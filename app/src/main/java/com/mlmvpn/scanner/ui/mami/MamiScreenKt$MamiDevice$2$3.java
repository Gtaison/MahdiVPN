package com.mlmvpn.scanner.ui.mami;

import androidx.compose.material3.r1;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.n;
import androidx.compose.runtime.o;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.v0;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final class MamiScreenKt$MamiDevice$2$3 implements ee.e {
    final /* synthetic */ k2 $confirm$delegate;

    public MamiScreenKt$MamiDevice$2$3(k2 k2Var) {
        this.$confirm$delegate = k2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u invoke$lambda$1$lambda$0(k2 k2Var) {
        MamiScreenKt.MamiDevice$lambda$91(k2Var, null);
        return u.f67154a;
    }

    @Override // ee.e
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((o) obj, ((Number) obj2).intValue());
        return u.f67154a;
    }

    public final void invoke(o oVar, int i) {
        int i10 = 2;
        if ((i & 3) == 2) {
            p0 p0Var = (p0) oVar;
            if (p0Var.G()) {
                p0Var.Y();
                return;
            }
        }
        r0 r0Var = v0.f3474a;
        p0 p0Var2 = (p0) oVar;
        p0Var2.e0(-845668859);
        k2 k2Var = this.$confirm$delegate;
        Object objI = p0Var2.I();
        if (objI == n.f3284a) {
            objI = new f(i10, k2Var);
            p0Var2.r0(objI);
        }
        p0Var2.u(false);
        r1.j((ee.a) objI, null, false, null, null, null, null, null, null, ComposableSingletons$MamiScreenKt.INSTANCE.m777getLambda4$app_release(), oVar, 805306374, 510);
    }
}
