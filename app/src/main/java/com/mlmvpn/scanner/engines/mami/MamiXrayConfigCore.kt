package com.mlmvpn.scanner.engines.mami

import org.json.JSONArray
import org.json.JSONObject
import android.util.Base64

/** Builds Xray-compatible outbound and full tunnel JSON for every supported Mami profile. */
class MamiXrayConfigCore {
    fun outboundFor(server: MamiCatalogCore.Server, tag: String = TAG, allowHysteriaGecko: Boolean = false): JSONObject {
        unsupportedReason(server, allowHysteriaGecko)?.let { throw IllegalArgumentException(it) }
        return when (server.protocol) {
            "trojan" -> trojan(server, tag)
            "hysteria2" -> hysteria2(server, tag)
            "vless-xhttp" -> vlessXhttp(server, tag)
            "vless-raw-reality" -> vlessRaw(server, tag)
            "vless-grpc-reality" -> vlessGrpc(server, tag)
            "vless" -> vlessGeneric(server, tag)
            else -> throw IllegalArgumentException("Unsupported Mami protocol: ${server.protocol}")
        }
    }

    fun configFor(
        server: MamiCatalogCore.Server,
        port: Int,
        listen: String = "127.0.0.1",
        logLevel: String = "warning",
        allowHysteriaGecko: Boolean = false
    ): JSONObject = configFor(outboundFor(server, TAG, allowHysteriaGecko), port, listen, logLevel)

    fun configJson(
        server: MamiCatalogCore.Server,
        tag: String = TAG,
        port: Int,
        listen: String = "127.0.0.1",
        logLevel: String = "warning",
        allowHysteriaGecko: Boolean = false
    ): String {
        server.json?.let { return it }
        return configFor(outboundFor(server, tag, allowHysteriaGecko), port, listen, logLevel).toString()
    }

    private fun configFor(
        outbound: JSONObject,
        port: Int,
        listen: String,
        logLevel: String
    ): JSONObject {
        require(port in 1..65_535)
        require(listen.isNotBlank())
        val inbounds = JSONArray().put(
            JSONObject()
                .put("tag", "mami-in")
                .put("port", port)
                .put("listen", listen)
                .put("protocol", "socks")
                .put("settings", JSONObject().put("udp", true))
        )
        val outbounds = JSONArray()
            .put(outbound)
            .put(JSONObject().put("tag", "direct").put("protocol", "freedom"))
            .put(JSONObject().put("tag", "block").put("protocol", "blackhole"))
        val rules = JSONArray()
            .put(
                JSONObject()
                    .put("type", "field")
                    .put("ip", JSONArray().put("::/0"))
                    .put("outboundTag", "block")
            )
            .put(
                JSONObject()
                    .put("type", "field")
                    .put("network", "udp")
                    .put("port", "443")
                    .put("outboundTag", "block")
            )
        return JSONObject()
            .put("log", JSONObject().put("loglevel", logLevel))
            .put("inbounds", inbounds)
            .put("outbounds", outbounds)
            .put("routing", JSONObject().put("domainStrategy", "AsIs").put("rules", rules))
    }

    fun unsupportedReason(server: MamiCatalogCore.Server?, allowHysteriaGecko: Boolean = false): String? {
        if (!allowHysteriaGecko && server?.protocol == "hysteria2" &&
            server.raw.optJSONObject("hysteria2")?.optString("obfs") == "gecko"
        ) return "پوشش gecko را موتور Xray این نسخه پشتیبانی نمی‌کند"
        return null
    }

    private fun trojan(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val settings = JSONObject().put(
            "servers",
            JSONArray().put(
                JSONObject()
                    .put("address", server.host)
                    .put("port", server.port)
                    .put("password", server.raw.optString("password"))
            )
        )
        val tls = JSONObject()
            .put("serverName", server.tlsServerName)
            .put("minVersion", "1.2")
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "trojan")
            .put("settings", settings)
            .put(
                "streamSettings",
                JSONObject()
                    .put("network", "raw")
                    .put("security", "tls")
                    .put("tlsSettings", tls)
            )
    }

    private fun hysteria2(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val hy2 = server.raw.getJSONObject("hysteria2")
        val stream = JSONObject()
            .put("network", "hysteria")
            .put("security", "tls")
        val hy2Settings = JSONObject()
            .put("version", 2)
            .put("auth", hy2.optString("auth"))
        val tls = JSONObject()
            .put("serverName", server.tlsServerName)
            .put("alpn", JSONArray().put("h3"))
        val pin = hy2.optString("pinSHA256")
        if (pin.isNotBlank()) tls.put("pinnedPeerCertSha256", hexOfPin(pin))
        stream.put("hysteriaSettings", hy2Settings)
        stream.put("tlsSettings", tls)

        val obfs = hy2.optString("obfs")
        if (obfs.isNotBlank()) {
            val settings = JSONObject().put("password", hy2.optString("obfsPassword"))
            if (obfs == "gecko") settings.put("packetSize", "512-1200")
            stream.put("udp", JSONArray().put(JSONObject().put("type", obfs).put("settings", settings)))
        }
        val hopPorts = hy2.optString("hopPorts")
        if (hopPorts.isNotBlank()) {
            stream.put(
                "quicParams",
                JSONObject().put(
                    "udpHop",
                    JSONObject()
                        .put("ports", hopPorts)
                        .put("interval", hy2.optInt("hopInterval"))
                )
            )
        }
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "hysteria")
            .put(
                "settings",
                JSONObject()
                    .put("version", 2)
                    .put("address", server.host)
                    .put("port", server.port)
            )
            .put("streamSettings", stream)
    }

    private fun vlessSettings(server: MamiCatalogCore.Server, user: JSONObject): JSONObject =
        JSONObject().put(
            "vnext",
            JSONArray().put(
                JSONObject()
                    .put("address", server.host)
                    .put("port", server.port)
                    .put("users", JSONArray().put(user))
            )
        )

    private fun vlessGeneric(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val vless = server.raw.getJSONObject("vless")
        val network = vless.optString("network")
        val security = vless.optString("security")
        val stream = JSONObject().put("network", network).put("security", security)

        when (network) {
            "ws" -> {
                val ws = vless.getJSONObject("ws")
                val settings = JSONObject().put("path", ws.optString("path"))
                putOptional(settings, "host", ws.optString("host"))
                putOptional(settings, "heartbeatPeriod", ws.optInt("heartbeatPeriod"))
                stream.put("wsSettings", settings)
            }
            "httpupgrade" -> {
                val upgrade = vless.getJSONObject("httpupgrade")
                val settings = JSONObject().put("path", upgrade.optString("path"))
                putOptional(settings, "host", upgrade.optString("host"))
                stream.put("httpupgradeSettings", settings)
            }
            "xhttp" -> stream.put("xhttpSettings", xhttpSettings(vless.getJSONObject("xhttp")))
            "grpc" -> {
                val grpc = vless.getJSONObject("grpc")
                val settings = JSONObject()
                    .put("serviceName", grpc.optString("serviceName"))
                    .put("multiMode", grpc.optBoolean("multiMode"))
                putOptional(settings, "multi_connections", grpc.optInt("multiConnections"))
                putOptional(settings, "authority", grpc.optString("authority"))
                putOptional(settings, "idle_timeout", grpc.optInt("idleTimeout"))
                putOptional(settings, "health_check_timeout", grpc.optInt("healthCheckTimeout"))
                if (grpc.optBoolean("permitWithoutStream")) settings.put("permit_without_stream", true)
                stream.put("grpcSettings", settings)
            }
        }

        if (security == "reality") {
            val reality = vless.getJSONObject("reality")
            stream.put(
                "realitySettings",
                reality(
                    server.tlsServerName,
                    reality.optString("fingerprint"),
                    reality.optString("publicKey"),
                    reality.optString("shortId"),
                    reality.optString("spiderX"),
                    reality.optString("mldsa65Verify")
                )
            )
        } else {
            val tls = vless.getJSONObject("tls")
            val settings = JSONObject()
                .put("serverName", server.tlsServerName)
                .put("fingerprint", tls.optString("fingerprint").ifBlank { FP })
                .put("minVersion", "1.2")
            val alpn = tls.optJSONArray("alpn")
            if (alpn != null && alpn.length() > 0) settings.put("alpn", alpn)
            val pin = tls.optString("pinSHA256")
            if (pin.isNotBlank()) settings.put("pinnedPeerCertSha256", hexOfPin(pin))
            stream.put("tlsSettings", settings)
        }

        val sockopt = vless.optJSONObject("sockopt")
        if (sockopt != null) {
            val settings = JSONObject()
            putOptional(settings, "tcpKeepAliveIdle", sockopt.optInt("tcpKeepAliveIdle"))
            putOptional(settings, "tcpKeepAliveInterval", sockopt.optInt("tcpKeepAliveInterval"))
            if (sockopt.optBoolean("tcpFastOpen")) settings.put("tcpFastOpen", true)
            if (sockopt.optBoolean("tcpMptcp")) settings.put("tcpMptcp", true)
            putOptional(settings, "tcpCongestion", sockopt.optString("tcpCongestion"))
            if (settings.length() > 0) stream.put("sockopt", settings)
        }

        val user = JSONObject()
            .put("id", vless.optString("uuid"))
            .put("encryption", vless.optString("encryption"))
        putOptional(user, "flow", vless.optString("flow"))
        val outbound = JSONObject()
            .put("tag", tag)
            .put("protocol", "vless")
            .put("settings", vlessSettings(server, user))
            .put("streamSettings", stream)

        val mux = vless.optJSONObject("mux")
        if (mux != null && mux.optBoolean("enabled")) {
            val muxSettings = JSONObject().put("enabled", true)
            putOptional(muxSettings, "concurrency", mux.optInt("concurrency"))
            putOptional(muxSettings, "xudpConcurrency", mux.optInt("xudpConcurrency"))
            putOptional(muxSettings, "xudpProxyUDP443", mux.opt("xudpProxyUDP443"))
            outbound.put("mux", muxSettings)
        }
        return outbound
    }

    private fun vlessGrpc(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val grpc = server.raw.getJSONObject("grpc")
        val user = JSONObject()
            .put("id", grpc.optString("uuid"))
            .put("encryption", "none")
        val stream = JSONObject()
            .put("network", "grpc")
            .put("security", "reality")
            .put(
                "grpcSettings",
                JSONObject()
                    .put("serviceName", grpc.optString("serviceName"))
                    .put("multiMode", true)
                    .put("multi_connections", grpc.optInt("multiConnections"))
            )
            .put(
                "realitySettings",
                reality(
                    server.tlsServerName,
                    grpc.optString("fingerprint"),
                    grpc.optString("publicKey"),
                    grpc.optString("shortId"),
                    "",
                    ""
                )
            )
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "vless")
            .put("settings", vlessSettings(server, user))
            .put("streamSettings", stream)
    }

    private fun vlessRaw(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val raw = server.raw.getJSONObject("raw")
        val user = JSONObject()
            .put("id", raw.optString("uuid"))
            .put("encryption", "none")
            .put("flow", "xtls-rprx-vision")
        val stream = JSONObject()
            .put("network", "raw")
            .put("security", "reality")
            .put(
                "realitySettings",
                reality(
                    server.tlsServerName,
                    raw.optString("fingerprint"),
                    raw.optString("publicKey"),
                    raw.optString("shortId"),
                    "",
                    ""
                )
            )
            .put(
                "sockopt",
                JSONObject()
                    .put("tcpKeepAliveIdle", 30)
                    .put("tcpKeepAliveInterval", 15)
            )
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "vless")
            .put("settings", vlessSettings(server, user))
            .put("streamSettings", stream)
    }

    private fun vlessXhttp(server: MamiCatalogCore.Server, tag: String): JSONObject {
        val xhttp = server.raw.getJSONObject("xhttp")
        val security = xhttp.optString("security")
        val stream = JSONObject()
            .put("network", "xhttp")
            .put("security", security)
            .put("xhttpSettings", xhttpSettings(xhttp))
        if (security == "reality") {
            stream.put(
                "realitySettings",
                reality(
                    server.tlsServerName,
                    FP,
                    xhttp.optString("publicKey"),
                    xhttp.optString("shortId"),
                    "",
                    ""
                )
            )
        } else {
            stream.put(
                "tlsSettings",
                JSONObject()
                    .put("serverName", server.tlsServerName)
                    .put("fingerprint", FP)
                    .put("alpn", JSONArray().put("h2"))
            )
        }
        val user = JSONObject()
            .put("id", xhttp.optString("uuid"))
            .put("encryption", xhttp.optString("encryption"))
        return JSONObject()
            .put("tag", tag)
            .put("protocol", "vless")
            .put("settings", vlessSettings(server, user))
            .put("streamSettings", stream)
    }

    private fun reality(
        serverName: String,
        fingerprint: String,
        publicKey: String,
        shortId: String,
        spiderX: String,
        mldsa65Verify: String
    ): JSONObject {
        val settings = JSONObject()
            .put("serverName", serverName)
            .put("fingerprint", fingerprint.ifBlank { FP })
            .put("publicKey", publicKey)
            .put("shortId", shortId)
        putOptional(settings, "spiderX", spiderX)
        putOptional(settings, "mldsa65Verify", mldsa65Verify)
        return settings
    }

    private fun xhttpSettings(raw: JSONObject): JSONObject {
        val settings = JSONObject()
            .put("path", raw.optString("path"))
            .put("mode", raw.optString("mode").ifBlank { "auto" })
        putOptional(settings, "host", raw.optString("host"))
        putOptional(settings, "xPaddingBytes", raw.optString("paddingBytes"))
        putOptional(settings, "sessionIDLength", raw.optString("sessionIDLength"))
        putOptional(settings, "sessionIDTable", raw.optString("sessionIDTable"))
        putOptional(settings, "scMaxEachPostBytes", raw.optString("maxPostBytes"))
        putOptional(settings, "scMinPostsIntervalMs", raw.optString("minPostInterval"))
        val xmux = raw.optJSONObject("xmux")
        if (xmux != null) {
            val options = JSONObject()
            putOptional(options, "maxConcurrency", xmux.optInt("maxConcurrency"))
            putOptional(options, "maxConnections", xmux.optInt("maxConnections"))
            putOptional(options, "cMaxReuseTimes", xmux.optInt("cMaxReuseTimes"))
            putOptional(options, "hMaxRequestTimes", xmux.optInt("hMaxRequestTimes"))
            putOptional(options, "hMaxReusableSecs", xmux.optInt("hMaxReusableSecs"))
            putOptional(options, "hKeepAlivePeriod", xmux.optInt("hKeepAlivePeriod"))
            if (options.length() > 0) settings.put("xmux", options)
        }
        return settings
    }

    private fun hexOfPin(value: String): String {
        val bytes = Base64.decode(value, Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING)
        return bytes.joinToString("") { "%02x".format(it.toInt() and 0xff) }
    }

    private fun putOptional(target: JSONObject, key: String, value: Any?) {
        if (value == null || value === JSONObject.NULL || value == "" || value == false || (value is Number && value.toDouble() == 0.0)) return
        target.put(key, value)
    }

    companion object {
        const val TAG = "mami-vpn"
        const val FP = "chrome"
    }
}
