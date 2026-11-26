package com.mlmvpn.scanner.ui.argo;

import androidx.compose.ui.semantics.j0;
import com.mlmvpn.scanner.engines.argo.ArgoPool;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a0 implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12643b;

    public /* synthetic */ a0(Object obj, int i) {
        this.f12642a = i;
        this.f12643b = obj;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f12642a) {
            case 0:
                return ArgoScreenKt.C08912.AnonymousClass3.invoke$lambda$12$lambda$11$lambda$10$lambda$9((ArgoPool.SourceView) this.f12643b, ((Boolean) obj).booleanValue());
            case 1:
                return ArgoScreenKt.ArgoList$lambda$110$lambda$109((ee.e) this.f12643b, (String) obj);
            case 2:
                return ArgoScreenKt.vpnLauncher$lambda$21$lambda$20((ee.a) this.f12643b, (e.a) obj);
            default:
                return ArgoScreenKt.PowerButton$lambda$88$lambda$85$lambda$84((String) this.f12643b, (j0) obj);
        }
    }
}
