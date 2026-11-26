package com.mlmvpn.scanner.engines.argo;

import java.util.List;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$measureExits$2$3$1", f = "ArgoPool.kt", l = {}, m = "invokeSuspend")
public final class ArgoPool$measureExits$2$3$1 extends j implements ee.e {
    final /* synthetic */ int $i;
    final /* synthetic */ List<Integer> $ports;
    final /* synthetic */ ArgoPool.Trace $tr;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoPool$measureExits$2$3$1(ArgoPool.Trace trace, List<Integer> list, int i, wd.d dVar) {
        super(2, dVar);
        this.$tr = trace;
        this.$ports = list;
        this.$i = i;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoPool$measureExits$2$3$1(this.$tr, this.$ports, this.$i, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        if (this.$tr.getOk()) {
            this.$tr.setCarried(ArgoPool.INSTANCE.carry(this.$ports.get(this.$i).intValue()));
        }
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoPool$measureExits$2$3$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
