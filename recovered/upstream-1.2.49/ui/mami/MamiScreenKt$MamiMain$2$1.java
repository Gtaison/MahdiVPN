package com.mlmvpn.scanner.ui.mami;

import android.content.Context;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import kotlinx.coroutines.i0;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$2$1", f = "MamiScreen.kt", l = {}, m = "invokeSuspend")
public final class MamiScreenKt$MamiMain$2$1 extends xd.j implements ee.e {
    final /* synthetic */ Context $context;
    final /* synthetic */ k2 $note$delegate;
    final /* synthetic */ l4 $st$delegate;
    final /* synthetic */ k2 $wasPhase$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiScreenKt$MamiMain$2$1(Context context, l4 l4Var, k2 k2Var, k2 k2Var2, wd.d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$st$delegate = l4Var;
        this.$wasPhase$delegate = k2Var;
        this.$note$delegate = k2Var2;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiScreenKt$MamiMain$2$1(this.$context, this.$st$delegate, this.$wasPhase$delegate, this.$note$delegate, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sd.m.b(obj);
        if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase(), "on") && kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$51(this.$wasPhase$delegate), TunnelVpnService.STATUS_CONNECTING)) {
            com.mlmvpn.scanner.e.t(this.$context, "✅ مامی وصل شد — داده واقعاً رد شد", 0, "✅ Mami connected — data really passed");
        }
        if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase(), TunnelVpnService.STATUS_CONNECTING)) {
            MamiScreenKt.MamiMain$lambda$48(this.$note$delegate, "");
        }
        this.$wasPhase$delegate.setValue(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase());
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiScreenKt$MamiMain$2$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
