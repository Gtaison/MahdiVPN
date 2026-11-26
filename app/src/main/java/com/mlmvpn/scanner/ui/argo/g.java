package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.ui.mae.MaePagesKt;
import com.mlmvpn.scanner.ui.npv.NpvSourcesPageKt;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ee.c f12669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12670c;

    public /* synthetic */ g(int i, int i10, ee.c cVar) {
        this.f12668a = i10;
        this.f12669b = cVar;
        this.f12670c = i;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f12668a;
        androidx.compose.runtime.o oVar = (androidx.compose.runtime.o) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                return ArgoScreenKt.ArgoAdd$lambda$175(this.f12669b, this.f12670c, oVar, iIntValue);
            case 1:
                return ArgoScreenKt.ArgoSources$lambda$189(this.f12669b, this.f12670c, oVar, iIntValue);
            case 2:
                return ArgoScreenKt.ArgoLogs$lambda$193(this.f12669b, this.f12670c, oVar, iIntValue);
            case 3:
                return MaePagesKt.ForeignExitsList$lambda$29(this.f12669b, this.f12670c, oVar, iIntValue);
            case 4:
                return MaePagesKt.ForeignExitsList$lambda$30(this.f12669b, this.f12670c, oVar, iIntValue);
            default:
                return NpvSourcesPageKt.AddChannel$lambda$61(this.f12669b, this.f12670c, oVar, iIntValue);
        }
    }
}
