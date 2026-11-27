package com.mlmvpn.scanner.engines.mami

import org.json.JSONArray
import org.json.JSONObject
import java.util.Locale

/** Strict, bounded parser for the versioned Mami server catalog. */
class MamiCatalogCore {
    data class Place(val country: String, val city: String)

    data class Location(
        val id: String,
        val countryCode: String,
        val country: String,
        val city: String,
        val sort: Int,
        val names: Map<String, Place>
    )

    data class Server(
        val id: String,
        val countryCode: String,
        val country: String,
        val city: String,
        val locationId: String,
        val protocol: String,
        val profile: String,
        val host: String,
        val port: Int,
        val tlsServerName: String,
        val raw: JSONObject,
        val locationSort: Int = 1000,
        val names: Map<String, Place> = emptyMap()
    ) {
        val json: String? get() = raw.optString("json").takeIf { it.isNotBlank() }
    }

    data class Skipped(val id: String, val reason: String)

    data class Parsed(
        val version: Int,
        val locations: List<Location>,
        val servers: List<Server>,
        val skipped: List<Skipped>
    )

    fun parseCatalog(payload: JSONObject): Parsed {
        val version = payload.optInt("version", -1)
        require(version in 1..8) { "Unsupported Mami catalog version" }
        val serverRows = payload.optJSONArray("servers")
            ?: throw IllegalArgumentException("Mami catalog has no servers array")
        val locationRows = payload.optJSONArray("locations") ?: JSONArray()
        require(version < 3 || locationRows.length() > 0) {
            "Mami catalog version $version requires locations"
        }

        val locations = mutableListOf<Location>()
        val locationById = linkedMapOf<String, Location>()
        for (index in 0 until minOf(locationRows.length(), MAX_LOCATIONS)) {
            val row = locationRows.optJSONObject(index) ?: continue
            val location = runCatching { parseLocation(row, version) }.getOrNull() ?: continue
            if (locationById.putIfAbsent(location.id, location) == null) locations += location
        }

        val servers = mutableListOf<Server>()
        val skipped = mutableListOf<Skipped>()
        val ids = HashSet<String>()
        for (index in 0 until minOf(serverRows.length(), MAX_SERVERS)) {
            val row = serverRows.optJSONObject(index)
            val id = row?.optString("id")?.take(64)?.ifBlank { "?" } ?: "?"
            try {
                requireNotNull(row) { "server" }
                val server = parseServer(row, version)
                require(ids.add(server.id)) { "duplicate-id" }
                val location = locationById[server.locationId]
                servers += server.copy(
                    locationSort = location?.sort ?: 1000,
                    names = location?.names.orEmpty()
                )
            } catch (failure: Throwable) {
                skipped += Skipped(id, failure.message?.take(80) ?: "invalid-server")
            }
        }
        return Parsed(version, locations, servers, skipped)
    }

    fun placeOf(server: Server, language: String): Place {
        val lang = language.lowercase(Locale.ROOT).substringBefore('-')
        return server.names[lang] ?: server.names["en"] ?: Place(server.country, server.city)
    }

    private fun parseLocation(row: JSONObject, version: Int): Location {
        val id = row.optString("id")
        val countryCode = row.optString("countryCode").uppercase(Locale.ROOT)
        require(isId(id)) { "location-id" }
        require(countryCode.matches(COUNTRY_CODE_REGEX)) { "location-country-code" }
        val country = safeText(row.optString("country"), 96, "location-country")
        val city = safeText(row.optString("city"), 96, "location-city")
        val sort = if (version >= 4) safeInt(row.opt("sort"), 0, 1000, "location-sort") else 1000
        val names = if (version >= 4) {
            val nameObject = row.optJSONObject("names") ?: throw IllegalArgumentException("location-names")
            mapOf(
                "en" to parsePlace(nameObject.optJSONObject("en"), "location-names-en"),
                "fa" to parsePlace(nameObject.optJSONObject("fa"), "location-names-fa"),
                "ar" to parsePlace(nameObject.optJSONObject("ar"), "location-names-ar")
            )
        } else emptyMap()
        return Location(id, countryCode, country, city, sort, names)
    }

    private fun parsePlace(row: JSONObject?, field: String): Place {
        requireNotNull(row) { field }
        return Place(
            safeText(row.optString("country"), 96, "$field-country"),
            safeText(row.optString("city"), 96, "$field-city")
        )
    }

    private fun parseServer(row: JSONObject, version: Int): Server {
        val id = row.optString("id")
        require(isId(id)) { "id" }
        val protocol = row.optString("protocol")
        require(protocol in PROTOCOLS) { "protocol" }
        val countryCode = row.optString("countryCode").uppercase(Locale.ROOT)
        require(countryCode.matches(COUNTRY_CODE_REGEX)) { "country-code" }
        val port = safeInt(row.opt("port"), 1, 65_535, "port")
        val tlsServerName = row.optString("tlsServerName")
        require(isDomain(tlsServerName)) { "tls-server-name" }
        val host = row.optString("host")
        require(if (protocol == "trojan") isDomain(host) else isDomain(host) || isPublicIpv4(host)) {
            "host"
        }
        val country = safeText(row.optString("country"), 96, "country")
        val city = safeText(row.optString("city"), 96, "city")
        val locationId = row.optString("locationId").ifBlank { id }
        require(isId(locationId)) { "location-id" }
        val profile = profileOf(row, protocol, version)

        when (protocol) {
            "trojan" -> {
                val password = row.optString("password")
                require(password.isNotBlank() && password.length <= 1024) { "password" }
            }
            "vless-xhttp" -> requireNotNull(row.optJSONObject("xhttp")) { "xhttp" }
            "vless-raw-reality" -> requireNotNull(row.optJSONObject("raw")) { "raw" }
            "hysteria2" -> requireNotNull(row.optJSONObject("hysteria2")) { "hysteria2" }
            "vless-grpc-reality" -> requireNotNull(row.optJSONObject("grpc")) { "grpc" }
            "vless" -> requireNotNull(row.optJSONObject("vless")) { "vless" }
        }

        // Validate the common credential fields before the config builder consumes the raw profile.
        when (protocol) {
            "vless-raw-reality" -> {
                val raw = row.getJSONObject("raw")
                require(isUuid(raw.optString("uuid"))) { "raw.uuid" }
                require(isBase64UrlBytes(raw.optString("publicKey"), 32)) { "raw.publicKey" }
                require(isShortId(raw.optString("shortId"))) { "raw.shortId" }
            }
            "vless-grpc-reality" -> {
                val grpc = row.getJSONObject("grpc")
                require(isUuid(grpc.optString("uuid"))) { "grpc.uuid" }
                require(isBase64UrlBytes(grpc.optString("publicKey"), 32)) { "grpc.publicKey" }
                require(isShortId(grpc.optString("shortId"))) { "grpc.shortId" }
            }
            "vless-xhttp" -> {
                val xhttp = row.getJSONObject("xhttp")
                require(isUuid(xhttp.optString("uuid"))) { "xhttp.uuid" }
                require(xhttp.optString("security") in setOf("tls", "reality")) { "xhttp.security" }
                require(isWsPath(xhttp.optString("path"))) { "xhttp.path" }
            }
            "vless" -> {
                val vless = row.getJSONObject("vless")
                require(isUuid(vless.optString("uuid"))) { "vless.uuid" }
                require(vless.optString("network") in NETWORKS) { "vless.network" }
                require(vless.optString("security") in setOf("tls", "reality")) { "vless.security" }
            }
            "hysteria2" -> {
                val hy2 = row.getJSONObject("hysteria2")
                require(hy2.optString("auth").isNotBlank()) { "hysteria2.auth" }
            }
        }

        return Server(
            id = id,
            countryCode = countryCode,
            country = country,
            city = city,
            locationId = locationId,
            protocol = protocol,
            profile = profile,
            host = host,
            port = port,
            tlsServerName = tlsServerName,
            raw = JSONObject(row.toString())
        )
    }

    private fun profileOf(row: JSONObject, protocol: String, version: Int): String {
        val explicit = row.optString("profile")
        if (explicit.isNotBlank()) {
            require(explicit.matches(PROFILE_REGEX)) { "profile" }
            require(explicit !in KNOWN_PROFILES || version >= 8) { "profile-custom" }
            return explicit
        }
        return when (protocol) {
            "vless-grpc-reality" -> "VGR"
            "hysteria2" -> "HY2"
            "vless-xhttp" -> if (row.optJSONObject("xhttp")?.optString("security") == "reality") "VXR" else "VXT"
            "vless-raw-reality" -> "VRR"
            "vless" -> throw IllegalArgumentException("profile-missing")
            else -> "VXT"
        }
    }

    private fun safeText(value: String, max: Int, field: String): String {
        require(value.length <= max) { field }
        require(value.none { it.isISOControl() || it == '<' || it == '>' || it in '\u202a'..'\u202e' }) { field }
        return value.trim()
    }

    private fun safeInt(value: Any?, min: Int, max: Int, field: String): Int {
        val number = when (value) {
            is Number -> value.toDouble()
            is String -> value.toDoubleOrNull()
            else -> null
        } ?: throw IllegalArgumentException(field)
        require(number.isFinite() && number % 1.0 == 0.0 && number in min.toDouble()..max.toDouble()) { field }
        return number.toInt()
    }

    private fun isId(value: String): Boolean =
        value.length in 1..64 && value.matches(ID_REGEX)

    private fun isDomain(value: String): Boolean {
        if (value.length !in 4..253 || value.startsWith('.') || value.endsWith('.')) return false
        val labels = value.lowercase(Locale.ROOT).split('.')
        if (labels.size < 2 || labels.last().length !in 2..24 || !labels.last().all { it in 'a'..'z' }) return false
        return labels.all { label ->
            label.isNotEmpty() && label.length <= 63 && label.first() != '-' && label.last() != '-' &&
                label.all { it in 'a'..'z' || it in '0'..'9' || it == '-' }
        }
    }

    private fun isPublicIpv4(value: String): Boolean {
        val parts = value.split('.')
        if (parts.size != 4) return false
        val octets = parts.map { it.toIntOrNull() ?: return false }
        if (octets.any { it !in 0..255 }) return false
        val (a, b) = octets
        return !(a == 0 || a == 10 || a == 127 || a >= 224 ||
            (a == 100 && b in 64..127) || (a == 169 && b == 254) ||
            (a == 172 && b in 16..31) || (a == 192 && b == 168))
    }

    private fun isUuid(value: String): Boolean =
        value.matches(UUID_REGEX)

    private fun isBase64UrlBytes(value: String, expected: Int): Boolean = runCatching {
        require(value.matches(BASE64URL_REGEX))
        val bytes = java.util.Base64.getUrlDecoder().decode(value)
        bytes.size == expected && java.util.Base64.getUrlEncoder().withoutPadding().encodeToString(bytes) == value
    }.getOrDefault(false)

    private fun isShortId(value: String): Boolean =
        value.isEmpty() || (value.length <= 16 && value.length % 2 == 0 && value.all { it in '0'..'9' || it.lowercaseChar() in 'a'..'f' })

    private fun isWsPath(value: String): Boolean =
        value.length in 1..2048 && value.startsWith('/') &&
            value.none { it.isWhitespace() || it.isISOControl() || it == '<' || it == '>' }

    companion object {
        private const val MAX_SERVERS = 200
        private const val MAX_LOCATIONS = 200
        private val PROTOCOLS = setOf(
            "trojan", "vless-xhttp", "vless-raw-reality",
            "hysteria2", "vless-grpc-reality", "vless"
        )
        private val NETWORKS = setOf("raw", "ws", "httpupgrade", "xhttp", "grpc")
        private val KNOWN_PROFILES = setOf("VXT", "VXR", "VRR", "HY2", "VGR")
        private val ID_REGEX = Regex("[A-Za-z0-9_-]{1,64}")
        private val COUNTRY_CODE_REGEX = Regex("[A-Z]{2}")
        private val PROFILE_REGEX = Regex("[A-Z0-9_-]{1,16}")
        private val UUID_REGEX = Regex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-8][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}")
        private val BASE64URL_REGEX = Regex("[A-Za-z0-9_-]+")
    }
}
