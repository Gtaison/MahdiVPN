package com.mlmvpn.scanner.engines.mami;

import kotlin.text.o;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectExclusive$bridge$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
public final class MamiEngine$connectExclusive$bridge$1 extends j implements ee.e {
    int label;

    public MamiEngine$connectExclusive$bridge$1(wd.d dVar) {
        super(2, dVar);
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$connectExclusive$bridge$1(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        MamiExclusive.Bridge bridgeDecodeBlock$default;
        String strA;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        sf.c cVarSavedExclusive = MamiApi.INSTANCE.savedExclusive();
        if (cVarSavedExclusive == null || (strA = cVarSavedExclusive.A("block", "")) == null) {
            bridgeDecodeBlock$default = null;
        } else {
            if (o.L0(strA)) {
                strA = null;
            }
            if (strA != null) {
                try {
                    bridgeDecodeBlock$default = MamiExclusive.decodeBlock$default(MamiExclusive.INSTANCE, strA, null, 2, null);
                } catch (Exception e10) {
                    MamiEngine.INSTANCE.log("پل ذخیره\u200cشده دیگر معتبر نیست (" + e10.getMessage() + ") — پل تازه خواسته می\u200cشود.");
                    bridgeDecodeBlock$default = null;
                }
            } else {
                bridgeDecodeBlock$default = null;
            }
        }
        return bridgeDecodeBlock$default == null ? MamiExclusive.decodeBlock$default(MamiExclusive.INSTANCE, MamiApi.INSTANCE.fetchExclusiveBridge().j("block"), null, 2, null) : bridgeDecodeBlock$default;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$connectExclusive$bridge$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
