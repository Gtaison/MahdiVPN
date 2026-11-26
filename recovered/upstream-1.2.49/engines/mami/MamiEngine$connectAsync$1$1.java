package com.mlmvpn.scanner.engines.mami;

import android.content.Context;
import android.util.Log;
import com.mlmvpn.scanner.utils.NetworkSettings;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.i0;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$connectAsync$1$1", f = "MamiEngine.kt", l = {488}, m = "invokeSuspend")
public final class MamiEngine$connectAsync$1$1 extends j implements ee.e {
    final /* synthetic */ List<String> $exclude;
    final /* synthetic */ String $serverId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiEngine$connectAsync$1$1(String str, List<String> list, wd.d dVar) {
        super(2, dVar);
        this.$serverId = str;
        this.$exclude = list;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiEngine$connectAsync$1$1(this.$serverId, this.$exclude, dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        try {
            if (i == 0) {
                m.b(obj);
                MamiEngine mamiEngine = MamiEngine.INSTANCE;
                MamiEngine.Prefs prefs = mamiEngine.prefs();
                NetworkSettings networkSettings = NetworkSettings.INSTANCE;
                Context context = MamiEngine.app;
                if (context == null) {
                    kotlin.jvm.internal.j.k("app");
                    throw null;
                }
                MamiEngine.Mode mode = networkSettings.proxyMode(context) ? MamiEngine.Mode.PROXY : MamiEngine.Mode.TUNNEL;
                String method = prefs.getMethod();
                String str = this.$serverId;
                String location = kotlin.jvm.internal.j.a(prefs.getMethod(), "auto") ? prefs.getLocation() : "";
                List<String> list = this.$exclude;
                this.label = 1;
                if (mamiEngine.connect(method, mode, str, location, list, this) == aVar) {
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
            Log.w("MAMI", "connect crashed", th2);
        }
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$connectAsync$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
