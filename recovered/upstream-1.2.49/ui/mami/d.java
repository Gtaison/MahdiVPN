package com.mlmvpn.scanner.ui.mami;

import android.content.Context;
import androidx.compose.runtime.k2;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f15492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k2 f15493c;

    public /* synthetic */ d(int i, Context context, k2 k2Var) {
        this.f15491a = i;
        this.f15492b = context;
        this.f15493c = k2Var;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f15491a) {
            case 0:
                return MamiScreenKt.MamiMain$lambda$41$lambda$40(this.f15492b, this.f15493c);
            default:
                return MamiScreenKt.MamiServers$lambda$82$lambda$81(this.f15492b, this.f15493c);
        }
    }
}
