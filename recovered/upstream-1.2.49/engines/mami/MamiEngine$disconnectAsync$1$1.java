package com.mlmvpn.scanner.engines.mami;

import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$disconnectAsync$1$1", f = "MamiEngine.kt", l = {797}, m = "invokeSuspend")
public final class MamiEngine$disconnectAsync$1$1 extends j implements ee.e {
    int label;

    public MamiEngine$disconnectAsync$1$1(wd.d dVar) {
        super(2, dVar);
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$disconnectAsync$1$1(dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            m.b(obj);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            this.label = 1;
            if (mamiEngine.disconnectNow("user", this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
        }
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$disconnectAsync$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
