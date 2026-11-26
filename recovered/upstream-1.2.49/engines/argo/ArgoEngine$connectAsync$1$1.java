package com.mlmvpn.scanner.engines.argo;

import android.util.Log;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.k0;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoEngine$connectAsync$1$1", f = "ArgoEngine.kt", l = {109}, m = "invokeSuspend")
public final class ArgoEngine$connectAsync$1$1 extends j implements ee.e {
    final /* synthetic */ String $id;
    final /* synthetic */ ArgoEngine.Mode $m;
    final /* synthetic */ String $raw;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgoEngine$connectAsync$1$1(String str, String str2, ArgoEngine.Mode mode, wd.d dVar) {
        super(2, dVar);
        this.$id = str;
        this.$raw = str2;
        this.$m = mode;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new ArgoEngine$connectAsync$1$1(this.$id, this.$raw, this.$m, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        try {
            if (i == 0) {
                m.b(obj);
                ArgoEngine argoEngine = ArgoEngine.INSTANCE;
                String str = this.$id;
                String str2 = this.$raw;
                ArgoEngine.Mode mode = this.$m;
                this.label = 1;
                if (argoEngine.connect(str, str2, mode, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m.b(obj);
            }
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th2) {
            Log.w("ARGO", "connect crashed", th2);
            if (ArgoEngine.wantConnected) {
                k0 k0Var = ArgoEngine._conn;
                String message = th2.getMessage();
                if (message == null) {
                    message = "وصل نشد";
                }
                ArgoEngine.Conn.Failed failed = new ArgoEngine.Conn.Failed(message);
                g1 g1Var = (g1) k0Var;
                g1Var.getClass();
                g1Var.k(null, failed);
                ArgoEngine.wantConnected = false;
            }
        }
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((ArgoEngine$connectAsync$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
