package com.mlmvpn.scanner.ui.mami;

import android.content.Context;
import androidx.compose.material3.r1;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.n;
import androidx.compose.runtime.o;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.v0;
import com.mlmvpn.scanner.engines.mami.MamiEngine;
import com.mlmvpn.scanner.store.StoreNetKt;
import java.io.IOException;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final class MamiScreenKt$MamiDevice$2$2 implements ee.e {
    final /* synthetic */ k2 $confirm$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $device;
    final /* synthetic */ k2 $note$delegate;

    public MamiScreenKt$MamiDevice$2$2(Context context, boolean z10, k2 k2Var, k2 k2Var2) {
        this.$context = context;
        this.$device = z10;
        this.$note$delegate = k2Var;
        this.$confirm$delegate = k2Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u invoke$lambda$1$lambda$0(Context context, boolean z10, k2 k2Var, k2 k2Var2) throws IOException {
        String str;
        String str2;
        String strForget = MamiEngine.INSTANCE.forget(context, z10);
        if (strForget == null) {
            if (z10) {
                str = "هویت این دستگاه پاک شد؛ اتصال بعدی دستگاه را دوباره ثبت می\u200cکند.";
                str2 = "This device's identity was cleared; the next connect registers it again.";
            } else {
                str = "نشست و فهرست پاک شد.";
                str2 = "Session and list cleared.";
            }
            strForget = StoreNetKt.tr(str, str2);
        }
        k2Var.setValue(strForget);
        MamiScreenKt.MamiDevice$lambda$91(k2Var2, null);
        return u.f67154a;
    }

    @Override // ee.e
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((o) obj, ((Number) obj2).intValue());
        return u.f67154a;
    }

    public final void invoke(o oVar, int i) {
        if ((i & 3) == 2) {
            p0 p0Var = (p0) oVar;
            if (p0Var.G()) {
                p0Var.Y();
                return;
            }
        }
        r0 r0Var = v0.f3474a;
        p0 p0Var2 = (p0) oVar;
        p0Var2.e0(-845683305);
        boolean zH = p0Var2.h(this.$context) | p0Var2.g(this.$device);
        final Context context = this.$context;
        final boolean z10 = this.$device;
        final k2 k2Var = this.$note$delegate;
        final k2 k2Var2 = this.$confirm$delegate;
        Object objI = p0Var2.I();
        if (zH || objI == n.f3284a) {
            objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.g
                @Override // ee.a
                public final Object invoke() {
                    return MamiScreenKt$MamiDevice$2$2.invoke$lambda$1$lambda$0(context, z10, k2Var, k2Var2);
                }
            };
            p0Var2.r0(objI);
        }
        p0Var2.u(false);
        r1.j((ee.a) objI, null, false, null, null, null, null, null, null, ComposableSingletons$MamiScreenKt.INSTANCE.m776getLambda3$app_release(), oVar, 805306368, 510);
    }
}
