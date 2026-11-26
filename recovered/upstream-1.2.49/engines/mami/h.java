package com.mlmvpn.scanner.engines.mami;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MamiEngine.Exit f11603b;

    public /* synthetic */ h(MamiEngine.Exit exit, int i) {
        this.f11602a = i;
        this.f11603b = exit;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f11602a) {
            case 0:
                return MamiEngine.C06211.invokeSuspend$lambda$1(this.f11603b, (MamiEngine.Status) obj);
            default:
                return MamiEngine.connected$lambda$80(this.f11603b, (MamiEngine.Status) obj);
        }
    }
}
