package com.mlmvpn.scanner.ui.mami;

import android.content.Context;
import com.mlmvpn.scanner.engines.mami.MamiEngine;
import java.io.IOException;
import kotlinx.coroutines.i0;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$1$1", f = "MamiScreen.kt", l = {}, m = "invokeSuspend")
public final class MamiScreenKt$MamiMain$1$1 extends xd.j implements ee.e {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiScreenKt$MamiMain$1$1(Context context, wd.d dVar) {
        super(2, dVar);
        this.$context = context;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiScreenKt$MamiMain$1$1(this.$context, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) throws IOException {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sd.m.b(obj);
        MamiEngine.INSTANCE.prewarm(this.$context);
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiScreenKt$MamiMain$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
