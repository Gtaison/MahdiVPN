package com.mlmvpn.scanner.engines.argo

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.charset.StandardCharsets
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

class ArgoProtocolCoreTest {
    @Test
    fun hkdfMatchesKnownVector() {
        val prk = ArgoProtocolCore.hkdfExtract(
            "HmacSHA256",
            "salt".toByteArray(StandardCharsets.UTF_8),
            "input key material".toByteArray(StandardCharsets.UTF_8)
        )
        val output = ArgoProtocolCore.hkdfExpand("HmacSHA256", prk, "info", 42)
        assertEquals(
            "f1840c1f388c8fc7a9137c561360962da050de51672f0d7c9fee3ff15c251fec952b1167ce74a43929bf",
            output.joinToString("") { "%02x".format(it.toInt() and 0xff) }
        )
    }

    @Test
    fun authRequestProducesExpectedMaterialSizesAndGzipEnvelope() {
        val request = ArgoProtocolCore.authRequest("A", nowMs = 1_700_000_000_000L)
        assertEquals(32, request.key.size)
        assertEquals(12, request.iv.size)
        assertEquals(32, request.aad.size)

        val compressed = ArgoProtocolCore.decodeBase64(request.header)
        val gzip = java.util.zip.GZIPInputStream(compressed.inputStream())
        val payload = gzip.use { it.readBytes() }
        // RSA-2048 ciphertext plus 1..32 bytes of random padding.
        assertTrue(payload.size in 257..288)
    }

    @Test
    fun opensAuthenticatedAesGcmSessionResponse() {
        val key = ByteArray(32) { it.toByte() }
        val iv = ByteArray(12) { (it + 12).toByte() }
        val aad = "argo-aad".toByteArray(StandardCharsets.UTF_8)
        val request = ArgoProtocolCore.AuthRequest("unused", key, iv, aad)
        val response = JSONObject()
            .put("uuid", "123e4567-e89b-12d3-a456-426614174000")
            .put("token", "session-token")
            .put("wsPath", "/socket")
            .put("headers", JSONObject().put("X-Test", "yes"))
            .toString()
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), GCMParameterSpec(128, iv))
        cipher.updateAAD(aad)
        val encrypted = cipher.doFinal(response.toByteArray(StandardCharsets.UTF_8))
        val encoded = Base64.getEncoder().encodeToString(encrypted)

        val session = ArgoProtocolCore.openAnswer(request, encoded, clockOffsetSec = 17)
        assertEquals("123e4567-e89b-12d3-a456-426614174000", session.uuid)
        assertEquals("session-token", session.token)
        assertEquals("/socket", session.wsPath)
        assertEquals("yes", session.headers["X-Test"])
        assertEquals(17L, session.clockOffsetSec)
    }

    @Test
    fun decodesSnowcfgAndExtractsServerRecordsWithoutTrustingBadSignatures() {
        val parameters = JSONObject()
            .put("servers_ir_primary", JSONObject().put("server", "ir.example.net").put("port", 8443))
            .put("servers_global_primary", JSONObject().put("server", "global.example.org").put("port", 443))
        val payload = JSONObject().put("parameters", parameters).toString().toByteArray(StandardCharsets.UTF_8)
        val compressed = java.io.ByteArrayOutputStream().also { output ->
            java.util.zip.DeflaterOutputStream(output).use { it.write(payload) }
        }.toByteArray()
        val inverted = compressed.map { (it.toInt().inv() and 0xff).toByte() }.toByteArray()
        val encodedPayload = Base64.getEncoder().encodeToString(inverted)
        val envelope = "v1.snowcfg.9.1700000000.$encodedPayload.AAAA"

        val decoded = ArgoProtocolCore.decodeSnowcfg(envelope)
        assertEquals(9L, decoded.serial)
        assertEquals(1_700_000_000_000L, decoded.issuedAtMs)
        assertFalse(decoded.signatureValid)
        val servers = ArgoProtocolCore.publicServersOf(decoded.parameters)
        assertEquals(2, servers.size)
        assertTrue(servers.any { it.host == "ir.example.net" && it.port == 8443 })
        assertTrue(servers.any { it.host == "global.example.org" && it.port == 443 })
    }

    @Test
    fun validatesHostsAndBuildsWebSocketOutbound() {
        assertTrue(ArgoProtocolCore.looksLikeHost("edge.example.net"))
        assertFalse(ArgoProtocolCore.looksLikeHost("192.0.2.1"))
        assertFalse(ArgoProtocolCore.looksLikeHost("-bad.example"))

        val endpoint = ArgoProtocolCore.Endpoint("id", "bridge", "edge.example.net", 443, "A")
        val session = ArgoProtocolCore.SessionInfo(
            uuid = "uuid",
            token = "token",
            wsPath = "/argo",
            grpcServiceName = "",
            headers = mapOf("X-Session" to "1", "Host" to "ignored.example"),
            clockOffsetSec = 0
        )
        val outbound = ArgoProtocolCore.xrayOutbound(endpoint, session)
        assertEquals("vmess", outbound.getString("protocol"))
        val stream = outbound.getJSONObject("streamSettings")
        assertEquals("ws", stream.getString("network"))
        assertEquals("/argo", stream.getJSONObject("wsSettings").getString("path"))
        assertEquals("1", stream.getJSONObject("wsSettings").getJSONObject("headers").getString("X-Session"))
        assertFalse(stream.getJSONObject("wsSettings").getJSONObject("headers").has("Host"))
    }
}
