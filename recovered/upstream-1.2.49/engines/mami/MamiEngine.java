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
import com.mlmvpn.core.lantern.LanternProcess;
import com.mlmvpn.core.tunnel.CoreConfig;
import com.mlmvpn.core.tunnel.IpFormatter;
import com.mlmvpn.core.tunnel.TunnelStatus;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.core.warp.XrayHosts;
import com.mlmvpn.scanner.MyVpnService;
import com.mlmvpn.scanner.data.CombineEngine;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.data.studio.central.ExitProxy;
import com.mlmvpn.scanner.engines.argo.ArgoNet;
import com.mlmvpn.scanner.engines.argo.ArgoProtocol;
import com.mlmvpn.scanner.engines.mae.device.DeviceSignals;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.engines.scout.ScoutScore;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.settings.SettingsSpotlight;
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
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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
import kotlin.collections.z;
import kotlin.jvm.internal.y;
import kotlin.text.o;
import kotlin.text.v;
import kotlinx.coroutines.flow.e1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
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
import x6.p;
import x6.t;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiEngine {
    public static final int $stable;
    private static final long CATALOG_MARGIN_SEC = 300;
    private static final List<String> ENGINE_NAMES;
    private static final int FAILOVER_MISSES = 3;
    private static final long FRESH_REGISTRATION_MS = 120000;
    private static final String HIVE_PROBE = "https://cp.cloudflare.com/generate_204";
    private static final long HIVE_TTL_MS = 3600000;
    private static final int KEEPALIVE_TICKS = 10;
    public static final String NODE_ID = "mami";
    private static final long OWNER_CHECK_MS = 5000;
    public static final String REMARKS = "mlm-mami-v1";
    private static final long SCOUT_BUDGET_MS = 30000;
    private static final long SCOUT_EACH_MS = 12000;
    private static final int SCOUT_MAX = 24;
    private static final long SCOUT_TTL_MS = 600000;
    private static final String TAG = "MAMI";
    private static final long TEMPLATE_FRESH_MS = 21600000;
    private static final long TEMPLATE_MAX_MS = 604800000;
    private static final long TICK_MS = 60000;
    private static final int TRIES = 3;
    private static final k0 _busy;
    private static final k0 _logs;
    private static final k0 _status;
    private static final k0 _version;
    private static Context app;
    private static final e1 busy;
    private static volatile boolean cancelled;
    private static j cat;
    private static s1 connectJob;
    private static final ConnectionOwner connectionOwner;
    private static final ConcurrentHashMap<String, j> delays;
    private static volatile ExclusiveLive exclusiveLive;
    private static volatile String frontMarker;
    private static volatile String frontTransport;
    private static j hiveCat;
    private static volatile Live live;
    private static final e1 logs;
    private static final e1 status;
    private static final e1 version;
    private static s1 watchJob;
    public static final MamiEngine INSTANCE = new MamiEngine();
    private static final List<Method> METHODS = r.a0(new Method("auto", "auto", "خودکار", "xray", null, true, "بهترین سرور فهرست رمزشدهٔ مامی، با سنجش واقعی تأخیر"), new Method("exclusive", "service:exclusive", "اختصاصی", "xray", null, true, "پلی که سرور مامی برای همین دستگاه می\u200cسازد"), new Method("meteor", "service:meteor", "سان", WarpIdRelay.VIA_FRONT, "geph", true, "شبکهٔ جهانی با مسیرهای پنهان"), new Method("hive", "service:hive", "لیون", "xray", null, true, "پل\u200cهایی که دستگاه\u200cهای دیگر آزموده\u200cاند"), new Method("smart", "service:smart", "هوشمند", WarpIdRelay.VIA_FRONT, "lantern", true, "خودش بهترین راه را پیدا می\u200cکند"), new Method("tor", "service:tor", "تایگر", WarpIdRelay.VIA_FRONT, "tor", true, "ناشناس و چندلایه، با پل\u200cهای خودش"));
    private static final Map<String, String> STEP_WORDS = d0.J(new j("session", "بررسی نشست این دستگاه با سرور مامی…"), new j("catalog", "گرفتن فهرست سرورها (رمزشده و امضاشده)…"), new j("hive", "گرفتن فهرست پل\u200cهای لیون…"), new j("bridge", "گرفتن پل اختصاصی این دستگاه…"), new j("auth", "احراز هویت با پل اختصاصی…"), new j("scout", "سنجش سرورها برای انتخاب بهترین…"), new j("engine", "راه\u200cاندازی موتور…"), new j("verify", "آزمون عبور داده (یک درخواست واقعی HTTPS)…"), new j("route", "روشن کردن مسیر انتخاب\u200cشده…"));
    private static final i0 scope = m0.a(g8.a.D(v0.f24208c, m0.b()));

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

        public Cand(String id2, MamiCatalog.Server server, sf.c outbound, String cc2, String country, String city, String locationId, String protocol, String profile) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(outbound, "outbound");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            kotlin.jvm.internal.j.e(locationId, "locationId");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profile, "profile");
            this.f11584id = id2;
            this.server = server;
            this.outbound = outbound;
            this.f11583cc = cc2;
            this.country = country;
            this.city = city;
            this.locationId = locationId;
            this.protocol = protocol;
            this.profile = profile;
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

        public CatalogInfo(long j, int i, int i10, int i11, int i12, long j10, long j11, boolean z10) {
            this.revision = j;
            this.payloadVersion = i;
            this.version = i10;
            this.servers = i11;
            this.skipped = i12;
            this.fetchedAt = j10;
            this.expiresAt = j11;
            this.fresh = z10;
        }

        public static /* synthetic */ CatalogInfo copy$default(CatalogInfo catalogInfo, long j, int i, int i10, int i11, int i12, long j10, long j11, boolean z10, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                j = catalogInfo.revision;
            }
            long j12 = j;
            if ((i13 & 2) != 0) {
                i = catalogInfo.payloadVersion;
            }
            return catalogInfo.copy(j12, i, (i13 & 4) != 0 ? catalogInfo.version : i10, (i13 & 8) != 0 ? catalogInfo.servers : i11, (i13 & 16) != 0 ? catalogInfo.skipped : i12, (i13 & 32) != 0 ? catalogInfo.fetchedAt : j10, (i13 & 64) != 0 ? catalogInfo.expiresAt : j11, (i13 & 128) != 0 ? catalogInfo.fresh : z10);
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

        public final CatalogInfo copy(long j, int i, int i10, int i11, int i12, long j10, long j11, boolean z10) {
            return new CatalogInfo(j, i, i10, i11, i12, j10, j11, z10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CatalogInfo)) {
                return false;
            }
            CatalogInfo catalogInfo = (CatalogInfo) obj;
            return this.revision == catalogInfo.revision && this.payloadVersion == catalogInfo.payloadVersion && this.version == catalogInfo.version && this.servers == catalogInfo.servers && this.skipped == catalogInfo.skipped && this.fetchedAt == catalogInfo.fetchedAt && this.expiresAt == catalogInfo.expiresAt && this.fresh == catalogInfo.fresh;
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
            return Boolean.hashCode(this.fresh) + w0.c(w0.c(androidx.compose.foundation.interaction.f.c(this.skipped, androidx.compose.foundation.interaction.f.c(this.servers, androidx.compose.foundation.interaction.f.c(this.version, androidx.compose.foundation.interaction.f.c(this.payloadVersion, Long.hashCode(this.revision) * 31, 31), 31), 31), 31), 31, this.fetchedAt), 31, this.expiresAt);
        }

        public String toString() {
            long j = this.revision;
            int i = this.payloadVersion;
            int i10 = this.version;
            int i11 = this.servers;
            int i12 = this.skipped;
            long j10 = this.fetchedAt;
            long j11 = this.expiresAt;
            boolean z10 = this.fresh;
            StringBuilder sbJ = i.j(j, "CatalogInfo(revision=", i, ", payloadVersion=");
            s.w(sbJ, ", version=", i10, ", servers=", i11);
            sbJ.append(", skipped=");
            sbJ.append(i12);
            sbJ.append(", fetchedAt=");
            sbJ.append(j10);
            v0.a.k(j11, ", expiresAt=", ", fresh=", sbJ);
            return f0.a.n(sbJ, ")", z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ExclusiveLive {
        private final String host;
        private final ArgoProtocol.SessionInfo info;
        private final int port;

        public ExclusiveLive(String host, int i, ArgoProtocol.SessionInfo info) {
            kotlin.jvm.internal.j.e(host, "host");
            kotlin.jvm.internal.j.e(info, "info");
            this.host = host;
            this.port = i;
            this.info = info;
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

        public Exit(String loc, String ip, long j) {
            kotlin.jvm.internal.j.e(loc, "loc");
            kotlin.jvm.internal.j.e(ip, "ip");
            this.loc = loc;
            this.ip = ip;
            this.ms = j;
        }

        public static /* synthetic */ Exit copy$default(Exit exit, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = exit.loc;
            }
            if ((i & 2) != 0) {
                str2 = exit.ip;
            }
            if ((i & 4) != 0) {
                j = exit.ms;
            }
            return exit.copy(str, str2, j);
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

        public final Exit copy(String loc, String ip, long j) {
            kotlin.jvm.internal.j.e(loc, "loc");
            kotlin.jvm.internal.j.e(ip, "ip");
            return new Exit(loc, ip, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Exit)) {
                return false;
            }
            Exit exit = (Exit) obj;
            return kotlin.jvm.internal.j.a(this.loc, exit.loc) && kotlin.jvm.internal.j.a(this.ip, exit.ip) && this.ms == exit.ms;
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
            return w0.k(this.ms, ")", s.n("Exit(loc=", this.loc, ", ip=", this.ip, ", ms="));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Fail extends Exception {
        private final String code;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fail(String code, String msg) {
            super(msg);
            kotlin.jvm.internal.j.e(code, "code");
            kotlin.jvm.internal.j.e(msg, "msg");
            this.code = code;
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

        public HiveInfo(long j, long j10, int i, int i10, boolean z10) {
            this.fetchedAt = j;
            this.revision = j10;
            this.servers = i;
            this.skipped = i10;
            this.fresh = z10;
        }

        public static /* synthetic */ HiveInfo copy$default(HiveInfo hiveInfo, long j, long j10, int i, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j = hiveInfo.fetchedAt;
            }
            long j11 = j;
            if ((i11 & 2) != 0) {
                j10 = hiveInfo.revision;
            }
            long j12 = j10;
            if ((i11 & 4) != 0) {
                i = hiveInfo.servers;
            }
            int i12 = i;
            if ((i11 & 8) != 0) {
                i10 = hiveInfo.skipped;
            }
            int i13 = i10;
            if ((i11 & 16) != 0) {
                z10 = hiveInfo.fresh;
            }
            return hiveInfo.copy(j11, j12, i12, i13, z10);
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

        public final HiveInfo copy(long j, long j10, int i, int i10, boolean z10) {
            return new HiveInfo(j, j10, i, i10, z10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HiveInfo)) {
                return false;
            }
            HiveInfo hiveInfo = (HiveInfo) obj;
            return this.fetchedAt == hiveInfo.fetchedAt && this.revision == hiveInfo.revision && this.servers == hiveInfo.servers && this.skipped == hiveInfo.skipped && this.fresh == hiveInfo.fresh;
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
            return Boolean.hashCode(this.fresh) + androidx.compose.foundation.interaction.f.c(this.skipped, androidx.compose.foundation.interaction.f.c(this.servers, w0.c(Long.hashCode(this.fetchedAt) * 31, 31, this.revision), 31), 31);
        }

        public String toString() {
            long j = this.fetchedAt;
            long j10 = this.revision;
            int i = this.servers;
            int i10 = this.skipped;
            boolean z10 = this.fresh;
            StringBuilder sbO = f0.a.o(j, "HiveInfo(fetchedAt=", ", revision=");
            s.p(i, j10, ", servers=", sbO);
            sbO.append(", skipped=");
            sbO.append(i10);
            sbO.append(", fresh=");
            sbO.append(z10);
            sbO.append(")");
            return sbO.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Live {
        private final Cand cand;
        private final String config;
        private final String engine;
        private final String kind;
        private final Mode mode;

        public Live(String kind, Cand cand, String str, String str2, Mode mode) {
            kotlin.jvm.internal.j.e(kind, "kind");
            kotlin.jvm.internal.j.e(mode, "mode");
            this.kind = kind;
            this.cand = cand;
            this.config = str;
            this.engine = str2;
            this.mode = mode;
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

        public Method(String key, String id2, String name, String kind, String str, boolean z10, String about) {
            kotlin.jvm.internal.j.e(key, "key");
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(name, "name");
            kotlin.jvm.internal.j.e(kind, "kind");
            kotlin.jvm.internal.j.e(about, "about");
            this.key = key;
            this.f11585id = id2;
            this.name = name;
            this.kind = kind;
            this.engine = str;
            this.ready = z10;
            this.about = about;
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
    public enum Mode {
        TUNNEL,
        PROXY;

        private static final /* synthetic */ yd.a $ENTRIES = com.google.android.gms.internal.mlkit_language_id_common.j.j(values());

        public static yd.a getEntries() {
            return $ENTRIES;
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

        public PlaceRow(String id2, String cc2, String country, String city, int i, int i10) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            this.f11587id = id2;
            this.f11586cc = cc2;
            this.country = country;
            this.city = city;
            this.sort = i;
            this.servers = i10;
        }

        public static /* synthetic */ PlaceRow copy$default(PlaceRow placeRow, String str, String str2, String str3, String str4, int i, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = placeRow.f11587id;
            }
            if ((i11 & 2) != 0) {
                str2 = placeRow.f11586cc;
            }
            if ((i11 & 4) != 0) {
                str3 = placeRow.country;
            }
            if ((i11 & 8) != 0) {
                str4 = placeRow.city;
            }
            if ((i11 & 16) != 0) {
                i = placeRow.sort;
            }
            if ((i11 & 32) != 0) {
                i10 = placeRow.servers;
            }
            int i12 = i;
            int i13 = i10;
            return placeRow.copy(str, str2, str3, str4, i12, i13);
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

        public final PlaceRow copy(String id2, String cc2, String country, String city, int i, int i10) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            return new PlaceRow(id2, cc2, country, city, i, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaceRow)) {
                return false;
            }
            PlaceRow placeRow = (PlaceRow) obj;
            return kotlin.jvm.internal.j.a(this.f11587id, placeRow.f11587id) && kotlin.jvm.internal.j.a(this.f11586cc, placeRow.f11586cc) && kotlin.jvm.internal.j.a(this.country, placeRow.country) && kotlin.jvm.internal.j.a(this.city, placeRow.city) && this.sort == placeRow.sort && this.servers == placeRow.servers;
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
            return Integer.hashCode(this.servers) + androidx.compose.foundation.interaction.f.c(this.sort, s.d(s.d(s.d(this.f11587id.hashCode() * 31, 31, this.f11586cc), 31, this.country), 31, this.city), 31);
        }

        public String toString() {
            String str = this.f11587id;
            String str2 = this.f11586cc;
            String str3 = this.country;
            String str4 = this.city;
            int i = this.sort;
            int i10 = this.servers;
            StringBuilder sbN = s.n("PlaceRow(id=", str, ", cc=", str2, ", country=");
            d1.x(sbN, str3, ", city=", str4, ", sort=");
            sbN.append(i);
            sbN.append(", servers=");
            sbN.append(i10);
            sbN.append(")");
            return sbN.toString();
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

        public static /* synthetic */ Prefs copy$default(Prefs prefs, String str, Mode mode, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = prefs.method;
            }
            if ((i & 2) != 0) {
                mode = prefs.mode;
            }
            if ((i & 4) != 0) {
                str2 = prefs.location;
            }
            return prefs.copy(str, mode, str2);
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

        public final Prefs copy(String method, Mode mode, String location) {
            kotlin.jvm.internal.j.e(method, "method");
            kotlin.jvm.internal.j.e(mode, "mode");
            kotlin.jvm.internal.j.e(location, "location");
            return new Prefs(method, mode, location);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Prefs)) {
                return false;
            }
            Prefs prefs = (Prefs) obj;
            return kotlin.jvm.internal.j.a(this.method, prefs.method) && this.mode == prefs.mode && kotlin.jvm.internal.j.a(this.location, prefs.location);
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
            return this.location.hashCode() + ((this.mode.hashCode() + (this.method.hashCode() * 31)) * 31);
        }

        public String toString() {
            String str = this.method;
            Mode mode = this.mode;
            String str2 = this.location;
            StringBuilder sb2 = new StringBuilder("Prefs(method=");
            sb2.append(str);
            sb2.append(", mode=");
            sb2.append(mode);
            sb2.append(", location=");
            return w0.r(sb2, str2, ")");
        }

        public Prefs(String method, Mode mode, String location) {
            kotlin.jvm.internal.j.e(method, "method");
            kotlin.jvm.internal.j.e(mode, "mode");
            kotlin.jvm.internal.j.e(location, "location");
            this.method = method;
            this.mode = mode;
            this.location = location;
        }

        public /* synthetic */ Prefs(String str, Mode mode, String str2, int i, kotlin.jvm.internal.e eVar) {
            this((i & 1) != 0 ? "auto" : str, (i & 2) != 0 ? Mode.TUNNEL : mode, (i & 4) != 0 ? "" : str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Ranked {
        private final long ms;
        private final long score;
        private final MamiCatalog.Server server;

        public Ranked(MamiCatalog.Server server, long j, long j10) {
            kotlin.jvm.internal.j.e(server, "server");
            this.server = server;
            this.ms = j;
            this.score = j10;
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

        public ServerRef(String id2, String cc2, String country, String city, String protocol, String profile, long j) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profile, "profile");
            this.f11589id = id2;
            this.f11588cc = cc2;
            this.country = country;
            this.city = city;
            this.protocol = protocol;
            this.profile = profile;
            this.ms = j;
        }

        public static /* synthetic */ ServerRef copy$default(ServerRef serverRef, String str, String str2, String str3, String str4, String str5, String str6, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverRef.f11589id;
            }
            if ((i & 2) != 0) {
                str2 = serverRef.f11588cc;
            }
            if ((i & 4) != 0) {
                str3 = serverRef.country;
            }
            if ((i & 8) != 0) {
                str4 = serverRef.city;
            }
            if ((i & 16) != 0) {
                str5 = serverRef.protocol;
            }
            if ((i & 32) != 0) {
                str6 = serverRef.profile;
            }
            if ((i & 64) != 0) {
                j = serverRef.ms;
            }
            long j10 = j;
            String str7 = str5;
            String str8 = str6;
            return serverRef.copy(str, str2, str3, str4, str7, str8, j10);
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

        public final ServerRef copy(String id2, String cc2, String country, String city, String protocol, String profile, long j) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profile, "profile");
            return new ServerRef(id2, cc2, country, city, protocol, profile, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServerRef)) {
                return false;
            }
            ServerRef serverRef = (ServerRef) obj;
            return kotlin.jvm.internal.j.a(this.f11589id, serverRef.f11589id) && kotlin.jvm.internal.j.a(this.f11588cc, serverRef.f11588cc) && kotlin.jvm.internal.j.a(this.country, serverRef.country) && kotlin.jvm.internal.j.a(this.city, serverRef.city) && kotlin.jvm.internal.j.a(this.protocol, serverRef.protocol) && kotlin.jvm.internal.j.a(this.profile, serverRef.profile) && this.ms == serverRef.ms;
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
            return Long.hashCode(this.ms) + s.d(s.d(s.d(s.d(s.d(this.f11589id.hashCode() * 31, 31, this.f11588cc), 31, this.country), 31, this.city), 31, this.protocol), 31, this.profile);
        }

        public String toString() {
            String str = this.f11589id;
            String str2 = this.f11588cc;
            String str3 = this.country;
            String str4 = this.city;
            String str5 = this.protocol;
            String str6 = this.profile;
            long j = this.ms;
            StringBuilder sbN = s.n("ServerRef(id=", str, ", cc=", str2, ", country=");
            d1.x(sbN, str3, ", city=", str4, ", protocol=");
            d1.x(sbN, str5, ", profile=", str6, ", ms=");
            return w0.k(j, ")", sbN);
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

        public ServerRow(String id2, String cc2, String country, String city, String locationId, String protocol, String profile, int i, boolean z10, String why, long j, long j10) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            kotlin.jvm.internal.j.e(locationId, "locationId");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profile, "profile");
            kotlin.jvm.internal.j.e(why, "why");
            this.f11591id = id2;
            this.f11590cc = cc2;
            this.country = country;
            this.city = city;
            this.locationId = locationId;
            this.protocol = protocol;
            this.profile = profile;
            this.sort = i;
            this.supported = z10;
            this.why = why;
            this.ms = j;
            this.at = j10;
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

        public final ServerRow copy(String id2, String cc2, String country, String city, String locationId, String protocol, String profile, int i, boolean z10, String why, long j, long j10) {
            kotlin.jvm.internal.j.e(id2, "id");
            kotlin.jvm.internal.j.e(cc2, "cc");
            kotlin.jvm.internal.j.e(country, "country");
            kotlin.jvm.internal.j.e(city, "city");
            kotlin.jvm.internal.j.e(locationId, "locationId");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profile, "profile");
            kotlin.jvm.internal.j.e(why, "why");
            return new ServerRow(id2, cc2, country, city, locationId, protocol, profile, i, z10, why, j, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServerRow)) {
                return false;
            }
            ServerRow serverRow = (ServerRow) obj;
            return kotlin.jvm.internal.j.a(this.f11591id, serverRow.f11591id) && kotlin.jvm.internal.j.a(this.f11590cc, serverRow.f11590cc) && kotlin.jvm.internal.j.a(this.country, serverRow.country) && kotlin.jvm.internal.j.a(this.city, serverRow.city) && kotlin.jvm.internal.j.a(this.locationId, serverRow.locationId) && kotlin.jvm.internal.j.a(this.protocol, serverRow.protocol) && kotlin.jvm.internal.j.a(this.profile, serverRow.profile) && this.sort == serverRow.sort && this.supported == serverRow.supported && kotlin.jvm.internal.j.a(this.why, serverRow.why) && this.ms == serverRow.ms && this.at == serverRow.at;
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
            return Long.hashCode(this.at) + w0.c(s.d(w0.d(androidx.compose.foundation.interaction.f.c(this.sort, s.d(s.d(s.d(s.d(s.d(s.d(this.f11591id.hashCode() * 31, 31, this.f11590cc), 31, this.country), 31, this.city), 31, this.locationId), 31, this.protocol), 31, this.profile), 31), 31, this.supported), 31, this.why), 31, this.ms);
        }

        public String toString() {
            String str = this.f11591id;
            String str2 = this.f11590cc;
            String str3 = this.country;
            String str4 = this.city;
            String str5 = this.locationId;
            String str6 = this.protocol;
            String str7 = this.profile;
            int i = this.sort;
            boolean z10 = this.supported;
            String str8 = this.why;
            long j = this.ms;
            long j10 = this.at;
            StringBuilder sbN = s.n("ServerRow(id=", str, ", cc=", str2, ", country=");
            d1.x(sbN, str3, ", city=", str4, ", locationId=");
            d1.x(sbN, str5, ", protocol=", str6, ", profile=");
            f0.a.r(i, str7, ", sort=", ", supported=", sbN);
            i.x(", why=", str8, ", ms=", sbN, z10);
            sbN.append(j);
            return s.j(j10, ", at=", ")", sbN);
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
            this(null, null, null, null, null, null, null, 0L, 0L, 0, null, 2047, null);
        }

        public static /* synthetic */ Status copy$default(Status status, String str, String str2, String str3, Mode mode, ServerRef serverRef, Exit exit, String str4, long j, long j10, int i, String str5, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = status.phase;
            }
            return status.copy(str, (i10 & 2) != 0 ? status.method : str2, (i10 & 4) != 0 ? status.step : str3, (i10 & 8) != 0 ? status.mode : mode, (i10 & 16) != 0 ? status.server : serverRef, (i10 & 32) != 0 ? status.exit : exit, (i10 & 64) != 0 ? status.error : str4, (i10 & 128) != 0 ? status.startedAt : j, (i10 & 256) != 0 ? status.connectedAt : j10, (i10 & 512) != 0 ? status.attempt : i, (i10 & 1024) != 0 ? status.lastWhy : str5);
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

        public final Status copy(String phase, String str, String step, Mode mode, ServerRef serverRef, Exit exit, String str2, long j, long j10, int i, String str3) {
            kotlin.jvm.internal.j.e(phase, "phase");
            kotlin.jvm.internal.j.e(step, "step");
            kotlin.jvm.internal.j.e(mode, "mode");
            return new Status(phase, str, step, mode, serverRef, exit, str2, j, j10, i, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Status)) {
                return false;
            }
            Status status = (Status) obj;
            return kotlin.jvm.internal.j.a(this.phase, status.phase) && kotlin.jvm.internal.j.a(this.method, status.method) && kotlin.jvm.internal.j.a(this.step, status.step) && this.mode == status.mode && kotlin.jvm.internal.j.a(this.server, status.server) && kotlin.jvm.internal.j.a(this.exit, status.exit) && kotlin.jvm.internal.j.a(this.error, status.error) && this.startedAt == status.startedAt && this.connectedAt == status.connectedAt && this.attempt == status.attempt && kotlin.jvm.internal.j.a(this.lastWhy, status.lastWhy);
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
            return kotlin.jvm.internal.j.a(this.phase, "on") || kotlin.jvm.internal.j.a(this.phase, "lost");
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getMethodName() {
            Method method = MamiEngine.INSTANCE.method(this.method);
            String name = method != null ? method.getName() : null;
            return name == null ? "" : name;
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
            String str = MamiEngine.INSTANCE.getSTEP_WORDS().get(this.step);
            return str == null ? "" : str;
        }

        public int hashCode() {
            int iHashCode = this.phase.hashCode() * 31;
            String str = this.method;
            int iHashCode2 = (this.mode.hashCode() + s.d((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.step)) * 31;
            ServerRef serverRef = this.server;
            int iHashCode3 = (iHashCode2 + (serverRef == null ? 0 : serverRef.hashCode())) * 31;
            Exit exit = this.exit;
            int iHashCode4 = (iHashCode3 + (exit == null ? 0 : exit.hashCode())) * 31;
            String str2 = this.error;
            int iC = androidx.compose.foundation.interaction.f.c(this.attempt, w0.c(w0.c((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.startedAt), 31, this.connectedAt), 31);
            String str3 = this.lastWhy;
            return iC + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.phase;
            String str2 = this.method;
            String str3 = this.step;
            Mode mode = this.mode;
            ServerRef serverRef = this.server;
            Exit exit = this.exit;
            String str4 = this.error;
            long j = this.startedAt;
            long j10 = this.connectedAt;
            int i = this.attempt;
            String str5 = this.lastWhy;
            StringBuilder sbN = s.n("Status(phase=", str, ", method=", str2, ", step=");
            sbN.append(str3);
            sbN.append(", mode=");
            sbN.append(mode);
            sbN.append(", server=");
            sbN.append(serverRef);
            sbN.append(", exit=");
            sbN.append(exit);
            sbN.append(", error=");
            s.q(j, str4, ", startedAt=", sbN);
            v0.a.k(j10, ", connectedAt=", ", attempt=", sbN);
            sbN.append(i);
            sbN.append(", lastWhy=");
            sbN.append(str5);
            sbN.append(")");
            return sbN.toString();
        }

        public Status(String phase, String str, String step, Mode mode, ServerRef serverRef, Exit exit, String str2, long j, long j10, int i, String str3) {
            kotlin.jvm.internal.j.e(phase, "phase");
            kotlin.jvm.internal.j.e(step, "step");
            kotlin.jvm.internal.j.e(mode, "mode");
            this.phase = phase;
            this.method = str;
            this.step = step;
            this.mode = mode;
            this.server = serverRef;
            this.exit = exit;
            this.error = str2;
            this.startedAt = j;
            this.connectedAt = j10;
            this.attempt = i;
            this.lastWhy = str3;
        }

        public /* synthetic */ Status(String str, String str2, String str3, Mode mode, ServerRef serverRef, Exit exit, String str4, long j, long j10, int i, String str5, int i10, kotlin.jvm.internal.e eVar) {
            this((i10 & 1) != 0 ? "off" : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? Mode.TUNNEL : mode, (i10 & 16) != 0 ? null : serverRef, (i10 & 32) != 0 ? null : exit, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? 0L : j, (i10 & 256) == 0 ? j10 : 0L, (i10 & 512) != 0 ? 0 : i, (i10 & 1024) != 0 ? null : str5);
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

        public AnonymousClass1(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.connect(null, null, null, null, null, this);
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

        public C06061(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.connectCatalog(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$10", f = "MamiEngine.kt", l = {546}, m = "invokeSuspend")
    public static final class AnonymousClass10 extends xd.j implements ee.c {
        final /* synthetic */ y $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(y yVar, wd.d dVar) {
            super(1, dVar);
            this.$list = yVar;
        }

        @Override // xd.a
        public final wd.d create(wd.d dVar) {
            return new AnonymousClass10(this.$list, dVar);
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
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            List list = (List) this.$list.element;
            this.label = 1;
            Object objScout$default = MamiEngine.scout$default(mamiEngine, list, true, false, this, 4, null);
            return objScout$default == aVar ? aVar : objScout$default;
        }

        @Override // ee.c
        public final Object invoke(wd.d dVar) {
            return ((AnonymousClass10) create(dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends xd.j implements ee.e {
        int label;

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
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass3) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06071(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.connectExclusive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06083 extends xd.j implements ee.e {
        int label;

        public C06083(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06083(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06083) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06091(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.connectFront(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectFront$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06103 extends xd.j implements ee.e {
        final /* synthetic */ String $engine;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06103(String str, wd.d dVar) {
            super(2, dVar);
            this.$engine = str;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06103(this.$engine, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            CoreConfig coreConfig = CoreConfig.INSTANCE;
            Context context = MamiEngine.app;
            if (context == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            String strJson = coreConfig.json(context, this.$engine);
            Context context2 = MamiEngine.app;
            if (context2 == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            Context context3 = MamiEngine.app;
            if (context3 != null) {
                v1.c.h(context2, new Intent(context3, (Class<?>) TunnelVpnService.class).setAction(TunnelVpnService.ACTION_CONNECT).putExtra("config", strJson));
                return u.f67154a;
            }
            kotlin.jvm.internal.j.k("app");
            throw null;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06103) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06111(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.connectHive(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06123 extends xd.j implements ee.e {
        int label;

        public C06123(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06123(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            return MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06123) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectHive$8", f = "MamiEngine.kt", l = {595}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends xd.j implements ee.c {
        final /* synthetic */ y $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(y yVar, wd.d dVar) {
            super(1, dVar);
            this.$list = yVar;
        }

        @Override // xd.a
        public final wd.d create(wd.d dVar) {
            return new AnonymousClass8(this.$list, dVar);
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
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            List list = (List) this.$list.element;
            this.label = 1;
            Object objScout = mamiEngine.scout(list, true, true, this);
            return objScout == aVar ? aVar : objScout;
        }

        @Override // ee.c
        public final Object invoke(wd.d dVar) {
            return ((AnonymousClass8) create(dVar)).invokeSuspend(u.f67154a);
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

        public C06131(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.disconnectNow(null, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectNow$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06143 extends xd.j implements ee.e {
        final /* synthetic */ ExclusiveLive $ex;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06143(ExclusiveLive exclusiveLive, wd.d dVar) {
            super(2, dVar);
            this.$ex = exclusiveLive;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C06143 c06143 = new C06143(this.$ex, dVar);
            c06143.L$0 = obj;
            return c06143;
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            Object objM1004constructorimpl;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            ExclusiveLive exclusiveLive = this.$ex;
            try {
                ArgoNet argoNet = ArgoNet.INSTANCE;
                String host = exclusiveLive.getHost();
                int port = exclusiveLive.getPort();
                ArgoProtocol.SessionInfo info = exclusiveLive.getInfo();
                LocalPort localPort = LocalPort.INSTANCE;
                Context context = MamiEngine.app;
                if (context != null) {
                    objM1004constructorimpl = l.m1004constructorimpl(argoNet.sessionRequest("disconnect", host, port, info, localPort.get(context) + LocalPort.PROBE_OFFSET, 6000L));
                    return l.m1003boximpl(objM1004constructorimpl);
                }
                kotlin.jvm.internal.j.k("app");
                throw null;
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06143) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine", f = "MamiEngine.kt", l = {880, 882}, m = "launch")
    public static final class C06151 extends xd.c {
        int label;
        /* synthetic */ Object result;

        public C06151(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.launch(null, null, this);
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

        public C06163(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06163(dVar);
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
            Object objH = kotlinx.coroutines.flow.h.h(connectionPhaseFlow, anonymousClass1, this);
            return objH == aVar ? aVar : objH;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06163) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(List<? extends j> list, kotlinx.coroutines.sync.h hVar, ConcurrentHashMap<String, Long> concurrentHashMap, String str, wd.d dVar) {
                super(2, dVar);
                this.$items = list;
                this.$sem = hVar;
                this.$out = concurrentHashMap;
                this.$probeUrl = str;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$items, this.$sem, this.$out, this.$probeUrl, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
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
                i0 i0Var = (i0) this.L$0;
                List<j> list = this.$items;
                kotlinx.coroutines.sync.h hVar = this.$sem;
                ConcurrentHashMap<String, Long> concurrentHashMap = this.$out;
                String str = this.$probeUrl;
                ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(list, 10));
                for (j jVar : list) {
                    arrayList.add(m0.c(i0Var, null, new MamiEngine$measure$2$1$1$1(hVar, concurrentHashMap, (String) jVar.component1(), str, (sf.c) jVar.component2(), null), 3));
                }
                this.label = 1;
                Object objD = m0.d(arrayList, this);
                return objD == aVar ? aVar : objD;
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((AnonymousClass1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(List<? extends j> list, String str, wd.d dVar) {
            super(2, dVar);
            this.$items = list;
            this.$probeUrl = str;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new AnonymousClass2(this.$items, this.$probeUrl, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.L$0;
                m.b(obj);
                return concurrentHashMap;
            }
            m.b(obj);
            CombineEngine combineEngine = CombineEngine.INSTANCE;
            Context context = MamiEngine.app;
            if (context == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            combineEngine.ensureCoreEnv(context);
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$items, new kotlinx.coroutines.sync.l(8), concurrentHashMap2, this.$probeUrl, null);
            this.L$0 = concurrentHashMap2;
            this.label = 1;
            return m0.L(30000L, anonymousClass1, this) == aVar ? aVar : concurrentHashMap2;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass2) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measureAllAsync$1", f = "MamiEngine.kt", l = {470}, m = "invokeSuspend")
    public static final class C06171 extends xd.j implements ee.e {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06171(Context context, wd.d dVar) {
            super(2, dVar);
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Status invokeSuspend$lambda$0(Status status) {
            return Status.copy$default(status, null, null, null, null, null, null, "هنوز فهرستی نیست — اول «به\u200cروزرسانی فهرست» را بزنید", 0L, 0L, 0, null, 1983, null);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06171(this.$context, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) throws IOException {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            u uVar = u.f67154a;
            try {
                try {
                    try {
                        if (i == 0) {
                            m.b(obj);
                            MamiEngine mamiEngine = MamiEngine.INSTANCE;
                            mamiEngine.init(this.$context);
                            if (((CharSequence) ((g1) MamiEngine._busy).getValue()).length() > 0) {
                                return uVar;
                            }
                            MamiCatalog.Parsed parsed = mamiEngine.parsedSaved();
                            if (parsed == null) {
                                mamiEngine.setStatus(new f(0));
                                return uVar;
                            }
                            g1 g1Var = (g1) MamiEngine._busy;
                            g1Var.getClass();
                            g1Var.k(null, "measure");
                            List<MamiCatalog.Server> servers = parsed.getServers();
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : servers) {
                                if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) obj2, false, 2, null) == null) {
                                    arrayList.add(obj2);
                                }
                            }
                            this.label = 1;
                            if (MamiEngine.scout$default(mamiEngine, arrayList, true, false, this, 4, null) == aVar) {
                                return aVar;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            m.b(obj);
                        }
                        g1 g1Var2 = (g1) MamiEngine._busy;
                        g1Var2.getClass();
                        g1Var2.k(null, "");
                        MamiEngine.INSTANCE.bump();
                    } catch (Throwable th2) {
                        MamiEngine mamiEngine2 = MamiEngine.INSTANCE;
                        mamiEngine2.log("سنجش انجام نشد: " + th2.getMessage());
                        g1 g1Var3 = (g1) MamiEngine._busy;
                        g1Var3.getClass();
                        g1Var3.k(null, "");
                        mamiEngine2.bump();
                    }
                    return uVar;
                } catch (CancellationException e10) {
                    throw e10;
                }
            } catch (Throwable th3) {
                g1 g1Var4 = (g1) MamiEngine._busy;
                g1Var4.getClass();
                g1Var4.k(null, "");
                MamiEngine.INSTANCE.bump();
                throw th3;
            }
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06171) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$refreshAsync$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06181 extends xd.j implements ee.e {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $what;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06181(Context context, String str, wd.d dVar) {
            super(2, dVar);
            this.$context = context;
            this.$what = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Status invokeSuspend$lambda$0(Throwable th2, Status status) {
            return Status.copy$default(status, null, null, null, null, null, null, th2.getMessage(), 0L, 0L, 0, null, 1983, null);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06181(this.$context, this.$what, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) throws IOException {
            List<MamiCatalog.Server> servers;
            List<MamiCatalog.Server> servers2;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            mamiEngine.init(this.$context);
            int length = ((CharSequence) ((g1) MamiEngine._busy).getValue()).length();
            u uVar = u.f67154a;
            if (length > 0 || kotlin.jvm.internal.j.a(((Status) ((g1) MamiEngine._status).getValue()).getPhase(), TunnelVpnService.STATUS_CONNECTING)) {
                return uVar;
            }
            ((g1) MamiEngine._busy).j(this.$what);
            int i = 0;
            try {
                try {
                    MamiApi.ensureSession$default(MamiApi.INSTANCE, false, 1, null);
                    if (kotlin.jvm.internal.j.a(this.$what, "hive")) {
                        mamiEngine.hiveNow(true);
                        MamiCatalog.Hive hive = mamiEngine.parsedHive();
                        mamiEngine.log("فهرست لیون تازه گرفته شد: " + ((hive == null || (servers2 = hive.getServers()) == null) ? 0 : servers2.size()) + " پل.");
                    } else {
                        mamiEngine.catalogNow(true);
                        MamiCatalog.Parsed parsed = mamiEngine.parsedSaved();
                        mamiEngine.log("فهرست تازه گرفته شد: " + ((parsed == null || (servers = parsed.getServers()) == null) ? 0 : servers.size()) + " سرور.");
                    }
                    g1 g1Var = (g1) MamiEngine._busy;
                    g1Var.getClass();
                    g1Var.k(null, "");
                    mamiEngine.bump();
                    return uVar;
                } catch (Throwable th2) {
                    g1 g1Var2 = (g1) MamiEngine._busy;
                    g1Var2.getClass();
                    g1Var2.k(null, "");
                    MamiEngine.INSTANCE.bump();
                    throw th2;
                }
            } catch (CancellationException e10) {
                throw e10;
            } catch (Throwable th3) {
                MamiEngine mamiEngine2 = MamiEngine.INSTANCE;
                String str = kotlin.jvm.internal.j.a(this.$what, "hive") ? "فهرست لیون" : "فهرست";
                mamiEngine2.log(str + " گرفته نشد: " + th3.getMessage());
                mamiEngine2.setStatus(new g(i, th3));
                g1 g1Var3 = (g1) MamiEngine._busy;
                g1Var3.getClass();
                g1Var3.k(null, "");
                mamiEngine2.bump();
                return uVar;
            }
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06181) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06191(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.scout(null, false, false, this);
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

        public C06201(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.settleAfterRegister(null, null, this);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00671(ExclusiveLive exclusiveLive, wd.d dVar) {
                super(2, dVar);
                this.$ex = exclusiveLive;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                return new C00671(this.$ex, dVar);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                ArgoNet argoNet = ArgoNet.INSTANCE;
                String host = this.$ex.getHost();
                int port = this.$ex.getPort();
                ArgoProtocol.SessionInfo info = this.$ex.getInfo();
                LocalPort localPort = LocalPort.INSTANCE;
                Context context = MamiEngine.app;
                if (context != null) {
                    return argoNet.sessionRequest(AetherScanService.EXTRA_KEEPALIVE, host, port, info, localPort.get(context) + LocalPort.PROBE_OFFSET, (32 & 32) != 0 ? 15000L : 0L);
                }
                kotlin.jvm.internal.j.k("app");
                throw null;
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((C00671) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$startWatch$1$5", f = "MamiEngine.kt", l = {995}, m = "invokeSuspend")
        public static final class AnonymousClass5 extends xd.j implements ee.e {
            final /* synthetic */ Live $l;
            final /* synthetic */ Prefs $p;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(Live live, Prefs prefs, wd.d dVar) {
                super(2, dVar);
                this.$l = live;
                this.$p = prefs;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                return new AnonymousClass5(this.$l, this.$p, dVar);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                int i = this.label;
                try {
                    if (i == 0) {
                        m.b(obj);
                        MamiEngine mamiEngine = MamiEngine.INSTANCE;
                        Mode mode = this.$l.getMode();
                        String location = this.$p.getLocation();
                        List listB = m9.d.B(this.$l.getCand().getId());
                        this.label = 1;
                        if (mamiEngine.connect("auto", mode, null, location, listB, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        m.b(obj);
                    }
                } catch (CancellationException e10) {
                    throw e10;
                } catch (Throwable th2) {
                    MamiEngine.INSTANCE.log("جابه\u200cجایی سرور نشد: " + th2.getMessage());
                }
                return u.f67154a;
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((AnonymousClass5) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        public C06211(wd.d dVar) {
            super(2, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Status invokeSuspend$lambda$0(Status status) {
            return Status.copy$default(status, "on", null, null, null, null, null, null, 0L, 0L, 0, null, 2046, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Status invokeSuspend$lambda$1(Exit exit, Status status) {
            return Status.copy$default(status, null, null, null, null, null, exit, null, 0L, 0L, 0, null, 2015, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Status invokeSuspend$lambda$2(Status status) {
            return Status.copy$default(status, "lost", null, null, null, null, null, null, 0L, 0L, 0, null, 2046, null);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            C06211 c06211 = new C06211(dVar);
            c06211.L$0 = obj;
            return c06211;
        }

        /* JADX WARN: Code duplicated, block: B:106:0x02ae A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:18:0x0090  */
        /* JADX WARN: Code duplicated, block: B:21:0x00a6 A[PHI: r2 r3 r5 r7 r9 r11
          0x00a6: PHI (r2v6 kotlinx.coroutines.i0) = (r2v14 kotlinx.coroutines.i0), (r2v35 kotlinx.coroutines.i0) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r3v9 long) = (r3v39 long), (r3v0 long) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r5v3 long) = (r5v4 long), (r5v0 long) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r7v6 long) = (r7v12 long), (r7v18 long) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r9v6 int) = (r9v8 int), (r9v14 int) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r11v4 int) = (r11v7 int), (r11v14 int) binds: [B:19:0x00a2, B:13:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:24:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:26:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:45:0x0107  */
        /* JADX WARN: Code duplicated, block: B:48:0x0111  */
        /* JADX WARN: Code duplicated, block: B:49:0x0113  */
        /* JADX WARN: Code duplicated, block: B:52:0x011d  */
        /* JADX WARN: Code duplicated, block: B:54:0x0126  */
        /* JADX WARN: Code duplicated, block: B:56:0x0132  */
        /* JADX WARN: Code duplicated, block: B:59:0x0149  */
        /* JADX WARN: Code duplicated, block: B:69:0x017d  */
        /* JADX WARN: Code duplicated, block: B:71:0x0187  */
        /* JADX WARN: Code duplicated, block: B:72:0x018c  */
        /* JADX WARN: Code duplicated, block: B:75:0x0195 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:91:0x021e  */
        /* JADX WARN: Code duplicated, block: B:93:0x0222  */
        /* JADX WARN: Code duplicated, block: B:98:0x024d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x02ba -> B:16:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0193 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0195 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0199 -> B:86:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01b5 -> B:81:0x01b8). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xd.a
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 822
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.mami.MamiEngine.C06211.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06211) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00682(TunnelController tunnelController, wd.d dVar) {
                super(2, dVar);
                this.$tc = tunnelController;
            }

            @Override // xd.a
            public final wd.d create(Object obj, wd.d dVar) {
                return new C00682(this.$tc, dVar);
            }

            @Override // xd.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
                int i = this.label;
                if (i != 0 && i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
                do {
                    String exitIp = ((TunnelUiState) this.$tc.getState().getValue()).getExitIp();
                    if (exitIp != null && !o.L0(exitIp)) {
                        return u.f67154a;
                    }
                    this.label = 1;
                } while (m0.j(MamiEngine.CATALOG_MARGIN_SEC, this) != aVar);
                return aVar;
            }

            @Override // ee.e
            public final Object invoke(i0 i0Var, wd.d dVar) {
                return ((C00682) create(i0Var, dVar)).invokeSuspend(u.f67154a);
            }
        }

        public C06222(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06222(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            TunnelController tunnelController;
            long j;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                m.b(obj);
                int activeSocksPort = TunnelStatus.INSTANCE.getActiveSocksPort();
                if (activeSocksPort > 0) {
                    MamiEngine mamiEngine = MamiEngine.INSTANCE;
                    Exit exitTrace = mamiEngine.trace(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, activeSocksPort)));
                    if (exitTrace != null) {
                        return mamiEngine.realExit(exitTrace);
                    }
                    return null;
                }
                if (!MamiEngine.INSTANCE.frontUp()) {
                    return null;
                }
                TunnelController tunnelController2 = TunnelController.INSTANCE;
                long jCurrentTimeMillis = System.currentTimeMillis();
                C00682 c00682 = new C00682(tunnelController2, null);
                this.L$0 = tunnelController2;
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                if (m0.L(6000L, c00682, this) == aVar) {
                    return aVar;
                }
                tunnelController = tunnelController2;
                j = jCurrentTimeMillis;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                tunnelController = (TunnelController) this.L$0;
                m.b(obj);
            }
            TunnelUiState tunnelUiState = (TunnelUiState) tunnelController.getState().getValue();
            String country = tunnelUiState.getCountry();
            if (country == null) {
                country = "";
            }
            String exitIp = tunnelUiState.getExitIp();
            String str = exitIp != null ? exitIp : "";
            String exitIp2 = tunnelUiState.getExitIp();
            return new Exit(country, str, (exitIp2 == null || o.L0(exitIp2)) ? 0L : System.currentTimeMillis() - j);
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06222) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$traceHttp$2", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06232 extends xd.j implements ee.e {
        int label;

        public C06232(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06232(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            Proxy.Type type = Proxy.Type.HTTP;
            LocalPort localPort = LocalPort.INSTANCE;
            Context context = MamiEngine.app;
            if (context != null) {
                return mamiEngine.trace(new Proxy(type, new InetSocketAddress(SniSession.LOCAL_HOST, localPort.get(context) + LocalPort.PROBE_OFFSET)));
            }
            kotlin.jvm.internal.j.k("app");
            throw null;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06232) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06241(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.tryServers(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$3", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class C06253 extends xd.j implements ee.e {
        final /* synthetic */ Cand $c;
        final /* synthetic */ PlaceRow $routePlace;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06253(Cand cand, PlaceRow placeRow, wd.d dVar) {
            super(2, dVar);
            this.$c = cand;
            this.$routePlace = placeRow;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new C06253(this.$c, this.$routePlace, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) throws Fail {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            MamiEngine.INSTANCE.applyRoute(this.$c, this.$routePlace);
            return u.f67154a;
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((C06253) create(i0Var, dVar)).invokeSuspend(u.f67154a);
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$5", f = "MamiEngine.kt", l = {686}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends xd.j implements ee.e {
        int label;

        public AnonymousClass5(wd.d dVar) {
            super(2, dVar);
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new AnonymousClass5(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                m.b(obj);
                TunnelExclusion tunnelExclusion = TunnelExclusion.INSTANCE;
                Context context = MamiEngine.app;
                if (context == null) {
                    kotlin.jvm.internal.j.k("app");
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
            return ((AnonymousClass5) create(i0Var, dVar)).invokeSuspend(u.f67154a);
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

        public C06261(wd.d dVar) {
            super(dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= TLObject.FLAG_31;
            return MamiEngine.this.verify(null, this);
        }
    }

    static {
        g1 g1VarB = kotlinx.coroutines.flow.h.b(new Status(null, null, null, null, null, null, null, 0L, 0L, 0, null, 2047, null));
        _status = g1VarB;
        status = g1VarB;
        g1 g1VarB2 = kotlinx.coroutines.flow.h.b(w.INSTANCE);
        _logs = g1VarB2;
        logs = g1VarB2;
        g1 g1VarB3 = kotlinx.coroutines.flow.h.b(0);
        _version = g1VarB3;
        version = g1VarB3;
        g1 g1VarB4 = kotlinx.coroutines.flow.h.b("");
        _busy = g1VarB4;
        busy = g1VarB4;
        connectionOwner = new ConnectionOwner();
        delays = new ConcurrentHashMap<>();
        ENGINE_NAMES = r.a0("ArgoVPN", "Argo", "آرگو", "Geph5", "Geph", "گف", LanternProcess.TAG, "لنترن", "Tor", "تور");
        $stable = 8;
    }

    private MamiEngine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRoute(Cand cand, PlaceRow placeRow) throws Fail {
        MamiCatalog.Server server = cand.getServer();
        if (server == null) {
            return;
        }
        j jVarConfirmedRoute = confirmedRoute();
        if (placeRow != null) {
            j jVar = new j(server.getProfile(), placeRow.getId());
            if (kotlin.jvm.internal.j.a(jVarConfirmedRoute, jVar)) {
                return;
            }
            try {
                MamiApi.INSTANCE.route((String) jVar.getFirst(), (String) jVar.getSecond(), true);
                saveRoute(jVar);
                return;
            } catch (Exception e10) {
                throw new Fail("ROUTE_FAILED", w0.n("انتخاب مکان به سرور مامی گفته نشد (", e10.getMessage(), ") — اتصال لغو شد"));
            }
        }
        if (jVarConfirmedRoute != null) {
            j jVar2 = new j(server.getProfile(), server.getLocationId());
            if (jVarConfirmedRoute.equals(jVar2)) {
                return;
            }
            try {
                MamiApi.INSTANCE.route((String) jVar2.getFirst(), (String) jVar2.getSecond(), false);
                saveRoute(null);
            } catch (Exception e11) {
                log("برگشت به مکانِ خود سرور به سرور مامی گفته نشد (" + e11.getMessage() + ").");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bump() {
        k0 k0Var = _version;
        Integer numValueOf = Integer.valueOf(((Number) ((g1) k0Var).getValue()).intValue() + 1);
        g1 g1Var = (g1) k0Var;
        g1Var.getClass();
        g1Var.k(null, numValueOf);
    }

    private final Cand candOf(MamiCatalog.Server server, PlaceRow placeRow) {
        String countryCode;
        String city;
        String country;
        j jVarPlaceOfServer = placeOfServer(server);
        String str = (String) jVarPlaceOfServer.component1();
        String str2 = (String) jVarPlaceOfServer.component2();
        String id2 = server.getId();
        sf.c cVarOutboundFor$default = MamiXrayConfig.outboundFor$default(MamiXrayConfig.INSTANCE, server, WarpIdRelay.VIA_PROXY, false, 4, null);
        if (placeRow == null || (countryCode = placeRow.getCc()) == null) {
            countryCode = server.getCountryCode();
        }
        return new Cand(id2, server, cVarOutboundFor$default, countryCode, (placeRow == null || (country = placeRow.getCountry()) == null) ? str : country, (placeRow == null || (city = placeRow.getCity()) == null) ? str2 : city, server.getLocationId(), server.getProtocol(), server.getProfile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MamiCatalog.Parsed catalogNow(boolean z10) throws Exception {
        Object objM1004constructorimpl;
        try {
            objM1004constructorimpl = l.m1004constructorimpl(MamiApi.INSTANCE.savedCatalog());
        } catch (Throwable th2) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
        }
        if (l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = null;
        }
        sf.c cVar = (sf.c) objM1004constructorimpl;
        boolean z11 = (cVar != null ? cVar.w("payload") : null) != null && cVar.x(0L, "expiresAt") > MamiApi.INSTANCE.nowSec() + CATALOG_MARGIN_SEC;
        if (z10 || !z11) {
            try {
                MamiApi.fetchCatalog$default(MamiApi.INSTANCE, null, 1, null);
            } catch (Exception e10) {
                if ((cVar != null ? cVar.w("payload") : null) == null) {
                    throw e10;
                }
                log("فهرست تازه گرفته نشد (" + e10.getMessage() + ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود.");
            }
            bump();
        }
        MamiCatalog.Parsed parsed = parsedSaved();
        if (parsed != null) {
            return parsed;
        }
        throw new IllegalStateException("فهرست سرورهای مامی خوانده نشد");
    }

    public static /* synthetic */ MamiCatalog.Parsed catalogNow$default(MamiEngine mamiEngine, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        return mamiEngine.catalogNow(z10);
    }

    private final void check() {
        if (cancelled) {
            throw new CancellationException("لغو شد");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status clearError$lambda$88(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, null, null, null, null, null, 0L, 0L, 0, null, 1983, null);
    }

    private final sf.c clientInfo() {
        String str = Build.MODEL;
        if (str == null) {
            str = "";
        }
        String strL1 = o.l1(80, o.n1(str).toString());
        if (strL1.length() < 2) {
            strL1 = "Android device";
        }
        String str2 = Build.VERSION.RELEASE;
        String strL2 = o.l1(24, str2 != null ? str2 : "");
        if (o.L0(strL2)) {
            strL2 = String.valueOf(Build.VERSION.SDK_INT);
        }
        Locale locale = Locale.getDefault();
        List listA0 = r.a0(locale.getLanguage(), locale.getCountry());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA0) {
            String str3 = (String) obj;
            kotlin.jvm.internal.j.b(str3);
            if (!o.L0(str3)) {
                arrayList.add(obj);
            }
        }
        String strF0 = q.F0(arrayList, "-", null, null, null, 62);
        if (o.L0(strF0)) {
            strF0 = GerehLocale.EN;
        }
        String id2 = TimeZone.getDefault().getID();
        if (o.L0(id2)) {
            id2 = "UTC";
        }
        sf.c cVarP = i.p("deviceModel", strL1, "androidVersion", strL2);
        i.s(56, "appVersionName", MamiApi.VERSION_NAME, "appVersionCode", cVarP);
        cVarP.D("locale", strF0);
        cVarP.D(DeviceSignals.TIMEZONE, id2);
        return cVarP;
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
    private final String config(sf.c cVar) {
        String strA;
        LocalPort localPort = LocalPort.INSTANCE;
        Context context = app;
        if (context == null) {
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
        int i = localPort.get(context);
        sf.c cVarO = i.o("remarks", REMARKS);
        sf.c cVar2 = new sf.c();
        cVar2.D("loglevel", "warning");
        cVarO.D(XrayCoreHostService.KEY_LOG, cVar2);
        sf.a aVar = new sf.a();
        sf.c cVarO2 = i.o("tag", "socks");
        com.mlmvpn.scanner.e.q(i, PsiphonProbeService.PORT, "listen", SniSession.LOCAL_HOST, cVarO2);
        sf.c cVarN = com.mlmvpn.scanner.e.n(cVarO2, "protocol", "mixed", "auth", "noauth");
        cVarN.E("udp", true);
        cVarO2.D("settings", cVarN);
        sf.c cVar3 = new sf.c();
        cVar3.E("enabled", true);
        sf.a aVar2 = new sf.a();
        aVar2.put(ExitProxy.HTTP);
        aVar2.put("tls");
        cVar3.D("destOverride", aVar2);
        cVarO2.D("sniffing", cVar3);
        aVar.put(cVarO2);
        sf.c cVar4 = new sf.c();
        cVar4.D("tag", ExitProxy.HTTP);
        cVar4.D(PsiphonProbeService.PORT, Integer.valueOf(i + LocalPort.PROBE_OFFSET));
        cVar4.D("listen", SniSession.LOCAL_HOST);
        cVar4.D("protocol", ExitProxy.HTTP);
        aVar.put(cVar4);
        cVarO.D("inbounds", aVar);
        XrayJsonGenerator xrayJsonGenerator = XrayJsonGenerator.INSTANCE;
        sf.c cVarQuicRefusalOutbound = xrayJsonGenerator.quicRefusalOutbound();
        sf.a aVar3 = new sf.a();
        sf.c cVar5 = new sf.c(cVar.toString());
        sf.c cVarO3 = com.mlmvpn.scanner.e.o(cVar5, "tag", WarpIdRelay.VIA_PROXY, aVar3, cVar5);
        cVarO3.D("tag", WarpIdRelay.VIA_DIRECT);
        sf.c cVarO4 = com.mlmvpn.scanner.e.o(cVarO3, "protocol", "freedom", aVar3, cVarO3);
        cVarO4.D("tag", "dns-out");
        sf.c cVarO5 = com.mlmvpn.scanner.e.o(cVarO4, "protocol", "dns", aVar3, cVarO4);
        cVarO5.D("tag", "blocked");
        cVarO5.D("protocol", "blackhole");
        aVar3.put(cVarO5);
        if (cVarQuicRefusalOutbound != null) {
            aVar3.put(cVarQuicRefusalOutbound);
        }
        cVarO.D("outbounds", aVar3);
        sf.c cVar6 = new sf.c();
        cVar6.D("tag", "mami-dns");
        sf.a aVar4 = new sf.a();
        sf.c cVar7 = new sf.c();
        cVar7.D("address", "https://8.8.8.8/dns-query");
        aVar4.put(cVar7);
        sf.c cVar8 = new sf.c();
        cVar8.D("address", "https://1.1.1.1/dns-query");
        aVar4.put(cVar8);
        cVar6.D("servers", aVar4);
        cVar6.D("queryStrategy", "UseIPv4");
        cVarO.D("dns", cVar6);
        sf.a aVar5 = new sf.a();
        sf.c cVarP = i.p(TeXSymbolParser.TYPE_ATTR, "field", PsiphonProbeService.PORT, "53");
        sf.c cVarO6 = com.mlmvpn.scanner.e.o(cVarP, "outboundTag", "dns-out", aVar5, cVarP);
        cVarO6.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a aVar6 = new sf.a();
        aVar6.put("mami-dns");
        cVarO6.D("inboundTag", aVar6);
        sf.c cVarO7 = com.mlmvpn.scanner.e.o(cVarO6, "outboundTag", WarpIdRelay.VIA_PROXY, aVar5, cVarO6);
        cVarO7.D(TeXSymbolParser.TYPE_ATTR, "field");
        sf.a aVar7 = new sf.a();
        aVar7.put("geoip:private");
        cVarO7.D("ip", aVar7);
        sf.c cVarO8 = com.mlmvpn.scanner.e.o(cVarO7, "outboundTag", WarpIdRelay.VIA_DIRECT, aVar5, cVarO7);
        cVarO8.D(TeXSymbolParser.TYPE_ATTR, "field");
        cVarO8.D(StudioError.NETWORK, "udp");
        cVarO8.D(PsiphonProbeService.PORT, "443");
        sf.c cVarO9 = com.mlmvpn.scanner.e.o(cVarO8, "outboundTag", (cVarQuicRefusalOutbound == null || (strA = cVarQuicRefusalOutbound.A("tag", "")) == null) ? "blocked" : strA, aVar5, cVarO8);
        cVarO9.D("domainStrategy", "AsIs");
        cVarO9.D("rules", aVar5);
        cVarO.D("routing", cVarO9);
        if (cVarQuicRefusalOutbound != null) {
            xrayJsonGenerator.addQuicRefusalPolicyTo(cVarO);
        }
        String string = cVarO.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }

    private final j confirmedRoute() {
        Object objM1004constructorimpl;
        String string = sp().getString("route", null);
        if (string == null) {
            return null;
        }
        try {
            objM1004constructorimpl = l.m1004constructorimpl(new sf.c(string));
        } catch (Throwable th2) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
        }
        if (l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = null;
        }
        sf.c cVar = (sf.c) objM1004constructorimpl;
        if (cVar == null) {
            return null;
        }
        j jVar = new j(cVar.A("profile", ""), cVar.A("locationId", ""));
        Object first = jVar.getFirst();
        kotlin.jvm.internal.j.d(first, "<get-first>(...)");
        if (o.L0((CharSequence) first)) {
            return null;
        }
        Object second = jVar.getSecond();
        kotlin.jvm.internal.j.d(second, "<get-second>(...)");
        if (o.L0((CharSequence) second)) {
            return null;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:68:0x01b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:91:0x0219  */
    /* JADX WARN: Code duplicated, block: B:94:0x0231  */
    /* JADX WARN: Code duplicated, block: B:98:0x0237 A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
    
        if (disconnectNow("switch", r3) == r4) goto L68;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0219, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(String str, Mode mode, String str2, String str3, List<String> list, wd.d dVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        boolean z10;
        Method method;
        Mode mode2;
        String str4;
        String str5;
        List<String> list2;
        String str6;
        String str7;
        MamiEngine mamiEngine;
        MamiEngine mamiEngine2;
        Method method2;
        boolean z11;
        String message;
        String strUnnamed$app_release;
        String str8;
        u uVar = u.f67154a;
        if (dVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) dVar;
            int i = anonymousClass1.label;
            if ((i & TLObject.FLAG_31) != 0) {
                anonymousClass1.label = i - TLObject.FLAG_31;
            } else {
                anonymousClass1 = new AnonymousClass1(dVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(dVar);
        }
        Object obj = anonymousClass1.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = anonymousClass1.label;
        try {
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        method = (Method) anonymousClass1.L$5;
                        list2 = (List) anonymousClass1.L$4;
                        str7 = (String) anonymousClass1.L$3;
                        str6 = (String) anonymousClass1.L$2;
                        z10 = false;
                        Mode mode3 = (Mode) anonymousClass1.L$1;
                        mamiEngine = (MamiEngine) anonymousClass1.L$0;
                        m.b(obj);
                        mode2 = mode3;
                    } else {
                        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        method2 = (Method) anonymousClass1.L$1;
                        mamiEngine2 = (MamiEngine) anonymousClass1.L$0;
                        try {
                            m.b(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            z10 = false;
                            if (cancelled) {
                                z11 = true;
                            } else {
                                z11 = true;
                            }
                            live = null;
                            frontMarker = null;
                            message = th.getMessage();
                            if (message == null) {
                                message = "وصل نشد";
                            }
                            strUnnamed$app_release = mamiEngine2.unnamed$app_release(message, method2.getName());
                            k0 k0Var = _status;
                            Status status2 = (Status) ((g1) k0Var).getValue();
                            if (z11) {
                                str8 = null;
                            } else {
                                str8 = strUnnamed$app_release;
                            }
                            ((g1) k0Var).j(Status.copy$default(status2, "off", null, "", null, null, null, str8, 0L, 0L, 0, null, 1978, null));
                            if (!z11) {
                                mamiEngine2.log("وصل نشد: " + strUnnamed$app_release);
                            }
                            mamiEngine2.bump();
                            if (th instanceof CancellationException) {
                                throw th;
                            }
                        }
                    }
                    return uVar;
                }
                z10 = false;
                m.b(obj);
                method = method(str);
                if (method == null) {
                    return uVar;
                }
                if (((Status) ((g1) _status).getValue()).getLive()) {
                    anonymousClass1.L$0 = this;
                    mode2 = mode;
                    anonymousClass1.L$1 = mode2;
                    str4 = str2;
                    anonymousClass1.L$2 = str4;
                    str5 = str3;
                    anonymousClass1.L$3 = str5;
                    list2 = list;
                    anonymousClass1.L$4 = list2;
                    anonymousClass1.L$5 = method;
                    anonymousClass1.label = 1;
                } else {
                    mode2 = mode;
                    str4 = str2;
                    str5 = str3;
                    list2 = list;
                }
                str6 = str4;
                str7 = str5;
                mamiEngine = this;
                if (kotlin.jvm.internal.j.a(method.getKind(), WarpIdRelay.VIA_FRONT)) {
                    anonymousClass1.L$0 = mamiEngine;
                    anonymousClass1.L$1 = method;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 2;
                    if (mamiEngine.connectFront(method, mode2, anonymousClass1) == aVar) {
                        return aVar;
                    }
                    return uVar;
                }
                if (kotlin.jvm.internal.j.a(method.getKey(), "hive")) {
                    anonymousClass1.L$0 = mamiEngine;
                    anonymousClass1.L$1 = method;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 3;
                    if (mamiEngine.connectHive(mode2, list2, anonymousClass1) == aVar) {
                        return aVar;
                    }
                    return uVar;
                }
                if (kotlin.jvm.internal.j.a(method.getKey(), "exclusive")) {
                    anonymousClass1.L$0 = mamiEngine;
                    anonymousClass1.L$1 = method;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 4;
                    if (mamiEngine.connectExclusive(mode2, anonymousClass1) == aVar) {
                        return aVar;
                    }
                    return uVar;
                }
                anonymousClass1.L$0 = mamiEngine;
                anonymousClass1.L$1 = method;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.label = 5;
                MamiEngine mamiEngine3 = mamiEngine;
                try {
                    if (mamiEngine3.connectCatalog(mode2, str6, str7, list2, anonymousClass1) == aVar) {
                        return aVar;
                    }
                    return uVar;
                } catch (Throwable th3) {
                    th = th3;
                    mamiEngine2 = mamiEngine3;
                    method2 = method;
                    if (cancelled) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    live = null;
                    frontMarker = null;
                    message = th.getMessage();
                    if (message == null) {
                        message = "وصل نشد";
                    }
                    strUnnamed$app_release = mamiEngine2.unnamed$app_release(message, method2.getName());
                    k0 k0Var2 = _status;
                    Status status3 = (Status) ((g1) k0Var2).getValue();
                    if (z11) {
                        str8 = null;
                    } else {
                        str8 = strUnnamed$app_release;
                    }
                    ((g1) k0Var2).j(Status.copy$default(status3, "off", null, "", null, null, null, str8, 0L, 0L, 0, null, 1978, null));
                    if (!z11) {
                        mamiEngine2.log("وصل نشد: " + strUnnamed$app_release);
                    }
                    mamiEngine2.bump();
                    if (th instanceof CancellationException) {
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                method2 = method;
                mamiEngine2 = mamiEngine;
                if (cancelled) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                live = null;
                frontMarker = null;
                message = th.getMessage();
                if (message == null) {
                    message = "وصل نشد";
                }
                strUnnamed$app_release = mamiEngine2.unnamed$app_release(message, method2.getName());
                k0 k0Var3 = _status;
                Status status4 = (Status) ((g1) k0Var3).getValue();
                if (z11) {
                    str8 = null;
                } else {
                    str8 = strUnnamed$app_release;
                }
                ((g1) k0Var3).j(Status.copy$default(status4, "off", null, "", null, null, null, str8, 0L, 0L, 0, null, 1978, null));
                if (!z11) {
                    mamiEngine2.log("وصل نشد: " + strUnnamed$app_release);
                }
                mamiEngine2.bump();
                if (th instanceof CancellationException) {
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            mamiEngine2 = mamiEngine;
        }
        cancelled = z10;
        Mode mode4 = kotlin.jvm.internal.j.a(method.getKind(), WarpIdRelay.VIA_FRONT) ? Mode.TUNNEL : mode2;
        k0 k0Var4 = _status;
        Status status5 = new Status(TunnelVpnService.STATUS_CONNECTING, method.getKey(), kotlin.jvm.internal.j.a(method.getKind(), "xray") ? "session" : "engine", mode4, null, null, null, System.currentTimeMillis(), 0L, 0, null, 1904, null);
        Mode mode5 = mode4;
        g1 g1Var = (g1) k0Var4;
        g1Var.getClass();
        g1Var.k(null, status5);
        mamiEngine.log(d1.h("اتصال با روش «", method.getName(), "» (", mode5 == Mode.TUNNEL ? "تونل کامل" : "پراکسی", ")…"));
        method2 = method;
        if (cancelled || (th instanceof CancellationException)) {
            z11 = true;
        } else {
            z11 = z10;
        }
        live = null;
        frontMarker = null;
        message = th.getMessage();
        if (message == null) {
            message = "وصل نشد";
        }
        strUnnamed$app_release = mamiEngine2.unnamed$app_release(message, method2.getName());
        k0 k0Var5 = _status;
        Status status6 = (Status) ((g1) k0Var5).getValue();
        if (z11) {
            str8 = null;
        } else {
            str8 = strUnnamed$app_release;
        }
        ((g1) k0Var5).j(Status.copy$default(status6, "off", null, "", null, null, null, str8, 0L, 0L, 0, null, 1978, null));
        if (!z11) {
            mamiEngine2.log("وصل نشد: " + strUnnamed$app_release);
        }
        mamiEngine2.bump();
        if ((th instanceof CancellationException) && !cancelled) {
            throw th;
        }
        return uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s1 connectAsync$default(MamiEngine mamiEngine, Context context, String str, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            list = w.INSTANCE;
        }
        return mamiEngine.connectAsync(context, str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s1 connectAsync$lambda$43(Context context, String str, List list) throws IOException {
        INSTANCE.init(context);
        s1 s1Var = connectJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        s1 s1Var2 = watchJob;
        if (s1Var2 != null) {
            s1Var2.cancel(null);
        }
        q2 q2VarY = m0.y(scope, null, null, new MamiEngine$connectAsync$1$1(str, list, null), 3);
        connectJob = q2VarY;
        return q2VarY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:110:0x02d9 A[LOOP:2: B:108:0x02d3->B:110:0x02d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x0323  */
    /* JADX WARN: Code duplicated, block: B:129:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:? A[LOOP:6: B:76:0x01db->B:138:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x0215 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x011f  */
    /* JADX WARN: Code duplicated, block: B:36:0x012f  */
    /* JADX WARN: Code duplicated, block: B:40:0x013f  */
    /* JADX WARN: Code duplicated, block: B:42:0x014a  */
    /* JADX WARN: Code duplicated, block: B:45:0x015a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0171  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x0204  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x0245  */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0305, code lost:
    
        if (r3.tryServers(r4, r5, r6, true, r7) == r2) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0264, code lost:
    
        if (r1 == r2) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connectCatalog(Mode mode, String str, String str2, List<String> list, wd.d dVar) throws Throwable {
        C06061 c06061;
        Mode mode2;
        String str3;
        List<String> list2;
        String str4;
        MamiEngine mamiEngine;
        List<String> list3;
        Mode mode3;
        String str5;
        y yVar;
        ArrayList arrayList;
        y yVar2;
        Set setP1;
        MamiEngine mamiEngine2;
        Object objScout$default;
        y yVar3;
        MamiEngine mamiEngine3;
        Mode mode4;
        y yVar4;
        Iterable iterable;
        Iterator it;
        ArrayList arrayList2;
        Object next;
        MamiEngine mamiEngine4;
        Iterator<T> it2;
        Object next2;
        Object obj;
        ArrayList arrayList3;
        Iterator it3;
        if (dVar instanceof C06061) {
            c06061 = (C06061) dVar;
            int i = c06061.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06061.label = i - TLObject.FLAG_31;
            } else {
                c06061 = new C06061(dVar);
            }
        } else {
            c06061 = new C06061(dVar);
        }
        C06061 c06062 = c06061;
        Object objJ = c06062.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06062.label;
        if (i10 == 0) {
            m.b(objJ);
            setStatus(new f(8));
            oe.e eVar = v0.f24208c;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
            c06062.L$0 = this;
            mode2 = mode;
            c06062.L$1 = mode2;
            str3 = str;
            c06062.L$2 = str3;
            c06062.L$3 = str2;
            list2 = list;
            c06062.L$4 = list2;
            c06062.label = 1;
            if (m0.J(eVar, anonymousClass3, c06062) != aVar) {
                str4 = str2;
                mamiEngine = this;
            }
            return aVar;
        }
        if (i10 == 1) {
            List<String> list4 = (List) c06062.L$4;
            str4 = (String) c06062.L$3;
            String str6 = (String) c06062.L$2;
            Mode mode5 = (Mode) c06062.L$1;
            mamiEngine = (MamiEngine) c06062.L$0;
            m.b(objJ);
            str3 = str6;
            mode2 = mode5;
            list2 = list4;
        } else {
            if (i10 == 2) {
                list3 = (List) c06062.L$4;
                str4 = (String) c06062.L$3;
                str5 = (String) c06062.L$2;
                Mode mode6 = (Mode) c06062.L$1;
                mamiEngine = (MamiEngine) c06062.L$0;
                m.b(objJ);
                mode3 = mode6;
                mamiEngine.check();
                yVar = new y();
                List<MamiCatalog.Server> servers = ((MamiCatalog.Parsed) objJ).getServers();
                arrayList = new ArrayList();
                for (Object obj2 : servers) {
                    if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) obj2, false, 2, null) == null) {
                        arrayList.add(obj2);
                    }
                }
                yVar.element = arrayList;
                if (!arrayList.isEmpty()) {
                    throw new Fail("NO_SERVERS", "فهرست مامی هیچ سروری نداشت که این برنامه بتواند اجرا کند");
                }
                yVar2 = new y();
                if (!o.L0(str4)) {
                    it2 = mamiEngine.locations().iterator();
                    do {
                        if (it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (!kotlin.jvm.internal.j.a(((PlaceRow) next2).getId(), str4));
                    yVar2.element = next2;
                    if (next2 == null) {
                        mamiEngine.log("مکان انتخاب\u200cشده در فهرست فعلی نیست؛ مکانِ خود سرور به کار می\u200cرود.");
                    }
                }
                if (str5 != null || o.L0(str5)) {
                    setP1 = q.p1(list3);
                    if (!setP1.isEmpty()) {
                        iterable = (Iterable) yVar.element;
                        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            it = iterable.iterator();
                            while (it.hasNext()) {
                                if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                                    Iterable iterable2 = (Iterable) yVar.element;
                                    arrayList2 = new ArrayList();
                                    for (Object obj3 : iterable2) {
                                        if (!setP1.contains(((MamiCatalog.Server) obj3).getId())) {
                                            arrayList2.add(obj3);
                                        }
                                    }
                                    yVar.element = arrayList2;
                                    break;
                                }
                            }
                        }
                    }
                    mamiEngine.setStatus(new f(10));
                    List list5 = (List) yVar.element;
                    c06062.L$0 = mamiEngine;
                    c06062.L$1 = mode3;
                    c06062.L$2 = yVar;
                    c06062.L$3 = yVar2;
                    c06062.L$4 = null;
                    c06062.label = 3;
                    mamiEngine2 = mamiEngine;
                    objScout$default = scout$default(mamiEngine2, list5, false, false, c06062, 6, null);
                    if (objScout$default != aVar) {
                        yVar3 = yVar;
                        objJ = objScout$default;
                        mamiEngine3 = mamiEngine2;
                        mode4 = mode3;
                        yVar4 = yVar2;
                        mamiEngine3.check();
                        AnonymousClass10 anonymousClass10 = new AnonymousClass10(yVar3, null);
                        c06062.L$0 = mamiEngine3;
                        c06062.L$1 = mode4;
                        c06062.L$2 = yVar3;
                        c06062.L$3 = yVar4;
                        c06062.label = 4;
                        objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass10, c06062);
                    }
                } else {
                    Iterator it4 = ((Iterable) yVar.element).iterator();
                    do {
                        if (!it4.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it4.next();
                    } while (!kotlin.jvm.internal.j.a(((MamiCatalog.Server) next).getId(), str5));
                    MamiCatalog.Server server = (MamiCatalog.Server) next;
                    if (server == null) {
                        throw new Fail("NO_SERVER", "این سرور در فهرست فعلی مامی نیست");
                    }
                    List listB = m9.d.B(server);
                    mamiEngine4 = mamiEngine;
                    mode4 = mode3;
                    obj = listB;
                    Iterable iterable3 = (Iterable) obj;
                    arrayList3 = new ArrayList(kotlin.collections.s.g0(iterable3, 10));
                    it3 = iterable3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(INSTANCE.candOf((MamiCatalog.Server) it3.next(), (PlaceRow) yVar2.element));
                    }
                    PlaceRow placeRow = (PlaceRow) yVar2.element;
                    c06062.L$0 = null;
                    c06062.L$1 = null;
                    c06062.L$2 = null;
                    c06062.L$3 = null;
                    c06062.L$4 = null;
                    c06062.label = 5;
                }
                return aVar;
            }
            if (i10 == 3) {
                yVar4 = (y) c06062.L$3;
                yVar3 = (y) c06062.L$2;
                mode4 = (Mode) c06062.L$1;
                mamiEngine3 = (MamiEngine) c06062.L$0;
                m.b(objJ);
                mamiEngine3.check();
                AnonymousClass10 anonymousClass11 = new AnonymousClass10(yVar3, null);
                c06062.L$0 = mamiEngine3;
                c06062.L$1 = mode4;
                c06062.L$2 = yVar3;
                c06062.L$3 = yVar4;
                c06062.label = 4;
                objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass11, c06062);
            } else if (i10 == 4) {
                yVar4 = (y) c06062.L$3;
                yVar3 = (y) c06062.L$2;
                mode4 = (Mode) c06062.L$1;
                mamiEngine3 = (MamiEngine) c06062.L$0;
                m.b(objJ);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : (List) objJ) {
                    if (((Ranked) obj4).getMs() > 0) {
                        arrayList4.add(obj4);
                    }
                }
                List listE1 = q.e1(arrayList4, 3);
                ArrayList arrayList5 = new ArrayList(kotlin.collections.s.g0(listE1, 10));
                Iterator it5 = listE1.iterator();
                while (it5.hasNext()) {
                    arrayList5.add(((Ranked) it5.next()).getServer());
                }
                if (arrayList5.isEmpty()) {
                    throw new Fail("NONE_ANSWERED", androidx.compose.foundation.interaction.f.o(((List) yVar3.element).size(), "هیچ\u200cکدام از ", " سرور مامی در سنجش جواب نداد"));
                }
                yVar2 = yVar4;
                mamiEngine4 = mamiEngine3;
                obj = arrayList5;
                Iterable iterable4 = (Iterable) obj;
                arrayList3 = new ArrayList(kotlin.collections.s.g0(iterable4, 10));
                it3 = iterable4.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(INSTANCE.candOf((MamiCatalog.Server) it3.next(), (PlaceRow) yVar2.element));
                }
                PlaceRow placeRow2 = (PlaceRow) yVar2.element;
                c06062.L$0 = null;
                c06062.L$1 = null;
                c06062.L$2 = null;
                c06062.L$3 = null;
                c06062.L$4 = null;
                c06062.label = 5;
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(objJ);
            }
        }
        return u.f67154a;
        mamiEngine.check();
        mamiEngine.setStatus(new f(9));
        oe.e eVar2 = v0.f24208c;
        MamiEngine$connectCatalog$parsed$1 mamiEngine$connectCatalog$parsed$1 = new MamiEngine$connectCatalog$parsed$1(null);
        c06062.L$0 = mamiEngine;
        c06062.L$1 = mode2;
        c06062.L$2 = str3;
        c06062.L$3 = str4;
        c06062.L$4 = list2;
        c06062.label = 2;
        objJ = m0.J(eVar2, mamiEngine$connectCatalog$parsed$1, c06062);
        if (objJ != aVar) {
            list3 = list2;
            mode3 = mode2;
            str5 = str3;
            mamiEngine.check();
            yVar = new y();
            List<MamiCatalog.Server> servers2 = ((MamiCatalog.Parsed) objJ).getServers();
            arrayList = new ArrayList();
            while (r1.hasNext()) {
                if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) obj2, false, 2, null) == null) {
                    arrayList.add(obj2);
                }
            }
            yVar.element = arrayList;
            if (!arrayList.isEmpty()) {
                throw new Fail("NO_SERVERS", "فهرست مامی هیچ سروری نداشت که این برنامه بتواند اجرا کند");
            }
            yVar2 = new y();
            if (!o.L0(str4)) {
                it2 = mamiEngine.locations().iterator();
                do {
                    if (it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (!kotlin.jvm.internal.j.a(((PlaceRow) next2).getId(), str4));
                yVar2.element = next2;
                if (next2 == null) {
                    mamiEngine.log("مکان انتخاب\u200cشده در فهرست فعلی نیست؛ مکانِ خود سرور به کار می\u200cرود.");
                }
            }
            if (str5 != null) {
            }
            setP1 = q.p1(list3);
            if (!setP1.isEmpty()) {
                iterable = (Iterable) yVar.element;
                if (!(iterable instanceof Collection)) {
                    it = iterable.iterator();
                    while (it.hasNext()) {
                        if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                            Iterable iterable5 = (Iterable) yVar.element;
                            arrayList2 = new ArrayList();
                            while (r3.hasNext()) {
                                if (!setP1.contains(((MamiCatalog.Server) obj3).getId())) {
                                    arrayList2.add(obj3);
                                }
                            }
                            yVar.element = arrayList2;
                            break;
                        }
                    }
                } else {
                    it = iterable.iterator();
                    while (it.hasNext()) {
                        if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                            Iterable iterable6 = (Iterable) yVar.element;
                            arrayList2 = new ArrayList();
                            while (r3.hasNext()) {
                                if (!setP1.contains(((MamiCatalog.Server) obj3).getId())) {
                                    arrayList2.add(obj3);
                                }
                            }
                            yVar.element = arrayList2;
                            break;
                        }
                    }
                }
            }
            mamiEngine.setStatus(new f(10));
            List list6 = (List) yVar.element;
            c06062.L$0 = mamiEngine;
            c06062.L$1 = mode3;
            c06062.L$2 = yVar;
            c06062.L$3 = yVar2;
            c06062.L$4 = null;
            c06062.label = 3;
            mamiEngine2 = mamiEngine;
            objScout$default = scout$default(mamiEngine2, list6, false, false, c06062, 6, null);
            if (objScout$default != aVar) {
                yVar3 = yVar;
                objJ = objScout$default;
                mamiEngine3 = mamiEngine2;
                mode4 = mode3;
                yVar4 = yVar2;
                mamiEngine3.check();
                AnonymousClass10 anonymousClass12 = new AnonymousClass10(yVar3, null);
                c06062.L$0 = mamiEngine3;
                c06062.L$1 = mode4;
                c06062.L$2 = yVar3;
                c06062.L$3 = yVar4;
                c06062.label = 4;
                objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass12, c06062);
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectCatalog$lambda$44(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "session", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectCatalog$lambda$45(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "catalog", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectCatalog$lambda$51(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "scout", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:37:0x0101  */
    /* JADX WARN: Code duplicated, block: B:38:0x0104  */
    /* JADX WARN: Code duplicated, block: B:42:0x013c  */
    /* JADX WARN: Code duplicated, block: B:45:0x014e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:55:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01d5, code lost:
    
        if (r3.tryServers(r1, r5, null, false, r8) == r2) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connectExclusive(Mode mode, wd.d dVar) throws Throwable {
        C06071 c06071;
        MamiEngine mamiEngine;
        Mode mode2;
        MamiEngine mamiEngine2;
        MamiExclusive.Bridge bridge;
        Object objJ;
        MamiExclusive.Bridge bridge2;
        Mode mode3;
        MamiExclusive.Endpoint endpointEndpointFor;
        String str;
        MamiExclusive.Endpoint endpoint;
        Mode mode4;
        MamiEngine mamiEngine3;
        ArgoNet.Auth auth;
        String strH;
        if (dVar instanceof C06071) {
            c06071 = (C06071) dVar;
            int i = c06071.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06071.label = i - TLObject.FLAG_31;
            } else {
                c06071 = new C06071(dVar);
            }
        } else {
            c06071 = new C06071(dVar);
        }
        C06071 c06072 = c06071;
        Object objJ2 = c06072.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06072.label;
        if (i10 == 0) {
            m.b(objJ2);
            setStatus(new f(16));
            oe.e eVar = v0.f24208c;
            C06083 c06083 = new C06083(null);
            c06072.L$0 = this;
            c06072.L$1 = mode;
            c06072.label = 1;
            if (m0.J(eVar, c06083, c06072) != aVar) {
                mamiEngine = this;
                mode2 = mode;
            }
            return aVar;
        }
        if (i10 == 1) {
            mode2 = (Mode) c06072.L$1;
            mamiEngine = (MamiEngine) c06072.L$0;
            m.b(objJ2);
        } else {
            if (i10 == 2) {
                mode2 = (Mode) c06072.L$1;
                mamiEngine2 = (MamiEngine) c06072.L$0;
                m.b(objJ2);
                bridge = (MamiExclusive.Bridge) objJ2;
                mamiEngine2.check();
                oe.e eVar2 = v0.f24208c;
                MamiEngine$connectExclusive$template$1 mamiEngine$connectExclusive$template$1 = new MamiEngine$connectExclusive$template$1(null);
                c06072.L$0 = mamiEngine2;
                c06072.L$1 = mode2;
                c06072.L$2 = bridge;
                c06072.label = 3;
                objJ = m0.J(eVar2, mamiEngine$connectExclusive$template$1, c06072);
                if (objJ != aVar) {
                    Mode mode5 = mode2;
                    bridge2 = bridge;
                    objJ2 = objJ;
                    mode3 = mode5;
                    endpointEndpointFor = MamiExclusive.INSTANCE.endpointFor(bridge2, (MamiExclusive.Template) objJ2);
                    mamiEngine2.check();
                    if (kotlin.jvm.internal.j.a(endpointEndpointFor.getProtocol(), "B")) {
                        str = "gRPC";
                    } else {
                        str = "WebSocket";
                    }
                    mamiEngine2.setStatus(new g(1, str));
                    mamiEngine2.log("احراز هویت با پل اختصاصی (" + str + ")…");
                    oe.e eVar3 = v0.f24208c;
                    MamiEngine$connectExclusive$a$1 mamiEngine$connectExclusive$a$1 = new MamiEngine$connectExclusive$a$1(endpointEndpointFor, null);
                    c06072.L$0 = mamiEngine2;
                    c06072.L$1 = mode3;
                    c06072.L$2 = endpointEndpointFor;
                    c06072.label = 4;
                    objJ2 = m0.J(eVar3, mamiEngine$connectExclusive$a$1, c06072);
                    if (objJ2 != aVar) {
                        endpoint = endpointEndpointFor;
                        mode4 = mode3;
                        mamiEngine3 = mamiEngine2;
                        auth = (ArgoNet.Auth) objJ2;
                        mamiEngine3.check();
                        ArgoProtocol.SessionInfo info = auth.getInfo();
                        if (auth.getOk()) {
                        }
                        if (o.L0(auth.getError())) {
                            strH = "";
                        } else {
                            strH = v0.a.h(": ", mamiEngine3.unnamed$app_release(auth.getError(), "اختصاصی"));
                        }
                        throw new Fail("EXCLUSIVE_AUTH", v0.a.h("پل اختصاصی احراز هویت را نپذیرفت", strH));
                    }
                }
                return aVar;
            }
            if (i10 == 3) {
                bridge2 = (MamiExclusive.Bridge) c06072.L$2;
                mode3 = (Mode) c06072.L$1;
                mamiEngine2 = (MamiEngine) c06072.L$0;
                m.b(objJ2);
                endpointEndpointFor = MamiExclusive.INSTANCE.endpointFor(bridge2, (MamiExclusive.Template) objJ2);
                mamiEngine2.check();
                if (kotlin.jvm.internal.j.a(endpointEndpointFor.getProtocol(), "B")) {
                    str = "gRPC";
                } else {
                    str = "WebSocket";
                }
                mamiEngine2.setStatus(new g(1, str));
                mamiEngine2.log("احراز هویت با پل اختصاصی (" + str + ")…");
                oe.e eVar4 = v0.f24208c;
                MamiEngine$connectExclusive$a$1 mamiEngine$connectExclusive$a$2 = new MamiEngine$connectExclusive$a$1(endpointEndpointFor, null);
                c06072.L$0 = mamiEngine2;
                c06072.L$1 = mode3;
                c06072.L$2 = endpointEndpointFor;
                c06072.label = 4;
                objJ2 = m0.J(eVar4, mamiEngine$connectExclusive$a$2, c06072);
                if (objJ2 != aVar) {
                    endpoint = endpointEndpointFor;
                    mode4 = mode3;
                    mamiEngine3 = mamiEngine2;
                    auth = (ArgoNet.Auth) objJ2;
                    mamiEngine3.check();
                    ArgoProtocol.SessionInfo info2 = auth.getInfo();
                    if (auth.getOk()) {
                    }
                    if (o.L0(auth.getError())) {
                        strH = v0.a.h(": ", mamiEngine3.unnamed$app_release(auth.getError(), "اختصاصی"));
                    } else {
                        strH = "";
                    }
                    throw new Fail("EXCLUSIVE_AUTH", v0.a.h("پل اختصاصی احراز هویت را نپذیرفت", strH));
                }
                return aVar;
            }
            if (i10 == 4) {
                MamiExclusive.Endpoint endpoint2 = (MamiExclusive.Endpoint) c06072.L$2;
                mode4 = (Mode) c06072.L$1;
                MamiEngine mamiEngine4 = (MamiEngine) c06072.L$0;
                m.b(objJ2);
                endpoint = endpoint2;
                mamiEngine3 = mamiEngine4;
                auth = (ArgoNet.Auth) objJ2;
                mamiEngine3.check();
                ArgoProtocol.SessionInfo info3 = auth.getInfo();
                if (auth.getOk() || info3 == null) {
                    if (o.L0(auth.getError())) {
                        strH = v0.a.h(": ", mamiEngine3.unnamed$app_release(auth.getError(), "اختصاصی"));
                    } else {
                        strH = "";
                    }
                    throw new Fail("EXCLUSIVE_AUTH", v0.a.h("پل اختصاصی احراز هویت را نپذیرفت", strH));
                }
                sf.c cVar = new sf.c();
                cVar.D("uuid", info3.getUuid());
                cVar.D("token", info3.getToken());
                cVar.D("wsPath", info3.getWsPath());
                cVar.D("grpcServiceName", info3.getGrpcServiceName());
                Map<String, String> headers = info3.getHeaders();
                kotlin.jvm.internal.j.c(headers, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                cVar.D("headers", new sf.c(headers));
                MamiExclusive mamiExclusive = MamiExclusive.INSTANCE;
                sf.c cVarOutboundFor$default = MamiExclusive.outboundFor$default(mamiExclusive, endpoint, mamiExclusive.sessionInfo(cVar), null, null, 12, null);
                exclusiveLive = new ExclusiveLive(endpoint.getHostName(), endpoint.getPort(), info3);
                List<Cand> listB = m9.d.B(new Cand("exclusive", null, cVarOutboundFor$default, "", "پل اختصاصی", "", "exclusive", "vmess", "EXC"));
                c06072.L$0 = null;
                c06072.L$1 = null;
                c06072.L$2 = null;
                c06072.label = 5;
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(objJ2);
            }
        }
        return u.f67154a;
        mamiEngine.check();
        mamiEngine.setStatus(new f(17));
        oe.e eVar5 = v0.f24208c;
        MamiEngine$connectExclusive$bridge$1 mamiEngine$connectExclusive$bridge$1 = new MamiEngine$connectExclusive$bridge$1(null);
        c06072.L$0 = mamiEngine;
        c06072.L$1 = mode2;
        c06072.label = 2;
        objJ2 = m0.J(eVar5, mamiEngine$connectExclusive$bridge$1, c06072);
        if (objJ2 != aVar) {
            mamiEngine2 = mamiEngine;
            bridge = (MamiExclusive.Bridge) objJ2;
            mamiEngine2.check();
            oe.e eVar6 = v0.f24208c;
            MamiEngine$connectExclusive$template$1 mamiEngine$connectExclusive$template$2 = new MamiEngine$connectExclusive$template$1(null);
            c06072.L$0 = mamiEngine2;
            c06072.L$1 = mode2;
            c06072.L$2 = bridge;
            c06072.label = 3;
            objJ = m0.J(eVar6, mamiEngine$connectExclusive$template$2, c06072);
            if (objJ != aVar) {
                Mode mode6 = mode2;
                bridge2 = bridge;
                objJ2 = objJ;
                mode3 = mode6;
                endpointEndpointFor = MamiExclusive.INSTANCE.endpointFor(bridge2, (MamiExclusive.Template) objJ2);
                mamiEngine2.check();
                if (kotlin.jvm.internal.j.a(endpointEndpointFor.getProtocol(), "B")) {
                    str = "gRPC";
                } else {
                    str = "WebSocket";
                }
                mamiEngine2.setStatus(new g(1, str));
                mamiEngine2.log("احراز هویت با پل اختصاصی (" + str + ")…");
                oe.e eVar7 = v0.f24208c;
                MamiEngine$connectExclusive$a$1 mamiEngine$connectExclusive$a$3 = new MamiEngine$connectExclusive$a$1(endpointEndpointFor, null);
                c06072.L$0 = mamiEngine2;
                c06072.L$1 = mode3;
                c06072.L$2 = endpointEndpointFor;
                c06072.label = 4;
                objJ2 = m0.J(eVar7, mamiEngine$connectExclusive$a$3, c06072);
                if (objJ2 != aVar) {
                    endpoint = endpointEndpointFor;
                    mode4 = mode3;
                    mamiEngine3 = mamiEngine2;
                    auth = (ArgoNet.Auth) objJ2;
                    mamiEngine3.check();
                    ArgoProtocol.SessionInfo info4 = auth.getInfo();
                    if (auth.getOk()) {
                    }
                    if (o.L0(auth.getError())) {
                        strH = v0.a.h(": ", mamiEngine3.unnamed$app_release(auth.getError(), "اختصاصی"));
                    } else {
                        strH = "";
                    }
                    throw new Fail("EXCLUSIVE_AUTH", v0.a.h("پل اختصاصی احراز هویت را نپذیرفت", strH));
                }
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectExclusive$lambda$67(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "session", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectExclusive$lambda$68(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "bridge", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectExclusive$lambda$69(String str, Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "auth", null, new ServerRef("exclusive", "", "پل اختصاصی", "", str, "EXC", 0L), null, null, 0L, 0L, 0, null, 2027, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:112:0x0258 A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:121:0x029f A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:123:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:124:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:131:0x0325  */
    /* JADX WARN: Code duplicated, block: B:134:0x032b A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:137:0x034d A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0352  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x014a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0153 A[Catch: all -> 0x00ba, TryCatch #3 {all -> 0x00ba, blocks: (B:28:0x00b4, B:55:0x014b, B:57:0x0153, B:59:0x0159, B:66:0x016a, B:67:0x0182, B:75:0x019b, B:62:0x0161, B:63:0x0166), top: B:156:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0159 A[Catch: all -> 0x00ba, TryCatch #3 {all -> 0x00ba, blocks: (B:28:0x00b4, B:55:0x014b, B:57:0x0153, B:59:0x0159, B:66:0x016a, B:67:0x0182, B:75:0x019b, B:62:0x0161, B:63:0x0166), top: B:156:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x015f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0161 A[Catch: all -> 0x00ba, TryCatch #3 {all -> 0x00ba, blocks: (B:28:0x00b4, B:55:0x014b, B:57:0x0153, B:59:0x0159, B:66:0x016a, B:67:0x0182, B:75:0x019b, B:62:0x0161, B:63:0x0166), top: B:156:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0167  */
    /* JADX WARN: Code duplicated, block: B:66:0x016a A[Catch: all -> 0x00ba, TryCatch #3 {all -> 0x00ba, blocks: (B:28:0x00b4, B:55:0x014b, B:57:0x0153, B:59:0x0159, B:66:0x016a, B:67:0x0182, B:75:0x019b, B:62:0x0161, B:63:0x0166), top: B:156:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x018a  */
    /* JADX WARN: Code duplicated, block: B:70:0x018e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0195  */
    /* JADX WARN: Code duplicated, block: B:74:0x0199  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:82:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x01d5 A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01df A[Catch: all -> 0x01fe, TryCatch #6 {all -> 0x01fe, blocks: (B:132:0x0327, B:134:0x032b, B:135:0x0330, B:137:0x034d, B:139:0x0353, B:125:0x02cd, B:77:0x01b0, B:90:0x01eb, B:94:0x01f7, B:99:0x0202, B:101:0x020e, B:106:0x0218, B:109:0x0237, B:110:0x0255, B:112:0x0258, B:116:0x0262, B:118:0x026a, B:121:0x029f, B:126:0x02da, B:127:0x02fb, B:85:0x01d5, B:87:0x01df, B:128:0x02fc), top: B:161:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x02c7 -> B:24:0x0096). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object connectFront(com.mlmvpn.scanner.engines.mami.MamiEngine.Method r24, com.mlmvpn.scanner.engines.mami.MamiEngine.Mode r25, wd.d r26) {
        /*
            Method dump skipped, instruction units count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mlmvpn.scanner.engines.mami.MamiEngine.connectFront(com.mlmvpn.scanner.engines.mami.MamiEngine$Method, com.mlmvpn.scanner.engines.mami.MamiEngine$Mode, wd.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectFront$lambda$74(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "engine", Mode.TUNNEL, null, null, null, 0L, 0L, 0, null, 2035, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectFront$lambda$77(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "verify", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectFront$lambda$78(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "route", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:? A[LOOP:4: B:49:0x013c->B:103:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x015f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[PHI: r1 r3 r4 r5
      0x0053: PHI (r1v23 java.lang.Object) = (r1v22 java.lang.Object), (r1v1 java.lang.Object) binds: [B:65:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r3v21 kotlin.jvm.internal.y) = (r3v20 kotlin.jvm.internal.y), (r3v32 kotlin.jvm.internal.y) binds: [B:65:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r4v16 com.mlmvpn.scanner.engines.mami.MamiEngine$Mode) = (r4v15 com.mlmvpn.scanner.engines.mami.MamiEngine$Mode), (r4v23 com.mlmvpn.scanner.engines.mami.MamiEngine$Mode) binds: [B:65:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r5v8 com.mlmvpn.scanner.engines.mami.MamiEngine) = (r5v7 com.mlmvpn.scanner.engines.mami.MamiEngine), (r5v17 com.mlmvpn.scanner.engines.mami.MamiEngine) binds: [B:65:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:37:0x0109  */
    /* JADX WARN: Code duplicated, block: B:41:0x0117  */
    /* JADX WARN: Code duplicated, block: B:43:0x0126  */
    /* JADX WARN: Code duplicated, block: B:48:0x0138  */
    /* JADX WARN: Code duplicated, block: B:51:0x0142  */
    /* JADX WARN: Code duplicated, block: B:56:0x0165  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x0203 A[LOOP:1: B:74:0x01fd->B:76:0x0203, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0217  */
    /* JADX WARN: Code duplicated, block: B:81:0x0227 A[LOOP:2: B:80:0x0225->B:81:0x0227, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x024f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0268  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0249, code lost:
    
        if (r17.tryServers(r4, r5, null, false, r7) == r2) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connectHive(Mode mode, List<String> list, wd.d dVar) throws Throwable {
        C06111 c06111;
        Mode mode2;
        List<String> list2;
        MamiEngine mamiEngine;
        Mode mode3;
        y yVar;
        ArrayList arrayList;
        Set setP1;
        MamiEngine mamiEngine2;
        Object objScout$default;
        MamiEngine mamiEngine3;
        y yVar2;
        Mode mode4;
        Iterable iterable;
        Iterator it;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Iterator it2;
        ArrayList arrayList5;
        int size;
        if (dVar instanceof C06111) {
            c06111 = (C06111) dVar;
            int i = c06111.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06111.label = i - TLObject.FLAG_31;
            } else {
                c06111 = new C06111(dVar);
            }
        } else {
            c06111 = new C06111(dVar);
        }
        C06111 c06112 = c06111;
        Object objJ = c06112.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06112.label;
        int i11 = 0;
        if (i10 == 0) {
            m.b(objJ);
            setStatus(new f(13));
            oe.e eVar = v0.f24208c;
            C06123 c06123 = new C06123(null);
            c06112.L$0 = this;
            c06112.L$1 = mode;
            c06112.L$2 = list;
            c06112.label = 1;
            if (m0.J(eVar, c06123, c06112) != aVar) {
                mode2 = mode;
                list2 = list;
                mamiEngine = this;
            }
            return aVar;
        }
        if (i10 == 1) {
            list2 = (List) c06112.L$2;
            mode2 = (Mode) c06112.L$1;
            mamiEngine = (MamiEngine) c06112.L$0;
            m.b(objJ);
        } else {
            if (i10 == 2) {
                list2 = (List) c06112.L$2;
                mode2 = (Mode) c06112.L$1;
                mamiEngine = (MamiEngine) c06112.L$0;
                m.b(objJ);
                mode3 = mode2;
                mamiEngine.check();
                yVar = new y();
                List<MamiCatalog.Server> servers = ((MamiCatalog.Hive) objJ).getServers();
                arrayList = new ArrayList();
                for (Object obj : servers) {
                    if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) obj, false, 2, null) == null) {
                        arrayList.add(obj);
                    }
                }
                yVar.element = arrayList;
                if (!arrayList.isEmpty()) {
                    throw new Fail("HIVE_NO_SERVERS", "لیون فعلاً پلی برای این دستگاه ندارد");
                }
                setP1 = q.p1(list2);
                if (!setP1.isEmpty()) {
                    iterable = (Iterable) yVar.element;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        it = iterable.iterator();
                        while (it.hasNext()) {
                            if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                                Iterable iterable2 = (Iterable) yVar.element;
                                arrayList2 = new ArrayList();
                                for (Object obj2 : iterable2) {
                                    if (!setP1.contains(((MamiCatalog.Server) obj2).getId())) {
                                        arrayList2.add(obj2);
                                    }
                                }
                                yVar.element = arrayList2;
                                break;
                            }
                        }
                    }
                }
                mamiEngine.setStatus(new f(19));
                List list3 = (List) yVar.element;
                c06112.L$0 = mamiEngine;
                c06112.L$1 = mode3;
                c06112.L$2 = yVar;
                c06112.label = 3;
                mamiEngine2 = mamiEngine;
                objScout$default = scout$default(mamiEngine2, list3, false, true, c06112, 2, null);
                if (objScout$default != aVar) {
                    mamiEngine3 = mamiEngine2;
                    yVar2 = yVar;
                    objJ = objScout$default;
                    mode4 = mode3;
                    mamiEngine3.check();
                    AnonymousClass8 anonymousClass8 = new AnonymousClass8(yVar2, null);
                    c06112.L$0 = mamiEngine3;
                    c06112.L$1 = mode4;
                    c06112.L$2 = yVar2;
                    c06112.label = 4;
                    objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass8, c06112);
                    if (objJ != aVar) {
                        MamiEngine mamiEngine4 = mamiEngine3;
                        Mode mode5 = mode4;
                        arrayList3 = new ArrayList();
                        for (Object obj3 : (List) objJ) {
                            if (((Ranked) obj3).getMs() > 0) {
                                arrayList3.add(obj3);
                            }
                        }
                        List listE1 = q.e1(arrayList3, 3);
                        arrayList4 = new ArrayList(kotlin.collections.s.g0(listE1, 10));
                        it2 = listE1.iterator();
                        while (it2.hasNext()) {
                            arrayList4.add(((Ranked) it2.next()).getServer());
                        }
                        if (!arrayList4.isEmpty()) {
                            throw new Fail("HIVE_UNREACHABLE", androidx.compose.foundation.interaction.f.o(((List) yVar2.element).size(), "هیچ\u200cکدام از ", " پل لیون جواب نداد"));
                        }
                        arrayList5 = new ArrayList(kotlin.collections.s.g0(arrayList4, 10));
                        size = arrayList4.size();
                        while (i11 < size) {
                            Object obj4 = arrayList4.get(i11);
                            i11++;
                            arrayList5.add(INSTANCE.candOf((MamiCatalog.Server) obj4, null));
                        }
                        c06112.L$0 = null;
                        c06112.L$1 = null;
                        c06112.L$2 = null;
                        c06112.label = 5;
                    }
                }
                return aVar;
            }
            if (i10 == 3) {
                yVar2 = (y) c06112.L$2;
                mode4 = (Mode) c06112.L$1;
                mamiEngine3 = (MamiEngine) c06112.L$0;
                m.b(objJ);
                mamiEngine3.check();
                AnonymousClass8 anonymousClass9 = new AnonymousClass8(yVar2, null);
                c06112.L$0 = mamiEngine3;
                c06112.L$1 = mode4;
                c06112.L$2 = yVar2;
                c06112.label = 4;
                objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass9, c06112);
                if (objJ != aVar) {
                    MamiEngine mamiEngine5 = mamiEngine3;
                    Mode mode6 = mode4;
                    arrayList3 = new ArrayList();
                    while (r1.hasNext()) {
                        if (((Ranked) obj3).getMs() > 0) {
                            arrayList3.add(obj3);
                        }
                    }
                    List listE2 = q.e1(arrayList3, 3);
                    arrayList4 = new ArrayList(kotlin.collections.s.g0(listE2, 10));
                    it2 = listE2.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(((Ranked) it2.next()).getServer());
                    }
                    if (!arrayList4.isEmpty()) {
                        throw new Fail("HIVE_UNREACHABLE", androidx.compose.foundation.interaction.f.o(((List) yVar2.element).size(), "هیچ\u200cکدام از ", " پل لیون جواب نداد"));
                    }
                    arrayList5 = new ArrayList(kotlin.collections.s.g0(arrayList4, 10));
                    size = arrayList4.size();
                    while (i11 < size) {
                        Object obj5 = arrayList4.get(i11);
                        i11++;
                        arrayList5.add(INSTANCE.candOf((MamiCatalog.Server) obj5, null));
                    }
                    c06112.L$0 = null;
                    c06112.L$1 = null;
                    c06112.L$2 = null;
                    c06112.label = 5;
                }
                return aVar;
            }
            if (i10 == 4) {
                yVar2 = (y) c06112.L$2;
                mode4 = (Mode) c06112.L$1;
                mamiEngine3 = (MamiEngine) c06112.L$0;
                m.b(objJ);
                MamiEngine mamiEngine6 = mamiEngine3;
                Mode mode7 = mode4;
                arrayList3 = new ArrayList();
                while (r1.hasNext()) {
                    if (((Ranked) obj3).getMs() > 0) {
                        arrayList3.add(obj3);
                    }
                }
                List listE3 = q.e1(arrayList3, 3);
                arrayList4 = new ArrayList(kotlin.collections.s.g0(listE3, 10));
                it2 = listE3.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(((Ranked) it2.next()).getServer());
                }
                if (!arrayList4.isEmpty()) {
                    throw new Fail("HIVE_UNREACHABLE", androidx.compose.foundation.interaction.f.o(((List) yVar2.element).size(), "هیچ\u200cکدام از ", " پل لیون جواب نداد"));
                }
                arrayList5 = new ArrayList(kotlin.collections.s.g0(arrayList4, 10));
                size = arrayList4.size();
                while (i11 < size) {
                    Object obj6 = arrayList4.get(i11);
                    i11++;
                    arrayList5.add(INSTANCE.candOf((MamiCatalog.Server) obj6, null));
                }
                c06112.L$0 = null;
                c06112.L$1 = null;
                c06112.L$2 = null;
                c06112.label = 5;
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(objJ);
            }
        }
        return u.f67154a;
        mamiEngine.check();
        mamiEngine.setStatus(new f(18));
        oe.e eVar2 = v0.f24208c;
        MamiEngine$connectHive$parsed$1 mamiEngine$connectHive$parsed$1 = new MamiEngine$connectHive$parsed$1(null);
        c06112.L$0 = mamiEngine;
        c06112.L$1 = mode2;
        c06112.L$2 = list2;
        c06112.label = 2;
        objJ = m0.J(eVar2, mamiEngine$connectHive$parsed$1, c06112);
        if (objJ != aVar) {
            mode3 = mode2;
            mamiEngine.check();
            yVar = new y();
            List<MamiCatalog.Server> servers2 = ((MamiCatalog.Hive) objJ).getServers();
            arrayList = new ArrayList();
            while (r1.hasNext()) {
                if (MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, (MamiCatalog.Server) obj, false, 2, null) == null) {
                    arrayList.add(obj);
                }
            }
            yVar.element = arrayList;
            if (!arrayList.isEmpty()) {
                throw new Fail("HIVE_NO_SERVERS", "لیون فعلاً پلی برای این دستگاه ندارد");
            }
            setP1 = q.p1(list2);
            if (!setP1.isEmpty()) {
                iterable = (Iterable) yVar.element;
                if (!(iterable instanceof Collection)) {
                    it = iterable.iterator();
                    while (it.hasNext()) {
                        if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                            Iterable iterable3 = (Iterable) yVar.element;
                            arrayList2 = new ArrayList();
                            while (r3.hasNext()) {
                                if (!setP1.contains(((MamiCatalog.Server) obj2).getId())) {
                                    arrayList2.add(obj2);
                                }
                            }
                            yVar.element = arrayList2;
                            break;
                        }
                    }
                } else {
                    it = iterable.iterator();
                    while (it.hasNext()) {
                        if (!setP1.contains(((MamiCatalog.Server) it.next()).getId())) {
                            Iterable iterable4 = (Iterable) yVar.element;
                            arrayList2 = new ArrayList();
                            while (r3.hasNext()) {
                                if (!setP1.contains(((MamiCatalog.Server) obj2).getId())) {
                                    arrayList2.add(obj2);
                                }
                            }
                            yVar.element = arrayList2;
                            break;
                        }
                    }
                }
            }
            mamiEngine.setStatus(new f(19));
            List list4 = (List) yVar.element;
            c06112.L$0 = mamiEngine;
            c06112.L$1 = mode3;
            c06112.L$2 = yVar;
            c06112.label = 3;
            mamiEngine2 = mamiEngine;
            objScout$default = scout$default(mamiEngine2, list4, false, true, c06112, 2, null);
            if (objScout$default != aVar) {
                mamiEngine3 = mamiEngine2;
                yVar2 = yVar;
                objJ = objScout$default;
                mode4 = mode3;
                mamiEngine3.check();
                AnonymousClass8 anonymousClass10 = new AnonymousClass8(yVar2, null);
                c06112.L$0 = mamiEngine3;
                c06112.L$1 = mode4;
                c06112.L$2 = yVar2;
                c06112.label = 4;
                objJ = mamiEngine3.settleAfterRegister((List) objJ, anonymousClass10, c06112);
                if (objJ != aVar) {
                    MamiEngine mamiEngine7 = mamiEngine3;
                    Mode mode8 = mode4;
                    arrayList3 = new ArrayList();
                    while (r1.hasNext()) {
                        if (((Ranked) obj3).getMs() > 0) {
                            arrayList3.add(obj3);
                        }
                    }
                    List listE4 = q.e1(arrayList3, 3);
                    arrayList4 = new ArrayList(kotlin.collections.s.g0(listE4, 10));
                    it2 = listE4.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(((Ranked) it2.next()).getServer());
                    }
                    if (!arrayList4.isEmpty()) {
                        throw new Fail("HIVE_UNREACHABLE", androidx.compose.foundation.interaction.f.o(((List) yVar2.element).size(), "هیچ\u200cکدام از ", " پل لیون جواب نداد"));
                    }
                    arrayList5 = new ArrayList(kotlin.collections.s.g0(arrayList4, 10));
                    size = arrayList4.size();
                    while (i11 < size) {
                        Object obj7 = arrayList4.get(i11);
                        i11++;
                        arrayList5.add(INSTANCE.candOf((MamiCatalog.Server) obj7, null));
                    }
                    c06112.L$0 = null;
                    c06112.L$1 = null;
                    c06112.L$2 = null;
                    c06112.label = 5;
                }
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectHive$lambda$58(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "session", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectHive$lambda$59(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "hive", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connectHive$lambda$63(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "scout", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    private final void connected(Exit exit) {
        String strH;
        String strN;
        setStatus(new h(exit, 1));
        Live live2 = live;
        if (kotlin.jvm.internal.j.a(live2 != null ? live2.getKind() : null, "xray")) {
            Live live3 = live;
            if ((live3 != null ? live3.getMode() : null) == Mode.PROXY) {
                LocalPort localPort = LocalPort.INSTANCE;
                Context context = app;
                if (context == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                strH = f0.a.h(localPort.get(context), " — فقط پراکسی محلی 127.0.0.1:");
            } else {
                strH = "";
            }
        } else {
            strH = "";
        }
        if (exit != null) {
            StringBuilder sbN = s.n("وصل شد", !o.L0(exit.getLoc()) ? v0.a.h(" — خروج از ", exit.getLoc()) : "", !o.L0(exit.getIp()) ? w0.n(" (", exit.getIp(), ")") : "", exit.getMs() > 0 ? androidx.compose.foundation.interaction.f.p(exit.getMs(), "، ", " میلی\u200cثانیه") : "", strH);
            sbN.append(".");
            strN = sbN.toString();
        } else {
            strN = w0.n("وصل شد", strH, ".");
        }
        log(strN);
        bump();
        startWatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status connected$lambda$80(Exit exit, Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, "on", null, "", null, null, exit, null, 0L, System.currentTimeMillis(), 0, null, 1690, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u disconnectAsync$lambda$81(Context context) throws IOException {
        INSTANCE.init(context);
        cancelled = true;
        s1 s1Var = connectJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        s1 s1Var2 = watchJob;
        if (s1Var2 != null) {
            s1Var2.cancel(null);
        }
        m0.y(scope, null, null, new MamiEngine$disconnectAsync$1$1(null), 3);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0117  */
    /* JADX WARN: Code duplicated, block: B:63:0x011a  */
    /* JADX WARN: Code duplicated, block: B:66:0x013c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object disconnectNow(String str, wd.d dVar) {
        C06131 c06131;
        Live live2;
        Status status2;
        MamiEngine mamiEngine;
        String str2;
        Status status3;
        String kind;
        String kind2;
        String str3;
        if (dVar instanceof C06131) {
            c06131 = (C06131) dVar;
            int i = c06131.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06131.label = i - TLObject.FLAG_31;
            } else {
                c06131 = new C06131(dVar);
            }
        } else {
            c06131 = new C06131(dVar);
        }
        Object obj = c06131.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06131.label;
        if (i10 == 0) {
            m.b(obj);
            cancelled = true;
            s1 s1Var = watchJob;
            if (s1Var != null) {
                s1Var.cancel(null);
            }
            live2 = live;
            status2 = (Status) ((g1) _status).getValue();
            if (!kotlin.jvm.internal.j.a(status2.getPhase(), "off")) {
                setStatus(new f(20));
            }
            ExclusiveLive exclusiveLive2 = exclusiveLive;
            if (kotlin.jvm.internal.j.a(live2 != null ? live2.getKind() : null, "xray")) {
                Cand cand = live2.getCand();
                if (kotlin.jvm.internal.j.a(cand != null ? cand.getId() : null, "exclusive") && exclusiveLive2 != null && isOurs()) {
                    oe.e eVar = v0.f24208c;
                    C06143 c06143 = new C06143(exclusiveLive2, null);
                    c06131.L$0 = this;
                    c06131.L$1 = str;
                    c06131.L$2 = live2;
                    c06131.L$3 = status2;
                    c06131.label = 1;
                    if (m0.J(eVar, c06143, c06131) == aVar) {
                        return aVar;
                    }
                    mamiEngine = this;
                    status3 = status2;
                    str2 = str;
                }
                exclusiveLive = null;
                if (live2 != null) {
                    kind = live2.getKind();
                } else {
                    kind = null;
                }
                if (kotlin.jvm.internal.j.a(kind, WarpIdRelay.VIA_FRONT)) {
                    mamiEngine.stopFront();
                } else {
                    if (live2 != null) {
                        kind2 = live2.getKind();
                    } else {
                        kind2 = null;
                    }
                    if (kotlin.jvm.internal.j.a(kind2, "xray") || kotlin.jvm.internal.j.a(status2.getPhase(), TunnelVpnService.STATUS_CONNECTING)) {
                        mamiEngine.stopService();
                        if (live2 == null && frontMarker != null) {
                            mamiEngine.stopFront();
                        }
                    }
                }
                live = null;
                frontMarker = null;
                g1 g1Var = (g1) _status;
                Status status4 = (Status) g1Var.getValue();
                if (kotlin.jvm.internal.j.a(str2, "switch")) {
                    str3 = null;
                } else {
                    str3 = str2;
                }
                g1Var.j(Status.copy$default(status4, "off", null, "", null, null, null, null, 0L, 0L, 0, str3, 986, null));
                if (!kotlin.jvm.internal.j.a(str2, "switch")) {
                    mamiEngine.log("مامی قطع شد.");
                }
                mamiEngine.bump();
                return u.f67154a;
            }
            mamiEngine = this;
            str2 = str;
            exclusiveLive = null;
            if (live2 != null) {
                kind = live2.getKind();
            } else {
                kind = null;
            }
            if (kotlin.jvm.internal.j.a(kind, WarpIdRelay.VIA_FRONT)) {
                mamiEngine.stopFront();
            } else {
                if (live2 != null) {
                    kind2 = live2.getKind();
                } else {
                    kind2 = null;
                }
                if (kotlin.jvm.internal.j.a(kind2, "xray")) {
                    mamiEngine.stopService();
                    if (live2 == null) {
                        mamiEngine.stopFront();
                    }
                } else {
                    mamiEngine.stopService();
                    if (live2 == null) {
                        mamiEngine.stopFront();
                    }
                }
            }
            live = null;
            frontMarker = null;
            g1 g1Var2 = (g1) _status;
            Status status5 = (Status) g1Var2.getValue();
            if (kotlin.jvm.internal.j.a(str2, "switch")) {
                str3 = null;
            } else {
                str3 = str2;
            }
            g1Var2.j(Status.copy$default(status5, "off", null, "", null, null, null, null, 0L, 0L, 0, str3, 986, null));
            if (!kotlin.jvm.internal.j.a(str2, "switch")) {
                mamiEngine.log("مامی قطع شد.");
            }
            mamiEngine.bump();
            return u.f67154a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        status3 = (Status) c06131.L$3;
        live2 = (Live) c06131.L$2;
        str2 = (String) c06131.L$1;
        mamiEngine = (MamiEngine) c06131.L$0;
        m.b(obj);
        status2 = status3;
        exclusiveLive = null;
        if (live2 != null) {
            kind = live2.getKind();
        } else {
            kind = null;
        }
        if (kotlin.jvm.internal.j.a(kind, WarpIdRelay.VIA_FRONT)) {
            mamiEngine.stopFront();
        } else {
            if (live2 != null) {
                kind2 = live2.getKind();
            } else {
                kind2 = null;
            }
            if (kotlin.jvm.internal.j.a(kind2, "xray")) {
                mamiEngine.stopService();
                if (live2 == null) {
                    mamiEngine.stopFront();
                }
            } else {
                mamiEngine.stopService();
                if (live2 == null) {
                    mamiEngine.stopFront();
                }
            }
        }
        live = null;
        frontMarker = null;
        g1 g1Var3 = (g1) _status;
        Status status6 = (Status) g1Var3.getValue();
        if (kotlin.jvm.internal.j.a(str2, "switch")) {
            str3 = null;
        } else {
            str3 = str2;
        }
        g1Var3.j(Status.copy$default(status6, "off", null, "", null, null, null, null, 0L, 0L, 0, str3, 986, null));
        if (!kotlin.jvm.internal.j.a(str2, "switch")) {
            mamiEngine.log("مامی قطع شد.");
        }
        mamiEngine.bump();
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status disconnectNow$lambda$82(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, "stopping", null, null, null, null, null, null, 0L, 0L, 0, null, 2046, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean frontUp() {
        return TunnelStatus.INSTANCE.isActive() || ((TunnelUiState) TunnelController.INSTANCE.getState().getValue()).getStage() == TunnelStage.RUNNING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MamiCatalog.Hive hiveNow(boolean z10) throws MamiApi.ApiException {
        Object objM1004constructorimpl;
        try {
            objM1004constructorimpl = l.m1004constructorimpl(MamiApi.INSTANCE.savedHive());
        } catch (Throwable th2) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
        }
        if (l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = null;
        }
        sf.c cVar = (sf.c) objM1004constructorimpl;
        boolean z11 = (cVar != null ? cVar.w("payload") : null) != null && System.currentTimeMillis() - cVar.x(0L, "fetchedAt") < 3600000;
        if (z10 || !z11) {
            try {
                MamiApi.INSTANCE.fetchHive(ScoutScore.CONNECT);
            } catch (MamiApi.ApiException e10) {
                if ((cVar != null ? cVar.w("payload") : null) == null || kotlin.jvm.internal.j.a(e10.getCode(), "hive-off")) {
                    throw e10;
                }
                log("فهرست تازهٔ لیون گرفته نشد (" + e10.getMessage() + ") — همان فهرست ذخیره\u200cشده به کار می\u200cرود.");
            }
            bump();
        }
        MamiCatalog.Hive hive = parsedHive();
        if (hive != null) {
            return hive;
        }
        throw new IllegalStateException("فهرست پل\u200cهای لیون خوانده نشد");
    }

    public static /* synthetic */ MamiCatalog.Hive hiveNow$default(MamiEngine mamiEngine, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        return mamiEngine.hiveNow(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u init$lambda$2(String it) {
        kotlin.jvm.internal.j.e(it, "it");
        INSTANCE.log(it);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j init$lambda$3() {
        return INSTANCE.networkNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MamiNet.Route init$lambda$4() {
        return INSTANCE.routeNow();
    }

    private final String lang() {
        return StoreNetKt.tr(GerehLocale.FA, GerehLocale.EN);
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
        C06151 c06151;
        if (dVar instanceof C06151) {
            c06151 = (C06151) dVar;
            int i = c06151.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06151.label = i - TLObject.FLAG_31;
            } else {
                c06151 = new C06151(dVar);
            }
        } else {
            c06151 = new C06151(dVar);
        }
        Object objL = c06151.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06151.label;
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
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
        Context context2 = app;
        if (context2 == null) {
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
        Intent intent = new Intent(context2, (Class<?>) MyVpnService.class);
        intent.putExtra("NODE_URI", str);
        intent.putExtra("MTU_PROFILE", NetworkSettings.Method.V2RAY.getId());
        intent.putExtra("NODE_ID", "mami");
        intent.putExtra("PROXY_MODE", mode == Mode.PROXY);
        LocalPort localPort = LocalPort.INSTANCE;
        Context context3 = app;
        if (context3 == null) {
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
        intent.putExtra("LOCAL_PORT", localPort.getString(context3));
        safeStart.service(context, intent);
        if (z10) {
            C06163 c06163 = new C06163(null);
            c06151.label = 1;
            if (m0.L(5000L, c06163, c06151) != aVar) {
            }
        }
        return aVar;
        MamiEngine$launch$phase$1 mamiEngine$launch$phase$1 = new MamiEngine$launch$phase$1(new kotlin.jvm.internal.u(), null);
        c06151.label = 2;
        objL = m0.L(GerehWatchdog.STUCK_MS, mamiEngine$launch$phase$1, c06151);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object measure(List<? extends j> list, String str, wd.d dVar) {
        return m0.i(new AnonymousClass2(list, str, null), dVar);
    }

    private final j networkNow() {
        Object objM1004constructorimpl;
        Object obj;
        j jVar;
        try {
            Context context = app;
            if (context == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
            Network[] allNetworks = connectivityManager.getAllNetworks();
            kotlin.jvm.internal.j.d(allNetworks, "getAllNetworks(...)");
            ArrayList arrayList = new ArrayList();
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null) {
                    arrayList.add(networkCapabilities);
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                NetworkCapabilities networkCapabilities2 = (NetworkCapabilities) obj;
                if (networkCapabilities2.hasCapability(12) && !networkCapabilities2.hasTransport(4)) {
                    break;
                }
            }
            NetworkCapabilities networkCapabilities3 = (NetworkCapabilities) obj;
            if (networkCapabilities3 == null || !networkCapabilities3.hasTransport(0)) {
                jVar = new j("wifi", "");
            } else {
                Context context2 = app;
                if (context2 == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService(TelephonyManager.class);
                String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
                if (networkOperator == null) {
                    networkOperator = "";
                }
                StringBuilder sb2 = new StringBuilder();
                int length = networkOperator.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = networkOperator.charAt(i10);
                    if (Character.isDigit(cCharAt)) {
                        sb2.append(cCharAt);
                    }
                }
                jVar = new j("cellular", sb2.toString());
            }
            objM1004constructorimpl = l.m1004constructorimpl(jVar);
            j jVar2 = new j("wifi", "");
            if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = jVar2;
            }
            return (j) objM1004constructorimpl;
        } catch (Throwable th2) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized MamiCatalog.Hive parsedHive() {
        Object objM1004constructorimpl;
        try {
            try {
                objM1004constructorimpl = l.m1004constructorimpl(MamiApi.INSTANCE.savedHive());
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
            MamiCatalog.Hive hive = null;
            if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = null;
            }
            sf.c cVar = (sf.c) objM1004constructorimpl;
            if (cVar == null) {
                return null;
            }
            sf.c cVarW = cVar.w("payload");
            if (cVarW == null) {
                return null;
            }
            String strValueOf = String.valueOf(cVar.x(0L, "fetchedAt"));
            j jVar = hiveCat;
            if (jVar != null && kotlin.jvm.internal.j.a(jVar.getFirst(), strValueOf)) {
                return (MamiCatalog.Hive) jVar.getSecond();
            }
            try {
                MamiCatalog.Hive hive2 = MamiCatalog.INSTANCE.parseHive(cVarW);
                hiveCat = new j(strValueOf, hive2);
                if (!hive2.getSkipped().isEmpty()) {
                    log(hive2.getSkipped().size() + " پل لیون کنار گذاشته شد: " + q.F0(q.e1(hive2.getSkipped(), 5), "، ", null, null, new f(21), 30));
                }
                hive = hive2;
            } catch (Exception e10) {
                log("فهرست لیون خوانده نشد: " + e10.getMessage());
            }
            return hive;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence parsedHive$lambda$23(MamiCatalog.Skipped it) {
        kotlin.jvm.internal.j.e(it, "it");
        return f0.a.m(it.getId(), " (", it.getWhy(), ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized MamiCatalog.Parsed parsedSaved() {
        Object objM1004constructorimpl;
        try {
            try {
                objM1004constructorimpl = l.m1004constructorimpl(MamiApi.INSTANCE.savedCatalog());
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
            MamiCatalog.Parsed parsed = null;
            if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = null;
            }
            sf.c cVar = (sf.c) objM1004constructorimpl;
            if (cVar == null) {
                return null;
            }
            sf.c cVarW = cVar.w("payload");
            if (cVarW == null) {
                return null;
            }
            String str = cVar.x(0L, "fetchedAt") + ":" + cVar.x(0L, "revision");
            j jVar = cat;
            if (jVar != null && kotlin.jvm.internal.j.a(jVar.getFirst(), str)) {
                return (MamiCatalog.Parsed) jVar.getSecond();
            }
            try {
                MamiCatalog.Parsed catalog = MamiCatalog.INSTANCE.parseCatalog(cVarW);
                cat = new j(str, catalog);
                if (!catalog.getSkipped().isEmpty()) {
                    log(catalog.getSkipped().size() + " سرور فهرست کنار گذاشته شد: " + q.F0(q.e1(catalog.getSkipped(), 5), "، ", null, null, new f(22), 30));
                }
                parsed = catalog;
            } catch (Exception e10) {
                log("فهرست ذخیره\u200cشده خوانده نشد: " + e10.getMessage());
            }
            return parsed;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence parsedSaved$lambda$20(MamiCatalog.Skipped it) {
        kotlin.jvm.internal.j.e(it, "it");
        return f0.a.m(it.getId(), " (", it.getWhy(), ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String placeLabel(Cand cand) {
        return !o.L0(cand.getCity()) ? f0.a.l(cand.getCountry(), " · ", cand.getCity()) : cand.getCountry();
    }

    private final MamiCatalog.Place placeOfLocation(MamiCatalog.Location location) {
        MamiCatalog.Names names = location.getNames();
        if (names != null) {
            MamiCatalog.Place en = names.get(INSTANCE.lang());
            if (en == null) {
                en = names.getEn();
            }
            if (en != null) {
                return en;
            }
        }
        return new MamiCatalog.Place(location.getCountry(), location.getCity());
    }

    private final j placeOfServer(MamiCatalog.Server server) {
        MamiCatalog.Place placePlaceOf = MamiCatalog.INSTANCE.placeOf(server, lang());
        return new j(placePlaceOf.getCountry(), placePlaceOf.getCity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Exit realExit(Exit exit) {
        String upperCase;
        String string;
        IpFormatter ipFormatter = IpFormatter.INSTANCE;
        if (ipFormatter.isRealCountry(exit.getLoc())) {
            return exit;
        }
        String country = ((TunnelUiState) TunnelController.INSTANCE.getState().getValue()).getCountry();
        if (country == null || (string = o.n1(country).toString()) == null) {
            upperCase = null;
        } else {
            upperCase = string.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.j.d(upperCase, "toUpperCase(...)");
        }
        if (upperCase == null) {
            upperCase = "";
        }
        return Exit.copy$default(exit, ipFormatter.isRealCountry(upperCase) ? upperCase : "", null, 0L, 6, null);
    }

    private final MamiNet.Route routeNow() {
        MyVpnService.Companion companion = MyVpnService.Companion;
        if (((g1) companion.getConnectionPhaseFlow()).getValue() != MyVpnService.Phase.CONNECTED) {
            TunnelStatus tunnelStatus = TunnelStatus.INSTANCE;
            if (!tunnelStatus.isActive() || tunnelStatus.getActiveSocksPort() <= 0) {
                return null;
            }
            return MamiNet.INSTANCE.socksRoute(tunnelStatus.getActiveSocksPort(), "موتور تونل برنامه");
        }
        MamiNet mamiNet = MamiNet.INSTANCE;
        LocalPort localPort = LocalPort.INSTANCE;
        Context context = app;
        if (context != null) {
            return mamiNet.socksRoute(localPort.get(context), kotlin.jvm.internal.j.a(((g1) companion.getConnectedNodeIdFlow()).getValue(), "mami") ? "خود مامی" : "موتور وصل برنامه");
        }
        kotlin.jvm.internal.j.k("app");
        throw null;
    }

    private final void saveRoute(j jVar) {
        SharedPreferences.Editor editorEdit = sp().edit();
        if (jVar == null) {
            editorEdit.remove("route");
        } else {
            sf.c cVar = new sf.c();
            cVar.D("profile", jVar.getFirst());
            cVar.D("locationId", jVar.getSecond());
            editorEdit.putString("route", cVar.toString());
        }
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:56:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:62:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:63:0x01df  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object scout(List<MamiCatalog.Server> list, boolean z10, boolean z11, wd.d dVar) {
        C06191 c06191;
        long j;
        ArrayList arrayList;
        MamiEngine mamiEngine;
        j jVar;
        ArrayList arrayList2;
        j jVar2;
        long jLongValue;
        long jHiveRank;
        List<MamiCatalog.Server> list2 = list;
        boolean z12 = z11;
        if (dVar instanceof C06191) {
            c06191 = (C06191) dVar;
            int i = c06191.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06191.label = i - TLObject.FLAG_31;
            } else {
                c06191 = new C06191(dVar);
            }
        } else {
            c06191 = new C06191(dVar);
        }
        Object objMeasure = c06191.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06191.label;
        long j10 = -1;
        if (i10 == 0) {
            m.b(objMeasure);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : list2) {
                MamiCatalog.Server server = (MamiCatalog.Server) obj;
                if (z10 || (jVar = delays.get(server.getId())) == null || jCurrentTimeMillis - ((Number) jVar.getSecond()).longValue() > 600000) {
                    arrayList3.add(obj);
                }
            }
            j = 0;
            List<MamiCatalog.Server> listE1 = q.e1(arrayList3, 24);
            if (!listE1.isEmpty()) {
                arrayList = new ArrayList();
                for (MamiCatalog.Server server2 : listE1) {
                    try {
                        arrayList.add(new j(server2.getId(), MamiXrayConfig.outboundFor$default(MamiXrayConfig.INSTANCE, server2, "mami-scout", false, 4, null)));
                    } catch (Exception unused) {
                        delays.put(server2.getId(), new j(new Long(j10), new Long(jCurrentTimeMillis)));
                        j10 = -1;
                    }
                }
                log("سنجش " + arrayList.size() + " سرور…");
                String str = z12 ? HIVE_PROBE : null;
                c06191.L$0 = this;
                c06191.L$1 = list2;
                c06191.L$2 = arrayList;
                c06191.Z$0 = z12;
                c06191.label = 1;
                objMeasure = measure(arrayList, str, c06191);
                if (objMeasure == aVar) {
                    return aVar;
                }
                mamiEngine = this;
            }
            List<MamiCatalog.Server> list3 = list2;
            arrayList2 = new ArrayList(kotlin.collections.s.g0(list3, 10));
            for (MamiCatalog.Server server3 : list3) {
                jVar2 = delays.get(server3.getId());
                if (jVar2 != null) {
                    jLongValue = ((Number) jVar2.getFirst()).longValue();
                } else {
                    jLongValue = -1;
                }
                if (z12) {
                    jHiveRank = MamiCatalog.INSTANCE.hiveRank(server3, jLongValue);
                } else if (jLongValue > j) {
                    jHiveRank = jLongValue;
                } else {
                    jHiveRank = Long.MAX_VALUE;
                }
                arrayList2.add(new Ranked(server3, jLongValue, jHiveRank));
            }
            return q.b1(arrayList2, new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$scout$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return p.e(Long.valueOf(((MamiEngine.Ranked) t10).getScore()), Long.valueOf(((MamiEngine.Ranked) t11).getScore()));
                }
            });
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z13 = c06191.Z$0;
        ArrayList arrayList4 = (ArrayList) c06191.L$2;
        List<MamiCatalog.Server> list4 = (List) c06191.L$1;
        mamiEngine = (MamiEngine) c06191.L$0;
        m.b(objMeasure);
        arrayList = arrayList4;
        j = 0;
        z12 = z13;
        list2 = list4;
        Map map = (Map) objMeasure;
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.j.d(it, "iterator(...)");
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.j.d(next, "next(...)");
            String str2 = (String) ((j) next).component1();
            Long l6 = (Long) map.get(str2);
            long jLongValue2 = l6 != null ? l6.longValue() : -1L;
            if (jLongValue2 > j) {
                i11++;
            }
            delays.put(str2, new j(new Long(jLongValue2), new Long(System.currentTimeMillis())));
        }
        mamiEngine.log(i11 + " سرور از " + arrayList.size() + " جواب داد.");
        mamiEngine.bump();
        List<MamiCatalog.Server> list5 = list2;
        arrayList2 = new ArrayList(kotlin.collections.s.g0(list5, 10));
        while (r1.hasNext()) {
            jVar2 = delays.get(server3.getId());
            if (jVar2 != null) {
                jLongValue = ((Number) jVar2.getFirst()).longValue();
            } else {
                jLongValue = -1;
            }
            if (z12) {
                jHiveRank = MamiCatalog.INSTANCE.hiveRank(server3, jLongValue);
            } else if (jLongValue > j) {
                jHiveRank = jLongValue;
            } else {
                jHiveRank = Long.MAX_VALUE;
            }
            arrayList2.add(new Ranked(server3, jLongValue, jHiveRank));
        }
        return q.b1(arrayList2, new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$scout$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return p.e(Long.valueOf(((MamiEngine.Ranked) t10).getScore()), Long.valueOf(((MamiEngine.Ranked) t11).getScore()));
            }
        });
    }

    public static /* synthetic */ Object scout$default(MamiEngine mamiEngine, List list, boolean z10, boolean z11, wd.d dVar, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        if ((i & 4) != 0) {
            z11 = false;
        }
        return mamiEngine.scout(list, z10, z11, dVar);
    }

    public static /* synthetic */ Prefs setPrefs$default(MamiEngine mamiEngine, String str, Mode mode, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            mode = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return mamiEngine.setPrefs(str, mode, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStatus(ee.c cVar) {
        k0 k0Var = _status;
        ((g1) k0Var).j(cVar.invoke(((g1) k0Var).getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:46:0x0123  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013c, code lost:
    
        if (r0 == r3) goto L49;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x00f0, please report this as an issue */
    /* JADX WARN: Path cross not found for [B:30:0x00aa, B:36:0x00c4], limit reached: 65 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x013c -> B:13:0x0043). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object settleAfterRegister(List<Ranked> list, ee.c cVar, wd.d dVar) {
        C06201 c06201;
        MamiEngine mamiEngine;
        Object objM1004constructorimpl;
        int i;
        C06201 c06202;
        MamiEngine mamiEngine2;
        long[] jArr;
        ee.c cVar2;
        int i10;
        List<Ranked> list2;
        long j;
        ee.c cVar3;
        int i11;
        long j10;
        if (dVar instanceof C06201) {
            c06201 = (C06201) dVar;
            int i12 = c06201.label;
            if ((i12 & TLObject.FLAG_31) != 0) {
                c06201.label = i12 - TLObject.FLAG_31;
                mamiEngine = this;
            } else {
                mamiEngine = this;
                c06201 = mamiEngine.new C06201(dVar);
            }
        } else {
            mamiEngine = this;
            c06201 = mamiEngine.new C06201(dVar);
        }
        Object objInvoke = c06201.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i13 = c06201.label;
        long j11 = 0;
        if (i13 == 0) {
            m.b(objInvoke);
            try {
                objM1004constructorimpl = l.m1004constructorimpl(new Long(MamiApi.INSTANCE.summary().getRegisteredAt()));
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
            Long l6 = new Long(0L);
            if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = l6;
            }
            long jLongValue = ((Number) objM1004constructorimpl).longValue();
            List<Ranked> list3 = list;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    if (((Ranked) it.next()).getMs() > 0) {
                        return list;
                    }
                }
            }
            if (jLongValue > 0 && System.currentTimeMillis() - jLongValue <= 120000) {
                i = 0;
                c06202 = c06201;
                mamiEngine2 = mamiEngine;
                jArr = new long[]{4000, 6000, SettingsSpotlight.FRESH_MS};
                cVar2 = cVar;
                i10 = 3;
                list2 = list;
                if (i < i10) {
                    j10 = jArr[i];
                    j = j11;
                    mamiEngine2.log("این دستگاه همین حالا ثبت شد؛ سرورها چند ثانیه طول می\u200cکشد تا آن را بشناسند — " + (j10 / ((long) 1000)) + " ثانیه دیگر دوباره سنجیده می\u200cشود…");
                    c06202.L$0 = mamiEngine2;
                    c06202.L$1 = cVar2;
                    c06202.L$2 = jArr;
                    c06202.I$0 = i;
                    c06202.I$1 = i10;
                    c06202.label = 1;
                    if (m0.j(j10, c06202) != aVar) {
                        int i14 = i;
                        cVar3 = cVar2;
                        c06201 = c06202;
                        i11 = i14;
                        mamiEngine2.check();
                        c06201.L$0 = mamiEngine2;
                        c06201.L$1 = cVar3;
                        c06201.L$2 = jArr;
                        c06201.I$0 = i11;
                        c06201.I$1 = i10;
                        c06201.label = 2;
                        objInvoke = cVar3.invoke(c06201);
                    }
                    return aVar;
                }
                return list2;
            }
            return list;
        }
        if (i13 == 1) {
            i10 = c06201.I$1;
            i11 = c06201.I$0;
            jArr = (long[]) c06201.L$2;
            cVar3 = (ee.c) c06201.L$1;
            mamiEngine2 = (MamiEngine) c06201.L$0;
            m.b(objInvoke);
            j = 0;
            mamiEngine2.check();
            c06201.L$0 = mamiEngine2;
            c06201.L$1 = cVar3;
            c06201.L$2 = jArr;
            c06201.I$0 = i11;
            c06201.I$1 = i10;
            c06201.label = 2;
            objInvoke = cVar3.invoke(c06201);
        } else {
            if (i13 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = c06201.I$1;
            i11 = c06201.I$0;
            jArr = (long[]) c06201.L$2;
            cVar3 = (ee.c) c06201.L$1;
            mamiEngine2 = (MamiEngine) c06201.L$0;
            m.b(objInvoke);
            j = 0;
        }
        C06201 c06203 = c06201;
        cVar2 = cVar3;
        list2 = (List) objInvoke;
        mamiEngine2.check();
        List<Ranked> list4 = list2;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((Ranked) it2.next()).getMs() > j) {
                    return list2;
                }
            }
        }
        i = i11 + 1;
        c06202 = c06203;
        j11 = j;
        if (i < i10) {
            j10 = jArr[i];
            j = j11;
            mamiEngine2.log("این دستگاه همین حالا ثبت شد؛ سرورها چند ثانیه طول می\u200cکشد تا آن را بشناسند — " + (j10 / ((long) 1000)) + " ثانیه دیگر دوباره سنجیده می\u200cشود…");
            c06202.L$0 = mamiEngine2;
            c06202.L$1 = cVar2;
            c06202.L$2 = jArr;
            c06202.I$0 = i;
            c06202.I$1 = i10;
            c06202.label = 1;
            if (m0.j(j10, c06202) != aVar) {
                int i15 = i;
                cVar3 = cVar2;
                c06201 = c06202;
                i11 = i15;
                mamiEngine2.check();
                c06201.L$0 = mamiEngine2;
                c06201.L$1 = cVar3;
                c06201.L$2 = jArr;
                c06201.I$0 = i11;
                c06201.I$1 = i10;
                c06201.label = 2;
                objInvoke = cVar3.invoke(c06201);
            }
            return aVar;
        }
        return list2;
    }

    private final SharedPreferences sp() {
        Context context = app;
        if (context != null) {
            return context.getSharedPreferences("mami", 0);
        }
        kotlin.jvm.internal.j.k("app");
        throw null;
    }

    private final void startWatch() {
        s1 s1Var = watchJob;
        if (s1Var != null) {
            s1Var.cancel(null);
        }
        watchJob = m0.y(scope, null, null, new C06211(null), 3);
    }

    private final void stopFront() {
        if (TunnelStatus.INSTANCE.isActive() || frontMarker != null) {
            try {
                SafeStart safeStart = SafeStart.INSTANCE;
                Context context = app;
                if (context == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                Context context2 = app;
                if (context2 == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                Intent action = new Intent(context2, (Class<?>) TunnelVpnService.class).setAction(TunnelVpnService.ACTION_DISCONNECT);
                kotlin.jvm.internal.j.d(action, "setAction(...)");
                l.m1004constructorimpl(Boolean.valueOf(safeStart.service(context, action)));
            } catch (Throwable th2) {
                l.m1004constructorimpl(m.a(th2));
            }
        }
    }

    private final void stopService() {
        if (isOurs()) {
            SafeStart safeStart = SafeStart.INSTANCE;
            Context context = app;
            if (context == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            Context context2 = app;
            if (context2 == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            Intent intent = new Intent(context2, (Class<?>) MyVpnService.class);
            intent.setAction("STOP");
            safeStart.service(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String testConfig(sf.c cVar) {
        sf.c cVar2 = new sf.c();
        sf.c cVar3 = new sf.c();
        cVar3.D("loglevel", "warning");
        cVar2.D(XrayCoreHostService.KEY_LOG, cVar3);
        sf.a aVar = new sf.a();
        sf.c cVarP = i.p("tag", "socks", "listen", SniSession.LOCAL_HOST);
        cVarP.D(PsiphonProbeService.PORT, Integer.valueOf(((int) (Math.random() * ((double) 3000))) + 36000));
        cVarP.D("protocol", "socks");
        sf.c cVar4 = new sf.c();
        cVar4.E("udp", false);
        cVarP.D("settings", cVar4);
        aVar.put(cVarP);
        cVar2.D("inbounds", aVar);
        sf.a aVar2 = new sf.a();
        sf.c cVar5 = new sf.c(cVar.toString());
        cVar5.D("tag", WarpIdRelay.VIA_PROXY);
        aVar2.put(cVar5);
        cVar2.D("outbounds", aVar2);
        String string = cVar2.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Exit trace(Proxy proxy) {
        Object objM1004constructorimpl;
        Exit exit;
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.e(proxy);
            builder.a(12L, TimeUnit.SECONDS);
            OkHttpClient okHttpClient = new OkHttpClient(builder);
            long jNanoTime = System.nanoTime();
            okhttp3.Request.Builder builder2 = new okhttp3.Request.Builder();
            builder2.j("https://www.cloudflare.com/cdn-cgi/trace");
            Response responseD = okHttpClient.b(new okhttp3.Request(builder2)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                String strW = responseBody != null ? responseBody.w() : null;
                String str = "";
                if (strW == null) {
                    strW = "";
                }
                if (responseD.A) {
                    kotlin.text.g gVarFind$default = kotlin.text.l.find$default(new kotlin.text.l("(?m)^loc=([A-Z0-9]{2})"), strW, 0, 2, null);
                    String str2 = gVarFind$default != null ? (String) ((f0) ((kotlin.text.i) gVarFind$default).a()).get(1) : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                    kotlin.text.g gVarFind$default2 = kotlin.text.l.find$default(new kotlin.text.l("(?m)^ip=(\\S+)"), strW, 0, 2, null);
                    String str3 = gVarFind$default2 != null ? (String) ((f0) ((kotlin.text.i) gVarFind$default2).a()).get(1) : null;
                    if (str3 != null) {
                        str = str3;
                    }
                    exit = new Exit(str2, str, (System.nanoTime() - jNanoTime) / ((long) 1000000));
                } else {
                    exit = null;
                }
                responseD.close();
                objM1004constructorimpl = l.m1004constructorimpl(exit);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    a.a.g(responseD, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th4));
        }
        return (Exit) (l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object traceFront(wd.d dVar) {
        return m0.J(v0.f24208c, new C06222(null), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object traceHttp(wd.d dVar) {
        return m0.J(v0.f24208c, new C06232(null), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(1:7)|8|(5:(2:121|(1:(1:(4:14|126|15|16)(2:21|22))(6:23|24|25|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)))(6:28|29|30|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71))|73))(15:31|113|32|45|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)))|73)|20|(1:98)|99|(1:108)(3:107|37|(3:39|(3:117|41|(12:44|45|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)))))(11:48|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71))))|73)(1:(2:110|111)(1:132))))(3:36|37|(3:39|(3:117|41|(12:44|45|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)))))(11:48|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71))))|73)(1:(2:110|111)(1:132)))|17|112|74|(2:76|77)(2:80|81)|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:31|113|32|45|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)))|73) */
    /* JADX WARN: Can't wrap try/catch for region: R(3:117|41|(12:44|45|130|49|128|50|122|51|52|119|53|(3:56|57|(4:60|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71))))) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:69|70|115|71) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:23|24|25|124|61|(4:63|(1:65)(1:66)|67|68)(4:69|70|115|71)) */
    /* JADX WARN: Code duplicated, block: B:101:0x028a  */
    /* JADX WARN: Code duplicated, block: B:109:0x02e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:117:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    /* JADX WARN: Code duplicated, block: B:44:0x0142  */
    /* JADX WARN: Code duplicated, block: B:48:0x0159  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:60:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ec A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #8 {all -> 0x005b, blocks: (B:15:0x004f, B:63:0x01ec, B:67:0x0203, B:68:0x0206), top: B:126:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:66:0x0201  */
    /* JADX WARN: Code duplicated, block: B:69:0x0207 A[Catch: all -> 0x026a, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x026a, blocks: (B:61:0x01e4, B:69:0x0207), top: B:124:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:98:0x0283  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0152, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0153, code lost:
    
        r15 = r11;
        r11 = r4;
        r4 = 0;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x022f, code lost:
    
        if (r0 == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0250, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0251, code lost:
    
        r15 = r5;
        r5 = r10;
        r11 = r14;
        r12 = r18;
        r10 = r1;
        r1 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0262, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0263, code lost:
    
        r11 = r10 == true ? 1 : 0;
        r10 = r1;
        r1 = r15;
        r15 = r5;
        r5 = r11 ? 1 : 0;
        r11 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x026a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x026d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0270, code lost:
    
        r5 = r10 == true ? 1 : 0;
        r10 = r1;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0274, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0276, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0279, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x027d, code lost:
    
        r0 = th;
     */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryServers(List<Cand> list, Mode mode, PlaceRow placeRow, boolean z10, wd.d dVar) throws Fail {
        C06241 c06241;
        MamiEngine mamiEngine;
        PlaceRow placeRow2;
        ?? r8;
        Iterator<Cand> it;
        C06241 c06242;
        MamiEngine mamiEngine2;
        Fail th2;
        Mode mode2;
        Mode mode3;
        PlaceRow placeRow3;
        final Cand next;
        String str;
        ?? r10;
        MamiEngine mamiEngine3;
        PlaceRow placeRow4;
        oe.e eVar;
        C06253 c06253;
        Mode mode4;
        PlaceRow placeRow5;
        MamiEngine mamiEngine4;
        Mode mode5;
        ?? r11;
        ?? r12;
        String str2;
        ?? r13;
        String strConfig;
        Object objLaunch;
        oe.e eVar2;
        AnonymousClass5 anonymousClass5;
        ?? r14;
        Mode mode6;
        if (dVar instanceof C06241) {
            c06241 = (C06241) dVar;
            int i = c06241.label;
            if ((i & TLObject.FLAG_31) != 0) {
                c06241.label = i - TLObject.FLAG_31;
                mamiEngine = this;
            } else {
                mamiEngine = this;
                c06241 = mamiEngine.new C06241(dVar);
            }
        } else {
            mamiEngine = this;
            c06241 = mamiEngine.new C06241(dVar);
        }
        Object objVerify = c06241.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i10 = c06241.label;
        ?? r15 = 4;
        int i11 = 1;
        wd.d dVar2 = null;
        if (i10 == 0) {
            m.b(objVerify);
            placeRow2 = placeRow;
            r8 = z10;
            it = list.iterator();
            c06242 = c06241;
            mamiEngine2 = mamiEngine;
            th2 = null;
            mode2 = mode;
            if (it.hasNext()) {
                if (th2 == null) {
                    throw new IllegalStateException("وصل نشد");
                }
                throw th2;
            }
            next = it.next();
            mamiEngine2.check();
            final j jVar = delays.get(next.getId());
            mamiEngine2.setStatus(new ee.c() { // from class: com.mlmvpn.scanner.engines.mami.e
                @Override // ee.c
                public final Object invoke(Object obj) {
                    return MamiEngine.tryServers$lambda$70(next, jVar, (MamiEngine.Status) obj);
                }
            });
            if (r8 != 0) {
                eVar = v0.f24208c;
                c06253 = new C06253(next, placeRow2, dVar2);
                c06242.L$0 = mamiEngine2;
                c06242.L$1 = mode2;
                c06242.L$2 = placeRow2;
                c06242.L$3 = it;
                c06242.L$4 = next;
                c06242.L$5 = dVar2;
                c06242.Z$0 = r8;
                c06242.I$0 = 0;
                c06242.label = i11;
                if (m0.J(eVar, c06253, c06242) != aVar) {
                    MamiEngine mamiEngine5 = mamiEngine2;
                    mode4 = mode2;
                    c06241 = c06242;
                    placeRow5 = placeRow2;
                    i10 = 0;
                    mamiEngine4 = mamiEngine5;
                    r14 = r8;
                    PlaceRow placeRow6 = placeRow5;
                    r11 = r14;
                    mamiEngine3 = mamiEngine4;
                    mode5 = mode4;
                    placeRow4 = placeRow6;
                    mamiEngine3.check();
                    mamiEngine3.setStatus(new f(24));
                    String strPlaceLabel = mamiEngine3.placeLabel(next);
                    String profile = next.getProfile();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("راه\u200cاندازی موتور با سرور ");
                    sb2.append(strPlaceLabel);
                    sb2.append(" (");
                    sb2.append(profile);
                    sb2.append(")…");
                    mamiEngine3.log(sb2.toString());
                    strConfig = mamiEngine3.config(next.getOutbound());
                    eVar2 = v0.f24208c;
                    anonymousClass5 = new AnonymousClass5(dVar2);
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode5;
                    c06241.L$2 = placeRow4;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = strConfig;
                    c06241.Z$0 = r11;
                    c06241.I$0 = i11;
                    c06241.label = 2;
                    if (m0.J(eVar2, anonymousClass5, c06241) != aVar) {
                        i10 = i11;
                        r13 = r11;
                        c06241.L$0 = mamiEngine3;
                        c06241.L$1 = mode5;
                        c06241.L$2 = placeRow4;
                        c06241.L$3 = it;
                        c06241.L$4 = next;
                        c06241.L$5 = strConfig;
                        c06241.Z$0 = r13;
                        c06241.I$0 = i10;
                        c06241.label = 3;
                        objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                        if (objLaunch != aVar) {
                            PlaceRow placeRow7 = placeRow4;
                            str = strConfig;
                            objVerify = objLaunch;
                            mode3 = mode5;
                            placeRow3 = placeRow7;
                            r12 = r13;
                            if (!((Boolean) objVerify).booleanValue()) {
                                if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                                    str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                                } else {
                                    str2 = "موتور بالا نیامد";
                                }
                                throw new IllegalStateException(str2);
                            }
                            mamiEngine3.check();
                            mamiEngine3.setStatus(new f(6));
                            MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$1 = new MamiEngine$tryServers$tr$1(dVar2);
                            c06241.L$0 = mamiEngine3;
                            c06241.L$1 = mode3;
                            c06241.L$2 = placeRow3;
                            c06241.L$3 = it;
                            c06241.L$4 = next;
                            c06241.L$5 = str;
                            c06241.Z$0 = r12;
                            c06241.I$0 = i10;
                            c06241.label = 4;
                            objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$1, c06241);
                            r10 = r12;
                        }
                    }
                }
            } else {
                mode5 = mode2;
                c06241 = c06242;
                r11 = r8 == true ? 1 : 0;
                mamiEngine3 = mamiEngine2;
                placeRow4 = placeRow2;
                i10 = 0;
                mamiEngine3.check();
                mamiEngine3.setStatus(new f(24));
                String strPlaceLabel2 = mamiEngine3.placeLabel(next);
                String profile2 = next.getProfile();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("راه\u200cاندازی موتور با سرور ");
                sb3.append(strPlaceLabel2);
                sb3.append(" (");
                sb3.append(profile2);
                sb3.append(")…");
                mamiEngine3.log(sb3.toString());
                strConfig = mamiEngine3.config(next.getOutbound());
                eVar2 = v0.f24208c;
                anonymousClass5 = new AnonymousClass5(dVar2);
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode5;
                c06241.L$2 = placeRow4;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = strConfig;
                c06241.Z$0 = r11;
                c06241.I$0 = i11;
                c06241.label = 2;
                if (m0.J(eVar2, anonymousClass5, c06241) != aVar) {
                    i10 = i11;
                    r13 = r11;
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode5;
                    c06241.L$2 = placeRow4;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = strConfig;
                    c06241.Z$0 = r13;
                    c06241.I$0 = i10;
                    c06241.label = 3;
                    objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                    if (objLaunch != aVar) {
                        PlaceRow placeRow8 = placeRow4;
                        str = strConfig;
                        objVerify = objLaunch;
                        mode3 = mode5;
                        placeRow3 = placeRow8;
                        r12 = r13;
                        if (!((Boolean) objVerify).booleanValue()) {
                            if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                                str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                            } else {
                                str2 = "موتور بالا نیامد";
                            }
                            throw new IllegalStateException(str2);
                        }
                        mamiEngine3.check();
                        mamiEngine3.setStatus(new f(6));
                        MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$2 = new MamiEngine$tryServers$tr$1(dVar2);
                        c06241.L$0 = mamiEngine3;
                        c06241.L$1 = mode3;
                        c06241.L$2 = placeRow3;
                        c06241.L$3 = it;
                        c06241.L$4 = next;
                        c06241.L$5 = str;
                        c06241.Z$0 = r12;
                        c06241.I$0 = i10;
                        c06241.label = 4;
                        objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$2, c06241);
                        r10 = r12;
                    }
                }
            }
            return aVar;
        }
        if (i10 == 1) {
            i10 = c06241.I$0;
            boolean z11 = c06241.Z$0;
            next = (Cand) c06241.L$4;
            it = (Iterator) c06241.L$3;
            placeRow5 = (PlaceRow) c06241.L$2;
            mode4 = (Mode) c06241.L$1;
            mamiEngine4 = (MamiEngine) c06241.L$0;
            try {
                m.b(objVerify);
                r14 = z11;
            } catch (Throwable th3) {
                th2 = th3;
                c06242 = c06241;
                mode2 = mode4;
                placeRow4 = placeRow5;
                mamiEngine3 = mamiEngine4;
                r15 = z11;
                ?? r16 = r15;
                if (i10 != 0) {
                    mamiEngine3.stopService();
                }
                if (cancelled) {
                }
                throw th2;
            }
            PlaceRow placeRow9 = placeRow5;
            r11 = r14;
            mamiEngine3 = mamiEngine4;
            mode5 = mode4;
            placeRow4 = placeRow9;
            mamiEngine3.check();
            mamiEngine3.setStatus(new f(24));
            String strPlaceLabel3 = mamiEngine3.placeLabel(next);
            String profile3 = next.getProfile();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("راه\u200cاندازی موتور با سرور ");
            sb4.append(strPlaceLabel3);
            sb4.append(" (");
            sb4.append(profile3);
            sb4.append(")…");
            mamiEngine3.log(sb4.toString());
            strConfig = mamiEngine3.config(next.getOutbound());
            eVar2 = v0.f24208c;
            anonymousClass5 = new AnonymousClass5(dVar2);
            c06241.L$0 = mamiEngine3;
            c06241.L$1 = mode5;
            c06241.L$2 = placeRow4;
            c06241.L$3 = it;
            c06241.L$4 = next;
            c06241.L$5 = strConfig;
            c06241.Z$0 = r11;
            c06241.I$0 = i11;
            c06241.label = 2;
            if (m0.J(eVar2, anonymousClass5, c06241) != aVar) {
                i10 = i11;
                r13 = r11;
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode5;
                c06241.L$2 = placeRow4;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = strConfig;
                c06241.Z$0 = r13;
                c06241.I$0 = i10;
                c06241.label = 3;
                objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                if (objLaunch != aVar) {
                    PlaceRow placeRow10 = placeRow4;
                    str = strConfig;
                    objVerify = objLaunch;
                    mode3 = mode5;
                    placeRow3 = placeRow10;
                    r12 = r13;
                    if (!((Boolean) objVerify).booleanValue()) {
                        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                            str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                        } else {
                            str2 = "موتور بالا نیامد";
                        }
                        throw new IllegalStateException(str2);
                    }
                    mamiEngine3.check();
                    mamiEngine3.setStatus(new f(6));
                    MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$3 = new MamiEngine$tryServers$tr$1(dVar2);
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode3;
                    c06241.L$2 = placeRow3;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = str;
                    c06241.Z$0 = r12;
                    c06241.I$0 = i10;
                    c06241.label = 4;
                    objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$3, c06241);
                    r10 = r12;
                }
            }
            return aVar;
        }
        try {
            if (i10 == 2) {
                i10 = c06241.I$0;
                boolean z12 = c06241.Z$0;
                String str3 = (String) c06241.L$5;
                next = (Cand) c06241.L$4;
                it = (Iterator) c06241.L$3;
                placeRow4 = (PlaceRow) c06241.L$2;
                mode5 = (Mode) c06241.L$1;
                MamiEngine mamiEngine6 = (MamiEngine) c06241.L$0;
                m.b(objVerify);
                strConfig = str3;
                r13 = z12;
                mamiEngine3 = mamiEngine6;
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode5;
                c06241.L$2 = placeRow4;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = strConfig;
                c06241.Z$0 = r13;
                c06241.I$0 = i10;
                c06241.label = 3;
                objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                if (objLaunch != aVar) {
                    PlaceRow placeRow11 = placeRow4;
                    str = strConfig;
                    objVerify = objLaunch;
                    mode3 = mode5;
                    placeRow3 = placeRow11;
                    r12 = r13;
                    if (!((Boolean) objVerify).booleanValue()) {
                        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                            str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                        } else {
                            str2 = "موتور بالا نیامد";
                        }
                        throw new IllegalStateException(str2);
                    }
                    mamiEngine3.check();
                    mamiEngine3.setStatus(new f(6));
                    MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$4 = new MamiEngine$tryServers$tr$1(dVar2);
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode3;
                    c06241.L$2 = placeRow3;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = str;
                    c06241.Z$0 = r12;
                    c06241.I$0 = i10;
                    c06241.label = 4;
                    objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$4, c06241);
                    r10 = r12;
                }
                return aVar;
            }
            if (i10 == 3) {
                i10 = c06241.I$0;
                boolean z13 = c06241.Z$0;
                String str4 = (String) c06241.L$5;
                next = (Cand) c06241.L$4;
                it = (Iterator) c06241.L$3;
                PlaceRow placeRow12 = (PlaceRow) c06241.L$2;
                Mode mode7 = (Mode) c06241.L$1;
                MamiEngine mamiEngine7 = (MamiEngine) c06241.L$0;
                m.b(objVerify);
                r12 = z13;
                mamiEngine3 = mamiEngine7;
                mode3 = mode7;
                placeRow3 = placeRow12;
                str = str4;
                if (!((Boolean) objVerify).booleanValue()) {
                    if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                        str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                    } else {
                        str2 = "موتور بالا نیامد";
                    }
                    throw new IllegalStateException(str2);
                }
                mamiEngine3.check();
                mamiEngine3.setStatus(new f(6));
                MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$5 = new MamiEngine$tryServers$tr$1(dVar2);
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode3;
                c06241.L$2 = placeRow3;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = str;
                c06241.Z$0 = r12;
                c06241.I$0 = i10;
                c06241.label = 4;
                objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$5, c06241);
                r10 = r12;
            } else {
                if (i10 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = c06241.I$0;
                r12 = c06241.Z$0;
                str = (String) c06241.L$5;
                next = (Cand) c06241.L$4;
                it = (Iterator) c06241.L$3;
                placeRow3 = (PlaceRow) c06241.L$2;
                mode3 = (Mode) c06241.L$1;
                mamiEngine3 = (MamiEngine) c06241.L$0;
                try {
                    m.b(objVerify);
                    r10 = r12;
                } catch (Throwable th4) {
                    th2 = th4;
                    ?? r17 = r12;
                    c06242 = c06241;
                    mode2 = mode3;
                    mamiEngine3 = mamiEngine3;
                    r15 = r17 == true ? 1 : 0;
                    placeRow4 = placeRow3;
                    ?? r18 = r15;
                    if (i10 != 0) {
                        mamiEngine3.stopService();
                    }
                    if (cancelled) {
                    }
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            c06242 = c06241;
            mode2 = mode6;
            ?? r19 = r15;
            if (i10 != 0) {
                mamiEngine3.stopService();
            }
            if (cancelled) {
            }
            throw th2;
        }
        ?? r110 = r15;
        if (i10 != 0) {
            mamiEngine3.stopService();
        }
        if (!cancelled || (th2 instanceof CancellationException) || ((th2 instanceof Fail) && kotlin.jvm.internal.j.a(th2.getCode(), "ROUTE_FAILED"))) {
            throw th2;
        }
        mamiEngine3.log("سرور " + mamiEngine3.placeLabel(next) + " وصل نشد: " + th2.getMessage());
        delays.put(next.getId(), new j(new Long(-1L), new Long(System.currentTimeMillis())));
        placeRow2 = placeRow4;
        mamiEngine2 = mamiEngine3;
        i11 = 1;
        dVar2 = null;
        r8 = r110;
        if (it.hasNext()) {
            if (th2 == null) {
                throw new IllegalStateException("وصل نشد");
            }
            throw th2;
        }
        next = it.next();
        mamiEngine2.check();
        final j jVar2 = delays.get(next.getId());
        mamiEngine2.setStatus(new ee.c() { // from class: com.mlmvpn.scanner.engines.mami.e
            @Override // ee.c
            public final Object invoke(Object obj) {
                return MamiEngine.tryServers$lambda$70(next, jVar2, (MamiEngine.Status) obj);
            }
        });
        if (r8 != 0) {
            eVar = v0.f24208c;
            c06253 = new C06253(next, placeRow2, dVar2);
            c06242.L$0 = mamiEngine2;
            c06242.L$1 = mode2;
            c06242.L$2 = placeRow2;
            c06242.L$3 = it;
            c06242.L$4 = next;
            c06242.L$5 = dVar2;
            c06242.Z$0 = r8;
            c06242.I$0 = 0;
            c06242.label = i11;
            if (m0.J(eVar, c06253, c06242) != aVar) {
                MamiEngine mamiEngine8 = mamiEngine2;
                mode4 = mode2;
                c06241 = c06242;
                placeRow5 = placeRow2;
                i10 = 0;
                mamiEngine4 = mamiEngine8;
                r14 = r8;
                PlaceRow placeRow13 = placeRow5;
                r11 = r14;
                mamiEngine3 = mamiEngine4;
                mode5 = mode4;
                placeRow4 = placeRow13;
                mamiEngine3.check();
                mamiEngine3.setStatus(new f(24));
                String strPlaceLabel4 = mamiEngine3.placeLabel(next);
                String profile4 = next.getProfile();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("راه\u200cاندازی موتور با سرور ");
                sb5.append(strPlaceLabel4);
                sb5.append(" (");
                sb5.append(profile4);
                sb5.append(")…");
                mamiEngine3.log(sb5.toString());
                strConfig = mamiEngine3.config(next.getOutbound());
                eVar2 = v0.f24208c;
                anonymousClass5 = new AnonymousClass5(dVar2);
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode5;
                c06241.L$2 = placeRow4;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = strConfig;
                c06241.Z$0 = r11;
                c06241.I$0 = i11;
                c06241.label = 2;
                if (m0.J(eVar2, anonymousClass5, c06241) != aVar) {
                    i10 = i11;
                    r13 = r11;
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode5;
                    c06241.L$2 = placeRow4;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = strConfig;
                    c06241.Z$0 = r13;
                    c06241.I$0 = i10;
                    c06241.label = 3;
                    objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                    if (objLaunch != aVar) {
                        PlaceRow placeRow14 = placeRow4;
                        str = strConfig;
                        objVerify = objLaunch;
                        mode3 = mode5;
                        placeRow3 = placeRow14;
                        r12 = r13;
                        if (!((Boolean) objVerify).booleanValue()) {
                            if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                                str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                            } else {
                                str2 = "موتور بالا نیامد";
                            }
                            throw new IllegalStateException(str2);
                        }
                        mamiEngine3.check();
                        mamiEngine3.setStatus(new f(6));
                        MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$6 = new MamiEngine$tryServers$tr$1(dVar2);
                        c06241.L$0 = mamiEngine3;
                        c06241.L$1 = mode3;
                        c06241.L$2 = placeRow3;
                        c06241.L$3 = it;
                        c06241.L$4 = next;
                        c06241.L$5 = str;
                        c06241.Z$0 = r12;
                        c06241.I$0 = i10;
                        c06241.label = 4;
                        objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$6, c06241);
                        r10 = r12;
                    }
                }
            }
        } else {
            mode5 = mode2;
            c06241 = c06242;
            r11 = r8 == true ? 1 : 0;
            mamiEngine3 = mamiEngine2;
            placeRow4 = placeRow2;
            i10 = 0;
            mamiEngine3.check();
            mamiEngine3.setStatus(new f(24));
            String strPlaceLabel5 = mamiEngine3.placeLabel(next);
            String profile5 = next.getProfile();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("راه\u200cاندازی موتور با سرور ");
            sb6.append(strPlaceLabel5);
            sb6.append(" (");
            sb6.append(profile5);
            sb6.append(")…");
            mamiEngine3.log(sb6.toString());
            strConfig = mamiEngine3.config(next.getOutbound());
            eVar2 = v0.f24208c;
            anonymousClass5 = new AnonymousClass5(dVar2);
            c06241.L$0 = mamiEngine3;
            c06241.L$1 = mode5;
            c06241.L$2 = placeRow4;
            c06241.L$3 = it;
            c06241.L$4 = next;
            c06241.L$5 = strConfig;
            c06241.Z$0 = r11;
            c06241.I$0 = i11;
            c06241.label = 2;
            if (m0.J(eVar2, anonymousClass5, c06241) != aVar) {
                i10 = i11;
                r13 = r11;
                c06241.L$0 = mamiEngine3;
                c06241.L$1 = mode5;
                c06241.L$2 = placeRow4;
                c06241.L$3 = it;
                c06241.L$4 = next;
                c06241.L$5 = strConfig;
                c06241.Z$0 = r13;
                c06241.I$0 = i10;
                c06241.label = 3;
                objLaunch = mamiEngine3.launch(strConfig, mode5, c06241);
                if (objLaunch != aVar) {
                    PlaceRow placeRow15 = placeRow4;
                    str = strConfig;
                    objVerify = objLaunch;
                    mode3 = mode5;
                    placeRow3 = placeRow15;
                    r12 = r13;
                    if (!((Boolean) objVerify).booleanValue()) {
                        if (((g1) MyVpnService.Companion.getConnectionPhaseFlow()).getValue() == MyVpnService.Phase.FAILED) {
                            str2 = "اندروید اجازهٔ VPN را نداد یا سرویس VPN بالا نیامد";
                        } else {
                            str2 = "موتور بالا نیامد";
                        }
                        throw new IllegalStateException(str2);
                    }
                    mamiEngine3.check();
                    mamiEngine3.setStatus(new f(6));
                    MamiEngine$tryServers$tr$1 mamiEngine$tryServers$tr$7 = new MamiEngine$tryServers$tr$1(dVar2);
                    c06241.L$0 = mamiEngine3;
                    c06241.L$1 = mode3;
                    c06241.L$2 = placeRow3;
                    c06241.L$3 = it;
                    c06241.L$4 = next;
                    c06241.L$5 = str;
                    c06241.Z$0 = r12;
                    c06241.I$0 = i10;
                    c06241.label = 4;
                    objVerify = mamiEngine3.verify(mamiEngine$tryServers$tr$7, c06241);
                    r10 = r12;
                }
            }
        }
        return aVar;
        String str5 = str;
        Cand cand = next;
        Mode mode8 = mode3;
        Exit exit = (Exit) objVerify;
        if (exit == null) {
            throw new IllegalStateException("موتور بالا آمد ولی داده\u200cای از سرور رد نشد");
        }
        mamiEngine3.setStatus(new f(7));
        live = new Live("xray", cand, str5, null, mode8);
        mamiEngine3.connected(exit);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status tryServers$lambda$70(Cand cand, j jVar, Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, null, null, new ServerRef(cand.getId(), cand.getCc(), cand.getCountry(), cand.getCity(), cand.getProtocol(), cand.getProfile(), jVar != null ? ((Number) jVar.getFirst()).longValue() : 0L), null, null, 0L, 0L, it.getAttempt() + 1, null, 1519, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status tryServers$lambda$71(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "engine", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status tryServers$lambda$72(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "verify", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status tryServers$lambda$73(Status it) {
        kotlin.jvm.internal.j.e(it, "it");
        return Status.copy$default(it, null, null, "route", null, null, null, null, 0L, 0L, 0, null, 2043, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(4:47|26|(6:29|30|35|(1:37)|38|(1:(1:42))(1:40))|44) */
    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    /* JADX WARN: Code duplicated, block: B:37:0x0089  */
    /* JADX WARN: Code duplicated, block: B:40:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0091  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        r2 = r12;
        r12 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        if (kotlinx.coroutines.m0.j(1200, r0) == r1) goto L44;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x008f -> B:45:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x009f -> B:45:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object verify(ee.c cVar, wd.d dVar) {
        C06261 c06261;
        ee.c cVar2;
        int i;
        MamiEngine mamiEngine;
        ee.c cVar3;
        Object objM1004constructorimpl;
        Exit exit;
        if (dVar instanceof C06261) {
            c06261 = (C06261) dVar;
            int i10 = c06261.label;
            if ((i10 & TLObject.FLAG_31) != 0) {
                c06261.label = i10 - TLObject.FLAG_31;
            } else {
                c06261 = new C06261(dVar);
            }
        } else {
            c06261 = new C06261(dVar);
        }
        Object obj = c06261.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i11 = c06261.label;
        if (i11 == 0) {
            m.b(obj);
            cVar2 = cVar;
            i = 0;
            mamiEngine = this;
            if (i < 3 || cancelled) {
                return null;
            }
            c06261.L$0 = mamiEngine;
            c06261.L$1 = cVar2;
            c06261.I$0 = i;
            c06261.label = 1;
            Object objInvoke = cVar2.invoke(c06261);
            if (objInvoke != aVar) {
                cVar3 = cVar2;
                obj = objInvoke;
                objM1004constructorimpl = l.m1004constructorimpl((Exit) obj);
                if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                    objM1004constructorimpl = null;
                }
                exit = (Exit) objM1004constructorimpl;
                if (exit != null) {
                    return exit;
                }
                if (i < 2) {
                    c06261.L$0 = mamiEngine;
                    c06261.L$1 = cVar3;
                    c06261.I$0 = i;
                    c06261.label = 2;
                }
            }
            return aVar;
        }
        if (i11 == 1) {
            i = c06261.I$0;
            cVar3 = (ee.c) c06261.L$1;
            mamiEngine = (MamiEngine) c06261.L$0;
            try {
                m.b(obj);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th3));
                if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                    objM1004constructorimpl = null;
                }
                exit = (Exit) objM1004constructorimpl;
                if (exit != null) {
                    return exit;
                }
                if (i < 2) {
                    c06261.L$0 = mamiEngine;
                    c06261.L$1 = cVar3;
                    c06261.I$0 = i;
                    c06261.label = 2;
                }
                cVar2 = cVar3;
                i++;
                if (i < 3) {
                }
                return null;
            }
            objM1004constructorimpl = l.m1004constructorimpl((Exit) obj);
            if (l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = null;
            }
            exit = (Exit) objM1004constructorimpl;
            if (exit != null) {
                return exit;
            }
            if (i < 2) {
                c06261.L$0 = mamiEngine;
                c06261.L$1 = cVar3;
                c06261.I$0 = i;
                c06261.label = 2;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c06261.I$0;
            cVar3 = (ee.c) c06261.L$1;
            mamiEngine = (MamiEngine) c06261.L$0;
            m.b(obj);
        }
        cVar2 = cVar3;
        i++;
        if (i < 3) {
        }
        return null;
    }

    public final CatalogInfo catalogInfo() {
        List<MamiCatalog.Skipped> skipped;
        List<MamiCatalog.Server> servers;
        MamiApi mamiApi = MamiApi.INSTANCE;
        MamiApi.Summary summary = mamiApi.summary();
        if (!summary.getHasCatalog()) {
            return null;
        }
        MamiCatalog.Parsed parsed = parsedSaved();
        long catalogRevision = summary.getCatalogRevision();
        int catalogPayloadVersion = summary.getCatalogPayloadVersion();
        boolean z10 = false;
        int version2 = parsed != null ? parsed.getVersion() : 0;
        int size = (parsed == null || (servers = parsed.getServers()) == null) ? 0 : servers.size();
        int size2 = (parsed == null || (skipped = parsed.getSkipped()) == null) ? 0 : skipped.size();
        long catalogFetchedAt = summary.getCatalogFetchedAt();
        long catalogExpiresAt = summary.getCatalogExpiresAt();
        if (summary.getCatalogExpiresAt() > 0 && summary.getCatalogExpiresAt() > mamiApi.nowSec()) {
            z10 = true;
        }
        return new CatalogInfo(catalogRevision, catalogPayloadVersion, version2, size, size2, catalogFetchedAt, catalogExpiresAt, z10);
    }

    public final void clearError() {
        if (((Status) ((g1) _status).getValue()).getError() != null) {
            setStatus(new f(23));
        }
    }

    public final s1 connectAsync(Context context, String str, List<String> exclude) {
        kotlin.jvm.internal.j.e(context, "context");
        kotlin.jvm.internal.j.e(exclude, "exclude");
        return (s1) connectionOwner.replace(null, new com.mlmvpn.core.aether.c(context, 5, str, exclude));
    }

    public final MamiApi.Summary control$app_release() {
        return MamiApi.INSTANCE.summary();
    }

    public final boolean disconnectAsync(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        return connectionOwner.stop(null, new d(context, 0));
    }

    public final String forget(Context context, boolean z10) throws IOException {
        kotlin.jvm.internal.j.e(context, "context");
        init(context);
        if (!kotlin.jvm.internal.j.a(((Status) ((g1) _status).getValue()).getPhase(), "off")) {
            return "اول اتصال مامی را قطع کنید";
        }
        try {
            MamiApi.INSTANCE.forget(z10);
            delays.clear();
            cat = null;
            hiveCat = null;
            saveRoute(null);
            log(z10 ? "هویت این دستگاه و نشست آن پاک شد؛ اتصال بعدی دستگاه را دوباره ثبت می\u200cکند." : "نشست و فهرست ذخیره\u200cشده پاک شد.");
            bump();
            return null;
        } catch (Exception e10) {
            String message = e10.getMessage();
            return message == null ? "پاک نشد" : message;
        }
    }

    public final String freshConfig(Context context) throws IOException {
        kotlin.jvm.internal.j.e(context, "context");
        init(context);
        Live live2 = live;
        if (live2 != null) {
            return live2.getConfig();
        }
        return null;
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
        List<MamiCatalog.Skipped> skipped;
        List<MamiCatalog.Server> servers;
        MamiApi.Summary summary = MamiApi.INSTANCE.summary();
        if (!summary.getHasHive()) {
            return null;
        }
        MamiCatalog.Hive hive = parsedHive();
        return new HiveInfo(summary.getHiveFetchedAt(), summary.getHiveRevision(), (hive == null || (servers = hive.getServers()) == null) ? 0 : servers.size(), (hive == null || (skipped = hive.getSkipped()) == null) ? 0 : skipped.size(), System.currentTimeMillis() - summary.getHiveFetchedAt() < 3600000);
    }

    public final void init(Context context) throws IOException {
        kotlin.jvm.internal.j.e(context, "context");
        if (app != null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        app = applicationContext;
        if (applicationContext == null) {
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
        InputStream inputStreamOpen = applicationContext.getAssets().open("mami/catalog-bootstrap.json");
        try {
            kotlin.jvm.internal.j.b(inputStreamOpen);
            String str = new String(t.p(inputStreamOpen), kotlin.text.a.f23859a);
            a.a.g(inputStreamOpen, null);
            MamiApi mamiApi = MamiApi.INSTANCE;
            Context context2 = app;
            if (context2 == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            File file = new File(context2.getFilesDir(), "mami");
            String property = System.getProperty("http.agent");
            if (property == null) {
                property = "";
            }
            mamiApi.init(file, str, property, clientInfo());
            mamiApi.setLogger(new f(11));
            mamiApi.setNetworkOf(new a(1));
            MamiNet.INSTANCE.setRouteOf(new a(2));
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a.a.g(inputStreamOpen, th2);
                throw th3;
            }
        }
    }

    public final boolean isMamiConfig(String str) {
        return kotlin.jvm.internal.j.a(str, REMARKS);
    }

    public final boolean isOurs() {
        return kotlin.jvm.internal.j.a(((g1) MyVpnService.Companion.getConnectedNodeIdFlow()).getValue(), "mami");
    }

    public final List<PlaceRow> locations() {
        ArrayList arrayList;
        MamiCatalog.Parsed parsed = parsedSaved();
        if (parsed == null) {
            return w.INSTANCE;
        }
        final List<MamiCatalog.Server> servers = parsed.getServers();
        Map mapH = s7.e.h(new z() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$groupingBy$1
            @Override // kotlin.collections.z
            public String keyOf(MamiCatalog.Server server) {
                return server.getLocationId();
            }

            @Override // kotlin.collections.z
            public Iterator<MamiCatalog.Server> sourceIterator() {
                return servers.iterator();
            }
        });
        HashSet hashSet = new HashSet();
        int i = 0;
        if (parsed.getLocations().isEmpty()) {
            List<MamiCatalog.Server> servers2 = parsed.getServers();
            arrayList = new ArrayList(kotlin.collections.s.g0(servers2, 10));
            for (MamiCatalog.Server server : servers2) {
                j jVarPlaceOfServer = INSTANCE.placeOfServer(server);
                String str = (String) jVarPlaceOfServer.component1();
                String str2 = (String) jVarPlaceOfServer.component2();
                String locationId = server.getLocationId();
                String countryCode = server.getCountryCode();
                int sort = server.getSort();
                Integer num = (Integer) mapH.get(server.getLocationId());
                arrayList.add(new PlaceRow(locationId, countryCode, str, str2, sort, num != null ? num.intValue() : 0));
            }
        } else {
            List<MamiCatalog.Location> locations = parsed.getLocations();
            arrayList = new ArrayList(kotlin.collections.s.g0(locations, 10));
            for (MamiCatalog.Location location : locations) {
                MamiCatalog.Place placePlaceOfLocation = INSTANCE.placeOfLocation(location);
                String id2 = location.getId();
                String countryCode2 = location.getCountryCode();
                String country = placePlaceOfLocation.getCountry();
                String city = placePlaceOfLocation.getCity();
                int sort2 = location.getSort();
                Integer num2 = (Integer) mapH.get(location.getId());
                arrayList.add(new PlaceRow(id2, countryCode2, country, city, sort2, num2 != null ? num2.intValue() : 0));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (hashSet.add(((PlaceRow) obj).getId())) {
                arrayList2.add(obj);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return p.e(Integer.valueOf(((MamiEngine.PlaceRow) t10).getSort()), Integer.valueOf(((MamiEngine.PlaceRow) t11).getSort()));
            }
        };
        return q.b1(arrayList2, new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$locations$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int iCompare = comparator.compare(t10, t11);
                return iCompare != 0 ? iCompare : p.e(((MamiEngine.PlaceRow) t10).getCountry(), ((MamiEngine.PlaceRow) t11).getCountry());
            }
        });
    }

    public final void log(String msg) {
        kotlin.jvm.internal.j.e(msg, "msg");
        String strG = d1.g("[", new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()), "] ", msg);
        Log.i(TAG, msg);
        g1 g1Var = (g1) _logs;
        g1Var.j(q.e1(q.S0(m9.d.B(strG), (Iterable) g1Var.getValue()), 300));
    }

    public final s1 measureAllAsync(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        return m0.y(scope, null, null, new C06171(context, null), 3);
    }

    public final Method method(String str) {
        Object next;
        Iterator<T> it = METHODS.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (kotlin.jvm.internal.j.a(((Method) next).getKey(), str)) {
                return (Method) next;
            }
        }
        next = null;
        return (Method) next;
    }

    public final Prefs prefs() {
        SharedPreferences sharedPreferencesSp = sp();
        String string = sharedPreferencesSp.getString(ConstKt.SEP_METHOD, "auto");
        if (INSTANCE.method(string) == null) {
            string = null;
        }
        String str = string != null ? string : "auto";
        Mode mode = kotlin.jvm.internal.j.a(sharedPreferencesSp.getString("mode", "tunnel"), WarpIdRelay.VIA_PROXY) ? Mode.PROXY : Mode.TUNNEL;
        String string2 = sharedPreferencesSp.getString("location", "");
        return new Prefs(str, mode, string2 != null ? string2 : "");
    }

    public final void prewarm(Context context) throws IOException {
        Method method;
        kotlin.jvm.internal.j.e(context, "context");
        init(context);
        if (!kotlin.jvm.internal.j.a(((Status) ((g1) _status).getValue()).getPhase(), "off") || (method = method(prefs().getMethod())) == null || kotlin.jvm.internal.j.a(method.getKind(), WarpIdRelay.VIA_FRONT)) {
            return;
        }
        if (kotlin.jvm.internal.j.a(method.getKey(), "auto") || kotlin.jvm.internal.j.a(method.getKey(), "hive")) {
            CombineEngine combineEngine = CombineEngine.INSTANCE;
            Context context2 = app;
            if (context2 == null) {
                kotlin.jvm.internal.j.k("app");
                throw null;
            }
            combineEngine.warmMeasure(context2);
        }
        XrayHosts xrayHosts = XrayHosts.INSTANCE;
        Context context3 = app;
        if (context3 != null) {
            xrayHosts.warm(context3, xrayHosts.getTUNNEL());
        } else {
            kotlin.jvm.internal.j.k("app");
            throw null;
        }
    }

    public final s1 refreshAsync(Context context, String what) {
        kotlin.jvm.internal.j.e(context, "context");
        kotlin.jvm.internal.j.e(what, "what");
        return m0.y(scope, null, null, new C06181(context, what, null), 3);
    }

    public final List<ServerRow> servers() {
        MamiCatalog.Parsed parsed = parsedSaved();
        if (parsed == null) {
            return w.INSTANCE;
        }
        List<MamiCatalog.Server> servers = parsed.getServers();
        ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(servers, 10));
        for (MamiCatalog.Server server : servers) {
            j jVar = delays.get(server.getId());
            j jVarPlaceOfServer = INSTANCE.placeOfServer(server);
            String str = (String) jVarPlaceOfServer.component1();
            String str2 = (String) jVarPlaceOfServer.component2();
            String strUnsupportedReason$default = MamiXrayConfig.unsupportedReason$default(MamiXrayConfig.INSTANCE, server, false, 2, null);
            String id2 = server.getId();
            String countryCode = server.getCountryCode();
            String locationId = server.getLocationId();
            String protocol = server.getProtocol();
            String profile = server.getProfile();
            int sort = server.getSort();
            boolean z10 = strUnsupportedReason$default == null;
            if (strUnsupportedReason$default == null) {
                strUnsupportedReason$default = "";
            }
            String str3 = strUnsupportedReason$default;
            long jLongValue = 0;
            long jLongValue2 = jVar != null ? ((Number) jVar.getFirst()).longValue() : 0L;
            if (jVar != null) {
                jLongValue = ((Number) jVar.getSecond()).longValue();
            }
            arrayList.add(new ServerRow(id2, countryCode, str, str2, locationId, protocol, profile, sort, z10, str3, jLongValue2, jLongValue));
        }
        final Comparator comparator = new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return p.e(Integer.valueOf(((MamiEngine.ServerRow) t10).getSort()), Integer.valueOf(((MamiEngine.ServerRow) t11).getSort()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int iCompare = comparator.compare(t10, t11);
                return iCompare != 0 ? iCompare : p.e(((MamiEngine.ServerRow) t10).getCountry(), ((MamiEngine.ServerRow) t11).getCountry());
            }
        };
        return q.b1(arrayList, new Comparator() { // from class: com.mlmvpn.scanner.engines.mami.MamiEngine$servers$$inlined$thenBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int iCompare = comparator2.compare(t10, t11);
                return iCompare != 0 ? iCompare : p.e(((MamiEngine.ServerRow) t10).getId(), ((MamiEngine.ServerRow) t11).getId());
            }
        });
    }

    public final Prefs setPrefs(String str, Mode mode, String str2) {
        SharedPreferences.Editor editorEdit = sp().edit();
        if (str != null && method(str) != null) {
            editorEdit.putString(ConstKt.SEP_METHOD, str);
        }
        if (mode != null) {
            editorEdit.putString("mode", mode == Mode.PROXY ? WarpIdRelay.VIA_PROXY : "tunnel");
        }
        if (str2 != null) {
            if (!i.B("^[A-Za-z0-9_-]{0,64}$", str2)) {
                str2 = "";
            }
            editorEdit.putString("location", str2);
        }
        editorEdit.apply();
        bump();
        return prefs();
    }

    public final String unnamed$app_release(String str, String method) {
        kotlin.jvm.internal.j.e(method, "method");
        if (str == null) {
            str = "";
        }
        String strQ0 = v.q0(v.q0(str, "سرور آرگو", "پل"), "به آرگو", "به پل");
        for (String literal : ENGINE_NAMES) {
            kotlin.text.l.Companion.getClass();
            kotlin.jvm.internal.j.e(literal, "literal");
            String strQuote = Pattern.quote(literal);
            kotlin.jvm.internal.j.d(strQuote, "quote(...)");
            strQ0 = new kotlin.text.l(w0.n("(?<![\\p{L}\\p{M}])", strQuote, "(?![\\p{L}\\p{M}])"), kotlin.text.m.IGNORE_CASE).replace(strQ0, method);
        }
        return strQ0;
    }
}
