package com.mlmvpn.scanner.engines.argo;

import com.mlmvpn.scanner.engines.proton.ProtonStealth;
import com.mlmvpn.scanner.ui.settings.SettingsSpotlight;
import java.util.List;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.sync.h;
import kotlinx.coroutines.sync.l;
import sd.m;
import sd.q;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$scanCleanIps$1$2$1", f = "ArgoPool.kt", l = {955}, m = "invokeSuspend")
public final class ArgoPool$scanCleanIps$1$2$1 extends j implements ee.e {
    final /* synthetic */ w $done;
    final /* synthetic */ h $gate2;
    final /* synthetic */ String $ip;
    final /* synthetic */ List<ArgoPool.Item> $refs;
    final /* synthetic */ List<q> $s2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoPool$scanCleanIps$1$2$1(h hVar, List<ArgoPool.Item> list, String str, List<q> list2, w wVar, wd.d dVar) {
        super(2, dVar);
        this.$gate2 = hVar;
        this.$refs = list;
        this.$ip = str;
        this.$s2 = list2;
        this.$done = wVar;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoPool$scanCleanIps$1$2$1(this.$gate2, this.$refs, this.$ip, this.$s2, this.$done, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        List<ArgoPool.Item> list;
        String str;
        h hVar;
        List<q> list2;
        w wVar;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        boolean z10 = true;
        if (i == 0) {
            m.b(obj);
            h hVar2 = this.$gate2;
            list = this.$refs;
            str = this.$ip;
            List<q> list3 = this.$s2;
            w wVar2 = this.$done;
            this.L$0 = hVar2;
            this.L$1 = list;
            this.L$2 = str;
            this.L$3 = list3;
            this.L$4 = wVar2;
            this.label = 1;
            l lVar = (l) hVar2;
            if (lVar.a(this) == aVar) {
                return aVar;
            }
            hVar = lVar;
            list2 = list3;
            wVar = wVar2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            wVar = (w) this.L$4;
            list2 = (List) this.L$3;
            str = (String) this.L$2;
            list = (List) this.L$1;
            h hVar3 = (h) this.L$0;
            m.b(obj);
            hVar = hVar3;
        }
        String str2 = str;
        try {
            if (!ArgoPool.scanCancel) {
                for (ArgoPool.Item item : list) {
                    kotlin.jvm.internal.j.d(item, "next(...)");
                    ArgoPool.Item item2 = item;
                    boolean z11 = z10;
                    ArgoNet.Auth authAuthenticate = ArgoNet.INSTANCE.authenticate(item2.getHost(), (32 & 2) != 0 ? ProtonStealth.PORT : item2.getPort(), (32 & 4) != 0 ? "" : str2, (32 & 8) != 0 ? "A" : "A", (32 & 16) != 0 ? 12000L : SettingsSpotlight.FRESH_MS, (32 & 32) != 0 ? 0L : 0L);
                    if (authAuthenticate.getOk() && authAuthenticate.getInfo() != null) {
                        list2.add(new q(str2, new Long(authAuthenticate.getMs()), new sd.j(item2, authAuthenticate.getInfo())));
                        break;
                    }
                    z10 = z11;
                }
                ArgoPool argoPool = ArgoPool.INSTANCE;
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
        return ((ArgoPool$scanCleanIps$1$2$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
