package com.mlmvpn.scanner.engines.mami;

import com.mlmvpn.scanner.backup.BackupFile;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import kotlin.collections.d0;
import kotlin.collections.q;
import kotlin.jvm.internal.j;
import kotlin.text.o;
import kotlin.text.v;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$3;
import okhttp3.Response;
import okhttp3.ResponseBody;
import sd.l;
import sd.m;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiNet {
    public static final MamiNet INSTANCE = new MamiNet();
    private static volatile ee.a routeOf = new ee.a() { // from class: com.mlmvpn.scanner.engines.mami.MamiNet$routeOf$1
        @Override // ee.a
        public final Void invoke() {
            return null;
        }
    };
    private static final sd.e base$delegate = m9.d.A(new a(4));
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Route {
        public static final int $stable = 8;
        private final String label;
        private final Proxy proxy;

        public Route(Proxy proxy, String label) {
            j.e(proxy, "proxy");
            j.e(label, "label");
            this.proxy = proxy;
            this.label = label;
        }

        public static /* synthetic */ Route copy$default(Route route, Proxy proxy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                proxy = route.proxy;
            }
            if ((i & 2) != 0) {
                str = route.label;
            }
            return route.copy(proxy, str);
        }

        public final Proxy component1() {
            return this.proxy;
        }

        public final String component2() {
            return this.label;
        }

        public final Route copy(Proxy proxy, String label) {
            j.e(proxy, "proxy");
            j.e(label, "label");
            return new Route(proxy, label);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Route)) {
                return false;
            }
            Route route = (Route) obj;
            return j.a(this.proxy, route.proxy) && j.a(this.label, route.label);
        }

        public final String getLabel() {
            return this.label;
        }

        public final Proxy getProxy() {
            return this.proxy;
        }

        public int hashCode() {
            return this.label.hashCode() + (this.proxy.hashCode() * 31);
        }

        public String toString() {
            return "Route(proxy=" + this.proxy + ", label=" + this.label + ")";
        }
    }

    private MamiNet() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient base_delegate$lambda$0() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.f29106f = false;
        return new OkHttpClient(builder);
    }

    private final OkHttpClient getBase() {
        return (OkHttpClient) base$delegate.getValue();
    }

    private final Resp once(String str, String str2, Map<String, String> map, byte[] bArr, String str3, long j, long j10, boolean z10, Route route) {
        String label;
        Proxy proxy;
        RequestBody$Companion$toRequestBody$3 requestBody$Companion$toRequestBody$3C;
        boolean z11;
        byte[] bArrC;
        String str4;
        Object next;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (route == null || (label = route.getLabel()) == null) {
            label = "مستقیم";
        }
        try {
            OkHttpClient.Builder builderA = getBase().a();
            if (route == null || (proxy = route.getProxy()) == null) {
                proxy = Proxy.NO_PROXY;
            }
            builderA.e(proxy);
            builderA.i = z10;
            builderA.j = z10;
            long jMin = Math.min(j, 10000L);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builderA.b(jMin, timeUnit);
            builderA.g(j, timeUnit);
            builderA.j(j, timeUnit);
            builderA.a(j + ((long) 2000), timeUnit);
            OkHttpClient okHttpClient = new OkHttpClient(builderA);
            String upperCase = str2.toUpperCase(Locale.ROOT);
            j.d(upperCase, "toUpperCase(...)");
            if (bArr == null || upperCase.equals("GET") || upperCase.equals("HEAD")) {
                requestBody$Companion$toRequestBody$3C = (upperCase.equals("POST") || upperCase.equals("PUT")) ? RequestBody.Companion.c(RequestBody.Companion, new byte[0], null, 0, 6) : null;
            } else {
                if (str3 == null) {
                    Iterator<T> it = map.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!v.m0((String) ((Map.Entry) next).getKey(), "Content-Type"));
                    Map.Entry entry = (Map.Entry) next;
                    str4 = entry != null ? (String) entry.getValue() : null;
                    if (str4 == null) {
                        str4 = BackupFile.MIME;
                    }
                } else {
                    str4 = str3;
                }
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.f29058d.getClass();
                requestBody$Companion$toRequestBody$3C = RequestBody.Companion.c(companion, bArr, MediaType.Companion.a(str4), 0, 6);
            }
            okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
            builder.j(str);
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                String key = entry2.getKey();
                String value = entry2.getValue();
                if (!v.m0(key, "Content-Type") || requestBody$Companion$toRequestBody$3C == null) {
                    builder.d(key, value);
                }
            }
            builder.f(upperCase, requestBody$Companion$toRequestBody$3C);
            Response responseD = okHttpClient.b(new okhttp3.Request(builder)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                Headers headers = responseD.f29155f;
                we.j jVarJ = responseBody != null ? responseBody.j() : null;
                if (jVarJ == null) {
                    bArrC = new byte[0];
                    z11 = false;
                } else {
                    jVarJ.request(1 + j10);
                    long j11 = jVarJ.a().f70283b;
                    z11 = j11 > j10;
                    bArrC = jVarJ.a().C(Math.min(j11, j10));
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str5 : headers.g()) {
                    String lowerCase = str5.toLowerCase(Locale.ROOT);
                    j.d(lowerCase, "toLowerCase(...)");
                    linkedHashMap.put(lowerCase, q.G0(headers.l(str5)));
                }
                String str6 = label;
                try {
                    Resp resp = new Resp(responseD.f29153d, linkedHashMap, bArrC, System.currentTimeMillis() - jCurrentTimeMillis, "", str6, z11);
                    responseD.close();
                    return resp;
                } catch (Throwable th2) {
                    th = th2;
                    label = str6;
                    Throwable th3 = th;
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        a.a.g(responseD, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            return new Resp(0, d0.E(), new byte[0], System.currentTimeMillis() - jCurrentTimeMillis, why(th6), label, false, 64, null);
        }
    }

    public final ee.a getRouteOf() {
        return routeOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Resp request(String url, String method, Map<String, String> headers, byte[] bArr, String str, long j, long j10, boolean z10, boolean z11) {
        Object objM1004constructorimpl;
        j.e(url, "url");
        j.e(method, "method");
        j.e(headers, "headers");
        Object obj = null;
        if (!z11) {
            try {
                objM1004constructorimpl = l.m1004constructorimpl((Route) routeOf.invoke());
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
            obj = (Route) (l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
        }
        Route route = obj;
        Resp respOnce = once(url, method, headers, bArr, str, j, j10, z10, route);
        return (respOnce.getCode() != 0 || route == 0) ? respOnce : once(url, method, headers, bArr, str, j, j10, z10, null);
    }

    public final void setRouteOf(ee.a aVar) {
        j.e(aVar, "<set-?>");
        routeOf = aVar;
    }

    public final Route socksRoute(int i, String label) {
        j.e(label, "label");
        return new Route(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(SniSession.LOCAL_HOST, i)), label);
    }

    public final String why(Throwable e10) {
        j.e(e10, "e");
        if (e10 instanceof UnknownHostException) {
            return "نام سرور پیدا نشد";
        }
        if (e10 instanceof ConnectException) {
            return "اتصال رد شد";
        }
        if ((e10 instanceof SocketTimeoutException) || (e10 instanceof InterruptedIOException)) {
            return "بی\u200cپاسخ (مهلت تمام شد)";
        }
        if (e10 instanceof SSLException) {
            return "دست\u200cدادن TLS نشد (احتمالاً فیلتر)";
        }
        String message = e10.getMessage();
        if (message == null) {
            message = "";
        }
        if (o.y0(message, "reset", true)) {
            return "اتصال در میانه قطع شد (احتمالاً فیلتر)";
        }
        String message2 = e10.getMessage();
        if (message2 == null) {
            message2 = e10.getClass().getSimpleName();
        }
        return o.l1(160, message2);
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Resp {
        public static final int $stable = 8;
        private final byte[] body;
        private final int code;
        private final String error;
        private final Map<String, String> headers;
        private final sd.e json$delegate;
        private final long ms;
        private final boolean truncated;
        private final String via;

        public Resp(int i, Map<String, String> headers, byte[] body, long j, String error, String via, boolean z10) {
            j.e(headers, "headers");
            j.e(body, "body");
            j.e(error, "error");
            j.e(via, "via");
            this.code = i;
            this.headers = headers;
            this.body = body;
            this.ms = j;
            this.error = error;
            this.via = via;
            this.truncated = z10;
            this.json$delegate = m9.d.A(new d(this, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sf.c json_delegate$lambda$1(Resp resp) {
            Object objM1004constructorimpl;
            String string = o.r1(resp.getText()).toString();
            if (!v.s0(string, "{", false)) {
                return null;
            }
            try {
                objM1004constructorimpl = l.m1004constructorimpl(new sf.c(string));
            } catch (Throwable th2) {
                objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
            }
            return (sf.c) (l.m1010isFailureimpl(objM1004constructorimpl) ? null : objM1004constructorimpl);
        }

        public final byte[] getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getError() {
            return this.error;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final sf.c getJson() {
            return (sf.c) this.json$delegate.getValue();
        }

        public final long getMs() {
            return this.ms;
        }

        public final String getText() {
            return new String(this.body, kotlin.text.a.f23859a);
        }

        public final boolean getTruncated() {
            return this.truncated;
        }

        public final String getVia() {
            return this.via;
        }

        public /* synthetic */ Resp(int i, Map map, byte[] bArr, long j, String str, String str2, boolean z10, int i10, kotlin.jvm.internal.e eVar) {
            this(i, map, bArr, j, str, str2, (i10 & 64) != 0 ? false : z10);
        }
    }
}
