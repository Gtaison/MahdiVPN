package com.mlmvpn.scanner.ui.argo;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.activity.compose.n f12666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ee.a f12667d;

    public /* synthetic */ f(Context context, androidx.activity.compose.n nVar, ee.a aVar, int i) {
        this.f12664a = i;
        this.f12665b = context;
        this.f12666c = nVar;
        this.f12667d = aVar;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f12664a) {
            case 0:
                return ArgoScreenKt.vpnLauncher$lambda$24$lambda$23$lambda$22(this.f12665b, this.f12666c, this.f12667d);
            default:
                return ArgoScreenKt.vpnLauncher$lambda$24$lambda$23(this.f12665b, this.f12666c, this.f12667d);
        }
    }
}
