package com.mlmvpn.scanner.engines.argo;

import android.content.Context;
import androidx.compose.runtime.i2;
import androidx.compose.runtime.k2;
import com.mlmvpn.scanner.engines.game.booster.model.GameProfile;
import com.mlmvpn.scanner.engines.scout.ScoutNet;
import com.mlmvpn.scanner.engines.spider.SpiderPanel;
import com.mlmvpn.scanner.engines.windscribe.WsMethod;
import com.mlmvpn.scanner.engines.windscribe.WsRepository;
import com.mlmvpn.scanner.gate.LockActivityKt;
import com.mlmvpn.scanner.gate.ReleaseChannel;
import com.mlmvpn.scanner.ui.game.GameBoostScreenKt;
import com.mlmvpn.scanner.ui.spider.SpiderScreenKt;
import com.mlmvpn.scanner.ui.widgetstudio.WidgetStudioScreenKt;
import com.mlmvpn.scanner.widget.studio.StudioConfigureActivityKt;
import com.mlmvpn.scanner.widget.studio.StudioSize;
import com.mlmvpn.scanner.widget.studio.WidgetTemplate;
import java.net.Socket;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ee.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f11214e;

    public /* synthetic */ a(WsRepository wsRepository, String str, WsMethod wsMethod, String str2) {
        this.f11210a = 4;
        this.f11213d = wsRepository;
        this.f11211b = str;
        this.f11214e = wsMethod;
        this.f11212c = str2;
    }

    @Override // ee.a
    public final Object invoke() {
        switch (this.f11210a) {
            case 0:
                return ArgoEngine.connectAsync$lambda$1((Context) this.f11213d, (ArgoEngine.Mode) this.f11214e, (String) this.f11211b, (String) this.f11212c);
            case 1:
                return ScoutNet.http$lambda$13$lambda$12$lambda$11((ScoutNet) this.f11213d, (Socket) this.f11214e, (String) this.f11211b, (String) this.f11212c);
            case 2:
                return WsRepository.putSecret$lambda$4((WsRepository) this.f11213d, (String) this.f11211b, (String) this.f11212c, (String) this.f11214e);
            case 3:
                return WsRepository.saveMeasurements$lambda$33((WsRepository) this.f11213d, (String) this.f11211b, (String) this.f11212c, (List) this.f11214e);
            case 4:
                return WsRepository.remember$lambda$21((WsRepository) this.f11213d, (String) this.f11211b, (WsMethod) this.f11214e, (String) this.f11212c);
            case 5:
                return LockActivityKt.UpdateBody$lambda$24$lambda$23((Context) this.f11213d, (ReleaseChannel.Offer) this.f11214e, (k2) this.f11211b, (i2) this.f11212c);
            case 6:
                return GameBoostScreenKt.GameBoostScreen$lambda$91$lambda$90((GameProfile) this.f11213d, (k2) this.f11214e, (ee.e) this.f11211b, (k2) this.f11212c);
            case 7:
                return SpiderScreenKt.SpiderScreen$lambda$61$lambda$50$lambda$49$lambda$48((Context) this.f11213d, (SpiderPanel.Install) this.f11214e, (SpiderPanel.User) this.f11211b, (k2) this.f11212c);
            case 8:
                return WidgetStudioScreenKt.WidgetStudioScreen$lambda$75$lambda$63$lambda$62((Context) this.f11213d, (k2) this.f11214e, (k2) this.f11211b, (k2) this.f11212c);
            default:
                return StudioConfigureActivityKt.ConfigureScreen$lambda$29$lambda$25$lambda$24$lambda$23$lambda$22((ee.c) this.f11213d, (WidgetTemplate) this.f11214e, (StudioSize) this.f11211b, (k2) this.f11212c);
        }
    }

    public /* synthetic */ a(WsRepository wsRepository, String str, String str2, Object obj, int i) {
        this.f11210a = i;
        this.f11213d = wsRepository;
        this.f11211b = str;
        this.f11212c = str2;
        this.f11214e = obj;
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f11210a = i;
        this.f11213d = obj;
        this.f11214e = obj2;
        this.f11211b = obj3;
        this.f11212c = obj4;
    }
}
