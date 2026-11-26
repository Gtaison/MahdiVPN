package com.mlmvpn.scanner.engines.mami;

import j$.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiJs {
    public static final int $stable = 0;
    public static final MamiJs INSTANCE = new MamiJs();
    public static final long MAX_SAFE_INTEGER = 9007199254740991L;

    private MamiJs() {
    }

    public final String b64u(byte[] b10) {
        j.e(b10, "b");
        String strEncodeToString = Base64.getUrlEncoder().withoutPadding().encodeToString(b10);
        j.d(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final byte[] canonicalB64u(String str) {
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length(); i++) {
                if (INSTANCE.isB64uChar(str.charAt(i))) {
                }
            }
            byte[] bArrNodeBase64 = nodeBase64(str);
            if (j.a(b64u(bArrNodeBase64), str)) {
                return bArrNodeBase64;
            }
        }
        return null;
    }

    public final String dropSpaces(String s8) {
        j.e(s8, "s");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s8.length(); i++) {
            char cCharAt = s8.charAt(i);
            if (!INSTANCE.isSpace(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    public final Object get(Object obj, String key) {
        Object objO;
        j.e(key, "key");
        if ((obj instanceof sf.c) && (objO = ((sf.c) obj).o(key)) != sf.c.f67157c) {
            return objO;
        }
        return null;
    }

    public final String hex(byte[] b10) {
        j.e(b10, "b");
        StringBuilder sb2 = new StringBuilder(b10.length * 2);
        for (byte b11 : b10) {
            sb2.append("0123456789abcdef".charAt((b11 >> 4) & 15));
            sb2.append("0123456789abcdef".charAt(b11 & 15));
        }
        String string = sb2.toString();
        j.d(string, "toString(...)");
        return string;
    }

    public final boolean isB64Body(String s8) {
        j.e(s8, "s");
        int length = s8.length();
        for (int i = 0; length > 0 && s8.charAt(length - 1) == '=' && i < 2; i++) {
            length--;
        }
        if (length == 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = s8.charAt(i10);
            if (('A' > cCharAt || cCharAt >= '[') && (('a' > cCharAt || cCharAt >= '{') && !(('0' <= cCharAt && cCharAt < ':') || cCharAt == '+' || cCharAt == '/'))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isB64uChar(char c2) {
        if ('A' <= c2 && c2 < '[') {
            return true;
        }
        if ('a' > c2 || c2 >= '{') {
            return ('0' <= c2 && c2 < ':') || c2 == '_' || c2 == '-';
        }
        return true;
    }

    public final boolean isInteger(Object obj) {
        Double dNum = num(obj);
        if (dNum != null) {
            double dDoubleValue = dNum.doubleValue();
            if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue) && dDoubleValue == Math.floor(dDoubleValue)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSafeInteger(Object obj) {
        Double dNum = num(obj);
        if (dNum != null) {
            double dDoubleValue = dNum.doubleValue();
            if (isInteger(obj) && Math.abs(dDoubleValue) <= 9.007199254740991E15d) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSpace(char c2) {
        if (('\t' <= c2 && c2 < 14) || c2 == ' ' || c2 == 160 || c2 == 5760) {
            return true;
        }
        return (8192 <= c2 && c2 < 8203) || c2 == 8232 || c2 == 8233 || c2 == 8239 || c2 == 8287 || c2 == 12288 || c2 == 65279;
    }

    public final List<Object> items(Object obj) {
        if (!(obj instanceof sf.a)) {
            return null;
        }
        sf.a aVar = (sf.a) obj;
        int size = aVar.f67155a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Object objM = aVar.m(i);
            if (objM == sf.c.f67157c) {
                objM = null;
            }
            arrayList.add(objM);
        }
        return arrayList;
    }

    public final byte[] latin1(String s8) {
        j.e(s8, "s");
        int length = s8.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (s8.charAt(i) & 255);
        }
        return bArr;
    }

    /* JADX INFO: renamed from: long, reason: not valid java name */
    public final long m302long(Object obj) {
        j.c(obj, "null cannot be cast to non-null type kotlin.Number");
        Number number = (Number) obj;
        return ((number instanceof Long) || (number instanceof Integer)) ? number.longValue() : (long) number.doubleValue();
    }

    public final byte[] nodeBase64(String s8) {
        int i;
        j.e(s8, "s");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((s8.length() / 4) * 3) + 3);
        int length = s8.length();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = s8.charAt(i12);
            if ('A' <= cCharAt && cCharAt < '[') {
                i = cCharAt - 'A';
            } else if ('a' <= cCharAt && cCharAt < '{') {
                i = cCharAt - 'G';
            } else if ('0' <= cCharAt && cCharAt < ':') {
                i = cCharAt + 4;
            } else if (cCharAt == '+' || cCharAt == '-') {
                i = 62;
            } else {
                if (cCharAt != '/' && cCharAt != '_') {
                    if (cCharAt == '=') {
                        break;
                    }
                } else {
                    i = 63;
                }
            }
            if (i10 != 0) {
                if (i10 == 1) {
                    byteArrayOutputStream.write((i11 << 2) | (i >> 4));
                } else if (i10 != 2) {
                    byteArrayOutputStream.write(((i11 & 3) << 6) | i);
                } else {
                    byteArrayOutputStream.write(((i11 & 15) << 4) | (i >> 2));
                }
            }
            i10 = (i10 + 1) % 4;
            i11 = i;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        j.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final Double num(Object obj) {
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        return null;
    }

    public final Object parseJson(String text) {
        Character chValueOf;
        j.e(text, "text");
        int i = 0;
        while (true) {
            if (i >= text.length()) {
                chValueOf = null;
                break;
            }
            char cCharAt = text.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
                chValueOf = Character.valueOf(cCharAt);
                break;
            }
            i++;
        }
        if (chValueOf == null) {
            throw new sf.b("empty");
        }
        char cCharValue = chValueOf.charValue();
        if (cCharValue != '{' && cCharValue != '[' && cCharValue != '\"' && cCharValue != '-' && (('0' > cCharValue || cCharValue >= ':') && cCharValue != 't' && cCharValue != 'f' && cCharValue != 'n')) {
            throw new sf.b("not JSON");
        }
        sf.f fVar = new sf.f(text);
        Object objE = fVar.e();
        if (fVar.c() != 0) {
            throw new sf.b("data after the value");
        }
        if ((objE instanceof String) && cCharValue != '\"') {
            throw new sf.b("not JSON");
        }
        if (objE == sf.c.f67157c) {
            return null;
        }
        return objE;
    }

    public final String trim(String s8) {
        j.e(s8, "s");
        int length = s8.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean zIsSpace = INSTANCE.isSpace(s8.charAt(!z10 ? i : length));
            if (z10) {
                if (!zIsSpace) {
                    break;
                }
                length--;
            } else if (zIsSpace) {
                i++;
            } else {
                z10 = true;
            }
        }
        return s8.subSequence(i, length + 1).toString();
    }
}
