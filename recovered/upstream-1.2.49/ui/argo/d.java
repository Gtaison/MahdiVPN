package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.ui.emergency.DialState;
import com.mlmvpn.scanner.ui.emergency.EmergencyKitKt;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f12655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f12658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f12659f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f12660h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f12661n;

    public /* synthetic */ d(Object obj, long j, String str, String str2, Object obj2, int i, int i10, int i11) {
        this.f12654a = i11;
        this.f12660h = obj;
        this.f12655b = j;
        this.f12656c = str;
        this.f12657d = str2;
        this.f12661n = obj2;
        this.f12658e = i;
        this.f12659f = i10;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12654a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ArgoScreenKt.Callout_8V94_ZQ$lambda$78((androidx.compose.ui.graphics.vector.f) this.f12660h, this.f12655b, this.f12656c, this.f12657d, (ee.a) this.f12661n, this.f12658e, this.f12659f, (androidx.compose.runtime.o) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return EmergencyKitKt.EmergencyStatusLine_8V94_ZQ$lambda$7((DialState) this.f12660h, this.f12655b, this.f12656c, this.f12657d, (androidx.compose.ui.t) this.f12661n, this.f12658e, this.f12659f, (androidx.compose.runtime.o) obj, iIntValue2);
        }
    }
}
