package com.mlmvpn.scanner.engines.argo;

import java.util.List;
import kotlinx.coroutines.i0;
import sd.l;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$4$1", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
public final class ArgoPool$measureExits$2$4$1 extends j implements ee.e {
    final /* synthetic */ int $i;
    final /* synthetic */ List<Integer> $ports;
    final /* synthetic */ ArgoPool.Ready $r;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoPool$measureExits$2$4$1(ArgoPool.Ready ready, List<Integer> list, int i, wd.d dVar) {
        super(2, dVar);
        this.$r = ready;
        this.$ports = list;
        this.$i = i;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        ArgoPool$measureExits$2$4$1 argoPool$measureExits$2$4$1 = new ArgoPool$measureExits$2$4$1(this.$r, this.$ports, this.$i, dVar);
        argoPool$measureExits$2$4$1.L$0 = obj;
        return argoPool$measureExits$2$4$1;
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        Object objM1004constructorimpl;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        ArgoPool.Ready ready = this.$r;
        try {
            objM1004constructorimpl = l.m1004constructorimpl(ArgoNet.INSTANCE.sessionRequest("disconnect", ready.getEp().getHost(), ready.getEp().getPort(), ready.getInfo(), ArgoPool.INSTANCE.socks(this.$ports.get(this.$i).intValue()), 6000L));
        } catch (Throwable th2) {
            objM1004constructorimpl = l.m1004constructorimpl(m.a(th2));
        }
        return l.m1003boximpl(objM1004constructorimpl);
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoPool$measureExits$2$4$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
