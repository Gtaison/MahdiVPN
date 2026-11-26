package com.mlmvpn.scanner.ui.argo;

import androidx.compose.foundation.layout.d0;
import com.mlmvpn.scanner.data.studio.StudioStore;
import com.mlmvpn.scanner.data.studio.domain.StudioNode;
import com.mlmvpn.scanner.engines.cfnet.CfNetManager;
import com.mlmvpn.scanner.engines.game.booster.model.GameProfile;
import com.mlmvpn.scanner.engines.game.booster.session.BoostOutcome;
import com.mlmvpn.scanner.engines.game.booster.session.LastSession;
import com.mlmvpn.scanner.engines.mae.MaeEngine;
import com.mlmvpn.scanner.engines.npv.NpvEngine;
import com.mlmvpn.scanner.engines.tgproxy.TgProgress;
import com.mlmvpn.scanner.engines.tgproxy.TgProxyManager;
import com.mlmvpn.scanner.engines.windscribe.WsConnection;
import com.mlmvpn.scanner.lan.LanStatus;
import com.mlmvpn.scanner.ui.configstudio.StudioAnalyticsScreenKt;
import com.mlmvpn.scanner.ui.configstudio.StudioBulkAddScreenKt;
import com.mlmvpn.scanner.ui.configstudio.StudioNodesScreenKt;
import com.mlmvpn.scanner.ui.doctor.CloudDoctorScreenKt;
import com.mlmvpn.scanner.ui.emergency.GstSetupWizardKt;
import com.mlmvpn.scanner.ui.game.GameBoostScreenKt;
import com.mlmvpn.scanner.ui.lan.LanScreenKt;
import com.mlmvpn.scanner.ui.mae.MaePagesKt;
import com.mlmvpn.scanner.ui.mae.MaeScreenKt;
import com.mlmvpn.scanner.ui.npv.NpvScreenKt;
import com.mlmvpn.scanner.ui.npv.NpvSourcesPageKt;
import com.mlmvpn.scanner.ui.outline.OutlineServersPageKt;
import com.mlmvpn.scanner.ui.scout.ScoutScreenKt;
import com.mlmvpn.scanner.ui.settings.SoftwareUpdateScreenKt;
import com.mlmvpn.scanner.ui.sublink.SubLinkScreenKt;
import com.mlmvpn.scanner.ui.tgproxy.TgProxyScreenKt;
import com.mlmvpn.scanner.ui.tunnel.Transport;
import com.mlmvpn.scanner.ui.tunnel.WarpIdentityCardKt;
import com.mlmvpn.scanner.ui.windscribe.WindscribeScreenKt;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements ee.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f12648e;

    public /* synthetic */ b(Object obj, ee.c cVar, ee.a aVar, int i, int i10) {
        this.f12644a = i10;
        this.f12647d = obj;
        this.f12645b = cVar;
        this.f12648e = aVar;
        this.f12646c = i;
    }

    @Override // ee.e
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12644a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ArgoScreenKt.ArgoList$lambda$118((ee.c) this.f12645b, (String) this.f12648e, (ee.c) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return StudioAnalyticsScreenKt.SliceGroup$lambda$48((d0) this.f12647d, (List) this.f12648e, (ee.c) this.f12645b, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue2);
            case 2:
                int iIntValue3 = ((Integer) obj2).intValue();
                return StudioBulkAddScreenKt.StudioBulkAddScreen$lambda$16((StudioStore) this.f12645b, (ee.a) this.f12647d, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue3);
            case 3:
                int iIntValue4 = ((Integer) obj2).intValue();
                return StudioNodesScreenKt.NodeRow$lambda$10((StudioNode) this.f12645b, (String) this.f12648e, (ee.a) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue4);
            case 4:
                int iIntValue5 = ((Integer) obj2).intValue();
                return CloudDoctorScreenKt.DeveloperSection$lambda$156((CfNetManager) this.f12645b, (List) this.f12647d, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue5);
            case 5:
                int iIntValue6 = ((Integer) obj2).intValue();
                return GstSetupWizardKt.StepDeploymentId$lambda$36((String) this.f12648e, (String) this.f12647d, (ee.c) this.f12645b, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue6);
            case 6:
                int iIntValue7 = ((Integer) obj2).intValue();
                return GameBoostScreenKt.LastSessionCard$lambda$132((String) this.f12648e, (LastSession.Summary) this.f12645b, (ee.a) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue7);
            case 7:
                int iIntValue8 = ((Integer) obj2).intValue();
                return GameBoostScreenKt.RegionPickerPage$lambda$171((GameProfile) this.f12647d, (ee.c) this.f12645b, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue8);
            case 8:
                int iIntValue9 = ((Integer) obj2).intValue();
                return GameBoostScreenKt.ActionsRow$lambda$158((BoostOutcome) this.f12645b, (ee.a) this.f12647d, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue9);
            case 9:
                int iIntValue10 = ((Integer) obj2).intValue();
                return LanScreenKt.ClientsSection$lambda$86((LanStatus) this.f12647d, (Set) this.f12648e, (ee.c) this.f12645b, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue10);
            case 10:
                int iIntValue11 = ((Integer) obj2).intValue();
                return MaePagesKt.SetupRow$lambda$106((String) this.f12648e, (String) this.f12645b, (ee.a) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue11);
            case 11:
                int iIntValue12 = ((Integer) obj2).intValue();
                return MaePagesKt.MaeOnboarding$lambda$22((ee.a) this.f12645b, (ee.e) this.f12647d, (ee.e) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue12);
            case 12:
                int iIntValue13 = ((Integer) obj2).intValue();
                return MaeScreenKt.SymptomDialog$lambda$135((MaeEngine.Ask) this.f12647d, (ee.c) this.f12645b, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue13);
            case 13:
                int iIntValue14 = ((Integer) obj2).intValue();
                return NpvScreenKt.Stat$lambda$93((String) this.f12648e, (String) this.f12645b, (androidx.compose.ui.t) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue14);
            case 14:
                int iIntValue15 = ((Integer) obj2).intValue();
                return NpvSourcesPageKt.ChannelRow$lambda$64((String) this.f12648e, (NpvEngine.ChannelState) this.f12645b, (ee.a) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue15);
            case 15:
                int iIntValue16 = ((Integer) obj2).intValue();
                return OutlineServersPageKt.Segmented$lambda$85((List) this.f12647d, this.f12648e, (ee.c) this.f12645b, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue16);
            case 16:
                int iIntValue17 = ((Integer) obj2).intValue();
                return ScoutScreenKt.ScoutDialog$lambda$55((String) this.f12648e, (ee.a) this.f12645b, (ee.f) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue17);
            case 17:
                int iIntValue18 = ((Integer) obj2).intValue();
                return SoftwareUpdateScreenKt.SoftwareUpdateScreen$lambda$6((ee.a) this.f12645b, (String) this.f12648e, (ee.a) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue18);
            case 18:
                int iIntValue19 = ((Integer) obj2).intValue();
                return SubLinkScreenKt.StateBlock$lambda$84((ee.e) this.f12645b, (String) this.f12648e, (String) this.f12647d, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue19);
            case 19:
                int iIntValue20 = ((Integer) obj2).intValue();
                return TgProxyScreenKt.ProgressCard$lambda$89((TgProgress) this.f12645b, (TgProxyManager) this.f12647d, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue20);
            case 20:
                int iIntValue21 = ((Integer) obj2).intValue();
                return WarpIdentityCardKt.WarpIdentitySection$lambda$20((d0) this.f12645b, (Transport) this.f12647d, this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue21);
            default:
                int iIntValue22 = ((Integer) obj2).intValue();
                return WindscribeScreenKt.TestProgress$lambda$67((WsConnection) this.f12645b, (List) this.f12647d, (ee.a) this.f12648e, this.f12646c, (androidx.compose.runtime.o) obj, iIntValue22);
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, ee.c cVar, int i, int i10) {
        this.f12644a = i10;
        this.f12647d = obj;
        this.f12648e = obj2;
        this.f12645b = cVar;
        this.f12646c = i;
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i, int i10) {
        this.f12644a = i10;
        this.f12645b = obj;
        this.f12647d = obj2;
        this.f12648e = obj3;
        this.f12646c = i;
    }

    public /* synthetic */ b(Object obj, String str, Object obj2, int i, int i10) {
        this.f12644a = i10;
        this.f12645b = obj;
        this.f12648e = str;
        this.f12647d = obj2;
        this.f12646c = i;
    }

    public /* synthetic */ b(String str, Object obj, Object obj2, int i, int i10) {
        this.f12644a = i10;
        this.f12648e = str;
        this.f12645b = obj;
        this.f12647d = obj2;
        this.f12646c = i;
    }

    public /* synthetic */ b(String str, String str2, int i, ee.c cVar) {
        this.f12644a = 5;
        this.f12648e = str;
        this.f12647d = str2;
        this.f12645b = cVar;
        this.f12646c = i;
    }
}
