package com.mlmvpn.scanner.engines.mami;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11599a;

    public /* synthetic */ f(int i) {
        this.f11599a = i;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f11599a) {
            case 0:
                return MamiEngine.C06171.invokeSuspend$lambda$0((MamiEngine.Status) obj);
            case 1:
                return MamiEngine.C06211.invokeSuspend$lambda$0((MamiEngine.Status) obj);
            case 2:
                return MamiEngine.C06211.invokeSuspend$lambda$2((MamiEngine.Status) obj);
            case 3:
                return MamiApi.logFn$lambda$1((String) obj);
            case 4:
                return MamiApi.discoverHost$lambda$13$lambda$10((DeadDropResult) obj);
            case 5:
                return Boolean.valueOf(MamiCatalog.SHORT_ID_OK$lambda$23((String) obj));
            case 6:
                return MamiEngine.tryServers$lambda$72((MamiEngine.Status) obj);
            case 7:
                return MamiEngine.tryServers$lambda$73((MamiEngine.Status) obj);
            case 8:
                return MamiEngine.connectCatalog$lambda$44((MamiEngine.Status) obj);
            case 9:
                return MamiEngine.connectCatalog$lambda$45((MamiEngine.Status) obj);
            case 10:
                return MamiEngine.connectCatalog$lambda$51((MamiEngine.Status) obj);
            case 11:
                return MamiEngine.init$lambda$2((String) obj);
            case 12:
                return MamiEngine.connectFront$lambda$74((MamiEngine.Status) obj);
            case 13:
                return MamiEngine.connectHive$lambda$58((MamiEngine.Status) obj);
            case 14:
                return MamiEngine.connectFront$lambda$77((MamiEngine.Status) obj);
            case 15:
                return MamiEngine.connectFront$lambda$78((MamiEngine.Status) obj);
            case 16:
                return MamiEngine.connectExclusive$lambda$67((MamiEngine.Status) obj);
            case 17:
                return MamiEngine.connectExclusive$lambda$68((MamiEngine.Status) obj);
            case 18:
                return MamiEngine.connectHive$lambda$59((MamiEngine.Status) obj);
            case 19:
                return MamiEngine.connectHive$lambda$63((MamiEngine.Status) obj);
            case 20:
                return MamiEngine.disconnectNow$lambda$82((MamiEngine.Status) obj);
            case 21:
                return MamiEngine.parsedHive$lambda$23((MamiCatalog.Skipped) obj);
            case 22:
                return MamiEngine.parsedSaved$lambda$20((MamiCatalog.Skipped) obj);
            case 23:
                return MamiEngine.clearError$lambda$88((MamiEngine.Status) obj);
            default:
                return MamiEngine.tryServers$lambda$71((MamiEngine.Status) obj);
        }
    }
}
