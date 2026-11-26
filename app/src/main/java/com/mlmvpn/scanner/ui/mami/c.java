package com.mlmvpn.scanner.ui.mami;

import android.content.Context;
import androidx.activity.compose.n;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.engines.mami.MamiEngine;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ee.a f15490d;

    public /* synthetic */ c(Context context, n nVar, ee.a aVar, int i) {
        this.f15487a = i;
        this.f15488b = context;
        this.f15489c = nVar;
        this.f15490d = aVar;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f15487a) {
            case 0:
                return MamiScreenKt.vpnLauncher$lambda$24$lambda$23$lambda$22((Context) this.f15488b, (n) this.f15489c, this.f15490d);
            case 1:
                return MamiScreenKt.vpnLauncher$lambda$24$lambda$23((Context) this.f15488b, (n) this.f15489c, this.f15490d);
            default:
                return MamiScreenKt.C09481.AnonymousClass2.invoke$lambda$3$lambda$2$lambda$1$lambda$0((MamiEngine.ServerRow) this.f15488b, this.f15490d, (k2) this.f15489c);
        }
    }

    public /* synthetic */ c(MamiEngine.ServerRow serverRow, ee.a aVar, k2 k2Var) {
        this.f15487a = 2;
        this.f15488b = serverRow;
        this.f15490d = aVar;
        this.f15489c = k2Var;
    }
}
