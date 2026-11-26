package com.mlmvpn.scanner.ui.mami;

import androidx.compose.foundation.layout.b3;
import androidx.compose.foundation.layout.d0;
import androidx.compose.material3.k9;
import androidx.compose.runtime.o;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.v0;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.settings.Ios;
import com.mlmvpn.scanner.ui.settings.IosSettingsKt;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;
import sd.u;
import x6.p;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final class ComposableSingletons$MamiScreenKt {
    public static final ComposableSingletons$MamiScreenKt INSTANCE = new ComposableSingletons$MamiScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    private static ee.f f211lambda1 = p.g(312831790, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.ComposableSingletons$MamiScreenKt$lambda-1$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (o) obj2, ((Number) obj3).intValue());
            return u.f67154a;
        }

        public final void invoke(d0 IosScreen, o oVar, int i) {
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
    private static ee.f f212lambda2 = p.g(-1597253405, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.ComposableSingletons$MamiScreenKt$lambda-2$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
            return u.f67154a;
        }

        public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
            kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            IosSettingsKt.m863SettingsRowqhMrWXk(StoreNetKt.tr("هنوز فهرستی نیست", "No list yet"), null, 0L, null, StoreNetKt.tr("«به\u200cروزرسانی فهرست» را بزنید، یا با روش «خودکار» وصل شوید.", "Tap «Refresh the list», or connect with «Auto»."), 0L, false, null, 0, oVar, 1572864, 430);
        }
    }, false);

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    private static ee.f f213lambda3 = p.g(8590385, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.ComposableSingletons$MamiScreenKt$lambda-3$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((b3) obj, (o) obj2, ((Number) obj3).intValue());
            return u.f67154a;
        }

        public final void invoke(b3 TextButton, o oVar, int i) {
            kotlin.jvm.internal.j.e(TextButton, "$this$TextButton");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            k9.b(StoreNetKt.tr("پاک شود", "Clear"), null, Ios.INSTANCE.getRed(oVar, 6), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 0, 0, 131066);
        }
    }, false);

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    private static ee.f f214lambda4 = p.g(1902924271, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.ComposableSingletons$MamiScreenKt$lambda-4$1
        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((b3) obj, (o) obj2, ((Number) obj3).intValue());
            return u.f67154a;
        }

        public final void invoke(b3 TextButton, o oVar, int i) {
            kotlin.jvm.internal.j.e(TextButton, "$this$TextButton");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            k9.b(StoreNetKt.tr("انصراف", "Cancel"), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 0, 0, 131070);
        }
    }, false);

    /* JADX INFO: renamed from: getLambda-1$app_release, reason: not valid java name */
    public final ee.f m774getLambda1$app_release() {
        return f211lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_release, reason: not valid java name */
    public final ee.f m775getLambda2$app_release() {
        return f212lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_release, reason: not valid java name */
    public final ee.f m776getLambda3$app_release() {
        return f213lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_release, reason: not valid java name */
    public final ee.f m777getLambda4$app_release() {
        return f214lambda4;
    }
}
