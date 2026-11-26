package com.mlmvpn.scanner.engines.mami;

import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectCatalog$parsed$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
public final class MamiEngine$connectCatalog$parsed$1 extends j implements ee.e {
    int label;

    public MamiEngine$connectCatalog$parsed$1(wd.d dVar) {
        super(2, dVar);
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$connectCatalog$parsed$1(dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        return MamiEngine.catalogNow$default(MamiEngine.INSTANCE, false, 1, null);
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$connectCatalog$parsed$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
