package com.mlmvpn.scanner.engines.argo;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11219a;

    public /* synthetic */ f(int i) {
        this.f11219a = i;
    }

    @Override // ee.a
    public final Object invoke() {
        boolean zAccess$getUpdateCancel$p;
        switch (this.f11219a) {
            case 0:
                zAccess$getUpdateCancel$p = ArgoPool.access$getUpdateCancel$p();
                break;
            case 1:
                zAccess$getUpdateCancel$p = ArgoPool.access$getUpdateCancel$p();
                break;
            case 2:
                return ArgoNet.base_delegate$lambda$0();
            case 3:
                return ArgoProtocol.RSA_KEY_delegate$lambda$0();
            default:
                return ArgoProtocol.MAC_KEY_delegate$lambda$1();
        }
        return Boolean.valueOf(zAccess$getUpdateCancel$p);
    }
}
