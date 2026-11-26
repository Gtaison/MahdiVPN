package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    public static final int $stable = 8;
    private final String body;
    private final RequestCtx ctx;

    public Request(RequestCtx ctx, String body) {
        j.e(ctx, "ctx");
        j.e(body, "body");
        this.ctx = ctx;
        this.body = body;
    }

    public final String getBody() {
        return this.body;
    }

    public final RequestCtx getCtx() {
        return this.ctx;
    }
}
