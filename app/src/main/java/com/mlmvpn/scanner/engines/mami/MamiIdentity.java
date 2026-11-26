package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import com.mlmvpn.core.aether.i;
import j$.util.Base64;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import kittoku.mvc.unit.IPv4PacketKt;
import kittoku.mvc.unit.dhcp.ConstKt;
import kotlin.collections.o;
import kotlin.collections.q;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiIdentity {
    public static final String BAD_ANDROID_ID = "9774d56d682e549c";
    public static final String FILE = "identity.json";
    public static final String PACKAGE = "com.yamyam.vpn";
    public static final int RSA_BITS = 3072;
    private static Identity cache;
    private static MamiStore cacheStore;
    public static final MamiIdentity INSTANCE = new MamiIdentity();
    private static final SecureRandom random = new SecureRandom();
    private static final Object cacheLock = new Object();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Der {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f11593b;
        private final int end;
        private int i;

        public Der(byte[] b10, int i, int i10) {
            j.e(b10, "b");
            this.f11593b = b10;
            this.i = i;
            this.end = i10;
        }

        private final sd.j take(int i) {
            int i10 = this.i;
            int i11 = this.end;
            if (i10 < i11) {
                byte[] bArr = this.f11593b;
                if ((bArr[i10] & ConstKt.DHCP_OPTION_END) == i) {
                    int i12 = i10 + 1;
                    this.i = i12;
                    if (i12 >= i11) {
                        throw new IllegalArgumentException("DER length");
                    }
                    int i13 = i10 + 2;
                    this.i = i13;
                    byte b10 = bArr[i12];
                    int i14 = b10 & ConstKt.DHCP_OPTION_END;
                    if ((b10 & 128) != 0) {
                        int i15 = b10 & IPv4PacketKt.IPv4_DEFAULT_TTL;
                        if (1 > i15 || i15 >= 5 || i13 + i15 > i11) {
                            throw new IllegalArgumentException("DER length");
                        }
                        i14 = 0;
                        for (int i16 = 0; i16 < i15; i16++) {
                            int i17 = i14 << 8;
                            byte[] bArr2 = this.f11593b;
                            int i18 = this.i;
                            this.i = i18 + 1;
                            i14 = (bArr2[i18] & ConstKt.DHCP_OPTION_END) | i17;
                        }
                    }
                    if (i14 >= 0) {
                        int i19 = this.i;
                        if (i19 + i14 <= this.end) {
                            this.i = i19 + i14;
                            return new sd.j(Integer.valueOf(i19), Integer.valueOf(i14));
                        }
                    }
                    throw new IllegalArgumentException("DER length");
                }
            }
            throw new IllegalArgumentException("DER tag");
        }

        /* JADX INFO: renamed from: int, reason: not valid java name */
        public final BigInteger m301int() {
            sd.j jVarTake = take(2);
            int iIntValue = ((Number) jVarTake.component1()).intValue();
            return new BigInteger(o.X(iIntValue, ((Number) jVarTake.component2()).intValue() + iIntValue, this.f11593b));
        }

        public final byte[] octets() {
            sd.j jVarTake = take(4);
            int iIntValue = ((Number) jVarTake.component1()).intValue();
            return o.X(iIntValue, ((Number) jVarTake.component2()).intValue() + iIntValue, this.f11593b);
        }

        public final Der seq() {
            sd.j jVarTake = take(48);
            int iIntValue = ((Number) jVarTake.component1()).intValue();
            return new Der(this.f11593b, iIntValue, ((Number) jVarTake.component2()).intValue() + iIntValue);
        }

        public /* synthetic */ Der(byte[] bArr, int i, int i10, int i11, kotlin.jvm.internal.e eVar) {
            this(bArr, (i11 & 2) != 0 ? 0 : i, (i11 & 4) != 0 ? bArr.length : i10);
        }
    }

    private MamiIdentity() {
    }

    private final byte[] derOfPem(String str) {
        String strQ0 = v.q0(v.q0(str, "-----BEGIN PRIVATE KEY-----", ""), "-----END PRIVATE KEY-----", "");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < strQ0.length(); i++) {
            char cCharAt = strQ0.charAt(i);
            if (!MamiJs.INSTANCE.isSpace(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        byte[] bArrDecode = Base64.getDecoder().decode(sb2.toString());
        j.d(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    public static /* synthetic */ String deviceIdFor$default(MamiIdentity mamiIdentity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = PACKAGE;
        }
        return mamiIdentity.deviceIdFor(str, str2);
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

    private final boolean isPackage(String str) {
        int length = str.length();
        if (3 <= length && length < 201) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (('A' <= cCharAt && cCharAt < '[') || (('a' <= cCharAt && cCharAt < '{') || (('0' <= cCharAt && cCharAt < ':') || cCharAt == '_' || cCharAt == '.'))) {
                }
            }
            return true;
        }
        return false;
    }

    private final long jsLong(Object obj) {
        Double dNum = MamiJs.INSTANCE.num(obj);
        if (dNum == null) {
            return 0L;
        }
        double dDoubleValue = dNum.doubleValue();
        if (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) {
            dNum = null;
        }
        if (dNum != null) {
            return (long) dNum.doubleValue();
        }
        return 0L;
    }

    private final sf.c record(String str, String str2, long j, long j10, PrivateKey privateKey) {
        sf.c cVar = new sf.c();
        com.mlmvpn.scanner.e.q(1, "v", "androidId", str, cVar);
        cVar.D("deviceId", str2);
        cVar.D("createdAt", Long.valueOf(j));
        cVar.D("keyCreatedAt", Long.valueOf(j10));
        cVar.D("privateKey", pemOf(privateKey));
        return cVar;
    }

    public final sd.j describePublicKey(PublicKey publicKey) {
        j.e(publicKey, "publicKey");
        byte[] encoded = publicKey.getEncoded();
        MamiJs mamiJs = MamiJs.INSTANCE;
        j.b(encoded);
        String strB64u = mamiJs.b64u(encoded);
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(encoded);
        j.d(bArrDigest, "digest(...)");
        return new sd.j(strB64u, mamiJs.b64u(bArrDigest));
    }

    public final String deviceIdFor(String str, String pkg) throws NoSuchAlgorithmException {
        j.e(pkg, "pkg");
        if (!isAndroidId(str)) {
            throw new IllegalArgumentException("android id has the wrong shape");
        }
        if (!isPackage(pkg)) {
            throw new IllegalArgumentException("package name has the wrong shape");
        }
        j.b(str);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        j.d(lowerCase, "toLowerCase(...)");
        return v0.a.h("dv1_", MamiJs.INSTANCE.b64u(i.D("YAMYAM-DEVICE-ID-V1\u0000" + pkg + WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR + lowerCase, kotlin.text.a.f23859a, "getBytes(...)", MessageDigest.getInstance("SHA-256"), "digest(...)")));
    }

    public final void forget(MamiStore store) {
        j.e(store, "store");
        synchronized (cacheLock) {
            cache = null;
            store.delete(FILE);
        }
    }

    public final Recipient freshRecipient() {
        return recipientOf(generateRsa());
    }

    public final KeyPair generateRsa() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(RSA_BITS, RSAKeyGenParameterSpec.F4));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        j.d(keyPairGenerateKeyPair, "run(...)");
        return keyPairGenerateKeyPair;
    }

    public final boolean isAndroidId(String str) {
        int length;
        if (str != null && 16 <= (length = str.length()) && length < 65) {
            for (int i = 0; i < str.length(); i++) {
                if (INSTANCE.isHex(str.charAt(i))) {
                }
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            j.d(lowerCase, "toLowerCase(...)");
            if (!lowerCase.equals(BAD_ANDROID_ID)) {
                return true;
            }
        }
        return false;
    }

    public final Identity load(MamiStore store) {
        Identity identityLoadOrNull;
        j.e(store, "store");
        synchronized (cacheLock) {
            identityLoadOrNull = INSTANCE.loadOrNull(store, true);
            j.b(identityLoadOrNull);
        }
        return identityLoadOrNull;
    }

    public final Identity loadOrNull(MamiStore store, boolean z10) {
        j.e(store, "store");
        synchronized (cacheLock) {
            try {
                if (cacheStore != store) {
                    cache = null;
                    cacheStore = store;
                }
                Identity identity = cache;
                if (identity != null) {
                    return identity;
                }
                MamiIdentity mamiIdentity = INSTANCE;
                Identity identityMaterialize = mamiIdentity.materialize(store.readJson(FILE));
                if (identityMaterialize != null) {
                    cache = identityMaterialize;
                    return identityMaterialize;
                }
                if (!z10) {
                    return null;
                }
                String strNewAndroidId = mamiIdentity.newAndroidId();
                KeyPair keyPairGenerateRsa = mamiIdentity.generateRsa();
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strDeviceIdFor$default = deviceIdFor$default(mamiIdentity, strNewAndroidId, null, 2, null);
                PrivateKey privateKey = keyPairGenerateRsa.getPrivate();
                j.d(privateKey, "getPrivate(...)");
                sf.c cVarRecord = mamiIdentity.record(strNewAndroidId, strDeviceIdFor$default, jCurrentTimeMillis, jCurrentTimeMillis, privateKey);
                store.writeJson(FILE, cVarRecord);
                Identity identityMaterialize2 = mamiIdentity.materialize(cVarRecord);
                if (identityMaterialize2 == null) {
                    throw new IllegalStateException("the new identity did not load");
                }
                cache = identityMaterialize2;
                return identityMaterialize2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Identity materialize(sf.c cVar) {
        byte[] bArrDerOfPem;
        sd.j jVarRsaPublicOfPkcs8$app_release;
        if (cVar != null) {
            try {
                MamiJs mamiJs = MamiJs.INSTANCE;
                Double dNum = mamiJs.num(mamiJs.get(cVar, "v"));
                if (dNum != null && dNum.doubleValue() == 1.0d) {
                    Object obj = mamiJs.get(cVar, "privateKey");
                    String str = obj instanceof String ? (String) obj : null;
                    if (str != null) {
                        Object obj2 = mamiJs.get(cVar, "androidId");
                        String str2 = obj2 instanceof String ? (String) obj2 : null;
                        if (str2 != null) {
                            Object obj3 = mamiJs.get(cVar, "deviceId");
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (str3 != null && j.a(deviceIdFor$default(this, str2, null, 2, null), str3) && (jVarRsaPublicOfPkcs8$app_release = rsaPublicOfPkcs8$app_release((bArrDerOfPem = derOfPem(str)))) != null) {
                                BigInteger bigInteger = (BigInteger) jVarRsaPublicOfPkcs8$app_release.component1();
                                BigInteger bigInteger2 = (BigInteger) jVarRsaPublicOfPkcs8$app_release.component2();
                                if (bigInteger.bitLength() == 3072) {
                                    PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArrDerOfPem));
                                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
                                    j.b(publicKeyGeneratePublic);
                                    sd.j jVarDescribePublicKey = describePublicKey(publicKeyGeneratePublic);
                                    long jJsLong = jsLong(mamiJs.get(cVar, "createdAt"));
                                    long jJsLong2 = jsLong(mamiJs.get(cVar, "keyCreatedAt"));
                                    Long lValueOf = Long.valueOf(jJsLong2);
                                    if (jJsLong2 == 0) {
                                        lValueOf = null;
                                    }
                                    long jLongValue = lValueOf != null ? lValueOf.longValue() : jJsLong;
                                    j.b(privateKeyGeneratePrivate);
                                    return new Identity(str3, str2, jJsLong, jLongValue, privateKeyGeneratePrivate, publicKeyGeneratePublic, (String) jVarDescribePublicKey.getFirst(), (String) jVarDescribePublicKey.getSecond());
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String newAndroidId() {
        String strHex;
        do {
            MamiJs mamiJs = MamiJs.INSTANCE;
            byte[] bArr = new byte[8];
            random.nextBytes(bArr);
            strHex = mamiJs.hex(bArr);
        } while (j.a(strHex, BAD_ANDROID_ID));
        return strHex;
    }

    public final String pemOf(PrivateKey key) {
        j.e(key, "key");
        String strEncodeToString = Base64.getEncoder().encodeToString(key.getEncoded());
        j.d(strEncodeToString, "encodeToString(...)");
        return w0.n("-----BEGIN PRIVATE KEY-----\n", q.F0(kotlin.text.o.x0(64, strEncodeToString), "\n", null, null, null, 62), "\n-----END PRIVATE KEY-----\n");
    }

    public final PrivateKey privateKeyOfPem(String pem) throws InvalidKeySpecException {
        j.e(pem, "pem");
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(derOfPem(pem)));
        j.d(privateKeyGeneratePrivate, "generatePrivate(...)");
        return privateKeyGeneratePrivate;
    }

    public final Recipient recipientOf(KeyPair pair) {
        j.e(pair, "pair");
        PublicKey publicKey = pair.getPublic();
        j.d(publicKey, "getPublic(...)");
        sd.j jVarDescribePublicKey = describePublicKey(publicKey);
        PrivateKey privateKey = pair.getPrivate();
        j.d(privateKey, "getPrivate(...)");
        PublicKey publicKey2 = pair.getPublic();
        j.d(publicKey2, "getPublic(...)");
        return new Recipient(privateKey, publicKey2, (String) jVarDescribePublicKey.getFirst(), (String) jVarDescribePublicKey.getSecond());
    }

    public final void reset() {
        synchronized (cacheLock) {
            cache = null;
        }
    }

    public final Identity rotateKey(MamiStore store) {
        Identity identityMaterialize;
        j.e(store, "store");
        synchronized (cacheLock) {
            MamiIdentity mamiIdentity = INSTANCE;
            Identity identityLoadOrNull = mamiIdentity.loadOrNull(store, true);
            j.b(identityLoadOrNull);
            KeyPair keyPairGenerateRsa = mamiIdentity.generateRsa();
            String androidId = identityLoadOrNull.getAndroidId();
            String deviceId = identityLoadOrNull.getDeviceId();
            long createdAt = identityLoadOrNull.getCreatedAt();
            long jCurrentTimeMillis = System.currentTimeMillis();
            PrivateKey privateKey = keyPairGenerateRsa.getPrivate();
            j.d(privateKey, "getPrivate(...)");
            sf.c cVarRecord = mamiIdentity.record(androidId, deviceId, createdAt, jCurrentTimeMillis, privateKey);
            store.writeJson(FILE, cVarRecord);
            identityMaterialize = mamiIdentity.materialize(cVarRecord);
            if (identityMaterialize == null) {
                throw new IllegalStateException("the new key did not load");
            }
            cache = identityMaterialize;
        }
        return identityMaterialize;
    }

    public final sd.j rsaPublicOfPkcs8$app_release(byte[] der) {
        j.e(der, "der");
        try {
            Der derSeq = new Der(der, 0, 0, 6, null).seq();
            derSeq.m301int();
            derSeq.seq();
            Der derSeq2 = new Der(derSeq.octets(), 0, 0, 6, null).seq();
            derSeq2.m301int();
            return new sd.j(derSeq2.m301int(), derSeq2.m301int());
        } catch (Exception unused) {
            return null;
        }
    }
}
