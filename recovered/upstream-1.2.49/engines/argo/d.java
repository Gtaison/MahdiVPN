package com.mlmvpn.scanner.engines.argo;

import java.util.Map;
import kotlin.text.g;
import sd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ee.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11217a;

    public /* synthetic */ d(int i) {
        this.f11217a = i;
    }

    @Override // ee.c
    public final Object invoke(Object obj) {
        switch (this.f11217a) {
            case 0:
                return Boolean.valueOf(ArgoPool.C03991.invokeSuspend$lambda$2((String) obj));
            case 1:
                return ArgoPool.rows$lambda$118((ArgoPool.Item) obj);
            case 2:
                return ArgoPool.decodeHtml$lambda$42((g) obj);
            case 3:
                return ArgoPool.harvestTelegram$lambda$47((String) obj);
            case 4:
                return ArgoPool.rows$lambda$119((ArgoPool.Item) obj);
            case 5:
                return ArgoPool.rows$lambda$120((ArgoPool.Item) obj);
            case 6:
                return ArgoPool.summary$lambda$104((ArgoPool.Group) obj);
            case 7:
                return ArgoPool.summary$lambda$105((ArgoPool.Group) obj);
            case 8:
                return ArgoPool.summary$lambda$106((ArgoPool.Group) obj);
            case 9:
                return ArgoPool.summary$lambda$110((ArgoProtocol.FalconOrigin) obj);
            case 10:
                return ArgoPool.summary$lambda$111((ArgoProtocol.FalconOrigin) obj);
            case 11:
                return Boolean.valueOf(ArgoPool.load$lambda$20((Map.Entry) obj));
            case 12:
                return ArgoProtocol.json$lambda$7((j) obj);
            default:
                return ArgoProtocol.extractBridgeBlocks$lambda$16((g) obj);
        }
    }
}
