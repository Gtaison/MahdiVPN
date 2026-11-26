package com.mlmvpn.scanner.engines.mami;

import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$template$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
public final class MamiEngine$connectExclusive$template$1 extends j implements ee.e {
    int label;

    public MamiEngine$connectExclusive$template$1(wd.d dVar) {
        super(2, dVar);
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$connectExclusive$template$1(dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) throws Exception {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        MamiApi mamiApi = MamiApi.INSTANCE;
        sf.c cVarSavedExclusiveTemplate = mamiApi.savedExclusiveTemplate();
        long jCurrentTimeMillis = cVarSavedExclusiveTemplate != null ? System.currentTimeMillis() - cVarSavedExclusiveTemplate.x(0L, "at") : Long.MAX_VALUE;
        if (cVarSavedExclusiveTemplate == null || jCurrentTimeMillis > 21600000) {
            try {
                cVarSavedExclusiveTemplate = mamiApi.fetchExclusiveTemplate();
            } catch (Exception e10) {
                if (cVarSavedExclusiveTemplate == null || jCurrentTimeMillis > 604800000) {
                    throw e10;
                }
                MamiEngine.INSTANCE.log("الگوی تازهٔ پل گرفته نشد (" + e10.getMessage() + ") — الگوی ذخیره\u200cشده به کار می\u200cرود.");
            }
        }
        MamiExclusive mamiExclusive = MamiExclusive.INSTANCE;
        kotlin.jvm.internal.j.b(cVarSavedExclusiveTemplate);
        return mamiExclusive.decodeTemplate(cVarSavedExclusiveTemplate.j("text"));
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$connectExclusive$template$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
