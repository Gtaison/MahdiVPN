package com.mlmvpn.scanner.ui.argo;

import android.content.Context;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sd.a f12739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k2 f12740d;

    public /* synthetic */ y(int i, k2 k2Var, Object obj, sd.a aVar) {
        this.f12737a = i;
        this.f12738b = obj;
        this.f12739c = aVar;
        this.f12740d = k2Var;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f12737a) {
            case 0:
                return ArgoScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$4$lambda$3((SettingsGroupScope) this.f12738b, (ee.c) this.f12739c, this.f12740d);
            case 1:
                return ArgoScreenKt.AnonymousClass3.AnonymousClass5.invoke$lambda$5$lambda$4((SettingsGroupScope) this.f12738b, (ee.c) this.f12739c, this.f12740d);
            default:
                return ArgoScreenKt.rememberConnect$lambda$31$lambda$30((Context) this.f12738b, (ee.a) this.f12739c, this.f12740d);
        }
    }
}
