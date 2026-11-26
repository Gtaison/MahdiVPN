package com.mlmvpn.scanner.ui.argo;

import a6.w0;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.ULocale;
import android.net.VpnService;
import android.widget.Toast;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.layout.a1;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.b3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.c1;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.d3;
import androidx.compose.foundation.layout.f0;
import androidx.compose.foundation.text.f2;
import androidx.compose.material3.c3;
import androidx.compose.material3.e8;
import androidx.compose.material3.f5;
import androidx.compose.material3.k9;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.e2;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.r3;
import androidx.compose.runtime.v0;
import androidx.compose.runtime.w2;
import androidx.compose.ui.graphics.vector.o1;
import androidx.compose.ui.graphics.x0;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.j3;
import androidx.compose.ui.platform.w1;
import androidx.compose.ui.semantics.g0;
import androidx.compose.ui.semantics.j0;
import androidx.compose.ui.text.s1;
import androidx.fragment.app.h0;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.scanner.MyVpnService;
import com.mlmvpn.scanner.R;
import com.mlmvpn.scanner.data.ScanGuard;
import com.mlmvpn.scanner.engines.argo.ArgoEngine;
import com.mlmvpn.scanner.engines.argo.ArgoPool;
import com.mlmvpn.scanner.engines.argo.ArgoProtocol;
import com.mlmvpn.scanner.engines.game.booster.brain.Brain;
import com.mlmvpn.scanner.engines.mami.MamiIdentity;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.EngineLiveKt;
import com.mlmvpn.scanner.ui.EngineTone;
import com.mlmvpn.scanner.ui.RouteChipsKt;
import com.mlmvpn.scanner.ui.f4;
import com.mlmvpn.scanner.ui.g1;
import com.mlmvpn.scanner.ui.home.GlassKt;
import com.mlmvpn.scanner.ui.j2;
import com.mlmvpn.scanner.ui.settings.Ios;
import com.mlmvpn.scanner.ui.settings.IosSettingsKt;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;
import com.mlmvpn.scanner.ui.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.mlmvpn.chat.bridge.GerehLocale;
import org.telegram.tgnet.TLObject;
import org.telegram.ui.Cells.d1;
import psi.Psi;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class ArgoScreenKt {
    private static final String TITLE = "آرگو VPN";

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoAdd$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class AnonymousClass2 implements ee.f {
        final /* synthetic */ ee.e $connect;
        final /* synthetic */ Context $context;
        final /* synthetic */ k2 $err$delegate;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ k2 $parsed$delegate;
        final /* synthetic */ ArgoPool.Summary $sum;
        final /* synthetic */ k2 $text$delegate;

        public AnonymousClass2(k2 k2Var, k2 k2Var2, Context context, ee.e eVar, k2 k2Var3, k2 k2Var4, ArgoPool.Summary summary) {
            this.$text$delegate = k2Var;
            this.$parsed$delegate = k2Var2;
            this.$context = context;
            this.$connect = eVar;
            this.$err$delegate = k2Var3;
            this.$note$delegate = k2Var4;
            this.$sum = summary;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$16$lambda$1$lambda$0(k2 k2Var, k2 k2Var2, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoAdd$lambda$161(k2Var, it);
            ArgoScreenKt.ArgoAdd$lambda$164(k2Var2, null);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$16$lambda$15$lambda$11$lambda$10(c1 c1Var, k2 k2Var, k2 k2Var2, k2 k2Var3, k2 k2Var4) {
            Object objM1004constructorimpl;
            ArgoScreenKt.ArgoAdd$lambda$167(k2Var, "");
            ArgoScreenKt.ArgoAdd$lambda$170(k2Var2, "");
            try {
                objM1004constructorimpl = sd.l.m1004constructorimpl(ArgoPool.INSTANCE.importText(ArgoScreenKt.ArgoAdd$lambda$160(k2Var3)));
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            if (sd.l.m1011isSuccessimpl(objM1004constructorimpl)) {
                ArgoPool.Absorbed absorbed = (ArgoPool.Absorbed) objM1004constructorimpl;
                ArgoScreenKt.ArgoAdd$lambda$164(k2Var4, null);
                StringBuilder sbK = d1.k(ArgoScreenKt.fa(absorbed.getBridges()), " پل و ", ArgoScreenKt.fa(absorbed.getFalcons()), " فالکن تازه به فهرست اضافه شد", absorbed.getBad() > 0 ? w0.n(" (", ArgoScreenKt.fa(absorbed.getBad()), " بلاک نامعتبر کنار گذاشته شد)") : "");
                sbK.append(".");
                ArgoScreenKt.ArgoAdd$lambda$170(k2Var2, StoreNetKt.tr(sbK.toString(), absorbed.getBridges() + " bridges and " + absorbed.getFalcons() + " falcons added" + (absorbed.getBad() > 0 ? androidx.compose.foundation.interaction.f.o(absorbed.getBad(), " (", " invalid blocks left out)") : "") + "."));
                if (absorbed.getFalcons() + absorbed.getBridges() > 0) {
                    ArgoScreenKt.ArgoAdd$lambda$161(k2Var3, "");
                }
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            if (thM1007exceptionOrNullimpl != null) {
                String message = thM1007exceptionOrNullimpl.getMessage();
                ArgoScreenKt.ArgoAdd$lambda$167(k2Var, message != null ? message : "");
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$16$lambda$15$lambda$14$lambda$13(c1 c1Var, ee.e eVar, k2 k2Var, k2 k2Var2, k2 k2Var3) {
            ArgoScreenKt.ArgoAdd$lambda$167(k2Var, "");
            ArgoScreenKt.ArgoAdd$lambda$170(k2Var2, "");
            if (kotlin.text.o.L0(ArgoScreenKt.ArgoAdd$lambda$160(k2Var3))) {
                ArgoScreenKt.ArgoAdd$lambda$167(k2Var, StoreNetKt.tr("اول بلاک پل یا دامنهٔ فالکن را بچسبانید", "Paste a bridge block or a falcon domain first"));
            } else {
                String strArgoAdd$lambda$160 = ArgoScreenKt.ArgoAdd$lambda$160(k2Var3);
                try {
                    sd.l.m1004constructorimpl(ArgoPool.INSTANCE.importText(strArgoAdd$lambda$160));
                } catch (Throwable th2) {
                    sd.l.m1004constructorimpl(sd.m.a(th2));
                }
                eVar.invoke(null, strArgoAdd$lambda$160);
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$16$lambda$15$lambda$4$lambda$3(c1 c1Var, k2 k2Var, k2 k2Var2, Context context, k2 k2Var3, k2 k2Var4) {
            Object objM1004constructorimpl;
            ClipData primaryClip;
            ClipData.Item itemAt;
            CharSequence charSequenceCoerceToText;
            ArgoScreenKt.ArgoAdd$lambda$167(k2Var, "");
            ArgoScreenKt.ArgoAdd$lambda$170(k2Var2, "");
            try {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(ClipboardManager.class);
                objM1004constructorimpl = sd.l.m1004constructorimpl((clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null || (charSequenceCoerceToText = itemAt.coerceToText(context)) == null) ? null : charSequenceCoerceToText.toString());
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                objM1004constructorimpl = null;
            }
            String str = (String) objM1004constructorimpl;
            if (str == null || kotlin.text.o.L0(str)) {
                ArgoScreenKt.ArgoAdd$lambda$167(k2Var, StoreNetKt.tr("دسترسی به کلیپ\u200cبورد مقدور نیست — متن را خودتان بچسبانید.", "The clipboard cannot be read — paste the text yourself."));
            } else {
                ArgoScreenKt.ArgoAdd$lambda$161(k2Var3, str);
                ArgoScreenKt.ArgoAdd$lambda$164(k2Var4, null);
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2 k2Var, k2 k2Var2, k2 k2Var3, k2 k2Var4) {
            ArgoScreenKt.ArgoAdd$lambda$167(k2Var, "");
            ArgoScreenKt.ArgoAdd$lambda$170(k2Var2, "");
            ArgoScreenKt.ArgoAdd$lambda$164(k2Var4, ArgoPool.INSTANCE.parse(ArgoScreenKt.ArgoAdd$lambda$160(k2Var3)));
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$25$lambda$24$lambda$23$lambda$21$lambda$20(c1 c1Var, Context context, ArgoProtocol.FalconOrigin falconOrigin) {
            sd.u uVar;
            sd.u uVar2 = sd.u.f67154a;
            try {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(ClipboardManager.class);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("ip", falconOrigin.getIp()));
                    uVar = uVar2;
                } else {
                    uVar = null;
                }
                sd.l.m1004constructorimpl(uVar);
            } catch (Throwable th2) {
                sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            Toast.makeText(context, StoreNetKt.tr(v0.a.h("آی\u200cپی کپی شد: ", falconOrigin.getIp()), "IP copied: " + falconOrigin.getIp()), 0).show();
            return uVar2;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:106:0x06d0  */
        /* JADX WARN: Code duplicated, block: B:110:0x06f3  */
        /* JADX WARN: Code duplicated, block: B:112:0x0731  */
        /* JADX WARN: Code duplicated, block: B:115:0x0736  */
        /* JADX WARN: Code duplicated, block: B:119:0x0781  */
        /* JADX WARN: Code duplicated, block: B:120:0x0785  */
        /* JADX WARN: Code duplicated, block: B:123:0x0798  */
        /* JADX WARN: Code duplicated, block: B:125:0x07a6  */
        /* JADX WARN: Code duplicated, block: B:130:0x0606 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:131:0x0602 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:28:0x021e  */
        /* JADX WARN: Code duplicated, block: B:30:0x0226  */
        /* JADX WARN: Code duplicated, block: B:35:0x0248  */
        /* JADX WARN: Code duplicated, block: B:42:0x0287  */
        /* JADX WARN: Code duplicated, block: B:48:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:54:0x0328  */
        /* JADX WARN: Code duplicated, block: B:60:0x0381  */
        /* JADX WARN: Code duplicated, block: B:63:0x03b0  */
        /* JADX WARN: Code duplicated, block: B:65:0x03d6  */
        /* JADX WARN: Code duplicated, block: B:68:0x03f0  */
        /* JADX WARN: Code duplicated, block: B:72:0x0422  */
        /* JADX WARN: Code duplicated, block: B:75:0x04a6  */
        /* JADX WARN: Code duplicated, block: B:77:0x04ac  */
        /* JADX WARN: Code duplicated, block: B:82:0x04cc  */
        /* JADX WARN: Code duplicated, block: B:88:0x05b3  */
        /* JADX WARN: Code duplicated, block: B:90:0x05bb A[LOOP:0: B:86:0x05ac->B:90:0x05bb, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:95:0x0620  */
        /* JADX WARN: Code duplicated, block: B:96:0x066b  */
        /* JADX WARN: Code duplicated, block: B:98:0x06a5  */
        /* JADX WARN: Code duplicated, block: B:99:0x06a9  */
        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            androidx.compose.ui.node.p pVar;
            Ios ios;
            float f8;
            final k2 k2Var;
            boolean zF;
            Object objI;
            e2 e2Var;
            final k2 k2Var2;
            int iE;
            l0 l0Var;
            androidx.compose.ui.node.m mVar;
            boolean zH;
            e2 e2Var2;
            Object obj;
            final k2 k2Var3;
            androidx.compose.ui.node.m mVar2;
            boolean zF2;
            Object obj2;
            boolean zF3;
            Object obj3;
            final k2 k2Var4;
            float f10;
            l0 l0Var2;
            boolean zF4;
            Object objI2;
            androidx.compose.runtime.o oVar2;
            p0 p0Var;
            Ios ios2;
            boolean z10;
            final ArgoPool.Parsed parsedArgoAdd$lambda$163;
            ArgoPool.Summary summary;
            int iE2;
            Context context;
            e2 e2Var3;
            int i10;
            androidx.compose.runtime.o oVar3;
            p0 p0Var2;
            Iterator it;
            int i11;
            androidx.compose.ui.semantics.f fVar;
            p0 p0Var3;
            float f11;
            androidx.compose.ui.q qVar;
            int iE3;
            l0 l0Var3;
            androidx.compose.ui.node.m mVar3;
            p0 p0Var4;
            Integer num;
            p0 p0Var5;
            androidx.compose.ui.q qVar2;
            boolean z11;
            boolean z12;
            boolean zH2;
            Object objI3;
            e2 e2Var4;
            int iE4;
            l0 l0Var4;
            androidx.compose.ui.node.m mVar4;
            Object next;
            int i12;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var6 = (p0) oVar;
                if (p0Var6.G()) {
                    p0Var6.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("پل یا فالکن خودتان", "Your own bridge or falcon"), 0.0f, oVar, 0, 2);
            androidx.compose.ui.q qVar3 = androidx.compose.ui.q.f4604b;
            float f12 = 16;
            androidx.compose.ui.t tVarX = f0.x(d3.e(qVar3, 1.0f), f12, 0.0f, 2);
            k2 k2Var5 = this.$text$delegate;
            k2 k2Var6 = this.$parsed$delegate;
            final Context context2 = this.$context;
            ee.e eVar = this.$connect;
            final k2 k2Var7 = this.$err$delegate;
            final k2 k2Var8 = this.$note$delegate;
            p0 p0Var7 = (p0) oVar;
            p0Var7.e0(-483455358);
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.i.f2024c;
            androidx.compose.ui.h hVar = androidx.compose.ui.b.f3551w;
            k0 k0VarA = c0.a(bVar, hVar, oVar);
            p0Var7.e0(-1323940314);
            int iE5 = b1.E(oVar);
            w2 w2VarO = p0Var7.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var5 = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarX);
            p0Var7.h0();
            if (p0Var7.M) {
                p0Var7.n(l0Var5);
            } else {
                p0Var7.t0();
            }
            androidx.compose.ui.node.p pVar2 = androidx.compose.ui.node.t.f4283f;
            b1.Y(oVar, pVar2, k0VarA);
            androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
            b1.Y(oVar, rVar, w2VarO);
            androidx.compose.ui.node.m mVar5 = androidx.compose.ui.node.t.i;
            p0 p0Var8 = (p0) oVar;
            if (p0Var8.M) {
                pVar = pVar2;
            } else {
                pVar = pVar2;
                if (!kotlin.jvm.internal.j.a(p0Var8.I(), Integer.valueOf(iE5))) {
                }
                com.mlmvpn.scanner.e.v(oVar, eVarM, oVar, 0);
                p0Var7.e0(2058660585);
                String strTr = StoreNetKt.tr("متن را اینجا بگذارید", "Put the text here");
                ios = Ios.INSTANCE;
                long label = ios.getLabel(oVar, 6);
                long jT = x6.a.t(15);
                androidx.compose.ui.text.font.w wVar = androidx.compose.ui.text.font.w.f4817h;
                androidx.compose.ui.node.p pVar3 = pVar;
                k9.b(strTr, null, label, jT, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
                float f13 = 2;
                f8 = 8;
                k9.b(StoreNetKt.tr("یک یا چند بلاک پل (-----BEGIN ARGO VPN BRIDGE BLOCK-----)، یا دامنه\u200cهای فالکن (هر کدام در یک خط). از هر پیام یا فایلی کپی کنید؛ بقیهٔ متن نادیده گرفته می\u200cشود.", "One or more bridge blocks (-----BEGIN ARGO VPN BRIDGE BLOCK-----), or falcon domains (one per line). Copy from any message or file; the rest of the text is ignored."), f0.z(qVar3, 0.0f, f13, 0.0f, f8, 5), ios.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(19), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
                String strArgoAdd$lambda$160 = ArgoScreenKt.ArgoAdd$lambda$160(k2Var5);
                p0Var7.e0(-2069624548);
                k2Var = k2Var5;
                zF = p0Var7.f(k2Var);
                objI = p0Var7.I();
                e2Var = androidx.compose.runtime.n.f3284a;
                if (!zF || objI == e2Var) {
                    k2Var2 = k2Var6;
                    objI = new ee.c() { // from class: com.mlmvpn.scanner.ui.argo.m
                        @Override // ee.c
                        public final Object invoke(Object obj4) {
                            return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$1$lambda$0(k2Var, k2Var2, (String) obj4);
                        }
                    };
                    p0Var7.r0(objI);
                } else {
                    k2Var2 = k2Var6;
                }
                p0Var7.u(false);
                ArgoScreenKt.Field(strArgoAdd$lambda$160, (ee.c) objI, "-----BEGIN ARGO VPN BRIDGE BLOCK-----\neJ…\n-----END ARGO VPN BRIDGE BLOCK-----\n\nfalcon.example.com", 7, null, oVar, 3456, 16);
                f0.e(oVar, d3.g(qVar3, f8));
                androidx.compose.foundation.layout.f fVarH = androidx.compose.foundation.layout.i.h(f8);
                float f14 = 6;
                androidx.compose.foundation.layout.f fVarH2 = androidx.compose.foundation.layout.i.h(f14);
                p0Var7.e0(1098475987);
                k0 k0VarC = a1.c(fVarH, fVarH2, oVar);
                p0Var7.e0(-1323940314);
                iE = b1.E(oVar);
                w2 w2VarO2 = p0Var7.o();
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(qVar3);
                p0Var7.h0();
                if (p0Var7.M) {
                    l0Var = l0Var5;
                    p0Var7.n(l0Var);
                } else {
                    l0Var = l0Var5;
                    p0Var7.t0();
                }
                b1.Y(oVar, pVar3, k0VarC);
                b1.Y(oVar, rVar, w2VarO2);
                if (p0Var8.M && kotlin.jvm.internal.j.a(p0Var8.I(), Integer.valueOf(iE))) {
                    mVar = mVar5;
                } else {
                    mVar = mVar5;
                    w0.u(iE, p0Var8, iE, mVar);
                }
                com.mlmvpn.scanner.e.v(oVar, eVarM2, oVar, 0);
                p0Var7.e0(2058660585);
                String strTr2 = StoreNetKt.tr("چسباندن", "Paste");
                androidx.compose.ui.graphics.vector.f fVarN = x6.p.n();
                p0Var7.e0(-1252946443);
                zH = p0Var7.h(context2) | p0Var7.f(k2Var);
                Object objI4 = p0Var7.I();
                if (!zH || objI4 == e2Var) {
                    e2Var2 = e2Var;
                    final k2 k2Var9 = k2Var2;
                    obj = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.n
                        @Override // ee.a
                        public final Object invoke() {
                            k2 k2Var10 = k2Var;
                            k2 k2Var11 = k2Var9;
                            return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$4$lambda$3(androidx.compose.foundation.layout.d1.f1987a, k2Var7, k2Var8, context2, k2Var10, k2Var11);
                        }
                    };
                    k2Var3 = k2Var8;
                    k2Var = k2Var;
                    k2Var2 = k2Var9;
                    p0Var7.r0(obj);
                } else {
                    obj = objI4;
                    e2Var2 = e2Var;
                    k2Var3 = k2Var8;
                }
                p0Var7.u(false);
                e2 e2Var5 = e2Var2;
                mVar2 = mVar;
                ArgoScreenKt.Btn(strTr2, false, false, fVarN, (ee.a) obj, oVar, 0, 6);
                String strTr3 = StoreNetKt.tr("بررسی", "Check");
                p0Var7.e0(-1252931435);
                zF2 = p0Var7.f(k2Var);
                Object objI5 = p0Var7.I();
                if (!zF2 || objI5 == e2Var5) {
                    final int i13 = 0;
                    obj2 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                        @Override // ee.a
                        public final Object invoke() {
                            int i14 = i13;
                            k2 k2Var10 = k2Var2;
                            k2 k2Var11 = k2Var;
                            k2 k2Var12 = k2Var3;
                            k2 k2Var13 = k2Var7;
                            switch (i14) {
                                case 0:
                                    return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var13, k2Var12, k2Var11, k2Var10);
                                default:
                                    return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var13, k2Var12, k2Var11, k2Var10);
                            }
                        }
                    };
                    p0Var7.r0(obj2);
                } else {
                    obj2 = objI5;
                }
                p0Var7.u(false);
                ArgoScreenKt.Btn(strTr3, false, false, null, (ee.a) obj2, oVar, 0, 14);
                String strTr4 = StoreNetKt.tr("افزودن به فهرست", "Add to the list");
                p0Var7.e0(-1252927145);
                zF3 = p0Var7.f(k2Var);
                Object objI6 = p0Var7.I();
                if (!zF3 || objI6 == e2Var5) {
                    final int i14 = 1;
                    k2Var4 = k2Var7;
                    obj3 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                        @Override // ee.a
                        public final Object invoke() {
                            int i15 = i14;
                            k2 k2Var10 = k2Var2;
                            k2 k2Var11 = k2Var;
                            k2 k2Var12 = k2Var3;
                            k2 k2Var13 = k2Var4;
                            switch (i15) {
                                case 0:
                                    return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var13, k2Var12, k2Var11, k2Var10);
                                default:
                                    return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var13, k2Var12, k2Var11, k2Var10);
                            }
                        }
                    };
                    p0Var7.r0(obj3);
                } else {
                    obj3 = objI6;
                    k2Var4 = k2Var7;
                }
                p0Var7.u(false);
                f10 = f14;
                l0Var2 = l0Var;
                ArgoScreenKt.Btn(strTr4, false, false, null, (ee.a) obj3, oVar, 0, 14);
                String strTr5 = StoreNetKt.tr("افزودن و اتصال", "Add and connect");
                p0Var7.e0(-1252905743);
                zF4 = p0Var7.f(k2Var) | p0Var7.f(eVar);
                objI2 = p0Var7.I();
                if (zF4 || objI2 == e2Var5) {
                    objI2 = new p(eVar, k2Var4, k2Var3, k2Var);
                    p0Var7.r0(objI2);
                }
                p0Var7.u(false);
                oVar2 = oVar;
                ArgoScreenKt.Btn(strTr5, true, false, null, (ee.a) objI2, oVar2, 48, 12);
                w0.z(p0Var7, false, true, false, false);
                p0Var7.e0(-2069560414);
                if (kotlin.text.o.L0(ArgoScreenKt.ArgoAdd$lambda$166(k2Var4))) {
                    p0Var = p0Var7;
                    ios2 = ios;
                    z10 = true;
                } else {
                    androidx.compose.ui.graphics.vector.f fVarL = x6.t.l();
                    ios2 = ios;
                    long red = ios2.getRed(oVar2, 6);
                    String strArgoAdd$lambda$166 = ArgoScreenKt.ArgoAdd$lambda$166(k2Var4);
                    p0Var = p0Var7;
                    z10 = true;
                    ArgoScreenKt.m546Callout8V94_ZQ(fVarL, red, strArgoAdd$lambda$166, null, null, oVar, 0, 24);
                    oVar2 = oVar;
                }
                p0Var.u(false);
                p0Var.e0(-2069557878);
                if (!kotlin.text.o.L0(ArgoScreenKt.ArgoAdd$lambda$169(k2Var3))) {
                    ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios2.getGreen(oVar2, 6), ArgoScreenKt.ArgoAdd$lambda$169(k2Var3), null, null, oVar, 0, 24);
                    oVar2 = oVar;
                }
                w0.z(p0Var, false, false, z10, false);
                p0Var.u(false);
                parsedArgoAdd$lambda$163 = ArgoScreenKt.ArgoAdd$lambda$163(this.$parsed$delegate);
                p0Var.e0(-1642854721);
                if (parsedArgoAdd$lambda$163 != null) {
                    f0.e(oVar2, d3.g(qVar3, 10));
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -1550748451, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoAdd$2$2$1
                        @Override // ee.f
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6) {
                            invoke((SettingsGroupScope) obj4, (androidx.compose.runtime.o) obj5, ((Number) obj6).intValue());
                            return sd.u.f67154a;
                        }

                        public final void invoke(SettingsGroupScope settingsGroupScope, androidx.compose.runtime.o oVar4, int i15) {
                            boolean z13;
                            p0 p0Var9;
                            String str;
                            String str2;
                            SettingsGroupScope SettingsGroup = settingsGroupScope;
                            androidx.compose.runtime.o oVar5 = oVar4;
                            kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                            int i16 = (i15 & 6) == 0 ? i15 | ((i15 & 8) == 0 ? ((p0) oVar5).f(SettingsGroup) : ((p0) oVar5).h(SettingsGroup) ? 4 : 2) : i15;
                            if ((i16 & 19) == 18) {
                                p0 p0Var10 = (p0) oVar5;
                                if (p0Var10.G()) {
                                    p0Var10.Y();
                                    return;
                                }
                            }
                            r0 r0Var2 = v0.f3474a;
                            p0 p0Var11 = (p0) oVar5;
                            p0Var11.e0(-1252886280);
                            int i17 = 6;
                            if (parsedArgoAdd$lambda$163.getBridges().isEmpty() && parsedArgoAdd$lambda$163.getFalcons().isEmpty()) {
                                ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.p.r(), Ios.INSTANCE.getOrange(oVar5, 6), StoreNetKt.tr("در این متن نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن.", "This text holds neither an Argo bridge block nor a falcon domain."), null, null, oVar5, 0, 24);
                            }
                            boolean z14 = false;
                            p0Var11.u(false);
                            p0Var11.e0(-1252877074);
                            boolean z15 = true;
                            for (ArgoPool.ParsedBridge parsedBridge : parsedArgoAdd$lambda$163.getBridges()) {
                                p0Var11.e0(-1252876490);
                                if (!z15) {
                                    SettingsGroup.Separator(oVar5, i16 & 14);
                                }
                                p0Var11.u(z14);
                                if (kotlin.text.o.L0(parsedBridge.getError())) {
                                    z13 = z14;
                                    p0Var9 = p0Var11;
                                    p0Var9.e0(774787488);
                                    String strL = f0.a.l(StoreNetKt.tr("پل · ", "Bridge · "), parsedBridge.getHost(), parsedBridge.getPort() != 443 ? f0.a.h(parsedBridge.getPort(), ":") : "");
                                    if (parsedBridge.getSigOk()) {
                                        str = "امضای آرگو درست است";
                                        str2 = "Argo's signature checks out";
                                    } else {
                                        str = "امضای آرگو نادرست است — پذیرفته نمی\u200cشود";
                                        str2 = "Argo's signature is wrong — it is not accepted";
                                    }
                                    oVar5 = oVar4;
                                    IosSettingsKt.m863SettingsRowqhMrWXk(strL, null, 0L, null, StoreNetKt.tr(str, str2), 0L, false, null, 0, oVar5, 1572864, 430);
                                    p0Var9.u(z13);
                                } else {
                                    p0Var11.e0(1410463109);
                                    z13 = z14;
                                    p0Var9 = p0Var11;
                                    IosSettingsKt.m863SettingsRowqhMrWXk(parsedBridge.getError(), null, 0L, null, null, Ios.INSTANCE.getRed(oVar5, i17), false, null, 0, oVar5, 1572864, 414);
                                    p0Var9.u(z13);
                                    oVar5 = oVar4;
                                }
                                p0Var11 = p0Var9;
                                z14 = z13;
                                z15 = z14;
                                i17 = i17;
                                SettingsGroup = settingsGroupScope;
                            }
                            boolean z16 = z14;
                            p0 p0Var12 = p0Var11;
                            p0Var12.u(z16);
                            for (String str3 : parsedArgoAdd$lambda$163.getFalcons()) {
                                p0Var12.e0(-1252857738);
                                if (!z15) {
                                    settingsGroupScope.Separator(oVar5, i16 & 14);
                                }
                                p0Var12.u(z16);
                                IosSettingsKt.m863SettingsRowqhMrWXk(v0.a.p(StoreNetKt.tr("فالکن · ", "Falcon · "), str3), null, 0L, null, StoreNetKt.tr("دامنه\u200cای روی کلادفلر جلوی سرور آرگو — با سنجش معلوم می\u200cشود زنده است یا نه", "A domain on Cloudflare in front of an Argo server — a test tells whether it is alive"), 0L, false, null, 0, oVar5, 1572864, 430);
                                oVar5 = oVar4;
                                z15 = z16;
                            }
                            r0 r0Var3 = v0.f3474a;
                        }
                    }), oVar, 384, 3);
                    oVar2 = oVar;
                }
                p0Var.u(false);
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("ساخت فالکن شخصی", "Make your own falcon"), 0.0f, oVar2, 0, 2);
                androidx.compose.ui.t tVarX2 = f0.x(d3.e(qVar3, 1.0f), f12, 0.0f, 2);
                float f15 = 12;
                androidx.compose.ui.t tVarV = f0.v(GlassKt.frostedGlass(tVarX2, e0.e.b(f15), false, false, oVar, 6, 6), f15);
                summary = this.$sum;
                Context context3 = this.$context;
                p0Var.e0(-483455358);
                k0 k0VarA2 = c0.a(bVar, hVar, oVar);
                p0Var.e0(-1323940314);
                iE2 = b1.E(oVar);
                w2 w2VarO3 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarV);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var2);
                } else {
                    p0Var.t0();
                }
                b1.Y(oVar, pVar3, k0VarA2);
                b1.Y(oVar, rVar, w2VarO3);
                if (p0Var8.M || !kotlin.jvm.internal.j.a(p0Var8.I(), Integer.valueOf(iE2))) {
                    w0.u(iE2, p0Var8, iE2, mVar2);
                }
                com.mlmvpn.scanner.e.v(oVar, eVarM3, oVar, 0);
                p0Var.e0(2058660585);
                context = context3;
                e2Var3 = e2Var5;
                k9.b(StoreNetKt.tr("فالکنی که فقط شما و نزدیکانتان بشناسید، دیرتر مسدود می\u200cشود", "A falcon only you and yours know is blocked later"), null, ios2.getLabel(oVar, 6), x6.a.t(15), null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
                i10 = 6;
                k9.b(StoreNetKt.tr("روش رسمی خود آرگو:", "Argo's own official way:"), f0.z(qVar3, 0.0f, f13, 0.0f, 4, 5), ios2.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
                oVar3 = oVar;
                p0Var2 = p0Var;
                p0Var2.e0(-2069466313);
                it = kotlin.collections.r.a0(StoreNetKt.tr("دامنه\u200cای (هر دامنه\u200cای) را به کلادفلر وصل کنید.", "Put a domain (any domain) on Cloudflare."), StoreNetKt.tr("یک رکورد A بسازید که به یکی از آی\u200cپی\u200cهای زیر اشاره کند و «Proxied» (ابر نارنجی) روشن باشد.", "Make an A record pointing at one of the IPs below, with «Proxied» (the orange cloud) on."), StoreNetKt.tr("در کلادفلر SSL/TLS را روی Full بگذارید.", "In Cloudflare, set SSL/TLS to Full."), StoreNetKt.tr("نام همان رکورد (مثلاً argo.example.com) را بالاتر، در «پل یا فالکن خودتان»، وارد کنید و «افزودن و اتصال» را بزنید.", "Enter that record's name (e.g. argo.example.com) above, in «Your own bridge or falcon», and tap «Add and connect».")).iterator();
                i11 = 0;
                while (true) {
                    fVar = null;
                    if (it.hasNext()) {
                        p0Var3 = p0Var2;
                        p0Var3.u(false);
                        f11 = f8;
                        f0.e(oVar3, d3.g(qVar3, f11));
                        if (summary.getFalconList().isEmpty()) {
                            p0Var3.e0(-2069459715);
                            k9.b(StoreNetKt.tr("فهرست سرورهای فالکن هنوز گرفته نشده — «به\u200cروزرسانی» را بزنید.", "The falcon servers' list has not been fetched yet — tap «Refresh»."), null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                            oVar3 = oVar;
                            z11 = false;
                            p0Var3.u(false);
                            p0Var5 = p0Var3;
                            qVar2 = qVar3;
                            z12 = true;
                        } else {
                            qVar = qVar3;
                            p0Var3.e0(-2069452147);
                            androidx.compose.foundation.layout.f fVarH3 = androidx.compose.foundation.layout.i.h(f10);
                            androidx.compose.foundation.layout.f fVarH4 = androidx.compose.foundation.layout.i.h(f10);
                            p0Var3.e0(1098475987);
                            k0 k0VarC2 = a1.c(fVarH3, fVarH4, oVar3);
                            p0Var3.e0(-1323940314);
                            iE3 = b1.E(oVar3);
                            w2 w2VarO4 = p0Var3.o();
                            androidx.compose.ui.node.u.i.getClass();
                            l0Var3 = androidx.compose.ui.node.t.f4279b;
                            androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(qVar);
                            p0Var3.h0();
                            if (p0Var3.M) {
                                p0Var3.n(l0Var3);
                            } else {
                                p0Var3.t0();
                            }
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC2);
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO4);
                            mVar3 = androidx.compose.ui.node.t.i;
                            p0Var4 = p0Var8;
                            if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE3))) {
                                w0.u(iE3, p0Var4, iE3, mVar3);
                            }
                            num = 0;
                            com.mlmvpn.scanner.e.v(oVar3, eVarM4, oVar3, null);
                            p0Var3.e0(2058660585);
                            p0Var3.e0(-1252782641);
                            for (ArgoProtocol.FalconOrigin falconOrigin : summary.getFalconList()) {
                                androidx.compose.ui.q qVar4 = qVar;
                                androidx.compose.ui.t tVarB = androidx.compose.ui.draw.h.b(qVar4, e0.e.b(10));
                                Ios ios3 = Ios.INSTANCE;
                                androidx.compose.ui.t tVarF = androidx.compose.foundation.p.f(tVarB, androidx.compose.ui.graphics.v.c(0.06f, ios3.getLabel(oVar3, 6)), androidx.compose.ui.graphics.d0.f3719a);
                                p0Var3.e0(1410557733);
                                Context context4 = context;
                                zH2 = p0Var3.h(context4) | p0Var3.f(falconOrigin);
                                objI3 = p0Var3.I();
                                if (zH2) {
                                    e2Var4 = e2Var3;
                                } else {
                                    e2Var4 = e2Var3;
                                    if (objI3 == e2Var4) {
                                    }
                                    p0Var3.u(false);
                                    androidx.compose.ui.t tVarL = androidx.compose.foundation.p.l(tVarF, false, fVar, (ee.a) objI3, 7);
                                    float f16 = f10;
                                    androidx.compose.ui.t tVarW = f0.w(tVarL, f11, f16);
                                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                                    p0Var3.e0(693286680);
                                    k0 k0VarA3 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, oVar3);
                                    p0Var3.e0(-1323940314);
                                    iE4 = b1.E(oVar3);
                                    w2 w2VarO5 = p0Var3.o();
                                    androidx.compose.ui.node.u.i.getClass();
                                    l0Var4 = androidx.compose.ui.node.t.f4279b;
                                    androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarW);
                                    p0Var3.h0();
                                    float f17 = f11;
                                    if (p0Var3.M) {
                                        p0Var3.n(l0Var4);
                                    } else {
                                        p0Var3.t0();
                                    }
                                    b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA3);
                                    b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO5);
                                    mVar4 = androidx.compose.ui.node.t.i;
                                    if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE4))) {
                                        w0.u(iE4, p0Var4, iE4, mVar4);
                                    }
                                    com.mlmvpn.scanner.e.v(oVar3, eVarM5, oVar3, num);
                                    p0Var3.e0(2058660585);
                                    Integer num2 = num;
                                    context = context4;
                                    p0 p0Var9 = p0Var3;
                                    k9.b(ArgoScreenKt.flag(falconOrigin.getCc()), null, 0L, x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131062);
                                    f0.e(oVar, d3.p(qVar4, f16));
                                    k9.b(falconOrigin.getIp(), null, ios3.getLabel(oVar, 6), x6.a.t(12), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 130994);
                                    f0.e(oVar, d3.p(qVar4, f16));
                                    f10 = f16;
                                    k9.b(StoreNetKt.tr(v0.a.h("بار ", ArgoScreenKt.fa(Math.round(falconOrigin.getLoad()))), "load " + Math.round(falconOrigin.getLoad())), null, ios3.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                                    oVar3 = oVar;
                                    w0.z(p0Var9, false, true, false, false);
                                    qVar = qVar4;
                                    p0Var3 = p0Var9;
                                    fVar = null;
                                    e2Var3 = e2Var4;
                                    f11 = f17;
                                    num = num2;
                                    p0Var4 = p0Var4;
                                }
                                objI3 = new q(context4, falconOrigin);
                                p0Var3.r0(objI3);
                                p0Var3.u(false);
                                androidx.compose.ui.t tVarL2 = androidx.compose.foundation.p.l(tVarF, false, fVar, (ee.a) objI3, 7);
                                float f18 = f10;
                                androidx.compose.ui.t tVarW2 = f0.w(tVarL2, f11, f18);
                                androidx.compose.ui.i iVar2 = androidx.compose.ui.b.f3549s;
                                p0Var3.e0(693286680);
                                k0 k0VarA4 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar2, oVar3);
                                p0Var3.e0(-1323940314);
                                iE4 = b1.E(oVar3);
                                w2 w2VarO6 = p0Var3.o();
                                androidx.compose.ui.node.u.i.getClass();
                                l0Var4 = androidx.compose.ui.node.t.f4279b;
                                androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(tVarW2);
                                p0Var3.h0();
                                float f19 = f11;
                                if (p0Var3.M) {
                                    p0Var3.n(l0Var4);
                                } else {
                                    p0Var3.t0();
                                }
                                b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA4);
                                b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO6);
                                mVar4 = androidx.compose.ui.node.t.i;
                                if (p0Var4.M) {
                                    w0.u(iE4, p0Var4, iE4, mVar4);
                                } else {
                                    w0.u(iE4, p0Var4, iE4, mVar4);
                                }
                                com.mlmvpn.scanner.e.v(oVar3, eVarM6, oVar3, num);
                                p0Var3.e0(2058660585);
                                Integer num3 = num;
                                context = context4;
                                p0 p0Var10 = p0Var3;
                                k9.b(ArgoScreenKt.flag(falconOrigin.getCc()), null, 0L, x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131062);
                                f0.e(oVar, d3.p(qVar4, f18));
                                k9.b(falconOrigin.getIp(), null, ios3.getLabel(oVar, 6), x6.a.t(12), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 130994);
                                f0.e(oVar, d3.p(qVar4, f18));
                                f10 = f18;
                                k9.b(StoreNetKt.tr(v0.a.h("بار ", ArgoScreenKt.fa(Math.round(falconOrigin.getLoad()))), "load " + Math.round(falconOrigin.getLoad())), null, ios3.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                                oVar3 = oVar;
                                w0.z(p0Var10, false, true, false, false);
                                qVar = qVar4;
                                p0Var3 = p0Var10;
                                fVar = null;
                                e2Var3 = e2Var4;
                                f11 = f19;
                                num = num3;
                                p0Var4 = p0Var4;
                            }
                            p0Var5 = p0Var3;
                            qVar2 = qVar;
                            z11 = false;
                            z12 = true;
                            w0.z(p0Var5, false, false, true, false);
                            p0Var5.u(false);
                            p0Var5.u(false);
                        }
                        w0.z(p0Var5, z11, z12, z11, z11);
                        f0.e(oVar3, d3.g(qVar2, 40));
                        r0 r0Var2 = v0.f3474a;
                        return;
                    }
                    next = it.next();
                    i12 = i11 + 1;
                    if (i11 >= 0) {
                        kotlin.collections.r.f0();
                        throw null;
                    }
                    k9.b(f0.a.l(ArgoScreenKt.fa(i12), ". ", (String) next), null, Ios.INSTANCE.getSecondaryLabel(oVar3, i10), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(20), 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 6, 130034);
                    p0Var2 = p0Var2;
                    oVar3 = oVar;
                    i11 = i12;
                    i10 = 6;
                }
            }
            w0.u(iE5, p0Var8, iE5, mVar5);
            com.mlmvpn.scanner.e.v(oVar, eVarM, oVar, 0);
            p0Var7.e0(2058660585);
            String strTr6 = StoreNetKt.tr("متن را اینجا بگذارید", "Put the text here");
            ios = Ios.INSTANCE;
            long label2 = ios.getLabel(oVar, 6);
            long jT2 = x6.a.t(15);
            androidx.compose.ui.text.font.w wVar2 = androidx.compose.ui.text.font.w.f4817h;
            androidx.compose.ui.node.p pVar4 = pVar;
            k9.b(strTr6, null, label2, jT2, null, wVar2, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
            float f110 = 2;
            f8 = 8;
            k9.b(StoreNetKt.tr("یک یا چند بلاک پل (-----BEGIN ARGO VPN BRIDGE BLOCK-----)، یا دامنه\u200cهای فالکن (هر کدام در یک خط). از هر پیام یا فایلی کپی کنید؛ بقیهٔ متن نادیده گرفته می\u200cشود.", "One or more bridge blocks (-----BEGIN ARGO VPN BRIDGE BLOCK-----), or falcon domains (one per line). Copy from any message or file; the rest of the text is ignored."), f0.z(qVar3, 0.0f, f110, 0.0f, f8, 5), ios.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(19), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
            String strArgoAdd$lambda$161 = ArgoScreenKt.ArgoAdd$lambda$160(k2Var5);
            p0Var7.e0(-2069624548);
            k2Var = k2Var5;
            zF = p0Var7.f(k2Var);
            objI = p0Var7.I();
            e2Var = androidx.compose.runtime.n.f3284a;
            if (zF) {
                k2Var2 = k2Var6;
                objI = new ee.c() { // from class: com.mlmvpn.scanner.ui.argo.m
                    @Override // ee.c
                    public final Object invoke(Object obj4) {
                        return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$1$lambda$0(k2Var, k2Var2, (String) obj4);
                    }
                };
                p0Var7.r0(objI);
            } else {
                k2Var2 = k2Var6;
                objI = new ee.c() { // from class: com.mlmvpn.scanner.ui.argo.m
                    @Override // ee.c
                    public final Object invoke(Object obj4) {
                        return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$1$lambda$0(k2Var, k2Var2, (String) obj4);
                    }
                };
                p0Var7.r0(objI);
            }
            p0Var7.u(false);
            ArgoScreenKt.Field(strArgoAdd$lambda$161, (ee.c) objI, "-----BEGIN ARGO VPN BRIDGE BLOCK-----\neJ…\n-----END ARGO VPN BRIDGE BLOCK-----\n\nfalcon.example.com", 7, null, oVar, 3456, 16);
            f0.e(oVar, d3.g(qVar3, f8));
            androidx.compose.foundation.layout.f fVarH5 = androidx.compose.foundation.layout.i.h(f8);
            float f111 = 6;
            androidx.compose.foundation.layout.f fVarH6 = androidx.compose.foundation.layout.i.h(f111);
            p0Var7.e0(1098475987);
            k0 k0VarC3 = a1.c(fVarH5, fVarH6, oVar);
            p0Var7.e0(-1323940314);
            iE = b1.E(oVar);
            w2 w2VarO7 = p0Var7.o();
            androidx.compose.runtime.internal.e eVarM7 = androidx.compose.ui.layout.u.m(qVar3);
            p0Var7.h0();
            if (p0Var7.M) {
                l0Var = l0Var5;
                p0Var7.n(l0Var);
            } else {
                l0Var = l0Var5;
                p0Var7.t0();
            }
            b1.Y(oVar, pVar4, k0VarC3);
            b1.Y(oVar, rVar, w2VarO7);
            if (p0Var8.M) {
                mVar = mVar5;
                w0.u(iE, p0Var8, iE, mVar);
            } else {
                mVar = mVar5;
                w0.u(iE, p0Var8, iE, mVar);
            }
            com.mlmvpn.scanner.e.v(oVar, eVarM7, oVar, 0);
            p0Var7.e0(2058660585);
            String strTr7 = StoreNetKt.tr("چسباندن", "Paste");
            androidx.compose.ui.graphics.vector.f fVarN2 = x6.p.n();
            p0Var7.e0(-1252946443);
            zH = p0Var7.h(context2) | p0Var7.f(k2Var);
            Object objI7 = p0Var7.I();
            if (zH) {
                e2Var2 = e2Var;
                final k2 k2Var10 = k2Var2;
                obj = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.n
                    @Override // ee.a
                    public final Object invoke() {
                        k2 k2Var11 = k2Var;
                        k2 k2Var12 = k2Var10;
                        return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$4$lambda$3(androidx.compose.foundation.layout.d1.f1987a, k2Var7, k2Var8, context2, k2Var11, k2Var12);
                    }
                };
                k2Var3 = k2Var8;
                k2Var = k2Var;
                k2Var2 = k2Var10;
                p0Var7.r0(obj);
            } else {
                e2Var2 = e2Var;
                final k2 k2Var11 = k2Var2;
                obj = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.n
                    @Override // ee.a
                    public final Object invoke() {
                        k2 k2Var12 = k2Var;
                        k2 k2Var13 = k2Var11;
                        return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$4$lambda$3(androidx.compose.foundation.layout.d1.f1987a, k2Var7, k2Var8, context2, k2Var12, k2Var13);
                    }
                };
                k2Var3 = k2Var8;
                k2Var = k2Var;
                k2Var2 = k2Var11;
                p0Var7.r0(obj);
            }
            p0Var7.u(false);
            e2 e2Var6 = e2Var2;
            mVar2 = mVar;
            ArgoScreenKt.Btn(strTr7, false, false, fVarN2, (ee.a) obj, oVar, 0, 6);
            String strTr8 = StoreNetKt.tr("بررسی", "Check");
            p0Var7.e0(-1252931435);
            zF2 = p0Var7.f(k2Var);
            Object objI8 = p0Var7.I();
            if (zF2) {
                final int i15 = 0;
                obj2 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                    @Override // ee.a
                    public final Object invoke() {
                        int i16 = i15;
                        k2 k2Var12 = k2Var2;
                        k2 k2Var13 = k2Var;
                        k2 k2Var14 = k2Var3;
                        k2 k2Var15 = k2Var7;
                        switch (i16) {
                            case 0:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var15, k2Var14, k2Var13, k2Var12);
                            default:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var15, k2Var14, k2Var13, k2Var12);
                        }
                    }
                };
                p0Var7.r0(obj2);
            } else {
                final int i16 = 0;
                obj2 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                    @Override // ee.a
                    public final Object invoke() {
                        int i17 = i16;
                        k2 k2Var12 = k2Var2;
                        k2 k2Var13 = k2Var;
                        k2 k2Var14 = k2Var3;
                        k2 k2Var15 = k2Var7;
                        switch (i17) {
                            case 0:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var15, k2Var14, k2Var13, k2Var12);
                            default:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var15, k2Var14, k2Var13, k2Var12);
                        }
                    }
                };
                p0Var7.r0(obj2);
            }
            p0Var7.u(false);
            ArgoScreenKt.Btn(strTr8, false, false, null, (ee.a) obj2, oVar, 0, 14);
            String strTr9 = StoreNetKt.tr("افزودن به فهرست", "Add to the list");
            p0Var7.e0(-1252927145);
            zF3 = p0Var7.f(k2Var);
            Object objI9 = p0Var7.I();
            if (zF3) {
                final int i17 = 1;
                k2Var4 = k2Var7;
                obj3 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                    @Override // ee.a
                    public final Object invoke() {
                        int i18 = i17;
                        k2 k2Var12 = k2Var2;
                        k2 k2Var13 = k2Var;
                        k2 k2Var14 = k2Var3;
                        k2 k2Var15 = k2Var4;
                        switch (i18) {
                            case 0:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var15, k2Var14, k2Var13, k2Var12);
                            default:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var15, k2Var14, k2Var13, k2Var12);
                        }
                    }
                };
                p0Var7.r0(obj3);
            } else {
                final int i18 = 1;
                k2Var4 = k2Var7;
                obj3 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.o
                    @Override // ee.a
                    public final Object invoke() {
                        int i19 = i18;
                        k2 k2Var12 = k2Var2;
                        k2 k2Var13 = k2Var;
                        k2 k2Var14 = k2Var3;
                        k2 k2Var15 = k2Var4;
                        switch (i19) {
                            case 0:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$6$lambda$5(k2Var15, k2Var14, k2Var13, k2Var12);
                            default:
                                return ArgoScreenKt.AnonymousClass2.invoke$lambda$16$lambda$15$lambda$11$lambda$10(androidx.compose.foundation.layout.d1.f1987a, k2Var15, k2Var14, k2Var13, k2Var12);
                        }
                    }
                };
                p0Var7.r0(obj3);
            }
            p0Var7.u(false);
            f10 = f111;
            l0Var2 = l0Var;
            ArgoScreenKt.Btn(strTr9, false, false, null, (ee.a) obj3, oVar, 0, 14);
            String strTr10 = StoreNetKt.tr("افزودن و اتصال", "Add and connect");
            p0Var7.e0(-1252905743);
            zF4 = p0Var7.f(k2Var) | p0Var7.f(eVar);
            objI2 = p0Var7.I();
            if (zF4) {
                objI2 = new p(eVar, k2Var4, k2Var3, k2Var);
                p0Var7.r0(objI2);
            } else {
                objI2 = new p(eVar, k2Var4, k2Var3, k2Var);
                p0Var7.r0(objI2);
            }
            p0Var7.u(false);
            oVar2 = oVar;
            ArgoScreenKt.Btn(strTr10, true, false, null, (ee.a) objI2, oVar2, 48, 12);
            w0.z(p0Var7, false, true, false, false);
            p0Var7.e0(-2069560414);
            if (kotlin.text.o.L0(ArgoScreenKt.ArgoAdd$lambda$166(k2Var4))) {
                androidx.compose.ui.graphics.vector.f fVarL2 = x6.t.l();
                ios2 = ios;
                long red2 = ios2.getRed(oVar2, 6);
                String strArgoAdd$lambda$167 = ArgoScreenKt.ArgoAdd$lambda$166(k2Var4);
                p0Var = p0Var7;
                z10 = true;
                ArgoScreenKt.m546Callout8V94_ZQ(fVarL2, red2, strArgoAdd$lambda$167, null, null, oVar, 0, 24);
                oVar2 = oVar;
            } else {
                p0Var = p0Var7;
                ios2 = ios;
                z10 = true;
            }
            p0Var.u(false);
            p0Var.e0(-2069557878);
            if (!kotlin.text.o.L0(ArgoScreenKt.ArgoAdd$lambda$169(k2Var3))) {
                ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios2.getGreen(oVar2, 6), ArgoScreenKt.ArgoAdd$lambda$169(k2Var3), null, null, oVar, 0, 24);
                oVar2 = oVar;
            }
            w0.z(p0Var, false, false, z10, false);
            p0Var.u(false);
            parsedArgoAdd$lambda$163 = ArgoScreenKt.ArgoAdd$lambda$163(this.$parsed$delegate);
            p0Var.e0(-1642854721);
            if (parsedArgoAdd$lambda$163 != null) {
                f0.e(oVar2, d3.g(qVar3, 10));
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -1550748451, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoAdd$2$2$1
                    @Override // ee.f
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6) {
                        invoke((SettingsGroupScope) obj4, (androidx.compose.runtime.o) obj5, ((Number) obj6).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(SettingsGroupScope settingsGroupScope, androidx.compose.runtime.o oVar4, int i19) {
                        boolean z13;
                        p0 p0Var11;
                        String str;
                        String str2;
                        SettingsGroupScope SettingsGroup = settingsGroupScope;
                        androidx.compose.runtime.o oVar5 = oVar4;
                        kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                        int i110 = (i19 & 6) == 0 ? i19 | ((i19 & 8) == 0 ? ((p0) oVar5).f(SettingsGroup) : ((p0) oVar5).h(SettingsGroup) ? 4 : 2) : i19;
                        if ((i110 & 19) == 18) {
                            p0 p0Var12 = (p0) oVar5;
                            if (p0Var12.G()) {
                                p0Var12.Y();
                                return;
                            }
                        }
                        r0 r0Var3 = v0.f3474a;
                        p0 p0Var13 = (p0) oVar5;
                        p0Var13.e0(-1252886280);
                        int i111 = 6;
                        if (parsedArgoAdd$lambda$163.getBridges().isEmpty() && parsedArgoAdd$lambda$163.getFalcons().isEmpty()) {
                            ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.p.r(), Ios.INSTANCE.getOrange(oVar5, 6), StoreNetKt.tr("در این متن نه بلاک پل آرگو پیدا شد و نه دامنهٔ فالکن.", "This text holds neither an Argo bridge block nor a falcon domain."), null, null, oVar5, 0, 24);
                        }
                        boolean z14 = false;
                        p0Var13.u(false);
                        p0Var13.e0(-1252877074);
                        boolean z15 = true;
                        for (ArgoPool.ParsedBridge parsedBridge : parsedArgoAdd$lambda$163.getBridges()) {
                            p0Var13.e0(-1252876490);
                            if (!z15) {
                                SettingsGroup.Separator(oVar5, i110 & 14);
                            }
                            p0Var13.u(z14);
                            if (kotlin.text.o.L0(parsedBridge.getError())) {
                                z13 = z14;
                                p0Var11 = p0Var13;
                                p0Var11.e0(774787488);
                                String strL = f0.a.l(StoreNetKt.tr("پل · ", "Bridge · "), parsedBridge.getHost(), parsedBridge.getPort() != 443 ? f0.a.h(parsedBridge.getPort(), ":") : "");
                                if (parsedBridge.getSigOk()) {
                                    str = "امضای آرگو درست است";
                                    str2 = "Argo's signature checks out";
                                } else {
                                    str = "امضای آرگو نادرست است — پذیرفته نمی\u200cشود";
                                    str2 = "Argo's signature is wrong — it is not accepted";
                                }
                                oVar5 = oVar4;
                                IosSettingsKt.m863SettingsRowqhMrWXk(strL, null, 0L, null, StoreNetKt.tr(str, str2), 0L, false, null, 0, oVar5, 1572864, 430);
                                p0Var11.u(z13);
                            } else {
                                p0Var13.e0(1410463109);
                                z13 = z14;
                                p0Var11 = p0Var13;
                                IosSettingsKt.m863SettingsRowqhMrWXk(parsedBridge.getError(), null, 0L, null, null, Ios.INSTANCE.getRed(oVar5, i111), false, null, 0, oVar5, 1572864, 414);
                                p0Var11.u(z13);
                                oVar5 = oVar4;
                            }
                            p0Var13 = p0Var11;
                            z14 = z13;
                            z15 = z14;
                            i111 = i111;
                            SettingsGroup = settingsGroupScope;
                        }
                        boolean z16 = z14;
                        p0 p0Var14 = p0Var13;
                        p0Var14.u(z16);
                        for (String str3 : parsedArgoAdd$lambda$163.getFalcons()) {
                            p0Var14.e0(-1252857738);
                            if (!z15) {
                                settingsGroupScope.Separator(oVar5, i110 & 14);
                            }
                            p0Var14.u(z16);
                            IosSettingsKt.m863SettingsRowqhMrWXk(v0.a.p(StoreNetKt.tr("فالکن · ", "Falcon · "), str3), null, 0L, null, StoreNetKt.tr("دامنه\u200cای روی کلادفلر جلوی سرور آرگو — با سنجش معلوم می\u200cشود زنده است یا نه", "A domain on Cloudflare in front of an Argo server — a test tells whether it is alive"), 0L, false, null, 0, oVar5, 1572864, 430);
                            oVar5 = oVar4;
                            z15 = z16;
                        }
                        r0 r0Var4 = v0.f3474a;
                    }
                }), oVar, 384, 3);
                oVar2 = oVar;
            }
            p0Var.u(false);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("ساخت فالکن شخصی", "Make your own falcon"), 0.0f, oVar2, 0, 2);
            androidx.compose.ui.t tVarX3 = f0.x(d3.e(qVar3, 1.0f), f12, 0.0f, 2);
            float f112 = 12;
            androidx.compose.ui.t tVarV2 = f0.v(GlassKt.frostedGlass(tVarX3, e0.e.b(f112), false, false, oVar, 6, 6), f112);
            summary = this.$sum;
            Context context5 = this.$context;
            p0Var.e0(-483455358);
            k0 k0VarA5 = c0.a(bVar, hVar, oVar);
            p0Var.e0(-1323940314);
            iE2 = b1.E(oVar);
            w2 w2VarO8 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM8 = androidx.compose.ui.layout.u.m(tVarV2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var2);
            } else {
                p0Var.t0();
            }
            b1.Y(oVar, pVar4, k0VarA5);
            b1.Y(oVar, rVar, w2VarO8);
            if (p0Var8.M) {
                w0.u(iE2, p0Var8, iE2, mVar2);
            } else {
                w0.u(iE2, p0Var8, iE2, mVar2);
            }
            com.mlmvpn.scanner.e.v(oVar, eVarM8, oVar, 0);
            p0Var.e0(2058660585);
            context = context5;
            e2Var3 = e2Var6;
            k9.b(StoreNetKt.tr("فالکنی که فقط شما و نزدیکانتان بشناسید، دیرتر مسدود می\u200cشود", "A falcon only you and yours know is blocked later"), null, ios2.getLabel(oVar, 6), x6.a.t(15), null, wVar2, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
            i10 = 6;
            k9.b(StoreNetKt.tr("روش رسمی خود آرگو:", "Argo's own official way:"), f0.z(qVar3, 0.0f, f110, 0.0f, 4, 5), ios2.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
            oVar3 = oVar;
            p0Var2 = p0Var;
            p0Var2.e0(-2069466313);
            it = kotlin.collections.r.a0(StoreNetKt.tr("دامنه\u200cای (هر دامنه\u200cای) را به کلادفلر وصل کنید.", "Put a domain (any domain) on Cloudflare."), StoreNetKt.tr("یک رکورد A بسازید که به یکی از آی\u200cپی\u200cهای زیر اشاره کند و «Proxied» (ابر نارنجی) روشن باشد.", "Make an A record pointing at one of the IPs below, with «Proxied» (the orange cloud) on."), StoreNetKt.tr("در کلادفلر SSL/TLS را روی Full بگذارید.", "In Cloudflare, set SSL/TLS to Full."), StoreNetKt.tr("نام همان رکورد (مثلاً argo.example.com) را بالاتر، در «پل یا فالکن خودتان»، وارد کنید و «افزودن و اتصال» را بزنید.", "Enter that record's name (e.g. argo.example.com) above, in «Your own bridge or falcon», and tap «Add and connect».")).iterator();
            i11 = 0;
            while (true) {
                fVar = null;
                if (it.hasNext()) {
                    p0Var3 = p0Var2;
                    p0Var3.u(false);
                    f11 = f8;
                    f0.e(oVar3, d3.g(qVar3, f11));
                    if (summary.getFalconList().isEmpty()) {
                        p0Var3.e0(-2069459715);
                        k9.b(StoreNetKt.tr("فهرست سرورهای فالکن هنوز گرفته نشده — «به\u200cروزرسانی» را بزنید.", "The falcon servers' list has not been fetched yet — tap «Refresh»."), null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                        oVar3 = oVar;
                        z11 = false;
                        p0Var3.u(false);
                        p0Var5 = p0Var3;
                        qVar2 = qVar3;
                        z12 = true;
                    } else {
                        qVar = qVar3;
                        p0Var3.e0(-2069452147);
                        androidx.compose.foundation.layout.f fVarH7 = androidx.compose.foundation.layout.i.h(f10);
                        androidx.compose.foundation.layout.f fVarH8 = androidx.compose.foundation.layout.i.h(f10);
                        p0Var3.e0(1098475987);
                        k0 k0VarC4 = a1.c(fVarH7, fVarH8, oVar3);
                        p0Var3.e0(-1323940314);
                        iE3 = b1.E(oVar3);
                        w2 w2VarO9 = p0Var3.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0Var3 = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM9 = androidx.compose.ui.layout.u.m(qVar);
                        p0Var3.h0();
                        if (p0Var3.M) {
                            p0Var3.n(l0Var3);
                        } else {
                            p0Var3.t0();
                        }
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC4);
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO9);
                        mVar3 = androidx.compose.ui.node.t.i;
                        p0Var4 = p0Var8;
                        if (p0Var4.M) {
                            w0.u(iE3, p0Var4, iE3, mVar3);
                        } else {
                            w0.u(iE3, p0Var4, iE3, mVar3);
                        }
                        num = 0;
                        com.mlmvpn.scanner.e.v(oVar3, eVarM9, oVar3, null);
                        p0Var3.e0(2058660585);
                        p0Var3.e0(-1252782641);
                        while (r27.hasNext()) {
                            androidx.compose.ui.q qVar5 = qVar;
                            androidx.compose.ui.t tVarB2 = androidx.compose.ui.draw.h.b(qVar5, e0.e.b(10));
                            Ios ios4 = Ios.INSTANCE;
                            androidx.compose.ui.t tVarF2 = androidx.compose.foundation.p.f(tVarB2, androidx.compose.ui.graphics.v.c(0.06f, ios4.getLabel(oVar3, 6)), androidx.compose.ui.graphics.d0.f3719a);
                            p0Var3.e0(1410557733);
                            Context context6 = context;
                            zH2 = p0Var3.h(context6) | p0Var3.f(falconOrigin);
                            objI3 = p0Var3.I();
                            if (zH2) {
                                e2Var4 = e2Var3;
                                if (objI3 == e2Var4) {
                                }
                                p0Var3.u(false);
                                androidx.compose.ui.t tVarL3 = androidx.compose.foundation.p.l(tVarF2, false, fVar, (ee.a) objI3, 7);
                                float f113 = f10;
                                androidx.compose.ui.t tVarW3 = f0.w(tVarL3, f11, f113);
                                androidx.compose.ui.i iVar3 = androidx.compose.ui.b.f3549s;
                                p0Var3.e0(693286680);
                                k0 k0VarA6 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar3, oVar3);
                                p0Var3.e0(-1323940314);
                                iE4 = b1.E(oVar3);
                                w2 w2VarO10 = p0Var3.o();
                                androidx.compose.ui.node.u.i.getClass();
                                l0Var4 = androidx.compose.ui.node.t.f4279b;
                                androidx.compose.runtime.internal.e eVarM10 = androidx.compose.ui.layout.u.m(tVarW3);
                                p0Var3.h0();
                                float f114 = f11;
                                if (p0Var3.M) {
                                    p0Var3.n(l0Var4);
                                } else {
                                    p0Var3.t0();
                                }
                                b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA6);
                                b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO10);
                                mVar4 = androidx.compose.ui.node.t.i;
                                if (p0Var4.M) {
                                    w0.u(iE4, p0Var4, iE4, mVar4);
                                } else {
                                    w0.u(iE4, p0Var4, iE4, mVar4);
                                }
                                com.mlmvpn.scanner.e.v(oVar3, eVarM10, oVar3, num);
                                p0Var3.e0(2058660585);
                                Integer num4 = num;
                                context = context6;
                                p0 p0Var11 = p0Var3;
                                k9.b(ArgoScreenKt.flag(falconOrigin.getCc()), null, 0L, x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131062);
                                f0.e(oVar, d3.p(qVar5, f113));
                                k9.b(falconOrigin.getIp(), null, ios4.getLabel(oVar, 6), x6.a.t(12), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 130994);
                                f0.e(oVar, d3.p(qVar5, f113));
                                f10 = f113;
                                k9.b(StoreNetKt.tr(v0.a.h("بار ", ArgoScreenKt.fa(Math.round(falconOrigin.getLoad()))), "load " + Math.round(falconOrigin.getLoad())), null, ios4.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                                oVar3 = oVar;
                                w0.z(p0Var11, false, true, false, false);
                                qVar = qVar5;
                                p0Var3 = p0Var11;
                                fVar = null;
                                e2Var3 = e2Var4;
                                f11 = f114;
                                num = num4;
                                p0Var4 = p0Var4;
                            } else {
                                e2Var4 = e2Var3;
                            }
                            objI3 = new q(context6, falconOrigin);
                            p0Var3.r0(objI3);
                            p0Var3.u(false);
                            androidx.compose.ui.t tVarL4 = androidx.compose.foundation.p.l(tVarF2, false, fVar, (ee.a) objI3, 7);
                            float f115 = f10;
                            androidx.compose.ui.t tVarW4 = f0.w(tVarL4, f11, f115);
                            androidx.compose.ui.i iVar4 = androidx.compose.ui.b.f3549s;
                            p0Var3.e0(693286680);
                            k0 k0VarA7 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar4, oVar3);
                            p0Var3.e0(-1323940314);
                            iE4 = b1.E(oVar3);
                            w2 w2VarO11 = p0Var3.o();
                            androidx.compose.ui.node.u.i.getClass();
                            l0Var4 = androidx.compose.ui.node.t.f4279b;
                            androidx.compose.runtime.internal.e eVarM11 = androidx.compose.ui.layout.u.m(tVarW4);
                            p0Var3.h0();
                            float f116 = f11;
                            if (p0Var3.M) {
                                p0Var3.n(l0Var4);
                            } else {
                                p0Var3.t0();
                            }
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA7);
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO11);
                            mVar4 = androidx.compose.ui.node.t.i;
                            if (p0Var4.M) {
                                w0.u(iE4, p0Var4, iE4, mVar4);
                            } else {
                                w0.u(iE4, p0Var4, iE4, mVar4);
                            }
                            com.mlmvpn.scanner.e.v(oVar3, eVarM11, oVar3, num);
                            p0Var3.e0(2058660585);
                            Integer num5 = num;
                            context = context6;
                            p0 p0Var12 = p0Var3;
                            k9.b(ArgoScreenKt.flag(falconOrigin.getCc()), null, 0L, x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131062);
                            f0.e(oVar, d3.p(qVar5, f115));
                            k9.b(falconOrigin.getIp(), null, ios4.getLabel(oVar, 6), x6.a.t(12), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 130994);
                            f0.e(oVar, d3.p(qVar5, f115));
                            f10 = f115;
                            k9.b(StoreNetKt.tr(v0.a.h("بار ", ArgoScreenKt.fa(Math.round(falconOrigin.getLoad()))), "load " + Math.round(falconOrigin.getLoad())), null, ios4.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                            oVar3 = oVar;
                            w0.z(p0Var12, false, true, false, false);
                            qVar = qVar5;
                            p0Var3 = p0Var12;
                            fVar = null;
                            e2Var3 = e2Var4;
                            f11 = f116;
                            num = num5;
                            p0Var4 = p0Var4;
                        }
                        p0Var5 = p0Var3;
                        qVar2 = qVar;
                        z11 = false;
                        z12 = true;
                        w0.z(p0Var5, false, false, true, false);
                        p0Var5.u(false);
                        p0Var5.u(false);
                    }
                    w0.z(p0Var5, z11, z12, z11, z11);
                    f0.e(oVar3, d3.g(qVar2, 40));
                    r0 r0Var3 = v0.f3474a;
                    return;
                }
                next = it.next();
                i12 = i11 + 1;
                if (i11 >= 0) {
                    kotlin.collections.r.f0();
                    throw null;
                }
                k9.b(f0.a.l(ArgoScreenKt.fa(i12), ". ", (String) next), null, Ios.INSTANCE.getSecondaryLabel(oVar3, i10), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(20), 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 6, 130034);
                p0Var2 = p0Var2;
                oVar3 = oVar;
                i11 = i12;
                i10 = 6;
            }
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoClean$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class C08882 implements ee.f {
        final /* synthetic */ ee.e $connect;
        final /* synthetic */ String $cur;
        final /* synthetic */ k2 $err$delegate;
        final /* synthetic */ ArgoPool.Job $job;
        final /* synthetic */ String $kind;
        final /* synthetic */ k2 $manual$delegate;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ ArgoPool.IpScan $scan;
        final /* synthetic */ ArgoPool.Summary $sum;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoClean$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class C01022 implements ee.f {
            final /* synthetic */ String $cur;
            final /* synthetic */ k2 $err$delegate;
            final /* synthetic */ List<ArgoPool.CleanIp> $list;
            final /* synthetic */ k2 $manual$delegate;
            final /* synthetic */ k2 $note$delegate;

            public C01022(List<ArgoPool.CleanIp> list, String str, k2 k2Var, k2 k2Var2, k2 k2Var3) {
                this.$list = list;
                this.$cur = str;
                this.$err$delegate = k2Var;
                this.$manual$delegate = k2Var2;
                this.$note$delegate = k2Var3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$5$lambda$4$lambda$3$lambda$2(b3 b3Var, ArgoPool.CleanIp cleanIp, k2 k2Var, k2 k2Var2, k2 k2Var3) {
                Object objM1004constructorimpl;
                try {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(ArgoPool.setPrefs$default(ArgoPool.INSTANCE, cleanIp.getIp(), null, 2, null));
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
                }
                Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
                String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                ArgoScreenKt.ArgoClean$lambda$144(k2Var, message);
                if (kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$143(k2Var))) {
                    ArgoScreenKt.ArgoClean$lambda$150(k2Var2, cleanIp.getIp());
                    ArgoScreenKt.ArgoClean$lambda$147(k2Var3, StoreNetKt.tr(w0.n("آی\u200cپی تمیز ", cleanIp.getIp(), " گذاشته شد — اتصال و سنجش از این به بعد از راه آن می\u200cرود. حالا «سنجش دوباره» را بزنید تا سرورهایی که قطع می\u200cشدند دوباره سنجیده شوند."), "Clean IP " + cleanIp.getIp() + " set — connects and tests now go through it. Now tap «Test again» so the servers that were cut are tested again."));
                }
                return sd.u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            public final void invoke(SettingsGroupScope settingsGroupScope, androidx.compose.runtime.o oVar, int i) {
                int i10;
                long j;
                k2 k2Var;
                k2 k2Var2;
                k2 k2Var3;
                SettingsGroupScope SettingsGroup = settingsGroupScope;
                androidx.compose.runtime.o oVar2 = oVar;
                boolean z10 = false;
                Integer num = 0;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                int i11 = (i & 6) == 0 ? i | ((i & 8) == 0 ? ((p0) oVar2).f(SettingsGroup) : ((p0) oVar2).h(SettingsGroup) ? 4 : 2) : i;
                if ((i11 & 19) == 18) {
                    p0 p0Var = (p0) oVar2;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                List<ArgoPool.CleanIp> list = this.$list;
                String str = this.$cur;
                k2 k2Var4 = this.$err$delegate;
                k2 k2Var5 = this.$manual$delegate;
                k2 k2Var6 = this.$note$delegate;
                int i12 = 0;
                for (Object obj : list) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.r.f0();
                        throw null;
                    }
                    final ArgoPool.CleanIp cleanIp = (ArgoPool.CleanIp) obj;
                    p0 p0Var2 = (p0) oVar2;
                    androidx.compose.runtime.a aVar = p0Var2.f3294a;
                    p0Var2.e0(-1423142498);
                    if (i12 > 0) {
                        SettingsGroup.Separator(oVar2, i11 & 14);
                    }
                    p0Var2.u(z10);
                    boolean zZ0 = kotlin.text.o.z0(cleanIp.getIp(), ':');
                    androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarE = d3.e(qVar, 1.0f);
                    p0Var2.e0(-1423138291);
                    k2 k2Var7 = k2Var5;
                    long jC = kotlin.jvm.internal.j.a(str, cleanIp.getIp()) ? androidx.compose.ui.graphics.v.c(0.12f, Ios.INSTANCE.getGreen(oVar2, 6)) : androidx.compose.ui.graphics.v.f3798h;
                    p0Var2.u(z10);
                    androidx.compose.ui.t tVarW = f0.w(androidx.compose.foundation.p.f(tVarE, jC, androidx.compose.ui.graphics.d0.f3719a), 14, 9);
                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                    p0Var2.e0(693286680);
                    k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, oVar2);
                    p0Var2.e0(-1323940314);
                    int iE = b1.E(oVar2);
                    w2 w2VarO = p0Var2.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0 l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var2.h0();
                    if (p0Var2.M) {
                        p0Var2.n(l0Var);
                    } else {
                        p0Var2.t0();
                    }
                    androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
                    b1.Y(oVar2, pVar, k0VarA);
                    androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
                    b1.Y(oVar2, rVar, w2VarO);
                    androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                    if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE))) {
                        w0.u(iE, p0Var2, iE, mVar);
                    }
                    com.mlmvpn.scanner.e.v(oVar2, eVarM, oVar2, num);
                    p0Var2.e0(2058660585);
                    String str2 = zZ0 ? "IPv6" : "IPv4";
                    if (zZ0) {
                        p0Var2.e0(-130308917);
                        long green = Ios.INSTANCE.getGreen(oVar2, 6);
                        i10 = 0;
                        p0Var2.u(false);
                        j = green;
                    } else {
                        i10 = 0;
                        p0Var2.e0(-130308438);
                        long blue = Ios.INSTANCE.getBlue(oVar2, 6);
                        p0Var2.u(false);
                        j = blue;
                    }
                    ArgoScreenKt.m547ChipRPmYEkk(str2, j, oVar2, i10);
                    f0.e(oVar2, d3.p(qVar, 8));
                    if (1.0f <= 0.0d) {
                        throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                    }
                    LayoutWeightElement layoutWeightElementA = com.mlmvpn.scanner.e.a(1.0f, true, p0Var2, -483455358);
                    k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, oVar2);
                    p0Var2.e0(-1323940314);
                    int iE2 = b1.E(oVar2);
                    w2 w2VarO2 = p0Var2.o();
                    androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(layoutWeightElementA);
                    p0Var2.h0();
                    if (p0Var2.M) {
                        p0Var2.n(l0Var);
                    } else {
                        p0Var2.t0();
                    }
                    b1.Y(oVar2, pVar, k0VarA2);
                    b1.Y(oVar2, rVar, w2VarO2);
                    if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE2))) {
                        w0.u(iE2, p0Var2, iE2, mVar);
                    }
                    com.mlmvpn.scanner.e.v(oVar2, eVarM2, oVar2, num);
                    p0Var2.e0(2058660585);
                    b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(oVar2, 2141651952, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoClean$2$2$1$1$1$1
                        @Override // ee.e
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                            return sd.u.f67154a;
                        }

                        public final void invoke(androidx.compose.runtime.o oVar3, int i14) {
                            if ((i14 & 3) == 2) {
                                p0 p0Var3 = (p0) oVar3;
                                if (p0Var3.G()) {
                                    p0Var3.Y();
                                    return;
                                }
                            }
                            r0 r0Var2 = v0.f3474a;
                            k9.b(cleanIp.getIp(), null, Ios.INSTANCE.getLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 2, false, 1, 0, null, null, oVar3, MamiIdentity.RSA_BITS, 3120, 120754);
                        }
                    }), oVar2, 48);
                    String strR = w0.r(androidx.media3.common.s.n("TLS ", ArgoScreenKt.fa(cleanIp.getTls()), " · آرگو ", ArgoScreenKt.fa(cleanIp.getAuth()), " ms · "), ArgoScreenKt.fa(cleanIp.getKbps()), " KB/s");
                    long tls = cleanIp.getTls();
                    Integer num2 = num;
                    long auth = cleanIp.getAuth();
                    k2 k2Var8 = k2Var6;
                    long kbps = cleanIp.getKbps();
                    StringBuilder sbO = f0.a.o(tls, "TLS ", " · Argo ");
                    sbO.append(auth);
                    String strTr = StoreNetKt.tr(strR, androidx.media3.common.s.j(kbps, " ms · ", " KB/s", sbO));
                    Ios ios = Ios.INSTANCE;
                    String str3 = str;
                    k2 k2Var9 = k2Var4;
                    k9.b(strTr, null, ios.getSecondaryLabel(oVar2, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                    w0.z(p0Var2, false, true, false, false);
                    if (kotlin.jvm.internal.j.a(str3, cleanIp.getIp())) {
                        p0Var2.e0(-130286507);
                        ArgoScreenKt.m547ChipRPmYEkk(StoreNetKt.tr("در حال استفاده", "in use"), ios.getGreen(oVar, 6), oVar, 0);
                        p0Var2.u(false);
                        k2Var = k2Var9;
                        k2Var2 = k2Var7;
                        k2Var3 = k2Var8;
                    } else {
                        p0Var2.e0(-130283554);
                        String strTr2 = StoreNetKt.tr("استفاده", "Use");
                        p0Var2.e0(-130282748);
                        boolean zF = p0Var2.f(cleanIp);
                        Object objI = p0Var2.I();
                        if (zF || objI == androidx.compose.runtime.n.f3284a) {
                            k2Var = k2Var9;
                            k2Var2 = k2Var7;
                            k2Var3 = k2Var8;
                            objI = new p(cleanIp, k2Var, k2Var2, k2Var3);
                            p0Var2.r0(objI);
                        } else {
                            k2Var = k2Var9;
                            k2Var2 = k2Var7;
                            k2Var3 = k2Var8;
                        }
                        p0Var2.u(false);
                        ArgoScreenKt.Btn(strTr2, false, false, null, (ee.a) objI, oVar, 0, 14);
                        p0Var2.u(false);
                    }
                    w0.z(p0Var2, false, true, false, false);
                    SettingsGroup = settingsGroupScope;
                    oVar2 = oVar;
                    z10 = false;
                    k2Var5 = k2Var2;
                    str = str3;
                    k2Var6 = k2Var3;
                    k2Var4 = k2Var;
                    i12 = i13;
                    num = num2;
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        public C08882(ArgoPool.IpScan ipScan, ArgoPool.Summary summary, String str, ArgoPool.Job job, k2 k2Var, k2 k2Var2, k2 k2Var3, String str2, ee.e eVar) {
            this.$scan = ipScan;
            this.$sum = summary;
            this.$cur = str;
            this.$job = job;
            this.$err$delegate = k2Var;
            this.$note$delegate = k2Var2;
            this.$manual$delegate = k2Var3;
            this.$kind = str2;
            this.$connect = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$10$lambda$9$lambda$2$lambda$1() {
            ArgoPool.INSTANCE.stopCleanScan();
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$10$lambda$9$lambda$5$lambda$4(c1 c1Var, k2 k2Var, k2 k2Var2) {
            Object objM1004constructorimpl;
            sd.u uVar = sd.u.f67154a;
            try {
                ArgoPool.scanCleanIps$default(ArgoPool.INSTANCE, 0, false, 3, null);
                objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
            if (message == null) {
                message = "";
            }
            ArgoScreenKt.ArgoClean$lambda$144(k2Var, message);
            ArgoScreenKt.ArgoClean$lambda$147(k2Var2, "");
            return uVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(boolean z10) {
            ArgoPool.setPrefs$default(ArgoPool.INSTANCE, null, Boolean.valueOf(z10), 1, null);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$19$lambda$13$lambda$12(c1 c1Var, String str, k2 k2Var) {
            Object objM1004constructorimpl;
            sd.u uVar = sd.u.f67154a;
            try {
                ArgoPool.test$default(ArgoPool.INSTANCE, str, null, null, false, false, false, 62, null);
                objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
            if (message == null) {
                message = "";
            }
            ArgoScreenKt.ArgoClean$lambda$144(k2Var, message);
            return uVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$19$lambda$16$lambda$15(c1 c1Var, k2 k2Var) {
            Object objM1004constructorimpl;
            sd.u uVar = sd.u.f67154a;
            try {
                ArgoPool.test$default(ArgoPool.INSTANCE, null, null, null, false, false, true, 31, null);
                objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
            if (message == null) {
                message = "";
            }
            ArgoScreenKt.ArgoClean$lambda$144(k2Var, message);
            return uVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$19$lambda$18$lambda$17(ee.e eVar) {
            eVar.invoke(null, null);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$31$lambda$24$lambda$23(k2 k2Var, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoClean$lambda$150(k2Var, it);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$31$lambda$30$lambda$27$lambda$26(b3 b3Var, k2 k2Var, k2 k2Var2, k2 k2Var3) {
            Object objM1004constructorimpl;
            String string = kotlin.text.o.n1(ArgoScreenKt.ArgoClean$lambda$149(k2Var)).toString();
            try {
                objM1004constructorimpl = sd.l.m1004constructorimpl(ArgoPool.setPrefs$default(ArgoPool.INSTANCE, string, null, 2, null));
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
            if (message == null) {
                message = "";
            }
            ArgoScreenKt.ArgoClean$lambda$144(k2Var2, message);
            if (kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$143(k2Var2))) {
                ArgoScreenKt.ArgoClean$lambda$147(k2Var3, !kotlin.text.o.L0(string) ? com.mlmvpn.core.aether.i.i("Connects and tests now go through ", string, ".", w0.n("اتصال و سنجش از این به بعد از راه ", string, " می\u200cرود.")) : StoreNetKt.tr("آی\u200cپی تمیز برداشته شد.", "The clean IP was removed."));
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$31$lambda$30$lambda$29$lambda$28(k2 k2Var, k2 k2Var2, k2 k2Var3) {
            ArgoPool.setPrefs$default(ArgoPool.INSTANCE, "", null, 2, null);
            ArgoScreenKt.ArgoClean$lambda$150(k2Var, "");
            ArgoScreenKt.ArgoClean$lambda$144(k2Var2, "");
            ArgoScreenKt.ArgoClean$lambda$147(k2Var3, StoreNetKt.tr("آی\u200cپی تمیز برداشته شد؛ اتصال از نشانی خود دامنه\u200cها می\u200cرود.", "The clean IP was removed; connects use the domains' own addresses."));
            return sd.u.f67154a;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:107:0x063f  */
        /* JADX WARN: Code duplicated, block: B:109:0x0643  */
        /* JADX WARN: Code duplicated, block: B:115:0x0676  */
        /* JADX WARN: Code duplicated, block: B:118:0x068e  */
        /* JADX WARN: Code duplicated, block: B:121:0x06ba  */
        /* JADX WARN: Code duplicated, block: B:128:0x06f3  */
        /* JADX WARN: Code duplicated, block: B:131:0x0709  */
        /* JADX WARN: Code duplicated, block: B:133:0x073e  */
        /* JADX WARN: Code duplicated, block: B:140:0x075c  */
        /* JADX WARN: Code duplicated, block: B:163:0x0864  */
        /* JADX WARN: Code duplicated, block: B:169:0x089f  */
        /* JADX WARN: Code duplicated, block: B:176:0x08cd  */
        /* JADX WARN: Code duplicated, block: B:177:0x08da  */
        /* JADX WARN: Code duplicated, block: B:179:0x0903  */
        /* JADX WARN: Code duplicated, block: B:181:0x0909  */
        /* JADX WARN: Code duplicated, block: B:186:0x0929  */
        /* JADX WARN: Code duplicated, block: B:193:0x09a1  */
        /* JADX WARN: Code duplicated, block: B:194:0x09a5  */
        /* JADX WARN: Code duplicated, block: B:199:0x09c0  */
        /* JADX WARN: Code duplicated, block: B:202:0x09de  */
        /* JADX WARN: Code duplicated, block: B:205:0x0a47  */
        /* JADX WARN: Code duplicated, block: B:206:0x0a4b  */
        /* JADX WARN: Code duplicated, block: B:211:0x0a66  */
        /* JADX WARN: Code duplicated, block: B:214:0x0a88  */
        /* JADX WARN: Code duplicated, block: B:215:0x0a98  */
        /* JADX WARN: Code duplicated, block: B:218:0x0ac2  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v87 */
        /* JADX WARN: Type inference failed for: r2v88 */
        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            Integer num;
            e2 e2Var;
            float f8;
            androidx.compose.ui.node.r rVar;
            k2 k2Var;
            k2 k2Var2;
            Object obj;
            androidx.compose.runtime.o oVar2;
            androidx.compose.ui.node.m mVar;
            boolean z10;
            Object obj2;
            String strConcat;
            String strConcat2;
            boolean z11;
            boolean z12;
            Ios ios;
            boolean z13;
            ArgoPool.IpScan ipScan;
            List<ArgoPool.CleanIp> cleanList;
            List<ArgoPool.CleanIp> list;
            int i10;
            float f10;
            float f11;
            l0 l0Var;
            androidx.compose.ui.node.p pVar;
            Integer num2;
            p0 p0Var;
            androidx.compose.ui.node.r rVar2;
            androidx.compose.ui.node.m mVar2;
            e2 e2Var2;
            androidx.compose.ui.q qVar;
            ?? r4;
            k2 k2Var3;
            k2 k2Var4;
            k2 k2Var5;
            int iE;
            p0 p0Var2;
            Object objI;
            Object obj3;
            androidx.compose.ui.node.m mVar3;
            e2 e2Var3;
            int iE2;
            Object objI2;
            k2 k2Var6;
            k2 k2Var7;
            k2 k2Var8;
            boolean z14;
            Object obj4;
            Object objI3;
            Object obj5;
            ArgoPool.IpScan ipScan2;
            androidx.compose.ui.node.m mVar4;
            androidx.compose.ui.node.r rVar3;
            e2 e2Var4;
            Object obj6;
            androidx.compose.ui.node.m mVar5;
            Object objI4;
            Object obj7;
            boolean zF;
            boolean z15;
            Object obj8;
            ArgoPool.Job testJob;
            int iE3;
            String str;
            String str2;
            boolean z16;
            Object obj9;
            androidx.compose.ui.h hVar = androidx.compose.ui.b.f3551w;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var3 = (p0) oVar;
                if (p0Var3.G()) {
                    p0Var3.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("آی\u200cپی تمیز کلادفلر — رفع فیلتر و سرعت بیشتر", "A clean Cloudflare IP — unblocking and more speed"), 0.0f, oVar, 0, 2);
            androidx.compose.ui.q qVar2 = androidx.compose.ui.q.f4604b;
            float f12 = 16;
            float f13 = 12;
            androidx.compose.ui.t tVarV = f0.v(GlassKt.frostedGlass(f0.x(d3.e(qVar2, 1.0f), f12, 0.0f, 2), e0.e.b(f13), false, false, oVar, 6, 6), f13);
            String str3 = this.$cur;
            ArgoPool.IpScan ipScan3 = this.$scan;
            ArgoPool.Job job = this.$job;
            k2 k2Var9 = this.$err$delegate;
            k2 k2Var10 = this.$note$delegate;
            ArgoPool.Summary summary = this.$sum;
            p0 p0Var4 = (p0) oVar;
            p0Var4.e0(-483455358);
            k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar, oVar);
            p0Var4.e0(-1323940314);
            int iE4 = b1.E(oVar);
            w2 w2VarO = p0Var4.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var2 = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarV);
            p0Var4.h0();
            if (p0Var4.M) {
                p0Var4.n(l0Var2);
            } else {
                p0Var4.t0();
            }
            b1.Y(oVar, androidx.compose.ui.node.t.f4283f, k0VarA);
            b1.Y(oVar, androidx.compose.ui.node.t.f4282e, w2VarO);
            androidx.compose.ui.node.m mVar6 = androidx.compose.ui.node.t.i;
            p0 p0Var5 = (p0) oVar;
            if (p0Var5.M || !kotlin.jvm.internal.j.a(p0Var5.I(), Integer.valueOf(iE4))) {
                w0.u(iE4, p0Var5, iE4, mVar6);
            }
            com.mlmvpn.scanner.e.v(oVar, eVarM, oVar, 0);
            p0Var4.e0(2058660585);
            String strTr = StoreNetKt.tr("یک آی\u200cپی تمیز، همهٔ پل\u200cها و فالکن\u200cها را با هم رفع فیلتر می\u200cکند", "One clean IP unblocks every bridge and falcon at once");
            Ios ios2 = Ios.INSTANCE;
            k2 k2Var11 = k2Var10;
            k9.b(strTr, null, ios2.getLabel(oVar, 6), x6.a.t(15), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
            float f14 = 4;
            int i11 = 6;
            k9.b(StoreNetKt.tr("همهٔ پل\u200cها، فالکن\u200cها و سرورهای آرگو پشت کلادفلرند و کلادفلر هر دامنه را از هر آی\u200cپی خودش می\u200cرساند. وقتی کنار سروری نوشته «وسط دانلود قطع شد»، سرور سالم است ولی اینترنت شما مسیر کلادفلرِ آن را می\u200cبُرد؛ با یک آی\u200cپی تمیز همان سرور کار می\u200cکند.", "Every Argo bridge, falcon and server sits behind Cloudflare, which delivers any domain from any of its IPs. When a server reads «cut part-way», it is alive but your line cuts Cloudflare's path to it; through a clean IP the same server works."), f0.z(qVar2, 0.0f, f14, 0.0f, 0.0f, 13), ios2.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(19), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
            androidx.compose.runtime.o oVar3 = oVar;
            float f15 = 6;
            androidx.compose.ui.q qVar3 = qVar2;
            f0.e(oVar3, d3.g(qVar3, f15));
            p0 p0Var6 = p0Var4;
            p0Var6.e0(-1423231681);
            Iterator it = kotlin.collections.r.a0(StoreNetKt.tr("«اسکن آی\u200cپی تمیز برای آرگو» را بزنید (یک تا سه دقیقه). سه مرحلهٔ واقعی دارد: دست\u200cدهی TLS، دست\u200cدهی خود آرگو، و یک دانلود واقعی.", "Tap «Scan for a clean IP for Argo» (one to three minutes). Three real stages: a TLS handshake, Argo's own handshake, and a real download."), StoreNetKt.tr("در فهرستی که می\u200cآید، کنار سریع\u200cترین (بالاترین KB/s) «استفاده» را بزنید — یا «بهترین را خودکار بگذار» را روشن کنید.", "In the list that comes, tap «Use» beside the fastest (the highest KB/s) — or turn on «Use the best automatically»."), StoreNetKt.tr("«سنجش دوباره» را بزنید: سرورهایی که قطع می\u200cشدند حالا از راه همین آی\u200cپی سنجیده می\u200cشوند. بعد وصل شوید.", "Tap «Test again»: the servers that were cut are now tested through this IP. Then connect.")).iterator();
            int i12 = 0;
            while (true) {
                ArgoPool.Job job2 = null;
                if (!it.hasNext()) {
                    float f16 = f15;
                    androidx.compose.ui.q qVar4 = qVar3;
                    p0 p0Var7 = p0Var6;
                    p0Var7.u(false);
                    float f17 = 10;
                    f0.e(oVar3, d3.g(qVar4, f17));
                    float f18 = 8;
                    androidx.compose.foundation.layout.f fVarH = androidx.compose.foundation.layout.i.h(f18);
                    androidx.compose.foundation.layout.f fVarH2 = androidx.compose.foundation.layout.i.h(f16);
                    p0Var7.e0(1098475987);
                    k0 k0VarC = a1.c(fVarH, fVarH2, oVar3);
                    p0Var7.e0(-1323940314);
                    int iE5 = b1.E(oVar3);
                    w2 w2VarO2 = p0Var7.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0 l0Var3 = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(qVar4);
                    p0Var7.h0();
                    if (p0Var7.M) {
                        p0Var7.n(l0Var3);
                    } else {
                        p0Var7.t0();
                    }
                    androidx.compose.ui.node.p pVar2 = androidx.compose.ui.node.t.f4283f;
                    b1.Y(oVar3, pVar2, k0VarC);
                    androidx.compose.ui.node.r rVar4 = androidx.compose.ui.node.t.f4282e;
                    b1.Y(oVar3, rVar4, w2VarO2);
                    androidx.compose.ui.node.m mVar7 = androidx.compose.ui.node.t.i;
                    if (p0Var5.M || !kotlin.jvm.internal.j.a(p0Var5.I(), Integer.valueOf(iE5))) {
                        w0.u(iE5, p0Var5, iE5, mVar7);
                    }
                    com.mlmvpn.scanner.e.v(oVar3, eVarM2, oVar3, 0);
                    p0Var7.e0(2058660585);
                    e2 e2Var5 = androidx.compose.runtime.n.f3284a;
                    if (ipScan3 == null || !ipScan3.getRunning()) {
                        num = 0;
                        e2Var = e2Var5;
                        f8 = f17;
                        rVar = rVar4;
                        p0Var7.e0(-1385722812);
                        String strTr2 = StoreNetKt.tr("اسکن آی\u200cپی تمیز برای آرگو", "Scan for a clean IP for Argo");
                        androidx.compose.ui.graphics.vector.f fVarG = hb.a.G();
                        boolean z17 = !(job != null && job.getRunning());
                        p0Var7.e0(2033513772);
                        Object objI5 = p0Var7.I();
                        if (objI5 == e2Var) {
                            k2Var = k2Var9;
                            k2Var2 = k2Var11;
                            q qVar5 = new q(k2Var, k2Var2);
                            p0Var7.r0(qVar5);
                            obj = qVar5;
                        } else {
                            k2Var = k2Var9;
                            k2Var2 = k2Var11;
                            obj = objI5;
                        }
                        p0Var7.u(false);
                        k2Var11 = k2Var2;
                        oVar2 = oVar;
                        ArgoScreenKt.Btn(strTr2, true, z17, fVarG, (ee.a) obj, oVar2, 48, 0);
                        p0Var7.u(false);
                    } else {
                        p0Var7.e0(2033505380);
                        String strTr3 = StoreNetKt.tr("توقف اسکن", "Stop the scan");
                        androidx.compose.ui.graphics.vector.f fVarY = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                        p0Var7.e0(2033507395);
                        Object objI6 = p0Var7.I();
                        if (objI6 == e2Var5) {
                            z16 = false;
                            r rVar5 = new r(false ? 1 : 0);
                            p0Var7.r0(rVar5);
                            obj9 = rVar5;
                        } else {
                            z16 = false;
                            obj9 = objI6;
                        }
                        ee.a aVar = (ee.a) obj9;
                        p0Var7.u(z16);
                        e2Var = e2Var5;
                        f8 = f17;
                        rVar = rVar4;
                        num = 0;
                        ArgoScreenKt.Btn(strTr3, false, false, fVarY, aVar, oVar3, 24576, 6);
                        p0Var7.u(z16);
                        oVar2 = oVar;
                        k2Var = k2Var9;
                    }
                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                    p0Var7.e0(693286680);
                    k0 k0VarA2 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, oVar2);
                    p0Var7.e0(-1323940314);
                    int iE6 = b1.E(oVar2);
                    w2 w2VarO3 = p0Var7.o();
                    androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(r12);
                    p0Var7.h0();
                    if (p0Var7.M) {
                        p0Var7.n(l0Var3);
                    } else {
                        p0Var7.t0();
                    }
                    b1.Y(oVar2, pVar2, k0VarA2);
                    b1.Y(oVar2, rVar, w2VarO3);
                    if (r5.M || !kotlin.jvm.internal.j.a(p0Var5.I(), Integer.valueOf(iE6))) {
                        mVar = mVar7;
                        w0.u(iE6, r5, iE6, mVar);
                    } else {
                        mVar = mVar7;
                    }
                    Integer num3 = num;
                    com.mlmvpn.scanner.e.v(oVar2, eVarM3, oVar2, num3);
                    p0Var7.e0(2058660585);
                    boolean autoClean = summary.getPrefs().getAutoClean();
                    p0Var7.e0(-130382005);
                    Object objI7 = p0Var7.I();
                    if (objI7 == e2Var) {
                        z10 = false;
                        s sVar = new s(false ? 1 : 0);
                        p0Var7.r0(sVar);
                        obj2 = sVar;
                    } else {
                        z10 = false;
                        obj2 = objI7;
                    }
                    p0Var7.u(z10);
                    androidx.compose.ui.node.m mVar8 = mVar;
                    e8.a(autoClean, (ee.c) obj2, null, null, false, null, null, oVar, 48, 124);
                    f0.e(oVar, d3.p(r12, f14));
                    String strTr4 = StoreNetKt.tr("بهترین را خودکار بگذار", "Use the best automatically");
                    Ios ios3 = Ios.INSTANCE;
                    androidx.compose.ui.node.r rVar6 = rVar;
                    e2 e2Var6 = e2Var;
                    k2 k2Var12 = k2Var;
                    float f19 = f8;
                    k9.b(strTr4, null, ios3.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                    w0.z(p0Var7, false, true, false, false);
                    w0.z(p0Var7, false, true, false, false);
                    if (kotlin.text.o.L0(str3)) {
                        strConcat = "الان: نشانی خود دامنه\u200cها (بدون آی\u200cپی تمیز)";
                        strConcat2 = "Now: the domains' own addresses (no clean IP)";
                    } else {
                        strConcat = "در حال استفاده: ".concat(str3);
                        strConcat2 = "In use: ".concat(str3);
                    }
                    k9.b(StoreNetKt.tr(strConcat, strConcat2), f0.z(r12, 0.0f, f16, 0.0f, 0.0f, 13), ios3.getSecondaryLabel(oVar, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
                    androidx.compose.runtime.o oVar4 = oVar;
                    p0Var7.e0(-1423185545);
                    if (ipScan3 != null) {
                        z11 = true;
                        if (ipScan3.getRunning()) {
                            String phase = ipScan3.getPhase();
                            if (kotlin.jvm.internal.j.a(phase, "tls")) {
                                str = "دست\u200cدهی TLS با نام سرور آرگو";
                                str2 = "TLS handshake with an Argo server's name";
                            } else if (kotlin.jvm.internal.j.a(phase, "auth")) {
                                str = "دست\u200cدهی خود آرگو از راه بهترین\u200cها";
                                str2 = "Argo's own handshake through the best ones";
                            } else {
                                str = "دانلود واقعی از راه بهترین\u200cها";
                                str2 = "A real download through the best ones";
                            }
                            String strTr5 = StoreNetKt.tr(str, str2);
                            int done = ipScan3.getDone();
                            int total = ipScan3.getTotal();
                            String strFa = ArgoScreenKt.fa(ipScan3.getDone());
                            String strFa2 = ArgoScreenKt.fa(ipScan3.getTotal());
                            String strN = !ipScan3.getFound().isEmpty() ? w0.n(" · ", ArgoScreenKt.fa(ipScan3.getFound().size()), " آی\u200cپی سالم") : "";
                            StringBuilder sbK = d1.k(strTr5, ": ", strFa, " از ", strFa2);
                            sbK.append(strN);
                            z12 = false;
                            ArgoScreenKt.JobLine(done, total, StoreNetKt.tr(sbK.toString(), strTr5 + ": " + ipScan3.getDone() + " of " + ipScan3.getTotal() + (ipScan3.getFound().isEmpty() ? "" : androidx.compose.foundation.interaction.f.o(ipScan3.getFound().size(), " · ", " sound IPs"))), oVar4, 0);
                        }
                        p0Var7.u(z12);
                        if (ipScan3 != null || ipScan3.getRunning() || kotlin.text.o.L0(ipScan3.getError())) {
                            ios = ios3;
                            if (ipScan3 != null || ipScan3.getRunning() || kotlin.text.o.L0(ipScan3.getNote())) {
                                z13 = false;
                                p0Var7.e0(-1168198502);
                            } else {
                                p0Var7.e0(-1423158632);
                                ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.p.r(), ios.getBlue(oVar4, 6), ipScan3.getNote(), null, null, oVar, 0, 24);
                                oVar4 = oVar;
                                z13 = false;
                            }
                            p0Var7.u(z13);
                        } else {
                            p0Var7.e0(-1423162789);
                            ios = ios3;
                            ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.p.r(), ios.getOrange(oVar4, 6), ipScan3.getError(), null, null, oVar, 0, 24);
                            oVar4 = oVar;
                            p0Var7.u(false);
                        }
                        p0Var7.e0(-1423156662);
                        if (!kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$143(k2Var12))) {
                            ArgoScreenKt.m546Callout8V94_ZQ(x6.t.l(), ios.getRed(oVar4, 6), ArgoScreenKt.ArgoClean$lambda$143(k2Var12), null, null, oVar, 0, 24);
                            oVar4 = oVar;
                        }
                        p0Var7.u(false);
                        p0Var7.e0(-1423154126);
                        if (!kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$146(k2Var11))) {
                            ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios.getGreen(oVar4, 6), ArgoScreenKt.ArgoClean$lambda$146(k2Var11), null, null, oVar, 0, 24);
                            oVar4 = oVar;
                        }
                        w0.z(p0Var7, false, false, z11, false);
                        p0Var7.u(false);
                        ipScan = this.$scan;
                        if (ipScan != null || ipScan.getFound().isEmpty()) {
                            cleanList = this.$sum.getCleanList();
                        } else {
                            cleanList = this.$scan.getFound();
                        }
                        list = cleanList;
                        p0Var7.e0(-114735512);
                        if (list.isEmpty()) {
                            i10 = 2;
                            f10 = 0.0f;
                        } else {
                            i10 = 2;
                            f10 = 0.0f;
                            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("نتیجه", "Results"), 0.0f, oVar4, 0, 2);
                            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar4, 202608173, new C01022(list, this.$cur, this.$err$delegate, this.$manual$delegate, this.$note$delegate)), oVar, 384, 3);
                            oVar4 = oVar;
                        }
                        p0Var7.u(false);
                        p0Var7.e0(-114671705);
                        if (!kotlin.text.o.L0(this.$cur) || ((ipScan2 = this.$scan) != null && ipScan2.getRunning() == z11)) {
                            f11 = f12;
                            l0Var = l0Var3;
                            pVar = pVar2;
                            num2 = num3;
                            p0Var = r5;
                            rVar2 = rVar6;
                            mVar2 = mVar8;
                            e2Var2 = e2Var6;
                            qVar = qVar4;
                            r4 = 0;
                        } else {
                            qVar = qVar4;
                            f11 = f12;
                            androidx.compose.ui.t tVarX = f0.x(com.mlmvpn.scanner.e.c(qVar, f19, oVar4, qVar, 1.0f), f11, f10, i10);
                            androidx.compose.foundation.layout.f fVarH3 = androidx.compose.foundation.layout.i.h(f18);
                            androidx.compose.foundation.layout.f fVarH4 = androidx.compose.foundation.layout.i.h(f16);
                            String str4 = this.$kind;
                            ee.e eVar = this.$connect;
                            k2 k2Var13 = this.$err$delegate;
                            p0Var7.e0(1098475987);
                            k0 k0VarC2 = a1.c(fVarH3, fVarH4, oVar4);
                            p0Var7.e0(-1323940314);
                            int iE7 = b1.E(oVar4);
                            w2 w2VarO4 = p0Var7.o();
                            androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(tVarX);
                            p0Var7.h0();
                            if (p0Var7.M) {
                                l0Var = l0Var3;
                                p0Var7.n(l0Var);
                            } else {
                                l0Var = l0Var3;
                                p0Var7.t0();
                            }
                            b1.Y(oVar4, pVar2, k0VarC2);
                            b1.Y(oVar4, rVar6, w2VarO4);
                            if (r5.M || !kotlin.jvm.internal.j.a(r5.I(), Integer.valueOf(iE7))) {
                                mVar4 = mVar8;
                                w0.u(iE7, r5, iE7, mVar4);
                            } else {
                                mVar4 = mVar8;
                            }
                            com.mlmvpn.scanner.e.v(oVar4, eVarM4, oVar4, num3);
                            p0Var7.e0(2058660585);
                            String strTr6 = StoreNetKt.tr("سنجش دوباره همه از راه این آی\u200cپی", "Test all again through this IP");
                            androidx.compose.ui.graphics.vector.f fVarX = com.google.android.gms.internal.auth.j.x();
                            p0Var7.e0(-1423070303);
                            boolean zF2 = p0Var7.f(str4);
                            Object objI8 = p0Var7.I();
                            if (zF2) {
                                rVar3 = rVar6;
                                e2Var4 = e2Var6;
                            } else {
                                rVar3 = rVar6;
                                e2Var4 = e2Var6;
                                obj6 = objI8;
                                if (objI8 == e2Var4) {
                                }
                                p0Var7.u(false);
                                e2Var2 = e2Var4;
                                mVar5 = mVar4;
                                ArgoScreenKt.Btn(strTr6, true, false, fVarX, (ee.a) obj6, oVar4, 48, 4);
                                String strTr7 = StoreNetKt.tr("فقط آن\u200cهایی که قطع می\u200cشدند", "Only the ones that were cut");
                                p0Var7.e0(-1423064701);
                                objI4 = p0Var7.I();
                                obj7 = objI4;
                                if (objI4 == e2Var2) {
                                    t tVar = new t(k2Var13);
                                    p0Var7.r0(tVar);
                                    obj7 = tVar;
                                }
                                p0Var7.u(false);
                                ArgoScreenKt.Btn(strTr7, false, false, null, (ee.a) obj7, oVar, 0, 14);
                                String strTr8 = StoreNetKt.tr("اتصال", "Connect");
                                androidx.compose.ui.graphics.vector.f fVarV = ge.a.v();
                                p0Var7.e0(-1423059169);
                                zF = p0Var7.f(eVar);
                                Object objI9 = p0Var7.I();
                                if (!zF || objI9 == e2Var2) {
                                    z15 = false;
                                    u uVar = new u(eVar, false ? 1 : 0);
                                    p0Var7.r0(uVar);
                                    obj8 = uVar;
                                } else {
                                    z15 = false;
                                    obj8 = objI9;
                                }
                                p0Var7.u(z15);
                                oVar4 = oVar;
                                ArgoScreenKt.Btn(strTr8, false, false, fVarV, (ee.a) obj8, oVar4, 0, 6);
                                w0.z(p0Var7, z15, true, z15, z15);
                                testJob = ArgoPool.INSTANCE.getTestJob();
                                if (testJob != null && testJob.getRunning()) {
                                    job2 = testJob;
                                }
                                if (job2 == null) {
                                    rVar2 = rVar3;
                                    mVar2 = mVar5;
                                    num2 = num3;
                                    p0Var = r5;
                                    pVar = pVar2;
                                    r4 = 0;
                                } else {
                                    androidx.compose.ui.t tVarX2 = f0.x(qVar, f11, 0.0f, 2);
                                    p0Var7.e0(733328855);
                                    k0 k0VarC3 = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar4);
                                    p0Var7.e0(-1323940314);
                                    iE3 = b1.E(oVar4);
                                    w2 w2VarO5 = p0Var7.o();
                                    androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarX2);
                                    p0Var7.h0();
                                    if (p0Var7.M) {
                                        p0Var7.n(l0Var);
                                    } else {
                                        p0Var7.t0();
                                    }
                                    pVar = pVar2;
                                    b1.Y(oVar4, pVar, k0VarC3);
                                    rVar2 = rVar3;
                                    b1.Y(oVar4, rVar2, w2VarO5);
                                    p0Var = r5;
                                    if (p0Var.M && kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(iE3))) {
                                        mVar2 = mVar5;
                                    } else {
                                        mVar2 = mVar5;
                                        w0.u(iE3, p0Var, iE3, mVar2);
                                    }
                                    num2 = num3;
                                    com.mlmvpn.scanner.e.v(oVar4, eVarM5, oVar4, num2);
                                    p0Var7.e0(2058660585);
                                    r4 = 0;
                                    ArgoScreenKt.JobLine(job2.getDone(), job2.getTotal(), ArgoScreenKt.progressWord(job2), oVar4, 0);
                                    w0.z(p0Var7, false, true, false, false);
                                }
                            }
                            q qVar6 = new q(str4, k2Var13);
                            p0Var7.r0(qVar6);
                            obj6 = qVar6;
                            p0Var7.u(false);
                            e2Var2 = e2Var4;
                            mVar5 = mVar4;
                            ArgoScreenKt.Btn(strTr6, true, false, fVarX, (ee.a) obj6, oVar4, 48, 4);
                            String strTr9 = StoreNetKt.tr("فقط آن\u200cهایی که قطع می\u200cشدند", "Only the ones that were cut");
                            p0Var7.e0(-1423064701);
                            objI4 = p0Var7.I();
                            obj7 = objI4;
                            if (objI4 == e2Var2) {
                                t tVar2 = new t(k2Var13);
                                p0Var7.r0(tVar2);
                                obj7 = tVar2;
                            }
                            p0Var7.u(false);
                            ArgoScreenKt.Btn(strTr9, false, false, null, (ee.a) obj7, oVar, 0, 14);
                            String strTr10 = StoreNetKt.tr("اتصال", "Connect");
                            androidx.compose.ui.graphics.vector.f fVarV2 = ge.a.v();
                            p0Var7.e0(-1423059169);
                            zF = p0Var7.f(eVar);
                            Object objI10 = p0Var7.I();
                            if (zF) {
                                z15 = false;
                                u uVar2 = new u(eVar, false ? 1 : 0);
                                p0Var7.r0(uVar2);
                                obj8 = uVar2;
                            } else {
                                z15 = false;
                                u uVar3 = new u(eVar, false ? 1 : 0);
                                p0Var7.r0(uVar3);
                                obj8 = uVar3;
                            }
                            p0Var7.u(z15);
                            oVar4 = oVar;
                            ArgoScreenKt.Btn(strTr10, false, false, fVarV2, (ee.a) obj8, oVar4, 0, 6);
                            w0.z(p0Var7, z15, true, z15, z15);
                            testJob = ArgoPool.INSTANCE.getTestJob();
                            if (testJob != null) {
                                job2 = testJob;
                            }
                            if (job2 == null) {
                                rVar2 = rVar3;
                                mVar2 = mVar5;
                                num2 = num3;
                                p0Var = r5;
                                pVar = pVar2;
                                r4 = 0;
                            } else {
                                androidx.compose.ui.t tVarX3 = f0.x(qVar, f11, 0.0f, 2);
                                p0Var7.e0(733328855);
                                k0 k0VarC4 = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar4);
                                p0Var7.e0(-1323940314);
                                iE3 = b1.E(oVar4);
                                w2 w2VarO6 = p0Var7.o();
                                androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(tVarX3);
                                p0Var7.h0();
                                if (p0Var7.M) {
                                    p0Var7.n(l0Var);
                                } else {
                                    p0Var7.t0();
                                }
                                pVar = pVar2;
                                b1.Y(oVar4, pVar, k0VarC4);
                                rVar2 = rVar3;
                                b1.Y(oVar4, rVar2, w2VarO6);
                                p0Var = r5;
                                if (p0Var.M) {
                                    mVar2 = mVar5;
                                    w0.u(iE3, p0Var, iE3, mVar2);
                                } else {
                                    mVar2 = mVar5;
                                    w0.u(iE3, p0Var, iE3, mVar2);
                                }
                                num2 = num3;
                                com.mlmvpn.scanner.e.v(oVar4, eVarM6, oVar4, num2);
                                p0Var7.e0(2058660585);
                                r4 = 0;
                                ArgoScreenKt.JobLine(job2.getDone(), job2.getTotal(), ArgoScreenKt.progressWord(job2), oVar4, 0);
                                w0.z(p0Var7, false, true, false, false);
                            }
                        }
                        p0Var7.u(r4);
                        IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("آی\u200cپی دستی", "A manual IP"), 0.0f, oVar4, r4, 2);
                        androidx.compose.ui.t tVarX4 = f0.x(d3.e(qVar, 1.0f), f11, 0.0f, 2);
                        k2Var3 = this.$manual$delegate;
                        k2Var4 = this.$err$delegate;
                        k2Var5 = this.$note$delegate;
                        p0Var7.e0(-483455358);
                        k0 k0VarA3 = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar, oVar4);
                        p0Var7.e0(-1323940314);
                        iE = b1.E(oVar4);
                        w2 w2VarO7 = p0Var7.o();
                        androidx.compose.runtime.internal.e eVarM7 = androidx.compose.ui.layout.u.m(tVarX4);
                        p0Var7.h0();
                        if (p0Var7.M) {
                            p0Var7.n(l0Var);
                        } else {
                            p0Var7.t0();
                        }
                        b1.Y(oVar4, pVar, k0VarA3);
                        b1.Y(oVar4, rVar2, w2VarO7);
                        if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var, iE, mVar2);
                        }
                        com.mlmvpn.scanner.e.v(oVar4, eVarM7, oVar4, num2);
                        p0Var7.e0(2058660585);
                        p0Var2 = p0Var;
                        String strArgoClean$lambda$149 = ArgoScreenKt.ArgoClean$lambda$149(k2Var3);
                        p0Var7.e0(-1423047593);
                        objI = p0Var7.I();
                        obj3 = objI;
                        if (objI == e2Var2) {
                            k kVar = new k(1, k2Var3);
                            p0Var7.r0(kVar);
                            obj3 = kVar;
                        }
                        p0Var7.u(false);
                        Integer num4 = num2;
                        mVar3 = mVar2;
                        e2Var3 = e2Var2;
                        ArgoScreenKt.Field(strArgoClean$lambda$149, (ee.c) obj3, StoreNetKt.tr("یا یک آی\u200cپی دستی، مثلاً 104.16.12.34 یا 2606:4700::…", "or a manual IP, e.g. 104.16.12.34 or 2606:4700::…"), 0, null, oVar4, 48, 24);
                        f0.e(oVar4, d3.g(qVar, f18));
                        androidx.compose.foundation.layout.f fVarH5 = androidx.compose.foundation.layout.i.h(f18);
                        p0Var7.e0(693286680);
                        k0 k0VarA4 = a3.a(fVarH5, androidx.compose.ui.b.f3548r, oVar4);
                        p0Var7.e0(-1323940314);
                        iE2 = b1.E(oVar4);
                        w2 w2VarO8 = p0Var7.o();
                        androidx.compose.runtime.internal.e eVarM8 = androidx.compose.ui.layout.u.m(qVar);
                        p0Var7.h0();
                        if (p0Var7.M) {
                            p0Var7.n(l0Var);
                        } else {
                            p0Var7.t0();
                        }
                        b1.Y(oVar4, pVar, k0VarA4);
                        b1.Y(oVar4, rVar2, w2VarO8);
                        if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE2))) {
                            w0.u(iE2, p0Var2, iE2, mVar3);
                        }
                        com.mlmvpn.scanner.e.v(oVar4, eVarM8, oVar4, num4);
                        p0Var7.e0(2058660585);
                        String strTr11 = StoreNetKt.tr("ذخیره", "Save");
                        p0Var7.e0(2033688367);
                        objI2 = p0Var7.I();
                        if (objI2 == e2Var3) {
                            k2Var6 = k2Var3;
                            k2Var7 = k2Var4;
                            k2Var8 = k2Var5;
                            z14 = false;
                            v vVar = new v(k2Var6, k2Var7, k2Var8, false ? 1 : 0);
                            p0Var7.r0(vVar);
                            obj4 = vVar;
                        } else {
                            k2Var6 = k2Var3;
                            k2Var7 = k2Var4;
                            k2Var8 = k2Var5;
                            z14 = false;
                            obj4 = objI2;
                        }
                        p0Var7.u(z14);
                        ArgoScreenKt.Btn(strTr11, false, false, null, (ee.a) obj4, oVar4, 0, 14);
                        String strTr12 = StoreNetKt.tr("بدون آی\u200cپی تمیز", "No clean IP");
                        p0Var7.e0(2033702663);
                        objI3 = p0Var7.I();
                        obj5 = objI3;
                        if (objI3 == e2Var3) {
                            v vVar2 = new v(k2Var6, k2Var7, k2Var8, 1);
                            p0Var7.r0(vVar2);
                            obj5 = vVar2;
                        }
                        p0Var7.u(false);
                        ArgoScreenKt.Btn(strTr12, false, false, null, (ee.a) obj5, oVar, 24576, 14);
                        w0.z(p0Var7, false, true, false, false);
                        w0.z(p0Var7, false, true, false, false);
                        IosSettingsKt.SettingsFooter(StoreNetKt.tr("روی بعضی اینترنت\u200cهای ایران لبهٔ IPv4 کلادفلر دست\u200cدهی را رد می\u200cکند و بعد از ۶۴ کیلوبایت قطع می\u200cشود، ولی IPv6 کار می\u200cکند؛ اسکن هر دو را جدا می\u200cسنجد و فقط آی\u200cپی\u200cای را نشان می\u200cدهد که دانلود واقعی از آن رد شد. آزمون از شبکهٔ واقعی گوشی می\u200cرود، حتی اگر موتور دیگری تونل کامل باز کرده باشد.", "On some Iranian lines Cloudflare's IPv4 edge passes the handshake and then stops after 64 KB, while IPv6 works; the scan measures both apart and shows only an IP a real download came through. The test goes out on the phone's real network, even when another engine holds a full tunnel."), oVar, 0);
                        f0.e(oVar, d3.g(qVar, 40));
                        r0 r0Var2 = v0.f3474a;
                        return;
                    }
                    z11 = true;
                    z12 = false;
                    p0Var7.u(z12);
                    if (ipScan3 != null) {
                        ios = ios3;
                        if (ipScan3 != null) {
                            z13 = false;
                            p0Var7.e0(-1168198502);
                        } else {
                            z13 = false;
                            p0Var7.e0(-1168198502);
                        }
                        p0Var7.u(z13);
                    } else {
                        ios = ios3;
                        if (ipScan3 != null) {
                            z13 = false;
                            p0Var7.e0(-1168198502);
                        } else {
                            z13 = false;
                            p0Var7.e0(-1168198502);
                        }
                        p0Var7.u(z13);
                    }
                    p0Var7.e0(-1423156662);
                    if (!kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$143(k2Var12))) {
                        ArgoScreenKt.m546Callout8V94_ZQ(x6.t.l(), ios.getRed(oVar4, 6), ArgoScreenKt.ArgoClean$lambda$143(k2Var12), null, null, oVar, 0, 24);
                        oVar4 = oVar;
                    }
                    p0Var7.u(false);
                    p0Var7.e0(-1423154126);
                    if (!kotlin.text.o.L0(ArgoScreenKt.ArgoClean$lambda$146(k2Var11))) {
                        ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios.getGreen(oVar4, 6), ArgoScreenKt.ArgoClean$lambda$146(k2Var11), null, null, oVar, 0, 24);
                        oVar4 = oVar;
                    }
                    w0.z(p0Var7, false, false, z11, false);
                    p0Var7.u(false);
                    ipScan = this.$scan;
                    if (ipScan != null) {
                        cleanList = this.$sum.getCleanList();
                    } else {
                        cleanList = this.$sum.getCleanList();
                    }
                    list = cleanList;
                    p0Var7.e0(-114735512);
                    if (list.isEmpty()) {
                        i10 = 2;
                        f10 = 0.0f;
                        IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("نتیجه", "Results"), 0.0f, oVar4, 0, 2);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar4, 202608173, new C01022(list, this.$cur, this.$err$delegate, this.$manual$delegate, this.$note$delegate)), oVar, 384, 3);
                        oVar4 = oVar;
                    } else {
                        i10 = 2;
                        f10 = 0.0f;
                    }
                    p0Var7.u(false);
                    p0Var7.e0(-114671705);
                    if (kotlin.text.o.L0(this.$cur)) {
                        f11 = f12;
                        l0Var = l0Var3;
                        pVar = pVar2;
                        num2 = num3;
                        p0Var = r5;
                        rVar2 = rVar6;
                        mVar2 = mVar8;
                        e2Var2 = e2Var6;
                        qVar = qVar4;
                        r4 = 0;
                    } else {
                        f11 = f12;
                        l0Var = l0Var3;
                        pVar = pVar2;
                        num2 = num3;
                        p0Var = r5;
                        rVar2 = rVar6;
                        mVar2 = mVar8;
                        e2Var2 = e2Var6;
                        qVar = qVar4;
                        r4 = 0;
                    }
                    p0Var7.u(r4);
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("آی\u200cپی دستی", "A manual IP"), 0.0f, oVar4, r4, 2);
                    androidx.compose.ui.t tVarX5 = f0.x(d3.e(qVar, 1.0f), f11, 0.0f, 2);
                    k2Var3 = this.$manual$delegate;
                    k2Var4 = this.$err$delegate;
                    k2Var5 = this.$note$delegate;
                    p0Var7.e0(-483455358);
                    k0 k0VarA5 = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar, oVar4);
                    p0Var7.e0(-1323940314);
                    iE = b1.E(oVar4);
                    w2 w2VarO9 = p0Var7.o();
                    androidx.compose.runtime.internal.e eVarM9 = androidx.compose.ui.layout.u.m(tVarX5);
                    p0Var7.h0();
                    if (p0Var7.M) {
                        p0Var7.n(l0Var);
                    } else {
                        p0Var7.t0();
                    }
                    b1.Y(oVar4, pVar, k0VarA5);
                    b1.Y(oVar4, rVar2, w2VarO9);
                    if (p0Var.M) {
                        w0.u(iE, p0Var, iE, mVar2);
                    } else {
                        w0.u(iE, p0Var, iE, mVar2);
                    }
                    com.mlmvpn.scanner.e.v(oVar4, eVarM9, oVar4, num2);
                    p0Var7.e0(2058660585);
                    p0Var2 = p0Var;
                    String strArgoClean$lambda$1410 = ArgoScreenKt.ArgoClean$lambda$149(k2Var3);
                    p0Var7.e0(-1423047593);
                    objI = p0Var7.I();
                    obj3 = objI;
                    if (objI == e2Var2) {
                        k kVar2 = new k(1, k2Var3);
                        p0Var7.r0(kVar2);
                        obj3 = kVar2;
                    }
                    p0Var7.u(false);
                    Integer num5 = num2;
                    mVar3 = mVar2;
                    e2Var3 = e2Var2;
                    ArgoScreenKt.Field(strArgoClean$lambda$1410, (ee.c) obj3, StoreNetKt.tr("یا یک آی\u200cپی دستی، مثلاً 104.16.12.34 یا 2606:4700::…", "or a manual IP, e.g. 104.16.12.34 or 2606:4700::…"), 0, null, oVar4, 48, 24);
                    f0.e(oVar4, d3.g(qVar, f18));
                    androidx.compose.foundation.layout.f fVarH6 = androidx.compose.foundation.layout.i.h(f18);
                    p0Var7.e0(693286680);
                    k0 k0VarA6 = a3.a(fVarH6, androidx.compose.ui.b.f3548r, oVar4);
                    p0Var7.e0(-1323940314);
                    iE2 = b1.E(oVar4);
                    w2 w2VarO10 = p0Var7.o();
                    androidx.compose.runtime.internal.e eVarM10 = androidx.compose.ui.layout.u.m(qVar);
                    p0Var7.h0();
                    if (p0Var7.M) {
                        p0Var7.n(l0Var);
                    } else {
                        p0Var7.t0();
                    }
                    b1.Y(oVar4, pVar, k0VarA6);
                    b1.Y(oVar4, rVar2, w2VarO10);
                    if (p0Var2.M) {
                        w0.u(iE2, p0Var2, iE2, mVar3);
                    } else {
                        w0.u(iE2, p0Var2, iE2, mVar3);
                    }
                    com.mlmvpn.scanner.e.v(oVar4, eVarM10, oVar4, num5);
                    p0Var7.e0(2058660585);
                    String strTr13 = StoreNetKt.tr("ذخیره", "Save");
                    p0Var7.e0(2033688367);
                    objI2 = p0Var7.I();
                    if (objI2 == e2Var3) {
                        k2Var6 = k2Var3;
                        k2Var7 = k2Var4;
                        k2Var8 = k2Var5;
                        z14 = false;
                        v vVar3 = new v(k2Var6, k2Var7, k2Var8, false ? 1 : 0);
                        p0Var7.r0(vVar3);
                        obj4 = vVar3;
                    } else {
                        k2Var6 = k2Var3;
                        k2Var7 = k2Var4;
                        k2Var8 = k2Var5;
                        z14 = false;
                        obj4 = objI2;
                    }
                    p0Var7.u(z14);
                    ArgoScreenKt.Btn(strTr13, false, false, null, (ee.a) obj4, oVar4, 0, 14);
                    String strTr14 = StoreNetKt.tr("بدون آی\u200cپی تمیز", "No clean IP");
                    p0Var7.e0(2033702663);
                    objI3 = p0Var7.I();
                    obj5 = objI3;
                    if (objI3 == e2Var3) {
                        v vVar4 = new v(k2Var6, k2Var7, k2Var8, 1);
                        p0Var7.r0(vVar4);
                        obj5 = vVar4;
                    }
                    p0Var7.u(false);
                    ArgoScreenKt.Btn(strTr14, false, false, null, (ee.a) obj5, oVar, 24576, 14);
                    w0.z(p0Var7, false, true, false, false);
                    w0.z(p0Var7, false, true, false, false);
                    IosSettingsKt.SettingsFooter(StoreNetKt.tr("روی بعضی اینترنت\u200cهای ایران لبهٔ IPv4 کلادفلر دست\u200cدهی را رد می\u200cکند و بعد از ۶۴ کیلوبایت قطع می\u200cشود، ولی IPv6 کار می\u200cکند؛ اسکن هر دو را جدا می\u200cسنجد و فقط آی\u200cپی\u200cای را نشان می\u200cدهد که دانلود واقعی از آن رد شد. آزمون از شبکهٔ واقعی گوشی می\u200cرود، حتی اگر موتور دیگری تونل کامل باز کرده باشد.", "On some Iranian lines Cloudflare's IPv4 edge passes the handshake and then stops after 64 KB, while IPv6 works; the scan measures both apart and shows only an IP a real download came through. The test goes out on the phone's real network, even when another engine holds a full tunnel."), oVar, 0);
                    f0.e(oVar, d3.g(qVar, 40));
                    r0 r0Var3 = v0.f3474a;
                    return;
                }
                Object next = it.next();
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.r.f0();
                    throw null;
                }
                k9.b(f0.a.l(ArgoScreenKt.fa(i13), ". ", (String) next), null, Ios.INSTANCE.getSecondaryLabel(oVar3, i11), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(20), 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 6, 130034);
                p0Var6 = p0Var6;
                oVar3 = oVar;
                i12 = i13;
                f15 = f15;
                qVar3 = qVar3;
                i11 = 6;
            }
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class C08892 implements ee.f {
        final /* synthetic */ k2 $err$delegate;
        final /* synthetic */ ArgoPool.Job $job;
        final /* synthetic */ String $kind;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ k2 $openCc$delegate;
        final /* synthetic */ k2 $query$delegate;
        final /* synthetic */ RowCtx $rowCtx;
        final /* synthetic */ ee.c $setKind;
        final /* synthetic */ ArgoPool.Summary $sum;
        final /* synthetic */ boolean $testing;
        final /* synthetic */ ArgoPool.Job $upd;
        final /* synthetic */ l4 $version$delegate;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoList$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass1 implements ee.e {
            final /* synthetic */ k2 $note$delegate;
            final /* synthetic */ boolean $testing;

            public AnonymousClass1(boolean z10, k2 k2Var) {
                this.$testing = z10;
                this.$note$delegate = k2Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$1$lambda$0(k2 k2Var) {
                int iRemoveDead = ArgoPool.INSTANCE.removeDead();
                ArgoScreenKt.ArgoList$lambda$106(k2Var, StoreNetKt.tr(v0.a.p(ArgoScreenKt.fa(iRemoveDead), " مورد مرده حذف شد."), iRemoveDead + " dead removed."));
                return sd.u.f67154a;
            }

            @Override // ee.e
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                return sd.u.f67154a;
            }

            public final void invoke(androidx.compose.runtime.o oVar, int i) {
                if ((i & 3) == 2) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                String strTr = StoreNetKt.tr("حذف مرده\u200cها", "Remove the dead");
                androidx.compose.ui.graphics.vector.f fVarR = com.google.android.gms.internal.mlkit_language_id_common.j.r();
                int i10 = 1;
                boolean z10 = !this.$testing;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(654240853);
                k2 k2Var = this.$note$delegate;
                Object objI = p0Var2.I();
                if (objI == androidx.compose.runtime.n.f3284a) {
                    objI = new t(i10, k2Var);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                ArgoScreenKt.Btn(strTr, false, z10, fVarR, (ee.a) objI, oVar, 24576, 2);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoList$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass7 implements ee.f {
            final /* synthetic */ k2 $err$delegate;
            final /* synthetic */ String $kind;
            final /* synthetic */ k2 $openCc$delegate;
            final /* synthetic */ RowCtx $rowCtx;
            final /* synthetic */ ArgoPool.Summary $sum;
            final /* synthetic */ boolean $testing;
            final /* synthetic */ l4 $version$delegate;

            public AnonymousClass7(ArgoPool.Summary summary, boolean z10, k2 k2Var, String str, k2 k2Var2, l4 l4Var, RowCtx rowCtx) {
                this.$sum = summary;
                this.$testing = z10;
                this.$openCc$delegate = k2Var;
                this.$kind = str;
                this.$err$delegate = k2Var2;
                this.$version$delegate = l4Var;
                this.$rowCtx = rowCtx;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$2$lambda$1(SettingsGroupScope settingsGroupScope, k2 k2Var) {
                Object objM1004constructorimpl;
                sd.u uVar = sd.u.f67154a;
                try {
                    ArgoPool.test$default(ArgoPool.INSTANCE, null, null, null, false, true, false, 47, null);
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
            public static final sd.u invoke$lambda$4$lambda$3(k2 k2Var) {
                ArgoScreenKt.ArgoList$lambda$96(k2Var, kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(k2Var), "★") ? null : "★");
                return sd.u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
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
                ee.e eVarM552getLambda3$app_release = ComposableSingletons$ArgoScreenKt.INSTANCE.m552getLambda3$app_release();
                String strTr = StoreNetKt.tr("تأییدشده روی اینترنت ایران (بدون تونل)", "Verified on Iran's internet (no tunnel)");
                String strTr2 = StoreNetKt.tr(f0.a.m(ArgoScreenKt.fa(this.$sum.getCounts().getVerified()), " مورد", this.$sum.getCounts().getVerifiedAt() > 0 ? v0.a.h(" · آزموده ", ArgoScreenKt.dateWord(this.$sum.getCounts().getVerifiedAt())) : "", " · کشورشان از همان آزمون"), this.$sum.getCounts().getVerified() + (this.$sum.getCounts().getVerifiedAt() > 0 ? v0.a.h(" · tested ", ArgoScreenKt.dateWord(this.$sum.getCounts().getVerifiedAt())) : "") + " · their country from that test");
                String strTr3 = StoreNetKt.tr("سنجش روی اینترنت خودم", "Test on my own network");
                boolean z10 = true;
                boolean z11 = this.$testing ^ true;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(654378392);
                int i11 = i10 & 14;
                if (i11 != 4 && ((i10 & 8) == 0 || !p0Var2.h(SettingsGroup))) {
                    z10 = false;
                }
                k2 k2Var = this.$err$delegate;
                Object objI = p0Var2.I();
                e2 e2Var = androidx.compose.runtime.n.f3284a;
                if (z10 || objI == e2Var) {
                    objI = new q(3, SettingsGroup, k2Var);
                    p0Var2.r0(objI);
                }
                ee.a aVar = (ee.a) objI;
                p0Var2.u(false);
                boolean zA = kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(this.$openCc$delegate), "★");
                p0Var2.e0(654382856);
                boolean zF = p0Var2.f(this.$openCc$delegate);
                k2 k2Var2 = this.$openCc$delegate;
                Object objI2 = p0Var2.I();
                if (zF || objI2 == e2Var) {
                    objI2 = new t(2, k2Var2);
                    p0Var2.r0(objI2);
                }
                p0Var2.u(false);
                ArgoScreenKt.GroupHead(eVarM552getLambda3$app_release, strTr, strTr2, strTr3, z11, aVar, zA, (ee.a) objI2, oVar, 6);
                if (kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoList$lambda$95(this.$openCc$delegate), "★")) {
                    long jArgoList$lambda$90 = ArgoScreenKt.ArgoList$lambda$90(this.$version$delegate);
                    p0Var2.e0(654386961);
                    boolean zE = p0Var2.e(jArgoList$lambda$90) | p0Var2.f(this.$kind);
                    String str = this.$kind;
                    Object objI3 = p0Var2.I();
                    if (zE || objI3 == e2Var) {
                        objI3 = ArgoPool.rows$default(ArgoPool.INSTANCE, str, null, null, "verified", Brain.MAX_CELLS, 6, null);
                        p0Var2.r0(objI3);
                    }
                    p0Var2.u(false);
                    List<ArgoPool.Row> list = (List) ((sd.j) objI3).component2();
                    RowCtx rowCtx = this.$rowCtx;
                    for (ArgoPool.Row row : list) {
                        SettingsGroup.Separator(oVar, i11);
                        ArgoScreenKt.ItemRow(row, rowCtx, oVar, 0);
                    }
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        public C08892(String str, ArgoPool.Job job, ArgoPool.Job job2, ArgoPool.Summary summary, k2 k2Var, boolean z10, k2 k2Var2, k2 k2Var3, ee.c cVar, l4 l4Var, RowCtx rowCtx, k2 k2Var4) {
            this.$kind = str;
            this.$job = job;
            this.$upd = job2;
            this.$sum = summary;
            this.$query$delegate = k2Var;
            this.$testing = z10;
            this.$note$delegate = k2Var2;
            this.$err$delegate = k2Var3;
            this.$setKind = cVar;
            this.$version$delegate = l4Var;
            this.$rowCtx = rowCtx;
            this.$openCc$delegate = k2Var4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$1$lambda$0(k2 k2Var, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoList$lambda$103(k2Var, it);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$6$lambda$5$lambda$3$lambda$2(ee.c cVar, String str) {
            cVar.invoke(str);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$8$lambda$7(k2 k2Var, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoList$lambda$100(k2Var, it);
            return sd.u.f67154a;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:139:0x06ae  */
        /* JADX WARN: Code duplicated, block: B:51:0x02f2  */
        /* JADX WARN: Code duplicated, block: B:52:0x02f6  */
        /* JADX WARN: Code duplicated, block: B:57:0x0317  */
        /* JADX WARN: Code duplicated, block: B:60:0x0336  */
        /* JADX WARN: Code duplicated, block: B:62:0x033b  */
        /* JADX WARN: Code duplicated, block: B:65:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:66:0x03b7  */
        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            int i10;
            androidx.compose.runtime.o oVar2;
            String str;
            int i11;
            int bridge;
            String str2;
            String str3;
            String str4;
            int bridge2;
            boolean z10;
            long jC;
            e2 e2Var;
            boolean z11;
            int iE;
            l0 l0Var;
            androidx.compose.ui.node.m mVar;
            androidx.compose.ui.text.font.w wVar;
            Integer num;
            int iIntValue;
            Integer num2 = 0;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var = (p0) oVar;
                if (p0Var.G()) {
                    p0Var.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            float f8 = 10;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            f0.e(oVar, d3.g(qVar, f8));
            String str5 = this.$kind;
            ArgoPool.Job job = this.$job;
            ArgoPool.Job job2 = this.$upd;
            androidx.compose.runtime.internal.e eVarF = x6.p.f(oVar, -1095991219, new AnonymousClass1(this.$testing, this.$note$delegate));
            p0 p0Var2 = (p0) oVar;
            p0Var2.e0(608589288);
            k2 k2Var = this.$err$delegate;
            Object objI = p0Var2.I();
            int i12 = 2;
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (objI == e2Var2) {
                objI = new k(i12, k2Var);
                p0Var2.r0(objI);
            }
            p0Var2.u(false);
            e2 e2Var3 = e2Var2;
            ArgoScreenKt.TestCard(str5, job, job2, eVarF, (ee.c) objI, oVar, 27648, 0);
            androidx.compose.runtime.o oVar3 = oVar;
            IosSettingsKt.SettingsFooter(StoreNetKt.tr(f0.a.l(ArgoScreenKt.fa(this.$sum.getCounts().getAlive()), " سالم از ", ArgoScreenKt.fa(this.$sum.getCounts().getTotal())), this.$sum.getCounts().getAlive() + " healthy of " + this.$sum.getCounts().getTotal()) + (!kotlin.text.o.L0(ArgoScreenKt.ArgoList$lambda$102(this.$err$delegate)) ? v0.a.h("\n", ArgoScreenKt.ArgoList$lambda$102(this.$err$delegate)) : "") + (kotlin.text.o.L0(ArgoScreenKt.ArgoList$lambda$105(this.$note$delegate)) ? "" : v0.a.h("\n", ArgoScreenKt.ArgoList$lambda$105(this.$note$delegate))), oVar3, 0);
            f0.e(oVar3, d3.g(qVar, f8));
            String str6 = "bridge";
            String str7 = "falcon";
            String str8 = "public";
            Map mapJ = kotlin.collections.d0.J(new sd.j(Psi.CrashTracebackLevelAll, Integer.valueOf(this.$sum.getCounts().getTotal())), new sd.j("bridge", Integer.valueOf(this.$sum.getCounts().getBridge())), new sd.j("falcon", Integer.valueOf(this.$sum.getCounts().getFalcon())), new sd.j("public", Integer.valueOf(this.$sum.getCounts().getPublic())));
            float f10 = 16;
            androidx.compose.ui.t tVarX = f0.x(d3.e(qVar, 1.0f), f10, 0.0f, 2);
            float f11 = 6;
            androidx.compose.foundation.layout.f fVarH = androidx.compose.foundation.layout.i.h(f11);
            androidx.compose.foundation.layout.f fVarH2 = androidx.compose.foundation.layout.i.h(f11);
            String str9 = this.$kind;
            ee.c cVar = this.$setKind;
            p0Var2.e0(1098475987);
            k0 k0VarC = a1.c(fVarH, fVarH2, oVar3);
            p0Var2.e0(-1323940314);
            int iE2 = b1.E(oVar3);
            w2 w2VarO = p0Var2.o();
            androidx.compose.ui.node.u.i.getClass();
            Map map = mapJ;
            l0 l0Var2 = androidx.compose.ui.node.t.f4279b;
            float f12 = f10;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarX);
            p0Var2.h0();
            if (p0Var2.M) {
                p0Var2.n(l0Var2);
            } else {
                p0Var2.t0();
            }
            b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
            b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
            androidx.compose.ui.node.m mVar2 = androidx.compose.ui.node.t.i;
            if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE2))) {
                w0.u(iE2, p0Var2, iE2, mVar2);
            }
            com.mlmvpn.scanner.e.v(oVar3, eVarM, oVar3, num2);
            p0Var2.e0(2058660585);
            p0Var2.e0(654269868);
            Iterator it = kotlin.collections.r.a0(Psi.CrashTracebackLevelAll, "bridge", "falcon", "public").iterator();
            while (true) {
                i10 = 3;
                if (!it.hasNext()) {
                    break;
                }
                String str10 = (String) it.next();
                boolean zA = kotlin.jvm.internal.j.a(str9, str10);
                androidx.compose.ui.t tVarB = androidx.compose.ui.draw.h.b(qVar, e0.e.a(50));
                p0Var2.e0(654272950);
                long jC2 = zA ? androidx.compose.ui.graphics.v.c(0.22f, Ios.INSTANCE.getBlue(oVar3, 6)) : androidx.compose.ui.graphics.v.f3798h;
                p0Var2.u(false);
                androidx.compose.ui.t tVarF = androidx.compose.foundation.p.f(tVarB, jC2, androidx.compose.ui.graphics.d0.f3719a);
                float f13 = 1;
                if (zA) {
                    p0Var2.e0(-478602996);
                    jC = androidx.compose.ui.graphics.v.c(0.6f, Ios.INSTANCE.getBlue(oVar3, 6));
                    z10 = false;
                } else {
                    z10 = false;
                    p0Var2.e0(-478601907);
                    jC = androidx.compose.ui.graphics.v.c(0.18f, Ios.INSTANCE.getLabel(oVar3, 6));
                }
                p0Var2.u(z10);
                androidx.compose.ui.t tVarH = androidx.compose.foundation.p.h(tVarF, f13, jC, e0.e.a(50));
                androidx.compose.ui.semantics.f fVar = new androidx.compose.ui.semantics.f(3);
                p0Var2.e0(-478598680);
                boolean zF = p0Var2.f(cVar) | p0Var2.f(str10);
                Object objI2 = p0Var2.I();
                if (zF) {
                    e2Var = e2Var3;
                } else {
                    e2Var = e2Var3;
                    if (objI2 != e2Var) {
                        z11 = false;
                    }
                    p0Var2.u(z11);
                    androidx.compose.ui.t tVarW = f0.w(androidx.compose.foundation.p.l(tVarH, z11, fVar, (ee.a) objI2, 3), 12, 5);
                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                    p0Var2.e0(693286680);
                    k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, oVar3);
                    p0Var2.e0(-1323940314);
                    iE = b1.E(oVar3);
                    w2 w2VarO2 = p0Var2.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var2.h0();
                    String str11 = str9;
                    if (p0Var2.M) {
                        p0Var2.n(l0Var);
                    } else {
                        p0Var2.t0();
                    }
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA);
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO2);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE))) {
                        w0.u(iE, p0Var2, iE, mVar);
                    }
                    com.mlmvpn.scanner.e.v(oVar3, eVarM2, oVar3, num2);
                    p0Var2.e0(2058660585);
                    String strKindAll = ArgoScreenKt.kindAll(str10);
                    Ios ios = Ios.INSTANCE;
                    long label = ios.getLabel(oVar3, 6);
                    long jS = x6.a.s(12.5d);
                    if (zA) {
                        wVar = androidx.compose.ui.text.font.w.f4818n;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4815e;
                    }
                    e2 e2Var4 = e2Var;
                    String str12 = str7;
                    String str13 = str8;
                    Integer num3 = num2;
                    androidx.compose.ui.q qVar2 = qVar;
                    p0 p0Var3 = p0Var2;
                    ee.c cVar2 = cVar;
                    Map map2 = map;
                    float f14 = f12;
                    String str14 = str6;
                    k9.b(strKindAll, null, label, jS, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131026);
                    f0.e(oVar, d3.p(qVar2, 4));
                    num = (Integer) map2.get(str10);
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    k9.b(ArgoScreenKt.fa(iIntValue), null, ios.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                    oVar3 = oVar;
                    w0.z(p0Var3, false, true, false, false);
                    qVar = qVar2;
                    p0Var2 = p0Var3;
                    num2 = num3;
                    cVar = cVar2;
                    str9 = str11;
                    map = map2;
                    f12 = f14;
                    str8 = str13;
                    str7 = str12;
                    str6 = str14;
                    e2Var3 = e2Var4;
                }
                z11 = false;
                objI2 = new w(null == true ? 1 : 0, str10, cVar);
                p0Var2.r0(objI2);
                p0Var2.u(z11);
                androidx.compose.ui.t tVarW2 = f0.w(androidx.compose.foundation.p.l(tVarH, z11, fVar, (ee.a) objI2, 3), 12, 5);
                androidx.compose.ui.i iVar2 = androidx.compose.ui.b.f3549s;
                p0Var2.e0(693286680);
                k0 k0VarA2 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar2, oVar3);
                p0Var2.e0(-1323940314);
                iE = b1.E(oVar3);
                w2 w2VarO3 = p0Var2.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarW2);
                p0Var2.h0();
                String str15 = str9;
                if (p0Var2.M) {
                    p0Var2.n(l0Var);
                } else {
                    p0Var2.t0();
                }
                b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA2);
                b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO3);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var2.M) {
                    w0.u(iE, p0Var2, iE, mVar);
                } else {
                    w0.u(iE, p0Var2, iE, mVar);
                }
                com.mlmvpn.scanner.e.v(oVar3, eVarM3, oVar3, num2);
                p0Var2.e0(2058660585);
                String strKindAll2 = ArgoScreenKt.kindAll(str10);
                Ios ios2 = Ios.INSTANCE;
                long label2 = ios2.getLabel(oVar3, 6);
                long jS2 = x6.a.s(12.5d);
                if (zA) {
                    wVar = androidx.compose.ui.text.font.w.f4818n;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4815e;
                }
                e2 e2Var5 = e2Var;
                String str16 = str7;
                String str17 = str8;
                Integer num4 = num2;
                androidx.compose.ui.q qVar3 = qVar;
                p0 p0Var4 = p0Var2;
                ee.c cVar3 = cVar;
                Map map3 = map;
                float f15 = f12;
                String str18 = str6;
                k9.b(strKindAll2, null, label2, jS2, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131026);
                f0.e(oVar, d3.p(qVar3, 4));
                num = (Integer) map3.get(str10);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 0;
                }
                k9.b(ArgoScreenKt.fa(iIntValue), null, ios2.getSecondaryLabel(oVar, 6), x6.a.t(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                oVar3 = oVar;
                w0.z(p0Var4, false, true, false, false);
                qVar = qVar3;
                p0Var2 = p0Var4;
                num2 = num4;
                cVar = cVar3;
                str9 = str15;
                map = map3;
                f12 = f15;
                str8 = str17;
                str7 = str16;
                str6 = str18;
                e2Var3 = e2Var5;
            }
            String str19 = str6;
            String str20 = str7;
            String str21 = str8;
            androidx.compose.ui.q qVar4 = qVar;
            p0 p0Var5 = p0Var2;
            float f16 = f12;
            e2 e2Var6 = e2Var3;
            w0.z(p0Var5, false, false, true, false);
            p0Var5.u(false);
            f0.e(oVar3, d3.g(qVar4, 8));
            String strArgoList$lambda$99 = ArgoScreenKt.ArgoList$lambda$99(this.$query$delegate);
            p0Var5.e0(608640394);
            boolean zF2 = p0Var5.f(this.$query$delegate);
            k2 k2Var2 = this.$query$delegate;
            Object objI3 = p0Var5.I();
            if (zF2 || objI3 == e2Var6) {
                objI3 = new k(i10, k2Var2);
                p0Var5.r0(objI3);
            }
            p0Var5.u(false);
            ArgoScreenKt.Field(strArgoList$lambda$99, (ee.c) objI3, StoreNetKt.tr("جست\u200cوجوی دامنه…", "Search a domain…"), 0, f0.x(qVar4, f16, 0.0f, 2), oVar, 24576, 8);
            IosSettingsKt.SettingsFooter(StoreNetKt.tr("«سنجش» واقعی است، نه پینگ: اول دست\u200cدهی خود آرگو با هر نشانی (یعنی سرور آرگو زنده است و از همین اینترنت می\u200cرسد)، بعد برای هر کدام که پذیرفت یک درخواست واقعی HTTPS از داخل خودش — کشور هر مورد همان جایی است که واقعاً از آن بیرون آمد. پل\u200cها و فالکن\u200cهای تازه\u200cتر اول سنجیده می\u200cشوند.", "A test is real, not a ping: first Argo's own handshake with each address (the Argo server is alive and reachable from this network), then for each that accepted, a real HTTPS request through it — each one's country is where it really came out. Newer bridges and falcons are tested first."), oVar, 0);
            String string = kotlin.text.o.n1(ArgoScreenKt.ArgoList$lambda$99(this.$query$delegate)).toString();
            if (string.length() > 0) {
                p0Var5.e0(1688766805);
                long jArgoList$lambda$90 = ArgoScreenKt.ArgoList$lambda$90(this.$version$delegate);
                p0Var5.e0(608666377);
                boolean zE = p0Var5.e(jArgoList$lambda$90) | p0Var5.f(this.$kind) | p0Var5.f(string);
                String str22 = this.$kind;
                Object objI4 = p0Var5.I();
                if (zE || objI4 == e2Var6) {
                    objI4 = ArgoPool.rows$default(ArgoPool.INSTANCE, str22, null, string, null, Brain.MAX_CELLS, 10, null);
                    p0Var5.r0(objI4);
                }
                sd.j jVar = (sd.j) objI4;
                p0Var5.u(false);
                int iIntValue2 = ((Number) jVar.component1()).intValue();
                final List list = (List) jVar.component2();
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr(d1.g("جست\u200cوجوی «", string, "» · ", ArgoScreenKt.fa(iIntValue2)), "Search «" + string + "» · " + iIntValue2), 0.0f, oVar, 0, 2);
                final RowCtx rowCtx = this.$rowCtx;
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar, -747412769, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.ArgoList.2.6
                    @Override // ee.f
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar4, int i13) {
                        androidx.compose.runtime.o oVar5;
                        p0 p0Var6;
                        kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                        int i14 = (i13 & 6) == 0 ? i13 | ((i13 & 8) == 0 ? ((p0) oVar4).f(SettingsGroup) : ((p0) oVar4).h(SettingsGroup) ? 4 : 2) : i13;
                        if ((i14 & 19) == 18) {
                            p0 p0Var7 = (p0) oVar4;
                            if (p0Var7.G()) {
                                p0Var7.Y();
                                return;
                            }
                        }
                        r0 r0Var2 = v0.f3474a;
                        p0 p0Var8 = (p0) oVar4;
                        p0Var8.e0(654329375);
                        if (list.isEmpty()) {
                            p0Var6 = p0Var8;
                            oVar5 = oVar4;
                            IosSettingsKt.m863SettingsRowqhMrWXk(StoreNetKt.tr("چیزی پیدا نشد.", "Nothing found."), null, 0L, null, null, 0L, false, null, 0, oVar5, 1572864, 446);
                        } else {
                            oVar5 = oVar4;
                            p0Var6 = p0Var8;
                        }
                        p0Var6.u(false);
                        List<ArgoPool.Row> list2 = list;
                        RowCtx rowCtx2 = rowCtx;
                        int i15 = 0;
                        for (Object obj : list2) {
                            int i16 = i15 + 1;
                            if (i15 < 0) {
                                kotlin.collections.r.f0();
                                throw null;
                            }
                            ArgoPool.Row row = (ArgoPool.Row) obj;
                            p0Var6.e0(654334001);
                            if (i15 > 0) {
                                SettingsGroup.Separator(oVar5, i14 & 14);
                            }
                            p0Var6.u(false);
                            ArgoScreenKt.ItemRow(row, rowCtx2, oVar5, 0);
                            i15 = i16;
                        }
                        r0 r0Var3 = v0.f3474a;
                    }
                }), oVar, 384, 3);
                p0Var5.u(false);
                oVar2 = oVar;
            } else {
                p0Var5.e0(1689329889);
                List<ArgoPool.Group> groups = this.$sum.getGroups();
                String str23 = this.$kind;
                ArrayList arrayList = new ArrayList();
                for (Object obj : groups) {
                    ArgoPool.Group group = (ArgoPool.Group) obj;
                    int iHashCode = str23.hashCode();
                    if (iHashCode != -1380801655) {
                        str2 = str21;
                        if (iHashCode == -1281896239) {
                            str3 = str20;
                            if (str23.equals(str3)) {
                                bridge2 = group.getFalcon();
                                str4 = str19;
                            }
                            str4 = str19;
                        } else if (iHashCode == -977423767 && str23.equals(str2)) {
                            bridge2 = group.getPublic();
                            str3 = str20;
                            str4 = str19;
                        } else {
                            str3 = str20;
                            str4 = str19;
                        }
                    } else {
                        str2 = str21;
                        str3 = str20;
                        str4 = str19;
                        bridge2 = str23.equals(str4) ? group.getBridge() : group.getN();
                    }
                    if (bridge2 > 0) {
                        arrayList.add(obj);
                    }
                    str19 = str4;
                    str21 = str2;
                    str20 = str3;
                }
                String str24 = str21;
                String str25 = str20;
                String str26 = str19;
                p0Var5.e0(608685766);
                if (arrayList.isEmpty()) {
                    oVar2 = oVar;
                    str = str26;
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, ComposableSingletons$ArgoScreenKt.INSTANCE.m551getLambda2$app_release(), oVar2, 384, 3);
                } else {
                    oVar2 = oVar;
                    str = str26;
                }
                p0Var5.u(false);
                p0Var5.e0(608696186);
                if (this.$sum.getCounts().getVerified() > 0) {
                    f0.e(oVar2, d3.g(qVar4, 14));
                    i11 = 14;
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -1481011270, new AnonymousClass7(this.$sum, this.$testing, this.$openCc$delegate, this.$kind, this.$err$delegate, this.$version$delegate, this.$rowCtx)), oVar2, 384, 3);
                } else {
                    i11 = 14;
                }
                p0Var5.u(false);
                String str27 = this.$kind;
                boolean z12 = this.$testing;
                k2 k2Var3 = this.$openCc$delegate;
                k2 k2Var4 = this.$err$delegate;
                l4 l4Var = this.$version$delegate;
                RowCtx rowCtx2 = this.$rowCtx;
                int size = arrayList.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj2 = arrayList.get(i13);
                    i13++;
                    ArgoPool.Group group2 = (ArgoPool.Group) obj2;
                    int i14 = size;
                    f0.e(oVar2, d3.g(qVar4, i11));
                    int iHashCode2 = str27.hashCode();
                    if (iHashCode2 != -1380801655) {
                        if (iHashCode2 != -1281896239) {
                            if (iHashCode2 == -977423767 && str27.equals(str24)) {
                                bridge = group2.getPublic();
                            } else {
                                bridge = group2.getN();
                            }
                        } else if (str27.equals(str25)) {
                            bridge = group2.getFalcon();
                        } else {
                            bridge = group2.getN();
                        }
                    } else if (str27.equals(str)) {
                        bridge = group2.getBridge();
                    } else {
                        bridge = group2.getN();
                    }
                    String str28 = str27;
                    k2 k2Var5 = k2Var3;
                    k2 k2Var6 = k2Var4;
                    l4 l4Var2 = l4Var;
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 1039680016, new ArgoScreenKt$ArgoList$2$8$1(group2, bridge, z12, str28, k2Var5, k2Var6, l4Var2, rowCtx2)), oVar2, 384, 3);
                    size = i14;
                    str27 = str28;
                    k2Var3 = k2Var5;
                    k2Var4 = k2Var6;
                    l4Var = l4Var2;
                    i11 = 14;
                }
                p0Var5.u(false);
            }
            f0.e(oVar2, d3.g(qVar4, 40));
            r0 r0Var2 = v0.f3474a;
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class AnonymousClass3 implements ee.f {
        final /* synthetic */ List<ArgoPool.Row> $best;
        final /* synthetic */ l4 $conn$delegate;
        final /* synthetic */ ee.e $connect;
        final /* synthetic */ boolean $connected;
        final /* synthetic */ boolean $connecting;
        final /* synthetic */ Context $context;
        final /* synthetic */ k2 $err$delegate;
        final /* synthetic */ ee.c $go;
        final /* synthetic */ ArgoPool.Job $job;
        final /* synthetic */ String $kind;
        final /* synthetic */ l4 $lastWhy$delegate;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ ArgoPool.IpScan $scan;
        final /* synthetic */ boolean $suggested;
        final /* synthetic */ ArgoPool.Summary $sum;
        final /* synthetic */ boolean $testing;
        final /* synthetic */ ArgoPool.Job $upd;
        final /* synthetic */ View $v;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass2 implements ee.f {
            final /* synthetic */ l4 $conn$delegate;
            final /* synthetic */ ee.e $connect;
            final /* synthetic */ k2 $err$delegate;
            final /* synthetic */ String $failed;
            final /* synthetic */ boolean $frozenHint;
            final /* synthetic */ ee.c $go;
            final /* synthetic */ ArgoPool.Job $job;
            final /* synthetic */ l4 $lastWhy$delegate;
            final /* synthetic */ k2 $note$delegate;

            public AnonymousClass2(String str, ee.e eVar, boolean z10, ArgoPool.Job job, ee.c cVar, k2 k2Var, l4 l4Var, l4 l4Var2, k2 k2Var2) {
                this.$failed = str;
                this.$connect = eVar;
                this.$frozenHint = z10;
                this.$job = job;
                this.$go = cVar;
                this.$err$delegate = k2Var;
                this.$lastWhy$delegate = l4Var;
                this.$conn$delegate = l4Var2;
                this.$note$delegate = k2Var2;
            }

            private static final void invoke$gap(kotlin.jvm.internal.u uVar, SettingsGroupScope settingsGroupScope, androidx.compose.runtime.o oVar, int i) {
                p0 p0Var = (p0) oVar;
                p0Var.e0(924517385);
                r0 r0Var = v0.f3474a;
                if (!uVar.element) {
                    settingsGroupScope.Separator(p0Var, 0);
                }
                uVar.element = false;
                p0Var.u(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$1$lambda$0(ee.e eVar) {
                eVar.invoke(null, null);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$4$lambda$3(SettingsGroupScope settingsGroupScope, ee.c cVar, k2 k2Var) {
                Object objM1004constructorimpl;
                sd.u uVar = sd.u.f67154a;
                try {
                    ArgoPool.scanCleanIps$default(ArgoPool.INSTANCE, 0, false, 3, null);
                    objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
                }
                Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
                String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                ArgoScreenKt.ArgoMain$lambda$46(k2Var, message);
                cVar.invoke(Page.CLEAN);
                return uVar;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
                int i10;
                int i11;
                int i12;
                int i13;
                String str;
                String str2;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                if ((i & 6) == 0) {
                    i10 = i | ((i & 8) == 0 ? ((p0) oVar).f(SettingsGroup) : ((p0) oVar).h(SettingsGroup) ? 4 : 2);
                } else {
                    i10 = i;
                }
                if ((i10 & 19) == 18) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                uVar.element = true;
                int i14 = 0;
                if (kotlin.text.o.L0(ArgoScreenKt.ArgoMain$lambda$45(this.$err$delegate))) {
                    i11 = 6;
                    if (this.$failed != null) {
                        p0 p0Var2 = (p0) oVar;
                        p0Var2.e0(-2055444691);
                        invoke$gap(uVar, SettingsGroup, oVar, 0);
                        ArgoScreenKt.m546Callout8V94_ZQ(x6.t.l(), Ios.INSTANCE.getRed(oVar, 6), v0.a.p(StoreNetKt.tr("وصل نشد: ", "Not connected: "), this.$failed), null, null, oVar, 0, 24);
                        p0Var2.u(false);
                    } else {
                        p0 p0Var3 = (p0) oVar;
                        p0Var3.e0(-2055353396);
                        p0Var3.u(false);
                    }
                } else {
                    p0 p0Var4 = (p0) oVar;
                    p0Var4.e0(-2055542155);
                    invoke$gap(uVar, SettingsGroup, oVar, 0);
                    i11 = 6;
                    ArgoScreenKt.m546Callout8V94_ZQ(x6.t.l(), Ios.INSTANCE.getRed(oVar, 6), ArgoScreenKt.ArgoMain$lambda$45(this.$err$delegate), null, null, oVar, 0, 24);
                    p0Var4.u(false);
                }
                p0 p0Var5 = (p0) oVar;
                p0Var5.e0(487888483);
                if (ArgoScreenKt.ArgoMain$lambda$40(this.$lastWhy$delegate) != null && (ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate) instanceof ArgoEngine.Conn.Idle)) {
                    invoke$gap(uVar, SettingsGroup, oVar, 0);
                    androidx.compose.ui.graphics.vector.f fVarR = com.google.android.gms.internal.auth.p.r();
                    long orange = Ios.INSTANCE.getOrange(oVar, i11);
                    if (kotlin.jvm.internal.j.a(ArgoScreenKt.ArgoMain$lambda$40(this.$lastWhy$delegate), "replaced")) {
                        str = "اتصال دیگری موتور را گرفت؛ آرگو کنار رفت.";
                        str2 = "Another connection took the engine; Argo stepped aside.";
                    } else {
                        str = "موتور متوقف شد؛ اتصال آرگو تمام شد.";
                        str2 = "The engine stopped; Argo's connection ended.";
                    }
                    ArgoScreenKt.m546Callout8V94_ZQ(fVarR, orange, StoreNetKt.tr(str, str2), null, null, oVar, 0, 24);
                }
                p0Var5.u(false);
                p0Var5.e0(487899588);
                ArgoEngine.Conn connArgoMain$lambda$39 = ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate);
                ArgoEngine.Conn.Connected connected = connArgoMain$lambda$39 instanceof ArgoEngine.Conn.Connected ? (ArgoEngine.Conn.Connected) connArgoMain$lambda$39 : null;
                boolean z10 = connected != null && connected.getLost();
                e2 e2Var = androidx.compose.runtime.n.f3284a;
                if (z10) {
                    invoke$gap(uVar, SettingsGroup, oVar, 0);
                    androidx.compose.ui.graphics.vector.f fVarL = x6.t.l();
                    long orange2 = Ios.INSTANCE.getOrange(oVar, i11);
                    String strTr = StoreNetKt.tr("سرور فعلی جواب نمی\u200cدهد.", "The current server stopped answering.");
                    String strTr2 = StoreNetKt.tr("اتصال دوباره", "Reconnect");
                    p0Var5.e0(487906189);
                    boolean zF = p0Var5.f(this.$connect);
                    ee.e eVar = this.$connect;
                    Object objI = p0Var5.I();
                    if (zF || objI == e2Var) {
                        i13 = 1;
                        objI = new u(eVar, i13);
                        p0Var5.r0(objI);
                    } else {
                        i13 = 1;
                    }
                    p0Var5.u(false);
                    i12 = i13;
                    ArgoScreenKt.m546Callout8V94_ZQ(fVarL, orange2, strTr, strTr2, (ee.a) objI, oVar, 0, 0);
                } else {
                    i12 = 1;
                }
                p0Var5.u(false);
                p0Var5.e0(487907595);
                if (!kotlin.text.o.L0(ArgoScreenKt.ArgoMain$lambda$48(this.$note$delegate))) {
                    invoke$gap(uVar, SettingsGroup, oVar, 0);
                    ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), Ios.INSTANCE.getGreen(oVar, 6), ArgoScreenKt.ArgoMain$lambda$48(this.$note$delegate), null, null, oVar, 0, 24);
                }
                p0Var5.u(false);
                if (this.$frozenHint) {
                    invoke$gap(uVar, SettingsGroup, oVar, 0);
                    androidx.compose.ui.graphics.vector.f fVarB = x6.o.f71260c;
                    if (fVarB == null) {
                        androidx.compose.ui.graphics.vector.e eVar2 = new androidx.compose.ui.graphics.vector.e("Filled.ContentCut", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 224);
                        kotlin.collections.w wVar = o1.f3904a;
                        x0 x0Var = new x0(androidx.compose.ui.graphics.v.f3792b);
                        androidx.compose.ui.graphics.vector.g gVarC = g1.c(9.64f, 7.64f);
                        gVarC.f(0.23f, -0.5f, 0.36f, -1.05f, 0.36f, -1.64f);
                        gVarC.f(0.0f, -2.21f, -1.79f, -4.0f, -4.0f, -4.0f);
                        gVarC.m(2.0f, 3.79f, 2.0f, 6.0f);
                        gVarC.n(1.79f, 4.0f, 4.0f, 4.0f);
                        gVarC.f(0.59f, 0.0f, 1.14f, -0.13f, 1.64f, -0.36f);
                        gVarC.i(10.0f, 12.0f);
                        gVarC.j(-2.36f, 2.36f);
                        gVarC.e(7.14f, 14.13f, 6.59f, 14.0f, 6.0f, 14.0f);
                        gVarC.f(-2.21f, 0.0f, -4.0f, 1.79f, -4.0f, 4.0f);
                        gVarC.n(1.79f, 4.0f, 4.0f, 4.0f);
                        gVarC.n(4.0f, -1.79f, 4.0f, -4.0f);
                        gVarC.f(0.0f, -0.59f, -0.13f, -1.14f, -0.36f, -1.64f);
                        gVarC.i(12.0f, 14.0f);
                        gVarC.j(7.0f, 7.0f);
                        gVarC.h(3.0f);
                        gVarC.p(-1.0f);
                        f0.a.D(gVarC, 9.64f, 7.64f, 6.0f, 8.0f);
                        gVarC.f(-1.1f, 0.0f, -2.0f, -0.89f, -2.0f, -2.0f);
                        gVarC.n(0.9f, -2.0f, 2.0f, -2.0f);
                        gVarC.n(2.0f, 0.89f, 2.0f, 2.0f);
                        gVarC.n(-0.9f, 2.0f, -2.0f, 2.0f);
                        gVarC.d();
                        gVarC.k(6.0f, 20.0f);
                        gVarC.f(-1.1f, 0.0f, -2.0f, -0.89f, -2.0f, -2.0f);
                        gVarC.n(0.9f, -2.0f, 2.0f, -2.0f);
                        gVarC.n(2.0f, 0.89f, 2.0f, 2.0f);
                        gVarC.n(-0.9f, 2.0f, -2.0f, 2.0f);
                        gVarC.d();
                        gVarC.k(12.0f, 12.5f);
                        gVarC.f(-0.28f, 0.0f, -0.5f, -0.22f, -0.5f, -0.5f);
                        gVarC.n(0.22f, -0.5f, 0.5f, -0.5f);
                        gVarC.n(0.5f, 0.22f, 0.5f, 0.5f);
                        gVarC.n(-0.22f, 0.5f, -0.5f, 0.5f);
                        f0.a.C(gVarC, 19.0f, 3.0f, -6.0f, 6.0f);
                        gVarC.j(2.0f, 2.0f);
                        g1.C(gVarC, 7.0f, -7.0f, 22.0f, 3.0f);
                        androidx.compose.ui.graphics.vector.e.a(eVar2, gVarC.f3849a, 0, x0Var);
                        fVarB = eVar2.b();
                        x6.o.f71260c = fVarB;
                    }
                    long orange3 = Ios.INSTANCE.getOrange(oVar, 6);
                    ArgoPool.Job job = this.$job;
                    kotlin.jvm.internal.j.b(job);
                    String strP = v0.a.p(ArgoScreenKt.fa(job.getFrozen()), " مورد جواب داد ولی وسط دانلود قطع شد. یعنی سرورها زنده\u200cاند ولی این اینترنت مسیر کلادفلرِ همان دامنه\u200cها را می\u200cبُرد (روی بعضی اینترنت\u200cها لبهٔ IPv4 کلادفلر بعد از ۶۴ کیلوبایت قطع می\u200cشود). «اسکن آی\u200cپی تمیز» یک لبهٔ سالم پیدا می\u200cکند که همه را با هم رفع فیلتر کند.");
                    ArgoPool.Job job2 = this.$job;
                    kotlin.jvm.internal.j.b(job2);
                    String strE = com.mlmvpn.core.aether.i.e(job2.getFrozen(), " answered and were then cut part-way: the servers are alive, but this line cuts Cloudflare's path to those domains (on some lines Cloudflare's IPv4 edge stops after 64 KB). «Scan for a clean IP» finds a sound edge that unblocks them all at once.", strP);
                    String strTr3 = StoreNetKt.tr("اسکن آی\u200cپی تمیز", "Scan for a clean IP");
                    p0Var5.e0(487937628);
                    if ((i10 & 14) != 4 && ((i10 & 8) == 0 || !p0Var5.h(SettingsGroup))) {
                        i12 = 0;
                    }
                    int i15 = i12 | (p0Var5.f(this.$go) ? 1 : 0);
                    ee.c cVar = this.$go;
                    k2 k2Var = this.$err$delegate;
                    Object objI2 = p0Var5.I();
                    if (i15 != 0 || objI2 == e2Var) {
                        objI2 = new y(i14, k2Var, SettingsGroup, cVar);
                        p0Var5.r0(objI2);
                    }
                    p0Var5.u(false);
                    ArgoScreenKt.m546Callout8V94_ZQ(fVarB, orange3, strE, strTr3, (ee.a) objI2, oVar, 0, 0);
                }
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass4 implements ee.f {
            final /* synthetic */ List<ArgoPool.Row> $best;
            final /* synthetic */ ee.e $connect;
            final /* synthetic */ boolean $connecting;
            final /* synthetic */ ee.c $go;
            final /* synthetic */ boolean $suggested;
            final /* synthetic */ ArgoPool.Summary $sum;

            public AnonymousClass4(List<ArgoPool.Row> list, ArgoPool.Summary summary, ee.c cVar, boolean z10, boolean z11, ee.e eVar) {
                this.$best = list;
                this.$sum = summary;
                this.$go = cVar;
                this.$suggested = z10;
                this.$connecting = z11;
                this.$connect = eVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$2$lambda$1$lambda$0(ee.e eVar, ArgoPool.Row row) {
                eVar.invoke(row.getId(), null);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$4$lambda$3(ee.c cVar) {
                cVar.invoke(Page.LIST);
                return sd.u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
            /* JADX WARN: Type inference failed for: r11v17 */
            /* JADX WARN: Type inference failed for: r11v18, types: [ee.a] */
            /* JADX WARN: Type inference failed for: r11v19 */
            /* JADX WARN: Type inference failed for: r1v1 */
            /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.runtime.p0] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v17 */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
            public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
                int i10;
                androidx.compose.runtime.o oVar2;
                ?? r4;
                String str;
                long jMsTone;
                String strP;
                boolean z10;
                ?? r11;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                if ((i & 6) == 0) {
                    i10 = i | ((i & 8) == 0 ? ((p0) oVar).f(SettingsGroup) : ((p0) oVar).h(SettingsGroup) ? 4 : 2);
                } else {
                    i10 = i;
                }
                if ((i10 & 19) == 18) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(487967814);
                if (this.$best.isEmpty()) {
                    r4 = p0Var2;
                    oVar2 = oVar;
                    IosSettingsKt.m863SettingsRowqhMrWXk(StoreNetKt.tr("هنوز موردی روی این اینترنت سالم نیست — «سنجش» را بزنید.", "Nothing healthy on this network yet — tap «Test»."), null, 0L, null, null, 0L, false, null, 0, oVar2, 1572864, 446);
                } else {
                    oVar2 = oVar;
                    r4 = p0Var2;
                }
                ?? r8 = 0;
                r4.u(false);
                r4.e0(487974529);
                List<ArgoPool.Row> list = this.$best;
                boolean z11 = this.$suggested;
                boolean z12 = this.$connecting;
                ee.e eVar = this.$connect;
                Iterator it = list.iterator();
                int i11 = 0;
                while (true) {
                    boolean zHasNext = it.hasNext();
                    e2 e2Var = androidx.compose.runtime.n.f3284a;
                    if (!zHasNext) {
                        ?? r10 = r8;
                        r4.u(r10);
                        SettingsGroup.Separator(oVar2, i10 & 14);
                        String strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cها", "Bridges and falcons");
                        androidx.compose.ui.graphics.vector.f fVarV = k6.a.v();
                        long indigo = Ios.INSTANCE.getIndigo(oVar2, 6);
                        String strFa = ArgoScreenKt.fa(this.$sum.getCounts().getTotal());
                        String strTr2 = StoreNetKt.tr(androidx.compose.foundation.interaction.f.r(" عمومی · ", ArgoScreenKt.fa(this.$sum.getCounts().getAlive()), " زنده", d1.k(ArgoScreenKt.fa(this.$sum.getCounts().getBridge()), " پل · ", ArgoScreenKt.fa(this.$sum.getCounts().getFalcon()), " فالکن · ", ArgoScreenKt.fa(this.$sum.getCounts().getPublic()))), this.$sum.getCounts().getBridge() + " bridges · " + this.$sum.getCounts().getFalcon() + " falcons · " + this.$sum.getCounts().getPublic() + " public · " + this.$sum.getCounts().getAlive() + " alive");
                        r4.e0(488011335);
                        boolean zF = r4.f(this.$go);
                        ee.c cVar = this.$go;
                        Object objI = r4.I();
                        Object obj = objI;
                        if (zF || objI == e2Var) {
                            z zVar = new z(cVar, r10 == true ? 1 : 0);
                            r4.r0(zVar);
                            obj = zVar;
                        }
                        r4.u(r10);
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr, fVarV, indigo, strFa, strTr2, 0L, false, (ee.a) obj, 0, oVar, 0, 352);
                        r0 r0Var2 = v0.f3474a;
                        return;
                    }
                    Object next = it.next();
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.r.f0();
                        throw null;
                    }
                    ArgoPool.Row row = (ArgoPool.Row) next;
                    r4.e0(487975180);
                    if (i11 > 0) {
                        SettingsGroup.Separator(oVar2, i10 & 14);
                    }
                    r4.u(r8);
                    String strL = f0.a.l(ArgoScreenKt.flag(row.getCc()), "  ", row.getHost());
                    androidx.compose.ui.graphics.vector.f fVarR = z11 ? fc.a.r() : hb.a.y();
                    if (z11) {
                        r4.e0(1755673467);
                        jMsTone = Ios.INSTANCE.getOrange(oVar2, 6);
                        r4.u(r8);
                        strL = strL;
                        str = null;
                    } else {
                        r4.e0(1755673862);
                        Long ms = row.getMs();
                        str = null;
                        jMsTone = ArgoScreenKt.msTone(ms != null ? ms.longValue() : 0L, oVar2, r8);
                        r4.u(r8);
                    }
                    if (z11) {
                        strP = StoreNetKt.tr("تأییدشده روی اینترنت ایران", "verified on Iran's internet");
                    } else {
                        Long ms2 = row.getMs();
                        strP = v0.a.p(ArgoScreenKt.fa(ms2 != null ? ms2.longValue() : 0L), " ms");
                    }
                    String strF0 = kotlin.collections.q.F0(kotlin.collections.o.b0(new String[]{strP, ArgoScreenKt.kindOne(row.getKind()), ArgoScreenKt.country(row.getCc()), (i11 != 0 || z11) ? str : StoreNetKt.tr("سریع\u200cترین", "fastest")}), " · ", null, null, null, 62);
                    r4.e0(487993065);
                    if (z12) {
                        r11 = str;
                        z10 = false;
                    } else {
                        r4.e0(1755685676);
                        boolean zF2 = r4.f(eVar) | r4.f(row);
                        Object objI2 = r4.I();
                        Object obj2 = objI2;
                        if (zF2 || objI2 == e2Var) {
                            q qVar = new q(5, eVar, row);
                            r4.r0(qVar);
                            obj2 = qVar;
                        }
                        z10 = false;
                        r4.u(false);
                        r11 = (ee.a) obj2;
                    }
                    r4.u(z10);
                    IosSettingsKt.m863SettingsRowqhMrWXk(strL, fVarR, jMsTone, null, strF0, 0L, false, r11, 0, oVar2, 0, 360);
                    r8 = z10;
                    i11 = i12;
                    z11 = z11;
                    z12 = z12;
                    eVar = eVar;
                }
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$3$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass5 implements ee.f {
            final /* synthetic */ k2 $err$delegate;
            final /* synthetic */ ee.c $go;
            final /* synthetic */ ArgoPool.IpScan $scan;
            final /* synthetic */ ArgoPool.Summary $sum;
            final /* synthetic */ boolean $testing;

            public AnonymousClass5(ArgoPool.Summary summary, ee.c cVar, ArgoPool.IpScan ipScan, boolean z10, k2 k2Var) {
                this.$sum = summary;
                this.$go = cVar;
                this.$scan = ipScan;
                this.$testing = z10;
                this.$err$delegate = k2Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$2$lambda$1(ee.c cVar) {
                cVar.invoke(Page.CLEAN);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$5$lambda$4(SettingsGroupScope settingsGroupScope, ee.c cVar, k2 k2Var) {
                Object objM1004constructorimpl;
                sd.u uVar = sd.u.f67154a;
                try {
                    ArgoPool.scanCleanIps$default(ArgoPool.INSTANCE, 0, false, 3, null);
                    objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
                } catch (Throwable th2) {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
                }
                Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
                String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                ArgoScreenKt.ArgoMain$lambda$46(k2Var, message);
                cVar.invoke(Page.CLEAN);
                return uVar;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            /* JADX WARN: Code duplicated, block: B:35:0x00ce  */
            /* JADX WARN: Code duplicated, block: B:37:0x00d7  */
            /* JADX WARN: Code duplicated, block: B:43:0x00f4  */
            /* JADX WARN: Code duplicated, block: B:46:0x00fa  */
            /* JADX WARN: Code duplicated, block: B:51:0x0106  */
            /* JADX WARN: Code duplicated, block: B:53:0x0109  */
            /* JADX WARN: Code duplicated, block: B:54:0x010c  */
            /* JADX WARN: Code duplicated, block: B:63:0x0126  */
            /* JADX WARN: Code duplicated, block: B:68:0x013c  */
            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
                int i10;
                int i11;
                boolean z10;
                String str;
                String str2;
                ArgoPool.IpScan ipScan;
                boolean z11;
                boolean z12;
                int i12;
                int i13;
                ee.c cVar;
                k2 k2Var;
                Object objI;
                ArgoPool.IpScan ipScan2;
                int i14;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                if ((i & 6) == 0) {
                    i10 = i | ((i & 8) == 0 ? ((p0) oVar).f(SettingsGroup) : ((p0) oVar).h(SettingsGroup) ? 4 : 2);
                } else {
                    i10 = i;
                }
                if ((i10 & 19) == 18) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                String strTr = StoreNetKt.tr("آی\u200cپی تمیز کلادفلر", "Clean Cloudflare IP");
                androidx.compose.ui.graphics.vector.f fVarY = hb.a.y();
                Ios ios = Ios.INSTANCE;
                long teal = ios.getTeal(oVar, 6);
                String cleanIp = this.$sum.getPrefs().getCleanIp();
                if (kotlin.text.o.L0(cleanIp)) {
                    cleanIp = null;
                }
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(488037192);
                boolean zF = p0Var2.f(this.$go);
                ee.c cVar2 = this.$go;
                Object objI2 = p0Var2.I();
                e2 e2Var = androidx.compose.runtime.n.f3284a;
                int i15 = 1;
                if (zF || objI2 == e2Var) {
                    objI2 = new z(cVar2, i15);
                    p0Var2.r0(objI2);
                }
                p0Var2.u(false);
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr, fVarY, teal, cleanIp, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 368);
                int i16 = i10 & 14;
                SettingsGroup.Separator(oVar, i16);
                ArgoPool.IpScan ipScan3 = this.$scan;
                if (ipScan3 != null) {
                    i11 = 1;
                    z10 = ipScan3.getRunning();
                    if (z10) {
                        str = "در حال اسکن…";
                        str2 = "Scanning…";
                    } else {
                        str = "اسکن آی\u200cپی تمیز";
                        str2 = "Scan for a clean IP";
                    }
                    String strTr2 = StoreNetKt.tr(str, str2);
                    androidx.compose.ui.graphics.vector.f fVarG = hb.a.G();
                    long teal2 = ios.getTeal(oVar, 6);
                    ipScan = this.$scan;
                    if (ipScan == null && ipScan.getRunning() == i11) {
                        z11 = i11;
                    } else {
                        z11 = 0;
                    }
                    if (this.$testing) {
                        z12 = 0;
                    } else {
                        ipScan2 = this.$scan;
                        if (ipScan2 == null && ipScan2.getRunning() == i11) {
                            i14 = i11;
                        } else {
                            i14 = 0;
                        }
                        if (i14 == 0) {
                            z12 = i11;
                        } else {
                            z12 = 0;
                        }
                    }
                    p0Var2.e0(488048160);
                    if (i16 != 4 || ((i10 & 8) != 0 && p0Var2.h(SettingsGroup))) {
                        i12 = i11;
                    } else {
                        i12 = 0;
                    }
                    i13 = i12 | (p0Var2.f(this.$go) ? 1 : 0);
                    cVar = this.$go;
                    k2Var = this.$err$delegate;
                    objI = p0Var2.I();
                    if (i13 == 0 || objI == e2Var) {
                        objI = new y(i11, k2Var, SettingsGroup, cVar);
                        p0Var2.r0(objI);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr2, fVarG, teal2, null, z11, z12, false, (ee.a) objI, oVar, 0, 72);
                }
                i11 = 1;
                if (z10) {
                    str = "در حال اسکن…";
                    str2 = "Scanning…";
                } else {
                    str = "اسکن آی\u200cپی تمیز";
                    str2 = "Scan for a clean IP";
                }
                String strTr3 = StoreNetKt.tr(str, str2);
                androidx.compose.ui.graphics.vector.f fVarG2 = hb.a.G();
                long teal3 = ios.getTeal(oVar, 6);
                ipScan = this.$scan;
                if (ipScan == null) {
                    z11 = 0;
                } else {
                    z11 = 0;
                }
                if (this.$testing) {
                    z12 = 0;
                } else {
                    ipScan2 = this.$scan;
                    if (ipScan2 == null) {
                        i14 = 0;
                    } else {
                        i14 = 0;
                    }
                    if (i14 == 0) {
                        z12 = i11;
                    } else {
                        z12 = 0;
                    }
                }
                p0Var2.e0(488048160);
                if (i16 != 4) {
                    i12 = i11;
                } else {
                    i12 = i11;
                }
                i13 = i12 | (p0Var2.f(this.$go) ? 1 : 0);
                cVar = this.$go;
                k2Var = this.$err$delegate;
                objI = p0Var2.I();
                if (i13 == 0) {
                    objI = new y(i11, k2Var, SettingsGroup, cVar);
                    p0Var2.r0(objI);
                } else {
                    objI = new y(i11, k2Var, SettingsGroup, cVar);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr3, fVarG2, teal3, null, z11, z12, false, (ee.a) objI, oVar, 0, 72);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoMain$3$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass6 implements ee.f {
            final /* synthetic */ ee.c $go;

            public AnonymousClass6(ee.c cVar) {
                this.$go = cVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$1$lambda$0(ee.c cVar) {
                cVar.invoke(Page.LIST);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$3$lambda$2(ee.c cVar) {
                cVar.invoke(Page.CLEAN);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$5$lambda$4(ee.c cVar) {
                cVar.invoke(Page.ADD);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$7$lambda$6(ee.c cVar) {
                cVar.invoke(Page.SOURCES);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$9$lambda$8(ee.c cVar) {
                cVar.invoke(Page.LOGS);
                return sd.u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            /* JADX WARN: Code duplicated, block: B:33:0x013d  */
            /* JADX WARN: Code duplicated, block: B:36:0x0142  */
            /* JADX WARN: Code duplicated, block: B:40:0x019f  */
            /* JADX WARN: Code duplicated, block: B:43:0x01a4  */
            /* JADX WARN: Code duplicated, block: B:47:0x0201  */
            /* JADX WARN: Code duplicated, block: B:49:0x0205  */
            public final void invoke(SettingsGroupScope SettingsGroup, androidx.compose.runtime.o oVar, int i) {
                int i10;
                e2 e2Var;
                e2 e2Var2;
                boolean zF;
                Object objI;
                e2 e2Var3;
                e2 e2Var4;
                boolean zF2;
                Object objI2;
                e2 e2Var5;
                int i11;
                boolean zF3;
                ee.c cVar;
                Object objI3;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                int i12 = 2;
                if ((i & 6) == 0) {
                    i10 = i | ((i & 8) == 0 ? ((p0) oVar).f(SettingsGroup) : ((p0) oVar).h(SettingsGroup) ? 4 : 2);
                } else {
                    i10 = i;
                }
                if ((i10 & 19) == 18) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                String strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cها", "Bridges and falcons");
                androidx.compose.ui.graphics.vector.f fVarV = k6.a.v();
                Ios ios = Ios.INSTANCE;
                long blue = ios.getBlue(oVar, 6);
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(488070407);
                boolean zF4 = p0Var2.f(this.$go);
                ee.c cVar2 = this.$go;
                Object objI4 = p0Var2.I();
                e2 e2Var6 = androidx.compose.runtime.n.f3284a;
                if (zF4 || objI4 == e2Var6) {
                    objI4 = new z(cVar2, i12);
                    p0Var2.r0(objI4);
                }
                p0Var2.u(false);
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr, fVarV, blue, null, null, 0L, false, (ee.a) objI4, 0, oVar, 0, 376);
                int i13 = i10 & 14;
                SettingsGroup.Separator(oVar, i13);
                String strTr2 = StoreNetKt.tr("آی\u200cپی تمیز (رفع فیلتر)", "Clean IP (unblocking)");
                androidx.compose.ui.graphics.vector.f fVarY = hb.a.y();
                long teal = ios.getTeal(oVar, 6);
                p0Var2.e0(488076296);
                boolean zF5 = p0Var2.f(this.$go);
                ee.c cVar3 = this.$go;
                Object objI5 = p0Var2.I();
                if (!zF5) {
                    e2Var = e2Var6;
                    if (objI5 == e2Var) {
                    }
                    p0Var2.u(false);
                    e2Var2 = e2Var;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr2, fVarY, teal, null, null, 0L, false, (ee.a) objI5, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr3 = StoreNetKt.tr("افزودن پل یا فالکن", "Add a bridge or falcon");
                    androidx.compose.ui.graphics.vector.f fVarL = k6.a.l();
                    long orange = ios.getOrange(oVar, 6);
                    p0Var2.e0(488082150);
                    zF = p0Var2.f(this.$go);
                    ee.c cVar4 = this.$go;
                    objI = p0Var2.I();
                    if (!zF) {
                        e2Var3 = e2Var2;
                        if (objI == e2Var3) {
                        }
                        p0Var2.u(false);
                        e2Var4 = e2Var3;
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr3, fVarL, orange, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
                        SettingsGroup.Separator(oVar, i13);
                        String strTr4 = StoreNetKt.tr("منابع و به\u200cروزرسانی", "Sources & refresh");
                        androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                        long indigo = ios.getIndigo(oVar, 6);
                        p0Var2.e0(488087946);
                        zF2 = p0Var2.f(this.$go);
                        ee.c cVar5 = this.$go;
                        objI2 = p0Var2.I();
                        if (!zF2) {
                            e2Var5 = e2Var4;
                            if (objI2 == e2Var5) {
                            }
                            p0Var2.u(false);
                            e2 e2Var7 = e2Var5;
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr4, fVarE, indigo, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                            SettingsGroup.Separator(oVar, i13);
                            String strTr5 = StoreNetKt.tr("لاگ", "Log");
                            androidx.compose.ui.graphics.vector.f fVarU = x6.a.u();
                            i11 = 6;
                            long purple = ios.getPurple(oVar, 6);
                            p0Var2.e0(488092935);
                            zF3 = p0Var2.f(this.$go);
                            cVar = this.$go;
                            objI3 = p0Var2.I();
                            if (zF3 || objI3 == e2Var7) {
                                objI3 = new z(cVar, i11);
                                p0Var2.r0(objI3);
                            }
                            p0Var2.u(false);
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr5, fVarU, purple, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                        }
                        e2Var5 = e2Var4;
                        objI2 = new z(cVar5, 5);
                        p0Var2.r0(objI2);
                        p0Var2.u(false);
                        e2 e2Var8 = e2Var5;
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr4, fVarE, indigo, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                        SettingsGroup.Separator(oVar, i13);
                        String strTr6 = StoreNetKt.tr("لاگ", "Log");
                        androidx.compose.ui.graphics.vector.f fVarU2 = x6.a.u();
                        i11 = 6;
                        long purple2 = ios.getPurple(oVar, 6);
                        p0Var2.e0(488092935);
                        zF3 = p0Var2.f(this.$go);
                        cVar = this.$go;
                        objI3 = p0Var2.I();
                        if (zF3) {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        } else {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr6, fVarU2, purple2, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                    }
                    e2Var3 = e2Var2;
                    objI = new z(cVar4, 4);
                    p0Var2.r0(objI);
                    p0Var2.u(false);
                    e2Var4 = e2Var3;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr3, fVarL, orange, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr7 = StoreNetKt.tr("منابع و به\u200cروزرسانی", "Sources & refresh");
                    androidx.compose.ui.graphics.vector.f fVarE2 = x6.q.E();
                    long indigo2 = ios.getIndigo(oVar, 6);
                    p0Var2.e0(488087946);
                    zF2 = p0Var2.f(this.$go);
                    ee.c cVar6 = this.$go;
                    objI2 = p0Var2.I();
                    if (!zF2) {
                        e2Var5 = e2Var4;
                        if (objI2 == e2Var5) {
                        }
                        p0Var2.u(false);
                        e2 e2Var9 = e2Var5;
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr7, fVarE2, indigo2, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                        SettingsGroup.Separator(oVar, i13);
                        String strTr8 = StoreNetKt.tr("لاگ", "Log");
                        androidx.compose.ui.graphics.vector.f fVarU3 = x6.a.u();
                        i11 = 6;
                        long purple3 = ios.getPurple(oVar, 6);
                        p0Var2.e0(488092935);
                        zF3 = p0Var2.f(this.$go);
                        cVar = this.$go;
                        objI3 = p0Var2.I();
                        if (zF3) {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        } else {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr8, fVarU3, purple3, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                    }
                    e2Var5 = e2Var4;
                    objI2 = new z(cVar6, 5);
                    p0Var2.r0(objI2);
                    p0Var2.u(false);
                    e2 e2Var10 = e2Var5;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr7, fVarE2, indigo2, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr9 = StoreNetKt.tr("لاگ", "Log");
                    androidx.compose.ui.graphics.vector.f fVarU4 = x6.a.u();
                    i11 = 6;
                    long purple4 = ios.getPurple(oVar, 6);
                    p0Var2.e0(488092935);
                    zF3 = p0Var2.f(this.$go);
                    cVar = this.$go;
                    objI3 = p0Var2.I();
                    if (zF3) {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    } else {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr9, fVarU4, purple4, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                }
                e2Var = e2Var6;
                objI5 = new z(cVar3, 3);
                p0Var2.r0(objI5);
                p0Var2.u(false);
                e2Var2 = e2Var;
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr2, fVarY, teal, null, null, 0L, false, (ee.a) objI5, 0, oVar, 0, 376);
                SettingsGroup.Separator(oVar, i13);
                String strTr10 = StoreNetKt.tr("افزودن پل یا فالکن", "Add a bridge or falcon");
                androidx.compose.ui.graphics.vector.f fVarL2 = k6.a.l();
                long orange2 = ios.getOrange(oVar, 6);
                p0Var2.e0(488082150);
                zF = p0Var2.f(this.$go);
                ee.c cVar7 = this.$go;
                objI = p0Var2.I();
                if (!zF) {
                    e2Var3 = e2Var2;
                    if (objI == e2Var3) {
                    }
                    p0Var2.u(false);
                    e2Var4 = e2Var3;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr10, fVarL2, orange2, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr11 = StoreNetKt.tr("منابع و به\u200cروزرسانی", "Sources & refresh");
                    androidx.compose.ui.graphics.vector.f fVarE3 = x6.q.E();
                    long indigo3 = ios.getIndigo(oVar, 6);
                    p0Var2.e0(488087946);
                    zF2 = p0Var2.f(this.$go);
                    ee.c cVar8 = this.$go;
                    objI2 = p0Var2.I();
                    if (!zF2) {
                        e2Var5 = e2Var4;
                        if (objI2 == e2Var5) {
                        }
                        p0Var2.u(false);
                        e2 e2Var11 = e2Var5;
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr11, fVarE3, indigo3, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                        SettingsGroup.Separator(oVar, i13);
                        String strTr12 = StoreNetKt.tr("لاگ", "Log");
                        androidx.compose.ui.graphics.vector.f fVarU5 = x6.a.u();
                        i11 = 6;
                        long purple5 = ios.getPurple(oVar, 6);
                        p0Var2.e0(488092935);
                        zF3 = p0Var2.f(this.$go);
                        cVar = this.$go;
                        objI3 = p0Var2.I();
                        if (zF3) {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        } else {
                            objI3 = new z(cVar, i11);
                            p0Var2.r0(objI3);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m863SettingsRowqhMrWXk(strTr12, fVarU5, purple5, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                    }
                    e2Var5 = e2Var4;
                    objI2 = new z(cVar8, 5);
                    p0Var2.r0(objI2);
                    p0Var2.u(false);
                    e2 e2Var12 = e2Var5;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr11, fVarE3, indigo3, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr13 = StoreNetKt.tr("لاگ", "Log");
                    androidx.compose.ui.graphics.vector.f fVarU6 = x6.a.u();
                    i11 = 6;
                    long purple6 = ios.getPurple(oVar, 6);
                    p0Var2.e0(488092935);
                    zF3 = p0Var2.f(this.$go);
                    cVar = this.$go;
                    objI3 = p0Var2.I();
                    if (zF3) {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    } else {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr13, fVarU6, purple6, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                }
                e2Var3 = e2Var2;
                objI = new z(cVar7, 4);
                p0Var2.r0(objI);
                p0Var2.u(false);
                e2Var4 = e2Var3;
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr10, fVarL2, orange2, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
                SettingsGroup.Separator(oVar, i13);
                String strTr14 = StoreNetKt.tr("منابع و به\u200cروزرسانی", "Sources & refresh");
                androidx.compose.ui.graphics.vector.f fVarE4 = x6.q.E();
                long indigo4 = ios.getIndigo(oVar, 6);
                p0Var2.e0(488087946);
                zF2 = p0Var2.f(this.$go);
                ee.c cVar9 = this.$go;
                objI2 = p0Var2.I();
                if (!zF2) {
                    e2Var5 = e2Var4;
                    if (objI2 == e2Var5) {
                    }
                    p0Var2.u(false);
                    e2 e2Var13 = e2Var5;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr14, fVarE4, indigo4, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i13);
                    String strTr15 = StoreNetKt.tr("لاگ", "Log");
                    androidx.compose.ui.graphics.vector.f fVarU7 = x6.a.u();
                    i11 = 6;
                    long purple7 = ios.getPurple(oVar, 6);
                    p0Var2.e0(488092935);
                    zF3 = p0Var2.f(this.$go);
                    cVar = this.$go;
                    objI3 = p0Var2.I();
                    if (zF3) {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    } else {
                        objI3 = new z(cVar, i11);
                        p0Var2.r0(objI3);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr15, fVarU7, purple7, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                }
                e2Var5 = e2Var4;
                objI2 = new z(cVar9, 5);
                p0Var2.r0(objI2);
                p0Var2.u(false);
                e2 e2Var14 = e2Var5;
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr14, fVarE4, indigo4, null, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 376);
                SettingsGroup.Separator(oVar, i13);
                String strTr16 = StoreNetKt.tr("لاگ", "Log");
                androidx.compose.ui.graphics.vector.f fVarU8 = x6.a.u();
                i11 = 6;
                long purple8 = ios.getPurple(oVar, 6);
                p0Var2.e0(488092935);
                zF3 = p0Var2.f(this.$go);
                cVar = this.$go;
                objI3 = p0Var2.I();
                if (zF3) {
                    objI3 = new z(cVar, i11);
                    p0Var2.r0(objI3);
                } else {
                    objI3 = new z(cVar, i11);
                    p0Var2.r0(objI3);
                }
                p0Var2.u(false);
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr16, fVarU8, purple8, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
            }
        }

        public AnonymousClass3(View view, boolean z10, boolean z11, boolean z12, l4 l4Var, Context context, ee.e eVar, ArgoPool.Job job, ArgoPool.Summary summary, String str, ArgoPool.Job job2, boolean z13, k2 k2Var, k2 k2Var2, l4 l4Var2, ee.c cVar, List<ArgoPool.Row> list, ArgoPool.IpScan ipScan) {
            this.$v = view;
            this.$testing = z10;
            this.$connecting = z11;
            this.$connected = z12;
            this.$conn$delegate = l4Var;
            this.$context = context;
            this.$connect = eVar;
            this.$job = job;
            this.$sum = summary;
            this.$kind = str;
            this.$upd = job2;
            this.$suggested = z13;
            this.$err$delegate = k2Var;
            this.$note$delegate = k2Var2;
            this.$lastWhy$delegate = l4Var2;
            this.$go = cVar;
            this.$best = list;
            this.$scan = ipScan;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$1$lambda$0(boolean z10, boolean z11, Context context, ee.e eVar, k2 k2Var, k2 k2Var2, l4 l4Var) {
            ArgoScreenKt.ArgoMain$lambda$46(k2Var, "");
            ArgoScreenKt.ArgoMain$lambda$49(k2Var2, "");
            if (z10 || z11 || (ArgoScreenKt.ArgoMain$lambda$39(l4Var) instanceof ArgoEngine.Conn.Connected)) {
                ArgoEngine.INSTANCE.disconnectAsync(context);
            } else {
                eVar.invoke(null, null);
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$3$lambda$2(k2 k2Var, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoMain$lambda$46(k2Var, it);
            return sd.u.f67154a;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:69:0x02b5  */
        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            p0 p0Var;
            int i10;
            String str;
            String str2;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var2 = (p0) oVar;
                if (p0Var2.G()) {
                    p0Var2.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            f0.e(oVar, d3.g(qVar, 12));
            EngineLiveKt.EngineIdent(R.drawable.ic_app_argo, ArgoScreenKt.TITLE, this.$v.getTone(), ArgoScreenKt.wordOf(ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate), this.$v), oVar, 48);
            float f8 = 18;
            f0.e(oVar, d3.g(qVar, f8));
            String head = this.$v.getHead();
            Ios ios = Ios.INSTANCE;
            float f10 = 24;
            k9.b(head, f0.x(d3.e(qVar, 1.0f), f10, 0.0f, 2), ios.getLabel(oVar, 6), x6.a.t(18), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, new androidx.compose.ui.text.style.l(3), 0L, 0, false, 0, 0, null, null, oVar, 199728, 0, 130512);
            androidx.compose.runtime.o oVar2 = oVar;
            p0 p0Var3 = (p0) oVar2;
            p0Var3.e0(2024412736);
            if (kotlin.text.o.L0(this.$v.getLine())) {
                p0Var = p0Var3;
            } else {
                f0.e(oVar2, d3.g(qVar, 4));
                p0Var = p0Var3;
                k9.b(this.$v.getLine(), f0.x(d3.e(qVar, 1.0f), f10, 0.0f, 2), ios.getSecondaryLabel(oVar2, 6), x6.a.s(13.5d), null, null, null, 0L, null, new androidx.compose.ui.text.style.l(3), x6.a.t(20), 0, false, 0, 0, null, null, oVar, 3120, 6, 129520);
                oVar2 = oVar;
            }
            p0Var.u(false);
            f0.e(oVar2, d3.g(qVar, f8));
            boolean z10 = this.$v.getTone() == EngineTone.ON;
            boolean z11 = this.$v.getTone() == EngineTone.BUSY && !this.$testing;
            boolean z12 = this.$connecting;
            boolean canPress = this.$v.getCanPress();
            p0Var.e0(2024426925);
            boolean zG = p0Var.g(this.$connected) | p0Var.g(this.$connecting) | p0Var.f(this.$conn$delegate) | p0Var.h(this.$context) | p0Var.f(this.$connect);
            final boolean z13 = this.$connected;
            final boolean z14 = this.$connecting;
            final Context context = this.$context;
            final ee.e eVar = this.$connect;
            final k2 k2Var = this.$err$delegate;
            final k2 k2Var2 = this.$note$delegate;
            final l4 l4Var = this.$conn$delegate;
            boolean z15 = z10;
            Object objI = p0Var.I();
            e2 e2Var = androidx.compose.runtime.n.f3284a;
            if (zG || objI == e2Var) {
                ee.a aVar = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.x
                    @Override // ee.a
                    public final Object invoke() {
                        return ArgoScreenKt.AnonymousClass3.invoke$lambda$1$lambda$0(z13, z14, context, eVar, k2Var, k2Var2, l4Var);
                    }
                };
                p0Var.r0(aVar);
                objI = aVar;
            }
            p0Var.u(false);
            androidx.compose.runtime.o oVar3 = oVar2;
            ArgoScreenKt.PowerButton(z15, z11, z12, canPress, (ee.a) objI, oVar3, 0);
            p0Var.e0(2024432923);
            if (this.$connected) {
                f0.e(oVar3, d3.g(qVar, 14));
                EngineLiveKt.EngineLiveStrip(oVar3, 0);
            }
            p0Var.u(false);
            RouteChipsKt.RouteChips(null, oVar3, 0, 1);
            ArgoEngine.Conn connArgoMain$lambda$39 = ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate);
            ArgoEngine.Conn.Failed failed = connArgoMain$lambda$39 instanceof ArgoEngine.Conn.Failed ? (ArgoEngine.Conn.Failed) connArgoMain$lambda$39 : null;
            String error = failed != null ? failed.getError() : null;
            ArgoPool.Job job = this.$job;
            boolean z16 = (job == null || job.getRunning() || this.$job.getFrozen() <= 0 || !kotlin.text.o.L0(this.$sum.getPrefs().getCleanIp()) || this.$connected) ? false : true;
            p0Var.e0(2024446342);
            if (kotlin.text.o.L0(ArgoScreenKt.ArgoMain$lambda$45(this.$err$delegate)) && error == null && (ArgoScreenKt.ArgoMain$lambda$40(this.$lastWhy$delegate) == null || !(ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate) instanceof ArgoEngine.Conn.Idle))) {
                ArgoEngine.Conn connArgoMain$lambda$310 = ArgoScreenKt.ArgoMain$lambda$39(this.$conn$delegate);
                ArgoEngine.Conn.Connected connected = connArgoMain$lambda$310 instanceof ArgoEngine.Conn.Connected ? (ArgoEngine.Conn.Connected) connArgoMain$lambda$310 : null;
                if ((connected != null && connected.getLost()) || !kotlin.text.o.L0(ArgoScreenKt.ArgoMain$lambda$48(this.$note$delegate)) || z16) {
                    f0.e(oVar3, d3.g(qVar, 10));
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar3, 877178731, new AnonymousClass2(error, this.$connect, z16, this.$job, this.$go, this.$err$delegate, this.$lastWhy$delegate, this.$conn$delegate, this.$note$delegate)), oVar3, 384, 3);
                }
            } else {
                f0.e(oVar3, d3.g(qVar, 10));
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar3, 877178731, new AnonymousClass2(error, this.$connect, z16, this.$job, this.$go, this.$err$delegate, this.$lastWhy$delegate, this.$conn$delegate, this.$note$delegate)), oVar3, 384, 3);
            }
            p0Var.u(false);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("سنجش و به\u200cروزرسانی", "Test & refresh"), " — ", StoreNetKt.tr(f0.a.m(ArgoScreenKt.fa(this.$sum.getCounts().getTotal()), " مورد · ", ArgoScreenKt.fa(this.$sum.getCounts().getAlive()), " سالم"), this.$sum.getCounts().getTotal() + " · " + this.$sum.getCounts().getAlive() + " healthy")), 0.0f, oVar3, 0, 2);
            String str3 = this.$kind;
            ArgoPool.Job job2 = this.$job;
            ArgoPool.Job job3 = this.$upd;
            p0Var.e0(2024526211);
            k2 k2Var3 = this.$err$delegate;
            Object objI2 = p0Var.I();
            if (objI2 == e2Var) {
                objI2 = new k(4, k2Var3);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            ArgoScreenKt.TestCard(str3, job2, job3, null, (ee.c) objI2, oVar, 24576, 8);
            IosSettingsKt.SettingsFooter(StoreNetKt.tr(v0.a.p(ArgoScreenKt.fa(this.$sum.getCounts().getTested()), " مورد روی همین اینترنت سنجیده شده. «به\u200cروزرسانی» پل\u200cها و فالکن\u200cهای تازه را از منابع می\u200cگیرد."), this.$sum.getCounts().getTested() + " tested on this network. «Refresh» fetches new bridges and falcons from the sources."), oVar, 0);
            List<ArgoPool.Group> groups = this.$sum.getGroups();
            if ((groups instanceof Collection) && groups.isEmpty()) {
                i10 = 0;
            } else {
                i10 = 0;
                for (ArgoPool.Group group : groups) {
                    if (group.getAlive() > 0 && !kotlin.jvm.internal.j.a(group.getCc(), "??") && (i10 = i10 + 1) < 0) {
                        kotlin.collections.r.e0();
                        throw null;
                    }
                }
            }
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("سالم\u200cترین\u200cها", "Healthiest"), " — ", com.mlmvpn.core.aether.i.e(i10, " countries", v0.a.p(ArgoScreenKt.fa(i10), " کشور"))), 0.0f, oVar, 0, 2);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar, -1476962856, new AnonymousClass4(this.$best, this.$sum, this.$go, this.$suggested, this.$connecting, this.$connect)), oVar, 384, 3);
            IosSettingsKt.SettingsFooter(this.$suggested ? StoreNetKt.tr("هنوز چیزی روی اینترنت خودتان سنجیده نشده؛ این\u200cها همراه برنامه روی اینترنت ایران و بدون تونل آزموده شده\u200cاند.", "Nothing tested on your own network yet; these were tested on Iran's internet, untunnelled, for the bundle.") : StoreNetKt.tr("کشور هر مورد همان جایی است که سنجش واقعاً از آن بیرون آمد.", "Each one's country is where the test really came out."), oVar, 0);
            String strTr = StoreNetKt.tr("آی\u200cپی تمیز", "Clean IP");
            if (kotlin.text.o.L0(this.$sum.getPrefs().getCleanIp())) {
                str = "خاموش";
                str2 = "off";
            } else {
                str = "روشن";
                str2 = "on";
            }
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(strTr, " — ", StoreNetKt.tr(str, str2)), 0.0f, oVar, 0, 2);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar, -367688753, new AnonymousClass5(this.$sum, this.$go, this.$scan, this.$testing, this.$err$delegate)), oVar, 384, 3);
            IosSettingsKt.SettingsFooter(StoreNetKt.tr("اگر سروری «وسط دانلود قطع شد» یا اصلاً وصل نمی\u200cشود، یک آی\u200cپی تمیز کلادفلر همهٔ پل\u200cها و فالکن\u200cها را با هم رفع فیلتر می\u200cکند و سرعت را بالا می\u200cبرد.", "If a server is «cut part-way» or does not connect at all, one clean Cloudflare IP unblocks every bridge and falcon at once and speeds them up."), oVar, 0);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("بخش\u200cها", "Sections"), 0.0f, oVar, 0, 2);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar, 355601680, new AnonymousClass6(this.$go)), oVar, 384, 3);
            f0.e(oVar, d3.g(qVar, 40));
            r0 r0Var2 = v0.f3474a;
        }
    }

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoSources$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class C08912 implements ee.f {
        final /* synthetic */ k2 $err$delegate;
        final /* synthetic */ k2 $input$delegate;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ List<ArgoPool.SourceView> $sources;
        final /* synthetic */ ArgoPool.Job $upd;
        final /* synthetic */ boolean $updating;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ArgoSources$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass3 implements ee.f {
            final /* synthetic */ k2 $note$delegate;
            final /* synthetic */ List<ArgoPool.SourceView> $sources;
            final /* synthetic */ boolean $updating;

            public AnonymousClass3(List<ArgoPool.SourceView> list, boolean z10, k2 k2Var) {
                this.$sources = list;
                this.$updating = z10;
                this.$note$delegate = k2Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$12$lambda$11$lambda$10$lambda$9(ArgoPool.SourceView sourceView, boolean z10) {
                ArgoPool.INSTANCE.setSourceOn(sourceView.getSrc().getId(), z10);
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$12$lambda$11$lambda$3$lambda$2(ArgoPool.SourceView sourceView) {
                ArgoPool.INSTANCE.update(m9.d.B(sourceView.getSrc().getId()));
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$12$lambda$11$lambda$5$lambda$4(ArgoPool.SourceView sourceView, k2 k2Var) {
                ArgoPool.INSTANCE.removeSource(sourceView.getSrc().getId());
                ArgoScreenKt.ArgoSources$lambda$186(k2Var, StoreNetKt.tr("منبع حذف شد؛ پل\u200cها و فالکن\u200cهایی که از آن گرفته شده بود در فهرست می\u200cمانند.", "The source was removed; the bridges and falcons it gave stay in the list."));
                return sd.u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final sd.u invoke$lambda$12$lambda$11$lambda$7$lambda$6(j0 semantics) {
                kotlin.jvm.internal.j.e(semantics, "$this$semantics");
                g0.c(StoreNetKt.tr("حذف منبع", "Remove the source"), semantics);
                return sd.u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                return sd.u.f67154a;
            }

            /* JADX WARN: Code duplicated, block: B:100:0x0349  */
            /* JADX WARN: Code duplicated, block: B:106:0x03b0  */
            /* JADX WARN: Code duplicated, block: B:109:0x03d9  */
            /* JADX WARN: Code duplicated, block: B:114:0x0408  */
            /* JADX WARN: Code duplicated, block: B:117:0x042a  */
            /* JADX WARN: Code duplicated, block: B:120:0x0460  */
            /* JADX WARN: Code duplicated, block: B:122:0x0468  */
            /* JADX WARN: Code duplicated, block: B:127:0x0486  */
            /* JADX WARN: Code duplicated, block: B:131:0x04bb  */
            /* JADX WARN: Code duplicated, block: B:135:0x04e1  */
            /* JADX WARN: Code duplicated, block: B:145:0x0512 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:78:0x0228  */
            /* JADX WARN: Code duplicated, block: B:80:0x0251  */
            /* JADX WARN: Code duplicated, block: B:81:0x0255  */
            /* JADX WARN: Code duplicated, block: B:86:0x0270  */
            /* JADX WARN: Code duplicated, block: B:89:0x02f4  */
            /* JADX WARN: Code duplicated, block: B:90:0x0304  */
            /* JADX WARN: Code duplicated, block: B:93:0x030f  */
            /* JADX WARN: Code duplicated, block: B:95:0x031a  */
            /* JADX WARN: Code duplicated, block: B:98:0x0339  */
            public final void invoke(SettingsGroupScope settingsGroupScope, androidx.compose.runtime.o oVar, int i) {
                boolean z10;
                androidx.compose.ui.graphics.vector.f fVarK;
                String strTr;
                k2 k2Var;
                Ios ios;
                float f8;
                k2 k2Var2;
                int iE;
                Integer num;
                String str;
                String strTr2;
                char c2;
                boolean z11;
                long secondaryLabel;
                boolean z12;
                int i10;
                boolean zH;
                Object objI;
                e2 e2Var;
                Integer num2;
                androidx.compose.ui.q qVar;
                int i11;
                boolean zH2;
                Object objI2;
                boolean zH3;
                Object objI3;
                k2 k2Var3;
                int i12;
                Object objI4;
                int iE2;
                SettingsGroupScope SettingsGroup = settingsGroupScope;
                androidx.compose.runtime.o oVar2 = oVar;
                boolean z13 = false;
                Integer num3 = 0;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                int i13 = (i & 6) == 0 ? i | ((i & 8) == 0 ? ((p0) oVar2).f(SettingsGroup) : ((p0) oVar2).h(SettingsGroup) ? 4 : 2) : i;
                if ((i13 & 19) == 18) {
                    p0 p0Var = (p0) oVar2;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                List<ArgoPool.SourceView> list = this.$sources;
                boolean z14 = this.$updating;
                k2 k2Var4 = this.$note$delegate;
                int i14 = 0;
                for (Object obj : list) {
                    int i15 = i14 + 1;
                    if (i14 < 0) {
                        kotlin.collections.r.f0();
                        throw null;
                    }
                    ArgoPool.SourceView sourceView = (ArgoPool.SourceView) obj;
                    p0 p0Var2 = (p0) oVar2;
                    androidx.compose.runtime.a aVar = p0Var2.f3294a;
                    p0Var2.e0(-267477171);
                    if (i14 > 0) {
                        SettingsGroup.Separator(oVar2, i13 & 14);
                    }
                    p0Var2.u(z13);
                    if (kotlin.jvm.internal.j.a(sourceView.getSrc().getType(), "telegram")) {
                        fVarK = m8.g.x();
                    } else {
                        List<String> value = sourceView.getSrc().getValue();
                        if (!(value instanceof Collection) || !value.isEmpty()) {
                            Iterator<T> it = value.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (kotlin.text.o.y0((String) it.next(), "github", true)) {
                                        z10 = true;
                                        break;
                                    }
                                } else {
                                    z10 = false;
                                    break;
                                }
                            }
                        } else {
                            z10 = false;
                            break;
                        }
                        fVarK = z10 ? s7.e.k() : sourceView.getSrc().getBuiltin() ? fc.a.r() : s7.e.o();
                    }
                    androidx.compose.ui.graphics.vector.f fVar = fVarK;
                    if (!kotlin.text.o.L0(sourceView.getError())) {
                        strTr = sourceView.getError();
                    } else if (sourceView.getAt() > 0) {
                        strTr = StoreNetKt.tr(g1.k(ArgoScreenKt.fa(sourceView.getTotal()), " ", kotlin.jvm.internal.j.a(sourceView.getSrc().getType(), "falcon-servers") ? "سرور فالکن" : "مورد در فهرست", " — ", ArgoScreenKt.ago(sourceView.getAt())), sourceView.getTotal() + " " + (kotlin.jvm.internal.j.a(sourceView.getSrc().getType(), "falcon-servers") ? "falcon servers" : "in the list") + " — " + ArgoScreenKt.ago(sourceView.getAt()));
                    } else {
                        strTr = StoreNetKt.tr("هنوز گرفته نشده", "not fetched yet");
                    }
                    String str2 = strTr;
                    androidx.compose.ui.q qVar2 = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarW = f0.w(d3.e(qVar2, 1.0f), 14, 9);
                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                    p0Var2.e0(693286680);
                    k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, oVar2);
                    p0Var2.e0(-1323940314);
                    int iE3 = b1.E(oVar2);
                    w2 w2VarO = p0Var2.o();
                    androidx.compose.ui.node.u.i.getClass();
                    boolean z15 = z14;
                    l0 l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var2.h0();
                    if (p0Var2.M) {
                        p0Var2.n(l0Var);
                    } else {
                        p0Var2.t0();
                    }
                    androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
                    b1.Y(oVar2, pVar, k0VarA);
                    androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
                    b1.Y(oVar2, rVar, w2VarO);
                    androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                    if (p0Var2.M) {
                        k2Var = k2Var4;
                    } else {
                        k2Var = k2Var4;
                        if (!kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE3))) {
                        }
                        com.mlmvpn.scanner.e.v(oVar2, eVarM, oVar2, num3);
                        p0Var2.e0(2058660585);
                        ios = Ios.INSTANCE;
                        long secondaryLabel2 = ios.getSecondaryLabel(oVar2, 6);
                        f8 = 18;
                        k2Var2 = k2Var;
                        c3.b(null, secondaryLabel2, fVar, d3.m(qVar2, f8), oVar2, 432, 0);
                        f0.e(oVar2, d3.p(qVar2, 8));
                        if (1.0f > 0.0d) {
                            throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                        }
                        LayoutWeightElement layoutWeightElementA = com.mlmvpn.scanner.e.a(1.0f, true, p0Var2, -483455358);
                        k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, oVar2);
                        p0Var2.e0(-1323940314);
                        iE = b1.E(oVar2);
                        w2 w2VarO2 = p0Var2.o();
                        androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(layoutWeightElementA);
                        p0Var2.h0();
                        if (p0Var2.M) {
                            p0Var2.n(l0Var);
                        } else {
                            p0Var2.t0();
                        }
                        b1.Y(oVar2, pVar, k0VarA2);
                        b1.Y(oVar2, rVar, w2VarO2);
                        if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var2, iE, mVar);
                        }
                        com.mlmvpn.scanner.e.v(oVar2, eVarM2, oVar2, num3);
                        p0Var2.e0(2058660585);
                        num = num3;
                        k9.b(sourceView.getSrc().getLabel(), null, ios.getLabel(oVar2, 6), x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                        if (kotlin.jvm.internal.j.a(sourceView.getSrc().getType(), "telegram")) {
                            str = null;
                        } else {
                            str = (String) kotlin.collections.q.A0(sourceView.getSrc().getValue());
                        }
                        if (sourceView.getSrc().getBuiltin()) {
                            strTr2 = StoreNetKt.tr("همراه برنامه", "built in");
                        } else {
                            strTr2 = null;
                        }
                        String strF0 = kotlin.collections.q.F0(kotlin.collections.o.b0(new String[]{str, str2, strTr2}), " · ", null, null, null, 62);
                        if (kotlin.text.o.L0(sourceView.getError())) {
                            c2 = 6;
                            z11 = false;
                            p0Var2.e0(342099330);
                            secondaryLabel = ios.getSecondaryLabel(oVar, 6);
                        } else {
                            p0Var2.e0(342098903);
                            c2 = 6;
                            secondaryLabel = ios.getRed(oVar, 6);
                            z11 = false;
                        }
                        p0Var2.u(z11);
                        z12 = z11;
                        k9.b(strF0, null, secondaryLabel, x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 2, false, 2, 0, null, null, oVar, MamiIdentity.RSA_BITS, 3120, 120818);
                        i10 = 1;
                        w0.z(p0Var2, z12, true, z12, z12);
                        String strTr3 = StoreNetKt.tr("دریافت", "Fetch");
                        boolean z16 = !z15;
                        p0Var2.e0(1026269402);
                        zH = p0Var2.h(sourceView);
                        objI = p0Var2.I();
                        e2Var = androidx.compose.runtime.n.f3284a;
                        if (zH || objI == e2Var) {
                            objI = new u(sourceView, 2);
                            p0Var2.r0(objI);
                        }
                        p0Var2.u(z12);
                        ArgoScreenKt.Btn(strTr3, false, z16, null, (ee.a) objI, oVar, 0, 10);
                        p0Var2.e0(1026271938);
                        if (sourceView.getSrc().getUser()) {
                            i11 = 4;
                            qVar = qVar2;
                            f0.e(oVar, d3.p(qVar, 4));
                            androidx.compose.ui.t tVarB = androidx.compose.ui.draw.h.b(d3.m(qVar, 30), e0.e.f17770a);
                            p0Var2.e0(1026276236);
                            zH3 = p0Var2.h(sourceView);
                            objI3 = p0Var2.I();
                            if (!zH3 || objI3 == e2Var) {
                                k2Var3 = k2Var2;
                                i12 = 6;
                                objI3 = new q(i12, sourceView, k2Var3);
                                p0Var2.r0(objI3);
                            } else {
                                k2Var3 = k2Var2;
                                i12 = 6;
                            }
                            p0Var2.u(z12);
                            androidx.compose.ui.t tVarL = androidx.compose.foundation.p.l(tVarB, z12, null, (ee.a) objI3, 7);
                            p0Var2.e0(1026285297);
                            objI4 = p0Var2.I();
                            if (objI4 == e2Var) {
                                objI4 = new s(i10);
                                p0Var2.r0(objI4);
                            }
                            p0Var2.u(z12);
                            androidx.compose.ui.t tVarA = androidx.compose.ui.semantics.k.a(tVarL, z12, (ee.c) objI4);
                            androidx.compose.ui.j jVar = androidx.compose.ui.b.f3544e;
                            p0Var2.e0(733328855);
                            k0 k0VarC = androidx.compose.foundation.layout.t.c(jVar, z12, oVar);
                            p0Var2.e0(-1323940314);
                            iE2 = b1.E(oVar);
                            w2 w2VarO3 = p0Var2.o();
                            androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarA);
                            p0Var2.h0();
                            if (p0Var2.M) {
                                p0Var2.n(l0Var);
                            } else {
                                p0Var2.t0();
                            }
                            b1.Y(oVar, pVar, k0VarC);
                            b1.Y(oVar, rVar, w2VarO3);
                            if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE2))) {
                                w0.u(iE2, p0Var2, iE2, mVar);
                            }
                            com.mlmvpn.scanner.e.v(oVar, eVarM3, oVar, num);
                            p0Var2.e0(2058660585);
                            k2Var2 = k2Var3;
                            num2 = num;
                            c3.b(null, ios.getRed(oVar, i12), com.google.android.gms.internal.mlkit_language_id_common.j.r(), d3.m(qVar, f8), oVar, 432, 0);
                            w0.z(p0Var2, z12, true, z12, z12);
                        } else {
                            num2 = num;
                            qVar = qVar2;
                            i11 = 4;
                        }
                        p0Var2.u(z12);
                        f0.e(oVar, d3.p(qVar, i11));
                        boolean on = sourceView.getOn();
                        p0Var2.e0(1026297755);
                        zH2 = p0Var2.h(sourceView);
                        objI2 = p0Var2.I();
                        if (zH2 || objI2 == e2Var) {
                            objI2 = new a0(sourceView, z12 ? 1 : 0);
                            p0Var2.r0(objI2);
                        }
                        p0Var2.u(z12);
                        e8.a(on, (ee.c) objI2, null, null, false, null, null, oVar, 0, 124);
                        w0.z(p0Var2, z12, true, z12, z12);
                        SettingsGroup = settingsGroupScope;
                        oVar2 = oVar;
                        z13 = z12 ? 1 : 0;
                        i14 = i15;
                        k2Var4 = k2Var2;
                        z14 = z15;
                        num3 = num2;
                    }
                    w0.u(iE3, p0Var2, iE3, mVar);
                    com.mlmvpn.scanner.e.v(oVar2, eVarM, oVar2, num3);
                    p0Var2.e0(2058660585);
                    ios = Ios.INSTANCE;
                    long secondaryLabel3 = ios.getSecondaryLabel(oVar2, 6);
                    f8 = 18;
                    k2Var2 = k2Var;
                    c3.b(null, secondaryLabel3, fVar, d3.m(qVar2, f8), oVar2, 432, 0);
                    f0.e(oVar2, d3.p(qVar2, 8));
                    if (1.0f > 0.0d) {
                        throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                    }
                    LayoutWeightElement layoutWeightElementA2 = com.mlmvpn.scanner.e.a(1.0f, true, p0Var2, -483455358);
                    k0 k0VarA3 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, oVar2);
                    p0Var2.e0(-1323940314);
                    iE = b1.E(oVar2);
                    w2 w2VarO4 = p0Var2.o();
                    androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(layoutWeightElementA2);
                    p0Var2.h0();
                    if (p0Var2.M) {
                        p0Var2.n(l0Var);
                    } else {
                        p0Var2.t0();
                    }
                    b1.Y(oVar2, pVar, k0VarA3);
                    b1.Y(oVar2, rVar, w2VarO4);
                    if (p0Var2.M) {
                        w0.u(iE, p0Var2, iE, mVar);
                    } else {
                        w0.u(iE, p0Var2, iE, mVar);
                    }
                    com.mlmvpn.scanner.e.v(oVar2, eVarM4, oVar2, num3);
                    p0Var2.e0(2058660585);
                    num = num3;
                    k9.b(sourceView.getSrc().getLabel(), null, ios.getLabel(oVar2, 6), x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                    if (kotlin.jvm.internal.j.a(sourceView.getSrc().getType(), "telegram")) {
                        str = (String) kotlin.collections.q.A0(sourceView.getSrc().getValue());
                    } else {
                        str = null;
                    }
                    if (sourceView.getSrc().getBuiltin()) {
                        strTr2 = StoreNetKt.tr("همراه برنامه", "built in");
                    } else {
                        strTr2 = null;
                    }
                    String strF1 = kotlin.collections.q.F0(kotlin.collections.o.b0(new String[]{str, str2, strTr2}), " · ", null, null, null, 62);
                    if (kotlin.text.o.L0(sourceView.getError())) {
                        p0Var2.e0(342098903);
                        c2 = 6;
                        secondaryLabel = ios.getRed(oVar, 6);
                        z11 = false;
                    } else {
                        c2 = 6;
                        z11 = false;
                        p0Var2.e0(342099330);
                        secondaryLabel = ios.getSecondaryLabel(oVar, 6);
                    }
                    p0Var2.u(z11);
                    z12 = z11;
                    k9.b(strF1, null, secondaryLabel, x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 2, false, 2, 0, null, null, oVar, MamiIdentity.RSA_BITS, 3120, 120818);
                    i10 = 1;
                    w0.z(p0Var2, z12, true, z12, z12);
                    String strTr4 = StoreNetKt.tr("دریافت", "Fetch");
                    boolean z17 = !z15;
                    p0Var2.e0(1026269402);
                    zH = p0Var2.h(sourceView);
                    objI = p0Var2.I();
                    e2Var = androidx.compose.runtime.n.f3284a;
                    if (zH) {
                        objI = new u(sourceView, 2);
                        p0Var2.r0(objI);
                    } else {
                        objI = new u(sourceView, 2);
                        p0Var2.r0(objI);
                    }
                    p0Var2.u(z12);
                    ArgoScreenKt.Btn(strTr4, false, z17, null, (ee.a) objI, oVar, 0, 10);
                    p0Var2.e0(1026271938);
                    if (sourceView.getSrc().getUser()) {
                        i11 = 4;
                        qVar = qVar2;
                        f0.e(oVar, d3.p(qVar, 4));
                        androidx.compose.ui.t tVarB2 = androidx.compose.ui.draw.h.b(d3.m(qVar, 30), e0.e.f17770a);
                        p0Var2.e0(1026276236);
                        zH3 = p0Var2.h(sourceView);
                        objI3 = p0Var2.I();
                        if (zH3) {
                            k2Var3 = k2Var2;
                            i12 = 6;
                            objI3 = new q(i12, sourceView, k2Var3);
                            p0Var2.r0(objI3);
                        } else {
                            k2Var3 = k2Var2;
                            i12 = 6;
                            objI3 = new q(i12, sourceView, k2Var3);
                            p0Var2.r0(objI3);
                        }
                        p0Var2.u(z12);
                        androidx.compose.ui.t tVarL2 = androidx.compose.foundation.p.l(tVarB2, z12, null, (ee.a) objI3, 7);
                        p0Var2.e0(1026285297);
                        objI4 = p0Var2.I();
                        if (objI4 == e2Var) {
                            objI4 = new s(i10);
                            p0Var2.r0(objI4);
                        }
                        p0Var2.u(z12);
                        androidx.compose.ui.t tVarA2 = androidx.compose.ui.semantics.k.a(tVarL2, z12, (ee.c) objI4);
                        androidx.compose.ui.j jVar2 = androidx.compose.ui.b.f3544e;
                        p0Var2.e0(733328855);
                        k0 k0VarC2 = androidx.compose.foundation.layout.t.c(jVar2, z12, oVar);
                        p0Var2.e0(-1323940314);
                        iE2 = b1.E(oVar);
                        w2 w2VarO5 = p0Var2.o();
                        androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarA2);
                        p0Var2.h0();
                        if (p0Var2.M) {
                            p0Var2.n(l0Var);
                        } else {
                            p0Var2.t0();
                        }
                        b1.Y(oVar, pVar, k0VarC2);
                        b1.Y(oVar, rVar, w2VarO5);
                        if (p0Var2.M) {
                            w0.u(iE2, p0Var2, iE2, mVar);
                        } else {
                            w0.u(iE2, p0Var2, iE2, mVar);
                        }
                        com.mlmvpn.scanner.e.v(oVar, eVarM5, oVar, num);
                        p0Var2.e0(2058660585);
                        k2Var2 = k2Var3;
                        num2 = num;
                        c3.b(null, ios.getRed(oVar, i12), com.google.android.gms.internal.mlkit_language_id_common.j.r(), d3.m(qVar, f8), oVar, 432, 0);
                        w0.z(p0Var2, z12, true, z12, z12);
                    } else {
                        num2 = num;
                        qVar = qVar2;
                        i11 = 4;
                    }
                    p0Var2.u(z12);
                    f0.e(oVar, d3.p(qVar, i11));
                    boolean on2 = sourceView.getOn();
                    p0Var2.e0(1026297755);
                    zH2 = p0Var2.h(sourceView);
                    objI2 = p0Var2.I();
                    if (zH2) {
                        objI2 = new a0(sourceView, z12 ? 1 : 0);
                        p0Var2.r0(objI2);
                    } else {
                        objI2 = new a0(sourceView, z12 ? 1 : 0);
                        p0Var2.r0(objI2);
                    }
                    p0Var2.u(z12);
                    e8.a(on2, (ee.c) objI2, null, null, false, null, null, oVar, 0, 124);
                    w0.z(p0Var2, z12, true, z12, z12);
                    SettingsGroup = settingsGroupScope;
                    oVar2 = oVar;
                    z13 = z12 ? 1 : 0;
                    i14 = i15;
                    k2Var4 = k2Var2;
                    z14 = z15;
                    num3 = num2;
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        public C08912(boolean z10, ArgoPool.Job job, k2 k2Var, k2 k2Var2, k2 k2Var3, List<ArgoPool.SourceView> list) {
            this.$updating = z10;
            this.$upd = job;
            this.$input$delegate = k2Var;
            this.$err$delegate = k2Var2;
            this.$note$delegate = k2Var3;
            this.$sources = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$12$lambda$11$lambda$10(d0 d0Var, k2 k2Var, k2 k2Var2, k2 k2Var3) {
            Object objM1004constructorimpl;
            ArgoScreenKt.ArgoSources$lambda$183(k2Var, "");
            ArgoScreenKt.ArgoSources$lambda$186(k2Var2, "");
            try {
                objM1004constructorimpl = sd.l.m1004constructorimpl(ArgoPool.INSTANCE.addSource(ArgoScreenKt.ArgoSources$lambda$179(k2Var3)));
            } catch (Throwable th2) {
                objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
            }
            if (sd.l.m1011isSuccessimpl(objM1004constructorimpl)) {
                ArgoPool.Source source = (ArgoPool.Source) objM1004constructorimpl;
                ArgoPool.INSTANCE.update(m9.d.B(source.getId()));
                ArgoScreenKt.ArgoSources$lambda$180(k2Var3, "");
                ArgoScreenKt.ArgoSources$lambda$186(k2Var2, StoreNetKt.tr(w0.n("«", source.getLabel(), "» اضافه شد و دریافت از آن شروع شد."), "«" + source.getLabel() + "» was added and fetching from it started."));
            }
            Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
            if (thM1007exceptionOrNullimpl != null) {
                String message = thM1007exceptionOrNullimpl.getMessage();
                ArgoScreenKt.ArgoSources$lambda$183(k2Var, message != null ? message : "");
            }
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$12$lambda$6$lambda$5(k2 k2Var, String it) {
            kotlin.jvm.internal.j.e(it, "it");
            ArgoScreenKt.ArgoSources$lambda$180(k2Var, it);
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$4$lambda$1$lambda$0() {
            ArgoPool.INSTANCE.stopUpdate();
            return sd.u.f67154a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final sd.u invoke$lambda$4$lambda$3$lambda$2() {
            ArgoPool.update$default(ArgoPool.INSTANCE, null, 1, null);
            return sd.u.f67154a;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
            return sd.u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x064d  */
        /* JADX WARN: Code duplicated, block: B:22:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:24:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:25:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:27:0x012d  */
        /* JADX WARN: Code duplicated, block: B:29:0x015b  */
        /* JADX WARN: Code duplicated, block: B:30:0x0165  */
        /* JADX WARN: Code duplicated, block: B:55:0x025f  */
        /* JADX WARN: Code duplicated, block: B:58:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:60:0x0318  */
        /* JADX WARN: Code duplicated, block: B:61:0x0323  */
        /* JADX WARN: Code duplicated, block: B:64:0x033d  */
        /* JADX WARN: Code duplicated, block: B:66:0x036c  */
        /* JADX WARN: Code duplicated, block: B:74:0x03e9  */
        /* JADX WARN: Code duplicated, block: B:77:0x0493  */
        /* JADX WARN: Code duplicated, block: B:79:0x049b  */
        /* JADX WARN: Code duplicated, block: B:84:0x04b9  */
        /* JADX WARN: Code duplicated, block: B:89:0x05ac  */
        /* JADX WARN: Code duplicated, block: B:90:0x05b8  */
        /* JADX WARN: Code duplicated, block: B:93:0x05e3  */
        /* JADX WARN: Code duplicated, block: B:94:0x05f1  */
        /* JADX WARN: Code duplicated, block: B:97:0x0616  */
        /* JADX WARN: Code duplicated, block: B:98:0x0637  */
        public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar, int i) {
            ArgoPool.Job job;
            e2 e2Var;
            p0 p0Var;
            androidx.compose.foundation.layout.b bVar;
            androidx.compose.ui.h hVar;
            e2 e2Var2;
            Object objI;
            androidx.compose.runtime.o oVar2;
            String str;
            String strTr;
            Ios ios;
            p0 p0Var2;
            String str2;
            e2 e2Var3;
            androidx.compose.runtime.o oVar3;
            boolean z10;
            p0 p0Var3;
            boolean z11;
            k2 k2Var;
            k2 k2Var2;
            k2 k2Var3;
            int iE;
            p0 p0Var4;
            Object objI2;
            k2 k2Var4;
            androidx.compose.runtime.o oVar4;
            Object objI3;
            k2 k2Var5;
            k2 k2Var6;
            int i10;
            Ios ios2;
            int i11;
            String strH;
            Object objI4;
            int i12;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var5 = (p0) oVar;
                if (p0Var5.G()) {
                    p0Var5.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            float f8 = 10;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            float f10 = 16;
            androidx.compose.ui.t tVarV = f0.v(GlassKt.frostedGlass(f0.x(com.mlmvpn.scanner.e.c(qVar, f8, oVar, qVar, 1.0f), f10, 0.0f, 2), e0.e.b(12), false, false, oVar, 6, 6), f8);
            boolean z12 = this.$updating;
            ArgoPool.Job job2 = this.$upd;
            p0 p0Var6 = (p0) oVar;
            androidx.compose.runtime.a aVar = p0Var6.f3294a;
            p0Var6.e0(-483455358);
            androidx.compose.foundation.layout.b bVar2 = androidx.compose.foundation.layout.i.f2024c;
            androidx.compose.ui.h hVar2 = androidx.compose.ui.b.f3551w;
            k0 k0VarA = c0.a(bVar2, hVar2, oVar);
            p0Var6.e0(-1323940314);
            int iE2 = b1.E(oVar);
            w2 w2VarO = p0Var6.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarV);
            p0Var6.h0();
            if (p0Var6.M) {
                p0Var6.n(l0Var);
            } else {
                p0Var6.t0();
            }
            androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
            b1.Y(oVar, pVar, k0VarA);
            androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
            b1.Y(oVar, rVar, w2VarO);
            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
            if (!p0Var6.M) {
                job = job2;
                if (!kotlin.jvm.internal.j.a(p0Var6.I(), Integer.valueOf(iE2))) {
                }
                com.mlmvpn.scanner.e.v(oVar, eVarM, oVar, 0);
                p0Var6.e0(2058660585);
                e2Var = androidx.compose.runtime.n.f3284a;
                if (z12) {
                    p0Var6.e0(-267601221);
                    String strTr2 = StoreNetKt.tr("توقف به\u200cروزرسانی", "Stop the refresh");
                    androidx.compose.ui.graphics.vector.f fVarY = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                    p0Var6.e0(-267598896);
                    objI4 = p0Var6.I();
                    if (objI4 == e2Var) {
                        i12 = 1;
                        objI4 = new r(i12);
                        p0Var6.r0(objI4);
                    } else {
                        i12 = 1;
                    }
                    p0Var6.u(false);
                    p0Var = p0Var6;
                    bVar = bVar2;
                    e2Var2 = e2Var;
                    hVar = hVar2;
                    ArgoScreenKt.Btn(strTr2, false, false, fVarY, (ee.a) objI4, oVar, 24576, 6);
                    p0Var.u(false);
                    oVar2 = oVar;
                } else {
                    p0Var = p0Var6;
                    bVar = bVar2;
                    hVar = hVar2;
                    e2Var2 = e2Var;
                    p0Var.e0(-267597423);
                    String strTr3 = StoreNetKt.tr("به\u200cروزرسانی پل\u200cها و فالکن\u200cها", "Refresh bridges and falcons");
                    androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                    p0Var.e0(-267594292);
                    objI = p0Var.I();
                    if (objI == e2Var2) {
                        objI = new r(2);
                        p0Var.r0(objI);
                    }
                    p0Var.u(false);
                    oVar2 = oVar;
                    ArgoScreenKt.Btn(strTr3, false, false, fVarE, (ee.a) objI, oVar2, 24576, 6);
                    p0Var.u(false);
                }
                str = " مورد تازه";
                if (job != 0 || job.getRunning() || job.getEndedAt() <= 0) {
                    str = " مورد تازه";
                    e2Var2 = e2Var2;
                    strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cهای تازه از همهٔ منابع روشن گرفته می\u200cشوند؛ هر چه از قبل دارید می\u200cماند.", "New bridges and falcons are fetched from every source that is on; whatever you have stays.");
                } else {
                    strTr = StoreNetKt.tr(androidx.compose.foundation.interaction.f.r(" مورد تازه", !job.getErrors().isEmpty() ? w0.n(" — ", ArgoScreenKt.fa(job.getErrors().size()), " منبع جواب نداد") : "", ".", androidx.media3.common.s.n("آخرین به\u200cروزرسانی ", ArgoScreenKt.ago(job.getEndedAt()), !kotlin.text.o.L0(job.getVia()) ? w0.n(" (از راه ", job.getVia(), ")") : "", ": ", ArgoScreenKt.fa(job.getFound()))), "Last refresh " + ArgoScreenKt.ago(job.getEndedAt()) + (!kotlin.text.o.L0(job.getVia()) ? w0.n(" (via ", job.getVia(), ")") : "") + ": " + job.getFound() + " new" + (!job.getErrors().isEmpty() ? androidx.compose.foundation.interaction.f.o(job.getErrors().size(), " — ", " sources did not answer") : "") + ".");
                }
                ios = Ios.INSTANCE;
                long secondaryLabel = ios.getSecondaryLabel(oVar2, 6);
                long jT = x6.a.t(12);
                float f11 = 6;
                p0Var2 = p0Var;
                androidx.compose.ui.t tVarZ = f0.z(qVar, 0.0f, f11, 0.0f, 0.0f, 13);
                str2 = str;
                e2Var3 = e2Var2;
                k9.b(strTr, tVarZ, secondaryLabel, jT, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
                oVar3 = oVar;
                p0Var2.e0(-267566166);
                if (z12) {
                    kotlin.jvm.internal.j.b(job);
                    int done = job.getDone();
                    int total = job.getTotal();
                    String label = job.getLabel();
                    String strFa = ArgoScreenKt.fa(job.getFound());
                    if (kotlin.text.o.L0(job.getVia())) {
                        strH = "";
                    } else {
                        strH = v0.a.h(" · از راه ", job.getVia());
                    }
                    String strK = g1.k(label, " · ", strFa, str2, strH);
                    z10 = false;
                    ArgoScreenKt.JobLine(done, total, StoreNetKt.tr(strK, job.getLabel() + " · " + job.getFound() + " new" + (kotlin.text.o.L0(job.getVia()) ? "" : v0.a.h(" · via ", job.getVia()))), oVar3, 0);
                } else {
                    z10 = false;
                }
                p0Var2.u(z10);
                p0Var2.e0(-267558033);
                if (job != 0 || job.getRunning() || job.getErrors().isEmpty()) {
                    p0Var3 = p0Var2;
                    z11 = z10;
                } else {
                    p0Var3 = p0Var2;
                    k9.b(kotlin.collections.q.F0(job.getErrors(), "\n", null, null, null, 62), f0.z(qVar, 0.0f, 4, 0.0f, 0.0f, 13), ios.getSecondaryLabel(oVar3, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
                    oVar3 = oVar;
                    z11 = false;
                }
                p0Var3.u(z11);
                k9.b(StoreNetKt.tr("تلگرام و گیت\u200cهاب روی بیشتر اینترنت\u200cهای ایران فیلترند: پیش از «به\u200cروزرسانی» یکی از موتورهای برنامه را وصل کنید — خود آرگو، V2Ray، سایفون، تور یا هر کدام. دریافت خودبه\u200cخود از داخل همان می\u200cرود.", "Telegram and GitHub are filtered on most Iranian lines: connect one of the app's engines before «Refresh» — Argo itself, V2Ray, Psiphon, Tor or any. The fetch goes through it by itself."), f0.z(qVar, 0.0f, f11, 0.0f, 0.0f, 13), ios.getSecondaryLabel(oVar3, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, x6.a.t(17), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
                w0.z(p0Var3, false, true, false, false);
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("منبع خودتان", "Your own source"), 0.0f, oVar, 0, 2);
                androidx.compose.ui.t tVarX = f0.x(d3.e(qVar, 1.0f), f10, 0.0f, 2);
                k2Var = this.$input$delegate;
                k2Var2 = this.$err$delegate;
                k2Var3 = this.$note$delegate;
                p0Var3.e0(-483455358);
                k0 k0VarA2 = c0.a(bVar, hVar, oVar);
                p0Var3.e0(-1323940314);
                iE = b1.E(oVar);
                w2 w2VarO2 = p0Var3.o();
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarX);
                p0Var3.h0();
                if (p0Var3.M) {
                    p0Var3.n(l0Var);
                } else {
                    p0Var3.t0();
                }
                b1.Y(oVar, pVar, k0VarA2);
                b1.Y(oVar, rVar, w2VarO2);
                if (p0Var3.M || !kotlin.jvm.internal.j.a(p0Var3.I(), Integer.valueOf(iE))) {
                    w0.u(iE, p0Var3, iE, mVar);
                }
                com.mlmvpn.scanner.e.v(oVar, eVarM2, oVar, 0);
                p0Var3.e0(2058660585);
                p0Var4 = p0Var3;
                k9.b(StoreNetKt.tr("کانال تلگرام یا نشانی گیت\u200cهاب", "A Telegram channel or a GitHub link"), null, ios.getLabel(oVar, 6), x6.a.t(15), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
                float f12 = 8;
                k9.b(StoreNetKt.tr("\u200e@name یا t.me/name برای کانال عمومی تلگرام؛ نشانی فایل یا مخزن گیت\u200cهاب، یا هر نشانی http(s) که متنش پل یا فالکن دارد. همان لحظه گرفته می\u200cشود و از آن به بعد با «به\u200cروزرسانی» هم.", "@name or t.me/name for a public Telegram channel; a GitHub file or repository, or any http(s) link whose text holds bridges or falcons. Fetched at once, and with every «Refresh» after."), f0.z(qVar, 0.0f, 2, 0.0f, f12, 5), ios.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(19), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
                String strArgoSources$lambda$179 = ArgoScreenKt.ArgoSources$lambda$179(k2Var);
                p0Var4.e0(-267506555);
                objI2 = p0Var4.I();
                if (objI2 == e2Var3) {
                    k2Var4 = k2Var;
                    objI2 = new k(5, k2Var4);
                    p0Var4.r0(objI2);
                } else {
                    k2Var4 = k2Var;
                }
                p0Var4.u(false);
                oVar4 = oVar;
                ArgoScreenKt.Field(strArgoSources$lambda$179, (ee.c) objI2, "@channel  |  https://t.me/channel  |  https://github.com/user/repo/blob/main/argo.txt", 0, null, oVar4, 432, 24);
                String strI = g1.i(qVar, f12, oVar4, "افزودن و دریافت", "Add and fetch");
                p0Var4.e0(-267499179);
                objI3 = p0Var4.I();
                if (objI3 == e2Var3) {
                    k2Var5 = k2Var2;
                    k2Var6 = k2Var3;
                    i10 = 2;
                    objI3 = new v(k2Var5, k2Var6, k2Var4, i10);
                    p0Var4.r0(objI3);
                } else {
                    k2Var5 = k2Var2;
                    k2Var6 = k2Var3;
                    i10 = 2;
                }
                p0Var4.u(false);
                ArgoScreenKt.Btn(strI, true, false, null, (ee.a) objI3, oVar4, 48, 12);
                p0Var4.e0(-267486855);
                if (kotlin.text.o.L0(ArgoScreenKt.ArgoSources$lambda$182(k2Var5))) {
                    ios2 = ios;
                    i11 = 6;
                } else {
                    androidx.compose.ui.graphics.vector.f fVarL = x6.t.l();
                    ios2 = ios;
                    long red = ios2.getRed(oVar4, 6);
                    String strArgoSources$lambda$182 = ArgoScreenKt.ArgoSources$lambda$182(k2Var5);
                    i11 = 6;
                    ArgoScreenKt.m546Callout8V94_ZQ(fVarL, red, strArgoSources$lambda$182, null, null, oVar, 0, 24);
                    oVar4 = oVar;
                }
                p0Var4.u(false);
                p0Var4.e0(-267484319);
                if (!kotlin.text.o.L0(ArgoScreenKt.ArgoSources$lambda$185(k2Var6))) {
                    ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios2.getGreen(oVar4, i11), ArgoScreenKt.ArgoSources$lambda$185(k2Var6), null, null, oVar, 0, 24);
                    oVar4 = oVar;
                }
                w0.z(p0Var4, false, false, true, false);
                p0Var4.u(false);
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("منابع", "Sources"), 0.0f, oVar4, 0, i10);
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar4, 1797389846, new AnonymousClass3(this.$sources, this.$updating, this.$note$delegate)), oVar, 384, 3);
                IosSettingsKt.SettingsFooter(StoreNetKt.tr("تلگرام و گیت\u200cهاب روی بعضی اینترنت\u200cها فیلترند: اگر موتوری از همین برنامه وصل باشد، دریافت از داخل همان می\u200cرود. فهرست رسمی سرورهای عمومی آرگو امضای خود آرگو را دارد و فقط با امضای درست پذیرفته می\u200cشود؛ پل\u200cها هم.", "Telegram and GitHub are filtered on some lines: when one of the app's engines is connected, the fetch goes through it. Argo's official public-server list carries Argo's own signature and is accepted only with a valid one; so are bridges."), oVar, 0);
                f0.e(oVar, d3.g(qVar, 40));
            }
            job = job2;
            w0.u(iE2, p0Var6, iE2, mVar);
            com.mlmvpn.scanner.e.v(oVar, eVarM, oVar, 0);
            p0Var6.e0(2058660585);
            e2Var = androidx.compose.runtime.n.f3284a;
            if (z12) {
                p0Var6.e0(-267601221);
                String strTr4 = StoreNetKt.tr("توقف به\u200cروزرسانی", "Stop the refresh");
                androidx.compose.ui.graphics.vector.f fVarY2 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                p0Var6.e0(-267598896);
                objI4 = p0Var6.I();
                if (objI4 == e2Var) {
                    i12 = 1;
                    objI4 = new r(i12);
                    p0Var6.r0(objI4);
                } else {
                    i12 = 1;
                }
                p0Var6.u(false);
                p0Var = p0Var6;
                bVar = bVar2;
                e2Var2 = e2Var;
                hVar = hVar2;
                ArgoScreenKt.Btn(strTr4, false, false, fVarY2, (ee.a) objI4, oVar, 24576, 6);
                p0Var.u(false);
                oVar2 = oVar;
            } else {
                p0Var = p0Var6;
                bVar = bVar2;
                hVar = hVar2;
                e2Var2 = e2Var;
                p0Var.e0(-267597423);
                String strTr5 = StoreNetKt.tr("به\u200cروزرسانی پل\u200cها و فالکن\u200cها", "Refresh bridges and falcons");
                androidx.compose.ui.graphics.vector.f fVarE2 = x6.q.E();
                p0Var.e0(-267594292);
                objI = p0Var.I();
                if (objI == e2Var2) {
                    objI = new r(2);
                    p0Var.r0(objI);
                }
                p0Var.u(false);
                oVar2 = oVar;
                ArgoScreenKt.Btn(strTr5, false, false, fVarE2, (ee.a) objI, oVar2, 24576, 6);
                p0Var.u(false);
            }
            str = " مورد تازه";
            if (job != 0) {
                str = " مورد تازه";
                e2Var2 = e2Var2;
                strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cهای تازه از همهٔ منابع روشن گرفته می\u200cشوند؛ هر چه از قبل دارید می\u200cماند.", "New bridges and falcons are fetched from every source that is on; whatever you have stays.");
            } else {
                str = " مورد تازه";
                e2Var2 = e2Var2;
                strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cهای تازه از همهٔ منابع روشن گرفته می\u200cشوند؛ هر چه از قبل دارید می\u200cماند.", "New bridges and falcons are fetched from every source that is on; whatever you have stays.");
            }
            ios = Ios.INSTANCE;
            long secondaryLabel2 = ios.getSecondaryLabel(oVar2, 6);
            long jT2 = x6.a.t(12);
            float f13 = 6;
            p0Var2 = p0Var;
            androidx.compose.ui.t tVarZ2 = f0.z(qVar, 0.0f, f13, 0.0f, 0.0f, 13);
            str2 = str;
            e2Var3 = e2Var2;
            k9.b(strTr, tVarZ2, secondaryLabel2, jT2, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 131056);
            oVar3 = oVar;
            p0Var2.e0(-267566166);
            if (z12) {
                kotlin.jvm.internal.j.b(job);
                int done2 = job.getDone();
                int total2 = job.getTotal();
                String label2 = job.getLabel();
                String strFa2 = ArgoScreenKt.fa(job.getFound());
                if (kotlin.text.o.L0(job.getVia())) {
                    strH = v0.a.h(" · از راه ", job.getVia());
                } else {
                    strH = "";
                }
                String strK2 = g1.k(label2, " · ", strFa2, str2, strH);
                if (kotlin.text.o.L0(job.getVia())) {
                }
                z10 = false;
                ArgoScreenKt.JobLine(done2, total2, StoreNetKt.tr(strK2, job.getLabel() + " · " + job.getFound() + " new" + (kotlin.text.o.L0(job.getVia()) ? "" : v0.a.h(" · via ", job.getVia()))), oVar3, 0);
            } else {
                z10 = false;
            }
            p0Var2.u(z10);
            p0Var2.e0(-267558033);
            if (job != 0) {
                p0Var3 = p0Var2;
                z11 = z10;
            } else {
                p0Var3 = p0Var2;
                z11 = z10;
            }
            p0Var3.u(z11);
            k9.b(StoreNetKt.tr("تلگرام و گیت\u200cهاب روی بیشتر اینترنت\u200cهای ایران فیلترند: پیش از «به\u200cروزرسانی» یکی از موتورهای برنامه را وصل کنید — خود آرگو، V2Ray، سایفون، تور یا هر کدام. دریافت خودبه\u200cخود از داخل همان می\u200cرود.", "Telegram and GitHub are filtered on most Iranian lines: connect one of the app's engines before «Refresh» — Argo itself, V2Ray, Psiphon, Tor or any. The fetch goes through it by itself."), f0.z(qVar, 0.0f, f13, 0.0f, 0.0f, 13), ios.getSecondaryLabel(oVar3, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, x6.a.t(17), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
            w0.z(p0Var3, false, true, false, false);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("منبع خودتان", "Your own source"), 0.0f, oVar, 0, 2);
            androidx.compose.ui.t tVarX2 = f0.x(d3.e(qVar, 1.0f), f10, 0.0f, 2);
            k2Var = this.$input$delegate;
            k2Var2 = this.$err$delegate;
            k2Var3 = this.$note$delegate;
            p0Var3.e0(-483455358);
            k0 k0VarA3 = c0.a(bVar, hVar, oVar);
            p0Var3.e0(-1323940314);
            iE = b1.E(oVar);
            w2 w2VarO3 = p0Var3.o();
            androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarX2);
            p0Var3.h0();
            if (p0Var3.M) {
                p0Var3.n(l0Var);
            } else {
                p0Var3.t0();
            }
            b1.Y(oVar, pVar, k0VarA3);
            b1.Y(oVar, rVar, w2VarO3);
            if (p0Var3.M) {
                w0.u(iE, p0Var3, iE, mVar);
            } else {
                w0.u(iE, p0Var3, iE, mVar);
            }
            com.mlmvpn.scanner.e.v(oVar, eVarM3, oVar, 0);
            p0Var3.e0(2058660585);
            p0Var4 = p0Var3;
            k9.b(StoreNetKt.tr("کانال تلگرام یا نشانی گیت\u200cهاب", "A Telegram channel or a GitHub link"), null, ios.getLabel(oVar, 6), x6.a.t(15), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, 199680, 0, 131026);
            float f14 = 8;
            k9.b(StoreNetKt.tr("\u200e@name یا t.me/name برای کانال عمومی تلگرام؛ نشانی فایل یا مخزن گیت\u200cهاب، یا هر نشانی http(s) که متنش پل یا فالکن دارد. همان لحظه گرفته می\u200cشود و از آن به بعد با «به\u200cروزرسانی» هم.", "@name or t.me/name for a public Telegram channel; a GitHub file or repository, or any http(s) link whose text holds bridges or falcons. Fetched at once, and with every «Refresh» after."), f0.z(qVar, 0.0f, 2, 0.0f, f14, 5), ios.getSecondaryLabel(oVar, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, x6.a.t(19), 0, false, 0, 0, null, null, oVar, 3120, 6, 130032);
            String strArgoSources$lambda$1710 = ArgoScreenKt.ArgoSources$lambda$179(k2Var);
            p0Var4.e0(-267506555);
            objI2 = p0Var4.I();
            if (objI2 == e2Var3) {
                k2Var4 = k2Var;
                objI2 = new k(5, k2Var4);
                p0Var4.r0(objI2);
            } else {
                k2Var4 = k2Var;
            }
            p0Var4.u(false);
            oVar4 = oVar;
            ArgoScreenKt.Field(strArgoSources$lambda$1710, (ee.c) objI2, "@channel  |  https://t.me/channel  |  https://github.com/user/repo/blob/main/argo.txt", 0, null, oVar4, 432, 24);
            String strI2 = g1.i(qVar, f14, oVar4, "افزودن و دریافت", "Add and fetch");
            p0Var4.e0(-267499179);
            objI3 = p0Var4.I();
            if (objI3 == e2Var3) {
                k2Var5 = k2Var2;
                k2Var6 = k2Var3;
                i10 = 2;
                objI3 = new v(k2Var5, k2Var6, k2Var4, i10);
                p0Var4.r0(objI3);
            } else {
                k2Var5 = k2Var2;
                k2Var6 = k2Var3;
                i10 = 2;
            }
            p0Var4.u(false);
            ArgoScreenKt.Btn(strI2, true, false, null, (ee.a) objI3, oVar4, 48, 12);
            p0Var4.e0(-267486855);
            if (kotlin.text.o.L0(ArgoScreenKt.ArgoSources$lambda$182(k2Var5))) {
                androidx.compose.ui.graphics.vector.f fVarL2 = x6.t.l();
                ios2 = ios;
                long red2 = ios2.getRed(oVar4, 6);
                String strArgoSources$lambda$183 = ArgoScreenKt.ArgoSources$lambda$182(k2Var5);
                i11 = 6;
                ArgoScreenKt.m546Callout8V94_ZQ(fVarL2, red2, strArgoSources$lambda$183, null, null, oVar, 0, 24);
                oVar4 = oVar;
            } else {
                ios2 = ios;
                i11 = 6;
            }
            p0Var4.u(false);
            p0Var4.e0(-267484319);
            if (!kotlin.text.o.L0(ArgoScreenKt.ArgoSources$lambda$185(k2Var6))) {
                ArgoScreenKt.m546Callout8V94_ZQ(com.google.android.gms.internal.auth.j.o(), ios2.getGreen(oVar4, i11), ArgoScreenKt.ArgoSources$lambda$185(k2Var6), null, null, oVar, 0, 24);
                oVar4 = oVar;
            }
            w0.z(p0Var4, false, false, true, false);
            p0Var4.u(false);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("منابع", "Sources"), 0.0f, oVar4, 0, i10);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar4, 1797389846, new AnonymousClass3(this.$sources, this.$updating, this.$note$delegate)), oVar, 384, 3);
            IosSettingsKt.SettingsFooter(StoreNetKt.tr("تلگرام و گیت\u200cهاب روی بعضی اینترنت\u200cها فیلترند: اگر موتوری از همین برنامه وصل باشد، دریافت از داخل همان می\u200cرود. فهرست رسمی سرورهای عمومی آرگو امضای خود آرگو را دارد و فقط با امضای درست پذیرفته می\u200cشود؛ پل\u200cها هم.", "Telegram and GitHub are filtered on some lines: when one of the app's engines is connected, the fetch goes through it. Argo's official public-server list carries Argo's own signature and is accepted only with a valid one; so are bridges."), oVar, 0);
            f0.e(oVar, d3.g(qVar, 40));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Page.values().length];
            try {
                iArr[Page.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Page.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Page.CLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Page.ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Page.SOURCES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Page.LOGS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArgoEngine.Step.values().length];
            try {
                iArr2[ArgoEngine.Step.AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ArgoEngine.Step.ENGINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ArgoEngine.Step.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ArgoEngine.Step.ROUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final void ArgoAdd(ee.c cVar, androidx.compose.runtime.o oVar, int i) {
        int i10;
        e2 e2Var = e2.f3199e;
        p0 p0Var = (p0) oVar;
        p0Var.f0(1773573722);
        if ((i & 6) == 0) {
            i10 = (p0Var.h(cVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i11 = 0;
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var.l(w1.f4590b);
            ArgoPool argoPool = ArgoPool.INSTANCE;
            long jArgoAdd$lambda$156 = ArgoAdd$lambda$156(b1.x(argoPool.getVersion(), p0Var));
            p0Var.e0(-351816662);
            boolean zE = p0Var.e(jArgoAdd$lambda$156);
            Object objI = p0Var.I();
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (zE || objI == e2Var2) {
                objI = argoPool.summary();
                p0Var.r0(objI);
            }
            ArgoPool.Summary summary = (ArgoPool.Summary) objI;
            p0Var.u(false);
            Object[] objArr = new Object[0];
            p0Var.e0(-351814312);
            Object objI2 = p0Var.I();
            if (objI2 == e2Var2) {
                objI2 = new r(7);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            k2 k2Var = (k2) x6.t.q(objArr, null, (ee.a) objI2, p0Var, 6);
            p0Var.e0(-351812971);
            Object objI3 = p0Var.I();
            if (objI3 == e2Var2) {
                objI3 = b1.N(null, e2Var);
                p0Var.r0(objI3);
            }
            k2 k2Var2 = (k2) objI3;
            Object objH = w0.h(-351810847, p0Var, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var.r0(objH);
            }
            k2 k2Var3 = (k2) objH;
            Object objH2 = w0.h(-351809311, p0Var, false);
            if (objH2 == e2Var2) {
                objH2 = b1.N("", e2Var);
                p0Var.r0(objH2);
            }
            k2 k2Var4 = (k2) objH2;
            p0Var.u(false);
            p0Var.e0(-351807213);
            int i12 = i10 & 14;
            boolean z10 = i12 == 4;
            Object objI4 = p0Var.I();
            if (z10 || objI4 == e2Var2) {
                objI4 = new z(cVar, 12);
                p0Var.r0(objI4);
            }
            p0Var.u(false);
            ee.e eVarRememberConnect = rememberConnect((ee.a) objI4, p0Var, 0, 0);
            String strTr = StoreNetKt.tr("افزودن پل یا فالکن", "Add a bridge or falcon");
            p0Var.e0(-351803981);
            boolean z11 = i12 == 4;
            Object objI5 = p0Var.I();
            if (z11 || objI5 == e2Var2) {
                objI5 = new z(cVar, 13);
                p0Var.r0(objI5);
            }
            p0Var.u(false);
            IosSettingsKt.IosScreen(strTr, (ee.a) objI5, TITLE, null, null, false, null, null, x6.p.f(p0Var, 2098766340, new AnonymousClass2(k2Var, k2Var2, context, eVarRememberConnect, k2Var3, k2Var4, summary)), p0Var, 100663680, 248);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new g(i, i11, cVar);
        }
    }

    private static final long ArgoAdd$lambda$156(l4 l4Var) {
        return ((Number) l4Var.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 ArgoAdd$lambda$159$lambda$158() {
        return b1.N("", e2.f3199e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoAdd$lambda$160(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoAdd$lambda$161(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArgoPool.Parsed ArgoAdd$lambda$163(k2 k2Var) {
        return (ArgoPool.Parsed) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoAdd$lambda$164(k2 k2Var, ArgoPool.Parsed parsed) {
        k2Var.setValue(parsed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoAdd$lambda$166(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoAdd$lambda$167(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoAdd$lambda$169(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoAdd$lambda$170(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoAdd$lambda$172$lambda$171(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoAdd$lambda$174$lambda$173(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoAdd$lambda$175(ee.c cVar, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoAdd(cVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    private static final void ArgoClean(ee.c cVar, String str, androidx.compose.runtime.o oVar, int i) {
        int i10;
        p0 p0Var;
        int i11;
        e2 e2Var = e2.f3199e;
        p0 p0Var2 = (p0) oVar;
        p0Var2.f0(1375596859);
        if ((i & 6) == 0) {
            i10 = (p0Var2.h(cVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var2.f(str) ? 32 : 16;
        }
        if ((i10 & 19) == 18 && p0Var2.G()) {
            p0Var2.Y();
            p0Var = p0Var2;
            i11 = 1;
        } else {
            r0 r0Var = v0.f3474a;
            ArgoPool argoPool = ArgoPool.INSTANCE;
            long jArgoClean$lambda$140 = ArgoClean$lambda$140(b1.x(argoPool.getVersion(), p0Var2));
            p0Var2.e0(1536427666);
            boolean zE = p0Var2.e(jArgoClean$lambda$140);
            Object objI = p0Var2.I();
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (zE || objI == e2Var2) {
                objI = argoPool.summary();
                p0Var2.r0(objI);
            }
            ArgoPool.Summary summary = (ArgoPool.Summary) objI;
            p0Var2.u(false);
            int i12 = i10;
            ArgoPool.IpScan ipScan = argoPool.getIpScan();
            ArgoPool.Job testJob = argoPool.getTestJob();
            String cleanIp = summary.getPrefs().getCleanIp();
            p0Var2.e0(1536432457);
            Object objI2 = p0Var2.I();
            if (objI2 == e2Var2) {
                objI2 = b1.N("", e2Var);
                p0Var2.r0(objI2);
            }
            k2 k2Var = (k2) objI2;
            Object objH = w0.h(1536433993, p0Var2, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var2.r0(objH);
            }
            k2 k2Var2 = (k2) objH;
            Object objH2 = w0.h(1536435594, p0Var2, false);
            if (objH2 == e2Var2) {
                objH2 = b1.N(cleanIp, e2Var);
                p0Var2.r0(objH2);
            }
            k2 k2Var3 = (k2) objH2;
            p0Var2.u(false);
            p0Var2.e0(1536437723);
            int i13 = i12 & 14;
            boolean z10 = i13 == 4;
            Object objI3 = p0Var2.I();
            if (z10 || objI3 == e2Var2) {
                objI3 = new z(cVar, 7);
                p0Var2.r0(objI3);
            }
            p0Var2.u(false);
            ee.e eVarRememberConnect = rememberConnect((ee.a) objI3, p0Var2, 0, 0);
            String strTr = StoreNetKt.tr("آی\u200cپی تمیز (رفع فیلتر)", "Clean IP (unblocking)");
            p0Var2.e0(1536441051);
            boolean z11 = i13 == 4;
            Object objI4 = p0Var2.I();
            if (z11 || objI4 == e2Var2) {
                objI4 = new z(cVar, 8);
                p0Var2.r0(objI4);
            }
            p0Var2.u(false);
            p0Var = p0Var2;
            i11 = 1;
            IosSettingsKt.IosScreen(strTr, (ee.a) objI4, TITLE, null, null, false, null, null, x6.p.f(p0Var2, 1300063441, new C08882(ipScan, summary, cleanIp, testJob, k2Var, k2Var2, k2Var3, str, eVarRememberConnect)), p0Var, 100663680, 248);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new i(cVar, str, i, i11);
        }
    }

    private static final long ArgoClean$lambda$140(l4 l4Var) {
        return ((Number) l4Var.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoClean$lambda$143(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoClean$lambda$144(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoClean$lambda$146(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoClean$lambda$147(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoClean$lambda$149(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoClean$lambda$150(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoClean$lambda$152$lambda$151(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoClean$lambda$154$lambda$153(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoClean$lambda$155(ee.c cVar, String str, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoClean(cVar, str, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    private static final void ArgoList(ee.c cVar, String str, ee.c cVar2, androidx.compose.runtime.o oVar, int i) {
        int i10;
        String str2;
        ee.c cVar3;
        int i11;
        e2 e2Var = e2.f3199e;
        p0 p0Var = (p0) oVar;
        p0Var.f0(1468829585);
        int i12 = 4;
        if ((i & 6) == 0) {
            i10 = (p0Var.h(cVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            str2 = str;
            i10 |= p0Var.f(str2) ? 32 : 16;
        } else {
            str2 = str;
        }
        if ((i & 384) == 0) {
            cVar3 = cVar2;
            i10 |= p0Var.h(cVar3) ? 256 : 128;
        } else {
            cVar3 = cVar2;
        }
        if ((i10 & 147) == 146 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            ArgoPool argoPool = ArgoPool.INSTANCE;
            k2 k2VarX = b1.x(argoPool.getVersion(), p0Var);
            k2 k2VarX2 = b1.x(ArgoEngine.INSTANCE.getConn(), p0Var);
            long jArgoList$lambda$90 = ArgoList$lambda$90(k2VarX);
            p0Var.e0(-2049422459);
            boolean zE = p0Var.e(jArgoList$lambda$90);
            Object objI = p0Var.I();
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (zE || objI == e2Var2) {
                objI = argoPool.summary();
                p0Var.r0(objI);
            }
            ArgoPool.Summary summary = (ArgoPool.Summary) objI;
            p0Var.u(false);
            ArgoPool.Job testJob = argoPool.getTestJob();
            ArgoPool.Job updateJob = argoPool.getUpdateJob();
            boolean z10 = testJob != null && testJob.getRunning();
            Object[] objArr = new Object[0];
            p0Var.e0(-2049416738);
            Object objI2 = p0Var.I();
            if (objI2 == e2Var2) {
                objI2 = new r(3);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            int i13 = 6;
            k2 k2Var = (k2) x6.t.q(objArr, null, (ee.a) objI2, p0Var, 6);
            Object[] objArr2 = new Object[0];
            p0Var.e0(-2049414573);
            Object objI3 = p0Var.I();
            if (objI3 == e2Var2) {
                objI3 = new r(i12);
                p0Var.r0(objI3);
            }
            p0Var.u(false);
            k2 k2Var2 = (k2) x6.t.q(objArr2, null, (ee.a) objI3, p0Var, 6);
            p0Var.e0(-2049413348);
            Object objI4 = p0Var.I();
            if (objI4 == e2Var2) {
                objI4 = b1.N("", e2Var);
                p0Var.r0(objI4);
            }
            k2 k2Var3 = (k2) objI4;
            Object objH = w0.h(-2049411812, p0Var, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var.r0(objH);
            }
            k2 k2Var4 = (k2) objH;
            p0Var.u(false);
            p0Var.e0(-2049409714);
            int i14 = i10 & 14;
            boolean z11 = i14 == 4;
            Object objI5 = p0Var.I();
            if (z11 || objI5 == e2Var2) {
                objI5 = new z(cVar, 9);
                p0Var.r0(objI5);
            }
            p0Var.u(false);
            ee.e eVarRememberConnect = rememberConnect((ee.a) objI5, p0Var, 0, 0);
            ArgoEngine.Conn connArgoList$lambda$91 = ArgoList$lambda$91(k2VarX2);
            ArgoEngine.Conn.Connected connected = connArgoList$lambda$91 instanceof ArgoEngine.Conn.Connected ? (ArgoEngine.Conn.Connected) connArgoList$lambda$91 : null;
            String id2 = connected != null ? connected.getId() : null;
            boolean z12 = ArgoList$lambda$91(k2VarX2) instanceof ArgoEngine.Conn.Connecting;
            boolean z13 = !kotlin.text.o.L0(summary.getPrefs().getCleanIp());
            p0Var.e0(-2049402126);
            boolean zF = p0Var.f(eVarRememberConnect);
            Object objI6 = p0Var.I();
            if (zF || objI6 == e2Var2) {
                i11 = 1;
                objI6 = new a0(eVarRememberConnect, i11);
                p0Var.r0(objI6);
            } else {
                i11 = 1;
            }
            ee.c cVar4 = (ee.c) objI6;
            Object objH2 = w0.h(-2049401023, p0Var, false);
            if (objH2 == e2Var2) {
                objH2 = new k(i13, k2Var3);
                p0Var.r0(objH2);
            }
            ee.c cVar5 = (ee.c) objH2;
            p0Var.u(false);
            p0Var.e0(-2049397521);
            int i15 = i14 == 4 ? i11 : 0;
            Object objI7 = p0Var.I();
            if (i15 != 0 || objI7 == e2Var2) {
                objI7 = new z(cVar, 10);
                p0Var.r0(objI7);
            }
            p0Var.u(false);
            RowCtx rowCtx = new RowCtx(id2, z12, z10, z13, cVar4, cVar5, (ee.a) objI7);
            String strTr = StoreNetKt.tr("پل\u200cها و فالکن\u200cها", "Bridges and falcons");
            p0Var.e0(-2049394354);
            if (i14 != 4) {
                i11 = 0;
            }
            Object objI8 = p0Var.I();
            if (i11 != 0 || objI8 == e2Var2) {
                objI8 = new z(cVar, 11);
                p0Var.r0(objI8);
            }
            p0Var.u(false);
            IosSettingsKt.IosScreen(strTr, (ee.a) objI8, TITLE, null, null, false, null, null, x6.p.f(p0Var, -70859589, new C08892(str2, testJob, updateJob, summary, k2Var2, z10, k2Var4, k2Var3, cVar3, k2VarX, rowCtx, k2Var)), p0Var, 100663680, 248);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new b((Object) cVar, str, (Object) cVar2, i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoList$lambda$100(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoList$lambda$102(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoList$lambda$103(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoList$lambda$105(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoList$lambda$106(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$108$lambda$107(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$110$lambda$109(ee.e eVar, String it) {
        kotlin.jvm.internal.j.e(it, "it");
        eVar.invoke(it, null);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$113$lambda$112(k2 k2Var, String id2) {
        Object objM1004constructorimpl;
        sd.u uVar = sd.u.f67154a;
        kotlin.jvm.internal.j.e(id2, "id");
        try {
            ArgoPool.test$default(ArgoPool.INSTANCE, null, null, m9.d.B(id2), false, false, false, 59, null);
            objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
        }
        Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
        String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
        if (message == null) {
            message = "";
        }
        k2Var.setValue(message);
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$115$lambda$114(ee.c cVar) {
        cVar.invoke(Page.CLEAN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$117$lambda$116(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoList$lambda$118(ee.c cVar, String str, ee.c cVar2, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoList(cVar, str, cVar2, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ArgoList$lambda$90(l4 l4Var) {
        return ((Number) l4Var.getValue()).longValue();
    }

    private static final ArgoEngine.Conn ArgoList$lambda$91(l4 l4Var) {
        return (ArgoEngine.Conn) l4Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 ArgoList$lambda$94$lambda$93() {
        return b1.N(null, e2.f3199e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoList$lambda$95(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoList$lambda$96(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 ArgoList$lambda$98$lambda$97() {
        return b1.N("", e2.f3199e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoList$lambda$99(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    private static final void ArgoLogs(ee.c cVar, androidx.compose.runtime.o oVar, int i) {
        int i10;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-437428834);
        int i11 = 2;
        if ((i & 6) == 0) {
            i10 = (p0Var.h(cVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            final k2 k2VarX = b1.x(ArgoEngine.INSTANCE.getLogs(), p0Var);
            String strTr = StoreNetKt.tr("لاگ", "Log");
            p0Var.e0(-2043031265);
            boolean z10 = (i10 & 14) == 4;
            Object objI = p0Var.I();
            if (z10 || objI == androidx.compose.runtime.n.f3284a) {
                objI = new z(cVar, 15);
                p0Var.r0(objI);
            }
            p0Var.u(false);
            IosSettingsKt.IosScreen(strTr, (ee.a) objI, TITLE, null, null, false, null, null, x6.p.f(p0Var, 1053607732, new ee.f() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.ArgoLogs.2
                @Override // ee.f
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((d0) obj, (androidx.compose.runtime.o) obj2, ((Number) obj3).intValue());
                    return sd.u.f67154a;
                }

                public final void invoke(d0 IosScreen, androidx.compose.runtime.o oVar2, int i12) {
                    androidx.compose.runtime.o oVar3 = oVar2;
                    kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
                    if ((i12 & 17) == 16) {
                        p0 p0Var2 = (p0) oVar3;
                        if (p0Var2.G()) {
                            p0Var2.Y();
                            return;
                        }
                    }
                    r0 r0Var2 = v0.f3474a;
                    boolean z11 = false;
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("رویدادهای اتصال", "Connection events"), 0.0f, oVar3, 0, 2);
                    androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarV = f0.v(GlassKt.frostedGlass(f0.x(d3.e(qVar, 1.0f), 16, 0.0f, 2), e0.e.b(14), false, false, oVar3, 6, 6), 12);
                    l4 l4Var = k2VarX;
                    p0 p0Var3 = (p0) oVar3;
                    p0Var3.e0(-483455358);
                    k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, oVar3);
                    p0Var3.e0(-1323940314);
                    int iE = b1.E(oVar3);
                    w2 w2VarO = p0Var3.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0 l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarV);
                    p0Var3.h0();
                    if (p0Var3.M) {
                        p0Var3.n(l0Var);
                    } else {
                        p0Var3.t0();
                    }
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarA);
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                    androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                    if (p0Var3.M || !kotlin.jvm.internal.j.a(p0Var3.I(), Integer.valueOf(iE))) {
                        w0.u(iE, p0Var3, iE, mVar);
                    }
                    eVarM.invoke(new r3(oVar3), oVar3, 0);
                    p0Var3.e0(2058660585);
                    p0Var3.e0(-1680675528);
                    List listArgoLogs$lambda$190 = ArgoScreenKt.ArgoLogs$lambda$190(l4Var);
                    if (listArgoLogs$lambda$190.isEmpty()) {
                        listArgoLogs$lambda$190 = m9.d.B(StoreNetKt.tr("هنوز رویدادی نیست.", "No events yet."));
                    }
                    Iterator it = listArgoLogs$lambda$190.iterator();
                    while (it.hasNext()) {
                        k9.b((String) it.next(), null, Ios.INSTANCE.getLabel(oVar3, 6), x6.a.t(11), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, x6.a.t(15), 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 6, 129970);
                        oVar3 = oVar2;
                        p0Var3 = p0Var3;
                        qVar = qVar;
                        z11 = false;
                    }
                    p0 p0Var4 = p0Var3;
                    w0.z(p0Var4, false, false, true, false);
                    p0Var4.u(false);
                    f0.e(oVar3, d3.g(qVar, 40));
                    r0 r0Var3 = v0.f3474a;
                }
            }), p0Var, 100663680, 248);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new g(i, i11, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> ArgoLogs$lambda$190(l4 l4Var) {
        return (List) l4Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoLogs$lambda$192$lambda$191(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoLogs$lambda$193(ee.c cVar, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoLogs(cVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:86:0x0221  */
    /* JADX WARN: Code duplicated, block: B:90:0x0252  */
    private static final void ArgoMain(ee.a aVar, ee.c cVar, String str, androidx.compose.runtime.o oVar, int i) {
        int i10;
        int i11;
        boolean z10;
        boolean zG;
        Object objI;
        Object objI2;
        k2 k2Var;
        boolean zF;
        Object objI3;
        ee.c cVar2;
        int i12;
        p0 p0Var;
        ee.a aVar2 = aVar;
        e2 e2Var = e2.f3199e;
        p0 p0Var2 = (p0) oVar;
        p0Var2.f0(-1517158491);
        if ((i & 6) == 0) {
            i10 = (p0Var2.h(aVar2) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var2.h(cVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= p0Var2.f(str) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && p0Var2.G()) {
            p0Var2.Y();
            i12 = i;
            p0Var = p0Var2;
            cVar2 = cVar;
        } else {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var2.l(w1.f4590b);
            ArgoEngine argoEngine = ArgoEngine.INSTANCE;
            k2 k2VarX = b1.x(argoEngine.getConn(), p0Var2);
            k2 k2VarX2 = b1.x(argoEngine.getLastWhy(), p0Var2);
            ArgoPool argoPool = ArgoPool.INSTANCE;
            k2 k2VarX3 = b1.x(argoPool.getVersion(), p0Var2);
            MyVpnService.Companion companion = MyVpnService.Companion;
            k2 k2VarX4 = b1.x(companion.getConnectionPhaseFlow(), p0Var2);
            k2 k2VarX5 = b1.x(companion.getConnectedNodeIdFlow(), p0Var2);
            p0Var2.e0(-2029040137);
            Object objI4 = p0Var2.I();
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (objI4 == e2Var2) {
                objI4 = b1.N("", e2Var);
                p0Var2.r0(objI4);
            }
            k2 k2Var2 = (k2) objI4;
            Object objH = w0.h(-2029038601, p0Var2, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var2.r0(objH);
            }
            k2 k2Var3 = (k2) objH;
            p0Var2.u(false);
            long jArgoMain$lambda$41 = ArgoMain$lambda$41(k2VarX3);
            p0Var2.e0(-2029037120);
            boolean zE = p0Var2.e(jArgoMain$lambda$41);
            Object objI5 = p0Var2.I();
            if (zE || objI5 == e2Var2) {
                objI5 = argoPool.summary();
                p0Var2.r0(objI5);
            }
            ArgoPool.Summary summary = (ArgoPool.Summary) objI5;
            p0Var2.u(false);
            ArgoPool.Job testJob = argoPool.getTestJob();
            ArgoPool.Job updateJob = argoPool.getUpdateJob();
            ArgoPool.IpScan ipScan = argoPool.getIpScan();
            long jArgoMain$lambda$42 = ArgoMain$lambda$41(k2VarX3);
            p0Var2.e0(-2029028675);
            boolean zE2 = p0Var2.e(jArgoMain$lambda$42);
            Object objI6 = p0Var2.I();
            if (zE2 || objI6 == e2Var2) {
                objI6 = (List) ArgoPool.rows$default(argoPool, null, null, null, "alive", 3, 7, null).getSecond();
                p0Var2.r0(objI6);
            }
            List list = (List) objI6;
            p0Var2.u(false);
            boolean z11 = list.isEmpty() && summary.getCounts().getVerified() > 0;
            long jArgoMain$lambda$43 = ArgoMain$lambda$41(k2VarX3);
            p0Var2.e0(-2029023899);
            boolean zE3 = p0Var2.e(jArgoMain$lambda$43) | p0Var2.g(z11);
            Object objI7 = p0Var2.I();
            if (zE3 || objI7 == e2Var2) {
                if (z11) {
                    list = (List) ArgoPool.rows$default(argoPool, null, null, null, "verified", 3, 7, null).getSecond();
                }
                p0Var2.r0(list);
                objI7 = list;
            }
            List list2 = (List) objI7;
            p0Var2.u(false);
            boolean z12 = kotlin.jvm.internal.j.a(ArgoMain$lambda$43(k2VarX5), "argo") && ArgoMain$lambda$42(k2VarX4) == MyVpnService.Phase.CONNECTED;
            boolean z13 = ArgoMain$lambda$39(k2VarX) instanceof ArgoEngine.Conn.Connecting;
            boolean z14 = (ArgoMain$lambda$39(k2VarX) instanceof ArgoEngine.Conn.Connected) || !(!z12 || z13 || (ArgoMain$lambda$39(k2VarX) instanceof ArgoEngine.Conn.Stopping));
            if (testJob != null) {
                i11 = 1;
                z10 = z11;
                boolean z15 = testJob.getRunning();
                ee.e eVarRememberConnect = rememberConnect(null, p0Var2, 0, i11);
                View viewViewOf = viewOf(ArgoMain$lambda$39(k2VarX), z12, summary, testJob);
                p0Var2.e0(-2029004085);
                zG = p0Var2.g(z12) | p0Var2.h(context);
                objI = p0Var2.I();
                if (zG || objI == e2Var2) {
                    objI = new ArgoScreenKt$ArgoMain$1$1(z12, context, null);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                b1.e(p0Var2, (ee.e) objI, sd.u.f67154a);
                p0Var2.e0(-2028996967);
                objI2 = p0Var2.I();
                if (objI2 == e2Var2) {
                    objI2 = b1.N(ArgoMain$lambda$39(k2VarX), e2Var);
                    p0Var2.r0(objI2);
                }
                k2Var = (k2) objI2;
                p0Var2.u(false);
                ArgoEngine.Conn connArgoMain$lambda$39 = ArgoMain$lambda$39(k2VarX);
                p0Var2.e0(-2028994812);
                zF = p0Var2.f(k2VarX) | p0Var2.h(context);
                objI3 = p0Var2.I();
                if (zF || objI3 == e2Var2) {
                    objI3 = new ArgoScreenKt$ArgoMain$2$1(context, k2VarX, k2Var, null);
                    p0Var2.r0(objI3);
                }
                p0Var2.u(false);
                b1.e(p0Var2, (ee.e) objI3, connArgoMain$lambda$39);
                cVar2 = cVar;
                i12 = i;
                p0Var = p0Var2;
                aVar2 = aVar;
                IosSettingsKt.IosScreen(null, aVar2, StoreNetKt.tr("خانه", "Home"), null, null, false, null, null, x6.p.f(p0Var2, 1238119631, new AnonymousClass3(viewViewOf, z15, z13, z14, k2VarX, context, eVarRememberConnect, testJob, summary, str, updateJob, z10, k2Var2, k2Var3, k2VarX2, cVar, list2, ipScan)), p0Var, ((i10 << 3) & 112) | 100663296, 249);
            } else {
                i11 = 1;
                z10 = z11;
            }
            ee.e eVarRememberConnect2 = rememberConnect(null, p0Var2, 0, i11);
            View viewViewOf2 = viewOf(ArgoMain$lambda$39(k2VarX), z12, summary, testJob);
            p0Var2.e0(-2029004085);
            zG = p0Var2.g(z12) | p0Var2.h(context);
            objI = p0Var2.I();
            if (zG) {
                objI = new ArgoScreenKt$ArgoMain$1$1(z12, context, null);
                p0Var2.r0(objI);
            } else {
                objI = new ArgoScreenKt$ArgoMain$1$1(z12, context, null);
                p0Var2.r0(objI);
            }
            p0Var2.u(false);
            b1.e(p0Var2, (ee.e) objI, sd.u.f67154a);
            p0Var2.e0(-2028996967);
            objI2 = p0Var2.I();
            if (objI2 == e2Var2) {
                objI2 = b1.N(ArgoMain$lambda$39(k2VarX), e2Var);
                p0Var2.r0(objI2);
            }
            k2Var = (k2) objI2;
            p0Var2.u(false);
            ArgoEngine.Conn connArgoMain$lambda$310 = ArgoMain$lambda$39(k2VarX);
            p0Var2.e0(-2028994812);
            zF = p0Var2.f(k2VarX) | p0Var2.h(context);
            objI3 = p0Var2.I();
            if (zF) {
                objI3 = new ArgoScreenKt$ArgoMain$2$1(context, k2VarX, k2Var, null);
                p0Var2.r0(objI3);
            } else {
                objI3 = new ArgoScreenKt$ArgoMain$2$1(context, k2VarX, k2Var, null);
                p0Var2.r0(objI3);
            }
            p0Var2.u(false);
            b1.e(p0Var2, (ee.e) objI3, connArgoMain$lambda$310);
            cVar2 = cVar;
            i12 = i;
            p0Var = p0Var2;
            aVar2 = aVar;
            IosSettingsKt.IosScreen(null, aVar2, StoreNetKt.tr("خانه", "Home"), null, null, false, null, null, x6.p.f(p0Var2, 1238119631, new AnonymousClass3(viewViewOf2, z15, z13, z14, k2VarX, context, eVarRememberConnect2, testJob, summary, str, updateJob, z10, k2Var2, k2Var3, k2VarX2, cVar, list2, ipScan)), p0Var, ((i10 << 3) & 112) | 100663296, 249);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new c(aVar2, cVar2, str, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArgoEngine.Conn ArgoMain$lambda$39(l4 l4Var) {
        return (ArgoEngine.Conn) l4Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoMain$lambda$40(l4 l4Var) {
        return (String) l4Var.getValue();
    }

    private static final long ArgoMain$lambda$41(l4 l4Var) {
        return ((Number) l4Var.getValue()).longValue();
    }

    private static final MyVpnService.Phase ArgoMain$lambda$42(l4 l4Var) {
        return (MyVpnService.Phase) l4Var.getValue();
    }

    private static final String ArgoMain$lambda$43(l4 l4Var) {
        return (String) l4Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoMain$lambda$45(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoMain$lambda$46(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoMain$lambda$48(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoMain$lambda$49(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArgoEngine.Conn ArgoMain$lambda$55(k2 k2Var) {
        return (ArgoEngine.Conn) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoMain$lambda$58(ee.a aVar, ee.c cVar, String str, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoMain(aVar, cVar, str, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    public static final void ArgoScreen(ee.a onBack, androidx.compose.runtime.o oVar, int i) {
        int i10;
        kotlin.jvm.internal.j.e(onBack, "onBack");
        p0 p0Var = (p0) oVar;
        p0Var.f0(766821730);
        int i11 = 4;
        if ((i & 6) == 0) {
            i10 = (p0Var.h(onBack) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var.l(w1.f4590b);
            p0Var.e0(-861006163);
            Object objI = p0Var.I();
            e2 e2Var = androidx.compose.runtime.n.f3284a;
            if (objI == e2Var) {
                objI = b1.N(Boolean.FALSE, e2.f3199e);
                p0Var.r0(objI);
            }
            k2 k2Var = (k2) objI;
            int i12 = 0;
            p0Var.u(false);
            p0Var.e0(-861004183);
            boolean zH = p0Var.h(context);
            Object objI2 = p0Var.I();
            if (zH || objI2 == e2Var) {
                objI2 = new ArgoScreenKt$ArgoScreen$1$1(context, k2Var, null);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            b1.e(p0Var, (ee.e) objI2, sd.u.f67154a);
            p0Var.e0(-861001009);
            boolean zArgoScreen$lambda$1 = ArgoScreen$lambda$1(k2Var);
            int i13 = 3;
            if (!zArgoScreen$lambda$1) {
                IosSettingsKt.IosScreen(TITLE, onBack, StoreNetKt.tr("خانه", "Home"), null, null, false, null, null, ComposableSingletons$ArgoScreenKt.INSTANCE.m550getLambda1$app_release(), p0Var, ((i10 << 3) & 112) | 100663302, 248);
                p0Var.u(false);
                androidx.compose.runtime.c3 c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new com.mlmvpn.scanner.ui.amnezia.a(i, i11, onBack);
                    return;
                }
                return;
            }
            p0Var.u(false);
            Object[] objArr = new Object[0];
            p0Var.e0(-860996792);
            Object objI3 = p0Var.I();
            if (objI3 == e2Var) {
                objI3 = new r(8);
                p0Var.r0(objI3);
            }
            p0Var.u(false);
            k2 k2Var2 = (k2) x6.t.q(objArr, null, (ee.a) objI3, p0Var, 6);
            Object[] objArr2 = new Object[0];
            p0Var.e0(-860991132);
            Object objI4 = p0Var.I();
            if (objI4 == e2Var) {
                objI4 = new r(9);
                p0Var.r0(objI4);
            }
            p0Var.u(false);
            k2 k2Var3 = (k2) x6.t.q(objArr2, null, (ee.a) objI4, p0Var, 6);
            boolean z10 = ArgoScreen$lambda$7(k2Var2) != Page.MAIN;
            p0Var.e0(-860988033);
            boolean zF = p0Var.f(k2Var2);
            Object objI5 = p0Var.I();
            if (zF || objI5 == e2Var) {
                objI5 = new t(i13, k2Var2);
                p0Var.r0(objI5);
            }
            p0Var.u(false);
            com.google.android.gms.internal.mlkit_vision_label.r.a(z10, (ee.a) objI5, 0, p0Var, 0);
            p0Var.e0(-860986440);
            boolean zF2 = p0Var.f(k2Var2);
            Object objI6 = p0Var.I();
            if (zF2 || objI6 == e2Var) {
                objI6 = new k(i12, k2Var2);
                p0Var.r0(objI6);
            }
            ee.c cVar = (ee.c) objI6;
            p0Var.u(false);
            switch (WhenMappings.$EnumSwitchMapping$0[ArgoScreen$lambda$7(k2Var2).ordinal()]) {
                case 1:
                    p0Var.e0(-860984731);
                    ArgoMain(onBack, cVar, ArgoScreen$lambda$11(k2Var3), p0Var, i10 & 14);
                    p0Var.u(false);
                    break;
                case 2:
                    p0Var.e0(-860983189);
                    String strArgoScreen$lambda$11 = ArgoScreen$lambda$11(k2Var3);
                    p0Var.e0(-860982600);
                    boolean zF3 = p0Var.f(k2Var3);
                    Object objI7 = p0Var.I();
                    if (zF3 || objI7 == e2Var) {
                        objI7 = new k(7, k2Var3);
                        p0Var.r0(objI7);
                    }
                    p0Var.u(false);
                    ArgoList(cVar, strArgoScreen$lambda$11, (ee.c) objI7, p0Var, 0);
                    p0Var.u(false);
                    break;
                case 3:
                    p0Var.e0(-860981442);
                    ArgoClean(cVar, ArgoScreen$lambda$11(k2Var3), p0Var, 0);
                    p0Var.u(false);
                    break;
                case 4:
                    p0Var.e0(-860980170);
                    ArgoAdd(cVar, p0Var, 0);
                    p0Var.u(false);
                    break;
                case 5:
                    p0Var.e0(-860979014);
                    ArgoSources(cVar, p0Var, 0);
                    p0Var.u(false);
                    break;
                case 6:
                    p0Var.e0(-860977833);
                    ArgoLogs(cVar, p0Var, 0);
                    p0Var.u(false);
                    break;
                default:
                    throw com.mlmvpn.scanner.e.k(-860985608, p0Var, false);
            }
        }
        androidx.compose.runtime.c3 c3VarY2 = p0Var.y();
        if (c3VarY2 != null) {
            c3VarY2.f3186d = new com.mlmvpn.scanner.ui.amnezia.a(i, 5, onBack);
        }
    }

    private static final boolean ArgoScreen$lambda$1(k2 k2Var) {
        return ((Boolean) k2Var.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 ArgoScreen$lambda$10$lambda$9() {
        return b1.N(Psi.CrashTracebackLevelAll, e2.f3199e);
    }

    private static final String ArgoScreen$lambda$11(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoScreen$lambda$14$lambda$13(k2 k2Var) {
        k2Var.setValue(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoScreen$lambda$16$lambda$15(k2 k2Var, Page it) {
        kotlin.jvm.internal.j.e(it, "it");
        k2Var.setValue(it);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoScreen$lambda$18$lambda$17(k2 k2Var, String it) {
        kotlin.jvm.internal.j.e(it, "it");
        k2Var.setValue(it);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoScreen$lambda$19(ee.a aVar, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoScreen(aVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoScreen$lambda$2(k2 k2Var, boolean z10) {
        k2Var.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoScreen$lambda$4(ee.a aVar, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoScreen(aVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 ArgoScreen$lambda$6$lambda$5() {
        return b1.N(Page.MAIN, e2.f3199e);
    }

    private static final Page ArgoScreen$lambda$7(k2 k2Var) {
        return (Page) k2Var.getValue();
    }

    private static final void ArgoSources(ee.c cVar, androidx.compose.runtime.o oVar, int i) {
        int i10;
        e2 e2Var = e2.f3199e;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-1141759325);
        if ((i & 6) == 0) {
            i10 = (p0Var.h(cVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i11 = 1;
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            ArgoPool argoPool = ArgoPool.INSTANCE;
            long jArgoSources$lambda$176 = ArgoSources$lambda$176(b1.x(argoPool.getVersion(), p0Var));
            p0Var.e0(1546653985);
            boolean zE = p0Var.e(jArgoSources$lambda$176);
            Object objI = p0Var.I();
            e2 e2Var2 = androidx.compose.runtime.n.f3284a;
            if (zE || objI == e2Var2) {
                objI = argoPool.sources();
                p0Var.r0(objI);
            }
            List list = (List) objI;
            p0Var.u(false);
            ArgoPool.Job updateJob = argoPool.getUpdateJob();
            boolean z10 = updateJob != null && updateJob.getRunning();
            p0Var.e0(1546658168);
            Object objI2 = p0Var.I();
            if (objI2 == e2Var2) {
                objI2 = b1.N("", e2Var);
                p0Var.r0(objI2);
            }
            k2 k2Var = (k2) objI2;
            Object objH = w0.h(1546659672, p0Var, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var.r0(objH);
            }
            k2 k2Var2 = (k2) objH;
            Object objH2 = w0.h(1546661208, p0Var, false);
            if (objH2 == e2Var2) {
                objH2 = b1.N("", e2Var);
                p0Var.r0(objH2);
            }
            k2 k2Var3 = (k2) objH2;
            p0Var.u(false);
            String strTr = StoreNetKt.tr("منابع و به\u200cروزرسانی", "Sources & refresh");
            p0Var.e0(1546664746);
            int i12 = 14;
            boolean z11 = (i10 & 14) == 4;
            Object objI3 = p0Var.I();
            if (z11 || objI3 == e2Var2) {
                objI3 = new z(cVar, i12);
                p0Var.r0(objI3);
            }
            p0Var.u(false);
            IosSettingsKt.IosScreen(strTr, (ee.a) objI3, TITLE, null, null, false, null, null, x6.p.f(p0Var, -223196851, new C08912(z10, updateJob, k2Var, k2Var2, k2Var3, list)), p0Var, 100663680, 248);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new g(i, i11, cVar);
        }
    }

    private static final long ArgoSources$lambda$176(l4 l4Var) {
        return ((Number) l4Var.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoSources$lambda$179(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoSources$lambda$180(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoSources$lambda$182(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoSources$lambda$183(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ArgoSources$lambda$185(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ArgoSources$lambda$186(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoSources$lambda$188$lambda$187(ee.c cVar) {
        cVar.invoke(Page.MAIN);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ArgoSources$lambda$189(ee.c cVar, int i, androidx.compose.runtime.o oVar, int i10) {
        ArgoSources(cVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:106:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:112:0x0226  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0081  */
    /* JADX WARN: Code duplicated, block: B:51:0x0085  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0097  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x011b  */
    /* JADX WARN: Code duplicated, block: B:88:0x012f  */
    /* JADX WARN: Code duplicated, block: B:89:0x013a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0176  */
    /* JADX WARN: Code duplicated, block: B:93:0x017a  */
    /* JADX WARN: Code duplicated, block: B:96:0x018d  */
    /* JADX WARN: Code duplicated, block: B:98:0x019b  */
    public static final void Btn(String str, boolean z10, boolean z11, androidx.compose.ui.graphics.vector.f fVar, ee.a aVar, androidx.compose.runtime.o oVar, int i, int i10) {
        String str2;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        int i14;
        androidx.compose.ui.graphics.vector.f fVar2;
        int i15;
        int i16;
        boolean z14;
        androidx.compose.ui.graphics.vector.f fVar3;
        long jC;
        long secondaryLabel;
        androidx.compose.ui.q qVar;
        androidx.compose.ui.t tVarL;
        int i17;
        l0 l0Var;
        int i18;
        androidx.compose.ui.node.m mVar;
        long j;
        androidx.compose.ui.text.font.w wVar;
        androidx.compose.ui.graphics.vector.f fVar4;
        boolean z15;
        boolean z16;
        androidx.compose.runtime.c3 c3VarY;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-1132637468);
        if ((i10 & 1) != 0) {
            i11 = i | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 6) == 0) {
                i11 = (p0Var.f(str2) ? 4 : 2) | i;
            } else {
                i11 = i;
            }
        }
        int i19 = i10 & 2;
        if (i19 == 0) {
            if ((i & 48) == 0) {
                z12 = z10;
                i11 |= p0Var.g(z12) ? 32 : 16;
            }
            i12 = i10 & 4;
            if (i12 != 0) {
                if ((i & 384) == 0) {
                    z13 = z11;
                    if (p0Var.g(z13)) {
                        i13 = 256;
                    } else {
                        i13 = 128;
                    }
                    i11 |= i13;
                }
                i14 = i10 & 8;
                if (i14 != 0) {
                    if ((i & MamiIdentity.RSA_BITS) == 0) {
                        fVar2 = fVar;
                        if (p0Var.f(fVar2)) {
                            i15 = 2048;
                        } else {
                            i15 = 1024;
                        }
                        i11 |= i15;
                    }
                    if ((i10 & 16) != 0) {
                        i11 |= 24576;
                    } else if ((i & 24576) == 0) {
                        if (p0Var.h(aVar)) {
                            i16 = 16384;
                        } else {
                            i16 = 8192;
                        }
                        i11 |= i16;
                    }
                    if ((i11 & 9363) == 9362 || !p0Var.G()) {
                        if (i19 != 0) {
                            z12 = false;
                        }
                        if (i12 != 0) {
                            z14 = true;
                        } else {
                            z14 = z13;
                        }
                        if (i14 != 0) {
                            fVar3 = null;
                        } else {
                            fVar3 = fVar2;
                        }
                        r0 r0Var = v0.f3474a;
                        if (z12) {
                            p0Var.e0(-1625886246);
                            jC = Ios.INSTANCE.getBlue(p0Var, 6);
                        } else {
                            p0Var.e0(-1625885591);
                            jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                        }
                        p0Var.u(false);
                        if (z12) {
                            p0Var.e0(-1625883941);
                            p0Var.u(false);
                            secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                        } else {
                            if (z14) {
                                p0Var.e0(-1625883045);
                                secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                            } else {
                                p0Var.e0(-1625882556);
                                secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                            }
                            p0Var.u(false);
                        }
                        e0.d dVarB = e0.e.b(9);
                        qVar = androidx.compose.ui.q.f4604b;
                        androidx.compose.ui.t tVarB = androidx.compose.ui.draw.h.b(qVar, dVarB);
                        if (!z14) {
                            jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                        }
                        androidx.compose.ui.t tVarF = androidx.compose.foundation.p.f(tVarB, jC, androidx.compose.ui.graphics.d0.f3719a);
                        if (z14) {
                            tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                        } else {
                            tVarL = qVar;
                        }
                        androidx.compose.ui.t tVarW = f0.w(tVarF.i(tVarL), 12, 7);
                        androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                        p0Var.e0(693286680);
                        k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
                        p0Var.e0(-1323940314);
                        i17 = p0Var.N;
                        w2 w2VarO = p0Var.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                        p0Var.h0();
                        i18 = i11;
                        if (p0Var.M) {
                            p0Var.n(l0Var);
                        } else {
                            p0Var.t0();
                        }
                        b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA);
                        b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO);
                        mVar = androidx.compose.ui.node.t.i;
                        if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i17))) {
                            w0.u(i17, p0Var, i17, mVar);
                        }
                        w0.v(0, eVarM, new r3(p0Var), p0Var, 2058660585);
                        p0Var.e0(210136186);
                        if (fVar3 != null) {
                            j = secondaryLabel;
                            c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                            f0.e(p0Var, d3.p(qVar, 5));
                        } else {
                            j = secondaryLabel;
                        }
                        p0Var.u(false);
                        long jT = x6.a.t(13);
                        if (z12) {
                            wVar = androidx.compose.ui.text.font.w.f4817h;
                        } else {
                            wVar = androidx.compose.ui.text.font.w.f4816f;
                        }
                        k9.b(str2, null, j, jT, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                        p0Var = p0Var;
                        w0.z(p0Var, false, true, false, false);
                        boolean z17 = z14;
                        fVar4 = fVar3;
                        z15 = z12;
                        z16 = z17;
                    } else {
                        p0Var.Y();
                        z15 = z12;
                        z16 = z13;
                        fVar4 = fVar2;
                    }
                    c3VarY = p0Var.y();
                    if (c3VarY != null) {
                        c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
                    }
                }
                i11 |= MamiIdentity.RSA_BITS;
                fVar2 = fVar;
                if ((i10 & 16) != 0) {
                    i11 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (p0Var.h(aVar)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i11 |= i16;
                }
                if ((i11 & 9363) == 9362) {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var2 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB2 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB2 = androidx.compose.ui.draw.h.b(qVar, dVarB2);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF2 = androidx.compose.foundation.p.f(tVarB2, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW2 = f0.w(tVarF2.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar2 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA2 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar2, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO2 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarW2);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA2);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO2);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM2, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT2 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT2, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z18 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z18;
                } else {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var3 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB3 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB3 = androidx.compose.ui.draw.h.b(qVar, dVarB3);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF3 = androidx.compose.foundation.p.f(tVarB3, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW3 = f0.w(tVarF3.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar3 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA3 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar3, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO3 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarW3);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA3);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO3);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM3, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT3 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT3, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z19 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z19;
                }
                c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
                }
            }
            i11 |= 384;
            z13 = z11;
            i14 = i10 & 8;
            if (i14 != 0) {
                if ((i & MamiIdentity.RSA_BITS) == 0) {
                    fVar2 = fVar;
                    if (p0Var.f(fVar2)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i11 |= i15;
                }
                if ((i10 & 16) != 0) {
                    i11 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (p0Var.h(aVar)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i11 |= i16;
                }
                if ((i11 & 9363) == 9362) {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var4 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB4 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB4 = androidx.compose.ui.draw.h.b(qVar, dVarB4);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF4 = androidx.compose.foundation.p.f(tVarB4, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW4 = f0.w(tVarF4.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar4 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA4 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar4, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO4 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(tVarW4);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA4);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO4);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM4, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT4 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT4, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z110 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z110;
                } else {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var5 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB5 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB5 = androidx.compose.ui.draw.h.b(qVar, dVarB5);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF5 = androidx.compose.foundation.p.f(tVarB5, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW5 = f0.w(tVarF5.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar5 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA5 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar5, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO5 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarW5);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA5);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO5);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM5, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT5 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT5, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z111 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z111;
                }
                c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
                }
            }
            i11 |= MamiIdentity.RSA_BITS;
            fVar2 = fVar;
            if ((i10 & 16) != 0) {
                i11 |= 24576;
            } else if ((i & 24576) == 0) {
                if (p0Var.h(aVar)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i11 |= i16;
            }
            if ((i11 & 9363) == 9362) {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var6 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB6 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB6 = androidx.compose.ui.draw.h.b(qVar, dVarB6);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF6 = androidx.compose.foundation.p.f(tVarB6, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW6 = f0.w(tVarF6.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar6 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA6 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar6, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO6 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(tVarW6);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA6);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO6);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM6, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT6 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT6, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z112 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z112;
            } else {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var7 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB7 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB7 = androidx.compose.ui.draw.h.b(qVar, dVarB7);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF7 = androidx.compose.foundation.p.f(tVarB7, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW7 = f0.w(tVarF7.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar7 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA7 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar7, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO7 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM7 = androidx.compose.ui.layout.u.m(tVarW7);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA7);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO7);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM7, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT7 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT7, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z113 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z113;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
            }
        }
        i11 |= 48;
        z12 = z10;
        i12 = i10 & 4;
        if (i12 != 0) {
            if ((i & 384) == 0) {
                z13 = z11;
                if (p0Var.g(z13)) {
                    i13 = 256;
                } else {
                    i13 = 128;
                }
                i11 |= i13;
            }
            i14 = i10 & 8;
            if (i14 != 0) {
                if ((i & MamiIdentity.RSA_BITS) == 0) {
                    fVar2 = fVar;
                    if (p0Var.f(fVar2)) {
                        i15 = 2048;
                    } else {
                        i15 = 1024;
                    }
                    i11 |= i15;
                }
                if ((i10 & 16) != 0) {
                    i11 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (p0Var.h(aVar)) {
                        i16 = 16384;
                    } else {
                        i16 = 8192;
                    }
                    i11 |= i16;
                }
                if ((i11 & 9363) == 9362) {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var8 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB8 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB8 = androidx.compose.ui.draw.h.b(qVar, dVarB8);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF8 = androidx.compose.foundation.p.f(tVarB8, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW8 = f0.w(tVarF8.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar8 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA8 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar8, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO8 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM8 = androidx.compose.ui.layout.u.m(tVarW8);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA8);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO8);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM8, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT8 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT8, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z114 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z114;
                } else {
                    if (i19 != 0) {
                        z12 = false;
                    }
                    if (i12 != 0) {
                        z14 = true;
                    } else {
                        z14 = z13;
                    }
                    if (i14 != 0) {
                        fVar3 = null;
                    } else {
                        fVar3 = fVar2;
                    }
                    r0 r0Var9 = v0.f3474a;
                    if (z12) {
                        p0Var.e0(-1625886246);
                        jC = Ios.INSTANCE.getBlue(p0Var, 6);
                    } else {
                        p0Var.e0(-1625885591);
                        jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                    }
                    p0Var.u(false);
                    if (z12) {
                        p0Var.e0(-1625883941);
                        p0Var.u(false);
                        secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                    } else {
                        if (z14) {
                            p0Var.e0(-1625883045);
                            secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                        } else {
                            p0Var.e0(-1625882556);
                            secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                        }
                        p0Var.u(false);
                    }
                    e0.d dVarB9 = e0.e.b(9);
                    qVar = androidx.compose.ui.q.f4604b;
                    androidx.compose.ui.t tVarB9 = androidx.compose.ui.draw.h.b(qVar, dVarB9);
                    if (!z14) {
                        jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                    }
                    androidx.compose.ui.t tVarF9 = androidx.compose.foundation.p.f(tVarB9, jC, androidx.compose.ui.graphics.d0.f3719a);
                    if (z14) {
                        tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                    } else {
                        tVarL = qVar;
                    }
                    androidx.compose.ui.t tVarW9 = f0.w(tVarF9.i(tVarL), 12, 7);
                    androidx.compose.ui.i iVar9 = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA9 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar9, p0Var);
                    p0Var.e0(-1323940314);
                    i17 = p0Var.N;
                    w2 w2VarO9 = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM9 = androidx.compose.ui.layout.u.m(tVarW9);
                    p0Var.h0();
                    i18 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA9);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO9);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M) {
                        w0.u(i17, p0Var, i17, mVar);
                    } else {
                        w0.u(i17, p0Var, i17, mVar);
                    }
                    w0.v(0, eVarM9, new r3(p0Var), p0Var, 2058660585);
                    p0Var.e0(210136186);
                    if (fVar3 != null) {
                        j = secondaryLabel;
                        c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                        f0.e(p0Var, d3.p(qVar, 5));
                    } else {
                        j = secondaryLabel;
                    }
                    p0Var.u(false);
                    long jT9 = x6.a.t(13);
                    if (z12) {
                        wVar = androidx.compose.ui.text.font.w.f4817h;
                    } else {
                        wVar = androidx.compose.ui.text.font.w.f4816f;
                    }
                    k9.b(str2, null, j, jT9, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                    p0Var = p0Var;
                    w0.z(p0Var, false, true, false, false);
                    boolean z115 = z14;
                    fVar4 = fVar3;
                    z15 = z12;
                    z16 = z115;
                }
                c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
                }
            }
            i11 |= MamiIdentity.RSA_BITS;
            fVar2 = fVar;
            if ((i10 & 16) != 0) {
                i11 |= 24576;
            } else if ((i & 24576) == 0) {
                if (p0Var.h(aVar)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i11 |= i16;
            }
            if ((i11 & 9363) == 9362) {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var10 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB10 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB10 = androidx.compose.ui.draw.h.b(qVar, dVarB10);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF10 = androidx.compose.foundation.p.f(tVarB10, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW10 = f0.w(tVarF10.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar10 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA10 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar10, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO10 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM10 = androidx.compose.ui.layout.u.m(tVarW10);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA10);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO10);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM10, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT10 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT10, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z116 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z116;
            } else {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var11 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB11 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB11 = androidx.compose.ui.draw.h.b(qVar, dVarB11);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF11 = androidx.compose.foundation.p.f(tVarB11, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW11 = f0.w(tVarF11.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar11 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA11 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar11, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO11 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM11 = androidx.compose.ui.layout.u.m(tVarW11);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA11);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO11);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM11, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT11 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT11, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z117 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z117;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
            }
        }
        i11 |= 384;
        z13 = z11;
        i14 = i10 & 8;
        if (i14 != 0) {
            if ((i & MamiIdentity.RSA_BITS) == 0) {
                fVar2 = fVar;
                if (p0Var.f(fVar2)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i11 |= i15;
            }
            if ((i10 & 16) != 0) {
                i11 |= 24576;
            } else if ((i & 24576) == 0) {
                if (p0Var.h(aVar)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i11 |= i16;
            }
            if ((i11 & 9363) == 9362) {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var12 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB12 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB12 = androidx.compose.ui.draw.h.b(qVar, dVarB12);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF12 = androidx.compose.foundation.p.f(tVarB12, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW12 = f0.w(tVarF12.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar12 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA12 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar12, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO12 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM12 = androidx.compose.ui.layout.u.m(tVarW12);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA12);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO12);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM12, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT12 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT12, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z118 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z118;
            } else {
                if (i19 != 0) {
                    z12 = false;
                }
                if (i12 != 0) {
                    z14 = true;
                } else {
                    z14 = z13;
                }
                if (i14 != 0) {
                    fVar3 = null;
                } else {
                    fVar3 = fVar2;
                }
                r0 r0Var13 = v0.f3474a;
                if (z12) {
                    p0Var.e0(-1625886246);
                    jC = Ios.INSTANCE.getBlue(p0Var, 6);
                } else {
                    p0Var.e0(-1625885591);
                    jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
                }
                p0Var.u(false);
                if (z12) {
                    p0Var.e0(-1625883941);
                    p0Var.u(false);
                    secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
                } else {
                    if (z14) {
                        p0Var.e0(-1625883045);
                        secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                    } else {
                        p0Var.e0(-1625882556);
                        secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                    }
                    p0Var.u(false);
                }
                e0.d dVarB13 = e0.e.b(9);
                qVar = androidx.compose.ui.q.f4604b;
                androidx.compose.ui.t tVarB13 = androidx.compose.ui.draw.h.b(qVar, dVarB13);
                if (!z14) {
                    jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
                }
                androidx.compose.ui.t tVarF13 = androidx.compose.foundation.p.f(tVarB13, jC, androidx.compose.ui.graphics.d0.f3719a);
                if (z14) {
                    tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar;
                }
                androidx.compose.ui.t tVarW13 = f0.w(tVarF13.i(tVarL), 12, 7);
                androidx.compose.ui.i iVar13 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA13 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar13, p0Var);
                p0Var.e0(-1323940314);
                i17 = p0Var.N;
                w2 w2VarO13 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM13 = androidx.compose.ui.layout.u.m(tVarW13);
                p0Var.h0();
                i18 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA13);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO13);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i17, p0Var, i17, mVar);
                } else {
                    w0.u(i17, p0Var, i17, mVar);
                }
                w0.v(0, eVarM13, new r3(p0Var), p0Var, 2058660585);
                p0Var.e0(210136186);
                if (fVar3 != null) {
                    j = secondaryLabel;
                    c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                    f0.e(p0Var, d3.p(qVar, 5));
                } else {
                    j = secondaryLabel;
                }
                p0Var.u(false);
                long jT13 = x6.a.t(13);
                if (z12) {
                    wVar = androidx.compose.ui.text.font.w.f4817h;
                } else {
                    wVar = androidx.compose.ui.text.font.w.f4816f;
                }
                k9.b(str2, null, j, jT13, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
                p0Var = p0Var;
                w0.z(p0Var, false, true, false, false);
                boolean z119 = z14;
                fVar4 = fVar3;
                z15 = z12;
                z16 = z119;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
            }
        }
        i11 |= MamiIdentity.RSA_BITS;
        fVar2 = fVar;
        if ((i10 & 16) != 0) {
            i11 |= 24576;
        } else if ((i & 24576) == 0) {
            if (p0Var.h(aVar)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i11 |= i16;
        }
        if ((i11 & 9363) == 9362) {
            if (i19 != 0) {
                z12 = false;
            }
            if (i12 != 0) {
                z14 = true;
            } else {
                z14 = z13;
            }
            if (i14 != 0) {
                fVar3 = null;
            } else {
                fVar3 = fVar2;
            }
            r0 r0Var14 = v0.f3474a;
            if (z12) {
                p0Var.e0(-1625886246);
                jC = Ios.INSTANCE.getBlue(p0Var, 6);
            } else {
                p0Var.e0(-1625885591);
                jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
            }
            p0Var.u(false);
            if (z12) {
                p0Var.e0(-1625883941);
                p0Var.u(false);
                secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
            } else {
                if (z14) {
                    p0Var.e0(-1625883045);
                    secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                } else {
                    p0Var.e0(-1625882556);
                    secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                }
                p0Var.u(false);
            }
            e0.d dVarB14 = e0.e.b(9);
            qVar = androidx.compose.ui.q.f4604b;
            androidx.compose.ui.t tVarB14 = androidx.compose.ui.draw.h.b(qVar, dVarB14);
            if (!z14) {
                jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
            }
            androidx.compose.ui.t tVarF14 = androidx.compose.foundation.p.f(tVarB14, jC, androidx.compose.ui.graphics.d0.f3719a);
            if (z14) {
                tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
            } else {
                tVarL = qVar;
            }
            androidx.compose.ui.t tVarW14 = f0.w(tVarF14.i(tVarL), 12, 7);
            androidx.compose.ui.i iVar14 = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA14 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar14, p0Var);
            p0Var.e0(-1323940314);
            i17 = p0Var.N;
            w2 w2VarO14 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM14 = androidx.compose.ui.layout.u.m(tVarW14);
            p0Var.h0();
            i18 = i11;
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA14);
            b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO14);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i17, p0Var, i17, mVar);
            } else {
                w0.u(i17, p0Var, i17, mVar);
            }
            w0.v(0, eVarM14, new r3(p0Var), p0Var, 2058660585);
            p0Var.e0(210136186);
            if (fVar3 != null) {
                j = secondaryLabel;
                c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                f0.e(p0Var, d3.p(qVar, 5));
            } else {
                j = secondaryLabel;
            }
            p0Var.u(false);
            long jT14 = x6.a.t(13);
            if (z12) {
                wVar = androidx.compose.ui.text.font.w.f4817h;
            } else {
                wVar = androidx.compose.ui.text.font.w.f4816f;
            }
            k9.b(str2, null, j, jT14, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
            p0Var = p0Var;
            w0.z(p0Var, false, true, false, false);
            boolean z1110 = z14;
            fVar4 = fVar3;
            z15 = z12;
            z16 = z1110;
        } else {
            if (i19 != 0) {
                z12 = false;
            }
            if (i12 != 0) {
                z14 = true;
            } else {
                z14 = z13;
            }
            if (i14 != 0) {
                fVar3 = null;
            } else {
                fVar3 = fVar2;
            }
            r0 r0Var15 = v0.f3474a;
            if (z12) {
                p0Var.e0(-1625886246);
                jC = Ios.INSTANCE.getBlue(p0Var, 6);
            } else {
                p0Var.e0(-1625885591);
                jC = androidx.compose.ui.graphics.v.c(0.1f, Ios.INSTANCE.getLabel(p0Var, 6));
            }
            p0Var.u(false);
            if (z12) {
                p0Var.e0(-1625883941);
                p0Var.u(false);
                secondaryLabel = androidx.compose.ui.graphics.v.f3795e;
            } else {
                if (z14) {
                    p0Var.e0(-1625883045);
                    secondaryLabel = Ios.INSTANCE.getLabel(p0Var, 6);
                } else {
                    p0Var.e0(-1625882556);
                    secondaryLabel = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                }
                p0Var.u(false);
            }
            e0.d dVarB15 = e0.e.b(9);
            qVar = androidx.compose.ui.q.f4604b;
            androidx.compose.ui.t tVarB15 = androidx.compose.ui.draw.h.b(qVar, dVarB15);
            if (!z14) {
                jC = androidx.compose.ui.graphics.v.c(androidx.compose.ui.graphics.v.e(jC) * 0.5f, jC);
            }
            androidx.compose.ui.t tVarF15 = androidx.compose.foundation.p.f(tVarB15, jC, androidx.compose.ui.graphics.d0.f3719a);
            if (z14) {
                tVarL = androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
            } else {
                tVarL = qVar;
            }
            androidx.compose.ui.t tVarW15 = f0.w(tVarF15.i(tVarL), 12, 7);
            androidx.compose.ui.i iVar15 = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA15 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar15, p0Var);
            p0Var.e0(-1323940314);
            i17 = p0Var.N;
            w2 w2VarO15 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM15 = androidx.compose.ui.layout.u.m(tVarW15);
            p0Var.h0();
            i18 = i11;
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA15);
            b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO15);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i17, p0Var, i17, mVar);
            } else {
                w0.u(i17, p0Var, i17, mVar);
            }
            w0.v(0, eVarM15, new r3(p0Var), p0Var, 2058660585);
            p0Var.e0(210136186);
            if (fVar3 != null) {
                j = secondaryLabel;
                c3.b(null, j, fVar3, d3.m(qVar, 15), p0Var, ((i18 >> 9) & 14) | 432, 0);
                f0.e(p0Var, d3.p(qVar, 5));
            } else {
                j = secondaryLabel;
            }
            p0Var.u(false);
            long jT15 = x6.a.t(13);
            if (z12) {
                wVar = androidx.compose.ui.text.font.w.f4817h;
            } else {
                wVar = androidx.compose.ui.text.font.w.f4816f;
            }
            k9.b(str2, null, j, jT15, null, wVar, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i18 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
            p0Var = p0Var;
            w0.z(p0Var, false, true, false, false);
            boolean z1111 = z14;
            fVar4 = fVar3;
            z15 = z12;
            z16 = z1111;
        }
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new f4(str, z15, z16, fVar4, aVar, i, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u Btn$lambda$80(String str, boolean z10, boolean z11, androidx.compose.ui.graphics.vector.f fVar, ee.a aVar, int i, int i10, androidx.compose.runtime.o oVar, int i11) {
        Btn(str, z10, z11, fVar, aVar, oVar, b1.b0(i | 1), i10);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:74:0x0115  */
    /* JADX WARN: Code duplicated, block: B:77:0x0163  */
    /* JADX WARN: Code duplicated, block: B:79:0x019d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x01be  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:87:0x01df  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Callout-8V94_ZQ, reason: not valid java name */
    public static final void m546Callout8V94_ZQ(androidx.compose.ui.graphics.vector.f fVar, long j, String str, String str2, ee.a aVar, androidx.compose.runtime.o oVar, int i, int i10) {
        androidx.compose.ui.graphics.vector.f fVar2;
        int i11;
        long j10;
        String str3;
        String str4;
        int i12;
        ee.a aVar2;
        int i13;
        int i14;
        l0 l0Var;
        int i15;
        androidx.compose.ui.node.m mVar;
        long label;
        long jT;
        long jT2;
        String str5;
        ee.a aVar3;
        String str6;
        ee.a aVar4;
        androidx.compose.runtime.c3 c3VarY;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-756713206);
        if ((i10 & 1) != 0) {
            i11 = i | 6;
            fVar2 = fVar;
        } else {
            fVar2 = fVar;
            if ((i & 6) == 0) {
                i11 = (p0Var.f(fVar2) ? 4 : 2) | i;
            } else {
                i11 = i;
            }
        }
        if ((i10 & 2) != 0) {
            i11 |= 48;
            j10 = j;
        } else {
            j10 = j;
            if ((i & 48) == 0) {
                i11 |= p0Var.e(j10) ? 32 : 16;
            }
        }
        if ((i10 & 4) != 0) {
            i11 |= 384;
            str3 = str;
        } else {
            str3 = str;
            if ((i & 384) == 0) {
                i11 |= p0Var.f(str3) ? 256 : 128;
            }
        }
        int i16 = i10 & 8;
        if (i16 == 0) {
            if ((i & MamiIdentity.RSA_BITS) == 0) {
                str4 = str2;
                i11 |= p0Var.f(str4) ? 2048 : 1024;
            }
            i12 = i10 & 16;
            if (i12 != 0) {
                if ((i & 24576) == 0) {
                    aVar2 = aVar;
                    if (p0Var.h(aVar2)) {
                        i13 = 16384;
                    } else {
                        i13 = 8192;
                    }
                    i11 |= i13;
                }
                if ((i11 & 9363) == 9362 || !p0Var.G()) {
                    if (i16 != 0) {
                        str4 = null;
                    }
                    if (i12 != 0) {
                        aVar2 = null;
                    }
                    r0 r0Var = v0.f3474a;
                    androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                    float f8 = 10;
                    androidx.compose.ui.t tVarW = f0.w(d3.e(qVar, 1.0f), 14, f8);
                    androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                    p0Var.e0(693286680);
                    k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
                    p0Var.e0(-1323940314);
                    i14 = p0Var.N;
                    w2 w2VarO = p0Var.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var.h0();
                    i15 = i11;
                    if (p0Var.M) {
                        p0Var.n(l0Var);
                    } else {
                        p0Var.t0();
                    }
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA);
                    b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO);
                    mVar = androidx.compose.ui.node.t.i;
                    if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i14))) {
                        w0.u(i14, p0Var, i14, mVar);
                    }
                    w0.v(0, eVarM, new r3(p0Var), p0Var, 2058660585);
                    c3.b(null, j10, fVar2, d3.m(qVar, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
                    f0.e(p0Var, d3.p(qVar, f8));
                    label = Ios.INSTANCE.getLabel(p0Var, 6);
                    jT = x6.a.t(13);
                    jT2 = x6.a.t(19);
                    if (1.0f <= 0.0d) {
                        throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                    }
                    k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
                    p0Var = p0Var;
                    p0Var.e0(587389746);
                    if (str4 != null || aVar2 == null) {
                        str5 = str4;
                        aVar3 = aVar2;
                    } else {
                        f0.e(p0Var, d3.p(qVar, 8));
                        str5 = str4;
                        aVar3 = aVar2;
                        Btn(str5, false, false, null, aVar3, p0Var, ((i15 >> 9) & 14) | (i15 & 57344), 14);
                    }
                    w0.z(p0Var, false, false, true, false);
                    p0Var.u(false);
                    str6 = str5;
                    aVar4 = aVar3;
                } else {
                    p0Var.Y();
                    aVar4 = aVar2;
                    str6 = str4;
                }
                c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new d(fVar, j, str, str6, aVar4, i, i10, 0);
                }
            }
            i11 |= 24576;
            aVar2 = aVar;
            if ((i11 & 9363) == 9362) {
                if (i16 != 0) {
                    str4 = null;
                }
                if (i12 != 0) {
                    aVar2 = null;
                }
                r0 r0Var2 = v0.f3474a;
                androidx.compose.ui.q qVar2 = androidx.compose.ui.q.f4604b;
                float f10 = 10;
                androidx.compose.ui.t tVarW2 = f0.w(d3.e(qVar2, 1.0f), 14, f10);
                androidx.compose.ui.i iVar2 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA2 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar2, p0Var);
                p0Var.e0(-1323940314);
                i14 = p0Var.N;
                w2 w2VarO2 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarW2);
                p0Var.h0();
                i15 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA2);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO2);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i14, p0Var, i14, mVar);
                } else {
                    w0.u(i14, p0Var, i14, mVar);
                }
                w0.v(0, eVarM2, new r3(p0Var), p0Var, 2058660585);
                c3.b(null, j10, fVar2, d3.m(qVar2, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
                f0.e(p0Var, d3.p(qVar2, f10));
                label = Ios.INSTANCE.getLabel(p0Var, 6);
                jT = x6.a.t(13);
                jT2 = x6.a.t(19);
                if (1.0f <= 0.0d) {
                    throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                }
                k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
                p0Var = p0Var;
                p0Var.e0(587389746);
                if (str4 != null) {
                    str5 = str4;
                    aVar3 = aVar2;
                } else {
                    str5 = str4;
                    aVar3 = aVar2;
                }
                w0.z(p0Var, false, false, true, false);
                p0Var.u(false);
                str6 = str5;
                aVar4 = aVar3;
            } else {
                if (i16 != 0) {
                    str4 = null;
                }
                if (i12 != 0) {
                    aVar2 = null;
                }
                r0 r0Var3 = v0.f3474a;
                androidx.compose.ui.q qVar3 = androidx.compose.ui.q.f4604b;
                float f11 = 10;
                androidx.compose.ui.t tVarW3 = f0.w(d3.e(qVar3, 1.0f), 14, f11);
                androidx.compose.ui.i iVar3 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA3 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar3, p0Var);
                p0Var.e0(-1323940314);
                i14 = p0Var.N;
                w2 w2VarO3 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarW3);
                p0Var.h0();
                i15 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA3);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO3);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i14, p0Var, i14, mVar);
                } else {
                    w0.u(i14, p0Var, i14, mVar);
                }
                w0.v(0, eVarM3, new r3(p0Var), p0Var, 2058660585);
                c3.b(null, j10, fVar2, d3.m(qVar3, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
                f0.e(p0Var, d3.p(qVar3, f11));
                label = Ios.INSTANCE.getLabel(p0Var, 6);
                jT = x6.a.t(13);
                jT2 = x6.a.t(19);
                if (1.0f <= 0.0d) {
                    throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                }
                k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
                p0Var = p0Var;
                p0Var.e0(587389746);
                if (str4 != null) {
                    str5 = str4;
                    aVar3 = aVar2;
                } else {
                    str5 = str4;
                    aVar3 = aVar2;
                }
                w0.z(p0Var, false, false, true, false);
                p0Var.u(false);
                str6 = str5;
                aVar4 = aVar3;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new d(fVar, j, str, str6, aVar4, i, i10, 0);
            }
        }
        i11 |= MamiIdentity.RSA_BITS;
        str4 = str2;
        i12 = i10 & 16;
        if (i12 != 0) {
            if ((i & 24576) == 0) {
                aVar2 = aVar;
                if (p0Var.h(aVar2)) {
                    i13 = 16384;
                } else {
                    i13 = 8192;
                }
                i11 |= i13;
            }
            if ((i11 & 9363) == 9362) {
                if (i16 != 0) {
                    str4 = null;
                }
                if (i12 != 0) {
                    aVar2 = null;
                }
                r0 r0Var4 = v0.f3474a;
                androidx.compose.ui.q qVar4 = androidx.compose.ui.q.f4604b;
                float f12 = 10;
                androidx.compose.ui.t tVarW4 = f0.w(d3.e(qVar4, 1.0f), 14, f12);
                androidx.compose.ui.i iVar4 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA4 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar4, p0Var);
                p0Var.e0(-1323940314);
                i14 = p0Var.N;
                w2 w2VarO4 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(tVarW4);
                p0Var.h0();
                i15 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA4);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO4);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i14, p0Var, i14, mVar);
                } else {
                    w0.u(i14, p0Var, i14, mVar);
                }
                w0.v(0, eVarM4, new r3(p0Var), p0Var, 2058660585);
                c3.b(null, j10, fVar2, d3.m(qVar4, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
                f0.e(p0Var, d3.p(qVar4, f12));
                label = Ios.INSTANCE.getLabel(p0Var, 6);
                jT = x6.a.t(13);
                jT2 = x6.a.t(19);
                if (1.0f <= 0.0d) {
                    throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                }
                k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
                p0Var = p0Var;
                p0Var.e0(587389746);
                if (str4 != null) {
                    str5 = str4;
                    aVar3 = aVar2;
                } else {
                    str5 = str4;
                    aVar3 = aVar2;
                }
                w0.z(p0Var, false, false, true, false);
                p0Var.u(false);
                str6 = str5;
                aVar4 = aVar3;
            } else {
                if (i16 != 0) {
                    str4 = null;
                }
                if (i12 != 0) {
                    aVar2 = null;
                }
                r0 r0Var5 = v0.f3474a;
                androidx.compose.ui.q qVar5 = androidx.compose.ui.q.f4604b;
                float f13 = 10;
                androidx.compose.ui.t tVarW5 = f0.w(d3.e(qVar5, 1.0f), 14, f13);
                androidx.compose.ui.i iVar5 = androidx.compose.ui.b.f3549s;
                p0Var.e0(693286680);
                k0 k0VarA5 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar5, p0Var);
                p0Var.e0(-1323940314);
                i14 = p0Var.N;
                w2 w2VarO5 = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarW5);
                p0Var.h0();
                i15 = i11;
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA5);
                b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO5);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M) {
                    w0.u(i14, p0Var, i14, mVar);
                } else {
                    w0.u(i14, p0Var, i14, mVar);
                }
                w0.v(0, eVarM5, new r3(p0Var), p0Var, 2058660585);
                c3.b(null, j10, fVar2, d3.m(qVar5, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
                f0.e(p0Var, d3.p(qVar5, f13));
                label = Ios.INSTANCE.getLabel(p0Var, 6);
                jT = x6.a.t(13);
                jT2 = x6.a.t(19);
                if (1.0f <= 0.0d) {
                    throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
                }
                k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
                p0Var = p0Var;
                p0Var.e0(587389746);
                if (str4 != null) {
                    str5 = str4;
                    aVar3 = aVar2;
                } else {
                    str5 = str4;
                    aVar3 = aVar2;
                }
                w0.z(p0Var, false, false, true, false);
                p0Var.u(false);
                str6 = str5;
                aVar4 = aVar3;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new d(fVar, j, str, str6, aVar4, i, i10, 0);
            }
        }
        i11 |= 24576;
        aVar2 = aVar;
        if ((i11 & 9363) == 9362) {
            if (i16 != 0) {
                str4 = null;
            }
            if (i12 != 0) {
                aVar2 = null;
            }
            r0 r0Var6 = v0.f3474a;
            androidx.compose.ui.q qVar6 = androidx.compose.ui.q.f4604b;
            float f14 = 10;
            androidx.compose.ui.t tVarW6 = f0.w(d3.e(qVar6, 1.0f), 14, f14);
            androidx.compose.ui.i iVar6 = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA6 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar6, p0Var);
            p0Var.e0(-1323940314);
            i14 = p0Var.N;
            w2 w2VarO6 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(tVarW6);
            p0Var.h0();
            i15 = i11;
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA6);
            b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO6);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i14, p0Var, i14, mVar);
            } else {
                w0.u(i14, p0Var, i14, mVar);
            }
            w0.v(0, eVarM6, new r3(p0Var), p0Var, 2058660585);
            c3.b(null, j10, fVar2, d3.m(qVar6, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
            f0.e(p0Var, d3.p(qVar6, f14));
            label = Ios.INSTANCE.getLabel(p0Var, 6);
            jT = x6.a.t(13);
            jT2 = x6.a.t(19);
            if (1.0f <= 0.0d) {
                throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
            }
            k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
            p0Var = p0Var;
            p0Var.e0(587389746);
            if (str4 != null) {
                str5 = str4;
                aVar3 = aVar2;
            } else {
                str5 = str4;
                aVar3 = aVar2;
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
            str6 = str5;
            aVar4 = aVar3;
        } else {
            if (i16 != 0) {
                str4 = null;
            }
            if (i12 != 0) {
                aVar2 = null;
            }
            r0 r0Var7 = v0.f3474a;
            androidx.compose.ui.q qVar7 = androidx.compose.ui.q.f4604b;
            float f15 = 10;
            androidx.compose.ui.t tVarW7 = f0.w(d3.e(qVar7, 1.0f), 14, f15);
            androidx.compose.ui.i iVar7 = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA7 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar7, p0Var);
            p0Var.e0(-1323940314);
            i14 = p0Var.N;
            w2 w2VarO7 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM7 = androidx.compose.ui.layout.u.m(tVarW7);
            p0Var.h0();
            i15 = i11;
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, androidx.compose.ui.node.t.f4283f, k0VarA7);
            b1.Y(p0Var, androidx.compose.ui.node.t.f4282e, w2VarO7);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i14, p0Var, i14, mVar);
            } else {
                w0.u(i14, p0Var, i14, mVar);
            }
            w0.v(0, eVarM7, new r3(p0Var), p0Var, 2058660585);
            c3.b(null, j10, fVar2, d3.m(qVar7, 20), p0Var, (i15 & 14) | 432 | ((i15 << 6) & 7168), 0);
            f0.e(p0Var, d3.p(qVar7, f15));
            label = Ios.INSTANCE.getLabel(p0Var, 6);
            jT = x6.a.t(13);
            jT2 = x6.a.t(19);
            if (1.0f <= 0.0d) {
                throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
            }
            k9.b(str3, new LayoutWeightElement(1.0f, true), label, jT, null, null, null, 0L, null, null, jT2, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 6, 130032);
            p0Var = p0Var;
            p0Var.e0(587389746);
            if (str4 != null) {
                str5 = str4;
                aVar3 = aVar2;
            } else {
                str5 = str4;
                aVar3 = aVar2;
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
            str6 = str5;
            aVar4 = aVar3;
        }
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new d(fVar, j, str, str6, aVar4, i, i10, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u Callout_8V94_ZQ$lambda$78(androidx.compose.ui.graphics.vector.f fVar, long j, String str, String str2, ee.a aVar, int i, int i10, androidx.compose.runtime.o oVar, int i11) {
        m546Callout8V94_ZQ(fVar, j, str, str2, aVar, oVar, b1.b0(i | 1), i10);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Chip-RPmYEkk, reason: not valid java name */
    public static final void m547ChipRPmYEkk(String str, long j, androidx.compose.runtime.o oVar, int i) {
        int i10;
        p0 p0Var;
        p0 p0Var2 = (p0) oVar;
        p0Var2.f0(-1142901841);
        if ((i & 6) == 0) {
            i10 = i | (p0Var2.f(str) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var2.e(j) ? 32 : 16;
        }
        if ((i10 & 19) == 18 && p0Var2.G()) {
            p0Var2.Y();
            p0Var = p0Var2;
        } else {
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.t tVarW = f0.w(androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(androidx.compose.ui.q.f4604b, e0.e.a(50)), androidx.compose.ui.graphics.v.c(0.18f, j), androidx.compose.ui.graphics.d0.f3719a), 7, 1);
            p0Var2.e0(733328855);
            k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, p0Var2);
            p0Var2.e0(-1323940314);
            int i11 = p0Var2.N;
            w2 w2VarO = p0Var2.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
            p0Var2.h0();
            if (p0Var2.M) {
                p0Var2.n(l0Var);
            } else {
                p0Var2.t0();
            }
            b1.Y(p0Var2, androidx.compose.ui.node.t.f4283f, k0VarC);
            b1.Y(p0Var2, androidx.compose.ui.node.t.f4282e, w2VarO);
            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
            if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(i11))) {
                w0.u(i11, p0Var2, i11, mVar);
            }
            w0.v(0, eVarM, new r3(p0Var2), p0Var2, 2058660585);
            k9.b(str, null, Ios.INSTANCE.getLabel(p0Var2, 6), x6.a.s(10.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var2, (i10 & 14) | MamiIdentity.RSA_BITS, 0, 131058);
            p0Var = p0Var2;
            w0.z(p0Var, false, true, false, false);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new t0(i, j, str, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u Chip_RPmYEkk$lambda$82(String str, long j, int i, androidx.compose.runtime.o oVar, int i10) {
        m547ChipRPmYEkk(str, j, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x0070  */
    /* JADX WARN: Code duplicated, block: B:48:0x0075  */
    /* JADX WARN: Code duplicated, block: B:50:0x0079  */
    /* JADX WARN: Code duplicated, block: B:52:0x0081  */
    /* JADX WARN: Code duplicated, block: B:53:0x0084  */
    /* JADX WARN: Code duplicated, block: B:57:0x008d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x009b  */
    /* JADX WARN: Code duplicated, block: B:63:0x009e  */
    /* JADX WARN: Code duplicated, block: B:65:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final void Field(final String str, final ee.c cVar, final String str2, int i, androidx.compose.ui.t tVar, androidx.compose.runtime.o oVar, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        androidx.compose.ui.t tVar2;
        int i15;
        final int i16;
        final androidx.compose.ui.t tVar3;
        int i17;
        androidx.compose.runtime.c3 c3VarY;
        p0 p0Var = (p0) oVar;
        p0Var.f0(669671688);
        if ((i11 & 1) != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 6) == 0) {
            i12 = (p0Var.f(str) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 48) == 0) {
            i12 |= p0Var.h(cVar) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= 384;
        } else if ((i10 & 384) == 0) {
            i12 |= p0Var.f(str2) ? 256 : 128;
        }
        int i18 = i11 & 8;
        if (i18 == 0) {
            if ((i10 & MamiIdentity.RSA_BITS) == 0) {
                i13 = i;
                i12 |= p0Var.d(i13) ? 2048 : 1024;
            }
            i14 = i11 & 16;
            if (i14 != 0) {
                if ((i10 & 24576) == 0) {
                    tVar2 = tVar;
                    if (p0Var.f(tVar2)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
                    }
                    i12 |= i15;
                }
                if ((i12 & 9363) == 9362 || !p0Var.G()) {
                    if (i18 != 0) {
                        i16 = 1;
                    } else {
                        i16 = i13;
                    }
                    if (i14 != 0) {
                        tVar3 = androidx.compose.ui.q.f4604b;
                    } else {
                        tVar3 = tVar2;
                    }
                    r0 r0Var = v0.f3474a;
                    b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                        @Override // ee.e
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                            return sd.u.f67154a;
                        }

                        public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                            String str3;
                            int i20;
                            ee.c cVar2;
                            boolean z10;
                            p0 p0Var2;
                            if ((i19 & 3) == 2) {
                                p0 p0Var3 = (p0) oVar2;
                                if (p0Var3.G()) {
                                    p0Var3.Y();
                                    return;
                                }
                            }
                            r0 r0Var2 = v0.f3474a;
                            float f8 = 10;
                            androidx.compose.runtime.o oVar3 = oVar2;
                            androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                            String str4 = str;
                            String str5 = str2;
                            int i21 = i16;
                            ee.c cVar3 = cVar;
                            p0 p0Var4 = (p0) oVar3;
                            p0Var4.e0(733328855);
                            k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                            p0Var4.e0(-1323940314);
                            int iE = b1.E(oVar3);
                            w2 w2VarO = p0Var4.o();
                            androidx.compose.ui.node.u.i.getClass();
                            l0 l0Var = androidx.compose.ui.node.t.f4279b;
                            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                            p0Var4.h0();
                            if (p0Var4.M) {
                                p0Var4.n(l0Var);
                            } else {
                                p0Var4.t0();
                            }
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                            b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                            if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                                w0.u(iE, p0Var4, iE, mVar);
                            }
                            eVarM.invoke(new r3(oVar3), oVar3, 0);
                            p0Var4.e0(2058660585);
                            p0Var4.e0(-1419002037);
                            if (str4.length() == 0) {
                                cVar2 = cVar3;
                                str3 = str4;
                                z10 = false;
                                i20 = i21;
                                k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                                oVar3 = oVar2;
                                p0Var2 = p0Var4;
                            } else {
                                str3 = str4;
                                i20 = i21;
                                cVar2 = cVar3;
                                z10 = false;
                                p0Var2 = p0Var4;
                            }
                            p0Var2.u(z10);
                            Ios ios = Ios.INSTANCE;
                            int i22 = i20;
                            p0 p0Var5 = p0Var2;
                            f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                            w0.z(p0Var5, z10, true, z10, z10);
                        }
                    }), p0Var, 48);
                    tVar2 = tVar3;
                    i17 = i16;
                } else {
                    p0Var.Y();
                    i17 = i13;
                }
                c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new j2(str, cVar, str2, i17, tVar2, i10, i11);
                }
            }
            i12 |= 24576;
            tVar2 = tVar;
            if ((i12 & 9363) == 9362) {
                if (i18 != 0) {
                    i16 = 1;
                } else {
                    i16 = i13;
                }
                if (i14 != 0) {
                    tVar3 = androidx.compose.ui.q.f4604b;
                } else {
                    tVar3 = tVar2;
                }
                r0 r0Var2 = v0.f3474a;
                b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                        String str3;
                        int i20;
                        ee.c cVar2;
                        boolean z10;
                        p0 p0Var2;
                        if ((i19 & 3) == 2) {
                            p0 p0Var3 = (p0) oVar2;
                            if (p0Var3.G()) {
                                p0Var3.Y();
                                return;
                            }
                        }
                        r0 r0Var3 = v0.f3474a;
                        float f8 = 10;
                        androidx.compose.runtime.o oVar3 = oVar2;
                        androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                        String str4 = str;
                        String str5 = str2;
                        int i21 = i16;
                        ee.c cVar3 = cVar;
                        p0 p0Var4 = (p0) oVar3;
                        p0Var4.e0(733328855);
                        k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                        p0Var4.e0(-1323940314);
                        int iE = b1.E(oVar3);
                        w2 w2VarO = p0Var4.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0 l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                        p0Var4.h0();
                        if (p0Var4.M) {
                            p0Var4.n(l0Var);
                        } else {
                            p0Var4.t0();
                        }
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                        androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                        if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var4, iE, mVar);
                        }
                        eVarM.invoke(new r3(oVar3), oVar3, 0);
                        p0Var4.e0(2058660585);
                        p0Var4.e0(-1419002037);
                        if (str4.length() == 0) {
                            cVar2 = cVar3;
                            str3 = str4;
                            z10 = false;
                            i20 = i21;
                            k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                            oVar3 = oVar2;
                            p0Var2 = p0Var4;
                        } else {
                            str3 = str4;
                            i20 = i21;
                            cVar2 = cVar3;
                            z10 = false;
                            p0Var2 = p0Var4;
                        }
                        p0Var2.u(z10);
                        Ios ios = Ios.INSTANCE;
                        int i22 = i20;
                        p0 p0Var5 = p0Var2;
                        f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                        w0.z(p0Var5, z10, true, z10, z10);
                    }
                }), p0Var, 48);
                tVar2 = tVar3;
                i17 = i16;
            } else {
                if (i18 != 0) {
                    i16 = 1;
                } else {
                    i16 = i13;
                }
                if (i14 != 0) {
                    tVar3 = androidx.compose.ui.q.f4604b;
                } else {
                    tVar3 = tVar2;
                }
                r0 r0Var3 = v0.f3474a;
                b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                        String str3;
                        int i20;
                        ee.c cVar2;
                        boolean z10;
                        p0 p0Var2;
                        if ((i19 & 3) == 2) {
                            p0 p0Var3 = (p0) oVar2;
                            if (p0Var3.G()) {
                                p0Var3.Y();
                                return;
                            }
                        }
                        r0 r0Var4 = v0.f3474a;
                        float f8 = 10;
                        androidx.compose.runtime.o oVar3 = oVar2;
                        androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                        String str4 = str;
                        String str5 = str2;
                        int i21 = i16;
                        ee.c cVar3 = cVar;
                        p0 p0Var4 = (p0) oVar3;
                        p0Var4.e0(733328855);
                        k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                        p0Var4.e0(-1323940314);
                        int iE = b1.E(oVar3);
                        w2 w2VarO = p0Var4.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0 l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                        p0Var4.h0();
                        if (p0Var4.M) {
                            p0Var4.n(l0Var);
                        } else {
                            p0Var4.t0();
                        }
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                        androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                        if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var4, iE, mVar);
                        }
                        eVarM.invoke(new r3(oVar3), oVar3, 0);
                        p0Var4.e0(2058660585);
                        p0Var4.e0(-1419002037);
                        if (str4.length() == 0) {
                            cVar2 = cVar3;
                            str3 = str4;
                            z10 = false;
                            i20 = i21;
                            k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                            oVar3 = oVar2;
                            p0Var2 = p0Var4;
                        } else {
                            str3 = str4;
                            i20 = i21;
                            cVar2 = cVar3;
                            z10 = false;
                            p0Var2 = p0Var4;
                        }
                        p0Var2.u(z10);
                        Ios ios = Ios.INSTANCE;
                        int i22 = i20;
                        p0 p0Var5 = p0Var2;
                        f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                        w0.z(p0Var5, z10, true, z10, z10);
                    }
                }), p0Var, 48);
                tVar2 = tVar3;
                i17 = i16;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new j2(str, cVar, str2, i17, tVar2, i10, i11);
            }
        }
        i12 |= MamiIdentity.RSA_BITS;
        i13 = i;
        i14 = i11 & 16;
        if (i14 != 0) {
            if ((i10 & 24576) == 0) {
                tVar2 = tVar;
                if (p0Var.f(tVar2)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i12 |= i15;
            }
            if ((i12 & 9363) == 9362) {
                if (i18 != 0) {
                    i16 = 1;
                } else {
                    i16 = i13;
                }
                if (i14 != 0) {
                    tVar3 = androidx.compose.ui.q.f4604b;
                } else {
                    tVar3 = tVar2;
                }
                r0 r0Var4 = v0.f3474a;
                b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                        String str3;
                        int i20;
                        ee.c cVar2;
                        boolean z10;
                        p0 p0Var2;
                        if ((i19 & 3) == 2) {
                            p0 p0Var3 = (p0) oVar2;
                            if (p0Var3.G()) {
                                p0Var3.Y();
                                return;
                            }
                        }
                        r0 r0Var5 = v0.f3474a;
                        float f8 = 10;
                        androidx.compose.runtime.o oVar3 = oVar2;
                        androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                        String str4 = str;
                        String str5 = str2;
                        int i21 = i16;
                        ee.c cVar3 = cVar;
                        p0 p0Var4 = (p0) oVar3;
                        p0Var4.e0(733328855);
                        k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                        p0Var4.e0(-1323940314);
                        int iE = b1.E(oVar3);
                        w2 w2VarO = p0Var4.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0 l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                        p0Var4.h0();
                        if (p0Var4.M) {
                            p0Var4.n(l0Var);
                        } else {
                            p0Var4.t0();
                        }
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                        androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                        if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var4, iE, mVar);
                        }
                        eVarM.invoke(new r3(oVar3), oVar3, 0);
                        p0Var4.e0(2058660585);
                        p0Var4.e0(-1419002037);
                        if (str4.length() == 0) {
                            cVar2 = cVar3;
                            str3 = str4;
                            z10 = false;
                            i20 = i21;
                            k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                            oVar3 = oVar2;
                            p0Var2 = p0Var4;
                        } else {
                            str3 = str4;
                            i20 = i21;
                            cVar2 = cVar3;
                            z10 = false;
                            p0Var2 = p0Var4;
                        }
                        p0Var2.u(z10);
                        Ios ios = Ios.INSTANCE;
                        int i22 = i20;
                        p0 p0Var5 = p0Var2;
                        f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                        w0.z(p0Var5, z10, true, z10, z10);
                    }
                }), p0Var, 48);
                tVar2 = tVar3;
                i17 = i16;
            } else {
                if (i18 != 0) {
                    i16 = 1;
                } else {
                    i16 = i13;
                }
                if (i14 != 0) {
                    tVar3 = androidx.compose.ui.q.f4604b;
                } else {
                    tVar3 = tVar2;
                }
                r0 r0Var5 = v0.f3474a;
                b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                        return sd.u.f67154a;
                    }

                    public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                        String str3;
                        int i20;
                        ee.c cVar2;
                        boolean z10;
                        p0 p0Var2;
                        if ((i19 & 3) == 2) {
                            p0 p0Var3 = (p0) oVar2;
                            if (p0Var3.G()) {
                                p0Var3.Y();
                                return;
                            }
                        }
                        r0 r0Var6 = v0.f3474a;
                        float f8 = 10;
                        androidx.compose.runtime.o oVar3 = oVar2;
                        androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                        String str4 = str;
                        String str5 = str2;
                        int i21 = i16;
                        ee.c cVar3 = cVar;
                        p0 p0Var4 = (p0) oVar3;
                        p0Var4.e0(733328855);
                        k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                        p0Var4.e0(-1323940314);
                        int iE = b1.E(oVar3);
                        w2 w2VarO = p0Var4.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0 l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                        p0Var4.h0();
                        if (p0Var4.M) {
                            p0Var4.n(l0Var);
                        } else {
                            p0Var4.t0();
                        }
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                        b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                        androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                        if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var4, iE, mVar);
                        }
                        eVarM.invoke(new r3(oVar3), oVar3, 0);
                        p0Var4.e0(2058660585);
                        p0Var4.e0(-1419002037);
                        if (str4.length() == 0) {
                            cVar2 = cVar3;
                            str3 = str4;
                            z10 = false;
                            i20 = i21;
                            k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                            oVar3 = oVar2;
                            p0Var2 = p0Var4;
                        } else {
                            str3 = str4;
                            i20 = i21;
                            cVar2 = cVar3;
                            z10 = false;
                            p0Var2 = p0Var4;
                        }
                        p0Var2.u(z10);
                        Ios ios = Ios.INSTANCE;
                        int i22 = i20;
                        p0 p0Var5 = p0Var2;
                        f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                        w0.z(p0Var5, z10, true, z10, z10);
                    }
                }), p0Var, 48);
                tVar2 = tVar3;
                i17 = i16;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new j2(str, cVar, str2, i17, tVar2, i10, i11);
            }
        }
        i12 |= 24576;
        tVar2 = tVar;
        if ((i12 & 9363) == 9362) {
            if (i18 != 0) {
                i16 = 1;
            } else {
                i16 = i13;
            }
            if (i14 != 0) {
                tVar3 = androidx.compose.ui.q.f4604b;
            } else {
                tVar3 = tVar2;
            }
            r0 r0Var6 = v0.f3474a;
            b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                @Override // ee.e
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                    return sd.u.f67154a;
                }

                public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                    String str3;
                    int i20;
                    ee.c cVar2;
                    boolean z10;
                    p0 p0Var2;
                    if ((i19 & 3) == 2) {
                        p0 p0Var3 = (p0) oVar2;
                        if (p0Var3.G()) {
                            p0Var3.Y();
                            return;
                        }
                    }
                    r0 r0Var7 = v0.f3474a;
                    float f8 = 10;
                    androidx.compose.runtime.o oVar3 = oVar2;
                    androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                    String str4 = str;
                    String str5 = str2;
                    int i21 = i16;
                    ee.c cVar3 = cVar;
                    p0 p0Var4 = (p0) oVar3;
                    p0Var4.e0(733328855);
                    k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                    p0Var4.e0(-1323940314);
                    int iE = b1.E(oVar3);
                    w2 w2VarO = p0Var4.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0 l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var4.h0();
                    if (p0Var4.M) {
                        p0Var4.n(l0Var);
                    } else {
                        p0Var4.t0();
                    }
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                    androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                    if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                        w0.u(iE, p0Var4, iE, mVar);
                    }
                    eVarM.invoke(new r3(oVar3), oVar3, 0);
                    p0Var4.e0(2058660585);
                    p0Var4.e0(-1419002037);
                    if (str4.length() == 0) {
                        cVar2 = cVar3;
                        str3 = str4;
                        z10 = false;
                        i20 = i21;
                        k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                        oVar3 = oVar2;
                        p0Var2 = p0Var4;
                    } else {
                        str3 = str4;
                        i20 = i21;
                        cVar2 = cVar3;
                        z10 = false;
                        p0Var2 = p0Var4;
                    }
                    p0Var2.u(z10);
                    Ios ios = Ios.INSTANCE;
                    int i22 = i20;
                    p0 p0Var5 = p0Var2;
                    f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                    w0.z(p0Var5, z10, true, z10, z10);
                }
            }), p0Var, 48);
            tVar2 = tVar3;
            i17 = i16;
        } else {
            if (i18 != 0) {
                i16 = 1;
            } else {
                i16 = i13;
            }
            if (i14 != 0) {
                tVar3 = androidx.compose.ui.q.f4604b;
            } else {
                tVar3 = tVar2;
            }
            r0 r0Var7 = v0.f3474a;
            b1.b(new androidx.compose.runtime.a3[]{j3.f4495k.b(i1.j.Ltr)}, x6.p.f(p0Var, -535480888, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt.Field.1
                @Override // ee.e
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                    return sd.u.f67154a;
                }

                public final void invoke(androidx.compose.runtime.o oVar2, int i19) {
                    String str3;
                    int i20;
                    ee.c cVar2;
                    boolean z10;
                    p0 p0Var2;
                    if ((i19 & 3) == 2) {
                        p0 p0Var3 = (p0) oVar2;
                        if (p0Var3.G()) {
                            p0Var3.Y();
                            return;
                        }
                    }
                    r0 r0Var8 = v0.f3474a;
                    float f8 = 10;
                    androidx.compose.runtime.o oVar3 = oVar2;
                    androidx.compose.ui.t tVarW = f0.w(GlassKt.frostedGlass(d3.e(tVar3, 1.0f), e0.e.b(f8), false, false, oVar3, 0, 6), 12, f8);
                    String str4 = str;
                    String str5 = str2;
                    int i21 = i16;
                    ee.c cVar3 = cVar;
                    p0 p0Var4 = (p0) oVar3;
                    p0Var4.e0(733328855);
                    k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, false, oVar3);
                    p0Var4.e0(-1323940314);
                    int iE = b1.E(oVar3);
                    w2 w2VarO = p0Var4.o();
                    androidx.compose.ui.node.u.i.getClass();
                    l0 l0Var = androidx.compose.ui.node.t.f4279b;
                    androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
                    p0Var4.h0();
                    if (p0Var4.M) {
                        p0Var4.n(l0Var);
                    } else {
                        p0Var4.t0();
                    }
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4283f, k0VarC);
                    b1.Y(oVar3, androidx.compose.ui.node.t.f4282e, w2VarO);
                    androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                    if (p0Var4.M || !kotlin.jvm.internal.j.a(p0Var4.I(), Integer.valueOf(iE))) {
                        w0.u(iE, p0Var4, iE, mVar);
                    }
                    eVarM.invoke(new r3(oVar3), oVar3, 0);
                    p0Var4.e0(2058660585);
                    p0Var4.e0(-1419002037);
                    if (str4.length() == 0) {
                        cVar2 = cVar3;
                        str3 = str4;
                        z10 = false;
                        i20 = i21;
                        k9.b(str5, null, Ios.INSTANCE.getSecondaryLabel(oVar3, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 0, 130994);
                        oVar3 = oVar2;
                        p0Var2 = p0Var4;
                    } else {
                        str3 = str4;
                        i20 = i21;
                        cVar2 = cVar3;
                        z10 = false;
                        p0Var2 = p0Var4;
                    }
                    p0Var2.u(z10);
                    Ios ios = Ios.INSTANCE;
                    int i22 = i20;
                    p0 p0Var5 = p0Var2;
                    f2.f(str3, cVar2, d3.e(androidx.compose.ui.q.f4604b, 1.0f), false, false, new s1(ios.getLabel(oVar3, 6), x6.a.s(12.5d), null, androidx.compose.ui.text.font.j.f4785c, null, null, null, 0L, 16777180), null, null, i22 == 1 ? true : z10, 0, i22, null, null, null, new x0(ios.getBlue(oVar3, 6)), null, oVar2, 384, 0, 47832);
                    w0.z(p0Var5, z10, true, z10, z10);
                }
            }), p0Var, 48);
            tVar2 = tVar3;
            i17 = i16;
        }
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new j2(str, cVar, str2, i17, tVar2, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u Field$lambda$83(String str, ee.c cVar, String str2, int i, androidx.compose.ui.t tVar, int i10, int i11, androidx.compose.runtime.o oVar, int i12) {
        Field(str, cVar, str2, i, tVar, oVar, b1.b0(i10 | 1), i11);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GroupHead(final ee.e eVar, final String str, final String str2, final String str3, final boolean z10, final ee.a aVar, final boolean z11, final ee.a aVar2, androidx.compose.runtime.o oVar, final int i) {
        int i10;
        p0 p0Var = (p0) oVar;
        p0Var.f0(492022796);
        if ((i & 6) == 0) {
            i10 = (p0Var.h(eVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var.f(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= p0Var.f(str2) ? 256 : 128;
        }
        if ((i & MamiIdentity.RSA_BITS) == 0) {
            i10 |= p0Var.f(str3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= p0Var.g(z10) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= p0Var.h(aVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i10 |= p0Var.g(z11) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i10 |= p0Var.h(aVar2) ? TLObject.FLAG_23 : TLObject.FLAG_22;
        }
        if ((4793491 & i10) == 4793490 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            int i11 = i10;
            float f8 = 10;
            androidx.compose.ui.t tVarW = f0.w(androidx.compose.foundation.p.l(d3.e(qVar, 1.0f), false, null, aVar2, 7), 14, f8);
            androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
            p0Var.e0(-1323940314);
            int i12 = p0Var.N;
            w2 w2VarO = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar, k0VarA);
            androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar, w2VarO);
            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i12))) {
                w0.u(i12, p0Var, i12, mVar);
            }
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
            eVar.invoke(p0Var, Integer.valueOf(i11 & 14));
            f0.e(p0Var, d3.p(qVar, f8));
            if (1.0f <= 0.0d) {
                throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
            }
            LayoutWeightElement layoutWeightElementA = com.mlmvpn.scanner.e.a(1.0f, true, p0Var, -483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            int i13 = p0Var.N;
            w2 w2VarO2 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(layoutWeightElementA);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarA2);
            b1.Y(p0Var, rVar, w2VarO2);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i13))) {
                w0.u(i13, p0Var, i13, mVar);
            }
            w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
            Ios ios = Ios.INSTANCE;
            int i14 = i11 >> 3;
            k9.b(str, null, ios.getLabel(p0Var, 6), x6.a.t(15), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i14 & 14) | 199680, 0, 131026);
            int i15 = i11 >> 6;
            k9.b(str2, null, ios.getSecondaryLabel(p0Var, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i15 & 14) | MamiIdentity.RSA_BITS, 0, 131058);
            w0.z(p0Var, false, true, false, false);
            Btn(str3, false, z10, null, aVar, p0Var, (i15 & 896) | ((i11 >> 9) & 14) | (i14 & 57344), 10);
            f0.e(p0Var, d3.p(qVar, 6));
            k9.b(z11 ? "▴" : "▾", null, ios.getSecondaryLabel(p0Var, 6), x6.a.t(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, MamiIdentity.RSA_BITS, 0, 131058);
            p0Var = p0Var;
            w0.z(p0Var, false, true, false, false);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.j
                @Override // ee.e
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return ArgoScreenKt.GroupHead$lambda$121(eVar, str, str2, str3, z10, aVar, z11, aVar2, i, (androidx.compose.runtime.o) obj, iIntValue);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u GroupHead$lambda$121(ee.e eVar, String str, String str2, String str3, boolean z10, ee.a aVar, boolean z11, ee.a aVar2, int i, androidx.compose.runtime.o oVar, int i10) {
        GroupHead(eVar, str, str2, str3, z10, aVar, z11, aVar2, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void ItemRow(ArgoPool.Row row, RowCtx rowCtx, androidx.compose.runtime.o oVar, int i) {
        int i10;
        long blue;
        androidx.compose.ui.q qVar;
        androidx.compose.ui.node.r rVar;
        float f8;
        androidx.compose.ui.q qVar2;
        androidx.compose.ui.node.p pVar;
        androidx.compose.ui.node.m mVar;
        int i11;
        final ?? r4;
        int i12;
        boolean z10;
        final RowCtx rowCtx2;
        int i13;
        final ArgoPool.Row row2 = row;
        p0 p0Var = (p0) oVar;
        p0Var.f0(1236232631);
        if ((i & 6) == 0) {
            i10 = i | (p0Var.f(row2) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var.f(rowCtx) ? 32 : 16;
        }
        int i14 = i10;
        if ((i14 & 19) == 18 && p0Var.G()) {
            p0Var.Y();
            rowCtx2 = rowCtx;
            i13 = 0;
        } else {
            r0 r0Var = v0.f3474a;
            String kind = row2.getKind();
            if (kotlin.jvm.internal.j.a(kind, "bridge")) {
                p0Var.e0(-257569817);
                blue = Ios.INSTANCE.getOrange(p0Var, 6);
            } else if (kotlin.jvm.internal.j.a(kind, "falcon")) {
                p0Var.e0(-257569050);
                blue = Ios.INSTANCE.getGreen(p0Var, 6);
            } else {
                p0Var.e0(-257568443);
                blue = Ios.INSTANCE.getBlue(p0Var, 6);
            }
            p0Var.u(false);
            androidx.compose.ui.q qVar3 = androidx.compose.ui.q.f4604b;
            androidx.compose.ui.t tVarW = f0.w(d3.e(qVar3, 1.0f), 14, 9);
            p0Var.e0(-483455358);
            k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            int i15 = p0Var.N;
            w2 w2VarO = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarW);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar2 = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar2, k0VarA);
            androidx.compose.ui.node.r rVar2 = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar2, w2VarO);
            androidx.compose.ui.node.m mVar2 = androidx.compose.ui.node.t.i;
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i15))) {
                w0.u(i15, p0Var, i15, mVar2);
            }
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
            androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA2 = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
            p0Var.e0(-1323940314);
            int i16 = p0Var.N;
            w2 w2VarO2 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(qVar3);
            p0Var.h0();
            long j = blue;
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar2, k0VarA2);
            b1.Y(p0Var, rVar2, w2VarO2);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i16))) {
                w0.u(i16, p0Var, i16, mVar2);
            }
            w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
            p0Var.e0(-1327607501);
            if (row2.getVerified() > 0) {
                rVar = rVar2;
                qVar = qVar3;
                c3.b(StoreNetKt.tr("تأییدشده روی اینترنت ایران، بدون تونل", "verified on Iran's internet, untunnelled"), Ios.INSTANCE.getOrange(p0Var, 6), fc.a.r(), d3.m(qVar3, 15), p0Var, 384, 0);
                f0.e(p0Var, d3.p(qVar, 4));
            } else {
                qVar = qVar3;
                rVar = rVar2;
            }
            p0Var.u(false);
            m547ChipRPmYEkk(kindOne(row2.getKind()), j, p0Var, 0);
            float f10 = 6;
            f0.e(p0Var, d3.p(qVar, f10));
            androidx.compose.runtime.a3[] a3VarArr = {j3.f4495k.b(i1.j.Ltr)};
            final androidx.compose.foundation.layout.c3 c3Var = androidx.compose.foundation.layout.c3.f1985a;
            b1.b(a3VarArr, x6.p.f(p0Var, 1479257425, new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.ArgoScreenKt$ItemRow$1$1$1
                @Override // ee.e
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.o) obj, ((Number) obj2).intValue());
                    return sd.u.f67154a;
                }

                public final void invoke(androidx.compose.runtime.o oVar2, int i17) {
                    if ((i17 & 3) == 2) {
                        p0 p0Var2 = (p0) oVar2;
                        if (p0Var2.G()) {
                            p0Var2.Y();
                            return;
                        }
                    }
                    r0 r0Var2 = v0.f3474a;
                    k9.b(v0.a.p(row2.getHost(), row2.getPort() != 443 ? f0.a.h(row2.getPort(), ":") : ""), c3Var.a(1.0f, false), Ios.INSTANCE.getLabel(oVar2, 6), x6.a.s(12.5d), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, 0L, 2, false, 1, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 3120, 120752);
                }
            }), p0Var, 48);
            w0.z(p0Var, false, true, false, false);
            String strTr = row2.getUser() ? StoreNetKt.tr("افزودهٔ شما", "added by you") : null;
            String strDateWord = dateWord(row2.getSeen());
            if (kotlin.text.o.L0(strDateWord)) {
                strDateWord = null;
            }
            String strTr2 = strDateWord != null ? StoreNetKt.tr("انتشار ".concat(strDateWord), "posted ".concat(strDateWord)) : null;
            String cc2 = row2.getCc();
            if (kotlin.text.o.L0(cc2)) {
                cc2 = null;
            }
            String strL = cc2 != null ? f0.a.l(flag(cc2), " ", country(cc2)) : null;
            String exitIp = row2.getExitIp();
            if (kotlin.text.o.L0(exitIp)) {
                exitIp = null;
            }
            String strTr3 = exitIp != null ? StoreNetKt.tr("خروج ".concat(exitIp), "exit ".concat(exitIp)) : null;
            String profile = row2.getProfile();
            if (kotlin.text.o.L0(profile)) {
                profile = null;
            }
            String strF0 = kotlin.collections.q.F0(kotlin.collections.o.b0(new String[]{strTr, strTr2, strL, strTr3, profile != null ? StoreNetKt.tr("پروفایل ".concat(profile), "profile ".concat(profile)) : null}), " · ", null, null, null, 62);
            p0Var.e0(1702138296);
            if (kotlin.text.o.L0(strF0)) {
                f8 = f10;
                qVar2 = qVar;
                pVar = pVar2;
                mVar = mVar2;
            } else {
                f8 = f10;
                pVar = pVar2;
                qVar2 = qVar;
                mVar = mVar2;
                k9.b(strF0, f0.z(qVar, 0.0f, 2, 0.0f, 0.0f, 13), Ios.INSTANCE.getSecondaryLabel(p0Var, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, 3120, 0, 131056);
                p0Var = p0Var;
            }
            p0Var.u(false);
            androidx.compose.ui.t tVarZ = f0.z(d3.e(qVar2, 1.0f), 0.0f, 5, 0.0f, 0.0f, 13);
            androidx.compose.foundation.layout.f fVarH = androidx.compose.foundation.layout.i.h(f8);
            androidx.compose.foundation.layout.f fVarH2 = androidx.compose.foundation.layout.i.h(4);
            p0Var.e0(1098475987);
            k0 k0VarC = a1.c(fVarH, fVarH2, p0Var);
            p0Var.e0(-1323940314);
            int i17 = p0Var.N;
            w2 w2VarO3 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarZ);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarC);
            b1.Y(p0Var, rVar, w2VarO3);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i17))) {
                w0.u(i17, p0Var, i17, mVar);
            }
            w0.x(p0Var, eVarM3, p0Var, 0, 2058660585);
            if (kotlin.jvm.internal.j.a(row.getOk(), Boolean.TRUE)) {
                p0Var.e0(1795338630);
                Long ms = row.getMs();
                String strP = v0.a.p(fa(ms != null ? ms.longValue() : 0L), " ms");
                Long ms2 = row.getMs();
                p0 p0Var2 = p0Var;
                k9.b(strP, new VerticalAlignElement(), msTone(ms2 != null ? ms2.longValue() : 0L, p0Var, 0), x6.a.t(13), null, androidx.compose.ui.text.font.w.f4818n, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var2, 199680, 0, 131024);
                p0Var = p0Var2;
                p0Var.u(false);
                i11 = 6;
            } else if (kotlin.jvm.internal.j.a(row.getOk(), Boolean.FALSE)) {
                p0Var.e0(1795529373);
                String error = row.getError();
                if (kotlin.text.o.L0(error)) {
                    error = StoreNetKt.tr("جواب نداد", "no answer");
                }
                if (error.length() > 42) {
                    error = kotlin.text.o.l1(42, error).concat("…");
                }
                i11 = 6;
                p0 p0Var3 = p0Var;
                k9.b(error, new VerticalAlignElement(), Ios.INSTANCE.getRed(p0Var, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var3, MamiIdentity.RSA_BITS, 0, 131056);
                p0Var = p0Var3;
                p0Var.u(false);
            } else {
                i11 = 6;
                p0Var.e0(1795748729);
                p0 p0Var4 = p0Var;
                k9.b(StoreNetKt.tr("سنجیده نشده", "not tested"), new VerticalAlignElement(), Ios.INSTANCE.getSecondaryLabel(p0Var, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var4, MamiIdentity.RSA_BITS, 0, 131056);
                p0Var = p0Var4;
                p0Var.u(false);
            }
            p0Var.e0(-1327540691);
            if (row.getFrozen() && !rowCtx.getHasClean()) {
                Btn(StoreNetKt.tr("آی\u200cپی تمیز", "Clean IP"), false, false, hb.a.y(), rowCtx.getOnClean(), p0Var, 0, 6);
            }
            p0Var.u(false);
            boolean zA = kotlin.jvm.internal.j.a(rowCtx.getHereId(), row.getId());
            e2 e2Var = androidx.compose.runtime.n.f3284a;
            if (zA) {
                p0Var.e0(-1327536129);
                m547ChipRPmYEkk(StoreNetKt.tr("وصل", "on"), Ios.INSTANCE.getGreen(p0Var, i11), p0Var, 0);
                p0Var.u(false);
                r4 = 1;
                i12 = 32;
                row2 = row;
                rowCtx2 = rowCtx;
            } else {
                p0Var.e0(-1327534486);
                String strTr4 = StoreNetKt.tr("وصل شو", "Connect");
                r4 = 1;
                boolean z11 = !rowCtx.getConnecting();
                p0Var.e0(-1327532812);
                i12 = 32;
                boolean z12 = ((i14 & 112) == 32) | ((i14 & 14) == 4);
                Object objI = p0Var.I();
                if (z12 || objI == e2Var) {
                    z10 = false;
                    row2 = row;
                    rowCtx2 = rowCtx;
                    final ?? r14 = 0 == true ? 1 : 0;
                    objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.h
                        @Override // ee.a
                        public final Object invoke() {
                            switch (r14) {
                                case 0:
                                    return ArgoScreenKt.ItemRow$lambda$138$lambda$137$lambda$134$lambda$133(rowCtx2, row2);
                                default:
                                    return ArgoScreenKt.ItemRow$lambda$138$lambda$137$lambda$136$lambda$135(rowCtx2, row2);
                            }
                        }
                    };
                    p0Var.r0(objI);
                } else {
                    z10 = false;
                    row2 = row;
                    rowCtx2 = rowCtx;
                }
                p0Var.u(z10);
                Btn(strTr4, false, z11, null, (ee.a) objI, p0Var, 0, 10);
                p0Var.u(z10);
            }
            String strTr5 = StoreNetKt.tr("سنجش همین", "Test this");
            androidx.compose.ui.graphics.vector.f fVarX = com.google.android.gms.internal.auth.j.x();
            boolean z13 = !rowCtx2.getTesting();
            p0Var.e0(-1327529039);
            ?? r8 = ((i14 & 14) == 4 ? r4 : 0) | ((i14 & 112) == i12 ? r4 : 0);
            Object objI2 = p0Var.I();
            if (r8 != 0 || objI2 == e2Var) {
                objI2 = new ee.a() { // from class: com.mlmvpn.scanner.ui.argo.h
                    @Override // ee.a
                    public final Object invoke() {
                        switch (r4) {
                            case 0:
                                return ArgoScreenKt.ItemRow$lambda$138$lambda$137$lambda$134$lambda$133(rowCtx2, row2);
                            default:
                                return ArgoScreenKt.ItemRow$lambda$138$lambda$137$lambda$136$lambda$135(rowCtx2, row2);
                        }
                    }
                };
                p0Var.r0(objI2);
            }
            i13 = 0;
            p0Var.u(false);
            Btn(strTr5, false, z13, fVarX, (ee.a) objI2, p0Var, 0, 2);
            w0.z(p0Var, false, r4, false, false);
            w0.z(p0Var, false, r4, false, false);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new i(row2, rowCtx2, i, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ItemRow$lambda$138$lambda$137$lambda$134$lambda$133(RowCtx rowCtx, ArgoPool.Row row) {
        rowCtx.getOnConnect().invoke(row.getId());
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ItemRow$lambda$138$lambda$137$lambda$136$lambda$135(RowCtx rowCtx, ArgoPool.Row row) {
        rowCtx.getOnTest().invoke(row.getId());
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u ItemRow$lambda$139(ArgoPool.Row row, RowCtx rowCtx, int i, androidx.compose.runtime.o oVar, int i10) {
        ItemRow(row, rowCtx, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void JobLine(int i, int i10, String str, androidx.compose.runtime.o oVar, int i11) {
        int i12;
        float f8;
        int i13;
        String str2 = str;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-1456220331);
        if ((i11 & 6) == 0) {
            i12 = (p0Var.d(i) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= p0Var.d(i10) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= p0Var.f(str2) ? 256 : 128;
        }
        if ((i12 & 147) == 146 && p0Var.G()) {
            p0Var.Y();
            i13 = i;
        } else {
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            float f10 = 8;
            androidx.compose.ui.t tVarZ = f0.z(d3.e(qVar, 1.0f), 0.0f, f10, 0.0f, 0.0f, 13);
            androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
            p0Var.e0(-1323940314);
            int i14 = p0Var.N;
            w2 w2VarO = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarZ);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar, k0VarA);
            androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar, w2VarO);
            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i14))) {
                w0.u(i14, p0Var, i14, mVar);
            }
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
            androidx.compose.ui.t tVarM = d3.m(qVar, 14);
            Ios ios = Ios.INSTANCE;
            float f11 = 2;
            int i15 = i12;
            f5.b(f11, 0, 390, 24, ios.getBlue(p0Var, 6), 0L, p0Var, tVarM);
            f0.e(p0Var, d3.p(qVar, f10));
            if (1.0f <= 0.0d) {
                throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
            }
            LayoutWeightElement layoutWeightElementA = com.mlmvpn.scanner.e.a(1.0f, true, p0Var, -483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            int i16 = p0Var.N;
            w2 w2VarO2 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(layoutWeightElementA);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarA2);
            b1.Y(p0Var, rVar, w2VarO2);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i16))) {
                w0.u(i16, p0Var, i16, mVar);
            }
            w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
            float fC = 0.0f;
            if (i10 > 0) {
                i13 = i;
                f8 = 1.0f;
                fC = com.google.android.gms.internal.mlkit_language_id_common.j.c(i13 / i10, 0.0f, 1.0f);
            } else {
                f8 = 1.0f;
                i13 = i;
            }
            androidx.compose.ui.t tVarE = d3.e(qVar, f8);
            float f12 = 4;
            f5.d(fC, 0, 0, 16, ios.getBlue(p0Var, 6), androidx.compose.ui.graphics.v.c(0.12f, ios.getLabel(p0Var, 6)), p0Var, androidx.compose.ui.draw.h.b(d3.g(tVarE, f12), e0.e.b(f11)));
            f0.e(p0Var, d3.g(qVar, f12));
            str2 = str;
            k9.b(str2, null, ios.getSecondaryLabel(p0Var, 6), x6.a.s(11.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, ((i15 >> 6) & 14) | MamiIdentity.RSA_BITS, 0, 131058);
            p0Var = p0Var;
            w0.z(p0Var, false, true, false, false);
            w0.z(p0Var, false, true, false, false);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new com.mlmvpn.scanner.ui.amnezia.m(i13, i10, str2, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u JobLine$lambda$76(int i, int i10, String str, int i11, androidx.compose.runtime.o oVar, int i12) {
        JobLine(i, i10, str, oVar, b1.b0(i11 | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x022a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0233  */
    /* JADX WARN: Code duplicated, block: B:106:0x025e  */
    /* JADX WARN: Code duplicated, block: B:109:0x028c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0294  */
    /* JADX WARN: Code duplicated, block: B:76:0x0170  */
    /* JADX WARN: Code duplicated, block: B:79:0x0184  */
    /* JADX WARN: Code duplicated, block: B:80:0x018e  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01da  */
    /* JADX WARN: Code duplicated, block: B:94:0x0206  */
    /* JADX WARN: Code duplicated, block: B:95:0x020a  */
    public static final void PowerButton(final boolean z10, final boolean z11, final boolean z12, final boolean z13, final ee.a aVar, androidx.compose.runtime.o oVar, final int i) {
        int i10;
        long orange;
        String strTr;
        String str;
        int i11;
        float f8;
        boolean zF;
        Object objI;
        androidx.compose.ui.t tVarL;
        int i12;
        int i13;
        androidx.compose.ui.q qVar;
        int i14;
        int i15;
        String strTr2;
        String str2;
        p0 p0Var = (p0) oVar;
        p0Var.f0(52025180);
        if ((i & 6) == 0) {
            i10 = (p0Var.g(z10) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var.g(z11) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= p0Var.g(z12) ? 256 : 128;
        }
        if ((i & MamiIdentity.RSA_BITS) == 0) {
            i10 |= p0Var.g(z13) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= p0Var.h(aVar) ? 16384 : 8192;
        }
        if ((i10 & 9363) == 9362 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            if (z10) {
                p0Var.e0(-1204282858);
                orange = Ios.INSTANCE.getGreen(p0Var, 6);
            } else if (z11 || z12) {
                p0Var.e0(-1204281865);
                orange = Ios.INSTANCE.getOrange(p0Var, 6);
            } else {
                p0Var.e0(-1204281227);
                orange = Ios.INSTANCE.getGray(p0Var, 6);
            }
            p0Var.u(false);
            if (z12) {
                strTr = StoreNetKt.tr("لغو اتصال", "Cancel");
            } else {
                strTr = (z10 || z11) ? StoreNetKt.tr("قطع اتصال", "Disconnect") : StoreNetKt.tr("اتصال به سریع\u200cترین", "Connect to the fastest");
            }
            androidx.compose.ui.q qVar2 = androidx.compose.ui.q.f4604b;
            androidx.compose.ui.t tVarE = d3.e(qVar2, 1.0f);
            androidx.compose.ui.j jVar = androidx.compose.ui.b.f3544e;
            p0Var.e0(733328855);
            k0 k0VarC = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
            p0Var.e0(-1323940314);
            int i16 = p0Var.N;
            w2 w2VarO = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0 l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarE);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar, k0VarC);
            androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar, w2VarO);
            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                str = "Cancel";
            } else {
                str = "Cancel";
                if (!kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i16))) {
                }
                w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
                androidx.compose.ui.t tVarM = d3.m(qVar2, 132);
                e0.d dVar = e0.e.f17770a;
                androidx.compose.ui.t tVarF = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(tVarM, dVar), androidx.compose.ui.graphics.v.c(0.18f, orange), androidx.compose.ui.graphics.d0.f3719a);
                i11 = 3;
                f8 = 3;
                androidx.compose.ui.t tVarH = androidx.compose.foundation.p.h(tVarF, f8, orange, dVar);
                p0Var.e0(178663758);
                zF = p0Var.f(strTr);
                objI = p0Var.I();
                if (zF || objI == androidx.compose.runtime.n.f3284a) {
                    objI = new a0(strTr, i11);
                    p0Var.r0(objI);
                }
                p0Var.u(false);
                androidx.compose.ui.t tVarA = androidx.compose.ui.semantics.k.a(tVarH, false, (ee.c) objI);
                if (z13) {
                    tVarL = androidx.compose.foundation.p.l(qVar2, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                } else {
                    tVarL = qVar2;
                }
                androidx.compose.ui.t tVarI = tVarA.i(tVarL);
                p0Var.e0(733328855);
                k0 k0VarC2 = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
                p0Var.e0(-1323940314);
                i12 = p0Var.N;
                w2 w2VarO2 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarI);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, pVar, k0VarC2);
                b1.Y(p0Var, rVar, w2VarO2);
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i12))) {
                    w0.u(i12, p0Var, i12, mVar);
                }
                w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
                androidx.compose.ui.h hVar = androidx.compose.ui.b.x;
                p0Var.e0(-483455358);
                k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar, p0Var);
                p0Var.e0(-1323940314);
                i13 = p0Var.N;
                w2 w2VarO3 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(qVar2);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, pVar, k0VarA);
                b1.Y(p0Var, rVar, w2VarO3);
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i13))) {
                    w0.u(i13, p0Var, i13, mVar);
                }
                w0.x(p0Var, eVarM3, p0Var, 0, 2058660585);
                if (z12) {
                    p0Var.e0(218660895);
                    qVar = qVar2;
                    i14 = 4;
                    i15 = 6;
                    f5.b(f8, 0, 390, 24, orange, 0L, p0Var, d3.m(qVar2, 40));
                    p0Var = p0Var;
                    p0Var.u(false);
                } else {
                    qVar = qVar2;
                    i14 = 4;
                    i15 = 6;
                    p0Var.e0(-1811343801);
                    c3.b(null, orange, ge.a.v(), d3.m(qVar, 44), p0Var, 432, 0);
                    p0Var.u(false);
                }
                f0.e(p0Var, d3.g(qVar, i14));
                if (z12) {
                    str2 = "لغو";
                } else {
                    if (!z10 || z11) {
                        strTr2 = StoreNetKt.tr("قطع", "Disconnect");
                    } else {
                        str2 = "اتصال";
                        str = "Connect";
                    }
                    p0 p0Var2 = p0Var;
                    k9.b(strTr2, null, Ios.INSTANCE.getLabel(p0Var, i15), x6.a.t(14), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var2, 199680, 0, 131026);
                    p0Var = p0Var2;
                    w0.z(p0Var, false, true, false, false);
                    w0.z(p0Var, false, true, false, false);
                    w0.z(p0Var, false, true, false, false);
                }
                strTr2 = StoreNetKt.tr(str2, str);
                p0 p0Var3 = p0Var;
                k9.b(strTr2, null, Ios.INSTANCE.getLabel(p0Var, i15), x6.a.t(14), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var3, 199680, 0, 131026);
                p0Var = p0Var3;
                w0.z(p0Var, false, true, false, false);
                w0.z(p0Var, false, true, false, false);
                w0.z(p0Var, false, true, false, false);
            }
            w0.u(i16, p0Var, i16, mVar);
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
            androidx.compose.ui.t tVarM2 = d3.m(qVar2, 132);
            e0.d dVar2 = e0.e.f17770a;
            androidx.compose.ui.t tVarF2 = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(tVarM2, dVar2), androidx.compose.ui.graphics.v.c(0.18f, orange), androidx.compose.ui.graphics.d0.f3719a);
            i11 = 3;
            f8 = 3;
            androidx.compose.ui.t tVarH2 = androidx.compose.foundation.p.h(tVarF2, f8, orange, dVar2);
            p0Var.e0(178663758);
            zF = p0Var.f(strTr);
            objI = p0Var.I();
            if (zF) {
                objI = new a0(strTr, i11);
                p0Var.r0(objI);
            } else {
                objI = new a0(strTr, i11);
                p0Var.r0(objI);
            }
            p0Var.u(false);
            androidx.compose.ui.t tVarA2 = androidx.compose.ui.semantics.k.a(tVarH2, false, (ee.c) objI);
            if (z13) {
                tVarL = androidx.compose.foundation.p.l(qVar2, false, new androidx.compose.ui.semantics.f(0), aVar, 3);
            } else {
                tVarL = qVar2;
            }
            androidx.compose.ui.t tVarI2 = tVarA2.i(tVarL);
            p0Var.e0(733328855);
            k0 k0VarC3 = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
            p0Var.e0(-1323940314);
            i12 = p0Var.N;
            w2 w2VarO4 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(tVarI2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarC3);
            b1.Y(p0Var, rVar, w2VarO4);
            if (p0Var.M) {
                w0.u(i12, p0Var, i12, mVar);
            } else {
                w0.u(i12, p0Var, i12, mVar);
            }
            w0.x(p0Var, eVarM4, p0Var, 0, 2058660585);
            androidx.compose.ui.h hVar2 = androidx.compose.ui.b.x;
            p0Var.e0(-483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar2, p0Var);
            p0Var.e0(-1323940314);
            i13 = p0Var.N;
            w2 w2VarO5 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(qVar2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarA2);
            b1.Y(p0Var, rVar, w2VarO5);
            if (p0Var.M) {
                w0.u(i13, p0Var, i13, mVar);
            } else {
                w0.u(i13, p0Var, i13, mVar);
            }
            w0.x(p0Var, eVarM5, p0Var, 0, 2058660585);
            if (z12) {
                p0Var.e0(218660895);
                qVar = qVar2;
                i14 = 4;
                i15 = 6;
                f5.b(f8, 0, 390, 24, orange, 0L, p0Var, d3.m(qVar2, 40));
                p0Var = p0Var;
                p0Var.u(false);
            } else {
                qVar = qVar2;
                i14 = 4;
                i15 = 6;
                p0Var.e0(-1811343801);
                c3.b(null, orange, ge.a.v(), d3.m(qVar, 44), p0Var, 432, 0);
                p0Var.u(false);
            }
            f0.e(p0Var, d3.g(qVar, i14));
            if (z12) {
                str2 = "لغو";
            } else {
                if (z10) {
                }
                strTr2 = StoreNetKt.tr("قطع", "Disconnect");
                p0 p0Var4 = p0Var;
                k9.b(strTr2, null, Ios.INSTANCE.getLabel(p0Var, i15), x6.a.t(14), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var4, 199680, 0, 131026);
                p0Var = p0Var4;
                w0.z(p0Var, false, true, false, false);
                w0.z(p0Var, false, true, false, false);
                w0.z(p0Var, false, true, false, false);
            }
            strTr2 = StoreNetKt.tr(str2, str);
            p0 p0Var5 = p0Var;
            k9.b(strTr2, null, Ios.INSTANCE.getLabel(p0Var, i15), x6.a.t(14), null, androidx.compose.ui.text.font.w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var5, 199680, 0, 131026);
            p0Var = p0Var5;
            w0.z(p0Var, false, true, false, false);
            w0.z(p0Var, false, true, false, false);
            w0.z(p0Var, false, true, false, false);
        }
        androidx.compose.runtime.c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.a
                @Override // ee.e
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return ArgoScreenKt.PowerButton$lambda$89(z10, z11, z12, z13, aVar, i, (androidx.compose.runtime.o) obj, iIntValue);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u PowerButton$lambda$88$lambda$85$lambda$84(String str, j0 semantics) {
        kotlin.jvm.internal.j.e(semantics, "$this$semantics");
        g0.c(str, semantics);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u PowerButton$lambda$89(boolean z10, boolean z11, boolean z12, boolean z13, ee.a aVar, int i, androidx.compose.runtime.o oVar, int i10) {
        PowerButton(z10, z11, z12, z13, aVar, oVar, b1.b0(i | 1));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:104:0x0201  */
    /* JADX WARN: Code duplicated, block: B:107:0x022b  */
    /* JADX WARN: Code duplicated, block: B:108:0x022d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0233  */
    /* JADX WARN: Code duplicated, block: B:112:0x0235  */
    /* JADX WARN: Code duplicated, block: B:115:0x023d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x023f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0270  */
    /* JADX WARN: Code duplicated, block: B:120:0x0272  */
    /* JADX WARN: Code duplicated, block: B:122:0x0275  */
    /* JADX WARN: Code duplicated, block: B:123:0x0277  */
    /* JADX WARN: Code duplicated, block: B:126:0x027f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x0281  */
    /* JADX WARN: Code duplicated, block: B:130:0x029f  */
    /* JADX WARN: Code duplicated, block: B:132:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:134:0x02da  */
    /* JADX WARN: Code duplicated, block: B:136:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:141:0x0321  */
    /* JADX WARN: Code duplicated, block: B:144:0x033b  */
    /* JADX WARN: Code duplicated, block: B:147:0x0358  */
    /* JADX WARN: Code duplicated, block: B:149:0x037b  */
    /* JADX WARN: Code duplicated, block: B:150:0x0386  */
    /* JADX WARN: Code duplicated, block: B:153:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:156:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:160:0x03de  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:76:0x0125  */
    /* JADX WARN: Code duplicated, block: B:77:0x0129  */
    /* JADX WARN: Code duplicated, block: B:80:0x013c  */
    /* JADX WARN: Code duplicated, block: B:82:0x014a  */
    /* JADX WARN: Code duplicated, block: B:85:0x017b  */
    /* JADX WARN: Code duplicated, block: B:86:0x017f  */
    /* JADX WARN: Code duplicated, block: B:89:0x018c  */
    /* JADX WARN: Code duplicated, block: B:93:0x019f  */
    /* JADX WARN: Code duplicated, block: B:96:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c8  */
    /* JADX WARN: Instruction removed from duplicated block: B:147:0x0358, please report this as an issue */
    public static final void TestCard(String str, ArgoPool.Job job, ArgoPool.Job job2, ee.e eVar, ee.c cVar, androidx.compose.runtime.o oVar, int i, int i10) {
        int i11;
        ee.e eVar2;
        int i12;
        ee.e eVar3;
        boolean z10;
        boolean z11;
        int i13;
        ee.e eVar4;
        int i14;
        l0 l0Var;
        androidx.compose.ui.node.m mVar;
        int i15;
        e2 e2Var;
        String strJ;
        int i16;
        boolean z12;
        int i17;
        boolean z13;
        boolean z14;
        Object objI;
        boolean z15;
        boolean z16;
        boolean z17;
        Object objI2;
        Object objI3;
        boolean z18;
        ee.e eVar5;
        String strH;
        Object objI4;
        Object objI5;
        androidx.compose.runtime.c3 c3VarY;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-1561098706);
        if ((i10 & 1) != 0) {
            i11 = i | 6;
        } else if ((i & 6) == 0) {
            i11 = (p0Var.f(str) ? 4 : 2) | i;
        } else {
            i11 = i;
        }
        if ((i10 & 2) != 0) {
            i11 |= 48;
        } else if ((i & 48) == 0) {
            i11 |= p0Var.h(job) ? 32 : 16;
        }
        if ((i10 & 4) != 0) {
            i11 |= 384;
        } else if ((i & 384) == 0) {
            i11 |= p0Var.h(job2) ? 256 : 128;
        }
        int i18 = i10 & 8;
        if (i18 == 0) {
            if ((i & MamiIdentity.RSA_BITS) == 0) {
                eVar2 = eVar;
                i11 |= p0Var.h(eVar2) ? 2048 : 1024;
            }
            if ((i10 & 16) != 0) {
                i11 |= 24576;
            } else if ((i & 24576) == 0) {
                if (p0Var.h(cVar)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i11 |= i12;
            }
            if ((i11 & 9363) == 9362 || !p0Var.G()) {
                if (i18 != 0) {
                    eVar3 = null;
                } else {
                    eVar3 = eVar2;
                }
                r0 r0Var = v0.f3474a;
                if (job == null && job.getRunning()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (job2 == null && job2.getRunning()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                i13 = i11;
                eVar4 = eVar3;
                androidx.compose.ui.t tVarFrostedGlass = GlassKt.frostedGlass(f0.x(d3.e(qVar, 1.0f), 16, 0.0f, 2), e0.e.b(12), false, false, p0Var, 6, 6);
                p0Var = p0Var;
                androidx.compose.ui.t tVarV = f0.v(tVarFrostedGlass, 10);
                p0Var.e0(-483455358);
                k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
                p0Var.e0(-1323940314);
                i14 = p0Var.N;
                w2 w2VarO = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarV);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                androidx.compose.ui.node.p pVar = androidx.compose.ui.node.t.f4283f;
                b1.Y(p0Var, pVar, k0VarA);
                androidx.compose.ui.node.r rVar = androidx.compose.ui.node.t.f4282e;
                b1.Y(p0Var, rVar, w2VarO);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i14))) {
                    w0.u(i14, p0Var, i14, mVar);
                }
                w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
                float f8 = 6;
                androidx.compose.foundation.layout.f fVarH = androidx.compose.foundation.layout.i.h(f8);
                androidx.compose.foundation.layout.f fVarH2 = androidx.compose.foundation.layout.i.h(f8);
                p0Var.e0(1098475987);
                k0 k0VarC = a1.c(fVarH, fVarH2, p0Var);
                p0Var.e0(-1323940314);
                i15 = p0Var.N;
                w2 w2VarO2 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(qVar);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, pVar, k0VarC);
                b1.Y(p0Var, rVar, w2VarO2);
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i15))) {
                    w0.u(i15, p0Var, i15, mVar);
                }
                w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
                e2Var = androidx.compose.runtime.n.f3284a;
                if (z10) {
                    p0Var.e0(1086186590);
                    String strTr = StoreNetKt.tr("توقف سنجش", "Stop the test");
                    androidx.compose.ui.graphics.vector.f fVarY = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                    p0Var.e0(1086188605);
                    objI5 = p0Var.I();
                    if (objI5 == e2Var) {
                        objI5 = new r(6);
                        p0Var.r0(objI5);
                    }
                    p0Var.u(false);
                    Btn(strTr, false, false, fVarY, (ee.a) objI5, p0Var, 24576, 6);
                    p0Var.u(false);
                } else {
                    p0Var.e0(-687836617);
                    if (kotlin.jvm.internal.j.a(str, Psi.CrashTracebackLevelAll)) {
                        strJ = StoreNetKt.tr("سنجش همه", "Test all");
                    } else {
                        strJ = g1.j("Test every ", kindOne(str), w0.n("سنجش همهٔ ", kindOne(str), "\u200cها"));
                    }
                    String str2 = strJ;
                    androidx.compose.ui.graphics.vector.f fVarX = com.google.android.gms.internal.auth.j.x();
                    p0Var.e0(1086195430);
                    i16 = i13 & 57344;
                    if (i16 == 16384) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    i17 = i13 & 14;
                    if (i17 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = z12 | z13;
                    objI = p0Var.I();
                    if (z14 || objI == e2Var) {
                        objI = new w(1, str, cVar);
                        p0Var.r0(objI);
                    }
                    p0Var.u(false);
                    Btn(str2, false, false, fVarX, (ee.a) objI, p0Var, 0, 6);
                    String strTr2 = StoreNetKt.tr("سنجش نسنجیده\u200cها", "Test the untested");
                    p0Var.e0(1086201587);
                    if (i16 == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if (i17 == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 = z16 | z15;
                    objI2 = p0Var.I();
                    if (z17 || objI2 == e2Var) {
                        objI2 = new w(2, str, cVar);
                        p0Var.r0(objI2);
                    }
                    p0Var.u(false);
                    Btn(strTr2, false, false, null, (ee.a) objI2, p0Var, 0, 14);
                    p0Var.u(false);
                }
                if (z11) {
                    p0Var.e0(1086206378);
                    String strTr3 = StoreNetKt.tr("توقف به\u200cروزرسانی", "Stop the refresh");
                    androidx.compose.ui.graphics.vector.f fVarY2 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                    p0Var.e0(1086208703);
                    objI4 = p0Var.I();
                    if (objI4 == e2Var) {
                        objI4 = new r(10);
                        p0Var.r0(objI4);
                    }
                    p0Var.u(false);
                    Btn(strTr3, false, false, fVarY2, (ee.a) objI4, p0Var, 24576, 6);
                    p0Var.u(false);
                } else {
                    p0Var.e0(1086210176);
                    String strTr4 = StoreNetKt.tr("به\u200cروزرسانی پل\u200cها و فالکن\u200cها", "Refresh bridges and falcons");
                    androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                    p0Var.e0(1086213307);
                    objI3 = p0Var.I();
                    if (objI3 == e2Var) {
                        objI3 = new r(11);
                        p0Var.r0(objI3);
                    }
                    p0Var.u(false);
                    Btn(strTr4, false, false, fVarE, (ee.a) objI3, p0Var, 24576, 6);
                    p0Var.u(false);
                }
                p0Var.e0(1086214606);
                if (eVar4 != null) {
                    eVar4.invoke(p0Var, Integer.valueOf((i13 >> 9) & 14));
                }
                w0.z(p0Var, false, false, true, false);
                p0Var.u(false);
                p0Var.e0(1855780325);
                if (z10) {
                    kotlin.jvm.internal.j.b(job);
                    JobLine(job.getDone(), job.getTotal(), progressWord(job), p0Var, 0);
                }
                p0Var.u(false);
                p0Var.e0(1855782778);
                if (z11) {
                    kotlin.jvm.internal.j.b(job2);
                    int done = job2.getDone();
                    int total = job2.getTotal();
                    String label = job2.getLabel();
                    String strFa = fa(job2.getFound());
                    if (kotlin.text.o.L0(job2.getVia())) {
                        strH = "";
                    } else {
                        strH = v0.a.h(" · از راه ", job2.getVia());
                    }
                    String strK = g1.k(label, " · ", strFa, " مورد تازه", strH);
                    z18 = false;
                    JobLine(done, total, StoreNetKt.tr(strK, job2.getLabel() + " · " + job2.getFound() + " new" + (kotlin.text.o.L0(job2.getVia()) ? "" : v0.a.h(" · via ", job2.getVia()))), p0Var, 0);
                } else {
                    z18 = false;
                }
                w0.z(p0Var, z18, z18, true, z18);
                p0Var.u(z18);
                eVar5 = eVar4;
            } else {
                p0Var.Y();
                eVar5 = eVar2;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new l(str, job, job2, eVar5, cVar, i, i10);
            }
        }
        i11 |= MamiIdentity.RSA_BITS;
        eVar2 = eVar;
        if ((i10 & 16) != 0) {
            i11 |= 24576;
        } else if ((i & 24576) == 0) {
            if (p0Var.h(cVar)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i11 |= i12;
        }
        if ((i11 & 9363) == 9362) {
            if (i18 != 0) {
                eVar3 = null;
            } else {
                eVar3 = eVar2;
            }
            r0 r0Var2 = v0.f3474a;
            if (job == null) {
                z10 = false;
            } else {
                z10 = false;
            }
            if (job2 == null) {
                z11 = false;
            } else {
                z11 = false;
            }
            androidx.compose.ui.q qVar2 = androidx.compose.ui.q.f4604b;
            i13 = i11;
            eVar4 = eVar3;
            androidx.compose.ui.t tVarFrostedGlass2 = GlassKt.frostedGlass(f0.x(d3.e(qVar2, 1.0f), 16, 0.0f, 2), e0.e.b(12), false, false, p0Var, 6, 6);
            p0Var = p0Var;
            androidx.compose.ui.t tVarV2 = f0.v(tVarFrostedGlass2, 10);
            p0Var.e0(-483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            i14 = p0Var.N;
            w2 w2VarO3 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(tVarV2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar2 = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar2, k0VarA2);
            androidx.compose.ui.node.r rVar2 = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar2, w2VarO3);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i14, p0Var, i14, mVar);
            } else {
                w0.u(i14, p0Var, i14, mVar);
            }
            w0.x(p0Var, eVarM3, p0Var, 0, 2058660585);
            float f10 = 6;
            androidx.compose.foundation.layout.f fVarH3 = androidx.compose.foundation.layout.i.h(f10);
            androidx.compose.foundation.layout.f fVarH4 = androidx.compose.foundation.layout.i.h(f10);
            p0Var.e0(1098475987);
            k0 k0VarC2 = a1.c(fVarH3, fVarH4, p0Var);
            p0Var.e0(-1323940314);
            i15 = p0Var.N;
            w2 w2VarO4 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(qVar2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar2, k0VarC2);
            b1.Y(p0Var, rVar2, w2VarO4);
            if (p0Var.M) {
                w0.u(i15, p0Var, i15, mVar);
            } else {
                w0.u(i15, p0Var, i15, mVar);
            }
            w0.x(p0Var, eVarM4, p0Var, 0, 2058660585);
            e2Var = androidx.compose.runtime.n.f3284a;
            if (z10) {
                p0Var.e0(1086186590);
                String strTr5 = StoreNetKt.tr("توقف سنجش", "Stop the test");
                androidx.compose.ui.graphics.vector.f fVarY3 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                p0Var.e0(1086188605);
                objI5 = p0Var.I();
                if (objI5 == e2Var) {
                    objI5 = new r(6);
                    p0Var.r0(objI5);
                }
                p0Var.u(false);
                Btn(strTr5, false, false, fVarY3, (ee.a) objI5, p0Var, 24576, 6);
                p0Var.u(false);
            } else {
                p0Var.e0(-687836617);
                if (kotlin.jvm.internal.j.a(str, Psi.CrashTracebackLevelAll)) {
                    strJ = StoreNetKt.tr("سنجش همه", "Test all");
                } else {
                    strJ = g1.j("Test every ", kindOne(str), w0.n("سنجش همهٔ ", kindOne(str), "\u200cها"));
                }
                String str3 = strJ;
                androidx.compose.ui.graphics.vector.f fVarX2 = com.google.android.gms.internal.auth.j.x();
                p0Var.e0(1086195430);
                i16 = i13 & 57344;
                if (i16 == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                i17 = i13 & 14;
                if (i17 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z12 | z13;
                objI = p0Var.I();
                if (z14) {
                    objI = new w(1, str, cVar);
                    p0Var.r0(objI);
                } else {
                    objI = new w(1, str, cVar);
                    p0Var.r0(objI);
                }
                p0Var.u(false);
                Btn(str3, false, false, fVarX2, (ee.a) objI, p0Var, 0, 6);
                String strTr6 = StoreNetKt.tr("سنجش نسنجیده\u200cها", "Test the untested");
                p0Var.e0(1086201587);
                if (i16 == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (i17 == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z16 | z15;
                objI2 = p0Var.I();
                if (z17) {
                    objI2 = new w(2, str, cVar);
                    p0Var.r0(objI2);
                } else {
                    objI2 = new w(2, str, cVar);
                    p0Var.r0(objI2);
                }
                p0Var.u(false);
                Btn(strTr6, false, false, null, (ee.a) objI2, p0Var, 0, 14);
                p0Var.u(false);
            }
            if (z11) {
                p0Var.e0(1086206378);
                String strTr7 = StoreNetKt.tr("توقف به\u200cروزرسانی", "Stop the refresh");
                androidx.compose.ui.graphics.vector.f fVarY4 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                p0Var.e0(1086208703);
                objI4 = p0Var.I();
                if (objI4 == e2Var) {
                    objI4 = new r(10);
                    p0Var.r0(objI4);
                }
                p0Var.u(false);
                Btn(strTr7, false, false, fVarY4, (ee.a) objI4, p0Var, 24576, 6);
                p0Var.u(false);
            } else {
                p0Var.e0(1086210176);
                String strTr8 = StoreNetKt.tr("به\u200cروزرسانی پل\u200cها و فالکن\u200cها", "Refresh bridges and falcons");
                androidx.compose.ui.graphics.vector.f fVarE2 = x6.q.E();
                p0Var.e0(1086213307);
                objI3 = p0Var.I();
                if (objI3 == e2Var) {
                    objI3 = new r(11);
                    p0Var.r0(objI3);
                }
                p0Var.u(false);
                Btn(strTr8, false, false, fVarE2, (ee.a) objI3, p0Var, 24576, 6);
                p0Var.u(false);
            }
            p0Var.e0(1086214606);
            if (eVar4 != null) {
                eVar4.invoke(p0Var, Integer.valueOf((i13 >> 9) & 14));
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
            p0Var.e0(1855780325);
            if (z10) {
                kotlin.jvm.internal.j.b(job);
                JobLine(job.getDone(), job.getTotal(), progressWord(job), p0Var, 0);
            }
            p0Var.u(false);
            p0Var.e0(1855782778);
            if (z11) {
                kotlin.jvm.internal.j.b(job2);
                int done2 = job2.getDone();
                int total2 = job2.getTotal();
                String label2 = job2.getLabel();
                String strFa2 = fa(job2.getFound());
                if (kotlin.text.o.L0(job2.getVia())) {
                    strH = v0.a.h(" · از راه ", job2.getVia());
                } else {
                    strH = "";
                }
                String strK2 = g1.k(label2, " · ", strFa2, " مورد تازه", strH);
                if (kotlin.text.o.L0(job2.getVia())) {
                }
                z18 = false;
                JobLine(done2, total2, StoreNetKt.tr(strK2, job2.getLabel() + " · " + job2.getFound() + " new" + (kotlin.text.o.L0(job2.getVia()) ? "" : v0.a.h(" · via ", job2.getVia()))), p0Var, 0);
            } else {
                z18 = false;
            }
            w0.z(p0Var, z18, z18, true, z18);
            p0Var.u(z18);
            eVar5 = eVar4;
        } else {
            if (i18 != 0) {
                eVar3 = null;
            } else {
                eVar3 = eVar2;
            }
            r0 r0Var3 = v0.f3474a;
            if (job == null) {
                z10 = false;
            } else {
                z10 = false;
            }
            if (job2 == null) {
                z11 = false;
            } else {
                z11 = false;
            }
            androidx.compose.ui.q qVar3 = androidx.compose.ui.q.f4604b;
            i13 = i11;
            eVar4 = eVar3;
            androidx.compose.ui.t tVarFrostedGlass3 = GlassKt.frostedGlass(f0.x(d3.e(qVar3, 1.0f), 16, 0.0f, 2), e0.e.b(12), false, false, p0Var, 6, 6);
            p0Var = p0Var;
            androidx.compose.ui.t tVarV3 = f0.v(tVarFrostedGlass3, 10);
            p0Var.e0(-483455358);
            k0 k0VarA3 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            i14 = p0Var.N;
            w2 w2VarO5 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarV3);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar3 = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar3, k0VarA3);
            androidx.compose.ui.node.r rVar3 = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar3, w2VarO5);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i14, p0Var, i14, mVar);
            } else {
                w0.u(i14, p0Var, i14, mVar);
            }
            w0.x(p0Var, eVarM5, p0Var, 0, 2058660585);
            float f11 = 6;
            androidx.compose.foundation.layout.f fVarH5 = androidx.compose.foundation.layout.i.h(f11);
            androidx.compose.foundation.layout.f fVarH6 = androidx.compose.foundation.layout.i.h(f11);
            p0Var.e0(1098475987);
            k0 k0VarC3 = a1.c(fVarH5, fVarH6, p0Var);
            p0Var.e0(-1323940314);
            i15 = p0Var.N;
            w2 w2VarO6 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(qVar3);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar3, k0VarC3);
            b1.Y(p0Var, rVar3, w2VarO6);
            if (p0Var.M) {
                w0.u(i15, p0Var, i15, mVar);
            } else {
                w0.u(i15, p0Var, i15, mVar);
            }
            w0.x(p0Var, eVarM6, p0Var, 0, 2058660585);
            e2Var = androidx.compose.runtime.n.f3284a;
            if (z10) {
                p0Var.e0(1086186590);
                String strTr9 = StoreNetKt.tr("توقف سنجش", "Stop the test");
                androidx.compose.ui.graphics.vector.f fVarY5 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                p0Var.e0(1086188605);
                objI5 = p0Var.I();
                if (objI5 == e2Var) {
                    objI5 = new r(6);
                    p0Var.r0(objI5);
                }
                p0Var.u(false);
                Btn(strTr9, false, false, fVarY5, (ee.a) objI5, p0Var, 24576, 6);
                p0Var.u(false);
            } else {
                p0Var.e0(-687836617);
                if (kotlin.jvm.internal.j.a(str, Psi.CrashTracebackLevelAll)) {
                    strJ = StoreNetKt.tr("سنجش همه", "Test all");
                } else {
                    strJ = g1.j("Test every ", kindOne(str), w0.n("سنجش همهٔ ", kindOne(str), "\u200cها"));
                }
                String str4 = strJ;
                androidx.compose.ui.graphics.vector.f fVarX3 = com.google.android.gms.internal.auth.j.x();
                p0Var.e0(1086195430);
                i16 = i13 & 57344;
                if (i16 == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                i17 = i13 & 14;
                if (i17 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z12 | z13;
                objI = p0Var.I();
                if (z14) {
                    objI = new w(1, str, cVar);
                    p0Var.r0(objI);
                } else {
                    objI = new w(1, str, cVar);
                    p0Var.r0(objI);
                }
                p0Var.u(false);
                Btn(str4, false, false, fVarX3, (ee.a) objI, p0Var, 0, 6);
                String strTr10 = StoreNetKt.tr("سنجش نسنجیده\u200cها", "Test the untested");
                p0Var.e0(1086201587);
                if (i16 == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (i17 == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z16 | z15;
                objI2 = p0Var.I();
                if (z17) {
                    objI2 = new w(2, str, cVar);
                    p0Var.r0(objI2);
                } else {
                    objI2 = new w(2, str, cVar);
                    p0Var.r0(objI2);
                }
                p0Var.u(false);
                Btn(strTr10, false, false, null, (ee.a) objI2, p0Var, 0, 14);
                p0Var.u(false);
            }
            if (z11) {
                p0Var.e0(1086206378);
                String strTr11 = StoreNetKt.tr("توقف به\u200cروزرسانی", "Stop the refresh");
                androidx.compose.ui.graphics.vector.f fVarY6 = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.y();
                p0Var.e0(1086208703);
                objI4 = p0Var.I();
                if (objI4 == e2Var) {
                    objI4 = new r(10);
                    p0Var.r0(objI4);
                }
                p0Var.u(false);
                Btn(strTr11, false, false, fVarY6, (ee.a) objI4, p0Var, 24576, 6);
                p0Var.u(false);
            } else {
                p0Var.e0(1086210176);
                String strTr12 = StoreNetKt.tr("به\u200cروزرسانی پل\u200cها و فالکن\u200cها", "Refresh bridges and falcons");
                androidx.compose.ui.graphics.vector.f fVarE3 = x6.q.E();
                p0Var.e0(1086213307);
                objI3 = p0Var.I();
                if (objI3 == e2Var) {
                    objI3 = new r(11);
                    p0Var.r0(objI3);
                }
                p0Var.u(false);
                Btn(strTr12, false, false, fVarE3, (ee.a) objI3, p0Var, 24576, 6);
                p0Var.u(false);
            }
            p0Var.e0(1086214606);
            if (eVar4 != null) {
                eVar4.invoke(p0Var, Integer.valueOf((i13 >> 9) & 14));
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
            p0Var.e0(1855780325);
            if (z10) {
                kotlin.jvm.internal.j.b(job);
                JobLine(job.getDone(), job.getTotal(), progressWord(job), p0Var, 0);
            }
            p0Var.u(false);
            p0Var.e0(1855782778);
            if (z11) {
                kotlin.jvm.internal.j.b(job2);
                int done3 = job2.getDone();
                int total3 = job2.getTotal();
                String label3 = job2.getLabel();
                String strFa3 = fa(job2.getFound());
                if (kotlin.text.o.L0(job2.getVia())) {
                    strH = v0.a.h(" · از راه ", job2.getVia());
                } else {
                    strH = "";
                }
                String strK3 = g1.k(label3, " · ", strFa3, " مورد تازه", strH);
                if (kotlin.text.o.L0(job2.getVia())) {
                }
                z18 = false;
                JobLine(done3, total3, StoreNetKt.tr(strK3, job2.getLabel() + " · " + job2.getFound() + " new" + (kotlin.text.o.L0(job2.getVia()) ? "" : v0.a.h(" · via ", job2.getVia()))), p0Var, 0);
            } else {
                z18 = false;
            }
            w0.z(p0Var, z18, z18, true, z18);
            p0Var.u(z18);
            eVar5 = eVar4;
        }
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new l(str, job, job2, eVar5, cVar, i, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$72$lambda$71$lambda$60$lambda$59() {
        ArgoPool.INSTANCE.stopTest();
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$72$lambda$71$lambda$63$lambda$62(ee.c cVar, c1 c1Var, String str) {
        Object objM1004constructorimpl;
        sd.u uVar = sd.u.f67154a;
        try {
            ArgoPool.test$default(ArgoPool.INSTANCE, str, null, null, false, false, false, 62, null);
            objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
        }
        Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
        String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
        if (message == null) {
            message = "";
        }
        cVar.invoke(message);
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$72$lambda$71$lambda$66$lambda$65(ee.c cVar, c1 c1Var, String str) {
        Object objM1004constructorimpl;
        sd.u uVar = sd.u.f67154a;
        try {
            ArgoPool.test$default(ArgoPool.INSTANCE, str, null, null, true, false, false, 54, null);
            objM1004constructorimpl = sd.l.m1004constructorimpl(uVar);
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
        }
        Throwable thM1007exceptionOrNullimpl = sd.l.m1007exceptionOrNullimpl(objM1004constructorimpl);
        String message = thM1007exceptionOrNullimpl != null ? thM1007exceptionOrNullimpl.getMessage() : null;
        if (message == null) {
            message = "";
        }
        cVar.invoke(message);
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$72$lambda$71$lambda$68$lambda$67() {
        ArgoPool.INSTANCE.stopUpdate();
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$72$lambda$71$lambda$70$lambda$69() {
        ArgoPool.update$default(ArgoPool.INSTANCE, null, 1, null);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u TestCard$lambda$73(String str, ArgoPool.Job job, ArgoPool.Job job2, ee.e eVar, ee.c cVar, int i, int i10, androidx.compose.runtime.o oVar, int i11) {
        TestCard(str, job, job2, eVar, cVar, oVar, b1.b0(i | 1), i10);
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ago(long j) {
        if (j <= 0) {
            return "";
        }
        long jMax = Math.max(0L, Math.round((System.currentTimeMillis() - j) / 60000.0d));
        if (jMax < 1) {
            return StoreNetKt.tr("همین حالا", "just now");
        }
        if (jMax < 60) {
            return g1.h(jMax, " min ago", v0.a.p(fa(jMax), " دقیقه پیش"));
        }
        long jRound = Math.round(jMax / 60.0d);
        if (jRound < 48) {
            return g1.h(jRound, " h ago", v0.a.p(fa(jRound), " ساعت پیش"));
        }
        double d10 = jRound / 24.0d;
        return g1.h(Math.round(d10), " days ago", v0.a.p(fa(Math.round(d10)), " روز پیش"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String country(String str) {
        if (kotlin.text.o.L0(str) || kotlin.jvm.internal.j.a(str, "??")) {
            return StoreNetKt.tr("سنجیده\u200cنشده", "not tested");
        }
        String displayCountry = new Locale("", str).getDisplayCountry(Locale.getDefault());
        return kotlin.text.o.L0(displayCountry) ? str : displayCountry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dateWord(long j) {
        Object objM1004constructorimpl;
        if (j <= 0) {
            return "";
        }
        try {
            objM1004constructorimpl = sd.l.m1004constructorimpl(DateFormat.getDateInstance(3, kotlin.jvm.internal.j.a(Locale.getDefault().getLanguage(), GerehLocale.FA) ? new ULocale("fa_IR@calendar=persian") : ULocale.getDefault()).format(new Date(j)));
        } catch (Throwable th2) {
            objM1004constructorimpl = sd.l.m1004constructorimpl(sd.m.a(th2));
        }
        return (String) (sd.l.m1010isFailureimpl(objM1004constructorimpl) ? "" : objM1004constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fa(long j) {
        boolean zA = kotlin.jvm.internal.j.a(Locale.getDefault().getLanguage(), GerehLocale.FA);
        String strValueOf = String.valueOf(j);
        if (!zA) {
            return strValueOf;
        }
        ArrayList arrayList = new ArrayList(strValueOf.length());
        for (int i = 0; i < strValueOf.length(); i++) {
            char cCharAt = strValueOf.charAt(i);
            if ('0' <= cCharAt && cCharAt < ':') {
                cCharAt = (char) (cCharAt + 1728);
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        return kotlin.collections.q.F0(arrayList, "", null, null, null, 62);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String flag(String str) {
        if (str.length() != 2) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return "";
            }
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.j.d(upperCase, "toUpperCase(...)");
        ArrayList arrayList = new ArrayList(upperCase.length());
        for (int i10 = 0; i10 < upperCase.length(); i10++) {
            char[] chars = Character.toChars(upperCase.charAt(i10) - 3675);
            kotlin.jvm.internal.j.d(chars, "toChars(...)");
            arrayList.add(new String(chars));
        }
        return kotlin.collections.q.F0(arrayList, "", null, null, null, 62);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    public static final String kindAll(String str) {
        String str2;
        String str3;
        int iHashCode = str.hashCode();
        if (iHashCode != -1380801655) {
            if (iHashCode != -1281896239) {
                if (iHashCode == -977423767 && str.equals("public")) {
                    str2 = "سرور عمومی";
                    str3 = "Public servers";
                } else {
                    str2 = "همه";
                    str3 = "All";
                }
            } else if (str.equals("falcon")) {
                str2 = "فالکن";
                str3 = "Falcons";
            } else {
                str2 = "همه";
                str3 = "All";
            }
        } else if (str.equals("bridge")) {
            str2 = "پل";
            str3 = "Bridges";
        } else {
            str2 = "همه";
            str3 = "All";
        }
        return StoreNetKt.tr(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String kindOne(String str) {
        String str2;
        String str3 = "bridge";
        if (kotlin.jvm.internal.j.a(str, "bridge")) {
            str2 = "پل";
        } else {
            str3 = "falcon";
            if (kotlin.jvm.internal.j.a(str, "falcon")) {
                str2 = "فالکن";
            } else {
                str2 = "سرور عمومی";
                str3 = "public server";
            }
        }
        return StoreNetKt.tr(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long msTone(long j, androidx.compose.runtime.o oVar, int i) {
        long red;
        p0 p0Var = (p0) oVar;
        p0Var.e0(692496208);
        r0 r0Var = v0.f3474a;
        if (j < 700) {
            p0Var.e0(400773219);
            red = Ios.INSTANCE.getGreen(p0Var, 6);
        } else if (j < 1600) {
            p0Var.e0(400774180);
            red = Ios.INSTANCE.getOrange(p0Var, 6);
        } else {
            p0Var.e0(400774689);
            red = Ios.INSTANCE.getRed(p0Var, 6);
        }
        p0Var.u(false);
        p0Var.u(false);
        return red;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0076  */
    public static final String progressWord(ArgoPool.Job job) {
        String strTr;
        switch (job.getKind()) {
            case "verified":
                strTr = StoreNetKt.tr("تأییدشده\u200cها", "The verified ones");
                break;
            case "ids":
                strTr = StoreNetKt.tr("موارد انتخاب\u200cشده", "The chosen ones");
                break;
            case "kind":
                strTr = g1.j("Every ", kindOne(job.getWhat()), w0.n("همهٔ ", kindOne(job.getWhat()), "\u200cها"));
                break;
            case "country":
                strTr = StoreNetKt.tr(v0.a.h("موارد ", country(job.getCc())), String.valueOf(country(job.getCc())));
                break;
            default:
                strTr = StoreNetKt.tr("همه", "All");
                break;
        }
        return StoreNetKt.tr(d1.i(d1.k(strTr, ": ", fa(job.getDone()), " از ", fa(job.getTotal())), " سنجیده شد — ", fa(job.getAlive()), " سالم", job.getFrozen() > 0 ? w0.n(" · ", fa(job.getFrozen()), " وسط دانلود قطع شد") : ""), strTr + ": " + job.getDone() + " of " + job.getTotal() + " tested — " + job.getAlive() + " healthy" + (job.getFrozen() > 0 ? androidx.compose.foundation.interaction.f.o(job.getFrozen(), " · ", " cut part-way") : ""));
    }

    private static final ee.e rememberConnect(ee.a aVar, androidx.compose.runtime.o oVar, int i, int i10) {
        p0 p0Var = (p0) oVar;
        p0Var.e0(-1249974808);
        boolean z10 = true;
        int i11 = i10 & 1;
        e2 e2Var = androidx.compose.runtime.n.f3284a;
        if (i11 != 0) {
            p0Var.e0(-1389680615);
            Object objI = p0Var.I();
            if (objI == e2Var) {
                objI = new r(5);
                p0Var.r0(objI);
            }
            aVar = (ee.a) objI;
            p0Var.u(false);
        }
        r0 r0Var = v0.f3474a;
        Context context = (Context) p0Var.l(w1.f4590b);
        p0Var.e0(-1389677608);
        Object objI2 = p0Var.I();
        if (objI2 == e2Var) {
            objI2 = b1.N(new sd.j(null, null), e2.f3199e);
            p0Var.r0(objI2);
        }
        final k2 k2Var = (k2) objI2;
        boolean zD = com.mlmvpn.scanner.e.D(p0Var, false, -1389674651, context);
        if ((((i & 14) ^ 6) <= 4 || !p0Var.f(aVar)) && (i & 6) != 4) {
            z10 = false;
        }
        boolean z11 = zD | z10;
        Object objI3 = p0Var.I();
        if (z11 || objI3 == e2Var) {
            objI3 = new y(2, k2Var, context, aVar);
            p0Var.r0(objI3);
        }
        p0Var.u(false);
        final ee.a aVarVpnLauncher = vpnLauncher((ee.a) objI3, p0Var, 0);
        p0Var.e0(-1389671808);
        boolean zF = p0Var.f(aVarVpnLauncher);
        Object objI4 = p0Var.I();
        if (zF || objI4 == e2Var) {
            objI4 = new ee.e() { // from class: com.mlmvpn.scanner.ui.argo.e
                @Override // ee.e
                public final Object invoke(Object obj, Object obj2) {
                    return ArgoScreenKt.rememberConnect$lambda$33$lambda$32(aVarVpnLauncher, k2Var, (String) obj, (String) obj2);
                }
            };
            p0Var.r0(objI4);
        }
        ee.e eVar = (ee.e) objI4;
        p0Var.u(false);
        p0Var.u(false);
        return eVar;
    }

    private static final sd.j rememberConnect$lambda$28(k2 k2Var) {
        return (sd.j) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u rememberConnect$lambda$31$lambda$30(Context context, ee.a aVar, k2 k2Var) {
        ArgoEngine.connectAsync$default(ArgoEngine.INSTANCE, context, (String) rememberConnect$lambda$28(k2Var).getFirst(), (String) rememberConnect$lambda$28(k2Var).getSecond(), null, 8, null);
        aVar.invoke();
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u rememberConnect$lambda$33$lambda$32(ee.a aVar, k2 k2Var, String str, String str2) {
        k2Var.setValue(new sd.j(str, str2));
        aVar.invoke();
        return sd.u.f67154a;
    }

    private static final View viewOf(ArgoEngine.Conn conn, boolean z10, ArgoPool.Summary summary, ArgoPool.Job job) {
        String strTr;
        String strJ;
        String str;
        String str2;
        String strTr2;
        boolean z11 = job != null && job.getRunning();
        String strTr3 = "";
        if (conn instanceof ArgoEngine.Conn.Connecting) {
            ArgoEngine.Conn.Connecting connecting = (ArgoEngine.Conn.Connecting) conn;
            int i = WhenMappings.$EnumSwitchMapping$1[connecting.getStep().ordinal()];
            if (i == 1) {
                strTr2 = StoreNetKt.tr("احراز هویت با سرور آرگو…", "Authenticating with the Argo server…");
            } else if (i == 2) {
                strTr2 = StoreNetKt.tr("راه\u200cاندازی موتور با این سرور…", "Starting the engine…");
            } else if (i == 3) {
                strTr2 = StoreNetKt.tr("آزمون عبور داده از داخل سرور (درخواست واقعی HTTPS)…", "Checking real data through the server (HTTPS)…");
            } else {
                if (i != 4) {
                    throw new sd.h();
                }
                strTr2 = StoreNetKt.tr("روشن کردن مسیر انتخاب\u200cشده…", "Turning the chosen path on…");
            }
            if (connecting.getAttempt() > 1) {
                strTr3 = com.mlmvpn.core.aether.i.g(" (try ", connecting.getAttempt(), ")", w0.n(" (مورد ", fa(connecting.getAttempt()), ")"));
            }
            return new View(EngineTone.BUSY, StoreNetKt.tr("در حال اتصال…", "Connecting…"), f0.a.m(connecting.getHost(), " — ", strTr2, strTr3), true);
        }
        if (conn instanceof ArgoEngine.Conn.Stopping) {
            return new View(EngineTone.BUSY, StoreNetKt.tr("در حال قطع…", "Disconnecting…"), "", false);
        }
        boolean z12 = conn instanceof ArgoEngine.Conn.Connected;
        if (z12) {
            ArgoEngine.Conn.Connected connected = (ArgoEngine.Conn.Connected) conn;
            if (connected.getLost()) {
                return new View(EngineTone.BUSY, StoreNetKt.tr("سرور دیگر داده رد نمی\u200cکند", "The server no longer carries data"), StoreNetKt.tr(v0.a.p(connected.getHost(), " — دو آزمون پیاپی از داخل آن جواب نداد. دکمهٔ وسط قطع می\u200cکند؛ «اتصال دوباره» مورد سالم بعدی را امتحان می\u200cکند."), connected.getHost() + " — two checks in a row got no answer through it. The button disconnects; «Reconnect» tries the next healthy one."), true);
            }
        }
        if (!z12) {
            if (z10) {
                return new View(EngineTone.ON, StoreNetKt.tr("وصل", "Connected"), "", true);
            }
            if (z11) {
                EngineTone engineTone = EngineTone.BUSY;
                String strTr4 = StoreNetKt.tr("سنجش…", "Testing…");
                kotlin.jvm.internal.j.b(job);
                return new View(engineTone, strTr4, v0.a.p(progressWord(job), StoreNetKt.tr(". دکمهٔ وسط به سریع\u200cترینِ سالمِ تاکنون وصل می\u200cشود.", ". The button connects to the fastest healthy one so far.")), true);
            }
            ArgoPool.Counts counts = summary.getCounts();
            return new View(EngineTone.OFF, TITLE, StoreNetKt.tr(w0.r(d1.k(fa(counts.getBridge()), " پل، ", fa(counts.getFalcon()), " فالکن و ", fa(counts.getPublic())), " سرور عمومی آرگو. ", counts.getAlive() > 0 ? v0.a.p(fa(counts.getAlive()), " مورد روی همین اینترنت واقعاً داده رد کرده\u200cاند. یک ضربه: سریع\u200cترینِ سالم وصل می\u200cشود.") : "هنوز چیزی روی این اینترنت سنجیده نشده — یک ضربه تازه\u200cترین\u200cها را امتحان می\u200cکند، یا «سنجش» را بزنید."), counts.getBridge() + " bridges, " + counts.getFalcon() + " falcons and " + counts.getPublic() + " public Argo servers. " + (counts.getAlive() > 0 ? androidx.compose.foundation.interaction.f.n(counts.getAlive(), " really carried data on this network. One tap connects the fastest healthy one.") : "Nothing tested on this network yet — one tap tries the freshest, or tap «Test».")), true);
        }
        ArgoEngine.Conn.Connected connected2 = (ArgoEngine.Conn.Connected) conn;
        if (kotlin.text.o.L0(connected2.getExitCc()) || kotlin.jvm.internal.j.a(connected2.getExitCc(), "??")) {
            strTr = StoreNetKt.tr("وصل", TunnelVpnService.STATUS_CONNECTED);
        } else {
            strTr = g1.j("exit in ", country(connected2.getExitCc()), v0.a.h("خروج از ", country(connected2.getExitCc())));
        }
        if (kotlin.text.o.L0(connected2.getExitIp())) {
            strJ = "";
        } else {
            strJ = g1.j(" · IP ", connected2.getExitIp(), v0.a.h(" · آی\u200cپی ", connected2.getExitIp()));
        }
        if (connected2.getMs() > 0) {
            strTr3 = StoreNetKt.tr(w0.n(" · ", fa(connected2.getMs()), " میلی\u200cثانیه"), " · " + connected2.getMs() + " ms");
        }
        if (connected2.getMode() == ArgoEngine.Mode.TUNNEL) {
            str = "تونل کامل";
            str2 = "full tunnel";
        } else {
            str = "پراکسی";
            str2 = WarpIdRelay.VIA_PROXY;
        }
        String strTr5 = StoreNetKt.tr(str, str2);
        EngineTone engineTone2 = EngineTone.ON;
        String strJ2 = g1.j("Connected — ", kindOne(connected2.getKind()), v0.a.h("وصل — ", kindOne(connected2.getKind())));
        String strR = androidx.compose.foundation.interaction.f.r(" — ", strTr5, ". هر دقیقه یک درخواست واقعی از داخل سرور فرستاده می\u200cشود و هر ده دقیقه نشست با سرور تمدید می\u200cشود.", d1.k(connected2.getHost(), " · ", strTr, strJ, strTr3));
        StringBuilder sbK = d1.k(connected2.getHost(), " · ", strTr, strJ, strTr3);
        sbK.append(" — ");
        sbK.append(strTr5);
        sbK.append(". A real request goes through the server every minute and the session is renewed every ten minutes.");
        return new View(engineTone2, strJ2, StoreNetKt.tr(strR, sbK.toString()), true);
    }

    private static final ee.a vpnLauncher(ee.a aVar, androidx.compose.runtime.o oVar, int i) {
        p0 p0Var = (p0) oVar;
        p0Var.e0(-1628416707);
        r0 r0Var = v0.f3474a;
        Context context = (Context) p0Var.l(w1.f4590b);
        h0 h0Var = new h0(false);
        p0Var.e0(1500479450);
        int i10 = (i & 14) ^ 6;
        int i11 = 1;
        boolean z10 = (i10 > 4 && p0Var.f(aVar)) || (i & 6) == 4;
        Object objI = p0Var.I();
        e2 e2Var = androidx.compose.runtime.n.f3284a;
        if (z10 || objI == e2Var) {
            objI = new a0(aVar, 2);
            p0Var.r0(objI);
        }
        p0Var.u(false);
        androidx.activity.compose.n nVarC = com.google.android.gms.internal.mlkit_language_id_common.j.C(h0Var, (ee.c) objI, p0Var, 0);
        p0Var.e0(1500482467);
        boolean zH = ((i10 > 4 && p0Var.f(aVar)) || (i & 6) == 4) | p0Var.h(context) | p0Var.h(nVarC);
        Object objI2 = p0Var.I();
        if (zH || objI2 == e2Var) {
            objI2 = new f(context, nVarC, aVar, i11);
            p0Var.r0(objI2);
        }
        ee.a aVar2 = (ee.a) objI2;
        p0Var.u(false);
        p0Var.u(false);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u vpnLauncher$lambda$21$lambda$20(ee.a aVar, e.a res) {
        kotlin.jvm.internal.j.e(res, "res");
        if (res.f17738a == -1) {
            aVar.invoke();
        }
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u vpnLauncher$lambda$24$lambda$23(Context context, androidx.activity.compose.n nVar, ee.a aVar) {
        ScanGuard.INSTANCE.run(ScanGuard.Reason.CONNECT_VPN, new f(context, nVar, aVar, 0));
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sd.u vpnLauncher$lambda$24$lambda$23$lambda$22(Context context, androidx.activity.compose.n nVar, ee.a aVar) {
        Intent intentPrepare;
        try {
            intentPrepare = VpnService.prepare(context);
        } catch (Exception unused) {
            intentPrepare = null;
        }
        if (intentPrepare != null) {
            nVar.a(intentPrepare);
        } else {
            aVar.invoke();
        }
        return sd.u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String wordOf(ArgoEngine.Conn conn, View view) {
        if (view.getTone() == EngineTone.ON) {
            return StoreNetKt.tr("وصل است", TunnelVpnService.STATUS_CONNECTED);
        }
        if ((conn instanceof ArgoEngine.Conn.Connected) && ((ArgoEngine.Conn.Connected) conn).getLost()) {
            return StoreNetKt.tr("بی\u200cداده", "no data");
        }
        if (conn instanceof ArgoEngine.Conn.Connecting) {
            return StoreNetKt.tr("در حال اتصال", TunnelVpnService.STATUS_CONNECTING);
        }
        if (conn instanceof ArgoEngine.Conn.Stopping) {
            return StoreNetKt.tr("در حال قطع", "disconnecting");
        }
        return view.getTone() == EngineTone.BUSY ? StoreNetKt.tr("در حال سنجش", "testing") : StoreNetKt.tr("قطع", "off");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fa(int i) {
        return fa(i);
    }
}
