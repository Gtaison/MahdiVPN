package com.mlmvpn.scanner.ui.argo;

import android.content.Context;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.engines.argo.ArgoEngine;
import com.mlmvpn.scanner.engines.argo.ArgoPool;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v0;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoScreen$1$1", f = "ArgoScreen.kt", l = {118}, m = "invokeSuspend")
public final class ArgoScreenKt$ArgoScreen$1$1 extends xd.j implements ee.e {
    final /* synthetic */ Context $context;
    final /* synthetic */ k2 $ready$delegate;
    int label;

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoScreen$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoScreen$1$1$1", f = "ArgoScreen.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends xd.j implements ee.e {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, wd.d dVar) {
            super(2, dVar);
            this.$context = context;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            return new AnonymousClass1(this.$context, dVar);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sd.m.b(obj);
            ArgoEngine.INSTANCE.init(this.$context);
            return ArgoPool.INSTANCE.summary();
        }

        @Override // ee.e
        public final Object invoke(i0 i0Var, wd.d dVar) {
            return ((AnonymousClass1) create(i0Var, dVar)).invokeSuspend(sd.u.f67154a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoScreenKt$ArgoScreen$1$1(Context context, k2 k2Var, wd.d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$ready$delegate = k2Var;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoScreenKt$ArgoScreen$1$1(this.$context, this.$ready$delegate, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            sd.m.b(obj);
            oe.e eVar = v0.f24208c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, null);
            this.label = 1;
            if (m0.J(eVar, anonymousClass1, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sd.m.b(obj);
        }
        ArgoScreenKt.ArgoScreen$lambda$2(this.$ready$delegate, true);
        return sd.u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoScreenKt$ArgoScreen$1$1) create(i0Var, dVar)).invokeSuspend(sd.u.f67154a);
    }
}
