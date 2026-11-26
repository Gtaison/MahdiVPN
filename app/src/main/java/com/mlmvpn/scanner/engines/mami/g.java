package com.mlmvpn.scanner.engines.mami;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f11601b;

    public /* synthetic */ g(int i, Serializable serializable) {
        this.f11600a = i;
        this.f11601b = serializable;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f11600a) {
            case 0:
                return MamiEngine.C06181.invokeSuspend$lambda$0((Throwable) this.f11601b, (MamiEngine.Status) obj);
            default:
                return MamiEngine.connectExclusive$lambda$69((String) this.f11601b, (MamiEngine.Status) obj);
        }
    }
}
