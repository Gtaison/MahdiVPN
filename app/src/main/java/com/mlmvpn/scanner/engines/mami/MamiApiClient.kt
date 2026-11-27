package com.mlmvpn.scanner.engines.mami

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.TelephonyManager
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import kotlinx.coroutines.sync.Mutex
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit

class MamiApiException(
    val errorCode: String,
    message: String,
    val httpStatus: Int = 0,
    val retryAfterSec: Int = 0
) : Exception(message)

data class MamiApiAnswer(
    val code: Int,
    val body: ByteArray,
    val headers: Map<String, String>,
    val host: String
) {
    fun bodyText(): String = String(body, StandardCharsets.UTF_8)
    fun json(): JSONObject? = if (body.isEmpty()) null else runCatching { JSONObject(bodyText()) }.getOrNull()
}

data class MamiCatalogResponse(
    val payload: JSONObject,
    val payloadVersion: Int,
    val revision: Long,
    val issuedAt: Long,
    val expiresAt: Long,
    val fetchedAt: Long,
    val host: String
)

data class MamiExclusiveBridge(val block: String, val revision: Long, val fetchedAt: Long)

data class MamiHiveResponse(val payload: JSONObject, val fetchedAt: Long, val host: String)

class MamiApiClient(
    private val context: Context,
    private val store: MamiStore = MamiStore(context),
    private val identity: MamiIdentityCore = MamiIdentityCore(context, store),
    private val envelope: MamiEnvelopeCore = MamiEnvelopeCore(),
    private val deadDrop: MamiDeadDropCore = MamiDeadDropCore()
) {
    private val lock = Any()
    private val sessionMutex = Mutex()
    private var boot: JSONObject? = null
    private var trustedKeys: Map<String, java.security.PublicKey> = emptyMap()
    private var stateCache: JSONObject? = null
    private var stickyIndex = 0
    private var stickyAt = 0L
    private var ready = false

    private val http = OkHttpClient.Builder()
        .connectTimeout(12, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .callTimeout(32, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

    @Synchronized
    fun init() {
        if (ready) return
        val bootText = context.applicationContext.assets
            .open("mami/catalog-bootstrap.json")
            .bufferedReader(StandardCharsets.UTF_8)
            .use { it.readText() }
        val parsedBoot = JSONObject(bootText)
        val keys = envelope.loadTrustedKeys(parsedBoot)
        identity.loadOrCreate()
        boot = parsedBoot
        trustedKeys = keys
        stateCache = store.readJson("state.json") ?: JSONObject()
        ready = true
    }

    fun clientInfo(): JSONObject {
        val model = Build.MODEL.orEmpty().take(80).ifBlank { "Android device" }
        val release = Build.VERSION.RELEASE.orEmpty().take(24).ifBlank { Build.VERSION.SDK_INT.toString() }
        return JSONObject()
            .put("deviceModel", model)
            .put("androidVersion", release)
            .put("appVersionName", VERSION_NAME)
            .put("appVersionCode", VERSION_CODE)
            .put("locale", Locale.getDefault().toLanguageTag().take(32))
            .put("timezone", TimeZone.getDefault().id.take(80))
    }

    suspend fun ensureHost(force: Boolean = false): String {
        init()
        val current = state()
        val host = current.optString("host")
        val now = System.currentTimeMillis()
        val age = now - current.optLong("hostAt", 0L)
        val triedAge = now - current.optLong("hostTriedAt", 0L)
        val recentFailure = current.optString("hostError").isNotBlank() && triedAge < HOST_RETRY_MS
        if (!force && host.isNotBlank() && (age < HOST_FRESH_MS || recentFailure)) return host

        val outcome = deadDrop.resolve()
        synchronized(lock) {
            val latest = state()
            latest.put("hostTriedAt", now)
            if (outcome.host != null) {
                if (latest.optString("host") != outcome.host) stickyIndex = 0
                latest.put("host", outcome.host)
                latest.put("hostSource", outcome.source.orEmpty())
                latest.put("hostAt", now)
                latest.put("hostError", "")
            } else {
                val errors = outcome.results.joinToString(" · ") { it.source.id + ": " + (it.error ?: "no host") }
                latest.put("hostError", errors.ifBlank { "dead-drop sources did not answer" })
                if (latest.optString("host").isBlank()) {
                    saveState()
                    throw MamiApiException("no-host", "نشانی سرور فرمان مامی پیدا نشد؛ منابع گوگل‌داکس و گیت‌هاب پاسخ ندادند")
                }
            }
            saveState()
            return latest.optString("host")
        }
    }

    suspend fun call(
        path: String,
        method: String = "POST",
        jsonBody: JSONObject? = null,
        rawBody: ByteArray? = null,
        accessToken: String? = null,
        timeoutMs: Long = CALL_MS,
        accept: String = "application/json",
        contentType: String = "application/json; charset=utf-8"
    ): MamiApiAnswer = withContext(Dispatchers.IO) {
        ensureHost()
        val bodyBytes = jsonBody?.toString()?.toByteArray(StandardCharsets.UTF_8) ?: rawBody
        val normalizedPath = if (path.startsWith("/")) path else "/api/v1/$path"
        val headers = linkedMapOf(
            "Accept" to accept,
            "Accept-Encoding" to "identity",
            "Cache-Control" to "no-store",
            "X-YamYam-Version-Code" to VERSION_CODE.toString(),
            "User-Agent" to userAgent(),
            "X-YY-Client" to CLIENT_KEY
        )
        if (!accessToken.isNullOrBlank()) {
            headers["Authorization"] = "Bearer $accessToken"
            if (method.equals("GET", true)) {
                headers["X-YamYam-Timezone"] = clientInfo().optString("timezone", "UTC")
                headers["X-YamYam-Version-Name"] = VERSION_NAME
            }
        }

        val hostList = hostOrder()
        val errors = mutableListOf<String>()
        for ((index, host) in hostList.withIndex()) {
            try {
                val requestBody = bodyBytes?.toRequestBody(contentType.toMediaType())
                val builder = Request.Builder().url("https://$host$normalizedPath")
                headers.forEach { (name, value) -> builder.header(name, value) }
                when (method.uppercase(Locale.ROOT)) {
                    "GET" -> builder.get()
                    "HEAD" -> builder.head()
                    "DELETE" -> if (requestBody == null) builder.delete() else builder.delete(requestBody)
                    "PUT" -> builder.put(requestBody ?: ByteArray(0).toRequestBody(contentType.toMediaType()))
                    "PATCH" -> builder.patch(requestBody ?: ByteArray(0).toRequestBody(contentType.toMediaType()))
                    else -> builder.post(requestBody ?: ByteArray(0).toRequestBody(contentType.toMediaType()))
                }
                val call = http.newCall(builder.build())
                call.timeout().timeout(timeoutMs.coerceIn(1_000L, CALL_MS), TimeUnit.MILLISECONDS)
                call.execute().use { response ->
                    val bytes = response.body?.bytes() ?: ByteArray(0)
                    if (bytes.size > MAX_ANSWER) {
                        throw MamiApiException("too-large", "پاسخ سرور مامی بیش از اندازه بزرگ بود", response.code)
                    }
                    val responseHeaders = response.headers.names().associateWith { response.header(it).orEmpty() }
                    noteClock(response.header("Date"))
                    synchronized(lock) {
                        if (stickyIndex != index) {
                            stickyIndex = index
                            stickyAt = System.currentTimeMillis()
                        }
                    }
                    return@withContext MamiApiAnswer(response.code, bytes, responseHeaders, host)
                }
            } catch (failure: MamiApiException) {
                throw failure
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (failure: Throwable) {
                errors += "$host: ${failure.message ?: failure.javaClass.simpleName}"
            }
        }
        throw MamiApiException(
            "unreachable",
            "سرور فرمان مامی در دسترس نبود: ${errors.joinToString(" · ")}"
        )
    }

    suspend fun ensureSession(forceRegister: Boolean = false): JSONObject {
        init()
        sessionMutex.lock()
        try {
            val now = nowSec()
            val current = if (forceRegister) null else state().optJSONObject("session")
            if (current != null && current.optLong("accessExpiresAt") > now + 60L) return current
            if (current != null && current.optLong("refreshExpiresAt") > now) {
                val refreshed = refresh(current)
                if (refreshed != null) return refreshed
            }
            synchronized(lock) {
                state().remove("session")
                saveState()
            }
            return register()
        } finally {
            sessionMutex.unlock()
        }
    }

    private suspend fun refresh(session: JSONObject): JSONObject? {
        val answer = call(
            path = "device/refresh",
            jsonBody = JSONObject().put("refreshToken", session.optString("refreshToken"))
        )
        if (answer.code == 401) return null
        if (answer.code !in 200..299) throw httpError("تمدید نشست", answer)
        val tokens = parseTokens(answer) ?: return null
        synchronized(lock) {
            state().put("session", tokens)
            saveState()
        }
        return tokens
    }

    private suspend fun register(): JSONObject {
        val identityData = identity.loadOrCreate()
        val answer = call(
            path = "device/register",
            jsonBody = JSONObject()
                .put("deviceId", identityData.deviceId)
                .put("client", clientInfo())
        )
        if (answer.code !in 200..299) throw httpError("ثبت دستگاه", answer)
        val tokens = parseTokens(answer)
            ?: throw MamiApiException("bad-tokens", "ثبت دستگاه: پاسخ سرور قالب درستی نداشت", answer.code)
        synchronized(lock) {
            state().put("session", tokens)
            state().put("registeredAt", System.currentTimeMillis())
            saveState()
        }
        return tokens
    }

    private fun parseTokens(answer: MamiApiAnswer): JSONObject? {
        if (answer.body.isEmpty() || answer.body.size > 16_384) return null
        val json = answer.json() ?: return null
        if (json.optString("tokenType") != "Bearer") return null
        val access = json.optString("accessToken")
        val refresh = json.optString("refreshToken")
        if (!access.matches(TOKEN_REGEX) || !refresh.matches(REFRESH_REGEX)) return null
        val accessExpiry = number(json.opt("accessExpiresAt"))
        val refreshExpiry = number(json.opt("refreshExpiresAt"))
        val user = json.optJSONObject("user") ?: return null
        if (accessExpiry <= 0L || refreshExpiry <= 0L) return null
        return JSONObject()
            .put("accessToken", access)
            .put("refreshToken", refresh)
            .put("accessExpiresAt", accessExpiry)
            .put("refreshExpiresAt", refreshExpiry)
            .put("user", user)
            .put("at", System.currentTimeMillis())
    }

    suspend fun fetchCatalog(minimumRevision: Long? = null): MamiCatalogResponse {
        init()
        var session = ensureSession()
        val savedMeta = state().optJSONObject("catalog")
        val minRevision = minimumRevision ?: savedMeta?.optLong("revision", 0L)?.takeIf { it > 0L } ?: 0L
        val audience = boot?.optString("audience").orEmpty()
        if (audience.isBlank()) throw MamiApiException("bootstrap", "شناسهٔ مخاطب کاتالوگ مامی در فایل bootstrap وجود ندارد")

        var lastBadRequest: MamiApiException? = null
        for (payloadVersion in PAYLOAD_VERSIONS) {
            var retried401 = false
            while (true) {
                val recipient = identity.freshRecipient()
                val request = envelope.newRequest(
                    payloadVersion = payloadVersion,
                    minimumRevision = minRevision,
                    audience = audience,
                    recipient = recipient,
                    clockOffsetSec = clockOffset()
                )
                val answer = call(
                    path = catalogPath(),
                    method = "POST",
                    rawBody = request.body.toByteArray(StandardCharsets.UTF_8),
                    accessToken = session.optString("accessToken"),
                    contentType = "application/json; charset=utf-8"
                )
                when {
                    answer.code == 400 && payloadVersion != PAYLOAD_VERSIONS.last() -> {
                        lastBadRequest = httpError("کاتالوگ", answer)
                        break
                    }
                    answer.code == 401 && !retried401 -> {
                        session = ensureSession(forceRegister = true)
                        retried401 = true
                    }
                    answer.code == 403 -> throw MamiApiException("blocked", "سرور مامی فعلاً به این دستگاه فهرست نمی‌دهد (کد ۴۰۳)", 403)
                    answer.code != 200 -> throw httpError("کاتالوگ", answer)
                    else -> {
                        val opened = try {
                            envelope.open(
                                responseBody = answer.bodyText(),
                                context = request.context,
                                trustedKeys = trustedKeys,
                                clockOffsetSec = clockOffset()
                            )
                        } catch (cancelled: CancellationException) {
                            throw cancelled
                        } catch (failure: Throwable) {
                            throw MamiApiException("envelope", "کاتالوگ باز نشد؛ امضا یا رمز پاسخ معتبر نبود: ${failure.message}")
                        }
                        val payload = try {
                            JSONObject(String(opened.plaintext, StandardCharsets.UTF_8))
                        } catch (failure: Throwable) {
                            throw MamiApiException("payload", "محتوای کاتالوگ JSON نبود")
                        }
                        val fetchedAt = System.currentTimeMillis()
                        val response = MamiCatalogResponse(
                            payload = payload,
                            payloadVersion = payloadVersion,
                            revision = opened.revision,
                            issuedAt = opened.issuedAt,
                            expiresAt = opened.expiresAt,
                            fetchedAt = fetchedAt,
                            host = answer.host
                        )
                        synchronized(lock) {
                            store.writeJson(
                                "catalog.json",
                                JSONObject()
                                    .put("payloadVersion", payloadVersion)
                                    .put("revision", opened.revision)
                                    .put("issuedAt", opened.issuedAt)
                                    .put("expiresAt", opened.expiresAt)
                                    .put("fetchedAt", fetchedAt)
                                    .put("host", answer.host)
                                    .put("payload", payload)
                            )
                            state().put(
                                "catalog",
                                JSONObject()
                                    .put("payloadVersion", payloadVersion)
                                    .put("revision", opened.revision)
                                    .put("expiresAt", opened.expiresAt)
                                    .put("fetchedAt", fetchedAt)
                            )
                            saveState()
                        }
                        return response
                    }
                }
            }
        }
        throw lastBadRequest ?: MamiApiException("catalog", "کاتالوگ مامی دریافت نشد")
    }

    fun savedCatalog(): MamiCatalogResponse? {
        init()
        val saved = store.readJson("catalog.json") ?: return null
        val payload = saved.optJSONObject("payload") ?: return null
        val revision = saved.optLong("revision")
        if (revision <= 0L) return null
        return MamiCatalogResponse(
            payload = payload,
            payloadVersion = saved.optInt("payloadVersion"),
            revision = revision,
            issuedAt = saved.optLong("issuedAt"),
            expiresAt = saved.optLong("expiresAt"),
            fetchedAt = saved.optLong("fetchedAt"),
            host = saved.optString("host")
        )
    }

    suspend fun fetchHive(purpose: String = "connect"): MamiHiveResponse {
        val session = ensureSession()
        val network = networkInfo()
        val body = JSONObject()
            .put("v", 2)
            .put("purpose", purpose)
            .put("transport", network.first)
        if (network.first == "cellular" && network.second.matches(Regex("\\d{5,6}"))) {
            body.put("carrier", network.second)
        }
        var answer = call("device/hive", jsonBody = body, accessToken = session.optString("accessToken"))
        if (answer.code == 401) {
            val refreshed = ensureSession(forceRegister = true)
            answer = call("device/hive", jsonBody = body, accessToken = refreshed.optString("accessToken"))
        }
        if (answer.code == 403 || answer.code == 404) {
            throw MamiApiException("hive-off", "سرور مامی برای این دستگاه فهرست لیون ارائه نکرد", answer.code)
        }
        if (answer.code != 200 || answer.body.size > 262_144) throw httpError("فهرست لیون", answer)
        val payload = answer.json() ?: throw MamiApiException("hive-shape", "فهرست لیون قالب درستی نداشت")
        val fetchedAt = System.currentTimeMillis()
        store.writeJson(
            "hive.json",
            JSONObject().put("fetchedAt", fetchedAt).put("host", answer.host).put("payload", payload)
        )
        return MamiHiveResponse(payload, fetchedAt, answer.host)
    }

    suspend fun fetchExclusiveBridge(): MamiExclusiveBridge {
        var session = ensureSession()
        var answer = call("device/exclusive-bridge", jsonBody = JSONObject(), accessToken = session.optString("accessToken"))
        if (answer.code == 401) {
            session = ensureSession(forceRegister = true)
            answer = call("device/exclusive-bridge", jsonBody = JSONObject(), accessToken = session.optString("accessToken"))
        }
        if (answer.code == 404) {
            answer = call("device/argo-bridge", jsonBody = JSONObject(), accessToken = session.optString("accessToken"))
        }
        if (answer.code == 403 || answer.code == 404) {
            throw MamiApiException("exclusive-off", "سرور مامی برای این دستگاه پل اختصاصی ارائه نکرد", answer.code)
        }
        if (answer.code != 200) throw httpError("پل اختصاصی", answer)
        val json = answer.json() ?: throw MamiApiException("exclusive-shape", "پاسخ پل اختصاصی JSON نبود")
        val block = json.optString("exclusiveBridge").ifBlank { json.optString("argoBridge") }
        val revision = json.optLong("revision")
        if (block.isBlank() || revision <= 0L) {
            throw MamiApiException("exclusive-shape", "پاسخ پل اختصاصی قالب درستی نداشت")
        }
        val fetchedAt = System.currentTimeMillis()
        store.writeJson(
            "exclusive.json",
            JSONObject().put("block", block).put("source", "panel").put("revision", revision).put("at", fetchedAt)
        )
        return MamiExclusiveBridge(block, revision, fetchedAt)
    }

    private fun catalogPath(): String {
        val endpoint = boot?.optString("endpoint", "/api/v1/catalog") ?: "/api/v1/catalog"
        return endpoint.replace(Regex("^/?api/v1/"), "")
    }

    private fun hostOrder(): List<String> {
        val host = state().optString("host")
        if (host.isBlank()) return emptyList()
        val all = listOf(host, "edge.$host", "assets.$host").distinct()
        val now = System.currentTimeMillis()
        if (stickyIndex !in all.indices || now - stickyAt >= STICKY_MS) {
            stickyIndex = 0
            stickyAt = 0L
        }
        val first = all.getOrNull(stickyIndex) ?: all.first()
        return listOf(first) + all.filterNot { it == first }
    }

    private fun noteClock(dateHeader: String?) {
        if (dateHeader.isNullOrBlank()) return
        val offset = runCatching {
            ZonedDateTime.parse(dateHeader, DateTimeFormatter.RFC_1123_DATE_TIME).toEpochSecond() -
                System.currentTimeMillis() / 1000L
        }.getOrNull() ?: return
        if (offset !in -86_400L..86_400L) return
        synchronized(lock) {
            state().put("clockOffsetSec", offset)
            saveState()
        }
    }

    private fun clockOffset(): Long = state().optLong("clockOffsetSec", 0L)
    private fun nowSec(): Long = System.currentTimeMillis() / 1000L + clockOffset()

    private fun number(value: Any?): Long = when (value) {
        is Number -> value.toLong()
        is String -> value.toDoubleOrNull()?.toLong() ?: 0L
        else -> 0L
    }

    private fun httpError(operation: String, answer: MamiApiAnswer): MamiApiException {
        val json = answer.json()
        val detail = json?.optString("error")?.takeIf { it.isNotBlank() }
            ?: json?.optString("message")?.takeIf { it.isNotBlank() }
        val summary = when (answer.code) {
            401, 403 -> "سرور دستگاه را نپذیرفت"
            429 -> "درخواست‌ها زیاد است؛ کمی بعد دوباره تلاش کنید"
            in 500..599 -> "سرور مامی خطای داخلی داد"
            else -> "پاسخ نامعتبر"
        }
        val retry = answer.headers.entries.firstOrNull { it.key.equals("retry-after", true) }
            ?.value?.toIntOrNull() ?: 0
        return MamiApiException(
            "http-${answer.code}",
            "$operation: $summary (کد ${answer.code})" + (detail?.let { " — ${it.take(160)}" } ?: ""),
            answer.code,
            retry
        )
    }

    private fun networkInfo(): Pair<String, String> {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val capabilities = manager?.activeNetwork?.let(manager::getNetworkCapabilities)
        if (capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true) {
            val operator = runCatching {
                (context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager)
                    ?.networkOperator.orEmpty()
            }.getOrDefault("")
            return "cellular" to operator
        }
        return "wifi" to ""
    }

    private fun userAgent(): String =
        "Dalvik/2.1.0 (Linux; U; Android ${Build.VERSION.RELEASE}; ${Build.MODEL} Build/${Build.ID})"

    private fun state(): JSONObject {
        synchronized(lock) {
            if (stateCache == null) stateCache = store.readJson("state.json") ?: JSONObject()
            return stateCache!!
        }
    }

    private fun saveState() {
        val current = stateCache ?: JSONObject()
        store.writeJson("state.json", current)
    }

    companion object {
        const val CLIENT_KEY = "0fb27d68b9dfe7fcf111e3b05ab73a917d3a6f32eb050e27"
        const val VERSION_CODE = 56
        const val VERSION_NAME = "1.0.12"
        private const val CALL_MS = 30_000L
        private const val HOST_FRESH_MS = 1_800_000L
        private const val HOST_RETRY_MS = 300_000L
        private const val STICKY_MS = 600_000L
        private const val MAX_ANSWER = 524_288
        private val PAYLOAD_VERSIONS = intArrayOf(8, 7, 6, 5, 4, 3)
        private val TOKEN_REGEX = Regex("^[A-Za-z0-9_.-]{32,8192}$")
        private val REFRESH_REGEX = Regex("^[A-Za-z0-9_-]{32,128}$")
    }
}
