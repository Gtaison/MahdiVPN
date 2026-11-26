package com.mlmvpn.scanner.engines.mami;

import androidx.media3.common.s;
import com.mlmvpn.core.warp.XrayCoreHostService;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import kittoku.mvc.unit.property.ConstKt;
import kotlin.collections.o;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import org.telegram.ui.Cells.d1;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiEnvelope {
    public static final int $stable;
    private static final List<String> ALL_KEYS;
    public static final long ANSWER_WITHIN_NS = 120000000000L;
    public static final String HEADER_TAG = "YAMYAM-CATALOG-V1";
    public static final MamiEnvelope INSTANCE = new MamiEnvelope();
    public static final int MAX_ENVELOPE = 524288;
    public static final int MAX_PLAINTEXT = 262144;
    private static final List<String> NUMBER_KEYS;
    public static final long SKEW_SEC = 60;
    private static final List<String> STRING_KEYS;
    public static final String SUITE = "P256-SHA256+RSA3072-OAEP256+A256GCM";
    public static final long WINDOW_SEC = 21600;
    private static final sd.e p256$delegate;
    private static final SecureRandom random;

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static abstract class FlatValue {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Num extends FlatValue {
            public static final int $stable = 0;
            private final String raw;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Num(String raw) {
                super(null);
                j.e(raw, "raw");
                this.raw = raw;
            }

            public final String getRaw() {
                return this.raw;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Other extends FlatValue {
            public static final int $stable = 0;
            public static final Other INSTANCE = new Other();

            private Other() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class Str extends FlatValue {
            public static final int $stable = 0;
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Str(String value) {
                super(null);
                j.e(value, "value");
                this.value = value;
            }

            public final String getValue() {
                return this.value;
            }
        }

        public /* synthetic */ FlatValue(kotlin.jvm.internal.e eVar) {
            this();
        }

        private FlatValue() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class Scanner {
        private int i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f11592n;
        private final String text;

        public Scanner(String text) {
            j.e(text, "text");
            this.text = text;
            this.f11592n = text.length();
        }

        public final int getI() {
            return this.i;
        }

        public final int getN() {
            return this.f11592n;
        }

        public final String getText() {
            return this.text;
        }

        public final String number() {
            char cCharAt;
            char cCharAt2;
            char cCharAt3;
            char cCharAt4;
            char cCharAt5;
            char cCharAt6;
            int i = this.i;
            if (i < this.f11592n && this.text.charAt(i) == '-') {
                i++;
            }
            if (i >= this.f11592n || '0' > (cCharAt = this.text.charAt(i)) || cCharAt >= ':') {
                return null;
            }
            if (this.text.charAt(i) == '0') {
                i++;
            } else {
                while (i < this.f11592n && '0' <= (cCharAt2 = this.text.charAt(i)) && cCharAt2 < ':') {
                    i++;
                }
            }
            int i10 = i + 1;
            if (i10 < this.f11592n && this.text.charAt(i) == '.' && '0' <= (cCharAt5 = this.text.charAt(i10)) && cCharAt5 < ':') {
                i = i10;
                while (i < this.f11592n && '0' <= (cCharAt6 = this.text.charAt(i)) && cCharAt6 < ':') {
                    i++;
                }
            }
            if (i < this.f11592n && (this.text.charAt(i) == 'e' || this.text.charAt(i) == 'E')) {
                int i11 = i + 1;
                if (i11 < this.f11592n && (this.text.charAt(i11) == '+' || this.text.charAt(i11) == '-')) {
                    i11 = i + 2;
                }
                if (i11 < this.f11592n && '0' <= (cCharAt3 = this.text.charAt(i11)) && cCharAt3 < ':') {
                    i = i11;
                    while (i < this.f11592n && '0' <= (cCharAt4 = this.text.charAt(i)) && cCharAt4 < ':') {
                        i++;
                    }
                }
            }
            String strSubstring = this.text.substring(this.i, i);
            j.d(strSubstring, "substring(...)");
            this.i = i;
            return strSubstring;
        }

        public final void setI(int i) {
            this.i = i;
        }

        public final String string() throws EnvelopeException {
            char c2;
            char c7;
            int i = this.i;
            if (i >= this.f11592n || this.text.charAt(i) != '\"') {
                return null;
            }
            int i10 = this.i + 1;
            StringBuilder sb2 = new StringBuilder();
            while (i10 < this.f11592n) {
                char cCharAt = this.text.charAt(i10);
                if (cCharAt == '\"') {
                    this.i = i10 + 1;
                    return sb2.toString();
                }
                if (cCharAt < ' ') {
                    return null;
                }
                if (cCharAt == '\\') {
                    int i11 = i10 + 1;
                    if (i11 >= this.f11592n) {
                        return null;
                    }
                    char cCharAt2 = this.text.charAt(i11);
                    if (cCharAt2 == '\"') {
                        sb2.append('\"');
                    } else if (cCharAt2 == '/') {
                        sb2.append('/');
                    } else if (cCharAt2 != '\\') {
                        if (cCharAt2 == 'b') {
                            c2 = '\b';
                        } else if (cCharAt2 == 'f') {
                            c2 = '\f';
                        } else if (cCharAt2 != 'n') {
                            if (cCharAt2 == 'r') {
                                c7 = '\r';
                            } else if (cCharAt2 != 't') {
                                int i12 = 0;
                                if (cCharAt2 != 'u') {
                                    MamiEnvelope.INSTANCE.check(false, "json", "bad escape " + cCharAt2);
                                } else {
                                    int i13 = i10 + 6;
                                    if (i13 > this.f11592n) {
                                        return null;
                                    }
                                    for (int i14 = i10 + 2; i14 < i13; i14++) {
                                        int iDigit = Character.digit(this.text.charAt(i14), 16);
                                        if (iDigit < 0 || this.text.charAt(i14) > 127) {
                                            return null;
                                        }
                                        i12 = (i12 * 16) + iDigit;
                                    }
                                    sb2.append((char) i12);
                                    i10 += 4;
                                }
                            } else {
                                c7 = '\t';
                            }
                            sb2.append(c7);
                        } else {
                            c2 = '\n';
                        }
                        sb2.append(c2);
                    } else {
                        sb2.append('\\');
                    }
                    i10 += 2;
                } else {
                    sb2.append(cCharAt);
                    i10++;
                }
            }
            return null;
        }

        public final void ws() {
            while (true) {
                int i = this.i;
                if (i >= this.f11592n) {
                    return;
                }
                if (this.text.charAt(i) != ' ' && this.text.charAt(this.i) != '\t' && this.text.charAt(this.i) != '\n' && this.text.charAt(this.i) != '\r') {
                    return;
                } else {
                    this.i++;
                }
            }
        }
    }

    static {
        List<String> listA0 = r.a0(ConstKt.SEP_VERSION, "issuedAt", "expiresAt", "revision");
        NUMBER_KEYS = listA0;
        List<String> listA1 = r.a0("suite", "keyId", "audience", "nonce", "recipientKeyHash", "wrappedKey", "iv", "ciphertext", "signature");
        STRING_KEYS = listA1;
        ALL_KEYS = q.S0(listA0, listA1);
        random = new SecureRandom();
        p256$delegate = m9.d.A(new a(3));
        $stable = 8;
    }

    private MamiEnvelope() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void check(boolean z10, String str, String str2) throws EnvelopeException {
        if (!z10) {
            throw new EnvelopeException(str, str2);
        }
    }

    public static /* synthetic */ void check$default(MamiEnvelope mamiEnvelope, boolean z10, String str, String str2, int i, Object obj) throws EnvelopeException {
        if ((i & 4) != 0) {
            str2 = null;
        }
        mamiEnvelope.check(z10, str, str2);
    }

    private final OAEPParameterSpec getOaep() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
    }

    private final ECParameterSpec getP256() {
        Object value = p256$delegate.getValue();
        j.d(value, "getValue(...)");
        return (ECParameterSpec) value;
    }

    private final boolean isKeyId(String str) {
        int length = str.length();
        if (1 <= length && length < 65) {
            for (int i = 0; i < str.length(); i++) {
                if (MamiJs.INSTANCE.isB64uChar(str.charAt(i))) {
                }
            }
            return true;
        }
        return false;
    }

    private final boolean isWholeNumber(String str) {
        char cCharAt;
        if (j.a(str, "0")) {
            return true;
        }
        if (str.length() == 0 || str.length() > 19 || '1' > (cCharAt = str.charAt(0)) || cCharAt >= ':') {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt2 = str.charAt(i);
            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ long nowSec$default(MamiEnvelope mamiEnvelope, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return mamiEnvelope.nowSec(j);
    }

    public static /* synthetic */ Opened open$default(MamiEnvelope mamiEnvelope, byte[] bArr, RequestCtx requestCtx, Map map, long j, Long l6, Long l10, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        return mamiEnvelope.open(bArr, requestCtx, map, j, (i & 16) != 0 ? null : l6, (i & 32) != 0 ? null : l10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ECParameterSpec p256_delegate$lambda$4() throws NoSuchAlgorithmException, InvalidParameterSpecException {
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC");
        algorithmParameters.init(new ECGenParameterSpec("secp256r1"));
        return (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class);
    }

    public static /* synthetic */ byte[] strictB64u$default(MamiEnvelope mamiEnvelope, String str, int i, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "base64";
        }
        return mamiEnvelope.strictB64u(str, i, str2);
    }

    public final byte[] headerBytes(EnvelopeFields e10) {
        j.e(e10, "e");
        List listA0 = r.a0(HEADER_TAG, String.valueOf(e10.getVersion()), e10.getSuite(), e10.getKeyId(), e10.getAudience(), e10.getNonce(), e10.getRecipientKeyHash(), String.valueOf(e10.getIssuedAt()), String.valueOf(e10.getExpiresAt()), String.valueOf(e10.getRevision()));
        return MamiJs.INSTANCE.latin1(q.F0(listA0, "\n", null, null, null, 62) + "\n");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    public final Map<String, PublicKey> loadTrustedKeys(sf.a aVar) throws EnvelopeException {
        boolean z10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Object> listItems = MamiJs.INSTANCE.items(aVar);
        if (listItems != null) {
            for (Object obj : listItems) {
                if (obj instanceof sf.c) {
                    MamiJs mamiJs = MamiJs.INSTANCE;
                    Object obj2 = mamiJs.get(obj, XrayCoreHostService.KEY_ID);
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    if (str != null && isKeyId(str)) {
                        Object obj3 = mamiJs.get(obj, "spki");
                        try {
                            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(strictB64u(obj3 instanceof String ? (String) obj3 : null, 128, "trusted-key")));
                            if (publicKeyGeneratePublic instanceof ECPublicKey) {
                                ECPublicKey eCPublicKey = (ECPublicKey) publicKeyGeneratePublic;
                                if (j.a(eCPublicKey.getParams().getOrder(), getP256().getOrder()) && j.a(eCPublicKey.getParams().getCurve(), getP256().getCurve()) && j.a(eCPublicKey.getParams().getGenerator(), getP256().getGenerator())) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                            } else {
                                z10 = false;
                            }
                            check(z10, "trusted-key", str.concat(" is not P-256"));
                            linkedHashMap.put(str, publicKeyGeneratePublic);
                        } catch (Exception unused) {
                            throw new EnvelopeException("trusted-key", str.concat(" is not an EC key"));
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final Request newRequest(String audience, long j, int i, Recipient recipient, long j10, Long l6, Long l10) throws EnvelopeException {
        boolean z10;
        j.e(audience, "audience");
        j.e(recipient, "recipient");
        int length = audience.length();
        boolean z11 = false;
        if (1 <= length && length < 129) {
            int i10 = 0;
            while (true) {
                if (i10 >= audience.length()) {
                    if (j >= 0 && j <= MamiJs.MAX_SAFE_INTEGER) {
                        z10 = true;
                        break;
                    }
                    break;
                }
                char cCharAt = audience.charAt(i10);
                if (('A' <= cCharAt && cCharAt < '[') || (('a' <= cCharAt && cCharAt < '{') || (('0' <= cCharAt && cCharAt < ':') || cCharAt == '.' || cCharAt == '_' || cCharAt == '-'))) {
                    i10++;
                }
                z10 = false;
                break;
            }
        }
        z10 = false;
        break;
        check(z10, "request", "audience or minimumRevision");
        if (2 <= i && i < 9) {
            z11 = true;
        }
        check(z11, "request", "payloadVersion");
        MamiJs mamiJs = MamiJs.INSTANCE;
        byte[] bArr = new byte[32];
        random.nextBytes(bArr);
        String strB64u = mamiJs.b64u(bArr);
        RequestCtx requestCtx = new RequestCtx(strB64u, audience, j, l6 != null ? l6.longValue() : nowSec(j10), l10 != null ? l10.longValue() : System.nanoTime(), recipient.getRecipientKeyHash(), recipient.getPrivateKey());
        String recipientPublicKey = recipient.getRecipientPublicKey();
        String recipientKeyHash = recipient.getRecipientKeyHash();
        StringBuilder sbK = s.k("{\"version\":1,\"payloadVersion\":", i, ",\"suite\":\"P256-SHA256+RSA3072-OAEP256+A256GCM\",\"audience\":\"", audience, "\",\"nonce\":\"");
        d1.x(sbK, strB64u, "\",\"recipientPublicKey\":\"", recipientPublicKey, "\",\"recipientKeyHash\":\"");
        s.q(j, recipientKeyHash, "\",\"minimumRevision\":", sbK);
        sbK.append("}");
        return new Request(requestCtx, sbK.toString());
    }

    public final long nowSec(long j) {
        return (System.currentTimeMillis() / ((long) 1000)) + ((long) ((int) j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Opened open(byte[] body, RequestCtx ctx, Map<String, ? extends PublicKey> trusted, long j, Long l6, Long l10) throws EnvelopeException {
        boolean zVerify;
        String str = "unwrap";
        j.e(body, "body");
        j.e(ctx, "ctx");
        j.e(trusted, "trusted");
        EnvelopeFields envelope = parseEnvelope(body);
        long jLongValue = l6 != null ? l6.longValue() : nowSec(j);
        long jLongValue2 = l10 != null ? l10.longValue() : System.nanoTime();
        boolean z10 = true;
        check(!ctx.getUsed(), "replay", "this request was already answered");
        ctx.setUsed(true);
        check(jLongValue2 - ctx.getMonoNs() >= 0 && jLongValue2 - ctx.getMonoNs() <= ANSWER_WITHIN_NS, "late", "answer came more than 120 s after the request");
        check$default(this, envelope.getVersion() == 1 && j.a(envelope.getSuite(), SUITE), "suite", null, 4, null);
        check$default(this, isKeyId(envelope.getKeyId()), "key-id", null, 4, null);
        check(j.a(envelope.getAudience(), ctx.getAudience()) && j.a(envelope.getNonce(), ctx.getNonce()), "echo", "audience or nonce does not match the request");
        check(j.a(envelope.getRecipientKeyHash(), ctx.getRecipientKeyHash()), "recipient", "sealed to another key");
        check$default(this, envelope.getRevision() >= ctx.getMinimumRevision() && envelope.getRevision() > 0, "revision", null, 4, null);
        check(envelope.getIssuedAt() > 0 && envelope.getIssuedAt() <= jLongValue + 60, "issued-at", "issued in the future");
        check(envelope.getIssuedAt() >= ctx.getRequestedAt() - 60, "issued-at", "issued before the request");
        check$default(this, envelope.getExpiresAt() > jLongValue && envelope.getExpiresAt() > envelope.getIssuedAt(), "expired", null, 4, null);
        check(envelope.getExpiresAt() - envelope.getIssuedAt() <= WINDOW_SEC, "window", "valid for more than 6 hours");
        byte[] bArrStrictB64u = strictB64u(envelope.getWrappedKey(), 384, "wrapped-key");
        byte[] bArrStrictB64u2 = strictB64u(envelope.getIv(), 12, "iv");
        byte[] bArrStrictB64u3 = strictB64u(envelope.getCiphertext(), 262160, "ciphertext");
        byte[] bArrStrictB64u4 = strictB64u(envelope.getSignature(), 80, "signature");
        check$default(this, bArrStrictB64u.length == 384 && bArrStrictB64u2.length == 12 && bArrStrictB64u3.length >= 17, "lengths", null, 4, null);
        PublicKey publicKey = trusted.get(envelope.getKeyId());
        check(publicKey != null, "unknown-key", envelope.getKeyId());
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(publicKey);
            signature.update(INSTANCE.signedBytes(envelope));
            zVerify = signature.verify(bArrStrictB64u4);
        } catch (Exception unused) {
            zVerify = false;
        }
        check$default(this, zVerify, "signature", null, 4, null);
        String str2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        int i = 2;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            PrivateKey privateKey = ctx.getPrivateKey();
            MamiEnvelope mamiEnvelope = INSTANCE;
            cipher.init(2, privateKey, mamiEnvelope.getOaep());
            byte[] bArrDoFinal = cipher.doFinal(bArrStrictB64u);
            try {
                check(bArrDoFinal.length == 32, "unwrap", "key is not 32 bytes");
                try {
                    Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher2.init(2, new SecretKeySpec(bArrDoFinal, "AES"), new GCMParameterSpec(128, bArrStrictB64u2));
                    cipher2.updateAAD(mamiEnvelope.headerBytes(envelope));
                    byte[] bArrDoFinal2 = cipher2.doFinal(bArrStrictB64u3);
                    if (bArrDoFinal2.length > 262144) {
                        z10 = false;
                    }
                    check(z10, "size", "plaintext too large");
                    Opened opened = new Opened(bArrDoFinal2, envelope.getKeyId(), envelope.getRevision(), envelope.getIssuedAt(), envelope.getExpiresAt());
                    Arrays.fill(bArrDoFinal, (byte) 0);
                    return opened;
                } catch (Exception unused2) {
                    throw new EnvelopeException("decrypt", str2, i, objArr3 == true ? 1 : 0);
                }
            } catch (Throwable th2) {
                Arrays.fill(bArrDoFinal, (byte) 0);
                throw th2;
            }
        } catch (Exception unused3) {
            throw new EnvelopeException(str, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x011c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final EnvelopeFields parseEnvelope(byte[] body) throws EnvelopeException {
        boolean z10;
        j.e(body, "body");
        check$default(this, body.length != 0 && body.length <= 524288, "size", null, 4, null);
        try {
            CharsetDecoder charsetDecoderNewDecoder = kotlin.text.a.f23859a.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(body)).toString();
            j.b(string);
            LinkedHashMap<String, FlatValue> flatObject = parseFlatObject(string);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            BigInteger bigIntegerValueOf = BigInteger.valueOf(MamiJs.MAX_SAFE_INTEGER);
            BigInteger bigIntegerValueOf2 = BigInteger.valueOf(Long.MAX_VALUE);
            for (Map.Entry<String, FlatValue> entry : flatObject.entrySet()) {
                String key = entry.getKey();
                FlatValue value = entry.getValue();
                check(ALL_KEYS.contains(key), "fields", v0.a.h("unexpected key ", key));
                if (NUMBER_KEYS.contains(key)) {
                    check((value instanceof FlatValue.Num) && isWholeNumber(((FlatValue.Num) value).getRaw()), "fields", v0.a.p(key, " is not a whole number"));
                    j.c(value, "null cannot be cast to non-null type com.mlmvpn.scanner.engines.mami.MamiEnvelope.FlatValue.Num");
                    BigInteger bigInteger = new BigInteger(((FlatValue.Num) value).getRaw());
                    check(bigInteger.compareTo(bigIntegerValueOf2) <= 0, "fields", v0.a.p(key, " is too large"));
                    check(bigInteger.compareTo(bigIntegerValueOf) <= 0, "range", key);
                    map.put(key, Long.valueOf(bigInteger.longValue()));
                } else {
                    if (value instanceof FlatValue.Str) {
                        FlatValue.Str str = (FlatValue.Str) value;
                        if (str.getValue().length() <= 0) {
                            z10 = false;
                        } else if (str.getValue().length() <= (j.a(key, "ciphertext") ? 350000 : 1024)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else {
                        z10 = false;
                    }
                    check(z10, "fields", key);
                    j.c(value, "null cannot be cast to non-null type com.mlmvpn.scanner.engines.mami.MamiEnvelope.FlatValue.Str");
                    map2.put(key, ((FlatValue.Str) value).getValue());
                }
            }
            for (String str2 : ALL_KEYS) {
                check(map.containsKey(str2) || map2.containsKey(str2), "fields", v0.a.h("missing ", str2));
            }
            Object obj = map.get(ConstKt.SEP_VERSION);
            j.b(obj);
            long jLongValue = ((Number) obj).longValue();
            Object obj2 = map.get("issuedAt");
            j.b(obj2);
            long jLongValue2 = ((Number) obj2).longValue();
            Object obj3 = map.get("expiresAt");
            j.b(obj3);
            long jLongValue3 = ((Number) obj3).longValue();
            Object obj4 = map.get("revision");
            j.b(obj4);
            long jLongValue4 = ((Number) obj4).longValue();
            Object obj5 = map2.get("suite");
            j.b(obj5);
            String str3 = (String) obj5;
            Object obj6 = map2.get("keyId");
            j.b(obj6);
            String str4 = (String) obj6;
            Object obj7 = map2.get("audience");
            j.b(obj7);
            String str5 = (String) obj7;
            Object obj8 = map2.get("nonce");
            j.b(obj8);
            String str6 = (String) obj8;
            Object obj9 = map2.get("recipientKeyHash");
            j.b(obj9);
            String str7 = (String) obj9;
            Object obj10 = map2.get("wrappedKey");
            j.b(obj10);
            String str8 = (String) obj10;
            Object obj11 = map2.get("iv");
            j.b(obj11);
            String str9 = (String) obj11;
            Object obj12 = map2.get("ciphertext");
            j.b(obj12);
            String str10 = (String) obj12;
            Object obj13 = map2.get("signature");
            j.b(obj13);
            return new EnvelopeFields(jLongValue, jLongValue2, jLongValue3, jLongValue4, str3, str4, str5, str6, str7, str8, str9, str10, (String) obj13);
        } catch (CharacterCodingException unused) {
            throw new EnvelopeException("utf8", null, 2, 0 == true ? 1 : 0);
        }
    }

    public final LinkedHashMap<String, FlatValue> parseFlatObject(String text) throws EnvelopeException {
        FlatValue num;
        j.e(text, "text");
        Scanner scanner = new Scanner(text);
        LinkedHashMap<String, FlatValue> linkedHashMap = new LinkedHashMap<>();
        scanner.ws();
        check(scanner.getI() < scanner.getN() && text.charAt(scanner.getI()) == '{', "json", "not an object");
        scanner.setI(scanner.getI() + 1);
        scanner.ws();
        if (scanner.getI() >= scanner.getN() || text.charAt(scanner.getI()) != '}') {
            while (true) {
                scanner.ws();
                String strString = scanner.string();
                check(strString != null, "json", "expected a name");
                scanner.ws();
                check(scanner.getI() < scanner.getN() && text.charAt(scanner.getI()) == ':', "json", "expected :");
                scanner.setI(scanner.getI() + 1);
                scanner.ws();
                String strString2 = scanner.string();
                if (strString2 != null) {
                    num = new FlatValue.Str(strString2);
                } else {
                    String strNumber = scanner.number();
                    if (strNumber != null) {
                        num = new FlatValue.Num(strNumber);
                    } else {
                        if (!v.r0(text, scanner.getI(), "true", false) && !v.r0(text, scanner.getI(), "false", false) && !v.r0(text, scanner.getI(), "null", false)) {
                            throw new EnvelopeException("json", "unexpected value");
                        }
                        FlatValue.Other other = FlatValue.Other.INSTANCE;
                        scanner.setI(scanner.getI() + (v.r0(text, scanner.getI(), "false", false) ? 5 : 4));
                        num = other;
                    }
                }
                j.b(strString);
                check(!linkedHashMap.containsKey(strString), "json", "duplicate key ".concat(strString));
                linkedHashMap.put(strString, num);
                scanner.ws();
                if (scanner.getI() >= scanner.getN() || text.charAt(scanner.getI()) != ',') {
                    break;
                }
                scanner.setI(scanner.getI() + 1);
            }
            check(scanner.getI() < scanner.getN() && text.charAt(scanner.getI()) == '}', "json", "expected , or }");
            scanner.setI(scanner.getI() + 1);
        } else {
            scanner.setI(scanner.getI() + 1);
        }
        scanner.ws();
        check(scanner.getI() == scanner.getN(), "json", "data after the object");
        return linkedHashMap;
    }

    public final byte[] signedBytes(EnvelopeFields e10) {
        j.e(e10, "e");
        byte[] bArrHeaderBytes = headerBytes(e10);
        MamiJs mamiJs = MamiJs.INSTANCE;
        StringBuilder sbK = d1.k(e10.getWrappedKey(), "\n", e10.getIv(), "\n", e10.getCiphertext());
        sbK.append("\n");
        return o.j0(bArrHeaderBytes, mamiJs.latin1(sbK.toString()));
    }

    public final byte[] strictB64u(String str, int i, String code) throws EnvelopeException {
        boolean z10;
        j.e(code, "code");
        if (str != null && str.length() > 0 && str.length() <= ((i + 2) / 3) * 4) {
            int i10 = 0;
            while (true) {
                if (i10 >= str.length()) {
                    z10 = true;
                    break;
                }
                if (!MamiJs.INSTANCE.isB64uChar(str.charAt(i10))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
        } else {
            z10 = false;
            break;
        }
        check$default(this, z10, code, null, 4, null);
        MamiJs mamiJs = MamiJs.INSTANCE;
        j.b(str);
        byte[] bArrNodeBase64 = mamiJs.nodeBase64(str);
        check$default(this, bArrNodeBase64.length <= i && j.a(mamiJs.b64u(bArrNodeBase64), str), code, null, 4, null);
        return bArrNodeBase64;
    }
}
