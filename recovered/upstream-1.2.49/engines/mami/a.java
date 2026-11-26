package com.mlmvpn.scanner.engines.mami;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11594a;

    public /* synthetic */ a(int i) {
        this.f11594a = i;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f11594a) {
            case 0:
                return MamiApi.networkOf$lambda$0();
            case 1:
                return MamiEngine.init$lambda$3();
            case 2:
                return MamiEngine.init$lambda$4();
            case 3:
                return MamiEnvelope.p256_delegate$lambda$4();
            default:
                return MamiNet.base_delegate$lambda$0();
        }
    }
}
