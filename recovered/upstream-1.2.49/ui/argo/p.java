package com.mlmvpn.scanner.ui.argo;

import androidx.compose.foundation.layout.c3;
import androidx.compose.foundation.layout.d1;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.engines.argo.ArgoPool;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12709a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k2 f12710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f12713e;

    public /* synthetic */ p(ArgoPool.CleanIp cleanIp, k2 k2Var, k2 k2Var2, k2 k2Var3) {
        this.f12713e = cleanIp;
        this.f12710b = k2Var;
        this.f12711c = k2Var2;
        this.f12712d = k2Var3;
    }

    @Override // ee.a
    public final Object invoke() {
        int i = this.f12709a;
        k2 k2Var = this.f12710b;
        Object obj = this.f12712d;
        Object obj2 = this.f12711c;
        Object obj3 = this.f12713e;
        switch (i) {
            case 0:
                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$14$lambda$13(d1.f1987a, (ee.e) obj3, k2Var, (k2) obj2, (k2) obj);
            case 1:
                return ArgoScreenKt.C08882.C01022.invoke$lambda$5$lambda$4$lambda$3$lambda$2(c3.f1985a, (ArgoPool.CleanIp) obj3, k2Var, (k2) obj2, (k2) obj);
            default:
                return ArgoScreenKt$ArgoList$2$8$1.invoke$lambda$4$lambda$3((SettingsGroupScope) obj3, (String) obj2, (ArgoPool.Group) obj, k2Var);
        }
    }

    public /* synthetic */ p(SettingsGroupScope settingsGroupScope, String str, ArgoPool.Group group, k2 k2Var) {
        this.f12713e = settingsGroupScope;
        this.f12711c = str;
        this.f12712d = group;
        this.f12710b = k2Var;
    }

    public /* synthetic */ p(ee.e eVar, k2 k2Var, k2 k2Var2, k2 k2Var3) {
        this.f12713e = eVar;
        this.f12710b = k2Var;
        this.f12711c = k2Var2;
        this.f12712d = k2Var3;
    }
}
