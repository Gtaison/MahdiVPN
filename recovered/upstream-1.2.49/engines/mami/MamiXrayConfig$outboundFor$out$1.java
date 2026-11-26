package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class MamiXrayConfig$outboundFor$out$1 extends kotlin.jvm.internal.h implements ee.e {
    public MamiXrayConfig$outboundFor$out$1(Object obj) {
        super(2, obj, MamiXrayConfig.class, "trojan", "trojan(Lcom/mlmvpn/scanner/engines/mami/MamiCatalog$Server;Ljava/lang/String;)Lorg/json/JSONObject;", 0);
    }

    @Override // ee.e
    public final sf.c invoke(MamiCatalog.Server p10, String p11) {
        j.e(p10, "p0");
        j.e(p11, "p1");
        return ((MamiXrayConfig) this.receiver).trojan(p10, p11);
    }
}
