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
import com.mlmvpn.scanner.utils.LocalPort;
import com.mlmvpn.scanner.utils.NetworkSettings;
import j$.time.Instant;
import j$.time.OffsetDateTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.w;
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
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import psi.Psi;
import sd.m;
import sd.u;
import x6.p;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoPool {
    public static final int $stable;
    private static final String ASSET = "argo/argo-pool.json";
    private static final List<Source> BUILTIN;
    private static final String CARRY_UA;
    private static final long CARRY_UA_FIXED_AT = 1794063600000L;
    private static final String CARRY_URL = "https://cachefly.cachefly.net/1mb.test";
    private static final List<String> CF_V4;
    private static final List<String> CF_V6;
    public static final ArgoPool INSTANCE;
    private static final l IPV4_LITERAL;
    private static final String TAG = "ARGO";
    private static final int TEST_BATCH = 12;
    private static final String TRACE_URL = "https://www.cloudflare.com/cdn-cgi/trace";
    private static final k0 _version;
    private static Context app;
    private static long bundleBuilt;
    private static sf.c cleanScan;
    private static File dir;
    private static List<ArgoProtocol.FalconOrigin> falconServers;
    private static volatile IpScan ipScan;
    private static final LinkedHashMap<String, Item> items;
    private static boolean loaded;
    private static Prefs prefs;
    private static final SecureRandom random;
    private static final HashMap<String, Result> results;
    private static volatile boolean saveQueued;
    private static volatile boolean scanCancel;
    private static final i0 scope;
    private static final HashMap<String, sf.c> sourceState;
    private static volatile boolean testCancel;
    private static volatile Job testJob;
    private static volatile boolean updateCancel;
    private static volatile Job updateJob;
    private static final List<Source> userSources;
    private static final e1 version;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Absorbed {
        public static final int $stable = 0;
        private final int bad;
        private final int bridges;
        private final int falcons;

        public Absorbed(int i, int i10, int i11) {
            this.bridges = i;
            this.falcons = i10;
            this.bad = i11;
        }

        public static /* synthetic */ Absorbed copy$default(Absorbed absorbed, int i, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i = absorbed.bridges;
            }
            if ((i12 & 2) != 0) {
                i10 = absorbed.falcons;
            }
            if ((i12 & 4) != 0) {
                i11 = absorbed.bad;
            }
            return absorbed.copy(i, i10, i11);
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

        public final Absorbed copy(int i, int i10, int i11) {
            return new Absorbed(i, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Absorbed)) {
                return false;
            }
            Absorbed absorbed = (Absorbed) obj;
            return this.bridges == absorbed.bridges && this.falcons == absorbed.falcons && this.bad == absorbed.bad;
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
            return Integer.hashCode(this.bad) + androidx.compose.foundation.interaction.f.c(this.falcons, Integer.hashCode(this.bridges) * 31, 31);
        }

        public String toString() {
            int i = this.bridges;
            int i10 = this.falcons;
            return w0.q(androidx.compose.foundation.interaction.f.u("Absorbed(bridges=", i, ", falcons=", i10, ", bad="), this.bad, ")");
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

        public CleanIp(String ip, long j, long j10, long j11, String loc) {
            j.e(ip, "ip");
            j.e(loc, "loc");
            this.ip = ip;
            this.tls = j;
            this.auth = j10;
            this.kbps = j11;
            this.loc = loc;
        }

        public static /* synthetic */ CleanIp copy$default(CleanIp cleanIp, String str, long j, long j10, long j11, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cleanIp.ip;
            }
            if ((i & 2) != 0) {
                j = cleanIp.tls;
            }
            if ((i & 4) != 0) {
                j10 = cleanIp.auth;
            }
            if ((i & 8) != 0) {
                j11 = cleanIp.kbps;
            }
            if ((i & 16) != 0) {
                str2 = cleanIp.loc;
            }
            String str3 = str2;
            long j12 = j11;
            return cleanIp.copy(str, j, j10, j12, str3);
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

        public final CleanIp copy(String ip, long j, long j10, long j11, String loc) {
            j.e(ip, "ip");
            j.e(loc, "loc");
            return new CleanIp(ip, j, j10, j11, loc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CleanIp)) {
                return false;
            }
            CleanIp cleanIp = (CleanIp) obj;
            return j.a(this.ip, cleanIp.ip) && this.tls == cleanIp.tls && this.auth == cleanIp.auth && this.kbps == cleanIp.kbps && j.a(this.loc, cleanIp.loc);
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
            return this.loc.hashCode() + w0.c(w0.c(w0.c(this.ip.hashCode() * 31, 31, this.tls), 31, this.auth), 31, this.kbps);
        }

        public String toString() {
            String str = this.ip;
            long j = this.tls;
            long j10 = this.auth;
            long j11 = this.kbps;
            String str2 = this.loc;
            StringBuilder sbM = s.m("CleanIp(ip=", str, ", tls=", j);
            v0.a.k(j10, ", auth=", ", kbps=", sbM);
            i.t(j11, ", loc=", str2, sbM);
            sbM.append(")");
            return sbM.toString();
        }

        public /* synthetic */ CleanIp(String str, long j, long j10, long j11, String str2, int i, kotlin.jvm.internal.e eVar) {
            this(str, j, j10, j11, (i & 16) != 0 ? "" : str2);
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

        public Counts(int i, int i10, int i11, int i12, int i13, int i14, int i15, long j) {
            this.bridge = i;
            this.falcon = i10;
            this.f2public = i11;
            this.total = i12;
            this.alive = i13;
            this.tested = i14;
            this.verified = i15;
            this.verifiedAt = j;
        }

        public static /* synthetic */ Counts copy$default(Counts counts, int i, int i10, int i11, int i12, int i13, int i14, int i15, long j, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i = counts.bridge;
            }
            if ((i16 & 2) != 0) {
                i10 = counts.falcon;
            }
            if ((i16 & 4) != 0) {
                i11 = counts.f2public;
            }
            if ((i16 & 8) != 0) {
                i12 = counts.total;
            }
            if ((i16 & 16) != 0) {
                i13 = counts.alive;
            }
            if ((i16 & 32) != 0) {
                i14 = counts.tested;
            }
            if ((i16 & 64) != 0) {
                i15 = counts.verified;
            }
            if ((i16 & 128) != 0) {
                j = counts.verifiedAt;
            }
            long j10 = j;
            int i17 = i14;
            int i18 = i15;
            int i19 = i13;
            int i20 = i11;
            return counts.copy(i, i10, i20, i12, i19, i17, i18, j10);
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

        public final Counts copy(int i, int i10, int i11, int i12, int i13, int i14, int i15, long j) {
            return new Counts(i, i10, i11, i12, i13, i14, i15, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Counts)) {
                return false;
            }
            Counts counts = (Counts) obj;
            return this.bridge == counts.bridge && this.falcon == counts.falcon && this.f2public == counts.f2public && this.total == counts.total && this.alive == counts.alive && this.tested == counts.tested && this.verified == counts.verified && this.verifiedAt == counts.verifiedAt;
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
            return Long.hashCode(this.verifiedAt) + androidx.compose.foundation.interaction.f.c(this.verified, androidx.compose.foundation.interaction.f.c(this.tested, androidx.compose.foundation.interaction.f.c(this.alive, androidx.compose.foundation.interaction.f.c(this.total, androidx.compose.foundation.interaction.f.c(this.f2public, androidx.compose.foundation.interaction.f.c(this.falcon, Integer.hashCode(this.bridge) * 31, 31), 31), 31), 31), 31), 31);
        }

        public String toString() {
            int i = this.bridge;
            int i10 = this.falcon;
            int i11 = this.f2public;
            int i12 = this.total;
            int i13 = this.alive;
            int i14 = this.tested;
            int i15 = this.verified;
            long j = this.verifiedAt;
            StringBuilder sbU = androidx.compose.foundation.interaction.f.u("Counts(bridge=", i, ", falcon=", i10, ", public=");
            s.v(sbU, i11, ", total=", i12, ", alive=");
            s.v(sbU, i13, ", tested=", i14, ", verified=");
            i.r(i15, j, ", verifiedAt=", sbU);
            sbU.append(")");
            return sbU.toString();
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

        public Group(String cc2, int i, int i10, Long l6, int i11, int i12, int i13) {
            j.e(cc2, "cc");
            this.f11198cc = cc2;
            this.f11199n = i;
            this.alive = i10;
            this.best = l6;
            this.bridge = i11;
            this.falcon = i12;
            this.f3public = i13;
        }

        public static /* synthetic */ Group copy$default(Group group, String str, int i, int i10, Long l6, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                str = group.f11198cc;
            }
            if ((i14 & 2) != 0) {
                i = group.f11199n;
            }
            if ((i14 & 4) != 0) {
                i10 = group.alive;
            }
            if ((i14 & 8) != 0) {
                l6 = group.best;
            }
            if ((i14 & 16) != 0) {
                i11 = group.bridge;
            }
            if ((i14 & 32) != 0) {
                i12 = group.falcon;
            }
            if ((i14 & 64) != 0) {
                i13 = group.f3public;
            }
            int i15 = i12;
            int i16 = i13;
            int i17 = i11;
            int i18 = i10;
            return group.copy(str, i, i18, l6, i17, i15, i16);
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

        public final Group copy(String cc2, int i, int i10, Long l6, int i11, int i12, int i13) {
            j.e(cc2, "cc");
            return new Group(cc2, i, i10, l6, i11, i12, i13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Group)) {
                return false;
            }
            Group group = (Group) obj;
            return j.a(this.f11198cc, group.f11198cc) && this.f11199n == group.f11199n && this.alive == group.alive && j.a(this.best, group.best) && this.bridge == group.bridge && this.falcon == group.falcon && this.f3public == group.f3public;
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
            int iC = androidx.compose.foundation.interaction.f.c(this.alive, androidx.compose.foundation.interaction.f.c(this.f11199n, this.f11198cc.hashCode() * 31, 31), 31);
            Long l6 = this.best;
            return Integer.hashCode(this.f3public) + androidx.compose.foundation.interaction.f.c(this.falcon, androidx.compose.foundation.interaction.f.c(this.bridge, (iC + (l6 == null ? 0 : l6.hashCode())) * 31, 31), 31);
        }

        public final void setAlive(int i) {
            this.alive = i;
        }

        public final void setBest(Long l6) {
            this.best = l6;
        }

        public final void setBridge(int i) {
            this.bridge = i;
        }

        public final void setFalcon(int i) {
            this.falcon = i;
        }

        public final void setN(int i) {
            this.f11199n = i;
        }

        public final void setPublic(int i) {
            this.f3public = i;
        }

        public String toString() {
            String str = this.f11198cc;
            int i = this.f11199n;
            int i10 = this.alive;
            Long l6 = this.best;
            int i11 = this.bridge;
            int i12 = this.falcon;
            int i13 = this.f3public;
            StringBuilder sbL = s.l("Group(cc=", str, ", n=", i, ", alive=");
            sbL.append(i10);
            sbL.append(", best=");
            sbL.append(l6);
            sbL.append(", bridge=");
            s.v(sbL, i11, ", falcon=", i12, ", public=");
            return w0.q(sbL, i13, ")");
        }

        public /* synthetic */ Group(String str, int i, int i10, Long l6, int i11, int i12, int i13, int i14, kotlin.jvm.internal.e eVar) {
            this(str, (i14 & 2) != 0 ? 0 : i, (i14 & 4) != 0 ? 0 : i10, (i14 & 8) != 0 ? null : l6, (i14 & 16) != 0 ? 0 : i11, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) != 0 ? 0 : i13);
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

        public IpScan(boolean z10, String phase, int i, int i10, List<CleanIp> found, String ref, String error, String note, long j) {
            j.e(phase, "phase");
            j.e(found, "found");
            j.e(ref, "ref");
            j.e(error, "error");
            j.e(note, "note");
            this.running = z10;
            this.phase = phase;
            this.done = i;
            this.total = i10;
            this.found = found;
            this.ref = ref;
            this.error = error;
            this.note = note;
            this.endedAt = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IpScan copy$default(IpScan ipScan, boolean z10, String str, int i, int i10, List list, String str2, String str3, String str4, long j, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z10 = ipScan.running;
            }
            if ((i11 & 2) != 0) {
                str = ipScan.phase;
            }
            if ((i11 & 4) != 0) {
                i = ipScan.done;
            }
            if ((i11 & 8) != 0) {
                i10 = ipScan.total;
            }
            if ((i11 & 16) != 0) {
                list = ipScan.found;
            }
            if ((i11 & 32) != 0) {
                str2 = ipScan.ref;
            }
            if ((i11 & 64) != 0) {
                str3 = ipScan.error;
            }
            if ((i11 & 128) != 0) {
                str4 = ipScan.note;
            }
            if ((i11 & 256) != 0) {
                j = ipScan.endedAt;
            }
            long j10 = j;
            String str5 = str3;
            String str6 = str4;
            List list2 = list;
            String str7 = str2;
            return ipScan.copy(z10, str, i, i10, list2, str7, str5, str6, j10);
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

        public final IpScan copy(boolean z10, String phase, int i, int i10, List<CleanIp> found, String ref, String error, String note, long j) {
            j.e(phase, "phase");
            j.e(found, "found");
            j.e(ref, "ref");
            j.e(error, "error");
            j.e(note, "note");
            return new IpScan(z10, phase, i, i10, found, ref, error, note, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IpScan)) {
                return false;
            }
            IpScan ipScan = (IpScan) obj;
            return this.running == ipScan.running && j.a(this.phase, ipScan.phase) && this.done == ipScan.done && this.total == ipScan.total && j.a(this.found, ipScan.found) && j.a(this.ref, ipScan.ref) && j.a(this.error, ipScan.error) && j.a(this.note, ipScan.note) && this.endedAt == ipScan.endedAt;
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
            return Long.hashCode(this.endedAt) + s.d(s.d(s.d(androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.c(this.total, androidx.compose.foundation.interaction.f.c(this.done, s.d(Boolean.hashCode(this.running) * 31, 31, this.phase), 31), 31), 31, this.found), 31, this.ref), 31, this.error), 31, this.note);
        }

        public String toString() {
            boolean z10 = this.running;
            String str = this.phase;
            int i = this.done;
            int i10 = this.total;
            List<CleanIp> list = this.found;
            String str2 = this.ref;
            String str3 = this.error;
            String str4 = this.note;
            long j = this.endedAt;
            StringBuilder sb2 = new StringBuilder("IpScan(running=");
            sb2.append(z10);
            sb2.append(", phase=");
            sb2.append(str);
            sb2.append(", done=");
            s.v(sb2, i, ", total=", i10, ", found=");
            sb2.append(list);
            sb2.append(", ref=");
            sb2.append(str2);
            sb2.append(", error=");
            d1.x(sb2, str3, ", note=", str4, ", endedAt=");
            return w0.k(j, ")", sb2);
        }

        public /* synthetic */ IpScan(boolean z10, String str, int i, int i10, List list, String str2, String str3, String str4, long j, int i11, kotlin.jvm.internal.e eVar) {
            this(z10, str, i, i10, list, str2, (i11 & 64) != 0 ? "" : str3, (i11 & 128) != 0 ? "" : str4, (i11 & 256) != 0 ? 0L : j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Page {
        private final int code;
        private final boolean ok;
        private final List<Post> posts;

        public Page(boolean z10, int i, List<Post> posts) {
            j.e(posts, "posts");
            this.ok = z10;
            this.code = i;
            this.posts = posts;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Page copy$default(Page page, boolean z10, int i, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = page.ok;
            }
            if ((i10 & 2) != 0) {
                i = page.code;
            }
            if ((i10 & 4) != 0) {
                list = page.posts;
            }
            return page.copy(z10, i, list);
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

        public final Page copy(boolean z10, int i, List<Post> posts) {
            j.e(posts, "posts");
            return new Page(z10, i, posts);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Page)) {
                return false;
            }
            Page page = (Page) obj;
            return this.ok == page.ok && this.code == page.code && j.a(this.posts, page.posts);
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
            return this.posts.hashCode() + androidx.compose.foundation.interaction.f.c(this.code, Boolean.hashCode(this.ok) * 31, 31);
        }

        public String toString() {
            boolean z10 = this.ok;
            int i = this.code;
            List<Post> list = this.posts;
            StringBuilder sb2 = new StringBuilder("Page(ok=");
            sb2.append(z10);
            sb2.append(", code=");
            sb2.append(i);
            sb2.append(", posts=");
            return d1.j(sb2, list, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Parsed {
        public static final int $stable = 8;
        private final List<ParsedBridge> bridges;
        private final List<String> falcons;

        public Parsed(List<ParsedBridge> bridges, List<String> falcons) {
            j.e(bridges, "bridges");
            j.e(falcons, "falcons");
            this.bridges = bridges;
            this.falcons = falcons;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Parsed copy$default(Parsed parsed, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = parsed.bridges;
            }
            if ((i & 2) != 0) {
                list2 = parsed.falcons;
            }
            return parsed.copy(list, list2);
        }

        public final List<ParsedBridge> component1() {
            return this.bridges;
        }

        public final List<String> component2() {
            return this.falcons;
        }

        public final Parsed copy(List<ParsedBridge> bridges, List<String> falcons) {
            j.e(bridges, "bridges");
            j.e(falcons, "falcons");
            return new Parsed(bridges, falcons);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) obj;
            return j.a(this.bridges, parsed.bridges) && j.a(this.falcons, parsed.falcons);
        }

        public final List<ParsedBridge> getBridges() {
            return this.bridges;
        }

        public final List<String> getFalcons() {
            return this.falcons;
        }

        public int hashCode() {
            return this.falcons.hashCode() + (this.bridges.hashCode() * 31);
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

        public ParsedBridge(String host, int i, boolean z10, String error) {
            j.e(host, "host");
            j.e(error, "error");
            this.host = host;
            this.port = i;
            this.sigOk = z10;
            this.error = error;
        }

        public static /* synthetic */ ParsedBridge copy$default(ParsedBridge parsedBridge, String str, int i, boolean z10, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = parsedBridge.host;
            }
            if ((i10 & 2) != 0) {
                i = parsedBridge.port;
            }
            if ((i10 & 4) != 0) {
                z10 = parsedBridge.sigOk;
            }
            if ((i10 & 8) != 0) {
                str2 = parsedBridge.error;
            }
            return parsedBridge.copy(str, i, z10, str2);
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

        public final ParsedBridge copy(String host, int i, boolean z10, String error) {
            j.e(host, "host");
            j.e(error, "error");
            return new ParsedBridge(host, i, z10, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParsedBridge)) {
                return false;
            }
            ParsedBridge parsedBridge = (ParsedBridge) obj;
            return j.a(this.host, parsedBridge.host) && this.port == parsedBridge.port && this.sigOk == parsedBridge.sigOk && j.a(this.error, parsedBridge.error);
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
            return this.error.hashCode() + w0.d(androidx.compose.foundation.interaction.f.c(this.port, this.host.hashCode() * 31, 31), 31, this.sigOk);
        }

        public String toString() {
            String str = this.host;
            int i = this.port;
            boolean z10 = this.sigOk;
            String str2 = this.error;
            StringBuilder sbL = s.l("ParsedBridge(host=", str, ", port=", i, ", sigOk=");
            sbL.append(z10);
            sbL.append(", error=");
            sbL.append(str2);
            sbL.append(")");
            return sbL.toString();
        }

        public /* synthetic */ ParsedBridge(String str, int i, boolean z10, String str2, int i10, kotlin.jvm.internal.e eVar) {
            this(str, i, z10, (i10 & 8) != 0 ? "" : str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Post {
        private final long at;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final long f11203id;
        private final String text;

        public Post(long j, long j10, String text) {
            j.e(text, "text");
            this.f11203id = j;
            this.at = j10;
            this.text = text;
        }

        public static /* synthetic */ Post copy$default(Post post, long j, long j10, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = post.f11203id;
            }
            long j11 = j;
            if ((i & 2) != 0) {
                j10 = post.at;
            }
            long j12 = j10;
            if ((i & 4) != 0) {
                str = post.text;
            }
            return post.copy(j11, j12, str);
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

        public final Post copy(long j, long j10, String text) {
            j.e(text, "text");
            return new Post(j, j10, text);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Post)) {
                return false;
            }
            Post post = (Post) obj;
            return this.f11203id == post.f11203id && this.at == post.at && j.a(this.text, post.text);
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
            return this.text.hashCode() + w0.c(Long.hashCode(this.f11203id) * 31, 31, this.at);
        }

        public String toString() {
            long j = this.f11203id;
            long j10 = this.at;
            String str = this.text;
            StringBuilder sbO = f0.a.o(j, "Post(id=", ", at=");
            i.t(j10, ", text=", str, sbO);
            sbO.append(")");
            return sbO.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Prefs {
        public static final int $stable = 0;
        private final boolean autoClean;
        private final String cleanIp;

        /* JADX WARN: Multi-variable type inference failed */
        public Prefs() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Prefs copy$default(Prefs prefs, String str, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = prefs.cleanIp;
            }
            if ((i & 2) != 0) {
                z10 = prefs.autoClean;
            }
            return prefs.copy(str, z10);
        }

        public final String component1() {
            return this.cleanIp;
        }

        public final boolean component2() {
            return this.autoClean;
        }

        public final Prefs copy(String cleanIp, boolean z10) {
            j.e(cleanIp, "cleanIp");
            return new Prefs(cleanIp, z10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Prefs)) {
                return false;
            }
            Prefs prefs = (Prefs) obj;
            return j.a(this.cleanIp, prefs.cleanIp) && this.autoClean == prefs.autoClean;
        }

        public final boolean getAutoClean() {
            return this.autoClean;
        }

        public final String getCleanIp() {
            return this.cleanIp;
        }

        public int hashCode() {
            return Boolean.hashCode(this.autoClean) + (this.cleanIp.hashCode() * 31);
        }

        public String toString() {
            return "Prefs(cleanIp=" + this.cleanIp + ", autoClean=" + this.autoClean + ")";
        }

        public Prefs(String cleanIp, boolean z10) {
            j.e(cleanIp, "cleanIp");
            this.cleanIp = cleanIp;
            this.autoClean = z10;
        }

        public /* synthetic */ Prefs(String str, boolean z10, int i, kotlin.jvm.internal.e eVar) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ready {
        private final ArgoProtocol.Endpoint ep;
        private final ArgoProtocol.SessionInfo info;
        private final long ms;
        private final Item x;

        public Ready(Item x, ArgoProtocol.Endpoint ep, ArgoProtocol.SessionInfo info, long j) {
            j.e(x, "x");
            j.e(ep, "ep");
            j.e(info, "info");
            this.x = x;
            this.ep = ep;
            this.info = info;
            this.ms = j;
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

        public Result(boolean z10, long j, String cc2, String exitIp, long j10, int i, String error, boolean z11, String edge) {
            j.e(cc2, "cc");
            j.e(exitIp, "exitIp");
            j.e(error, "error");
            j.e(edge, "edge");
            this.ok = z10;
            this.ms = j;
            this.f11204cc = cc2;
            this.exitIp = exitIp;
            this.at = j10;
            this.fails = i;
            this.error = error;
            this.frozen = z11;
            this.edge = edge;
        }

        public static /* synthetic */ Result copy$default(Result result, boolean z10, long j, String str, String str2, long j10, int i, String str3, boolean z11, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = result.ok;
            }
            if ((i10 & 2) != 0) {
                j = result.ms;
            }
            if ((i10 & 4) != 0) {
                str = result.f11204cc;
            }
            if ((i10 & 8) != 0) {
                str2 = result.exitIp;
            }
            if ((i10 & 16) != 0) {
                j10 = result.at;
            }
            if ((i10 & 32) != 0) {
                i = result.fails;
            }
            if ((i10 & 64) != 0) {
                str3 = result.error;
            }
            if ((i10 & 128) != 0) {
                z11 = result.frozen;
            }
            if ((i10 & 256) != 0) {
                str4 = result.edge;
            }
            long j11 = j10;
            String str5 = str;
            return result.copy(z10, j, str5, str2, j11, i, str3, z11, str4);
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

        public final Result copy(boolean z10, long j, String cc2, String exitIp, long j10, int i, String error, boolean z11, String edge) {
            j.e(cc2, "cc");
            j.e(exitIp, "exitIp");
            j.e(error, "error");
            j.e(edge, "edge");
            return new Result(z10, j, cc2, exitIp, j10, i, error, z11, edge);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.ok == result.ok && this.ms == result.ms && j.a(this.f11204cc, result.f11204cc) && j.a(this.exitIp, result.exitIp) && this.at == result.at && this.fails == result.fails && j.a(this.error, result.error) && this.frozen == result.frozen && j.a(this.edge, result.edge);
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
            return this.edge.hashCode() + w0.d(s.d(androidx.compose.foundation.interaction.f.c(this.fails, w0.c(s.d(s.d(w0.c(Boolean.hashCode(this.ok) * 31, 31, this.ms), 31, this.f11204cc), 31, this.exitIp), 31, this.at), 31), 31, this.error), 31, this.frozen);
        }

        public String toString() {
            boolean z10 = this.ok;
            long j = this.ms;
            String str = this.f11204cc;
            String str2 = this.exitIp;
            long j10 = this.at;
            int i = this.fails;
            String str3 = this.error;
            boolean z11 = this.frozen;
            String str4 = this.edge;
            StringBuilder sb2 = new StringBuilder("Result(ok=");
            sb2.append(z10);
            sb2.append(", ms=");
            sb2.append(j);
            d1.x(sb2, ", cc=", str, ", exitIp=", str2);
            v0.a.k(j10, ", at=", ", fails=", sb2);
            d1.n(i, ", error=", str3, ", frozen=", sb2);
            sb2.append(z11);
            sb2.append(", edge=");
            sb2.append(str4);
            sb2.append(")");
            return sb2.toString();
        }

        public /* synthetic */ Result(boolean z10, long j, String str, String str2, long j10, int i, String str3, boolean z11, String str4, int i10, kotlin.jvm.internal.e eVar) {
            this(z10, j, str, str2, j10, i, str3, (i10 & 128) != 0 ? false : z11, (i10 & 256) != 0 ? "" : str4);
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

        public Source(String id2, String type, List<String> value, String label, boolean z10, boolean z11, long j) {
            j.e(id2, "id");
            j.e(type, "type");
            j.e(value, "value");
            j.e(label, "label");
            this.f11207id = id2;
            this.type = type;
            this.value = value;
            this.label = label;
            this.builtin = z10;
            this.user = z11;
            this.addedAt = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Source copy$default(Source source, String str, String str2, List list, String str3, boolean z10, boolean z11, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.f11207id;
            }
            if ((i & 2) != 0) {
                str2 = source.type;
            }
            if ((i & 4) != 0) {
                list = source.value;
            }
            if ((i & 8) != 0) {
                str3 = source.label;
            }
            if ((i & 16) != 0) {
                z10 = source.builtin;
            }
            if ((i & 32) != 0) {
                z11 = source.user;
            }
            if ((i & 64) != 0) {
                j = source.addedAt;
            }
            long j10 = j;
            boolean z12 = z10;
            boolean z13 = z11;
            return source.copy(str, str2, list, str3, z12, z13, j10);
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

        public final Source copy(String id2, String type, List<String> value, String label, boolean z10, boolean z11, long j) {
            j.e(id2, "id");
            j.e(type, "type");
            j.e(value, "value");
            j.e(label, "label");
            return new Source(id2, type, value, label, z10, z11, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Source)) {
                return false;
            }
            Source source = (Source) obj;
            return j.a(this.f11207id, source.f11207id) && j.a(this.type, source.type) && j.a(this.value, source.value) && j.a(this.label, source.label) && this.builtin == source.builtin && this.user == source.user && this.addedAt == source.addedAt;
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
            return Long.hashCode(this.addedAt) + w0.d(w0.d(s.d(androidx.compose.foundation.interaction.f.f(s.d(this.f11207id.hashCode() * 31, 31, this.type), 31, this.value), 31, this.label), 31, this.builtin), 31, this.user);
        }

        public String toString() {
            String str = this.f11207id;
            String str2 = this.type;
            List<String> list = this.value;
            String str3 = this.label;
            boolean z10 = this.builtin;
            boolean z11 = this.user;
            long j = this.addedAt;
            StringBuilder sbN = s.n("Source(id=", str, ", type=", str2, ", value=");
            sbN.append(list);
            sbN.append(", label=");
            sbN.append(str3);
            sbN.append(", builtin=");
            s.x(sbN, z10, ", user=", z11, ", addedAt=");
            return w0.k(j, ")", sbN);
        }

        public /* synthetic */ Source(String str, String str2, List list, String str3, boolean z10, boolean z11, long j, int i, kotlin.jvm.internal.e eVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? false : z10, (i & 32) != 0 ? false : z11, (i & 64) != 0 ? 0L : j);
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

        public SourceView(Source src, boolean z10, long j, int i, int i10, String error) {
            j.e(src, "src");
            j.e(error, "error");
            this.src = src;
            this.on = z10;
            this.at = j;
            this.found = i;
            this.total = i10;
            this.error = error;
        }

        public static /* synthetic */ SourceView copy$default(SourceView sourceView, Source source, boolean z10, long j, int i, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                source = sourceView.src;
            }
            if ((i11 & 2) != 0) {
                z10 = sourceView.on;
            }
            if ((i11 & 4) != 0) {
                j = sourceView.at;
            }
            if ((i11 & 8) != 0) {
                i = sourceView.found;
            }
            if ((i11 & 16) != 0) {
                i10 = sourceView.total;
            }
            if ((i11 & 32) != 0) {
                str = sourceView.error;
            }
            String str2 = str;
            int i12 = i;
            long j10 = j;
            return sourceView.copy(source, z10, j10, i12, i10, str2);
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

        public final SourceView copy(Source src, boolean z10, long j, int i, int i10, String error) {
            j.e(src, "src");
            j.e(error, "error");
            return new SourceView(src, z10, j, i, i10, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SourceView)) {
                return false;
            }
            SourceView sourceView = (SourceView) obj;
            return j.a(this.src, sourceView.src) && this.on == sourceView.on && this.at == sourceView.at && this.found == sourceView.found && this.total == sourceView.total && j.a(this.error, sourceView.error);
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
            return this.error.hashCode() + androidx.compose.foundation.interaction.f.c(this.total, androidx.compose.foundation.interaction.f.c(this.found, w0.c(w0.d(this.src.hashCode() * 31, 31, this.on), 31, this.at), 31), 31);
        }

        public String toString() {
            Source source = this.src;
            boolean z10 = this.on;
            long j = this.at;
            int i = this.found;
            int i10 = this.total;
            String str = this.error;
            StringBuilder sb2 = new StringBuilder("SourceView(src=");
            sb2.append(source);
            sb2.append(", on=");
            sb2.append(z10);
            sb2.append(", at=");
            s.p(i, j, ", found=", sb2);
            sb2.append(", total=");
            sb2.append(i10);
            sb2.append(", error=");
            sb2.append(str);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Trace {
        private volatile boolean carried;
        private final String ip;
        private final String loc;
        private final boolean ok;

        public Trace(boolean z10, String loc, String ip) {
            j.e(loc, "loc");
            j.e(ip, "ip");
            this.ok = z10;
            this.loc = loc;
            this.ip = ip;
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

        public final void setCarried(boolean z10) {
            this.carried = z10;
        }

        public /* synthetic */ Trace(boolean z10, String str, String str2, int i, kotlin.jvm.internal.e eVar) {
            this(z10, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
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

        public AnonymousClass1(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.this.harvestTelegram(null, 0, null, null, null, this);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(VlessXrayInjector vlessXrayInjector, wd.d dVar) {
                super(2, dVar);
                this.$core = vlessXrayInjector;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$core, dVar);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                Object objM1004constructorimpl;
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                try {
                    this.$core.stop();
                    objM1004constructorimpl = sd.l.m1004constructorimpl(u.f67154a);
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
                }
                return sd.l.m1003boximpl(objM1004constructorimpl);
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((AnonymousClass5) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Ready> list, String str, wd.d dVar) {
            super(2, dVar);
            this.$batch = list;
            this.$connectIp = str;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$batch, this.$connectIp, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:108:0x0357 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:110:0x0308 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:22:0x0063 A[PHI: r0 r3 r4 r8 r15
          0x0063: PHI (r0v23 java.util.List) = (r0v19 java.util.List), (r0v32 java.util.List) binds: [B:68:0x02cd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0063: PHI (r3v28 com.mlmvpn.core.warp.VlessXrayInjector) = (r3v27 com.mlmvpn.core.warp.VlessXrayInjector), (r3v29 com.mlmvpn.core.warp.VlessXrayInjector) binds: [B:68:0x02cd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0063: PHI (r4v34 java.lang.Object) = (r4v33 java.lang.Object), (r4v36 java.lang.Object) binds: [B:68:0x02cd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0063: PHI (r8v9 kotlinx.coroutines.i0) = (r8v6 kotlinx.coroutines.i0), (r8v12 kotlinx.coroutines.i0) binds: [B:68:0x02cd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0063: PHI (r15v7 int) = (r15v5 int), (r15v8 int) binds: [B:68:0x02cd, B:21:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:26:0x0078 A[PHI: r0 r7 r8 r15
          0x0078: PHI (r0v19 java.util.List) = (r0v9 java.util.List), (r0v22 java.util.List) binds: [B:61:0x028c, B:25:0x0077] A[DONT_GENERATE, DONT_INLINE]
          0x0078: PHI (r7v10 com.mlmvpn.core.warp.VlessXrayInjector) = (r7v7 com.mlmvpn.core.warp.VlessXrayInjector), (r7v15 com.mlmvpn.core.warp.VlessXrayInjector) binds: [B:61:0x028c, B:25:0x0077] A[DONT_GENERATE, DONT_INLINE]
          0x0078: PHI (r8v6 kotlinx.coroutines.i0) = (r8v2 kotlinx.coroutines.i0), (r8v8 kotlinx.coroutines.i0) binds: [B:61:0x028c, B:25:0x0077] A[DONT_GENERATE, DONT_INLINE]
          0x0078: PHI (r15v5 int) = (r15v4 int), (r15v6 int) binds: [B:61:0x028c, B:25:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:51:0x0222 A[Catch: all -> 0x004b, TryCatch #1 {all -> 0x004b, blocks: (B:15:0x0044, B:20:0x005c, B:24:0x0074, B:28:0x0088, B:49:0x021a, B:51:0x0222, B:52:0x0235, B:54:0x023b, B:60:0x0270), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x023b A[Catch: all -> 0x004b, LOOP:3: B:52:0x0235->B:54:0x023b, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x004b, blocks: (B:15:0x0044, B:20:0x005c, B:24:0x0074, B:28:0x0088, B:49:0x021a, B:51:0x0222, B:52:0x0235, B:54:0x023b, B:60:0x0270), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x026f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x0270 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004b, blocks: (B:15:0x0044, B:20:0x005c, B:24:0x0074, B:28:0x0088, B:49:0x021a, B:51:0x0222, B:52:0x0235, B:54:0x023b, B:60:0x0270), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x02ab A[Catch: all -> 0x0031, LOOP:2: B:64:0x02a7->B:66:0x02ab, LOOP_END, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x002c, B:82:0x0322, B:83:0x0335, B:85:0x033b, B:87:0x0343, B:88:0x0357, B:89:0x035c, B:90:0x035d, B:70:0x02d1, B:71:0x02e6, B:73:0x02ec, B:75:0x02f4, B:76:0x0308, B:77:0x030d, B:78:0x030e, B:63:0x0290, B:64:0x02a7, B:66:0x02ab, B:67:0x02c0), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:69:0x02cf  */
        /* JADX WARN: Code duplicated, block: B:73:0x02ec A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x002c, B:82:0x0322, B:83:0x0335, B:85:0x033b, B:87:0x0343, B:88:0x0357, B:89:0x035c, B:90:0x035d, B:70:0x02d1, B:71:0x02e6, B:73:0x02ec, B:75:0x02f4, B:76:0x0308, B:77:0x030d, B:78:0x030e, B:63:0x0290, B:64:0x02a7, B:66:0x02ab, B:67:0x02c0), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x02f4 A[Catch: all -> 0x0031, LOOP:1: B:71:0x02e6->B:75:0x02f4, LOOP_END, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x002c, B:82:0x0322, B:83:0x0335, B:85:0x033b, B:87:0x0343, B:88:0x0357, B:89:0x035c, B:90:0x035d, B:70:0x02d1, B:71:0x02e6, B:73:0x02ec, B:75:0x02f4, B:76:0x0308, B:77:0x030d, B:78:0x030e, B:63:0x0290, B:64:0x02a7, B:66:0x02ab, B:67:0x02c0), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x031f  */
        /* JADX WARN: Code duplicated, block: B:81:0x0321  */
        /* JADX WARN: Code duplicated, block: B:85:0x033b A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x002c, B:82:0x0322, B:83:0x0335, B:85:0x033b, B:87:0x0343, B:88:0x0357, B:89:0x035c, B:90:0x035d, B:70:0x02d1, B:71:0x02e6, B:73:0x02ec, B:75:0x02f4, B:76:0x0308, B:77:0x030d, B:78:0x030e, B:63:0x0290, B:64:0x02a7, B:66:0x02ab, B:67:0x02c0), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x0343 A[Catch: all -> 0x0031, LOOP:0: B:83:0x0335->B:87:0x0343, LOOP_END, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x002c, B:82:0x0322, B:83:0x0335, B:85:0x033b, B:87:0x0343, B:88:0x0357, B:89:0x035c, B:90:0x035d, B:70:0x02d1, B:71:0x02e6, B:73:0x02ec, B:75:0x02f4, B:76:0x0308, B:77:0x030d, B:78:0x030e, B:63:0x0290, B:64:0x02a7, B:66:0x02ab, B:67:0x02c0), top: B:105:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:93:0x0370 A[PHI: r0 r3
          0x0370: PHI (r0v36 java.util.List) = (r0v33 java.util.List), (r0v38 java.util.List) binds: [B:91:0x036d, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x0370: PHI (r3v32 com.mlmvpn.core.warp.VlessXrayInjector) = (r3v30 com.mlmvpn.core.warp.VlessXrayInjector), (r3v36 com.mlmvpn.core.warp.VlessXrayInjector) binds: [B:91:0x036d, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:96:0x038c A[RETURN] */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x004c: MOVE (r3 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:77), block:B:18:0x004c */
        @Override // xd.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            VlessXrayInjector vlessXrayInjector;
            VlessXrayInjector vlessXrayInjector2;
            wd.d dVar;
            Object objStart;
            i0 i0Var;
            List list;
            VlessXrayInjector vlessXrayInjector3;
            ArgoPool argoPool;
            int i;
            int iIntValue;
            ArrayList arrayList;
            wd.i iVarPlus;
            AnonymousClass5 anonymousClass5;
            VlessXrayInjector vlessXrayInjector4;
            ArrayList arrayList2;
            g gVarA;
            Object objD;
            i0 i0Var2;
            List list2;
            List list3;
            ArrayList arrayList3;
            int i10;
            List list4;
            int i11;
            ArrayList arrayList4;
            int i12;
            wd.i iVarPlus2;
            AnonymousClass5 anonymousClass6;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            try {
                try {
                    switch (this.label) {
                        case 0:
                            m.b(obj);
                            i0 i0Var3 = (i0) this.L$0;
                            List<Ready> list5 = this.$batch;
                            ArrayList arrayList5 = new ArrayList(kotlin.collections.s.g0(list5, 10));
                            for (Ready ready : list5) {
                                arrayList5.add(new Integer(ArgoPool.INSTANCE.freePort()));
                            }
                            sf.a aVar2 = new sf.a();
                            sf.a aVar3 = new sf.a();
                            sf.a aVar4 = new sf.a();
                            List<Ready> list6 = this.$batch;
                            String str = this.$connectIp;
                            int i13 = 0;
                            for (Object obj2 : list6) {
                                int i14 = i13 + 1;
                                if (i13 < 0) {
                                    r.f0();
                                    throw null;
                                }
                                Ready ready2 = (Ready) obj2;
                                sf.c cVar = new sf.c();
                                cVar.D("tag", "in" + i13);
                                cVar.D("listen", SniSession.LOCAL_HOST);
                                cVar.D(PsiphonProbeService.PORT, Integer.valueOf(((Number) arrayList5.get(i13)).intValue()));
                                cVar.D("protocol", "socks");
                                sf.c cVar2 = new sf.c();
                                cVar2.E("udp", false);
                                cVar.D("settings", cVar2);
                                aVar2.put(cVar);
                                String str2 = str;
                                int i15 = i13;
                                aVar3.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, ready2.getEp(), ready2.getInfo(), f0.a.h(i13, "out"), str2, null, 16, null));
                                sf.c cVar3 = new sf.c();
                                cVar3.D(TeXSymbolParser.TYPE_ATTR, "field");
                                sf.a aVar5 = new sf.a();
                                aVar5.put("in" + i15);
                                cVar3.D("inboundTag", aVar5);
                                cVar3.D("outboundTag", "out" + i15);
                                aVar4.put(cVar3);
                                str = str2;
                                i13 = i14;
                            }
                            dVar = null;
                            sf.c cVar4 = new sf.c();
                            cVar4.D("tag", "block");
                            cVar4.D("protocol", "blackhole");
                            aVar3.put(cVar4);
                            sf.c cVar5 = new sf.c();
                            sf.c cVar6 = new sf.c();
                            cVar6.D("loglevel", "none");
                            cVar5.D(XrayCoreHostService.KEY_LOG, cVar6);
                            cVar5.D("inbounds", aVar2);
                            cVar5.D("outbounds", aVar3);
                            sf.c cVar7 = new sf.c();
                            cVar7.D("domainStrategy", "AsIs");
                            cVar7.D("rules", aVar4);
                            String strH = com.mlmvpn.scanner.e.h(cVar5, "routing", cVar7, "toString(...)");
                            VlessXrayInjector vlessXrayInjector5 = new VlessXrayInjector(0, null, true, 2, null);
                            try {
                                Context context = ArgoPool.app;
                                if (context == null) {
                                    j.k("app");
                                    throw null;
                                }
                                this.L$0 = i0Var3;
                                this.L$1 = arrayList5;
                                this.L$2 = vlessXrayInjector5;
                                this.label = 1;
                                objStart = vlessXrayInjector5.start(context, strH, 0, this);
                                if (objStart != aVar) {
                                    i0Var = i0Var3;
                                    list = arrayList5;
                                    vlessXrayInjector3 = vlessXrayInjector5;
                                    if (((Boolean) objStart).booleanValue()) {
                                        argoPool = ArgoPool.INSTANCE;
                                        i = 0;
                                        iIntValue = ((Number) list.get(0)).intValue();
                                        this.L$0 = i0Var;
                                        this.L$1 = list;
                                        this.L$2 = vlessXrayInjector3;
                                        this.label = 3;
                                        if (argoPool.waitPort(iIntValue, 5000L, this) != aVar) {
                                            vlessXrayInjector4 = vlessXrayInjector3;
                                            h hVarY = r.Y(this.$batch);
                                            arrayList2 = new ArrayList(kotlin.collections.s.g0(hVarY, 10));
                                            gVarA = hVarY.iterator();
                                            while (gVarA.f23130c) {
                                                arrayList2.add(m0.c(i0Var, v0.f24208c, new ArgoPool$measureExits$2$out$1$1(list, gVarA.nextInt(), null), 2));
                                            }
                                            this.L$0 = i0Var;
                                            this.L$1 = list;
                                            this.L$2 = vlessXrayInjector4;
                                            this.label = 4;
                                            objD = m0.d(arrayList2, this);
                                            if (objD != aVar) {
                                                i0Var2 = i0Var;
                                                list2 = list;
                                                list3 = (List) objD;
                                                List list7 = list3;
                                                arrayList3 = new ArrayList(kotlin.collections.s.g0(list7, 10));
                                                i10 = i;
                                                for (Object obj3 : list7) {
                                                    i11 = i10 + 1;
                                                    if (i10 >= 0) {
                                                        r.f0();
                                                        throw null;
                                                    }
                                                    arrayList3.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$3$1((Trace) obj3, list2, i10, null), 2));
                                                    i10 = i11;
                                                }
                                                this.L$0 = i0Var2;
                                                this.L$1 = list2;
                                                this.L$2 = vlessXrayInjector4;
                                                this.L$3 = list3;
                                                this.label = 5;
                                                if (m0.d(arrayList3, this) == aVar) {
                                                    list4 = list3;
                                                    List<Ready> list8 = this.$batch;
                                                    arrayList4 = new ArrayList(kotlin.collections.s.g0(list8, 10));
                                                    for (Object obj4 : list8) {
                                                        i12 = i + 1;
                                                        if (i < 0) {
                                                            r.f0();
                                                            throw null;
                                                        }
                                                        arrayList4.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) obj4, list2, i, null), 2));
                                                        i = i12;
                                                    }
                                                    this.L$0 = vlessXrayInjector4;
                                                    this.L$1 = list4;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.label = 6;
                                                    if (m0.d(arrayList4, this) != aVar) {
                                                        iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                                                        anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                                                        this.L$0 = list4;
                                                        this.L$1 = null;
                                                        this.label = 7;
                                                        if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                                            return list4;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        List<Ready> list9 = this.$batch;
                                        arrayList = new ArrayList(kotlin.collections.s.g0(list9, 10));
                                        for (Ready ready3 : list9) {
                                            arrayList.add(new Trace(false, null, null, 6, null));
                                        }
                                        iVarPlus = m2.f24144a.plus(v0.f24208c);
                                        wd.d dVar2 = dVar;
                                        anonymousClass5 = new AnonymousClass5(vlessXrayInjector3, dVar2);
                                        this.L$0 = arrayList;
                                        this.L$1 = dVar2;
                                        this.L$2 = dVar2;
                                        this.label = 2;
                                        if (m0.J(iVarPlus, anonymousClass5, this) == aVar) {
                                            return arrayList;
                                        }
                                    }
                                }
                                return aVar;
                            } catch (Throwable th2) {
                                th = th2;
                                vlessXrayInjector2 = vlessXrayInjector5;
                                wd.i iVarPlus3 = m2.f24144a.plus(v0.f24208c);
                                AnonymousClass5 anonymousClass7 = new AnonymousClass5(vlessXrayInjector2, null);
                                this.L$0 = th;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 8;
                                if (m0.J(iVarPlus3, anonymousClass7, this) != aVar) {
                                    throw th;
                                }
                            }
                        case 1:
                            vlessXrayInjector3 = (VlessXrayInjector) this.L$2;
                            list = (List) this.L$1;
                            i0Var = (i0) this.L$0;
                            m.b(obj);
                            objStart = obj;
                            dVar = null;
                            if (((Boolean) objStart).booleanValue()) {
                                List<Ready> list10 = this.$batch;
                                arrayList = new ArrayList(kotlin.collections.s.g0(list10, 10));
                                while (r0.hasNext()) {
                                    arrayList.add(new Trace(false, null, null, 6, null));
                                }
                                iVarPlus = m2.f24144a.plus(v0.f24208c);
                                wd.d dVar3 = dVar;
                                anonymousClass5 = new AnonymousClass5(vlessXrayInjector3, dVar3);
                                this.L$0 = arrayList;
                                this.L$1 = dVar3;
                                this.L$2 = dVar3;
                                this.label = 2;
                                if (m0.J(iVarPlus, anonymousClass5, this) == aVar) {
                                    return arrayList;
                                }
                            } else {
                                argoPool = ArgoPool.INSTANCE;
                                i = 0;
                                iIntValue = ((Number) list.get(0)).intValue();
                                this.L$0 = i0Var;
                                this.L$1 = list;
                                this.L$2 = vlessXrayInjector3;
                                this.label = 3;
                                if (argoPool.waitPort(iIntValue, 5000L, this) != aVar) {
                                    vlessXrayInjector4 = vlessXrayInjector3;
                                    h hVarY2 = r.Y(this.$batch);
                                    arrayList2 = new ArrayList(kotlin.collections.s.g0(hVarY2, 10));
                                    gVarA = hVarY2.iterator();
                                    while (gVarA.f23130c) {
                                        arrayList2.add(m0.c(i0Var, v0.f24208c, new ArgoPool$measureExits$2$out$1$1(list, gVarA.nextInt(), null), 2));
                                    }
                                    this.L$0 = i0Var;
                                    this.L$1 = list;
                                    this.L$2 = vlessXrayInjector4;
                                    this.label = 4;
                                    objD = m0.d(arrayList2, this);
                                    if (objD != aVar) {
                                        i0Var2 = i0Var;
                                        list2 = list;
                                        list3 = (List) objD;
                                        List list11 = list3;
                                        arrayList3 = new ArrayList(kotlin.collections.s.g0(list11, 10));
                                        i10 = i;
                                        while (r0.hasNext()) {
                                            i11 = i10 + 1;
                                            if (i10 >= 0) {
                                                r.f0();
                                                throw null;
                                            }
                                            arrayList3.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$3$1((Trace) obj3, list2, i10, null), 2));
                                            i10 = i11;
                                        }
                                        this.L$0 = i0Var2;
                                        this.L$1 = list2;
                                        this.L$2 = vlessXrayInjector4;
                                        this.L$3 = list3;
                                        this.label = 5;
                                        if (m0.d(arrayList3, this) == aVar) {
                                            list4 = list3;
                                            List<Ready> list12 = this.$batch;
                                            arrayList4 = new ArrayList(kotlin.collections.s.g0(list12, 10));
                                            while (r4.hasNext()) {
                                                i12 = i + 1;
                                                if (i < 0) {
                                                    r.f0();
                                                    throw null;
                                                }
                                                arrayList4.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) obj4, list2, i, null), 2));
                                                i = i12;
                                            }
                                            this.L$0 = vlessXrayInjector4;
                                            this.L$1 = list4;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.label = 6;
                                            if (m0.d(arrayList4, this) != aVar) {
                                                iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                                                anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                                                this.L$0 = list4;
                                                this.L$1 = null;
                                                this.label = 7;
                                                if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                                    return list4;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return aVar;
                        case 2:
                        case 7:
                            List list13 = (List) this.L$0;
                            m.b(obj);
                            return list13;
                        case 3:
                            vlessXrayInjector3 = (VlessXrayInjector) this.L$2;
                            list = (List) this.L$1;
                            i0Var = (i0) this.L$0;
                            m.b(obj);
                            i = 0;
                            vlessXrayInjector4 = vlessXrayInjector3;
                            h hVarY3 = r.Y(this.$batch);
                            arrayList2 = new ArrayList(kotlin.collections.s.g0(hVarY3, 10));
                            gVarA = hVarY3.iterator();
                            while (gVarA.f23130c) {
                                arrayList2.add(m0.c(i0Var, v0.f24208c, new ArgoPool$measureExits$2$out$1$1(list, gVarA.nextInt(), null), 2));
                            }
                            this.L$0 = i0Var;
                            this.L$1 = list;
                            this.L$2 = vlessXrayInjector4;
                            this.label = 4;
                            objD = m0.d(arrayList2, this);
                            if (objD != aVar) {
                                i0Var2 = i0Var;
                                list2 = list;
                                list3 = (List) objD;
                                List list14 = list3;
                                arrayList3 = new ArrayList(kotlin.collections.s.g0(list14, 10));
                                i10 = i;
                                while (r0.hasNext()) {
                                    i11 = i10 + 1;
                                    if (i10 >= 0) {
                                        r.f0();
                                        throw null;
                                    }
                                    arrayList3.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$3$1((Trace) obj3, list2, i10, null), 2));
                                    i10 = i11;
                                }
                                this.L$0 = i0Var2;
                                this.L$1 = list2;
                                this.L$2 = vlessXrayInjector4;
                                this.L$3 = list3;
                                this.label = 5;
                                if (m0.d(arrayList3, this) == aVar) {
                                    list4 = list3;
                                    List<Ready> list15 = this.$batch;
                                    arrayList4 = new ArrayList(kotlin.collections.s.g0(list15, 10));
                                    while (r4.hasNext()) {
                                        i12 = i + 1;
                                        if (i < 0) {
                                            r.f0();
                                            throw null;
                                        }
                                        arrayList4.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) obj4, list2, i, null), 2));
                                        i = i12;
                                    }
                                    this.L$0 = vlessXrayInjector4;
                                    this.L$1 = list4;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.label = 6;
                                    if (m0.d(arrayList4, this) != aVar) {
                                        iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                                        anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                                        this.L$0 = list4;
                                        this.L$1 = null;
                                        this.label = 7;
                                        if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                            return list4;
                                        }
                                    }
                                }
                            }
                            return aVar;
                        case 4:
                            VlessXrayInjector vlessXrayInjector6 = (VlessXrayInjector) this.L$2;
                            list = (List) this.L$1;
                            i0Var = (i0) this.L$0;
                            m.b(obj);
                            objD = obj;
                            vlessXrayInjector4 = vlessXrayInjector6;
                            i = 0;
                            i0Var2 = i0Var;
                            list2 = list;
                            list3 = (List) objD;
                            List list16 = list3;
                            arrayList3 = new ArrayList(kotlin.collections.s.g0(list16, 10));
                            i10 = i;
                            while (r0.hasNext()) {
                                i11 = i10 + 1;
                                if (i10 >= 0) {
                                    r.f0();
                                    throw null;
                                }
                                arrayList3.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$3$1((Trace) obj3, list2, i10, null), 2));
                                i10 = i11;
                            }
                            this.L$0 = i0Var2;
                            this.L$1 = list2;
                            this.L$2 = vlessXrayInjector4;
                            this.L$3 = list3;
                            this.label = 5;
                            if (m0.d(arrayList3, this) == aVar) {
                                list4 = list3;
                                List<Ready> list17 = this.$batch;
                                arrayList4 = new ArrayList(kotlin.collections.s.g0(list17, 10));
                                while (r4.hasNext()) {
                                    i12 = i + 1;
                                    if (i < 0) {
                                        r.f0();
                                        throw null;
                                    }
                                    arrayList4.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) obj4, list2, i, null), 2));
                                    i = i12;
                                }
                                this.L$0 = vlessXrayInjector4;
                                this.L$1 = list4;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 6;
                                if (m0.d(arrayList4, this) != aVar) {
                                    iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                                    anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                                    this.L$0 = list4;
                                    this.L$1 = null;
                                    this.label = 7;
                                    if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                        return list4;
                                    }
                                }
                            }
                            return aVar;
                        case 5:
                            list4 = (List) this.L$3;
                            VlessXrayInjector vlessXrayInjector7 = (VlessXrayInjector) this.L$2;
                            list2 = (List) this.L$1;
                            i0Var2 = (i0) this.L$0;
                            m.b(obj);
                            vlessXrayInjector4 = vlessXrayInjector7;
                            i = 0;
                            List<Ready> list18 = this.$batch;
                            arrayList4 = new ArrayList(kotlin.collections.s.g0(list18, 10));
                            while (r4.hasNext()) {
                                i12 = i + 1;
                                if (i < 0) {
                                    r.f0();
                                    throw null;
                                }
                                arrayList4.add(m0.c(i0Var2, v0.f24208c, new ArgoPool$measureExits$2$4$1((Ready) obj4, list2, i, null), 2));
                                i = i12;
                            }
                            this.L$0 = vlessXrayInjector4;
                            this.L$1 = list4;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 6;
                            if (m0.d(arrayList4, this) != aVar) {
                                iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                                anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                                this.L$0 = list4;
                                this.L$1 = null;
                                this.label = 7;
                                if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                    return list4;
                                }
                            }
                            return aVar;
                        case 6:
                            list4 = (List) this.L$1;
                            vlessXrayInjector4 = (VlessXrayInjector) this.L$0;
                            m.b(obj);
                            iVarPlus2 = m2.f24144a.plus(v0.f24208c);
                            anonymousClass6 = new AnonymousClass5(vlessXrayInjector4, null);
                            this.L$0 = list4;
                            this.L$1 = null;
                            this.label = 7;
                            if (m0.J(iVarPlus2, anonymousClass6, this) != aVar) {
                                return aVar;
                            }
                            return list4;
                        case 8:
                            Throwable th3 = (Throwable) this.L$0;
                            m.b(obj);
                            throw th3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                vlessXrayInjector2 = vlessXrayInjector;
            }
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass2) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$saveSoon$1", f = "ArgoPool.kt", l = {198}, m = "invokeSuspend")
    public static final class C03981 extends xd.j implements ee.e {
        int label;

        public C03981(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C03981(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                m.b(obj);
                this.label = 1;
                if (m0.j(1500L, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
            }
            ArgoPool.saveQueued = false;
            ArgoPool.INSTANCE.saveNow();
            return u.f67154a;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C03981) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03991(int i, boolean z10, List<Item> list, wd.d dVar) {
            super(2, dVar);
            this.$count = i;
            this.$v6 = z10;
            this.$refs = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$2(String str) {
            return o.z0(str, ':');
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C03991 c03991 = new C03991(this.$count, this.$v6, this.$refs, dVar);
            c03991.L$0 = obj;
            return c03991;
        }

        /* JADX WARN: Code duplicated, block: B:103:0x03e6 A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:91:0x03ae, B:93:0x03b2, B:95:0x03bc, B:100:0x03ca, B:101:0x03de, B:103:0x03e6, B:105:0x0410, B:85:0x034a, B:87:0x0356, B:106:0x0422, B:108:0x0435, B:130:0x0498, B:135:0x04aa, B:137:0x04b0, B:139:0x04b6, B:149:0x04d2, B:150:0x04d6, B:144:0x04c3, B:111:0x043f, B:112:0x0443, B:114:0x0449, B:116:0x045f, B:118:0x0467, B:121:0x0471, B:122:0x0475, B:124:0x047b), top: B:188:0x03ae }] */
        /* JADX WARN: Code duplicated, block: B:104:0x040d  */
        /* JADX WARN: Code duplicated, block: B:134:0x04a7  */
        /* JADX WARN: Code duplicated, block: B:148:0x04cf  */
        /* JADX WARN: Code duplicated, block: B:154:0x051c A[Catch: all -> 0x055b, LOOP:0: B:152:0x0516->B:154:0x051c, LOOP_END, TryCatch #2 {all -> 0x055b, blocks: (B:151:0x04d7, B:152:0x0516, B:154:0x051c, B:157:0x055e, B:159:0x0573, B:161:0x057d), top: B:192:0x04d7 }] */
        /* JADX WARN: Code duplicated, block: B:166:0x0598  */
        /* JADX WARN: Code duplicated, block: B:171:0x05a5 A[Catch: all -> 0x05bc, TryCatch #3 {all -> 0x05bc, blocks: (B:168:0x059e, B:169:0x059f, B:171:0x05a5, B:175:0x05bf, B:176:0x05c3, B:177:0x05c4), top: B:194:0x04d6 }] */
        /* JADX WARN: Code duplicated, block: B:174:0x05be  */
        /* JADX WARN: Code duplicated, block: B:192:0x04d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:226:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x0348  */
        /* JADX WARN: Code duplicated, block: B:87:0x0356 A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:91:0x03ae, B:93:0x03b2, B:95:0x03bc, B:100:0x03ca, B:101:0x03de, B:103:0x03e6, B:105:0x0410, B:85:0x034a, B:87:0x0356, B:106:0x0422, B:108:0x0435, B:130:0x0498, B:135:0x04aa, B:137:0x04b0, B:139:0x04b6, B:149:0x04d2, B:150:0x04d6, B:144:0x04c3, B:111:0x043f, B:112:0x0443, B:114:0x0449, B:116:0x045f, B:118:0x0467, B:121:0x0471, B:122:0x0475, B:124:0x047b), top: B:188:0x03ae }] */
        /* JADX WARN: Code duplicated, block: B:90:0x03a5  */
        /* JADX WARN: Code duplicated, block: B:93:0x03b2 A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:91:0x03ae, B:93:0x03b2, B:95:0x03bc, B:100:0x03ca, B:101:0x03de, B:103:0x03e6, B:105:0x0410, B:85:0x034a, B:87:0x0356, B:106:0x0422, B:108:0x0435, B:130:0x0498, B:135:0x04aa, B:137:0x04b0, B:139:0x04b6, B:149:0x04d2, B:150:0x04d6, B:144:0x04c3, B:111:0x043f, B:112:0x0443, B:114:0x0449, B:116:0x045f, B:118:0x0467, B:121:0x0471, B:122:0x0475, B:124:0x047b), top: B:188:0x03ae }] */
        /* JADX WARN: Code duplicated, block: B:95:0x03bc A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:91:0x03ae, B:93:0x03b2, B:95:0x03bc, B:100:0x03ca, B:101:0x03de, B:103:0x03e6, B:105:0x0410, B:85:0x034a, B:87:0x0356, B:106:0x0422, B:108:0x0435, B:130:0x0498, B:135:0x04aa, B:137:0x04b0, B:139:0x04b6, B:149:0x04d2, B:150:0x04d6, B:144:0x04c3, B:111:0x043f, B:112:0x0443, B:114:0x0449, B:116:0x045f, B:118:0x0467, B:121:0x0471, B:122:0x0475, B:124:0x047b), top: B:188:0x03ae }] */
        /* JADX WARN: Code duplicated, block: B:99:0x03c7  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x03a5 -> B:188:0x03ae). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r38) {
            /*
                Method dump skipped, instruction units count: 1526
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.argo.ArgoPool.C03991.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C03991) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00532(VlessXrayInjector vlessXrayInjector, wd.d dVar) {
                super(2, dVar);
                this.$core = vlessXrayInjector;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                C00532 c00532 = new C00532(this.$core, dVar);
                c00532.L$0 = obj;
                return c00532;
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                Object objM1004constructorimpl;
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                try {
                    this.$core.stop();
                    objM1004constructorimpl = sd.l.m1004constructorimpl(u.f67154a);
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
                }
                return sd.l.m1003boximpl(objM1004constructorimpl);
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((C00532) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04002(Item item, ArgoProtocol.SessionInfo sessionInfo, String str, wd.d dVar) {
            super(2, dVar);
            this.$ref = item;
            this.$info = sessionInfo;
            this.$ip = str;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C04002 c04002 = new C04002(this.$ref, this.$info, this.$ip, dVar);
            c04002.L$0 = obj;
            return c04002;
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0128  */
        /* JADX WARN: Code duplicated, block: B:37:0x013f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0140 A[Catch: all -> 0x01f3, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01f3, blocks: (B:32:0x0120, B:38:0x0140, B:27:0x0108, B:29:0x010e, B:63:0x01f6, B:64:0x01fb), top: B:69:0x0108 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0156  */
        /* JADX WARN: Code duplicated, block: B:44:0x019a  */
        /* JADX WARN: Code duplicated, block: B:52:0x01c5  */
        /* JADX WARN: Code duplicated, block: B:56:0x01db  */
        /* JADX WARN: Code duplicated, block: B:60:0x01f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
        @Override // xd.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i0 i0Var;
            int iFreePort;
            ArgoProtocol.Endpoint endpointEndpointOf;
            VlessXrayInjector vlessXrayInjector;
            VlessXrayInjector vlessXrayInjector2;
            Object objStart;
            ArgoPool argoPool;
            int i;
            ArgoProtocol.Endpoint endpoint;
            m2 m2Var;
            C00532 c00532;
            m2 m2Var2;
            C00532 c00533;
            int iIntValue;
            double dNanoTime;
            Long l6;
            m2 m2Var3;
            C00532 c00534;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                m.b(obj);
                i0Var = (i0) this.L$0;
                ArgoPool argoPool2 = ArgoPool.INSTANCE;
                iFreePort = argoPool2.freePort();
                endpointEndpointOf = argoPool2.endpointOf(this.$ref);
                sf.c cVar = new sf.c();
                sf.c cVar2 = new sf.c();
                cVar2.D("loglevel", "none");
                cVar.D(XrayCoreHostService.KEY_LOG, cVar2);
                sf.a aVar2 = new sf.a();
                sf.c cVarP = i.p("tag", "in", "listen", SniSession.LOCAL_HOST);
                cVarP.D(PsiphonProbeService.PORT, Integer.valueOf(iFreePort));
                cVarP.D("protocol", "socks");
                sf.c cVar3 = new sf.c();
                cVar3.E("udp", false);
                cVarP.D("settings", cVar3);
                aVar2.put(cVarP);
                cVar.D("inbounds", aVar2);
                sf.a aVar3 = new sf.a();
                aVar3.put(ArgoProtocol.xrayOutbound$default(ArgoProtocol.INSTANCE, endpointEndpointOf, this.$info, "out", this.$ip, null, 16, null));
                cVar.D("outbounds", aVar3);
                String string = cVar.toString();
                j.d(string, "toString(...)");
                vlessXrayInjector = new VlessXrayInjector(0, null, true, 2, null);
                try {
                    Context context = ArgoPool.app;
                    if (context == null) {
                        j.k("app");
                        throw null;
                    }
                    this.L$0 = i0Var;
                    this.L$1 = endpointEndpointOf;
                    this.L$2 = vlessXrayInjector;
                    this.I$0 = iFreePort;
                    this.label = 1;
                    objStart = vlessXrayInjector.start(context, string, 0, this);
                    if (objStart != aVar) {
                        if (((Boolean) objStart).booleanValue()) {
                            argoPool = ArgoPool.INSTANCE;
                            this.L$0 = i0Var;
                            this.L$1 = endpointEndpointOf;
                            this.L$2 = vlessXrayInjector;
                            this.I$0 = iFreePort;
                            this.label = 3;
                            if (argoPool.waitPort(iFreePort, 5000L, this) != aVar) {
                                i = iFreePort;
                                endpoint = endpointEndpointOf;
                                vlessXrayInjector2 = vlessXrayInjector;
                                long jNanoTime = System.nanoTime();
                                ArgoPool argoPool3 = ArgoPool.INSTANCE;
                                sd.j jVarDownload = argoPool3.download(i, ArgoPool.CARRY_URL, 1048576L, GerehWatchdog.STUCK_MS, false);
                                int i11 = i;
                                iIntValue = ((Number) jVarDownload.component1()).intValue();
                                long jLongValue = ((Number) jVarDownload.component2()).longValue();
                                dNanoTime = (System.nanoTime() - jNanoTime) / 1.0E9d;
                                if (dNanoTime < 0.001d) {
                                    dNanoTime = 0.001d;
                                }
                                sd.l.m1004constructorimpl(ArgoNet.INSTANCE.sessionRequest("disconnect", endpoint.getHost(), endpoint.getPort(), this.$info, argoPool3.socks(i11), 6000L));
                                if (iIntValue == 200) {
                                    l6 = null;
                                } else {
                                    l6 = null;
                                }
                                m2Var3 = m2.f24144a;
                                c00534 = new C00532(vlessXrayInjector2, null);
                                this.L$0 = l6;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (m0.J(m2Var3, c00534, this) != aVar) {
                                    return l6;
                                }
                            }
                        } else {
                            m2Var = m2.f24144a;
                            c00532 = new C00532(vlessXrayInjector, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 2;
                            if (m0.J(m2Var, c00532, this) == aVar) {
                                return null;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    vlessXrayInjector2 = vlessXrayInjector;
                    m2Var2 = m2.f24144a;
                    c00533 = new C00532(vlessXrayInjector2, null);
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (m0.J(m2Var2, c00533, this) != aVar) {
                        throw th;
                    }
                }
            } else if (i10 == 1) {
                int i12 = this.I$0;
                VlessXrayInjector vlessXrayInjector3 = (VlessXrayInjector) this.L$2;
                ArgoProtocol.Endpoint endpoint2 = (ArgoProtocol.Endpoint) this.L$1;
                i0Var = (i0) this.L$0;
                try {
                    m.b(obj);
                    vlessXrayInjector = vlessXrayInjector3;
                    endpointEndpointOf = endpoint2;
                    iFreePort = i12;
                    objStart = obj;
                    if (((Boolean) objStart).booleanValue()) {
                        m2Var = m2.f24144a;
                        c00532 = new C00532(vlessXrayInjector, null);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 2;
                        if (m0.J(m2Var, c00532, this) == aVar) {
                            return null;
                        }
                    } else {
                        argoPool = ArgoPool.INSTANCE;
                        this.L$0 = i0Var;
                        this.L$1 = endpointEndpointOf;
                        this.L$2 = vlessXrayInjector;
                        this.I$0 = iFreePort;
                        this.label = 3;
                        if (argoPool.waitPort(iFreePort, 5000L, this) != aVar) {
                            i = iFreePort;
                            endpoint = endpointEndpointOf;
                            vlessXrayInjector2 = vlessXrayInjector;
                            long jNanoTime2 = System.nanoTime();
                            ArgoPool argoPool4 = ArgoPool.INSTANCE;
                            sd.j jVarDownload2 = argoPool4.download(i, ArgoPool.CARRY_URL, 1048576L, GerehWatchdog.STUCK_MS, false);
                            int i13 = i;
                            iIntValue = ((Number) jVarDownload2.component1()).intValue();
                            long jLongValue2 = ((Number) jVarDownload2.component2()).longValue();
                            dNanoTime = (System.nanoTime() - jNanoTime2) / 1.0E9d;
                            if (dNanoTime < 0.001d) {
                                dNanoTime = 0.001d;
                            }
                            sd.l.m1004constructorimpl(ArgoNet.INSTANCE.sessionRequest("disconnect", endpoint.getHost(), endpoint.getPort(), this.$info, argoPool4.socks(i13), 6000L));
                            if (iIntValue == 200) {
                                l6 = null;
                            } else {
                                l6 = null;
                            }
                            m2Var3 = m2.f24144a;
                            c00534 = new C00532(vlessXrayInjector2, null);
                            this.L$0 = l6;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 4;
                            if (m0.J(m2Var3, c00534, this) != aVar) {
                                return l6;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    vlessXrayInjector2 = vlessXrayInjector3;
                    m2Var2 = m2.f24144a;
                    c00533 = new C00532(vlessXrayInjector2, null);
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (m0.J(m2Var2, c00533, this) != aVar) {
                        throw th;
                    }
                }
            } else {
                if (i10 == 2) {
                    m.b(obj);
                    return null;
                }
                if (i10 != 3) {
                    if (i10 == 4) {
                        Long l10 = (Long) this.L$0;
                        m.b(obj);
                        return l10;
                    }
                    if (i10 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th4 = (Throwable) this.L$0;
                    m.b(obj);
                    throw th4;
                }
                int i14 = this.I$0;
                vlessXrayInjector2 = (VlessXrayInjector) this.L$2;
                endpoint = (ArgoProtocol.Endpoint) this.L$1;
                try {
                    m.b(obj);
                    i = i14;
                    long jNanoTime3 = System.nanoTime();
                    ArgoPool argoPool5 = ArgoPool.INSTANCE;
                    sd.j jVarDownload3 = argoPool5.download(i, ArgoPool.CARRY_URL, 1048576L, GerehWatchdog.STUCK_MS, false);
                    int i15 = i;
                    iIntValue = ((Number) jVarDownload3.component1()).intValue();
                    long jLongValue3 = ((Number) jVarDownload3.component2()).longValue();
                    dNanoTime = (System.nanoTime() - jNanoTime3) / 1.0E9d;
                    if (dNanoTime < 0.001d) {
                        dNanoTime = 0.001d;
                    }
                    try {
                        sd.l.m1004constructorimpl(ArgoNet.INSTANCE.sessionRequest("disconnect", endpoint.getHost(), endpoint.getPort(), this.$info, argoPool5.socks(i15), 6000L));
                    } catch (Throwable th5) {
                        sd.l.m1004constructorimpl(m.a(th5));
                    }
                    if (iIntValue == 200 || jLongValue3 < 500000) {
                        l6 = null;
                    } else {
                        l6 = new Long(Math.round((jLongValue3 / 1024.0d) / dNanoTime));
                    }
                    m2Var3 = m2.f24144a;
                    c00534 = new C00532(vlessXrayInjector2, null);
                    this.L$0 = l6;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (m0.J(m2Var3, c00534, this) != aVar) {
                        return l6;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    m2Var2 = m2.f24144a;
                    c00533 = new C00532(vlessXrayInjector2, null);
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (m0.J(m2Var2, c00533, this) != aVar) {
                        throw th;
                    }
                }
            }
            return aVar;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C04002) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C04011(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.this.telegramPageRetry(null, null, null, null, this);
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
            final /* synthetic */ w $alive;
            final /* synthetic */ kotlinx.coroutines.sync.a $chain;
            final /* synthetic */ String $connectIp;
            final /* synthetic */ w $done;
            final /* synthetic */ w $frozen;
            final /* synthetic */ List<Item> $list;
            final /* synthetic */ AtomicInteger $next;
            final /* synthetic */ List<Ready> $ready;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00541(List<Item> list, AtomicInteger atomicInteger, String str, List<Ready> list2, w wVar, w wVar2, w wVar3, kotlinx.coroutines.sync.a aVar, i0 i0Var, wd.d dVar) {
                super(2, dVar);
                this.$list = list;
                this.$next = atomicInteger;
                this.$connectIp = str;
                this.$ready = list2;
                this.$done = wVar;
                this.$alive = wVar2;
                this.$frozen = wVar3;
                this.$chain = aVar;
                this.$$this$launch = i0Var;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                C00541 c00541 = new C00541(this.$list, this.$next, this.$connectIp, this.$ready, this.$done, this.$alive, this.$frozen, this.$chain, this.$$this$launch, dVar);
                c00541.L$0 = obj;
                return c00541;
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                i0 i0Var = (i0) this.L$0;
                List<Item> list = this.$list;
                AtomicInteger atomicInteger = this.$next;
                String str = this.$connectIp;
                List<Ready> list2 = this.$ready;
                w wVar = this.$done;
                w wVar2 = this.$alive;
                w wVar3 = this.$frozen;
                kotlinx.coroutines.sync.a aVar2 = this.$chain;
                i0 i0Var2 = this.$$this$launch;
                for (int i = 0; i < 8; i++) {
                    m0.y(i0Var, null, null, new ArgoPool$test$1$1$1$1(list, atomicInteger, str, list2, wVar, wVar2, wVar3, aVar2, i0Var2, null), 3);
                }
                return u.f67154a;
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((C00541) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04021(List<Item> list, String str, wd.d dVar) {
            super(2, dVar);
            this.$list = list;
            this.$connectIp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:48:0x0109  */
        /* JADX WARN: Code duplicated, block: B:52:0x0118 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0120 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x012a A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0199 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:69:0x019f A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:71:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:73:0x01e7 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:46:0x0101, B:49:0x010a, B:50:0x0112, B:52:0x0118, B:54:0x0120, B:56:0x012a, B:59:0x0144, B:61:0x014a, B:63:0x0150, B:66:0x016a, B:67:0x0199, B:69:0x019f, B:72:0x01b9, B:73:0x01e7, B:75:0x0222, B:76:0x0225, B:79:0x0229, B:25:0x00a3, B:26:0x00a6, B:33:0x00c6, B:34:0x00c7, B:82:0x0231, B:83:0x0232, B:27:0x00a7, B:29:0x00bd), top: B:86:0x00a3, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        /* JADX WARN: Code duplicated, block: B:96:0x0222 A[SYNTHETIC] */
        public static final Object invokeSuspend$flush(kotlinx.coroutines.sync.a aVar, List<Ready> list, i0 i0Var, String str, w wVar, w wVar2, w wVar3, wd.d dVar) throws Throwable {
            ArgoPool$test$1$flush$1 argoPool$test$1$flush$1;
            w wVar4;
            w wVar5;
            String str2;
            w wVar6;
            List<Ready> list2;
            kotlinx.coroutines.sync.a aVar2;
            kotlinx.coroutines.sync.a aVar3;
            List listK1;
            w wVar7;
            w wVar8;
            List list3;
            kotlinx.coroutines.sync.a aVar4;
            kotlinx.coroutines.sync.a aVar5;
            Object objM1004constructorimpl;
            kotlinx.coroutines.sync.a aVar6;
            kotlin.collections.w wVar9;
            List list4;
            int i;
            Ready ready;
            Trace trace;
            String loc;
            if (dVar instanceof ArgoPool$test$1$flush$1) {
                argoPool$test$1$flush$1 = (ArgoPool$test$1$flush$1) dVar;
                int i10 = argoPool$test$1$flush$1.label;
                if ((i10 & TLObject.FLAG_31) != 0) {
                    argoPool$test$1$flush$1.label = i10 - TLObject.FLAG_31;
                } else {
                    argoPool$test$1$flush$1 = new ArgoPool$test$1$flush$1(dVar);
                }
            } else {
                argoPool$test$1$flush$1 = new ArgoPool$test$1$flush$1(dVar);
            }
            Object obj = argoPool$test$1$flush$1.result;
            kotlin.coroutines.intrinsics.a aVar7 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i11 = argoPool$test$1$flush$1.label;
            int i12 = 0;
            try {
                if (i11 == 0) {
                    m.b(obj);
                    argoPool$test$1$flush$1.L$0 = list;
                    argoPool$test$1$flush$1.L$1 = i0Var;
                    argoPool$test$1$flush$1.L$2 = str;
                    wVar4 = wVar;
                    argoPool$test$1$flush$1.L$3 = wVar4;
                    argoPool$test$1$flush$1.L$4 = wVar2;
                    argoPool$test$1$flush$1.L$5 = wVar3;
                    argoPool$test$1$flush$1.L$6 = aVar;
                    argoPool$test$1$flush$1.label = 1;
                    kotlinx.coroutines.sync.f fVar = (kotlinx.coroutines.sync.f) aVar;
                    if (fVar.d(argoPool$test$1$flush$1) != aVar7) {
                        wVar5 = wVar2;
                        str2 = str;
                        wVar6 = wVar3;
                        list2 = list;
                        aVar2 = fVar;
                    }
                    return aVar7;
                }
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list3 = (List) argoPool$test$1$flush$1.L$4;
                    aVar4 = (kotlinx.coroutines.sync.a) argoPool$test$1$flush$1.L$3;
                    wVar7 = (w) argoPool$test$1$flush$1.L$2;
                    wVar5 = (w) argoPool$test$1$flush$1.L$1;
                    wVar8 = (w) argoPool$test$1$flush$1.L$0;
                    try {
                        m.b(obj);
                        aVar4 = aVar4;
                        objM1004constructorimpl = sd.l.m1004constructorimpl((List) obj);
                        aVar6 = aVar4;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th));
                            aVar6 = aVar4;
                        } catch (Throwable th3) {
                            th = th3;
                            aVar5 = aVar4;
                            ((kotlinx.coroutines.sync.f) aVar5).f(null);
                            throw th;
                        }
                    }
                    aVar3 = aVar6;
                    wVar9 = kotlin.collections.w.INSTANCE;
                    if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                        objM1004constructorimpl = wVar9;
                    }
                    list4 = (List) objM1004constructorimpl;
                    for (Object obj2 : list3) {
                        i = i12 + 1;
                        if (i12 >= 0) {
                            r.f0();
                            throw null;
                        }
                        ready = (Ready) obj2;
                        trace = (Trace) q.B0(i12, list4);
                        if (trace == null) {
                            trace = new Trace(false, null, null, 6, null);
                        }
                        if (!trace.getOk() && trace.getCarried()) {
                            ArgoPool argoPool = ArgoPool.INSTANCE;
                            String id2 = ready.getX().getId();
                            long ms = ready.getMs();
                            String loc2 = trace.getLoc();
                            if (o.L0(loc2)) {
                                loc2 = "??";
                            }
                            ArgoPool.record$default(argoPool, id2, true, ms, loc2, trace.getIp(), null, false, null, 224, null);
                            invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 1, 0, 32, null);
                        } else if (trace.getOk()) {
                            ArgoPool argoPool2 = ArgoPool.INSTANCE;
                            String id3 = ready.getX().getId();
                            long ms2 = ready.getMs();
                            loc = trace.getLoc();
                            if (o.L0(loc)) {
                                loc = "??";
                            }
                            ArgoPool.record$default(argoPool2, id3, false, ms2, loc, trace.getIp(), "جواب داد ولی وسط دانلود قطع شد — «آی\u200cپی تمیز» را امتحان کنید", true, null, 128, null);
                            invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 1, 16, null);
                        } else {
                            ArgoPool.record$default(ArgoPool.INSTANCE, ready.getX().getId(), false, ready.getMs(), null, null, "احراز هویت شد ولی داده\u200cای از داخلش رد نشد", false, null, 216, null);
                            invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 0, 48, null);
                        }
                        i12 = i;
                    }
                    u uVar = u.f67154a;
                    ((kotlinx.coroutines.sync.f) aVar3).f(null);
                    return uVar;
                }
                kotlinx.coroutines.sync.a aVar8 = (kotlinx.coroutines.sync.a) argoPool$test$1$flush$1.L$6;
                wVar6 = (w) argoPool$test$1$flush$1.L$5;
                wVar5 = (w) argoPool$test$1$flush$1.L$4;
                wVar4 = (w) argoPool$test$1$flush$1.L$3;
                str2 = (String) argoPool$test$1$flush$1.L$2;
                list2 = (List) argoPool$test$1$flush$1.L$0;
                m.b(obj);
                aVar2 = aVar8;
                j.b(list2);
                synchronized (list2) {
                    listK1 = q.k1(q.e1(list2, 12));
                    int size = listK1.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        list2.remove(0);
                    }
                }
                if (!listK1.isEmpty()) {
                    try {
                        ArgoPool argoPool3 = ArgoPool.INSTANCE;
                        argoPool$test$1$flush$1.L$0 = wVar4;
                        argoPool$test$1$flush$1.L$1 = wVar5;
                        argoPool$test$1$flush$1.L$2 = wVar6;
                        argoPool$test$1$flush$1.L$3 = aVar3;
                        argoPool$test$1$flush$1.L$4 = listK1;
                        argoPool$test$1$flush$1.L$5 = null;
                        argoPool$test$1$flush$1.L$6 = null;
                        argoPool$test$1$flush$1.label = 2;
                        Object objMeasureExits = argoPool3.measureExits(listK1, str2, argoPool$test$1$flush$1);
                        if (objMeasureExits != aVar7) {
                            wVar7 = wVar6;
                            wVar8 = wVar4;
                            list3 = listK1;
                            aVar4 = aVar3;
                            obj = objMeasureExits;
                            objM1004constructorimpl = sd.l.m1004constructorimpl((List) obj);
                            aVar6 = aVar4;
                            aVar3 = aVar6;
                            wVar9 = kotlin.collections.w.INSTANCE;
                            if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                                objM1004constructorimpl = wVar9;
                            }
                            list4 = (List) objM1004constructorimpl;
                            while (r3.hasNext()) {
                                i = i12 + 1;
                                if (i12 >= 0) {
                                    r.f0();
                                    throw null;
                                }
                                ready = (Ready) obj2;
                                trace = (Trace) q.B0(i12, list4);
                                if (trace == null) {
                                    trace = new Trace(false, null, null, 6, null);
                                }
                                if (!trace.getOk()) {
                                    if (trace.getOk()) {
                                        ArgoPool argoPool4 = ArgoPool.INSTANCE;
                                        String id4 = ready.getX().getId();
                                        long ms3 = ready.getMs();
                                        loc = trace.getLoc();
                                        if (o.L0(loc)) {
                                            loc = "??";
                                        }
                                        ArgoPool.record$default(argoPool4, id4, false, ms3, loc, trace.getIp(), "جواب داد ولی وسط دانلود قطع شد — «آی\u200cپی تمیز» را امتحان کنید", true, null, 128, null);
                                        invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 1, 16, null);
                                    } else {
                                        ArgoPool.record$default(ArgoPool.INSTANCE, ready.getX().getId(), false, ready.getMs(), null, null, "احراز هویت شد ولی داده\u200cای از داخلش رد نشد", false, null, 216, null);
                                        invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 0, 48, null);
                                    }
                                } else if (trace.getOk()) {
                                    ArgoPool argoPool5 = ArgoPool.INSTANCE;
                                    String id5 = ready.getX().getId();
                                    long ms4 = ready.getMs();
                                    loc = trace.getLoc();
                                    if (o.L0(loc)) {
                                        loc = "??";
                                    }
                                    ArgoPool.record$default(argoPool5, id5, false, ms4, loc, trace.getIp(), "جواب داد ولی وسط دانلود قطع شد — «آی\u200cپی تمیز» را امتحان کنید", true, null, 128, null);
                                    invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 1, 16, null);
                                } else {
                                    ArgoPool.record$default(ArgoPool.INSTANCE, ready.getX().getId(), false, ready.getMs(), null, null, "احراز هویت شد ولی داده\u200cای از داخلش رد نشد", false, null, 216, null);
                                    invokeSuspend$tally$default(wVar8, wVar5, wVar7, 1, 0, 0, 48, null);
                                }
                                i12 = i;
                            }
                        }
                        return aVar7;
                    } catch (Throwable th4) {
                        th = th4;
                        wVar7 = wVar6;
                        wVar8 = wVar4;
                        list3 = listK1;
                        aVar4 = aVar3;
                        objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th));
                        aVar6 = aVar4;
                    }
                }
                u uVar2 = u.f67154a;
                ((kotlinx.coroutines.sync.f) aVar3).f(null);
                return uVar2;
            } catch (Throwable th5) {
                th = th5;
                aVar5 = aVar3;
                ((kotlinx.coroutines.sync.f) aVar5).f(null);
                throw th;
            }
            aVar3 = aVar2;
        }

        private static final void invokeSuspend$tally(w wVar, w wVar2, w wVar3, int i, int i10, int i11) {
            ArgoPool argoPool = ArgoPool.INSTANCE;
            synchronized (argoPool) {
                try {
                    wVar.element += i;
                    wVar2.element += i10;
                    wVar3.element += i11;
                    Job testJob = argoPool.getTestJob();
                    ArgoPool.testJob = testJob != null ? Job.copy$default(testJob, false, wVar.element, 0, wVar2.element, wVar3.element, null, 0, null, null, 0L, null, null, null, 8165, null) : null;
                    argoPool.changed();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public static /* synthetic */ void invokeSuspend$tally$default(w wVar, w wVar2, w wVar3, int i, int i10, int i11, int i12, Object obj) {
            if ((i12 & 16) != 0) {
                i10 = 0;
            }
            if ((i12 & 32) != 0) {
                i11 = 0;
            }
            invokeSuspend$tally(wVar, wVar2, wVar3, i, i10, i11);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C04021 c04021 = new C04021(this.$list, this.$connectIp, dVar);
            c04021.L$0 = obj;
            return c04021;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:21:0x00da  */
        /* JADX WARN: Code duplicated, block: B:23:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:24:0x00fb  */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00d4, code lost:
        
            if (invokeSuspend$flush(r0, r1, r2, r3, r4, r5, r6, r7) == r8) goto L19;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00d4 -> B:20:0x00d7). Please report as a decompilation issue!!! */
        @Override // xd.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            w wVar;
            kotlinx.coroutines.sync.a aVar;
            i0 i0Var;
            w wVar2;
            List list;
            w wVar3;
            w wVar4;
            List list2;
            w wVar5;
            i0 i0Var2;
            w wVar6;
            kotlinx.coroutines.sync.a aVar2;
            Job testJob;
            Job jobCopy$default;
            C04021 c04021 = this;
            kotlin.coroutines.intrinsics.a aVar3 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = c04021.label;
            if (i == 0) {
                m.b(obj);
                i0 i0Var3 = (i0) c04021.L$0;
                AtomicInteger atomicInteger = new AtomicInteger(0);
                List listSynchronizedList = Collections.synchronizedList(new ArrayList());
                kotlinx.coroutines.sync.f fVar = new kotlinx.coroutines.sync.f();
                w wVar7 = new w();
                w wVar8 = new w();
                w wVar9 = new w();
                C00541 c00541 = new C00541(c04021.$list, atomicInteger, c04021.$connectIp, listSynchronizedList, wVar7, wVar8, wVar9, fVar, i0Var3, null);
                wVar = wVar9;
                aVar = fVar;
                i0Var = i0Var3;
                c04021.L$0 = i0Var;
                c04021.L$1 = listSynchronizedList;
                c04021.L$2 = aVar;
                c04021.L$3 = wVar7;
                c04021.L$4 = wVar8;
                c04021.L$5 = wVar;
                c04021.label = 1;
                if (m0.i(c00541, c04021) != aVar3) {
                    wVar2 = wVar8;
                    list = listSynchronizedList;
                    wVar3 = wVar7;
                }
                return aVar3;
            }
            if (i == 1) {
                wVar = (w) c04021.L$5;
                wVar2 = (w) c04021.L$4;
                wVar3 = (w) c04021.L$3;
                aVar = (kotlinx.coroutines.sync.a) c04021.L$2;
                list = (List) c04021.L$1;
                i0Var = (i0) c04021.L$0;
                m.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                w wVar10 = (w) c04021.L$5;
                w wVar11 = (w) c04021.L$4;
                w wVar12 = (w) c04021.L$3;
                kotlinx.coroutines.sync.a aVar4 = (kotlinx.coroutines.sync.a) c04021.L$2;
                List list3 = (List) c04021.L$1;
                i0 i0Var4 = (i0) c04021.L$0;
                m.b(obj);
                wVar4 = wVar11;
                list2 = list3;
                wVar5 = wVar12;
                i0Var2 = i0Var4;
                wVar6 = wVar10;
                aVar2 = aVar4;
            }
            c04021 = this;
            j.b(list2);
            if (!list2.isEmpty()) {
                ArgoPool argoPool = ArgoPool.INSTANCE;
                testJob = argoPool.getTestJob();
                if (testJob != null) {
                    jobCopy$default = Job.copy$default(testJob, false, 0, 0, 0, 0, null, 0, null, null, System.currentTimeMillis(), null, null, null, 7678, null);
                } else {
                    jobCopy$default = null;
                }
                ArgoPool.testJob = jobCopy$default;
                argoPool.saveNow();
                return u.f67154a;
            }
            String str = c04021.$connectIp;
            c04021.L$0 = i0Var2;
            c04021.L$1 = list2;
            c04021.L$2 = aVar2;
            c04021.L$3 = wVar5;
            c04021.L$4 = wVar4;
            c04021.L$5 = wVar6;
            c04021.label = 2;
            i0 i0Var5 = i0Var;
            wVar4 = wVar2;
            list2 = list;
            wVar5 = wVar3;
            i0Var2 = i0Var5;
            wVar6 = wVar;
            aVar2 = aVar;
            j.b(list2);
            if (!list2.isEmpty()) {
                ArgoPool argoPool2 = ArgoPool.INSTANCE;
                testJob = argoPool2.getTestJob();
                if (testJob != null) {
                    jobCopy$default = Job.copy$default(testJob, false, 0, 0, 0, 0, null, 0, null, null, System.currentTimeMillis(), null, null, null, 7678, null);
                } else {
                    jobCopy$default = null;
                }
                ArgoPool.testJob = jobCopy$default;
                argoPool2.saveNow();
                return u.f67154a;
            }
            String str2 = c04021.$connectIp;
            c04021.L$0 = i0Var2;
            c04021.L$1 = list2;
            c04021.L$2 = aVar2;
            c04021.L$3 = wVar5;
            c04021.L$4 = wVar4;
            c04021.L$5 = wVar6;
            c04021.label = 2;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C04021) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04031(List<Source> list, ArgoNet.Route route, wd.d dVar) {
            super(2, dVar);
            this.$list = list;
            this.$route = route;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final u invokeSuspend$lambda$2(Source source, int i, int i10) {
            Job jobCopy$default;
            ArgoPool argoPool = ArgoPool.INSTANCE;
            Job updateJob = argoPool.getUpdateJob();
            if (updateJob != null) {
                jobCopy$default = Job.copy$default(updateJob, false, 0, 0, 0, 0, source.getLabel() + " — صفحهٔ " + i + "، " + i10 + " مورد تازه", 0, null, null, 0L, null, null, null, 8159, null);
            } else {
                jobCopy$default = null;
            }
            ArgoPool.updateJob = jobCopy$default;
            argoPool.changed();
            return u.f67154a;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C04031(this.$list, this.$route, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x0058  */
        /* JADX WARN: Code duplicated, block: B:19:0x0060  */
        /* JADX WARN: Code duplicated, block: B:20:0x0085  */
        /* JADX WARN: Code duplicated, block: B:25:0x009b A[Catch: all -> 0x00a4, TryCatch #1 {all -> 0x00a4, blocks: (B:23:0x008d, B:25:0x009b, B:28:0x00a7), top: B:72:0x008d }] */
        /* JADX WARN: Code duplicated, block: B:32:0x00be A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00b2, B:32:0x00be, B:37:0x00d1, B:45:0x0108, B:47:0x0110, B:49:0x0123), top: B:70:0x00b2 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:36:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:39:0x00f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:45:0x0108 A[Catch: all -> 0x0100, TRY_ENTER, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00b2, B:32:0x00be, B:37:0x00d1, B:45:0x0108, B:47:0x0110, B:49:0x0123), top: B:70:0x00b2 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x0110 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00b2, B:32:0x00be, B:37:0x00d1, B:45:0x0108, B:47:0x0110, B:49:0x0123), top: B:70:0x00b2 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0123 A[Catch: all -> 0x0100, TRY_LEAVE, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00b2, B:32:0x00be, B:37:0x00d1, B:45:0x0108, B:47:0x0110, B:49:0x0123), top: B:70:0x00b2 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x017b  */
        /* JADX WARN: Code duplicated, block: B:61:0x019a  */
        /* JADX WARN: Code duplicated, block: B:72:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f3 -> B:41:0x00f9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r33) {
            /*
                Method dump skipped, instruction units count: 474
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.argo.ArgoPool.C04031.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C04031) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C04041(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return ArgoPool.this.waitPort(0, 0L, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        ArgoPool argoPool = new ArgoPool();
        INSTANCE = argoPool;
        String property = System.getProperty("http.agent");
        String str = null;
        if (property == null) {
            property = "Mozilla/5.0 (Linux; Android)";
        } else {
            if (o.L0(property) || o.y0(property, "okhttp", true)) {
                property = null;
            }
            if (property == null) {
                property = "Mozilla/5.0 (Linux; Android)";
            }
        }
        CARRY_UA = property;
        scope = m0.a(g8.a.D(v0.f24208c, m0.b()));
        random = new SecureRandom();
        items = new LinkedHashMap<>();
        results = new HashMap<>();
        userSources = new ArrayList();
        sourceState = new HashMap<>();
        prefs = new Prefs(str, false, 3, null == true ? 1 : 0);
        falconServers = kotlin.collections.w.INSTANCE;
        g1 g1VarB = kotlinx.coroutines.flow.h.b(0L);
        _version = g1VarB;
        version = g1VarB;
        BUILTIN = r.a0(argoPool.tg("argooo_vpn"), argoPool.tg("ARGO_VPNN"), argoPool.tg("falconchi"), argoPool.tg("argo_falcon"), argoPool.tg("falcon_argo"), argoPool.tg("argovpn_falcon"), argoPool.tg("argo_bridge"), argoPool.tg("ArgoVPNs"), argoPool.tg("vvpnfc"), argoPool.tg("falconsazi"), argoPool.tg("pol_argo"), new Source("gh:bannedbook-ssvpn", XrayMeasureService.KEY_URL, m9.d.B("https://github.com/bannedbook/ssvpn/issues"), "گیت\u200cهاب — ایشوهای bannedbook/ssvpn", true, false, 0L, 96, null), new Source("argo:config", "snowcfg", r.a0("https://s3.amazonaws.com/argovpn/browse/data6.br", "https://raw.githubusercontent.com/legend-wizard/browse/refs/heads/main/data6.br", "https://akeptumbesnow.com/repo6"), "فهرست رسمی سرورهای عمومی آرگو", true, false, 0L, 96, null), new Source("argo:falcon", "falcon-servers", m9.d.B("https://raw.githubusercontent.com/ArgoConfBot/ARG/master/lib.br"), "فهرست رسمی سرورهای فالکن (برای ساخت فالکن شخصی)", true, false, 0L, 96, null));
        CF_V4 = r.a0("173.245.48.0/20", "103.21.244.0/22", "103.22.200.0/22", "103.31.4.0/22", "141.101.64.0/18", "108.162.192.0/18", "190.93.240.0/20", "188.114.96.0/20", "197.234.240.0/22", "198.41.128.0/17", "162.158.0.0/15", "104.16.0.0/13", "104.24.0.0/14", "172.64.0.0/13", "131.0.72.0/22");
        CF_V6 = r.a0("2606:4700:3030", "2606:4700:3031", "2606:4700:3032", "2606:4700:3033", "2606:4700:3034", "2606:4700:3035", "2606:4700:3036", "2606:4700:3037", "2606:4700:10", "2606:4700:20", "2606:4700:7", "2606:4700:4400", "2803:f800:50", "2a06:98c1:3120", "2a06:98c1:3121", "2400:cb00:2049");
        IPV4_LITERAL = new l("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$");
        $stable = 8;
    }

    private ArgoPool() {
    }

    public final Absorbed absorbText(String str, String str2, long j, boolean z10, boolean z11) {
        Iterator<String> it = ArgoProtocol.INSTANCE.extractBridgeBlocks(str).iterator();
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            try {
                ArgoProtocol.Bridge bridgeDecodeBridgeBlock = ArgoProtocol.INSTANCE.decodeBridgeBlock(it.next());
                if (!bridgeDecodeBridgeBlock.getSigOk()) {
                    i11++;
                } else if (addItem$default(this, "bridge", bridgeDecodeBridgeBlock.getHost(), bridgeDecodeBridgeBlock.getPort(), bridgeDecodeBridgeBlock.getProtocol(), str2, j, z11, null, 128, null)) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        Iterator<String> it2 = ArgoProtocol.INSTANCE.extractFalconHosts(new l("-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+", kotlin.text.m.IGNORE_CASE).replace(str, ""), z10).iterator();
        while (it2.hasNext()) {
            if (addItem$default(this, "falcon", it2.next(), ProtonStealth.PORT, "A", str2, j, z11, null, 128, null)) {
                i++;
            }
        }
        return new Absorbed(i10, i, i11);
    }

    public static /* synthetic */ Absorbed absorbText$default(ArgoPool argoPool, String str, String str2, long j, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 8) != 0) {
            z10 = false;
        }
        if ((i & 16) != 0) {
            z11 = false;
        }
        return argoPool.absorbText(str, str2, j, z10, z11);
    }

    public static final /* synthetic */ boolean access$getUpdateCancel$p() {
        return updateCancel;
    }

    private final synchronized boolean addItem(String str, String str2, int i, String str3, String str4, long j, boolean z10, String str5) {
        int i10 = i;
        long jCurrentTimeMillis = j;
        synchronized (this) {
            try {
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                j.d(lowerCase, "toLowerCase(...)");
                String strQ1 = o.q1(lowerCase, '.');
                if (!ArgoProtocol.INSTANCE.looksLikeHost(strQ1)) {
                    return false;
                }
                if (1 > i10 || i10 >= 65536) {
                    i10 = ProtonStealth.PORT;
                }
                int i11 = i10;
                String strIdOf = idOf(str, strQ1, i11);
                LinkedHashMap<String, Item> linkedHashMap = items;
                Item item = linkedHashMap.get(strIdOf);
                if (item != null) {
                    if (jCurrentTimeMillis > item.getSeen()) {
                        item.setSeen(jCurrentTimeMillis);
                    }
                    if (z10) {
                        item.setUser(true);
                    }
                    return false;
                }
                String str6 = j.a(str3, "B") ? "B" : "A";
                if (jCurrentTimeMillis <= 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                linkedHashMap.put(strIdOf, new Item(strIdOf, str, strQ1, i11, str6, str4, null, jCurrentTimeMillis, z10, str5, null, 0L, null, 7232, null));
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ boolean addItem$default(ArgoPool argoPool, String str, String str2, int i, String str3, String str4, long j, boolean z10, String str5, int i10, Object obj) {
        return argoPool.addItem(str, str2, i, str3, str4, j, (i10 & 64) != 0 ? false : z10, (i10 & 128) != 0 ? "" : str5);
    }

    private static final CharSequence addSource$lambda$61(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean carry(int i) {
        return ((Number) download(i, CARRY_URL, 262144L, GerehWatchdog.STUCK_MS, true).getSecond()).longValue() >= 250000;
    }

    private final String ccOf(Item item) {
        String cc2;
        Result result = results.get(item.getId());
        if (result != null && (cc2 = result.getCc()) != null) {
            if (o.L0(cc2) || cc2.equals("??")) {
                cc2 = null;
            }
            if (cc2 != null) {
                return cc2;
            }
        }
        String cc0 = item.getCc0();
        return o.L0(cc0) ? "??" : cc0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changed() {
        k0 k0Var = _version;
        Long lValueOf = Long.valueOf(((Number) ((g1) k0Var).getValue()).longValue() + 1);
        g1 g1Var = (g1) k0Var;
        g1Var.getClass();
        g1Var.k(null, lValueOf);
    }

    private final OkHttpClient client(int i, long j) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.e(socks(i));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.b(j, timeUnit);
        builder.g(j, timeUnit);
        builder.a(j, timeUnit);
        builder.f29106f = false;
        return new OkHttpClient(builder);
    }

    private final String decodeHtml(String str) {
        return v.q0(new l("&#(\\d+);").replace(v.q0(v.q0(v.q0(v.q0(v.q0(new l("<[^>]+>").replace(new l("<br\\s*/?>", kotlin.text.m.IGNORE_CASE).replace(str, "\n"), ""), "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&#39;", "'"), "&nbsp;", " "), new d(2)), "&amp;", "&");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence decodeHtml$lambda$42(kotlin.text.g m10) {
        j.e(m10, "m");
        Integer numV0 = v.v0((String) ((f0) ((kotlin.text.i) m10).a()).get(1));
        if (numV0 == null) {
            return "";
        }
        char[] chars = Character.toChars(numV0.intValue());
        j.d(chars, "toChars(...)");
        return new String(chars);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sd.j download(int i, String str, long j, long j10, boolean z10) {
        Object objM1004constructorimpl;
        sd.j jVar;
        we.j jVarJ;
        try {
            Request.Builder builder = new Request.Builder();
            builder.j(str);
            builder.d("User-Agent", CARRY_UA);
            if (z10) {
                builder.d("Range", "bytes=0-" + (j - 1));
            }
            Response responseD = client(i, j10).b(new Request(builder)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                int i10 = responseD.f29153d;
                if (responseBody == null || (jVarJ = responseBody.j()) == null) {
                    jVar = new sd.j(Integer.valueOf(i10), 0L);
                } else {
                    we.h hVar = new we.h();
                    long j11 = 0;
                    while (j11 < j) {
                        try {
                            long jS = jVarJ.s(hVar, 65536L);
                            if (jS < 0) {
                                break;
                            }
                            j11 += jS;
                            hVar.c();
                        } catch (IOException unused) {
                        }
                    }
                    jVar = new sd.j(Integer.valueOf(i10), Long.valueOf(j11));
                }
                responseD.close();
                objM1004constructorimpl = sd.l.m1004constructorimpl(jVar);
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
        sd.j jVar2 = new sd.j(0, 0L);
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = jVar2;
        }
        return (sd.j) objM1004constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArgoProtocol.Endpoint endpointOf(Item item) {
        return new ArgoProtocol.Endpoint(item.getId(), item.getKind(), item.getHost(), item.getPort(), item.getProtocol());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int freePort() throws IOException {
        ServerSocket serverSocket = new ServerSocket(0);
        try {
            int localPort = serverSocket.getLocalPort();
            serverSocket.close();
            return localPort;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a.a.g(serverSocket, th2);
                throw th3;
            }
        }
    }

    private final String githubRaw(String str) {
        kotlin.text.g gVarFind$default = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/]+)/(?:blob|raw)/(.+)$", kotlin.text.m.IGNORE_CASE), str, 0, 2, null);
        if (gVarFind$default == null) {
            return str;
        }
        kotlin.text.i iVar = (kotlin.text.i) gVarFind$default;
        return "https://raw.githubusercontent.com/" + ((f0) iVar.a()).get(1) + "/" + ((f0) iVar.a()).get(2) + "/" + ((f0) iVar.a()).get(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int harvestOfficial(Source source, ArgoNet.Route route) {
        if (j.a(source.getType(), "snowcfg")) {
            Iterator<String> it = source.getValue().iterator();
            while (it.hasNext()) {
                sd.j jVarFetchText$default = ArgoNet.fetchText$default(ArgoNet.INSTANCE, it.next(), route, 0L, 0L, 12, null);
                int iIntValue = ((Number) jVarFetchText$default.component1()).intValue();
                String str = (String) jVarFetchText$default.component2();
                if (iIntValue == 200) {
                    try {
                        ArgoProtocol argoProtocol = ArgoProtocol.INSTANCE;
                        ArgoProtocol.Snowcfg snowcfgDecodeSnowcfg = argoProtocol.decodeSnowcfg(str);
                        if (snowcfgDecodeSnowcfg.getSigOk()) {
                            int i = 0;
                            for (ArgoProtocol.PublicServer publicServer : argoProtocol.publicServersOf(snowcfgDecodeSnowcfg.getParams())) {
                                if (addItem$default(this, "public", publicServer.getHost(), publicServer.getPort(), "A", source.getId(), snowcfgDecodeSnowcfg.getIssuedMs(), false, publicServer.getProfile(), 64, null)) {
                                    i++;
                                }
                            }
                            return i;
                        }
                        continue;
                    } catch (Throwable unused) {
                        continue;
                    }
                }
            }
            throw new IllegalStateException("هیچ\u200cکدام از نشانی\u200cهای فهرست رسمی جواب نداد");
        }
        if (j.a(source.getType(), "falcon-servers")) {
            Iterator<String> it2 = source.getValue().iterator();
            while (it2.hasNext()) {
                sd.j jVarFetchText$default2 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, it2.next(), route, 0L, 0L, 12, null);
                int iIntValue2 = ((Number) jVarFetchText$default2.component1()).intValue();
                String str2 = (String) jVarFetchText$default2.component2();
                if (iIntValue2 == 200) {
                    try {
                        List<ArgoProtocol.FalconOrigin> listDecodeFalconServers = ArgoProtocol.INSTANCE.decodeFalconServers(str2);
                        if (!listDecodeFalconServers.isEmpty()) {
                            falconServers = listDecodeFalconServers;
                            sf.c cVar = new sf.c();
                            cVar.D("at", Long.valueOf(System.currentTimeMillis()));
                            List<ArgoProtocol.FalconOrigin> list = listDecodeFalconServers;
                            ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(list, 10));
                            for (ArgoProtocol.FalconOrigin falconOrigin : list) {
                                sf.c cVar2 = new sf.c();
                                cVar2.D("ip", falconOrigin.getIp());
                                cVar2.D(AwgProbeService.KEY_COUNTRY, falconOrigin.getCc());
                                cVar2.D("load", Double.valueOf(falconOrigin.getLoad()));
                                arrayList.add(cVar2);
                            }
                            cVar.D("falconServers", new sf.a((Collection) arrayList));
                            String string = cVar.toString();
                            j.d(string, "toString(...)");
                            try {
                                writeJson("remote.json", string);
                            } catch (Throwable unused2) {
                                continue;
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            }
            throw new IllegalStateException("فهرست سرورهای فالکن گرفته نشد");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x013f  */
    /* JADX WARN: Code duplicated, block: B:43:0x014f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0155  */
    /* JADX WARN: Code duplicated, block: B:48:0x0169  */
    /* JADX WARN: Code duplicated, block: B:51:0x0191  */
    /* JADX WARN: Code duplicated, block: B:53:0x0198  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:93:0x01bb A[EDGE_INSN: B:93:0x01bb->B:55:0x01bb BREAK  A[LOOP:0: B:39:0x0135->B:44:0x0151], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x026c -> B:86:0x0277). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x0155
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object harvestTelegram(com.mlmvpn.scanner.engines.argo.ArgoPool.Source r29, int r30, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r31, ee.e r32, ee.a r33, wd.d r34) {
        return ArgoPoolRecoveryBridge.recoverHarvestTelegram(this, r29, r30, r31, r32, r33, r34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence harvestTelegram$lambda$47(String line) {
        j.e(line, "line");
        return new l("BRIDGE BLOCK|^[A-Za-z0-9+/=]{20,}$").containsMatchIn(o.n1(line).toString()) ? line : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int harvestUrl(Source source, ArgoNet.Route route, ee.a aVar) {
        List<String> r14;
        Object objM1004constructorimpl;
        ArgoPool argoPool = this;
        String str = (String) q.y0(source.getValue());
        List<String> B = (List<String>) m9.d.B(argoPool.githubRaw(str));
        kotlin.text.m mVar = kotlin.text.m.IGNORE_CASE;
        kotlin.text.g gVarFind$default = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/#?]+)/?$", mVar), str, 0, 2, null);
        kotlin.text.g gVarFind$default2 = l.find$default(new l("^https?://github\\.com/([^/]+)/([^/#?]+)/(issues|discussions)", mVar), str, 0, 2, null);
        if (gVarFind$default2 != null) {
            kotlin.text.i iVar = (kotlin.text.i) gVarFind$default2;
            String str2 = "https://api.github.com/repos/" + ((f0) iVar.a()).get(1) + "/" + ((f0) iVar.a()).get(2);
            h hVar = new h(1, 3, 1);
            ArrayList arrayList = new ArrayList();
            g gVarA = hVar.iterator();
            while (gVarA.f23130c) {
                int iNextInt = gVarA.nextInt();
                q.m0(arrayList, r.a0(f0.a.i(iNextInt, str2, "/issues?state=all&per_page=100&page="), f0.a.i(iNextInt, str2, "/issues/comments?per_page=100&page=")));
            }
            r14 = arrayList;
        } else {
            if (gVarFind$default != null) {
                kotlin.text.i iVar2 = (kotlin.text.i) gVarFind$default;
                sd.j jVarFetchText$default = ArgoNet.fetchText$default(ArgoNet.INSTANCE, "https://api.github.com/repos/" + ((f0) iVar2.a()).get(1) + "/" + o.V0((String) ((f0) iVar2.a()).get(2), ".git") + "/contents", route, 0L, 0L, 12, null);
                int iIntValue = ((Number) jVarFetchText$default.component1()).intValue();
                try {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(new sf.a((String) jVarFetchText$default.component2()));
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
                }
                sf.a aVar2 = (sf.a) (sd.l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
                if (aVar2 == null) {
                    throw new IllegalStateException(androidx.compose.foundation.interaction.f.o(iIntValue, "مخزن گیت\u200cهاب خوانده نشد (کد ", ")"));
                }
                h hVarJ = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, aVar2.f67155a.size());
                ArrayList arrayList2 = new ArrayList();
                g gVarA2 = hVarJ.iterator();
                while (gVarA2.f23130c) {
                    sf.c cVarQ = aVar2.q(gVarA2.nextInt());
                    if (cVarQ != null) {
                        arrayList2.add(cVarQ);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    sf.c cVar = (sf.c) obj;
                    if (j.a(cVar.A(TeXSymbolParser.TYPE_ATTR, ""), "file")) {
                        String strA = cVar.A("download_url", "");
                        j.d(strA, "optString(...)");
                        if (!o.L0(strA) && cVar.x(0L, "size") < 8000000) {
                            l lVar = new l("\\.(png|jpe?g|gif|webp|zip|apk|exe|pdf)$", kotlin.text.m.IGNORE_CASE);
                            String strA2 = cVar.A("name", "");
                            j.d(strA2, "optString(...)");
                            if (!lVar.containsMatchIn(strA2)) {
                                arrayList3.add(obj);
                            }
                        }
                    }
                }
                List listE1 = q.e1(arrayList3, 30);
                B = new ArrayList(kotlin.collections.s.g0(listE1, 10));
                Iterator it = listE1.iterator();
                while (it.hasNext()) {
                    B.add(((sf.c) it.next()).A("download_url", ""));
                }
            }
            r14 = B;
        }
        int falcons = 0;
        for (String str3 : r14) {
            if (((Boolean) aVar.invoke()).booleanValue()) {
                break;
            }
            sd.j jVarFetchText$default2 = ArgoNet.fetchText$default(ArgoNet.INSTANCE, str3, route, 0L, 0L, 12, null);
            int iIntValue2 = ((Number) jVarFetchText$default2.component1()).intValue();
            String str4 = (String) jVarFetchText$default2.component2();
            if (iIntValue2 == 200 && str4.length() != 0) {
                y yVar = new y();
                yVar.element = str4;
                boolean zContainsMatchIn = new l("^\\s*[\\[{]").containsMatchIn((CharSequence) yVar.element);
                u uVar = u.f67154a;
                if (zContainsMatchIn) {
                    try {
                        Object aVar3 = v.s0(o.r1((String) yVar.element).toString(), "[", false) ? new sf.a((String) yVar.element) : new sf.c((String) yVar.element);
                        if (!(aVar3 instanceof sf.a) || ((sf.a) aVar3).f67155a.size() != 0) {
                            ArrayList arrayList4 = new ArrayList();
                            argoPool.jsonStrings(aVar3, arrayList4);
                            yVar.element = q.F0(arrayList4, "\n", null, null, null, 62);
                        }
                        sd.l.m1004constructorimpl(uVar);
                    } catch (Throwable th3) {
                        sd.l.m1004constructorimpl(m.a(th3));
                    }
                }
                String strReplace = new l("\\s+").replace((CharSequence) yVar.element, "");
                if (i.B("^[A-Za-z0-9+/=]{40,}$", strReplace) && !v.s0(strReplace, "eJ", false)) {
                    try {
                        String str5 = new String(ArgoProtocol.INSTANCE.b64(strReplace), kotlin.text.a.f23859a);
                        if (o.z0(str5, '\n') || o.z0(str5, '.')) {
                            yVar.element = yVar.element + "\n" + str5;
                        }
                        sd.l.m1004constructorimpl(uVar);
                    } catch (Throwable th4) {
                        sd.l.m1004constructorimpl(m.a(th4));
                    }
                }
                Absorbed absorbedAbsorbText$default = absorbText$default(argoPool, (String) yVar.element, source.getId(), System.currentTimeMillis(), true, false, 16, null);
                falcons = absorbedAbsorbText$default.getFalcons() + absorbedAbsorbText$default.getBridges() + falcons;
            } else if (r14.size() == 1) {
                throw new IllegalStateException(androidx.compose.foundation.interaction.f.o(iIntValue2, "نشانی جواب نداد (کد ", ")"));
            }
            argoPool = this;
        }
        return falcons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasGlobalV6() {
        Object objM1004constructorimpl;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            j.d(networkInterfaces, "getNetworkInterfaces(...)");
            ArrayList list = Collections.list(networkInterfaces);
            j.d(list, "list(...)");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            boolean z10 = false;
            int i = 0;
            while (i < size) {
                Object obj = list.get(i);
                i++;
                NetworkInterface networkInterface = (NetworkInterface) obj;
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    String name = networkInterface.getName();
                    j.d(name, "getName(...)");
                    if (!v.s0(name, XrayCoreHostService.KEY_TUN, false)) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size2 = arrayList.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList.get(i10);
                i10++;
                Enumeration<InetAddress> inetAddresses = ((NetworkInterface) obj2).getInetAddresses();
                j.d(inetAddresses, "getInetAddresses(...)");
                ArrayList list2 = Collections.list(inetAddresses);
                j.d(list2, "list(...)");
                q.m0(arrayList2, list2);
            }
            if (!arrayList2.isEmpty()) {
                int size3 = arrayList2.size();
                int i11 = 0;
                while (i11 < size3) {
                    Object obj3 = arrayList2.get(i11);
                    i11++;
                    InetAddress inetAddress = (InetAddress) obj3;
                    if ((inetAddress instanceof Inet6Address) && !((Inet6Address) inetAddress).isLinkLocalAddress() && !((Inet6Address) inetAddress).isSiteLocalAddress() && !((Inet6Address) inetAddress).isLoopbackAddress() && (((Inet6Address) inetAddress).getAddress()[0] & 224) == 32) {
                        z10 = true;
                        break;
                    }
                }
            }
            objM1004constructorimpl = sd.l.m1004constructorimpl(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = bool;
        }
        return ((Boolean) objM1004constructorimpl).booleanValue();
    }

    private final String idOf(String str, String str2, int i) {
        return str.charAt(0) + ":" + str2 + (i != 443 ? f0.a.h(i, ":") : "");
    }

    private final sf.c itemJson(Item item) {
        sf.c cVar = new sf.c();
        cVar.D(XrayCoreHostService.KEY_ID, item.getId());
        cVar.D("kind", item.getKind());
        cVar.D("host", item.getHost());
        cVar.D(PsiphonProbeService.PORT, Integer.valueOf(item.getPort()));
        cVar.D("protocol", item.getProtocol());
        cVar.D("src", item.getSrc());
        cVar.D("from", item.getFrom());
        cVar.D("seen", Long.valueOf(item.getSeen()));
        cVar.E("user", item.getUser());
        cVar.D("profile", item.getProfile());
        cVar.D("cc0", item.getCc0());
        cVar.D("v0", Long.valueOf(item.getV0()));
        cVar.D("ip0", item.getIp0());
        return cVar;
    }

    private final Item itemOf(sf.c cVar) {
        String strA = cVar.A(XrayCoreHostService.KEY_ID, "");
        j.d(strA, "optString(...)");
        String strA2 = cVar.A("kind", "");
        j.d(strA2, "optString(...)");
        String strA3 = cVar.A("host", "");
        j.d(strA3, "optString(...)");
        int iT = cVar.t(ProtonStealth.PORT, PsiphonProbeService.PORT);
        String strA4 = cVar.A("protocol", "A");
        j.d(strA4, "optString(...)");
        String strA5 = cVar.A("src", "");
        j.d(strA5, "optString(...)");
        String strA6 = cVar.A("from", "");
        j.d(strA6, "optString(...)");
        long jX = cVar.x(0L, "seen");
        boolean zQ = cVar.q("user", false);
        String strA7 = cVar.A("profile", "");
        j.d(strA7, "optString(...)");
        String strA8 = cVar.A("cc0", "");
        j.d(strA8, "optString(...)");
        long jX2 = cVar.x(0L, "v0");
        String strA9 = cVar.A("ip0", "");
        j.d(strA9, "optString(...)");
        return new Item(strA, strA2, strA3, iT, strA4, strA5, strA6, jX, zQ, strA7, strA8, jX2, strA9);
    }

    private final void jsonStrings(Object obj, List<String> list) {
        if (obj instanceof String) {
            list.add(obj);
            return;
        }
        if (obj instanceof sf.a) {
            sf.a aVar = (sf.a) obj;
            int size = aVar.f67155a.size();
            for (int i = 0; i < size; i++) {
                jsonStrings(aVar.m(i), list);
            }
            return;
        }
        if (obj instanceof sf.c) {
            sf.c cVar = (sf.c) obj;
            Iterator itN = cVar.n();
            j.d(itN, "keys(...)");
            while (itN.hasNext()) {
                jsonStrings(cVar.o((String) itN.next()), list);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01e2 A[Catch: all -> 0x01d7, TRY_LEAVE, TryCatch #4 {all -> 0x01d7, blocks: (B:4:0x0003, B:9:0x000a, B:93:0x01ae, B:94:0x01b6, B:96:0x01bc, B:99:0x01da, B:101:0x01e2, B:118:0x026c, B:117:0x0264, B:119:0x026f, B:121:0x0277, B:131:0x02b2, B:130:0x02aa, B:132:0x02b5, B:155:0x037f, B:156:0x0382, B:162:0x03c2, B:163:0x03c5, B:165:0x03cd, B:178:0x0402, B:177:0x03fa, B:179:0x0405, B:180:0x040b, B:182:0x0411, B:184:0x0423, B:186:0x042b, B:161:0x03ba, B:154:0x0377, B:166:0x03cf, B:171:0x03ec, B:175:0x03f5, B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3, B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370, B:158:0x038a, B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:202:0x0003, inners: #1, #2, #3, #5, #10 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01f2 A[Catch: all -> 0x021d, TryCatch #10 {all -> 0x021d, blocks: (B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:213:0x01e4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x020c A[Catch: all -> 0x021d, TryCatch #10 {all -> 0x021d, blocks: (B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:213:0x01e4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0216 A[Catch: all -> 0x021d, TryCatch #10 {all -> 0x021d, blocks: (B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:213:0x01e4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0254  */
    /* JADX WARN: Code duplicated, block: B:121:0x0277 A[Catch: all -> 0x01d7, TRY_LEAVE, TryCatch #4 {all -> 0x01d7, blocks: (B:4:0x0003, B:9:0x000a, B:93:0x01ae, B:94:0x01b6, B:96:0x01bc, B:99:0x01da, B:101:0x01e2, B:118:0x026c, B:117:0x0264, B:119:0x026f, B:121:0x0277, B:131:0x02b2, B:130:0x02aa, B:132:0x02b5, B:155:0x037f, B:156:0x0382, B:162:0x03c2, B:163:0x03c5, B:165:0x03cd, B:178:0x0402, B:177:0x03fa, B:179:0x0405, B:180:0x040b, B:182:0x0411, B:184:0x0423, B:186:0x042b, B:161:0x03ba, B:154:0x0377, B:166:0x03cf, B:171:0x03ec, B:175:0x03f5, B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3, B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370, B:158:0x038a, B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:202:0x0003, inners: #1, #2, #3, #5, #10 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x028d A[Catch: all -> 0x02a1, LOOP:2: B:123:0x0287->B:125:0x028d, LOOP_END, TryCatch #2 {all -> 0x02a1, blocks: (B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3), top: B:198:0x0279, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x02e1 A[Catch: all -> 0x02e7, TryCatch #3 {all -> 0x02e7, blocks: (B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370), top: B:200:0x02d4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x02f3 A[Catch: all -> 0x02e7, TryCatch #3 {all -> 0x02e7, blocks: (B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370), top: B:200:0x02d4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02f9 A[Catch: all -> 0x02e7, TryCatch #3 {all -> 0x02e7, blocks: (B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370), top: B:200:0x02d4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x034c A[Catch: all -> 0x02e7, TryCatch #3 {all -> 0x02e7, blocks: (B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370), top: B:200:0x02d4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0360 A[Catch: all -> 0x02e7, LOOP:5: B:149:0x035a->B:151:0x0360, LOOP_END, TryCatch #3 {all -> 0x02e7, blocks: (B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370), top: B:200:0x02d4, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03cd A[Catch: all -> 0x01d7, TRY_LEAVE, TryCatch #4 {all -> 0x01d7, blocks: (B:4:0x0003, B:9:0x000a, B:93:0x01ae, B:94:0x01b6, B:96:0x01bc, B:99:0x01da, B:101:0x01e2, B:118:0x026c, B:117:0x0264, B:119:0x026f, B:121:0x0277, B:131:0x02b2, B:130:0x02aa, B:132:0x02b5, B:155:0x037f, B:156:0x0382, B:162:0x03c2, B:163:0x03c5, B:165:0x03cd, B:178:0x0402, B:177:0x03fa, B:179:0x0405, B:180:0x040b, B:182:0x0411, B:184:0x0423, B:186:0x042b, B:161:0x03ba, B:154:0x0377, B:166:0x03cf, B:171:0x03ec, B:175:0x03f5, B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3, B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370, B:158:0x038a, B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:202:0x0003, inners: #1, #2, #3, #5, #10 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:169:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:171:0x03ec A[Catch: all -> 0x03f1, TryCatch #1 {all -> 0x03f1, blocks: (B:166:0x03cf, B:171:0x03ec, B:175:0x03f5), top: B:196:0x03cf, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:182:0x0411 A[Catch: all -> 0x01d7, TryCatch #4 {all -> 0x01d7, blocks: (B:4:0x0003, B:9:0x000a, B:93:0x01ae, B:94:0x01b6, B:96:0x01bc, B:99:0x01da, B:101:0x01e2, B:118:0x026c, B:117:0x0264, B:119:0x026f, B:121:0x0277, B:131:0x02b2, B:130:0x02aa, B:132:0x02b5, B:155:0x037f, B:156:0x0382, B:162:0x03c2, B:163:0x03c5, B:165:0x03cd, B:178:0x0402, B:177:0x03fa, B:179:0x0405, B:180:0x040b, B:182:0x0411, B:184:0x0423, B:186:0x042b, B:161:0x03ba, B:154:0x0377, B:166:0x03cf, B:171:0x03ec, B:175:0x03f5, B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3, B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370, B:158:0x038a, B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:202:0x0003, inners: #1, #2, #3, #5, #10 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x02d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x0341 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01bc A[Catch: all -> 0x01d7, TryCatch #4 {all -> 0x01d7, blocks: (B:4:0x0003, B:9:0x000a, B:93:0x01ae, B:94:0x01b6, B:96:0x01bc, B:99:0x01da, B:101:0x01e2, B:118:0x026c, B:117:0x0264, B:119:0x026f, B:121:0x0277, B:131:0x02b2, B:130:0x02aa, B:132:0x02b5, B:155:0x037f, B:156:0x0382, B:162:0x03c2, B:163:0x03c5, B:165:0x03cd, B:178:0x0402, B:177:0x03fa, B:179:0x0405, B:180:0x040b, B:182:0x0411, B:184:0x0423, B:186:0x042b, B:161:0x03ba, B:154:0x0377, B:166:0x03cf, B:171:0x03ec, B:175:0x03f5, B:122:0x0279, B:123:0x0287, B:125:0x028d, B:128:0x02a3, B:134:0x02d4, B:136:0x02e1, B:139:0x02ea, B:141:0x02f3, B:143:0x02f9, B:144:0x0341, B:145:0x0344, B:147:0x034c, B:148:0x0351, B:149:0x035a, B:151:0x0360, B:152:0x0370, B:158:0x038a, B:102:0x01e4, B:104:0x01f2, B:106:0x020c, B:108:0x0216, B:112:0x021f, B:114:0x0255, B:115:0x025d), top: B:202:0x0003, inners: #1, #2, #3, #5, #10 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:96:0x01bc, please report this as an issue */
    private final synchronized void load() {
        List<ArgoProtocol.FalconOrigin> list;
        Object objM1004constructorimpl;
        Throwable thM1007exceptionOrNullimpl;
        String json;
        String json2;
        String json3;
        Object objM1004constructorimpl2;
        sf.a aVarV;
        int size;
        int i;
        sf.c cVarW;
        Iterator itN;
        sf.c cVarQ;
        String json4;
        Object objM1004constructorimpl3;
        String json5;
        HashMap<String, sf.c> map;
        Object objM1004constructorimpl4;
        List<ArgoProtocol.FalconOrigin> falconServers2;
        Object obj;
        ArgoPool argoPool;
        Object objM1004constructorimpl5;
        sf.c cVar;
        Iterator itN2;
        ArgoPool argoPool2;
        Object objM1004constructorimpl6;
        sf.a aVar;
        int size2;
        int i10;
        Item itemItemOf;
        Item item;
        String id2;
        String str;
        String cc0;
        Object objM1004constructorimpl7;
        try {
            if (loaded) {
                return;
            }
            int i11 = 1;
            loaded = true;
            int i12 = 0;
            try {
                Context context = app;
                try {
                    if (context == null) {
                        j.k("app");
                        throw null;
                    }
                    InputStream inputStreamOpen = context.getAssets().open(ASSET);
                    j.d(inputStreamOpen, "open(...)");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, kotlin.text.a.f23859a), 8192);
                    try {
                        String strI = com.google.android.gms.internal.auth.j.I(bufferedReader);
                        bufferedReader.close();
                        sf.c cVar2 = new sf.c(strI);
                        sf.a aVarV2 = cVar2.v("items");
                        if (aVarV2 == null) {
                            aVarV2 = new sf.a();
                        }
                        int size3 = aVarV2.f67155a.size();
                        int i13 = 0;
                        while (i13 < size3) {
                            sf.a aVarP = aVarV2.p(i13);
                            if (aVarP != null) {
                                String strT = aVarP.t(i12, "");
                                String str2 = j.a(strT, "b") ? "bridge" : j.a(strT, "f") ? "falcon" : "public";
                                String strT2 = aVarP.t(i11, "");
                                int iO = aVarP.o(2);
                                Integer numValueOf = Integer.valueOf(iO);
                                if (iO <= 0) {
                                    numValueOf = null;
                                }
                                int iIntValue = numValueOf != null ? numValueOf.intValue() : ProtonStealth.PORT;
                                j.b(strT2);
                                String strIdOf = idOf(str2, strT2, iIntValue);
                                String str3 = j.a(aVarP.t(3, ""), "B") ? "B" : "A";
                                String str4 = "bundled";
                                String strT3 = aVarP.t(4, "");
                                if (j.a(strT3, "0")) {
                                    strT3 = null;
                                }
                                if (strT3 == null) {
                                    strT3 = "";
                                }
                                String str5 = strT3;
                                long j = 1000;
                                long jR = aVarP.r(5, 0L) * j;
                                String strT4 = aVarP.t(6, "");
                                if (j.a(strT4, "0")) {
                                    strT4 = null;
                                }
                                if (strT4 == null) {
                                    strT4 = "";
                                }
                                String str6 = strT4;
                                String strT5 = aVarP.t(7, "");
                                if (j.a(strT5, "0")) {
                                    strT5 = null;
                                }
                                if (strT5 == null) {
                                    strT5 = "";
                                }
                                String str7 = strT5;
                                long jR2 = aVarP.r(8, 0L) * j;
                                String strT6 = aVarP.t(9, "");
                                if (j.a(strT6, "0")) {
                                    strT6 = null;
                                }
                                if (strT6 == null) {
                                    strT6 = "";
                                }
                                Item item2 = new Item(strIdOf, str2, strT2, iIntValue, str3, str4, str5, jR, false, str6, str7, jR2, strT6, 256, null);
                                items.put(item2.getId(), item2);
                            }
                            i13++;
                            i11 = 1;
                            i12 = 0;
                        }
                        list = null;
                        try {
                            objM1004constructorimpl7 = sd.l.m1004constructorimpl(Long.valueOf(Instant.parse(cVar2.A("built", "")).toEpochMilli()));
                        } catch (Throwable th2) {
                            objM1004constructorimpl7 = sd.l.m1004constructorimpl(m.a(th2));
                        }
                        if (sd.l.m1010isFailureimpl(objM1004constructorimpl7)) {
                            objM1004constructorimpl7 = 0L;
                        }
                        bundleBuilt = ((Number) objM1004constructorimpl7).longValue();
                        falconServers = parseFalconServers(cVar2.v("falconServers"));
                        objM1004constructorimpl = sd.l.m1004constructorimpl(u.f67154a);
                        thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
                        if (thM1007exceptionOrNullimpl != null) {
                            Log.w(TAG, "bundle unreadable: " + thM1007exceptionOrNullimpl.getMessage());
                        }
                        json = readJson("pool.json");
                        if (json != null) {
                            argoPool2 = INSTANCE;
                            try {
                                aVar = new sf.a(json);
                                size2 = aVar.f67155a.size();
                                for (i10 = 0; i10 < size2; i10++) {
                                    itemItemOf = argoPool2.itemOf(aVar.h(i10));
                                    LinkedHashMap<String, Item> linkedHashMap = items;
                                    item = linkedHashMap.get(itemItemOf.getId());
                                    id2 = itemItemOf.getId();
                                    if (item != null) {
                                        cc0 = itemItemOf.getCc0();
                                        if (o.L0(cc0)) {
                                            cc0 = item.getCc0();
                                        }
                                        str = id2;
                                        itemItemOf = Item.copy$default(itemItemOf, null, null, null, 0, null, null, null, 0L, false, null, cc0, Math.max(itemItemOf.getV0(), item.getV0()), null, 5119, null);
                                    } else {
                                        str = id2;
                                    }
                                    linkedHashMap.put(str, itemItemOf);
                                }
                                objM1004constructorimpl6 = sd.l.m1004constructorimpl(u.f67154a);
                            } catch (Throwable th3) {
                                objM1004constructorimpl6 = sd.l.m1004constructorimpl(m.a(th3));
                            }
                            sd.l.m1003boximpl(objM1004constructorimpl6);
                        }
                        json2 = readJson("results.json");
                        if (json2 != null) {
                            argoPool = INSTANCE;
                            try {
                                cVar = new sf.c(json2);
                                itN2 = cVar.n();
                                j.d(itN2, "keys(...)");
                                while (itN2.hasNext()) {
                                    String str8 = (String) itN2.next();
                                    results.put(str8, argoPool.resultOf(cVar.h(str8)));
                                }
                                objM1004constructorimpl5 = sd.l.m1004constructorimpl(u.f67154a);
                            } catch (Throwable th4) {
                                objM1004constructorimpl5 = sd.l.m1004constructorimpl(m.a(th4));
                            }
                            sd.l.m1003boximpl(objM1004constructorimpl5);
                        }
                        Set<Map.Entry<String, Result>> setEntrySet = results.entrySet();
                        j.d(setEntrySet, "<get-entries>(...)");
                        q.U0(setEntrySet, new d(11));
                        json3 = readJson("sources.json");
                        if (json3 != null) {
                            try {
                                sf.c cVar3 = new sf.c(json3);
                                aVarV = cVar3.v("list");
                                if (aVarV == null) {
                                    aVarV = new sf.a();
                                }
                                size = aVarV.f67155a.size();
                                for (i = 0; i < size; i++) {
                                    cVarQ = aVarV.q(i);
                                    if (cVarQ != null) {
                                        List<Source> list2 = userSources;
                                        String strA = cVarQ.A(XrayCoreHostService.KEY_ID, "");
                                        j.d(strA, "optString(...)");
                                        String strA2 = cVarQ.A(TeXSymbolParser.TYPE_ATTR, "");
                                        j.d(strA2, "optString(...)");
                                        List listB = m9.d.B(cVarQ.A("value", ""));
                                        String strA3 = cVarQ.A("label", "");
                                        j.d(strA3, "optString(...)");
                                        list2.add(new Source(strA, strA2, listB, strA3, false, true, cVarQ.x(0L, "addedAt")));
                                    }
                                }
                                cVarW = cVar3.w("state");
                                if (cVarW == null) {
                                    cVarW = new sf.c();
                                }
                                itN = cVarW.n();
                                j.d(itN, "keys(...)");
                                while (itN.hasNext()) {
                                    String str9 = (String) itN.next();
                                    sourceState.put(str9, cVarW.h(str9));
                                }
                                objM1004constructorimpl2 = sd.l.m1004constructorimpl(u.f67154a);
                            } catch (Throwable th5) {
                                objM1004constructorimpl2 = sd.l.m1004constructorimpl(m.a(th5));
                            }
                            sd.l.m1003boximpl(objM1004constructorimpl2);
                        }
                        json4 = readJson("prefs.json");
                        if (json4 != null) {
                            try {
                                sf.c cVar4 = new sf.c(json4);
                                String strA4 = cVar4.A("cleanIp", "");
                                j.d(strA4, "optString(...)");
                                prefs = new Prefs(strA4, cVar4.q("autoClean", false));
                                cleanScan = cVar4.w("cleanScan");
                                objM1004constructorimpl3 = sd.l.m1004constructorimpl(u.f67154a);
                            } catch (Throwable th6) {
                                objM1004constructorimpl3 = sd.l.m1004constructorimpl(m.a(th6));
                            }
                            sd.l.m1003boximpl(objM1004constructorimpl3);
                        }
                        json5 = readJson("remote.json");
                        if (json5 != null) {
                            try {
                                falconServers2 = INSTANCE.parseFalconServers(new sf.c(json5).v("falconServers"));
                                if (!falconServers2.isEmpty()) {
                                    falconServers2 = list;
                                }
                                if (falconServers2 != null) {
                                    falconServers = falconServers2;
                                    obj = u.f67154a;
                                } else {
                                    obj = list;
                                }
                                objM1004constructorimpl4 = sd.l.m1004constructorimpl(obj);
                            } catch (Throwable th7) {
                                objM1004constructorimpl4 = sd.l.m1004constructorimpl(m.a(th7));
                            }
                            sd.l.m1003boximpl(objM1004constructorimpl4);
                        }
                        for (Source source : BUILTIN) {
                            map = sourceState;
                            if (map.containsKey(source.getId()) && bundleBuilt > 0) {
                                String id3 = source.getId();
                                sf.c cVar5 = new sf.c();
                                cVar5.D("at", Long.valueOf(bundleBuilt));
                                cVar5.D("found", 0);
                                cVar5.E("on", true);
                                map.put(id3, cVar5);
                            }
                        }
                    } catch (Throwable th8) {
                        list = null;
                        try {
                            throw th8;
                        } catch (Throwable th9) {
                            a.a.g(bufferedReader, th8);
                            throw th9;
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th));
                    thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
                    if (thM1007exceptionOrNullimpl != null) {
                        Log.w(TAG, "bundle unreadable: " + thM1007exceptionOrNullimpl.getMessage());
                    }
                    json = readJson("pool.json");
                    if (json != null) {
                        argoPool2 = INSTANCE;
                        aVar = new sf.a(json);
                        size2 = aVar.f67155a.size();
                        while (i10 < size2) {
                            itemItemOf = argoPool2.itemOf(aVar.h(i10));
                            LinkedHashMap<String, Item> linkedHashMap2 = items;
                            item = linkedHashMap2.get(itemItemOf.getId());
                            id2 = itemItemOf.getId();
                            if (item != null) {
                                cc0 = itemItemOf.getCc0();
                                if (o.L0(cc0)) {
                                    cc0 = item.getCc0();
                                }
                                str = id2;
                                itemItemOf = Item.copy$default(itemItemOf, null, null, null, 0, null, null, null, 0L, false, null, cc0, Math.max(itemItemOf.getV0(), item.getV0()), null, 5119, null);
                            } else {
                                str = id2;
                            }
                            linkedHashMap2.put(str, itemItemOf);
                        }
                        objM1004constructorimpl6 = sd.l.m1004constructorimpl(u.f67154a);
                        sd.l.m1003boximpl(objM1004constructorimpl6);
                    }
                    json2 = readJson("results.json");
                    if (json2 != null) {
                        argoPool = INSTANCE;
                        cVar = new sf.c(json2);
                        itN2 = cVar.n();
                        j.d(itN2, "keys(...)");
                        while (itN2.hasNext()) {
                            String str10 = (String) itN2.next();
                            results.put(str10, argoPool.resultOf(cVar.h(str10)));
                        }
                        objM1004constructorimpl5 = sd.l.m1004constructorimpl(u.f67154a);
                        sd.l.m1003boximpl(objM1004constructorimpl5);
                    }
                    Set<Map.Entry<String, Result>> setEntrySet2 = results.entrySet();
                    j.d(setEntrySet2, "<get-entries>(...)");
                    q.U0(setEntrySet2, new d(11));
                    json3 = readJson("sources.json");
                    if (json3 != null) {
                        sf.c cVar6 = new sf.c(json3);
                        aVarV = cVar6.v("list");
                        if (aVarV == null) {
                            aVarV = new sf.a();
                        }
                        size = aVarV.f67155a.size();
                        while (i < size) {
                            cVarQ = aVarV.q(i);
                            if (cVarQ != null) {
                                List<Source> list3 = userSources;
                                String strA5 = cVarQ.A(XrayCoreHostService.KEY_ID, "");
                                j.d(strA5, "optString(...)");
                                String strA6 = cVarQ.A(TeXSymbolParser.TYPE_ATTR, "");
                                j.d(strA6, "optString(...)");
                                List listB2 = m9.d.B(cVarQ.A("value", ""));
                                String strA7 = cVarQ.A("label", "");
                                j.d(strA7, "optString(...)");
                                list3.add(new Source(strA5, strA6, listB2, strA7, false, true, cVarQ.x(0L, "addedAt")));
                            }
                        }
                        cVarW = cVar6.w("state");
                        if (cVarW == null) {
                            cVarW = new sf.c();
                        }
                        itN = cVarW.n();
                        j.d(itN, "keys(...)");
                        while (itN.hasNext()) {
                            String str11 = (String) itN.next();
                            sourceState.put(str11, cVarW.h(str11));
                        }
                        objM1004constructorimpl2 = sd.l.m1004constructorimpl(u.f67154a);
                        sd.l.m1003boximpl(objM1004constructorimpl2);
                    }
                    json4 = readJson("prefs.json");
                    if (json4 != null) {
                        sf.c cVar7 = new sf.c(json4);
                        String strA8 = cVar7.A("cleanIp", "");
                        j.d(strA8, "optString(...)");
                        prefs = new Prefs(strA8, cVar7.q("autoClean", false));
                        cleanScan = cVar7.w("cleanScan");
                        objM1004constructorimpl3 = sd.l.m1004constructorimpl(u.f67154a);
                        sd.l.m1003boximpl(objM1004constructorimpl3);
                    }
                    json5 = readJson("remote.json");
                    if (json5 != null) {
                        falconServers2 = INSTANCE.parseFalconServers(new sf.c(json5).v("falconServers"));
                        if (!falconServers2.isEmpty()) {
                            falconServers2 = list;
                        }
                        if (falconServers2 != null) {
                            falconServers = falconServers2;
                            obj = u.f67154a;
                        } else {
                            obj = list;
                        }
                        objM1004constructorimpl4 = sd.l.m1004constructorimpl(obj);
                        sd.l.m1003boximpl(objM1004constructorimpl4);
                    }
                    while (r0.hasNext()) {
                        map = sourceState;
                        if (map.containsKey(source.getId())) {
                        }
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                list = null;
            }
        } catch (Throwable th12) {
            throw th12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean load$lambda$20(Map.Entry entry) {
        j.e(entry, "<destruct>");
        Object value = entry.getValue();
        j.d(value, "component2(...)");
        Result result = (Result) value;
        return result.getFrozen() && result.getAt() < CARRY_UA_FIXED_AT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object measureExits(List<Ready> list, String str, wd.d dVar) {
        return m0.i(new AnonymousClass2(list, str, null), dVar);
    }

    private final List<ArgoProtocol.FalconOrigin> parseFalconServers(sf.a aVar) {
        ArgoProtocol.FalconOrigin falconOrigin;
        h hVarJ = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, aVar != null ? aVar.f67155a.size() : 0);
        ArrayList arrayList = new ArrayList();
        Iterator it = hVarJ.iterator();
        while (it.hasNext()) {
            int iNextInt = ((g) it).nextInt();
            j.b(aVar);
            sf.c cVarQ = aVar.q(iNextInt);
            if (cVarQ != null) {
                String strA = cVarQ.A("ip", "");
                j.d(strA, "optString(...)");
                String strA2 = cVarQ.A(AwgProbeService.KEY_COUNTRY, "??");
                j.d(strA2, "optString(...)");
                falconOrigin = new ArgoProtocol.FalconOrigin(strA, strA2, cVarQ.s("load", 0.0d));
            } else {
                falconOrigin = null;
            }
            if (falconOrigin != null) {
                arrayList.add(falconOrigin);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List pick$default(ArgoPool argoPool, int i, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = 3;
        }
        return argoPool.pick(i);
    }

    private final String readJson(String str) {
        Object objM1004constructorimpl;
        try {
            File file = dir;
            if (file == null) {
                j.k("dir");
                throw null;
            }
            File file2 = new File(file, str);
            if (!file2.exists()) {
                file2 = null;
            }
            objM1004constructorimpl = sd.l.m1004constructorimpl(file2 != null ? ce.o.n0(file2, kotlin.text.a.f23859a) : null);
            return (String) (sd.l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
        }
    }

    public static /* synthetic */ void record$default(ArgoPool argoPool, String str, boolean z10, long j, String str2, String str3, String str4, boolean z11, String str5, int i, Object obj) {
        argoPool.record(str, z10, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? false : z11, (i & 128) != 0 ? "" : str5);
    }

    private final synchronized List<Item> refHosts(int i) {
        List listB1;
        List listB2;
        ArrayList arrayList;
        Result result;
        try {
            Collection<Item> collectionValues = items.values();
            j.d(collectionValues, "<get-values>(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : collectionValues) {
                if (!j.a(((Item) obj).getKind(), "falcon")) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList2.get(i11);
                i11++;
                Result result2 = results.get(((Item) obj2).getId());
                if (result2 != null && result2.getOk()) {
                    arrayList3.add(obj2);
                }
            }
            listB1 = q.b1(arrayList3, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    Object obj3 = ArgoPool.results.get(((ArgoPool.Item) t10).getId());
                    j.b(obj3);
                    Long lValueOf = Long.valueOf(((ArgoPool.Result) obj3).getMs());
                    Object obj4 = ArgoPool.results.get(((ArgoPool.Item) t11).getId());
                    j.b(obj4);
                    return p.e(lValueOf, Long.valueOf(((ArgoPool.Result) obj4).getMs()));
                }
            });
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList2.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj3 = arrayList2.get(i12);
                i12++;
                Item item = (Item) obj3;
                if (item.getV0() > 0 && ((result = results.get(item.getId())) == null || !result.getOk())) {
                    arrayList4.add(obj3);
                }
            }
            listB2 = q.b1(arrayList4, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$refHosts$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return p.e(Long.valueOf(((ArgoPool.Item) t11).getV0()), Long.valueOf(((ArgoPool.Item) t10).getV0()));
                }
            });
            arrayList = new ArrayList();
            int size3 = arrayList2.size();
            while (i10 < size3) {
                Object obj4 = arrayList2.get(i10);
                i10++;
                Item item2 = (Item) obj4;
                if (j.a(item2.getKind(), "public") && item2.getV0() == 0) {
                    arrayList.add(obj4);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return q.e1(q.S0(q.S0(listB1, listB2), arrayList), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeSource$lambda$64(String str, Source it) {
        j.e(it, "it");
        return j.a(it.getId(), str);
    }

    private final sf.c resultJson(Result result) {
        sf.c cVar = new sf.c();
        cVar.E("ok", result.getOk());
        cVar.D(AwgProbeService.KEY_MS, Long.valueOf(result.getMs()));
        cVar.D(AwgProbeService.KEY_COUNTRY, result.getCc());
        cVar.D("exitIp", result.getExitIp());
        cVar.D("at", Long.valueOf(result.getAt()));
        cVar.D("fails", Integer.valueOf(result.getFails()));
        cVar.D("error", result.getError());
        cVar.E("frozen", result.getFrozen());
        cVar.D("edge", result.getEdge());
        return cVar;
    }

    private final Result resultOf(sf.c cVar) {
        boolean zQ = cVar.q("ok", false);
        long jX = cVar.x(0L, AwgProbeService.KEY_MS);
        String strA = cVar.A(AwgProbeService.KEY_COUNTRY, "");
        j.d(strA, "optString(...)");
        String strA2 = cVar.A("exitIp", "");
        j.d(strA2, "optString(...)");
        long jX2 = cVar.x(0L, "at");
        int iT = cVar.t(0, "fails");
        String strA3 = cVar.A("error", "");
        j.d(strA3, "optString(...)");
        boolean zQ2 = cVar.q("frozen", false);
        String strA4 = cVar.A("edge", "");
        j.d(strA4, "optString(...)");
        return new Result(zQ, jX, strA, strA2, jX2, iT, strA3, zQ2, strA4);
    }

    private final ArgoNet.Route routeNow() {
        MyVpnService.Companion companion = MyVpnService.Companion;
        if (((g1) companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.CONNECTED) {
            LocalPort localPort = LocalPort.INSTANCE;
            Context context = app;
            if (context != null) {
                return new ArgoNet.Route(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, localPort.get(context))), j.a(((g1) companion.getConnectedNodeIdFlow()).getValue(), "argo") ? "خود آرگو" : "موتور وصل برنامه (Xray)");
            }
            j.k("app");
            throw null;
        }
        TunnelStatus tunnelStatus = TunnelStatus.INSTANCE;
        int activeSocksPort = tunnelStatus.getActiveSocksPort();
        if (activeSocksPort <= 0 || !tunnelStatus.isActive()) {
            return null;
        }
        return new ArgoNet.Route(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, activeSocksPort)), "موتور وصل برنامه");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0080  */
    private final Row rowOf(Item item) {
        String ip0;
        String exitIp;
        Result result = results.get(item.getId());
        String strCcOf = ccOf(item);
        String id2 = item.getId();
        String kind = item.getKind();
        String host = item.getHost();
        int port = item.getPort();
        boolean user = item.getUser();
        String profile = item.getProfile();
        long v10 = item.getV0();
        Boolean boolValueOf = result != null ? Boolean.valueOf(result.getOk()) : null;
        boolean z10 = false;
        if (result != null && !result.getOk() && result.getFrozen()) {
            z10 = true;
        }
        Long lValueOf = (result == null || !result.getOk()) ? null : Long.valueOf(result.getMs());
        String error = "";
        if (j.a(strCcOf, "??")) {
            strCcOf = "";
        }
        if (result == null || (exitIp = result.getExitIp()) == null) {
            ip0 = item.getIp0();
        } else {
            ip0 = o.L0(exitIp) ? null : exitIp;
            if (ip0 == null) {
                ip0 = item.getIp0();
            }
        }
        String str = ip0;
        long at = result != null ? result.getAt() : 0L;
        if (result != null && !result.getOk()) {
            error = result.getError();
        }
        return new Row(id2, kind, host, port, user, profile, v10, boolValueOf, z10, lValueOf, strCcOf, str, at, error, result != null ? result.getFails() : 0, item.getSeen());
    }

    public static /* synthetic */ sd.j rows$default(ArgoPool argoPool, String str, String str2, String str3, String str4, int i, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = Psi.CrashTracebackLevelAll;
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        if ((i10 & 16) != 0) {
            i = 300;
        }
        int i11 = i;
        String str5 = str3;
        return argoPool.rows(str, str2, str5, str4, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable rows$lambda$118(Item it) {
        j.e(it, "it");
        return Integer.valueOf(rows$score(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable rows$lambda$119(Item it) {
        j.e(it, "it");
        Result result = results.get(it.getId());
        return Long.valueOf(result != null ? result.getMs() : Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable rows$lambda$120(Item it) {
        j.e(it, "it");
        return Long.valueOf(-it.getSeen());
    }

    private static final int rows$score(Item item) {
        Result result = results.get(item.getId());
        if (result != null && result.getOk()) {
            return 0;
        }
        if (result != null || item.getV0() <= 0) {
            return result == null ? 2 : 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> sampleV4(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i10 = 0; i10 < i; i10++) {
            List<String> list = CF_V4;
            int i11 = 1;
            List listA1 = o.a1(list.get(random.nextInt(list.size())), new char[]{'/'}, 6);
            String str = (String) listA1.get(0);
            String str2 = (String) listA1.get(1);
            List listA2 = o.a1(str, new char[]{'.'}, 6);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.s.g0(listA2, 10));
            Iterator it = listA2.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            }
            int iIntValue = (((Number) arrayList2.get(0)).intValue() << 24) | (((Number) arrayList2.get(1)).intValue() << 16) | (((Number) arrayList2.get(2)).intValue() << 8) | ((Number) arrayList2.get(3)).intValue();
            int iNextInt = random.nextInt(1 << (32 - Integer.parseInt(str2)));
            if (iNextInt >= 1) {
                i11 = iNextInt;
            }
            int i12 = iIntValue + i11;
            arrayList.add(((i12 >>> 24) & 255) + "." + ((i12 >>> 16) & 255) + "." + ((i12 >>> 8) & 255) + "." + (i12 & 255));
        }
        return q.s0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> sampleV6(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i10 = 0; i10 < i; i10++) {
            List<String> list = CF_V6;
            String str = list.get(i10 % list.size());
            ArrayList arrayList2 = new ArrayList(5);
            for (int i11 = 0; i11 < 5; i11++) {
                arrayList2.add(Integer.toHexString(random.nextInt(65536)));
            }
            arrayList.add(((Object) str) + ":" + q.F0(arrayList2, ":", null, null, null, 62));
        }
        return m9.d.I(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void savePrefs() {
        sf.c cVar = new sf.c();
        cVar.D("cleanIp", prefs.getCleanIp());
        cVar.E("autoClean", prefs.getAutoClean());
        sf.c cVar2 = cleanScan;
        if (cVar2 != null) {
            cVar.D("cleanScan", cVar2);
        }
        String string = cVar.toString();
        j.d(string, "toString(...)");
        writeJson("prefs.json", string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveSoon() {
        changed();
        if (saveQueued) {
            return;
        }
        saveQueued = true;
        m0.y(scope, null, null, new C03981(null), 3);
    }

    public static /* synthetic */ void scanCleanIps$default(ArgoPool argoPool, int i, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = 300;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        argoPool.scanCleanIps(i, z10);
    }

    private final synchronized List<Item> select(String str, String str2, List<String> list, boolean z10, boolean z11, boolean z12) {
        List listK1;
        try {
            Collection<Item> collectionValues = items.values();
            j.d(collectionValues, "<get-values>(...)");
            listK1 = q.k1(collectionValues);
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                Set setP1 = q.p1(list);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listK1) {
                    if (setP1.contains(((Item) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                listK1 = arrayList;
            }
            if (!j.a(str, Psi.CrashTracebackLevelAll)) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listK1) {
                    if (j.a(((Item) obj2).getKind(), str)) {
                        arrayList2.add(obj2);
                    }
                }
                listK1 = arrayList2;
            }
            if (!o.L0(str2)) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : listK1) {
                    Item item = (Item) obj3;
                    ArgoPool argoPool = INSTANCE;
                    j.b(item);
                    if (j.a(argoPool.ccOf(item), str2)) {
                        arrayList3.add(obj3);
                    }
                }
                listK1 = arrayList3;
            }
            if (z10) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : listK1) {
                    if (results.get(((Item) obj4).getId()) == null) {
                        arrayList4.add(obj4);
                    }
                }
                listK1 = arrayList4;
            }
            if (z11) {
                ArrayList arrayList5 = new ArrayList();
                for (Object obj5 : listK1) {
                    if (((Item) obj5).getV0() > 0) {
                        arrayList5.add(obj5);
                    }
                }
                listK1 = arrayList5;
            }
            if (z12) {
                ArrayList arrayList6 = new ArrayList();
                for (Object obj6 : listK1) {
                    Result result = results.get(((Item) obj6).getId());
                    if (result != null && !result.getOk()) {
                        arrayList6.add(obj6);
                    }
                }
                listK1 = arrayList6;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return q.b1(listK1, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$select$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return p.e(Long.valueOf(((ArgoPool.Item) t11).getSeen()), Long.valueOf(((ArgoPool.Item) t10).getSeen()));
            }
        });
    }

    public static /* synthetic */ Prefs setPrefs$default(ArgoPool argoPool, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        return argoPool.setPrefs(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Proxy socks(int i) {
        return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object speedThrough(String str, Item item, ArgoProtocol.SessionInfo sessionInfo, wd.d dVar) {
        return m0.J(v0.f24208c, new C04002(item, sessionInfo, str, null), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable summary$lambda$104(Group it) {
        j.e(it, "it");
        return Boolean.valueOf(j.a(it.getCc(), "??"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable summary$lambda$105(Group it) {
        j.e(it, "it");
        return Integer.valueOf(-it.getAlive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable summary$lambda$106(Group it) {
        j.e(it, "it");
        return Integer.valueOf(-it.getN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable summary$lambda$110(ArgoProtocol.FalconOrigin it) {
        j.e(it, "it");
        return it.getCc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable summary$lambda$111(ArgoProtocol.FalconOrigin it) {
        j.e(it, "it");
        return Double.valueOf(it.getLoad());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e7  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Page telegramPage(String str, Long l6, ArgoNet.Route route) throws UnsupportedEncodingException {
        String str2;
        Long lW0;
        long jLongValue;
        String str3;
        String str4;
        Object objM1004constructorimpl;
        sd.j jVarFetchText$default = ArgoNet.fetchText$default(ArgoNet.INSTANCE, w0.n("https://t.me/s/", URLEncoder.encode(str, "UTF-8"), l6 != null ? "?before=" + l6 : ""), route, GerehWatchdog.STUCK_MS, 0L, 8, null);
        int iIntValue = ((Number) jVarFetchText$default.component1()).intValue();
        String str5 = (String) jVarFetchText$default.component2();
        if (iIntValue != 200 || str5.length() == 0) {
            return new Page(false, iIntValue, kotlin.collections.w.INSTANCE);
        }
        List<String> listT0 = q.t0(o.b1(str5, new String[]{"tgme_widget_message_wrap"}, 6), 1);
        ArrayList arrayList = new ArrayList();
        for (String str6 : listT0) {
            Object post = null;
            kotlin.text.g gVarM = i.m("data-post=\"[^\"/]+/(\\d+)\"", str6, 0, 2, null);
            if (gVarM != null && (str2 = (String) ((f0) ((kotlin.text.i) gVarM).a()).get(1)) != null && (lW0 = v.w0(str2)) != null) {
                long jLongValue2 = lW0.longValue();
                kotlin.text.g gVarM2 = i.m("<time[^>]*datetime=\"([^\"]+)\"", str6, 0, 2, null);
                if (gVarM2 == null || (str4 = (String) ((f0) ((kotlin.text.i) gVarM2).a()).get(1)) == null) {
                    jLongValue = 0;
                } else {
                    try {
                        objM1004constructorimpl = sd.l.m1004constructorimpl(Long.valueOf(OffsetDateTime.parse(str4).toInstant().toEpochMilli()));
                    } catch (Throwable th2) {
                        objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
                    }
                    if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                        objM1004constructorimpl = null;
                    }
                    Long l10 = (Long) objM1004constructorimpl;
                    if (l10 != null) {
                        jLongValue = l10.longValue();
                    } else {
                        jLongValue = 0;
                    }
                }
                kotlin.text.g gVarM3 = i.m("<div class=\"tgme_widget_message_text[^\"]*\"[^>]*>([\\s\\S]*?)</div>", str6, 0, 2, null);
                if (gVarM3 != null && (str3 = (String) ((f0) ((kotlin.text.i) gVarM3).a()).get(1)) != null) {
                    post = INSTANCE.decodeHtml(str3);
                }
                post = new Post(jLongValue2, jLongValue, post == null ? "" : post);
            }
            if (post != null) {
                arrayList.add(post);
            }
        }
        return new Page(true, iIntValue, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x008e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0096  */
    /* JADX WARN: Code duplicated, block: B:20:0x00b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c7 A[PHI: r0 r1 r4 r8 r9 r10 r11 r12 r13 r15 r16
      0x00c7: PHI (r0v5 java.lang.String) = (r0v4 java.lang.String), (r0v8 java.lang.String) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r1v6 java.lang.Long) = (r1v4 java.lang.Long), (r1v8 java.lang.Long) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r4v6 com.mlmvpn.scanner.engines.argo.ArgoNet$Route) = (r4v4 com.mlmvpn.scanner.engines.argo.ArgoNet$Route), (r4v8 com.mlmvpn.scanner.engines.argo.ArgoNet$Route) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r8v4 ee.a) = (r8v2 ee.a), (r8v6 ee.a) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r9v4 com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1) = 
      (r9v2 com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1)
      (r9v6 com.mlmvpn.scanner.engines.argo.ArgoPool$telegramPageRetry$1)
     binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r10v7 int) = (r10v5 int), (r10v9 int) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r11v6 int) = (r11v4 int), (r11v9 int) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r12v3 long[]) = (r12v1 long[]), (r12v5 long[]) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r13v4 com.mlmvpn.scanner.engines.argo.ArgoPool$Page) = (r13v2 com.mlmvpn.scanner.engines.argo.ArgoPool$Page), (r13v7 com.mlmvpn.scanner.engines.argo.ArgoPool$Page) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r15v2 com.mlmvpn.scanner.engines.argo.ArgoPool) = (r15v1 com.mlmvpn.scanner.engines.argo.ArgoPool), (r15v3 com.mlmvpn.scanner.engines.argo.ArgoPool) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00c7: PHI (r16v1 long) = (r16v0 long), (r16v2 long) binds: [B:17:0x0094, B:22:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0094 -> B:23:0x00c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b1 -> B:22:0x00bc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object telegramPageRetry(java.lang.String r19, java.lang.Long r20, com.mlmvpn.scanner.engines.argo.ArgoNet.Route r21, ee.a r22, wd.d r23) {
        return ArgoPoolRecoveryBridge.recoverTelegramPageRetry(this, r19, r20, r21, r22, r23);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void test$default(ArgoPool argoPool, String str, String str2, List list, boolean z10, boolean z11, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Psi.CrashTracebackLevelAll;
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            z10 = false;
        }
        if ((i & 16) != 0) {
            z11 = false;
        }
        argoPool.test(str, str2, list, z10, z11, (i & 32) != 0 ? false : z12);
    }

    private final Source tg(String str) {
        return new Source(v0.a.h("tg:", str), "telegram", m9.d.B(str), v0.a.h("کانال تلگرام @", str), true, false, 0L, 96, null);
    }

    private final Long tlsPing(String str, String str2, int i) {
        Object objM1004constructorimpl;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getByName(str), ProtonStealth.PORT), i);
            socket.setSoTimeout(i);
            SocketFactory socketFactory = SSLSocketFactory.getDefault();
            j.c(socketFactory, "null cannot be cast to non-null type javax.net.ssl.SSLSocketFactory");
            Socket socketCreateSocket = ((SSLSocketFactory) socketFactory).createSocket(socket, str2, ProtonStealth.PORT, true);
            j.c(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            try {
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                sSLParameters.setServerNames(m9.d.B(new SNIHostName(str2)));
                sSLSocket.setSSLParameters(sSLParameters);
                sSLSocket.startHandshake();
                sSLSocket.close();
                objM1004constructorimpl = sd.l.m1004constructorimpl(Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    a.a.g(sSLSocket, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th4));
        }
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = null;
        }
        return (Long) objM1004constructorimpl;
    }

    public static /* synthetic */ Long tlsPing$default(ArgoPool argoPool, String str, String str2, int i, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i = 2500;
        }
        return argoPool.tlsPing(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Trace traceVia(int i) {
        Object objM1004constructorimpl;
        try {
            OkHttpClient okHttpClientClient = client(i, 15000L);
            Request.Builder builder = new Request.Builder();
            builder.j(TRACE_URL);
            Response responseD = okHttpClientClient.b(new Request(builder)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                String strW = responseBody != null ? responseBody.w() : null;
                String str = "";
                if (strW == null) {
                    strW = "";
                }
                boolean z10 = false;
                kotlin.text.g gVarFind$default = l.find$default(new l("(?m)^loc=([A-Z]{2})"), strW, 0, 2, null);
                String str2 = gVarFind$default != null ? (String) ((f0) ((kotlin.text.i) gVarFind$default).a()).get(1) : null;
                if (str2 == null) {
                    str2 = "";
                }
                kotlin.text.g gVarFind$default2 = l.find$default(new l("(?m)^ip=(\\S+)"), strW, 0, 2, null);
                String str3 = gVarFind$default2 != null ? (String) ((f0) ((kotlin.text.i) gVarFind$default2).a()).get(1) : null;
                if (str3 != null) {
                    str = str3;
                }
                if (responseD.A && str2.length() > 0) {
                    z10 = true;
                }
                Trace trace = new Trace(z10, str2, str);
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
        Trace trace2 = new Trace(false, null, null, 6, null);
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = trace2;
        }
        return (Trace) objM1004constructorimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(ArgoPool argoPool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        argoPool.update(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitPort(int i, long j, wd.d dVar) {
        C04041 c04041;
        ArgoPool argoPool;
        int i10;
        long jCurrentTimeMillis;
        Object objM1004constructorimpl;
        if (dVar instanceof C04041) {
            c04041 = (C04041) dVar;
            int i11 = c04041.label;
            if ((i11 & TLObject.FLAG_31) != 0) {
                c04041.label = i11 - TLObject.FLAG_31;
            } else {
                c04041 = new C04041(dVar);
            }
        } else {
            c04041 = new C04041(dVar);
        }
        Object obj = c04041.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i12 = c04041.label;
        if (i12 == 0) {
            m.b(obj);
            argoPool = this;
            i10 = i;
            jCurrentTimeMillis = System.currentTimeMillis() + j;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jCurrentTimeMillis = c04041.J$0;
            i10 = c04041.I$0;
            argoPool = (ArgoPool) c04041.L$0;
            m.b(obj);
        }
        do {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            u uVar = u.f67154a;
            if (jCurrentTimeMillis2 < jCurrentTimeMillis) {
                try {
                    Socket socket = new Socket();
                    try {
                        socket.connect(new InetSocketAddress(SniSession.LOCAL_HOST, i10), 300);
                        socket.close();
                        objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            a.a.g(socket, th2);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th4));
                }
                if (!sd.l.m1011isSuccessimpl(objM1004constructorimpl)) {
                    c04041.L$0 = argoPool;
                    c04041.I$0 = i10;
                    c04041.J$0 = jCurrentTimeMillis;
                    c04041.label = 1;
                }
            }
            return uVar;
        } while (m0.j(150L, c04041) != aVar);
        return aVar;
    }

    private final void writeJson(String str, String str2) {
        try {
            File file = dir;
            if (file == null) {
                j.k("dir");
                throw null;
            }
            File file2 = new File(file, str + ".tmp");
            ce.o.q0(file2, str2, kotlin.text.a.f23859a);
            File file3 = dir;
            if (file3 == null) {
                j.k("dir");
                throw null;
            }
            if (!file2.renameTo(new File(file3, str))) {
                File file4 = dir;
                if (file4 == null) {
                    j.k("dir");
                    throw null;
                }
                ce.o.q0(new File(file4, str), str2, kotlin.text.a.f23859a);
            }
            sd.l.m1004constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            sd.l.m1004constructorimpl(m.a(th2));
        }
    }

    public final synchronized Source addSource(String input) {
        sd.q qVar;
        String strConcat;
        Source source;
        try {
            j.e(input, "input");
            load();
            String string = o.n1(input).toString();
            if (string.length() <= 0) {
                throw new IllegalArgumentException("نشانی منبع خالی است");
            }
            kotlin.text.m mVar = kotlin.text.m.IGNORE_CASE;
            int i = 0;
            kotlin.text.g gVarFind$default = l.find$default(new l("^(?:@|(?:https?://)?(?:t\\.me|telegram\\.me)/(?:s/)?)([A-Za-z][A-Za-z0-9_]{3,31})(?:[/?#].*)?$", mVar), string, 0, 2, null);
            if (gVarFind$default != null) {
                kotlin.text.i iVar = (kotlin.text.i) gVarFind$default;
                qVar = new sd.q("telegram", ((f0) iVar.a()).get(1), "کانال تلگرام @" + ((f0) iVar.a()).get(1));
            } else if (new l("^[A-Za-z][A-Za-z0-9_]{4,31}$").matches(string)) {
                qVar = new sd.q("telegram", string, "کانال تلگرام @".concat(string));
            } else {
                if (!new l("^https?://\\S+$", mVar).matches(string)) {
                    throw new IllegalArgumentException("این نشانی شناخته نشد — نام کانال تلگرام (@name یا t.me/name) یا یک نشانی http(s) از گیت\u200cهاب یا هر سایتی بدهید");
                }
                qVar = new sd.q(XrayMeasureService.KEY_URL, string, new l("github\\.com|githubusercontent\\.com", mVar).containsMatchIn(string) ? "گیت\u200cهاب — ".concat(o.l1(60, new l("^https?://(raw\\.)?github(usercontent)?\\.com/", mVar).replace(string, ""))) : o.l1(70, new l("^https?://", mVar).replace(string, "")));
            }
            String str = (String) qVar.component1();
            String str2 = (String) qVar.component2();
            String str3 = (String) qVar.component3();
            if (j.a(str, "telegram")) {
                strConcat = "tg:" + str2;
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byte[] bytes = str2.getBytes(kotlin.text.a.f23859a);
                j.d(bytes, "getBytes(...)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                j.d(bArrDigest, "digest(...)");
                StringBuilder sb2 = new StringBuilder();
                sb2.append((CharSequence) "");
                int i10 = 0;
                for (byte b10 : bArrDigest) {
                    i10++;
                    if (i10 > 1) {
                        sb2.append((CharSequence) "");
                    }
                    sb2.append(addSource$lambda$61(b10));
                }
                sb2.append((CharSequence) "");
                strConcat = "u:".concat(o.l1(12, sb2.toString()));
            }
            String str4 = strConcat;
            ArrayList arrayListS0 = q.S0(BUILTIN, userSources);
            if (!arrayListS0.isEmpty()) {
                int size = arrayListS0.size();
                while (i < size) {
                    Object obj = arrayListS0.get(i);
                    i++;
                    if (v.m0(((Source) obj).getId(), str4)) {
                        throw new IllegalArgumentException("این منبع قبلاً اضافه شده است");
                    }
                }
            }
            source = new Source(str4, str, m9.d.B(str2), str3, false, true, System.currentTimeMillis());
            userSources.add(source);
            saveNow();
        } catch (Throwable th2) {
            throw th2;
        }
        return source;
    }

    public final String cleanIp() {
        load();
        return prefs.getCleanIp();
    }

    public final synchronized ArgoProtocol.Endpoint endpointFromRaw(String raw) {
        j.e(raw, "raw");
        load();
        ArgoProtocol argoProtocol = ArgoProtocol.INSTANCE;
        List<String> listExtractBridgeBlocks = argoProtocol.extractBridgeBlocks(raw);
        if (listExtractBridgeBlocks.isEmpty()) {
            List<String> listExtractFalconHosts = argoProtocol.extractFalconHosts(raw, true);
            if (listExtractFalconHosts.isEmpty()) {
                throw new IllegalArgumentException("نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن");
            }
            addItem$default(this, "falcon", listExtractFalconHosts.get(0), ProtonStealth.PORT, "A", "user", System.currentTimeMillis(), true, null, 128, null);
            saveSoon();
            Item item = items.get(idOf("falcon", listExtractFalconHosts.get(0), ProtonStealth.PORT));
            j.b(item);
            return endpointOf(item);
        }
        ArgoProtocol.Bridge bridgeDecodeBridgeBlock = argoProtocol.decodeBridgeBlock(listExtractBridgeBlocks.get(0));
        if (!bridgeDecodeBridgeBlock.getSigOk()) {
            throw new IllegalArgumentException("امضای این بلاک پل معتبر نیست — بلاک ناقص کپی شده یا ساختگی است");
        }
        addItem$default(this, "bridge", bridgeDecodeBridgeBlock.getHost(), bridgeDecodeBridgeBlock.getPort(), bridgeDecodeBridgeBlock.getProtocol(), "user", System.currentTimeMillis(), true, null, 128, null);
        saveSoon();
        Item item2 = items.get(idOf("bridge", bridgeDecodeBridgeBlock.getHost(), bridgeDecodeBridgeBlock.getPort()));
        j.b(item2);
        return endpointOf(item2);
    }

    public final synchronized ArgoProtocol.Endpoint get(String id2) {
        Item item;
        j.e(id2, "id");
        load();
        item = items.get(id2);
        return item != null ? INSTANCE.endpointOf(item) : null;
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

    public final synchronized sd.j importFromChat(String text) throws Throwable {
        Throwable th2;
        try {
            j.e(text, "text");
            load();
            try {
                Absorbed absorbedAbsorbText = absorbText(text, "user", System.currentTimeMillis(), true, true);
                saveNow();
                Parsed parsed = parse(text);
                List<ParsedBridge> bridges = parsed.getBridges();
                ArrayList arrayList = new ArrayList();
                for (Object obj : bridges) {
                    try {
                        ParsedBridge parsedBridge = (ParsedBridge) obj;
                        if (parsedBridge.getSigOk() && !o.L0(parsedBridge.getHost())) {
                            arrayList.add(obj);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.s.g0(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    ParsedBridge parsedBridge2 = (ParsedBridge) obj2;
                    arrayList2.add(INSTANCE.idOf("bridge", parsedBridge2.getHost(), parsedBridge2.getPort()));
                }
                List<String> falcons = parsed.getFalcons();
                ArrayList arrayList3 = new ArrayList(kotlin.collections.s.g0(falcons, 10));
                Iterator<T> it = falcons.iterator();
                while (it.hasNext()) {
                    arrayList3.add(INSTANCE.idOf("falcon", (String) it.next(), ProtonStealth.PORT));
                }
                List listS0 = q.s0(q.S0(arrayList2, arrayList3));
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : listS0) {
                    if (items.containsKey((String) obj3)) {
                        arrayList4.add(obj3);
                    }
                }
                if (!arrayList4.isEmpty()) {
                    try {
                        test$default(this, null, null, arrayList4, false, false, false, 59, null);
                        sd.l.m1004constructorimpl(u.f67154a);
                    } catch (Throwable th4) {
                        sd.l.m1004constructorimpl(m.a(th4));
                    }
                }
                return new sd.j(absorbedAbsorbText, arrayList4);
            } catch (Throwable th5) {
                th = th5;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final synchronized Absorbed importText(String text) throws Throwable {
        try {
            try {
                j.e(text, "text");
                load();
                Absorbed absorbedAbsorbText = absorbText(text, "user", System.currentTimeMillis(), true, true);
                saveNow();
                return absorbedAbsorbText;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            throw th;
        }
    }

    public final void init(Context context) {
        j.e(context, "context");
        if (app != null) {
            return;
        }
        app = context.getApplicationContext();
        Context context2 = app;
        if (context2 == null) {
            j.k("app");
            throw null;
        }
        File file = new File(context2.getFilesDir(), "argo");
        file.mkdirs();
        dir = file;
    }

    public final boolean isIpLiteral(String str) {
        Object objM1004constructorimpl;
        String strO1 = o.o1(i.h(str, "s", str), '[', ']');
        if (IPV4_LITERAL.matches(strO1)) {
            return true;
        }
        if (!o.z0(strO1, ':') || !i.B("^[0-9A-Fa-f:.]+$", strO1)) {
            return false;
        }
        try {
            objM1004constructorimpl = sd.l.m1004constructorimpl(Boolean.valueOf(InetAddress.getByName(strO1) instanceof Inet6Address));
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = bool;
        }
        return ((Boolean) objM1004constructorimpl).booleanValue();
    }

    public final Parsed parse(String text) {
        ParsedBridge parsedBridge;
        j.e(text, "text");
        List<String> listExtractBridgeBlocks = ArgoProtocol.INSTANCE.extractBridgeBlocks(text);
        ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(listExtractBridgeBlocks, 10));
        Iterator<T> it = listExtractBridgeBlocks.iterator();
        while (it.hasNext()) {
            try {
                ArgoProtocol.Bridge bridgeDecodeBridgeBlock = ArgoProtocol.INSTANCE.decodeBridgeBlock((String) it.next());
                parsedBridge = new ParsedBridge(bridgeDecodeBridgeBlock.getHost(), bridgeDecodeBridgeBlock.getPort(), bridgeDecodeBridgeBlock.getSigOk(), null, 8, null);
            } catch (Throwable th2) {
                String message = th2.getMessage();
                if (message == null) {
                    message = "بلاک پل خوانده نشد";
                }
                parsedBridge = new ParsedBridge("", ProtonStealth.PORT, false, message);
            }
            arrayList.add(parsedBridge);
        }
        return new Parsed(arrayList, ArgoProtocol.INSTANCE.extractFalconHosts(new l("-+\\s*BEGIN ARGO VPN BRIDGE BLOCK[\\s\\S]*?END ARGO VPN BRIDGE BLOCK\\s*-+", kotlin.text.m.IGNORE_CASE).replace(text, ""), true));
    }

    public final synchronized List<ArgoProtocol.Endpoint> pick(int i) {
        ArrayList arrayList;
        try {
            load();
            Collection<Item> collectionValues = items.values();
            j.d(collectionValues, "<get-values>(...)");
            List listK1 = q.k1(collectionValues);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listK1) {
                Result result = results.get(((Item) obj).getId());
                if (result != null && result.getOk()) {
                    arrayList2.add(obj);
                }
            }
            List listB1 = q.b1(arrayList2, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    Object obj2 = ArgoPool.results.get(((ArgoPool.Item) t10).getId());
                    j.b(obj2);
                    Long lValueOf = Long.valueOf(((ArgoPool.Result) obj2).getMs());
                    Object obj3 = ArgoPool.results.get(((ArgoPool.Item) t11).getId());
                    j.b(obj3);
                    return p.e(lValueOf, Long.valueOf(((ArgoPool.Result) obj3).getMs()));
                }
            });
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listK1) {
                Item item = (Item) obj2;
                if (results.get(item.getId()) == null && item.getV0() > 0) {
                    arrayList3.add(obj2);
                }
            }
            List listB2 = q.b1(arrayList3, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return p.e(Long.valueOf(((ArgoPool.Item) t11).getV0()), Long.valueOf(((ArgoPool.Item) t10).getV0()));
                }
            });
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : listK1) {
                Item item2 = (Item) obj3;
                if (results.get(item2.getId()) == null && item2.getV0() == 0 && !j.a(item2.getKind(), "falcon")) {
                    arrayList4.add(obj3);
                }
            }
            List<Item> listE1 = q.e1(q.S0(q.S0(listB1, listB2), q.b1(arrayList4, new Comparator() { // from class: com.mlmvpn.scanner.engines.argo.ArgoPool$pick$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return p.e(Long.valueOf(((ArgoPool.Item) t11).getSeen()), Long.valueOf(((ArgoPool.Item) t10).getSeen()));
                }
            })), i);
            arrayList = new ArrayList(kotlin.collections.s.g0(listE1, 10));
            for (Item item3 : listE1) {
                ArgoPool argoPool = INSTANCE;
                j.b(item3);
                arrayList.add(argoPool.endpointOf(item3));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public final synchronized void record(String id2, boolean z10, long j, String cc2, String exitIp, String error, boolean z11, String edge) {
        String str;
        try {
            j.e(id2, "id");
            j.e(cc2, "cc");
            j.e(exitIp, "exitIp");
            j.e(error, "error");
            j.e(edge, "edge");
            load();
            HashMap<String, Result> map = results;
            Result result = map.get(id2);
            if (z10 || !o.L0(cc2)) {
                str = cc2;
            } else {
                String cc3 = result != null ? result.getCc() : null;
                if (cc3 == null) {
                    cc3 = "";
                }
                str = cc3;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            int fails = 0;
            if (!z10) {
                fails = (result != null ? result.getFails() : 0) + 1;
            }
            map.put(id2, new Result(z10, j, str, exitIp, jCurrentTimeMillis, fails, error, z11, edge));
            saveSoon();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized int remove(List<String> ids) {
        int i;
        try {
            j.e(ids, "ids");
            load();
            i = 0;
            for (String str : ids) {
                if (items.remove(str) != null) {
                    results.remove(str);
                    i++;
                }
            }
            saveNow();
        } catch (Throwable th2) {
            throw th2;
        }
        return i;
    }

    public final synchronized int removeDead() {
        ArrayList arrayList;
        try {
            load();
            Collection<Item> collectionValues = items.values();
            j.d(collectionValues, "<get-values>(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : collectionValues) {
                Result result = results.get(((Item) obj).getId());
                if (result != null && !result.getOk() && result.getFails() >= 3) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList(kotlin.collections.s.g0(arrayList2, 10));
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                arrayList.add(((Item) obj2).getId());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return remove(arrayList);
    }

    public final synchronized boolean removeSource(final String id2) {
        boolean zV0;
        j.e(id2, "id");
        load();
        zV0 = q.V0(new ee.c() { // from class: com.mlmvpn.scanner.engines.argo.c
            @Override // ee.c
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ArgoPool.removeSource$lambda$64(id2, (ArgoPool.Source) obj));
            }
        }, userSources);
        sourceState.remove(id2);
        saveNow();
        return zV0;
    }

    public final synchronized sd.j rows(String kind, String cc2, String q10, String only, int i) {
        ArrayList arrayList;
        Integer numValueOf;
        ArrayList arrayList2;
        try {
            j.e(kind, "kind");
            j.e(cc2, "cc");
            j.e(q10, "q");
            j.e(only, "only");
            load();
            Collection<Item> collectionValues = items.values();
            j.d(collectionValues, "<get-values>(...)");
            List listK1 = q.k1(collectionValues);
            if (!kind.equals(Psi.CrashTracebackLevelAll)) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : listK1) {
                    if (j.a(((Item) obj).getKind(), kind)) {
                        arrayList3.add(obj);
                    }
                }
                listK1 = arrayList3;
            }
            if (!o.L0(cc2)) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : listK1) {
                    Item item = (Item) obj2;
                    ArgoPool argoPool = INSTANCE;
                    j.b(item);
                    if (j.a(argoPool.ccOf(item), cc2)) {
                        arrayList4.add(obj2);
                    }
                }
                listK1 = arrayList4;
            }
            int iHashCode = only.hashCode();
            int i10 = 1;
            if (iHashCode != -1994383672) {
                if (iHashCode != 3599307) {
                    if (iHashCode == 92903629 && only.equals("alive")) {
                        arrayList = new ArrayList();
                        for (Object obj3 : listK1) {
                            Result result = results.get(((Item) obj3).getId());
                            if (result != null && result.getOk()) {
                                arrayList.add(obj3);
                            }
                        }
                        listK1 = arrayList;
                    }
                } else if (only.equals("user")) {
                    arrayList = new ArrayList();
                    for (Object obj4 : listK1) {
                        if (((Item) obj4).getUser()) {
                            arrayList.add(obj4);
                        }
                    }
                    listK1 = arrayList;
                }
            } else if (only.equals("verified")) {
                arrayList = new ArrayList();
                for (Object obj5 : listK1) {
                    if (((Item) obj5).getV0() > 0) {
                        arrayList.add(obj5);
                    }
                }
                listK1 = arrayList;
            }
            String lowerCase = o.n1(q10).toString().toLowerCase(Locale.ROOT);
            j.d(lowerCase, "toLowerCase(...)");
            if (lowerCase.length() > 0) {
                ArrayList arrayList5 = new ArrayList();
                for (Object obj6 : listK1) {
                    if (o.y0(((Item) obj6).getHost(), lowerCase, false)) {
                        arrayList5.add(obj6);
                    }
                }
                listK1 = arrayList5;
            }
            List listB1 = q.b1(listK1, p.d(new d(i10), new d(4), new d(5)));
            numValueOf = Integer.valueOf(listB1.size());
            List<Item> listE1 = q.e1(listB1, com.google.android.gms.internal.mlkit_language_id_common.j.d(i, 1, 2000));
            arrayList2 = new ArrayList(kotlin.collections.s.g0(listE1, 10));
            for (Item item2 : listE1) {
                ArgoPool argoPool2 = INSTANCE;
                j.b(item2);
                arrayList2.add(argoPool2.rowOf(item2));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return new sd.j(numValueOf, arrayList2);
    }

    public final synchronized void saveNow() {
        try {
            if (loaded) {
                Collection<Item> collectionValues = items.values();
                j.d(collectionValues, "<get-values>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    if (!j.a(((Item) obj).getSrc(), "bundled")) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.s.g0(arrayList, 10));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    Item item = (Item) obj2;
                    ArgoPool argoPool = INSTANCE;
                    j.b(item);
                    arrayList2.add(argoPool.itemJson(item));
                }
                String string = new sf.a((Collection) arrayList2).toString();
                j.d(string, "toString(...)");
                writeJson("pool.json", string);
                sf.c cVar = new sf.c();
                for (Map.Entry<String, Result> entry : results.entrySet()) {
                    cVar.D(entry.getKey(), INSTANCE.resultJson(entry.getValue()));
                }
                String string2 = cVar.toString();
                j.d(string2, "toString(...)");
                writeJson("results.json", string2);
                sf.c cVar2 = new sf.c();
                List<Source> list = userSources;
                ArrayList arrayList3 = new ArrayList(kotlin.collections.s.g0(list, 10));
                for (Source source : list) {
                    sf.c cVar3 = new sf.c();
                    cVar3.D(XrayCoreHostService.KEY_ID, source.getId());
                    cVar3.D(TeXSymbolParser.TYPE_ATTR, source.getType());
                    cVar3.D("value", q.y0(source.getValue()));
                    cVar3.D("label", source.getLabel());
                    cVar3.D("addedAt", Long.valueOf(source.getAddedAt()));
                    arrayList3.add(cVar3);
                }
                cVar2.D("list", new sf.a((Collection) arrayList3));
                sf.c cVar4 = new sf.c();
                for (Map.Entry<String, sf.c> entry2 : sourceState.entrySet()) {
                    cVar4.D(entry2.getKey(), entry2.getValue());
                }
                cVar2.D("state", cVar4);
                String string3 = cVar2.toString();
                j.d(string3, "toString(...)");
                writeJson("sources.json", string3);
                savePrefs();
                changed();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void scanCleanIps(int i, boolean z10) {
        load();
        IpScan ipScan2 = ipScan;
        if (ipScan2 != null && ipScan2.getRunning()) {
            throw new IllegalStateException("اسکن آی\u200cپی تمیز در حال اجراست");
        }
        Job job = testJob;
        if (job != null && job.getRunning()) {
            throw new IllegalStateException("اول سنجش فهرست تمام شود");
        }
        List<Item> listRefHosts = refHosts(3);
        if (listRefHosts.isEmpty()) {
            throw new IllegalStateException("هیچ سرور آرگویی برای اسکن نیست — اول «به\u200cروزرسانی» را بزنید");
        }
        scanCancel = false;
        ipScan = new IpScan(true, "tls", 0, 0, kotlin.collections.w.INSTANCE, listRefHosts.get(0).getHost(), null, null, 0L, 448, null);
        changed();
        m0.y(scope, null, null, new C03991(i, z10, listRefHosts, null), 3);
    }

    public final synchronized Prefs setPrefs(String str, Boolean bool) {
        try {
            load();
            if (str != null) {
                String strO1 = o.o1(o.n1(str).toString(), '[', ']');
                if (strO1.length() != 0 && !isIpLiteral(strO1)) {
                    throw new IllegalArgumentException("آی\u200cپی تمیز معتبر نیست");
                }
                prefs = Prefs.copy$default(prefs, strO1, false, 2, null);
            }
            if (bool != null) {
                prefs = Prefs.copy$default(prefs, null, bool.booleanValue(), 1, null);
            }
            savePrefs();
            changed();
        } catch (Throwable th2) {
            throw th2;
        }
        return prefs;
    }

    public final synchronized void setSourceOn(String id2, boolean z10) {
        try {
            j.e(id2, "id");
            load();
            HashMap<String, sf.c> map = sourceState;
            sf.c cVar = map.get(id2);
            if (cVar == null) {
                cVar = new sf.c();
                map.put(id2, cVar);
            }
            cVar.E("on", z10);
            saveNow();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized List<SourceView> sources() {
        ArrayList arrayList;
        int size;
        try {
            load();
            ArrayList arrayListS0 = q.S0(BUILTIN, userSources);
            arrayList = new ArrayList(kotlin.collections.s.g0(arrayListS0, 10));
            int size2 = arrayListS0.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayListS0.get(i);
                i++;
                Source source = (Source) obj;
                sf.c cVar = sourceState.get(source.getId());
                if (j.a(source.getType(), "falcon-servers")) {
                    size = falconServers.size();
                } else {
                    Collection<Item> collectionValues = items.values();
                    j.d(collectionValues, "<get-values>(...)");
                    Collection<Item> collection = collectionValues;
                    if ((collection instanceof Collection) && collection.isEmpty()) {
                        size = 0;
                    } else {
                        int i10 = 0;
                        for (Item item : collection) {
                            if (j.a(item.getSrc(), source.getId()) || j.a(item.getFrom(), source.getId())) {
                                i10++;
                                if (i10 < 0) {
                                    r.e0();
                                    throw null;
                                }
                            }
                        }
                        size = i10;
                    }
                }
                boolean zQ = cVar != null ? cVar.q("on", true) : true;
                long jX = cVar != null ? cVar.x(0L, "at") : 0L;
                int iT = cVar != null ? cVar.t(0, "found") : 0;
                String strA = cVar != null ? cVar.A("error", "") : null;
                if (strA == null) {
                    strA = "";
                }
                arrayList.add(new SourceView(source, zQ, jX, iT, size, strA));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
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
        int i;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long jMax;
        List listB1;
        List<CleanIp> arrayList;
        sf.a aVarV;
        try {
            load();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            i = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            jMax = 0;
            for (Item item : items.values()) {
                j.d(item, "next(...)");
                Item item2 = item;
                String kind = item2.getKind();
                if (j.a(kind, "bridge")) {
                    i++;
                } else if (j.a(kind, "falcon")) {
                    i10++;
                } else {
                    i11++;
                }
                if (item2.getV0() > 0) {
                    i14++;
                    jMax = Math.max(jMax, item2.getV0());
                }
                Result result = results.get(item2.getId());
                if (result != null) {
                    i13++;
                }
                if (result != null && result.getOk()) {
                    i12++;
                }
                String strCcOf = ccOf(item2);
                Object obj = linkedHashMap.get(strCcOf);
                if (obj == null) {
                    Group group = new Group(INSTANCE.ccOf(item2), 0, 0, null, 0, 0, 0, 126, null);
                    linkedHashMap.put(strCcOf, group);
                    obj = group;
                }
                Group group2 = (Group) obj;
                group2.setN(group2.getN() + 1);
                String kind2 = item2.getKind();
                if (j.a(kind2, "bridge")) {
                    group2.setBridge(group2.getBridge() + 1);
                } else if (j.a(kind2, "falcon")) {
                    group2.setFalcon(group2.getFalcon() + 1);
                } else {
                    group2.setPublic(group2.getPublic() + 1);
                }
                if (result != null && result.getOk()) {
                    group2.setAlive(group2.getAlive() + 1);
                    if (group2.getBest() != null) {
                        long ms = result.getMs();
                        Long best = group2.getBest();
                        j.b(best);
                        if (ms < best.longValue()) {
                        }
                    }
                    group2.setBest(Long.valueOf(result.getMs()));
                }
            }
            long j = 0;
            Collection collectionValues = linkedHashMap.values();
            j.d(collectionValues, "<get-values>(...)");
            listB1 = q.b1(collectionValues, p.d(new d(6), new d(7), new d(8)));
            sf.c cVar = cleanScan;
            if (cVar == null || (aVarV = cVar.v("list")) == null) {
                arrayList = null;
            } else {
                h hVarJ = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, aVarV.f67155a.size());
                ArrayList arrayList2 = new ArrayList();
                g gVarA = hVarJ.iterator();
                while (gVarA.f23130c) {
                    sf.c cVarQ = aVarV.q(gVarA.nextInt());
                    if (cVarQ != null) {
                        arrayList2.add(cVarQ);
                    }
                }
                arrayList = new ArrayList(kotlin.collections.s.g0(arrayList2, 10));
                int size = arrayList2.size();
                int i15 = 0;
                while (i15 < size) {
                    Object obj2 = arrayList2.get(i15);
                    i15++;
                    sf.c cVar2 = (sf.c) obj2;
                    String strA = cVar2.A("ip", "");
                    j.d(strA, "optString(...)");
                    int i16 = size;
                    long j10 = j;
                    long jX = cVar2.x(j10, "tls");
                    long jX2 = cVar2.x(j10, "auth");
                    long jX3 = cVar2.x(j10, "kbps");
                    String strA2 = cVar2.A("loc", "");
                    j.d(strA2, "optString(...)");
                    arrayList.add(new CleanIp(strA, jX, jX2, jX3, strA2));
                    arrayList2 = arrayList2;
                    size = i16;
                    j = 0;
                }
            }
            if (arrayList == null) {
                arrayList = kotlin.collections.w.INSTANCE;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return new Summary(new Counts(i, i10, i11, items.size(), i12, i13, i14, jMax), listB1, prefs, arrayList, falconServers.size(), q.b1(falconServers, p.d(new d(9), new d(10))));
    }

    public final void test(String kind, String cc2, List<String> list, boolean z10, boolean z11, boolean z12) {
        String str;
        String str2 = "kind";
        j.e(kind, "kind");
        j.e(cc2, "cc");
        load();
        Job job = testJob;
        if (job != null && job.getRunning()) {
            throw new IllegalStateException("یک سنجش در حال اجراست");
        }
        IpScan ipScan2 = ipScan;
        if (ipScan2 != null && ipScan2.getRunning()) {
            throw new IllegalStateException("اول اسکن آی\u200cپی تمیز تمام شود");
        }
        List<Item> listSelect = select(kind, cc2, list, z10, z11, z12);
        if (listSelect.isEmpty()) {
            throw new IllegalStateException("موردی برای سنجش نیست");
        }
        testCancel = false;
        String cleanIp = prefs.getCleanIp();
        if (z11) {
            str2 = "verified";
        } else if (!o.L0(cc2)) {
            str2 = TunnelVpnService.EXTRA_COUNTRY;
        } else {
            if (list == null) {
                if (kind.equals(Psi.CrashTracebackLevelAll)) {
                    str = Psi.CrashTracebackLevelAll;
                }
                testJob = new Job(true, 0, listSelect.size(), 0, 0, null, 0, null, null, 0L, str, cc2, kind, 1016, null);
                changed();
                m0.y(scope, null, null, new C04021(listSelect, cleanIp, null), 3);
            }
            str2 = "ids";
        }
        str = str2;
        testJob = new Job(true, 0, listSelect.size(), 0, 0, null, 0, null, null, 0L, str, cc2, kind, 1016, null);
        changed();
        m0.y(scope, null, null, new C04021(listSelect, cleanIp, null), 3);
    }

    public final void update(List<String> list) {
        String label;
        load();
        Job job = updateJob;
        if (job == null || !job.getRunning()) {
            List<SourceView> listSources = sources();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSources) {
                SourceView sourceView = (SourceView) obj;
                if (list != null ? list.contains(sourceView.getSrc().getId()) : sourceView.getOn()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(kotlin.collections.s.g0(arrayList, 10));
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                arrayList2.add(((SourceView) obj2).getSrc());
            }
            updateCancel = false;
            ArgoNet.Route routeRouteNow = routeNow();
            int size2 = arrayList2.size();
            if (routeRouteNow == null || (label = routeRouteNow.getLabel()) == null) {
                label = "مستقیم (بدون تونل)";
            }
            updateJob = new Job(true, 0, size2, 0, 0, null, 0, null, label, 0L, null, null, null, 7928, null);
            changed();
            m0.y(scope, null, null, new C04031(arrayList2, routeRouteNow, null), 3);
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

        public Job(boolean z10, int i, int i10, int i11, int i12, String label, int i13, List<String> errors, String via, long j, String kind, String cc2, String what) {
            j.e(label, "label");
            j.e(errors, "errors");
            j.e(via, "via");
            j.e(kind, "kind");
            j.e(cc2, "cc");
            j.e(what, "what");
            this.running = z10;
            this.done = i;
            this.total = i10;
            this.alive = i11;
            this.frozen = i12;
            this.label = label;
            this.found = i13;
            this.errors = errors;
            this.via = via;
            this.endedAt = j;
            this.kind = kind;
            this.f11202cc = cc2;
            this.what = what;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Job copy$default(Job job, boolean z10, int i, int i10, int i11, int i12, String str, int i13, List list, String str2, long j, String str3, String str4, String str5, int i14, Object obj) {
            return job.copy((i14 & 1) != 0 ? job.running : z10, (i14 & 2) != 0 ? job.done : i, (i14 & 4) != 0 ? job.total : i10, (i14 & 8) != 0 ? job.alive : i11, (i14 & 16) != 0 ? job.frozen : i12, (i14 & 32) != 0 ? job.label : str, (i14 & 64) != 0 ? job.found : i13, (i14 & 128) != 0 ? job.errors : list, (i14 & 256) != 0 ? job.via : str2, (i14 & 512) != 0 ? job.endedAt : j, (i14 & 1024) != 0 ? job.kind : str3, (i14 & 2048) != 0 ? job.f11202cc : str4, (i14 & 4096) != 0 ? job.what : str5);
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

        public final Job copy(boolean z10, int i, int i10, int i11, int i12, String label, int i13, List<String> errors, String via, long j, String kind, String cc2, String what) {
            j.e(label, "label");
            j.e(errors, "errors");
            j.e(via, "via");
            j.e(kind, "kind");
            j.e(cc2, "cc");
            j.e(what, "what");
            return new Job(z10, i, i10, i11, i12, label, i13, errors, via, j, kind, cc2, what);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Job)) {
                return false;
            }
            Job job = (Job) obj;
            return this.running == job.running && this.done == job.done && this.total == job.total && this.alive == job.alive && this.frozen == job.frozen && j.a(this.label, job.label) && this.found == job.found && j.a(this.errors, job.errors) && j.a(this.via, job.via) && this.endedAt == job.endedAt && j.a(this.kind, job.kind) && j.a(this.f11202cc, job.f11202cc) && j.a(this.what, job.what);
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
            return this.what.hashCode() + s.d(s.d(w0.c(s.d(androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.c(this.found, s.d(androidx.compose.foundation.interaction.f.c(this.frozen, androidx.compose.foundation.interaction.f.c(this.alive, androidx.compose.foundation.interaction.f.c(this.total, androidx.compose.foundation.interaction.f.c(this.done, Boolean.hashCode(this.running) * 31, 31), 31), 31), 31), 31, this.label), 31), 31, this.errors), 31, this.via), 31, this.endedAt), 31, this.kind), 31, this.f11202cc);
        }

        public String toString() {
            boolean z10 = this.running;
            int i = this.done;
            int i10 = this.total;
            int i11 = this.alive;
            int i12 = this.frozen;
            String str = this.label;
            int i13 = this.found;
            List<String> list = this.errors;
            String str2 = this.via;
            long j = this.endedAt;
            String str3 = this.kind;
            String str4 = this.f11202cc;
            String str5 = this.what;
            StringBuilder sb2 = new StringBuilder("Job(running=");
            sb2.append(z10);
            sb2.append(", done=");
            sb2.append(i);
            sb2.append(", total=");
            s.v(sb2, i10, ", alive=", i11, ", frozen=");
            d1.n(i12, ", label=", str, ", found=", sb2);
            sb2.append(i13);
            sb2.append(", errors=");
            sb2.append(list);
            sb2.append(", via=");
            s.q(j, str2, ", endedAt=", sb2);
            d1.x(sb2, ", kind=", str3, ", cc=", str4);
            return androidx.compose.foundation.interaction.f.r(", what=", str5, ")", sb2);
        }

        public Job(boolean z10, int i, int i10, int i11, int i12, String str, int i13, List list, String str2, long j, String str3, String str4, String str5, int i14, kotlin.jvm.internal.e eVar) {
            this(z10, i, i10, (i14 & 8) != 0 ? 0 : i11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? "" : str, (i14 & 64) != 0 ? 0 : i13, (i14 & 128) != 0 ? kotlin.collections.w.INSTANCE : list, (i14 & 256) != 0 ? "" : str2, (i14 & 512) != 0 ? 0L : j, (i14 & 1024) != 0 ? Psi.CrashTracebackLevelAll : str3, (i14 & 2048) != 0 ? "" : str4, (i14 & 4096) != 0 ? Psi.CrashTracebackLevelAll : str5);
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

        public Summary(Counts counts, List list, Prefs prefs, List list2, int i, List list3, int i10, kotlin.jvm.internal.e eVar) {
            this(counts, list, prefs, list2, i, (i10 & 32) != 0 ? kotlin.collections.w.INSTANCE : list3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Summary copy$default(Summary summary, Counts counts, List list, Prefs prefs, List list2, int i, List list3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                counts = summary.counts;
            }
            if ((i10 & 2) != 0) {
                list = summary.groups;
            }
            if ((i10 & 4) != 0) {
                prefs = summary.prefs;
            }
            if ((i10 & 8) != 0) {
                list2 = summary.cleanList;
            }
            if ((i10 & 16) != 0) {
                i = summary.falconServers;
            }
            if ((i10 & 32) != 0) {
                list3 = summary.falconList;
            }
            int i11 = i;
            List list4 = list3;
            return summary.copy(counts, list, prefs, list2, i11, list4);
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

        public final Summary copy(Counts counts, List<Group> groups, Prefs prefs, List<CleanIp> cleanList, int i, List<ArgoProtocol.FalconOrigin> falconList) {
            j.e(counts, "counts");
            j.e(groups, "groups");
            j.e(prefs, "prefs");
            j.e(cleanList, "cleanList");
            j.e(falconList, "falconList");
            return new Summary(counts, groups, prefs, cleanList, i, falconList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            return j.a(this.counts, summary.counts) && j.a(this.groups, summary.groups) && j.a(this.prefs, summary.prefs) && j.a(this.cleanList, summary.cleanList) && this.falconServers == summary.falconServers && j.a(this.falconList, summary.falconList);
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
            return this.falconList.hashCode() + androidx.compose.foundation.interaction.f.c(this.falconServers, androidx.compose.foundation.interaction.f.f((this.prefs.hashCode() + androidx.compose.foundation.interaction.f.f(this.counts.hashCode() * 31, 31, this.groups)) * 31, 31, this.cleanList), 31);
        }

        public String toString() {
            return "Summary(counts=" + this.counts + ", groups=" + this.groups + ", prefs=" + this.prefs + ", cleanList=" + this.cleanList + ", falconServers=" + this.falconServers + ", falconList=" + this.falconList + ")";
        }

        public Summary(Counts counts, List<Group> groups, Prefs prefs, List<CleanIp> cleanList, int i, List<ArgoProtocol.FalconOrigin> falconList) {
            j.e(counts, "counts");
            j.e(groups, "groups");
            j.e(prefs, "prefs");
            j.e(cleanList, "cleanList");
            j.e(falconList, "falconList");
            this.counts = counts;
            this.groups = groups;
            this.prefs = prefs;
            this.cleanList = cleanList;
            this.falconServers = i;
            this.falconList = falconList;
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

        public Item(String id2, String kind, String host, int i, String protocol, String src, String from, long j, boolean z10, String profile, String cc0, long j10, String ip0) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(protocol, "protocol");
            j.e(src, "src");
            j.e(from, "from");
            j.e(profile, "profile");
            j.e(cc0, "cc0");
            j.e(ip0, "ip0");
            this.f11200id = id2;
            this.kind = kind;
            this.host = host;
            this.port = i;
            this.protocol = protocol;
            this.src = src;
            this.from = from;
            this.seen = j;
            this.user = z10;
            this.profile = profile;
            this.cc0 = cc0;
            this.f11201v0 = j10;
            this.ip0 = ip0;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, int i, String str4, String str5, String str6, long j, boolean z10, String str7, String str8, long j10, String str9, int i10, Object obj) {
            return item.copy((i10 & 1) != 0 ? item.f11200id : str, (i10 & 2) != 0 ? item.kind : str2, (i10 & 4) != 0 ? item.host : str3, (i10 & 8) != 0 ? item.port : i, (i10 & 16) != 0 ? item.protocol : str4, (i10 & 32) != 0 ? item.src : str5, (i10 & 64) != 0 ? item.from : str6, (i10 & 128) != 0 ? item.seen : j, (i10 & 256) != 0 ? item.user : z10, (i10 & 512) != 0 ? item.profile : str7, (i10 & 1024) != 0 ? item.cc0 : str8, (i10 & 2048) != 0 ? item.f11201v0 : j10, (i10 & 4096) != 0 ? item.ip0 : str9);
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

        public final Item copy(String id2, String kind, String host, int i, String protocol, String src, String from, long j, boolean z10, String profile, String cc0, long j10, String ip0) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(protocol, "protocol");
            j.e(src, "src");
            j.e(from, "from");
            j.e(profile, "profile");
            j.e(cc0, "cc0");
            j.e(ip0, "ip0");
            return new Item(id2, kind, host, i, protocol, src, from, j, z10, profile, cc0, j10, ip0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return j.a(this.f11200id, item.f11200id) && j.a(this.kind, item.kind) && j.a(this.host, item.host) && this.port == item.port && j.a(this.protocol, item.protocol) && j.a(this.src, item.src) && j.a(this.from, item.from) && this.seen == item.seen && this.user == item.user && j.a(this.profile, item.profile) && j.a(this.cc0, item.cc0) && this.f11201v0 == item.f11201v0 && j.a(this.ip0, item.ip0);
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
            return this.ip0.hashCode() + w0.c(s.d(s.d(w0.d(w0.c(s.d(s.d(s.d(androidx.compose.foundation.interaction.f.c(this.port, s.d(s.d(this.f11200id.hashCode() * 31, 31, this.kind), 31, this.host), 31), 31, this.protocol), 31, this.src), 31, this.from), 31, this.seen), 31, this.user), 31, this.profile), 31, this.cc0), 31, this.f11201v0);
        }

        public final void setCc0(String str) {
            j.e(str, "<set-?>");
            this.cc0 = str;
        }

        public final void setIp0(String str) {
            j.e(str, "<set-?>");
            this.ip0 = str;
        }

        public final void setSeen(long j) {
            this.seen = j;
        }

        public final void setUser(boolean z10) {
            this.user = z10;
        }

        public final void setV0(long j) {
            this.f11201v0 = j;
        }

        public String toString() {
            String str = this.f11200id;
            String str2 = this.kind;
            String str3 = this.host;
            int i = this.port;
            String str4 = this.protocol;
            String str5 = this.src;
            String str6 = this.from;
            long j = this.seen;
            boolean z10 = this.user;
            String str7 = this.profile;
            String str8 = this.cc0;
            long j10 = this.f11201v0;
            String str9 = this.ip0;
            StringBuilder sbN = s.n("Item(id=", str, ", kind=", str2, ", host=");
            f0.a.r(i, str3, ", port=", ", protocol=", sbN);
            d1.x(sbN, str4, ", src=", str5, ", from=");
            s.q(j, str6, ", seen=", sbN);
            sbN.append(", user=");
            sbN.append(z10);
            sbN.append(", profile=");
            sbN.append(str7);
            f0.a.x(", cc0=", str8, ", v0=", sbN);
            i.t(j10, ", ip0=", str9, sbN);
            sbN.append(")");
            return sbN.toString();
        }

        public /* synthetic */ Item(String str, String str2, String str3, int i, String str4, String str5, String str6, long j, boolean z10, String str7, String str8, long j10, String str9, int i10, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, i, str4, str5, (i10 & 64) != 0 ? "" : str6, (i10 & 128) != 0 ? 0L : j, (i10 & 256) != 0 ? false : z10, (i10 & 512) != 0 ? "" : str7, (i10 & 1024) != 0 ? "" : str8, (i10 & 2048) != 0 ? 0L : j10, (i10 & 4096) != 0 ? "" : str9);
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

        public Row(String id2, String kind, String host, int i, boolean z10, String profile, long j, Boolean bool, boolean z11, Long l6, String cc2, String exitIp, long j10, String error, int i10, long j11) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(profile, "profile");
            j.e(cc2, "cc");
            j.e(exitIp, "exitIp");
            j.e(error, "error");
            this.f11206id = id2;
            this.kind = kind;
            this.host = host;
            this.port = i;
            this.user = z10;
            this.profile = profile;
            this.verified = j;
            this.ok = bool;
            this.frozen = z11;
            this.ms = l6;
            this.f11205cc = cc2;
            this.exitIp = exitIp;
            this.at = j10;
            this.error = error;
            this.fails = i10;
            this.seen = j11;
        }

        public static /* synthetic */ Row copy$default(Row row, String str, String str2, String str3, int i, boolean z10, String str4, long j, Boolean bool, boolean z11, Long l6, String str5, String str6, long j10, String str7, int i10, long j11, int i11, Object obj) {
            long j12;
            int i12;
            String str8 = (i11 & 1) != 0 ? row.f11206id : str;
            String str9 = (i11 & 2) != 0 ? row.kind : str2;
            String str10 = (i11 & 4) != 0 ? row.host : str3;
            int i13 = (i11 & 8) != 0 ? row.port : i;
            boolean z12 = (i11 & 16) != 0 ? row.user : z10;
            String str11 = (i11 & 32) != 0 ? row.profile : str4;
            long j13 = (i11 & 64) != 0 ? row.verified : j;
            Boolean bool2 = (i11 & 128) != 0 ? row.ok : bool;
            boolean z13 = (i11 & 256) != 0 ? row.frozen : z11;
            Long l10 = (i11 & 512) != 0 ? row.ms : l6;
            String str12 = (i11 & 1024) != 0 ? row.f11205cc : str5;
            String str13 = (i11 & 2048) != 0 ? row.exitIp : str6;
            String str14 = str8;
            String str15 = str9;
            long j14 = (i11 & 4096) != 0 ? row.at : j10;
            String str16 = (i11 & 8192) != 0 ? row.error : str7;
            long j15 = j14;
            int i14 = (i11 & 16384) != 0 ? row.fails : i10;
            if ((i11 & 32768) != 0) {
                i12 = i14;
                j12 = row.seen;
            } else {
                j12 = j11;
                i12 = i14;
            }
            return row.copy(str14, str15, str10, i13, z12, str11, j13, bool2, z13, l10, str12, str13, j15, str16, i12, j12);
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

        public final Row copy(String id2, String kind, String host, int i, boolean z10, String profile, long j, Boolean bool, boolean z11, Long l6, String cc2, String exitIp, long j10, String error, int i10, long j11) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(profile, "profile");
            j.e(cc2, "cc");
            j.e(exitIp, "exitIp");
            j.e(error, "error");
            return new Row(id2, kind, host, i, z10, profile, j, bool, z11, l6, cc2, exitIp, j10, error, i10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Row)) {
                return false;
            }
            Row row = (Row) obj;
            return j.a(this.f11206id, row.f11206id) && j.a(this.kind, row.kind) && j.a(this.host, row.host) && this.port == row.port && this.user == row.user && j.a(this.profile, row.profile) && this.verified == row.verified && j.a(this.ok, row.ok) && this.frozen == row.frozen && j.a(this.ms, row.ms) && j.a(this.f11205cc, row.f11205cc) && j.a(this.exitIp, row.exitIp) && this.at == row.at && j.a(this.error, row.error) && this.fails == row.fails && this.seen == row.seen;
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
            int iC = w0.c(s.d(w0.d(androidx.compose.foundation.interaction.f.c(this.port, s.d(s.d(this.f11206id.hashCode() * 31, 31, this.kind), 31, this.host), 31), 31, this.user), 31, this.profile), 31, this.verified);
            Boolean bool = this.ok;
            int iD = w0.d((iC + (bool == null ? 0 : bool.hashCode())) * 31, 31, this.frozen);
            Long l6 = this.ms;
            return Long.hashCode(this.seen) + androidx.compose.foundation.interaction.f.c(this.fails, s.d(w0.c(s.d(s.d((iD + (l6 != null ? l6.hashCode() : 0)) * 31, 31, this.f11205cc), 31, this.exitIp), 31, this.at), 31, this.error), 31);
        }

        public String toString() {
            String str = this.f11206id;
            String str2 = this.kind;
            String str3 = this.host;
            int i = this.port;
            boolean z10 = this.user;
            String str4 = this.profile;
            long j = this.verified;
            Boolean bool = this.ok;
            boolean z11 = this.frozen;
            Long l6 = this.ms;
            String str5 = this.f11205cc;
            String str6 = this.exitIp;
            long j10 = this.at;
            String str7 = this.error;
            int i10 = this.fails;
            long j11 = this.seen;
            StringBuilder sbN = s.n("Row(id=", str, ", kind=", str2, ", host=");
            f0.a.r(i, str3, ", port=", ", user=", sbN);
            i.x(", profile=", str4, ", verified=", sbN, z10);
            sbN.append(j);
            sbN.append(", ok=");
            sbN.append(bool);
            sbN.append(", frozen=");
            sbN.append(z11);
            sbN.append(", ms=");
            sbN.append(l6);
            d1.x(sbN, ", cc=", str5, ", exitIp=", str6);
            v0.a.k(j10, ", at=", ", error=", sbN);
            f0.a.r(i10, str7, ", fails=", ", seen=", sbN);
            return w0.k(j11, ")", sbN);
        }

        public /* synthetic */ Row(String str, String str2, String str3, int i, boolean z10, String str4, long j, Boolean bool, boolean z11, Long l6, String str5, String str6, long j10, String str7, int i10, long j11, int i11, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, i, z10, str4, j, bool, z11, l6, str5, str6, j10, str7, i10, (i11 & 32768) != 0 ? 0L : j11);
        }
    }
}
