package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import androidx.media3.common.s;
import com.mlmvpn.core.aether.AetherScanService;
import com.mlmvpn.core.aether.i;
import com.mlmvpn.scanner.data.studio.api.DeviceReport;
import com.mlmvpn.scanner.engines.mae.device.DeviceSignals;
import com.mlmvpn.scanner.engines.scout.ScoutScore;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.internal.j;
import kotlin.text.l;
import kotlin.text.o;
import kotlin.text.v;
import org.telegram.messenger.MediaDataController;
import org.telegram.messenger.NotificationBadge;
import org.telegram.ui.Cells.d1;
import sd.m;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiApi {
    private static final long CALL_MS = 30000;
    public static final String CLIENT_KEY = "0fb27d68b9dfe7fcf111e3b05ab73a917d3a6f32eb050e27";
    private static final long HOST_FRESH_MS = 1800000;
    private static final long HOST_RETRY_MS = 300000;
    private static final int MAX_ANSWER = 524288;
    private static sf.c S = null;
    private static final long STICKY_MS = 600000;
    public static final int VERSION_CODE = 56;
    public static final String VERSION_NAME = "1.0.12";
    private static sf.c boot;
    private static volatile long lastRediscover;
    private static volatile boolean ready;
    private static MamiStore store;
    private static Map<String, ? extends PublicKey> trusted;
    public static final MamiApi INSTANCE = new MamiApi();
    private static final int[] PAYLOAD_VERSIONS = {8, 7, 6, 5, 4, 3};
    private static String userAgent = "Dalvik/2.1.0 (Linux; U; Android 14; Android device Build/UP1A.231005.007)";
    private static sf.c client = new sf.c();
    private static volatile ee.a networkOf = new a(0);
    private static volatile ee.c logFn = new f(3);
    private static final Object lock = new Object();
    private static final Object hostLock = new Object();
    private static volatile Sticky sticky = new Sticky(0, 0);
    private static final l TOKEN_RE = new l("^[A-Za-z0-9_.-]{32,8192}$");
    private static final l REFRESH_RE = new l("^[A-Za-z0-9_-]{32,128}$");
    private static final Object sessionLock = new Object();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Answer {
        public static final int $stable = 8;
        private final String host;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final MamiNet.Resp f11576r;

        public Answer(MamiNet.Resp r4, String host) {
            j.e(r4, "r");
            j.e(host, "host");
            this.f11576r = r4;
            this.host = host;
        }

        public final int getCode() {
            return this.f11576r.getCode();
        }

        public final String getHost() {
            return this.host;
        }

        public final sf.c getJson() {
            return this.f11576r.getJson();
        }

        public final MamiNet.Resp getR() {
            return this.f11576r;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class ApiException extends Exception {
        public static final int $stable = 0;
        private final String code;
        private final int retryAfter;
        private final int status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiException(String code, String message, int i, int i10) {
            super(message);
            j.e(code, "code");
            j.e(message, "message");
            this.code = code;
            this.status = i;
            this.retryAfter = i10;
        }

        public final String getCode() {
            return this.code;
        }

        public final int getRetryAfter() {
            return this.retryAfter;
        }

        public final int getStatus() {
            return this.status;
        }

        public /* synthetic */ ApiException(String str, String str2, int i, int i10, int i11, kotlin.jvm.internal.e eVar) {
            this(str, str2, (i11 & 4) != 0 ? 0 : i, (i11 & 8) != 0 ? 0 : i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class HostResult {
        public static final int $stable = 0;
        private final boolean fresh;
        private final String host;
        private final boolean ok;

        public HostResult(boolean z10, String str, boolean z11) {
            this.ok = z10;
            this.host = str;
            this.fresh = z11;
        }

        public static /* synthetic */ HostResult copy$default(HostResult hostResult, boolean z10, String str, boolean z11, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = hostResult.ok;
            }
            if ((i & 2) != 0) {
                str = hostResult.host;
            }
            if ((i & 4) != 0) {
                z11 = hostResult.fresh;
            }
            return hostResult.copy(z10, str, z11);
        }

        public final boolean component1() {
            return this.ok;
        }

        public final String component2() {
            return this.host;
        }

        public final boolean component3() {
            return this.fresh;
        }

        public final HostResult copy(boolean z10, String str, boolean z11) {
            return new HostResult(z10, str, z11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HostResult)) {
                return false;
            }
            HostResult hostResult = (HostResult) obj;
            return this.ok == hostResult.ok && j.a(this.host, hostResult.host) && this.fresh == hostResult.fresh;
        }

        public final boolean getFresh() {
            return this.fresh;
        }

        public final String getHost() {
            return this.host;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.ok) * 31;
            String str = this.host;
            return Boolean.hashCode(this.fresh) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            boolean z10 = this.ok;
            String str = this.host;
            boolean z11 = this.fresh;
            StringBuilder sb2 = new StringBuilder("HostResult(ok=");
            sb2.append(z10);
            sb2.append(", host=");
            sb2.append(str);
            sb2.append(", fresh=");
            return f0.a.n(sb2, ")", z11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Sticky {
        private final long at;
        private final int index;

        public Sticky(int i, long j) {
            this.index = i;
            this.at = j;
        }

        public static /* synthetic */ Sticky copy$default(Sticky sticky, int i, long j, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i = sticky.index;
            }
            if ((i10 & 2) != 0) {
                j = sticky.at;
            }
            return sticky.copy(i, j);
        }

        public final int component1() {
            return this.index;
        }

        public final long component2() {
            return this.at;
        }

        public final Sticky copy(int i, long j) {
            return new Sticky(i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Sticky)) {
                return false;
            }
            Sticky sticky = (Sticky) obj;
            return this.index == sticky.index && this.at == sticky.at;
        }

        public final long getAt() {
            return this.at;
        }

        public final int getIndex() {
            return this.index;
        }

        public int hashCode() {
            return Long.hashCode(this.at) + (Integer.hashCode(this.index) * 31);
        }

        public String toString() {
            return "Sticky(index=" + this.index + ", at=" + this.at + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Summary {
        public static final int $stable = 0;
        private final long accessExpiresAt;
        private final long catalogExpiresAt;
        private final long catalogFetchedAt;
        private final int catalogPayloadVersion;
        private final long catalogRevision;
        private final long clockOffsetSec;
        private final boolean hasCatalog;
        private final boolean hasHive;
        private final int hiveCount;
        private final long hiveFetchedAt;
        private final long hiveRevision;
        private final String host;
        private final long hostAt;
        private final String hostError;
        private final String hostSource;
        private final boolean registered;
        private final long registeredAt;

        public Summary(String str, String str2, long j, String hostError, boolean z10, long j10, long j11, long j12, long j13, int i, long j14, long j15, boolean z11, long j16, int i10, long j17, boolean z12) {
            j.e(hostError, "hostError");
            this.host = str;
            this.hostSource = str2;
            this.hostAt = j;
            this.hostError = hostError;
            this.registered = z10;
            this.registeredAt = j10;
            this.accessExpiresAt = j11;
            this.clockOffsetSec = j12;
            this.catalogRevision = j13;
            this.catalogPayloadVersion = i;
            this.catalogExpiresAt = j14;
            this.catalogFetchedAt = j15;
            this.hasCatalog = z11;
            this.hiveFetchedAt = j16;
            this.hiveCount = i10;
            this.hiveRevision = j17;
            this.hasHive = z12;
        }

        public final String component1() {
            return this.host;
        }

        public final int component10() {
            return this.catalogPayloadVersion;
        }

        public final long component11() {
            return this.catalogExpiresAt;
        }

        public final long component12() {
            return this.catalogFetchedAt;
        }

        public final boolean component13() {
            return this.hasCatalog;
        }

        public final long component14() {
            return this.hiveFetchedAt;
        }

        public final int component15() {
            return this.hiveCount;
        }

        public final long component16() {
            return this.hiveRevision;
        }

        public final boolean component17() {
            return this.hasHive;
        }

        public final String component2() {
            return this.hostSource;
        }

        public final long component3() {
            return this.hostAt;
        }

        public final String component4() {
            return this.hostError;
        }

        public final boolean component5() {
            return this.registered;
        }

        public final long component6() {
            return this.registeredAt;
        }

        public final long component7() {
            return this.accessExpiresAt;
        }

        public final long component8() {
            return this.clockOffsetSec;
        }

        public final long component9() {
            return this.catalogRevision;
        }

        public final Summary copy(String str, String str2, long j, String hostError, boolean z10, long j10, long j11, long j12, long j13, int i, long j14, long j15, boolean z11, long j16, int i10, long j17, boolean z12) {
            j.e(hostError, "hostError");
            return new Summary(str, str2, j, hostError, z10, j10, j11, j12, j13, i, j14, j15, z11, j16, i10, j17, z12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            return j.a(this.host, summary.host) && j.a(this.hostSource, summary.hostSource) && this.hostAt == summary.hostAt && j.a(this.hostError, summary.hostError) && this.registered == summary.registered && this.registeredAt == summary.registeredAt && this.accessExpiresAt == summary.accessExpiresAt && this.clockOffsetSec == summary.clockOffsetSec && this.catalogRevision == summary.catalogRevision && this.catalogPayloadVersion == summary.catalogPayloadVersion && this.catalogExpiresAt == summary.catalogExpiresAt && this.catalogFetchedAt == summary.catalogFetchedAt && this.hasCatalog == summary.hasCatalog && this.hiveFetchedAt == summary.hiveFetchedAt && this.hiveCount == summary.hiveCount && this.hiveRevision == summary.hiveRevision && this.hasHive == summary.hasHive;
        }

        public final long getAccessExpiresAt() {
            return this.accessExpiresAt;
        }

        public final long getCatalogExpiresAt() {
            return this.catalogExpiresAt;
        }

        public final long getCatalogFetchedAt() {
            return this.catalogFetchedAt;
        }

        public final int getCatalogPayloadVersion() {
            return this.catalogPayloadVersion;
        }

        public final long getCatalogRevision() {
            return this.catalogRevision;
        }

        public final long getClockOffsetSec() {
            return this.clockOffsetSec;
        }

        public final boolean getHasCatalog() {
            return this.hasCatalog;
        }

        public final boolean getHasHive() {
            return this.hasHive;
        }

        public final int getHiveCount() {
            return this.hiveCount;
        }

        public final long getHiveFetchedAt() {
            return this.hiveFetchedAt;
        }

        public final long getHiveRevision() {
            return this.hiveRevision;
        }

        public final String getHost() {
            return this.host;
        }

        public final long getHostAt() {
            return this.hostAt;
        }

        public final String getHostError() {
            return this.hostError;
        }

        public final String getHostSource() {
            return this.hostSource;
        }

        public final boolean getRegistered() {
            return this.registered;
        }

        public final long getRegisteredAt() {
            return this.registeredAt;
        }

        public int hashCode() {
            String str = this.host;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.hostSource;
            return Boolean.hashCode(this.hasHive) + w0.c(androidx.compose.foundation.interaction.f.c(this.hiveCount, w0.c(w0.d(w0.c(w0.c(androidx.compose.foundation.interaction.f.c(this.catalogPayloadVersion, w0.c(w0.c(w0.c(w0.c(w0.d(s.d(w0.c((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.hostAt), 31, this.hostError), 31, this.registered), 31, this.registeredAt), 31, this.accessExpiresAt), 31, this.clockOffsetSec), 31, this.catalogRevision), 31), 31, this.catalogExpiresAt), 31, this.catalogFetchedAt), 31, this.hasCatalog), 31, this.hiveFetchedAt), 31), 31, this.hiveRevision);
        }

        public String toString() {
            String str = this.host;
            String str2 = this.hostSource;
            long j = this.hostAt;
            String str3 = this.hostError;
            boolean z10 = this.registered;
            long j10 = this.registeredAt;
            long j11 = this.accessExpiresAt;
            long j12 = this.clockOffsetSec;
            long j13 = this.catalogRevision;
            int i = this.catalogPayloadVersion;
            long j14 = this.catalogExpiresAt;
            long j15 = this.catalogFetchedAt;
            boolean z11 = this.hasCatalog;
            long j16 = this.hiveFetchedAt;
            int i10 = this.hiveCount;
            long j17 = this.hiveRevision;
            boolean z12 = this.hasHive;
            StringBuilder sbN = s.n("Summary(host=", str, ", hostSource=", str2, ", hostAt=");
            i.t(j, ", hostError=", str3, sbN);
            sbN.append(", registered=");
            sbN.append(z10);
            sbN.append(", registeredAt=");
            sbN.append(j10);
            v0.a.k(j11, ", accessExpiresAt=", ", clockOffsetSec=", sbN);
            sbN.append(j12);
            v0.a.k(j13, ", catalogRevision=", ", catalogPayloadVersion=", sbN);
            i.r(i, j14, ", catalogExpiresAt=", sbN);
            v0.a.k(j15, ", catalogFetchedAt=", ", hasCatalog=", sbN);
            sbN.append(z11);
            sbN.append(", hiveFetchedAt=");
            sbN.append(j16);
            sbN.append(", hiveCount=");
            sbN.append(i10);
            sbN.append(", hiveRevision=");
            sbN.append(j17);
            sbN.append(", hasHive=");
            sbN.append(z12);
            sbN.append(")");
            return sbN.toString();
        }
    }

    private MamiApi() {
    }

    private final Answer authed(String str, sf.c cVar) {
        Answer answerCall$default = call$default(this, str, null, cVar, null, ensureSession$default(this, false, 1, null).A("accessToken", ""), 0L, null, null, 234, null);
        return answerCall$default.getCode() == 401 ? call$default(this, str, null, cVar, null, ensureSession(true).A("accessToken", ""), 0L, null, null, 234, null) : answerCall$default;
    }

    public static /* synthetic */ Answer call$default(MamiApi mamiApi, String str, String str2, sf.c cVar, byte[] bArr, String str3, long j, String str4, String str5, int i, Object obj) {
        return mamiApi.call(str, (i & 2) != 0 ? "POST" : str2, (i & 4) != 0 ? null : cVar, (i & 8) != 0 ? null : bArr, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? 30000L : j, (i & 64) == 0 ? str4 : null, (i & 128) != 0 ? "application/json" : str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void call$lambda$18() {
        try {
            sd.l.m1004constructorimpl(INSTANCE.discoverHost());
        } catch (Throwable th2) {
            sd.l.m1004constructorimpl(m.a(th2));
        }
    }

    private final String catalogPath() {
        sf.c cVar = boot;
        if (cVar == null) {
            j.k("boot");
            throw null;
        }
        String strA = cVar.A("endpoint", "/api/v1/catalog");
        j.d(strA, "optString(...)");
        return new l("^/?api/v1/").replace(strA, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence discoverHost$lambda$13$lambda$10(DeadDropResult it) {
        j.e(it, "it");
        return f0.a.l(it.getLabel(), ": ", it.getError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.j discoverHost$lambda$13$lambda$9(String url, int i, int i10) {
        j.e(url, "url");
        MamiNet.Resp respRequest = MamiNet.INSTANCE.request(url, (410 & 2) != 0 ? "GET" : null, (410 & 4) != 0 ? d0.E() : d0.J(new sd.j("Cache-Control", "no-cache"), new sd.j("User-Agent", userAgent)), (410 & 8) != 0 ? null : null, (410 & 16) == 0 ? null : null, (410 & 32) != 0 ? 15000L : i, (410 & 64) != 0 ? 2097152L : i10, (410 & 128) != 0, (410 & 256) != 0 ? false : false);
        if (respRequest.getCode() == 0) {
            return null;
        }
        return new sd.j(Integer.valueOf(respRequest.getCode()), respRequest.getBody());
    }

    public static /* synthetic */ sf.c ensureSession$default(MamiApi mamiApi, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        return mamiApi.ensureSession(z10);
    }

    public static /* synthetic */ sf.c fetchCatalog$default(MamiApi mamiApi, Long l6, int i, Object obj) {
        if ((i & 1) != 0) {
            l6 = null;
        }
        return mamiApi.fetchCatalog(l6);
    }

    public static /* synthetic */ sf.c fetchHive$default(MamiApi mamiApi, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ScoutScore.CONNECT;
        }
        return mamiApi.fetchHive(str);
    }

    public static /* synthetic */ void forget$default(MamiApi mamiApi, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        mamiApi.forget(z10);
    }

    private final List<sd.j> hostOrder() {
        String strA = st().A("host", "");
        j.b(strA);
        if (o.L0(strA)) {
            return w.INSTANCE;
        }
        List listA0 = r.a0(strA, "edge.".concat(strA), "assets.".concat(strA));
        int i = 0;
        if (sticky.getIndex() != 0 && System.currentTimeMillis() - sticky.getAt() >= 600000) {
            sticky = new Sticky(0, 0L);
        }
        int iMin = Math.min(sticky.getIndex(), listA0.size() - 1);
        List listB = m9.d.B(new sd.j(listA0.get(iMin), Integer.valueOf(iMin)));
        List list = listA0;
        ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.f0();
                throw null;
            }
            arrayList.add(new sd.j((String) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            if (((Number) ((sd.j) obj2).getSecond()).intValue() != iMin) {
                arrayList2.add(obj2);
            }
        }
        return q.S0(listB, arrayList2);
    }

    private final SimpleDateFormat httpDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:17:0x002d  */
    private final ApiException httpError(String str, Answer answer) {
        String strA;
        String strA2;
        String str2;
        Integer numV0;
        sf.c json = answer.getJson();
        if (json != null && (strA = json.A("error", "")) != null) {
            if (o.L0(strA)) {
                strA = null;
            }
            if (strA == null) {
                if (json != null) {
                    strA = null;
                } else {
                    strA = null;
                }
            }
        } else if (json != null || (strA2 = json.A("message", "")) == null || o.L0(strA2)) {
            strA = null;
        } else {
            strA = strA2;
        }
        String strL1 = strA != null ? o.l1(160, strA) : null;
        if (strL1 == null) {
            strL1 = "";
        }
        int code = answer.getCode();
        if (code == 401 || code == 403) {
            str2 = "سرور دستگاه را نپذیرفت";
        } else if (code == 429) {
            str2 = "سرور گفت درخواست\u200cها زیاد است؛ کمی بعد";
        } else {
            str2 = code >= 500 ? "سرور مامی خطای داخلی داد" : "پاسخ نامعتبر";
        }
        String strH = f0.a.h(code, "http-");
        String strConcat = o.L0(strL1) ? "" : " — ".concat(strL1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(": ");
        sb2.append(str2);
        sb2.append(" (کد ");
        sb2.append(code);
        String strR = w0.r(sb2, ")", strConcat);
        String str3 = answer.getR().getHeaders().get("retry-after");
        return new ApiException(strH, strR, code, (str3 == null || (numV0 = v.v0(str3)) == null) ? 0 : numV0.intValue());
    }

    private final void log(String str) {
        try {
            logFn.invoke(str);
            sd.l.m1004constructorimpl(u.f67154a);
        } catch (Throwable th2) {
            sd.l.m1004constructorimpl(m.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u logFn$lambda$1(String it) {
        j.e(it, "it");
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.j networkOf$lambda$0() {
        return new sd.j("wifi", "");
    }

    private final double numberOf(Object obj) {
        Double dI0;
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (!(obj instanceof String) || (dI0 = kotlin.text.u.i0(o.n1((String) obj).toString())) == null) {
            return Double.NaN;
        }
        return dI0.doubleValue();
    }

    private final sf.c parseTokens(Answer answer) {
        sf.c json;
        if (answer.getR().getBody().length != 0 && answer.getR().getBody().length <= 16384 && (json = answer.getJson()) != null && j.a(json.A("tokenType", ""), "Bearer")) {
            Object objO = json.o("accessToken");
            String str = objO instanceof String ? (String) objO : null;
            if (str != null) {
                Object objO2 = json.o("refreshToken");
                String str2 = objO2 instanceof String ? (String) objO2 : null;
                if (str2 != null && TOKEN_RE.matches(str) && REFRESH_RE.matches(str2)) {
                    double dNumberOf = numberOf(json.o("accessExpiresAt"));
                    double dNumberOf2 = numberOf(json.o("refreshExpiresAt"));
                    if (dNumberOf > 0.0d && dNumberOf2 > 0.0d) {
                        Object objO3 = json.o("user");
                        sf.c cVar = objO3 instanceof sf.c ? (sf.c) objO3 : null;
                        if (cVar != null) {
                            sf.c cVarP = i.p("accessToken", str, "refreshToken", str2);
                            cVarP.D("accessExpiresAt", Long.valueOf((long) dNumberOf));
                            cVarP.D("refreshExpiresAt", Long.valueOf((long) dNumberOf2));
                            cVarP.D("user", cVar);
                            cVarP.D("at", Long.valueOf(System.currentTimeMillis()));
                            return cVarP;
                        }
                    }
                }
            }
        }
        return null;
    }

    private final sf.c refresh(sf.c cVar) throws ApiException {
        sf.c cVar2 = new sf.c();
        cVar2.D("refreshToken", cVar.A("refreshToken", ""));
        Answer answerCall$default = call$default(this, "device/refresh", null, cVar2, null, null, 0L, null, null, MediaDataController.MAX_LINKS_COUNT, null);
        int code = answerCall$default.getCode();
        if (200 > code || code >= 300) {
            if (answerCall$default.getCode() != 401) {
                throw httpError("تمدید نشست", answerCall$default);
            }
            log("سرور تمدید نشست را نپذیرفت — ثبت دوباره.");
            return null;
        }
        sf.c tokens = parseTokens(answerCall$default);
        if (tokens == null) {
            log("پاسخ تمدید نشست قالب درستی نداشت — ثبت دوباره.");
            return null;
        }
        st().D("session", tokens);
        m299saved1pmJ48();
        return tokens;
    }

    private final sf.c register() throws ApiException {
        Identity identityLoad = MamiIdentity.INSTANCE.load(getStore());
        log("ثبت این دستگاه روی سرور مامی…");
        sf.c cVar = new sf.c();
        cVar.D("deviceId", identityLoad.getDeviceId());
        cVar.D("client", client);
        Answer answerCall$default = call$default(this, "device/register", null, cVar, null, null, 0L, null, null, MediaDataController.MAX_LINKS_COUNT, null);
        int code = answerCall$default.getCode();
        if (200 > code || code >= 300) {
            throw httpError("ثبت دستگاه", answerCall$default);
        }
        sf.c tokens = parseTokens(answerCall$default);
        if (tokens == null) {
            throw new ApiException("bad-tokens", "ثبت دستگاه: پاسخ سرور قالب درستی نداشت", 0, 0, 12, null);
        }
        sf.c cVarSt = st();
        cVarSt.D("session", tokens);
        cVarSt.D("registeredAt", Long.valueOf(System.currentTimeMillis()));
        m299saved1pmJ48();
        log("دستگاه ثبت شد.");
        return tokens;
    }

    public static /* synthetic */ void route$default(MamiApi mamiApi, String str, String str2, boolean z10, int i, Object obj) throws ApiException {
        if ((i & 4) != 0) {
            z10 = true;
        }
        mamiApi.route(str, str2, z10);
    }

    /* JADX INFO: renamed from: save-d1pmJ48, reason: not valid java name */
    private final Object m299saved1pmJ48() {
        Object objM1004constructorimpl;
        synchronized (lock) {
            MamiApi mamiApi = INSTANCE;
            try {
                mamiApi.getStore().writeJson("state.json", mamiApi.st());
                objM1004constructorimpl = sd.l.m1004constructorimpl(u.f67154a);
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
            }
        }
        return objM1004constructorimpl;
    }

    private final sf.c st() {
        sf.c json;
        synchronized (lock) {
            try {
                json = S;
                if (json == null) {
                    json = INSTANCE.getStore().readJson("state.json");
                    if (json == null) {
                        json = new sf.c();
                    }
                    S = json;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return json;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:27:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:29:0x0105  */
    /* JADX WARN: Code duplicated, block: B:31:0x010f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0148  */
    /* JADX WARN: Code duplicated, block: B:46:0x0195  */
    /* JADX WARN: Code duplicated, block: B:50:0x012d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0111 A[SYNTHETIC] */
    public final Answer call(String str, String str2, sf.c cVar, byte[] bArr, String str3, long j, String str4, String accept) throws ApiException {
        byte[] bArr2;
        String str5;
        String str6;
        String str7;
        ArrayList arrayList;
        String str8;
        int iIntValue;
        String str9;
        MamiNet.Resp respRequest;
        String error;
        String string;
        String p10 = str;
        String method = str2;
        j.e(p10, "p");
        j.e(method, "method");
        j.e(accept, "accept");
        ensureHost();
        LinkedHashMap linkedHashMapG = d0.G(new sd.j("Accept", accept), new sd.j("Accept-Encoding", "identity"), new sd.j("Cache-Control", "no-store"), new sd.j("X-YamYam-Version-Code", "56"), new sd.j("User-Agent", userAgent), new sd.j("X-YY-Client", CLIENT_KEY));
        if (str3 != null) {
            linkedHashMapG.put("Authorization", "Bearer ".concat(str3));
        }
        if (str3 != null && method.equals("GET")) {
            linkedHashMapG.put("X-YamYam-Timezone", client.A(DeviceSignals.TIMEZONE, "UTC"));
            linkedHashMapG.put("X-YamYam-Version-Name", VERSION_NAME);
        }
        if (cVar == null || (string = cVar.toString()) == null) {
            bArr2 = bArr;
        } else {
            byte[] bytes = string.getBytes(kotlin.text.a.f23859a);
            j.d(bytes, "getBytes(...)");
            bArr2 = bytes;
        }
        if (bArr2 != null) {
            if (str4 == null) {
                str5 = "application/json; charset=utf-8";
            } else {
                str6 = str4;
            }
            if (!v.s0(p10, "/", false)) {
                p10 = "/api/v1/".concat(p10);
            }
            str7 = p10;
            arrayList = new ArrayList();
            for (sd.j jVar : hostOrder()) {
                str8 = (String) jVar.component1();
                iIntValue = ((Number) jVar.component2()).intValue();
                str9 = str7;
                respRequest = MamiNet.INSTANCE.request(w0.n("https://", str8, str7), (410 & 2) != 0 ? "GET" : method, (410 & 4) != 0 ? d0.E() : linkedHashMapG, (410 & 8) != 0 ? null : bArr2, (410 & 16) == 0 ? str6 : null, (410 & 32) != 0 ? 15000L : j, (410 & 64) != 0 ? 2097152L : 528384L, (410 & 128) != 0, (410 & 256) != 0 ? false : false);
                if (respRequest.getCode() == 0) {
                    noteClock(respRequest.getHeaders().get("date"));
                    if (iIntValue != sticky.getIndex()) {
                        sticky = new Sticky(iIntValue, System.currentTimeMillis());
                    }
                    if (respRequest.getBody().length <= 524288 || respRequest.getTruncated()) {
                        throw new ApiException("too-large", "پاسخ سرور بیش از اندازه بزرگ بود", 0, 0, 12, null);
                    }
                    return new Answer(respRequest, str8);
                }
                error = respRequest.getError();
                if (o.L0(error)) {
                    error = "بی\u200cپاسخ";
                }
                arrayList.add(str8 + ": " + ((Object) error));
                str7 = str9;
                method = str2;
            }
            if (System.currentTimeMillis() - lastRediscover > 60000) {
                lastRediscover = System.currentTimeMillis();
                Thread thread = new Thread(new c(), "mami-host");
                thread.setDaemon(true);
                thread.start();
            }
            throw new ApiException(DeviceReport.UNREACHABLE, v0.a.h("سرور فرمان مامی در دسترس نبود: ", q.F0(arrayList, " · ", null, null, null, 62)), 0, 0, 12, null);
        }
        str5 = null;
        str6 = str5;
        if (!v.s0(p10, "/", false)) {
            p10 = "/api/v1/".concat(p10);
        }
        str7 = p10;
        arrayList = new ArrayList();
        while (r16.hasNext()) {
            str8 = (String) jVar.component1();
            iIntValue = ((Number) jVar.component2()).intValue();
            str9 = str7;
            respRequest = MamiNet.INSTANCE.request(w0.n("https://", str8, str7), (410 & 2) != 0 ? "GET" : method, (410 & 4) != 0 ? d0.E() : linkedHashMapG, (410 & 8) != 0 ? null : bArr2, (410 & 16) == 0 ? str6 : null, (410 & 32) != 0 ? 15000L : j, (410 & 64) != 0 ? 2097152L : 528384L, (410 & 128) != 0, (410 & 256) != 0 ? false : false);
            if (respRequest.getCode() == 0) {
                noteClock(respRequest.getHeaders().get("date"));
                if (iIntValue != sticky.getIndex()) {
                    sticky = new Sticky(iIntValue, System.currentTimeMillis());
                }
                if (respRequest.getBody().length <= 524288) {
                }
                throw new ApiException("too-large", "پاسخ سرور بیش از اندازه بزرگ بود", 0, 0, 12, null);
            }
            error = respRequest.getError();
            if (o.L0(error)) {
                error = "بی\u200cپاسخ";
            }
            arrayList.add(str8 + ": " + ((Object) error));
            str7 = str9;
            method = str2;
        }
        if (System.currentTimeMillis() - lastRediscover > 60000) {
            lastRediscover = System.currentTimeMillis();
            Thread thread2 = new Thread(new c(), "mami-host");
            thread2.setDaemon(true);
            thread2.start();
        }
        throw new ApiException(DeviceReport.UNREACHABLE, v0.a.h("سرور فرمان مامی در دسترس نبود: ", q.F0(arrayList, " · ", null, null, null, 62)), 0, 0, 12, null);
    }

    public final long clockOffset() {
        return st().x(0L, "clockOffsetSec");
    }

    public final HostResult discoverHost() {
        String str;
        HostResult hostResult;
        synchronized (hostLock) {
            try {
                DeadDropOutcome deadDropOutcomeResolve$default = MamiDeadDrop.resolve$default(MamiDeadDrop.INSTANCE, null, 0, new b(), 3, null);
                MamiApi mamiApi = INSTANCE;
                sf.c cVarSt = mamiApi.st();
                cVarSt.D("hostTriedAt", Long.valueOf(System.currentTimeMillis()));
                if (!deadDropOutcomeResolve$default.getOk() || deadDropOutcomeResolve$default.getHost() == null) {
                    String strF0 = q.F0(deadDropOutcomeResolve$default.getResults(), " · ", null, null, new f(4), 30);
                    if (o.L0(strF0)) {
                        strF0 = "بی\u200cپاسخ";
                    }
                    cVarSt.D("hostError", strF0);
                    String strA = cVarSt.A("host", "");
                    j.d(strA, "optString(...)");
                    if (o.L0(strA)) {
                        str = ".";
                    } else {
                        str = " — همان قبلی «" + cVarSt.A("host", "") + "» به کار می\u200cرود.";
                    }
                    mamiApi.log("نشانی سرور فرمان پیدا نشد (" + strF0 + ")" + str);
                } else {
                    if (!j.a(cVarSt.A("host", ""), deadDropOutcomeResolve$default.getHost())) {
                        mamiApi.log("نشانی سرور فرمان: " + deadDropOutcomeResolve$default.getHost() + " (از " + (j.a(deadDropOutcomeResolve$default.getSource(), "github") ? "گیت\u200cهاب" : "گوگل\u200cداکس") + ").");
                        sticky = new Sticky(0, 0L);
                    }
                    cVarSt.D("host", deadDropOutcomeResolve$default.getHost());
                    cVarSt.D("hostSource", deadDropOutcomeResolve$default.getSource());
                    cVarSt.D("hostAt", Long.valueOf(System.currentTimeMillis()));
                    cVarSt.D("hostError", "");
                }
                mamiApi.m299saved1pmJ48();
                String strA2 = cVarSt.A("host", "");
                if (o.L0(strA2)) {
                    strA2 = null;
                }
                hostResult = new HostResult(strA2 != null, strA2, deadDropOutcomeResolve$default.getOk());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hostResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r7 < 300000) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String ensureHost() throws ApiException {
        sf.c cVarSt = st();
        String strA = cVarSt.A("host", "");
        long jCurrentTimeMillis = System.currentTimeMillis() - cVarSt.x(0L, "hostAt");
        long jCurrentTimeMillis2 = System.currentTimeMillis() - cVarSt.x(0L, "hostTriedAt");
        j.b(strA);
        if (o.L0(strA) || jCurrentTimeMillis >= 1800000) {
            if (!o.L0(strA)) {
                String strA2 = cVarSt.A("hostError", "");
                j.d(strA2, "optString(...)");
                if (!o.L0(strA2)) {
                }
            }
            String host = discoverHost().getHost();
            if (host != null) {
                return host;
            }
            throw new ApiException("no-host", "نشانی سرور فرمان مامی پیدا نشد (گوگل\u200cداکس و گیت\u200cهاب هیچ\u200cکدام جواب ندادند)", 0, 0, 12, null);
        }
        return strA;
    }

    public final sf.c ensureSession(boolean z10) {
        sf.c cVarRefresh;
        synchronized (sessionLock) {
            MamiApi mamiApi = INSTANCE;
            long jNowSec = mamiApi.nowSec();
            sf.c cVarW = z10 ? null : mamiApi.st().w("session");
            if (cVarW != null && cVarW.x(0L, "accessExpiresAt") > ((long) 60) + jNowSec) {
                return cVarW;
            }
            if (cVarW != null && cVarW.x(0L, "refreshExpiresAt") > jNowSec && (cVarRefresh = mamiApi.refresh(cVarW)) != null) {
                return cVarRefresh;
            }
            mamiApi.st().J("session");
            mamiApi.m299saved1pmJ48();
            return mamiApi.register();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    public final sf.c fetchCatalog(Long l6) throws Throwable {
        long jLongValue;
        Long lValueOf;
        int i = 0;
        Throwable th2 = null;
        sf.c cVarEnsureSession$default = ensureSession$default(this, false, 1, null);
        sf.c cVarW = st().w("catalog");
        String str = "revision";
        if (l6 != null) {
            jLongValue = l6.longValue();
        } else {
            jLongValue = 0;
            if (cVarW != null) {
                long jX = cVarW.x(0L, "revision");
                lValueOf = Long.valueOf(jX);
                if (jX <= 0) {
                    lValueOf = null;
                }
            } else {
                lValueOf = null;
            }
            if (lValueOf != null) {
                jLongValue = lValueOf.longValue();
            }
        }
        long j = jLongValue;
        boolean z10 = false;
        ApiException apiExceptionHttpError = null;
        while (true) {
            int[] iArr = PAYLOAD_VERSIONS;
            if (i >= iArr.length) {
                if (apiExceptionHttpError != null) {
                    throw apiExceptionHttpError;
                }
                throw new ApiException("catalog", "کاتالوگ گرفته نشد", 0, 0, 12, null);
            }
            int i10 = iArr[i];
            Recipient recipientFreshRecipient = MamiIdentity.INSTANCE.freshRecipient();
            MamiEnvelope mamiEnvelope = MamiEnvelope.INSTANCE;
            sf.c cVar = boot;
            if (cVar == null) {
                Throwable th3 = th2;
                j.k("boot");
                throw th3;
            }
            Request requestNewRequest = mamiEnvelope.newRequest(cVar.j("audience"), j, i10, recipientFreshRecipient, (96 & 16) != 0 ? 0L : clockOffset(), (96 & 32) != 0 ? null : null, (96 & 64) != 0 ? null : null);
            String strCatalogPath = catalogPath();
            String body = requestNewRequest.getBody();
            Charset charset = kotlin.text.a.f23859a;
            byte[] bytes = body.getBytes(charset);
            j.d(bytes, "getBytes(...)");
            String str2 = str;
            sf.c cVar2 = cVarEnsureSession$default;
            th2 = th2;
            Answer answerCall$default = call$default(this, strCatalogPath, null, null, bytes, cVarEnsureSession$default.A("accessToken", ""), 0L, null, null, 230, null);
            if (answerCall$default.getCode() == 400 && i < iArr.length - 1) {
                apiExceptionHttpError = httpError("کاتالوگ", answerCall$default);
                i++;
                cVarEnsureSession$default = cVar2;
            } else {
                if (answerCall$default.getCode() != 401 || z10) {
                    if (answerCall$default.getCode() == 403) {
                        throw new ApiException("blocked", "سرور مامی فعلاً به این دستگاه فهرست نمی\u200cدهد (کد ۴۰۳)", 403, 0, 8, null);
                    }
                    if (answerCall$default.getCode() != 200) {
                        throw httpError("کاتالوگ", answerCall$default);
                    }
                    try {
                        byte[] body2 = answerCall$default.getR().getBody();
                        RequestCtx ctx = requestNewRequest.getCtx();
                        Map<String, ? extends PublicKey> map = trusted;
                        j.b(map);
                        Opened openedOpen$default = MamiEnvelope.open$default(mamiEnvelope, body2, ctx, map, clockOffset(), null, null, 48, null);
                        try {
                            sf.c cVar3 = new sf.c(new String(openedOpen$default.getPlaintext(), charset));
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            sf.c cVar4 = new sf.c();
                            cVar4.D("payloadVersion", Integer.valueOf(i10));
                            cVar4.D(str2, Long.valueOf(openedOpen$default.getRevision()));
                            cVar4.D("issuedAt", Long.valueOf(openedOpen$default.getIssuedAt()));
                            cVar4.D("expiresAt", Long.valueOf(openedOpen$default.getExpiresAt()));
                            cVar4.D("fetchedAt", Long.valueOf(jCurrentTimeMillis));
                            cVar4.D("host", answerCall$default.getHost());
                            cVar4.D("payload", cVar3);
                            getStore().writeJson("catalog.json", cVar4);
                            sf.c cVarSt = st();
                            sf.c cVar5 = new sf.c();
                            cVar5.D("payloadVersion", Integer.valueOf(i10));
                            cVar5.D(str2, Long.valueOf(openedOpen$default.getRevision()));
                            cVar5.D("expiresAt", Long.valueOf(openedOpen$default.getExpiresAt()));
                            cVar5.D("fetchedAt", Long.valueOf(jCurrentTimeMillis));
                            cVarSt.D("catalog", cVar5);
                            m299saved1pmJ48();
                            log("کاتالوگ گرفته شد (نسخهٔ بار " + i10 + "، ویرایش " + openedOpen$default.getRevision() + ").");
                            return cVar4;
                        } catch (Exception unused) {
                            throw new ApiException("payload", "محتوای کاتالوگ JSON نبود", 0, 0, 12, null);
                        }
                    } catch (Exception e10) {
                        throw new ApiException("envelope", w0.n("کاتالوگ باز نشد (", e10.getMessage(), ") — امضا یا رمز پاسخ درست نبود"), 0, 0, 12, null);
                    }
                }
                log("سرور نشست را نپذیرفت — ثبت دوباره و درخواست دوباره.");
                cVarEnsureSession$default = ensureSession(true);
                z10 = true;
            }
            str = str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0070  */
    public final sf.c fetchExclusiveBridge() throws ApiException {
        Object objO;
        Answer answerAuthed = authed("device/exclusive-bridge", new sf.c());
        if (answerAuthed.getCode() == 404) {
            answerAuthed = authed("device/argo-bridge", new sf.c());
        }
        if (answerAuthed.getCode() == 403 || answerAuthed.getCode() == 404) {
            throw new ApiException("exclusive-off", "سرور مامی برای این دستگاه پل اختصاصی نداد", answerAuthed.getCode(), 0, 8, null);
        }
        int code = answerAuthed.getCode();
        if (200 > code || code >= 300) {
            throw httpError("پل اختصاصی", answerAuthed);
        }
        sf.c json = answerAuthed.getJson();
        if (json == null) {
            json = new sf.c();
        }
        Object objO2 = json.o("exclusiveBridge");
        String str = objO2 instanceof String ? (String) objO2 : null;
        if (str == null) {
            objO = json.o("argoBridge");
            if (objO instanceof String) {
                str = (String) objO;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
        } else {
            if (str.length() <= 0) {
                str = null;
            }
            if (str == null) {
                objO = json.o("argoBridge");
                if (objO instanceof String) {
                    str = (String) objO;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
            }
        }
        double dNumberOf = numberOf(json.o("revision"));
        if (str.length() == 0 || Double.isNaN(dNumberOf) || dNumberOf <= 0.0d || dNumberOf != Math.floor(dNumberOf)) {
            throw new ApiException("exclusive-shape", "پاسخ پل اختصاصی قالب درستی نداشت", 0, 0, 12, null);
        }
        MamiExclusive.decodeBlock$default(MamiExclusive.INSTANCE, str, null, 2, null);
        sf.c json2 = getStore().readJson("exclusive.json");
        if (json2 != null && j.a(json2.A("source", ""), "panel") && json2.x(0L, "revision") > ((long) dNumberOf)) {
            return json2;
        }
        sf.c cVarP = i.p("block", str, "source", "panel");
        long j = (long) dNumberOf;
        cVarP.D("revision", Long.valueOf(j));
        cVarP.D("at", Long.valueOf(System.currentTimeMillis()));
        getStore().writeJson("exclusive.json", cVarP);
        log(w0.k(j, ").", new StringBuilder("پل اختصاصی گرفته شد (ویرایش ")));
        return cVarP;
    }

    public final sf.c fetchExclusiveTemplate() throws ExclusiveException, ApiException {
        Answer answerCall$default = call$default(this, "/runtime-assets/v1/exclusive/data5.br", "GET", null, null, null, 25000L, null, "*/*", 92, null);
        int code = answerCall$default.getCode();
        if (200 > code || code >= 300) {
            throw httpError("الگوی پل اختصاصی", answerCall$default);
        }
        if (answerCall$default.getR().getBody().length > 262144) {
            throw new ApiException("too-large", "الگوی پل اختصاصی بیش از اندازه بزرگ بود", 0, 0, 12, null);
        }
        String string = o.n1(new String(answerCall$default.getR().getBody(), kotlin.text.a.f23863e)).toString();
        MamiExclusive.INSTANCE.decodeTemplate(string);
        sf.c cVar = new sf.c();
        cVar.D("text", string);
        cVar.D("at", Long.valueOf(System.currentTimeMillis()));
        getStore().writeJson("exclusive-remote.json", cVar);
        return cVar;
    }

    public final sf.c fetchHive(String purpose) throws ApiException {
        Object objM1004constructorimpl;
        j.e(purpose, "purpose");
        try {
            objM1004constructorimpl = sd.l.m1004constructorimpl((sd.j) networkOf.invoke());
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
        }
        sd.j jVar = new sd.j("wifi", "");
        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
            objM1004constructorimpl = jVar;
        }
        sd.j jVar2 = (sd.j) objM1004constructorimpl;
        Object obj = (String) jVar2.component1();
        String str = (String) jVar2.component2();
        sf.c cVar = new sf.c();
        com.mlmvpn.scanner.e.q(2, "v", "purpose", purpose, cVar);
        cVar.D(AetherScanService.EXTRA_TRANSPORT, obj);
        if (j.a(obj, "cellular") && i.B("^\\d{5,6}$", str)) {
            cVar.D("carrier", str);
        }
        Answer answerAuthed = authed("device/hive", cVar);
        if (answerAuthed.getCode() == 403 || answerAuthed.getCode() == 404) {
            throw new ApiException("hive-off", "لیون فعلاً برای این دستگاه روشن نیست (سرور مامی فهرستی نداد)", answerAuthed.getCode(), 0, 8, null);
        }
        if (answerAuthed.getCode() != 200) {
            throw httpError("فهرست لیون", answerAuthed);
        }
        sf.c json = answerAuthed.getJson();
        if (json == null || answerAuthed.getR().getBody().length > 262144) {
            throw new ApiException("hive-shape", "فهرست لیون قالب درستی نداشت", 0, 0, 12, null);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        sf.c cVar2 = new sf.c();
        cVar2.D("fetchedAt", Long.valueOf(jCurrentTimeMillis));
        cVar2.D("host", answerAuthed.getHost());
        cVar2.D("payload", json);
        getStore().writeJson("hive.json", cVar2);
        sf.a aVarV = json.v("servers");
        int size = aVarV != null ? aVarV.f67155a.size() : 0;
        double dNumberOf = numberOf(json.o("revision"));
        long j = Double.isNaN(dNumberOf) ? 0L : (long) dNumberOf;
        sf.c cVarSt = st();
        sf.c cVar3 = new sf.c();
        cVar3.D("fetchedAt", Long.valueOf(jCurrentTimeMillis));
        cVar3.D("revision", Long.valueOf(j));
        cVar3.D(NotificationBadge.NewHtcHomeBadger.COUNT, Integer.valueOf(size));
        cVarSt.D("hive", cVar3);
        m299saved1pmJ48();
        log("فهرست لیون گرفته شد (" + size + " پل، ویرایش " + j + ").");
        return cVar2;
    }

    public final void forget(boolean z10) {
        sf.c cVarSt = st();
        Iterator it = r.a0("session", "registeredAt", "catalog", "hive").iterator();
        while (it.hasNext()) {
            cVarSt.J((String) it.next());
        }
        m299saved1pmJ48();
        getStore().delete("catalog.json");
        getStore().delete("hive.json");
        getStore().delete("exclusive.json");
        if (z10) {
            MamiIdentity.INSTANCE.forget(getStore());
        }
    }

    public final ee.a getNetworkOf() {
        return networkOf;
    }

    public final int[] getPAYLOAD_VERSIONS() {
        return PAYLOAD_VERSIONS;
    }

    public final MamiStore getStore() {
        MamiStore mamiStore = store;
        if (mamiStore != null) {
            return mamiStore;
        }
        j.k("store");
        throw null;
    }

    public final synchronized void init(File dir, String bootText, String ua2, sf.c clientInfo) {
        try {
            j.e(dir, "dir");
            j.e(bootText, "bootText");
            j.e(ua2, "ua");
            j.e(clientInfo, "clientInfo");
            if (ready) {
                return;
            }
            store = new MamiFileStore(dir);
            boot = new sf.c(bootText);
            MamiEnvelope mamiEnvelope = MamiEnvelope.INSTANCE;
            sf.c cVar = boot;
            if (cVar == null) {
                j.k("boot");
                throw null;
            }
            trusted = mamiEnvelope.loadTrustedKeys(cVar.g("trustedSigningKeys"));
            if (!o.L0(ua2)) {
                userAgent = ua2;
            }
            client = clientInfo;
            ready = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void noteClock(String str) {
        Object objM1004constructorimpl;
        if (str == null || o.L0(str)) {
            return;
        }
        try {
            Date date = httpDate().parse(str);
            objM1004constructorimpl = sd.l.m1004constructorimpl(date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th2));
        }
        Long l6 = (Long) (sd.l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
        if (l6 != null) {
            long jLongValue = l6.longValue();
            if (jLongValue <= 0) {
                return;
            }
            long jFloorDiv = Math.floorDiv(jLongValue - System.currentTimeMillis(), 1000L);
            if (Math.abs(jFloorDiv - clockOffset()) >= 2) {
                st().D("clockOffsetSec", Long.valueOf(jFloorDiv));
                m299saved1pmJ48();
            }
        }
    }

    public final long nowSec() {
        return clockOffset() + (System.currentTimeMillis() / ((long) 1000));
    }

    public final void route(String profile, String locationId, boolean z10) throws ApiException {
        j.e(profile, "profile");
        j.e(locationId, "locationId");
        if (!new l("^[A-Za-z0-9_-]{1,64}$").matches(locationId)) {
            throw new ApiException("bad-location", "شناسهٔ مکان نامعتبر است", 0, 0, 12, null);
        }
        if (!i.B("^[A-Z][A-Z0-9]{1,7}$", profile)) {
            throw new ApiException("bad-profile", "پروفایل نامعتبر است", 0, 0, 12, null);
        }
        sf.c cVarP = i.p("profile", profile, "locationId", locationId);
        cVarP.D("selection", z10 ? "user" : "automatic");
        Answer answerAuthed = authed("device/route", cVarP);
        int code = answerAuthed.getCode();
        if (200 > code || code >= 300) {
            throw httpError("انتخاب مکان", answerAuthed);
        }
        log(d1.h("انتخاب مکان به سرور مامی گفته شد (", locationId, "، ", profile, ")."));
    }

    public final sf.c savedCatalog() {
        return getStore().readJson("catalog.json");
    }

    public final sf.c savedExclusive() {
        return getStore().readJson("exclusive.json");
    }

    public final sf.c savedExclusiveTemplate() {
        return getStore().readJson("exclusive-remote.json");
    }

    public final sf.c savedHive() {
        return getStore().readJson("hive.json");
    }

    public final void setLogger(ee.c fn) {
        j.e(fn, "fn");
        logFn = fn;
    }

    public final void setNetworkOf(ee.a aVar) {
        j.e(aVar, "<set-?>");
        networkOf = aVar;
    }

    public final Summary summary() {
        sf.c cVarSt = st();
        sf.c cVarW = cVarSt.w("session");
        sf.c cVarW2 = cVarSt.w("catalog");
        sf.c cVarW3 = cVarSt.w("hive");
        String strA = cVarSt.A("host", "");
        String str = o.L0(strA) ? null : strA;
        String strA2 = cVarSt.A("hostSource", "");
        String str2 = o.L0(strA2) ? null : strA2;
        long jX = cVarSt.x(0L, "hostAt");
        String strA3 = cVarSt.A("hostError", "");
        j.d(strA3, "optString(...)");
        return new Summary(str, str2, jX, strA3, cVarW != null, cVarSt.x(0L, "registeredAt"), cVarW != null ? cVarW.x(0L, "accessExpiresAt") : 0L, clockOffset(), cVarW2 != null ? cVarW2.x(0L, "revision") : 0L, cVarW2 != null ? cVarW2.t(0, "payloadVersion") : 0, cVarW2 != null ? cVarW2.x(0L, "expiresAt") : 0L, cVarW2 != null ? cVarW2.x(0L, "fetchedAt") : 0L, cVarW2 != null, cVarW3 != null ? cVarW3.x(0L, "fetchedAt") : 0L, cVarW3 != null ? cVarW3.t(0, NotificationBadge.NewHtcHomeBadger.COUNT) : 0, cVarW3 != null ? cVarW3.x(0L, "revision") : 0L, cVarW3 != null);
    }
}
