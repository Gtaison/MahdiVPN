package com.mlmvpn.scanner.ui.mami;

import androidx.compose.runtime.k2;
import androidx.compose.ui.semantics.j0;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15483b;

    public /* synthetic */ a(Object obj, int i) {
        this.f15482a = i;
        this.f15483b = obj;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f15482a) {
            case 0:
                return MamiScreenKt.MamiScreen$lambda$12$lambda$11((k2) this.f15483b, (Page) obj);
            case 1:
                return MamiScreenKt.PowerButton$lambda$72$lambda$69$lambda$68((String) this.f15483b, (j0) obj);
            default:
                return MamiScreenKt.vpnLauncher$lambda$21$lambda$20((ee.a) this.f15483b, (e.a) obj);
        }
    }
}
