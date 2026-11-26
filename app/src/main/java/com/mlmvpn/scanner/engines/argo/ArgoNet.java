package com.mlmvpn.scanner.engines.argo;

import a6.w0;
import androidx.media3.common.s;
import com.mlmvpn.scanner.data.studio.central.Central;
import com.mlmvpn.scanner.engines.rstaspoof.SniSession;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.j;
import kotlin.text.o;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.telegram.ui.Cells.d1;
import we.h;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoNet {
    public static final ArgoNet INSTANCE = new ArgoNet();
    private static final sd.e base$delegate = m9.d.A(new f(2));
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Auth {
        public static final int $stable = 8;
        private final int code;
        private final String error;
        private final boolean fatal;
        private final ArgoProtocol.SessionInfo info;
        private final long ms;
        private final boolean ok;

        public Auth(boolean z10, long j, int i, boolean z11, String error, ArgoProtocol.SessionInfo sessionInfo) {
            j.e(error, "error");
            this.ok = z10;
            this.ms = j;
            this.code = i;
            this.fatal = z11;
            this.error = error;
            this.info = sessionInfo;
        }

        public static /* synthetic */ Auth copy$default(Auth auth, boolean z10, long j, int i, boolean z11, String str, ArgoProtocol.SessionInfo sessionInfo, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = auth.ok;
            }
            if ((i10 & 2) != 0) {
                j = auth.ms;
            }
            if ((i10 & 4) != 0) {
                i = auth.code;
            }
            if ((i10 & 8) != 0) {
                z11 = auth.fatal;
            }
            if ((i10 & 16) != 0) {
                str = auth.error;
            }
            if ((i10 & 32) != 0) {
                sessionInfo = auth.info;
            }
            return auth.copy(z10, j, i, z11, str, sessionInfo);
        }

        public final boolean component1() {
            return this.ok;
        }

        public final long component2() {
            return this.ms;
        }

        public final int component3() {
            return this.code;
        }

        public final boolean component4() {
            return this.fatal;
        }

        public final String component5() {
            return this.error;
        }

        public final ArgoProtocol.SessionInfo component6() {
            return this.info;
        }

        public final Auth copy(boolean z10, long j, int i, boolean z11, String error, ArgoProtocol.SessionInfo sessionInfo) {
            j.e(error, "error");
            return new Auth(z10, j, i, z11, error, sessionInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Auth)) {
                return false;
            }
            Auth auth = (Auth) obj;
            return this.ok == auth.ok && this.ms == auth.ms && this.code == auth.code && this.fatal == auth.fatal && j.a(this.error, auth.error) && j.a(this.info, auth.info);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getError() {
            return this.error;
        }

        public final boolean getFatal() {
            return this.fatal;
        }

        public final ArgoProtocol.SessionInfo getInfo() {
            return this.info;
        }

        public final long getMs() {
            return this.ms;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public int hashCode() {
            int iD = s.d(w0.d(androidx.compose.foundation.interaction.f.c(this.code, w0.c(Boolean.hashCode(this.ok) * 31, 31, this.ms), 31), 31, this.fatal), 31, this.error);
            ArgoProtocol.SessionInfo sessionInfo = this.info;
            return iD + (sessionInfo == null ? 0 : sessionInfo.hashCode());
        }

        public String toString() {
            return "Auth(ok=" + this.ok + ", ms=" + this.ms + ", code=" + this.code + ", fatal=" + this.fatal + ", error=" + this.error + ", info=" + this.info + ")";
        }

        public /* synthetic */ Auth(boolean z10, long j, int i, boolean z11, String str, ArgoProtocol.SessionInfo sessionInfo, int i10, kotlin.jvm.internal.e eVar) {
            this(z10, j, (i10 & 4) != 0 ? 0 : i, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? "" : str, (i10 & 32) != 0 ? null : sessionInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Route {
        public static final int $stable = 8;
        private final String label;
        private final Proxy proxy;

        public Route(Proxy proxy, String label) {
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
            Proxy proxy = this.proxy;
            return this.label.hashCode() + ((proxy == null ? 0 : proxy.hashCode()) * 31);
        }

        public String toString() {
            return "Route(proxy=" + this.proxy + ", label=" + this.label + ")";
        }
    }

    private ArgoNet() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient base_delegate$lambda$0() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.i = false;
        builder.j = false;
        builder.f29106f = false;
        return new OkHttpClient(builder);
    }

    public static /* synthetic */ sd.j fetchText$default(ArgoNet argoNet, String str, Route route, long j, long j10, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 25000;
        }
        long j11 = j;
        if ((i & 8) != 0) {
            j10 = 8000000;
        }
        return argoNet.fetchText(str, route, j11, j10);
    }

    private static final sd.j fetchText$once(long j, String str, long j10, Proxy proxy) {
        String strE;
        try {
            OkHttpClient.Builder builderA = INSTANCE.getBase().a();
            builderA.i = true;
            builderA.j = true;
            if (proxy == null) {
                proxy = Proxy.NO_PROXY;
            }
            builderA.e(proxy);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builderA.b(j, timeUnit);
            builderA.g(j, timeUnit);
            builderA.a(j + ((long) Central.MAX_USERS), timeUnit);
            OkHttpClient okHttpClient = new OkHttpClient(builderA);
            Request.Builder builder = new Request.Builder();
            builder.j(str);
            builder.d("User-Agent", "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0 Mobile Safari/537.36");
            Response responseD = okHttpClient.b(new Request(builder)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                we.j jVarJ = responseBody != null ? responseBody.j() : null;
                if (jVarJ == null) {
                    strE = "";
                } else {
                    jVarJ.request(j10);
                    h hVarA = jVarJ.a();
                    long jMin = Math.min(jVarJ.a().f70283b, j10);
                    hVarA.getClass();
                    strE = hVarA.E(jMin, kotlin.text.a.f23859a);
                }
                sd.j jVar = new sd.j(Integer.valueOf(responseD.f29153d), strE);
                responseD.close();
                return jVar;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    a.a.g(responseD, th2);
                    throw th3;
                }
            }
        } catch (Throwable unused) {
            return new sd.j(0, "");
        }
    }

    private final OkHttpClient getBase() {
        return (OkHttpClient) base$delegate.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0184, code lost:
    
        if (kotlin.text.o.y0(r2, "certificate", true) != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Auth authenticate(final String host, int i, final String connectIp, String protocol, long j, long j10) {
        String str;
        int i10;
        Auth auth;
        j.e(host, "host");
        j.e(connectIp, "connectIp");
        j.e(protocol, "protocol");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ArgoProtocol argoProtocol = ArgoProtocol.INSTANCE;
            ArgoProtocol.AuthRequest authRequestAuthRequest$default = ArgoProtocol.authRequest$default(argoProtocol, protocol, 0L, j10, 2, null);
            OkHttpClient.Builder builderA = getBase().a();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builderA.b(j, timeUnit);
            builderA.g(j, timeUnit);
            builderA.a(j + ((long) 2000), timeUnit);
            if (!o.L0(connectIp)) {
                builderA.c(new Dns() { // from class: com.mlmvpn.scanner.engines.argo.ArgoNet$authenticate$client$1$1
                    @Override // okhttp3.Dns
                    public List<InetAddress> lookup(String hostname) {
                        j.e(hostname, "hostname");
                        return hostname.equalsIgnoreCase(host) ? m9.d.B(InetAddress.getByName(o.o1(connectIp, '[', ']'))) : Dns.K.lookup(hostname);
                    }
                });
            }
            OkHttpClient okHttpClient = new OkHttpClient(builderA);
            String strG = d1.g("https://", host, i != 443 ? f0.a.h(i, ":") : "", "/");
            Request.Builder builder = new Request.Builder();
            builder.j(strG);
            builder.d("Authorization", authRequestAuthRequest$default.getHeader());
            builder.d("User-Agent", ArgoProtocol.USER_AGENT);
            builder.d("Accept", "*/*");
            try {
                Response responseD = okHttpClient.b(new Request(builder)).d();
                try {
                    int i11 = responseD.f29153d;
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (200 <= i11 && i11 < 300) {
                        ResponseBody responseBody = responseD.f29156h;
                        String strW = responseBody != null ? responseBody.w() : null;
                        if (strW == null) {
                            strW = "";
                        }
                        try {
                            i10 = i11;
                            try {
                                auth = new Auth(true, jCurrentTimeMillis2, i10, false, null, argoProtocol.openAnswer(authRequestAuthRequest$default, o.n1(o.l1(65536, strW)).toString(), j10), 24, null);
                            } catch (Throwable unused) {
                                auth = new Auth(false, jCurrentTimeMillis2, i10, true, "پاسخ سرور باز نشد — این دامنه سرور آرگو نیست", null, 32, null);
                            }
                        } catch (Throwable unused2) {
                            i10 = i11;
                        }
                        responseD.close();
                        return auth;
                    }
                    boolean z10 = i11 == 521 || i11 == 522 || i11 == 523 || i11 == 530;
                    if (z10) {
                        str = "سرور پشت این دامنه خاموش است یا دامنه دیگر به آرگو اشاره نمی\u200cکند";
                    } else if (i11 == 403 || i11 == 401) {
                        str = "سرور درخواست را نپذیرفت";
                    } else {
                        str = i11 == 404 ? "این دامنه سرور آرگو نیست" : "پاسخ نامعتبر";
                    }
                    Auth auth2 = new Auth(false, jCurrentTimeMillis2, i11, z10 || i11 == 404, str + " (کد " + i11 + ")", null, 32, null);
                    responseD.close();
                    return auth2;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        a.a.g(responseD, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (!o.L0(connectIp)) {
                    if (!(th4 instanceof SSLPeerUnverifiedException)) {
                        if (th4 instanceof SSLException) {
                            String message = th4.getMessage();
                            if (message == null) {
                                message = "";
                            }
                        }
                    }
                    return new Auth(false, jCurrentTimeMillis3, 0, true, "این دامنه دیگر پشت کلادفلر نیست", null, 36, null);
                }
                if (th4 instanceof UnknownHostException) {
                    return new Auth(false, jCurrentTimeMillis3, 0, true, "دامنه دیگر وجود ندارد", null, 36, null);
                }
                if (th4 instanceof ConnectException) {
                    return new Auth(false, jCurrentTimeMillis3, 0, false, "اتصال رد شد", null, 44, null);
                }
                if ((th4 instanceof SocketTimeoutException) || (th4 instanceof InterruptedIOException)) {
                    return new Auth(false, jCurrentTimeMillis3, 0, false, "بی\u200cپاسخ (مهلت تمام شد)", null, 44, null);
                }
                if (th4 instanceof IOException) {
                    String message2 = th4.getMessage();
                    if (o.y0(message2 != null ? message2 : "", "reset", true)) {
                        return new Auth(false, jCurrentTimeMillis3, 0, false, "اتصال در میانه قطع شد (احتمالاً فیلتر)", null, 44, null);
                    }
                }
                String message3 = th4.getMessage();
                if (message3 == null) {
                    message3 = "خطای شبکه";
                }
                return new Auth(false, jCurrentTimeMillis3, 0, false, message3, null, 44, null);
            }
        } catch (Throwable th5) {
            return new Auth(false, 0L, 0, false, v0.a.h("ساخت درخواست ناموفق بود: ", th5.getMessage()), null, 44, null);
        }
    }

    public final sd.j fetchText(String url, Route route, long j, long j10) {
        j.e(url, "url");
        sd.j jVarFetchText$once = fetchText$once(j, url, j10, route != null ? route.getProxy() : null);
        if (((Number) jVarFetchText$once.getFirst()).intValue() != 0) {
            return jVarFetchText$once;
        }
        return (route != null ? route.getProxy() : null) != null ? fetchText$once(j, url, j10, null) : jVarFetchText$once;
    }

    public final sd.j sessionRequest(String kind, String host, int i, ArgoProtocol.SessionInfo info, int i10, long j) {
        j.e(kind, "kind");
        j.e(host, "host");
        j.e(info, "info");
        return sessionRequest(kind, host, i, info, new Proxy(Proxy.Type.HTTP, new InetSocketAddress(SniSession.LOCAL_HOST, i10)), j);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b3  */
    public final sd.j sessionRequest(String kind, String host, int i, ArgoProtocol.SessionInfo info, Proxy proxy, long j) {
        String str;
        boolean z10;
        j.e(kind, "kind");
        j.e(host, "host");
        j.e(info, "info");
        j.e(proxy, "proxy");
        try {
            OkHttpClient.Builder builderA = getBase().a();
            builderA.e(proxy);
            builderA.a(j, TimeUnit.MILLISECONDS);
            OkHttpClient okHttpClient = new OkHttpClient(builderA);
            String str2 = "";
            if (i != 443) {
                str = ":" + i;
            } else {
                str = "";
            }
            String str3 = "https://" + host + str + "/";
            Request.Builder builder = new Request.Builder();
            builder.j(str3);
            builder.d("Authorization", ArgoProtocol.sessionHeader$default(ArgoProtocol.INSTANCE, kind, info, 0L, 4, null));
            builder.d("User-Agent", ArgoProtocol.USER_AGENT);
            Response responseD = okHttpClient.b(new Request(builder)).d();
            try {
                ResponseBody responseBody = responseD.f29156h;
                int i10 = responseD.f29153d;
                String strW = responseBody != null ? responseBody.w() : null;
                if (strW != null) {
                    str2 = strW;
                }
                if (200 > i10 || i10 >= 300) {
                    z10 = false;
                } else {
                    z10 = true;
                    if (str2.length() % 2 != 1) {
                        z10 = false;
                    }
                }
                sd.j jVar = new sd.j(Boolean.valueOf(z10), Integer.valueOf(i10));
                responseD.close();
                return jVar;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    a.a.g(responseD, th2);
                    throw th3;
                }
            }
        } catch (Throwable unused) {
            return new sd.j(Boolean.FALSE, 0);
        }
    }
}
