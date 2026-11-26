package com.mlmvpn.scanner.engines.argo;

import com.mlmvpn.scanner.engines.proton.ProtonStealth;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.q;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1$1$1$1", f = "ArgoPool.kt", l = {670}, m = "invokeSuspend")
public final class ArgoPool$test$1$1$1$1 extends j implements ee.e {
    final /* synthetic */ i0 $$this$launch;
    final /* synthetic */ w $alive;
    final /* synthetic */ kotlinx.coroutines.sync.a $chain;
    final /* synthetic */ String $connectIp;
    final /* synthetic */ w $done;
    final /* synthetic */ w $frozen;
    final /* synthetic */ List<ArgoPool.Item> $list;
    final /* synthetic */ AtomicInteger $next;
    final /* synthetic */ List<ArgoPool.Ready> $ready;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoPool$test$1$1$1$1(List<ArgoPool.Item> list, AtomicInteger atomicInteger, String str, List<ArgoPool.Ready> list2, w wVar, w wVar2, w wVar3, kotlinx.coroutines.sync.a aVar, i0 i0Var, wd.d dVar) {
        super(2, dVar);
        this.$list = list;
        this.$next = atomicInteger;
        this.$connectIp = str;
        this.$ready = list2;
        this.$done = wVar;
        this.$alive = wVar2;
        this.$frozen = wVar3;
        this.$chain = aVar;
        this.$$this$launch = i0Var;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoPool$test$1$1$1$1(this.$list, this.$next, this.$connectIp, this.$ready, this.$done, this.$alive, this.$frozen, this.$chain, this.$$this$launch, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i != 0 && i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        while (!ArgoPool.testCancel) {
            ArgoPool.Item item = (ArgoPool.Item) q.B0(this.$next.getAndIncrement(), this.$list);
            if (item == null) {
                break;
            }
            ArgoPool argoPool = ArgoPool.INSTANCE;
            ArgoProtocol.Endpoint endpointEndpointOf = argoPool.endpointOf(item);
            ArgoNet.Auth authAuthenticate = ArgoNet.INSTANCE.authenticate(endpointEndpointOf.getHost(), (32 & 2) != 0 ? ProtonStealth.PORT : endpointEndpointOf.getPort(), (32 & 4) != 0 ? "" : this.$connectIp, (32 & 8) != 0 ? "A" : endpointEndpointOf.getProtocol(), (32 & 16) != 0 ? 12000L : 10000L, (32 & 32) != 0 ? 0L : 0L);
            ArgoProtocol.SessionInfo info = authAuthenticate.getInfo();
            if (!authAuthenticate.getOk() || info == null) {
                ArgoPool.record$default(argoPool, item.getId(), false, authAuthenticate.getMs(), null, null, authAuthenticate.getError(), false, null, 216, null);
                ArgoPool.C04021.invokeSuspend$tally$default(this.$done, this.$alive, this.$frozen, 1, 0, 0, 48, null);
            } else {
                this.$ready.add(new ArgoPool.Ready(item, endpointEndpointOf, info, authAuthenticate.getMs()));
                if (this.$ready.size() >= 12) {
                    kotlinx.coroutines.sync.a aVar2 = this.$chain;
                    List<ArgoPool.Ready> list = this.$ready;
                    i0 i0Var = this.$$this$launch;
                    String str = this.$connectIp;
                    w wVar = this.$done;
                    w wVar2 = this.$alive;
                    w wVar3 = this.$frozen;
                    this.label = 1;
                    if (ArgoPool.C04021.invokeSuspend$flush(aVar2, list, i0Var, str, wVar, wVar2, wVar3, this) == aVar) {
                        return aVar;
                    }
                } else {
                    continue;
                }
            }
        }
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoPool$test$1$1$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
