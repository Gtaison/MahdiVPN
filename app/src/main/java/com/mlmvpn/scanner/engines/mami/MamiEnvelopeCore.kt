package com.mlmvpn.scanner.engines.mami

import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import android.util.Base64
import org.json.JSONObject
import java.io.StringReader
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.PublicKey
import java.security.Signature
import java.security.interfaces.ECPublicKey
import java.security.spec.MGF1ParameterSpec
import java.security.spec.PSource
import java.security.spec.X509EncodedKeySpec
import java.security.spec.OAEPParameterSpec
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Authenticated Mami catalog envelope.
 *
 * Responses are signed by a pinned P-256 key, carry an RSA-3072-OAEP-wrapped AES-256 key,
 * and encrypt their payload with AES-256-GCM. Request contexts are one-shot and time-bound.
 */
class MamiEnvelopeCore {
    data class RequestContext internal constructor(
        val nonce: String,
        val audience: String,
        val minimumRevision: Long,
        val requestedAtSec: Long,
        val recipientKeyHash: String,
        internal val privateKey: java.security.PrivateKey,
        internal val startedAtNanos: Long,
        internal var used: Boolean = false
    )

    data class Request(val body: String, val context: RequestContext)

    data class Opened(
        val plaintext: ByteArray,
        val keyId: String,
        val revision: Long,
        val issuedAt: Long,
        val expiresAt: Long
    )

    private data class Fields(
        val version: Long,
        val issuedAt: Long,
        val expiresAt: Long,
        val revision: Long,
        val suite: String,
        val keyId: String,
        val audience: String,
        val nonce: String,
        val recipientKeyHash: String,
        val wrappedKey: String,
        val iv: String,
        val ciphertext: String,
        val signature: String
    )

    private val random = java.security.SecureRandom()

    fun loadTrustedKeys(bootstrap: JSONObject): Map<String, PublicKey> {
        val entries = bootstrap.optJSONArray("trustedSigningKeys")
            ?: throw IllegalArgumentException("Mami bootstrap has no trusted signing keys")
        val trusted = LinkedHashMap<String, PublicKey>()
        for (index in 0 until entries.length()) {
            val entry = entries.optJSONObject(index) ?: continue
            val id = entry.optString("id")
            val encoded = entry.optString("spki")
            if (!id.matches(KEY_ID_REGEX)) continue
            val der = strictB64u(encoded, "trusted signing key")
            val key = KeyFactory.getInstance("EC").generatePublic(X509EncodedKeySpec(der))
            require(key is ECPublicKey && key.params.curve.field.fieldSize == 256 &&
                key.params.order.bitLength() == 256
            ) { "Mami signing key is not P-256" }
            require(trusted.put(id, key) == null) { "Duplicate Mami signing key id" }
        }
        require(trusted.isNotEmpty()) { "Mami bootstrap has no usable signing keys" }
        return trusted
    }

    fun newRequest(
        payloadVersion: Int,
        minimumRevision: Long,
        audience: String,
        recipient: MamiIdentityCore.Recipient,
        clockOffsetSec: Long = 0L,
        nowMs: Long = System.currentTimeMillis()
    ): Request {
        require(payloadVersion in 2..8) { "Unsupported Mami payload version" }
        require(minimumRevision in 0..MAX_SAFE_INTEGER) { "Invalid Mami minimum revision" }
        require(audience.matches(AUDIENCE_REGEX)) { "Invalid Mami audience" }
        val nonceBytes = ByteArray(32).also(random::nextBytes)
        val nonce = base64Url(nonceBytes)
        val requestedAt = nowMs / 1000L + clockOffsetSec
        val context = RequestContext(
            nonce = nonce,
            audience = audience,
            minimumRevision = minimumRevision,
            requestedAtSec = requestedAt,
            recipientKeyHash = recipient.publicKeyHash,
            privateKey = recipient.privateKey,
            startedAtNanos = System.nanoTime()
        )
        val body = JSONObject()
            .put("version", 1)
            .put("payloadVersion", payloadVersion)
            .put("suite", SUITE)
            .put("audience", audience)
            .put("nonce", nonce)
            .put("minimumRevision", minimumRevision)
            .put("recipientPublicKey", recipient.publicKey)
            .put("recipientKeyHash", recipient.publicKeyHash)
            .toString()
        return Request(body, context)
    }

    fun open(
        responseBody: String,
        context: RequestContext,
        trustedKeys: Map<String, PublicKey>,
        clockOffsetSec: Long = 0L,
        nowMs: Long = System.currentTimeMillis()
    ): Opened {
        synchronized(context) {
            require(!context.used) { "Mami request context has already been used" }
            context.used = true
        }
        val elapsed = System.nanoTime() - context.startedAtNanos
        require(elapsed in 1L..MAX_REQUEST_NANOS) { "Mami response arrived outside the request window" }

        val fields = parseEnvelope(responseBody)
        require(fields.version == 1L) { "Unsupported Mami envelope version" }
        require(fields.suite == SUITE) { "Unsupported Mami envelope cipher suite" }
        require(fields.keyId.matches(KEY_ID_REGEX)) { "Invalid Mami signing key id" }
        require(fields.audience == context.audience) { "Mami response audience mismatch" }
        require(fields.nonce == context.nonce) { "Mami response nonce mismatch" }
        require(fields.recipientKeyHash == context.recipientKeyHash) { "Mami recipient key mismatch" }
        require(fields.revision >= context.minimumRevision && fields.revision > 0L) {
            "Mami catalog revision is older than requested"
        }

        val nowSec = nowMs / 1000L + clockOffsetSec
        require(fields.issuedAt >= context.requestedAtSec - 60L) { "Mami envelope was issued before this request" }
        require(fields.issuedAt <= nowSec + 60L) { "Mami envelope issue time is in the future" }
        require(fields.expiresAt > nowSec && fields.expiresAt > fields.issuedAt) { "Mami envelope has expired" }
        require(fields.expiresAt - fields.issuedAt <= MAX_ENVELOPE_LIFETIME_SEC) {
            "Mami envelope lifetime is too long"
        }

        val nonceBytes = strictB64u(fields.nonce, "nonce")
        val recipientHashBytes = strictB64u(fields.recipientKeyHash, "recipient key hash")
        require(nonceBytes.size == 32 && recipientHashBytes.size == 32) {
            "Invalid Mami request binding field size"
        }
        val signingKey = trustedKeys[fields.keyId]
            ?: throw IllegalArgumentException("Mami signing key is not trusted")
        val wrappedKey = strictB64u(fields.wrappedKey, "wrapped AES key")
        val iv = strictB64u(fields.iv, "AES-GCM IV")
        val ciphertext = strictB64u(fields.ciphertext, "ciphertext")
        val signature = strictB64u(fields.signature, "signature")
        require(wrappedKey.size == RSA_CIPHERTEXT_BYTES) { "Invalid wrapped AES key size" }
        require(iv.size == GCM_IV_BYTES) { "Invalid AES-GCM IV size" }
        require(ciphertext.size in GCM_TAG_BYTES..MAX_CIPHERTEXT_BYTES) { "Invalid Mami ciphertext size" }
        require(signature.size in 64..80) { "Invalid Mami signature size" }

        val header = headerBytes(fields)
        val signed = signedBytes(fields, header)
        val verifier = Signature.getInstance("SHA256withECDSA")
        verifier.initVerify(signingKey)
        verifier.update(signed)
        require(verifier.verify(signature)) { "Mami envelope signature verification failed" }

        val oaep = OAEPParameterSpec(
            "SHA-256",
            "MGF1",
            MGF1ParameterSpec.SHA256,
            PSource.PSpecified.DEFAULT
        )
        val unwrap = Cipher.getInstance("RSA/ECB/OAEPPadding")
        unwrap.init(Cipher.DECRYPT_MODE, context.privateKey, oaep)
        val aesKey = unwrap.doFinal(wrappedKey)
        require(aesKey.size == AES_KEY_BYTES) { "Invalid unwrapped Mami AES key" }

        try {
            val decrypt = Cipher.getInstance("AES/GCM/NoPadding")
            decrypt.init(Cipher.DECRYPT_MODE, SecretKeySpec(aesKey, "AES"), GCMParameterSpec(128, iv))
            decrypt.updateAAD(header)
            val plaintext = decrypt.doFinal(ciphertext)
            require(plaintext.size <= MAX_PLAINTEXT_BYTES) { "Mami catalog payload exceeds the size limit" }
            return Opened(
                plaintext = plaintext,
                keyId = fields.keyId,
                revision = fields.revision,
                issuedAt = fields.issuedAt,
                expiresAt = fields.expiresAt
            )
        } finally {
            aesKey.fill(0)
        }
    }

    fun headerBytes(fields: Map<String, String>): ByteArray {
        val ordered = listOf(
            fields.getValue("version"),
            fields.getValue("suite"),
            fields.getValue("keyId"),
            fields.getValue("audience"),
            fields.getValue("nonce"),
            fields.getValue("recipientKeyHash"),
            fields.getValue("issuedAt"),
            fields.getValue("expiresAt"),
            fields.getValue("revision")
        )
        return (HEADER_TAG + "\n" + ordered.joinToString("\n") + "\n")
            .toByteArray(StandardCharsets.UTF_8)
    }

    private fun headerBytes(fields: Fields): ByteArray = headerBytes(
        mapOf(
            "version" to fields.version.toString(),
            "suite" to fields.suite,
            "keyId" to fields.keyId,
            "audience" to fields.audience,
            "nonce" to fields.nonce,
            "recipientKeyHash" to fields.recipientKeyHash,
            "issuedAt" to fields.issuedAt.toString(),
            "expiresAt" to fields.expiresAt.toString(),
            "revision" to fields.revision.toString()
        )
    )

    fun signedBytes(fields: Map<String, String>): ByteArray {
        val header = headerBytes(fields)
        val suffix = fields.getValue("wrappedKey") + "\n" +
            fields.getValue("iv") + "\n" +
            fields.getValue("ciphertext") + "\n"
        return header + suffix.toByteArray(StandardCharsets.ISO_8859_1)
    }

    private fun signedBytes(fields: Fields, header: ByteArray): ByteArray {
        val suffix = fields.wrappedKey + "\n" + fields.iv + "\n" + fields.ciphertext + "\n"
        return header + suffix.toByteArray(StandardCharsets.ISO_8859_1)
    }

    private fun parseEnvelope(text: String): Fields {
        require(text.toByteArray(StandardCharsets.UTF_8).size <= MAX_ENVELOPE_BYTES) {
            "Mami envelope exceeds the size limit"
        }
        val values = LinkedHashMap<String, String>()
        val allowed = NUMBER_FIELDS + STRING_FIELDS
        JsonReader(StringReader(text)).use { reader ->
            reader.isLenient = false
            reader.beginObject()
            while (reader.hasNext()) {
                val key = reader.nextName()
                require(key in allowed) { "Unknown Mami envelope field: $key" }
                require(!values.containsKey(key)) { "Duplicate Mami envelope field: $key" }
                val value = when (reader.peek()) {
                    JsonToken.STRING, JsonToken.NUMBER -> reader.nextString()
                    else -> throw IllegalArgumentException("Invalid Mami envelope field type: $key")
                }
                values[key] = value
            }
            reader.endObject()
            require(reader.peek() == JsonToken.END_DOCUMENT) { "Trailing data after Mami envelope" }
        }
        require(values.keys == allowed) { "Mami envelope is missing required fields" }
        fun number(key: String): Long {
            val raw = values.getValue(key)
            require(raw.matches(UNSIGNED_INTEGER_REGEX)) { "Invalid Mami numeric field: $key" }
            return raw.toLongOrNull()?.takeIf { it <= MAX_SAFE_INTEGER }
                ?: throw IllegalArgumentException("Mami numeric field is out of range: $key")
        }
        fun string(key: String) = values.getValue(key)
        return Fields(
            version = number("version"),
            issuedAt = number("issuedAt"),
            expiresAt = number("expiresAt"),
            revision = number("revision"),
            suite = string("suite"),
            keyId = string("keyId"),
            audience = string("audience"),
            nonce = string("nonce"),
            recipientKeyHash = string("recipientKeyHash"),
            wrappedKey = string("wrappedKey"),
            iv = string("iv"),
            ciphertext = string("ciphertext"),
            signature = string("signature")
        )
    }

    private fun strictB64u(value: String, label: String): ByteArray {
        require(value.isNotEmpty() && value.matches(BASE64URL_REGEX)) { "Invalid $label encoding" }
        val decoded = Base64.decode(value, Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING)
        require(base64Url(decoded) == value) { "Non-canonical $label encoding" }
        return decoded
    }

    private fun base64Url(value: ByteArray): String =
        Base64.encodeToString(value, Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING)

    companion object {
        const val SUITE = "P256-SHA256+RSA3072-OAEP256+A256GCM"
        private const val HEADER_TAG = "YAMYAM-CATALOG-V1"
        private const val AES_KEY_BYTES = 32
        private const val GCM_IV_BYTES = 12
        private const val GCM_TAG_BYTES = 16
        private const val RSA_CIPHERTEXT_BYTES = 384
        private const val MAX_CIPHERTEXT_BYTES = 262_160
        private const val MAX_PLAINTEXT_BYTES = 262_144
        private const val MAX_ENVELOPE_BYTES = 524_288
        private const val MAX_ENVELOPE_LIFETIME_SEC = 21_600L
        private const val MAX_REQUEST_NANOS = 120_000_000_000L
        private const val MAX_SAFE_INTEGER = 9_007_199_254_740_991L
        private val KEY_ID_REGEX = Regex("[A-Za-z0-9_-]{1,64}")
        private val AUDIENCE_REGEX = Regex("[A-Za-z0-9._-]{1,128}")
        private val BASE64URL_REGEX = Regex("[A-Za-z0-9_-]+")
        private val UNSIGNED_INTEGER_REGEX = Regex("0|[1-9][0-9]*")
        private val NUMBER_FIELDS = setOf("version", "issuedAt", "expiresAt", "revision")
        private val STRING_FIELDS = setOf(
            "suite", "keyId", "audience", "nonce", "recipientKeyHash",
            "wrappedKey", "iv", "ciphertext", "signature"
        )
    }
}
