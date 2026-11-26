package com.mlmvpn.scanner.ui.argo;

import android.content.Context;
import androidx.compose.foundation.layout.d1;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.engines.argo.ArgoPool;
import com.mlmvpn.scanner.engines.argo.ArgoProtocol;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12716c;

    public /* synthetic */ q(int i, Object obj, Object obj2) {
        this.f12714a = i;
        this.f12715b = obj;
        this.f12716c = obj2;
    }

    @Override // ee.a
    public final Object invoke() {
        int i = this.f12714a;
        Object obj = this.f12716c;
        Object obj2 = this.f12715b;
        switch (i) {
            case 0:
                return ArgoScreenKt.AnonymousClass2.invoke$lambda$25$lambda$24$lambda$23$lambda$21$lambda$20(d1.f1987a, (Context) obj2, (ArgoProtocol.FalconOrigin) obj);
            case 1:
                return ArgoScreenKt.C08882.invoke$lambda$10$lambda$9$lambda$5$lambda$4(d1.f1987a, (k2) obj2, (k2) obj);
            case 2:
                return ArgoScreenKt.C08882.invoke$lambda$19$lambda$13$lambda$12(d1.f1987a, (String) obj2, (k2) obj);
            case 3:
                return ArgoScreenKt.C08892.AnonymousClass7.invoke$lambda$2$lambda$1((SettingsGroupScope) obj2, (k2) obj);
            case 4:
                return ArgoScreenKt$ArgoList$2$8$1.invoke$lambda$6$lambda$5((ArgoPool.Group) obj2, (k2) obj);
            case 5:
                return ArgoScreenKt.AnonymousClass3.AnonymousClass4.invoke$lambda$2$lambda$1$lambda$0((ee.e) obj2, (ArgoPool.Row) obj);
            default:
                return ArgoScreenKt.C08912.AnonymousClass3.invoke$lambda$12$lambda$11$lambda$5$lambda$4((ArgoPool.SourceView) obj2, (k2) obj);
        }
    }

    public /* synthetic */ q(Context context, ArgoProtocol.FalconOrigin falconOrigin) {
        this.f12714a = 0;
        this.f12715b = context;
        this.f12716c = falconOrigin;
    }

    public /* synthetic */ q(k2 k2Var, k2 k2Var2) {
        this.f12714a = 1;
        this.f12715b = k2Var;
        this.f12716c = k2Var2;
    }

    public /* synthetic */ q(String str, k2 k2Var) {
        this.f12714a = 2;
        this.f12715b = str;
        this.f12716c = k2Var;
    }
}
