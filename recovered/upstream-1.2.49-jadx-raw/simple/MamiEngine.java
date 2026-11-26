package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.media3.common.s;
import com.mlmvpn.core.aether.AetherScanService;
import com.mlmvpn.core.aether.i;
import com.mlmvpn.core.geph.GephAccount;
import com.mlmvpn.core.lantern.LanternProcess;
import com.mlmvpn.core.tunnel.CoreConfig;
import com.mlmvpn.core.tunnel.IpFormatter;
import com.mlmvpn.core.tunnel.TunnelStatus;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.AwgProbeService;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.core.warp.XrayHosts;
import com.mlmvpn.scanner.MyVpnService;
import com.mlmvpn.scanner.data.CombineEngine;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.data.studio.central.ExitProxy;
import com.mlmvpn.scanner.engines.argo.ArgoNet;
import com.mlmvpn.scanner.engines.argo.ArgoProtocol;
import com.mlmvpn.scanner.engines.cfdoctor.DoctorRunner;
import com.mlmvpn.scanner.engines.mae.device.DeviceSignals;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.engines.scout.ScoutScore;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.settings.SettingsSpotlight;
import com.mlmvpn.scanner.ui.tunnel.Transport;
import com.mlmvpn.scanner.ui.tunnel.TunnelController;
import com.mlmvpn.scanner.ui.tunnel.TunnelExclusion;
import com.mlmvpn.scanner.ui.tunnel.TunnelStage;
import com.mlmvpn.scanner.ui.tunnel.TunnelUiState;
import com.mlmvpn.scanner.utils.ConnectionOwner;
import com.mlmvpn.scanner.utils.LocalPort;
import com.mlmvpn.scanner.utils.NetworkSettings;
import com.mlmvpn.scanner.utils.SafeStart;
import com.mlmvpn.scanner.utils.XrayJsonGenerator;
import java.io.File;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.collections.d0;
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.internal.y;
import kotlin.text.o;
import kotlin.text.v;
import kotlinx.coroutines.flow.e1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.v0;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.mlmvpn.chat.bridge.GerehLocale;
import org.mlmvpn.chat.bridge.GerehWatchdog;
import org.scilab.forge.jlatexmath.TeXSymbolParser;
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import sd.j;
import sd.l;
import sd.m;
import sd.u;
import x6.t;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiEngine {
    public static final int $stable = 0;
    private static final long CATALOG_MARGIN_SEC = 300;
    private static final List<String> ENGINE_NAMES = null;
    private static final int FAILOVER_MISSES = 3;
    private static final long FRESH_REGISTRATION_MS = 120000;
    private static final String HIVE_PROBE = "https://cp.cloudflare.com/generate_204";
    private static final long HIVE_TTL_MS = 3600000;
    public static final MamiEngine INSTANCE = null;
    private static final int KEEPALIVE_TICKS = 10;
    private static final List<Method> METHODS = null;
    public static final String NODE_ID = "mami";
    private static final long OWNER_CHECK_MS = 5000;
    public static final String REMARKS = "mlm-mami-v1";
    private static final long SCOUT_BUDGET_MS = 30000;
    private static final long SCOUT_EACH_MS = 12000;
    private static final int SCOUT_MAX = 24;
    private static final long SCOUT_TTL_MS = 600000;
    private static final Map<String, String> STEP_WORDS = null;
    private static final String TAG = "MAMI";
    private static final long TEMPLATE_FRESH_MS = 21600000;
    private static final long TEMPLATE_MAX_MS = 604800000;
    private static final long TICK_MS = 60000;
    private static final int TRIES = 3;
    private static final k0 _busy = null;
    private static final k0 _logs = null;
    private static final k0 _status = null;
    private static final k0 _version = null;
    private static Context app;
    private static final e1 busy = null;
    private static volatile boolean cancelled;
    private static j cat;
    private static s1 connectJob;
    private static final ConnectionOwner connectionOwner = null;
    private static final ConcurrentHashMap<String, j> delays = null;
    private static volatile ExclusiveLive exclusiveLive;
    private static volatile String frontMarker;
    private static volatile String frontTransport;
    private static j hiveCat;
    private static volatile Live live;
    private static final e1 logs = null;
    private static final i0 scope = null;
    private static final e1 status = null;
    private static final e1 version = null;
    private static s1 watchJob;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Cand {

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11583cc;
        private final String city;
        private final String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11584id;
        private final String locationId;
        private final sf.c outbound;
        private final String profile;
        private final String protocol;
        private final MamiCatalog.Server server;

        public Cand(String r4, MamiCatalog.Server r8, sf.c r10, String r11, String r12, String r13, String r14, String r15, String r16) {
            kotlin.jvm.internal.j.e(r4, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r10, "outbound");
            kotlin.jvm.internal.j.e(r11, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r12, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r13, "city");
            kotlin.jvm.internal.j.e(r14, "locationId");
            kotlin.jvm.internal.j.e(r15, "protocol");
            kotlin.jvm.internal.j.e(r16, "profile");
            this.f11584id = r4;
            this.server = r8;
            this.outbound = r10;
            this.f11583cc = r11;
            this.country = r12;
            this.city = r13;
            this.locationId = r14;
            this.protocol = r15;
            this.profile = r16;
        }

        public final String getCc() {
            return this.f11583cc;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getId() {
            return this.f11584id;
        }

        public final String getLocationId() {
            return this.locationId;
        }

        public final sf.c getOutbound() {
            return this.outbound;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final MamiCatalog.Server getServer() {
            return this.server;
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

        public CatalogInfo(long r4, int r8, int r10, int r11, int r12, long r13, long r14, boolean r15) {
            this.revision = r4;
            this.payloadVersion = r8;
            this.version = r10;
            this.servers = r11;
            this.skipped = r12;
            this.fetchedAt = r13;
            this.expiresAt = r14;
            this.fresh = r15;
        }

        public static /* synthetic */ CatalogInfo copy$default(CatalogInfo r12, long r13, int r15, int r16, int r17, int r18, long r19, long r21, boolean r23, int r24, Object r25) {
            if ((r24 & 1) == 0) goto L5;
            r13 = r12.revision;
        L5:
            long r4 = r13;
            if ((r24 & 2) == 0) goto L8;
            r15 = r12.payloadVersion;
        L8:
            int r8 = r15;
            if ((r24 & 4) == 0) goto L11;
            int r10 = r12.version;
        L13:
            if ((r24 & 8) == 0) goto L15;
            int r11 = r12.servers;
        L17:
            if ((r24 & 16) == 0) goto L19;
            int r14 = r12.skipped;
        L21:
            if ((r24 & 32) == 0) goto L23;
            long r20 = r12.fetchedAt;
        L25:
            if ((r24 & 64) == 0) goto L27;
            long r22 = r12.expiresAt;
        L29:
            if ((r24 & 128) == 0) goto L32;
            boolean r110 = r12.fresh;
        L34:
            return r12.copy(r4, r8, r10, r11, r14, r20, r22, r110);
        L32:
            r110 = r23;
            goto L34
        L27:
            r22 = r21;
            goto L29
        L23:
            r20 = r19;
            goto L25
        L19:
            r14 = r18;
            goto L21
        L15:
            r11 = r17;
            goto L17
        L11:
            r10 = r16;
            goto L13
        }

        public final long component1() {
            return this.revision;
        }

        public final int component2() {
            return this.payloadVersion;
        }

        public final int component3() {
            return this.version;
        }

        public final int component4() {
            return this.servers;
        }

        public final int component5() {
            return this.skipped;
        }

        public final long component6() {
            return this.fetchedAt;
        }

        public final long component7() {
            return this.expiresAt;
        }

        public final boolean component8() {
            return this.fresh;
        }

        public final CatalogInfo copy(long r13, int r15, int r16, int r17, int r18, long r19, long r21, boolean r23) {
            return new CatalogInfo(r13, r15, r16, r17, r18, r19, r21, r23);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof CatalogInfo) == true) goto L8;
            return false;
        L8:
            CatalogInfo r10 = (CatalogInfo) r8;
            if (this.revision == r10.revision) goto L12;
            return false;
        L12:
            if (this.payloadVersion == r10.payloadVersion) goto L15;
            return false;
        L15:
            if (this.version == r10.version) goto L18;
            return false;
        L18:
            if (this.servers == r10.servers) goto L21;
            return false;
        L21:
            if (this.skipped == r10.skipped) goto L24;
            return false;
        L24:
            if (this.fetchedAt == r10.fetchedAt) goto L27;
            return false;
        L27:
            if (this.expiresAt == r10.expiresAt) goto L30;
            return false;
        L30:
            if (this.fresh == r10.fresh) goto L32;
            return false;
        L32:
            return true;
        }

        public final long getExpiresAt() {
            return this.expiresAt;
        }

        public final long getFetchedAt() {
            return this.fetchedAt;
        }

        public final boolean getFresh() {
            return this.fresh;
        }

        public final int getPayloadVersion() {
            return this.payloadVersion;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final int getServers() {
            return this.servers;
        }

        public final int getSkipped() {
            return this.skipped;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int r4 = Long.hashCode(this.revision) * 31;
            int r8 = androidx.compose.foundation.interaction.f.c(this.payloadVersion, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.version, r8, 31);
            int r11 = androidx.compose.foundation.interaction.f.c(this.servers, r10, 31);
            int r12 = w0.c(w0.c(androidx.compose.foundation.interaction.f.c(this.skipped, r11, 31), 31, this.fetchedAt), 31, this.expiresAt);
            return Boolean.hashCode(this.fresh) + r12;
        }

        public String toString() {
            long r4 = this.revision;
            int r8 = this.payloadVersion;
            int r10 = this.version;
            int r11 = this.servers;
            int r12 = this.skipped;
            long r13 = this.fetchedAt;
            long r14 = this.expiresAt;
            boolean r15 = this.fresh;
            StringBuilder r16 = i.j(r4, "CatalogInfo(revision=", r8, ", payloadVersion=");
            s.w(r16, ", version=", r10, ", servers=", r11);
            r16.append(", skipped=");
            r16.append(r12);
            r16.append(", fetchedAt=");
            r16.append(r13);
            v0.a.k(r14, ", expiresAt=", ", fresh=", r16);
            return f0.a.n(r16, ")", r15);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ExclusiveLive {
        private final String host;
        private final ArgoProtocol.SessionInfo info;
        private final int port;

        public ExclusiveLive(String r4, int r8, ArgoProtocol.SessionInfo r10) {
            kotlin.jvm.internal.j.e(r4, "host");
            kotlin.jvm.internal.j.e(r10, "info");
            this.host = r4;
            this.port = r8;
            this.info = r10;
        }

        public final String getHost() {
            return this.host;
        }

        public final ArgoProtocol.SessionInfo getInfo() {
            return this.info;
        }

        public final int getPort() {
            return this.port;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Exit {
        public static final int $stable = 0;
        private final String ip;
        private final String loc;
        private final long ms;

        public Exit(String r4, String r8, long r10) {
            kotlin.jvm.internal.j.e(r4, "loc");
            kotlin.jvm.internal.j.e(r8, "ip");
            this.loc = r4;
            this.ip = r8;
            this.ms = r10;
        }

        public static /* synthetic */ Exit copy$default(Exit r4, String r8, String r10, long r11, int r12, Object r13) {
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

        public final Exit copy(String r4, String r8, long r10) {
            kotlin.jvm.internal.j.e(r4, "loc");
            kotlin.jvm.internal.j.e(r8, "ip");
            return new Exit(r4, r8, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Exit) == true) goto L8;
            return false;
        L8:
            Exit r10 = (Exit) r8;
            if (kotlin.jvm.internal.j.a(this.loc, r10.loc) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.j.a(this.ip, r10.ip) == true) goto L15;
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
            return w0.k(this.ms, ")", s.n("Exit(loc=", r4, ", ip=", r8, ", ms="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Fail extends Exception {
        private final String code;

        public Fail(String r4, String r8) {
            kotlin.jvm.internal.j.e(r4, "code");
            kotlin.jvm.internal.j.e(r8, "msg");
            super(r8);
            this.code = r4;
        }

        public final String getCode() {
            return this.code;
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

        public HiveInfo(long r4, long r8, int r10, int r11, boolean r12) {
            this.fetchedAt = r4;
            this.revision = r8;
            this.servers = r10;
            this.skipped = r11;
            this.fresh = r12;
        }

        public static /* synthetic */ HiveInfo copy$default(HiveInfo r8, long r10, long r11, int r13, int r14, boolean r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L5;
            r10 = r8.fetchedAt;
        L5:
            long r4 = r10;
            if ((r16 & 2) == 0) goto L8;
            r11 = r8.revision;
        L8:
            long r12 = r11;
            if ((r16 & 4) == 0) goto L11;
            r13 = r8.servers;
        L11:
            int r18 = r13;
            if ((r16 & 8) == 0) goto L14;
            r14 = r8.skipped;
        L14:
            int r19 = r14;
            if ((r16 & 16) == 0) goto L18;
            r15 = r8.fresh;
        L18:
            return r8.copy(r4, r12, r18, r19, r15);
        }

        public final long component1() {
            return this.fetchedAt;
        }

        public final long component2() {
            return this.revision;
        }

        public final int component3() {
            return this.servers;
        }

        public final int component4() {
            return this.skipped;
        }

        public final boolean component5() {
            return this.fresh;
        }

        public final HiveInfo copy(long r10, long r11, int r13, int r14, boolean r15) {
            return new HiveInfo(r10, r11, r13, r14, r15);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof HiveInfo) == true) goto L8;
            return false;
        L8:
            HiveInfo r10 = (HiveInfo) r8;
            if (this.fetchedAt == r10.fetchedAt) goto L12;
            return false;
        L12:
            if (this.revision == r10.revision) goto L15;
            return false;
        L15:
            if (this.servers == r10.servers) goto L18;
            return false;
        L18:
            if (this.skipped == r10.skipped) goto L21;
            return false;
        L21:
            if (this.fresh == r10.fresh) goto L23;
            return false;
        L23:
            return true;
        }

        public final long getFetchedAt() {
            return this.fetchedAt;
        }

        public final boolean getFresh() {
            return this.fresh;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final int getServers() {
            return this.servers;
        }

        public final int getSkipped() {
            return this.skipped;
        }

        public int hashCode() {
            int r4 = w0.c(Long.hashCode(this.fetchedAt) * 31, 31, this.revision);
            int r8 = androidx.compose.foundation.interaction.f.c(this.servers, r4, 31);
            int r10 = androidx.compose.foundation.interaction.f.c(this.skipped, r8, 31);
            return Boolean.hashCode(this.fresh) + r10;
        }

        public String toString() {
            long r4 = this.fetchedAt;
            long r8 = this.revision;
            int r10 = this.servers;
            int r11 = this.skipped;
            boolean r12 = this.fresh;
            StringBuilder r13 = f0.a.o(r4, "HiveInfo(fetchedAt=", ", revision=");
            s.p(r10, r8, ", servers=", r13);
            r13.append(", skipped=");
            r13.append(r11);
            r13.append(", fresh=");
            r13.append(r12);
            r13.append(")");
            return r13.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Live {
        private final Cand cand;
        private final String config;
        private final String engine;
        private final String kind;
        private final Mode mode;

        public Live(String r4, Cand r8, String r10, String r11, Mode r12) {
            kotlin.jvm.internal.j.e(r4, "kind");
            kotlin.jvm.internal.j.e(r12, "mode");
            this.kind = r4;
            this.cand = r8;
            this.config = r10;
            this.engine = r11;
            this.mode = r12;
        }

        public final Cand getCand() {
            return this.cand;
        }

        public final String getConfig() {
            return this.config;
        }

        public final String getEngine() {
            return this.engine;
        }

        public final String getKind() {
            return this.kind;
        }

        public final Mode getMode() {
            return this.mode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Method {
        public static final int $stable = 0;
        private final String about;
        private final String engine;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11585id;
        private final String key;
        private final String kind;
        private final String name;
        private final boolean ready;

        public Method(String r4, String r8, String r10, String r11, String r12, boolean r13, String r14) {
            kotlin.jvm.internal.j.e(r4, "key");
            kotlin.jvm.internal.j.e(r8, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r10, "name");
            kotlin.jvm.internal.j.e(r11, "kind");
            kotlin.jvm.internal.j.e(r14, "about");
            this.key = r4;
            this.f11585id = r8;
            this.name = r10;
            this.kind = r11;
            this.engine = r12;
            this.ready = r13;
            this.about = r14;
        }

        public final String getAbout() {
            return this.about;
        }

        public final String getEngine() {
            return this.engine;
        }

        public final String getId() {
            return this.f11585id;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getKind() {
            return this.kind;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getReady() {
            return this.ready;
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
    public static final class PlaceRow {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11586cc;
        private final String city;
        private final String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11587id;
        private final int servers;
        private final int sort;

        public PlaceRow(String r4, String r8, String r10, String r11, int r12, int r13) {
            kotlin.jvm.internal.j.e(r4, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r8, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r10, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r11, "city");
            this.f11587id = r4;
            this.f11586cc = r8;
            this.country = r10;
            this.city = r11;
            this.sort = r12;
            this.servers = r13;
        }

        public static /* synthetic */ PlaceRow copy$default(PlaceRow r4, String r8, String r10, String r11, String r12, int r13, int r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r8 = r4.f11587id;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r10 = r4.f11586cc;
        L9:
            if ((r15 & 4) == 0) goto L12;
            r11 = r4.country;
        L12:
            if ((r15 & 8) == 0) goto L15;
            r12 = r4.city;
        L15:
            if ((r15 & 16) == 0) goto L18;
            r13 = r4.sort;
        L18:
            if ((r15 & 32) == 0) goto L20;
            r14 = r4.servers;
        L20:
            int r17 = r13;
            int r18 = r14;
            String r19 = r11;
            String r20 = r12;
            return r4.copy(r8, r10, r19, r20, r17, r18);
        }

        public final String component1() {
            return this.f11587id;
        }

        public final String component2() {
            return this.f11586cc;
        }

        public final String component3() {
            return this.country;
        }

        public final String component4() {
            return this.city;
        }

        public final int component5() {
            return this.sort;
        }

        public final int component6() {
            return this.servers;
        }

        public final PlaceRow copy(String r10, String r11, String r12, String r13, int r14, int r15) {
            kotlin.jvm.internal.j.e(r10, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r11, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r12, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r13, "city");
            return new PlaceRow(r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof PlaceRow) == true) goto L8;
            return false;
        L8:
            PlaceRow r10 = (PlaceRow) r8;
            if (kotlin.jvm.internal.j.a(this.f11587id, r10.f11587id) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.j.a(this.f11586cc, r10.f11586cc) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.j.a(this.country, r10.country) == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.j.a(this.city, r10.city) == true) goto L21;
            return false;
        L21:
            if (this.sort == r10.sort) goto L24;
            return false;
        L24:
            if (this.servers == r10.servers) goto L26;
            return false;
        L26:
            return true;
        }

        public final String getCc() {
            return this.f11586cc;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getId() {
            return this.f11587id;
        }

        public final int getServers() {
            return this.servers;
        }

        public final int getSort() {
            return this.sort;
        }

        public int hashCode() {
            int r4 = s.d(s.d(s.d(this.f11587id.hashCode() * 31, 31, this.f11586cc), 31, this.country), 31, this.city);
            int r8 = androidx.compose.foundation.interaction.f.c(this.sort, r4, 31);
            return Integer.hashCode(this.servers) + r8;
        }

        public String toString() {
            String r4 = this.f11587id;
            String r8 = this.f11586cc;
            String r10 = this.country;
            String r11 = this.city;
            int r12 = this.sort;
            int r13 = this.servers;
            StringBuilder r14 = s.n("PlaceRow(id=", r4, ", cc=", r8, ", country=");
            d1.x(r14, r10, ", city=", r11, ", sort=");
            r14.append(r12);
            r14.append(", servers=");
            r14.append(r13);
            r14.append(")");
            return r14.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Prefs {
        public static final int $stable = 0;
        private final String location;
        private final String method;
        private final Mode mode;

        public Prefs() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Prefs copy$default(Prefs r4, String r8, Mode r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r8 = r4.method;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r10 = r4.mode;
        L9:
            if ((r12 & 4) == 0) goto L12;
            r11 = r4.location;
        L12:
            return r4.copy(r8, r10, r11);
        }

        public final String component1() {
            return this.method;
        }

        public final Mode component2() {
            return this.mode;
        }

        public final String component3() {
            return this.location;
        }

        public final Prefs copy(String r4, Mode r8, String r10) {
            kotlin.jvm.internal.j.e(r4, ConstKt.SEP_METHOD);
            kotlin.jvm.internal.j.e(r8, "mode");
            kotlin.jvm.internal.j.e(r10, "location");
            return new Prefs(r4, r8, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Prefs) == true) goto L8;
            return false;
        L8:
            Prefs r10 = (Prefs) r8;
            if (kotlin.jvm.internal.j.a(this.method, r10.method) == true) goto L12;
            return false;
        L12:
            if (this.mode == r10.mode) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.j.a(this.location, r10.location) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getLocation() {
            return this.location;
        }

        public final String getMethod() {
            return this.method;
        }

        public final Mode getMode() {
            return this.mode;
        }

        public int hashCode() {
            int r4 = this.method.hashCode() * 31;
            int r8 = (this.mode.hashCode() + r4) * 31;
            return this.location.hashCode() + r8;
        }

        public String toString() {
            String r4 = this.method;
            Mode r8 = this.mode;
            String r10 = this.location;
            StringBuilder r11 = new StringBuilder("Prefs(method=");
            r11.append(r4);
            r11.append(", mode=");
            r11.append(r8);
            r11.append(", location=");
            return w0.r(r11, r10, ")");
        }

        public Prefs(String r4, Mode r8, String r10) {
            kotlin.jvm.internal.j.e(r4, ConstKt.SEP_METHOD);
            kotlin.jvm.internal.j.e(r8, "mode");
            kotlin.jvm.internal.j.e(r10, "location");
            this.method = r4;
            this.mode = r8;
            this.location = r10;
        }

        public /* synthetic */ Prefs(String r4, Mode r8, String r10, int r11, kotlin.jvm.internal.e r12) {
            if ((r11 & 1) == 0) goto L6;
            r4 = "auto";
        L6:
            if ((r11 & 2) == 0) goto L9;
            r8 = Mode.TUNNEL;
        L9:
            if ((r11 & 4) == 0) goto L11;
            r10 = "";
        L11:
            this(r4, r8, r10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ranked {
        private final long ms;
        private final long score;
        private final MamiCatalog.Server server;

        public Ranked(MamiCatalog.Server r4, long r8, long r10) {
            kotlin.jvm.internal.j.e(r4, "server");
            this.server = r4;
            this.ms = r8;
            this.score = r10;
        }

        public final long getMs() {
            return this.ms;
        }

        public final long getScore() {
            return this.score;
        }

        public final MamiCatalog.Server getServer() {
            return this.server;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ServerRef {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11588cc;
        private final String city;
        private final String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11589id;
        private final long ms;
        private final String profile;
        private final String protocol;

        public ServerRef(String r4, String r8, String r10, String r11, String r12, String r13, long r14) {
            kotlin.jvm.internal.j.e(r4, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r8, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r10, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r11, "city");
            kotlin.jvm.internal.j.e(r12, "protocol");
            kotlin.jvm.internal.j.e(r13, "profile");
            this.f11589id = r4;
            this.f11588cc = r8;
            this.country = r10;
            this.city = r11;
            this.protocol = r12;
            this.profile = r13;
            this.ms = r14;
        }

        public static /* synthetic */ ServerRef copy$default(ServerRef r4, String r8, String r10, String r11, String r12, String r13, String r14, long r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L6;
            r8 = r4.f11589id;
        L6:
            if ((r16 & 2) == 0) goto L9;
            r10 = r4.f11588cc;
        L9:
            if ((r16 & 4) == 0) goto L12;
            r11 = r4.country;
        L12:
            if ((r16 & 8) == 0) goto L15;
            r12 = r4.city;
        L15:
            if ((r16 & 16) == 0) goto L18;
            r13 = r4.protocol;
        L18:
            if ((r16 & 32) == 0) goto L21;
            r14 = r4.profile;
        L21:
            if ((r16 & 64) == 0) goto L23;
            r15 = r4.ms;
        L23:
            long r18 = r15;
            String r19 = r13;
            String r20 = r14;
            String r21 = r11;
            String r22 = r12;
            return r4.copy(r8, r10, r21, r22, r19, r20, r18);
        }

        public final String component1() {
            return this.f11589id;
        }

        public final String component2() {
            return this.f11588cc;
        }

        public final String component3() {
            return this.country;
        }

        public final String component4() {
            return this.city;
        }

        public final String component5() {
            return this.protocol;
        }

        public final String component6() {
            return this.profile;
        }

        public final long component7() {
            return this.ms;
        }

        public final ServerRef copy(String r11, String r12, String r13, String r14, String r15, String r16, long r17) {
            kotlin.jvm.internal.j.e(r11, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r12, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r13, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r14, "city");
            kotlin.jvm.internal.j.e(r15, "protocol");
            kotlin.jvm.internal.j.e(r16, "profile");
            return new ServerRef(r11, r12, r13, r14, r15, r16, r17);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ServerRef) == true) goto L8;
            return false;
        L8:
            ServerRef r10 = (ServerRef) r8;
            if (kotlin.jvm.internal.j.a(this.f11589id, r10.f11589id) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.j.a(this.f11588cc, r10.f11588cc) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.j.a(this.country, r10.country) == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.j.a(this.city, r10.city) == true) goto L21;
            return false;
        L21:
            if (kotlin.jvm.internal.j.a(this.protocol, r10.protocol) == true) goto L24;
            return false;
        L24:
            if (kotlin.jvm.internal.j.a(this.profile, r10.profile) == true) goto L27;
            return false;
        L27:
            if (this.ms == r10.ms) goto L29;
            return false;
        L29:
            return true;
        }

        public final String getCc() {
            return this.f11588cc;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getId() {
            return this.f11589id;
        }

        public final long getMs() {
            return this.ms;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public int hashCode() {
            int r4 = s.d(s.d(s.d(s.d(s.d(this.f11589id.hashCode() * 31, 31, this.f11588cc), 31, this.country), 31, this.city), 31, this.protocol), 31, this.profile);
            return Long.hashCode(this.ms) + r4;
        }

        public String toString() {
            String r4 = this.f11589id;
            String r8 = this.f11588cc;
            String r10 = this.country;
            String r11 = this.city;
            String r12 = this.protocol;
            String r13 = this.profile;
            long r14 = this.ms;
            StringBuilder r15 = s.n("ServerRef(id=", r4, ", cc=", r8, ", country=");
            d1.x(r15, r10, ", city=", r11, ", protocol=");
            d1.x(r15, r12, ", profile=", r13, ", ms=");
            return w0.k(r14, ")", r15);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ServerRow {
        public static final int $stable = 0;
        private final long at;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11590cc;
        private final String city;
        private final String country;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11591id;
        private final String locationId;
        private final long ms;
        private final String profile;
        private final String protocol;
        private final int sort;
        private final boolean supported;
        private final String why;

        public ServerRow(String r4, String r8, String r10, String r11, String r12, String r13, String r14, int r15, boolean r16, String r17, long r18, long r19) {
            kotlin.jvm.internal.j.e(r4, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r8, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r10, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r11, "city");
            kotlin.jvm.internal.j.e(r12, "locationId");
            kotlin.jvm.internal.j.e(r13, "protocol");
            kotlin.jvm.internal.j.e(r14, "profile");
            kotlin.jvm.internal.j.e(r17, "why");
            this.f11591id = r4;
            this.f11590cc = r8;
            this.country = r10;
            this.city = r11;
            this.locationId = r12;
            this.protocol = r13;
            this.profile = r14;
            this.sort = r15;
            this.supported = r16;
            this.why = r17;
            this.ms = r18;
            this.at = r19;
        }

        public static /* synthetic */ ServerRow copy$default(ServerRow r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, boolean r25, String r26, long r27, long r29, int r31, Object r32) {
            if ((r31 & 1) == 0) goto L5;
            String r4 = r16.f11591id;
        L7:
            if ((r31 & 2) == 0) goto L9;
            String r8 = r16.f11590cc;
        L11:
            if ((r31 & 4) == 0) goto L13;
            String r10 = r16.country;
        L15:
            if ((r31 & 8) == 0) goto L17;
            String r11 = r16.city;
        L19:
            if ((r31 & 16) == 0) goto L21;
            String r12 = r16.locationId;
        L23:
            if ((r31 & 32) == 0) goto L25;
            String r13 = r16.protocol;
        L27:
            if ((r31 & 64) == 0) goto L29;
            String r14 = r16.profile;
        L31:
            if ((r31 & 128) == 0) goto L33;
            int r15 = r16.sort;
        L35:
            if ((r31 & 256) == 0) goto L37;
            boolean r110 = r16.supported;
        L39:
            if ((r31 & 512) == 0) goto L41;
            String r111 = r16.why;
        L43:
            if ((r31 & 1024) == 0) goto L45;
            long r112 = r16.ms;
        L47:
            if ((r31 & 2048) == 0) goto L50;
            long r30 = r16.at;
        L52:
            return r16.copy(r4, r8, r10, r11, r12, r13, r14, r15, r110, r111, r112, r30);
        L50:
            r30 = r29;
            goto L52
        L45:
            r112 = r27;
            goto L47
        L41:
            r111 = r26;
            goto L43
        L37:
            r110 = r25;
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
            return this.f11591id;
        }

        public final String component10() {
            return this.why;
        }

        public final long component11() {
            return this.ms;
        }

        public final long component12() {
            return this.at;
        }

        public final String component2() {
            return this.f11590cc;
        }

        public final String component3() {
            return this.country;
        }

        public final String component4() {
            return this.city;
        }

        public final String component5() {
            return this.locationId;
        }

        public final String component6() {
            return this.protocol;
        }

        public final String component7() {
            return this.profile;
        }

        public final int component8() {
            return this.sort;
        }

        public final boolean component9() {
            return this.supported;
        }

        public final ServerRow copy(String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, boolean r25, String r26, long r27, long r29) {
            kotlin.jvm.internal.j.e(r17, XrayCoreHostService.KEY_ID);
            kotlin.jvm.internal.j.e(r18, AwgProbeService.KEY_COUNTRY);
            kotlin.jvm.internal.j.e(r19, TunnelVpnService.EXTRA_COUNTRY);
            kotlin.jvm.internal.j.e(r20, "city");
            kotlin.jvm.internal.j.e(r21, "locationId");
            kotlin.jvm.internal.j.e(r22, "protocol");
            kotlin.jvm.internal.j.e(r23, "profile");
            kotlin.jvm.internal.j.e(r26, "why");
            return new ServerRow(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ServerRow) == true) goto L8;
            return false;
        L8:
            ServerRow r10 = (ServerRow) r8;
            if (kotlin.jvm.internal.j.a(this.f11591id, r10.f11591id) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.j.a(this.f11590cc, r10.f11590cc) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.j.a(this.country, r10.country) == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.j.a(this.city, r10.city) == true) goto L21;
            return false;
        L21:
            if (kotlin.jvm.internal.j.a(this.locationId, r10.locationId) == true) goto L24;
            return false;
        L24:
            if (kotlin.jvm.internal.j.a(this.protocol, r10.protocol) == true) goto L27;
            return false;
        L27:
            if (kotlin.jvm.internal.j.a(this.profile, r10.profile) == true) goto L30;
            return false;
        L30:
            if (this.sort == r10.sort) goto L33;
            return false;
        L33:
            if (this.supported == r10.supported) goto L36;
            return false;
        L36:
            if (kotlin.jvm.internal.j.a(this.why, r10.why) == true) goto L39;
            return false;
        L39:
            if (this.ms == r10.ms) goto L42;
            return false;
        L42:
            if (this.at == r10.at) goto L44;
            return false;
        L44:
            return true;
        }

        public final long getAt() {
            return this.at;
        }

        public final String getCc() {
            return this.f11590cc;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getId() {
            return this.f11591id;
        }

        public final String getLocationId() {
            return this.locationId;
        }

        public final long getMs() {
            return this.ms;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final int getSort() {
            return this.sort;
        }

        public final boolean getSupported() {
            return this.supported;
        }

        public final String getWhy() {
            return this.why;
        }

        public int hashCode() {
            int r4 = s.d(s.d(s.d(s.d(s.d(s.d(this.f11591id.hashCode() * 31, 31, this.f11590cc), 31, this.country), 31, this.city), 31, this.locationId), 31, this.protocol), 31, this.profile);
            int r8 = w0.c(s.d(w0.d(androidx.compose.foundation.interaction.f.c(this.sort, r4, 31), 31, this.supported), 31, this.why), 31, this.ms);
            return Long.hashCode(this.at) + r8;
        }

        public String toString() {
            String r4 = this.f11591id;
            String r8 = this.f11590cc;
            String r10 = this.country;
            String r11 = this.city;
            String r12 = this.locationId;
            String r13 = this.protocol;
            String r14 = this.profile;
            int r15 = this.sort;
            boolean r16 = this.supported;
            String r17 = this.why;
            long r18 = this.ms;
            long r19 = this.at;
            StringBuilder r20 = s.n("ServerRow(id=", r4, ", cc=", r8, ", country=");
            d1.x(r20, r10, ", city=", r11, ", locationId=");
            d1.x(r20, r12, ", protocol=", r13, ", profile=");
            f0.a.r(r15, r14, ", sort=", ", supported=", r20);
            i.x(", why=", r17, ", ms=", r20, r16);
            r20.append(r18);
            return s.j(r19, ", at=", ")", r20);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Status {
        public static final int $stable = 0;
        private final int attempt;
        private final long connectedAt;
        private final String error;
        private final Exit exit;
        private final String lastWhy;
        private final String method;
        private final Mode mode;
        private final String phase;
        private final ServerRef server;
        private final long startedAt;
        private final String step;

        public Status() {
            this(null, null, null, null, null, null, null, 0, 0, 0, null, 2047, null);
        }

        public static /* synthetic */ Status copy$default(Status r12, String r13, String r14, String r15, Mode r16, ServerRef r17, Exit r18, String r19, long r20, long r22, int r24, String r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L6;
            r13 = r12.phase;
        L6:
            if ((r26 & 2) == 0) goto L8;
            String r4 = r12.method;
        L10:
            if ((r26 & 4) == 0) goto L12;
            String r8 = r12.step;
        L14:
            if ((r26 & 8) == 0) goto L16;
            Mode r10 = r12.mode;
        L18:
            if ((r26 & 16) == 0) goto L20;
            ServerRef r11 = r12.server;
        L22:
            if ((r26 & 32) == 0) goto L24;
            Exit r21 = r12.exit;
        L26:
            if ((r26 & 64) == 0) goto L28;
            String r23 = r12.error;
        L30:
            if ((r26 & 128) == 0) goto L32;
            long r28 = r12.startedAt;
        L34:
            if ((r26 & 256) == 0) goto L36;
            long r29 = r12.connectedAt;
        L38:
            if ((r26 & 512) == 0) goto L40;
            int r110 = r12.attempt;
        L42:
            if ((r26 & 1024) == 0) goto L45;
            String r210 = r12.lastWhy;
        L47:
            return r12.copy(r13, r4, r8, r10, r11, r21, r23, r28, r29, r110, r210);
        L45:
            r210 = r25;
            goto L47
        L40:
            r110 = r24;
            goto L42
        L36:
            r29 = r22;
            goto L38
        L32:
            r28 = r20;
            goto L34
        L28:
            r23 = r19;
            goto L30
        L24:
            r21 = r18;
            goto L26
        L20:
            r11 = r17;
            goto L22
        L16:
            r10 = r16;
            goto L18
        L12:
            r8 = r15;
            goto L14
        L8:
            r4 = r14;
            goto L10
        }

        public final String component1() {
            return this.phase;
        }

        public final int component10() {
            return this.attempt;
        }

        public final String component11() {
            return this.lastWhy;
        }

        public final String component2() {
            return this.method;
        }

        public final String component3() {
            return this.step;
        }

        public final Mode component4() {
            return this.mode;
        }

        public final ServerRef component5() {
            return this.server;
        }

        public final Exit component6() {
            return this.exit;
        }

        public final String component7() {
            return this.error;
        }

        public final long component8() {
            return this.startedAt;
        }

        public final long component9() {
            return this.connectedAt;
        }

        public final Status copy(String r16, String r17, String r18, Mode r19, ServerRef r20, Exit r21, String r22, long r23, long r25, int r27, String r28) {
            kotlin.jvm.internal.j.e(r16, "phase");
            kotlin.jvm.internal.j.e(r18, "step");
            kotlin.jvm.internal.j.e(r19, "mode");
            return new Status(r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r28);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Status) == true) goto L8;
            return false;
        L8:
            Status r10 = (Status) r8;
            if (kotlin.jvm.internal.j.a(this.phase, r10.phase) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.j.a(this.method, r10.method) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.j.a(this.step, r10.step) == true) goto L18;
            return false;
        L18:
            if (this.mode == r10.mode) goto L21;
            return false;
        L21:
            if (kotlin.jvm.internal.j.a(this.server, r10.server) == true) goto L24;
            return false;
        L24:
            if (kotlin.jvm.internal.j.a(this.exit, r10.exit) == true) goto L27;
            return false;
        L27:
            if (kotlin.jvm.internal.j.a(this.error, r10.error) == true) goto L30;
            return false;
        L30:
            if (this.startedAt == r10.startedAt) goto L33;
            return false;
        L33:
            if (this.connectedAt == r10.connectedAt) goto L36;
            return false;
        L36:
            if (this.attempt == r10.attempt) goto L39;
            return false;
        L39:
            if (kotlin.jvm.internal.j.a(this.lastWhy, r10.lastWhy) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int getAttempt() {
            return this.attempt;
        }

        public final long getConnectedAt() {
            return this.connectedAt;
        }

        public final String getError() {
            return this.error;
        }

        public final Exit getExit() {
            return this.exit;
        }

        public final String getLastWhy() {
            return this.lastWhy;
        }

        public final boolean getLive() {
            if (kotlin.jvm.internal.j.a(this.phase, "on") == false) goto L5;
            return true;
        L5:
            if (kotlin.jvm.internal.j.a(this.phase, "lost") == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getMethodName() {
            Method r4 = MamiEngine.INSTANCE.method(this.method);
            if (r4 == null) goto L5;
            String r8 = r4.getName();
        L6:
            if (r8 != null) goto L9;
            return "";
        L9:
            return r8;
        L5:
            r8 = null;
            goto L6
        }

        public final Mode getMode() {
            return this.mode;
        }

        public final String getPhase() {
            return this.phase;
        }

        public final ServerRef getServer() {
            return this.server;
        }

        public final long getStartedAt() {
            return this.startedAt;
        }

        public final String getStep() {
            return this.step;
        }

        public final String getStepWord() {
            String r4 = MamiEngine.INSTANCE.getSTEP_WORDS().get(this.step);
            if (r4 != null) goto L6;
            return "";
        L6:
            return r4;
        }

        public int hashCode() {
            int r4 = this.phase.hashCode() * 31;
            String r8 = this.method;
            int r10 = 0;
            if (r8 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (this.mode.hashCode() + s.d((r4 + r11) * 31, 31, this.step)) * 31;
            ServerRef r13 = this.server;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            Exit r16 = this.exit;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.error;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = androidx.compose.foundation.interaction.f.c(this.attempt, w0.c(w0.c((r18 + r20) * 31, 31, this.startedAt), 31, this.connectedAt), 31);
            String r22 = this.lastWhy;
            if (r22 == null) goto L23;
            r10 = r22.hashCode();
        L23:
            return r21 + r10;
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r8.hashCode();
            goto L6
        }

        public String toString() {
            String r4 = this.phase;
            String r8 = this.method;
            String r10 = this.step;
            Mode r11 = this.mode;
            ServerRef r12 = this.server;
            Exit r13 = this.exit;
            String r14 = this.error;
            long r15 = this.startedAt;
            long r16 = this.connectedAt;
            int r17 = this.attempt;
            String r18 = this.lastWhy;
            StringBuilder r19 = s.n("Status(phase=", r4, ", method=", r8, ", step=");
            r19.append(r10);
            r19.append(", mode=");
            r19.append(r11);
            r19.append(", server=");
            r19.append(r12);
            r19.append(", exit=");
            r19.append(r13);
            r19.append(", error=");
            s.q(r15, r14, ", startedAt=", r19);
            v0.a.k(r16, ", connectedAt=", ", attempt=", r19);
            r19.append(r17);
            r19.append(", lastWhy=");
            r19.append(r18);
            r19.append(")");
            return r19.toString();
        }

        public Status(String r4, String r8, String r10, Mode r11, ServerRef r12, Exit r13, String r14, long r15, long r16, int r17, String r18) {
            kotlin.jvm.internal.j.e(r4, "phase");
            kotlin.jvm.internal.j.e(r10, "step");
            kotlin.jvm.internal.j.e(r11, "mode");
            this.phase = r4;
            this.method = r8;
            this.step = r10;
            this.mode = r11;
            this.server = r12;
            this.exit = r13;
            this.error = r14;
            this.startedAt = r15;
            this.connectedAt = r16;
            this.attempt = r17;
            this.lastWhy = r18;
        }

        public /* synthetic */ Status(String r14, String r15, String r16, Mode r17, ServerRef r18, Exit r19, String r20, long r21, long r23, int r25, String r26, int r27, kotlin.jvm.internal.e r28) {
            if ((r27 & 1) == 0) goto L6;
            r14 = "off";
        L6:
            if ((r27 & 2) == 0) goto L8;
            String r4 = null;
        L10:
            if ((r27 & 4) == 0) goto L12;
            String r8 = "";
        L14:
            if ((r27 & 8) == 0) goto L16;
            Mode r10 = Mode.TUNNEL;
        L18:
            if ((r27 & 16) == 0) goto L20;
            ServerRef r11 = null;
        L22:
            if ((r27 & 32) == 0) goto L24;
            Exit r12 = null;
        L26:
            if ((r27 & 64) == 0) goto L28;
            String r13 = null;
        L29:
            long r22 = 0;
            if ((r27 & 128) == 0) goto L32;
            long r110 = 0;
        L34:
            if ((r27 & 256) != 0) goto L38;
            r22 = r23;
        L38:
            if ((r27 & 512) == 0) goto L40;
            int r24 = 0;
        L42:
            if ((r27 & 1024) == 0) goto L45;
            String r29 = null;
        L46:
            this(r14, r4, r8, r10, r11, r12, r13, r110, r22, r24, r29);
            return;
        L45:
            r29 = r26;
            goto L46
        L40:
            r24 = r25;
            goto L42
        L32:
            r110 = r21;
            goto L34
        L28:
            r13 = r20;
            goto L29
        L24:
            r12 = r19;
            goto L26
        L20:
            r11 = r18;
            goto L22
        L16:
            r10 = r17;
            goto L18
        L12:
            r8 = r16;
            goto L14
        L8:
            r4 = r15;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {496, 504, 505, 506, 507}, m = ScoutScore.CONNECT)
    public static final class AnonymousClass1 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public AnonymousClass1(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$connect(this.this$0, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {523, 526, 544, 546, 550}, m = "connectCatalog")
    public static final class C06061 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06061(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$connectCatalog(this.this$0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10", f = "MamiEngine.kt", l = {546}, m = "invokeSuspend")
    public static final class AnonymousClass10 extends xd.j implements ee.c {
        final /* synthetic */ y $list;
        int label;

        public AnonymousClass10(y r4, wd.d r8) {
            this.$list = r4;
            super(1, r8);
        }

        @Override // xd.a
        public final wd.d create(wd.d r4) {
            return new AnonymousClass10(this.$list, r4);
        }

        @Override // ee.c
        public /* bridge */ /* synthetic */ Object invoke(Object r4) {
            return invoke((wd.d) r4);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r10) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            if (r8 == 0) goto L9;
            if (r8 != 1) goto L8;
            m.b(r10);
            return r10;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            m.b(r10);
            MamiEngine r11 = MamiEngine.INSTANCE;
            List r12 = (List) this.$list.element;
            this.label = 1;
            Object r13 = MamiEngine.scout$default(r11, r12, true, false, this, 4, null);
            if (r13 != r4) goto L12;
            return r4;
        L12:
            return r13;
        }

        public final Object invoke(wd.d r4) {
            return ((AnonymousClass10) create(r4)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends xd.j implements ee.e {
        int label;

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
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L7;
            m.b(r4);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass3) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {608, 611, 619, 635, 645}, m = "connectExclusive")
    public static final class C06071 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06071(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$connectExclusive(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06083 extends xd.j implements ee.e {
        int label;

        public C06083(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06083(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L7;
            m.b(r4);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06083) create(r4, r8)).invokeSuspend(u.f67154a);
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
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06091(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$connectFront(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06103 extends xd.j implements ee.e {
        final /* synthetic */ String $engine;
        int label;

        public C06103(String r4, wd.d r8) {
            this.$engine = r4;
            super(2, r8);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06103(this.$engine, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L19;
            m.b(r8);
            CoreConfig r10 = CoreConfig.INSTANCE;
            Context r11 = MamiEngine.access$getApp$p();
            if (r11 == null) goto L16;
            String r12 = r10.json(r11, this.$engine);
            Context r13 = MamiEngine.access$getApp$p();
            if (r13 == null) goto L14;
            Context r14 = MamiEngine.access$getApp$p();
            if (r14 == null) goto L12;
            v1.c.h(r13, new Intent(r14, TunnelVpnService.class).setAction(TunnelVpnService.ACTION_CONNECT).putExtra("config", r12));
            return u.f67154a;
        L12:
            kotlin.jvm.internal.j.k("app");
            throw null;
        L14:
            kotlin.jvm.internal.j.k("app");
            throw null;
        L16:
            kotlin.jvm.internal.j.k("app");
            throw null;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06103) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {583, 586, 593, 595, 598}, m = "connectHive")
    public static final class C06111 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06111(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$connectHive(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06123 extends xd.j implements ee.e {
        int label;

        public C06123(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06123(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L7;
            m.b(r4);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06123) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8", f = "MamiEngine.kt", l = {595}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends xd.j implements ee.c {
        final /* synthetic */ y $list;
        int label;

        public AnonymousClass8(y r4, wd.d r8) {
            this.$list = r4;
            super(1, r8);
        }

        @Override // xd.a
        public final wd.d create(wd.d r4) {
            return new AnonymousClass8(this.$list, r4);
        }

        @Override // ee.c
        public /* bridge */ /* synthetic */ Object invoke(Object r4) {
            return invoke((wd.d) r4);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r10 = this.label;
            if (r10 == 0) goto L9;
            if (r10 != 1) goto L8;
            m.b(r4);
            return r4;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            m.b(r4);
            MamiEngine r11 = MamiEngine.INSTANCE;
            List r12 = (List) this.$list.element;
            this.label = 1;
            Object r13 = MamiEngine.access$scout(r11, r12, true, true, this);
            if (r13 != r8) goto L12;
            return r8;
        L12:
            return r13;
        }

        public final Object invoke(wd.d r4) {
            return ((AnonymousClass8) create(r4)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {809}, m = "disconnectNow")
    public static final class C06131 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06131(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$disconnectNow(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06143 extends xd.j implements ee.e {
        final /* synthetic */ ExclusiveLive $ex;
        private /* synthetic */ Object L$0;
        int label;

        public C06143(ExclusiveLive r4, wd.d r8) {
            this.$ex = r4;
            super(2, r8);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            C06143 r10 = new C06143(this.$ex, r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r10) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L16;
            m.b(r10);
            i0 r11 = (i0) this.L$0;
            ExclusiveLive r12 = this.$ex;
            ArgoNet r8 = ArgoNet.INSTANCE;     // Catch: Throwable -> L8
            String r13 = r12.getHost();     // Catch: Throwable -> L8
            int r14 = r12.getPort();     // Catch: Throwable -> L8
            ArgoProtocol.SessionInfo r15 = r12.getInfo();     // Catch: Throwable -> L8
            LocalPort r16 = LocalPort.INSTANCE;     // Catch: Throwable -> L8
            Context r17 = MamiEngine.access$getApp$p();     // Catch: Throwable -> L8
            if (r17 == null) goto L10;
            Object r18 = l.m1004constructorimpl(r8.sessionRequest("disconnect", r13, r14, r15, r16.get(r17) + LocalPort.PROBE_OFFSET, 6000));     // Catch: Throwable -> L8
        L14:
            return l.m1003boximpl(r18);
        L10:
            kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L8
            throw null;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            r18 = l.m1004constructorimpl(m.a(th));
            goto L14
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06143) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {880, 882}, m = "launch")
    public static final class C06151 extends xd.c {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06151(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$launch(this.this$0, null, null, this);
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

        public C06163(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06163(r8);
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
            Object r13 = kotlinx.coroutines.flow.h.h(r11, r12, this);
            if (r13 != r4) goto L12;
            return r4;
        L12:
            return r13;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06163) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2", f = "MamiEngine.kt", l = {419}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends xd.j implements ee.e {
        final /* synthetic */ List<j> $items;
        final /* synthetic */ String $probeUrl;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1", f = "MamiEngine.kt", l = {430}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends xd.j implements ee.e {
            final /* synthetic */ List<j> $items;
            final /* synthetic */ ConcurrentHashMap<String, Long> $out;
            final /* synthetic */ String $probeUrl;
            final /* synthetic */ kotlinx.coroutines.sync.h $sem;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(List<? extends j> r4, kotlinx.coroutines.sync.h r8, ConcurrentHashMap<String, Long> r10, String r11, wd.d r12) {
                this.$items = r4;
                this.$sem = r8;
                this.$out = r10;
                this.$probeUrl = r11;
                super(2, r12);
            }

            @Override // xd.a
            public final wd.d create(Object r8, wd.d r10) {
                AnonymousClass1 r4 = new AnonymousClass1(this.$items, this.$sem, this.$out, this.$probeUrl, r10);
                r4.L$0 = r8;
                return r4;
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r12) {
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                int r8 = this.label;
                if (r8 == 0) goto L9;
                if (r8 != 1) goto L8;
                m.b(r12);
                return r12;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                m.b(r12);
                i0 r13 = (i0) this.L$0;
                List<j> r10 = this.$items;
                kotlinx.coroutines.sync.h r11 = this.$sem;
                ConcurrentHashMap<String, Long> r14 = this.$out;
                String r15 = this.$probeUrl;
                ArrayList r16 = new ArrayList(kotlin.collections.s.g0(r10, 10));
                Iterator<T> r17 = r10.iterator();
            L11:
                if (r17.hasNext() == false) goto L13;
                j r18 = (j) r17.next();
                r16.add(m0.c(r13, null, new MamiEngine$measure$2$1$1$1(r11, r14, (String) r18.component1(), r15, (sf.c) r18.component2(), null), 3));
                goto L11
            L13:
                this.label = 1;
                Object r19 = m0.d(r16, this);
                if (r19 != r4) goto L16;
                return r4;
            L16:
                return r19;
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((AnonymousClass1) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(List<? extends j> r4, String r8, wd.d r10) {
            this.$items = r4;
            this.$probeUrl = r8;
            super(2, r10);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new AnonymousClass2(this.$items, this.$probeUrl, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r10) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            if (r8 == 0) goto L9;
            if (r8 != 1) goto L8;
            ConcurrentHashMap r11 = (ConcurrentHashMap) this.L$0;
            m.b(r10);
            return r11;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            m.b(r10);
            CombineEngine r12 = CombineEngine.INSTANCE;
            Context r13 = MamiEngine.access$getApp$p();
            if (r13 == null) goto L15;
            r12.ensureCoreEnv(r13);
            ConcurrentHashMap r14 = new ConcurrentHashMap();
            kotlinx.coroutines.sync.l r15 = new kotlinx.coroutines.sync.l(8);
            AnonymousClass1 r16 = new AnonymousClass1(this.$items, r15, r14, this.$probeUrl, null);
            this.L$0 = r14;
            this.label = 1;
            if (m0.L(30000, r16, this) != r4) goto L14;
            return r4;
        L14:
            return r14;
        L15:
            kotlin.jvm.internal.j.k("app");
            throw null;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass2) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1", f = "MamiEngine.kt", l = {470}, m = "invokeSuspend")
    public static final class C06171 extends xd.j implements ee.e {
        final /* synthetic */ Context $context;
        int label;

        public C06171(Context r4, wd.d r8) {
            this.$context = r4;
            super(2, r8);
        }

        public static /* synthetic */ Status d(Status r4) {
            return invokeSuspend$lambda$0(r4);
        }

        private static final Status invokeSuspend$lambda$0(Status r17) {
            return Status.copy$default(r17, null, null, null, null, null, null, "هنوز فهرستی نیست — اول «به\u200cروزرسانی فهرست» را بزنید", 0, 0, 0, null, 1983, null);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06171(this.$context, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r14) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            u r10 = u.f67154a;
            if (r8 == 0) goto L13;
            if (r8 != 1) goto L12;
            m.b(r14);     // Catch: Throwable -> L7 CancellationException -> L9
        L30:
            g1 r15 = (g1) MamiEngine.access$get_busy$p();
            r15.getClass();
            r15.k(null, "");
            MamiEngine.access$bump(MamiEngine.INSTANCE);
        L33:
            return r10;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            m.b(r14);
            MamiEngine r11 = MamiEngine.INSTANCE;
            r11.init(this.$context);
            if (((CharSequence) ((g1) MamiEngine.access$get_busy$p()).getValue()).length() <= 0) goto L16;
            return r10;
        L16:
            MamiCatalog.Parsed r16 = MamiEngine.access$parsedSaved(r11);
            if (r16 != null) goto L20;
            MamiEngine.access$setStatus(r11, new f(0));
            return r10;
        L20:
            g1 r12 = (g1) MamiEngine.access$get_busy$p();
            r12.getClass();
            r12.k(null, "measure");
            List<MamiCatalog.Server> r17 = r16.getServers();     // Catch: Throwable -> L7 CancellationException -> L9
            ArrayList r13 = new ArrayList();     // Catch: Throwable -> L7 CancellationException -> L9
            Iterator<T> r18 = r17.iterator();     // Catch: Throwable -> L7 CancellationException -> L9
        L23:
            if (r18.hasNext() == false) goto L27;
            Object r19 = r18.next();     // Catch: Throwable -> L7 CancellationException -> L9
            if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) r19, false, 2, null) != null) goto L23;
            r13.add(r19);     // Catch: Throwable -> L7 CancellationException -> L9
            goto L23
        L27:
            this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
            if (MamiEngine.scout$default(r11, r13, true, false, this, 4, null) != r4) goto L30;
            return r4;
        L34:
            th = move-exception;
            g1 r20 = (g1) MamiEngine.access$get_busy$p();
            r20.getClass();
            r20.k(null, "");
            MamiEngine.access$bump(MamiEngine.INSTANCE);
            throw th;
        L7:
            th = move-exception;
            MamiEngine r21 = MamiEngine.INSTANCE;     // Catch: Throwable -> L34
            r21.log("سنجش انجام نشد: " + th.getMessage());     // Catch: Throwable -> L34
            g1 r110 = (g1) MamiEngine.access$get_busy$p();
            r110.getClass();
            r110.k(null, "");
            MamiEngine.access$bump(r21);
        L9:
            e = move-exception;
            throw e;     // Catch: Throwable -> L34
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06171) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06181 extends xd.j implements ee.e {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $what;
        int label;

        public C06181(Context r4, String r8, wd.d r10) {
            this.$context = r4;
            this.$what = r8;
            super(2, r10);
        }

        public static /* synthetic */ Status d(Throwable r4, Status r8) {
            return invokeSuspend$lambda$0(r4, r8);
        }

        private static final Status invokeSuspend$lambda$0(Throwable r17, Status r18) {
            return Status.copy$default(r18, null, null, null, null, null, null, r17.getMessage(), 0, 0, 0, null, 1983, null);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06181(this.$context, this.$what, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r10) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L46;
            m.b(r10);
            MamiEngine r11 = MamiEngine.INSTANCE;
            r11.init(this.$context);
            int r8 = ((CharSequence) ((g1) MamiEngine.access$get_busy$p()).getValue()).length();
            u r12 = u.f67154a;
            if (r8 <= 0) goto L8;
        L9:
            return r12;
        L8:
            if (kotlin.jvm.internal.j.a(((Status) ((g1) MamiEngine.access$get_status$p()).getValue()).getPhase(), TunnelVpnService.STATUS_CONNECTING) == true) goto L9;
            ((g1) MamiEngine.access$get_busy$p()).j(this.$what);
            MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);     // Catch: Throwable -> L18 CancellationException -> L20
            if (kotlin.jvm.internal.j.a(this.$what, "hive") == false) goto L24;
            MamiEngine.access$hiveNow(r11, true);     // Catch: Throwable -> L18 CancellationException -> L20
            MamiCatalog.Hive r13 = MamiEngine.access$parsedHive(r11);     // Catch: Throwable -> L18 CancellationException -> L20
            if (r13 == null) goto L22;
            List<MamiCatalog.Server> r14 = r13.getServers();     // Catch: Throwable -> L18 CancellationException -> L20
            if (r14 == null) goto L22;
            int r15 = r14.size();     // Catch: Throwable -> L18 CancellationException -> L20
        L23:
            r11.log("فهرست لیون تازه گرفته شد: " + r15 + " پل.");     // Catch: Throwable -> L18 CancellationException -> L20
        L31:
            g1 r16 = (g1) MamiEngine.access$get_busy$p();
            r16.getClass();
            r16.k(null, "");
            MamiEngine.access$bump(r11);
            return r12;
        L22:
            r15 = 0;
            goto L23
        L24:
            MamiEngine.access$catalogNow(r11, true);     // Catch: Throwable -> L18 CancellationException -> L20
            MamiCatalog.Parsed r17 = MamiEngine.access$parsedSaved(r11);     // Catch: Throwable -> L18 CancellationException -> L20
            if (r17 == null) goto L29;
            List<MamiCatalog.Server> r18 = r17.getServers();     // Catch: Throwable -> L18 CancellationException -> L20
            if (r18 == null) goto L29;
            int r19 = r18.size();     // Catch: Throwable -> L18 CancellationException -> L20
        L30:
            r11.log("فهرست تازه گرفته شد: " + r19 + " سرور.");     // Catch: Throwable -> L18 CancellationException -> L20
        L29:
            r19 = 0;
        L36:
            th = move-exception;
            g1 r20 = (g1) MamiEngine.access$get_busy$p();
            r20.getClass();
            r20.k(null, "");
            MamiEngine.access$bump(MamiEngine.INSTANCE);
            throw th;
        L20:
            e = move-exception;
            throw e;     // Catch: Throwable -> L36
        L18:
            th = move-exception;
            MamiEngine r21 = MamiEngine.INSTANCE;     // Catch: Throwable -> L36
            if (kotlin.jvm.internal.j.a(this.$what, "hive") == false) goto L38;
            String r22 = "فهرست لیون";
        L39:
            r21.log(r22 + " گرفته نشد: " + th.getMessage());     // Catch: Throwable -> L36
            MamiEngine.access$setStatus(r21, new g(0, th));     // Catch: Throwable -> L36
            g1 r110 = (g1) MamiEngine.access$get_busy$p();
            r110.getClass();
            r110.k(null, "");
            MamiEngine.access$bump(r21);
            return r12;
        L38:
            r22 = "فهرست";
            goto L39
        L46:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06181) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$scout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {447}, m = "scout")
    public static final class C06191 extends xd.c {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06191(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$scout(this.this$0, null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$settleAfterRegister$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {565, 567}, m = "settleAfterRegister")
    public static final class C06201 extends xd.c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06201(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$settleAfterRegister(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1", f = "MamiEngine.kt", l = {955, 974, 974, 979}, m = "invokeSuspend")
    public static final class C06211 extends xd.j implements ee.e {
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
        public static final class C00671 extends xd.j implements ee.e {
            final /* synthetic */ ExclusiveLive $ex;
            int label;

            public C00671(ExclusiveLive r4, wd.d r8) {
                this.$ex = r4;
                super(2, r8);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                return new C00671(this.$ex, r8);
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r12) {
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) goto L11;
                m.b(r12);
                ArgoNet r8 = ArgoNet.INSTANCE;
                String r10 = this.$ex.getHost();
                int r11 = this.$ex.getPort();
                ArgoProtocol.SessionInfo r13 = this.$ex.getInfo();
                LocalPort r14 = LocalPort.INSTANCE;
                Context r15 = MamiEngine.access$getApp$p();
                if (r15 != null) goto L7;
                kotlin.jvm.internal.j.k("app");
                throw null;
            L7:
                return ArgoNet.sessionRequest$default(r8, AetherScanService.EXTRA_KEEPALIVE, r10, r11, r13, r14.get(r15) + LocalPort.PROBE_OFFSET, 0, 32, null);
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((C00671) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5", f = "MamiEngine.kt", l = {995}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends xd.j implements ee.e {
            final /* synthetic */ Live $l;
            final /* synthetic */ Prefs $p;
            int label;

            public AnonymousClass5(Live r4, Prefs r8, wd.d r10) {
                this.$l = r4;
                this.$p = r8;
                super(2, r10);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                return new AnonymousClass5(this.$l, this.$p, r8);
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r10) {
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                int r8 = this.label;
                if (r8 == 0) goto L13;
                if (r8 != 1) goto L12;
                m.b(r10);     // Catch: Throwable -> L7 CancellationException -> L9
            L21:
            L19:
                return u.f67154a;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L13:
                m.b(r10);
                MamiEngine r11 = MamiEngine.INSTANCE;     // Catch: Throwable -> L7 CancellationException -> L9
                Mode r12 = this.$l.getMode();     // Catch: Throwable -> L7 CancellationException -> L9
                String r13 = this.$p.getLocation();     // Catch: Throwable -> L7 CancellationException -> L9
                List r14 = m9.d.B(this.$l.getCand().getId());     // Catch: Throwable -> L7 CancellationException -> L9
                this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
                if (MamiEngine.access$connect(r11, "auto", r12, null, r13, r14, this) != r4) goto L21;
                return r4;
            L9:
                e = move-exception;
                throw e;
            L7:
                th = move-exception;
                MamiEngine.INSTANCE.log("جابه\u200cجایی سرور نشد: " + th.getMessage());
                goto L19
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((AnonymousClass5) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        public C06211(wd.d r4) {
            super(2, r4);
        }

        public static /* synthetic */ Status d(Status r4) {
            return invokeSuspend$lambda$2(r4);
        }

        public static /* synthetic */ Status f(Exit r4, Status r8) {
            return invokeSuspend$lambda$1(r4, r8);
        }

        public static /* synthetic */ Status g(Status r4) {
            return invokeSuspend$lambda$0(r4);
        }

        private static final Status invokeSuspend$lambda$0(Status r17) {
            return Status.copy$default(r17, "on", null, null, null, null, null, null, 0, 0, 0, null, 2046, null);
        }

        private static final Status invokeSuspend$lambda$1(Exit r17, Status r18) {
            return Status.copy$default(r18, null, null, null, null, null, r17, null, 0, 0, 0, null, 2015, null);
        }

        private static final Status invokeSuspend$lambda$2(Status r17) {
            return Status.copy$default(r17, "lost", null, null, null, null, null, null, 0, 0, 0, null, 2046, null);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            C06211 r10 = new C06211(r8);
            r10.L$0 = r4;
            return r10;
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x02ba -> B:16:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0193 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0195 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0199 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01b5 -> B:81:0x01b8). Please report as a decompilation issue!!! */
        @Override // xd.a
        public final Object invokeSuspend(Object r32) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r8 = this.label;
            long r10 = 5000;
            long r11 = 0;
            if (r8 == 0) goto L14;
            if (r8 == 1) goto L13;
            if (r8 == 2) goto L12;
            if (r8 == 3) goto L11;
            if (r8 != 4) goto L10;
            long r14 = this.J$0;
            int r12 = this.I$1;
            int r13 = this.I$0;
            Exit r15 = (Exit) this.L$2;
            Live r16 = (Live) this.L$1;
            i0 r17 = (i0) this.L$0;
            m.b(r32);
            long r20 = 5000;
            Object r18 = r32;
        L81:
            j r19 = (j) r18;
            boolean r21 = ((Boolean) r19.component1()).booleanValue();
            int r22 = ((Number) r19.component2()).intValue();
            MamiEngine r23 = MamiEngine.INSTANCE;
            if (r21 == false) goto L84;
            String r24 = "نشست با پل اختصاصی تمدید شد.";
        L85:
            r23.log(r24);
        L86:
            if (r15 != null) goto L88;
            int r25 = r12 + 1;
            if (r25 < 2) goto L97;
            if (kotlin.jvm.internal.j.a(((Status) ((g1) MamiEngine.access$get_status$p()).getValue()).getPhase(), "on") == false) goto L97;
            MamiEngine r26 = MamiEngine.INSTANCE;
            MamiEngine.access$setStatus(r26, new f(2));
            r26.log("دو آزمون پیاپی از داخل اتصال جواب نداد.");
        L97:
            if (r25 < 3) goto L107;
            if (kotlin.jvm.internal.j.a(r16.getKind(), "xray") == false) goto L107;
            if (kotlin.jvm.internal.j.a(((Status) ((g1) MamiEngine.access$get_status$p()).getValue()).getMethod(), "auto") == false) goto L107;
            if (r16.getCand() == null) goto L107;
            MamiEngine r27 = MamiEngine.INSTANCE;
            r27.log("سرور " + MamiEngine.access$placeLabel(r27, r16.getCand()) + " جواب نمی\u200cدهد — رفتن به سرور بعدی…");
            MamiEngine.access$setConnectJob$p(m0.y(MamiEngine.access$getScope$p(), null, null, new AnonymousClass5(r16, r27.prefs(), null), 3));
        L122:
            return u.f67154a;
        L107:
            int r28 = r13;
            int r110 = r25;
            i0 r29 = r17;
            int r30 = r28;
            long r31 = r14;
            r10 = r20;
            r11 = 0;
        L17:
            if (m0.t(r29) == false) goto L122;
            this.L$0 = r29;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = r30;
            this.I$1 = r110;
            this.J$0 = r31;
            this.label = 1;
            if (m0.j(r10, this) == r4) goto L80;
        L21:
            Live r111 = MamiEngine.access$getLive$p();
            if (r111 == null) goto L122;
            TunnelUiState r112 = (TunnelUiState) TunnelController.INSTANCE.getState().getValue();
            r20 = r10;
            if (kotlin.jvm.internal.j.a(r111.getKind(), WarpIdRelay.VIA_FRONT) == true) goto L27;
        L42:
            boolean r33 = false;
        L44:
            if (kotlin.jvm.internal.j.a(r111.getKind(), "xray") == true) goto L46;
            if (r33 == false) goto L50;
        L110:
            if (kotlin.jvm.internal.j.a(r111.getKind(), "xray") == true) goto L112;
        L113:
            if (r33 == false) goto L115;
        L114:
            String r210 = "replaced";
        L116:
            MamiEngine.access$setLive$p(null);
            MamiEngine.access$setFrontMarker$p(null);
            MamiEngine.access$setExclusiveLive$p(null);
            ((g1) MamiEngine.access$get_status$p()).j(Status.copy$default((Status) ((g1) MamiEngine.access$get_status$p()).getValue(), "off", null, "", null, null, null, null, 0, 0, 0, r210, 986, null));
            MamiEngine r34 = MamiEngine.INSTANCE;
            if (r210.equals("replaced") == false) goto L119;
            String r35 = "اتصال دیگری موتور را برداشت؛ مامی قطع شد.";
        L120:
            r34.log(r35);
            MamiEngine.access$bump(r34);
            goto L122
        L119:
            r35 = "موتور مامی خاموش شد.";
            goto L120
        L115:
            r210 = "stopped";
            goto L116
        L112:
            if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.CONNECTED) goto L114;
        L50:
            if (MamiEngine.access$frontUp(MamiEngine.INSTANCE) == false) goto L110;
        L52:
            r31 = r31 + r20;
            if (r31 < 60000) goto L108;
            int r36 = r30 + 1;
            if (kotlin.jvm.internal.j.a(r111.getKind(), "xray") == false) goto L62;
            MamiEngine r37 = MamiEngine.INSTANCE;
            this.L$0 = r29;
            this.L$1 = r111;
            this.I$0 = r36;
            this.I$1 = r110;
            this.J$0 = r11;
            this.label = 2;
            Object r38 = MamiEngine.access$traceHttp(r37, this);
            if (r38 == r4) goto L80;
            i0 r113 = r29;
            r12 = r110;
            Live r114 = r111;
            long r39 = r11;
        L60:
            Exit r40 = (Exit) r38;
        L61:
            Live r310 = r114;
            r13 = r36;
            r17 = r113;
            r14 = r39;
            r16 = r310;
            r15 = r40;
            if (MamiEngine.access$getLive$p() != r16) goto L122;
            ExclusiveLive r41 = MamiEngine.access$getExclusiveLive$p();
            Cand r42 = r16.getCand();
            if (r42 == null) goto L72;
            String r43 = r42.getId();
        L74:
            if (kotlin.jvm.internal.j.a(r43, "exclusive") == false) goto L86;
            if (r41 == null) goto L86;
            if ((r13 % 10) != 0) goto L86;
            oe.e r44 = v0.f24208c;
            C00671 r45 = new C00671(r41, null);
            this.L$0 = r17;
            this.L$1 = r16;
            this.L$2 = r15;
            this.I$0 = r13;
            this.I$1 = r12;
            this.J$0 = r14;
            this.label = 4;
            r18 = m0.J(r44, r45, this);
            if (r18 != r4) goto L81;
        L72:
            r43 = null;
            goto L74
        L62:
            MamiEngine r46 = MamiEngine.INSTANCE;
            this.L$0 = r29;
            this.L$1 = r111;
            this.I$0 = r36;
            this.I$1 = r110;
            this.J$0 = r11;
            this.label = 3;
            Object r47 = MamiEngine.access$traceFront(r46, this);
            if (r47 == r4) goto L80;
            r113 = r29;
            r12 = r110;
            r114 = r111;
            r39 = r11;
        L66:
            r40 = (Exit) r47;
            goto L61
        L108:
            r10 = r20;
            goto L17
        L46:
            if (MamiEngine.INSTANCE.isOurs() == true) goto L52;
        L27:
            if (r112.getStage() != TunnelStage.RUNNING) goto L42;
            if (MamiEngine.access$getFrontTransport$p() == null) goto L42;
            Transport r48 = r112.getActive();
            if (r48 == null) goto L33;
            String r49 = r48.getId();
        L34:
            if (r49 == null) goto L42;
            Transport r50 = r112.getActive();
            if (r50 == null) goto L38;
            String r51 = r50.getId();
        L40:
            if (kotlin.jvm.internal.j.a(r51, MamiEngine.access$getFrontTransport$p()) == true) goto L42;
            r33 = true;
            goto L44
        L38:
            r51 = null;
            goto L40
        L33:
            r49 = null;
        L80:
            return r4;
        L88:
            if (kotlin.jvm.internal.j.a(((Status) ((g1) MamiEngine.access$get_status$p()).getValue()).getPhase(), "lost") == false) goto L90;
            MamiEngine r52 = MamiEngine.INSTANCE;
            MamiEngine.access$setStatus(r52, new f(1));
            r52.log("اتصال دوباره داده رد می\u200cکند.");
        L90:
            MamiEngine.access$setStatus(MamiEngine.INSTANCE, new h(r15, 0));
            r29 = r17;
            r30 = r13;
            r31 = r14;
            r10 = r20;
            r11 = 0;
        L15:
            r110 = 0;
            goto L17
        L84:
            r24 = androidx.compose.foundation.interaction.f.o(r22, "تمدید نشست پل جواب نداد (کد ", ").");
            goto L85
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r39 = this.J$0;
            r12 = this.I$1;
            r36 = this.I$0;
            r114 = (Live) this.L$1;
            r113 = (i0) this.L$0;
            m.b(r32);
            r20 = 5000;
            r47 = r32;
            goto L66
        L12:
            r39 = this.J$0;
            r12 = this.I$1;
            r36 = this.I$0;
            r114 = (Live) this.L$1;
            r113 = (i0) this.L$0;
            m.b(r32);
            r20 = 5000;
            r38 = r32;
            goto L60
        L13:
            r31 = this.J$0;
            int r53 = this.I$1;
            r30 = this.I$0;
            i0 r115 = (i0) this.L$0;
            m.b(r32);
            r110 = r53;
            r29 = r115;
            goto L21
        L14:
            m.b(r32);
            r29 = (i0) this.L$0;
            r31 = 0;
            r30 = 0;
            goto L15
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06211) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2", f = "MamiEngine.kt", l = {922}, m = "invokeSuspend")
    public static final class C06222 extends xd.j implements ee.e {
        long J$0;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceFront$2$2", f = "MamiEngine.kt", l = {922}, m = "invokeSuspend")
        public static final class C00682 extends xd.j implements ee.e {
            final /* synthetic */ TunnelController $tc;
            int label;

            public C00682(TunnelController r4, wd.d r8) {
                this.$tc = r4;
                super(2, r8);
            }

            @Override // xd.a
            public final wd.d create(Object r4, wd.d r8) {
                return new C00682(this.$tc, r8);
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
                return invoke((i0) r4, (wd.d) r8);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object r8) {
                kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                int r10 = this.label;
                if (r10 == 0) goto L8;
                if (r10 == 1) goto L8;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                m.b(r8);
            L9:
                String r11 = ((TunnelUiState) this.$tc.getState().getValue()).getExitIp();
                if (r11 != null) goto L12;
            L16:
                this.label = 1;
                if (m0.j(MamiEngine.CATALOG_MARGIN_SEC, this) != r4) goto L9;
                return r4;
            L12:
                if (o.L0(r11) == true) goto L16;
                return u.f67154a;
            }

            public final Object invoke(i0 r4, wd.d r8) {
                return ((C00682) create(r4, r8)).invokeSuspend(u.f67154a);
            }
        }

        public C06222(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06222(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            long r11 = this.J$0;
            TunnelController r12 = (TunnelController) this.L$0;
            m.b(r8);
        L21:
            TunnelUiState r13 = (TunnelUiState) r12.getState().getValue();
            String r14 = r13.getCountry();
            String r15 = "";
            if (r14 != null) goto L24;
            r14 = "";
        L24:
            String r16 = r13.getExitIp();
            if (r16 == null) goto L28;
            r15 = r16;
        L28:
            String r17 = r13.getExitIp();
            if (r17 != null) goto L31;
        L34:
            long r18 = 0;
        L36:
            return new Exit(r14, r15, r18);
        L31:
            if (o.L0(r17) == true) goto L34;
            r18 = System.currentTimeMillis() - r11;
            goto L36
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            m.b(r8);
            int r19 = TunnelStatus.INSTANCE.getActiveSocksPort();
            if (r19 <= 0) goto L16;
            MamiEngine r20 = MamiEngine.INSTANCE;
            Exit r21 = MamiEngine.access$trace(r20, new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, r19)));
            if (r21 != null) goto L13;
            return null;
        L13:
            return MamiEngine.access$realExit(r20, r21);
        L16:
            if (MamiEngine.access$frontUp(MamiEngine.INSTANCE) == false) goto L37;
            TunnelController r22 = TunnelController.INSTANCE;
            long r23 = System.currentTimeMillis();
            C00682 r24 = new C00682(r22, null);
            this.L$0 = r22;
            this.J$0 = r23;
            this.label = 1;
            if (m0.L(6000, r24, this) != r4) goto L20;
            return r4;
        L20:
            r12 = r22;
            r11 = r23;
            goto L21
        L37:
            return null;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06222) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06232 extends xd.j implements ee.e {
        int label;

        public C06232(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06232(r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            kotlin.coroutines.intrinsics.a r4 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L11;
            m.b(r8);
            MamiEngine r10 = MamiEngine.INSTANCE;
            Proxy.Type r11 = Proxy.Type.HTTP;
            LocalPort r12 = LocalPort.INSTANCE;
            Context r13 = MamiEngine.access$getApp$p();
            if (r13 != null) goto L7;
            kotlin.jvm.internal.j.k("app");
            throw null;
        L7:
            return MamiEngine.access$trace(r10, new Proxy(r11, new InetSocketAddress(SniSession.LOCAL_HOST, r12.get(r13) + LocalPort.PROBE_OFFSET)));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06232) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {680, 686, 687, 690}, m = "tryServers")
    public static final class C06241 extends xd.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06241(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$tryServers(this.this$0, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06253 extends xd.j implements ee.e {
        final /* synthetic */ Cand $c;
        final /* synthetic */ PlaceRow $routePlace;
        int label;

        public C06253(Cand r4, PlaceRow r8, wd.d r10) {
            this.$c = r4;
            this.$routePlace = r8;
            super(2, r10);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new C06253(this.$c, this.$routePlace, r8);
        }

        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object r4, Object r8) {
            return invoke((i0) r4, (wd.d) r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            kotlin.coroutines.intrinsics.a r8 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) goto L7;
            m.b(r4);
            MamiEngine.access$applyRoute(MamiEngine.INSTANCE, this.$c, this.$routePlace);
            return u.f67154a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((C06253) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5", f = "MamiEngine.kt", l = {686}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends xd.j implements ee.e {
        int label;

        public AnonymousClass5(wd.d r4) {
            super(2, r4);
        }

        @Override // xd.a
        public final wd.d create(Object r4, wd.d r8) {
            return new AnonymousClass5(r8);
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
            Context r12 = MamiEngine.access$getApp$p();
            if (r12 == null) goto L15;
            this.label = 1;
            if (r11.releaseForXray(r12, this) != r8) goto L14;
            return r8;
        L15:
            kotlin.jvm.internal.j.k("app");
            throw null;
        }

        public final Object invoke(i0 r4, wd.d r8) {
            return ((AnonymousClass5) create(r4, r8)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$verify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {777, 779}, m = "verify")
    public static final class C06261 extends xd.c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MamiEngine this$0;

        public C06261(MamiEngine r4, wd.d r8) {
            this.this$0 = r4;
            super(r8);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.access$verify(this.this$0, null, this);
        }
    }

    static {
        INSTANCE = new MamiEngine();
        METHODS = r.a0(new Method[]{new Method("auto", "auto", "خودکار", "xray", null, true, "بهترین سرور فهرست رمزشدهٔ مامی، با سنجش واقعی تأخیر"), new Method("exclusive", "service:exclusive", "اختصاصی", "xray", null, true, "پلی که سرور مامی برای همین دستگاه می\u200cسازد"), new Method("meteor", "service:meteor", "سان", WarpIdRelay.VIA_FRONT, "geph", true, "شبکهٔ جهانی با مسیرهای پنهان"), new Method("hive", "service:hive", "لیون", "xray", null, true, "پل\u200cهایی که دستگاه\u200cهای دیگر آزموده\u200cاند"), new Method("smart", "service:smart", "هوشمند", WarpIdRelay.VIA_FRONT, "lantern", true, "خودش بهترین راه را پیدا می\u200cکند"), new Method("tor", "service:tor", "تایگر", WarpIdRelay.VIA_FRONT, "tor", true, "ناشناس و چندلایه، با پل\u200cهای خودش")});
        STEP_WORDS = d0.J(new j[]{new j("session", "بررسی نشست این دستگاه با سرور مامی…"), new j("catalog", "گرفتن فهرست سرورها (رمزشده و امضاشده)…"), new j("hive", "گرفتن فهرست پل\u200cهای لیون…"), new j("bridge", "گرفتن پل اختصاصی این دستگاه…"), new j("auth", "احراز هویت با پل اختصاصی…"), new j("scout", "سنجش سرورها برای انتخاب بهترین…"), new j("engine", "راه\u200cاندازی موتور…"), new j("verify", "آزمون عبور داده (یک درخواست واقعی HTTPS)…"), new j("route", "روشن کردن مسیر انتخاب\u200cشده…")});
        r2 r4 = m0.b();
        scope = m0.a(g8.a.D(v0.f24208c, r4));
        g1 r8 = kotlinx.coroutines.flow.h.b(new Status(null, null, null, null, null, null, null, 0, 0, 0, null, 2047, null));
        _status = r8;
        status = r8;
        g1 r10 = kotlinx.coroutines.flow.h.b(w.INSTANCE);
        _logs = r10;
        logs = r10;
        g1 r11 = kotlinx.coroutines.flow.h.b(0);
        _version = r11;
        version = r11;
        g1 r12 = kotlinx.coroutines.flow.h.b("");
        _busy = r12;
        busy = r12;
        connectionOwner = new ConnectionOwner();
        delays = new ConcurrentHashMap();
        ENGINE_NAMES = r.a0(new String[]{"ArgoVPN", "Argo", "آرگو", "Geph5", "Geph", "گف", LanternProcess.TAG, "لنترن", "Tor", "تور"});
        $stable = 8;
    }

    private MamiEngine() {
    }

    public static /* synthetic */ Status a(Status r4) {
        return connectFront$lambda$78(r4);
    }

    public static final /* synthetic */ void access$applyRoute(MamiEngine r4, Cand r8, PlaceRow r10) {
        r4.applyRoute(r8, r10);
    }

    public static final /* synthetic */ void access$bump(MamiEngine r4) {
        r4.bump();
    }

    public static final /* synthetic */ MamiCatalog.Parsed access$catalogNow(MamiEngine r4, boolean r8) {
        return r4.catalogNow(r8);
    }

    public static final /* synthetic */ Object access$connect(MamiEngine r4, String r8, Mode r10, String r11, String r12, List r13, wd.d r14) {
        return r4.connect(r8, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ Object access$connectCatalog(MamiEngine r4, Mode r8, String r10, String r11, List r12, wd.d r13) {
        return r4.connectCatalog(r8, r10, r11, r12, r13);
    }

    public static final /* synthetic */ Object access$connectExclusive(MamiEngine r4, Mode r8, wd.d r10) {
        return r4.connectExclusive(r8, r10);
    }

    public static final /* synthetic */ Object access$connectFront(MamiEngine r4, Method r8, Mode r10, wd.d r11) {
        return r4.connectFront(r8, r10, r11);
    }

    public static final /* synthetic */ Object access$connectHive(MamiEngine r4, Mode r8, List r10, wd.d r11) {
        return r4.connectHive(r8, r10, r11);
    }

    public static final /* synthetic */ Object access$disconnectNow(MamiEngine r4, String r8, wd.d r10) {
        return r4.disconnectNow(r8, r10);
    }

    public static final /* synthetic */ boolean access$frontUp(MamiEngine r4) {
        return r4.frontUp();
    }

    public static final /* synthetic */ Context access$getApp$p() {
        return app;
    }

    public static final /* synthetic */ ExclusiveLive access$getExclusiveLive$p() {
        return exclusiveLive;
    }

    public static final /* synthetic */ String access$getFrontTransport$p() {
        return frontTransport;
    }

    public static final /* synthetic */ Live access$getLive$p() {
        return live;
    }

    public static final /* synthetic */ i0 access$getScope$p() {
        return scope;
    }

    public static final /* synthetic */ k0 access$get_busy$p() {
        return _busy;
    }

    public static final /* synthetic */ k0 access$get_status$p() {
        return _status;
    }

    public static final /* synthetic */ MamiCatalog.Hive access$hiveNow(MamiEngine r4, boolean r8) {
        return r4.hiveNow(r8);
    }

    public static final /* synthetic */ Object access$launch(MamiEngine r4, String r8, Mode r10, wd.d r11) {
        return r4.launch(r8, r10, r11);
    }

    public static final /* synthetic */ Object access$measure(MamiEngine r4, List r8, String r10, wd.d r11) {
        return r4.measure(r8, r10, r11);
    }

    public static final /* synthetic */ MamiCatalog.Hive access$parsedHive(MamiEngine r4) {
        return r4.parsedHive();
    }

    public static final /* synthetic */ MamiCatalog.Parsed access$parsedSaved(MamiEngine r4) {
        return r4.parsedSaved();
    }

    public static final /* synthetic */ String access$placeLabel(MamiEngine r4, Cand r8) {
        return r4.placeLabel(r8);
    }

    public static final /* synthetic */ Exit access$realExit(MamiEngine r4, Exit r8) {
        return r4.realExit(r8);
    }

    public static final /* synthetic */ Object access$scout(MamiEngine r4, List r8, boolean r10, boolean r11, wd.d r12) {
        return r4.scout(r8, r10, r11, r12);
    }

    public static final /* synthetic */ void access$setConnectJob$p(s1 r4) {
        connectJob = r4;
    }

    public static final /* synthetic */ void access$setExclusiveLive$p(ExclusiveLive r4) {
        exclusiveLive = r4;
    }

    public static final /* synthetic */ void access$setFrontMarker$p(String r4) {
        frontMarker = r4;
    }

    public static final /* synthetic */ void access$setLive$p(Live r4) {
        live = r4;
    }

    public static final /* synthetic */ void access$setStatus(MamiEngine r4, ee.c r8) {
        r4.setStatus(r8);
    }

    public static final /* synthetic */ Object access$settleAfterRegister(MamiEngine r4, List r8, ee.c r10, wd.d r11) {
        return r4.settleAfterRegister(r8, r10, r11);
    }

    public static final /* synthetic */ String access$testConfig(MamiEngine r4, sf.c r8) {
        return r4.testConfig(r8);
    }

    public static final /* synthetic */ Exit access$trace(MamiEngine r4, Proxy r8) {
        return r4.trace(r8);
    }

    public static final /* synthetic */ Object access$traceFront(MamiEngine r4, wd.d r8) {
        return r4.traceFront(r8);
    }

    public static final /* synthetic */ Object access$traceHttp(MamiEngine r4, wd.d r8) {
        return r4.traceHttp(r8);
    }

    public static final /* synthetic */ Object access$tryServers(MamiEngine r4, List r8, Mode r10, PlaceRow r11, boolean r12, wd.d r13) {
        return r4.tryServers(r8, r10, r11, r12, r13);
    }

    public static final /* synthetic */ Object access$verify(MamiEngine r4, ee.c r8, wd.d r10) {
        return r4.verify(r8, r10);
    }

    private final void applyRoute(Cand r4, PlaceRow r8) {
        MamiCatalog.Server r10 = r4.getServer();
        if (r10 == null) goto L30;
        j r11 = confirmedRoute();
        if (r8 == null) goto L16;
        j r12 = new j(r10.getProfile(), r8.getId());
        if (kotlin.jvm.internal.j.a(r11, r12) == true) goto L31;
        MamiApi.INSTANCE.route((String) r12.getFirst(), (String) r12.getSecond(), true);     // Catch: Exception -> L13
        saveRoute(r12);
        return;
    L13:
        e = move-exception;
        throw new Fail("ROUTE_FAILED", w0.n("انتخاب مکان به سرور مامی گفته نشد (", e.getMessage(), ") — اتصال لغو شد"));
    L31:
        return;
    L16:
        if (r11 == null) goto L29;
        j r13 = new j(r10.getProfile(), r10.getLocationId());
        if (r11.equals(r13) == true) goto L32;
        MamiApi.INSTANCE.route((String) r13.getFirst(), (String) r13.getSecond(), false);     // Catch: Exception -> L22
        saveRoute(null);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        log("برگشت به مکانِ خود سرور به سرور مامی گفته نشد (" + e.getMessage() + ").");
        return;
    L32:
        return;
    L29:
        return;
    }

    public static /* synthetic */ s1 b(Context r4, String r8, List r10) {
        return connectAsync$lambda$43(r4, r8, r10);
    }

    private final void bump() {
        k0 r4 = _version;
        Integer r8 = Integer.valueOf(((Number) ((g1) r4).getValue()).intValue() + 1);
        g1 r10 = (g1) r4;
        r10.getClass();
        r10.k(null, r8);
    }

    public static /* synthetic */ Status c(Status r4) {
        return connectExclusive$lambda$68(r4);
    }

    private final Cand candOf(MamiCatalog.Server r13, PlaceRow r14) {
        j r4 = placeOfServer(r13);
        String r8 = (String) r4.component1();
        String r10 = (String) r4.component2();
        String r11 = r13.getId();
        sf.c r15 = MamiXrayConfig.outboundFor$default(MamiXrayConfig.INSTANCE, r13, WarpIdRelay.VIA_PROXY, false, 4, null);
        if (r14 == null) goto L8;
        String r12 = r14.getCc();
        if (r12 == null) goto L8;
    L7:
        String r16 = r12;
        if (r14 == null) goto L14;
        String r17 = r14.getCountry();
        if (r17 == null) goto L14;
        String r18 = r17;
    L15:
        if (r14 == null) goto L20;
        String r19 = r14.getCity();
        if (r19 == null) goto L20;
        String r20 = r19;
    L22:
        return new Cand(r11, r13, r15, r16, r18, r20, r13.getLocationId(), r13.getProtocol(), r13.getProfile());
    L20:
        r20 = r10;
    L14:
        r18 = r8;
    L8:
        r12 = r13.getCountryCode();
        goto L7
    }

    private final MamiCatalog.Parsed catalogNow(boolean r12) {
        Object r4 = l.m1004constructorimpl(MamiApi.INSTANCE.savedCatalog());     // Catch: Throwable -> L4
    L6:
        sf.c r8 = null;
        if (l.m1010isFailureimpl(r4) == false) goto L9;
        r4 = null;
    L9:
        sf.c r10 = (sf.c) r4;
        if (r10 == null) goto L12;
        sf.c r11 = r10.w("payload");
    L14:
        if (r11 != null) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r12 == true) goto L35;
        if (r13 == false) goto L35;
    L29:
        MamiCatalog.Parsed r14 = parsedSaved();
        if (r14 == null) goto L33;
        return r14;
    L33:
        throw new IllegalStateException("فهرست سرورهای مامی خوانده نشد");
    L35:
        MamiApi.fetchCatalog$default(MamiApi.INSTANCE, null, 1, null);     // Catch: Exception -> L23
    L28:
        bump();
    L23:
        e = move-exception;
        if (r10 == null) goto L26;
        r8 = r10.w("payload");
    L26:
        if (r8 == null) goto L34;
        log("فهرست تازه گرفته نشد (" + e.getMessage() + ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود.");
        goto L28
    L34:
        throw e;
    L16:
        if (r10.x(0, "expiresAt") <= (MamiApi.INSTANCE.nowSec() + CATALOG_MARGIN_SEC)) goto L18;
        r13 = true;
        goto L19
    L12:
        r11 = null;
    L4:
        th = move-exception;
        r4 = l.m1004constructorimpl(m.a(th));
        goto L6
    }

    public static /* synthetic */ MamiCatalog.Parsed catalogNow$default(MamiEngine r4, boolean r8, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r8 = false;
    L6:
        return r4.catalogNow(r8);
    }

    private final void check() {
        if (cancelled == true) goto L6;
        return;
    L6:
        throw new CancellationException("لغو شد");
    }

    private static final Status clearError$lambda$88(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, null, null, null, null, null, 0, 0, 0, null, 1983, null);
    }

    private final sf.c clientInfo() {
        String r4 = Build.MODEL;
        String r8 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r10 = o.l1(80, o.n1(r4).toString());
        if (r10.length() >= 2) goto L8;
        r10 = "Android device";
    L8:
        String r11 = Build.VERSION.RELEASE;
        if (r11 == null) goto L12;
        r8 = r11;
    L12:
        String r12 = o.l1(24, r8);
        if (o.L0(r12) == false) goto L15;
        r12 = String.valueOf(Build.VERSION.SDK_INT);
    L15:
        Locale r13 = Locale.getDefault();
        List r14 = r.a0(new String[]{r13.getLanguage(), r13.getCountry()});
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Object r17 = r16.next();
        String r18 = (String) r17;
        kotlin.jvm.internal.j.b(r18);
        if (o.L0(r18) == true) goto L17;
        r15.add(r17);
        goto L17
    L21:
        String r19 = q.F0(r15, "-", null, null, null, 62);
        if (o.L0(r19) == false) goto L24;
        r19 = GerehLocale.EN;
    L24:
        String r20 = TimeZone.getDefault().getID();
        if (o.L0(r20) == false) goto L27;
        r20 = "UTC";
    L27:
        sf.c r21 = i.p("deviceModel", r10, "androidVersion", r12);
        i.s(56, "appVersionName", MamiApi.VERSION_NAME, "appVersionCode", r21);
        r21.D("locale", r19);
        r21.D(DeviceSignals.TIMEZONE, r20);
        return r21;
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
    private final String config(sf.c r17) {
        LocalPort r4 = LocalPort.INSTANCE;
        Context r8 = app;
        if (r8 == null) goto L19;
        int r10 = r4.get(r8);
        sf.c r11 = i.o("remarks", REMARKS);
        sf.c r12 = new sf.c();
        r12.D("loglevel", "warning");
        r11.D(XrayCoreHostService.KEY_LOG, r12);
        sf.a r13 = new sf.a();
        sf.c r14 = i.o("tag", "socks");
        com.mlmvpn.scanner.e.q(r10, PsiphonProbeService.PORT, "listen", SniSession.LOCAL_HOST, r14);
        sf.c r15 = com.mlmvpn.scanner.e.n(r14, "protocol", "mixed", "auth", "noauth");
        r15.E("udp", true);
        r14.D("settings", r15);
        sf.c r16 = new sf.c();
        r16.E("enabled", true);
        sf.a r18 = new sf.a();
        r18.put(ExitProxy.HTTP);
        r18.put("tls");
        r16.D("destOverride", r18);
        r14.D("sniffing", r16);
        r13.put(r14);
        sf.c r19 = new sf.c();
        r19.D("tag", ExitProxy.HTTP);
        r19.D(PsiphonProbeService.PORT, Integer.valueOf(r10 + LocalPort.PROBE_OFFSET));
        r19.D("listen", SniSession.LOCAL_HOST);
        r19.D("protocol", ExitProxy.HTTP);
        r13.put(r19);
        r11.D("inbounds", r13);
        XrayJsonGenerator r20 = XrayJsonGenerator.INSTANCE;
        sf.c r21 = r20.quicRefusalOutbound();
        sf.a r22 = new sf.a();
        sf.c r23 = new sf.c(r17.toString());
        sf.c r24 = com.mlmvpn.scanner.e.o(r23, "tag", WarpIdRelay.VIA_PROXY, r22, r23);
        r24.D("tag", WarpIdRelay.VIA_DIRECT);
        sf.c r25 = com.mlmvpn.scanner.e.o(r24, "protocol", "freedom", r22, r24);
        r25.D("tag", "dns-out");
        sf.c r26 = com.mlmvpn.scanner.e.o(r25, "protocol", "dns", r22, r25);
        r26.D("tag", "blocked");
        r26.D("protocol", "blackhole");
        r22.put(r26);
        if (r21 == null) goto L7;
        r22.put(r21);
    L7:
        r11.D("outbounds", r22);
        sf.c r27 = new sf.c();
        r27.D("tag", "mami-dns");
        sf.a r110 = new sf.a();
        sf.c r111 = new sf.c();
        r111.D("address", "https://8.8.8.8/dns-query");
        r110.put(r111);
        sf.c r112 = new sf.c();
        r112.D("address", "https://1.1.1.1/dns-query");
        r110.put(r112);
        r27.D("servers", r110);
        r27.D("queryStrategy", "UseIPv4");
        r11.D("dns", r27);
        sf.a r28 = new sf.a();
        sf.c r113 = i.p(TeXSymbolParser.TYPE_ATTR, "field", PsiphonProbeService.PORT, "53");
        sf.c r114 = com.mlmvpn.scanner.e.o(r113, "outboundTag", "dns-out", r28, r113);
        r114.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a r115 = new sf.a();
        r115.put("mami-dns");
        r114.D("inboundTag", r115);
        sf.c r29 = com.mlmvpn.scanner.e.o(r114, "outboundTag", WarpIdRelay.VIA_PROXY, r28, r114);
        r29.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a r30 = new sf.a();
        r30.put("geoip:private");
        r29.D("ip", r30);
        sf.c r31 = com.mlmvpn.scanner.e.o(r29, "outboundTag", WarpIdRelay.VIA_DIRECT, r28, r29);
        r31.D(TeXSymbolParser.TYPE_ATTR, "field");
        r31.D(StudioError.NETWORK, "udp");
        r31.D(PsiphonProbeService.PORT, "443");
        if (r21 == null) goto L13;
        String r32 = r21.A("tag", "");
        if (r32 == null) goto L13;
        String r116 = r32;
    L14:
        sf.c r33 = com.mlmvpn.scanner.e.o(r31, "outboundTag", r116, r28, r31);
        r33.D("domainStrategy", "AsIs");
        r33.D("rules", r28);
        r11.D("routing", r33);
        if (r21 == null) goto L17;
        r20.addQuicRefusalPolicyTo(r11);
    L17:
        String r34 = r11.toString();
        kotlin.jvm.internal.j.d(r34, "toString(...)");
        return r34;
    L13:
        r116 = "blocked";
        goto L14
    L19:
        kotlin.jvm.internal.j.k("app");
        throw null;
    }

    private final j confirmedRoute() {
        String r4 = sp().getString("route", null);
        if (r4 == null) goto L21;
        Object r8 = l.m1004constructorimpl(new sf.c(r4));     // Catch: Throwable -> L6
    L9:
        if (l.m1010isFailureimpl(r8) == false) goto L11;
        r8 = null;
    L11:
        sf.c r10 = (sf.c) r8;
        if (r10 == null) goto L22;
        j r11 = new j(r10.A("profile", ""), r10.A("locationId", ""));
        Object r12 = r11.getFirst();
        kotlin.jvm.internal.j.d(r12, "<get-first>(...)");
        if (o.L0((CharSequence) r12) == true) goto L23;
        Object r13 = r11.getSecond();
        kotlin.jvm.internal.j.d(r13, "<get-second>(...)");
        if (o.L0((CharSequence) r13) == false) goto L18;
        return null;
    L18:
        return r11;
    L23:
        return null;
    L22:
        return null;
    L6:
        th = move-exception;
        r8 = l.m1004constructorimpl(m.a(th));
        goto L9
    L21:
        return null;
    }

    private final Object connect(String r36, Mode r37, String r38, String r39, List<String> r40, wd.d r41) {
        u r4 = u.f67154a;
        if ((r41 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r8 = (AnonymousClass1) r41;
        int r10 = r8.label;
        if ((r10 & TLObject.FLAG_31) == 0) goto L7;
        r8.label = r10 - TLObject.FLAG_31;
    L8:
        Object r11 = r8.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r8.label;
        if (r13 == 0) goto L23;
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L15;
        if (r13 == 4) goto L15;
        if (r13 == 5) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Method r14 = (Method) r8.L$1;
        MamiEngine r15 = (MamiEngine) r8.L$0;
        m.b(r11);     // Catch: Throwable -> L18
    L98:
        return r4;
    L18:
        th = th;
        boolean r16 = false;
    L75:
        if (cancelled == false) goto L77;
    L81:
        boolean r17 = true;
    L82:
        live = null;
        frontMarker = null;
        String r18 = th.getMessage();
        if (r18 != null) goto L85;
        r18 = "وصل نشد";
    L85:
        String r19 = r15.unnamed$app_release(r18, r14.getName());
        k0 r20 = _status;
        Status r110 = (Status) ((g1) r20).getValue();
        if (r17 == false) goto L88;
        String r26 = null;
    L89:
        ((g1) r20).j(Status.copy$default(r110, "off", null, "", null, null, null, r26, 0, 0, 0, null, 1978, null));
        if (r17 == true) goto L92;
        r15.log("وصل نشد: " + r19);
    L92:
        r15.bump();
        if ((th instanceof CancellationException) == false) goto L98;
        if (cancelled == true) goto L98;
        throw th;
    L88:
        r26 = r19;
        goto L89
    L77:
        if ((th instanceof CancellationException) == true) goto L81;
        r17 = r16;
        goto L82
    L22:
        Method r21 = (Method) r8.L$5;
        List<String> r111 = (List) r8.L$4;
        String r112 = (String) r8.L$3;
        String r113 = (String) r8.L$2;
        r16 = false;
        Mode r22 = (Mode) r8.L$1;
        MamiEngine r23 = (MamiEngine) r8.L$0;
        m.b(r11);
        Mode r24 = r22;
    L33:
        cancelled = r16;
        if (kotlin.jvm.internal.j.a(r21.getKind(), WarpIdRelay.VIA_FRONT) == false) goto L36;
        Mode r25 = Mode.TUNNEL;
    L37:
        k0 r27 = _status;
        String r114 = r21.getKey();
        if (kotlin.jvm.internal.j.a(r21.getKind(), "xray") == false) goto L41;
        String r28 = "session";
    L42:
        Status r115 = new Status(TunnelVpnService.STATUS_CONNECTING, r114, r28, r25, null, null, null, System.currentTimeMillis(), 0, 0, null, 1904, null);
        Mode r29 = r25;
        g1 r30 = (g1) r27;
        r30.getClass();
        r30.k(null, r115);
        String r31 = r21.getName();
        if (r29 != Mode.TUNNEL) goto L45;
        String r32 = "تونل کامل";
    L46:
        r23.log(d1.h("اتصال با روش «", r31, "» (", r32, ")…"));
    L72:
        th = th;
        r15 = r23;
    L71:
        r14 = r21;
        goto L75
    L103:
        if (kotlin.jvm.internal.j.a(r21.getKind(), WarpIdRelay.VIA_FRONT) == false) goto L55;
        r8.L$0 = r23;     // Catch: Throwable -> L52
        r8.L$1 = r21;     // Catch: Throwable -> L52
        r8.L$2 = null;     // Catch: Throwable -> L52
        r8.L$3 = null;     // Catch: Throwable -> L52
        r8.L$4 = null;     // Catch: Throwable -> L52
        r8.L$5 = null;     // Catch: Throwable -> L52
        r8.label = 2;     // Catch: Throwable -> L52
        if (r23.connectFront(r21, r24, r8) != r12) goto L98;
    L68:
        return r12;
    L55:
        if (kotlin.jvm.internal.j.a(r21.getKey(), "hive") == false) goto L60;
        r8.L$0 = r23;     // Catch: Throwable -> L52
        r8.L$1 = r21;     // Catch: Throwable -> L52
        r8.L$2 = null;     // Catch: Throwable -> L52
        r8.L$3 = null;     // Catch: Throwable -> L52
        r8.L$4 = null;     // Catch: Throwable -> L52
        r8.L$5 = null;     // Catch: Throwable -> L52
        r8.label = 3;     // Catch: Throwable -> L52
        if (r23.connectHive(r24, r111, r8) != r12) goto L98;
    L60:
        if (kotlin.jvm.internal.j.a(r21.getKey(), "exclusive") == false) goto L64;
        r8.L$0 = r23;     // Catch: Throwable -> L52
        r8.L$1 = r21;     // Catch: Throwable -> L52
        r8.L$2 = null;     // Catch: Throwable -> L52
        r8.L$3 = null;     // Catch: Throwable -> L52
        r8.L$4 = null;     // Catch: Throwable -> L52
        r8.L$5 = null;     // Catch: Throwable -> L52
        r8.label = 4;     // Catch: Throwable -> L52
        if (r23.connectExclusive(r24, r8) != r12) goto L98;
    L64:
        r8.L$0 = r23;     // Catch: Throwable -> L72
        r8.L$1 = r21;     // Catch: Throwable -> L72
        r8.L$2 = null;     // Catch: Throwable -> L72
        r8.L$3 = null;     // Catch: Throwable -> L72
        r8.L$4 = null;     // Catch: Throwable -> L72
        r8.L$5 = null;     // Catch: Throwable -> L72
        r8.label = 5;     // Catch: Throwable -> L72
        MamiEngine r310 = r23;
        if (r310.connectCatalog(r24, r113, r112, r111, r8) != r12) goto L98;
    L69:
        th = th;
        r15 = r310;
    L52:
        th = th;
        r14 = r21;
        r15 = r23;
        goto L75
    L45:
        r32 = "پراکسی";
        goto L46
    L41:
        r28 = "engine";
        goto L42
    L36:
        r25 = r24;
        goto L37
    L23:
        r16 = false;
        m.b(r11);
        r21 = method(r36);
        if (r21 != null) goto L27;
        return r4;
    L27:
        if (((Status) ((g1) _status).getValue()).getLive() == false) goto L31;
        r8.L$0 = this;
        r24 = r37;
        r8.L$1 = r24;
        String r33 = r38;
        r8.L$2 = r33;
        String r34 = r39;
        r8.L$3 = r34;
        r111 = r40;
        r8.L$4 = r111;
        r8.L$5 = r21;
        r8.label = 1;
        if (disconnectNow("switch", r8) == r12) goto L68;
    L32:
        r113 = r33;
        r112 = r34;
        r23 = this;
        goto L33
    L31:
        r24 = r37;
        r33 = r38;
        r34 = r39;
        r111 = r40;
    L7:
        r8 = new AnonymousClass1(this, r41);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s1 connectAsync$default(MamiEngine r4, Context r8, String r10, List r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = w.INSTANCE;
    L9:
        return r4.connectAsync(r8, r10, r11);
    }

    private static final s1 connectAsync$lambda$43(Context r4, String r8, List r10) {
        INSTANCE.init(r4);
        s1 r11 = connectJob;
        if (r11 == null) goto L5;
        r11.cancel(null);
    L5:
        s1 r12 = watchJob;
        if (r12 == null) goto L8;
        r12.cancel(null);
    L8:
        q2 r13 = m0.y(scope, null, null, new MamiEngine$connectAsync$1$1(r8, r10, null), 3);
        connectJob = r13;
        return r13;
    }

    private final Object connectCatalog(Mode r18, String r19, String r20, List<String> r21, wd.d r22) {
        if ((r22 instanceof C06061) == false) goto L8;
        C06061 r4 = (C06061) r22;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L8;
        r4.label = r8 - TLObject.FLAG_31;
    L7:
        C06061 r10 = r4;
        Object r11 = r10.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r10.label;
        if (r13 == 0) goto L23;
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L21;
        if (r13 == 3) goto L20;
        if (r13 == 4) goto L19;
        if (r13 != 5) goto L18;
        m.b(r11);
    L115:
        return u.f67154a;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        y r14 = (y) r10.L$3;
        y r15 = (y) r10.L$2;
        Mode r16 = (Mode) r10.L$1;
        MamiEngine r17 = (MamiEngine) r10.L$0;
        m.b(r11);
    L94:
        ArrayList r23 = new ArrayList();
        Iterator r24 = ((List) r11).iterator();
    L96:
        if (r24.hasNext() == false) goto L100;
        Object r25 = r24.next();
        if (((Ranked) r25).getMs() <= 0) goto L96;
        r23.add(r25);
        goto L96
    L100:
        List r26 = q.e1(r23, 3);
        ArrayList r27 = new ArrayList(kotlin.collections.s.g0(r26, 10));
        Iterator r28 = r26.iterator();
    L102:
        if (r28.hasNext() == false) goto L105;
        r27.add(((Ranked) r28.next()).getServer());
        goto L102
    L105:
        if (r27.isEmpty() == true) goto L117;
        y r29 = r14;
        MamiEngine r30 = r17;
        Object r31 = r27;
    L107:
        Iterable r32 = (Iterable) r31;
        ArrayList r33 = new ArrayList(kotlin.collections.s.g0(r32, 10));
        Iterator r34 = r32.iterator();
    L109:
        if (r34.hasNext() == false) goto L111;
        r33.add(INSTANCE.candOf((MamiCatalog.Server) r34.next(), (PlaceRow) r29.element));
        goto L109
    L111:
        PlaceRow r35 = (PlaceRow) r29.element;
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 5;
        if (r30.tryServers(r33, r16, r35, true, r10) != r12) goto L115;
    L113:
        return r12;
    L117:
        throw new Fail("NONE_ANSWERED", androidx.compose.foundation.interaction.f.o(((List) r15.element).size(), "هیچ\u200cکدام از ", " سرور مامی در سنجش جواب نداد"));
    L20:
        r14 = (y) r10.L$3;
        r15 = (y) r10.L$2;
        r16 = (Mode) r10.L$1;
        r17 = (MamiEngine) r10.L$0;
        m.b(r11);
    L91:
        r17.check();
        AnonymousClass10 r36 = new AnonymousClass10(r15, null);
        r10.L$0 = r17;
        r10.L$1 = r16;
        r10.L$2 = r15;
        r10.L$3 = r14;
        r10.label = 4;
        r11 = r17.settleAfterRegister((List) r11, r36, r10);
        if (r11 != r12) goto L94;
    L21:
        List<String> r37 = (List) r10.L$4;
        String r38 = (String) r10.L$3;
        String r39 = (String) r10.L$2;
        Mode r40 = (Mode) r10.L$1;
        MamiEngine r41 = (MamiEngine) r10.L$0;
        m.b(r11);
        Mode r110 = r40;
    L31:
        r41.check();
        y r42 = new y();
        List<MamiCatalog.Server> r43 = ((MamiCatalog.Parsed) r11).getServers();
        ArrayList r111 = new ArrayList();
        Iterator<T> r44 = r43.iterator();
    L33:
        if (r44.hasNext() == false) goto L38;
        Object r112 = r44.next();
        if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) r112, false, 2, null) != null) goto L33;
        r111.add(r112);
        goto L33
    L38:
        r42.element = r111;
        if (r111.isEmpty() == true) goto L119;
        r29 = new y();
        if (o.L0(r38) == true) goto L52;
        Iterator<T> r45 = r41.locations().iterator();
    L44:
        if (r45.hasNext() == false) goto L48;
        Object r46 = r45.next();
        if (kotlin.jvm.internal.j.a(((PlaceRow) r46).getId(), r38) == false) goto L44;
    L49:
        r29.element = r46;
        if (r46 != null) goto L52;
        r41.log("مکان انتخاب\u200cشده در فهرست فعلی نیست؛ مکانِ خود سرور به کار می\u200cرود.");
        goto L52
    L48:
        r46 = null;
    L52:
        if (r39 != null) goto L54;
    L68:
        Set r47 = q.p1(r37);
        if (r47.isEmpty() == true) goto L87;
        Iterable r48 = (Iterable) r42.element;
        if ((r48 instanceof Collection) == true) goto L73;
    L75:
        Iterator r49 = r48.iterator();
    L77:
        if (r49.hasNext() == false) goto L87;
        if (r47.contains(((MamiCatalog.Server) r49.next()).getId()) == true) goto L77;
        Iterable r50 = (Iterable) r42.element;
        ArrayList r51 = new ArrayList();
        Iterator r52 = r50.iterator();
    L82:
        if (r52.hasNext() == false) goto L86;
        Object r53 = r52.next();
        if (r47.contains(((MamiCatalog.Server) r53).getId()) == true) goto L82;
        r51.add(r53);
        goto L82
    L86:
        r42.element = r51;
        goto L87
    L73:
        if (((Collection) r48).isEmpty() == false) goto L75;
    L87:
        r41.setStatus(new f(10));
        List r54 = (List) r42.element;
        r10.L$0 = r41;
        r10.L$1 = r110;
        r10.L$2 = r42;
        r10.L$3 = r29;
        r10.L$4 = null;
        r10.label = 3;
        MamiEngine r55 = r41;
        Object r56 = scout$default(r55, r54, false, false, r10, 6, null);
        if (r56 == r12) goto L113;
        r15 = r42;
        r11 = r56;
        r17 = r55;
        r16 = r110;
        r14 = r29;
        goto L91
    L54:
        if (o.L0(r39) == true) goto L68;
        Iterator r57 = ((Iterable) r42.element).iterator();
    L58:
        if (r57.hasNext() == false) goto L62;
        Object r58 = r57.next();
        if (kotlin.jvm.internal.j.a(((MamiCatalog.Server) r58).getId(), r39) == false) goto L58;
    L63:
        MamiCatalog.Server r59 = (MamiCatalog.Server) r58;
        if (r59 == null) goto L67;
        List r60 = m9.d.B(r59);
        r30 = r41;
        r16 = r110;
        r31 = r60;
        goto L107
    L67:
        throw new Fail("NO_SERVER", "این سرور در فهرست فعلی مامی نیست");
    L62:
        r58 = null;
        goto L63
    L119:
        throw new Fail("NO_SERVERS", "فهرست مامی هیچ سروری نداشت که این برنامه بتواند اجرا کند");
    L22:
        List<String> r61 = (List) r10.L$4;
        r38 = (String) r10.L$3;
        String r62 = (String) r10.L$2;
        Mode r63 = (Mode) r10.L$1;
        r41 = (MamiEngine) r10.L$0;
        m.b(r11);
        String r64 = r62;
        Mode r65 = r63;
        List<String> r113 = r61;
    L27:
        r41.check();
        r41.setStatus(new f(9));
        oe.e r66 = v0.f24208c;
        MamiEngine$connectCatalog$parsed$1 r67 = new MamiEngine$connectCatalog$parsed$1(null);
        r10.L$0 = r41;
        r10.L$1 = r65;
        r10.L$2 = r64;
        r10.L$3 = r38;
        r10.L$4 = r113;
        r10.label = 2;
        r11 = m0.J(r66, r67, r10);
        if (r11 == r12) goto L113;
        r37 = r113;
        r110 = r65;
        r39 = r64;
        goto L31
    L23:
        m.b(r11);
        setStatus(new f(8));
        oe.e r68 = v0.f24208c;
        AnonymousClass3 r69 = new AnonymousClass3(null);
        r10.L$0 = this;
        r65 = r18;
        r10.L$1 = r65;
        r64 = r19;
        r10.L$2 = r64;
        r10.L$3 = r20;
        r113 = r21;
        r10.L$4 = r113;
        r10.label = 1;
        if (m0.J(r68, r69, r10) == r12) goto L113;
        r38 = r20;
        r41 = this;
    L8:
        r4 = new C06061(this, r22);
        goto L7
    }

    private static final Status connectCatalog$lambda$44(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "session", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectCatalog$lambda$45(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "catalog", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectCatalog$lambda$51(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "scout", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private final Object connectExclusive(Mode r30, wd.d r31) {
        if ((r31 instanceof C06071) == false) goto L8;
        C06071 r4 = (C06071) r31;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L8;
        r4.label = r8 - TLObject.FLAG_31;
    L7:
        C06071 r10 = r4;
        Object r11 = r10.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r10.label;
        if (r13 == 0) goto L23;
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L21;
        if (r13 == 3) goto L20;
        if (r13 == 4) goto L19;
        if (r13 != 5) goto L18;
        m.b(r11);
    L51:
        return u.f67154a;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        MamiExclusive.Endpoint r14 = (MamiExclusive.Endpoint) r10.L$2;
        Mode r15 = (Mode) r10.L$1;
        MamiEngine r16 = (MamiEngine) r10.L$0;
        m.b(r11);
        MamiExclusive.Endpoint r17 = r14;
        MamiEngine r18 = r16;
    L43:
        ArgoNet.Auth r19 = (ArgoNet.Auth) r11;
        r18.check();
        ArgoProtocol.SessionInfo r20 = r19.getInfo();
        if (r19.getOk() == false) goto L53;
        if (r20 == null) goto L53;
        sf.c r21 = new sf.c();
        r21.D("uuid", r20.getUuid());
        r21.D("token", r20.getToken());
        r21.D("wsPath", r20.getWsPath());
        r21.D("grpcServiceName", r20.getGrpcServiceName());
        Map<String, String> r22 = r20.getHeaders();
        kotlin.jvm.internal.j.c(r22, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r21.D("headers", new sf.c(r22));
        MamiExclusive r110 = MamiExclusive.INSTANCE;
        sf.c r23 = MamiExclusive.outboundFor$default(r110, r17, r110.sessionInfo(r21), null, null, 12, null);
        exclusiveLive = new ExclusiveLive(r17.getHostName(), r17.getPort(), r20);
        List<Cand> r24 = m9.d.B(new Cand("exclusive", null, r23, "", "پل اختصاصی", "", "exclusive", "vmess", "EXC"));
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 5;
        if (r18.tryServers(r24, r15, null, false, r10) != r12) goto L51;
    L49:
        return r12;
    L53:
        if (o.L0(r19.getError()) == true) goto L55;
        String r25 = v0.a.h(": ", r18.unnamed$app_release(r19.getError(), "اختصاصی"));
    L57:
        throw new Fail("EXCLUSIVE_AUTH", v0.a.h("پل اختصاصی احراز هویت را نپذیرفت", r25));
    L55:
        r25 = "";
        goto L57
    L20:
        MamiExclusive.Bridge r26 = (MamiExclusive.Bridge) r10.L$2;
        Mode r27 = (Mode) r10.L$1;
        MamiEngine r28 = (MamiEngine) r10.L$0;
        m.b(r11);
    L35:
        MamiExclusive.Endpoint r29 = MamiExclusive.INSTANCE.endpointFor(r26, (MamiExclusive.Template) r11);
        r28.check();
        if (kotlin.jvm.internal.j.a(r29.getProtocol(), "B") == false) goto L38;
        String r32 = "gRPC";
    L39:
        r28.setStatus(new g(1, r32));
        r28.log("احراز هویت با پل اختصاصی (" + r32 + ")…");
        oe.e r33 = v0.f24208c;
        MamiEngine$connectExclusive$a$1 r34 = new MamiEngine$connectExclusive$a$1(r29, null);
        r10.L$0 = r28;
        r10.L$1 = r27;
        r10.L$2 = r29;
        r10.label = 4;
        r11 = m0.J(r33, r34, r10);
        if (r11 == r12) goto L49;
        r17 = r29;
        r15 = r27;
        r18 = r28;
        goto L43
    L38:
        r32 = "WebSocket";
        goto L39
    L21:
        Mode r35 = (Mode) r10.L$1;
        r28 = (MamiEngine) r10.L$0;
        m.b(r11);
    L31:
        MamiExclusive.Bridge r36 = (MamiExclusive.Bridge) r11;
        r28.check();
        oe.e r37 = v0.f24208c;
        MamiEngine$connectExclusive$template$1 r111 = new MamiEngine$connectExclusive$template$1(null);
        r10.L$0 = r28;
        r10.L$1 = r35;
        r10.L$2 = r36;
        r10.label = 3;
        Object r38 = m0.J(r37, r111, r10);
        if (r38 == r12) goto L49;
        Mode r210 = r35;
        r26 = r36;
        r11 = r38;
        r27 = r210;
        goto L35
    L22:
        r35 = (Mode) r10.L$1;
        MamiEngine r39 = (MamiEngine) r10.L$0;
        m.b(r11);
    L27:
        r39.check();
        r39.setStatus(new f(17));
        oe.e r40 = v0.f24208c;
        MamiEngine$connectExclusive$bridge$1 r112 = new MamiEngine$connectExclusive$bridge$1(null);
        r10.L$0 = r39;
        r10.L$1 = r35;
        r10.label = 2;
        r11 = m0.J(r40, r112, r10);
        if (r11 == r12) goto L49;
        r28 = r39;
        goto L31
    L23:
        m.b(r11);
        setStatus(new f(16));
        oe.e r41 = v0.f24208c;
        C06083 r42 = new C06083(null);
        r10.L$0 = this;
        r10.L$1 = r30;
        r10.label = 1;
        if (m0.J(r41, r42, r10) == r12) goto L49;
        r39 = this;
        r35 = r30;
    L8:
        r4 = new C06071(this, r31);
        goto L7
    }

    private static final Status connectExclusive$lambda$67(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "session", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectExclusive$lambda$68(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "bridge", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectExclusive$lambda$69(String r17, Status r18) {
        kotlin.jvm.internal.j.e(r18, "it");
        return Status.copy$default(r18, null, null, "auth", null, new ServerRef("exclusive", "", "پل اختصاصی", "", r17, "EXC", 0), null, null, 0, 0, 0, null, 2027, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x02c7 -> B:24:0x0096). Please report as a decompilation issue!!! */
    private final Object connectFront(Method r24, Mode r25, wd.d r26) {
        u r4 = u.f67154a;
        if ((r26 instanceof C06091) == false) goto L7;
        C06091 r8 = (C06091) r26;
        int r10 = r8.label;
        if ((r10 & TLObject.FLAG_31) == 0) goto L7;
        r8.label = r10 - TLObject.FLAG_31;
    L8:
        Object r11 = r8.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r8.label;
        String r14 = "ساخت حساب ناشناس برای «";
        if (r13 == 0) goto L37;
        if (r13 == 1) goto L32;
        if (r13 == 2) goto L27;
        if (r13 == 3) goto L21;
        if (r13 != 4) goto L20;
        int r15 = r8.I$0;
        TunnelController r16 = (TunnelController) r8.L$2;
        String r17 = (String) r8.L$1;
        MamiEngine r18 = (MamiEngine) r8.L$0;
        m.b(r11);     // Catch: Throwable -> L17
        u r19 = r4;
        String r20 = r17;
    L132:
        Exit r21 = (Exit) r11;     // Catch: Throwable -> L97
        if (r21 != null) goto L135;
        r18.log("اولین درخواست از داخل موتور دیر جواب داد؛ موتور روشن می\u200cماند.");     // Catch: Throwable -> L97
    L135:
        r18.check();     // Catch: Throwable -> L97
        r18.setStatus(new f(15));     // Catch: Throwable -> L97
        Transport r22 = ((TunnelUiState) r16.getState().getValue()).getActive();     // Catch: Throwable -> L97
        if (r22 == null) goto L138;
        String r23 = r22.getId();     // Catch: Throwable -> L97
    L139:
        frontTransport = r23;     // Catch: Throwable -> L97
        live = new Live(WarpIdRelay.VIA_FRONT, null, null, r20, Mode.TUNNEL);     // Catch: Throwable -> L97
        r18.connected(r21);     // Catch: Throwable -> L97
        return r19;
    L138:
        r23 = null;
    L17:
        th = th;
    L147:
        if (r15 == 0) goto L149;
        r18.stopFront();
    L149:
        frontMarker = null;
        throw th;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        int r27 = r8.I$3;
        int r28 = r8.I$2;
        long r29 = r8.J$1;
        long r110 = r8.J$0;
        int r30 = r8.I$1;
        int r31 = r8.I$0;
        TunnelController r111 = (TunnelController) r8.L$4;
        TunnelUiState r112 = (TunnelUiState) r8.L$3;
        String r32 = (String) r8.L$2;
        Method r210 = (Method) r8.L$1;
        MamiEngine r113 = (MamiEngine) r8.L$0;
        m.b(r11);     // Catch: Throwable -> L25
        r19 = r4;
        kotlin.coroutines.intrinsics.a r33 = r12;
        int r114 = r28;
        TunnelController r34 = r111;
        String r35 = "ساخت حساب ناشناس برای «";
        long r211 = r110;
        int r115 = r27;
        TunnelUiState r116 = r112;
        C06091 r36 = r8;
        int r117 = r31;
        r18 = r113;
        int r37 = r30;
        String r38 = r32;
    L24:
        Method r39 = r210;
        r29 = r29 + ((long) 1000);     // Catch: Throwable -> L97
        r12 = r33;
        r14 = r35;
        r4 = r19;
    L77:
        r18.check();     // Catch: Throwable -> L97
        TunnelUiState r118 = (TunnelUiState) r34.getState().getValue();     // Catch: Throwable -> L97
        r19 = r4;
        if (r118.getStage() != TunnelStage.STARTING) goto L80;
        int r40 = 1;
    L81:
        if (r40 != 0) goto L85;
        if (r118 != r116) goto L85;
        kotlin.coroutines.intrinsics.a r212 = r12;
    L90:
        TunnelStage r41 = r118.getStage();     // Catch: Throwable -> L97
        TunnelStage r42 = TunnelStage.FAILED;     // Catch: Throwable -> L97
        if (r41 != r42) goto L111;
        if (r40 != 0) goto L99;
        if (r118 == r116) goto L111;
        if (r116.getStage() == r42) goto L111;
    L99:
        String r43 = r39.getName();     // Catch: Throwable -> L97
        String r44 = r118.getMessage();     // Catch: Throwable -> L97
        if (r44 != null) goto L102;
    L108:
        String r45 = "";
    L110:
        throw new Fail("ENGINE_FAILED", "«" + r43 + "» بالا نیامد" + r45);     // Catch: Throwable -> L97
    L102:
        if (o.L0(r44) == false) goto L105;
        r44 = null;
    L105:
        if (r44 == null) goto L108;
        r45 = ": " + INSTANCE.unnamed$app_release(r44, r39.getName());     // Catch: Throwable -> L97
        if (r45 != null) goto L110;
    L111:
        if (r37 == 0) goto L119;
        int r46 = r118.getProgress();     // Catch: Throwable -> L97
        if (r46 < 0) goto L119;
        if (r46 >= 101) goto L119;
        if ((r118.getProgress() / 10) == r115) goto L119;
        int r47 = r118.getProgress() / 10;     // Catch: Throwable -> L97
        r18.log(r14 + r39.getName() + "» — " + r118.getProgress() + "٪");     // Catch: Throwable -> L97
        r115 = r47;
    L119:
        r35 = r14;
        long r119 = r211;
        if (r29 >= r119) goto L127;
        r36.L$0 = r18;     // Catch: Throwable -> L97
        r36.L$1 = r39;     // Catch: Throwable -> L97
        r36.L$2 = r38;     // Catch: Throwable -> L97
        r36.L$3 = r116;     // Catch: Throwable -> L97
        r36.L$4 = r34;     // Catch: Throwable -> L97
        r36.I$0 = r117;     // Catch: Throwable -> L97
        r36.I$1 = r37;     // Catch: Throwable -> L97
        r36.J$0 = r119;     // Catch: Throwable -> L97
        r36.J$1 = r29;     // Catch: Throwable -> L97
        r36.I$2 = r40;     // Catch: Throwable -> L97
        r36.I$3 = r115;     // Catch: Throwable -> L97
        r36.label = 3;     // Catch: Throwable -> L97
        r210 = r39;
        int r213 = r40;
        r33 = r212;
        if (m0.j(1000, r36) == r33) goto L162;
        r114 = r213;
        r211 = r119;
        goto L24
    L162:
        return r33;
    L127:
        throw new IllegalStateException("موتور در " + (r119 / ((long) 60000)) + " دقیقه بالا نیامد");     // Catch: Throwable -> L97
    L85:
        r212 = r12;
        if (r118.getStage() == TunnelStage.RUNNING) goto L128;
        if (TunnelStatus.INSTANCE.isActive() == false) goto L90;
    L128:
        r18.check();     // Catch: Throwable -> L97
        r18.setStatus(new f(14));     // Catch: Throwable -> L97
        MamiEngine$connectFront$tr$1 r48 = new MamiEngine$connectFront$tr$1(null);     // Catch: Throwable -> L97
        r36.L$0 = r18;     // Catch: Throwable -> L97
        r36.L$1 = r38;     // Catch: Throwable -> L97
        r36.L$2 = r34;     // Catch: Throwable -> L97
        r36.L$3 = null;     // Catch: Throwable -> L97
        r36.L$4 = null;     // Catch: Throwable -> L97
        r36.I$0 = r117;     // Catch: Throwable -> L97
        r36.label = 4;     // Catch: Throwable -> L97
        r11 = r18.verify(r48, r36);     // Catch: Throwable -> L97
        if (r11 == r212) goto L163;
        r16 = r34;
        r20 = r38;
        goto L132
    L163:
        return r212;
    L80:
        r40 = r114;
    L97:
        th = th;
        r15 = r117;
    L25:
        th = th;
        r15 = r31;
        r18 = r113;
        goto L147
    L27:
        int r49 = r8.I$0;
        TunnelUiState r50 = (TunnelUiState) r8.L$3;
        r38 = (String) r8.L$2;
        Method r51 = (Method) r8.L$1;
        MamiEngine r52 = (MamiEngine) r8.L$0;
        m.b(r11);     // Catch: Throwable -> L30
        int r120 = 1;
    L56:
        if (kotlin.jvm.internal.j.a(r38, "geph") == false) goto L64;
        GephAccount r121 = GephAccount.INSTANCE;     // Catch: Throwable -> L30
        Context r122 = app;     // Catch: Throwable -> L30
        if (r122 != null) goto L60;
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L60:
        if (r121.hasAccount(r122) == true) goto L64;
        int r53 = r120;
    L65:
        if (r53 == 0) goto L68;
        r52.log("ساخت حساب ناشناس برای «" + r51.getName() + "» (فقط بار اول؛ چند ثانیه تا چند دقیقه)…");     // Catch: Throwable -> L30
    L68:
        if (kotlin.jvm.internal.j.a(r38, "tor") == false) goto L70;
        long r123 = 240000;
    L72:
        if (r53 == 0) goto L74;
        long r124 = 1200000;
    L76:
        r211 = r123 + r124;     // Catch: Throwable -> L30
        r114 = 0;
        r117 = r49;
        r36 = r8;
        r18 = r52;
        r29 = 0;
        r115 = -1;
        r116 = r50;
        r39 = r51;
        r37 = r53;
        r34 = TunnelController.INSTANCE;     // Catch: Throwable -> L30
        goto L77
    L74:
        r124 = 0;
        goto L76
    L70:
        r123 = DoctorRunner.VARIANTS_MS;
    L64:
        r53 = 0;
    L30:
        th = th;
        r15 = r49;
        r18 = r52;
        goto L147
    L32:
        r49 = r8.I$0;
        r50 = (TunnelUiState) r8.L$3;
        r38 = (String) r8.L$2;
        r51 = (Method) r8.L$1;
        MamiEngine r125 = (MamiEngine) r8.L$0;
        m.b(r11);     // Catch: Throwable -> L35
        r120 = 1;
    L51:
        oe.e r126 = v0.f24208c;     // Catch: Throwable -> L35
        C06103 r127 = new C06103(r38, null);     // Catch: Throwable -> L35
        r8.L$0 = r125;     // Catch: Throwable -> L35
        r8.L$1 = r51;     // Catch: Throwable -> L35
        r8.L$2 = r38;     // Catch: Throwable -> L35
        r8.L$3 = r50;     // Catch: Throwable -> L35
        r8.I$0 = r49;     // Catch: Throwable -> L35
        r8.label = 2;     // Catch: Throwable -> L35
        if (m0.J(r126, r127, r8) == r12) goto L130;
        r52 = r125;
    L130:
        return r12;
    L35:
        th = th;
        r15 = r49;
        r18 = r125;
        goto L147
    L37:
        m.b(r11);
        String r54 = r24.getEngine();
        if (r54 != null) goto L41;
        return r4;
    L41:
        if (r25 != Mode.PROXY) goto L43;
        log("این روش روی گوشی همیشه تونل کامل است (موتورش درگاه پراکسی جدا ندارد).");
    L43:
        frontMarker = r54;
        setStatus(new f(12));     // Catch: Throwable -> L145
        TunnelUiState r55 = (TunnelUiState) TunnelController.INSTANCE.getState().getValue();     // Catch: Throwable -> L141
        TunnelExclusion r56 = TunnelExclusion.INSTANCE;     // Catch: Throwable -> L141
        Context r57 = app;     // Catch: Throwable -> L141
        if (r57 == null) goto L143;
        r8.L$0 = this;     // Catch: Throwable -> L141
        r8.L$1 = r24;     // Catch: Throwable -> L141
        r8.L$2 = r54;     // Catch: Throwable -> L141
        r8.L$3 = r55;     // Catch: Throwable -> L141
        r120 = 1;
        r8.I$0 = 1;     // Catch: Throwable -> L141
        r8.label = 1;     // Catch: Throwable -> L141
        if (r56.releaseForTunnelStack(r57, r8) == r12) goto L130;
        r38 = r54;
        r50 = r55;
        r51 = r24;
        r49 = 1;
        r125 = this;
        goto L51
    L143:
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L141
        throw null;     // Catch: Throwable -> L141
    L141:
        th = th;
        r18 = this;
        r15 = 1;
    L145:
        th = th;
        r18 = this;
        r15 = 0;
    L7:
        r8 = new C06091(this, r26);
        goto L8
    }

    private static final Status connectFront$lambda$74(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "engine", Mode.TUNNEL, null, null, null, 0, 0, 0, null, 2035, null);
    }

    private static final Status connectFront$lambda$77(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "verify", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectFront$lambda$78(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "route", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private final Object connectHive(Mode r19, List<String> r20, wd.d r21) {
        if ((r21 instanceof C06111) == false) goto L8;
        C06111 r4 = (C06111) r21;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L8;
        r4.label = r8 - TLObject.FLAG_31;
    L7:
        C06111 r10 = r4;
        Object r11 = r10.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r10.label;
        int r14 = 0;
        if (r13 == 0) goto L25;
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L22;
        if (r13 == 3) goto L21;
        if (r13 == 4) goto L19;
        if (r13 != 5) goto L18;
        m.b(r11);
    L86:
        return u.f67154a;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        y r15 = (y) r10.L$2;
        Mode r16 = (Mode) r10.L$1;
        MamiEngine r17 = (MamiEngine) r10.L$0;
        m.b(r11);
    L20:
        MamiEngine r18 = r17;
        Mode r22 = r16;
        ArrayList r23 = new ArrayList();
        Iterator r24 = ((List) r11).iterator();
    L69:
        if (r24.hasNext() == false) goto L73;
        Object r25 = r24.next();
        if (((Ranked) r25).getMs() <= 0) goto L69;
        r23.add(r25);
        goto L69
    L73:
        List r26 = q.e1(r23, 3);
        ArrayList r27 = new ArrayList(kotlin.collections.s.g0(r26, 10));
        Iterator r28 = r26.iterator();
    L75:
        if (r28.hasNext() == false) goto L78;
        r27.add(((Ranked) r28.next()).getServer());
        goto L75
    L78:
        if (r27.isEmpty() == true) goto L88;
        ArrayList r29 = new ArrayList(kotlin.collections.s.g0(r27, 10));
        int r30 = r27.size();
    L80:
        if (r14 >= r30) goto L82;
        Object r31 = r27.get(r14);
        r14 = r14 + 1;
        MamiEngine r32 = INSTANCE;
        r29.add(r32.candOf((MamiCatalog.Server) r31, null));
        goto L80
    L82:
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 5;
        if (r18.tryServers(r29, r22, null, false, r10) != r12) goto L86;
    L84:
        return r12;
    L88:
        throw new Fail("HIVE_UNREACHABLE", androidx.compose.foundation.interaction.f.o(((List) r15.element).size(), "هیچ\u200cکدام از ", " پل لیون جواب نداد"));
    L21:
        r15 = (y) r10.L$2;
        r16 = (Mode) r10.L$1;
        r17 = (MamiEngine) r10.L$0;
        m.b(r11);
    L64:
        r17.check();
        AnonymousClass8 r33 = new AnonymousClass8(r15, null);
        r10.L$0 = r17;
        r10.L$1 = r16;
        r10.L$2 = r15;
        r10.label = 4;
        r11 = r17.settleAfterRegister((List) r11, r33, r10);
        if (r11 != r12) goto L20;
    L22:
        List<String> r34 = (List) r10.L$2;
        Mode r35 = (Mode) r10.L$1;
        MamiEngine r36 = (MamiEngine) r10.L$0;
        m.b(r11);
    L23:
        Mode r110 = r35;
        r36.check();
        y r37 = new y();
        List<MamiCatalog.Server> r38 = ((MamiCatalog.Hive) r11).getServers();
        ArrayList r39 = new ArrayList();
        Iterator<T> r40 = r38.iterator();
    L34:
        if (r40.hasNext() == false) goto L39;
        Object r41 = r40.next();
        MamiXrayConfig r111 = MamiXrayConfig.INSTANCE;
        if (MamiXrayConfig.unsupportedReason$default(r111, (MamiCatalog.Server) r41, false, 2, null) != null) goto L34;
        r39.add(r41);
        goto L34
    L39:
        r37.element = r39;
        if (r39.isEmpty() == true) goto L90;
        Set r42 = q.p1(r34);
        if (r42.isEmpty() == true) goto L60;
        Iterable r43 = (Iterable) r37.element;
        if ((r43 instanceof Collection) == true) goto L46;
    L48:
        Iterator r44 = r43.iterator();
    L50:
        if (r44.hasNext() == false) goto L60;
        if (r42.contains(((MamiCatalog.Server) r44.next()).getId()) == true) goto L50;
        Iterable r45 = (Iterable) r37.element;
        ArrayList r46 = new ArrayList();
        Iterator r47 = r45.iterator();
    L55:
        if (r47.hasNext() == false) goto L59;
        Object r48 = r47.next();
        if (r42.contains(((MamiCatalog.Server) r48).getId()) == true) goto L55;
        r46.add(r48);
        goto L55
    L59:
        r37.element = r46;
        goto L60
    L46:
        if (((Collection) r43).isEmpty() == false) goto L48;
    L60:
        r36.setStatus(new f(19));
        List r49 = (List) r37.element;
        r10.L$0 = r36;
        r10.L$1 = r110;
        r10.L$2 = r37;
        r10.label = 3;
        MamiEngine r50 = r36;
        Object r51 = scout$default(r50, r49, false, true, r10, 2, null);
        if (r51 == r12) goto L84;
        r17 = r50;
        r15 = r37;
        r11 = r51;
        r16 = r110;
        goto L64
    L90:
        throw new Fail("HIVE_NO_SERVERS", "لیون فعلاً پلی برای این دستگاه ندارد");
    L24:
        r34 = (List) r10.L$2;
        r35 = (Mode) r10.L$1;
        r36 = (MamiEngine) r10.L$0;
        m.b(r11);
    L29:
        r36.check();
        r36.setStatus(new f(18));
        oe.e r52 = v0.f24208c;
        MamiEngine$connectHive$parsed$1 r53 = new MamiEngine$connectHive$parsed$1(null);
        r10.L$0 = r36;
        r10.L$1 = r35;
        r10.L$2 = r34;
        r10.label = 2;
        r11 = m0.J(r52, r53, r10);
        if (r11 != r12) goto L23;
    L25:
        m.b(r11);
        setStatus(new f(13));
        oe.e r54 = v0.f24208c;
        C06123 r55 = new C06123(null);
        r10.L$0 = this;
        r10.L$1 = r19;
        r10.L$2 = r20;
        r10.label = 1;
        if (m0.J(r54, r55, r10) == r12) goto L84;
        r35 = r19;
        r34 = r20;
        r36 = this;
    L8:
        r4 = new C06111(this, r21);
        goto L7
    }

    private static final Status connectHive$lambda$58(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "session", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectHive$lambda$59(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "hive", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status connectHive$lambda$63(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "scout", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private final void connected(Exit r11) {
        setStatus(new h(r11, 1));
        Live r4 = live;
        if (r4 == null) goto L5;
        String r8 = r4.getKind();
    L6:
        String r10 = "";
        if (kotlin.jvm.internal.j.a(r8, "xray") == false) goto L19;
        Live r12 = live;
        if (r12 == null) goto L11;
        Mode r13 = r12.getMode();
    L13:
        if (r13 != Mode.PROXY) goto L19;
        LocalPort r14 = LocalPort.INSTANCE;
        Context r15 = app;
        if (r15 == null) goto L17;
        String r16 = f0.a.h(r14.get(r15), " — فقط پراکسی محلی 127.0.0.1:");
    L21:
        if (r11 != null) goto L23;
        String r17 = w0.n("وصل شد", r16, ".");
    L35:
        log(r17);
        bump();
        startWatch();
        return;
    L23:
        if (o.L0(r11.getLoc()) == true) goto L25;
        String r18 = v0.a.h(" — خروج از ", r11.getLoc());
    L27:
        if (o.L0(r11.getIp()) == true) goto L29;
        String r19 = w0.n(" (", r11.getIp(), ")");
    L31:
        if (r11.getMs() <= 0) goto L33;
        r10 = androidx.compose.foundation.interaction.f.p(r11.getMs(), "، ", " میلی\u200cثانیه");
    L33:
        StringBuilder r110 = s.n("وصل شد", r18, r19, r10, r16);
        r110.append(".");
        r17 = r110.toString();
        goto L35
    L29:
        r19 = "";
        goto L31
    L25:
        r18 = "";
        goto L27
    L17:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L11:
        r13 = null;
    L19:
        r16 = "";
        goto L21
    L5:
        r8 = null;
        goto L6
    }

    private static final Status connected$lambda$80(Exit r17, Status r18) {
        kotlin.jvm.internal.j.e(r18, "it");
        return Status.copy$default(r18, "on", null, "", null, null, r17, null, 0, System.currentTimeMillis(), 0, null, 1690, null);
    }

    public static /* synthetic */ Status d(Status r4) {
        return connectHive$lambda$63(r4);
    }

    private static final u disconnectAsync$lambda$81(Context r4) {
        INSTANCE.init(r4);
        cancelled = true;
        s1 r8 = connectJob;
        if (r8 == null) goto L5;
        r8.cancel(null);
    L5:
        s1 r10 = watchJob;
        if (r10 == null) goto L8;
        r10.cancel(null);
    L8:
        m0.y(scope, null, null, new MamiEngine$disconnectAsync$1$1(null), 3);
        return u.f67154a;
    }

    private final Object disconnectNow(String r25, wd.d r26) {
        if ((r26 instanceof C06131) == false) goto L7;
        C06131 r4 = (C06131) r26;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
    L8:
        Object r10 = r4.result;
        kotlin.coroutines.intrinsics.a r11 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r12 = r4.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        Status r13 = (Status) r4.L$3;
        Live r14 = (Live) r4.L$2;
        String r15 = (String) r4.L$1;
        MamiEngine r16 = (MamiEngine) r4.L$0;
        m.b(r10);
    L39:
        Status r17 = r13;
    L41:
        exclusiveLive = null;
        if (r14 == null) goto L44;
        String r18 = r14.getKind();
    L46:
        if (kotlin.jvm.internal.j.a(r18, WarpIdRelay.VIA_FRONT) == false) goto L48;
        r16.stopFront();
    L60:
        live = null;
        frontMarker = null;
        g1 r19 = (g1) _status;
        Status r20 = (Status) r19.getValue();
        if (kotlin.jvm.internal.j.a(r15, "switch") == false) goto L63;
        String r21 = null;
    L64:
        r19.j(Status.copy$default(r20, "off", null, "", null, null, null, null, 0, 0, 0, r21, 986, null));
        if (kotlin.jvm.internal.j.a(r15, "switch") == true) goto L67;
        r16.log("مامی قطع شد.");
    L67:
        r16.bump();
        return u.f67154a;
    L63:
        r21 = r15;
        goto L64
    L48:
        if (r14 == null) goto L50;
        String r22 = r14.getKind();
    L52:
        if (kotlin.jvm.internal.j.a(r22, "xray") == false) goto L54;
    L55:
        r16.stopService();
        if (r14 != null) goto L60;
        if (frontMarker == null) goto L60;
        r16.stopFront();
        goto L60
    L54:
        if (kotlin.jvm.internal.j.a(r17.getPhase(), TunnelVpnService.STATUS_CONNECTING) == false) goto L60;
    L50:
        r22 = null;
        goto L52
    L44:
        r18 = null;
        goto L46
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        m.b(r10);
        cancelled = true;
        s1 r23 = watchJob;
        if (r23 == null) goto L17;
        r23.cancel(null);
    L17:
        r14 = live;
        r17 = (Status) ((g1) _status).getValue();
        if (kotlin.jvm.internal.j.a(r17.getPhase(), "off") == true) goto L20;
        setStatus(new f(20));
    L20:
        ExclusiveLive r24 = exclusiveLive;
        if (r14 == null) goto L23;
        String r27 = r14.getKind();
    L25:
        if (kotlin.jvm.internal.j.a(r27, "xray") == false) goto L40;
        Cand r28 = r14.getCand();
        if (r28 == null) goto L29;
        String r29 = r28.getId();
    L31:
        if (kotlin.jvm.internal.j.a(r29, "exclusive") == false) goto L40;
        if (r24 == null) goto L40;
        if (isOurs() == false) goto L40;
        oe.e r30 = v0.f24208c;
        C06143 r110 = new C06143(r24, null);
        r4.L$0 = this;
        r4.L$1 = r25;
        r4.L$2 = r14;
        r4.L$3 = r17;
        r4.label = 1;
        if (m0.J(r30, r110, r4) != r11) goto L38;
        return r11;
    L38:
        r16 = this;
        r13 = r17;
        r15 = r25;
        goto L39
    L29:
        r29 = null;
    L40:
        r16 = this;
        r15 = r25;
        goto L41
    L23:
        r27 = null;
    L7:
        r4 = new C06131(this, r26);
        goto L8
    }

    private static final Status disconnectNow$lambda$82(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, "stopping", null, null, null, null, null, null, 0, 0, 0, null, 2046, null);
    }

    public static /* synthetic */ CharSequence e(MamiCatalog.Skipped r4) {
        return parsedHive$lambda$23(r4);
    }

    public static /* synthetic */ Status f(Status r4) {
        return clearError$lambda$88(r4);
    }

    private final boolean frontUp() {
        if (TunnelStatus.INSTANCE.isActive() == false) goto L5;
        return true;
    L5:
        if (((TunnelUiState) TunnelController.INSTANCE.getState().getValue()).getStage() == TunnelStage.RUNNING) goto L11;
        return false;
    L11:
        return true;
    }

    public static /* synthetic */ Status g(Status r4) {
        return tryServers$lambda$73(r4);
    }

    public static /* synthetic */ Status h(Status r4) {
        return disconnectNow$lambda$82(r4);
    }

    private final MamiCatalog.Hive hiveNow(boolean r10) {
        Object r4 = l.m1004constructorimpl(MamiApi.INSTANCE.savedHive());     // Catch: Throwable -> L4
    L6:
        sf.c r8 = null;
        if (l.m1010isFailureimpl(r4) == false) goto L9;
        r4 = null;
    L9:
        sf.c r11 = (sf.c) r4;
        if (r11 == null) goto L12;
        sf.c r12 = r11.w("payload");
    L13:
        if (r12 != null) goto L15;
    L17:
        boolean r13 = false;
    L18:
        if (r10 == true) goto L38;
        if (r13 == false) goto L38;
    L30:
        MamiCatalog.Hive r14 = parsedHive();
        if (r14 == null) goto L34;
        return r14;
    L34:
        throw new IllegalStateException("فهرست پل\u200cهای لیون خوانده نشد");
    L38:
        MamiApi.INSTANCE.fetchHive(ScoutScore.CONNECT);     // Catch: MamiApi.ApiException -> L22
    L29:
        bump();
    L22:
        e = move-exception;
        if (r11 == null) goto L25;
        r8 = r11.w("payload");
    L25:
        if (r8 != null) goto L27;
    L35:
        throw e;
    L27:
        if (kotlin.jvm.internal.j.a(e.getCode(), "hive-off") == true) goto L35;
        log("فهرست تازهٔ لیون گرفته نشد (" + e.getMessage() + ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود.");
        goto L29
    L15:
        if ((System.currentTimeMillis() - r11.x(0, "fetchedAt")) >= 3600000) goto L17;
        r13 = true;
        goto L18
    L12:
        r12 = null;
    L4:
        th = move-exception;
        r4 = l.m1004constructorimpl(m.a(th));
        goto L6
    }

    public static /* synthetic */ MamiCatalog.Hive hiveNow$default(MamiEngine r4, boolean r8, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r8 = false;
    L6:
        return r4.hiveNow(r8);
    }

    public static /* synthetic */ u i(String r4) {
        return init$lambda$2(r4);
    }

    private static final u init$lambda$2(String r4) {
        kotlin.jvm.internal.j.e(r4, "it");
        INSTANCE.log(r4);
        return u.f67154a;
    }

    private static final j init$lambda$3() {
        return INSTANCE.networkNow();
    }

    private static final MamiNet.Route init$lambda$4() {
        return INSTANCE.routeNow();
    }

    public static /* synthetic */ CharSequence j(MamiCatalog.Skipped r4) {
        return parsedSaved$lambda$20(r4);
    }

    public static /* synthetic */ Status k(Status r4) {
        return connectCatalog$lambda$44(r4);
    }

    public static /* synthetic */ Status l(Status r4) {
        return connectFront$lambda$77(r4);
    }

    private final String lang() {
        return StoreNetKt.tr(GerehLocale.FA, GerehLocale.EN);
    }

    private final Object launch(String r13, Mode r14, wd.d r15) {
        if ((r15 instanceof C06151) == false) goto L7;
        C06151 r4 = (C06151) r15;
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
        MamiEngine$launch$phase$1 r17 = new MamiEngine$launch$phase$1(new kotlin.jvm.internal.u(), null);
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
        r21.putExtra("NODE_ID", "mami");
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
        C06163 r114 = new C06163(null);
        r4.label = 1;
        if (m0.L(5000, r114, r4) != r10) goto L35;
    L43:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L27:
        r111 = false;
        goto L28
    L45:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L47:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L19:
        r18 = false;
    L7:
        r4 = new C06151(this, r15);
        goto L8
    }

    public static /* synthetic */ Status m(Cand r4, j r8, Status r10) {
        return tryServers$lambda$70(r4, r8, r10);
    }

    private final Object measure(List<? extends j> r4, String r8, wd.d r10) {
        return m0.i(new AnonymousClass2(r4, r8, null), r10);
    }

    public static /* synthetic */ Status n(Status r4) {
        return tryServers$lambda$72(r4);
    }

    private final j networkNow() {
        Context r4 = app;     // Catch: Throwable -> L11
        String r8 = null;
        if (r4 == null) goto L44;
        ConnectivityManager r10 = (ConnectivityManager) r4.getSystemService(ConnectivityManager.class);     // Catch: Throwable -> L11
        Network[] r11 = r10.getAllNetworks();     // Catch: Throwable -> L11
        kotlin.jvm.internal.j.d(r11, "getAllNetworks(...)");     // Catch: Throwable -> L11
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L11
        int r13 = r11.length;     // Catch: Throwable -> L11
        int r14 = 0;
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L14;
        NetworkCapabilities r16 = r10.getNetworkCapabilities(r11[r15]);     // Catch: Throwable -> L11
        if (r16 == null) goto L13;
        r12.add(r16);     // Catch: Throwable -> L11
    L13:
        r15 = r15 + 1;     // Catch: Throwable -> L11
        goto L7
    L14:
        int r17 = r12.size();     // Catch: Throwable -> L11
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L21;
        Object r19 = r12.get(r18);     // Catch: Throwable -> L11
        r18 = r18 + 1;     // Catch: Throwable -> L11
        NetworkCapabilities r20 = (NetworkCapabilities) r19;     // Catch: Throwable -> L11
        if (r20.hasCapability(12) == false) goto L15;
        if (r20.hasTransport(4) == true) goto L15;
    L22:
        NetworkCapabilities r21 = (NetworkCapabilities) r19;     // Catch: Throwable -> L11
        if (r21 != null) goto L25;
    L42:
        j r22 = new j("wifi", "");     // Catch: Throwable -> L11
    L43:
        Object r23 = l.m1004constructorimpl(r22);     // Catch: Throwable -> L11
    L47:
        j r24 = new j("wifi", "");
        if (l.m1010isFailureimpl(r23) == false) goto L51;
        r23 = r24;
    L51:
        return (j) r23;
    L25:
        if (r21.hasTransport(0) != true) goto L42;
        Context r25 = app;     // Catch: Throwable -> L11
        if (r25 == null) goto L40;
        TelephonyManager r26 = (TelephonyManager) r25.getSystemService(TelephonyManager.class);     // Catch: Throwable -> L11
        if (r26 == null) goto L31;
        r8 = r26.getNetworkOperator();     // Catch: Throwable -> L11
    L31:
        if (r8 != null) goto L33;
        r8 = "";
    L33:
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L11
        int r28 = r8.length();     // Catch: Throwable -> L11
    L34:
        if (r14 >= r28) goto L39;
        char r29 = r8.charAt(r14);     // Catch: Throwable -> L11
        if (Character.isDigit(r29) == false) goto L38;
        r27.append(r29);     // Catch: Throwable -> L11
    L38:
        r14 = r14 + 1;     // Catch: Throwable -> L11
        goto L34
    L39:
        r22 = new j("cellular", r27.toString());     // Catch: Throwable -> L11
        goto L43
    L40:
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    L21:
        r19 = null;
        goto L22
    L44:
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r23 = l.m1004constructorimpl(m.a(th));
        goto L47
    }

    public static /* synthetic */ Status o(Status r4) {
        return connectCatalog$lambda$45(r4);
    }

    public static /* synthetic */ j p() {
        return init$lambda$3();
    }

    private final synchronized MamiCatalog.Hive parsedHive() {
        monitor-enter(this);
        Object r4 = l.m1004constructorimpl(MamiApi.INSTANCE.savedHive());     // Catch: Throwable -> L6
    L8:
        MamiCatalog.Hive r8 = null;
        if (l.m1010isFailureimpl(r4) == false) goto L11;
        r4 = null;
    L11:
        sf.c r10 = (sf.c) r4;     // Catch: Throwable -> L26
        if (r10 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        sf.c r11 = r10.w("payload");     // Catch: Throwable -> L26
        if (r11 != null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        String r12 = String.valueOf(r10.x(0, "fetchedAt"));     // Catch: Throwable -> L26
        j r13 = hiveCat;     // Catch: Throwable -> L26
        if (r13 != null) goto L22;
    L41:
        MamiCatalog.Hive r14 = MamiCatalog.INSTANCE.parseHive(r11);     // Catch: Throwable -> L26 Exception -> L32
        hiveCat = new j(r12, r14);     // Catch: Throwable -> L26 Exception -> L32
        if (r14.getSkipped().isEmpty() == true) goto L34;
        log(r14.getSkipped().size() + " پل لیون کنار گذاشته شد: " + q.F0(q.e1(r14.getSkipped(), 5), "، ", null, null, new f(21), 30));     // Catch: Throwable -> L26 Exception -> L32
    L34:
        r8 = r14;
    L36:
        monitor-exit(this);
        return r8;
    L32:
        e = move-exception;
        log("فهرست لیون خوانده نشد: " + e.getMessage());     // Catch: Throwable -> L26
        goto L36
    L22:
        if (kotlin.jvm.internal.j.a(r13.getFirst(), r12) == false) goto L41;
        MamiCatalog.Hive r15 = (MamiCatalog.Hive) r13.getSecond();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r15;
    L26:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        r4 = l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L26
        goto L8
    }

    private static final CharSequence parsedHive$lambda$23(MamiCatalog.Skipped r4) {
        kotlin.jvm.internal.j.e(r4, "it");
        return f0.a.m(r4.getId(), " (", r4.getWhy(), ")");
    }

    private final synchronized MamiCatalog.Parsed parsedSaved() {
        monitor-enter(this);
        Object r4 = l.m1004constructorimpl(MamiApi.INSTANCE.savedCatalog());     // Catch: Throwable -> L6
    L8:
        MamiCatalog.Parsed r8 = null;
        if (l.m1010isFailureimpl(r4) == false) goto L11;
        r4 = null;
    L11:
        sf.c r10 = (sf.c) r4;     // Catch: Throwable -> L26
        if (r10 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        sf.c r11 = r10.w("payload");     // Catch: Throwable -> L26
        if (r11 != null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        String r12 = r10.x(0, "fetchedAt") + ":" + r10.x(0, "revision");     // Catch: Throwable -> L26
        j r13 = cat;     // Catch: Throwable -> L26
        if (r13 != null) goto L22;
    L42:
        MamiCatalog.Parsed r14 = MamiCatalog.INSTANCE.parseCatalog(r11);     // Catch: Throwable -> L26 Exception -> L32
        cat = new j(r12, r14);     // Catch: Throwable -> L26 Exception -> L32
        if (r14.getSkipped().isEmpty() == true) goto L34;
        log(r14.getSkipped().size() + " سرور فهرست کنار گذاشته شد: " + q.F0(q.e1(r14.getSkipped(), 5), "، ", null, null, new f(22), 30));     // Catch: Throwable -> L26 Exception -> L32
    L34:
        r8 = r14;
    L36:
        monitor-exit(this);
        return r8;
    L32:
        e = move-exception;
        log("فهرست ذخیره\u200cشده خوانده نشد: " + e.getMessage());     // Catch: Throwable -> L26
        goto L36
    L22:
        if (kotlin.jvm.internal.j.a(r13.getFirst(), r12) == false) goto L42;
        MamiCatalog.Parsed r15 = (MamiCatalog.Parsed) r13.getSecond();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r15;
    L26:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        r4 = l.m1004constructorimpl(m.a(th));     // Catch: Throwable -> L26
        goto L8
    }

    private static final CharSequence parsedSaved$lambda$20(MamiCatalog.Skipped r4) {
        kotlin.jvm.internal.j.e(r4, "it");
        return f0.a.m(r4.getId(), " (", r4.getWhy(), ")");
    }

    private final String placeLabel(Cand r4) {
        if (o.L0(r4.getCity()) == true) goto L7;
        return f0.a.l(r4.getCountry(), " · ", r4.getCity());
    L7:
        return r4.getCountry();
    }

    private final MamiCatalog.Place placeOfLocation(MamiCatalog.Location r4) {
        MamiCatalog.Names r8 = r4.getNames();
        if (r8 == null) goto L11;
        MamiCatalog.Place r10 = r8.get(INSTANCE.lang());
        if (r10 != null) goto L7;
        r10 = r8.getEn();
    L7:
        if (r10 == null) goto L11;
        return r10;
    L11:
        return new MamiCatalog.Place(r4.getCountry(), r4.getCity());
    }

    private final j placeOfServer(MamiCatalog.Server r4) {
        MamiCatalog.Place r8 = MamiCatalog.INSTANCE.placeOf(r4, lang());
        return new j(r8.getCountry(), r8.getCity());
    }

    public static /* synthetic */ Status q(Status r4) {
        return connectFront$lambda$74(r4);
    }

    public static /* synthetic */ Status r(Status r4) {
        return connectHive$lambda$59(r4);
    }

    private final Exit realExit(Exit r11) {
        IpFormatter r4 = IpFormatter.INSTANCE;
        if (r4.isRealCountry(r11.getLoc()) == false) goto L5;
        return r11;
    L5:
        String r8 = ((TunnelUiState) TunnelController.INSTANCE.getState().getValue()).getCountry();
        if (r8 == null) goto L10;
        String r10 = o.n1(r8).toString();
        if (r10 == null) goto L10;
        String r12 = r10.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.j.d(r12, "toUpperCase(...)");
    L12:
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        if (r4.isRealCountry(r12) == false) goto L17;
        String r13 = r12;
    L19:
        return Exit.copy$default(r11, r13, null, 0, 6, null);
    L17:
        r13 = "";
    L10:
        r12 = null;
        goto L12
    }

    private final MamiNet.Route routeNow() {
        MyVpnService.Companion r4 = MyVpnService.Companion;
        if (((g1) r4.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.CONNECTED) goto L14;
        MamiNet r8 = MamiNet.INSTANCE;
        LocalPort r10 = LocalPort.INSTANCE;
        Context r11 = app;
        if (r11 == null) goto L12;
        int r12 = r10.get(r11);
        if (kotlin.jvm.internal.j.a(((g1) r4.getConnectedNodeIdFlow()).getValue(), "mami") == false) goto L9;
        String r13 = "خود مامی";
    L11:
        return r8.socksRoute(r12, r13);
    L9:
        r13 = "موتور وصل برنامه";
        goto L11
    L12:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L14:
        TunnelStatus r14 = TunnelStatus.INSTANCE;
        if (r14.isActive() == true) goto L17;
    L20:
        return null;
    L17:
        if (r14.getActiveSocksPort() <= 0) goto L20;
        return MamiNet.INSTANCE.socksRoute(r14.getActiveSocksPort(), "موتور تونل برنامه");
    }

    public static /* synthetic */ MamiNet.Route s() {
        return init$lambda$4();
    }

    private final void saveRoute(j r8) {
        SharedPreferences.Editor r4 = sp().edit();
        if (r8 != null) goto L5;
        r4.remove("route");
    L6:
        r4.apply();
        return;
    L5:
        sf.c r10 = new sf.c();
        r10.D("profile", r8.getFirst());
        r10.D("locationId", r8.getSecond());
        r4.putString("route", r10.toString());
        goto L6
    }

    private final Object scout(List<MamiCatalog.Server> r25, boolean r26, boolean r27, wd.d r28) {
        List<MamiCatalog.Server> r4 = r25;
        boolean r8 = r27;
        if ((r28 instanceof C06191) == false) goto L7;
        C06191 r10 = (C06191) r28;
        int r11 = r10.label;
        if ((r11 & TLObject.FLAG_31) == 0) goto L7;
        r10.label = r11 - TLObject.FLAG_31;
    L8:
        Object r12 = r10.result;
        kotlin.coroutines.intrinsics.a r13 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r14 = r10.label;
        long r15 = -1;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        boolean r16 = r10.Z$0;
        ArrayList r17 = (ArrayList) r10.L$2;
        List<MamiCatalog.Server> r18 = (List) r10.L$1;
        MamiEngine r19 = (MamiEngine) r10.L$0;
        m.b(r12);
        ArrayList r20 = r17;
        long r110 = 0;
        r8 = r16;
        r4 = r18;
    L41:
        Map r21 = (Map) r12;
        Iterator r22 = r20.iterator();
        kotlin.jvm.internal.j.d(r22, "iterator(...)");
        int r23 = 0;
    L43:
        if (r22.hasNext() == false) goto L52;
        Object r24 = r22.next();
        kotlin.jvm.internal.j.d(r24, "next(...)");
        String r29 = (String) ((j) r24).component1();
        Long r30 = (Long) r21.get(r29);
        if (r30 == null) goto L47;
        long r31 = r30.longValue();
    L49:
        if (r31 <= r110) goto L51;
        r23 = r23 + 1;
    L51:
        delays.put(r29, new j(new Long(r31), new Long(System.currentTimeMillis())));
        goto L43
    L47:
        r31 = -1;
        goto L49
    L52:
        r19.log(r23 + " سرور از " + r20.size() + " جواب داد.");
        r19.bump();
    L53:
        List<MamiCatalog.Server> r32 = r4;
        ArrayList r33 = new ArrayList(kotlin.collections.s.g0(r32, 10));
        Iterator<T> r34 = r32.iterator();
    L55:
        if (r34.hasNext() == false) goto L69;
        MamiCatalog.Server r35 = (MamiCatalog.Server) r34.next();
        j r36 = delays.get(r35.getId());
        if (r36 == null) goto L59;
        long r37 = ((Number) r36.getFirst()).longValue();
    L61:
        if (r8 == false) goto L64;
        long r38 = MamiCatalog.INSTANCE.hiveRank(r35, r37);
    L67:
        r33.add(new Ranked(r35, r37, r38));
        goto L55
    L64:
        if (r37 <= r110) goto L66;
        r38 = r37;
        goto L67
    L66:
        r38 = Long.MAX_VALUE;
        goto L67
    L59:
        r37 = -1;
        goto L61
    L69:
        return q.b1(r33, new MamiEngine$scout$$inlined$sortedBy$1());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        m.b(r12);
        long r111 = System.currentTimeMillis();
        ArrayList r39 = new ArrayList();
        Iterator<T> r40 = r4.iterator();
    L16:
        if (r40.hasNext() == false) goto L24;
        Object r112 = r40.next();
        MamiCatalog.Server r113 = (MamiCatalog.Server) r112;
        if (r26 == true) goto L23;
        j r41 = delays.get(r113.getId());
        if (r41 == null) goto L23;
        if ((r111 - ((Number) r41.getSecond()).longValue()) <= 600000) goto L16;
    L23:
        r39.add(r112);
        goto L16
    L24:
        r110 = 0;
        List r42 = q.e1(r39, 24);
        if (r42.isEmpty() == true) goto L53;
        r20 = new ArrayList();
        Iterator r43 = r42.iterator();
    L28:
        if (r43.hasNext() == false) goto L33;
        MamiCatalog.Server r114 = (MamiCatalog.Server) r43.next();
        r20.add(new j(r114.getId(), MamiXrayConfig.outboundFor$default(MamiXrayConfig.INSTANCE, r114, "mami-scout", false, 4, null)));     // Catch: Exception -> L32
    L32:
        delays.put(r114.getId(), new j(new Long(r15), new Long(r111)));
        r15 = -1;
        goto L28
    L33:
        log("سنجش " + r20.size() + " سرور…");
        if (r8 == false) goto L36;
        String r44 = HIVE_PROBE;
    L37:
        r10.L$0 = this;
        r10.L$1 = r4;
        r10.L$2 = r20;
        r10.Z$0 = r8;
        r10.label = 1;
        r12 = measure(r20, r44, r10);
        if (r12 != r13) goto L40;
        return r13;
    L40:
        r19 = this;
        goto L41
    L36:
        r44 = null;
    L7:
        r10 = new C06191(this, r28);
        goto L8
    }

    public static /* synthetic */ Object scout$default(MamiEngine r4, List r8, boolean r10, boolean r11, wd.d r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = false;
    L9:
        return r4.scout(r8, r10, r11, r12);
    }

    public static /* synthetic */ Prefs setPrefs$default(MamiEngine r4, String r8, Mode r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = null;
    L12:
        return r4.setPrefs(r8, r10, r11);
    }

    private final void setStatus(ee.c r4) {
        k0 r8 = _status;
        Object r10 = r4.invoke(((g1) r8).getValue());
        ((g1) r8).j(r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x013c -> B:13:0x0043). Please report as a decompilation issue!!! */
    private final Object settleAfterRegister(List<Ranked> r19, ee.c r20, wd.d r21) {
        if ((r21 instanceof C06201) == false) goto L7;
        C06201 r4 = (C06201) r21;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
        MamiEngine r10 = this;
    L8:
        Object r11 = r4.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r4.label;
        long r14 = 0;
        if (r13 == 0) goto L17;
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L15;
        int r15 = r4.I$1;
        int r16 = r4.I$0;
        long[] r17 = (long[]) r4.L$2;
        ee.c r18 = (ee.c) r4.L$1;
        MamiEngine r110 = (MamiEngine) r4.L$0;
        m.b(r11);
        long r111 = 0;
    L13:
        C06201 r22 = r4;
        ee.c r23 = r18;
        List<Ranked> r24 = (List) r11;
        r110.check();
        List<Ranked> r25 = r24;
        if ((r25 instanceof Collection) == true) goto L53;
    L55:
        Iterator<T> r26 = r25.iterator();
    L57:
        if (r26.hasNext() == false) goto L61;
        if (((Ranked) r26.next()).getMs() <= r111) goto L57;
    L62:
        return r24;
    L61:
        int r112 = r16 + 1;
        C06201 r27 = r22;
        r14 = r111;
    L42:
        if (r112 >= r15) goto L62;
        long r113 = r17[r112];
        r111 = r14;
        r110.log("این دستگاه همین حالا ثبت شد؛ سرورها چند ثانیه طول می\u200cکشد تا آن را بشناسند — " + (r113 / ((long) 1000)) + " ثانیه دیگر دوباره سنجیده می\u200cشود…");
        r27.L$0 = r110;
        r27.L$1 = r23;
        r27.L$2 = r17;
        r27.I$0 = r112;
        r27.I$1 = r15;
        r27.label = 1;
        if (m0.j(r113, r27) == r12) goto L49;
        int r114 = r112;
        r18 = r23;
        r4 = r27;
        r16 = r114;
    L47:
        r110.check();
        r4.L$0 = r110;
        r4.L$1 = r18;
        r4.L$2 = r17;
        r4.I$0 = r16;
        r4.I$1 = r15;
        r4.label = 2;
        r11 = r18.invoke(r4);
        if (r11 != r12) goto L13;
    L49:
        return r12;
    L53:
        if (r25.isEmpty() == false) goto L55;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r15 = r4.I$1;
        r16 = r4.I$0;
        r17 = (long[]) r4.L$2;
        r18 = (ee.c) r4.L$1;
        r110 = (MamiEngine) r4.L$0;
        m.b(r11);
        r111 = 0;
        goto L47
    L17:
        m.b(r11);
        Object r28 = l.m1004constructorimpl(new Long(MamiApi.INSTANCE.summary().getRegisteredAt()));     // Catch: Throwable -> L20
    L22:
        Long r29 = new Long(0);
        if (l.m1010isFailureimpl(r28) == false) goto L25;
        r28 = r29;
    L25:
        long r30 = ((Number) r28).longValue();
        List<Ranked> r31 = r19;
        if ((r31 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r32 = r31.iterator();
    L32:
        if (r32.hasNext() == false) goto L37;
        if (((Ranked) r32.next()).getMs() <= 0) goto L32;
    L63:
        return r19;
    L37:
        if (r30 <= 0) goto L63;
        if ((System.currentTimeMillis() - r30) > 120000) goto L63;
        r112 = 0;
        r27 = r4;
        r110 = r10;
        r17 = new long[]{4000, 6000, SettingsSpotlight.FRESH_MS};
        r23 = r20;
        r15 = 3;
        r24 = r19;
        goto L42
    L28:
        if (r31.isEmpty() == false) goto L30;
    L20:
        th = move-exception;
        r28 = l.m1004constructorimpl(m.a(th));
    L7:
        r10 = this;
        r4 = new C06201(r10, r21);
        goto L8
    }

    private final SharedPreferences sp() {
        Context r4 = app;
        if (r4 != null) goto L5;
        kotlin.jvm.internal.j.k("app");
        throw null;
    L5:
        return r4.getSharedPreferences("mami", 0);
    }

    private final void startWatch() {
        s1 r4 = watchJob;
        if (r4 == null) goto L5;
        r4.cancel(null);
    L5:
        watchJob = m0.y(scope, null, null, new C06211(null), 3);
    }

    private final void stopFront() {
        if (TunnelStatus.INSTANCE.isActive() == false) goto L5;
    L23:
        SafeStart r4 = SafeStart.INSTANCE;     // Catch: Throwable -> L15
        Context r8 = app;     // Catch: Throwable -> L15
        if (r8 == null) goto L19;
        Context r10 = app;     // Catch: Throwable -> L15
        if (r10 == null) goto L17;
        Intent r11 = new Intent(r10, TunnelVpnService.class).setAction(TunnelVpnService.ACTION_DISCONNECT);     // Catch: Throwable -> L15
        kotlin.jvm.internal.j.d(r11, "setAction(...)");     // Catch: Throwable -> L15
        l.m1004constructorimpl(Boolean.valueOf(r4.service(r8, r11)));     // Catch: Throwable -> L15
        return;
    L17:
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L15
    L19:
        kotlin.jvm.internal.j.k("app");     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        l.m1004constructorimpl(m.a(th));
        return;
    L5:
        if (frontMarker != null) goto L23;
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
        kotlin.jvm.internal.j.k("app");
        throw null;
    L12:
        kotlin.jvm.internal.j.k("app");
        throw null;
    }

    public static /* synthetic */ Status t(Status r4) {
        return connectCatalog$lambda$51(r4);
    }

    private final String testConfig(sf.c r11) {
        sf.c r4 = new sf.c();
        sf.c r8 = new sf.c();
        r8.D("loglevel", "warning");
        r4.D(XrayCoreHostService.KEY_LOG, r8);
        sf.a r10 = new sf.a();
        sf.c r12 = i.p("tag", "socks", "listen", SniSession.LOCAL_HOST);
        r12.D(PsiphonProbeService.PORT, Integer.valueOf(((int) (Math.random() * ((double) 3000))) + 36000));
        r12.D("protocol", "socks");
        sf.c r13 = new sf.c();
        r13.E("udp", false);
        r12.D("settings", r13);
        r10.put(r12);
        r4.D("inbounds", r10);
        sf.a r14 = new sf.a();
        sf.c r15 = new sf.c(r11.toString());
        r15.D("tag", WarpIdRelay.VIA_PROXY);
        r14.put(r15);
        r4.D("outbounds", r14);
        String r16 = r4.toString();
        kotlin.jvm.internal.j.d(r16, "toString(...)");
        return r16;
    }

    private final Exit trace(Proxy r12) {
        Object r4 = null;
        OkHttpClient.Builder r8 = new OkHttpClient.Builder();     // Catch: Throwable -> L33
        r8.e(r12);     // Catch: Throwable -> L33
        r8.a(12, TimeUnit.SECONDS);     // Catch: Throwable -> L33
        OkHttpClient r13 = new OkHttpClient(r8);     // Catch: Throwable -> L33
        long r10 = System.nanoTime();     // Catch: Throwable -> L33
        okhttp3.Request.Builder r11 = new okhttp3.Request.Builder();     // Catch: Throwable -> L33
        r11.j("https://www.cloudflare.com/cdn-cgi/trace");     // Catch: Throwable -> L33
        Response r14 = r13.b(new okhttp3.Request(r11)).d();     // Catch: Throwable -> L33
        ResponseBody r15 = r14.f29156h;     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        String r16 = r15.w();     // Catch: Throwable -> L8
    L11:
        String r17 = "";
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        if (r14.A == true) goto L17;
        Exit r18 = null;
    L31:
        r14.close();     // Catch: Throwable -> L33
        Object r19 = l.m1004constructorimpl(r18);     // Catch: Throwable -> L33
    L41:
        if (l.m1010isFailureimpl(r19) == true) goto L45;
        r4 = r19;
    L45:
        return (Exit) r4;
    L17:
        kotlin.text.g r20 = kotlin.text.l.find$default(new kotlin.text.l("(?m)^loc=([A-Z0-9]{2})"), r16, 0, 2, null);     // Catch: Throwable -> L8
        if (r20 == null) goto L20;
        String r21 = (String) ((f0) ((kotlin.text.i) r20).a()).get(1);     // Catch: Throwable -> L8
    L21:
        if (r21 != null) goto L23;
        r21 = "";
    L23:
        kotlin.text.g r22 = kotlin.text.l.find$default(new kotlin.text.l("(?m)^ip=(\\S+)"), r16, 0, 2, null);     // Catch: Throwable -> L8
        if (r22 == null) goto L26;
        String r23 = (String) ((f0) ((kotlin.text.i) r22).a()).get(1);     // Catch: Throwable -> L8
    L27:
        if (r23 == null) goto L30;
        r17 = r23;
    L30:
        r18 = new Exit(r21, r17, (System.nanoTime() - r10) / ((long) 1000000));     // Catch: Throwable -> L8
    L26:
        r23 = null;
        goto L27
    L20:
        r21 = null;
        goto L21
    L10:
        r16 = null;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        a.a.g(r14, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r19 = l.m1004constructorimpl(m.a(th));
        goto L41
    }

    private final Object traceFront(wd.d r4) {
        return m0.J(v0.f24208c, new C06222(null), r4);
    }

    private final Object traceHttp(wd.d r4) {
        return m0.J(v0.f24208c, new C06232(null), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x009a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]) (LINE:155), block:B:27:0x0099 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0142 -> B:45:0x014a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0153 -> B:97:0x0281). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0159 -> B:130:0x0162). Please report as a decompilation issue!!! */
    private final Object tryServers(List<Cand> r24, Mode r25, PlaceRow r26, boolean r27, wd.d r28) {
        if ((r28 instanceof C06241) == false) goto L7;
        C06241 r4 = (C06241) r28;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
        MamiEngine r10 = this;
    L8:
        Object r11 = r4.result;
        kotlin.coroutines.intrinsics.a r12 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r13 = r4.label;
        ?? r14 = 4;
        int r15 = 1;
        wd.d r16 = null;
        if (r13 == 0) goto L36;
        if (r13 != 1) goto L121;
        r13 = r4.I$0;
        boolean r17 = r4.Z$0;
        Cand r18 = (Cand) r4.L$4;
        Iterator<Cand> r19 = (Iterator) r4.L$3;
        PlaceRow r110 = (PlaceRow) r4.L$2;
        Mode r111 = (Mode) r4.L$1;
        MamiEngine r112 = (MamiEngine) r4.L$0;
        m.b(r11);     // Catch: Throwable -> L34
        ?? r20 = r17;
    L45:
        PlaceRow r22 = r110;
        ?? r113 = r20;
        MamiEngine r21 = r112;
        Mode r114 = r111;
        PlaceRow r115 = r22;
    L130:
        r21.check();     // Catch: Throwable -> L86
        r21.setStatus(new f(24));     // Catch: Throwable -> L86
        String r23 = r21.placeLabel(r18);     // Catch: Throwable -> L86
        String r116 = r18.getProfile();     // Catch: Throwable -> L86
        StringBuilder r29 = new StringBuilder();     // Catch: Throwable -> L86
        r29.append("راه\u200cاندازی موتور با سرور ");     // Catch: Throwable -> L95
        r29.append(r23);     // Catch: Throwable -> L95
        r29.append(" (");     // Catch: Throwable -> L95
        r29.append(r116);     // Catch: Throwable -> L95
        r29.append(")…");     // Catch: Throwable -> L95
        r21.log(r29.toString());     // Catch: Throwable -> L95
        String r30 = r21.config(r18.getOutbound());     // Catch: Throwable -> L95
        oe.e r31 = v0.f24208c;     // Catch: Throwable -> L93
        AnonymousClass5 r32 = new AnonymousClass5(r16);     // Catch: Throwable -> L93
        r4.L$0 = r21;     // Catch: Throwable -> L93
        r4.L$1 = r114;     // Catch: Throwable -> L93
        r4.L$2 = r115;     // Catch: Throwable -> L93
        r4.L$3 = r19;     // Catch: Throwable -> L93
        r4.L$4 = r18;     // Catch: Throwable -> L93
        r4.L$5 = r30;     // Catch: Throwable -> L93
        r4.Z$0 = r113;     // Catch: Throwable -> L93
        r4.I$0 = r15;     // Catch: Throwable -> L93
        r4.label = 2;     // Catch: Throwable -> L90
        if (m0.J(r31, r32, r4) == r12) goto L73;
        r13 = r15;
        ?? r117 = r113;
    L57:
        r4.L$0 = r21;     // Catch: Throwable -> L86
        r4.L$1 = r114;     // Catch: Throwable -> L86
        r4.L$2 = r115;     // Catch: Throwable -> L86
        r4.L$3 = r19;     // Catch: Throwable -> L86
        r4.L$4 = r18;     // Catch: Throwable -> L86
        r4.L$5 = r30;     // Catch: Throwable -> L86
        r4.Z$0 = r117;     // Catch: Throwable -> L86
        r4.I$0 = r13;     // Catch: Throwable -> L86
        r4.label = 3;     // Catch: Throwable -> L86
        Object r118 = r21.launch(r30, r114, r4);     // Catch: Throwable -> L86
        if (r118 == r12) goto L73;
        PlaceRow r210 = r115;
        String r119 = r30;
        r11 = r118;
        Mode r120 = r114;
        PlaceRow r121 = r210;
        ?? r122 = r117;
    L124:
    L84:
        Fail th2 = th;
    L83:
        boolean r123 = r122 == true ? 1 : 0;
        C06241 r124 = r4;
        Mode r33 = r120;
        r21 = r21;
        ?? r34 = r123 ? 1 : 0;
        r115 = r121;
    L97:
        if (r13 == 0) goto L100;
        r21.stopService();
    L100:
        if (cancelled == false) goto L102;
    L108:
        throw th2;
    L102:
        if ((th2 instanceof CancellationException) == true) goto L108;
        if ((th2 instanceof Fail) == true) goto L106;
    L107:
        r21.log("سرور " + r21.placeLabel(r18) + " وصل نشد: " + th2.getMessage());
        delays.put(r18.getId(), new j(new Long(-1), new Long(System.currentTimeMillis())));
        PlaceRow r35 = r115;
        MamiEngine r125 = r21;
        r15 = 1;
        r16 = null;
        ?? r36 = r34;
    L38:
        if (r19.hasNext() == false) goto L109;
        r18 = r19.next();
        r125.check();
        r125.setStatus(new e(r18, delays.get(r18.getId())));
        if (r36 != 0) goto L117;
        r114 = r33;
        r4 = r124;
        r113 = r36 == true ? 1 : 0;
        r21 = r125;
        r115 = r35;
        r13 = 0;
        goto L130
    L117:
        oe.e r37 = v0.f24208c;     // Catch: Throwable -> L46
        C06253 r126 = new C06253(r18, r35, r16);     // Catch: Throwable -> L46
        r124.L$0 = r125;     // Catch: Throwable -> L46
        r124.L$1 = r33;     // Catch: Throwable -> L46
        r124.L$2 = r35;     // Catch: Throwable -> L46
        r124.L$3 = r19;     // Catch: Throwable -> L46
        r124.L$4 = r18;     // Catch: Throwable -> L46
        r124.L$5 = r16;     // Catch: Throwable -> L46
        r124.Z$0 = r36;     // Catch: Throwable -> L46
        r124.I$0 = 0;     // Catch: Throwable -> L46
        r124.label = r15;     // Catch: Throwable -> L46
        if (m0.J(r37, r126, r124) == r12) goto L73;
        MamiEngine r211 = r125;
        r111 = r33;
        r4 = r124;
        r110 = r35;
        r13 = 0;
        r112 = r211;
        r20 = r36;
    L46:
        th2 = th;
        r21 = r125;
        r115 = r35;
        r13 = 0;
        r34 = r36;
        goto L97
    L109:
        if (th2 == null) goto L111;
        throw th2;
    L111:
        throw new IllegalStateException("وصل نشد");
    L106:
        if (kotlin.jvm.internal.j.a(th2.getCode(), "ROUTE_FAILED") == true) goto L108;
    L62:
        if (((Boolean) r11).booleanValue() == false) goto L64;
        r21.check();     // Catch: Throwable -> L84
        r21.setStatus(new f(6));     // Catch: Throwable -> L84
        MamiEngine$tryServers$tr$1 r38 = new MamiEngine$tryServers$tr$1(r16);     // Catch: Throwable -> L84
        r4.L$0 = r21;     // Catch: Throwable -> L84
        r4.L$1 = r120;     // Catch: Throwable -> L84
        r4.L$2 = r121;     // Catch: Throwable -> L84
        r4.L$3 = r19;     // Catch: Throwable -> L84
        r4.L$4 = r18;     // Catch: Throwable -> L84
        r4.L$5 = r119;     // Catch: Throwable -> L84
        r4.Z$0 = r122;     // Catch: Throwable -> L84
        r4.I$0 = r13;     // Catch: Throwable -> L84
        r4.label = 4;     // Catch: Throwable -> L82
        r11 = r21.verify(r38, r4);     // Catch: Throwable -> L82
        ?? r127 = r122;
        if (r11 == r12) goto L73;
    L17:
        String r128 = r119;
        Cand r129 = r18;
        Mode r212 = r120;
        Exit r39 = (Exit) r11;     // Catch: Throwable -> L78
        if (r39 == null) goto L81;
        r21.setStatus(new f(7));     // Catch: Throwable -> L78
        live = new Live("xray", r129, r128, null, r212);     // Catch: Throwable -> L78
        r21.connected(r39);     // Catch: Throwable -> L78
        return u.f67154a;
    L81:
        throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");     // Catch: Throwable -> L78
    L78:
        th2 = th;
        r21 = r21;
        r34 = r127;
        r115 = r121;
        r18 = r129;
        r124 = r4;
        r33 = r212;
    L82:
        th2 = th;
        goto L83
    L64:
        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.FAILED) goto L66;
        String r40 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
    L68:
        throw new IllegalStateException(r40);     // Catch: Throwable -> L18
    L18:
        th2 = th;
        ?? r41 = r122;
        r124 = r4;
        r33 = r120;
        r21 = r21;
        r14 = r41 == true ? 1 : 0;
        r115 = r121;
    L20:
        r34 = r14;
        goto L97
    L66:
        r40 = "موتور بالا نیامد";
    L73:
        return r12;
    L90:
        th2 = th;
    L92:
        r13 = r15;
    L89:
        r34 = r113 == true ? 1 : 0;
        r124 = r4;
        r33 = r114;
    L93:
        th2 = th;
    L95:
        th2 = th;
    L86:
        th2 = th;
    L34:
        th2 = th;
        r124 = r4;
        r33 = r111;
        r115 = r110;
        r21 = r112;
        r14 = r17;
        goto L20
    L121:
        if (r13 == 2) goto L28;
        if (r13 == 3) goto L23;
        if (r13 != 4) goto L22;
        r13 = r4.I$0;
        r122 = r4.Z$0;
        r119 = (String) r4.L$5;
        r18 = (Cand) r4.L$4;
        r19 = (Iterator) r4.L$3;
        r121 = (PlaceRow) r4.L$2;
        r120 = (Mode) r4.L$1;
        r21 = (MamiEngine) r4.L$0;
        m.b(r11);     // Catch: Throwable -> L18
        r127 = r122;
        goto L17
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        r13 = r4.I$0;
        boolean r42 = r4.Z$0;
        String r130 = (String) r4.L$5;
        r18 = (Cand) r4.L$4;
        r19 = (Iterator) r4.L$3;
        PlaceRow r131 = (PlaceRow) r4.L$2;
        Mode r132 = (Mode) r4.L$1;
        MamiEngine r133 = (MamiEngine) r4.L$0;
        m.b(r11);     // Catch: Throwable -> L26
        r122 = r42;
        r21 = r133;
        r120 = r132;
        r121 = r131;
        r119 = r130;
        goto L124
    L28:
        r13 = r4.I$0;
        boolean r43 = r4.Z$0;
        String r134 = (String) r4.L$5;
        r18 = (Cand) r4.L$4;
        r19 = (Iterator) r4.L$3;
        r115 = (PlaceRow) r4.L$2;
        r114 = (Mode) r4.L$1;
        MamiEngine r135 = (MamiEngine) r4.L$0;
        m.b(r11);     // Catch: Throwable -> L26
        r30 = r134;
        r117 = r43;
        r21 = r135;
    L26:
        th2 = th;
        r124 = r4;
        r33 = r14;
        goto L20
    L36:
        m.b(r11);
        r35 = r26;
        r36 = r27;
        r19 = r24.iterator();
        r124 = r4;
        r125 = r10;
        th2 = null;
        r33 = r25;
    L7:
        r10 = this;
        r4 = new C06241(r10, r28);
        goto L8
    }

    private static final Status tryServers$lambda$70(Cand r17, j r18, Status r19) {
        kotlin.jvm.internal.j.e(r19, "it");
        int r13 = r19.getAttempt() + 1;
        String r4 = r17.getId();
        String r8 = r17.getCc();
        String r10 = r17.getCountry();
        String r11 = r17.getCity();
        String r12 = r17.getProtocol();
        String r14 = r17.getProfile();
        if (r18 == null) goto L5;
        long r15 = ((Number) r18.getFirst()).longValue();
    L7:
        return Status.copy$default(r19, null, null, null, null, new ServerRef(r4, r8, r10, r11, r12, r14, r15), null, null, 0, 0, r13, null, 1519, null);
    L5:
        r15 = 0;
        goto L7
    }

    private static final Status tryServers$lambda$71(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "engine", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status tryServers$lambda$72(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "verify", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    private static final Status tryServers$lambda$73(Status r17) {
        kotlin.jvm.internal.j.e(r17, "it");
        return Status.copy$default(r17, null, null, "route", null, null, null, null, 0, 0, 0, null, 2043, null);
    }

    public static /* synthetic */ Status u(Exit r4, Status r8) {
        return connected$lambda$80(r4, r8);
    }

    public static /* synthetic */ u v(Context r4) {
        return disconnectAsync$lambda$81(r4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x008f -> B:45:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x009f -> B:45:0x00a2). Please report as a decompilation issue!!! */
    private final Object verify(ee.c r11, wd.d r12) {
        if ((r12 instanceof C06261) == false) goto L7;
        C06261 r4 = (C06261) r12;
        int r8 = r4.label;
        if ((r8 & TLObject.FLAG_31) == 0) goto L7;
        r4.label = r8 - TLObject.FLAG_31;
    L8:
        Object r13 = r4.result;
        kotlin.coroutines.intrinsics.a r10 = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int r14 = r4.label;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        int r15 = r4.I$0;
        ee.c r16 = (ee.c) r4.L$1;
        MamiEngine r17 = (MamiEngine) r4.L$0;
        m.b(r13);
    L45:
        ee.c r18 = r16;
        r15 = r15 + 1;
    L22:
        if (r15 < 3) goto L24;
    L46:
        return null;
    L24:
        if (cancelled == true) goto L46;
        r4.L$0 = r17;     // Catch: Throwable -> L32
        r4.L$1 = r18;     // Catch: Throwable -> L32
        r4.I$0 = r15;     // Catch: Throwable -> L32
        r4.label = 1;     // Catch: Throwable -> L32
        Object r19 = r18.invoke(r4);     // Catch: Throwable -> L32
        if (r19 == r10) goto L44;
        r16 = r18;
        r13 = r19;
    L30:
        Object r110 = l.m1004constructorimpl((Exit) r13);     // Catch: Throwable -> L18
    L36:
        if (l.m1010isFailureimpl(r110) == false) goto L38;
        r110 = null;
    L38:
        Exit r111 = (Exit) r110;
        if (r111 == null) goto L41;
        return r111;
    L41:
        if (r15 >= 2) goto L45;
        r4.L$0 = r17;
        r4.L$1 = r16;
        r4.I$0 = r15;
        r4.label = 2;
        if (m0.j(1200, r4) != r10) goto L45;
    L18:
        Throwable th2 = th;
    L34:
        r110 = l.m1004constructorimpl(m.a(th2));
    L44:
        return r10;
    L32:
        th = move-exception;
        r16 = r18;
        th2 = th;
        goto L34
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r15 = r4.I$0;
        r16 = (ee.c) r4.L$1;
        r17 = (MamiEngine) r4.L$0;
        m.b(r13);     // Catch: Throwable -> L18
        goto L30
    L20:
        m.b(r13);
        r18 = r11;
        r15 = 0;
        r17 = this;
    L7:
        r4 = new C06261(this, r12);
        goto L8
    }

    public static /* synthetic */ Status w(Status r4) {
        return connectExclusive$lambda$67(r4);
    }

    public static /* synthetic */ Status x(Status r4) {
        return tryServers$lambda$71(r4);
    }

    public static /* synthetic */ Status y(String r4, Status r8) {
        return connectExclusive$lambda$69(r4, r8);
    }

    public static /* synthetic */ Status z(Status r4) {
        return connectHive$lambda$58(r4);
    }

    public final CatalogInfo catalogInfo() {
        MamiApi r4 = MamiApi.INSTANCE;
        MamiApi.Summary r8 = r4.summary();
        if (r8.getHasCatalog() == true) goto L6;
        return null;
    L6:
        MamiCatalog.Parsed r10 = parsedSaved();
        long r11 = r8.getCatalogRevision();
        int r12 = r8.getCatalogPayloadVersion();
        boolean r13 = false;
        if (r10 == null) goto L9;
        int r14 = r10.getVersion();
    L10:
        if (r10 == null) goto L14;
        List<MamiCatalog.Server> r15 = r10.getServers();
        if (r15 == null) goto L14;
        int r16 = r15.size();
    L15:
        if (r10 == null) goto L19;
        List<MamiCatalog.Skipped> r17 = r10.getSkipped();
        if (r17 == null) goto L19;
        int r18 = r17.size();
    L20:
        long r19 = r8.getCatalogFetchedAt();
        long r110 = r8.getCatalogExpiresAt();
        if (r8.getCatalogExpiresAt() <= 0) goto L26;
        if (r8.getCatalogExpiresAt() <= r4.nowSec()) goto L26;
        r13 = true;
    L26:
        return new CatalogInfo(r11, r12, r14, r16, r18, r19, r110, r13);
    L19:
        r18 = 0;
    L14:
        r16 = 0;
        goto L15
    L9:
        r14 = 0;
        goto L10
    }

    public final void clearError() {
        if (((Status) ((g1) _status).getValue()).getError() == null) goto L6;
        setStatus(new f(23));
        return;
    }

    public final s1 connectAsync(Context r4, String r8, List<String> r10) {
        kotlin.jvm.internal.j.e(r4, "context");
        kotlin.jvm.internal.j.e(r10, "exclude");
        return (s1) connectionOwner.replace(null, new com.mlmvpn.core.aether.c(r4, 5, r8, r10));
    }

    public final MamiApi.Summary control$app_release() {
        return MamiApi.INSTANCE.summary();
    }

    public final boolean disconnectAsync(Context r4) {
        kotlin.jvm.internal.j.e(r4, "context");
        return connectionOwner.stop(null, new d(r4, 0));
    }

    public final String forget(Context r4, boolean r8) {
        kotlin.jvm.internal.j.e(r4, "context");
        init(r4);
        if (kotlin.jvm.internal.j.a(((Status) ((g1) _status).getValue()).getPhase(), "off") == true) goto L18;
        return "اول اتصال مامی را قطع کنید";
    L18:
        MamiApi.INSTANCE.forget(r8);     // Catch: Exception -> L9
        delays.clear();     // Catch: Exception -> L9
        cat = null;     // Catch: Exception -> L9
        hiveCat = null;     // Catch: Exception -> L9
        saveRoute(null);     // Catch: Exception -> L9
        if (r8 == false) goto L11;
        String r10 = "هویت این دستگاه و نشست آن پاک شد؛ اتصال بعدی دستگاه را دوباره ثبت می\u200cکند.";
    L12:
        log(r10);     // Catch: Exception -> L9
        bump();     // Catch: Exception -> L9
        return null;
    L11:
        r10 = "نشست و فهرست ذخیره\u200cشده پاک شد.";
    L9:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 != null) goto L20;
        return "پاک نشد";
    L20:
        return r11;
    }

    public final String freshConfig(Context r4) {
        kotlin.jvm.internal.j.e(r4, "context");
        init(r4);
        Live r8 = live;
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getConfig();
    }

    public final e1 getBusy() {
        return busy;
    }

    public final String getFrontMarker() {
        return frontMarker;
    }

    public final e1 getLogs() {
        return logs;
    }

    public final List<Method> getMETHODS() {
        return METHODS;
    }

    public final Map<String, String> getSTEP_WORDS() {
        return STEP_WORDS;
    }

    public final e1 getStatus() {
        return status;
    }

    public final e1 getVersion() {
        return version;
    }

    public final HiveInfo hiveInfo() {
        MamiApi.Summary r4 = MamiApi.INSTANCE.summary();
        if (r4.getHasHive() == true) goto L6;
        return null;
    L6:
        MamiCatalog.Hive r8 = parsedHive();
        long r10 = r4.getHiveFetchedAt();
        long r11 = r4.getHiveRevision();
        boolean r12 = false;
        if (r8 == null) goto L11;
        List<MamiCatalog.Server> r13 = r8.getServers();
        if (r13 == null) goto L11;
        int r14 = r13.size();
    L12:
        if (r8 == null) goto L16;
        List<MamiCatalog.Skipped> r15 = r8.getSkipped();
        if (r15 == null) goto L16;
        int r16 = r15.size();
    L18:
        if ((System.currentTimeMillis() - r4.getHiveFetchedAt()) >= 3600000) goto L21;
        r12 = true;
    L21:
        return new HiveInfo(r10, r11, r14, r16, r12);
    L16:
        r16 = 0;
    L11:
        r14 = 0;
        goto L12
    }

    public final void init(Context r8) {
        kotlin.jvm.internal.j.e(r8, "context");
        if (app == null) goto L5;
        return;
    L5:
        Context r10 = r8.getApplicationContext();
        app = r10;
        if (r10 == null) goto L23;
        InputStream r11 = r10.getAssets().open("mami/catalog-bootstrap.json");
        kotlin.jvm.internal.j.b(r11);     // Catch: Throwable -> L18
        String r4 = new String(t.p(r11), kotlin.text.a.f23859a);     // Catch: Throwable -> L18
        a.a.g(r11, null);
        MamiApi r12 = MamiApi.INSTANCE;
        Context r13 = app;
        if (r13 == null) goto L16;
        File r14 = new File(r13.getFilesDir(), "mami");
        String r15 = System.getProperty("http.agent");
        if (r15 != null) goto L14;
        r15 = "";
    L14:
        r12.init(r14, r4, r15, clientInfo());
        r12.setLogger(new f(11));
        r12.setNetworkOf(new a(1));
        MamiNet.INSTANCE.setRouteOf(new a(2));
        return;
    L16:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        a.a.g(r11, th);
        throw th;
    L23:
        kotlin.jvm.internal.j.k("app");
        throw null;
    }

    public final boolean isMamiConfig(String r4) {
        return kotlin.jvm.internal.j.a(r4, REMARKS);
    }

    public final boolean isOurs() {
        return kotlin.jvm.internal.j.a(((g1) MyVpnService.Companion.getConnectedNodeIdFlow()).getValue(), "mami");
    }

    public final List<PlaceRow> locations() {
        MamiCatalog.Parsed r4 = parsedSaved();
        if (r4 == null) goto L5;
        Map r8 = s7.e.h(new MamiEngine$locations$$inlined$groupingBy$1(r4.getServers()));
        HashSet r10 = new HashSet();
        int r11 = 0;
        if (r4.getLocations().isEmpty() == true) goto L16;
        List<MamiCatalog.Location> r12 = r4.getLocations();
        ArrayList r13 = new ArrayList(kotlin.collections.s.g0(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L24;
        MamiCatalog.Location r15 = (MamiCatalog.Location) r14.next();
        MamiCatalog.Place r16 = INSTANCE.placeOfLocation(r15);
        String r17 = r15.getId();
        String r18 = r15.getCountryCode();
        String r19 = r16.getCountry();
        String r110 = r16.getCity();
        int r111 = r15.getSort();
        Integer r20 = (Integer) r8.get(r15.getId());
        if (r20 == null) goto L14;
        int r112 = r20.intValue();
    L15:
        r13.add(new PlaceRow(r17, r18, r19, r110, r111, r112));
        goto L10
    L14:
        r112 = 0;
    L24:
        ArrayList r21 = new ArrayList();
        int r22 = r13.size();
    L25:
        if (r11 >= r22) goto L30;
        Object r23 = r13.get(r11);
        r11 = r11 + 1;
        if (r10.add(((PlaceRow) r23).getId()) == false) goto L25;
        r21.add(r23);
        goto L25
    L30:
        return q.b1(r21, new MamiEngine$locations$$inlined$thenBy$1(new MamiEngine$locations$$inlined$compareBy$1()));
    L16:
        List<MamiCatalog.Server> r24 = r4.getServers();
        r13 = new ArrayList(kotlin.collections.s.g0(r24, 10));
        Iterator<T> r25 = r24.iterator();
    L18:
        if (r25.hasNext() == false) goto L24;
        MamiCatalog.Server r26 = (MamiCatalog.Server) r25.next();
        j r27 = INSTANCE.placeOfServer(r26);
        String r113 = (String) r27.component1();
        String r114 = (String) r27.component2();
        String r28 = r26.getLocationId();
        String r115 = r26.getCountryCode();
        int r116 = r26.getSort();
        Integer r29 = (Integer) r8.get(r26.getLocationId());
        if (r29 == null) goto L22;
        int r117 = r29.intValue();
    L23:
        r13.add(new PlaceRow(r28, r115, r113, r114, r116, r117));
        goto L18
    L22:
        r117 = 0;
        goto L23
    L5:
        return w.INSTANCE;
    }

    public final void log(String r4) {
        kotlin.jvm.internal.j.e(r4, "msg");
        String r8 = d1.g("[", new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()), "] ", r4);
        Log.i(TAG, r4);
        k0 r10 = _logs;
        g1 r11 = (g1) r10;
        r11.j(q.e1(q.S0(m9.d.B(r8), (Iterable) r11.getValue()), 300));
    }

    public final s1 measureAllAsync(Context r4) {
        kotlin.jvm.internal.j.e(r4, "context");
        return m0.y(scope, null, null, new C06171(r4, null), 3);
    }

    public final Method method(String r4) {
        Iterator<T> r8 = METHODS.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r10 = r8.next();
        if (kotlin.jvm.internal.j.a(((Method) r10).getKey(), r4) == false) goto L4;
    L10:
        return (Method) r10;
    L8:
        r10 = null;
        goto L10
    }

    public final Prefs prefs() {
        SharedPreferences r4 = sp();
        String r8 = "auto";
        String r10 = r4.getString(ConstKt.SEP_METHOD, "auto");
        if (INSTANCE.method(r10) != null) goto L6;
        r10 = null;
    L6:
        if (r10 == null) goto L10;
        r8 = r10;
    L10:
        if (kotlin.jvm.internal.j.a(r4.getString("mode", "tunnel"), WarpIdRelay.VIA_PROXY) == false) goto L12;
        Mode r11 = Mode.PROXY;
    L13:
        String r12 = "";
        String r13 = r4.getString("location", "");
        if (r13 == null) goto L18;
        r12 = r13;
    L18:
        return new Prefs(r8, r11, r12);
    L12:
        r11 = Mode.TUNNEL;
        goto L13
    }

    public final void prewarm(Context r4) {
        kotlin.jvm.internal.j.e(r4, "context");
        init(r4);
        if (kotlin.jvm.internal.j.a(((Status) ((g1) _status).getValue()).getPhase(), "off") == false) goto L26;
        Method r8 = method(prefs().getMethod());
        if (r8 != null) goto L9;
        return;
    L9:
        if (kotlin.jvm.internal.j.a(r8.getKind(), WarpIdRelay.VIA_FRONT) == false) goto L12;
        return;
    L12:
        if (kotlin.jvm.internal.j.a(r8.getKey(), "auto") == false) goto L14;
    L15:
        CombineEngine r10 = CombineEngine.INSTANCE;
        Context r11 = app;
        if (r11 == null) goto L24;
        r10.warmMeasure(r11);
    L18:
        XrayHosts r12 = XrayHosts.INSTANCE;
        Context r13 = app;
        if (r13 == null) goto L22;
        r12.warm(r13, r12.getTUNNEL());
        return;
    L22:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L24:
        kotlin.jvm.internal.j.k("app");
        throw null;
    L14:
        if (kotlin.jvm.internal.j.a(r8.getKey(), "hive") == false) goto L18;
    }

    public final s1 refreshAsync(Context r4, String r8) {
        kotlin.jvm.internal.j.e(r4, "context");
        kotlin.jvm.internal.j.e(r8, "what");
        return m0.y(scope, null, null, new C06181(r4, r8, null), 3);
    }

    public final List<ServerRow> servers() {
        MamiCatalog.Parsed r4 = parsedSaved();
        if (r4 == null) goto L5;
        List<MamiCatalog.Server> r8 = r4.getServers();
        ArrayList r10 = new ArrayList(kotlin.collections.s.g0(r8, 10));
        Iterator<T> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L23;
        MamiCatalog.Server r12 = (MamiCatalog.Server) r11.next();
        j r13 = delays.get(r12.getId());
        j r14 = INSTANCE.placeOfServer(r12);
        String r15 = (String) r14.component1();
        String r16 = (String) r14.component2();
        String r17 = MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, r12, false, 2, null);
        String r18 = r12.getId();
        String r19 = r12.getCountryCode();
        String r110 = r12.getLocationId();
        String r111 = r12.getProtocol();
        String r112 = r12.getProfile();
        int r113 = r12.getSort();
        if (r17 != null) goto L12;
        boolean r114 = true;
    L13:
        if (r17 != null) goto L15;
        r17 = "";
    L15:
        String r115 = r17;
        long r20 = 0;
        if (r13 == null) goto L18;
        long r116 = ((Number) r13.getFirst()).longValue();
    L19:
        if (r13 == null) goto L21;
        r20 = ((Number) r13.getSecond()).longValue();
    L21:
        r10.add(new ServerRow(r18, r19, r15, r16, r110, r111, r112, r113, r114, r115, r116, r20));
        goto L8
    L18:
        r116 = 0;
        goto L19
    L12:
        r114 = false;
        goto L13
    L23:
        return q.b1(r10, new MamiEngine$servers$$inlined$thenBy$2(new MamiEngine$servers$$inlined$thenBy$1(new MamiEngine$servers$$inlined$compareBy$1())));
    L5:
        return w.INSTANCE;
    }

    public final Prefs setPrefs(String r4, Mode r8, String r10) {
        SharedPreferences.Editor r11 = sp().edit();
        if (r4 != null) goto L5;
    L7:
        if (r8 != null) goto L9;
    L13:
        if (r10 != null) goto L15;
    L19:
        r11.apply();
        bump();
        return prefs();
    L15:
        if (i.B("^[A-Za-z0-9_-]{0,64}$", r10) == true) goto L18;
        r10 = "";
    L18:
        r11.putString("location", r10);
        goto L19
    L9:
        if (r8 != Mode.PROXY) goto L11;
        String r12 = WarpIdRelay.VIA_PROXY;
    L12:
        r11.putString("mode", r12);
        goto L13
    L11:
        r12 = "tunnel";
        goto L12
    L5:
        if (method(r4) == null) goto L7;
        r11.putString(ConstKt.SEP_METHOD, r4);
        goto L7
    }

    public final String unnamed$app_release(String r8, String r10) {
        kotlin.jvm.internal.j.e(r10, ConstKt.SEP_METHOD);
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r11 = v.q0(v.q0(r8, "سرور آرگو", "پل"), "به آرگو", "به پل");
        Iterator<String> r4 = ENGINE_NAMES.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String r12 = r4.next();
        kotlin.text.l.Companion.getClass();
        kotlin.jvm.internal.j.e(r12, "literal");
        String r13 = Pattern.quote(r12);
        kotlin.jvm.internal.j.d(r13, "quote(...)");
        r11 = new kotlin.text.l(w0.n("(?<![\\p{L}\\p{M}])", r13, "(?![\\p{L}\\p{M}])"), kotlin.text.m.IGNORE_CASE).replace(r11, r10);
        goto L7
    L9:
        return r11;
    }
}
