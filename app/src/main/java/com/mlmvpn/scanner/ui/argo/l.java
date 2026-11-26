package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.engines.argo.ArgoPool;
import com.mlmvpn.scanner.ui.configstudio.design.StudioDesignKt;
import com.mlmvpn.scanner.ui.outline.OutlineServersPageKt;
import com.mlmvpn.scanner.ui.settings.IosAlertsKt;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12689a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f12692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f12693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f12694f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f12695h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ sd.a f12696n;

    public /* synthetic */ l(androidx.compose.ui.graphics.vector.f fVar, String str, String str2, String str3, ee.a aVar, int i, int i10) {
        this.f12693e = fVar;
        this.f12690b = str;
        this.f12694f = str2;
        this.f12695h = str3;
        this.f12696n = aVar;
        this.f12691c = i;
        this.f12692d = i10;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12689a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ArgoScreenKt.TestCard$lambda$73(this.f12690b, (ArgoPool.Job) this.f12693e, (ArgoPool.Job) this.f12694f, (ee.e) this.f12695h, (ee.c) this.f12696n, this.f12691c, this.f12692d, (androidx.compose.runtime.o) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return StudioDesignKt.EmptyState$lambda$24((androidx.compose.ui.graphics.vector.f) this.f12693e, this.f12690b, (String) this.f12694f, (String) this.f12695h, (ee.a) this.f12696n, this.f12691c, this.f12692d, (androidx.compose.runtime.o) obj, iIntValue2);
            case 2:
                int iIntValue3 = ((Integer) obj2).intValue();
                return OutlineServersPageKt.OutlineServersPage$lambda$73((ee.a) this.f12693e, (ee.c) this.f12696n, (ee.a) this.f12694f, (ee.a) this.f12695h, this.f12690b, this.f12691c, this.f12692d, (androidx.compose.runtime.o) obj, iIntValue3);
            default:
                int iIntValue4 = ((Integer) obj2).intValue();
                return IosAlertsKt.IosAlert$lambda$0(this.f12690b, (String) this.f12693e, (List) this.f12694f, (ee.a) this.f12696n, (ee.e) this.f12695h, this.f12691c, this.f12692d, (androidx.compose.runtime.o) obj, iIntValue4);
        }
    }

    public /* synthetic */ l(ee.a aVar, ee.c cVar, ee.a aVar2, ee.a aVar3, String str, int i, int i10) {
        this.f12693e = aVar;
        this.f12696n = cVar;
        this.f12694f = aVar2;
        this.f12695h = aVar3;
        this.f12690b = str;
        this.f12691c = i;
        this.f12692d = i10;
    }

    public /* synthetic */ l(String str, ArgoPool.Job job, ArgoPool.Job job2, ee.e eVar, ee.c cVar, int i, int i10) {
        this.f12690b = str;
        this.f12693e = job;
        this.f12694f = job2;
        this.f12695h = eVar;
        this.f12696n = cVar;
        this.f12691c = i;
        this.f12692d = i10;
    }

    public /* synthetic */ l(String str, String str2, List list, ee.a aVar, ee.e eVar, int i, int i10) {
        this.f12690b = str;
        this.f12693e = str2;
        this.f12694f = list;
        this.f12696n = aVar;
        this.f12695h = eVar;
        this.f12691c = i;
        this.f12692d = i10;
    }
}
