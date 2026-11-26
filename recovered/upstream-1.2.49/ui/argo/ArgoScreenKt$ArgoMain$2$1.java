package com.mlmvpn.scanner.ui.argo;

import android.content.Context;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import com.mlmvpn.scanner.engines.argo.ArgoEngine;
import kotlinx.coroutines.i0;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$2$1", f = "ArgoScreen.kt", l = {}, m = "invokeSuspend")
public final class ArgoScreenKt$ArgoMain$2$1 extends xd.j implements ee.e {
    final /* synthetic */ l4 $conn$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ k2 $was$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoScreenKt$ArgoMain$2$1(Context context, l4 l4Var, k2 k2Var, wd.d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$conn$delegate = l4Var;
        this.$was$delegate = k2Var;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoScreenKt$ArgoMain$2$1(this.$context, this.$conn$delegate, this.$was$delegate, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sd.m.b(obj);
        if (ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate) instanceof ArgoEngine.Conn.Connected) {
            ArgoEngine.Conn connArgoMain$lambda$39 = ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate);
            kotlin.jvm.internal.j.c(connArgoMain$lambda$39, "null cannot be cast to non-null type com.mlmvpn.scanner.engines.argo.ArgoEngine.Conn.Connected");
            if (!((ArgoEngine.Conn.Connected) connArgoMain$lambda$39).getLost() && (ArgoScreenKt.ArgoMain$lambda$55(this.$was$delegate) instanceof ArgoEngine.Conn.Connecting)) {
                com.mlmvpn.scanner.e.t(this.$context, "✅ آرگو وصل شد — داده واقعاً رد شد", 0, "✅ Argo connected — data really passed");
            }
        }
        this.$was$delegate.setValue(ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate));
        return sd.u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoScreenKt$ArgoMain$2$1) create(i0Var, dVar)).invokeSuspend(sd.u.f67154a);
    }
}
