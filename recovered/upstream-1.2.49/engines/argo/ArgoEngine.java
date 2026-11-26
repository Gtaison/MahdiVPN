package com.mlmvpn.scanner.engines.argo;

import a6.w0;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.media3.common.s;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.scanner.MyVpnService;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.data.studio.central.ExitProxy;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.engines.scout.ScoutScore;
import com.mlmvpn.scanner.ui.tunnel.TunnelExclusion;
import com.mlmvpn.scanner.utils.ConnectionOwner;
import com.mlmvpn.scanner.utils.LocalPort;
import com.mlmvpn.scanner.utils.NetworkSettings;
import com.mlmvpn.scanner.utils.SafeStart;
import com.mlmvpn.scanner.utils.XrayJsonGenerator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.w;
import kotlin.jvm.internal.j;
import kotlin.text.g;
import kotlin.text.i;
import kotlin.text.l;
import kotlin.text.o;
import kotlinx.coroutines.flow.e1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.v0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.mlmvpn.chat.bridge.GerehWatchdog;
import org.scilab.forge.jlatexmath.TeXSymbolParser;
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import sd.m;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoEngine {
    public static final int $stable;
    public static final String NODE_ID = "argo";
    private static final long OWNER_CHECK_MS = 5000;
    public static final String REMARKS = "mlm-argo-v1";
    private static final String TAG = "ARGO";
    private static final k0 _conn;
    private static final k0 _lastWhy;
    private static final k0 _logs;
    private static Context app;
    private static final e1 conn;
    private static s1 connectJob;
    private static final ConnectionOwner connectionOwner;
    private static final e1 lastWhy;
    private static volatile Live live;
    private static final e1 logs;
    private static volatile boolean wantConnected;
    private static s1 watchJob;
    public static final ArgoEngine INSTANCE = new ArgoEngine();
    private static final i0 scope = m0.a(g8.a.D(v0.f24208c, m0.b()));

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static abstract class Conn {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Connected extends Conn {
            public static final int $stable = 0;
            private final String exitCc;
            private final String exitIp;
            private final String host;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            private final String f11197id;
            private final String kind;
            private final boolean lost;
            private final Mode mode;
            private final long ms;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connected(String host, String kind, String exitCc, String exitIp, long j, Mode mode, boolean z10, String id2) {
                super(null);
                j.e(host, "host");
                j.e(kind, "kind");
                j.e(exitCc, "exitCc");
                j.e(exitIp, "exitIp");
                j.e(mode, "mode");
                j.e(id2, "id");
                this.host = host;
                this.kind = kind;
                this.exitCc = exitCc;
                this.exitIp = exitIp;
                this.ms = j;
                this.mode = mode;
                this.lost = z10;
                this.f11197id = id2;
            }

            public static /* synthetic */ Connected copy$default(Connected connected, String str, String str2, String str3, String str4, long j, Mode mode, boolean z10, String str5, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = connected.host;
                }
                if ((i & 2) != 0) {
                    str2 = connected.kind;
                }
                if ((i & 4) != 0) {
                    str3 = connected.exitCc;
                }
                if ((i & 8) != 0) {
                    str4 = connected.exitIp;
                }
                if ((i & 16) != 0) {
                    j = connected.ms;
                }
                if ((i & 32) != 0) {
                    mode = connected.mode;
                }
                if ((i & 64) != 0) {
                    z10 = connected.lost;
                }
                if ((i & 128) != 0) {
                    str5 = connected.f11197id;
                }
                String str6 = str5;
                Mode mode2 = mode;
                long j10 = j;
                String str7 = str3;
                String str8 = str4;
                return connected.copy(str, str2, str7, str8, j10, mode2, z10, str6);
            }

            public final String component1() {
                return this.host;
            }

            public final String component2() {
                return this.kind;
            }

            public final String component3() {
                return this.exitCc;
            }

            public final String component4() {
                return this.exitIp;
            }

            public final long component5() {
                return this.ms;
            }

            public final Mode component6() {
                return this.mode;
            }

            public final boolean component7() {
                return this.lost;
            }

            public final String component8() {
                return this.f11197id;
            }

            public final Connected copy(String host, String kind, String exitCc, String exitIp, long j, Mode mode, boolean z10, String id2) {
                j.e(host, "host");
                j.e(kind, "kind");
                j.e(exitCc, "exitCc");
                j.e(exitIp, "exitIp");
                j.e(mode, "mode");
                j.e(id2, "id");
                return new Connected(host, kind, exitCc, exitIp, j, mode, z10, id2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Connected)) {
                    return false;
                }
                Connected connected = (Connected) obj;
                return j.a(this.host, connected.host) && j.a(this.kind, connected.kind) && j.a(this.exitCc, connected.exitCc) && j.a(this.exitIp, connected.exitIp) && this.ms == connected.ms && this.mode == connected.mode && this.lost == connected.lost && j.a(this.f11197id, connected.f11197id);
            }

            public final String getExitCc() {
                return this.exitCc;
            }

            public final String getExitIp() {
                return this.exitIp;
            }

            public final String getHost() {
                return this.host;
            }

            public final String getId() {
                return this.f11197id;
            }

            public final String getKind() {
                return this.kind;
            }

            public final boolean getLost() {
                return this.lost;
            }

            public final Mode getMode() {
                return this.mode;
            }

            public final long getMs() {
                return this.ms;
            }

            public int hashCode() {
                return this.f11197id.hashCode() + w0.d((this.mode.hashCode() + w0.c(s.d(s.d(s.d(this.host.hashCode() * 31, 31, this.kind), 31, this.exitCc), 31, this.exitIp), 31, this.ms)) * 31, 31, this.lost);
            }

            public String toString() {
                String str = this.host;
                String str2 = this.kind;
                String str3 = this.exitCc;
                String str4 = this.exitIp;
                long j = this.ms;
                Mode mode = this.mode;
                boolean z10 = this.lost;
                String str5 = this.f11197id;
                StringBuilder sbN = s.n("Connected(host=", str, ", kind=", str2, ", exitCc=");
                d1.x(sbN, str3, ", exitIp=", str4, ", ms=");
                sbN.append(j);
                sbN.append(", mode=");
                sbN.append(mode);
                sbN.append(", lost=");
                sbN.append(z10);
                sbN.append(", id=");
                sbN.append(str5);
                sbN.append(")");
                return sbN.toString();
            }

            public /* synthetic */ Connected(String str, String str2, String str3, String str4, long j, Mode mode, boolean z10, String str5, int i, kotlin.jvm.internal.e eVar) {
                this(str, str2, str3, str4, j, mode, (i & 64) != 0 ? false : z10, (i & 128) != 0 ? "" : str5);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Connecting extends Conn {
            public static final int $stable = 0;
            private final int attempt;
            private final String host;
            private final String kind;
            private final Step step;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connecting(Step step, String host, String kind, int i) {
                super(null);
                j.e(step, "step");
                j.e(host, "host");
                j.e(kind, "kind");
                this.step = step;
                this.host = host;
                this.kind = kind;
                this.attempt = i;
            }

            public static /* synthetic */ Connecting copy$default(Connecting connecting, Step step, String str, String str2, int i, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    step = connecting.step;
                }
                if ((i10 & 2) != 0) {
                    str = connecting.host;
                }
                if ((i10 & 4) != 0) {
                    str2 = connecting.kind;
                }
                if ((i10 & 8) != 0) {
                    i = connecting.attempt;
                }
                return connecting.copy(step, str, str2, i);
            }

            public final Step component1() {
                return this.step;
            }

            public final String component2() {
                return this.host;
            }

            public final String component3() {
                return this.kind;
            }

            public final int component4() {
                return this.attempt;
            }

            public final Connecting copy(Step step, String host, String kind, int i) {
                j.e(step, "step");
                j.e(host, "host");
                j.e(kind, "kind");
                return new Connecting(step, host, kind, i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Connecting)) {
                    return false;
                }
                Connecting connecting = (Connecting) obj;
                return this.step == connecting.step && j.a(this.host, connecting.host) && j.a(this.kind, connecting.kind) && this.attempt == connecting.attempt;
            }

            public final int getAttempt() {
                return this.attempt;
            }

            public final String getHost() {
                return this.host;
            }

            public final String getKind() {
                return this.kind;
            }

            public final Step getStep() {
                return this.step;
            }

            public int hashCode() {
                return Integer.hashCode(this.attempt) + s.d(s.d(this.step.hashCode() * 31, 31, this.host), 31, this.kind);
            }

            public String toString() {
                Step step = this.step;
                String str = this.host;
                String str2 = this.kind;
                int i = this.attempt;
                StringBuilder sb2 = new StringBuilder("Connecting(step=");
                sb2.append(step);
                sb2.append(", host=");
                sb2.append(str);
                sb2.append(", kind=");
                return s.i(i, str2, ", attempt=", ")", sb2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Failed extends Conn {
            public static final int $stable = 0;
            private final String error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(String error) {
                super(null);
                j.e(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failed.error;
                }
                return failed.copy(str);
            }

            public final String component1() {
                return this.error;
            }

            public final Failed copy(String error) {
                j.e(error, "error");
                return new Failed(error);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && j.a(this.error, ((Failed) obj).error);
            }

            public final String getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return w0.n("Failed(error=", this.error, ")");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Idle extends Conn {
            public static final int $stable = 0;
            public static final Idle INSTANCE = new Idle();

            private Idle() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Stopping extends Conn {
            public static final int $stable = 0;
            public static final Stopping INSTANCE = new Stopping();

            private Stopping() {
                super(null);
            }
        }

        public /* synthetic */ Conn(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Conn() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Live {
        private final String config;
        private final String connectIp;
        private final ArgoProtocol.Endpoint ep;
        private final ArgoProtocol.SessionInfo info;
        private final Mode mode;

        public Live(ArgoProtocol.Endpoint ep, ArgoProtocol.SessionInfo info, String connectIp, String config, Mode mode) {
            j.e(ep, "ep");
            j.e(info, "info");
            j.e(connectIp, "connectIp");
            j.e(config, "config");
            j.e(mode, "mode");
            this.ep = ep;
            this.info = info;
            this.connectIp = connectIp;
            this.config = config;
            this.mode = mode;
        }

        public static /* synthetic */ Live copy$default(Live live, ArgoProtocol.Endpoint endpoint, ArgoProtocol.SessionInfo sessionInfo, String str, String str2, Mode mode, int i, Object obj) {
            if ((i & 1) != 0) {
                endpoint = live.ep;
            }
            if ((i & 2) != 0) {
                sessionInfo = live.info;
            }
            if ((i & 4) != 0) {
                str = live.connectIp;
            }
            if ((i & 8) != 0) {
                str2 = live.config;
            }
            if ((i & 16) != 0) {
                mode = live.mode;
            }
            Mode mode2 = mode;
            String str3 = str;
            return live.copy(endpoint, sessionInfo, str3, str2, mode2);
        }

        public final ArgoProtocol.Endpoint component1() {
            return this.ep;
        }

        public final ArgoProtocol.SessionInfo component2() {
            return this.info;
        }

        public final String component3() {
            return this.connectIp;
        }

        public final String component4() {
            return this.config;
        }

        public final Mode component5() {
            return this.mode;
        }

        public final Live copy(ArgoProtocol.Endpoint ep, ArgoProtocol.SessionInfo info, String connectIp, String config, Mode mode) {
            j.e(ep, "ep");
            j.e(info, "info");
            j.e(connectIp, "connectIp");
            j.e(config, "config");
            j.e(mode, "mode");
            return new Live(ep, info, connectIp, config, mode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Live)) {
                return false;
            }
            Live live = (Live) obj;
            return j.a(this.ep, live.ep) && j.a(this.info, live.info) && j.a(this.connectIp, live.connectIp) && j.a(this.config, live.config) && this.mode == live.mode;
        }

        public final String getConfig() {
            return this.config;
        }

        public final String getConnectIp() {
            return this.connectIp;
        }

        public final ArgoProtocol.Endpoint getEp() {
            return this.ep;
        }

        public final ArgoProtocol.SessionInfo getInfo() {
            return this.info;
        }

        public final Mode getMode() {
            return this.mode;
        }

        public int hashCode() {
            return this.mode.hashCode() + s.d(s.d((this.info.hashCode() + (this.ep.hashCode() * 31)) * 31, 31, this.connectIp), 31, this.config);
        }

        public String toString() {
            ArgoProtocol.Endpoint endpoint = this.ep;
            ArgoProtocol.SessionInfo sessionInfo = this.info;
            String str = this.connectIp;
            String str2 = this.config;
            Mode mode = this.mode;
            StringBuilder sb2 = new StringBuilder("Live(ep=");
            sb2.append(endpoint);
            sb2.append(", info=");
            sb2.append(sessionInfo);
            sb2.append(", connectIp=");
            d1.x(sb2, str, ", config=", str2, ", mode=");
            sb2.append(mode);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public enum Mode {
        TUNNEL,
        PROXY;

        private static final /* synthetic */ yd.a $ENTRIES = com.google.android.gms.internal.mlkit_language_id_common.j.j(values());

        public static yd.a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public enum Step {
        AUTH,
        ENGINE,
        VERIFY,
        ROUTE;

        private static final /* synthetic */ yd.a $ENTRIES = com.google.android.gms.internal.mlkit_language_id_common.j.j(values());

        public static yd.a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        public static final int $stable = 0;
        private final String ip;
        private final String loc;
        private final long ms;

        public Trace(String loc, String ip, long j) {
            j.e(loc, "loc");
            j.e(ip, "ip");
            this.loc = loc;
            this.ip = ip;
            this.ms = j;
        }

        public static /* synthetic */ Trace copy$default(Trace trace, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trace.loc;
            }
            if ((i & 2) != 0) {
                str2 = trace.ip;
            }
            if ((i & 4) != 0) {
                j = trace.ms;
            }
            return trace.copy(str, str2, j);
        }

        public final String component1() {
            return this.loc;
        }

        public final String component2() {
            return this.ip;
        }

        public final long component3() {
            return this.ms;
        }

        public final Trace copy(String loc, String ip, long j) {
            j.e(loc, "loc");
            j.e(ip, "ip");
            return new Trace(loc, ip, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Trace)) {
                return false;
            }
            Trace trace = (Trace) obj;
            return j.a(this.loc, trace.loc) && j.a(this.ip, trace.ip) && this.ms == trace.ms;
        }

        public final String getIp() {
            return this.ip;
        }

        public final String getLoc() {
            return this.loc;
        }

        public final long getMs() {
            return this.ms;
        }

        public int hashCode() {
            return Long.hashCode(this.ms) + s.d(this.loc.hashCode() * 31, 31, this.ip);
        }

        public String toString() {
            return w0.k(this.ms, ")", s.n("Trace(loc=", this.loc, ", ip=", this.ip, ", ms="));
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {149}, m = ScoutScore.CONNECT)
    public static final class AnonymousClass1 extends xd.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.this.connect(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {239, 241}, m = "launch")
    public static final class C03941 extends xd.c {
        int label;
        /* synthetic */ Object result;

        public C03941(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.this.launch(null, null, this);
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
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass1(wd.d dVar) {
                super(2, dVar);
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // ee.e
            public final Object invoke(MyVpnService.Phase phase, wd.d dVar) {
                return ((AnonymousClass1) create(phase, dVar)).invokeSuspend(u.f67154a);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                return Boolean.valueOf(((MyVpnService.Phase) this.L$0) != MyVpnService.Phase.CONNECTED);
            }
        }

        public AnonymousClass3(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new AnonymousClass3(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                return obj;
            }
            m.b(obj);
            k0 connectionPhaseFlow = MyVpnService.Companion.getConnectionPhaseFlow();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            Object objH = h.h(connectionPhaseFlow, anonymousClass1, this);
            return objH == aVar ? aVar : objH;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass3) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$startWatch$1", f = "ArgoEngine.kt", l = {283, 298}, m = "invokeSuspend")
    public static final class C03951 extends xd.j implements ee.e {
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C03951(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C03951 c03951 = new C03951(dVar);
            c03951.L$0 = obj;
            return c03951;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0056  */
        /* JADX WARN: Code duplicated, block: B:18:0x0070 A[PHI: r2 r3 r5 r11 r13 r14
          0x0070: PHI (r2v3 kotlinx.coroutines.i0) = (r2v10 kotlinx.coroutines.i0), (r2v21 kotlinx.coroutines.i0) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
          0x0070: PHI (r3v1 long) = (r3v5 long), (r3v0 long) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
          0x0070: PHI (r5v1 long) = (r5v3 long), (r5v0 long) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
          0x0070: PHI (r11v1 long) = (r11v5 long), (r11v7 long) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
          0x0070: PHI (r13v1 int) = (r13v3 int), (r13v5 int) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
          0x0070: PHI (r14v1 int) = (r14v3 int), (r14v8 int) binds: [B:16:0x006c, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:21:0x0078  */
        /* JADX WARN: Code duplicated, block: B:23:0x0082  */
        /* JADX WARN: Code duplicated, block: B:25:0x0094  */
        /* JADX WARN: Code duplicated, block: B:26:0x0096  */
        /* JADX WARN: Code duplicated, block: B:29:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:30:0x00be  */
        /* JADX WARN: Code duplicated, block: B:32:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:34:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:37:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:68:0x01d9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e3 -> B:38:0x00e8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01d9 -> B:11:0x0050). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                Method dump skipped, instruction units count: 480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.argo.ArgoEngine.C03951.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C03951) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            Object objM1004constructorimpl;
            Trace trace;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                Proxy.Type type = Proxy.Type.HTTP;
                LocalPort localPort = LocalPort.INSTANCE;
                Context context = ArgoEngine.app;
                if (context == null) {
                    j.k("app");
                    throw null;
                }
                builder.e(new Proxy(type, new InetSocketAddress(SniSession.LOCAL_HOST, localPort.get(context) + LocalPort.PROBE_OFFSET)));
                builder.a(12L, TimeUnit.SECONDS);
                OkHttpClient okHttpClient = new OkHttpClient(builder);
                long jNanoTime = System.nanoTime();
                Request.Builder builder2 = new Request.Builder();
                builder2.j("https://www.cloudflare.com/cdn-cgi/trace");
                Response responseD = okHttpClient.b(new Request(builder2)).d();
                try {
                    ResponseBody responseBody = responseD.f29156h;
                    String strW = responseBody != null ? responseBody.w() : null;
                    String str = "";
                    if (strW == null) {
                        strW = "";
                    }
                    if (responseD.A) {
                        g gVarFind$default = l.find$default(new l("(?m)^loc=([A-Z]{2})"), strW, 0, 2, null);
                        String str2 = gVarFind$default != null ? (String) ((f0) ((i) gVarFind$default).a()).get(1) : null;
                        if (str2 == null) {
                            str2 = "";
                        }
                        g gVarFind$default2 = l.find$default(new l("(?m)^ip=(\\S+)"), strW, 0, 2, null);
                        String str3 = gVarFind$default2 != null ? (String) ((f0) ((i) gVarFind$default2).a()).get(1) : null;
                        if (str3 != null) {
                            str = str3;
                        }
                        trace = str2.length() == 0 ? null : new Trace(str2, str, (System.nanoTime() - jNanoTime) / ((long) 1000000));
                    }
                    responseD.close();
                    objM1004constructorimpl = sd.l.m1004constructorimpl(trace);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        a.a.g(responseD, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th4));
            }
            if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                return null;
            }
            return objM1004constructorimpl;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass2) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {166, 174, 175, 181, 183}, m = "tryOne")
    public static final class C03961 extends xd.c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C03961(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.this.tryOne(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3", f = "ArgoEngine.kt", l = {174}, m = "invokeSuspend")
    public static final class C03973 extends xd.j implements ee.e {
        int label;

        public C03973(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C03973(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                m.b(obj);
                TunnelExclusion tunnelExclusion = TunnelExclusion.INSTANCE;
                Context context = ArgoEngine.app;
                if (context == null) {
                    j.k("app");
                    throw null;
                }
                this.label = 1;
                if (tunnelExclusion.releaseForXray(context, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
            }
            return u.f67154a;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C03973) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    static {
        g1 g1VarB = h.b(Conn.Idle.INSTANCE);
        _conn = g1VarB;
        conn = g1VarB;
        g1 g1VarB2 = h.b(w.INSTANCE);
        _logs = g1VarB2;
        logs = g1VarB2;
        g1 g1VarB3 = h.b(null);
        _lastWhy = g1VarB3;
        lastWhy = g1VarB3;
        connectionOwner = new ConnectionOwner();
        $stable = 8;
    }

    private ArgoEngine() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final String config(ArgoProtocol.Endpoint endpoint, ArgoProtocol.SessionInfo sessionInfo, String str) {
        String strA;
        LocalPort localPort = LocalPort.INSTANCE;
        Context context = app;
        if (context == null) {
            j.k("app");
            throw null;
        }
        int i = localPort.get(context);
        sf.c cVarO = com.mlmvpn.core.aether.i.o("remarks", REMARKS);
        sf.c cVar = new sf.c();
        cVar.D("loglevel", "warning");
        cVarO.D(XrayCoreHostService.KEY_LOG, cVar);
        sf.a aVar = new sf.a();
        sf.c cVarO2 = com.mlmvpn.core.aether.i.o("tag", "socks");
        com.mlmvpn.scanner.e.q(i, PsiphonProbeService.PORT, "listen", SniSession.LOCAL_HOST, cVarO2);
        sf.c cVarN = com.mlmvpn.scanner.e.n(cVarO2, "protocol", "mixed", "auth", "noauth");
        cVarN.E("udp", true);
        cVarO2.D("settings", cVarN);
        sf.c cVar2 = new sf.c();
        cVar2.E("enabled", true);
        sf.a aVar2 = new sf.a();
        aVar2.put(ExitProxy.HTTP);
        aVar2.put("tls");
        cVar2.D("destOverride", aVar2);
        cVarO2.D("sniffing", cVar2);
        aVar.put(cVarO2);
        sf.c cVar3 = new sf.c();
        cVar3.D("tag", ExitProxy.HTTP);
        cVar3.D(PsiphonProbeService.PORT, Integer.valueOf(i + LocalPort.PROBE_OFFSET));
        cVar3.D("listen", SniSession.LOCAL_HOST);
        cVar3.D("protocol", ExitProxy.HTTP);
        aVar.put(cVar3);
        cVarO.D("inbounds", aVar);
        XrayJsonGenerator xrayJsonGenerator = XrayJsonGenerator.INSTANCE;
        sf.c cVarQuicRefusalOutbound = xrayJsonGenerator.quicRefusalOutbound();
        sf.a aVar3 = new sf.a();
        aVar3.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, endpoint, sessionInfo, WarpIdRelay.VIA_PROXY, str, null, 16, null));
        sf.c cVar4 = new sf.c();
        cVar4.D("tag", WarpIdRelay.VIA_DIRECT);
        sf.c cVarO3 = com.mlmvpn.scanner.e.o(cVar4, "protocol", "freedom", aVar3, cVar4);
        cVarO3.D("tag", "dns-out");
        sf.c cVarO4 = com.mlmvpn.scanner.e.o(cVarO3, "protocol", "dns", aVar3, cVarO3);
        String str2 = "blocked";
        cVarO4.D("tag", "blocked");
        cVarO4.D("protocol", "blackhole");
        aVar3.put(cVarO4);
        if (cVarQuicRefusalOutbound != null) {
            aVar3.put(cVarQuicRefusalOutbound);
        }
        cVarO.D("outbounds", aVar3);
        sf.c cVar5 = new sf.c();
        cVar5.D("tag", "argo-dns");
        sf.a aVar4 = new sf.a();
        sf.c cVar6 = new sf.c();
        cVar6.D("address", "https://8.8.8.8/dns-query");
        aVar4.put(cVar6);
        sf.c cVar7 = new sf.c();
        cVar7.D("address", "https://1.1.1.1/dns-query");
        aVar4.put(cVar7);
        cVar5.D("servers", aVar4);
        cVar5.D("queryStrategy", "UseIPv4");
        cVarO.D("dns", cVar5);
        sf.a aVar5 = new sf.a();
        sf.c cVarP = com.mlmvpn.core.aether.i.p(TeXSymbolParser.TYPE_ATTR, "field", PsiphonProbeService.PORT, "53");
        sf.c cVarO5 = com.mlmvpn.scanner.e.o(cVarP, "outboundTag", "dns-out", aVar5, cVarP);
        cVarO5.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a aVar6 = new sf.a();
        aVar6.put("argo-dns");
        cVarO5.D("inboundTag", aVar6);
        sf.c cVarO6 = com.mlmvpn.scanner.e.o(cVarO5, "outboundTag", WarpIdRelay.VIA_PROXY, aVar5, cVarO5);
        cVarO6.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a aVar7 = new sf.a();
        aVar7.put("geoip:private");
        cVarO6.D("ip", aVar7);
        sf.c cVarO7 = com.mlmvpn.scanner.e.o(cVarO6, "outboundTag", WarpIdRelay.VIA_DIRECT, aVar5, cVarO6);
        cVarO7.D(TeXSymbolParser.TYPE_ATTR, "field");
        cVarO7.D(StudioError.NETWORK, "udp");
        cVarO7.D(PsiphonProbeService.PORT, "443");
        if (cVarQuicRefusalOutbound != null && (strA = cVarQuicRefusalOutbound.A("tag", "")) != null) {
            str2 = strA;
        }
        sf.c cVarO8 = com.mlmvpn.scanner.e.o(cVarO7, "outboundTag", str2, aVar5, cVarO7);
        cVarO8.D("domainStrategy", "AsIs");
        cVarO8.D("rules", aVar5);
        cVarO.D("routing", cVarO8);
        if (cVarQuicRefusalOutbound != null) {
            xrayJsonGenerator.addQuicRefusalPolicyTo(cVarO);
        }
        String string = cVarO.toString();
        j.d(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:48:0x00d3
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final java.lang.Object connect(java.lang.String r27, java.lang.String r28, com.mlmvpn.scanner.engines.argo.ArgoEngine.Mode r29, wd.d r30) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.argo.ArgoEngine.connect(java.lang.String, java.lang.String, com.mlmvpn.scanner.engines.argo.ArgoEngine$Mode, wd.d):java.lang.Object");
    }

    public static /* synthetic */ s1 connectAsync$default(ArgoEngine argoEngine, Context context, String str, String str2, Mode mode, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            mode = null;
        }
        return argoEngine.connectAsync(context, str, str2, mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s1 connectAsync$lambda$1(Context context, Mode mode, String str, String str2) {
        INSTANCE.init(context);
        s1 s1Var = connectJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        s1 s1Var2 = watchJob;
        if (s1Var2 != null) {
            s1Var2.cancel(null);
        }
        wantConnected = true;
        ((g1) _lastWhy).j(null);
        if (mode == null) {
            NetworkSettings networkSettings = NetworkSettings.INSTANCE;
            Context context2 = app;
            if (context2 == null) {
                j.k("app");
                throw null;
            }
            mode = networkSettings.proxyMode(context2) ? Mode.PROXY : Mode.TUNNEL;
        }
        q2 q2VarY = m0.y(scope, null, null, new ArgoEngine$connectAsync$1$1(str, str2, mode, null), 3);
        connectJob = q2VarY;
        return q2VarY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u disconnectAsync$lambda$2(Context context) {
        ArgoEngine argoEngine = INSTANCE;
        argoEngine.init(context);
        wantConnected = false;
        s1 s1Var = connectJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        s1 s1Var2 = watchJob;
        if (s1Var2 != null) {
            s1Var2.cancel(null);
        }
        Live live2 = live;
        live = null;
        ((g1) _lastWhy).j(null);
        ((g1) _conn).j((live2 != null || argoEngine.isOurs()) ? Conn.Stopping.INSTANCE : Conn.Idle.INSTANCE);
        m0.y(scope, null, null, new ArgoEngine$disconnectAsync$1$1(live2, null), 3);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        if (r15 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object launch(String str, Mode mode, wd.d dVar) throws Throwable {
        C03941 c03941;
        if (dVar instanceof C03941) {
            c03941 = (C03941) dVar;
            int i = c03941.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c03941.label = i - TLObject.FLAG_31;
            } else {
                c03941 = new C03941(dVar);
            }
        } else {
            c03941 = new C03941(dVar);
        }
        Object objL = c03941.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c03941.label;
        if (i10 != 0) {
            if (i10 == 1) {
                m.b(objL);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(objL);
            }
            return Boolean.valueOf(((MyVpnService.Phase) objL) == MyVpnService.Phase.CONNECTED);
        }
        m.b(objL);
        boolean z10 = ((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.CONNECTED;
        SafeStart safeStart = SafeStart.INSTANCE;
        Context context = app;
        if (context == null) {
            j.k("app");
            throw null;
        }
        Context context2 = app;
        if (context2 == null) {
            j.k("app");
            throw null;
        }
        Intent intent = new Intent(context2, (Class<?>) MyVpnService.class);
        intent.putExtra("NODE_URI", str);
        intent.putExtra("MTU_PROFILE", NetworkSettings.Method.V2RAY.getId());
        intent.putExtra("NODE_ID", "argo");
        intent.putExtra("PROXY_MODE", mode == Mode.PROXY);
        LocalPort localPort = LocalPort.INSTANCE;
        Context context3 = app;
        if (context3 == null) {
            j.k("app");
            throw null;
        }
        intent.putExtra("LOCAL_PORT", localPort.getString(context3));
        safeStart.service(context, intent);
        if (z10) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
            c03941.label = 1;
            if (m0.L(5000L, anonymousClass3, c03941) != aVar) {
            }
        }
        return aVar;
        ArgoEngine$launch$phase$1 argoEngine$launch$phase$1 = new ArgoEngine$launch$phase$1(new kotlin.jvm.internal.u(), null);
        c03941.label = 2;
        objL = m0.L(GerehWatchdog.STUCK_MS, argoEngine$launch$phase$1, c03941);
    }

    private final void startWatch() {
        s1 s1Var = watchJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        watchJob = m0.y(scope, null, null, new C03951(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopService() {
        if (isOurs()) {
            SafeStart safeStart = SafeStart.INSTANCE;
            Context context = app;
            if (context == null) {
                j.k("app");
                throw null;
            }
            Context context2 = app;
            if (context2 == null) {
                j.k("app");
                throw null;
            }
            Intent intent = new Intent(context2, (Class<?>) MyVpnService.class);
            intent.setAction("STOP");
            safeStart.service(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object trace(wd.d dVar) {
        return m0.J(v0.f24208c, new AnonymousClass2(null), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:62:0x0273  */
    /* JADX WARN: Code duplicated, block: B:64:0x0277  */
    /* JADX WARN: Code duplicated, block: B:67:0x0296  */
    /* JADX WARN: Code duplicated, block: B:70:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:74:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:76:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x02db  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:80:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x0360  */
    /* JADX WARN: Code duplicated, block: B:85:0x036e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0374  */
    /* JADX WARN: Code duplicated, block: B:88:0x037f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0387  */
    /* JADX WARN: Code duplicated, block: B:93:0x03b7  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x022d, code lost:
    
        if (r3 == r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02be, code lost:
    
        if (kotlinx.coroutines.m0.j(1200, r4) == r5) goto L72;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x02be -> B:16:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryOne(ArgoProtocol.Endpoint endpoint, Mode mode, int i, wd.d dVar) throws Throwable {
        C03961 c03961;
        String strCleanIp;
        String str;
        Object obj;
        Mode mode2;
        ArgoEngine argoEngine;
        ArgoNet.Auth auth;
        ArgoProtocol.Endpoint endpoint2;
        int i10;
        String str2;
        Mode mode3;
        ArgoProtocol.SessionInfo sessionInfo;
        ArgoEngine argoEngine2;
        String str3;
        int i11;
        Trace trace;
        Mode mode4;
        String str4;
        String str5;
        ArgoProtocol.SessionInfo sessionInfo2;
        Trace trace2;
        ArgoProtocol.Endpoint endpoint3;
        Mode mode5;
        String loc;
        String strH;
        LocalPort localPort;
        Context context;
        ArgoNet.Auth auth2;
        Object objTrace;
        String str6;
        Mode mode6;
        String str7;
        int i12;
        int i13;
        ArgoProtocol.Endpoint endpoint4 = endpoint;
        int i14 = i;
        if (dVar instanceof C03961) {
            c03961 = (C03961) dVar;
            int i15 = c03961.label;
            if ((i15 & TLObject.FLAG_31) != 0) {
                c03961.label = i15 - TLObject.FLAG_31;
            } else {
                c03961 = new C03961(dVar);
            }
        } else {
            c03961 = new C03961(dVar);
        }
        Object objLaunch = c03961.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i16 = c03961.label;
        if (i16 == 0) {
            m.b(objLaunch);
            strCleanIp = ArgoPool.INSTANCE.cleanIp();
            k0 k0Var = _conn;
            Conn.Connecting connecting = new Conn.Connecting(Step.AUTH, endpoint4.getHost(), endpoint4.getKind(), i14);
            g1 g1Var = (g1) k0Var;
            g1Var.getClass();
            g1Var.k(null, connecting);
            String kind = endpoint4.getKind();
            if (j.a(kind, "falcon")) {
                str = "فالکن";
            } else {
                str = j.a(kind, "public") ? "سرور عمومی" : "پل";
            }
            String host = endpoint4.getHost();
            String strConcat = !o.L0(strCleanIp) ? " از راه آی\u200cپی تمیز ".concat(strCleanIp) : "";
            StringBuilder sbN = s.n("احراز هویت با ", str, " «", host, "»");
            sbN.append(strConcat);
            sbN.append("…");
            log(sbN.toString());
            oe.e eVar = v0.f24208c;
            ArgoEngine$tryOne$a$1 argoEngine$tryOne$a$1 = new ArgoEngine$tryOne$a$1(endpoint4, strCleanIp, null);
            c03961.L$0 = this;
            c03961.L$1 = endpoint4;
            c03961.L$2 = mode;
            c03961.L$3 = strCleanIp;
            c03961.I$0 = i14;
            c03961.label = 1;
            Object objJ = m0.J(eVar, argoEngine$tryOne$a$1, c03961);
            if (objJ != aVar) {
                obj = objJ;
                mode2 = mode;
                argoEngine = this;
            }
            return aVar;
        }
        if (i16 == 1) {
            int i17 = c03961.I$0;
            String str8 = (String) c03961.L$3;
            mode2 = (Mode) c03961.L$2;
            ArgoProtocol.Endpoint endpoint5 = (ArgoProtocol.Endpoint) c03961.L$1;
            argoEngine = (ArgoEngine) c03961.L$0;
            m.b(objLaunch);
            i14 = i17;
            endpoint4 = endpoint5;
            obj = objLaunch;
            strCleanIp = str8;
        } else if (i16 == 2) {
            i10 = c03961.I$0;
            str2 = (String) c03961.L$6;
            sessionInfo = (ArgoProtocol.SessionInfo) c03961.L$5;
            auth = (ArgoNet.Auth) c03961.L$4;
            str3 = (String) c03961.L$3;
            mode3 = (Mode) c03961.L$2;
            endpoint2 = (ArgoProtocol.Endpoint) c03961.L$1;
            argoEngine2 = (ArgoEngine) c03961.L$0;
            m.b(objLaunch);
            c03961.L$0 = argoEngine2;
            c03961.L$1 = endpoint2;
            c03961.L$2 = mode3;
            c03961.L$3 = str3;
            c03961.L$4 = auth;
            c03961.L$5 = sessionInfo;
            c03961.L$6 = str2;
            c03961.I$0 = i10;
            c03961.label = 3;
            objLaunch = argoEngine2.launch(str2, mode3, c03961);
        } else {
            if (i16 == 3) {
                i10 = c03961.I$0;
                str2 = (String) c03961.L$6;
                sessionInfo = (ArgoProtocol.SessionInfo) c03961.L$5;
                auth = (ArgoNet.Auth) c03961.L$4;
                str3 = (String) c03961.L$3;
                mode3 = (Mode) c03961.L$2;
                endpoint2 = (ArgoProtocol.Endpoint) c03961.L$1;
                argoEngine2 = (ArgoEngine) c03961.L$0;
                m.b(objLaunch);
                if (!((Boolean) objLaunch).booleanValue()) {
                    throw new IllegalStateException(((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED ? "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد" : "موتور بالا نیامد");
                }
                k0 k0Var2 = _conn;
                Conn.Connecting connecting2 = new Conn.Connecting(Step.VERIFY, endpoint2.getHost(), endpoint2.getKind(), i10);
                g1 g1Var2 = (g1) k0Var2;
                g1Var2.getClass();
                g1Var2.k(null, connecting2);
                i11 = 0;
                trace = null;
                if (i11 >= 3) {
                    if (wantConnected) {
                        throw new IllegalStateException("لغو شد");
                    }
                    c03961.L$0 = argoEngine2;
                    c03961.L$1 = endpoint2;
                    c03961.L$2 = mode3;
                    c03961.L$3 = str3;
                    c03961.L$4 = auth;
                    c03961.L$5 = sessionInfo;
                    c03961.L$6 = str2;
                    c03961.L$7 = null;
                    c03961.I$0 = i10;
                    c03961.I$1 = i11;
                    c03961.label = 4;
                    objTrace = argoEngine2.trace(c03961);
                    if (objTrace != aVar) {
                        auth2 = auth;
                        str7 = str3;
                        mode6 = mode3;
                        str6 = str2;
                        i12 = i10;
                        i13 = i11;
                        trace2 = (Trace) objTrace;
                        if (trace2 == null) {
                            c03961.L$0 = argoEngine2;
                            c03961.L$1 = endpoint2;
                            c03961.L$2 = mode6;
                            c03961.L$3 = str7;
                            c03961.L$4 = auth2;
                            c03961.L$5 = sessionInfo;
                            c03961.L$6 = str6;
                            c03961.L$7 = trace2;
                            c03961.I$0 = i12;
                            c03961.I$1 = i13;
                            c03961.label = 5;
                        } else {
                            i10 = i12;
                            sessionInfo2 = sessionInfo;
                            str4 = str7;
                            mode4 = mode6;
                            str5 = str6;
                            auth = auth2;
                        }
                    }
                    return aVar;
                }
                trace2 = trace;
                sessionInfo2 = sessionInfo;
                str4 = str3;
                mode4 = mode3;
                str5 = str2;
                endpoint3 = endpoint2;
                if (trace2 == null) {
                    throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");
                }
                k0 k0Var3 = _conn;
                Conn.Connecting connecting3 = new Conn.Connecting(Step.ROUTE, endpoint3.getHost(), endpoint3.getKind(), i10);
                g1 g1Var3 = (g1) k0Var3;
                g1Var3.getClass();
                g1Var3.k(null, connecting3);
                mode5 = mode4;
                live = new Live(endpoint3, sessionInfo2, str4, str5, mode5);
                Conn.Connected connected = new Conn.Connected(endpoint3.getHost(), endpoint3.getKind(), trace2.getLoc(), trace2.getIp(), trace2.getMs(), mode4, false, endpoint3.getId(), 64, null);
                g1Var3.getClass();
                g1Var3.k(null, connected);
                ArgoPool.record$default(ArgoPool.INSTANCE, endpoint3.getId(), true, auth.getMs(), trace2.getLoc(), trace2.getIp(), null, false, str4, 96, null);
                loc = trace2.getLoc();
                if (o.L0(loc)) {
                    loc = "??";
                }
                String ip = trace2.getIp();
                long ms = trace2.getMs();
                if (mode5 == Mode.PROXY) {
                    localPort = LocalPort.INSTANCE;
                    context = app;
                    if (context == null) {
                        j.k("app");
                        throw null;
                    }
                    strH = f0.a.h(localPort.get(context), " — فقط پراکسی محلی 127.0.0.1:");
                } else {
                    strH = " — تونل کامل گوشی";
                }
                StringBuilder sb2 = new StringBuilder("وصل شد — خروج از ");
                sb2.append((Object) loc);
                sb2.append(" (");
                sb2.append(ip);
                sb2.append(")، ");
                com.mlmvpn.core.aether.i.t(ms, " میلی\u200cثانیه", strH, sb2);
                sb2.append(".");
                argoEngine2.log(sb2.toString());
                argoEngine2.startWatch();
                return u.f67154a;
            }
            if (i16 == 4) {
                i13 = c03961.I$1;
                i12 = c03961.I$0;
                String str9 = (String) c03961.L$6;
                ArgoProtocol.SessionInfo sessionInfo3 = (ArgoProtocol.SessionInfo) c03961.L$5;
                ArgoNet.Auth auth3 = (ArgoNet.Auth) c03961.L$4;
                String str10 = (String) c03961.L$3;
                Mode mode7 = (Mode) c03961.L$2;
                ArgoProtocol.Endpoint endpoint6 = (ArgoProtocol.Endpoint) c03961.L$1;
                ArgoEngine argoEngine3 = (ArgoEngine) c03961.L$0;
                m.b(objLaunch);
                str6 = str9;
                sessionInfo = sessionInfo3;
                str7 = str10;
                auth2 = auth3;
                mode6 = mode7;
                endpoint2 = endpoint6;
                argoEngine2 = argoEngine3;
                objTrace = objLaunch;
                trace2 = (Trace) objTrace;
                if (trace2 == null) {
                    c03961.L$0 = argoEngine2;
                    c03961.L$1 = endpoint2;
                    c03961.L$2 = mode6;
                    c03961.L$3 = str7;
                    c03961.L$4 = auth2;
                    c03961.L$5 = sessionInfo;
                    c03961.L$6 = str6;
                    c03961.L$7 = trace2;
                    c03961.I$0 = i12;
                    c03961.I$1 = i13;
                    c03961.label = 5;
                } else {
                    i10 = i12;
                    sessionInfo2 = sessionInfo;
                    str4 = str7;
                    mode4 = mode6;
                    str5 = str6;
                    auth = auth2;
                }
                endpoint3 = endpoint2;
                if (trace2 == null) {
                    throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");
                }
                k0 k0Var4 = _conn;
                Conn.Connecting connecting4 = new Conn.Connecting(Step.ROUTE, endpoint3.getHost(), endpoint3.getKind(), i10);
                g1 g1Var4 = (g1) k0Var4;
                g1Var4.getClass();
                g1Var4.k(null, connecting4);
                mode5 = mode4;
                live = new Live(endpoint3, sessionInfo2, str4, str5, mode5);
                Conn.Connected connected2 = new Conn.Connected(endpoint3.getHost(), endpoint3.getKind(), trace2.getLoc(), trace2.getIp(), trace2.getMs(), mode4, false, endpoint3.getId(), 64, null);
                g1Var4.getClass();
                g1Var4.k(null, connected2);
                ArgoPool.record$default(ArgoPool.INSTANCE, endpoint3.getId(), true, auth.getMs(), trace2.getLoc(), trace2.getIp(), null, false, str4, 96, null);
                loc = trace2.getLoc();
                if (o.L0(loc)) {
                    loc = "??";
                }
                String ip2 = trace2.getIp();
                long ms2 = trace2.getMs();
                if (mode5 == Mode.PROXY) {
                    localPort = LocalPort.INSTANCE;
                    context = app;
                    if (context == null) {
                        j.k("app");
                        throw null;
                    }
                    strH = f0.a.h(localPort.get(context), " — فقط پراکسی محلی 127.0.0.1:");
                } else {
                    strH = " — تونل کامل گوشی";
                }
                StringBuilder sb3 = new StringBuilder("وصل شد — خروج از ");
                sb3.append((Object) loc);
                sb3.append(" (");
                sb3.append(ip2);
                sb3.append(")، ");
                com.mlmvpn.core.aether.i.t(ms2, " میلی\u200cثانیه", strH, sb3);
                sb3.append(".");
                argoEngine2.log(sb3.toString());
                argoEngine2.startWatch();
                return u.f67154a;
            }
            if (i16 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i13 = c03961.I$1;
            i12 = c03961.I$0;
            Trace trace3 = (Trace) c03961.L$7;
            str6 = (String) c03961.L$6;
            ArgoProtocol.SessionInfo sessionInfo4 = (ArgoProtocol.SessionInfo) c03961.L$5;
            auth2 = (ArgoNet.Auth) c03961.L$4;
            str7 = (String) c03961.L$3;
            mode6 = (Mode) c03961.L$2;
            endpoint2 = (ArgoProtocol.Endpoint) c03961.L$1;
            argoEngine2 = (ArgoEngine) c03961.L$0;
            m.b(objLaunch);
            trace2 = trace3;
            sessionInfo = sessionInfo4;
        }
        ArgoEngine argoEngine4 = argoEngine2;
        ArgoProtocol.Endpoint endpoint7 = endpoint2;
        Mode mode8 = mode6;
        str3 = str7;
        auth = auth2;
        trace = trace2;
        i11 = i13 + 1;
        i10 = i12;
        str2 = str6;
        mode3 = mode8;
        endpoint2 = endpoint7;
        argoEngine2 = argoEngine4;
        if (i11 >= 3) {
            if (wantConnected) {
                throw new IllegalStateException("لغو شد");
            }
            c03961.L$0 = argoEngine2;
            c03961.L$1 = endpoint2;
            c03961.L$2 = mode3;
            c03961.L$3 = str3;
            c03961.L$4 = auth;
            c03961.L$5 = sessionInfo;
            c03961.L$6 = str2;
            c03961.L$7 = null;
            c03961.I$0 = i10;
            c03961.I$1 = i11;
            c03961.label = 4;
            objTrace = argoEngine2.trace(c03961);
            if (objTrace != aVar) {
                auth2 = auth;
                str7 = str3;
                mode6 = mode3;
                str6 = str2;
                i12 = i10;
                i13 = i11;
                trace2 = (Trace) objTrace;
                if (trace2 == null) {
                    c03961.L$0 = argoEngine2;
                    c03961.L$1 = endpoint2;
                    c03961.L$2 = mode6;
                    c03961.L$3 = str7;
                    c03961.L$4 = auth2;
                    c03961.L$5 = sessionInfo;
                    c03961.L$6 = str6;
                    c03961.L$7 = trace2;
                    c03961.I$0 = i12;
                    c03961.I$1 = i13;
                    c03961.label = 5;
                } else {
                    i10 = i12;
                    sessionInfo2 = sessionInfo;
                    str4 = str7;
                    mode4 = mode6;
                    str5 = str6;
                    auth = auth2;
                }
            }
            return aVar;
        }
        trace2 = trace;
        sessionInfo2 = sessionInfo;
        str4 = str3;
        mode4 = mode3;
        str5 = str2;
        endpoint3 = endpoint2;
        if (trace2 == null) {
            throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");
        }
        k0 k0Var5 = _conn;
        Conn.Connecting connecting5 = new Conn.Connecting(Step.ROUTE, endpoint3.getHost(), endpoint3.getKind(), i10);
        g1 g1Var5 = (g1) k0Var5;
        g1Var5.getClass();
        g1Var5.k(null, connecting5);
        mode5 = mode4;
        live = new Live(endpoint3, sessionInfo2, str4, str5, mode5);
        Conn.Connected connected3 = new Conn.Connected(endpoint3.getHost(), endpoint3.getKind(), trace2.getLoc(), trace2.getIp(), trace2.getMs(), mode4, false, endpoint3.getId(), 64, null);
        g1Var5.getClass();
        g1Var5.k(null, connected3);
        ArgoPool.record$default(ArgoPool.INSTANCE, endpoint3.getId(), true, auth.getMs(), trace2.getLoc(), trace2.getIp(), null, false, str4, 96, null);
        loc = trace2.getLoc();
        if (o.L0(loc)) {
            loc = "??";
        }
        String ip3 = trace2.getIp();
        long ms3 = trace2.getMs();
        if (mode5 == Mode.PROXY) {
            localPort = LocalPort.INSTANCE;
            context = app;
            if (context == null) {
                j.k("app");
                throw null;
            }
            strH = f0.a.h(localPort.get(context), " — فقط پراکسی محلی 127.0.0.1:");
        } else {
            strH = " — تونل کامل گوشی";
        }
        StringBuilder sb4 = new StringBuilder("وصل شد — خروج از ");
        sb4.append((Object) loc);
        sb4.append(" (");
        sb4.append(ip3);
        sb4.append(")، ");
        com.mlmvpn.core.aether.i.t(ms3, " میلی\u200cثانیه", strH, sb4);
        sb4.append(".");
        argoEngine2.log(sb4.toString());
        argoEngine2.startWatch();
        return u.f67154a;
        auth = (ArgoNet.Auth) obj;
        if (!wantConnected) {
            throw new IllegalStateException("لغو شد");
        }
        ArgoProtocol.SessionInfo info = auth.getInfo();
        if (!auth.getOk() || info == null) {
            String error = auth.getError();
            if (o.L0(error)) {
                error = "احراز هویت نشد";
            }
            throw new IllegalStateException(error);
        }
        argoEngine.log("سرور پذیرفت (" + auth.getMs() + " میلی\u200cثانیه) — مسیر WebSocket «" + info.getWsPath() + "».");
        k0 k0Var6 = _conn;
        Conn.Connecting connecting6 = new Conn.Connecting(Step.ENGINE, endpoint4.getHost(), endpoint4.getKind(), i14);
        g1 g1Var6 = (g1) k0Var6;
        g1Var6.getClass();
        g1Var6.k(null, connecting6);
        String strConfig = argoEngine.config(endpoint4, info, strCleanIp);
        oe.e eVar2 = v0.f24208c;
        C03973 c03973 = new C03973(null);
        c03961.L$0 = argoEngine;
        c03961.L$1 = endpoint4;
        c03961.L$2 = mode2;
        c03961.L$3 = strCleanIp;
        c03961.L$4 = auth;
        c03961.L$5 = info;
        c03961.L$6 = strConfig;
        c03961.I$0 = i14;
        c03961.label = 2;
        if (m0.J(eVar2, c03973, c03961) != aVar) {
            endpoint2 = endpoint4;
            i10 = i14;
            str2 = strConfig;
            mode3 = mode2;
            sessionInfo = info;
            argoEngine2 = argoEngine;
            str3 = strCleanIp;
            c03961.L$0 = argoEngine2;
            c03961.L$1 = endpoint2;
            c03961.L$2 = mode3;
            c03961.L$3 = str3;
            c03961.L$4 = auth;
            c03961.L$5 = sessionInfo;
            c03961.L$6 = str2;
            c03961.I$0 = i10;
            c03961.label = 3;
            objLaunch = argoEngine2.launch(str2, mode3, c03961);
        }
        return aVar;
    }

    public final s1 connectAsync(Context context, String str, String str2, Mode mode) {
        j.e(context, "context");
        return (s1) connectionOwner.replace(null, new a(context, mode, str, str2, 0));
    }

    public final boolean disconnectAsync(final Context context) {
        j.e(context, "context");
        return connectionOwner.stop(null, new ee.a() { // from class: com.mlmvpn.scanner.engines.argo.b
            @Override // ee.a
            public final Object invoke() {
                return ArgoEngine.disconnectAsync$lambda$2(context);
            }
        });
    }

    public final String freshConfig(Context context) {
        j.e(context, "context");
        init(context);
        Live live2 = live;
        if (live2 != null) {
            return live2.getConfig();
        }
        return null;
    }

    public final e1 getConn() {
        return conn;
    }

    public final e1 getLastWhy() {
        return lastWhy;
    }

    public final e1 getLogs() {
        return logs;
    }

    public final void init(Context context) {
        j.e(context, "context");
        if (app != null) {
            return;
        }
        app = context.getApplicationContext();
        ArgoPool argoPool = ArgoPool.INSTANCE;
        Context context2 = app;
        if (context2 != null) {
            argoPool.init(context2);
        } else {
            j.k("app");
            throw null;
        }
    }

    public final boolean isArgoConfig(String str) {
        return j.a(str, REMARKS);
    }

    public final boolean isOurs() {
        return j.a(((g1) MyVpnService.Companion.getConnectedNodeIdFlow()).getValue(), "argo");
    }

    public final void log(String msg) {
        j.e(msg, "msg");
        String strG = d1.g("[", new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()), "] ", msg);
        Log.i(TAG, msg);
        g1 g1Var = (g1) _logs;
        g1Var.j(q.e1(q.S0(m9.d.B(strG), (Iterable) g1Var.getValue()), 300));
    }
}
