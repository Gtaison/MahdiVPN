package com.mlmvpn.scanner.engines.mami;

import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$tryServers$tr$1", f = "MamiEngine.kt", l = {690}, m = "invokeSuspend")
public final class MamiEngine$tryServers$tr$1 extends j implements ee.c {
    int label;

    public MamiEngine$tryServers$tr$1(wd.d dVar) {
        super(1, dVar);
    }

    @Override // xd.a
    public final wd.d create(wd.d dVar) {
        return new MamiEngine$tryServers$tr$1(dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            return obj;
        }
        m.b(obj);
        MamiEngine mamiEngine = MamiEngine.INSTANCE;
        this.label = 1;
        Object objTraceHttp = mamiEngine.traceHttp(this);
        return objTraceHttp == aVar ? aVar : objTraceHttp;
    }

    @Override // ee.c
    public final Object invoke(wd.d dVar) {
        return ((MamiEngine$tryServers$tr$1) create(dVar)).invokeSuspend(u.f67154a);
    }
}
