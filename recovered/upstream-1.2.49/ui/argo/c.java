package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.ui.emergency.GstSetupWizardKt;
import com.mlmvpn.scanner.ui.game.GameBoostScreenKt;
import com.mlmvpn.scanner.ui.proton.ProtonScreenKt;
import com.mlmvpn.scanner.ui.settings.SmartIranPageKt;
import com.mlmvpn.scanner.ui.tunnel.PsiphonPagesKt;
import com.mlmvpn.scanner.ui.widgetstudio.WidgetStudioScreenKt;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ee.c f12651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ee.a f12652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f12653e;

    public /* synthetic */ c(ee.a aVar, ee.c cVar, String str, int i) {
        this.f12649a = 0;
        this.f12652d = aVar;
        this.f12651c = cVar;
        this.f12650b = str;
        this.f12653e = i;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12649a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ArgoScreenKt.ArgoMain$lambda$58(this.f12652d, this.f12651c, this.f12650b, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                ee.a aVar = this.f12652d;
                ee.c cVar = this.f12651c;
                return GstSetupWizardKt.StepPassword$lambda$26(this.f12650b, cVar, aVar, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue2);
            case 2:
                int iIntValue3 = ((Integer) obj2).intValue();
                ee.a aVar2 = this.f12652d;
                ee.c cVar2 = this.f12651c;
                return GstSetupWizardKt.StepConfirmPassword$lambda$27(this.f12650b, cVar2, aVar2, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue3);
            case 3:
                int iIntValue4 = ((Integer) obj2).intValue();
                ee.a aVar3 = this.f12652d;
                ee.c cVar3 = this.f12651c;
                return GameBoostScreenKt.FeedbackCard$lambda$142(this.f12650b, cVar3, aVar3, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue4);
            case 4:
                int iIntValue5 = ((Integer) obj2).intValue();
                ee.a aVar4 = this.f12652d;
                ee.c cVar4 = this.f12651c;
                return ProtonScreenKt.ProtonWebPage$lambda$163(this.f12650b, aVar4, cVar4, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue5);
            case 5:
                int iIntValue6 = ((Integer) obj2).intValue();
                ee.a aVar5 = this.f12652d;
                ee.c cVar5 = this.f12651c;
                return SmartIranPageKt.SmartIranPage$lambda$22(this.f12650b, aVar5, cVar5, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue6);
            case 6:
                int iIntValue7 = ((Integer) obj2).intValue();
                ee.a aVar6 = this.f12652d;
                ee.c cVar6 = this.f12651c;
                return PsiphonPagesKt.PsiphonMethodScreen$lambda$38(aVar6, this.f12650b, cVar6, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue7);
            default:
                int iIntValue8 = ((Integer) obj2).intValue();
                ee.a aVar7 = this.f12652d;
                ee.c cVar7 = this.f12651c;
                return WidgetStudioScreenKt.MethodPicker$lambda$173(this.f12650b, cVar7, aVar7, this.f12653e, (androidx.compose.runtime.o) obj, iIntValue8);
        }
    }

    public /* synthetic */ c(ee.a aVar, String str, ee.c cVar, int i) {
        this.f12649a = 6;
        this.f12652d = aVar;
        this.f12650b = str;
        this.f12651c = cVar;
        this.f12653e = i;
    }

    public /* synthetic */ c(String str, ee.a aVar, ee.c cVar, int i, int i10) {
        this.f12649a = i10;
        this.f12650b = str;
        this.f12652d = aVar;
        this.f12651c = cVar;
        this.f12653e = i;
    }

    public /* synthetic */ c(String str, ee.c cVar, ee.a aVar, int i, int i10) {
        this.f12649a = i10;
        this.f12650b = str;
        this.f12651c = cVar;
        this.f12652d = aVar;
        this.f12653e = i;
    }
}
