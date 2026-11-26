package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import androidx.media3.common.s;
import com.mlmvpn.core.aether.i;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.utils.CfUnfilter;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.Inflater;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.collections.a0;
import kotlin.collections.b0;
import kotlin.collections.d0;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.text.l;
import kotlin.text.o;
import kotlin.text.v;
import org.telegram.ui.Cells.d1;
import sd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiExclusive {
    public static final String BRIDGE_KEY_SPKI = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwVEhfRU709R1WPT3cVgu2beUJGJ7OHk27uQjfc6PxpLdg+GKqm/t8c2GMH6FCgcRsB+s8FH+YD8gXiiE5b4g/Q==";
    public static final int MAX = 262144;
    public static final MamiExclusive INSTANCE = new MamiExclusive();
    private static final List<String> KINDS = r.a0("ARGO VPN BRIDGE BLOCK", "EXCLUSIVE VPN BRIDGE BLOCK");
    private static final Map<String, String> HELLO_PROTOCOL = d0.J(new j("safari604", "A"), new j("chm100", "B"));
    private static final Map<String, String> HELLO_FINGERPRINT = d0.J(new j("safari604", "ios"), new j("safari605", CfUnfilter.LOCAL_FRONT_FINGERPRINT), new j("chm100", MamiXrayConfig.FP), new j("chm106", MamiXrayConfig.FP), new j("chm-cf", MamiXrayConfig.FP));
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Bridge {
        public static final int $stable = 8;
        private final String echConfig;
        private final Map<String, Object> headers;
        private final String kind;
        private final sf.c payload;
        private final int port;
        private final String server;

        public Bridge(String kind, String server, int i, Map<String, ? extends Object> map, String echConfig, sf.c payload) {
            kotlin.jvm.internal.j.e(kind, "kind");
            kotlin.jvm.internal.j.e(server, "server");
            kotlin.jvm.internal.j.e(echConfig, "echConfig");
            kotlin.jvm.internal.j.e(payload, "payload");
            this.kind = kind;
            this.server = server;
            this.port = i;
            this.headers = map;
            this.echConfig = echConfig;
            this.payload = payload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bridge copy$default(Bridge bridge, String str, String str2, int i, Map map, String str3, sf.c cVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bridge.kind;
            }
            if ((i10 & 2) != 0) {
                str2 = bridge.server;
            }
            if ((i10 & 4) != 0) {
                i = bridge.port;
            }
            if ((i10 & 8) != 0) {
                map = bridge.headers;
            }
            if ((i10 & 16) != 0) {
                str3 = bridge.echConfig;
            }
            if ((i10 & 32) != 0) {
                cVar = bridge.payload;
            }
            String str4 = str3;
            sf.c cVar2 = cVar;
            return bridge.copy(str, str2, i, map, str4, cVar2);
        }

        public final String component1() {
            return this.kind;
        }

        public final String component2() {
            return this.server;
        }

        public final int component3() {
            return this.port;
        }

        public final Map<String, Object> component4() {
            return this.headers;
        }

        public final String component5() {
            return this.echConfig;
        }

        public final sf.c component6() {
            return this.payload;
        }

        public final Bridge copy(String kind, String server, int i, Map<String, ? extends Object> map, String echConfig, sf.c payload) {
            kotlin.jvm.internal.j.e(kind, "kind");
            kotlin.jvm.internal.j.e(server, "server");
            kotlin.jvm.internal.j.e(echConfig, "echConfig");
            kotlin.jvm.internal.j.e(payload, "payload");
            return new Bridge(kind, server, i, map, echConfig, payload);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Bridge)) {
                return false;
            }
            Bridge bridge = (Bridge) obj;
            return kotlin.jvm.internal.j.a(this.kind, bridge.kind) && kotlin.jvm.internal.j.a(this.server, bridge.server) && this.port == bridge.port && kotlin.jvm.internal.j.a(this.headers, bridge.headers) && kotlin.jvm.internal.j.a(this.echConfig, bridge.echConfig) && kotlin.jvm.internal.j.a(this.payload, bridge.payload);
        }

        public final String getEchConfig() {
            return this.echConfig;
        }

        public final Map<String, Object> getHeaders() {
            return this.headers;
        }

        public final String getKind() {
            return this.kind;
        }

        public final sf.c getPayload() {
            return this.payload;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getServer() {
            return this.server;
        }

        public int hashCode() {
            int iC = androidx.compose.foundation.interaction.f.c(this.port, s.d(this.kind.hashCode() * 31, 31, this.server), 31);
            Map<String, Object> map = this.headers;
            return this.payload.hashCode() + s.d((iC + (map == null ? 0 : map.hashCode())) * 31, 31, this.echConfig);
        }

        public String toString() {
            String str = this.kind;
            String str2 = this.server;
            int i = this.port;
            Map<String, Object> map = this.headers;
            String str3 = this.echConfig;
            sf.c cVar = this.payload;
            StringBuilder sbN = s.n("Bridge(kind=", str, ", server=", str2, ", port=");
            sbN.append(i);
            sbN.append(", headers=");
            sbN.append(map);
            sbN.append(", echConfig=");
            sbN.append(str3);
            sbN.append(", payload=");
            sbN.append(cVar);
            sbN.append(")");
            return sbN.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Endpoint {
        public static final int $stable = 8;
        private final String clientHello;
        private final String echConfig;
        private final Map<String, String> headers;
        private final String host;
        private final String hostName;
        private final int port;
        private final String protocol;

        public Endpoint(String host, int i, String hostName, Map<String, String> headers, String clientHello, String protocol, String echConfig) {
            kotlin.jvm.internal.j.e(host, "host");
            kotlin.jvm.internal.j.e(hostName, "hostName");
            kotlin.jvm.internal.j.e(headers, "headers");
            kotlin.jvm.internal.j.e(clientHello, "clientHello");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(echConfig, "echConfig");
            this.host = host;
            this.port = i;
            this.hostName = hostName;
            this.headers = headers;
            this.clientHello = clientHello;
            this.protocol = protocol;
            this.echConfig = echConfig;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Endpoint copy$default(Endpoint endpoint, String str, int i, String str2, Map map, String str3, String str4, String str5, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = endpoint.host;
            }
            if ((i10 & 2) != 0) {
                i = endpoint.port;
            }
            if ((i10 & 4) != 0) {
                str2 = endpoint.hostName;
            }
            if ((i10 & 8) != 0) {
                map = endpoint.headers;
            }
            if ((i10 & 16) != 0) {
                str3 = endpoint.clientHello;
            }
            if ((i10 & 32) != 0) {
                str4 = endpoint.protocol;
            }
            if ((i10 & 64) != 0) {
                str5 = endpoint.echConfig;
            }
            String str6 = str4;
            String str7 = str5;
            String str8 = str3;
            String str9 = str2;
            return endpoint.copy(str, i, str9, map, str8, str6, str7);
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.port;
        }

        public final String component3() {
            return this.hostName;
        }

        public final Map<String, String> component4() {
            return this.headers;
        }

        public final String component5() {
            return this.clientHello;
        }

        public final String component6() {
            return this.protocol;
        }

        public final String component7() {
            return this.echConfig;
        }

        public final Endpoint copy(String host, int i, String hostName, Map<String, String> headers, String clientHello, String protocol, String echConfig) {
            kotlin.jvm.internal.j.e(host, "host");
            kotlin.jvm.internal.j.e(hostName, "hostName");
            kotlin.jvm.internal.j.e(headers, "headers");
            kotlin.jvm.internal.j.e(clientHello, "clientHello");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(echConfig, "echConfig");
            return new Endpoint(host, i, hostName, headers, clientHello, protocol, echConfig);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Endpoint)) {
                return false;
            }
            Endpoint endpoint = (Endpoint) obj;
            return kotlin.jvm.internal.j.a(this.host, endpoint.host) && this.port == endpoint.port && kotlin.jvm.internal.j.a(this.hostName, endpoint.hostName) && kotlin.jvm.internal.j.a(this.headers, endpoint.headers) && kotlin.jvm.internal.j.a(this.clientHello, endpoint.clientHello) && kotlin.jvm.internal.j.a(this.protocol, endpoint.protocol) && kotlin.jvm.internal.j.a(this.echConfig, endpoint.echConfig);
        }

        public final String getClientHello() {
            return this.clientHello;
        }

        public final String getEchConfig() {
            return this.echConfig;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getHostName() {
            return this.hostName;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public int hashCode() {
            return this.echConfig.hashCode() + s.d(s.d(i.b(this.headers, s.d(androidx.compose.foundation.interaction.f.c(this.port, this.host.hashCode() * 31, 31), 31, this.hostName), 31), 31, this.clientHello), 31, this.protocol);
        }

        public String toString() {
            String str = this.host;
            int i = this.port;
            String str2 = this.hostName;
            Map<String, String> map = this.headers;
            String str3 = this.clientHello;
            String str4 = this.protocol;
            String str5 = this.echConfig;
            StringBuilder sbL = s.l("Endpoint(host=", str, ", port=", i, ", hostName=");
            sbL.append(str2);
            sbL.append(", headers=");
            sbL.append(map);
            sbL.append(", clientHello=");
            d1.x(sbL, str3, ", protocol=", str4, ", echConfig=");
            return w0.r(sbL, str5, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Template {
        public static final int $stable = 8;
        private final sf.c bridgeTemplate;
        private final String clientHello;
        private final List<sf.c> profiles;
        private final String protocol;

        /* JADX WARN: Multi-variable type inference failed */
        public Template(sf.c bridgeTemplate, String clientHello, String protocol, List<? extends sf.c> profiles) {
            kotlin.jvm.internal.j.e(bridgeTemplate, "bridgeTemplate");
            kotlin.jvm.internal.j.e(clientHello, "clientHello");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profiles, "profiles");
            this.bridgeTemplate = bridgeTemplate;
            this.clientHello = clientHello;
            this.protocol = protocol;
            this.profiles = profiles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Template copy$default(Template template, sf.c cVar, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = template.bridgeTemplate;
            }
            if ((i & 2) != 0) {
                str = template.clientHello;
            }
            if ((i & 4) != 0) {
                str2 = template.protocol;
            }
            if ((i & 8) != 0) {
                list = template.profiles;
            }
            return template.copy(cVar, str, str2, list);
        }

        public final sf.c component1() {
            return this.bridgeTemplate;
        }

        public final String component2() {
            return this.clientHello;
        }

        public final String component3() {
            return this.protocol;
        }

        public final List<sf.c> component4() {
            return this.profiles;
        }

        public final Template copy(sf.c bridgeTemplate, String clientHello, String protocol, List<? extends sf.c> profiles) {
            kotlin.jvm.internal.j.e(bridgeTemplate, "bridgeTemplate");
            kotlin.jvm.internal.j.e(clientHello, "clientHello");
            kotlin.jvm.internal.j.e(protocol, "protocol");
            kotlin.jvm.internal.j.e(profiles, "profiles");
            return new Template(bridgeTemplate, clientHello, protocol, profiles);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Template)) {
                return false;
            }
            Template template = (Template) obj;
            return kotlin.jvm.internal.j.a(this.bridgeTemplate, template.bridgeTemplate) && kotlin.jvm.internal.j.a(this.clientHello, template.clientHello) && kotlin.jvm.internal.j.a(this.protocol, template.protocol) && kotlin.jvm.internal.j.a(this.profiles, template.profiles);
        }

        public final sf.c getBridgeTemplate() {
            return this.bridgeTemplate;
        }

        public final String getClientHello() {
            return this.clientHello;
        }

        public final List<sf.c> getProfiles() {
            return this.profiles;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public int hashCode() {
            return this.profiles.hashCode() + s.d(s.d(this.bridgeTemplate.hashCode() * 31, 31, this.clientHello), 31, this.protocol);
        }

        public String toString() {
            return "Template(bridgeTemplate=" + this.bridgeTemplate + ", clientHello=" + this.clientHello + ", protocol=" + this.protocol + ", profiles=" + this.profiles + ")";
        }
    }

    private MamiExclusive() {
    }

    private final Void bad(String str, String str2) throws ExclusiveException {
        throw new ExclusiveException(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bridge decodeBlock$default(MamiExclusive mamiExclusive, String str, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return mamiExclusive.decodeBlock(str, list);
    }

    private final byte[] inflateCapped(byte[] bArr, String str) {
        Inflater inflater = new Inflater();
        try {
            try {
                inflater.setInput(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[8192];
                while (!inflater.finished()) {
                    int iInflate = inflater.inflate(bArr2);
                    if (iInflate == 0 && (inflater.needsInput() || inflater.needsDictionary())) {
                        bad(str, "محتوای فشرده باز نشد");
                        throw new sd.c();
                    }
                    byteArrayOutputStream.write(bArr2, 0, iInflate);
                    if (byteArrayOutputStream.size() > 262144) {
                        bad(str, "محتوای فشرده باز نشد");
                        throw new sd.c();
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                kotlin.jvm.internal.j.d(byteArray, "toByteArray(...)");
                inflater.end();
                return byteArray;
            } catch (ExclusiveException e10) {
                throw e10;
            } catch (Exception unused) {
                bad(str, "محتوای فشرده باز نشد");
                throw new sd.c();
            }
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    private final boolean isHostName(Object obj) {
        if ((obj instanceof String) && ((String) obj).length() <= 253) {
            List listA1 = o.a1((CharSequence) obj, new char[]{'.'}, 6);
            if (listA1.size() >= 2) {
                List list = listA1;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (!INSTANCE.isLabel((String) it.next())) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean isLabel(String str) {
        if (str.length() != 0 && str.length() <= 63 && isLabel$alnum(o.E0(str)) && isLabel$alnum(o.M0(str))) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (isLabel$alnum(cCharAt) || cCharAt == '-') {
                }
            }
            return true;
        }
        return false;
    }

    private static final boolean isLabel$alnum(char c2) {
        if ('A' <= c2 && c2 < '[') {
            return true;
        }
        if ('a' > c2 || c2 >= '{') {
            return '0' <= c2 && c2 < ':';
        }
        return true;
    }

    private final boolean isMarker(String str, String str2, String str3) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '-') {
            i++;
        }
        if (i != 0) {
            String strL = f0.a.l(str2, " ", str3);
            if (v.r0(str, i, strL, false)) {
                String strSubstring = str.substring(strL.length() + i);
                kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
                if (strSubstring.length() > 0) {
                    for (int i10 = 0; i10 < strSubstring.length(); i10++) {
                        if (strSubstring.charAt(i10) == '-') {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isUuid(String str) {
        if (str.length() != 36) {
            return false;
        }
        Iterable nVar = new n(new androidx.activity.d(str, 5), 1);
        if ((nVar instanceof Collection) && ((Collection) nVar).isEmpty()) {
            return true;
        }
        Iterator it = nVar.iterator();
        while (true) {
            b0 b0Var = (b0) it;
            if (!b0Var.f23828b.hasNext()) {
                return true;
            }
            a0 a0Var = (a0) b0Var.next();
            int i = a0Var.f23823a;
            char cCharValue = ((Character) a0Var.f23824b).charValue();
            if (i == 8 || i == 13 || i == 18 || i == 23) {
                if (cCharValue != '-') {
                    return false;
                }
            } else if ('0' > cCharValue || cCharValue >= ':') {
                if ('a' > cCharValue || cCharValue >= 'g') {
                    if ('A' > cCharValue || cCharValue >= 'G') {
                        return false;
                    }
                }
            }
        }
    }

    private final List<PublicKey> keyObjects(List<String> list) {
        if (list == null) {
            list = m9.d.B("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwVEhfRU709R1WPT3cVgu2beUJGJ7OHk27uQjfc6PxpLdg+GKqm/t8c2GMH6FCgcRsB+s8FH+YD8gXiiE5b4g/Q==");
        }
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(MamiJs.INSTANCE.nodeBase64((String) it.next()))));
        }
        return arrayList;
    }

    public static /* synthetic */ sf.c outboundFor$default(MamiExclusive mamiExclusive, Endpoint endpoint, sf.c cVar, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = MamiXrayConfig.TAG;
        }
        return mamiExclusive.outboundFor(endpoint, cVar, str, str2);
    }

    private final String strOr(Object obj, String str) {
        return !truthy(obj) ? str : String.valueOf(obj);
    }

    private final boolean truthy(Object obj) {
        if (obj == null || obj.equals("") || obj.equals(Boolean.FALSE)) {
            return false;
        }
        return ((obj instanceof Number) && ((Number) obj).doubleValue() == 0.0d) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x026e  */
    /* JADX WARN: Code duplicated, block: B:137:0x027b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0177  */
    public final Bridge decodeBlock(String str, List<String> list) throws ExclusiveException {
        Object next;
        Double dNum;
        boolean z10;
        boolean z11;
        LinkedHashMap linkedHashMap;
        String str2;
        boolean z12;
        boolean zVerify;
        boolean z13;
        String str3 = str == null ? "" : str;
        if (MamiJs.INSTANCE.trim(str3).length() == 0 || str3.length() > 262144) {
            bad("EXCLUSIVE_BRIDGE_FORMAT", "بلاک پل خالی یا بیش از اندازه بزرگ است");
            throw new sd.c();
        }
        List<String> listSplit = new l("\r?\n").split(str3, 0);
        ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            arrayList.add(MamiJs.INSTANCE.trim((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() < 3) {
            bad("EXCLUSIVE_BRIDGE_FORMAT", "بلاک پل کامل نیست (نشانگر آغاز و پایان لازم است)");
            throw new sd.c();
        }
        Iterator<T> it2 = KINDS.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String str4 = (String) next;
            MamiExclusive mamiExclusive = INSTANCE;
            if (mamiExclusive.isMarker((String) q.y0(arrayList2), "BEGIN", str4) && mamiExclusive.isMarker((String) q.G0(arrayList2), "END", str4)) {
                break;
            }
        }
        String str5 = (String) next;
        if (str5 == null) {
            bad("EXCLUSIVE_BRIDGE_FORMAT", "نشانگر آغاز یا پایان بلاک پل درست نیست");
            throw new sd.c();
        }
        boolean z14 = true;
        String strF0 = q.F0(arrayList2.subList(1, arrayList2.size() - 1), "", null, null, null, 62);
        MamiJs mamiJs = MamiJs.INSTANCE;
        if (!mamiJs.isB64Body(strF0)) {
            bad("EXCLUSIVE_BRIDGE_FORMAT", "بدنهٔ بلاک پل base64 درست نیست");
            throw new sd.c();
        }
        try {
            byte[] bArrInflateCapped = inflateCapped(mamiJs.nodeBase64(strF0), "EXCLUSIVE_BRIDGE_FORMAT");
            Charset charset = kotlin.text.a.f23859a;
            Object json = mamiJs.parseJson(new String(bArrInflateCapped, charset));
            Object obj2 = mamiJs.get(json, ConstKt.SEP_VERSION);
            Object obj3 = mamiJs.get(json, "payload");
            Object obj4 = mamiJs.get(json, "signature");
            if (!(json instanceof sf.c) || (dNum = mamiJs.num(obj2)) == null || dNum.doubleValue() != 1.0d || !(obj3 instanceof String) || !(obj4 instanceof String) || ((CharSequence) obj3).length() == 0) {
                bad("EXCLUSIVE_BRIDGE_FORMAT", "بلاک پل قالب درستی ندارد");
                throw new sd.c();
            }
            byte[] bArrNodeBase64 = mamiJs.nodeBase64((String) obj4);
            byte[] bytes = ((String) obj3).getBytes(charset);
            kotlin.jvm.internal.j.d(bytes, "getBytes(...)");
            if (bArrNodeBase64.length == 0) {
                z10 = false;
            } else {
                List<PublicKey> listKeyObjects = keyObjects(list);
                if (!(listKeyObjects instanceof Collection) || !listKeyObjects.isEmpty()) {
                    Iterator<T> it3 = listKeyObjects.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z13 = false;
                            break;
                        }
                        PublicKey publicKey = (PublicKey) it3.next();
                        try {
                            Signature signature = Signature.getInstance("SHA256withECDSA");
                            signature.initVerify(publicKey);
                            signature.update(bytes);
                            zVerify = signature.verify(bArrNodeBase64);
                        } catch (Exception unused) {
                            zVerify = false;
                        }
                        if (zVerify) {
                            z13 = true;
                            break;
                        }
                    }
                } else {
                    z13 = false;
                    break;
                }
                if (z13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (!z10) {
                bad("EXCLUSIVE_BRIDGE_SIGNATURE", "امضای بلاک پل معتبر نیست — این پل از سرور مامی نیست یا دست\u200cکاری شده");
                throw new sd.c();
            }
            try {
                MamiJs mamiJs2 = MamiJs.INSTANCE;
                Object json2 = mamiJs2.parseJson(new String(mamiJs2.nodeBase64((String) obj3), kotlin.text.a.f23859a));
                if (json2 == null || !(((z11 = json2 instanceof sf.c)) || (json2 instanceof sf.a))) {
                    bad("EXCLUSIVE_BRIDGE_PAYLOAD", "محتوای پل خوانده نشد");
                    throw new sd.c();
                }
                Object obj5 = mamiJs2.get(json2, "server");
                if (!isHostName(obj5)) {
                    bad("EXCLUSIVE_BRIDGE_PAYLOAD", "نشانی سرور پل نامعتبر است");
                    throw new sd.c();
                }
                Object obj6 = mamiJs2.get(json2, PsiphonProbeService.PORT);
                if (mamiJs2.isInteger(obj6)) {
                    Double dNum2 = mamiJs2.num(obj6);
                    kotlin.jvm.internal.j.b(dNum2);
                    if (dNum2.doubleValue() >= 1.0d) {
                        Double dNum3 = mamiJs2.num(obj6);
                        kotlin.jvm.internal.j.b(dNum3);
                        if (dNum3.doubleValue() <= 65535.0d) {
                            Object obj7 = mamiJs2.get(json2, "headers");
                            if (obj7 instanceof sf.c) {
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                Iterator itN = ((sf.c) obj7).n();
                                kotlin.jvm.internal.j.d(itN, "keys(...)");
                                while (itN.hasNext()) {
                                    String str6 = (String) itN.next();
                                    MamiJs mamiJs3 = MamiJs.INSTANCE;
                                    kotlin.jvm.internal.j.b(str6);
                                    linkedHashMap2.put(str6, mamiJs3.get(obj7, str6));
                                }
                                linkedHashMap = linkedHashMap2;
                            } else {
                                linkedHashMap = null;
                            }
                            Object obj8 = MamiJs.INSTANCE.get(json2, "echConfig");
                            if (obj8 instanceof String) {
                                String str7 = (String) obj8;
                                int length = str7.length();
                                if (8 <= length && length < 4097) {
                                    CharSequence charSequence = (CharSequence) obj8;
                                    for (int i10 = 0; i10 < charSequence.length(); i10++) {
                                        char cCharAt = charSequence.charAt(i10);
                                        if ('A' <= cCharAt && cCharAt < '[') {
                                            z12 = true;
                                        } else if ('a' <= cCharAt && cCharAt < '{') {
                                            z12 = true;
                                        } else if (('0' <= cCharAt && cCharAt < ':') || cCharAt == '+' || cCharAt == '/' || cCharAt == '=') {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        if (!z12) {
                                            z14 = false;
                                            break;
                                        }
                                    }
                                    if (z14) {
                                        str2 = str7;
                                    } else {
                                        str2 = "";
                                    }
                                } else {
                                    str2 = "";
                                }
                            } else {
                                str2 = "";
                            }
                            String str8 = v.s0(str5, "EXCLUSIVE", false) ? "exclusive" : "argo";
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj5;
                            Double dNum4 = MamiJs.INSTANCE.num(obj6);
                            kotlin.jvm.internal.j.b(dNum4);
                            int iDoubleValue = (int) dNum4.doubleValue();
                            sf.c cVar = z11 ? (sf.c) json2 : null;
                            if (cVar == null) {
                                cVar = new sf.c();
                            }
                            return new Bridge(str8, str9, iDoubleValue, linkedHashMap, str2, cVar);
                        }
                    }
                }
                bad("EXCLUSIVE_BRIDGE_PAYLOAD", "درگاه سرور پل نامعتبر است یا نیامده");
                throw new sd.c();
            } catch (Exception unused2) {
                bad("EXCLUSIVE_BRIDGE_PAYLOAD", "محتوای پل خوانده نشد");
                throw new sd.c();
            }
        } catch (ExclusiveException e10) {
            throw e10;
        } catch (Exception unused3) {
            bad("EXCLUSIVE_BRIDGE_FORMAT", "بلاک پل JSON درستی ندارد");
            throw new sd.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.collections.w] */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.collections.w] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v12 */
    public final Template decodeTemplate(String str) throws ExclusiveException {
        Object next;
        MamiJs mamiJs = MamiJs.INSTANCE;
        if (str == null) {
            str = "";
        }
        String strDropSpaces = mamiJs.dropSpaces(str);
        if (strDropSpaces.length() == 0 || strDropSpaces.length() > 262144 || !mamiJs.isB64Body(strDropSpaces)) {
            bad("EXCLUSIVE_REMOTE_FORMAT", "الگوی راه دور base64 درستی نیست");
            throw new sd.c();
        }
        byte[] bArrNodeBase64 = mamiJs.nodeBase64(strDropSpaces);
        int length = bArrNodeBase64.length;
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) ((~bArrNodeBase64[(bArrNodeBase64.length - 1) - i10]) & 255);
        }
        try {
            MamiJs mamiJs2 = MamiJs.INSTANCE;
            Object obj = mamiJs2.get(mamiJs2.parseJson(new String(inflateCapped(bArr, "EXCLUSIVE_REMOTE_FORMAT"), kotlin.text.a.f23859a)), "parameters");
            if (!(obj instanceof sf.c) || !((sf.c) obj).f67158a.containsKey("bridge_template")) {
                bad("EXCLUSIVE_REMOTE_FORMAT", "الگوی راه دور «bridge_template» ندارد");
                throw new sd.c();
            }
            Object json = mamiJs2.get(obj, "bridge_template");
            sf.c cVar = new sf.c();
            if ((json instanceof String) && mamiJs2.trim((String) json).length() > 0) {
                try {
                    json = mamiJs2.parseJson((String) json);
                } catch (Exception unused) {
                    bad("EXCLUSIVE_REMOTE_FORMAT", "«bridge_template» JSON درستی نیست");
                    throw new sd.c();
                }
            } else if (!(json instanceof sf.c) && !(json instanceof sf.a)) {
                json = cVar;
            }
            List arrayList = w.INSTANCE;
            try {
                Object json2 = mamiJs2.get(obj, "profiles");
                if (json2 instanceof String) {
                    json2 = mamiJs2.parseJson((String) json2);
                }
                List<Object> listItems = mamiJs2.items(mamiJs2.get(json2, "profiles"));
                if (listItems != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : listItems) {
                        if (obj2 instanceof sf.c) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList = new ArrayList();
                    int size = arrayList2.size();
                    while (i < size) {
                        Object obj3 = arrayList2.get(i);
                        i++;
                        if (MamiJs.INSTANCE.get((sf.c) obj3, "name") instanceof String) {
                            arrayList.add(obj3);
                        }
                    }
                }
            } catch (Exception unused2) {
                arrayList = w.INSTANCE;
            }
            Iterator it = ((Iterable) arrayList).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.j.a(MamiJs.INSTANCE.get((sf.c) next, "name"), "ir"));
            sf.c cVar2 = (sf.c) next;
            Object obj4 = cVar2 != null ? MamiJs.INSTANCE.get(cVar2, "defaultClientHello") : null;
            String str2 = obj4 instanceof String ? (String) obj4 : null;
            if (str2 == null) {
                str2 = "safari604";
            }
            String str3 = HELLO_PROTOCOL.get(str2);
            if (str3 == null) {
                bad("EXCLUSIVE_REMOTE_PROFILE", "پروفایل ClientHello ناشناخته است: ".concat(str2));
                throw new sd.c();
            }
            sf.c cVar3 = json instanceof sf.c ? (sf.c) json : null;
            if (cVar3 == null) {
                cVar3 = new sf.c();
            }
            return new Template(cVar3, str2, str3, arrayList);
        } catch (ExclusiveException e10) {
            throw e10;
        } catch (Exception unused3) {
            bad("EXCLUSIVE_REMOTE_FORMAT", "الگوی راه دور JSON درستی ندارد");
            throw new sd.c();
        }
    }

    public final Endpoint endpointFor(Bridge bridge, Template template) {
        Map<String, Object> mapE;
        String clientHello;
        sf.c bridgeTemplate;
        kotlin.jvm.internal.j.e(bridge, "bridge");
        Object obj = (template == null || (bridgeTemplate = template.getBridgeTemplate()) == null) ? null : MamiJs.INSTANCE.get(bridgeTemplate, "headers");
        sf.c cVar = obj instanceof sf.c ? (sf.c) obj : null;
        if (bridge.getHeaders() != null && !bridge.getHeaders().isEmpty()) {
            mapE = bridge.getHeaders();
        } else if (cVar != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator itN = cVar.n();
            kotlin.jvm.internal.j.d(itN, "keys(...)");
            while (itN.hasNext()) {
                String str = (String) itN.next();
                MamiJs mamiJs = MamiJs.INSTANCE;
                kotlin.jvm.internal.j.b(str);
                linkedHashMap.put(str, mamiJs.get(cVar, str));
            }
            mapE = linkedHashMap;
        } else {
            mapE = d0.E();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> it = mapE.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            if (value instanceof String) {
                String str2 = key + value;
                int i = 0;
                while (true) {
                    if (i >= str2.length()) {
                        String lowerCase = key.toLowerCase(Locale.ROOT);
                        kotlin.jvm.internal.j.d(lowerCase, "toLowerCase(...)");
                        linkedHashMap2.put(lowerCase.equals("host") ? "Host" : key, value);
                        break;
                    }
                    char cCharAt = str2.charAt(i);
                    if (cCharAt == '\r' || cCharAt == '\n') {
                        break;
                    }
                    i++;
                }
            }
        }
        CharSequence charSequence = (CharSequence) linkedHashMap2.get("Host");
        if (charSequence == null || charSequence.length() == 0 || kotlin.jvm.internal.j.a(linkedHashMap2.get("Host"), "AUTO")) {
            linkedHashMap2.put("Host", bridge.getServer());
        }
        if (template == null || (clientHello = template.getClientHello()) == null) {
            clientHello = "safari604";
        }
        String str3 = clientHello;
        String server = bridge.getServer();
        int port = bridge.getPort();
        Object obj2 = linkedHashMap2.get("Host");
        kotlin.jvm.internal.j.b(obj2);
        String str4 = (String) obj2;
        String str5 = HELLO_PROTOCOL.get(str3);
        if (str5 == null) {
            str5 = "A";
        }
        return new Endpoint(server, port, str4, linkedHashMap2, str3, str5, bridge.getEchConfig());
    }

    public final String fingerprintFor(String clientHello, String str) throws ExclusiveException {
        kotlin.jvm.internal.j.e(clientHello, "clientHello");
        if (str != null && str.length() != 0) {
            return MamiXrayConfig.FP;
        }
        String str2 = HELLO_FINGERPRINT.get(clientHello);
        if (str2 != null) {
            return str2;
        }
        bad("EXCLUSIVE_KYLA_PROFILE", "پروفایل ClientHello پشتیبانی نمی\u200cشود: ".concat(clientHello));
        throw new sd.c();
    }

    public final Map<String, String> getHELLO_FINGERPRINT() {
        return HELLO_FINGERPRINT;
    }

    public final Map<String, String> getHELLO_PROTOCOL() {
        return HELLO_PROTOCOL;
    }

    public final List<String> getKINDS() {
        return KINDS;
    }

    public final sf.c outboundFor(Endpoint ep, sf.c info, String str, String tag) throws ExclusiveException {
        kotlin.jvm.internal.j.e(ep, "ep");
        kotlin.jvm.internal.j.e(info, "info");
        kotlin.jvm.internal.j.e(tag, "tag");
        sessionInfo(info);
        boolean zA = kotlin.jvm.internal.j.a(ep.getProtocol(), "B");
        LinkedHashMap linkedHashMap = new LinkedHashMap(ep.getHeaders());
        Object obj = MamiJs.INSTANCE.get(info, "headers");
        if (obj instanceof sf.c) {
            Iterator itN = ((sf.c) obj).n();
            kotlin.jvm.internal.j.d(itN, "keys(...)");
            while (itN.hasNext()) {
                String str2 = (String) itN.next();
                MamiJs mamiJs = MamiJs.INSTANCE;
                kotlin.jvm.internal.j.b(str2);
                linkedHashMap.put(str2, mamiJs.get(obj, str2));
            }
        } else if (obj instanceof sf.a) {
            sf.a aVar = (sf.a) obj;
            int size = aVar.f67155a.size();
            for (int i = 0; i < size; i++) {
                String strValueOf = String.valueOf(i);
                Object objM = aVar.m(i);
                if (objM == sf.c.f67157c) {
                    objM = null;
                }
                linkedHashMap.put(strValueOf, objM);
            }
        }
        Object hostName = linkedHashMap.get("Host");
        MamiExclusive mamiExclusive = INSTANCE;
        if (!mamiExclusive.truthy(hostName)) {
            hostName = null;
        }
        if (hostName == null) {
            hostName = linkedHashMap.get("host");
            if (!mamiExclusive.truthy(hostName)) {
                hostName = null;
            }
            if (hostName == null) {
                hostName = ep.getHostName();
            }
        }
        linkedHashMap.remove("Host");
        linkedHashMap.remove("host");
        String strFingerprintFor = fingerprintFor(ep.getClientHello(), ep.getEchConfig());
        sf.c cVar = new sf.c();
        if (zA) {
            String strStrOr = strOr(MamiJs.INSTANCE.get(info, "grpcServiceName"), "");
            if (strStrOr.length() != 0) {
                for (int i10 = 0; i10 < strStrOr.length(); i10++) {
                    char cCharAt = strStrOr.charAt(i10);
                    if (cCharAt >= '!' && cCharAt <= '~') {
                    }
                }
                sf.c cVarN = com.mlmvpn.scanner.e.n(cVar, StudioError.NETWORK, "grpc", "serviceName", strStrOr);
                cVarN.D("authority", ep.getHostName());
                cVar.D("grpcSettings", cVarN);
            }
            bad("EXCLUSIVE_GRPC", "نام سرویس gRPC پل نامعتبر است");
            throw new sd.c();
        }
        String strStrOr2 = strOr(MamiJs.INSTANCE.get(info, "wsPath"), "/");
        if (strStrOr2.charAt(0) != '/') {
            bad("EXCLUSIVE_WS", "مسیر WebSocket پل نامعتبر است");
            throw new sd.c();
        }
        kotlin.text.g gVarM = i.m("[?&]ed=([0-9]+)", strStrOr2, 0, 2, null);
        if (gVarM != null) {
            BigInteger bigInteger = new BigInteger((String) ((f0) ((kotlin.text.i) gVarM).a()).get(1));
            if (bigInteger.compareTo(BigInteger.ONE) < 0 || bigInteger.compareTo(BigInteger.valueOf(65536L)) > 0) {
                bad("EXCLUSIVE_WS", "مقدار ed در مسیر WebSocket نامعتبر است");
                throw new sd.c();
            }
        }
        sf.c cVar2 = new sf.c();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                value = sf.c.f67157c;
            }
            cVar2.D(str3, value);
        }
        sf.c cVarN2 = com.mlmvpn.scanner.e.n(cVar, StudioError.NETWORK, "ws", "path", strStrOr2);
        if (hostName == null) {
            hostName = sf.c.f67157c;
        }
        cVarN2.D("host", hostName);
        cVarN2.D("headers", cVar2);
        cVar.D("wsSettings", cVarN2);
        sf.c cVarM = com.mlmvpn.scanner.e.m("security", "tls", cVar);
        cVarM.D("serverName", ep.getHostName());
        sf.a aVar2 = new sf.a();
        aVar2.put(zA ? "h2" : "http/1.1");
        cVarM.D("alpn", aVar2);
        cVarM.D("fingerprint", strFingerprintFor);
        if (ep.getEchConfig().length() > 0) {
            cVarM.D("echConfigList", ep.getEchConfig());
        }
        cVar.D("tlsSettings", cVarM);
        sf.c cVar3 = new sf.c();
        cVar3.D("tag", tag);
        sf.c cVarM2 = com.mlmvpn.scanner.e.m("protocol", "vmess", cVar3);
        sf.a aVar3 = new sf.a();
        sf.c cVar4 = new sf.c();
        cVar4.D("address", (str == null || str.length() == 0) ? ep.getHost() : str);
        cVar4.D(PsiphonProbeService.PORT, Integer.valueOf(ep.getPort()));
        sf.a aVar4 = new sf.a();
        sf.c cVar5 = new sf.c();
        cVar5.D(XrayCoreHostService.KEY_ID, MamiJs.INSTANCE.get(info, "uuid"));
        i.s(0, "security", "auto", "alterId", cVar5);
        aVar4.put(cVar5);
        cVar4.D("users", aVar4);
        aVar3.put(cVar4);
        cVarM2.D("vnext", aVar3);
        cVar3.D("settings", cVarM2);
        cVar3.D("streamSettings", cVar);
        return cVar3;
    }

    public final sf.c sessionInfo(sf.c cVar) throws ExclusiveException {
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj = mamiJs.get(cVar, "uuid");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        if (cVar == null || !isUuid(str)) {
            bad("EXCLUSIVE_AUTH_SHAPE", "پاسخ احراز هویت شناسهٔ معتبری نداشت");
            throw new sd.c();
        }
        Object obj2 = mamiJs.get(cVar, "token");
        if ((obj2 instanceof String) && ((CharSequence) obj2).length() != 0) {
            return cVar;
        }
        bad("EXCLUSIVE_AUTH_SHAPE", "پاسخ احراز هویت توکن نداشت");
        throw new sd.c();
    }
}
