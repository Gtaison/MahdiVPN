package com.mlmvpn.scanner.engines.outline

import android.content.Context
import android.content.Intent
import android.util.Log
import com.mlmvpn.scanner.MyVpnService
import com.mlmvpn.scanner.data.CombineEngine
import com.mlmvpn.scanner.engines.flux.FluxNet
import com.mlmvpn.scanner.engines.freeconfig.FreeConfigEngine
import com.mlmvpn.scanner.utils.LocalPort
import com.mlmvpn.scanner.utils.NetworkSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.Socket
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

/**
 * «Outline»: Outline VPN access keys -- free public Shadowsocks servers and the user's own keys --
 * tested on this line, fastest first, connected in one tap.
 *
 *  - Lists: Shadowmere's keys and public GitHub lists rebuilt hourly or better ([OutlineSources]),
 *    refreshed while the screen is open and they are due, tested only when the user asks; deleted
 *    servers stay out ([OutlineBrain.TOMBSTONE_MS]). Shadowmere is filtered in Iran: the APK carries
 *    its keys, and they are refreshed only through one of the app's tunnels -- by themselves when
 *    Outline connects ([Trigger.CONNECT]); a refresh the user asks for with no tunnel up says so.
 *  - Test: a TCP knock on every server first (cheap, and most dead ones fail it), then a real
 *    request through each one that answered, in the in-process core -- the same measurement the
 *    rest of the app uses ([CombineEngine.measureUri]). Results are per network.
 *  - Connect: the key goes to [MyVpnService] as a plain `ss://` link, so the tunnel is built by the
 *    same code as every other config: per-app split tunnelling, Local Network sharing (listener,
 *    password, blocked devices), proxy mode and the Smart Iran route all apply unchanged.
 *    "Connected" only after a real request went through; a server that carries nothing is replaced
 *    by the next fastest, up to three.
 */
object OutlineEngine {

    private const val TAG = "Outline"
    const val NODE_ID = "outline"
    private const val UNDO_MS = 6_000L
    private const val TCP_TIMEOUT_MS = 3_000
    private const val TCP_WORKERS = 64
    private const val REAL_TIMEOUT_MS = 8_000
    /**
     */
    private const val SPEED_URL = "https://speed.cloudflare.com/__down?bytes=3000000"

    private lateinit var app: Context
    lateinit var store: OutlineStore
        private set
    private lateinit var repo: OutlineSourceRepo
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    @Volatile private var initialized = false

    private val _connect = MutableStateFlow<OutlineConnect>(OutlineConnect.Idle)
    val connect: StateFlow<OutlineConnect> = _connect

    private val _progress = MutableStateFlow(OutlineTestProgress())
    val progress: StateFlow<OutlineTestProgress> = _progress

    private val _pending = MutableStateFlow<Set<String>>(emptySet())
    val pending: StateFlow<Set<String>> = _pending

    private val _refreshing = MutableStateFlow(false)
    val refreshing: StateFlow<Boolean> = _refreshing

    private val _net = MutableStateFlow("unknown")
    val net: StateFlow<String> = _net

    /** A speed sample of the connected server, in bits per second; null while none was taken. */
    private val _speed = MutableStateFlow<SpeedState>(SpeedState.None)
    val speed: StateFlow<SpeedState> = _speed

    sealed class SpeedState {
        object None : SpeedState()
        object Running : SpeedState()
        data class Done(val bps: Long) : SpeedState()
        object Failed : SpeedState()
    }

    private val _notice = MutableStateFlow<Notice?>(null)
    val notice: StateFlow<Notice?> = _notice

    sealed class Notice {
        data class Imported(val count: Int) : Notice()
        object ImportFailed : Notice()
        data class Refreshed(val added: Int) : Notice()
        object RefreshFailed : Notice()
        object Offline : Notice()
        data class Removed(val count: Int) : Notice()
        /** The user asked for a refresh with no tunnel up: Shadowmere is reached only through one. */
        data class NeedTunnel(val added: Int) : Notice()
        /** A tunnel was up and Shadowmere still did not answer through it. */
        data class ShadowmereFailed(val added: Int) : Notice()
    }

    /** Who asked for a refresh: what it fetches and what it tells the user. */
    enum class Trigger {
        /** The user: every list, and a word about Shadowmere when it could not be reached. */
        USER,
        /** The page, open or still open: the lists that are due. */
        PAGE,
        /** Outline just connected: Shadowmere through its tunnel, when due, without a word. */
        CONNECT,
    }

    fun consumeNotice() { _notice.value = null }

    @Volatile private var testJob: Job? = null
    @Volatile private var connectJob: Job? = null
    @Volatile private var wantConnected = false

    @Synchronized
    fun init(context: Context) {
        if (initialized) return
        app = context.applicationContext
        store = OutlineStore(app.filesDir)
        repo = OutlineSourceRepo(app)
        // Shadowmere is filtered here: a fresh install (or an update with a newer copy) starts with
        // the keys it listed when the app was built, before or without a fetch through a tunnel.
        repo.shadowmereSeed(System.currentTimeMillis())?.let { seed ->
            store.update { OutlineBrain.merge(it, seed, System.currentTimeMillis()) }
            Log.i(TAG, "shadowmere: ${seed.size} keys from the APK")
        }
        _net.value = FluxNet.current(app).key
        observeSession()
        initialized = true
    }

    fun isInitialized() = initialized

    /** Another engine took the VPN, or it went down from outside: stop claiming a connection. */
    private fun observeSession() {
        scope.launch {
            combine(MyVpnService.connectionPhaseFlow, MyVpnService.connectedNodeIdFlow) { phase, id ->
                phase != MyVpnService.Phase.IDLE && id == NODE_ID
            }.collect { ours ->
                if (!ours && _connect.value is OutlineConnect.Connected) {
                    _connect.value = OutlineConnect.Idle
                    _speed.value = SpeedState.None
                    wantConnected = false
                    launch(Dispatchers.IO) { stopLeg() }
                }
            }
        }
    }

    /**
     * The page opened, or is still open (the screen asks again every few minutes). The lists are
     * fetched when they are due -- Shadowmere every hour, as soon as its hourly check is out -- but
     * nothing is ever tested unless the user asks: opening the page used to start a test of up to 80
     * public servers by itself, on the user's data, every half hour (user report, 2026-10-17), and
     * Shadowmere's new keys are not pinged by themselves either (user, 2026-10-25: «پینگ خودکار
     * نباشه به هیچ عنوان»).
     */
    fun onOpen(context: Context) {
        init(context)
        _net.value = FluxNet.current(app).key
        val s = store.current
        val now = System.currentTimeMillis()
        val tunnelUp = com.mlmvpn.scanner.lan.LanShare.isTunnelUp(app)
        if (s.servers.isEmpty() || repo.anyDue(s.prefs.disabledSources, now, tunnelUp)) refresh(force = s.lastRefreshAt == 0L, by = Trigger.PAGE)
    }

    // ---------------------------------------------------------------- lists

    fun refresh(force: Boolean = true, by: Trigger = Trigger.USER) {
        if (_refreshing.value) return
        if (by == Trigger.CONNECT) {
            val src = OutlineSources.byId(OutlineSources.SHADOWMERE) ?: return
            if (src.id in store.current.prefs.disabledSources || !repo.due(src, System.currentTimeMillis())) return
        }
        _refreshing.value = true
        scope.launch {
            try {
                val now = System.currentTimeMillis()
                val disabled = store.current.prefs.disabledSources
                // Any tile's tunnel will do: Outline, V2Ray, WireGuard, WARP, Tor...
                val tunnelUp = com.mlmvpn.scanner.lan.LanShare.isTunnelUp(app)
                val only = if (by == Trigger.CONNECT) setOf(OutlineSources.SHADOWMERE) else null
                val fetched = withContext(Dispatchers.IO) { repo.refresh(force, disabled, tunnelPort(), now, tunnelUp, only) }
                val before = store.current.servers.map { it.id }.toHashSet()
                // Most trusted lists first, so a server in several keeps the best list as its source.
                val incoming = fetched.sortedByDescending { it.source.prior }.flatMap { it.batch.servers }
                // A connect's fetch that brought nothing leaves the pool and its refresh time alone.
                if (fetched.isNotEmpty() || by != Trigger.CONNECT) store.update { s ->
                    val merged = OutlineBrain.merge(s, incoming, now)
                    merged.copy(lastRefreshAt = if (fetched.isNotEmpty() || s.servers.isNotEmpty()) now else s.lastRefreshAt)
                }
                val added = store.current.servers.count { it.id !in before }
                Log.i(TAG, "refresh: ${fetched.size} sources answered, pool ${store.current.servers.size} (+$added)")
                val wantShadowmere = OutlineSources.SHADOWMERE !in disabled
                val gotShadowmere = fetched.any { it.source.id == OutlineSources.SHADOWMERE }
                if (by != Trigger.CONNECT) _notice.value = when {
                    by == Trigger.USER && wantShadowmere && !tunnelUp -> Notice.NeedTunnel(added)
                    by == Trigger.USER && wantShadowmere && !gotShadowmere -> Notice.ShadowmereFailed(added)
                    fetched.isEmpty() && store.current.servers.isEmpty() -> Notice.RefreshFailed
                    else -> Notice.Refreshed(added)
                }
            } catch (e: Exception) {
                Log.w(TAG, "refresh failed", e)
                if (by != Trigger.CONNECT) _notice.value = Notice.RefreshFailed
            } finally {
                _refreshing.value = false
            }
        }
    }

    fun sourceInfo(id: String): Pair<Long, Int> = repo.lastOk(id) to repo.lastCount(id)

    fun setSourceEnabled(id: String, on: Boolean) = setPrefs { p ->
        p.copy(disabledSources = if (on) p.disabledSources - id else p.disabledSources + id)
    }

    fun setPrefs(change: (OutlinePrefs) -> OutlinePrefs) { store.update { it.copy(prefs = change(it.prefs)) } }

    /** Pasted or scanned text: any number of `ss://` and `ssconf://` keys. */
    fun importText(context: Context, text: String) {
        init(context)
        scope.launch(Dispatchers.IO) {
            val now = System.currentTimeMillis()
            val keys = OutlineParser.keysIn(text)
            val servers = keys.mapNotNull { k ->
                if (k.startsWith("ssconf://", ignoreCase = true)) {
                    val (url, name) = OutlineParser.ssconfUrl(k) ?: return@mapNotNull null
                    val body = repo.fetchSsconf(url, tunnelPort()) ?: return@mapNotNull null
                    OutlineParser.parseSsconfBody(body, k, now, name)
                } else OutlineParser.parse(k, OutlineServer.USER_SOURCE, now)
            }.distinctBy { it.id }
            if (servers.isEmpty()) { _notice.value = Notice.ImportFailed; return@launch }
            // A key the user adds is theirs even if it was deleted from a list before.
            store.update { s ->
                val ids = servers.map { it.id }.toHashSet()
                OutlineBrain.merge(s.copy(tombstones = s.tombstones - ids, servers = s.servers.filter { it.id !in ids }), servers, now)
            }
            _notice.value = Notice.Imported(servers.size)
            testIds(servers.map { it.id })
        }
    }

    fun toggleFavorite(id: String) = store.update { s ->
        s.copy(favorites = if (id in s.favorites) s.favorites - id else s.favorites + id)
    }

    // ---------------------------------------------------------------- deleting, with undo

    private data class Removed(val servers: List<OutlineServer>, val stats: Map<String, Map<String, OutlineStat>>, val favs: Set<String>)
    @Volatile private var lastRemoved: Removed? = null
    private val _undoCount = MutableStateFlow(0)
    /** How many servers the last deletion removed while it can still be undone; 0 when it cannot. */
    val undoCount: StateFlow<Int> = _undoCount
    private var undoTimer: Job? = null

    fun delete(ids: Collection<String>) {
        if (ids.isEmpty()) return
        val set = ids.toHashSet()
        val cur = store.current
        val gone = cur.servers.filter { it.id in set }
        if (gone.isEmpty()) return
        lastRemoved = Removed(gone, cur.stats.mapValues { (_, m) -> m.filterKeys { it in set } }, cur.favorites.intersect(set))
        store.update { OutlineBrain.remove(it, set, System.currentTimeMillis()) }
        _undoCount.value = gone.size
        undoTimer?.cancel()
        undoTimer = scope.launch { delay(UNDO_MS); _undoCount.value = 0; lastRemoved = null }
    }

    fun undoDelete() {
        val r = lastRemoved ?: return
        lastRemoved = null
        undoTimer?.cancel()
        _undoCount.value = 0
        val ids = r.servers.mapTo(HashSet()) { it.id }
        store.update { s ->
            val present = s.servers.mapTo(HashSet()) { it.id }
            s.copy(
                servers = s.servers + r.servers.filter { it.id !in present },
                stats = (s.stats.keys + r.stats.keys).associateWith { net -> (s.stats[net] ?: emptyMap()) + (r.stats[net] ?: emptyMap()) },
                tombstones = s.tombstones - ids,
                favorites = s.favorites + r.favs,
            )
        }
    }

    fun removeDead() {
        val ids = OutlineBrain.deadIds(store.current, _net.value)
        delete(ids)
        _notice.value = Notice.Removed(ids.size)
    }

    // ---------------------------------------------------------------- delay tests

    /**
     * [all]: every server; otherwise favourites, the ones that worked here, Shadowmere's current keys
     * and the most promising. [country] or [source]: every server of that country or that list.
     */
    fun test(all: Boolean, country: String? = null, source: String? = null) {
        val net = FluxNet.current(app).key.also { _net.value = it }
        val picked = OutlineBrain.pickForTest(store.current, net, all = all || country != null || source != null)
            .filter { country == null || OutlineBrain.group(it) == country }
            .filter { source == null || it.sourceId == source }
        start(picked, net)
    }

    fun testOne(id: String) = testIds(listOf(id))

    private fun testIds(ids: List<String>) {
        val set = ids.toHashSet()
        val net = FluxNet.current(app).key.also { _net.value = it }
        start(store.current.servers.filter { it.id in set }, net)
    }

    fun stopTest() { testJob?.cancel() }

    /**
     * One test of [servers], in two passes, every server counted the moment its pass decides it.
     *
     *  1. Straight from this line: a TCP knock on every server, many at once, and each one that
     *     answers goes into a real request through it in the `:xprobe` process (OutlineProbe) right
     *     away -- not after the whole list was knocked. A public server that panics Xray there ends
     *     that process, not the app (crash seen 2026-10-11).
     */
    private fun start(servers: List<OutlineServer>, net: String) {
        if (servers.isEmpty()) return
        testJob?.cancel()
        val previous = testJob
        testJob = scope.launch {
            previous?.join()
            _progress.value = OutlineTestProgress(running = true, total = servers.size, phaseStartedAt = System.currentTimeMillis())
            _pending.value = servers.mapTo(HashSet()) { it.id }
            val buffer = ConcurrentHashMap<String, OutlineBrain.Result>()
            val done = AtomicInteger()
            val alive = AtomicInteger()
            val flusher = launch { while (isActive) { delay(400); flush(buffer, net) } }
            // Both counters only ever grow: results arrive on many threads at once, and a plain
            // read-copy-write let a slower thread put an older count back.
            fun count(ok: Boolean) {
                val d = done.incrementAndGet()
                val a = if (ok) alive.incrementAndGet() else alive.get()
                _progress.update { p -> p.copy(done = maxOf(p.done, d), alive = maxOf(p.alive, a)) }
            }
            fun record(id: String, ms: Long?) {
                buffer[id] = OutlineBrain.Result(id, ms)
                _pending.update { it - id }
            }
            fun report(id: String, ms: Long?) { record(id, ms); count(ms != null) }
            try {
                if (!FluxNet.online(app)) { _notice.value = Notice.Offline; return@launch }
                FreeConfigEngine.ensureXrayEnv(app)
                        // Failed direct probes are retained as failures; no WARP fallback is attempted.
                val knockedClosed = AtomicInteger()
                val knockedOpen = AtomicInteger()
                val straightOk = AtomicInteger()
                coroutineScope {
                    fun failedStraight(id: String) { report(id, null) }
                    val open = Channel<OutlineServer>(Channel.UNLIMITED)
                    launch {
                        val gate = Semaphore(TCP_WORKERS)
                        coroutineScope {
                            // In list order: favourites and the ones that worked here are knocked first.
                            servers.forEach { s ->
                                launch(KNOCK) {
                                    gate.withPermit {
                                        if (tcpOpen(s.host, s.port)) { knockedOpen.incrementAndGet(); open.send(s) }
                                        else { knockedClosed.incrementAndGet(); failedStraight(s.id) }
                                    }
                                }
                            }
                        }
                        open.close()
                    }
                    OutlineProbe.testStream(app, open, REAL_TIMEOUT_MS) { id, ms ->
                        if (ms != null) { straightOk.incrementAndGet(); report(id, ms) } else failedStraight(id)
                    }
                    Log.i(TAG, "test: straight ${straightOk.get()} of ${servers.size} -- knock closed ${knockedClosed.get()}, " +
                        "open ${knockedOpen.get()} (of those, real request failed ${knockedOpen.get() - straightOk.get()})")

                }
                flusher.cancel()
                Log.i(TAG, "test: ${alive.get()} of ${servers.size} working (${straightOk.get()} direct)")
                // If the network went offline during the test, discard the results.
                if (alive.get() == 0 && servers.size >= 5 && !FluxNet.online(app)) {
                    buffer.clear()
                    _notice.value = Notice.Offline
                }
            } finally {
                flusher.cancel()
                withContext(NonCancellable) { flush(buffer, net) }
                _pending.value = emptySet()
                _progress.update { it.copy(running = false) }
            }
        }
    }

    /** The TCP knock's own threads: each connect blocks for up to [TCP_TIMEOUT_MS]. */
    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    private val KNOCK = Dispatchers.IO.limitedParallelism(TCP_WORKERS)

    private fun flush(buffer: ConcurrentHashMap<String, OutlineBrain.Result>, net: String) {
        if (buffer.isEmpty()) return
        val batch = buffer.keys.toList().mapNotNull { buffer.remove(it) }
        if (batch.isNotEmpty()) store.update { OutlineBrain.record(it, net, batch, System.currentTimeMillis()) }
    }

    private fun tcpOpen(host: String, port: Int): Boolean = runCatching {
        Socket(Proxy.NO_PROXY).use { it.connect(InetSocketAddress(host, port), TCP_TIMEOUT_MS) }
        true
    }.getOrDefault(false)

    // ---------------------------------------------------------------- connecting

    /** [serverId], or the fastest working server here when null. */
    fun connectAsync(context: Context, serverId: String? = null): Job {
        init(context)
        val previous = connectJob
        previous?.cancel()
        return scope.launch {
            previous?.join()
            kotlinx.coroutines.currentCoroutineContext().ensureActive()
            wantConnected = true
            _speed.value = SpeedState.None
            try { connectLoop(serverId) } catch (e: kotlinx.coroutines.CancellationException) { throw e } catch (e: Exception) {
                Log.w(TAG, "connect crashed", e)
                if (wantConnected) _connect.value = OutlineConnect.Failed(serverId, OutlineConnect.Reason.NO_DATA)
            }
        }.also { connectJob = it }
    }

    fun disconnectAsync(context: Context) {
        init(context)
        wantConnected = false
        connectJob?.cancel()
        _connect.value = OutlineConnect.Idle
        _speed.value = SpeedState.None
        stopService()

    }

    private suspend fun connectLoop(serverId: String?) {
        val net = FluxNet.current(app).key.also { _net.value = it }
        if (!FluxNet.online(app)) { _connect.value = OutlineConnect.Failed(serverId, OutlineConnect.Reason.OFFLINE); return }
        val tried = HashSet<String>()
        fun next(): OutlineServer? {
            val st = store.current
            return OutlineBrain.best(st, net, exclude = tried)
                ?: st.scoutWinners[net]?.takeIf { it !in tried }?.let { id -> st.servers.firstOrNull { it.id == id } }
                ?: st.lastConnectedId?.takeIf { it !in tried }?.let { id -> st.servers.firstOrNull { it.id == id } }
        }
        var server = serverId?.let { id -> store.current.servers.firstOrNull { it.id == id } } ?: next()
        if (server == null) {
            // Nothing tested yet: a quick test first, then the fastest it found.
            _connect.value = OutlineConnect.Connecting("", OutlineConnect.Step.PREPARING, 1)
            test(all = false)
            testJob?.join()
            server = next()
        }
        if (server == null) { _connect.value = OutlineConnect.Failed(null, OutlineConnect.Reason.NO_SERVERS); return }
        val maxAttempts = if (store.current.prefs.autoFallback) 3 else 1
        var connected = false
        try {
            connected = connectServers(server, maxAttempts, tried, net, ::next)
        } finally {
            // The leg stays only under a tunnel that rides it.
            if (!(connected && legInUse && wantConnected)) withContext(NonCancellable + Dispatchers.IO) { stopLeg() }
        }
    }

    /** True when one of them connected and carried a real request. */
    private suspend fun connectServers(
        first: OutlineServer, maxAttempts: Int, tried: HashSet<String>, net: String, next: () -> OutlineServer?,
    ): Boolean {
        var server: OutlineServer? = first
        var attempt = 1
        while (server != null && wantConnected) {
            tried += server.id
            val outcome = connectOne(server, attempt)
            if (!wantConnected) return false
            if (outcome == null) {
                store.update { it.copy(lastConnectedId = server!!.id) }
                return true
            }
            store.update { OutlineBrain.record(it, net, listOf(OutlineBrain.Result(server!!.id, null)), System.currentTimeMillis()) }
            if (outcome == OutlineConnect.Reason.VPN_REFUSED || attempt >= maxAttempts) {
                _connect.value = OutlineConnect.Failed(server.id, outcome)
                stopService()
                return false
            }
            attempt++
            server = next()
            if (server == null) {
                _connect.value = OutlineConnect.Failed(first.id, outcome)
                stopService()
            }
        }
        return false
    }

    /** Null when connected and a real request went through; otherwise why not. */
    private suspend fun connectOne(server: OutlineServer, attempt: Int): OutlineConnect.Reason? {
        _connect.value = OutlineConnect.Connecting(server.id, OutlineConnect.Step.PREPARING, attempt)
        withContext(Dispatchers.IO) { com.mlmvpn.scanner.ui.tunnel.TunnelExclusion.releaseForXray(app) }
        if (com.mlmvpn.scanner.utils.VpnConfig.parseUri(server.uri) == null) return OutlineConnect.Reason.BAD_CONFIG
        // Outline connects directly; no WARP fallback or proxy is involved.
        if (!wantConnected) return null
        _connect.value = OutlineConnect.Connecting(server.id, OutlineConnect.Step.STARTING, attempt)
        val up = startTunnel(server.uri)
        var rtt: Long? = null
        var reason: OutlineConnect.Reason = OutlineConnect.Reason.NO_DATA
        if (up) {
            _connect.value = OutlineConnect.Connecting(server.id, OutlineConnect.Step.VERIFYING, attempt)
            rtt = canary(attempts = 3)
        } else {
            reason = if (MyVpnService.connectionPhaseFlow.value == MyVpnService.Phase.FAILED) OutlineConnect.Reason.VPN_REFUSED else OutlineConnect.Reason.BAD_CONFIG
        }
        if (!wantConnected) return null
        if (rtt == null) return reason
        val since = System.currentTimeMillis()
        _connect.value = OutlineConnect.Connected(server.id, server.country, rtt, since)
        store.update { OutlineBrain.record(it, _net.value, listOf(OutlineBrain.Result(server.id, rtt)), since) }
        Log.i(TAG, "connected directly: $server in $rtt ms")
        // Shadowmere is filtered on the line: now that a tunnel is up, its newest keys come through it.
        refresh(force = false, by = Trigger.CONNECT)
        // Where it really exits, asked through the tunnel; the server moves to that country.
        scope.launch {
            val trace = exitTrace()
            if (trace != null) {
                val (ip, cc) = trace
                if (cc != null) store.update { s -> s.copy(servers = s.servers.map { if (it.id == server.id) it.copy(country = cc) else it }) }
                val st = _connect.value
                if (st is OutlineConnect.Connected && st.serverId == server.id) _connect.value = st.copy(country = cc ?: st.country, exitIp = ip)
            }
        }
        return null
    }

    private suspend fun startTunnel(uri: String): Boolean {
        kotlinx.coroutines.currentCoroutineContext().ensureActive()
        val wasUp = MyVpnService.connectionPhaseFlow.value == MyVpnService.Phase.CONNECTED
        // The same extras Quick Connect sends: a plain link, so MyVpnService builds the config with
        // the app's own settings (split tunnel, LAN sharing, proxy mode, Smart Iran route).
        com.mlmvpn.scanner.utils.SafeStart.service(app, Intent(app, MyVpnService::class.java).apply {
            putExtra("NODE_URI", uri)
            putExtra("NODE_ID", NODE_ID)
            putExtra("MTU_PROFILE", NetworkSettings.Method.OUTLINE.id)
            putExtra("PROXY_MODE", NetworkSettings.proxyMode(app))
            putExtra("LOCAL_PORT", LocalPort.getString(app))
        })
        if (wasUp) withTimeoutOrNull(5_000) { MyVpnService.connectionPhaseFlow.first { it != MyVpnService.Phase.CONNECTED } }
        var sawConnecting = false
        val phase = withTimeoutOrNull(30_000) {
            MyVpnService.connectionPhaseFlow.first { p ->
                if (p == MyVpnService.Phase.CONNECTING) sawConnecting = true
                (p == MyVpnService.Phase.CONNECTED && MyVpnService.connectedNodeIdFlow.value == NODE_ID) ||
                    (sawConnecting && (p == MyVpnService.Phase.IDLE || p == MyVpnService.Phase.FAILED))
            }
        }
        return phase == MyVpnService.Phase.CONNECTED
    }

    /**
     * An HTTP request through the tunnel's own local proxy (the app itself is outside its VPN). The
     * proxy is the "mixed" inbound on the Local Port, which needs the sharing password when Local
     * Network sharing has one -- sent, so a protected share never reads as a dead server.
     */
    private fun proxyRequest(target: String, host: String, timeoutMs: Int): Pair<Long, String>? = runCatching {
        val start = System.nanoTime()
        Socket(Proxy.NO_PROXY).use { s ->
            s.soTimeout = timeoutMs
            s.connect(InetSocketAddress("127.0.0.1", LocalPort.get(app)), 2_000)
            val auth = proxyAuth()?.let { "Proxy-Authorization: $it\r\n" }.orEmpty()
            s.getOutputStream().write("GET $target HTTP/1.1\r\nHost: $host\r\n${auth}Connection: close\r\n\r\n".toByteArray())
            val body = s.getInputStream().bufferedReader().readText()
            (System.nanoTime() - start) / 1_000_000 to body
        }
    }.getOrNull()

    /** The Local Port's credentials when Local Network sharing protects it with a password (user `mlm`). */
    private fun proxyAuth(): String? =
        NetworkSettings.lanPassword(app)?.takeIf { it.isNotBlank() && com.mlmvpn.scanner.lan.LanShare.sharingActive(app) }
            ?.let { "Basic " + android.util.Base64.encodeToString("mlm:$it".toByteArray(), android.util.Base64.NO_WRAP) }

    private suspend fun canary(attempts: Int): Long? = withContext(Dispatchers.IO) {
        repeat(attempts) { i ->
            if (!wantConnected) return@withContext null
            val r = proxyRequest("http://www.gstatic.com/generate_204", "www.gstatic.com", 6_000)
            val ok = r != null && r.second.lineSequence().firstOrNull().orEmpty().let { it.contains(" 204") || it.contains(" 200") }
            Log.i(TAG, "canary ${i + 1}/$attempts: ${if (ok) "OK ${r!!.first}ms" else "FAIL"}")
            if (ok) return@withContext r!!.first
            if (i < attempts - 1) delay(1_200)
        }
        null
    }

    /** The exit address and country, from Cloudflare's trace through the tunnel. */
    private suspend fun exitTrace(): Pair<String?, String?>? = withContext(Dispatchers.IO) {
        delay(1_200)
        val body = proxyRequest("http://www.cloudflare.com/cdn-cgi/trace", "www.cloudflare.com", 8_000)?.second ?: return@withContext null
        val lines = body.lineSequence()
        val ip = lines.firstOrNull { it.startsWith("ip=") }?.substringAfter('=')?.trim()
        val cc = lines.firstOrNull { it.startsWith("loc=") }?.substringAfter('=')?.trim()?.uppercase()
            ?.takeIf { it.length == 2 && it.all { c -> c in 'A'..'Z' } && it != "XX" && it != "T1" }
        ip to cc
    }

    /** A 3 MB download through the tunnel, for the connected card's speed tile. */
    fun speedTest() {
        if (_connect.value !is OutlineConnect.Connected || _speed.value == SpeedState.Running) return
        _speed.value = SpeedState.Running
        scope.launch(Dispatchers.IO) {
            val bps = runCatching {
                val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", LocalPort.get(app)))
                val c = java.net.URL(SPEED_URL).openConnection(proxy) as java.net.HttpURLConnection
                proxyAuth()?.let { c.setRequestProperty("Proxy-Authorization", it) }
                c.connectTimeout = 8_000; c.readTimeout = 8_000; c.useCaches = false
                try {
                    c.inputStream.use { input ->
                        val buf = ByteArray(32 * 1024)
                        var start = 0L; var total = 0L
                        val deadline = System.nanoTime() + 12_000_000_000L
                        while (true) {
                            val n = input.read(buf); if (n < 0) break
                            val t = System.nanoTime()
                            if (start == 0L) start = t else total += n
                            if (t > deadline) break
                        }
                        val secs = (System.nanoTime() - start) / 1e9
                        if (start == 0L || total < 200_000 || secs < 0.05) null else (total * 8 / secs).toLong()
                    }
                } finally { c.disconnect() }
            }.getOrNull()
            _speed.value = if (bps != null) SpeedState.Done(bps) else SpeedState.Failed
            val st = _connect.value
            if (bps != null && st is OutlineConnect.Connected) {
                store.update { s ->
                    val m = s.statsFor(_net.value).toMutableMap()
                    m[st.serverId]?.let { m[st.serverId] = it.copy(speedBps = bps) }
                    s.copy(stats = s.stats + (_net.value to m))
                }
            }
        }
    }

    private fun stopService() {
        if (MyVpnService.connectedNodeIdFlow.value == NODE_ID) {
            com.mlmvpn.scanner.utils.SafeStart.service(app, Intent(app, MyVpnService::class.java).apply { action = "STOP" })
        }
    }

    /** The running tunnel's local proxy, for fetching lists through it; null when none is up. */
    private fun tunnelPort(): Int? =
        if (MyVpnService.connectionPhaseFlow.value == MyVpnService.Phase.CONNECTED) LocalPort.get(app) else null

    fun isOurs(): Boolean = MyVpnService.connectedNodeIdFlow.value == NODE_ID && MyVpnService.connectionPhaseFlow.value != MyVpnService.Phase.IDLE

    // ---------------------------------------------------------------- MLM Scout

    /**
     * For MLM Scout: what to race on this network -- favourites, the ones that worked here, the
     * user's own keys, then the most promising untested. Fetches the lists once if there are none.
     */
    suspend fun scoutCandidates(context: Context, max: Int = 24): List<OutlineServer> {
        init(context)
        if (store.current.servers.isEmpty()) {
            refresh(force = true, by = Trigger.PAGE)
            delay(300)
            withTimeoutOrNull(60_000) { refreshing.first { !it } }
        }
        val net = FluxNet.current(app).key
        return OutlineBrain.pickForTest(store.current, net, all = false, limit = max).take(max)
    }

    /** Scout proved [uri] on this network: it is listed as working here, and connect tries it early. */
    fun scoutProved(context: Context, uri: String, ms: Long) {
        init(context)
        val net = FluxNet.current(app).key
        val s = store.current.servers.firstOrNull { it.uri == uri } ?: return
        store.update { OutlineBrain.record(it, net, listOf(OutlineBrain.Result(s.id, ms)), System.currentTimeMillis()).copy(scoutWinners = it.scoutWinners + (net to s.id)) }
    }
}
