package com.mlmvpn.scanner.ui.argo;

import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.d3;
import androidx.compose.material3.c3;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.v0;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.settings.Ios;
import com.mlmvpn.scanner.ui.settings.IosSettingsKt;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ComposableSingletons$ArgoScreenKt {
    public static final ComposableSingletons$ArgoScreenKt INSTANCE = new ComposableSingletons$ArgoScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    private static ee.f f159lambda1 = x6.p.g(-214144365, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ComposableSingletons$ArgoScreenKt$lambda-1$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
        }
    }, false);

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    private static ee.f f160lambda2 = x6.p.g(408249219, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ComposableSingletons$ArgoScreenKt$lambda-2$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
            kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            IosSettingsKt.m863SettingsRowqhMrWXk(StoreNetKt.tr("چیزی در فهرست نیست — «به\u200cروزرسانی» را بزنید.", "The list is empty — tap «Refresh»."), null, 0L, null, null, 0L, false, null, 0, oVar, 1572864, 446);
        }
    }, false);

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    private static ee.e f161lambda3 = x6.p.g(-365570418, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ComposableSingletons$ArgoScreenKt$lambda-3$1
        @Override // ee.e
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
            return sd.u.f67154a;
        }

        public final void invoke(androidx.compose.runtime.o oVar, int i) {
            if ((i & 3) == 2) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            c3.b(null, Ios.INSTANCE.getOrange(oVar, 6), fc.a.r(), d3.m(androidx.compose.ui.q.f4604b, 20), oVar, 432, 0);
        }
    }, false);

    /* JADX INFO: renamed from: getLambda-1$app_release, reason: not valid java name */
    public final ee.f m550getLambda1$app_release() {
        return f159lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_release, reason: not valid java name */
    public final ee.f m551getLambda2$app_release() {
        return f160lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_release, reason: not valid java name */
    public final ee.e m552getLambda3$app_release() {
        return f161lambda3;
    }
}
