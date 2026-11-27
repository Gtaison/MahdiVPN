package com.mlmvpn.scanner.engines.argo

import android.content.Context
import android.content.Intent
import android.util.Log
import com.mlmvpn.scanner.MyVpnService
import com.mlmvpn.scanner.utils.ConnectionOwner
import com.mlmvpn.scanner.utils.LocalPort
import com.mlmvpn.scanner.utils.NetworkSettings
import com.mlmvpn.scanner.utils.SafeStart
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.net.ssl.HttpsURLConnection

/**
 * Argo's source-level Xray engine.
 *
 * "Connected" is published only after the service reports this node id AND a real HTTPS trace
 * succeeds through the local SOCKS inbound. Authentication or a running Xray process alone is
 * not considered a successful connection.
 */
object ArgoEngine {
    const val NODE_ID = "argo"
    private const val TAG = "ARGO"
    private const val TRACE_URL = "https://www.cloudflare.com/cdn-cgi/trace"

    enum class Mode { TUNNEL, PROXY }
    enum class Phase { IDLE, REFRESHING, AUTHENTICATING, STARTING, VERIFYING, CONNECTED, FAILED, STOPPING }
    enum class Step { POOL, AUTH, TUNNEL, TRAFFIC }

    data class PoolStats(
        val total: Int,
        val bridges: Int,
        val publicServers: Int,
        val falcons: Int,
        val falconOrigins: Int
    )

    data class State(
        val phase: Phase = Phase.IDLE,
        val step: Step? = null,
        val host: String? = null,
        val kind: String? = null,
        val exitCountry: String? = null,
        val exitIp: String? = null,
        val latencyMs: Long? = null,
        val mode: Mode? = null,
        val message: String? = null
    ) {
        val connected: Boolean get() = phase == Phase.CONNECTED
        val busy: Boolean get() = phase in setOf(Phase.REFRESHING, Phase.AUTHENTICATING, Phase.STARTING, Phase.VERIFYING, Phase.STOPPING)
    }

    private data class Live(
        val endpoint: ArgoProtocolCore.Endpoint,
        val session: ArgoProtocolCore.SessionInfo,
        val config: String,
        val mode: Mode
    )

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val owner = ConnectionOwner()
    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()
    private val _logs = MutableStateFlow<List<String>>(emptyList())
    val logs: StateFlow<List<String>> = _logs.asStateFlow()

    private val authClient = OkHttpClient.Builder()
        .connectTimeout(9, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .callTimeout(16, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build()

    @Volatile private var app: Context? = null
    @Volatile private var pool: ArgoPoolRepository? = null
    @Volatile private var connectJob: Job? = null
    @Volatile private var wantConnected = false
    @Volatile private var live: Live? = null

    @Synchronized
    fun init(context: Context) {
        if (app != null) return
        val application = context.applicationContext
        app = application
        pool = ArgoPoolRepository(application)
    }

    fun isOurs(): Boolean =
        MyVpnService.connectedNodeIdFlow.value == NODE_ID &&
            MyVpnService.connectionPhaseFlow.value != MyVpnService.Phase.IDLE

    fun connectAsync(
        context: Context,
        selectedId: String? = null,
        rawConfig: String? = null,
        mode: Mode? = null
    ): Job = owner.replace(null) {
        init(context)
        val previous = connectJob
        previous?.cancel()
        scope.launch {
            previous?.join()
            currentCoroutineContext().ensureActive()
            wantConnected = true
            val chosenMode = mode ?: if (NetworkSettings.proxyMode(app!!)) Mode.PROXY else Mode.TUNNEL
            live = null
            _state.value = State(phase = Phase.REFRESHING, step = Step.POOL, mode = chosenMode)
            try {
                connect(selectedId, rawConfig, chosenMode)
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (failure: Throwable) {
                Log.w(TAG, "connect failed", failure)
                if (wantConnected) fail(failure.message ?: "اتصال آرگو ناموفق بود")
            }
        }.also { connectJob = it }
    }

    fun disconnectAsync(context: Context) {
        owner.stop(null) {
            init(context)
            wantConnected = false
            connectJob?.cancel()
            live = null
            _state.value = State(phase = Phase.STOPPING)
            stopService()
            _state.value = State()
        }
    }

    fun freshConfig(context: Context): String? {
        init(context)
        return live?.config
    }

    fun poolStats(context: Context): PoolStats {
        init(context)
        val repository = pool ?: return PoolStats(0, 0, 0, 0, 0)
        val items = repository.allItems()
        return PoolStats(
            total = items.size,
            bridges = items.count { it.kind == "bridge" },
            publicServers = items.count { it.kind == "public" },
            falcons = items.count { it.kind == "falcon" },
            falconOrigins = repository.falconOrigins().size
        )
    }

    fun refreshAsync(context: Context): Job {
        init(context)
        return scope.launch {
            val before = _state.value
            if (!before.connected) {
                _state.value = State(phase = Phase.REFRESHING, step = Step.POOL, message = "به‌روزرسانی منابع آرگو")
            }
            try {
                val result = (pool ?: error("Argo pool is not initialized")).refresh { log(it) }
                log("منابع به‌روز شدند: ${result.added} مورد تازه")
                if (!before.connected) {
                    _state.value = State(
                        phase = Phase.IDLE,
                        message = "به‌روزرسانی انجام شد؛ ${result.added} مورد تازه"
                    )
                }
            } catch (failure: Throwable) {
                if (!before.connected) {
                    _state.value = State(phase = Phase.FAILED, message = failure.message ?: "به‌روزرسانی ناموفق بود")
                }
                log("به‌روزرسانی منابع ناموفق بود: ${failure.message}")
            }
        }
    }

    fun log(message: String) {
        val line = "[${System.currentTimeMillis()}] $message"
        Log.i(TAG, message)
        _logs.value = (_logs.value + line).takeLast(250)
    }

    private suspend fun connect(selectedId: String?, rawConfig: String?, mode: Mode) {
        val repository = pool ?: error("Argo pool is not initialized")
        var candidates = when {
            !rawConfig.isNullOrBlank() -> listOf(repository.endpointFromRaw(rawConfig))
            !selectedId.isNullOrBlank() -> repository.allItems()
                .firstOrNull { it.id == selectedId }
                ?.let { listOf(ArgoProtocolCore.Endpoint(it.id, it.kind, it.host, it.port, it.protocol)) }
                ?: throw IllegalArgumentException("این سرور در فهرست آرگو وجود ندارد")
            else -> repository.candidates(5)
        }

        if (candidates.isEmpty()) {
            _state.value = State(phase = Phase.REFRESHING, step = Step.POOL, mode = mode, message = "به‌روزرسانی منابع آرگو")
            val result = repository.refresh { log(it) }
            log("به‌روزرسانی تمام شد؛ ${result.added} مورد تازه")
            candidates = repository.candidates(8)
        }
        if (candidates.isEmpty()) {
            fail("سرور تازه و معتبر پیدا نشد؛ اتصال اینترنت و منابع آرگو را بررسی کنید")
            return
        }

        var lastError = "هیچ سروری پاسخ نداد"
        for ((index, endpoint) in candidates.withIndex()) {
            if (!wantConnected) return
            val cleanIps = if (endpoint.kind == "falcon") {
                repository.falconOrigins().sortedBy { it.load }.take(3).map { it.ip }.distinct() + listOf("")
            } else listOf("")
            for (connectIp in cleanIps.distinct()) {
                if (!wantConnected) return
                _state.value = State(
                    phase = Phase.AUTHENTICATING, step = Step.AUTH,
                    host = endpoint.host, kind = endpoint.kind, mode = mode,
                    message = "احراز هویت با سرور ${index + 1}/${candidates.size}"
                )
                try {
                    val session = authenticate(endpoint, connectIp)
                    val config = buildConfig(endpoint, session, connectIp)
                    live = Live(endpoint, session, config, mode)
                    _state.value = State(
                        phase = Phase.STARTING, step = Step.TUNNEL,
                        host = endpoint.host, kind = endpoint.kind, mode = mode
                    )
                    if (!launch(config, mode)) {
                        lastError = if (MyVpnService.connectionPhaseFlow.value == MyVpnService.Phase.FAILED) {
                            "اندروید اجازهٔ VPN نداد یا سرویس Xray بالا نیامد"
                        } else {
                            "موتور Xray بالا نیامد"
                        }
                        stopService()
                        log("${endpoint.host}: $lastError")
                        continue
                    }

                    _state.value = State(
                        phase = Phase.VERIFYING, step = Step.TRAFFIC,
                        host = endpoint.host, kind = endpoint.kind, mode = mode
                    )
                    var trace: Triple<String, String, Long>? = null
                    for (attempt in 0 until 3) {
                        trace = traceThroughSocks()
                        if (trace != null) break
                        if (attempt < 2) delay(1_200)
                    }
                    if (trace != null && trace!!.second.isNotBlank()) {
                        _state.value = State(
                            phase = Phase.CONNECTED, host = endpoint.host, kind = endpoint.kind,
                            exitCountry = trace!!.first, exitIp = trace!!.second,
                            latencyMs = trace!!.third, mode = mode
                        )
                        log("اتصال واقعی برقرار شد؛ خروجی ${trace!!.first} / ${trace!!.second}")
                        return
                    }
                    lastError = "موتور بالا آمد ولی ترافیکی از تونل عبور نکرد"
                    log("${endpoint.host}: $lastError")
                    stopService()
                } catch (cancelled: CancellationException) {
                    throw cancelled
                } catch (failure: Throwable) {
                    lastError = failure.message ?: "احراز هویت یا اتصال ناموفق بود"
                    log("${endpoint.host}: $lastError")
                    stopService()
                }
            }
        }
        if (wantConnected) fail(lastError)
    }

    private suspend fun authenticate(
        endpoint: ArgoProtocolCore.Endpoint,
        connectIp: String
    ): ArgoProtocolCore.SessionInfo = withContext(Dispatchers.IO) {
        val started = System.currentTimeMillis()
        val requestData = ArgoProtocolCore.authRequest(endpoint.protocol, started)
        val portPart = if (endpoint.port == 443) "" else ":${endpoint.port}"
        val request = Request.Builder()
            .url("https://${endpoint.host}$portPart/")
            .header("Authorization", requestData.header)
            .header("User-Agent", "okhttp/4.12.0")
            .header("Accept", "*/*")
            .get()
            .build()
        val client = if (connectIp.isBlank()) authClient else authClient.newBuilder()
            .dns(object : Dns {
                override fun lookup(hostname: String): List<InetAddress> =
                    if (hostname.equals(endpoint.host, ignoreCase = true)) {
                        listOf(InetAddress.getByName(connectIp))
                    } else Dns.SYSTEM.lookup(hostname)
            })
            .build()
        client.newCall(request).execute().use { response ->
            val body = response.body?.string().orEmpty()
            require(body.toByteArray().size <= 65_536) { "پاسخ احراز هویت بیش از اندازه بزرگ است" }
            require(response.isSuccessful) {
                when (response.code) {
                    401, 403 -> "سرور درخواست احراز هویت را نپذیرفت"
                    404 -> "این دامنه سرور آرگو نیست"
                    521, 522, 523, 530 -> "سرور پشت دامنه در دسترس نیست"
                    else -> "پاسخ نامعتبر سرور (HTTP ${response.code})"
                }
            }
            val offset = response.header("Date")?.let { date ->
                runCatching {
                    ZonedDateTime.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME).toEpochSecond() -
                        System.currentTimeMillis() / 1000L
                }.getOrNull()
            } ?: 0L
            ArgoProtocolCore.openAnswer(requestData, body, offset)
        }
    }

    private fun buildConfig(
        endpoint: ArgoProtocolCore.Endpoint,
        session: ArgoProtocolCore.SessionInfo,
        connectIp: String = ""
    ): String {
        val context = app ?: error("Argo is not initialized")
        val port = LocalPort.get(context)
        val socksSettings = JSONObject()
            .put("auth", "noauth")
            .put("udp", true)
        val socksSniffing = JSONObject()
            .put("enabled", true)
            .put("destOverride", JSONArray().put("http").put("tls"))
        val socks = JSONObject()
            .put("tag", "socks")
            .put("listen", "127.0.0.1")
            .put("port", port)
            .put("protocol", "mixed")
            .put("settings", socksSettings)
            .put("sniffing", socksSniffing)
        val http = JSONObject()
            .put("tag", "http")
            .put("listen", "127.0.0.1")
            .put("port", port + LocalPort.PROBE_OFFSET)
            .put("protocol", "http")
            .put("settings", JSONObject())

        val outbounds = JSONArray()
            .put(ArgoProtocolCore.xrayOutbound(endpoint, session, "argo", connectIp))
            .put(JSONObject().put("tag", "direct").put("protocol", "freedom").put("settings", JSONObject()))
            .put(JSONObject().put("tag", "dns-out").put("protocol", "dns").put("settings", JSONObject()))
            .put(JSONObject().put("tag", "blocked").put("protocol", "blackhole").put("settings", JSONObject()))

        val rules = JSONArray()
            .put(JSONObject().put("type", "field").put("port", "53").put("outboundTag", "dns-out"))
            .put(JSONObject().put("type", "field").put("inboundTag", JSONArray().put("argo-dns")).put("outboundTag", "argo"))
            .put(
                JSONObject()
                    .put("type", "field")
                    .put("ip", JSONArray().put("geoip:private"))
                    .put("outboundTag", "direct")
            )
            .put(
                JSONObject()
                    .put("type", "field")
                    .put("network", "udp")
                    .put("port", "443")
                    .put("outboundTag", "blocked")
            )
        val dns = JSONObject()
            .put("tag", "argo-dns")
            .put(
                "servers",
                JSONArray()
                    .put(JSONObject().put("address", "https://8.8.8.8/dns-query"))
                    .put(JSONObject().put("address", "https://1.1.1.1/dns-query"))
            )
            .put("queryStrategy", "UseIPv4")
        val root = JSONObject()
            .put("remarks", "Argo")
            .put("log", JSONObject().put("loglevel", "warning"))
            .put("inbounds", JSONArray().put(socks).put(http))
            .put("outbounds", outbounds)
            .put("dns", dns)
            .put("routing", JSONObject().put("domainStrategy", "AsIs").put("rules", rules))
        return root.toString()
    }

    private suspend fun launch(config: String, mode: Mode): Boolean {
        currentCoroutineContext().ensureActive()
        val context = app ?: return false
        val wasUp = MyVpnService.connectionPhaseFlow.value == MyVpnService.Phase.CONNECTED
        withContext(Dispatchers.IO) {
            com.mlmvpn.scanner.ui.tunnel.TunnelExclusion.releaseForXray(context)
        }
        SafeStart.service(context, Intent(context, MyVpnService::class.java).apply {
            putExtra("NODE_URI", config)
            putExtra("MTU_PROFILE", NetworkSettings.Method.V2RAY.id)
            putExtra("NODE_ID", NODE_ID)
            putExtra("PROXY_MODE", mode == Mode.PROXY)
            putExtra("LOCAL_PORT", LocalPort.getString(context))
        })
        if (wasUp) {
            withTimeoutOrNull(5_000) {
                MyVpnService.connectionPhaseFlow.first { it != MyVpnService.Phase.CONNECTED }
            }
        }
        var sawConnecting = false
        val phase = withTimeoutOrNull(18_000) {
            MyVpnService.connectionPhaseFlow.first { value ->
                if (value == MyVpnService.Phase.CONNECTING) sawConnecting = true
                (value == MyVpnService.Phase.CONNECTED && MyVpnService.connectedNodeIdFlow.value == NODE_ID) ||
                    (sawConnecting && (value == MyVpnService.Phase.IDLE || value == MyVpnService.Phase.FAILED))
            }
        }
        return phase == MyVpnService.Phase.CONNECTED && MyVpnService.connectedNodeIdFlow.value == NODE_ID
    }

    private suspend fun traceThroughSocks(): Triple<String, String, Long>? = withContext(Dispatchers.IO) {
        val context = app ?: return@withContext null
        val proxy = Proxy(
            Proxy.Type.SOCKS,
            InetSocketAddress("127.0.0.1", LocalPort.get(context))
        )
        runCatching {
            val start = System.nanoTime()
            val connection = (URL(TRACE_URL).openConnection(proxy) as HttpsURLConnection).apply {
                connectTimeout = 8_000
                readTimeout = 8_000
                instanceFollowRedirects = false
            }
            val body = connection.inputStream.bufferedReader().use { it.readText().take(32_768) }
            connection.disconnect()
            val country = Regex("(?m)^loc=([A-Z]{2})").find(body)?.groupValues?.get(1).orEmpty()
            val ip = Regex("(?m)^ip=(\\S+)").find(body)?.groupValues?.get(1).orEmpty()
            val elapsed = (System.nanoTime() - start) / 1_000_000L
            if (country.isBlank() || ip.isBlank()) null else Triple(country, ip, elapsed)
        }.getOrNull()
    }

    private fun stopService() {
        val context = app ?: return
        if (MyVpnService.connectedNodeIdFlow.value == NODE_ID) {
            SafeStart.service(context, Intent(context, MyVpnService::class.java).apply { action = "STOP" })
        }
    }

    private fun fail(message: String) {
        wantConnected = false
        live = null
        stopService()
        _state.value = State(phase = Phase.FAILED, message = message)
        log(message)
    }
}
