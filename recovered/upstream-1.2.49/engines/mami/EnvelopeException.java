package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class EnvelopeException extends Exception {
    public static final int $stable = 0;
    private final String code;
    private final String detail;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnvelopeException(String code, String str) {
        super(str != null ? f0.a.l(code, ": ", str) : code);
        j.e(code, "code");
        this.code = code;
        this.detail = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDetail() {
        return this.detail;
    }

    public /* synthetic */ EnvelopeException(String str, String str2, int i, kotlin.jvm.internal.e eVar) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
