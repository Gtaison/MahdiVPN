package com.mlmvpn.scanner.engines.mami

import android.content.Context
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.SecureRandom
import java.security.spec.PKCS8EncodedKeySpec
import java.util.Locale
import java.util.Base64

/**
 * Mami device identity and short-lived RSA response recipients.
 *
 * The persistent identity is deliberately independent of Android's advertising identifiers.
 * The API's device id is derived from a random local Android-id surrogate and the upstream
 * client package namespace, matching the original Mami client format.
 */
class MamiIdentityCore(
    private val context: Context,
    private val store: MamiStore = MamiStore(context)
) {
    data class Identity(
        val androidId: String,
        val deviceId: String,
        val createdAt: Long,
        val keyCreatedAt: Long,
        val privateKeyPem: String
    )

    data class Recipient(
        val publicKey: String,
        val publicKeyHash: String,
        val privateKey: PrivateKey,
        val keyPair: KeyPair
    )

    private val random = SecureRandom()

    @Synchronized
    fun loadOrCreate(): Identity {
        val saved = store.readJson(IDENTITY_FILE)
        val restored = saved?.let(::identityFromJson)
        if (restored != null) return restored

        val now = System.currentTimeMillis()
        val androidId = newAndroidId()
        val deviceId = deviceIdFor(androidId, UPSTREAM_PACKAGE)
        val pair = generateRsa()
        val privatePem = privateKeyToPem(pair.private.encoded)
        val identity = Identity(androidId, deviceId, now, now, privatePem)
        store.writeJson(IDENTITY_FILE, identityToJson(identity))
        return identity
    }

    /** Creates the per-request RSA-3072 key pair used to decrypt one catalog envelope. */
    fun freshRecipient(): Recipient = describePublicKey(generateRsa())

    fun describePublicKey(pair: KeyPair): Recipient {
        val der = pair.public.encoded
        return Recipient(
            publicKey = base64Url(der),
            publicKeyHash = base64Url(sha256(der)),
            privateKey = pair.private,
            keyPair = pair
        )
    }

    fun deviceIdFor(androidId: String, packageName: String = UPSTREAM_PACKAGE): String {
        require(isAndroidId(androidId))
        require(packageName.matches(Regex("[A-Za-z0-9_.]{1,160}")))
        val material = "YAMYAM-DEVICE-ID-V1" + '\u0000' + packageName + '\u001f' + androidId.lowercase(Locale.ROOT)
        return "dv1_" + base64Url(sha256(material.toByteArray(StandardCharsets.UTF_8)))
    }

    fun isAndroidId(value: String): Boolean =
        value.matches(Regex("[0-9a-fA-F]{16,64}")) &&
            !value.equals("9774d56d682e549c", ignoreCase = true)

    fun newAndroidId(): String {
        val bytes = ByteArray(8)
        random.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it.toInt() and 0xff) }
    }

    fun generateRsa(): KeyPair =
        KeyPairGenerator.getInstance("RSA").apply { initialize(RSA_BITS, random) }.generateKeyPair()

    fun privateKeyFromPem(pem: String): PrivateKey {
        val body = pem
            .replace("-----BEGIN PRIVATE KEY-----", "")
            .replace("-----END PRIVATE KEY-----", "")
            .filterNot(Char::isWhitespace)
        val der = Base64.getDecoder().decode(body)
        return KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(der))
    }

    private fun identityFromJson(json: JSONObject): Identity? = runCatching {
        require(json.optInt("version") == 1)
        val androidId = json.getString("androidId")
        require(isAndroidId(androidId))
        val deviceId = json.getString("deviceId")
        require(deviceId == deviceIdFor(androidId, UPSTREAM_PACKAGE))
        val privatePem = json.getString("privateKeyPem")
        val privateKey = privateKeyFromPem(privatePem)
        require(privateKey.algorithm.equals("RSA", ignoreCase = true))
        Identity(
            androidId = androidId,
            deviceId = deviceId,
            createdAt = json.getLong("createdAt"),
            keyCreatedAt = json.getLong("keyCreatedAt"),
            privateKeyPem = privatePem
        )
    }.getOrNull()

    private fun identityToJson(identity: Identity): JSONObject =
        JSONObject()
            .put("version", 1)
            .put("androidId", identity.androidId)
            .put("deviceId", identity.deviceId)
            .put("createdAt", identity.createdAt)
            .put("keyCreatedAt", identity.keyCreatedAt)
            .put("privateKeyPem", identity.privateKeyPem)

    private fun privateKeyToPem(der: ByteArray): String {
        val encoded = Base64.getMimeEncoder(64, "\n".toByteArray()).encodeToString(der)
        return "-----BEGIN PRIVATE KEY-----\n" + encoded + "\n-----END PRIVATE KEY-----"
    }

    private fun sha256(value: ByteArray): ByteArray =
        MessageDigest.getInstance("SHA-256").digest(value)

    private fun base64Url(value: ByteArray): String =
        Base64.getUrlEncoder().withoutPadding().encodeToString(value)

    companion object {
        private const val IDENTITY_FILE = "identity.json"
        private const val UPSTREAM_PACKAGE = "com.yamyam.vpn"
        private const val RSA_BITS = 3072
    }
}
