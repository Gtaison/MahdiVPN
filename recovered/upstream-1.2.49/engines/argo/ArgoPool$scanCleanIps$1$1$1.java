package com.mlmvpn.scanner.engines.argo;

import java.util.List;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.sync.h;
import kotlinx.coroutines.sync.l;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$1$1", f = "ArgoPool.kt", l = {955}, m = "invokeSuspend")
public final class ArgoPool$scanCleanIps$1$1$1 extends j implements ee.e {
    final /* synthetic */ w $done;
    final /* synthetic */ h $gate1;
    final /* synthetic */ String $ip;
    final /* synthetic */ List<ArgoPool.Item> $refs;
    final /* synthetic */ List<sd.j> $s1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoPool$scanCleanIps$1$1$1(h hVar, String str, List<ArgoPool.Item> list, w wVar, List<sd.j> list2, wd.d dVar) {
        super(2, dVar);
        this.$gate1 = hVar;
        this.$ip = str;
        this.$refs = list;
        this.$done = wVar;
        this.$s1 = list2;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoPool$scanCleanIps$1$1$1(this.$gate1, this.$ip, this.$refs, this.$done, this.$s1, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        String str;
        List<ArgoPool.Item> list;
        h hVar;
        w wVar;
        List<sd.j> list2;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            m.b(obj);
            h hVar2 = this.$gate1;
            str = this.$ip;
            list = this.$refs;
            w wVar2 = this.$done;
            List<sd.j> list3 = this.$s1;
            this.L$0 = hVar2;
            this.L$1 = str;
            this.L$2 = list;
            this.L$3 = wVar2;
            this.L$4 = list3;
            this.label = 1;
            l lVar = (l) hVar2;
            if (lVar.a(this) == aVar) {
                return aVar;
            }
            hVar = lVar;
            wVar = wVar2;
            list2 = list3;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) this.L$4;
            wVar = (w) this.L$3;
            list = (List) this.L$2;
            str = (String) this.L$1;
            h hVar3 = (h) this.L$0;
            m.b(obj);
            hVar = hVar3;
        }
        String str2 = str;
        try {
            if (!ArgoPool.scanCancel) {
                ArgoPool argoPool = ArgoPool.INSTANCE;
                Long lTlsPing$default = ArgoPool.tlsPing$default(argoPool, str2, list.get(0).getHost(), 0, 4, null);
                if (lTlsPing$default != null) {
                    list2.add(new sd.j(str2, new Long(lTlsPing$default.longValue())));
                }
                synchronized (argoPool) {
                    wVar.element++;
                }
                ArgoPool.IpScan ipScan = argoPool.getIpScan();
                ArgoPool.ipScan = ipScan != null ? ArgoPool.IpScan.copy$default(ipScan, false, null, wVar.element, 0, null, null, null, null, 0L, 507, null) : null;
                argoPool.changed();
            }
            ((l) hVar).c();
            return u.f67154a;
        } catch (Throwable th2) {
            ((l) hVar).c();
            throw th2;
        }
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoPool$scanCleanIps$1$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
