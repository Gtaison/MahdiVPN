package com.mlmvpn.scanner.engines.mami

import android.content.Context
import android.util.Base64
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.SecureRandom
import java.security.interfaces.RSAPrivateCrtKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.RSAKeyGenParameterSpec
import java.security.spec.RSAPublicKeySpec
import java.util.Locale

/**
 * Mami identity implementation compatible with the identity.json format used by the
 * original client. The long-lived device identity and its RSA key are persisted locally.
 */
class MamiIdentityCore(
    context: Context,
    private val store: MamiStore = MamiStore(context)
) {
    data class Identity(
        val deviceId: String,
        val androidId: String,
        val createdAt: Long,
        val keyCreatedAt: Long,
        val privateKey: PrivateKey,
        val publicKey: java.security.PublicKey,
        val publicKeyBase64Url: String,
        val publicKeyHash: String
    )

    data class Recipient(
        val privateKey: PrivateKey,
        val publicKey: java.security.PublicKey,
        val publicKeyBase64Url: String,
        val publicKeyHash: String
    )

    private val random = SecureRandom()

    @Synchronized
    fun loadOrCreate(): Identity {
        store.readJson(IDENTITY_FILE)?.let(::materialize)?.let { return it }

        val now = System.currentTimeMillis()
        val androidId = newAndroidId()
        val pair = generateRsa()
        val record = record(
            androidId = androidId,
            deviceId = deviceIdFor(androidId),
            createdAt = now,
            keyCreatedAt = now,
            privateKey = pair.private
        )
        store.writeJson(IDENTITY_FILE, record)
        return materialize(record)
            ?: throw IllegalStateException("The new Mami identity could not be loaded")
    }

    /** Per-request RSA-3072 recipient used by the signed catalog envelope. */
    fun freshRecipient(): Recipient = recipientOf(generateRsa())

    fun recipientOf(pair: KeyPair): Recipient {
        val publicKey = pair.public
        val encoded = publicKey.encoded
        return Recipient(
            privateKey = pair.private,
            publicKey = publicKey,
            publicKeyBase64Url = base64Url(encoded),
            publicKeyHash = base64Url(sha256(encoded))
        )
    }

    fun deviceIdFor(androidId: String, packageName: String = UPSTREAM_PACKAGE): String {
        require(isAndroidId(androidId)) { "android id has the wrong shape" }
        require(isPackage(packageName)) { "package name has the wrong shape" }
        // Chromium's MULTI_COOKIE_VALUE_SEPARATOR used by the original implementation is NUL.
        val material = "YAMYAM-DEVICE-ID-V1\u0000" + packageName + "\u0000" +
            androidId.lowercase(Locale.ROOT)
        return "dv1_" + base64Url(sha256(material.toByteArray(StandardCharsets.UTF_8)))
    }

    fun isAndroidId(value: String): Boolean =
        value.length in 16..64 &&
            value.all { it in '0'..'9' || it in 'a'..'f' || it in 'A'..'F' } &&
            !value.equals(BAD_ANDROID_ID, ignoreCase = true)

    fun newAndroidId(): String {
        val bytes = ByteArray(8)
        var value: String
        do {
            random.nextBytes(bytes)
            value = bytes.joinToString("") { "%02x".format(it.toInt() and 0xff) }
        } while (value == BAD_ANDROID_ID)
        return value
    }

    fun generateRsa(): KeyPair =
        KeyPairGenerator.getInstance("RSA").apply {
            initialize(RSAKeyGenParameterSpec(RSA_BITS, RSAKeyGenParameterSpec.F4), random)
        }.generateKeyPair()

    fun privateKeyOfPem(pem: String): PrivateKey {
        val body = pem
            .replace("-----BEGIN PRIVATE KEY-----", "")
            .replace("-----END PRIVATE KEY-----", "")
            .filterNot(Char::isWhitespace)
        val der = Base64.decode(body, Base64.DEFAULT)
        return KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(der))
    }

    fun pemOf(privateKey: PrivateKey): String {
        val encoded = Base64.encodeToString(privateKey.encoded, Base64.NO_WRAP)
        return "-----BEGIN PRIVATE KEY-----\n" +
            encoded.chunked(64).joinToString("\n") +
            "\n-----END PRIVATE KEY-----\n"
    }

    private fun materialize(json: JSONObject): Identity? = runCatching {
        require(json.optInt("v") == 1)
        val androidId = json.getString("androidId")
        require(isAndroidId(androidId))
        val deviceId = json.getString("deviceId")
        require(deviceId == deviceIdFor(androidId))

        val privateKey = privateKeyOfPem(json.getString("privateKey"))
        val rsaPrivate = privateKey as? RSAPrivateCrtKey
            ?: throw IllegalArgumentException("Mami identity key is not RSA CRT")
        require(rsaPrivate.modulus.bitLength() == RSA_BITS)

        val publicKey = KeyFactory.getInstance("RSA").generatePublic(
            RSAPublicKeySpec(rsaPrivate.modulus, rsaPrivate.publicExponent)
        )
        val publicBytes = publicKey.encoded
        val createdAt = json.optLong("createdAt", 0L)
        val storedKeyTime = json.optLong("keyCreatedAt", 0L)
        val keyCreatedAt = if (storedKeyTime != 0L) storedKeyTime else createdAt

        Identity(
            deviceId = deviceId,
            androidId = androidId,
            createdAt = createdAt,
            keyCreatedAt = keyCreatedAt,
            privateKey = privateKey,
            publicKey = publicKey,
            publicKeyBase64Url = base64Url(publicBytes),
            publicKeyHash = base64Url(sha256(publicBytes))
        )
    }.getOrNull()

    private fun record(
        androidId: String,
        deviceId: String,
        createdAt: Long,
        keyCreatedAt: Long,
        privateKey: PrivateKey
    ): JSONObject = JSONObject()
        .put("v", 1)
        .put("androidId", androidId)
        .put("deviceId", deviceId)
        .put("createdAt", createdAt)
        .put("keyCreatedAt", keyCreatedAt)
        .put("privateKey", pemOf(privateKey))

    private fun isPackage(value: String): Boolean =
        value.length in 3..200 && value.all {
            it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9' || it == '_' || it == '.'
        }

    private fun sha256(value: ByteArray): ByteArray =
        MessageDigest.getInstance("SHA-256").digest(value)

    private fun base64Url(value: ByteArray): String =
        Base64.encodeToString(value, Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING)

    companion object {
        const val IDENTITY_FILE = "identity.json"
        const val UPSTREAM_PACKAGE = "com.yamyam.vpn"
        const val BAD_ANDROID_ID = "9774d56d682e549c"
        const val RSA_BITS = 3072
    }
}
