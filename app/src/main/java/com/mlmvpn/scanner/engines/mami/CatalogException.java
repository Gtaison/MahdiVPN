package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class CatalogException extends Exception {
    public static final int $stable = 0;
    private final String why;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogException(String why) {
        super(why);
        j.e(why, "why");
        this.why = why;
    }

    public final String getWhy() {
        return this.why;
    }
}
