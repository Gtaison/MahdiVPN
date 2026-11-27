package com.mlmvpn.scanner.engines.argo

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.nio.charset.StandardCharsets
import java.time.OffsetDateTime
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Persistent Argo endpoint pool.
 *
 * The bundled snapshot is only a bootstrap cache: its entries can expire. Refresh obtains
 * the signed public feed, Falcon origins, and current Telegram source posts before candidates
 * are offered to the connection engine.
 */
class ArgoPoolRepository(context: Context) {
    data class Item(
        val id: String,
        val kind: String,
        val host: String,
        val port: Int,
        val protocol: String,
        val source: String,
        val from: String,
        val seenAt: Long,
        val profile: String,
        val countryCode: String,
        val validUntil: Long,
        val ip: String
    )

    data class UpdateResult(
        val added: Int,
        val publicServers: Int,
        val bridges: Int,
        val falcons: Int,
        val errors: List<String>,
        val completedAt: Long
    )

    private val app = context.applicationContext
    private val directory = File(app.filesDir, "argo").apply { mkdirs() }
    private val persistence = File(directory, "pool.json")
    private val http = OkHttpClient.Builder()
        .connectTimeout(12, TimeUnit.SECONDS)
        .readTimeout(18, TimeUnit.SECONDS)
        .callTimeout(22, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    private val items = LinkedHashMap<String, Item>()
    private val falconOrigins = mutableListOf<ArgoProtocolCore.FalconOrigin>()
    @Volatile private var loaded = false

    private val telegramChannels = listOf(
        "argooo_vpn", "ARGO_VPNN", "falconchi", "argo_falcon", "falcon_argo",
        "argovpn_falcon", "argo_bridge", "ArgoVPNs", "vvpnfc", "falconsazi", "pol_argo"
    )

    private val publicFeedUrls = listOf(
        "https://s3.amazonaws.com/argovpn/browse/data6.br",
        "https://raw.githubusercontent.com/legend-wizard/browse/refs/heads/main/data6.br",
        "https://akeptumbesnow.com/repo6"
    )
    private val falconFeedUrls = listOf(
        "https://raw.githubusercontent.com/ArgoConfBot/ARG/master/lib.br"
    )

    @Synchronized
    fun load() {
        if (loaded) return
        val bundled = runCatching {
            app.assets.open("argo/argo-pool.json").bufferedReader(StandardCharsets.UTF_8).use { it.readText() }
        }.getOrNull()
        if (!bundled.isNullOrBlank()) {
            parseBundleSnapshot(bundled).forEach { items.putIfAbsent(it.id, it) }
            val root = JSONObject(bundled)
            root.optJSONArray("falconServers")?.let(::parseFalconOrigins)?.let {
                falconOrigins.clear()
                falconOrigins.addAll(it)
            }
        }
        if (persistence.isFile) {
            runCatching {
                val saved = JSONObject(persistence.readText(StandardCharsets.UTF_8))
                saved.optJSONArray("items")?.let { array ->
                    for (index in 0 until array.length()) {
                        val item = array.optJSONObject(index)?.let(::itemFromJson) ?: continue
                        items[item.id] = item
                    }
                }
                saved.optJSONArray("falconServers")?.let(::parseFalconOrigins)?.let {
                    if (it.isNotEmpty()) {
                        falconOrigins.clear()
                        falconOrigins.addAll(it)
                    }
                }
            }
        }
        loaded = true
    }

    @Synchronized
    fun allItems(): List<Item> {
        load()
        return items.values.toList()
    }

    @Synchronized
    fun falconOrigins(): List<ArgoProtocolCore.FalconOrigin> {
        load()
        return falconOrigins.toList()
    }

    /** Only non-expired records are returned; the old bundled snapshot is not trusted forever. */
    @Synchronized
    fun candidates(limit: Int = 3): List<ArgoProtocolCore.Endpoint> {
        require(limit > 0)
        load()
        val now = System.currentTimeMillis()
        return items.values
            .filter { it.validUntil <= 0L || it.validUntil > now }
            .sortedWith(
                compareByDescending<Item> { it.seenAt }
                    .thenBy { kindPriority(it.kind) }
            )
            .take(limit)
            .map { ArgoProtocolCore.Endpoint(it.id, it.kind, it.host, it.port, it.protocol) }
    }

    /** Import a user-supplied bridge block or Falcon hostname; unsigned bridges are rejected. */
    @Synchronized
    fun endpointFromRaw(raw: String): ArgoProtocolCore.Endpoint {
        load()
        val block = ArgoProtocolCore.extractBridgeBlocks(raw).firstOrNull()
        val item = if (block != null) {
            val bridge = ArgoProtocolCore.decodeBridgeBlock(block)
            require(bridge.signatureValid) { "امضای بلاک پل آرگو معتبر نیست" }
            addItem(
                kind = "bridge", host = bridge.host, port = bridge.port, protocol = bridge.protocol,
                source = "user", from = "manual", seenAt = System.currentTimeMillis()
            )
        } else {
            val host = ArgoProtocolCore.extractFalconHosts(raw, allowUrlLines = true).firstOrNull()
                ?: throw IllegalArgumentException("نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن")
            addItem(
                kind = "falcon", host = host, port = 443, protocol = "A",
                source = "user", from = "manual", seenAt = System.currentTimeMillis()
            )
        }
        saveLocked()
        return item.toEndpoint()
    }

    @Synchronized
    fun importText(text: String, source: String = "user"): Int {
        load()
        val now = System.currentTimeMillis()
        var added = 0
        val blocks = ArgoProtocolCore.extractBridgeBlocks(text)
        blocks.forEach { block ->
            runCatching { ArgoProtocolCore.decodeBridgeBlock(block) }
                .getOrNull()
                ?.takeIf { it.signatureValid }
                ?.let { bridge ->
                    if (addItem("bridge", bridge.host, bridge.port, bridge.protocol, source, source, now) != null) {
                        added++
                    }
                }
        }
        val withoutBlocks = blocks.fold(text) { remaining, block -> remaining.replace(block, " ") }
        ArgoProtocolCore.extractFalconHosts(withoutBlocks).forEach { host ->
            if (addItem("falcon", host, 443, "A", source, source, now) != null) added++
        }
        saveLocked()
        return added
    }

    /**
     * Refreshes the real upstream sources. A public-server feed is accepted only when its
     * ECDSA signature is valid and its issue time is plausible; Telegram posts are parsed for
     * signed bridge blocks and Falcon hostnames.
     */
    suspend fun refresh(onProgress: (String) -> Unit = {}): UpdateResult = withContext(Dispatchers.IO) {
        load()
        val before = synchronized(this@ArgoPoolRepository) { items.size }
        val errors = mutableListOf<String>()
        var publicAdded = 0
        var bridgeAdded = 0
        var falconAdded = 0

        var publicFeedAccepted = false
        for (url in publicFeedUrls) {
            try {
                onProgress("دریافت فهرست رسمی سرورهای عمومی")
                val text = fetchText(url)
                val feed = ArgoProtocolCore.decodeSnowcfg(text)
                val now = System.currentTimeMillis()
                require(feed.signatureValid) { "امضای فهرست عمومی معتبر نیست" }
                require(feed.issuedAtMs in (now - 30L * DAY_MS)..(now + DAY_MS)) {
                    "فهرست عمومی قدیمی یا دارای زمان نامعتبر است"
                }
                val servers = ArgoProtocolCore.publicServersOf(feed.parameters)
                require(servers.isNotEmpty()) { "فهرست عمومی سروری ندارد" }
                synchronized(this@ArgoPoolRepository) {
                    servers.forEach { server ->
                        if (addItem(
                                "public", server.host, server.port, "A",
                                "argo:config", server.profile, feed.issuedAtMs,
                                validUntil = feed.issuedAtMs + 30L * DAY_MS
                            ) != null
                        ) publicAdded++
                    }
                    saveLocked()
                }
                publicFeedAccepted = true
                break
            } catch (failure: Throwable) {
                errors += "فهرست عمومی: ${failure.message ?: failure.javaClass.simpleName}"
            }
        }
        if (!publicFeedAccepted) errors += "هیچ‌یک از منابع فهرست عمومی تأیید نشد"

        var falconFeedAccepted = false
        for (url in falconFeedUrls) {
            try {
                onProgress("دریافت فهرست IPهای فالکن")
                val text = fetchText(url)
                val decoded = ArgoProtocolCore.decodeFalconServers(text)
                require(decoded.isNotEmpty()) { "فهرست فالکن خالی است" }
                synchronized(this@ArgoPoolRepository) {
                    falconOrigins.clear()
                    falconOrigins.addAll(decoded)
                    saveLocked()
                }
                falconFeedAccepted = true
                break
            } catch (failure: Throwable) {
                errors += "فهرست فالکن: ${failure.message ?: failure.javaClass.simpleName}"
            }
        }
        if (!falconFeedAccepted) errors += "فهرست IPهای فالکن به‌روز نشد"

        telegramChannels.forEachIndexed { index, channel ->
            try {
                onProgress("بررسی کانال آرگو ${index + 1}/${telegramChannels.size}")
                val html = fetchText("https://t.me/s/$channel")
                val posts = parseTelegramPage(html)
                posts.forEach { post ->
                    val count = importText(post, "tg:$channel")
                    synchronized(this@ArgoPoolRepository) {
                        // Count only records created during this post; importText itself is
                        // idempotent, so duplicates from overlapping channels are harmless.
                    }
                    if (count > 0) {
                        // Separate counts are calculated from the resulting item types below.
                    }
                }
            } catch (failure: Throwable) {
                errors += "تلگرام @$channel: ${failure.message ?: failure.javaClass.simpleName}"
            }
        }

        val totalAfter = synchronized(this@ArgoPoolRepository) {
            saveLocked()
            items.size
        }
        val added = (totalAfter - before).coerceAtLeast(0)
        val all = allItems()
        UpdateResult(
            added = added,
            publicServers = publicAdded,
            bridges = all.count { it.kind == "bridge" },
            falcons = all.count { it.kind == "falcon" },
            errors = errors,
            completedAt = System.currentTimeMillis()
        )
    }

    private fun fetchText(url: String): String {
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 Chrome/120.0 Mobile Safari/537.36")
            .header("Accept", "*/*")
            .build()
        http.newCall(request).execute().use { response ->
            require(response.isSuccessful) { "HTTP ${response.code}" }
            val body = response.body?.string().orEmpty()
            require(body.isNotBlank()) { "پاسخ خالی بود" }
            require(body.toByteArray(StandardCharsets.UTF_8).size <= MAX_SOURCE_BYTES) { "پاسخ بیش از اندازه بزرگ است" }
            return body
        }
    }

    private fun parseTelegramPage(html: String): List<String> {
        val fragments = html.split("tgme_widget_message_wrap").drop(1)
        val posts = mutableListOf<String>()
        fragments.forEach { fragment ->
            val match = Regex("<div class=\"tgme_widget_message_text[^\"]*\"[^>]*>([\\s\\S]*?)</div>")
                .find(fragment) ?: return@forEach
            val body = decodeHtml(match.groupValues[1]).trim()
            if (body.isNotBlank()) posts += body
        }
        return posts
    }

    private fun decodeHtml(value: String): String {
        return value
            .replace(Regex("<br\\s*/?>", RegexOption.IGNORE_CASE), "\n")
            .replace(Regex("<[^>]+>"), "")
            .replace("&lt;", "<").replace("&gt;", ">")
            .replace("&quot;", "\"").replace("&#39;", "'")
            .replace("&nbsp;", " ").replace("&amp;", "&")
            .replace(Regex("&#(\\d+);")) { match ->
                match.groupValues[1].toIntOrNull()?.let { String(Character.toChars(it)) }.orEmpty()
            }
    }

    @Synchronized
    private fun addItem(
        kind: String,
        host: String,
        port: Int,
        protocol: String,
        source: String,
        from: String,
        seenAt: Long,
        profile: String = "",
        countryCode: String = "",
        validUntil: Long = 0L,
        ip: String = ""
    ): Item? {
        val normalized = host.trim().trimEnd('.').lowercase(Locale.ROOT)
        if (kind !in setOf("bridge", "falcon", "public") || !ArgoProtocolCore.looksLikeHost(normalized)) return null
        val safePort = port.takeIf { it in 1..65535 } ?: 443
        val id = "${kind.first()}:$normalized" + if (safePort == 443) "" else ":$safePort"
        val existing = items[id]
        if (existing != null) {
            if (seenAt > existing.seenAt) items[id] = existing.copy(seenAt = seenAt)
            return null
        }
        return Item(
            id, kind, normalized, safePort, if (protocol == "B") "B" else "A",
            source, from, seenAt.takeIf { it > 0L } ?: System.currentTimeMillis(),
            profile, countryCode, validUntil, ip
        ).also { items[id] = it }
    }

    @Synchronized
    private fun saveLocked() {
        val array = JSONArray()
        items.values.forEach { array.put(itemToJson(it)) }
        val origins = JSONArray()
        falconOrigins.forEach { origin ->
            origins.put(
                JSONObject()
                    .put("ip", origin.ip)
                    .put("countryCode", origin.countryCode)
                    .put("serverLoad", origin.load)
            )
        }
        val root = JSONObject()
            .put("version", 1)
            .put("updatedAt", System.currentTimeMillis())
            .put("items", array)
            .put("falconServers", origins)
        val temp = File(directory, "pool.json.tmp")
        temp.writeText(root.toString(), StandardCharsets.UTF_8)
        if (persistence.exists()) persistence.delete()
        check(temp.renameTo(persistence)) { "Could not persist Argo pool" }
    }

    private fun itemToJson(item: Item) = JSONObject()
        .put("id", item.id).put("kind", item.kind).put("host", item.host)
        .put("port", item.port).put("protocol", item.protocol)
        .put("source", item.source).put("from", item.from).put("seenAt", item.seenAt)
        .put("profile", item.profile).put("countryCode", item.countryCode)
        .put("validUntil", item.validUntil).put("ip", item.ip)

    private fun itemFromJson(json: JSONObject) = Item(
        id = json.optString("id"),
        kind = json.optString("kind"),
        host = json.optString("host"),
        port = json.optInt("port", 443),
        protocol = json.optString("protocol", "A"),
        source = json.optString("source"),
        from = json.optString("from"),
        seenAt = json.optLong("seenAt"),
        profile = json.optString("profile"),
        countryCode = json.optString("countryCode"),
        validUntil = json.optLong("validUntil"),
        ip = json.optString("ip")
    )

    private fun parseFalconOrigins(array: JSONArray): List<ArgoProtocolCore.FalconOrigin> =
        buildList {
            for (index in 0 until array.length()) {
                val json = array.optJSONObject(index) ?: continue
                val ip = json.optString("ip")
                if (ip.isNotBlank()) {
                    add(
                        ArgoProtocolCore.FalconOrigin(
                            ip,
                            json.optString("cc", json.optString("countryCode")),
                            json.optDouble("load", json.optDouble("serverLoad", 0.0))
                        )
                    )
                }
            }
        }

    private fun Item.toEndpoint() =
        ArgoProtocolCore.Endpoint(id, kind, host, port, protocol)

    private fun kindPriority(kind: String): Int =
        when (kind) {
            "bridge" -> 0
            "public" -> 1
            "falcon" -> 2
            else -> 3
        }

    companion object {
        private const val DAY_MS = 86_400_000L
        private const val MAX_SOURCE_BYTES = 2 * 1024 * 1024

        /** Pure parser used by unit tests and by [load]. */
        fun parseBundleSnapshot(jsonText: String): List<Item> {
            val root = JSONObject(jsonText)
            val array = root.optJSONArray("items") ?: JSONArray()
            val parsed = mutableListOf<Item>()
            for (index in 0 until array.length()) {
                val row = array.optJSONArray(index) ?: continue
                if (row.length() < 2) continue
                val shortKind = row.optString(0)
                val kind = when (shortKind) {
                    "b" -> "bridge"
                    "f" -> "falcon"
                    "p" -> "public"
                    else -> continue
                }
                val host = row.optString(1).trim().lowercase(Locale.ROOT)
                if (!ArgoProtocolCore.looksLikeHost(host)) continue
                val port = row.optInt(2, 443).takeIf { it in 1..65535 } ?: 443
                val protocol = if (row.optString(3) == "B") "B" else "A"
                val from = row.optString(4)
                val seen = row.optLong(5) * 1000L
                val profile = row.optString(6)
                val country = row.optString(7)
                val validUntil = row.optLong(8) * 1000L
                val ip = row.optString(9)
                val id = "${shortKind}:$host" + if (port == 443) "" else ":$port"
                parsed += Item(
                    id, kind, host, port, protocol, "bundled", from,
                    seen, profile, country, validUntil, ip
                )
            }
            return parsed
        }
    }
}
