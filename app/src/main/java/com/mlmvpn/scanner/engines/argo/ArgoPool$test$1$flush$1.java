package com.mlmvpn.scanner.engines.argo;

import org.telegram.tgnet.TLObject;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.argo.ArgoPool$test$1", f = "ArgoPool.kt", l = {956, 650}, m = "invokeSuspend$flush")
public final class ArgoPool$test$1$flush$1 extends xd.c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    public ArgoPool$test$1$flush$1(wd.d dVar) {
        super(dVar);
    }

    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= TLObject.FLAG_31;
        return ArgoPool.C04021.invokeSuspend$flush(null, null, null, null, null, null, null, this);
    }
}
