package com.mlmvpn.scanner.ui.mami;

import androidx.compose.runtime.o;
import com.mlmvpn.scanner.ui.npv.NpvScreenKt;
import com.mlmvpn.scanner.ui.outline.OutlineScreenKt;
import com.mlmvpn.scanner.ui.outline.OutlineServersPageKt;
import com.mlmvpn.scanner.ui.proton.ProtonScreenKt;
import com.mlmvpn.scanner.ui.sanction.AntiSanctionScreenKt;
import com.mlmvpn.scanner.ui.store.StoreScreenKt;
import com.mlmvpn.scanner.ui.sublink.SubLinkDetailScreenKt;
import com.mlmvpn.scanner.ui.tgproxy.TgProxyScreenKt;
import com.mlmvpn.scanner.ui.urnetwork.UrnetworkUiKt;
import com.mlmvpn.scanner.ui.widgetstudio.WidgetStudioScreenKt;
import com.mlmvpn.scanner.ui.windscribe.WindscribeScreenKt;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ee.a f15485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15486c;

    public /* synthetic */ b(int i, int i10, ee.a aVar) {
        this.f15484a = i10;
        this.f15485b = aVar;
        this.f15486c = i;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f15484a;
        o oVar = (o) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                return MamiScreenKt.MamiScreen$lambda$19(this.f15485b, this.f15486c, oVar, iIntValue);
            case 1:
                return MamiScreenKt.MamiDevice$lambda$98(this.f15485b, this.f15486c, oVar, iIntValue);
            case 2:
                return MamiScreenKt.MamiServers$lambda$83(this.f15485b, this.f15486c, oVar, iIntValue);
            case 3:
                return MamiScreenKt.MamiLogs$lambda$100(this.f15485b, this.f15486c, oVar, iIntValue);
            case 4:
                return MamiScreenKt.MamiScreen$lambda$4(this.f15485b, this.f15486c, oVar, iIntValue);
            case 5:
                return NpvScreenKt.NpvScreen$lambda$40(this.f15485b, this.f15486c, oVar, iIntValue);
            case 6:
                return OutlineScreenKt.OutlineScreen$lambda$5(this.f15485b, this.f15486c, oVar, iIntValue);
            case 7:
                return OutlineScreenKt.OutlineScreen$lambda$70(this.f15485b, this.f15486c, oVar, iIntValue);
            case 8:
                return OutlineScreenKt.SourcesPage$lambda$111(this.f15485b, this.f15486c, oVar, iIntValue);
            case 9:
                return OutlineServersPageKt.PickRow$lambda$95(this.f15485b, this.f15486c, oVar, iIntValue);
            case 10:
                return ProtonScreenKt.ProtonScreen$lambda$4(this.f15485b, this.f15486c, oVar, iIntValue);
            case 11:
                return ProtonScreenKt.ProtonScreen$lambda$25(this.f15485b, this.f15486c, oVar, iIntValue);
            case 12:
                return AntiSanctionScreenKt.AntiSanctionScreen$lambda$57(this.f15485b, this.f15486c, oVar, iIntValue);
            case 13:
                return AntiSanctionScreenKt.AntiSanctionScreen$lambda$58(this.f15485b, this.f15486c, oVar, iIntValue);
            case 14:
                return AntiSanctionScreenKt.AntiSanctionScreen$lambda$50(this.f15485b, this.f15486c, oVar, iIntValue);
            case 15:
                return StoreScreenKt.StoreScreen$lambda$26(this.f15485b, this.f15486c, oVar, iIntValue);
            case 16:
                return SubLinkDetailScreenKt.SubLinkHelpScreen$lambda$25(this.f15485b, this.f15486c, oVar, iIntValue);
            case 17:
                return TgProxyScreenKt.TgProxyScreen$lambda$1(this.f15485b, this.f15486c, oVar, iIntValue);
            case 18:
                return TgProxyScreenKt.TgProxyScreen$lambda$12(this.f15485b, this.f15486c, oVar, iIntValue);
            case 19:
                return UrnetworkUiKt.UrnetworkUsageCard$lambda$81(this.f15485b, this.f15486c, oVar, iIntValue);
            case 20:
                return WidgetStudioScreenKt.WidgetStudioScreen$lambda$102(this.f15485b, this.f15486c, oVar, iIntValue);
            default:
                return WindscribeScreenKt.WindscribeScreen$lambda$51(this.f15485b, this.f15486c, oVar, iIntValue);
        }
    }
}
