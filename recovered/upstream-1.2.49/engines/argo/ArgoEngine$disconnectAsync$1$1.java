package com.mlmvpn.scanner.engines.argo;

import android.content.Context;
import com.mlmvpn.scanner.utils.LocalPort;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$disconnectAsync$1$1", f = "ArgoEngine.kt", l = {}, m = "invokeSuspend")
public final class ArgoEngine$disconnectAsync$1$1 extends j implements ee.e {
    final /* synthetic */ ArgoEngine.Live $was;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoEngine$disconnectAsync$1$1(ArgoEngine.Live live, wd.d dVar) {
        super(2, dVar);
        this.$was = live;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoEngine$disconnectAsync$1$1(this.$was, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.b(obj);
        try {
            if (this.$was != null && ArgoEngine.INSTANCE.isOurs()) {
                ArgoNet argoNet = ArgoNet.INSTANCE;
                String host = this.$was.getEp().getHost();
                int port = this.$was.getEp().getPort();
                ArgoProtocol.SessionInfo info = this.$was.getInfo();
                LocalPort localPort = LocalPort.INSTANCE;
                Context context = ArgoEngine.app;
                if (context == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                argoNet.sessionRequest("disconnect", host, port, info, localPort.get(context) + LocalPort.PROBE_OFFSET, 6000L);
            }
            ArgoEngine argoEngine = ArgoEngine.INSTANCE;
            argoEngine.stopService();
            argoEngine.log("آرگو قطع شد.");
            if (((g1) ArgoEngine._conn).getValue() instanceof ArgoEngine.Conn.Stopping) {
                ((g1) ArgoEngine._conn).j(ArgoEngine.Conn.Idle.INSTANCE);
            }
            return u.f67154a;
        } catch (Throwable th2) {
            if (!(((g1) ArgoEngine._conn).getValue() instanceof ArgoEngine.Conn.Stopping)) {
                throw th2;
            }
            ((g1) ArgoEngine._conn).j(ArgoEngine.Conn.Idle.INSTANCE);
            throw th2;
        }
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoEngine$disconnectAsync$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
