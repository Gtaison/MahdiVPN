package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import androidx.media3.common.s;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.AwgProbeService;
import com.mlmvpn.core.warp.XrayCoreHostService;
import com.mlmvpn.scanner.data.studio.api.StudioError;
import com.mlmvpn.scanner.data.studio.central.Central;
import com.mlmvpn.scanner.engines.cloud.CfUsage;
import com.mlmvpn.scanner.engines.scout.PsiphonProbeService;
import com.mlmvpn.scanner.utils.CfUnfilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.collections.a0;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.internal.j;
import kotlin.text.o;
import org.mlmvpn.chat.bridge.GerehLocale;
import org.telegram.ui.Cells.d1;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiCatalog {
    private static final String WS_PATH_CHARS = "._~!$&'()*+,;=:@%/-";
    public static final MamiCatalog INSTANCE = new MamiCatalog();
    private static final List<String> PROTOCOLS = r.a0("trojan", "vless-xhttp", "vless-raw-reality", "hysteria2", "vless-grpc-reality", "vless");
    private static final List<String> PROFILES = r.a0("VXT", "VXR", "VRR", "HY2", "VGR");
    private static final List<String> XHTTP_MODES = r.a0("auto", "packet-up", "stream-up", "stream-one");
    private static final List<String> FINGERPRINTS = r.a0(MamiXrayConfig.FP, "firefox", CfUnfilter.LOCAL_FRONT_FINGERPRINT, "ios", "android", "edge", "360", "qq", ConstKt.SEP_RANDOM, "randomized");
    private static final List<String> NETWORKS = r.a0("raw", "ws", "httpupgrade", "xhttp", "grpc");
    private static final ee.c SHORT_ID_OK = new f(5);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Grpc {
        public static final int $stable = 0;
        private final String encryption;
        private final String fingerprint;
        private final int multiConnections;
        private final String publicKey;
        private final String security;
        private final String serviceName;
        private final String shortId;
        private final String uuid;

        public Grpc(String uuid, String encryption, String security, String publicKey, String shortId, String fingerprint, String serviceName, int i) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            j.e(serviceName, "serviceName");
            this.uuid = uuid;
            this.encryption = encryption;
            this.security = security;
            this.publicKey = publicKey;
            this.shortId = shortId;
            this.fingerprint = fingerprint;
            this.serviceName = serviceName;
            this.multiConnections = i;
        }

        public static /* synthetic */ Grpc copy$default(Grpc grpc, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = grpc.uuid;
            }
            if ((i10 & 2) != 0) {
                str2 = grpc.encryption;
            }
            if ((i10 & 4) != 0) {
                str3 = grpc.security;
            }
            if ((i10 & 8) != 0) {
                str4 = grpc.publicKey;
            }
            if ((i10 & 16) != 0) {
                str5 = grpc.shortId;
            }
            if ((i10 & 32) != 0) {
                str6 = grpc.fingerprint;
            }
            if ((i10 & 64) != 0) {
                str7 = grpc.serviceName;
            }
            if ((i10 & 128) != 0) {
                i = grpc.multiConnections;
            }
            String str8 = str7;
            int i11 = i;
            String str9 = str5;
            String str10 = str6;
            return grpc.copy(str, str2, str3, str4, str9, str10, str8, i11);
        }

        public final String component1() {
            return this.uuid;
        }

        public final String component2() {
            return this.encryption;
        }

        public final String component3() {
            return this.security;
        }

        public final String component4() {
            return this.publicKey;
        }

        public final String component5() {
            return this.shortId;
        }

        public final String component6() {
            return this.fingerprint;
        }

        public final String component7() {
            return this.serviceName;
        }

        public final int component8() {
            return this.multiConnections;
        }

        public final Grpc copy(String uuid, String encryption, String security, String publicKey, String shortId, String fingerprint, String serviceName, int i) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            j.e(serviceName, "serviceName");
            return new Grpc(uuid, encryption, security, publicKey, shortId, fingerprint, serviceName, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Grpc)) {
                return false;
            }
            Grpc grpc = (Grpc) obj;
            return j.a(this.uuid, grpc.uuid) && j.a(this.encryption, grpc.encryption) && j.a(this.security, grpc.security) && j.a(this.publicKey, grpc.publicKey) && j.a(this.shortId, grpc.shortId) && j.a(this.fingerprint, grpc.fingerprint) && j.a(this.serviceName, grpc.serviceName) && this.multiConnections == grpc.multiConnections;
        }

        public final String getEncryption() {
            return this.encryption;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final int getMultiConnections() {
            return this.multiConnections;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getSecurity() {
            return this.security;
        }

        public final String getServiceName() {
            return this.serviceName;
        }

        public final String getShortId() {
            return this.shortId;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return Integer.hashCode(this.multiConnections) + s.d(s.d(s.d(s.d(s.d(s.d(this.uuid.hashCode() * 31, 31, this.encryption), 31, this.security), 31, this.publicKey), 31, this.shortId), 31, this.fingerprint), 31, this.serviceName);
        }

        public String toString() {
            String str = this.uuid;
            String str2 = this.encryption;
            String str3 = this.security;
            String str4 = this.publicKey;
            String str5 = this.shortId;
            String str6 = this.fingerprint;
            String str7 = this.serviceName;
            int i = this.multiConnections;
            StringBuilder sbN = s.n("Grpc(uuid=", str, ", encryption=", str2, ", security=");
            d1.x(sbN, str3, ", publicKey=", str4, ", shortId=");
            d1.x(sbN, str5, ", fingerprint=", str6, ", serviceName=");
            return s.i(i, str7, ", multiConnections=", ")", sbN);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class GrpcTransport {
        public static final int $stable = 0;
        private final String authority;
        private final int healthCheckTimeout;
        private final int idleTimeout;
        private final int multiConnections;
        private final boolean multiMode;
        private final boolean permitWithoutStream;
        private final String serviceName;

        public GrpcTransport(String serviceName, boolean z10, int i, String authority, int i10, int i11, boolean z11) {
            j.e(serviceName, "serviceName");
            j.e(authority, "authority");
            this.serviceName = serviceName;
            this.multiMode = z10;
            this.multiConnections = i;
            this.authority = authority;
            this.idleTimeout = i10;
            this.healthCheckTimeout = i11;
            this.permitWithoutStream = z11;
        }

        public static /* synthetic */ GrpcTransport copy$default(GrpcTransport grpcTransport, String str, boolean z10, int i, String str2, int i10, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = grpcTransport.serviceName;
            }
            if ((i12 & 2) != 0) {
                z10 = grpcTransport.multiMode;
            }
            if ((i12 & 4) != 0) {
                i = grpcTransport.multiConnections;
            }
            if ((i12 & 8) != 0) {
                str2 = grpcTransport.authority;
            }
            if ((i12 & 16) != 0) {
                i10 = grpcTransport.idleTimeout;
            }
            if ((i12 & 32) != 0) {
                i11 = grpcTransport.healthCheckTimeout;
            }
            if ((i12 & 64) != 0) {
                z11 = grpcTransport.permitWithoutStream;
            }
            int i13 = i11;
            boolean z12 = z11;
            int i14 = i10;
            int i15 = i;
            return grpcTransport.copy(str, z10, i15, str2, i14, i13, z12);
        }

        public final String component1() {
            return this.serviceName;
        }

        public final boolean component2() {
            return this.multiMode;
        }

        public final int component3() {
            return this.multiConnections;
        }

        public final String component4() {
            return this.authority;
        }

        public final int component5() {
            return this.idleTimeout;
        }

        public final int component6() {
            return this.healthCheckTimeout;
        }

        public final boolean component7() {
            return this.permitWithoutStream;
        }

        public final GrpcTransport copy(String serviceName, boolean z10, int i, String authority, int i10, int i11, boolean z11) {
            j.e(serviceName, "serviceName");
            j.e(authority, "authority");
            return new GrpcTransport(serviceName, z10, i, authority, i10, i11, z11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GrpcTransport)) {
                return false;
            }
            GrpcTransport grpcTransport = (GrpcTransport) obj;
            return j.a(this.serviceName, grpcTransport.serviceName) && this.multiMode == grpcTransport.multiMode && this.multiConnections == grpcTransport.multiConnections && j.a(this.authority, grpcTransport.authority) && this.idleTimeout == grpcTransport.idleTimeout && this.healthCheckTimeout == grpcTransport.healthCheckTimeout && this.permitWithoutStream == grpcTransport.permitWithoutStream;
        }

        public final String getAuthority() {
            return this.authority;
        }

        public final int getHealthCheckTimeout() {
            return this.healthCheckTimeout;
        }

        public final int getIdleTimeout() {
            return this.idleTimeout;
        }

        public final int getMultiConnections() {
            return this.multiConnections;
        }

        public final boolean getMultiMode() {
            return this.multiMode;
        }

        public final boolean getPermitWithoutStream() {
            return this.permitWithoutStream;
        }

        public final String getServiceName() {
            return this.serviceName;
        }

        public int hashCode() {
            return Boolean.hashCode(this.permitWithoutStream) + androidx.compose.foundation.interaction.f.c(this.healthCheckTimeout, androidx.compose.foundation.interaction.f.c(this.idleTimeout, s.d(androidx.compose.foundation.interaction.f.c(this.multiConnections, w0.d(this.serviceName.hashCode() * 31, 31, this.multiMode), 31), 31, this.authority), 31), 31);
        }

        public String toString() {
            String str = this.serviceName;
            boolean z10 = this.multiMode;
            int i = this.multiConnections;
            String str2 = this.authority;
            int i10 = this.idleTimeout;
            int i11 = this.healthCheckTimeout;
            boolean z11 = this.permitWithoutStream;
            StringBuilder sb2 = new StringBuilder("GrpcTransport(serviceName=");
            sb2.append(str);
            sb2.append(", multiMode=");
            sb2.append(z10);
            sb2.append(", multiConnections=");
            d1.n(i, ", authority=", str2, ", idleTimeout=", sb2);
            s.v(sb2, i10, ", healthCheckTimeout=", i11, ", permitWithoutStream=");
            return f0.a.n(sb2, ")", z11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Hive {
        public static final int $stable = 8;
        private final Object assignment;
        private final long revision;
        private final List<Server> servers;
        private final List<Skipped> skipped;
        private final int testIntervalMinutes;

        public Hive(long j, List<Server> servers, List<Skipped> skipped, Object obj, int i) {
            j.e(servers, "servers");
            j.e(skipped, "skipped");
            this.revision = j;
            this.servers = servers;
            this.skipped = skipped;
            this.assignment = obj;
            this.testIntervalMinutes = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Hive copy$default(Hive hive, long j, List list, List list2, Object obj, int i, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                j = hive.revision;
            }
            long j10 = j;
            if ((i10 & 2) != 0) {
                list = hive.servers;
            }
            List list3 = list;
            if ((i10 & 4) != 0) {
                list2 = hive.skipped;
            }
            List list4 = list2;
            if ((i10 & 8) != 0) {
                obj = hive.assignment;
            }
            Object obj3 = obj;
            if ((i10 & 16) != 0) {
                i = hive.testIntervalMinutes;
            }
            return hive.copy(j10, list3, list4, obj3, i);
        }

        public final long component1() {
            return this.revision;
        }

        public final List<Server> component2() {
            return this.servers;
        }

        public final List<Skipped> component3() {
            return this.skipped;
        }

        public final Object component4() {
            return this.assignment;
        }

        public final int component5() {
            return this.testIntervalMinutes;
        }

        public final Hive copy(long j, List<Server> servers, List<Skipped> skipped, Object obj, int i) {
            j.e(servers, "servers");
            j.e(skipped, "skipped");
            return new Hive(j, servers, skipped, obj, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Hive)) {
                return false;
            }
            Hive hive = (Hive) obj;
            return this.revision == hive.revision && j.a(this.servers, hive.servers) && j.a(this.skipped, hive.skipped) && j.a(this.assignment, hive.assignment) && this.testIntervalMinutes == hive.testIntervalMinutes;
        }

        public final Object getAssignment() {
            return this.assignment;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final List<Server> getServers() {
            return this.servers;
        }

        public final List<Skipped> getSkipped() {
            return this.skipped;
        }

        public final int getTestIntervalMinutes() {
            return this.testIntervalMinutes;
        }

        public int hashCode() {
            int iF = androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.f(Long.hashCode(this.revision) * 31, 31, this.servers), 31, this.skipped);
            Object obj = this.assignment;
            return Integer.hashCode(this.testIntervalMinutes) + ((iF + (obj == null ? 0 : obj.hashCode())) * 31);
        }

        public String toString() {
            return "Hive(revision=" + this.revision + ", servers=" + this.servers + ", skipped=" + this.skipped + ", assignment=" + this.assignment + ", testIntervalMinutes=" + this.testIntervalMinutes + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class HttpUpgradeTransport {
        public static final int $stable = 0;
        private final String host;
        private final String path;

        public HttpUpgradeTransport(String path, String host) {
            j.e(path, "path");
            j.e(host, "host");
            this.path = path;
            this.host = host;
        }

        public static /* synthetic */ HttpUpgradeTransport copy$default(HttpUpgradeTransport httpUpgradeTransport, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = httpUpgradeTransport.path;
            }
            if ((i & 2) != 0) {
                str2 = httpUpgradeTransport.host;
            }
            return httpUpgradeTransport.copy(str, str2);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.host;
        }

        public final HttpUpgradeTransport copy(String path, String host) {
            j.e(path, "path");
            j.e(host, "host");
            return new HttpUpgradeTransport(path, host);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HttpUpgradeTransport)) {
                return false;
            }
            HttpUpgradeTransport httpUpgradeTransport = (HttpUpgradeTransport) obj;
            return j.a(this.path, httpUpgradeTransport.path) && j.a(this.host, httpUpgradeTransport.host);
        }

        public final String getHost() {
            return this.host;
        }

        public final String getPath() {
            return this.path;
        }

        public int hashCode() {
            return this.host.hashCode() + (this.path.hashCode() * 31);
        }

        public String toString() {
            return d1.h("HttpUpgradeTransport(path=", this.path, ", host=", this.host, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Hysteria2 {
        public static final int $stable = 0;
        private final String auth;
        private final int hopInterval;
        private final String hopPorts;
        private final String obfs;
        private final String obfsPassword;
        private final String pinSHA256;

        public Hysteria2(String auth, String pinSHA256, String obfs, String obfsPassword, String hopPorts, int i) {
            j.e(auth, "auth");
            j.e(pinSHA256, "pinSHA256");
            j.e(obfs, "obfs");
            j.e(obfsPassword, "obfsPassword");
            j.e(hopPorts, "hopPorts");
            this.auth = auth;
            this.pinSHA256 = pinSHA256;
            this.obfs = obfs;
            this.obfsPassword = obfsPassword;
            this.hopPorts = hopPorts;
            this.hopInterval = i;
        }

        public static /* synthetic */ Hysteria2 copy$default(Hysteria2 hysteria2, String str, String str2, String str3, String str4, String str5, int i, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = hysteria2.auth;
            }
            if ((i10 & 2) != 0) {
                str2 = hysteria2.pinSHA256;
            }
            if ((i10 & 4) != 0) {
                str3 = hysteria2.obfs;
            }
            if ((i10 & 8) != 0) {
                str4 = hysteria2.obfsPassword;
            }
            if ((i10 & 16) != 0) {
                str5 = hysteria2.hopPorts;
            }
            if ((i10 & 32) != 0) {
                i = hysteria2.hopInterval;
            }
            String str6 = str5;
            int i11 = i;
            return hysteria2.copy(str, str2, str3, str4, str6, i11);
        }

        public final String component1() {
            return this.auth;
        }

        public final String component2() {
            return this.pinSHA256;
        }

        public final String component3() {
            return this.obfs;
        }

        public final String component4() {
            return this.obfsPassword;
        }

        public final String component5() {
            return this.hopPorts;
        }

        public final int component6() {
            return this.hopInterval;
        }

        public final Hysteria2 copy(String auth, String pinSHA256, String obfs, String obfsPassword, String hopPorts, int i) {
            j.e(auth, "auth");
            j.e(pinSHA256, "pinSHA256");
            j.e(obfs, "obfs");
            j.e(obfsPassword, "obfsPassword");
            j.e(hopPorts, "hopPorts");
            return new Hysteria2(auth, pinSHA256, obfs, obfsPassword, hopPorts, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Hysteria2)) {
                return false;
            }
            Hysteria2 hysteria2 = (Hysteria2) obj;
            return j.a(this.auth, hysteria2.auth) && j.a(this.pinSHA256, hysteria2.pinSHA256) && j.a(this.obfs, hysteria2.obfs) && j.a(this.obfsPassword, hysteria2.obfsPassword) && j.a(this.hopPorts, hysteria2.hopPorts) && this.hopInterval == hysteria2.hopInterval;
        }

        public final String getAuth() {
            return this.auth;
        }

        public final int getHopInterval() {
            return this.hopInterval;
        }

        public final String getHopPorts() {
            return this.hopPorts;
        }

        public final String getObfs() {
            return this.obfs;
        }

        public final String getObfsPassword() {
            return this.obfsPassword;
        }

        public final String getPinSHA256() {
            return this.pinSHA256;
        }

        public int hashCode() {
            return Integer.hashCode(this.hopInterval) + s.d(s.d(s.d(s.d(this.auth.hashCode() * 31, 31, this.pinSHA256), 31, this.obfs), 31, this.obfsPassword), 31, this.hopPorts);
        }

        public String toString() {
            String str = this.auth;
            String str2 = this.pinSHA256;
            String str3 = this.obfs;
            String str4 = this.obfsPassword;
            String str5 = this.hopPorts;
            int i = this.hopInterval;
            StringBuilder sbN = s.n("Hysteria2(auth=", str, ", pinSHA256=", str2, ", obfs=");
            d1.x(sbN, str3, ", obfsPassword=", str4, ", hopPorts=");
            return s.i(i, str5, ", hopInterval=", ")", sbN);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Location {
        public static final int $stable = 0;
        private final String city;
        private final String country;
        private final String countryCode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11577id;
        private final Names names;
        private final int sort;

        public Location(String id2, String countryCode, String country, String city, int i, Names names) {
            j.e(id2, "id");
            j.e(countryCode, "countryCode");
            j.e(country, "country");
            j.e(city, "city");
            this.f11577id = id2;
            this.countryCode = countryCode;
            this.country = country;
            this.city = city;
            this.sort = i;
            this.names = names;
        }

        public static /* synthetic */ Location copy$default(Location location, String str, String str2, String str3, String str4, int i, Names names, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = location.f11577id;
            }
            if ((i10 & 2) != 0) {
                str2 = location.countryCode;
            }
            if ((i10 & 4) != 0) {
                str3 = location.country;
            }
            if ((i10 & 8) != 0) {
                str4 = location.city;
            }
            if ((i10 & 16) != 0) {
                i = location.sort;
            }
            if ((i10 & 32) != 0) {
                names = location.names;
            }
            int i11 = i;
            Names names2 = names;
            return location.copy(str, str2, str3, str4, i11, names2);
        }

        public final String component1() {
            return this.f11577id;
        }

        public final String component2() {
            return this.countryCode;
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

        public final Names component6() {
            return this.names;
        }

        public final Location copy(String id2, String countryCode, String country, String city, int i, Names names) {
            j.e(id2, "id");
            j.e(countryCode, "countryCode");
            j.e(country, "country");
            j.e(city, "city");
            return new Location(id2, countryCode, country, city, i, names);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Location)) {
                return false;
            }
            Location location = (Location) obj;
            return j.a(this.f11577id, location.f11577id) && j.a(this.countryCode, location.countryCode) && j.a(this.country, location.country) && j.a(this.city, location.city) && this.sort == location.sort && j.a(this.names, location.names);
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final String getId() {
            return this.f11577id;
        }

        public final Names getNames() {
            return this.names;
        }

        public final int getSort() {
            return this.sort;
        }

        public int hashCode() {
            int iC = androidx.compose.foundation.interaction.f.c(this.sort, s.d(s.d(s.d(this.f11577id.hashCode() * 31, 31, this.countryCode), 31, this.country), 31, this.city), 31);
            Names names = this.names;
            return iC + (names == null ? 0 : names.hashCode());
        }

        public String toString() {
            String str = this.f11577id;
            String str2 = this.countryCode;
            String str3 = this.country;
            String str4 = this.city;
            int i = this.sort;
            Names names = this.names;
            StringBuilder sbN = s.n("Location(id=", str, ", countryCode=", str2, ", country=");
            d1.x(sbN, str3, ", city=", str4, ", sort=");
            sbN.append(i);
            sbN.append(", names=");
            sbN.append(names);
            sbN.append(")");
            return sbN.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Mux {
        public static final int $stable = 0;
        private final int concurrency;
        private final boolean enabled;
        private final int xudpConcurrency;
        private final String xudpProxyUDP443;

        public Mux(boolean z10, int i, int i10, String xudpProxyUDP443) {
            j.e(xudpProxyUDP443, "xudpProxyUDP443");
            this.enabled = z10;
            this.concurrency = i;
            this.xudpConcurrency = i10;
            this.xudpProxyUDP443 = xudpProxyUDP443;
        }

        public static /* synthetic */ Mux copy$default(Mux mux, boolean z10, int i, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z10 = mux.enabled;
            }
            if ((i11 & 2) != 0) {
                i = mux.concurrency;
            }
            if ((i11 & 4) != 0) {
                i10 = mux.xudpConcurrency;
            }
            if ((i11 & 8) != 0) {
                str = mux.xudpProxyUDP443;
            }
            return mux.copy(z10, i, i10, str);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final int component2() {
            return this.concurrency;
        }

        public final int component3() {
            return this.xudpConcurrency;
        }

        public final String component4() {
            return this.xudpProxyUDP443;
        }

        public final Mux copy(boolean z10, int i, int i10, String xudpProxyUDP443) {
            j.e(xudpProxyUDP443, "xudpProxyUDP443");
            return new Mux(z10, i, i10, xudpProxyUDP443);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Mux)) {
                return false;
            }
            Mux mux = (Mux) obj;
            return this.enabled == mux.enabled && this.concurrency == mux.concurrency && this.xudpConcurrency == mux.xudpConcurrency && j.a(this.xudpProxyUDP443, mux.xudpProxyUDP443);
        }

        public final int getConcurrency() {
            return this.concurrency;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final int getXudpConcurrency() {
            return this.xudpConcurrency;
        }

        public final String getXudpProxyUDP443() {
            return this.xudpProxyUDP443;
        }

        public int hashCode() {
            return this.xudpProxyUDP443.hashCode() + androidx.compose.foundation.interaction.f.c(this.xudpConcurrency, androidx.compose.foundation.interaction.f.c(this.concurrency, Boolean.hashCode(this.enabled) * 31, 31), 31);
        }

        public String toString() {
            return "Mux(enabled=" + this.enabled + ", concurrency=" + this.concurrency + ", xudpConcurrency=" + this.xudpConcurrency + ", xudpProxyUDP443=" + this.xudpProxyUDP443 + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Names {
        public static final int $stable = 0;
        private final Place ar;
        private final Place en;

        /* JADX INFO: renamed from: fa, reason: collision with root package name */
        private final Place f11578fa;

        public Names(Place en, Place fa2, Place ar) {
            j.e(en, "en");
            j.e(fa2, "fa");
            j.e(ar, "ar");
            this.en = en;
            this.f11578fa = fa2;
            this.ar = ar;
        }

        public static /* synthetic */ Names copy$default(Names names, Place place, Place place2, Place place3, int i, Object obj) {
            if ((i & 1) != 0) {
                place = names.en;
            }
            if ((i & 2) != 0) {
                place2 = names.f11578fa;
            }
            if ((i & 4) != 0) {
                place3 = names.ar;
            }
            return names.copy(place, place2, place3);
        }

        public final Place component1() {
            return this.en;
        }

        public final Place component2() {
            return this.f11578fa;
        }

        public final Place component3() {
            return this.ar;
        }

        public final Names copy(Place en, Place fa2, Place ar) {
            j.e(en, "en");
            j.e(fa2, "fa");
            j.e(ar, "ar");
            return new Names(en, fa2, ar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Names)) {
                return false;
            }
            Names names = (Names) obj;
            return j.a(this.en, names.en) && j.a(this.f11578fa, names.f11578fa) && j.a(this.ar, names.ar);
        }

        public final Place get(String lang) {
            j.e(lang, "lang");
            int iHashCode = lang.hashCode();
            if (iHashCode == 3121) {
                if (lang.equals("ar")) {
                    return this.ar;
                }
                return null;
            }
            if (iHashCode == 3241) {
                if (lang.equals(GerehLocale.EN)) {
                    return this.en;
                }
                return null;
            }
            if (iHashCode == 3259 && lang.equals(GerehLocale.FA)) {
                return this.f11578fa;
            }
            return null;
        }

        public final Place getAr() {
            return this.ar;
        }

        public final Place getEn() {
            return this.en;
        }

        public final Place getFa() {
            return this.f11578fa;
        }

        public int hashCode() {
            return this.ar.hashCode() + ((this.f11578fa.hashCode() + (this.en.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "Names(en=" + this.en + ", fa=" + this.f11578fa + ", ar=" + this.ar + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Parsed {
        public static final int $stable = 8;
        private final List<Location> locations;
        private final List<Server> servers;
        private final List<Skipped> skipped;
        private final int version;

        public Parsed(int i, List<Location> locations, List<Server> servers, List<Skipped> skipped) {
            j.e(locations, "locations");
            j.e(servers, "servers");
            j.e(skipped, "skipped");
            this.version = i;
            this.locations = locations;
            this.servers = servers;
            this.skipped = skipped;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Parsed copy$default(Parsed parsed, int i, List list, List list2, List list3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i = parsed.version;
            }
            if ((i10 & 2) != 0) {
                list = parsed.locations;
            }
            if ((i10 & 4) != 0) {
                list2 = parsed.servers;
            }
            if ((i10 & 8) != 0) {
                list3 = parsed.skipped;
            }
            return parsed.copy(i, list, list2, list3);
        }

        public final int component1() {
            return this.version;
        }

        public final List<Location> component2() {
            return this.locations;
        }

        public final List<Server> component3() {
            return this.servers;
        }

        public final List<Skipped> component4() {
            return this.skipped;
        }

        public final Parsed copy(int i, List<Location> locations, List<Server> servers, List<Skipped> skipped) {
            j.e(locations, "locations");
            j.e(servers, "servers");
            j.e(skipped, "skipped");
            return new Parsed(i, locations, servers, skipped);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) obj;
            return this.version == parsed.version && j.a(this.locations, parsed.locations) && j.a(this.servers, parsed.servers) && j.a(this.skipped, parsed.skipped);
        }

        public final List<Location> getLocations() {
            return this.locations;
        }

        public final List<Server> getServers() {
            return this.servers;
        }

        public final List<Skipped> getSkipped() {
            return this.skipped;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.skipped.hashCode() + androidx.compose.foundation.interaction.f.f(androidx.compose.foundation.interaction.f.f(Integer.hashCode(this.version) * 31, 31, this.locations), 31, this.servers);
        }

        public String toString() {
            return "Parsed(version=" + this.version + ", locations=" + this.locations + ", servers=" + this.servers + ", skipped=" + this.skipped + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Place {
        public static final int $stable = 0;
        private final String city;
        private final String country;

        public Place(String country, String city) {
            j.e(country, "country");
            j.e(city, "city");
            this.country = country;
            this.city = city;
        }

        public static /* synthetic */ Place copy$default(Place place, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = place.country;
            }
            if ((i & 2) != 0) {
                str2 = place.city;
            }
            return place.copy(str, str2);
        }

        public final String component1() {
            return this.country;
        }

        public final String component2() {
            return this.city;
        }

        public final Place copy(String country, String city) {
            j.e(country, "country");
            j.e(city, "city");
            return new Place(country, city);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Place)) {
                return false;
            }
            Place place = (Place) obj;
            return j.a(this.country, place.country) && j.a(this.city, place.city);
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public int hashCode() {
            return this.city.hashCode() + (this.country.hashCode() * 31);
        }

        public String toString() {
            return d1.h("Place(country=", this.country, ", city=", this.city, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Raw {
        public static final int $stable = 0;
        private final String encryption;
        private final String fingerprint;
        private final String flow;
        private final String publicKey;
        private final String security;
        private final String shortId;
        private final String uuid;

        public Raw(String uuid, String encryption, String flow, String security, String publicKey, String shortId, String fingerprint) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(flow, "flow");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            this.uuid = uuid;
            this.encryption = encryption;
            this.flow = flow;
            this.security = security;
            this.publicKey = publicKey;
            this.shortId = shortId;
            this.fingerprint = fingerprint;
        }

        public static /* synthetic */ Raw copy$default(Raw raw, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = raw.uuid;
            }
            if ((i & 2) != 0) {
                str2 = raw.encryption;
            }
            if ((i & 4) != 0) {
                str3 = raw.flow;
            }
            if ((i & 8) != 0) {
                str4 = raw.security;
            }
            if ((i & 16) != 0) {
                str5 = raw.publicKey;
            }
            if ((i & 32) != 0) {
                str6 = raw.shortId;
            }
            if ((i & 64) != 0) {
                str7 = raw.fingerprint;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str5;
            String str11 = str3;
            return raw.copy(str, str2, str11, str4, str10, str8, str9);
        }

        public final String component1() {
            return this.uuid;
        }

        public final String component2() {
            return this.encryption;
        }

        public final String component3() {
            return this.flow;
        }

        public final String component4() {
            return this.security;
        }

        public final String component5() {
            return this.publicKey;
        }

        public final String component6() {
            return this.shortId;
        }

        public final String component7() {
            return this.fingerprint;
        }

        public final Raw copy(String uuid, String encryption, String flow, String security, String publicKey, String shortId, String fingerprint) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(flow, "flow");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            return new Raw(uuid, encryption, flow, security, publicKey, shortId, fingerprint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Raw)) {
                return false;
            }
            Raw raw = (Raw) obj;
            return j.a(this.uuid, raw.uuid) && j.a(this.encryption, raw.encryption) && j.a(this.flow, raw.flow) && j.a(this.security, raw.security) && j.a(this.publicKey, raw.publicKey) && j.a(this.shortId, raw.shortId) && j.a(this.fingerprint, raw.fingerprint);
        }

        public final String getEncryption() {
            return this.encryption;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getFlow() {
            return this.flow;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getSecurity() {
            return this.security;
        }

        public final String getShortId() {
            return this.shortId;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return this.fingerprint.hashCode() + s.d(s.d(s.d(s.d(s.d(this.uuid.hashCode() * 31, 31, this.encryption), 31, this.flow), 31, this.security), 31, this.publicKey), 31, this.shortId);
        }

        public String toString() {
            String str = this.uuid;
            String str2 = this.encryption;
            String str3 = this.flow;
            String str4 = this.security;
            String str5 = this.publicKey;
            String str6 = this.shortId;
            String str7 = this.fingerprint;
            StringBuilder sbN = s.n("Raw(uuid=", str, ", encryption=", str2, ", flow=");
            d1.x(sbN, str3, ", security=", str4, ", publicKey=");
            d1.x(sbN, str5, ", shortId=", str6, ", fingerprint=");
            return w0.r(sbN, str7, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class RealityBlock {
        public static final int $stable = 0;
        private final String fingerprint;
        private final String mldsa65Verify;
        private final String publicKey;
        private final String shortId;
        private final String spiderX;

        public RealityBlock(String publicKey, String shortId, String fingerprint, String spiderX, String mldsa65Verify) {
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            j.e(spiderX, "spiderX");
            j.e(mldsa65Verify, "mldsa65Verify");
            this.publicKey = publicKey;
            this.shortId = shortId;
            this.fingerprint = fingerprint;
            this.spiderX = spiderX;
            this.mldsa65Verify = mldsa65Verify;
        }

        public static /* synthetic */ RealityBlock copy$default(RealityBlock realityBlock, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = realityBlock.publicKey;
            }
            if ((i & 2) != 0) {
                str2 = realityBlock.shortId;
            }
            if ((i & 4) != 0) {
                str3 = realityBlock.fingerprint;
            }
            if ((i & 8) != 0) {
                str4 = realityBlock.spiderX;
            }
            if ((i & 16) != 0) {
                str5 = realityBlock.mldsa65Verify;
            }
            String str6 = str5;
            String str7 = str3;
            return realityBlock.copy(str, str2, str7, str4, str6);
        }

        public final String component1() {
            return this.publicKey;
        }

        public final String component2() {
            return this.shortId;
        }

        public final String component3() {
            return this.fingerprint;
        }

        public final String component4() {
            return this.spiderX;
        }

        public final String component5() {
            return this.mldsa65Verify;
        }

        public final RealityBlock copy(String publicKey, String shortId, String fingerprint, String spiderX, String mldsa65Verify) {
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(fingerprint, "fingerprint");
            j.e(spiderX, "spiderX");
            j.e(mldsa65Verify, "mldsa65Verify");
            return new RealityBlock(publicKey, shortId, fingerprint, spiderX, mldsa65Verify);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RealityBlock)) {
                return false;
            }
            RealityBlock realityBlock = (RealityBlock) obj;
            return j.a(this.publicKey, realityBlock.publicKey) && j.a(this.shortId, realityBlock.shortId) && j.a(this.fingerprint, realityBlock.fingerprint) && j.a(this.spiderX, realityBlock.spiderX) && j.a(this.mldsa65Verify, realityBlock.mldsa65Verify);
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getMldsa65Verify() {
            return this.mldsa65Verify;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getShortId() {
            return this.shortId;
        }

        public final String getSpiderX() {
            return this.spiderX;
        }

        public int hashCode() {
            return this.mldsa65Verify.hashCode() + s.d(s.d(s.d(this.publicKey.hashCode() * 31, 31, this.shortId), 31, this.fingerprint), 31, this.spiderX);
        }

        public String toString() {
            String str = this.publicKey;
            String str2 = this.shortId;
            String str3 = this.fingerprint;
            String str4 = this.spiderX;
            String str5 = this.mldsa65Verify;
            StringBuilder sbN = s.n("RealityBlock(publicKey=", str, ", shortId=", str2, ", fingerprint=");
            d1.x(sbN, str3, ", spiderX=", str4, ", mldsa65Verify=");
            return w0.r(sbN, str5, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Score {
        public static final int $stable = 0;
        private final double ms;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final double f11579n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final double f11580p;

        public Score(double d10, double d11, double d12) {
            this.f11580p = d10;
            this.f11579n = d11;
            this.ms = d12;
        }

        public static /* synthetic */ Score copy$default(Score score, double d10, double d11, double d12, int i, Object obj) {
            if ((i & 1) != 0) {
                d10 = score.f11580p;
            }
            double d13 = d10;
            if ((i & 2) != 0) {
                d11 = score.f11579n;
            }
            double d14 = d11;
            if ((i & 4) != 0) {
                d12 = score.ms;
            }
            return score.copy(d13, d14, d12);
        }

        public final double component1() {
            return this.f11580p;
        }

        public final double component2() {
            return this.f11579n;
        }

        public final double component3() {
            return this.ms;
        }

        public final Score copy(double d10, double d11, double d12) {
            return new Score(d10, d11, d12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Score)) {
                return false;
            }
            Score score = (Score) obj;
            return Double.compare(this.f11580p, score.f11580p) == 0 && Double.compare(this.f11579n, score.f11579n) == 0 && Double.compare(this.ms, score.ms) == 0;
        }

        public final double getMs() {
            return this.ms;
        }

        public final double getN() {
            return this.f11579n;
        }

        public final double getP() {
            return this.f11580p;
        }

        public int hashCode() {
            return Double.hashCode(this.ms) + androidx.compose.foundation.interaction.f.b(Double.hashCode(this.f11580p) * 31, 31, this.f11579n);
        }

        public String toString() {
            return "Score(p=" + this.f11580p + ", n=" + this.f11579n + ", ms=" + this.ms + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Skipped {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11582id;
        private final String why;

        public Skipped(String id2, String why) {
            j.e(id2, "id");
            j.e(why, "why");
            this.f11582id = id2;
            this.why = why;
        }

        public static /* synthetic */ Skipped copy$default(Skipped skipped, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = skipped.f11582id;
            }
            if ((i & 2) != 0) {
                str2 = skipped.why;
            }
            return skipped.copy(str, str2);
        }

        public final String component1() {
            return this.f11582id;
        }

        public final String component2() {
            return this.why;
        }

        public final Skipped copy(String id2, String why) {
            j.e(id2, "id");
            j.e(why, "why");
            return new Skipped(id2, why);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Skipped)) {
                return false;
            }
            Skipped skipped = (Skipped) obj;
            return j.a(this.f11582id, skipped.f11582id) && j.a(this.why, skipped.why);
        }

        public final String getId() {
            return this.f11582id;
        }

        public final String getWhy() {
            return this.why;
        }

        public int hashCode() {
            return this.why.hashCode() + (this.f11582id.hashCode() * 31);
        }

        public String toString() {
            return d1.h("Skipped(id=", this.f11582id, ", why=", this.why, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Sockopt {
        public static final int $stable = 0;
        private final String tcpCongestion;
        private final boolean tcpFastOpen;
        private final int tcpKeepAliveIdle;
        private final int tcpKeepAliveInterval;
        private final boolean tcpMptcp;

        public Sockopt(int i, int i10, boolean z10, boolean z11, String tcpCongestion) {
            j.e(tcpCongestion, "tcpCongestion");
            this.tcpKeepAliveIdle = i;
            this.tcpKeepAliveInterval = i10;
            this.tcpFastOpen = z10;
            this.tcpMptcp = z11;
            this.tcpCongestion = tcpCongestion;
        }

        public static /* synthetic */ Sockopt copy$default(Sockopt sockopt, int i, int i10, boolean z10, boolean z11, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i = sockopt.tcpKeepAliveIdle;
            }
            if ((i11 & 2) != 0) {
                i10 = sockopt.tcpKeepAliveInterval;
            }
            if ((i11 & 4) != 0) {
                z10 = sockopt.tcpFastOpen;
            }
            if ((i11 & 8) != 0) {
                z11 = sockopt.tcpMptcp;
            }
            if ((i11 & 16) != 0) {
                str = sockopt.tcpCongestion;
            }
            String str2 = str;
            boolean z12 = z10;
            return sockopt.copy(i, i10, z12, z11, str2);
        }

        public final int component1() {
            return this.tcpKeepAliveIdle;
        }

        public final int component2() {
            return this.tcpKeepAliveInterval;
        }

        public final boolean component3() {
            return this.tcpFastOpen;
        }

        public final boolean component4() {
            return this.tcpMptcp;
        }

        public final String component5() {
            return this.tcpCongestion;
        }

        public final Sockopt copy(int i, int i10, boolean z10, boolean z11, String tcpCongestion) {
            j.e(tcpCongestion, "tcpCongestion");
            return new Sockopt(i, i10, z10, z11, tcpCongestion);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Sockopt)) {
                return false;
            }
            Sockopt sockopt = (Sockopt) obj;
            return this.tcpKeepAliveIdle == sockopt.tcpKeepAliveIdle && this.tcpKeepAliveInterval == sockopt.tcpKeepAliveInterval && this.tcpFastOpen == sockopt.tcpFastOpen && this.tcpMptcp == sockopt.tcpMptcp && j.a(this.tcpCongestion, sockopt.tcpCongestion);
        }

        public final String getTcpCongestion() {
            return this.tcpCongestion;
        }

        public final boolean getTcpFastOpen() {
            return this.tcpFastOpen;
        }

        public final int getTcpKeepAliveIdle() {
            return this.tcpKeepAliveIdle;
        }

        public final int getTcpKeepAliveInterval() {
            return this.tcpKeepAliveInterval;
        }

        public final boolean getTcpMptcp() {
            return this.tcpMptcp;
        }

        public int hashCode() {
            return this.tcpCongestion.hashCode() + w0.d(w0.d(androidx.compose.foundation.interaction.f.c(this.tcpKeepAliveInterval, Integer.hashCode(this.tcpKeepAliveIdle) * 31, 31), 31, this.tcpFastOpen), 31, this.tcpMptcp);
        }

        public String toString() {
            int i = this.tcpKeepAliveIdle;
            int i10 = this.tcpKeepAliveInterval;
            boolean z10 = this.tcpFastOpen;
            boolean z11 = this.tcpMptcp;
            String str = this.tcpCongestion;
            StringBuilder sbU = androidx.compose.foundation.interaction.f.u("Sockopt(tcpKeepAliveIdle=", i, ", tcpKeepAliveInterval=", i10, ", tcpFastOpen=");
            s.x(sbU, z10, ", tcpMptcp=", z11, ", tcpCongestion=");
            return w0.r(sbU, str, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class TlsBlock {
        public static final int $stable = 8;
        private final List<String> alpn;
        private final String fingerprint;
        private final String pinSHA256;

        public TlsBlock(String fingerprint, List<String> alpn, String pinSHA256) {
            j.e(fingerprint, "fingerprint");
            j.e(alpn, "alpn");
            j.e(pinSHA256, "pinSHA256");
            this.fingerprint = fingerprint;
            this.alpn = alpn;
            this.pinSHA256 = pinSHA256;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TlsBlock copy$default(TlsBlock tlsBlock, String str, List list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tlsBlock.fingerprint;
            }
            if ((i & 2) != 0) {
                list = tlsBlock.alpn;
            }
            if ((i & 4) != 0) {
                str2 = tlsBlock.pinSHA256;
            }
            return tlsBlock.copy(str, list, str2);
        }

        public final String component1() {
            return this.fingerprint;
        }

        public final List<String> component2() {
            return this.alpn;
        }

        public final String component3() {
            return this.pinSHA256;
        }

        public final TlsBlock copy(String fingerprint, List<String> alpn, String pinSHA256) {
            j.e(fingerprint, "fingerprint");
            j.e(alpn, "alpn");
            j.e(pinSHA256, "pinSHA256");
            return new TlsBlock(fingerprint, alpn, pinSHA256);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TlsBlock)) {
                return false;
            }
            TlsBlock tlsBlock = (TlsBlock) obj;
            return j.a(this.fingerprint, tlsBlock.fingerprint) && j.a(this.alpn, tlsBlock.alpn) && j.a(this.pinSHA256, tlsBlock.pinSHA256);
        }

        public final List<String> getAlpn() {
            return this.alpn;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getPinSHA256() {
            return this.pinSHA256;
        }

        public int hashCode() {
            return this.pinSHA256.hashCode() + androidx.compose.foundation.interaction.f.f(this.fingerprint.hashCode() * 31, 31, this.alpn);
        }

        public String toString() {
            String str = this.fingerprint;
            List<String> list = this.alpn;
            String str2 = this.pinSHA256;
            StringBuilder sb2 = new StringBuilder("TlsBlock(fingerprint=");
            sb2.append(str);
            sb2.append(", alpn=");
            sb2.append(list);
            sb2.append(", pinSHA256=");
            return w0.r(sb2, str2, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class WsTransport {
        public static final int $stable = 0;
        private final int heartbeatPeriod;
        private final String host;
        private final String path;

        public WsTransport(String path, String host, int i) {
            j.e(path, "path");
            j.e(host, "host");
            this.path = path;
            this.host = host;
            this.heartbeatPeriod = i;
        }

        public static /* synthetic */ WsTransport copy$default(WsTransport wsTransport, String str, String str2, int i, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = wsTransport.path;
            }
            if ((i10 & 2) != 0) {
                str2 = wsTransport.host;
            }
            if ((i10 & 4) != 0) {
                i = wsTransport.heartbeatPeriod;
            }
            return wsTransport.copy(str, str2, i);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.host;
        }

        public final int component3() {
            return this.heartbeatPeriod;
        }

        public final WsTransport copy(String path, String host, int i) {
            j.e(path, "path");
            j.e(host, "host");
            return new WsTransport(path, host, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WsTransport)) {
                return false;
            }
            WsTransport wsTransport = (WsTransport) obj;
            return j.a(this.path, wsTransport.path) && j.a(this.host, wsTransport.host) && this.heartbeatPeriod == wsTransport.heartbeatPeriod;
        }

        public final int getHeartbeatPeriod() {
            return this.heartbeatPeriod;
        }

        public final String getHost() {
            return this.host;
        }

        public final String getPath() {
            return this.path;
        }

        public int hashCode() {
            return Integer.hashCode(this.heartbeatPeriod) + s.d(this.path.hashCode() * 31, 31, this.host);
        }

        public String toString() {
            String str = this.path;
            String str2 = this.host;
            return w0.q(s.n("WsTransport(path=", str, ", host=", str2, ", heartbeatPeriod="), this.heartbeatPeriod, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Xhttp {
        public static final int $stable = 0;
        private final String encryption;
        private final String maxPostBytes;
        private final String minPostInterval;
        private final String mode;
        private final String paddingBytes;
        private final String path;
        private final String publicKey;
        private final String security;
        private final String sessionIDLength;
        private final String sessionIDTable;
        private final String shortId;
        private final String uuid;

        public Xhttp(String uuid, String encryption, String security, String publicKey, String shortId, String path, String mode, String paddingBytes, String sessionIDLength, String sessionIDTable, String maxPostBytes, String minPostInterval) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(path, "path");
            j.e(mode, "mode");
            j.e(paddingBytes, "paddingBytes");
            j.e(sessionIDLength, "sessionIDLength");
            j.e(sessionIDTable, "sessionIDTable");
            j.e(maxPostBytes, "maxPostBytes");
            j.e(minPostInterval, "minPostInterval");
            this.uuid = uuid;
            this.encryption = encryption;
            this.security = security;
            this.publicKey = publicKey;
            this.shortId = shortId;
            this.path = path;
            this.mode = mode;
            this.paddingBytes = paddingBytes;
            this.sessionIDLength = sessionIDLength;
            this.sessionIDTable = sessionIDTable;
            this.maxPostBytes = maxPostBytes;
            this.minPostInterval = minPostInterval;
        }

        public static /* synthetic */ Xhttp copy$default(Xhttp xhttp, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, Object obj) {
            if ((i & 1) != 0) {
                str = xhttp.uuid;
            }
            if ((i & 2) != 0) {
                str2 = xhttp.encryption;
            }
            if ((i & 4) != 0) {
                str3 = xhttp.security;
            }
            if ((i & 8) != 0) {
                str4 = xhttp.publicKey;
            }
            if ((i & 16) != 0) {
                str5 = xhttp.shortId;
            }
            if ((i & 32) != 0) {
                str6 = xhttp.path;
            }
            if ((i & 64) != 0) {
                str7 = xhttp.mode;
            }
            if ((i & 128) != 0) {
                str8 = xhttp.paddingBytes;
            }
            if ((i & 256) != 0) {
                str9 = xhttp.sessionIDLength;
            }
            if ((i & 512) != 0) {
                str10 = xhttp.sessionIDTable;
            }
            if ((i & 1024) != 0) {
                str11 = xhttp.maxPostBytes;
            }
            if ((i & 2048) != 0) {
                str12 = xhttp.minPostInterval;
            }
            String str13 = str11;
            String str14 = str12;
            String str15 = str9;
            String str16 = str10;
            String str17 = str7;
            String str18 = str8;
            String str19 = str5;
            String str20 = str6;
            return xhttp.copy(str, str2, str3, str4, str19, str20, str17, str18, str15, str16, str13, str14);
        }

        public final String component1() {
            return this.uuid;
        }

        public final String component10() {
            return this.sessionIDTable;
        }

        public final String component11() {
            return this.maxPostBytes;
        }

        public final String component12() {
            return this.minPostInterval;
        }

        public final String component2() {
            return this.encryption;
        }

        public final String component3() {
            return this.security;
        }

        public final String component4() {
            return this.publicKey;
        }

        public final String component5() {
            return this.shortId;
        }

        public final String component6() {
            return this.path;
        }

        public final String component7() {
            return this.mode;
        }

        public final String component8() {
            return this.paddingBytes;
        }

        public final String component9() {
            return this.sessionIDLength;
        }

        public final Xhttp copy(String uuid, String encryption, String security, String publicKey, String shortId, String path, String mode, String paddingBytes, String sessionIDLength, String sessionIDTable, String maxPostBytes, String minPostInterval) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(security, "security");
            j.e(publicKey, "publicKey");
            j.e(shortId, "shortId");
            j.e(path, "path");
            j.e(mode, "mode");
            j.e(paddingBytes, "paddingBytes");
            j.e(sessionIDLength, "sessionIDLength");
            j.e(sessionIDTable, "sessionIDTable");
            j.e(maxPostBytes, "maxPostBytes");
            j.e(minPostInterval, "minPostInterval");
            return new Xhttp(uuid, encryption, security, publicKey, shortId, path, mode, paddingBytes, sessionIDLength, sessionIDTable, maxPostBytes, minPostInterval);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Xhttp)) {
                return false;
            }
            Xhttp xhttp = (Xhttp) obj;
            return j.a(this.uuid, xhttp.uuid) && j.a(this.encryption, xhttp.encryption) && j.a(this.security, xhttp.security) && j.a(this.publicKey, xhttp.publicKey) && j.a(this.shortId, xhttp.shortId) && j.a(this.path, xhttp.path) && j.a(this.mode, xhttp.mode) && j.a(this.paddingBytes, xhttp.paddingBytes) && j.a(this.sessionIDLength, xhttp.sessionIDLength) && j.a(this.sessionIDTable, xhttp.sessionIDTable) && j.a(this.maxPostBytes, xhttp.maxPostBytes) && j.a(this.minPostInterval, xhttp.minPostInterval);
        }

        public final String getEncryption() {
            return this.encryption;
        }

        public final String getMaxPostBytes() {
            return this.maxPostBytes;
        }

        public final String getMinPostInterval() {
            return this.minPostInterval;
        }

        public final String getMode() {
            return this.mode;
        }

        public final String getPaddingBytes() {
            return this.paddingBytes;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getSecurity() {
            return this.security;
        }

        public final String getSessionIDLength() {
            return this.sessionIDLength;
        }

        public final String getSessionIDTable() {
            return this.sessionIDTable;
        }

        public final String getShortId() {
            return this.shortId;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return this.minPostInterval.hashCode() + s.d(s.d(s.d(s.d(s.d(s.d(s.d(s.d(s.d(s.d(this.uuid.hashCode() * 31, 31, this.encryption), 31, this.security), 31, this.publicKey), 31, this.shortId), 31, this.path), 31, this.mode), 31, this.paddingBytes), 31, this.sessionIDLength), 31, this.sessionIDTable), 31, this.maxPostBytes);
        }

        public String toString() {
            String str = this.uuid;
            String str2 = this.encryption;
            String str3 = this.security;
            String str4 = this.publicKey;
            String str5 = this.shortId;
            String str6 = this.path;
            String str7 = this.mode;
            String str8 = this.paddingBytes;
            String str9 = this.sessionIDLength;
            String str10 = this.sessionIDTable;
            String str11 = this.maxPostBytes;
            String str12 = this.minPostInterval;
            StringBuilder sbN = s.n("Xhttp(uuid=", str, ", encryption=", str2, ", security=");
            d1.x(sbN, str3, ", publicKey=", str4, ", shortId=");
            d1.x(sbN, str5, ", path=", str6, ", mode=");
            d1.x(sbN, str7, ", paddingBytes=", str8, ", sessionIDLength=");
            d1.x(sbN, str9, ", sessionIDTable=", str10, ", maxPostBytes=");
            return d1.i(sbN, str11, ", minPostInterval=", str12, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Xmux {
        public static final int $stable = 0;
        private final String cMaxReuseTimes;
        private final int hKeepAlivePeriod;
        private final String hMaxRequestTimes;
        private final String hMaxReusableSecs;
        private final String maxConcurrency;
        private final String maxConnections;

        public Xmux(String maxConcurrency, String maxConnections, String cMaxReuseTimes, String hMaxRequestTimes, String hMaxReusableSecs, int i) {
            j.e(maxConcurrency, "maxConcurrency");
            j.e(maxConnections, "maxConnections");
            j.e(cMaxReuseTimes, "cMaxReuseTimes");
            j.e(hMaxRequestTimes, "hMaxRequestTimes");
            j.e(hMaxReusableSecs, "hMaxReusableSecs");
            this.maxConcurrency = maxConcurrency;
            this.maxConnections = maxConnections;
            this.cMaxReuseTimes = cMaxReuseTimes;
            this.hMaxRequestTimes = hMaxRequestTimes;
            this.hMaxReusableSecs = hMaxReusableSecs;
            this.hKeepAlivePeriod = i;
        }

        public static /* synthetic */ Xmux copy$default(Xmux xmux, String str, String str2, String str3, String str4, String str5, int i, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = xmux.maxConcurrency;
            }
            if ((i10 & 2) != 0) {
                str2 = xmux.maxConnections;
            }
            if ((i10 & 4) != 0) {
                str3 = xmux.cMaxReuseTimes;
            }
            if ((i10 & 8) != 0) {
                str4 = xmux.hMaxRequestTimes;
            }
            if ((i10 & 16) != 0) {
                str5 = xmux.hMaxReusableSecs;
            }
            if ((i10 & 32) != 0) {
                i = xmux.hKeepAlivePeriod;
            }
            String str6 = str5;
            int i11 = i;
            return xmux.copy(str, str2, str3, str4, str6, i11);
        }

        public final String component1() {
            return this.maxConcurrency;
        }

        public final String component2() {
            return this.maxConnections;
        }

        public final String component3() {
            return this.cMaxReuseTimes;
        }

        public final String component4() {
            return this.hMaxRequestTimes;
        }

        public final String component5() {
            return this.hMaxReusableSecs;
        }

        public final int component6() {
            return this.hKeepAlivePeriod;
        }

        public final Xmux copy(String maxConcurrency, String maxConnections, String cMaxReuseTimes, String hMaxRequestTimes, String hMaxReusableSecs, int i) {
            j.e(maxConcurrency, "maxConcurrency");
            j.e(maxConnections, "maxConnections");
            j.e(cMaxReuseTimes, "cMaxReuseTimes");
            j.e(hMaxRequestTimes, "hMaxRequestTimes");
            j.e(hMaxReusableSecs, "hMaxReusableSecs");
            return new Xmux(maxConcurrency, maxConnections, cMaxReuseTimes, hMaxRequestTimes, hMaxReusableSecs, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Xmux)) {
                return false;
            }
            Xmux xmux = (Xmux) obj;
            return j.a(this.maxConcurrency, xmux.maxConcurrency) && j.a(this.maxConnections, xmux.maxConnections) && j.a(this.cMaxReuseTimes, xmux.cMaxReuseTimes) && j.a(this.hMaxRequestTimes, xmux.hMaxRequestTimes) && j.a(this.hMaxReusableSecs, xmux.hMaxReusableSecs) && this.hKeepAlivePeriod == xmux.hKeepAlivePeriod;
        }

        public final String getCMaxReuseTimes() {
            return this.cMaxReuseTimes;
        }

        public final int getHKeepAlivePeriod() {
            return this.hKeepAlivePeriod;
        }

        public final String getHMaxRequestTimes() {
            return this.hMaxRequestTimes;
        }

        public final String getHMaxReusableSecs() {
            return this.hMaxReusableSecs;
        }

        public final String getMaxConcurrency() {
            return this.maxConcurrency;
        }

        public final String getMaxConnections() {
            return this.maxConnections;
        }

        public int hashCode() {
            return Integer.hashCode(this.hKeepAlivePeriod) + s.d(s.d(s.d(s.d(this.maxConcurrency.hashCode() * 31, 31, this.maxConnections), 31, this.cMaxReuseTimes), 31, this.hMaxRequestTimes), 31, this.hMaxReusableSecs);
        }

        public String toString() {
            String str = this.maxConcurrency;
            String str2 = this.maxConnections;
            String str3 = this.cMaxReuseTimes;
            String str4 = this.hMaxRequestTimes;
            String str5 = this.hMaxReusableSecs;
            int i = this.hKeepAlivePeriod;
            StringBuilder sbN = s.n("Xmux(maxConcurrency=", str, ", maxConnections=", str2, ", cMaxReuseTimes=");
            d1.x(sbN, str3, ", hMaxRequestTimes=", str4, ", hMaxReusableSecs=");
            return s.i(i, str5, ", hKeepAlivePeriod=", ")", sbN);
        }
    }

    private MamiCatalog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SHORT_ID_OK$lambda$23(String s8) {
        j.e(s8, "s");
        if (s8.length() <= 16 && s8.length() % 2 == 0) {
            for (int i = 0; i < s8.length(); i++) {
                if (INSTANCE.isHex(s8.charAt(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ byte[] b64uBytes$default(MamiCatalog mamiCatalog, Object obj, Integer num, int i, Object obj2) {
        if ((i & 2) != 0) {
            num = null;
        }
        return mamiCatalog.b64uBytes(obj, num);
    }

    private final Void bad(String str) throws CatalogException {
        throw new CatalogException(str);
    }

    private final boolean bool(Object obj) {
        return j.a(obj, Boolean.TRUE);
    }

    private final String fingerprint(Object obj, String str) {
        if (obj == null || obj.equals("")) {
            obj = MamiXrayConfig.FP;
        }
        return oneOf(obj, FINGERPRINTS, str);
    }

    private final boolean hasCtrl(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (INSTANCE.isCtrl(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private final int m300int(Object obj, long j, long j10, String str) throws CatalogException {
        MamiJs mamiJs = MamiJs.INSTANCE;
        if (!mamiJs.isInteger(obj)) {
            bad(str);
            throw new sd.c();
        }
        Double dNum = mamiJs.num(obj);
        j.b(dNum);
        double dDoubleValue = dNum.doubleValue();
        if (dDoubleValue >= j && dDoubleValue <= j10) {
            return (int) dDoubleValue;
        }
        bad(str);
        throw new sd.c();
    }

    private final boolean isAlnum(char c2) {
        if ('A' <= c2 && c2 < '[') {
            return true;
        }
        if ('a' > c2 || c2 >= '{') {
            return '0' <= c2 && c2 < ':';
        }
        return true;
    }

    private final boolean isBidi(char c2) {
        if (8234 > c2 || c2 >= 8239) {
            return 8294 <= c2 && c2 < 8298;
        }
        return true;
    }

    private final boolean isCountryCode(Object obj) {
        if ((obj instanceof String) && ((String) obj).length() == 2) {
            CharSequence charSequence = (CharSequence) obj;
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if ('A' <= cCharAt && cCharAt < '[') {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isCtrl(char c2) {
        if (c2 > 31) {
            return 127 <= c2 && c2 < 160;
        }
        return true;
    }

    private final boolean isCustomProfile(String str) {
        char cCharAt;
        int length = str.length();
        if (2 <= length && length < 9 && 'A' <= (cCharAt = str.charAt(0)) && cCharAt < '[') {
            String strB0 = o.B0(1, str);
            for (int i = 0; i < strB0.length(); i++) {
                char cCharAt2 = strB0.charAt(i);
                if (('A' <= cCharAt2 && cCharAt2 < '[') || INSTANCE.isDigit(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isDigit(char c2) {
        return '0' <= c2 && c2 < ':';
    }

    private final boolean isHex(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return true;
        }
        if ('a' > c2 || c2 >= 'g') {
            return 'A' <= c2 && c2 < 'G';
        }
        return true;
    }

    private final boolean isHiveId(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 13 && str.charAt(0) == 'h') {
                String strB0 = o.B0(1, str);
                for (int i = 0; i < strB0.length(); i++) {
                    char cCharAt = strB0.charAt(i);
                    if (('0' <= cCharAt && cCharAt < ':') || ('a' <= cCharAt && cCharAt < 'g')) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean isId(Object obj) {
        return (obj instanceof String) && isIdText((String) obj, 64);
    }

    private final boolean isIdText(String str, int i) {
        int length = str.length();
        if (1 <= length && length <= i) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (INSTANCE.isAlnum(cCharAt) || cCharAt == '_' || cCharAt == '-') {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isLabel(String str) {
        if (str.length() != 0 && str.length() <= 63 && isAlnum(o.E0(str)) && isAlnum(o.M0(str))) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (INSTANCE.isAlnum(cCharAt) || cCharAt == '-') {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isRange(String str) {
        int iI0 = o.I0('-', 0, 6, str);
        if (iI0 < 0) {
            return isRange$num(str);
        }
        String strSubstring = str.substring(0, iI0);
        j.d(strSubstring, "substring(...)");
        if (isRange$num(strSubstring)) {
            String strSubstring2 = str.substring(iI0 + 1);
            j.d(strSubstring2, "substring(...)");
            if (isRange$num(strSubstring2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isRange$num(String str) {
        char cCharAt;
        if (j.a(str, "0")) {
            return true;
        }
        if (str.length() > 0 && '1' <= (cCharAt = str.charAt(0)) && cCharAt < ':') {
            for (int i = 0; i < str.length(); i++) {
                if (INSTANCE.isDigit(str.charAt(i))) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isServiceName(String str, int i, int i10) {
        int length = str.length();
        if (i <= length && length <= i10) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (INSTANCE.isAlnum(cCharAt) || cCharAt == '.' || cCharAt == '_' || cCharAt == '~' || cCharAt == '-') {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isWsPath(String str) {
        if (str.length() > 0 && str.charAt(0) == '/') {
            String strB0 = o.B0(1, str);
            for (int i = 0; i < strB0.length(); i++) {
                char cCharAt = strB0.charAt(i);
                if (INSTANCE.isAlnum(cCharAt) || o.z0(WS_PATH_CHARS, cCharAt)) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean nonPrintableAscii(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~') {
                return true;
            }
        }
        return false;
    }

    private final Grpc normGrpc(Object obj) throws CatalogException {
        sf.c cVarObj = obj(obj, "grpc");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj2 = mamiJs.get(cVarObj, "serviceName");
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (isServiceName(str, 8, 128)) {
                return new Grpc(uuidOf(mamiJs.get(cVarObj, "uuid"), "grpc.uuid"), oneOf(mamiJs.get(cVarObj, "encryption"), m9.d.B("none"), "grpc.encryption"), oneOf(mamiJs.get(cVarObj, "security"), m9.d.B("reality"), "grpc.security"), publicKey(mamiJs.get(cVarObj, "publicKey"), "grpc.publicKey"), shortId(mamiJs.get(cVarObj, "shortId"), "grpc.shortId"), fingerprint(mamiJs.get(cVarObj, "fingerprint"), "grpc.fingerprint"), str, m300int(mamiJs.get(cVarObj, "multiConnections"), 1L, 8L, "grpc.multiConnections"));
            }
        }
        bad("grpc.serviceName");
        throw new sd.c();
    }

    private final Hysteria2 normHy2(Object obj) throws CatalogException {
        String strSubstring;
        int length;
        int length2;
        sf.c cVarObj = obj(obj, "hysteria2");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj2 = mamiJs.get(cVarObj, "obfs");
        String strSubstring2 = "";
        if (obj2 == null) {
            obj2 = "";
        }
        String strOneOf = oneOf(obj2, r.a0("", "salamander", "gecko"), "hysteria2.obfs");
        String strPlain = plain(mamiJs.get(cVarObj, "obfsPassword"), "hysteria2.obfsPassword", 128);
        if (strOneOf.length() > 0) {
            int length3 = strPlain.length();
            if (16 <= length3 && length3 < 129) {
                for (int i = 0; i < strPlain.length(); i++) {
                    char cCharAt = strPlain.charAt(i);
                    if (INSTANCE.isAlnum(cCharAt) || cCharAt == '_' || cCharAt == '-') {
                    }
                }
            }
            bad("hysteria2.obfsPassword");
            throw new sd.c();
        }
        if (!j.a(strPlain, "")) {
            bad("hysteria2.obfsPassword");
            throw new sd.c();
        }
        MamiJs mamiJs2 = MamiJs.INSTANCE;
        String strPlain2 = plain(mamiJs2.get(cVarObj, "hopPorts"), "hysteria2.hopPorts", 32);
        Object obj3 = mamiJs2.get(cVarObj, "hopInterval");
        if (obj3 == null) {
            obj3 = 0;
        }
        if (strPlain2.length() > 0) {
            int iI0 = o.I0('-', 0, 6, strPlain2);
            if (iI0 > 0) {
                strSubstring = strPlain2.substring(0, iI0);
                j.d(strSubstring, "substring(...)");
            } else {
                strSubstring = "";
            }
            if (iI0 > 0) {
                strSubstring2 = strPlain2.substring(iI0 + 1);
                j.d(strSubstring2, "substring(...)");
            }
            if (iI0 > 0 && 4 <= (length = strSubstring.length()) && length < 6 && 4 <= (length2 = strSubstring2.length()) && length2 < 6) {
                for (int i10 = 0; i10 < strSubstring.length(); i10++) {
                    if (INSTANCE.isDigit(strSubstring.charAt(i10))) {
                    }
                }
                for (int iM300int = 0; iM300int < strSubstring2.length(); iM300int++) {
                    if (INSTANCE.isDigit(strSubstring2.charAt(iM300int))) {
                    }
                }
                iM300int = (Integer.parseInt(strSubstring) >= 1024 && Integer.parseInt(strSubstring) < Integer.parseInt(strSubstring2) && Integer.parseInt(strSubstring2) <= 65535) ? m300int(obj3, 5L, 300L, "hysteria2.hopInterval") : 0;
            }
            bad("hysteria2.hopPorts");
            throw new sd.c();
        }
        Double dNum = mamiJs2.num(obj3);
        if (dNum == null || dNum.doubleValue() != 0.0d) {
            bad("hysteria2.hopInterval");
            throw new sd.c();
        }
        int i11 = iM300int;
        MamiJs mamiJs3 = MamiJs.INSTANCE;
        String strUuidOf = uuidOf(mamiJs3.get(cVarObj, "auth"), "hysteria2.auth");
        Object obj4 = mamiJs3.get(cVarObj, "pinSHA256");
        if (b64uBytes(obj4, 32) != null) {
            j.c(obj4, "null cannot be cast to non-null type kotlin.String");
            return new Hysteria2(strUuidOf, (String) obj4, strOneOf, strPlain, strPlain2, i11);
        }
        bad("hysteria2.pinSHA256");
        throw new sd.c();
    }

    private final Raw normRaw(Object obj) throws CatalogException {
        sf.c cVarObj = obj(obj, "raw");
        MamiJs mamiJs = MamiJs.INSTANCE;
        String strUuidOf = uuidOf(mamiJs.get(cVarObj, "uuid"), "raw.uuid");
        String strOneOf = oneOf(mamiJs.get(cVarObj, "encryption"), m9.d.B("none"), "raw.encryption");
        Object obj2 = mamiJs.get(cVarObj, "flow");
        if (obj2 == null) {
            obj2 = "";
        }
        oneOf(obj2, r.a0("", "xtls-rprx-vision"), "raw.flow");
        return new Raw(strUuidOf, strOneOf, "xtls-rprx-vision", oneOf(mamiJs.get(cVarObj, "security"), m9.d.B("reality"), "raw.security"), publicKey(mamiJs.get(cVarObj, "publicKey"), "raw.publicKey"), shortId(mamiJs.get(cVarObj, "shortId"), "raw.shortId"), fingerprint(mamiJs.get(cVarObj, "fingerprint"), "raw.fingerprint"));
    }

    private final Xhttp normXhttp(Object obj) throws CatalogException {
        String str;
        String strShortId;
        sf.c cVarObj = obj(obj, "xhttp");
        MamiJs mamiJs = MamiJs.INSTANCE;
        String strOneOf = oneOf(mamiJs.get(cVarObj, "security"), r.a0("tls", "reality"), "xhttp.security");
        Object obj2 = mamiJs.get(cVarObj, "path");
        if ((obj2 instanceof String) && ((CharSequence) obj2).length() != 0) {
            String str2 = (String) obj2;
            if (str2.charAt(0) == '/' && str2.length() <= 2048 && !hasCtrl(str2)) {
                Object obj3 = mamiJs.get(cVarObj, "encryption");
                if ((obj3 instanceof String) && ((CharSequence) obj3).length() != 0) {
                    String str3 = (String) obj3;
                    if (str3.length() <= 4096 && !hasCtrl(str3)) {
                        String strPlain = plain(mamiJs.get(cVarObj, "sessionIDTable"), "xhttp.sessionIDTable", 64);
                        if (nonPrintableAscii(strPlain)) {
                            bad("xhttp.sessionIDTable");
                            throw new sd.c();
                        }
                        String strUuidOf = uuidOf(mamiJs.get(cVarObj, "uuid"), "xhttp.uuid");
                        Object obj4 = mamiJs.get(cVarObj, "mode");
                        if (obj4 == null || obj4.equals("")) {
                            obj4 = "auto";
                        }
                        String strOneOf2 = oneOf(obj4, XHTTP_MODES, "xhttp.mode");
                        String strRange = range(mamiJs.get(cVarObj, "paddingBytes"), "xhttp.paddingBytes");
                        String strRange2 = range(mamiJs.get(cVarObj, "sessionIDLength"), "xhttp.sessionIDLength");
                        String strRange3 = range(mamiJs.get(cVarObj, "maxPostBytes"), "xhttp.maxPostBytes");
                        String strRange4 = range(mamiJs.get(cVarObj, "minPostInterval"), "xhttp.minPostInterval");
                        if (j.a(strOneOf, "reality")) {
                            String strPublicKey = publicKey(mamiJs.get(cVarObj, "publicKey"), "xhttp.publicKey");
                            strShortId = shortId(mamiJs.get(cVarObj, "shortId"), "xhttp.shortId");
                            str = strPublicKey;
                        } else {
                            str = "";
                            strShortId = str;
                        }
                        return new Xhttp(strUuidOf, str3, strOneOf, str, strShortId, str2, strOneOf2, strRange, strRange2, strPlain, strRange3, strRange4);
                    }
                }
                bad("xhttp.encryption");
                throw new sd.c();
            }
        }
        bad("xhttp.path");
        throw new sd.c();
    }

    public static /* synthetic */ Server normalizeServer$default(MamiCatalog mamiCatalog, Object obj, int i, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            i = 8;
        }
        return mamiCatalog.normalizeServer(obj, i);
    }

    private final sf.c obj(Object obj, String str) throws CatalogException {
        if (obj instanceof sf.c) {
            return (sf.c) obj;
        }
        bad(str);
        throw new sd.c();
    }

    private final String oneOf(Object obj, List<String> list, String str) throws CatalogException {
        if ((obj instanceof String) && list.contains(obj)) {
            return (String) obj;
        }
        bad(str);
        throw new sd.c();
    }

    private final sf.c placeJson(Place place) {
        sf.c cVar = new sf.c();
        cVar.D(TunnelVpnService.EXTRA_COUNTRY, place.getCountry());
        cVar.D("city", place.getCity());
        return cVar;
    }

    public static /* synthetic */ Place placeOf$default(MamiCatalog mamiCatalog, Server server, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = GerehLocale.FA;
        }
        return mamiCatalog.placeOf(server, str);
    }

    private final String plain(Object obj, String str, int i) throws CatalogException {
        if (obj == null || obj.equals("")) {
            return "";
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() <= i && !hasCtrl(str2)) {
                return str2;
            }
        }
        bad(str);
        throw new sd.c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0 A[RETURN] */
    private final String profileOf(sf.c cVar, String str, int i) throws CatalogException {
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj = mamiJs.get(cVar, "profile");
        if (obj != null && !obj.equals("")) {
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (isCustomProfile(str2)) {
                    if (PROFILES.contains(obj) || i >= 8) {
                        return str2;
                    }
                    bad("profile-custom");
                    throw new sd.c();
                }
            }
            bad("profile");
            throw new sd.c();
        }
        switch (str.hashCode()) {
            case -2104049249:
                if (str.equals("vless-grpc-reality")) {
                    return "VGR";
                }
                return "VXT";
            case -463551909:
                if (str.equals("hysteria2")) {
                    return "HY2";
                }
                return "VXT";
            case -259010366:
                return (str.equals("vless-xhttp") && j.a(mamiJs.get(mamiJs.get(cVar, "xhttp"), "security"), "reality")) ? "VXR" : "VXT";
            case 112293647:
                if (str.equals("vless")) {
                    bad("profile-missing");
                    throw new sd.c();
                }
                return "VXT";
            case 228052973:
                if (str.equals("vless-raw-reality")) {
                    return "VRR";
                }
                return "VXT";
            default:
                return "VXT";
        }
    }

    private final String publicKey(Object obj, String str) throws CatalogException {
        if (b64uBytes(obj, 32) != null) {
            j.c(obj, "null cannot be cast to non-null type kotlin.String");
            return (String) obj;
        }
        bad(str);
        throw new sd.c();
    }

    private final String range(Object obj, String str) throws CatalogException {
        String strPlain = plain(obj, str, 64);
        if (strPlain.length() <= 0 || isRange(strPlain)) {
            return strPlain;
        }
        bad(str);
        throw new sd.c();
    }

    private final String shortId(Object obj, String str) throws CatalogException {
        if (obj == null) {
            obj = "";
        }
        if ((obj instanceof String) && ((Boolean) SHORT_ID_OK.invoke(obj)).booleanValue()) {
            return (String) obj;
        }
        bad(str);
        throw new sd.c();
    }

    private final String text(Object obj, String str, int i) throws CatalogException {
        if (obj instanceof String) {
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.length() != 0) {
                String str2 = (String) obj;
                if (str2.length() <= i && obj.equals(MamiJs.INSTANCE.trim(str2))) {
                    for (int i10 = 0; i10 < charSequence.length(); i10++) {
                        char cCharAt = charSequence.charAt(i10);
                        MamiCatalog mamiCatalog = INSTANCE;
                        if (!mamiCatalog.isCtrl(cCharAt) && !mamiCatalog.isBidi(cCharAt) && cCharAt != '<' && cCharAt != '>') {
                        }
                    }
                    return str2;
                }
            }
        }
        bad(str);
        throw new sd.c();
    }

    public static /* synthetic */ String text$default(MamiCatalog mamiCatalog, Object obj, String str, int i, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            i = 64;
        }
        return mamiCatalog.text(obj, str, i);
    }

    private final String uuidOf(Object obj, String str) throws CatalogException {
        if (isUuid(obj)) {
            j.c(obj, "null cannot be cast to non-null type kotlin.String");
            return (String) obj;
        }
        bad(str);
        throw new sd.c();
    }

    private final String vlessEncryption(Object obj, String str, int i) throws CatalogException {
        if (j.a(obj, "none")) {
            return "none";
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() <= i) {
                List listA1 = o.a1((CharSequence) obj, new char[]{'.'}, 6);
                if (listA1.size() >= 4 && j.a(listA1.get(0), "mlkem768x25519plus") && r.a0("native", "xorpub", ConstKt.SEP_RANDOM).contains(listA1.get(1)) && r.a0("1rtt", "0rtt").contains(listA1.get(2))) {
                    List<String> listT0 = q.t0(listA1, 3);
                    if (!(listT0 instanceof Collection) || !listT0.isEmpty()) {
                        for (String str3 : listT0) {
                            if (str3.length() > 0) {
                                for (int i10 = 0; i10 < str3.length(); i10++) {
                                    char cCharAt = str3.charAt(i10);
                                    if (INSTANCE.isAlnum(cCharAt) || cCharAt == '_' || cCharAt == '-') {
                                    }
                                }
                            }
                        }
                    }
                    return str2;
                }
                bad(str);
                throw new sd.c();
            }
        }
        bad(str);
        throw new sd.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c vlessJson(Vless vless) {
        sf.c cVar = new sf.c();
        cVar.D("uuid", vless.getUuid());
        cVar.D("encryption", vless.getEncryption());
        cVar.D("flow", vless.getFlow());
        cVar.D(StudioError.NETWORK, vless.getNetwork());
        cVar.D("security", vless.getSecurity());
        if (j.a(vless.getNetwork(), "raw")) {
            cVar.D("raw", new sf.c());
        }
        WsTransport ws = vless.getWs();
        if (ws != null) {
            sf.c cVar2 = new sf.c();
            cVar2.D("path", ws.getPath());
            cVar2.D("host", ws.getHost());
            cVar2.D("heartbeatPeriod", Integer.valueOf(ws.getHeartbeatPeriod()));
            cVar.D("ws", cVar2);
        }
        HttpUpgradeTransport httpupgrade = vless.getHttpupgrade();
        if (httpupgrade != null) {
            sf.c cVar3 = new sf.c();
            cVar3.D("path", httpupgrade.getPath());
            cVar3.D("host", httpupgrade.getHost());
            cVar.D("httpupgrade", cVar3);
        }
        XhttpTransport xhttp = vless.getXhttp();
        if (xhttp != null) {
            sf.c cVar4 = new sf.c();
            cVar4.D("path", xhttp.getPath());
            cVar4.D("mode", xhttp.getMode());
            cVar4.D("host", xhttp.getHost());
            cVar4.D("paddingBytes", xhttp.getPaddingBytes());
            cVar4.D("sessionIDLength", xhttp.getSessionIDLength());
            cVar4.D("sessionIDTable", xhttp.getSessionIDTable());
            cVar4.D("maxPostBytes", xhttp.getMaxPostBytes());
            cVar4.D("minPostInterval", xhttp.getMinPostInterval());
            Xmux xmux = xhttp.getXmux();
            if (xmux != null) {
                sf.c cVar5 = new sf.c();
                cVar5.D("maxConcurrency", xmux.getMaxConcurrency());
                cVar5.D("maxConnections", xmux.getMaxConnections());
                cVar5.D("cMaxReuseTimes", xmux.getCMaxReuseTimes());
                cVar5.D("hMaxRequestTimes", xmux.getHMaxRequestTimes());
                cVar5.D("hMaxReusableSecs", xmux.getHMaxReusableSecs());
                cVar5.D("hKeepAlivePeriod", Integer.valueOf(xmux.getHKeepAlivePeriod()));
                cVar4.D("xmux", cVar5);
            }
            cVar.D("xhttp", cVar4);
        }
        GrpcTransport grpc = vless.getGrpc();
        if (grpc != null) {
            sf.c cVar6 = new sf.c();
            cVar6.D("serviceName", grpc.getServiceName());
            cVar6.E("multiMode", grpc.getMultiMode());
            cVar6.D("multiConnections", Integer.valueOf(grpc.getMultiConnections()));
            cVar6.D("authority", grpc.getAuthority());
            cVar6.D("idleTimeout", Integer.valueOf(grpc.getIdleTimeout()));
            cVar6.D("healthCheckTimeout", Integer.valueOf(grpc.getHealthCheckTimeout()));
            cVar6.E("permitWithoutStream", grpc.getPermitWithoutStream());
            cVar.D("grpc", cVar6);
        }
        RealityBlock reality = vless.getReality();
        if (reality != null) {
            sf.c cVar7 = new sf.c();
            cVar7.D("publicKey", reality.getPublicKey());
            cVar7.D("shortId", reality.getShortId());
            cVar7.D("fingerprint", reality.getFingerprint());
            cVar7.D("spiderX", reality.getSpiderX());
            cVar7.D("mldsa65Verify", reality.getMldsa65Verify());
            cVar.D("reality", cVar7);
        }
        TlsBlock tls = vless.getTls();
        if (tls != null) {
            sf.c cVar8 = new sf.c();
            cVar8.D("fingerprint", tls.getFingerprint());
            cVar8.D("alpn", new sf.a((Collection) tls.getAlpn()));
            cVar8.D("pinSHA256", tls.getPinSHA256());
            cVar.D("tls", cVar8);
        }
        Mux mux = vless.getMux();
        if (mux != null) {
            sf.c cVar9 = new sf.c();
            cVar9.E("enabled", mux.getEnabled());
            cVar9.D("concurrency", Integer.valueOf(mux.getConcurrency()));
            cVar9.D("xudpConcurrency", Integer.valueOf(mux.getXudpConcurrency()));
            cVar9.D("xudpProxyUDP443", mux.getXudpProxyUDP443());
            cVar.D("mux", cVar9);
        }
        Sockopt sockopt = vless.getSockopt();
        if (sockopt != null) {
            sf.c cVar10 = new sf.c();
            cVar10.D("tcpKeepAliveIdle", Integer.valueOf(sockopt.getTcpKeepAliveIdle()));
            cVar10.D("tcpKeepAliveInterval", Integer.valueOf(sockopt.getTcpKeepAliveInterval()));
            cVar10.E("tcpFastOpen", sockopt.getTcpFastOpen());
            cVar10.E("tcpMptcp", sockopt.getTcpMptcp());
            cVar10.D("tcpCongestion", sockopt.getTcpCongestion());
            cVar.D("sockopt", cVar10);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf.c xhttpJson(Xhttp xhttp) {
        sf.c cVar = new sf.c();
        cVar.D("uuid", xhttp.getUuid());
        cVar.D("encryption", xhttp.getEncryption());
        cVar.D("security", xhttp.getSecurity());
        cVar.D("publicKey", xhttp.getPublicKey());
        cVar.D("shortId", xhttp.getShortId());
        cVar.D("path", xhttp.getPath());
        cVar.D("mode", xhttp.getMode());
        cVar.D("paddingBytes", xhttp.getPaddingBytes());
        cVar.D("sessionIDLength", xhttp.getSessionIDLength());
        cVar.D("sessionIDTable", xhttp.getSessionIDTable());
        cVar.D("maxPostBytes", xhttp.getMaxPostBytes());
        cVar.D("minPostInterval", xhttp.getMinPostInterval());
        return cVar;
    }

    public final byte[] b64uBytes(Object obj, Integer num) {
        byte[] bArrCanonicalB64u;
        if (!(obj instanceof String) || (bArrCanonicalB64u = MamiJs.INSTANCE.canonicalB64u((String) obj)) == null) {
            return null;
        }
        if (num == null || bArrCanonicalB64u.length == num.intValue()) {
            return bArrCanonicalB64u;
        }
        return null;
    }

    public final Server exclusiveServer(String configJson) {
        j.e(configJson, "configJson");
        return new Server("exclusive", "", "پل اختصاصی", "", "exclusive", "vmess", "EXC", null, 0, null, 0, null, null, null, null, null, null, null, null, configJson, 524160, null);
    }

    public final List<String> getFINGERPRINTS() {
        return FINGERPRINTS;
    }

    public final List<String> getNETWORKS() {
        return NETWORKS;
    }

    public final List<String> getPROFILES() {
        return PROFILES;
    }

    public final List<String> getPROTOCOLS() {
        return PROTOCOLS;
    }

    public final List<String> getXHTTP_MODES() {
        return XHTTP_MODES;
    }

    public final long hiveRank(Server server, long j) {
        long jFloor = 0;
        if (j <= 0) {
            return MamiJs.MAX_SAFE_INTEGER;
        }
        Score score = server != null ? server.getScore() : null;
        if (score != null) {
            jFloor = (long) Math.floor((score.getN() / (score.getN() + ((double) 5))) * (((double) 1) - score.getP()) * ((double) 2500));
        }
        return j + jFloor;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    public final boolean isDomain(Object obj) {
        CharSequence charSequence;
        int i;
        char cCharAt;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() >= 3 && str.length() <= 253) {
                List listA1 = o.a1((CharSequence) obj, new char[]{'.'}, 6);
                if (listA1.size() >= 2) {
                    List list = listA1;
                    if ((list instanceof Collection) && list.isEmpty()) {
                        charSequence = (CharSequence) q.G0(listA1);
                        i = 0;
                        while (i < charSequence.length()) {
                            cCharAt = charSequence.charAt(i);
                            i = 'A' > cCharAt ? i + 1 : i + 1;
                            return true;
                        }
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (!INSTANCE.isLabel((String) it.next())) {
                        }
                    }
                    charSequence = (CharSequence) q.G0(listA1);
                    i = 0;
                    while (i < charSequence.length()) {
                        cCharAt = charSequence.charAt(i);
                        if (('A' > cCharAt && cCharAt < '[') || ('a' <= cCharAt && cCharAt < '{')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final boolean isPublicIPv4(Object obj) {
        int i;
        if (obj instanceof String) {
            List listA1 = o.a1((CharSequence) obj, new char[]{'.'}, 6);
            if (listA1.size() == 4) {
                List<String> list = listA1;
                boolean z10 = list instanceof Collection;
                if (!z10 || !list.isEmpty()) {
                    for (String str : list) {
                        int length = str.length();
                        if (1 <= length && length < 4) {
                            for (int i10 = 0; i10 < str.length(); i10++) {
                                if (INSTANCE.isDigit(str.charAt(i10))) {
                                }
                            }
                        }
                    }
                    if (z10 || !list.isEmpty()) {
                        for (String str2 : list) {
                            if (Integer.parseInt(str2) <= 255 || (str2.length() > 1 && str2.charAt(0) == '0')) {
                            }
                        }
                        i = Integer.parseInt((String) listA1.get(0));
                        int i11 = Integer.parseInt((String) listA1.get(1));
                        if (i == 0 && i != 10 && i != 127 && i < 224 && ((i != 169 || i11 != 254) && ((i != 172 || 16 > i11 || i11 >= 32) && (i != 192 || i11 != 168)))) {
                            return true;
                        }
                    } else {
                        i = Integer.parseInt((String) listA1.get(0));
                        int i12 = Integer.parseInt((String) listA1.get(1));
                        if (i == 0) {
                        }
                    }
                } else if (z10) {
                    while (r2.hasNext()) {
                        if (Integer.parseInt(str2) <= 255) {
                        }
                    }
                    i = Integer.parseInt((String) listA1.get(0));
                    int i13 = Integer.parseInt((String) listA1.get(1));
                    if (i == 0) {
                    }
                } else {
                    while (r2.hasNext()) {
                        if (Integer.parseInt(str2) <= 255) {
                        }
                    }
                    i = Integer.parseInt((String) listA1.get(0));
                    int i14 = Integer.parseInt((String) listA1.get(1));
                    if (i == 0) {
                    }
                }
            }
        }
        return false;
    }

    public final boolean isUuid(Object obj) {
        boolean zIsHex;
        if ((obj instanceof String) && ((String) obj).length() == 36) {
            Iterable nVar = new n(new androidx.activity.d((CharSequence) obj, 5), 1);
            if (!(nVar instanceof Collection) || !((Collection) nVar).isEmpty()) {
                Iterator it = nVar.iterator();
                do {
                    b0 b0Var = (b0) it;
                    if (b0Var.f23828b.hasNext()) {
                        a0 a0Var = (a0) b0Var.next();
                        int i = a0Var.f23823a;
                        char cCharValue = ((Character) a0Var.f23824b).charValue();
                        if (i == 8 || i == 13 || i == 18 || i == 23) {
                            zIsHex = cCharValue == '-';
                        } else {
                            zIsHex = INSTANCE.isHex(cCharValue);
                        }
                    }
                } while (zIsHex);
            }
            return true;
        }
        return false;
    }

    public final sf.c locationJson(Location l6) {
        Object objNamesJson;
        j.e(l6, "l");
        sf.c cVar = new sf.c();
        cVar.D(XrayCoreHostService.KEY_ID, l6.getId());
        cVar.D("countryCode", l6.getCountryCode());
        cVar.D(TunnelVpnService.EXTRA_COUNTRY, l6.getCountry());
        cVar.D("city", l6.getCity());
        cVar.D("sort", Integer.valueOf(l6.getSort()));
        Names names = l6.getNames();
        if (names == null || (objNamesJson = INSTANCE.namesJson(names)) == null) {
            objNamesJson = sf.c.f67157c;
        }
        cVar.D("names", objNamesJson);
        return cVar;
    }

    public final sf.c namesJson(Names n10) {
        j.e(n10, "n");
        sf.c cVar = new sf.c();
        cVar.D(GerehLocale.EN, placeJson(n10.getEn()));
        cVar.D(GerehLocale.FA, placeJson(n10.getFa()));
        cVar.D("ar", placeJson(n10.getAr()));
        return cVar;
    }

    public final Server normalizeHiveServer(Object obj) throws CatalogException {
        Score score;
        sf.c cVarObj = obj(obj, "server");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj2 = mamiJs.get(cVarObj, XrayCoreHostService.KEY_ID);
        if (!isHiveId(obj2)) {
            bad(XrayCoreHostService.KEY_ID);
            throw new sd.c();
        }
        Object obj3 = mamiJs.get(cVarObj, PsiphonProbeService.PORT);
        if (mamiJs.isInteger(obj3)) {
            Double dNum = mamiJs.num(obj3);
            j.b(dNum);
            if (dNum.doubleValue() >= 1.0d) {
                Double dNum2 = mamiJs.num(obj3);
                j.b(dNum2);
                if (dNum2.doubleValue() <= 65535.0d) {
                    Object obj4 = mamiJs.get(cVarObj, "tlsServerName");
                    if (!isDomain(obj4)) {
                        bad("tls-server-name");
                        throw new sd.c();
                    }
                    Object obj5 = mamiJs.get(cVarObj, "host");
                    if (!isPublicIPv4(obj5) && !isDomain(obj5)) {
                        bad("host");
                        throw new sd.c();
                    }
                    Vless vlessNormalizeVless = normalizeVless(mamiJs.get(cVarObj, "vless"));
                    Object obj6 = mamiJs.get(cVarObj, "score");
                    if (obj6 != null) {
                        sf.c cVarObj2 = obj(obj6, "score");
                        Object obj7 = mamiJs.get(cVarObj2, "p");
                        Object obj8 = mamiJs.get(cVarObj2, "n");
                        Object obj9 = mamiJs.get(cVarObj2, AwgProbeService.KEY_MS);
                        if (obj7 instanceof Number) {
                            Number number = (Number) obj7;
                            if (number.doubleValue() >= 0.0d && number.doubleValue() <= 1.0d && (obj8 instanceof Number)) {
                                Number number2 = (Number) obj8;
                                if (number2.doubleValue() >= 0.0d && number2.doubleValue() <= 1000000.0d && (obj9 instanceof Number)) {
                                    Number number3 = (Number) obj9;
                                    score = (number3.doubleValue() >= 0.0d && number3.doubleValue() <= 60000.0d) ? new Score(number.doubleValue(), number2.doubleValue(), number3.doubleValue()) : null;
                                }
                            }
                        }
                        bad("score");
                        throw new sd.c();
                    }
                    Score score2 = score;
                    j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                    j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                    Double dNum3 = mamiJs.num(obj3);
                    j.b(dNum3);
                    int iDoubleValue = (int) dNum3.doubleValue();
                    j.c(obj4, "null cannot be cast to non-null type kotlin.String");
                    return new Server((String) obj2, "", "پل لیون", "", "hive", "vless", "HIVE", (String) obj5, iDoubleValue, (String) obj4, 1000, null, null, null, null, null, null, vlessNormalizeVless, score2, null, 651264, null);
                }
            }
        }
        bad(PsiphonProbeService.PORT);
        throw new sd.c();
    }

    public final Location normalizeLocation(Object obj, int i) throws CatalogException {
        int i10;
        Names names;
        sf.c cVarObj = obj(obj, "location");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj2 = mamiJs.get(cVarObj, XrayCoreHostService.KEY_ID);
        if (!isId(obj2)) {
            bad("location-id");
            throw new sd.c();
        }
        Object obj3 = mamiJs.get(cVarObj, "countryCode");
        if (!isCountryCode(obj3)) {
            bad("location-country-code");
            throw new sd.c();
        }
        String strText$default = text$default(this, mamiJs.get(cVarObj, TunnelVpnService.EXTRA_COUNTRY), "location-country", 0, 4, null);
        String strText$default2 = text$default(this, mamiJs.get(cVarObj, "city"), "location-city", 0, 4, null);
        if (i >= 4) {
            int iM300int = m300int(mamiJs.get(cVarObj, "sort"), 0L, CfUsage.FREE_DAILY, "location-sort");
            sf.c cVarObj2 = obj(mamiJs.get(cVarObj, "names"), "location-names");
            List<String> listA0 = r.a0(GerehLocale.EN, GerehLocale.FA, "ar");
            ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(listA0, 10));
            for (String str : listA0) {
                MamiCatalog mamiCatalog = INSTANCE;
                MamiJs mamiJs2 = MamiJs.INSTANCE;
                sf.c cVarObj3 = mamiCatalog.obj(mamiJs2.get(cVarObj2, str), v0.a.h("location-names-", str));
                arrayList.add(new Place(mamiCatalog.text(mamiJs2.get(cVarObj3, TunnelVpnService.EXTRA_COUNTRY), "location-names-country", 96), mamiCatalog.text(mamiJs2.get(cVarObj3, "city"), "location-names-city", 96)));
                iM300int = iM300int;
            }
            i10 = iM300int;
            names = new Names((Place) arrayList.get(0), (Place) arrayList.get(1), (Place) arrayList.get(2));
        } else {
            i10 = 1000;
            names = null;
        }
        j.c(obj2, "null cannot be cast to non-null type kotlin.String");
        j.c(obj3, "null cannot be cast to non-null type kotlin.String");
        return new Location((String) obj2, (String) obj3, strText$default, strText$default2, i10, names);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        if (hasCtrl(r4) == false) goto L43;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Server normalizeServer(Object obj, int i) throws CatalogException {
        String str;
        sf.c cVarObj = obj(obj, "server");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj2 = mamiJs.get(cVarObj, XrayCoreHostService.KEY_ID);
        if (!isId(obj2)) {
            bad(XrayCoreHostService.KEY_ID);
            throw new sd.c();
        }
        String strOneOf = oneOf(mamiJs.get(cVarObj, "protocol"), PROTOCOLS, "protocol");
        Object obj3 = mamiJs.get(cVarObj, "countryCode");
        if (!isCountryCode(obj3)) {
            bad("country-code");
            throw new sd.c();
        }
        Object obj4 = mamiJs.get(cVarObj, PsiphonProbeService.PORT);
        if (mamiJs.isInteger(obj4)) {
            Double dNum = mamiJs.num(obj4);
            j.b(dNum);
            if (dNum.doubleValue() >= 1.0d) {
                Double dNum2 = mamiJs.num(obj4);
                j.b(dNum2);
                if (dNum2.doubleValue() <= 65535.0d) {
                    Object obj5 = mamiJs.get(cVarObj, "tlsServerName");
                    if (!isDomain(obj5)) {
                        bad("tls-server-name");
                        throw new sd.c();
                    }
                    Object obj6 = mamiJs.get(cVarObj, "host");
                    if (!j.a(strOneOf, "trojan") ? isPublicIPv4(obj6) || isDomain(obj6) : isDomain(obj6)) {
                        bad("host");
                        throw new sd.c();
                    }
                    String strText$default = text$default(this, mamiJs.get(cVarObj, TunnelVpnService.EXTRA_COUNTRY), TunnelVpnService.EXTRA_COUNTRY, 0, 4, null);
                    String strText$default2 = text$default(this, mamiJs.get(cVarObj, "city"), "city", 0, 4, null);
                    String strProfileOf = profileOf(cVarObj, strOneOf, i);
                    Object obj7 = mamiJs.get(cVarObj, "locationId");
                    if (obj7 == null || obj7.equals("")) {
                        obj7 = obj2;
                    }
                    if (!isId(obj7)) {
                        bad("location-id");
                        throw new sd.c();
                    }
                    if (j.a(strOneOf, "trojan")) {
                        Object obj8 = mamiJs.get(cVarObj, "password");
                        if ((obj8 instanceof String) && ((CharSequence) obj8).length() != 0) {
                            str = (String) obj8;
                            if (str.length() <= 1024) {
                            }
                        }
                        bad("password");
                        throw new sd.c();
                    }
                    str = null;
                    String str2 = str;
                    j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                    j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                    j.c(obj7, "null cannot be cast to non-null type kotlin.String");
                    j.c(obj6, "null cannot be cast to non-null type kotlin.String");
                    Double dNum3 = mamiJs.num(obj4);
                    j.b(dNum3);
                    int iDoubleValue = (int) dNum3.doubleValue();
                    j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                    Server server = new Server((String) obj2, (String) obj3, strText$default, strText$default2, (String) obj7, strOneOf, strProfileOf, (String) obj6, iDoubleValue, (String) obj5, 0, null, str2, null, null, null, null, null, null, null, 1043456, null);
                    switch (strOneOf.hashCode()) {
                        case -2104049249:
                            if (strOneOf.equals("vless-grpc-reality")) {
                                return Server.copy$default(server, null, null, null, null, null, null, null, null, 0, null, 0, null, null, null, null, null, normGrpc(mamiJs.get(cVarObj, "grpc")), null, null, null, 983039, null);
                            }
                            return server;
                        case -463551909:
                            if (strOneOf.equals("hysteria2")) {
                                return Server.copy$default(server, null, null, null, null, null, null, null, null, 0, null, 0, null, null, null, null, normHy2(mamiJs.get(cVarObj, "hysteria2")), null, null, null, null, 1015807, null);
                            }
                            return server;
                        case -259010366:
                            if (strOneOf.equals("vless-xhttp")) {
                                return Server.copy$default(server, null, null, null, null, null, null, null, null, 0, null, 0, null, null, normXhttp(mamiJs.get(cVarObj, "xhttp")), null, null, null, null, null, null, 1040383, null);
                            }
                            return server;
                        case 112293647:
                            if (strOneOf.equals("vless")) {
                                Server serverCopy$default = Server.copy$default(server, null, null, null, null, null, null, null, null, 0, null, 0, null, null, null, null, null, null, normalizeVless(mamiJs.get(cVarObj, "vless")), null, null, 917503, null);
                                if (!PROFILES.contains(strProfileOf)) {
                                    return serverCopy$default;
                                }
                                bad("profile-known-for-vless");
                                throw new sd.c();
                            }
                            return server;
                        case 228052973:
                            if (strOneOf.equals("vless-raw-reality")) {
                                return Server.copy$default(server, null, null, null, null, null, null, null, null, 0, null, 0, null, null, null, normRaw(mamiJs.get(cVarObj, "raw")), null, null, null, null, null, 1032191, null);
                            }
                            return server;
                        default:
                            return server;
                    }
                }
            }
        }
        bad(PsiphonProbeService.PORT);
        throw new sd.c();
    }

    /* JADX WARN: Code duplicated, block: B:121:0x035b A[PHI: r19 r21 r33 r34
      0x035b: PHI (r19v1 java.lang.String) = (r19v0 java.lang.String), (r19v6 java.lang.String) binds: [B:119:0x034e, B:116:0x033c] A[DONT_GENERATE, DONT_INLINE]
      0x035b: PHI (r21v1 int) = (r21v0 int), (r21v8 int) binds: [B:119:0x034e, B:116:0x033c] A[DONT_GENERATE, DONT_INLINE]
      0x035b: PHI (r33v1 java.lang.String) = (r33v0 java.lang.String), (r33v5 java.lang.String) binds: [B:119:0x034e, B:116:0x033c] A[DONT_GENERATE, DONT_INLINE]
      0x035b: PHI (r34v1 java.lang.String) = (r34v0 java.lang.String), (r34v5 java.lang.String) binds: [B:119:0x034e, B:116:0x033c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:123:0x0371  */
    /* JADX WARN: Code duplicated, block: B:136:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:138:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:139:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:142:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:229:0x05f5  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Vless normalizeVless(Object obj) throws CatalogException {
        String str;
        String str2;
        String str3;
        int iM300int;
        sf.c cVarObj;
        Object obj2;
        String str4;
        String strPlain;
        Object obj3;
        Object obj4;
        HttpUpgradeTransport httpUpgradeTransport;
        WsTransport wsTransport;
        XhttpTransport xhttpTransport;
        GrpcTransport grpcTransport;
        Object obj5;
        int iM300int2;
        TlsBlock tlsBlock;
        List<Object> listItems;
        String str5;
        TlsBlock tlsBlock2;
        RealityBlock realityBlock;
        Mux mux;
        Sockopt sockopt;
        Xmux xmux;
        sf.c cVarObj2 = obj(obj, "vless");
        MamiJs mamiJs = MamiJs.INSTANCE;
        String strOneOf = oneOf(mamiJs.get(cVarObj2, StudioError.NETWORK), NETWORKS, "vless.network");
        String str6 = "tls";
        String strOneOf2 = oneOf(mamiJs.get(cVarObj2, "security"), r.a0("tls", "reality"), "vless.security");
        Object obj6 = mamiJs.get(cVarObj2, "flow");
        if (obj6 == null) {
            obj6 = "";
        }
        String strOneOf3 = oneOf(obj6, r.a0("", "xtls-rprx-vision"), "vless.flow");
        if (strOneOf3.length() > 0 && !j.a(strOneOf, "raw")) {
            bad("vless.flow");
            throw new sd.c();
        }
        String strUuidOf = uuidOf(mamiJs.get(cVarObj2, "uuid"), "vless.uuid");
        String strVlessEncryption = vlessEncryption(mamiJs.get(cVarObj2, "encryption"), "vless.encryption", 2048);
        int iHashCode = strOneOf.hashCode();
        if (iHashCode != -1041340268) {
            if (iHashCode == 3804) {
                str = "";
                str2 = strOneOf3;
                str3 = strUuidOf;
                iM300int = 0;
                if (strOneOf.equals("ws")) {
                    cVarObj = obj(mamiJs.get(cVarObj2, strOneOf), "vless.".concat(strOneOf));
                    obj2 = mamiJs.get(cVarObj, "path");
                    if (obj2 instanceof String) {
                        str4 = (String) obj2;
                        if (str4.length() <= 2048 && isWsPath(str4)) {
                            strPlain = plain(mamiJs.get(cVarObj, "host"), w0.n("vless.", strOneOf, ".host"), 253);
                            if (strPlain.length() <= 0 && !isDomain(strPlain)) {
                                bad(w0.n("vless.", strOneOf, ".host"));
                                throw new sd.c();
                            }
                            if (strOneOf.equals("ws")) {
                                obj5 = mamiJs.get(cVarObj, "heartbeatPeriod");
                                if (obj5 == null) {
                                    iM300int2 = iM300int;
                                    obj3 = "ws";
                                    obj4 = "httpupgrade";
                                } else {
                                    obj4 = "httpupgrade";
                                    obj3 = "ws";
                                    iM300int2 = m300int(obj5, 0L, 300L, "vless.ws.heartbeatPeriod");
                                }
                                wsTransport = new WsTransport(str4, strPlain, iM300int2);
                                cVarObj2 = cVarObj2;
                                httpUpgradeTransport = null;
                            } else {
                                str6 = "tls";
                                obj3 = "ws";
                                obj4 = "httpupgrade";
                                httpUpgradeTransport = new HttpUpgradeTransport(str4, strPlain);
                                cVarObj2 = cVarObj2;
                                wsTransport = null;
                            }
                            xhttpTransport = null;
                            grpcTransport = null;
                        }
                    }
                    bad(w0.n("vless.", strOneOf, ".path"));
                    throw new sd.c();
                }
            } else if (iHashCode == 3181598) {
                str = "";
                str2 = strOneOf3;
                str3 = strUuidOf;
                if (strOneOf.equals("grpc")) {
                    sf.c cVarObj3 = obj(mamiJs.get(cVarObj2, "grpc"), "vless.grpc");
                    Object obj7 = mamiJs.get(cVarObj3, "serviceName");
                    if (obj7 instanceof String) {
                        String str7 = (String) obj7;
                        if (isServiceName(str7, 1, 128)) {
                            String strPlain2 = plain(mamiJs.get(cVarObj3, "authority"), "vless.grpc.authority", 253);
                            if (strPlain2.length() > 0 && !isDomain(strPlain2)) {
                                bad("vless.grpc.authority");
                                throw new sd.c();
                            }
                            Object obj8 = mamiJs.get(cVarObj3, "multiConnections");
                            int iM300int3 = obj8 == null ? 0 : INSTANCE.m300int(obj8, 0L, 8L, "vless.grpc.multiConnections");
                            Object obj9 = mamiJs.get(cVarObj3, "idleTimeout");
                            int iM300int4 = obj9 == null ? 0 : INSTANCE.m300int(obj9, 0L, 600L, "vless.grpc.idleTimeout");
                            Object obj10 = mamiJs.get(cVarObj3, "healthCheckTimeout");
                            GrpcTransport grpcTransport2 = new GrpcTransport(str7, bool(mamiJs.get(cVarObj3, "multiMode")), iM300int3, strPlain2, iM300int4, obj10 == null ? 0 : INSTANCE.m300int(obj10, 0L, 120L, "vless.grpc.healthCheckTimeout"), bool(mamiJs.get(cVarObj3, "permitWithoutStream")));
                            if (grpcTransport2.getIdleTimeout() != 0 && grpcTransport2.getIdleTimeout() < 10) {
                                bad("vless.grpc.idleTimeout");
                                throw new sd.c();
                            }
                            if (grpcTransport2.getHealthCheckTimeout() != 0 && grpcTransport2.getHealthCheckTimeout() < 5) {
                                bad("vless.grpc.healthCheckTimeout");
                                throw new sd.c();
                            }
                            grpcTransport = grpcTransport2;
                            httpUpgradeTransport = null;
                            wsTransport = null;
                            xhttpTransport = null;
                            iM300int = 0;
                            obj3 = "ws";
                            obj4 = "httpupgrade";
                        }
                    }
                    bad("vless.grpc.serviceName");
                    throw new sd.c();
                }
                iM300int = 0;
            } else {
                if (iHashCode == 114035968 && strOneOf.equals("xhttp")) {
                    sf.c cVarObj4 = obj(mamiJs.get(cVarObj2, "xhttp"), "vless.xhttp");
                    Object obj11 = mamiJs.get(cVarObj4, "path");
                    if ((obj11 instanceof String) && ((CharSequence) obj11).length() != 0) {
                        String str8 = (String) obj11;
                        str2 = strOneOf3;
                        if (str8.charAt(0) == '/' && str8.length() <= 2048 && !hasCtrl(str8)) {
                            Object obj12 = mamiJs.get(cVarObj4, "mode");
                            if (obj12 == null || obj12.equals("")) {
                                obj12 = "auto";
                            }
                            String strOneOf4 = oneOf(obj12, XHTTP_MODES, "vless.xhttp.mode");
                            String strPlain3 = plain(mamiJs.get(cVarObj4, "host"), "vless.xhttp.host", 253);
                            String strRange = range(mamiJs.get(cVarObj4, "paddingBytes"), "vless.xhttp.paddingBytes");
                            String strRange2 = range(mamiJs.get(cVarObj4, "sessionIDLength"), "vless.xhttp.sessionIDLength");
                            str3 = strUuidOf;
                            String strPlain4 = plain(mamiJs.get(cVarObj4, "sessionIDTable"), "vless.xhttp.sessionIDTable", 64);
                            str = "";
                            String strRange3 = range(mamiJs.get(cVarObj4, "maxPostBytes"), "vless.xhttp.maxPostBytes");
                            String strRange4 = range(mamiJs.get(cVarObj4, "minPostInterval"), "vless.xhttp.minPostInterval");
                            if (nonPrintableAscii(strPlain4)) {
                                bad("vless.xhttp.sessionIDTable");
                                throw new sd.c();
                            }
                            if (strPlain3.length() > 0 && !isDomain(strPlain3)) {
                                bad("vless.xhttp.host");
                                throw new sd.c();
                            }
                            Object obj13 = mamiJs.get(cVarObj4, "xmux");
                            if (obj13 != null) {
                                sf.c cVarObj5 = obj(obj13, "vless.xhttp.xmux");
                                String strRange5 = range(mamiJs.get(cVarObj5, "maxConcurrency"), "xmux.maxConcurrency");
                                String strRange6 = range(mamiJs.get(cVarObj5, "maxConnections"), "xmux.maxConnections");
                                String strRange7 = range(mamiJs.get(cVarObj5, "cMaxReuseTimes"), "xmux.cMaxReuseTimes");
                                String strRange8 = range(mamiJs.get(cVarObj5, "hMaxRequestTimes"), "xmux.hMaxRequestTimes");
                                String strRange9 = range(mamiJs.get(cVarObj5, "hMaxReusableSecs"), "xmux.hMaxReusableSecs");
                                Object obj14 = mamiJs.get(cVarObj5, "hKeepAlivePeriod");
                                Xmux xmux2 = new Xmux(strRange5, strRange6, strRange7, strRange8, strRange9, obj14 == null ? 0 : INSTANCE.m300int(obj14, 0L, 600L, "xmux.hKeepAlivePeriod"));
                                if (xmux2.getMaxConcurrency().length() > 0 && xmux2.getMaxConnections().length() > 0) {
                                    bad("xmux.both");
                                    throw new sd.c();
                                }
                                xmux = xmux2;
                            } else {
                                xmux = null;
                            }
                            xhttpTransport = new XhttpTransport(str8, strOneOf4, strPlain3, strRange, strRange2, strPlain4, strRange3, strRange4, xmux);
                            httpUpgradeTransport = null;
                            wsTransport = null;
                            grpcTransport = null;
                            iM300int = 0;
                            obj3 = "ws";
                            obj4 = "httpupgrade";
                        }
                    }
                    bad("vless.xhttp.path");
                    throw new sd.c();
                }
                str = "";
                str2 = strOneOf3;
                str3 = strUuidOf;
                iM300int = 0;
            }
            cVarObj2 = cVarObj2;
            str6 = "tls";
            httpUpgradeTransport = null;
            wsTransport = null;
            xhttpTransport = null;
            grpcTransport = null;
            obj3 = "ws";
            obj4 = "httpupgrade";
        } else {
            str = "";
            str2 = strOneOf3;
            str3 = strUuidOf;
            iM300int = 0;
            if (strOneOf.equals("httpupgrade")) {
                cVarObj = obj(mamiJs.get(cVarObj2, strOneOf), "vless.".concat(strOneOf));
                obj2 = mamiJs.get(cVarObj, "path");
                if (obj2 instanceof String) {
                    str4 = (String) obj2;
                    if (str4.length() <= 2048) {
                        strPlain = plain(mamiJs.get(cVarObj, "host"), w0.n("vless.", strOneOf, ".host"), 253);
                        if (strPlain.length() <= 0) {
                        }
                        if (strOneOf.equals("ws")) {
                            obj5 = mamiJs.get(cVarObj, "heartbeatPeriod");
                            if (obj5 == null) {
                                iM300int2 = iM300int;
                                obj3 = "ws";
                                obj4 = "httpupgrade";
                            } else {
                                obj4 = "httpupgrade";
                                obj3 = "ws";
                                iM300int2 = m300int(obj5, 0L, 300L, "vless.ws.heartbeatPeriod");
                            }
                            wsTransport = new WsTransport(str4, strPlain, iM300int2);
                            cVarObj2 = cVarObj2;
                            httpUpgradeTransport = null;
                        } else {
                            str6 = "tls";
                            obj3 = "ws";
                            obj4 = "httpupgrade";
                            httpUpgradeTransport = new HttpUpgradeTransport(str4, strPlain);
                            cVarObj2 = cVarObj2;
                            wsTransport = null;
                        }
                        xhttpTransport = null;
                        grpcTransport = null;
                    }
                }
                bad(w0.n("vless.", strOneOf, ".path"));
                throw new sd.c();
            }
            cVarObj2 = cVarObj2;
            str6 = "tls";
            httpUpgradeTransport = null;
            wsTransport = null;
            xhttpTransport = null;
            grpcTransport = null;
            obj3 = "ws";
            obj4 = "httpupgrade";
        }
        if (!j.a(strOneOf2, "reality")) {
            tlsBlock = null;
            sf.c cVarObj6 = obj(mamiJs.get(cVarObj2, str6), "vless.tls");
            Object obj15 = mamiJs.get(cVarObj6, "alpn");
            if (obj15 == null) {
                listItems = w.INSTANCE;
            } else {
                listItems = mamiJs.items(obj15);
                if (listItems == null) {
                    bad("vless.tls.alpn");
                    throw new sd.c();
                }
            }
            if (listItems.size() <= 3) {
                List<Object> list = listItems;
                if (q.p1(list).size() == listItems.size()) {
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (Object obj16 : list) {
                            if (!(obj16 instanceof String) || !r.a0("h2", "http/1.1", "h3").contains(obj16)) {
                            }
                        }
                    }
                    MamiJs mamiJs2 = MamiJs.INSTANCE;
                    Object obj17 = mamiJs2.get(cVarObj6, "pinSHA256");
                    str5 = str;
                    if (obj17 != null && !obj17.equals(str5) && b64uBytes(obj17, 32) == null) {
                        bad("vless.tls.pinSHA256");
                        throw new sd.c();
                    }
                    String strFingerprint = fingerprint(mamiJs2.get(cVarObj6, "fingerprint"), "vless.tls.fingerprint");
                    ArrayList arrayList = new ArrayList(kotlin.collections.s.g0(list, 10));
                    for (Object obj18 : list) {
                        j.c(obj18, "null cannot be cast to non-null type kotlin.String");
                        arrayList.add((String) obj18);
                    }
                    String str9 = (String) obj17;
                    if (str9 == null) {
                        str9 = str5;
                    }
                    tlsBlock2 = new TlsBlock(strFingerprint, arrayList, str9);
                    realityBlock = null;
                }
            }
            bad("vless.tls.alpn");
            throw new sd.c();
        }
        if (strOneOf.equals(obj3) || strOneOf.equals(obj4)) {
            bad("vless.reality-network");
            throw new sd.c();
        }
        sf.c cVarObj7 = obj(mamiJs.get(cVarObj2, "reality"), "vless.reality");
        String strPlain5 = plain(mamiJs.get(cVarObj7, "spiderX"), "vless.reality.spiderX", 256);
        String strPlain6 = plain(mamiJs.get(cVarObj7, "mldsa65Verify"), "vless.reality.mldsa65Verify", 256);
        if (strPlain6.length() > 0) {
            tlsBlock = null;
            if (b64uBytes$default(this, strPlain6, null, 2, null) == null) {
                bad("vless.reality.mldsa65Verify");
                throw new sd.c();
            }
        } else {
            tlsBlock = null;
        }
        realityBlock = new RealityBlock(publicKey(mamiJs.get(cVarObj7, "publicKey"), "vless.reality.publicKey"), shortId(mamiJs.get(cVarObj7, "shortId"), "vless.reality.shortId"), fingerprint(mamiJs.get(cVarObj7, "fingerprint"), "vless.reality.fingerprint"), strPlain5, strPlain6);
        tlsBlock2 = tlsBlock;
        str5 = str;
        MamiJs mamiJs3 = MamiJs.INSTANCE;
        Object obj19 = mamiJs3.get(cVarObj2, "mux");
        if (obj19 != null) {
            sf.c cVarObj8 = obj(obj19, "vless.mux");
            boolean zBool = bool(mamiJs3.get(cVarObj8, "enabled"));
            Object obj20 = mamiJs3.get(cVarObj8, "concurrency");
            int iM300int5 = obj20 == null ? iM300int : INSTANCE.m300int(obj20, 0L, 16L, "vless.mux.concurrency");
            Object obj21 = mamiJs3.get(cVarObj8, "xudpConcurrency");
            int iM300int6 = obj21 == null ? iM300int : INSTANCE.m300int(obj21, 0L, 128L, "vless.mux.xudpConcurrency");
            Object obj22 = mamiJs3.get(cVarObj8, "xudpProxyUDP443");
            if (obj22 == null) {
                obj22 = str5;
            }
            String strOneOf5 = oneOf(obj22, r.a0(str5, "reject", Central.NOHWID_ALLOW, "skip"), "vless.mux.xudpProxyUDP443");
            if (!zBool && (iM300int5 != 0 || iM300int6 != 0 || strOneOf5.length() > 0)) {
                bad("vless.mux.disabled");
                throw new sd.c();
            }
            if (zBool && str2.length() > 0) {
                bad("vless.mux.flow");
                throw new sd.c();
            }
            if (zBool) {
                mux = new Mux(true, iM300int5, iM300int6, strOneOf5);
            } else {
                mux = tlsBlock;
            }
        } else {
            mux = tlsBlock;
        }
        Object obj23 = mamiJs3.get(cVarObj2, "sockopt");
        if (obj23 != null) {
            sf.c cVarObj9 = obj(obj23, "vless.sockopt");
            Object obj24 = mamiJs3.get(cVarObj9, "tcpKeepAliveIdle");
            int iM300int7 = obj24 == null ? iM300int : INSTANCE.m300int(obj24, 0L, 600L, "vless.sockopt.idle");
            Object obj25 = mamiJs3.get(cVarObj9, "tcpKeepAliveInterval");
            if (obj25 != null) {
                iM300int = INSTANCE.m300int(obj25, 0L, 600L, "vless.sockopt.interval");
            }
            int i = iM300int;
            boolean zBool2 = bool(mamiJs3.get(cVarObj9, "tcpFastOpen"));
            boolean zBool3 = bool(mamiJs3.get(cVarObj9, "tcpMptcp"));
            Object obj26 = mamiJs3.get(cVarObj9, "tcpCongestion");
            if (obj26 == null) {
                obj26 = str5;
            }
            sockopt = new Sockopt(iM300int7, i, zBool2, zBool3, oneOf(obj26, r.a0(str5, "bbr", "cubic", "reno"), "vless.sockopt.congestion"));
        } else {
            sockopt = tlsBlock;
        }
        return new Vless(str3, strVlessEncryption, str2, strOneOf, strOneOf2, wsTransport, httpUpgradeTransport, xhttpTransport, grpcTransport, realityBlock, tlsBlock2, mux, sockopt);
    }

    public final Parsed parseCatalog(sf.c payload) throws CatalogException {
        j.e(payload, "payload");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj = mamiJs.get(payload, ConstKt.SEP_VERSION);
        if (mamiJs.isInteger(obj)) {
            Double dNum = mamiJs.num(obj);
            j.b(dNum);
            if (dNum.doubleValue() >= 1.0d) {
                Double dNum2 = mamiJs.num(obj);
                j.b(dNum2);
                if (dNum2.doubleValue() <= 8.0d) {
                    Double dNum3 = mamiJs.num(obj);
                    j.b(dNum3);
                    int iDoubleValue = (int) dNum3.doubleValue();
                    List<Object> listItems = mamiJs.items(mamiJs.get(payload, "servers"));
                    if (listItems == null) {
                        bad("servers");
                        throw new sd.c();
                    }
                    List<Object> listItems2 = mamiJs.items(mamiJs.get(payload, "locations"));
                    if (iDoubleValue >= 3 && (listItems2 == null || listItems2.isEmpty())) {
                        bad("locations");
                        throw new sd.c();
                    }
                    ArrayList arrayList = new ArrayList();
                    HashMap map = new HashMap();
                    if (listItems2 == null) {
                        listItems2 = w.INSTANCE;
                    }
                    Iterator it = q.e1(listItems2, 200).iterator();
                    while (it.hasNext()) {
                        try {
                            Location locationNormalizeLocation = normalizeLocation(it.next(), iDoubleValue);
                            if (!map.containsKey(locationNormalizeLocation.getId())) {
                                map.put(locationNormalizeLocation.getId(), locationNormalizeLocation);
                                arrayList.add(locationNormalizeLocation);
                            }
                        } catch (CatalogException unused) {
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    HashSet hashSet = new HashSet();
                    for (Object obj2 : q.e1(listItems, 200)) {
                        Object obj3 = MamiJs.INSTANCE.get(obj2, XrayCoreHostService.KEY_ID);
                        String strL1 = obj3 instanceof String ? o.l1(64, (String) obj3) : "?";
                        try {
                            Server serverNormalizeServer = normalizeServer(obj2, iDoubleValue);
                            if (!hashSet.add(serverNormalizeServer.getId())) {
                                bad("duplicate-id");
                                throw new sd.c();
                            }
                            Location location = (Location) map.get(serverNormalizeServer.getLocationId());
                            arrayList2.add(Server.copy$default(serverNormalizeServer, null, null, null, null, null, null, null, null, 0, null, location != null ? location.getSort() : 1000, location != null ? location.getNames() : null, null, null, null, null, null, null, null, null, 1045503, null));
                        } catch (CatalogException e10) {
                            arrayList3.add(new Skipped(strL1, e10.getWhy()));
                        }
                    }
                    return new Parsed(iDoubleValue, arrayList, arrayList2, arrayList3);
                }
            }
        }
        bad(ConstKt.SEP_VERSION);
        throw new sd.c();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cb  */
    public final Hive parseHive(sf.c payload) throws CatalogException {
        int iDoubleValue;
        j.e(payload, "payload");
        MamiJs mamiJs = MamiJs.INSTANCE;
        Object obj = mamiJs.get(payload, "revision");
        if (mamiJs.isSafeInteger(obj)) {
            Double dNum = mamiJs.num(obj);
            j.b(dNum);
            if (dNum.doubleValue() >= 0.0d) {
                List<Object> listItems = mamiJs.items(mamiJs.get(payload, "servers"));
                if (listItems == null) {
                    bad("servers");
                    throw new sd.c();
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (Object obj2 : q.e1(listItems, 64)) {
                    Object obj3 = MamiJs.INSTANCE.get(obj2, XrayCoreHostService.KEY_ID);
                    String strL1 = obj3 instanceof String ? o.l1(64, (String) obj3) : "?";
                    try {
                        Server serverNormalizeHiveServer = normalizeHiveServer(obj2);
                        if (hashSet.add(serverNormalizeHiveServer.getId())) {
                            arrayList.add(serverNormalizeHiveServer);
                        }
                    } catch (CatalogException e10) {
                        arrayList2.add(new Skipped(strL1, e10.getWhy()));
                    }
                }
                MamiJs mamiJs2 = MamiJs.INSTANCE;
                Object obj4 = mamiJs2.get(payload, "testIntervalMinutes");
                if (mamiJs2.isInteger(obj4)) {
                    Double dNum2 = mamiJs2.num(obj4);
                    j.b(dNum2);
                    if (dNum2.doubleValue() >= 30.0d) {
                        Double dNum3 = mamiJs2.num(obj4);
                        j.b(dNum3);
                        if (dNum3.doubleValue() <= 1440.0d) {
                            Double dNum4 = mamiJs2.num(obj4);
                            j.b(dNum4);
                            iDoubleValue = (int) dNum4.doubleValue();
                        } else {
                            iDoubleValue = 0;
                        }
                    } else {
                        iDoubleValue = 0;
                    }
                } else {
                    iDoubleValue = 0;
                }
                int i = iDoubleValue;
                Object obj5 = mamiJs2.get(payload, "assignment");
                long jM302long = mamiJs2.m302long(obj);
                if (!(obj5 instanceof sf.c) && !(obj5 instanceof sf.a)) {
                    obj5 = null;
                }
                return new Hive(jM302long, arrayList, arrayList2, obj5, i);
            }
        }
        bad("hive-revision");
        throw new sd.c();
    }

    public final Place placeOf(Server s8, String lang) {
        Place en;
        j.e(s8, "s");
        j.e(lang, "lang");
        Names names = s8.getNames();
        if (names != null) {
            en = names.get(lang);
            if (en == null) {
                en = names.getEn();
            }
        } else {
            en = null;
        }
        return en == null ? new Place(s8.getCountry(), s8.getCity()) : en;
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class XhttpTransport {
        public static final int $stable = 0;
        private final String host;
        private final String maxPostBytes;
        private final String minPostInterval;
        private final String mode;
        private final String paddingBytes;
        private final String path;
        private final String sessionIDLength;
        private final String sessionIDTable;
        private final Xmux xmux;

        public XhttpTransport(String path, String mode, String host, String paddingBytes, String sessionIDLength, String sessionIDTable, String maxPostBytes, String minPostInterval, Xmux xmux) {
            j.e(path, "path");
            j.e(mode, "mode");
            j.e(host, "host");
            j.e(paddingBytes, "paddingBytes");
            j.e(sessionIDLength, "sessionIDLength");
            j.e(sessionIDTable, "sessionIDTable");
            j.e(maxPostBytes, "maxPostBytes");
            j.e(minPostInterval, "minPostInterval");
            this.path = path;
            this.mode = mode;
            this.host = host;
            this.paddingBytes = paddingBytes;
            this.sessionIDLength = sessionIDLength;
            this.sessionIDTable = sessionIDTable;
            this.maxPostBytes = maxPostBytes;
            this.minPostInterval = minPostInterval;
            this.xmux = xmux;
        }

        public static /* synthetic */ XhttpTransport copy$default(XhttpTransport xhttpTransport, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Xmux xmux, int i, Object obj) {
            if ((i & 1) != 0) {
                str = xhttpTransport.path;
            }
            if ((i & 2) != 0) {
                str2 = xhttpTransport.mode;
            }
            if ((i & 4) != 0) {
                str3 = xhttpTransport.host;
            }
            if ((i & 8) != 0) {
                str4 = xhttpTransport.paddingBytes;
            }
            if ((i & 16) != 0) {
                str5 = xhttpTransport.sessionIDLength;
            }
            if ((i & 32) != 0) {
                str6 = xhttpTransport.sessionIDTable;
            }
            if ((i & 64) != 0) {
                str7 = xhttpTransport.maxPostBytes;
            }
            if ((i & 128) != 0) {
                str8 = xhttpTransport.minPostInterval;
            }
            if ((i & 256) != 0) {
                xmux = xhttpTransport.xmux;
            }
            String str9 = str8;
            Xmux xmux2 = xmux;
            String str10 = str6;
            String str11 = str7;
            String str12 = str5;
            String str13 = str3;
            return xhttpTransport.copy(str, str2, str13, str4, str12, str10, str11, str9, xmux2);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.mode;
        }

        public final String component3() {
            return this.host;
        }

        public final String component4() {
            return this.paddingBytes;
        }

        public final String component5() {
            return this.sessionIDLength;
        }

        public final String component6() {
            return this.sessionIDTable;
        }

        public final String component7() {
            return this.maxPostBytes;
        }

        public final String component8() {
            return this.minPostInterval;
        }

        public final Xmux component9() {
            return this.xmux;
        }

        public final XhttpTransport copy(String path, String mode, String host, String paddingBytes, String sessionIDLength, String sessionIDTable, String maxPostBytes, String minPostInterval, Xmux xmux) {
            j.e(path, "path");
            j.e(mode, "mode");
            j.e(host, "host");
            j.e(paddingBytes, "paddingBytes");
            j.e(sessionIDLength, "sessionIDLength");
            j.e(sessionIDTable, "sessionIDTable");
            j.e(maxPostBytes, "maxPostBytes");
            j.e(minPostInterval, "minPostInterval");
            return new XhttpTransport(path, mode, host, paddingBytes, sessionIDLength, sessionIDTable, maxPostBytes, minPostInterval, xmux);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof XhttpTransport)) {
                return false;
            }
            XhttpTransport xhttpTransport = (XhttpTransport) obj;
            return j.a(this.path, xhttpTransport.path) && j.a(this.mode, xhttpTransport.mode) && j.a(this.host, xhttpTransport.host) && j.a(this.paddingBytes, xhttpTransport.paddingBytes) && j.a(this.sessionIDLength, xhttpTransport.sessionIDLength) && j.a(this.sessionIDTable, xhttpTransport.sessionIDTable) && j.a(this.maxPostBytes, xhttpTransport.maxPostBytes) && j.a(this.minPostInterval, xhttpTransport.minPostInterval) && j.a(this.xmux, xhttpTransport.xmux);
        }

        public final String getHost() {
            return this.host;
        }

        public final String getMaxPostBytes() {
            return this.maxPostBytes;
        }

        public final String getMinPostInterval() {
            return this.minPostInterval;
        }

        public final String getMode() {
            return this.mode;
        }

        public final String getPaddingBytes() {
            return this.paddingBytes;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getSessionIDLength() {
            return this.sessionIDLength;
        }

        public final String getSessionIDTable() {
            return this.sessionIDTable;
        }

        public final Xmux getXmux() {
            return this.xmux;
        }

        public int hashCode() {
            int iD = s.d(s.d(s.d(s.d(s.d(s.d(s.d(this.path.hashCode() * 31, 31, this.mode), 31, this.host), 31, this.paddingBytes), 31, this.sessionIDLength), 31, this.sessionIDTable), 31, this.maxPostBytes), 31, this.minPostInterval);
            Xmux xmux = this.xmux;
            return iD + (xmux == null ? 0 : xmux.hashCode());
        }

        public String toString() {
            String str = this.path;
            String str2 = this.mode;
            String str3 = this.host;
            String str4 = this.paddingBytes;
            String str5 = this.sessionIDLength;
            String str6 = this.sessionIDTable;
            String str7 = this.maxPostBytes;
            String str8 = this.minPostInterval;
            Xmux xmux = this.xmux;
            StringBuilder sbN = s.n("XhttpTransport(path=", str, ", mode=", str2, ", host=");
            d1.x(sbN, str3, ", paddingBytes=", str4, ", sessionIDLength=");
            d1.x(sbN, str5, ", sessionIDTable=", str6, ", maxPostBytes=");
            d1.x(sbN, str7, ", minPostInterval=", str8, ", xmux=");
            sbN.append(xmux);
            sbN.append(")");
            return sbN.toString();
        }

        public /* synthetic */ XhttpTransport(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Xmux xmux, int i, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, str4, str5, str6, str7, str8, (i & 256) != 0 ? null : xmux);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Vless {
        public static final int $stable = 8;
        private final String encryption;
        private final String flow;
        private final GrpcTransport grpc;
        private final HttpUpgradeTransport httpupgrade;
        private final Mux mux;
        private final String network;
        private final RealityBlock reality;
        private final String security;
        private final Sockopt sockopt;
        private final TlsBlock tls;
        private final String uuid;
        private final WsTransport ws;
        private final XhttpTransport xhttp;

        public Vless(String uuid, String encryption, String flow, String network, String security, WsTransport wsTransport, HttpUpgradeTransport httpUpgradeTransport, XhttpTransport xhttpTransport, GrpcTransport grpcTransport, RealityBlock realityBlock, TlsBlock tlsBlock, Mux mux, Sockopt sockopt) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(flow, "flow");
            j.e(network, "network");
            j.e(security, "security");
            this.uuid = uuid;
            this.encryption = encryption;
            this.flow = flow;
            this.network = network;
            this.security = security;
            this.ws = wsTransport;
            this.httpupgrade = httpUpgradeTransport;
            this.xhttp = xhttpTransport;
            this.grpc = grpcTransport;
            this.reality = realityBlock;
            this.tls = tlsBlock;
            this.mux = mux;
            this.sockopt = sockopt;
        }

        public static /* synthetic */ Vless copy$default(Vless vless, String str, String str2, String str3, String str4, String str5, WsTransport wsTransport, HttpUpgradeTransport httpUpgradeTransport, XhttpTransport xhttpTransport, GrpcTransport grpcTransport, RealityBlock realityBlock, TlsBlock tlsBlock, Mux mux, Sockopt sockopt, int i, Object obj) {
            if ((i & 1) != 0) {
                str = vless.uuid;
            }
            return vless.copy(str, (i & 2) != 0 ? vless.encryption : str2, (i & 4) != 0 ? vless.flow : str3, (i & 8) != 0 ? vless.network : str4, (i & 16) != 0 ? vless.security : str5, (i & 32) != 0 ? vless.ws : wsTransport, (i & 64) != 0 ? vless.httpupgrade : httpUpgradeTransport, (i & 128) != 0 ? vless.xhttp : xhttpTransport, (i & 256) != 0 ? vless.grpc : grpcTransport, (i & 512) != 0 ? vless.reality : realityBlock, (i & 1024) != 0 ? vless.tls : tlsBlock, (i & 2048) != 0 ? vless.mux : mux, (i & 4096) != 0 ? vless.sockopt : sockopt);
        }

        public final String component1() {
            return this.uuid;
        }

        public final RealityBlock component10() {
            return this.reality;
        }

        public final TlsBlock component11() {
            return this.tls;
        }

        public final Mux component12() {
            return this.mux;
        }

        public final Sockopt component13() {
            return this.sockopt;
        }

        public final String component2() {
            return this.encryption;
        }

        public final String component3() {
            return this.flow;
        }

        public final String component4() {
            return this.network;
        }

        public final String component5() {
            return this.security;
        }

        public final WsTransport component6() {
            return this.ws;
        }

        public final HttpUpgradeTransport component7() {
            return this.httpupgrade;
        }

        public final XhttpTransport component8() {
            return this.xhttp;
        }

        public final GrpcTransport component9() {
            return this.grpc;
        }

        public final Vless copy(String uuid, String encryption, String flow, String network, String security, WsTransport wsTransport, HttpUpgradeTransport httpUpgradeTransport, XhttpTransport xhttpTransport, GrpcTransport grpcTransport, RealityBlock realityBlock, TlsBlock tlsBlock, Mux mux, Sockopt sockopt) {
            j.e(uuid, "uuid");
            j.e(encryption, "encryption");
            j.e(flow, "flow");
            j.e(network, "network");
            j.e(security, "security");
            return new Vless(uuid, encryption, flow, network, security, wsTransport, httpUpgradeTransport, xhttpTransport, grpcTransport, realityBlock, tlsBlock, mux, sockopt);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Vless)) {
                return false;
            }
            Vless vless = (Vless) obj;
            return j.a(this.uuid, vless.uuid) && j.a(this.encryption, vless.encryption) && j.a(this.flow, vless.flow) && j.a(this.network, vless.network) && j.a(this.security, vless.security) && j.a(this.ws, vless.ws) && j.a(this.httpupgrade, vless.httpupgrade) && j.a(this.xhttp, vless.xhttp) && j.a(this.grpc, vless.grpc) && j.a(this.reality, vless.reality) && j.a(this.tls, vless.tls) && j.a(this.mux, vless.mux) && j.a(this.sockopt, vless.sockopt);
        }

        public final String getEncryption() {
            return this.encryption;
        }

        public final String getFlow() {
            return this.flow;
        }

        public final GrpcTransport getGrpc() {
            return this.grpc;
        }

        public final HttpUpgradeTransport getHttpupgrade() {
            return this.httpupgrade;
        }

        public final Mux getMux() {
            return this.mux;
        }

        public final String getNetwork() {
            return this.network;
        }

        public final RealityBlock getReality() {
            return this.reality;
        }

        public final String getSecurity() {
            return this.security;
        }

        public final Sockopt getSockopt() {
            return this.sockopt;
        }

        public final TlsBlock getTls() {
            return this.tls;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final WsTransport getWs() {
            return this.ws;
        }

        public final XhttpTransport getXhttp() {
            return this.xhttp;
        }

        public int hashCode() {
            int iD = s.d(s.d(s.d(s.d(this.uuid.hashCode() * 31, 31, this.encryption), 31, this.flow), 31, this.network), 31, this.security);
            WsTransport wsTransport = this.ws;
            int iHashCode = (iD + (wsTransport == null ? 0 : wsTransport.hashCode())) * 31;
            HttpUpgradeTransport httpUpgradeTransport = this.httpupgrade;
            int iHashCode2 = (iHashCode + (httpUpgradeTransport == null ? 0 : httpUpgradeTransport.hashCode())) * 31;
            XhttpTransport xhttpTransport = this.xhttp;
            int iHashCode3 = (iHashCode2 + (xhttpTransport == null ? 0 : xhttpTransport.hashCode())) * 31;
            GrpcTransport grpcTransport = this.grpc;
            int iHashCode4 = (iHashCode3 + (grpcTransport == null ? 0 : grpcTransport.hashCode())) * 31;
            RealityBlock realityBlock = this.reality;
            int iHashCode5 = (iHashCode4 + (realityBlock == null ? 0 : realityBlock.hashCode())) * 31;
            TlsBlock tlsBlock = this.tls;
            int iHashCode6 = (iHashCode5 + (tlsBlock == null ? 0 : tlsBlock.hashCode())) * 31;
            Mux mux = this.mux;
            int iHashCode7 = (iHashCode6 + (mux == null ? 0 : mux.hashCode())) * 31;
            Sockopt sockopt = this.sockopt;
            return iHashCode7 + (sockopt != null ? sockopt.hashCode() : 0);
        }

        public String toString() {
            String str = this.uuid;
            String str2 = this.encryption;
            String str3 = this.flow;
            String str4 = this.network;
            String str5 = this.security;
            WsTransport wsTransport = this.ws;
            HttpUpgradeTransport httpUpgradeTransport = this.httpupgrade;
            XhttpTransport xhttpTransport = this.xhttp;
            GrpcTransport grpcTransport = this.grpc;
            RealityBlock realityBlock = this.reality;
            TlsBlock tlsBlock = this.tls;
            Mux mux = this.mux;
            Sockopt sockopt = this.sockopt;
            StringBuilder sbN = s.n("Vless(uuid=", str, ", encryption=", str2, ", flow=");
            d1.x(sbN, str3, ", network=", str4, ", security=");
            sbN.append(str5);
            sbN.append(", ws=");
            sbN.append(wsTransport);
            sbN.append(", httpupgrade=");
            sbN.append(httpUpgradeTransport);
            sbN.append(", xhttp=");
            sbN.append(xhttpTransport);
            sbN.append(", grpc=");
            sbN.append(grpcTransport);
            sbN.append(", reality=");
            sbN.append(realityBlock);
            sbN.append(", tls=");
            sbN.append(tlsBlock);
            sbN.append(", mux=");
            sbN.append(mux);
            sbN.append(", sockopt=");
            sbN.append(sockopt);
            sbN.append(")");
            return sbN.toString();
        }

        public /* synthetic */ Vless(String str, String str2, String str3, String str4, String str5, WsTransport wsTransport, HttpUpgradeTransport httpUpgradeTransport, XhttpTransport xhttpTransport, GrpcTransport grpcTransport, RealityBlock realityBlock, TlsBlock tlsBlock, Mux mux, Sockopt sockopt, int i, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : wsTransport, (i & 64) != 0 ? null : httpUpgradeTransport, (i & 128) != 0 ? null : xhttpTransport, (i & 256) != 0 ? null : grpcTransport, (i & 512) != 0 ? null : realityBlock, (i & 1024) != 0 ? null : tlsBlock, (i & 2048) != 0 ? null : mux, (i & 4096) != 0 ? null : sockopt);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Server {
        public static final int $stable = 8;
        private final String city;
        private final String country;
        private final String countryCode;
        private final Grpc grpc;
        private final String host;
        private final Hysteria2 hysteria2;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f11581id;
        private final String json;
        private final String locationId;
        private final Names names;
        private final String password;
        private final int port;
        private final String profile;
        private final String protocol;
        private final Raw raw;
        private final Score score;
        private final String sni;
        private final int sort;
        private final Vless vless;
        private final Xhttp xhttp;

        public Server(String id2, String countryCode, String country, String city, String locationId, String protocol, String profile, String host, int i, String sni, int i10, Names names, String str, Xhttp xhttp, Raw raw, Hysteria2 hysteria2, Grpc grpc, Vless vless, Score score, String str2) {
            j.e(id2, "id");
            j.e(countryCode, "countryCode");
            j.e(country, "country");
            j.e(city, "city");
            j.e(locationId, "locationId");
            j.e(protocol, "protocol");
            j.e(profile, "profile");
            j.e(host, "host");
            j.e(sni, "sni");
            this.f11581id = id2;
            this.countryCode = countryCode;
            this.country = country;
            this.city = city;
            this.locationId = locationId;
            this.protocol = protocol;
            this.profile = profile;
            this.host = host;
            this.port = i;
            this.sni = sni;
            this.sort = i10;
            this.names = names;
            this.password = str;
            this.xhttp = xhttp;
            this.raw = raw;
            this.hysteria2 = hysteria2;
            this.grpc = grpc;
            this.vless = vless;
            this.score = score;
            this.json = str2;
        }

        public static /* synthetic */ Server copy$default(Server server, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, int i10, Names names, String str10, Xhttp xhttp, Raw raw, Hysteria2 hysteria2, Grpc grpc, Vless vless, Score score, String str11, int i11, Object obj) {
            String str12;
            Score score2;
            String str13 = (i11 & 1) != 0 ? server.f11581id : str;
            String str14 = (i11 & 2) != 0 ? server.countryCode : str2;
            String str15 = (i11 & 4) != 0 ? server.country : str3;
            String str16 = (i11 & 8) != 0 ? server.city : str4;
            String str17 = (i11 & 16) != 0 ? server.locationId : str5;
            String str18 = (i11 & 32) != 0 ? server.protocol : str6;
            String str19 = (i11 & 64) != 0 ? server.profile : str7;
            String str20 = (i11 & 128) != 0 ? server.host : str8;
            int i12 = (i11 & 256) != 0 ? server.port : i;
            String str21 = (i11 & 512) != 0 ? server.sni : str9;
            int i13 = (i11 & 1024) != 0 ? server.sort : i10;
            Names names2 = (i11 & 2048) != 0 ? server.names : names;
            String str22 = (i11 & 4096) != 0 ? server.password : str10;
            Xhttp xhttp2 = (i11 & 8192) != 0 ? server.xhttp : xhttp;
            String str23 = str13;
            Raw raw2 = (i11 & 16384) != 0 ? server.raw : raw;
            Hysteria2 hysteria3 = (i11 & 32768) != 0 ? server.hysteria2 : hysteria2;
            Grpc grpc2 = (i11 & 65536) != 0 ? server.grpc : grpc;
            Vless vless2 = (i11 & 131072) != 0 ? server.vless : vless;
            Score score3 = (i11 & 262144) != 0 ? server.score : score;
            if ((i11 & 524288) != 0) {
                score2 = score3;
                str12 = server.json;
            } else {
                str12 = str11;
                score2 = score3;
            }
            return server.copy(str23, str14, str15, str16, str17, str18, str19, str20, i12, str21, i13, names2, str22, xhttp2, raw2, hysteria3, grpc2, vless2, score2, str12);
        }

        public final String component1() {
            return this.f11581id;
        }

        public final String component10() {
            return this.sni;
        }

        public final int component11() {
            return this.sort;
        }

        public final Names component12() {
            return this.names;
        }

        public final String component13() {
            return this.password;
        }

        public final Xhttp component14() {
            return this.xhttp;
        }

        public final Raw component15() {
            return this.raw;
        }

        public final Hysteria2 component16() {
            return this.hysteria2;
        }

        public final Grpc component17() {
            return this.grpc;
        }

        public final Vless component18() {
            return this.vless;
        }

        public final Score component19() {
            return this.score;
        }

        public final String component2() {
            return this.countryCode;
        }

        public final String component20() {
            return this.json;
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

        public final String component8() {
            return this.host;
        }

        public final int component9() {
            return this.port;
        }

        public final Server copy(String id2, String countryCode, String country, String city, String locationId, String protocol, String profile, String host, int i, String sni, int i10, Names names, String str, Xhttp xhttp, Raw raw, Hysteria2 hysteria2, Grpc grpc, Vless vless, Score score, String str2) {
            j.e(id2, "id");
            j.e(countryCode, "countryCode");
            j.e(country, "country");
            j.e(city, "city");
            j.e(locationId, "locationId");
            j.e(protocol, "protocol");
            j.e(profile, "profile");
            j.e(host, "host");
            j.e(sni, "sni");
            return new Server(id2, countryCode, country, city, locationId, protocol, profile, host, i, sni, i10, names, str, xhttp, raw, hysteria2, grpc, vless, score, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Server)) {
                return false;
            }
            Server server = (Server) obj;
            return j.a(this.f11581id, server.f11581id) && j.a(this.countryCode, server.countryCode) && j.a(this.country, server.country) && j.a(this.city, server.city) && j.a(this.locationId, server.locationId) && j.a(this.protocol, server.protocol) && j.a(this.profile, server.profile) && j.a(this.host, server.host) && this.port == server.port && j.a(this.sni, server.sni) && this.sort == server.sort && j.a(this.names, server.names) && j.a(this.password, server.password) && j.a(this.xhttp, server.xhttp) && j.a(this.raw, server.raw) && j.a(this.hysteria2, server.hysteria2) && j.a(this.grpc, server.grpc) && j.a(this.vless, server.vless) && j.a(this.score, server.score) && j.a(this.json, server.json);
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final Grpc getGrpc() {
            return this.grpc;
        }

        public final String getHost() {
            return this.host;
        }

        public final Hysteria2 getHysteria2() {
            return this.hysteria2;
        }

        public final String getId() {
            return this.f11581id;
        }

        public final String getJson() {
            return this.json;
        }

        public final String getLocationId() {
            return this.locationId;
        }

        public final Names getNames() {
            return this.names;
        }

        public final String getPassword() {
            return this.password;
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

        public final Raw getRaw() {
            return this.raw;
        }

        public final Score getScore() {
            return this.score;
        }

        public final String getSni() {
            return this.sni;
        }

        public final int getSort() {
            return this.sort;
        }

        public final Vless getVless() {
            return this.vless;
        }

        public final Xhttp getXhttp() {
            return this.xhttp;
        }

        public int hashCode() {
            int iC = androidx.compose.foundation.interaction.f.c(this.sort, s.d(androidx.compose.foundation.interaction.f.c(this.port, s.d(s.d(s.d(s.d(s.d(s.d(s.d(this.f11581id.hashCode() * 31, 31, this.countryCode), 31, this.country), 31, this.city), 31, this.locationId), 31, this.protocol), 31, this.profile), 31, this.host), 31), 31, this.sni), 31);
            Names names = this.names;
            int iHashCode = (iC + (names == null ? 0 : names.hashCode())) * 31;
            String str = this.password;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Xhttp xhttp = this.xhttp;
            int iHashCode3 = (iHashCode2 + (xhttp == null ? 0 : xhttp.hashCode())) * 31;
            Raw raw = this.raw;
            int iHashCode4 = (iHashCode3 + (raw == null ? 0 : raw.hashCode())) * 31;
            Hysteria2 hysteria2 = this.hysteria2;
            int iHashCode5 = (iHashCode4 + (hysteria2 == null ? 0 : hysteria2.hashCode())) * 31;
            Grpc grpc = this.grpc;
            int iHashCode6 = (iHashCode5 + (grpc == null ? 0 : grpc.hashCode())) * 31;
            Vless vless = this.vless;
            int iHashCode7 = (iHashCode6 + (vless == null ? 0 : vless.hashCode())) * 31;
            Score score = this.score;
            int iHashCode8 = (iHashCode7 + (score == null ? 0 : score.hashCode())) * 31;
            String str2 = this.json;
            return iHashCode8 + (str2 != null ? str2.hashCode() : 0);
        }

        public final sf.c toJson() {
            Object objNamesJson;
            Object obj;
            sf.c cVar = new sf.c();
            cVar.D(XrayCoreHostService.KEY_ID, this.f11581id);
            cVar.D("countryCode", this.countryCode);
            cVar.D(TunnelVpnService.EXTRA_COUNTRY, this.country);
            cVar.D("city", this.city);
            cVar.D("locationId", this.locationId);
            cVar.D("protocol", this.protocol);
            cVar.D("profile", this.profile);
            cVar.D("host", this.host);
            cVar.D(PsiphonProbeService.PORT, Integer.valueOf(this.port));
            cVar.D("sni", this.sni);
            String str = this.password;
            if (str != null) {
                cVar.D("password", str);
            }
            Xhttp xhttp = this.xhttp;
            if (xhttp != null) {
                cVar.D("xhttp", MamiCatalog.INSTANCE.xhttpJson(xhttp));
            }
            Raw raw = this.raw;
            if (raw != null) {
                sf.c cVar2 = new sf.c();
                cVar2.D("uuid", raw.getUuid());
                cVar2.D("encryption", raw.getEncryption());
                cVar2.D("flow", raw.getFlow());
                cVar2.D("security", raw.getSecurity());
                cVar2.D("publicKey", raw.getPublicKey());
                cVar2.D("shortId", raw.getShortId());
                cVar2.D("fingerprint", raw.getFingerprint());
                cVar.D("raw", cVar2);
            }
            Hysteria2 hysteria2 = this.hysteria2;
            if (hysteria2 != null) {
                sf.c cVar3 = new sf.c();
                cVar3.D("auth", hysteria2.getAuth());
                cVar3.D("pinSHA256", hysteria2.getPinSHA256());
                cVar3.D("obfs", hysteria2.getObfs());
                cVar3.D("obfsPassword", hysteria2.getObfsPassword());
                cVar3.D("hopPorts", hysteria2.getHopPorts());
                cVar3.D("hopInterval", Integer.valueOf(hysteria2.getHopInterval()));
                cVar.D("hysteria2", cVar3);
            }
            Grpc grpc = this.grpc;
            if (grpc != null) {
                sf.c cVar4 = new sf.c();
                cVar4.D("uuid", grpc.getUuid());
                cVar4.D("encryption", grpc.getEncryption());
                cVar4.D("security", grpc.getSecurity());
                cVar4.D("publicKey", grpc.getPublicKey());
                cVar4.D("shortId", grpc.getShortId());
                cVar4.D("fingerprint", grpc.getFingerprint());
                cVar4.D("serviceName", grpc.getServiceName());
                cVar4.D("multiConnections", Integer.valueOf(grpc.getMultiConnections()));
                cVar.D("grpc", cVar4);
            }
            Vless vless = this.vless;
            if (vless != null) {
                cVar.D("vless", MamiCatalog.INSTANCE.vlessJson(vless));
            }
            cVar.D("sort", Integer.valueOf(this.sort));
            Names names = this.names;
            if (names == null || (objNamesJson = MamiCatalog.INSTANCE.namesJson(names)) == null) {
                objNamesJson = sf.c.f67157c;
            }
            cVar.D("names", objNamesJson);
            if (j.a(this.profile, "HIVE")) {
                Score score = this.score;
                if (score != null) {
                    sf.c cVar5 = new sf.c();
                    cVar5.D("p", Double.valueOf(score.getP()));
                    cVar5.D("n", Double.valueOf(score.getN()));
                    cVar5.D(AwgProbeService.KEY_MS, Double.valueOf(score.getMs()));
                    obj = cVar5;
                } else {
                    obj = sf.c.f67157c;
                }
                cVar.D("score", obj);
            }
            return cVar;
        }

        public String toString() {
            String str = this.f11581id;
            String str2 = this.countryCode;
            String str3 = this.country;
            String str4 = this.city;
            String str5 = this.locationId;
            String str6 = this.protocol;
            String str7 = this.profile;
            String str8 = this.host;
            int i = this.port;
            String str9 = this.sni;
            int i10 = this.sort;
            Names names = this.names;
            String str10 = this.password;
            Xhttp xhttp = this.xhttp;
            Raw raw = this.raw;
            Hysteria2 hysteria2 = this.hysteria2;
            Grpc grpc = this.grpc;
            Vless vless = this.vless;
            Score score = this.score;
            String str11 = this.json;
            StringBuilder sbN = s.n("Server(id=", str, ", countryCode=", str2, ", country=");
            d1.x(sbN, str3, ", city=", str4, ", locationId=");
            d1.x(sbN, str5, ", protocol=", str6, ", profile=");
            d1.x(sbN, str7, ", host=", str8, ", port=");
            d1.n(i, ", sni=", str9, ", sort=", sbN);
            sbN.append(i10);
            sbN.append(", names=");
            sbN.append(names);
            sbN.append(", password=");
            sbN.append(str10);
            sbN.append(", xhttp=");
            sbN.append(xhttp);
            sbN.append(", raw=");
            sbN.append(raw);
            sbN.append(", hysteria2=");
            sbN.append(hysteria2);
            sbN.append(", grpc=");
            sbN.append(grpc);
            sbN.append(", vless=");
            sbN.append(vless);
            sbN.append(", score=");
            sbN.append(score);
            sbN.append(", json=");
            sbN.append(str11);
            sbN.append(")");
            return sbN.toString();
        }

        public /* synthetic */ Server(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, int i10, Names names, String str10, Xhttp xhttp, Raw raw, Hysteria2 hysteria2, Grpc grpc, Vless vless, Score score, String str11, int i11, kotlin.jvm.internal.e eVar) {
            this(str, str2, str3, str4, str5, str6, str7, (i11 & 128) != 0 ? "" : str8, (i11 & 256) != 0 ? 0 : i, (i11 & 512) != 0 ? "" : str9, (i11 & 1024) != 0 ? 1000 : i10, (i11 & 2048) != 0 ? null : names, (i11 & 4096) != 0 ? null : str10, (i11 & 8192) != 0 ? null : xhttp, (i11 & 16384) != 0 ? null : raw, (32768 & i11) != 0 ? null : hysteria2, (65536 & i11) != 0 ? null : grpc, (131072 & i11) != 0 ? null : vless, (262144 & i11) != 0 ? null : score, (i11 & 524288) != 0 ? null : str11);
        }
    }
}
