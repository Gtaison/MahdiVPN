package com.mlmvpn.scanner.engines.argo;

import com.mlmvpn.scanner.engines.proton.ProtonStealth;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$tryOne$a$1", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
public final class ArgoEngine$tryOne$a$1 extends j implements ee.e {
    final /* synthetic */ ArgoProtocol.Endpoint $ep;
    final /* synthetic */ String $ip;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoEngine$tryOne$a$1(ArgoProtocol.Endpoint endpoint, String str, wd.d dVar) {
        super(2, dVar);
        this.$ep = endpoint;
        this.$ip = str;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoEngine$tryOne$a$1(this.$ep, this.$ip, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        return ArgoNet.INSTANCE.authenticate(this.$ep.getHost(), (32 & 2) != 0 ? ProtonStealth.PORT : this.$ep.getPort(), (32 & 4) != 0 ? "" : this.$ip, (32 & 8) != 0 ? "A" : this.$ep.getProtocol(), (32 & 16) != 0 ? 12000L : 0L, (32 & 32) != 0 ? 0L : 0L);
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoEngine$tryOne$a$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
