package com.mlmvpn.scanner.engines.mami;

import com.mlmvpn.scanner.MyVpnService;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import sd.m;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$launch$phase$1", f = "MamiEngine.kt", l = {883}, m = "invokeSuspend")
public final class MamiEngine$launch$phase$1 extends j implements ee.e {
    final /* synthetic */ u $sawConnecting;
    int label;

    /* JADX INFO: renamed from: com.mlmvpn.scanner.engines.mami.MamiEngine$launch$phase$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    @xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$launch$phase$1$1", f = "MamiEngine.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends j implements ee.e {
        final /* synthetic */ u $sawConnecting;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(u uVar, wd.d dVar) {
            super(2, dVar);
            this.$sawConnecting = uVar;
        }

        @Override // xd.a
        public final wd.d create(Object obj, wd.d dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sawConnecting, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // ee.e
        public final Object invoke(MyVpnService.Phase phase, wd.d dVar) {
            return ((AnonymousClass1) create(phase, dVar)).invokeSuspend(sd.u.f67154a);
        }

        @Override // xd.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            m.b(obj);
            MyVpnService.Phase phase = (MyVpnService.Phase) this.L$0;
            boolean z10 = true;
            if (phase == MyVpnService.Phase.CONNECTING) {
                this.$sawConnecting.element = true;
            }
            if ((phase != MyVpnService.Phase.CONNECTED || !kotlin.jvm.internal.j.a(((g1) MyVpnService.Companion.getConnectedNodeIdFlow()).getValue(), "mami")) && (!this.$sawConnecting.element || (phase != MyVpnService.Phase.IDLE && phase != MyVpnService.Phase.FAILED))) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiEngine$launch$phase$1(u uVar, wd.d dVar) {
        super(2, dVar);
        this.$sawConnecting = uVar;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$launch$phase$1(this.$sawConnecting, dVar);
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
        k0 connectionPhaseFlow = MyVpnService.Companion.getConnectionPhaseFlow();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sawConnecting, null);
        this.label = 1;
        Object objH = kotlinx.coroutines.flow.h.h(connectionPhaseFlow, anonymousClass1, this);
        return objH == aVar ? aVar : objH;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$launch$phase$1) create(i0Var, dVar)).invokeSuspend(sd.u.f67154a);
    }
}
