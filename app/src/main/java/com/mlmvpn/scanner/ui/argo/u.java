package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.engines.argo.ArgoPool;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12722b;

    public /* synthetic */ u(Object obj, int i) {
        this.f12721a = i;
        this.f12722b = obj;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f12721a) {
            case 0:
                return ArgoScreenKt.C08882.invoke$lambda$19$lambda$18$lambda$17((ee.e) this.f12722b);
            case 1:
                return ArgoScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$1$lambda$0((ee.e) this.f12722b);
            default:
                return ArgoScreenKt.C08912.AnonymousClass3.invoke$lambda$12$lambda$11$lambda$3$lambda$2((ArgoPool.SourceView) this.f12722b);
        }
    }
}
