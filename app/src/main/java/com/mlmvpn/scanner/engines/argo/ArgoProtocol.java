package com.mlmvpn.scanner.engines.argo;

import a6.w0;
import androidx.media3.common.s;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.scanner.data.studio.StudioDeployer;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.engines.mami.MamiXrayConfig;
import com.mlmvpn.scanner.engines.proton.ProtonStealth;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import je.h;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.collections.d0;
import kotlin.collections.q;
import kotlin.jvm.internal.j;
import kotlin.text.g;
import kotlin.text.i;
import kotlin.text.l;
import kotlin.text.m;
import kotlin.text.o;
import kotlin.text.v;
import le.n;
import le.p;
import org.scilab.forge.jlatexmath.TeXSymbolParser;
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import we.k;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoProtocol {
    public static final int $stable;
    private static final l BLOCK_RE;
    public static final String BRIDGE_KEY_SPKI = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwVEhfRU709R1WPT3cVgu2beUJGJ7OHk27uQjfc6PxpLdg+GKqm/t8c2GMH6FCgcRsB+s8FH+YD8gXiiE5b4g/Q==";
    private static final l HOST_RE;
    public static final ArgoProtocol INSTANCE;
    private static final l IPV4_RE;
    private static final sd.e MAC_KEY$delegate;
    private static final l MARKER_RE;
    private static final l NOT_FALCON;
    private static final byte[] RSA_DER;
    private static final sd.e RSA_KEY$delegate;
    private static final String RSA_SPKI = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz/M4JOwjHadx2ZsZZOATv0sT+YCtleYy4BPBBYA1KKypT59gVc5y1geVIbV6ssktTGnWE7q2BQsKG6QLZ13Xzdc/uYHm8hcQewlsUrh5i3qs9kyZSHXV9TqPna4sKX9pVxMxO+PfUWABzygRgDdpP3x/Y8my7oh3NVbRKrWrabcAtuyL3mdQGCWHooaVQfYttLWBuCSDUF8C5AnDUNQ5DnOrQFt8bKMQoqt7aj97Ecf2TiU0jxUAKt5QpmuS+Yjrny6/U7aCFU9iP+uQFwKNBRpxwlR/OS4mIq9gCWkrI7FWJ2i4AGU878IwiwGKYwvJK2Pyk3+6fW4dVg7+K+6B7QIDAQAB";
    private static final Map<String, String> SNOW_KEYS;
    public static final String USER_AGENT = "okhttp/4.12.0";
    private static final SecureRandom random;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class AuthRequest {
        public static final int $stable = 8;
        private final byte[] aad;
        private final String header;
        private final byte[] iv;
        private final byte[] key;

        public AuthRequest(String header, byte[] key, byte[] iv, byte[] aad) {
            j.e(header, "header");
            j.e(key, "key");
            j.e(iv, "iv");
            j.e(aad, "aad");
            this.header = header;
            this.key = key;
            this.iv = iv;
            this.aad = aad;
        }

        public final byte[] getAad() {
            return this.aad;
        }

        public final String getHeader() {
            return this.header;
        }

        public final byte[] getIv() {
            return this.iv;
        }

        public final byte[] getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Bridge {
        public static final int $stable = 8;
        private final Map<String, String> headers;
        private final String host;
        private final int port;
        private final String protocol;
        private final boolean sigOk;

        public Bridge(String host, int i, String protocol, boolean z10, Map<String, String> map) {
            j.e(host, "host");
            j.e(protocol, "protocol");
            this.host = host;
            this.port = i;
            this.protocol = protocol;
            this.sigOk = z10;
            this.headers = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bridge copy$default(Bridge bridge, String str, int i, String str2, boolean z10, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = bridge.host;
            }
            if ((i10 & 2) != 0) {
                i = bridge.port;
            }
            if ((i10 & 4) != 0) {
                str2 = bridge.protocol;
            }
            if ((i10 & 8) != 0) {
                z10 = bridge.sigOk;
            }
            if ((i10 & 16) != 0) {
                map = bridge.headers;
            }
            Map map2 = map;
            String str3 = str2;
            return bridge.copy(str, i, str3, z10, map2);
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.port;
        }

        public final String component3() {
            return this.protocol;
        }

        public final boolean component4() {
            return this.sigOk;
        }

        public final Map<String, String> component5() {
            return this.headers;
        }

        public final Bridge copy(String host, int i, String protocol, boolean z10, Map<String, String> map) {
            j.e(host, "host");
            j.e(protocol, "protocol");
            return new Bridge(host, i, protocol, z10, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Bridge)) {
                return false;
            }
            Bridge bridge = (Bridge) obj;
            return j.a(this.host, bridge.host) && this.port == bridge.port && j.a(this.protocol, bridge.protocol) && this.sigOk == bridge.sigOk && j.a(this.headers, bridge.headers);
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getHost() {
            return this.host;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final boolean getSigOk() {
            return this.sigOk;
        }

        public int hashCode() {
            int iD = w0.d(s.d(androidx.compose.foundation.interaction.f.c(this.port, this.host.hashCode() * 31, 31), 31, this.protocol), 31, this.sigOk);
            Map<String, String> map = this.headers;
            return iD + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            String str = this.host;
            int i = this.port;
            String str2 = this.protocol;
            boolean z10 = this.sigOk;
            Map<String, String> map = this.headers;
            StringBuilder sbL = s.l("Bridge(host=", str, ", port=", i, ", protocol=");
            s.u(str2, ", sigOk=", ", headers=", sbL, z10);
            sbL.append(map);
            sbL.append(")");
            return sbL.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Endpoint {
        public static final int $stable = 0;
        private final String host;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11208id;
        private final String kind;
        private final int port;
        private final String protocol;

        public Endpoint(String id2, String kind, String host, int i, String protocol) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(protocol, "protocol");
            this.f11208id = id2;
            this.kind = kind;
            this.host = host;
            this.port = i;
            this.protocol = protocol;
        }

        public static /* synthetic */ Endpoint copy$default(Endpoint endpoint, String str, String str2, String str3, int i, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = endpoint.f11208id;
            }
            if ((i10 & 2) != 0) {
                str2 = endpoint.kind;
            }
            if ((i10 & 4) != 0) {
                str3 = endpoint.host;
            }
            if ((i10 & 8) != 0) {
                i = endpoint.port;
            }
            if ((i10 & 16) != 0) {
                str4 = endpoint.protocol;
            }
            String str5 = str4;
            String str6 = str3;
            return endpoint.copy(str, str2, str6, i, str5);
        }

        public final String component1() {
            return this.f11208id;
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

        public final Endpoint copy(String id2, String kind, String host, int i, String protocol) {
            j.e(id2, "id");
            j.e(kind, "kind");
            j.e(host, "host");
            j.e(protocol, "protocol");
            return new Endpoint(id2, kind, host, i, protocol);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Endpoint)) {
                return false;
            }
            Endpoint endpoint = (Endpoint) obj;
            return j.a(this.f11208id, endpoint.f11208id) && j.a(this.kind, endpoint.kind) && j.a(this.host, endpoint.host) && this.port == endpoint.port && j.a(this.protocol, endpoint.protocol);
        }

        public final String getHost() {
            return this.host;
        }

        public final String getId() {
            return this.f11208id;
        }

        public final String getKind() {
            return this.kind;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public int hashCode() {
            return this.protocol.hashCode() + androidx.compose.foundation.interaction.f.c(this.port, s.d(s.d(this.f11208id.hashCode() * 31, 31, this.kind), 31, this.host), 31);
        }

        public String toString() {
            String str = this.f11208id;
            String str2 = this.kind;
            String str3 = this.host;
            int i = this.port;
            String str4 = this.protocol;
            StringBuilder sbN = s.n("Endpoint(id=", str, ", kind=", str2, ", host=");
            f0.a.r(i, str3, ", port=", ", protocol=", sbN);
            return w0.r(sbN, str4, ")");
        }

        public /* synthetic */ Endpoint(String str, String str2, String str3, int i, String str4, int i10, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, (i10 & 8) != 0 ? ProtonStealth.PORT : i, (i10 & 16) != 0 ? "A" : str4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class FalconOrigin {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        private final String f11209cc;
        private final String ip;
        private final double load;

        public FalconOrigin(String ip, String cc2, double d10) {
            j.e(ip, "ip");
            j.e(cc2, "cc");
            this.ip = ip;
            this.f11209cc = cc2;
            this.load = d10;
        }

        public static /* synthetic */ FalconOrigin copy$default(FalconOrigin falconOrigin, String str, String str2, double d10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = falconOrigin.ip;
            }
            if ((i & 2) != 0) {
                str2 = falconOrigin.f11209cc;
            }
            if ((i & 4) != 0) {
                d10 = falconOrigin.load;
            }
            return falconOrigin.copy(str, str2, d10);
        }

        public final String component1() {
            return this.ip;
        }

        public final String component2() {
            return this.f11209cc;
        }

        public final double component3() {
            return this.load;
        }

        public final FalconOrigin copy(String ip, String cc2, double d10) {
            j.e(ip, "ip");
            j.e(cc2, "cc");
            return new FalconOrigin(ip, cc2, d10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FalconOrigin)) {
                return false;
            }
            FalconOrigin falconOrigin = (FalconOrigin) obj;
            return j.a(this.ip, falconOrigin.ip) && j.a(this.f11209cc, falconOrigin.f11209cc) && Double.compare(this.load, falconOrigin.load) == 0;
        }

        public final String getCc() {
            return this.f11209cc;
        }

        public final String getIp() {
            return this.ip;
        }

        public final double getLoad() {
            return this.load;
        }

        public int hashCode() {
            return Double.hashCode(this.load) + s.d(this.ip.hashCode() * 31, 31, this.f11209cc);
        }

        public String toString() {
            String str = this.ip;
            String str2 = this.f11209cc;
            double d10 = this.load;
            StringBuilder sbN = s.n("FalconOrigin(ip=", str, ", cc=", str2, ", load=");
            sbN.append(d10);
            sbN.append(")");
            return sbN.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class PublicServer {
        public static final int $stable = 0;
        private final String host;
        private final int port;
        private final String profile;

        public PublicServer(String host, int i, String profile) {
            j.e(host, "host");
            j.e(profile, "profile");
            this.host = host;
            this.port = i;
            this.profile = profile;
        }

        public static /* synthetic */ PublicServer copy$default(PublicServer publicServer, String str, int i, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = publicServer.host;
            }
            if ((i10 & 2) != 0) {
                i = publicServer.port;
            }
            if ((i10 & 4) != 0) {
                str2 = publicServer.profile;
            }
            return publicServer.copy(str, i, str2);
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.port;
        }

        public final String component3() {
            return this.profile;
        }

        public final PublicServer copy(String host, int i, String profile) {
            j.e(host, "host");
            j.e(profile, "profile");
            return new PublicServer(host, i, profile);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PublicServer)) {
                return false;
            }
            PublicServer publicServer = (PublicServer) obj;
            return j.a(this.host, publicServer.host) && this.port == publicServer.port && j.a(this.profile, publicServer.profile);
        }

        public final String getHost() {
            return this.host;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProfile() {
            return this.profile;
        }

        public int hashCode() {
            return this.profile.hashCode() + androidx.compose.foundation.interaction.f.c(this.port, this.host.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.host;
            int i = this.port;
            return w0.r(s.l("PublicServer(host=", str, ", port=", i, ", profile="), this.profile, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Snowcfg {
        public static final int $stable = 8;
        private final long issuedMs;
        private final String kid;
        private final sf.c params;
        private final long serial;
        private final boolean sigOk;

        public Snowcfg(String kid, long j, long j10, boolean z10, sf.c params) {
            j.e(kid, "kid");
            j.e(params, "params");
            this.kid = kid;
            this.serial = j;
            this.issuedMs = j10;
            this.sigOk = z10;
            this.params = params;
        }

        public static /* synthetic */ Snowcfg copy$default(Snowcfg snowcfg, String str, long j, long j10, boolean z10, sf.c cVar, int i, Object obj) {
            if ((i & 1) != 0) {
                str = snowcfg.kid;
            }
            if ((i & 2) != 0) {
                j = snowcfg.serial;
            }
            if ((i & 4) != 0) {
                j10 = snowcfg.issuedMs;
            }
            if ((i & 8) != 0) {
                z10 = snowcfg.sigOk;
            }
            if ((i & 16) != 0) {
                cVar = snowcfg.params;
            }
            long j11 = j10;
            return snowcfg.copy(str, j, j11, z10, cVar);
        }

        public final String component1() {
            return this.kid;
        }

        public final long component2() {
            return this.serial;
        }

        public final long component3() {
            return this.issuedMs;
        }

        public final boolean component4() {
            return this.sigOk;
        }

        public final sf.c component5() {
            return this.params;
        }

        public final Snowcfg copy(String kid, long j, long j10, boolean z10, sf.c params) {
            j.e(kid, "kid");
            j.e(params, "params");
            return new Snowcfg(kid, j, j10, z10, params);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snowcfg)) {
                return false;
            }
            Snowcfg snowcfg = (Snowcfg) obj;
            return j.a(this.kid, snowcfg.kid) && this.serial == snowcfg.serial && this.issuedMs == snowcfg.issuedMs && this.sigOk == snowcfg.sigOk && j.a(this.params, snowcfg.params);
        }

        public final long getIssuedMs() {
            return this.issuedMs;
        }

        public final String getKid() {
            return this.kid;
        }

        public final sf.c getParams() {
            return this.params;
        }

        public final long getSerial() {
            return this.serial;
        }

        public final boolean getSigOk() {
            return this.sigOk;
        }

        public int hashCode() {
            return this.params.hashCode() + w0.d(w0.c(w0.c(this.kid.hashCode() * 31, 31, this.serial), 31, this.issuedMs), 31, this.sigOk);
        }

        public String toString() {
            String str = this.kid;
            long j = this.serial;
            long j10 = this.issuedMs;
            boolean z10 = this.sigOk;
            sf.c cVar = this.params;
            StringBuilder sbM = s.m("Snowcfg(kid=", str, ", serial=", j);
            v0.a.k(j10, ", issuedMs=", ", sigOk=", sbM);
            sbM.append(z10);
            sbM.append(", params=");
            sbM.append(cVar);
            sbM.append(")");
            return sbM.toString();
        }
    }

    static {
        ArgoProtocol argoProtocol = new ArgoProtocol();
        INSTANCE = argoProtocol;
        SNOW_KEYS = d0.J(new sd.j("snowcfg", "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEe9JfBCUoFo1vmiYHLNz0EbAN/xkzFlBrdBFbCGCQ4N41Cjt6c7vNi6dAfJSdn/a39m5AkbBcn9a/ITxMxZNHJQ=="), new sd.j("snowcfg-f", "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEfMH+QlcC9f0wsbsHWJYcei+cp4rO2WnTzHcdhQF3OJFP58+I1O/Z/HTJE9GXUZ5SV3WPQgJF8V/YFoObjvmZtw=="), new sd.j("snowcfg-b", "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvOr0llysYNMT+F4fRE0S7Bh/s29X8EXyKIbcZFwXmm2KebR9YvG+nBasKrH0QzZLgxdNDggIqgTdU0wAJXtMJA=="));
        random = new SecureRandom();
        RSA_DER = argoProtocol.b64(RSA_SPKI);
        RSA_KEY$delegate = m9.d.A(new f(3));
        MAC_KEY$delegate = m9.d.A(new f(4));
        m mVar = m.IGNORE_CASE;
        BLOCK_RE = new l("(?:-\\+|-+)\\s*BEGIN ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)([\\s\\S]*?)(?:-\\+|-+)\\s*END ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)", mVar);
        MARKER_RE = new l("(?:-\\+|-+)\\s*(BEGIN|END) ARGO VPN BRIDGE BLOCK\\s*(?:-\\+|-+)", mVar);
        NOT_FALCON = new l("(^|\\.)(t\\.me|telegram\\.(org|me)|argovpn\\.com|google\\.com|youtube\\.com|youtu\\.be|instagram\\.com|twitter\\.com|x\\.com|github\\.com|githubusercontent\\.com|apple\\.com|play\\.google\\.com|cafebazaar\\.ir|myket\\.ir|bit\\.ly|tinyurl\\.com|aparat\\.com|wikipedia\\.org|whatsapp\\.com|cloudflare\\.com|workers\\.dev|pages\\.dev)$", mVar);
        HOST_RE = new l("^(?=.{1,253}$)([a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z][a-z0-9-]{1,23}$", mVar);
        IPV4_RE = new l("^\\d+\\.\\d+\\.\\d+\\.\\d+$");
        $stable = 8;
    }

    private ArgoProtocol() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] MAC_KEY_delegate$lambda$1() {
        return INSTANCE.hkdfExpand("HmacSHA256", RSA_DER, "Argo-RSA-MAC-Key", 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PublicKey RSA_KEY_delegate$lambda$0() {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(RSA_DER));
    }

    public static /* synthetic */ AuthRequest authRequest$default(ArgoProtocol argoProtocol, String str, long j, long j10, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        long j11 = j;
        if ((i & 4) != 0) {
            j10 = 0;
        }
        return argoProtocol.authRequest(str, j11, j10);
    }

    private final PublicKey ecKey(String str) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(b64(str)));
        j.d(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractBridgeBlocks$lambda$16(g it) {
        j.e(it, "it");
        return ((i) it).c();
    }

    public static /* synthetic */ List extractFalconHosts$default(ArgoProtocol argoProtocol, String str, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return argoProtocol.extractFalconHosts(str, z10);
    }

    private final byte[] getMAC_KEY() {
        return (byte[]) MAC_KEY$delegate.getValue();
    }

    private final PublicKey getRSA_KEY() {
        Object value = RSA_KEY$delegate.getValue();
        j.d(value, "getValue(...)");
        return (PublicKey) value;
    }

    private final byte[] gzip(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            j.d(byteArray, "toByteArray(...)");
            return byteArray;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a.a.g(gZIPOutputStream, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ byte[] inflate$default(ArgoProtocol argoProtocol, byte[] bArr, int i, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i = TLObject.FLAG_22;
        }
        return argoProtocol.inflate(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence json$lambda$7(sd.j jVar) {
        j.e(jVar, "<destruct>");
        String str = (String) jVar.component1();
        Object objComponent2 = jVar.component2();
        ArgoProtocol argoProtocol = INSTANCE;
        return f0.a.l(argoProtocol.quote(str), ":", argoProtocol.value(objComponent2));
    }

    public static /* synthetic */ SessionInfo openAnswer$default(ArgoProtocol argoProtocol, AuthRequest authRequest, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return argoProtocol.openAnswer(authRequest, str, j);
    }

    private final String padB64(String str) {
        return str.length() % 4 == 0 ? str : v0.a.p(str, v.o0(4 - (str.length() % 4), "="));
    }

    public static /* synthetic */ String sessionHeader$default(ArgoProtocol argoProtocol, String str, SessionInfo sessionInfo, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        return argoProtocol.sessionHeader(str, sessionInfo, j);
    }

    private static final CharSequence sha256Hex$lambda$4(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final String value(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return quote((String) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj.toString();
        }
        if (!(obj instanceof Number)) {
            return quote(obj.toString());
        }
        Number number = (Number) obj;
        return (number.doubleValue() != Math.floor(number.doubleValue()) || Double.isInfinite(number.doubleValue())) ? number.toString() : String.valueOf(number.longValue());
    }

    public static /* synthetic */ String vmessUri$default(ArgoProtocol argoProtocol, Endpoint endpoint, SessionInfo sessionInfo, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            str2 = "";
        }
        return argoProtocol.vmessUri(endpoint, sessionInfo, str, str2);
    }

    public static /* synthetic */ sf.c xrayOutbound$default(ArgoProtocol argoProtocol, Endpoint endpoint, SessionInfo sessionInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "";
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = MamiXrayConfig.FP;
        }
        return argoProtocol.xrayOutbound(endpoint, sessionInfo, str, str4, str3);
    }

    public final AuthRequest authRequest(String protocol, long j, long j10) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        j.e(protocol, "protocol");
        byte[] bArr = new byte[32];
        SecureRandom secureRandom = random;
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        byte[] bArrHkdfExpand = hkdfExpand("HmacSHA512", hkdfExtract("HmacSHA512", bArr2, bArr3), "ArgoVPN-Derivation", 32);
        byte[] bArrHkdfExtract = hkdfExtract("HmacSHA256", bArr, bArrHkdfExpand);
        byte[] bArrHkdfExpand2 = hkdfExpand("HmacSHA256", bArrHkdfExtract, "Argo-AES-Key", 32);
        byte[] bArrHkdfExpand3 = hkdfExpand("HmacSHA256", bArrHkdfExtract, "Argo-AES-IV", 12);
        String strSealRequest = sealRequest(json(new sd.j("protocol", protocol.equals("B") ? "B" : "A"), new sd.j("request", "auth"), new sd.j("salt", b64NoPad(bArr)), new sd.j("secret", b64NoPad(bArrHkdfExpand)), new sd.j("t", Long.valueOf((((long) 1000) * j10) + j)), new sd.j(ConstKt.SEP_VERSION, 3)));
        byte[] mac_key = getMAC_KEY();
        byte[] bytes = strSealRequest.getBytes(kotlin.text.a.f23862d);
        j.d(bytes, "getBytes(...)");
        return new AuthRequest(strSealRequest, bArrHkdfExpand2, bArrHkdfExpand3, hmac("HmacSHA256", mac_key, bytes));
    }

    public final byte[] b64(String s8) {
        j.e(s8, "s");
        k kVar = we.l.Companion;
        String strPadB64 = INSTANCE.padB64(com.mlmvpn.scanner.e.g("\\s+", o.n1(s8).toString(), ""));
        kVar.getClass();
        we.l lVarA = k.a(strPadB64);
        if (lVarA != null) {
            return lVarA.toByteArray();
        }
        throw new IllegalArgumentException("bad base64");
    }

    public final String b64NoPad(byte[] b10) {
        j.e(b10, "b");
        we.l.Companion.getClass();
        return o.q1(k.d(b10, 0, -1234567890).base64(), '=');
    }

    public final byte[] b64url(String s8) {
        j.e(s8, "s");
        return b64(v.p0(v.p0(s8, '-', '+'), '_', '/'));
    }

    public final we.l bytes(byte[] b10) {
        j.e(b10, "b");
        we.l.Companion.getClass();
        return k.d(b10, 0, -1234567890);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00cc  */
    public final Bridge decodeBridgeBlock(String block) {
        int iIntValue;
        j.e(block, "block");
        String strG = com.mlmvpn.scanner.e.g("\\s+", MARKER_RE.replace(block, ""), "");
        if (strG.length() <= 0) {
            throw new IllegalArgumentException("بلاک پل خالی است");
        }
        try {
            boolean zVerifyEcdsa = false;
            byte[] bArrInflate$default = inflate$default(this, b64(strG), 0, 2, null);
            Charset charset = kotlin.text.a.f23859a;
            sf.c cVar = new sf.c(new String(bArrInflate$default, charset));
            Object objO = cVar.o("payload");
            String str = objO instanceof String ? (String) objO : null;
            if (str == null) {
                throw new IllegalArgumentException("بلاک پل محتوای معتبری ندارد");
            }
            if (cVar.t(-1, ConstKt.SEP_VERSION) != 1) {
                throw new IllegalArgumentException("نسخهٔ این بلاک پل پشتیبانی نمی\u200cشود");
            }
            try {
                byte[] bytes = str.getBytes(charset);
                j.d(bytes, "getBytes(...)");
                String strA = cVar.A("signature", "");
                j.d(strA, "optString(...)");
                zVerifyEcdsa = verifyEcdsa("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEwVEhfRU709R1WPT3cVgu2beUJGJ7OHk27uQjfc6PxpLdg+GKqm/t8c2GMH6FCgcRsB+s8FH+YD8gXiiE5b4g/Q==", bytes, b64(strA));
            } catch (Throwable unused) {
            }
            boolean z10 = zVerifyEcdsa;
            try {
                sf.c cVar2 = new sf.c(new String(b64(str), kotlin.text.a.f23859a));
                String strA2 = cVar2.A("server", "");
                if (o.L0(strA2)) {
                    strA2 = cVar2.A("hostName", "");
                }
                j.d(strA2, "ifBlank(...)");
                String string = o.n1(strA2).toString();
                Locale locale = Locale.ROOT;
                String lowerCase = string.toLowerCase(locale);
                j.d(lowerCase, "toLowerCase(...)");
                if (!looksLikeHost(lowerCase)) {
                    throw new IllegalArgumentException("نشانی سرور داخل بلاک پل معتبر نیست");
                }
                String strA3 = cVar2.A(PsiphonProbeService.PORT, "");
                j.d(strA3, "optString(...)");
                Integer numV0 = v.v0(strA3);
                if (numV0 == null) {
                    iIntValue = ProtonStealth.PORT;
                } else {
                    int iIntValue2 = numV0.intValue();
                    if (1 > iIntValue2 || iIntValue2 >= 65536) {
                        numV0 = null;
                    }
                    if (numV0 != null) {
                        iIntValue = numV0.intValue();
                    } else {
                        iIntValue = ProtonStealth.PORT;
                    }
                }
                int i = iIntValue;
                String strA4 = cVar2.A("protocol", "A");
                j.d(strA4, "optString(...)");
                String upperCase = strA4.toUpperCase(locale);
                j.d(upperCase, "toUpperCase(...)");
                String str2 = upperCase.equals("B") ? "B" : "A";
                sf.c cVarW = cVar2.w("headers");
                return new Bridge(lowerCase, i, str2, z10, cVarW != null ? stringMap(cVarW) : null);
            } catch (Throwable unused2) {
                throw new IllegalArgumentException("محتوای بلاک پل خوانده نشد");
            }
        } catch (Throwable unused3) {
            throw new IllegalArgumentException("این متن بلاک پل آرگو نیست (باز نشد)");
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    public final List<FalconOrigin> decodeFalconServers(String text) {
        FalconOrigin falconOrigin;
        j.e(text, "text");
        byte[] bArrB64 = b64(o.n1(text).toString());
        ArrayList arrayList = new ArrayList(bArrB64.length);
        for (byte b10 : bArrB64) {
            arrayList.add(Byte.valueOf((byte) ((~b10) & 255)));
        }
        sf.f fVar = new sf.f(new String(inflate$default(this, q.g1(arrayList), 0, 2, null), kotlin.text.a.f23859a));
        ArrayList arrayList2 = new ArrayList();
        if (fVar.c() != '[') {
            throw fVar.f("A JSONArray text must start with '['");
        }
        char c2 = fVar.c();
        if (c2 == 0) {
            throw fVar.f("Expected a ',' or ']'");
        }
        if (c2 != ']') {
            fVar.a();
            while (true) {
                if (fVar.c() == ',') {
                    fVar.a();
                    arrayList2.add(sf.c.f67157c);
                } else {
                    fVar.a();
                    arrayList2.add(fVar.e());
                }
                char c7 = fVar.c();
                if (c7 == 0) {
                    throw fVar.f("Expected a ',' or ']'");
                }
                if (c7 != ',') {
                    if (c7 == ']') {
                        break;
                    }
                    throw fVar.f("Expected a ',' or ']'");
                }
                char c10 = fVar.c();
                if (c10 == 0) {
                    throw fVar.f("Expected a ',' or ']'");
                }
                if (c10 == ']') {
                    break;
                }
                fVar.a();
            }
        }
        h hVarJ = com.google.android.gms.internal.mlkit_language_id_common.j.J(0, arrayList2.size());
        ArrayList arrayList3 = new ArrayList();
        je.g gVarA = hVarJ.iterator();
        while (gVarA.f23130c) {
            int iNextInt = gVarA.nextInt();
            Object obj = (iNextInt < 0 || iNextInt >= arrayList2.size()) ? null : arrayList2.get(iNextInt);
            sf.c cVar = obj instanceof sf.c ? (sf.c) obj : null;
            if (cVar == null) {
                falconOrigin = null;
            } else {
                String strA = cVar.A("serverIp", "");
                if (o.L0(strA)) {
                    falconOrigin = null;
                } else {
                    String strA2 = cVar.A("countryCode", "??");
                    String upperCase = (o.L0(strA2) ? "??" : strA2).toUpperCase(Locale.ROOT);
                    j.d(upperCase, "toUpperCase(...)");
                    double dS = cVar.s("serverLoad", 0.0d);
                    falconOrigin = new FalconOrigin(strA, upperCase, Double.isNaN(dS) ? 0.0d : dS);
                }
            }
            if (falconOrigin != null) {
                arrayList3.add(falconOrigin);
            }
        }
        return arrayList3;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0080  */
    public final Snowcfg decodeSnowcfg(String str) {
        boolean z10;
        List listA1 = o.a1(com.mlmvpn.core.aether.i.h(str, "text", str), new char[]{'.'}, 6);
        if (listA1.size() != 6 || !j.a(listA1.get(0), StudioDeployer.DO_TAG)) {
            throw new IllegalArgumentException("not a snowcfg envelope");
        }
        String str2 = (String) listA1.get(1);
        String str3 = (String) listA1.get(2);
        String str4 = (String) listA1.get(3);
        String str5 = (String) listA1.get(4);
        String str6 = (String) listA1.get(5);
        String str7 = SNOW_KEYS.get(str2);
        if (str7 != null) {
            byte[] bytes = q.F0(listA1.subList(0, 5), ".", null, null, null, 62).getBytes(kotlin.text.a.f23859a);
            j.d(bytes, "getBytes(...)");
            if (verifyEcdsa(str7, bytes, b64url(str6))) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        byte[] bArrB64 = b64(str5);
        ArrayList arrayList = new ArrayList(bArrB64.length);
        for (byte b10 : bArrB64) {
            arrayList.add(Byte.valueOf((byte) ((~b10) & 255)));
        }
        sf.c cVar = new sf.c(new String(inflate$default(this, q.g1(q.X0(arrayList)), 0, 2, null), kotlin.text.a.f23859a));
        Long lW0 = v.w0(str3);
        long jLongValue = lW0 != null ? lW0.longValue() : 0L;
        Long lW1 = v.w0(str4);
        long jLongValue2 = ((long) 1000) * (lW1 != null ? lW1.longValue() : 0L);
        sf.c cVarW = cVar.w("parameters");
        if (cVarW == null) {
            cVarW = new sf.c();
        }
        return new Snowcfg(str2, jLongValue, jLongValue2, z10, cVarW);
    }

    public final List<String> extractBridgeBlocks(String str) {
        if (str == null) {
            str = "";
        }
        le.q qVarV = n.V(l.findAll$default(BLOCK_RE, str, 0, 2, null), new d(13));
        ArrayList arrayList = new ArrayList();
        Iterator it = qVarV.iterator();
        while (true) {
            p pVar = (p) it;
            if (!pVar.hasNext()) {
                break;
            }
            arrayList.add(pVar.next());
        }
        if (arrayList.isEmpty()) {
            String strG = com.mlmvpn.scanner.e.g("\\s+", str, "");
            if (com.mlmvpn.core.aether.i.B("^eJ[A-Za-z0-9+/=]{60,}$", strG)) {
                arrayList.add(strG);
            }
        }
        return arrayList;
    }

    public final List<String> extractFalconHosts(String str, boolean z10) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (str == null) {
            str = "";
        }
        Iterator<String> it = new l("\\r?\\n").split(str, 0).iterator();
        while (it.hasNext()) {
            String strG = com.mlmvpn.scanner.e.g("[^a-zA-Z0-9.]+$", com.mlmvpn.scanner.e.g("^[^a-zA-Z0-9]+", o.n1(new l("[\\u200c\\u200f\\u200e\\u202a-\\u202e]").replace(it.next(), "")).toString(), ""), "");
            if (z10) {
                strG = com.mlmvpn.scanner.e.g("[/:].*$", new l("^https?://", m.IGNORE_CASE).replace(strG, ""), "");
            }
            if (strG.length() != 0) {
                int i = 0;
                while (true) {
                    if (i >= strG.length()) {
                        String lowerCase = strG.toLowerCase(Locale.ROOT);
                        j.d(lowerCase, "toLowerCase(...)");
                        if (looksLikeHost(lowerCase) && !NOT_FALCON.containsMatchIn(lowerCase)) {
                            linkedHashSet.add(lowerCase);
                            break;
                        }
                        break;
                    }
                    if (x6.p.u(strG.charAt(i))) {
                        break;
                    }
                    i++;
                }
            }
        }
        return q.k1(linkedHashSet);
    }

    public final byte[] hkdfExpand(String alg, byte[] prk, String info, int i) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        j.e(alg, "alg");
        j.e(prk, "prk");
        j.e(info, "info");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrHmac = new byte[0];
        int i10 = 1;
        while (byteArrayOutputStream.size() < i) {
            byte[] bytes = info.getBytes(kotlin.text.a.f23859a);
            j.d(bytes, "getBytes(...)");
            bArrHmac = hmac(alg, prk, kotlin.collections.o.j0(kotlin.collections.o.j0(bArrHmac, bytes), new byte[]{(byte) i10}));
            byteArrayOutputStream.write(bArrHmac);
            i10++;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        j.d(byteArray, "toByteArray(...)");
        byte[] bArrCopyOf = Arrays.copyOf(byteArray, i);
        j.d(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final byte[] hkdfExtract(String alg, byte[] salt, byte[] ikm) {
        j.e(alg, "alg");
        j.e(salt, "salt");
        j.e(ikm, "ikm");
        return hmac(alg, salt, ikm);
    }

    public final byte[] hmac(String alg, byte[] key, byte[] data) throws NoSuchAlgorithmException, InvalidKeyException {
        j.e(alg, "alg");
        j.e(key, "key");
        j.e(data, "data");
        Mac mac = Mac.getInstance(alg);
        mac.init(new SecretKeySpec(key, alg));
        byte[] bArrDoFinal = mac.doFinal(data);
        j.d(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    public final byte[] inflate(byte[] data, int i) {
        j.e(data, "data");
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        do {
            try {
                if (inflater.finished()) {
                    inflater.end();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    j.d(byteArray, "toByteArray(...)");
                    return byteArray;
                }
                int iInflate = inflater.inflate(bArr);
                if (iInflate == 0 && (inflater.needsInput() || inflater.needsDictionary())) {
                    throw new IllegalArgumentException("truncated zlib stream");
                }
                byteArrayOutputStream.write(bArr, 0, iInflate);
            } catch (Throwable th2) {
                inflater.end();
                throw th2;
            }
        } while (byteArrayOutputStream.size() <= i);
        throw new IllegalArgumentException("inflated data too large");
    }

    public final String json(sd.j... pairs) {
        j.e(pairs, "pairs");
        return kotlin.collections.o.i0(pairs, ",", "{", "}", new d(12), 24);
    }

    public final boolean looksLikeHost(String str) {
        int length;
        return str != null && 4 <= (length = str.length()) && length < 254 && HOST_RE.matches(str) && !IPV4_RE.matches(str);
    }

    public final SessionInfo openAnswer(AuthRequest req, String body, long j) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        j.e(req, "req");
        j.e(body, "body");
        byte[] bArrB64 = b64(body);
        if (bArrB64.length < 17) {
            throw new IllegalArgumentException("short");
        }
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, new SecretKeySpec(req.getKey(), "AES"), new GCMParameterSpec(128, req.getIv()));
        cipher.updateAAD(req.getAad());
        byte[] bArrDoFinal = cipher.doFinal(bArrB64);
        j.d(bArrDoFinal, "doFinal(...)");
        sf.c cVar = new sf.c(new String(bArrDoFinal, kotlin.text.a.f23859a));
        String strA = cVar.A("uuid", "");
        j.b(strA);
        if (o.L0(strA)) {
            throw new IllegalArgumentException("no uuid");
        }
        Map<String, String> mapStringMap = stringMap(cVar.w("headers"));
        String strA2 = cVar.A("token", "");
        j.d(strA2, "optString(...)");
        String strA3 = cVar.A("wsPath", "");
        if (o.L0(strA3)) {
            strA3 = "/";
        }
        String strA4 = cVar.A("grpcServiceName", "");
        j.d(strA4, "optString(...)");
        return new SessionInfo(strA, strA2, strA3, strA4, mapStringMap, j);
    }

    public final List<PublicServer> publicServersOf(sf.c params) {
        j.e(params, "params");
        ArrayList arrayList = new ArrayList();
        Iterator itN = params.n();
        j.d(itN, "keys(...)");
        while (itN.hasNext()) {
            String str = (String) itN.next();
            l lVar = new l("^servers?_(ir|global)_", m.IGNORE_CASE);
            j.b(str);
            if (lVar.containsMatchIn(str)) {
                try {
                    Object objA = params.a(str);
                    sf.c cVar = objA instanceof String ? new sf.c((String) objA) : (sf.c) objA;
                    String strA = cVar.A("server", "");
                    j.d(strA, "optString(...)");
                    String lowerCase = strA.toLowerCase(Locale.ROOT);
                    j.d(lowerCase, "toLowerCase(...)");
                    if (looksLikeHost(lowerCase)) {
                        String strA2 = cVar.A(PsiphonProbeService.PORT, "");
                        j.d(strA2, "optString(...)");
                        Integer numV0 = v.v0(strA2);
                        int iIntValue = numV0 != null ? numV0.intValue() : ProtonStealth.PORT;
                        String strA3 = cVar.A("profile", "");
                        if (o.L0(strA3)) {
                            strA3 = o.y0(str, "_ir_", false) ? "ir" : "global";
                        }
                        arrayList.add(new PublicServer(lowerCase, iIntValue, strA3));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public final String quote(String s8) {
        j.e(s8, "s");
        StringBuilder sb2 = new StringBuilder("\"");
        int length = s8.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = s8.charAt(i);
            if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\t') {
                sb2.append("\\t");
            } else if (j.f(cCharAt, 32) < 0) {
                sb2.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1)));
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
        String string = sb2.toString();
        j.d(string, "toString(...)");
        return string;
    }

    public final String sealRequest(String jsonText) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        j.e(jsonText, "jsonText");
        byte[] bytes = jsonText.getBytes(kotlin.text.a.f23859a);
        j.d(bytes, "getBytes(...)");
        if (bytes.length > 190) {
            throw new IllegalArgumentException("محتوای درخواست برای RSA بیش از حد بلند است");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        cipher.init(1, getRSA_KEY(), new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        byte[] bArrDoFinal = cipher.doFinal(bytes);
        SecureRandom secureRandom = random;
        byte[] bArr = new byte[secureRandom.nextInt(32) + 1];
        secureRandom.nextBytes(bArr);
        j.b(bArrDoFinal);
        return b64NoPad(gzip(kotlin.collections.o.j0(bArrDoFinal, bArr)));
    }

    public final String sessionHeader(String kind, SessionInfo s8, long j) {
        j.e(kind, "kind");
        j.e(s8, "s");
        return sealRequest(json(new sd.j("request", kind), new sd.j("sessionId", sha256Hex(s8.getUuid() + s8.getToken())), new sd.j("t", Long.valueOf((s8.getClockOffsetSec() * ((long) 1000)) + j)), new sd.j(ConstKt.SEP_VERSION, 3)));
    }

    public final String sha256Hex(String s8) throws NoSuchAlgorithmException {
        j.e(s8, "s");
        byte[] bArrD = com.mlmvpn.core.aether.i.D(s8, kotlin.text.a.f23859a, "getBytes(...)", MessageDigest.getInstance("SHA-256"), "digest(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i = 0;
        for (byte b10 : bArrD) {
            i++;
            if (i > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(sha256Hex$lambda$4(b10));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public final Map<String, String> stringMap(sf.c cVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cVar != null) {
            Iterator itN = cVar.n();
            j.d(itN, "keys(...)");
            while (itN.hasNext()) {
                String str = (String) itN.next();
                linkedHashMap.put(str, cVar.A(str, ""));
            }
        }
        return linkedHashMap;
    }

    public final boolean verifyEcdsa(String spki, byte[] data, byte[] sigDer) {
        j.e(spki, "spki");
        j.e(data, "data");
        j.e(sigDer, "sigDer");
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(INSTANCE.ecKey(spki));
            signature.update(data);
            return signature.verify(sigDer);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String vmessUri(Endpoint ep, SessionInfo info, String str, String str2) {
        String wsPath;
        j.e(ep, "ep");
        j.e(info, "info");
        String connectIp = str;
        j.e(connectIp, "connectIp");
        String label = str2;
        j.e(label, "label");
        boolean z10 = j.a(ep.getProtocol(), "B") && !o.L0(info.getGrpcServiceName());
        sd.j jVar = new sd.j("v", "2");
        if (o.L0(label)) {
            label = v0.a.h("Argo · ", ep.getHost());
        }
        sd.j jVar2 = new sd.j("ps", label);
        if (o.L0(connectIp)) {
            connectIp = ep.getHost();
        }
        sd.j jVar3 = new sd.j("add", connectIp);
        sd.j jVar4 = new sd.j(PsiphonProbeService.PORT, String.valueOf(ep.getPort()));
        sd.j jVar5 = new sd.j(XrayCoreHostService.KEY_ID, info.getUuid());
        sd.j jVar6 = new sd.j("aid", "0");
        sd.j jVar7 = new sd.j("scy", "auto");
        sd.j jVar8 = new sd.j("net", z10 ? "grpc" : "ws");
        sd.j jVar9 = new sd.j(TeXSymbolParser.TYPE_ATTR, z10 ? "gun" : "none");
        sd.j jVar10 = new sd.j("host", ep.getHost());
        if (z10) {
            wsPath = info.getGrpcServiceName();
        } else {
            wsPath = info.getWsPath();
            if (o.L0(wsPath)) {
                wsPath = "/";
            }
        }
        String strJson = json(jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, jVar10, new sd.j("path", wsPath), new sd.j("tls", "tls"), new sd.j("sni", ep.getHost()), new sd.j("alpn", z10 ? "h2" : "http/1.1"), new sd.j("fp", MamiXrayConfig.FP));
        we.h hVar = new we.h();
        hVar.P(strJson);
        return v0.a.h("vmess://", hVar.f(hVar.f70283b).base64());
    }

    public final sf.c xrayOutbound(Endpoint ep, SessionInfo info, String tag, String connectIp, String fingerprint) {
        j.e(ep, "ep");
        j.e(info, "info");
        j.e(tag, "tag");
        j.e(connectIp, "connectIp");
        j.e(fingerprint, "fingerprint");
        boolean z10 = j.a(ep.getProtocol(), "B") && !o.L0(info.getGrpcServiceName());
        sf.c cVar = new sf.c();
        for (Map.Entry<String, String> entry : info.getHeaders().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!v.m0(key, "host")) {
                cVar.D(key, value);
            }
        }
        sf.c cVar2 = new sf.c();
        if (z10) {
            sf.c cVarM = com.mlmvpn.scanner.e.m(StudioError.NETWORK, "grpc", cVar2);
            cVarM.D("serviceName", info.getGrpcServiceName());
            cVar2.D("grpcSettings", cVarM);
        } else {
            sf.c cVarM2 = com.mlmvpn.scanner.e.m(StudioError.NETWORK, "ws", cVar2);
            String wsPath = info.getWsPath();
            if (o.L0(wsPath)) {
                wsPath = "/";
            }
            cVarM2.D("path", wsPath);
            cVarM2.D("host", ep.getHost());
            cVarM2.D("headers", cVar);
            cVar2.D("wsSettings", cVarM2);
        }
        sf.c cVarM3 = com.mlmvpn.scanner.e.m("security", "tls", cVar2);
        cVarM3.D("serverName", ep.getHost());
        if (o.L0(fingerprint)) {
            fingerprint = MamiXrayConfig.FP;
        }
        sf.a aVarL = com.mlmvpn.scanner.e.l("fingerprint", fingerprint, cVarM3);
        aVarL.put(z10 ? "h2" : "http/1.1");
        cVarM3.D("alpn", aVarL);
        sf.c cVarQ = com.mlmvpn.core.aether.i.q(cVar2, cVarM3, "tlsSettings");
        cVarQ.D(XrayCoreHostService.KEY_ID, info.getUuid());
        cVarQ.D("security", "auto");
        cVarQ.D("alterId", 0);
        sf.c cVar3 = new sf.c();
        cVar3.D("tag", tag);
        sf.c cVarM4 = com.mlmvpn.scanner.e.m("protocol", "vmess", cVar3);
        sf.a aVar = new sf.a();
        sf.c cVar4 = new sf.c();
        if (o.L0(connectIp)) {
            connectIp = ep.getHost();
        }
        cVar4.D("address", connectIp);
        cVar4.D(PsiphonProbeService.PORT, Integer.valueOf(ep.getPort()));
        sf.a aVar2 = new sf.a();
        aVar2.put(cVarQ);
        cVar4.D("users", aVar2);
        aVar.put(cVar4);
        cVarM4.D("vnext", aVar);
        cVar3.D("settings", cVarM4);
        cVar3.D("streamSettings", cVar2);
        return cVar3;
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class SessionInfo {
        public static final int $stable = 8;
        private final long clockOffsetSec;
        private final String grpcServiceName;
        private final Map<String, String> headers;
        private final String token;
        private final String uuid;
        private final String wsPath;

        public SessionInfo(String uuid, String token, String wsPath, String grpcServiceName, Map<String, String> headers, long j) {
            j.e(uuid, "uuid");
            j.e(token, "token");
            j.e(wsPath, "wsPath");
            j.e(grpcServiceName, "grpcServiceName");
            j.e(headers, "headers");
            this.uuid = uuid;
            this.token = token;
            this.wsPath = wsPath;
            this.grpcServiceName = grpcServiceName;
            this.headers = headers;
            this.clockOffsetSec = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, String str3, String str4, Map map, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionInfo.uuid;
            }
            if ((i & 2) != 0) {
                str2 = sessionInfo.token;
            }
            if ((i & 4) != 0) {
                str3 = sessionInfo.wsPath;
            }
            if ((i & 8) != 0) {
                str4 = sessionInfo.grpcServiceName;
            }
            if ((i & 16) != 0) {
                map = sessionInfo.headers;
            }
            if ((i & 32) != 0) {
                j = sessionInfo.clockOffsetSec;
            }
            long j10 = j;
            Map map2 = map;
            String str5 = str3;
            return sessionInfo.copy(str, str2, str5, str4, map2, j10);
        }

        public final String component1() {
            return this.uuid;
        }

        public final String component2() {
            return this.token;
        }

        public final String component3() {
            return this.wsPath;
        }

        public final String component4() {
            return this.grpcServiceName;
        }

        public final Map<String, String> component5() {
            return this.headers;
        }

        public final long component6() {
            return this.clockOffsetSec;
        }

        public final SessionInfo copy(String uuid, String token, String wsPath, String grpcServiceName, Map<String, String> headers, long j) {
            j.e(uuid, "uuid");
            j.e(token, "token");
            j.e(wsPath, "wsPath");
            j.e(grpcServiceName, "grpcServiceName");
            j.e(headers, "headers");
            return new SessionInfo(uuid, token, wsPath, grpcServiceName, headers, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionInfo)) {
                return false;
            }
            SessionInfo sessionInfo = (SessionInfo) obj;
            return j.a(this.uuid, sessionInfo.uuid) && j.a(this.token, sessionInfo.token) && j.a(this.wsPath, sessionInfo.wsPath) && j.a(this.grpcServiceName, sessionInfo.grpcServiceName) && j.a(this.headers, sessionInfo.headers) && this.clockOffsetSec == sessionInfo.clockOffsetSec;
        }

        public final long getClockOffsetSec() {
            return this.clockOffsetSec;
        }

        public final String getGrpcServiceName() {
            return this.grpcServiceName;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final String getWsPath() {
            return this.wsPath;
        }

        public int hashCode() {
            return Long.hashCode(this.clockOffsetSec) + com.mlmvpn.core.aether.i.b(this.headers, s.d(s.d(s.d(this.uuid.hashCode() * 31, 31, this.token), 31, this.wsPath), 31, this.grpcServiceName), 31);
        }

        public String toString() {
            String str = this.uuid;
            String str2 = this.token;
            String str3 = this.wsPath;
            String str4 = this.grpcServiceName;
            Map<String, String> map = this.headers;
            long j = this.clockOffsetSec;
            StringBuilder sbN = s.n("SessionInfo(uuid=", str, ", token=", str2, ", wsPath=");
            d1.x(sbN, str3, ", grpcServiceName=", str4, ", headers=");
            sbN.append(map);
            sbN.append(", clockOffsetSec=");
            sbN.append(j);
            sbN.append(")");
            return sbN.toString();
        }

        public /* synthetic */ SessionInfo(String str, String str2, String str3, String str4, Map map, long j, int i, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, str4, map, (i & 32) != 0 ? 0L : j);
        }
    }
}
