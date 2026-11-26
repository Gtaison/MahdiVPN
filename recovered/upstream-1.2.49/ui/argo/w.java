package com.mlmvpn.scanner.ui.argo;

import androidx.compose.foundation.layout.d1;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ee.c f12728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12729c;

    public /* synthetic */ w(int i, String str, ee.c cVar) {
        this.f12727a = i;
        this.f12728b = cVar;
        this.f12729c = str;
    }

    @Override // ee.a
    public final Object invoke() {
        int i = this.f12727a;
        String str = this.f12729c;
        ee.c cVar = this.f12728b;
        switch (i) {
            case 0:
                return ArgoScreenKt.C08892.invoke$lambda$6$lambda$5$lambda$3$lambda$2(cVar, str);
            case 1:
                return ArgoScreenKt.TestCard$lambda$72$lambda$71$lambda$63$lambda$62(cVar, d1.f1987a, str);
            default:
                return ArgoScreenKt.TestCard$lambda$72$lambda$71$lambda$66$lambda$65(cVar, d1.f1987a, str);
        }
    }
}
