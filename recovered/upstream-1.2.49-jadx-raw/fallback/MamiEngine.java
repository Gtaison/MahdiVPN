package com.mlmvpn.scanner.engines.mami;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiEngine {
    public static final int $stable = 0;
    private static final long CATALOG_MARGIN_SEC = 300;
    private static final java.util.List<java.lang.String> ENGINE_NAMES = null;
    private static final int FAILOVER_MISSES = 3;
    private static final long FRESH_REGISTRATION_MS = 120000;
    private static final java.lang.String HIVE_PROBE = "https://cp.cloudflare.com/generate_204";
    private static final long HIVE_TTL_MS = 3600000;
    public static final com.mlmvpn.scanner.engines.mami.MamiEngine INSTANCE = null;
    private static final int KEEPALIVE_TICKS = 10;
    private static final java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.Method> METHODS = null;
    public static final java.lang.String NODE_ID = "mami";
    private static final long OWNER_CHECK_MS = 5000;
    public static final java.lang.String REMARKS = "mlm-mami-v1";
    private static final long SCOUT_BUDGET_MS = 30000;
    private static final long SCOUT_EACH_MS = 12000;
    private static final int SCOUT_MAX = 24;
    private static final long SCOUT_TTL_MS = 600000;
    private static final java.util.Map<java.lang.String, java.lang.String> STEP_WORDS = null;
    private static final java.lang.String TAG = "MAMI";
    private static final long TEMPLATE_FRESH_MS = 21600000;
    private static final long TEMPLATE_MAX_MS = 604800000;
    private static final long TICK_MS = 60000;
    private static final int TRIES = 3;
    private static final kotlinx.coroutines.flow.k0 _busy = null;
    private static final kotlinx.coroutines.flow.k0 _logs = null;
    private static final kotlinx.coroutines.flow.k0 _status = null;
    private static final kotlinx.coroutines.flow.k0 _version = null;
    private static android.content.Context app;
    private static final kotlinx.coroutines.flow.e1 busy = null;
    private static volatile boolean cancelled;
    private static sd.j cat;
    private static kotlinx.coroutines.s1 connectJob;
    private static final com.mlmvpn.scanner.utils.ConnectionOwner connectionOwner = null;
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> delays = null;
    private static volatile com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive exclusiveLive;
    private static volatile java.lang.String frontMarker;
    private static volatile java.lang.String frontTransport;
    private static sd.j hiveCat;
    private static volatile com.mlmvpn.scanner.engines.mami.MamiEngine.Live live;
    private static final kotlinx.coroutines.flow.e1 logs = null;
    private static final kotlinx.coroutines.i0 scope = null;
    private static final kotlinx.coroutines.flow.e1 status = null;
    private static final kotlinx.coroutines.flow.e1 version = null;
    private static kotlinx.coroutines.s1 watchJob;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Cand {

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11583cc;
        private final java.lang.String city;
        private final java.lang.String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11584id;
        private final java.lang.String locationId;
        private final sf.c outbound;
        private final java.lang.String profile;
        private final java.lang.String protocol;
        private final com.mlmvpn.scanner.engines.mami.MamiCatalog.Server server;

        public Cand(java.lang.String r2, com.mlmvpn.scanner.engines.mami.MamiCatalog.Server r3, sf.c r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "outbound"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "locationId"
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "protocol"
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "profile"
                kotlin.jvm.internal.j.e(r10, r0)
                r1.<init>()
                r1.f11584id = r2
                r1.server = r3
                r1.outbound = r4
                r1.f11583cc = r5
                r1.country = r6
                r1.city = r7
                r1.locationId = r8
                r1.protocol = r9
                r1.profile = r10
                return
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11583cc
                return r0
        }

        public final java.lang.String getCity() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String getCountry() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11584id
                return r0
        }

        public final java.lang.String getLocationId() {
                r1 = this;
                java.lang.String r0 = r1.locationId
                return r0
        }

        public final sf.c getOutbound() {
                r1 = this;
                sf.c r0 = r1.outbound
                return r0
        }

        public final java.lang.String getProfile() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final java.lang.String getProtocol() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiCatalog.Server getServer() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r0 = r1.server
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class CatalogInfo {
        public static final int $stable = 0;
        private final long expiresAt;
        private final long fetchedAt;
        private final boolean fresh;
        private final int payloadVersion;
        private final long revision;
        private final int servers;
        private final int skipped;
        private final int version;

        public CatalogInfo(long r1, int r3, int r4, int r5, int r6, long r7, long r9, boolean r11) {
                r0 = this;
                r0.<init>()
                r0.revision = r1
                r0.payloadVersion = r3
                r0.version = r4
                r0.servers = r5
                r0.skipped = r6
                r0.fetchedAt = r7
                r0.expiresAt = r9
                r0.fresh = r11
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo r12, long r13, int r15, int r16, int r17, int r18, long r19, long r21, boolean r23, int r24, java.lang.Object r25) {
                r0 = r24
                r1 = r0 & 1
                if (r1 == 0) goto L8
                long r13 = r12.revision
            L8:
                r1 = r13
                r13 = r0 & 2
                if (r13 == 0) goto Lf
                int r15 = r12.payloadVersion
            Lf:
                r3 = r15
                r13 = r0 & 4
                if (r13 == 0) goto L18
                int r13 = r12.version
                r4 = r13
                goto L1a
            L18:
                r4 = r16
            L1a:
                r13 = r0 & 8
                if (r13 == 0) goto L22
                int r13 = r12.servers
                r5 = r13
                goto L24
            L22:
                r5 = r17
            L24:
                r13 = r0 & 16
                if (r13 == 0) goto L2c
                int r13 = r12.skipped
                r6 = r13
                goto L2e
            L2c:
                r6 = r18
            L2e:
                r13 = r0 & 32
                if (r13 == 0) goto L36
                long r13 = r12.fetchedAt
                r7 = r13
                goto L38
            L36:
                r7 = r19
            L38:
                r13 = r0 & 64
                if (r13 == 0) goto L40
                long r13 = r12.expiresAt
                r9 = r13
                goto L42
            L40:
                r9 = r21
            L42:
                r13 = r0 & 128(0x80, float:1.794E-43)
                if (r13 == 0) goto L4b
                boolean r13 = r12.fresh
                r11 = r13
            L49:
                r0 = r12
                goto L4e
            L4b:
                r11 = r23
                goto L49
            L4e:
                com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo r12 = r0.copy(r1, r3, r4, r5, r6, r7, r9, r11)
                return r12
        }

        public final long component1() {
                r2 = this;
                long r0 = r2.revision
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.payloadVersion
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.version
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.skipped
                return r0
        }

        public final long component6() {
                r2 = this;
                long r0 = r2.fetchedAt
                return r0
        }

        public final long component7() {
                r2 = this;
                long r0 = r2.expiresAt
                return r0
        }

        public final boolean component8() {
                r1 = this;
                boolean r0 = r1.fresh
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo copy(long r13, int r15, int r16, int r17, int r18, long r19, long r21, boolean r23) {
                r12 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo
                r1 = r13
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r9 = r21
                r11 = r23
                r0.<init>(r1, r3, r4, r5, r6, r7, r9, r11)
                return r0
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo) r8
                long r3 = r7.revision
                long r5 = r8.revision
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L15
                return r2
            L15:
                int r1 = r7.payloadVersion
                int r3 = r8.payloadVersion
                if (r1 == r3) goto L1c
                return r2
            L1c:
                int r1 = r7.version
                int r3 = r8.version
                if (r1 == r3) goto L23
                return r2
            L23:
                int r1 = r7.servers
                int r3 = r8.servers
                if (r1 == r3) goto L2a
                return r2
            L2a:
                int r1 = r7.skipped
                int r3 = r8.skipped
                if (r1 == r3) goto L31
                return r2
            L31:
                long r3 = r7.fetchedAt
                long r5 = r8.fetchedAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L3a
                return r2
            L3a:
                long r3 = r7.expiresAt
                long r5 = r8.expiresAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L43
                return r2
            L43:
                boolean r1 = r7.fresh
                boolean r8 = r8.fresh
                if (r1 == r8) goto L4a
                return r2
            L4a:
                return r0
        }

        public final long getExpiresAt() {
                r2 = this;
                long r0 = r2.expiresAt
                return r0
        }

        public final long getFetchedAt() {
                r2 = this;
                long r0 = r2.fetchedAt
                return r0
        }

        public final boolean getFresh() {
                r1 = this;
                boolean r0 = r1.fresh
                return r0
        }

        public final int getPayloadVersion() {
                r1 = this;
                int r0 = r1.payloadVersion
                return r0
        }

        public final long getRevision() {
                r2 = this;
                long r0 = r2.revision
                return r0
        }

        public final int getServers() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final int getSkipped() {
                r1 = this;
                int r0 = r1.skipped
                return r0
        }

        public final int getVersion() {
                r1 = this;
                int r0 = r1.version
                return r0
        }

        public int hashCode() {
                r4 = this;
                long r0 = r4.revision
                int r0 = java.lang.Long.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                int r2 = r4.payloadVersion
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.version
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.servers
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.skipped
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                long r2 = r4.fetchedAt
                int r0 = a6.w0.c(r0, r1, r2)
                long r2 = r4.expiresAt
                int r0 = a6.w0.c(r0, r1, r2)
                boolean r1 = r4.fresh
                int r1 = java.lang.Boolean.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r13 = this;
                long r0 = r13.revision
                int r2 = r13.payloadVersion
                int r3 = r13.version
                int r4 = r13.servers
                int r5 = r13.skipped
                long r6 = r13.fetchedAt
                long r8 = r13.expiresAt
                boolean r10 = r13.fresh
                java.lang.String r11 = "CatalogInfo(revision="
                java.lang.String r12 = ", payloadVersion="
                java.lang.StringBuilder r0 = com.mlmvpn.core.aether.i.j(r0, r11, r2, r12)
                java.lang.String r1 = ", version="
                java.lang.String r2 = ", servers="
                androidx.media3.common.s.w(r0, r1, r3, r2, r4)
                java.lang.String r1 = ", skipped="
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ", fetchedAt="
                r0.append(r1)
                r0.append(r6)
                java.lang.String r1 = ", expiresAt="
                java.lang.String r2 = ", fresh="
                v0.a.k(r8, r1, r2, r0)
                java.lang.String r1 = ")"
                java.lang.String r0 = f0.a.n(r0, r1, r10)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ExclusiveLive {
        private final java.lang.String host;
        private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo info;
        private final int port;

        public ExclusiveLive(java.lang.String r2, int r3, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r4) {
                r1 = this;
                java.lang.String r0 = "host"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "info"
                kotlin.jvm.internal.j.e(r4, r0)
                r1.<init>()
                r1.host = r2
                r1.port = r3
                r1.info = r4
                return
        }

        public final java.lang.String getHost() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo getInfo() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r0 = r1.info
                return r0
        }

        public final int getPort() {
                r1 = this;
                int r0 = r1.port
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Exit {
        public static final int $stable = 0;
        private final java.lang.String ip;
        private final java.lang.String loc;
        private final long ms;

        public Exit(java.lang.String r2, java.lang.String r3, long r4) {
                r1 = this;
                java.lang.String r0 = "loc"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r3, r0)
                r1.<init>()
                r1.loc = r2
                r1.ip = r3
                r1.ms = r4
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Exit copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r0, java.lang.String r1, java.lang.String r2, long r3, int r5, java.lang.Object r6) {
                r6 = r5 & 1
                if (r6 == 0) goto L6
                java.lang.String r1 = r0.loc
            L6:
                r6 = r5 & 2
                if (r6 == 0) goto Lc
                java.lang.String r2 = r0.ip
            Lc:
                r5 = r5 & 4
                if (r5 == 0) goto L12
                long r3 = r0.ms
            L12:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r0.copy(r1, r2, r3)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.loc
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.ip
                return r0
        }

        public final long component3() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit copy(java.lang.String r2, java.lang.String r3, long r4) {
                r1 = this;
                java.lang.String r0 = "loc"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r3, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Exit
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.Exit
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r8
                java.lang.String r1 = r7.loc
                java.lang.String r3 = r8.loc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.ip
                java.lang.String r3 = r8.ip
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                long r3 = r7.ms
                long r5 = r8.ms
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L2b
                return r2
            L2b:
                return r0
        }

        public final java.lang.String getIp() {
                r1 = this;
                java.lang.String r0 = r1.ip
                return r0
        }

        public final java.lang.String getLoc() {
                r1 = this;
                java.lang.String r0 = r1.loc
                return r0
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.loc
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r3.ip
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r1 = r3.ms
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r7 = this;
                java.lang.String r0 = r7.loc
                java.lang.String r1 = r7.ip
                long r2 = r7.ms
                java.lang.String r4 = ", ip="
                java.lang.String r5 = ", ms="
                java.lang.String r6 = "Exit(loc="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r6, r0, r4, r1, r5)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.k(r2, r1, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Fail extends java.lang.Exception {
        private final java.lang.String code;

        public Fail(java.lang.String r2, java.lang.String r3) {
                r1 = this;
                java.lang.String r0 = "code"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "msg"
                kotlin.jvm.internal.j.e(r3, r0)
                r1.<init>(r3)
                r1.code = r2
                return
        }

        public final java.lang.String getCode() {
                r1 = this;
                java.lang.String r0 = r1.code
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class HiveInfo {
        public static final int $stable = 0;
        private final long fetchedAt;
        private final boolean fresh;
        private final long revision;
        private final int servers;
        private final int skipped;

        public HiveInfo(long r1, long r3, int r5, int r6, boolean r7) {
                r0 = this;
                r0.<init>()
                r0.fetchedAt = r1
                r0.revision = r3
                r0.servers = r5
                r0.skipped = r6
                r0.fresh = r7
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo r8, long r9, long r11, int r13, int r14, boolean r15, int r16, java.lang.Object r17) {
                r0 = r16 & 1
                if (r0 == 0) goto L6
                long r9 = r8.fetchedAt
            L6:
                r1 = r9
                r9 = r16 & 2
                if (r9 == 0) goto Ld
                long r11 = r8.revision
            Ld:
                r3 = r11
                r9 = r16 & 4
                if (r9 == 0) goto L14
                int r13 = r8.servers
            L14:
                r5 = r13
                r9 = r16 & 8
                if (r9 == 0) goto L1b
                int r14 = r8.skipped
            L1b:
                r6 = r14
                r9 = r16 & 16
                if (r9 == 0) goto L22
                boolean r15 = r8.fresh
            L22:
                r0 = r8
                r7 = r15
                com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo r8 = r0.copy(r1, r3, r5, r6, r7)
                return r8
        }

        public final long component1() {
                r2 = this;
                long r0 = r2.fetchedAt
                return r0
        }

        public final long component2() {
                r2 = this;
                long r0 = r2.revision
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.skipped
                return r0
        }

        public final boolean component5() {
                r1 = this;
                boolean r0 = r1.fresh
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo copy(long r9, long r11, int r13, int r14, boolean r15) {
                r8 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo
                r1 = r9
                r3 = r11
                r5 = r13
                r6 = r14
                r7 = r15
                r0.<init>(r1, r3, r5, r6, r7)
                return r0
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo) r8
                long r3 = r7.fetchedAt
                long r5 = r8.fetchedAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L15
                return r2
            L15:
                long r3 = r7.revision
                long r5 = r8.revision
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L1e
                return r2
            L1e:
                int r1 = r7.servers
                int r3 = r8.servers
                if (r1 == r3) goto L25
                return r2
            L25:
                int r1 = r7.skipped
                int r3 = r8.skipped
                if (r1 == r3) goto L2c
                return r2
            L2c:
                boolean r1 = r7.fresh
                boolean r8 = r8.fresh
                if (r1 == r8) goto L33
                return r2
            L33:
                return r0
        }

        public final long getFetchedAt() {
                r2 = this;
                long r0 = r2.fetchedAt
                return r0
        }

        public final boolean getFresh() {
                r1 = this;
                boolean r0 = r1.fresh
                return r0
        }

        public final long getRevision() {
                r2 = this;
                long r0 = r2.revision
                return r0
        }

        public final int getServers() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final int getSkipped() {
                r1 = this;
                int r0 = r1.skipped
                return r0
        }

        public int hashCode() {
                r4 = this;
                long r0 = r4.fetchedAt
                int r0 = java.lang.Long.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                long r2 = r4.revision
                int r0 = a6.w0.c(r0, r1, r2)
                int r2 = r4.servers
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.skipped
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                boolean r1 = r4.fresh
                int r1 = java.lang.Boolean.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r9 = this;
                long r0 = r9.fetchedAt
                long r2 = r9.revision
                int r4 = r9.servers
                int r5 = r9.skipped
                boolean r6 = r9.fresh
                java.lang.String r7 = "HiveInfo(fetchedAt="
                java.lang.String r8 = ", revision="
                java.lang.StringBuilder r0 = f0.a.o(r0, r7, r8)
                java.lang.String r1 = ", servers="
                androidx.media3.common.s.p(r4, r2, r1, r0)
                java.lang.String r1 = ", skipped="
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ", fresh="
                r0.append(r1)
                r0.append(r6)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Live {
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.Cand cand;
        private final java.lang.String config;
        private final java.lang.String engine;
        private final java.lang.String kind;
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode mode;

        public Live(java.lang.String r2, com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r3, java.lang.String r4, java.lang.String r5, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r6) {
                r1 = this;
                java.lang.String r0 = "kind"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r6, r0)
                r1.<init>()
                r1.kind = r2
                r1.cand = r3
                r1.config = r4
                r1.engine = r5
                r1.mode = r6
                return
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Cand getCand() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r0 = r1.cand
                return r0
        }

        public final java.lang.String getConfig() {
                r1 = this;
                java.lang.String r0 = r1.config
                return r0
        }

        public final java.lang.String getEngine() {
                r1 = this;
                java.lang.String r0 = r1.engine
                return r0
        }

        public final java.lang.String getKind() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode getMode() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r1.mode
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Method {
        public static final int $stable = 0;
        private final java.lang.String about;
        private final java.lang.String engine;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11585id;
        private final java.lang.String key;
        private final java.lang.String kind;
        private final java.lang.String name;
        private final boolean ready;

        public Method(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, java.lang.String r8) {
                r1 = this;
                java.lang.String r0 = "key"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "kind"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "about"
                kotlin.jvm.internal.j.e(r8, r0)
                r1.<init>()
                r1.key = r2
                r1.f11585id = r3
                r1.name = r4
                r1.kind = r5
                r1.engine = r6
                r1.ready = r7
                r1.about = r8
                return
        }

        public final java.lang.String getAbout() {
                r1 = this;
                java.lang.String r0 = r1.about
                return r0
        }

        public final java.lang.String getEngine() {
                r1 = this;
                java.lang.String r0 = r1.engine
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11585id
                return r0
        }

        public final java.lang.String getKey() {
                r1 = this;
                java.lang.String r0 = r1.key
                return r0
        }

        public final java.lang.String getKind() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.String getName() {
                r1 = this;
                java.lang.String r0 = r1.name
                return r0
        }

        public final boolean getReady() {
                r1 = this;
                boolean r0 = r1.ready
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final enum Mode extends java.lang.Enum<com.mlmvpn.scanner.engines.mami.MamiEngine.Mode> {
        private static final /* synthetic */ yd.a $ENTRIES = null;
        private static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Mode[] $VALUES = null;
        public static final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode PROXY = null;
        public static final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode TUNNEL = null;

        private static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Mode[] $values() {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode[] r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine.Mode[]{r0, r1}
                return r0
        }

        static {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Mode
                java.lang.String r1 = "TUNNEL"
                r2 = 0
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL = r0
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Mode
                java.lang.String r1 = "PROXY"
                r2 = 1
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY = r0
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode[] r0 = $values()
                com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.$VALUES = r0
                yd.b r0 = com.google.android.gms.internal.mlkit_language_id_common.j.j(r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.$ENTRIES = r0
                return
        }

        private Mode(java.lang.String r1, int r2) {
                r0 = this;
                r0.<init>(r1, r2)
                return
        }

        public static yd.a getEntries() {
                yd.a r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.$ENTRIES
                return r0
        }

        public static com.mlmvpn.scanner.engines.mami.MamiEngine.Mode valueOf(java.lang.String r1) {
                java.lang.Class<com.mlmvpn.scanner.engines.mami.MamiEngine$Mode> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.class
                java.lang.Enum r1 = java.lang.Enum.valueOf(r0, r1)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r1
                return r1
        }

        public static com.mlmvpn.scanner.engines.mami.MamiEngine.Mode[] values() {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode[] r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.$VALUES
                java.lang.Object r0 = r0.clone()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode[] r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode[]) r0
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class PlaceRow {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11586cc;
        private final java.lang.String city;
        private final java.lang.String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11587id;
        private final int servers;
        private final int sort;

        public PlaceRow(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, int r6, int r7) {
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r5, r0)
                r1.<init>()
                r1.f11587id = r2
                r1.f11586cc = r3
                r1.country = r4
                r1.city = r5
                r1.sort = r6
                r1.servers = r7
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5, int r6, int r7, java.lang.Object r8) {
                r8 = r7 & 1
                if (r8 == 0) goto L6
                java.lang.String r1 = r0.f11587id
            L6:
                r8 = r7 & 2
                if (r8 == 0) goto Lc
                java.lang.String r2 = r0.f11586cc
            Lc:
                r8 = r7 & 4
                if (r8 == 0) goto L12
                java.lang.String r3 = r0.country
            L12:
                r8 = r7 & 8
                if (r8 == 0) goto L18
                java.lang.String r4 = r0.city
            L18:
                r8 = r7 & 16
                if (r8 == 0) goto L1e
                int r5 = r0.sort
            L1e:
                r7 = r7 & 32
                if (r7 == 0) goto L24
                int r6 = r0.servers
            L24:
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r0 = r2.copy(r3, r4, r5, r6, r7, r8)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11587id
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.f11586cc
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.sort
                return r0
        }

        public final int component6() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow copy(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, int r14) {
                r8 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r12, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow
                r2 = r9
                r3 = r10
                r4 = r11
                r5 = r12
                r6 = r13
                r7 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r1
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r5
                java.lang.String r1 = r4.f11587id
                java.lang.String r3 = r5.f11587id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r4.f11586cc
                java.lang.String r3 = r5.f11586cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r4.country
                java.lang.String r3 = r5.country
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.lang.String r1 = r4.city
                java.lang.String r3 = r5.city
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                int r1 = r4.sort
                int r3 = r5.sort
                if (r1 == r3) goto L3f
                return r2
            L3f:
                int r1 = r4.servers
                int r5 = r5.servers
                if (r1 == r5) goto L46
                return r2
            L46:
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11586cc
                return r0
        }

        public final java.lang.String getCity() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String getCountry() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11587id
                return r0
        }

        public final int getServers() {
                r1 = this;
                int r0 = r1.servers
                return r0
        }

        public final int getSort() {
                r1 = this;
                int r0 = r1.sort
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.f11587id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r3.f11586cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.country
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.city
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r3.sort
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r1 = r3.servers
                int r1 = java.lang.Integer.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r9 = this;
                java.lang.String r0 = r9.f11587id
                java.lang.String r1 = r9.f11586cc
                java.lang.String r2 = r9.country
                java.lang.String r3 = r9.city
                int r4 = r9.sort
                int r5 = r9.servers
                java.lang.String r6 = ", cc="
                java.lang.String r7 = ", country="
                java.lang.String r8 = "PlaceRow(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r8, r0, r6, r1, r7)
                java.lang.String r1 = ", city="
                java.lang.String r6 = ", sort="
                org.telegram.ui.Cells.d1.x(r0, r2, r1, r3, r6)
                r0.append(r4)
                java.lang.String r1 = ", servers="
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Prefs {
        public static final int $stable = 0;
        private final java.lang.String location;
        private final java.lang.String method;
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode mode;

        public Prefs() {
                r6 = this;
                r4 = 7
                r5 = 0
                r1 = 0
                r2 = 0
                r3 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                return
        }

        public Prefs(java.lang.String r2, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r3, java.lang.String r4) {
                r1 = this;
                java.lang.String r0 = "method"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "location"
                kotlin.jvm.internal.j.e(r4, r0)
                r1.<init>()
                r1.method = r2
                r1.mode = r3
                r1.location = r4
                return
        }

        public /* synthetic */ Prefs(java.lang.String r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, java.lang.String r3, int r4, kotlin.jvm.internal.e r5) {
                r0 = this;
                r5 = r4 & 1
                if (r5 == 0) goto L6
                java.lang.String r1 = "auto"
            L6:
                r5 = r4 & 2
                if (r5 == 0) goto Lc
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
            Lc:
                r4 = r4 & 4
                if (r4 == 0) goto L12
                java.lang.String r3 = ""
            L12:
                r0.<init>(r1, r2, r3)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs r0, java.lang.String r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, java.lang.String r3, int r4, java.lang.Object r5) {
                r5 = r4 & 1
                if (r5 == 0) goto L6
                java.lang.String r1 = r0.method
            L6:
                r5 = r4 & 2
                if (r5 == 0) goto Lc
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r2 = r0.mode
            Lc:
                r4 = r4 & 4
                if (r4 == 0) goto L12
                java.lang.String r3 = r0.location
            L12:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r0 = r0.copy(r1, r2, r3)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.method
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode component2() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r1.mode
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.location
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs copy(java.lang.String r2, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r3, java.lang.String r4) {
                r1 = this;
                java.lang.String r0 = "method"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "location"
                kotlin.jvm.internal.j.e(r4, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs) r5
                java.lang.String r1 = r4.method
                java.lang.String r3 = r5.method
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = r4.mode
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = r5.mode
                if (r1 == r3) goto L1e
                return r2
            L1e:
                java.lang.String r1 = r4.location
                java.lang.String r5 = r5.location
                boolean r5 = kotlin.jvm.internal.j.a(r1, r5)
                if (r5 != 0) goto L29
                return r2
            L29:
                return r0
        }

        public final java.lang.String getLocation() {
                r1 = this;
                java.lang.String r0 = r1.location
                return r0
        }

        public final java.lang.String getMethod() {
                r1 = this;
                java.lang.String r0 = r1.method
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode getMode() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r1.mode
                return r0
        }

        public int hashCode() {
                r2 = this;
                java.lang.String r0 = r2.method
                int r0 = r0.hashCode()
                int r0 = r0 * 31
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = r2.mode
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                int r1 = r1 * 31
                java.lang.String r0 = r2.location
                int r0 = r0.hashCode()
                int r0 = r0 + r1
                return r0
        }

        public java.lang.String toString() {
                r5 = this;
                java.lang.String r0 = r5.method
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = r5.mode
                java.lang.String r2 = r5.location
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Prefs(method="
                r3.<init>(r4)
                r3.append(r0)
                java.lang.String r0 = ", mode="
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = ", location="
                r3.append(r0)
                java.lang.String r0 = ")"
                java.lang.String r0 = a6.w0.r(r3, r2, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ranked {
        private final long ms;
        private final long score;
        private final com.mlmvpn.scanner.engines.mami.MamiCatalog.Server server;

        public Ranked(com.mlmvpn.scanner.engines.mami.MamiCatalog.Server r2, long r3, long r5) {
                r1 = this;
                java.lang.String r0 = "server"
                kotlin.jvm.internal.j.e(r2, r0)
                r1.<init>()
                r1.server = r2
                r1.ms = r3
                r1.score = r5
                return
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final long getScore() {
                r2 = this;
                long r0 = r2.score
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiCatalog.Server getServer() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r0 = r1.server
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ServerRef {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11588cc;
        private final java.lang.String city;
        private final java.lang.String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11589id;
        private final long ms;
        private final java.lang.String profile;
        private final java.lang.String protocol;

        public ServerRef(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, long r8) {
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "protocol"
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "profile"
                kotlin.jvm.internal.j.e(r7, r0)
                r1.<init>()
                r1.f11589id = r2
                r1.f11588cc = r3
                r1.country = r4
                r1.city = r5
                r1.protocol = r6
                r1.profile = r7
                r1.ms = r8
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, long r7, int r9, java.lang.Object r10) {
                r10 = r9 & 1
                if (r10 == 0) goto L6
                java.lang.String r1 = r0.f11589id
            L6:
                r10 = r9 & 2
                if (r10 == 0) goto Lc
                java.lang.String r2 = r0.f11588cc
            Lc:
                r10 = r9 & 4
                if (r10 == 0) goto L12
                java.lang.String r3 = r0.country
            L12:
                r10 = r9 & 8
                if (r10 == 0) goto L18
                java.lang.String r4 = r0.city
            L18:
                r10 = r9 & 16
                if (r10 == 0) goto L1e
                java.lang.String r5 = r0.protocol
            L1e:
                r10 = r9 & 32
                if (r10 == 0) goto L24
                java.lang.String r6 = r0.profile
            L24:
                r9 = r9 & 64
                if (r9 == 0) goto L2a
                long r7 = r0.ms
            L2a:
                r9 = r7
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11589id
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.f11588cc
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String component5() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final long component7() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef copy(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, long r17) {
                r10 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r12, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r14, r0)
                java.lang.String r0 = "protocol"
                kotlin.jvm.internal.j.e(r15, r0)
                java.lang.String r0 = "profile"
                r7 = r16
                kotlin.jvm.internal.j.e(r7, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef
                r2 = r11
                r3 = r12
                r4 = r13
                r5 = r14
                r6 = r15
                r8 = r17
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef) r8
                java.lang.String r1 = r7.f11589id
                java.lang.String r3 = r8.f11589id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.f11588cc
                java.lang.String r3 = r8.f11588cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r7.country
                java.lang.String r3 = r8.country
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.lang.String r1 = r7.city
                java.lang.String r3 = r8.city
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                java.lang.String r1 = r7.protocol
                java.lang.String r3 = r8.protocol
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L43
                return r2
            L43:
                java.lang.String r1 = r7.profile
                java.lang.String r3 = r8.profile
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4e
                return r2
            L4e:
                long r3 = r7.ms
                long r5 = r8.ms
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L57
                return r2
            L57:
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11588cc
                return r0
        }

        public final java.lang.String getCity() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String getCountry() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11589id
                return r0
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final java.lang.String getProfile() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final java.lang.String getProtocol() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.f11589id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r3.f11588cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.country
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.city
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.protocol
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.profile
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r1 = r3.ms
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r11 = this;
                java.lang.String r0 = r11.f11589id
                java.lang.String r1 = r11.f11588cc
                java.lang.String r2 = r11.country
                java.lang.String r3 = r11.city
                java.lang.String r4 = r11.protocol
                java.lang.String r5 = r11.profile
                long r6 = r11.ms
                java.lang.String r8 = ", cc="
                java.lang.String r9 = ", country="
                java.lang.String r10 = "ServerRef(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r10, r0, r8, r1, r9)
                java.lang.String r1 = ", city="
                java.lang.String r8 = ", protocol="
                org.telegram.ui.Cells.d1.x(r0, r2, r1, r3, r8)
                java.lang.String r1 = ", profile="
                java.lang.String r2 = ", ms="
                org.telegram.ui.Cells.d1.x(r0, r4, r1, r5, r2)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.k(r6, r1, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ServerRow {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11590cc;
        private final java.lang.String city;
        private final java.lang.String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11591id;
        private final java.lang.String locationId;
        private final long ms;
        private final java.lang.String profile;
        private final java.lang.String protocol;
        private final int sort;
        private final boolean supported;
        private final java.lang.String why;

        public ServerRow(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, boolean r10, java.lang.String r11, long r12, long r14) {
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "country"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "city"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "locationId"
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "protocol"
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "profile"
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "why"
                kotlin.jvm.internal.j.e(r11, r0)
                r1.<init>()
                r1.f11591id = r2
                r1.f11590cc = r3
                r1.country = r4
                r1.city = r5
                r1.locationId = r6
                r1.protocol = r7
                r1.profile = r8
                r1.sort = r9
                r1.supported = r10
                r1.why = r11
                r1.ms = r12
                r1.at = r14
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, boolean r25, java.lang.String r26, long r27, long r29, int r31, java.lang.Object r32) {
                r0 = r16
                r1 = r31
                r2 = r1 & 1
                if (r2 == 0) goto Lb
                java.lang.String r2 = r0.f11591id
                goto Ld
            Lb:
                r2 = r17
            Ld:
                r3 = r1 & 2
                if (r3 == 0) goto L14
                java.lang.String r3 = r0.f11590cc
                goto L16
            L14:
                r3 = r18
            L16:
                r4 = r1 & 4
                if (r4 == 0) goto L1d
                java.lang.String r4 = r0.country
                goto L1f
            L1d:
                r4 = r19
            L1f:
                r5 = r1 & 8
                if (r5 == 0) goto L26
                java.lang.String r5 = r0.city
                goto L28
            L26:
                r5 = r20
            L28:
                r6 = r1 & 16
                if (r6 == 0) goto L2f
                java.lang.String r6 = r0.locationId
                goto L31
            L2f:
                r6 = r21
            L31:
                r7 = r1 & 32
                if (r7 == 0) goto L38
                java.lang.String r7 = r0.protocol
                goto L3a
            L38:
                r7 = r22
            L3a:
                r8 = r1 & 64
                if (r8 == 0) goto L41
                java.lang.String r8 = r0.profile
                goto L43
            L41:
                r8 = r23
            L43:
                r9 = r1 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L4a
                int r9 = r0.sort
                goto L4c
            L4a:
                r9 = r24
            L4c:
                r10 = r1 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L53
                boolean r10 = r0.supported
                goto L55
            L53:
                r10 = r25
            L55:
                r11 = r1 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L5c
                java.lang.String r11 = r0.why
                goto L5e
            L5c:
                r11 = r26
            L5e:
                r12 = r1 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L65
                long r12 = r0.ms
                goto L67
            L65:
                r12 = r27
            L67:
                r1 = r1 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L88
                long r14 = r0.at
                r30 = r14
            L6f:
                r17 = r0
                r18 = r2
                r19 = r3
                r20 = r4
                r21 = r5
                r22 = r6
                r23 = r7
                r24 = r8
                r25 = r9
                r26 = r10
                r27 = r11
                r28 = r12
                goto L8b
            L88:
                r30 = r29
                goto L6f
            L8b:
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow r0 = r17.copy(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r30)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11591id
                return r0
        }

        public final java.lang.String component10() {
                r1 = this;
                java.lang.String r0 = r1.why
                return r0
        }

        public final long component11() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final long component12() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.f11590cc
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String component5() {
                r1 = this;
                java.lang.String r0 = r1.locationId
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final int component8() {
                r1 = this;
                int r0 = r1.sort
                return r0
        }

        public final boolean component9() {
                r1 = this;
                boolean r0 = r1.supported
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow copy(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, boolean r25, java.lang.String r26, long r27, long r29) {
                r16 = this;
                java.lang.String r0 = "id"
                r2 = r17
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "cc"
                r3 = r18
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "country"
                r4 = r19
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "city"
                r5 = r20
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "locationId"
                r6 = r21
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "protocol"
                r7 = r22
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "profile"
                r8 = r23
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "why"
                r11 = r26
                kotlin.jvm.internal.j.e(r11, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow
                r9 = r24
                r10 = r25
                r12 = r27
                r14 = r29
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow) r8
                java.lang.String r1 = r7.f11591id
                java.lang.String r3 = r8.f11591id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.f11590cc
                java.lang.String r3 = r8.f11590cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r7.country
                java.lang.String r3 = r8.country
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.lang.String r1 = r7.city
                java.lang.String r3 = r8.city
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                java.lang.String r1 = r7.locationId
                java.lang.String r3 = r8.locationId
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L43
                return r2
            L43:
                java.lang.String r1 = r7.protocol
                java.lang.String r3 = r8.protocol
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4e
                return r2
            L4e:
                java.lang.String r1 = r7.profile
                java.lang.String r3 = r8.profile
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L59
                return r2
            L59:
                int r1 = r7.sort
                int r3 = r8.sort
                if (r1 == r3) goto L60
                return r2
            L60:
                boolean r1 = r7.supported
                boolean r3 = r8.supported
                if (r1 == r3) goto L67
                return r2
            L67:
                java.lang.String r1 = r7.why
                java.lang.String r3 = r8.why
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L72
                return r2
            L72:
                long r3 = r7.ms
                long r5 = r8.ms
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L7b
                return r2
            L7b:
                long r3 = r7.at
                long r5 = r8.at
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L84
                return r2
            L84:
                return r0
        }

        public final long getAt() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11590cc
                return r0
        }

        public final java.lang.String getCity() {
                r1 = this;
                java.lang.String r0 = r1.city
                return r0
        }

        public final java.lang.String getCountry() {
                r1 = this;
                java.lang.String r0 = r1.country
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11591id
                return r0
        }

        public final java.lang.String getLocationId() {
                r1 = this;
                java.lang.String r0 = r1.locationId
                return r0
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final java.lang.String getProfile() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final java.lang.String getProtocol() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public final int getSort() {
                r1 = this;
                int r0 = r1.sort
                return r0
        }

        public final boolean getSupported() {
                r1 = this;
                boolean r0 = r1.supported
                return r0
        }

        public final java.lang.String getWhy() {
                r1 = this;
                java.lang.String r0 = r1.why
                return r0
        }

        public int hashCode() {
                r4 = this;
                java.lang.String r0 = r4.f11591id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r4.f11590cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.country
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.city
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.locationId
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.protocol
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.profile
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r4.sort
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                boolean r2 = r4.supported
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.String r2 = r4.why
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.ms
                int r0 = a6.w0.c(r0, r1, r2)
                long r1 = r4.at
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r18 = this;
                r0 = r18
                java.lang.String r1 = r0.f11591id
                java.lang.String r2 = r0.f11590cc
                java.lang.String r3 = r0.country
                java.lang.String r4 = r0.city
                java.lang.String r5 = r0.locationId
                java.lang.String r6 = r0.protocol
                java.lang.String r7 = r0.profile
                int r8 = r0.sort
                boolean r9 = r0.supported
                java.lang.String r10 = r0.why
                long r11 = r0.ms
                long r13 = r0.at
                java.lang.String r15 = ", cc="
                java.lang.String r0 = ", country="
                r16 = r13
                java.lang.String r13 = "ServerRow(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r13, r1, r15, r2, r0)
                java.lang.String r1 = ", city="
                java.lang.String r2 = ", locationId="
                org.telegram.ui.Cells.d1.x(r0, r3, r1, r4, r2)
                java.lang.String r1 = ", protocol="
                java.lang.String r2 = ", profile="
                org.telegram.ui.Cells.d1.x(r0, r5, r1, r6, r2)
                java.lang.String r1 = ", sort="
                java.lang.String r2 = ", supported="
                f0.a.r(r8, r7, r1, r2, r0)
                java.lang.String r1 = ", why="
                java.lang.String r2 = ", ms="
                com.mlmvpn.core.aether.i.x(r1, r10, r2, r0, r9)
                r0.append(r11)
                java.lang.String r1 = ", at="
                java.lang.String r2 = ")"
                r3 = r16
                java.lang.String r0 = androidx.media3.common.s.j(r3, r1, r2, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Status {
        public static final int $stable = 0;
        private final int attempt;
        private final long connectedAt;
        private final java.lang.String error;
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit exit;
        private final java.lang.String lastWhy;
        private final java.lang.String method;
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode mode;
        private final java.lang.String phase;
        private final com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef server;
        private final long startedAt;
        private final java.lang.String step;

        public Status() {
                r16 = this;
                r14 = 2047(0x7ff, float:2.868E-42)
                r15 = 0
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r10 = 0
                r12 = 0
                r13 = 0
                r0 = r16
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14, r15)
                return
        }

        public Status(java.lang.String r2, java.lang.String r3, java.lang.String r4, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r5, com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef r6, com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r7, java.lang.String r8, long r9, long r11, int r13, java.lang.String r14) {
                r1 = this;
                java.lang.String r0 = "phase"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "step"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r5, r0)
                r1.<init>()
                r1.phase = r2
                r1.method = r3
                r1.step = r4
                r1.mode = r5
                r1.server = r6
                r1.exit = r7
                r1.error = r8
                r1.startedAt = r9
                r1.connectedAt = r11
                r1.attempt = r13
                r1.lastWhy = r14
                return
        }

        public /* synthetic */ Status(java.lang.String r14, java.lang.String r15, java.lang.String r16, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r17, com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef r18, com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r19, java.lang.String r20, long r21, long r23, int r25, java.lang.String r26, int r27, kotlin.jvm.internal.e r28) {
                r13 = this;
                r0 = r27
                r1 = r0 & 1
                if (r1 == 0) goto L8
                java.lang.String r14 = "off"
            L8:
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto Lf
                r1 = r2
                goto L10
            Lf:
                r1 = r15
            L10:
                r3 = r0 & 4
                if (r3 == 0) goto L17
                java.lang.String r3 = ""
                goto L19
            L17:
                r3 = r16
            L19:
                r4 = r0 & 8
                if (r4 == 0) goto L20
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
                goto L22
            L20:
                r4 = r17
            L22:
                r5 = r0 & 16
                if (r5 == 0) goto L28
                r5 = r2
                goto L2a
            L28:
                r5 = r18
            L2a:
                r6 = r0 & 32
                if (r6 == 0) goto L30
                r6 = r2
                goto L32
            L30:
                r6 = r19
            L32:
                r7 = r0 & 64
                if (r7 == 0) goto L38
                r7 = r2
                goto L3a
            L38:
                r7 = r20
            L3a:
                r8 = r0 & 128(0x80, float:1.794E-43)
                r9 = 0
                if (r8 == 0) goto L42
                r11 = r9
                goto L44
            L42:
                r11 = r21
            L44:
                r8 = r0 & 256(0x100, float:3.59E-43)
                if (r8 == 0) goto L49
                goto L4b
            L49:
                r9 = r23
            L4b:
                r8 = r0 & 512(0x200, float:7.175E-43)
                if (r8 == 0) goto L51
                r8 = 0
                goto L53
            L51:
                r8 = r25
            L53:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L6f
                r28 = r2
            L59:
                r15 = r13
                r16 = r14
                r17 = r1
                r18 = r3
                r19 = r4
                r20 = r5
                r21 = r6
                r22 = r7
                r27 = r8
                r25 = r9
                r23 = r11
                goto L72
            L6f:
                r28 = r26
                goto L59
            L72:
                r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r28)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status copy$default(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r16, com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef r17, com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r18, java.lang.String r19, long r20, long r22, int r24, java.lang.String r25, int r26, java.lang.Object r27) {
                r0 = r26
                r1 = r0 & 1
                if (r1 == 0) goto L8
                java.lang.String r13 = r12.phase
            L8:
                r1 = r0 & 2
                if (r1 == 0) goto Lf
                java.lang.String r1 = r12.method
                goto L10
            Lf:
                r1 = r14
            L10:
                r2 = r0 & 4
                if (r2 == 0) goto L17
                java.lang.String r2 = r12.step
                goto L18
            L17:
                r2 = r15
            L18:
                r3 = r0 & 8
                if (r3 == 0) goto L1f
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = r12.mode
                goto L21
            L1f:
                r3 = r16
            L21:
                r4 = r0 & 16
                if (r4 == 0) goto L28
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r4 = r12.server
                goto L2a
            L28:
                r4 = r17
            L2a:
                r5 = r0 & 32
                if (r5 == 0) goto L31
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r5 = r12.exit
                goto L33
            L31:
                r5 = r18
            L33:
                r6 = r0 & 64
                if (r6 == 0) goto L3a
                java.lang.String r6 = r12.error
                goto L3c
            L3a:
                r6 = r19
            L3c:
                r7 = r0 & 128(0x80, float:1.794E-43)
                if (r7 == 0) goto L43
                long r7 = r12.startedAt
                goto L45
            L43:
                r7 = r20
            L45:
                r9 = r0 & 256(0x100, float:3.59E-43)
                if (r9 == 0) goto L4c
                long r9 = r12.connectedAt
                goto L4e
            L4c:
                r9 = r22
            L4e:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L55
                int r11 = r12.attempt
                goto L57
            L55:
                r11 = r24
            L57:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L74
                java.lang.String r0 = r12.lastWhy
                r27 = r0
            L5f:
                r14 = r12
                r15 = r13
                r16 = r1
                r17 = r2
                r18 = r3
                r19 = r4
                r20 = r5
                r21 = r6
                r22 = r7
                r24 = r9
                r26 = r11
                goto L77
            L74:
                r27 = r25
                goto L5f
            L77:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r12 = r14.copy(r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r27)
                return r12
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.phase
                return r0
        }

        public final int component10() {
                r1 = this;
                int r0 = r1.attempt
                return r0
        }

        public final java.lang.String component11() {
                r1 = this;
                java.lang.String r0 = r1.lastWhy
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.method
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.step
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode component4() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r1.mode
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef component5() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r0 = r1.server
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit component6() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r1.exit
                return r0
        }

        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final long component8() {
                r2 = this;
                long r0 = r2.startedAt
                return r0
        }

        public final long component9() {
                r2 = this;
                long r0 = r2.connectedAt
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Status copy(java.lang.String r16, java.lang.String r17, java.lang.String r18, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r19, com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef r20, com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r21, java.lang.String r22, long r23, long r25, int r27, java.lang.String r28) {
                r15 = this;
                java.lang.String r0 = "phase"
                r2 = r16
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "step"
                r4 = r18
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "mode"
                r5 = r19
                kotlin.jvm.internal.j.e(r5, r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Status
                r3 = r17
                r6 = r20
                r7 = r21
                r8 = r22
                r9 = r23
                r11 = r25
                r13 = r27
                r14 = r28
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.Status
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r8
                java.lang.String r1 = r7.phase
                java.lang.String r3 = r8.phase
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.method
                java.lang.String r3 = r8.method
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r7.step
                java.lang.String r3 = r8.step
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = r7.mode
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = r8.mode
                if (r1 == r3) goto L34
                return r2
            L34:
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r1 = r7.server
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r3 = r8.server
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L3f
                return r2
            L3f:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r1 = r7.exit
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r3 = r8.exit
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4a
                return r2
            L4a:
                java.lang.String r1 = r7.error
                java.lang.String r3 = r8.error
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L55
                return r2
            L55:
                long r3 = r7.startedAt
                long r5 = r8.startedAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L5e
                return r2
            L5e:
                long r3 = r7.connectedAt
                long r5 = r8.connectedAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L67
                return r2
            L67:
                int r1 = r7.attempt
                int r3 = r8.attempt
                if (r1 == r3) goto L6e
                return r2
            L6e:
                java.lang.String r1 = r7.lastWhy
                java.lang.String r8 = r8.lastWhy
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L79
                return r2
            L79:
                return r0
        }

        public final int getAttempt() {
                r1 = this;
                int r0 = r1.attempt
                return r0
        }

        public final long getConnectedAt() {
                r2 = this;
                long r0 = r2.connectedAt
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit getExit() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r1.exit
                return r0
        }

        public final java.lang.String getLastWhy() {
                r1 = this;
                java.lang.String r0 = r1.lastWhy
                return r0
        }

        public final boolean getLive() {
                r2 = this;
                java.lang.String r0 = r2.phase
                java.lang.String r1 = "on"
                boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
                if (r0 != 0) goto L17
                java.lang.String r0 = r2.phase
                java.lang.String r1 = "lost"
                boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
                if (r0 == 0) goto L15
                goto L17
            L15:
                r0 = 0
                return r0
            L17:
                r0 = 1
                return r0
        }

        public final java.lang.String getMethod() {
                r1 = this;
                java.lang.String r0 = r1.method
                return r0
        }

        public final java.lang.String getMethodName() {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                java.lang.String r1 = r2.method
                com.mlmvpn.scanner.engines.mami.MamiEngine$Method r0 = r0.method(r1)
                if (r0 == 0) goto Lf
                java.lang.String r0 = r0.getName()
                goto L10
            Lf:
                r0 = 0
            L10:
                if (r0 != 0) goto L14
                java.lang.String r0 = ""
            L14:
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.Mode getMode() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r1.mode
                return r0
        }

        public final java.lang.String getPhase() {
                r1 = this;
                java.lang.String r0 = r1.phase
                return r0
        }

        public final com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRef getServer() {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r0 = r1.server
                return r0
        }

        public final long getStartedAt() {
                r2 = this;
                long r0 = r2.startedAt
                return r0
        }

        public final java.lang.String getStep() {
                r1 = this;
                java.lang.String r0 = r1.step
                return r0
        }

        public final java.lang.String getStepWord() {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                java.util.Map r0 = r0.getSTEP_WORDS()
                java.lang.String r1 = r2.step
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L12
                java.lang.String r0 = ""
            L12:
                return r0
        }

        public int hashCode() {
                r6 = this;
                java.lang.String r0 = r6.phase
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r6.method
                r3 = 0
                if (r2 != 0) goto L10
                r2 = r3
                goto L14
            L10:
                int r2 = r2.hashCode()
            L14:
                int r0 = r0 + r2
                int r0 = r0 * r1
                java.lang.String r2 = r6.step
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r2 = r6.mode
                int r2 = r2.hashCode()
                int r2 = r2 + r0
                int r2 = r2 * r1
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r0 = r6.server
                if (r0 != 0) goto L2a
                r0 = r3
                goto L2e
            L2a:
                int r0 = r0.hashCode()
            L2e:
                int r2 = r2 + r0
                int r2 = r2 * r1
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r6.exit
                if (r0 != 0) goto L36
                r0 = r3
                goto L3a
            L36:
                int r0 = r0.hashCode()
            L3a:
                int r2 = r2 + r0
                int r2 = r2 * r1
                java.lang.String r0 = r6.error
                if (r0 != 0) goto L42
                r0 = r3
                goto L46
            L42:
                int r0 = r0.hashCode()
            L46:
                int r2 = r2 + r0
                int r2 = r2 * r1
                long r4 = r6.startedAt
                int r0 = a6.w0.c(r2, r1, r4)
                long r4 = r6.connectedAt
                int r0 = a6.w0.c(r0, r1, r4)
                int r2 = r6.attempt
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.String r1 = r6.lastWhy
                if (r1 != 0) goto L5f
                goto L63
            L5f:
                int r3 = r1.hashCode()
            L63:
                int r0 = r0 + r3
                return r0
        }

        public java.lang.String toString() {
                r16 = this;
                r0 = r16
                java.lang.String r1 = r0.phase
                java.lang.String r2 = r0.method
                java.lang.String r3 = r0.step
                com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r4 = r0.mode
                com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r5 = r0.server
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r6 = r0.exit
                java.lang.String r7 = r0.error
                long r8 = r0.startedAt
                long r10 = r0.connectedAt
                int r12 = r0.attempt
                java.lang.String r13 = r0.lastWhy
                java.lang.String r14 = ", method="
                java.lang.String r15 = ", step="
                java.lang.String r0 = "Status(phase="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r0, r1, r14, r2, r15)
                r0.append(r3)
                java.lang.String r1 = ", mode="
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = ", server="
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ", exit="
                r0.append(r1)
                r0.append(r6)
                java.lang.String r1 = ", error="
                r0.append(r1)
                java.lang.String r1 = ", startedAt="
                androidx.media3.common.s.q(r8, r7, r1, r0)
                java.lang.String r1 = ", connectedAt="
                java.lang.String r2 = ", attempt="
                v0.a.k(r10, r1, r2, r0)
                r0.append(r12)
                java.lang.String r1 = ", lastWhy="
                r0.append(r1)
                r0.append(r13)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {496, 504, 505, 506, 507}, m = "connect")
    public static final class AnonymousClass1 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public AnonymousClass1(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                r7 = this;
                r7.result = r8
                int r8 = r7.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r8 = r8 | r0
                r7.label = r8
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = r7.this$0
                r4 = 0
                r5 = 0
                r1 = 0
                r2 = 0
                r3 = 0
                r6 = r7
                java.lang.Object r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connect(r0, r1, r2, r3, r4, r5, r6)
                return r8
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {523, 526, 544, 546, 550}, m = "connectCatalog")
    public static final class C06061 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06061(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                r6 = this;
                r6.result = r7
                int r7 = r6.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = r7 | r0
                r6.label = r7
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = r6.this$0
                r3 = 0
                r4 = 0
                r1 = 0
                r2 = 0
                r5 = r6
                java.lang.Object r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connectCatalog(r0, r1, r2, r3, r4, r5)
                return r7
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10", f = "MamiEngine.kt", l = {546}, m = "invokeSuspend")
    public static final class AnonymousClass10 extends xd.j implements ee.c {
        final /* synthetic */ kotlin.jvm.internal.y $list;
        int label;

        public AnonymousClass10(kotlin.jvm.internal.y r1, wd.d r2) {
                r0 = this;
                r0.$list = r1
                r1 = 1
                r0.<init>(r1, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(wd.d r3) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10
                kotlin.jvm.internal.y r1 = r2.$list
                r0.<init>(r1, r3)
                return r0
        }

        @Override // ee.c
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                r0 = this;
                wd.d r1 = (wd.d) r1
                java.lang.Object r1 = r0.invoke(r1)
                return r1
        }

        public final java.lang.Object invoke(wd.d r2) {
                r1 = this;
                wd.d r2 = r1.create(r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass10) r2
                sd.u r0 = sd.u.f67154a
                java.lang.Object r2 = r2.invokeSuspend(r0)
                return r2
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                r8 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                sd.m.b(r9)
                return r9
            Ld:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L15:
                sd.m.b(r9)
                com.mlmvpn.scanner.engines.mami.MamiEngine r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                kotlin.jvm.internal.y r9 = r8.$list
                java.lang.Object r9 = r9.element
                java.util.List r9 = (java.util.List) r9
                r8.label = r2
                r3 = 1
                r4 = 0
                r6 = 4
                r7 = 0
                r5 = r8
                r2 = r9
                java.lang.Object r9 = com.mlmvpn.scanner.engines.mami.MamiEngine.scout$default(r1, r2, r3, r4, r5, r6, r7)
                if (r9 != r0) goto L2f
                return r0
            L2f:
                return r9
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends xd.j implements ee.e {
        int label;

        public AnonymousClass3(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass3) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r3.label
                if (r0 != 0) goto L13
                sd.m.b(r4)
                com.mlmvpn.scanner.engines.mami.MamiApi r4 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
                r0 = 1
                r1 = 0
                r2 = 0
                sf.c r4 = com.mlmvpn.scanner.engines.mami.MamiApi.ensureSession$default(r4, r2, r0, r1)
                return r4
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {608, 611, 619, 635, 645}, m = "connectExclusive")
    public static final class C06071 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06071(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connectExclusive(r2, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06083 extends xd.j implements ee.e {
        int label;

        public C06083(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06083) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r3.label
                if (r0 != 0) goto L13
                sd.m.b(r4)
                com.mlmvpn.scanner.engines.mami.MamiApi r4 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
                r0 = 1
                r1 = 0
                r2 = 0
                sf.c r4 = com.mlmvpn.scanner.engines.mami.MamiApi.ensureSession$default(r4, r2, r0, r1)
                return r4
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {718, 719, 754, 760}, m = "connectFront")
    public static final class C06091 extends xd.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        long J$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06091(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connectFront(r2, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06103 extends xd.j implements ee.e {
        final /* synthetic */ java.lang.String $engine;
        int label;

        public C06103(java.lang.String r1, wd.d r2) {
                r0 = this;
                r0.$engine = r1
                r1 = 2
                r0.<init>(r1, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r2, wd.d r3) {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3
                java.lang.String r0 = r1.$engine
                r2.<init>(r0, r3)
                return r2
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06103) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                r5 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r5.label
                if (r0 != 0) goto L4b
                sd.m.b(r6)
                com.mlmvpn.core.tunnel.CoreConfig r6 = com.mlmvpn.core.tunnel.CoreConfig.INSTANCE
                android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                r1 = 0
                java.lang.String r2 = "app"
                if (r0 == 0) goto L47
                java.lang.String r3 = r5.$engine
                java.lang.String r6 = r6.json(r0, r3)
                android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                if (r0 == 0) goto L43
                android.content.Intent r3 = new android.content.Intent
                android.content.Context r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                if (r4 == 0) goto L3f
                java.lang.Class<com.mlmvpn.core.tunnel.TunnelVpnService> r1 = com.mlmvpn.core.tunnel.TunnelVpnService.class
                r3.<init>(r4, r1)
                java.lang.String r1 = "com.mlmvpn.core.tunnel.CONNECT"
                android.content.Intent r1 = r3.setAction(r1)
                java.lang.String r2 = "config"
                android.content.Intent r6 = r1.putExtra(r2, r6)
                v1.c.h(r0, r6)
                sd.u r6 = sd.u.f67154a
                return r6
            L3f:
                kotlin.jvm.internal.j.k(r2)
                throw r1
            L43:
                kotlin.jvm.internal.j.k(r2)
                throw r1
            L47:
                kotlin.jvm.internal.j.k(r2)
                throw r1
            L4b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {583, 586, 593, 595, 598}, m = "connectHive")
    public static final class C06111 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06111(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connectHive(r2, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06123 extends xd.j implements ee.e {
        int label;

        public C06123(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06123) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r3.label
                if (r0 != 0) goto L13
                sd.m.b(r4)
                com.mlmvpn.scanner.engines.mami.MamiApi r4 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
                r0 = 1
                r1 = 0
                r2 = 0
                sf.c r4 = com.mlmvpn.scanner.engines.mami.MamiApi.ensureSession$default(r4, r2, r0, r1)
                return r4
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8", f = "MamiEngine.kt", l = {595}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends xd.j implements ee.c {
        final /* synthetic */ kotlin.jvm.internal.y $list;
        int label;

        public AnonymousClass8(kotlin.jvm.internal.y r1, wd.d r2) {
                r0 = this;
                r0.$list = r1
                r1 = 1
                r0.<init>(r1, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(wd.d r3) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8
                kotlin.jvm.internal.y r1 = r2.$list
                r0.<init>(r1, r3)
                return r0
        }

        @Override // ee.c
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                r0 = this;
                wd.d r1 = (wd.d) r1
                java.lang.Object r1 = r0.invoke(r1)
                return r1
        }

        public final java.lang.Object invoke(wd.d r2) {
                r1 = this;
                wd.d r2 = r1.create(r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass8) r2
                sd.u r0 = sd.u.f67154a
                java.lang.Object r2 = r2.invokeSuspend(r0)
                return r2
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                sd.m.b(r4)
                return r4
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L15:
                sd.m.b(r4)
                com.mlmvpn.scanner.engines.mami.MamiEngine r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                kotlin.jvm.internal.y r1 = r3.$list
                java.lang.Object r1 = r1.element
                java.util.List r1 = (java.util.List) r1
                r3.label = r2
                java.lang.Object r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$scout(r4, r1, r2, r2, r3)
                if (r4 != r0) goto L29
                return r0
            L29:
                return r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {809}, m = "disconnectNow")
    public static final class C06131 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06131(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$disconnectNow(r2, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06143 extends xd.j implements ee.e {
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive $ex;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        public C06143(com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive r1, wd.d r2) {
                r0 = this;
                r0.$ex = r1
                r1 = 2
                r0.<init>(r1, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r3, wd.d r4) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3
                com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r1 = r2.$ex
                r0.<init>(r1, r4)
                r0.L$0 = r3
                return r0
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06143) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                r8 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r8.label
                if (r0 != 0) goto L4f
                sd.m.b(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.i0 r9 = (kotlinx.coroutines.i0) r9
                com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r9 = r8.$ex
                com.mlmvpn.scanner.engines.argo.ArgoNet r0 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE     // Catch: java.lang.Throwable -> L38
                java.lang.String r1 = "disconnect"
                java.lang.String r2 = r9.getHost()     // Catch: java.lang.Throwable -> L38
                int r3 = r9.getPort()     // Catch: java.lang.Throwable -> L38
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r4 = r9.getInfo()     // Catch: java.lang.Throwable -> L38
                com.mlmvpn.scanner.utils.LocalPort r9 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE     // Catch: java.lang.Throwable -> L38
                android.content.Context r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()     // Catch: java.lang.Throwable -> L38
                if (r5 == 0) goto L3b
                int r9 = r9.get(r5)     // Catch: java.lang.Throwable -> L38
                int r5 = r9 + 10000
                r6 = 6000(0x1770, double:2.9644E-320)
                sd.j r9 = r0.sessionRequest(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L38
                java.lang.Object r9 = sd.l.m1004constructorimpl(r9)     // Catch: java.lang.Throwable -> L38
                goto L4a
            L38:
                r0 = move-exception
                r9 = r0
                goto L42
            L3b:
                java.lang.String r9 = "app"
                kotlin.jvm.internal.j.k(r9)     // Catch: java.lang.Throwable -> L38
                r9 = 0
                throw r9     // Catch: java.lang.Throwable -> L38
            L42:
                sd.l$a r9 = sd.m.a(r9)
                java.lang.Object r9 = sd.l.m1004constructorimpl(r9)
            L4a:
                sd.l r9 = sd.l.m1003boximpl(r9)
                return r9
            L4f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {880, 882}, m = "launch")
    public static final class C06151 extends xd.c {
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06151(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$launch(r2, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3", f = "MamiEngine.kt", l = {880}, m = "invokeSuspend")
    public static final class C06163 extends xd.j implements ee.e {
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends xd.j implements ee.e {
            /* synthetic */ java.lang.Object L$0;
            int label;

            public AnonymousClass1(wd.d r2) {
                    r1 = this;
                    r0 = 2
                    r1.<init>(r0, r2)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r2, wd.d r3) {
                    r1 = this;
                    com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1
                    r0.<init>(r3)
                    r0.L$0 = r2
                    return r0
            }

            public final java.lang.Object invoke(com.mlmvpn.scanner.MyVpnService.Phase r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06163.AnonymousClass1) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    r0 = this;
                    com.mlmvpn.scanner.MyVpnService$Phase r1 = (com.mlmvpn.scanner.MyVpnService.Phase) r1
                    wd.d r2 = (wd.d) r2
                    java.lang.Object r1 = r0.invoke(r1, r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                    r1 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r0 = r1.label
                    if (r0 != 0) goto L19
                    sd.m.b(r2)
                    java.lang.Object r2 = r1.L$0
                    com.mlmvpn.scanner.MyVpnService$Phase r2 = (com.mlmvpn.scanner.MyVpnService.Phase) r2
                    com.mlmvpn.scanner.MyVpnService$Phase r0 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
                    if (r2 == r0) goto L13
                    r2 = 1
                    goto L14
                L13:
                    r2 = 0
                L14:
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                    return r2
                L19:
                    java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r2.<init>(r0)
                    throw r2
            }
        }

        public C06163(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06163) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                r4 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                sd.m.b(r5)
                return r5
            Ld:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L15:
                sd.m.b(r5)
                com.mlmvpn.scanner.MyVpnService$Companion r5 = com.mlmvpn.scanner.MyVpnService.Companion
                kotlinx.coroutines.flow.k0 r5 = r5.getConnectionPhaseFlow()
                com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3$1
                r3 = 0
                r1.<init>(r3)
                r4.label = r2
                java.lang.Object r5 = kotlinx.coroutines.flow.h.h(r5, r1, r4)
                if (r5 != r0) goto L2d
                return r0
            L2d:
                return r5
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2", f = "MamiEngine.kt", l = {419}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        final /* synthetic */ java.util.List<sd.j> $items;
        final /* synthetic */ java.lang.String $probeUrl;
        java.lang.Object L$0;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1", f = "MamiEngine.kt", l = {430}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends xd.j implements ee.e {
            final /* synthetic */ java.util.List<sd.j> $items;
            final /* synthetic */ java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> $out;
            final /* synthetic */ java.lang.String $probeUrl;
            final /* synthetic */ kotlinx.coroutines.sync.h $sem;
            private /* synthetic */ java.lang.Object L$0;
            int label;

            public AnonymousClass1(java.util.List<? extends sd.j> r1, kotlinx.coroutines.sync.h r2, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r3, java.lang.String r4, wd.d r5) {
                    r0 = this;
                    r0.$items = r1
                    r0.$sem = r2
                    r0.$out = r3
                    r0.$probeUrl = r4
                    r1 = 2
                    r0.<init>(r1, r5)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r7, wd.d r8) {
                    r6 = this;
                    com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1
                    java.util.List<sd.j> r1 = r6.$items
                    kotlinx.coroutines.sync.h r2 = r6.$sem
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r3 = r6.$out
                    java.lang.String r4 = r6.$probeUrl
                    r5 = r8
                    r0.<init>(r1, r2, r3, r4, r5)
                    r0.L$0 = r7
                    return r0
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    r0 = this;
                    kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                    wd.d r2 = (wd.d) r2
                    java.lang.Object r1 = r0.invoke(r1, r2)
                    return r1
            }

            public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass2.AnonymousClass1) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                    r11 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r1 = r11.label
                    r2 = 1
                    if (r1 == 0) goto L15
                    if (r1 != r2) goto Ld
                    sd.m.b(r12)
                    return r12
                Ld:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L15:
                    sd.m.b(r12)
                    java.lang.Object r12 = r11.L$0
                    kotlinx.coroutines.i0 r12 = (kotlinx.coroutines.i0) r12
                    java.util.List<sd.j> r1 = r11.$items
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    kotlinx.coroutines.sync.h r4 = r11.$sem
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r5 = r11.$out
                    java.lang.String r7 = r11.$probeUrl
                    java.util.ArrayList r10 = new java.util.ArrayList
                    r3 = 10
                    int r3 = kotlin.collections.s.g0(r1, r3)
                    r10.<init>(r3)
                    java.util.Iterator r1 = r1.iterator()
                L35:
                    boolean r3 = r1.hasNext()
                    if (r3 == 0) goto L5e
                    java.lang.Object r3 = r1.next()
                    sd.j r3 = (sd.j) r3
                    java.lang.Object r6 = r3.component1()
                    java.lang.String r6 = (java.lang.String) r6
                    java.lang.Object r3 = r3.component2()
                    r8 = r3
                    sf.c r8 = (sf.c) r8
                    com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1$1$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1$1$1
                    r9 = 0
                    r3.<init>(r4, r5, r6, r7, r8, r9)
                    r6 = 3
                    r8 = 0
                    kotlinx.coroutines.q0 r3 = kotlinx.coroutines.m0.c(r12, r8, r3, r6)
                    r10.add(r3)
                    goto L35
                L5e:
                    r11.label = r2
                    java.lang.Object r12 = kotlinx.coroutines.m0.d(r10, r11)
                    if (r12 != r0) goto L67
                    return r0
                L67:
                    return r12
            }
        }

        public AnonymousClass2(java.util.List<? extends sd.j> r1, java.lang.String r2, wd.d r3) {
                r0 = this;
                r0.$items = r1
                r0.$probeUrl = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r3, wd.d r4) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2
                java.util.List<sd.j> r0 = r2.$items
                java.lang.String r1 = r2.$probeUrl
                r3.<init>(r0, r1, r4)
                return r3
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass2) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                r9 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                java.lang.Object r0 = r9.L$0
                java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0
                sd.m.b(r10)
                return r0
            L11:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L19:
                sd.m.b(r10)
                com.mlmvpn.scanner.data.CombineEngine r10 = com.mlmvpn.scanner.data.CombineEngine.INSTANCE
                android.content.Context r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                if (r1 == 0) goto L4b
                r10.ensureCoreEnv(r1)
                java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap
                r6.<init>()
                kotlinx.coroutines.sync.l r5 = new kotlinx.coroutines.sync.l
                r10 = 8
                r5.<init>(r10)
                com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1
                java.util.List<sd.j> r4 = r9.$items
                java.lang.String r7 = r9.$probeUrl
                r8 = 0
                r3.<init>(r4, r5, r6, r7, r8)
                r9.L$0 = r6
                r9.label = r2
                r1 = 30000(0x7530, double:1.4822E-319)
                java.lang.Object r10 = kotlinx.coroutines.m0.L(r1, r3, r9)
                if (r10 != r0) goto L4a
                return r0
            L4a:
                return r6
            L4b:
                java.lang.String r10 = "app"
                kotlin.jvm.internal.j.k(r10)
                r10 = 0
                throw r10
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1", f = "MamiEngine.kt", l = {470}, m = "invokeSuspend")
    public static final class C06171 extends xd.j implements ee.e {
        final /* synthetic */ android.content.Context $context;
        int label;

        public C06171(android.content.Context r1, wd.d r2) {
                r0 = this;
                r0.$context = r1
                r1 = 2
                r0.<init>(r1, r2)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status d(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = invokeSuspend$lambda$0(r0)
                return r0
        }

        private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status invokeSuspend$lambda$0(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
                r15 = 1983(0x7bf, float:2.779E-42)
                r16 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                java.lang.String r8 = "هنوز فهرستی نیست — اول «به\u200cروزرسانی فهرست» را بزنید"
                r9 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r1 = r17
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
                return r0
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r2, wd.d r3) {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1
                android.content.Context r0 = r1.$context
                r2.<init>(r0, r3)
                return r2
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06171) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                r13 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r13.label
                r2 = 1
                java.lang.String r3 = ""
                sd.u r4 = sd.u.f67154a
                r5 = 0
                if (r1 == 0) goto L23
                if (r1 != r2) goto L1b
                sd.m.b(r14)     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                goto L96
            L13:
                r0 = move-exception
                r14 = r0
                goto La8
            L17:
                r0 = move-exception
                r14 = r0
                goto Ld5
            L1b:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L23:
                sd.m.b(r14)
                com.mlmvpn.scanner.engines.mami.MamiEngine r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                android.content.Context r14 = r13.$context
                r6.init(r14)
                kotlinx.coroutines.flow.k0 r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r14 = (kotlinx.coroutines.flow.g1) r14
                java.lang.Object r14 = r14.getValue()
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                int r14 = r14.length()
                if (r14 <= 0) goto L40
                return r4
            L40:
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$parsedSaved(r6)
                if (r14 != 0) goto L50
                com.mlmvpn.scanner.engines.mami.f r14 = new com.mlmvpn.scanner.engines.mami.f
                r0 = 0
                r14.<init>(r0)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setStatus(r6, r14)
                return r4
            L50:
                kotlinx.coroutines.flow.k0 r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
                r1.getClass()
                java.lang.String r7 = "measure"
                r1.k(r5, r7)
                java.util.List r14 = r14.getServers()     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                r7.<init>()     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                java.util.Iterator r14 = r14.iterator()     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
            L6d:
                boolean r1 = r14.hasNext()     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                if (r1 == 0) goto L88
                java.lang.Object r1 = r14.next()     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                r8 = r1
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r8 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r8     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                com.mlmvpn.scanner.engines.mami.MamiXrayConfig r9 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                r10 = 0
                r11 = 2
                java.lang.String r8 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.unsupportedReason$default(r9, r8, r10, r11, r5)     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                if (r8 != 0) goto L6d
                r7.add(r1)     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                goto L6d
            L88:
                r13.label = r2     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                r8 = 1
                r9 = 0
                r11 = 4
                r12 = 0
                r10 = r13
                java.lang.Object r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.scout$default(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L13 java.util.concurrent.CancellationException -> L17
                if (r14 != r0) goto L96
                return r0
            L96:
                kotlinx.coroutines.flow.k0 r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r14 = (kotlinx.coroutines.flow.g1) r14
                r14.getClass()
                r14.k(r5, r3)
                com.mlmvpn.scanner.engines.mami.MamiEngine r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r14)
                goto Ld1
            La8:
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE     // Catch: java.lang.Throwable -> Ld2
                java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> Ld2
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2
                r1.<init>()     // Catch: java.lang.Throwable -> Ld2
                java.lang.String r2 = "سنجش انجام نشد: "
                r1.append(r2)     // Catch: java.lang.Throwable -> Ld2
                r1.append(r14)     // Catch: java.lang.Throwable -> Ld2
                java.lang.String r14 = r1.toString()     // Catch: java.lang.Throwable -> Ld2
                r0.log(r14)     // Catch: java.lang.Throwable -> Ld2
                kotlinx.coroutines.flow.k0 r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r14 = (kotlinx.coroutines.flow.g1) r14
                r14.getClass()
                r14.k(r5, r3)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r0)
            Ld1:
                return r4
            Ld2:
                r0 = move-exception
                r14 = r0
                goto Ld6
            Ld5:
                throw r14     // Catch: java.lang.Throwable -> Ld2
            Ld6:
                kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
                r0.getClass()
                r0.k(r5, r3)
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r0)
                throw r14
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06181 extends xd.j implements ee.e {
        final /* synthetic */ android.content.Context $context;
        final /* synthetic */ java.lang.String $what;
        int label;

        public C06181(android.content.Context r1, java.lang.String r2, wd.d r3) {
                r0 = this;
                r0.$context = r1
                r0.$what = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status d(java.lang.Throwable r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r1) {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = invokeSuspend$lambda$0(r0, r1)
                return r0
        }

        private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status invokeSuspend$lambda$0(java.lang.Throwable r17, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r18) {
                java.lang.String r8 = r17.getMessage()
                r15 = 1983(0x7bf, float:2.779E-42)
                r16 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r1 = r18
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
                return r0
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r3, wd.d r4) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1
                android.content.Context r0 = r2.$context
                java.lang.String r1 = r2.$what
                r3.<init>(r0, r1, r4)
                return r3
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06181) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                r9 = this;
                java.lang.String r0 = "hive"
                java.lang.String r1 = ""
                java.lang.String r2 = "فهرست تازه گرفته شد: "
                java.lang.String r3 = "فهرست لیون تازه گرفته شد: "
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r4 = r9.label
                if (r4 != 0) goto L120
                sd.m.b(r10)
                com.mlmvpn.scanner.engines.mami.MamiEngine r10 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                android.content.Context r4 = r9.$context
                r10.init(r4)
                kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
                java.lang.Object r4 = r4.getValue()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                sd.u r5 = sd.u.f67154a
                if (r4 <= 0) goto L2d
                goto L45
            L2d:
                kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
                java.lang.Object r4 = r4.getValue()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r4
                java.lang.String r4 = r4.getPhase()
                java.lang.String r6 = "connecting"
                boolean r4 = kotlin.jvm.internal.j.a(r4, r6)
                if (r4 == 0) goto L46
            L45:
                return r5
            L46:
                kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                java.lang.String r6 = r9.$what
                kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
                r4.j(r6)
                r4 = 0
                r6 = 0
                com.mlmvpn.scanner.engines.mami.MamiApi r7 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r8 = 1
                com.mlmvpn.scanner.engines.mami.MamiApi.ensureSession$default(r7, r4, r8, r6)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                java.lang.String r7 = r9.$what     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                boolean r7 = kotlin.jvm.internal.j.a(r7, r0)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                if (r7 == 0) goto L90
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$hiveNow(r10, r8)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$parsedHive(r10)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                if (r2 == 0) goto L7a
                java.util.List r2 = r2.getServers()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                if (r2 == 0) goto L7a
                int r2 = r2.size()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                goto L7b
            L75:
                r10 = move-exception
                goto Lc9
            L77:
                r10 = move-exception
                goto L10d
            L7a:
                r2 = r4
            L7b:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r7.<init>(r3)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r7.append(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                java.lang.String r2 = " پل."
                r7.append(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r10.log(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                goto Lb9
            L90:
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$catalogNow(r10, r8)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$parsedSaved(r10)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                if (r3 == 0) goto La4
                java.util.List r3 = r3.getServers()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                if (r3 == 0) goto La4
                int r3 = r3.size()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                goto La5
            La4:
                r3 = r4
            La5:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r7.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r7.append(r3)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                java.lang.String r2 = " سرور."
                r7.append(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
                r10.log(r2)     // Catch: java.lang.Throwable -> L75 java.util.concurrent.CancellationException -> L77
            Lb9:
                kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
                r0.getClass()
                r0.k(r6, r1)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r10)
                return r5
            Lc9:
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE     // Catch: java.lang.Throwable -> Ld6
                java.lang.String r3 = r9.$what     // Catch: java.lang.Throwable -> Ld6
                boolean r0 = kotlin.jvm.internal.j.a(r3, r0)     // Catch: java.lang.Throwable -> Ld6
                if (r0 == 0) goto Ld8
                java.lang.String r0 = "فهرست لیون"
                goto Lda
            Ld6:
                r10 = move-exception
                goto L10e
            Ld8:
                java.lang.String r0 = "فهرست"
            Lda:
                java.lang.String r3 = r10.getMessage()     // Catch: java.lang.Throwable -> Ld6
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld6
                r7.<init>()     // Catch: java.lang.Throwable -> Ld6
                r7.append(r0)     // Catch: java.lang.Throwable -> Ld6
                java.lang.String r0 = " گرفته نشد: "
                r7.append(r0)     // Catch: java.lang.Throwable -> Ld6
                r7.append(r3)     // Catch: java.lang.Throwable -> Ld6
                java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> Ld6
                r2.log(r0)     // Catch: java.lang.Throwable -> Ld6
                com.mlmvpn.scanner.engines.mami.g r0 = new com.mlmvpn.scanner.engines.mami.g     // Catch: java.lang.Throwable -> Ld6
                r0.<init>(r4, r10)     // Catch: java.lang.Throwable -> Ld6
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setStatus(r2, r0)     // Catch: java.lang.Throwable -> Ld6
                kotlinx.coroutines.flow.k0 r10 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r10 = (kotlinx.coroutines.flow.g1) r10
                r10.getClass()
                r10.k(r6, r1)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r2)
                return r5
            L10d:
                throw r10     // Catch: java.lang.Throwable -> Ld6
            L10e:
                kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_busy$p()
                kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
                r0.getClass()
                r0.k(r6, r1)
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r0)
                throw r10
            L120:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$scout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {447}, m = "scout")
    public static final class C06191 extends xd.c {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06191(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
                r2 = this;
                r2.result = r3
                int r3 = r2.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r3 | r0
                r2.label = r3
                com.mlmvpn.scanner.engines.mami.MamiEngine r3 = r2.this$0
                r0 = 0
                r1 = 0
                java.lang.Object r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$scout(r3, r0, r1, r1, r2)
                return r3
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$settleAfterRegister$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {565, 567}, m = "settleAfterRegister")
    public static final class C06201 extends xd.c {
        int I$0;
        int I$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06201(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$settleAfterRegister(r2, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1", f = "MamiEngine.kt", l = {955, 974, 974, 979}, m = "invokeSuspend")
    public static final class C06211 extends xd.j implements ee.e {
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
        public static final class C00671 extends xd.j implements ee.e {
            final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive $ex;
            int label;

            public C00671(com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive r1, wd.d r2) {
                    r0 = this;
                    r0.$ex = r1
                    r1 = 2
                    r0.<init>(r1, r2)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r2, wd.d r3) {
                    r1 = this;
                    com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1
                    com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r0 = r1.$ex
                    r2.<init>(r0, r3)
                    return r2
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    r0 = this;
                    kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                    wd.d r2 = (wd.d) r2
                    java.lang.Object r1 = r0.invoke(r1, r2)
                    return r1
            }

            public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06211.C00671) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                    r11 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r0 = r11.label
                    if (r0 != 0) goto L3e
                    sd.m.b(r12)
                    com.mlmvpn.scanner.engines.argo.ArgoNet r1 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
                    com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r12 = r11.$ex
                    java.lang.String r3 = r12.getHost()
                    com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r12 = r11.$ex
                    int r4 = r12.getPort()
                    com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r12 = r11.$ex
                    com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r5 = r12.getInfo()
                    com.mlmvpn.scanner.utils.LocalPort r12 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
                    android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                    if (r0 == 0) goto L37
                    int r12 = r12.get(r0)
                    int r6 = r12 + 10000
                    r9 = 32
                    r10 = 0
                    java.lang.String r2 = "keepalive"
                    r7 = 0
                    sd.j r12 = com.mlmvpn.scanner.engines.argo.ArgoNet.sessionRequest$default(r1, r2, r3, r4, r5, r6, r7, r9, r10)
                    return r12
                L37:
                    java.lang.String r12 = "app"
                    kotlin.jvm.internal.j.k(r12)
                    r12 = 0
                    throw r12
                L3e:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5", f = "MamiEngine.kt", l = {995}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends xd.j implements ee.e {
            final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Live $l;
            final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs $p;
            int label;

            public AnonymousClass5(com.mlmvpn.scanner.engines.mami.MamiEngine.Live r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs r2, wd.d r3) {
                    r0 = this;
                    r0.$l = r1
                    r0.$p = r2
                    r1 = 2
                    r0.<init>(r1, r3)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r3, wd.d r4) {
                    r2 = this;
                    com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Live r0 = r2.$l
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r1 = r2.$p
                    r3.<init>(r0, r1, r4)
                    return r3
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    r0 = this;
                    kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                    wd.d r2 = (wd.d) r2
                    java.lang.Object r1 = r0.invoke(r1, r2)
                    return r1
            }

            public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06211.AnonymousClass5) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                    r8 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r1 = r8.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    sd.m.b(r9)     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    goto L5f
                Ld:
                    r0 = move-exception
                    r9 = r0
                    goto L48
                L10:
                    r0 = move-exception
                    r9 = r0
                    goto L62
                L13:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L1b:
                    sd.m.b(r9)
                    com.mlmvpn.scanner.engines.mami.MamiEngine r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    r9 = r2
                    java.lang.String r2 = "auto"
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Live r3 = r8.$l     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = r3.getMode()     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r4 = r8.$p     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    java.lang.String r5 = r4.getLocation()     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Live r4 = r8.$l     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r4 = r4.getCand()     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    java.lang.String r4 = r4.getId()     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    java.util.List r6 = m9.d.B(r4)     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    r8.label = r9     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    r4 = 0
                    r7 = r8
                    java.lang.Object r9 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$connect(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Ld java.util.concurrent.CancellationException -> L10
                    if (r9 != r0) goto L5f
                    return r0
                L48:
                    com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                    java.lang.String r9 = r9.getMessage()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "جابه\u200cجایی سرور نشد: "
                    r1.<init>(r2)
                    r1.append(r9)
                    java.lang.String r9 = r1.toString()
                    r0.log(r9)
                L5f:
                    sd.u r9 = sd.u.f67154a
                    return r9
                L62:
                    throw r9
            }
        }

        public C06211(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status d(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = invokeSuspend$lambda$2(r0)
                return r0
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status f(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r1) {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = invokeSuspend$lambda$1(r0, r1)
                return r0
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status g(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = invokeSuspend$lambda$0(r0)
                return r0
        }

        private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status invokeSuspend$lambda$0(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
                r15 = 2046(0x7fe, float:2.867E-42)
                r16 = 0
                java.lang.String r2 = "on"
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r1 = r17
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
                return r0
        }

        private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status invokeSuspend$lambda$1(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r17, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r18) {
                r15 = 2015(0x7df, float:2.824E-42)
                r16 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r7 = r17
                r1 = r18
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
                return r0
        }

        private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status invokeSuspend$lambda$2(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
                r15 = 2046(0x7fe, float:2.867E-42)
                r16 = 0
                java.lang.String r2 = "lost"
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r1 = r17
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
                return r0
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r2, wd.d r3) {
                r1 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1
                r0.<init>(r3)
                r0.L$0 = r2
                return r0
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06211) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
                r31 = this;
                r0 = r31
                kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 5000(0x1388, double:2.4703E-320)
                r5 = 0
                r7 = 4
                r8 = 3
                r9 = 2
                java.lang.String r10 = "xray"
                r12 = 1
                r13 = 0
                if (r2 == 0) goto L80
                if (r2 == r12) goto L6d
                if (r2 == r9) goto L56
                if (r2 == r8) goto L3f
                if (r2 != r7) goto L37
                long r14 = r0.J$0
                int r2 = r0.I$1
                int r11 = r0.I$0
                java.lang.Object r7 = r0.L$2
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r7 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r7
                java.lang.Object r8 = r0.L$1
                com.mlmvpn.scanner.engines.mami.MamiEngine$Live r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Live) r8
                java.lang.Object r9 = r0.L$0
                kotlinx.coroutines.i0 r9 = (kotlinx.coroutines.i0) r9
                sd.m.b(r32)
                r20 = r3
                r6 = 4
                r3 = r32
                goto L1b8
            L37:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L3f:
                long r7 = r0.J$0
                int r2 = r0.I$1
                int r9 = r0.I$0
                java.lang.Object r11 = r0.L$1
                com.mlmvpn.scanner.engines.mami.MamiEngine$Live r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Live) r11
                java.lang.Object r14 = r0.L$0
                kotlinx.coroutines.i0 r14 = (kotlinx.coroutines.i0) r14
                sd.m.b(r32)
                r20 = r3
                r3 = r32
                goto L174
            L56:
                long r7 = r0.J$0
                int r2 = r0.I$1
                int r9 = r0.I$0
                java.lang.Object r11 = r0.L$1
                com.mlmvpn.scanner.engines.mami.MamiEngine$Live r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Live) r11
                java.lang.Object r14 = r0.L$0
                kotlinx.coroutines.i0 r14 = (kotlinx.coroutines.i0) r14
                sd.m.b(r32)
                r20 = r3
                r3 = r32
                goto L14e
            L6d:
                long r7 = r0.J$0
                int r2 = r0.I$1
                int r9 = r0.I$0
                java.lang.Object r11 = r0.L$0
                kotlinx.coroutines.i0 r11 = (kotlinx.coroutines.i0) r11
                sd.m.b(r32)
                r30 = r11
                r11 = r2
                r2 = r30
                goto La6
            L80:
                sd.m.b(r32)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.i0 r2 = (kotlinx.coroutines.i0) r2
                r7 = r5
                r9 = 0
            L89:
                r11 = 0
            L8a:
                boolean r14 = kotlinx.coroutines.m0.t(r2)
                if (r14 == 0) goto L333
                r0.L$0 = r2
                r0.L$1 = r13
                r0.L$2 = r13
                r0.I$0 = r9
                r0.I$1 = r11
                r0.J$0 = r7
                r0.label = r12
                java.lang.Object r14 = kotlinx.coroutines.m0.j(r3, r0)
                if (r14 != r1) goto La6
                goto L1b7
            La6:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Live r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getLive$p()
                if (r14 != 0) goto Lae
                goto L333
            Lae:
                com.mlmvpn.scanner.ui.tunnel.TunnelController r15 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE
                kotlinx.coroutines.flow.e1 r15 = r15.getState()
                java.lang.Object r15 = r15.getValue()
                com.mlmvpn.scanner.ui.tunnel.TunnelUiState r15 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r15
                r20 = r3
                java.lang.String r3 = r14.getKind()
                java.lang.String r4 = "front"
                boolean r3 = kotlin.jvm.internal.j.a(r3, r4)
                if (r3 == 0) goto Lfc
                com.mlmvpn.scanner.ui.tunnel.TunnelStage r3 = r15.getStage()
                com.mlmvpn.scanner.ui.tunnel.TunnelStage r4 = com.mlmvpn.scanner.ui.tunnel.TunnelStage.RUNNING
                if (r3 != r4) goto Lfc
                java.lang.String r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getFrontTransport$p()
                if (r3 == 0) goto Lfc
                com.mlmvpn.scanner.ui.tunnel.Transport r3 = r15.getActive()
                if (r3 == 0) goto Le1
                java.lang.String r3 = r3.getId()
                goto Le2
            Le1:
                r3 = r13
            Le2:
                if (r3 == 0) goto Lfc
                com.mlmvpn.scanner.ui.tunnel.Transport r3 = r15.getActive()
                if (r3 == 0) goto Lef
                java.lang.String r3 = r3.getId()
                goto Lf0
            Lef:
                r3 = r13
            Lf0:
                java.lang.String r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getFrontTransport$p()
                boolean r3 = kotlin.jvm.internal.j.a(r3, r4)
                if (r3 != 0) goto Lfc
                r3 = r12
                goto Lfd
            Lfc:
                r3 = 0
            Lfd:
                java.lang.String r4 = r14.getKind()
                boolean r4 = kotlin.jvm.internal.j.a(r4, r10)
                if (r4 == 0) goto L111
                com.mlmvpn.scanner.engines.mami.MamiEngine r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                boolean r4 = r4.isOurs()
                if (r4 != 0) goto L11d
                goto L2be
            L111:
                if (r3 != 0) goto L2be
                com.mlmvpn.scanner.engines.mami.MamiEngine r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                boolean r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$frontUp(r4)
                if (r4 != 0) goto L11d
                goto L2be
            L11d:
                long r7 = r7 + r20
                r3 = 60000(0xea60, double:2.9644E-319)
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 < 0) goto L2ba
                int r9 = r9 + 1
                java.lang.String r3 = r14.getKind()
                boolean r3 = kotlin.jvm.internal.j.a(r3, r10)
                if (r3 == 0) goto L159
                com.mlmvpn.scanner.engines.mami.MamiEngine r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                r0.L$0 = r2
                r0.L$1 = r14
                r0.I$0 = r9
                r0.I$1 = r11
                r0.J$0 = r5
                r4 = 2
                r0.label = r4
                java.lang.Object r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$traceHttp(r3, r0)
                if (r3 != r1) goto L149
                goto L1b7
            L149:
                r7 = r14
                r14 = r2
                r2 = r11
                r11 = r7
                r7 = r5
            L14e:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r3
            L150:
                r30 = r11
                r11 = r9
                r9 = r14
                r14 = r7
                r8 = r30
                r7 = r3
                goto L177
            L159:
                com.mlmvpn.scanner.engines.mami.MamiEngine r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                r0.L$0 = r2
                r0.L$1 = r14
                r0.I$0 = r9
                r0.I$1 = r11
                r0.J$0 = r5
                r4 = 3
                r0.label = r4
                java.lang.Object r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$traceFront(r3, r0)
                if (r3 != r1) goto L16f
                goto L1b7
            L16f:
                r7 = r14
                r14 = r2
                r2 = r11
                r11 = r7
                r7 = r5
            L174:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r3
                goto L150
            L177:
                com.mlmvpn.scanner.engines.mami.MamiEngine$Live r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getLive$p()
                if (r3 != r8) goto L333
                com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getExclusiveLive$p()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r4 = r8.getCand()
                if (r4 == 0) goto L18c
                java.lang.String r4 = r4.getId()
                goto L18d
            L18c:
                r4 = r13
            L18d:
                java.lang.String r5 = "exclusive"
                boolean r4 = kotlin.jvm.internal.j.a(r4, r5)
                if (r4 == 0) goto L1e0
                if (r3 == 0) goto L1e0
                int r4 = r11 % 10
                if (r4 != 0) goto L1e0
                oe.e r4 = kotlinx.coroutines.v0.f24208c
                com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1 r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1
                r5.<init>(r3, r13)
                r0.L$0 = r9
                r0.L$1 = r8
                r0.L$2 = r7
                r0.I$0 = r11
                r0.I$1 = r2
                r0.J$0 = r14
                r6 = 4
                r0.label = r6
                java.lang.Object r3 = kotlinx.coroutines.m0.J(r4, r5, r0)
                if (r3 != r1) goto L1b8
            L1b7:
                return r1
            L1b8:
                sd.j r3 = (sd.j) r3
                java.lang.Object r4 = r3.component1()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                java.lang.Object r3 = r3.component2()
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                com.mlmvpn.scanner.engines.mami.MamiEngine r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                if (r4 == 0) goto L1d5
                java.lang.String r3 = "نشست با پل اختصاصی تمدید شد."
                goto L1dd
            L1d5:
                java.lang.String r4 = "تمدید نشست پل جواب نداد (کد "
                java.lang.String r6 = ")."
                java.lang.String r3 = androidx.compose.foundation.interaction.f.o(r3, r4, r6)
            L1dd:
                r5.log(r3)
            L1e0:
                if (r7 == 0) goto L21e
                kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
                java.lang.Object r2 = r2.getValue()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r2
                java.lang.String r2 = r2.getPhase()
                java.lang.String r3 = "lost"
                boolean r2 = kotlin.jvm.internal.j.a(r2, r3)
                if (r2 == 0) goto L20a
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.f r3 = new com.mlmvpn.scanner.engines.mami.f
                r4 = 1
                r3.<init>(r4)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setStatus(r2, r3)
                java.lang.String r3 = "اتصال دوباره داده رد می\u200cکند."
                r2.log(r3)
            L20a:
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.h r3 = new com.mlmvpn.scanner.engines.mami.h
                r4 = 0
                r3.<init>(r7, r4)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setStatus(r2, r3)
                r2 = r9
                r9 = r11
                r7 = r14
                r3 = r20
                r5 = 0
                goto L89
            L21e:
                int r2 = r2 + r12
                r4 = 2
                if (r2 < r4) goto L24a
                kotlinx.coroutines.flow.k0 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.g1 r3 = (kotlinx.coroutines.flow.g1) r3
                java.lang.Object r3 = r3.getValue()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r3
                java.lang.String r3 = r3.getPhase()
                java.lang.String r5 = "on"
                boolean r3 = kotlin.jvm.internal.j.a(r3, r5)
                if (r3 == 0) goto L24a
                com.mlmvpn.scanner.engines.mami.MamiEngine r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.f r5 = new com.mlmvpn.scanner.engines.mami.f
                r6 = 2
                r5.<init>(r6)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setStatus(r3, r5)
                java.lang.String r5 = "دو آزمون پیاپی از داخل اتصال جواب نداد."
                r3.log(r5)
            L24a:
                r3 = 3
                if (r2 < r3) goto L2ae
                java.lang.String r3 = r8.getKind()
                boolean r3 = kotlin.jvm.internal.j.a(r3, r10)
                if (r3 == 0) goto L2ac
                kotlinx.coroutines.flow.k0 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.g1 r3 = (kotlinx.coroutines.flow.g1) r3
                java.lang.Object r3 = r3.getValue()
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r3
                java.lang.String r3 = r3.getMethod()
                java.lang.String r5 = "auto"
                boolean r3 = kotlin.jvm.internal.j.a(r3, r5)
                if (r3 == 0) goto L2ac
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r3 = r8.getCand()
                if (r3 == 0) goto L2ac
                com.mlmvpn.scanner.engines.mami.MamiEngine r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r2 = r8.getCand()
                java.lang.String r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$placeLabel(r1, r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "سرور "
                r3.<init>(r4)
                r3.append(r2)
                java.lang.String r2 = " جواب نمی\u200cدهد — رفتن به سرور بعدی…"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.log(r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r1 = r1.prefs()
                kotlinx.coroutines.i0 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getScope$p()
                com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5
                r3.<init>(r8, r1, r13)
                r5 = 3
                kotlinx.coroutines.q2 r1 = kotlinx.coroutines.m0.y(r2, r13, r13, r3, r5)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setConnectJob$p(r1)
                goto L333
            L2ac:
                r5 = 3
                goto L2af
            L2ae:
                r5 = r3
            L2af:
                r3 = r11
                r11 = r2
                r2 = r9
                r9 = r3
                r7 = r14
                r3 = r20
                r5 = 0
                goto L8a
            L2ba:
                r3 = r20
                goto L8a
            L2be:
                java.lang.String r1 = r14.getKind()
                boolean r1 = kotlin.jvm.internal.j.a(r1, r10)
                java.lang.String r2 = "replaced"
                if (r1 == 0) goto L2da
                com.mlmvpn.scanner.MyVpnService$Companion r1 = com.mlmvpn.scanner.MyVpnService.Companion
                kotlinx.coroutines.flow.k0 r1 = r1.getConnectionPhaseFlow()
                kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
                java.lang.Object r1 = r1.getValue()
                com.mlmvpn.scanner.MyVpnService$Phase r4 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
                if (r1 == r4) goto L2dc
            L2da:
                if (r3 == 0) goto L2df
            L2dc:
                r27 = r2
                goto L2e3
            L2df:
                java.lang.String r1 = "stopped"
                r27 = r1
            L2e3:
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setLive$p(r13)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setFrontMarker$p(r13)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$setExclusiveLive$p(r13)
                kotlinx.coroutines.flow.k0 r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.k0 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$get_status$p()
                kotlinx.coroutines.flow.g1 r3 = (kotlinx.coroutines.flow.g1) r3
                java.lang.Object r3 = r3.getValue()
                r14 = r3
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r14 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r14
                r28 = 986(0x3da, float:1.382E-42)
                r29 = 0
                java.lang.String r15 = "off"
                r16 = 0
                java.lang.String r17 = ""
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r24 = 0
                r26 = 0
                com.mlmvpn.scanner.engines.mami.MamiEngine$Status r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29)
                r4 = r27
                kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
                r1.j(r3)
                com.mlmvpn.scanner.engines.mami.MamiEngine r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                boolean r2 = r4.equals(r2)
                if (r2 == 0) goto L32b
                java.lang.String r2 = "اتصال دیگری موتور را برداشت؛ مامی قطع شد."
                goto L32d
            L32b:
                java.lang.String r2 = "موتور مامی خاموش شد."
            L32d:
                r1.log(r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$bump(r1)
            L333:
                sd.u r1 = sd.u.f67154a
                return r1
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2", f = "MamiEngine.kt", l = {922}, m = "invokeSuspend")
    public static final class C06222 extends xd.j implements ee.e {
        long J$0;
        java.lang.Object L$0;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2", f = "MamiEngine.kt", l = {922}, m = "invokeSuspend")
        public static final class C00682 extends xd.j implements ee.e {
            final /* synthetic */ com.mlmvpn.scanner.ui.tunnel.TunnelController $tc;
            int label;

            public C00682(com.mlmvpn.scanner.ui.tunnel.TunnelController r1, wd.d r2) {
                    r0 = this;
                    r0.$tc = r1
                    r1 = 2
                    r0.<init>(r1, r2)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r2, wd.d r3) {
                    r1 = this;
                    com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2
                    com.mlmvpn.scanner.ui.tunnel.TunnelController r0 = r1.$tc
                    r2.<init>(r0, r3)
                    return r2
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                    r0 = this;
                    kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                    wd.d r2 = (wd.d) r2
                    java.lang.Object r1 = r0.invoke(r1, r2)
                    return r1
            }

            public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06222.C00682) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                    r5 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L12
                    if (r1 != r2) goto La
                    goto L12
                La:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L12:
                    sd.m.b(r6)
                L15:
                    com.mlmvpn.scanner.ui.tunnel.TunnelController r6 = r5.$tc
                    kotlinx.coroutines.flow.e1 r6 = r6.getState()
                    java.lang.Object r6 = r6.getValue()
                    com.mlmvpn.scanner.ui.tunnel.TunnelUiState r6 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r6
                    java.lang.String r6 = r6.getExitIp()
                    if (r6 == 0) goto L31
                    boolean r6 = kotlin.text.o.L0(r6)
                    if (r6 == 0) goto L2e
                    goto L31
                L2e:
                    sd.u r6 = sd.u.f67154a
                    return r6
                L31:
                    r5.label = r2
                    r3 = 300(0x12c, double:1.48E-321)
                    java.lang.Object r6 = kotlinx.coroutines.m0.j(r3, r5)
                    if (r6 != r0) goto L15
                    return r0
            }
        }

        public C06222(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06222) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                r7 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                long r0 = r7.J$0
                java.lang.Object r2 = r7.L$0
                com.mlmvpn.scanner.ui.tunnel.TunnelController r2 = (com.mlmvpn.scanner.ui.tunnel.TunnelController) r2
                sd.m.b(r8)
                goto L67
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                sd.m.b(r8)
                com.mlmvpn.core.tunnel.TunnelStatus r8 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE
                int r8 = r8.getActiveSocksPort()
                r1 = 0
                if (r8 <= 0) goto L43
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                java.net.Proxy r2 = new java.net.Proxy
                java.net.Proxy$Type r3 = java.net.Proxy.Type.SOCKS
                java.net.InetSocketAddress r4 = new java.net.InetSocketAddress
                java.lang.String r5 = "127.0.0.1"
                r4.<init>(r5, r8)
                r2.<init>(r3, r4)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$trace(r0, r2)
                if (r8 == 0) goto L42
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$realExit(r0, r8)
                return r8
            L42:
                return r1
            L43:
                com.mlmvpn.scanner.engines.mami.MamiEngine r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                boolean r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$frontUp(r8)
                if (r8 == 0) goto L9d
                com.mlmvpn.scanner.ui.tunnel.TunnelController r8 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE
                long r3 = java.lang.System.currentTimeMillis()
                com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2 r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2
                r5.<init>(r8, r1)
                r7.L$0 = r8
                r7.J$0 = r3
                r7.label = r2
                r1 = 6000(0x1770, double:2.9644E-320)
                java.lang.Object r1 = kotlinx.coroutines.m0.L(r1, r5, r7)
                if (r1 != r0) goto L65
                return r0
            L65:
                r2 = r8
                r0 = r3
            L67:
                kotlinx.coroutines.flow.e1 r8 = r2.getState()
                java.lang.Object r8 = r8.getValue()
                com.mlmvpn.scanner.ui.tunnel.TunnelUiState r8 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r8
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Exit
                java.lang.String r3 = r8.getCountry()
                java.lang.String r4 = ""
                if (r3 != 0) goto L7c
                r3 = r4
            L7c:
                java.lang.String r5 = r8.getExitIp()
                if (r5 != 0) goto L83
                goto L84
            L83:
                r4 = r5
            L84:
                java.lang.String r8 = r8.getExitIp()
                if (r8 == 0) goto L97
                boolean r8 = kotlin.text.o.L0(r8)
                if (r8 == 0) goto L91
                goto L97
            L91:
                long r5 = java.lang.System.currentTimeMillis()
                long r5 = r5 - r0
                goto L99
            L97:
                r5 = 0
            L99:
                r2.<init>(r3, r4, r5)
                return r2
            L9d:
                return r1
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06232 extends xd.j implements ee.e {
        int label;

        public C06232(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06232) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                r5 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r5.label
                if (r0 != 0) goto L33
                sd.m.b(r6)
                com.mlmvpn.scanner.engines.mami.MamiEngine r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                java.net.Proxy r0 = new java.net.Proxy
                java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP
                java.net.InetSocketAddress r2 = new java.net.InetSocketAddress
                com.mlmvpn.scanner.utils.LocalPort r3 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
                android.content.Context r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                if (r4 == 0) goto L2c
                int r3 = r3.get(r4)
                int r3 = r3 + 10000
                java.lang.String r4 = "127.0.0.1"
                r2.<init>(r4, r3)
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$trace(r6, r0)
                return r6
            L2c:
                java.lang.String r6 = "app"
                kotlin.jvm.internal.j.k(r6)
                r6 = 0
                throw r6
            L33:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {680, 686, 687, 690}, m = "tryServers")
    public static final class C06241 extends xd.c {
        int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06241(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                r6 = this;
                r6.result = r7
                int r7 = r6.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = r7 | r0
                r6.label = r7
                com.mlmvpn.scanner.engines.mami.MamiEngine r0 = r6.this$0
                r3 = 0
                r4 = 0
                r1 = 0
                r2 = 0
                r5 = r6
                java.lang.Object r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$tryServers(r0, r1, r2, r3, r4, r5)
                return r7
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06253 extends xd.j implements ee.e {
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Cand $c;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow $routePlace;
        int label;

        public C06253(com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r1, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r2, wd.d r3) {
                r0 = this;
                r0.$c = r1
                r0.$routePlace = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r3, wd.d r4) {
                r2 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r0 = r2.$c
                com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r1 = r2.$routePlace
                r3.<init>(r0, r1, r4)
                return r3
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06253) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
                r2 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r2.label
                if (r0 != 0) goto L15
                sd.m.b(r3)
                com.mlmvpn.scanner.engines.mami.MamiEngine r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
                com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r0 = r2.$c
                com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r1 = r2.$routePlace
                com.mlmvpn.scanner.engines.mami.MamiEngine.access$applyRoute(r3, r0, r1)
                sd.u r3 = sd.u.f67154a
                return r3
            L15:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5", f = "MamiEngine.kt", l = {686}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends xd.j implements ee.e {
        int label;

        public AnonymousClass5(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5
                r1.<init>(r2)
                return r1
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1, java.lang.Object r2) {
                r0 = this;
                kotlinx.coroutines.i0 r1 = (kotlinx.coroutines.i0) r1
                wd.d r2 = (wd.d) r2
                java.lang.Object r1 = r0.invoke(r1, r2)
                return r1
        }

        public final java.lang.Object invoke(kotlinx.coroutines.i0 r1, wd.d r2) {
                r0 = this;
                wd.d r1 = r0.create(r1, r2)
                com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass5) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                sd.m.b(r4)
                goto L29
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L15:
                sd.m.b(r4)
                com.mlmvpn.scanner.ui.tunnel.TunnelExclusion r4 = com.mlmvpn.scanner.ui.tunnel.TunnelExclusion.INSTANCE
                android.content.Context r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$getApp$p()
                if (r1 == 0) goto L2c
                r3.label = r2
                java.lang.Object r4 = r4.releaseForXray(r1, r3)
                if (r4 != r0) goto L29
                return r0
            L29:
                sd.u r4 = sd.u.f67154a
                return r4
            L2c:
                java.lang.String r4 = "app"
                kotlin.jvm.internal.j.k(r4)
                r4 = 0
                throw r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$verify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {777, 779}, m = "verify")
    public static final class C06261 extends xd.c {
        int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine this$0;

        public C06261(com.mlmvpn.scanner.engines.mami.MamiEngine r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                r1 = this;
                r1.result = r2
                int r2 = r1.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r0
                r1.label = r2
                com.mlmvpn.scanner.engines.mami.MamiEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.access$verify(r2, r0, r1)
                return r2
        }
    }

    static {
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine
            r0.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r7 = 1
            java.lang.String r8 = "بهترین سرور فهرست رمزشدهٔ مامی، با سنجش واقعی تأخیر"
            java.lang.String r2 = "auto"
            java.lang.String r3 = "auto"
            java.lang.String r4 = "خودکار"
            java.lang.String r5 = "xray"
            r6 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r8 = 1
            java.lang.String r9 = "پلی که سرور مامی برای همین دستگاه می\u200cسازد"
            java.lang.String r3 = "exclusive"
            java.lang.String r4 = "service:exclusive"
            java.lang.String r5 = "اختصاصی"
            java.lang.String r6 = "xray"
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r9 = 1
            java.lang.String r10 = "شبکهٔ جهانی با مسیرهای پنهان"
            java.lang.String r4 = "meteor"
            java.lang.String r5 = "service:meteor"
            java.lang.String r6 = "سان"
            java.lang.String r7 = "front"
            java.lang.String r8 = "geph"
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r4 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r10 = 1
            java.lang.String r11 = "پل\u200cهایی که دستگاه\u200cهای دیگر آزموده\u200cاند"
            java.lang.String r5 = "hive"
            java.lang.String r6 = "service:hive"
            java.lang.String r7 = "لیون"
            java.lang.String r8 = "xray"
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r11 = 1
            java.lang.String r12 = "خودش بهترین راه را پیدا می\u200cکند"
            java.lang.String r6 = "smart"
            java.lang.String r7 = "service:smart"
            java.lang.String r8 = "هوشمند"
            java.lang.String r9 = "front"
            java.lang.String r10 = "lantern"
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r6 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Method
            r12 = 1
            java.lang.String r13 = "ناشناس و چندلایه، با پل\u200cهای خودش"
            java.lang.String r7 = "tor"
            java.lang.String r8 = "service:tor"
            java.lang.String r9 = "تایگر"
            java.lang.String r10 = "front"
            java.lang.String r11 = "tor"
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method[] r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine.Method[]{r1, r2, r3, r4, r5, r6}
            java.util.List r0 = kotlin.collections.r.a0(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine.METHODS = r0
            sd.j r1 = new sd.j
            java.lang.String r0 = "session"
            java.lang.String r2 = "بررسی نشست این دستگاه با سرور مامی…"
            r1.<init>(r0, r2)
            sd.j r2 = new sd.j
            java.lang.String r0 = "catalog"
            java.lang.String r3 = "گرفتن فهرست سرورها (رمزشده و امضاشده)…"
            r2.<init>(r0, r3)
            sd.j r3 = new sd.j
            java.lang.String r0 = "hive"
            java.lang.String r4 = "گرفتن فهرست پل\u200cهای لیون…"
            r3.<init>(r0, r4)
            sd.j r4 = new sd.j
            java.lang.String r0 = "bridge"
            java.lang.String r5 = "گرفتن پل اختصاصی این دستگاه…"
            r4.<init>(r0, r5)
            sd.j r5 = new sd.j
            java.lang.String r0 = "auth"
            java.lang.String r6 = "احراز هویت با پل اختصاصی…"
            r5.<init>(r0, r6)
            sd.j r6 = new sd.j
            java.lang.String r0 = "scout"
            java.lang.String r7 = "سنجش سرورها برای انتخاب بهترین…"
            r6.<init>(r0, r7)
            sd.j r7 = new sd.j
            java.lang.String r0 = "engine"
            java.lang.String r8 = "راه\u200cاندازی موتور…"
            r7.<init>(r0, r8)
            sd.j r8 = new sd.j
            java.lang.String r0 = "verify"
            java.lang.String r9 = "آزمون عبور داده (یک درخواست واقعی HTTPS)…"
            r8.<init>(r0, r9)
            sd.j r9 = new sd.j
            java.lang.String r0 = "route"
            java.lang.String r10 = "روشن کردن مسیر انتخاب\u200cشده…"
            r9.<init>(r0, r10)
            sd.j[] r0 = new sd.j[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.Map r0 = kotlin.collections.d0.J(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine.STEP_WORDS = r0
            kotlinx.coroutines.r2 r0 = kotlinx.coroutines.m0.b()
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            wd.i r0 = g8.a.D(r1, r0)
            kotlinx.coroutines.internal.e r0 = kotlinx.coroutines.m0.a(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine.scope = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Status
            r15 = 2047(0x7ff, float:2.868E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r1)
            com.mlmvpn.scanner.engines.mami.MamiEngine._status = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine.status = r0
            kotlin.collections.w r0 = kotlin.collections.w.INSTANCE
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine._logs = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine.logs = r0
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine._version = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine.version = r0
            java.lang.String r0 = ""
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine._busy = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine.busy = r0
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = new com.mlmvpn.scanner.utils.ConnectionOwner
            r0.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine.connectionOwner = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine.delays = r0
            java.lang.String r9 = "Tor"
            java.lang.String r10 = "تور"
            java.lang.String r1 = "ArgoVPN"
            java.lang.String r2 = "Argo"
            java.lang.String r3 = "آرگو"
            java.lang.String r4 = "Geph5"
            java.lang.String r5 = "Geph"
            java.lang.String r6 = "گف"
            java.lang.String r7 = "Lantern"
            java.lang.String r8 = "لنترن"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r0 = kotlin.collections.r.a0(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine.ENGINE_NAMES = r0
            r0 = 8
            com.mlmvpn.scanner.engines.mami.MamiEngine.$stable = r0
            return
    }

    private MamiEngine() {
            r0 = this;
            r0.<init>()
            return
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status a(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectFront$lambda$78(r0)
            return r0
    }

    public static final /* synthetic */ void access$applyRoute(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r1, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r2) {
            r0.applyRoute(r1, r2)
            return
    }

    public static final /* synthetic */ void access$bump(com.mlmvpn.scanner.engines.mami.MamiEngine r0) {
            r0.bump()
            return
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed access$catalogNow(com.mlmvpn.scanner.engines.mami.MamiEngine r0, boolean r1) {
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = r0.catalogNow(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connect(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.lang.String r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, java.lang.String r3, java.lang.String r4, java.util.List r5, wd.d r6) {
            java.lang.Object r0 = r0.connect(r1, r2, r3, r4, r5, r6)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connectCatalog(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r1, java.lang.String r2, java.lang.String r3, java.util.List r4, wd.d r5) {
            java.lang.Object r0 = r0.connectCatalog(r1, r2, r3, r4, r5)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connectExclusive(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r1, wd.d r2) {
            java.lang.Object r0 = r0.connectExclusive(r1, r2)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connectFront(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Method r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, wd.d r3) {
            java.lang.Object r0 = r0.connectFront(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connectHive(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r1, java.util.List r2, wd.d r3) {
            java.lang.Object r0 = r0.connectHive(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$disconnectNow(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.lang.String r1, wd.d r2) {
            java.lang.Object r0 = r0.disconnectNow(r1, r2)
            return r0
    }

    public static final /* synthetic */ boolean access$frontUp(com.mlmvpn.scanner.engines.mami.MamiEngine r0) {
            boolean r0 = r0.frontUp()
            return r0
    }

    public static final /* synthetic */ android.content.Context access$getApp$p() {
            android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive access$getExclusiveLive$p() {
            com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.exclusiveLive
            return r0
    }

    public static final /* synthetic */ java.lang.String access$getFrontTransport$p() {
            java.lang.String r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.frontTransport
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Live access$getLive$p() {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.live
            return r0
    }

    public static final /* synthetic */ kotlinx.coroutines.i0 access$getScope$p() {
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            return r0
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.k0 access$get_busy$p() {
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._busy
            return r0
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.k0 access$get_status$p() {
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive access$hiveNow(com.mlmvpn.scanner.engines.mami.MamiEngine r0, boolean r1) {
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r0 = r0.hiveNow(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$launch(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.lang.String r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, wd.d r3) {
            java.lang.Object r0 = r0.launch(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$measure(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.util.List r1, java.lang.String r2, wd.d r3) {
            java.lang.Object r0 = r0.measure(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive access$parsedHive(com.mlmvpn.scanner.engines.mami.MamiEngine r0) {
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r0 = r0.parsedHive()
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed access$parsedSaved(com.mlmvpn.scanner.engines.mami.MamiEngine r0) {
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = r0.parsedSaved()
            return r0
    }

    public static final /* synthetic */ java.lang.String access$placeLabel(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r1) {
            java.lang.String r0 = r0.placeLabel(r1)
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Exit access$realExit(com.mlmvpn.scanner.engines.mami.MamiEngine r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r1) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r0.realExit(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$scout(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.util.List r1, boolean r2, boolean r3, wd.d r4) {
            java.lang.Object r0 = r0.scout(r1, r2, r3, r4)
            return r0
    }

    public static final /* synthetic */ void access$setConnectJob$p(kotlinx.coroutines.s1 r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine.connectJob = r0
            return
    }

    public static final /* synthetic */ void access$setExclusiveLive$p(com.mlmvpn.scanner.engines.mami.MamiEngine.ExclusiveLive r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine.exclusiveLive = r0
            return
    }

    public static final /* synthetic */ void access$setFrontMarker$p(java.lang.String r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker = r0
            return
    }

    public static final /* synthetic */ void access$setLive$p(com.mlmvpn.scanner.engines.mami.MamiEngine.Live r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine.live = r0
            return
    }

    public static final /* synthetic */ void access$setStatus(com.mlmvpn.scanner.engines.mami.MamiEngine r0, ee.c r1) {
            r0.setStatus(r1)
            return
    }

    public static final /* synthetic */ java.lang.Object access$settleAfterRegister(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.util.List r1, ee.c r2, wd.d r3) {
            java.lang.Object r0 = r0.settleAfterRegister(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ java.lang.String access$testConfig(com.mlmvpn.scanner.engines.mami.MamiEngine r0, sf.c r1) {
            java.lang.String r0 = r0.testConfig(r1)
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Exit access$trace(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.net.Proxy r1) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = r0.trace(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$traceFront(com.mlmvpn.scanner.engines.mami.MamiEngine r0, wd.d r1) {
            java.lang.Object r0 = r0.traceFront(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$traceHttp(com.mlmvpn.scanner.engines.mami.MamiEngine r0, wd.d r1) {
            java.lang.Object r0 = r0.traceHttp(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$tryServers(com.mlmvpn.scanner.engines.mami.MamiEngine r0, java.util.List r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r2, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r3, boolean r4, wd.d r5) {
            java.lang.Object r0 = r0.tryServers(r1, r2, r3, r4, r5)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$verify(com.mlmvpn.scanner.engines.mami.MamiEngine r0, ee.c r1, wd.d r2) {
            java.lang.Object r0 = r0.verify(r1, r2)
            return r0
    }

    private final void applyRoute(com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r4, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r5) {
            r3 = this;
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r4 = r4.getServer()
            if (r4 != 0) goto L8
            goto L95
        L8:
            sd.j r0 = r3.confirmedRoute()
            if (r5 == 0) goto L4d
            java.lang.String r4 = r4.getProfile()
            java.lang.String r5 = r5.getId()
            sd.j r1 = new sd.j
            r1.<init>(r4, r5)
            boolean r4 = kotlin.jvm.internal.j.a(r0, r1)
            if (r4 == 0) goto L22
            goto L95
        L22:
            com.mlmvpn.scanner.engines.mami.MamiApi r4 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Exception -> L38
            java.lang.Object r5 = r1.getFirst()     // Catch: java.lang.Exception -> L38
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L38
            java.lang.Object r0 = r1.getSecond()     // Catch: java.lang.Exception -> L38
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L38
            r2 = 1
            r4.route(r5, r0, r2)     // Catch: java.lang.Exception -> L38
            r3.saveRoute(r1)
            return
        L38:
            r4 = move-exception
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.String r4 = r4.getMessage()
            java.lang.String r0 = "انتخاب مکان به سرور مامی گفته نشد ("
            java.lang.String r1 = ") — اتصال لغو شد"
            java.lang.String r4 = a6.w0.n(r0, r4, r1)
            java.lang.String r0 = "ROUTE_FAILED"
            r5.<init>(r0, r4)
            throw r5
        L4d:
            if (r0 == 0) goto L95
            java.lang.String r5 = r4.getProfile()
            java.lang.String r4 = r4.getLocationId()
            sd.j r1 = new sd.j
            r1.<init>(r5, r4)
            boolean r4 = r0.equals(r1)
            if (r4 == 0) goto L63
            goto L95
        L63:
            com.mlmvpn.scanner.engines.mami.MamiApi r4 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Exception -> L7a
            java.lang.Object r5 = r1.getFirst()     // Catch: java.lang.Exception -> L7a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L7a
            java.lang.Object r0 = r1.getSecond()     // Catch: java.lang.Exception -> L7a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L7a
            r1 = 0
            r4.route(r5, r0, r1)     // Catch: java.lang.Exception -> L7a
            r4 = 0
            r3.saveRoute(r4)     // Catch: java.lang.Exception -> L7a
            return
        L7a:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "برگشت به مکانِ خود سرور به سرور مامی گفته نشد ("
            r5.<init>(r0)
            r5.append(r4)
            java.lang.String r4 = ")."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.log(r4)
        L95:
            return
    }

    public static /* synthetic */ kotlinx.coroutines.s1 b(android.content.Context r0, java.lang.String r1, java.util.List r2) {
            kotlinx.coroutines.s1 r0 = connectAsync$lambda$43(r0, r1, r2)
            return r0
    }

    private final void bump() {
            r3 = this;
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._version
            r1 = r0
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            int r1 = r1 + 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            r0.getClass()
            r2 = 0
            r0.k(r2, r1)
            return
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status c(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectExclusive$lambda$68(r0)
            return r0
    }

    private final com.mlmvpn.scanner.engines.mami.MamiEngine.Cand candOf(com.mlmvpn.scanner.engines.mami.MamiCatalog.Server r13, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r14) {
            r12 = this;
            sd.j r0 = r12.placeOfServer(r13)
            java.lang.Object r1 = r0.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.component2()
            java.lang.String r0 = (java.lang.String) r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Cand
            java.lang.String r3 = r13.getId()
            com.mlmvpn.scanner.engines.mami.MamiXrayConfig r4 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE
            r8 = 4
            r9 = 0
            java.lang.String r6 = "proxy"
            r7 = 0
            r5 = r13
            sf.c r13 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.outboundFor$default(r4, r5, r6, r7, r8, r9)
            r4 = r5
            if (r14 == 0) goto L2e
            java.lang.String r5 = r14.getCc()
            if (r5 != 0) goto L2c
            goto L2e
        L2c:
            r6 = r5
            goto L33
        L2e:
            java.lang.String r5 = r4.getCountryCode()
            goto L2c
        L33:
            if (r14 == 0) goto L3e
            java.lang.String r5 = r14.getCountry()
            if (r5 != 0) goto L3c
            goto L3e
        L3c:
            r7 = r5
            goto L3f
        L3e:
            r7 = r1
        L3f:
            if (r14 == 0) goto L4a
            java.lang.String r14 = r14.getCity()
            if (r14 != 0) goto L48
            goto L4a
        L48:
            r8 = r14
            goto L4b
        L4a:
            r8 = r0
        L4b:
            java.lang.String r9 = r4.getLocationId()
            java.lang.String r10 = r4.getProtocol()
            java.lang.String r11 = r4.getProfile()
            r5 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
    }

    private final com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed catalogNow(boolean r12) {
            r11 = this;
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> Lb
            sf.c r0 = r0.savedCatalog()     // Catch: java.lang.Throwable -> Lb
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lb
            goto L14
        Lb:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        L14:
            boolean r1 = sd.l.m1010isFailureimpl(r0)
            r2 = 0
            if (r1 == 0) goto L1c
            r0 = r2
        L1c:
            sf.c r0 = (sf.c) r0
            java.lang.String r1 = "payload"
            if (r0 == 0) goto L27
            sf.c r3 = r0.w(r1)
            goto L28
        L27:
            r3 = r2
        L28:
            r4 = 1
            if (r3 == 0) goto L42
            java.lang.String r3 = "expiresAt"
            r5 = 0
            long r5 = r0.x(r5, r3)
            com.mlmvpn.scanner.engines.mami.MamiApi r3 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
            long r7 = r3.nowSec()
            r9 = 300(0x12c, double:1.48E-321)
            long r7 = r7 + r9
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L42
            r3 = r4
            goto L43
        L42:
            r3 = 0
        L43:
            if (r12 != 0) goto L47
            if (r3 != 0) goto L73
        L47:
            com.mlmvpn.scanner.engines.mami.MamiApi r12 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Exception -> L4d
            com.mlmvpn.scanner.engines.mami.MamiApi.fetchCatalog$default(r12, r2, r4, r2)     // Catch: java.lang.Exception -> L4d
            goto L70
        L4d:
            r12 = move-exception
            if (r0 == 0) goto L54
            sf.c r2 = r0.w(r1)
        L54:
            if (r2 == 0) goto L82
            java.lang.String r12 = r12.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "فهرست تازه گرفته نشد ("
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود."
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.log(r12)
        L70:
            r11.bump()
        L73:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r12 = r11.parsedSaved()
            if (r12 == 0) goto L7a
            return r12
        L7a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "فهرست سرورهای مامی خوانده نشد"
            r12.<init>(r0)
            throw r12
        L82:
            throw r12
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed catalogNow$default(com.mlmvpn.scanner.engines.mami.MamiEngine r0, boolean r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L5
            r1 = 0
        L5:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = r0.catalogNow(r1)
            return r0
    }

    private final void check() {
            r2 = this;
            boolean r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled
            if (r0 != 0) goto L5
            return
        L5:
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.String r1 = "لغو شد"
            r0.<init>(r1)
            throw r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status clearError$lambda$88(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 1983(0x7bf, float:2.779E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private final sf.c clientInfo() {
            r9 = this;
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = ""
            if (r0 != 0) goto L7
            r0 = r1
        L7:
            java.lang.CharSequence r0 = kotlin.text.o.n1(r0)
            java.lang.String r0 = r0.toString()
            r2 = 80
            java.lang.String r0 = kotlin.text.o.l1(r2, r0)
            int r2 = r0.length()
            r3 = 2
            if (r2 >= r3) goto L1e
            java.lang.String r0 = "Android device"
        L1e:
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            if (r2 != 0) goto L23
            goto L24
        L23:
            r1 = r2
        L24:
            r2 = 24
            java.lang.String r1 = kotlin.text.o.l1(r2, r1)
            boolean r2 = kotlin.text.o.L0(r1)
            if (r2 == 0) goto L36
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L36:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = r2.getLanguage()
            java.lang.String r2 = r2.getCountry()
            java.lang.String[] r2 = new java.lang.String[]{r3, r2}
            java.util.List r2 = kotlin.collections.r.a0(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L55:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L6f
            java.lang.Object r4 = r2.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            kotlin.jvm.internal.j.b(r5)
            boolean r5 = kotlin.text.o.L0(r5)
            if (r5 != 0) goto L55
            r3.add(r4)
            goto L55
        L6f:
            r7 = 0
            r8 = 62
            java.lang.String r4 = "-"
            r5 = 0
            r6 = 0
            java.lang.String r2 = kotlin.collections.q.F0(r3, r4, r5, r6, r7, r8)
            boolean r3 = kotlin.text.o.L0(r2)
            if (r3 == 0) goto L82
            java.lang.String r2 = "en"
        L82:
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()
            java.lang.String r3 = r3.getID()
            boolean r4 = kotlin.text.o.L0(r3)
            if (r4 == 0) goto L92
            java.lang.String r3 = "UTC"
        L92:
            java.lang.String r4 = "deviceModel"
            java.lang.String r5 = "androidVersion"
            sf.c r0 = com.mlmvpn.core.aether.i.p(r4, r0, r5, r1)
            java.lang.String r1 = "appVersionCode"
            r4 = 56
            java.lang.String r5 = "appVersionName"
            java.lang.String r6 = "1.0.12"
            com.mlmvpn.core.aether.i.s(r4, r5, r6, r1, r0)
            java.lang.String r1 = "locale"
            r0.D(r1, r2)
            java.lang.String r1 = "timezone"
            r0.D(r1, r3)
            return r0
    }

    private final java.lang.String config(sf.c r17) {
            r16 = this;
            com.mlmvpn.scanner.utils.LocalPort r0 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r1 == 0) goto L197
            int r0 = r0.get(r1)
            java.lang.String r1 = "remarks"
            java.lang.String r2 = "mlm-mami-v1"
            sf.c r1 = com.mlmvpn.core.aether.i.o(r1, r2)
            sf.c r2 = new sf.c
            r2.<init>()
            java.lang.String r3 = "loglevel"
            java.lang.String r4 = "warning"
            r2.D(r3, r4)
            java.lang.String r3 = "log"
            r1.D(r3, r2)
            sf.a r2 = new sf.a
            r2.<init>()
            java.lang.String r3 = "socks"
            java.lang.String r4 = "tag"
            sf.c r3 = com.mlmvpn.core.aether.i.o(r4, r3)
            java.lang.String r5 = "port"
            java.lang.String r6 = "listen"
            java.lang.String r7 = "127.0.0.1"
            com.mlmvpn.scanner.e.q(r0, r5, r6, r7, r3)
            java.lang.String r8 = "auth"
            java.lang.String r9 = "noauth"
            java.lang.String r10 = "protocol"
            java.lang.String r11 = "mixed"
            sf.c r8 = com.mlmvpn.scanner.e.n(r3, r10, r11, r8, r9)
            java.lang.String r9 = "udp"
            r11 = 1
            r8.E(r9, r11)
            java.lang.String r12 = "settings"
            r3.D(r12, r8)
            sf.c r8 = new sf.c
            r8.<init>()
            java.lang.String r12 = "enabled"
            r8.E(r12, r11)
            sf.a r11 = new sf.a
            r11.<init>()
            java.lang.String r12 = "http"
            r11.put(r12)
            java.lang.String r13 = "tls"
            r11.put(r13)
            java.lang.String r13 = "destOverride"
            r8.D(r13, r11)
            java.lang.String r11 = "sniffing"
            r3.D(r11, r8)
            r2.put(r3)
            sf.c r3 = new sf.c
            r3.<init>()
            r3.D(r4, r12)
            int r0 = r0 + 10000
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.D(r5, r0)
            r3.D(r6, r7)
            r3.D(r10, r12)
            r2.put(r3)
            java.lang.String r0 = "inbounds"
            r1.D(r0, r2)
            com.mlmvpn.scanner.utils.XrayJsonGenerator r0 = com.mlmvpn.scanner.utils.XrayJsonGenerator.INSTANCE
            sf.c r2 = r0.quicRefusalOutbound()
            sf.a r3 = new sf.a
            r3.<init>()
            sf.c r6 = new sf.c
            java.lang.String r7 = r17.toString()
            r6.<init>(r7)
            java.lang.String r7 = "proxy"
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r4, r7, r3, r6)
            java.lang.String r8 = "direct"
            r6.D(r4, r8)
            java.lang.String r11 = "freedom"
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r10, r11, r3, r6)
            java.lang.String r11 = "dns-out"
            r6.D(r4, r11)
            java.lang.String r12 = "dns"
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r10, r12, r3, r6)
            java.lang.String r13 = "blocked"
            r6.D(r4, r13)
            java.lang.String r14 = "blackhole"
            r6.D(r10, r14)
            r3.put(r6)
            if (r2 == 0) goto Ld7
            r3.put(r2)
        Ld7:
            java.lang.String r6 = "outbounds"
            r1.D(r6, r3)
            sf.c r3 = new sf.c
            r3.<init>()
            java.lang.String r6 = "mami-dns"
            r3.D(r4, r6)
            sf.a r10 = new sf.a
            r10.<init>()
            sf.c r14 = new sf.c
            r14.<init>()
            java.lang.String r15 = "https://8.8.8.8/dns-query"
            r17 = r13
            java.lang.String r13 = "address"
            r14.D(r13, r15)
            r10.put(r14)
            sf.c r14 = new sf.c
            r14.<init>()
            java.lang.String r15 = "https://1.1.1.1/dns-query"
            r14.D(r13, r15)
            r10.put(r14)
            java.lang.String r13 = "servers"
            r3.D(r13, r10)
            java.lang.String r10 = "queryStrategy"
            java.lang.String r13 = "UseIPv4"
            r3.D(r10, r13)
            r1.D(r12, r3)
            sf.a r3 = new sf.a
            r3.<init>()
            java.lang.String r10 = "53"
            java.lang.String r12 = "type"
            java.lang.String r13 = "field"
            sf.c r10 = com.mlmvpn.core.aether.i.p(r12, r13, r5, r10)
            java.lang.String r14 = "outboundTag"
            sf.c r10 = com.mlmvpn.scanner.e.o(r10, r14, r11, r3, r10)
            r10.D(r12, r13)
            sf.a r11 = new sf.a
            r11.<init>()
            r11.put(r6)
            java.lang.String r6 = "inboundTag"
            r10.D(r6, r11)
            sf.c r6 = com.mlmvpn.scanner.e.o(r10, r14, r7, r3, r10)
            r6.D(r12, r13)
            sf.a r7 = new sf.a
            r7.<init>()
            java.lang.String r10 = "geoip:private"
            r7.put(r10)
            java.lang.String r10 = "ip"
            r6.D(r10, r7)
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r14, r8, r3, r6)
            r6.D(r12, r13)
            java.lang.String r7 = "network"
            r6.D(r7, r9)
            java.lang.String r7 = "443"
            r6.D(r5, r7)
            if (r2 == 0) goto L171
            java.lang.String r5 = ""
            java.lang.String r4 = r2.A(r4, r5)
            if (r4 != 0) goto L16f
            goto L171
        L16f:
            r13 = r4
            goto L173
        L171:
            r13 = r17
        L173:
            sf.c r4 = com.mlmvpn.scanner.e.o(r6, r14, r13, r3, r6)
            java.lang.String r5 = "domainStrategy"
            java.lang.String r6 = "AsIs"
            r4.D(r5, r6)
            java.lang.String r5 = "rules"
            r4.D(r5, r3)
            java.lang.String r3 = "routing"
            r1.D(r3, r4)
            if (r2 == 0) goto L18d
            r0.addQuicRefusalPolicyTo(r1)
        L18d:
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        L197:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            r0 = 0
            throw r0
    }

    private final sd.j confirmedRoute() {
            r5 = this;
            android.content.SharedPreferences r0 = r5.sp()
            java.lang.String r1 = "route"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L61
            sf.c r1 = new sf.c     // Catch: java.lang.Throwable -> L17
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L17
            java.lang.Object r0 = sd.l.m1004constructorimpl(r1)     // Catch: java.lang.Throwable -> L17
            goto L20
        L17:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        L20:
            boolean r1 = sd.l.m1010isFailureimpl(r0)
            if (r1 == 0) goto L27
            r0 = r2
        L27:
            sf.c r0 = (sf.c) r0
            if (r0 == 0) goto L61
            java.lang.String r1 = "profile"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.A(r1, r3)
            java.lang.String r4 = "locationId"
            java.lang.String r0 = r0.A(r4, r3)
            sd.j r3 = new sd.j
            r3.<init>(r1, r0)
            java.lang.Object r0 = r3.getFirst()
            java.lang.String r1 = "<get-first>(...)"
            kotlin.jvm.internal.j.d(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.o.L0(r0)
            if (r0 != 0) goto L61
            java.lang.Object r0 = r3.getSecond()
            java.lang.String r1 = "<get-second>(...)"
            kotlin.jvm.internal.j.d(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.o.L0(r0)
            if (r0 != 0) goto L61
            r2 = r3
        L61:
            return r2
    }

    private final java.lang.Object connect(java.lang.String r36, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r37, java.lang.String r38, java.lang.String r39, java.util.List<java.lang.String> r40, wd.d r41) {
            r35 = this;
            r1 = r35
            r0 = r41
            sd.u r2 = sd.u.f67154a
            boolean r3 = r0 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass1
            if (r3 == 0) goto L19
            r3 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$connect$1 r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.mlmvpn.scanner.engines.mami.MamiEngine$connect$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connect$1
            r3.<init>(r1, r0)
        L1e:
            java.lang.Object r0 = r3.result
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r5 = r3.label
            r7 = 5
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 1
            r12 = 0
            if (r5 == 0) goto L6f
            if (r5 == r11) goto L50
            if (r5 == r10) goto L36
            if (r5 == r9) goto L36
            if (r5 == r8) goto L36
            if (r5 != r7) goto L48
        L36:
            java.lang.Object r4 = r3.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r4
            java.lang.Object r3 = r3.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r3
            sd.m.b(r0)     // Catch: java.lang.Throwable -> L43
            goto L237
        L43:
            r0 = move-exception
            r16 = 0
            goto L1be
        L48:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L50:
            java.lang.Object r5 = r3.L$5
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r5
            java.lang.Object r13 = r3.L$4
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r3.L$3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r3.L$2
            java.lang.String r15 = (java.lang.String) r15
            r16 = 0
            java.lang.Object r6 = r3.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r6
            java.lang.Object r7 = r3.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r7 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r7
            sd.m.b(r0)
            r0 = r6
            goto Lb6
        L6f:
            r16 = 0
            sd.m.b(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r5 = r35.method(r36)
            if (r5 != 0) goto L7b
            return r2
        L7b:
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r0
            boolean r0 = r0.getLive()
            if (r0 == 0) goto Lab
            r3.L$0 = r1
            r0 = r37
            r3.L$1 = r0
            r6 = r38
            r3.L$2 = r6
            r7 = r39
            r3.L$3 = r7
            r13 = r40
            r3.L$4 = r13
            r3.L$5 = r5
            r3.label = r11
            java.lang.String r14 = "switch"
            java.lang.Object r14 = r1.disconnectNow(r14, r3)
            if (r14 != r4) goto Lb3
            goto L1b5
        Lab:
            r0 = r37
            r6 = r38
            r7 = r39
            r13 = r40
        Lb3:
            r15 = r6
            r14 = r7
            r7 = r1
        Lb6:
            com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled = r16
            java.lang.String r6 = r5.getKind()
            java.lang.String r11 = "front"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r11)
            if (r6 == 0) goto Lc9
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
            r21 = r6
            goto Lcb
        Lc9:
            r21 = r0
        Lcb:
            kotlinx.coroutines.flow.k0 r6 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r17 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Status
            java.lang.String r19 = r5.getKey()
            java.lang.String r8 = r5.getKind()
            java.lang.String r9 = "xray"
            boolean r8 = kotlin.jvm.internal.j.a(r8, r9)
            if (r8 == 0) goto Le4
            java.lang.String r8 = "session"
        Le1:
            r20 = r8
            goto Le7
        Le4:
            java.lang.String r8 = "engine"
            goto Le1
        Le7:
            long r25 = java.lang.System.currentTimeMillis()
            r31 = 1904(0x770, float:2.668E-42)
            r32 = 0
            java.lang.String r18 = "connecting"
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31, r32)
            r9 = r17
            r8 = r21
            kotlinx.coroutines.flow.g1 r6 = (kotlinx.coroutines.flow.g1) r6
            r6.getClass()
            r6.k(r12, r9)
            java.lang.String r6 = r5.getName()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r9 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
            if (r8 != r9) goto L117
            java.lang.String r8 = "تونل کامل"
            goto L119
        L117:
            java.lang.String r8 = "پراکسی"
        L119:
            java.lang.String r9 = "» ("
            java.lang.String r10 = ")…"
            java.lang.String r12 = "اتصال با روش «"
            java.lang.String r6 = org.telegram.ui.Cells.d1.h(r12, r6, r9, r8, r10)
            r7.log(r6)
            java.lang.String r6 = r5.getKind()     // Catch: java.lang.Throwable -> L1bb
            boolean r6 = kotlin.jvm.internal.j.a(r6, r11)     // Catch: java.lang.Throwable -> L1bb
            if (r6 == 0) goto L14d
            r3.L$0 = r7     // Catch: java.lang.Throwable -> L148
            r3.L$1 = r5     // Catch: java.lang.Throwable -> L148
            r6 = 0
            r3.L$2 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$3 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$4 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$5 = r6     // Catch: java.lang.Throwable -> L148
            r6 = 2
            r3.label = r6     // Catch: java.lang.Throwable -> L148
            java.lang.Object r0 = r7.connectFront(r5, r0, r3)     // Catch: java.lang.Throwable -> L148
            if (r0 != r4) goto L237
            goto L1b5
        L148:
            r0 = move-exception
            r4 = r5
            r3 = r7
            goto L1be
        L14d:
            java.lang.String r6 = r5.getKey()     // Catch: java.lang.Throwable -> L1bb
            java.lang.String r8 = "hive"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r8)     // Catch: java.lang.Throwable -> L1bb
            if (r6 == 0) goto L170
            r3.L$0 = r7     // Catch: java.lang.Throwable -> L148
            r3.L$1 = r5     // Catch: java.lang.Throwable -> L148
            r6 = 0
            r3.L$2 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$3 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$4 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$5 = r6     // Catch: java.lang.Throwable -> L148
            r6 = 3
            r3.label = r6     // Catch: java.lang.Throwable -> L148
            java.lang.Object r0 = r7.connectHive(r0, r13, r3)     // Catch: java.lang.Throwable -> L148
            if (r0 != r4) goto L237
            goto L1b5
        L170:
            java.lang.String r6 = r5.getKey()     // Catch: java.lang.Throwable -> L1bb
            java.lang.String r8 = "exclusive"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r8)     // Catch: java.lang.Throwable -> L1bb
            if (r6 == 0) goto L193
            r3.L$0 = r7     // Catch: java.lang.Throwable -> L148
            r3.L$1 = r5     // Catch: java.lang.Throwable -> L148
            r6 = 0
            r3.L$2 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$3 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$4 = r6     // Catch: java.lang.Throwable -> L148
            r3.L$5 = r6     // Catch: java.lang.Throwable -> L148
            r6 = 4
            r3.label = r6     // Catch: java.lang.Throwable -> L148
            java.lang.Object r0 = r7.connectExclusive(r0, r3)     // Catch: java.lang.Throwable -> L148
            if (r0 != r4) goto L237
            goto L1b5
        L193:
            r3.L$0 = r7     // Catch: java.lang.Throwable -> L1bb
            r3.L$1 = r5     // Catch: java.lang.Throwable -> L1bb
            r6 = 0
            r3.L$2 = r6     // Catch: java.lang.Throwable -> L1bb
            r3.L$3 = r6     // Catch: java.lang.Throwable -> L1bb
            r3.L$4 = r6     // Catch: java.lang.Throwable -> L1bb
            r3.L$5 = r6     // Catch: java.lang.Throwable -> L1bb
            r6 = 5
            r3.label = r6     // Catch: java.lang.Throwable -> L1bb
            r37 = r0
            r41 = r3
            r36 = r7
            r40 = r13
            r39 = r14
            r38 = r15
            java.lang.Object r0 = r36.connectCatalog(r37, r38, r39, r40, r41)     // Catch: java.lang.Throwable -> L1b6
            if (r0 != r4) goto L237
        L1b5:
            return r4
        L1b6:
            r0 = move-exception
            r3 = r36
        L1b9:
            r4 = r5
            goto L1be
        L1bb:
            r0 = move-exception
            r3 = r7
            goto L1b9
        L1be:
            boolean r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled
            if (r5 != 0) goto L1cc
            boolean r5 = r0 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L1c7
            goto L1cc
        L1c7:
            r6 = r16
        L1c9:
            r18 = 0
            goto L1ce
        L1cc:
            r6 = 1
            goto L1c9
        L1ce:
            com.mlmvpn.scanner.engines.mami.MamiEngine.live = r18
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker = r18
            java.lang.String r5 = r0.getMessage()
            if (r5 != 0) goto L1da
            java.lang.String r5 = "وصل نشد"
        L1da:
            java.lang.String r4 = r4.getName()
            java.lang.String r4 = r3.unnamed$app_release(r5, r4)
            kotlinx.coroutines.flow.k0 r5 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            r7 = r5
            kotlinx.coroutines.flow.g1 r7 = (kotlinx.coroutines.flow.g1) r7
            java.lang.Object r7 = r7.getValue()
            r19 = r7
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r19 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r19
            if (r6 == 0) goto L1f4
            r26 = r18
            goto L1f6
        L1f4:
            r26 = r4
        L1f6:
            r33 = 1978(0x7ba, float:2.772E-42)
            r34 = 0
            java.lang.String r20 = "off"
            r21 = 0
            java.lang.String r22 = ""
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r33, r34)
            kotlinx.coroutines.flow.g1 r5 = (kotlinx.coroutines.flow.g1) r5
            r5.j(r7)
            if (r6 != 0) goto L22a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "وصل نشد: "
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.log(r4)
        L22a:
            r3.bump()
            boolean r3 = r0 instanceof java.util.concurrent.CancellationException
            if (r3 == 0) goto L237
            boolean r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled
            if (r3 == 0) goto L236
            goto L237
        L236:
            throw r0
        L237:
            return r2
    }

    public static kotlinx.coroutines.s1 connectAsync$default(com.mlmvpn.scanner.engines.mami.MamiEngine r0, android.content.Context r1, java.lang.String r2, java.util.List r3, int r4, java.lang.Object r5) {
            r5 = r4 & 2
            if (r5 == 0) goto L5
            r2 = 0
        L5:
            r4 = r4 & 4
            if (r4 == 0) goto Lb
            kotlin.collections.w r3 = kotlin.collections.w.INSTANCE
        Lb:
            kotlinx.coroutines.s1 r0 = r0.connectAsync(r1, r2, r3)
            return r0
    }

    private static final kotlinx.coroutines.s1 connectAsync$lambda$43(android.content.Context r2, java.lang.String r3, java.util.List r4) {
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            r0.init(r2)
            kotlinx.coroutines.s1 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.connectJob
            r0 = 0
            if (r2 == 0) goto Ld
            r2.cancel(r0)
        Ld:
            kotlinx.coroutines.s1 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.watchJob
            if (r2 == 0) goto L14
            r2.cancel(r0)
        L14:
            kotlinx.coroutines.i0 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectAsync$1$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectAsync$1$1
            r1.<init>(r3, r4, r0)
            r3 = 3
            kotlinx.coroutines.q2 r2 = kotlinx.coroutines.m0.y(r2, r0, r0, r1, r3)
            com.mlmvpn.scanner.engines.mami.MamiEngine.connectJob = r2
            return r2
    }

    private final java.lang.Object connectCatalog(com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r18, java.lang.String r19, java.lang.String r20, java.util.List<java.lang.String> r21, wd.d r22) {
            r17 = this;
            r0 = r17
            r1 = r22
            boolean r2 = r1 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06061
            if (r2 == 0) goto L18
            r2 = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$1 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06061) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r7 = r2
            goto L1e
        L18:
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$1
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r7.result
            kotlin.coroutines.intrinsics.a r2 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r3 = r7.label
            r11 = 5
            r12 = 4
            r4 = 1
            r13 = 3
            r5 = 2
            r14 = 0
            if (r3 == 0) goto La3
            if (r3 == r4) goto L87
            if (r3 == r5) goto L6d
            if (r3 == r13) goto L58
            if (r3 == r12) goto L43
            if (r3 != r11) goto L3b
            sd.m.b(r1)
            goto L308
        L3b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L43:
            java.lang.Object r3 = r7.L$3
            kotlin.jvm.internal.y r3 = (kotlin.jvm.internal.y) r3
            java.lang.Object r4 = r7.L$2
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            java.lang.Object r5 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r5
            java.lang.Object r6 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r1)
            goto L268
        L58:
            java.lang.Object r3 = r7.L$3
            kotlin.jvm.internal.y r3 = (kotlin.jvm.internal.y) r3
            java.lang.Object r4 = r7.L$2
            kotlin.jvm.internal.y r4 = (kotlin.jvm.internal.y) r4
            java.lang.Object r5 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r5
            java.lang.Object r6 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r1)
            goto L24b
        L6d:
            java.lang.Object r3 = r7.L$4
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r7.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r7.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r8
            java.lang.Object r9 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r9
            sd.m.b(r1)
            r15 = r8
            goto L100
        L87:
            java.lang.Object r3 = r7.L$4
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r7.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r7.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r8
            java.lang.Object r9 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r9
            sd.m.b(r1)
            r15 = r8
            r8 = r6
            r6 = r15
            r15 = r3
            goto Ld5
        La3:
            sd.m.b(r1)
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 8
            r1.<init>(r3)
            r0.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3
            r3.<init>(r14)
            r7.L$0 = r0
            r6 = r18
            r7.L$1 = r6
            r8 = r19
            r7.L$2 = r8
            r9 = r20
            r7.L$3 = r9
            r15 = r21
            r7.L$4 = r15
            r7.label = r4
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r3, r7)
            if (r1 != r2) goto Ld3
            goto L307
        Ld3:
            r4 = r9
            r9 = r0
        Ld5:
            r9.check()
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 9
            r1.<init>(r3)
            r9.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$parsed$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$parsed$1
            r3.<init>(r14)
            r7.L$0 = r9
            r7.L$1 = r6
            r7.L$2 = r8
            r7.L$3 = r4
            r7.L$4 = r15
            r7.label = r5
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r3, r7)
            if (r1 != r2) goto Lfd
            goto L307
        Lfd:
            r3 = r15
            r15 = r6
            r6 = r8
        L100:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r1 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed) r1
            r9.check()
            kotlin.jvm.internal.y r8 = new kotlin.jvm.internal.y
            r8.<init>()
            java.util.List r1 = r1.getServers()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r1 = r1.iterator()
        L119:
            boolean r16 = r1.hasNext()
            if (r16 == 0) goto L137
            java.lang.Object r10 = r1.next()
            r12 = r10
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r12 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r12
            com.mlmvpn.scanner.engines.mami.MamiXrayConfig r13 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE
            r0 = 0
            java.lang.String r0 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.unsupportedReason$default(r13, r12, r0, r5, r14)
            if (r0 != 0) goto L132
            r11.add(r10)
        L132:
            r0 = r17
            r12 = 4
            r13 = 3
            goto L119
        L137:
            r8.element = r11
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L323
            kotlin.jvm.internal.y r0 = new kotlin.jvm.internal.y
            r0.<init>()
            boolean r1 = kotlin.text.o.L0(r4)
            if (r1 != 0) goto L176
            java.util.List r1 = r9.locations()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L154:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L16c
            java.lang.Object r5 = r1.next()
            r10 = r5
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r10 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r10
            java.lang.String r10 = r10.getId()
            boolean r10 = kotlin.jvm.internal.j.a(r10, r4)
            if (r10 == 0) goto L154
            goto L16d
        L16c:
            r5 = r14
        L16d:
            r0.element = r5
            if (r5 != 0) goto L176
            java.lang.String r1 = "مکان انتخاب\u200cشده در فهرست فعلی نیست؛ مکانِ خود سرور به کار می\u200cرود."
            r9.log(r1)
        L176:
            if (r6 == 0) goto L1b6
            boolean r1 = kotlin.text.o.L0(r6)
            if (r1 == 0) goto L17f
            goto L1b6
        L17f:
            java.lang.Object r1 = r8.element
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L187:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L19f
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r4 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = kotlin.jvm.internal.j.a(r4, r6)
            if (r4 == 0) goto L187
            goto L1a0
        L19f:
            r3 = r14
        L1a0:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r3 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r3
            if (r3 == 0) goto L1ac
            java.util.List r1 = m9.d.B(r3)
            r3 = r9
            r5 = r15
            goto L2c2
        L1ac:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.String r1 = "NO_SERVER"
            java.lang.String r2 = "این سرور در فهرست فعلی مامی نیست"
            r0.<init>(r1, r2)
            throw r0
        L1b6:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r1 = kotlin.collections.q.p1(r3)
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L21b
            java.lang.Object r3 = r8.element
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L1d7
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L1d7
            goto L21b
        L1d7:
            java.util.Iterator r3 = r3.iterator()
        L1db:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L21b
            java.lang.Object r4 = r3.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r4 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L1db
            java.lang.Object r3 = r8.element
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L1fe:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L219
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r6 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r6
            java.lang.String r6 = r6.getId()
            boolean r6 = r1.contains(r6)
            if (r6 != 0) goto L1fe
            r4.add(r5)
            goto L1fe
        L219:
            r8.element = r4
        L21b:
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 10
            r1.<init>(r3)
            r9.setStatus(r1)
            java.lang.Object r1 = r8.element
            r4 = r1
            java.util.List r4 = (java.util.List) r4
            r7.L$0 = r9
            r7.L$1 = r15
            r7.L$2 = r8
            r7.L$3 = r0
            r7.L$4 = r14
            r1 = 3
            r7.label = r1
            r5 = 0
            r6 = 0
            r1 = r8
            r8 = 6
            r3 = r9
            r9 = 0
            java.lang.Object r4 = scout$default(r3, r4, r5, r6, r7, r8, r9)
            if (r4 != r2) goto L245
            goto L307
        L245:
            r5 = r4
            r4 = r1
            r1 = r5
            r6 = r3
            r5 = r15
            r3 = r0
        L24b:
            java.util.List r1 = (java.util.List) r1
            r6.check()
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10
            r0.<init>(r4, r14)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.L$2 = r4
            r7.L$3 = r3
            r8 = 4
            r7.label = r8
            java.lang.Object r1 = r6.settleAfterRegister(r1, r0, r7)
            if (r1 != r2) goto L268
            goto L307
        L268:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L275:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L290
            java.lang.Object r8 = r1.next()
            r9 = r8
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r9
            long r9 = r9.getMs()
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L275
            r0.add(r8)
            goto L275
        L290:
            r8 = 3
            java.util.List r0 = kotlin.collections.q.e1(r0, r8)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r8 = 10
            int r9 = kotlin.collections.s.g0(r0, r8)
            r1.<init>(r9)
            java.util.Iterator r0 = r0.iterator()
        L2a6:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L2ba
            java.lang.Object r8 = r0.next()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r8
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r8 = r8.getServer()
            r1.add(r8)
            goto L2a6
        L2ba:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L30b
            r0 = r3
            r3 = r6
        L2c2:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = 10
            int r6 = kotlin.collections.s.g0(r1, r8)
            r4.<init>(r6)
            java.util.Iterator r1 = r1.iterator()
        L2d3:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L2ed
            java.lang.Object r6 = r1.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r6 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r6
            com.mlmvpn.scanner.engines.mami.MamiEngine r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            java.lang.Object r9 = r0.element
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r9
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r6 = r8.candOf(r6, r9)
            r4.add(r6)
            goto L2d3
        L2ed:
            java.lang.Object r0 = r0.element
            r6 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r6
            r7.L$0 = r14
            r7.L$1 = r14
            r7.L$2 = r14
            r7.L$3 = r14
            r7.L$4 = r14
            r0 = 5
            r7.label = r0
            r8 = r7
            r7 = 1
            java.lang.Object r0 = r3.tryServers(r4, r5, r6, r7, r8)
            if (r0 != r2) goto L308
        L307:
            return r2
        L308:
            sd.u r0 = sd.u.f67154a
            return r0
        L30b:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.Object r1 = r4.element
            java.util.List r1 = (java.util.List) r1
            int r1 = r1.size()
            java.lang.String r2 = "هیچ\u200cکدام از "
            java.lang.String r3 = " سرور مامی در سنجش جواب نداد"
            java.lang.String r1 = androidx.compose.foundation.interaction.f.o(r1, r2, r3)
            java.lang.String r2 = "NONE_ANSWERED"
            r0.<init>(r2, r1)
            throw r0
        L323:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.String r1 = "NO_SERVERS"
            java.lang.String r2 = "فهرست مامی هیچ سروری نداشت که این برنامه بتواند اجرا کند"
            r0.<init>(r1, r2)
            throw r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectCatalog$lambda$44(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "session"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectCatalog$lambda$45(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "catalog"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectCatalog$lambda$51(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "scout"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private final java.lang.Object connectExclusive(com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r30, wd.d r31) {
            r29 = this;
            r0 = r29
            r1 = r31
            boolean r2 = r1 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06071
            if (r2 == 0) goto L18
            r2 = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$1 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06071) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$1
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.result
            kotlin.coroutines.intrinsics.a r2 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r3 = r8.label
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L7f
            if (r3 == r9) goto L73
            if (r3 == r7) goto L67
            if (r3 == r6) goto L56
            if (r3 == r5) goto L43
            if (r3 != r4) goto L3b
            sd.m.b(r1)
            goto L1d8
        L3b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L43:
            java.lang.Object r3 = r8.L$2
            com.mlmvpn.scanner.engines.mami.MamiExclusive$Endpoint r3 = (com.mlmvpn.scanner.engines.mami.MamiExclusive.Endpoint) r3
            java.lang.Object r5 = r8.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r5
            java.lang.Object r6 = r8.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r1)
            r12 = r3
            r3 = r6
            goto L13f
        L56:
            java.lang.Object r3 = r8.L$2
            com.mlmvpn.scanner.engines.mami.MamiExclusive$Bridge r3 = (com.mlmvpn.scanner.engines.mami.MamiExclusive.Bridge) r3
            java.lang.Object r6 = r8.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r6
            java.lang.Object r7 = r8.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r7 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r7
            sd.m.b(r1)
            goto Lea
        L67:
            java.lang.Object r3 = r8.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r3
            java.lang.Object r7 = r8.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r7 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r7
            sd.m.b(r1)
            goto Lc8
        L73:
            java.lang.Object r3 = r8.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r3
            java.lang.Object r9 = r8.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r9
            sd.m.b(r1)
            goto La5
        L7f:
            sd.m.b(r1)
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 16
            r1.<init>(r3)
            r0.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3
            r3.<init>(r10)
            r8.L$0 = r0
            r11 = r30
            r8.L$1 = r11
            r8.label = r9
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r3, r8)
            if (r1 != r2) goto La3
            goto L1d7
        La3:
            r9 = r0
            r3 = r11
        La5:
            r9.check()
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r11 = 17
            r1.<init>(r11)
            r9.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$bridge$1 r11 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$bridge$1
            r11.<init>(r10)
            r8.L$0 = r9
            r8.L$1 = r3
            r8.label = r7
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r11, r8)
            if (r1 != r2) goto Lc7
            goto L1d7
        Lc7:
            r7 = r9
        Lc8:
            com.mlmvpn.scanner.engines.mami.MamiExclusive$Bridge r1 = (com.mlmvpn.scanner.engines.mami.MamiExclusive.Bridge) r1
            r7.check()
            oe.e r9 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$template$1 r11 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$template$1
            r11.<init>(r10)
            r8.L$0 = r7
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r6
            java.lang.Object r6 = kotlinx.coroutines.m0.J(r9, r11, r8)
            if (r6 != r2) goto Le4
            goto L1d7
        Le4:
            r28 = r3
            r3 = r1
            r1 = r6
            r6 = r28
        Lea:
            com.mlmvpn.scanner.engines.mami.MamiExclusive$Template r1 = (com.mlmvpn.scanner.engines.mami.MamiExclusive.Template) r1
            com.mlmvpn.scanner.engines.mami.MamiExclusive r9 = com.mlmvpn.scanner.engines.mami.MamiExclusive.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiExclusive$Endpoint r3 = r9.endpointFor(r3, r1)
            r7.check()
            java.lang.String r1 = r3.getProtocol()
            java.lang.String r9 = "B"
            boolean r1 = kotlin.jvm.internal.j.a(r1, r9)
            if (r1 == 0) goto L104
            java.lang.String r1 = "gRPC"
            goto L106
        L104:
            java.lang.String r1 = "WebSocket"
        L106:
            com.mlmvpn.scanner.engines.mami.g r9 = new com.mlmvpn.scanner.engines.mami.g
            r11 = 1
            r9.<init>(r11, r1)
            r7.setStatus(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "احراز هویت با پل اختصاصی ("
            r9.<init>(r11)
            r9.append(r1)
            java.lang.String r1 = ")…"
            r9.append(r1)
            java.lang.String r1 = r9.toString()
            r7.log(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$a$1 r9 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$a$1
            r9.<init>(r3, r10)
            r8.L$0 = r7
            r8.L$1 = r6
            r8.L$2 = r3
            r8.label = r5
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r9, r8)
            if (r1 != r2) goto L13c
            goto L1d7
        L13c:
            r12 = r3
            r5 = r6
            r3 = r7
        L13f:
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r1 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r1
            r3.check()
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r6 = r1.getInfo()
            boolean r7 = r1.getOk()
            if (r7 == 0) goto L1db
            if (r6 != 0) goto L152
            goto L1db
        L152:
            sf.c r1 = new sf.c
            r1.<init>()
            java.lang.String r7 = "uuid"
            java.lang.String r9 = r6.getUuid()
            r1.D(r7, r9)
            java.lang.String r7 = "token"
            java.lang.String r9 = r6.getToken()
            r1.D(r7, r9)
            java.lang.String r7 = "wsPath"
            java.lang.String r9 = r6.getWsPath()
            r1.D(r7, r9)
            java.lang.String r7 = "grpcServiceName"
            java.lang.String r9 = r6.getGrpcServiceName()
            r1.D(r7, r9)
            sf.c r7 = new sf.c
            java.util.Map r9 = r6.getHeaders()
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.collections.Map<*, *>"
            kotlin.jvm.internal.j.c(r9, r11)
            r7.<init>(r9)
            java.lang.String r9 = "headers"
            r1.D(r9, r7)
            com.mlmvpn.scanner.engines.mami.MamiExclusive r11 = com.mlmvpn.scanner.engines.mami.MamiExclusive.INSTANCE
            sf.c r13 = r11.sessionInfo(r1)
            r16 = 12
            r17 = 0
            r14 = 0
            r15 = 0
            sf.c r21 = com.mlmvpn.scanner.engines.mami.MamiExclusive.outboundFor$default(r11, r12, r13, r14, r15, r16, r17)
            com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive
            java.lang.String r7 = r12.getHostName()
            int r9 = r12.getPort()
            r1.<init>(r7, r9, r6)
            com.mlmvpn.scanner.engines.mami.MamiEngine.exclusiveLive = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r18 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Cand
            java.lang.String r26 = "vmess"
            java.lang.String r27 = "EXC"
            java.lang.String r19 = "exclusive"
            r20 = 0
            java.lang.String r22 = ""
            java.lang.String r23 = "پل اختصاصی"
            java.lang.String r24 = ""
            java.lang.String r25 = "exclusive"
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27)
            java.util.List r1 = m9.d.B(r18)
            r8.L$0 = r10
            r8.L$1 = r10
            r8.L$2 = r10
            r8.label = r4
            r6 = 0
            r7 = 0
            r4 = r1
            java.lang.Object r1 = r3.tryServers(r4, r5, r6, r7, r8)
            if (r1 != r2) goto L1d8
        L1d7:
            return r2
        L1d8:
            sd.u r1 = sd.u.f67154a
            return r1
        L1db:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.String r4 = r1.getError()
            boolean r4 = kotlin.text.o.L0(r4)
            if (r4 != 0) goto L1f8
            java.lang.String r1 = r1.getError()
            java.lang.String r4 = "اختصاصی"
            java.lang.String r1 = r3.unnamed$app_release(r1, r4)
            java.lang.String r3 = ": "
            java.lang.String r1 = v0.a.h(r3, r1)
            goto L1fa
        L1f8:
            java.lang.String r1 = ""
        L1fa:
            java.lang.String r3 = "پل اختصاصی احراز هویت را نپذیرفت"
            java.lang.String r1 = v0.a.h(r3, r1)
            java.lang.String r3 = "EXCLUSIVE_AUTH"
            r2.<init>(r3, r1)
            throw r2
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectExclusive$lambda$67(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "session"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectExclusive$lambda$68(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "bridge"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectExclusive$lambda$69(java.lang.String r17, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r18) {
            java.lang.String r0 = "it"
            r1 = r18
            kotlin.jvm.internal.j.e(r1, r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef
            java.lang.String r8 = "EXC"
            r9 = 0
            java.lang.String r3 = "exclusive"
            java.lang.String r4 = ""
            java.lang.String r5 = "پل اختصاصی"
            java.lang.String r6 = ""
            r7 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r15 = 2027(0x7eb, float:2.84E-42)
            r16 = 0
            r6 = r2
            r2 = 0
            r3 = 0
            java.lang.String r4 = "auth"
            r5 = 0
            r7 = 0
            r8 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private final java.lang.Object connectFront(com.mlmvpn.scanner.engines.mami.MamiEngine.Method r24, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r25, wd.d r26) {
            r23 = this;
            r1 = r23
            r0 = r26
            sd.u r2 = sd.u.f67154a
            boolean r3 = r0 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06091
            if (r3 == 0) goto L19
            r3 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$1 r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06091) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$1 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$1
            r3.<init>(r1, r0)
        L1e:
            java.lang.Object r0 = r3.result
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r5 = r3.label
            java.lang.String r6 = "app"
            r7 = 4
            r8 = 3
            r9 = 2
            r11 = 1
            java.lang.String r13 = "ساخت حساب ناشناس برای «"
            if (r5 == 0) goto Ldd
            if (r5 == r11) goto Lbf
            if (r5 == r9) goto La0
            if (r5 == r8) goto L58
            if (r5 != r7) goto L50
            int r10 = r3.I$0
            java.lang.Object r4 = r3.L$2
            com.mlmvpn.scanner.ui.tunnel.TunnelController r4 = (com.mlmvpn.scanner.ui.tunnel.TunnelController) r4
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r3
            sd.m.b(r0)     // Catch: java.lang.Throwable -> L4d
            r18 = r2
            r9 = r5
            r11 = r10
            goto L327
        L4d:
            r0 = move-exception
            goto L375
        L50:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L58:
            int r5 = r3.I$3
            int r6 = r3.I$2
            long r9 = r3.J$1
            long r14 = r3.J$0
            int r7 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r12 = r3.L$4
            com.mlmvpn.scanner.ui.tunnel.TunnelController r12 = (com.mlmvpn.scanner.ui.tunnel.TunnelController) r12
            java.lang.Object r11 = r3.L$3
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r11 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r11
            r18 = r0
            java.lang.Object r0 = r3.L$2
            java.lang.String r0 = (java.lang.String) r0
            r24 = r0
            java.lang.Object r0 = r3.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r0
            r25 = r0
            java.lang.Object r0 = r3.L$0
            r19 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine r19 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r19
            sd.m.b(r18)     // Catch: java.lang.Throwable -> L9a
            r18 = r2
            r1 = r4
            r17 = r6
            r6 = r12
            r2 = r13
            r20 = r14
            r4 = 3
            r15 = r5
            r14 = r11
            r5 = r3
            r11 = r8
            r3 = r19
            r8 = r7
            r7 = r24
        L96:
            r0 = r25
            goto L2cd
        L9a:
            r0 = move-exception
            r10 = r8
            r3 = r19
            goto L375
        La0:
            r18 = r0
            int r5 = r3.I$0
            java.lang.Object r0 = r3.L$3
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r0 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r0
            java.lang.Object r7 = r3.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r3.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r8
            java.lang.Object r9 = r3.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r9
            sd.m.b(r18)     // Catch: java.lang.Throwable -> Lba
            r12 = 1
            goto L14b
        Lba:
            r0 = move-exception
            r10 = r5
            r3 = r9
            goto L375
        Lbf:
            r18 = r0
            int r5 = r3.I$0
            java.lang.Object r0 = r3.L$3
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r0 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r0
            java.lang.Object r7 = r3.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r3.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r8
            java.lang.Object r11 = r3.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r11
            sd.m.b(r18)     // Catch: java.lang.Throwable -> Ld8
            r12 = 1
            goto L12f
        Ld8:
            r0 = move-exception
            r10 = r5
            r3 = r11
            goto L375
        Ldd:
            r18 = r0
            sd.m.b(r18)
            java.lang.String r0 = r24.getEngine()
            if (r0 != 0) goto Le9
            return r2
        Le9:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
            r7 = r25
            if (r7 != r5) goto Lf4
            java.lang.String r5 = "این روش روی گوشی همیشه تونل کامل است (موتورش درگاه پراکسی جدا ندارد)."
            r1.log(r5)
        Lf4:
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker = r0
            com.mlmvpn.scanner.engines.mami.f r5 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L371
            r7 = 12
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L371
            r1.setStatus(r5)     // Catch: java.lang.Throwable -> L371
            com.mlmvpn.scanner.ui.tunnel.TunnelController r5 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE     // Catch: java.lang.Throwable -> L366
            kotlinx.coroutines.flow.e1 r5 = r5.getState()     // Catch: java.lang.Throwable -> L366
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> L366
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r5 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r5     // Catch: java.lang.Throwable -> L366
            com.mlmvpn.scanner.ui.tunnel.TunnelExclusion r7 = com.mlmvpn.scanner.ui.tunnel.TunnelExclusion.INSTANCE     // Catch: java.lang.Throwable -> L366
            android.content.Context r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> L366
            if (r8 == 0) goto L36b
            r3.L$0 = r1     // Catch: java.lang.Throwable -> L366
            r11 = r24
            r3.L$1 = r11     // Catch: java.lang.Throwable -> L366
            r3.L$2 = r0     // Catch: java.lang.Throwable -> L366
            r3.L$3 = r5     // Catch: java.lang.Throwable -> L366
            r12 = 1
            r3.I$0 = r12     // Catch: java.lang.Throwable -> L366
            r3.label = r12     // Catch: java.lang.Throwable -> L366
            java.lang.Object r7 = r7.releaseForTunnelStack(r8, r3)     // Catch: java.lang.Throwable -> L366
            if (r7 != r4) goto L12a
        L127:
            r1 = r4
            goto L324
        L12a:
            r7 = r0
            r0 = r5
            r8 = r11
            r5 = r12
            r11 = r1
        L12f:
            oe.e r14 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> Ld8
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3 r15 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3     // Catch: java.lang.Throwable -> Ld8
            r10 = 0
            r15.<init>(r7, r10)     // Catch: java.lang.Throwable -> Ld8
            r3.L$0 = r11     // Catch: java.lang.Throwable -> Ld8
            r3.L$1 = r8     // Catch: java.lang.Throwable -> Ld8
            r3.L$2 = r7     // Catch: java.lang.Throwable -> Ld8
            r3.L$3 = r0     // Catch: java.lang.Throwable -> Ld8
            r3.I$0 = r5     // Catch: java.lang.Throwable -> Ld8
            r3.label = r9     // Catch: java.lang.Throwable -> Ld8
            java.lang.Object r9 = kotlinx.coroutines.m0.J(r14, r15, r3)     // Catch: java.lang.Throwable -> Ld8
            if (r9 != r4) goto L14a
            goto L127
        L14a:
            r9 = r11
        L14b:
            java.lang.String r10 = "geph"
            boolean r10 = kotlin.jvm.internal.j.a(r7, r10)     // Catch: java.lang.Throwable -> Lba
            if (r10 == 0) goto L167
            com.mlmvpn.core.geph.GephAccount r10 = com.mlmvpn.core.geph.GephAccount.INSTANCE     // Catch: java.lang.Throwable -> Lba
            android.content.Context r11 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> Lba
            if (r11 == 0) goto L161
            boolean r6 = r10.hasAccount(r11)     // Catch: java.lang.Throwable -> Lba
            if (r6 != 0) goto L167
            r6 = r12
            goto L168
        L161:
            kotlin.jvm.internal.j.k(r6)     // Catch: java.lang.Throwable -> Lba
            r16 = 0
            throw r16     // Catch: java.lang.Throwable -> Lba
        L167:
            r6 = 0
        L168:
            if (r6 == 0) goto L182
            java.lang.String r10 = r8.getName()     // Catch: java.lang.Throwable -> Lba
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r11.<init>(r13)     // Catch: java.lang.Throwable -> Lba
            r11.append(r10)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r10 = "» (فقط بار اول؛ چند ثانیه تا چند دقیقه)…"
            r11.append(r10)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> Lba
            r9.log(r10)     // Catch: java.lang.Throwable -> Lba
        L182:
            java.lang.String r10 = "tor"
            boolean r10 = kotlin.jvm.internal.j.a(r7, r10)     // Catch: java.lang.Throwable -> Lba
            if (r10 == 0) goto L18e
            r10 = 240000(0x3a980, double:1.18576E-318)
            goto L191
        L18e:
            r10 = 150000(0x249f0, double:7.411E-319)
        L191:
            r14 = 0
            if (r6 == 0) goto L199
            r18 = 1200000(0x124f80, double:5.92879E-318)
            goto L19b
        L199:
            r18 = r14
        L19b:
            long r10 = r10 + r18
            com.mlmvpn.scanner.ui.tunnel.TunnelController r18 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE     // Catch: java.lang.Throwable -> Lba
            r19 = -1
            r20 = r10
            r17 = 0
            r11 = r5
            r5 = r3
            r3 = r9
            r9 = r14
            r15 = r19
            r14 = r0
            r0 = r8
            r8 = r6
            r6 = r18
        L1b0:
            r3.check()     // Catch: java.lang.Throwable -> L1fe
            kotlinx.coroutines.flow.e1 r18 = r6.getState()     // Catch: java.lang.Throwable -> L1fe
            java.lang.Object r18 = r18.getValue()     // Catch: java.lang.Throwable -> L1fe
            r12 = r18
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r12 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r12     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r1 = r12.getStage()     // Catch: java.lang.Throwable -> L1fe
            r18 = r2
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r2 = com.mlmvpn.scanner.ui.tunnel.TunnelStage.STARTING     // Catch: java.lang.Throwable -> L1fe
            if (r1 != r2) goto L1cb
            r1 = 1
            goto L1cd
        L1cb:
            r1 = r17
        L1cd:
            if (r1 != 0) goto L1d5
            if (r12 == r14) goto L1d2
            goto L1d5
        L1d2:
            r22 = r4
            goto L1eb
        L1d5:
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r2 = r12.getStage()     // Catch: java.lang.Throwable -> L1fe
            r22 = r4
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r4 = com.mlmvpn.scanner.ui.tunnel.TunnelStage.RUNNING     // Catch: java.lang.Throwable -> L1fe
            if (r2 == r4) goto L1e7
            com.mlmvpn.core.tunnel.TunnelStatus r2 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE     // Catch: java.lang.Throwable -> L1fe
            boolean r2 = r2.isActive()     // Catch: java.lang.Throwable -> L1fe
            if (r2 == 0) goto L1eb
        L1e7:
            r1 = r22
            goto L2fc
        L1eb:
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r2 = r12.getStage()     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r4 = com.mlmvpn.scanner.ui.tunnel.TunnelStage.FAILED     // Catch: java.lang.Throwable -> L1fe
            if (r2 != r4) goto L256
            if (r1 != 0) goto L202
            if (r12 == r14) goto L256
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r2 = r14.getStage()     // Catch: java.lang.Throwable -> L1fe
            if (r2 == r4) goto L256
            goto L202
        L1fe:
            r0 = move-exception
            r10 = r11
            goto L375
        L202:
            java.lang.String r1 = "ENGINE_FAILED"
            java.lang.String r2 = r0.getName()     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r4 = r12.getMessage()     // Catch: java.lang.Throwable -> L1fe
            if (r4 == 0) goto L235
            boolean r5 = kotlin.text.o.L0(r4)     // Catch: java.lang.Throwable -> L1fe
            if (r5 != 0) goto L215
            goto L216
        L215:
            r4 = 0
        L216:
            if (r4 == 0) goto L235
            com.mlmvpn.scanner.engines.mami.MamiEngine r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r0 = r5.unnamed$app_release(r4, r0)     // Catch: java.lang.Throwable -> L1fe
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1fe
            r4.<init>()     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r5 = ": "
            r4.append(r5)     // Catch: java.lang.Throwable -> L1fe
            r4.append(r0)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L1fe
            if (r0 != 0) goto L237
        L235:
            java.lang.String r0 = ""
        L237:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1fe
            r4.<init>()     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r5 = "«"
            r4.append(r5)     // Catch: java.lang.Throwable -> L1fe
            r4.append(r2)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r2 = "» بالا نیامد"
            r4.append(r2)     // Catch: java.lang.Throwable -> L1fe
            r4.append(r0)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail     // Catch: java.lang.Throwable -> L1fe
            r2.<init>(r1, r0)     // Catch: java.lang.Throwable -> L1fe
            throw r2     // Catch: java.lang.Throwable -> L1fe
        L256:
            if (r8 == 0) goto L298
            int r2 = r12.getProgress()     // Catch: java.lang.Throwable -> L1fe
            if (r2 < 0) goto L298
            r4 = 101(0x65, float:1.42E-43)
            if (r2 >= r4) goto L298
            int r2 = r12.getProgress()     // Catch: java.lang.Throwable -> L1fe
            int r2 = r2 / 10
            if (r2 == r15) goto L298
            int r2 = r12.getProgress()     // Catch: java.lang.Throwable -> L1fe
            int r2 = r2 / 10
            java.lang.String r4 = r0.getName()     // Catch: java.lang.Throwable -> L1fe
            int r12 = r12.getProgress()     // Catch: java.lang.Throwable -> L1fe
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1fe
            r15.<init>()     // Catch: java.lang.Throwable -> L1fe
            r15.append(r13)     // Catch: java.lang.Throwable -> L1fe
            r15.append(r4)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r4 = "» — "
            r15.append(r4)     // Catch: java.lang.Throwable -> L1fe
            r15.append(r12)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r4 = "٪"
            r15.append(r4)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r4 = r15.toString()     // Catch: java.lang.Throwable -> L1fe
            r3.log(r4)     // Catch: java.lang.Throwable -> L1fe
            r15 = r2
        L298:
            r2 = r13
            r12 = r20
            int r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r4 >= 0) goto L2da
            r5.L$0 = r3     // Catch: java.lang.Throwable -> L1fe
            r5.L$1 = r0     // Catch: java.lang.Throwable -> L1fe
            r5.L$2 = r7     // Catch: java.lang.Throwable -> L1fe
            r5.L$3 = r14     // Catch: java.lang.Throwable -> L1fe
            r5.L$4 = r6     // Catch: java.lang.Throwable -> L1fe
            r5.I$0 = r11     // Catch: java.lang.Throwable -> L1fe
            r5.I$1 = r8     // Catch: java.lang.Throwable -> L1fe
            r5.J$0 = r12     // Catch: java.lang.Throwable -> L1fe
            r5.J$1 = r9     // Catch: java.lang.Throwable -> L1fe
            r5.I$2 = r1     // Catch: java.lang.Throwable -> L1fe
            r5.I$3 = r15     // Catch: java.lang.Throwable -> L1fe
            r4 = 3
            r5.label = r4     // Catch: java.lang.Throwable -> L1fe
            r25 = r0
            r24 = r1
            r0 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r0 = kotlinx.coroutines.m0.j(r0, r5)     // Catch: java.lang.Throwable -> L1fe
            r1 = r22
            if (r0 != r1) goto L2c7
            goto L324
        L2c7:
            r17 = r24
            r20 = r12
            goto L96
        L2cd:
            r12 = 1000(0x3e8, float:1.401E-42)
            long r12 = (long) r12     // Catch: java.lang.Throwable -> L1fe
            long r9 = r9 + r12
            r4 = r1
            r13 = r2
            r2 = r18
            r12 = 1
            r1 = r23
            goto L1b0
        L2da:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1fe
            r1 = 60000(0xea60, float:8.4078E-41)
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L1fe
            long r1 = r12 / r1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1fe
            r4.<init>()     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r5 = "موتور در "
            r4.append(r5)     // Catch: java.lang.Throwable -> L1fe
            r4.append(r1)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r1 = " دقیقه بالا نیامد"
            r4.append(r1)     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L1fe
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L1fe
            throw r0     // Catch: java.lang.Throwable -> L1fe
        L2fc:
            r3.check()     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.f r0 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L1fe
            r2 = 14
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1fe
            r3.setStatus(r0)     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$tr$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$tr$1     // Catch: java.lang.Throwable -> L1fe
            r10 = 0
            r0.<init>(r10)     // Catch: java.lang.Throwable -> L1fe
            r5.L$0 = r3     // Catch: java.lang.Throwable -> L1fe
            r5.L$1 = r7     // Catch: java.lang.Throwable -> L1fe
            r5.L$2 = r6     // Catch: java.lang.Throwable -> L1fe
            r5.L$3 = r10     // Catch: java.lang.Throwable -> L1fe
            r5.L$4 = r10     // Catch: java.lang.Throwable -> L1fe
            r5.I$0 = r11     // Catch: java.lang.Throwable -> L1fe
            r2 = 4
            r5.label = r2     // Catch: java.lang.Throwable -> L1fe
            java.lang.Object r0 = r3.verify(r0, r5)     // Catch: java.lang.Throwable -> L1fe
            if (r0 != r1) goto L325
        L324:
            return r1
        L325:
            r4 = r6
            r9 = r7
        L327:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r0     // Catch: java.lang.Throwable -> L1fe
            if (r0 != 0) goto L330
            java.lang.String r1 = "اولین درخواست از داخل موتور دیر جواب داد؛ موتور روشن می\u200cماند."
            r3.log(r1)     // Catch: java.lang.Throwable -> L1fe
        L330:
            r3.check()     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L1fe
            r2 = 15
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1fe
            r3.setStatus(r1)     // Catch: java.lang.Throwable -> L1fe
            kotlinx.coroutines.flow.e1 r1 = r4.getState()     // Catch: java.lang.Throwable -> L1fe
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r1 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r1     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.ui.tunnel.Transport r1 = r1.getActive()     // Catch: java.lang.Throwable -> L1fe
            if (r1 == 0) goto L352
            java.lang.String r1 = r1.getId()     // Catch: java.lang.Throwable -> L1fe
            goto L353
        L352:
            r1 = 0
        L353:
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontTransport = r1     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Live     // Catch: java.lang.Throwable -> L1fe
            java.lang.String r6 = "front"
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r10 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL     // Catch: java.lang.Throwable -> L1fe
            r7 = 0
            r8 = 0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L1fe
            com.mlmvpn.scanner.engines.mami.MamiEngine.live = r5     // Catch: java.lang.Throwable -> L1fe
            r3.connected(r0)     // Catch: java.lang.Throwable -> L1fe
            return r18
        L366:
            r0 = move-exception
            r3 = r23
            r10 = 1
            goto L375
        L36b:
            kotlin.jvm.internal.j.k(r6)     // Catch: java.lang.Throwable -> L366
            r16 = 0
            throw r16     // Catch: java.lang.Throwable -> L366
        L371:
            r0 = move-exception
            r3 = r23
            r10 = 0
        L375:
            if (r10 == 0) goto L37a
            r3.stopFront()
        L37a:
            r16 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker = r16
            throw r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectFront$lambda$74(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
            r15 = 2035(0x7f3, float:2.852E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "engine"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectFront$lambda$77(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "verify"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectFront$lambda$78(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "route"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private final java.lang.Object connectHive(com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r19, java.util.List<java.lang.String> r20, wd.d r21) {
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06111
            if (r2 == 0) goto L18
            r2 = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$1 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06111) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r7 = r2
            goto L1e
        L18:
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$1
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r7.result
            kotlin.coroutines.intrinsics.a r2 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r3 = r7.label
            r10 = 0
            r11 = 5
            r12 = 4
            r13 = 3
            r4 = 2
            r5 = 1
            r14 = 0
            if (r3 == 0) goto L8c
            if (r3 == r5) goto L7c
            if (r3 == r4) goto L6b
            if (r3 == r13) goto L5a
            if (r3 == r12) goto L44
            if (r3 != r11) goto L3c
            sd.m.b(r1)
            goto L24c
        L3c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L44:
            java.lang.Object r3 = r7.L$2
            kotlin.jvm.internal.y r3 = (kotlin.jvm.internal.y) r3
            java.lang.Object r4 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r4
            java.lang.Object r5 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r5
            sd.m.b(r1)
        L53:
            r17 = r5
            r5 = r4
            r4 = r17
            goto L1c0
        L5a:
            java.lang.Object r3 = r7.L$2
            kotlin.jvm.internal.y r3 = (kotlin.jvm.internal.y) r3
            java.lang.Object r4 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r4
            java.lang.Object r5 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r5
            sd.m.b(r1)
            goto L1a5
        L6b:
            java.lang.Object r3 = r7.L$2
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r5 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r5
            java.lang.Object r6 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r1)
        L7a:
            r15 = r5
            goto Ldb
        L7c:
            java.lang.Object r3 = r7.L$2
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r5 = r7.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r5
            java.lang.Object r6 = r7.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r1)
            goto Lb7
        L8c:
            sd.m.b(r1)
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 13
            r1.<init>(r3)
            r0.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3 r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3
            r3.<init>(r14)
            r7.L$0 = r0
            r6 = r19
            r7.L$1 = r6
            r8 = r20
            r7.L$2 = r8
            r7.label = r5
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r3, r7)
            if (r1 != r2) goto Lb4
            goto L24b
        Lb4:
            r5 = r6
            r3 = r8
            r6 = r0
        Lb7:
            r6.check()
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r8 = 18
            r1.<init>(r8)
            r6.setStatus(r1)
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$parsed$1 r8 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$parsed$1
            r8.<init>(r14)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.L$2 = r3
            r7.label = r4
            java.lang.Object r1 = kotlinx.coroutines.m0.J(r1, r8, r7)
            if (r1 != r2) goto L7a
            goto L24b
        Ldb:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r1 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive) r1
            r6.check()
            kotlin.jvm.internal.y r5 = new kotlin.jvm.internal.y
            r5.<init>()
            java.util.List r1 = r1.getServers()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r1 = r1.iterator()
        Lf4:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L10f
            java.lang.Object r9 = r1.next()
            r11 = r9
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r11 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r11
            com.mlmvpn.scanner.engines.mami.MamiXrayConfig r12 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE
            java.lang.String r11 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.unsupportedReason$default(r12, r11, r10, r4, r14)
            if (r11 != 0) goto L10c
            r8.add(r9)
        L10c:
            r11 = 5
            r12 = 4
            goto Lf4
        L10f:
            r5.element = r8
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L268
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r1 = kotlin.collections.q.p1(r3)
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L17c
            java.lang.Object r3 = r5.element
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L138
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L138
            goto L17c
        L138:
            java.util.Iterator r3 = r3.iterator()
        L13c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L17c
            java.lang.Object r4 = r3.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r4 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L13c
            java.lang.Object r3 = r5.element
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L15f:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L17a
            java.lang.Object r8 = r3.next()
            r9 = r8
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r9 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r9
            java.lang.String r9 = r9.getId()
            boolean r9 = r1.contains(r9)
            if (r9 != 0) goto L15f
            r4.add(r8)
            goto L15f
        L17a:
            r5.element = r4
        L17c:
            com.mlmvpn.scanner.engines.mami.f r1 = new com.mlmvpn.scanner.engines.mami.f
            r3 = 19
            r1.<init>(r3)
            r6.setStatus(r1)
            java.lang.Object r1 = r5.element
            r4 = r1
            java.util.List r4 = (java.util.List) r4
            r7.L$0 = r6
            r7.L$1 = r15
            r7.L$2 = r5
            r7.label = r13
            r1 = r5
            r5 = 0
            r3 = r6
            r6 = 1
            r8 = 2
            r9 = 0
            java.lang.Object r4 = scout$default(r3, r4, r5, r6, r7, r8, r9)
            if (r4 != r2) goto L1a1
            goto L24b
        L1a1:
            r5 = r3
            r3 = r1
            r1 = r4
            r4 = r15
        L1a5:
            java.util.List r1 = (java.util.List) r1
            r5.check()
            com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8 r6 = new com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8
            r6.<init>(r3, r14)
            r7.L$0 = r5
            r7.L$1 = r4
            r7.L$2 = r3
            r8 = 4
            r7.label = r8
            java.lang.Object r1 = r5.settleAfterRegister(r1, r6, r7)
            if (r1 != r2) goto L53
            goto L24b
        L1c0:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r1 = r1.iterator()
        L1cd:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L1e8
            java.lang.Object r8 = r1.next()
            r9 = r8
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r9
            long r11 = r9.getMs()
            r15 = 0
            int r9 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r9 <= 0) goto L1cd
            r6.add(r8)
            goto L1cd
        L1e8:
            java.util.List r1 = kotlin.collections.q.e1(r6, r13)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r8 = 10
            int r9 = kotlin.collections.s.g0(r1, r8)
            r6.<init>(r9)
            java.util.Iterator r1 = r1.iterator()
        L1fd:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L211
            java.lang.Object r9 = r1.next()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r9 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r9
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r9 = r9.getServer()
            r6.add(r9)
            goto L1fd
        L211:
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L24f
            r3 = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            int r1 = kotlin.collections.s.g0(r6, r8)
            r4.<init>(r1)
            int r1 = r6.size()
        L225:
            if (r10 >= r1) goto L239
            java.lang.Object r8 = r6.get(r10)
            int r10 = r10 + 1
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r8 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r8
            com.mlmvpn.scanner.engines.mami.MamiEngine r9 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r8 = r9.candOf(r8, r14)
            r4.add(r8)
            goto L225
        L239:
            r7.L$0 = r14
            r7.L$1 = r14
            r7.L$2 = r14
            r1 = 5
            r7.label = r1
            r6 = 0
            r8 = r7
            r7 = 0
            java.lang.Object r1 = r3.tryServers(r4, r5, r6, r7, r8)
            if (r1 != r2) goto L24c
        L24b:
            return r2
        L24c:
            sd.u r1 = sd.u.f67154a
            return r1
        L24f:
            r1 = r3
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.Object r1 = r1.element
            java.util.List r1 = (java.util.List) r1
            int r1 = r1.size()
            java.lang.String r3 = "هیچ\u200cکدام از "
            java.lang.String r4 = " پل لیون جواب نداد"
            java.lang.String r1 = androidx.compose.foundation.interaction.f.o(r1, r3, r4)
            java.lang.String r3 = "HIVE_UNREACHABLE"
            r2.<init>(r3, r1)
            throw r2
        L268:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Fail
            java.lang.String r2 = "HIVE_NO_SERVERS"
            java.lang.String r3 = "لیون فعلاً پلی برای این دستگاه ندارد"
            r1.<init>(r2, r3)
            throw r1
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectHive$lambda$58(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "session"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectHive$lambda$59(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "hive"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connectHive$lambda$63(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "scout"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private final void connected(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r11) {
            r10 = this;
            com.mlmvpn.scanner.engines.mami.h r0 = new com.mlmvpn.scanner.engines.mami.h
            r1 = 1
            r0.<init>(r11, r1)
            r10.setStatus(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.live
            r1 = 0
            if (r0 == 0) goto L13
            java.lang.String r0 = r0.getKind()
            goto L14
        L13:
            r0 = r1
        L14:
            java.lang.String r2 = "xray"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r2)
            java.lang.String r2 = ""
            if (r0 == 0) goto L43
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.live
            if (r0 == 0) goto L27
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r0 = r0.getMode()
            goto L28
        L27:
            r0 = r1
        L28:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
            if (r0 != r3) goto L43
            com.mlmvpn.scanner.utils.LocalPort r0 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r3 == 0) goto L3d
            int r0 = r0.get(r3)
            java.lang.String r1 = " — فقط پراکسی محلی 127.0.0.1:"
            java.lang.String r0 = f0.a.h(r0, r1)
            goto L44
        L3d:
            java.lang.String r11 = "app"
            kotlin.jvm.internal.j.k(r11)
            throw r1
        L43:
            r0 = r2
        L44:
            java.lang.String r1 = "."
            java.lang.String r3 = "وصل شد"
            if (r11 == 0) goto L9a
            java.lang.String r4 = r11.getLoc()
            boolean r4 = kotlin.text.o.L0(r4)
            if (r4 != 0) goto L5f
            java.lang.String r4 = r11.getLoc()
            java.lang.String r5 = " — خروج از "
            java.lang.String r4 = v0.a.h(r5, r4)
            goto L60
        L5f:
            r4 = r2
        L60:
            java.lang.String r5 = r11.getIp()
            boolean r5 = kotlin.text.o.L0(r5)
            if (r5 != 0) goto L77
            java.lang.String r5 = r11.getIp()
            java.lang.String r6 = " ("
            java.lang.String r7 = ")"
            java.lang.String r5 = a6.w0.n(r6, r5, r7)
            goto L78
        L77:
            r5 = r2
        L78:
            long r6 = r11.getMs()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L8e
            long r6 = r11.getMs()
            java.lang.String r11 = "، "
            java.lang.String r2 = " میلی\u200cثانیه"
            java.lang.String r2 = androidx.compose.foundation.interaction.f.p(r6, r11, r2)
        L8e:
            java.lang.StringBuilder r11 = androidx.media3.common.s.n(r3, r4, r5, r2, r0)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            goto L9e
        L9a:
            java.lang.String r11 = a6.w0.n(r3, r0, r1)
        L9e:
            r10.log(r11)
            r10.bump()
            r10.startWatch()
            return
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status connected$lambda$80(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r17, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r18) {
            java.lang.String r0 = "it"
            r1 = r18
            kotlin.jvm.internal.j.e(r1, r0)
            long r11 = java.lang.System.currentTimeMillis()
            r15 = 1690(0x69a, float:2.368E-42)
            r16 = 0
            java.lang.String r2 = "on"
            r3 = 0
            java.lang.String r4 = ""
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r13 = 0
            r14 = 0
            r7 = r17
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status d(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectHive$lambda$63(r0)
            return r0
    }

    private static final sd.u disconnectAsync$lambda$81(android.content.Context r3) {
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            r0.init(r3)
            r3 = 1
            com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled = r3
            kotlinx.coroutines.s1 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.connectJob
            r0 = 0
            if (r3 == 0) goto L10
            r3.cancel(r0)
        L10:
            kotlinx.coroutines.s1 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.watchJob
            if (r3 == 0) goto L17
            r3.cancel(r0)
        L17:
            kotlinx.coroutines.i0 r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectAsync$1$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectAsync$1$1
            r1.<init>(r0)
            r2 = 3
            kotlinx.coroutines.m0.y(r3, r0, r0, r1, r2)
            sd.u r3 = sd.u.f67154a
            return r3
    }

    private final java.lang.Object disconnectNow(java.lang.String r25, wd.d r26) {
            r24 = this;
            r0 = r24
            r1 = r26
            boolean r2 = r1 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06131
            if (r2 == 0) goto L17
            r2 = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$1 r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06131) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r4 = r2.label
            java.lang.String r5 = "xray"
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L47
            if (r4 != r6) goto L3f
            java.lang.Object r3 = r2.L$3
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r3 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r3
            java.lang.Object r4 = r2.L$2
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Live) r4
            java.lang.Object r6 = r2.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r2.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r2
            sd.m.b(r1)
            goto Lbe
        L3f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L47:
            sd.m.b(r1)
            com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled = r6
            kotlinx.coroutines.s1 r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.watchJob
            if (r1 == 0) goto L53
            r1.cancel(r7)
        L53:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.live
            kotlinx.coroutines.flow.k0 r1 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r1
            java.lang.String r8 = r1.getPhase()
            java.lang.String r9 = "off"
            boolean r8 = kotlin.jvm.internal.j.a(r8, r9)
            if (r8 != 0) goto L75
            com.mlmvpn.scanner.engines.mami.f r8 = new com.mlmvpn.scanner.engines.mami.f
            r9 = 20
            r8.<init>(r9)
            r0.setStatus(r8)
        L75:
            com.mlmvpn.scanner.engines.mami.MamiEngine$ExclusiveLive r8 = com.mlmvpn.scanner.engines.mami.MamiEngine.exclusiveLive
            if (r4 == 0) goto L7e
            java.lang.String r9 = r4.getKind()
            goto L7f
        L7e:
            r9 = r7
        L7f:
            boolean r9 = kotlin.jvm.internal.j.a(r9, r5)
            if (r9 == 0) goto Lc0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r9 = r4.getCand()
            if (r9 == 0) goto L90
            java.lang.String r9 = r9.getId()
            goto L91
        L90:
            r9 = r7
        L91:
            java.lang.String r10 = "exclusive"
            boolean r9 = kotlin.jvm.internal.j.a(r9, r10)
            if (r9 == 0) goto Lc0
            if (r8 == 0) goto Lc0
            boolean r9 = r0.isOurs()
            if (r9 == 0) goto Lc0
            oe.e r9 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3 r10 = new com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3
            r10.<init>(r8, r7)
            r2.L$0 = r0
            r8 = r25
            r2.L$1 = r8
            r2.L$2 = r4
            r2.L$3 = r1
            r2.label = r6
            java.lang.Object r2 = kotlinx.coroutines.m0.J(r9, r10, r2)
            if (r2 != r3) goto Lbb
            return r3
        Lbb:
            r2 = r0
            r3 = r1
            r6 = r8
        Lbe:
            r1 = r3
            goto Lc4
        Lc0:
            r8 = r25
            r2 = r0
            r6 = r8
        Lc4:
            com.mlmvpn.scanner.engines.mami.MamiEngine.exclusiveLive = r7
            if (r4 == 0) goto Lcd
            java.lang.String r3 = r4.getKind()
            goto Lce
        Lcd:
            r3 = r7
        Lce:
            java.lang.String r8 = "front"
            boolean r3 = kotlin.jvm.internal.j.a(r3, r8)
            if (r3 == 0) goto Lda
            r2.stopFront()
            goto L100
        Lda:
            if (r4 == 0) goto Le1
            java.lang.String r3 = r4.getKind()
            goto Le2
        Le1:
            r3 = r7
        Le2:
            boolean r3 = kotlin.jvm.internal.j.a(r3, r5)
            if (r3 != 0) goto Lf4
            java.lang.String r1 = r1.getPhase()
            java.lang.String r3 = "connecting"
            boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
            if (r1 == 0) goto L100
        Lf4:
            r2.stopService()
            if (r4 != 0) goto L100
            java.lang.String r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker
            if (r1 == 0) goto L100
            r2.stopFront()
        L100:
            com.mlmvpn.scanner.engines.mami.MamiEngine.live = r7
            com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker = r7
            kotlinx.coroutines.flow.k0 r1 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r3 = r1.getValue()
            r8 = r3
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r8 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r8
            java.lang.String r3 = "switch"
            boolean r4 = kotlin.jvm.internal.j.a(r6, r3)
            if (r4 == 0) goto L11a
            r21 = r7
            goto L11c
        L11a:
            r21 = r6
        L11c:
            r22 = 986(0x3da, float:1.382E-42)
            r23 = 0
            java.lang.String r9 = "off"
            r10 = 0
            java.lang.String r11 = ""
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r21, r22, r23)
            r1.j(r4)
            boolean r1 = kotlin.jvm.internal.j.a(r6, r3)
            if (r1 != 0) goto L141
            java.lang.String r1 = "مامی قطع شد."
            r2.log(r1)
        L141:
            r2.bump()
            sd.u r1 = sd.u.f67154a
            return r1
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status disconnectNow$lambda$82(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2046(0x7fe, float:2.867E-42)
            r16 = 0
            java.lang.String r2 = "stopping"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    public static /* synthetic */ java.lang.CharSequence e(com.mlmvpn.scanner.engines.mami.MamiCatalog.Skipped r0) {
            java.lang.CharSequence r0 = parsedHive$lambda$23(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status f(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = clearError$lambda$88(r0)
            return r0
    }

    private final boolean frontUp() {
            r2 = this;
            com.mlmvpn.core.tunnel.TunnelStatus r0 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE
            boolean r0 = r0.isActive()
            if (r0 != 0) goto L1f
            com.mlmvpn.scanner.ui.tunnel.TunnelController r0 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE
            kotlinx.coroutines.flow.e1 r0 = r0.getState()
            java.lang.Object r0 = r0.getValue()
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r0 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r0
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r0 = r0.getStage()
            com.mlmvpn.scanner.ui.tunnel.TunnelStage r1 = com.mlmvpn.scanner.ui.tunnel.TunnelStage.RUNNING
            if (r0 != r1) goto L1d
            goto L1f
        L1d:
            r0 = 0
            return r0
        L1f:
            r0 = 1
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status g(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = tryServers$lambda$73(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status h(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = disconnectNow$lambda$82(r0)
            return r0
    }

    private final com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive hiveNow(boolean r9) {
            r8 = this;
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> Lb
            sf.c r0 = r0.savedHive()     // Catch: java.lang.Throwable -> Lb
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lb
            goto L14
        Lb:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        L14:
            boolean r1 = sd.l.m1010isFailureimpl(r0)
            r2 = 0
            if (r1 == 0) goto L1c
            r0 = r2
        L1c:
            sf.c r0 = (sf.c) r0
            java.lang.String r1 = "payload"
            if (r0 == 0) goto L27
            sf.c r3 = r0.w(r1)
            goto L28
        L27:
            r3 = r2
        L28:
            if (r3 == 0) goto L40
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = "fetchedAt"
            r6 = 0
            long r5 = r0.x(r6, r5)
            long r3 = r3 - r5
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L40
            r3 = 1
            goto L41
        L40:
            r3 = 0
        L41:
            if (r9 != 0) goto L45
            if (r3 != 0) goto L7f
        L45:
            com.mlmvpn.scanner.engines.mami.MamiApi r9 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: com.mlmvpn.scanner.engines.mami.MamiApi.ApiException -> L4d
            java.lang.String r3 = "connect"
            r9.fetchHive(r3)     // Catch: com.mlmvpn.scanner.engines.mami.MamiApi.ApiException -> L4d
            goto L7c
        L4d:
            r9 = move-exception
            if (r0 == 0) goto L54
            sf.c r2 = r0.w(r1)
        L54:
            if (r2 == 0) goto L8e
            java.lang.String r0 = r9.getCode()
            java.lang.String r1 = "hive-off"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            if (r0 != 0) goto L8e
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "فهرست تازهٔ لیون گرفته نشد ("
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.log(r9)
        L7c:
            r8.bump()
        L7f:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r9 = r8.parsedHive()
            if (r9 == 0) goto L86
            return r9
        L86:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "فهرست پل\u200cهای لیون خوانده نشد"
            r9.<init>(r0)
            throw r9
        L8e:
            throw r9
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive hiveNow$default(com.mlmvpn.scanner.engines.mami.MamiEngine r0, boolean r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L5
            r1 = 0
        L5:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r0 = r0.hiveNow(r1)
            return r0
    }

    public static /* synthetic */ sd.u i(java.lang.String r0) {
            sd.u r0 = init$lambda$2(r0)
            return r0
    }

    private static final sd.u init$lambda$2(java.lang.String r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            r0.log(r1)
            sd.u r1 = sd.u.f67154a
            return r1
    }

    private static final sd.j init$lambda$3() {
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            sd.j r0 = r0.networkNow()
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiNet.Route init$lambda$4() {
            com.mlmvpn.scanner.engines.mami.MamiEngine r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiNet$Route r0 = r0.routeNow()
            return r0
    }

    public static /* synthetic */ java.lang.CharSequence j(com.mlmvpn.scanner.engines.mami.MamiCatalog.Skipped r0) {
            java.lang.CharSequence r0 = parsedSaved$lambda$20(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status k(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectCatalog$lambda$44(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status l(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectFront$lambda$77(r0)
            return r0
    }

    private final java.lang.String lang() {
            r2 = this;
            java.lang.String r0 = "fa"
            java.lang.String r1 = "en"
            java.lang.String r0 = com.mlmvpn.scanner.store.StoreNetKt.tr(r0, r1)
            return r0
    }

    private final java.lang.Object launch(java.lang.String r13, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r14, wd.d r15) {
            r12 = this;
            boolean r0 = r15 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06151
            if (r0 == 0) goto L13
            r0 = r15
            com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1 r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L3a
            if (r2 == r6) goto L35
            if (r2 != r3) goto L2d
            sd.m.b(r15)
            goto Lbf
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            sd.m.b(r15)
            goto Laa
        L3a:
            sd.m.b(r15)
            com.mlmvpn.scanner.MyVpnService$Companion r15 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r15 = r15.getConnectionPhaseFlow()
            kotlinx.coroutines.flow.g1 r15 = (kotlinx.coroutines.flow.g1) r15
            java.lang.Object r15 = r15.getValue()
            com.mlmvpn.scanner.MyVpnService$Phase r2 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
            if (r15 != r2) goto L4f
            r15 = r6
            goto L50
        L4f:
            r15 = r4
        L50:
            com.mlmvpn.scanner.utils.SafeStart r2 = com.mlmvpn.scanner.utils.SafeStart.INSTANCE
            android.content.Context r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            java.lang.String r8 = "app"
            if (r7 == 0) goto Ld3
            android.content.Intent r9 = new android.content.Intent
            android.content.Context r10 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r10 == 0) goto Lcf
            java.lang.Class<com.mlmvpn.scanner.MyVpnService> r11 = com.mlmvpn.scanner.MyVpnService.class
            r9.<init>(r10, r11)
            java.lang.String r10 = "NODE_URI"
            r9.putExtra(r10, r13)
            com.mlmvpn.scanner.utils.NetworkSettings$Method r13 = com.mlmvpn.scanner.utils.NetworkSettings.Method.V2RAY
            java.lang.String r13 = r13.getId()
            java.lang.String r10 = "MTU_PROFILE"
            r9.putExtra(r10, r13)
            java.lang.String r13 = "NODE_ID"
            java.lang.String r10 = "mami"
            r9.putExtra(r13, r10)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r13 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
            if (r14 != r13) goto L80
            r13 = r6
            goto L81
        L80:
            r13 = r4
        L81:
            java.lang.String r14 = "PROXY_MODE"
            r9.putExtra(r14, r13)
            com.mlmvpn.scanner.utils.LocalPort r13 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r14 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r14 == 0) goto Lcb
            java.lang.String r13 = r13.getString(r14)
            java.lang.String r14 = "LOCAL_PORT"
            r9.putExtra(r14, r13)
            r2.service(r7, r9)
            if (r15 == 0) goto Laa
            com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3 r13 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$3
            r13.<init>(r5)
            r0.label = r6
            r14 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r13 = kotlinx.coroutines.m0.L(r14, r13, r0)
            if (r13 != r1) goto Laa
            goto Lbe
        Laa:
            kotlin.jvm.internal.u r13 = new kotlin.jvm.internal.u
            r13.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine$launch$phase$1 r14 = new com.mlmvpn.scanner.engines.mami.MamiEngine$launch$phase$1
            r14.<init>(r13, r5)
            r0.label = r3
            r2 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Object r15 = kotlinx.coroutines.m0.L(r2, r14, r0)
            if (r15 != r1) goto Lbf
        Lbe:
            return r1
        Lbf:
            com.mlmvpn.scanner.MyVpnService$Phase r15 = (com.mlmvpn.scanner.MyVpnService.Phase) r15
            com.mlmvpn.scanner.MyVpnService$Phase r13 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
            if (r15 != r13) goto Lc6
            r4 = r6
        Lc6:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r4)
            return r13
        Lcb:
            kotlin.jvm.internal.j.k(r8)
            throw r5
        Lcf:
            kotlin.jvm.internal.j.k(r8)
            throw r5
        Ld3:
            kotlin.jvm.internal.j.k(r8)
            throw r5
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status m(com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r0, sd.j r1, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r2) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = tryServers$lambda$70(r0, r1, r2)
            return r0
    }

    private final java.lang.Object measure(java.util.List<? extends sd.j> r3, java.lang.String r4, wd.d r5) {
            r2 = this;
            com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2
            r1 = 0
            r0.<init>(r3, r4, r1)
            java.lang.Object r3 = kotlinx.coroutines.m0.i(r0, r5)
            return r3
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status n(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = tryServers$lambda$72(r0)
            return r0
    }

    private final sd.j networkNow() {
            r11 = this;
            java.lang.String r0 = "wifi"
            java.lang.String r1 = ""
            android.content.Context r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "app"
            r4 = 0
            if (r2 == 0) goto Lae
            java.lang.Class<android.net.ConnectivityManager> r5 = android.net.ConnectivityManager.class
            java.lang.Object r2 = r2.getSystemService(r5)     // Catch: java.lang.Throwable -> L32
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Throwable -> L32
            android.net.Network[] r5 = r2.getAllNetworks()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "getAllNetworks(...)"
            kotlin.jvm.internal.j.d(r5, r6)     // Catch: java.lang.Throwable -> L32
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L32
            r6.<init>()     // Catch: java.lang.Throwable -> L32
            int r7 = r5.length     // Catch: java.lang.Throwable -> L32
            r8 = 0
            r9 = r8
        L24:
            if (r9 >= r7) goto L38
            r10 = r5[r9]     // Catch: java.lang.Throwable -> L32
            android.net.NetworkCapabilities r10 = r2.getNetworkCapabilities(r10)     // Catch: java.lang.Throwable -> L32
            if (r10 == 0) goto L35
            r6.add(r10)     // Catch: java.lang.Throwable -> L32
            goto L35
        L32:
            r2 = move-exception
            goto Lb2
        L35:
            int r9 = r9 + 1
            goto L24
        L38:
            int r2 = r6.size()     // Catch: java.lang.Throwable -> L32
            r5 = r8
        L3d:
            if (r5 >= r2) goto L58
            java.lang.Object r7 = r6.get(r5)     // Catch: java.lang.Throwable -> L32
            int r5 = r5 + 1
            r9 = r7
            android.net.NetworkCapabilities r9 = (android.net.NetworkCapabilities) r9     // Catch: java.lang.Throwable -> L32
            r10 = 12
            boolean r10 = r9.hasCapability(r10)     // Catch: java.lang.Throwable -> L32
            if (r10 == 0) goto L3d
            r10 = 4
            boolean r9 = r9.hasTransport(r10)     // Catch: java.lang.Throwable -> L32
            if (r9 != 0) goto L3d
            goto L59
        L58:
            r7 = r4
        L59:
            android.net.NetworkCapabilities r7 = (android.net.NetworkCapabilities) r7     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto La4
            boolean r2 = r7.hasTransport(r8)     // Catch: java.lang.Throwable -> L32
            r5 = 1
            if (r2 != r5) goto La4
            android.content.Context r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto La0
            java.lang.Class<android.telephony.TelephonyManager> r3 = android.telephony.TelephonyManager.class
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch: java.lang.Throwable -> L32
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "cellular"
            if (r2 == 0) goto L78
            java.lang.String r4 = r2.getNetworkOperator()     // Catch: java.lang.Throwable -> L32
        L78:
            if (r4 != 0) goto L7b
            r4 = r1
        L7b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            int r5 = r4.length()     // Catch: java.lang.Throwable -> L32
        L84:
            if (r8 >= r5) goto L96
            char r6 = r4.charAt(r8)     // Catch: java.lang.Throwable -> L32
            boolean r7 = java.lang.Character.isDigit(r6)     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto L93
            r2.append(r6)     // Catch: java.lang.Throwable -> L32
        L93:
            int r8 = r8 + 1
            goto L84
        L96:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            sd.j r4 = new sd.j     // Catch: java.lang.Throwable -> L32
            r4.<init>(r3, r2)     // Catch: java.lang.Throwable -> L32
            goto La9
        La0:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L32
            throw r4     // Catch: java.lang.Throwable -> L32
        La4:
            sd.j r4 = new sd.j     // Catch: java.lang.Throwable -> L32
            r4.<init>(r0, r1)     // Catch: java.lang.Throwable -> L32
        La9:
            java.lang.Object r2 = sd.l.m1004constructorimpl(r4)     // Catch: java.lang.Throwable -> L32
            goto Lba
        Lae:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L32
            throw r4     // Catch: java.lang.Throwable -> L32
        Lb2:
            sd.l$a r2 = sd.m.a(r2)
            java.lang.Object r2 = sd.l.m1004constructorimpl(r2)
        Lba:
            sd.j r3 = new sd.j
            r3.<init>(r0, r1)
            boolean r0 = sd.l.m1010isFailureimpl(r2)
            if (r0 == 0) goto Lc6
            r2 = r3
        Lc6:
            sd.j r2 = (sd.j) r2
            return r2
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status o(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectCatalog$lambda$45(r0)
            return r0
    }

    public static /* synthetic */ sd.j p() {
            sd.j r0 = init$lambda$3()
            return r0
    }

    private final synchronized com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive parsedHive() {
            r11 = this;
            java.lang.String r1 = "فهرست لیون خوانده نشد: "
            monitor-enter(r11)
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> Le
            sf.c r0 = r0.savedHive()     // Catch: java.lang.Throwable -> Le
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Le
            goto L17
        Le:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L51
        L17:
            boolean r2 = sd.l.m1010isFailureimpl(r0)     // Catch: java.lang.Throwable -> L51
            r3 = 0
            if (r2 == 0) goto L1f
            r0 = r3
        L1f:
            sf.c r0 = (sf.c) r0     // Catch: java.lang.Throwable -> L51
            if (r0 != 0) goto L25
            monitor-exit(r11)
            return r3
        L25:
            java.lang.String r2 = "payload"
            sf.c r2 = r0.w(r2)     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L2f
            monitor-exit(r11)
            return r3
        L2f:
            java.lang.String r4 = "fetchedAt"
            r5 = 0
            long r4 = r0.x(r5, r4)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L51
            sd.j r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.hiveCat     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L53
            java.lang.Object r5 = r4.getFirst()     // Catch: java.lang.Throwable -> L51
            boolean r5 = kotlin.jvm.internal.j.a(r5, r0)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L53
            java.lang.Object r0 = r4.getSecond()     // Catch: java.lang.Throwable -> L51
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r0 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Hive) r0     // Catch: java.lang.Throwable -> L51
            monitor-exit(r11)
            return r0
        L51:
            r0 = move-exception
            goto Lc4
        L53:
            com.mlmvpn.scanner.engines.mami.MamiCatalog r4 = com.mlmvpn.scanner.engines.mami.MamiCatalog.INSTANCE     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r2 = r4.parseHive(r2)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            sd.j r4 = new sd.j     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r4.<init>(r0, r2)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            com.mlmvpn.scanner.engines.mami.MamiEngine.hiveCat = r4     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.util.List r0 = r2.getSkipped()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            if (r0 != 0) goto Lad
            java.util.List r0 = r2.getSkipped()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.util.List r4 = r2.getSkipped()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r5 = 5
            java.util.List r4 = kotlin.collections.q.e1(r4, r5)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r5 = r4
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.lang.String r6 = "، "
            com.mlmvpn.scanner.engines.mami.f r9 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r4 = 21
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r10 = 30
            r7 = 0
            r8 = 0
            java.lang.String r4 = kotlin.collections.q.F0(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r5.<init>()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r5.append(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.lang.String r0 = " پل لیون کنار گذاشته شد: "
            r5.append(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r5.append(r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            r11.log(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> Lab
            goto Lad
        Lab:
            r0 = move-exception
            goto Laf
        Lad:
            r3 = r2
            goto Lc2
        Laf:
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L51
            r2.append(r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L51
            r11.log(r0)     // Catch: java.lang.Throwable -> L51
        Lc2:
            monitor-exit(r11)
            return r3
        Lc4:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L51
            throw r0
    }

    private static final java.lang.CharSequence parsedHive$lambda$23(com.mlmvpn.scanner.engines.mami.MamiCatalog.Skipped r3) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r3, r0)
            java.lang.String r0 = r3.getId()
            java.lang.String r3 = r3.getWhy()
            java.lang.String r1 = " ("
            java.lang.String r2 = ")"
            java.lang.String r3 = f0.a.m(r0, r1, r3, r2)
            return r3
    }

    private final synchronized com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed parsedSaved() {
            r11 = this;
            java.lang.String r1 = "فهرست ذخیره\u200cشده خوانده نشد: "
            monitor-enter(r11)
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> Le
            sf.c r0 = r0.savedCatalog()     // Catch: java.lang.Throwable -> Le
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Le
            goto L17
        Le:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L67
        L17:
            boolean r2 = sd.l.m1010isFailureimpl(r0)     // Catch: java.lang.Throwable -> L67
            r3 = 0
            if (r2 == 0) goto L1f
            r0 = r3
        L1f:
            sf.c r0 = (sf.c) r0     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L25
            monitor-exit(r11)
            return r3
        L25:
            java.lang.String r2 = "payload"
            sf.c r2 = r0.w(r2)     // Catch: java.lang.Throwable -> L67
            if (r2 != 0) goto L2f
            monitor-exit(r11)
            return r3
        L2f:
            java.lang.String r4 = "fetchedAt"
            r5 = 0
            long r7 = r0.x(r5, r4)     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = "revision"
            long r4 = r0.x(r5, r4)     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r0.<init>()     // Catch: java.lang.Throwable -> L67
            r0.append(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = ":"
            r0.append(r6)     // Catch: java.lang.Throwable -> L67
            r0.append(r4)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L67
            sd.j r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.cat     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L69
            java.lang.Object r5 = r4.getFirst()     // Catch: java.lang.Throwable -> L67
            boolean r5 = kotlin.jvm.internal.j.a(r5, r0)     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L69
            java.lang.Object r0 = r4.getSecond()     // Catch: java.lang.Throwable -> L67
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Parsed) r0     // Catch: java.lang.Throwable -> L67
            monitor-exit(r11)
            return r0
        L67:
            r0 = move-exception
            goto Lda
        L69:
            com.mlmvpn.scanner.engines.mami.MamiCatalog r4 = com.mlmvpn.scanner.engines.mami.MamiCatalog.INSTANCE     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r2 = r4.parseCatalog(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            sd.j r4 = new sd.j     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r4.<init>(r0, r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            com.mlmvpn.scanner.engines.mami.MamiEngine.cat = r4     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.util.List r0 = r2.getSkipped()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            if (r0 != 0) goto Lc3
            java.util.List r0 = r2.getSkipped()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.util.List r4 = r2.getSkipped()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r5 = 5
            java.util.List r4 = kotlin.collections.q.e1(r4, r5)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r5 = r4
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.lang.String r6 = "، "
            com.mlmvpn.scanner.engines.mami.f r9 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r4 = 22
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r10 = 30
            r7 = 0
            r8 = 0
            java.lang.String r4 = kotlin.collections.q.F0(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r5.<init>()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r5.append(r0)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.lang.String r0 = " سرور فهرست کنار گذاشته شد: "
            r5.append(r0)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r5.append(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            r11.log(r0)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> Lc1
            goto Lc3
        Lc1:
            r0 = move-exception
            goto Lc5
        Lc3:
            r3 = r2
            goto Ld8
        Lc5:
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L67
            r2.append(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L67
            r11.log(r0)     // Catch: java.lang.Throwable -> L67
        Ld8:
            monitor-exit(r11)
            return r3
        Lda:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L67
            throw r0
    }

    private static final java.lang.CharSequence parsedSaved$lambda$20(com.mlmvpn.scanner.engines.mami.MamiCatalog.Skipped r3) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r3, r0)
            java.lang.String r0 = r3.getId()
            java.lang.String r3 = r3.getWhy()
            java.lang.String r1 = " ("
            java.lang.String r2 = ")"
            java.lang.String r3 = f0.a.m(r0, r1, r3, r2)
            return r3
    }

    private final java.lang.String placeLabel(com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r3) {
            r2 = this;
            java.lang.String r0 = r3.getCity()
            boolean r0 = kotlin.text.o.L0(r0)
            if (r0 != 0) goto L19
            java.lang.String r0 = r3.getCountry()
            java.lang.String r3 = r3.getCity()
            java.lang.String r1 = " · "
            java.lang.String r3 = f0.a.l(r0, r1, r3)
            return r3
        L19:
            java.lang.String r3 = r3.getCountry()
            return r3
    }

    private final com.mlmvpn.scanner.engines.mami.MamiCatalog.Place placeOfLocation(com.mlmvpn.scanner.engines.mami.MamiCatalog.Location r3) {
            r2 = this;
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Names r0 = r3.getNames()
            if (r0 == 0) goto L1a
            com.mlmvpn.scanner.engines.mami.MamiEngine r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            java.lang.String r1 = r1.lang()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Place r1 = r0.get(r1)
            if (r1 != 0) goto L16
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Place r1 = r0.getEn()
        L16:
            if (r1 != 0) goto L19
            goto L1a
        L19:
            return r1
        L1a:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Place r0 = new com.mlmvpn.scanner.engines.mami.MamiCatalog$Place
            java.lang.String r1 = r3.getCountry()
            java.lang.String r3 = r3.getCity()
            r0.<init>(r1, r3)
            return r0
    }

    private final sd.j placeOfServer(com.mlmvpn.scanner.engines.mami.MamiCatalog.Server r3) {
            r2 = this;
            com.mlmvpn.scanner.engines.mami.MamiCatalog r0 = com.mlmvpn.scanner.engines.mami.MamiCatalog.INSTANCE
            java.lang.String r1 = r2.lang()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Place r3 = r0.placeOf(r3, r1)
            java.lang.String r0 = r3.getCountry()
            java.lang.String r3 = r3.getCity()
            sd.j r1 = new sd.j
            r1.<init>(r0, r3)
            return r1
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status q(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectFront$lambda$74(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status r(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectHive$lambda$59(r0)
            return r0
    }

    private final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit realExit(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r11) {
            r10 = this;
            com.mlmvpn.core.tunnel.IpFormatter r0 = com.mlmvpn.core.tunnel.IpFormatter.INSTANCE
            java.lang.String r1 = r11.getLoc()
            boolean r1 = r0.isRealCountry(r1)
            if (r1 == 0) goto Ld
            return r11
        Ld:
            com.mlmvpn.scanner.ui.tunnel.TunnelController r1 = com.mlmvpn.scanner.ui.tunnel.TunnelController.INSTANCE
            kotlinx.coroutines.flow.e1 r1 = r1.getState()
            java.lang.Object r1 = r1.getValue()
            com.mlmvpn.scanner.ui.tunnel.TunnelUiState r1 = (com.mlmvpn.scanner.ui.tunnel.TunnelUiState) r1
            java.lang.String r1 = r1.getCountry()
            if (r1 == 0) goto L35
            java.lang.CharSequence r1 = kotlin.text.o.n1(r1)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L35
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toUpperCase(r2)
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.j.d(r1, r2)
            goto L36
        L35:
            r1 = 0
        L36:
            java.lang.String r2 = ""
            if (r1 != 0) goto L3b
            r1 = r2
        L3b:
            boolean r0 = r0.isRealCountry(r1)
            if (r0 == 0) goto L43
            r4 = r1
            goto L44
        L43:
            r4 = r2
        L44:
            r8 = 6
            r9 = 0
            r5 = 0
            r6 = 0
            r3 = r11
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r11 = com.mlmvpn.scanner.engines.mami.MamiEngine.Exit.copy$default(r3, r4, r5, r6, r8, r9)
            return r11
    }

    private final com.mlmvpn.scanner.engines.mami.MamiNet.Route routeNow() {
            r5 = this;
            com.mlmvpn.scanner.MyVpnService$Companion r0 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r1 = r0.getConnectionPhaseFlow()
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            com.mlmvpn.scanner.MyVpnService$Phase r2 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
            r3 = 0
            if (r1 != r2) goto L3f
            com.mlmvpn.scanner.engines.mami.MamiNet r1 = com.mlmvpn.scanner.engines.mami.MamiNet.INSTANCE
            com.mlmvpn.scanner.utils.LocalPort r2 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r4 == 0) goto L39
            int r2 = r2.get(r4)
            kotlinx.coroutines.flow.k0 r0 = r0.getConnectedNodeIdFlow()
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.String r3 = "mami"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r3)
            if (r0 == 0) goto L32
            java.lang.String r0 = "خود مامی"
            goto L34
        L32:
            java.lang.String r0 = "موتور وصل برنامه"
        L34:
            com.mlmvpn.scanner.engines.mami.MamiNet$Route r0 = r1.socksRoute(r2, r0)
            return r0
        L39:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            throw r3
        L3f:
            com.mlmvpn.core.tunnel.TunnelStatus r0 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE
            boolean r1 = r0.isActive()
            if (r1 == 0) goto L5a
            int r1 = r0.getActiveSocksPort()
            if (r1 <= 0) goto L5a
            com.mlmvpn.scanner.engines.mami.MamiNet r1 = com.mlmvpn.scanner.engines.mami.MamiNet.INSTANCE
            int r0 = r0.getActiveSocksPort()
            java.lang.String r2 = "موتور تونل برنامه"
            com.mlmvpn.scanner.engines.mami.MamiNet$Route r0 = r1.socksRoute(r0, r2)
            return r0
        L5a:
            return r3
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiNet.Route s() {
            com.mlmvpn.scanner.engines.mami.MamiNet$Route r0 = init$lambda$4()
            return r0
    }

    private final void saveRoute(sd.j r6) {
            r5 = this;
            android.content.SharedPreferences r0 = r5.sp()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "route"
            if (r6 != 0) goto L10
            r0.remove(r1)
            goto L2e
        L10:
            sf.c r2 = new sf.c
            r2.<init>()
            java.lang.String r3 = "profile"
            java.lang.Object r4 = r6.getFirst()
            r2.D(r3, r4)
            java.lang.String r3 = "locationId"
            java.lang.Object r6 = r6.getSecond()
            r2.D(r3, r6)
            java.lang.String r6 = r2.toString()
            r0.putString(r1, r6)
        L2e:
            r0.apply()
            return
    }

    private final java.lang.Object scout(java.util.List<com.mlmvpn.scanner.engines.mami.MamiCatalog.Server> r25, boolean r26, boolean r27, wd.d r28) {
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r27
            r3 = r28
            boolean r4 = r3 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06191
            if (r4 == 0) goto L1b
            r4 = r3
            com.mlmvpn.scanner.engines.mami.MamiEngine$scout$1 r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06191) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            com.mlmvpn.scanner.engines.mami.MamiEngine$scout$1 r4 = new com.mlmvpn.scanner.engines.mami.MamiEngine$scout$1
            r4.<init>(r0, r3)
        L20:
            java.lang.Object r3 = r4.result
            kotlin.coroutines.intrinsics.a r5 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r6 = r4.label
            r9 = -1
            r11 = 1
            if (r6 == 0) goto L4d
            if (r6 != r11) goto L45
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$2
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r5 = r4.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r4 = r4.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r4
            sd.m.b(r3)
            r6 = r2
            r16 = 0
            r2 = r1
            r1 = r5
            goto L126
        L45:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L4d:
            sd.m.b(r3)
            long r12 = java.lang.System.currentTimeMillis()
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r3 = r3.iterator()
        L60:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L96
            java.lang.Object r14 = r3.next()
            r15 = r14
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r15 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r15
            r16 = 0
            if (r26 != 0) goto L92
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r8 = r15.getId()
            java.lang.Object r7 = r7.get(r8)
            sd.j r7 = (sd.j) r7
            if (r7 == 0) goto L92
            java.lang.Object r7 = r7.getSecond()
            java.lang.Number r7 = (java.lang.Number) r7
            long r7 = r7.longValue()
            long r7 = r12 - r7
            r18 = 600000(0x927c0, double:2.964394E-318)
            int r7 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r7 <= 0) goto L60
        L92:
            r6.add(r14)
            goto L60
        L96:
            r16 = 0
            r3 = 24
            java.util.List r3 = kotlin.collections.q.e1(r6, r3)
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L19a
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r3 = r3.iterator()
        Lb0:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto Lf4
            java.lang.Object r7 = r3.next()
            r19 = r7
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r19 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r19
            java.lang.String r7 = r19.getId()     // Catch: java.lang.Exception -> Ld9
            com.mlmvpn.scanner.engines.mami.MamiXrayConfig r18 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE     // Catch: java.lang.Exception -> Ld9
            java.lang.String r20 = "mami-scout"
            r22 = 4
            r23 = 0
            r21 = 0
            sf.c r8 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.outboundFor$default(r18, r19, r20, r21, r22, r23)     // Catch: java.lang.Exception -> Ld9
            sd.j r14 = new sd.j     // Catch: java.lang.Exception -> Ld9
            r14.<init>(r7, r8)     // Catch: java.lang.Exception -> Ld9
            r6.add(r14)     // Catch: java.lang.Exception -> Ld9
            goto Lb0
        Ld9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r7 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r8 = r19.getId()
            java.lang.Long r14 = new java.lang.Long
            r14.<init>(r9)
            java.lang.Long r15 = new java.lang.Long
            r15.<init>(r12)
            sd.j r9 = new sd.j
            r9.<init>(r14, r15)
            r7.put(r8, r9)
            r9 = -1
            goto Lb0
        Lf4:
            int r3 = r6.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "سنجش "
            r7.<init>(r8)
            r7.append(r3)
            java.lang.String r3 = " سرور…"
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r0.log(r3)
            if (r2 == 0) goto L113
            java.lang.String r3 = "https://cp.cloudflare.com/generate_204"
            goto L114
        L113:
            r3 = 0
        L114:
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r6
            r4.Z$0 = r2
            r4.label = r11
            java.lang.Object r3 = r0.measure(r6, r3, r4)
            if (r3 != r5) goto L125
            return r5
        L125:
            r4 = r0
        L126:
            java.util.Map r3 = (java.util.Map) r3
            java.util.Iterator r5 = r6.iterator()
            java.lang.String r7 = "iterator(...)"
            kotlin.jvm.internal.j.d(r5, r7)
            r7 = 0
        L132:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L177
            java.lang.Object r8 = r5.next()
            java.lang.String r9 = "next(...)"
            kotlin.jvm.internal.j.d(r8, r9)
            sd.j r8 = (sd.j) r8
            java.lang.Object r8 = r8.component1()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r3.get(r8)
            java.lang.Long r9 = (java.lang.Long) r9
            if (r9 == 0) goto L156
            long r9 = r9.longValue()
            goto L158
        L156:
            r9 = -1
        L158:
            int r11 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r11 <= 0) goto L15e
            int r7 = r7 + 1
        L15e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r11 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r9)
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.Long r13 = new java.lang.Long
            r13.<init>(r9)
            sd.j r9 = new sd.j
            r9.<init>(r12, r13)
            r11.put(r8, r9)
            goto L132
        L177:
            int r3 = r6.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            java.lang.String r6 = " سرور از "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = " جواب داد."
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.log(r3)
            r4.bump()
        L19a:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.s.g0(r1, r4)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L1ab:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L1f1
            java.lang.Object r4 = r1.next()
            r6 = r4
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r6 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r5 = r6.getId()
            java.lang.Object r4 = r4.get(r5)
            sd.j r4 = (sd.j) r4
            if (r4 == 0) goto L1d2
            java.lang.Object r4 = r4.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            r7 = r4
            goto L1d4
        L1d2:
            r7 = -1
        L1d4:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r5 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked
            if (r2 == 0) goto L1df
            com.mlmvpn.scanner.engines.mami.MamiCatalog r4 = com.mlmvpn.scanner.engines.mami.MamiCatalog.INSTANCE
            long r9 = r4.hiveRank(r6, r7)
            goto L1ea
        L1df:
            int r4 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r4 <= 0) goto L1e5
            r9 = r7
            goto L1ea
        L1e5:
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1ea:
            r5.<init>(r6, r7, r9)
            r3.add(r5)
            goto L1ab
        L1f1:
            com.mlmvpn.scanner.engines.mami.MamiEngine$scout$$inlined$sortedBy$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$scout$$inlined$sortedBy$1
            r1.<init>()
            java.util.List r1 = kotlin.collections.q.b1(r3, r1)
            return r1
    }

    public static /* synthetic */ java.lang.Object scout$default(com.mlmvpn.scanner.engines.mami.MamiEngine r1, java.util.List r2, boolean r3, boolean r4, wd.d r5, int r6, java.lang.Object r7) {
            r7 = r6 & 2
            r0 = 0
            if (r7 == 0) goto L6
            r3 = r0
        L6:
            r6 = r6 & 4
            if (r6 == 0) goto Lb
            r4 = r0
        Lb:
            java.lang.Object r1 = r1.scout(r2, r3, r4, r5)
            return r1
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs setPrefs$default(com.mlmvpn.scanner.engines.mami.MamiEngine r1, java.lang.String r2, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r3, java.lang.String r4, int r5, java.lang.Object r6) {
            r6 = r5 & 1
            r0 = 0
            if (r6 == 0) goto L6
            r2 = r0
        L6:
            r6 = r5 & 2
            if (r6 == 0) goto Lb
            r3 = r0
        Lb:
            r5 = r5 & 4
            if (r5 == 0) goto L10
            r4 = r0
        L10:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r1 = r1.setPrefs(r2, r3, r4)
            return r1
    }

    private final void setStatus(ee.c r3) {
            r2 = this;
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            r1 = r0
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r3 = r3.invoke(r1)
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            r0.j(r3)
            return
    }

    private final java.lang.Object settleAfterRegister(java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked> r19, ee.c r20, wd.d r21) {
            r18 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06201
            if (r1 == 0) goto L17
            r1 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$settleAfterRegister$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06201) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r18
            goto L1e
        L17:
            com.mlmvpn.scanner.engines.mami.MamiEngine$settleAfterRegister$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$settleAfterRegister$1
            r2 = r18
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r8 = 1
            if (r4 == 0) goto L66
            if (r4 == r8) goto L4f
            if (r4 != r5) goto L47
            int r4 = r1.I$1
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$2
            long[] r10 = (long[]) r10
            java.lang.Object r11 = r1.L$1
            ee.c r11 = (ee.c) r11
            java.lang.Object r12 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r12
            sd.m.b(r0)
            r19 = r6
        L43:
            r6 = r1
            r1 = r11
            goto L13f
        L47:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4f:
            int r4 = r1.I$1
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$2
            long[] r10 = (long[]) r10
            java.lang.Object r11 = r1.L$1
            ee.c r11 = (ee.c) r11
            java.lang.Object r12 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r12
            sd.m.b(r0)
            r19 = r6
            goto L129
        L66:
            sd.m.b(r0)
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Throwable -> L7d
            com.mlmvpn.scanner.engines.mami.MamiApi$Summary r0 = r0.summary()     // Catch: java.lang.Throwable -> L7d
            long r9 = r0.getRegisteredAt()     // Catch: java.lang.Throwable -> L7d
            java.lang.Long r0 = new java.lang.Long     // Catch: java.lang.Throwable -> L7d
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L7d
            goto L86
        L7d:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        L86:
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r6)
            boolean r9 = sd.l.m1010isFailureimpl(r0)
            if (r9 == 0) goto L92
            r0 = r4
        L92:
            java.lang.Number r0 = (java.lang.Number) r0
            long r9 = r0.longValue()
            r0 = r19
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r4 = r0 instanceof java.util.Collection
            if (r4 == 0) goto Laa
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto Laa
            goto Lc4
        Laa:
            java.util.Iterator r0 = r0.iterator()
        Lae:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lc4
            java.lang.Object r4 = r0.next()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r4
            long r11 = r4.getMs()
            int r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r4 <= 0) goto Lae
            goto L176
        Lc4:
            int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r0 <= 0) goto L176
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r9
            r9 = 120000(0x1d4c0, double:5.9288E-319)
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 <= 0) goto Ld6
            goto L176
        Ld6:
            r0 = 3
            long[] r4 = new long[r0]
            r9 = 4000(0xfa0, double:1.9763E-320)
            r11 = 0
            r4[r11] = r9
            r9 = 6000(0x1770, double:2.9644E-320)
            r4[r8] = r9
            r9 = 8000(0x1f40, double:3.9525E-320)
            r4[r5] = r9
            r9 = r1
            r12 = r2
            r10 = r4
            r1 = r20
            r4 = r0
            r0 = r19
        Lee:
            if (r11 >= r4) goto L175
            r13 = r10[r11]
            r0 = 1000(0x3e8, float:1.401E-42)
            r15 = r6
            long r6 = (long) r0
            long r6 = r13 / r6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r19 = r15
            java.lang.String r15 = "این دستگاه همین حالا ثبت شد؛ سرورها چند ثانیه طول می\u200cکشد تا آن را بشناسند — "
            r0.<init>(r15)
            r0.append(r6)
            java.lang.String r6 = " ثانیه دیگر دوباره سنجیده می\u200cشود…"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r12.log(r0)
            r9.L$0 = r12
            r9.L$1 = r1
            r9.L$2 = r10
            r9.I$0 = r11
            r9.I$1 = r4
            r9.label = r8
            java.lang.Object r0 = kotlinx.coroutines.m0.j(r13, r9)
            if (r0 != r3) goto L123
            goto L13e
        L123:
            r17 = r11
            r11 = r1
            r1 = r9
            r9 = r17
        L129:
            r12.check()
            r1.L$0 = r12
            r1.L$1 = r11
            r1.L$2 = r10
            r1.I$0 = r9
            r1.I$1 = r4
            r1.label = r5
            java.lang.Object r0 = r11.invoke(r1)
            if (r0 != r3) goto L43
        L13e:
            return r3
        L13f:
            java.util.List r0 = (java.util.List) r0
            r12.check()
            r7 = r0
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r11 = r7 instanceof java.util.Collection
            if (r11 == 0) goto L155
            r11 = r7
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L155
            goto L16e
        L155:
            java.util.Iterator r7 = r7.iterator()
        L159:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L16e
            java.lang.Object r11 = r7.next()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Ranked r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Ranked) r11
            long r13 = r11.getMs()
            int r11 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r11 <= 0) goto L159
            goto L175
        L16e:
            int r11 = r9 + 1
            r9 = r6
            r6 = r19
            goto Lee
        L175:
            return r0
        L176:
            return r19
    }

    private final android.content.SharedPreferences sp() {
            r3 = this;
            android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r0 == 0) goto Lc
            java.lang.String r1 = "mami"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            return r0
        Lc:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            r0 = 0
            throw r0
    }

    private final void startWatch() {
            r4 = this;
            kotlinx.coroutines.s1 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.watchJob
            r1 = 0
            if (r0 == 0) goto L8
            r0.cancel(r1)
        L8:
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1
            r2.<init>(r1)
            r3 = 3
            kotlinx.coroutines.q2 r0 = kotlinx.coroutines.m0.y(r0, r1, r1, r2, r3)
            com.mlmvpn.scanner.engines.mami.MamiEngine.watchJob = r0
            return
    }

    private final void stopFront() {
            r6 = this;
            com.mlmvpn.core.tunnel.TunnelStatus r0 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE
            boolean r0 = r0.isActive()
            if (r0 != 0) goto Le
            java.lang.String r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker
            if (r0 == 0) goto Ld
            goto Le
        Ld:
            return
        Le:
            com.mlmvpn.scanner.utils.SafeStart r0 = com.mlmvpn.scanner.utils.SafeStart.INSTANCE     // Catch: java.lang.Throwable -> L39
            android.content.Context r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> L39
            r2 = 0
            java.lang.String r3 = "app"
            if (r1 == 0) goto L3f
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Throwable -> L39
            android.content.Context r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.app     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L3b
            java.lang.Class<com.mlmvpn.core.tunnel.TunnelVpnService> r2 = com.mlmvpn.core.tunnel.TunnelVpnService.class
            r4.<init>(r5, r2)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "com.mlmvpn.core.tunnel.DISCONNECT"
            android.content.Intent r2 = r4.setAction(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "setAction(...)"
            kotlin.jvm.internal.j.d(r2, r3)     // Catch: java.lang.Throwable -> L39
            boolean r0 = r0.service(r1, r2)     // Catch: java.lang.Throwable -> L39
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L39
            sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L39
            return
        L39:
            r0 = move-exception
            goto L43
        L3b:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L39
            throw r2     // Catch: java.lang.Throwable -> L39
        L3f:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L39
            throw r2     // Catch: java.lang.Throwable -> L39
        L43:
            sd.l$a r0 = sd.m.a(r0)
            sd.l.m1004constructorimpl(r0)
            return
    }

    private final void stopService() {
            r6 = this;
            boolean r0 = r6.isOurs()
            if (r0 == 0) goto L2b
            com.mlmvpn.scanner.utils.SafeStart r0 = com.mlmvpn.scanner.utils.SafeStart.INSTANCE
            android.content.Context r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            r2 = 0
            java.lang.String r3 = "app"
            if (r1 == 0) goto L27
            android.content.Intent r4 = new android.content.Intent
            android.content.Context r5 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r5 == 0) goto L23
            java.lang.Class<com.mlmvpn.scanner.MyVpnService> r2 = com.mlmvpn.scanner.MyVpnService.class
            r4.<init>(r5, r2)
            java.lang.String r2 = "STOP"
            r4.setAction(r2)
            r0.service(r1, r4)
            return
        L23:
            kotlin.jvm.internal.j.k(r3)
            throw r2
        L27:
            kotlin.jvm.internal.j.k(r3)
            throw r2
        L2b:
            return
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status t(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectCatalog$lambda$51(r0)
            return r0
    }

    private final java.lang.String testConfig(sf.c r11) {
            r10 = this;
            sf.c r0 = new sf.c
            r0.<init>()
            sf.c r1 = new sf.c
            r1.<init>()
            java.lang.String r2 = "loglevel"
            java.lang.String r3 = "warning"
            r1.D(r2, r3)
            java.lang.String r2 = "log"
            r0.D(r2, r1)
            sf.a r1 = new sf.a
            r1.<init>()
            java.lang.String r2 = "listen"
            java.lang.String r3 = "127.0.0.1"
            java.lang.String r4 = "tag"
            java.lang.String r5 = "socks"
            sf.c r2 = com.mlmvpn.core.aether.i.p(r4, r5, r2, r3)
            double r6 = java.lang.Math.random()
            r3 = 3000(0xbb8, float:4.204E-42)
            double r8 = (double) r3
            double r6 = r6 * r8
            int r3 = (int) r6
            r6 = 36000(0x8ca0, float:5.0447E-41)
            int r3 = r3 + r6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r6 = "port"
            r2.D(r6, r3)
            java.lang.String r3 = "protocol"
            r2.D(r3, r5)
            sf.c r3 = new sf.c
            r3.<init>()
            java.lang.String r5 = "udp"
            r6 = 0
            r3.E(r5, r6)
            java.lang.String r5 = "settings"
            r2.D(r5, r3)
            r1.put(r2)
            java.lang.String r2 = "inbounds"
            r0.D(r2, r1)
            sf.a r1 = new sf.a
            r1.<init>()
            sf.c r2 = new sf.c
            java.lang.String r11 = r11.toString()
            r2.<init>(r11)
            java.lang.String r11 = "proxy"
            r2.D(r4, r11)
            r1.put(r2)
            java.lang.String r11 = "outbounds"
            r0.D(r11, r1)
            java.lang.String r11 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.j.d(r11, r0)
            return r11
    }

    private final com.mlmvpn.scanner.engines.mami.MamiEngine.Exit trace(java.net.Proxy r12) {
            r11 = this;
            r0 = 0
            okhttp3.OkHttpClient$Builder r1 = new okhttp3.OkHttpClient$Builder     // Catch: java.lang.Throwable -> La3
            r1.<init>()     // Catch: java.lang.Throwable -> La3
            r1.e(r12)     // Catch: java.lang.Throwable -> La3
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> La3
            r2 = 12
            r1.a(r2, r12)     // Catch: java.lang.Throwable -> La3
            okhttp3.OkHttpClient r12 = new okhttp3.OkHttpClient     // Catch: java.lang.Throwable -> La3
            r12.<init>(r1)     // Catch: java.lang.Throwable -> La3
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> La3
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> La3
            r3.<init>()     // Catch: java.lang.Throwable -> La3
            java.lang.String r4 = "https://www.cloudflare.com/cdn-cgi/trace"
            r3.j(r4)     // Catch: java.lang.Throwable -> La3
            okhttp3.Request r4 = new okhttp3.Request     // Catch: java.lang.Throwable -> La3
            r4.<init>(r3)     // Catch: java.lang.Throwable -> La3
            okhttp3.internal.connection.RealCall r12 = r12.b(r4)     // Catch: java.lang.Throwable -> La3
            okhttp3.Response r12 = r12.d()     // Catch: java.lang.Throwable -> La3
            okhttp3.ResponseBody r3 = r12.f29156h     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L3c
            java.lang.String r3 = r3.w()     // Catch: java.lang.Throwable -> L39
            goto L3d
        L39:
            r1 = move-exception
            goto La5
        L3c:
            r3 = r0
        L3d:
            java.lang.String r4 = ""
            if (r3 != 0) goto L42
            r3 = r4
        L42:
            boolean r5 = r12.A     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L48
            r3 = r0
            goto L9b
        L48:
            kotlin.text.l r5 = new kotlin.text.l     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = "(?m)^loc=([A-Z0-9]{2})"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L39
            r6 = 2
            r7 = 0
            kotlin.text.g r5 = kotlin.text.l.find$default(r5, r3, r7, r6, r0)     // Catch: java.lang.Throwable -> L39
            r8 = 1
            if (r5 == 0) goto L67
            kotlin.text.i r5 = (kotlin.text.i) r5     // Catch: java.lang.Throwable -> L39
            java.util.List r5 = r5.a()     // Catch: java.lang.Throwable -> L39
            kotlin.collections.f0 r5 = (kotlin.collections.f0) r5     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r5.get(r8)     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L39
            goto L68
        L67:
            r5 = r0
        L68:
            if (r5 != 0) goto L6b
            r5 = r4
        L6b:
            kotlin.text.l r9 = new kotlin.text.l     // Catch: java.lang.Throwable -> L39
            java.lang.String r10 = "(?m)^ip=(\\S+)"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L39
            kotlin.text.g r3 = kotlin.text.l.find$default(r9, r3, r7, r6, r0)     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L87
            kotlin.text.i r3 = (kotlin.text.i) r3     // Catch: java.lang.Throwable -> L39
            java.util.List r3 = r3.a()     // Catch: java.lang.Throwable -> L39
            kotlin.collections.f0 r3 = (kotlin.collections.f0) r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L39
            goto L88
        L87:
            r3 = r0
        L88:
            if (r3 != 0) goto L8b
            goto L8c
        L8b:
            r4 = r3
        L8c:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Exit     // Catch: java.lang.Throwable -> L39
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L39
            long r6 = r6 - r1
            r1 = 1000000(0xf4240, float:1.401298E-39)
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L39
            long r6 = r6 / r1
            r3.<init>(r5, r4, r6)     // Catch: java.lang.Throwable -> L39
        L9b:
            r12.close()     // Catch: java.lang.Throwable -> La3
            java.lang.Object r12 = sd.l.m1004constructorimpl(r3)     // Catch: java.lang.Throwable -> La3
            goto Lb3
        La3:
            r12 = move-exception
            goto Lab
        La5:
            throw r1     // Catch: java.lang.Throwable -> La6
        La6:
            r2 = move-exception
            a.a.g(r12, r1)     // Catch: java.lang.Throwable -> La3
            throw r2     // Catch: java.lang.Throwable -> La3
        Lab:
            sd.l$a r12 = sd.m.a(r12)
            java.lang.Object r12 = sd.l.m1004constructorimpl(r12)
        Lb3:
            boolean r1 = sd.l.m1010isFailureimpl(r12)
            if (r1 == 0) goto Lba
            goto Lbb
        Lba:
            r0 = r12
        Lbb:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r0
            return r0
    }

    private final java.lang.Object traceFront(wd.d r4) {
            r3 = this;
            oe.e r0 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2
            r2 = 0
            r1.<init>(r2)
            java.lang.Object r4 = kotlinx.coroutines.m0.J(r0, r1, r4)
            return r4
    }

    private final java.lang.Object traceHttp(wd.d r4) {
            r3 = this;
            oe.e r0 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2
            r2 = 0
            r1.<init>(r2)
            java.lang.Object r4 = kotlinx.coroutines.m0.J(r0, r1, r4)
            return r4
    }

    private final java.lang.Object tryServers(java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.Cand> r24, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r25, com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow r26, boolean r27, wd.d r28) {
            r23 = this;
            r0 = r28
            boolean r1 = r0 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06241
            if (r1 == 0) goto L17
            r1 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$1 r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06241) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r23
            goto L1e
        L17:
            com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$1
            r2 = r23
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r4 = r1.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r4 == 0) goto Le9
            if (r4 == r8) goto Lc2
            if (r4 == r7) goto L9c
            if (r4 == r6) goto L6d
            if (r4 != r5) goto L65
            int r4 = r1.I$0
            boolean r10 = r1.Z$0
            java.lang.Object r11 = r1.L$5
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.L$4
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Cand) r12
            java.lang.Object r13 = r1.L$3
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r1.L$2
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r14 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r14
            java.lang.Object r15 = r1.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r15 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r15
            java.lang.Object r5 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r5 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r5
            sd.m.b(r0)     // Catch: java.lang.Throwable -> L5b
            r6 = 4
        L53:
            r19 = r11
            r18 = r12
            r21 = r15
            goto L232
        L5b:
            r0 = move-exception
            r6 = r10
            r10 = r1
            r1 = r15
            r15 = r5
            r5 = r6
            r11 = r14
        L62:
            r6 = 4
            goto L281
        L65:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L6d:
            int r4 = r1.I$0
            boolean r5 = r1.Z$0
            java.lang.Object r10 = r1.L$5
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.L$4
            r12 = r11
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Cand) r12
            java.lang.Object r11 = r1.L$3
            r13 = r11
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r11 = r1.L$2
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r11
            java.lang.Object r14 = r1.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r14 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r14
            java.lang.Object r15 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r15 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r15
            sd.m.b(r0)     // Catch: java.lang.Throwable -> L98
            r22 = r10
            r10 = r5
            r5 = r15
            r15 = r14
            r14 = r11
            r11 = r22
            goto L1e4
        L98:
            r0 = move-exception
            r10 = r1
            r1 = r14
            goto L62
        L9c:
            int r4 = r1.I$0
            boolean r5 = r1.Z$0
            java.lang.Object r10 = r1.L$5
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.L$4
            r12 = r11
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Cand) r12
            java.lang.Object r11 = r1.L$3
            r13 = r11
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r11 = r1.L$2
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r11
            java.lang.Object r14 = r1.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r14 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r14
            java.lang.Object r15 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r15 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r15
            sd.m.b(r0)     // Catch: java.lang.Throwable -> L98
            r0 = r10
            r10 = r5
            r5 = r15
            goto L1c3
        Lc2:
            int r4 = r1.I$0
            boolean r5 = r1.Z$0
            java.lang.Object r10 = r1.L$4
            r12 = r10
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Cand) r12
            java.lang.Object r10 = r1.L$3
            r13 = r10
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r10 = r1.L$2
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r10 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r10
            java.lang.Object r11 = r1.L$1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r11 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Mode) r11
            java.lang.Object r14 = r1.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r14 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r14
            sd.m.b(r0)     // Catch: java.lang.Throwable -> Le1
            goto L14a
        Le1:
            r0 = move-exception
            r6 = r10
            r10 = r1
            r1 = r11
            r11 = r6
            r15 = r14
            goto L62
        Le9:
            sd.m.b(r0)
            java.util.Iterator r0 = r24.iterator()
            r4 = r26
            r5 = r27
            r13 = r0
            r10 = r1
            r11 = r2
            r0 = r9
            r1 = r25
        Lfa:
            boolean r12 = r13.hasNext()
            if (r12 == 0) goto L2e9
            java.lang.Object r0 = r13.next()
            r12 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Cand r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Cand) r12
            r11.check()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r14 = r12.getId()
            java.lang.Object r0 = r0.get(r14)
            sd.j r0 = (sd.j) r0
            com.mlmvpn.scanner.engines.mami.e r14 = new com.mlmvpn.scanner.engines.mami.e
            r14.<init>(r12, r0)
            r11.setStatus(r14)
            r14 = 0
            if (r5 == 0) goto L159
            oe.e r0 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> L152
            com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3 r15 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3     // Catch: java.lang.Throwable -> L152
            r15.<init>(r12, r4, r9)     // Catch: java.lang.Throwable -> L152
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L152
            r10.L$1 = r1     // Catch: java.lang.Throwable -> L152
            r10.L$2 = r4     // Catch: java.lang.Throwable -> L152
            r10.L$3 = r13     // Catch: java.lang.Throwable -> L152
            r10.L$4 = r12     // Catch: java.lang.Throwable -> L152
            r10.L$5 = r9     // Catch: java.lang.Throwable -> L152
            r10.Z$0 = r5     // Catch: java.lang.Throwable -> L152
            r10.I$0 = r14     // Catch: java.lang.Throwable -> L152
            r10.label = r8     // Catch: java.lang.Throwable -> L152
            java.lang.Object r0 = kotlinx.coroutines.m0.J(r0, r15, r10)     // Catch: java.lang.Throwable -> L152
            if (r0 != r3) goto L142
            goto L231
        L142:
            r22 = r11
            r11 = r1
            r1 = r10
            r10 = r4
            r4 = r14
            r14 = r22
        L14a:
            r22 = r10
            r10 = r5
            r5 = r14
            r14 = r11
            r11 = r22
            goto L162
        L152:
            r0 = move-exception
            r15 = r11
            r6 = 4
            r11 = r4
            r4 = r14
            goto L281
        L159:
            r22 = r14
            r14 = r1
            r1 = r10
            r10 = r5
            r5 = r11
            r11 = r4
            r4 = r22
        L162:
            r5.check()     // Catch: java.lang.Throwable -> L26d
            com.mlmvpn.scanner.engines.mami.f r0 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L26d
            r15 = 24
            r0.<init>(r15)     // Catch: java.lang.Throwable -> L26d
            r5.setStatus(r0)     // Catch: java.lang.Throwable -> L26d
            java.lang.String r0 = r5.placeLabel(r12)     // Catch: java.lang.Throwable -> L26d
            java.lang.String r15 = r12.getProfile()     // Catch: java.lang.Throwable -> L26d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26d
            r6.<init>()     // Catch: java.lang.Throwable -> L26d
            java.lang.String r7 = "راه\u200cاندازی موتور با سرور "
            r6.append(r7)     // Catch: java.lang.Throwable -> L27d
            r6.append(r0)     // Catch: java.lang.Throwable -> L27d
            java.lang.String r0 = " ("
            r6.append(r0)     // Catch: java.lang.Throwable -> L27d
            r6.append(r15)     // Catch: java.lang.Throwable -> L27d
            java.lang.String r0 = ")…"
            r6.append(r0)     // Catch: java.lang.Throwable -> L27d
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L27d
            r5.log(r0)     // Catch: java.lang.Throwable -> L27d
            sf.c r0 = r12.getOutbound()     // Catch: java.lang.Throwable -> L27d
            java.lang.String r0 = r5.config(r0)     // Catch: java.lang.Throwable -> L27d
            oe.e r4 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> L279
            com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5 r6 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5     // Catch: java.lang.Throwable -> L279
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L279
            r1.L$0 = r5     // Catch: java.lang.Throwable -> L279
            r1.L$1 = r14     // Catch: java.lang.Throwable -> L279
            r1.L$2 = r11     // Catch: java.lang.Throwable -> L279
            r1.L$3 = r13     // Catch: java.lang.Throwable -> L279
            r1.L$4 = r12     // Catch: java.lang.Throwable -> L279
            r1.L$5 = r0     // Catch: java.lang.Throwable -> L279
            r1.Z$0 = r10     // Catch: java.lang.Throwable -> L279
            r1.I$0 = r8     // Catch: java.lang.Throwable -> L279
            r7 = 2
            r1.label = r7     // Catch: java.lang.Throwable -> L274
            java.lang.Object r4 = kotlinx.coroutines.m0.J(r4, r6, r1)     // Catch: java.lang.Throwable -> L274
            if (r4 != r3) goto L1c2
            goto L231
        L1c2:
            r4 = r8
        L1c3:
            r1.L$0 = r5     // Catch: java.lang.Throwable -> L26d
            r1.L$1 = r14     // Catch: java.lang.Throwable -> L26d
            r1.L$2 = r11     // Catch: java.lang.Throwable -> L26d
            r1.L$3 = r13     // Catch: java.lang.Throwable -> L26d
            r1.L$4 = r12     // Catch: java.lang.Throwable -> L26d
            r1.L$5 = r0     // Catch: java.lang.Throwable -> L26d
            r1.Z$0 = r10     // Catch: java.lang.Throwable -> L26d
            r1.I$0 = r4     // Catch: java.lang.Throwable -> L26d
            r6 = 3
            r1.label = r6     // Catch: java.lang.Throwable -> L26d
            java.lang.Object r15 = r5.launch(r0, r14, r1)     // Catch: java.lang.Throwable -> L26d
            if (r15 != r3) goto L1dd
            goto L231
        L1dd:
            r22 = r11
            r11 = r0
            r0 = r15
            r15 = r14
            r14 = r22
        L1e4:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L26a
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L26a
            if (r0 != 0) goto L207
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L5b
            com.mlmvpn.scanner.MyVpnService$Companion r11 = com.mlmvpn.scanner.MyVpnService.Companion     // Catch: java.lang.Throwable -> L5b
            kotlinx.coroutines.flow.k0 r11 = r11.getConnectionPhaseFlow()     // Catch: java.lang.Throwable -> L5b
            kotlinx.coroutines.flow.g1 r11 = (kotlinx.coroutines.flow.g1) r11     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r11 = r11.getValue()     // Catch: java.lang.Throwable -> L5b
            com.mlmvpn.scanner.MyVpnService$Phase r6 = com.mlmvpn.scanner.MyVpnService.Phase.FAILED     // Catch: java.lang.Throwable -> L5b
            if (r11 != r6) goto L201
            java.lang.String r6 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد"
            goto L203
        L201:
            java.lang.String r6 = "موتور بالا نیامد"
        L203:
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L5b
            throw r0     // Catch: java.lang.Throwable -> L5b
        L207:
            r5.check()     // Catch: java.lang.Throwable -> L26a
            com.mlmvpn.scanner.engines.mami.f r0 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L26a
            r6 = 6
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L26a
            r5.setStatus(r0)     // Catch: java.lang.Throwable -> L26a
            com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$tr$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$tr$1     // Catch: java.lang.Throwable -> L26a
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L26a
            r1.L$0 = r5     // Catch: java.lang.Throwable -> L26a
            r1.L$1 = r15     // Catch: java.lang.Throwable -> L26a
            r1.L$2 = r14     // Catch: java.lang.Throwable -> L26a
            r1.L$3 = r13     // Catch: java.lang.Throwable -> L26a
            r1.L$4 = r12     // Catch: java.lang.Throwable -> L26a
            r1.L$5 = r11     // Catch: java.lang.Throwable -> L26a
            r1.Z$0 = r10     // Catch: java.lang.Throwable -> L26a
            r1.I$0 = r4     // Catch: java.lang.Throwable -> L26a
            r6 = 4
            r1.label = r6     // Catch: java.lang.Throwable -> L262
            java.lang.Object r0 = r5.verify(r0, r1)     // Catch: java.lang.Throwable -> L262
            if (r0 != r3) goto L53
        L231:
            return r3
        L232:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r0     // Catch: java.lang.Throwable -> L250
            if (r0 == 0) goto L25a
            com.mlmvpn.scanner.engines.mami.f r11 = new com.mlmvpn.scanner.engines.mami.f     // Catch: java.lang.Throwable -> L250
            r12 = 7
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L250
            r5.setStatus(r11)     // Catch: java.lang.Throwable -> L250
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r16 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Live     // Catch: java.lang.Throwable -> L250
            java.lang.String r17 = "xray"
            r20 = 0
            r16.<init>(r17, r18, r19, r20, r21)     // Catch: java.lang.Throwable -> L250
            com.mlmvpn.scanner.engines.mami.MamiEngine.live = r16     // Catch: java.lang.Throwable -> L250
            r5.connected(r0)     // Catch: java.lang.Throwable -> L250
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L250
            return r0
        L250:
            r0 = move-exception
            r15 = r5
            r5 = r10
            r11 = r14
            r12 = r18
            r10 = r1
            r1 = r21
            goto L281
        L25a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L250
            java.lang.String r11 = "موتور بالا آمد ولی داده\u200cای از سرور رد نشد"
            r0.<init>(r11)     // Catch: java.lang.Throwable -> L250
            throw r0     // Catch: java.lang.Throwable -> L250
        L262:
            r0 = move-exception
        L263:
            r11 = r10
            r10 = r1
            r1 = r15
            r15 = r5
            r5 = r11
            r11 = r14
            goto L281
        L26a:
            r0 = move-exception
            r6 = 4
            goto L263
        L26d:
            r0 = move-exception
            r6 = 4
        L26f:
            r15 = r5
        L270:
            r5 = r10
            r10 = r1
            r1 = r14
            goto L281
        L274:
            r0 = move-exception
            r6 = 4
        L276:
            r15 = r5
            r4 = r8
            goto L270
        L279:
            r0 = move-exception
            r6 = 4
            r7 = 2
            goto L276
        L27d:
            r0 = move-exception
            r6 = 4
            r7 = 2
            goto L26f
        L281:
            if (r4 == 0) goto L286
            r15.stopService()
        L286:
            boolean r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled
            if (r4 != 0) goto L2e8
            boolean r4 = r0 instanceof java.util.concurrent.CancellationException
            if (r4 != 0) goto L2e8
            boolean r4 = r0 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.Fail
            if (r4 == 0) goto L2a1
            r4 = r0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Fail r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Fail) r4
            java.lang.String r4 = r4.getCode()
            java.lang.String r14 = "ROUTE_FAILED"
            boolean r4 = kotlin.jvm.internal.j.a(r4, r14)
            if (r4 != 0) goto L2e8
        L2a1:
            java.lang.String r4 = r15.placeLabel(r12)
            java.lang.String r14 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "سرور "
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r4 = " وصل نشد: "
            r6.append(r4)
            r6.append(r14)
            java.lang.String r4 = r6.toString()
            r15.log(r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r6 = r12.getId()
            java.lang.Long r7 = new java.lang.Long
            r8 = -1
            r7.<init>(r8)
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r8)
            sd.j r8 = new sd.j
            r8.<init>(r7, r12)
            r4.put(r6, r8)
            r4 = r11
            r11 = r15
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            goto Lfa
        L2e8:
            throw r0
        L2e9:
            if (r0 != 0) goto L2f2
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "وصل نشد"
            r0.<init>(r1)
        L2f2:
            throw r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status tryServers$lambda$70(com.mlmvpn.scanner.engines.mami.MamiEngine.Cand r17, sd.j r18, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r19) {
            java.lang.String r0 = "it"
            r1 = r19
            kotlin.jvm.internal.j.e(r1, r0)
            int r0 = r1.getAttempt()
            int r13 = r0 + 1
            com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRef
            java.lang.String r3 = r17.getId()
            java.lang.String r4 = r17.getCc()
            java.lang.String r5 = r17.getCountry()
            java.lang.String r6 = r17.getCity()
            java.lang.String r7 = r17.getProtocol()
            java.lang.String r8 = r17.getProfile()
            if (r18 == 0) goto L34
            java.lang.Object r0 = r18.getFirst()
            java.lang.Number r0 = (java.lang.Number) r0
            long r9 = r0.longValue()
            goto L36
        L34:
            r9 = 0
        L36:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r15 = 1519(0x5ef, float:2.129E-42)
            r16 = 0
            r6 = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status tryServers$lambda$71(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "engine"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status tryServers$lambda$72(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "verify"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    private static final com.mlmvpn.scanner.engines.mami.MamiEngine.Status tryServers$lambda$73(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r17) {
            java.lang.String r0 = "it"
            r1 = r17
            kotlin.jvm.internal.j.e(r1, r0)
            r15 = 2043(0x7fb, float:2.863E-42)
            r16 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "route"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.Status.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status u(com.mlmvpn.scanner.engines.mami.MamiEngine.Exit r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r1) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connected$lambda$80(r0, r1)
            return r0
    }

    public static /* synthetic */ sd.u v(android.content.Context r0) {
            sd.u r0 = disconnectAsync$lambda$81(r0)
            return r0
    }

    private final java.lang.Object verify(ee.c r11, wd.d r12) {
            r10 = this;
            boolean r0 = r12 instanceof com.mlmvpn.scanner.engines.mami.MamiEngine.C06261
            if (r0 == 0) goto L13
            r0 = r12
            com.mlmvpn.scanner.engines.mami.MamiEngine$verify$1 r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.C06261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mlmvpn.scanner.engines.mami.MamiEngine$verify$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$verify$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$1
            ee.c r2 = (ee.c) r2
            java.lang.Object r6 = r0.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r12)
            goto La2
        L36:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3e:
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$1
            ee.c r2 = (ee.c) r2
            java.lang.Object r6 = r0.L$0
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine) r6
            sd.m.b(r12)     // Catch: java.lang.Throwable -> L4c
            goto L70
        L4c:
            r12 = move-exception
            goto L7b
        L4e:
            sd.m.b(r12)
            r12 = 0
            r6 = r12
            r12 = r11
            r11 = r6
            r6 = r10
        L56:
            r2 = 3
            if (r11 >= r2) goto La5
            boolean r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.cancelled
            if (r2 == 0) goto L5e
            goto La5
        L5e:
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L77
            r0.I$0 = r11     // Catch: java.lang.Throwable -> L77
            r0.label = r5     // Catch: java.lang.Throwable -> L77
            java.lang.Object r2 = r12.invoke(r0)     // Catch: java.lang.Throwable -> L77
            if (r2 != r1) goto L6d
            goto La1
        L6d:
            r9 = r2
            r2 = r12
            r12 = r9
        L70:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r12     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r12 = sd.l.m1004constructorimpl(r12)     // Catch: java.lang.Throwable -> L4c
            goto L83
        L77:
            r2 = move-exception
            r9 = r2
            r2 = r12
            r12 = r9
        L7b:
            sd.l$a r12 = sd.m.a(r12)
            java.lang.Object r12 = sd.l.m1004constructorimpl(r12)
        L83:
            boolean r7 = sd.l.m1010isFailureimpl(r12)
            if (r7 == 0) goto L8a
            r12 = r3
        L8a:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Exit r12 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Exit) r12
            if (r12 == 0) goto L8f
            return r12
        L8f:
            if (r11 >= r4) goto La2
            r0.L$0 = r6
            r0.L$1 = r2
            r0.I$0 = r11
            r0.label = r4
            r7 = 1200(0x4b0, double:5.93E-321)
            java.lang.Object r12 = kotlinx.coroutines.m0.j(r7, r0)
            if (r12 != r1) goto La2
        La1:
            return r1
        La2:
            r12 = r2
            int r11 = r11 + r5
            goto L56
        La5:
            return r3
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status w(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectExclusive$lambda$67(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status x(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = tryServers$lambda$71(r0)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status y(java.lang.String r0, com.mlmvpn.scanner.engines.mami.MamiEngine.Status r1) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectExclusive$lambda$69(r0, r1)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.mami.MamiEngine.Status z(com.mlmvpn.scanner.engines.mami.MamiEngine.Status r0) {
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = connectHive$lambda$58(r0)
            return r0
    }

    public final com.mlmvpn.scanner.engines.mami.MamiEngine.CatalogInfo catalogInfo() {
            r18 = this;
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiApi$Summary r1 = r0.summary()
            boolean r2 = r1.getHasCatalog()
            if (r2 != 0) goto Le
            r0 = 0
            return r0
        Le:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r2 = r18.parsedSaved()
            com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo r3 = new com.mlmvpn.scanner.engines.mami.MamiEngine$CatalogInfo
            long r4 = r1.getCatalogRevision()
            int r6 = r1.getCatalogPayloadVersion()
            r7 = 0
            if (r2 == 0) goto L24
            int r8 = r2.getVersion()
            goto L25
        L24:
            r8 = r7
        L25:
            if (r2 == 0) goto L32
            java.util.List r9 = r2.getServers()
            if (r9 == 0) goto L32
            int r9 = r9.size()
            goto L33
        L32:
            r9 = r7
        L33:
            if (r2 == 0) goto L40
            java.util.List r2 = r2.getSkipped()
            if (r2 == 0) goto L40
            int r2 = r2.size()
            goto L41
        L40:
            r2 = r7
        L41:
            long r10 = r1.getCatalogFetchedAt()
            long r12 = r1.getCatalogExpiresAt()
            long r14 = r1.getCatalogExpiresAt()
            r16 = 0
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 <= 0) goto L60
            long r14 = r1.getCatalogExpiresAt()
            long r0 = r0.nowSec()
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L60
            r7 = 1
        L60:
            r14 = r7
            r7 = r8
            r8 = r9
            r9 = r2
            r3.<init>(r4, r6, r7, r8, r9, r10, r12, r14)
            return r3
    }

    public final void clearError() {
            r2 = this;
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r0 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r0
            java.lang.String r0 = r0.getError()
            if (r0 == 0) goto L1a
            com.mlmvpn.scanner.engines.mami.f r0 = new com.mlmvpn.scanner.engines.mami.f
            r1 = 23
            r0.<init>(r1)
            r2.setStatus(r0)
        L1a:
            return
    }

    public final kotlinx.coroutines.s1 connectAsync(android.content.Context r4, java.lang.String r5, java.util.List<java.lang.String> r6) {
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            java.lang.String r0 = "exclude"
            kotlin.jvm.internal.j.e(r6, r0)
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.connectionOwner
            com.mlmvpn.core.aether.c r1 = new com.mlmvpn.core.aether.c
            r2 = 5
            r1.<init>(r4, r2, r5, r6)
            r4 = 0
            java.lang.Object r4 = r0.replace(r4, r1)
            kotlinx.coroutines.s1 r4 = (kotlinx.coroutines.s1) r4
            return r4
    }

    public final com.mlmvpn.scanner.engines.mami.MamiApi.Summary control$app_release() {
            r1 = this;
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiApi$Summary r0 = r0.summary()
            return r0
    }

    public final boolean disconnectAsync(android.content.Context r4) {
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.connectionOwner
            com.mlmvpn.scanner.engines.mami.d r1 = new com.mlmvpn.scanner.engines.mami.d
            r2 = 0
            r1.<init>(r4, r2)
            r4 = 0
            boolean r4 = r0.stop(r4, r1)
            return r4
    }

    public final java.lang.String forget(android.content.Context r2, boolean r3) {
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            r1.init(r2)
            kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
            java.lang.Object r2 = r2.getValue()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r2
            java.lang.String r2 = r2.getPhase()
            java.lang.String r0 = "off"
            boolean r2 = kotlin.jvm.internal.j.a(r2, r0)
            if (r2 != 0) goto L21
            java.lang.String r2 = "اول اتصال مامی را قطع کنید"
            return r2
        L21:
            com.mlmvpn.scanner.engines.mami.MamiApi r2 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE     // Catch: java.lang.Exception -> L38
            r2.forget(r3)     // Catch: java.lang.Exception -> L38
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays     // Catch: java.lang.Exception -> L38
            r2.clear()     // Catch: java.lang.Exception -> L38
            r2 = 0
            com.mlmvpn.scanner.engines.mami.MamiEngine.cat = r2     // Catch: java.lang.Exception -> L38
            com.mlmvpn.scanner.engines.mami.MamiEngine.hiveCat = r2     // Catch: java.lang.Exception -> L38
            r1.saveRoute(r2)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L3a
            java.lang.String r3 = "هویت این دستگاه و نشست آن پاک شد؛ اتصال بعدی دستگاه را دوباره ثبت می\u200cکند."
            goto L3c
        L38:
            r2 = move-exception
            goto L43
        L3a:
            java.lang.String r3 = "نشست و فهرست ذخیره\u200cشده پاک شد."
        L3c:
            r1.log(r3)     // Catch: java.lang.Exception -> L38
            r1.bump()     // Catch: java.lang.Exception -> L38
            return r2
        L43:
            java.lang.String r2 = r2.getMessage()
            if (r2 != 0) goto L4b
            java.lang.String r2 = "پاک نشد"
        L4b:
            return r2
    }

    public final java.lang.String freshConfig(android.content.Context r2) {
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            r1.init(r2)
            com.mlmvpn.scanner.engines.mami.MamiEngine$Live r2 = com.mlmvpn.scanner.engines.mami.MamiEngine.live
            if (r2 == 0) goto L11
            java.lang.String r2 = r2.getConfig()
            return r2
        L11:
            r2 = 0
            return r2
    }

    public final kotlinx.coroutines.flow.e1 getBusy() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.busy
            return r0
    }

    public final java.lang.String getFrontMarker() {
            r1 = this;
            java.lang.String r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.frontMarker
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getLogs() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.logs
            return r0
    }

    public final java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.Method> getMETHODS() {
            r1 = this;
            java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine$Method> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.METHODS
            return r0
    }

    public final java.util.Map<java.lang.String, java.lang.String> getSTEP_WORDS() {
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.STEP_WORDS
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getStatus() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.status
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getVersion() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.version
            return r0
    }

    public final com.mlmvpn.scanner.engines.mami.MamiEngine.HiveInfo hiveInfo() {
            r13 = this;
            com.mlmvpn.scanner.engines.mami.MamiApi r0 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiApi$Summary r0 = r0.summary()
            boolean r1 = r0.getHasHive()
            if (r1 != 0) goto Le
            r0 = 0
            return r0
        Le:
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Hive r1 = r13.parsedHive()
            com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$HiveInfo
            long r3 = r0.getHiveFetchedAt()
            long r5 = r0.getHiveRevision()
            r7 = 0
            if (r1 == 0) goto L2a
            java.util.List r8 = r1.getServers()
            if (r8 == 0) goto L2a
            int r8 = r8.size()
            goto L2b
        L2a:
            r8 = r7
        L2b:
            if (r1 == 0) goto L38
            java.util.List r1 = r1.getSkipped()
            if (r1 == 0) goto L38
            int r1 = r1.size()
            goto L39
        L38:
            r1 = r7
        L39:
            long r9 = java.lang.System.currentTimeMillis()
            long r11 = r0.getHiveFetchedAt()
            long r9 = r9 - r11
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 >= 0) goto L4a
            r7 = 1
        L4a:
            r9 = r7
            r7 = r8
            r8 = r1
            r2.<init>(r3, r5, r7, r8, r9)
            return r2
    }

    public final void init(android.content.Context r6) {
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r6, r0)
            android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r0 == 0) goto La
            return
        La:
            android.content.Context r6 = r6.getApplicationContext()
            com.mlmvpn.scanner.engines.mami.MamiEngine.app = r6
            java.lang.String r0 = "app"
            r1 = 0
            if (r6 == 0) goto L7c
            android.content.res.AssetManager r6 = r6.getAssets()
            java.lang.String r2 = "mami/catalog-bootstrap.json"
            java.io.InputStream r6 = r6.open(r2)
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L75
            kotlin.jvm.internal.j.b(r6)     // Catch: java.lang.Throwable -> L75
            byte[] r3 = x6.t.p(r6)     // Catch: java.lang.Throwable -> L75
            java.nio.charset.Charset r4 = kotlin.text.a.f23859a     // Catch: java.lang.Throwable -> L75
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L75
            a.a.g(r6, r1)
            com.mlmvpn.scanner.engines.mami.MamiApi r6 = com.mlmvpn.scanner.engines.mami.MamiApi.INSTANCE
            java.io.File r3 = new java.io.File
            android.content.Context r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r4 == 0) goto L71
            java.io.File r0 = r4.getFilesDir()
            java.lang.String r1 = "mami"
            r3.<init>(r0, r1)
            java.lang.String r0 = "http.agent"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L4b
            java.lang.String r0 = ""
        L4b:
            sf.c r1 = r5.clientInfo()
            r6.init(r3, r2, r0, r1)
            com.mlmvpn.scanner.engines.mami.f r0 = new com.mlmvpn.scanner.engines.mami.f
            r1 = 11
            r0.<init>(r1)
            r6.setLogger(r0)
            com.mlmvpn.scanner.engines.mami.a r0 = new com.mlmvpn.scanner.engines.mami.a
            r1 = 1
            r0.<init>(r1)
            r6.setNetworkOf(r0)
            com.mlmvpn.scanner.engines.mami.MamiNet r6 = com.mlmvpn.scanner.engines.mami.MamiNet.INSTANCE
            com.mlmvpn.scanner.engines.mami.a r0 = new com.mlmvpn.scanner.engines.mami.a
            r1 = 2
            r0.<init>(r1)
            r6.setRouteOf(r0)
            return
        L71:
            kotlin.jvm.internal.j.k(r0)
            throw r1
        L75:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L77
        L77:
            r1 = move-exception
            a.a.g(r6, r0)
            throw r1
        L7c:
            kotlin.jvm.internal.j.k(r0)
            throw r1
    }

    public final boolean isMamiConfig(java.lang.String r2) {
            r1 = this;
            java.lang.String r0 = "mlm-mami-v1"
            boolean r2 = kotlin.jvm.internal.j.a(r2, r0)
            return r2
    }

    public final boolean isOurs() {
            r2 = this;
            com.mlmvpn.scanner.MyVpnService$Companion r0 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r0 = r0.getConnectedNodeIdFlow()
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "mami"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            return r0
    }

    public final java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow> locations() {
            r15 = this;
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = r15.parsedSaved()
            if (r0 != 0) goto L9
            kotlin.collections.w r0 = kotlin.collections.w.INSTANCE
            return r0
        L9:
            java.util.List r1 = r0.getServers()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$groupingBy$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$groupingBy$1
            r2.<init>(r1)
            java.util.Map r1 = s7.e.h(r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.List r3 = r0.getLocations()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 10
            r5 = 0
            if (r3 != 0) goto L81
            java.util.List r0 = r0.getLocations()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.s.g0(r0, r4)
            r3.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L3f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Ldc
            java.lang.Object r4 = r0.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Location r4 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Location) r4
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Place r6 = r6.placeOfLocation(r4)
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r7 = new com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow
            java.lang.String r8 = r4.getId()
            java.lang.String r9 = r4.getCountryCode()
            java.lang.String r10 = r6.getCountry()
            java.lang.String r11 = r6.getCity()
            int r12 = r4.getSort()
            java.lang.String r4 = r4.getId()
            java.lang.Object r4 = r1.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L79
            int r4 = r4.intValue()
            r13 = r4
            goto L7a
        L79:
            r13 = r5
        L7a:
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r3.add(r7)
            goto L3f
        L81:
            java.util.List r0 = r0.getServers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.s.g0(r0, r4)
            r3.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L94:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Ldc
            java.lang.Object r4 = r0.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r4 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r4
            com.mlmvpn.scanner.engines.mami.MamiEngine r6 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            sd.j r6 = r6.placeOfServer(r4)
            java.lang.Object r7 = r6.component1()
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r6 = r6.component2()
            r12 = r6
            java.lang.String r12 = (java.lang.String) r12
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r8 = new com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow
            java.lang.String r9 = r4.getLocationId()
            java.lang.String r10 = r4.getCountryCode()
            int r13 = r4.getSort()
            java.lang.String r4 = r4.getLocationId()
            java.lang.Object r4 = r1.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto Ld4
            int r4 = r4.intValue()
            r14 = r4
            goto Ld5
        Ld4:
            r14 = r5
        Ld5:
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r3.add(r8)
            goto L94
        Ldc:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r3.size()
        Le5:
            if (r5 >= r1) goto Lfe
            java.lang.Object r4 = r3.get(r5)
            int r5 = r5 + 1
            r6 = r4
            com.mlmvpn.scanner.engines.mami.MamiEngine$PlaceRow r6 = (com.mlmvpn.scanner.engines.mami.MamiEngine.PlaceRow) r6
            java.lang.String r6 = r6.getId()
            boolean r6 = r2.add(r6)
            if (r6 == 0) goto Le5
            r0.add(r4)
            goto Le5
        Lfe:
            com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$compareBy$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$compareBy$1
            r1.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$thenBy$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$thenBy$1
            r2.<init>(r1)
            java.util.List r0 = kotlin.collections.q.b1(r0, r2)
            return r0
    }

    public final void log(java.lang.String r4) {
            r3 = this;
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.j.e(r4, r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "HH:mm:ss"
            java.util.Locale r2 = java.util.Locale.US
            r0.<init>(r1, r2)
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            java.lang.String r0 = r0.format(r1)
            java.lang.String r1 = "["
            java.lang.String r2 = "] "
            java.lang.String r0 = org.telegram.ui.Cells.d1.g(r1, r0, r2, r4)
            java.lang.String r1 = "MAMI"
            android.util.Log.i(r1, r4)
            kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.mami.MamiEngine._logs
            java.util.List r0 = m9.d.B(r0)
            java.util.Collection r0 = (java.util.Collection) r0
            kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
            java.lang.Object r1 = r4.getValue()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r0 = kotlin.collections.q.S0(r0, r1)
            r1 = 300(0x12c, float:4.2E-43)
            java.util.List r0 = kotlin.collections.q.e1(r0, r1)
            r4.j(r0)
            return
    }

    public final kotlinx.coroutines.s1 measureAllAsync(android.content.Context r4) {
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1
            r2 = 0
            r1.<init>(r4, r2)
            r4 = 3
            kotlinx.coroutines.q2 r4 = kotlinx.coroutines.m0.y(r0, r2, r2, r1, r4)
            return r4
    }

    public final com.mlmvpn.scanner.engines.mami.MamiEngine.Method method(java.lang.String r4) {
            r3 = this;
            java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine$Method> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.METHODS
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L20
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r2 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r2
            java.lang.String r2 = r2.getKey()
            boolean r2 = kotlin.jvm.internal.j.a(r2, r4)
            if (r2 == 0) goto L8
            goto L21
        L20:
            r1 = 0
        L21:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r1 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Method) r1
            return r1
    }

    public final com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs prefs() {
            r5 = this;
            android.content.SharedPreferences r0 = r5.sp()
            java.lang.String r1 = "method"
            java.lang.String r2 = "auto"
            java.lang.String r1 = r0.getString(r1, r2)
            com.mlmvpn.scanner.engines.mami.MamiEngine r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r3 = r3.method(r1)
            if (r3 == 0) goto L15
            goto L16
        L15:
            r1 = 0
        L16:
            if (r1 != 0) goto L19
            goto L1a
        L19:
            r2 = r1
        L1a:
            java.lang.String r1 = "mode"
            java.lang.String r3 = "tunnel"
            java.lang.String r1 = r0.getString(r1, r3)
            java.lang.String r3 = "proxy"
            boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
            if (r1 == 0) goto L2d
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
            goto L2f
        L2d:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r1 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.TUNNEL
        L2f:
            java.lang.String r3 = "location"
            java.lang.String r4 = ""
            java.lang.String r0 = r0.getString(r3, r4)
            if (r0 != 0) goto L3a
            goto L3b
        L3a:
            r4 = r0
        L3b:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs
            r0.<init>(r2, r1, r4)
            return r0
    }

    public final void prewarm(android.content.Context r4) {
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            r3.init(r4)
            kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.mami.MamiEngine._status
            kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
            java.lang.Object r4 = r4.getValue()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Status r4 = (com.mlmvpn.scanner.engines.mami.MamiEngine.Status) r4
            java.lang.String r4 = r4.getPhase()
            java.lang.String r0 = "off"
            boolean r4 = kotlin.jvm.internal.j.a(r4, r0)
            if (r4 != 0) goto L1f
            goto L3a
        L1f:
            com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r4 = r3.prefs()
            java.lang.String r4 = r4.getMethod()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r4 = r3.method(r4)
            if (r4 != 0) goto L2e
            goto L3a
        L2e:
            java.lang.String r0 = r4.getKind()
            java.lang.String r1 = "front"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            if (r0 == 0) goto L3b
        L3a:
            return
        L3b:
            java.lang.String r0 = r4.getKey()
            java.lang.String r1 = "auto"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            r1 = 0
            java.lang.String r2 = "app"
            if (r0 != 0) goto L56
            java.lang.String r4 = r4.getKey()
            java.lang.String r0 = "hive"
            boolean r4 = kotlin.jvm.internal.j.a(r4, r0)
            if (r4 == 0) goto L5f
        L56:
            com.mlmvpn.scanner.data.CombineEngine r4 = com.mlmvpn.scanner.data.CombineEngine.INSTANCE
            android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r0 == 0) goto L71
            r4.warmMeasure(r0)
        L5f:
            com.mlmvpn.core.warp.XrayHosts r4 = com.mlmvpn.core.warp.XrayHosts.INSTANCE
            android.content.Context r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.app
            if (r0 == 0) goto L6d
            com.mlmvpn.core.warp.XrayHosts$Host r1 = r4.getTUNNEL()
            r4.warm(r0, r1)
            return
        L6d:
            kotlin.jvm.internal.j.k(r2)
            throw r1
        L71:
            kotlin.jvm.internal.j.k(r2)
            throw r1
    }

    public final kotlinx.coroutines.s1 refreshAsync(android.content.Context r4, java.lang.String r5) {
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r4, r0)
            java.lang.String r0 = "what"
            kotlin.jvm.internal.j.e(r5, r0)
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.scope
            com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1 r1 = new com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1
            r2 = 0
            r1.<init>(r4, r5, r2)
            r4 = 3
            kotlinx.coroutines.q2 r4 = kotlinx.coroutines.m0.y(r0, r2, r2, r1, r4)
            return r4
    }

    public final java.util.List<com.mlmvpn.scanner.engines.mami.MamiEngine.ServerRow> servers() {
            r21 = this;
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Parsed r0 = r21.parsedSaved()
            if (r0 != 0) goto L9
            kotlin.collections.w r0 = kotlin.collections.w.INSTANCE
            return r0
        L9:
            java.util.List r0 = r0.getServers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.s.g0(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto La1
            java.lang.Object r2 = r0.next()
            com.mlmvpn.scanner.engines.mami.MamiCatalog$Server r2 = (com.mlmvpn.scanner.engines.mami.MamiCatalog.Server) r2
            java.util.concurrent.ConcurrentHashMap<java.lang.String, sd.j> r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.delays
            java.lang.String r4 = r2.getId()
            java.lang.Object r3 = r3.get(r4)
            sd.j r3 = (sd.j) r3
            com.mlmvpn.scanner.engines.mami.MamiEngine r4 = com.mlmvpn.scanner.engines.mami.MamiEngine.INSTANCE
            sd.j r4 = r4.placeOfServer(r2)
            java.lang.Object r5 = r4.component1()
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r4 = r4.component2()
            r10 = r4
            java.lang.String r10 = (java.lang.String) r10
            com.mlmvpn.scanner.engines.mami.MamiXrayConfig r4 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.INSTANCE
            r5 = 2
            r6 = 0
            r7 = 0
            java.lang.String r4 = com.mlmvpn.scanner.engines.mami.MamiXrayConfig.unsupportedReason$default(r4, r2, r7, r5, r6)
            com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow r6 = new com.mlmvpn.scanner.engines.mami.MamiEngine$ServerRow
            r5 = r7
            java.lang.String r7 = r2.getId()
            java.lang.String r8 = r2.getCountryCode()
            java.lang.String r11 = r2.getLocationId()
            java.lang.String r12 = r2.getProtocol()
            java.lang.String r13 = r2.getProfile()
            int r14 = r2.getSort()
            if (r4 != 0) goto L73
            r2 = 1
            r15 = r2
            goto L74
        L73:
            r15 = r5
        L74:
            if (r4 != 0) goto L78
            java.lang.String r4 = ""
        L78:
            r16 = r4
            r4 = 0
            if (r3 == 0) goto L89
            java.lang.Object r2 = r3.getFirst()
            java.lang.Number r2 = (java.lang.Number) r2
            long r17 = r2.longValue()
            goto L8b
        L89:
            r17 = r4
        L8b:
            if (r3 == 0) goto L97
            java.lang.Object r2 = r3.getSecond()
            java.lang.Number r2 = (java.lang.Number) r2
            long r4 = r2.longValue()
        L97:
            r19 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19)
            r1.add(r6)
            goto L1e
        La1:
            com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$compareBy$1 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$compareBy$1
            r0.<init>()
            com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$1 r2 = new com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$1
            r2.<init>(r0)
            com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$2 r0 = new com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$2
            r0.<init>(r2)
            java.util.List r0 = kotlin.collections.q.b1(r1, r0)
            return r0
    }

    public final com.mlmvpn.scanner.engines.mami.MamiEngine.Prefs setPrefs(java.lang.String r3, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r4, java.lang.String r5) {
            r2 = this;
            android.content.SharedPreferences r0 = r2.sp()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r3 == 0) goto L15
            com.mlmvpn.scanner.engines.mami.MamiEngine$Method r1 = r2.method(r3)
            if (r1 == 0) goto L15
            java.lang.String r1 = "method"
            r0.putString(r1, r3)
        L15:
            if (r4 == 0) goto L25
            com.mlmvpn.scanner.engines.mami.MamiEngine$Mode r3 = com.mlmvpn.scanner.engines.mami.MamiEngine.Mode.PROXY
            if (r4 != r3) goto L1e
            java.lang.String r3 = "proxy"
            goto L20
        L1e:
            java.lang.String r3 = "tunnel"
        L20:
            java.lang.String r4 = "mode"
            r0.putString(r4, r3)
        L25:
            if (r5 == 0) goto L37
            java.lang.String r3 = "^[A-Za-z0-9_-]{0,64}$"
            boolean r3 = com.mlmvpn.core.aether.i.B(r3, r5)
            if (r3 == 0) goto L30
            goto L32
        L30:
            java.lang.String r5 = ""
        L32:
            java.lang.String r3 = "location"
            r0.putString(r3, r5)
        L37:
            r0.apply()
            r2.bump()
            com.mlmvpn.scanner.engines.mami.MamiEngine$Prefs r3 = r2.prefs()
            return r3
    }

    public final java.lang.String unnamed$app_release(java.lang.String r6, java.lang.String r7) {
            r5 = this;
            java.lang.String r0 = "method"
            kotlin.jvm.internal.j.e(r7, r0)
            if (r6 != 0) goto L9
            java.lang.String r6 = ""
        L9:
            java.lang.String r0 = "سرور آرگو"
            java.lang.String r1 = "پل"
            java.lang.String r6 = kotlin.text.v.q0(r6, r0, r1)
            java.lang.String r0 = "به آرگو"
            java.lang.String r1 = "به پل"
            java.lang.String r6 = kotlin.text.v.q0(r6, r0, r1)
            java.util.List<java.lang.String> r0 = com.mlmvpn.scanner.engines.mami.MamiEngine.ENGINE_NAMES
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L52
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            kotlin.text.l r2 = new kotlin.text.l
            kotlin.text.j r3 = kotlin.text.l.Companion
            r3.getClass()
            java.lang.String r3 = "literal"
            kotlin.jvm.internal.j.e(r1, r3)
            java.lang.String r1 = java.util.regex.Pattern.quote(r1)
            java.lang.String r3 = "quote(...)"
            kotlin.jvm.internal.j.d(r1, r3)
            java.lang.String r3 = "(?<![\\p{L}\\p{M}])"
            java.lang.String r4 = "(?![\\p{L}\\p{M}])"
            java.lang.String r1 = a6.w0.n(r3, r1, r4)
            kotlin.text.m r3 = kotlin.text.m.IGNORE_CASE
            r2.<init>(r1, r3)
            java.lang.String r6 = r2.replace(r6, r7)
            goto L1f
        L52:
            return r6
    }
}
