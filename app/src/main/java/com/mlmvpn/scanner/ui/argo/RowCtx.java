package com.mlmvpn.scanner.ui.argo;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
final class RowCtx {
    private final boolean connecting;
    private final boolean hasClean;
    private final String hereId;
    private final ee.a onClean;
    private final ee.c onConnect;
    private final ee.c onTest;
    private final boolean testing;

    public RowCtx(String str, boolean z10, boolean z11, boolean z12, ee.c onConnect, ee.c onTest, ee.a onClean) {
        kotlin.jvm.internal.j.e(onConnect, "onConnect");
        kotlin.jvm.internal.j.e(onTest, "onTest");
        kotlin.jvm.internal.j.e(onClean, "onClean");
        this.hereId = str;
        this.connecting = z10;
        this.testing = z11;
        this.hasClean = z12;
        this.onConnect = onConnect;
        this.onTest = onTest;
        this.onClean = onClean;
    }

    public final boolean getConnecting() {
        return this.connecting;
    }

    public final boolean getHasClean() {
        return this.hasClean;
    }

    public final String getHereId() {
        return this.hereId;
    }

    public final ee.a getOnClean() {
        return this.onClean;
    }

    public final ee.c getOnConnect() {
        return this.onConnect;
    }

    public final ee.c getOnTest() {
        return this.onTest;
    }

    public final boolean getTesting() {
        return this.testing;
    }
}
