package com.mlmvpn.scanner.engines.argo;

import a6.w0;
import android.content.Context;
import android.util.Log;
import androidx.media3.common.s;
import com.mlmvpn.core.aether.i;
import com.mlmvpn.core.tunnel.TunnelStatus;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.AwgProbeService;
import com.mlmvpn.core.warp.VlessXrayInjector;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.core.warp.XrayMeasureService;
import com.mlmvpn.scanner.MyVpnService;
import com.mlmvpn.scanner.engines.proton.ProtonStealth;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.ui.settings.SettingsSpotlight;
import com.mlmvpn.scanner.utils.LocalPort;
import com.mlmvpn.scanner.utils.NetworkSettings;
import j$.time.Instant;
import j$.time.OffsetDateTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import je.g;
import je.h;
import kotlin.collections.d0;
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.y;
import kotlin.text.l;
import kotlin.text.o;
import kotlin.text.v;
import kotlinx.coroutines.flow.e1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.v0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.mlmvpn.chat.bridge.GerehWatchdog;
import org.scilab.forge.jlatexmath.TeXSymbolParser;
import org.telegram.messenger.MediaDataController;
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import psi.Psi;
import sd.m;
import sd.u;
import x6.p;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoPool {
    public static final int $stable = 0;
    private static final String ASSET = "argo/argo-pool.json";
    private static final List<Source> BUILTIN = null;
    private static final String CARRY_UA = null;
    private static final long CARRY_UA_FIXED_AT = 1794063600000L;
    private static final String CARRY_URL = "https://cachefly.cachefly.net/1mb.test";
    private static final List<String> CF_V4 = null;
    private static final List<String> CF_V6 = null;
    public static final ArgoPool INSTANCE = null;
    private static final l IPV4_LITERAL = null;
    private static final String TAG = "ARGO";
    private static final int TEST_BATCH = 12;
    private static final String TRACE_URL = "https://www.cloudflare.com/cdn-cgi/trace";
    private static final k0 _version = null;
    private static Context app;
    private static long bundleBuilt;
    private static sf.c cleanScan;
    private static File dir;
    private static List<ArgoProtocol.FalconOrigin> falconServers;
    private static volatile IpScan ipScan;
    private static final LinkedHashMap<String, Item> items = null;
    private static boolean loaded;
    private static Prefs prefs;
    private static final SecureRandom random = null;
    private static final HashMap<String, Result> results = null;
    private static volatile boolean saveQueued;
    private static volatile boolean scanCancel;
    private static final i0 scope = null;
    private static final HashMap<String, sf.c> sourceState = null;
    private static volatile boolean testCancel;
    private static volatile Job testJob;
    private static volatile boolean updateCancel;
    private static volatile Job updateJob;
    private static final List<Source> userSources = null;
    private static final e1 version = null;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Absorbed {
        public static final int $stable = 0;
        private final int bad;
        private final int bridges;
        private final int falcons;

        public Absorbed(int r4, int r8, int r10) {
            this.bridges = r4;
            this.falcons = r8;
            this.bad = r10;
        }

        public static /* synthetic */ Absorbed copy$default(Absorbed r4, int r8, int r10, int r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r8 = r4.bridges;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r4.falcons;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r4.bad;
        L12:
            return r4.copy(r8, r10, r11);
        }

        public final int component1() {
            return this.bridges;
        }

        public final int component2() {
            return this.falcons;
        }

        public final int component3() {
            return this.bad;
        }

        public final Absorbed copy(int r4, int r8, int r10) {
            return new Absorbed(r4, r8, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Absorbed) == true) goto L8;
            return false;
        L8:
            Absorbed r10 = (Absorbed) r8;
            if (this.bridges == r10.bridges) goto L12;
            return false;
        L12:
            if (this.falcons == r10.falcons) goto L15;
            return false;
        L15:
            if (this.bad == r10.bad) goto L17;
            return false;
        L17:
            return true;
        }

        public final int getBad() {
            return this.bad;
        }

        public final int getBridges() {
            return this.bridges;
        }

        public final int getFalcons() {
            return this.falcons;
        }

        public int hashCode() {
            int r4 = Integer.hashCode(this.bridges) * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.falcons, r4, 31);
            return Integer.hashCode(this.bad) + r8;
        }

        public String toString() {
            int r4 = this.bridges;
            int r8 = this.falcons;
            int r10 = this.bad;
            return w0.q(androidx.compose.foundation.interaction.f.u("Absorbed(bridges=", r4, ", falcons=", r8, ", bad="), r10, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class CleanIp {
        public static final int $stable = 0;
        private final long auth;
        private final String ip;
        private final long kbps;
        private final String loc;
        private final long tls;

        public CleanIp(String r4, long r8, long r10, long r11, String r12) {
            j.e(r4, "ip");
            j.e(r12, "loc");
            this.ip = r4;
            this.tls = r8;
            this.auth = r10;
            this.kbps = r11;
            this.loc = r12;
        }

        public static /* synthetic */ CleanIp copy$default(CleanIp r4, String r8, long r10, long r11, long r12, String r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r8 = r4.ip;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r10 = r4.tls;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r11 = r4.auth;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r12 = r4.kbps;
        L15:
            if ((r14 & 16) == 0) goto L17;
            r13 = r4.loc;
        L17:
            String r16 = r13;
            long r17 = r12;
            long r18 = r11;
            String r19 = r8;
            return r4.copy(r19, r10, r18, r17, r16);
        }

        public final String component1() {
            return this.ip;
        }

        public final long component2() {
            return this.tls;
        }

        public final long component3() {
            return this.auth;
        }

        public final long component4() {
            return this.kbps;
        }

        public final String component5() {
            return this.loc;
        }

        public final CleanIp copy(String r11, long r12, long r14, long r16, String r18) {
            j.e(r11, "ip");
            j.e(r18, "loc");
            return new CleanIp(r11, r12, r14, r16, r18);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof CleanIp) == true) goto L8;
            return false;
        L8:
            CleanIp r10 = (CleanIp) r8;
            if (j.a(this.ip, r10.ip) == true) goto L12;
            return false;
        L12:
            if (this.tls == r10.tls) goto L15;
            return false;
        L15:
            if (this.auth == r10.auth) goto L18;
            return false;
        L18:
            if (this.kbps == r10.kbps) goto L21;
            return false;
        L21:
            if (j.a(this.loc, r10.loc) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final long getAuth() {
            return this.auth;
        }

        public final String getIp() {
            return this.ip;
        }

        public final long getKbps() {
            return this.kbps;
        }

        public final String getLoc() {
            return this.loc;
        }

        public final long getTls() {
            return this.tls;
        }

        public int hashCode() {
            int r4 = w0.c(w0.c(w0.c(this.ip.hashCode() * 31, 31, this.tls), 31, this.auth), 31, this.kbps);
            return this.loc.hashCode() + r4;
        }

        public String toString() {
            String r4 = this.ip;
            long r8 = this.tls;
            long r10 = this.auth;
            long r11 = this.kbps;
            String r12 = this.loc;
            StringBuilder r13 = s.m("CleanIp(ip=", r4, ", tls=", r8);
            v0.a.k(r10, ", auth=", ", kbps=", r13);
            i.t(r11, ", loc=", r12, r13);
            r13.append(")");
            return r13.toString();
        }

        public /* synthetic */ CleanIp(String r11, long r12, long r14, long r16, String r18, int r19, kotlin.jvm.internal.e r20) {
            if ((r19 & 16) == 0) goto L6;
            String r10 = "";
        L7:
            this(r11, r12, r14, r16, r10);
            return;
        L6:
            r10 = r18;
            goto L7
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

        public Counts(int r4, int r8, int r10, int r11, int r12, int r13, int r14, long r15) {
            this.bridge = r4;
            this.falcon = r8;
            this.f2public = r10;
            this.total = r11;
            this.alive = r12;
            this.tested = r13;
            this.verified = r14;
            this.verifiedAt = r15;
        }

        public static /* synthetic */ Counts copy$default(Counts r4, int r8, int r10, int r11, int r12, int r13, int r14, int r15, long r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r8 = r4.bridge;
        L6:
            if ((r17 & 2) == 0) goto L9;
            r10 = r4.falcon;
        L9:
            if ((r17 & 4) == 0) goto L12;
            r11 = r4.f2public;
        L12:
            if ((r17 & 8) == 0) goto L15;
            r12 = r4.total;
        L15:
            if ((r17 & 16) == 0) goto L18;
            r13 = r4.alive;
        L18:
            if ((r17 & 32) == 0) goto L21;
            r14 = r4.tested;
        L21:
            if ((r17 & 64) == 0) goto L24;
            r15 = r4.verified;
        L24:
            if ((r17 & 128) == 0) goto L26;
            r16 = r4.verifiedAt;
        L26:
            long r19 = r16;
            int r20 = r14;
            int r21 = r15;
            int r22 = r12;
            int r23 = r13;
            int r24 = r11;
            int r25 = r8;
            return r4.copy(r25, r10, r24, r22, r23, r20, r21, r19);
        }

        public final int component1() {
            return this.bridge;
        }

        public final int component2() {
            return this.falcon;
        }

        public final int component3() {
            return this.f2public;
        }

        public final int component4() {
            return this.total;
        }

        public final int component5() {
            return this.alive;
        }

        public final int component6() {
            return this.tested;
        }

        public final int component7() {
            return this.verified;
        }

        public final long component8() {
            return this.verifiedAt;
        }

        public final Counts copy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, long r18) {
            return new Counts(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Counts) == true) goto L8;
            return false;
        L8:
            Counts r10 = (Counts) r8;
            if (this.bridge == r10.bridge) goto L12;
            return false;
        L12:
            if (this.falcon == r10.falcon) goto L15;
            return false;
        L15:
            if (this.f2public == r10.f2public) goto L18;
            return false;
        L18:
            if (this.total == r10.total) goto L21;
            return false;
        L21:
            if (this.alive == r10.alive) goto L24;
            return false;
        L24:
            if (this.tested == r10.tested) goto L27;
            return false;
        L27:
            if (this.verified == r10.verified) goto L30;
            return false;
        L30:
            if (this.verifiedAt == r10.verifiedAt) goto L32;
            return false;
        L32:
            return true;
        }

        public final int getAlive() {
            return this.alive;
        }

        public final int getBridge() {
            return this.bridge;
        }

        public final int getFalcon() {
            return this.falcon;
        }

        public final int getPublic() {
            return this.f2public;
        }

        public final int getTested() {
            return this.tested;
        }

        public final int getTotal() {
            return this.total;
        }

        public final int getVerified() {
            return this.verified;
        }

        public final long getVerifiedAt() {
            return this.verifiedAt;
        }

        public int hashCode() {
            int r4 = Integer.hashCode(this.bridge) * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.falcon, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.f2public, r8, 31);
            int r11 = androidx.compose.foundation.interaction.f.c(this.total, r10, 31);
            int r12 = androidx.compose.foundation.interaction.f.c(this.alive, r11, 31);
            int r13 = androidx.compose.foundation.interaction.f.c(this.tested, r12, 31);
            int r14 = androidx.compose.foundation.interaction.f.c(this.verified, r13, 31);
            return Long.hashCode(this.verifiedAt) + r14;
        }

        public String toString() {
            int r4 = this.bridge;
            int r8 = this.falcon;
            int r10 = this.f2public;
            int r11 = this.total;
            int r12 = this.alive;
            int r13 = this.tested;
            int r14 = this.verified;
            long r15 = this.verifiedAt;
            StringBuilder r16 = androidx.compose.foundation.interaction.f.u("Counts(bridge=", r4, ", falcon=", r8, ", public=");
            s.v(r16, r10, ", total=", r11, ", alive=");
            s.v(r16, r12, ", tested=", r13, ", verified=");
            i.r(r14, r15, ", verifiedAt=", r16);
            r16.append(")");
            return r16.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Group {
        public static final int $stable = 8;
        private int alive;
        private Long best;
        private int bridge;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11198cc;
        private int falcon;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f11199n;

        /* JADX INFO: renamed from: public, reason: not valid java name */
        private int f3public;

        public Group(String r4, int r8, int r10, Long r11, int r12, int r13, int r14) {
            j.e(r4, AwgProbeService.KEY_COUNTRY);
            this.f11198cc = r4;
            this.f11199n = r8;
            this.alive = r10;
            this.best = r11;
            this.bridge = r12;
            this.falcon = r13;
            this.f3public = r14;
        }

        public static /* synthetic */ Group copy$default(Group r4, String r8, int r10, int r11, Long r12, int r13, int r14, int r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L6;
            r8 = r4.f11198cc;
        L6:
            if ((r16 & 2) == 0) goto L9;
            r10 = r4.f11199n;
        L9:
            if ((r16 & 4) == 0) goto L12;
            r11 = r4.alive;
        L12:
            if ((r16 & 8) == 0) goto L15;
            r12 = r4.best;
        L15:
            if ((r16 & 16) == 0) goto L18;
            r13 = r4.bridge;
        L18:
            if ((r16 & 32) == 0) goto L21;
            r14 = r4.falcon;
        L21:
            if ((r16 & 64) == 0) goto L23;
            r15 = r4.f3public;
        L23:
            int r18 = r14;
            int r19 = r15;
            Long r20 = r12;
            int r21 = r13;
            int r22 = r11;
            String r23 = r8;
            return r4.copy(r23, r10, r22, r20, r21, r18, r19);
        }

        public final String component1() {
            return this.f11198cc;
        }

        public final int component2() {
            return this.f11199n;
        }

        public final int component3() {
            return this.alive;
        }

        public final Long component4() {
            return this.best;
        }

        public final int component5() {
            return this.bridge;
        }

        public final int component6() {
            return this.falcon;
        }

        public final int component7() {
            return this.f3public;
        }

        public final Group copy(String r10, int r11, int r12, Long r13, int r14, int r15, int r16) {
            j.e(r10, AwgProbeService.KEY_COUNTRY);
            return new Group(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Group) == true) goto L8;
            return false;
        L8:
            Group r10 = (Group) r8;
            if (j.a(this.f11198cc, r10.f11198cc) == true) goto L12;
            return false;
        L12:
            if (this.f11199n == r10.f11199n) goto L15;
            return false;
        L15:
            if (this.alive == r10.alive) goto L18;
            return false;
        L18:
            if (j.a(this.best, r10.best) == true) goto L21;
            return false;
        L21:
            if (this.bridge == r10.bridge) goto L24;
            return false;
        L24:
            if (this.falcon == r10.falcon) goto L27;
            return false;
        L27:
            if (this.f3public == r10.f3public) goto L29;
            return false;
        L29:
            return true;
        }

        public final int getAlive() {
            return this.alive;
        }

        public final Long getBest() {
            return this.best;
        }

        public final int getBridge() {
            return this.bridge;
        }

        public final String getCc() {
            return this.f11198cc;
        }

        public final int getFalcon() {
            return this.falcon;
        }

        public final int getN() {
            return this.f11199n;
        }

        public final int getPublic() {
            return this.f3public;
        }

        public int hashCode() {
            int r4 = this.f11198cc.hashCode() * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.f11199n, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.alive, r8, 31);
            Long r11 = this.best;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r10 + r12) * 31;
            int r14 = androidx.compose.foundation.interaction.f.c(this.bridge, r13, 31);
            int r15 = androidx.compose.foundation.interaction.f.c(this.falcon, r14, 31);
            return Integer.hashCode(this.f3public) + r15;
        L5:
            r12 = r11.hashCode();
            goto L6
        }

        public final void setAlive(int r4) {
            this.alive = r4;
        }

        public final void setBest(Long r4) {
            this.best = r4;
        }

        public final void setBridge(int r4) {
            this.bridge = r4;
        }

        public final void setFalcon(int r4) {
            this.falcon = r4;
        }

        public final void setN(int r4) {
            this.f11199n = r4;
        }

        public final void setPublic(int r4) {
            this.f3public = r4;
        }

        public String toString() {
            String r4 = this.f11198cc;
            int r8 = this.f11199n;
            int r10 = this.alive;
            Long r11 = this.best;
            int r12 = this.bridge;
            int r13 = this.falcon;
            int r14 = this.f3public;
            StringBuilder r15 = s.l("Group(cc=", r4, ", n=", r8, ", alive=");
            r15.append(r10);
            r15.append(", best=");
            r15.append(r11);
            r15.append(", bridge=");
            s.v(r15, r12, ", falcon=", r13, ", public=");
            return w0.q(r15, r14, ")");
        }

        public /* synthetic */ Group(String r4, int r8, int r10, Long r11, int r12, int r13, int r14, int r15, kotlin.jvm.internal.e r16) {
            if ((r15 & 2) == 0) goto L6;
            r8 = 0;
        L6:
            if ((r15 & 4) == 0) goto L9;
            r10 = 0;
        L9:
            if ((r15 & 8) == 0) goto L12;
            r11 = null;
        L12:
            if ((r15 & 16) == 0) goto L15;
            r12 = 0;
        L15:
            if ((r15 & 32) == 0) goto L18;
            r13 = 0;
        L18:
            if ((r15 & 64) == 0) goto L21;
            int r17 = 0;
        L20:
            int r18 = r13;
            int r19 = r12;
            Long r20 = r11;
            this(r4, r8, r10, r20, r19, r18, r17);
            return;
        L21:
            r17 = r14;
            goto L20
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class IpScan {
        public static final int $stable = 8;
        private final int done;
        private final long endedAt;
        private final String error;
        private final List<CleanIp> found;
        private final String note;
        private final String phase;
        private final String ref;
        private final boolean running;
        private final int total;

        public IpScan(boolean r4, String r8, int r10, int r11, List<CleanIp> r12, String r13, String r14, String r15, long r16) {
            j.e(r8, "phase");
            j.e(r12, "found");
            j.e(r13, "ref");
            j.e(r14, "error");
            j.e(r15, "note");
            this.running = r4;
            this.phase = r8;
            this.done = r10;
            this.total = r11;
            this.found = r12;
            this.ref = r13;
            this.error = r14;
            this.note = r15;
            this.endedAt = r16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IpScan copy$default(IpScan r4, boolean r8, String r10, int r11, int r12, List r13, String r14, String r15, String r16, long r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L6;
            r8 = r4.running;
        L6:
            if ((r18 & 2) == 0) goto L9;
            r10 = r4.phase;
        L9:
            if ((r18 & 4) == 0) goto L12;
            r11 = r4.done;
        L12:
            if ((r18 & 8) == 0) goto L15;
            r12 = r4.total;
        L15:
            if ((r18 & 16) == 0) goto L18;
            r13 = r4.found;
        L18:
            if ((r18 & 32) == 0) goto L21;
            r14 = r4.ref;
        L21:
            if ((r18 & 64) == 0) goto L24;
            r15 = r4.error;
        L24:
            if ((r18 & 128) == 0) goto L27;
            r16 = r4.note;
        L27:
            if ((r18 & 256) == 0) goto L29;
            r17 = r4.endedAt;
        L29:
            long r110 = r17;
            String r20 = r15;
            String r111 = r16;
            List r21 = r13;
            String r22 = r14;
            int r23 = r11;
            int r24 = r12;
            return r4.copy(r8, r10, r23, r24, r21, r22, r20, r111, r110);
        }

        public final boolean component1() {
            return this.running;
        }

        public final String component2() {
            return this.phase;
        }

        public final int component3() {
            return this.done;
        }

        public final int component4() {
            return this.total;
        }

        public final List<CleanIp> component5() {
            return this.found;
        }

        public final String component6() {
            return this.ref;
        }

        public final String component7() {
            return this.error;
        }

        public final String component8() {
            return this.note;
        }

        public final long component9() {
            return this.endedAt;
        }

        public final IpScan copy(boolean r13, String r14, int r15, int r16, List<CleanIp> r17, String r18, String r19, String r20, long r21) {
            j.e(r14, "phase");
            j.e(r17, "found");
            j.e(r18, "ref");
            j.e(r19, "error");
            j.e(r20, "note");
            return new IpScan(r13, r14, r15, r16, r17, r18, r19, r20, r21);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof IpScan) == true) goto L8;
            return false;
        L8:
            IpScan r10 = (IpScan) r8;
            if (this.running == r10.running) goto L12;
            return false;
        L12:
            if (j.a(this.phase, r10.phase) == true) goto L15;
            return false;
        L15:
            if (this.done == r10.done) goto L18;
            return false;
        L18:
            if (this.total == r10.total) goto L21;
            return false;
        L21:
            if (j.a(this.found, r10.found) == true) goto L24;
            return false;
        L24:
            if (j.a(this.ref, r10.ref) == true) goto L27;
            return false;
        L27:
            if (j.a(this.error, r10.error) == true) goto L30;
            return false;
        L30:
            if (j.a(this.note, r10.note) == true) goto L33;
            return false;
        L33:
            if (this.endedAt == r10.endedAt) goto L35;
            return false;
        L35:
            return true;
        }

        public final int getDone() {
            return this.done;
        }

        public final long getEndedAt() {
            return this.endedAt;
        }

        public final String getError() {
            return this.error;
        }

        public final List<CleanIp> getFound() {
            return this.found;
        }

        public final String getNote() {
            return this.note;
        }

        public final String getPhase() {
            return this.phase;
        }

        public final String getRef() {
            return this.ref;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            int r4 = s.d(Boolean.hashCode(this.running) * 31, 31, this.phase);
            int r8 = androidx.compose.foundation.interaction.f.c(this.done, r4, 31);
            int r10 = s.d(s.d(s.d(androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.c(this.total, r8, 31), 31, this.found), 31, this.ref), 31, this.error), 31, this.note);
            return Long.hashCode(this.endedAt) + r10;
        }

        public String toString() {
            boolean r4 = this.running;
            String r8 = this.phase;
            int r10 = this.done;
            int r11 = this.total;
            List<CleanIp> r12 = this.found;
            String r13 = this.ref;
            String r14 = this.error;
            String r15 = this.note;
            long r16 = this.endedAt;
            StringBuilder r17 = new StringBuilder("IpScan(running=");
            r17.append(r4);
            r17.append(", phase=");
            r17.append(r8);
            r17.append(", done=");
            s.v(r17, r10, ", total=", r11, ", found=");
            r17.append(r12);
            r17.append(", ref=");
            r17.append(r13);
            r17.append(", error=");
            d1.x(r17, r14, ", note=", r15, ", endedAt=");
            return w0.k(r16, ")", r17);
        }

        public /* synthetic */ IpScan(boolean r4, String r8, int r10, int r11, List r12, String r13, String r14, String r15, long r16, int r17, kotlin.jvm.internal.e r18) {
            if ((r17 & 64) == 0) goto L6;
            r14 = "";
        L6:
            if ((r17 & 128) == 0) goto L9;
            r15 = "";
        L9:
            if ((r17 & 256) == 0) goto L11;
            r16 = 0;
        L11:
            long r19 = r16;
            String r110 = r15;
            this(r4, r8, r10, r11, r12, r13, r14, r110, r19);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Item {
        public static final int $stable = 8;
        private String cc0;
        private final String from;
        private final String host;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11200id;
        private String ip0;
        private final String kind;
        private final int port;
        private final String profile;
        private final String protocol;
        private long seen;
        private final String src;
        private boolean user;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private long f11201v0;

        public Item(String r8, String r10, String r11, int r12, String r13, String r14, String r15, long r16, boolean r17, String r18, String r19, long r110, String r111) {
            j.e(r8, XrayCoreHostService.KEY_ID);
            j.e(r10, "kind");
            j.e(r11, "host");
            j.e(r13, "protocol");
            j.e(r14, "src");
            j.e(r15, "from");
            j.e(r18, "profile");
            j.e(r19, "cc0");
            j.e(r111, "ip0");
            this.f11200id = r8;
            this.kind = r10;
            this.host = r11;
            this.port = r12;
            this.protocol = r13;
            this.src = r14;
            this.from = r15;
            this.seen = r16;
            this.user = r17;
            this.profile = r18;
            this.cc0 = r19;
            this.f11201v0 = r110;
            this.ip0 = r111;
        }

        public static /* synthetic */ Item copy$default(Item r16, String r17, String r18, String r19, int r20, String r21, String r22, String r23, long r24, boolean r26, String r27, String r28, long r29, String r31, int r32, Object r33) {
            if ((r32 & 1) == 0) goto L5;
            String r4 = r16.f11200id;
        L7:
            if ((r32 & 2) == 0) goto L9;
            String r8 = r16.kind;
        L11:
            if ((r32 & 4) == 0) goto L13;
            String r10 = r16.host;
        L15:
            if ((r32 & 8) == 0) goto L17;
            int r11 = r16.port;
        L19:
            if ((r32 & 16) == 0) goto L21;
            String r12 = r16.protocol;
        L23:
            if ((r32 & 32) == 0) goto L25;
            String r13 = r16.src;
        L27:
            if ((r32 & 64) == 0) goto L29;
            String r14 = r16.from;
        L31:
            if ((r32 & 128) == 0) goto L33;
            long r15 = r16.seen;
        L35:
            if ((r32 & 256) == 0) goto L37;
            boolean r110 = r16.user;
        L39:
            if ((r32 & 512) == 0) goto L41;
            String r111 = r16.profile;
        L43:
            if ((r32 & 1024) == 0) goto L45;
            String r112 = r16.cc0;
        L47:
            if ((r32 & 2048) == 0) goto L49;
            long r113 = r16.f11201v0;
        L51:
            if ((r32 & 4096) == 0) goto L54;
            String r34 = r16.ip0;
        L56:
            return r16.copy(r4, r8, r10, r11, r12, r13, r14, r15, r110, r111, r112, r113, r34);
        L54:
            r34 = r31;
            goto L56
        L49:
            r113 = r29;
            goto L51
        L45:
            r112 = r28;
            goto L47
        L41:
            r111 = r27;
            goto L43
        L37:
            r110 = r26;
            goto L39
        L33:
            r15 = r24;
            goto L35
        L29:
            r14 = r23;
            goto L31
        L25:
            r13 = r22;
            goto L27
        L21:
            r12 = r21;
            goto L23
        L17:
            r11 = r20;
            goto L19
        L13:
            r10 = r19;
            goto L15
        L9:
            r8 = r18;
            goto L11
        L5:
            r4 = r17;
            goto L7
        }

        public final String component1() {
            return this.f11200id;
        }

        public final String component10() {
            return this.profile;
        }

        public final String component11() {
            return this.cc0;
        }

        public final long component12() {
            return this.f11201v0;
        }

        public final String component13() {
            return this.ip0;
        }

        public final String component2() {
            return this.kind;
        }

        public final String component3() {
            return this.host;
        }

        public final int component4() {
            return this.port;
        }

        public final String component5() {
            return this.protocol;
        }

        public final String component6() {
            return this.src;
        }

        public final String component7() {
            return this.from;
        }

        public final long component8() {
            return this.seen;
        }

        public final boolean component9() {
            return this.user;
        }

        public final Item copy(String r18, String r19, String r20, int r21, String r22, String r23, String r24, long r25, boolean r27, String r28, String r29, long r30, String r32) {
            j.e(r18, XrayCoreHostService.KEY_ID);
            j.e(r19, "kind");
            j.e(r20, "host");
            j.e(r22, "protocol");
            j.e(r23, "src");
            j.e(r24, "from");
            j.e(r28, "profile");
            j.e(r29, "cc0");
            j.e(r32, "ip0");
            return new Item(r18, r19, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r32);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Item) == true) goto L8;
            return false;
        L8:
            Item r10 = (Item) r8;
            if (j.a(this.f11200id, r10.f11200id) == true) goto L12;
            return false;
        L12:
            if (j.a(this.kind, r10.kind) == true) goto L15;
            return false;
        L15:
            if (j.a(this.host, r10.host) == true) goto L18;
            return false;
        L18:
            if (this.port == r10.port) goto L21;
            return false;
        L21:
            if (j.a(this.protocol, r10.protocol) == true) goto L24;
            return false;
        L24:
            if (j.a(this.src, r10.src) == true) goto L27;
            return false;
        L27:
            if (j.a(this.from, r10.from) == true) goto L30;
            return false;
        L30:
            if (this.seen == r10.seen) goto L33;
            return false;
        L33:
            if (this.user == r10.user) goto L36;
            return false;
        L36:
            if (j.a(this.profile, r10.profile) == true) goto L39;
            return false;
        L39:
            if (j.a(this.cc0, r10.cc0) == true) goto L42;
            return false;
        L42:
            if (this.f11201v0 == r10.f11201v0) goto L45;
            return false;
        L45:
            if (j.a(this.ip0, r10.ip0) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final String getCc0() {
            return this.cc0;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getId() {
            return this.f11200id;
        }

        public final String getIp0() {
            return this.ip0;
        }

        public final String getKind() {
            return this.kind;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final long getSeen() {
            return this.seen;
        }

        public final String getSrc() {
            return this.src;
        }

        public final boolean getUser() {
            return this.user;
        }

        public final long getV0() {
            return this.f11201v0;
        }

        public int hashCode() {
            int r4 = s.d(s.d(this.f11200id.hashCode() * 31, 31, this.kind), 31, this.host);
            int r8 = w0.c(s.d(s.d(w0.d(w0.c(s.d(s.d(s.d(androidx.compose.foundation.interaction.f.c(this.port, r4, 31), 31, this.protocol), 31, this.src), 31, this.from), 31, this.seen), 31, this.user), 31, this.profile), 31, this.cc0), 31, this.f11201v0);
            return this.ip0.hashCode() + r8;
        }

        public final void setCc0(String r4) {
            j.e(r4, "<set-?>");
            this.cc0 = r4;
        }

        public final void setIp0(String r4) {
            j.e(r4, "<set-?>");
            this.ip0 = r4;
        }

        public final void setSeen(long r4) {
            this.seen = r4;
        }

        public final void setUser(boolean r4) {
            this.user = r4;
        }

        public final void setV0(long r4) {
            this.f11201v0 = r4;
        }

        public String toString() {
            String r4 = this.f11200id;
            String r8 = this.kind;
            String r10 = this.host;
            int r11 = this.port;
            String r12 = this.protocol;
            String r13 = this.src;
            String r14 = this.from;
            long r15 = this.seen;
            boolean r16 = this.user;
            String r17 = this.profile;
            String r18 = this.cc0;
            long r19 = this.f11201v0;
            String r110 = this.ip0;
            StringBuilder r20 = s.n("Item(id=", r4, ", kind=", r8, ", host=");
            f0.a.r(r11, r10, ", port=", ", protocol=", r20);
            d1.x(r20, r12, ", src=", r13, ", from=");
            s.q(r15, r14, ", seen=", r20);
            r20.append(", user=");
            r20.append(r16);
            r20.append(", profile=");
            r20.append(r17);
            f0.a.x(", cc0=", r18, ", v0=", r20);
            i.t(r19, ", ip0=", r110, r20);
            r20.append(")");
            return r20.toString();
        }

        public /* synthetic */ Item(String r20, String r21, String r22, int r23, String r24, String r25, String r26, long r27, boolean r29, String r30, String r31, long r32, String r34, int r35, kotlin.jvm.internal.e r36) {
            if ((r35 & 64) == 0) goto L5;
            String r10 = "";
        L7:
            if ((r35 & 128) == 0) goto L9;
            long r11 = 0;
        L11:
            if ((r35 & 256) == 0) goto L13;
            boolean r13 = false;
        L15:
            if ((r35 & 512) == 0) goto L17;
            String r14 = "";
        L19:
            if ((r35 & 1024) == 0) goto L21;
            String r15 = "";
        L23:
            if ((r35 & 2048) == 0) goto L25;
            long r16 = 0;
        L27:
            if ((r35 & 4096) == 0) goto L30;
            String r18 = "";
        L31:
            this(r20, r21, r22, r23, r24, r25, r10, r11, r13, r14, r15, r16, r18);
            return;
        L30:
            r18 = r34;
            goto L31
        L25:
            r16 = r32;
            goto L27
        L21:
            r15 = r31;
            goto L23
        L17:
            r14 = r30;
            goto L19
        L13:
            r13 = r29;
            goto L15
        L9:
            r11 = r27;
            goto L11
        L5:
            r10 = r26;
            goto L7
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Job {
        public static final int $stable = 8;
        private final int alive;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11202cc;
        private final int done;
        private final long endedAt;
        private final List<String> errors;
        private final int found;
        private final int frozen;
        private final String kind;
        private final String label;
        private final boolean running;
        private final int total;
        private final String via;
        private final String what;

        public Job(boolean r4, int r8, int r10, int r11, int r12, String r13, int r14, List<String> r15, String r16, long r17, String r18, String r19, String r110) {
            j.e(r13, "label");
            j.e(r15, "errors");
            j.e(r16, "via");
            j.e(r18, "kind");
            j.e(r19, AwgProbeService.KEY_COUNTRY);
            j.e(r110, "what");
            this.running = r4;
            this.done = r8;
            this.total = r10;
            this.alive = r11;
            this.frozen = r12;
            this.label = r13;
            this.found = r14;
            this.errors = r15;
            this.via = r16;
            this.endedAt = r17;
            this.kind = r18;
            this.f11202cc = r19;
            this.what = r110;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Job copy$default(Job r14, boolean r15, int r16, int r17, int r18, int r19, String r20, int r21, List r22, String r23, long r24, String r26, String r27, String r28, int r29, Object r30) {
            if ((r29 & 1) == 0) goto L5;
            boolean r4 = r14.running;
        L7:
            if ((r29 & 2) == 0) goto L9;
            int r8 = r14.done;
        L11:
            if ((r29 & 4) == 0) goto L13;
            int r10 = r14.total;
        L15:
            if ((r29 & 8) == 0) goto L17;
            int r11 = r14.alive;
        L19:
            if ((r29 & 16) == 0) goto L21;
            int r12 = r14.frozen;
        L23:
            if ((r29 & 32) == 0) goto L25;
            String r13 = r14.label;
        L27:
            if ((r29 & 64) == 0) goto L29;
            int r25 = r14.found;
        L31:
            if ((r29 & 128) == 0) goto L33;
            List r31 = r14.errors;
        L35:
            if ((r29 & 256) == 0) goto L37;
            String r32 = r14.via;
        L39:
            if ((r29 & 512) == 0) goto L41;
            long r110 = r14.endedAt;
        L43:
            if ((r29 & 1024) == 0) goto L45;
            String r111 = r14.kind;
        L47:
            if ((r29 & 2048) == 0) goto L49;
            String r112 = r14.f11202cc;
        L51:
            if ((r29 & 4096) == 0) goto L54;
            String r210 = r14.what;
        L56:
            return r14.copy(r4, r8, r10, r11, r12, r13, r25, r31, r32, r110, r111, r112, r210);
        L54:
            r210 = r28;
            goto L56
        L49:
            r112 = r27;
            goto L51
        L45:
            r111 = r26;
            goto L47
        L41:
            r110 = r24;
            goto L43
        L37:
            r32 = r23;
            goto L39
        L33:
            r31 = r22;
            goto L35
        L29:
            r25 = r21;
            goto L31
        L25:
            r13 = r20;
            goto L27
        L21:
            r12 = r19;
            goto L23
        L17:
            r11 = r18;
            goto L19
        L13:
            r10 = r17;
            goto L15
        L9:
            r8 = r16;
            goto L11
        L5:
            r4 = r15;
            goto L7
        }

        public final boolean component1() {
            return this.running;
        }

        public final long component10() {
            return this.endedAt;
        }

        public final String component11() {
            return this.kind;
        }

        public final String component12() {
            return this.f11202cc;
        }

        public final String component13() {
            return this.what;
        }

        public final int component2() {
            return this.done;
        }

        public final int component3() {
            return this.total;
        }

        public final int component4() {
            return this.alive;
        }

        public final int component5() {
            return this.frozen;
        }

        public final String component6() {
            return this.label;
        }

        public final int component7() {
            return this.found;
        }

        public final List<String> component8() {
            return this.errors;
        }

        public final String component9() {
            return this.via;
        }

        public final Job copy(boolean r17, int r18, int r19, int r20, int r21, String r22, int r23, List<String> r24, String r25, long r26, String r28, String r29, String r30) {
            j.e(r22, "label");
            j.e(r24, "errors");
            j.e(r25, "via");
            j.e(r28, "kind");
            j.e(r29, AwgProbeService.KEY_COUNTRY);
            j.e(r30, "what");
            return new Job(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Job) == true) goto L8;
            return false;
        L8:
            Job r10 = (Job) r8;
            if (this.running == r10.running) goto L12;
            return false;
        L12:
            if (this.done == r10.done) goto L15;
            return false;
        L15:
            if (this.total == r10.total) goto L18;
            return false;
        L18:
            if (this.alive == r10.alive) goto L21;
            return false;
        L21:
            if (this.frozen == r10.frozen) goto L24;
            return false;
        L24:
            if (j.a(this.label, r10.label) == true) goto L27;
            return false;
        L27:
            if (this.found == r10.found) goto L30;
            return false;
        L30:
            if (j.a(this.errors, r10.errors) == true) goto L33;
            return false;
        L33:
            if (j.a(this.via, r10.via) == true) goto L36;
            return false;
        L36:
            if (this.endedAt == r10.endedAt) goto L39;
            return false;
        L39:
            if (j.a(this.kind, r10.kind) == true) goto L42;
            return false;
        L42:
            if (j.a(this.f11202cc, r10.f11202cc) == true) goto L45;
            return false;
        L45:
            if (j.a(this.what, r10.what) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final int getAlive() {
            return this.alive;
        }

        public final String getCc() {
            return this.f11202cc;
        }

        public final int getDone() {
            return this.done;
        }

        public final long getEndedAt() {
            return this.endedAt;
        }

        public final List<String> getErrors() {
            return this.errors;
        }

        public final int getFound() {
            return this.found;
        }

        public final int getFrozen() {
            return this.frozen;
        }

        public final String getKind() {
            return this.kind;
        }

        public final String getLabel() {
            return this.label;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final int getTotal() {
            return this.total;
        }

        public final String getVia() {
            return this.via;
        }

        public final String getWhat() {
            return this.what;
        }

        public int hashCode() {
            int r4 = Boolean.hashCode(this.running) * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.done, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.total, r8, 31);
            int r11 = androidx.compose.foundation.interaction.f.c(this.alive, r10, 31);
            int r12 = s.d(androidx.compose.foundation.interaction.f.c(this.frozen, r11, 31), 31, this.label);
            int r13 = s.d(s.d(w0.c(s.d(androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.c(this.found, r12, 31), 31, this.errors), 31, this.via), 31, this.endedAt), 31, this.kind), 31, this.f11202cc);
            return this.what.hashCode() + r13;
        }

        public String toString() {
            boolean r4 = this.running;
            int r8 = this.done;
            int r10 = this.total;
            int r11 = this.alive;
            int r12 = this.frozen;
            String r13 = this.label;
            int r14 = this.found;
            List<String> r15 = this.errors;
            String r16 = this.via;
            long r17 = this.endedAt;
            String r18 = this.kind;
            String r19 = this.f11202cc;
            String r110 = this.what;
            StringBuilder r111 = new StringBuilder("Job(running=");
            r111.append(r4);
            r111.append(", done=");
            r111.append(r8);
            r111.append(", total=");
            s.v(r111, r10, ", alive=", r11, ", frozen=");
            d1.n(r12, ", label=", r13, ", found=", r111);
            r111.append(r14);
            r111.append(", errors=");
            r111.append(r15);
            r111.append(", via=");
            s.q(r17, r16, ", endedAt=", r111);
            d1.x(r111, ", kind=", r18, ", cc=", r19);
            return androidx.compose.foundation.interaction.f.r(", what=", r110, ")", r111);
        }

        public Job(boolean r19, int r20, int r21, int r22, int r23, String r24, int r25, List r26, String r27, long r28, String r30, String r31, String r32, int r33, kotlin.jvm.internal.e r34) {
            if ((r33 & 8) == 0) goto L5;
            int r8 = 0;
        L7:
            if ((r33 & 16) == 0) goto L9;
            int r10 = 0;
        L11:
            if ((r33 & 32) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r33 & 64) == 0) goto L17;
            int r12 = 0;
        L19:
            if ((r33 & 128) == 0) goto L21;
            List r13 = w.INSTANCE;
        L23:
            if ((r33 & 256) == 0) goto L25;
            String r14 = "";
        L27:
            if ((r33 & 512) == 0) goto L29;
            long r15 = 0;
        L31:
            if ((r33 & 1024) == 0) goto L33;
            String r16 = Psi.CrashTracebackLevelAll;
        L35:
            if ((r33 & 2048) == 0) goto L37;
            String r17 = "";
        L39:
            if ((r33 & 4096) == 0) goto L42;
            String r18 = Psi.CrashTracebackLevelAll;
        L43:
            this(r19, r20, r21, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18);
            return;
        L42:
            r18 = r32;
            goto L43
        L37:
            r17 = r31;
            goto L39
        L33:
            r16 = r30;
            goto L35
        L29:
            r15 = r28;
            goto L31
        L25:
            r14 = r27;
            goto L27
        L21:
            r13 = r26;
            goto L23
        L17:
            r12 = r25;
            goto L19
        L13:
            r11 = r24;
            goto L15
        L9:
            r10 = r23;
            goto L11
        L5:
            r8 = r22;
            goto L7
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Page {
        private final int code;
        private final boolean ok;
        private final List<Post> posts;

        public Page(boolean r4, int r8, List<Post> r10) {
            j.e(r10, "posts");
            this.ok = r4;
            this.code = r8;
            this.posts = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Page copy$default(Page r4, boolean r8, int r10, List r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r8 = r4.ok;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r4.code;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r4.posts;
        L12:
            return r4.copy(r8, r10, r11);
        }

        public final boolean component1() {
            return this.ok;
        }

        public final int component2() {
            return this.code;
        }

        public final List<Post> component3() {
            return this.posts;
        }

        public final Page copy(boolean r4, int r8, List<Post> r10) {
            j.e(r10, "posts");
            return new Page(r4, r8, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Page) == true) goto L8;
            return false;
        L8:
            Page r10 = (Page) r8;
            if (this.ok == r10.ok) goto L12;
            return false;
        L12:
            if (this.code == r10.code) goto L15;
            return false;
        L15:
            if (j.a(this.posts, r10.posts) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int getCode() {
            return this.code;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final List<Post> getPosts() {
            return this.posts;
        }

        public int hashCode() {
            int r4 = Boolean.hashCode(this.ok) * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.code, r4, 31);
            return this.posts.hashCode() + r8;
        }

        public String toString() {
            boolean r4 = this.ok;
            int r8 = this.code;
            List<Post> r10 = this.posts;
            StringBuilder r11 = new StringBuilder("Page(ok=");
            r11.append(r4);
            r11.append(", code=");
            r11.append(r8);
            r11.append(", posts=");
            return d1.j(r11, r10, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Parsed {
        public static final int $stable = 8;
        private final List<ParsedBridge> bridges;
        private final List<String> falcons;

        public Parsed(List<ParsedBridge> r4, List<String> r8) {
            j.e(r4, "bridges");
            j.e(r8, "falcons");
            this.bridges = r4;
            this.falcons = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Parsed copy$default(Parsed r4, List r8, List r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r8 = r4.bridges;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r4.falcons;
        L9:
            return r4.copy(r8, r10);
        }

        public final List<ParsedBridge> component1() {
            return this.bridges;
        }

        public final List<String> component2() {
            return this.falcons;
        }

        public final Parsed copy(List<ParsedBridge> r4, List<String> r8) {
            j.e(r4, "bridges");
            j.e(r8, "falcons");
            return new Parsed(r4, r8);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Parsed) == true) goto L8;
            return false;
        L8:
            Parsed r10 = (Parsed) r8;
            if (j.a(this.bridges, r10.bridges) == true) goto L12;
            return false;
        L12:
            if (j.a(this.falcons, r10.falcons) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final List<ParsedBridge> getBridges() {
            return this.bridges;
        }

        public final List<String> getFalcons() {
            return this.falcons;
        }

        public int hashCode() {
            int r4 = this.bridges.hashCode() * 31;
            return this.falcons.hashCode() + r4;
        }

        public String toString() {
            return "Parsed(bridges=" + this.bridges + ", falcons=" + this.falcons + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ParsedBridge {
        public static final int $stable = 0;
        private final String error;
        private final String host;
        private final int port;
        private final boolean sigOk;

        public ParsedBridge(String r4, int r8, boolean r10, String r11) {
            j.e(r4, "host");
            j.e(r11, "error");
            this.host = r4;
            this.port = r8;
            this.sigOk = r10;
            this.error = r11;
        }

        public static /* synthetic */ ParsedBridge copy$default(ParsedBridge r4, String r8, int r10, boolean r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r8 = r4.host;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r10 = r4.port;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r11 = r4.sigOk;
        L12:
            if ((r13 & 8) == 0) goto L15;
            r12 = r4.error;
        L15:
            return r4.copy(r8, r10, r11, r12);
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.port;
        }

        public final boolean component3() {
            return this.sigOk;
        }

        public final String component4() {
            return this.error;
        }

        public final ParsedBridge copy(String r4, int r8, boolean r10, String r11) {
            j.e(r4, "host");
            j.e(r11, "error");
            return new ParsedBridge(r4, r8, r10, r11);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ParsedBridge) == true) goto L8;
            return false;
        L8:
            ParsedBridge r10 = (ParsedBridge) r8;
            if (j.a(this.host, r10.host) == true) goto L12;
            return false;
        L12:
            if (this.port == r10.port) goto L15;
            return false;
        L15:
            if (this.sigOk == r10.sigOk) goto L18;
            return false;
        L18:
            if (j.a(this.error, r10.error) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final String getError() {
            return this.error;
        }

        public final String getHost() {
            return this.host;
        }

        public final int getPort() {
            return this.port;
        }

        public final boolean getSigOk() {
            return this.sigOk;
        }

        public int hashCode() {
            int r4 = this.host.hashCode() * 31;
            int r8 = w0.d(androidx.compose.foundation.interaction.f.c(this.port, r4, 31), 31, this.sigOk);
            return this.error.hashCode() + r8;
        }

        public String toString() {
            String r4 = this.host;
            int r8 = this.port;
            boolean r10 = this.sigOk;
            String r11 = this.error;
            StringBuilder r12 = s.l("ParsedBridge(host=", r4, ", port=", r8, ", sigOk=");
            r12.append(r10);
            r12.append(", error=");
            r12.append(r11);
            r12.append(")");
            return r12.toString();
        }

        public /* synthetic */ ParsedBridge(String r4, int r8, boolean r10, String r11, int r12, kotlin.jvm.internal.e r13) {
            if ((r12 & 8) == 0) goto L5;
            r11 = "";
        L5:
            this(r4, r8, r10, r11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Post {
        private final long at;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final long f11203id;
        private final String text;

        public Post(long r4, long r8, String r10) {
            j.e(r10, "text");
            this.f11203id = r4;
            this.at = r8;
            this.text = r10;
        }

        public static /* synthetic */ Post copy$default(Post r8, long r10, long r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L5;
            r10 = r8.f11203id;
        L5:
            long r4 = r10;
            if ((r13 & 2) == 0) goto L8;
            r11 = r8.at;
        L8:
            long r15 = r11;
            if ((r13 & 4) == 0) goto L12;
            r12 = r8.text;
        L12:
            return r8.copy(r4, r15, r12);
        }

        public final long component1() {
            return this.f11203id;
        }

        public final long component2() {
            return this.at;
        }

        public final String component3() {
            return this.text;
        }

        public final Post copy(long r8, long r10, String r12) {
            j.e(r12, "text");
            return new Post(r8, r10, r12);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Post) == true) goto L8;
            return false;
        L8:
            Post r10 = (Post) r8;
            if (this.f11203id == r10.f11203id) goto L12;
            return false;
        L12:
            if (this.at == r10.at) goto L15;
            return false;
        L15:
            if (j.a(this.text, r10.text) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final long getAt() {
            return this.at;
        }

        public final long getId() {
            return this.f11203id;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            int r4 = w0.c(Long.hashCode(this.f11203id) * 31, 31, this.at);
            return this.text.hashCode() + r4;
        }

        public String toString() {
            long r4 = this.f11203id;
            long r8 = this.at;
            String r10 = this.text;
            StringBuilder r11 = f0.a.o(r4, "Post(id=", ", at=");
            i.t(r8, ", text=", r10, r11);
            r11.append(")");
            return r11.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Prefs {
        public static final int $stable = 0;
        private final boolean autoClean;
        private final String cleanIp;

        public Prefs() {
            this(null, false, 3, null);
        }

        public static /* synthetic */ Prefs copy$default(Prefs r4, String r8, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r8 = r4.cleanIp;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r4.autoClean;
        L9:
            return r4.copy(r8, r10);
        }

        public final String component1() {
            return this.cleanIp;
        }

        public final boolean component2() {
            return this.autoClean;
        }

        public final Prefs copy(String r4, boolean r8) {
            j.e(r4, "cleanIp");
            return new Prefs(r4, r8);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Prefs) == true) goto L8;
            return false;
        L8:
            Prefs r10 = (Prefs) r8;
            if (j.a(this.cleanIp, r10.cleanIp) == true) goto L12;
            return false;
        L12:
            if (this.autoClean == r10.autoClean) goto L14;
            return false;
        L14:
            return true;
        }

        public final boolean getAutoClean() {
            return this.autoClean;
        }

        public final String getCleanIp() {
            return this.cleanIp;
        }

        public int hashCode() {
            int r4 = this.cleanIp.hashCode() * 31;
            return Boolean.hashCode(this.autoClean) + r4;
        }

        public String toString() {
            return "Prefs(cleanIp=" + this.cleanIp + ", autoClean=" + this.autoClean + ")";
        }

        public Prefs(String r4, boolean r8) {
            j.e(r4, "cleanIp");
            this.cleanIp = r4;
            this.autoClean = r8;
        }

        public /* synthetic */ Prefs(String r4, boolean r8, int r10, kotlin.jvm.internal.e r11) {
            if ((r10 & 1) == 0) goto L6;
            r4 = "";
        L6:
            if ((r10 & 2) == 0) goto L8;
            r8 = false;
        L8:
            this(r4, r8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ready {
        private final ArgoProtocol.Endpoint ep;
        private final ArgoProtocol.SessionInfo info;
        private final long ms;
        private final Item x;

        public Ready(Item r4, ArgoProtocol.Endpoint r8, ArgoProtocol.SessionInfo r10, long r11) {
            j.e(r4, "x");
            j.e(r8, "ep");
            j.e(r10, "info");
            this.x = r4;
            this.ep = r8;
            this.info = r10;
            this.ms = r11;
        }

        public final ArgoProtocol.Endpoint getEp() {
            return this.ep;
        }

        public final ArgoProtocol.SessionInfo getInfo() {
            return this.info;
        }

        public final long getMs() {
            return this.ms;
        }

        public final Item getX() {
            return this.x;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Result {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11204cc;
        private final String edge;
        private final String error;
        private final String exitIp;
        private final int fails;
        private final boolean frozen;
        private final long ms;
        private final boolean ok;

        public Result(boolean r4, long r8, String r10, String r11, long r12, int r13, String r14, boolean r15, String r16) {
            j.e(r10, AwgProbeService.KEY_COUNTRY);
            j.e(r11, "exitIp");
            j.e(r14, "error");
            j.e(r16, "edge");
            this.ok = r4;
            this.ms = r8;
            this.f11204cc = r10;
            this.exitIp = r11;
            this.at = r12;
            this.fails = r13;
            this.error = r14;
            this.frozen = r15;
            this.edge = r16;
        }

        public static /* synthetic */ Result copy$default(Result r4, boolean r8, long r10, String r11, String r12, long r13, int r14, String r15, boolean r16, String r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L6;
            r8 = r4.ok;
        L6:
            if ((r18 & 2) == 0) goto L9;
            r10 = r4.ms;
        L9:
            if ((r18 & 4) == 0) goto L12;
            r11 = r4.f11204cc;
        L12:
            if ((r18 & 8) == 0) goto L15;
            r12 = r4.exitIp;
        L15:
            if ((r18 & 16) == 0) goto L18;
            r13 = r4.at;
        L18:
            if ((r18 & 32) == 0) goto L21;
            r14 = r4.fails;
        L21:
            if ((r18 & 64) == 0) goto L24;
            r15 = r4.error;
        L24:
            if ((r18 & 128) == 0) goto L27;
            r16 = r4.frozen;
        L27:
            if ((r18 & 256) == 0) goto L29;
            r17 = r4.edge;
        L29:
            boolean r110 = r16;
            String r111 = r17;
            long r20 = r13;
            String r21 = r11;
            String r22 = r12;
            long r23 = r10;
            boolean r24 = r8;
            return r4.copy(r24, r23, r21, r22, r20, r14, r15, r110, r111);
        }

        public final boolean component1() {
            return this.ok;
        }

        public final long component2() {
            return this.ms;
        }

        public final String component3() {
            return this.f11204cc;
        }

        public final String component4() {
            return this.exitIp;
        }

        public final long component5() {
            return this.at;
        }

        public final int component6() {
            return this.fails;
        }

        public final String component7() {
            return this.error;
        }

        public final boolean component8() {
            return this.frozen;
        }

        public final String component9() {
            return this.edge;
        }

        public final Result copy(boolean r14, long r15, String r17, String r18, long r19, int r21, String r22, boolean r23, String r24) {
            j.e(r17, AwgProbeService.KEY_COUNTRY);
            j.e(r18, "exitIp");
            j.e(r22, "error");
            j.e(r24, "edge");
            return new Result(r14, r15, r17, r18, r19, r21, r22, r23, r24);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Result) == true) goto L8;
            return false;
        L8:
            Result r10 = (Result) r8;
            if (this.ok == r10.ok) goto L12;
            return false;
        L12:
            if (this.ms == r10.ms) goto L15;
            return false;
        L15:
            if (j.a(this.f11204cc, r10.f11204cc) == true) goto L18;
            return false;
        L18:
            if (j.a(this.exitIp, r10.exitIp) == true) goto L21;
            return false;
        L21:
            if (this.at == r10.at) goto L24;
            return false;
        L24:
            if (this.fails == r10.fails) goto L27;
            return false;
        L27:
            if (j.a(this.error, r10.error) == true) goto L30;
            return false;
        L30:
            if (this.frozen == r10.frozen) goto L33;
            return false;
        L33:
            if (j.a(this.edge, r10.edge) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final long getAt() {
            return this.at;
        }

        public final String getCc() {
            return this.f11204cc;
        }

        public final String getEdge() {
            return this.edge;
        }

        public final String getError() {
            return this.error;
        }

        public final String getExitIp() {
            return this.exitIp;
        }

        public final int getFails() {
            return this.fails;
        }

        public final boolean getFrozen() {
            return this.frozen;
        }

        public final long getMs() {
            return this.ms;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public int hashCode() {
            int r4 = w0.c(s.d(s.d(w0.c(Boolean.hashCode(this.ok) * 31, 31, this.ms), 31, this.f11204cc), 31, this.exitIp), 31, this.at);
            int r8 = w0.d(s.d(androidx.compose.foundation.interaction.f.c(this.fails, r4, 31), 31, this.error), 31, this.frozen);
            return this.edge.hashCode() + r8;
        }

        public String toString() {
            boolean r4 = this.ok;
            long r8 = this.ms;
            String r10 = this.f11204cc;
            String r11 = this.exitIp;
            long r12 = this.at;
            int r13 = this.fails;
            String r14 = this.error;
            boolean r15 = this.frozen;
            String r16 = this.edge;
            StringBuilder r17 = new StringBuilder("Result(ok=");
            r17.append(r4);
            r17.append(", ms=");
            r17.append(r8);
            d1.x(r17, ", cc=", r10, ", exitIp=", r11);
            v0.a.k(r12, ", at=", ", fails=", r17);
            d1.n(r13, ", error=", r14, ", frozen=", r17);
            r17.append(r15);
            r17.append(", edge=");
            r17.append(r16);
            r17.append(")");
            return r17.toString();
        }

        public /* synthetic */ Result(boolean r15, long r16, String r18, String r19, long r20, int r22, String r23, boolean r24, String r25, int r26, kotlin.jvm.internal.e r27) {
            if ((r26 & 128) == 0) goto L5;
            boolean r12 = false;
        L7:
            if ((r26 & 256) == 0) goto L10;
            String r13 = "";
        L11:
            this(r15, r16, r18, r19, r20, r22, r23, r12, r13);
            return;
        L10:
            r13 = r25;
            goto L11
        L5:
            r12 = r24;
            goto L7
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Row {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11205cc;
        private final String error;
        private final String exitIp;
        private final int fails;
        private final boolean frozen;
        private final String host;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11206id;
        private final String kind;
        private final Long ms;
        private final Boolean ok;
        private final int port;
        private final String profile;
        private final long seen;
        private final boolean user;
        private final long verified;

        public Row(String r8, String r10, String r11, int r12, boolean r13, String r14, long r15, Boolean r16, boolean r17, Long r18, String r19, String r110, long r111, String r20, int r21, long r22) {
            j.e(r8, XrayCoreHostService.KEY_ID);
            j.e(r10, "kind");
            j.e(r11, "host");
            j.e(r14, "profile");
            j.e(r19, AwgProbeService.KEY_COUNTRY);
            j.e(r110, "exitIp");
            j.e(r20, "error");
            this.f11206id = r8;
            this.kind = r10;
            this.host = r11;
            this.port = r12;
            this.user = r13;
            this.profile = r14;
            this.verified = r15;
            this.ok = r16;
            this.frozen = r17;
            this.ms = r18;
            this.f11205cc = r19;
            this.exitIp = r110;
            this.at = r111;
            this.error = r20;
            this.fails = r21;
            this.seen = r22;
        }

        public static /* synthetic */ Row copy$default(Row r16, String r17, String r18, String r19, int r20, boolean r21, String r22, long r23, Boolean r25, boolean r26, Long r27, String r28, String r29, long r30, String r32, int r33, long r34, int r36, Object r37) {
            if ((r36 & 1) == 0) goto L5;
            String r4 = r16.f11206id;
        L7:
            if ((r36 & 2) == 0) goto L9;
            String r8 = r16.kind;
        L11:
            if ((r36 & 4) == 0) goto L13;
            String r10 = r16.host;
        L15:
            if ((r36 & 8) == 0) goto L17;
            int r11 = r16.port;
        L19:
            if ((r36 & 16) == 0) goto L21;
            boolean r12 = r16.user;
        L23:
            if ((r36 & 32) == 0) goto L25;
            String r13 = r16.profile;
        L27:
            if ((r36 & 64) == 0) goto L29;
            long r14 = r16.verified;
        L31:
            if ((r36 & 128) == 0) goto L33;
            Boolean r15 = r16.ok;
        L35:
            if ((r36 & 256) == 0) goto L37;
            boolean r110 = r16.frozen;
        L39:
            if ((r36 & 512) == 0) goto L41;
            Long r111 = r16.ms;
        L43:
            if ((r36 & 1024) == 0) goto L45;
            String r112 = r16.f11205cc;
        L47:
            if ((r36 & 2048) == 0) goto L49;
            String r113 = r16.exitIp;
        L50:
            String r114 = r4;
            String r115 = r8;
            if ((r36 & 4096) == 0) goto L53;
            long r24 = r16.at;
        L55:
            if ((r36 & 8192) == 0) goto L57;
            String r116 = r16.error;
        L58:
            long r117 = r24;
            if ((r36 & 16384) == 0) goto L61;
            int r31 = r16.fails;
        L63:
            if ((r36 & 32768) == 0) goto L66;
            int r35 = r31;
            long r38 = r16.seen;
        L68:
            return r16.copy(r114, r115, r10, r11, r12, r13, r14, r15, r110, r111, r112, r113, r117, r116, r35, r38);
        L66:
            r38 = r34;
            r35 = r31;
            goto L68
        L61:
            r31 = r33;
            goto L63
        L57:
            r116 = r32;
            goto L58
        L53:
            r24 = r30;
            goto L55
        L49:
            r113 = r29;
            goto L50
        L45:
            r112 = r28;
            goto L47
        L41:
            r111 = r27;
            goto L43
        L37:
            r110 = r26;
            goto L39
        L33:
            r15 = r25;
            goto L35
        L29:
            r14 = r23;
            goto L31
        L25:
            r13 = r22;
            goto L27
        L21:
            r12 = r21;
            goto L23
        L17:
            r11 = r20;
            goto L19
        L13:
            r10 = r19;
            goto L15
        L9:
            r8 = r18;
            goto L11
        L5:
            r4 = r17;
            goto L7
        }

        public final String component1() {
            return this.f11206id;
        }

        public final Long component10() {
            return this.ms;
        }

        public final String component11() {
            return this.f11205cc;
        }

        public final String component12() {
            return this.exitIp;
        }

        public final long component13() {
            return this.at;
        }

        public final String component14() {
            return this.error;
        }

        public final int component15() {
            return this.fails;
        }

        public final long component16() {
            return this.seen;
        }

        public final String component2() {
            return this.kind;
        }

        public final String component3() {
            return this.host;
        }

        public final int component4() {
            return this.port;
        }

        public final boolean component5() {
            return this.user;
        }

        public final String component6() {
            return this.profile;
        }

        public final long component7() {
            return this.verified;
        }

        public final Boolean component8() {
            return this.ok;
        }

        public final boolean component9() {
            return this.frozen;
        }

        public final Row copy(String r22, String r23, String r24, int r25, boolean r26, String r27, long r28, Boolean r30, boolean r31, Long r32, String r33, String r34, long r35, String r37, int r38, long r39) {
            j.e(r22, XrayCoreHostService.KEY_ID);
            j.e(r23, "kind");
            j.e(r24, "host");
            j.e(r27, "profile");
            j.e(r33, AwgProbeService.KEY_COUNTRY);
            j.e(r34, "exitIp");
            j.e(r37, "error");
            return new Row(r22, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Row) == true) goto L8;
            return false;
        L8:
            Row r10 = (Row) r8;
            if (j.a(this.f11206id, r10.f11206id) == true) goto L12;
            return false;
        L12:
            if (j.a(this.kind, r10.kind) == true) goto L15;
            return false;
        L15:
            if (j.a(this.host, r10.host) == true) goto L18;
            return false;
        L18:
            if (this.port == r10.port) goto L21;
            return false;
        L21:
            if (this.user == r10.user) goto L24;
            return false;
        L24:
            if (j.a(this.profile, r10.profile) == true) goto L27;
            return false;
        L27:
            if (this.verified == r10.verified) goto L30;
            return false;
        L30:
            if (j.a(this.ok, r10.ok) == true) goto L33;
            return false;
        L33:
            if (this.frozen == r10.frozen) goto L36;
            return false;
        L36:
            if (j.a(this.ms, r10.ms) == true) goto L39;
            return false;
        L39:
            if (j.a(this.f11205cc, r10.f11205cc) == true) goto L42;
            return false;
        L42:
            if (j.a(this.exitIp, r10.exitIp) == true) goto L45;
            return false;
        L45:
            if (this.at == r10.at) goto L48;
            return false;
        L48:
            if (j.a(this.error, r10.error) == true) goto L51;
            return false;
        L51:
            if (this.fails == r10.fails) goto L54;
            return false;
        L54:
            if (this.seen == r10.seen) goto L56;
            return false;
        L56:
            return true;
        }

        public final long getAt() {
            return this.at;
        }

        public final String getCc() {
            return this.f11205cc;
        }

        public final String getError() {
            return this.error;
        }

        public final String getExitIp() {
            return this.exitIp;
        }

        public final int getFails() {
            return this.fails;
        }

        public final boolean getFrozen() {
            return this.frozen;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getId() {
            return this.f11206id;
        }

        public final String getKind() {
            return this.kind;
        }

        public final Long getMs() {
            return this.ms;
        }

        public final Boolean getOk() {
            return this.ok;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final long getSeen() {
            return this.seen;
        }

        public final boolean getUser() {
            return this.user;
        }

        public final long getVerified() {
            return this.verified;
        }

        public int hashCode() {
            int r4 = w0.c(s.d(w0.d(androidx.compose.foundation.interaction.f.c(this.port, s.d(s.d(this.f11206id.hashCode() * 31, 31, this.kind), 31, this.host), 31), 31, this.user), 31, this.profile), 31, this.verified);
            Boolean r8 = this.ok;
            int r10 = 0;
            if (r8 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = w0.d((r4 + r11) * 31, 31, this.frozen);
            Long r13 = this.ms;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return Long.hashCode(this.seen) + androidx.compose.foundation.interaction.f.c(this.fails, s.d(w0.c(s.d(s.d((r12 + r10) * 31, 31, this.f11205cc), 31, this.exitIp), 31, this.at), 31, this.error), 31);
        L5:
            r11 = r8.hashCode();
            goto L6
        }

        public String toString() {
            String r4 = this.f11206id;
            String r8 = this.kind;
            String r10 = this.host;
            int r11 = this.port;
            boolean r12 = this.user;
            String r13 = this.profile;
            long r14 = this.verified;
            Boolean r15 = this.ok;
            boolean r16 = this.frozen;
            Long r17 = this.ms;
            String r18 = this.f11205cc;
            String r19 = this.exitIp;
            long r110 = this.at;
            String r111 = this.error;
            int r112 = this.fails;
            long r113 = this.seen;
            StringBuilder r20 = s.n("Row(id=", r4, ", kind=", r8, ", host=");
            f0.a.r(r11, r10, ", port=", ", user=", r20);
            i.x(", profile=", r13, ", verified=", r20, r12);
            r20.append(r14);
            r20.append(", ok=");
            r20.append(r15);
            r20.append(", frozen=");
            r20.append(r16);
            r20.append(", ms=");
            r20.append(r17);
            d1.x(r20, ", cc=", r18, ", exitIp=", r19);
            v0.a.k(r110, ", at=", ", error=", r20);
            f0.a.r(r112, r111, ", fails=", ", seen=", r20);
            return w0.k(r113, ")", r20);
        }

        public /* synthetic */ Row(String r23, String r24, String r25, int r26, boolean r27, String r28, long r29, Boolean r31, boolean r32, Long r33, String r34, String r35, long r36, String r38, int r39, long r40, int r42, kotlin.jvm.internal.e r43) {
            if ((r42 & 32768) == 0) goto L6;
            long r20 = 0;
        L7:
            this(r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r20);
            return;
        L6:
            r20 = r40;
            goto L7
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Source {
        public static final int $stable = 8;
        private final long addedAt;
        private final boolean builtin;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11207id;
        private final String label;
        private final String type;
        private final boolean user;
        private final List<String> value;

        public Source(String r4, String r8, List<String> r10, String r11, boolean r12, boolean r13, long r14) {
            j.e(r4, XrayCoreHostService.KEY_ID);
            j.e(r8, TeXSymbolParser.TYPE_ATTR);
            j.e(r10, "value");
            j.e(r11, "label");
            this.f11207id = r4;
            this.type = r8;
            this.value = r10;
            this.label = r11;
            this.builtin = r12;
            this.user = r13;
            this.addedAt = r14;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Source copy$default(Source r4, String r8, String r10, List r11, String r12, boolean r13, boolean r14, long r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L6;
            r8 = r4.f11207id;
        L6:
            if ((r16 & 2) == 0) goto L9;
            r10 = r4.type;
        L9:
            if ((r16 & 4) == 0) goto L12;
            r11 = r4.value;
        L12:
            if ((r16 & 8) == 0) goto L15;
            r12 = r4.label;
        L15:
            if ((r16 & 16) == 0) goto L18;
            r13 = r4.builtin;
        L18:
            if ((r16 & 32) == 0) goto L21;
            r14 = r4.user;
        L21:
            if ((r16 & 64) == 0) goto L23;
            r15 = r4.addedAt;
        L23:
            long r18 = r15;
            boolean r19 = r13;
            boolean r20 = r14;
            List r21 = r11;
            String r22 = r12;
            return r4.copy(r8, r10, r21, r22, r19, r20, r18);
        }

        public final String component1() {
            return this.f11207id;
        }

        public final String component2() {
            return this.type;
        }

        public final List<String> component3() {
            return this.value;
        }

        public final String component4() {
            return this.label;
        }

        public final boolean component5() {
            return this.builtin;
        }

        public final boolean component6() {
            return this.user;
        }

        public final long component7() {
            return this.addedAt;
        }

        public final Source copy(String r11, String r12, List<String> r13, String r14, boolean r15, boolean r16, long r17) {
            j.e(r11, XrayCoreHostService.KEY_ID);
            j.e(r12, TeXSymbolParser.TYPE_ATTR);
            j.e(r13, "value");
            j.e(r14, "label");
            return new Source(r11, r12, r13, r14, r15, r16, r17);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Source) == true) goto L8;
            return false;
        L8:
            Source r10 = (Source) r8;
            if (j.a(this.f11207id, r10.f11207id) == true) goto L12;
            return false;
        L12:
            if (j.a(this.type, r10.type) == true) goto L15;
            return false;
        L15:
            if (j.a(this.value, r10.value) == true) goto L18;
            return false;
        L18:
            if (j.a(this.label, r10.label) == true) goto L21;
            return false;
        L21:
            if (this.builtin == r10.builtin) goto L24;
            return false;
        L24:
            if (this.user == r10.user) goto L27;
            return false;
        L27:
            if (this.addedAt == r10.addedAt) goto L29;
            return false;
        L29:
            return true;
        }

        public final long getAddedAt() {
            return this.addedAt;
        }

        public final boolean getBuiltin() {
            return this.builtin;
        }

        public final String getId() {
            return this.f11207id;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getType() {
            return this.type;
        }

        public final boolean getUser() {
            return this.user;
        }

        public final List<String> getValue() {
            return this.value;
        }

        public int hashCode() {
            int r4 = w0.d(w0.d(s.d(androidx.compose.foundation.interaction.f.f(s.d(this.f11207id.hashCode() * 31, 31, this.type), 31, this.value), 31, this.label), 31, this.builtin), 31, this.user);
            return Long.hashCode(this.addedAt) + r4;
        }

        public String toString() {
            String r4 = this.f11207id;
            String r8 = this.type;
            List<String> r10 = this.value;
            String r11 = this.label;
            boolean r12 = this.builtin;
            boolean r13 = this.user;
            long r14 = this.addedAt;
            StringBuilder r15 = s.n("Source(id=", r4, ", type=", r8, ", value=");
            r15.append(r10);
            r15.append(", label=");
            r15.append(r11);
            r15.append(", builtin=");
            s.x(r15, r12, ", user=", r13, ", addedAt=");
            return w0.k(r14, ")", r15);
        }

        public /* synthetic */ Source(String r4, String r8, List r10, String r11, boolean r12, boolean r13, long r14, int r15, kotlin.jvm.internal.e r16) {
            if ((r15 & 16) == 0) goto L6;
            r12 = false;
        L6:
            if ((r15 & 32) == 0) goto L9;
            r13 = false;
        L9:
            if ((r15 & 64) == 0) goto L11;
            r14 = 0;
        L11:
            long r17 = r14;
            this(r4, r8, r10, r11, r12, r13, r17);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class SourceView {
        public static final int $stable = 8;
        private final long at;
        private final String error;
        private final int found;
        private final boolean on;
        private final Source src;
        private final int total;

        public SourceView(Source r4, boolean r8, long r10, int r11, int r12, String r13) {
            j.e(r4, "src");
            j.e(r13, "error");
            this.src = r4;
            this.on = r8;
            this.at = r10;
            this.found = r11;
            this.total = r12;
            this.error = r13;
        }

        public static /* synthetic */ SourceView copy$default(SourceView r4, Source r8, boolean r10, long r11, int r12, int r13, String r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r8 = r4.src;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r10 = r4.on;
        L9:
            if ((r15 & 4) == 0) goto L12;
            r11 = r4.at;
        L12:
            if ((r15 & 8) == 0) goto L15;
            r12 = r4.found;
        L15:
            if ((r15 & 16) == 0) goto L18;
            r13 = r4.total;
        L18:
            if ((r15 & 32) == 0) goto L20;
            r14 = r4.error;
        L20:
            String r17 = r14;
            int r18 = r12;
            long r19 = r11;
            Source r20 = r8;
            boolean r21 = r10;
            return r4.copy(r20, r21, r19, r18, r13, r17);
        }

        public final Source component1() {
            return this.src;
        }

        public final boolean component2() {
            return this.on;
        }

        public final long component3() {
            return this.at;
        }

        public final int component4() {
            return this.found;
        }

        public final int component5() {
            return this.total;
        }

        public final String component6() {
            return this.error;
        }

        public final SourceView copy(Source r10, boolean r11, long r12, int r14, int r15, String r16) {
            j.e(r10, "src");
            j.e(r16, "error");
            return new SourceView(r10, r11, r12, r14, r15, r16);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof SourceView) == true) goto L8;
            return false;
        L8:
            SourceView r10 = (SourceView) r8;
            if (j.a(this.src, r10.src) == true) goto L12;
            return false;
        L12:
            if (this.on == r10.on) goto L15;
            return false;
        L15:
            if (this.at == r10.at) goto L18;
            return false;
        L18:
            if (this.found == r10.found) goto L21;
            return false;
        L21:
            if (this.total == r10.total) goto L24;
            return false;
        L24:
            if (j.a(this.error, r10.error) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final long getAt() {
            return this.at;
        }

        public final String getError() {
            return this.error;
        }

        public final int getFound() {
            return this.found;
        }

        public final boolean getOn() {
            return this.on;
        }

        public final Source getSrc() {
            return this.src;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            int r4 = w0.c(w0.d(this.src.hashCode() * 31, 31, this.on), 31, this.at);
            int r8 = androidx.compose.foundation.interaction.f.c(this.found, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.total, r8, 31);
            return this.error.hashCode() + r10;
        }

        public String toString() {
            Source r4 = this.src;
            boolean r8 = this.on;
            long r10 = this.at;
            int r11 = this.found;
            int r12 = this.total;
            String r13 = this.error;
            StringBuilder r14 = new StringBuilder("SourceView(src=");
            r14.append(r4);
            r14.append(", on=");
            r14.append(r8);
            r14.append(", at=");
            s.p(r11, r10, ", found=", r14);
            r14.append(", total=");
            r14.append(r12);
            r14.append(", error=");
            r14.append(r13);
            r14.append(")");
            return r14.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Summary {
        public static final int $stable = 8;
        private final List<CleanIp> cleanList;
        private final Counts counts;
        private final List<ArgoProtocol.FalconOrigin> falconList;
        private final int falconServers;
        private final List<Group> groups;
        private final Prefs prefs;

        public Summary(Counts r8, List r10, Prefs r11, List r12, int r13, List r14, int r15, kotlin.jvm.internal.e r16) {
            if ((r15 & 32) == 0) goto L5;
            r14 = w.INSTANCE;
        L5:
            this(r8, r10, r11, r12, r13, r14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Summary copy$default(Summary r4, Counts r8, List r10, Prefs r11, List r12, int r13, List r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r8 = r4.counts;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r10 = r4.groups;
        L9:
            if ((r15 & 4) == 0) goto L12;
            r11 = r4.prefs;
        L12:
            if ((r15 & 8) == 0) goto L15;
            r12 = r4.cleanList;
        L15:
            if ((r15 & 16) == 0) goto L18;
            r13 = r4.falconServers;
        L18:
            if ((r15 & 32) == 0) goto L20;
            r14 = r4.falconList;
        L20:
            int r17 = r13;
            List r18 = r14;
            Prefs r19 = r11;
            List r20 = r12;
            return r4.copy(r8, r10, r19, r20, r17, r18);
        }

        public final Counts component1() {
            return this.counts;
        }

        public final List<Group> component2() {
            return this.groups;
        }

        public final Prefs component3() {
            return this.prefs;
        }

        public final List<CleanIp> component4() {
            return this.cleanList;
        }

        public final int component5() {
            return this.falconServers;
        }

        public final List<ArgoProtocol.FalconOrigin> component6() {
            return this.falconList;
        }

        public final Summary copy(Counts r10, List<Group> r11, Prefs r12, List<CleanIp> r13, int r14, List<ArgoProtocol.FalconOrigin> r15) {
            j.e(r10, "counts");
            j.e(r11, "groups");
            j.e(r12, "prefs");
            j.e(r13, "cleanList");
            j.e(r15, "falconList");
            return new Summary(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Summary) == true) goto L8;
            return false;
        L8:
            Summary r10 = (Summary) r8;
            if (j.a(this.counts, r10.counts) == true) goto L12;
            return false;
        L12:
            if (j.a(this.groups, r10.groups) == true) goto L15;
            return false;
        L15:
            if (j.a(this.prefs, r10.prefs) == true) goto L18;
            return false;
        L18:
            if (j.a(this.cleanList, r10.cleanList) == true) goto L21;
            return false;
        L21:
            if (this.falconServers == r10.falconServers) goto L24;
            return false;
        L24:
            if (j.a(this.falconList, r10.falconList) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final List<CleanIp> getCleanList() {
            return this.cleanList;
        }

        public final Counts getCounts() {
            return this.counts;
        }

        public final List<ArgoProtocol.FalconOrigin> getFalconList() {
            return this.falconList;
        }

        public final int getFalconServers() {
            return this.falconServers;
        }

        public final List<Group> getGroups() {
            return this.groups;
        }

        public final Prefs getPrefs() {
            return this.prefs;
        }

        public int hashCode() {
            int r4 = androidx.compose.foundation.interaction.f.f(this.counts.hashCode() * 31, 31, this.groups);
            int r8 = androidx.compose.foundation.interaction.f.f((this.prefs.hashCode() + r4) * 31, 31, this.cleanList);
            int r10 = androidx.compose.foundation.interaction.f.c(this.falconServers, r8, 31);
            return this.falconList.hashCode() + r10;
        }

        public String toString() {
            return "Summary(counts=" + this.counts + ", groups=" + this.groups + ", prefs=" + this.prefs + ", cleanList=" + this.cleanList + ", falconServers=" + this.falconServers + ", falconList=" + this.falconList + ")";
        }

        public Summary(Counts r4, List<Group> r8, Prefs r10, List<CleanIp> r11, int r12, List<ArgoProtocol.FalconOrigin> r13) {
            j.e(r4, "counts");
            j.e(r8, "groups");
            j.e(r10, "prefs");
            j.e(r11, "cleanList");
            j.e(r13, "falconList");
            this.counts = r4;
            this.groups = r8;
            this.prefs = r10;
            this.cleanList = r11;
            this.falconServers = r12;
            this.falconList = r13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        private volatile boolean carried;
        private final String ip;
        private final String loc;
        private final boolean ok;

        public Trace(boolean r4, String r8, String r10) {
            j.e(r8, "loc");
            j.e(r10, "ip");
            this.ok = r4;
            this.loc = r8;
            this.ip = r10;
        }

        public final boolean getCarried() {
            return this.carried;
        }

        public final String getIp() {
            return this.ip;
        }

        public final String getLoc() {
            return this.loc;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final void setCarried(boolean r4) {
            this.carried = r4;
        }

        public /* synthetic */ Trace(boolean r4, String r8, String r10, int r11, kotlin.jvm.internal.e r12) {
            if ((r11 & 2) == 0) goto L6;
            r8 = "";
        L6:
            if ((r11 & 4) == 0) goto L8;
            r10 = "";
        L8:
            this(r4, r8, r10);
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
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ArgoPool this$0;

        public AnonymousClass1(ArgoPool r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.access$harvestTelegram(this.this$0, null, 0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2", f = "ArgoPool.kt", l = {575, 583, NetworkSettings.MIN_MTU, 577, 578, 580, 583, 583}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        final /* synthetic */ List<Ready> $batch;
        final /* synthetic */ String $connectIp;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$5", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends xd.j implements ee.e {
            final /* synthetic */ VlessXrayInjector $core;
            private /* synthetic */ Object L$0;
            int label;

            public AnonymousClass5(VlessXrayInjector r4, wd.d r8) {
                this.$core = r4;
                super(2, r8);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                AnonymousClass5 r10 = new AnonymousClass5(this.$core, r8);
                r10.L$0 = r4;
                return r10;
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r4) {
                kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) goto L12;
                m.b(r4);
                i0 r10 = (i0) this.L$0;
                this.$core.stop();     // Catch: Throwable -> L7
                Object r11 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L7
            L10:
                return sd.l.m1003boximpl(r11);
            L7:
                th = move-exception;
                r11 = sd.l.m1004constructorimpl(m.a(th));
                goto L10
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((AnonymousClass5) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        public AnonymousClass2(List<Ready> r4, String r8, wd.d r10) {
            this.$batch = r4;
            this.$connectIp = r8;
            super(2, r10);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            AnonymousClass2 r10 = new AnonymousClass2(this.$batch, this.$connectIp, r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x004c: MOVE (r3 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:77), block:B:18:0x004c */
        @Override // xd.a
        public final Object invokeSuspend(Object r24) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            switch(this.label) {
                case 0: goto L30;
                case 1: goto L27;
                case 2: goto L7;
                case 3: goto L23;
                case 4: goto L19;
                case 5: goto L14;
                case 6: goto L9;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            Throwable r8 = (Throwable) this.L$0;
            m.b(r24);
            throw r8;
        L7:
            List r10 = (List) this.L$0;
            m.b(r24);
            return r10;
        L9:
            List r11 = (List) this.L$1;
            VlessXrayInjector r12 = (VlessXrayInjector) this.L$0;
            m.b(r24);     // Catch: Throwable -> L12
        L93:
            wd.i r13 = m2.f24144a.plus(v0.f24208c);
            AnonymousClass5 r14 = new AnonymousClass5(r12, null);
            this.L$0 = r11;
            this.L$1 = null;
            this.label = 7;
            if (m0.J(r13, r14, this) == r4) goto L103;
            return r11;
        L103:
            return r4;
        L14:
            r11 = (List) this.L$3;
            VlessXrayInjector r15 = (VlessXrayInjector) this.L$2;
            List r16 = (List) this.L$1;
            i0 r17 = (i0) this.L$0;
            m.b(r24);     // Catch: Throwable -> L17
            r12 = r15;
            int r18 = 0;
        L82:
            List<Ready> r19 = this.$batch;     // Catch: Throwable -> L12
            ArrayList r20 = new ArrayList(kotlin.collections.s.g0(r19, 10));     // Catch: Throwable -> L12
            Iterator<T> r21 = r19.iterator();     // Catch: Throwable -> L12
        L84:
            if (r21.hasNext() == false) goto L90;
            Object r22 = r21.next();     // Catch: Throwable -> L12
            int r23 = r18 + 1;     // Catch: Throwable -> L12
            if (r18 < 0) goto L88;
            r20.add(m0.c(r17, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) r22, r16, r18, null), 2));     // Catch: Throwable -> L12
            r18 = r23;
            goto L84
        L88:
            r.f0();     // Catch: Throwable -> L12
            throw null;     // Catch: Throwable -> L12
        L90:
            this.L$0 = r12;     // Catch: Throwable -> L12
            this.L$1 = r11;     // Catch: Throwable -> L12
            this.L$2 = null;     // Catch: Throwable -> L12
            this.L$3 = null;     // Catch: Throwable -> L12
            this.label = 6;     // Catch: Throwable -> L12
            if (m0.d(r20, this) != r4) goto L93;
        L19:
            VlessXrayInjector r25 = (VlessXrayInjector) this.L$2;
            List r26 = (List) this.L$1;
            i0 r27 = (i0) this.L$0;
            m.b(r24);     // Catch: Throwable -> L17
            Object r28 = r24;
            r12 = r25;
            r18 = 0;
        L22:
            r17 = r27;
            r16 = r26;
            List r29 = (List) r28;     // Catch: Throwable -> L12
            List r30 = r29;     // Catch: Throwable -> L12
            ArrayList r31 = new ArrayList(kotlin.collections.s.g0(r30, 10));     // Catch: Throwable -> L12
            Iterator r32 = r30.iterator();     // Catch: Throwable -> L12
            int r33 = r18;
        L72:
            if (r32.hasNext() == false) goto L78;
            Object r34 = r32.next();     // Catch: Throwable -> L12
            int r110 = r33 + 1;     // Catch: Throwable -> L12
            if (r33 < 0) goto L76;
            r31.add(m0.c(r17, v0.f24208c, new ArgoPool$measureExits$2$3$1((Trace) r34, r16, r33, null), 2));     // Catch: Throwable -> L12
            r33 = r110;
            goto L72
        L76:
            r.f0();     // Catch: Throwable -> L12
            throw null;     // Catch: Throwable -> L12
        L78:
            this.L$0 = r17;     // Catch: Throwable -> L12
            this.L$1 = r16;     // Catch: Throwable -> L12
            this.L$2 = r12;     // Catch: Throwable -> L12
            this.L$3 = r29;     // Catch: Throwable -> L12
            this.label = 5;     // Catch: Throwable -> L12
            if (m0.d(r31, this) == r4) goto L103;
            r11 = r29;
            goto L82
        L23:
            VlessXrayInjector r35 = (VlessXrayInjector) this.L$2;
            r26 = (List) this.L$1;
            r27 = (i0) this.L$0;
            m.b(r24);     // Catch: Throwable -> L17
            r18 = 0;
        L26:
            r12 = r35;
            h r36 = r.Y(this.$batch);     // Catch: Throwable -> L12
            ArrayList r37 = new ArrayList(kotlin.collections.s.g0(r36, 10));     // Catch: Throwable -> L12
            g r38 = r36.a();     // Catch: Throwable -> L12
        L65:
            if (r38.f23130c == false) goto L67;
            r37.add(m0.c(r27, v0.f24208c, new ArgoPool$measureExits$2$out$1$1(r26, r38.nextInt(), null), 2));     // Catch: Throwable -> L12
            goto L65
        L67:
            this.L$0 = r27;     // Catch: Throwable -> L12
            this.L$1 = r26;     // Catch: Throwable -> L12
            this.L$2 = r12;     // Catch: Throwable -> L12
            this.label = 4;     // Catch: Throwable -> L12
            r28 = m0.d(r37, this);     // Catch: Throwable -> L12
            if (r28 != r4) goto L22;
        L27:
            r35 = (VlessXrayInjector) this.L$2;
            r26 = (List) this.L$1;
            r27 = (i0) this.L$0;
            m.b(r24);     // Catch: Throwable -> L17
            Object r39 = r24;
            wd.d r210 = null;
        L50:
            if (((Boolean) r39).booleanValue() == true) goto L60;
            List<Ready> r40 = this.$batch;     // Catch: Throwable -> L17
            ArrayList r41 = new ArrayList(kotlin.collections.s.g0(r40, 10));     // Catch: Throwable -> L17
            Iterator<T> r42 = r40.iterator();     // Catch: Throwable -> L17
        L53:
            if (r42.hasNext() == false) goto L56;
            Ready r43 = (Ready) r42.next();     // Catch: Throwable -> L17
            r41.add(new Trace(false, null, null, 6, null));     // Catch: Throwable -> L17
            goto L53
        L56:
            wd.i r44 = m2.f24144a.plus(v0.f24208c);
            wd.d r45 = r210;
            AnonymousClass5 r46 = new AnonymousClass5(r35, r45);
            this.L$0 = r41;
            this.L$1 = r45;
            this.L$2 = r45;
            this.label = 2;
            if (m0.J(r44, r46, this) == r4) goto L103;
            return r41;
        L60:
            ArgoPool r47 = ArgoPool.INSTANCE;     // Catch: Throwable -> L17
            r18 = 0;
            int r48 = ((Number) r26.get(0)).intValue();     // Catch: Throwable -> L17
            this.L$0 = r27;     // Catch: Throwable -> L17
            this.L$1 = r26;     // Catch: Throwable -> L17
            this.L$2 = r35;     // Catch: Throwable -> L17
            this.label = 3;     // Catch: Throwable -> L17
            if (ArgoPool.access$waitPort(r47, r48, 5000, this) != r4) goto L26;
        L30:
            m.b(r24);
            i0 r49 = (i0) this.L$0;
            List<Ready> r50 = this.$batch;
            ArrayList r51 = new ArrayList(kotlin.collections.s.g0(r50, 10));
            Iterator<T> r52 = r50.iterator();
        L32:
            if (r52.hasNext() == false) goto L34;
            Ready r53 = (Ready) r52.next();
            r51.add(new Integer(ArgoPool.access$freePort(ArgoPool.INSTANCE)));
            goto L32
        L34:
            sf.a r54 = new sf.a();
            sf.a r55 = new sf.a();
            sf.a r111 = new sf.a();
            List<Ready> r112 = this.$batch;
            String r113 = this.$connectIp;
            Iterator<T> r114 = r112.iterator();
            int r115 = 0;
        L36:
            if (r114.hasNext() == false) goto L42;
            Object r116 = r114.next();
            int r211 = r115 + 1;
            if (r115 < 0) goto L40;
            Ready r117 = (Ready) r116;
            sf.c r56 = new sf.c();
            r56.D("tag", "in" + r115);
            r56.D("listen", SniSession.LOCAL_HOST);
            r56.D(PsiphonProbeService.PORT, Integer.valueOf(((Number) r51.get(r115)).intValue()));
            r56.D("protocol", "socks");
            sf.c r57 = new sf.c();
            r57.E("udp", false);
            r56.D("settings", r57);
            r54.put(r56);
            String r118 = r113;
            int r212 = r115;
            r55.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, r117.getEp(), r117.getInfo(), f0.a.h(r115, "out"), r118, null, 16, null));
            sf.c r58 = new sf.c();
            r58.D(TeXSymbolParser.TYPE_ATTR, "field");
            sf.a r119 = new sf.a();
            r119.put("in" + r212);
            r58.D("inboundTag", r119);
            r58.D("outboundTag", "out" + r212);
            r111.put(r58);
            r113 = r118;
            r115 = r211;
            goto L36
        L40:
            r.f0();
            throw null;
        L42:
            r210 = null;
            sf.c r59 = new sf.c();
            r59.D("tag", "block");
            r59.D("protocol", "blackhole");
            r55.put(r59);
            sf.c r60 = new sf.c();
            sf.c r61 = new sf.c();
            r61.D("loglevel", "none");
            r60.D(XrayCoreHostService.KEY_LOG, r61);
            r60.D("inbounds", r54);
            r60.D("outbounds", r55);
            sf.c r62 = new sf.c();
            r62.D("domainStrategy", "AsIs");
            r62.D("rules", r111);
            String r63 = com.mlmvpn.scanner.e.h(r60, "routing", r62, "toString(...)");
            VlessXrayInjector r64 = new VlessXrayInjector(0, null, true, 2, null);
            Context r65 = ArgoPool.access$getApp$p();     // Catch: Throwable -> L97
            if (r65 == null) goto L99;
            this.L$0 = r49;     // Catch: Throwable -> L97
            this.L$1 = r51;     // Catch: Throwable -> L97
            this.L$2 = r64;     // Catch: Throwable -> L97
            this.label = 1;     // Catch: Throwable -> L97
            r39 = r64.start(r65, r63, 0, this);     // Catch: Throwable -> L97
            if (r39 == r4) goto L103;
            r27 = r49;
            r26 = r51;
            r35 = r64;
            goto L50
        L99:
            j.k("app");     // Catch: Throwable -> L97
            throw null;     // Catch: Throwable -> L97
        L97:
            th = th;
            VlessXrayInjector r66 = r64;
        L101:
            wd.i r67 = m2.f24144a.plus(v0.f24208c);
            AnonymousClass5 r68 = new AnonymousClass5(r66, null);
            this.L$0 = th;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 8;
            if (m0.J(r67, r68, this) == r4) goto L103;
            throw th;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            th = th;
        L17:
            th = th;
            r66 = r7;
            goto L101
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass2) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1", f = "ArgoPool.kt", l = {198}, m = "invokeSuspend")
    public static final class C03981 extends xd.j implements ee.e {
        int label;

        public C03981(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C03981(r8);
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
        L11:
            ArgoPool.access$setSaveQueued$p(false);
            ArgoPool.INSTANCE.saveNow();
            return u.f67154a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            m.b(r4);
            this.label = 1;
            if (m0.j(1500, this) != r8) goto L11;
            return r8;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C03981) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1", f = "ArgoPool.kt", l = {746, 766, 776}, m = "invokeSuspend")
    public static final class C03991 extends xd.j implements ee.e {
        final /* synthetic */ int $count;
        final /* synthetic */ List<Item> $refs;
        final /* synthetic */ boolean $v6;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        public C03991(int r4, boolean r8, List<Item> r10, wd.d r11) {
            this.$count = r4;
            this.$v6 = r8;
            this.$refs = r10;
            super(2, r11);
        }

        public static /* synthetic */ boolean d(String r4) {
            return invokeSuspend$lambda$2(r4);
        }

        private static final boolean invokeSuspend$lambda$2(String r4) {
            return o.z0(r4, ':');
        }

        @Override // xd.a
        public final wd.d create(Object r8, wd.d r10) {
            C03991 r4 = new C03991(this.$count, this.$v6, this.$refs, r10);
            r4.L$0 = r8;
            return r4;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x03a5 -> B:188:0x03ae). Please report as a decompilation issue!!! */
        @Override // xd.a
        public final Object invokeSuspend(Object r38) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            List r10 = null;
            if (r8 == 0) goto L20;
            if (r8 == 1) goto L17;
            if (r8 == 2) goto L14;
            if (r8 != 3) goto L13;
            long r11 = this.J$0;
            int r12 = this.I$1;
            int r13 = this.I$0;
            String r14 = (String) this.L$7;
            Iterator r15 = (Iterator) this.L$6;
            List r16 = (List) this.L$5;
            List r17 = (List) this.L$4;
            Map r18 = (Map) this.L$3;
            List r19 = (List) this.L$2;
            ee.c r20 = (ee.c) this.L$1;
            List r21 = (List) this.L$0;
            m.b(r38);     // Catch: Throwable -> L10
            kotlin.coroutines.intrinsics.a r22 = r4;
            List r23 = r19;
            long r28 = r11;
            Object r24 = r38;
            ee.c r25 = r20;
            Map r26 = r18;
            List r27 = r21;
            List r29 = r17;
            int r30 = r12;
        L188:
            Long r31 = (Long) r24;     // Catch: Throwable -> L97
            if (r31 == null) goto L101;
            Long r110 = (Long) r26.get(r14);     // Catch: Throwable -> L97
            if (r110 == null) goto L99;
            long r111 = r110.longValue();     // Catch: Throwable -> L97
        L100:
            r16.add(new CleanIp(r14, r111, r28, r31.longValue(), null, 16, null));     // Catch: Throwable -> L97
            goto L101
        L99:
            r111 = 0;
        L101:
            ArgoPool r32 = ArgoPool.INSTANCE;     // Catch: Throwable -> L97
            IpScan r210 = r32.getIpScan();     // Catch: Throwable -> L97
            if (r210 == null) goto L104;
            IpScan r33 = IpScan.copy$default(r210, false, null, r30 + 1, 0, q.b1(r16, new ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$1()), null, null, null, 0, 491, null);     // Catch: Throwable -> L97
        L105:
            ArgoPool.access$setIpScan$p(r33);     // Catch: Throwable -> L97
            ArgoPool.access$changed(r32);     // Catch: Throwable -> L97
            r4 = r22;
            List r34 = r29;
            List r35 = r27;
            Map r36 = r26;
            ee.c r37 = r25;
            List r39 = r23;
            int r40 = r13;
            r10 = null;
        L82:
            if (r15.hasNext() == false) goto L106;
            r13 = r40 + 1;
            sd.q r112 = (sd.q) r15.next();     // Catch: Throwable -> L97
            if (ArgoPool.access$getScanCancel$p() == true) goto L106;
            r14 = (String) r112.component1();     // Catch: Throwable -> L97
            long r41 = ((Number) r112.component2()).longValue();     // Catch: Throwable -> L97
            sd.j r113 = (sd.j) r112.component3();     // Catch: Throwable -> L97
            Item r42 = (Item) r113.component1();     // Catch: Throwable -> L97
            ArgoProtocol.SessionInfo r114 = (ArgoProtocol.SessionInfo) r113.component2();     // Catch: Throwable -> L97
            kotlin.coroutines.intrinsics.a r211 = r4;
            ArgoPool r43 = ArgoPool.INSTANCE;     // Catch: Throwable -> L97
            this.L$0 = r35;     // Catch: Throwable -> L97
            this.L$1 = r37;     // Catch: Throwable -> L97
            this.L$2 = r39;     // Catch: Throwable -> L97
            this.L$3 = r36;     // Catch: Throwable -> L97
            this.L$4 = r34;     // Catch: Throwable -> L97
            this.L$5 = r16;     // Catch: Throwable -> L97
            this.L$6 = r15;     // Catch: Throwable -> L97
            this.L$7 = r14;     // Catch: Throwable -> L97
            this.I$0 = r13;     // Catch: Throwable -> L97
            this.I$1 = r40;     // Catch: Throwable -> L97
            this.J$0 = r41;     // Catch: Throwable -> L97
            int r310 = r40;
            this.label = 3;     // Catch: Throwable -> L97
            r24 = ArgoPool.access$speedThrough(r43, r14, r42, r114, this);     // Catch: Throwable -> L97
            r22 = r211;
            if (r24 == r22) goto L226;
            r28 = r41;
            r23 = r39;
            r25 = r37;
            r26 = r36;
            r27 = r35;
            r29 = r34;
            r30 = r310;
            goto L188
        L226:
            return r22;
        L106:
            List r212 = q.b1(r16, new ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedByDescending$2());     // Catch: Throwable -> L97
            List r44 = r34;     // Catch: Throwable -> L97
            if ((r44 instanceof Collection) == true) goto L109;
        L111:
            Iterator r45 = r44.iterator();     // Catch: Throwable -> L97
        L113:
            if (r45.hasNext() == false) goto L128;
            if (((Boolean) r37.invoke(((sd.q) r45.next()).getFirst())).booleanValue() == true) goto L113;
            List r46 = r212;     // Catch: Throwable -> L97
            if ((r46 instanceof Collection) == true) goto L119;
        L121:
            Iterator r47 = r46.iterator();     // Catch: Throwable -> L97
        L123:
            if (r47.hasNext() == false) goto L127;
            if (((Boolean) r37.invoke(((CleanIp) r47.next()).getIp())).booleanValue() == true) goto L123;
        L127:
            boolean r48 = true;
        L129:
            if (r48 == true) goto L131;
        L134:
            String r49 = "";
        L133:
            String r311 = r49;
            if (r212.isEmpty() == true) goto L138;
        L148:
            String r50 = "";
        L142:
            String r312 = r50;
            ArgoPool r51 = ArgoPool.INSTANCE;     // Catch: Throwable -> L97
            List<Item> r52 = this.$refs;     // Catch: Throwable -> L97
            monitor-enter(r51);     // Catch: Throwable -> L97
            sf.c r53 = new sf.c();     // Catch: Throwable -> L155
            r53.D("at", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L155
            r53.D("ref", r52.get(0).getHost());     // Catch: Throwable -> L155
            List r54 = q.e1(r212, 12);     // Catch: Throwable -> L155
            ArrayList r55 = new ArrayList(kotlin.collections.s.g0(r54, 10));     // Catch: Throwable -> L155
            Iterator r56 = r54.iterator();     // Catch: Throwable -> L155
        L153:
            if (r56.hasNext() == false) goto L157;
            CleanIp r57 = (CleanIp) r56.next();     // Catch: Throwable -> L155
            sf.c r58 = new sf.c();     // Catch: Throwable -> L155
            r58.D("ip", r57.getIp());     // Catch: Throwable -> L155
            r58.D("tls", Long.valueOf(r57.getTls()));     // Catch: Throwable -> L155
            r58.D("auth", Long.valueOf(r57.getAuth()));     // Catch: Throwable -> L155
            r58.D("kbps", Long.valueOf(r57.getKbps()));     // Catch: Throwable -> L155
            r55.add(r58);     // Catch: Throwable -> L155
            goto L153
        L157:
            r53.D("list", new sf.a(r55));     // Catch: Throwable -> L155
            ArgoPool.access$setCleanScan$p(r53);     // Catch: Throwable -> L155
            if (r212.isEmpty() == false) goto L160;
        L166:
            IpScan r59 = null;
        L167:
            ArgoPool r60 = ArgoPool.INSTANCE;     // Catch: Throwable -> L164
            ArgoPool.access$savePrefs(r60);     // Catch: Throwable -> L164
            monitor-exit(r51);     // Catch: Throwable -> L172
            IpScan r213 = r60.getIpScan();     // Catch: Throwable -> L172
            if (r213 == null) goto L174;
            IpScan r61 = IpScan.copy$default(r213, false, null, 0, 0, r212, null, r312, r311, System.currentTimeMillis(), 46, null);     // Catch: Throwable -> L172
        L175:
            ArgoPool.access$setIpScan$p(r61);     // Catch: Throwable -> L172
        L186:
            ArgoPool.access$changed(ArgoPool.INSTANCE);
            return u.f67154a;
        L174:
            r61 = r59;
        L164:
            th = th;
        L176:
            monitor-exit(r51);     // Catch: Throwable -> L172
            throw th;     // Catch: Throwable -> L172
        L160:
            if (ArgoPool.access$getPrefs$p().getAutoClean() == false) goto L166;
            r59 = null;
            ArgoPool.access$setPrefs$p(Prefs.copy$default(ArgoPool.access$getPrefs$p(), ((CleanIp) q.y0(r212)).getIp(), false, 2, null));     // Catch: Throwable -> L164
        L155:
            th = th;
        L172:
            th = th;
        L178:
            IpScan r62 = ArgoPool.INSTANCE.getIpScan();
            if (r62 == null) goto L184;
            String r63 = th.getMessage();
            if (r63 != null) goto L183;
            r63 = "";
        L183:
            IpScan r64 = IpScan.copy$default(r62, false, null, 0, 0, null, null, r63, null, System.currentTimeMillis(), 190, null);
        L185:
            ArgoPool.access$setIpScan$p(r64);
            goto L186
        L184:
            r64 = r35;
            goto L185
        L138:
            if (ArgoPool.access$getScanCancel$p() == true) goto L148;
            if (r35.isEmpty() == false) goto L143;
            r50 = "هیچ آی\u200cپی کلادفلری از این اینترنت جواب نداد";
            goto L142
        L143:
            if (r48 == true) goto L145;
        L147:
            r50 = "آی\u200cپی\u200cهایی جواب دادند ولی هیچ\u200cکدام داده رد نکرد — دوباره با تعداد بیشتر امتحان کنید";
            goto L142
        L145:
            if (r39.isEmpty() == false) goto L147;
            r50 = "آی\u200cپی\u200cهای IPv4 جواب دادند ولی وسط دانلود قطع شدند، و این سیستم IPv6 ندارد — روی این اینترنت فعلاً راهی از کلادفلر نیست";
            goto L142
        L131:
            if (r212.isEmpty() == true) goto L134;
            r49 = "روی این اینترنت لبهٔ IPv4 کلادفلر وسط دانلود قطع می\u200cشود؛ فقط IPv6 داده رد می\u200cکند.";
            goto L133
        L119:
            if (r46.isEmpty() == false) goto L121;
        L128:
            r48 = false;
            goto L129
        L109:
            if (r44.isEmpty() == false) goto L111;
        L104:
            r33 = null;
        L97:
            th = th;
            r35 = null;
            goto L178
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            Map r65 = (Map) this.L$4;
            List r66 = (List) this.L$3;
            List r67 = (List) this.L$2;
            ee.c r68 = (ee.c) this.L$1;
            List r69 = (List) this.L$0;
            m.b(r38);     // Catch: Throwable -> L10
        L65:
            j.b(r66);     // Catch: Throwable -> L10
            List r70 = q.b1(r66, new ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$2());     // Catch: Throwable -> L10
            ArrayList r115 = new ArrayList();     // Catch: Throwable -> L10
            Iterator r71 = r70.iterator();     // Catch: Throwable -> L10
        L67:
            if (r71.hasNext() == false) goto L71;
            Object r116 = r71.next();     // Catch: Throwable -> L10
            if (((Boolean) r68.invoke(((sd.q) r116).getFirst())).booleanValue() == true) goto L67;
            r115.add(r116);     // Catch: Throwable -> L10
            goto L67
        L71:
            List r117 = q.e1(r115, 4);     // Catch: Throwable -> L10
            ArrayList r118 = new ArrayList();     // Catch: Throwable -> L10
            Iterator r72 = r70.iterator();     // Catch: Throwable -> L10
        L73:
            if (r72.hasNext() == false) goto L77;
            Object r119 = r72.next();     // Catch: Throwable -> L10
            if (((Boolean) r68.invoke(((sd.q) r119).getFirst())).booleanValue() == false) goto L73;
            r118.add(r119);     // Catch: Throwable -> L10
            goto L73
        L77:
            ArrayList r73 = q.S0(r117, q.e1(r118, 4));     // Catch: Throwable -> L10
            ArgoPool r74 = ArgoPool.INSTANCE;     // Catch: Throwable -> L10
            IpScan r214 = r74.getIpScan();     // Catch: Throwable -> L10
            if (r214 == null) goto L80;
            IpScan r120 = IpScan.copy$default(r214, false, "speed", 0, r73.size(), null, null, null, null, 0, 497, null);     // Catch: Throwable -> L10
        L81:
            ArgoPool.access$setIpScan$p(r120);     // Catch: Throwable -> L10
            ArgoPool.access$changed(r74);     // Catch: Throwable -> L10
            r16 = new ArrayList();     // Catch: Throwable -> L10
            r15 = r73.iterator();     // Catch: Throwable -> L10
            r39 = r67;
            r35 = r69;
            r37 = r68;
            r36 = r65;
            r40 = 0;
            r34 = r73;
            goto L82
        L80:
            r120 = null;
            goto L81
        L17:
            kotlin.jvm.internal.w r75 = (kotlin.jvm.internal.w) this.L$2;
            List r76 = (List) this.L$1;
            i0 r77 = (i0) this.L$0;
            m.b(r38);     // Catch: Throwable -> L10
            r69 = r76;
        L38:
            j.b(r69);     // Catch: Throwable -> L10
            List r78 = q.b1(r69, new ArgoPool$scanCleanIps$1$invokeSuspend$$inlined$sortedBy$1());     // Catch: Throwable -> L10
            r68 = new d(0);     // Catch: Throwable -> L10
            ArrayList r121 = new ArrayList();     // Catch: Throwable -> L10
            Iterator r79 = r78.iterator();     // Catch: Throwable -> L10
        L40:
            if (r79.hasNext() == false) goto L44;
            Object r122 = r79.next();     // Catch: Throwable -> L10
            if (((Boolean) r68.invoke(((sd.j) r122).getFirst())).booleanValue() == true) goto L40;
            r121.add(r122);     // Catch: Throwable -> L10
            goto L40
        L44:
            ArrayList r80 = new ArrayList();     // Catch: Throwable -> L10
            Iterator r81 = r78.iterator();     // Catch: Throwable -> L10
        L46:
            if (r81.hasNext() == false) goto L51;
            Object r123 = r81.next();     // Catch: Throwable -> L10
            if (((Boolean) r68.invoke(((sd.j) r123).getFirst())).booleanValue() == false) goto L46;
            r80.add(r123);     // Catch: Throwable -> L10
            goto L46
        L51:
            if (r80.isEmpty() == true) goto L53;
            int r82 = 12;
        L54:
            ArrayList r83 = q.S0(q.e1(r121, r82), q.e1(r80, 24 - Math.min(r82, r121.size())));     // Catch: Throwable -> L10
            ArgoPool r124 = ArgoPool.INSTANCE;     // Catch: Throwable -> L10
            IpScan r215 = r124.getIpScan();     // Catch: Throwable -> L10
            if (r215 == null) goto L57;
            IpScan r125 = IpScan.copy$default(r215, false, "auth", 0, r83.size(), null, null, null, null, 0, 497, null);     // Catch: Throwable -> L10
        L58:
            ArgoPool.access$setIpScan$p(r125);     // Catch: Throwable -> L10
            ArgoPool.access$changed(r124);     // Catch: Throwable -> L10
            List r216 = Collections.synchronizedList(new ArrayList());     // Catch: Throwable -> L10
            Map r126 = d0.S(r83);     // Catch: Throwable -> L10
            r75.element = 0;     // Catch: Throwable -> L10
            int r127 = kotlinx.coroutines.sync.m.f24188a;     // Catch: Throwable -> L10
            kotlinx.coroutines.sync.l r128 = new kotlinx.coroutines.sync.l(6);     // Catch: Throwable -> L10
            List<Item> r129 = this.$refs;     // Catch: Throwable -> L10
            ArrayList r130 = new ArrayList(kotlin.collections.s.g0(r83, 10));     // Catch: Throwable -> L10
            int r131 = r83.size();     // Catch: Throwable -> L10
            int r132 = 0;
        L59:
            if (r132 >= r131) goto L61;
            Object r217 = r83.get(r132);     // Catch: Throwable -> L10
            r132 = r132 + 1;     // Catch: Throwable -> L10
            kotlin.jvm.internal.w r218 = r75;
            kotlinx.coroutines.sync.l r219 = r128;
            List<Item> r220 = r129;
            r130.add(m0.c(r77, null, new ArgoPool$scanCleanIps$1$2$1(r219, r220, (String) ((sd.j) r217).component1(), r216, r218, null), 3));     // Catch: Throwable -> L10
            r216 = r216;
            r128 = r219;
            r129 = r220;
            r75 = r218;
            goto L59
        L61:
            List r84 = r216;
            this.L$0 = r69;     // Catch: Throwable -> L10
            this.L$1 = r68;     // Catch: Throwable -> L10
            this.L$2 = r80;     // Catch: Throwable -> L10
            this.L$3 = r84;     // Catch: Throwable -> L10
            this.L$4 = r126;     // Catch: Throwable -> L10
            this.label = 2;     // Catch: Throwable -> L10
            if (m0.d(r130, this) == r4) goto L89;
            r66 = r84;
            r67 = r80;
            r65 = r126;
        L89:
            return r4;
        L57:
            r125 = null;
            goto L58
        L53:
            r82 = 24;
            goto L54
        L20:
            int r221 = 3;
            m.b(r38);
            r77 = (i0) this.L$0;
            ArgoPool r85 = ArgoPool.INSTANCE;     // Catch: Throwable -> L10
            List r86 = ArgoPool.access$sampleV4(r85, com.google.android.gms.internal.mlkit_language_id_common.j.d(this.$count, 50, 3000));     // Catch: Throwable -> L10
            if (this.$v6 == true) goto L24;
        L26:
            IpScan r222 = r85.getIpScan();     // Catch: Throwable -> L10
            if (r222 == null) goto L29;
            IpScan r87 = IpScan.copy$default(r222, false, null, 0, r86.size(), null, null, null, null, 0, 503, null);     // Catch: Throwable -> L10
        L30:
            ArgoPool.access$setIpScan$p(r87);     // Catch: Throwable -> L10
            List r223 = Collections.synchronizedList(new ArrayList());     // Catch: Throwable -> L10
            int r88 = kotlinx.coroutines.sync.m.f24188a;     // Catch: Throwable -> L10
            kotlinx.coroutines.sync.l r89 = new kotlinx.coroutines.sync.l(32);     // Catch: Throwable -> L10
            kotlin.jvm.internal.w r224 = new kotlin.jvm.internal.w();     // Catch: Throwable -> L10
            List r90 = r86;     // Catch: Throwable -> L10
            List<Item> r91 = this.$refs;     // Catch: Throwable -> L10
            ArrayList r92 = new ArrayList(kotlin.collections.s.g0(r90, 10));     // Catch: Throwable -> L10
            Iterator r93 = r90.iterator();     // Catch: Throwable -> L10
        L32:
            if (r93.hasNext() == false) goto L34;
            kotlinx.coroutines.sync.l r225 = r89;
            List<Item> r226 = r91;
            r92.add(m0.c(r77, null, new ArgoPool$scanCleanIps$1$1$1(r225, (String) r93.next(), r226, r224, r223, null), r221));     // Catch: Throwable -> L10
            r224 = r224;
            r223 = r223;
            r89 = r225;
            r91 = r226;
            r221 = 3;
            goto L32
        L34:
            r75 = r224;
            List r94 = r223;
            this.L$0 = r77;     // Catch: Throwable -> L10
            this.L$1 = r94;     // Catch: Throwable -> L10
            this.L$2 = r75;     // Catch: Throwable -> L10
            this.label = 1;     // Catch: Throwable -> L10
            if (m0.d(r92, this) == r4) goto L89;
            r69 = r94;
            goto L38
        L29:
            r87 = null;
            goto L30
        L24:
            if (ArgoPool.access$hasGlobalV6(r85) == false) goto L26;
            r86 = q.S0(r86, ArgoPool.access$sampleV6(r85, r86.size() / 3));     // Catch: Throwable -> L10
        L10:
            th = th;
            r35 = r10;
            goto L178
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C03991) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2", f = "ArgoPool.kt", l = {596, 605, 597, 605, 605}, m = "invokeSuspend")
    public static final class C04002 extends xd.j implements ee.e {
        final /* synthetic */ ArgoProtocol.SessionInfo $info;
        final /* synthetic */ String $ip;
        final /* synthetic */ Item $ref;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$speedThrough$2$2", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class C00532 extends xd.j implements ee.e {
            final /* synthetic */ VlessXrayInjector $core;
            private /* synthetic */ Object L$0;
            int label;

            public C00532(VlessXrayInjector r4, wd.d r8) {
                this.$core = r4;
                super(2, r8);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                C00532 r10 = new C00532(this.$core, r8);
                r10.L$0 = r4;
                return r10;
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r4) {
                kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) goto L12;
                m.b(r4);
                i0 r10 = (i0) this.L$0;
                this.$core.stop();     // Catch: Throwable -> L7
                Object r11 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L7
            L10:
                return sd.l.m1003boximpl(r11);
            L7:
                th = move-exception;
                r11 = sd.l.m1004constructorimpl(m.a(th));
                goto L10
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((C00532) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        public C04002(Item r4, ArgoProtocol.SessionInfo r8, String r10, wd.d r11) {
            this.$ref = r4;
            this.$info = r8;
            this.$ip = r10;
            super(2, r11);
        }

        @Override // xd.a
        public final wd.d create(Object r8, wd.d r10) {
            C04002 r4 = new C04002(this.$ref, this.$info, this.$ip, r10);
            r4.L$0 = r8;
            return r4;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r30) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            if (r8 == 0) goto L26;
            if (r8 == 1) goto L21;
            if (r8 == 2) goto L19;
            if (r8 == 3) goto L14;
            if (r8 == 4) goto L12;
            if (r8 != 5) goto L10;
            Throwable r10 = (Throwable) this.L$0;
            m.b(r30);
            throw r10;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            Long r11 = (Long) this.L$0;
            m.b(r30);
            return r11;
        L14:
            int r12 = this.I$0;
            VlessXrayInjector r13 = (VlessXrayInjector) this.L$2;
            ArgoProtocol.Endpoint r14 = (ArgoProtocol.Endpoint) this.L$1;
            i0 r15 = (i0) this.L$0;
            m.b(r30);     // Catch: Throwable -> L17
            int r21 = r12;
        L42:
            long r16 = System.nanoTime();     // Catch: Throwable -> L17
            ArgoPool r20 = ArgoPool.INSTANCE;     // Catch: Throwable -> L17
            sd.j r17 = ArgoPool.access$download(r20, r21, ArgoPool.CARRY_URL, 1048576, GerehWatchdog.STUCK_MS, false);     // Catch: Throwable -> L17
            int r18 = r21;
            int r19 = ((Number) r17.component1()).intValue();     // Catch: Throwable -> L17
            long r110 = ((Number) r17.component2()).longValue();     // Catch: Throwable -> L17
            double r22 = (System.nanoTime() - r16) / 1.0E9d;     // Catch: Throwable -> L17
            if (r22 >= 0.001d) goto L74;
            r22 = 0.001d;
        L74:
            sd.l.m1004constructorimpl(ArgoNet.INSTANCE.sessionRequest("disconnect", r14.getHost(), r14.getPort(), this.$info, ArgoPool.access$socks(r20, r18), 6000));     // Catch: Throwable -> L48
        L51:
            if (r19 == 200) goto L53;
        L56:
            Long r23 = null;
        L57:
            m2 r24 = m2.f24144a;
            C00532 r25 = new C00532(r13, null);
            this.L$0 = r23;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 4;
            if (m0.J(r24, r25, this) == r4) goto L67;
            return r23;
        L67:
            return r4;
        L53:
            if (r110 < 500000) goto L56;
            r23 = new Long(Math.round((r110 / 1024.0d) / r22));     // Catch: Throwable -> L17
        L48:
            th = move-exception;
            sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L17
        L17:
            th = th;
        L65:
            m2 r26 = m2.f24144a;
            C00532 r27 = new C00532(r13, null);
            this.L$0 = th;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (m0.J(r26, r27, this) == r4) goto L67;
            throw th;
        L19:
            m.b(r30);
            return null;
        L21:
            int r28 = this.I$0;
            VlessXrayInjector r29 = (VlessXrayInjector) this.L$2;
            ArgoProtocol.Endpoint r31 = (ArgoProtocol.Endpoint) this.L$1;
            i0 r111 = (i0) this.L$0;
            m.b(r30);     // Catch: Throwable -> L24
            VlessXrayInjector r112 = r29;
            ArgoProtocol.Endpoint r113 = r31;
            int r32 = r28;
            Object r33 = r30;
        L33:
            if (((Boolean) r33).booleanValue() == true) goto L38;
            m2 r34 = m2.f24144a;
            C00532 r35 = new C00532(r112, null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (m0.J(r34, r35, this) == r4) goto L67;
            return null;
        L38:
            ArgoPool r36 = ArgoPool.INSTANCE;     // Catch: Throwable -> L61
            this.L$0 = r111;     // Catch: Throwable -> L61
            this.L$1 = r113;     // Catch: Throwable -> L61
            this.L$2 = r112;     // Catch: Throwable -> L61
            this.I$0 = r32;     // Catch: Throwable -> L61
            this.label = 3;     // Catch: Throwable -> L61
            if (ArgoPool.access$waitPort(r36, r32, 5000, this) == r4) goto L67;
            r21 = r32;
            r14 = r113;
            r13 = r112;
        L24:
            th = th;
            r13 = r29;
            goto L65
        L26:
            m.b(r30);
            r111 = (i0) this.L$0;
            ArgoPool r37 = ArgoPool.INSTANCE;
            r32 = ArgoPool.access$freePort(r37);
            r113 = ArgoPool.access$endpointOf(r37, this.$ref);
            sf.c r38 = new sf.c();
            sf.c r114 = new sf.c();
            r114.D("loglevel", "none");
            r38.D(XrayCoreHostService.KEY_LOG, r114);
            sf.a r115 = new sf.a();
            sf.c r39 = i.p("tag", "in", "listen", SniSession.LOCAL_HOST);
            r39.D(PsiphonProbeService.PORT, Integer.valueOf(r32));
            r39.D("protocol", "socks");
            sf.c r116 = new sf.c();
            r116.E("udp", false);
            r39.D("settings", r116);
            r115.put(r39);
            r38.D("inbounds", r115);
            sf.a r40 = new sf.a();
            r40.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, r113, this.$info, "out", this.$ip, null, 16, null));
            r38.D("outbounds", r40);
            String r41 = r38.toString();
            j.d(r41, "toString(...)");
            r112 = new VlessXrayInjector(0, null, true, 2, null);
            Context r42 = ArgoPool.access$getApp$p();     // Catch: Throwable -> L61
            if (r42 == null) goto L63;
            this.L$0 = r111;     // Catch: Throwable -> L61
            this.L$1 = r113;     // Catch: Throwable -> L61
            this.L$2 = r112;     // Catch: Throwable -> L61
            this.I$0 = r32;     // Catch: Throwable -> L61
            this.label = 1;     // Catch: Throwable -> L61
            r33 = r112.start(r42, r41, 0, this);     // Catch: Throwable -> L61
            if (r33 != r4) goto L33;
        L63:
            j.k("app");     // Catch: Throwable -> L61
            throw null;     // Catch: Throwable -> L61
        L61:
            th = th;
            r13 = r112;
            goto L65
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C04002) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool", f = "ArgoPool.kt", l = {292}, m = "telegramPageRetry")
    public static final class C04011 extends xd.c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ArgoPool this$0;

        public C04011(ArgoPool r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.access$telegramPageRetry(this.this$0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$test$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1", f = "ArgoPool.kt", l = {660, 675}, m = "invokeSuspend")
    public static final class C04021 extends xd.j implements ee.e {
        final /* synthetic */ String $connectIp;
        final /* synthetic */ List<Item> $list;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
        public static final class C00541 extends xd.j implements ee.e {
            final /* synthetic */ i0 $$this$launch;
            final /* synthetic */ kotlin.jvm.internal.w $alive;
            final /* synthetic */ kotlinx.coroutines.sync.a $chain;
            final /* synthetic */ String $connectIp;
            final /* synthetic */ kotlin.jvm.internal.w $done;
            final /* synthetic */ kotlin.jvm.internal.w $frozen;
            final /* synthetic */ List<Item> $list;
            final /* synthetic */ AtomicInteger $next;
            final /* synthetic */ List<Ready> $ready;
            private /* synthetic */ Object L$0;
            int label;

            public C00541(List<Item> r4, AtomicInteger r8, String r10, List<Ready> r11, kotlin.jvm.internal.w r12, kotlin.jvm.internal.w r13, kotlin.jvm.internal.w r14, kotlinx.coroutines.sync.a r15, i0 r16, wd.d r17) {
                this.$list = r4;
                this.$next = r8;
                this.$connectIp = r10;
                this.$ready = r11;
                this.$done = r12;
                this.$alive = r13;
                this.$frozen = r14;
                this.$chain = r15;
                this.$$this$launch = r16;
                super(2, r17);
            }

            @Override // xd.a
            public final wd.d create(Object r12, wd.d r13) {
                C00541 r4 = new C00541(this.$list, this.$next, this.$connectIp, this.$ready, this.$done, this.$alive, this.$frozen, this.$chain, this.$$this$launch, r13);
                r4.L$0 = r12;
                return r4;
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r14) {
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) goto L11;
                m.b(r14);
                i0 r15 = (i0) this.L$0;
                List<Item> r8 = this.$list;
                AtomicInteger r10 = this.$next;
                String r11 = this.$connectIp;
                List<Ready> r12 = this.$ready;
                kotlin.jvm.internal.w r13 = this.$done;
                kotlin.jvm.internal.w r16 = this.$alive;
                kotlin.jvm.internal.w r17 = this.$frozen;
                kotlinx.coroutines.sync.a r18 = this.$chain;
                i0 r19 = this.$$this$launch;
                int r110 = 0;
            L6:
                if (r110 >= 8) goto L9;
                m0.y(r15, null, null, new ArgoPool$test$1$1$1$1(r8, r10, r11, r12, r13, r16, r17, r18, r19, null), 3);
                r110 = r110 + 1;
                goto L6
            L9:
                return u.f67154a;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((C00541) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        public C04021(List<Item> r4, String r8, wd.d r10) {
            this.$list = r4;
            this.$connectIp = r8;
            super(2, r10);
        }

        public static final /* synthetic */ Object access$invokeSuspend$flush(kotlinx.coroutines.sync.a r4, List r8, i0 r10, String r11, kotlin.jvm.internal.w r12, kotlin.jvm.internal.w r13, kotlin.jvm.internal.w r14, wd.d r15) {
            return invokeSuspend$flush(r4, r8, r10, r11, r12, r13, r14, r15);
        }

        private static final Object invokeSuspend$flush(kotlinx.coroutines.sync.a r23, List<Ready> r24, i0 r25, String r26, kotlin.jvm.internal.w r27, kotlin.jvm.internal.w r28, kotlin.jvm.internal.w r29, wd.d r30) {
            if ((r30 instanceof ArgoPool$test$1$flush$1) == false) goto L7;
            ArgoPool$test$1$flush$1 r4 = (ArgoPool$test$1$flush$1) r30;
            int r8 = r4.label;
            if ((r8 & TLObject.FLAG_31) == 0) goto L7;
            r4.label = r8 - TLObject.FLAG_31;
        L8:
            Object r10 = r4.result;
            kotlin.coroutines.intrinsics.a r11 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r12 = r4.label;
            int r13 = 0;
            if (r12 == 0) goto L21;
            if (r12 == 1) goto L19;
            if (r12 != 2) goto L18;
            List r14 = (List) r4.L$4;
            kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r4.L$3;
            kotlin.jvm.internal.w r16 = (kotlin.jvm.internal.w) r4.L$2;
            kotlin.jvm.internal.w r17 = (kotlin.jvm.internal.w) r4.L$1;
            kotlin.jvm.internal.w r18 = (kotlin.jvm.internal.w) r4.L$0;
            m.b(r10);     // Catch: Throwable -> L15
            r15 = r15;
        L40:
            Object r19 = sd.l.m1004constructorimpl((List) r10);     // Catch: Throwable -> L15
            kotlinx.coroutines.sync.a r20 = r15;
        L41:
            kotlinx.coroutines.sync.a r21 = r20;
            w r22 = w.INSTANCE;     // Catch: Throwable -> L57
            if (sd.l.m1010isFailureimpl(r19) == false) goto L49;
            r19 = r22;
        L49:
            List r31 = (List) r19;     // Catch: Throwable -> L57
            Iterator r32 = r14.iterator();     // Catch: Throwable -> L57
        L51:
            if (r32.hasNext() == false) goto L79;
            Object r33 = r32.next();     // Catch: Throwable -> L57
            int r34 = r13 + 1;     // Catch: Throwable -> L57
            if (r13 < 0) goto L75;
            Ready r35 = (Ready) r33;     // Catch: Throwable -> L57
            Trace r36 = (Trace) q.B0(r13, r31);     // Catch: Throwable -> L57
            if (r36 != null) goto L60;
            r36 = new Trace(false, null, null, 6, null);     // Catch: Throwable -> L57
        L60:
            if (r36.getOk() == false) goto L68;
            if (r36.getCarried() == false) goto L68;
            ArgoPool r110 = ArgoPool.INSTANCE;     // Catch: Throwable -> L57
            String r111 = r35.getX().getId();     // Catch: Throwable -> L57
            long r112 = r35.getMs();     // Catch: Throwable -> L57
            String r37 = r36.getLoc();     // Catch: Throwable -> L57
            if (o.L0(r37) == false) goto L66;
            r37 = "??";
        L66:
            ArgoPool.record$default(r110, r111, true, r112, r37, r36.getIp(), null, false, null, 224, null);     // Catch: Throwable -> L57
            invokeSuspend$tally$default(r18, r17, r16, 1, 1, 0, 32, null);     // Catch: Throwable -> L57
        L74:
            r13 = r34;
        L68:
            if (r36.getOk() == false) goto L73;
            ArgoPool r113 = ArgoPool.INSTANCE;     // Catch: Throwable -> L57
            String r114 = r35.getX().getId();     // Catch: Throwable -> L57
            long r115 = r35.getMs();     // Catch: Throwable -> L57
            String r38 = r36.getLoc();     // Catch: Throwable -> L57
            if (o.L0(r38) == false) goto L72;
            r38 = "??";
        L72:
            ArgoPool.record$default(r113, r114, false, r115, r38, r36.getIp(), "جواب داد ولی وسط دانلود قطع شد — «آی\u200cپی تمیز» را امتحان کنید", true, null, 128, null);     // Catch: Throwable -> L57
            invokeSuspend$tally$default(r18, r17, r16, 1, 0, 1, 16, null);     // Catch: Throwable -> L57
            goto L74
        L73:
            ArgoPool.record$default(ArgoPool.INSTANCE, r35.getX().getId(), false, r35.getMs(), null, null, "احراز هویت شد ولی داده\u200cای از داخلش رد نشد", false, null, 216, null);     // Catch: Throwable -> L57
            invokeSuspend$tally$default(r18, r17, r16, 1, 0, 0, 48, null);     // Catch: Throwable -> L57
            goto L74
        L75:
            r.f0();     // Catch: Throwable -> L57
            throw null;     // Catch: Throwable -> L57
        L79:
            u r39 = u.f67154a;     // Catch: Throwable -> L57
            ((kotlinx.coroutines.sync.f) r21).f(null);
            return r39;
        L15:
            th = th;
        L91:
            r19 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L77
            r20 = r15;
        L77:
            th = th;
            kotlinx.coroutines.sync.a r40 = r15;
        L84:
            ((kotlinx.coroutines.sync.f) r40).f(null);
            throw th;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            kotlinx.coroutines.sync.a r41 = (kotlinx.coroutines.sync.a) r4.L$6;
            kotlin.jvm.internal.w r42 = (kotlin.jvm.internal.w) r4.L$5;
            r17 = (kotlin.jvm.internal.w) r4.L$4;
            kotlin.jvm.internal.w r43 = (kotlin.jvm.internal.w) r4.L$3;
            String r116 = (String) r4.L$2;
            i0 r117 = (i0) r4.L$1;
            List<Ready> r118 = (List) r4.L$0;
            m.b(r10);
            kotlinx.coroutines.sync.a r44 = r41;
        L20:
            r21 = r44;
            j.b(r118);     // Catch: Throwable -> L57
            monitor-enter(r118);     // Catch: Throwable -> L57
            List r119 = q.k1(q.e1(r118, 12));     // Catch: Throwable -> L31
            int r45 = r119.size();     // Catch: Throwable -> L31
            int r120 = 0;
        L28:
            if (r120 >= r45) goto L33;
            r118.remove(0);     // Catch: Throwable -> L31
            r120 = r120 + 1;
            goto L28
        L33:
            monitor-exit(r118);     // Catch: Throwable -> L57
            if (r119.isEmpty() == true) goto L79;
            ArgoPool r46 = ArgoPool.INSTANCE;     // Catch: Throwable -> L42
            r4.L$0 = r43;     // Catch: Throwable -> L42
            r4.L$1 = r17;     // Catch: Throwable -> L42
            r4.L$2 = r42;     // Catch: Throwable -> L42
            r4.L$3 = r21;     // Catch: Throwable -> L42
            r4.L$4 = r119;     // Catch: Throwable -> L42
            r4.L$5 = null;     // Catch: Throwable -> L42
            r4.L$6 = null;     // Catch: Throwable -> L42
            r4.label = 2;     // Catch: Throwable -> L42
            Object r47 = ArgoPool.access$measureExits(r46, r119, r116, r4);     // Catch: Throwable -> L42
            if (r47 != r11) goto L39;
        L38:
            return r11;
        L39:
            r16 = r42;
            r18 = r43;
            r14 = r119;
            r15 = r21;
            r10 = r47;
        L42:
            th = th;
            r16 = r42;
            r18 = r43;
            r14 = r119;
            r15 = r21;
        L31:
            th = move-exception;
            throw th;     // Catch: Throwable -> L57
        L57:
            th = th;
            r40 = r21;
            goto L84
        L21:
            m.b(r10);
            r4.L$0 = r24;
            r4.L$1 = r25;
            r4.L$2 = r26;
            r43 = r27;
            r4.L$3 = r43;
            r4.L$4 = r28;
            r4.L$5 = r29;
            r4.L$6 = r23;
            r4.label = 1;
            kotlinx.coroutines.sync.f r48 = (kotlinx.coroutines.sync.f) r23;
            if (r48.d(r4) == r11) goto L38;
            r17 = r28;
            r116 = r26;
            r42 = r29;
            r118 = r24;
            r44 = r48;
        L7:
            r4 = new ArgoPool$test$1$flush$1(r30);
            goto L8
        }

        private static final void invokeSuspend$tally(kotlin.jvm.internal.w r22, kotlin.jvm.internal.w r23, kotlin.jvm.internal.w r24, int r25, int r26, int r27) {
            ArgoPool r4 = ArgoPool.INSTANCE;
            monitor-enter(r4);
            r22.element += r25;     // Catch: Throwable -> L7
            r23.element += r26;     // Catch: Throwable -> L7
            r24.element += r27;     // Catch: Throwable -> L7
            Job r8 = r4.getTestJob();     // Catch: Throwable -> L7
            if (r8 == null) goto L9;
            Job r10 = Job.copy$default(r8, false, r22.element, 0, r23.element, r24.element, null, 0, null, null, 0, null, null, null, 8165, null);     // Catch: Throwable -> L7
        L10:
            ArgoPool.access$setTestJob$p(r10);     // Catch: Throwable -> L7
            ArgoPool.access$changed(r4);     // Catch: Throwable -> L7
            monitor-exit(r4);
            return;
        L9:
            r10 = null;
        L7:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void invokeSuspend$tally$default(kotlin.jvm.internal.w r4, kotlin.jvm.internal.w r8, kotlin.jvm.internal.w r10, int r11, int r12, int r13, int r14, Object r15) {
            if ((r14 & 16) == 0) goto L6;
            r12 = 0;
        L6:
            if ((r14 & 32) == 0) goto L8;
            r13 = 0;
        L8:
            invokeSuspend$tally(r4, r8, r10, r11, r12, r13);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            C04021 r10 = new C04021(this.$list, this.$connectIp, r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00d4 -> B:20:0x00d7). Please report as a decompilation issue!!! */
        @Override // xd.a
        public final Object invokeSuspend(Object r22) {
            C04021 r8 = this;
            kotlin.coroutines.intrinsics.a r10 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r4 = r8.label;
            if (r4 == 0) goto L10;
            if (r4 == 1) goto L9;
            if (r4 != 2) goto L8;
            kotlin.jvm.internal.w r11 = (kotlin.jvm.internal.w) r8.L$5;
            kotlin.jvm.internal.w r12 = (kotlin.jvm.internal.w) r8.L$4;
            kotlin.jvm.internal.w r13 = (kotlin.jvm.internal.w) r8.L$3;
            kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) r8.L$2;
            List r15 = (List) r8.L$1;
            i0 r16 = (i0) r8.L$0;
            m.b(r22);
            kotlin.jvm.internal.w r17 = r12;
            List r18 = r15;
            kotlin.jvm.internal.w r19 = r13;
            i0 r20 = r16;
            kotlin.jvm.internal.w r21 = r11;
            kotlinx.coroutines.sync.a r23 = r14;
        L20:
            r8 = this;
        L15:
            j.b(r18);
            if (r18.isEmpty() == true) goto L21;
            String r24 = r8.$connectIp;
            r8.L$0 = r20;
            r8.L$1 = r18;
            r8.L$2 = r23;
            r8.L$3 = r19;
            r8.L$4 = r17;
            r8.L$5 = r21;
            r8.label = 2;
            if (invokeSuspend$flush(r23, r18, r20, r24, r19, r17, r21, r8) != r10) goto L20;
        L19:
            return r10;
        L21:
            ArgoPool r25 = ArgoPool.INSTANCE;
            Job r26 = r25.getTestJob();
            if (r26 == null) goto L24;
            Job r27 = Job.copy$default(r26, false, 0, 0, 0, 0, null, 0, null, null, System.currentTimeMillis(), null, null, null, 7678, null);
        L25:
            ArgoPool.access$setTestJob$p(r27);
            r25.saveNow();
            return u.f67154a;
        L24:
            r27 = null;
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            kotlin.jvm.internal.w r28 = (kotlin.jvm.internal.w) r8.L$5;
            kotlin.jvm.internal.w r29 = (kotlin.jvm.internal.w) r8.L$4;
            kotlin.jvm.internal.w r30 = (kotlin.jvm.internal.w) r8.L$3;
            kotlinx.coroutines.sync.a r31 = (kotlinx.coroutines.sync.a) r8.L$2;
            List r32 = (List) r8.L$1;
            i0 r33 = (i0) r8.L$0;
            m.b(r22);
        L14:
            i0 r34 = r33;
            r17 = r29;
            r18 = r32;
            r19 = r30;
            r20 = r34;
            r21 = r28;
            r23 = r31;
            goto L15
        L10:
            m.b(r22);
            i0 r110 = (i0) r8.L$0;
            AtomicInteger r111 = new AtomicInteger(0);
            List r112 = Collections.synchronizedList(new ArrayList());
            kotlinx.coroutines.sync.f r113 = new kotlinx.coroutines.sync.f();
            kotlin.jvm.internal.w r114 = new kotlin.jvm.internal.w();
            kotlin.jvm.internal.w r115 = new kotlin.jvm.internal.w();
            kotlin.jvm.internal.w r116 = new kotlin.jvm.internal.w();
            C00541 r117 = new C00541(r8.$list, r111, r8.$connectIp, r112, r114, r115, r116, r113, r110, null);
            r28 = r116;
            r31 = r113;
            r33 = r110;
            r8.L$0 = r33;
            r8.L$1 = r112;
            r8.L$2 = r31;
            r8.L$3 = r114;
            r8.L$4 = r115;
            r8.L$5 = r28;
            r8.label = 1;
            if (m0.i(r117, r8) == r10) goto L19;
            r29 = r115;
            r32 = r112;
            r30 = r114;
            goto L14
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C04021) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$update$1", f = "ArgoPool.kt", l = {478}, m = "invokeSuspend")
    public static final class C04031 extends xd.j implements ee.e {
        final /* synthetic */ List<Source> $list;
        final /* synthetic */ ArgoNet.Route $route;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public C04031(List<Source> r4, ArgoNet.Route r8, wd.d r10) {
            this.$list = r4;
            this.$route = r8;
            super(2, r10);
        }

        public static /* synthetic */ u d(Source r4, int r8, int r10) {
            return invokeSuspend$lambda$2(r4, r8, r10);
        }

        public static /* synthetic */ boolean f() {
            return invokeSuspend$lambda$4();
        }

        public static /* synthetic */ boolean g() {
            return invokeSuspend$lambda$3();
        }

        private static final u invokeSuspend$lambda$2(Source r18, int r19, int r20) {
            ArgoPool r4 = ArgoPool.INSTANCE;
            Job r8 = r4.getUpdateJob();
            if (r8 == null) goto L5;
            Job r10 = Job.copy$default(r8, false, 0, 0, 0, 0, r18.getLabel() + " — صفحهٔ " + r19 + "، " + r20 + " مورد تازه", 0, null, null, 0, null, null, null, 8159, null);
        L6:
            ArgoPool.access$setUpdateJob$p(r10);
            ArgoPool.access$changed(r4);
            return u.f67154a;
        L5:
            r10 = null;
            goto L6
        }

        private static final boolean invokeSuspend$lambda$3() {
            return ArgoPool.access$getUpdateCancel$p();
        }

        private static final boolean invokeSuspend$lambda$4() {
            return ArgoPool.access$getUpdateCancel$p();
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C04031(this.$list, this.$route, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f3 -> B:41:0x00f9). Please report as a decompilation issue!!! */
        @Override // xd.a
        public final Object invokeSuspend(Object r33) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r4 = this.label;
            Job r10 = null;
            if (r4 == 0) goto L12;
            if (r4 != 1) goto L11;
            int r11 = this.I$1;
            int r12 = this.I$0;
            sf.c r13 = (sf.c) this.L$3;
            Source r14 = (Source) this.L$2;
            Iterator<Source> r15 = (Iterator) this.L$1;
            List r16 = (List) this.L$0;
            m.b(r33);     // Catch: Throwable -> L8
            Object r17 = r33;
        L41:
            int r18 = ((Number) r17).intValue();     // Catch: Throwable -> L8
        L51:
            r13.D("at", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L8
            r13.D("found", Integer.valueOf(r18));     // Catch: Throwable -> L8
            r11 = r11 + r18;
        L53:
            int r19 = r11;
            int r110 = r12 + 1;
            ArgoPool r20 = ArgoPool.INSTANCE;
            Job r111 = r20.getUpdateJob();
            if (r111 == null) goto L61;
            Job r21 = Job.copy$default(r111, false, r110, 0, 0, 0, null, r19, q.f1(5, r16), null, 0, null, null, null, 7997, null);
        L62:
            ArgoPool.access$setUpdateJob$p(r21);
            ArgoPool.access$saveSoon(r20);
            List r112 = r16;
            int r113 = r110;
            int r114 = r19;
            Iterator<Source> r115 = r15;
        L14:
            if (r115.hasNext() == false) goto L65;
            Source r22 = r115.next();
            if (ArgoPool.access$getUpdateCancel$p() == true) goto L65;
            ArgoPool r23 = ArgoPool.INSTANCE;
            Job r116 = r23.getUpdateJob();
            if (r116 == null) goto L20;
            Job r24 = Job.copy$default(r116, false, 0, 0, 0, 0, r22.getLabel(), 0, null, null, 0, null, null, null, 8159, null);
        L21:
            ArgoPool.access$setUpdateJob$p(r24);
            ArgoPool.access$changed(r23);
            monitor-enter(r23);
            HashMap r25 = ArgoPool.access$getSourceState$p();     // Catch: Throwable -> L26
            String r26 = r22.getId();     // Catch: Throwable -> L26
            Object r27 = r25.get(r26);     // Catch: Throwable -> L26
            if (r27 != null) goto L28;
            r27 = new sf.c();     // Catch: Throwable -> L26
            r25.put(r26, r27);     // Catch: Throwable -> L26
        L28:
            sf.c r117 = (sf.c) r27;     // Catch: Throwable -> L26
            r117.D("error", "");     // Catch: Throwable -> L26
            monitor-exit(r23);
            String r28 = r22.getType();     // Catch: Throwable -> L43
            if (j.a(r28, "telegram") == false) goto L46;
            if (r117.x(0, "at") <= 0) goto L36;
            int r29 = 40;
        L35:
            int r30 = r29;
            ArgoNet.Route r31 = this.$route;     // Catch: Throwable -> L43
            e r32 = new e(r22);     // Catch: Throwable -> L43
            f r34 = new f(0);     // Catch: Throwable -> L43
            this.L$0 = r112;     // Catch: Throwable -> L43
            this.L$1 = r115;     // Catch: Throwable -> L43
            this.L$2 = r22;     // Catch: Throwable -> L43
            this.L$3 = r117;     // Catch: Throwable -> L43
            this.I$0 = r113;     // Catch: Throwable -> L43
            this.I$1 = r114;     // Catch: Throwable -> L43
            this.label = 1;     // Catch: Throwable -> L43
            r17 = ArgoPool.access$harvestTelegram(r23, r22, r30, r31, r32, r34, this);     // Catch: Throwable -> L43
            if (r17 != r8) goto L40;
            return r8;
        L40:
            r14 = r22;
            r11 = r114;
            r12 = r113;
            r15 = r115;
            r16 = r112;
            r13 = r117;
            goto L41
        L36:
            r29 = MediaDataController.MAX_LINKS_COUNT;
            goto L35
        L46:
            if (j.a(r28, XrayMeasureService.KEY_URL) == false) goto L49;
            r18 = ArgoPool.access$harvestUrl(r23, r22, this.$route, new f(1));     // Catch: Throwable -> L43
            r11 = r114;
            r12 = r113;
            r15 = r115;
            r16 = r112;
            r13 = r117;
            goto L51
        L49:
            r18 = ArgoPool.access$harvestOfficial(r23, r22, this.$route);     // Catch: Throwable -> L43
            r11 = r114;
            r12 = r113;
            r15 = r115;
            r16 = r112;
            r13 = r117;
        L43:
            th = th;
            r14 = r22;
            r11 = r114;
            r12 = r113;
            r15 = r115;
            r16 = r112;
            r13 = r117;
        L54:
            String r118 = th.getMessage();
            if (r118 != null) goto L57;
            r13.D("error", r118);
            r16.add(r14.getLabel() + ": " + th.getMessage());
            goto L53
        L57:
            r13.D("error", "");
            r16.add(r14.getLabel() + ": " + th.getMessage());
        L26:
            th = move-exception;
            throw th;
        L20:
            r24 = null;
        L65:
            ArgoPool r35 = ArgoPool.INSTANCE;
            Job r119 = r35.getUpdateJob();
            if (r119 == null) goto L68;
            r10 = Job.copy$default(r119, false, 0, 0, 0, 0, "", 0, null, null, System.currentTimeMillis(), null, null, null, 7646, null);
        L68:
            ArgoPool.access$setUpdateJob$p(r10);
            r35.saveNow();
            return u.f67154a;
        L61:
            r21 = null;
        L8:
            th = th;
            goto L54
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r112 = androidx.compose.foundation.interaction.f.v(r33);
            r115 = this.$list.iterator();
            r114 = 0;
            r113 = 0;
            goto L14
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C04031) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$waitPort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool", f = "ArgoPool.kt", l = {519}, m = "waitPort")
    public static final class C04041 extends xd.c {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ArgoPool this$0;

        public C04041(ArgoPool r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.access$waitPort(this.this$0, 0, 0, this);
        }
    }

    static {
        ArgoPool r4 = new ArgoPool();
        INSTANCE = r4;
        String r8 = System.getProperty("http.agent");
        if (r8 != null) goto L5;
    L11:
        r8 = "Mozilla/5.0 (Linux; Android)";
    L12:
        CARRY_UA = r8;
        scope = m0.a(g8.a.D(v0.f24208c, m0.b()));
        random = new SecureRandom();
        items = new LinkedHashMap();
        results = new HashMap();
        userSources = new ArrayList();
        sourceState = new HashMap();
        prefs = new Prefs(null, false, 3, null);
        falconServers = w.INSTANCE;
        g1 r10 = kotlinx.coroutines.flow.h.b(0L);
        _version = r10;
        version = r10;
        BUILTIN = r.a0(new Source[]{r4.tg("argooo_vpn"), r4.tg("ARGO_VPNN"), r4.tg("falconchi"), r4.tg("argo_falcon"), r4.tg("falcon_argo"), r4.tg("argovpn_falcon"), r4.tg("argo_bridge"), r4.tg("ArgoVPNs"), r4.tg("vvpnfc"), r4.tg("falconsazi"), r4.tg("pol_argo"), new Source("gh:bannedbook-ssvpn", XrayMeasureService.KEY_URL, m9.d.B("https://github.com/bannedbook/ssvpn/issues"), "گیت\u200cهاب — ایشوهای bannedbook/ssvpn", true, false, 0, 96, null), new Source("argo:config", "snowcfg", r.a0(new String[]{"https://s3.amazonaws.com/argovpn/browse/data6.br", "https://raw.githubusercontent.com/legend-wizard/browse/refs/heads/main/data6.br", "https://akeptumbesnow.com/repo6"}), "فهرست رسمی سرورهای عمومی آرگو", true, false, 0, 96, null), new Source("argo:falcon", "falcon-servers", m9.d.B("https://raw.githubusercontent.com/ArgoConfBot/ARG/master/lib.br"), "فهرست رسمی سرورهای فالکن (برای ساخت فالکن شخصی)", true, false, 0, 96, null)});
        CF_V4 = r.a0(new String[]{"173.245.48.0/20", "103.21.244.0/22", "103.22.200.0/22", "103.31.4.0/22", "141.101.64.0/18", "108.162.192.0/18", "190.93.240.0/20", "188.114.96.0/20", "197.234.240.0/22", "198.41.128.0/17", "162.158.0.0/15", "104.16.0.0/13", "104.24.0.0/14", "172.64.0.0/13", "131.0.72.0/22"});
        CF_V6 = r.a0(new String[]{"2606:4700:3030", "2606:4700:3031", "2606:4700:3032", "2606:4700:3033", "2606:4700:3034", "2606:4700:3035", "2606:4700:3036", "2606:4700:3037", "2606:4700:10", "2606:4700:20", "2606:4700:7", "2606:4700:4400", "2803:f800:50", "2a06:98c1:3120", "2a06:98c1:3121", "2400:cb00:2049"});
        IPV4_LITERAL = new l("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$");
        $stable = 8;
        return;
    L5:
        if (o.L0(r8) == false) goto L7;
    L9:
        r8 = null;
    L10:
        if (r8 != null) goto L12;
    L7:
        if (o.y0(r8, "okhttp", true) == true) goto L9;
        goto L9
    }

    private ArgoPool() {
    }

    public static /* synthetic */ Comparable a(ArgoProtocol.FalconOrigin r4) {
        return summary$lambda$110(r4);
    }

    private final Absorbed absorbText(String r20, String r21, long r22, boolean r24, boolean r25) {
        Iterator<String> r4 = ArgoProtocol.INSTANCE.extractBridgeBlocks(r20).iterator();
        int r8 = 0;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r4.hasNext() == false) goto L12;
        ArgoProtocol.Bridge r12 = ArgoProtocol.INSTANCE.decodeBridgeBlock(r4.next());     // Catch: Throwable -> L20
        if (r12.getSigOk() == false) goto L8;
        if (addItem$default(this, "bridge", r12.getHost(), r12.getPort(), r12.getProtocol(), r21, r22, r25, null, 128, null) == false) goto L4;
        r10 = r10 + 1;
    L8:
        r11 = r11 + 1;     // Catch: Throwable -> L20
        goto L4
    L12:
        Iterator<String> r13 = ArgoProtocol.INSTANCE.extractFalconHosts(new l("-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+", kotlin.text.m.IGNORE_CASE).replace(r20, ""), r24).iterator();
    L14:
        if (r13.hasNext() == false) goto L19;
        if (addItem$default(this, "falcon", r13.next(), ProtonStealth.PORT, "A", r21, r22, r25, null, 128, null) == false) goto L14;
        r8 = r8 + 1;
        goto L14
    L19:
        return new Absorbed(r10, r8, r11);
    }

    public static /* synthetic */ Absorbed absorbText$default(ArgoPool r4, String r8, String r10, long r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 16) == 0) goto L9;
        r13 = false;
    L9:
        return r4.absorbText(r8, r10, r11, r12, r13);
    }

    public static final /* synthetic */ boolean access$carry(ArgoPool r4, int r8) {
        return r4.carry(r8);
    }

    public static final /* synthetic */ void access$changed(ArgoPool r4) {
        r4.changed();
    }

    public static final /* synthetic */ sd.j access$download(ArgoPool r4, int r8, String r10, long r11, long r12, boolean r13) {
        return r4.download(r8, r10, r11, r12, r13);
    }

    public static final /* synthetic */ ArgoProtocol.Endpoint access$endpointOf(ArgoPool r4, Item r8) {
        return r4.endpointOf(r8);
    }

    public static final /* synthetic */ int access$freePort(ArgoPool r4) {
        return r4.freePort();
    }

    public static final /* synthetic */ Context access$getApp$p() {
        return app;
    }

    public static final /* synthetic */ Prefs access$getPrefs$p() {
        return prefs;
    }

    public static final /* synthetic */ HashMap access$getResults$p() {
        return results;
    }

    public static final /* synthetic */ boolean access$getScanCancel$p() {
        return scanCancel;
    }

    public static final /* synthetic */ HashMap access$getSourceState$p() {
        return sourceState;
    }

    public static final /* synthetic */ boolean access$getTestCancel$p() {
        return testCancel;
    }

    public static final /* synthetic */ boolean access$getUpdateCancel$p() {
        return updateCancel;
    }

    public static final /* synthetic */ int access$harvestOfficial(ArgoPool r4, Source r8, ArgoNet.Route r10) {
        return r4.harvestOfficial(r8, r10);
    }

    public static final /* synthetic */ Object access$harvestTelegram(ArgoPool r4, Source r8, int r10, ArgoNet.Route r11, ee.e r12, ee.a r13, wd.d r14) {
        return r4.harvestTelegram(r8, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ int access$harvestUrl(ArgoPool r4, Source r8, ArgoNet.Route r10, ee.a r11) {
        return r4.harvestUrl(r8, r10, r11);
    }

    public static final /* synthetic */ boolean access$hasGlobalV6(ArgoPool r4) {
        return r4.hasGlobalV6();
    }

    public static final /* synthetic */ Object access$measureExits(ArgoPool r4, List r8, String r10, wd.d r11) {
        return r4.measureExits(r8, r10, r11);
    }

    public static final /* synthetic */ List access$sampleV4(ArgoPool r4, int r8) {
        return r4.sampleV4(r8);
    }

    public static final /* synthetic */ List access$sampleV6(ArgoPool r4, int r8) {
        return r4.sampleV6(r8);
    }

    public static final /* synthetic */ void access$savePrefs(ArgoPool r4) {
        r4.savePrefs();
    }

    public static final /* synthetic */ void access$saveSoon(ArgoPool r4) {
        r4.saveSoon();
    }

    public static final /* synthetic */ void access$setCleanScan$p(sf.c r4) {
        cleanScan = r4;
    }

    public static final /* synthetic */ void access$setIpScan$p(IpScan r4) {
        ipScan = r4;
    }

    public static final /* synthetic */ void access$setPrefs$p(Prefs r4) {
        prefs = r4;
    }

    public static final /* synthetic */ void access$setSaveQueued$p(boolean r4) {
        saveQueued = r4;
    }

    public static final /* synthetic */ void access$setTestJob$p(Job r4) {
        testJob = r4;
    }

    public static final /* synthetic */ void access$setUpdateJob$p(Job r4) {
        updateJob = r4;
    }

    public static final /* synthetic */ Proxy access$socks(ArgoPool r4, int r8) {
        return r4.socks(r8);
    }

    public static final /* synthetic */ Object access$speedThrough(ArgoPool r4, String r8, Item r10, ArgoProtocol.SessionInfo r11, wd.d r12) {
        return r4.speedThrough(r8, r10, r11, r12);
    }

    public static final /* synthetic */ Object access$telegramPageRetry(ArgoPool r4, String r8, Long r10, ArgoNet.Route r11, ee.a r12, wd.d r13) {
        return r4.telegramPageRetry(r8, r10, r11, r12, r13);
    }

    public static final /* synthetic */ Trace access$traceVia(ArgoPool r4, int r8) {
        return r4.traceVia(r8);
    }

    public static final /* synthetic */ Object access$waitPort(ArgoPool r4, int r8, long r10, wd.d r11) {
        return r4.waitPort(r8, r10, r11);
    }

    private final synchronized boolean addItem(String r28, String r29, int r30, String r31, String r32, long r33, boolean r35, String r36) {
        int r4 = r30;
        long r8 = r33;
        monitor-enter(this);
        String r10 = r29.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L18
        j.d(r10, "toLowerCase(...)");     // Catch: Throwable -> L18
        String r12 = o.q1(r10, new char[]{'.'});     // Catch: Throwable -> L18
        if (ArgoProtocol.INSTANCE.looksLikeHost(r12) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        if (1 <= r4) goto L10;
    L12:
        r4 = ProtonStealth.PORT;
    L11:
        int r13 = r4;
        String r11 = idOf(r28, r12, r13);     // Catch: Throwable -> L18
        LinkedHashMap<String, Item> r14 = items;     // Catch: Throwable -> L18
        Item r15 = r14.get(r11);     // Catch: Throwable -> L18
        if (r15 == null) goto L25;
        if (r8 <= r15.getSeen()) goto L20;
        r15.setSeen(r8);     // Catch: Throwable -> L18
    L20:
        if (r35 == false) goto L22;
        r15.setUser(true);     // Catch: Throwable -> L18
    L22:
        monitor-exit(this);
        return false;
    L25:
        if (j.a(r31, "B") == false) goto L28;
        String r16 = "B";
    L27:
        String r17 = r16;
        if (r8 > 0) goto L33;
        r8 = System.currentTimeMillis();     // Catch: Throwable -> L18
    L33:
        r14.put(r11, new Item(r11, r28, r12, r13, r17, r32, null, r8, r35, r36, null, 0, null, 7232, null));     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    L28:
        r16 = "A";
        goto L27
    L10:
        if (r4 >= 65536) goto L12;
    L18:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean addItem$default(ArgoPool r12, String r13, String r14, int r15, String r16, String r17, long r18, boolean r20, String r21, int r22, Object r23) {
        if ((r22 & 64) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r22 & 128) == 0) goto L10;
        String r11 = "";
    L12:
        return r12.addItem(r13, r14, r15, r16, r17, r18, r10, r11);
    L10:
        r11 = r21;
        goto L12
    L5:
        r10 = r20;
        goto L7
    }

    private static final CharSequence addSource$lambda$61(byte r4) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r4)}, 1));
    }

    public static /* synthetic */ boolean b(Map.Entry r4) {
        return load$lambda$20(r4);
    }

    public static /* synthetic */ CharSequence c(kotlin.text.g r4) {
        return decodeHtml$lambda$42(r4);
    }

    private final boolean carry(int r10) {
        if (((Number) download(r10, CARRY_URL, 262144, GerehWatchdog.STUCK_MS, true).getSecond()).longValue() < 250000) goto L6;
        return true;
    L6:
        return false;
    }

    private final String ccOf(Item r4) {
        Result r8 = results.get(r4.getId());
        if (r8 == null) goto L15;
        String r10 = r8.getCc();
        if (r10 == null) goto L15;
        if (o.L0(r10) == false) goto L9;
    L11:
        r10 = null;
    L12:
        if (r10 == null) goto L15;
        return r10;
    L9:
        if (r10.equals("??") == true) goto L11;
    L15:
        String r11 = r4.getCc0();
        if (o.L0(r11) == false) goto L18;
        return "??";
    L18:
        return r11;
    }

    private final void changed() {
        k0 r4 = _version;
        Long r8 = Long.valueOf(((Number) ((g1) r4).getValue()).longValue() + 1);
        g1 r10 = (g1) r4;
        r10.getClass();
        r10.k(null, r8);
    }

    private final OkHttpClient client(int r4, long r8) {
        OkHttpClient.Builder r10 = new OkHttpClient.Builder();
        r10.e(socks(r4));
        TimeUnit r11 = TimeUnit.MILLISECONDS;
        r10.b(r8, r11);
        r10.g(r8, r11);
        r10.a(r8, r11);
        r10.f29106f = false;
        return new OkHttpClient(r10);
    }

    public static /* synthetic */ Comparable d(Item r4) {
        return rows$lambda$118(r4);
    }

    private final String decodeHtml(String r4) {
        String r8 = new l("<br\\s*/?>", kotlin.text.m.IGNORE_CASE).replace(r4, "\n");
        String r10 = v.q0(v.q0(v.q0(v.q0(v.q0(new l("<[^>]+>").replace(r8, ""), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&#39;", "'"), "&nbsp;", " ");
        return v.q0(new l("&#(\\d+);").replace(r10, new d(2)), "&amp;", "&");
    }

    private static final CharSequence decodeHtml$lambda$42(kotlin.text.g r4) {
        j.e(r4, "m");
        Integer r8 = v.v0((String) ((f0) ((kotlin.text.i) r4).a()).get(1));
        if (r8 == null) goto L6;
        char[] r10 = Character.toChars(r8.intValue());
        j.d(r10, "toChars(...)");
        return new String(r10);
    L6:
        return "";
    }

    private final sd.j download(int r8, String r10, long r11, long r12, boolean r14) {
        Request.Builder r4 = new Request.Builder();     // Catch: Throwable -> L6
        r4.j(r10);     // Catch: Throwable -> L6
        r4.d("User-Agent", CARRY_UA);     // Catch: Throwable -> L6
        if (r14 == false) goto L8;
        r4.d("Range", "bytes=0-" + (r11 - 1));     // Catch: Throwable -> L6
    L8:
        Response r13 = client(r8, r12).b(new Request(r4)).d();     // Catch: Throwable -> L6
        ResponseBody r15 = r13.f29156h;     // Catch: Throwable -> L24
        int r16 = r13.f29153d;
        if (r15 == null) goto L27;
        we.j r17 = r15.j();     // Catch: Throwable -> L24
        if (r17 == null) goto L27;
        we.h r18 = new we.h();     // Catch: Throwable -> L24
        long r19 = 0;
    L18:
        if (r19 >= r11) goto L26;
        long r20 = r17.s(r18, 65536);     // Catch: Throwable -> L24 IOException -> L40
        if (r20 < 0) goto L26;
        r19 = r19 + r20;     // Catch: Throwable -> L24 IOException -> L40
        r18.c();     // Catch: Throwable -> L24 IOException -> L40
    L26:
        sd.j r110 = new sd.j(Integer.valueOf(r16), Long.valueOf(r19));     // Catch: Throwable -> L24
    L28:
        r13.close();     // Catch: Throwable -> L6
        Object r21 = sd.l.m1004constructorimpl(r110);     // Catch: Throwable -> L6
    L35:
        sd.j r111 = new sd.j(0, 0L);
        if (sd.l.m1010isFailureimpl(r21) == false) goto L39;
        r21 = r111;
    L39:
        return (sd.j) r21;
    L27:
        r110 = new sd.j(Integer.valueOf(r16), 0L);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        a.a.g(r13, th);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r21 = sd.l.m1004constructorimpl(m.a(th));
        goto L35
    }

    public static /* synthetic */ Comparable e(Item r4) {
        return rows$lambda$119(r4);
    }

    private final ArgoProtocol.Endpoint endpointOf(Item r8) {
        return new ArgoProtocol.Endpoint(r8.getId(), r8.getKind(), r8.getHost(), r8.getPort(), r8.getProtocol());
    }

    public static /* synthetic */ Comparable f(Group r4) {
        return summary$lambda$106(r4);
    }

    private final int freePort() {
        ServerSocket r4 = new ServerSocket(0);
        int r8 = r4.getLocalPort();     // Catch: Throwable -> L6
        r4.close();
        return r8;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        a.a.g(r4, th);
        throw th;
    }

    public static /* synthetic */ Comparable g(Group r4) {
        return summary$lambda$105(r4);
    }

    private final String githubRaw(String r8) {
        kotlin.text.g r4 = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/]+)/(?:blob|raw)/(.+)$", kotlin.text.m.IGNORE_CASE), r8, 0, 2, null);
        if (r4 != null) goto L5;
        return r8;
    L5:
        kotlin.text.i r10 = (kotlin.text.i) r4;
        return "https://raw.githubusercontent.com/" + ((f0) r10.a()).get(1) + "/" + ((f0) r10.a()).get(2) + "/" + ((f0) r10.a()).get(3);
    }

    public static /* synthetic */ Comparable h(ArgoProtocol.FalconOrigin r4) {
        return summary$lambda$111(r4);
    }

    private final int harvestOfficial(Source r20, ArgoNet.Route r21) {
        if (j.a(r20.getType(), "snowcfg") == false) goto L21;
        Iterator<String> r4 = r20.getValue().iterator();
    L6:
        if (r4.hasNext() == false) goto L19;
        sd.j r8 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, r4.next(), r21, 0, 0, 12, null);
        int r10 = ((Number) r8.component1()).intValue();
        String r11 = (String) r8.component2();
        if (r10 != 200) goto L6;
        ArgoProtocol r12 = ArgoProtocol.INSTANCE;     // Catch: Throwable -> L42
        ArgoProtocol.Snowcfg r13 = r12.decodeSnowcfg(r11);     // Catch: Throwable -> L42
        if (r13.getSigOk() == false) goto L6;
        Iterator<ArgoProtocol.PublicServer> r14 = r12.publicServersOf(r13.getParams()).iterator();     // Catch: Throwable -> L42
        int r15 = 0;
    L13:
        if (r14.hasNext() == false) goto L17;
        ArgoProtocol.PublicServer r16 = r14.next();     // Catch: Throwable -> L42
        if (addItem$default(this, "public", r16.getHost(), r16.getPort(), "A", r20.getId(), r13.getIssuedMs(), false, r16.getProfile(), 64, null) == false) goto L13;
        r15 = r15 + 1;
        goto L13
    L17:
        return r15;
    L19:
        throw new IllegalStateException("هیچ\u200cکدام از نشانی\u200cهای فهرست رسمی جواب نداد");
    L21:
        if (j.a(r20.getType(), "falcon-servers") == false) goto L41;
        Iterator<String> r17 = r20.getValue().iterator();
    L24:
        if (r17.hasNext() == false) goto L39;
        sd.j r18 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, r17.next(), r21, 0, 0, 12, null);
        int r19 = ((Number) r18.component1()).intValue();
        String r22 = (String) r18.component2();
        if (r19 != 200) goto L24;
        List<ArgoProtocol.FalconOrigin> r23 = ArgoProtocol.INSTANCE.decodeFalconServers(r22);     // Catch: Throwable -> L44
        if (r23.isEmpty() == true) goto L24;
        falconServers = r23;     // Catch: Throwable -> L44
        sf.c r24 = new sf.c();     // Catch: Throwable -> L44
        r24.D("at", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L44
        List<ArgoProtocol.FalconOrigin> r25 = r23;     // Catch: Throwable -> L44
        ArrayList r26 = new ArrayList(kotlin.collections.s.g0(r25, 10));     // Catch: Throwable -> L44
        Iterator<T> r27 = r25.iterator();     // Catch: Throwable -> L44
    L31:
        if (r27.hasNext() == false) goto L33;
        ArgoProtocol.FalconOrigin r28 = (ArgoProtocol.FalconOrigin) r27.next();     // Catch: Throwable -> L44
        sf.c r29 = new sf.c();     // Catch: Throwable -> L44
        r29.D("ip", r28.getIp());     // Catch: Throwable -> L44
        r29.D(AwgProbeService.KEY_COUNTRY, r28.getCc());     // Catch: Throwable -> L44
        r29.D("load", Double.valueOf(r28.getLoad()));     // Catch: Throwable -> L44
        r26.add(r29);     // Catch: Throwable -> L44
        goto L31
    L33:
        r24.D("falconServers", new sf.a(r26));     // Catch: Throwable -> L44
        String r30 = r24.toString();     // Catch: Throwable -> L44
        j.d(r30, "toString(...)");     // Catch: Throwable -> L44
        writeJson("remote.json", r30);     // Catch: Throwable -> L43
    L39:
        throw new IllegalStateException("فهرست سرورهای فالکن گرفته نشد");
    L41:
        return 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x026c -> B:86:0x0277). Please report as a decompilation issue!!! */
    private final Object harvestTelegram(Source r29, int r30, ArgoNet.Route r31, ee.e r32, ee.a r33, wd.d r34) {
        if ((r34 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) r34;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
        ArgoPool r10 = this;
    L8:
        Object r11 = r4.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r4.label;
        int r14 = 1;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        int r15 = r4.I$3;
        int r16 = r4.I$2;
        int r17 = r4.I$1;
        int r18 = r4.I$0;
        Long r19 = (Long) r4.L$5;
        ee.a r110 = (ee.a) r4.L$4;
        ee.e r111 = (ee.e) r4.L$3;
        ArgoNet.Route r112 = (ArgoNet.Route) r4.L$2;
        Source r113 = (Source) r4.L$1;
        ArgoPool r20 = (ArgoPool) r4.L$0;
        m.b(r11);
        int r114 = r15;
        ee.e r21 = r111;
        int r26 = 1;
        Source r22 = r113;
        int r115 = r17;
        Long r23 = r19;
        ee.a r116 = r110;
        AnonymousClass1 r117 = r4;
        int r24 = r18;
        ArgoNet.Route r118 = r112;
        int r119 = r16;
        r12 = r12;
        char r25 = 2;
    L86:
        r12 = r12;
        r14 = r26;
    L17:
        if (r115 >= r24) goto L92;
        if (((Boolean) r116.invoke()).booleanValue() == true) goto L92;
        String r27 = (String) q.y0(r22.getValue());
        r117.L$0 = r20;
        r117.L$1 = r22;
        r117.L$2 = r118;
        r117.L$3 = r21;
        r117.L$4 = r116;
        r117.L$5 = r23;
        r117.I$0 = r24;
        r117.I$1 = r115;
        r117.I$2 = r119;
        r117.I$3 = r114;
        r117.label = r14;
        Object r28 = r20.telegramPageRetry(r27, r23, r118, r116, r117);
        if (r28 == r12) goto L84;
        int r210 = r119;
        Source r120 = r22;
        r11 = r28;
        int r35 = r115;
        ArgoPool r121 = r20;
        int r36 = r210;
        Long r211 = r23;
        int r37 = r24;
        r4 = r117;
        ee.e r122 = r21;
        int r38 = r114;
        ArgoNet.Route r123 = r118;
        Long r124 = r211;
    L24:
        Page r39 = (Page) r11;
        if (r39.getOk() == true) goto L37;
        if (r35 != 0) goto L90;
        if (r39.getCode() != 0) goto L32;
        if (r123 == null) goto L31;
        String r40 = w0.n("تلگرام از راه «", r123.getLabel(), "» هم جواب نداد — اتصال همان موتور را بررسی کنید");
    L34:
        throw new IllegalStateException(r40);
    L31:
        r40 = "تلگرام روی این اینترنت فیلتر است — اول یکی از موتورها (یا خود آرگو) را وصل کنید و دوباره «به\u200cروزرسانی» را بزنید";
        goto L34
    L32:
        r40 = androidx.compose.foundation.interaction.f.o(r39.getCode(), "کانال جواب نداد (کد ", ") — نام کانال را بررسی کنید");
    L90:
        r119 = r36;
        goto L92
    L37:
        if (r39.getPosts().isEmpty() == true) goto L90;
        Iterator<Post> r212 = r39.getPosts().iterator();
        int r213 = 0;
    L39:
        r26 = r14;
        r36 = r36;
        if (r212.hasNext() == false) goto L55;
        Post r125 = r212.next();
        String r41 = r125.getText();
        if (r41.length() == 0) goto L44;
        Page r310 = r39;
        if (new l("فالکن|falcon", kotlin.text.m.IGNORE_CASE).containsMatchIn(r41) == true) goto L49;
        r41 = q.F0(o.Q0(r41), "\n", null, null, new d(3), 30);
    L49:
        String r126 = r120.getId();
        if (r125.getAt() <= 0) goto L53;
        long r42 = r125.getAt();
    L54:
        Absorbed r43 = absorbText$default(r121, r41, r126, r42, false, false, 24, null);
        r213 = (r43.getFalcons() + r43.getBridges()) + r213;
        r39 = r310;
        goto L44
    L53:
        r42 = System.currentTimeMillis();
    L44:
        r14 = r26;
        goto L39
    L55:
        Page r311 = r39;
        int r44 = r36 + r213;
        int r45 = r35 + 1;
        r122.invoke(new Integer(r45), new Integer(r44));
        if (r213 <= 0) goto L58;
        int r46 = 0;
    L60:
        if (r46 < 6) goto L68;
        sf.c r47 = sourceState.get(r120.getId());
        if (r47 == null) goto L64;
        long r48 = 0;
        long r49 = r47.x(0, "at");
    L66:
        if (r49 <= r48) goto L69;
    L87:
        r119 = r44;
    L69:
        Iterator<T> r50 = r311.getPosts().iterator();
        if (r50.hasNext() == false) goto L89;
        long r51 = ((Post) r50.next()).getId();
    L73:
        if (r50.hasNext() == false) goto L77;
        long r127 = ((Post) r50.next()).getId();
        if (r51 <= r127) goto L73;
        r51 = r127;
        goto L73
    L77:
        if (r124 != null) goto L79;
    L80:
        Long r52 = new Long(r51);
        if (r51 <= 1) goto L87;
        long r53 = ((long) random.nextInt(600)) + 600;
        r4.L$0 = r121;
        r4.L$1 = r120;
        r4.L$2 = r123;
        r4.L$3 = r122;
        r4.L$4 = r116;
        r4.L$5 = r52;
        r4.I$0 = r37;
        r4.I$1 = r45;
        r4.I$2 = r44;
        r4.I$3 = r46;
        r25 = 2;
        r4.label = 2;
        if (m0.j(r53, r4) == r12) goto L101;
        Source r54 = r120;
        r119 = r44;
        r22 = r54;
        r118 = r123;
        r20 = r121;
        r114 = r46;
        r115 = r45;
        r21 = r122;
        r117 = r4;
        r24 = r37;
        r23 = r52;
        goto L86
    L101:
        return r12;
    L79:
        if (r51 >= r124.longValue()) goto L87;
    L89:
        throw new NoSuchElementException();
    L64:
        r48 = 0;
        r49 = 0;
        goto L66
    L68:
        r12 = r12;
        goto L69
    L58:
        r46 = r38 + 1;
        goto L60
    L84:
        return r12;
    L92:
        return new Integer(r119);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r38 = r4.I$3;
        r36 = r4.I$2;
        r35 = r4.I$1;
        r37 = r4.I$0;
        r124 = (Long) r4.L$5;
        r116 = (ee.a) r4.L$4;
        r122 = (ee.e) r4.L$3;
        r123 = (ArgoNet.Route) r4.L$2;
        r120 = (Source) r4.L$1;
        r121 = (ArgoPool) r4.L$0;
        m.b(r11);
        goto L24
    L16:
        m.b(r11);
        r118 = r31;
        r21 = r32;
        r116 = r33;
        r23 = null;
        r117 = r4;
        r20 = r10;
        r114 = 0;
        r119 = 0;
        r115 = 0;
        r22 = r29;
        r24 = r30;
    L7:
        r10 = this;
        r4 = new AnonymousClass1(r10, r34);
        goto L8
    }

    private static final CharSequence harvestTelegram$lambda$47(String r4) {
        j.e(r4, XrayCoreHostService.KEY_LINE);
        if (new l("BRIDGE BLOCK|^[A-Za-z0-9+/=]{20,}$").containsMatchIn(o.n1(r4).toString()) == false) goto L5;
        return r4;
    L5:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final int harvestUrl(Source r27, ArgoNet.Route r28, ee.a r29) {
        ArgoPool r4 = this;
        String r8 = (String) q.y0(r27.getValue());
        ?? r10 = m9.d.B(r4.githubRaw(r8));
        kotlin.text.m r11 = kotlin.text.m.IGNORE_CASE;
        Object r12 = null;
        kotlin.text.g r13 = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/#?]+)/?$", r11), r8, 0, 2, null);
        kotlin.text.g r14 = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/#?]+)/(issues|discussions)", r11), r8, 0, 2, null);
        if (r14 == null) goto L9;
        kotlin.text.i r15 = (kotlin.text.i) r14;
        String r16 = "https://api.github.com/repos/" + ((f0) r15.a()).get(1) + "/" + ((f0) r15.a()).get(2);
        h r17 = new h(1, 3, 1);
        ArrayList r18 = new ArrayList();
        g r19 = r17.a();
    L6:
        if (r19.f23130c == false) goto L8;
        int r20 = r19.nextInt();
        q.m0(r18, r.a0(new String[]{f0.a.i(r20, r16, "/issues?state=all&per_page=100&page="), f0.a.i(r20, r16, "/issues/comments?per_page=100&page=")}));
        goto L6
    L8:
        ?? r110 = r18;
    L47:
        Iterator r24 = r110.iterator();
        int r25 = 0;
    L49:
        if (r24.hasNext() == false) goto L95;
        String r111 = (String) r24.next();
        if (((Boolean) r29.invoke()).booleanValue() == true) goto L95;
        sd.j r21 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, r111, r28, 0, 0, 12, null);
        int r22 = ((Number) r21.component1()).intValue();
        String r23 = (String) r21.component2();
        if (r22 != 200) goto L91;
        if (r23.length() == 0) goto L91;
        y r26 = new y();
        r26.element = r23;
        boolean r30 = new l("^\\s*[\\[{]").containsMatchIn((CharSequence) r26.element);
        u r31 = u.f67154a;
        if (r30 == true) goto L100;
    L73:
        String r32 = new l("\\s+").replace((CharSequence) r26.element, "");
        if (i.B("^[A-Za-z0-9+/=]{40,}$", r32) == true) goto L76;
    L88:
        Absorbed r33 = absorbText$default(r4, (String) r26.element, r27.getId(), System.currentTimeMillis(), true, false, 16, null);
        r25 = (r33.getFalcons() + r33.getBridges()) + r25;
    L89:
        r4 = this;
        goto L49
    L76:
        if (v.s0(r32, "eJ", false) == true) goto L88;
        String r34 = new String(ArgoProtocol.INSTANCE.b64(r32), kotlin.text.a.f23859a);     // Catch: Throwable -> L82
        if (o.z0(r34, '\n') == false) goto L80;
    L84:
        r26.element = r26.element + "\n" + r34;     // Catch: Throwable -> L82
    L85:
        sd.l.m1004constructorimpl(r31);     // Catch: Throwable -> L82
        goto L88
    L80:
        if (o.z0(r34, '.') == false) goto L85;
    L82:
        th = move-exception;
        sd.l.m1004constructorimpl(m.a(th));
        goto L88
    L100:
        if (v.s0(o.r1((String) r26.element).toString(), "[", false) == false) goto L64;
        Object r35 = new sf.a((String) r26.element);     // Catch: Throwable -> L62
    L66:
        if ((r35 instanceof sf.a) == true) goto L68;
    L69:
        ArrayList r36 = new ArrayList();     // Catch: Throwable -> L62
        r4.jsonStrings(r35, r36);     // Catch: Throwable -> L62
        r26.element = q.F0(r36, "\n", null, null, null, 62);     // Catch: Throwable -> L62
    L70:
        sd.l.m1004constructorimpl(r31);     // Catch: Throwable -> L62
        goto L73
    L68:
        if (((sf.a) r35).f67155a.size() == 0) goto L70;
    L64:
        r35 = new sf.c((String) r26.element);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        sd.l.m1004constructorimpl(m.a(th));
    L91:
        if (r110.size() != 1) goto L89;
        throw new IllegalStateException(androidx.compose.foundation.interaction.f.o(r22, "نشانی جواب نداد (کد ", ")"));
    L95:
        return r25;
    L9:
        if (r13 == null) goto L44;
        kotlin.text.i r37 = (kotlin.text.i) r13;
        sd.j r38 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, "https://api.github.com/repos/" + ((f0) r37.a()).get(1) + "/" + o.V0((String) ((f0) r37.a()).get(2), ".git") + "/contents", r28, 0, 0, 12, null);
        int r39 = ((Number) r38.component1()).intValue();
        Object r40 = sd.l.m1004constructorimpl(new sf.a((String) r38.component2()));     // Catch: Throwable -> L13
    L16:
        if (sd.l.m1010isFailureimpl(r40) == true) goto L19;
        r12 = r40;
    L19:
        sf.a r41 = (sf.a) r12;
        if (r41 == null) goto L46;
        h r42 = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, r41.f67155a.size());
        ArrayList r43 = new ArrayList();
        g r44 = r42.a();
    L23:
        if (r44.f23130c == false) goto L27;
        sf.c r45 = r41.q(r44.nextInt());
        if (r45 == null) goto L23;
        r43.add(r45);
        goto L23
    L27:
        ArrayList r46 = new ArrayList();
        int r47 = r43.size();
        int r48 = 0;
    L29:
        if (r48 >= r47) goto L40;
        Object r49 = r43.get(r48);
        r48 = r48 + 1;
        sf.c r50 = (sf.c) r49;
        if (j.a(r50.A(TeXSymbolParser.TYPE_ATTR, ""), "file") == false) goto L29;
        String r51 = r50.A("download_url", "");
        j.d(r51, "optString(...)");
        if (o.L0(r51) == true) goto L29;
        if (r50.x(0, "size") >= 8000000) goto L29;
        l r52 = new l("\\.(png|jpe?g|gif|webp|zip|apk|exe|pdf)$", kotlin.text.m.IGNORE_CASE);
        String r53 = r50.A("name", "");
        j.d(r53, "optString(...)");
        if (r52.containsMatchIn(r53) == true) goto L29;
        r46.add(r49);
        goto L29
    L40:
        List r54 = q.e1(r46, 30);
        r10 = new ArrayList(kotlin.collections.s.g0(r54, 10));
        Iterator r55 = r54.iterator();
    L42:
        if (r55.hasNext() == false) goto L44;
        r10.add(((sf.c) r55.next()).A("download_url", ""));
        goto L42
    L46:
        throw new IllegalStateException(androidx.compose.foundation.interaction.f.o(r39, "مخزن گیت\u200cهاب خوانده نشد (کد ", ")"));
    L13:
        th = move-exception;
        r40 = sd.l.m1004constructorimpl(m.a(th));
    L44:
        r110 = r10;
        goto L47
    }

    private final boolean hasGlobalV6() {
        Enumeration<NetworkInterface> r4 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L12
        j.d(r4, "getNetworkInterfaces(...)");     // Catch: Throwable -> L12
        ArrayList r8 = Collections.list(r4);     // Catch: Throwable -> L12
        j.d(r8, "list(...)");     // Catch: Throwable -> L12
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L12
        int r11 = r8.size();     // Catch: Throwable -> L12
        boolean r12 = false;
        int r13 = 0;
    L4:
        if (r13 >= r11) goto L14;
        Object r14 = r8.get(r13);     // Catch: Throwable -> L12
        r13 = r13 + 1;     // Catch: Throwable -> L12
        NetworkInterface r15 = (NetworkInterface) r14;     // Catch: Throwable -> L12
        if (r15.isUp() == false) goto L4;
        if (r15.isLoopback() == true) goto L4;
        String r16 = r15.getName();     // Catch: Throwable -> L12
        j.d(r16, "getName(...)");     // Catch: Throwable -> L12
        if (v.s0(r16, XrayCoreHostService.KEY_TUN, false) == true) goto L4;
        r10.add(r14);     // Catch: Throwable -> L12
        goto L4
    L14:
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L12
        int r18 = r10.size();     // Catch: Throwable -> L12
        int r19 = 0;
    L15:
        if (r19 >= r18) goto L18;
        Object r20 = r10.get(r19);     // Catch: Throwable -> L12
        r19 = r19 + 1;     // Catch: Throwable -> L12
        Enumeration<InetAddress> r21 = ((NetworkInterface) r20).getInetAddresses();     // Catch: Throwable -> L12
        j.d(r21, "getInetAddresses(...)");     // Catch: Throwable -> L12
        ArrayList r22 = Collections.list(r21);     // Catch: Throwable -> L12
        j.d(r22, "list(...)");     // Catch: Throwable -> L12
        q.m0(r17, r22);     // Catch: Throwable -> L12
        goto L15
    L18:
        if (r17.isEmpty() == true) goto L33;
        int r23 = r17.size();     // Catch: Throwable -> L12
        int r24 = 0;
    L21:
        if (r24 >= r23) goto L33;
        Object r25 = r17.get(r24);     // Catch: Throwable -> L12
        r24 = r24 + 1;     // Catch: Throwable -> L12
        InetAddress r26 = (InetAddress) r25;     // Catch: Throwable -> L12
        if ((r26 instanceof Inet6Address) == false) goto L21;
        if (((Inet6Address) r26).isLinkLocalAddress() == true) goto L21;
        if (((Inet6Address) r26).isSiteLocalAddress() == true) goto L21;
        if (((Inet6Address) r26).isLoopbackAddress() == true) goto L21;
        if ((((Inet6Address) r26).getAddress()[0] & 224) != 32) goto L21;
        r12 = true;
    L33:
        Object r27 = sd.l.m1004constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L12
    L36:
        Boolean r28 = Boolean.FALSE;
        if (sd.l.m1010isFailureimpl(r27) == false) goto L40;
        r27 = r28;
    L40:
        return ((Boolean) r27).booleanValue();
    L12:
        th = move-exception;
        r27 = sd.l.m1004constructorimpl(m.a(th));
        goto L36
    }

    public static /* synthetic */ Comparable i(Item r4) {
        return rows$lambda$120(r4);
    }

    private final String idOf(String r4, String r8, int r10) {
        char r11 = r4.charAt(0);
        if (r10 == 443) goto L5;
        String r12 = f0.a.h(r10, ":");
    L7:
        return r11 + ":" + r8 + r12;
    L5:
        r12 = "";
        goto L7
    }

    private final sf.c itemJson(Item r4) {
        sf.c r8 = new sf.c();
        r8.D(XrayCoreHostService.KEY_ID, r4.getId());
        r8.D("kind", r4.getKind());
        r8.D("host", r4.getHost());
        r8.D(PsiphonProbeService.PORT, Integer.valueOf(r4.getPort()));
        r8.D("protocol", r4.getProtocol());
        r8.D("src", r4.getSrc());
        r8.D("from", r4.getFrom());
        r8.D("seen", Long.valueOf(r4.getSeen()));
        r8.E("user", r4.getUser());
        r8.D("profile", r4.getProfile());
        r8.D("cc0", r4.getCc0());
        r8.D("v0", Long.valueOf(r4.getV0()));
        r8.D("ip0", r4.getIp0());
        return r8;
    }

    private final Item itemOf(sf.c r22) {
        String r4 = r22.A(XrayCoreHostService.KEY_ID, "");
        j.d(r4, "optString(...)");
        String r8 = r22.A("kind", "");
        j.d(r8, "optString(...)");
        String r10 = r22.A("host", "");
        j.d(r10, "optString(...)");
        int r11 = r22.t(ProtonStealth.PORT, PsiphonProbeService.PORT);
        String r12 = r22.A("protocol", "A");
        j.d(r12, "optString(...)");
        String r13 = r22.A("src", "");
        j.d(r13, "optString(...)");
        String r14 = r22.A("from", "");
        j.d(r14, "optString(...)");
        long r15 = r22.x(0, "seen");
        boolean r16 = r22.q("user", false);
        String r17 = r22.A("profile", "");
        j.d(r17, "optString(...)");
        String r18 = r22.A("cc0", "");
        j.d(r18, "optString(...)");
        long r19 = r22.x(0, "v0");
        String r20 = r22.A("ip0", "");
        j.d(r20, "optString(...)");
        return new Item(r4, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ CharSequence j(String r4) {
        return harvestTelegram$lambda$47(r4);
    }

    private final void jsonStrings(Object r4, List<String> r8) {
        if ((r4 instanceof String) == false) goto L7;
        r8.add(r4);
        return;
    L7:
        if ((r4 instanceof sf.a) == false) goto L12;
        sf.a r10 = (sf.a) r4;
        int r11 = r10.f67155a.size();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L20;
        jsonStrings(r10.m(r12), r8);
        r12 = r12 + 1;
        goto L9
    L20:
        return;
    L12:
        if ((r4 instanceof sf.c) == false) goto L17;
        sf.c r13 = (sf.c) r4;
        Iterator r14 = r13.n();
        j.d(r14, "keys(...)");
    L15:
        if (r14.hasNext() == false) goto L21;
        jsonStrings(r13.o((String) r14.next()), r8);
        goto L15
    L21:
        return;
    }

    public static /* synthetic */ Comparable k(Group r4) {
        return summary$lambda$104(r4);
    }

    public static /* synthetic */ boolean l(String r4, Source r8) {
        return removeSource$lambda$64(r4, r8);
    }

    private final synchronized void load() {
        monitor-enter(this);
    L97:
        th = move-exception;
        throw th;
    L5:
        if (loaded == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        int r4 = 1;
        loaded = true;     // Catch: Throwable -> L97
        int r8 = 0;
        Context r10 = app;     // Catch: Throwable -> L18
        if (r10 == null) goto L91;
        InputStream r11 = r10.getAssets().open(ASSET);     // Catch: Throwable -> L18
        j.d(r11, "open(...)");     // Catch: Throwable -> L18
        BufferedReader r12 = new BufferedReader(new InputStreamReader(r11, kotlin.text.a.f23859a), 8192);     // Catch: Throwable -> L18
        String r13 = com.google.android.gms.internal.auth.j.I(r12);     // Catch: Throwable -> L85
        r12.close();     // Catch: Throwable -> L18
        sf.c r14 = new sf.c(r13);     // Catch: Throwable -> L18
        sf.a r15 = r14.v("items");     // Catch: Throwable -> L18
        if (r15 != null) goto L20;
        r15 = new sf.a();     // Catch: Throwable -> L18
    L20:
        int r16 = r15.f67155a.size();     // Catch: Throwable -> L18
        int r17 = 0;
    L21:
        if (r17 >= r16) goto L75;
        sf.a r18 = r15.p(r17);     // Catch: Throwable -> L18
        if (r18 == null) goto L74;
        String r19 = r18.t(r8, "");     // Catch: Throwable -> L18
        if (j.a(r19, "b") == false) goto L30;
        String r110 = "bridge";
    L28:
        String r111 = r110;
        String r112 = r18.t(r4, "");     // Catch: Throwable -> L18
        int r113 = r18.o(2);     // Catch: Throwable -> L18
        Integer r114 = Integer.valueOf(r113);     // Catch: Throwable -> L18
        if (r113 > 0) goto L37;
        r114 = null;
    L37:
        if (r114 == null) goto L39;
        int r115 = r114.intValue();     // Catch: Throwable -> L18
    L40:
        j.b(r112);     // Catch: Throwable -> L18
        String r116 = idOf(r111, r112, r115);     // Catch: Throwable -> L18
        if (j.a(r18.t(3, ""), "B") == false) goto L48;
        String r20 = "B";
    L45:
        String r117 = r20;
        String r21 = r18.t(4, "");     // Catch: Throwable -> L46
        if (j.a(r21, "0") == false) goto L53;
        r21 = null;
    L53:
        if (r21 != null) goto L55;
        r21 = "";
    L55:
        String r118 = r21;
        long r22 = 1000;
        long r23 = r18.r(5, 0) * r22;     // Catch: Throwable -> L46
        String r24 = r18.t(6, "");     // Catch: Throwable -> L46
        if (j.a(r24, "0") == false) goto L59;
        r24 = null;
    L59:
        if (r24 != null) goto L61;
        r24 = "";
    L61:
        String r25 = r24;
        String r26 = r18.t(7, "");     // Catch: Throwable -> L46
        if (j.a(r26, "0") == false) goto L65;
        r26 = null;
    L65:
        if (r26 != null) goto L67;
        r26 = "";
    L67:
        String r27 = r26;
        long r28 = r18.r(8, 0) * r22;     // Catch: Throwable -> L46
        String r29 = r18.t(9, "");     // Catch: Throwable -> L46
        if (j.a(r29, "0") == false) goto L71;
        r29 = null;
    L71:
        if (r29 != null) goto L73;
        r29 = "";
    L73:
        Item r119 = new Item(r116, r111, r112, r115, r117, "bundled", r118, r23, false, r25, r27, r28, r29, 256, null);     // Catch: Throwable -> L46
        items.put(r119.getId(), r119);     // Catch: Throwable -> L46
        goto L74
    L48:
        r20 = "A";
        goto L45
    L39:
        r115 = ProtonStealth.PORT;
        goto L40
    L30:
        if (j.a(r19, "f") == false) goto L32;
        r110 = "falcon";
        goto L28
    L32:
        r110 = "public";
    L74:
        r17 = r17 + 1;
        r4 = 1;
        r8 = 0;
        goto L21
    L75:
        List<ArgoProtocol.FalconOrigin> r30 = null;
        Object r31 = sd.l.m1004constructorimpl(Long.valueOf(Instant.parse(r14.A("built", "")).toEpochMilli()));     // Catch: Throwable -> L78
    L81:
        if (sd.l.m1010isFailureimpl(r31) == false) goto L83;
        r31 = 0L;
    L83:
        bundleBuilt = ((Number) r31).longValue();     // Catch: Throwable -> L46
        falconServers = parseFalconServers(r14.v("falconServers"));     // Catch: Throwable -> L46
        Object r32 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L46
    L94:
        Throwable r33 = sd.l.m1007exceptionOrNullimpl(r32);     // Catch: Throwable -> L97
        if (r33 == null) goto L99;
        Log.w(TAG, "bundle unreadable: " + r33.getMessage());     // Catch: Throwable -> L97
    L99:
        String r34 = readJson("pool.json");     // Catch: Throwable -> L97
        if (r34 == null) goto L119;
        ArgoPool r35 = INSTANCE;     // Catch: Throwable -> L97
        sf.a r36 = new sf.a(r34);     // Catch: Throwable -> L110
        int r37 = r36.f67155a.size();     // Catch: Throwable -> L110
        int r38 = 0;
    L103:
        if (r38 >= r37) goto L115;
        Item r39 = r35.itemOf(r36.h(r38));     // Catch: Throwable -> L110
        LinkedHashMap<String, Item> r40 = items;     // Catch: Throwable -> L110
        Item r41 = r40.get(r39.getId());     // Catch: Throwable -> L110
        String r120 = r39.getId();     // Catch: Throwable -> L110
        if (r41 == null) goto L113;
        String r121 = r39.getCc0();     // Catch: Throwable -> L110
        if (o.L0(r121) == false) goto L112;
        r121 = r41.getCc0();     // Catch: Throwable -> L110
    L112:
        String r42 = r120;
        r39 = Item.copy$default(r39, null, null, null, 0, null, null, null, 0, false, null, r121, Math.max(r39.getV0(), r41.getV0()), null, 5119, null);     // Catch: Throwable -> L110
    L114:
        r40.put(r42, r39);     // Catch: Throwable -> L110
        r38 = r38 + 1;     // Catch: Throwable -> L110
        goto L103
    L113:
        r42 = r120;
        goto L114
    L115:
        Object r43 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L110
    L118:
        sd.l.m1003boximpl(r43);     // Catch: Throwable -> L97
        goto L119
    L110:
        th = move-exception;
        r43 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
    L119:
        String r44 = readJson("results.json");     // Catch: Throwable -> L97
        if (r44 == null) goto L132;
        ArgoPool r45 = INSTANCE;     // Catch: Throwable -> L97
        sf.c r46 = new sf.c(r44);     // Catch: Throwable -> L126
        Iterator r47 = r46.n();     // Catch: Throwable -> L126
        j.d(r47, "keys(...)");     // Catch: Throwable -> L126
    L124:
        if (r47.hasNext() == false) goto L128;
        String r48 = (String) r47.next();     // Catch: Throwable -> L126
        results.put(r48, r45.resultOf(r46.h(r48)));     // Catch: Throwable -> L126
        goto L124
    L128:
        Object r49 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L126
    L131:
        sd.l.m1003boximpl(r49);     // Catch: Throwable -> L97
        goto L132
    L126:
        th = move-exception;
        r49 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
    L132:
        Set<Map.Entry<String, Result>> r50 = results.entrySet();     // Catch: Throwable -> L97
        j.d(r50, "<get-entries>(...)");     // Catch: Throwable -> L97
        q.U0(r50, new d(11));     // Catch: Throwable -> L97
        String r51 = readJson("sources.json");     // Catch: Throwable -> L97
        if (r51 != null) goto L200;
    L156:
        String r52 = readJson("prefs.json");     // Catch: Throwable -> L97
        if (r52 != null) goto L204;
    L163:
        String r53 = readJson("remote.json");     // Catch: Throwable -> L97
        if (r53 != null) goto L196;
    L179:
        Iterator<Source> r54 = BUILTIN.iterator();     // Catch: Throwable -> L97
    L180:
        if (r54.hasNext() == false) goto L190;
        Source r55 = r54.next();     // Catch: Throwable -> L97
        HashMap<String, sf.c> r56 = sourceState;     // Catch: Throwable -> L97
        if (r56.containsKey(r55.getId()) == true) goto L180;
        if (bundleBuilt <= 0) goto L180;
        String r57 = r55.getId();     // Catch: Throwable -> L97
        sf.c r58 = new sf.c();     // Catch: Throwable -> L97
        r58.D("at", Long.valueOf(bundleBuilt));     // Catch: Throwable -> L97
        r58.D("found", 0);     // Catch: Throwable -> L97
        r58.E("on", true);     // Catch: Throwable -> L97
        r56.put(r57, r58);     // Catch: Throwable -> L97
        goto L180
    L190:
        monitor-exit(this);
        return;
    L196:
        List<ArgoProtocol.FalconOrigin> r59 = INSTANCE.parseFalconServers(new sf.c(r53).v("falconServers"));     // Catch: Throwable -> L172
        if (r59.isEmpty() == false) goto L170;
        r59 = r30;
    L170:
        if (r59 == null) goto L174;
        falconServers = r59;     // Catch: Throwable -> L172
        Object r60 = u.f67154a;     // Catch: Throwable -> L172
    L175:
        Object r61 = sd.l.m1004constructorimpl(r60);     // Catch: Throwable -> L172
    L178:
        sd.l.m1003boximpl(r61);     // Catch: Throwable -> L97
        goto L179
    L174:
        r60 = r30;
    L172:
        th = move-exception;
        r61 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
        goto L178
    L204:
        sf.c r62 = new sf.c(r52);     // Catch: Throwable -> L160
        String r63 = r62.A("cleanIp", "");     // Catch: Throwable -> L160
        j.d(r63, "optString(...)");     // Catch: Throwable -> L160
        prefs = new Prefs(r63, r62.q("autoClean", false));     // Catch: Throwable -> L160
        cleanScan = r62.w("cleanScan");     // Catch: Throwable -> L160
        Object r64 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L160
    L162:
        sd.l.m1003boximpl(r64);     // Catch: Throwable -> L97
        goto L163
    L160:
        th = move-exception;
        r64 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
        goto L162
    L200:
        sf.c r65 = new sf.c(r51);     // Catch: Throwable -> L137
        sf.a r66 = r65.v("list");     // Catch: Throwable -> L137
        if (r66 != null) goto L139;
        r66 = new sf.a();     // Catch: Throwable -> L137
    L139:
        int r67 = r66.f67155a.size();     // Catch: Throwable -> L137
        int r68 = 0;
    L140:
        if (r68 >= r67) goto L145;
        sf.c r69 = r66.q(r68);     // Catch: Throwable -> L137
        if (r69 == null) goto L144;
        List<Source> r70 = userSources;     // Catch: Throwable -> L137
        String r71 = r69.A(XrayCoreHostService.KEY_ID, "");     // Catch: Throwable -> L137
        j.d(r71, "optString(...)");     // Catch: Throwable -> L137
        String r72 = r69.A(TeXSymbolParser.TYPE_ATTR, "");     // Catch: Throwable -> L137
        j.d(r72, "optString(...)");     // Catch: Throwable -> L137
        List r122 = m9.d.B(r69.A("value", ""));     // Catch: Throwable -> L137
        String r123 = r69.A("label", "");     // Catch: Throwable -> L137
        j.d(r123, "optString(...)");     // Catch: Throwable -> L137
        r70.add(new Source(r71, r72, r122, r123, false, true, r69.x(0, "addedAt")));     // Catch: Throwable -> L137
    L144:
        r68 = r68 + 1;     // Catch: Throwable -> L137
        goto L140
    L145:
        sf.c r73 = r65.w("state");     // Catch: Throwable -> L137
        if (r73 != null) goto L148;
        r73 = new sf.c();     // Catch: Throwable -> L137
    L148:
        Iterator r74 = r73.n();     // Catch: Throwable -> L137
        j.d(r74, "keys(...)");     // Catch: Throwable -> L137
    L150:
        if (r74.hasNext() == false) goto L152;
        String r75 = (String) r74.next();     // Catch: Throwable -> L137
        sourceState.put(r75, r73.h(r75));     // Catch: Throwable -> L137
        goto L150
    L152:
        Object r76 = sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L137
    L155:
        sd.l.m1003boximpl(r76);     // Catch: Throwable -> L97
        goto L156
    L137:
        th = move-exception;
        r76 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
    L78:
        th = move-exception;
        r31 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L46
        goto L81
    L85:
        th = move-exception;
        r30 = null;
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        a.a.g(r12, th);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L91:
        j.k("app");     // Catch: Throwable -> L46
        throw null;     // Catch: Throwable -> L46
    L46:
        th = th;
    L93:
        r32 = sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L97
    L18:
        th = th;
        r30 = null;
        goto L93
    }

    private static final boolean load$lambda$20(Map.Entry r4) {
        j.e(r4, "<destruct>");
        Object r8 = r4.getValue();
        j.d(r8, "component2(...)");
        Result r10 = (Result) r8;
        if (r10.getFrozen() == true) goto L5;
        return false;
    L5:
        if (r10.getAt() >= CARRY_UA_FIXED_AT) goto L10;
        return true;
    L10:
        return false;
    }

    private final Object measureExits(List<Ready> r4, String r8, wd.d r10) {
        return m0.i(new AnonymousClass2(r4, r8, null), r10);
    }

    private final List<ArgoProtocol.FalconOrigin> parseFalconServers(sf.a r10) {
        if (r10 == null) goto L5;
        int r4 = r10.f67155a.size();
    L6:
        h r8 = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, r4);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r8.iterator();
    L8:
        if (r12.hasNext() == false) goto L15;
        int r13 = ((g) r12).nextInt();
        j.b(r10);
        sf.c r14 = r10.q(r13);
        if (r14 == null) goto L12;
        String r15 = r14.A("ip", "");
        j.d(r15, "optString(...)");
        String r16 = r14.A(AwgProbeService.KEY_COUNTRY, "??");
        j.d(r16, "optString(...)");
        ArgoProtocol.FalconOrigin r17 = new ArgoProtocol.FalconOrigin(r15, r16, r14.s("load", 0.0d));
    L13:
        if (r17 == null) goto L8;
        r11.add(r17);
        goto L8
    L12:
        r17 = null;
        goto L13
    L15:
        return r11;
    L5:
        r4 = 0;
        goto L6
    }

    public static /* synthetic */ List pick$default(ArgoPool r4, int r8, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r8 = 3;
    L6:
        return r4.pick(r8);
    }

    private final String readJson(String r4) {
        Object r8 = null;
        File r10 = dir;     // Catch: Throwable -> L13
        if (r10 == null) goto L15;
        File r11 = new File(r10, r4);     // Catch: Throwable -> L13
        if (r11.exists() == true) goto L9;
        r11 = null;
    L9:
        if (r11 == null) goto L11;
        String r12 = ce.o.n0(r11, kotlin.text.a.f23859a);     // Catch: Throwable -> L13
    L12:
        Object r13 = sd.l.m1004constructorimpl(r12);     // Catch: Throwable -> L13
    L19:
        if (sd.l.m1010isFailureimpl(r13) == true) goto L23;
        r8 = r13;
    L23:
        return (String) r8;
    L11:
        r12 = null;
        goto L12
    L15:
        j.k("dir");     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13 = sd.l.m1004constructorimpl(m.a(th));
        goto L19
    }

    public static /* synthetic */ void record$default(ArgoPool r13, String r14, boolean r15, long r16, String r18, String r19, String r20, boolean r21, String r22, int r23, Object r24) {
        if ((r23 & 4) == 0) goto L5;
        long r8 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        String r10 = "";
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r11 = "";
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r12 = "";
    L19:
        if ((r23 & 64) == 0) goto L21;
        boolean r17 = false;
    L23:
        if ((r23 & 128) == 0) goto L26;
        String r110 = "";
    L27:
        r13.record(r14, r15, r8, r10, r11, r12, r17, r110);
        return;
    L26:
        r110 = r22;
        goto L27
    L21:
        r17 = r21;
        goto L23
    L17:
        r12 = r20;
        goto L19
    L13:
        r11 = r19;
        goto L15
    L9:
        r10 = r18;
        goto L11
    L5:
        r8 = r16;
        goto L7
    }

    private final synchronized List<Item> refHosts(int r14) {
        monitor-enter(this);
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L9
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L9
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L9
        Iterator<T> r10 = r4.iterator();     // Catch: Throwable -> L9
    L5:
        if (r10.hasNext() == false) goto L11;
        Object r11 = r10.next();     // Catch: Throwable -> L9
        if (j.a(((Item) r11).getKind(), "falcon") == true) goto L5;
        r8.add(r11);     // Catch: Throwable -> L9
        goto L5
    L11:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L9
        int r13 = r8.size();     // Catch: Throwable -> L9
        int r15 = 0;
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L19;
        Object r17 = r8.get(r16);     // Catch: Throwable -> L9
        r16 = r16 + 1;     // Catch: Throwable -> L9
        Result r18 = results.get(((Item) r17).getId());     // Catch: Throwable -> L9
        if (r18 == null) goto L13;
        if (r18.getOk() != true) goto L13;
        r12.add(r17);     // Catch: Throwable -> L9
        goto L13
    L19:
        List r19 = q.b1(r12, new ArgoPool$refHosts$$inlined$sortedBy$1());     // Catch: Throwable -> L9
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L9
        int r21 = r8.size();     // Catch: Throwable -> L9
        int r22 = 0;
    L21:
        if (r22 >= r21) goto L30;
        Object r23 = r8.get(r22);     // Catch: Throwable -> L9
        r22 = r22 + 1;     // Catch: Throwable -> L9
        Item r110 = (Item) r23;     // Catch: Throwable -> L9
        if (r110.getV0() <= 0) goto L21;
        Result r24 = results.get(r110.getId());     // Catch: Throwable -> L9
        if (r24 == null) goto L29;
        if (r24.getOk() == true) goto L21;
    L29:
        r20.add(r23);     // Catch: Throwable -> L9
        goto L21
    L30:
        List r25 = q.b1(r20, new ArgoPool$refHosts$$inlined$sortedByDescending$1());     // Catch: Throwable -> L9
        ArrayList r26 = new ArrayList();     // Catch: Throwable -> L9
        int r27 = r8.size();     // Catch: Throwable -> L9
    L31:
        if (r15 >= r27) goto L37;
        Object r28 = r8.get(r15);     // Catch: Throwable -> L9
        r15 = r15 + 1;     // Catch: Throwable -> L9
        Item r29 = (Item) r28;     // Catch: Throwable -> L9
        if (j.a(r29.getKind(), "public") == false) goto L31;
        if (r29.getV0() != 0) goto L31;
        r26.add(r28);     // Catch: Throwable -> L9
        goto L31
    L37:
        List<Item> r111 = q.e1(q.S0(q.S0(r19, r25), r26), r14);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r111;
    L9:
        th = move-exception;
        throw th;
    }

    private static final boolean removeSource$lambda$64(String r4, Source r8) {
        j.e(r8, "it");
        return j.a(r8.getId(), r4);
    }

    private final sf.c resultJson(Result r4) {
        sf.c r8 = new sf.c();
        r8.E("ok", r4.getOk());
        r8.D(AwgProbeService.KEY_MS, Long.valueOf(r4.getMs()));
        r8.D(AwgProbeService.KEY_COUNTRY, r4.getCc());
        r8.D("exitIp", r4.getExitIp());
        r8.D("at", Long.valueOf(r4.getAt()));
        r8.D("fails", Integer.valueOf(r4.getFails()));
        r8.D("error", r4.getError());
        r8.E("frozen", r4.getFrozen());
        r8.D("edge", r4.getEdge());
        return r8;
    }

    private final Result resultOf(sf.c r17) {
        boolean r4 = r17.q("ok", false);
        long r8 = r17.x(0, AwgProbeService.KEY_MS);
        String r10 = r17.A(AwgProbeService.KEY_COUNTRY, "");
        j.d(r10, "optString(...)");
        String r11 = r17.A("exitIp", "");
        j.d(r11, "optString(...)");
        long r12 = r17.x(0, "at");
        int r13 = r17.t(0, "fails");
        String r14 = r17.A("error", "");
        j.d(r14, "optString(...)");
        boolean r15 = r17.q("frozen", false);
        String r16 = r17.A("edge", "");
        j.d(r16, "optString(...)");
        return new Result(r4, r8, r10, r11, r12, r13, r14, r15, r16);
    }

    private final ArgoNet.Route routeNow() {
        MyVpnService.Companion r4 = MyVpnService.Companion;
        if (((g1) r4.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.CONNECTED) goto L14;
        LocalPort r8 = LocalPort.INSTANCE;
        Context r10 = app;
        if (r10 == null) goto L12;
        int r11 = r8.get(r10);
        Proxy r12 = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, r11));
        if (j.a(((g1) r4.getConnectedNodeIdFlow()).getValue(), "argo") == false) goto L9;
        String r13 = "خود آرگو";
    L11:
        return new ArgoNet.Route(r12, r13);
    L9:
        r13 = "موتور وصل برنامه (Xray)";
        goto L11
    L12:
        j.k("app");
        throw null;
    L14:
        TunnelStatus r14 = TunnelStatus.INSTANCE;
        int r15 = r14.getActiveSocksPort();
        if (r15 > 0) goto L17;
    L20:
        return null;
    L17:
        if (r14.isActive() == false) goto L20;
        return new ArgoNet.Route(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, r15)), "موتور وصل برنامه");
    }

    private final Row rowOf(Item r25) {
        Result r4 = results.get(r25.getId());
        String r8 = ccOf(r25);
        String r10 = r25.getId();
        String r11 = r25.getKind();
        String r12 = r25.getHost();
        int r13 = r25.getPort();
        boolean r14 = r25.getUser();
        String r15 = r25.getProfile();
        long r16 = r25.getV0();
        String r17 = null;
        if (r4 == null) goto L5;
        Boolean r18 = Boolean.valueOf(r4.getOk());
    L6:
        boolean r19 = false;
        if (r4 == null) goto L14;
        if (r4.getOk() == true) goto L14;
        if (r4.getFrozen() == false) goto L14;
        r19 = true;
    L14:
        if (r4 != null) goto L16;
    L18:
        Long r110 = null;
    L19:
        String r111 = "";
        if (j.a(r8, "??") == false) goto L22;
        r8 = "";
    L22:
        if (r4 == null) goto L32;
        String r112 = r4.getExitIp();
        if (r112 == null) goto L32;
        if (o.L0(r112) == true) goto L29;
        r17 = r112;
    L29:
        if (r17 == null) goto L32;
    L31:
        String r113 = r17;
        if (r4 == null) goto L35;
        long r114 = r4.getAt();
    L36:
        if (r4 != null) goto L38;
    L40:
        if (r4 == null) goto L42;
        int r115 = r4.getFails();
    L44:
        return new Row(r10, r11, r12, r13, r14, r15, r16, r18, r19, r110, r8, r113, r114, r111, r115, r25.getSeen());
    L42:
        r115 = 0;
        goto L44
    L38:
        if (r4.getOk() == true) goto L40;
        r111 = r4.getError();
        goto L40
    L35:
        r114 = 0;
    L32:
        r17 = r25.getIp0();
        goto L31
    L16:
        if (r4.getOk() != true) goto L18;
        r110 = Long.valueOf(r4.getMs());
        goto L19
    L5:
        r18 = null;
        goto L6
    }

    public static /* synthetic */ sd.j rows$default(ArgoPool r4, String r8, String r10, String r11, String r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r8 = Psi.CrashTracebackLevelAll;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r11 = "";
    L12:
        if ((r14 & 8) == 0) goto L15;
        r12 = "";
    L15:
        if ((r14 & 16) == 0) goto L17;
        r13 = 300;
    L17:
        String r16 = r12;
        int r17 = r13;
        String r18 = r11;
        String r19 = r8;
        return r4.rows(r19, r10, r18, r16, r17);
    }

    private static final Comparable rows$lambda$118(Item r4) {
        j.e(r4, "it");
        return Integer.valueOf(rows$score(r4));
    }

    private static final Comparable rows$lambda$119(Item r4) {
        j.e(r4, "it");
        Result r8 = results.get(r4.getId());
        if (r8 == null) goto L7;
        long r10 = r8.getMs();
    L6:
        return Long.valueOf(r10);
    L7:
        r10 = Long.MAX_VALUE;
        goto L6
    }

    private static final Comparable rows$lambda$120(Item r4) {
        j.e(r4, "it");
        return Long.valueOf(-r4.getSeen());
    }

    private static final int rows$score(Item r8) {
        Result r4 = results.get(r8.getId());
        if (r4 != null) goto L5;
    L8:
        if (r4 == null) goto L10;
    L12:
        if (r4 != null) goto L15;
        return 2;
    L15:
        return 3;
    L10:
        if (r8.getV0() <= 0) goto L12;
        return 1;
    L5:
        if (r4.getOk() != true) goto L8;
        return 0;
    }

    private final List<String> sampleV4(int r10) {
        ArrayList r4 = new ArrayList(r10);
        int r8 = 0;
    L3:
        if (r8 >= r10) goto L14;
        List<String> r11 = CF_V4;
        int r12 = 1;
        List r13 = o.a1(r11.get(random.nextInt(r11.size())), new char[]{'/'}, 6);
        String r14 = (String) r13.get(0);
        String r15 = (String) r13.get(1);
        List r16 = o.a1(r14, new char[]{'.'}, 6);
        ArrayList r17 = new ArrayList(kotlin.collections.s.g0(r16, 10));
        Iterator r18 = r16.iterator();
    L6:
        if (r18.hasNext() == false) goto L8;
        r17.add(Integer.valueOf(Integer.parseInt((String) r18.next())));
        goto L6
    L8:
        int r19 = (((((Number) r17.get(0)).intValue() << 24) | (((Number) r17.get(1)).intValue() << 16)) | (((Number) r17.get(2)).intValue() << 8)) | ((Number) r17.get(3)).intValue();
        int r20 = random.nextInt(1 << (32 - Integer.parseInt(r15)));
        if (r20 < 1) goto L12;
        r12 = r20;
    L12:
        int r21 = r19 + r12;
        r4.add(((r21 >>> 24) & 255) + "." + ((r21 >>> 16) & 255) + "." + ((r21 >>> 8) & 255) + "." + (r21 & 255));
        r8 = r8 + 1;
        goto L3
    L14:
        return q.s0(r4);
    }

    private final List<String> sampleV6(int r11) {
        ArrayList r4 = new ArrayList(r11);
        int r8 = 0;
    L3:
        if (r8 >= r11) goto L9;
        List<String> r10 = CF_V6;
        String r12 = r10.get(r8 % r10.size());
        ArrayList r13 = new ArrayList(5);
        int r14 = 0;
    L5:
        if (r14 >= 5) goto L7;
        r13.add(Integer.toHexString(random.nextInt(65536)));
        r14 = r14 + 1;
        goto L5
    L7:
        r4.add(r12 + ":" + q.F0(r13, ":", null, null, null, 62));
        r8 = r8 + 1;
        goto L3
    L9:
        return m9.d.I(r4);
    }

    private final void savePrefs() {
        sf.c r4 = new sf.c();
        r4.D("cleanIp", prefs.getCleanIp());
        r4.E("autoClean", prefs.getAutoClean());
        sf.c r8 = cleanScan;
        if (r8 == null) goto L5;
        r4.D("cleanScan", r8);
    L5:
        String r10 = r4.toString();
        j.d(r10, "toString(...)");
        writeJson("prefs.json", r10);
    }

    private final void saveSoon() {
        changed();
        if (saveQueued == false) goto L5;
        return;
    L5:
        saveQueued = true;
        m0.y(scope, null, null, new C03981(null), 3);
    }

    public static /* synthetic */ void scanCleanIps$default(ArgoPool r4, int r8, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r8 = 300;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = true;
    L8:
        r4.scanCleanIps(r8, r10);
    }

    private final synchronized List<Item> select(String r8, String r10, List<String> r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(this);
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L14
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L14
        List r15 = q.k1(r4);     // Catch: Throwable -> L14
        List<String> r16 = r11;     // Catch: Throwable -> L14
        if (r16 == null) goto L18;
        if (r16.isEmpty() == true) goto L18;
        Set r17 = q.p1(r11);     // Catch: Throwable -> L14
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r19 = r15.iterator();     // Catch: Throwable -> L14
    L10:
        if (r19.hasNext() == false) goto L16;
        Object r20 = r19.next();     // Catch: Throwable -> L14
        if (r17.contains(((Item) r20).getId()) == false) goto L10;
        r18.add(r20);     // Catch: Throwable -> L14
        goto L10
    L16:
        r15 = r18;
    L18:
        if (j.a(r8, Psi.CrashTracebackLevelAll) == true) goto L27;
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r22 = r15.iterator();     // Catch: Throwable -> L14
    L21:
        if (r22.hasNext() == false) goto L25;
        Object r23 = r22.next();     // Catch: Throwable -> L14
        if (j.a(((Item) r23).getKind(), r8) == false) goto L21;
        r21.add(r23);     // Catch: Throwable -> L14
        goto L21
    L25:
        r15 = r21;
    L27:
        if (o.L0(r10) == true) goto L35;
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r25 = r15.iterator();     // Catch: Throwable -> L14
    L30:
        if (r25.hasNext() == false) goto L34;
        Object r26 = r25.next();     // Catch: Throwable -> L14
        Item r27 = (Item) r26;     // Catch: Throwable -> L14
        ArgoPool r28 = INSTANCE;     // Catch: Throwable -> L14
        j.b(r27);     // Catch: Throwable -> L14
        if (j.a(r28.ccOf(r27), r10) == false) goto L30;
        r24.add(r26);     // Catch: Throwable -> L14
        goto L30
    L34:
        r15 = r24;
    L35:
        if (r12 == false) goto L43;
        ArrayList r29 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r30 = r15.iterator();     // Catch: Throwable -> L14
    L38:
        if (r30.hasNext() == false) goto L42;
        Object r31 = r30.next();     // Catch: Throwable -> L14
        if (results.get(((Item) r31).getId()) != null) goto L38;
        r29.add(r31);     // Catch: Throwable -> L14
        goto L38
    L42:
        r15 = r29;
    L43:
        if (r13 == false) goto L51;
        ArrayList r32 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r33 = r15.iterator();     // Catch: Throwable -> L14
    L46:
        if (r33.hasNext() == false) goto L50;
        Object r34 = r33.next();     // Catch: Throwable -> L14
        if (((Item) r34).getV0() <= 0) goto L46;
        r32.add(r34);     // Catch: Throwable -> L14
        goto L46
    L50:
        r15 = r32;
    L51:
        if (r14 == false) goto L61;
        ArrayList r35 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r36 = r15.iterator();     // Catch: Throwable -> L14
    L54:
        if (r36.hasNext() == false) goto L60;
        Object r37 = r36.next();     // Catch: Throwable -> L14
        Result r38 = results.get(((Item) r37).getId());     // Catch: Throwable -> L14
        if (r38 == null) goto L54;
        if (r38.getOk() == true) goto L54;
        r35.add(r37);     // Catch: Throwable -> L14
        goto L54
    L60:
        r15 = r35;
    L61:
        List<Item> r39 = q.b1(r15, new ArgoPool$select$$inlined$sortedByDescending$1());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r39;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Prefs setPrefs$default(ArgoPool r4, String r8, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = null;
    L9:
        return r4.setPrefs(r8, r10);
    }

    private final Proxy socks(int r8) {
        return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, r8));
    }

    private final Object speedThrough(String r4, Item r8, ArgoProtocol.SessionInfo r10, wd.d r11) {
        return m0.J(v0.f24208c, new C04002(r8, r10, r4, null), r11);
    }

    private static final Comparable summary$lambda$104(Group r4) {
        j.e(r4, "it");
        return Boolean.valueOf(j.a(r4.getCc(), "??"));
    }

    private static final Comparable summary$lambda$105(Group r4) {
        j.e(r4, "it");
        return Integer.valueOf(-r4.getAlive());
    }

    private static final Comparable summary$lambda$106(Group r4) {
        j.e(r4, "it");
        return Integer.valueOf(-r4.getN());
    }

    private static final Comparable summary$lambda$110(ArgoProtocol.FalconOrigin r4) {
        j.e(r4, "it");
        return r4.getCc();
    }

    private static final Comparable summary$lambda$111(ArgoProtocol.FalconOrigin r4) {
        j.e(r4, "it");
        return Double.valueOf(r4.getLoad());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Page telegramPage(String r17, Long r18, ArgoNet.Route r19) {
        ArgoNet r4 = ArgoNet.INSTANCE;
        String r8 = URLEncoder.encode(r17, "UTF-8");
        if (r18 == null) goto L5;
        String r10 = "?before=" + r18;
    L6:
        sd.j r11 = ArgoNet.fetchText$default(r4, w0.n("https://t.me/s/", r8, r10), r19, GerehWatchdog.STUCK_MS, 0, 8, null);
        int r12 = ((Number) r11.component1()).intValue();
        String r13 = (String) r11.component2();
        if (r12 != 200) goto L49;
        if (r13.length() == 0) goto L49;
        List r14 = q.t0(o.b1(r13, new String[]{"tgme_widget_message_wrap"}, 6), 1);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L47;
        String r20 = (String) r16.next();
        Object r21 = null;
        kotlin.text.g r22 = i.m("data-post=\"[^\"/]+/(\\d+)\"", r20, 0, 2, null);
        if (r22 == null) goto L44;
        String r23 = (String) ((f0) ((kotlin.text.i) r22).a()).get(1);
        if (r23 == null) goto L44;
        Long r24 = v.w0(r23);
        if (r24 == null) goto L44;
        long r110 = r24.longValue();
        kotlin.text.g r25 = i.m("<time[^>]*datetime=\"([^\"]+)\"", r20, 0, 2, null);
        if (r25 == null) goto L34;
        String r26 = (String) ((f0) ((kotlin.text.i) r25).a()).get(1);
        if (r26 == null) goto L34;
        Object r27 = sd.l.m1004constructorimpl(Long.valueOf(OffsetDateTime.parse(r26).toInstant().toEpochMilli()));     // Catch: Throwable -> L26
    L29:
        if (sd.l.m1010isFailureimpl(r27) == false) goto L31;
        r27 = null;
    L31:
        Long r28 = (Long) r27;
        if (r28 == null) goto L34;
        long r111 = r28.longValue();
    L35:
        kotlin.text.g r29 = i.m("<div class=\"tgme_widget_message_text[^\"]*\"[^>]*>([\\s\\S]*?)</div>", r20, 0, 2, null);
        if (r29 == null) goto L40;
        String r30 = (String) ((f0) ((kotlin.text.i) r29).a()).get(1);
        if (r30 == null) goto L40;
        r21 = INSTANCE.decodeHtml(r30);
    L40:
        if (r21 != null) goto L42;
        String r112 = "";
    L43:
        r21 = new Post(r110, r111, r112);
        goto L44
    L42:
        r112 = r21;
    L26:
        th = move-exception;
        r27 = sd.l.m1004constructorimpl(m.a(th));
    L34:
        r111 = 0;
    L44:
        if (r21 == null) goto L13;
        r15.add(r21);
        goto L13
    L47:
        return new Page(true, r12, r15);
    L49:
        return new Page(false, r12, w.INSTANCE);
    L5:
        r10 = "";
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0094 -> B:23:0x00c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b1 -> B:22:0x00bc). Please report as a decompilation issue!!! */
    private final Object telegramPageRetry(String r19, Long r20, ArgoNet.Route r21, ee.a r22, wd.d r23) {
        if ((r23 instanceof C04011) == false) goto L7;
        C04011 r4 = (C04011) r23;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
        ArgoPool r10 = this;
    L8:
        Object r11 = r4.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r4.label;
        long r14 = 0;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        int r15 = r4.I$1;
        int r16 = r4.I$0;
        long[] r17 = (long[]) r4.L$6;
        Page r18 = (Page) r4.L$5;
        ee.a r110 = (ee.a) r4.L$4;
        ArgoNet.Route r111 = (ArgoNet.Route) r4.L$3;
        Long r112 = (Long) r4.L$2;
        String r113 = (String) r4.L$1;
        ArgoPool r114 = (ArgoPool) r4.L$0;
        m.b(r11);
        long r115 = 0;
    L22:
        long[] r24 = r17;
        C04011 r25 = r4;
        Long r26 = r112;
        Page r116 = r18;
        int r117 = r15;
        ArgoNet.Route r27 = r111;
        long[] r118 = r24;
        ee.a r28 = r110;
        int r119 = r16;
        ee.a r29 = r28;
        String r30 = r113;
    L24:
        if (((Boolean) r29.invoke()).booleanValue() == true) goto L31;
        r116 = r114.telegramPage(r30, r26, r27);
        if (r116.getOk() == true) goto L31;
        if (r116.getCode() == 404) goto L31;
        r119 = r119 + 1;
        r14 = r115;
    L15:
        if (r119 >= r117) goto L31;
        r115 = r14;
        long r31 = r118[r119];
        if (r31 <= r115) goto L24;
        r25.L$0 = r114;
        r25.L$1 = r30;
        r25.L$2 = r26;
        r25.L$3 = r27;
        r25.L$4 = r29;
        r25.L$5 = r116;
        r25.L$6 = r118;
        r25.I$0 = r119;
        r25.I$1 = r117;
        r25.label = 1;
        if (m0.j(r31, r25) != r12) goto L21;
        return r12;
    L21:
        Page r120 = r116;
        r112 = r26;
        r4 = r25;
        r17 = r118;
        r111 = r27;
        r15 = r117;
        r18 = r120;
        int r121 = r119;
        r110 = r29;
        r16 = r121;
        r113 = r30;
    L31:
        return r116;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        m.b(r11);
        r116 = new Page(false, 0, w.INSTANCE);
        r114 = r10;
        r117 = 5;
        r119 = 0;
        r118 = new long[]{0, 3000, SettingsSpotlight.FRESH_MS, GerehWatchdog.STUCK_MS, 45000};
        r30 = r19;
        r27 = r21;
        r29 = r22;
        r25 = r4;
        r26 = r20;
    L7:
        r10 = this;
        r4 = new C04011(r10, r23);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void test$default(ArgoPool r4, String r8, String r10, List r11, boolean r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r8 = Psi.CrashTracebackLevelAll;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r15 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r12 = false;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r13 = false;
    L18:
        if ((r15 & 32) == 0) goto L20;
        boolean r17 = false;
    L21:
        r4.test(r8, r10, r11, r12, r13, r17);
        return;
    L20:
        r17 = r14;
        goto L21
    }

    private final Source tg(String r12) {
        return new Source(v0.a.h("tg:", r12), "telegram", m9.d.B(r12), v0.a.h("کانال تلگرام @", r12), true, false, 0, 96, null);
    }

    private final Long tlsPing(String r8, String r10, int r11) {
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L6
        Socket r12 = new Socket();     // Catch: Throwable -> L6
        r12.connect(new InetSocketAddress(InetAddress.getByName(r8), ProtonStealth.PORT), r11);     // Catch: Throwable -> L6
        r12.setSoTimeout(r11);     // Catch: Throwable -> L6
        SocketFactory r13 = SSLSocketFactory.getDefault();     // Catch: Throwable -> L6
        j.c(r13, "null cannot be cast to non-null type javax.net.ssl.SSLSocketFactory");     // Catch: Throwable -> L6
        Socket r14 = ((SSLSocketFactory) r13).createSocket(r12, r10, ProtonStealth.PORT, true);     // Catch: Throwable -> L6
        j.c(r14, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L6
        SSLSocket r15 = (SSLSocket) r14;     // Catch: Throwable -> L6
        SSLParameters r16 = r15.getSSLParameters();     // Catch: Throwable -> L8
        r16.setServerNames(m9.d.B(new SNIHostName(r10)));     // Catch: Throwable -> L8
        r15.setSSLParameters(r16);     // Catch: Throwable -> L8
        r15.startHandshake();     // Catch: Throwable -> L8
        r15.close();     // Catch: Throwable -> L6
        Object r17 = sd.l.m1004constructorimpl(Long.valueOf(System.currentTimeMillis() - r4));     // Catch: Throwable -> L6
    L15:
        if (sd.l.m1010isFailureimpl(r17) == false) goto L18;
        r17 = null;
    L18:
        return (Long) r17;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        a.a.g(r15, th);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r17 = sd.l.m1004constructorimpl(m.a(th));
        goto L15
    }

    public static /* synthetic */ Long tlsPing$default(ArgoPool r4, String r8, String r10, int r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = 2500;
    L6:
        return r4.tlsPing(r8, r10, r11);
    }

    private final Trace traceVia(int r10) {
        OkHttpClient r11 = client(r10, 15000);     // Catch: Throwable -> L34
        Request.Builder r4 = new Request.Builder();     // Catch: Throwable -> L34
        r4.j(TRACE_URL);     // Catch: Throwable -> L34
        Response r12 = r11.b(new Request(r4)).d();     // Catch: Throwable -> L34
        ResponseBody r8 = r12.f29156h;     // Catch: Throwable -> L8
        String r13 = null;
        if (r8 == null) goto L10;
        String r14 = r8.w();     // Catch: Throwable -> L8
    L11:
        String r15 = "";
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        boolean r16 = false;
        kotlin.text.g r17 = l.find$default(new l("(?m)^loc=([A-Z]{2})"), r14, 0, 2, null);     // Catch: Throwable -> L8
        if (r17 == null) goto L17;
        String r18 = (String) ((f0) ((kotlin.text.i) r17).a()).get(1);     // Catch: Throwable -> L8
    L18:
        if (r18 != null) goto L20;
        r18 = "";
    L20:
        kotlin.text.g r19 = l.find$default(new l("(?m)^ip=(\\S+)"), r14, 0, 2, null);     // Catch: Throwable -> L8
        if (r19 == null) goto L23;
        r13 = (String) ((f0) ((kotlin.text.i) r19).a()).get(1);     // Catch: Throwable -> L8
    L23:
        if (r13 == null) goto L27;
        r15 = r13;
    L27:
        if (r12.A == true) goto L29;
    L31:
        Trace r20 = new Trace(r16, r18, r15);     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L34
        Object r110 = sd.l.m1004constructorimpl(r20);     // Catch: Throwable -> L34
    L41:
        Trace r21 = new Trace(false, null, null, 6, null);
        if (sd.l.m1010isFailureimpl(r110) == false) goto L45;
        r110 = r21;
    L45:
        return (Trace) r110;
    L29:
        if (r18.length() <= 0) goto L31;
        r16 = true;
        goto L31
    L17:
        r18 = null;
        goto L18
    L10:
        r14 = null;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        a.a.g(r12, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r110 = sd.l.m1004constructorimpl(m.a(th));
        goto L41
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(ArgoPool r4, List r8, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L5;
        r8 = null;
    L5:
        r4.update(r8);
    }

    private final Object waitPort(int r8, long r10, wd.d r11) {
        if ((r11 instanceof C04041) == false) goto L7;
        C04041 r4 = (C04041) r11;
        int r12 = r4.label;
        if ((r12 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r12 - TLObject.FLAG_31;
    L8:
        Object r13 = r4.result;
        kotlin.coroutines.intrinsics.a r14 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r15 = r4.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r16 = r4.J$0;
        int r17 = r4.I$0;
        ArgoPool r18 = (ArgoPool) r4.L$0;
        m.b(r13);
    L15:
        long r19 = System.currentTimeMillis();
        u r20 = u.f67154a;
        if (r19 >= r16) goto L35;
        Socket r110 = new Socket();     // Catch: Throwable -> L21
        r110.connect(new InetSocketAddress(SniSession.LOCAL_HOST, r17), 300);     // Catch: Throwable -> L23
        r110.close();     // Catch: Throwable -> L21
        Object r111 = sd.l.m1004constructorimpl(r20);     // Catch: Throwable -> L21
    L30:
        if (sd.l.m1011isSuccessimpl(r111) == true) goto L35;
        r4.L$0 = r18;
        r4.I$0 = r17;
        r4.J$0 = r16;
        r4.label = 1;
        if (m0.j(150, r4) != r14) goto L15;
        return r14;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        a.a.g(r110, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r111 = sd.l.m1004constructorimpl(m.a(th));
    L35:
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        m.b(r13);
        r18 = this;
        r17 = r8;
        r16 = System.currentTimeMillis() + r10;
    L7:
        r4 = new C04041(this, r11);
        goto L8
    }

    private final void writeJson(String r8, String r10) {
        File r4 = dir;     // Catch: Throwable -> L12
        if (r4 == null) goto L20;
        File r11 = new File(r4, r8 + ".tmp");     // Catch: Throwable -> L12
        ce.o.r0(r11, r10);     // Catch: Throwable -> L12
        File r12 = dir;     // Catch: Throwable -> L12
        if (r12 != null) goto L8;
        j.k("dir");     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L8:
        if (r11.renameTo(new File(r12, r8)) == true) goto L16;
        File r13 = dir;     // Catch: Throwable -> L12
        if (r13 == null) goto L14;
        ce.o.r0(new File(r13, r8), r10);     // Catch: Throwable -> L12
        goto L16
    L14:
        j.k("dir");     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L16:
        sd.l.m1004constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
        return;
    L20:
        j.k("dir");     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sd.l.m1004constructorimpl(m.a(th));
    }

    public final synchronized Source addSource(String r21) {
        monitor-enter(this);
        j.e(r21, "input");     // Catch: Throwable -> L9
        load();     // Catch: Throwable -> L9
        String r8 = o.n1(r21).toString();     // Catch: Throwable -> L9
        if (r8.length() <= 0) goto L48;
        kotlin.text.m r10 = kotlin.text.m.IGNORE_CASE;     // Catch: Throwable -> L9
        int r11 = 0;
        kotlin.text.g r12 = l.find$default(new l("^(?:@|(?:https?://)?(?:t\\.me|telegram\\.me)/(?:s/)?)([A-Za-z][A-Za-z0-9_]{3,31})(?:[/?#].*)?$", r10), r8, 0, 2, null);     // Catch: Throwable -> L9
        if (r12 == null) goto L12;
        kotlin.text.i r13 = (kotlin.text.i) r12;     // Catch: Throwable -> L9
        sd.q r4 = new sd.q("telegram", ((f0) r13.a()).get(1), "کانال تلگرام @" + ((f0) r13.a()).get(1));     // Catch: Throwable -> L9
    L21:
        String r14 = (String) r4.component1();     // Catch: Throwable -> L9
        String r15 = (String) r4.component2();     // Catch: Throwable -> L9
        String r16 = (String) r4.component3();     // Catch: Throwable -> L9
        if (j.a(r14, "telegram") == false) goto L25;
        String r17 = "tg:" + r15;     // Catch: Throwable -> L9
    L24:
        String r18 = r17;
        ArrayList r19 = q.S0(BUILTIN, userSources);     // Catch: Throwable -> L9
        if (r19.isEmpty() == true) goto L42;
        int r20 = r19.size();     // Catch: Throwable -> L9
    L36:
        if (r11 >= r20) goto L42;
        Object r22 = r19.get(r11);     // Catch: Throwable -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L9
        if (v.m0(((Source) r22).getId(), r18) == false) goto L36;
        throw new IllegalArgumentException("این منبع قبلاً اضافه شده است");     // Catch: Throwable -> L9
    L42:
        Source r110 = new Source(r18, r14, m9.d.B(r15), r16, false, true, System.currentTimeMillis());     // Catch: Throwable -> L9
        userSources.add(r110);     // Catch: Throwable -> L9
        saveNow();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r110;
    L25:
        MessageDigest r23 = MessageDigest.getInstance("SHA-1");     // Catch: Throwable -> L9
        byte[] r24 = r15.getBytes(kotlin.text.a.f23859a);     // Catch: Throwable -> L9
        j.d(r24, "getBytes(...)");     // Catch: Throwable -> L9
        byte[] r25 = r23.digest(r24);     // Catch: Throwable -> L9
        j.d(r25, "digest(...)");     // Catch: Throwable -> L9
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L9
        r26.append("");     // Catch: Throwable -> L9
        int r27 = r25.length;     // Catch: Throwable -> L9
        int r28 = 0;
        int r29 = 0;
    L26:
        if (r28 >= r27) goto L31;
        byte r111 = r25[r28];     // Catch: Throwable -> L9
        r29 = r29 + 1;     // Catch: Throwable -> L9
        if (r29 <= 1) goto L30;
        r26.append("");     // Catch: Throwable -> L9
    L30:
        r26.append(addSource$lambda$61(r111));     // Catch: Throwable -> L9
        r28 = r28 + 1;     // Catch: Throwable -> L9
        goto L26
    L31:
        r26.append("");     // Catch: Throwable -> L9
        r17 = "u:".concat(o.l1(12, r26.toString()));     // Catch: Throwable -> L9
        goto L24
    L12:
        if (new l("^[A-Za-z][A-Za-z0-9_]{4,31}$").matches(r8) == false) goto L15;
        r4 = new sd.q("telegram", r8, "کانال تلگرام @".concat(r8));     // Catch: Throwable -> L9
        goto L21
    L15:
        if (new l("^https?://\\S+$", r10).matches(r8) == false) goto L46;
        if (new l("github\\.com|githubusercontent\\.com", r10).containsMatchIn(r8) == false) goto L19;
        String r30 = "گیت\u200cهاب — ".concat(o.l1(60, new l("^https?://(raw\\.)?github(usercontent)?\\.com/", r10).replace(r8, "")));     // Catch: Throwable -> L9
    L20:
        r4 = new sd.q(XrayMeasureService.KEY_URL, r8, r30);     // Catch: Throwable -> L9
        goto L21
    L19:
        r30 = o.l1(70, new l("^https?://", r10).replace(r8, ""));     // Catch: Throwable -> L9
        goto L20
    L46:
        throw new IllegalArgumentException("این نشانی شناخته نشد — نام کانال تلگرام (@name یا t.me/name) یا یک نشانی http(s) از گیت\u200cهاب یا هر سایتی بدهید");     // Catch: Throwable -> L9
    L48:
        throw new IllegalArgumentException("نشانی منبع خالی است");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final String cleanIp() {
        load();
        return prefs.getCleanIp();
    }

    public final synchronized ArgoProtocol.Endpoint endpointFromRaw(String r15) {
        monitor-enter(this);
        j.e(r15, "raw");     // Catch: Throwable -> L10
        load();     // Catch: Throwable -> L10
        ArgoProtocol r4 = ArgoProtocol.INSTANCE;     // Catch: Throwable -> L10
        List<String> r8 = r4.extractBridgeBlocks(r15);     // Catch: Throwable -> L10
        if (r8.isEmpty() == true) goto L14;
        ArgoProtocol.Bridge r10 = r4.decodeBridgeBlock(r8.get(0));     // Catch: Throwable -> L10
        if (r10.getSigOk() == false) goto L13;
        addItem$default(this, "bridge", r10.getHost(), r10.getPort(), r10.getProtocol(), "user", System.currentTimeMillis(), true, null, 128, null);     // Catch: Throwable -> L10
        saveSoon();     // Catch: Throwable -> L10
        Item r11 = items.get(idOf("bridge", r10.getHost(), r10.getPort()));     // Catch: Throwable -> L10
        j.b(r11);     // Catch: Throwable -> L10
        ArgoProtocol.Endpoint r12 = endpointOf(r11);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L13:
        throw new IllegalArgumentException("امضای این بلاک پل معتبر نیست — بلاک ناقص کپی شده یا ساختگی است");     // Catch: Throwable -> L10
    L14:
        List<String> r13 = r4.extractFalconHosts(r15, true);     // Catch: Throwable -> L10
        if (r13.isEmpty() == true) goto L20;
        addItem$default(this, "falcon", r13.get(0), ProtonStealth.PORT, "A", "user", System.currentTimeMillis(), true, null, 128, null);     // Catch: Throwable -> L10
        saveSoon();     // Catch: Throwable -> L10
        Item r14 = items.get(idOf("falcon", r13.get(0), ProtonStealth.PORT));     // Catch: Throwable -> L10
        j.b(r14);     // Catch: Throwable -> L10
        ArgoProtocol.Endpoint r16 = endpointOf(r14);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r16;
    L20:
        throw new IllegalArgumentException("نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized ArgoProtocol.Endpoint get(String r4) {
        monitor-enter(this);
        j.e(r4, XrayCoreHostService.KEY_ID);     // Catch: Throwable -> L7
        load();     // Catch: Throwable -> L7
        Item r8 = items.get(r4);     // Catch: Throwable -> L7
        if (r8 == null) goto L9;
        ArgoProtocol.Endpoint r10 = INSTANCE.endpointOf(r8);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r10;
    L9:
        r10 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final IpScan getIpScan() {
        return ipScan;
    }

    public final Job getTestJob() {
        return testJob;
    }

    public final Job getUpdateJob() {
        return updateJob;
    }

    public final e1 getVersion() {
        return version;
    }

    public final synchronized sd.j importFromChat(String r11) {
        monitor-enter(this);
        j.e(r11, "text");     // Catch: Throwable -> L47
        load();     // Catch: Throwable -> L47
        Absorbed r12 = absorbText(r11, "user", System.currentTimeMillis(), true, true);     // Catch: Throwable -> L41
        saveNow();     // Catch: Throwable -> L47
        Parsed r4 = parse(r11);     // Catch: Throwable -> L47
        List<ParsedBridge> r8 = r4.getBridges();     // Catch: Throwable -> L47
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L47
        Iterator<T> r13 = r8.iterator();     // Catch: Throwable -> L47
    L8:
        if (r13.hasNext() == false) goto L17;
        Object r14 = r13.next();     // Catch: Throwable -> L15
        ParsedBridge r15 = (ParsedBridge) r14;     // Catch: Throwable -> L15
        if (r15.getSigOk() == false) goto L8;
        if (o.L0(r15.getHost()) == true) goto L8;
        r10.add(r14);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Throwable r16 = th;
    L49:
        monitor-exit(this);     // Catch: Throwable -> L41
        throw r16;
    L17:
        ArrayList r17 = new ArrayList(kotlin.collections.s.g0(r10, 10));     // Catch: Throwable -> L47
        int r18 = r10.size();     // Catch: Throwable -> L47
        int r19 = 0;
    L19:
        if (r19 >= r18) goto L22;
        Object r20 = r10.get(r19);     // Catch: Throwable -> L15
        r19 = r19 + 1;     // Catch: Throwable -> L15
        ParsedBridge r21 = (ParsedBridge) r20;     // Catch: Throwable -> L15
        r17.add(INSTANCE.idOf("bridge", r21.getHost(), r21.getPort()));     // Catch: Throwable -> L15
        goto L19
    L22:
        List<String> r22 = r4.getFalcons();     // Catch: Throwable -> L47
        ArrayList r23 = new ArrayList(kotlin.collections.s.g0(r22, 10));     // Catch: Throwable -> L47
        Iterator<T> r24 = r22.iterator();     // Catch: Throwable -> L47
    L24:
        if (r24.hasNext() == false) goto L27;
        String r25 = (String) r24.next();     // Catch: Throwable -> L15
        r23.add(INSTANCE.idOf("falcon", r25, ProtonStealth.PORT));     // Catch: Throwable -> L15
        goto L24
    L27:
        List r26 = q.s0(q.S0(r17, r23));     // Catch: Throwable -> L47
        ArrayList r27 = new ArrayList();     // Catch: Throwable -> L47
        Iterator r28 = r26.iterator();     // Catch: Throwable -> L47
    L29:
        if (r28.hasNext() == false) goto L34;
        Object r29 = r28.next();     // Catch: Throwable -> L15
        LinkedHashMap<String, Item> r30 = items;     // Catch: Throwable -> L15
        if (r30.containsKey((String) r29) == false) goto L29;
        r27.add(r29);     // Catch: Throwable -> L15
        goto L29
    L34:
        if (r27.isEmpty() == true) goto L44;
        test$default(this, null, null, r27, false, false, false, 59, null);     // Catch: Throwable -> L39
        sd.l.m1004constructorimpl(u.f67154a);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        sd.l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L41
    L44:
        sd.j r31 = new sd.j(r12, r27);     // Catch: Throwable -> L41
        monitor-exit(this);
        return r31;
    L41:
        th = th;
    L42:
        r16 = th;
    L47:
        th = th;
        goto L42
    }

    public final synchronized Absorbed importText(String r10) {
        monitor-enter(this);
        j.e(r10, "text");     // Catch: Throwable -> L10
        load();     // Catch: Throwable -> L10
        Absorbed r11 = absorbText(r10, "user", System.currentTimeMillis(), true, true);     // Catch: Throwable -> L8
        saveNow();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L8:
        th = th;
    L9:
        Throwable r12 = th;
        monitor-exit(this);     // Catch: Throwable -> L8
        throw r12;
    L10:
        th = th;
        goto L9
    }

    public final void init(Context r4) {
        j.e(r4, "context");
        if (app == null) goto L5;
        return;
    L5:
        app = r4.getApplicationContext();
        Context r8 = app;
        if (r8 == null) goto L9;
        File r10 = new File(r8.getFilesDir(), "argo");
        r10.mkdirs();
        dir = r10;
        return;
    L9:
        j.k("app");
        throw null;
    }

    public final boolean isIpLiteral(String r4) {
        String r8 = o.o1(i.h(r4, "s", r4), new char[]{'[', ']'});
        if (IPV4_LITERAL.matches(r8) == false) goto L7;
        return true;
    L7:
        if (o.z0(r8, ':') == true) goto L9;
        return false;
    L9:
        if (i.B("^[0-9A-Fa-f:.]+$", r8) == false) goto L24;
        Object r10 = sd.l.m1004constructorimpl(Boolean.valueOf(InetAddress.getByName(r8) instanceof Inet6Address));     // Catch: Throwable -> L13
    L15:
        Boolean r11 = Boolean.FALSE;
        if (sd.l.m1010isFailureimpl(r10) == false) goto L19;
        r10 = r11;
    L19:
        return ((Boolean) r10).booleanValue();
    L13:
        th = move-exception;
        r10 = sd.l.m1004constructorimpl(m.a(th));
        goto L15
    L24:
        return false;
    }

    public final Parsed parse(String r12) {
        j.e(r12, "text");
        List<String> r4 = ArgoProtocol.INSTANCE.extractBridgeBlocks(r12);
        ArrayList r8 = new ArrayList(kotlin.collections.s.g0(r4, 10));
        Iterator<T> r10 = r4.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) r10.next();
        ArgoProtocol.Bridge r13 = ArgoProtocol.INSTANCE.decodeBridgeBlock(r11);     // Catch: Throwable -> L8
        ParsedBridge r14 = new ParsedBridge(r13.getHost(), r13.getPort(), r13.getSigOk(), null, 8, null);     // Catch: Throwable -> L8
    L13:
        r8.add(r14);
    L8:
        th = move-exception;
        String r15 = th.getMessage();
        if (r15 != null) goto L12;
        r15 = "بلاک پل خوانده نشد";
    L12:
        r14 = new ParsedBridge("", ProtonStealth.PORT, false, r15);
        goto L13
    L14:
        String r16 = new l("-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+", kotlin.text.m.IGNORE_CASE).replace(r12, "");
        return new Parsed(r8, ArgoProtocol.INSTANCE.extractFalconHosts(r16, true));
    }

    public final synchronized List<ArgoProtocol.Endpoint> pick(int r11) {
        monitor-enter(this);
        load();     // Catch: Throwable -> L11
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L11
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L11
        List r8 = q.k1(r4);     // Catch: Throwable -> L11
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r12 = r8.iterator();     // Catch: Throwable -> L11
    L5:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();     // Catch: Throwable -> L11
        Result r14 = results.get(((Item) r13).getId());     // Catch: Throwable -> L11
        if (r14 == null) goto L5;
        if (r14.getOk() != true) goto L5;
        r10.add(r13);     // Catch: Throwable -> L11
        goto L5
    L13:
        List r15 = q.b1(r10, new ArgoPool$pick$$inlined$sortedBy$1());     // Catch: Throwable -> L11
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r17 = r8.iterator();     // Catch: Throwable -> L11
    L15:
        if (r17.hasNext() == false) goto L21;
        Object r18 = r17.next();     // Catch: Throwable -> L11
        Item r19 = (Item) r18;     // Catch: Throwable -> L11
        if (results.get(r19.getId()) != null) goto L15;
        if (r19.getV0() <= 0) goto L15;
        r16.add(r18);     // Catch: Throwable -> L11
        goto L15
    L21:
        List r20 = q.b1(r16, new ArgoPool$pick$$inlined$sortedByDescending$1());     // Catch: Throwable -> L11
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r22 = r8.iterator();     // Catch: Throwable -> L11
    L23:
        if (r22.hasNext() == false) goto L31;
        Object r23 = r22.next();     // Catch: Throwable -> L11
        Item r24 = (Item) r23;     // Catch: Throwable -> L11
        if (results.get(r24.getId()) != null) goto L23;
        if (r24.getV0() != 0) goto L23;
        if (j.a(r24.getKind(), "falcon") == true) goto L23;
        r21.add(r23);     // Catch: Throwable -> L11
        goto L23
    L31:
        List r25 = q.b1(r21, new ArgoPool$pick$$inlined$sortedByDescending$2());     // Catch: Throwable -> L11
        List r110 = q.e1(q.S0(q.S0(r15, r20), r25), r11);     // Catch: Throwable -> L11
        ArrayList r26 = new ArrayList(kotlin.collections.s.g0(r110, 10));     // Catch: Throwable -> L11
        Iterator r111 = r110.iterator();     // Catch: Throwable -> L11
    L32:
        if (r111.hasNext() == false) goto L36;
        Item r27 = (Item) r111.next();     // Catch: Throwable -> L11
        ArgoPool r28 = INSTANCE;     // Catch: Throwable -> L11
        j.b(r27);     // Catch: Throwable -> L11
        r26.add(r28.endpointOf(r27));     // Catch: Throwable -> L11
        goto L32
    L36:
        monitor-exit(this);
        return r26;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void record(String r14, boolean r15, long r16, String r18, String r19, String r20, boolean r21, String r22) {
        monitor-enter(this);
        j.e(r14, XrayCoreHostService.KEY_ID);     // Catch: Throwable -> L9
        j.e(r18, AwgProbeService.KEY_COUNTRY);     // Catch: Throwable -> L9
        j.e(r19, "exitIp");     // Catch: Throwable -> L9
        j.e(r20, "error");     // Catch: Throwable -> L9
        j.e(r22, "edge");     // Catch: Throwable -> L9
        load();     // Catch: Throwable -> L9
        HashMap<String, Result> r4 = results;     // Catch: Throwable -> L9
        Result r8 = r4.get(r14);     // Catch: Throwable -> L9
        if (r15 == false) goto L6;
    L15:
        String r10 = r18;
    L16:
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L9
        int r12 = 0;
        if (r15 == true) goto L22;
        if (r8 == null) goto L21;
        r12 = r8.getFails();     // Catch: Throwable -> L9
    L21:
        r12 = r12 + 1;     // Catch: Throwable -> L9
    L22:
        r4.put(r14, new Result(r15, r16, r10, r19, r11, r12, r20, r21, r22));     // Catch: Throwable -> L9
        saveSoon();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L6:
        if (o.L0(r18) == false) goto L15;
        if (r8 == null) goto L11;
        String r13 = r8.getCc();     // Catch: Throwable -> L9
    L12:
        if (r13 != null) goto L14;
        r13 = "";
    L14:
        r10 = r13;
        goto L16
    L11:
        r13 = null;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int remove(List<String> r4) {
        monitor-enter(this);
        j.e(r4, "ids");     // Catch: Throwable -> L9
        load();     // Catch: Throwable -> L9
        Iterator<String> r8 = r4.iterator();     // Catch: Throwable -> L9
        int r10 = 0;
    L5:
        if (r8.hasNext() == false) goto L11;
        String r11 = r8.next();     // Catch: Throwable -> L9
        if (items.remove(r11) == null) goto L5;
        results.remove(r11);     // Catch: Throwable -> L9
        r10 = r10 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        saveNow();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int removeDead() {
        monitor-enter(this);
        load();     // Catch: Throwable -> L13
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L13
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L13
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r10 = r4.iterator();     // Catch: Throwable -> L13
    L5:
        if (r10.hasNext() == false) goto L15;
        Object r11 = r10.next();     // Catch: Throwable -> L13
        Result r12 = results.get(((Item) r11).getId());     // Catch: Throwable -> L13
        if (r12 == null) goto L5;
        if (r12.getOk() == true) goto L5;
        if (r12.getFails() < 3) goto L5;
        r8.add(r11);     // Catch: Throwable -> L13
        goto L5
    L15:
        ArrayList r13 = new ArrayList(kotlin.collections.s.g0(r8, 10));     // Catch: Throwable -> L13
        int r14 = r8.size();     // Catch: Throwable -> L13
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L18;
        Object r16 = r8.get(r15);     // Catch: Throwable -> L13
        r15 = r15 + 1;     // Catch: Throwable -> L13
        r13.add(((Item) r16).getId());     // Catch: Throwable -> L13
        goto L16
    L18:
        int r17 = remove(r13);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r17;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean removeSource(String r4) {
        monitor-enter(this);
        j.e(r4, XrayCoreHostService.KEY_ID);     // Catch: Throwable -> L6
        load();     // Catch: Throwable -> L6
        List<Source> r8 = userSources;     // Catch: Throwable -> L6
        boolean r10 = q.V0(new c(r4), r8);     // Catch: Throwable -> L6
        sourceState.remove(r4);     // Catch: Throwable -> L6
        saveNow();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized sd.j rows(String r8, String r10, String r11, String r12, int r13) {
        monitor-enter(this);
        j.e(r8, "kind");     // Catch: Throwable -> L11
        j.e(r10, AwgProbeService.KEY_COUNTRY);     // Catch: Throwable -> L11
        j.e(r11, "q");     // Catch: Throwable -> L11
        j.e(r12, "only");     // Catch: Throwable -> L11
        load();     // Catch: Throwable -> L11
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L11
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L11
        List r14 = q.k1(r4);     // Catch: Throwable -> L11
        if (r8.equals(Psi.CrashTracebackLevelAll) == true) goto L15;
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L11
    L7:
        if (r16.hasNext() == false) goto L13;
        Object r17 = r16.next();     // Catch: Throwable -> L11
        if (j.a(((Item) r17).getKind(), r8) == false) goto L7;
        r15.add(r17);     // Catch: Throwable -> L11
        goto L7
    L13:
        r14 = r15;
    L15:
        if (o.L0(r10) == true) goto L23;
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r19 = r14.iterator();     // Catch: Throwable -> L11
    L18:
        if (r19.hasNext() == false) goto L22;
        Object r20 = r19.next();     // Catch: Throwable -> L11
        Item r21 = (Item) r20;     // Catch: Throwable -> L11
        ArgoPool r22 = INSTANCE;     // Catch: Throwable -> L11
        j.b(r21);     // Catch: Throwable -> L11
        if (j.a(r22.ccOf(r21), r10) == false) goto L18;
        r18.add(r20);     // Catch: Throwable -> L11
        goto L18
    L22:
        r14 = r18;
    L23:
        int r23 = r12.hashCode();     // Catch: Throwable -> L11
        if (r23 == (-1994383672)) goto L52;
        if (r23 == 3599307) goto L43;
        if (r23 == 92903629) goto L31;
    L60:
        String r24 = o.n1(r11).toString().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L11
        j.d(r24, "toLowerCase(...)");     // Catch: Throwable -> L11
        if (r24.length() <= 0) goto L69;
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r110 = r14.iterator();     // Catch: Throwable -> L11
    L64:
        if (r110.hasNext() == false) goto L68;
        Object r26 = r110.next();     // Catch: Throwable -> L11
        if (o.y0(((Item) r26).getHost(), r24, false) == false) goto L64;
        r25.add(r26);     // Catch: Throwable -> L11
        goto L64
    L68:
        r14 = r25;
    L69:
        List r27 = q.b1(r14, p.d(new ee.c[]{new d(1), new d(4), new d(5)}));     // Catch: Throwable -> L11
        Integer r28 = Integer.valueOf(r27.size());     // Catch: Throwable -> L11
        List r29 = q.e1(r27, com.google.android.gms.internal.mlkit_language_id_common.j.d(r13, 1, 2000));     // Catch: Throwable -> L11
        ArrayList r30 = new ArrayList(kotlin.collections.s.g0(r29, 10));     // Catch: Throwable -> L11
        Iterator r31 = r29.iterator();     // Catch: Throwable -> L11
    L71:
        if (r31.hasNext() == false) goto L73;
        Item r111 = (Item) r31.next();     // Catch: Throwable -> L11
        ArgoPool r112 = INSTANCE;     // Catch: Throwable -> L11
        j.b(r111);     // Catch: Throwable -> L11
        r30.add(r112.rowOf(r111));     // Catch: Throwable -> L11
        goto L71
    L73:
        sd.j r32 = new sd.j(r28, r30);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r32;
    L31:
        if (r12.equals("alive") == false) goto L60;
        ArrayList r33 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r34 = r14.iterator();     // Catch: Throwable -> L11
    L35:
        if (r34.hasNext() == false) goto L41;
        Object r113 = r34.next();     // Catch: Throwable -> L11
        Result r35 = results.get(((Item) r113).getId());     // Catch: Throwable -> L11
        if (r35 == null) goto L35;
        if (r35.getOk() != true) goto L35;
        r33.add(r113);     // Catch: Throwable -> L11
    L41:
        r14 = r33;
        goto L60
    L43:
        if (r12.equals("user") == false) goto L60;
        r33 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r36 = r14.iterator();     // Catch: Throwable -> L11
    L47:
        if (r36.hasNext() == false) goto L41;
        Object r114 = r36.next();     // Catch: Throwable -> L11
        if (((Item) r114).getUser() == false) goto L47;
        r33.add(r114);     // Catch: Throwable -> L11
        goto L47
    L52:
        if (r12.equals("verified") == false) goto L60;
        r33 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r37 = r14.iterator();     // Catch: Throwable -> L11
    L56:
        if (r37.hasNext() == false) goto L41;
        Object r115 = r37.next();     // Catch: Throwable -> L11
        if (((Item) r115).getV0() <= 0) goto L56;
        r33.add(r115);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void saveNow() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (loaded == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Collection<Item> r4 = items.values();     // Catch: Throwable -> L13
        j.d(r4, "<get-values>(...)");     // Catch: Throwable -> L13
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r10 = r4.iterator();     // Catch: Throwable -> L13
    L9:
        if (r10.hasNext() == false) goto L15;
        Object r11 = r10.next();     // Catch: Throwable -> L13
        if (j.a(((Item) r11).getSrc(), "bundled") == true) goto L9;
        r8.add(r11);     // Catch: Throwable -> L13
        goto L9
    L15:
        ArrayList r12 = new ArrayList(kotlin.collections.s.g0(r8, 10));     // Catch: Throwable -> L13
        int r13 = r8.size();     // Catch: Throwable -> L13
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L18;
        Object r15 = r8.get(r14);     // Catch: Throwable -> L13
        r14 = r14 + 1;     // Catch: Throwable -> L13
        Item r16 = (Item) r15;     // Catch: Throwable -> L13
        ArgoPool r17 = INSTANCE;     // Catch: Throwable -> L13
        j.b(r16);     // Catch: Throwable -> L13
        r12.add(r17.itemJson(r16));     // Catch: Throwable -> L13
        goto L16
    L18:
        String r18 = new sf.a(r12).toString();     // Catch: Throwable -> L13
        j.d(r18, "toString(...)");     // Catch: Throwable -> L13
        writeJson("pool.json", r18);     // Catch: Throwable -> L13
        sf.c r19 = new sf.c();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, Result>> r20 = results.entrySet().iterator();     // Catch: Throwable -> L13
    L20:
        if (r20.hasNext() == false) goto L22;
        Map.Entry<String, Result> r21 = r20.next();     // Catch: Throwable -> L13
        String r22 = r21.getKey();     // Catch: Throwable -> L13
        Result r23 = r21.getValue();     // Catch: Throwable -> L13
        r19.D(r22, INSTANCE.resultJson(r23));     // Catch: Throwable -> L13
        goto L20
    L22:
        String r24 = r19.toString();     // Catch: Throwable -> L13
        j.d(r24, "toString(...)");     // Catch: Throwable -> L13
        writeJson("results.json", r24);     // Catch: Throwable -> L13
        sf.c r25 = new sf.c();     // Catch: Throwable -> L13
        List<Source> r26 = userSources;     // Catch: Throwable -> L13
        ArrayList r27 = new ArrayList(kotlin.collections.s.g0(r26, 10));     // Catch: Throwable -> L13
        Iterator<T> r28 = r26.iterator();     // Catch: Throwable -> L13
    L24:
        if (r28.hasNext() == false) goto L26;
        Source r29 = (Source) r28.next();     // Catch: Throwable -> L13
        sf.c r30 = new sf.c();     // Catch: Throwable -> L13
        r30.D(XrayCoreHostService.KEY_ID, r29.getId());     // Catch: Throwable -> L13
        r30.D(TeXSymbolParser.TYPE_ATTR, r29.getType());     // Catch: Throwable -> L13
        r30.D("value", q.y0(r29.getValue()));     // Catch: Throwable -> L13
        r30.D("label", r29.getLabel());     // Catch: Throwable -> L13
        r30.D("addedAt", Long.valueOf(r29.getAddedAt()));     // Catch: Throwable -> L13
        r27.add(r30);     // Catch: Throwable -> L13
        goto L24
    L26:
        r25.D("list", new sf.a(r27));     // Catch: Throwable -> L13
        sf.c r31 = new sf.c();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, sf.c>> r32 = sourceState.entrySet().iterator();     // Catch: Throwable -> L13
    L28:
        if (r32.hasNext() == false) goto L30;
        Map.Entry<String, sf.c> r33 = r32.next();     // Catch: Throwable -> L13
        r31.D(r33.getKey(), r33.getValue());     // Catch: Throwable -> L13
        goto L28
    L30:
        r25.D("state", r31);     // Catch: Throwable -> L13
        String r34 = r25.toString();     // Catch: Throwable -> L13
        j.d(r34, "toString(...)");     // Catch: Throwable -> L13
        writeJson("sources.json", r34);     // Catch: Throwable -> L13
        savePrefs();     // Catch: Throwable -> L13
        changed();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final void scanCleanIps(int r18, boolean r19) {
        load();
        IpScan r4 = ipScan;
        if (r4 != null) goto L5;
    L9:
        Job r8 = testJob;
        if (r8 != null) goto L12;
    L16:
        List<Item> r10 = refHosts(3);
        if (r10.isEmpty() == true) goto L21;
        scanCancel = false;
        ipScan = new IpScan(true, "tls", 0, 0, w.INSTANCE, r10.get(0).getHost(), null, null, 0, 448, null);
        changed();
        m0.y(scope, null, null, new C03991(r18, r19, r10, null), 3);
        return;
    L21:
        throw new IllegalStateException("هیچ سرور آرگویی برای اسکن نیست — اول «به\u200cروزرسانی» را بزنید");
    L12:
        if (r8.getRunning() != true) goto L16;
        throw new IllegalStateException("اول سنجش فهرست تمام شود");
    L5:
        if (r4.getRunning() != true) goto L9;
        throw new IllegalStateException("اسکن آی\u200cپی تمیز در حال اجراست");
    }

    public final synchronized Prefs setPrefs(String r8, Boolean r10) {
        monitor-enter(this);
        load();     // Catch: Throwable -> L11
        if (r8 == null) goto L15;
        String r11 = o.o1(o.n1(r8).toString(), new char[]{'[', ']'});     // Catch: Throwable -> L11
        if (r11.length() != 0) goto L9;
    L10:
        prefs = Prefs.copy$default(prefs, r11, false, 2, null);     // Catch: Throwable -> L11
        goto L15
    L9:
        if (isIpLiteral(r11) == true) goto L10;
        throw new IllegalArgumentException("آی\u200cپی تمیز معتبر نیست");     // Catch: Throwable -> L11
    L15:
        if (r10 == null) goto L17;
        prefs = Prefs.copy$default(prefs, null, r10.booleanValue(), 1, null);     // Catch: Throwable -> L11
    L17:
        savePrefs();     // Catch: Throwable -> L11
        changed();     // Catch: Throwable -> L11
        Prefs r12 = prefs;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void setSourceOn(String r4, boolean r8) {
        monitor-enter(this);
        j.e(r4, XrayCoreHostService.KEY_ID);     // Catch: Throwable -> L6
        load();     // Catch: Throwable -> L6
        HashMap<String, sf.c> r10 = sourceState;     // Catch: Throwable -> L6
        sf.c r11 = r10.get(r4);     // Catch: Throwable -> L6
        if (r11 != null) goto L8;
        r11 = new sf.c();     // Catch: Throwable -> L6
        r10.put(r4, r11);     // Catch: Throwable -> L6
    L8:
        r11.E("on", r8);     // Catch: Throwable -> L6
        saveNow();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized List<SourceView> sources() {
        monitor-enter(this);
        load();     // Catch: Throwable -> L8
        ArrayList r4 = q.S0(BUILTIN, userSources);     // Catch: Throwable -> L8
        ArrayList r8 = new ArrayList(kotlin.collections.s.g0(r4, 10));     // Catch: Throwable -> L8
        int r10 = r4.size();     // Catch: Throwable -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L43;
        Object r12 = r4.get(r11);     // Catch: Throwable -> L8
        r11 = r11 + 1;     // Catch: Throwable -> L8
        Source r13 = (Source) r12;     // Catch: Throwable -> L8
        sf.c r14 = sourceState.get(r13.getId());     // Catch: Throwable -> L8
        String r15 = null;
        if (j.a(r13.getType(), "falcon-servers") == false) goto L10;
        int r16 = falconServers.size();     // Catch: Throwable -> L8
    L28:
        boolean r17 = true;
        if (r14 == null) goto L31;
        r17 = r14.q("on", true);     // Catch: Throwable -> L8
    L31:
        long r18 = 0;
        if (r14 == null) goto L34;
        r18 = r14.x(0, "at");     // Catch: Throwable -> L8
    L34:
        if (r14 == null) goto L36;
        int r19 = r14.t(0, "found");     // Catch: Throwable -> L8
    L37:
        if (r14 == null) goto L39;
        r15 = r14.A("error", "");     // Catch: Throwable -> L8
    L39:
        if (r15 != null) goto L41;
        r15 = "";
    L41:
        r8.add(new SourceView(r13, r17, r18, r19, r16, r15));     // Catch: Throwable -> L8
        goto L4
    L36:
        r19 = 0;
        goto L37
    L10:
        Collection<Item> r20 = items.values();     // Catch: Throwable -> L8
        j.d(r20, "<get-values>(...)");     // Catch: Throwable -> L8
        Collection<Item> r21 = r20;     // Catch: Throwable -> L8
        if ((r21 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r22 = r21.iterator();     // Catch: Throwable -> L8
        int r23 = 0;
    L17:
        if (r22.hasNext() == false) goto L27;
        Item r110 = (Item) r22.next();     // Catch: Throwable -> L8
        if (j.a(r110.getSrc(), r13.getId()) == true) goto L22;
        if (j.a(r110.getFrom(), r13.getId()) == false) goto L17;
    L22:
        r23 = r23 + 1;     // Catch: Throwable -> L8
        if (r23 >= 0) goto L17;
        r.e0();     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L27:
        r16 = r23;
        goto L28
    L13:
        if (r21.isEmpty() == false) goto L15;
        r16 = 0;
        goto L28
    L43:
        monitor-exit(this);
        return r8;
    L8:
        th = move-exception;
        throw th;
    }

    public final void stopCleanScan() {
        scanCancel = true;
    }

    public final void stopTest() {
        testCancel = true;
    }

    public final void stopUpdate() {
        updateCancel = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.collections.w] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r22v0, types: [java.util.List] */
    public final synchronized Summary summary() {
        monitor-enter(this);
        load();     // Catch: Throwable -> L17
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L17
        Iterator<Item> r8 = items.values().iterator();     // Catch: Throwable -> L17
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        long r16 = 0;
    L6:
        if (r8.hasNext() == false) goto L45;
        Item r17 = r8.next();     // Catch: Throwable -> L17
        j.d(r17, "next(...)");     // Catch: Throwable -> L17
        Item r18 = r17;     // Catch: Throwable -> L17
        String r19 = r18.getKind();     // Catch: Throwable -> L17
        if (j.a(r19, "bridge") == false) goto L11;
        r10 = r10 + 1;     // Catch: Throwable -> L17
    L15:
        if (r18.getV0() <= 0) goto L19;
        r15 = r15 + 1;     // Catch: Throwable -> L17
        r16 = Math.max(r16, r18.getV0());     // Catch: Throwable -> L17
    L19:
        Result r20 = results.get(r18.getId());     // Catch: Throwable -> L17
        if (r20 == null) goto L22;
        r14 = r14 + 1;     // Catch: Throwable -> L17
    L22:
        if (r20 != null) goto L24;
    L26:
        String r21 = ccOf(r18);     // Catch: Throwable -> L17
        Object r110 = r4.get(r21);     // Catch: Throwable -> L17
        if (r110 != null) goto L30;
        Group r111 = new Group(INSTANCE.ccOf(r18), 0, 0, null, 0, 0, 0, 126, null);     // Catch: Throwable -> L17
        r4.put(r21, r111);     // Catch: Throwable -> L17
        r110 = r111;
    L30:
        Group r22 = (Group) r110;     // Catch: Throwable -> L17
        r22.setN(r22.getN() + 1);     // Catch: Throwable -> L17
        String r23 = r18.getKind();     // Catch: Throwable -> L17
        if (j.a(r23, "bridge") == false) goto L34;
        r22.setBridge(r22.getBridge() + 1);     // Catch: Throwable -> L17
    L37:
        if (r20 == null) goto L6;
        if (r20.getOk() != true) goto L6;
        r22.setAlive(r22.getAlive() + 1);     // Catch: Throwable -> L17
        if (r22.getBest() == null) goto L44;
        long r24 = r20.getMs();     // Catch: Throwable -> L17
        Long r112 = r22.getBest();     // Catch: Throwable -> L17
        j.b(r112);     // Catch: Throwable -> L17
        if (r24 >= r112.longValue()) goto L6;
    L44:
        r22.setBest(Long.valueOf(r20.getMs()));     // Catch: Throwable -> L17
        goto L6
    L34:
        if (j.a(r23, "falcon") == false) goto L36;
        r22.setFalcon(r22.getFalcon() + 1);     // Catch: Throwable -> L17
        goto L37
    L36:
        r22.setPublic(r22.getPublic() + 1);     // Catch: Throwable -> L17
        goto L37
    L24:
        if (r20.getOk() != true) goto L26;
        r13 = r13 + 1;     // Catch: Throwable -> L17
        goto L26
    L11:
        if (j.a(r19, "falcon") == false) goto L13;
        r11 = r11 + 1;     // Catch: Throwable -> L17
        goto L15
    L13:
        r12 = r12 + 1;     // Catch: Throwable -> L17
        goto L15
    L45:
        long r113 = 0;
        Collection r25 = r4.values();     // Catch: Throwable -> L17
        j.d(r25, "<get-values>(...)");     // Catch: Throwable -> L17
        List r26 = q.b1(r25, p.d(new ee.c[]{new d(6), new d(7), new d(8)}));     // Catch: Throwable -> L17
        sf.c r27 = cleanScan;     // Catch: Throwable -> L17
        if (r27 == null) goto L58;
        sf.a r28 = r27.v("list");     // Catch: Throwable -> L17
        if (r28 == null) goto L58;
        h r29 = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, r28.f67155a.size());     // Catch: Throwable -> L17
        ArrayList r30 = new ArrayList();     // Catch: Throwable -> L17
        g r31 = r29.a();     // Catch: Throwable -> L17
    L51:
        if (r31.f23130c == false) goto L55;
        sf.c r32 = r28.q(r31.nextInt());     // Catch: Throwable -> L17
        if (r32 == null) goto L51;
        r30.add(r32);     // Catch: Throwable -> L17
        goto L51
    L55:
        ?? r33 = new ArrayList(kotlin.collections.s.g0(r30, 10));     // Catch: Throwable -> L17
        int r34 = r30.size();     // Catch: Throwable -> L17
        int r35 = 0;
    L56:
        if (r35 >= r34) goto L59;
        Object r114 = r30.get(r35);     // Catch: Throwable -> L17
        r35 = r35 + 1;     // Catch: Throwable -> L17
        sf.c r115 = (sf.c) r114;     // Catch: Throwable -> L17
        String r36 = r115.A("ip", "");     // Catch: Throwable -> L17
        j.d(r36, "optString(...)");     // Catch: Throwable -> L17
        int r210 = r34;
        long r37 = r113;
        long r38 = r115.x(r37, "tls");     // Catch: Throwable -> L17
        long r39 = r115.x(r37, "auth");     // Catch: Throwable -> L17
        long r310 = r115.x(r37, "kbps");     // Catch: Throwable -> L17
        String r40 = r115.A("loc", "");     // Catch: Throwable -> L17
        j.d(r40, "optString(...)");     // Catch: Throwable -> L17
        r33.add(new CleanIp(r36, r38, r39, r310, r40));     // Catch: Throwable -> L17
        r30 = r30;
        r34 = r210;
        r113 = 0;
    L59:
        if (r33 != 0) goto L61;
        r33 = w.INSTANCE;     // Catch: Throwable -> L17
    L61:
        Counts r41 = new Counts(r10, r11, r12, items.size(), r13, r14, r15, r16);     // Catch: Throwable -> L17
        Prefs r211 = prefs;     // Catch: Throwable -> L17
        Summary r116 = new Summary(r41, r26, r211, r33, falconServers.size(), q.b1(falconServers, p.d(new ee.c[]{new d(9), new d(10)})));     // Catch: Throwable -> L17
        monitor-exit(this);
        return r116;
    L58:
        r33 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    public final void test(String r22, String r23, List<String> r24, boolean r25, boolean r26, boolean r27) {
        String r4 = "kind";
        j.e(r22, "kind");
        j.e(r23, AwgProbeService.KEY_COUNTRY);
        load();
        Job r8 = testJob;
        if (r8 != null) goto L5;
    L9:
        IpScan r10 = ipScan;
        if (r10 != null) goto L12;
    L16:
        List<Item> r11 = select(r22, r23, r24, r25, r26, r27);
        if (r11.isEmpty() == true) goto L34;
        testCancel = false;
        String r12 = prefs.getCleanIp();
        if (r26 == false) goto L23;
        r4 = "verified";
    L21:
        String r13 = r4;
    L31:
        testJob = new Job(true, 0, r11.size(), 0, 0, null, 0, null, null, 0, r13, r23, r22, 1016, null);
        changed();
        m0.y(scope, null, null, new C04021(r11, r12, null), 3);
        return;
    L23:
        if (o.L0(r23) == true) goto L25;
        r4 = TunnelVpnService.EXTRA_COUNTRY;
        goto L21
    L25:
        if (r24 == null) goto L28;
        r4 = "ids";
        goto L21
    L28:
        if (r22.equals(Psi.CrashTracebackLevelAll) == false) goto L21;
        r13 = Psi.CrashTracebackLevelAll;
        goto L31
    L34:
        throw new IllegalStateException("موردی برای سنجش نیست");
    L12:
        if (r10.getRunning() != true) goto L16;
        throw new IllegalStateException("اول اسکن آی\u200cپی تمیز تمام شود");
    L5:
        if (r8.getRunning() != true) goto L9;
        throw new IllegalStateException("یک سنجش در حال اجراست");
    }

    public final void update(List<String> r20) {
        load();
        Job r4 = updateJob;
        if (r4 != null) goto L5;
    L7:
        List<SourceView> r8 = sources();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L16;
        Object r12 = r11.next();
        SourceView r13 = (SourceView) r12;
        if (r20 == null) goto L13;
        boolean r14 = r20.contains(r13.getSrc().getId());
    L14:
        if (r14 == false) goto L9;
        r10.add(r12);
        goto L9
    L13:
        r14 = r13.getOn();
        goto L14
    L16:
        ArrayList r15 = new ArrayList(kotlin.collections.s.g0(r10, 10));
        int r16 = r10.size();
        int r17 = 0;
    L17:
        if (r17 >= r16) goto L19;
        Object r18 = r10.get(r17);
        r17 = r17 + 1;
        r15.add(((SourceView) r18).getSrc());
        goto L17
    L19:
        updateCancel = false;
        ArgoNet.Route r19 = routeNow();
        int r21 = r15.size();
        if (r19 == null) goto L25;
        String r22 = r19.getLabel();
        if (r22 == null) goto L25;
    L26:
        updateJob = new Job(true, 0, r21, 0, 0, null, 0, null, r22, 0, null, null, null, 7928, null);
        changed();
        m0.y(scope, null, null, new C04031(r15, r19, null), 3);
        return;
    L25:
        r22 = "مستقیم (بدون تونل)";
        goto L26
    L5:
        if (r4.getRunning() != true) goto L7;
    }
}
