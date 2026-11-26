package com.mlmvpn.scanner.engines.argo;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoPool {
    public static final int $stable = 0;
    private static final java.lang.String ASSET = "argo/argo-pool.json";
    private static final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Source> BUILTIN = null;
    private static final java.lang.String CARRY_UA = null;
    private static final long CARRY_UA_FIXED_AT = 1794063600000L;
    private static final java.lang.String CARRY_URL = "https://cachefly.cachefly.net/1mb.test";
    private static final java.util.List<java.lang.String> CF_V4 = null;
    private static final java.util.List<java.lang.String> CF_V6 = null;
    public static final com.mlmvpn.scanner.engines.argo.ArgoPool INSTANCE = null;
    private static final kotlin.text.l IPV4_LITERAL = null;
    private static final java.lang.String TAG = "ARGO";
    private static final int TEST_BATCH = 12;
    private static final java.lang.String TRACE_URL = "https://www.cloudflare.com/cdn-cgi/trace";
    private static final kotlinx.coroutines.flow.k0 _version = null;
    private static android.content.Context app;
    private static long bundleBuilt;
    private static sf.c cleanScan;
    private static java.io.File dir;
    private static java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> falconServers;
    private static volatile com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan ipScan;
    private static final java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool.Item> items = null;
    private static boolean loaded;
    private static com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs prefs;
    private static final java.security.SecureRandom random = null;
    private static final java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool.Result> results = null;
    private static volatile boolean saveQueued;
    private static volatile boolean scanCancel;
    private static final kotlinx.coroutines.i0 scope = null;
    private static final java.util.HashMap<java.lang.String, sf.c> sourceState = null;
    private static volatile boolean testCancel;
    private static volatile com.mlmvpn.scanner.engines.argo.ArgoPool.Job testJob;
    private static volatile boolean updateCancel;
    private static volatile com.mlmvpn.scanner.engines.argo.ArgoPool.Job updateJob;
    private static final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Source> userSources = null;
    private static final kotlinx.coroutines.flow.e1 version = null;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Absorbed {
        public static final int $stable = 0;
        private final int bad;
        private final int bridges;
        private final int falcons;

        public Absorbed(int r1, int r2, int r3) {
                r0 = this;
                r0.<init>()
                r0.bridges = r1
                r0.falcons = r2
                r0.bad = r3
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed r0, int r1, int r2, int r3, int r4, java.lang.Object r5) {
                r5 = r4 & 1
                if (r5 == 0) goto L6
                int r1 = r0.bridges
            L6:
                r5 = r4 & 2
                if (r5 == 0) goto Lc
                int r2 = r0.falcons
            Lc:
                r4 = r4 & 4
                if (r4 == 0) goto L12
                int r3 = r0.bad
            L12:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r0 = r0.copy(r1, r2, r3)
                return r0
        }

        public final int component1() {
                r1 = this;
                int r0 = r1.bridges
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.falcons
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.bad
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed copy(int r2, int r3, int r4) {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed) r5
                int r1 = r4.bridges
                int r3 = r5.bridges
                if (r1 == r3) goto L13
                return r2
            L13:
                int r1 = r4.falcons
                int r3 = r5.falcons
                if (r1 == r3) goto L1a
                return r2
            L1a:
                int r1 = r4.bad
                int r5 = r5.bad
                if (r1 == r5) goto L21
                return r2
            L21:
                return r0
        }

        public final int getBad() {
                r1 = this;
                int r0 = r1.bad
                return r0
        }

        public final int getBridges() {
                r1 = this;
                int r0 = r1.bridges
                return r0
        }

        public final int getFalcons() {
                r1 = this;
                int r0 = r1.falcons
                return r0
        }

        public int hashCode() {
                r3 = this;
                int r0 = r3.bridges
                int r0 = java.lang.Integer.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                int r2 = r3.falcons
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r1 = r3.bad
                int r1 = java.lang.Integer.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r6 = this;
                int r0 = r6.bridges
                int r1 = r6.falcons
                int r2 = r6.bad
                java.lang.String r3 = ", falcons="
                java.lang.String r4 = ", bad="
                java.lang.String r5 = "Absorbed(bridges="
                java.lang.StringBuilder r0 = androidx.compose.foundation.interaction.f.u(r5, r0, r3, r1, r4)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.q(r0, r2, r1)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class CleanIp {
        public static final int $stable = 0;
        private final long auth;
        private final java.lang.String ip;
        private final long kbps;
        private final java.lang.String loc;
        private final long tls;

        public CleanIp(java.lang.String r2, long r3, long r5, long r7, java.lang.String r9) {
                r1 = this;
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "loc"
                kotlin.jvm.internal.j.e(r9, r0)
                r1.<init>()
                r1.ip = r2
                r1.tls = r3
                r1.auth = r5
                r1.kbps = r7
                r1.loc = r9
                return
        }

        public /* synthetic */ CleanIp(java.lang.String r11, long r12, long r14, long r16, java.lang.String r18, int r19, kotlin.jvm.internal.e r20) {
                r10 = this;
                r0 = r19 & 16
                if (r0 == 0) goto Le
                java.lang.String r0 = ""
                r9 = r0
            L7:
                r1 = r10
                r2 = r11
                r3 = r12
                r5 = r14
                r7 = r16
                goto L11
            Le:
                r9 = r18
                goto L7
            L11:
                r1.<init>(r2, r3, r5, r7, r9)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp r0, java.lang.String r1, long r2, long r4, long r6, java.lang.String r8, int r9, java.lang.Object r10) {
                r10 = r9 & 1
                if (r10 == 0) goto L6
                java.lang.String r1 = r0.ip
            L6:
                r10 = r9 & 2
                if (r10 == 0) goto Lc
                long r2 = r0.tls
            Lc:
                r10 = r9 & 4
                if (r10 == 0) goto L12
                long r4 = r0.auth
            L12:
                r10 = r9 & 8
                if (r10 == 0) goto L18
                long r6 = r0.kbps
            L18:
                r9 = r9 & 16
                if (r9 == 0) goto L1e
                java.lang.String r8 = r0.loc
            L1e:
                r10 = r8
                r8 = r6
                r6 = r4
                r4 = r2
                r2 = r0
                r3 = r1
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r0 = r2.copy(r3, r4, r6, r8, r10)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.ip
                return r0
        }

        public final long component2() {
                r2 = this;
                long r0 = r2.tls
                return r0
        }

        public final long component3() {
                r2 = this;
                long r0 = r2.auth
                return r0
        }

        public final long component4() {
                r2 = this;
                long r0 = r2.kbps
                return r0
        }

        public final java.lang.String component5() {
                r1 = this;
                java.lang.String r0 = r1.loc
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp copy(java.lang.String r11, long r12, long r14, long r16, java.lang.String r18) {
                r10 = this;
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "loc"
                r9 = r18
                kotlin.jvm.internal.j.e(r9, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp
                r2 = r11
                r3 = r12
                r5 = r14
                r7 = r16
                r1.<init>(r2, r3, r5, r7, r9)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp) r8
                java.lang.String r1 = r7.ip
                java.lang.String r3 = r8.ip
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                long r3 = r7.tls
                long r5 = r8.tls
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L20
                return r2
            L20:
                long r3 = r7.auth
                long r5 = r8.auth
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L29
                return r2
            L29:
                long r3 = r7.kbps
                long r5 = r8.kbps
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L32
                return r2
            L32:
                java.lang.String r1 = r7.loc
                java.lang.String r8 = r8.loc
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L3d
                return r2
            L3d:
                return r0
        }

        public final long getAuth() {
                r2 = this;
                long r0 = r2.auth
                return r0
        }

        public final java.lang.String getIp() {
                r1 = this;
                java.lang.String r0 = r1.ip
                return r0
        }

        public final long getKbps() {
                r2 = this;
                long r0 = r2.kbps
                return r0
        }

        public final java.lang.String getLoc() {
                r1 = this;
                java.lang.String r0 = r1.loc
                return r0
        }

        public final long getTls() {
                r2 = this;
                long r0 = r2.tls
                return r0
        }

        public int hashCode() {
                r4 = this;
                java.lang.String r0 = r4.ip
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                long r2 = r4.tls
                int r0 = a6.w0.c(r0, r1, r2)
                long r2 = r4.auth
                int r0 = a6.w0.c(r0, r1, r2)
                long r2 = r4.kbps
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r1 = r4.loc
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r10 = this;
                java.lang.String r0 = r10.ip
                long r1 = r10.tls
                long r3 = r10.auth
                long r5 = r10.kbps
                java.lang.String r7 = r10.loc
                java.lang.String r8 = "CleanIp(ip="
                java.lang.String r9 = ", tls="
                java.lang.StringBuilder r0 = androidx.media3.common.s.m(r8, r0, r9, r1)
                java.lang.String r1 = ", auth="
                java.lang.String r2 = ", kbps="
                v0.a.k(r3, r1, r2, r0)
                java.lang.String r1 = ", loc="
                com.mlmvpn.core.aether.i.t(r5, r1, r7, r0)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Counts {
        public static final int $stable = 0;
        private final int alive;
        private final int bridge;
        private final int falcon;

        /* JADX INFO: renamed from: public, reason: not valid java name */
        private final int f2public;
        private final int tested;
        private final int total;
        private final int verified;
        private final long verifiedAt;

        public Counts(int r1, int r2, int r3, int r4, int r5, int r6, int r7, long r8) {
                r0 = this;
                r0.<init>()
                r0.bridge = r1
                r0.falcon = r2
                r0.f2public = r3
                r0.total = r4
                r0.alive = r5
                r0.tested = r6
                r0.verified = r7
                r0.verifiedAt = r8
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Counts copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Counts r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, long r8, int r10, java.lang.Object r11) {
                r11 = r10 & 1
                if (r11 == 0) goto L6
                int r1 = r0.bridge
            L6:
                r11 = r10 & 2
                if (r11 == 0) goto Lc
                int r2 = r0.falcon
            Lc:
                r11 = r10 & 4
                if (r11 == 0) goto L12
                int r3 = r0.f2public
            L12:
                r11 = r10 & 8
                if (r11 == 0) goto L18
                int r4 = r0.total
            L18:
                r11 = r10 & 16
                if (r11 == 0) goto L1e
                int r5 = r0.alive
            L1e:
                r11 = r10 & 32
                if (r11 == 0) goto L24
                int r6 = r0.tested
            L24:
                r11 = r10 & 64
                if (r11 == 0) goto L2a
                int r7 = r0.verified
            L2a:
                r10 = r10 & 128(0x80, float:1.794E-43)
                if (r10 == 0) goto L30
                long r8 = r0.verifiedAt
            L30:
                r10 = r8
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r2 = r0
                r3 = r1
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9, r10)
                return r0
        }

        public final int component1() {
                r1 = this;
                int r0 = r1.bridge
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.falcon
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.f2public
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final int component6() {
                r1 = this;
                int r0 = r1.tested
                return r0
        }

        public final int component7() {
                r1 = this;
                int r0 = r1.verified
                return r0
        }

        public final long component8() {
                r2 = this;
                long r0 = r2.verifiedAt
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Counts copy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, long r18) {
                r10 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Counts
                r1 = r11
                r2 = r12
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r16
                r7 = r17
                r8 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                return r0
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Counts
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Counts) r8
                int r1 = r7.bridge
                int r3 = r8.bridge
                if (r1 == r3) goto L13
                return r2
            L13:
                int r1 = r7.falcon
                int r3 = r8.falcon
                if (r1 == r3) goto L1a
                return r2
            L1a:
                int r1 = r7.f2public
                int r3 = r8.f2public
                if (r1 == r3) goto L21
                return r2
            L21:
                int r1 = r7.total
                int r3 = r8.total
                if (r1 == r3) goto L28
                return r2
            L28:
                int r1 = r7.alive
                int r3 = r8.alive
                if (r1 == r3) goto L2f
                return r2
            L2f:
                int r1 = r7.tested
                int r3 = r8.tested
                if (r1 == r3) goto L36
                return r2
            L36:
                int r1 = r7.verified
                int r3 = r8.verified
                if (r1 == r3) goto L3d
                return r2
            L3d:
                long r3 = r7.verifiedAt
                long r5 = r8.verifiedAt
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L46
                return r2
            L46:
                return r0
        }

        public final int getAlive() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final int getBridge() {
                r1 = this;
                int r0 = r1.bridge
                return r0
        }

        public final int getFalcon() {
                r1 = this;
                int r0 = r1.falcon
                return r0
        }

        public final int getPublic() {
                r1 = this;
                int r0 = r1.f2public
                return r0
        }

        public final int getTested() {
                r1 = this;
                int r0 = r1.tested
                return r0
        }

        public final int getTotal() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final int getVerified() {
                r1 = this;
                int r0 = r1.verified
                return r0
        }

        public final long getVerifiedAt() {
                r2 = this;
                long r0 = r2.verifiedAt
                return r0
        }

        public int hashCode() {
                r3 = this;
                int r0 = r3.bridge
                int r0 = java.lang.Integer.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                int r2 = r3.falcon
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.f2public
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.total
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.alive
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.tested
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.verified
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                long r1 = r3.verifiedAt
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r12 = this;
                int r0 = r12.bridge
                int r1 = r12.falcon
                int r2 = r12.f2public
                int r3 = r12.total
                int r4 = r12.alive
                int r5 = r12.tested
                int r6 = r12.verified
                long r7 = r12.verifiedAt
                java.lang.String r9 = ", falcon="
                java.lang.String r10 = ", public="
                java.lang.String r11 = "Counts(bridge="
                java.lang.StringBuilder r0 = androidx.compose.foundation.interaction.f.u(r11, r0, r9, r1, r10)
                java.lang.String r1 = ", total="
                java.lang.String r9 = ", alive="
                androidx.media3.common.s.v(r0, r2, r1, r3, r9)
                java.lang.String r1 = ", tested="
                java.lang.String r2 = ", verified="
                androidx.media3.common.s.v(r0, r4, r1, r5, r2)
                java.lang.String r1 = ", verifiedAt="
                com.mlmvpn.core.aether.i.r(r6, r7, r1, r0)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Group {
        public static final int $stable = 8;
        private int alive;
        private java.lang.Long best;
        private int bridge;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11198cc;
        private int falcon;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f11199n;

        /* JADX INFO: renamed from: public, reason: not valid java name */
        private int f3public;

        public Group(java.lang.String r2, int r3, int r4, java.lang.Long r5, int r6, int r7, int r8) {
                r1 = this;
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r2, r0)
                r1.<init>()
                r1.f11198cc = r2
                r1.f11199n = r3
                r1.alive = r4
                r1.best = r5
                r1.bridge = r6
                r1.falcon = r7
                r1.f3public = r8
                return
        }

        public /* synthetic */ Group(java.lang.String r2, int r3, int r4, java.lang.Long r5, int r6, int r7, int r8, int r9, kotlin.jvm.internal.e r10) {
                r1 = this;
                r10 = r9 & 2
                r0 = 0
                if (r10 == 0) goto L6
                r3 = r0
            L6:
                r10 = r9 & 4
                if (r10 == 0) goto Lb
                r4 = r0
            Lb:
                r10 = r9 & 8
                if (r10 == 0) goto L10
                r5 = 0
            L10:
                r10 = r9 & 16
                if (r10 == 0) goto L15
                r6 = r0
            L15:
                r10 = r9 & 32
                if (r10 == 0) goto L1a
                r7 = r0
            L1a:
                r9 = r9 & 64
                if (r9 == 0) goto L27
                r9 = r0
            L1f:
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                goto L29
            L27:
                r9 = r8
                goto L1f
            L29:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Group copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r0, java.lang.String r1, int r2, int r3, java.lang.Long r4, int r5, int r6, int r7, int r8, java.lang.Object r9) {
                r9 = r8 & 1
                if (r9 == 0) goto L6
                java.lang.String r1 = r0.f11198cc
            L6:
                r9 = r8 & 2
                if (r9 == 0) goto Lc
                int r2 = r0.f11199n
            Lc:
                r9 = r8 & 4
                if (r9 == 0) goto L12
                int r3 = r0.alive
            L12:
                r9 = r8 & 8
                if (r9 == 0) goto L18
                java.lang.Long r4 = r0.best
            L18:
                r9 = r8 & 16
                if (r9 == 0) goto L1e
                int r5 = r0.bridge
            L1e:
                r9 = r8 & 32
                if (r9 == 0) goto L24
                int r6 = r0.falcon
            L24:
                r8 = r8 & 64
                if (r8 == 0) goto L2a
                int r7 = r0.f3public
            L2a:
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r2 = r0
                r3 = r1
                com.mlmvpn.scanner.engines.argo.ArgoPool$Group r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11198cc
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.f11199n
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final java.lang.Long component4() {
                r1 = this;
                java.lang.Long r0 = r1.best
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.bridge
                return r0
        }

        public final int component6() {
                r1 = this;
                int r0 = r1.falcon
                return r0
        }

        public final int component7() {
                r1 = this;
                int r0 = r1.f3public
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Group copy(java.lang.String r10, int r11, int r12, java.lang.Long r13, int r14, int r15, int r16) {
                r9 = this;
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r10, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Group r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Group
                r2 = r10
                r3 = r11
                r4 = r12
                r5 = r13
                r6 = r14
                r7 = r15
                r8 = r16
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                return r1
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Group
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Group r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Group) r5
                java.lang.String r1 = r4.f11198cc
                java.lang.String r3 = r5.f11198cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                int r1 = r4.f11199n
                int r3 = r5.f11199n
                if (r1 == r3) goto L1e
                return r2
            L1e:
                int r1 = r4.alive
                int r3 = r5.alive
                if (r1 == r3) goto L25
                return r2
            L25:
                java.lang.Long r1 = r4.best
                java.lang.Long r3 = r5.best
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L30
                return r2
            L30:
                int r1 = r4.bridge
                int r3 = r5.bridge
                if (r1 == r3) goto L37
                return r2
            L37:
                int r1 = r4.falcon
                int r3 = r5.falcon
                if (r1 == r3) goto L3e
                return r2
            L3e:
                int r1 = r4.f3public
                int r5 = r5.f3public
                if (r1 == r5) goto L45
                return r2
            L45:
                return r0
        }

        public final int getAlive() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final java.lang.Long getBest() {
                r1 = this;
                java.lang.Long r0 = r1.best
                return r0
        }

        public final int getBridge() {
                r1 = this;
                int r0 = r1.bridge
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11198cc
                return r0
        }

        public final int getFalcon() {
                r1 = this;
                int r0 = r1.falcon
                return r0
        }

        public final int getN() {
                r1 = this;
                int r0 = r1.f11199n
                return r0
        }

        public final int getPublic() {
                r1 = this;
                int r0 = r1.f3public
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.f11198cc
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                int r2 = r3.f11199n
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.alive
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.Long r2 = r3.best
                if (r2 != 0) goto L1b
                r2 = 0
                goto L1f
            L1b:
                int r2 = r2.hashCode()
            L1f:
                int r0 = r0 + r2
                int r0 = r0 * r1
                int r2 = r3.bridge
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.falcon
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r1 = r3.f3public
                int r1 = java.lang.Integer.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public final void setAlive(int r1) {
                r0 = this;
                r0.alive = r1
                return
        }

        public final void setBest(java.lang.Long r1) {
                r0 = this;
                r0.best = r1
                return
        }

        public final void setBridge(int r1) {
                r0 = this;
                r0.bridge = r1
                return
        }

        public final void setFalcon(int r1) {
                r0 = this;
                r0.falcon = r1
                return
        }

        public final void setN(int r1) {
                r0 = this;
                r0.f11199n = r1
                return
        }

        public final void setPublic(int r1) {
                r0 = this;
                r0.f3public = r1
                return
        }

        public java.lang.String toString() {
                r10 = this;
                java.lang.String r0 = r10.f11198cc
                int r1 = r10.f11199n
                int r2 = r10.alive
                java.lang.Long r3 = r10.best
                int r4 = r10.bridge
                int r5 = r10.falcon
                int r6 = r10.f3public
                java.lang.String r7 = ", n="
                java.lang.String r8 = ", alive="
                java.lang.String r9 = "Group(cc="
                java.lang.StringBuilder r0 = androidx.media3.common.s.l(r9, r0, r7, r1, r8)
                r0.append(r2)
                java.lang.String r1 = ", best="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = ", bridge="
                r0.append(r1)
                java.lang.String r1 = ", falcon="
                java.lang.String r2 = ", public="
                androidx.media3.common.s.v(r0, r4, r1, r5, r2)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.q(r0, r6, r1)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class IpScan {
        public static final int $stable = 8;
        private final int done;
        private final long endedAt;
        private final java.lang.String error;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> found;
        private final java.lang.String note;
        private final java.lang.String phase;
        private final java.lang.String ref;
        private final boolean running;
        private final int total;

        public IpScan(boolean r2, java.lang.String r3, int r4, int r5, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, long r10) {
                r1 = this;
                java.lang.String r0 = "phase"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "found"
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "ref"
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "error"
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "note"
                kotlin.jvm.internal.j.e(r9, r0)
                r1.<init>()
                r1.running = r2
                r1.phase = r3
                r1.done = r4
                r1.total = r5
                r1.found = r6
                r1.ref = r7
                r1.error = r8
                r1.note = r9
                r1.endedAt = r10
                return
        }

        public /* synthetic */ IpScan(boolean r2, java.lang.String r3, int r4, int r5, java.util.List r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, long r10, int r12, kotlin.jvm.internal.e r13) {
                r1 = this;
                r13 = r12 & 64
                java.lang.String r0 = ""
                if (r13 == 0) goto L7
                r8 = r0
            L7:
                r13 = r12 & 128(0x80, float:1.794E-43)
                if (r13 == 0) goto Lc
                r9 = r0
            Lc:
                r12 = r12 & 256(0x100, float:3.59E-43)
                if (r12 == 0) goto L12
                r10 = 0
            L12:
                r11 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan r0, boolean r1, java.lang.String r2, int r3, int r4, java.util.List r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, long r9, int r11, java.lang.Object r12) {
                r12 = r11 & 1
                if (r12 == 0) goto L6
                boolean r1 = r0.running
            L6:
                r12 = r11 & 2
                if (r12 == 0) goto Lc
                java.lang.String r2 = r0.phase
            Lc:
                r12 = r11 & 4
                if (r12 == 0) goto L12
                int r3 = r0.done
            L12:
                r12 = r11 & 8
                if (r12 == 0) goto L18
                int r4 = r0.total
            L18:
                r12 = r11 & 16
                if (r12 == 0) goto L1e
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r5 = r0.found
            L1e:
                r12 = r11 & 32
                if (r12 == 0) goto L24
                java.lang.String r6 = r0.ref
            L24:
                r12 = r11 & 64
                if (r12 == 0) goto L2a
                java.lang.String r7 = r0.error
            L2a:
                r12 = r11 & 128(0x80, float:1.794E-43)
                if (r12 == 0) goto L30
                java.lang.String r8 = r0.note
            L30:
                r11 = r11 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L36
                long r9 = r0.endedAt
            L36:
                r11 = r9
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                return r0
        }

        public final boolean component1() {
                r1 = this;
                boolean r0 = r1.running
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.phase
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.done
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> component5() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r0 = r1.found
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.ref
                return r0
        }

        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final java.lang.String component8() {
                r1 = this;
                java.lang.String r0 = r1.note
                return r0
        }

        public final long component9() {
                r2 = this;
                long r0 = r2.endedAt
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan copy(boolean r13, java.lang.String r14, int r15, int r16, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, long r21) {
                r12 = this;
                java.lang.String r0 = "phase"
                kotlin.jvm.internal.j.e(r14, r0)
                java.lang.String r0 = "found"
                r6 = r17
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "ref"
                r7 = r18
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "error"
                r8 = r19
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "note"
                r9 = r20
                kotlin.jvm.internal.j.e(r9, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r10 = r21
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan) r8
                boolean r1 = r7.running
                boolean r3 = r8.running
                if (r1 == r3) goto L13
                return r2
            L13:
                java.lang.String r1 = r7.phase
                java.lang.String r3 = r8.phase
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L1e
                return r2
            L1e:
                int r1 = r7.done
                int r3 = r8.done
                if (r1 == r3) goto L25
                return r2
            L25:
                int r1 = r7.total
                int r3 = r8.total
                if (r1 == r3) goto L2c
                return r2
            L2c:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r1 = r7.found
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r3 = r8.found
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L37
                return r2
            L37:
                java.lang.String r1 = r7.ref
                java.lang.String r3 = r8.ref
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L42
                return r2
            L42:
                java.lang.String r1 = r7.error
                java.lang.String r3 = r8.error
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4d
                return r2
            L4d:
                java.lang.String r1 = r7.note
                java.lang.String r3 = r8.note
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L58
                return r2
            L58:
                long r3 = r7.endedAt
                long r5 = r8.endedAt
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L61
                return r2
            L61:
                return r0
        }

        public final int getDone() {
                r1 = this;
                int r0 = r1.done
                return r0
        }

        public final long getEndedAt() {
                r2 = this;
                long r0 = r2.endedAt
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> getFound() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r0 = r1.found
                return r0
        }

        public final java.lang.String getNote() {
                r1 = this;
                java.lang.String r0 = r1.note
                return r0
        }

        public final java.lang.String getPhase() {
                r1 = this;
                java.lang.String r0 = r1.phase
                return r0
        }

        public final java.lang.String getRef() {
                r1 = this;
                java.lang.String r0 = r1.ref
                return r0
        }

        public final boolean getRunning() {
                r1 = this;
                boolean r0 = r1.running
                return r0
        }

        public final int getTotal() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public int hashCode() {
                r3 = this;
                boolean r0 = r3.running
                int r0 = java.lang.Boolean.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r3.phase
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r3.done
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r3.total
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r2 = r3.found
                int r0 = androidx.compose.foundation.interaction.f.f(r0, r1, r2)
                java.lang.String r2 = r3.ref
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.error
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r3.note
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r1 = r3.endedAt
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r12 = this;
                boolean r0 = r12.running
                java.lang.String r1 = r12.phase
                int r2 = r12.done
                int r3 = r12.total
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r4 = r12.found
                java.lang.String r5 = r12.ref
                java.lang.String r6 = r12.error
                java.lang.String r7 = r12.note
                long r8 = r12.endedAt
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                java.lang.String r11 = "IpScan(running="
                r10.<init>(r11)
                r10.append(r0)
                java.lang.String r0 = ", phase="
                r10.append(r0)
                r10.append(r1)
                java.lang.String r0 = ", done="
                r10.append(r0)
                java.lang.String r0 = ", total="
                java.lang.String r1 = ", found="
                androidx.media3.common.s.v(r10, r2, r0, r3, r1)
                r10.append(r4)
                java.lang.String r0 = ", ref="
                r10.append(r0)
                r10.append(r5)
                java.lang.String r0 = ", error="
                r10.append(r0)
                java.lang.String r0 = ", note="
                java.lang.String r1 = ", endedAt="
                org.telegram.ui.Cells.d1.x(r10, r6, r0, r7, r1)
                java.lang.String r0 = ")"
                java.lang.String r0 = a6.w0.k(r8, r0, r10)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Item {
        public static final int $stable = 8;
        private java.lang.String cc0;
        private final java.lang.String from;
        private final java.lang.String host;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11200id;
        private java.lang.String ip0;
        private final java.lang.String kind;
        private final int port;
        private final java.lang.String profile;
        private final java.lang.String protocol;
        private long seen;
        private final java.lang.String src;
        private boolean user;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private long f11201v0;

        public Item(java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12, boolean r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19) {
                r4 = this;
                r0 = r15
                r1 = r16
                r2 = r19
                java.lang.String r3 = "id"
                kotlin.jvm.internal.j.e(r5, r3)
                java.lang.String r3 = "kind"
                kotlin.jvm.internal.j.e(r6, r3)
                java.lang.String r3 = "host"
                kotlin.jvm.internal.j.e(r7, r3)
                java.lang.String r3 = "protocol"
                kotlin.jvm.internal.j.e(r9, r3)
                java.lang.String r3 = "src"
                kotlin.jvm.internal.j.e(r10, r3)
                java.lang.String r3 = "from"
                kotlin.jvm.internal.j.e(r11, r3)
                java.lang.String r3 = "profile"
                kotlin.jvm.internal.j.e(r15, r3)
                java.lang.String r3 = "cc0"
                kotlin.jvm.internal.j.e(r1, r3)
                java.lang.String r3 = "ip0"
                kotlin.jvm.internal.j.e(r2, r3)
                r4.<init>()
                r4.f11200id = r5
                r4.kind = r6
                r4.host = r7
                r4.port = r8
                r4.protocol = r9
                r4.src = r10
                r4.from = r11
                r4.seen = r12
                r4.user = r14
                r4.profile = r0
                r4.cc0 = r1
                r5 = r17
                r4.f11201v0 = r5
                r4.ip0 = r2
                return
        }

        public /* synthetic */ Item(java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, long r27, boolean r29, java.lang.String r30, java.lang.String r31, long r32, java.lang.String r34, int r35, kotlin.jvm.internal.e r36) {
                r19 = this;
                r0 = r35
                r1 = r0 & 64
                java.lang.String r2 = ""
                if (r1 == 0) goto La
                r10 = r2
                goto Lc
            La:
                r10 = r26
            Lc:
                r1 = r0 & 128(0x80, float:1.794E-43)
                r3 = 0
                if (r1 == 0) goto L14
                r11 = r3
                goto L16
            L14:
                r11 = r27
            L16:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L1d
                r1 = 0
                r13 = r1
                goto L1f
            L1d:
                r13 = r29
            L1f:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L25
                r14 = r2
                goto L27
            L25:
                r14 = r30
            L27:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L2d
                r15 = r2
                goto L2f
            L2d:
                r15 = r31
            L2f:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L36
                r16 = r3
                goto L38
            L36:
                r16 = r32
            L38:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L4d
                r18 = r2
            L3e:
                r3 = r19
                r4 = r20
                r5 = r21
                r6 = r22
                r7 = r23
                r8 = r24
                r9 = r25
                goto L50
            L4d:
                r18 = r34
                goto L3e
            L50:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r18)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Item copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, long r24, boolean r26, java.lang.String r27, java.lang.String r28, long r29, java.lang.String r31, int r32, java.lang.Object r33) {
                r0 = r16
                r1 = r32
                r2 = r1 & 1
                if (r2 == 0) goto Lb
                java.lang.String r2 = r0.f11200id
                goto Ld
            Lb:
                r2 = r17
            Ld:
                r3 = r1 & 2
                if (r3 == 0) goto L14
                java.lang.String r3 = r0.kind
                goto L16
            L14:
                r3 = r18
            L16:
                r4 = r1 & 4
                if (r4 == 0) goto L1d
                java.lang.String r4 = r0.host
                goto L1f
            L1d:
                r4 = r19
            L1f:
                r5 = r1 & 8
                if (r5 == 0) goto L26
                int r5 = r0.port
                goto L28
            L26:
                r5 = r20
            L28:
                r6 = r1 & 16
                if (r6 == 0) goto L2f
                java.lang.String r6 = r0.protocol
                goto L31
            L2f:
                r6 = r21
            L31:
                r7 = r1 & 32
                if (r7 == 0) goto L38
                java.lang.String r7 = r0.src
                goto L3a
            L38:
                r7 = r22
            L3a:
                r8 = r1 & 64
                if (r8 == 0) goto L41
                java.lang.String r8 = r0.from
                goto L43
            L41:
                r8 = r23
            L43:
                r9 = r1 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L4a
                long r9 = r0.seen
                goto L4c
            L4a:
                r9 = r24
            L4c:
                r11 = r1 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L53
                boolean r11 = r0.user
                goto L55
            L53:
                r11 = r26
            L55:
                r12 = r1 & 512(0x200, float:7.175E-43)
                if (r12 == 0) goto L5c
                java.lang.String r12 = r0.profile
                goto L5e
            L5c:
                r12 = r27
            L5e:
                r13 = r1 & 1024(0x400, float:1.435E-42)
                if (r13 == 0) goto L65
                java.lang.String r13 = r0.cc0
                goto L67
            L65:
                r13 = r28
            L67:
                r14 = r1 & 2048(0x800, float:2.87E-42)
                if (r14 == 0) goto L6e
                long r14 = r0.f11201v0
                goto L70
            L6e:
                r14 = r29
            L70:
                r1 = r1 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L93
                java.lang.String r1 = r0.ip0
                r32 = r1
            L78:
                r17 = r0
                r18 = r2
                r19 = r3
                r20 = r4
                r21 = r5
                r22 = r6
                r23 = r7
                r24 = r8
                r25 = r9
                r27 = r11
                r28 = r12
                r29 = r13
                r30 = r14
                goto L96
            L93:
                r32 = r31
                goto L78
            L96:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = r17.copy(r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r32)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11200id
                return r0
        }

        public final java.lang.String component10() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final java.lang.String component11() {
                r1 = this;
                java.lang.String r0 = r1.cc0
                return r0
        }

        public final long component12() {
                r2 = this;
                long r0 = r2.f11201v0
                return r0
        }

        public final java.lang.String component13() {
                r1 = this;
                java.lang.String r0 = r1.ip0
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.port
                return r0
        }

        public final java.lang.String component5() {
                r1 = this;
                java.lang.String r0 = r1.protocol
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.src
                return r0
        }

        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.from
                return r0
        }

        public final long component8() {
                r2 = this;
                long r0 = r2.seen
                return r0
        }

        public final boolean component9() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Item copy(java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, long r25, boolean r27, java.lang.String r28, java.lang.String r29, long r30, java.lang.String r32) {
                r17 = this;
                java.lang.String r0 = "id"
                r2 = r18
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "kind"
                r3 = r19
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "host"
                r4 = r20
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "protocol"
                r6 = r22
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "src"
                r7 = r23
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "from"
                r8 = r24
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "profile"
                r12 = r28
                kotlin.jvm.internal.j.e(r12, r0)
                java.lang.String r0 = "cc0"
                r13 = r29
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "ip0"
                r1 = r32
                kotlin.jvm.internal.j.e(r1, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Item
                r5 = r21
                r9 = r25
                r11 = r27
                r14 = r30
                r16 = r32
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r16)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Item
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r8
                java.lang.String r1 = r7.f11200id
                java.lang.String r3 = r8.f11200id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.kind
                java.lang.String r3 = r8.kind
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r7.host
                java.lang.String r3 = r8.host
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                int r1 = r7.port
                int r3 = r8.port
                if (r1 == r3) goto L34
                return r2
            L34:
                java.lang.String r1 = r7.protocol
                java.lang.String r3 = r8.protocol
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L3f
                return r2
            L3f:
                java.lang.String r1 = r7.src
                java.lang.String r3 = r8.src
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4a
                return r2
            L4a:
                java.lang.String r1 = r7.from
                java.lang.String r3 = r8.from
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L55
                return r2
            L55:
                long r3 = r7.seen
                long r5 = r8.seen
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L5e
                return r2
            L5e:
                boolean r1 = r7.user
                boolean r3 = r8.user
                if (r1 == r3) goto L65
                return r2
            L65:
                java.lang.String r1 = r7.profile
                java.lang.String r3 = r8.profile
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L70
                return r2
            L70:
                java.lang.String r1 = r7.cc0
                java.lang.String r3 = r8.cc0
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L7b
                return r2
            L7b:
                long r3 = r7.f11201v0
                long r5 = r8.f11201v0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L84
                return r2
            L84:
                java.lang.String r1 = r7.ip0
                java.lang.String r8 = r8.ip0
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L8f
                return r2
            L8f:
                return r0
        }

        public final java.lang.String getCc0() {
                r1 = this;
                java.lang.String r0 = r1.cc0
                return r0
        }

        public final java.lang.String getFrom() {
                r1 = this;
                java.lang.String r0 = r1.from
                return r0
        }

        public final java.lang.String getHost() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11200id
                return r0
        }

        public final java.lang.String getIp0() {
                r1 = this;
                java.lang.String r0 = r1.ip0
                return r0
        }

        public final java.lang.String getKind() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final int getPort() {
                r1 = this;
                int r0 = r1.port
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

        public final long getSeen() {
                r2 = this;
                long r0 = r2.seen
                return r0
        }

        public final java.lang.String getSrc() {
                r1 = this;
                java.lang.String r0 = r1.src
                return r0
        }

        public final boolean getUser() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final long getV0() {
                r2 = this;
                long r0 = r2.f11201v0
                return r0
        }

        public int hashCode() {
                r4 = this;
                java.lang.String r0 = r4.f11200id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r4.kind
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.host
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r4.port
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.String r2 = r4.protocol
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.src
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.from
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.seen
                int r0 = a6.w0.c(r0, r1, r2)
                boolean r2 = r4.user
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.String r2 = r4.profile
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.cc0
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.f11201v0
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r1 = r4.ip0
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public final void setCc0(java.lang.String r2) {
                r1 = this;
                java.lang.String r0 = "<set-?>"
                kotlin.jvm.internal.j.e(r2, r0)
                r1.cc0 = r2
                return
        }

        public final void setIp0(java.lang.String r2) {
                r1 = this;
                java.lang.String r0 = "<set-?>"
                kotlin.jvm.internal.j.e(r2, r0)
                r1.ip0 = r2
                return
        }

        public final void setSeen(long r1) {
                r0 = this;
                r0.seen = r1
                return
        }

        public final void setUser(boolean r1) {
                r0 = this;
                r0.user = r1
                return
        }

        public final void setV0(long r1) {
                r0 = this;
                r0.f11201v0 = r1
                return
        }

        public java.lang.String toString() {
                r18 = this;
                r0 = r18
                java.lang.String r1 = r0.f11200id
                java.lang.String r2 = r0.kind
                java.lang.String r3 = r0.host
                int r4 = r0.port
                java.lang.String r5 = r0.protocol
                java.lang.String r6 = r0.src
                java.lang.String r7 = r0.from
                long r8 = r0.seen
                boolean r10 = r0.user
                java.lang.String r11 = r0.profile
                java.lang.String r12 = r0.cc0
                long r13 = r0.f11201v0
                java.lang.String r15 = r0.ip0
                java.lang.String r0 = ", kind="
                r16 = r13
                java.lang.String r13 = ", host="
                java.lang.String r14 = "Item(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r14, r1, r0, r2, r13)
                java.lang.String r1 = ", port="
                java.lang.String r2 = ", protocol="
                f0.a.r(r4, r3, r1, r2, r0)
                java.lang.String r1 = ", src="
                java.lang.String r2 = ", from="
                org.telegram.ui.Cells.d1.x(r0, r5, r1, r6, r2)
                java.lang.String r1 = ", seen="
                androidx.media3.common.s.q(r8, r7, r1, r0)
                java.lang.String r1 = ", user="
                r0.append(r1)
                r0.append(r10)
                java.lang.String r1 = ", profile="
                r0.append(r1)
                r0.append(r11)
                java.lang.String r1 = ", cc0="
                java.lang.String r2 = ", v0="
                f0.a.x(r1, r12, r2, r0)
                java.lang.String r1 = ", ip0="
                r2 = r16
                com.mlmvpn.core.aether.i.t(r2, r1, r15, r0)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Job {
        public static final int $stable = 8;
        private final int alive;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11202cc;
        private final int done;
        private final long endedAt;
        private final java.util.List<java.lang.String> errors;
        private final int found;
        private final int frozen;
        private final java.lang.String kind;
        private final java.lang.String label;
        private final boolean running;
        private final int total;
        private final java.lang.String via;
        private final java.lang.String what;

        public Job(boolean r2, int r3, int r4, int r5, int r6, java.lang.String r7, int r8, java.util.List<java.lang.String> r9, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
                r1 = this;
                java.lang.String r0 = "label"
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "errors"
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "via"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "kind"
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r14, r0)
                java.lang.String r0 = "what"
                kotlin.jvm.internal.j.e(r15, r0)
                r1.<init>()
                r1.running = r2
                r1.done = r3
                r1.total = r4
                r1.alive = r5
                r1.frozen = r6
                r1.label = r7
                r1.found = r8
                r1.errors = r9
                r1.via = r10
                r1.endedAt = r11
                r1.kind = r13
                r1.f11202cc = r14
                r1.what = r15
                return
        }

        public Job(boolean r19, int r20, int r21, int r22, int r23, java.lang.String r24, int r25, java.util.List r26, java.lang.String r27, long r28, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, kotlin.jvm.internal.e r34) {
                r18 = this;
                r0 = r33
                r1 = r0 & 8
                r2 = 0
                if (r1 == 0) goto L9
                r7 = r2
                goto Lb
            L9:
                r7 = r22
            Lb:
                r1 = r0 & 16
                if (r1 == 0) goto L11
                r8 = r2
                goto L13
            L11:
                r8 = r23
            L13:
                r1 = r0 & 32
                java.lang.String r3 = ""
                if (r1 == 0) goto L1b
                r9 = r3
                goto L1d
            L1b:
                r9 = r24
            L1d:
                r1 = r0 & 64
                if (r1 == 0) goto L23
                r10 = r2
                goto L25
            L23:
                r10 = r25
            L25:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L2d
                kotlin.collections.w r1 = kotlin.collections.w.INSTANCE
                r11 = r1
                goto L2f
            L2d:
                r11 = r26
            L2f:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L35
                r12 = r3
                goto L37
            L35:
                r12 = r27
            L37:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L3f
                r1 = 0
                r13 = r1
                goto L41
            L3f:
                r13 = r28
            L41:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                java.lang.String r2 = "all"
                if (r1 == 0) goto L49
                r15 = r2
                goto L4b
            L49:
                r15 = r30
            L4b:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L52
                r16 = r3
                goto L54
            L52:
                r16 = r31
            L54:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L63
                r17 = r2
            L5a:
                r3 = r18
                r4 = r19
                r5 = r20
                r6 = r21
                goto L66
            L63:
                r17 = r32
                goto L5a
            L66:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Job copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Job r14, boolean r15, int r16, int r17, int r18, int r19, java.lang.String r20, int r21, java.util.List r22, java.lang.String r23, long r24, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, java.lang.Object r30) {
                r0 = r29
                r1 = r0 & 1
                if (r1 == 0) goto L9
                boolean r1 = r14.running
                goto La
            L9:
                r1 = r15
            La:
                r2 = r0 & 2
                if (r2 == 0) goto L11
                int r2 = r14.done
                goto L13
            L11:
                r2 = r16
            L13:
                r3 = r0 & 4
                if (r3 == 0) goto L1a
                int r3 = r14.total
                goto L1c
            L1a:
                r3 = r17
            L1c:
                r4 = r0 & 8
                if (r4 == 0) goto L23
                int r4 = r14.alive
                goto L25
            L23:
                r4 = r18
            L25:
                r5 = r0 & 16
                if (r5 == 0) goto L2c
                int r5 = r14.frozen
                goto L2e
            L2c:
                r5 = r19
            L2e:
                r6 = r0 & 32
                if (r6 == 0) goto L35
                java.lang.String r6 = r14.label
                goto L37
            L35:
                r6 = r20
            L37:
                r7 = r0 & 64
                if (r7 == 0) goto L3e
                int r7 = r14.found
                goto L40
            L3e:
                r7 = r21
            L40:
                r8 = r0 & 128(0x80, float:1.794E-43)
                if (r8 == 0) goto L47
                java.util.List<java.lang.String> r8 = r14.errors
                goto L49
            L47:
                r8 = r22
            L49:
                r9 = r0 & 256(0x100, float:3.59E-43)
                if (r9 == 0) goto L50
                java.lang.String r9 = r14.via
                goto L52
            L50:
                r9 = r23
            L52:
                r10 = r0 & 512(0x200, float:7.175E-43)
                if (r10 == 0) goto L59
                long r10 = r14.endedAt
                goto L5b
            L59:
                r10 = r24
            L5b:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L62
                java.lang.String r12 = r14.kind
                goto L64
            L62:
                r12 = r26
            L64:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L6b
                java.lang.String r13 = r14.f11202cc
                goto L6d
            L6b:
                r13 = r27
            L6d:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L8f
                java.lang.String r0 = r14.what
                r29 = r0
            L75:
                r15 = r14
                r16 = r1
                r17 = r2
                r18 = r3
                r19 = r4
                r20 = r5
                r21 = r6
                r22 = r7
                r23 = r8
                r24 = r9
                r25 = r10
                r27 = r12
                r28 = r13
                goto L92
            L8f:
                r29 = r28
                goto L75
            L92:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r14 = r15.copy(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29)
                return r14
        }

        public final boolean component1() {
                r1 = this;
                boolean r0 = r1.running
                return r0
        }

        public final long component10() {
                r2 = this;
                long r0 = r2.endedAt
                return r0
        }

        public final java.lang.String component11() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.String component12() {
                r1 = this;
                java.lang.String r0 = r1.f11202cc
                return r0
        }

        public final java.lang.String component13() {
                r1 = this;
                java.lang.String r0 = r1.what
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.done
                return r0
        }

        public final int component3() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.frozen
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.label
                return r0
        }

        public final int component7() {
                r1 = this;
                int r0 = r1.found
                return r0
        }

        public final java.util.List<java.lang.String> component8() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.errors
                return r0
        }

        public final java.lang.String component9() {
                r1 = this;
                java.lang.String r0 = r1.via
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Job copy(boolean r17, int r18, int r19, int r20, int r21, java.lang.String r22, int r23, java.util.List<java.lang.String> r24, java.lang.String r25, long r26, java.lang.String r28, java.lang.String r29, java.lang.String r30) {
                r16 = this;
                java.lang.String r0 = "label"
                r7 = r22
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "errors"
                r9 = r24
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "via"
                r10 = r25
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "kind"
                r13 = r28
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "cc"
                r14 = r29
                kotlin.jvm.internal.j.e(r14, r0)
                java.lang.String r0 = "what"
                r15 = r30
                kotlin.jvm.internal.j.e(r15, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Job
                r2 = r17
                r3 = r18
                r4 = r19
                r5 = r20
                r6 = r21
                r8 = r23
                r11 = r26
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Job
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Job) r8
                boolean r1 = r7.running
                boolean r3 = r8.running
                if (r1 == r3) goto L13
                return r2
            L13:
                int r1 = r7.done
                int r3 = r8.done
                if (r1 == r3) goto L1a
                return r2
            L1a:
                int r1 = r7.total
                int r3 = r8.total
                if (r1 == r3) goto L21
                return r2
            L21:
                int r1 = r7.alive
                int r3 = r8.alive
                if (r1 == r3) goto L28
                return r2
            L28:
                int r1 = r7.frozen
                int r3 = r8.frozen
                if (r1 == r3) goto L2f
                return r2
            L2f:
                java.lang.String r1 = r7.label
                java.lang.String r3 = r8.label
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L3a
                return r2
            L3a:
                int r1 = r7.found
                int r3 = r8.found
                if (r1 == r3) goto L41
                return r2
            L41:
                java.util.List<java.lang.String> r1 = r7.errors
                java.util.List<java.lang.String> r3 = r8.errors
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4c
                return r2
            L4c:
                java.lang.String r1 = r7.via
                java.lang.String r3 = r8.via
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L57
                return r2
            L57:
                long r3 = r7.endedAt
                long r5 = r8.endedAt
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L60
                return r2
            L60:
                java.lang.String r1 = r7.kind
                java.lang.String r3 = r8.kind
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L6b
                return r2
            L6b:
                java.lang.String r1 = r7.f11202cc
                java.lang.String r3 = r8.f11202cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L76
                return r2
            L76:
                java.lang.String r1 = r7.what
                java.lang.String r8 = r8.what
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L81
                return r2
            L81:
                return r0
        }

        public final int getAlive() {
                r1 = this;
                int r0 = r1.alive
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11202cc
                return r0
        }

        public final int getDone() {
                r1 = this;
                int r0 = r1.done
                return r0
        }

        public final long getEndedAt() {
                r2 = this;
                long r0 = r2.endedAt
                return r0
        }

        public final java.util.List<java.lang.String> getErrors() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.errors
                return r0
        }

        public final int getFound() {
                r1 = this;
                int r0 = r1.found
                return r0
        }

        public final int getFrozen() {
                r1 = this;
                int r0 = r1.frozen
                return r0
        }

        public final java.lang.String getKind() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.String getLabel() {
                r1 = this;
                java.lang.String r0 = r1.label
                return r0
        }

        public final boolean getRunning() {
                r1 = this;
                boolean r0 = r1.running
                return r0
        }

        public final int getTotal() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final java.lang.String getVia() {
                r1 = this;
                java.lang.String r0 = r1.via
                return r0
        }

        public final java.lang.String getWhat() {
                r1 = this;
                java.lang.String r0 = r1.what
                return r0
        }

        public int hashCode() {
                r4 = this;
                boolean r0 = r4.running
                int r0 = java.lang.Boolean.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                int r2 = r4.done
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.total
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.alive
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.frozen
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.String r2 = r4.label
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r4.found
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.util.List<java.lang.String> r2 = r4.errors
                int r0 = androidx.compose.foundation.interaction.f.f(r0, r1, r2)
                java.lang.String r2 = r4.via
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.endedAt
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r2 = r4.kind
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.f11202cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r1 = r4.what
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r16 = this;
                r0 = r16
                boolean r1 = r0.running
                int r2 = r0.done
                int r3 = r0.total
                int r4 = r0.alive
                int r5 = r0.frozen
                java.lang.String r6 = r0.label
                int r7 = r0.found
                java.util.List<java.lang.String> r8 = r0.errors
                java.lang.String r9 = r0.via
                long r10 = r0.endedAt
                java.lang.String r12 = r0.kind
                java.lang.String r13 = r0.f11202cc
                java.lang.String r14 = r0.what
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                java.lang.String r0 = "Job(running="
                r15.<init>(r0)
                r15.append(r1)
                java.lang.String r0 = ", done="
                r15.append(r0)
                r15.append(r2)
                java.lang.String r0 = ", total="
                r15.append(r0)
                java.lang.String r0 = ", alive="
                java.lang.String r1 = ", frozen="
                androidx.media3.common.s.v(r15, r3, r0, r4, r1)
                java.lang.String r0 = ", label="
                java.lang.String r1 = ", found="
                org.telegram.ui.Cells.d1.n(r5, r0, r6, r1, r15)
                r15.append(r7)
                java.lang.String r0 = ", errors="
                r15.append(r0)
                r15.append(r8)
                java.lang.String r0 = ", via="
                r15.append(r0)
                java.lang.String r0 = ", endedAt="
                androidx.media3.common.s.q(r10, r9, r0, r15)
                java.lang.String r0 = ", kind="
                java.lang.String r1 = ", cc="
                org.telegram.ui.Cells.d1.x(r15, r0, r12, r1, r13)
                java.lang.String r0 = ", what="
                java.lang.String r1 = ")"
                java.lang.String r0 = androidx.compose.foundation.interaction.f.r(r0, r14, r1, r15)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Page {
        private final int code;
        private final boolean ok;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Post> posts;

        public Page(boolean r2, int r3, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Post> r4) {
                r1 = this;
                java.lang.String r0 = "posts"
                kotlin.jvm.internal.j.e(r4, r0)
                r1.<init>()
                r1.ok = r2
                r1.code = r3
                r1.posts = r4
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Page copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Page r0, boolean r1, int r2, java.util.List r3, int r4, java.lang.Object r5) {
                r5 = r4 & 1
                if (r5 == 0) goto L6
                boolean r1 = r0.ok
            L6:
                r5 = r4 & 2
                if (r5 == 0) goto Lc
                int r2 = r0.code
            Lc:
                r4 = r4 & 4
                if (r4 == 0) goto L12
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r3 = r0.posts
            L12:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = r0.copy(r1, r2, r3)
                return r0
        }

        public final boolean component1() {
                r1 = this;
                boolean r0 = r1.ok
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.code
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Post> component3() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r0 = r1.posts
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Page copy(boolean r2, int r3, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Post> r4) {
                r1 = this;
                java.lang.String r0 = "posts"
                kotlin.jvm.internal.j.e(r4, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Page
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Page
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Page r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Page) r5
                boolean r1 = r4.ok
                boolean r3 = r5.ok
                if (r1 == r3) goto L13
                return r2
            L13:
                int r1 = r4.code
                int r3 = r5.code
                if (r1 == r3) goto L1a
                return r2
            L1a:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r1 = r4.posts
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r5 = r5.posts
                boolean r5 = kotlin.jvm.internal.j.a(r1, r5)
                if (r5 != 0) goto L25
                return r2
            L25:
                return r0
        }

        public final int getCode() {
                r1 = this;
                int r0 = r1.code
                return r0
        }

        public final boolean getOk() {
                r1 = this;
                boolean r0 = r1.ok
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Post> getPosts() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r0 = r1.posts
                return r0
        }

        public int hashCode() {
                r3 = this;
                boolean r0 = r3.ok
                int r0 = java.lang.Boolean.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                int r2 = r3.code
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r1 = r3.posts
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r5 = this;
                boolean r0 = r5.ok
                int r1 = r5.code
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Post> r2 = r5.posts
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Page(ok="
                r3.<init>(r4)
                r3.append(r0)
                java.lang.String r0 = ", code="
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = ", posts="
                r3.append(r0)
                java.lang.String r0 = ")"
                java.lang.String r0 = org.telegram.ui.Cells.d1.j(r3, r2, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Parsed {
        public static final int $stable = 8;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge> bridges;
        private final java.util.List<java.lang.String> falcons;

        public Parsed(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge> r2, java.util.List<java.lang.String> r3) {
                r1 = this;
                java.lang.String r0 = "bridges"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "falcons"
                kotlin.jvm.internal.j.e(r3, r0)
                r1.<init>()
                r1.bridges = r2
                r1.falcons = r3
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed r0, java.util.List r1, java.util.List r2, int r3, java.lang.Object r4) {
                r4 = r3 & 1
                if (r4 == 0) goto L6
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r1 = r0.bridges
            L6:
                r3 = r3 & 2
                if (r3 == 0) goto Lc
                java.util.List<java.lang.String> r2 = r0.falcons
            Lc:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed r0 = r0.copy(r1, r2)
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge> component1() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r0 = r1.bridges
                return r0
        }

        public final java.util.List<java.lang.String> component2() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.falcons
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed copy(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge> r2, java.util.List<java.lang.String> r3) {
                r1 = this;
                java.lang.String r0 = "bridges"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "falcons"
                kotlin.jvm.internal.j.e(r3, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed
                r0.<init>(r2, r3)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed) r5
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r1 = r4.bridges
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r3 = r5.bridges
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.util.List<java.lang.String> r1 = r4.falcons
                java.util.List<java.lang.String> r5 = r5.falcons
                boolean r5 = kotlin.jvm.internal.j.a(r1, r5)
                if (r5 != 0) goto L22
                return r2
            L22:
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge> getBridges() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r0 = r1.bridges
                return r0
        }

        public final java.util.List<java.lang.String> getFalcons() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.falcons
                return r0
        }

        public int hashCode() {
                r2 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r0 = r2.bridges
                int r0 = r0.hashCode()
                int r0 = r0 * 31
                java.util.List<java.lang.String> r1 = r2.falcons
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r4 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge> r0 = r4.bridges
                java.util.List<java.lang.String> r1 = r4.falcons
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Parsed(bridges="
                r2.<init>(r3)
                r2.append(r0)
                java.lang.String r0 = ", falcons="
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = ")"
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ParsedBridge {
        public static final int $stable = 0;
        private final java.lang.String error;
        private final java.lang.String host;
        private final int port;
        private final boolean sigOk;

        public ParsedBridge(java.lang.String r2, int r3, boolean r4, java.lang.String r5) {
                r1 = this;
                java.lang.String r0 = "host"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "error"
                kotlin.jvm.internal.j.e(r5, r0)
                r1.<init>()
                r1.host = r2
                r1.port = r3
                r1.sigOk = r4
                r1.error = r5
                return
        }

        public /* synthetic */ ParsedBridge(java.lang.String r1, int r2, boolean r3, java.lang.String r4, int r5, kotlin.jvm.internal.e r6) {
                r0 = this;
                r5 = r5 & 8
                if (r5 == 0) goto L6
                java.lang.String r4 = ""
            L6:
                r0.<init>(r1, r2, r3, r4)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge r0, java.lang.String r1, int r2, boolean r3, java.lang.String r4, int r5, java.lang.Object r6) {
                r6 = r5 & 1
                if (r6 == 0) goto L6
                java.lang.String r1 = r0.host
            L6:
                r6 = r5 & 2
                if (r6 == 0) goto Lc
                int r2 = r0.port
            Lc:
                r6 = r5 & 4
                if (r6 == 0) goto L12
                boolean r3 = r0.sigOk
            L12:
                r5 = r5 & 8
                if (r5 == 0) goto L18
                java.lang.String r4 = r0.error
            L18:
                com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r0 = r0.copy(r1, r2, r3, r4)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final int component2() {
                r1 = this;
                int r0 = r1.port
                return r0
        }

        public final boolean component3() {
                r1 = this;
                boolean r0 = r1.sigOk
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge copy(java.lang.String r2, int r3, boolean r4, java.lang.String r5) {
                r1 = this;
                java.lang.String r0 = "host"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "error"
                kotlin.jvm.internal.j.e(r5, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge
                r0.<init>(r2, r3, r4, r5)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge) r5
                java.lang.String r1 = r4.host
                java.lang.String r3 = r5.host
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                int r1 = r4.port
                int r3 = r5.port
                if (r1 == r3) goto L1e
                return r2
            L1e:
                boolean r1 = r4.sigOk
                boolean r3 = r5.sigOk
                if (r1 == r3) goto L25
                return r2
            L25:
                java.lang.String r1 = r4.error
                java.lang.String r5 = r5.error
                boolean r5 = kotlin.jvm.internal.j.a(r1, r5)
                if (r5 != 0) goto L30
                return r2
            L30:
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final java.lang.String getHost() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final int getPort() {
                r1 = this;
                int r0 = r1.port
                return r0
        }

        public final boolean getSigOk() {
                r1 = this;
                boolean r0 = r1.sigOk
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.host
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                int r2 = r3.port
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                boolean r2 = r3.sigOk
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.String r1 = r3.error
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r7 = this;
                java.lang.String r0 = r7.host
                int r1 = r7.port
                boolean r2 = r7.sigOk
                java.lang.String r3 = r7.error
                java.lang.String r4 = ", port="
                java.lang.String r5 = ", sigOk="
                java.lang.String r6 = "ParsedBridge(host="
                java.lang.StringBuilder r0 = androidx.media3.common.s.l(r6, r0, r4, r1, r5)
                r0.append(r2)
                java.lang.String r1 = ", error="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Post {
        private final long at;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final long f11203id;
        private final java.lang.String text;

        public Post(long r2, long r4, java.lang.String r6) {
                r1 = this;
                java.lang.String r0 = "text"
                kotlin.jvm.internal.j.e(r6, r0)
                r1.<init>()
                r1.f11203id = r2
                r1.at = r4
                r1.text = r6
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Post copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Post r6, long r7, long r9, java.lang.String r11, int r12, java.lang.Object r13) {
                r13 = r12 & 1
                if (r13 == 0) goto L6
                long r7 = r6.f11203id
            L6:
                r1 = r7
                r7 = r12 & 2
                if (r7 == 0) goto Ld
                long r9 = r6.at
            Ld:
                r3 = r9
                r7 = r12 & 4
                if (r7 == 0) goto L14
                java.lang.String r11 = r6.text
            L14:
                r0 = r6
                r5 = r11
                com.mlmvpn.scanner.engines.argo.ArgoPool$Post r6 = r0.copy(r1, r3, r5)
                return r6
        }

        public final long component1() {
                r2 = this;
                long r0 = r2.f11203id
                return r0
        }

        public final long component2() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.text
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Post copy(long r8, long r10, java.lang.String r12) {
                r7 = this;
                java.lang.String r0 = "text"
                kotlin.jvm.internal.j.e(r12, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Post r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Post
                r2 = r8
                r4 = r10
                r6 = r12
                r1.<init>(r2, r4, r6)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Post
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Post r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Post) r8
                long r3 = r7.f11203id
                long r5 = r8.f11203id
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L15
                return r2
            L15:
                long r3 = r7.at
                long r5 = r8.at
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L1e
                return r2
            L1e:
                java.lang.String r1 = r7.text
                java.lang.String r8 = r8.text
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L29
                return r2
            L29:
                return r0
        }

        public final long getAt() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final long getId() {
                r2 = this;
                long r0 = r2.f11203id
                return r0
        }

        public final java.lang.String getText() {
                r1 = this;
                java.lang.String r0 = r1.text
                return r0
        }

        public int hashCode() {
                r4 = this;
                long r0 = r4.f11203id
                int r0 = java.lang.Long.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                long r2 = r4.at
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r1 = r4.text
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r7 = this;
                long r0 = r7.f11203id
                long r2 = r7.at
                java.lang.String r4 = r7.text
                java.lang.String r5 = "Post(id="
                java.lang.String r6 = ", at="
                java.lang.StringBuilder r0 = f0.a.o(r0, r5, r6)
                java.lang.String r1 = ", text="
                com.mlmvpn.core.aether.i.t(r2, r1, r4, r0)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Prefs {
        public static final int $stable = 0;
        private final boolean autoClean;
        private final java.lang.String cleanIp;

        public Prefs() {
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r2, r0, r1, r2)
                return
        }

        public Prefs(java.lang.String r2, boolean r3) {
                r1 = this;
                java.lang.String r0 = "cleanIp"
                kotlin.jvm.internal.j.e(r2, r0)
                r1.<init>()
                r1.cleanIp = r2
                r1.autoClean = r3
                return
        }

        public /* synthetic */ Prefs(java.lang.String r1, boolean r2, int r3, kotlin.jvm.internal.e r4) {
                r0 = this;
                r4 = r3 & 1
                if (r4 == 0) goto L6
                java.lang.String r1 = ""
            L6:
                r3 = r3 & 2
                if (r3 == 0) goto Lb
                r2 = 0
            Lb:
                r0.<init>(r1, r2)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r0, java.lang.String r1, boolean r2, int r3, java.lang.Object r4) {
                r4 = r3 & 1
                if (r4 == 0) goto L6
                java.lang.String r1 = r0.cleanIp
            L6:
                r3 = r3 & 2
                if (r3 == 0) goto Lc
                boolean r2 = r0.autoClean
            Lc:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = r0.copy(r1, r2)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.cleanIp
                return r0
        }

        public final boolean component2() {
                r1 = this;
                boolean r0 = r1.autoClean
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs copy(java.lang.String r2, boolean r3) {
                r1 = this;
                java.lang.String r0 = "cleanIp"
                kotlin.jvm.internal.j.e(r2, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs
                r0.<init>(r2, r3)
                return r0
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs) r5
                java.lang.String r1 = r4.cleanIp
                java.lang.String r3 = r5.cleanIp
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                boolean r1 = r4.autoClean
                boolean r5 = r5.autoClean
                if (r1 == r5) goto L1e
                return r2
            L1e:
                return r0
        }

        public final boolean getAutoClean() {
                r1 = this;
                boolean r0 = r1.autoClean
                return r0
        }

        public final java.lang.String getCleanIp() {
                r1 = this;
                java.lang.String r0 = r1.cleanIp
                return r0
        }

        public int hashCode() {
                r2 = this;
                java.lang.String r0 = r2.cleanIp
                int r0 = r0.hashCode()
                int r0 = r0 * 31
                boolean r1 = r2.autoClean
                int r1 = java.lang.Boolean.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r4 = this;
                java.lang.String r0 = r4.cleanIp
                boolean r1 = r4.autoClean
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Prefs(cleanIp="
                r2.<init>(r3)
                r2.append(r0)
                java.lang.String r0 = ", autoClean="
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = ")"
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ready {
        private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint ep;
        private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo info;
        private final long ms;
        private final com.mlmvpn.scanner.engines.argo.ArgoPool.Item x;

        public Ready(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r2, com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r3, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r4, long r5) {
                r1 = this;
                java.lang.String r0 = "x"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "ep"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "info"
                kotlin.jvm.internal.j.e(r4, r0)
                r1.<init>()
                r1.x = r2
                r1.ep = r3
                r1.info = r4
                r1.ms = r5
                return
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint getEp() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r1.ep
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo getInfo() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r0 = r1.info
                return r0
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Item getX() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = r1.x
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Result {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11204cc;
        private final java.lang.String edge;
        private final java.lang.String error;
        private final java.lang.String exitIp;
        private final int fails;
        private final boolean frozen;
        private final long ms;
        private final boolean ok;

        public Result(boolean r2, long r3, java.lang.String r5, java.lang.String r6, long r7, int r9, java.lang.String r10, boolean r11, java.lang.String r12) {
                r1 = this;
                java.lang.String r0 = "cc"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "exitIp"
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "error"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "edge"
                kotlin.jvm.internal.j.e(r12, r0)
                r1.<init>()
                r1.ok = r2
                r1.ms = r3
                r1.f11204cc = r5
                r1.exitIp = r6
                r1.at = r7
                r1.fails = r9
                r1.error = r10
                r1.frozen = r11
                r1.edge = r12
                return
        }

        public /* synthetic */ Result(boolean r15, long r16, java.lang.String r18, java.lang.String r19, long r20, int r22, java.lang.String r23, boolean r24, java.lang.String r25, int r26, kotlin.jvm.internal.e r27) {
                r14 = this;
                r0 = r26
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L9
                r1 = 0
                r12 = r1
                goto Lb
            L9:
                r12 = r24
            Lb:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L21
                java.lang.String r0 = ""
                r13 = r0
            L12:
                r2 = r14
                r3 = r15
                r4 = r16
                r6 = r18
                r7 = r19
                r8 = r20
                r10 = r22
                r11 = r23
                goto L24
            L21:
                r13 = r25
                goto L12
            L24:
                r2.<init>(r3, r4, r6, r7, r8, r10, r11, r12, r13)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Result copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Result r0, boolean r1, long r2, java.lang.String r4, java.lang.String r5, long r6, int r8, java.lang.String r9, boolean r10, java.lang.String r11, int r12, java.lang.Object r13) {
                r13 = r12 & 1
                if (r13 == 0) goto L6
                boolean r1 = r0.ok
            L6:
                r13 = r12 & 2
                if (r13 == 0) goto Lc
                long r2 = r0.ms
            Lc:
                r13 = r12 & 4
                if (r13 == 0) goto L12
                java.lang.String r4 = r0.f11204cc
            L12:
                r13 = r12 & 8
                if (r13 == 0) goto L18
                java.lang.String r5 = r0.exitIp
            L18:
                r13 = r12 & 16
                if (r13 == 0) goto L1e
                long r6 = r0.at
            L1e:
                r13 = r12 & 32
                if (r13 == 0) goto L24
                int r8 = r0.fails
            L24:
                r13 = r12 & 64
                if (r13 == 0) goto L2a
                java.lang.String r9 = r0.error
            L2a:
                r13 = r12 & 128(0x80, float:1.794E-43)
                if (r13 == 0) goto L30
                boolean r10 = r0.frozen
            L30:
                r12 = r12 & 256(0x100, float:3.59E-43)
                if (r12 == 0) goto L36
                java.lang.String r11 = r0.edge
            L36:
                r12 = r10
                r13 = r11
                r10 = r8
                r11 = r9
                r8 = r6
                r6 = r4
                r7 = r5
                r4 = r2
                r2 = r0
                r3 = r1
                com.mlmvpn.scanner.engines.argo.ArgoPool$Result r0 = r2.copy(r3, r4, r6, r7, r8, r10, r11, r12, r13)
                return r0
        }

        public final boolean component1() {
                r1 = this;
                boolean r0 = r1.ok
                return r0
        }

        public final long component2() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.f11204cc
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.exitIp
                return r0
        }

        public final long component5() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final int component6() {
                r1 = this;
                int r0 = r1.fails
                return r0
        }

        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final boolean component8() {
                r1 = this;
                boolean r0 = r1.frozen
                return r0
        }

        public final java.lang.String component9() {
                r1 = this;
                java.lang.String r0 = r1.edge
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Result copy(boolean r14, long r15, java.lang.String r17, java.lang.String r18, long r19, int r21, java.lang.String r22, boolean r23, java.lang.String r24) {
                r13 = this;
                java.lang.String r0 = "cc"
                r5 = r17
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "exitIp"
                r6 = r18
                kotlin.jvm.internal.j.e(r6, r0)
                java.lang.String r0 = "error"
                r10 = r22
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "edge"
                r12 = r24
                kotlin.jvm.internal.j.e(r12, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Result r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Result
                r2 = r14
                r3 = r15
                r7 = r19
                r9 = r21
                r11 = r23
                r1.<init>(r2, r3, r5, r6, r7, r9, r10, r11, r12)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Result
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Result r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r8
                boolean r1 = r7.ok
                boolean r3 = r8.ok
                if (r1 == r3) goto L13
                return r2
            L13:
                long r3 = r7.ms
                long r5 = r8.ms
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L1c
                return r2
            L1c:
                java.lang.String r1 = r7.f11204cc
                java.lang.String r3 = r8.f11204cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L27
                return r2
            L27:
                java.lang.String r1 = r7.exitIp
                java.lang.String r3 = r8.exitIp
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L32
                return r2
            L32:
                long r3 = r7.at
                long r5 = r8.at
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L3b
                return r2
            L3b:
                int r1 = r7.fails
                int r3 = r8.fails
                if (r1 == r3) goto L42
                return r2
            L42:
                java.lang.String r1 = r7.error
                java.lang.String r3 = r8.error
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L4d
                return r2
            L4d:
                boolean r1 = r7.frozen
                boolean r3 = r8.frozen
                if (r1 == r3) goto L54
                return r2
            L54:
                java.lang.String r1 = r7.edge
                java.lang.String r8 = r8.edge
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L5f
                return r2
            L5f:
                return r0
        }

        public final long getAt() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11204cc
                return r0
        }

        public final java.lang.String getEdge() {
                r1 = this;
                java.lang.String r0 = r1.edge
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final java.lang.String getExitIp() {
                r1 = this;
                java.lang.String r0 = r1.exitIp
                return r0
        }

        public final int getFails() {
                r1 = this;
                int r0 = r1.fails
                return r0
        }

        public final boolean getFrozen() {
                r1 = this;
                boolean r0 = r1.frozen
                return r0
        }

        public final long getMs() {
                r2 = this;
                long r0 = r2.ms
                return r0
        }

        public final boolean getOk() {
                r1 = this;
                boolean r0 = r1.ok
                return r0
        }

        public int hashCode() {
                r4 = this;
                boolean r0 = r4.ok
                int r0 = java.lang.Boolean.hashCode(r0)
                r1 = 31
                int r0 = r0 * r1
                long r2 = r4.ms
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r2 = r4.f11204cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.exitIp
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.at
                int r0 = a6.w0.c(r0, r1, r2)
                int r2 = r4.fails
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.String r2 = r4.error
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                boolean r2 = r4.frozen
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.String r1 = r4.edge
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r13 = this;
                boolean r0 = r13.ok
                long r1 = r13.ms
                java.lang.String r3 = r13.f11204cc
                java.lang.String r4 = r13.exitIp
                long r5 = r13.at
                int r7 = r13.fails
                java.lang.String r8 = r13.error
                boolean r9 = r13.frozen
                java.lang.String r10 = r13.edge
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                java.lang.String r12 = "Result(ok="
                r11.<init>(r12)
                r11.append(r0)
                java.lang.String r0 = ", ms="
                r11.append(r0)
                r11.append(r1)
                java.lang.String r0 = ", cc="
                java.lang.String r1 = ", exitIp="
                org.telegram.ui.Cells.d1.x(r11, r0, r3, r1, r4)
                java.lang.String r0 = ", at="
                java.lang.String r1 = ", fails="
                v0.a.k(r5, r0, r1, r11)
                java.lang.String r0 = ", error="
                java.lang.String r1 = ", frozen="
                org.telegram.ui.Cells.d1.n(r7, r0, r8, r1, r11)
                r11.append(r9)
                java.lang.String r0 = ", edge="
                r11.append(r0)
                r11.append(r10)
                java.lang.String r0 = ")"
                r11.append(r0)
                java.lang.String r0 = r11.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Row {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final java.lang.String f11205cc;
        private final java.lang.String error;
        private final java.lang.String exitIp;
        private final int fails;
        private final boolean frozen;
        private final java.lang.String host;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11206id;
        private final java.lang.String kind;
        private final java.lang.Long ms;
        private final java.lang.Boolean ok;
        private final int port;
        private final java.lang.String profile;
        private final long seen;
        private final boolean user;
        private final long verified;

        public Row(java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, boolean r9, java.lang.String r10, long r11, java.lang.Boolean r13, boolean r14, java.lang.Long r15, java.lang.String r16, java.lang.String r17, long r18, java.lang.String r20, int r21, long r22) {
                r4 = this;
                r0 = r16
                r1 = r17
                r2 = r20
                java.lang.String r3 = "id"
                kotlin.jvm.internal.j.e(r5, r3)
                java.lang.String r3 = "kind"
                kotlin.jvm.internal.j.e(r6, r3)
                java.lang.String r3 = "host"
                kotlin.jvm.internal.j.e(r7, r3)
                java.lang.String r3 = "profile"
                kotlin.jvm.internal.j.e(r10, r3)
                java.lang.String r3 = "cc"
                kotlin.jvm.internal.j.e(r0, r3)
                java.lang.String r3 = "exitIp"
                kotlin.jvm.internal.j.e(r1, r3)
                java.lang.String r3 = "error"
                kotlin.jvm.internal.j.e(r2, r3)
                r4.<init>()
                r4.f11206id = r5
                r4.kind = r6
                r4.host = r7
                r4.port = r8
                r4.user = r9
                r4.profile = r10
                r4.verified = r11
                r4.ok = r13
                r4.frozen = r14
                r4.ms = r15
                r4.f11205cc = r0
                r4.exitIp = r1
                r5 = r18
                r4.at = r5
                r4.error = r2
                r5 = r21
                r4.fails = r5
                r5 = r22
                r4.seen = r5
                return
        }

        public /* synthetic */ Row(java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, boolean r27, java.lang.String r28, long r29, java.lang.Boolean r31, boolean r32, java.lang.Long r33, java.lang.String r34, java.lang.String r35, long r36, java.lang.String r38, int r39, long r40, int r42, kotlin.jvm.internal.e r43) {
                r22 = this;
                r0 = 32768(0x8000, float:4.5918E-41)
                r0 = r42 & r0
                if (r0 == 0) goto L2c
                r0 = 0
                r20 = r0
            Lb:
                r2 = r22
                r3 = r23
                r4 = r24
                r5 = r25
                r6 = r26
                r7 = r27
                r8 = r28
                r9 = r29
                r11 = r31
                r12 = r32
                r13 = r33
                r14 = r34
                r15 = r35
                r16 = r36
                r18 = r38
                r19 = r39
                goto L2f
            L2c:
                r20 = r40
                goto Lb
            L2f:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r18, r19, r20)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Row copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Row r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, boolean r21, java.lang.String r22, long r23, java.lang.Boolean r25, boolean r26, java.lang.Long r27, java.lang.String r28, java.lang.String r29, long r30, java.lang.String r32, int r33, long r34, int r36, java.lang.Object r37) {
                r0 = r16
                r1 = r36
                r2 = r1 & 1
                if (r2 == 0) goto Lb
                java.lang.String r2 = r0.f11206id
                goto Ld
            Lb:
                r2 = r17
            Ld:
                r3 = r1 & 2
                if (r3 == 0) goto L14
                java.lang.String r3 = r0.kind
                goto L16
            L14:
                r3 = r18
            L16:
                r4 = r1 & 4
                if (r4 == 0) goto L1d
                java.lang.String r4 = r0.host
                goto L1f
            L1d:
                r4 = r19
            L1f:
                r5 = r1 & 8
                if (r5 == 0) goto L26
                int r5 = r0.port
                goto L28
            L26:
                r5 = r20
            L28:
                r6 = r1 & 16
                if (r6 == 0) goto L2f
                boolean r6 = r0.user
                goto L31
            L2f:
                r6 = r21
            L31:
                r7 = r1 & 32
                if (r7 == 0) goto L38
                java.lang.String r7 = r0.profile
                goto L3a
            L38:
                r7 = r22
            L3a:
                r8 = r1 & 64
                if (r8 == 0) goto L41
                long r8 = r0.verified
                goto L43
            L41:
                r8 = r23
            L43:
                r10 = r1 & 128(0x80, float:1.794E-43)
                if (r10 == 0) goto L4a
                java.lang.Boolean r10 = r0.ok
                goto L4c
            L4a:
                r10 = r25
            L4c:
                r11 = r1 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L53
                boolean r11 = r0.frozen
                goto L55
            L53:
                r11 = r26
            L55:
                r12 = r1 & 512(0x200, float:7.175E-43)
                if (r12 == 0) goto L5c
                java.lang.Long r12 = r0.ms
                goto L5e
            L5c:
                r12 = r27
            L5e:
                r13 = r1 & 1024(0x400, float:1.435E-42)
                if (r13 == 0) goto L65
                java.lang.String r13 = r0.f11205cc
                goto L67
            L65:
                r13 = r28
            L67:
                r14 = r1 & 2048(0x800, float:2.87E-42)
                if (r14 == 0) goto L6e
                java.lang.String r14 = r0.exitIp
                goto L70
            L6e:
                r14 = r29
            L70:
                r15 = r1 & 4096(0x1000, float:5.74E-42)
                r17 = r2
                r18 = r3
                if (r15 == 0) goto L7b
                long r2 = r0.at
                goto L7d
            L7b:
                r2 = r30
            L7d:
                r15 = r1 & 8192(0x2000, float:1.14794E-41)
                if (r15 == 0) goto L84
                java.lang.String r15 = r0.error
                goto L86
            L84:
                r15 = r32
            L86:
                r19 = r2
                r2 = r1 & 16384(0x4000, float:2.2959E-41)
                if (r2 == 0) goto L8f
                int r2 = r0.fails
                goto L91
            L8f:
                r2 = r33
            L91:
                r3 = 32768(0x8000, float:4.5918E-41)
                r1 = r1 & r3
                if (r1 == 0) goto Lbe
                r21 = r2
                long r1 = r0.seen
                r34 = r21
                r35 = r1
            L9f:
                r31 = r19
                r20 = r4
                r21 = r5
                r22 = r6
                r23 = r7
                r24 = r8
                r26 = r10
                r27 = r11
                r28 = r12
                r29 = r13
                r30 = r14
                r33 = r15
                r19 = r18
                r18 = r17
                r17 = r0
                goto Lc3
            Lbe:
                r35 = r34
                r34 = r2
                goto L9f
            Lc3:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Row r0 = r17.copy(r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r33, r34, r35)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11206id
                return r0
        }

        public final java.lang.Long component10() {
                r1 = this;
                java.lang.Long r0 = r1.ms
                return r0
        }

        public final java.lang.String component11() {
                r1 = this;
                java.lang.String r0 = r1.f11205cc
                return r0
        }

        public final java.lang.String component12() {
                r1 = this;
                java.lang.String r0 = r1.exitIp
                return r0
        }

        public final long component13() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String component14() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final int component15() {
                r1 = this;
                int r0 = r1.fails
                return r0
        }

        public final long component16() {
                r2 = this;
                long r0 = r2.seen
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.port
                return r0
        }

        public final boolean component5() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final long component7() {
                r2 = this;
                long r0 = r2.verified
                return r0
        }

        public final java.lang.Boolean component8() {
                r1 = this;
                java.lang.Boolean r0 = r1.ok
                return r0
        }

        public final boolean component9() {
                r1 = this;
                boolean r0 = r1.frozen
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Row copy(java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, boolean r26, java.lang.String r27, long r28, java.lang.Boolean r30, boolean r31, java.lang.Long r32, java.lang.String r33, java.lang.String r34, long r35, java.lang.String r37, int r38, long r39) {
                r21 = this;
                java.lang.String r0 = "id"
                r2 = r22
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "kind"
                r3 = r23
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "host"
                r4 = r24
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "profile"
                r7 = r27
                kotlin.jvm.internal.j.e(r7, r0)
                java.lang.String r0 = "cc"
                r13 = r33
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "exitIp"
                r14 = r34
                kotlin.jvm.internal.j.e(r14, r0)
                java.lang.String r0 = "error"
                r1 = r37
                kotlin.jvm.internal.j.e(r1, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Row r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Row
                r5 = r25
                r6 = r26
                r8 = r28
                r10 = r30
                r11 = r31
                r12 = r32
                r15 = r35
                r17 = r37
                r18 = r38
                r19 = r39
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r17, r18, r19)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Row
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Row r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Row) r8
                java.lang.String r1 = r7.f11206id
                java.lang.String r3 = r8.f11206id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.kind
                java.lang.String r3 = r8.kind
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r7.host
                java.lang.String r3 = r8.host
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                int r1 = r7.port
                int r3 = r8.port
                if (r1 == r3) goto L34
                return r2
            L34:
                boolean r1 = r7.user
                boolean r3 = r8.user
                if (r1 == r3) goto L3b
                return r2
            L3b:
                java.lang.String r1 = r7.profile
                java.lang.String r3 = r8.profile
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L46
                return r2
            L46:
                long r3 = r7.verified
                long r5 = r8.verified
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L4f
                return r2
            L4f:
                java.lang.Boolean r1 = r7.ok
                java.lang.Boolean r3 = r8.ok
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L5a
                return r2
            L5a:
                boolean r1 = r7.frozen
                boolean r3 = r8.frozen
                if (r1 == r3) goto L61
                return r2
            L61:
                java.lang.Long r1 = r7.ms
                java.lang.Long r3 = r8.ms
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L6c
                return r2
            L6c:
                java.lang.String r1 = r7.f11205cc
                java.lang.String r3 = r8.f11205cc
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L77
                return r2
            L77:
                java.lang.String r1 = r7.exitIp
                java.lang.String r3 = r8.exitIp
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L82
                return r2
            L82:
                long r3 = r7.at
                long r5 = r8.at
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L8b
                return r2
            L8b:
                java.lang.String r1 = r7.error
                java.lang.String r3 = r8.error
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L96
                return r2
            L96:
                int r1 = r7.fails
                int r3 = r8.fails
                if (r1 == r3) goto L9d
                return r2
            L9d:
                long r3 = r7.seen
                long r5 = r8.seen
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto La6
                return r2
            La6:
                return r0
        }

        public final long getAt() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String getCc() {
                r1 = this;
                java.lang.String r0 = r1.f11205cc
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final java.lang.String getExitIp() {
                r1 = this;
                java.lang.String r0 = r1.exitIp
                return r0
        }

        public final int getFails() {
                r1 = this;
                int r0 = r1.fails
                return r0
        }

        public final boolean getFrozen() {
                r1 = this;
                boolean r0 = r1.frozen
                return r0
        }

        public final java.lang.String getHost() {
                r1 = this;
                java.lang.String r0 = r1.host
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11206id
                return r0
        }

        public final java.lang.String getKind() {
                r1 = this;
                java.lang.String r0 = r1.kind
                return r0
        }

        public final java.lang.Long getMs() {
                r1 = this;
                java.lang.Long r0 = r1.ms
                return r0
        }

        public final java.lang.Boolean getOk() {
                r1 = this;
                java.lang.Boolean r0 = r1.ok
                return r0
        }

        public final int getPort() {
                r1 = this;
                int r0 = r1.port
                return r0
        }

        public final java.lang.String getProfile() {
                r1 = this;
                java.lang.String r0 = r1.profile
                return r0
        }

        public final long getSeen() {
                r2 = this;
                long r0 = r2.seen
                return r0
        }

        public final boolean getUser() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final long getVerified() {
                r2 = this;
                long r0 = r2.verified
                return r0
        }

        public int hashCode() {
                r4 = this;
                java.lang.String r0 = r4.f11206id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r4.kind
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.host
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r4.port
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                boolean r2 = r4.user
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.String r2 = r4.profile
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.verified
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.Boolean r2 = r4.ok
                r3 = 0
                if (r2 != 0) goto L34
                r2 = r3
                goto L38
            L34:
                int r2 = r2.hashCode()
            L38:
                int r0 = r0 + r2
                int r0 = r0 * r1
                boolean r2 = r4.frozen
                int r0 = a6.w0.d(r0, r1, r2)
                java.lang.Long r2 = r4.ms
                if (r2 != 0) goto L45
                goto L49
            L45:
                int r3 = r2.hashCode()
            L49:
                int r0 = r0 + r3
                int r0 = r0 * r1
                java.lang.String r2 = r4.f11205cc
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.lang.String r2 = r4.exitIp
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                long r2 = r4.at
                int r0 = a6.w0.c(r0, r1, r2)
                java.lang.String r2 = r4.error
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                int r2 = r4.fails
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                long r1 = r4.seen
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r22 = this;
                r0 = r22
                java.lang.String r1 = r0.f11206id
                java.lang.String r2 = r0.kind
                java.lang.String r3 = r0.host
                int r4 = r0.port
                boolean r5 = r0.user
                java.lang.String r6 = r0.profile
                long r7 = r0.verified
                java.lang.Boolean r9 = r0.ok
                boolean r10 = r0.frozen
                java.lang.Long r11 = r0.ms
                java.lang.String r12 = r0.f11205cc
                java.lang.String r13 = r0.exitIp
                long r14 = r0.at
                r16 = r14
                java.lang.String r14 = r0.error
                int r15 = r0.fails
                r18 = r14
                r19 = r15
                long r14 = r0.seen
                java.lang.String r0 = ", kind="
                r20 = r14
                java.lang.String r14 = ", host="
                java.lang.String r15 = "Row(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r15, r1, r0, r2, r14)
                java.lang.String r1 = ", port="
                java.lang.String r2 = ", user="
                f0.a.r(r4, r3, r1, r2, r0)
                java.lang.String r1 = ", profile="
                java.lang.String r2 = ", verified="
                com.mlmvpn.core.aether.i.x(r1, r6, r2, r0, r5)
                r0.append(r7)
                java.lang.String r1 = ", ok="
                r0.append(r1)
                r0.append(r9)
                java.lang.String r1 = ", frozen="
                r0.append(r1)
                r0.append(r10)
                java.lang.String r1 = ", ms="
                r0.append(r1)
                r0.append(r11)
                java.lang.String r1 = ", cc="
                java.lang.String r2 = ", exitIp="
                org.telegram.ui.Cells.d1.x(r0, r1, r12, r2, r13)
                java.lang.String r1 = ", at="
                java.lang.String r2 = ", error="
                r3 = r16
                v0.a.k(r3, r1, r2, r0)
                java.lang.String r1 = ", fails="
                java.lang.String r2 = ", seen="
                r3 = r18
                r4 = r19
                f0.a.r(r4, r3, r1, r2, r0)
                java.lang.String r1 = ")"
                r2 = r20
                java.lang.String r0 = a6.w0.k(r2, r1, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Source {
        public static final int $stable = 8;
        private final long addedAt;
        private final boolean builtin;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final java.lang.String f11207id;
        private final java.lang.String label;
        private final java.lang.String type;
        private final boolean user;
        private final java.util.List<java.lang.String> value;

        public Source(java.lang.String r2, java.lang.String r3, java.util.List<java.lang.String> r4, java.lang.String r5, boolean r6, boolean r7, long r8) {
                r1 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "type"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "value"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "label"
                kotlin.jvm.internal.j.e(r5, r0)
                r1.<init>()
                r1.f11207id = r2
                r1.type = r3
                r1.value = r4
                r1.label = r5
                r1.builtin = r6
                r1.user = r7
                r1.addedAt = r8
                return
        }

        public /* synthetic */ Source(java.lang.String r2, java.lang.String r3, java.util.List r4, java.lang.String r5, boolean r6, boolean r7, long r8, int r10, kotlin.jvm.internal.e r11) {
                r1 = this;
                r11 = r10 & 16
                r0 = 0
                if (r11 == 0) goto L6
                r6 = r0
            L6:
                r11 = r10 & 32
                if (r11 == 0) goto Lb
                r7 = r0
            Lb:
                r10 = r10 & 64
                if (r10 == 0) goto L11
                r8 = 0
            L11:
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Source copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r0, java.lang.String r1, java.lang.String r2, java.util.List r3, java.lang.String r4, boolean r5, boolean r6, long r7, int r9, java.lang.Object r10) {
                r10 = r9 & 1
                if (r10 == 0) goto L6
                java.lang.String r1 = r0.f11207id
            L6:
                r10 = r9 & 2
                if (r10 == 0) goto Lc
                java.lang.String r2 = r0.type
            Lc:
                r10 = r9 & 4
                if (r10 == 0) goto L12
                java.util.List<java.lang.String> r3 = r0.value
            L12:
                r10 = r9 & 8
                if (r10 == 0) goto L18
                java.lang.String r4 = r0.label
            L18:
                r10 = r9 & 16
                if (r10 == 0) goto L1e
                boolean r5 = r0.builtin
            L1e:
                r10 = r9 & 32
                if (r10 == 0) goto L24
                boolean r6 = r0.user
            L24:
                r9 = r9 & 64
                if (r9 == 0) goto L2a
                long r7 = r0.addedAt
            L2a:
                r9 = r7
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9)
                return r0
        }

        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.f11207id
                return r0
        }

        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.type
                return r0
        }

        public final java.util.List<java.lang.String> component3() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.value
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.label
                return r0
        }

        public final boolean component5() {
                r1 = this;
                boolean r0 = r1.builtin
                return r0
        }

        public final boolean component6() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final long component7() {
                r2 = this;
                long r0 = r2.addedAt
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Source copy(java.lang.String r11, java.lang.String r12, java.util.List<java.lang.String> r13, java.lang.String r14, boolean r15, boolean r16, long r17) {
                r10 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "type"
                kotlin.jvm.internal.j.e(r12, r0)
                java.lang.String r0 = "value"
                kotlin.jvm.internal.j.e(r13, r0)
                java.lang.String r0 = "label"
                kotlin.jvm.internal.j.e(r14, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source
                r2 = r11
                r3 = r12
                r4 = r13
                r5 = r14
                r6 = r15
                r7 = r16
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
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Source
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r8
                java.lang.String r1 = r7.f11207id
                java.lang.String r3 = r8.f11207id
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.lang.String r1 = r7.type
                java.lang.String r3 = r8.type
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.util.List<java.lang.String> r1 = r7.value
                java.util.List<java.lang.String> r3 = r8.value
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.lang.String r1 = r7.label
                java.lang.String r3 = r8.label
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                boolean r1 = r7.builtin
                boolean r3 = r8.builtin
                if (r1 == r3) goto L3f
                return r2
            L3f:
                boolean r1 = r7.user
                boolean r3 = r8.user
                if (r1 == r3) goto L46
                return r2
            L46:
                long r3 = r7.addedAt
                long r5 = r8.addedAt
                int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r8 == 0) goto L4f
                return r2
            L4f:
                return r0
        }

        public final long getAddedAt() {
                r2 = this;
                long r0 = r2.addedAt
                return r0
        }

        public final boolean getBuiltin() {
                r1 = this;
                boolean r0 = r1.builtin
                return r0
        }

        public final java.lang.String getId() {
                r1 = this;
                java.lang.String r0 = r1.f11207id
                return r0
        }

        public final java.lang.String getLabel() {
                r1 = this;
                java.lang.String r0 = r1.label
                return r0
        }

        public final java.lang.String getType() {
                r1 = this;
                java.lang.String r0 = r1.type
                return r0
        }

        public final boolean getUser() {
                r1 = this;
                boolean r0 = r1.user
                return r0
        }

        public final java.util.List<java.lang.String> getValue() {
                r1 = this;
                java.util.List<java.lang.String> r0 = r1.value
                return r0
        }

        public int hashCode() {
                r3 = this;
                java.lang.String r0 = r3.f11207id
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.lang.String r2 = r3.type
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                java.util.List<java.lang.String> r2 = r3.value
                int r0 = androidx.compose.foundation.interaction.f.f(r0, r1, r2)
                java.lang.String r2 = r3.label
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                boolean r2 = r3.builtin
                int r0 = a6.w0.d(r0, r1, r2)
                boolean r2 = r3.user
                int r0 = a6.w0.d(r0, r1, r2)
                long r1 = r3.addedAt
                int r1 = java.lang.Long.hashCode(r1)
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r11 = this;
                java.lang.String r0 = r11.f11207id
                java.lang.String r1 = r11.type
                java.util.List<java.lang.String> r2 = r11.value
                java.lang.String r3 = r11.label
                boolean r4 = r11.builtin
                boolean r5 = r11.user
                long r6 = r11.addedAt
                java.lang.String r8 = ", type="
                java.lang.String r9 = ", value="
                java.lang.String r10 = "Source(id="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r10, r0, r8, r1, r9)
                r0.append(r2)
                java.lang.String r1 = ", label="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = ", builtin="
                r0.append(r1)
                java.lang.String r1 = ", user="
                java.lang.String r2 = ", addedAt="
                androidx.media3.common.s.x(r0, r4, r1, r5, r2)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.k(r6, r1, r0)
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class SourceView {
        public static final int $stable = 8;
        private final long at;
        private final java.lang.String error;
        private final int found;
        private final boolean on;
        private final com.mlmvpn.scanner.engines.argo.ArgoPool.Source src;
        private final int total;

        public SourceView(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r2, boolean r3, long r4, int r6, int r7, java.lang.String r8) {
                r1 = this;
                java.lang.String r0 = "src"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "error"
                kotlin.jvm.internal.j.e(r8, r0)
                r1.<init>()
                r1.src = r2
                r1.on = r3
                r1.at = r4
                r1.found = r6
                r1.total = r7
                r1.error = r8
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r1, boolean r2, long r3, int r5, int r6, java.lang.String r7, int r8, java.lang.Object r9) {
                r9 = r8 & 1
                if (r9 == 0) goto L6
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r1 = r0.src
            L6:
                r9 = r8 & 2
                if (r9 == 0) goto Lc
                boolean r2 = r0.on
            Lc:
                r9 = r8 & 4
                if (r9 == 0) goto L12
                long r3 = r0.at
            L12:
                r9 = r8 & 8
                if (r9 == 0) goto L18
                int r5 = r0.found
            L18:
                r9 = r8 & 16
                if (r9 == 0) goto L1e
                int r6 = r0.total
            L1e:
                r8 = r8 & 32
                if (r8 == 0) goto L24
                java.lang.String r7 = r0.error
            L24:
                r8 = r6
                r9 = r7
                r7 = r5
                r5 = r3
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r0 = r2.copy(r3, r4, r5, r7, r8, r9)
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Source component1() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = r1.src
                return r0
        }

        public final boolean component2() {
                r1 = this;
                boolean r0 = r1.on
                return r0
        }

        public final long component3() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final int component4() {
                r1 = this;
                int r0 = r1.found
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public final java.lang.String component6() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView copy(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r10, boolean r11, long r12, int r14, int r15, java.lang.String r16) {
                r9 = this;
                java.lang.String r0 = "src"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "error"
                r8 = r16
                kotlin.jvm.internal.j.e(r8, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView
                r2 = r10
                r3 = r11
                r4 = r12
                r6 = r14
                r7 = r15
                r1.<init>(r2, r3, r4, r6, r7, r8)
                return r1
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView) r8
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r1 = r7.src
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r3 = r8.src
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                boolean r1 = r7.on
                boolean r3 = r8.on
                if (r1 == r3) goto L1e
                return r2
            L1e:
                long r3 = r7.at
                long r5 = r8.at
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 == 0) goto L27
                return r2
            L27:
                int r1 = r7.found
                int r3 = r8.found
                if (r1 == r3) goto L2e
                return r2
            L2e:
                int r1 = r7.total
                int r3 = r8.total
                if (r1 == r3) goto L35
                return r2
            L35:
                java.lang.String r1 = r7.error
                java.lang.String r8 = r8.error
                boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                if (r8 != 0) goto L40
                return r2
            L40:
                return r0
        }

        public final long getAt() {
                r2 = this;
                long r0 = r2.at
                return r0
        }

        public final java.lang.String getError() {
                r1 = this;
                java.lang.String r0 = r1.error
                return r0
        }

        public final int getFound() {
                r1 = this;
                int r0 = r1.found
                return r0
        }

        public final boolean getOn() {
                r1 = this;
                boolean r0 = r1.on
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Source getSrc() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = r1.src
                return r0
        }

        public final int getTotal() {
                r1 = this;
                int r0 = r1.total
                return r0
        }

        public int hashCode() {
                r4 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = r4.src
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                boolean r2 = r4.on
                int r0 = a6.w0.d(r0, r1, r2)
                long r2 = r4.at
                int r0 = a6.w0.c(r0, r1, r2)
                int r2 = r4.found
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                int r2 = r4.total
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.lang.String r1 = r4.error
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r9 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = r9.src
                boolean r1 = r9.on
                long r2 = r9.at
                int r4 = r9.found
                int r5 = r9.total
                java.lang.String r6 = r9.error
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "SourceView(src="
                r7.<init>(r8)
                r7.append(r0)
                java.lang.String r0 = ", on="
                r7.append(r0)
                r7.append(r1)
                java.lang.String r0 = ", at="
                r7.append(r0)
                java.lang.String r0 = ", found="
                androidx.media3.common.s.p(r4, r2, r0, r7)
                java.lang.String r0 = ", total="
                r7.append(r0)
                r7.append(r5)
                java.lang.String r0 = ", error="
                r7.append(r0)
                r7.append(r6)
                java.lang.String r0 = ")"
                r7.append(r0)
                java.lang.String r0 = r7.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Summary {
        public static final int $stable = 8;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> cleanList;
        private final com.mlmvpn.scanner.engines.argo.ArgoPool.Counts counts;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> falconList;
        private final int falconServers;
        private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Group> groups;
        private final com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs prefs;

        public Summary(com.mlmvpn.scanner.engines.argo.ArgoPool.Counts r2, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Group> r3, com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r4, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> r5, int r6, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> r7) {
                r1 = this;
                java.lang.String r0 = "counts"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "groups"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "prefs"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "cleanList"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "falconList"
                kotlin.jvm.internal.j.e(r7, r0)
                r1.<init>()
                r1.counts = r2
                r1.groups = r3
                r1.prefs = r4
                r1.cleanList = r5
                r1.falconServers = r6
                r1.falconList = r7
                return
        }

        public Summary(com.mlmvpn.scanner.engines.argo.ArgoPool.Counts r8, java.util.List r9, com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r10, java.util.List r11, int r12, java.util.List r13, int r14, kotlin.jvm.internal.e r15) {
                r7 = this;
                r14 = r14 & 32
                if (r14 == 0) goto L6
                kotlin.collections.w r13 = kotlin.collections.w.INSTANCE
            L6:
                r0 = r7
                r1 = r8
                r2 = r9
                r3 = r10
                r4 = r11
                r5 = r12
                r6 = r13
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Summary copy$default(com.mlmvpn.scanner.engines.argo.ArgoPool.Summary r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Counts r1, java.util.List r2, com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r3, java.util.List r4, int r5, java.util.List r6, int r7, java.lang.Object r8) {
                r8 = r7 & 1
                if (r8 == 0) goto L6
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r1 = r0.counts
            L6:
                r8 = r7 & 2
                if (r8 == 0) goto Lc
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r2 = r0.groups
            Lc:
                r8 = r7 & 4
                if (r8 == 0) goto L12
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r3 = r0.prefs
            L12:
                r8 = r7 & 8
                if (r8 == 0) goto L18
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r4 = r0.cleanList
            L18:
                r8 = r7 & 16
                if (r8 == 0) goto L1e
                int r5 = r0.falconServers
            L1e:
                r7 = r7 & 32
                if (r7 == 0) goto L24
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r6 = r0.falconList
            L24:
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                r2 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Summary r0 = r2.copy(r3, r4, r5, r6, r7, r8)
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Counts component1() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = r1.counts
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Group> component2() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r0 = r1.groups
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs component3() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = r1.prefs
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> component4() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r0 = r1.cleanList
                return r0
        }

        public final int component5() {
                r1 = this;
                int r0 = r1.falconServers
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> component6() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r0 = r1.falconList
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Summary copy(com.mlmvpn.scanner.engines.argo.ArgoPool.Counts r9, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Group> r10, com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r11, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> r12, int r13, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> r14) {
                r8 = this;
                java.lang.String r0 = "counts"
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "groups"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "prefs"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "cleanList"
                kotlin.jvm.internal.j.e(r12, r0)
                java.lang.String r0 = "falconList"
                kotlin.jvm.internal.j.e(r14, r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Summary r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Summary
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
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.Summary
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Summary r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Summary) r5
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r1 = r4.counts
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r3 = r5.counts
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r1 = r4.groups
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r3 = r5.groups
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r1 = r4.prefs
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r3 = r5.prefs
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r1 = r4.cleanList
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r3 = r5.cleanList
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                int r1 = r4.falconServers
                int r3 = r5.falconServers
                if (r1 == r3) goto L3f
                return r2
            L3f:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r1 = r4.falconList
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r5 = r5.falconList
                boolean r5 = kotlin.jvm.internal.j.a(r1, r5)
                if (r5 != 0) goto L4a
                return r2
            L4a:
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp> getCleanList() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r0 = r1.cleanList
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Counts getCounts() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = r1.counts
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> getFalconList() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r0 = r1.falconList
                return r0
        }

        public final int getFalconServers() {
                r1 = this;
                int r0 = r1.falconServers
                return r0
        }

        public final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Group> getGroups() {
                r1 = this;
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r0 = r1.groups
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs getPrefs() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = r1.prefs
                return r0
        }

        public int hashCode() {
                r3 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = r3.counts
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r2 = r3.groups
                int r0 = androidx.compose.foundation.interaction.f.f(r0, r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r2 = r3.prefs
                int r2 = r2.hashCode()
                int r2 = r2 + r0
                int r2 = r2 * r1
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r0 = r3.cleanList
                int r0 = androidx.compose.foundation.interaction.f.f(r2, r1, r0)
                int r2 = r3.falconServers
                int r0 = androidx.compose.foundation.interaction.f.c(r2, r0, r1)
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r1 = r3.falconList
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r8 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r0 = r8.counts
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Group> r1 = r8.groups
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r2 = r8.prefs
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp> r3 = r8.cleanList
                int r4 = r8.falconServers
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r5 = r8.falconList
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Summary(counts="
                r6.<init>(r7)
                r6.append(r0)
                java.lang.String r0 = ", groups="
                r6.append(r0)
                r6.append(r1)
                java.lang.String r0 = ", prefs="
                r6.append(r0)
                r6.append(r2)
                java.lang.String r0 = ", cleanList="
                r6.append(r0)
                r6.append(r3)
                java.lang.String r0 = ", falconServers="
                r6.append(r0)
                r6.append(r4)
                java.lang.String r0 = ", falconList="
                r6.append(r0)
                r6.append(r5)
                java.lang.String r0 = ")"
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        private volatile boolean carried;
        private final java.lang.String ip;
        private final java.lang.String loc;
        private final boolean ok;

        public Trace(boolean r2, java.lang.String r3, java.lang.String r4) {
                r1 = this;
                java.lang.String r0 = "loc"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r4, r0)
                r1.<init>()
                r1.ok = r2
                r1.loc = r3
                r1.ip = r4
                return
        }

        public /* synthetic */ Trace(boolean r2, java.lang.String r3, java.lang.String r4, int r5, kotlin.jvm.internal.e r6) {
                r1 = this;
                r6 = r5 & 2
                java.lang.String r0 = ""
                if (r6 == 0) goto L7
                r3 = r0
            L7:
                r5 = r5 & 4
                if (r5 == 0) goto Lc
                r4 = r0
            Lc:
                r1.<init>(r2, r3, r4)
                return
        }

        public final boolean getCarried() {
                r1 = this;
                boolean r0 = r1.carried
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

        public final boolean getOk() {
                r1 = this;
                boolean r0 = r1.ok
                return r0
        }

        public final void setCarried(boolean r1) {
                r0 = this;
                r0.carried = r1
                return
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$harvestTelegram$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool", f = "ArgoPool.kt", l = {303, 331}, m = "harvestTelegram")
    public static final class AnonymousClass1 extends xd.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool this$0;

        public AnonymousClass1(com.mlmvpn.scanner.engines.argo.ArgoPool r1, wd.d r2) {
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
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = r7.this$0
                r4 = 0
                r5 = 0
                r1 = 0
                r2 = 0
                r3 = 0
                r6 = r7
                java.lang.Object r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$harvestTelegram(r0, r1, r2, r3, r4, r5, r6)
                return r8
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2", f = "ArgoPool.kt", l = {575, 583, 576, 577, 578, 580, 583, 583}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> $batch;
        final /* synthetic */ java.lang.String $connectIp;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends xd.j implements ee.e {
            final /* synthetic */ com.mlmvpn.core.warp.VlessXrayInjector $core;
            private /* synthetic */ java.lang.Object L$0;
            int label;

            public AnonymousClass5(com.mlmvpn.core.warp.VlessXrayInjector r1, wd.d r2) {
                    r0 = this;
                    r0.$core = r1
                    r1 = 2
                    r0.<init>(r1, r2)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r3, wd.d r4) {
                    r2 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5
                    com.mlmvpn.core.warp.VlessXrayInjector r1 = r2.$core
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
                    com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.AnonymousClass2.AnonymousClass5) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                    r1 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r0 = r1.label
                    if (r0 != 0) goto L27
                    sd.m.b(r2)
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.i0 r2 = (kotlinx.coroutines.i0) r2
                    com.mlmvpn.core.warp.VlessXrayInjector r2 = r1.$core
                    r2.stop()     // Catch: java.lang.Throwable -> L19
                    sd.u r2 = sd.u.f67154a     // Catch: java.lang.Throwable -> L19
                    java.lang.Object r2 = sd.l.m1004constructorimpl(r2)     // Catch: java.lang.Throwable -> L19
                    goto L22
                L19:
                    r2 = move-exception
                    sd.l$a r2 = sd.m.a(r2)
                    java.lang.Object r2 = sd.l.m1004constructorimpl(r2)
                L22:
                    sd.l r2 = sd.l.m1003boximpl(r2)
                    return r2
                L27:
                    java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r2.<init>(r0)
                    throw r2
            }
        }

        public AnonymousClass2(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> r1, java.lang.String r2, wd.d r3) {
                r0 = this;
                r0.$batch = r1
                r0.$connectIp = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r4, wd.d r5) {
                r3 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r1 = r3.$batch
                java.lang.String r2 = r3.$connectIp
                r0.<init>(r1, r2, r5)
                r0.L$0 = r4
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.AnonymousClass2) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
                r23 = this;
                r1 = r23
                kotlin.coroutines.intrinsics.a r2 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r1.label
                r4 = 10
                switch(r0) {
                    case 0: goto L91;
                    case 1: goto L7b;
                    case 2: goto L1c;
                    case 3: goto L67;
                    case 4: goto L4f;
                    case 5: goto L34;
                    case 6: goto L24;
                    case 7: goto L1c;
                    case 8: goto L13;
                    default: goto Lb;
                }
            Lb:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L13:
                java.lang.Object r0 = r1.L$0
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                sd.m.b(r24)
                goto L3b9
            L1c:
                java.lang.Object r0 = r1.L$0
                java.util.List r0 = (java.util.List) r0
                sd.m.b(r24)
                return r0
            L24:
                java.lang.Object r0 = r1.L$1
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r3 = r1.L$0
                com.mlmvpn.core.warp.VlessXrayInjector r3 = (com.mlmvpn.core.warp.VlessXrayInjector) r3
                sd.m.b(r24)     // Catch: java.lang.Throwable -> L31
                goto L370
            L31:
                r0 = move-exception
                goto L398
            L34:
                java.lang.Object r0 = r1.L$3
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r7 = r1.L$2
                com.mlmvpn.core.warp.VlessXrayInjector r7 = (com.mlmvpn.core.warp.VlessXrayInjector) r7
                java.lang.Object r8 = r1.L$1
                java.util.List r8 = (java.util.List) r8
                java.lang.Object r9 = r1.L$0
                kotlinx.coroutines.i0 r9 = (kotlinx.coroutines.i0) r9
                sd.m.b(r24)     // Catch: java.lang.Throwable -> L4b
                r3 = r7
                r15 = 0
                goto L322
            L4b:
                r0 = move-exception
                r3 = r7
                goto L398
            L4f:
                java.lang.Object r0 = r1.L$2
                r7 = r0
                com.mlmvpn.core.warp.VlessXrayInjector r7 = (com.mlmvpn.core.warp.VlessXrayInjector) r7
                java.lang.Object r0 = r1.L$1
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r8 = r1.L$0
                kotlinx.coroutines.i0 r8 = (kotlinx.coroutines.i0) r8
                sd.m.b(r24)     // Catch: java.lang.Throwable -> L4b
                r4 = r24
                r3 = r7
                r15 = 0
            L63:
                r9 = r8
                r8 = r0
                goto L2d1
            L67:
                java.lang.Object r0 = r1.L$2
                r7 = r0
                com.mlmvpn.core.warp.VlessXrayInjector r7 = (com.mlmvpn.core.warp.VlessXrayInjector) r7
                java.lang.Object r0 = r1.L$1
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r8 = r1.L$0
                kotlinx.coroutines.i0 r8 = (kotlinx.coroutines.i0) r8
                sd.m.b(r24)     // Catch: java.lang.Throwable -> L4b
                r15 = 0
            L78:
                r3 = r7
                goto L290
            L7b:
                java.lang.Object r0 = r1.L$2
                r7 = r0
                com.mlmvpn.core.warp.VlessXrayInjector r7 = (com.mlmvpn.core.warp.VlessXrayInjector) r7
                java.lang.Object r0 = r1.L$1
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r8 = r1.L$0
                kotlinx.coroutines.i0 r8 = (kotlinx.coroutines.i0) r8
                sd.m.b(r24)     // Catch: java.lang.Throwable -> L4b
                r3 = r24
                r21 = 0
                goto L21a
            L91:
                sd.m.b(r24)
                java.lang.Object r0 = r1.L$0
                kotlinx.coroutines.i0 r0 = (kotlinx.coroutines.i0) r0
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r7 = r1.$batch
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                int r9 = kotlin.collections.s.g0(r7, r4)
                r8.<init>(r9)
                java.util.Iterator r7 = r7.iterator()
            La9:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto Lc4
                java.lang.Object r9 = r7.next()
                com.mlmvpn.scanner.engines.argo.ArgoPool$Ready r9 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Ready) r9
                com.mlmvpn.scanner.engines.argo.ArgoPool r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                int r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$freePort(r9)
                java.lang.Integer r10 = new java.lang.Integer
                r10.<init>(r9)
                r8.add(r10)
                goto La9
            Lc4:
                sf.a r7 = new sf.a
                r7.<init>()
                sf.a r9 = new sf.a
                r9.<init>()
                sf.a r10 = new sf.a
                r10.<init>()
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r11 = r1.$batch
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.lang.String r12 = r1.$connectIp
                java.util.Iterator r11 = r11.iterator()
                r13 = 0
            Lde:
                boolean r14 = r11.hasNext()
                java.lang.String r15 = "protocol"
                java.lang.String r3 = "tag"
                if (r14 == 0) goto L1a7
                java.lang.Object r14 = r11.next()
                int r20 = r13 + 1
                if (r13 < 0) goto L1a1
                com.mlmvpn.scanner.engines.argo.ArgoPool$Ready r14 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Ready) r14
                r21 = 0
                sf.c r6 = new sf.c
                r6.<init>()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "in"
                r4.<init>(r5)
                r4.append(r13)
                java.lang.String r4 = r4.toString()
                r6.D(r3, r4)
                java.lang.String r3 = "listen"
                java.lang.String r4 = "127.0.0.1"
                r6.D(r3, r4)
                java.lang.Object r3 = r8.get(r13)
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = "port"
                r6.D(r4, r3)
                java.lang.String r3 = "socks"
                r6.D(r15, r3)
                sf.c r3 = new sf.c
                r3.<init>()
                java.lang.String r4 = "udp"
                r15 = 0
                r3.E(r4, r15)
                java.lang.String r4 = "settings"
                r6.D(r4, r3)
                r7.put(r6)
                r16 = r12
                com.mlmvpn.scanner.engines.argo.ArgoProtocol r12 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r3 = r14.getEp()
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r14 = r14.getInfo()
                java.lang.String r4 = "out"
                java.lang.String r15 = f0.a.h(r13, r4)
                r18 = 16
                r19 = 0
                r17 = 0
                r22 = r13
                r13 = r3
                r3 = r22
                sf.c r6 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.xrayOutbound$default(r12, r13, r14, r15, r16, r17, r18, r19)
                r9.put(r6)
                sf.c r6 = new sf.c
                r6.<init>()
                java.lang.String r12 = "type"
                java.lang.String r13 = "field"
                r6.D(r12, r13)
                sf.a r12 = new sf.a
                r12.<init>()
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r5)
                r13.append(r3)
                java.lang.String r5 = r13.toString()
                r12.put(r5)
                java.lang.String r5 = "inboundTag"
                r6.D(r5, r12)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>(r4)
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                java.lang.String r4 = "outboundTag"
                r6.D(r4, r3)
                r10.put(r6)
                r12 = r16
                r13 = r20
                r4 = 10
                goto Lde
            L1a1:
                r21 = 0
                kotlin.collections.r.f0()
                throw r21
            L1a7:
                r21 = 0
                sf.c r4 = new sf.c
                r4.<init>()
                java.lang.String r5 = "block"
                r4.D(r3, r5)
                java.lang.String r3 = "blackhole"
                r4.D(r15, r3)
                r9.put(r4)
                sf.c r3 = new sf.c
                r3.<init>()
                sf.c r4 = new sf.c
                r4.<init>()
                java.lang.String r5 = "loglevel"
                java.lang.String r6 = "none"
                r4.D(r5, r6)
                java.lang.String r5 = "log"
                r3.D(r5, r4)
                java.lang.String r4 = "inbounds"
                r3.D(r4, r7)
                java.lang.String r4 = "outbounds"
                r3.D(r4, r9)
                sf.c r4 = new sf.c
                r4.<init>()
                java.lang.String r5 = "domainStrategy"
                java.lang.String r6 = "AsIs"
                r4.D(r5, r6)
                java.lang.String r5 = "rules"
                r4.D(r5, r10)
                java.lang.String r5 = "toString(...)"
                java.lang.String r6 = "routing"
                java.lang.String r3 = com.mlmvpn.scanner.e.h(r3, r6, r4, r5)
                com.mlmvpn.core.warp.VlessXrayInjector r9 = new com.mlmvpn.core.warp.VlessXrayInjector
                r13 = 2
                r14 = 0
                r10 = 0
                r11 = 0
                r12 = 1
                r9.<init>(r10, r11, r12, r13, r14)
                android.content.Context r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getApp$p()     // Catch: java.lang.Throwable -> L38d
                if (r4 == 0) goto L390
                r1.L$0 = r0     // Catch: java.lang.Throwable -> L38d
                r1.L$1 = r8     // Catch: java.lang.Throwable -> L38d
                r1.L$2 = r9     // Catch: java.lang.Throwable -> L38d
                r5 = 1
                r1.label = r5     // Catch: java.lang.Throwable -> L38d
                r15 = 0
                java.lang.Object r3 = r9.start(r4, r3, r15, r1)     // Catch: java.lang.Throwable -> L38d
                if (r3 != r2) goto L216
                goto L3b8
            L216:
                r7 = r8
                r8 = r0
                r0 = r7
                r7 = r9
            L21a:
                java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L4b
                boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L4b
                if (r3 != 0) goto L270
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r0 = r1.$batch     // Catch: java.lang.Throwable -> L4b
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4b
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4b
                r4 = 10
                int r4 = kotlin.collections.s.g0(r0, r4)     // Catch: java.lang.Throwable -> L4b
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L4b
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L4b
            L235:
                boolean r4 = r0.hasNext()     // Catch: java.lang.Throwable -> L4b
                if (r4 == 0) goto L24f
                java.lang.Object r4 = r0.next()     // Catch: java.lang.Throwable -> L4b
                com.mlmvpn.scanner.engines.argo.ArgoPool$Ready r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Ready) r4     // Catch: java.lang.Throwable -> L4b
                com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r8 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Trace     // Catch: java.lang.Throwable -> L4b
                r12 = 6
                r13 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r8.<init>(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L4b
                r3.add(r8)     // Catch: java.lang.Throwable -> L4b
                goto L235
            L24f:
                kotlinx.coroutines.m2 r0 = kotlinx.coroutines.m2.f24144a
                oe.e r4 = kotlinx.coroutines.v0.f24208c
                wd.i r0 = r0.plus(r4)
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5 r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5
                r5 = r21
                r4.<init>(r7, r5)
                r1.L$0 = r3
                r1.L$1 = r5
                r1.L$2 = r5
                r5 = 2
                r1.label = r5
                java.lang.Object r0 = kotlinx.coroutines.m0.J(r0, r4, r1)
                if (r0 != r2) goto L26f
                goto L3b8
            L26f:
                return r3
            L270:
                com.mlmvpn.scanner.engines.argo.ArgoPool r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4b
                r15 = 0
                java.lang.Object r4 = r0.get(r15)     // Catch: java.lang.Throwable -> L4b
                java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Throwable -> L4b
                int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L4b
                r1.L$0 = r8     // Catch: java.lang.Throwable -> L4b
                r1.L$1 = r0     // Catch: java.lang.Throwable -> L4b
                r1.L$2 = r7     // Catch: java.lang.Throwable -> L4b
                r5 = 3
                r1.label = r5     // Catch: java.lang.Throwable -> L4b
                r5 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$waitPort(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L4b
                if (r3 != r2) goto L78
                goto L3b8
            L290:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r4 = r1.$batch     // Catch: java.lang.Throwable -> L31
                java.util.Collection r4 = (java.util.Collection) r4     // Catch: java.lang.Throwable -> L31
                je.h r4 = kotlin.collections.r.Y(r4)     // Catch: java.lang.Throwable -> L31
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L31
                r6 = 10
                int r7 = kotlin.collections.s.g0(r4, r6)     // Catch: java.lang.Throwable -> L31
                r5.<init>(r7)     // Catch: java.lang.Throwable -> L31
                je.g r4 = r4.a()     // Catch: java.lang.Throwable -> L31
            L2a7:
                boolean r6 = r4.f23130c     // Catch: java.lang.Throwable -> L31
                if (r6 == 0) goto L2c0
                int r6 = r4.nextInt()     // Catch: java.lang.Throwable -> L31
                oe.e r7 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> L31
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$out$1$1 r9 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$out$1$1     // Catch: java.lang.Throwable -> L31
                r10 = 0
                r9.<init>(r0, r6, r10)     // Catch: java.lang.Throwable -> L31
                r6 = 2
                kotlinx.coroutines.q0 r7 = kotlinx.coroutines.m0.c(r8, r7, r9, r6)     // Catch: java.lang.Throwable -> L31
                r5.add(r7)     // Catch: java.lang.Throwable -> L31
                goto L2a7
            L2c0:
                r1.L$0 = r8     // Catch: java.lang.Throwable -> L31
                r1.L$1 = r0     // Catch: java.lang.Throwable -> L31
                r1.L$2 = r3     // Catch: java.lang.Throwable -> L31
                r4 = 4
                r1.label = r4     // Catch: java.lang.Throwable -> L31
                java.lang.Object r4 = kotlinx.coroutines.m0.d(r5, r1)     // Catch: java.lang.Throwable -> L31
                if (r4 != r2) goto L63
                goto L3b8
            L2d1:
                java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L31
                r0 = r4
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L31
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L31
                r6 = 10
                int r7 = kotlin.collections.s.g0(r0, r6)     // Catch: java.lang.Throwable -> L31
                r5.<init>(r7)     // Catch: java.lang.Throwable -> L31
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L31
                r6 = r15
            L2e6:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L31
                if (r7 == 0) goto L30e
                java.lang.Object r7 = r0.next()     // Catch: java.lang.Throwable -> L31
                int r10 = r6 + 1
                if (r6 < 0) goto L308
                com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Trace) r7     // Catch: java.lang.Throwable -> L31
                oe.e r11 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> L31
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$3$1 r12 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$3$1     // Catch: java.lang.Throwable -> L31
                r13 = 0
                r12.<init>(r7, r8, r6, r13)     // Catch: java.lang.Throwable -> L31
                r6 = 2
                kotlinx.coroutines.q0 r7 = kotlinx.coroutines.m0.c(r9, r11, r12, r6)     // Catch: java.lang.Throwable -> L31
                r5.add(r7)     // Catch: java.lang.Throwable -> L31
                r6 = r10
                goto L2e6
            L308:
                kotlin.collections.r.f0()     // Catch: java.lang.Throwable -> L31
                r21 = 0
                throw r21     // Catch: java.lang.Throwable -> L31
            L30e:
                r1.L$0 = r9     // Catch: java.lang.Throwable -> L31
                r1.L$1 = r8     // Catch: java.lang.Throwable -> L31
                r1.L$2 = r3     // Catch: java.lang.Throwable -> L31
                r1.L$3 = r4     // Catch: java.lang.Throwable -> L31
                r0 = 5
                r1.label = r0     // Catch: java.lang.Throwable -> L31
                java.lang.Object r0 = kotlinx.coroutines.m0.d(r5, r1)     // Catch: java.lang.Throwable -> L31
                if (r0 != r2) goto L321
                goto L3b8
            L321:
                r0 = r4
            L322:
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r4 = r1.$batch     // Catch: java.lang.Throwable -> L31
                java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L31
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L31
                r6 = 10
                int r6 = kotlin.collections.s.g0(r4, r6)     // Catch: java.lang.Throwable -> L31
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L31
                java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L31
            L335:
                boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L31
                if (r6 == 0) goto L35d
                java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L31
                int r7 = r15 + 1
                if (r15 < 0) goto L357
                com.mlmvpn.scanner.engines.argo.ArgoPool$Ready r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Ready) r6     // Catch: java.lang.Throwable -> L31
                oe.e r10 = kotlinx.coroutines.v0.f24208c     // Catch: java.lang.Throwable -> L31
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$4$1 r11 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$4$1     // Catch: java.lang.Throwable -> L31
                r13 = 0
                r11.<init>(r6, r8, r15, r13)     // Catch: java.lang.Throwable -> L31
                r6 = 2
                kotlinx.coroutines.q0 r10 = kotlinx.coroutines.m0.c(r9, r10, r11, r6)     // Catch: java.lang.Throwable -> L31
                r5.add(r10)     // Catch: java.lang.Throwable -> L31
                r15 = r7
                goto L335
            L357:
                kotlin.collections.r.f0()     // Catch: java.lang.Throwable -> L31
                r21 = 0
                throw r21     // Catch: java.lang.Throwable -> L31
            L35d:
                r1.L$0 = r3     // Catch: java.lang.Throwable -> L31
                r1.L$1 = r0     // Catch: java.lang.Throwable -> L31
                r13 = 0
                r1.L$2 = r13     // Catch: java.lang.Throwable -> L31
                r1.L$3 = r13     // Catch: java.lang.Throwable -> L31
                r4 = 6
                r1.label = r4     // Catch: java.lang.Throwable -> L31
                java.lang.Object r4 = kotlinx.coroutines.m0.d(r5, r1)     // Catch: java.lang.Throwable -> L31
                if (r4 != r2) goto L370
                goto L3b8
            L370:
                kotlinx.coroutines.m2 r4 = kotlinx.coroutines.m2.f24144a
                oe.e r5 = kotlinx.coroutines.v0.f24208c
                wd.i r4 = r4.plus(r5)
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5 r5 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5
                r13 = 0
                r5.<init>(r3, r13)
                r1.L$0 = r0
                r1.L$1 = r13
                r3 = 7
                r1.label = r3
                java.lang.Object r3 = kotlinx.coroutines.m0.J(r4, r5, r1)
                if (r3 != r2) goto L38c
                goto L3b8
            L38c:
                return r0
            L38d:
                r0 = move-exception
                r3 = r9
                goto L398
            L390:
                java.lang.String r0 = "app"
                kotlin.jvm.internal.j.k(r0)     // Catch: java.lang.Throwable -> L38d
                r21 = 0
                throw r21     // Catch: java.lang.Throwable -> L38d
            L398:
                kotlinx.coroutines.m2 r4 = kotlinx.coroutines.m2.f24144a
                oe.e r5 = kotlinx.coroutines.v0.f24208c
                wd.i r4 = r4.plus(r5)
                com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5 r5 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5
                r13 = 0
                r5.<init>(r3, r13)
                r1.L$0 = r0
                r1.L$1 = r13
                r1.L$2 = r13
                r1.L$3 = r13
                r3 = 8
                r1.label = r3
                java.lang.Object r3 = kotlinx.coroutines.m0.J(r4, r5, r1)
                if (r3 != r2) goto L3b9
            L3b8:
                return r2
            L3b9:
                throw r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1", f = "ArgoPool.kt", l = {198}, m = "invokeSuspend")
    public static final class C03981 extends xd.j implements ee.e {
        int label;

        public C03981(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C03981) r1
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
                goto L23
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L15:
                sd.m.b(r4)
                r3.label = r2
                r1 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r4 = kotlinx.coroutines.m0.j(r1, r3)
                if (r4 != r0) goto L23
                return r0
            L23:
                r4 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setSaveQueued$p(r4)
                com.mlmvpn.scanner.engines.argo.ArgoPool r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                r4.saveNow()
                sd.u r4 = sd.u.f67154a
                return r4
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1", f = "ArgoPool.kt", l = {746, 766, 776}, m = "invokeSuspend")
    public static final class C03991 extends xd.j implements ee.e {
        final /* synthetic */ int $count;
        final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> $refs;
        final /* synthetic */ boolean $v6;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        int label;

        public C03991(int r1, boolean r2, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> r3, wd.d r4) {
                r0 = this;
                r0.$count = r1
                r0.$v6 = r2
                r0.$refs = r3
                r1 = 2
                r0.<init>(r1, r4)
                return
        }

        public static /* synthetic */ boolean d(java.lang.String r0) {
                boolean r0 = invokeSuspend$lambda$2(r0)
                return r0
        }

        private static final boolean invokeSuspend$lambda$2(java.lang.String r1) {
                r0 = 58
                boolean r1 = kotlin.text.o.z0(r1, r0)
                return r1
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r5, wd.d r6) {
                r4 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1
                int r1 = r4.$count
                boolean r2 = r4.$v6
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r3 = r4.$refs
                r0.<init>(r1, r2, r3, r6)
                r0.L$0 = r5
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C03991) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r38) {
                r37 = this;
                r1 = r37
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r2 = r1.label
                r4 = 10
                r5 = 3
                r6 = 2
                r7 = 1
                r9 = 0
                if (r2 == 0) goto L89
                if (r2 == r7) goto L75
                if (r2 == r6) goto L5a
                if (r2 != r5) goto L52
                long r10 = r1.J$0
                int r2 = r1.I$1
                int r12 = r1.I$0
                java.lang.Object r13 = r1.L$7
                java.lang.String r13 = (java.lang.String) r13
                java.lang.Object r14 = r1.L$6
                java.util.Iterator r14 = (java.util.Iterator) r14
                java.lang.Object r15 = r1.L$5
                java.util.List r15 = (java.util.List) r15
                java.lang.Object r3 = r1.L$4
                java.util.List r3 = (java.util.List) r3
                java.lang.Object r6 = r1.L$3
                java.util.Map r6 = (java.util.Map) r6
                java.lang.Object r8 = r1.L$2
                java.util.List r8 = (java.util.List) r8
                java.lang.Object r7 = r1.L$1
                ee.c r7 = (ee.c) r7
                r20 = r5
                java.lang.Object r5 = r1.L$0
                java.util.List r5 = (java.util.List) r5
                sd.m.b(r38)     // Catch: java.lang.Throwable -> L4e
                r4 = r0
                r9 = r8
                r28 = r10
                r0 = r38
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r3
                r3 = r2
                r2 = r20
                goto L3ae
            L4e:
                r0 = move-exception
                r5 = r9
                goto L5c5
            L52:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L5a:
                r20 = r5
                java.lang.Object r2 = r1.L$4
                java.util.Map r2 = (java.util.Map) r2
                java.lang.Object r3 = r1.L$3
                java.util.List r3 = (java.util.List) r3
                java.lang.Object r5 = r1.L$2
                java.util.List r5 = (java.util.List) r5
                java.lang.Object r6 = r1.L$1
                ee.c r6 = (ee.c) r6
                java.lang.Object r7 = r1.L$0
                java.util.List r7 = (java.util.List) r7
                sd.m.b(r38)     // Catch: java.lang.Throwable -> L4e
                goto L28e
            L75:
                r20 = r5
                java.lang.Object r2 = r1.L$2
                kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
                java.lang.Object r3 = r1.L$1
                java.util.List r3 = (java.util.List) r3
                java.lang.Object r5 = r1.L$0
                kotlinx.coroutines.i0 r5 = (kotlinx.coroutines.i0) r5
                sd.m.b(r38)     // Catch: java.lang.Throwable -> L4e
                r7 = r3
                goto L159
            L89:
                r20 = r5
                sd.m.b(r38)
                java.lang.Object r2 = r1.L$0
                r5 = r2
                kotlinx.coroutines.i0 r5 = (kotlinx.coroutines.i0) r5
                com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4e
                int r3 = r1.$count     // Catch: java.lang.Throwable -> L4e
                r6 = 50
                r7 = 3000(0xbb8, float:4.204E-42)
                int r3 = com.google.android.gms.internal.mlkit_language_id_common.j.d(r3, r6, r7)     // Catch: java.lang.Throwable -> L4e
                java.util.List r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$sampleV4(r2, r3)     // Catch: java.lang.Throwable -> L4e
                boolean r6 = r1.$v6     // Catch: java.lang.Throwable -> L4e
                if (r6 == 0) goto Lc0
                boolean r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$hasGlobalV6(r2)     // Catch: java.lang.Throwable -> L4e
                if (r6 == 0) goto Lc0
                r6 = r3
                java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Throwable -> L4e
                int r3 = r3.size()     // Catch: java.lang.Throwable -> L4e
                int r3 = r3 / 3
                java.util.List r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$sampleV6(r2, r3)     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r3 = kotlin.collections.q.S0(r6, r3)     // Catch: java.lang.Throwable -> L4e
            Lc0:
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r21 = r2.getIpScan()     // Catch: java.lang.Throwable -> L4e
                if (r21 == 0) goto Le3
                int r25 = r3.size()     // Catch: java.lang.Throwable -> L4e
                r32 = 503(0x1f7, float:7.05E-43)
                r33 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33)     // Catch: java.lang.Throwable -> L4e
                goto Le4
            Le3:
                r2 = r9
            Le4:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r2)     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r2.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.List r26 = java.util.Collections.synchronizedList(r2)     // Catch: java.lang.Throwable -> L4e
                int r2 = kotlinx.coroutines.sync.m.f24188a     // Catch: java.lang.Throwable -> L4e
                kotlinx.coroutines.sync.l r2 = new kotlinx.coroutines.sync.l     // Catch: java.lang.Throwable -> L4e
                r6 = 32
                r2.<init>(r6)     // Catch: java.lang.Throwable -> L4e
                kotlin.jvm.internal.w r25 = new kotlin.jvm.internal.w     // Catch: java.lang.Throwable -> L4e
                r25.<init>()     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r6 = r1.$refs     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                int r8 = kotlin.collections.s.g0(r3, r4)     // Catch: java.lang.Throwable -> L4e
                r7.<init>(r8)     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
            L10f:
                boolean r8 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r8 == 0) goto L142
                java.lang.Object r8 = r3.next()     // Catch: java.lang.Throwable -> L4e
                r23 = r8
                java.lang.String r23 = (java.lang.String) r23     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$1$1 r21 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$1$1     // Catch: java.lang.Throwable -> L4e
                r27 = 0
                r22 = r2
                r24 = r6
                r21.<init>(r22, r23, r24, r25, r26, r27)     // Catch: java.lang.Throwable -> L4e
                r8 = r21
                r2 = r25
                r6 = r26
                r10 = r20
                kotlinx.coroutines.q0 r8 = kotlinx.coroutines.m0.c(r5, r9, r8, r10)     // Catch: java.lang.Throwable -> L4e
                r7.add(r8)     // Catch: java.lang.Throwable -> L4e
                r25 = r2
                r26 = r6
                r2 = r22
                r6 = r24
                r20 = 3
                goto L10f
            L142:
                r2 = r25
                r6 = r26
                r1.L$0 = r5     // Catch: java.lang.Throwable -> L4e
                r1.L$1 = r6     // Catch: java.lang.Throwable -> L4e
                r1.L$2 = r2     // Catch: java.lang.Throwable -> L4e
                r3 = 1
                r1.label = r3     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r3 = kotlinx.coroutines.m0.d(r7, r1)     // Catch: java.lang.Throwable -> L4e
                if (r3 != r0) goto L158
            L155:
                r4 = r0
                goto L3a4
            L158:
                r7 = r6
            L159:
                kotlin.jvm.internal.j.b(r7)     // Catch: java.lang.Throwable -> L4e
                r3 = r7
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$1 r6 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$1     // Catch: java.lang.Throwable -> L4e
                r6.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.List r3 = kotlin.collections.q.b1(r3, r6)     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.d r6 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L4e
                r8 = 0
                r6.<init>(r8)     // Catch: java.lang.Throwable -> L4e
                r8 = r3
                java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r10.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L4e
            L17a:
                boolean r11 = r8.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r11 == 0) goto L19b
                java.lang.Object r11 = r8.next()     // Catch: java.lang.Throwable -> L4e
                r12 = r11
                sd.j r12 = (sd.j) r12     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r12.getFirst()     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r6.invoke(r12)     // Catch: java.lang.Throwable -> L4e
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L4e
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L4e
                if (r12 != 0) goto L17a
                r10.add(r11)     // Catch: java.lang.Throwable -> L4e
                goto L17a
            L19b:
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r8.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
            L1a6:
                boolean r11 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r11 == 0) goto L1c7
                java.lang.Object r11 = r3.next()     // Catch: java.lang.Throwable -> L4e
                r12 = r11
                sd.j r12 = (sd.j) r12     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r12.getFirst()     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r6.invoke(r12)     // Catch: java.lang.Throwable -> L4e
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L4e
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L4e
                if (r12 == 0) goto L1a6
                r8.add(r11)     // Catch: java.lang.Throwable -> L4e
                goto L1a6
            L1c7:
                boolean r3 = r8.isEmpty()     // Catch: java.lang.Throwable -> L4e
                r11 = 24
                if (r3 != 0) goto L1d2
                r3 = 12
                goto L1d3
            L1d2:
                r3 = r11
            L1d3:
                java.util.List r12 = kotlin.collections.q.e1(r10, r3)     // Catch: java.lang.Throwable -> L4e
                java.util.Collection r12 = (java.util.Collection) r12     // Catch: java.lang.Throwable -> L4e
                int r10 = r10.size()     // Catch: java.lang.Throwable -> L4e
                int r3 = java.lang.Math.min(r3, r10)     // Catch: java.lang.Throwable -> L4e
                int r11 = r11 - r3
                java.util.List r3 = kotlin.collections.q.e1(r8, r11)     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r3 = kotlin.collections.q.S0(r12, r3)     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool r10 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r21 = r10.getIpScan()     // Catch: java.lang.Throwable -> L4e
                if (r21 == 0) goto L211
                java.lang.String r23 = "auth"
                int r25 = r3.size()     // Catch: java.lang.Throwable -> L4e
                r32 = 497(0x1f1, float:6.96E-43)
                r33 = 0
                r22 = 0
                r24 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r11 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33)     // Catch: java.lang.Throwable -> L4e
                goto L212
            L211:
                r11 = r9
            L212:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r11)     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r10)     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r10.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.List r25 = java.util.Collections.synchronizedList(r10)     // Catch: java.lang.Throwable -> L4e
                java.util.Map r10 = kotlin.collections.d0.S(r3)     // Catch: java.lang.Throwable -> L4e
                r11 = 0
                r2.element = r11     // Catch: java.lang.Throwable -> L4e
                int r11 = kotlinx.coroutines.sync.m.f24188a     // Catch: java.lang.Throwable -> L4e
                kotlinx.coroutines.sync.l r11 = new kotlinx.coroutines.sync.l     // Catch: java.lang.Throwable -> L4e
                r12 = 6
                r11.<init>(r12)     // Catch: java.lang.Throwable -> L4e
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r12 = r1.$refs     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r13 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                int r14 = kotlin.collections.s.g0(r3, r4)     // Catch: java.lang.Throwable -> L4e
                r13.<init>(r14)     // Catch: java.lang.Throwable -> L4e
                int r14 = r3.size()     // Catch: java.lang.Throwable -> L4e
                r15 = 0
            L240:
                if (r15 >= r14) goto L274
                java.lang.Object r21 = r3.get(r15)     // Catch: java.lang.Throwable -> L4e
                int r15 = r15 + 1
                sd.j r21 = (sd.j) r21     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r21 = r21.component1()     // Catch: java.lang.Throwable -> L4e
                r24 = r21
                java.lang.String r24 = (java.lang.String) r24     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$2$1 r21 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$2$1     // Catch: java.lang.Throwable -> L4e
                r27 = 0
                r26 = r2
                r22 = r11
                r23 = r12
                r21.<init>(r22, r23, r24, r25, r26, r27)     // Catch: java.lang.Throwable -> L4e
                r11 = r21
                r2 = r25
                r12 = 3
                kotlinx.coroutines.q0 r11 = kotlinx.coroutines.m0.c(r5, r9, r11, r12)     // Catch: java.lang.Throwable -> L4e
                r13.add(r11)     // Catch: java.lang.Throwable -> L4e
                r25 = r2
                r11 = r22
                r12 = r23
                r2 = r26
                goto L240
            L274:
                r2 = r25
                r1.L$0 = r7     // Catch: java.lang.Throwable -> L4e
                r1.L$1 = r6     // Catch: java.lang.Throwable -> L4e
                r1.L$2 = r8     // Catch: java.lang.Throwable -> L4e
                r1.L$3 = r2     // Catch: java.lang.Throwable -> L4e
                r1.L$4 = r10     // Catch: java.lang.Throwable -> L4e
                r3 = 2
                r1.label = r3     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r3 = kotlinx.coroutines.m0.d(r13, r1)     // Catch: java.lang.Throwable -> L4e
                if (r3 != r0) goto L28b
                goto L155
            L28b:
                r3 = r2
                r5 = r8
                r2 = r10
            L28e:
                kotlin.jvm.internal.j.b(r3)     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$2 r8 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$2     // Catch: java.lang.Throwable -> L4e
                r8.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.List r3 = kotlin.collections.q.b1(r3, r8)     // Catch: java.lang.Throwable -> L4e
                r8 = r3
                java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r10.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L4e
            L2a8:
                boolean r11 = r8.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r11 == 0) goto L2c9
                java.lang.Object r11 = r8.next()     // Catch: java.lang.Throwable -> L4e
                r12 = r11
                sd.q r12 = (sd.q) r12     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r12.getFirst()     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r12 = r6.invoke(r12)     // Catch: java.lang.Throwable -> L4e
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L4e
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L4e
                if (r12 != 0) goto L2a8
                r10.add(r11)     // Catch: java.lang.Throwable -> L4e
                goto L2a8
            L2c9:
                r8 = 4
                java.util.List r10 = kotlin.collections.q.e1(r10, r8)     // Catch: java.lang.Throwable -> L4e
                java.util.Collection r10 = (java.util.Collection) r10     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r11.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
            L2db:
                boolean r12 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r12 == 0) goto L2fc
                java.lang.Object r12 = r3.next()     // Catch: java.lang.Throwable -> L4e
                r13 = r12
                sd.q r13 = (sd.q) r13     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r13 = r13.getFirst()     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r13 = r6.invoke(r13)     // Catch: java.lang.Throwable -> L4e
                java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Throwable -> L4e
                boolean r13 = r13.booleanValue()     // Catch: java.lang.Throwable -> L4e
                if (r13 == 0) goto L2db
                r11.add(r12)     // Catch: java.lang.Throwable -> L4e
                goto L2db
            L2fc:
                java.util.List r3 = kotlin.collections.q.e1(r11, r8)     // Catch: java.lang.Throwable -> L4e
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r3 = kotlin.collections.q.S0(r10, r3)     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r21 = r8.getIpScan()     // Catch: java.lang.Throwable -> L4e
                if (r21 == 0) goto L32b
                java.lang.String r23 = "speed"
                int r25 = r3.size()     // Catch: java.lang.Throwable -> L4e
                r32 = 497(0x1f1, float:6.96E-43)
                r33 = 0
                r22 = 0
                r24 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r10 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33)     // Catch: java.lang.Throwable -> L4e
                goto L32c
            L32b:
                r10 = r9
            L32c:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r10)     // Catch: java.lang.Throwable -> L4e
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r8)     // Catch: java.lang.Throwable -> L4e
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4e
                r8.<init>()     // Catch: java.lang.Throwable -> L4e
                java.util.Iterator r10 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
                r15 = r8
                r14 = r10
                r8 = r5
                r5 = r7
                r7 = r6
                r6 = r2
                r2 = 0
            L342:
                boolean r10 = r14.hasNext()     // Catch: java.lang.Throwable -> L4e
                if (r10 == 0) goto L422
                int r12 = r2 + 1
                java.lang.Object r10 = r14.next()     // Catch: java.lang.Throwable -> L3c3
                sd.q r10 = (sd.q) r10     // Catch: java.lang.Throwable -> L3c3
                boolean r11 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getScanCancel$p()     // Catch: java.lang.Throwable -> L3c3
                if (r11 != 0) goto L422
                java.lang.Object r11 = r10.component1()     // Catch: java.lang.Throwable -> L3c3
                r13 = r11
                java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r11 = r10.component2()     // Catch: java.lang.Throwable -> L3c3
                java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> L3c3
                r38 = r10
                long r9 = r11.longValue()     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r11 = r38.component3()     // Catch: java.lang.Throwable -> L3c3
                sd.j r11 = (sd.j) r11     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r22 = r11.component1()     // Catch: java.lang.Throwable -> L3c3
                r4 = r22
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r4     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r11 = r11.component2()     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r11 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo) r11     // Catch: java.lang.Throwable -> L3c3
                r22 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L3c3
                r1.L$0 = r5     // Catch: java.lang.Throwable -> L3c3
                r1.L$1 = r7     // Catch: java.lang.Throwable -> L3c3
                r1.L$2 = r8     // Catch: java.lang.Throwable -> L3c3
                r1.L$3 = r6     // Catch: java.lang.Throwable -> L3c3
                r1.L$4 = r3     // Catch: java.lang.Throwable -> L3c3
                r1.L$5 = r15     // Catch: java.lang.Throwable -> L3c3
                r1.L$6 = r14     // Catch: java.lang.Throwable -> L3c3
                r1.L$7 = r13     // Catch: java.lang.Throwable -> L3c3
                r1.I$0 = r12     // Catch: java.lang.Throwable -> L3c3
                r1.I$1 = r2     // Catch: java.lang.Throwable -> L3c3
                r1.J$0 = r9     // Catch: java.lang.Throwable -> L3c3
                r38 = r2
                r2 = 3
                r1.label = r2     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$speedThrough(r0, r13, r4, r11, r1)     // Catch: java.lang.Throwable -> L3c3
                r4 = r22
                if (r0 != r4) goto L3a5
            L3a4:
                return r4
            L3a5:
                r28 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r3
                r3 = r38
            L3ae:
                java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L3de
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r24 = new com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r10 = r7.get(r13)     // Catch: java.lang.Throwable -> L3c3
                java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Throwable -> L3c3
                if (r10 == 0) goto L3c7
                long r10 = r10.longValue()     // Catch: java.lang.Throwable -> L3c3
            L3c0:
                r26 = r10
                goto L3ca
            L3c3:
                r0 = move-exception
                r5 = 0
                goto L5c5
            L3c7:
                r10 = 0
                goto L3c0
            L3ca:
                long r30 = r0.longValue()     // Catch: java.lang.Throwable -> L3c3
                r33 = 16
                r34 = 0
                r32 = 0
                r25 = r13
                r24.<init>(r25, r26, r28, r30, r32, r33, r34)     // Catch: java.lang.Throwable -> L3c3
                r0 = r24
                r15.add(r0)     // Catch: java.lang.Throwable -> L3c3
            L3de:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r24 = r0.getIpScan()     // Catch: java.lang.Throwable -> L3c3
                if (r24 == 0) goto L40d
                r19 = 1
                int r27 = r3 + 1
                r3 = r15
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$1 r10 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$1     // Catch: java.lang.Throwable -> L3c3
                r10.<init>()     // Catch: java.lang.Throwable -> L3c3
                java.util.List r29 = kotlin.collections.q.b1(r3, r10)     // Catch: java.lang.Throwable -> L3c3
                r35 = 491(0x1eb, float:6.88E-43)
                r36 = 0
                r25 = 0
                r26 = 0
                r28 = 0
                r30 = 0
                r31 = 0
                r32 = 0
                r33 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r36)     // Catch: java.lang.Throwable -> L3c3
                goto L410
            L40d:
                r19 = 1
                r3 = 0
            L410:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r3)     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r0)     // Catch: java.lang.Throwable -> L3c3
                r0 = r4
                r3 = r5
                r5 = r6
                r6 = r7
                r7 = r8
                r8 = r9
                r2 = r12
                r4 = 10
                r9 = 0
                goto L342
            L422:
                r19 = 1
                java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$2     // Catch: java.lang.Throwable -> L3c3
                r0.<init>()     // Catch: java.lang.Throwable -> L3c3
                java.util.List r29 = kotlin.collections.q.b1(r15, r0)     // Catch: java.lang.Throwable -> L3c3
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L3c3
                boolean r0 = r3 instanceof java.util.Collection     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L43f
                r0 = r3
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L3c3
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L43f
                goto L495
            L43f:
                java.util.Iterator r0 = r3.iterator()     // Catch: java.lang.Throwable -> L3c3
            L443:
                boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L3c3
                if (r2 == 0) goto L495
                java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L3c3
                sd.q r2 = (sd.q) r2     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r2 = r2.getFirst()     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r2 = r7.invoke(r2)     // Catch: java.lang.Throwable -> L3c3
                java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L3c3
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L3c3
                if (r2 != 0) goto L443
                r0 = r29
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L3c3
                boolean r2 = r0 instanceof java.util.Collection     // Catch: java.lang.Throwable -> L3c3
                if (r2 == 0) goto L471
                r2 = r0
                java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L3c3
                boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r2 == 0) goto L471
                goto L492
            L471:
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L3c3
            L475:
                boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L3c3
                if (r2 == 0) goto L492
                java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L3c3
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp) r2     // Catch: java.lang.Throwable -> L3c3
                java.lang.String r2 = r2.getIp()     // Catch: java.lang.Throwable -> L3c3
                java.lang.Object r2 = r7.invoke(r2)     // Catch: java.lang.Throwable -> L3c3
                java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L3c3
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L3c3
                if (r2 != 0) goto L475
                goto L495
            L492:
                r7 = r19
                goto L496
            L495:
                r7 = 0
            L496:
                if (r7 == 0) goto L4a7
                r0 = r29
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L3c3
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r0 != 0) goto L4a7
                java.lang.String r0 = "روی این اینترنت لبهٔ IPv4 کلادفلر وسط دانلود قطع می\u200cشود؛ فقط IPv6 داده رد می\u200cکند."
            L4a4:
                r32 = r0
                goto L4aa
            L4a7:
                java.lang.String r0 = ""
                goto L4a4
            L4aa:
                boolean r0 = r29.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L4cf
                boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getScanCancel$p()     // Catch: java.lang.Throwable -> L3c3
                if (r0 != 0) goto L4cf
                boolean r0 = r5.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L4c1
                java.lang.String r0 = "هیچ آی\u200cپی کلادفلری از این اینترنت جواب نداد"
            L4be:
                r31 = r0
                goto L4d2
            L4c1:
                if (r7 == 0) goto L4cc
                boolean r0 = r8.isEmpty()     // Catch: java.lang.Throwable -> L3c3
                if (r0 == 0) goto L4cc
                java.lang.String r0 = "آی\u200cپی\u200cهای IPv4 جواب دادند ولی وسط دانلود قطع شدند، و این سیستم IPv6 ندارد — روی این اینترنت فعلاً راهی از کلادفلر نیست"
                goto L4be
            L4cc:
                java.lang.String r0 = "آی\u200cپی\u200cهایی جواب دادند ولی هیچ\u200cکدام داده رد نکرد — دوباره با تعداد بیشتر امتحان کنید"
                goto L4be
            L4cf:
                java.lang.String r0 = ""
                goto L4be
            L4d2:
                com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L3c3
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = r1.$refs     // Catch: java.lang.Throwable -> L3c3
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L3c3
                sf.c r3 = new sf.c     // Catch: java.lang.Throwable -> L55b
                r3.<init>()     // Catch: java.lang.Throwable -> L55b
                java.lang.String r4 = "at"
                long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L55b
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L55b
                r3.D(r4, r5)     // Catch: java.lang.Throwable -> L55b
                java.lang.String r4 = "ref"
                r8 = 0
                java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Throwable -> L55b
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L55b
                java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L55b
                r3.D(r4, r0)     // Catch: java.lang.Throwable -> L55b
                java.lang.String r0 = "list"
                r4 = r29
                java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L55b
                r5 = 12
                java.util.List r4 = kotlin.collections.q.e1(r4, r5)     // Catch: java.lang.Throwable -> L55b
                java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L55b
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L55b
                r6 = 10
                int r6 = kotlin.collections.s.g0(r4, r6)     // Catch: java.lang.Throwable -> L55b
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L55b
                java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L55b
            L516:
                boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L55b
                if (r6 == 0) goto L55e
                java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L55b
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp) r6     // Catch: java.lang.Throwable -> L55b
                sf.c r7 = new sf.c     // Catch: java.lang.Throwable -> L55b
                r7.<init>()     // Catch: java.lang.Throwable -> L55b
                java.lang.String r8 = "ip"
                java.lang.String r9 = r6.getIp()     // Catch: java.lang.Throwable -> L55b
                r7.D(r8, r9)     // Catch: java.lang.Throwable -> L55b
                java.lang.String r8 = "tls"
                long r9 = r6.getTls()     // Catch: java.lang.Throwable -> L55b
                java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L55b
                r7.D(r8, r9)     // Catch: java.lang.Throwable -> L55b
                java.lang.String r8 = "auth"
                long r9 = r6.getAuth()     // Catch: java.lang.Throwable -> L55b
                java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L55b
                r7.D(r8, r9)     // Catch: java.lang.Throwable -> L55b
                java.lang.String r8 = "kbps"
                long r9 = r6.getKbps()     // Catch: java.lang.Throwable -> L55b
                java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L55b
                r7.D(r8, r6)     // Catch: java.lang.Throwable -> L55b
                r5.add(r7)     // Catch: java.lang.Throwable -> L55b
                goto L516
            L55b:
                r0 = move-exception
                r5 = 0
                goto L5c3
            L55e:
                sf.a r4 = new sf.a     // Catch: java.lang.Throwable -> L55b
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L55b
                r3.D(r0, r4)     // Catch: java.lang.Throwable -> L55b
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setCleanScan$p(r3)     // Catch: java.lang.Throwable -> L55b
                r0 = r29
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L55b
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L55b
                if (r0 != 0) goto L598
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getPrefs$p()     // Catch: java.lang.Throwable -> L55b
                boolean r0 = r0.getAutoClean()     // Catch: java.lang.Throwable -> L55b
                if (r0 == 0) goto L598
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getPrefs$p()     // Catch: java.lang.Throwable -> L55b
                java.lang.Object r3 = kotlin.collections.q.y0(r29)     // Catch: java.lang.Throwable -> L55b
                com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.CleanIp) r3     // Catch: java.lang.Throwable -> L55b
                java.lang.String r3 = r3.getIp()     // Catch: java.lang.Throwable -> L55b
                r4 = 2
                r5 = 0
                r8 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs.copy$default(r0, r3, r8, r4, r5)     // Catch: java.lang.Throwable -> L596
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setPrefs$p(r0)     // Catch: java.lang.Throwable -> L596
                goto L599
            L596:
                r0 = move-exception
                goto L5c3
            L598:
                r5 = 0
            L599:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L596
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$savePrefs(r0)     // Catch: java.lang.Throwable -> L596
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L5bc
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r24 = r0.getIpScan()     // Catch: java.lang.Throwable -> L5bc
                if (r24 == 0) goto L5be
                long r33 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5bc
                r35 = 46
                r36 = 0
                r25 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r30 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r36)     // Catch: java.lang.Throwable -> L5bc
                goto L5bf
            L5bc:
                r0 = move-exception
                goto L5c5
            L5be:
                r0 = r5
            L5bf:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r0)     // Catch: java.lang.Throwable -> L5bc
                goto L5ee
            L5c3:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L5bc
                throw r0     // Catch: java.lang.Throwable -> L5bc
            L5c5:
                com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r6 = r2.getIpScan()
                if (r6 == 0) goto L5ea
                java.lang.String r0 = r0.getMessage()
                if (r0 != 0) goto L5d5
                java.lang.String r0 = ""
            L5d5:
                r13 = r0
                long r15 = java.lang.System.currentTimeMillis()
                r17 = 190(0xbe, float:2.66E-43)
                r18 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r18)
                goto L5eb
            L5ea:
                r9 = r5
            L5eb:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setIpScan$p(r9)
            L5ee:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r0)
                sd.u r0 = sd.u.f67154a
                return r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2", f = "ArgoPool.kt", l = {596, 605, 597, 605, 605}, m = "invokeSuspend")
    public static final class C04002 extends xd.j implements ee.e {
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo $info;
        final /* synthetic */ java.lang.String $ip;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Item $ref;
        int I$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class C00532 extends xd.j implements ee.e {
            final /* synthetic */ com.mlmvpn.core.warp.VlessXrayInjector $core;
            private /* synthetic */ java.lang.Object L$0;
            int label;

            public C00532(com.mlmvpn.core.warp.VlessXrayInjector r1, wd.d r2) {
                    r0 = this;
                    r0.$core = r1
                    r1 = 2
                    r0.<init>(r1, r2)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r3, wd.d r4) {
                    r2 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2
                    com.mlmvpn.core.warp.VlessXrayInjector r1 = r2.$core
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
                    com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04002.C00532) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r2) {
                    r1 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r0 = r1.label
                    if (r0 != 0) goto L27
                    sd.m.b(r2)
                    java.lang.Object r2 = r1.L$0
                    kotlinx.coroutines.i0 r2 = (kotlinx.coroutines.i0) r2
                    com.mlmvpn.core.warp.VlessXrayInjector r2 = r1.$core
                    r2.stop()     // Catch: java.lang.Throwable -> L19
                    sd.u r2 = sd.u.f67154a     // Catch: java.lang.Throwable -> L19
                    java.lang.Object r2 = sd.l.m1004constructorimpl(r2)     // Catch: java.lang.Throwable -> L19
                    goto L22
                L19:
                    r2 = move-exception
                    sd.l$a r2 = sd.m.a(r2)
                    java.lang.Object r2 = sd.l.m1004constructorimpl(r2)
                L22:
                    sd.l r2 = sd.l.m1003boximpl(r2)
                    return r2
                L27:
                    java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r2.<init>(r0)
                    throw r2
            }
        }

        public C04002(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r1, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r2, java.lang.String r3, wd.d r4) {
                r0 = this;
                r0.$ref = r1
                r0.$info = r2
                r0.$ip = r3
                r1 = 2
                r0.<init>(r1, r4)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r5, wd.d r6) {
                r4 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r1 = r4.$ref
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r2 = r4.$info
                java.lang.String r3 = r4.$ip
                r0.<init>(r1, r2, r3, r6)
                r0.L$0 = r5
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04002) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
                r29 = this;
                r1 = r29
                kotlin.coroutines.intrinsics.a r2 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r1.label
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                r8 = 0
                if (r0 == 0) goto L69
                if (r0 == r7) goto L4d
                if (r0 == r6) goto L49
                if (r0 == r5) goto L31
                if (r0 == r4) goto L29
                if (r0 == r3) goto L20
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L20:
                java.lang.Object r0 = r1.L$0
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                sd.m.b(r30)
                goto L213
            L29:
                java.lang.Object r0 = r1.L$0
                java.lang.Long r0 = (java.lang.Long) r0
                sd.m.b(r30)
                return r0
            L31:
                int r0 = r1.I$0
                java.lang.Object r5 = r1.L$2
                com.mlmvpn.core.warp.VlessXrayInjector r5 = (com.mlmvpn.core.warp.VlessXrayInjector) r5
                java.lang.Object r6 = r1.L$1
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r6 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r6
                java.lang.Object r7 = r1.L$0
                kotlinx.coroutines.i0 r7 = (kotlinx.coroutines.i0) r7
                sd.m.b(r30)     // Catch: java.lang.Throwable -> L46
                r21 = r0
                goto L15a
            L46:
                r0 = move-exception
                goto L1fc
            L49:
                sd.m.b(r30)
                return r8
            L4d:
                int r0 = r1.I$0
                java.lang.Object r7 = r1.L$2
                com.mlmvpn.core.warp.VlessXrayInjector r7 = (com.mlmvpn.core.warp.VlessXrayInjector) r7
                java.lang.Object r9 = r1.L$1
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r9 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r9
                java.lang.Object r10 = r1.L$0
                kotlinx.coroutines.i0 r10 = (kotlinx.coroutines.i0) r10
                sd.m.b(r30)     // Catch: java.lang.Throwable -> L65
                r14 = r7
                r13 = r9
                r9 = r0
                r0 = r30
                goto L120
            L65:
                r0 = move-exception
                r5 = r7
                goto L1fc
            L69:
                sd.m.b(r30)
                java.lang.Object r0 = r1.L$0
                r10 = r0
                kotlinx.coroutines.i0 r10 = (kotlinx.coroutines.i0) r10
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                int r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$freePort(r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r11 = r1.$ref
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r13 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$endpointOf(r0, r11)
                sf.c r0 = new sf.c
                r0.<init>()
                sf.c r11 = new sf.c
                r11.<init>()
                java.lang.String r12 = "loglevel"
                java.lang.String r14 = "none"
                r11.D(r12, r14)
                java.lang.String r12 = "log"
                r0.D(r12, r11)
                sf.a r11 = new sf.a
                r11.<init>()
                java.lang.String r12 = "listen"
                java.lang.String r14 = "127.0.0.1"
                java.lang.String r15 = "tag"
                java.lang.String r3 = "in"
                sf.c r3 = com.mlmvpn.core.aether.i.p(r15, r3, r12, r14)
                java.lang.String r12 = "port"
                java.lang.Integer r14 = java.lang.Integer.valueOf(r9)
                r3.D(r12, r14)
                java.lang.String r12 = "protocol"
                java.lang.String r14 = "socks"
                r3.D(r12, r14)
                sf.c r12 = new sf.c
                r12.<init>()
                java.lang.String r14 = "udp"
                r15 = 0
                r12.E(r14, r15)
                java.lang.String r14 = "settings"
                r3.D(r14, r12)
                r11.put(r3)
                java.lang.String r3 = "inbounds"
                r0.D(r3, r11)
                sf.a r3 = new sf.a
                r3.<init>()
                com.mlmvpn.scanner.engines.argo.ArgoProtocol r12 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r14 = r1.$info
                java.lang.String r11 = r1.$ip
                r18 = 16
                r19 = 0
                r16 = r15
                java.lang.String r15 = "out"
                r17 = 0
                r28 = r16
                r16 = r11
                r11 = r28
                sf.c r12 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.xrayOutbound$default(r12, r13, r14, r15, r16, r17, r18, r19)
                r3.put(r12)
                java.lang.String r12 = "outbounds"
                r0.D(r12, r3)
                java.lang.String r0 = r0.toString()
                java.lang.String r3 = "toString(...)"
                kotlin.jvm.internal.j.d(r0, r3)
                com.mlmvpn.core.warp.VlessXrayInjector r14 = new com.mlmvpn.core.warp.VlessXrayInjector
                r18 = 2
                r15 = 0
                r16 = 0
                r17 = 1
                r14.<init>(r15, r16, r17, r18, r19)
                android.content.Context r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getApp$p()     // Catch: java.lang.Throwable -> L1f3
                if (r3 == 0) goto L1f6
                r1.L$0 = r10     // Catch: java.lang.Throwable -> L1f3
                r1.L$1 = r13     // Catch: java.lang.Throwable -> L1f3
                r1.L$2 = r14     // Catch: java.lang.Throwable -> L1f3
                r1.I$0 = r9     // Catch: java.lang.Throwable -> L1f3
                r1.label = r7     // Catch: java.lang.Throwable -> L1f3
                java.lang.Object r0 = r14.start(r3, r0, r11, r1)     // Catch: java.lang.Throwable -> L1f3
                if (r0 != r2) goto L120
                goto L212
            L120:
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L1f3
                boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L1f3
                if (r0 != 0) goto L140
                kotlinx.coroutines.m2 r0 = kotlinx.coroutines.m2.f24144a
                com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2 r3 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2
                r3.<init>(r14, r8)
                r1.L$0 = r8
                r1.L$1 = r8
                r1.L$2 = r8
                r1.label = r6
                java.lang.Object r0 = kotlinx.coroutines.m0.J(r0, r3, r1)
                if (r0 != r2) goto L13f
                goto L212
            L13f:
                return r8
            L140:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L1f3
                r1.L$0 = r10     // Catch: java.lang.Throwable -> L1f3
                r1.L$1 = r13     // Catch: java.lang.Throwable -> L1f3
                r1.L$2 = r14     // Catch: java.lang.Throwable -> L1f3
                r1.I$0 = r9     // Catch: java.lang.Throwable -> L1f3
                r1.label = r5     // Catch: java.lang.Throwable -> L1f3
                r5 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$waitPort(r0, r9, r5, r1)     // Catch: java.lang.Throwable -> L1f3
                if (r0 != r2) goto L156
                goto L212
            L156:
                r21 = r9
                r6 = r13
                r5 = r14
            L15a:
                long r9 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L46
                com.mlmvpn.scanner.engines.argo.ArgoPool r20 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L46
                java.lang.String r22 = "https://cachefly.cachefly.net/1mb.test"
                r25 = 20000(0x4e20, double:9.8813E-320)
                r27 = 0
                r23 = 1048576(0x100000, double:5.180654E-318)
                sd.j r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$download(r20, r21, r22, r23, r25, r27)     // Catch: java.lang.Throwable -> L46
                r7 = r20
                r3 = r21
                java.lang.Object r11 = r0.component1()     // Catch: java.lang.Throwable -> L46
                java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> L46
                int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L46
                java.lang.Object r0 = r0.component2()     // Catch: java.lang.Throwable -> L46
                java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L46
                long r12 = r0.longValue()     // Catch: java.lang.Throwable -> L46
                long r14 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L46
                long r14 = r14 - r9
                double r9 = (double) r14     // Catch: java.lang.Throwable -> L46
                r14 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
                double r9 = r9 / r14
                r14 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
                int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r0 >= 0) goto L19b
                r9 = r14
            L19b:
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r0 = r1.$info     // Catch: java.lang.Throwable -> L46
                com.mlmvpn.scanner.engines.argo.ArgoNet r20 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE     // Catch: java.lang.Throwable -> L1b9
                java.lang.String r21 = "disconnect"
                java.lang.String r22 = r6.getHost()     // Catch: java.lang.Throwable -> L1b9
                int r23 = r6.getPort()     // Catch: java.lang.Throwable -> L1b9
                java.net.Proxy r25 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$socks(r7, r3)     // Catch: java.lang.Throwable -> L1b9
                r26 = 6000(0x1770, double:2.9644E-320)
                r24 = r0
                sd.j r0 = r20.sessionRequest(r21, r22, r23, r24, r25, r26)     // Catch: java.lang.Throwable -> L1b9
                sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1b9
                goto L1c1
            L1b9:
                r0 = move-exception
                sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L46
                sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L46
            L1c1:
                r0 = 200(0xc8, float:2.8E-43)
                if (r11 != r0) goto L1db
                r6 = 500000(0x7a120, double:2.47033E-318)
                int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
                if (r0 < 0) goto L1db
                double r6 = (double) r12     // Catch: java.lang.Throwable -> L46
                r11 = 4652218415073722368(0x4090000000000000, double:1024.0)
                double r6 = r6 / r11
                double r6 = r6 / r9
                long r6 = java.lang.Math.round(r6)     // Catch: java.lang.Throwable -> L46
                java.lang.Long r0 = new java.lang.Long     // Catch: java.lang.Throwable -> L46
                r0.<init>(r6)     // Catch: java.lang.Throwable -> L46
                goto L1dc
            L1db:
                r0 = r8
            L1dc:
                kotlinx.coroutines.m2 r3 = kotlinx.coroutines.m2.f24144a
                com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2 r6 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2
                r6.<init>(r5, r8)
                r1.L$0 = r0
                r1.L$1 = r8
                r1.L$2 = r8
                r1.label = r4
                java.lang.Object r3 = kotlinx.coroutines.m0.J(r3, r6, r1)
                if (r3 != r2) goto L1f2
                goto L212
            L1f2:
                return r0
            L1f3:
                r0 = move-exception
                r5 = r14
                goto L1fc
            L1f6:
                java.lang.String r0 = "app"
                kotlin.jvm.internal.j.k(r0)     // Catch: java.lang.Throwable -> L1f3
                throw r8     // Catch: java.lang.Throwable -> L1f3
            L1fc:
                kotlinx.coroutines.m2 r3 = kotlinx.coroutines.m2.f24144a
                com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2 r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2
                r4.<init>(r5, r8)
                r1.L$0 = r0
                r1.L$1 = r8
                r1.L$2 = r8
                r5 = 5
                r1.label = r5
                java.lang.Object r3 = kotlinx.coroutines.m0.J(r3, r4, r1)
                if (r3 != r2) goto L213
            L212:
                return r2
            L213:
                throw r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool", f = "ArgoPool.kt", l = {292}, m = "telegramPageRetry")
    public static final class C04011 extends xd.c {
        int I$0;
        int I$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool this$0;

        public C04011(com.mlmvpn.scanner.engines.argo.ArgoPool r1, wd.d r2) {
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
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = r6.this$0
                r3 = 0
                r4 = 0
                r1 = 0
                r2 = 0
                r5 = r6
                java.lang.Object r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$telegramPageRetry(r0, r1, r2, r3, r4, r5)
                return r7
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$test$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1", f = "ArgoPool.kt", l = {660, 675}, m = "invokeSuspend")
    public static final class C04021 extends xd.j implements ee.e {
        final /* synthetic */ java.lang.String $connectIp;
        final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> $list;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class C00541 extends xd.j implements ee.e {
            final /* synthetic */ kotlinx.coroutines.i0 $$this$launch;
            final /* synthetic */ kotlin.jvm.internal.w $alive;
            final /* synthetic */ kotlinx.coroutines.sync.a $chain;
            final /* synthetic */ java.lang.String $connectIp;
            final /* synthetic */ kotlin.jvm.internal.w $done;
            final /* synthetic */ kotlin.jvm.internal.w $frozen;
            final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> $list;
            final /* synthetic */ java.util.concurrent.atomic.AtomicInteger $next;
            final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> $ready;
            private /* synthetic */ java.lang.Object L$0;
            int label;

            public C00541(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> r1, java.util.concurrent.atomic.AtomicInteger r2, java.lang.String r3, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> r4, kotlin.jvm.internal.w r5, kotlin.jvm.internal.w r6, kotlin.jvm.internal.w r7, kotlinx.coroutines.sync.a r8, kotlinx.coroutines.i0 r9, wd.d r10) {
                    r0 = this;
                    r0.$list = r1
                    r0.$next = r2
                    r0.$connectIp = r3
                    r0.$ready = r4
                    r0.$done = r5
                    r0.$alive = r6
                    r0.$frozen = r7
                    r0.$chain = r8
                    r0.$$this$launch = r9
                    r1 = 2
                    r0.<init>(r1, r10)
                    return
            }

            @Override // xd.a
            public final wd.d create(java.lang.Object r12, wd.d r13) {
                    r11 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1
                    java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r1 = r11.$list
                    java.util.concurrent.atomic.AtomicInteger r2 = r11.$next
                    java.lang.String r3 = r11.$connectIp
                    java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r4 = r11.$ready
                    kotlin.jvm.internal.w r5 = r11.$done
                    kotlin.jvm.internal.w r6 = r11.$alive
                    kotlin.jvm.internal.w r7 = r11.$frozen
                    kotlinx.coroutines.sync.a r8 = r11.$chain
                    kotlinx.coroutines.i0 r9 = r11.$$this$launch
                    r10 = r13
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                    r0.L$0 = r12
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
                    com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04021.C00541) r1
                    sd.u r2 = sd.u.f67154a
                    java.lang.Object r1 = r1.invokeSuspend(r2)
                    return r1
            }

            @Override // xd.a
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                    r13 = this;
                    kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                    int r0 = r13.label
                    if (r0 != 0) goto L36
                    sd.m.b(r14)
                    java.lang.Object r14 = r13.L$0
                    kotlinx.coroutines.i0 r14 = (kotlinx.coroutines.i0) r14
                    java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r1 = r13.$list
                    java.util.concurrent.atomic.AtomicInteger r2 = r13.$next
                    java.lang.String r3 = r13.$connectIp
                    java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Ready> r4 = r13.$ready
                    kotlin.jvm.internal.w r5 = r13.$done
                    kotlin.jvm.internal.w r6 = r13.$alive
                    kotlin.jvm.internal.w r7 = r13.$frozen
                    kotlinx.coroutines.sync.a r8 = r13.$chain
                    kotlinx.coroutines.i0 r9 = r13.$$this$launch
                    r0 = 0
                    r11 = r0
                L21:
                    r0 = 8
                    if (r11 >= r0) goto L33
                    com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1$1$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1$1$1
                    r10 = 0
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                    r10 = 3
                    r12 = 0
                    kotlinx.coroutines.m0.y(r14, r12, r12, r0, r10)
                    int r11 = r11 + 1
                    goto L21
                L33:
                    sd.u r14 = sd.u.f67154a
                    return r14
                L36:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r0)
                    throw r14
            }
        }

        public C04021(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> r1, java.lang.String r2, wd.d r3) {
                r0 = this;
                r0.$list = r1
                r0.$connectIp = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        public static final /* synthetic */ java.lang.Object access$invokeSuspend$flush(kotlinx.coroutines.sync.a r0, java.util.List r1, kotlinx.coroutines.i0 r2, java.lang.String r3, kotlin.jvm.internal.w r4, kotlin.jvm.internal.w r5, kotlin.jvm.internal.w r6, wd.d r7) {
                java.lang.Object r0 = invokeSuspend$flush(r0, r1, r2, r3, r4, r5, r6, r7)
                return r0
        }

        private static final java.lang.Object invokeSuspend$flush(kotlinx.coroutines.sync.a r23, java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> r24, kotlinx.coroutines.i0 r25, java.lang.String r26, kotlin.jvm.internal.w r27, kotlin.jvm.internal.w r28, kotlin.jvm.internal.w r29, wd.d r30) {
                r0 = r23
                r1 = r30
                boolean r2 = r1 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$flush$1
                if (r2 == 0) goto L17
                r2 = r1
                com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$flush$1 r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$flush$1) r2
                int r3 = r2.label
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = r3 & r4
                if (r5 == 0) goto L17
                int r3 = r3 - r4
                r2.label = r3
                goto L1c
            L17:
                com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$flush$1 r2 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$flush$1
                r2.<init>(r1)
            L1c:
                java.lang.Object r1 = r2.result
                kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r4 = r2.label
                r5 = 2
                r6 = 0
                r7 = 1
                r8 = 0
                if (r4 == 0) goto L76
                if (r4 == r7) goto L55
                if (r4 != r5) goto L4d
                java.lang.Object r0 = r2.L$4
                r3 = r0
                java.util.List r3 = (java.util.List) r3
                java.lang.Object r0 = r2.L$3
                r4 = r0
                kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r4
                java.lang.Object r0 = r2.L$2
                r5 = r0
                kotlin.jvm.internal.w r5 = (kotlin.jvm.internal.w) r5
                java.lang.Object r0 = r2.L$1
                r7 = r0
                kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
                java.lang.Object r0 = r2.L$0
                r2 = r0
                kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
                sd.m.b(r1)     // Catch: java.lang.Throwable -> L4a
                goto Leb
            L4a:
                r0 = move-exception
                goto Lf8
            L4d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L55:
                java.lang.Object r0 = r2.L$6
                kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
                java.lang.Object r4 = r2.L$5
                kotlin.jvm.internal.w r4 = (kotlin.jvm.internal.w) r4
                java.lang.Object r7 = r2.L$4
                kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
                java.lang.Object r9 = r2.L$3
                kotlin.jvm.internal.w r9 = (kotlin.jvm.internal.w) r9
                java.lang.Object r10 = r2.L$2
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r11 = r2.L$1
                kotlinx.coroutines.i0 r11 = (kotlinx.coroutines.i0) r11
                java.lang.Object r11 = r2.L$0
                java.util.List r11 = (java.util.List) r11
                sd.m.b(r1)
            L74:
                r1 = r0
                goto La3
            L76:
                sd.m.b(r1)
                r1 = r24
                r2.L$0 = r1
                r4 = r25
                r2.L$1 = r4
                r4 = r26
                r2.L$2 = r4
                r9 = r27
                r2.L$3 = r9
                r10 = r28
                r2.L$4 = r10
                r11 = r29
                r2.L$5 = r11
                r2.L$6 = r0
                r2.label = r7
                kotlinx.coroutines.sync.f r0 = (kotlinx.coroutines.sync.f) r0
                java.lang.Object r7 = r0.d(r2)
                if (r7 != r3) goto L9e
                goto Le5
            L9e:
                r7 = r10
                r10 = r4
                r4 = r11
                r11 = r1
                goto L74
            La3:
                kotlin.jvm.internal.j.b(r11)     // Catch: java.lang.Throwable -> L141
                monitor-enter(r11)     // Catch: java.lang.Throwable -> L141
                r0 = r11
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> Lc3
                r12 = 12
                java.util.List r0 = kotlin.collections.q.e1(r0, r12)     // Catch: java.lang.Throwable -> Lc3
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> Lc3
                java.util.List r12 = kotlin.collections.q.k1(r0)     // Catch: java.lang.Throwable -> Lc3
                int r0 = r12.size()     // Catch: java.lang.Throwable -> Lc3
                r13 = r6
            Lbb:
                if (r13 >= r0) goto Lc6
                r11.remove(r6)     // Catch: java.lang.Throwable -> Lc3
                int r13 = r13 + 1
                goto Lbb
            Lc3:
                r0 = move-exception
                goto L231
            Lc6:
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L141
                boolean r0 = r12.isEmpty()     // Catch: java.lang.Throwable -> L141
                if (r0 != 0) goto L229
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> Lf3
                r2.L$0 = r9     // Catch: java.lang.Throwable -> Lf3
                r2.L$1 = r7     // Catch: java.lang.Throwable -> Lf3
                r2.L$2 = r4     // Catch: java.lang.Throwable -> Lf3
                r2.L$3 = r1     // Catch: java.lang.Throwable -> Lf3
                r2.L$4 = r12     // Catch: java.lang.Throwable -> Lf3
                r2.L$5 = r8     // Catch: java.lang.Throwable -> Lf3
                r2.L$6 = r8     // Catch: java.lang.Throwable -> Lf3
                r2.label = r5     // Catch: java.lang.Throwable -> Lf3
                java.lang.Object r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$measureExits(r0, r12, r10, r2)     // Catch: java.lang.Throwable -> Lf3
                if (r0 != r3) goto Le6
            Le5:
                return r3
            Le6:
                r5 = r4
                r2 = r9
                r3 = r12
                r4 = r1
                r1 = r0
            Leb:
                java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r0 = sd.l.m1004constructorimpl(r1)     // Catch: java.lang.Throwable -> L4a
            Lf1:
                r1 = r4
                goto L101
            Lf3:
                r0 = move-exception
                r5 = r4
                r2 = r9
                r3 = r12
                r4 = r1
            Lf8:
                sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L226
                java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L226
                goto Lf1
            L101:
                kotlin.collections.w r4 = kotlin.collections.w.INSTANCE     // Catch: java.lang.Throwable -> L141
                boolean r9 = sd.l.m1010isFailureimpl(r0)     // Catch: java.lang.Throwable -> L141
                if (r9 == 0) goto L10a
                r0 = r4
            L10a:
                java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L141
                java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L141
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L141
            L112:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L141
                if (r4 == 0) goto L229
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L141
                int r9 = r6 + 1
                if (r6 < 0) goto L222
                com.mlmvpn.scanner.engines.argo.ArgoPool$Ready r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Ready) r4     // Catch: java.lang.Throwable -> L141
                java.lang.Object r6 = kotlin.collections.q.B0(r6, r0)     // Catch: java.lang.Throwable -> L141
                com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Trace) r6     // Catch: java.lang.Throwable -> L141
                if (r6 != 0) goto L144
                com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r6 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Trace     // Catch: java.lang.Throwable -> L141
                r10 = 6
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r23 = r6
                r27 = r10
                r28 = r11
                r24 = r12
                r25 = r13
                r26 = r14
                r23.<init>(r24, r25, r26, r27, r28)     // Catch: java.lang.Throwable -> L141
                goto L144
            L141:
                r0 = move-exception
                goto L233
            L144:
                boolean r10 = r6.getOk()     // Catch: java.lang.Throwable -> L141
                if (r10 == 0) goto L199
                boolean r10 = r6.getCarried()     // Catch: java.lang.Throwable -> L141
                if (r10 == 0) goto L199
                com.mlmvpn.scanner.engines.argo.ArgoPool r11 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L141
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r10 = r4.getX()     // Catch: java.lang.Throwable -> L141
                java.lang.String r12 = r10.getId()     // Catch: java.lang.Throwable -> L141
                long r14 = r4.getMs()     // Catch: java.lang.Throwable -> L141
                java.lang.String r4 = r6.getLoc()     // Catch: java.lang.Throwable -> L141
                boolean r10 = kotlin.text.o.L0(r4)     // Catch: java.lang.Throwable -> L141
                if (r10 == 0) goto L16a
                java.lang.String r4 = "??"
            L16a:
                r16 = r4
                java.lang.String r17 = r6.getIp()     // Catch: java.lang.Throwable -> L141
                r21 = 224(0xe0, float:3.14E-43)
                r22 = 0
                r13 = 1
                r18 = 0
                r19 = 0
                r20 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool.record$default(r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Throwable -> L141
                r4 = 32
                r6 = 0
                r10 = 1
                r11 = 1
                r12 = 0
                r23 = r2
                r29 = r4
                r25 = r5
                r30 = r6
                r24 = r7
                r26 = r10
                r27 = r11
                r28 = r12
                invokeSuspend$tally$default(r23, r24, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L141
                goto L21f
            L199:
                boolean r10 = r6.getOk()     // Catch: java.lang.Throwable -> L141
                if (r10 == 0) goto L1e7
                com.mlmvpn.scanner.engines.argo.ArgoPool r11 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L141
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r10 = r4.getX()     // Catch: java.lang.Throwable -> L141
                java.lang.String r12 = r10.getId()     // Catch: java.lang.Throwable -> L141
                long r14 = r4.getMs()     // Catch: java.lang.Throwable -> L141
                java.lang.String r4 = r6.getLoc()     // Catch: java.lang.Throwable -> L141
                boolean r10 = kotlin.text.o.L0(r4)     // Catch: java.lang.Throwable -> L141
                if (r10 == 0) goto L1b9
                java.lang.String r4 = "??"
            L1b9:
                r16 = r4
                java.lang.String r17 = r6.getIp()     // Catch: java.lang.Throwable -> L141
                java.lang.String r18 = "جواب داد ولی وسط دانلود قطع شد — «آی\u200cپی تمیز» را امتحان کنید"
                r21 = 128(0x80, float:1.794E-43)
                r22 = 0
                r13 = 0
                r19 = 1
                r20 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool.record$default(r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Throwable -> L141
                r4 = 16
                r6 = 0
                r10 = 1
                r11 = 0
                r12 = 1
                r23 = r2
                r29 = r4
                r25 = r5
                r30 = r6
                r24 = r7
                r26 = r10
                r27 = r11
                r28 = r12
                invokeSuspend$tally$default(r23, r24, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L141
                goto L21f
            L1e7:
                com.mlmvpn.scanner.engines.argo.ArgoPool r10 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L141
                com.mlmvpn.scanner.engines.argo.ArgoPool$Item r6 = r4.getX()     // Catch: java.lang.Throwable -> L141
                java.lang.String r11 = r6.getId()     // Catch: java.lang.Throwable -> L141
                long r13 = r4.getMs()     // Catch: java.lang.Throwable -> L141
                java.lang.String r17 = "احراز هویت شد ولی داده\u200cای از داخلش رد نشد"
                r20 = 216(0xd8, float:3.03E-43)
                r21 = 0
                r12 = 0
                r15 = 0
                r16 = 0
                r18 = 0
                r19 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool.record$default(r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)     // Catch: java.lang.Throwable -> L141
                r4 = 48
                r6 = 0
                r10 = 1
                r11 = 0
                r12 = 0
                r23 = r2
                r29 = r4
                r25 = r5
                r30 = r6
                r24 = r7
                r26 = r10
                r27 = r11
                r28 = r12
                invokeSuspend$tally$default(r23, r24, r25, r26, r27, r28, r29, r30)     // Catch: java.lang.Throwable -> L141
            L21f:
                r6 = r9
                goto L112
            L222:
                kotlin.collections.r.f0()     // Catch: java.lang.Throwable -> L141
                throw r8     // Catch: java.lang.Throwable -> L141
            L226:
                r0 = move-exception
                r1 = r4
                goto L233
            L229:
                sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L141
                kotlinx.coroutines.sync.f r1 = (kotlinx.coroutines.sync.f) r1
                r1.f(r8)
                return r0
            L231:
                monitor-exit(r11)     // Catch: java.lang.Throwable -> L141
                throw r0     // Catch: java.lang.Throwable -> L141
            L233:
                kotlinx.coroutines.sync.f r1 = (kotlinx.coroutines.sync.f) r1
                r1.f(r8)
                throw r0
        }

        private static final void invokeSuspend$tally(kotlin.jvm.internal.w r22, kotlin.jvm.internal.w r23, kotlin.jvm.internal.w r24, int r25, int r26, int r27) {
                r0 = r22
                r1 = r23
                r2 = r24
                com.mlmvpn.scanner.engines.argo.ArgoPool r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                monitor-enter(r3)
                int r4 = r0.element     // Catch: java.lang.Throwable -> L3e
                int r4 = r4 + r25
                r0.element = r4     // Catch: java.lang.Throwable -> L3e
                int r4 = r1.element     // Catch: java.lang.Throwable -> L3e
                int r4 = r4 + r26
                r1.element = r4     // Catch: java.lang.Throwable -> L3e
                int r4 = r2.element     // Catch: java.lang.Throwable -> L3e
                int r4 = r4 + r27
                r2.element = r4     // Catch: java.lang.Throwable -> L3e
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r5 = r3.getTestJob()     // Catch: java.lang.Throwable -> L3e
                if (r5 == 0) goto L40
                int r7 = r0.element     // Catch: java.lang.Throwable -> L3e
                int r9 = r1.element     // Catch: java.lang.Throwable -> L3e
                int r10 = r2.element     // Catch: java.lang.Throwable -> L3e
                r20 = 8165(0x1fe5, float:1.1442E-41)
                r21 = 0
                r6 = 0
                r8 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21)     // Catch: java.lang.Throwable -> L3e
                goto L41
            L3e:
                r0 = move-exception
                goto L49
            L40:
                r0 = 0
            L41:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setTestJob$p(r0)     // Catch: java.lang.Throwable -> L3e
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r3)     // Catch: java.lang.Throwable -> L3e
                monitor-exit(r3)
                return
            L49:
                monitor-exit(r3)
                throw r0
        }

        public static /* synthetic */ void invokeSuspend$tally$default(kotlin.jvm.internal.w r1, kotlin.jvm.internal.w r2, kotlin.jvm.internal.w r3, int r4, int r5, int r6, int r7, java.lang.Object r8) {
                r8 = r7 & 16
                r0 = 0
                if (r8 == 0) goto L6
                r5 = r0
            L6:
                r7 = r7 & 32
                if (r7 == 0) goto Lb
                r6 = r0
            Lb:
                invokeSuspend$tally(r1, r2, r3, r4, r5, r6)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r4, wd.d r5) {
                r3 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$test$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r1 = r3.$list
                java.lang.String r2 = r3.$connectIp
                r0.<init>(r1, r2, r5)
                r0.L$0 = r4
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$test$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04021) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
                r21 = this;
                r7 = r21
                kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r7.label
                r9 = 2
                r1 = 1
                if (r0 == 0) goto L56
                if (r0 == r1) goto L3a
                if (r0 != r9) goto L32
                java.lang.Object r0 = r7.L$5
                kotlin.jvm.internal.w r0 = (kotlin.jvm.internal.w) r0
                java.lang.Object r1 = r7.L$4
                kotlin.jvm.internal.w r1 = (kotlin.jvm.internal.w) r1
                java.lang.Object r2 = r7.L$3
                kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
                java.lang.Object r3 = r7.L$2
                kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r3
                java.lang.Object r4 = r7.L$1
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r5 = r7.L$0
                kotlinx.coroutines.i0 r5 = (kotlinx.coroutines.i0) r5
                sd.m.b(r22)
                r6 = r5
                r5 = r1
                r1 = r4
                r4 = r2
                r2 = r6
                r6 = r0
                r0 = r3
                goto Ld7
            L32:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L3a:
                java.lang.Object r0 = r7.L$5
                kotlin.jvm.internal.w r0 = (kotlin.jvm.internal.w) r0
                java.lang.Object r1 = r7.L$4
                kotlin.jvm.internal.w r1 = (kotlin.jvm.internal.w) r1
                java.lang.Object r2 = r7.L$3
                kotlin.jvm.internal.w r2 = (kotlin.jvm.internal.w) r2
                java.lang.Object r3 = r7.L$2
                kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r3
                java.lang.Object r4 = r7.L$1
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r5 = r7.L$0
                kotlinx.coroutines.i0 r5 = (kotlinx.coroutines.i0) r5
                sd.m.b(r22)
                goto Lad
            L56:
                sd.m.b(r22)
                java.lang.Object r0 = r7.L$0
                r19 = r0
                kotlinx.coroutines.i0 r19 = (kotlinx.coroutines.i0) r19
                java.util.concurrent.atomic.AtomicInteger r12 = new java.util.concurrent.atomic.AtomicInteger
                r0 = 0
                r12.<init>(r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.List r14 = java.util.Collections.synchronizedList(r0)
                kotlinx.coroutines.sync.f r18 = new kotlinx.coroutines.sync.f
                r18.<init>()
                kotlin.jvm.internal.w r15 = new kotlin.jvm.internal.w
                r15.<init>()
                kotlin.jvm.internal.w r16 = new kotlin.jvm.internal.w
                r16.<init>()
                kotlin.jvm.internal.w r17 = new kotlin.jvm.internal.w
                r17.<init>()
                com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1 r10 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r11 = r7.$list
                java.lang.String r13 = r7.$connectIp
                r20 = 0
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                r2 = r16
                r0 = r17
                r3 = r18
                r5 = r19
                r7.L$0 = r5
                r7.L$1 = r14
                r7.L$2 = r3
                r7.L$3 = r15
                r7.L$4 = r2
                r7.L$5 = r0
                r7.label = r1
                java.lang.Object r1 = kotlinx.coroutines.m0.i(r10, r7)
                if (r1 != r8) goto Laa
                goto Ld6
            Laa:
                r1 = r2
                r4 = r14
                r2 = r15
            Lad:
                r6 = r5
                r5 = r1
                r1 = r4
                r4 = r2
                r2 = r6
                r6 = r0
                r0 = r3
            Lb4:
                kotlin.jvm.internal.j.b(r1)
                r3 = r1
                java.util.Collection r3 = (java.util.Collection) r3
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto Lda
                java.lang.String r3 = r7.$connectIp
                r7.L$0 = r2
                r7.L$1 = r1
                r7.L$2 = r0
                r7.L$3 = r4
                r7.L$4 = r5
                r7.L$5 = r6
                r7.label = r9
                java.lang.Object r3 = invokeSuspend$flush(r0, r1, r2, r3, r4, r5, r6, r7)
                if (r3 != r8) goto Ld7
            Ld6:
                return r8
            Ld7:
                r7 = r21
                goto Lb4
            Lda:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = r0.getTestJob()
                if (r1 == 0) goto Lfb
                long r11 = java.lang.System.currentTimeMillis()
                r16 = 7678(0x1dfe, float:1.0759E-41)
                r17 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17)
                goto Lfc
            Lfb:
                r1 = 0
            Lfc:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setTestJob$p(r1)
                r0.saveNow()
                sd.u r0 = sd.u.f67154a
                return r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$update$1", f = "ArgoPool.kt", l = {478}, m = "invokeSuspend")
    public static final class C04031 extends xd.j implements ee.e {
        final /* synthetic */ java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Source> $list;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoNet.Route $route;
        int I$0;
        int I$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;

        public C04031(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Source> r1, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r2, wd.d r3) {
                r0 = this;
                r0.$list = r1
                r0.$route = r2
                r1 = 2
                r0.<init>(r1, r3)
                return
        }

        public static /* synthetic */ sd.u d(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r0, int r1, int r2) {
                sd.u r0 = invokeSuspend$lambda$2(r0, r1, r2)
                return r0
        }

        public static /* synthetic */ boolean f() {
                boolean r0 = invokeSuspend$lambda$4()
                return r0
        }

        public static /* synthetic */ boolean g() {
                boolean r0 = invokeSuspend$lambda$3()
                return r0
        }

        private static final sd.u invokeSuspend$lambda$2(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r18, int r19, int r20) {
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = r0.getUpdateJob()
                if (r1 == 0) goto L47
                java.lang.String r2 = r18.getLabel()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                java.lang.String r2 = " — صفحهٔ "
                r3.append(r2)
                r2 = r19
                r3.append(r2)
                java.lang.String r2 = "، "
                r3.append(r2)
                r2 = r20
                r3.append(r2)
                java.lang.String r2 = " مورد تازه"
                r3.append(r2)
                java.lang.String r7 = r3.toString()
                r16 = 8159(0x1fdf, float:1.1433E-41)
                r17 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17)
                goto L48
            L47:
                r1 = 0
            L48:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setUpdateJob$p(r1)
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r0)
                sd.u r0 = sd.u.f67154a
                return r0
        }

        private static final boolean invokeSuspend$lambda$3() {
                boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getUpdateCancel$p()
                return r0
        }

        private static final boolean invokeSuspend$lambda$4() {
                boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getUpdateCancel$p()
                return r0
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r3, wd.d r4) {
                r2 = this;
                com.mlmvpn.scanner.engines.argo.ArgoPool$update$1 r3 = new com.mlmvpn.scanner.engines.argo.ArgoPool$update$1
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = r2.$list
                com.mlmvpn.scanner.engines.argo.ArgoNet$Route r1 = r2.$route
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
                com.mlmvpn.scanner.engines.argo.ArgoPool$update$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04031) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r33) {
                r32 = this;
                r7 = r32
                kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r7.label
                r9 = 0
                r10 = 1
                if (r0 == 0) goto L36
                if (r0 != r10) goto L2e
                int r1 = r7.I$1
                int r2 = r7.I$0
                java.lang.Object r0 = r7.L$3
                r3 = r0
                sf.c r3 = (sf.c) r3
                java.lang.Object r0 = r7.L$2
                r4 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r4
                java.lang.Object r0 = r7.L$1
                r5 = r0
                java.util.Iterator r5 = (java.util.Iterator) r5
                java.lang.Object r0 = r7.L$0
                r6 = r0
                java.util.List r6 = (java.util.List) r6
                sd.m.b(r33)     // Catch: java.lang.Throwable -> L2b
                r0 = r33
                goto Lf9
            L2b:
                r0 = move-exception
                goto L144
            L2e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L36:
                java.util.ArrayList r0 = androidx.compose.foundation.interaction.f.v(r33)
                java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r1 = r7.$list
                java.util.Iterator r1 = r1.iterator()
                r2 = 0
                r14 = r0
                r13 = r1
                r11 = r2
                r12 = r11
            L45:
                boolean r0 = r13.hasNext()
                if (r0 == 0) goto L1aa
                java.lang.Object r0 = r13.next()
                r2 = r0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Source r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r2
                boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getUpdateCancel$p()
                if (r0 != 0) goto L1aa
                com.mlmvpn.scanner.engines.argo.ArgoPool r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r15 = r1.getUpdateJob()
                if (r15 == 0) goto L85
                java.lang.String r21 = r2.getLabel()
                r30 = 8159(0x1fdf, float:1.1433E-41)
                r31 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31)
                goto L86
            L85:
                r0 = r9
            L86:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setUpdateJob$p(r0)
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$changed(r1)
                monitor-enter(r1)
                java.util.HashMap r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$getSourceState$p()     // Catch: java.lang.Throwable -> La4
                java.lang.String r3 = r2.getId()     // Catch: java.lang.Throwable -> La4
                java.lang.Object r4 = r0.get(r3)     // Catch: java.lang.Throwable -> La4
                if (r4 != 0) goto La7
                sf.c r4 = new sf.c     // Catch: java.lang.Throwable -> La4
                r4.<init>()     // Catch: java.lang.Throwable -> La4
                r0.put(r3, r4)     // Catch: java.lang.Throwable -> La4
                goto La7
            La4:
                r0 = move-exception
                goto L1a8
            La7:
                r15 = r4
                sf.c r15 = (sf.c) r15     // Catch: java.lang.Throwable -> La4
                java.lang.String r0 = "error"
                java.lang.String r3 = ""
                r15.D(r0, r3)     // Catch: java.lang.Throwable -> La4
                monitor-exit(r1)
                java.lang.String r0 = r2.getType()     // Catch: java.lang.Throwable -> L100
                java.lang.String r3 = "telegram"
                boolean r3 = kotlin.jvm.internal.j.a(r0, r3)     // Catch: java.lang.Throwable -> L100
                if (r3 == 0) goto L108
                java.lang.String r0 = "at"
                r3 = 0
                long r5 = r15.x(r3, r0)     // Catch: java.lang.Throwable -> L100
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 <= 0) goto Lce
                r0 = 40
            Lcc:
                r3 = r0
                goto Ld1
            Lce:
                r0 = 250(0xfa, float:3.5E-43)
                goto Lcc
            Ld1:
                com.mlmvpn.scanner.engines.argo.ArgoNet$Route r4 = r7.$route     // Catch: java.lang.Throwable -> L100
                com.mlmvpn.scanner.engines.argo.e r5 = new com.mlmvpn.scanner.engines.argo.e     // Catch: java.lang.Throwable -> L100
                r5.<init>(r2)     // Catch: java.lang.Throwable -> L100
                com.mlmvpn.scanner.engines.argo.f r6 = new com.mlmvpn.scanner.engines.argo.f     // Catch: java.lang.Throwable -> L100
                r0 = 0
                r6.<init>(r0)     // Catch: java.lang.Throwable -> L100
                r7.L$0 = r14     // Catch: java.lang.Throwable -> L100
                r7.L$1 = r13     // Catch: java.lang.Throwable -> L100
                r7.L$2 = r2     // Catch: java.lang.Throwable -> L100
                r7.L$3 = r15     // Catch: java.lang.Throwable -> L100
                r7.I$0 = r12     // Catch: java.lang.Throwable -> L100
                r7.I$1 = r11     // Catch: java.lang.Throwable -> L100
                r7.label = r10     // Catch: java.lang.Throwable -> L100
                java.lang.Object r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$harvestTelegram(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L100
                if (r0 != r8) goto Lf3
                return r8
            Lf3:
                r4 = r2
                r1 = r11
                r2 = r12
                r5 = r13
                r6 = r14
                r3 = r15
            Lf9:
                java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> L2b
                int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L2b
                goto L12a
            L100:
                r0 = move-exception
                r4 = r2
                r1 = r11
                r2 = r12
                r5 = r13
                r6 = r14
                r3 = r15
                goto L144
            L108:
                java.lang.String r3 = "url"
                boolean r0 = kotlin.jvm.internal.j.a(r0, r3)     // Catch: java.lang.Throwable -> L100
                if (r0 == 0) goto L123
                com.mlmvpn.scanner.engines.argo.ArgoNet$Route r0 = r7.$route     // Catch: java.lang.Throwable -> L100
                com.mlmvpn.scanner.engines.argo.f r3 = new com.mlmvpn.scanner.engines.argo.f     // Catch: java.lang.Throwable -> L100
                r4 = 1
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L100
                int r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$harvestUrl(r1, r2, r0, r3)     // Catch: java.lang.Throwable -> L100
            L11c:
                r4 = r2
                r1 = r11
                r2 = r12
                r5 = r13
                r6 = r14
                r3 = r15
                goto L12a
            L123:
                com.mlmvpn.scanner.engines.argo.ArgoNet$Route r0 = r7.$route     // Catch: java.lang.Throwable -> L100
                int r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$harvestOfficial(r1, r2, r0)     // Catch: java.lang.Throwable -> L100
                goto L11c
            L12a:
                java.lang.String r11 = "at"
                long r12 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
                java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Throwable -> L2b
                r3.D(r11, r12)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r11 = "found"
                java.lang.Integer r12 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L2b
                r3.D(r11, r12)     // Catch: java.lang.Throwable -> L2b
                int r1 = r1 + r0
            L141:
                r18 = r1
                goto L171
            L144:
                java.lang.String r11 = "error"
                java.lang.String r12 = r0.getMessage()
                if (r12 != 0) goto L14e
                java.lang.String r12 = ""
            L14e:
                r3.D(r11, r12)
                java.lang.String r3 = r4.getLabel()
                java.lang.String r0 = r0.getMessage()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                java.lang.String r3 = ": "
                r4.append(r3)
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r6.add(r0)
                goto L141
            L171:
                int r13 = r2 + 1
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r11 = r0.getUpdateJob()
                if (r11 == 0) goto L19a
                r1 = 5
                java.util.List r19 = kotlin.collections.q.f1(r1, r6)
                r26 = 7997(0x1f3d, float:1.1206E-41)
                r27 = 0
                r12 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r20 = 0
                r21 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27)
                goto L19b
            L19a:
                r1 = r9
            L19b:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setUpdateJob$p(r1)
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$saveSoon(r0)
                r14 = r6
                r12 = r13
                r11 = r18
                r13 = r5
                goto L45
            L1a8:
                monitor-exit(r1)
                throw r0
            L1aa:
                com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r10 = r0.getUpdateJob()
                if (r10 == 0) goto L1d1
                java.lang.String r16 = ""
                long r20 = java.lang.System.currentTimeMillis()
                r25 = 7646(0x1dde, float:1.0714E-41)
                r26 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                com.mlmvpn.scanner.engines.argo.ArgoPool$Job r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.Job.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26)
            L1d1:
                com.mlmvpn.scanner.engines.argo.ArgoPool.access$setUpdateJob$p(r9)
                r0.saveNow()
                sd.u r0 = sd.u.f67154a
                return r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$waitPort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool", f = "ArgoPool.kt", l = {519}, m = "waitPort")
    public static final class C04041 extends xd.c {
        int I$0;
        long J$0;
        java.lang.Object L$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool this$0;

        public C04041(com.mlmvpn.scanner.engines.argo.ArgoPool r1, wd.d r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                r3.result = r4
                int r4 = r3.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r4 | r0
                r3.label = r4
                com.mlmvpn.scanner.engines.argo.ArgoPool r4 = r3.this$0
                r0 = 0
                r1 = 0
                java.lang.Object r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.access$waitPort(r4, r0, r1, r3)
                return r4
        }
    }

    static {
            com.mlmvpn.scanner.engines.argo.ArgoPool r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool
            r0.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE = r0
            java.lang.String r1 = "http.agent"
            java.lang.String r1 = java.lang.System.getProperty(r1)
            r2 = 0
            if (r1 == 0) goto L23
            boolean r3 = kotlin.text.o.L0(r1)
            if (r3 != 0) goto L20
            java.lang.String r3 = "okhttp"
            r4 = 1
            boolean r3 = kotlin.text.o.y0(r1, r3, r4)
            if (r3 != 0) goto L20
            goto L21
        L20:
            r1 = r2
        L21:
            if (r1 != 0) goto L25
        L23:
            java.lang.String r1 = "Mozilla/5.0 (Linux; Android)"
        L25:
            com.mlmvpn.scanner.engines.argo.ArgoPool.CARRY_UA = r1
            kotlinx.coroutines.r2 r1 = kotlinx.coroutines.m0.b()
            oe.e r3 = kotlinx.coroutines.v0.f24208c
            wd.i r1 = g8.a.D(r3, r1)
            kotlinx.coroutines.internal.e r1 = kotlinx.coroutines.m0.a(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool.scope = r1
            java.security.SecureRandom r1 = new java.security.SecureRandom
            r1.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.random = r1
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.items = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.results = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.userSources = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState = r1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs
            r3 = 0
            r4 = 3
            r1.<init>(r2, r3, r4, r2)
            com.mlmvpn.scanner.engines.argo.ArgoPool.prefs = r1
            kotlin.collections.w r1 = kotlin.collections.w.INSTANCE
            com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers = r1
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            kotlinx.coroutines.flow.g1 r1 = kotlinx.coroutines.flow.h.b(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool._version = r1
            com.mlmvpn.scanner.engines.argo.ArgoPool.version = r1
            java.lang.String r1 = "argooo_vpn"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r2 = r0.tg(r1)
            java.lang.String r1 = "ARGO_VPNN"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r3 = r0.tg(r1)
            java.lang.String r1 = "falconchi"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r4 = r0.tg(r1)
            java.lang.String r1 = "argo_falcon"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r5 = r0.tg(r1)
            java.lang.String r1 = "falcon_argo"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r6 = r0.tg(r1)
            java.lang.String r1 = "argovpn_falcon"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r7 = r0.tg(r1)
            java.lang.String r1 = "argo_bridge"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r8 = r0.tg(r1)
            java.lang.String r1 = "ArgoVPNs"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r9 = r0.tg(r1)
            java.lang.String r1 = "vvpnfc"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r10 = r0.tg(r1)
            java.lang.String r1 = "falconsazi"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r11 = r0.tg(r1)
            java.lang.String r1 = "pol_argo"
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r12 = r0.tg(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r13 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source
            java.lang.String r0 = "https://github.com/bannedbook/ssvpn/issues"
            java.util.List r16 = m9.d.B(r0)
            r22 = 96
            r23 = 0
            java.lang.String r14 = "gh:bannedbook-ssvpn"
            java.lang.String r15 = "url"
            java.lang.String r17 = "گیت\u200cهاب — ایشوهای bannedbook/ssvpn"
            r18 = 1
            r19 = 0
            r20 = 0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r22, r23)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r14 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source
            java.lang.String r0 = "https://raw.githubusercontent.com/legend-wizard/browse/refs/heads/main/data6.br"
            java.lang.String r1 = "https://akeptumbesnow.com/repo6"
            java.lang.String r15 = "https://s3.amazonaws.com/argovpn/browse/data6.br"
            java.lang.String[] r0 = new java.lang.String[]{r15, r0, r1}
            java.util.List r17 = kotlin.collections.r.a0(r0)
            r23 = 96
            r24 = 0
            java.lang.String r15 = "argo:config"
            java.lang.String r16 = "snowcfg"
            java.lang.String r18 = "فهرست رسمی سرورهای عمومی آرگو"
            r19 = 1
            r20 = 0
            r21 = 0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r23, r24)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r15 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source
            java.lang.String r0 = "https://raw.githubusercontent.com/ArgoConfBot/ARG/master/lib.br"
            java.util.List r18 = m9.d.B(r0)
            r24 = 96
            r25 = 0
            java.lang.String r16 = "argo:falcon"
            java.lang.String r17 = "falcon-servers"
            java.lang.String r19 = "فهرست رسمی سرورهای فالکن (برای ساخت فالکن شخصی)"
            r20 = 1
            r21 = 0
            r22 = 0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r24, r25)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source[] r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool.Source[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15}
            java.util.List r0 = kotlin.collections.r.a0(r0)
            com.mlmvpn.scanner.engines.argo.ArgoPool.BUILTIN = r0
            java.lang.String r14 = "172.64.0.0/13"
            java.lang.String r15 = "131.0.72.0/22"
            java.lang.String r1 = "173.245.48.0/20"
            java.lang.String r2 = "103.21.244.0/22"
            java.lang.String r3 = "103.22.200.0/22"
            java.lang.String r4 = "103.31.4.0/22"
            java.lang.String r5 = "141.101.64.0/18"
            java.lang.String r6 = "108.162.192.0/18"
            java.lang.String r7 = "190.93.240.0/20"
            java.lang.String r8 = "188.114.96.0/20"
            java.lang.String r9 = "197.234.240.0/22"
            java.lang.String r10 = "198.41.128.0/17"
            java.lang.String r11 = "162.158.0.0/15"
            java.lang.String r12 = "104.16.0.0/13"
            java.lang.String r13 = "104.24.0.0/14"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15}
            java.util.List r0 = kotlin.collections.r.a0(r0)
            com.mlmvpn.scanner.engines.argo.ArgoPool.CF_V4 = r0
            java.lang.String r15 = "2a06:98c1:3121"
            java.lang.String r16 = "2400:cb00:2049"
            java.lang.String r1 = "2606:4700:3030"
            java.lang.String r2 = "2606:4700:3031"
            java.lang.String r3 = "2606:4700:3032"
            java.lang.String r4 = "2606:4700:3033"
            java.lang.String r5 = "2606:4700:3034"
            java.lang.String r6 = "2606:4700:3035"
            java.lang.String r7 = "2606:4700:3036"
            java.lang.String r8 = "2606:4700:3037"
            java.lang.String r9 = "2606:4700:10"
            java.lang.String r10 = "2606:4700:20"
            java.lang.String r11 = "2606:4700:7"
            java.lang.String r12 = "2606:4700:4400"
            java.lang.String r13 = "2803:f800:50"
            java.lang.String r14 = "2a06:98c1:3120"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16}
            java.util.List r0 = kotlin.collections.r.a0(r0)
            com.mlmvpn.scanner.engines.argo.ArgoPool.CF_V6 = r0
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$"
            r0.<init>(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool.IPV4_LITERAL = r0
            r0 = 8
            com.mlmvpn.scanner.engines.argo.ArgoPool.$stable = r0
            return
    }

    private ArgoPool() {
            r0 = this;
            r0.<init>()
            return
    }

    public static /* synthetic */ java.lang.Comparable a(com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin r0) {
            java.lang.Comparable r0 = summary$lambda$110(r0)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed absorbText(java.lang.String r20, java.lang.String r21, long r22, boolean r24, boolean r25) {
            r19 = this;
            r0 = r20
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r1 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
            java.util.List r1 = r1.extractBridgeBlocks(r0)
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
        Lf:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r6 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L27
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Bridge r5 = r6.decodeBridgeBlock(r5)     // Catch: java.lang.Throwable -> L27
            boolean r6 = r5.getSigOk()     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L2a
        L27:
            int r4 = r4 + 1
            goto Lf
        L2a:
            java.lang.String r6 = "bridge"
            java.lang.String r7 = r5.getHost()     // Catch: java.lang.Throwable -> L27
            int r8 = r5.getPort()     // Catch: java.lang.Throwable -> L27
            java.lang.String r9 = r5.getProtocol()     // Catch: java.lang.Throwable -> L27
            r15 = 128(0x80, float:1.794E-43)
            r16 = 0
            r14 = 0
            r5 = r19
            r10 = r21
            r11 = r22
            r13 = r25
            boolean r6 = addItem$default(r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L27
            if (r6 == 0) goto Lf
            int r3 = r3 + 1
            goto Lf
        L4e:
            kotlin.text.l r1 = new kotlin.text.l
            java.lang.String r5 = "-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+"
            kotlin.text.m r6 = kotlin.text.m.IGNORE_CASE
            r1.<init>(r5, r6)
            java.lang.String r5 = ""
            java.lang.String r0 = r1.replace(r0, r5)
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r1 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
            r5 = r24
            java.util.List r0 = r1.extractFalconHosts(r0, r5)
            java.util.Iterator r0 = r0.iterator()
        L69:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L93
            java.lang.Object r1 = r0.next()
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9
            r17 = 128(0x80, float:1.794E-43)
            r18 = 0
            java.lang.String r8 = "falcon"
            r10 = 443(0x1bb, float:6.21E-43)
            java.lang.String r11 = "A"
            r16 = 0
            r7 = r19
            r12 = r21
            r13 = r22
            r15 = r25
            boolean r1 = addItem$default(r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18)
            if (r1 == 0) goto L69
            int r2 = r2 + 1
            goto L69
        L93:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed
            r0.<init>(r3, r2, r4)
            return r0
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed absorbText$default(com.mlmvpn.scanner.engines.argo.ArgoPool r1, java.lang.String r2, java.lang.String r3, long r4, boolean r6, boolean r7, int r8, java.lang.Object r9) {
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto L6
            r6 = r0
        L6:
            r8 = r8 & 16
            if (r8 == 0) goto Lb
            r7 = r0
        Lb:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r1 = r1.absorbText(r2, r3, r4, r6, r7)
            return r1
    }

    public static final /* synthetic */ boolean access$carry(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1) {
            boolean r0 = r0.carry(r1)
            return r0
    }

    public static final /* synthetic */ void access$changed(com.mlmvpn.scanner.engines.argo.ArgoPool r0) {
            r0.changed()
            return
    }

    public static final /* synthetic */ sd.j access$download(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1, java.lang.String r2, long r3, long r5, boolean r7) {
            sd.j r0 = r0.download(r1, r2, r3, r5, r7)
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint access$endpointOf(com.mlmvpn.scanner.engines.argo.ArgoPool r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Item r1) {
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r0.endpointOf(r1)
            return r0
    }

    public static final /* synthetic */ int access$freePort(com.mlmvpn.scanner.engines.argo.ArgoPool r0) {
            int r0 = r0.freePort()
            return r0
    }

    public static final /* synthetic */ android.content.Context access$getApp$p() {
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.app
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs access$getPrefs$p() {
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs
            return r0
    }

    public static final /* synthetic */ java.util.HashMap access$getResults$p() {
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results
            return r0
    }

    public static final /* synthetic */ boolean access$getScanCancel$p() {
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.scanCancel
            return r0
    }

    public static final /* synthetic */ java.util.HashMap access$getSourceState$p() {
            java.util.HashMap<java.lang.String, sf.c> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState
            return r0
    }

    public static final /* synthetic */ boolean access$getTestCancel$p() {
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.testCancel
            return r0
    }

    public static final /* synthetic */ boolean access$getUpdateCancel$p() {
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.updateCancel
            return r0
    }

    public static final /* synthetic */ int access$harvestOfficial(com.mlmvpn.scanner.engines.argo.ArgoPool r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r1, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r2) {
            int r0 = r0.harvestOfficial(r1, r2)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$harvestTelegram(com.mlmvpn.scanner.engines.argo.ArgoPool r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r1, int r2, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r3, ee.e r4, ee.a r5, wd.d r6) {
            java.lang.Object r0 = r0.harvestTelegram(r1, r2, r3, r4, r5, r6)
            return r0
    }

    public static final /* synthetic */ int access$harvestUrl(com.mlmvpn.scanner.engines.argo.ArgoPool r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r1, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r2, ee.a r3) {
            int r0 = r0.harvestUrl(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ boolean access$hasGlobalV6(com.mlmvpn.scanner.engines.argo.ArgoPool r0) {
            boolean r0 = r0.hasGlobalV6()
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$measureExits(com.mlmvpn.scanner.engines.argo.ArgoPool r0, java.util.List r1, java.lang.String r2, wd.d r3) {
            java.lang.Object r0 = r0.measureExits(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ java.util.List access$sampleV4(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1) {
            java.util.List r0 = r0.sampleV4(r1)
            return r0
    }

    public static final /* synthetic */ java.util.List access$sampleV6(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1) {
            java.util.List r0 = r0.sampleV6(r1)
            return r0
    }

    public static final /* synthetic */ void access$savePrefs(com.mlmvpn.scanner.engines.argo.ArgoPool r0) {
            r0.savePrefs()
            return
    }

    public static final /* synthetic */ void access$saveSoon(com.mlmvpn.scanner.engines.argo.ArgoPool r0) {
            r0.saveSoon()
            return
    }

    public static final /* synthetic */ void access$setCleanScan$p(sf.c r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.cleanScan = r0
            return
    }

    public static final /* synthetic */ void access$setIpScan$p(com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.ipScan = r0
            return
    }

    public static final /* synthetic */ void access$setPrefs$p(com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.prefs = r0
            return
    }

    public static final /* synthetic */ void access$setSaveQueued$p(boolean r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.saveQueued = r0
            return
    }

    public static final /* synthetic */ void access$setTestJob$p(com.mlmvpn.scanner.engines.argo.ArgoPool.Job r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.testJob = r0
            return
    }

    public static final /* synthetic */ void access$setUpdateJob$p(com.mlmvpn.scanner.engines.argo.ArgoPool.Job r0) {
            com.mlmvpn.scanner.engines.argo.ArgoPool.updateJob = r0
            return
    }

    public static final /* synthetic */ java.net.Proxy access$socks(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1) {
            java.net.Proxy r0 = r0.socks(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$speedThrough(com.mlmvpn.scanner.engines.argo.ArgoPool r0, java.lang.String r1, com.mlmvpn.scanner.engines.argo.ArgoPool.Item r2, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r3, wd.d r4) {
            java.lang.Object r0 = r0.speedThrough(r1, r2, r3, r4)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$telegramPageRetry(com.mlmvpn.scanner.engines.argo.ArgoPool r0, java.lang.String r1, java.lang.Long r2, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r3, ee.a r4, wd.d r5) {
            java.lang.Object r0 = r0.telegramPageRetry(r1, r2, r3, r4, r5)
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Trace access$traceVia(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1) {
            com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r0 = r0.traceVia(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$waitPort(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1, long r2, wd.d r4) {
            java.lang.Object r0 = r0.waitPort(r1, r2, r4)
            return r0
    }

    private final synchronized boolean addItem(java.lang.String r28, java.lang.String r29, int r30, java.lang.String r31, java.lang.String r32, long r33, boolean r35, java.lang.String r36) {
            r27 = this;
            r1 = r27
            r0 = r30
            r2 = r33
            monitor-enter(r27)
            java.util.Locale r4 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L51
            r5 = r29
            java.lang.String r4 = r5.toLowerCase(r4)     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "toLowerCase(...)"
            kotlin.jvm.internal.j.d(r4, r5)     // Catch: java.lang.Throwable -> L51
            r5 = 1
            char[] r6 = new char[r5]     // Catch: java.lang.Throwable -> L51
            r7 = 0
            r8 = 46
            r6[r7] = r8     // Catch: java.lang.Throwable -> L51
            java.lang.String r12 = kotlin.text.o.q1(r4, r6)     // Catch: java.lang.Throwable -> L51
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r4 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L51
            boolean r4 = r4.looksLikeHost(r12)     // Catch: java.lang.Throwable -> L51
            if (r4 != 0) goto L2a
            monitor-exit(r27)
            return r7
        L2a:
            if (r5 > r0) goto L34
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r0 >= r4) goto L34
        L30:
            r11 = r28
            r13 = r0
            goto L37
        L34:
            r0 = 443(0x1bb, float:6.21E-43)
            goto L30
        L37:
            java.lang.String r10 = r1.idOf(r11, r12, r13)     // Catch: java.lang.Throwable -> L51
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r0.get(r10)     // Catch: java.lang.Throwable -> L51
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r4     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L5a
            long r8 = r4.getSeen()     // Catch: java.lang.Throwable -> L51
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L53
            r4.setSeen(r2)     // Catch: java.lang.Throwable -> L51
            goto L53
        L51:
            r0 = move-exception
            goto L95
        L53:
            if (r35 == 0) goto L58
            r4.setUser(r5)     // Catch: java.lang.Throwable -> L51
        L58:
            monitor-exit(r27)
            return r7
        L5a:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r9 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Item     // Catch: java.lang.Throwable -> L51
            java.lang.String r4 = "B"
            r6 = r31
            boolean r4 = kotlin.jvm.internal.j.a(r6, r4)     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L6a
            java.lang.String r4 = "B"
        L68:
            r14 = r4
            goto L6d
        L6a:
            java.lang.String r4 = "A"
            goto L68
        L6d:
            r6 = 0
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L76
        L73:
            r17 = r2
            goto L7b
        L76:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L51
            goto L73
        L7b:
            r25 = 7232(0x1c40, float:1.0134E-41)
            r26 = 0
            r16 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r15 = r32
            r19 = r35
            r20 = r36
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r21, r22, r24, r25, r26)     // Catch: java.lang.Throwable -> L51
            r0.put(r10, r9)     // Catch: java.lang.Throwable -> L51
            monitor-exit(r27)
            return r5
        L95:
            monitor-exit(r27)     // Catch: java.lang.Throwable -> L51
            throw r0
    }

    public static /* synthetic */ boolean addItem$default(com.mlmvpn.scanner.engines.argo.ArgoPool r12, java.lang.String r13, java.lang.String r14, int r15, java.lang.String r16, java.lang.String r17, long r18, boolean r20, java.lang.String r21, int r22, java.lang.Object r23) {
            r0 = r22
            r1 = r0 & 64
            if (r1 == 0) goto L9
            r1 = 0
            r10 = r1
            goto Lb
        L9:
            r10 = r20
        Lb:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L1d
            java.lang.String r0 = ""
            r11 = r0
        L12:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            goto L20
        L1d:
            r11 = r21
            goto L12
        L20:
            boolean r12 = r2.addItem(r3, r4, r5, r6, r7, r8, r10, r11)
            return r12
    }

    private static final java.lang.CharSequence addSource$lambda$61(byte r1) {
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            r0 = 1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0)
            java.lang.String r0 = "%02x"
            java.lang.String r1 = java.lang.String.format(r0, r1)
            return r1
    }

    public static /* synthetic */ boolean b(java.util.Map.Entry r0) {
            boolean r0 = load$lambda$20(r0)
            return r0
    }

    public static /* synthetic */ java.lang.CharSequence c(kotlin.text.g r0) {
            java.lang.CharSequence r0 = decodeHtml$lambda$42(r0)
            return r0
    }

    private final boolean carry(int r9) {
            r8 = this;
            r5 = 20000(0x4e20, double:9.8813E-320)
            r7 = 1
            java.lang.String r2 = "https://cachefly.cachefly.net/1mb.test"
            r3 = 262144(0x40000, double:1.295163E-318)
            r0 = r8
            r1 = r9
            sd.j r9 = r0.download(r1, r2, r3, r5, r7)
            java.lang.Object r9 = r9.getSecond()
            java.lang.Number r9 = (java.lang.Number) r9
            long r0 = r9.longValue()
            r2 = 250000(0x3d090, double:1.235164E-318)
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 < 0) goto L21
            r9 = 1
            return r9
        L21:
            r9 = 0
            return r9
    }

    private final java.lang.String ccOf(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r4) {
            r3 = this;
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results
            java.lang.String r1 = r4.getId()
            java.lang.Object r0 = r0.get(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r0
            java.lang.String r1 = "??"
            if (r0 == 0) goto L28
            java.lang.String r0 = r0.getCc()
            if (r0 == 0) goto L28
            boolean r2 = kotlin.text.o.L0(r0)
            if (r2 != 0) goto L23
            boolean r2 = r0.equals(r1)
            if (r2 != 0) goto L23
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 != 0) goto L27
            goto L28
        L27:
            return r0
        L28:
            java.lang.String r4 = r4.getCc0()
            boolean r0 = kotlin.text.o.L0(r4)
            if (r0 == 0) goto L33
            return r1
        L33:
            return r4
    }

    private final void changed() {
            r5 = this;
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.argo.ArgoPool._version
            r1 = r0
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            long r1 = r1.longValue()
            r3 = 1
            long r1 = r1 + r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            r0.getClass()
            r2 = 0
            r0.k(r2, r1)
            return
    }

    private final okhttp3.OkHttpClient client(int r2, long r3) {
            r1 = this;
            okhttp3.OkHttpClient$Builder r0 = new okhttp3.OkHttpClient$Builder
            r0.<init>()
            java.net.Proxy r2 = r1.socks(r2)
            r0.e(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.b(r3, r2)
            r0.g(r3, r2)
            r0.a(r3, r2)
            r2 = 0
            r0.f29106f = r2
            okhttp3.OkHttpClient r2 = new okhttp3.OkHttpClient
            r2.<init>(r0)
            return r2
    }

    public static /* synthetic */ java.lang.Comparable d(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r0) {
            java.lang.Comparable r0 = rows$lambda$118(r0)
            return r0
    }

    private final java.lang.String decodeHtml(java.lang.String r4) {
            r3 = this;
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "<br\\s*/?>"
            kotlin.text.m r2 = kotlin.text.m.IGNORE_CASE
            r0.<init>(r1, r2)
            java.lang.String r1 = "\n"
            java.lang.String r4 = r0.replace(r4, r1)
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "<[^>]+>"
            r0.<init>(r1)
            java.lang.String r1 = ""
            java.lang.String r4 = r0.replace(r4, r1)
            java.lang.String r0 = "&lt;"
            java.lang.String r1 = "<"
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            java.lang.String r0 = "&gt;"
            java.lang.String r1 = ">"
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            java.lang.String r0 = "&quot;"
            java.lang.String r1 = "\""
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            java.lang.String r0 = "&#39;"
            java.lang.String r1 = "'"
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            java.lang.String r0 = "&nbsp;"
            java.lang.String r1 = " "
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "&#(\\d+);"
            r0.<init>(r1)
            com.mlmvpn.scanner.engines.argo.d r1 = new com.mlmvpn.scanner.engines.argo.d
            r2 = 2
            r1.<init>(r2)
            java.lang.String r4 = r0.replace(r4, r1)
            java.lang.String r0 = "&amp;"
            java.lang.String r1 = "&"
            java.lang.String r4 = kotlin.text.v.q0(r4, r0, r1)
            return r4
    }

    private static final java.lang.CharSequence decodeHtml$lambda$42(kotlin.text.g r1) {
            java.lang.String r0 = "m"
            kotlin.jvm.internal.j.e(r1, r0)
            kotlin.text.i r1 = (kotlin.text.i) r1
            java.util.List r1 = r1.a()
            r0 = 1
            kotlin.collections.f0 r1 = (kotlin.collections.f0) r1
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Integer r1 = kotlin.text.v.v0(r1)
            if (r1 == 0) goto L2d
            int r1 = r1.intValue()
            char[] r1 = java.lang.Character.toChars(r1)
            java.lang.String r0 = "toChars(...)"
            kotlin.jvm.internal.j.d(r1, r0)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            return r0
        L2d:
            java.lang.String r1 = ""
            return r1
    }

    private final sd.j download(int r8, java.lang.String r9, long r10, long r12, boolean r14) {
            r7 = this;
            r0 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.String r3 = "bytes=0-"
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> L2f
            r4.<init>()     // Catch: java.lang.Throwable -> L2f
            r4.j(r9)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = "User-Agent"
            java.lang.String r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.CARRY_UA     // Catch: java.lang.Throwable -> L2f
            r4.d(r9, r5)     // Catch: java.lang.Throwable -> L2f
            if (r14 == 0) goto L31
            java.lang.String r9 = "Range"
            r5 = 1
            long r5 = r10 - r5
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r14.<init>(r3)     // Catch: java.lang.Throwable -> L2f
            r14.append(r5)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r14 = r14.toString()     // Catch: java.lang.Throwable -> L2f
            r4.d(r9, r14)     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r8 = move-exception
            goto L90
        L31:
            okhttp3.Request r9 = new okhttp3.Request     // Catch: java.lang.Throwable -> L2f
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L2f
            okhttp3.OkHttpClient r8 = r7.client(r8, r12)     // Catch: java.lang.Throwable -> L2f
            okhttp3.internal.connection.RealCall r8 = r8.b(r9)     // Catch: java.lang.Throwable -> L2f
            okhttp3.Response r8 = r8.d()     // Catch: java.lang.Throwable -> L2f
            okhttp3.ResponseBody r9 = r8.f29156h     // Catch: java.lang.Throwable -> L69
            int r12 = r8.f29153d
            if (r9 == 0) goto L79
            we.j r9 = r9.j()     // Catch: java.lang.Throwable -> L69
            if (r9 != 0) goto L4f
            goto L79
        L4f:
            we.h r13 = new we.h     // Catch: java.lang.Throwable -> L69
            r13.<init>()     // Catch: java.lang.Throwable -> L69
            r3 = r0
        L55:
            int r14 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r14 >= 0) goto L6b
            r5 = 65536(0x10000, double:3.2379E-319)
            long r5 = r9.s(r13, r5)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6b
            int r14 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r14 < 0) goto L6b
            long r3 = r3 + r5
            r13.c()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6b
            goto L55
        L69:
            r9 = move-exception
            goto L8a
        L6b:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L69
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L69
            sd.j r11 = new sd.j     // Catch: java.lang.Throwable -> L69
            r11.<init>(r9, r10)     // Catch: java.lang.Throwable -> L69
            goto L82
        L79:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L69
            sd.j r11 = new sd.j     // Catch: java.lang.Throwable -> L69
            r11.<init>(r9, r2)     // Catch: java.lang.Throwable -> L69
        L82:
            r8.close()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = sd.l.m1004constructorimpl(r11)     // Catch: java.lang.Throwable -> L2f
            goto L98
        L8a:
            throw r9     // Catch: java.lang.Throwable -> L8b
        L8b:
            r10 = move-exception
            a.a.g(r8, r9)     // Catch: java.lang.Throwable -> L2f
            throw r10     // Catch: java.lang.Throwable -> L2f
        L90:
            sd.l$a r8 = sd.m.a(r8)
            java.lang.Object r8 = sd.l.m1004constructorimpl(r8)
        L98:
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            sd.j r10 = new sd.j
            r10.<init>(r9, r2)
            boolean r9 = sd.l.m1010isFailureimpl(r8)
            if (r9 == 0) goto La9
            r8 = r10
        La9:
            sd.j r8 = (sd.j) r8
            return r8
    }

    public static /* synthetic */ java.lang.Comparable e(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r0) {
            java.lang.Comparable r0 = rows$lambda$119(r0)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint endpointOf(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r7) {
            r6 = this;
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = new com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint
            java.lang.String r1 = r7.getId()
            java.lang.String r2 = r7.getKind()
            java.lang.String r3 = r7.getHost()
            int r4 = r7.getPort()
            java.lang.String r5 = r7.getProtocol()
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
    }

    public static /* synthetic */ java.lang.Comparable f(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r0) {
            java.lang.Comparable r0 = summary$lambda$106(r0)
            return r0
    }

    private final int freePort() {
            r3 = this;
            java.net.ServerSocket r0 = new java.net.ServerSocket
            r1 = 0
            r0.<init>(r1)
            int r1 = r0.getLocalPort()     // Catch: java.lang.Throwable -> Le
            r0.close()
            return r1
        Le:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L10
        L10:
            r2 = move-exception
            a.a.g(r0, r1)
            throw r2
    }

    public static /* synthetic */ java.lang.Comparable g(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r0) {
            java.lang.Comparable r0 = summary$lambda$105(r0)
            return r0
    }

    private final java.lang.String githubRaw(java.lang.String r5) {
            r4 = this;
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "^https?://github\\.com/([^/]+)/([^/]+)/(?:blob|raw)/(.+)$"
            kotlin.text.m r2 = kotlin.text.m.IGNORE_CASE
            r0.<init>(r1, r2)
            r1 = 0
            r2 = 0
            r3 = 2
            kotlin.text.g r0 = kotlin.text.l.find$default(r0, r5, r2, r3, r1)
            if (r0 != 0) goto L13
            return r5
        L13:
            kotlin.text.i r0 = (kotlin.text.i) r0
            java.util.List r5 = r0.a()
            r1 = 1
            kotlin.collections.f0 r5 = (kotlin.collections.f0) r5
            java.lang.Object r5 = r5.get(r1)
            java.util.List r1 = r0.a()
            kotlin.collections.f0 r1 = (kotlin.collections.f0) r1
            java.lang.Object r1 = r1.get(r3)
            java.util.List r0 = r0.a()
            r2 = 3
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "https://raw.githubusercontent.com/"
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r5 = "/"
            r2.append(r5)
            r2.append(r1)
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            return r5
    }

    public static /* synthetic */ java.lang.Comparable h(com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin r0) {
            java.lang.Comparable r0 = summary$lambda$111(r0)
            return r0
    }

    private final int harvestOfficial(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r20, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r21) {
            r19 = this;
            java.lang.String r0 = r20.getType()
            java.lang.String r1 = "snowcfg"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == 0) goto L9b
            java.util.List r0 = r20.getValue()
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L93
            java.lang.Object r3 = r0.next()
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            com.mlmvpn.scanner.engines.argo.ArgoNet r4 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
            r11 = 12
            r12 = 0
            r7 = 0
            r9 = 0
            r6 = r21
            sd.j r3 = com.mlmvpn.scanner.engines.argo.ArgoNet.fetchText$default(r4, r5, r6, r7, r9, r11, r12)
            java.lang.Object r4 = r3.component1()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r3 = r3.component2()
            java.lang.String r3 = (java.lang.String) r3
            if (r4 != r1) goto L17
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r4 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L17
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Snowcfg r3 = r4.decodeSnowcfg(r3)     // Catch: java.lang.Throwable -> L17
            boolean r5 = r3.getSigOk()     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L17
            sf.c r5 = r3.getParams()     // Catch: java.lang.Throwable -> L17
            java.util.List r4 = r4.publicServersOf(r5)     // Catch: java.lang.Throwable -> L17
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L17
            r5 = r2
        L5e:
            boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L92
            java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L17
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$PublicServer r6 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.PublicServer) r6     // Catch: java.lang.Throwable -> L17
            java.lang.String r8 = "public"
            java.lang.String r9 = r6.getHost()     // Catch: java.lang.Throwable -> L17
            int r10 = r6.getPort()     // Catch: java.lang.Throwable -> L17
            java.lang.String r11 = "A"
            java.lang.String r12 = r20.getId()     // Catch: java.lang.Throwable -> L17
            long r13 = r3.getIssuedMs()     // Catch: java.lang.Throwable -> L17
            java.lang.String r16 = r6.getProfile()     // Catch: java.lang.Throwable -> L17
            r17 = 64
            r18 = 0
            r15 = 0
            r7 = r19
            boolean r6 = addItem$default(r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L5e
            int r5 = r5 + 1
            goto L5e
        L92:
            return r5
        L93:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "هیچ\u200cکدام از نشانی\u200cهای فهرست رسمی جواب نداد"
            r0.<init>(r1)
            throw r0
        L9b:
            java.lang.String r0 = r20.getType()
            java.lang.String r3 = "falcon-servers"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r3)
            if (r0 == 0) goto L16e
            java.util.List r0 = r20.getValue()
            java.util.Iterator r0 = r0.iterator()
        Laf:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L164
            java.lang.Object r3 = r0.next()
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            com.mlmvpn.scanner.engines.argo.ArgoNet r4 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
            r11 = 12
            r12 = 0
            r7 = 0
            r9 = 0
            r6 = r21
            sd.j r3 = com.mlmvpn.scanner.engines.argo.ArgoNet.fetchText$default(r4, r5, r6, r7, r9, r11, r12)
            java.lang.Object r4 = r3.component1()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r3 = r3.component2()
            java.lang.String r3 = (java.lang.String) r3
            if (r4 != r1) goto L160
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r4 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L160
            java.util.List r3 = r4.decodeFalconServers(r3)     // Catch: java.lang.Throwable -> L160
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: java.lang.Throwable -> L160
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L160
            if (r4 != 0) goto L160
            com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers = r3     // Catch: java.lang.Throwable -> L160
            java.lang.String r4 = "remote.json"
            sf.c r5 = new sf.c     // Catch: java.lang.Throwable -> L160
            r5.<init>()     // Catch: java.lang.Throwable -> L160
            java.lang.String r6 = "at"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L160
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L160
            r5.D(r6, r7)     // Catch: java.lang.Throwable -> L160
            java.lang.String r6 = "falconServers"
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L160
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L160
            r8 = 10
            int r8 = kotlin.collections.s.g0(r3, r8)     // Catch: java.lang.Throwable -> L160
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L160
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L160
        L115:
            boolean r8 = r3.hasNext()     // Catch: java.lang.Throwable -> L160
            if (r8 == 0) goto L149
            java.lang.Object r8 = r3.next()     // Catch: java.lang.Throwable -> L160
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin r8 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin) r8     // Catch: java.lang.Throwable -> L160
            sf.c r9 = new sf.c     // Catch: java.lang.Throwable -> L160
            r9.<init>()     // Catch: java.lang.Throwable -> L160
            java.lang.String r10 = "ip"
            java.lang.String r11 = r8.getIp()     // Catch: java.lang.Throwable -> L160
            r9.D(r10, r11)     // Catch: java.lang.Throwable -> L160
            java.lang.String r10 = "cc"
            java.lang.String r11 = r8.getCc()     // Catch: java.lang.Throwable -> L160
            r9.D(r10, r11)     // Catch: java.lang.Throwable -> L160
            java.lang.String r10 = "load"
            double r11 = r8.getLoad()     // Catch: java.lang.Throwable -> L160
            java.lang.Double r8 = java.lang.Double.valueOf(r11)     // Catch: java.lang.Throwable -> L160
            r9.D(r10, r8)     // Catch: java.lang.Throwable -> L160
            r7.add(r9)     // Catch: java.lang.Throwable -> L160
            goto L115
        L149:
            sf.a r3 = new sf.a     // Catch: java.lang.Throwable -> L160
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L160
            r5.D(r6, r3)     // Catch: java.lang.Throwable -> L160
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L160
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.j.d(r3, r5)     // Catch: java.lang.Throwable -> L160
            r7 = r19
            r7.writeJson(r4, r3)     // Catch: java.lang.Throwable -> Laf
            goto L170
        L160:
            r7 = r19
            goto Laf
        L164:
            r7 = r19
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "فهرست سرورهای فالکن گرفته نشد"
            r0.<init>(r1)
            throw r0
        L16e:
            r7 = r19
        L170:
            return r2
    }

    private final java.lang.Object harvestTelegram(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r29, int r30, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r31, ee.e r32, ee.a r33, wd.d r34) {
            r28 = this;
            r0 = r34
            boolean r1 = r0 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.AnonymousClass1
            if (r1 == 0) goto L17
            r1 = r0
            com.mlmvpn.scanner.engines.argo.ArgoPool$harvestTelegram$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r28
            goto L1e
        L17:
            com.mlmvpn.scanner.engines.argo.ArgoPool$harvestTelegram$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$harvestTelegram$1
            r2 = r28
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r4 = r1.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L8d
            if (r4 == r6) goto L68
            if (r4 != r5) goto L60
            int r4 = r1.I$3
            int r8 = r1.I$2
            int r9 = r1.I$1
            int r10 = r1.I$0
            java.lang.Object r11 = r1.L$5
            java.lang.Long r11 = (java.lang.Long) r11
            java.lang.Object r12 = r1.L$4
            ee.a r12 = (ee.a) r12
            java.lang.Object r13 = r1.L$3
            ee.e r13 = (ee.e) r13
            java.lang.Object r14 = r1.L$2
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r14 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Route) r14
            java.lang.Object r15 = r1.L$1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r15 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r15
            java.lang.Object r7 = r1.L$0
            com.mlmvpn.scanner.engines.argo.ArgoPool r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool) r7
            sd.m.b(r0)
            r0 = r13
            r13 = r4
            r4 = r0
            r26 = r6
            r0 = r15
            r15 = r9
            r9 = r11
            r11 = r12
            r12 = r1
            r1 = r10
            r10 = r14
            r14 = r8
            r8 = r3
            r3 = r5
            goto L277
        L60:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L68:
            int r4 = r1.I$3
            int r7 = r1.I$2
            int r8 = r1.I$1
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$5
            java.lang.Long r10 = (java.lang.Long) r10
            java.lang.Object r11 = r1.L$4
            ee.a r11 = (ee.a) r11
            java.lang.Object r12 = r1.L$3
            ee.e r12 = (ee.e) r12
            java.lang.Object r13 = r1.L$2
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r13 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Route) r13
            java.lang.Object r14 = r1.L$1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r14 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r14
            java.lang.Object r15 = r1.L$0
            com.mlmvpn.scanner.engines.argo.ArgoPool r15 = (com.mlmvpn.scanner.engines.argo.ArgoPool) r15
            sd.m.b(r0)
            goto Le9
        L8d:
            sd.m.b(r0)
            r0 = 0
            r10 = r31
            r4 = r32
            r11 = r33
            r9 = r0
            r12 = r1
            r7 = r2
            r13 = 0
            r14 = 0
            r15 = 0
            r0 = r29
            r1 = r30
        La1:
            if (r15 >= r1) goto L289
            java.lang.Object r8 = r11.invoke()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L289
            java.util.List r8 = r0.getValue()
            java.lang.Object r8 = kotlin.collections.q.y0(r8)
            java.lang.String r8 = (java.lang.String) r8
            r12.L$0 = r7
            r12.L$1 = r0
            r12.L$2 = r10
            r12.L$3 = r4
            r12.L$4 = r11
            r12.L$5 = r9
            r12.I$0 = r1
            r12.I$1 = r15
            r12.I$2 = r14
            r12.I$3 = r13
            r12.label = r6
            java.lang.Object r8 = r7.telegramPageRetry(r8, r9, r10, r11, r12)
            if (r8 != r3) goto Ld8
            r8 = r3
            goto L26b
        Ld8:
            r27 = r14
            r14 = r0
            r0 = r8
            r8 = r15
            r15 = r7
            r7 = r27
            r27 = r9
            r9 = r1
            r1 = r12
            r12 = r4
            r4 = r13
            r13 = r10
            r10 = r27
        Le9:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Page) r0
            boolean r16 = r0.getOk()
            if (r16 != 0) goto L121
            if (r8 != 0) goto L11d
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r3 = r0.getCode()
            if (r3 != 0) goto L10d
            if (r13 == 0) goto L10a
            java.lang.String r0 = r13.getLabel()
            java.lang.String r3 = "تلگرام از راه «"
            java.lang.String r4 = "» هم جواب نداد — اتصال همان موتور را بررسی کنید"
            java.lang.String r0 = a6.w0.n(r3, r0, r4)
            goto L119
        L10a:
            java.lang.String r0 = "تلگرام روی این اینترنت فیلتر است — اول یکی از موتورها (یا خود آرگو) را وصل کنید و دوباره «به\u200cروزرسانی» را بزنید"
            goto L119
        L10d:
            int r0 = r0.getCode()
            java.lang.String r3 = "کانال جواب نداد (کد "
            java.lang.String r4 = ") — نام کانال را بررسی کنید"
            java.lang.String r0 = androidx.compose.foundation.interaction.f.o(r0, r3, r4)
        L119:
            r1.<init>(r0)
            throw r1
        L11d:
            r29 = r7
            goto L287
        L121:
            java.util.List r16 = r0.getPosts()
            boolean r16 = r16.isEmpty()
            if (r16 != 0) goto L11d
            java.util.List r16 = r0.getPosts()
            java.util.Iterator r24 = r16.iterator()
            r25 = 0
        L135:
            boolean r16 = r24.hasNext()
            r26 = r6
            r29 = r7
            if (r16 == 0) goto L1bb
            java.lang.Object r16 = r24.next()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Post r16 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Post) r16
            java.lang.String r5 = r16.getText()
            int r17 = r5.length()
            if (r17 != 0) goto L155
            r7 = r29
        L151:
            r6 = r26
            r5 = 2
            goto L135
        L155:
            r30 = 0
            kotlin.text.l r6 = new kotlin.text.l
            java.lang.String r7 = "فالکن|falcon"
            r32 = r0
            kotlin.text.m r0 = kotlin.text.m.IGNORE_CASE
            r6.<init>(r7, r0)
            boolean r0 = r6.containsMatchIn(r5)
            if (r0 == 0) goto L169
            goto L185
        L169:
            java.util.List r0 = kotlin.text.o.Q0(r5)
            r17 = r0
            java.lang.Iterable r17 = (java.lang.Iterable) r17
            com.mlmvpn.scanner.engines.argo.d r0 = new com.mlmvpn.scanner.engines.argo.d
            r5 = 3
            r0.<init>(r5)
            r22 = 30
            java.lang.String r18 = "\n"
            r19 = 0
            r20 = 0
            r21 = r0
            java.lang.String r5 = kotlin.collections.q.F0(r17, r18, r19, r20, r21, r22)
        L185:
            java.lang.String r17 = r14.getId()
            long r6 = r16.getAt()
            int r0 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
            if (r0 <= 0) goto L198
            long r6 = r16.getAt()
        L195:
            r18 = r6
            goto L19d
        L198:
            long r6 = java.lang.System.currentTimeMillis()
            goto L195
        L19d:
            r22 = 24
            r23 = 0
            r20 = 0
            r21 = 0
            r16 = r5
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r0 = absorbText$default(r15, r16, r17, r18, r20, r21, r22, r23)
            int r5 = r0.getBridges()
            int r0 = r0.getFalcons()
            int r0 = r0 + r5
            int r25 = r0 + r25
            r7 = r29
            r0 = r32
            goto L151
        L1bb:
            r32 = r0
            r30 = 0
            int r0 = r29 + r25
            int r5 = r8 + 1
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r0)
            r12.invoke(r6, r7)
            if (r25 <= 0) goto L1d4
            r4 = 0
            goto L1d6
        L1d4:
            int r4 = r4 + 1
        L1d6:
            r6 = 6
            if (r4 < r6) goto L1fa
            java.util.HashMap<java.lang.String, sf.c> r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState
            java.lang.String r7 = r14.getId()
            java.lang.Object r6 = r6.get(r7)
            sf.c r6 = (sf.c) r6
            if (r6 == 0) goto L1f1
            java.lang.String r7 = "at"
            r8 = r3
            r2 = r30
            long r6 = r6.x(r2, r7)
            goto L1f5
        L1f1:
            r8 = r3
            r2 = r30
            r6 = r2
        L1f5:
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 > 0) goto L27f
            goto L1fb
        L1fa:
            r8 = r3
        L1fb:
            java.util.List r2 = r32.getPosts()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L281
            java.lang.Object r3 = r2.next()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Post r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Post) r3
            long r6 = r3.getId()
        L215:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L22c
            java.lang.Object r3 = r2.next()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Post r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Post) r3
            long r16 = r3.getId()
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r3 <= 0) goto L215
            r6 = r16
            goto L215
        L22c:
            if (r10 == 0) goto L236
            long r2 = r10.longValue()
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L27f
        L236:
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r6)
            r16 = 1
            int r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r3 <= 0) goto L27f
            java.security.SecureRandom r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.random
            r6 = 600(0x258, float:8.41E-43)
            int r3 = r3.nextInt(r6)
            long r6 = (long) r3
            r16 = 600(0x258, double:2.964E-321)
            long r6 = r6 + r16
            r1.L$0 = r15
            r1.L$1 = r14
            r1.L$2 = r13
            r1.L$3 = r12
            r1.L$4 = r11
            r1.L$5 = r2
            r1.I$0 = r9
            r1.I$1 = r5
            r1.I$2 = r0
            r1.I$3 = r4
            r3 = 2
            r1.label = r3
            java.lang.Object r6 = kotlinx.coroutines.m0.j(r6, r1)
            if (r6 != r8) goto L26c
        L26b:
            return r8
        L26c:
            r7 = r14
            r14 = r0
            r0 = r7
            r10 = r13
            r7 = r15
            r13 = r4
            r15 = r5
            r4 = r12
            r12 = r1
            r1 = r9
            r9 = r2
        L277:
            r2 = r28
            r5 = r3
            r3 = r8
            r6 = r26
            goto La1
        L27f:
            r14 = r0
            goto L289
        L281:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        L287:
            r14 = r29
        L289:
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r14)
            return r0
    }

    private static final java.lang.CharSequence harvestTelegram$lambda$47(java.lang.String r2) {
            java.lang.String r0 = "line"
            kotlin.jvm.internal.j.e(r2, r0)
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r1 = "BRIDGE BLOCK|^[A-Za-z0-9+/=]{20,}$"
            r0.<init>(r1)
            java.lang.CharSequence r1 = kotlin.text.o.n1(r2)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.containsMatchIn(r1)
            if (r0 == 0) goto L1b
            return r2
        L1b:
            java.lang.String r2 = ""
            return r2
    }

    private final int harvestUrl(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r27, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r28, ee.a r29) {
            r26 = this;
            r1 = r26
            java.util.List r0 = r27.getValue()
            java.lang.Object r0 = kotlin.collections.q.y0(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = r1.githubRaw(r0)
            java.util.List r2 = m9.d.B(r2)
            kotlin.text.l r3 = new kotlin.text.l
            kotlin.text.m r4 = kotlin.text.m.IGNORE_CASE
            java.lang.String r5 = "^https?://github\\.com/([^/]+)/([^/#?]+)/?$"
            r3.<init>(r5, r4)
            r10 = 0
            r5 = 2
            r6 = 0
            kotlin.text.g r3 = kotlin.text.l.find$default(r3, r0, r10, r5, r6)
            kotlin.text.l r7 = new kotlin.text.l
            java.lang.String r8 = "^https?://github\\.com/([^/]+)/([^/#?]+)/(issues|discussions)"
            r7.<init>(r8, r4)
            kotlin.text.g r0 = kotlin.text.l.find$default(r7, r0, r10, r5, r6)
            r11 = 10
            java.lang.String r12 = ")"
            java.lang.String r4 = "/"
            java.lang.String r7 = "https://api.github.com/repos/"
            java.lang.String r13 = ""
            r14 = 1
            if (r0 == 0) goto L98
            kotlin.text.i r0 = (kotlin.text.i) r0
            java.util.List r2 = r0.a()
            kotlin.collections.f0 r2 = (kotlin.collections.f0) r2
            java.lang.Object r2 = r2.get(r14)
            java.util.List r0 = r0.a()
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r7)
            r3.append(r2)
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            je.h r2 = new je.h
            r3 = 3
            r2.<init>(r14, r3, r14)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            je.g r2 = r2.a()
        L73:
            boolean r4 = r2.f23130c
            if (r4 == 0) goto L95
            int r4 = r2.nextInt()
            java.lang.String r5 = "/issues?state=all&per_page=100&page="
            java.lang.String r5 = f0.a.i(r4, r0, r5)
            java.lang.String r6 = "/issues/comments?per_page=100&page="
            java.lang.String r4 = f0.a.i(r4, r0, r6)
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            java.util.List r4 = kotlin.collections.r.a0(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.collections.q.m0(r3, r4)
            goto L73
        L95:
            r14 = r3
            goto L1ca
        L98:
            if (r3 == 0) goto L1bc
            com.mlmvpn.scanner.engines.argo.ArgoNet r15 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
            kotlin.text.i r3 = (kotlin.text.i) r3
            java.util.List r0 = r3.a()
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r14)
            java.util.List r2 = r3.a()
            kotlin.collections.f0 r2 = (kotlin.collections.f0) r2
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = ".git"
            java.lang.String r2 = kotlin.text.o.V0(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r7)
            r3.append(r0)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r0 = "/contents"
            r3.append(r0)
            java.lang.String r16 = r3.toString()
            r22 = 12
            r23 = 0
            r18 = 0
            r20 = 0
            r17 = r28
            sd.j r0 = com.mlmvpn.scanner.engines.argo.ArgoNet.fetchText$default(r15, r16, r17, r18, r20, r22, r23)
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.String r0 = (java.lang.String) r0
            sf.a r3 = new sf.a     // Catch: java.lang.Throwable -> Lf9
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lf9
            java.lang.Object r0 = sd.l.m1004constructorimpl(r3)     // Catch: java.lang.Throwable -> Lf9
            goto L102
        Lf9:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        L102:
            boolean r3 = sd.l.m1010isFailureimpl(r0)
            if (r3 == 0) goto L109
            goto L10a
        L109:
            r6 = r0
        L10a:
            sf.a r6 = (sf.a) r6
            if (r6 == 0) goto L1be
            java.util.ArrayList r0 = r6.f67155a
            int r0 = r0.size()
            je.h r0 = com.google.android.gms.internal.mlkit_language_id_common.j.J(r10, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            je.g r0 = r0.a()
        L121:
            boolean r3 = r0.f23130c
            if (r3 == 0) goto L133
            int r3 = r0.nextInt()
            sf.c r3 = r6.q(r3)
            if (r3 == 0) goto L121
            r2.add(r3)
            goto L121
        L133:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r3 = r2.size()
            r4 = r10
        L13d:
            java.lang.String r5 = "download_url"
            if (r4 >= r3) goto L193
            java.lang.Object r6 = r2.get(r4)
            int r4 = r4 + 1
            r7 = r6
            sf.c r7 = (sf.c) r7
            java.lang.String r8 = "type"
            java.lang.String r8 = r7.A(r8, r13)
            java.lang.String r9 = "file"
            boolean r8 = kotlin.jvm.internal.j.a(r8, r9)
            if (r8 == 0) goto L191
            java.lang.String r5 = r7.A(r5, r13)
            java.lang.String r8 = "optString(...)"
            kotlin.jvm.internal.j.d(r5, r8)
            boolean r5 = kotlin.text.o.L0(r5)
            if (r5 != 0) goto L191
            java.lang.String r5 = "size"
            r14 = 0
            long r14 = r7.x(r14, r5)
            r16 = 8000000(0x7a1200, double:3.952525E-317)
            int r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r5 >= 0) goto L191
            kotlin.text.l r5 = new kotlin.text.l
            java.lang.String r9 = "\\.(png|jpe?g|gif|webp|zip|apk|exe|pdf)$"
            kotlin.text.m r14 = kotlin.text.m.IGNORE_CASE
            r5.<init>(r9, r14)
            java.lang.String r9 = "name"
            java.lang.String r7 = r7.A(r9, r13)
            kotlin.jvm.internal.j.d(r7, r8)
            boolean r5 = r5.containsMatchIn(r7)
            if (r5 != 0) goto L191
            r0.add(r6)
        L191:
            r14 = 1
            goto L13d
        L193:
            r2 = 30
            java.util.List r0 = kotlin.collections.q.e1(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = kotlin.collections.s.g0(r0, r11)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L1a8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1bc
            java.lang.Object r3 = r0.next()
            sf.c r3 = (sf.c) r3
            java.lang.String r3 = r3.A(r5, r13)
            r2.add(r3)
            goto L1a8
        L1bc:
            r14 = r2
            goto L1ca
        L1be:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = "مخزن گیت\u200cهاب خوانده نشد (کد "
            java.lang.String r2 = androidx.compose.foundation.interaction.f.o(r2, r3, r12)
            r0.<init>(r2)
            throw r0
        L1ca:
            java.util.Iterator r24 = r14.iterator()
            r25 = r10
        L1d0:
            boolean r0 = r24.hasNext()
            if (r0 == 0) goto L321
            java.lang.Object r0 = r24.next()
            r16 = r0
            java.lang.String r16 = (java.lang.String) r16
            java.lang.Object r0 = r29.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L321
            com.mlmvpn.scanner.engines.argo.ArgoNet r15 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
            r22 = 12
            r23 = 0
            r18 = 0
            r20 = 0
            r17 = r28
            sd.j r0 = com.mlmvpn.scanner.engines.argo.ArgoNet.fetchText$default(r15, r16, r17, r18, r20, r22, r23)
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.String r0 = (java.lang.String) r0
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L30d
            int r3 = r0.length()
            if (r3 != 0) goto L216
            goto L30d
        L216:
            kotlin.jvm.internal.y r2 = new kotlin.jvm.internal.y
            r2.<init>()
            r2.element = r0
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r3 = "^\\s*[\\[{]"
            r0.<init>(r3)
            java.lang.Object r3 = r2.element
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = r0.containsMatchIn(r3)
            sd.u r3 = sd.u.f67154a
            if (r0 == 0) goto L288
            java.lang.Object r0 = r2.element     // Catch: java.lang.Throwable -> L24e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L24e
            java.lang.CharSequence r0 = kotlin.text.o.r1(r0)     // Catch: java.lang.Throwable -> L24e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L24e
            java.lang.String r4 = "["
            boolean r0 = kotlin.text.v.s0(r0, r4, r10)     // Catch: java.lang.Throwable -> L24e
            if (r0 == 0) goto L250
            sf.a r0 = new sf.a     // Catch: java.lang.Throwable -> L24e
            java.lang.Object r4 = r2.element     // Catch: java.lang.Throwable -> L24e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L24e
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L24e
            goto L259
        L24e:
            r0 = move-exception
            goto L281
        L250:
            sf.c r0 = new sf.c     // Catch: java.lang.Throwable -> L24e
            java.lang.Object r4 = r2.element     // Catch: java.lang.Throwable -> L24e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L24e
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L24e
        L259:
            boolean r4 = r0 instanceof sf.a     // Catch: java.lang.Throwable -> L24e
            if (r4 == 0) goto L268
            r4 = r0
            sf.a r4 = (sf.a) r4     // Catch: java.lang.Throwable -> L24e
            java.util.ArrayList r4 = r4.f67155a     // Catch: java.lang.Throwable -> L24e
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L24e
            if (r4 == 0) goto L27d
        L268:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L24e
            r4.<init>()     // Catch: java.lang.Throwable -> L24e
            r1.jsonStrings(r0, r4)     // Catch: java.lang.Throwable -> L24e
            java.lang.String r5 = "\n"
            r8 = 0
            r9 = 62
            r6 = 0
            r7 = 0
            java.lang.String r0 = kotlin.collections.q.F0(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L24e
            r2.element = r0     // Catch: java.lang.Throwable -> L24e
        L27d:
            sd.l.m1004constructorimpl(r3)     // Catch: java.lang.Throwable -> L24e
            goto L288
        L281:
            sd.l$a r0 = sd.m.a(r0)
            sd.l.m1004constructorimpl(r0)
        L288:
            java.lang.Object r0 = r2.element
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.l r4 = new kotlin.text.l
            java.lang.String r5 = "\\s+"
            r4.<init>(r5)
            java.lang.String r0 = r4.replace(r0, r13)
            java.lang.String r4 = "^[A-Za-z0-9+/=]{40,}$"
            boolean r4 = com.mlmvpn.core.aether.i.B(r4, r0)
            if (r4 == 0) goto L2e8
            java.lang.String r4 = "eJ"
            boolean r4 = kotlin.text.v.s0(r0, r4, r10)
            if (r4 != 0) goto L2e8
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L2c3
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r5 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L2c3
            byte[] r0 = r5.b64(r0)     // Catch: java.lang.Throwable -> L2c3
            java.nio.charset.Charset r5 = kotlin.text.a.f23859a     // Catch: java.lang.Throwable -> L2c3
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L2c3
            boolean r0 = kotlin.text.o.z0(r4, r11)     // Catch: java.lang.Throwable -> L2c3
            if (r0 != 0) goto L2c5
            r0 = 46
            boolean r0 = kotlin.text.o.z0(r4, r0)     // Catch: java.lang.Throwable -> L2c3
            if (r0 == 0) goto L2dd
            goto L2c5
        L2c3:
            r0 = move-exception
            goto L2e1
        L2c5:
            java.lang.Object r0 = r2.element     // Catch: java.lang.Throwable -> L2c3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c3
            r5.<init>()     // Catch: java.lang.Throwable -> L2c3
            r5.append(r0)     // Catch: java.lang.Throwable -> L2c3
            java.lang.String r0 = "\n"
            r5.append(r0)     // Catch: java.lang.Throwable -> L2c3
            r5.append(r4)     // Catch: java.lang.Throwable -> L2c3
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L2c3
            r2.element = r0     // Catch: java.lang.Throwable -> L2c3
        L2dd:
            sd.l.m1004constructorimpl(r3)     // Catch: java.lang.Throwable -> L2c3
            goto L2e8
        L2e1:
            sd.l$a r0 = sd.m.a(r0)
            sd.l.m1004constructorimpl(r0)
        L2e8:
            java.lang.Object r0 = r2.element
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = r27.getId()
            long r4 = java.lang.System.currentTimeMillis()
            r8 = 16
            r9 = 0
            r6 = 1
            r7 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r0 = absorbText$default(r1, r2, r3, r4, r6, r7, r8, r9)
            int r1 = r0.getBridges()
            int r0 = r0.getFalcons()
            int r0 = r0 + r1
            int r25 = r0 + r25
        L309:
            r1 = r26
            goto L1d0
        L30d:
            int r0 = r14.size()
            r1 = 1
            if (r0 == r1) goto L315
            goto L309
        L315:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "نشانی جواب نداد (کد "
            java.lang.String r1 = androidx.compose.foundation.interaction.f.o(r2, r1, r12)
            r0.<init>(r1)
            throw r0
        L321:
            return r25
    }

    private final boolean hasGlobalV6() {
            r9 = this;
            java.lang.String r0 = "list(...)"
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "getNetworkInterfaces(...)"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L49
            java.util.ArrayList r1 = java.util.Collections.list(r1)     // Catch: java.lang.Throwable -> L49
            kotlin.jvm.internal.j.d(r1, r0)     // Catch: java.lang.Throwable -> L49
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L49
            r2.<init>()     // Catch: java.lang.Throwable -> L49
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L49
            r4 = 0
            r5 = r4
        L1d:
            if (r5 >= r3) goto L4c
            java.lang.Object r6 = r1.get(r5)     // Catch: java.lang.Throwable -> L49
            int r5 = r5 + 1
            r7 = r6
            java.net.NetworkInterface r7 = (java.net.NetworkInterface) r7     // Catch: java.lang.Throwable -> L49
            boolean r8 = r7.isUp()     // Catch: java.lang.Throwable -> L49
            if (r8 == 0) goto L1d
            boolean r8 = r7.isLoopback()     // Catch: java.lang.Throwable -> L49
            if (r8 != 0) goto L1d
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L49
            java.lang.String r8 = "getName(...)"
            kotlin.jvm.internal.j.d(r7, r8)     // Catch: java.lang.Throwable -> L49
            java.lang.String r8 = "tun"
            boolean r7 = kotlin.text.v.s0(r7, r8, r4)     // Catch: java.lang.Throwable -> L49
            if (r7 != 0) goto L1d
            r2.add(r6)     // Catch: java.lang.Throwable -> L49
            goto L1d
        L49:
            r0 = move-exception
            goto Lc1
        L4c:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L49
            r1.<init>()     // Catch: java.lang.Throwable -> L49
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L49
            r5 = r4
        L56:
            if (r5 >= r3) goto L74
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> L49
            int r5 = r5 + 1
            java.net.NetworkInterface r6 = (java.net.NetworkInterface) r6     // Catch: java.lang.Throwable -> L49
            java.util.Enumeration r6 = r6.getInetAddresses()     // Catch: java.lang.Throwable -> L49
            java.lang.String r7 = "getInetAddresses(...)"
            kotlin.jvm.internal.j.d(r6, r7)     // Catch: java.lang.Throwable -> L49
            java.util.ArrayList r6 = java.util.Collections.list(r6)     // Catch: java.lang.Throwable -> L49
            kotlin.jvm.internal.j.d(r6, r0)     // Catch: java.lang.Throwable -> L49
            kotlin.collections.q.m0(r1, r6)     // Catch: java.lang.Throwable -> L49
            goto L56
        L74:
            boolean r0 = r1.isEmpty()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L7b
            goto Lb8
        L7b:
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L49
            r2 = r4
        L80:
            if (r2 >= r0) goto Lb8
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L49
            int r2 = r2 + 1
            java.net.InetAddress r3 = (java.net.InetAddress) r3     // Catch: java.lang.Throwable -> L49
            boolean r5 = r3 instanceof java.net.Inet6Address     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L80
            r5 = r3
            java.net.Inet6Address r5 = (java.net.Inet6Address) r5     // Catch: java.lang.Throwable -> L49
            boolean r5 = r5.isLinkLocalAddress()     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L80
            r5 = r3
            java.net.Inet6Address r5 = (java.net.Inet6Address) r5     // Catch: java.lang.Throwable -> L49
            boolean r5 = r5.isSiteLocalAddress()     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L80
            r5 = r3
            java.net.Inet6Address r5 = (java.net.Inet6Address) r5     // Catch: java.lang.Throwable -> L49
            boolean r5 = r5.isLoopbackAddress()     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L80
            java.net.Inet6Address r3 = (java.net.Inet6Address) r3     // Catch: java.lang.Throwable -> L49
            byte[] r3 = r3.getAddress()     // Catch: java.lang.Throwable -> L49
            r3 = r3[r4]     // Catch: java.lang.Throwable -> L49
            r3 = r3 & 224(0xe0, float:3.14E-43)
            r5 = 32
            if (r3 != r5) goto L80
            r4 = 1
        Lb8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L49
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L49
            goto Lc9
        Lc1:
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        Lc9:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r2 = sd.l.m1010isFailureimpl(r0)
            if (r2 == 0) goto Ld2
            r0 = r1
        Ld2:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
    }

    public static /* synthetic */ java.lang.Comparable i(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r0) {
            java.lang.Comparable r0 = rows$lambda$120(r0)
            return r0
    }

    private final java.lang.String idOf(java.lang.String r3, java.lang.String r4, int r5) {
            r2 = this;
            r0 = 0
            char r3 = r3.charAt(r0)
            r0 = 443(0x1bb, float:6.21E-43)
            java.lang.String r1 = ":"
            if (r5 == r0) goto L10
            java.lang.String r5 = f0.a.h(r5, r1)
            goto L12
        L10:
            java.lang.String r5 = ""
        L12:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r1)
            r0.append(r4)
            r0.append(r5)
            java.lang.String r3 = r0.toString()
            return r3
    }

    private final sf.c itemJson(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r4) {
            r3 = this;
            sf.c r0 = new sf.c
            r0.<init>()
            java.lang.String r1 = "id"
            java.lang.String r2 = r4.getId()
            r0.D(r1, r2)
            java.lang.String r1 = "kind"
            java.lang.String r2 = r4.getKind()
            r0.D(r1, r2)
            java.lang.String r1 = "host"
            java.lang.String r2 = r4.getHost()
            r0.D(r1, r2)
            int r1 = r4.getPort()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "port"
            r0.D(r2, r1)
            java.lang.String r1 = "protocol"
            java.lang.String r2 = r4.getProtocol()
            r0.D(r1, r2)
            java.lang.String r1 = "src"
            java.lang.String r2 = r4.getSrc()
            r0.D(r1, r2)
            java.lang.String r1 = "from"
            java.lang.String r2 = r4.getFrom()
            r0.D(r1, r2)
            long r1 = r4.getSeen()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "seen"
            r0.D(r2, r1)
            java.lang.String r1 = "user"
            boolean r2 = r4.getUser()
            r0.E(r1, r2)
            java.lang.String r1 = "profile"
            java.lang.String r2 = r4.getProfile()
            r0.D(r1, r2)
            java.lang.String r1 = "cc0"
            java.lang.String r2 = r4.getCc0()
            r0.D(r1, r2)
            long r1 = r4.getV0()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "v0"
            r0.D(r2, r1)
            java.lang.String r1 = "ip0"
            java.lang.String r4 = r4.getIp0()
            r0.D(r1, r4)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Item itemOf(sf.c r22) {
            r21 = this;
            r0 = r22
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Item
            java.lang.String r2 = "id"
            java.lang.String r3 = ""
            java.lang.String r2 = r0.A(r2, r3)
            java.lang.String r4 = "optString(...)"
            kotlin.jvm.internal.j.d(r2, r4)
            java.lang.String r5 = "kind"
            java.lang.String r5 = r0.A(r5, r3)
            kotlin.jvm.internal.j.d(r5, r4)
            java.lang.String r6 = "host"
            java.lang.String r6 = r0.A(r6, r3)
            kotlin.jvm.internal.j.d(r6, r4)
            java.lang.String r7 = "port"
            r8 = 443(0x1bb, float:6.21E-43)
            int r7 = r0.t(r8, r7)
            java.lang.String r8 = "protocol"
            java.lang.String r9 = "A"
            java.lang.String r8 = r0.A(r8, r9)
            kotlin.jvm.internal.j.d(r8, r4)
            java.lang.String r9 = "src"
            java.lang.String r9 = r0.A(r9, r3)
            kotlin.jvm.internal.j.d(r9, r4)
            java.lang.String r10 = "from"
            java.lang.String r10 = r0.A(r10, r3)
            kotlin.jvm.internal.j.d(r10, r4)
            r11 = 0
            java.lang.String r13 = "seen"
            long r13 = r0.x(r11, r13)
            java.lang.String r15 = "user"
            r11 = 0
            boolean r11 = r0.q(r15, r11)
            java.lang.String r12 = "profile"
            java.lang.String r12 = r0.A(r12, r3)
            kotlin.jvm.internal.j.d(r12, r4)
            java.lang.String r15 = "cc0"
            java.lang.String r15 = r0.A(r15, r3)
            kotlin.jvm.internal.j.d(r15, r4)
            r16 = r1
            java.lang.String r1 = "v0"
            r17 = r5
            r18 = r6
            r5 = 0
            long r5 = r0.x(r5, r1)
            java.lang.String r1 = "ip0"
            java.lang.String r0 = r0.A(r1, r3)
            kotlin.jvm.internal.j.d(r0, r4)
            r1 = r2
            r4 = r7
            r7 = r10
            r10 = r11
            r11 = r12
            r12 = r15
            r2 = r17
            r3 = r18
            r15 = r0
            r0 = r16
            r19 = r5
            r5 = r8
            r6 = r9
            r8 = r13
            r13 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r15)
            return r0
    }

    public static /* synthetic */ java.lang.CharSequence j(java.lang.String r0) {
            java.lang.CharSequence r0 = harvestTelegram$lambda$47(r0)
            return r0
    }

    private final void jsonStrings(java.lang.Object r4, java.util.List<java.lang.String> r5) {
            r3 = this;
            boolean r0 = r4 instanceof java.lang.String
            if (r0 == 0) goto L8
            r5.add(r4)
            return
        L8:
            boolean r0 = r4 instanceof sf.a
            if (r0 == 0) goto L21
            sf.a r4 = (sf.a) r4
            java.util.ArrayList r0 = r4.f67155a
            int r0 = r0.size()
            r1 = 0
        L15:
            if (r1 >= r0) goto L44
            java.lang.Object r2 = r4.m(r1)
            r3.jsonStrings(r2, r5)
            int r1 = r1 + 1
            goto L15
        L21:
            boolean r0 = r4 instanceof sf.c
            if (r0 == 0) goto L44
            sf.c r4 = (sf.c) r4
            java.util.Iterator r0 = r4.n()
            java.lang.String r1 = "keys(...)"
            kotlin.jvm.internal.j.d(r0, r1)
        L30:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r4.o(r1)
            r3.jsonStrings(r1, r5)
            goto L30
        L44:
            return
    }

    public static /* synthetic */ java.lang.Comparable k(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r0) {
            java.lang.Comparable r0 = summary$lambda$104(r0)
            return r0
    }

    public static /* synthetic */ boolean l(java.lang.String r0, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r1) {
            boolean r0 = removeSource$lambda$64(r0, r1)
            return r0
    }

    private final synchronized void load() {
            r32 = this;
            r1 = r32
            monitor-enter(r32)
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.loaded     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L9
            monitor-exit(r32)
            return
        L9:
            r2 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool.loaded = r2     // Catch: java.lang.Throwable -> L1d7
            r3 = 0
            r5 = 0
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.app     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L1a6
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = "argo/argo-pool.json"
            java.io.InputStream r0 = r0.open(r7)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = "open(...)"
            kotlin.jvm.internal.j.d(r0, r7)     // Catch: java.lang.Throwable -> L4a
            java.nio.charset.Charset r7 = kotlin.text.a.f23859a     // Catch: java.lang.Throwable -> L4a
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4a
            r8.<init>(r0, r7)     // Catch: java.lang.Throwable -> L4a
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a
            r0 = 8192(0x2000, float:1.14794E-41)
            r7.<init>(r8, r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = com.google.android.gms.internal.auth.j.I(r7)     // Catch: java.lang.Throwable -> L19c
            r7.close()     // Catch: java.lang.Throwable -> L4a
            sf.c r7 = new sf.c     // Catch: java.lang.Throwable -> L4a
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = "items"
            sf.a r0 = r7.v(r0)     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L4f
            sf.a r0 = new sf.a     // Catch: java.lang.Throwable -> L4a
            r0.<init>()     // Catch: java.lang.Throwable -> L4a
            goto L4f
        L4a:
            r0 = move-exception
            r30 = 0
            goto L1ae
        L4f:
            java.util.ArrayList r8 = r0.f67155a     // Catch: java.lang.Throwable -> L4a
            int r8 = r8.size()     // Catch: java.lang.Throwable -> L4a
            r9 = r5
        L56:
            if (r9 >= r8) goto L152
            sf.a r10 = r0.p(r9)     // Catch: java.lang.Throwable -> L4a
            if (r10 != 0) goto L62
            r30 = 0
            goto L14c
        L62:
            java.lang.String r11 = ""
            java.lang.String r11 = r10.t(r5, r11)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r12 = "b"
            boolean r12 = kotlin.jvm.internal.j.a(r11, r12)     // Catch: java.lang.Throwable -> L4a
            if (r12 == 0) goto L74
            java.lang.String r11 = "bridge"
        L72:
            r14 = r11
            goto L82
        L74:
            java.lang.String r12 = "f"
            boolean r11 = kotlin.jvm.internal.j.a(r11, r12)     // Catch: java.lang.Throwable -> L4a
            if (r11 == 0) goto L7f
            java.lang.String r11 = "falcon"
            goto L72
        L7f:
            java.lang.String r11 = "public"
            goto L72
        L82:
            java.lang.String r11 = ""
            java.lang.String r15 = r10.t(r2, r11)     // Catch: java.lang.Throwable -> L4a
            r11 = 2
            int r11 = r10.o(r11)     // Catch: java.lang.Throwable -> L4a
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L4a
            if (r11 <= 0) goto L94
            goto L95
        L94:
            r12 = 0
        L95:
            if (r12 == 0) goto L9c
            int r11 = r12.intValue()     // Catch: java.lang.Throwable -> L4a
            goto L9e
        L9c:
            r11 = 443(0x1bb, float:6.21E-43)
        L9e:
            kotlin.jvm.internal.j.b(r15)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r13 = r1.idOf(r14, r15, r11)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r12 = ""
            r30 = 0
            r6 = 3
            java.lang.String r6 = r10.t(r6, r12)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r12 = "B"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r12)     // Catch: java.lang.Throwable -> Lbb
            if (r6 == 0) goto Lbe
            java.lang.String r6 = "B"
        Lb8:
            r17 = r6
            goto Lc1
        Lbb:
            r0 = move-exception
            goto L1ae
        Lbe:
            java.lang.String r6 = "A"
            goto Lb8
        Lc1:
            java.lang.String r18 = "bundled"
            java.lang.String r6 = ""
            r12 = 4
            java.lang.String r6 = r10.t(r12, r6)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r12 = "0"
            boolean r12 = kotlin.jvm.internal.j.a(r6, r12)     // Catch: java.lang.Throwable -> Lbb
            if (r12 != 0) goto Ld3
            goto Ld5
        Ld3:
            r6 = r30
        Ld5:
            if (r6 != 0) goto Ld9
            java.lang.String r6 = ""
        Ld9:
            r19 = r6
            r6 = 5
            long r20 = r10.r(r6, r3)     // Catch: java.lang.Throwable -> Lbb
            r6 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r6     // Catch: java.lang.Throwable -> Lbb
            long r20 = r20 * r5
            java.lang.String r12 = ""
            r2 = 6
            java.lang.String r2 = r10.t(r2, r12)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r12 = "0"
            boolean r12 = kotlin.jvm.internal.j.a(r2, r12)     // Catch: java.lang.Throwable -> Lbb
            if (r12 != 0) goto Lf5
            goto Lf7
        Lf5:
            r2 = r30
        Lf7:
            if (r2 != 0) goto Lfb
            java.lang.String r2 = ""
        Lfb:
            r23 = r2
            java.lang.String r2 = ""
            r12 = 7
            java.lang.String r2 = r10.t(r12, r2)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r12 = "0"
            boolean r12 = kotlin.jvm.internal.j.a(r2, r12)     // Catch: java.lang.Throwable -> Lbb
            if (r12 != 0) goto L10d
            goto L10f
        L10d:
            r2 = r30
        L10f:
            if (r2 != 0) goto L113
            java.lang.String r2 = ""
        L113:
            r24 = r2
            r2 = 8
            long r25 = r10.r(r2, r3)     // Catch: java.lang.Throwable -> Lbb
            long r25 = r25 * r5
            java.lang.String r2 = ""
            r5 = 9
            java.lang.String r2 = r10.t(r5, r2)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = "0"
            boolean r5 = kotlin.jvm.internal.j.a(r2, r5)     // Catch: java.lang.Throwable -> Lbb
            if (r5 != 0) goto L12e
            goto L130
        L12e:
            r2 = r30
        L130:
            if (r2 != 0) goto L134
            java.lang.String r2 = ""
        L134:
            r27 = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r12 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Item     // Catch: java.lang.Throwable -> Lbb
            r22 = 0
            r28 = 256(0x100, float:3.59E-43)
            r29 = 0
            r16 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r29)     // Catch: java.lang.Throwable -> Lbb
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = r12.getId()     // Catch: java.lang.Throwable -> Lbb
            r2.put(r5, r12)     // Catch: java.lang.Throwable -> Lbb
        L14c:
            int r9 = r9 + 1
            r2 = 1
            r5 = 0
            goto L56
        L152:
            r30 = 0
            java.lang.String r0 = "built"
            java.lang.String r2 = ""
            java.lang.String r0 = r7.A(r0, r2)     // Catch: java.lang.Throwable -> L16d
            j$.time.Instant r0 = j$.time.Instant.parse(r0)     // Catch: java.lang.Throwable -> L16d
            long r5 = r0.toEpochMilli()     // Catch: java.lang.Throwable -> L16d
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L16d
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L16d
            goto L176
        L16d:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lbb
        L176:
            java.lang.Long r2 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> Lbb
            boolean r5 = sd.l.m1010isFailureimpl(r0)     // Catch: java.lang.Throwable -> Lbb
            if (r5 == 0) goto L181
            r0 = r2
        L181:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.lang.Throwable -> Lbb
            long r5 = r0.longValue()     // Catch: java.lang.Throwable -> Lbb
            com.mlmvpn.scanner.engines.argo.ArgoPool.bundleBuilt = r5     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = "falconServers"
            sf.a r0 = r7.v(r0)     // Catch: java.lang.Throwable -> Lbb
            java.util.List r0 = r1.parseFalconServers(r0)     // Catch: java.lang.Throwable -> Lbb
            com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers = r0     // Catch: java.lang.Throwable -> Lbb
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lbb
            goto L1b6
        L19c:
            r0 = move-exception
            r30 = 0
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L1a1
        L1a1:
            r0 = move-exception
            a.a.g(r7, r2)     // Catch: java.lang.Throwable -> Lbb
            throw r0     // Catch: java.lang.Throwable -> Lbb
        L1a6:
            r30 = 0
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)     // Catch: java.lang.Throwable -> Lbb
            throw r30     // Catch: java.lang.Throwable -> Lbb
        L1ae:
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L1b6:
            java.lang.Throwable r0 = sd.l.m1007exceptionOrNullimpl(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L1da
            java.lang.String r2 = "ARGO"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L1d7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d7
            r5.<init>()     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r6 = "bundle unreadable: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L1d7
            r5.append(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L1d7
            android.util.Log.w(r2, r0)     // Catch: java.lang.Throwable -> L1d7
            goto L1da
        L1d7:
            r0 = move-exception
            goto L45c
        L1da:
            java.lang.String r0 = "pool.json"
            java.lang.String r0 = r1.readJson(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L26f
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L1d7
            sf.a r5 = new sf.a     // Catch: java.lang.Throwable -> L21d
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L21d
            java.util.ArrayList r0 = r5.f67155a     // Catch: java.lang.Throwable -> L21d
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L21d
            r6 = 0
        L1f0:
            if (r6 >= r0) goto L25d
            sf.c r7 = r5.h(r6)     // Catch: java.lang.Throwable -> L21d
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = r2.itemOf(r7)     // Catch: java.lang.Throwable -> L21d
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L21d
            java.lang.String r9 = r8.getId()     // Catch: java.lang.Throwable -> L21d
            java.lang.Object r9 = r7.get(r9)     // Catch: java.lang.Throwable -> L21d
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r9 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r9     // Catch: java.lang.Throwable -> L21d
            java.lang.String r10 = r8.getId()     // Catch: java.lang.Throwable -> L21d
            if (r9 == 0) goto L254
            java.lang.String r11 = r8.getCc0()     // Catch: java.lang.Throwable -> L21d
            boolean r12 = kotlin.text.o.L0(r11)     // Catch: java.lang.Throwable -> L21d
            if (r12 == 0) goto L21a
            java.lang.String r11 = r9.getCc0()     // Catch: java.lang.Throwable -> L21d
        L21a:
            r20 = r11
            goto L21f
        L21d:
            r0 = move-exception
            goto L264
        L21f:
            long r11 = r8.getV0()     // Catch: java.lang.Throwable -> L21d
            long r13 = r9.getV0()     // Catch: java.lang.Throwable -> L21d
            long r21 = java.lang.Math.max(r11, r13)     // Catch: java.lang.Throwable -> L21d
            r24 = 5119(0x13ff, float:7.173E-42)
            r25 = 0
            r9 = 0
            r11 = r10
            r10 = 0
            r12 = r11
            r11 = 0
            r13 = r12
            r12 = 0
            r14 = r13
            r13 = 0
            r15 = r14
            r14 = 0
            r16 = r15
            r15 = 0
            r18 = r16
            r16 = 0
            r19 = r18
            r18 = 0
            r23 = r19
            r19 = 0
            r26 = r23
            r23 = 0
            r3 = r26
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.Item.copy$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r23, r24, r25)     // Catch: java.lang.Throwable -> L21d
            goto L255
        L254:
            r3 = r10
        L255:
            r7.put(r3, r8)     // Catch: java.lang.Throwable -> L21d
            int r6 = r6 + 1
            r3 = 0
            goto L1f0
        L25d:
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L21d
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L21d
            goto L26c
        L264:
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L26c:
            sd.l.m1003boximpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L26f:
            java.lang.String r0 = "results.json"
            java.lang.String r0 = r1.readJson(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L2b5
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L1d7
            sf.c r3 = new sf.c     // Catch: java.lang.Throwable -> L2a1
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L2a1
            java.util.Iterator r0 = r3.n()     // Catch: java.lang.Throwable -> L2a1
            java.lang.String r4 = "keys(...)"
            kotlin.jvm.internal.j.d(r0, r4)     // Catch: java.lang.Throwable -> L2a1
        L287:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Throwable -> L2a1
            if (r4 == 0) goto L2a3
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Throwable -> L2a1
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L2a1
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L2a1
            sf.c r6 = r3.h(r4)     // Catch: java.lang.Throwable -> L2a1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r6 = r2.resultOf(r6)     // Catch: java.lang.Throwable -> L2a1
            r5.put(r4, r6)     // Catch: java.lang.Throwable -> L2a1
            goto L287
        L2a1:
            r0 = move-exception
            goto L2aa
        L2a3:
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L2a1
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L2a1
            goto L2b2
        L2aa:
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L2b2:
            sd.l.m1003boximpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L2b5:
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L1d7
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r2 = "<get-entries>(...)"
            kotlin.jvm.internal.j.d(r0, r2)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L1d7
            com.mlmvpn.scanner.engines.argo.d r2 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L1d7
            r3 = 11
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d7
            kotlin.collections.q.U0(r0, r2)     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r0 = "sources.json"
            java.lang.String r0 = r1.readJson(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L382
            sf.c r2 = new sf.c     // Catch: java.lang.Throwable -> L2e7
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r0 = "list"
            sf.a r0 = r2.v(r0)     // Catch: java.lang.Throwable -> L2e7
            if (r0 != 0) goto L2ea
            sf.a r0 = new sf.a     // Catch: java.lang.Throwable -> L2e7
            r0.<init>()     // Catch: java.lang.Throwable -> L2e7
            goto L2ea
        L2e7:
            r0 = move-exception
            goto L377
        L2ea:
            java.util.ArrayList r3 = r0.f67155a     // Catch: java.lang.Throwable -> L2e7
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L2e7
            r4 = 0
        L2f1:
            if (r4 >= r3) goto L344
            sf.c r5 = r0.q(r4)     // Catch: java.lang.Throwable -> L2e7
            if (r5 == 0) goto L341
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L2e7
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r7 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r8 = "id"
            java.lang.String r9 = ""
            java.lang.String r8 = r5.A(r8, r9)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r9 = "optString(...)"
            kotlin.jvm.internal.j.d(r8, r9)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r9 = "type"
            java.lang.String r10 = ""
            java.lang.String r9 = r5.A(r9, r10)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r10 = "optString(...)"
            kotlin.jvm.internal.j.d(r9, r10)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r10 = "value"
            java.lang.String r11 = ""
            java.lang.String r10 = r5.A(r10, r11)     // Catch: java.lang.Throwable -> L2e7
            java.util.List r10 = m9.d.B(r10)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r11 = "label"
            java.lang.String r12 = ""
            java.lang.String r11 = r5.A(r11, r12)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r12 = "optString(...)"
            kotlin.jvm.internal.j.d(r11, r12)     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r12 = "addedAt"
            r13 = 0
            long r15 = r5.x(r13, r12)     // Catch: java.lang.Throwable -> L2e7
            r12 = 0
            r13 = 1
            r14 = r15
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L2e7
            r6.add(r7)     // Catch: java.lang.Throwable -> L2e7
        L341:
            int r4 = r4 + 1
            goto L2f1
        L344:
            java.lang.String r0 = "state"
            sf.c r0 = r2.w(r0)     // Catch: java.lang.Throwable -> L2e7
            if (r0 != 0) goto L351
            sf.c r0 = new sf.c     // Catch: java.lang.Throwable -> L2e7
            r0.<init>()     // Catch: java.lang.Throwable -> L2e7
        L351:
            java.util.Iterator r2 = r0.n()     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r3 = "keys(...)"
            kotlin.jvm.internal.j.d(r2, r3)     // Catch: java.lang.Throwable -> L2e7
        L35a:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2e7
            if (r3 == 0) goto L370
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2e7
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L2e7
            java.util.HashMap<java.lang.String, sf.c> r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L2e7
            sf.c r5 = r0.h(r3)     // Catch: java.lang.Throwable -> L2e7
            r4.put(r3, r5)     // Catch: java.lang.Throwable -> L2e7
            goto L35a
        L370:
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L2e7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L2e7
            goto L37f
        L377:
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L37f:
            sd.l.m1003boximpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L382:
            java.lang.String r0 = "prefs.json"
            java.lang.String r0 = r1.readJson(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L3c5
            sf.c r2 = new sf.c     // Catch: java.lang.Throwable -> L3b9
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3b9
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs     // Catch: java.lang.Throwable -> L3b9
            java.lang.String r3 = "cleanIp"
            java.lang.String r4 = ""
            java.lang.String r3 = r2.A(r3, r4)     // Catch: java.lang.Throwable -> L3b9
            java.lang.String r4 = "optString(...)"
            kotlin.jvm.internal.j.d(r3, r4)     // Catch: java.lang.Throwable -> L3b9
            java.lang.String r4 = "autoClean"
            r5 = 0
            boolean r4 = r2.q(r4, r5)     // Catch: java.lang.Throwable -> L3b9
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3b9
            com.mlmvpn.scanner.engines.argo.ArgoPool.prefs = r0     // Catch: java.lang.Throwable -> L3b9
            java.lang.String r0 = "cleanScan"
            sf.c r0 = r2.w(r0)     // Catch: java.lang.Throwable -> L3b9
            com.mlmvpn.scanner.engines.argo.ArgoPool.cleanScan = r0     // Catch: java.lang.Throwable -> L3b9
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> L3b9
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L3b9
            goto L3c2
        L3b9:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L3c2:
            sd.l.m1003boximpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L3c5:
            java.lang.String r0 = "remote.json"
            java.lang.String r0 = r1.readJson(r0)     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L405
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L1d7
            sf.c r3 = new sf.c     // Catch: java.lang.Throwable -> L3f1
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3f1
            java.lang.String r0 = "falconServers"
            sf.a r0 = r3.v(r0)     // Catch: java.lang.Throwable -> L3f1
            java.util.List r0 = r2.parseFalconServers(r0)     // Catch: java.lang.Throwable -> L3f1
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L3f1
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L3f1
            if (r2 != 0) goto L3e8
            goto L3ea
        L3e8:
            r0 = r30
        L3ea:
            if (r0 == 0) goto L3f3
            com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers = r0     // Catch: java.lang.Throwable -> L3f1
            sd.u r6 = sd.u.f67154a     // Catch: java.lang.Throwable -> L3f1
            goto L3f5
        L3f1:
            r0 = move-exception
            goto L3fa
        L3f3:
            r6 = r30
        L3f5:
            java.lang.Object r0 = sd.l.m1004constructorimpl(r6)     // Catch: java.lang.Throwable -> L3f1
            goto L402
        L3fa:
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> L1d7
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L402:
            sd.l.m1003boximpl(r0)     // Catch: java.lang.Throwable -> L1d7
        L405:
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.BUILTIN     // Catch: java.lang.Throwable -> L1d7
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L1d7
        L40b:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L1d7
            if (r2 == 0) goto L45a
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L1d7
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r2     // Catch: java.lang.Throwable -> L1d7
            java.util.HashMap<java.lang.String, sf.c> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r4 = r2.getId()     // Catch: java.lang.Throwable -> L1d7
            boolean r4 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L1d7
            if (r4 != 0) goto L457
            long r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.bundleBuilt     // Catch: java.lang.Throwable -> L1d7
            r27 = 0
            int r4 = (r4 > r27 ? 1 : (r4 == r27 ? 0 : -1))
            if (r4 <= 0) goto L454
            java.lang.String r2 = r2.getId()     // Catch: java.lang.Throwable -> L1d7
            sf.c r4 = new sf.c     // Catch: java.lang.Throwable -> L1d7
            r4.<init>()     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r5 = "at"
            long r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.bundleBuilt     // Catch: java.lang.Throwable -> L1d7
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L1d7
            r4.D(r5, r6)     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r5 = "found"
            r31 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r31)     // Catch: java.lang.Throwable -> L1d7
            r4.D(r5, r6)     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r5 = "on"
            r6 = 1
            r4.E(r5, r6)     // Catch: java.lang.Throwable -> L1d7
            r3.put(r2, r4)     // Catch: java.lang.Throwable -> L1d7
            goto L40b
        L454:
            r31 = 0
            goto L40b
        L457:
            r27 = 0
            goto L454
        L45a:
            monitor-exit(r32)
            return
        L45c:
            monitor-exit(r32)     // Catch: java.lang.Throwable -> L1d7
            throw r0
    }

    private static final boolean load$lambda$20(java.util.Map.Entry r4) {
            java.lang.String r0 = "<destruct>"
            kotlin.jvm.internal.j.e(r4, r0)
            java.lang.Object r4 = r4.getValue()
            java.lang.String r0 = "component2(...)"
            kotlin.jvm.internal.j.d(r4, r0)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r4
            boolean r0 = r4.getFrozen()
            if (r0 == 0) goto L25
            long r0 = r4.getAt()
            r2 = 1794063600000(0x1a1b6860980, double:8.863851912143E-312)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L25
            r4 = 1
            return r4
        L25:
            r4 = 0
            return r4
    }

    private final java.lang.Object measureExits(java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Ready> r3, java.lang.String r4, wd.d r5) {
            r2 = this;
            com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2
            r1 = 0
            r0.<init>(r3, r4, r1)
            java.lang.Object r3 = kotlinx.coroutines.m0.i(r0, r5)
            return r3
    }

    private final java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin> parseFalconServers(sf.a r10) {
            r9 = this;
            r0 = 0
            if (r10 == 0) goto La
            java.util.ArrayList r1 = r10.f67155a
            int r1 = r1.size()
            goto Lb
        La:
            r1 = r0
        Lb:
            je.h r0 = com.google.android.gms.internal.mlkit_language_id_common.j.J(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5b
            r2 = r0
            je.g r2 = (je.g) r2
            int r2 = r2.nextInt()
            kotlin.jvm.internal.j.b(r10)
            sf.c r2 = r10.q(r2)
            if (r2 == 0) goto L54
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin r3 = new com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin
            java.lang.String r4 = "ip"
            java.lang.String r5 = ""
            java.lang.String r4 = r2.A(r4, r5)
            java.lang.String r5 = "optString(...)"
            kotlin.jvm.internal.j.d(r4, r5)
            java.lang.String r6 = "cc"
            java.lang.String r7 = "??"
            java.lang.String r6 = r2.A(r6, r7)
            kotlin.jvm.internal.j.d(r6, r5)
            java.lang.String r5 = "load"
            r7 = 0
            double r7 = r2.s(r5, r7)
            r3.<init>(r4, r6, r7)
            goto L55
        L54:
            r3 = 0
        L55:
            if (r3 == 0) goto L18
            r1.add(r3)
            goto L18
        L5b:
            return r1
    }

    public static /* synthetic */ java.util.List pick$default(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L5
            r1 = 3
        L5:
            java.util.List r0 = r0.pick(r1)
            return r0
    }

    private final java.lang.String readJson(java.lang.String r4) {
            r3 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L21
            java.io.File r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.dir     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L23
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L21
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L11
            goto L12
        L11:
            r1 = r0
        L12:
            if (r1 == 0) goto L1b
            java.nio.charset.Charset r4 = kotlin.text.a.f23859a     // Catch: java.lang.Throwable -> L21
            java.lang.String r4 = ce.o.n0(r1, r4)     // Catch: java.lang.Throwable -> L21
            goto L1c
        L1b:
            r4 = r0
        L1c:
            java.lang.Object r4 = sd.l.m1004constructorimpl(r4)     // Catch: java.lang.Throwable -> L21
            goto L31
        L21:
            r4 = move-exception
            goto L29
        L23:
            java.lang.String r4 = "dir"
            kotlin.jvm.internal.j.k(r4)     // Catch: java.lang.Throwable -> L21
            throw r0     // Catch: java.lang.Throwable -> L21
        L29:
            sd.l$a r4 = sd.m.a(r4)
            java.lang.Object r4 = sd.l.m1004constructorimpl(r4)
        L31:
            boolean r1 = sd.l.m1010isFailureimpl(r4)
            if (r1 == 0) goto L38
            goto L39
        L38:
            r0 = r4
        L39:
            java.lang.String r0 = (java.lang.String) r0
            return r0
    }

    public static /* synthetic */ void record$default(com.mlmvpn.scanner.engines.argo.ArgoPool r13, java.lang.String r14, boolean r15, long r16, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, int r23, java.lang.Object r24) {
            r0 = r23
            r1 = r0 & 4
            if (r1 == 0) goto La
            r1 = 0
            r6 = r1
            goto Lc
        La:
            r6 = r16
        Lc:
            r1 = r0 & 8
            java.lang.String r2 = ""
            if (r1 == 0) goto L14
            r8 = r2
            goto L16
        L14:
            r8 = r18
        L16:
            r1 = r0 & 16
            if (r1 == 0) goto L1c
            r9 = r2
            goto L1e
        L1c:
            r9 = r19
        L1e:
            r1 = r0 & 32
            if (r1 == 0) goto L24
            r10 = r2
            goto L26
        L24:
            r10 = r20
        L26:
            r1 = r0 & 64
            if (r1 == 0) goto L2d
            r1 = 0
            r11 = r1
            goto L2f
        L2d:
            r11 = r21
        L2f:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L38
            r12 = r2
        L34:
            r3 = r13
            r4 = r14
            r5 = r15
            goto L3b
        L38:
            r12 = r22
            goto L34
        L3b:
            r3.record(r4, r5, r6, r8, r9, r10, r11, r12)
            return
    }

    private final synchronized java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> refHosts(int r14) {
            r13 = this;
            monitor-enter(r13)
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L34
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r1)     // Catch: java.lang.Throwable -> L34
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r1.<init>()     // Catch: java.lang.Throwable -> L34
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L34
        L17:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L34
            r3 = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r3     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = r3.getKind()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "falcon"
            boolean r3 = kotlin.jvm.internal.j.a(r3, r4)     // Catch: java.lang.Throwable -> L34
            if (r3 != 0) goto L17
            r1.add(r2)     // Catch: java.lang.Throwable -> L34
            goto L17
        L34:
            r14 = move-exception
            goto Lee
        L37:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r0.<init>()     // Catch: java.lang.Throwable -> L34
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L34
            r3 = 0
            r4 = r3
        L42:
            r5 = 1
            if (r4 >= r2) goto L66
            java.lang.Object r6 = r1.get(r4)     // Catch: java.lang.Throwable -> L34
            int r4 = r4 + 1
            r7 = r6
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r7     // Catch: java.lang.Throwable -> L34
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L34
            java.lang.String r7 = r7.getId()     // Catch: java.lang.Throwable -> L34
            java.lang.Object r7 = r8.get(r7)     // Catch: java.lang.Throwable -> L34
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r7     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto L42
            boolean r7 = r7.getOk()     // Catch: java.lang.Throwable -> L34
            if (r7 != r5) goto L42
            r0.add(r6)     // Catch: java.lang.Throwable -> L34
            goto L42
        L66:
            com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedBy$1 r2 = new com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedBy$1     // Catch: java.lang.Throwable -> L34
            r2.<init>()     // Catch: java.lang.Throwable -> L34
            java.util.List r0 = kotlin.collections.q.b1(r0, r2)     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r2.<init>()     // Catch: java.lang.Throwable -> L34
            int r4 = r1.size()     // Catch: java.lang.Throwable -> L34
            r6 = r3
        L79:
            r7 = 0
            if (r6 >= r4) goto La7
            java.lang.Object r9 = r1.get(r6)     // Catch: java.lang.Throwable -> L34
            int r6 = r6 + 1
            r10 = r9
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r10 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r10     // Catch: java.lang.Throwable -> L34
            long r11 = r10.getV0()     // Catch: java.lang.Throwable -> L34
            int r7 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r7 <= 0) goto L79
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L34
            java.lang.String r8 = r10.getId()     // Catch: java.lang.Throwable -> L34
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Throwable -> L34
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r7     // Catch: java.lang.Throwable -> L34
            if (r7 == 0) goto La3
            boolean r7 = r7.getOk()     // Catch: java.lang.Throwable -> L34
            if (r7 != r5) goto La3
            goto L79
        La3:
            r2.add(r9)     // Catch: java.lang.Throwable -> L34
            goto L79
        La7:
            com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedByDescending$1 r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedByDescending$1     // Catch: java.lang.Throwable -> L34
            r4.<init>()     // Catch: java.lang.Throwable -> L34
            java.util.List r2 = kotlin.collections.q.b1(r2, r4)     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L34
            r4.<init>()     // Catch: java.lang.Throwable -> L34
            int r5 = r1.size()     // Catch: java.lang.Throwable -> L34
        Lb9:
            if (r3 >= r5) goto Ldc
            java.lang.Object r6 = r1.get(r3)     // Catch: java.lang.Throwable -> L34
            int r3 = r3 + 1
            r9 = r6
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r9 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r9     // Catch: java.lang.Throwable -> L34
            java.lang.String r10 = r9.getKind()     // Catch: java.lang.Throwable -> L34
            java.lang.String r11 = "public"
            boolean r10 = kotlin.jvm.internal.j.a(r10, r11)     // Catch: java.lang.Throwable -> L34
            if (r10 == 0) goto Lb9
            long r9 = r9.getV0()     // Catch: java.lang.Throwable -> L34
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 != 0) goto Lb9
            r4.add(r6)     // Catch: java.lang.Throwable -> L34
            goto Lb9
        Ldc:
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L34
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r0 = kotlin.collections.q.S0(r0, r2)     // Catch: java.lang.Throwable -> L34
            java.util.ArrayList r0 = kotlin.collections.q.S0(r0, r4)     // Catch: java.lang.Throwable -> L34
            java.util.List r14 = kotlin.collections.q.e1(r0, r14)     // Catch: java.lang.Throwable -> L34
            monitor-exit(r13)
            return r14
        Lee:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L34
            throw r14
    }

    private static final boolean removeSource$lambda$64(java.lang.String r1, com.mlmvpn.scanner.engines.argo.ArgoPool.Source r2) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r2 = r2.getId()
            boolean r1 = kotlin.jvm.internal.j.a(r2, r1)
            return r1
    }

    private final sf.c resultJson(com.mlmvpn.scanner.engines.argo.ArgoPool.Result r4) {
            r3 = this;
            sf.c r0 = new sf.c
            r0.<init>()
            java.lang.String r1 = "ok"
            boolean r2 = r4.getOk()
            r0.E(r1, r2)
            long r1 = r4.getMs()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "ms"
            r0.D(r2, r1)
            java.lang.String r1 = "cc"
            java.lang.String r2 = r4.getCc()
            r0.D(r1, r2)
            java.lang.String r1 = "exitIp"
            java.lang.String r2 = r4.getExitIp()
            r0.D(r1, r2)
            long r1 = r4.getAt()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "at"
            r0.D(r2, r1)
            int r1 = r4.getFails()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "fails"
            r0.D(r2, r1)
            java.lang.String r1 = "error"
            java.lang.String r2 = r4.getError()
            r0.D(r1, r2)
            java.lang.String r1 = "frozen"
            boolean r2 = r4.getFrozen()
            r0.E(r1, r2)
            java.lang.String r1 = "edge"
            java.lang.String r4 = r4.getEdge()
            r0.D(r1, r4)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Result resultOf(sf.c r17) {
            r16 = this;
            r0 = r17
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Result
            java.lang.String r2 = "ok"
            r3 = 0
            boolean r2 = r0.q(r2, r3)
            r4 = 0
            java.lang.String r6 = "ms"
            long r6 = r0.x(r4, r6)
            java.lang.String r8 = "cc"
            java.lang.String r9 = ""
            java.lang.String r8 = r0.A(r8, r9)
            java.lang.String r10 = "optString(...)"
            kotlin.jvm.internal.j.d(r8, r10)
            java.lang.String r11 = "exitIp"
            java.lang.String r11 = r0.A(r11, r9)
            kotlin.jvm.internal.j.d(r11, r10)
            java.lang.String r12 = "at"
            long r4 = r0.x(r4, r12)
            java.lang.String r12 = "fails"
            int r12 = r0.t(r3, r12)
            java.lang.String r13 = "error"
            java.lang.String r13 = r0.A(r13, r9)
            kotlin.jvm.internal.j.d(r13, r10)
            java.lang.String r14 = "frozen"
            boolean r3 = r0.q(r14, r3)
            java.lang.String r14 = "edge"
            java.lang.String r0 = r0.A(r14, r9)
            kotlin.jvm.internal.j.d(r0, r10)
            r10 = r3
            r9 = r13
            r15 = r11
            r11 = r0
            r0 = r1
            r1 = r2
            r2 = r6
            r6 = r4
            r4 = r8
            r5 = r15
            r8 = r12
            r0.<init>(r1, r2, r4, r5, r6, r8, r9, r10, r11)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoNet.Route routeNow() {
            r7 = this;
            com.mlmvpn.scanner.MyVpnService$Companion r0 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r1 = r0.getConnectionPhaseFlow()
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            java.lang.Object r1 = r1.getValue()
            com.mlmvpn.scanner.MyVpnService$Phase r2 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
            java.lang.String r3 = "127.0.0.1"
            r4 = 0
            if (r1 != r2) goto L4c
            com.mlmvpn.scanner.utils.LocalPort r1 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.app
            if (r2 == 0) goto L46
            int r1 = r1.get(r2)
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r2 = new com.mlmvpn.scanner.engines.argo.ArgoNet$Route
            java.net.Proxy r4 = new java.net.Proxy
            java.net.Proxy$Type r5 = java.net.Proxy.Type.SOCKS
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress
            r6.<init>(r3, r1)
            r4.<init>(r5, r6)
            kotlinx.coroutines.flow.k0 r0 = r0.getConnectedNodeIdFlow()
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "argo"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
            if (r0 == 0) goto L40
            java.lang.String r0 = "خود آرگو"
            goto L42
        L40:
            java.lang.String r0 = "موتور وصل برنامه (Xray)"
        L42:
            r2.<init>(r4, r0)
            return r2
        L46:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            throw r4
        L4c:
            com.mlmvpn.core.tunnel.TunnelStatus r0 = com.mlmvpn.core.tunnel.TunnelStatus.INSTANCE
            int r1 = r0.getActiveSocksPort()
            if (r1 <= 0) goto L6e
            boolean r0 = r0.isActive()
            if (r0 == 0) goto L6e
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r0 = new com.mlmvpn.scanner.engines.argo.ArgoNet$Route
            java.net.Proxy r2 = new java.net.Proxy
            java.net.Proxy$Type r4 = java.net.Proxy.Type.SOCKS
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress
            r5.<init>(r3, r1)
            r2.<init>(r4, r5)
            java.lang.String r1 = "موتور وصل برنامه"
            r0.<init>(r2, r1)
            return r0
        L6e:
            return r4
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Row rowOf(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r25) {
            r24 = this;
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results
            java.lang.String r1 = r25.getId()
            java.lang.Object r0 = r0.get(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r0
            java.lang.String r1 = r24.ccOf(r25)
            java.lang.String r3 = r25.getId()
            java.lang.String r4 = r25.getKind()
            java.lang.String r5 = r25.getHost()
            int r6 = r25.getPort()
            boolean r7 = r25.getUser()
            java.lang.String r8 = r25.getProfile()
            long r9 = r25.getV0()
            r2 = 0
            if (r0 == 0) goto L38
            boolean r11 = r0.getOk()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L39
        L38:
            r11 = r2
        L39:
            r12 = 0
            r13 = 1
            if (r0 == 0) goto L4c
            boolean r14 = r0.getOk()
            if (r14 != 0) goto L4c
            boolean r14 = r0.getFrozen()
            if (r14 == 0) goto L4c
            r14 = r12
            r12 = r13
            goto L4d
        L4c:
            r14 = r12
        L4d:
            if (r0 == 0) goto L5e
            boolean r15 = r0.getOk()
            if (r15 != r13) goto L5e
            long r15 = r0.getMs()
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            goto L5f
        L5e:
            r13 = r2
        L5f:
            java.lang.String r15 = "??"
            boolean r15 = kotlin.jvm.internal.j.a(r1, r15)
            java.lang.String r16 = ""
            if (r15 == 0) goto L6b
            r1 = r16
        L6b:
            if (r0 == 0) goto L80
            java.lang.String r15 = r0.getExitIp()
            if (r15 == 0) goto L80
            boolean r17 = kotlin.text.o.L0(r15)
            if (r17 == 0) goto L7a
            goto L7b
        L7a:
            r2 = r15
        L7b:
            if (r2 != 0) goto L7e
            goto L80
        L7e:
            r15 = r2
            goto L85
        L80:
            java.lang.String r2 = r25.getIp0()
            goto L7e
        L85:
            if (r0 == 0) goto L8c
            long r17 = r0.getAt()
            goto L8e
        L8c:
            r17 = 0
        L8e:
            if (r0 == 0) goto L9a
            boolean r2 = r0.getOk()
            if (r2 != 0) goto L9a
            java.lang.String r16 = r0.getError()
        L9a:
            if (r0 == 0) goto La3
            int r0 = r0.getFails()
            r19 = r0
            goto La5
        La3:
            r19 = r14
        La5:
            long r20 = r25.getSeen()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Row r2 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Row
            r22 = r17
            r18 = r16
            r16 = r22
            r14 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r18, r19, r20)
            return r2
    }

    public static /* synthetic */ sd.j rows$default(com.mlmvpn.scanner.engines.argo.ArgoPool r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, int r6, int r7, java.lang.Object r8) {
            r8 = r7 & 1
            if (r8 == 0) goto L6
            java.lang.String r2 = "all"
        L6:
            r8 = r7 & 2
            java.lang.String r0 = ""
            if (r8 == 0) goto Ld
            r3 = r0
        Ld:
            r8 = r7 & 4
            if (r8 == 0) goto L12
            r4 = r0
        L12:
            r8 = r7 & 8
            if (r8 == 0) goto L17
            r5 = r0
        L17:
            r7 = r7 & 16
            if (r7 == 0) goto L1d
            r6 = 300(0x12c, float:4.2E-43)
        L1d:
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            sd.j r1 = r3.rows(r4, r5, r6, r7, r8)
            return r1
    }

    private static final java.lang.Comparable rows$lambda$118(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            int r1 = rows$score(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            return r1
    }

    private static final java.lang.Comparable rows$lambda$119(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r2) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r2, r0)
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results
            java.lang.String r2 = r2.getId()
            java.lang.Object r2 = r0.get(r2)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r2
            if (r2 == 0) goto L1c
            long r0 = r2.getMs()
        L17:
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            return r2
        L1c:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L17
    }

    private static final java.lang.Comparable rows$lambda$120(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r2) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r2, r0)
            long r0 = r2.getSeen()
            long r0 = -r0
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            return r2
    }

    private static final int rows$score(com.mlmvpn.scanner.engines.argo.ArgoPool.Item r6) {
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results
            java.lang.String r1 = r6.getId()
            java.lang.Object r0 = r0.get(r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r0
            r1 = 1
            if (r0 == 0) goto L17
            boolean r2 = r0.getOk()
            if (r2 != r1) goto L17
            r6 = 0
            return r6
        L17:
            if (r0 != 0) goto L24
            long r2 = r6.getV0()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L24
            return r1
        L24:
            if (r0 != 0) goto L28
            r6 = 2
            return r6
        L28:
            r6 = 3
            return r6
    }

    private final java.util.List<java.lang.String> sampleV4(int r10) {
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r10)
            r1 = 0
            r2 = r1
        L7:
            if (r2 >= r10) goto Le1
            java.util.List<java.lang.String> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.CF_V4
            java.security.SecureRandom r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.random
            int r5 = r3.size()
            int r4 = r4.nextInt(r5)
            java.lang.Object r3 = r3.get(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 1
            char[] r5 = new char[r4]
            r6 = 47
            r5[r1] = r6
            r6 = 6
            java.util.List r3 = kotlin.text.o.a1(r3, r5, r6)
            java.lang.Object r5 = r3.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            char[] r7 = new char[r4]
            r8 = 46
            r7[r1] = r8
            java.util.List r5 = kotlin.text.o.a1(r5, r7, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.s.g0(r5, r7)
            r6.<init>(r7)
            java.util.Iterator r5 = r5.iterator()
        L4e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L66
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            int r7 = java.lang.Integer.parseInt(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
            goto L4e
        L66:
            java.lang.Object r5 = r6.get(r1)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            int r5 = r5 << 24
            java.lang.Object r7 = r6.get(r4)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r7 = r7 << 16
            r5 = r5 | r7
            r7 = 2
            java.lang.Object r7 = r6.get(r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r7 = r7 << 8
            r5 = r5 | r7
            r7 = 3
            java.lang.Object r6 = r6.get(r7)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r5 = r5 | r6
            java.security.SecureRandom r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.random
            int r3 = java.lang.Integer.parseInt(r3)
            int r3 = 32 - r3
            int r3 = r4 << r3
            int r3 = r6.nextInt(r3)
            if (r3 >= r4) goto Laa
            goto Lab
        Laa:
            r4 = r3
        Lab:
            int r5 = r5 + r4
            int r3 = r5 >>> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r4 = r5 >>> 16
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r6 = r5 >>> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            r5 = r5 & 255(0xff, float:3.57E-43)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r3 = "."
            r7.append(r3)
            r7.append(r4)
            r7.append(r3)
            r7.append(r6)
            r7.append(r3)
            r7.append(r5)
            java.lang.String r3 = r7.toString()
            r0.add(r3)
            int r2 = r2 + 1
            goto L7
        Le1:
            java.util.List r10 = kotlin.collections.q.s0(r0)
            return r10
    }

    private final java.util.List<java.lang.String> sampleV6(int r11) {
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r11)
            r1 = 0
            r2 = r1
        L7:
            if (r2 >= r11) goto L55
            java.util.List<java.lang.String> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.CF_V6
            int r4 = r3.size()
            int r4 = r2 % r4
            java.lang.Object r3 = r3.get(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 5
            r4.<init>(r5)
            r6 = r1
        L1c:
            if (r6 >= r5) goto L30
            java.security.SecureRandom r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.random
            r8 = 65536(0x10000, float:9.18355E-41)
            int r7 = r7.nextInt(r8)
            java.lang.String r7 = java.lang.Integer.toHexString(r7)
            r4.add(r7)
            int r6 = r6 + 1
            goto L1c
        L30:
            r8 = 0
            r9 = 62
            java.lang.String r5 = ":"
            r6 = 0
            r7 = 0
            java.lang.String r4 = kotlin.collections.q.F0(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = ":"
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            r0.add(r3)
            int r2 = r2 + 1
            goto L7
        L55:
            java.util.List r11 = m9.d.I(r0)
            return r11
    }

    private final void savePrefs() {
            r3 = this;
            sf.c r0 = new sf.c
            r0.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs
            java.lang.String r1 = r1.getCleanIp()
            java.lang.String r2 = "cleanIp"
            r0.D(r2, r1)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs
            boolean r1 = r1.getAutoClean()
            java.lang.String r2 = "autoClean"
            r0.E(r2, r1)
            sf.c r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.cleanScan
            if (r1 == 0) goto L24
            java.lang.String r2 = "cleanScan"
            r0.D(r2, r1)
        L24:
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.j.d(r0, r1)
            java.lang.String r1 = "prefs.json"
            r3.writeJson(r1, r0)
            return
    }

    private final void saveSoon() {
            r4 = this;
            r4.changed()
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.saveQueued
            if (r0 == 0) goto L8
            return
        L8:
            r0 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool.saveQueued = r0
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.scope
            com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1
            r2 = 0
            r1.<init>(r2)
            r3 = 3
            kotlinx.coroutines.m0.y(r0, r2, r2, r1, r3)
            return
    }

    public static /* synthetic */ void scanCleanIps$default(com.mlmvpn.scanner.engines.argo.ArgoPool r0, int r1, boolean r2, int r3, java.lang.Object r4) {
            r4 = r3 & 1
            if (r4 == 0) goto L6
            r1 = 300(0x12c, float:4.2E-43)
        L6:
            r3 = r3 & 2
            if (r3 == 0) goto Lb
            r2 = 1
        Lb:
            r0.scanCleanIps(r1, r2)
            return
    }

    private final synchronized java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.Item> select(java.lang.String r5, java.lang.String r6, java.util.List<java.lang.String> r7, boolean r8, boolean r9, boolean r10) {
            r4 = this;
            monitor-enter(r4)
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L4a
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.List r0 = kotlin.collections.q.k1(r0)     // Catch: java.lang.Throwable -> L4a
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L4e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L1e
            goto L4e
        L1e:
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L4a
            java.util.Set r7 = kotlin.collections.q.p1(r7)     // Catch: java.lang.Throwable -> L4a
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r1.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        L2f:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L4a
            r3 = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r3     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Throwable -> L4a
            boolean r3 = r7.contains(r3)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L2f
            r1.add(r2)     // Catch: java.lang.Throwable -> L4a
            goto L2f
        L4a:
            r5 = move-exception
            goto L143
        L4d:
            r0 = r1
        L4e:
            java.lang.String r7 = "all"
            boolean r7 = kotlin.jvm.internal.j.a(r5, r7)     // Catch: java.lang.Throwable -> L4a
            if (r7 != 0) goto L7d
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r7.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        L61:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L7c
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L4a
            r2 = r1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r2     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = r2.getKind()     // Catch: java.lang.Throwable -> L4a
            boolean r2 = kotlin.jvm.internal.j.a(r2, r5)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L61
            r7.add(r1)     // Catch: java.lang.Throwable -> L4a
            goto L61
        L7c:
            r0 = r7
        L7d:
            boolean r5 = kotlin.text.o.L0(r6)     // Catch: java.lang.Throwable -> L4a
            if (r5 != 0) goto Laf
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r7 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        L8e:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto Lae
            java.lang.Object r0 = r7.next()     // Catch: java.lang.Throwable -> L4a
            r1 = r0
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r1     // Catch: java.lang.Throwable -> L4a
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4a
            kotlin.jvm.internal.j.b(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = r2.ccOf(r1)     // Catch: java.lang.Throwable -> L4a
            boolean r1 = kotlin.jvm.internal.j.a(r1, r6)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L8e
            r5.add(r0)     // Catch: java.lang.Throwable -> L4a
            goto L8e
        Lae:
            r0 = r5
        Laf:
            if (r8 == 0) goto Lda
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r6 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        Lbc:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto Ld9
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4a
            r8 = r7
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r8     // Catch: java.lang.Throwable -> L4a
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L4a
            java.lang.String r8 = r8.getId()     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r8 = r0.get(r8)     // Catch: java.lang.Throwable -> L4a
            if (r8 != 0) goto Lbc
            r5.add(r7)     // Catch: java.lang.Throwable -> L4a
            goto Lbc
        Ld9:
            r0 = r5
        Lda:
            if (r9 == 0) goto L103
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r6 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        Le7:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L102
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4a
            r8 = r7
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r8     // Catch: java.lang.Throwable -> L4a
            long r8 = r8.getV0()     // Catch: java.lang.Throwable -> L4a
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto Le7
            r5.add(r7)     // Catch: java.lang.Throwable -> L4a
            goto Le7
        L102:
            r0 = r5
        L103:
            if (r10 == 0) goto L136
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r6 = r0.iterator()     // Catch: java.lang.Throwable -> L4a
        L110:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L135
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4a
            r8 = r7
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r8     // Catch: java.lang.Throwable -> L4a
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r9 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L4a
            java.lang.String r8 = r8.getId()     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r8 = r9.get(r8)     // Catch: java.lang.Throwable -> L4a
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r8 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r8     // Catch: java.lang.Throwable -> L4a
            if (r8 == 0) goto L110
            boolean r8 = r8.getOk()     // Catch: java.lang.Throwable -> L4a
            if (r8 != 0) goto L110
            r5.add(r7)     // Catch: java.lang.Throwable -> L4a
            goto L110
        L135:
            r0 = r5
        L136:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L4a
            com.mlmvpn.scanner.engines.argo.ArgoPool$select$$inlined$sortedByDescending$1 r5 = new com.mlmvpn.scanner.engines.argo.ArgoPool$select$$inlined$sortedByDescending$1     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.util.List r5 = kotlin.collections.q.b1(r0, r5)     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r4)
            return r5
        L143:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L4a
            throw r5
    }

    public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs setPrefs$default(com.mlmvpn.scanner.engines.argo.ArgoPool r1, java.lang.String r2, java.lang.Boolean r3, int r4, java.lang.Object r5) {
            r5 = r4 & 1
            r0 = 0
            if (r5 == 0) goto L6
            r2 = r0
        L6:
            r4 = r4 & 2
            if (r4 == 0) goto Lb
            r3 = r0
        Lb:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r1 = r1.setPrefs(r2, r3)
            return r1
    }

    private final java.net.Proxy socks(int r5) {
            r4 = this;
            java.net.Proxy r0 = new java.net.Proxy
            java.net.Proxy$Type r1 = java.net.Proxy.Type.SOCKS
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress
            java.lang.String r3 = "127.0.0.1"
            r2.<init>(r3, r5)
            r0.<init>(r1, r2)
            return r0
    }

    private final java.lang.Object speedThrough(java.lang.String r4, com.mlmvpn.scanner.engines.argo.ArgoPool.Item r5, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r6, wd.d r7) {
            r3 = this;
            oe.e r0 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2
            r2 = 0
            r1.<init>(r5, r6, r4, r2)
            java.lang.Object r4 = kotlinx.coroutines.m0.J(r0, r1, r7)
            return r4
    }

    private static final java.lang.Comparable summary$lambda$104(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            java.lang.String r1 = r1.getCc()
            java.lang.String r0 = "??"
            boolean r1 = kotlin.jvm.internal.j.a(r1, r0)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
    }

    private static final java.lang.Comparable summary$lambda$105(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            int r1 = r1.getAlive()
            int r1 = -r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            return r1
    }

    private static final java.lang.Comparable summary$lambda$106(com.mlmvpn.scanner.engines.argo.ArgoPool.Group r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            int r1 = r1.getN()
            int r1 = -r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            return r1
    }

    private static final java.lang.Comparable summary$lambda$110(com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin r1) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r1, r0)
            java.lang.String r1 = r1.getCc()
            return r1
    }

    private static final java.lang.Comparable summary$lambda$111(com.mlmvpn.scanner.engines.argo.ArgoProtocol.FalconOrigin r2) {
            java.lang.String r0 = "it"
            kotlin.jvm.internal.j.e(r2, r0)
            double r0 = r2.getLoad()
            java.lang.Double r2 = java.lang.Double.valueOf(r0)
            return r2
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Page telegramPage(java.lang.String r17, java.lang.Long r18, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r19) {
            r16 = this;
            r0 = r18
            com.mlmvpn.scanner.engines.argo.ArgoNet r1 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
            java.lang.String r2 = "UTF-8"
            r3 = r17
            java.lang.String r2 = java.net.URLEncoder.encode(r3, r2)
            java.lang.String r9 = ""
            if (r0 == 0) goto L1f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "?before="
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L20
        L1f:
            r0 = r9
        L20:
            java.lang.String r3 = "https://t.me/s/"
            java.lang.String r0 = a6.w0.n(r3, r2, r0)
            r7 = 8
            r8 = 0
            r3 = 20000(0x4e20, double:9.8813E-320)
            r5 = 0
            r2 = r1
            r1 = r0
            r0 = r2
            r2 = r19
            sd.j r0 = com.mlmvpn.scanner.engines.argo.ArgoNet.fetchText$default(r0, r1, r2, r3, r5, r7, r8)
            java.lang.Object r1 = r0.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.String r0 = (java.lang.String) r0
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 0
            if (r1 != r2) goto L11f
            int r2 = r0.length()
            if (r2 != 0) goto L53
            goto L11f
        L53:
            java.lang.String r2 = "tgme_widget_message_wrap"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            r4 = 6
            java.util.List r0 = kotlin.text.o.b1(r0, r2, r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 1
            java.util.List r0 = kotlin.collections.q.t0(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r0.iterator()
        L70:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L119
            java.lang.Object r0 = r5.next()
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r0 = "data-post=\"[^\"/]+/(\\d+)\""
            r7 = 2
            r8 = 0
            kotlin.text.g r0 = com.mlmvpn.core.aether.i.m(r0, r6, r3, r7, r8)
            if (r0 == 0) goto L112
            kotlin.text.i r0 = (kotlin.text.i) r0
            java.util.List r0 = r0.a()
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L112
            java.lang.Long r0 = kotlin.text.v.w0(r0)
            if (r0 == 0) goto L112
            long r11 = r0.longValue()
            java.lang.String r0 = "<time[^>]*datetime=\"([^\"]+)\""
            kotlin.text.g r0 = com.mlmvpn.core.aether.i.m(r0, r6, r3, r7, r8)
            if (r0 == 0) goto Le7
            kotlin.text.i r0 = (kotlin.text.i) r0
            java.util.List r0 = r0.a()
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Le7
            j$.time.OffsetDateTime r0 = j$.time.OffsetDateTime.parse(r0)     // Catch: java.lang.Throwable -> Lce
            j$.time.Instant r0 = r0.toInstant()     // Catch: java.lang.Throwable -> Lce
            long r13 = r0.toEpochMilli()     // Catch: java.lang.Throwable -> Lce
            java.lang.Long r0 = java.lang.Long.valueOf(r13)     // Catch: java.lang.Throwable -> Lce
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lce
            goto Ld7
        Lce:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)
            java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
        Ld7:
            boolean r10 = sd.l.m1010isFailureimpl(r0)
            if (r10 == 0) goto Lde
            r0 = r8
        Lde:
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto Le7
            long r13 = r0.longValue()
            goto Le9
        Le7:
            r13 = 0
        Le9:
            java.lang.String r0 = "<div class=\"tgme_widget_message_text[^\"]*\"[^>]*>([\\s\\S]*?)</div>"
            kotlin.text.g r0 = com.mlmvpn.core.aether.i.m(r0, r6, r3, r7, r8)
            if (r0 == 0) goto L107
            kotlin.text.i r0 = (kotlin.text.i) r0
            java.util.List r0 = r0.a()
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L107
            com.mlmvpn.scanner.engines.argo.ArgoPool r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            java.lang.String r8 = r6.decodeHtml(r0)
        L107:
            if (r8 != 0) goto L10b
            r15 = r9
            goto L10c
        L10b:
            r15 = r8
        L10c:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Post r10 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Post
            r10.<init>(r11, r13, r15)
            r8 = r10
        L112:
            if (r8 == 0) goto L70
            r4.add(r8)
            goto L70
        L119:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Page
            r0.<init>(r2, r1, r4)
            return r0
        L11f:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Page
            kotlin.collections.w r2 = kotlin.collections.w.INSTANCE
            r0.<init>(r3, r1, r2)
            return r0
    }

    private final java.lang.Object telegramPageRetry(java.lang.String r19, java.lang.Long r20, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r21, ee.a r22, wd.d r23) {
            r18 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.C04011
            if (r1 == 0) goto L17
            r1 = r0
            com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04011) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r18
            goto L1e
        L17:
            com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1
            r2 = r18
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.a r3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r4 = r1.label
            r5 = 0
            r7 = 1
            if (r4 == 0) goto L5a
            if (r4 != r7) goto L52
            int r4 = r1.I$1
            int r8 = r1.I$0
            java.lang.Object r9 = r1.L$6
            long[] r9 = (long[]) r9
            java.lang.Object r10 = r1.L$5
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r10 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Page) r10
            java.lang.Object r11 = r1.L$4
            ee.a r11 = (ee.a) r11
            java.lang.Object r12 = r1.L$3
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r12 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Route) r12
            java.lang.Object r13 = r1.L$2
            java.lang.Long r13 = (java.lang.Long) r13
            java.lang.Object r14 = r1.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r1.L$0
            com.mlmvpn.scanner.engines.argo.ArgoPool r15 = (com.mlmvpn.scanner.engines.argo.ArgoPool) r15
            sd.m.b(r0)
            r16 = r5
            goto Lbc
        L52:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L5a:
            sd.m.b(r0)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Page
            kotlin.collections.w r4 = kotlin.collections.w.INSTANCE
            r8 = 0
            r0.<init>(r8, r8, r4)
            r4 = 5
            long[] r9 = new long[r4]
            r9[r8] = r5
            r10 = 3000(0xbb8, double:1.482E-320)
            r9[r7] = r10
            r10 = 2
            r11 = 8000(0x1f40, double:3.9525E-320)
            r9[r10] = r11
            r10 = 3
            r11 = 20000(0x4e20, double:9.8813E-320)
            r9[r10] = r11
            r10 = 4
            r11 = 45000(0xafc8, double:2.2233E-319)
            r9[r10] = r11
            r13 = r0
            r15 = r2
            r10 = r4
            r11 = r8
            r12 = r9
            r0 = r19
            r4 = r21
            r8 = r22
            r9 = r1
            r1 = r20
        L8c:
            if (r11 >= r10) goto Lea
            r16 = r5
            r5 = r12[r11]
            int r14 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r14 <= 0) goto Lc7
            r9.L$0 = r15
            r9.L$1 = r0
            r9.L$2 = r1
            r9.L$3 = r4
            r9.L$4 = r8
            r9.L$5 = r13
            r9.L$6 = r12
            r9.I$0 = r11
            r9.I$1 = r10
            r9.label = r7
            java.lang.Object r5 = kotlinx.coroutines.m0.j(r5, r9)
            if (r5 != r3) goto Lb1
            return r3
        Lb1:
            r14 = r13
            r13 = r1
            r1 = r9
            r9 = r12
            r12 = r4
            r4 = r10
            r10 = r14
            r14 = r11
            r11 = r8
            r8 = r14
            r14 = r0
        Lbc:
            r0 = r9
            r9 = r1
            r1 = r13
            r13 = r10
            r10 = r4
            r4 = r12
            r12 = r0
            r0 = r11
            r11 = r8
            r8 = r0
            r0 = r14
        Lc7:
            java.lang.Object r5 = r8.invoke()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto Lea
            com.mlmvpn.scanner.engines.argo.ArgoPool$Page r13 = r15.telegramPage(r0, r1, r4)
            boolean r5 = r13.getOk()
            if (r5 != 0) goto Lea
            int r5 = r13.getCode()
            r6 = 404(0x194, float:5.66E-43)
            if (r5 != r6) goto Le6
            goto Lea
        Le6:
            int r11 = r11 + r7
            r5 = r16
            goto L8c
        Lea:
            return r13
    }

    public static /* synthetic */ void test$default(com.mlmvpn.scanner.engines.argo.ArgoPool r1, java.lang.String r2, java.lang.String r3, java.util.List r4, boolean r5, boolean r6, boolean r7, int r8, java.lang.Object r9) {
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = "all"
        L6:
            r9 = r8 & 2
            if (r9 == 0) goto Lc
            java.lang.String r3 = ""
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = 0
        L11:
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto L17
            r5 = r0
        L17:
            r9 = r8 & 16
            if (r9 == 0) goto L1c
            r6 = r0
        L1c:
            r8 = r8 & 32
            if (r8 == 0) goto L28
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2f
        L28:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2f:
            r3.test(r4, r5, r6, r7, r8, r9)
            return
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Source tg(java.lang.String r12) {
            r11 = this;
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source
            java.lang.String r1 = "tg:"
            java.lang.String r1 = v0.a.h(r1, r12)
            java.util.List r3 = m9.d.B(r12)
            java.lang.String r2 = "کانال تلگرام @"
            java.lang.String r4 = v0.a.h(r2, r12)
            r9 = 96
            r10 = 0
            java.lang.String r2 = "telegram"
            r5 = 1
            r6 = 0
            r7 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10)
            return r0
    }

    private final java.lang.Long tlsPing(java.lang.String r6, java.lang.String r7, int r8) {
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L58
            java.net.Socket r2 = new java.net.Socket     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L58
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r6)     // Catch: java.lang.Throwable -> L58
            r4 = 443(0x1bb, float:6.21E-43)
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L58
            r2.connect(r3, r8)     // Catch: java.lang.Throwable -> L58
            r2.setSoTimeout(r8)     // Catch: java.lang.Throwable -> L58
            javax.net.SocketFactory r6 = javax.net.ssl.SSLSocketFactory.getDefault()     // Catch: java.lang.Throwable -> L58
            java.lang.String r8 = "null cannot be cast to non-null type javax.net.ssl.SSLSocketFactory"
            kotlin.jvm.internal.j.c(r6, r8)     // Catch: java.lang.Throwable -> L58
            javax.net.ssl.SSLSocketFactory r6 = (javax.net.ssl.SSLSocketFactory) r6     // Catch: java.lang.Throwable -> L58
            r8 = 1
            java.net.Socket r6 = r6.createSocket(r2, r7, r4, r8)     // Catch: java.lang.Throwable -> L58
            java.lang.String r8 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            kotlin.jvm.internal.j.c(r6, r8)     // Catch: java.lang.Throwable -> L58
            javax.net.ssl.SSLSocket r6 = (javax.net.ssl.SSLSocket) r6     // Catch: java.lang.Throwable -> L58
            javax.net.ssl.SSLParameters r8 = r6.getSSLParameters()     // Catch: java.lang.Throwable -> L5a
            javax.net.ssl.SNIHostName r2 = new javax.net.ssl.SNIHostName     // Catch: java.lang.Throwable -> L5a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            java.util.List r7 = m9.d.B(r2)     // Catch: java.lang.Throwable -> L5a
            r8.setServerNames(r7)     // Catch: java.lang.Throwable -> L5a
            r6.setSSLParameters(r8)     // Catch: java.lang.Throwable -> L5a
            r6.startHandshake()     // Catch: java.lang.Throwable -> L5a
            r6.close()     // Catch: java.lang.Throwable -> L58
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L58
            long r6 = r6 - r0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L58
            java.lang.Object r6 = sd.l.m1004constructorimpl(r6)     // Catch: java.lang.Throwable -> L58
            goto L69
        L58:
            r6 = move-exception
            goto L61
        L5a:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L5c
        L5c:
            r8 = move-exception
            a.a.g(r6, r7)     // Catch: java.lang.Throwable -> L58
            throw r8     // Catch: java.lang.Throwable -> L58
        L61:
            sd.l$a r6 = sd.m.a(r6)
            java.lang.Object r6 = sd.l.m1004constructorimpl(r6)
        L69:
            boolean r7 = sd.l.m1010isFailureimpl(r6)
            if (r7 == 0) goto L70
            r6 = 0
        L70:
            java.lang.Long r6 = (java.lang.Long) r6
            return r6
    }

    public static /* synthetic */ java.lang.Long tlsPing$default(com.mlmvpn.scanner.engines.argo.ArgoPool r0, java.lang.String r1, java.lang.String r2, int r3, int r4, java.lang.Object r5) {
            r4 = r4 & 4
            if (r4 == 0) goto L6
            r3 = 2500(0x9c4, float:3.503E-42)
        L6:
            java.lang.Long r0 = r0.tlsPing(r1, r2, r3)
            return r0
    }

    private final com.mlmvpn.scanner.engines.argo.ArgoPool.Trace traceVia(int r10) {
            r9 = this;
            r0 = 15000(0x3a98, double:7.411E-320)
            okhttp3.OkHttpClient r10 = r9.client(r10, r0)     // Catch: java.lang.Throwable -> L8c
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> L8c
            r0.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = "https://www.cloudflare.com/cdn-cgi/trace"
            r0.j(r1)     // Catch: java.lang.Throwable -> L8c
            okhttp3.Request r1 = new okhttp3.Request     // Catch: java.lang.Throwable -> L8c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8c
            okhttp3.internal.connection.RealCall r10 = r10.b(r1)     // Catch: java.lang.Throwable -> L8c
            okhttp3.Response r10 = r10.d()     // Catch: java.lang.Throwable -> L8c
            okhttp3.ResponseBody r0 = r10.f29156h     // Catch: java.lang.Throwable -> L27
            r1 = 0
            if (r0 == 0) goto L2b
            java.lang.String r0 = r0.w()     // Catch: java.lang.Throwable -> L27
            goto L2c
        L27:
            r0 = move-exception
            r1 = r0
            goto L8f
        L2b:
            r0 = r1
        L2c:
            java.lang.String r2 = ""
            if (r0 != 0) goto L31
            r0 = r2
        L31:
            kotlin.text.l r3 = new kotlin.text.l     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = "(?m)^loc=([A-Z]{2})"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L27
            r4 = 2
            r5 = 0
            kotlin.text.g r3 = kotlin.text.l.find$default(r3, r0, r5, r4, r1)     // Catch: java.lang.Throwable -> L27
            r6 = 1
            if (r3 == 0) goto L50
            kotlin.text.i r3 = (kotlin.text.i) r3     // Catch: java.lang.Throwable -> L27
            java.util.List r3 = r3.a()     // Catch: java.lang.Throwable -> L27
            kotlin.collections.f0 r3 = (kotlin.collections.f0) r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r3 = r3.get(r6)     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L27
            goto L51
        L50:
            r3 = r1
        L51:
            if (r3 != 0) goto L54
            r3 = r2
        L54:
            kotlin.text.l r7 = new kotlin.text.l     // Catch: java.lang.Throwable -> L27
            java.lang.String r8 = "(?m)^ip=(\\S+)"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L27
            kotlin.text.g r0 = kotlin.text.l.find$default(r7, r0, r5, r4, r1)     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L70
            kotlin.text.i r0 = (kotlin.text.i) r0     // Catch: java.lang.Throwable -> L27
            java.util.List r0 = r0.a()     // Catch: java.lang.Throwable -> L27
            kotlin.collections.f0 r0 = (kotlin.collections.f0) r0     // Catch: java.lang.Throwable -> L27
            java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> L27
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L27
        L70:
            if (r1 != 0) goto L73
            goto L74
        L73:
            r2 = r1
        L74:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Trace     // Catch: java.lang.Throwable -> L27
            boolean r1 = r10.A     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L81
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L27
            if (r1 <= 0) goto L81
            r5 = r6
        L81:
            r0.<init>(r5, r3, r2)     // Catch: java.lang.Throwable -> L27
            r10.close()     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r10 = sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> L8c
            goto L9d
        L8c:
            r0 = move-exception
            r10 = r0
            goto L95
        L8f:
            throw r1     // Catch: java.lang.Throwable -> L90
        L90:
            r0 = move-exception
            a.a.g(r10, r1)     // Catch: java.lang.Throwable -> L8c
            throw r0     // Catch: java.lang.Throwable -> L8c
        L95:
            sd.l$a r10 = sd.m.a(r10)
            java.lang.Object r10 = sd.l.m1004constructorimpl(r10)
        L9d:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Trace
            r4 = 6
            r5 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r1 = sd.l.m1010isFailureimpl(r10)
            if (r1 == 0) goto Lae
            r10 = r0
        Lae:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Trace r10 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Trace) r10
            return r10
    }

    public static /* synthetic */ void update$default(com.mlmvpn.scanner.engines.argo.ArgoPool r0, java.util.List r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L5
            r1 = 0
        L5:
            r0.update(r1)
            return
    }

    private final java.lang.Object waitPort(int r8, long r9, wd.d r11) {
            r7 = this;
            boolean r0 = r11 instanceof com.mlmvpn.scanner.engines.argo.ArgoPool.C04041
            if (r0 == 0) goto L13
            r0 = r11
            com.mlmvpn.scanner.engines.argo.ArgoPool$waitPort$1 r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.C04041) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mlmvpn.scanner.engines.argo.ArgoPool$waitPort$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$waitPort$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            long r8 = r0.J$0
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$0
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool) r2
            sd.m.b(r11)
            goto L42
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            sd.m.b(r11)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 + r9
            r2 = r7
            r10 = r8
            r8 = r4
        L42:
            long r4 = java.lang.System.currentTimeMillis()
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            sd.u r4 = sd.u.f67154a
            if (r11 >= 0) goto L8e
            java.net.Socket r11 = new java.net.Socket     // Catch: java.lang.Throwable -> L65
            r11.<init>()     // Catch: java.lang.Throwable -> L65
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "127.0.0.1"
            r5.<init>(r6, r10)     // Catch: java.lang.Throwable -> L67
            r6 = 300(0x12c, float:4.2E-43)
            r11.connect(r5, r6)     // Catch: java.lang.Throwable -> L67
            r11.close()     // Catch: java.lang.Throwable -> L65
            java.lang.Object r11 = sd.l.m1004constructorimpl(r4)     // Catch: java.lang.Throwable -> L65
            goto L76
        L65:
            r11 = move-exception
            goto L6e
        L67:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L69
        L69:
            r6 = move-exception
            a.a.g(r11, r5)     // Catch: java.lang.Throwable -> L65
            throw r6     // Catch: java.lang.Throwable -> L65
        L6e:
            sd.l$a r11 = sd.m.a(r11)
            java.lang.Object r11 = sd.l.m1004constructorimpl(r11)
        L76:
            boolean r11 = sd.l.m1011isSuccessimpl(r11)
            if (r11 == 0) goto L7d
            goto L8e
        L7d:
            r0.L$0 = r2
            r0.I$0 = r10
            r0.J$0 = r8
            r0.label = r3
            r4 = 150(0x96, double:7.4E-322)
            java.lang.Object r11 = kotlinx.coroutines.m0.j(r4, r0)
            if (r11 != r1) goto L42
            return r1
        L8e:
            return r4
    }

    private final void writeJson(java.lang.String r7, java.lang.String r8) {
            r6 = this;
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L3c
            java.io.File r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.dir     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            java.lang.String r3 = "dir"
            if (r1 == 0) goto L4c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r4.<init>()     // Catch: java.lang.Throwable -> L3c
            r4.append(r7)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = ".tmp"
            r4.append(r5)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L3c
            r0.<init>(r1, r4)     // Catch: java.lang.Throwable -> L3c
            ce.o.r0(r0, r8)     // Catch: java.lang.Throwable -> L3c
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L3c
            java.io.File r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.dir     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L48
            r1.<init>(r4, r7)     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r0.renameTo(r1)     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L42
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L3c
            java.io.File r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.dir     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L3e
            r0.<init>(r1, r7)     // Catch: java.lang.Throwable -> L3c
            ce.o.r0(r0, r8)     // Catch: java.lang.Throwable -> L3c
            goto L42
        L3c:
            r7 = move-exception
            goto L50
        L3e:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L3c
            throw r2     // Catch: java.lang.Throwable -> L3c
        L42:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L3c
            sd.l.m1004constructorimpl(r7)     // Catch: java.lang.Throwable -> L3c
            return
        L48:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L3c
            throw r2     // Catch: java.lang.Throwable -> L3c
        L4c:
            kotlin.jvm.internal.j.k(r3)     // Catch: java.lang.Throwable -> L3c
            throw r2     // Catch: java.lang.Throwable -> L3c
        L50:
            sd.l$a r7 = sd.m.a(r7)
            sd.l.m1004constructorimpl(r7)
            return
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoPool.Source addSource(java.lang.String r21) {
            r20 = this;
            java.lang.String r0 = "کانال تلگرام @"
            java.lang.String r1 = "u:"
            java.lang.String r2 = "tg:"
            java.lang.String r3 = "گیت\u200cهاب — "
            java.lang.String r4 = "کانال تلگرام @"
            monitor-enter(r20)
            java.lang.String r5 = "input"
            r6 = r21
            kotlin.jvm.internal.j.e(r6, r5)     // Catch: java.lang.Throwable -> L60
            r20.load()     // Catch: java.lang.Throwable -> L60
            java.lang.CharSequence r5 = kotlin.text.o.n1(r6)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L60
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L60
            if (r6 <= 0) goto L19b
            kotlin.text.l r6 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r7 = "^(?:@|(?:https?://)?(?:t\\.me|telegram\\.me)/(?:s/)?)([A-Za-z][A-Za-z0-9_]{3,31})(?:[/?#].*)?$"
            kotlin.text.m r8 = kotlin.text.m.IGNORE_CASE     // Catch: java.lang.Throwable -> L60
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L60
            r7 = 2
            r9 = 0
            r10 = 0
            kotlin.text.g r6 = kotlin.text.l.find$default(r6, r5, r10, r7, r9)     // Catch: java.lang.Throwable -> L60
            r7 = 1
            if (r6 == 0) goto L63
            sd.q r0 = new sd.q     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "telegram"
            kotlin.text.i r6 = (kotlin.text.i) r6     // Catch: java.lang.Throwable -> L60
            java.util.List r5 = r6.a()     // Catch: java.lang.Throwable -> L60
            kotlin.collections.f0 r5 = (kotlin.collections.f0) r5     // Catch: java.lang.Throwable -> L60
            java.lang.Object r5 = r5.get(r7)     // Catch: java.lang.Throwable -> L60
            java.util.List r6 = r6.a()     // Catch: java.lang.Throwable -> L60
            kotlin.collections.f0 r6 = (kotlin.collections.f0) r6     // Catch: java.lang.Throwable -> L60
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r8.<init>(r4)     // Catch: java.lang.Throwable -> L60
            r8.append(r6)     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = r8.toString()     // Catch: java.lang.Throwable -> L60
            r0.<init>(r3, r5, r4)     // Catch: java.lang.Throwable -> L60
            goto Lc9
        L60:
            r0 = move-exception
            goto L1a3
        L63:
            kotlin.text.l r4 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = "^[A-Za-z][A-Za-z0-9_]{4,31}$"
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L60
            boolean r4 = r4.matches(r5)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L7d
            sd.q r3 = new sd.q     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "telegram"
            java.lang.String r0 = r0.concat(r5)     // Catch: java.lang.Throwable -> L60
            r3.<init>(r4, r5, r0)     // Catch: java.lang.Throwable -> L60
            r0 = r3
            goto Lc9
        L7d:
            kotlin.text.l r0 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "^https?://\\S+$"
            r0.<init>(r4, r8)     // Catch: java.lang.Throwable -> L60
            boolean r0 = r0.matches(r5)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L193
            sd.q r0 = new sd.q     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "url"
            kotlin.text.l r6 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r9 = "github\\.com|githubusercontent\\.com"
            r6.<init>(r9, r8)     // Catch: java.lang.Throwable -> L60
            boolean r6 = r6.containsMatchIn(r5)     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto Lb3
            kotlin.text.l r6 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r9 = "^https?://(raw\\.)?github(usercontent)?\\.com/"
            r6.<init>(r9, r8)     // Catch: java.lang.Throwable -> L60
            java.lang.String r8 = ""
            java.lang.String r6 = r6.replace(r5, r8)     // Catch: java.lang.Throwable -> L60
            r8 = 60
            java.lang.String r6 = kotlin.text.o.l1(r8, r6)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = r3.concat(r6)     // Catch: java.lang.Throwable -> L60
            goto Lc6
        Lb3:
            kotlin.text.l r3 = new kotlin.text.l     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = "^https?://"
            r3.<init>(r6, r8)     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = ""
            java.lang.String r3 = r3.replace(r5, r6)     // Catch: java.lang.Throwable -> L60
            r6 = 70
            java.lang.String r3 = kotlin.text.o.l1(r6, r3)     // Catch: java.lang.Throwable -> L60
        Lc6:
            r0.<init>(r4, r5, r3)     // Catch: java.lang.Throwable -> L60
        Lc9:
            java.lang.Object r3 = r0.component1()     // Catch: java.lang.Throwable -> L60
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L60
            java.lang.Object r3 = r0.component2()     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L60
            java.lang.Object r0 = r0.component3()     // Catch: java.lang.Throwable -> L60
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = "telegram"
            boolean r0 = kotlin.jvm.internal.j.a(r13, r0)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto Lf3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L60
            r0.append(r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
        Lf1:
            r12 = r0
            goto L144
        Lf3:
            java.lang.String r0 = "SHA-1"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.lang.Throwable -> L60
            java.nio.charset.Charset r2 = kotlin.text.a.f23859a     // Catch: java.lang.Throwable -> L60
            byte[] r2 = r3.getBytes(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "getBytes(...)"
            kotlin.jvm.internal.j.d(r2, r4)     // Catch: java.lang.Throwable -> L60
            byte[] r0 = r0.digest(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "digest(...)"
            kotlin.jvm.internal.j.d(r0, r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = ""
            java.lang.String r4 = ""
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r5.<init>()     // Catch: java.lang.Throwable -> L60
            r5.append(r4)     // Catch: java.lang.Throwable -> L60
            int r6 = r0.length     // Catch: java.lang.Throwable -> L60
            r8 = r10
            r9 = r8
        L11c:
            if (r8 >= r6) goto L132
            r11 = r0[r8]     // Catch: java.lang.Throwable -> L60
            int r9 = r9 + r7
            if (r9 <= r7) goto L126
            r5.append(r2)     // Catch: java.lang.Throwable -> L60
        L126:
            java.lang.CharSequence r11 = addSource$lambda$61(r11)     // Catch: java.lang.Throwable -> L60
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> L60
            r5.append(r11)     // Catch: java.lang.Throwable -> L60
            int r8 = r8 + 1
            goto L11c
        L132:
            r5.append(r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L60
            r2 = 12
            java.lang.String r0 = kotlin.text.o.l1(r2, r0)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r1.concat(r0)     // Catch: java.lang.Throwable -> L60
            goto Lf1
        L144:
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.BUILTIN     // Catch: java.lang.Throwable -> L60
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L60
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L60
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L60
            java.util.ArrayList r0 = kotlin.collections.q.S0(r0, r1)     // Catch: java.lang.Throwable -> L60
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L157
            goto L178
        L157:
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L60
        L15b:
            if (r10 >= r1) goto L178
            java.lang.Object r2 = r0.get(r10)     // Catch: java.lang.Throwable -> L60
            int r10 = r10 + 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r2     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = r2.getId()     // Catch: java.lang.Throwable -> L60
            boolean r2 = kotlin.text.v.m0(r2, r12)     // Catch: java.lang.Throwable -> L60
            if (r2 != 0) goto L170
            goto L15b
        L170:
            java.lang.String r0 = "این منبع قبلاً اضافه شده است"
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L60
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L60
            throw r1     // Catch: java.lang.Throwable -> L60
        L178:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r11 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Source     // Catch: java.lang.Throwable -> L60
            java.util.List r14 = m9.d.B(r3)     // Catch: java.lang.Throwable -> L60
            long r18 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L60
            r16 = 0
            r17 = 1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L60
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L60
            r0.add(r11)     // Catch: java.lang.Throwable -> L60
            r20.saveNow()     // Catch: java.lang.Throwable -> L60
            monitor-exit(r20)
            return r11
        L193:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "این نشانی شناخته نشد — نام کانال تلگرام (@name یا t.me/name) یا یک نشانی http(s) از گیت\u200cهاب یا هر سایتی بدهید"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60
            throw r0     // Catch: java.lang.Throwable -> L60
        L19b:
            java.lang.String r0 = "نشانی منبع خالی است"
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L60
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L60
            throw r1     // Catch: java.lang.Throwable -> L60
        L1a3:
            monitor-exit(r20)     // Catch: java.lang.Throwable -> L60
            throw r0
    }

    public final java.lang.String cleanIp() {
            r1 = this;
            r1.load()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs
            java.lang.String r0 = r0.getCleanIp()
            return r0
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint endpointFromRaw(java.lang.String r15) {
            r14 = this;
            monitor-enter(r14)
            java.lang.String r1 = "raw"
            kotlin.jvm.internal.j.e(r15, r1)     // Catch: java.lang.Throwable -> L68
            r14.load()     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r1 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L68
            java.util.List r2 = r1.extractBridgeBlocks(r15)     // Catch: java.lang.Throwable -> L68
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L68
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L68
            r13 = 0
            if (r3 != 0) goto L72
            java.lang.Object r0 = r2.get(r13)     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Bridge r0 = r1.decodeBridgeBlock(r0)     // Catch: java.lang.Throwable -> L68
            boolean r1 = r0.getSigOk()     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L6a
            java.lang.String r2 = "bridge"
            java.lang.String r3 = r0.getHost()     // Catch: java.lang.Throwable -> L68
            int r4 = r0.getPort()     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = r0.getProtocol()     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = "user"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L68
            r11 = 128(0x80, float:1.794E-43)
            r12 = 0
            r9 = 1
            r10 = 0
            r1 = r14
            addItem$default(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L68
            r14.saveSoon()     // Catch: java.lang.Throwable -> L68
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "bridge"
            java.lang.String r4 = r0.getHost()     // Catch: java.lang.Throwable -> L68
            int r0 = r0.getPort()     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = r14.idOf(r3, r4, r0)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L68
            kotlin.jvm.internal.j.b(r0)     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r14.endpointOf(r0)     // Catch: java.lang.Throwable -> L68
            monitor-exit(r14)
            return r0
        L68:
            r0 = move-exception
            goto Lc6
        L6a:
            java.lang.String r0 = "امضای این بلاک پل معتبر نیست — بلاک ناقص کپی شده یا ساختگی است"
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L68
            throw r1     // Catch: java.lang.Throwable -> L68
        L72:
            r3 = 1
            java.util.List r0 = r1.extractFalconHosts(r15, r3)     // Catch: java.lang.Throwable -> L68
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L68
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto Lbe
            java.lang.String r2 = "falcon"
            java.lang.Object r1 = r0.get(r13)     // Catch: java.lang.Throwable -> L68
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "A"
            java.lang.String r6 = "user"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L68
            r11 = 128(0x80, float:1.794E-43)
            r12 = 0
            r4 = 443(0x1bb, float:6.21E-43)
            r9 = 1
            r10 = 0
            r1 = r14
            addItem$default(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L68
            r14.saveSoon()     // Catch: java.lang.Throwable -> L68
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "falcon"
            java.lang.Object r0 = r0.get(r13)     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L68
            r4 = 443(0x1bb, float:6.21E-43)
            java.lang.String r0 = r14.idOf(r3, r0, r4)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r2.get(r0)     // Catch: java.lang.Throwable -> L68
            kotlin.jvm.internal.j.b(r0)     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L68
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r14.endpointOf(r0)     // Catch: java.lang.Throwable -> L68
            monitor-exit(r14)
            return r0
        Lbe:
            java.lang.String r0 = "نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن"
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L68
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L68
            throw r2     // Catch: java.lang.Throwable -> L68
        Lc6:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L68
            throw r0
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint get(java.lang.String r2) {
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.j.e(r2, r0)     // Catch: java.lang.Throwable -> L1a
            r1.load()     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L1a
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r2     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L1c
            com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L1a
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r2 = r0.endpointOf(r2)     // Catch: java.lang.Throwable -> L1a
            goto L1d
        L1a:
            r2 = move-exception
            goto L1f
        L1c:
            r2 = 0
        L1d:
            monitor-exit(r1)
            return r2
        L1f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1a
            throw r2
    }

    public final com.mlmvpn.scanner.engines.argo.ArgoPool.IpScan getIpScan() {
            r1 = this;
            com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.ipScan
            return r0
    }

    public final com.mlmvpn.scanner.engines.argo.ArgoPool.Job getTestJob() {
            r1 = this;
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.testJob
            return r0
    }

    public final com.mlmvpn.scanner.engines.argo.ArgoPool.Job getUpdateJob() {
            r1 = this;
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.updateJob
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getVersion() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.version
            return r0
    }

    public final synchronized sd.j importFromChat(java.lang.String r11) {
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.j.e(r11, r0)     // Catch: java.lang.Throwable -> L106
            r10.load()     // Catch: java.lang.Throwable -> L106
            java.lang.String r3 = "user"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L106
            r6 = 1
            r7 = 1
            r1 = r10
            r2 = r11
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r11 = r1.absorbText(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> Lfb
            r10.saveNow()     // Catch: java.lang.Throwable -> L106
            com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed r0 = r10.parse(r2)     // Catch: java.lang.Throwable -> L106
            java.util.List r1 = r0.getBridges()     // Catch: java.lang.Throwable -> L106
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L106
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L106
            r2.<init>()     // Catch: java.lang.Throwable -> L106
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L106
        L2d:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L106
            if (r3 == 0) goto L53
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L4e
            r4 = r3
            com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge) r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r4.getSigOk()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L2d
            java.lang.String r4 = r4.getHost()     // Catch: java.lang.Throwable -> L4e
            boolean r4 = kotlin.text.o.L0(r4)     // Catch: java.lang.Throwable -> L4e
            if (r4 != 0) goto L2d
            r2.add(r3)     // Catch: java.lang.Throwable -> L4e
            goto L2d
        L4e:
            r0 = move-exception
            r11 = r0
            r1 = r10
            goto L109
        L53:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L106
            r3 = 10
            int r4 = kotlin.collections.s.g0(r2, r3)     // Catch: java.lang.Throwable -> L106
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L106
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L106
            r5 = 0
        L63:
            if (r5 >= r4) goto L81
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> L4e
            int r5 = r5 + 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.ParsedBridge) r6     // Catch: java.lang.Throwable -> L4e
            com.mlmvpn.scanner.engines.argo.ArgoPool r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "bridge"
            java.lang.String r9 = r6.getHost()     // Catch: java.lang.Throwable -> L4e
            int r6 = r6.getPort()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = r7.idOf(r8, r9, r6)     // Catch: java.lang.Throwable -> L4e
            r1.add(r6)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L81:
            java.util.List r0 = r0.getFalcons()     // Catch: java.lang.Throwable -> L106
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L106
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L106
            int r3 = kotlin.collections.s.g0(r0, r3)     // Catch: java.lang.Throwable -> L106
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L106
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L106
        L94:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> L106
            if (r3 == 0) goto Lae
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L4e
            com.mlmvpn.scanner.engines.argo.ArgoPool r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = "falcon"
            r6 = 443(0x1bb, float:6.21E-43)
            java.lang.String r3 = r4.idOf(r5, r3, r6)     // Catch: java.lang.Throwable -> L4e
            r2.add(r3)     // Catch: java.lang.Throwable -> L4e
            goto L94
        Lae:
            java.util.ArrayList r0 = kotlin.collections.q.S0(r1, r2)     // Catch: java.lang.Throwable -> L106
            java.util.List r0 = kotlin.collections.q.s0(r0)     // Catch: java.lang.Throwable -> L106
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L106
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L106
            r4.<init>()     // Catch: java.lang.Throwable -> L106
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L106
        Lc1:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L106
            if (r1 == 0) goto Lda
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L4e
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L4e
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L4e
            boolean r2 = r3.containsKey(r2)     // Catch: java.lang.Throwable -> L4e
            if (r2 == 0) goto Lc1
            r4.add(r1)     // Catch: java.lang.Throwable -> L4e
            goto Lc1
        Lda:
            boolean r0 = r4.isEmpty()     // Catch: java.lang.Throwable -> L106
            if (r0 != 0) goto Lfe
            r8 = 59
            r9 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r10
            test$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lf2
            sd.u r0 = sd.u.f67154a     // Catch: java.lang.Throwable -> Lf2
            sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lf2
            goto Lff
        Lf2:
            r0 = move-exception
            sd.l$a r0 = sd.m.a(r0)     // Catch: java.lang.Throwable -> Lfb
            sd.l.m1004constructorimpl(r0)     // Catch: java.lang.Throwable -> Lfb
            goto Lff
        Lfb:
            r0 = move-exception
        Lfc:
            r11 = r0
            goto L109
        Lfe:
            r1 = r10
        Lff:
            sd.j r0 = new sd.j     // Catch: java.lang.Throwable -> Lfb
            r0.<init>(r11, r4)     // Catch: java.lang.Throwable -> Lfb
            monitor-exit(r10)
            return r0
        L106:
            r0 = move-exception
            r1 = r10
            goto Lfc
        L109:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lfb
            throw r11
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoPool.Absorbed importText(java.lang.String r9) {
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.j.e(r9, r0)     // Catch: java.lang.Throwable -> L1f
            r8.load()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = "user"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1f
            r6 = 1
            r7 = 1
            r1 = r8
            r2 = r9
            com.mlmvpn.scanner.engines.argo.ArgoPool$Absorbed r9 = r1.absorbText(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L1c
            r8.saveNow()     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r8)
            return r9
        L1c:
            r0 = move-exception
        L1d:
            r9 = r0
            goto L22
        L1f:
            r0 = move-exception
            r1 = r8
            goto L1d
        L22:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L1c
            throw r9
    }

    public final void init(android.content.Context r3) {
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r3, r0)
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.app
            if (r0 == 0) goto La
            return
        La:
            android.content.Context r3 = r3.getApplicationContext()
            com.mlmvpn.scanner.engines.argo.ArgoPool.app = r3
            java.io.File r3 = new java.io.File
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.app
            if (r0 == 0) goto L25
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r1 = "argo"
            r3.<init>(r0, r1)
            r3.mkdirs()
            com.mlmvpn.scanner.engines.argo.ArgoPool.dir = r3
            return
        L25:
            java.lang.String r3 = "app"
            kotlin.jvm.internal.j.k(r3)
            r3 = 0
            throw r3
    }

    public final boolean isIpLiteral(java.lang.String r3) {
            r2 = this;
            java.lang.String r0 = "s"
            java.lang.String r3 = com.mlmvpn.core.aether.i.h(r3, r0, r3)
            r0 = 2
            char[] r0 = new char[r0]
            r0 = {x0056: FILL_ARRAY_DATA , data: [91, 93} // fill-array
            java.lang.String r3 = kotlin.text.o.o1(r3, r0)
            kotlin.text.l r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.IPV4_LITERAL
            boolean r0 = r0.matches(r3)
            if (r0 == 0) goto L1a
            r3 = 1
            return r3
        L1a:
            r0 = 58
            boolean r0 = kotlin.text.o.z0(r3, r0)
            if (r0 == 0) goto L53
            java.lang.String r0 = "^[0-9A-Fa-f:.]+$"
            boolean r0 = com.mlmvpn.core.aether.i.B(r0, r3)
            if (r0 != 0) goto L2b
            goto L53
        L2b:
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r3)     // Catch: java.lang.Throwable -> L3a
            boolean r3 = r3 instanceof java.net.Inet6Address     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r3 = sd.l.m1004constructorimpl(r3)     // Catch: java.lang.Throwable -> L3a
            goto L43
        L3a:
            r3 = move-exception
            sd.l$a r3 = sd.m.a(r3)
            java.lang.Object r3 = sd.l.m1004constructorimpl(r3)
        L43:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r1 = sd.l.m1010isFailureimpl(r3)
            if (r1 == 0) goto L4c
            r3 = r0
        L4c:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            return r3
        L53:
            r3 = 0
            return r3
    }

    public final com.mlmvpn.scanner.engines.argo.ArgoPool.Parsed parse(java.lang.String r12) {
            r11 = this;
            java.lang.String r0 = "text"
            kotlin.jvm.internal.j.e(r12, r0)
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r0 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
            java.util.List r0 = r0.extractBridgeBlocks(r12)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.s.g0(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r2 = r0.iterator()
        L1c:
            boolean r0 = r2.hasNext()
            java.lang.String r3 = ""
            if (r0 == 0) goto L5b
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r4 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Bridge r0 = r4.decodeBridgeBlock(r0)     // Catch: java.lang.Throwable -> L46
            com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = r0.getHost()     // Catch: java.lang.Throwable -> L46
            int r6 = r0.getPort()     // Catch: java.lang.Throwable -> L46
            boolean r7 = r0.getSigOk()     // Catch: java.lang.Throwable -> L46
            r9 = 8
            r10 = 0
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L46
            goto L57
        L46:
            r0 = move-exception
            com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$ParsedBridge
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L51
            java.lang.String r0 = "بلاک پل خوانده نشد"
        L51:
            r5 = 443(0x1bb, float:6.21E-43)
            r6 = 0
            r4.<init>(r3, r5, r6, r0)
        L57:
            r1.add(r4)
            goto L1c
        L5b:
            kotlin.text.l r0 = new kotlin.text.l
            java.lang.String r2 = "-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+"
            kotlin.text.m r4 = kotlin.text.m.IGNORE_CASE
            r0.<init>(r2, r4)
            java.lang.String r12 = r0.replace(r12, r3)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Parsed
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r2 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
            r3 = 1
            java.util.List r12 = r2.extractFalconHosts(r12, r3)
            r0.<init>(r1, r12)
            return r0
    }

    public final synchronized java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint> pick(int r11) {
            r10 = this;
            monitor-enter(r10)
            r10.load()     // Catch: java.lang.Throwable -> L47
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L47
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r1)     // Catch: java.lang.Throwable -> L47
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L47
            java.util.List r0 = kotlin.collections.q.k1(r0)     // Catch: java.lang.Throwable -> L47
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L47
            r2.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L47
        L21:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L4a
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L47
            r4 = r3
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r4     // Catch: java.lang.Throwable -> L47
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getId()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L47
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r4     // Catch: java.lang.Throwable -> L47
            if (r4 == 0) goto L21
            boolean r4 = r4.getOk()     // Catch: java.lang.Throwable -> L47
            r5 = 1
            if (r4 != r5) goto L21
            r2.add(r3)     // Catch: java.lang.Throwable -> L47
            goto L21
        L47:
            r11 = move-exception
            goto L112
        L4a:
            com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedBy$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedBy$1     // Catch: java.lang.Throwable -> L47
            r1.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.List r1 = kotlin.collections.q.b1(r2, r1)     // Catch: java.lang.Throwable -> L47
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L47
            r3.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L47
        L5f:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L47
            r5 = 0
            if (r4 == 0) goto L86
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L47
            r7 = r4
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r7     // Catch: java.lang.Throwable -> L47
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L47
            java.lang.String r9 = r7.getId()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r8 = r8.get(r9)     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L5f
            long r7 = r7.getV0()     // Catch: java.lang.Throwable -> L47
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5f
            r3.add(r4)     // Catch: java.lang.Throwable -> L47
            goto L5f
        L86:
            com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$1 r2 = new com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$1     // Catch: java.lang.Throwable -> L47
            r2.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.List r2 = kotlin.collections.q.b1(r3, r2)     // Catch: java.lang.Throwable -> L47
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L47
            r3.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L47
        L9a:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r4 == 0) goto Lcb
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Throwable -> L47
            r7 = r4
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r7     // Catch: java.lang.Throwable -> L47
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r8 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L47
            java.lang.String r9 = r7.getId()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r8 = r8.get(r9)     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L9a
            long r8 = r7.getV0()     // Catch: java.lang.Throwable -> L47
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L9a
            java.lang.String r7 = r7.getKind()     // Catch: java.lang.Throwable -> L47
            java.lang.String r8 = "falcon"
            boolean r7 = kotlin.jvm.internal.j.a(r7, r8)     // Catch: java.lang.Throwable -> L47
            if (r7 != 0) goto L9a
            r3.add(r4)     // Catch: java.lang.Throwable -> L47
            goto L9a
        Lcb:
            com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$2     // Catch: java.lang.Throwable -> L47
            r0.<init>()     // Catch: java.lang.Throwable -> L47
            java.util.List r0 = kotlin.collections.q.b1(r3, r0)     // Catch: java.lang.Throwable -> L47
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L47
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r1 = kotlin.collections.q.S0(r1, r2)     // Catch: java.lang.Throwable -> L47
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r0 = kotlin.collections.q.S0(r1, r0)     // Catch: java.lang.Throwable -> L47
            java.util.List r11 = kotlin.collections.q.e1(r0, r11)     // Catch: java.lang.Throwable -> L47
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L47
            r1 = 10
            int r1 = kotlin.collections.s.g0(r11, r1)     // Catch: java.lang.Throwable -> L47
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L47
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L47
        Lf7:
            boolean r1 = r11.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L110
            java.lang.Object r1 = r11.next()     // Catch: java.lang.Throwable -> L47
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r1 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r1     // Catch: java.lang.Throwable -> L47
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L47
            kotlin.jvm.internal.j.b(r1)     // Catch: java.lang.Throwable -> L47
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r1 = r2.endpointOf(r1)     // Catch: java.lang.Throwable -> L47
            r0.add(r1)     // Catch: java.lang.Throwable -> L47
            goto Lf7
        L110:
            monitor-exit(r10)
            return r0
        L112:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L47
            throw r11
    }

    public final synchronized void record(java.lang.String r14, boolean r15, long r16, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22) {
            r13 = this;
            monitor-enter(r13)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.j.e(r14, r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "cc"
            r1 = r18
            kotlin.jvm.internal.j.e(r1, r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "exitIp"
            r6 = r19
            kotlin.jvm.internal.j.e(r6, r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "error"
            r10 = r20
            kotlin.jvm.internal.j.e(r10, r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = "edge"
            r12 = r22
            kotlin.jvm.internal.j.e(r12, r0)     // Catch: java.lang.Throwable -> L3e
            r13.load()     // Catch: java.lang.Throwable -> L3e
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r2 = r0.get(r14)     // Catch: java.lang.Throwable -> L3e
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r2     // Catch: java.lang.Throwable -> L3e
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Result     // Catch: java.lang.Throwable -> L3e
            if (r15 != 0) goto L48
            boolean r3 = kotlin.text.o.L0(r18)     // Catch: java.lang.Throwable -> L3e
            if (r3 == 0) goto L48
            if (r2 == 0) goto L41
            java.lang.String r3 = r2.getCc()     // Catch: java.lang.Throwable -> L3e
            goto L42
        L3e:
            r0 = move-exception
            r14 = r0
            goto L6c
        L41:
            r3 = 0
        L42:
            if (r3 != 0) goto L46
            java.lang.String r3 = ""
        L46:
            r5 = r3
            goto L4a
        L48:
            r5 = r18
        L4a:
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3e
            r3 = 0
            if (r15 == 0) goto L58
        L51:
            r2 = r15
            r11 = r21
            r9 = r3
            r3 = r16
            goto L61
        L58:
            if (r2 == 0) goto L5e
            int r3 = r2.getFails()     // Catch: java.lang.Throwable -> L3e
        L5e:
            int r3 = r3 + 1
            goto L51
        L61:
            r1.<init>(r2, r3, r5, r6, r7, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L3e
            r0.put(r14, r1)     // Catch: java.lang.Throwable -> L3e
            r13.saveSoon()     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r13)
            return
        L6c:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L3e
            throw r14
    }

    public final synchronized int remove(java.util.List<java.lang.String> r4) {
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "ids"
            kotlin.jvm.internal.j.e(r4, r0)     // Catch: java.lang.Throwable -> L2a
            r3.load()     // Catch: java.lang.Throwable -> L2a
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L2a
            r0 = 0
        Le:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L2a
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r2.remove(r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto Le
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L2a
            r2.remove(r1)     // Catch: java.lang.Throwable -> L2a
            int r0 = r0 + 1
            goto Le
        L2a:
            r4 = move-exception
            goto L31
        L2c:
            r3.saveNow()     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r3)
            return r0
        L31:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2a
            throw r4
    }

    public final synchronized int removeDead() {
            r5 = this;
            monitor-enter(r5)
            r5.load()     // Catch: java.lang.Throwable -> L46
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L46
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L46
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r1)     // Catch: java.lang.Throwable -> L46
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L46
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L46
            r1.<init>()     // Catch: java.lang.Throwable -> L46
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L46
        L1a:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L48
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L46
            r3 = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r3     // Catch: java.lang.Throwable -> L46
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = r3.getId()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Throwable -> L46
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r3     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L1a
            boolean r4 = r3.getOk()     // Catch: java.lang.Throwable -> L46
            if (r4 != 0) goto L1a
            int r3 = r3.getFails()     // Catch: java.lang.Throwable -> L46
            r4 = 3
            if (r3 < r4) goto L1a
            r1.add(r2)     // Catch: java.lang.Throwable -> L46
            goto L1a
        L46:
            r0 = move-exception
            goto L70
        L48:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L46
            r2 = 10
            int r2 = kotlin.collections.s.g0(r1, r2)     // Catch: java.lang.Throwable -> L46
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L46
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L46
            r3 = 0
        L58:
            if (r3 >= r2) goto L6a
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L46
            int r3 = r3 + 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r4     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = r4.getId()     // Catch: java.lang.Throwable -> L46
            r0.add(r4)     // Catch: java.lang.Throwable -> L46
            goto L58
        L6a:
            int r0 = r5.remove(r0)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r5)
            return r0
        L70:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L46
            throw r0
    }

    public final synchronized boolean removeSource(java.lang.String r3) {
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.j.e(r3, r0)     // Catch: java.lang.Throwable -> L1e
            r2.load()     // Catch: java.lang.Throwable -> L1e
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L1e
            com.mlmvpn.scanner.engines.argo.c r1 = new com.mlmvpn.scanner.engines.argo.c     // Catch: java.lang.Throwable -> L1e
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L1e
            boolean r0 = kotlin.collections.q.V0(r1, r0)     // Catch: java.lang.Throwable -> L1e
            java.util.HashMap<java.lang.String, sf.c> r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L1e
            r1.remove(r3)     // Catch: java.lang.Throwable -> L1e
            r2.saveNow()     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r2)
            return r0
        L1e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
            throw r3
    }

    public final synchronized sd.j rows(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11) {
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.j.e(r7, r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = "cc"
            kotlin.jvm.internal.j.e(r8, r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = "q"
            kotlin.jvm.internal.j.e(r9, r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = "only"
            kotlin.jvm.internal.j.e(r10, r0)     // Catch: java.lang.Throwable -> L57
            r6.load()     // Catch: java.lang.Throwable -> L57
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L57
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r1)     // Catch: java.lang.Throwable -> L57
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.List r0 = kotlin.collections.q.k1(r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "all"
            boolean r1 = r7.equals(r1)     // Catch: java.lang.Throwable -> L57
            if (r1 != 0) goto L5b
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r1.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L3c:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L57
            r3 = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r3     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r3.getKind()     // Catch: java.lang.Throwable -> L57
            boolean r3 = kotlin.jvm.internal.j.a(r3, r7)     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L3c
            r1.add(r2)     // Catch: java.lang.Throwable -> L57
            goto L3c
        L57:
            r7 = move-exception
            goto L1e4
        L5a:
            r0 = r1
        L5b:
            boolean r7 = kotlin.text.o.L0(r8)     // Catch: java.lang.Throwable -> L57
            if (r7 != 0) goto L8d
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L6c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L8c
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L57
            r2 = r1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r2     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.ArgoPool r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L57
            kotlin.jvm.internal.j.b(r2)     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = r3.ccOf(r2)     // Catch: java.lang.Throwable -> L57
            boolean r2 = kotlin.jvm.internal.j.a(r2, r8)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L6c
            r7.add(r1)     // Catch: java.lang.Throwable -> L57
            goto L6c
        L8c:
            r0 = r7
        L8d:
            int r7 = r10.hashCode()     // Catch: java.lang.Throwable -> L57
            r8 = -1994383672(0xffffffff89201ec8, float:-1.9273773E-33)
            r1 = 1
            if (r7 == r8) goto L10a
            r8 = 3599307(0x36ebcb, float:5.043703E-39)
            if (r7 == r8) goto Ldf
            r8 = 92903629(0x58998cd, float:1.2939548E-35)
            if (r7 == r8) goto La3
            goto L139
        La3:
            java.lang.String r7 = "alive"
            boolean r7 = r10.equals(r7)     // Catch: java.lang.Throwable -> L57
            if (r7 != 0) goto Lad
            goto L139
        Lad:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r8 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        Lb8:
            boolean r10 = r8.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto Ldd
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L57
            r0 = r10
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L57
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = r0.getId()     // Catch: java.lang.Throwable -> L57
            java.lang.Object r0 = r2.get(r0)     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r0     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto Lb8
            boolean r0 = r0.getOk()     // Catch: java.lang.Throwable -> L57
            if (r0 != r1) goto Lb8
            r7.add(r10)     // Catch: java.lang.Throwable -> L57
            goto Lb8
        Ldd:
            r0 = r7
            goto L139
        Ldf:
            java.lang.String r7 = "user"
            boolean r7 = r10.equals(r7)     // Catch: java.lang.Throwable -> L57
            if (r7 != 0) goto Le8
            goto L139
        Le8:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r8 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        Lf3:
            boolean r10 = r8.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto Ldd
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L57
            r0 = r10
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L57
            boolean r0 = r0.getUser()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto Lf3
            r7.add(r10)     // Catch: java.lang.Throwable -> L57
            goto Lf3
        L10a:
            java.lang.String r7 = "verified"
            boolean r7 = r10.equals(r7)     // Catch: java.lang.Throwable -> L57
            if (r7 != 0) goto L113
            goto L139
        L113:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r7.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r8 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L11e:
            boolean r10 = r8.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto Ldd
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L57
            r0 = r10
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r0 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r0     // Catch: java.lang.Throwable -> L57
            long r2 = r0.getV0()     // Catch: java.lang.Throwable -> L57
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L11e
            r7.add(r10)     // Catch: java.lang.Throwable -> L57
            goto L11e
        L139:
            java.lang.CharSequence r7 = kotlin.text.o.n1(r9)     // Catch: java.lang.Throwable -> L57
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L57
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L57
            java.lang.String r7 = r7.toLowerCase(r8)     // Catch: java.lang.Throwable -> L57
            java.lang.String r8 = "toLowerCase(...)"
            kotlin.jvm.internal.j.d(r7, r8)     // Catch: java.lang.Throwable -> L57
            int r8 = r7.length()     // Catch: java.lang.Throwable -> L57
            r9 = 0
            if (r8 <= 0) goto L17a
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r8.<init>()     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r10 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L15e:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L179
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Throwable -> L57
            r2 = r0
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r2 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r2     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = r2.getHost()     // Catch: java.lang.Throwable -> L57
            boolean r2 = kotlin.text.o.y0(r2, r7, r9)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L15e
            r8.add(r0)     // Catch: java.lang.Throwable -> L57
            goto L15e
        L179:
            r0 = r8
        L17a:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.d r7 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L57
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.d r8 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L57
            r10 = 4
            r8.<init>(r10)     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.d r10 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L57
            r2 = 5
            r10.<init>(r2)     // Catch: java.lang.Throwable -> L57
            r2 = 3
            ee.c[] r2 = new ee.c[r2]     // Catch: java.lang.Throwable -> L57
            r2[r9] = r7     // Catch: java.lang.Throwable -> L57
            r2[r1] = r8     // Catch: java.lang.Throwable -> L57
            r7 = 2
            r2[r7] = r10     // Catch: java.lang.Throwable -> L57
            androidx.compose.foundation.text.selection.a1 r7 = x6.p.d(r2)     // Catch: java.lang.Throwable -> L57
            java.util.List r7 = kotlin.collections.q.b1(r0, r7)     // Catch: java.lang.Throwable -> L57
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L57
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L57
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L57
            r9 = 2000(0x7d0, float:2.803E-42)
            int r9 = com.google.android.gms.internal.mlkit_language_id_common.j.d(r11, r1, r9)     // Catch: java.lang.Throwable -> L57
            java.util.List r7 = kotlin.collections.q.e1(r7, r9)     // Catch: java.lang.Throwable -> L57
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L57
            r10 = 10
            int r10 = kotlin.collections.s.g0(r7, r10)     // Catch: java.lang.Throwable -> L57
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L57
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L57
        L1c4:
            boolean r10 = r7.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto L1dd
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r10 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r10     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.ArgoPool r11 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L57
            kotlin.jvm.internal.j.b(r10)     // Catch: java.lang.Throwable -> L57
            com.mlmvpn.scanner.engines.argo.ArgoPool$Row r10 = r11.rowOf(r10)     // Catch: java.lang.Throwable -> L57
            r9.add(r10)     // Catch: java.lang.Throwable -> L57
            goto L1c4
        L1dd:
            sd.j r7 = new sd.j     // Catch: java.lang.Throwable -> L57
            r7.<init>(r8, r9)     // Catch: java.lang.Throwable -> L57
            monitor-exit(r6)
            return r7
        L1e4:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L57
            throw r7
    }

    public final synchronized void saveNow() {
            r10 = this;
            monitor-enter(r10)
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.loaded     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L7
            monitor-exit(r10)
            return
        L7:
            java.lang.String r0 = "pool.json"
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L3c
            java.util.Collection r1 = r1.values()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L3c
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L3c
        L1f:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3f
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L3c
            r4 = r3
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r4     // Catch: java.lang.Throwable -> L3c
            java.lang.String r4 = r4.getSrc()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = "bundled"
            boolean r4 = kotlin.jvm.internal.j.a(r4, r5)     // Catch: java.lang.Throwable -> L3c
            if (r4 != 0) goto L1f
            r2.add(r3)     // Catch: java.lang.Throwable -> L3c
            goto L1f
        L3c:
            r0 = move-exception
            goto L166
        L3f:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3c
            r3 = 10
            int r4 = kotlin.collections.s.g0(r2, r3)     // Catch: java.lang.Throwable -> L3c
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L3c
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L3c
            r5 = 0
        L4f:
            if (r5 >= r4) goto L66
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> L3c
            int r5 = r5 + 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r6     // Catch: java.lang.Throwable -> L3c
            com.mlmvpn.scanner.engines.argo.ArgoPool r7 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L3c
            kotlin.jvm.internal.j.b(r6)     // Catch: java.lang.Throwable -> L3c
            sf.c r6 = r7.itemJson(r6)     // Catch: java.lang.Throwable -> L3c
            r1.add(r6)     // Catch: java.lang.Throwable -> L3c
            goto L4f
        L66:
            sf.a r2 = new sf.a     // Catch: java.lang.Throwable -> L3c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L3c
            r10.writeJson(r0, r1)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r0 = "results.json"
            sf.c r1 = new sf.c     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L3c
            java.util.Set r2 = r2.entrySet()     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L3c
        L88:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto Laa
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L3c
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> L3c
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r4     // Catch: java.lang.Throwable -> L3c
            com.mlmvpn.scanner.engines.argo.ArgoPool r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L3c
            sf.c r4 = r6.resultJson(r4)     // Catch: java.lang.Throwable -> L3c
            r1.D(r5, r4)     // Catch: java.lang.Throwable -> L3c
            goto L88
        Laa:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L3c
            r10.writeJson(r0, r1)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r0 = "sources.json"
            sf.c r1 = new sf.c     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "list"
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L3c
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L3c
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3c
            int r3 = kotlin.collections.s.g0(r4, r3)     // Catch: java.lang.Throwable -> L3c
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r3 = r4.iterator()     // Catch: java.lang.Throwable -> L3c
        Ld0:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L11a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L3c
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r4     // Catch: java.lang.Throwable -> L3c
            sf.c r6 = new sf.c     // Catch: java.lang.Throwable -> L3c
            r6.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = "id"
            java.lang.String r8 = r4.getId()     // Catch: java.lang.Throwable -> L3c
            r6.D(r7, r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = "type"
            java.lang.String r8 = r4.getType()     // Catch: java.lang.Throwable -> L3c
            r6.D(r7, r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = "value"
            java.util.List r8 = r4.getValue()     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r8 = kotlin.collections.q.y0(r8)     // Catch: java.lang.Throwable -> L3c
            r6.D(r7, r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = "label"
            java.lang.String r8 = r4.getLabel()     // Catch: java.lang.Throwable -> L3c
            r6.D(r7, r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = "addedAt"
            long r8 = r4.getAddedAt()     // Catch: java.lang.Throwable -> L3c
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L3c
            r6.D(r7, r4)     // Catch: java.lang.Throwable -> L3c
            r5.add(r6)     // Catch: java.lang.Throwable -> L3c
            goto Ld0
        L11a:
            sf.a r3 = new sf.a     // Catch: java.lang.Throwable -> L3c
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L3c
            r1.D(r2, r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "state"
            sf.c r3 = new sf.c     // Catch: java.lang.Throwable -> L3c
            r3.<init>()     // Catch: java.lang.Throwable -> L3c
            java.util.HashMap<java.lang.String, sf.c> r4 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L3c
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L3c
        L133:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L14f
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L3c
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> L3c
            sf.c r5 = (sf.c) r5     // Catch: java.lang.Throwable -> L3c
            r3.D(r6, r5)     // Catch: java.lang.Throwable -> L3c
            goto L133
        L14f:
            r1.D(r2, r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.j.d(r1, r2)     // Catch: java.lang.Throwable -> L3c
            r10.writeJson(r0, r1)     // Catch: java.lang.Throwable -> L3c
            r10.savePrefs()     // Catch: java.lang.Throwable -> L3c
            r10.changed()     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r10)
            return
        L166:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L3c
            throw r0
    }

    public final void scanCleanIps(int r18, boolean r19) {
            r17 = this;
            r17.load()
            com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.ipScan
            r1 = 1
            if (r0 == 0) goto L17
            boolean r0 = r0.getRunning()
            if (r0 == r1) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "اسکن آی\u200cپی تمیز در حال اجراست"
            r0.<init>(r1)
            throw r0
        L17:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.testJob
            if (r0 == 0) goto L2a
            boolean r0 = r0.getRunning()
            if (r0 == r1) goto L22
            goto L2a
        L22:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "اول سنجش فهرست تمام شود"
            r0.<init>(r1)
            throw r0
        L2a:
            r0 = 3
            r1 = r17
            java.util.List r2 = r1.refHosts(r0)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L6d
            r3 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool.scanCancel = r3
            com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan
            kotlin.collections.w r9 = kotlin.collections.w.INSTANCE
            java.lang.Object r3 = r2.get(r3)
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r3
            java.lang.String r10 = r3.getHost()
            r15 = 448(0x1c0, float:6.28E-43)
            r16 = 0
            r5 = 1
            java.lang.String r6 = "tls"
            r7 = 0
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16)
            com.mlmvpn.scanner.engines.argo.ArgoPool.ipScan = r4
            r1.changed()
            kotlinx.coroutines.i0 r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.scope
            com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1 r4 = new com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1
            r5 = 0
            r6 = r18
            r7 = r19
            r4.<init>(r6, r7, r2, r5)
            kotlinx.coroutines.m0.y(r3, r5, r5, r4, r0)
            return
        L6d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "هیچ سرور آرگویی برای اسکن نیست — اول «به\u200cروزرسانی» را بزنید"
            r0.<init>(r2)
            throw r0
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs setPrefs(java.lang.String r5, java.lang.Boolean r6) {
            r4 = this;
            monitor-enter(r4)
            r4.load()     // Catch: java.lang.Throwable -> L30
            r0 = 0
            if (r5 == 0) goto L3a
            java.lang.CharSequence r5 = kotlin.text.o.n1(r5)     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L30
            r1 = 2
            char[] r2 = new char[r1]     // Catch: java.lang.Throwable -> L30
            r2 = {x0056: FILL_ARRAY_DATA , data: [91, 93} // fill-array     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = kotlin.text.o.o1(r5, r2)     // Catch: java.lang.Throwable -> L30
            int r2 = r5.length()     // Catch: java.lang.Throwable -> L30
            if (r2 != 0) goto L20
            goto L26
        L20:
            boolean r2 = r4.isIpLiteral(r5)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L32
        L26:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs     // Catch: java.lang.Throwable -> L30
            r3 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs.copy$default(r2, r5, r3, r1, r0)     // Catch: java.lang.Throwable -> L30
            com.mlmvpn.scanner.engines.argo.ArgoPool.prefs = r5     // Catch: java.lang.Throwable -> L30
            goto L3a
        L30:
            r5 = move-exception
            goto L53
        L32:
            java.lang.String r5 = "آی\u200cپی تمیز معتبر نیست"
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L30
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L30
            throw r6     // Catch: java.lang.Throwable -> L30
        L3a:
            if (r6 == 0) goto L49
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs     // Catch: java.lang.Throwable -> L30
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L30
            r1 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.Prefs.copy$default(r5, r0, r6, r1, r0)     // Catch: java.lang.Throwable -> L30
            com.mlmvpn.scanner.engines.argo.ArgoPool.prefs = r5     // Catch: java.lang.Throwable -> L30
        L49:
            r4.savePrefs()     // Catch: java.lang.Throwable -> L30
            r4.changed()     // Catch: java.lang.Throwable -> L30
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs     // Catch: java.lang.Throwable -> L30
            monitor-exit(r4)
            return r5
        L53:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L30
            throw r5
    }

    public final synchronized void setSourceOn(java.lang.String r3, boolean r4) {
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.j.e(r3, r0)     // Catch: java.lang.Throwable -> L1a
            r2.load()     // Catch: java.lang.Throwable -> L1a
            java.util.HashMap<java.lang.String, sf.c> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r0.get(r3)     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L1c
            sf.c r1 = new sf.c     // Catch: java.lang.Throwable -> L1a
            r1.<init>()     // Catch: java.lang.Throwable -> L1a
            r0.put(r3, r1)     // Catch: java.lang.Throwable -> L1a
            goto L1c
        L1a:
            r3 = move-exception
            goto L28
        L1c:
            sf.c r1 = (sf.c) r1     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "on"
            r1.E(r3, r4)     // Catch: java.lang.Throwable -> L1a
            r2.saveNow()     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r2)
            return
        L28:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r3
    }

    public final synchronized java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView> sources() {
            r16 = this;
            monitor-enter(r16)
            r16.load()     // Catch: java.lang.Throwable -> L4d
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.BUILTIN     // Catch: java.lang.Throwable -> L4d
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L4d
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoPool$Source> r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.userSources     // Catch: java.lang.Throwable -> L4d
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L4d
            java.util.ArrayList r0 = kotlin.collections.q.S0(r0, r1)     // Catch: java.lang.Throwable -> L4d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4d
            r2 = 10
            int r2 = kotlin.collections.s.g0(r0, r2)     // Catch: java.lang.Throwable -> L4d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4d
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            r4 = r3
        L21:
            if (r4 >= r2) goto Ldd
            java.lang.Object r5 = r0.get(r4)     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 + 1
            r7 = r5
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r7 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Source) r7     // Catch: java.lang.Throwable -> L4d
            java.util.HashMap<java.lang.String, sf.c> r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.sourceState     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r7.getId()     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L4d
            sf.c r5 = (sf.c) r5     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r7.getType()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "falcon-servers"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r8)     // Catch: java.lang.Throwable -> L4d
            r8 = 0
            if (r6 == 0) goto L50
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers     // Catch: java.lang.Throwable -> L4d
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L4d
            r12 = r6
            goto La3
        L4d:
            r0 = move-exception
            goto Ldf
        L50:
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r6 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L4d
            java.util.Collection r6 = r6.values()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r9 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r6, r9)     // Catch: java.lang.Throwable -> L4d
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch: java.lang.Throwable -> L4d
            boolean r9 = r6 instanceof java.util.Collection     // Catch: java.lang.Throwable -> L4d
            if (r9 == 0) goto L6c
            r9 = r6
            java.util.Collection r9 = (java.util.Collection) r9     // Catch: java.lang.Throwable -> L4d
            boolean r9 = r9.isEmpty()     // Catch: java.lang.Throwable -> L4d
            if (r9 == 0) goto L6c
            r12 = r3
            goto La3
        L6c:
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L4d
            r9 = r3
        L71:
            boolean r10 = r6.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r10 == 0) goto La2
            java.lang.Object r10 = r6.next()     // Catch: java.lang.Throwable -> L4d
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r10 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r10     // Catch: java.lang.Throwable -> L4d
            java.lang.String r11 = r10.getSrc()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r12 = r7.getId()     // Catch: java.lang.Throwable -> L4d
            boolean r11 = kotlin.jvm.internal.j.a(r11, r12)     // Catch: java.lang.Throwable -> L4d
            if (r11 != 0) goto L99
            java.lang.String r10 = r10.getFrom()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r11 = r7.getId()     // Catch: java.lang.Throwable -> L4d
            boolean r10 = kotlin.jvm.internal.j.a(r10, r11)     // Catch: java.lang.Throwable -> L4d
            if (r10 == 0) goto L71
        L99:
            int r9 = r9 + 1
            if (r9 < 0) goto L9e
            goto L71
        L9e:
            kotlin.collections.r.e0()     // Catch: java.lang.Throwable -> L4d
            throw r8     // Catch: java.lang.Throwable -> L4d
        La2:
            r12 = r9
        La3:
            com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r6 = new com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView     // Catch: java.lang.Throwable -> L4d
            r9 = 1
            if (r5 == 0) goto Lae
            java.lang.String r10 = "on"
            boolean r9 = r5.q(r10, r9)     // Catch: java.lang.Throwable -> L4d
        Lae:
            r10 = 0
            if (r5 == 0) goto Lb8
            java.lang.String r13 = "at"
            long r10 = r5.x(r10, r13)     // Catch: java.lang.Throwable -> L4d
        Lb8:
            if (r5 == 0) goto Lc1
            java.lang.String r13 = "found"
            int r13 = r5.t(r3, r13)     // Catch: java.lang.Throwable -> L4d
            goto Lc2
        Lc1:
            r13 = r3
        Lc2:
            if (r5 == 0) goto Lcc
            java.lang.String r8 = "error"
            java.lang.String r14 = ""
            java.lang.String r8 = r5.A(r8, r14)     // Catch: java.lang.Throwable -> L4d
        Lcc:
            if (r8 != 0) goto Ld0
            java.lang.String r8 = ""
        Ld0:
            r15 = r13
            r13 = r8
            r8 = r9
            r9 = r10
            r11 = r15
            r6.<init>(r7, r8, r9, r11, r12, r13)     // Catch: java.lang.Throwable -> L4d
            r1.add(r6)     // Catch: java.lang.Throwable -> L4d
            goto L21
        Ldd:
            monitor-exit(r16)
            return r1
        Ldf:
            monitor-exit(r16)     // Catch: java.lang.Throwable -> L4d
            throw r0
    }

    public final void stopCleanScan() {
            r1 = this;
            r0 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool.scanCancel = r0
            return
    }

    public final void stopTest() {
            r1 = this;
            r0 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool.testCancel = r0
            return
    }

    public final void stopUpdate() {
            r1 = this;
            r0 = 1
            com.mlmvpn.scanner.engines.argo.ArgoPool.updateCancel = r0
            return
    }

    public final synchronized com.mlmvpn.scanner.engines.argo.ArgoPool.Summary summary() {
            r39 = this;
            r1 = r39
            monitor-enter(r39)
            r1.load()     // Catch: java.lang.Throwable -> L60
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L60
            r0.<init>()     // Catch: java.lang.Throwable -> L60
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L60
            java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L60
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L60
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L1d:
            boolean r6 = r2.hasNext()     // Catch: java.lang.Throwable -> L60
            r10 = 1
            if (r6 == 0) goto L11e
            java.lang.Object r6 = r2.next()     // Catch: java.lang.Throwable -> L60
            r16 = 0
            java.lang.String r3 = "next(...)"
            kotlin.jvm.internal.j.d(r6, r3)     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.ArgoPool$Item r6 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Item) r6     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = r6.getKind()     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "bridge"
            boolean r4 = kotlin.jvm.internal.j.a(r3, r4)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L40
            int r7 = r7 + 1
            goto L4d
        L40:
            java.lang.String r4 = "falcon"
            boolean r3 = kotlin.jvm.internal.j.a(r3, r4)     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L4b
            int r8 = r8 + 1
            goto L4d
        L4b:
            int r9 = r9 + 1
        L4d:
            long r3 = r6.getV0()     // Catch: java.lang.Throwable -> L60
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L63
            int r13 = r13 + 1
            long r3 = r6.getV0()     // Catch: java.lang.Throwable -> L60
            long r14 = java.lang.Math.max(r14, r3)     // Catch: java.lang.Throwable -> L60
            goto L63
        L60:
            r0 = move-exception
            goto L234
        L63:
            java.util.HashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Result> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.results     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = r6.getId()     // Catch: java.lang.Throwable -> L60
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.ArgoPool$Result r3 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Result) r3     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L73
            int r12 = r12 + 1
        L73:
            if (r3 == 0) goto L7d
            boolean r4 = r3.getOk()     // Catch: java.lang.Throwable -> L60
            if (r4 != r10) goto L7d
            int r11 = r11 + 1
        L7d:
            java.lang.String r4 = r1.ccOf(r6)     // Catch: java.lang.Throwable -> L60
            java.lang.Object r18 = r0.get(r4)     // Catch: java.lang.Throwable -> L60
            if (r18 != 0) goto Lac
            com.mlmvpn.scanner.engines.argo.ArgoPool$Group r19 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Group     // Catch: java.lang.Throwable -> L60
            r29 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool r5 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE     // Catch: java.lang.Throwable -> L60
            java.lang.String r20 = r5.ccOf(r6)     // Catch: java.lang.Throwable -> L60
            r27 = 126(0x7e, float:1.77E-43)
            r28 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch: java.lang.Throwable -> L60
            r5 = r19
            r0.put(r4, r5)     // Catch: java.lang.Throwable -> L60
            r18 = r5
            goto Lae
        Lac:
            r29 = 0
        Lae:
            r4 = r18
            com.mlmvpn.scanner.engines.argo.ArgoPool$Group r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.Group) r4     // Catch: java.lang.Throwable -> L60
            int r5 = r4.getN()     // Catch: java.lang.Throwable -> L60
            int r5 = r5 + r10
            r4.setN(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r6.getKind()     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = "bridge"
            boolean r6 = kotlin.jvm.internal.j.a(r5, r6)     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto Lcf
            int r5 = r4.getBridge()     // Catch: java.lang.Throwable -> L60
            int r5 = r5 + r10
            r4.setBridge(r5)     // Catch: java.lang.Throwable -> L60
            goto Le8
        Lcf:
            java.lang.String r6 = "falcon"
            boolean r5 = kotlin.jvm.internal.j.a(r5, r6)     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto Le0
            int r5 = r4.getFalcon()     // Catch: java.lang.Throwable -> L60
            int r5 = r5 + r10
            r4.setFalcon(r5)     // Catch: java.lang.Throwable -> L60
            goto Le8
        Le0:
            int r5 = r4.getPublic()     // Catch: java.lang.Throwable -> L60
            int r5 = r5 + r10
            r4.setPublic(r5)     // Catch: java.lang.Throwable -> L60
        Le8:
            if (r3 == 0) goto L1d
            boolean r5 = r3.getOk()     // Catch: java.lang.Throwable -> L60
            if (r5 != r10) goto L1d
            int r5 = r4.getAlive()     // Catch: java.lang.Throwable -> L60
            int r5 = r5 + r10
            r4.setAlive(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.Long r5 = r4.getBest()     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L111
            long r5 = r3.getMs()     // Catch: java.lang.Throwable -> L60
            java.lang.Long r10 = r4.getBest()     // Catch: java.lang.Throwable -> L60
            kotlin.jvm.internal.j.b(r10)     // Catch: java.lang.Throwable -> L60
            long r18 = r10.longValue()     // Catch: java.lang.Throwable -> L60
            int r5 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r5 >= 0) goto L1d
        L111:
            long r5 = r3.getMs()     // Catch: java.lang.Throwable -> L60
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L60
            r4.setBest(r3)     // Catch: java.lang.Throwable -> L60
            goto L1d
        L11e:
            r16 = 0
            r29 = 0
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "<get-values>(...)"
            kotlin.jvm.internal.j.d(r0, r2)     // Catch: java.lang.Throwable -> L60
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.d r2 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L60
            r3 = 6
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.d r3 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L60
            r4 = 7
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.d r4 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L60
            r5 = 8
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L60
            r5 = 3
            ee.c[] r5 = new ee.c[r5]     // Catch: java.lang.Throwable -> L60
            r5[r29] = r2     // Catch: java.lang.Throwable -> L60
            r5[r10] = r3     // Catch: java.lang.Throwable -> L60
            r2 = 2
            r5[r2] = r4     // Catch: java.lang.Throwable -> L60
            androidx.compose.foundation.text.selection.a1 r3 = x6.p.d(r5)     // Catch: java.lang.Throwable -> L60
            java.util.List r20 = kotlin.collections.q.b1(r0, r3)     // Catch: java.lang.Throwable -> L60
            sf.c r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.cleanScan     // Catch: java.lang.Throwable -> L60
            r3 = 10
            if (r0 == 0) goto L1ec
            java.lang.String r4 = "list"
            sf.a r0 = r0.v(r4)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L1ec
            java.util.ArrayList r4 = r0.f67155a     // Catch: java.lang.Throwable -> L60
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L60
            r5 = r29
            je.h r4 = com.google.android.gms.internal.mlkit_language_id_common.j.J(r5, r4)     // Catch: java.lang.Throwable -> L60
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L60
            r5.<init>()     // Catch: java.lang.Throwable -> L60
            je.g r4 = r4.a()     // Catch: java.lang.Throwable -> L60
        L175:
            boolean r6 = r4.f23130c     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L187
            int r6 = r4.nextInt()     // Catch: java.lang.Throwable -> L60
            sf.c r6 = r0.q(r6)     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L175
            r5.add(r6)     // Catch: java.lang.Throwable -> L60
            goto L175
        L187:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L60
            int r4 = kotlin.collections.s.g0(r5, r3)     // Catch: java.lang.Throwable -> L60
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L60
            int r4 = r5.size()     // Catch: java.lang.Throwable -> L60
            r6 = 0
        L195:
            if (r6 >= r4) goto L1ed
            java.lang.Object r18 = r5.get(r6)     // Catch: java.lang.Throwable -> L60
            int r6 = r6 + 1
            r10 = r18
            sf.c r10 = (sf.c) r10     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp r30 = new com.mlmvpn.scanner.engines.argo.ArgoPool$CleanIp     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "ip"
            java.lang.String r3 = ""
            java.lang.String r2 = r10.A(r2, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "optString(...)"
            kotlin.jvm.internal.j.d(r2, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "tls"
            r23 = r4
            r22 = r5
            r4 = r16
            long r32 = r10.x(r4, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "auth"
            long r34 = r10.x(r4, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "kbps"
            long r36 = r10.x(r4, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "loc"
            java.lang.String r4 = ""
            java.lang.String r3 = r10.A(r3, r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "optString(...)"
            kotlin.jvm.internal.j.d(r3, r4)     // Catch: java.lang.Throwable -> L60
            r31 = r2
            r38 = r3
            r30.<init>(r31, r32, r34, r36, r38)     // Catch: java.lang.Throwable -> L60
            r2 = r30
            r0.add(r2)     // Catch: java.lang.Throwable -> L60
            r5 = r22
            r4 = r23
            r2 = 2
            r3 = 10
            r10 = 1
            r16 = 0
            goto L195
        L1ec:
            r0 = 0
        L1ed:
            if (r0 != 0) goto L1f1
            kotlin.collections.w r0 = kotlin.collections.w.INSTANCE     // Catch: java.lang.Throwable -> L60
        L1f1:
            r22 = r0
            r0 = 2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Summary r18 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Summary     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.ArgoPool$Counts r6 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Counts     // Catch: java.lang.Throwable -> L60
            java.util.LinkedHashMap<java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoPool$Item> r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.items     // Catch: java.lang.Throwable -> L60
            int r10 = r2.size()     // Catch: java.lang.Throwable -> L60
            r19 = 1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L60
            r2 = 10
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r21 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs     // Catch: java.lang.Throwable -> L60
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers     // Catch: java.lang.Throwable -> L60
            int r23 = r3.size()     // Catch: java.lang.Throwable -> L60
            java.util.List<com.mlmvpn.scanner.engines.argo.ArgoProtocol$FalconOrigin> r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.falconServers     // Catch: java.lang.Throwable -> L60
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.d r4 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L60
            r5 = 9
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L60
            com.mlmvpn.scanner.engines.argo.d r5 = new com.mlmvpn.scanner.engines.argo.d     // Catch: java.lang.Throwable -> L60
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L60
            ee.c[] r0 = new ee.c[r0]     // Catch: java.lang.Throwable -> L60
            r29 = 0
            r0[r29] = r4     // Catch: java.lang.Throwable -> L60
            r0[r19] = r5     // Catch: java.lang.Throwable -> L60
            androidx.compose.foundation.text.selection.a1 r0 = x6.p.d(r0)     // Catch: java.lang.Throwable -> L60
            java.util.List r24 = kotlin.collections.q.b1(r3, r0)     // Catch: java.lang.Throwable -> L60
            r19 = r6
            r18.<init>(r19, r20, r21, r22, r23, r24)     // Catch: java.lang.Throwable -> L60
            monitor-exit(r39)
            return r18
        L234:
            monitor-exit(r39)     // Catch: java.lang.Throwable -> L60
            throw r0
    }

    public final void test(java.lang.String r22, java.lang.String r23, java.util.List<java.lang.String> r24, boolean r25, boolean r26, boolean r27) {
            r21 = this;
            r14 = r22
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.j.e(r14, r0)
            java.lang.String r1 = "cc"
            r13 = r23
            kotlin.jvm.internal.j.e(r13, r1)
            r21.load()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.testJob
            r2 = 1
            if (r1 == 0) goto L25
            boolean r1 = r1.getRunning()
            if (r1 == r2) goto L1d
            goto L25
        L1d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "یک سنجش در حال اجراست"
            r0.<init>(r1)
            throw r0
        L25:
            com.mlmvpn.scanner.engines.argo.ArgoPool$IpScan r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.ipScan
            if (r1 == 0) goto L38
            boolean r1 = r1.getRunning()
            if (r1 == r2) goto L30
            goto L38
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "اول اسکن آی\u200cپی تمیز تمام شود"
            r0.<init>(r1)
            throw r0
        L38:
            java.util.List r1 = r21.select(r22, r23, r24, r25, r26, r27)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto La6
            r2 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool.testCancel = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool$Prefs r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.prefs
            java.lang.String r2 = r2.getCleanIp()
            if (r26 == 0) goto L51
            java.lang.String r0 = "verified"
        L4f:
            r12 = r0
            goto L69
        L51:
            boolean r3 = kotlin.text.o.L0(r13)
            if (r3 != 0) goto L5a
            java.lang.String r0 = "country"
            goto L4f
        L5a:
            if (r24 == 0) goto L5f
            java.lang.String r0 = "ids"
            goto L4f
        L5f:
            java.lang.String r3 = "all"
            boolean r4 = r14.equals(r3)
            if (r4 != 0) goto L68
            goto L4f
        L68:
            r12 = r3
        L69:
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r0 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Job
            int r3 = r1.size()
            r15 = 1016(0x3f8, float:1.424E-42)
            r16 = 0
            r4 = r1
            r1 = 1
            r5 = r2
            r2 = 0
            r6 = r4
            r4 = 0
            r7 = r5
            r5 = 0
            r8 = r6
            r6 = 0
            r9 = r7
            r7 = 0
            r10 = r8
            r8 = 0
            r11 = r9
            r9 = 0
            r17 = r10
            r18 = r11
            r10 = 0
            r19 = r17
            r20 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16)
            com.mlmvpn.scanner.engines.argo.ArgoPool.testJob = r0
            r21.changed()
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.scope
            com.mlmvpn.scanner.engines.argo.ArgoPool$test$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoPool$test$1
            r2 = 0
            r10 = r19
            r9 = r20
            r1.<init>(r10, r9, r2)
            r3 = 3
            kotlinx.coroutines.m0.y(r0, r2, r2, r1, r3)
            return
        La6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "موردی برای سنجش نیست"
            r0.<init>(r1)
            throw r0
    }

    public final void update(java.util.List<java.lang.String> r20) {
            r19 = this;
            r0 = r20
            r19.load()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.updateJob
            if (r1 == 0) goto L11
            boolean r1 = r1.getRunning()
            r2 = 1
            if (r1 != r2) goto L11
            return
        L11:
            java.util.List r1 = r19.sources()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L20:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L46
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r4 = (com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView) r4
            if (r0 == 0) goto L3c
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r4 = r4.getSrc()
            java.lang.String r4 = r4.getId()
            boolean r4 = r0.contains(r4)
            goto L40
        L3c:
            boolean r4 = r4.getOn()
        L40:
            if (r4 == 0) goto L20
            r2.add(r3)
            goto L20
        L46:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.s.g0(r2, r1)
            r0.<init>(r1)
            int r1 = r2.size()
            r3 = 0
            r4 = r3
        L57:
            if (r4 >= r1) goto L69
            java.lang.Object r5 = r2.get(r4)
            int r4 = r4 + 1
            com.mlmvpn.scanner.engines.argo.ArgoPool$SourceView r5 = (com.mlmvpn.scanner.engines.argo.ArgoPool.SourceView) r5
            com.mlmvpn.scanner.engines.argo.ArgoPool$Source r5 = r5.getSrc()
            r0.add(r5)
            goto L57
        L69:
            com.mlmvpn.scanner.engines.argo.ArgoPool.updateCancel = r3
            com.mlmvpn.scanner.engines.argo.ArgoNet$Route r1 = r19.routeNow()
            com.mlmvpn.scanner.engines.argo.ArgoPool$Job r2 = new com.mlmvpn.scanner.engines.argo.ArgoPool$Job
            int r5 = r0.size()
            if (r1 == 0) goto L80
            java.lang.String r3 = r1.getLabel()
            if (r3 != 0) goto L7e
            goto L80
        L7e:
            r11 = r3
            goto L83
        L80:
            java.lang.String r3 = "مستقیم (بدون تونل)"
            goto L7e
        L83:
            r17 = 7928(0x1ef8, float:1.111E-41)
            r18 = 0
            r3 = 1
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            com.mlmvpn.scanner.engines.argo.ArgoPool.updateJob = r2
            r19.changed()
            kotlinx.coroutines.i0 r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.scope
            com.mlmvpn.scanner.engines.argo.ArgoPool$update$1 r3 = new com.mlmvpn.scanner.engines.argo.ArgoPool$update$1
            r4 = 0
            r3.<init>(r0, r1, r4)
            r0 = 3
            kotlinx.coroutines.m0.y(r2, r4, r4, r3, r0)
            return
    }
}
