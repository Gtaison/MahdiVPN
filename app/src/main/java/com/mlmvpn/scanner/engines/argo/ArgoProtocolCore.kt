package com.mlmvpn.scanner.engines.argo

import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.MessageDigest
import java.security.PublicKey
import java.security.SecureRandom
import java.security.Signature
import java.security.spec.MGF1ParameterSpec
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import java.util.Locale
import java.util.zip.GZIPOutputStream
import java.util.zip.Inflater
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.OAEPParameterSpec
import javax.crypto.spec.PSource
import javax.crypto.spec.SecretKeySpec

/**
 * Source-level implementation of the Argo wire protocol recovered from the 1.2.51
 * application binary. Kept independent of UI and Android services so crypto and parsing
 * can be tested before the connection lifecycle is integrated.
 *
 * Do not weaken signature, authentication, or payload-size checks to make a server respond.
 */
object ArgoProtocolCore {
    private val random = SecureRandom()

    // Public protocol keys shipped by the 1.2.51 client. These are public verification /
    // encryption keys, not private credentials.
    private const val RSA_SPKI =
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz/M4JOwjHadx2ZsZZOATv0sT+YCtleYy4BPBBYA1KKypT59gVc5y1geVIbV6ssktTGnWE7q2BQsKG6QLZ13Xzdc/uYHm8hcQewlsUrh5i3qs9kyZSHXV9TqPna4sKX9pVxMxO+PfUWABzygRgDdpP3x/Y8my7oh3NVbRKrWrabcAtuyL3mdQGCWHooaVQfYttLWBuCSDUF8C5AnDUNQ5DnOrQFt8bKMQoqt7aj97Ecf2TiU0jxUAKt5QpmuS+Yjrny6/U7aCFU9iP+uQFwKNBRpxwlR/OS4mIq9gCWkrI7FWJ2i4AGU878IwiwGKYwvJK2Pyk3+6fW4dVg7+K+6B7QIDAQAB"

    const val BRIDGE_KEY_SPKI =
        "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwVEhfRU709R1WPT3cVgu2beUJGJ7OHk27uQjfc6PxpLdg+GKqm/t8c2GMH6FCgcRsB+s8FH+YD8gXiiE5b4g/Q=="

    private val bridgeBlockRegex = Regex(
        "(?:-\\+|-+)\\s*BEGIN ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)([\\s\\S]*?)(?:-\\+|-+)\\s*END ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)",
        RegexOption.IGNORE_CASE
    )
    private val bridgeMarkerRegex = Regex(
        "(?:-\\+|-+)\\s*(?:BEGIN|END) ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)",
        RegexOption.IGNORE_CASE
    )
    private val domainRegex = Regex(
        "^(?=.{1,253}$)([a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z][a-z0-9-]{1,23}$",
        RegexOption.IGNORE_CASE
    )
    private val ipv4Regex = Regex("^\\d+\\.\\d+\\.\\d+\\.\\d+$")

    data class AuthRequest(
        val header: String,
        val key: ByteArray,
        val iv: ByteArray,
        val aad: ByteArray
    )

    data class SessionInfo(
        val uuid: String,
        val token: String,
        val wsPath: String,
        val grpcServiceName: String,
        val headers: Map<String, String>,
        val clockOffsetSec: Long
    )

    data class Endpoint(
        val id: String,
        val kind: String,
        val host: String,
        val port: Int,
        val protocol: String
    )

    data class Bridge(
        val host: String,
        val port: Int,
        val protocol: String,
        val signatureValid: Boolean,
        val headers: Map<String, String>
    )

    data class FalconOrigin(val ip: String, val countryCode: String, val load: Double)

    /** HKDF-Extract, as used by the original Argo handshake. */
    fun hkdfExtract(algorithm: String, salt: ByteArray, inputKeyMaterial: ByteArray): ByteArray =
        hmac(algorithm, salt, inputKeyMaterial)

    /** HKDF-Expand, with the exact info||counter ordering used by the original client. */
    fun hkdfExpand(algorithm: String, pseudorandomKey: ByteArray, info: String, length: Int): ByteArray {
        require(length in 1..(255 * macLength(algorithm))) { "Invalid HKDF output length" }
        val output = ByteArrayOutputStream()
        var previous = ByteArray(0)
        var counter = 1
        val infoBytes = info.toByteArray(StandardCharsets.UTF_8)
        while (output.size() < length) {
            previous = hmac(algorithm, pseudorandomKey, previous + infoBytes + byteArrayOf(counter.toByte()))
            output.write(previous)
            counter++
        }
        return output.toByteArray().copyOf(length)
    }

    fun hmac(algorithm: String, key: ByteArray, data: ByteArray): ByteArray {
        val mac = Mac.getInstance(algorithm)
        mac.init(SecretKeySpec(key, algorithm))
        return mac.doFinal(data)
    }

    private fun macLength(algorithm: String): Int =
        when (algorithm.uppercase(Locale.ROOT)) {
            "HMACSHA256" -> 32
            "HMACSHA512" -> 64
            else -> throw IllegalArgumentException("Unsupported HMAC: $algorithm")
        }

    /**
     * Creates the encrypted Authorization header and the per-request AES-GCM material.
     * [clockOffsetSec] is the server clock correction learned from the previous session.
     */
    fun authRequest(protocol: String, nowMs: Long = System.currentTimeMillis(), clockOffsetSec: Long = 0L): AuthRequest {
        val salt = ByteArray(32).also(random::nextBytes)
        val secretSalt = ByteArray(32).also(random::nextBytes)
        val secretInput = ByteArray(32).also(random::nextBytes)

        val secret = hkdfExpand(
            "HmacSHA512",
            hkdfExtract("HmacSHA512", secretSalt, secretInput),
            "ArgoVPN-Derivation",
            32
        )
        val prk = hkdfExtract("HmacSHA256", salt, secret)
        val key = hkdfExpand("HmacSHA256", prk, "Argo-AES-Key", 32)
        val iv = hkdfExpand("HmacSHA256", prk, "Argo-AES-IV", 12)
        val payload = JSONObject()
            .put("protocol", if (protocol == "B") "B" else "A")
            .put("request", "auth")
            .put("salt", base64NoPadding(salt))
            .put("secret", base64NoPadding(secret))
            .put("t", nowMs + clockOffsetSec * 1000L)
            .put("v", 3)
            .toString()
        val header = sealRequest(payload)
        val aad = hmac("HmacSHA256", macKey(), header.toByteArray(StandardCharsets.UTF_8))
        return AuthRequest(header, key, iv, aad)
    }

    /** Opens the AES-GCM response returned by an Argo endpoint. */
    fun openAnswer(request: AuthRequest, responseBody: String, clockOffsetSec: Long = 0L): SessionInfo {
        val encrypted = decodeBase64(responseBody)
        require(encrypted.size >= 17) { "Argo response is too short" }
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(request.key, "AES"), GCMParameterSpec(128, request.iv))
        cipher.updateAAD(request.aad)
        val plain = cipher.doFinal(encrypted)
        val json = JSONObject(String(plain, StandardCharsets.UTF_8))
        val uuid = json.optString("uuid").trim()
        require(uuid.isNotEmpty()) { "Argo response has no UUID" }
        val headersJson = json.optJSONObject("headers")
        val headers = buildMap {
            if (headersJson != null) {
                val keys = headersJson.keys()
                while (keys.hasNext()) {
                    val key = keys.next()
                    put(key, headersJson.optString(key, ""))
                }
            }
        }
        return SessionInfo(
            uuid = uuid,
            token = json.optString("token", ""),
            wsPath = json.optString("wsPath", "/").ifBlank { "/" },
            grpcServiceName = json.optString("grpcServiceName", ""),
            headers = headers,
            clockOffsetSec = clockOffsetSec
        )
    }

    fun sessionHeader(kind: String, session: SessionInfo, nowMs: Long = System.currentTimeMillis()): String {
        val sessionId = sha256Hex(session.uuid + session.token)
        val payload = JSONObject()
            .put("request", kind)
            .put("sessionId", sessionId)
            .put("t", nowMs + session.clockOffsetSec * 1000L)
            .put("v", 3)
            .toString()
        return sealRequest(payload)
    }

    /** Convert an authenticated Argo endpoint into the Xray VMess outbound used by the app. */
    fun xrayOutbound(
        endpoint: Endpoint,
        session: SessionInfo,
        tag: String = "argo",
        connectIp: String = endpoint.host,
        fingerprint: String = "chrome"
    ): JSONObject {
        require(endpoint.port in 1..65535)
        val grpc = endpoint.protocol == "B" && session.grpcServiceName.isNotBlank()
        val user = JSONObject()
            .put("id", session.uuid)
            .put("alterId", 0)
            .put("security", "auto")
        val server = JSONObject()
            .put("address", connectIp.ifBlank { endpoint.host })
            .put("port", endpoint.port)
            .put("users", JSONArray().put(user))
        val settings = JSONObject().put("vnext", JSONArray().put(server))
        val stream = JSONObject().put("network", if (grpc) "grpc" else "ws").put("security", "tls")
        val tls = JSONObject()
            .put("serverName", endpoint.host)
            .put("fingerprint", fingerprint.ifBlank { "chrome" })
            .put("alpn", JSONArray().put(if (grpc) "h2" else "http/1.1"))
        stream.put("tlsSettings", tls)
        if (grpc) {
            stream.put("grpcSettings", JSONObject().put("serviceName", session.grpcServiceName))
        } else {
            val headers = JSONObject()
            session.headers.forEach { (key, value) ->
                if (!key.equals("host", ignoreCase = true)) headers.put(key, value)
            }
            stream.put(
                "wsSettings",
                JSONObject()
                    .put("path", session.wsPath.ifBlank { "/" })
                    .put("host", endpoint.host)
                    .put("headers", headers)
            )
        }
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "vmess")
            .put("settings", settings)
            .put("streamSettings", stream)
    }

    /** Decode a signed/unsigned bridge block. An invalid signature is reported, not trusted. */
    fun decodeBridgeBlock(block: String): Bridge {
        val payloadText = bridgeMarkerRegex.replace(block, "").filterNot(Char::isWhitespace)
        require(payloadText.isNotEmpty()) { "Empty Argo bridge block" }
        val outer = JSONObject(String(inflate(decodeBase64(payloadText), 1_048_576), StandardCharsets.UTF_8))
        val payload = outer.optString("payload")
        require(payload.isNotBlank()) { "Bridge block has no payload" }
        require(outer.optInt("v", -1) == 1) { "Unsupported bridge block version" }
        val signatureValid = runCatching {
            verifyEcdsa(BRIDGE_KEY_SPKI, payload.toByteArray(StandardCharsets.UTF_8), decodeBase64(outer.optString("signature")))
        }.getOrDefault(false)
        val inner = JSONObject(String(decodeBase64(payload), StandardCharsets.UTF_8))
        val host = inner.optString("server").ifBlank { inner.optString("hostName") }
            .trim().lowercase(Locale.ROOT)
        require(looksLikeHost(host)) { "Invalid bridge hostname" }
        val port = inner.optString("port").toIntOrNull()?.takeIf { it in 1..65535 } ?: 443
        val protocol = if (inner.optString("protocol", "A").uppercase(Locale.ROOT) == "B") "B" else "A"
        val headersJson = inner.optJSONObject("headers")
        val headers = buildMap {
            if (headersJson != null) {
                val keys = headersJson.keys()
                while (keys.hasNext()) {
                    val key = keys.next()
                    put(key, headersJson.optString(key, ""))
                }
            }
        }
        return Bridge(host, port, protocol, signatureValid, headers)
    }

    fun extractBridgeBlocks(text: String): List<String> =
        bridgeBlockRegex.findAll(text).map { it.value }.toList()

    /** Falcon server lists are base64, byte-inverted, then zlib-compressed JSON. */
    fun decodeFalconServers(encoded: String): List<FalconOrigin> {
        val inverted = decodeBase64(encoded.trim()).map { (it.toInt().inv() and 0xff).toByte() }.toByteArray()
        val array = JSONArray(String(inflate(inverted, 1_048_576), StandardCharsets.UTF_8))
        return buildList {
            for (i in 0 until array.length()) {
                val item = array.optJSONObject(i) ?: continue
                val ip = item.optString("ip")
                if (ip.isBlank()) continue
                add(FalconOrigin(ip, item.optString("countryCode"), item.optDouble("serverLoad", 0.0)))
            }
        }
    }

    fun looksLikeHost(host: String): Boolean {
        val normalized = host.trim().trimEnd('.').lowercase(Locale.ROOT)
        return normalized.length in 4..253 && domainRegex.matches(normalized) && !ipv4Regex.matches(normalized)
    }

    fun verifyEcdsa(spkiBase64: String, data: ByteArray, signatureDer: ByteArray): Boolean = runCatching {
        val keyBytes = decodeBase64(spkiBase64)
        val key = KeyFactory.getInstance("EC").generatePublic(X509EncodedKeySpec(keyBytes))
        Signature.getInstance("SHA256withECDSA").run {
            initVerify(key)
            update(data)
            verify(signatureDer)
        }
    }.getOrDefault(false)

    fun sha256Hex(value: String): String =
        MessageDigest.getInstance("SHA-256")
            .digest(value.toByteArray(StandardCharsets.UTF_8))
            .joinToString("") { "%02x".format(it.toInt() and 0xff) }

    fun decodeBase64(value: String): ByteArray {
        val clean = value.filterNot(Char::isWhitespace)
        val padded = clean + "=".repeat((4 - clean.length % 4) % 4)
        return Base64.getDecoder().decode(padded)
    }

    fun base64NoPadding(bytes: ByteArray): String =
        Base64.getEncoder().withoutPadding().encodeToString(bytes)

    /** The original format uses RSA-OAEP(SHA-256, MGF1-SHA-256), then gzip and base64. */
    fun sealRequest(jsonText: String): String {
        val plain = jsonText.toByteArray(StandardCharsets.UTF_8)
        require(plain.size <= 190) { "Argo request payload exceeds RSA limit" }
        val keyBytes = decodeBase64(RSA_SPKI)
        val publicKey: PublicKey = KeyFactory.getInstance("RSA")
            .generatePublic(X509EncodedKeySpec(keyBytes))
        val cipher = Cipher.getInstance("RSA/ECB/OAEPPadding")
        cipher.init(
            Cipher.ENCRYPT_MODE,
            publicKey,
            OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT)
        )
        val encrypted = cipher.doFinal(plain)
        val padding = ByteArray(random.nextInt(32) + 1).also(random::nextBytes)
        return base64NoPadding(gzip(encrypted + padding))
    }

    private fun macKey(): ByteArray =
        hkdfExpand("HmacSHA256", decodeBase64(RSA_SPKI), "Argo-RSA-MAC-Key", 32)

    private fun gzip(input: ByteArray): ByteArray {
        val output = ByteArrayOutputStream()
        GZIPOutputStream(output).use { it.write(input) }
        return output.toByteArray()
    }

    /** Bounded zlib inflater; callers must choose a limit appropriate to the data type. */
    fun inflate(input: ByteArray, maxBytes: Int): ByteArray {
        require(maxBytes > 0)
        val inflater = Inflater()
        val output = ByteArrayOutputStream()
        val buffer = ByteArray(8192)
        try {
            inflater.setInput(input)
            while (!inflater.finished()) {
                val count = inflater.inflate(buffer)
                if (count == 0 && (inflater.needsInput() || inflater.needsDictionary())) {
                    throw IllegalArgumentException("Truncated zlib stream")
                }
                if (count > 0) {
                    output.write(buffer, 0, count)
                    require(output.size() <= maxBytes) { "Inflated payload exceeds limit" }
                }
            }
            return output.toByteArray()
        } finally {
            inflater.end()
        }
    }
}
