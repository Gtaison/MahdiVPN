package com.mlmvpn.scanner.ui.argo;

import a6.w0;
import androidx.compose.material3.k9;
import androidx.compose.runtime.e2;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.v0;
import com.mlmvpn.scanner.engines.argo.ArgoPool;
import com.mlmvpn.scanner.engines.game.booster.brain.Brain;
import com.mlmvpn.scanner.engines.mami.MamiIdentity;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.settings.IosSettingsKt;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoScreenKt$ArgoList$2$8$1 implements ee.f {
    final /* synthetic */ k2 $err$delegate;
    final /* synthetic */ ArgoPool.Group $g;
    final /* synthetic */ String $kind;
    final /* synthetic */ int $n;
    final /* synthetic */ k2 $openCc$delegate;
    final /* synthetic */ RowCtx $rowCtx;
    final /* synthetic */ boolean $testing;
    final /* synthetic */ l4 $version$delegate;

    public ArgoScreenKt$ArgoList$2$8$1(ArgoPool.Group group, int i, boolean z10, String str, k2 k2Var, k2 k2Var2, l4 l4Var, RowCtx rowCtx) {
        this.$g = group;
        this.$n = i;
        this.$testing = z10;
        this.$kind = str;
        this.$openCc$delegate = k2Var;
        this.$err$delegate = k2Var2;
        this.$version$delegate = l4Var;
        this.$rowCtx = rowCtx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u invoke$lambda$4$lambda$3(SettingsGroupScope settingsGroupScope, String str, ArgoPool.Group group, k2 k2Var) {
        Object objM1004constructorimpl;
        sd.u uVar = sd.u.f67154a;
        try {
            ArgoPool.test$default(ArgoPool.INSTANCE, str, group.getCc(), null, false, false, false, 60, null);
            objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
        }
        Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
        String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
        if (message == null) {
            message = "";
        }
        ArgoScreenKt.ArgoList$lambda$103(k2Var, message);
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u invoke$lambda$6$lambda$5(ArgoPool.Group group, k2 k2Var) {
        ArgoScreenKt.ArgoList$lambda$96(k2Var, kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(k2Var), group.getCc()) ? null : group.getCc());
        return sd.u.f67154a;
    }

    @Override // ee.f
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
        return sd.u.f67154a;
    }

    public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
        String strN;
        String str;
        String str2;
        String strP;
        kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
        int i10 = (i & 6) == 0 ? i | ((i & 8) == 0 ? ((p0) oVar).f(SettingsGroup) : ((p0) oVar).h(SettingsGroup) ? 4 : 2) : i;
        if ((i10 & 19) == 18) {
            p0 p0Var = (p0) oVar;
            if (p0Var.G()) {
                p0Var.Y();
                return;
            }
        }
        r0 r0Var = v0.f3474a;
        final ArgoPool.Group group = this.$g;
        androidx.compose.runtime.internal.e eVarF = x6.p.f(oVar, 1365365732, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoList$2$8$1.1
            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                return sd.u.f67154a;
            }

            public final void invoke(androidx.compose.runtime.o oVar2, int i11) {
                if ((i11 & 3) == 2) {
                    p0 p0Var2 = (p0) oVar2;
                    if (p0Var2.G()) {
                        p0Var2.Y();
                        return;
                    }
                }
                r0 r0Var2 = v0.f3474a;
                String strFlag = ArgoScreenKt.flag(group.getCc());
                if (kotlin.text.o.L0(strFlag)) {
                    strFlag = "❔";
                }
                k9.b(strFlag, null, 0L, x6.a.t(18), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 131062);
            }
        });
        String strTr = kotlin.jvm.internal.j.a(this.$g.getCc(), "??") ? StoreNetKt.tr("سنجیده\u200cنشده\u200cها (کشورشان بعد از سنجش معلوم می\u200cشود)", "Untested (their country shows after a test)") : ArgoScreenKt.country(this.$g.getCc());
        String strFa = ArgoScreenKt.fa(this.$n);
        String str3 = "";
        String strN2 = this.$g.getAlive() > 0 ? w0.n(" · ", ArgoScreenKt.fa(this.$g.getAlive()), " سالم") : "";
        Long best = this.$g.getBest();
        if (best == null || (strN = w0.n(" · بهترین ", ArgoScreenKt.fa(best.longValue()), " ms")) == null) {
            strN = "";
        }
        String strM = f0.a.m(strFa, " مورد", strN2, strN);
        int i11 = this.$n;
        String strO = this.$g.getAlive() > 0 ? androidx.compose.foundation.interaction.f.o(this.$g.getAlive(), " · ", " healthy") : "";
        Long best2 = this.$g.getBest();
        if (best2 != null && (strP = androidx.compose.foundation.interaction.f.p(best2.longValue(), " · best ", " ms")) != null) {
            str3 = strP;
        }
        String strTr2 = StoreNetKt.tr(strM, i11 + strO + str3);
        if (kotlin.jvm.internal.j.a(this.$g.getCc(), "??")) {
            str = "سنجش این\u200cها";
            str2 = "Test these";
        } else {
            str = "سنجش این کشور";
            str2 = "Test this country";
        }
        String strTr3 = StoreNetKt.tr(str, str2);
        boolean z10 = true;
        boolean z11 = !this.$testing;
        p0 p0Var2 = (p0) oVar;
        p0Var2.e0(-478455490);
        int i12 = i10 & 14;
        if (i12 != 4 && ((i10 & 8) == 0 || !p0Var2.h(SettingsGroup))) {
            z10 = false;
        }
        boolean zF = p0Var2.f(this.$kind) | z10 | p0Var2.h(this.$g);
        String str4 = this.$kind;
        ArgoPool.Group group2 = this.$g;
        k2 k2Var = this.$err$delegate;
        Object objI = p0Var2.I();
        e2 e2Var = androidx.compose.runtime.n.f3284a;
        if (zF || objI == e2Var) {
            objI = new p(SettingsGroup, str4, group2, k2Var);
            p0Var2.r0(objI);
        }
        ee.a aVar = (ee.a) objI;
        p0Var2.u(false);
        boolean zA = kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(this.$openCc$delegate), this.$g.getCc());
        p0Var2.e0(-478450775);
        boolean zF2 = p0Var2.f(this.$openCc$delegate) | p0Var2.h(this.$g);
        ArgoPool.Group group3 = this.$g;
        k2 k2Var2 = this.$openCc$delegate;
        Object objI2 = p0Var2.I();
        if (zF2 || objI2 == e2Var) {
            objI2 = new q(4, group3, k2Var2);
            p0Var2.r0(objI2);
        }
        p0Var2.u(false);
        ArgoScreenKt.GroupHead(eVarF, strTr, strTr2, strTr3, z11, aVar, zA, (ee.a) objI2, oVar, 6);
        if (kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(this.$openCc$delegate), this.$g.getCc())) {
            long jArgoList$lambda$90 = ArgoScreenKt.ArgoList$lambda$90(this.$version$delegate);
            String cc2 = this.$g.getCc();
            p0Var2.e0(-478446450);
            boolean zE = p0Var2.e(jArgoList$lambda$90) | p0Var2.f(this.$kind) | p0Var2.f(cc2);
            String str5 = this.$kind;
            ArgoPool.Group group4 = this.$g;
            Object objI3 = p0Var2.I();
            if (zE || objI3 == e2Var) {
                objI3 = ArgoPool.rows$default(ArgoPool.INSTANCE, str5, group4.getCc(), null, null, Brain.MAX_CELLS, 12, null);
                p0Var2.r0(objI3);
            }
            sd.j jVar = (sd.j) objI3;
            p0Var2.u(false);
            int iIntValue = ((Number) jVar.component1()).intValue();
            List<ArgoPool.Row> list = (List) jVar.component2();
            p0Var2.e0(-478442838);
            RowCtx rowCtx = this.$rowCtx;
            for (ArgoPool.Row row : list) {
                SettingsGroup.Separator(oVar, i12);
                ArgoScreenKt.ItemRow(row, rowCtx, oVar, 0);
            }
            p0Var2.u(false);
            if (iIntValue > list.size()) {
                SettingsGroup.Separator(oVar, i12);
                IosSettingsKt.m863SettingsRowqhMrWXk(StoreNetKt.tr(f0.a.m(ArgoScreenKt.fa(list.size()), " مورد اول از ", ArgoScreenKt.fa(iIntValue), " نشان داده شد (سالم\u200cها و تازه\u200cترها اول)؛ برای بقیه جست\u200cوجو کنید."), w0.l("The first ", list.size(), " of ", iIntValue, " are shown (healthy and newer first); search for the rest.")), null, 0L, null, null, 0L, false, null, 0, oVar, 1572864, 446);
            }
        }
        r0 r0Var2 = v0.f3474a;
    }
}
