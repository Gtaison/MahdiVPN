package com.mlmvpn.scanner.engines.argo;

import a6.w0;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.media3.common.s;
import com.mlmvpn.core.aether.AetherScanService;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.w;
import kotlin.jvm.internal.j;
import kotlin.text.g;
import kotlin.text.i;
import kotlin.text.o;
import kotlinx.coroutines.flow.e1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r2;
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
import sd.l;
import sd.m;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoEngine {
    public static final int $stable = 0;
    public static final ArgoEngine INSTANCE = null;
    public static final String NODE_ID = "argo";
    private static final long OWNER_CHECK_MS = 5000;
    public static final String REMARKS = "mlm-argo-v1";
    private static final String TAG = "ARGO";
    private static final k0 _conn = null;
    private static final k0 _lastWhy = null;
    private static final k0 _logs = null;
    private static Context app;
    private static final e1 conn = null;
    private static s1 connectJob;
    private static final ConnectionOwner connectionOwner = null;
    private static final e1 lastWhy = null;
    private static volatile Live live;
    private static final e1 logs = null;
    private static final i0 scope = null;
    private static volatile boolean wantConnected;
    private static s1 watchJob;

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

            public Connected(String r4, String r8, String r10, String r11, long r12, Mode r13, boolean r14, String r15) {
                j.e(r4, "host");
                j.e(r8, "kind");
                j.e(r10, "exitCc");
                j.e(r11, "exitIp");
                j.e(r13, "mode");
                j.e(r15, XrayCoreHostService.KEY_ID);
                super(null);
                this.host = r4;
                this.kind = r8;
                this.exitCc = r10;
                this.exitIp = r11;
                this.ms = r12;
                this.mode = r13;
                this.lost = r14;
                this.f11197id = r15;
            }

            public static /* synthetic */ Connected copy$default(Connected r4, String r8, String r10, String r11, String r12, long r13, Mode r14, boolean r15, String r16, int r17, Object r18) {
                if ((r17 & 1) == 0) goto L6;
                r8 = r4.host;
            L6:
                if ((r17 & 2) == 0) goto L9;
                r10 = r4.kind;
            L9:
                if ((r17 & 4) == 0) goto L12;
                r11 = r4.exitCc;
            L12:
                if ((r17 & 8) == 0) goto L15;
                r12 = r4.exitIp;
            L15:
                if ((r17 & 16) == 0) goto L18;
                r13 = r4.ms;
            L18:
                if ((r17 & 32) == 0) goto L21;
                r14 = r4.mode;
            L21:
                if ((r17 & 64) == 0) goto L24;
                r15 = r4.lost;
            L24:
                if ((r17 & 128) == 0) goto L26;
                r16 = r4.f11197id;
            L26:
                String r19 = r16;
                Mode r20 = r14;
                long r21 = r13;
                String r22 = r11;
                String r23 = r12;
                String r24 = r8;
                String r25 = r10;
                return r4.copy(r24, r25, r22, r23, r21, r20, r15, r19);
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

            public final Connected copy(String r12, String r13, String r14, String r15, long r16, Mode r18, boolean r19, String r20) {
                j.e(r12, "host");
                j.e(r13, "kind");
                j.e(r14, "exitCc");
                j.e(r15, "exitIp");
                j.e(r18, "mode");
                j.e(r20, XrayCoreHostService.KEY_ID);
                return new Connected(r12, r13, r14, r15, r16, r18, r19, r20);
            }

            public boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof Connected) == true) goto L8;
                return false;
            L8:
                Connected r10 = (Connected) r8;
                if (j.a(this.host, r10.host) == true) goto L12;
                return false;
            L12:
                if (j.a(this.kind, r10.kind) == true) goto L15;
                return false;
            L15:
                if (j.a(this.exitCc, r10.exitCc) == true) goto L18;
                return false;
            L18:
                if (j.a(this.exitIp, r10.exitIp) == true) goto L21;
                return false;
            L21:
                if (this.ms == r10.ms) goto L24;
                return false;
            L24:
                if (this.mode == r10.mode) goto L27;
                return false;
            L27:
                if (this.lost == r10.lost) goto L30;
                return false;
            L30:
                if (j.a(this.f11197id, r10.f11197id) == true) goto L32;
                return false;
            L32:
                return true;
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
                int r4 = w0.c(s.d(s.d(s.d(this.host.hashCode() * 31, 31, this.kind), 31, this.exitCc), 31, this.exitIp), 31, this.ms);
                int r8 = w0.d((this.mode.hashCode() + r4) * 31, 31, this.lost);
                return this.f11197id.hashCode() + r8;
            }

            public String toString() {
                String r4 = this.host;
                String r8 = this.kind;
                String r10 = this.exitCc;
                String r11 = this.exitIp;
                long r12 = this.ms;
                Mode r13 = this.mode;
                boolean r14 = this.lost;
                String r15 = this.f11197id;
                StringBuilder r16 = s.n("Connected(host=", r4, ", kind=", r8, ", exitCc=");
                d1.x(r16, r10, ", exitIp=", r11, ", ms=");
                r16.append(r12);
                r16.append(", mode=");
                r16.append(r13);
                r16.append(", lost=");
                r16.append(r14);
                r16.append(", id=");
                r16.append(r15);
                r16.append(")");
                return r16.toString();
            }

            public /* synthetic */ Connected(String r13, String r14, String r15, String r16, long r17, Mode r19, boolean r20, String r21, int r22, kotlin.jvm.internal.e r23) {
                if ((r22 & 64) == 0) goto L5;
                boolean r10 = false;
            L7:
                if ((r22 & 128) == 0) goto L10;
                String r11 = "";
            L11:
                this(r13, r14, r15, r16, r17, r19, r10, r11);
                return;
            L10:
                r11 = r21;
                goto L11
            L5:
                r10 = r20;
                goto L7
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Connecting extends Conn {
            public static final int $stable = 0;
            private final int attempt;
            private final String host;
            private final String kind;
            private final Step step;

            public Connecting(Step r4, String r8, String r10, int r11) {
                j.e(r4, "step");
                j.e(r8, "host");
                j.e(r10, "kind");
                super(null);
                this.step = r4;
                this.host = r8;
                this.kind = r10;
                this.attempt = r11;
            }

            public static /* synthetic */ Connecting copy$default(Connecting r4, Step r8, String r10, String r11, int r12, int r13, Object r14) {
                if ((r13 & 1) == 0) goto L6;
                r8 = r4.step;
            L6:
                if ((r13 & 2) == 0) goto L9;
                r10 = r4.host;
            L9:
                if ((r13 & 4) == 0) goto L12;
                r11 = r4.kind;
            L12:
                if ((r13 & 8) == 0) goto L15;
                r12 = r4.attempt;
            L15:
                return r4.copy(r8, r10, r11, r12);
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

            public final Connecting copy(Step r4, String r8, String r10, int r11) {
                j.e(r4, "step");
                j.e(r8, "host");
                j.e(r10, "kind");
                return new Connecting(r4, r8, r10, r11);
            }

            public boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof Connecting) == true) goto L8;
                return false;
            L8:
                Connecting r10 = (Connecting) r8;
                if (this.step == r10.step) goto L12;
                return false;
            L12:
                if (j.a(this.host, r10.host) == true) goto L15;
                return false;
            L15:
                if (j.a(this.kind, r10.kind) == true) goto L18;
                return false;
            L18:
                if (this.attempt == r10.attempt) goto L20;
                return false;
            L20:
                return true;
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
                int r4 = s.d(s.d(this.step.hashCode() * 31, 31, this.host), 31, this.kind);
                return Integer.hashCode(this.attempt) + r4;
            }

            public String toString() {
                Step r4 = this.step;
                String r8 = this.host;
                String r10 = this.kind;
                int r11 = this.attempt;
                StringBuilder r12 = new StringBuilder("Connecting(step=");
                r12.append(r4);
                r12.append(", host=");
                r12.append(r8);
                r12.append(", kind=");
                return s.i(r11, r10, ", attempt=", ")", r12);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Failed extends Conn {
            public static final int $stable = 0;
            private final String error;

            public Failed(String r4) {
                j.e(r4, "error");
                super(null);
                this.error = r4;
            }

            public static /* synthetic */ Failed copy$default(Failed r4, String r8, int r10, Object r11) {
                if ((r10 & 1) == 0) goto L6;
                r8 = r4.error;
            L6:
                return r4.copy(r8);
            }

            public final String component1() {
                return this.error;
            }

            public final Failed copy(String r4) {
                j.e(r4, "error");
                return new Failed(r4);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof Failed) == true) goto L9;
                return false;
            L9:
                if (j.a(this.error, ((Failed) r4).error) == true) goto L11;
                return false;
            L11:
                return true;
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
            public static final Idle INSTANCE = null;

            static {
                INSTANCE = new Idle();
            }

            private Idle() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Stopping extends Conn {
            public static final int $stable = 0;
            public static final Stopping INSTANCE = null;

            static {
                INSTANCE = new Stopping();
            }

            private Stopping() {
                super(null);
            }
        }

        public /* synthetic */ Conn(kotlin.jvm.internal.e r4) {
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

        public Live(ArgoProtocol.Endpoint r4, ArgoProtocol.SessionInfo r8, String r10, String r11, Mode r12) {
            j.e(r4, "ep");
            j.e(r8, "info");
            j.e(r10, "connectIp");
            j.e(r11, "config");
            j.e(r12, "mode");
            this.ep = r4;
            this.info = r8;
            this.connectIp = r10;
            this.config = r11;
            this.mode = r12;
        }

        public static /* synthetic */ Live copy$default(Live r4, ArgoProtocol.Endpoint r8, ArgoProtocol.SessionInfo r10, String r11, String r12, Mode r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r8 = r4.ep;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r10 = r4.info;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r11 = r4.connectIp;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r12 = r4.config;
        L15:
            if ((r14 & 16) == 0) goto L17;
            r13 = r4.mode;
        L17:
            String r16 = r12;
            Mode r17 = r13;
            String r18 = r11;
            ArgoProtocol.Endpoint r19 = r8;
            return r4.copy(r19, r10, r18, r16, r17);
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

        public final Live copy(ArgoProtocol.Endpoint r8, ArgoProtocol.SessionInfo r10, String r11, String r12, Mode r13) {
            j.e(r8, "ep");
            j.e(r10, "info");
            j.e(r11, "connectIp");
            j.e(r12, "config");
            j.e(r13, "mode");
            return new Live(r8, r10, r11, r12, r13);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Live) == true) goto L8;
            return false;
        L8:
            Live r10 = (Live) r8;
            if (j.a(this.ep, r10.ep) == true) goto L12;
            return false;
        L12:
            if (j.a(this.info, r10.info) == true) goto L15;
            return false;
        L15:
            if (j.a(this.connectIp, r10.connectIp) == true) goto L18;
            return false;
        L18:
            if (j.a(this.config, r10.config) == true) goto L21;
            return false;
        L21:
            if (this.mode == r10.mode) goto L23;
            return false;
        L23:
            return true;
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
            int r4 = this.ep.hashCode() * 31;
            int r8 = s.d(s.d((this.info.hashCode() + r4) * 31, 31, this.connectIp), 31, this.config);
            return this.mode.hashCode() + r8;
        }

        public String toString() {
            ArgoProtocol.Endpoint r4 = this.ep;
            ArgoProtocol.SessionInfo r8 = this.info;
            String r10 = this.connectIp;
            String r11 = this.config;
            Mode r12 = this.mode;
            StringBuilder r13 = new StringBuilder("Live(ep=");
            r13.append(r4);
            r13.append(", info=");
            r13.append(r8);
            r13.append(", connectIp=");
            d1.x(r13, r10, ", config=", r11, ", mode=");
            r13.append(r12);
            r13.append(")");
            return r13.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ yd.a $ENTRIES = null;
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode PROXY = null;
        public static final Mode TUNNEL = null;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{TUNNEL, PROXY};
        }

        static {
            TUNNEL = new Mode("TUNNEL", 0);
            PROXY = new Mode("PROXY", 1);
            Mode[] r4 = $values();
            $VALUES = r4;
            $ENTRIES = com.google.android.gms.internal.mlkit_language_id_common.j.j(r4);
        }

        private Mode(String r4, int r8) {
            super(r4, r8);
        }

        public static yd.a getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String r4) {
            return (Mode) Enum.valueOf(Mode.class, r4);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final enum Step extends Enum<Step> {
        private static final /* synthetic */ yd.a $ENTRIES = null;
        private static final /* synthetic */ Step[] $VALUES = null;
        public static final Step AUTH = null;
        public static final Step ENGINE = null;
        public static final Step ROUTE = null;
        public static final Step VERIFY = null;

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{AUTH, ENGINE, VERIFY, ROUTE};
        }

        static {
            AUTH = new Step("AUTH", 0);
            ENGINE = new Step("ENGINE", 1);
            VERIFY = new Step("VERIFY", 2);
            ROUTE = new Step("ROUTE", 3);
            Step[] r4 = $values();
            $VALUES = r4;
            $ENTRIES = com.google.android.gms.internal.mlkit_language_id_common.j.j(r4);
        }

        private Step(String r4, int r8) {
            super(r4, r8);
        }

        public static yd.a getEntries() {
            return $ENTRIES;
        }

        public static Step valueOf(String r4) {
            return (Step) Enum.valueOf(Step.class, r4);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        public static final int $stable = 0;
        private final String ip;
        private final String loc;
        private final long ms;

        public Trace(String r4, String r8, long r10) {
            j.e(r4, "loc");
            j.e(r8, "ip");
            this.loc = r4;
            this.ip = r8;
            this.ms = r10;
        }

        public static /* synthetic */ Trace copy$default(Trace r4, String r8, String r10, long r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r8 = r4.loc;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r4.ip;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r4.ms;
        L12:
            return r4.copy(r8, r10, r11);
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

        public final Trace copy(String r4, String r8, long r10) {
            j.e(r4, "loc");
            j.e(r8, "ip");
            return new Trace(r4, r8, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Trace) == true) goto L8;
            return false;
        L8:
            Trace r10 = (Trace) r8;
            if (j.a(this.loc, r10.loc) == true) goto L12;
            return false;
        L12:
            if (j.a(this.ip, r10.ip) == true) goto L15;
            return false;
        L15:
            if (this.ms == r10.ms) goto L17;
            return false;
        L17:
            return true;
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
            int r4 = s.d(this.loc.hashCode() * 31, 31, this.ip);
            return Long.hashCode(this.ms) + r4;
        }

        public String toString() {
            String r4 = this.loc;
            String r8 = this.ip;
            return w0.k(this.ms, ")", s.n("Trace(loc=", r4, ", ip=", r8, ", ms="));
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
        final /* synthetic */ ArgoEngine this$0;

        public AnonymousClass1(ArgoEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.access$connect(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine", f = "ArgoEngine.kt", l = {239, 241}, m = "launch")
    public static final class C03941 extends xd.c {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ArgoEngine this$0;

        public C03941(ArgoEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.access$launch(this.this$0, null, null, this);
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

            public AnonymousClass1(wd.d r4) {
                super(2, r4);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                AnonymousClass1 r10 = new AnonymousClass1(r8);
                r10.L$0 = r4;
                return r10;
            }

            public final Object invoke(MyVpnService.Phase r4, wd.d r8) {
                return ((AnonymousClass1) create(r4, r8)).invokeSuspend(u.f67154a);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r4) {
                kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) goto L11;
                m.b(r4);
                if (((MyVpnService.Phase) this.L$0) == MyVpnService.Phase.CONNECTED) goto L7;
                boolean r10 = true;
            L9:
                return Boolean.valueOf(r10);
            L7:
                r10 = false;
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((MyVpnService.Phase) r4, (wd.d) r8);
            }
        }

        public AnonymousClass3(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new AnonymousClass3(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r10 = this.label;
            if (r10 == 0) goto L9;
            if (r10 != 1) goto L8;
            m.b(r8);
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            m.b(r8);
            k0 r11 = MyVpnService.Companion.getConnectionPhaseFlow();
            AnonymousClass1 r12 = new AnonymousClass1(null);
            this.label = 1;
            Object r13 = h.h(r11, r12, this);
            if (r13 != r4) goto L12;
            return r4;
        L12:
            return r13;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass3) create(r4, r8)).invokeSuspend(u.f67154a);
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

        public C03951(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            C03951 r10 = new C03951(r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e3 -> B:38:0x00e8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01d9 -> B:11:0x0050). Please report as a decompilation issue!!! */
        @Override // xd.a
        public final Object invokeSuspend(Object r34) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            long r10 = 5000;
            long r11 = 0;
            if (r8 == 0) goto L10;
            if (r8 == 1) goto L9;
            if (r8 != 2) goto L8;
            long r12 = this.J$0;
            int r13 = this.I$1;
            int r14 = this.I$0;
            Live r15 = (Live) this.L$1;
            i0 r16 = (i0) this.L$0;
            m.b(r34);
            long r17 = 5000;
            Object r18 = r34;
        L38:
            Trace r19 = (Trace) r18;
            Object r20 = ((g1) ArgoEngine.access$get_conn$p()).getValue();
            if ((r20 instanceof Conn.Connected) == false) goto L41;
            Conn.Connected r21 = (Conn.Connected) r20;
        L42:
            if (r19 == null) goto L50;
            if (r21 != null) goto L45;
        L47:
            if (r21 == null) goto L49;
            ((g1) ArgoEngine.access$get_conn$p()).j(Conn.Connected.copy$default(r21, null, null, r19.getLoc(), r19.getIp(), r19.getMs(), null, false, null, 163, null));
        L49:
            int r22 = 0;
        L57:
            if ((r14 % 10) != 0) goto L67;
            ArgoNet r23 = ArgoNet.INSTANCE;
            String r24 = r15.getEp().getHost();
            int r25 = r15.getEp().getPort();
            ArgoProtocol.SessionInfo r26 = r15.getInfo();
            LocalPort r27 = LocalPort.INSTANCE;
            Context r28 = ArgoEngine.access$getApp$p();
            if (r28 == null) goto L65;
            sd.j r29 = ArgoNet.sessionRequest$default(r23, AetherScanService.EXTRA_KEEPALIVE, r24, r25, r26, r27.get(r28) + LocalPort.PROBE_OFFSET, 0, 32, null);
            boolean r30 = ((Boolean) r29.component1()).booleanValue();
            int r31 = ((Number) r29.component2()).intValue();
            ArgoEngine r32 = ArgoEngine.INSTANCE;
            if (r30 == false) goto L63;
            String r33 = "نشست با سرور تمدید شد.";
        L64:
            r32.log(r33);
            goto L67
        L63:
            r33 = androidx.compose.foundation.interaction.f.o(r31, "تمدید نشست جواب نداد (کد ", ").");
            goto L64
        L65:
            j.k("app");
            throw null;
        L67:
            int r110 = r22;
            i0 r35 = r16;
            r10 = r17;
            r11 = 0;
        L12:
            if (m0.t(r35) == false) goto L70;
            if (ArgoEngine.access$getWantConnected$p() == false) goto L70;
            this.L$0 = r35;
            this.L$1 = null;
            this.I$0 = r14;
            this.I$1 = r110;
            this.J$0 = r12;
            this.label = 1;
            if (m0.j(r10, this) == r4) goto L36;
        L18:
            Live r111 = ArgoEngine.access$getLive$p();
            if (r111 == null) goto L70;
            r17 = r10;
            ArgoEngine r36 = ArgoEngine.INSTANCE;
            if (r36.isOurs() == false) goto L24;
            r12 = r12 + r17;
            if (r12 < 60000) goto L68;
            r14 = r14 + 1;
            this.L$0 = r35;
            this.L$1 = r111;
            this.I$0 = r14;
            this.I$1 = r110;
            this.J$0 = r11;
            this.label = 2;
            r18 = ArgoEngine.access$trace(r36, this);
            if (r18 == r4) goto L36;
            r16 = r35;
            r13 = r110;
            r15 = r111;
            r12 = r11;
            goto L38
        L68:
            r10 = r17;
            goto L12
        L24:
            if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.CONNECTED) goto L26;
            String r37 = "replaced";
        L27:
            ArgoEngine.access$setWantConnected$p(false);
            ArgoEngine.access$setLive$p(null);
            g1 r38 = (g1) ArgoEngine.access$get_lastWhy$p();
            r38.getClass();
            r38.k(null, r37);
            ((g1) ArgoEngine.access$get_conn$p()).j(Conn.Idle.INSTANCE);
            if (r37.equals("replaced") == false) goto L30;
            String r39 = "موتور دیگری VPN را گرفت؛ اتصال آرگو کنار رفت.";
        L31:
            r36.log(r39);
            goto L70
        L30:
            r39 = "موتور متوقف شد؛ اتصال آرگو تمام شد.";
            goto L31
        L26:
            r37 = "stopped";
        L36:
            return r4;
        L70:
            return u.f67154a;
        L45:
            if (r21.getLost() != true) goto L47;
            ArgoEngine.INSTANCE.log("سرور دوباره داده رد می\u200cکند.");
            goto L47
        L50:
            r22 = r13 + 1;
            if (r22 < 2) goto L57;
            if (r21 == null) goto L57;
            if (r21.getLost() == true) goto L57;
            ((g1) ArgoEngine.access$get_conn$p()).j(Conn.Connected.copy$default(r21, null, null, null, null, 0, null, true, null, 191, null));
            ArgoEngine.INSTANCE.log("دو آزمون پیاپی از داخل سرور جواب نداد.");
            goto L57
        L41:
            r21 = null;
            goto L42
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r12 = this.J$0;
            int r40 = this.I$1;
            r14 = this.I$0;
            i0 r112 = (i0) this.L$0;
            m.b(r34);
            r110 = r40;
            r35 = r112;
            goto L18
        L10:
            m.b(r34);
            r35 = (i0) this.L$0;
            r12 = 0;
            r14 = 0;
            r110 = 0;
            goto L12
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C03951) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$trace$2", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            AnonymousClass2 r10 = new AnonymousClass2(r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r12) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L55;
            m.b(r12);
            i0 r13 = (i0) this.L$0;
            OkHttpClient.Builder r8 = new OkHttpClient.Builder();     // Catch: Throwable -> L40
            Proxy.Type r10 = Proxy.Type.HTTP;     // Catch: Throwable -> L40
            LocalPort r11 = LocalPort.INSTANCE;     // Catch: Throwable -> L40
            Context r14 = ArgoEngine.access$getApp$p();     // Catch: Throwable -> L40
            if (r14 == null) goto L46;
            r8.e(new Proxy(r10, new InetSocketAddress(SniSession.LOCAL_HOST, r11.get(r14) + LocalPort.PROBE_OFFSET)));     // Catch: Throwable -> L40
            r8.a(12, TimeUnit.SECONDS);     // Catch: Throwable -> L40
            OkHttpClient r15 = new OkHttpClient(r8);     // Catch: Throwable -> L40
            long r16 = System.nanoTime();     // Catch: Throwable -> L40
            Request.Builder r17 = new Request.Builder();     // Catch: Throwable -> L40
            r17.j("https://www.cloudflare.com/cdn-cgi/trace");     // Catch: Throwable -> L40
            Response r18 = r15.b(new Request(r17)).d();     // Catch: Throwable -> L40
            ResponseBody r19 = r18.f29156h;     // Catch: Throwable -> L12
            if (r19 == null) goto L14;
            String r20 = r19.w();     // Catch: Throwable -> L12
        L15:
            String r21 = "";
            if (r20 != null) goto L19;
            r20 = "";
        L19:
            if (r18.A == true) goto L21;
        L20:
            Trace r22 = null;
        L38:
            r18.close();     // Catch: Throwable -> L40
            Object r23 = l.m1004constructorimpl(r22);     // Catch: Throwable -> L40
        L50:
            if (l.m1010isFailureimpl(r23) == false) goto L53;
            return null;
        L53:
            return r23;
        L21:
            g r24 = kotlin.text.l.find$default(new kotlin.text.l("(?m)^loc=([A-Z]{2})"), r20, 0, 2, null);     // Catch: Throwable -> L12
            if (r24 == null) goto L24;
            String r25 = (String) ((f0) ((i) r24).a()).get(1);     // Catch: Throwable -> L12
        L25:
            if (r25 != null) goto L27;
            r25 = "";
        L27:
            g r26 = kotlin.text.l.find$default(new kotlin.text.l("(?m)^ip=(\\S+)"), r20, 0, 2, null);     // Catch: Throwable -> L12
            if (r26 == null) goto L30;
            String r27 = (String) ((f0) ((i) r26).a()).get(1);     // Catch: Throwable -> L12
        L31:
            if (r27 == null) goto L35;
            r21 = r27;
        L35:
            if (r25.length() == 0) goto L20;
            r22 = new Trace(r25, r21, (System.nanoTime() - r16) / ((long) 1000000));     // Catch: Throwable -> L12
        L30:
            r27 = null;
            goto L31
        L24:
            r25 = null;
            goto L25
        L14:
            r20 = null;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            a.a.g(r18, th);     // Catch: Throwable -> L40
            throw th;     // Catch: Throwable -> L40
        L46:
            j.k("app");     // Catch: Throwable -> L40
            throw null;     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            r23 = l.m1004constructorimpl(m.a(th));
            goto L50
        L55:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass2) create(r4, r8)).invokeSuspend(u.f67154a);
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
        final /* synthetic */ ArgoEngine this$0;

        public C03961(ArgoEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return ArgoEngine.access$tryOne(this.this$0, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$3", f = "ArgoEngine.kt", l = {174}, m = "invokeSuspend")
    public static final class C03973 extends xd.j implements ee.e {
        int label;

        public C03973(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C03973(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            m.b(r4);
        L14:
            return u.f67154a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            m.b(r4);
            TunnelExclusion r11 = TunnelExclusion.INSTANCE;
            Context r12 = ArgoEngine.access$getApp$p();
            if (r12 == null) goto L15;
            this.label = 1;
            if (r11.releaseForXray(r12, this) != r8) goto L14;
            return r8;
        L15:
            j.k("app");
            throw null;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C03973) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    static {
        INSTANCE = new ArgoEngine();
        r2 r4 = m0.b();
        scope = m0.a(g8.a.D(v0.f24208c, r4));
        g1 r8 = h.b(Conn.Idle.INSTANCE);
        _conn = r8;
        conn = r8;
        g1 r10 = h.b(w.INSTANCE);
        _logs = r10;
        logs = r10;
        g1 r11 = h.b(null);
        _lastWhy = r11;
        lastWhy = r11;
        connectionOwner = new ConnectionOwner();
        $stable = 8;
    }

    private ArgoEngine() {
    }

    public static /* synthetic */ u a(Context r4) {
        return disconnectAsync$lambda$2(r4);
    }

    public static final /* synthetic */ Object access$connect(ArgoEngine r4, String r8, String r10, Mode r11, wd.d r12) {
        return r4.connect(r8, r10, r11, r12);
    }

    public static final /* synthetic */ Context access$getApp$p() {
        return app;
    }

    public static final /* synthetic */ Live access$getLive$p() {
        return live;
    }

    public static final /* synthetic */ boolean access$getWantConnected$p() {
        return wantConnected;
    }

    public static final /* synthetic */ k0 access$get_conn$p() {
        return _conn;
    }

    public static final /* synthetic */ k0 access$get_lastWhy$p() {
        return _lastWhy;
    }

    public static final /* synthetic */ Object access$launch(ArgoEngine r4, String r8, Mode r10, wd.d r11) {
        return r4.launch(r8, r10, r11);
    }

    public static final /* synthetic */ void access$setLive$p(Live r4) {
        live = r4;
    }

    public static final /* synthetic */ void access$setWantConnected$p(boolean r4) {
        wantConnected = r4;
    }

    public static final /* synthetic */ void access$stopService(ArgoEngine r4) {
        r4.stopService();
    }

    public static final /* synthetic */ Object access$trace(ArgoEngine r4, wd.d r8) {
        return r4.trace(r8);
    }

    public static final /* synthetic */ Object access$tryOne(ArgoEngine r4, ArgoProtocol.Endpoint r8, Mode r10, int r11, wd.d r12) {
        return r4.tryOne(r8, r10, r11, r12);
    }

    public static /* synthetic */ s1 b(Context r4, Mode r8, String r10, String r11) {
        return connectAsync$lambda$1(r4, r8, r10, r11);
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
    private final String config(ArgoProtocol.Endpoint r20, ArgoProtocol.SessionInfo r21, String r22) {
        LocalPort r4 = LocalPort.INSTANCE;
        Context r8 = app;
        if (r8 == null) goto L18;
        int r10 = r4.get(r8);
        sf.c r11 = com.mlmvpn.core.aether.i.o("remarks", REMARKS);
        sf.c r12 = new sf.c();
        r12.D("loglevel", "warning");
        r11.D(XrayCoreHostService.KEY_LOG, r12);
        sf.a r13 = new sf.a();
        sf.c r14 = com.mlmvpn.core.aether.i.o("tag", "socks");
        com.mlmvpn.scanner.e.q(r10, PsiphonProbeService.PORT, "listen", SniSession.LOCAL_HOST, r14);
        sf.c r15 = com.mlmvpn.scanner.e.n(r14, "protocol", "mixed", "auth", "noauth");
        r15.E("udp", true);
        r14.D("settings", r15);
        sf.c r16 = new sf.c();
        r16.E("enabled", true);
        sf.a r17 = new sf.a();
        r17.put(ExitProxy.HTTP);
        r17.put("tls");
        r16.D("destOverride", r17);
        r14.D("sniffing", r16);
        r13.put(r14);
        sf.c r18 = new sf.c();
        r18.D("tag", ExitProxy.HTTP);
        r18.D(PsiphonProbeService.PORT, Integer.valueOf(r10 + LocalPort.PROBE_OFFSET));
        r18.D("listen", SniSession.LOCAL_HOST);
        r18.D("protocol", ExitProxy.HTTP);
        r13.put(r18);
        r11.D("inbounds", r13);
        XrayJsonGenerator r19 = XrayJsonGenerator.INSTANCE;
        sf.c r23 = r19.quicRefusalOutbound();
        sf.a r24 = new sf.a();
        r24.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, r20, r21, WarpIdRelay.VIA_PROXY, r22, null, 16, null));
        sf.c r25 = new sf.c();
        r25.D("tag", WarpIdRelay.VIA_DIRECT);
        sf.c r26 = com.mlmvpn.scanner.e.o(r25, "protocol", "freedom", r24, r25);
        r26.D("tag", "dns-out");
        sf.c r27 = com.mlmvpn.scanner.e.o(r26, "protocol", "dns", r24, r26);
        String r110 = "blocked";
        r27.D("tag", "blocked");
        r27.D("protocol", "blackhole");
        r24.put(r27);
        if (r23 == null) goto L7;
        r24.put(r23);
    L7:
        r11.D("outbounds", r24);
        sf.c r28 = new sf.c();
        r28.D("tag", "argo-dns");
        sf.a r111 = new sf.a();
        sf.c r112 = new sf.c();
        r112.D("address", "https://8.8.8.8/dns-query");
        r111.put(r112);
        sf.c r113 = new sf.c();
        r113.D("address", "https://1.1.1.1/dns-query");
        r111.put(r113);
        r28.D("servers", r111);
        r28.D("queryStrategy", "UseIPv4");
        r11.D("dns", r28);
        sf.a r29 = new sf.a();
        sf.c r114 = com.mlmvpn.core.aether.i.p(TeXSymbolParser.TYPE_ATTR, "field", PsiphonProbeService.PORT, "53");
        sf.c r30 = com.mlmvpn.scanner.e.o(r114, "outboundTag", "dns-out", r29, r114);
        r30.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a r115 = new sf.a();
        r115.put("argo-dns");
        r30.D("inboundTag", r115);
        sf.c r31 = com.mlmvpn.scanner.e.o(r30, "outboundTag", WarpIdRelay.VIA_PROXY, r29, r30);
        r31.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a r32 = new sf.a();
        r32.put("geoip:private");
        r31.D("ip", r32);
        sf.c r33 = com.mlmvpn.scanner.e.o(r31, "outboundTag", WarpIdRelay.VIA_DIRECT, r29, r31);
        r33.D(TeXSymbolParser.TYPE_ATTR, "field");
        r33.D(StudioError.NETWORK, "udp");
        r33.D(PsiphonProbeService.PORT, "443");
        if (r23 == null) goto L13;
        String r34 = r23.A("tag", "");
        if (r34 == null) goto L13;
        r110 = r34;
    L13:
        sf.c r35 = com.mlmvpn.scanner.e.o(r33, "outboundTag", r110, r29, r33);
        r35.D("domainStrategy", "AsIs");
        r35.D("rules", r29);
        r11.D("routing", r35);
        if (r23 == null) goto L16;
        r19.addQuicRefusalPolicyTo(r11);
    L16:
        String r36 = r11.toString();
        j.d(r36, "toString(...)");
        return r36;
    L18:
        j.k("app");
        throw null;
    }

    private final Object connect(String r27, String r28, Mode r29, wd.d r30) {
        u r4 = u.f67154a;
        if ((r30 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r8 = (AnonymousClass1) r30;
        int r10 = r8.label;
        if ((r10 & TLObject.FLAG_31) == 0) goto L7;
        r8.label = r10 - TLObject.FLAG_31;
        ArgoEngine r11 = this;
    L8:
        Object r12 = r8.result;
        kotlin.coroutines.intrinsics.a r13 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r14 = r8.label;
        if (r14 == 0) goto L20;
        if (r14 != 1) goto L19;
        int r15 = r8.I$0;
        ArgoProtocol.Endpoint r16 = (ArgoProtocol.Endpoint) r8.L$3;
        Iterator r17 = (Iterator) r8.L$2;
        Mode r18 = (Mode) r8.L$1;
        ArgoEngine r19 = (ArgoEngine) r8.L$0;
        m.b(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L62:
        return r4;
    L14:
        th = th;
        int r20 = r15;
        Mode r21 = r18;
    L49:
        String r22 = th.getMessage();
        if (r22 != null) goto L52;
        r22 = "وصل نشد";
    L52:
        r19.log("«" + r16.getHost() + "» وصل نشد: " + r22);
        String r23 = r22;
        ArgoPool.record$default(ArgoPool.INSTANCE, r16.getId(), false, 0, null, null, r23, false, null, 220, null);
        r19.stopService();
        int r24 = r20;
        String r25 = r23;
    L40:
        if (r17.hasNext() == false) goto L55;
        r20 = r24 + 1;
        r16 = (ArgoProtocol.Endpoint) r17.next();
        if (wantConnected == true) goto L60;
        return r4;
    L60:
        r8.L$0 = r19;     // Catch: CancellationException -> L16 Throwable -> L48
        r8.L$1 = r21;     // Catch: CancellationException -> L16 Throwable -> L48
        r8.L$2 = r17;     // Catch: CancellationException -> L16 Throwable -> L48
        r8.L$3 = r16;     // Catch: CancellationException -> L16 Throwable -> L48
        r8.I$0 = r20;     // Catch: CancellationException -> L16 Throwable -> L48
        r8.label = 1;     // Catch: CancellationException -> L16 Throwable -> L48
        if (r19.tryOne(r16, r21, r20, r8) != r13) goto L62;
        return r13;
    L48:
        th = th;
        goto L49
    L67:
        th = th;
        goto L49
    L55:
        if (wantConnected == false) goto L57;
        k0 r26 = _conn;
        Conn.Failed r31 = new Conn.Failed(r25);
        g1 r32 = (g1) r26;
        r32.getClass();
        r32.k(null, r31);
        wantConnected = false;
    L57:
        return r4;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        m.b(r12);
        if (r28 != null) goto L23;
    L26:
        if (r27 != null) goto L28;
    L35:
        List<ArgoProtocol.Endpoint> r33 = ArgoPool.INSTANCE.pick(3);
    L37:
        if (r33.isEmpty() == true) goto L59;
        r21 = r29;
        r17 = r33.iterator();
        r19 = r11;
        r24 = 0;
        r25 = "وصل نشد";
        goto L40
    L59:
        throw new IllegalStateException("هیچ پل یا فالکنی برای اتصال نیست — اول «به\u200cروزرسانی» یا «سنجش» را بزنید");
    L28:
        if (o.L0(r27) == true) goto L35;
        ArgoProtocol.Endpoint r34 = ArgoPool.INSTANCE.get(r27);
        if (r34 == null) goto L34;
        r33 = m9.d.B(r34);
        goto L37
    L34:
        throw new IllegalStateException("این مورد در فهرست نیست");
    L23:
        if (o.L0(r28) == true) goto L26;
        r33 = m9.d.B(ArgoPool.INSTANCE.endpointFromRaw(r28));
    L16:
        e = move-exception;
        throw e;
    L7:
        r11 = this;
        r8 = new AnonymousClass1(r11, r30);
        goto L8
    }

    public static /* synthetic */ s1 connectAsync$default(ArgoEngine r4, Context r8, String r10, String r11, Mode r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 8) == 0) goto L12;
        r12 = null;
    L12:
        return r4.connectAsync(r8, r10, r11, r12);
    }

    private static final s1 connectAsync$lambda$1(Context r4, Mode r8, String r10, String r11) {
        INSTANCE.init(r4);
        s1 r12 = connectJob;
        if (r12 == null) goto L5;
        r12.cancel(null);
    L5:
        s1 r13 = watchJob;
        if (r13 == null) goto L8;
        r13.cancel(null);
    L8:
        wantConnected = true;
        ((g1) _lastWhy).j(null);
        if (r8 != null) goto L18;
        NetworkSettings r14 = NetworkSettings.INSTANCE;
        Context r15 = app;
        if (r15 != null) goto L13;
        j.k("app");
        throw null;
    L13:
        if (r14.proxyMode(r15) == false) goto L15;
        r8 = Mode.PROXY;
        goto L18
    L15:
        r8 = Mode.TUNNEL;
    L18:
        q2 r16 = m0.y(scope, null, null, new ArgoEngine$connectAsync$1$1(r10, r11, r8, null), 3);
        connectJob = r16;
        return r16;
    }

    private static final u disconnectAsync$lambda$2(Context r4) {
        ArgoEngine r8 = INSTANCE;
        r8.init(r4);
        wantConnected = false;
        s1 r10 = connectJob;
        if (r10 == null) goto L5;
        r10.cancel(null);
    L5:
        s1 r11 = watchJob;
        if (r11 == null) goto L8;
        r11.cancel(null);
    L8:
        Live r12 = live;
        live = null;
        ((g1) _lastWhy).j(null);
        k0 r13 = _conn;
        if (r12 == null) goto L11;
    L14:
        Object r14 = Conn.Stopping.INSTANCE;
    L15:
        ((g1) r13).j(r14);
        m0.y(scope, null, null, new ArgoEngine$disconnectAsync$1$1(r12, null), 3);
        return u.f67154a;
    L11:
        if (r8.isOurs() == true) goto L14;
        r14 = Conn.Idle.INSTANCE;
        goto L15
    }

    private final Object launch(String r13, Mode r14, wd.d r15) {
        if ((r15 instanceof C03941) == false) goto L7;
        C03941 r4 = (C03941) r15;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
    L8:
        Object r16 = r4.result;
        kotlin.coroutines.intrinsics.a r10 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r11 = r4.label;
        boolean r12 = false;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L14;
        m.b(r16);
    L39:
        if (((MyVpnService.Phase) r16) != MyVpnService.Phase.CONNECTED) goto L42;
        r12 = true;
    L42:
        return Boolean.valueOf(r12);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        m.b(r16);
    L35:
        ArgoEngine$launch$phase$1 r17 = new ArgoEngine$launch$phase$1(new kotlin.jvm.internal.u(), null);
        r4.label = 2;
        r16 = m0.L(GerehWatchdog.STUCK_MS, r17, r4);
        if (r16 != r10) goto L39;
    L37:
        return r10;
    L16:
        m.b(r16);
        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.CONNECTED) goto L19;
        boolean r18 = true;
    L20:
        SafeStart r19 = SafeStart.INSTANCE;
        Context r20 = app;
        if (r20 == null) goto L47;
        Context r110 = app;
        if (r110 == null) goto L45;
        Intent r21 = new Intent(r110, MyVpnService.class);
        r21.putExtra("NODE_URI", r13);
        r21.putExtra("MTU_PROFILE", NetworkSettings.Method.V2RAY.getId());
        r21.putExtra("NODE_ID", "argo");
        if (r14 != Mode.PROXY) goto L27;
        boolean r111 = true;
    L28:
        r21.putExtra("PROXY_MODE", r111);
        LocalPort r112 = LocalPort.INSTANCE;
        Context r113 = app;
        if (r113 == null) goto L43;
        r21.putExtra("LOCAL_PORT", r112.getString(r113));
        r19.service(r20, r21);
        if (r18 == false) goto L35;
        AnonymousClass3 r114 = new AnonymousClass3(null);
        r4.label = 1;
        if (m0.L(5000, r114, r4) != r10) goto L35;
    L43:
        j.k("app");
        throw null;
    L27:
        r111 = false;
        goto L28
    L45:
        j.k("app");
        throw null;
    L47:
        j.k("app");
        throw null;
    L19:
        r18 = false;
    L7:
        r4 = new C03941(this, r15);
        goto L8
    }

    private final void startWatch() {
        s1 r4 = watchJob;
        if (r4 == null) goto L5;
        r4.cancel(null);
    L5:
        watchJob = m0.y(scope, null, null, new C03951(null), 3);
    }

    private final void stopService() {
        if (isOurs() == false) goto L14;
        SafeStart r4 = SafeStart.INSTANCE;
        Context r8 = app;
        if (r8 == null) goto L12;
        Context r10 = app;
        if (r10 == null) goto L10;
        Intent r11 = new Intent(r10, MyVpnService.class);
        r11.setAction("STOP");
        r4.service(r8, r11);
        return;
    L10:
        j.k("app");
        throw null;
    L12:
        j.k("app");
        throw null;
    }

    private final Object trace(wd.d r4) {
        return m0.J(v0.f24208c, new AnonymousClass2(null), r4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x02be -> B:16:0x0064). Please report as a decompilation issue!!! */
    private final Object tryOne(ArgoProtocol.Endpoint r42, Mode r43, int r44, wd.d r45) {
        ArgoProtocol.Endpoint r4 = r42;
        int r8 = r44;
        if ((r45 instanceof C03961) == false) goto L7;
        C03961 r10 = (C03961) r45;
        int r11 = r10.label;
        if ((r11 & TLObject.FLAG_31) == 0) goto L7;
        r10.label = r11 - TLObject.FLAG_31;
    L8:
        Object r12 = r10.result;
        kotlin.coroutines.intrinsics.a r13 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r14 = r10.label;
        if (r14 == 0) goto L23;
        if (r14 == 1) goto L22;
        if (r14 == 2) goto L21;
        if (r14 == 3) goto L20;
        if (r14 == 4) goto L19;
        if (r14 != 5) goto L18;
        int r15 = r10.I$1;
        int r16 = r10.I$0;
        Trace r17 = (Trace) r10.L$7;
        String r18 = (String) r10.L$6;
        ArgoProtocol.SessionInfo r19 = (ArgoProtocol.SessionInfo) r10.L$5;
        ArgoNet.Auth r110 = (ArgoNet.Auth) r10.L$4;
        String r20 = (String) r10.L$3;
        Mode r21 = (Mode) r10.L$2;
        ArgoProtocol.Endpoint r111 = (ArgoProtocol.Endpoint) r10.L$1;
        ArgoEngine r112 = (ArgoEngine) r10.L$0;
        m.b(r12);
        Trace r22 = r17;
        ArgoProtocol.SessionInfo r23 = r19;
    L16:
        ArgoEngine r113 = r112;
        ArgoProtocol.Endpoint r114 = r111;
        Mode r115 = r21;
        String r24 = r20;
        ArgoNet.Auth r25 = r110;
        Trace r26 = r22;
        int r27 = r15 + 1;
        int r28 = r16;
        String r29 = r18;
        Mode r116 = r115;
        r111 = r114;
        r112 = r113;
    L61:
        if (r27 < 3) goto L63;
        r22 = r26;
        ArgoProtocol.SessionInfo r30 = r23;
        String r210 = r24;
        Mode r35 = r116;
        String r31 = r29;
    L75:
        ArgoProtocol.Endpoint r32 = r111;
        if (r22 == null) goto L94;
        k0 r33 = _conn;
        Conn.Connecting r34 = new Conn.Connecting(Step.ROUTE, r32.getHost(), r32.getKind(), r28);
        g1 r36 = (g1) r33;
        r36.getClass();
        r36.k(null, r34);
        Mode r37 = r35;
        live = new Live(r32, r30, r210, r31, r37);
        Conn.Connected r211 = new Conn.Connected(r32.getHost(), r32.getKind(), r22.getLoc(), r22.getIp(), r22.getMs(), r35, false, r32.getId(), 64, null);
        r36.getClass();
        r36.k(null, r211);
        ArgoPool.record$default(ArgoPool.INSTANCE, r32.getId(), true, r25.getMs(), r22.getLoc(), r22.getIp(), null, false, r210, 96, null);
        String r38 = r22.getLoc();
        if (o.L0(r38) == false) goto L83;
        r38 = "??";
    L83:
        String r39 = r22.getIp();
        long r40 = r22.getMs();
        if (r37 != Mode.PROXY) goto L90;
        LocalPort r41 = LocalPort.INSTANCE;
        Context r46 = app;
        if (r46 == null) goto L88;
        String r47 = f0.a.h(r41.get(r46), " — فقط پراکسی محلی 127.0.0.1:");
    L91:
        StringBuilder r48 = new StringBuilder("وصل شد — خروج از ");
        r48.append(r38);
        r48.append(" (");
        r48.append(r39);
        r48.append(")، ");
        com.mlmvpn.core.aether.i.t(r40, " میلی\u200cثانیه", r47, r48);
        r48.append(".");
        r112.log(r48.toString());
        r112.startWatch();
        return u.f67154a;
    L88:
        j.k("app");
        throw null;
    L90:
        r47 = " — تونل کامل گوشی";
        goto L91
    L94:
        throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");
    L63:
        if (wantConnected == false) goto L77;
        r10.L$0 = r112;
        r10.L$1 = r111;
        r10.L$2 = r116;
        r10.L$3 = r24;
        r10.L$4 = r25;
        r10.L$5 = r23;
        r10.L$6 = r29;
        r10.L$7 = null;
        r10.I$0 = r28;
        r10.I$1 = r27;
        r10.label = 4;
        Object r117 = r112.trace(r10);
        if (r117 == r13) goto L72;
        r110 = r25;
        r20 = r24;
        r21 = r116;
        r18 = r29;
        r16 = r28;
        r15 = r27;
    L68:
        r22 = (Trace) r117;
        if (r22 != null) goto L74;
        r10.L$0 = r112;
        r10.L$1 = r111;
        r10.L$2 = r21;
        r10.L$3 = r20;
        r10.L$4 = r110;
        r10.L$5 = r23;
        r10.L$6 = r18;
        r10.L$7 = r22;
        r10.I$0 = r16;
        r10.I$1 = r15;
        r10.label = 5;
        if (m0.j(1200, r10) != r13) goto L16;
    L74:
        r28 = r16;
        r30 = r23;
        r210 = r20;
        r35 = r21;
        r31 = r18;
        r25 = r110;
    L72:
        return r13;
    L77:
        throw new IllegalStateException("لغو شد");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r15 = r10.I$1;
        r16 = r10.I$0;
        String r49 = (String) r10.L$6;
        ArgoProtocol.SessionInfo r50 = (ArgoProtocol.SessionInfo) r10.L$5;
        ArgoNet.Auth r51 = (ArgoNet.Auth) r10.L$4;
        String r118 = (String) r10.L$3;
        Mode r119 = (Mode) r10.L$2;
        ArgoProtocol.Endpoint r120 = (ArgoProtocol.Endpoint) r10.L$1;
        ArgoEngine r121 = (ArgoEngine) r10.L$0;
        m.b(r12);
        r18 = r49;
        r23 = r50;
        r20 = r118;
        r110 = r51;
        r21 = r119;
        r111 = r120;
        r112 = r121;
        r117 = r12;
        goto L68
    L20:
        r28 = r10.I$0;
        r29 = (String) r10.L$6;
        r23 = (ArgoProtocol.SessionInfo) r10.L$5;
        r25 = (ArgoNet.Auth) r10.L$4;
        r24 = (String) r10.L$3;
        r116 = (Mode) r10.L$2;
        r111 = (ArgoProtocol.Endpoint) r10.L$1;
        r112 = (ArgoEngine) r10.L$0;
        m.b(r12);
    L52:
        if (((Boolean) r12).booleanValue() == false) goto L54;
        k0 r52 = _conn;
        Conn.Connecting r122 = new Conn.Connecting(Step.VERIFY, r111.getHost(), r111.getKind(), r28);
        g1 r53 = (g1) r52;
        r53.getClass();
        r53.k(null, r122);
        r27 = 0;
        r26 = null;
        goto L61
    L54:
        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.FAILED) goto L56;
        String r54 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
    L58:
        throw new IllegalStateException(r54);
    L56:
        r54 = "موتور بالا نیامد";
        goto L58
    L21:
        r28 = r10.I$0;
        r29 = (String) r10.L$6;
        r23 = (ArgoProtocol.SessionInfo) r10.L$5;
        r25 = (ArgoNet.Auth) r10.L$4;
        r24 = (String) r10.L$3;
        r116 = (Mode) r10.L$2;
        r111 = (ArgoProtocol.Endpoint) r10.L$1;
        r112 = (ArgoEngine) r10.L$0;
        m.b(r12);
    L48:
        r10.L$0 = r112;
        r10.L$1 = r111;
        r10.L$2 = r116;
        r10.L$3 = r24;
        r10.L$4 = r25;
        r10.L$5 = r23;
        r10.L$6 = r29;
        r10.I$0 = r28;
        r10.label = 3;
        r12 = r112.launch(r29, r116, r10);
        if (r12 != r13) goto L52;
    L22:
        int r55 = r10.I$0;
        String r56 = (String) r10.L$3;
        Mode r57 = (Mode) r10.L$2;
        ArgoProtocol.Endpoint r58 = (ArgoProtocol.Endpoint) r10.L$1;
        ArgoEngine r59 = (ArgoEngine) r10.L$0;
        m.b(r12);
        r8 = r55;
        r4 = r58;
        Object r60 = r12;
        String r61 = r56;
    L38:
        r25 = (ArgoNet.Auth) r60;
        if (wantConnected == false) goto L101;
        ArgoProtocol.SessionInfo r123 = r25.getInfo();
        if (r25.getOk() == false) goto L95;
        if (r123 == null) goto L95;
        r59.log("سرور پذیرفت (" + r25.getMs() + " میلی\u200cثانیه) — مسیر WebSocket «" + r123.getWsPath() + "».");
        k0 r124 = _conn;
        Conn.Connecting r125 = new Conn.Connecting(Step.ENGINE, r4.getHost(), r4.getKind(), r8);
        g1 r126 = (g1) r124;
        r126.getClass();
        r126.k(null, r125);
        String r127 = r59.config(r4, r123, r61);
        oe.e r128 = v0.f24208c;
        C03973 r129 = new C03973(null);
        r10.L$0 = r59;
        r10.L$1 = r4;
        r10.L$2 = r57;
        r10.L$3 = r61;
        r10.L$4 = r25;
        r10.L$5 = r123;
        r10.L$6 = r127;
        r10.I$0 = r8;
        r10.label = 2;
        if (m0.J(r128, r129, r10) == r13) goto L72;
        r111 = r4;
        r28 = r8;
        r29 = r127;
        r116 = r57;
        r23 = r123;
        r112 = r59;
        r24 = r61;
    L95:
        String r62 = r25.getError();
        if (o.L0(r62) == false) goto L99;
        r62 = "احراز هویت نشد";
    L99:
        throw new IllegalStateException(r62);
    L101:
        throw new IllegalStateException("لغو شد");
    L23:
        m.b(r12);
        r61 = ArgoPool.INSTANCE.cleanIp();
        k0 r63 = _conn;
        Conn.Connecting r64 = new Conn.Connecting(Step.AUTH, r4.getHost(), r4.getKind(), r8);
        g1 r65 = (g1) r63;
        r65.getClass();
        r65.k(null, r64);
        String r66 = r4.getKind();
        if (j.a(r66, "falcon") == false) goto L27;
        String r67 = "فالکن";
    L30:
        String r68 = r4.getHost();
        if (o.L0(r61) == true) goto L33;
        String r69 = " از راه آی\u200cپی تمیز ".concat(r61);
    L34:
        StringBuilder r70 = s.n("احراز هویت با ", r67, " «", r68, "»");
        r70.append(r69);
        r70.append("…");
        log(r70.toString());
        oe.e r71 = v0.f24208c;
        ArgoEngine$tryOne$a$1 r72 = new ArgoEngine$tryOne$a$1(r4, r61, null);
        r10.L$0 = this;
        r10.L$1 = r4;
        r10.L$2 = r43;
        r10.L$3 = r61;
        r10.I$0 = r8;
        r10.label = 1;
        Object r73 = m0.J(r71, r72, r10);
        if (r73 == r13) goto L72;
        r60 = r73;
        r57 = r43;
        r59 = this;
        goto L38
    L33:
        r69 = "";
        goto L34
    L27:
        if (j.a(r66, "public") == false) goto L29;
        r67 = "سرور عمومی";
        goto L30
    L29:
        r67 = "پل";
    L7:
        r10 = new C03961(this, r45);
        goto L8
    }

    public final s1 connectAsync(Context r8, String r10, String r11, Mode r12) {
        j.e(r8, "context");
        return (s1) connectionOwner.replace(null, new a(r8, r12, r10, r11, 0));
    }

    public final boolean disconnectAsync(Context r4) {
        j.e(r4, "context");
        return connectionOwner.stop(null, new b(r4));
    }

    public final String freshConfig(Context r4) {
        j.e(r4, "context");
        init(r4);
        Live r8 = live;
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getConfig();
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

    public final void init(Context r4) {
        j.e(r4, "context");
        if (app == null) goto L5;
        return;
    L5:
        app = r4.getApplicationContext();
        ArgoPool r8 = ArgoPool.INSTANCE;
        Context r10 = app;
        if (r10 == null) goto L9;
        r8.init(r10);
        return;
    L9:
        j.k("app");
        throw null;
    }

    public final boolean isArgoConfig(String r4) {
        return j.a(r4, REMARKS);
    }

    public final boolean isOurs() {
        return j.a(((g1) MyVpnService.Companion.getConnectedNodeIdFlow()).getValue(), "argo");
    }

    public final void log(String r4) {
        j.e(r4, "msg");
        String r8 = d1.g("[", new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()), "] ", r4);
        Log.i(TAG, r4);
        k0 r10 = _logs;
        g1 r11 = (g1) r10;
        r11.j(q.e1(q.S0(m9.d.B(r8), (Iterable) r11.getValue()), 300));
    }
}
