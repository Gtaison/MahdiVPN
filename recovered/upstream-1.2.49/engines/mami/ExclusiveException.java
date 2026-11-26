package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ExclusiveException extends Exception {
    public static final int $stable = 0;
    private final String code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExclusiveException(String code, String message) {
        super(message);
        j.e(code, "code");
        j.e(message, "message");
        this.code = code;
    }

    public final String getCode() {
        return this.code;
    }
}
