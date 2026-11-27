package com.mlmvpn.scanner.engines.mami

import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.charset.StandardCharsets
import java.security.KeyPairGenerator
import java.security.MessageDigest
import java.security.Signature
import java.security.spec.ECGenParameterSpec
import java.security.spec.MGF1ParameterSpec
import java.security.spec.PSource
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.OAEPParameterSpec
import javax.crypto.spec.SecretKeySpec

class MamiEnvelopeCoreTest {
    @Test
    fun verifiesSignatureUnwrapsKeyAndDecryptsOneShotCatalogEnvelope() {
        val core = MamiEnvelopeCore()
        val rsa = KeyPairGenerator.getInstance("RSA").apply { initialize(3072) }.generateKeyPair()
        val recipientPublic = b64u(rsa.public.encoded)
        val recipientHash = b64u(sha256(rsa.public.encoded))
        val recipient = MamiIdentityCore.Recipient(
            publicKey = recipientPublic,
            publicKeyHash = recipientHash,
            privateKey = rsa.private,
            keyPair = rsa
        )
        val request = core.newRequest(
            payloadVersion = 8,
            minimumRevision = 0,
            audience = "mami-catalog",
            recipient = recipient
        )

        val signing = KeyPairGenerator.getInstance("EC")
            .apply { initialize(ECGenParameterSpec("secp256r1")) }
            .generateKeyPair()
        val now = System.currentTimeMillis() / 1000L
        val aesKey = ByteArray(32).also(java.security.SecureRandom()::nextBytes)
        val iv = ByteArray(12).also(java.security.SecureRandom()::nextBytes)
        val plaintext = """{"revision":7,"servers":[]}""".toByteArray(StandardCharsets.UTF_8)

        val fields = linkedMapOf(
            "version" to "1",
            "suite" to MamiEnvelopeCore.SUITE,
            "keyId" to "test-key",
            "audience" to "mami-catalog",
            "nonce" to request.context.nonce,
            "recipientKeyHash" to recipientHash,
            "issuedAt" to now.toString(),
            "expiresAt" to (now + 300L).toString(),
            "revision" to "7"
        )
        val header = core.headerBytes(fields)
        val encrypt = Cipher.getInstance("AES/GCM/NoPadding")
        encrypt.init(Cipher.ENCRYPT_MODE, SecretKeySpec(aesKey, "AES"), GCMParameterSpec(128, iv))
        encrypt.updateAAD(header)
        val ciphertext = encrypt.doFinal(plaintext)

        val wrap = Cipher.getInstance("RSA/ECB/OAEPPadding")
        wrap.init(
            Cipher.ENCRYPT_MODE,
            rsa.public,
            OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT)
        )
        fields["wrappedKey"] = b64u(wrap.doFinal(aesKey))
        fields["iv"] = b64u(iv)
        fields["ciphertext"] = b64u(ciphertext)

        val signer = Signature.getInstance("SHA256withECDSA")
        signer.initSign(signing.private)
        signer.update(core.signedBytes(fields))
        fields["signature"] = b64u(signer.sign())

        val envelope = JSONObject()
            .put("version", 1)
            .put("issuedAt", now)
            .put("expiresAt", now + 300L)
            .put("revision", 7)
            .put("suite", fields.getValue("suite"))
            .put("keyId", fields.getValue("keyId"))
            .put("audience", fields.getValue("audience"))
            .put("nonce", fields.getValue("nonce"))
            .put("recipientKeyHash", fields.getValue("recipientKeyHash"))
            .put("wrappedKey", fields.getValue("wrappedKey"))
            .put("iv", fields.getValue("iv"))
            .put("ciphertext", fields.getValue("ciphertext"))
            .put("signature", fields.getValue("signature"))

        val opened = core.open(
            responseBody = envelope.toString(),
            context = request.context,
            trustedKeys = mapOf("test-key" to signing.public)
        )
        assertArrayEquals(plaintext, opened.plaintext)
        assertEquals(7L, opened.revision)
        assertEquals("test-key", opened.keyId)
        assertThrows(IllegalArgumentException::class.java) {
            core.open(envelope.toString(), request.context, mapOf("test-key" to signing.public))
        }
    }

    @Test
    fun loadsOnlyPinnedP256SigningKeysFromBootstrap() {
        val signing = KeyPairGenerator.getInstance("EC")
            .apply { initialize(ECGenParameterSpec("secp256r1")) }
            .generateKeyPair()
        val bootstrap = JSONObject().put(
            "trustedSigningKeys",
            JSONArray().put(
                JSONObject()
                    .put("id", "catalog-key-1")
                    .put("spki", b64u(signing.public.encoded))
            )
        )
        val keys = MamiEnvelopeCore().loadTrustedKeys(bootstrap)
        assertTrue(keys.containsKey("catalog-key-1"))
        assertEquals("EC", keys.getValue("catalog-key-1").algorithm)
    }

    private fun sha256(bytes: ByteArray) = MessageDigest.getInstance("SHA-256").digest(bytes)

    private fun b64u(bytes: ByteArray) =
        Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)
}
