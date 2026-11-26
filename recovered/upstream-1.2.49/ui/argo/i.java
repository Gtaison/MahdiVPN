package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.engines.argo.ArgoPool;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12677d;

    public /* synthetic */ i(Object obj, Object obj2, int i, int i10) {
        this.f12674a = i10;
        this.f12676c = obj;
        this.f12677d = obj2;
        this.f12675b = i;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12674a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ArgoScreenKt.ItemRow$lambda$139((ArgoPool.Row) this.f12676c, (RowCtx) this.f12677d, this.f12675b, (androidx.compose.runtime.o) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return ArgoScreenKt.ArgoClean$lambda$155((ee.c) this.f12676c, (String) this.f12677d, this.f12675b, (androidx.compose.runtime.o) obj, iIntValue2);
        }
    }
}
