package com.mlmvpn.scanner.engines.mami;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11596b;

    public /* synthetic */ d(Object obj, int i) {
        this.f11595a = i;
        this.f11596b = obj;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f11595a) {
            case 0:
                return MamiEngine.disconnectAsync$lambda$81((Context) this.f11596b);
            default:
                return MamiNet.Resp.json_delegate$lambda$1((MamiNet.Resp) this.f11596b);
        }
    }
}
