package com.mlmvpn.scanner.ui.mami;

import com.mlmvpn.scanner.engines.mami.MamiEngine;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class k implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15518b;

    public /* synthetic */ k(Object obj, int i) {
        this.f15517a = i;
        this.f15518b = obj;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f15517a) {
            case 0:
                return MamiScreenKt.AnonymousClass4.C01444.invoke$lambda$2$lambda$1$lambda$0((MamiEngine.Method) this.f15518b);
            default:
                return MamiScreenKt.AnonymousClass4.AnonymousClass5.invoke$lambda$4$lambda$3$lambda$2((MamiEngine.PlaceRow) this.f15518b);
        }
    }
}
