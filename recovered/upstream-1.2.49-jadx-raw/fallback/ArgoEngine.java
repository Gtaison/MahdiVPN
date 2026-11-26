package com.mlmvpn.scanner.engines.argo;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoEngine {
    public static final int $stable = 0;
    public static final com.mlmvpn.scanner.engines.argo.ArgoEngine INSTANCE = null;
    public static final java.lang.String NODE_ID = "argo";
    private static final long OWNER_CHECK_MS = 5000;
    public static final java.lang.String REMARKS = "mlm-argo-v1";
    private static final java.lang.String TAG = "ARGO";
    private static final kotlinx.coroutines.flow.k0 _conn = null;
    private static final kotlinx.coroutines.flow.k0 _lastWhy = null;
    private static final kotlinx.coroutines.flow.k0 _logs = null;
    private static android.content.Context app;
    private static final kotlinx.coroutines.flow.e1 conn = null;
    private static kotlinx.coroutines.s1 connectJob;
    private static final com.mlmvpn.scanner.utils.ConnectionOwner connectionOwner = null;
    private static final kotlinx.coroutines.flow.e1 lastWhy = null;
    private static volatile com.mlmvpn.scanner.engines.argo.ArgoEngine.Live live;
    private static final kotlinx.coroutines.flow.e1 logs = null;
    private static final kotlinx.coroutines.i0 scope = null;
    private static volatile boolean wantConnected;
    private static kotlinx.coroutines.s1 watchJob;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static abstract class Conn {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Connected extends com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn {
            public static final int $stable = 0;
            private final java.lang.String exitCc;
            private final java.lang.String exitIp;
            private final java.lang.String host;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            private final java.lang.String f11197id;
            private final java.lang.String kind;
            private final boolean lost;
            private final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode mode;
            private final long ms;

            public Connected(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, long r6, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r8, boolean r9, java.lang.String r10) {
                    r1 = this;
                    java.lang.String r0 = "host"
                    kotlin.jvm.internal.j.e(r2, r0)
                    java.lang.String r0 = "kind"
                    kotlin.jvm.internal.j.e(r3, r0)
                    java.lang.String r0 = "exitCc"
                    kotlin.jvm.internal.j.e(r4, r0)
                    java.lang.String r0 = "exitIp"
                    kotlin.jvm.internal.j.e(r5, r0)
                    java.lang.String r0 = "mode"
                    kotlin.jvm.internal.j.e(r8, r0)
                    java.lang.String r0 = "id"
                    kotlin.jvm.internal.j.e(r10, r0)
                    r0 = 0
                    r1.<init>(r0)
                    r1.host = r2
                    r1.kind = r3
                    r1.exitCc = r4
                    r1.exitIp = r5
                    r1.ms = r6
                    r1.mode = r8
                    r1.lost = r9
                    r1.f11197id = r10
                    return
            }

            public /* synthetic */ Connected(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, long r17, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r19, boolean r20, java.lang.String r21, int r22, kotlin.jvm.internal.e r23) {
                    r12 = this;
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
                    r9 = r19
                    goto L20
                L1d:
                    r11 = r21
                    goto L12
                L20:
                    r2.<init>(r3, r4, r5, r6, r7, r9, r10, r11)
                    return
            }

            public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected copy$default(com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r7, boolean r8, java.lang.String r9, int r10, java.lang.Object r11) {
                    r11 = r10 & 1
                    if (r11 == 0) goto L6
                    java.lang.String r1 = r0.host
                L6:
                    r11 = r10 & 2
                    if (r11 == 0) goto Lc
                    java.lang.String r2 = r0.kind
                Lc:
                    r11 = r10 & 4
                    if (r11 == 0) goto L12
                    java.lang.String r3 = r0.exitCc
                L12:
                    r11 = r10 & 8
                    if (r11 == 0) goto L18
                    java.lang.String r4 = r0.exitIp
                L18:
                    r11 = r10 & 16
                    if (r11 == 0) goto L1e
                    long r5 = r0.ms
                L1e:
                    r11 = r10 & 32
                    if (r11 == 0) goto L24
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r7 = r0.mode
                L24:
                    r11 = r10 & 64
                    if (r11 == 0) goto L2a
                    boolean r8 = r0.lost
                L2a:
                    r10 = r10 & 128(0x80, float:1.794E-43)
                    if (r10 == 0) goto L30
                    java.lang.String r9 = r0.f11197id
                L30:
                    r10 = r8
                    r11 = r9
                    r9 = r7
                    r7 = r5
                    r5 = r3
                    r6 = r4
                    r3 = r1
                    r4 = r2
                    r2 = r0
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r0 = r2.copy(r3, r4, r5, r6, r7, r9, r10, r11)
                    return r0
            }

            public final java.lang.String component1() {
                    r1 = this;
                    java.lang.String r0 = r1.host
                    return r0
            }

            public final java.lang.String component2() {
                    r1 = this;
                    java.lang.String r0 = r1.kind
                    return r0
            }

            public final java.lang.String component3() {
                    r1 = this;
                    java.lang.String r0 = r1.exitCc
                    return r0
            }

            public final java.lang.String component4() {
                    r1 = this;
                    java.lang.String r0 = r1.exitIp
                    return r0
            }

            public final long component5() {
                    r2 = this;
                    long r0 = r2.ms
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode component6() {
                    r1 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = r1.mode
                    return r0
            }

            public final boolean component7() {
                    r1 = this;
                    boolean r0 = r1.lost
                    return r0
            }

            public final java.lang.String component8() {
                    r1 = this;
                    java.lang.String r0 = r1.f11197id
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected copy(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, long r16, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r18, boolean r19, java.lang.String r20) {
                    r11 = this;
                    java.lang.String r0 = "host"
                    kotlin.jvm.internal.j.e(r12, r0)
                    java.lang.String r0 = "kind"
                    kotlin.jvm.internal.j.e(r13, r0)
                    java.lang.String r0 = "exitCc"
                    kotlin.jvm.internal.j.e(r14, r0)
                    java.lang.String r0 = "exitIp"
                    kotlin.jvm.internal.j.e(r15, r0)
                    java.lang.String r0 = "mode"
                    r8 = r18
                    kotlin.jvm.internal.j.e(r8, r0)
                    java.lang.String r0 = "id"
                    r10 = r20
                    kotlin.jvm.internal.j.e(r10, r0)
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected
                    r2 = r12
                    r3 = r13
                    r4 = r14
                    r5 = r15
                    r6 = r16
                    r9 = r19
                    r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10)
                    return r1
            }

            public boolean equals(java.lang.Object r8) {
                    r7 = this;
                    r0 = 1
                    if (r7 != r8) goto L4
                    return r0
                L4:
                    boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected
                    r2 = 0
                    if (r1 != 0) goto La
                    return r2
                La:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r8 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected) r8
                    java.lang.String r1 = r7.host
                    java.lang.String r3 = r8.host
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
                    java.lang.String r1 = r7.exitCc
                    java.lang.String r3 = r8.exitCc
                    boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                    if (r1 != 0) goto L2d
                    return r2
                L2d:
                    java.lang.String r1 = r7.exitIp
                    java.lang.String r3 = r8.exitIp
                    boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                    if (r1 != 0) goto L38
                    return r2
                L38:
                    long r3 = r7.ms
                    long r5 = r8.ms
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 == 0) goto L41
                    return r2
                L41:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r1 = r7.mode
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r3 = r8.mode
                    if (r1 == r3) goto L48
                    return r2
                L48:
                    boolean r1 = r7.lost
                    boolean r3 = r8.lost
                    if (r1 == r3) goto L4f
                    return r2
                L4f:
                    java.lang.String r1 = r7.f11197id
                    java.lang.String r8 = r8.f11197id
                    boolean r8 = kotlin.jvm.internal.j.a(r1, r8)
                    if (r8 != 0) goto L5a
                    return r2
                L5a:
                    return r0
            }

            public final java.lang.String getExitCc() {
                    r1 = this;
                    java.lang.String r0 = r1.exitCc
                    return r0
            }

            public final java.lang.String getExitIp() {
                    r1 = this;
                    java.lang.String r0 = r1.exitIp
                    return r0
            }

            public final java.lang.String getHost() {
                    r1 = this;
                    java.lang.String r0 = r1.host
                    return r0
            }

            public final java.lang.String getId() {
                    r1 = this;
                    java.lang.String r0 = r1.f11197id
                    return r0
            }

            public final java.lang.String getKind() {
                    r1 = this;
                    java.lang.String r0 = r1.kind
                    return r0
            }

            public final boolean getLost() {
                    r1 = this;
                    boolean r0 = r1.lost
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode getMode() {
                    r1 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = r1.mode
                    return r0
            }

            public final long getMs() {
                    r2 = this;
                    long r0 = r2.ms
                    return r0
            }

            public int hashCode() {
                    r4 = this;
                    java.lang.String r0 = r4.host
                    int r0 = r0.hashCode()
                    r1 = 31
                    int r0 = r0 * r1
                    java.lang.String r2 = r4.kind
                    int r0 = androidx.media3.common.s.d(r0, r1, r2)
                    java.lang.String r2 = r4.exitCc
                    int r0 = androidx.media3.common.s.d(r0, r1, r2)
                    java.lang.String r2 = r4.exitIp
                    int r0 = androidx.media3.common.s.d(r0, r1, r2)
                    long r2 = r4.ms
                    int r0 = a6.w0.c(r0, r1, r2)
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r2 = r4.mode
                    int r2 = r2.hashCode()
                    int r2 = r2 + r0
                    int r2 = r2 * r1
                    boolean r0 = r4.lost
                    int r0 = a6.w0.d(r2, r1, r0)
                    java.lang.String r1 = r4.f11197id
                    int r1 = r1.hashCode()
                    int r1 = r1 + r0
                    return r1
            }

            public java.lang.String toString() {
                    r12 = this;
                    java.lang.String r0 = r12.host
                    java.lang.String r1 = r12.kind
                    java.lang.String r2 = r12.exitCc
                    java.lang.String r3 = r12.exitIp
                    long r4 = r12.ms
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r6 = r12.mode
                    boolean r7 = r12.lost
                    java.lang.String r8 = r12.f11197id
                    java.lang.String r9 = ", kind="
                    java.lang.String r10 = ", exitCc="
                    java.lang.String r11 = "Connected(host="
                    java.lang.StringBuilder r0 = androidx.media3.common.s.n(r11, r0, r9, r1, r10)
                    java.lang.String r1 = ", exitIp="
                    java.lang.String r9 = ", ms="
                    org.telegram.ui.Cells.d1.x(r0, r2, r1, r3, r9)
                    r0.append(r4)
                    java.lang.String r1 = ", mode="
                    r0.append(r1)
                    r0.append(r6)
                    java.lang.String r1 = ", lost="
                    r0.append(r1)
                    r0.append(r7)
                    java.lang.String r1 = ", id="
                    r0.append(r1)
                    r0.append(r8)
                    java.lang.String r1 = ")"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    return r0
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Connecting extends com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn {
            public static final int $stable = 0;
            private final int attempt;
            private final java.lang.String host;
            private final java.lang.String kind;
            private final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step step;

            public Connecting(com.mlmvpn.scanner.engines.argo.ArgoEngine.Step r2, java.lang.String r3, java.lang.String r4, int r5) {
                    r1 = this;
                    java.lang.String r0 = "step"
                    kotlin.jvm.internal.j.e(r2, r0)
                    java.lang.String r0 = "host"
                    kotlin.jvm.internal.j.e(r3, r0)
                    java.lang.String r0 = "kind"
                    kotlin.jvm.internal.j.e(r4, r0)
                    r0 = 0
                    r1.<init>(r0)
                    r1.step = r2
                    r1.host = r3
                    r1.kind = r4
                    r1.attempt = r5
                    return
            }

            public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connecting copy$default(com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connecting r0, com.mlmvpn.scanner.engines.argo.ArgoEngine.Step r1, java.lang.String r2, java.lang.String r3, int r4, int r5, java.lang.Object r6) {
                    r6 = r5 & 1
                    if (r6 == 0) goto L6
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r1 = r0.step
                L6:
                    r6 = r5 & 2
                    if (r6 == 0) goto Lc
                    java.lang.String r2 = r0.host
                Lc:
                    r6 = r5 & 4
                    if (r6 == 0) goto L12
                    java.lang.String r3 = r0.kind
                L12:
                    r5 = r5 & 8
                    if (r5 == 0) goto L18
                    int r4 = r0.attempt
                L18:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r0 = r0.copy(r1, r2, r3, r4)
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step component1() {
                    r1 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = r1.step
                    return r0
            }

            public final java.lang.String component2() {
                    r1 = this;
                    java.lang.String r0 = r1.host
                    return r0
            }

            public final java.lang.String component3() {
                    r1 = this;
                    java.lang.String r0 = r1.kind
                    return r0
            }

            public final int component4() {
                    r1 = this;
                    int r0 = r1.attempt
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connecting copy(com.mlmvpn.scanner.engines.argo.ArgoEngine.Step r2, java.lang.String r3, java.lang.String r4, int r5) {
                    r1 = this;
                    java.lang.String r0 = "step"
                    kotlin.jvm.internal.j.e(r2, r0)
                    java.lang.String r0 = "host"
                    kotlin.jvm.internal.j.e(r3, r0)
                    java.lang.String r0 = "kind"
                    kotlin.jvm.internal.j.e(r4, r0)
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting
                    r0.<init>(r2, r3, r4, r5)
                    return r0
            }

            public boolean equals(java.lang.Object r5) {
                    r4 = this;
                    r0 = 1
                    if (r4 != r5) goto L4
                    return r0
                L4:
                    boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connecting
                    r2 = 0
                    if (r1 != 0) goto La
                    return r2
                La:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r5 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connecting) r5
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r1 = r4.step
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r3 = r5.step
                    if (r1 == r3) goto L13
                    return r2
                L13:
                    java.lang.String r1 = r4.host
                    java.lang.String r3 = r5.host
                    boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                    if (r1 != 0) goto L1e
                    return r2
                L1e:
                    java.lang.String r1 = r4.kind
                    java.lang.String r3 = r5.kind
                    boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                    if (r1 != 0) goto L29
                    return r2
                L29:
                    int r1 = r4.attempt
                    int r5 = r5.attempt
                    if (r1 == r5) goto L30
                    return r2
                L30:
                    return r0
            }

            public final int getAttempt() {
                    r1 = this;
                    int r0 = r1.attempt
                    return r0
            }

            public final java.lang.String getHost() {
                    r1 = this;
                    java.lang.String r0 = r1.host
                    return r0
            }

            public final java.lang.String getKind() {
                    r1 = this;
                    java.lang.String r0 = r1.kind
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step getStep() {
                    r1 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = r1.step
                    return r0
            }

            public int hashCode() {
                    r3 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = r3.step
                    int r0 = r0.hashCode()
                    r1 = 31
                    int r0 = r0 * r1
                    java.lang.String r2 = r3.host
                    int r0 = androidx.media3.common.s.d(r0, r1, r2)
                    java.lang.String r2 = r3.kind
                    int r0 = androidx.media3.common.s.d(r0, r1, r2)
                    int r1 = r3.attempt
                    int r1 = java.lang.Integer.hashCode(r1)
                    int r1 = r1 + r0
                    return r1
            }

            public java.lang.String toString() {
                    r6 = this;
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = r6.step
                    java.lang.String r1 = r6.host
                    java.lang.String r2 = r6.kind
                    int r3 = r6.attempt
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "Connecting(step="
                    r4.<init>(r5)
                    r4.append(r0)
                    java.lang.String r0 = ", host="
                    r4.append(r0)
                    r4.append(r1)
                    java.lang.String r0 = ", kind="
                    r4.append(r0)
                    java.lang.String r0 = ", attempt="
                    java.lang.String r1 = ")"
                    java.lang.String r0 = androidx.media3.common.s.i(r3, r2, r0, r1, r4)
                    return r0
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Failed extends com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn {
            public static final int $stable = 0;
            private final java.lang.String error;

            public Failed(java.lang.String r2) {
                    r1 = this;
                    java.lang.String r0 = "error"
                    kotlin.jvm.internal.j.e(r2, r0)
                    r0 = 0
                    r1.<init>(r0)
                    r1.error = r2
                    return
            }

            public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Failed copy$default(com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Failed r0, java.lang.String r1, int r2, java.lang.Object r3) {
                    r2 = r2 & 1
                    if (r2 == 0) goto L6
                    java.lang.String r1 = r0.error
                L6:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed r0 = r0.copy(r1)
                    return r0
            }

            public final java.lang.String component1() {
                    r1 = this;
                    java.lang.String r0 = r1.error
                    return r0
            }

            public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Failed copy(java.lang.String r2) {
                    r1 = this;
                    java.lang.String r0 = "error"
                    kotlin.jvm.internal.j.e(r2, r0)
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed
                    r0.<init>(r2)
                    return r0
            }

            public boolean equals(java.lang.Object r4) {
                    r3 = this;
                    r0 = 1
                    if (r3 != r4) goto L4
                    return r0
                L4:
                    boolean r1 = r4 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Failed
                    r2 = 0
                    if (r1 != 0) goto La
                    return r2
                La:
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed r4 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Failed) r4
                    java.lang.String r1 = r3.error
                    java.lang.String r4 = r4.error
                    boolean r4 = kotlin.jvm.internal.j.a(r1, r4)
                    if (r4 != 0) goto L17
                    return r2
                L17:
                    return r0
            }

            public final java.lang.String getError() {
                    r1 = this;
                    java.lang.String r0 = r1.error
                    return r0
            }

            public int hashCode() {
                    r1 = this;
                    java.lang.String r0 = r1.error
                    int r0 = r0.hashCode()
                    return r0
            }

            public java.lang.String toString() {
                    r3 = this;
                    java.lang.String r0 = r3.error
                    java.lang.String r1 = "Failed(error="
                    java.lang.String r2 = ")"
                    java.lang.String r0 = a6.w0.n(r1, r0, r2)
                    return r0
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Idle extends com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn {
            public static final int $stable = 0;
            public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Idle INSTANCE = null;

            static {
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Idle r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Idle
                    r0.<init>()
                    com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Idle.INSTANCE = r0
                    return
            }

            private Idle() {
                    r1 = this;
                    r0 = 0
                    r1.<init>(r0)
                    return
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Stopping extends com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn {
            public static final int $stable = 0;
            public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Stopping INSTANCE = null;

            static {
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Stopping r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Stopping
                    r0.<init>()
                    com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Stopping.INSTANCE = r0
                    return
            }

            private Stopping() {
                    r1 = this;
                    r0 = 0
                    r1.<init>(r0)
                    return
            }
        }

        private Conn() {
                r0 = this;
                r0.<init>()
                return
        }

        public /* synthetic */ Conn(kotlin.jvm.internal.e r1) {
                r0 = this;
                r0.<init>()
                return
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Live {
        private final java.lang.String config;
        private final java.lang.String connectIp;
        private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint ep;
        private final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo info;
        private final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode mode;

        public Live(com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r2, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r3, java.lang.String r4, java.lang.String r5, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r6) {
                r1 = this;
                java.lang.String r0 = "ep"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "info"
                kotlin.jvm.internal.j.e(r3, r0)
                java.lang.String r0 = "connectIp"
                kotlin.jvm.internal.j.e(r4, r0)
                java.lang.String r0 = "config"
                kotlin.jvm.internal.j.e(r5, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r6, r0)
                r1.<init>()
                r1.ep = r2
                r1.info = r3
                r1.connectIp = r4
                r1.config = r5
                r1.mode = r6
                return
        }

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Live copy$default(com.mlmvpn.scanner.engines.argo.ArgoEngine.Live r0, com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r1, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r2, java.lang.String r3, java.lang.String r4, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r5, int r6, java.lang.Object r7) {
                r7 = r6 & 1
                if (r7 == 0) goto L6
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r1 = r0.ep
            L6:
                r7 = r6 & 2
                if (r7 == 0) goto Lc
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r2 = r0.info
            Lc:
                r7 = r6 & 4
                if (r7 == 0) goto L12
                java.lang.String r3 = r0.connectIp
            L12:
                r7 = r6 & 8
                if (r7 == 0) goto L18
                java.lang.String r4 = r0.config
            L18:
                r6 = r6 & 16
                if (r6 == 0) goto L1e
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r5 = r0.mode
            L1e:
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r2 = r0
                r3 = r1
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r0 = r2.copy(r3, r4, r5, r6, r7)
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint component1() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r1.ep
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo component2() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r0 = r1.info
                return r0
        }

        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.connectIp
                return r0
        }

        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.config
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode component5() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = r1.mode
                return r0
        }

        public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Live copy(com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r8, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r9, java.lang.String r10, java.lang.String r11, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r12) {
                r7 = this;
                java.lang.String r0 = "ep"
                kotlin.jvm.internal.j.e(r8, r0)
                java.lang.String r0 = "info"
                kotlin.jvm.internal.j.e(r9, r0)
                java.lang.String r0 = "connectIp"
                kotlin.jvm.internal.j.e(r10, r0)
                java.lang.String r0 = "config"
                kotlin.jvm.internal.j.e(r11, r0)
                java.lang.String r0 = "mode"
                kotlin.jvm.internal.j.e(r12, r0)
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Live
                r2 = r8
                r3 = r9
                r4 = r10
                r5 = r11
                r6 = r12
                r1.<init>(r2, r3, r4, r5, r6)
                return r1
        }

        public boolean equals(java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Live
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r5 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Live) r5
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r1 = r4.ep
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r3 = r5.ep
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L17
                return r2
            L17:
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r1 = r4.info
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r3 = r5.info
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L22
                return r2
            L22:
                java.lang.String r1 = r4.connectIp
                java.lang.String r3 = r5.connectIp
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L2d
                return r2
            L2d:
                java.lang.String r1 = r4.config
                java.lang.String r3 = r5.config
                boolean r1 = kotlin.jvm.internal.j.a(r1, r3)
                if (r1 != 0) goto L38
                return r2
            L38:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r1 = r4.mode
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r5 = r5.mode
                if (r1 == r5) goto L3f
                return r2
            L3f:
                return r0
        }

        public final java.lang.String getConfig() {
                r1 = this;
                java.lang.String r0 = r1.config
                return r0
        }

        public final java.lang.String getConnectIp() {
                r1 = this;
                java.lang.String r0 = r1.connectIp
                return r0
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

        public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode getMode() {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = r1.mode
                return r0
        }

        public int hashCode() {
                r3 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r3.ep
                int r0 = r0.hashCode()
                r1 = 31
                int r0 = r0 * r1
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r2 = r3.info
                int r2 = r2.hashCode()
                int r2 = r2 + r0
                int r2 = r2 * r1
                java.lang.String r0 = r3.connectIp
                int r0 = androidx.media3.common.s.d(r2, r1, r0)
                java.lang.String r2 = r3.config
                int r0 = androidx.media3.common.s.d(r0, r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r1 = r3.mode
                int r1 = r1.hashCode()
                int r1 = r1 + r0
                return r1
        }

        public java.lang.String toString() {
                r7 = this;
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r7.ep
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r1 = r7.info
                java.lang.String r2 = r7.connectIp
                java.lang.String r3 = r7.config
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r4 = r7.mode
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "Live(ep="
                r5.<init>(r6)
                r5.append(r0)
                java.lang.String r0 = ", info="
                r5.append(r0)
                r5.append(r1)
                java.lang.String r0 = ", connectIp="
                r5.append(r0)
                java.lang.String r0 = ", config="
                java.lang.String r1 = ", mode="
                org.telegram.ui.Cells.d1.x(r5, r2, r0, r3, r1)
                r5.append(r4)
                java.lang.String r0 = ")"
                r5.append(r0)
                java.lang.String r0 = r5.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final enum Mode extends java.lang.Enum<com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode> {
        private static final /* synthetic */ yd.a $ENTRIES = null;
        private static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode[] $VALUES = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode PROXY = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode TUNNEL = null;

        private static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode[] $values() {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.TUNNEL
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r1 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.PROXY
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode[] r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode[]{r0, r1}
                return r0
        }

        static {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode
                java.lang.String r1 = "TUNNEL"
                r2 = 0
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.TUNNEL = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode
                java.lang.String r1 = "PROXY"
                r2 = 1
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.PROXY = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode[] r0 = $values()
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.$VALUES = r0
                yd.b r0 = com.google.android.gms.internal.mlkit_language_id_common.j.j(r0)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.$ENTRIES = r0
                return
        }

        private Mode(java.lang.String r1, int r2) {
                r0 = this;
                r0.<init>(r1, r2)
                return
        }

        public static yd.a getEntries() {
                yd.a r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.$ENTRIES
                return r0
        }

        public static com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode valueOf(java.lang.String r1) {
                java.lang.Class<com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode> r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.class
                java.lang.Enum r1 = java.lang.Enum.valueOf(r0, r1)
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r1
                return r1
        }

        public static com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode[] values() {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode[] r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.$VALUES
                java.lang.Object r0 = r0.clone()
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode[] r0 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode[]) r0
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final enum Step extends java.lang.Enum<com.mlmvpn.scanner.engines.argo.ArgoEngine.Step> {
        private static final /* synthetic */ yd.a $ENTRIES = null;
        private static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Step[] $VALUES = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step AUTH = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step ENGINE = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step ROUTE = null;
        public static final com.mlmvpn.scanner.engines.argo.ArgoEngine.Step VERIFY = null;

        private static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Step[] $values() {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.AUTH
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r1 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ENGINE
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.VERIFY
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ROUTE
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step[] r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine.Step[]{r0, r1, r2, r3}
                return r0
        }

        static {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Step
                java.lang.String r1 = "AUTH"
                r2 = 0
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.AUTH = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Step
                java.lang.String r1 = "ENGINE"
                r2 = 1
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ENGINE = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Step
                java.lang.String r1 = "VERIFY"
                r2 = 2
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.VERIFY = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Step
                java.lang.String r1 = "ROUTE"
                r2 = 3
                r0.<init>(r1, r2)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ROUTE = r0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step[] r0 = $values()
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.$VALUES = r0
                yd.b r0 = com.google.android.gms.internal.mlkit_language_id_common.j.j(r0)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.$ENTRIES = r0
                return
        }

        private Step(java.lang.String r1, int r2) {
                r0 = this;
                r0.<init>(r1, r2)
                return
        }

        public static yd.a getEntries() {
                yd.a r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.$ENTRIES
                return r0
        }

        public static com.mlmvpn.scanner.engines.argo.ArgoEngine.Step valueOf(java.lang.String r1) {
                java.lang.Class<com.mlmvpn.scanner.engines.argo.ArgoEngine$Step> r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.class
                java.lang.Enum r1 = java.lang.Enum.valueOf(r0, r1)
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Step) r1
                return r1
        }

        public static com.mlmvpn.scanner.engines.argo.ArgoEngine.Step[] values() {
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step[] r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.$VALUES
                java.lang.Object r0 = r0.clone()
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Step[] r0 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Step[]) r0
                return r0
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        public static final int $stable = 0;
        private final java.lang.String ip;
        private final java.lang.String loc;
        private final long ms;

        public Trace(java.lang.String r2, java.lang.String r3, long r4) {
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

        public static /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace copy$default(com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace r0, java.lang.String r1, java.lang.String r2, long r3, int r5, java.lang.Object r6) {
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r0 = r0.copy(r1, r2, r3)
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

        public final com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace copy(java.lang.String r2, java.lang.String r3, long r4) {
                r1 = this;
                java.lang.String r0 = "loc"
                kotlin.jvm.internal.j.e(r2, r0)
                java.lang.String r0 = "ip"
                kotlin.jvm.internal.j.e(r3, r0)
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(java.lang.Object r8) {
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r8 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace) r8
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
                java.lang.String r6 = "Trace(loc="
                java.lang.StringBuilder r0 = androidx.media3.common.s.n(r6, r0, r4, r1, r5)
                java.lang.String r1 = ")"
                java.lang.String r0 = a6.w0.k(r2, r1, r0)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {149}, m = "connect")
    public static final class AnonymousClass1 extends xd.c {
        int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine this$0;

        public AnonymousClass1(com.mlmvpn.scanner.engines.argo.ArgoEngine r1, wd.d r2) {
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$connect(r2, r0, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {239, 241}, m = "launch")
    public static final class C03941 extends xd.c {
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine this$0;

        public C03941(com.mlmvpn.scanner.engines.argo.ArgoEngine r1, wd.d r2) {
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine r2 = r1.this$0
                r0 = 0
                java.lang.Object r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$launch(r2, r0, r0, r1)
                return r2
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3", f = "ArgoEngine.kt", l = {239}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends xd.j implements ee.e {
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
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
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1
                    r0.<init>(r3)
                    r0.L$0 = r2
                    return r0
            }

            public final java.lang.Object invoke(com.mlmvpn.scanner.MyVpnService.Phase r1, wd.d r2) {
                    r0 = this;
                    wd.d r1 = r0.create(r1, r2)
                    com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.AnonymousClass3.AnonymousClass1) r1
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

        public AnonymousClass3(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3 r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3 r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.AnonymousClass3) r1
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3$1
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

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1", f = "ArgoEngine.kt", l = {283, 298}, m = "invokeSuspend")
    public static final class C03951 extends xd.j implements ee.e {
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        int label;

        public C03951(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r2, wd.d r3) {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1 r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.C03951) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
                r33 = this;
                r0 = r33
                kotlin.coroutines.intrinsics.a r1 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 5000(0x1388, double:2.4703E-320)
                r5 = 0
                r7 = 2
                r8 = 0
                r9 = 0
                r10 = 1
                if (r2 == 0) goto L46
                if (r2 == r10) goto L33
                if (r2 != r7) goto L2b
                long r11 = r0.J$0
                int r2 = r0.I$1
                int r13 = r0.I$0
                java.lang.Object r14 = r0.L$1
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r14 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Live) r14
                java.lang.Object r15 = r0.L$0
                kotlinx.coroutines.i0 r15 = (kotlinx.coroutines.i0) r15
                sd.m.b(r34)
                r16 = r3
                r3 = r34
                goto Le8
            L2b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L33:
                long r11 = r0.J$0
                int r2 = r0.I$1
                int r13 = r0.I$0
                java.lang.Object r14 = r0.L$0
                kotlinx.coroutines.i0 r14 = (kotlinx.coroutines.i0) r14
                sd.m.b(r34)
                r32 = r14
                r14 = r2
                r2 = r32
                goto L70
            L46:
                sd.m.b(r34)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.i0 r2 = (kotlinx.coroutines.i0) r2
                r11 = r5
                r13 = r8
                r14 = r13
            L50:
                boolean r15 = kotlinx.coroutines.m0.t(r2)
                if (r15 == 0) goto L1dd
                boolean r15 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$getWantConnected$p()
                if (r15 == 0) goto L1dd
                r0.L$0 = r2
                r0.L$1 = r9
                r0.I$0 = r13
                r0.I$1 = r14
                r0.J$0 = r11
                r0.label = r10
                java.lang.Object r15 = kotlinx.coroutines.m0.j(r3, r0)
                if (r15 != r1) goto L70
                goto Le2
            L70:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r15 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$getLive$p()
                if (r15 != 0) goto L78
                goto L1dd
            L78:
                r16 = r3
                com.mlmvpn.scanner.engines.argo.ArgoEngine r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
                boolean r4 = r3.isOurs()
                if (r4 != 0) goto Lc5
                com.mlmvpn.scanner.MyVpnService$Companion r1 = com.mlmvpn.scanner.MyVpnService.Companion
                kotlinx.coroutines.flow.k0 r1 = r1.getConnectionPhaseFlow()
                kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
                java.lang.Object r1 = r1.getValue()
                com.mlmvpn.scanner.MyVpnService$Phase r2 = com.mlmvpn.scanner.MyVpnService.Phase.CONNECTED
                java.lang.String r4 = "replaced"
                if (r1 != r2) goto L96
                r1 = r4
                goto L98
            L96:
                java.lang.String r1 = "stopped"
            L98:
                com.mlmvpn.scanner.engines.argo.ArgoEngine.access$setWantConnected$p(r8)
                com.mlmvpn.scanner.engines.argo.ArgoEngine.access$setLive$p(r9)
                kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$get_lastWhy$p()
                kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
                r2.getClass()
                r2.k(r9, r1)
                kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$get_conn$p()
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Idle r5 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Idle.INSTANCE
                kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
                r2.j(r5)
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto Lbe
                java.lang.String r1 = "موتور دیگری VPN را گرفت؛ اتصال آرگو کنار رفت."
                goto Lc0
            Lbe:
                java.lang.String r1 = "موتور متوقف شد؛ اتصال آرگو تمام شد."
            Lc0:
                r3.log(r1)
                goto L1dd
            Lc5:
                long r11 = r11 + r16
                r18 = 60000(0xea60, double:2.9644E-319)
                int r4 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
                if (r4 < 0) goto L1d9
                int r13 = r13 + 1
                r0.L$0 = r2
                r0.L$1 = r15
                r0.I$0 = r13
                r0.I$1 = r14
                r0.J$0 = r5
                r0.label = r7
                java.lang.Object r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$trace(r3, r0)
                if (r3 != r1) goto Le3
            Le2:
                return r1
            Le3:
                r11 = r15
                r15 = r2
                r2 = r14
                r14 = r11
                r11 = r5
            Le8:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r3 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace) r3
                kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$get_conn$p()
                kotlinx.coroutines.flow.g1 r4 = (kotlinx.coroutines.flow.g1) r4
                java.lang.Object r4 = r4.getValue()
                boolean r5 = r4 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected
                if (r5 == 0) goto Lfd
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r4 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected) r4
                r20 = r4
                goto Lff
            Lfd:
                r20 = r9
            Lff:
                if (r3 == 0) goto L13b
                if (r20 == 0) goto L110
                boolean r2 = r20.getLost()
                if (r2 != r10) goto L110
                com.mlmvpn.scanner.engines.argo.ArgoEngine r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
                java.lang.String r4 = "سرور دوباره داده رد می\u200cکند."
                r2.log(r4)
            L110:
                if (r20 == 0) goto L139
                kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$get_conn$p()
                java.lang.String r23 = r3.getLoc()
                java.lang.String r24 = r3.getIp()
                long r25 = r3.getMs()
                r30 = 163(0xa3, float:2.28E-43)
                r31 = 0
                r21 = 0
                r22 = 0
                r27 = 0
                r28 = 0
                r29 = 0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected.copy$default(r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31)
                kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
                r2.j(r3)
            L139:
                r2 = r8
                goto L16e
            L13b:
                int r2 = r2 + r10
                if (r2 < r7) goto L16e
                if (r20 == 0) goto L16e
                boolean r3 = r20.getLost()
                if (r3 != 0) goto L16e
                kotlinx.coroutines.flow.k0 r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$get_conn$p()
                r30 = 191(0xbf, float:2.68E-43)
                r31 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r27 = 0
                r28 = 1
                r29 = 0
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r4 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected.copy$default(r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31)
                kotlinx.coroutines.flow.g1 r3 = (kotlinx.coroutines.flow.g1) r3
                r3.j(r4)
                com.mlmvpn.scanner.engines.argo.ArgoEngine r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
                java.lang.String r4 = "دو آزمون پیاپی از داخل سرور جواب نداد."
                r3.log(r4)
            L16e:
                int r3 = r13 % 10
                if (r3 != 0) goto L1d1
                com.mlmvpn.scanner.engines.argo.ArgoNet r20 = com.mlmvpn.scanner.engines.argo.ArgoNet.INSTANCE
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r3 = r14.getEp()
                java.lang.String r22 = r3.getHost()
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r3 = r14.getEp()
                int r23 = r3.getPort()
                com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r24 = r14.getInfo()
                com.mlmvpn.scanner.utils.LocalPort r3 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
                android.content.Context r4 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$getApp$p()
                if (r4 == 0) goto L1cb
                int r3 = r3.get(r4)
                int r3 = r3 + 10000
                r28 = 32
                r29 = 0
                java.lang.String r21 = "keepalive"
                r26 = 0
                r25 = r3
                sd.j r3 = com.mlmvpn.scanner.engines.argo.ArgoNet.sessionRequest$default(r20, r21, r22, r23, r24, r25, r26, r28, r29)
                java.lang.Object r4 = r3.component1()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                java.lang.Object r3 = r3.component2()
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                com.mlmvpn.scanner.engines.argo.ArgoEngine r5 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
                if (r4 == 0) goto L1bf
                java.lang.String r3 = "نشست با سرور تمدید شد."
                goto L1c7
            L1bf:
                java.lang.String r4 = "تمدید نشست جواب نداد (کد "
                java.lang.String r6 = ")."
                java.lang.String r3 = androidx.compose.foundation.interaction.f.o(r3, r4, r6)
            L1c7:
                r5.log(r3)
                goto L1d1
            L1cb:
                java.lang.String r1 = "app"
                kotlin.jvm.internal.j.k(r1)
                throw r9
            L1d1:
                r14 = r2
                r2 = r15
                r3 = r16
                r5 = 0
                goto L50
            L1d9:
                r3 = r16
                goto L50
            L1dd:
                sd.u r1 = sd.u.f67154a
                return r1
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        private /* synthetic */ java.lang.Object L$0;
        int label;

        public AnonymousClass2(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r2, wd.d r3) {
                r1 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2 r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2 r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.AnonymousClass2) r1
                sd.u r2 = sd.u.f67154a
                java.lang.Object r1 = r1.invokeSuspend(r2)
                return r1
        }

        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                r11 = this;
                kotlin.coroutines.intrinsics.a r0 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
                int r0 = r11.label
                if (r0 != 0) goto Lf2
                sd.m.b(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.i0 r12 = (kotlinx.coroutines.i0) r12
                r12 = 0
                okhttp3.OkHttpClient$Builder r0 = new okhttp3.OkHttpClient$Builder     // Catch: java.lang.Throwable -> Ld3
                r0.<init>()     // Catch: java.lang.Throwable -> Ld3
                java.net.Proxy r1 = new java.net.Proxy     // Catch: java.lang.Throwable -> Ld3
                java.net.Proxy$Type r2 = java.net.Proxy.Type.HTTP     // Catch: java.lang.Throwable -> Ld3
                java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> Ld3
                java.lang.String r4 = "127.0.0.1"
                com.mlmvpn.scanner.utils.LocalPort r5 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE     // Catch: java.lang.Throwable -> Ld3
                android.content.Context r6 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$getApp$p()     // Catch: java.lang.Throwable -> Ld3
                if (r6 == 0) goto Ldb
                int r5 = r5.get(r6)     // Catch: java.lang.Throwable -> Ld3
                int r5 = r5 + 10000
                r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> Ld3
                r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> Ld3
                r0.e(r1)     // Catch: java.lang.Throwable -> Ld3
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> Ld3
                r2 = 12
                r0.a(r2, r1)     // Catch: java.lang.Throwable -> Ld3
                okhttp3.OkHttpClient r1 = new okhttp3.OkHttpClient     // Catch: java.lang.Throwable -> Ld3
                r1.<init>(r0)     // Catch: java.lang.Throwable -> Ld3
                long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> Ld3
                okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch: java.lang.Throwable -> Ld3
                r0.<init>()     // Catch: java.lang.Throwable -> Ld3
                java.lang.String r4 = "https://www.cloudflare.com/cdn-cgi/trace"
                r0.j(r4)     // Catch: java.lang.Throwable -> Ld3
                okhttp3.Request r4 = new okhttp3.Request     // Catch: java.lang.Throwable -> Ld3
                r4.<init>(r0)     // Catch: java.lang.Throwable -> Ld3
                okhttp3.internal.connection.RealCall r0 = r1.b(r4)     // Catch: java.lang.Throwable -> Ld3
                okhttp3.Response r0 = r0.d()     // Catch: java.lang.Throwable -> Ld3
                okhttp3.ResponseBody r1 = r0.f29156h     // Catch: java.lang.Throwable -> L62
                if (r1 == 0) goto L65
                java.lang.String r1 = r1.w()     // Catch: java.lang.Throwable -> L62
                goto L66
            L62:
                r1 = move-exception
                goto Ld5
            L65:
                r1 = r12
            L66:
                java.lang.String r4 = ""
                if (r1 != 0) goto L6b
                r1 = r4
            L6b:
                boolean r5 = r0.A     // Catch: java.lang.Throwable -> L62
                if (r5 != 0) goto L71
            L6f:
                r1 = r12
                goto Lcb
            L71:
                kotlin.text.l r5 = new kotlin.text.l     // Catch: java.lang.Throwable -> L62
                java.lang.String r6 = "(?m)^loc=([A-Z]{2})"
                r5.<init>(r6)     // Catch: java.lang.Throwable -> L62
                r6 = 2
                r7 = 0
                kotlin.text.g r5 = kotlin.text.l.find$default(r5, r1, r7, r6, r12)     // Catch: java.lang.Throwable -> L62
                r8 = 1
                if (r5 == 0) goto L90
                kotlin.text.i r5 = (kotlin.text.i) r5     // Catch: java.lang.Throwable -> L62
                java.util.List r5 = r5.a()     // Catch: java.lang.Throwable -> L62
                kotlin.collections.f0 r5 = (kotlin.collections.f0) r5     // Catch: java.lang.Throwable -> L62
                java.lang.Object r5 = r5.get(r8)     // Catch: java.lang.Throwable -> L62
                java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L62
                goto L91
            L90:
                r5 = r12
            L91:
                if (r5 != 0) goto L94
                r5 = r4
            L94:
                kotlin.text.l r9 = new kotlin.text.l     // Catch: java.lang.Throwable -> L62
                java.lang.String r10 = "(?m)^ip=(\\S+)"
                r9.<init>(r10)     // Catch: java.lang.Throwable -> L62
                kotlin.text.g r1 = kotlin.text.l.find$default(r9, r1, r7, r6, r12)     // Catch: java.lang.Throwable -> L62
                if (r1 == 0) goto Lb0
                kotlin.text.i r1 = (kotlin.text.i) r1     // Catch: java.lang.Throwable -> L62
                java.util.List r1 = r1.a()     // Catch: java.lang.Throwable -> L62
                kotlin.collections.f0 r1 = (kotlin.collections.f0) r1     // Catch: java.lang.Throwable -> L62
                java.lang.Object r1 = r1.get(r8)     // Catch: java.lang.Throwable -> L62
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L62
                goto Lb1
            Lb0:
                r1 = r12
            Lb1:
                if (r1 != 0) goto Lb4
                goto Lb5
            Lb4:
                r4 = r1
            Lb5:
                int r1 = r5.length()     // Catch: java.lang.Throwable -> L62
                if (r1 != 0) goto Lbc
                goto L6f
            Lbc:
                com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace     // Catch: java.lang.Throwable -> L62
                long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L62
                long r6 = r6 - r2
                r2 = 1000000(0xf4240, float:1.401298E-39)
                long r2 = (long) r2     // Catch: java.lang.Throwable -> L62
                long r6 = r6 / r2
                r1.<init>(r5, r4, r6)     // Catch: java.lang.Throwable -> L62
            Lcb:
                r0.close()     // Catch: java.lang.Throwable -> Ld3
                java.lang.Object r0 = sd.l.m1004constructorimpl(r1)     // Catch: java.lang.Throwable -> Ld3
                goto Le9
            Ld3:
                r0 = move-exception
                goto Le1
            Ld5:
                throw r1     // Catch: java.lang.Throwable -> Ld6
            Ld6:
                r2 = move-exception
                a.a.g(r0, r1)     // Catch: java.lang.Throwable -> Ld3
                throw r2     // Catch: java.lang.Throwable -> Ld3
            Ldb:
                java.lang.String r0 = "app"
                kotlin.jvm.internal.j.k(r0)     // Catch: java.lang.Throwable -> Ld3
                throw r12     // Catch: java.lang.Throwable -> Ld3
            Le1:
                sd.l$a r0 = sd.m.a(r0)
                java.lang.Object r0 = sd.l.m1004constructorimpl(r0)
            Le9:
                boolean r1 = sd.l.m1010isFailureimpl(r0)
                if (r1 == 0) goto Lf0
                goto Lf1
            Lf0:
                r12 = r0
            Lf1:
                return r12
            Lf2:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {166, 174, 175, 181, 183}, m = "tryOne")
    public static final class C03961 extends xd.c {
        int I$0;
        int I$1;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine this$0;

        public C03961(com.mlmvpn.scanner.engines.argo.ArgoEngine r1, wd.d r2) {
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine r3 = r2.this$0
                r0 = 0
                r1 = 0
                java.lang.Object r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$tryOne(r3, r0, r0, r1, r2)
                return r3
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3", f = "ArgoEngine.kt", l = {174}, m = "invokeSuspend")
    public static final class C03973 extends xd.j implements ee.e {
        int label;

        public C03973(wd.d r2) {
                r1 = this;
                r0 = 2
                r1.<init>(r0, r2)
                return
        }

        @Override // xd.a
        public final wd.d create(java.lang.Object r1, wd.d r2) {
                r0 = this;
                com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3 r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3
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
                com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3 r1 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.C03973) r1
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
                android.content.Context r1 = com.mlmvpn.scanner.engines.argo.ArgoEngine.access$getApp$p()
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

    static {
            com.mlmvpn.scanner.engines.argo.ArgoEngine r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine
            r0.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE = r0
            kotlinx.coroutines.r2 r0 = kotlinx.coroutines.m0.b()
            oe.e r1 = kotlinx.coroutines.v0.f24208c
            wd.i r0 = g8.a.D(r1, r0)
            kotlinx.coroutines.internal.e r0 = kotlinx.coroutines.m0.a(r0)
            com.mlmvpn.scanner.engines.argo.ArgoEngine.scope = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Idle r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Idle.INSTANCE
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.argo.ArgoEngine._conn = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine.conn = r0
            kotlin.collections.w r0 = kotlin.collections.w.INSTANCE
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.argo.ArgoEngine._logs = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine.logs = r0
            r0 = 0
            kotlinx.coroutines.flow.g1 r0 = kotlinx.coroutines.flow.h.b(r0)
            com.mlmvpn.scanner.engines.argo.ArgoEngine._lastWhy = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine.lastWhy = r0
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = new com.mlmvpn.scanner.utils.ConnectionOwner
            r0.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoEngine.connectionOwner = r0
            r0 = 8
            com.mlmvpn.scanner.engines.argo.ArgoEngine.$stable = r0
            return
    }

    private ArgoEngine() {
            r0 = this;
            r0.<init>()
            return
    }

    public static /* synthetic */ sd.u a(android.content.Context r0) {
            sd.u r0 = disconnectAsync$lambda$2(r0)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$connect(com.mlmvpn.scanner.engines.argo.ArgoEngine r0, java.lang.String r1, java.lang.String r2, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r3, wd.d r4) {
            java.lang.Object r0 = r0.connect(r1, r2, r3, r4)
            return r0
    }

    public static final /* synthetic */ android.content.Context access$getApp$p() {
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            return r0
    }

    public static final /* synthetic */ com.mlmvpn.scanner.engines.argo.ArgoEngine.Live access$getLive$p() {
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.live
            return r0
    }

    public static final /* synthetic */ boolean access$getWantConnected$p() {
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected
            return r0
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.k0 access$get_conn$p() {
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            return r0
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.k0 access$get_lastWhy$p() {
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine._lastWhy
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$launch(com.mlmvpn.scanner.engines.argo.ArgoEngine r0, java.lang.String r1, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r2, wd.d r3) {
            java.lang.Object r0 = r0.launch(r1, r2, r3)
            return r0
    }

    public static final /* synthetic */ void access$setLive$p(com.mlmvpn.scanner.engines.argo.ArgoEngine.Live r0) {
            com.mlmvpn.scanner.engines.argo.ArgoEngine.live = r0
            return
    }

    public static final /* synthetic */ void access$setWantConnected$p(boolean r0) {
            com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected = r0
            return
    }

    public static final /* synthetic */ void access$stopService(com.mlmvpn.scanner.engines.argo.ArgoEngine r0) {
            r0.stopService()
            return
    }

    public static final /* synthetic */ java.lang.Object access$trace(com.mlmvpn.scanner.engines.argo.ArgoEngine r0, wd.d r1) {
            java.lang.Object r0 = r0.trace(r1)
            return r0
    }

    public static final /* synthetic */ java.lang.Object access$tryOne(com.mlmvpn.scanner.engines.argo.ArgoEngine r0, com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r1, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r2, int r3, wd.d r4) {
            java.lang.Object r0 = r0.tryOne(r1, r2, r3, r4)
            return r0
    }

    public static /* synthetic */ kotlinx.coroutines.s1 b(android.content.Context r0, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r1, java.lang.String r2, java.lang.String r3) {
            kotlinx.coroutines.s1 r0 = connectAsync$lambda$1(r0, r1, r2, r3)
            return r0
    }

    private final java.lang.String config(com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r20, com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo r21, java.lang.String r22) {
            r19 = this;
            com.mlmvpn.scanner.utils.LocalPort r0 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r1 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r1 == 0) goto L1a1
            int r0 = r0.get(r1)
            java.lang.String r1 = "remarks"
            java.lang.String r2 = "mlm-argo-v1"
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
            com.mlmvpn.scanner.engines.argo.ArgoProtocol r11 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.INSTANCE
            r17 = 16
            r18 = 0
            java.lang.String r14 = "proxy"
            r16 = 0
            r12 = r20
            r13 = r21
            r15 = r22
            sf.c r6 = com.mlmvpn.scanner.engines.argo.ArgoProtocol.xrayOutbound$default(r11, r12, r13, r14, r15, r16, r17, r18)
            r3.put(r6)
            sf.c r6 = new sf.c
            r6.<init>()
            java.lang.String r7 = "direct"
            r6.D(r4, r7)
            java.lang.String r8 = "freedom"
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r10, r8, r3, r6)
            java.lang.String r8 = "dns-out"
            r6.D(r4, r8)
            java.lang.String r11 = "dns"
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r10, r11, r3, r6)
            java.lang.String r12 = "blocked"
            r6.D(r4, r12)
            java.lang.String r13 = "blackhole"
            r6.D(r10, r13)
            r3.put(r6)
            if (r2 == 0) goto Le4
            r3.put(r2)
        Le4:
            java.lang.String r6 = "outbounds"
            r1.D(r6, r3)
            sf.c r3 = new sf.c
            r3.<init>()
            java.lang.String r6 = "argo-dns"
            r3.D(r4, r6)
            sf.a r10 = new sf.a
            r10.<init>()
            sf.c r13 = new sf.c
            r13.<init>()
            java.lang.String r14 = "https://8.8.8.8/dns-query"
            java.lang.String r15 = "address"
            r13.D(r15, r14)
            r10.put(r13)
            sf.c r13 = new sf.c
            r13.<init>()
            java.lang.String r14 = "https://1.1.1.1/dns-query"
            r13.D(r15, r14)
            r10.put(r13)
            java.lang.String r13 = "servers"
            r3.D(r13, r10)
            java.lang.String r10 = "queryStrategy"
            java.lang.String r13 = "UseIPv4"
            r3.D(r10, r13)
            r1.D(r11, r3)
            sf.a r3 = new sf.a
            r3.<init>()
            java.lang.String r10 = "53"
            java.lang.String r11 = "type"
            java.lang.String r13 = "field"
            sf.c r10 = com.mlmvpn.core.aether.i.p(r11, r13, r5, r10)
            java.lang.String r14 = "outboundTag"
            sf.c r8 = com.mlmvpn.scanner.e.o(r10, r14, r8, r3, r10)
            r8.D(r11, r13)
            sf.a r10 = new sf.a
            r10.<init>()
            r10.put(r6)
            java.lang.String r6 = "inboundTag"
            r8.D(r6, r10)
            java.lang.String r6 = "proxy"
            sf.c r6 = com.mlmvpn.scanner.e.o(r8, r14, r6, r3, r8)
            r6.D(r11, r13)
            sf.a r8 = new sf.a
            r8.<init>()
            java.lang.String r10 = "geoip:private"
            r8.put(r10)
            java.lang.String r10 = "ip"
            r6.D(r10, r8)
            sf.c r6 = com.mlmvpn.scanner.e.o(r6, r14, r7, r3, r6)
            r6.D(r11, r13)
            java.lang.String r7 = "network"
            r6.D(r7, r9)
            java.lang.String r7 = "443"
            r6.D(r5, r7)
            if (r2 == 0) goto L17d
            java.lang.String r5 = ""
            java.lang.String r4 = r2.A(r4, r5)
            if (r4 != 0) goto L17c
            goto L17d
        L17c:
            r12 = r4
        L17d:
            sf.c r4 = com.mlmvpn.scanner.e.o(r6, r14, r12, r3, r6)
            java.lang.String r5 = "domainStrategy"
            java.lang.String r6 = "AsIs"
            r4.D(r5, r6)
            java.lang.String r5 = "rules"
            r4.D(r5, r3)
            java.lang.String r3 = "routing"
            r1.D(r3, r4)
            if (r2 == 0) goto L197
            r0.addQuicRefusalPolicyTo(r1)
        L197:
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        L1a1:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            r0 = 0
            throw r0
    }

    private final java.lang.Object connect(java.lang.String r27, java.lang.String r28, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r29, wd.d r30) {
            r26 = this;
            r0 = r27
            r1 = r28
            r2 = r30
            sd.u r3 = sd.u.f67154a
            boolean r4 = r2 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.AnonymousClass1
            if (r4 == 0) goto L1d
            r4 = r2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$connect$1 r4 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.AnonymousClass1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1d
            int r5 = r5 - r6
            r4.label = r5
            r5 = r26
            goto L24
        L1d:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$connect$1 r4 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$connect$1
            r5 = r26
            r4.<init>(r5, r2)
        L24:
            java.lang.Object r2 = r4.result
            kotlin.coroutines.intrinsics.a r6 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r7 = r4.label
            r8 = 0
            java.lang.String r9 = "وصل نشد"
            r10 = 1
            if (r7 == 0) goto L5d
            if (r7 != r10) goto L55
            int r1 = r4.I$0
            java.lang.Object r0 = r4.L$3
            r7 = r0
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r7 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r7
            java.lang.Object r0 = r4.L$2
            r11 = r0
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r0 = r4.L$1
            r12 = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r12 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r12
            java.lang.Object r0 = r4.L$0
            r13 = r0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r13 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r13
            sd.m.b(r2)     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L52
            goto Ld2
        L4d:
            r0 = move-exception
            r2 = r1
            r1 = r12
            goto Ld4
        L52:
            r0 = move-exception
            goto L11a
        L55:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L5d:
            sd.m.b(r2)
            if (r1 == 0) goto L74
            boolean r2 = kotlin.text.o.L0(r1)
            if (r2 == 0) goto L69
            goto L74
        L69:
            com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r0.endpointFromRaw(r1)
            java.util.List r0 = m9.d.B(r0)
            goto L99
        L74:
            if (r0 == 0) goto L92
            boolean r1 = kotlin.text.o.L0(r0)
            if (r1 == 0) goto L7d
            goto L92
        L7d:
            com.mlmvpn.scanner.engines.argo.ArgoPool r1 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r0 = r1.get(r0)
            if (r0 == 0) goto L8a
            java.util.List r0 = m9.d.B(r0)
            goto L99
        L8a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "این مورد در فهرست نیست"
            r0.<init>(r1)
            throw r0
        L92:
            com.mlmvpn.scanner.engines.argo.ArgoPool r0 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            r1 = 3
            java.util.List r0 = r0.pick(r1)
        L99:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L132
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = r29
            r11 = r0
            r13 = r5
            r0 = r8
            r2 = r9
        Lab:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L11b
            int r2 = r0 + 1
            java.lang.Object r0 = r11.next()
            r7 = r0
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r7 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r7
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected
            if (r0 != 0) goto Lbf
            return r3
        Lbf:
            r4.L$0 = r13     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            r4.L$1 = r1     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            r4.L$2 = r11     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            r4.L$3 = r7     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            r4.I$0 = r2     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            r4.label = r10     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            java.lang.Object r0 = r13.tryOne(r7, r1, r2, r4)     // Catch: java.util.concurrent.CancellationException -> L52 java.lang.Throwable -> Ld3
            if (r0 != r6) goto Ld2
            return r6
        Ld2:
            return r3
        Ld3:
            r0 = move-exception
        Ld4:
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto Ldb
            r0 = r9
        Ldb:
            java.lang.String r12 = r7.getHost()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "«"
            r14.<init>(r15)
            r14.append(r12)
            java.lang.String r12 = "» وصل نشد: "
            r14.append(r12)
            r14.append(r0)
            java.lang.String r12 = r14.toString()
            r13.log(r12)
            com.mlmvpn.scanner.engines.argo.ArgoPool r14 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            java.lang.String r15 = r7.getId()
            r24 = 220(0xdc, float:3.08E-43)
            r25 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r21 = r0
            com.mlmvpn.scanner.engines.argo.ArgoPool.record$default(r14, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25)
            r13.stopService()
            r0 = r2
            r2 = r21
            goto Lab
        L11a:
            throw r0
        L11b:
            boolean r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected
            if (r0 == 0) goto L131
            kotlinx.coroutines.flow.k0 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Failed
            r1.<init>(r2)
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            r0.getClass()
            r2 = 0
            r0.k(r2, r1)
            com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected = r8
        L131:
            return r3
        L132:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "هیچ پل یا فالکنی برای اتصال نیست — اول «به\u200cروزرسانی» یا «سنجش» را بزنید"
            r0.<init>(r1)
            throw r0
    }

    public static /* synthetic */ kotlinx.coroutines.s1 connectAsync$default(com.mlmvpn.scanner.engines.argo.ArgoEngine r1, android.content.Context r2, java.lang.String r3, java.lang.String r4, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r5, int r6, java.lang.Object r7) {
            r7 = r6 & 2
            r0 = 0
            if (r7 == 0) goto L6
            r3 = r0
        L6:
            r7 = r6 & 4
            if (r7 == 0) goto Lb
            r4 = r0
        Lb:
            r6 = r6 & 8
            if (r6 == 0) goto L10
            r5 = r0
        L10:
            kotlinx.coroutines.s1 r1 = r1.connectAsync(r2, r3, r4, r5)
            return r1
    }

    private static final kotlinx.coroutines.s1 connectAsync$lambda$1(android.content.Context r2, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r3, java.lang.String r4, java.lang.String r5) {
            com.mlmvpn.scanner.engines.argo.ArgoEngine r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
            r0.init(r2)
            kotlinx.coroutines.s1 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.connectJob
            r0 = 0
            if (r2 == 0) goto Ld
            r2.cancel(r0)
        Ld:
            kotlinx.coroutines.s1 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.watchJob
            if (r2 == 0) goto L14
            r2.cancel(r0)
        L14:
            r2 = 1
            com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected = r2
            kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine._lastWhy
            kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
            r2.j(r0)
            if (r3 != 0) goto L38
            com.mlmvpn.scanner.utils.NetworkSettings r2 = com.mlmvpn.scanner.utils.NetworkSettings.INSTANCE
            android.content.Context r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r3 == 0) goto L32
            boolean r2 = r2.proxyMode(r3)
            if (r2 == 0) goto L2f
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.PROXY
            goto L38
        L2f:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.TUNNEL
            goto L38
        L32:
            java.lang.String r2 = "app"
            kotlin.jvm.internal.j.k(r2)
            throw r0
        L38:
            kotlinx.coroutines.i0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.scope
            com.mlmvpn.scanner.engines.argo.ArgoEngine$connectAsync$1$1 r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$connectAsync$1$1
            r1.<init>(r4, r5, r3, r0)
            r3 = 3
            kotlinx.coroutines.q2 r2 = kotlinx.coroutines.m0.y(r2, r0, r0, r1, r3)
            com.mlmvpn.scanner.engines.argo.ArgoEngine.connectJob = r2
            return r2
    }

    private static final sd.u disconnectAsync$lambda$2(android.content.Context r3) {
            com.mlmvpn.scanner.engines.argo.ArgoEngine r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.INSTANCE
            r0.init(r3)
            r3 = 0
            com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected = r3
            kotlinx.coroutines.s1 r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.connectJob
            r1 = 0
            if (r3 == 0) goto L10
            r3.cancel(r1)
        L10:
            kotlinx.coroutines.s1 r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.watchJob
            if (r3 == 0) goto L17
            r3.cancel(r1)
        L17:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.live
            com.mlmvpn.scanner.engines.argo.ArgoEngine.live = r1
            kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine._lastWhy
            kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
            r2.j(r1)
            kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            if (r3 != 0) goto L30
            boolean r0 = r0.isOurs()
            if (r0 == 0) goto L2d
            goto L30
        L2d:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Idle r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Idle.INSTANCE
            goto L32
        L30:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Stopping r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Stopping.INSTANCE
        L32:
            kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
            r2.j(r0)
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.scope
            com.mlmvpn.scanner.engines.argo.ArgoEngine$disconnectAsync$1$1 r2 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$disconnectAsync$1$1
            r2.<init>(r3, r1)
            r3 = 3
            kotlinx.coroutines.m0.y(r0, r1, r1, r2, r3)
            sd.u r3 = sd.u.f67154a
            return r3
    }

    private final java.lang.Object launch(java.lang.String r13, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r14, wd.d r15) {
            r12 = this;
            boolean r0 = r15 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.C03941
            if (r0 == 0) goto L13
            r0 = r15
            com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1 r0 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.C03941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1 r0 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1
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
            android.content.Context r7 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            java.lang.String r8 = "app"
            if (r7 == 0) goto Ld3
            android.content.Intent r9 = new android.content.Intent
            android.content.Context r10 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
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
            java.lang.String r10 = "argo"
            r9.putExtra(r13, r10)
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r13 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.PROXY
            if (r14 != r13) goto L80
            r13 = r6
            goto L81
        L80:
            r13 = r4
        L81:
            java.lang.String r14 = "PROXY_MODE"
            r9.putExtra(r14, r13)
            com.mlmvpn.scanner.utils.LocalPort r13 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r14 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r14 == 0) goto Lcb
            java.lang.String r13 = r13.getString(r14)
            java.lang.String r14 = "LOCAL_PORT"
            r9.putExtra(r14, r13)
            r2.service(r7, r9)
            if (r15 == 0) goto Laa
            com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3 r13 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$3
            r13.<init>(r5)
            r0.label = r6
            r14 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r13 = kotlinx.coroutines.m0.L(r14, r13, r0)
            if (r13 != r1) goto Laa
            goto Lbe
        Laa:
            kotlin.jvm.internal.u r13 = new kotlin.jvm.internal.u
            r13.<init>()
            com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$phase$1 r14 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$phase$1
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

    private final void startWatch() {
            r4 = this;
            kotlinx.coroutines.s1 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.watchJob
            r1 = 0
            if (r0 == 0) goto L8
            r0.cancel(r1)
        L8:
            kotlinx.coroutines.i0 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.scope
            com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1 r2 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1
            r2.<init>(r1)
            r3 = 3
            kotlinx.coroutines.q2 r0 = kotlinx.coroutines.m0.y(r0, r1, r1, r2, r3)
            com.mlmvpn.scanner.engines.argo.ArgoEngine.watchJob = r0
            return
    }

    private final void stopService() {
            r6 = this;
            boolean r0 = r6.isOurs()
            if (r0 == 0) goto L2b
            com.mlmvpn.scanner.utils.SafeStart r0 = com.mlmvpn.scanner.utils.SafeStart.INSTANCE
            android.content.Context r1 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            r2 = 0
            java.lang.String r3 = "app"
            if (r1 == 0) goto L27
            android.content.Intent r4 = new android.content.Intent
            android.content.Context r5 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
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

    private final java.lang.Object trace(wd.d r4) {
            r3 = this;
            oe.e r0 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2 r1 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2
            r2 = 0
            r1.<init>(r2)
            java.lang.Object r4 = kotlinx.coroutines.m0.J(r0, r1, r4)
            return r4
    }

    private final java.lang.Object tryOne(com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint r42, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r43, int r44, wd.d r45) {
            r41 = this;
            r0 = r41
            r1 = r42
            r2 = r44
            r3 = r45
            boolean r4 = r3 instanceof com.mlmvpn.scanner.engines.argo.ArgoEngine.C03961
            if (r4 == 0) goto L1b
            r4 = r3
            com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$1 r4 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.C03961) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$1 r4 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$1
            r4.<init>(r0, r3)
        L20:
            java.lang.Object r3 = r4.result
            kotlin.coroutines.intrinsics.a r5 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED
            int r6 = r4.label
            java.lang.String r7 = "لغو شد"
            r8 = 5
            r9 = 4
            r10 = 2
            r11 = 3
            r12 = 1
            r13 = 0
            if (r6 == 0) goto L109
            if (r6 == r12) goto Leb
            if (r6 == r10) goto Lc8
            if (r6 == r11) goto La5
            if (r6 == r9) goto L75
            if (r6 != r8) goto L6d
            int r1 = r4.I$1
            int r2 = r4.I$0
            java.lang.Object r6 = r4.L$7
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r6 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace) r6
            java.lang.Object r10 = r4.L$6
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r14 = r4.L$5
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r14 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo) r14
            java.lang.Object r15 = r4.L$4
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r15 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r15
            java.lang.Object r8 = r4.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r4.L$2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r9 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r9
            java.lang.Object r11 = r4.L$1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r11 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r11
            java.lang.Object r12 = r4.L$0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r12 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r12
            sd.m.b(r3)
            r0 = r6
            r6 = r14
            r3 = 4
        L64:
            r13 = r12
            r16 = 1
            r12 = r11
            r11 = r9
            r9 = r8
            r8 = r15
            goto L2c1
        L6d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L75:
            int r1 = r4.I$1
            int r2 = r4.I$0
            java.lang.Object r6 = r4.L$6
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r4.L$5
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r8 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo) r8
            java.lang.Object r9 = r4.L$4
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r9 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r9
            java.lang.Object r10 = r4.L$3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r4.L$2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r11 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r11
            java.lang.Object r12 = r4.L$1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r12 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r12
            java.lang.Object r14 = r4.L$0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r14 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r14
            sd.m.b(r3)
            r13 = r10
            r10 = r6
            r6 = r8
            r8 = r13
            r15 = r9
            r9 = r11
            r11 = r12
            r12 = r14
            r13 = 3
            r14 = r3
            r3 = 4
            goto L29c
        La5:
            int r1 = r4.I$0
            java.lang.Object r2 = r4.L$6
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r4.L$5
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r6 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo) r6
            java.lang.Object r8 = r4.L$4
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r8 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r8
            java.lang.Object r9 = r4.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r4.L$2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r10 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r10
            java.lang.Object r11 = r4.L$1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r11 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r11
            java.lang.Object r12 = r4.L$0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r12 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r12
            sd.m.b(r3)
            goto L231
        Lc8:
            int r1 = r4.I$0
            java.lang.Object r2 = r4.L$6
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r4.L$5
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r6 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.SessionInfo) r6
            java.lang.Object r8 = r4.L$4
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r8 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r8
            java.lang.Object r9 = r4.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r4.L$2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r10 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r10
            java.lang.Object r11 = r4.L$1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r11 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r11
            java.lang.Object r12 = r4.L$0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r12 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r12
            sd.m.b(r3)
            goto L216
        Leb:
            int r1 = r4.I$0
            java.lang.Object r2 = r4.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r4.L$2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r6 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode) r6
            java.lang.Object r8 = r4.L$1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$Endpoint r8 = (com.mlmvpn.scanner.engines.argo.ArgoProtocol.Endpoint) r8
            java.lang.Object r9 = r4.L$0
            com.mlmvpn.scanner.engines.argo.ArgoEngine r9 = (com.mlmvpn.scanner.engines.argo.ArgoEngine) r9
            sd.m.b(r3)
            r40 = r2
            r2 = r1
            r1 = r8
            r8 = r3
            r3 = r40
            goto L194
        L109:
            sd.m.b(r3)
            com.mlmvpn.scanner.engines.argo.ArgoPool r3 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            java.lang.String r3 = r3.cleanIp()
            kotlinx.coroutines.flow.k0 r6 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r8 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r9 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.AUTH
            java.lang.String r11 = r1.getHost()
            java.lang.String r12 = r1.getKind()
            r8.<init>(r9, r11, r12, r2)
            kotlinx.coroutines.flow.g1 r6 = (kotlinx.coroutines.flow.g1) r6
            r6.getClass()
            r6.k(r13, r8)
            java.lang.String r6 = r1.getKind()
            java.lang.String r8 = "falcon"
            boolean r8 = kotlin.jvm.internal.j.a(r6, r8)
            if (r8 == 0) goto L13a
            java.lang.String r6 = "فالکن"
            goto L147
        L13a:
            java.lang.String r8 = "public"
            boolean r6 = kotlin.jvm.internal.j.a(r6, r8)
            if (r6 == 0) goto L145
            java.lang.String r6 = "سرور عمومی"
            goto L147
        L145:
            java.lang.String r6 = "پل"
        L147:
            java.lang.String r8 = r1.getHost()
            boolean r9 = kotlin.text.o.L0(r3)
            if (r9 != 0) goto L158
            java.lang.String r9 = " از راه آی\u200cپی تمیز "
            java.lang.String r9 = r9.concat(r3)
            goto L15a
        L158:
            java.lang.String r9 = ""
        L15a:
            java.lang.String r11 = " «"
            java.lang.String r12 = "»"
            java.lang.String r14 = "احراز هویت با "
            java.lang.StringBuilder r6 = androidx.media3.common.s.n(r14, r6, r11, r8, r12)
            r6.append(r9)
            java.lang.String r8 = "…"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r0.log(r6)
            oe.e r6 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$a$1 r8 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$a$1
            r8.<init>(r1, r3, r13)
            r4.L$0 = r0
            r4.L$1 = r1
            r9 = r43
            r4.L$2 = r9
            r4.L$3 = r3
            r4.I$0 = r2
            r11 = 1
            r4.label = r11
            java.lang.Object r6 = kotlinx.coroutines.m0.J(r6, r8, r4)
            if (r6 != r5) goto L191
            goto L2c0
        L191:
            r8 = r6
            r6 = r9
            r9 = r0
        L194:
            com.mlmvpn.scanner.engines.argo.ArgoNet$Auth r8 = (com.mlmvpn.scanner.engines.argo.ArgoNet.Auth) r8
            boolean r11 = com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected
            if (r11 == 0) goto L3d1
            com.mlmvpn.scanner.engines.argo.ArgoProtocol$SessionInfo r11 = r8.getInfo()
            boolean r12 = r8.getOk()
            if (r12 == 0) goto L3bf
            if (r11 != 0) goto L1a8
            goto L3bf
        L1a8:
            long r14 = r8.getMs()
            java.lang.String r12 = r11.getWsPath()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r13 = "سرور پذیرفت ("
            r10.<init>(r13)
            r10.append(r14)
            java.lang.String r13 = " میلی\u200cثانیه) — مسیر WebSocket «"
            r10.append(r13)
            r10.append(r12)
            java.lang.String r12 = "»."
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            r9.log(r10)
            kotlinx.coroutines.flow.k0 r10 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r12 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r13 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ENGINE
            java.lang.String r14 = r1.getHost()
            java.lang.String r15 = r1.getKind()
            r12.<init>(r13, r14, r15, r2)
            kotlinx.coroutines.flow.g1 r10 = (kotlinx.coroutines.flow.g1) r10
            r10.getClass()
            r13 = 0
            r10.k(r13, r12)
            java.lang.String r10 = r9.config(r1, r11, r3)
            oe.e r12 = kotlinx.coroutines.v0.f24208c
            com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3 r14 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3
            r14.<init>(r13)
            r4.L$0 = r9
            r4.L$1 = r1
            r4.L$2 = r6
            r4.L$3 = r3
            r4.L$4 = r8
            r4.L$5 = r11
            r4.L$6 = r10
            r4.I$0 = r2
            r13 = 2
            r4.label = r13
            java.lang.Object r12 = kotlinx.coroutines.m0.J(r12, r14, r4)
            if (r12 != r5) goto L20e
            goto L2c0
        L20e:
            r12 = r11
            r11 = r1
            r1 = r2
            r2 = r10
            r10 = r6
            r6 = r12
            r12 = r9
            r9 = r3
        L216:
            r4.L$0 = r12
            r4.L$1 = r11
            r4.L$2 = r10
            r4.L$3 = r9
            r4.L$4 = r8
            r4.L$5 = r6
            r4.L$6 = r2
            r4.I$0 = r1
            r3 = 3
            r4.label = r3
            java.lang.Object r3 = r12.launch(r2, r10, r4)
            if (r3 != r5) goto L231
            goto L2c0
        L231:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L254
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            com.mlmvpn.scanner.MyVpnService$Companion r2 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r2 = r2.getConnectionPhaseFlow()
            kotlinx.coroutines.flow.g1 r2 = (kotlinx.coroutines.flow.g1) r2
            java.lang.Object r2 = r2.getValue()
            com.mlmvpn.scanner.MyVpnService$Phase r3 = com.mlmvpn.scanner.MyVpnService.Phase.FAILED
            if (r2 != r3) goto L24e
            java.lang.String r2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد"
            goto L250
        L24e:
            java.lang.String r2 = "موتور بالا نیامد"
        L250:
            r1.<init>(r2)
            throw r1
        L254:
            kotlinx.coroutines.flow.k0 r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r13 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r14 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.VERIFY
            java.lang.String r15 = r11.getHost()
            java.lang.String r0 = r11.getKind()
            r13.<init>(r14, r15, r0, r1)
            kotlinx.coroutines.flow.g1 r3 = (kotlinx.coroutines.flow.g1) r3
            r3.getClass()
            r0 = 0
            r3.k(r0, r13)
            r0 = 0
            r3 = 0
        L270:
            r13 = 3
            if (r0 >= r13) goto L2db
            boolean r3 = com.mlmvpn.scanner.engines.argo.ArgoEngine.wantConnected
            if (r3 == 0) goto L2d5
            r4.L$0 = r12
            r4.L$1 = r11
            r4.L$2 = r10
            r4.L$3 = r9
            r4.L$4 = r8
            r4.L$5 = r6
            r4.L$6 = r2
            r3 = 0
            r4.L$7 = r3
            r4.I$0 = r1
            r4.I$1 = r0
            r3 = 4
            r4.label = r3
            java.lang.Object r14 = r12.trace(r4)
            if (r14 != r5) goto L296
            goto L2c0
        L296:
            r15 = r8
            r8 = r9
            r9 = r10
            r10 = r2
            r2 = r1
            r1 = r0
        L29c:
            r0 = r14
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Trace r0 = (com.mlmvpn.scanner.engines.argo.ArgoEngine.Trace) r0
            if (r0 != 0) goto L2cb
            r4.L$0 = r12
            r4.L$1 = r11
            r4.L$2 = r9
            r4.L$3 = r8
            r4.L$4 = r15
            r4.L$5 = r6
            r4.L$6 = r10
            r4.L$7 = r0
            r4.I$0 = r2
            r4.I$1 = r1
            r14 = 5
            r4.label = r14
            r13 = 1200(0x4b0, double:5.93E-321)
            java.lang.Object r13 = kotlinx.coroutines.m0.j(r13, r4)
            if (r13 != r5) goto L64
        L2c0:
            return r5
        L2c1:
            int r1 = r1 + 1
            r3 = r0
            r0 = r1
            r1 = r2
            r2 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            goto L270
        L2cb:
            r1 = r2
            r4 = r6
            r27 = r8
            r35 = r9
            r6 = r10
            r8 = r15
        L2d3:
            r3 = r11
            goto L2e3
        L2d5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r7)
            throw r0
        L2db:
            r0 = r3
            r4 = r6
            r27 = r9
            r35 = r10
            r6 = r2
            goto L2d3
        L2e3:
            if (r0 == 0) goto L3b7
            kotlinx.coroutines.flow.k0 r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine._conn
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting r5 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connecting
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Step r7 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Step.ROUTE
            java.lang.String r9 = r3.getHost()
            java.lang.String r10 = r3.getKind()
            r5.<init>(r7, r9, r10, r1)
            r1 = r2
            kotlinx.coroutines.flow.g1 r1 = (kotlinx.coroutines.flow.g1) r1
            r1.getClass()
            r13 = 0
            r1.k(r13, r5)
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r2 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Live
            r5 = r27
            r7 = r35
            r2.<init>(r3, r4, r5, r6, r7)
            com.mlmvpn.scanner.engines.argo.ArgoEngine.live = r2
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected r28 = new com.mlmvpn.scanner.engines.argo.ArgoEngine$Conn$Connected
            java.lang.String r29 = r3.getHost()
            java.lang.String r30 = r3.getKind()
            java.lang.String r31 = r0.getLoc()
            java.lang.String r32 = r0.getIp()
            long r33 = r0.getMs()
            java.lang.String r37 = r3.getId()
            r38 = 64
            r39 = 0
            r36 = 0
            r28.<init>(r29, r30, r31, r32, r33, r35, r36, r37, r38, r39)
            r2 = r28
            r1.getClass()
            r13 = 0
            r1.k(r13, r2)
            com.mlmvpn.scanner.engines.argo.ArgoPool r18 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            java.lang.String r19 = r3.getId()
            long r21 = r8.getMs()
            java.lang.String r23 = r0.getLoc()
            java.lang.String r24 = r0.getIp()
            r28 = 96
            r29 = 0
            r20 = 1
            r25 = 0
            r26 = 0
            com.mlmvpn.scanner.engines.argo.ArgoPool.record$default(r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29)
            java.lang.String r1 = r0.getLoc()
            boolean r2 = kotlin.text.o.L0(r1)
            if (r2 == 0) goto L362
            java.lang.String r1 = "??"
        L362:
            java.lang.String r2 = r0.getIp()
            long r3 = r0.getMs()
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode.PROXY
            if (r7 != r0) goto L387
            com.mlmvpn.scanner.utils.LocalPort r0 = com.mlmvpn.scanner.utils.LocalPort.INSTANCE
            android.content.Context r5 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r5 == 0) goto L37f
            int r0 = r0.get(r5)
            java.lang.String r5 = " — فقط پراکسی محلی 127.0.0.1:"
            java.lang.String r0 = f0.a.h(r0, r5)
            goto L389
        L37f:
            java.lang.String r0 = "app"
            kotlin.jvm.internal.j.k(r0)
            r17 = 0
            throw r17
        L387:
            java.lang.String r0 = " — تونل کامل گوشی"
        L389:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "وصل شد — خروج از "
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = " ("
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = ")، "
            r5.append(r1)
            java.lang.String r1 = " میلی\u200cثانیه"
            com.mlmvpn.core.aether.i.t(r3, r1, r0, r5)
            java.lang.String r0 = "."
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r12.log(r0)
            r12.startWatch()
            sd.u r0 = sd.u.f67154a
            return r0
        L3b7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "موتور بالا آمد ولی داده\u200cای از سرور رد نشد"
            r0.<init>(r1)
            throw r0
        L3bf:
            java.lang.String r0 = r8.getError()
            boolean r1 = kotlin.text.o.L0(r0)
            if (r1 == 0) goto L3cb
            java.lang.String r0 = "احراز هویت نشد"
        L3cb:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L3d1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r7)
            throw r0
    }

    public final kotlinx.coroutines.s1 connectAsync(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r11) {
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r8, r0)
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.connectionOwner
            com.mlmvpn.scanner.engines.argo.a r1 = new com.mlmvpn.scanner.engines.argo.a
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            r8 = 0
            java.lang.Object r8 = r0.replace(r8, r1)
            kotlinx.coroutines.s1 r8 = (kotlinx.coroutines.s1) r8
            return r8
    }

    public final boolean disconnectAsync(android.content.Context r3) {
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r3, r0)
            com.mlmvpn.scanner.utils.ConnectionOwner r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.connectionOwner
            com.mlmvpn.scanner.engines.argo.b r1 = new com.mlmvpn.scanner.engines.argo.b
            r1.<init>(r3)
            r3 = 0
            boolean r3 = r0.stop(r3, r1)
            return r3
    }

    public final java.lang.String freshConfig(android.content.Context r2) {
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            r1.init(r2)
            com.mlmvpn.scanner.engines.argo.ArgoEngine$Live r2 = com.mlmvpn.scanner.engines.argo.ArgoEngine.live
            if (r2 == 0) goto L11
            java.lang.String r2 = r2.getConfig()
            return r2
        L11:
            r2 = 0
            return r2
    }

    public final kotlinx.coroutines.flow.e1 getConn() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.conn
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getLastWhy() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.lastWhy
            return r0
    }

    public final kotlinx.coroutines.flow.e1 getLogs() {
            r1 = this;
            kotlinx.coroutines.flow.e1 r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.logs
            return r0
    }

    public final void init(android.content.Context r2) {
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r0 == 0) goto La
            return
        La:
            android.content.Context r2 = r2.getApplicationContext()
            com.mlmvpn.scanner.engines.argo.ArgoEngine.app = r2
            com.mlmvpn.scanner.engines.argo.ArgoPool r2 = com.mlmvpn.scanner.engines.argo.ArgoPool.INSTANCE
            android.content.Context r0 = com.mlmvpn.scanner.engines.argo.ArgoEngine.app
            if (r0 == 0) goto L1a
            r2.init(r0)
            return
        L1a:
            java.lang.String r2 = "app"
            kotlin.jvm.internal.j.k(r2)
            r2 = 0
            throw r2
    }

    public final boolean isArgoConfig(java.lang.String r2) {
            r1 = this;
            java.lang.String r0 = "mlm-argo-v1"
            boolean r2 = kotlin.jvm.internal.j.a(r2, r0)
            return r2
    }

    public final boolean isOurs() {
            r2 = this;
            com.mlmvpn.scanner.MyVpnService$Companion r0 = com.mlmvpn.scanner.MyVpnService.Companion
            kotlinx.coroutines.flow.k0 r0 = r0.getConnectedNodeIdFlow()
            kotlinx.coroutines.flow.g1 r0 = (kotlinx.coroutines.flow.g1) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "argo"
            boolean r0 = kotlin.jvm.internal.j.a(r0, r1)
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
            java.lang.String r1 = "ARGO"
            android.util.Log.i(r1, r4)
            kotlinx.coroutines.flow.k0 r4 = com.mlmvpn.scanner.engines.argo.ArgoEngine._logs
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
}
