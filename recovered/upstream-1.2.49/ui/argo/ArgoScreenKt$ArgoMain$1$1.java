package com.mlmvpn.scanner.ui.argo;

import android.content.Context;
import com.mlmvpn.core.warp.XrayHosts;
import com.mlmvpn.scanner.engines.argo.ArgoEngine;
import kotlinx.coroutines.i0;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$1$1", f = "ArgoScreen.kt", l = {}, m = "invokeSuspend")
public final class ArgoScreenKt$ArgoMain$1$1 extends xd.j implements ee.e {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $ours;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoScreenKt$ArgoMain$1$1(boolean z10, Context context, wd.d dVar) {
        super(2, dVar);
        this.$ours = z10;
        this.$context = context;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoScreenKt$ArgoMain$1$1(this.$ours, this.$context, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sd.m.b(obj);
        if ((ArgoEngine.INSTANCE.getConn().getValue() instanceof ArgoEngine.Conn.Idle) && !this.$ours) {
            XrayHosts xrayHosts = XrayHosts.INSTANCE;
            xrayHosts.warm(this.$context, xrayHosts.getTUNNEL());
        }
        return sd.u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoScreenKt$ArgoMain$1$1) create(i0Var, dVar)).invokeSuspend(sd.u.f67154a);
    }
}
