package com.mlmvpn.scanner.ui.mami;

import a6.w0;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.d3;
import androidx.compose.foundation.layout.f0;
import androidx.compose.material3.f5;
import androidx.compose.material3.k9;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.c3;
import androidx.compose.runtime.e2;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import androidx.compose.runtime.n;
import androidx.compose.runtime.o;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.r0;
import androidx.compose.runtime.r3;
import androidx.compose.runtime.v0;
import androidx.compose.runtime.w2;
import androidx.compose.ui.graphics.v;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.w1;
import androidx.compose.ui.semantics.g0;
import androidx.compose.ui.semantics.j0;
import androidx.compose.ui.t;
import androidx.compose.ui.text.font.w;
import androidx.fragment.app.h0;
import com.google.android.gms.internal.auth.p;
import com.google.android.gms.internal.play_billing.d2;
import com.mlmvpn.core.tunnel.TunnelVpnService;
import com.mlmvpn.core.warp.WarpIdRelay;
import com.mlmvpn.scanner.R;
import com.mlmvpn.scanner.data.ScanGuard;
import com.mlmvpn.scanner.engines.mami.MamiApi;
import com.mlmvpn.scanner.engines.mami.MamiEngine;
import com.mlmvpn.scanner.engines.mami.MamiIdentity;
import com.mlmvpn.scanner.store.StoreNetKt;
import com.mlmvpn.scanner.ui.EngineLiveKt;
import com.mlmvpn.scanner.ui.EngineTone;
import com.mlmvpn.scanner.ui.RouteChipsKt;
import com.mlmvpn.scanner.ui.g1;
import com.mlmvpn.scanner.ui.home.GlassKt;
import com.mlmvpn.scanner.ui.settings.Ios;
import com.mlmvpn.scanner.ui.settings.IosSettingsKt;
import com.mlmvpn.scanner.ui.settings.SettingsGroupScope;
import com.mlmvpn.scanner.ui.t2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.r;
import org.mlmvpn.chat.bridge.GerehLocale;
import org.telegram.ui.Cells.d1;
import sd.q;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
public final class MamiScreenKt {
    private static final Map<String, String> PROFILE_WORDS = d0.J(new sd.j("VXT", "XHTTP · TLS"), new sd.j("VXR", "XHTTP · Reality"), new sd.j("VRR", "Vision · Reality"), new sd.j("HY2", "Hysteria2"), new sd.j("VGR", "gRPC · Reality"));

    /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public static final class AnonymousClass4 implements ee.f {
        final /* synthetic */ ee.a $ask;
        final /* synthetic */ l4 $busy$delegate;
        final /* synthetic */ MamiEngine.CatalogInfo $cat;
        final /* synthetic */ MamiEngine.Method $chosen;
        final /* synthetic */ boolean $connecting;
        final /* synthetic */ Context $context;
        final /* synthetic */ MamiApi.Summary $control;
        final /* synthetic */ ee.c $go;
        final /* synthetic */ MamiEngine.HiveInfo $hive;
        final /* synthetic */ boolean $live;
        final /* synthetic */ boolean $lock;
        final /* synthetic */ List<MamiEngine.PlaceRow> $locs;
        final /* synthetic */ k2 $note$delegate;
        final /* synthetic */ MamiEngine.Prefs $prefs;
        final /* synthetic */ k2 $serverTarget$delegate;
        final /* synthetic */ k2 $showAllPlaces$delegate;
        final /* synthetic */ l4 $st$delegate;
        final /* synthetic */ EngineTone $tone;
        final /* synthetic */ String $word;

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$11, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass11 implements ee.f {
            final /* synthetic */ MamiEngine.CatalogInfo $cat;
            final /* synthetic */ ee.c $go;

            public AnonymousClass11(MamiEngine.CatalogInfo catalogInfo, ee.c cVar) {
                this.$cat = catalogInfo;
                this.$go = cVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$2$lambda$1(ee.c cVar) {
                cVar.invoke(Page.SERVERS);
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$4$lambda$3(ee.c cVar) {
                cVar.invoke(Page.DEVICE);
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$6$lambda$5(ee.c cVar) {
                cVar.invoke(Page.LOGS);
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x0151  */
            public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
                int i10;
                e2 e2Var;
                boolean zF;
                final ee.c cVar;
                Object objI;
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
                String strTr = StoreNetKt.tr("سرورهای فهرست", "The list's servers");
                androidx.compose.ui.graphics.vector.f fVarV = k6.a.v();
                Ios ios = Ios.INSTANCE;
                long blue = ios.getBlue(oVar, 6);
                MamiEngine.CatalogInfo catalogInfo = this.$cat;
                String strFa = catalogInfo != null ? MamiScreenKt.fa(catalogInfo.getServers()) : null;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(82741738);
                boolean zF2 = p0Var2.f(this.$go);
                final ee.c cVar2 = this.$go;
                Object objI2 = p0Var2.I();
                final int i11 = 0;
                e2 e2Var2 = n.f3284a;
                if (zF2 || objI2 == e2Var2) {
                    objI2 = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.i
                        @Override // ee.a
                        public final Object invoke() {
                            switch (i11) {
                                case 0:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$2$lambda$1(cVar2);
                                case 1:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$4$lambda$3(cVar2);
                                default:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$6$lambda$5(cVar2);
                            }
                        }
                    };
                    p0Var2.r0(objI2);
                }
                p0Var2.u(false);
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr, fVarV, blue, strFa, null, 0L, false, (ee.a) objI2, 0, oVar, 0, 368);
                int i12 = i10 & 14;
                SettingsGroup.Separator(oVar, i12);
                String strTr2 = StoreNetKt.tr("دستگاه و فهرست", "Device and list");
                androidx.compose.ui.graphics.vector.f fVarP = p.p();
                long indigo = ios.getIndigo(oVar, 6);
                p0Var2.e0(82747561);
                boolean zF3 = p0Var2.f(this.$go);
                final ee.c cVar3 = this.$go;
                Object objI3 = p0Var2.I();
                if (!zF3) {
                    e2Var = e2Var2;
                    if (objI3 == e2Var) {
                    }
                    p0Var2.u(false);
                    e2 e2Var3 = e2Var;
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr2, fVarP, indigo, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                    SettingsGroup.Separator(oVar, i12);
                    String strTr3 = StoreNetKt.tr("لاگ", "Log");
                    androidx.compose.ui.graphics.vector.f fVarU = x6.a.u();
                    long purple = ios.getPurple(oVar, 6);
                    p0Var2.e0(82752519);
                    zF = p0Var2.f(this.$go);
                    cVar = this.$go;
                    objI = p0Var2.I();
                    if (zF || objI == e2Var3) {
                        final int i13 = 2;
                        objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.i
                            @Override // ee.a
                            public final Object invoke() {
                                switch (i13) {
                                    case 0:
                                        return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$2$lambda$1(cVar);
                                    case 1:
                                        return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$4$lambda$3(cVar);
                                    default:
                                        return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$6$lambda$5(cVar);
                                }
                            }
                        };
                        p0Var2.r0(objI);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m863SettingsRowqhMrWXk(strTr3, fVarU, purple, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
                }
                e2Var = e2Var2;
                final int i14 = 1;
                objI3 = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.i
                    @Override // ee.a
                    public final Object invoke() {
                        switch (i14) {
                            case 0:
                                return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$2$lambda$1(cVar3);
                            case 1:
                                return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$4$lambda$3(cVar3);
                            default:
                                return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$6$lambda$5(cVar3);
                        }
                    }
                };
                p0Var2.r0(objI3);
                p0Var2.u(false);
                e2 e2Var4 = e2Var;
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr2, fVarP, indigo, null, null, 0L, false, (ee.a) objI3, 0, oVar, 0, 376);
                SettingsGroup.Separator(oVar, i12);
                String strTr4 = StoreNetKt.tr("لاگ", "Log");
                androidx.compose.ui.graphics.vector.f fVarU2 = x6.a.u();
                long purple2 = ios.getPurple(oVar, 6);
                p0Var2.e0(82752519);
                zF = p0Var2.f(this.$go);
                cVar = this.$go;
                objI = p0Var2.I();
                if (zF) {
                    final int i15 = 2;
                    objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.i
                        @Override // ee.a
                        public final Object invoke() {
                            switch (i15) {
                                case 0:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$2$lambda$1(cVar);
                                case 1:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$4$lambda$3(cVar);
                                default:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$6$lambda$5(cVar);
                            }
                        }
                    };
                    p0Var2.r0(objI);
                } else {
                    final int i16 = 2;
                    objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.i
                        @Override // ee.a
                        public final Object invoke() {
                            switch (i16) {
                                case 0:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$2$lambda$1(cVar);
                                case 1:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$4$lambda$3(cVar);
                                default:
                                    return MamiScreenKt.AnonymousClass4.AnonymousClass11.invoke$lambda$6$lambda$5(cVar);
                            }
                        }
                    };
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                IosSettingsKt.m863SettingsRowqhMrWXk(strTr4, fVarU2, purple2, null, null, 0L, false, (ee.a) objI, 0, oVar, 0, 376);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass3 implements ee.f {
            final /* synthetic */ ee.a $ask;
            final /* synthetic */ k2 $note$delegate;
            final /* synthetic */ List<q> $notes;
            final /* synthetic */ k2 $serverTarget$delegate;

            public AnonymousClass3(List<q> list, ee.a aVar, k2 k2Var, k2 k2Var2) {
                this.$notes = list;
                this.$ask = aVar;
                this.$serverTarget$delegate = k2Var;
                this.$note$delegate = k2Var2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$4$lambda$1$lambda$0(ee.a aVar, k2 k2Var) {
                MamiScreenKt.MamiMain$lambda$39(k2Var, null);
                aVar.invoke();
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$4$lambda$3$lambda$2(String str, k2 k2Var) {
                if (kotlin.jvm.internal.j.a(str, MamiScreenKt.MamiMain$lambda$47(k2Var))) {
                    MamiScreenKt.MamiMain$lambda$48(k2Var, "");
                } else {
                    MamiEngine.INSTANCE.clearError();
                }
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
            /* JADX WARN: Type inference failed for: r19v3 */
            /* JADX WARN: Type inference failed for: r2v14 */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.runtime.p0] */
            public final void invoke(SettingsGroupScope settingsGroupScope, o oVar, int i) {
                ?? r4;
                k2 k2Var;
                k2 k2Var2;
                ee.a aVar;
                SettingsGroupScope SettingsGroup = settingsGroupScope;
                o oVar2 = oVar;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                int i10 = (i & 6) == 0 ? i | ((i & 8) == 0 ? ((p0) oVar2).f(SettingsGroup) : ((p0) oVar2).h(SettingsGroup) ? 4 : 2) : i;
                if ((i10 & 19) == 18) {
                    p0 p0Var = (p0) oVar2;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                List<q> list = this.$notes;
                final ee.a aVar2 = this.$ask;
                final k2 k2Var3 = this.$serverTarget$delegate;
                k2 k2Var4 = this.$note$delegate;
                final ?? r8 = 0;
                int i11 = 0;
                for (Object obj : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        r.f0();
                        throw null;
                    }
                    q qVar = (q) obj;
                    long j = ((v) qVar.component1()).f3799a;
                    final String str = (String) qVar.component2();
                    boolean zBooleanValue = ((Boolean) qVar.component3()).booleanValue();
                    ?? r10 = (p0) oVar2;
                    r10.e0(82583116);
                    if (i11 > 0) {
                        SettingsGroup.Separator(oVar2, i10 & 14);
                    }
                    r10.u(r8);
                    e2 e2Var = n.f3284a;
                    if (zBooleanValue) {
                        r10.e0(-934476017);
                        String strL = f0.a.l(str, " ", StoreNetKt.tr("اتصال دوباره", "Reconnect"));
                        k2 k2Var5 = k2Var4;
                        androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                        r10.e0(-934472205);
                        boolean zF = r10.f(aVar2);
                        Object objI = r10.I();
                        Object obj2 = objI;
                        if (zF || objI == e2Var) {
                            ee.a aVar3 = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.j
                                @Override // ee.a
                                public final Object invoke() {
                                    switch (r8) {
                                        case 0:
                                            return MamiScreenKt.AnonymousClass4.AnonymousClass3.invoke$lambda$4$lambda$1$lambda$0((ee.a) aVar2, k2Var3);
                                        default:
                                            return MamiScreenKt.AnonymousClass4.AnonymousClass3.invoke$lambda$4$lambda$3$lambda$2((String) aVar2, k2Var3);
                                    }
                                }
                            };
                            r10.r0(aVar3);
                            obj2 = aVar3;
                        }
                        r10.u(r8);
                        r4 = r8 == true ? 1 : 0;
                        IosSettingsKt.m860SettingsActionRowXfSFWjk(strL, fVarE, j, null, false, false, false, (ee.a) obj2, oVar, 0, 120);
                        r10.u(r4);
                        k2Var = k2Var5;
                        k2Var2 = k2Var3;
                        aVar = aVar2;
                    } else {
                        r4 = r8;
                        ee.a aVar4 = aVar2;
                        k2 k2Var6 = k2Var3;
                        final k2 k2Var7 = k2Var4;
                        r10.e0(-934470274);
                        r10.e0(-934467919);
                        boolean zF2 = r10.f(str);
                        Object objI2 = r10.I();
                        Object obj3 = objI2;
                        if (zF2 || objI2 == e2Var) {
                            final int i13 = 1;
                            ee.a aVar5 = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.j
                                @Override // ee.a
                                public final Object invoke() {
                                    switch (i13) {
                                        case 0:
                                            return MamiScreenKt.AnonymousClass4.AnonymousClass3.invoke$lambda$4$lambda$1$lambda$0((ee.a) str, k2Var7);
                                        default:
                                            return MamiScreenKt.AnonymousClass4.AnonymousClass3.invoke$lambda$4$lambda$3$lambda$2((String) str, k2Var7);
                                    }
                                }
                            };
                            r10.r0(aVar5);
                            obj3 = aVar5;
                        }
                        r10.u(r4);
                        k2Var = k2Var7;
                        k2Var2 = k2Var6;
                        aVar = aVar4;
                        IosSettingsKt.m863SettingsRowqhMrWXk(str, null, 0L, null, null, j, false, (ee.a) obj3, 0, oVar, 1572864, 286);
                        r10.u(r4);
                    }
                    SettingsGroup = settingsGroupScope;
                    oVar2 = oVar;
                    r8 = r4;
                    i11 = i12;
                    aVar2 = aVar;
                    k2Var3 = k2Var2;
                    k2Var4 = k2Var;
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$4, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class C01444 implements ee.f {
            final /* synthetic */ boolean $lock;
            final /* synthetic */ MamiEngine.Prefs $prefs;

            public C01444(MamiEngine.Prefs prefs, boolean z10) {
                this.$prefs = prefs;
                this.$lock = z10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$2$lambda$1$lambda$0(MamiEngine.Method method) {
                MamiEngine.setPrefs$default(MamiEngine.INSTANCE, method.getKey(), null, null, 6, null);
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
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
                List<MamiEngine.Method> methods = MamiEngine.INSTANCE.getMETHODS();
                MamiEngine.Prefs prefs = this.$prefs;
                boolean z10 = this.$lock;
                int i11 = 0;
                int i12 = 0;
                for (Object obj : methods) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        r.f0();
                        throw null;
                    }
                    MamiEngine.Method method = (MamiEngine.Method) obj;
                    p0 p0Var2 = (p0) oVar;
                    p0Var2.e0(82602348);
                    if (i12 > 0) {
                        SettingsGroup.Separator(oVar, i10 & 14);
                    }
                    p0Var2.u(false);
                    boolean zA = kotlin.jvm.internal.j.a(prefs.getMethod(), method.getKey());
                    boolean z11 = !z10;
                    p0Var2.e0(-934455460);
                    boolean zF = p0Var2.f(method);
                    Object objI = p0Var2.I();
                    if (zF || objI == n.f3284a) {
                        objI = new k(method, i11);
                        p0Var2.r0(objI);
                    }
                    p0Var2.u(false);
                    MamiScreenKt.MethodRow(method, zA, z11, (ee.a) objI, oVar, 0);
                    i12 = i13;
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass5 implements ee.f {
            final /* synthetic */ boolean $lock;
            final /* synthetic */ List<MamiEngine.PlaceRow> $locs;
            final /* synthetic */ MamiEngine.Prefs $prefs;
            final /* synthetic */ k2 $showAllPlaces$delegate;

            public AnonymousClass5(MamiEngine.Prefs prefs, boolean z10, List<MamiEngine.PlaceRow> list, k2 k2Var) {
                this.$prefs = prefs;
                this.$lock = z10;
                this.$locs = list;
                this.$showAllPlaces$delegate = k2Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$1$lambda$0() {
                MamiEngine.setPrefs$default(MamiEngine.INSTANCE, null, null, "", 3, null);
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$4$lambda$3$lambda$2(MamiEngine.PlaceRow placeRow) {
                MamiEngine.setPrefs$default(MamiEngine.INSTANCE, null, null, placeRow.getId(), 3, null);
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$6$lambda$5(k2 k2Var) {
                MamiScreenKt.MamiMain$lambda$45(k2Var, true);
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
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
                String strTr = StoreNetKt.tr("خودکار", "Automatic");
                String strTr2 = StoreNetKt.tr("مکانِ سرورِ سریع\u200cتر", "the faster server's own place");
                boolean zL0 = kotlin.text.o.L0(this.$prefs.getLocation());
                boolean z10 = !this.$lock;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(82628700);
                Object objI = p0Var2.I();
                Object obj = n.f3284a;
                int i11 = 0;
                if (objI == obj) {
                    objI = new l(i11);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                MamiScreenKt.PlaceRow(strTr, strTr2, "", zL0, z10, (ee.a) objI, oVar, 196992);
                List<MamiEngine.PlaceRow> listE1 = (MamiScreenKt.MamiMain$lambda$44(this.$showAllPlaces$delegate) || this.$locs.size() <= 8) ? this.$locs : kotlin.collections.q.e1(this.$locs, 8);
                p0Var2.e0(82633727);
                MamiEngine.Prefs prefs = this.$prefs;
                boolean z11 = this.$lock;
                for (MamiEngine.PlaceRow placeRow : listE1) {
                    SettingsGroup.Separator(oVar, i10 & 14);
                    String strL = f0.a.l(MamiScreenKt.flag(placeRow.getCc()), "  ", placeRow.getCountry());
                    String strP = v0.a.p(placeRow.getCity(), placeRow.getServers() > 0 ? com.mlmvpn.core.aether.i.g(" · ", placeRow.getServers(), " servers", w0.n(" · ", MamiScreenKt.fa(placeRow.getServers()), " سرور")) : "");
                    boolean z12 = z11;
                    String cc2 = placeRow.getCc();
                    boolean zA = kotlin.jvm.internal.j.a(prefs.getLocation(), placeRow.getId());
                    MamiEngine.Prefs prefs2 = prefs;
                    boolean z13 = !z12;
                    p0Var2.e0(-934420003);
                    boolean zF = p0Var2.f(placeRow);
                    Object objI2 = p0Var2.I();
                    if (zF || objI2 == obj) {
                        objI2 = new k(placeRow, 1);
                        p0Var2.r0(objI2);
                    }
                    p0Var2.u(false);
                    MamiScreenKt.PlaceRow(strL, strP, cc2, zA, z13, (ee.a) objI2, oVar, 0);
                    z11 = z12;
                    prefs = prefs2;
                    i11 = 0;
                }
                p0Var2.u(i11);
                if (!MamiScreenKt.MamiMain$lambda$44(this.$showAllPlaces$delegate) && this.$locs.size() > 8) {
                    SettingsGroup.Separator(oVar, i10 & 14);
                    String strG = com.mlmvpn.core.aether.i.g("All ", this.$locs.size(), " places", w0.n("همهٔ ", MamiScreenKt.fa(this.$locs.size()), " مکان"));
                    androidx.compose.ui.graphics.vector.f fVarV = k6.a.v();
                    long blue = Ios.INSTANCE.getBlue(oVar, 6);
                    p0Var2.e0(82650990);
                    boolean zF2 = p0Var2.f(this.$showAllPlaces$delegate);
                    k2 k2Var = this.$showAllPlaces$delegate;
                    Object objI3 = p0Var2.I();
                    if (zF2 || objI3 == obj) {
                        objI3 = new f(3, k2Var);
                        p0Var2.r0(objI3);
                    }
                    p0Var2.u(false);
                    IosSettingsKt.m860SettingsActionRowXfSFWjk(strG, fVarV, blue, null, false, false, false, (ee.a) objI3, oVar, 0, 120);
                }
                r0 r0Var2 = v0.f3474a;
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass7 implements ee.f {
            final /* synthetic */ l4 $busy$delegate;
            final /* synthetic */ MamiEngine.CatalogInfo $cat;
            final /* synthetic */ boolean $connecting;
            final /* synthetic */ Context $context;

            public AnonymousClass7(boolean z10, Context context, MamiEngine.CatalogInfo catalogInfo, l4 l4Var) {
                this.$connecting = z10;
                this.$context = context;
                this.$cat = catalogInfo;
                this.$busy$delegate = l4Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$1$lambda$0(Context context) {
                MamiEngine.INSTANCE.refreshAsync(context, "catalog");
                return u.f67154a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$3$lambda$2(Context context) {
                MamiEngine.INSTANCE.measureAllAsync(context);
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
                int i10;
                String str;
                String str2;
                String str3;
                String str4;
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
                if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "catalog")) {
                    str = "در حال گرفتن…";
                    str2 = "Fetching…";
                } else {
                    str = "به\u200cروزرسانی فهرست";
                    str2 = "Refresh the list";
                }
                String strTr = StoreNetKt.tr(str, str2);
                androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                Ios ios = Ios.INSTANCE;
                long blue = ios.getBlue(oVar, 6);
                boolean zA = kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "catalog");
                int i11 = 0;
                boolean z10 = (MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate).length() == 0) && !this.$connecting;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(82679589);
                boolean zH = p0Var2.h(this.$context);
                Context context = this.$context;
                Object objI = p0Var2.I();
                e2 e2Var = n.f3284a;
                if (zH || objI == e2Var) {
                    objI = new m(context, i11);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr, fVarE, blue, null, zA, z10, false, (ee.a) objI, oVar, 0, 72);
                SettingsGroup.Separator(oVar, i10 & 14);
                if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "measure")) {
                    str3 = "در حال سنجش…";
                    str4 = "Measuring…";
                } else {
                    str3 = "سنجش سرورها";
                    str4 = "Measure the servers";
                }
                String strTr2 = StoreNetKt.tr(str3, str4);
                androidx.compose.ui.graphics.vector.f fVarY = hb.a.y();
                long green = ios.getGreen(oVar, 6);
                boolean zA2 = kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "measure");
                boolean z11 = (!(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate).length() == 0) || this.$connecting || this.$cat == null) ? false : true;
                p0Var2.e0(82691709);
                boolean zH2 = p0Var2.h(this.$context);
                Context context2 = this.$context;
                Object objI2 = p0Var2.I();
                if (zH2 || objI2 == e2Var) {
                    objI2 = new m(context2, 1);
                    p0Var2.r0(objI2);
                }
                p0Var2.u(false);
                IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr2, fVarY, green, null, zA2, z11, false, (ee.a) objI2, oVar, 0, 72);
            }
        }

        /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$4$9, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
        public static final class AnonymousClass9 implements ee.f {
            final /* synthetic */ l4 $busy$delegate;
            final /* synthetic */ boolean $connecting;
            final /* synthetic */ Context $context;

            public AnonymousClass9(boolean z10, Context context, l4 l4Var) {
                this.$connecting = z10;
                this.$context = context;
                this.$busy$delegate = l4Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final u invoke$lambda$1$lambda$0(Context context) {
                MamiEngine.INSTANCE.refreshAsync(context, "hive");
                return u.f67154a;
            }

            @Override // ee.f
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                return u.f67154a;
            }

            public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
                String str;
                String str2;
                kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                if ((i & 17) == 16) {
                    p0 p0Var = (p0) oVar;
                    if (p0Var.G()) {
                        p0Var.Y();
                        return;
                    }
                }
                r0 r0Var = v0.f3474a;
                if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "hive")) {
                    str = "در حال گرفتن…";
                    str2 = "Fetching…";
                } else {
                    str = "به\u200cروزرسانی پل\u200cها";
                    str2 = "Refresh the bridges";
                }
                String strTr = StoreNetKt.tr(str, str2);
                androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                long pink = Ios.INSTANCE.getPink(oVar, 6);
                boolean zA = kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "hive");
                boolean z10 = MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate).length() == 0 && !this.$connecting;
                p0 p0Var2 = (p0) oVar;
                p0Var2.e0(82718146);
                boolean zH = p0Var2.h(this.$context);
                Context context = this.$context;
                Object objI = p0Var2.I();
                if (zH || objI == n.f3284a) {
                    objI = new m(context, 2);
                    p0Var2.r0(objI);
                }
                p0Var2.u(false);
                IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr, fVarE, pink, null, zA, z10, false, (ee.a) objI, oVar, 0, 72);
            }
        }

        public AnonymousClass4(EngineTone engineTone, String str, boolean z10, boolean z11, l4 l4Var, Context context, ee.a aVar, MamiEngine.Method method, MamiEngine.Prefs prefs, MamiEngine.CatalogInfo catalogInfo, MamiEngine.HiveInfo hiveInfo, List<MamiEngine.PlaceRow> list, boolean z12, MamiApi.Summary summary, k2 k2Var, l4 l4Var2, k2 k2Var2, k2 k2Var3, ee.c cVar) {
            this.$tone = engineTone;
            this.$word = str;
            this.$connecting = z10;
            this.$live = z11;
            this.$st$delegate = l4Var;
            this.$context = context;
            this.$ask = aVar;
            this.$chosen = method;
            this.$prefs = prefs;
            this.$cat = catalogInfo;
            this.$hive = hiveInfo;
            this.$locs = list;
            this.$lock = z12;
            this.$control = summary;
            this.$serverTarget$delegate = k2Var;
            this.$busy$delegate = l4Var2;
            this.$note$delegate = k2Var2;
            this.$showAllPlaces$delegate = k2Var3;
            this.$go = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final u invoke$lambda$1$lambda$0(boolean z10, boolean z11, Context context, ee.a aVar, l4 l4Var, k2 k2Var) {
            if (z10 || z11 || kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "stopping")) {
                MamiEngine.INSTANCE.disconnectAsync(context);
            } else {
                MamiScreenKt.MamiMain$lambda$39(k2Var, null);
                aVar.invoke();
            }
            return u.f67154a;
        }

        @Override // ee.f
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((androidx.compose.foundation.layout.d0) obj, (o) obj2, ((Number) obj3).intValue());
            return u.f67154a;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x05dc  */
        /* JADX WARN: Code duplicated, block: B:103:0x0608  */
        /* JADX WARN: Code duplicated, block: B:106:0x063b  */
        /* JADX WARN: Code duplicated, block: B:107:0x0644  */
        /* JADX WARN: Code duplicated, block: B:111:0x0660  */
        /* JADX WARN: Code duplicated, block: B:113:0x066d  */
        /* JADX WARN: Code duplicated, block: B:115:0x0687  */
        /* JADX WARN: Code duplicated, block: B:118:0x06b5  */
        /* JADX WARN: Code duplicated, block: B:120:0x06c3  */
        /* JADX WARN: Code duplicated, block: B:121:0x06d4  */
        /* JADX WARN: Code duplicated, block: B:124:0x06ef  */
        /* JADX WARN: Code duplicated, block: B:45:0x0289  */
        /* JADX WARN: Code duplicated, block: B:47:0x02c6  */
        /* JADX WARN: Code duplicated, block: B:48:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:53:0x02eb  */
        /* JADX WARN: Code duplicated, block: B:55:0x0381  */
        /* JADX WARN: Code duplicated, block: B:61:0x03d6  */
        /* JADX WARN: Code duplicated, block: B:78:0x0474  */
        /* JADX WARN: Code duplicated, block: B:80:0x047e  */
        /* JADX WARN: Code duplicated, block: B:84:0x04a5  */
        /* JADX WARN: Code duplicated, block: B:87:0x04da  */
        /* JADX WARN: Code duplicated, block: B:88:0x0501  */
        /* JADX WARN: Code duplicated, block: B:91:0x053c  */
        /* JADX WARN: Code duplicated, block: B:92:0x0546  */
        /* JADX WARN: Code duplicated, block: B:95:0x0567  */
        /* JADX WARN: Code duplicated, block: B:97:0x05b9  */
        /* JADX WARN: Code duplicated, block: B:98:0x05c3  */
        /* JADX WARN: Instruction removed from duplicated block: B:101:0x05dc, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v11 */
        /* JADX WARN: Type inference failed for: r13v15 */
        /* JADX WARN: Type inference failed for: r13v7, types: [boolean, int] */
        public final void invoke(androidx.compose.foundation.layout.d0 IosScreen, o oVar, int i) {
            float f8;
            boolean z10;
            String strTr;
            String str;
            p0 p0Var;
            androidx.compose.ui.q qVar;
            Object obj;
            Ios ios;
            ?? r13;
            k2 k2Var;
            l4 l4Var;
            td.b bVarJ;
            Ios ios2;
            int i10;
            List<Object> listBuild;
            androidx.compose.ui.q qVar2;
            String strTr2;
            MamiEngine.HiveInfo hiveInfo;
            String strTr3;
            MamiEngine.HiveInfo hiveInfo2;
            String strI;
            String strN;
            String strTr4;
            MamiEngine.CatalogInfo catalogInfo;
            String strH;
            String strTr5;
            String str2;
            String str3;
            String error;
            int iE;
            l0 l0Var;
            androidx.compose.ui.node.m mVar;
            kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
            if ((i & 17) == 16) {
                p0 p0Var2 = (p0) oVar;
                if (p0Var2.G()) {
                    p0Var2.Y();
                    return;
                }
            }
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.q qVar3 = androidx.compose.ui.q.f4604b;
            f0.e(oVar, d3.g(qVar3, 12));
            EngineLiveKt.EngineIdent(R.drawable.ic_app_mami, MamiScreenKt.getTITLE(), this.$tone, this.$word, oVar, 0);
            float f10 = 24;
            f0.e(oVar, d3.g(qVar3, f10));
            boolean zA = kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase(), "on");
            boolean z11 = this.$connecting || kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase(), "stopping") || kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getPhase(), "lost");
            boolean z12 = this.$connecting;
            p0 p0Var3 = (p0) oVar;
            p0Var3.e0(1309117608);
            boolean zG = p0Var3.g(this.$connecting) | p0Var3.g(this.$live) | p0Var3.f(this.$st$delegate) | p0Var3.h(this.$context) | p0Var3.f(this.$ask);
            final boolean z13 = this.$connecting;
            final boolean z14 = this.$live;
            final Context context = this.$context;
            final ee.a aVar = this.$ask;
            final l4 l4Var2 = this.$st$delegate;
            final k2 k2Var2 = this.$serverTarget$delegate;
            Object objI = p0Var3.I();
            if (zG || objI == n.f3284a) {
                objI = new ee.a() { // from class: com.mlmvpn.scanner.ui.mami.h
                    @Override // ee.a
                    public final Object invoke() {
                        return MamiScreenKt.AnonymousClass4.invoke$lambda$1$lambda$0(z13, z14, context, aVar, l4Var2, k2Var2);
                    }
                };
                p0Var3.r0(objI);
            }
            p0Var3.u(false);
            MamiScreenKt.PowerButton(zA, z11, z12, (ee.a) objI, oVar, 0, 0);
            float f11 = 14;
            f0.e(oVar, d3.g(qVar3, f11));
            String strHeadLine = MamiScreenKt.headLine(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate), this.$chosen);
            Ios ios3 = Ios.INSTANCE;
            k9.b(strHeadLine, f0.x(d3.e(qVar3, 1.0f), f10, 0.0f, 2), ios3.getLabel(oVar, 6), x6.a.t(16), null, w.f4817h, null, 0L, null, new androidx.compose.ui.text.style.l(3), 0L, 0, false, 0, 0, null, null, oVar, 199728, 0, 130512);
            f0.e(oVar, d3.g(qVar3, 4));
            k9.b(MamiScreenKt.statusLine(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate), this.$chosen, this.$prefs, this.$cat, this.$hive, this.$locs), f0.x(d3.e(qVar3, 1.0f), f10, 0.0f, 2), ios3.getSecondaryLabel(oVar, 6), x6.a.s(13.5d), null, null, null, 0L, null, new androidx.compose.ui.text.style.l(3), 0L, 0, false, 0, 0, null, null, oVar, 3120, 0, 130544);
            o oVar2 = oVar;
            p0Var3.e0(1309138220);
            if (this.$live) {
                f8 = f11;
                f0.e(oVar2, d3.g(qVar3, f8));
                z10 = false;
                EngineLiveKt.EngineLiveStrip(oVar2, 0);
            } else {
                f8 = f11;
                z10 = false;
            }
            p0Var3.u(z10);
            RouteChipsKt.RouteChips(null, oVar2, z10 ? 1 : 0, 1);
            if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "measure") || (this.$connecting && kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(this.$st$delegate).getStep(), "scout"))) {
                strTr = StoreNetKt.tr("هر سرور با یک درخواست واقعی سنجیده می\u200cشود (تا نیم دقیقه)…", "Each server is measured with a real request (up to half a minute)…");
            } else {
                if (!kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "catalog")) {
                    if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate), "hive")) {
                        strTr = StoreNetKt.tr("گرفتن فهرست پل\u200cهای لیون…", "Fetching Lion's bridges…");
                    } else {
                        str = "";
                    }
                    p0Var3.e0(1309160851);
                    if (kotlin.text.o.L0(str)) {
                        p0Var = p0Var3;
                        qVar = qVar3;
                        obj = "hive";
                        ios = ios3;
                        r13 = z10;
                    } else {
                        float f12 = 8;
                        t tVarX = f0.x(com.mlmvpn.scanner.e.c(qVar3, f12, oVar2, qVar3, 1.0f), f10, 0.0f, 2);
                        androidx.compose.foundation.layout.c cVar = androidx.compose.foundation.layout.i.f2026e;
                        androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
                        p0Var3.e0(693286680);
                        k0 k0VarA = a3.a(cVar, iVar, oVar2);
                        p0Var3.e0(-1323940314);
                        iE = b1.E(oVar2);
                        w2 w2VarO = p0Var3.o();
                        androidx.compose.ui.node.u.i.getClass();
                        l0Var = androidx.compose.ui.node.t.f4279b;
                        androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarX);
                        p0Var3.h0();
                        if (p0Var3.M) {
                            p0Var3.n(l0Var);
                        } else {
                            p0Var3.t0();
                        }
                        b1.Y(oVar2, androidx.compose.ui.node.t.f4283f, k0VarA);
                        b1.Y(oVar2, androidx.compose.ui.node.t.f4282e, w2VarO);
                        mVar = androidx.compose.ui.node.t.i;
                        if (p0Var3.M || !kotlin.jvm.internal.j.a(p0Var3.I(), Integer.valueOf(iE))) {
                            w0.u(iE, p0Var3, iE, mVar);
                        }
                        eVarM.invoke(new r3(oVar2), oVar2, Integer.valueOf(z10 ? 1 : 0));
                        p0Var3.e0(2058660585);
                        f5.b(2, 0, 390, 24, ios3.getBlue(oVar2, 6), 0L, oVar, d3.m(qVar3, f8));
                        f0.e(oVar, d3.p(qVar3, f12));
                        obj = "hive";
                        qVar = qVar3;
                        p0 p0Var4 = p0Var3;
                        ios = ios3;
                        k9.b(str, null, ios3.getSecondaryLabel(oVar, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                        oVar2 = oVar;
                        r13 = 0;
                        w0.z(p0Var4, false, true, false, false);
                        p0Var = p0Var4;
                    }
                    p0Var.u(r13);
                    p0Var.e0(1309181426);
                    k2Var = this.$note$delegate;
                    l4Var = this.$st$delegate;
                    bVarJ = m9.d.j();
                    p0Var.e0(1309181549);
                    if (!kotlin.text.o.L0(MamiScreenKt.MamiMain$lambda$47(k2Var)) || kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), TunnelVpnService.STATUS_CONNECTING)) {
                        ios2 = ios;
                        i10 = 6;
                    } else {
                        ios2 = ios;
                        i10 = 6;
                        bVarJ.add(new q(new v(ios2.getGreen(oVar2, 6)), MamiScreenKt.MamiMain$lambda$47(k2Var), Boolean.FALSE));
                    }
                    p0Var.u(r13);
                    p0Var.e0(1309184722);
                    if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "off") && (error = MamiScreenKt.MamiMain$lambda$29(l4Var).getError()) != null && !kotlin.text.o.L0(error)) {
                        v vVar = new v(ios2.getRed(oVar2, i10));
                        String error2 = MamiScreenKt.MamiMain$lambda$29(l4Var).getError();
                        kotlin.jvm.internal.j.b(error2);
                        bVarJ.add(new q(vVar, error2, Boolean.FALSE));
                    }
                    p0Var.u(r13);
                    p0Var.e0(1309188318);
                    if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "off") && (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getLastWhy(), "replaced") || kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getLastWhy(), "stopped"))) {
                        v vVar2 = new v(ios2.getOrange(oVar2, i10));
                        if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getLastWhy(), "replaced")) {
                            str2 = "اتصال دیگری موتور را گرفت؛ مامی کنار رفت.";
                            str3 = "Another connection took the engine; Mami stepped aside.";
                        } else {
                            str2 = "موتور متوقف شد؛ اتصال مامی تمام شد.";
                            str3 = "The engine stopped; Mami's connection ended.";
                        }
                        bVarJ.add(new q(vVar2, StoreNetKt.tr(str2, str3), Boolean.FALSE));
                    }
                    p0Var.u(r13);
                    p0Var.e0(1309199985);
                    if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "lost")) {
                        bVarJ.add(new q(new v(ios2.getOrange(oVar2, i10)), StoreNetKt.tr("اتصال فعلی جواب نمی\u200cدهد.", "The connection stopped answering."), Boolean.TRUE));
                    }
                    p0Var.u(r13);
                    listBuild = bVarJ.build();
                    p0Var.u(r13);
                    p0Var.e0(1309204977);
                    if (listBuild.isEmpty()) {
                        qVar2 = qVar;
                    } else {
                        qVar2 = qVar;
                        f0.e(oVar2, d3.g(qVar2, 8));
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 426746717, new AnonymousClass3(listBuild, this.$ask, this.$serverTarget$delegate, this.$note$delegate)), oVar2, 384, 3);
                    }
                    p0Var.u(r13);
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("روش اتصال", "Method"), " — ", MamiScreenKt.methodName(this.$chosen)), 0.0f, oVar2, r13, 2);
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -207770224, new C01444(this.$prefs, this.$lock)), oVar2, 384, 3);
                    if (this.$lock) {
                        strTr2 = StoreNetKt.tr("برای عوض کردن روش اول قطع کنید.", "Disconnect first to change the method.");
                    } else {
                        strTr2 = StoreNetKt.tr("«خودکار» از فهرست سرورهای مامی بهترین را انتخاب می\u200cکند؛ اگر یک روش وصل نشد، روش دیگری را امتحان کنید.", "«Auto» picks the best of Mami's servers; if a method does not connect, try another.");
                    }
                    IosSettingsKt.SettingsFooter(strTr2, oVar2, r13);
                    p0Var.e0(1309248181);
                    if (kotlin.jvm.internal.j.a(this.$chosen.getKey(), "auto")) {
                        IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("مکان", "Place"), " — ", com.mlmvpn.core.aether.i.e(this.$locs.size(), " places", v0.a.p(MamiScreenKt.fa(this.$locs.size()), " مکان"))), 0.0f, oVar2, r13, 2);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 595890492, new AnonymousClass5(this.$prefs, this.$lock, this.$locs, this.$showAllPlaces$delegate)), oVar2, 384, 3);
                        if (this.$locs.isEmpty()) {
                            strTr4 = StoreNetKt.tr("بعد از اولین دریافت فهرست، مکان\u200cها اینجا می\u200cآیند.", "Places appear here after the first list is fetched.");
                        } else {
                            strTr4 = StoreNetKt.tr("مکان جایی است که ترافیک از آن بیرون می\u200cآید؛ سرورِ ورود را همچنان سنجش انتخاب می\u200cکند.", "The place is where traffic comes out; the way in is still chosen by the test.");
                        }
                        IosSettingsKt.SettingsFooter(strTr4, oVar2, r13);
                        String strTr6 = StoreNetKt.tr("فهرست سرورها", "Server list");
                        catalogInfo = this.$cat;
                        if (catalogInfo != null) {
                            strH = v0.a.h(" — ", StoreNetKt.tr(v0.a.h("ویرایش ", MamiScreenKt.fa(catalogInfo.getRevision())), "revision " + catalogInfo.getRevision()));
                            if (strH == null) {
                                strH = "";
                            }
                        } else {
                            strH = "";
                        }
                        IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(v0.a.p(strTr6, strH), 0.0f, oVar2, r13, 2);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -206076507, new AnonymousClass7(this.$connecting, this.$context, this.$cat, this.$busy$delegate)), oVar2, 384, 3);
                        String strCatalogLine = MamiScreenKt.catalogLine(this.$cat);
                        if (this.$control.getRegistered()) {
                            strTr5 = "";
                        } else {
                            strTr5 = StoreNetKt.tr(" اولین دریافت فهرست، این دستگاه را به\u200cصورت ناشناس روی سرور مامی ثبت می\u200cکند.", " The first fetch registers this device anonymously with Mami's server.");
                        }
                        com.mlmvpn.scanner.e.x(strCatalogLine, strTr5, oVar2, r13);
                    }
                    p0Var.u(r13);
                    p0Var.e0(1309329769);
                    if (kotlin.jvm.internal.j.a(this.$chosen.getKey(), obj)) {
                        String strTr7 = StoreNetKt.tr("پل\u200cهای لیون", "Lion's bridges");
                        hiveInfo = this.$hive;
                        if (hiveInfo != null) {
                            strTr3 = com.mlmvpn.core.aether.i.e(hiveInfo.getServers(), " bridges", v0.a.p(MamiScreenKt.fa(hiveInfo.getServers()), " پل"));
                            if (strTr3 == null) {
                                strTr3 = StoreNetKt.tr("خالی", "empty");
                            }
                        } else {
                            strTr3 = StoreNetKt.tr("خالی", "empty");
                        }
                        IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(strTr7, " — ", strTr3), 0.0f, oVar2, r13, 2);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 765034267, new AnonymousClass9(this.$connecting, this.$context, this.$busy$delegate)), oVar2, 384, 3);
                        hiveInfo2 = this.$hive;
                        if (hiveInfo2 != null) {
                            String strWhenWord = MamiScreenKt.whenWord(hiveInfo2.getFetchedAt());
                            if (hiveInfo2.getSkipped() > 0) {
                                strN = w0.n(" · ", MamiScreenKt.fa(hiveInfo2.getSkipped()), " پل نامعتبر کنار گذاشته شد");
                            } else {
                                strN = "";
                            }
                            strI = com.mlmvpn.core.aether.i.i("Fetched ", MamiScreenKt.whenWord(hiveInfo2.getFetchedAt()), ". ", d1.g("گرفته\u200cشده ", strWhenWord, strN, ". "));
                            if (strI == null) {
                                strI = "";
                            }
                        } else {
                            strI = "";
                        }
                        com.mlmvpn.scanner.e.x(strI, StoreNetKt.tr("پل\u200cها با یک درخواست واقعی سنجیده می\u200cشوند و ترتیبشان سابقهٔ موفقیت هر پل را هم در نظر می\u200cگیرد.", "Bridges are measured with a real request, and ranked with each bridge's record of success."), oVar2, r13);
                    }
                    p0Var.u(r13);
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("بیشتر", "More"), 0.0f, oVar2, r13, 2);
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 1251293049, new AnonymousClass11(this.$cat, this.$go)), oVar2, 384, 3);
                    f0.e(oVar2, d3.g(qVar2, 40));
                }
                strTr = StoreNetKt.tr("گرفتن فهرست رمزشده از سرور مامی…", "Fetching the sealed list from Mami's server…");
            }
            str = strTr;
            p0Var3.e0(1309160851);
            if (kotlin.text.o.L0(str)) {
                float f13 = 8;
                t tVarX2 = f0.x(com.mlmvpn.scanner.e.c(qVar3, f13, oVar2, qVar3, 1.0f), f10, 0.0f, 2);
                androidx.compose.foundation.layout.c cVar2 = androidx.compose.foundation.layout.i.f2026e;
                androidx.compose.ui.i iVar2 = androidx.compose.ui.b.f3549s;
                p0Var3.e0(693286680);
                k0 k0VarA2 = a3.a(cVar2, iVar2, oVar2);
                p0Var3.e0(-1323940314);
                iE = b1.E(oVar2);
                w2 w2VarO2 = p0Var3.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarX2);
                p0Var3.h0();
                if (p0Var3.M) {
                    p0Var3.n(l0Var);
                } else {
                    p0Var3.t0();
                }
                b1.Y(oVar2, androidx.compose.ui.node.t.f4283f, k0VarA2);
                b1.Y(oVar2, androidx.compose.ui.node.t.f4282e, w2VarO2);
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var3.M) {
                    w0.u(iE, p0Var3, iE, mVar);
                } else {
                    w0.u(iE, p0Var3, iE, mVar);
                }
                eVarM2.invoke(new r3(oVar2), oVar2, Integer.valueOf(z10 ? 1 : 0));
                p0Var3.e0(2058660585);
                f5.b(2, 0, 390, 24, ios3.getBlue(oVar2, 6), 0L, oVar, d3.m(qVar3, f8));
                f0.e(oVar, d3.p(qVar3, f13));
                obj = "hive";
                qVar = qVar3;
                p0 p0Var5 = p0Var3;
                ios = ios3;
                k9.b(str, null, ios3.getSecondaryLabel(oVar, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar, MamiIdentity.RSA_BITS, 0, 131058);
                oVar2 = oVar;
                r13 = 0;
                w0.z(p0Var5, false, true, false, false);
                p0Var = p0Var5;
            } else {
                p0Var = p0Var3;
                qVar = qVar3;
                obj = "hive";
                ios = ios3;
                r13 = z10;
            }
            p0Var.u(r13);
            p0Var.e0(1309181426);
            k2Var = this.$note$delegate;
            l4Var = this.$st$delegate;
            bVarJ = m9.d.j();
            p0Var.e0(1309181549);
            if (kotlin.text.o.L0(MamiScreenKt.MamiMain$lambda$47(k2Var))) {
                ios2 = ios;
                i10 = 6;
            } else {
                ios2 = ios;
                i10 = 6;
            }
            p0Var.u(r13);
            p0Var.e0(1309184722);
            if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "off")) {
                v vVar3 = new v(ios2.getRed(oVar2, i10));
                String error3 = MamiScreenKt.MamiMain$lambda$29(l4Var).getError();
                kotlin.jvm.internal.j.b(error3);
                bVarJ.add(new q(vVar3, error3, Boolean.FALSE));
            }
            p0Var.u(r13);
            p0Var.e0(1309188318);
            if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "off")) {
                v vVar4 = new v(ios2.getOrange(oVar2, i10));
                if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getLastWhy(), "replaced")) {
                    str2 = "اتصال دیگری موتور را گرفت؛ مامی کنار رفت.";
                    str3 = "Another connection took the engine; Mami stepped aside.";
                } else {
                    str2 = "موتور متوقف شد؛ اتصال مامی تمام شد.";
                    str3 = "The engine stopped; Mami's connection ended.";
                }
                bVarJ.add(new q(vVar4, StoreNetKt.tr(str2, str3), Boolean.FALSE));
            }
            p0Var.u(r13);
            p0Var.e0(1309199985);
            if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiMain$lambda$29(l4Var).getPhase(), "lost")) {
                bVarJ.add(new q(new v(ios2.getOrange(oVar2, i10)), StoreNetKt.tr("اتصال فعلی جواب نمی\u200cدهد.", "The connection stopped answering."), Boolean.TRUE));
            }
            p0Var.u(r13);
            listBuild = bVarJ.build();
            p0Var.u(r13);
            p0Var.e0(1309204977);
            if (listBuild.isEmpty()) {
                qVar2 = qVar;
                f0.e(oVar2, d3.g(qVar2, 8));
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 426746717, new AnonymousClass3(listBuild, this.$ask, this.$serverTarget$delegate, this.$note$delegate)), oVar2, 384, 3);
            } else {
                qVar2 = qVar;
            }
            p0Var.u(r13);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("روش اتصال", "Method"), " — ", MamiScreenKt.methodName(this.$chosen)), 0.0f, oVar2, r13, 2);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -207770224, new C01444(this.$prefs, this.$lock)), oVar2, 384, 3);
            if (this.$lock) {
                strTr2 = StoreNetKt.tr("برای عوض کردن روش اول قطع کنید.", "Disconnect first to change the method.");
            } else {
                strTr2 = StoreNetKt.tr("«خودکار» از فهرست سرورهای مامی بهترین را انتخاب می\u200cکند؛ اگر یک روش وصل نشد، روش دیگری را امتحان کنید.", "«Auto» picks the best of Mami's servers; if a method does not connect, try another.");
            }
            IosSettingsKt.SettingsFooter(strTr2, oVar2, r13);
            p0Var.e0(1309248181);
            if (kotlin.jvm.internal.j.a(this.$chosen.getKey(), "auto")) {
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(StoreNetKt.tr("مکان", "Place"), " — ", com.mlmvpn.core.aether.i.e(this.$locs.size(), " places", v0.a.p(MamiScreenKt.fa(this.$locs.size()), " مکان"))), 0.0f, oVar2, r13, 2);
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 595890492, new AnonymousClass5(this.$prefs, this.$lock, this.$locs, this.$showAllPlaces$delegate)), oVar2, 384, 3);
                if (this.$locs.isEmpty()) {
                    strTr4 = StoreNetKt.tr("مکان جایی است که ترافیک از آن بیرون می\u200cآید؛ سرورِ ورود را همچنان سنجش انتخاب می\u200cکند.", "The place is where traffic comes out; the way in is still chosen by the test.");
                } else {
                    strTr4 = StoreNetKt.tr("بعد از اولین دریافت فهرست، مکان\u200cها اینجا می\u200cآیند.", "Places appear here after the first list is fetched.");
                }
                IosSettingsKt.SettingsFooter(strTr4, oVar2, r13);
                String strTr8 = StoreNetKt.tr("فهرست سرورها", "Server list");
                catalogInfo = this.$cat;
                if (catalogInfo != null) {
                    strH = v0.a.h(" — ", StoreNetKt.tr(v0.a.h("ویرایش ", MamiScreenKt.fa(catalogInfo.getRevision())), "revision " + catalogInfo.getRevision()));
                    if (strH == null) {
                        strH = "";
                    }
                } else {
                    strH = "";
                }
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(v0.a.p(strTr8, strH), 0.0f, oVar2, r13, 2);
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -206076507, new AnonymousClass7(this.$connecting, this.$context, this.$cat, this.$busy$delegate)), oVar2, 384, 3);
                String strCatalogLine2 = MamiScreenKt.catalogLine(this.$cat);
                if (this.$control.getRegistered()) {
                    strTr5 = StoreNetKt.tr(" اولین دریافت فهرست، این دستگاه را به\u200cصورت ناشناس روی سرور مامی ثبت می\u200cکند.", " The first fetch registers this device anonymously with Mami's server.");
                } else {
                    strTr5 = "";
                }
                com.mlmvpn.scanner.e.x(strCatalogLine2, strTr5, oVar2, r13);
            }
            p0Var.u(r13);
            p0Var.e0(1309329769);
            if (kotlin.jvm.internal.j.a(this.$chosen.getKey(), obj)) {
                String strTr9 = StoreNetKt.tr("پل\u200cهای لیون", "Lion's bridges");
                hiveInfo = this.$hive;
                if (hiveInfo != null) {
                    strTr3 = com.mlmvpn.core.aether.i.e(hiveInfo.getServers(), " bridges", v0.a.p(MamiScreenKt.fa(hiveInfo.getServers()), " پل"));
                    if (strTr3 == null) {
                        strTr3 = StoreNetKt.tr("خالی", "empty");
                    }
                } else {
                    strTr3 = StoreNetKt.tr("خالی", "empty");
                }
                IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(f0.a.l(strTr9, " — ", strTr3), 0.0f, oVar2, r13, 2);
                IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 765034267, new AnonymousClass9(this.$connecting, this.$context, this.$busy$delegate)), oVar2, 384, 3);
                hiveInfo2 = this.$hive;
                if (hiveInfo2 != null) {
                    String strWhenWord2 = MamiScreenKt.whenWord(hiveInfo2.getFetchedAt());
                    if (hiveInfo2.getSkipped() > 0) {
                        strN = w0.n(" · ", MamiScreenKt.fa(hiveInfo2.getSkipped()), " پل نامعتبر کنار گذاشته شد");
                    } else {
                        strN = "";
                    }
                    strI = com.mlmvpn.core.aether.i.i("Fetched ", MamiScreenKt.whenWord(hiveInfo2.getFetchedAt()), ". ", d1.g("گرفته\u200cشده ", strWhenWord2, strN, ". "));
                    if (strI == null) {
                        strI = "";
                    }
                } else {
                    strI = "";
                }
                com.mlmvpn.scanner.e.x(strI, StoreNetKt.tr("پل\u200cها با یک درخواست واقعی سنجیده می\u200cشوند و ترتیبشان سابقهٔ موفقیت هر پل را هم در نظر می\u200cگیرد.", "Bridges are measured with a real request, and ranked with each bridge's record of success."), oVar2, r13);
            }
            p0Var.u(r13);
            IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("بیشتر", "More"), 0.0f, oVar2, r13, 2);
            IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 1251293049, new AnonymousClass11(this.$cat, this.$go)), oVar2, 384, 3);
            f0.e(oVar2, d3.g(qVar2, 40));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Page.values().length];
            try {
                iArr[Page.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Page.SERVERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Page.DEVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Page.LOGS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    private static final void MamiDevice(ee.a aVar, o oVar, int i) {
        int i10;
        k2 k2Var;
        int i11;
        c3 c3VarY;
        e2 e2Var = e2.f3199e;
        p0 p0Var = (p0) oVar;
        p0Var.f0(857635155);
        if ((i & 6) == 0) {
            i10 = i | (p0Var.h(aVar) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i10 & 3) != 2 || !p0Var.G()) {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var.l(w1.f4590b);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            k2 k2VarX = b1.x(mamiEngine.getStatus(), p0Var);
            k2 k2VarX2 = b1.x(mamiEngine.getVersion(), p0Var);
            k2 k2VarX3 = b1.x(mamiEngine.getBusy(), p0Var);
            int iMamiDevice$lambda$85 = MamiDevice$lambda$85(k2VarX2);
            p0Var.e0(2111521823);
            boolean zD = p0Var.d(iMamiDevice$lambda$85);
            Object objI = p0Var.I();
            e2 e2Var2 = n.f3284a;
            if (zD || objI == e2Var2) {
                objI = mamiEngine.control$app_release();
                p0Var.r0(objI);
            }
            final MamiApi.Summary summary = (MamiApi.Summary) objI;
            p0Var.u(false);
            int iMamiDevice$lambda$86 = MamiDevice$lambda$85(k2VarX2);
            p0Var.e0(2111523651);
            boolean zD2 = p0Var.d(iMamiDevice$lambda$86);
            Object objI2 = p0Var.I();
            if (zD2 || objI2 == e2Var2) {
                objI2 = mamiEngine.catalogInfo();
                p0Var.r0(objI2);
            }
            final MamiEngine.CatalogInfo catalogInfo = (MamiEngine.CatalogInfo) objI2;
            p0Var.u(false);
            final boolean z10 = !kotlin.jvm.internal.j.a(MamiDevice$lambda$84(k2VarX).getPhase(), "off") || MamiDevice$lambda$86(k2VarX3).length() > 0;
            p0Var.e0(2111527488);
            Object objI3 = p0Var.I();
            if (objI3 == e2Var2) {
                objI3 = b1.N(null, e2Var);
                p0Var.r0(objI3);
            }
            final k2 k2Var2 = (k2) objI3;
            Object objH = w0.h(2111530612, p0Var, false);
            if (objH == e2Var2) {
                objH = b1.N("", e2Var);
                p0Var.r0(objH);
            }
            final k2 k2Var3 = (k2) objH;
            p0Var.u(false);
            IosSettingsKt.IosScreen(StoreNetKt.tr("دستگاه و فهرست", "Device and list"), aVar, getTITLE(), null, null, false, null, null, x6.p.f(p0Var, -775301783, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt.MamiDevice.1

                /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiDevice$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
                public static final class AnonymousClass2 implements ee.f {
                    final /* synthetic */ k2 $confirm$delegate;
                    final /* synthetic */ boolean $lock;

                    public AnonymousClass2(boolean z10, k2 k2Var) {
                        this.$lock = z10;
                        this.$confirm$delegate = k2Var;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final u invoke$lambda$1$lambda$0(k2 k2Var) {
                        MamiScreenKt.MamiDevice$lambda$91(k2Var, Boolean.FALSE);
                        return u.f67154a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final u invoke$lambda$3$lambda$2(k2 k2Var) {
                        MamiScreenKt.MamiDevice$lambda$91(k2Var, Boolean.TRUE);
                        return u.f67154a;
                    }

                    @Override // ee.f
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                        return u.f67154a;
                    }

                    public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
                        int i10;
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
                        String strTr = StoreNetKt.tr("نشست و فهرست", "Session and list");
                        androidx.compose.ui.graphics.vector.f fVarR = com.google.android.gms.internal.mlkit_vision_subject_segmentation.r.r();
                        Ios ios = Ios.INSTANCE;
                        long red = ios.getRed(oVar, 6);
                        int i11 = 1;
                        boolean z10 = !this.$lock;
                        p0 p0Var2 = (p0) oVar;
                        p0Var2.e0(-845725114);
                        k2 k2Var = this.$confirm$delegate;
                        Object objI = p0Var2.I();
                        int i12 = 0;
                        e2 e2Var = n.f3284a;
                        if (objI == e2Var) {
                            objI = new f(i12, k2Var);
                            p0Var2.r0(objI);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr, fVarR, red, null, false, z10, false, (ee.a) objI, oVar, 12582912, 88);
                        SettingsGroup.Separator(oVar, i10 & 14);
                        String strTr2 = StoreNetKt.tr("هویت تازه برای این دستگاه", "A new identity for this device");
                        androidx.compose.ui.graphics.vector.f fVarP = p.p();
                        long red2 = ios.getRed(oVar, 6);
                        boolean z11 = !this.$lock;
                        p0Var2.e0(-845717851);
                        k2 k2Var2 = this.$confirm$delegate;
                        Object objI2 = p0Var2.I();
                        if (objI2 == e2Var) {
                            objI2 = new f(i11, k2Var2);
                            p0Var2.r0(objI2);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr2, fVarP, red2, null, false, z11, false, (ee.a) objI2, oVar, 12582912, 88);
                    }
                }

                @Override // ee.f
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((androidx.compose.foundation.layout.d0) obj, (o) obj2, ((Number) obj3).intValue());
                    return u.f67154a;
                }

                public final void invoke(androidx.compose.foundation.layout.d0 IosScreen, o oVar2, int i12) {
                    String strMamiDevice$lambda$93;
                    kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
                    if ((i12 & 17) == 16) {
                        p0 p0Var2 = (p0) oVar2;
                        if (p0Var2.G()) {
                            p0Var2.Y();
                            return;
                        }
                    }
                    r0 r0Var2 = v0.f3474a;
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("سرور فرمان و نشست این دستگاه", "Control host and this device's session"), 0.0f, oVar2, 0, 2);
                    final MamiApi.Summary summary2 = summary;
                    final MamiEngine.CatalogInfo catalogInfo2 = catalogInfo;
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -1818500224, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt.MamiDevice.1.1
                        @Override // ee.f
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                            return u.f67154a;
                        }

                        /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
                        /* JADX WARN: Code duplicated, block: B:45:0x00b6  */
                        public final void invoke(SettingsGroupScope SettingsGroup, o oVar3, int i13) {
                            int i14;
                            String strTr;
                            String strTr2;
                            String strM;
                            String str;
                            String strTr3;
                            String hostSource;
                            String str2;
                            String str3;
                            kotlin.jvm.internal.j.e(SettingsGroup, "$this$SettingsGroup");
                            if ((i13 & 6) == 0) {
                                i14 = i13 | ((i13 & 8) == 0 ? ((p0) oVar3).f(SettingsGroup) : ((p0) oVar3).h(SettingsGroup) ? 4 : 2);
                            } else {
                                i14 = i13;
                            }
                            if ((i14 & 19) == 18) {
                                p0 p0Var3 = (p0) oVar3;
                                if (p0Var3.G()) {
                                    p0Var3.Y();
                                    return;
                                }
                            }
                            r0 r0Var3 = v0.f3474a;
                            String strTr4 = StoreNetKt.tr("سرور فرمان", "Control host");
                            if (summary2.getHost() != null) {
                                String host = summary2.getHost();
                                String strTr5 = StoreNetKt.tr("از", "from");
                                String hostSource2 = summary2.getHostSource();
                                if (hostSource2 == null) {
                                    hostSource = summary2.getHostSource();
                                    if (hostSource == null) {
                                        hostSource = "—";
                                    }
                                } else {
                                    int iHashCode = hostSource2.hashCode();
                                    if (iHashCode != -1245635613) {
                                        if (iHashCode != -1240244679) {
                                            str2 = "گوگل\u200cداکس";
                                            str3 = "Google Docs";
                                            hostSource = StoreNetKt.tr(str2, str3);
                                        } else {
                                            str2 = "گوگل\u200cداکس";
                                            str3 = "Google Docs";
                                            hostSource = StoreNetKt.tr(str2, str3);
                                        }
                                    } else if (hostSource2.equals("github")) {
                                        str2 = "گیت\u200cهاب";
                                        str3 = "GitHub";
                                        hostSource = StoreNetKt.tr(str2, str3);
                                    } else {
                                        hostSource = summary2.getHostSource();
                                        if (hostSource == null) {
                                            hostSource = "—";
                                        }
                                    }
                                }
                                strTr = w0.r(d1.k(host, " · ", strTr5, " ", hostSource), " · ", MamiScreenKt.whenWord(summary2.getHostAt()));
                            } else {
                                strTr = StoreNetKt.tr("هنوز پیدا نشده (اولین اتصال پیدا می\u200cکند)", "not found yet (the first connect finds it)");
                            }
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr4, null, 0L, null, v0.a.p(strTr, !kotlin.text.o.L0(summary2.getHostError()) ? v0.a.h("\n", summary2.getHostError()) : ""), 0L, false, null, 0, oVar3, 1572864, 430);
                            int i15 = i14 & 14;
                            SettingsGroup.Separator(oVar3, i15);
                            String strTr6 = StoreNetKt.tr("ثبت دستگاه", "Registration");
                            if (summary2.getRegistered()) {
                                strTr2 = g1.j("registered (anonymous) · ", MamiScreenKt.whenWord(summary2.getRegisteredAt()), w0.n("ثبت\u200cشده (ناشناس) · ", MamiScreenKt.whenWord(summary2.getRegisteredAt()), summary2.getAccessExpiresAt() > 0 ? v0.a.h(" · اعتبار نشست ", MamiScreenKt.whenWord(summary2.getAccessExpiresAt())) : ""));
                            } else {
                                strTr2 = StoreNetKt.tr("ثبت نشده", "not registered");
                            }
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr6, null, 0L, null, strTr2, 0L, false, null, 0, oVar3, 1572864, 430);
                            SettingsGroup.Separator(oVar3, i15);
                            String strTr7 = StoreNetKt.tr("اختلاف ساعت با سرور", "Clock offset");
                            if (summary2.getClockOffsetSec() != 0) {
                                strM = f0.a.m(MamiScreenKt.fa(Math.abs(summary2.getClockOffsetSec())), " ثانیه ", summary2.getClockOffsetSec() > 0 ? "جلوتر" : "عقب\u200cتر", " (خودکار جبران می\u200cشود)");
                                str = Math.abs(summary2.getClockOffsetSec()) + " s " + (summary2.getClockOffsetSec() > 0 ? "ahead" : "behind") + " (made up for automatically)";
                            } else {
                                strM = "ندارد";
                                str = "none";
                            }
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr7, null, 0L, null, StoreNetKt.tr(strM, str), 0L, false, null, 0, oVar3, 1572864, 430);
                            SettingsGroup.Separator(oVar3, i15);
                            String strTr8 = StoreNetKt.tr("فهرست سرورها", "Server list");
                            MamiEngine.CatalogInfo catalogInfo3 = catalogInfo2;
                            if (catalogInfo3 != null) {
                                String strH = d1.h("ویرایش ", MamiScreenKt.fa(catalogInfo3.getRevision()), " · نسخهٔ بار ", MamiScreenKt.fa(catalogInfo2.getPayloadVersion()), " · ");
                                StringBuilder sbJ = com.mlmvpn.core.aether.i.j(catalogInfo2.getRevision(), "revision ", catalogInfo2.getPayloadVersion(), " · payload ");
                                sbJ.append(" · ");
                                strTr3 = v0.a.p(StoreNetKt.tr(strH, sbJ.toString()), MamiScreenKt.catalogLine(catalogInfo2));
                            } else {
                                strTr3 = StoreNetKt.tr("هنوز گرفته نشده", "not fetched yet");
                            }
                            IosSettingsKt.m863SettingsRowqhMrWXk(strTr8, null, 0L, null, strTr3, 0L, false, null, 0, oVar3, 1572864, 430);
                        }
                    }), oVar2, 384, 3);
                    IosSettingsKt.SettingsFooter(StoreNetKt.tr("فهرست سرورها رمزشده است و فقط با کلیدی باز می\u200cشود که همین دستگاه برای هر درخواست تازه می\u200cسازد، و امضای سرور مامی باید درست باشد؛ فهرستی که امضایش نخواند پذیرفته نمی\u200cشود. هیچ نام، شماره یا حسابی از شما فرستاده نمی\u200cشود.", "The server list is encrypted to a key this device makes fresh for each request, and Mami's signature must check out. No name, number or account of yours is sent."), oVar2, 0);
                    IosSettingsKt.m864SettingsSectionHeaderrAjV9yQ(StoreNetKt.tr("پاک کردن", "Clear"), 0.0f, oVar2, 0, 2);
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, -2014550423, new AnonymousClass2(z10, k2Var2)), oVar2, 384, 3);
                    if (z10) {
                        strMamiDevice$lambda$93 = StoreNetKt.tr("برای پاک کردن، اول اتصال مامی را قطع کنید.", "Disconnect Mami first to clear.");
                    } else {
                        strMamiDevice$lambda$93 = MamiScreenKt.MamiDevice$lambda$93(k2Var3);
                        if (kotlin.text.o.L0(strMamiDevice$lambda$93)) {
                            strMamiDevice$lambda$93 = StoreNetKt.tr("«نشست و فهرست»: اتصال بعدی دوباره می\u200cگیرد. «هویت تازه»: این دستگاه برای سرور مامی دستگاه تازه\u200cای می\u200cشود (مثل نصب دوباره).", "«Session and list»: the next connect fetches again. «New identity»: this device becomes a new device to Mami's server (like a reinstall).");
                        }
                    }
                    IosSettingsKt.SettingsFooter(strMamiDevice$lambda$93, oVar2, 0);
                    f0.e(oVar2, d3.g(androidx.compose.ui.q.f4604b, 40));
                }
            }), p0Var, ((i10 << 3) & 112) | 100663296, 248);
            Boolean boolMamiDevice$lambda$90 = MamiDevice$lambda$90(k2Var2);
            if (boolMamiDevice$lambda$90 != null) {
                final boolean zBooleanValue = boolMamiDevice$lambda$90.booleanValue();
                p0Var.e0(-770587962);
                Object objI4 = p0Var.I();
                if (objI4 == e2Var2) {
                    k2Var = k2Var2;
                    objI4 = new f(4, k2Var);
                    p0Var.r0(objI4);
                } else {
                    k2Var = k2Var2;
                }
                ee.a aVar2 = (ee.a) objI4;
                p0Var.u(false);
                androidx.compose.runtime.internal.e eVarF = x6.p.f(p0Var, -939559858, new MamiScreenKt$MamiDevice$2$2(context, zBooleanValue, k2Var3, k2Var));
                androidx.compose.runtime.internal.e eVarF2 = x6.p.f(p0Var, 954774028, new MamiScreenKt$MamiDevice$2$3(k2Var));
                androidx.compose.runtime.internal.e eVarF3 = x6.p.f(p0Var, -1445859382, new ee.e() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiDevice$2$4
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((o) obj, ((Number) obj2).intValue());
                        return u.f67154a;
                    }

                    public final void invoke(o oVar2, int i12) {
                        String str;
                        String str2;
                        if ((i12 & 3) == 2) {
                            p0 p0Var2 = (p0) oVar2;
                            if (p0Var2.G()) {
                                p0Var2.Y();
                                return;
                            }
                        }
                        r0 r0Var2 = v0.f3474a;
                        if (zBooleanValue) {
                            str = "هویت تازه";
                            str2 = "New identity";
                        } else {
                            str = "پاک کردن";
                            str2 = "Clear";
                        }
                        k9.b(StoreNetKt.tr(str, str2), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, 0, 0, 131070);
                    }
                });
                androidx.compose.runtime.internal.e eVarF4 = x6.p.f(p0Var, -498692439, new ee.e() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiDevice$2$5
                    @Override // ee.e
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((o) obj, ((Number) obj2).intValue());
                        return u.f67154a;
                    }

                    public final void invoke(o oVar2, int i12) {
                        if ((i12 & 3) == 2) {
                            p0 p0Var2 = (p0) oVar2;
                            if (p0Var2.G()) {
                                p0Var2.Y();
                                return;
                            }
                        }
                        r0 r0Var2 = v0.f3474a;
                        k9.b(zBooleanValue ? StoreNetKt.tr("این دستگاه برای سرور مامی هویت تازه\u200cای بگیرد؟ نشست و فهرست هم پاک می\u200cشود.", "Give this device a new identity for Mami's server? The session and list are cleared too.") : StoreNetKt.tr("نشست و فهرست سرورهای مامی پاک شود؟", "Clear Mami's session and server list?"), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, oVar2, 0, 0, 131070);
                    }
                });
                i11 = 1;
                androidx.compose.material3.m.b(aVar2, eVarF, null, eVarF2, null, eVarF3, eVarF4, null, 0L, 0L, 0L, 0L, 0.0f, null, p0Var, 1772598, 0, 16276);
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new b(i, i11, aVar);
            }
        }
        p0Var.Y();
        i11 = 1;
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new b(i, i11, aVar);
        }
    }

    private static final MamiEngine.Status MamiDevice$lambda$84(l4 l4Var) {
        return (MamiEngine.Status) l4Var.getValue();
    }

    private static final int MamiDevice$lambda$85(l4 l4Var) {
        return ((Number) l4Var.getValue()).intValue();
    }

    private static final String MamiDevice$lambda$86(l4 l4Var) {
        return (String) l4Var.getValue();
    }

    private static final Boolean MamiDevice$lambda$90(k2 k2Var) {
        return (Boolean) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiDevice$lambda$91(k2 k2Var, Boolean bool) {
        k2Var.setValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiDevice$lambda$93(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiDevice$lambda$97$lambda$96$lambda$95(k2 k2Var) {
        k2Var.setValue(null);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiDevice$lambda$98(ee.a aVar, int i, o oVar, int i10) {
        MamiDevice(aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    private static final void MamiLogs(ee.a aVar, o oVar, int i) {
        int i10;
        ee.a aVar2;
        p0 p0Var = (p0) oVar;
        p0Var.f0(1749822874);
        if ((i & 6) == 0) {
            i10 = (p0Var.h(aVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i11 = 3;
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
            aVar2 = aVar;
        } else {
            r0 r0Var = v0.f3474a;
            final k2 k2VarX = b1.x(MamiEngine.INSTANCE.getLogs(), p0Var);
            aVar2 = aVar;
            IosSettingsKt.IosScreen(StoreNetKt.tr("لاگ مامی", "Mami log"), aVar2, getTITLE(), null, null, false, null, null, x6.p.f(p0Var, -1054107856, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt.MamiLogs.1
                @Override // ee.f
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((androidx.compose.foundation.layout.d0) obj, (o) obj2, ((Number) obj3).intValue());
                    return u.f67154a;
                }

                public final void invoke(androidx.compose.foundation.layout.d0 IosScreen, o oVar2, int i12) {
                    o oVar3 = oVar2;
                    kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
                    if ((i12 & 17) == 16) {
                        p0 p0Var2 = (p0) oVar3;
                        if (p0Var2.G()) {
                            p0Var2.Y();
                            return;
                        }
                    }
                    r0 r0Var2 = v0.f3474a;
                    androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                    t tVarV = f0.v(GlassKt.frostedGlass(f0.x(com.mlmvpn.scanner.e.c(qVar, 10, oVar3, qVar, 1.0f), 16, 0.0f, 2), e0.e.b(14), false, false, oVar3, 6, 6), 12);
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
                    boolean z10 = false;
                    eVarM.invoke(new r3(oVar3), oVar3, 0);
                    p0Var3.e0(2058660585);
                    p0Var3.e0(-2086905704);
                    List listMamiLogs$lambda$99 = MamiScreenKt.MamiLogs$lambda$99(l4Var);
                    if (listMamiLogs$lambda$99.isEmpty()) {
                        listMamiLogs$lambda$99 = m9.d.B(StoreNetKt.tr("هنوز رویدادی نیست.", "Nothing yet."));
                    }
                    Iterator it = listMamiLogs$lambda$99.iterator();
                    while (it.hasNext()) {
                        k9.b((String) it.next(), null, Ios.INSTANCE.getLabel(oVar3, 6), x6.a.t(11), null, null, androidx.compose.ui.text.font.j.f4785c, 0L, null, null, x6.a.t(15), 0, false, 0, 0, null, null, oVar2, MamiIdentity.RSA_BITS, 6, 129970);
                        oVar3 = oVar2;
                        p0Var3 = p0Var3;
                        qVar = qVar;
                        z10 = false;
                    }
                    p0 p0Var4 = p0Var3;
                    w0.z(p0Var4, false, false, true, false);
                    p0Var4.u(false);
                    f0.e(oVar3, d3.g(qVar, 40));
                    r0 r0Var3 = v0.f3474a;
                }
            }), p0Var, ((i10 << 3) & 112) | 100663296, 248);
        }
        c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new b(i, i11, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiLogs$lambda$100(ee.a aVar, int i, o oVar, int i10) {
        MamiLogs(aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> MamiLogs$lambda$99(l4 l4Var) {
        return (List) l4Var.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x02ec  */
    private static final void MamiMain(ee.a aVar, ee.c cVar, o oVar, int i) {
        int i10;
        Object mamiScreenKt$MamiMain$2$1;
        k2 k2Var;
        wd.d dVar;
        EngineTone engineTone;
        String strTr;
        String str;
        String str2;
        ee.c cVar2;
        p0 p0Var;
        ee.a aVar2 = aVar;
        e2 e2Var = e2.f3199e;
        p0 p0Var2 = (p0) oVar;
        p0Var2.f0(-98385821);
        int i11 = 2;
        if ((i & 6) == 0) {
            i10 = i | (p0Var2.h(aVar2) ? 4 : 2);
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var2.h(cVar) ? 32 : 16;
        }
        int i12 = i10;
        if ((i12 & 19) == 18 && p0Var2.G()) {
            p0Var2.Y();
            cVar2 = cVar;
            p0Var = p0Var2;
        } else {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var2.l(w1.f4590b);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            k2 k2VarX = b1.x(mamiEngine.getStatus(), p0Var2);
            k2 k2VarX2 = b1.x(mamiEngine.getVersion(), p0Var2);
            k2 k2VarX3 = b1.x(mamiEngine.getBusy(), p0Var2);
            int iMamiMain$lambda$30 = MamiMain$lambda$30(k2VarX2);
            p0Var2.e0(-213198784);
            boolean zD = p0Var2.d(iMamiMain$lambda$30);
            Object objI = p0Var2.I();
            e2 e2Var2 = n.f3284a;
            if (zD || objI == e2Var2) {
                objI = mamiEngine.prefs();
                p0Var2.r0(objI);
            }
            MamiEngine.Prefs prefs = (MamiEngine.Prefs) objI;
            int i13 = 0;
            p0Var2.u(false);
            int iMamiMain$lambda$31 = MamiMain$lambda$30(k2VarX2);
            p0Var2.e0(-213197018);
            boolean zD2 = p0Var2.d(iMamiMain$lambda$31);
            Object objI2 = p0Var2.I();
            if (zD2 || objI2 == e2Var2) {
                objI2 = mamiEngine.catalogInfo();
                p0Var2.r0(objI2);
            }
            MamiEngine.CatalogInfo catalogInfo = (MamiEngine.CatalogInfo) objI2;
            p0Var2.u(false);
            int iMamiMain$lambda$32 = MamiMain$lambda$30(k2VarX2);
            p0Var2.e0(-213195037);
            boolean zD3 = p0Var2.d(iMamiMain$lambda$32);
            Object objI3 = p0Var2.I();
            if (zD3 || objI3 == e2Var2) {
                objI3 = mamiEngine.hiveInfo();
                p0Var2.r0(objI3);
            }
            MamiEngine.HiveInfo hiveInfo = (MamiEngine.HiveInfo) objI3;
            p0Var2.u(false);
            int iMamiMain$lambda$33 = MamiMain$lambda$30(k2VarX2);
            p0Var2.e0(-213193148);
            boolean zD4 = p0Var2.d(iMamiMain$lambda$33);
            Object objI4 = p0Var2.I();
            if (zD4 || objI4 == e2Var2) {
                objI4 = mamiEngine.locations();
                p0Var2.r0(objI4);
            }
            List list = (List) objI4;
            p0Var2.u(false);
            int iMamiMain$lambda$34 = MamiMain$lambda$30(k2VarX2);
            p0Var2.e0(-213191134);
            boolean zD5 = p0Var2.d(iMamiMain$lambda$34);
            Object objI5 = p0Var2.I();
            if (zD5 || objI5 == e2Var2) {
                objI5 = mamiEngine.control$app_release();
                p0Var2.r0(objI5);
            }
            MamiApi.Summary summary = (MamiApi.Summary) objI5;
            p0Var2.u(false);
            boolean zA = kotlin.jvm.internal.j.a(MamiMain$lambda$29(k2VarX).getPhase(), TunnelVpnService.STATUS_CONNECTING);
            boolean live = MamiMain$lambda$29(k2VarX).getLive();
            boolean z10 = zA || live;
            MamiEngine.Method method = mamiEngine.method(prefs.getMethod());
            if (method == null) {
                method = mamiEngine.getMETHODS().get(0);
            }
            MamiEngine.Method method2 = method;
            p0Var2.e0(-213183326);
            Object objI6 = p0Var2.I();
            if (objI6 == e2Var2) {
                objI6 = b1.N(null, e2Var);
                p0Var2.r0(objI6);
            }
            k2 k2Var2 = (k2) objI6;
            boolean zD6 = com.mlmvpn.scanner.e.D(p0Var2, false, -213181110, context);
            Object objI7 = p0Var2.I();
            if (zD6 || objI7 == e2Var2) {
                objI7 = new d(i13, context, k2Var2);
                p0Var2.r0(objI7);
            }
            p0Var2.u(false);
            ee.a aVarVpnLauncher = vpnLauncher((ee.a) objI7, p0Var2, 0);
            Object[] objArr = new Object[0];
            p0Var2.e0(-213178159);
            Object objI8 = p0Var2.I();
            if (objI8 == e2Var2) {
                objI8 = new l(i11);
                p0Var2.r0(objI8);
            }
            p0Var2.u(false);
            k2 k2Var3 = (k2) x6.t.q(objArr, null, (ee.a) objI8, p0Var2, 6);
            p0Var2.e0(-213176809);
            Object objI9 = p0Var2.I();
            if (objI9 == e2Var2) {
                objI9 = b1.N("", e2Var);
                p0Var2.r0(objI9);
            }
            k2 k2Var4 = (k2) objI9;
            p0Var2.u(false);
            String method3 = prefs.getMethod();
            p0Var2.e0(-213171529);
            boolean zH = p0Var2.h(context);
            Object objI10 = p0Var2.I();
            if (zH || objI10 == e2Var2) {
                objI10 = new MamiScreenKt$MamiMain$1$1(context, null);
                p0Var2.r0(objI10);
            }
            p0Var2.u(false);
            b1.e(p0Var2, (ee.e) objI10, method3);
            p0Var2.e0(-213166371);
            Object objI11 = p0Var2.I();
            if (objI11 == e2Var2) {
                objI11 = b1.N(MamiMain$lambda$29(k2VarX).getPhase(), e2Var);
                p0Var2.r0(objI11);
            }
            k2 k2Var5 = (k2) objI11;
            p0Var2.u(false);
            String phase = MamiMain$lambda$29(k2VarX).getPhase();
            p0Var2.e0(-213163948);
            boolean zF = p0Var2.f(k2VarX) | p0Var2.h(context);
            Object objI12 = p0Var2.I();
            if (zF || objI12 == e2Var2) {
                k2Var = k2Var2;
                dVar = null;
                mamiScreenKt$MamiMain$2$1 = new MamiScreenKt$MamiMain$2$1(context, k2VarX, k2Var5, k2Var4, null);
                p0Var2.r0(mamiScreenKt$MamiMain$2$1);
            } else {
                k2Var = k2Var2;
                dVar = null;
                mamiScreenKt$MamiMain$2$1 = objI12;
            }
            p0Var2.u(false);
            b1.e(p0Var2, (ee.e) mamiScreenKt$MamiMain$2$1, phase);
            p0Var2.e0(-213153479);
            Object objI13 = p0Var2.I();
            if (objI13 == e2Var2) {
                objI13 = b1.N(MamiMain$lambda$31(k2VarX3), e2Var);
                p0Var2.r0(objI13);
            }
            k2 k2Var6 = (k2) objI13;
            p0Var2.u(false);
            String strMamiMain$lambda$31 = MamiMain$lambda$31(k2VarX3);
            p0Var2.e0(-213150922);
            boolean zF2 = p0Var2.f(k2VarX3);
            Object objI14 = p0Var2.I();
            if (zF2 || objI14 == e2Var2) {
                objI14 = new MamiScreenKt$MamiMain$3$1(k2VarX3, k2Var6, k2Var4, dVar);
                p0Var2.r0(objI14);
            }
            p0Var2.u(false);
            b1.e(p0Var2, (ee.e) objI14, strMamiMain$lambda$31);
            String phase2 = MamiMain$lambda$29(k2VarX).getPhase();
            int iHashCode = phase2.hashCode();
            if (iHashCode != -775651656) {
                if (iHashCode != 3551) {
                    if (iHashCode == 3327780 ? phase2.equals("lost") : iHashCode == 1715648628 && phase2.equals("stopping")) {
                        engineTone = EngineTone.BUSY;
                    }
                } else if (phase2.equals("on")) {
                    engineTone = EngineTone.ON;
                }
                engineTone = EngineTone.OFF;
            } else if (phase2.equals(r9)) {
                engineTone = EngineTone.BUSY;
            } else {
                engineTone = EngineTone.OFF;
            }
            String phase3 = MamiMain$lambda$29(k2VarX).getPhase();
            int iHashCode2 = phase3.hashCode();
            if (iHashCode2 != -775651656) {
                if (iHashCode2 != 3551) {
                    if (iHashCode2 != 3327780) {
                        if (iHashCode2 == 1715648628 && phase3.equals("stopping")) {
                            str = "در حال قطع";
                            str2 = "disconnecting";
                        }
                    } else if (phase3.equals("lost")) {
                        str = "بی\u200cداده";
                        str2 = "no data";
                    }
                } else if (phase3.equals("on")) {
                    str = "وصل است";
                    str2 = TunnelVpnService.STATUS_CONNECTED;
                }
                strTr = StoreNetKt.tr(str, str2);
                String strTr2 = StoreNetKt.tr("خانه", "Home");
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(engineTone, strTr, zA, live, k2VarX, context, aVarVpnLauncher, method2, prefs, catalogInfo, hiveInfo, list, z10, summary, k2Var, k2VarX3, k2Var4, k2Var3, cVar);
                cVar2 = cVar;
                p0Var = p0Var2;
                aVar2 = aVar;
                IosSettingsKt.IosScreen(null, aVar2, strTr2, null, null, false, null, null, x6.p.f(p0Var2, 328443513, anonymousClass4), p0Var, ((i12 << 3) & 112) | 100663296, 249);
            } else {
                if (phase3.equals(r9)) {
                    strTr = StoreNetKt.tr("در حال اتصال", TunnelVpnService.STATUS_CONNECTING);
                }
                String strTr3 = StoreNetKt.tr("خانه", "Home");
                AnonymousClass4 anonymousClass5 = new AnonymousClass4(engineTone, strTr, zA, live, k2VarX, context, aVarVpnLauncher, method2, prefs, catalogInfo, hiveInfo, list, z10, summary, k2Var, k2VarX3, k2Var4, k2Var3, cVar);
                cVar2 = cVar;
                p0Var = p0Var2;
                aVar2 = aVar;
                IosSettingsKt.IosScreen(null, aVar2, strTr3, null, null, false, null, null, x6.p.f(p0Var2, 328443513, anonymousClass5), p0Var, ((i12 << 3) & 112) | 100663296, 249);
            }
            str = "قطع";
            str2 = "off";
            strTr = StoreNetKt.tr(str, str2);
            String strTr4 = StoreNetKt.tr("خانه", "Home");
            AnonymousClass4 anonymousClass6 = new AnonymousClass4(engineTone, strTr, zA, live, k2VarX, context, aVarVpnLauncher, method2, prefs, catalogInfo, hiveInfo, list, z10, summary, k2Var, k2VarX3, k2Var4, k2Var3, cVar);
            cVar2 = cVar;
            p0Var = p0Var2;
            aVar2 = aVar;
            IosSettingsKt.IosScreen(null, aVar2, strTr4, null, null, false, null, null, x6.p.f(p0Var2, 328443513, anonymousClass6), p0Var, ((i12 << 3) & 112) | 100663296, 249);
        }
        c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new com.mlmvpn.scanner.engines.nahan.e(aVar2, cVar2, i, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MamiEngine.Status MamiMain$lambda$29(l4 l4Var) {
        return (MamiEngine.Status) l4Var.getValue();
    }

    private static final int MamiMain$lambda$30(l4 l4Var) {
        return ((Number) l4Var.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiMain$lambda$31(l4 l4Var) {
        return (String) l4Var.getValue();
    }

    private static final String MamiMain$lambda$38(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiMain$lambda$39(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiMain$lambda$41$lambda$40(Context context, k2 k2Var) {
        MamiEngine.connectAsync$default(MamiEngine.INSTANCE, context, MamiMain$lambda$38(k2Var), null, 4, null);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 MamiMain$lambda$43$lambda$42() {
        return b1.N(Boolean.FALSE, e2.f3199e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MamiMain$lambda$44(k2 k2Var) {
        return ((Boolean) k2Var.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiMain$lambda$45(k2 k2Var, boolean z10) {
        k2Var.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiMain$lambda$47(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiMain$lambda$48(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiMain$lambda$51(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiMain$lambda$55(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiMain$lambda$58(ee.a aVar, ee.c cVar, int i, o oVar, int i10) {
        MamiMain(aVar, cVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    public static final void MamiScreen(ee.a onBack, o oVar, int i) {
        int i10;
        kotlin.jvm.internal.j.e(onBack, "onBack");
        p0 p0Var = (p0) oVar;
        p0Var.f0(1293797885);
        int i11 = 4;
        if ((i & 6) == 0) {
            i10 = (p0Var.h(onBack) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i12 = 0;
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            Context context = (Context) p0Var.l(w1.f4590b);
            p0Var.e0(589796589);
            Object objI = p0Var.I();
            e2 e2Var = n.f3284a;
            if (objI == e2Var) {
                objI = b1.N(Boolean.FALSE, e2.f3199e);
                p0Var.r0(objI);
            }
            k2 k2Var = (k2) objI;
            p0Var.u(false);
            p0Var.e0(589798571);
            boolean zH = p0Var.h(context);
            Object objI2 = p0Var.I();
            if (zH || objI2 == e2Var) {
                objI2 = new MamiScreenKt$MamiScreen$1$1(context, k2Var, null);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            b1.e(p0Var, (ee.e) objI2, u.f67154a);
            p0Var.e0(589801807);
            if (!MamiScreen$lambda$1(k2Var)) {
                IosSettingsKt.IosScreen(getTITLE(), onBack, StoreNetKt.tr("خانه", "Home"), null, null, false, null, null, ComposableSingletons$MamiScreenKt.INSTANCE.m774getLambda1$app_release(), p0Var, ((i10 << 3) & 112) | 100663296, 248);
                p0Var.u(false);
                c3 c3VarY = p0Var.y();
                if (c3VarY != null) {
                    c3VarY.f3186d = new b(i, i11, onBack);
                    return;
                }
                return;
            }
            int i13 = i10;
            p0Var.u(false);
            Object[] objArr = new Object[0];
            p0Var.e0(589806024);
            Object objI3 = p0Var.I();
            int i14 = 1;
            if (objI3 == e2Var) {
                objI3 = new l(i14);
                p0Var.r0(objI3);
            }
            p0Var.u(false);
            int i15 = 6;
            k2 k2Var2 = (k2) x6.t.q(objArr, null, (ee.a) objI3, p0Var, 6);
            boolean z10 = MamiScreen$lambda$7(k2Var2) != Page.MAIN;
            p0Var.e0(589809247);
            boolean zF = p0Var.f(k2Var2);
            Object objI4 = p0Var.I();
            if (zF || objI4 == e2Var) {
                objI4 = new f(5, k2Var2);
                p0Var.r0(objI4);
            }
            p0Var.u(false);
            com.google.android.gms.internal.mlkit_vision_label.r.a(z10, (ee.a) objI4, 0, p0Var, 0);
            int i16 = WhenMappings.$EnumSwitchMapping$0[MamiScreen$lambda$7(k2Var2).ordinal()];
            if (i16 == 1) {
                boolean zQ = g1.q(p0Var, 589811183, 589811864, k2Var2);
                Object objI5 = p0Var.I();
                if (zQ || objI5 == e2Var) {
                    objI5 = new a(k2Var2, i12);
                    p0Var.r0(objI5);
                }
                p0Var.u(false);
                MamiMain(onBack, (ee.c) objI5, p0Var, i13 & 14);
                p0Var.u(false);
            } else if (i16 == 2) {
                boolean zQ2 = g1.q(p0Var, 589813141, 589813791, k2Var2);
                Object objI6 = p0Var.I();
                if (zQ2 || objI6 == e2Var) {
                    objI6 = new f(i15, k2Var2);
                    p0Var.r0(objI6);
                }
                p0Var.u(false);
                MamiServers((ee.a) objI6, p0Var, 0);
                p0Var.u(false);
            } else if (i16 == 3) {
                boolean zQ3 = g1.q(p0Var, 589815252, 589815871, k2Var2);
                Object objI7 = p0Var.I();
                if (zQ3 || objI7 == e2Var) {
                    objI7 = new f(7, k2Var2);
                    p0Var.r0(objI7);
                }
                p0Var.u(false);
                MamiDevice((ee.a) objI7, p0Var, 0);
                p0Var.u(false);
            } else {
                if (i16 != 4) {
                    throw com.mlmvpn.scanner.e.k(589810297, p0Var, false);
                }
                boolean zQ4 = g1.q(p0Var, 589817266, 589817823, k2Var2);
                Object objI8 = p0Var.I();
                if (zQ4 || objI8 == e2Var) {
                    objI8 = new f(8, k2Var2);
                    p0Var.r0(objI8);
                }
                p0Var.u(false);
                MamiLogs((ee.a) objI8, p0Var, 0);
                p0Var.u(false);
            }
        }
        c3 c3VarY2 = p0Var.y();
        if (c3VarY2 != null) {
            c3VarY2.f3186d = new b(i, i12, onBack);
        }
    }

    private static final boolean MamiScreen$lambda$1(k2 k2Var) {
        return ((Boolean) k2Var.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$10$lambda$9(k2 k2Var) {
        k2Var.setValue(Page.MAIN);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$12$lambda$11(k2 k2Var, Page it) {
        kotlin.jvm.internal.j.e(it, "it");
        k2Var.setValue(it);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$14$lambda$13(k2 k2Var) {
        k2Var.setValue(Page.MAIN);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$16$lambda$15(k2 k2Var) {
        k2Var.setValue(Page.MAIN);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$18$lambda$17(k2 k2Var) {
        k2Var.setValue(Page.MAIN);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$19(ee.a aVar, int i, o oVar, int i10) {
        MamiScreen(aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiScreen$lambda$2(k2 k2Var, boolean z10) {
        k2Var.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiScreen$lambda$4(ee.a aVar, int i, o oVar, int i10) {
        MamiScreen(aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k2 MamiScreen$lambda$6$lambda$5() {
        return b1.N(Page.MAIN, e2.f3199e);
    }

    private static final Page MamiScreen$lambda$7(k2 k2Var) {
        return (Page) k2Var.getValue();
    }

    private static final void MamiServers(ee.a aVar, o oVar, int i) {
        int i10;
        ee.a aVar2;
        MamiEngine.ServerRef server;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-831044331);
        int i11 = 2;
        if ((i & 6) == 0) {
            i10 = (p0Var.h(aVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i10 & 3) == 2 && p0Var.G()) {
            p0Var.Y();
            aVar2 = aVar;
        } else {
            r0 r0Var = v0.f3474a;
            final Context context = (Context) p0Var.l(w1.f4590b);
            MamiEngine mamiEngine = MamiEngine.INSTANCE;
            k2 k2VarX = b1.x(mamiEngine.getStatus(), p0Var);
            k2 k2VarX2 = b1.x(mamiEngine.getVersion(), p0Var);
            final k2 k2VarX3 = b1.x(mamiEngine.getBusy(), p0Var);
            int iMamiServers$lambda$75 = MamiServers$lambda$75(k2VarX2);
            p0Var.e0(778561371);
            boolean zD = p0Var.d(iMamiServers$lambda$75);
            Object objI = p0Var.I();
            e2 e2Var = n.f3284a;
            if (zD || objI == e2Var) {
                objI = mamiEngine.servers();
                p0Var.r0(objI);
            }
            final List list = (List) objI;
            Object objH = w0.h(778563323, p0Var, false);
            String id2 = null;
            if (objH == e2Var) {
                objH = b1.N(null, e2.f3199e);
                p0Var.r0(objH);
            }
            final k2 k2Var = (k2) objH;
            boolean zD2 = com.mlmvpn.scanner.e.D(p0Var, false, 778565590, context);
            Object objI2 = p0Var.I();
            if (zD2 || objI2 == e2Var) {
                objI2 = new d(1, context, k2Var);
                p0Var.r0(objI2);
            }
            p0Var.u(false);
            final ee.a aVarVpnLauncher = vpnLauncher((ee.a) objI2, p0Var, 0);
            final boolean zA = kotlin.jvm.internal.j.a(MamiServers$lambda$74(k2VarX).getPhase(), TunnelVpnService.STATUS_CONNECTING);
            if (MamiServers$lambda$74(k2VarX).getLive() && (server = MamiServers$lambda$74(k2VarX).getServer()) != null) {
                id2 = server.getId();
            }
            final String str = id2;
            aVar2 = aVar;
            IosSettingsKt.IosScreen(StoreNetKt.tr("سرورهای فهرست", "The list's servers"), aVar2, getTITLE(), null, null, false, null, null, x6.p.f(p0Var, 87518143, new ee.f() { // from class: com.mlmvpn.scanner.ui.mami.MamiScreenKt.MamiServers.1

                /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiServers$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
                public static final class C01451 implements ee.f {
                    final /* synthetic */ l4 $busy$delegate;
                    final /* synthetic */ boolean $connecting;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ List<MamiEngine.ServerRow> $list;

                    public C01451(boolean z10, Context context, List<MamiEngine.ServerRow> list, l4 l4Var) {
                        this.$connecting = z10;
                        this.$context = context;
                        this.$list = list;
                        this.$busy$delegate = l4Var;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final u invoke$lambda$1$lambda$0(Context context) {
                        MamiEngine.INSTANCE.refreshAsync(context, "catalog");
                        return u.f67154a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final u invoke$lambda$3$lambda$2(Context context) {
                        MamiEngine.INSTANCE.measureAllAsync(context);
                        return u.f67154a;
                    }

                    @Override // ee.f
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                        return u.f67154a;
                    }

                    public final void invoke(SettingsGroupScope SettingsGroup, o oVar, int i) {
                        int i10;
                        String str;
                        String str2;
                        String str3;
                        String str4;
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
                        if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate), "catalog")) {
                            str = "در حال گرفتن…";
                            str2 = "Fetching…";
                        } else {
                            str = "به\u200cروزرسانی فهرست";
                            str2 = "Refresh the list";
                        }
                        String strTr = StoreNetKt.tr(str, str2);
                        androidx.compose.ui.graphics.vector.f fVarE = x6.q.E();
                        Ios ios = Ios.INSTANCE;
                        long blue = ios.getBlue(oVar, 6);
                        boolean zA = kotlin.jvm.internal.j.a(MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate), "catalog");
                        boolean z10 = (MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate).length() == 0) && !this.$connecting;
                        p0 p0Var2 = (p0) oVar;
                        p0Var2.e0(1947845534);
                        boolean zH = p0Var2.h(this.$context);
                        Context context = this.$context;
                        Object objI = p0Var2.I();
                        e2 e2Var = n.f3284a;
                        if (zH || objI == e2Var) {
                            objI = new m(context, 3);
                            p0Var2.r0(objI);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr, fVarE, blue, null, zA, z10, false, (ee.a) objI, oVar, 0, 72);
                        SettingsGroup.Separator(oVar, i10 & 14);
                        if (kotlin.jvm.internal.j.a(MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate), "measure")) {
                            str3 = "در حال سنجش… (تا نیم دقیقه)";
                            str4 = "Measuring… (up to half a minute)";
                        } else {
                            str3 = "سنجش سرورها";
                            str4 = "Measure the servers";
                        }
                        String strTr2 = StoreNetKt.tr(str3, str4);
                        androidx.compose.ui.graphics.vector.f fVarY = hb.a.y();
                        long green = ios.getGreen(oVar, 6);
                        boolean zA2 = kotlin.jvm.internal.j.a(MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate), "measure");
                        boolean z11 = (!(MamiScreenKt.MamiServers$lambda$76(this.$busy$delegate).length() == 0) || this.$connecting || this.$list.isEmpty()) ? false : true;
                        p0Var2.e0(1947858646);
                        boolean zH2 = p0Var2.h(this.$context);
                        Context context2 = this.$context;
                        Object objI2 = p0Var2.I();
                        if (zH2 || objI2 == e2Var) {
                            objI2 = new m(context2, 4);
                            p0Var2.r0(objI2);
                        }
                        p0Var2.u(false);
                        IosSettingsKt.m860SettingsActionRowXfSFWjk(strTr2, fVarY, green, null, zA2, z11, false, (ee.a) objI2, oVar, 0, 72);
                    }
                }

                /* JADX INFO: renamed from: com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiServers$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
                public static final class AnonymousClass2 implements ee.f {
                    final /* synthetic */ ee.a $ask;
                    final /* synthetic */ boolean $connecting;
                    final /* synthetic */ List<MamiEngine.ServerRow> $list;
                    final /* synthetic */ String $liveId;
                    final /* synthetic */ k2 $target$delegate;

                    public AnonymousClass2(List<MamiEngine.ServerRow> list, String str, boolean z10, ee.a aVar, k2 k2Var) {
                        this.$list = list;
                        this.$liveId = str;
                        this.$connecting = z10;
                        this.$ask = aVar;
                        this.$target$delegate = k2Var;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final u invoke$lambda$3$lambda$2$lambda$1$lambda$0(MamiEngine.ServerRow serverRow, ee.a aVar, k2 k2Var) {
                        MamiScreenKt.MamiServers$lambda$80(k2Var, serverRow.getId());
                        aVar.invoke();
                        return u.f67154a;
                    }

                    @Override // ee.f
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SettingsGroupScope) obj, (o) obj2, ((Number) obj3).intValue());
                        return u.f67154a;
                    }

                    public final void invoke(SettingsGroupScope settingsGroupScope, o oVar, int i) {
                        String strTr;
                        boolean z10;
                        int i10;
                        long red;
                        boolean z11;
                        ee.a aVar;
                        SettingsGroupScope SettingsGroup = settingsGroupScope;
                        o oVar2 = oVar;
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
                        List<MamiEngine.ServerRow> list = this.$list;
                        String str = this.$liveId;
                        boolean z12 = this.$connecting;
                        ee.a aVar2 = this.$ask;
                        k2 k2Var = this.$target$delegate;
                        boolean z13 = false;
                        int i12 = 0;
                        for (Object obj : list) {
                            int i13 = i12 + 1;
                            if (i12 < 0) {
                                r.f0();
                                throw null;
                            }
                            MamiEngine.ServerRow serverRow = (MamiEngine.ServerRow) obj;
                            p0 p0Var2 = (p0) oVar2;
                            p0Var2.e0(1947889573);
                            if (i12 > 0) {
                                SettingsGroup.Separator(oVar2, i11 & 14);
                            }
                            p0Var2.u(z13);
                            if (!serverRow.getSupported()) {
                                strTr = null;
                            } else if (serverRow.getMs() > 0) {
                                strTr = v0.a.p(MamiScreenKt.fa(serverRow.getMs()), " ms");
                            } else {
                                strTr = serverRow.getMs() < 0 ? StoreNetKt.tr("جواب نداد", "no answer") : StoreNetKt.tr("سنجیده\u200cنشده", "not measured");
                            }
                            boolean supported = serverRow.getSupported();
                            t tVarA = androidx.compose.ui.q.f4604b;
                            if (!supported) {
                                tVarA = androidx.compose.ui.draw.h.a(tVarA, 0.55f);
                            }
                            p0Var2.e0(733328855);
                            k0 k0VarC = androidx.compose.foundation.layout.t.c(androidx.compose.ui.b.f3540a, z13, oVar2);
                            p0Var2.e0(-1323940314);
                            int iE = b1.E(oVar2);
                            w2 w2VarO = p0Var2.o();
                            androidx.compose.ui.node.u.i.getClass();
                            l0 l0Var = androidx.compose.ui.node.t.f4279b;
                            androidx.compose.runtime.internal.e eVarM = androidx.compose.ui.layout.u.m(tVarA);
                            p0Var2.h0();
                            boolean z14 = z13;
                            if (p0Var2.M) {
                                p0Var2.n(l0Var);
                            } else {
                                p0Var2.t0();
                            }
                            b1.Y(oVar2, androidx.compose.ui.node.t.f4283f, k0VarC);
                            b1.Y(oVar2, androidx.compose.ui.node.t.f4282e, w2VarO);
                            androidx.compose.ui.node.m mVar = androidx.compose.ui.node.t.i;
                            if (p0Var2.M || !kotlin.jvm.internal.j.a(p0Var2.I(), Integer.valueOf(iE))) {
                                w0.u(iE, p0Var2, iE, mVar);
                            }
                            eVarM.invoke(new r3(oVar2), oVar2, Integer.valueOf(z14 ? 1 : 0));
                            p0Var2.e0(2058660585);
                            String strJ = "";
                            String strM = f0.a.m(MamiScreenKt.flag(serverRow.getCc()), "  ", serverRow.getCountry(), !kotlin.text.o.L0(serverRow.getCity()) ? v0.a.h(" · ", serverRow.getCity()) : "");
                            androidx.compose.ui.graphics.vector.f fVarV = k6.a.v();
                            if (kotlin.jvm.internal.j.a(serverRow.getId(), str)) {
                                p0Var2.e0(189018514);
                                red = Ios.INSTANCE.getGreen(oVar2, 6);
                                z10 = z14 ? 1 : 0;
                            } else {
                                z10 = z14 ? 1 : 0;
                                if (!serverRow.getSupported()) {
                                    i10 = 189019569;
                                } else if (serverRow.getMs() > 0) {
                                    p0Var2.e0(189020436);
                                    if (serverRow.getMs() < 700) {
                                        p0Var2.e0(189021010);
                                        red = Ios.INSTANCE.getGreen(oVar2, 6);
                                        z10 = false;
                                    } else {
                                        z10 = false;
                                        z10 = false;
                                        if (serverRow.getMs() < 1600) {
                                            p0Var2.e0(189022035);
                                            red = Ios.INSTANCE.getOrange(oVar2, 6);
                                        } else {
                                            p0Var2.e0(189022544);
                                            red = Ios.INSTANCE.getRed(oVar2, 6);
                                        }
                                    }
                                    p0Var2.u(z10);
                                } else {
                                    z10 = false;
                                    i10 = 189022993;
                                }
                                p0Var2.e0(i10);
                                red = Ios.INSTANCE.getGray(oVar2, 6);
                            }
                            p0Var2.u(z10);
                            if (kotlin.jvm.internal.j.a(serverRow.getId(), str)) {
                                strTr = StoreNetKt.tr("وصل", "on");
                            }
                            String strProfileWord = MamiScreenKt.profileWord(serverRow.getProfile(), serverRow.getProtocol());
                            String strH = !serverRow.getSupported() ? v0.a.h(" — ", serverRow.getWhy()) : "";
                            if (serverRow.getAt() > 0) {
                                strJ = g1.j(" · measured ", MamiScreenKt.whenWord(serverRow.getAt()), v0.a.h(" · سنجش ", MamiScreenKt.whenWord(serverRow.getAt())));
                            }
                            String str2 = strProfileWord + strH + strJ;
                            p0Var2.e0(189033923);
                            if (!serverRow.getSupported() || z12 || kotlin.jvm.internal.j.a(serverRow.getId(), str)) {
                                z11 = false;
                                aVar = null;
                            } else {
                                p0Var2.e0(189035813);
                                boolean zF = p0Var2.f(serverRow) | p0Var2.f(aVar2);
                                Object objI = p0Var2.I();
                                if (zF || objI == n.f3284a) {
                                    objI = new c(serverRow, aVar2, k2Var);
                                    p0Var2.r0(objI);
                                }
                                aVar = (ee.a) objI;
                                z11 = false;
                                p0Var2.u(false);
                            }
                            p0Var2.u(z11);
                            boolean z15 = z11;
                            IosSettingsKt.m863SettingsRowqhMrWXk(strM, fVarV, red, strTr, str2, 0L, false, aVar, 0, oVar2, 0, 352);
                            w0.z(p0Var2, z15, true, z15, z15);
                            oVar2 = oVar;
                            z13 = z15;
                            i12 = i13;
                            z12 = z12;
                            str = str;
                            k2Var = k2Var;
                            aVar2 = aVar2;
                            SettingsGroup = settingsGroupScope;
                        }
                        r0 r0Var2 = v0.f3474a;
                    }
                }

                @Override // ee.f
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((androidx.compose.foundation.layout.d0) obj, (o) obj2, ((Number) obj3).intValue());
                    return u.f67154a;
                }

                public final void invoke(androidx.compose.foundation.layout.d0 IosScreen, o oVar2, int i12) {
                    int i13;
                    kotlin.jvm.internal.j.e(IosScreen, "$this$IosScreen");
                    if ((i12 & 17) == 16) {
                        p0 p0Var2 = (p0) oVar2;
                        if (p0Var2.G()) {
                            p0Var2.Y();
                            return;
                        }
                    }
                    r0 r0Var2 = v0.f3474a;
                    androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
                    f0.e(oVar2, d3.g(qVar, 10));
                    IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 2108104840, new C01451(zA, context, list, k2VarX3)), oVar2, 384, 3);
                    List<MamiEngine.ServerRow> list2 = list;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        i13 = 0;
                    } else {
                        Iterator<T> it = list2.iterator();
                        i13 = 0;
                        while (it.hasNext()) {
                            if (((MamiEngine.ServerRow) it.next()).getMs() > 0 && (i13 = i13 + 1) < 0) {
                                r.e0();
                                throw null;
                            }
                        }
                    }
                    IosSettingsKt.SettingsFooter(StoreNetKt.tr(f0.a.m(MamiScreenKt.fa(i13), " سالم از ", MamiScreenKt.fa(list.size()), ". «سنجش» واقعی است، نه پینگ: هر سرور با Xray راه می\u200cافتد و یک درخواست واقعی HTTPS از داخلش فرستاده می\u200cشود. «خودکار» از میان همین\u200cها سریع\u200cترین را انتخاب می\u200cکند و اگر سروری وسط اتصال جواب ندهد، خودش به بعدی می\u200cرود."), i13 + " healthy of " + list.size() + ". A real test, not a ping: each server runs in Xray and a real HTTPS request goes through it. «Auto» picks the fastest of these, and moves on by itself if one stops answering."), oVar2, 0);
                    if (list.isEmpty()) {
                        p0 p0Var3 = (p0) oVar2;
                        p0Var3.e0(-982259079);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, ComposableSingletons$MamiScreenKt.INSTANCE.m775getLambda2$app_release(), oVar2, 384, 3);
                        p0Var3.u(false);
                    } else {
                        p0 p0Var4 = (p0) oVar2;
                        p0Var4.e0(-981962161);
                        IosSettingsKt.m862SettingsGroupuFdPcIQ(null, 0.0f, x6.p.f(oVar2, 1432083244, new AnonymousClass2(list, str, zA, aVarVpnLauncher, k2Var)), oVar2, 384, 3);
                        IosSettingsKt.SettingsFooter(StoreNetKt.tr("روی هر سرور بزنید تا با روش «خودکار» به همان وصل شوید.", "Tap a server to connect to it with «Auto»."), oVar2, 0);
                        p0Var4.u(false);
                    }
                    f0.e(oVar2, d3.g(qVar, 40));
                    r0 r0Var3 = v0.f3474a;
                }
            }), p0Var, ((i10 << 3) & 112) | 100663296, 248);
        }
        c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new b(i, i11, aVar2);
        }
    }

    private static final MamiEngine.Status MamiServers$lambda$74(l4 l4Var) {
        return (MamiEngine.Status) l4Var.getValue();
    }

    private static final int MamiServers$lambda$75(l4 l4Var) {
        return ((Number) l4Var.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MamiServers$lambda$76(l4 l4Var) {
        return (String) l4Var.getValue();
    }

    private static final String MamiServers$lambda$79(k2 k2Var) {
        return (String) k2Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MamiServers$lambda$80(k2 k2Var, String str) {
        k2Var.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiServers$lambda$82$lambda$81(Context context, k2 k2Var) {
        MamiEngine mamiEngine = MamiEngine.INSTANCE;
        MamiEngine.setPrefs$default(mamiEngine, "auto", null, null, 6, null);
        MamiEngine.connectAsync$default(mamiEngine, context, MamiServers$lambda$79(k2Var), null, 4, null);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MamiServers$lambda$83(ee.a aVar, int i, o oVar, int i10) {
        MamiServers(aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MethodRow(MamiEngine.Method method, boolean z10, boolean z11, ee.a aVar, o oVar, int i) {
        int i10;
        boolean z12;
        long label;
        p0 p0Var = (p0) oVar;
        p0Var.f0(1302764597);
        if ((i & 6) == 0) {
            i10 = (p0Var.f(method) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var.g(z10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= p0Var.g(z11) ? 256 : 128;
        }
        if ((i & MamiIdentity.RSA_BITS) == 0) {
            i10 |= p0Var.h(aVar) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            long jMethodTint = methodTint(method.getKey(), p0Var, 0);
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            t tVarW = f0.w(d3.e(qVar, 1.0f).i(z11 ? androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(3), aVar, 3) : qVar), 16, 10);
            androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
            p0Var.e0(-1323940314);
            int i11 = p0Var.N;
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
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i11))) {
                w0.u(i11, p0Var, i11, mVar);
            }
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
            t tVarF = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(d3.m(qVar, 29), e0.e.b(7)), jMethodTint, androidx.compose.ui.graphics.d0.f3719a);
            androidx.compose.ui.j jVar = androidx.compose.ui.b.f3544e;
            p0Var.e0(733328855);
            k0 k0VarC = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
            p0Var.e0(-1323940314);
            int i12 = p0Var.N;
            w2 w2VarO2 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarF);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarC);
            b1.Y(p0Var, rVar, w2VarO2);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i12))) {
                w0.u(i12, p0Var, i12, mVar);
            }
            w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
            androidx.compose.material3.c3.a(d2.B(p0Var, methodIcon(method.getKey())), null, d3.m(qVar, 19), v.f3795e, p0Var, 3504, 0);
            w0.z(p0Var, false, true, false, false);
            f0.e(p0Var, d3.p(qVar, 12));
            if (1.0f <= 0.0d) {
                throw new IllegalArgumentException(f0.a.k("invalid weight ", "; must be greater than zero", 1.0f).toString());
            }
            LayoutWeightElement layoutWeightElementA = com.mlmvpn.scanner.e.a(1.0f, true, p0Var, -483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, androidx.compose.ui.b.f3551w, p0Var);
            p0Var.e0(-1323940314);
            int i13 = p0Var.N;
            w2 w2VarO3 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(layoutWeightElementA);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar, k0VarA2);
            b1.Y(p0Var, rVar, w2VarO3);
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i13))) {
                w0.u(i13, p0Var, i13, mVar);
            }
            w0.x(p0Var, eVarM3, p0Var, 0, 2058660585);
            String strMethodName = methodName(method);
            if (z11 || z10) {
                z12 = false;
                p0Var.e0(1285454413);
                label = Ios.INSTANCE.getLabel(p0Var, 6);
            } else {
                p0Var.e0(1285454902);
                label = Ios.INSTANCE.getSecondaryLabel(p0Var, 6);
                z12 = false;
            }
            p0Var.u(z12);
            k9.b(strMethodName, null, label, x6.a.t(16), null, z10 ? w.f4817h : w.f4815e, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, MamiIdentity.RSA_BITS, 0, 131026);
            String strMethodAbout = methodAbout(method);
            Ios ios = Ios.INSTANCE;
            k9.b(strMethodAbout, null, ios.getSecondaryLabel(p0Var, 6), x6.a.s(12.5d), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, MamiIdentity.RSA_BITS, 0, 131058);
            p0Var = p0Var;
            w0.z(p0Var, false, true, false, false);
            p0Var.e0(288205237);
            if (z10) {
                androidx.compose.material3.c3.b(StoreNetKt.tr("انتخاب\u200cشده", "selected"), ios.getBlue(p0Var, 6), com.google.android.gms.internal.mlkit_common.u.p(), d3.m(qVar, 20), p0Var, 384, 0);
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
        }
        c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new t2(method, z10, z11, aVar, i, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u MethodRow$lambda$64(MamiEngine.Method method, boolean z10, boolean z11, ee.a aVar, int i, o oVar, int i10) {
        MethodRow(method, z10, z11, aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlaceRow(String str, String str2, String str3, boolean z10, boolean z11, ee.a aVar, o oVar, int i) {
        int i10;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-866485413);
        if ((i & 6) == 0) {
            i10 = (p0Var.f(str) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= p0Var.f(str2) ? 32 : 16;
        }
        if ((i & MamiIdentity.RSA_BITS) == 0) {
            i10 |= p0Var.g(z10) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= p0Var.g(z11) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= p0Var.h(aVar) ? 131072 : 65536;
        }
        if ((74771 & i10) == 74770 && p0Var.G()) {
            p0Var.Y();
        } else {
            r0 r0Var = v0.f3474a;
            androidx.compose.ui.q qVar = androidx.compose.ui.q.f4604b;
            t tVarW = f0.w(d3.e(qVar, 1.0f).i(z11 ? androidx.compose.foundation.p.l(qVar, false, new androidx.compose.ui.semantics.f(3), aVar, 3) : qVar), 16, 9);
            androidx.compose.ui.i iVar = androidx.compose.ui.b.f3549s;
            p0Var.e0(693286680);
            k0 k0VarA = a3.a(androidx.compose.foundation.layout.i.f2022a, iVar, p0Var);
            p0Var.e0(-1323940314);
            int i11 = p0Var.N;
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
            int i12 = i10;
            if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i11))) {
                w0.u(i11, p0Var, i11, mVar);
            }
            w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
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
            k9.b(str, null, ios.getLabel(p0Var, 6), x6.a.t(15), null, z10 ? w.f4817h : w.f4815e, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, (i12 & 14) | MamiIdentity.RSA_BITS, 0, 131026);
            p0Var = p0Var;
            p0Var.e0(-1843401097);
            if (!kotlin.text.o.L0(str2)) {
                k9.b(str2, null, ios.getSecondaryLabel(p0Var, 6), x6.a.t(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var, ((i12 >> 3) & 14) | MamiIdentity.RSA_BITS, 0, 131058);
                p0Var = p0Var;
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
            p0Var.e0(-461819027);
            if (z10) {
                androidx.compose.material3.c3.b(StoreNetKt.tr("انتخاب\u200cشده", "selected"), ios.getBlue(p0Var, 6), com.google.android.gms.internal.mlkit_common.u.p(), d3.m(qVar, 20), p0Var, 384, 0);
            }
            w0.z(p0Var, false, false, true, false);
            p0Var.u(false);
        }
        c3 c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new com.mlmvpn.scanner.ui.emergency.q(str, str2, str3, z10, z11, aVar, i, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u PlaceRow$lambda$67(String str, String str2, String str3, boolean z10, boolean z11, ee.a aVar, int i, o oVar, int i10) {
        PlaceRow(str, str2, str3, z10, z11, aVar, oVar, b1.b0(i | 1));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x0223  */
    /* JADX WARN: Code duplicated, block: B:104:0x022c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0256  */
    /* JADX WARN: Code duplicated, block: B:109:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:68:0x0109  */
    /* JADX WARN: Code duplicated, block: B:69:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0120  */
    /* JADX WARN: Code duplicated, block: B:74:0x012e  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0170  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:86:0x01be  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:94:0x0203  */
    /* JADX WARN: Code duplicated, block: B:97:0x0210  */
    public static final void PowerButton(final boolean z10, final boolean z11, boolean z12, final ee.a aVar, o oVar, final int i, final int i10) {
        int i11;
        boolean z13;
        int i12;
        boolean z14;
        long gray;
        String str;
        String str2;
        String strTr;
        androidx.compose.ui.q qVar;
        int i13;
        l0 l0Var;
        androidx.compose.ui.node.m mVar;
        float f8;
        boolean zF;
        Object objI;
        int i14;
        int i15;
        int i16;
        String str3;
        androidx.compose.ui.q qVar2;
        int i17;
        int i18;
        boolean z15;
        final boolean z16;
        c3 c3VarY;
        p0 p0Var = (p0) oVar;
        p0Var.f0(-1426155766);
        if ((i10 & 1) != 0) {
            i11 = i | 6;
        } else if ((i & 6) == 0) {
            i11 = (p0Var.g(z10) ? 4 : 2) | i;
        } else {
            i11 = i;
        }
        if ((i10 & 2) != 0) {
            i11 |= 48;
        } else if ((i & 48) == 0) {
            i11 |= p0Var.g(z11) ? 32 : 16;
        }
        int i19 = i10 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                z13 = z12;
                i11 |= p0Var.g(z13) ? 256 : 128;
            }
            if ((i10 & 8) != 0) {
                i11 |= MamiIdentity.RSA_BITS;
            } else if ((i & MamiIdentity.RSA_BITS) == 0) {
                if (p0Var.h(aVar)) {
                    i12 = 2048;
                } else {
                    i12 = 1024;
                }
                i11 |= i12;
            }
            if ((i11 & 1171) == 1170 || !p0Var.G()) {
                if (i19 != 0) {
                    z14 = false;
                } else {
                    z14 = z13;
                }
                r0 r0Var = v0.f3474a;
                if (z10) {
                    p0Var.e0(-1039412243);
                    gray = Ios.INSTANCE.getGreen(p0Var, 6);
                } else if (z11) {
                    p0Var.e0(-1039411634);
                    gray = Ios.INSTANCE.getOrange(p0Var, 6);
                } else {
                    p0Var.e0(-1039410996);
                    gray = Ios.INSTANCE.getGray(p0Var, 6);
                }
                p0Var.u(false);
                if (!z10 || z11) {
                    str = "قطع";
                    str2 = "Disconnect";
                } else {
                    str = "اتصال";
                    str2 = "Connect";
                }
                strTr = StoreNetKt.tr(str, str2);
                qVar = androidx.compose.ui.q.f4604b;
                t tVarE = d3.e(qVar, 1.0f);
                androidx.compose.ui.j jVar = androidx.compose.ui.b.f3544e;
                p0Var.e0(733328855);
                k0 k0VarC = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
                p0Var.e0(-1323940314);
                i13 = p0Var.N;
                w2 w2VarO = p0Var.o();
                androidx.compose.ui.node.u.i.getClass();
                l0Var = androidx.compose.ui.node.t.f4279b;
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
                mVar = androidx.compose.ui.node.t.i;
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i13))) {
                    w0.u(i13, p0Var, i13, mVar);
                }
                w0.x(p0Var, eVarM, p0Var, 0, 2058660585);
                t tVarM = d3.m(qVar, 132);
                e0.d dVar = e0.e.f17770a;
                t tVarF = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(tVarM, dVar), v.c(0.18f, gray), androidx.compose.ui.graphics.d0.f3719a);
                f8 = 3;
                t tVarH = androidx.compose.foundation.p.h(tVarF, f8, gray, dVar);
                p0Var.e0(-1586629307);
                zF = p0Var.f(strTr);
                objI = p0Var.I();
                i14 = 1;
                if (zF || objI == n.f3284a) {
                    objI = new a(strTr, i14);
                    p0Var.r0(objI);
                }
                p0Var.u(false);
                t tVarL = androidx.compose.foundation.p.l(androidx.compose.ui.semantics.k.a(tVarH, false, (ee.c) objI), false, new androidx.compose.ui.semantics.f(0), aVar, 3);
                p0Var.e0(733328855);
                k0 k0VarC2 = androidx.compose.foundation.layout.t.c(jVar, false, p0Var);
                p0Var.e0(-1323940314);
                i15 = p0Var.N;
                w2 w2VarO2 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM2 = androidx.compose.ui.layout.u.m(tVarL);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, pVar, k0VarC2);
                b1.Y(p0Var, rVar, w2VarO2);
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i15))) {
                    w0.u(i15, p0Var, i15, mVar);
                }
                w0.x(p0Var, eVarM2, p0Var, 0, 2058660585);
                androidx.compose.ui.h hVar = androidx.compose.ui.b.x;
                p0Var.e0(-483455358);
                k0 k0VarA = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar, p0Var);
                p0Var.e0(-1323940314);
                i16 = p0Var.N;
                w2 w2VarO3 = p0Var.o();
                androidx.compose.runtime.internal.e eVarM3 = androidx.compose.ui.layout.u.m(qVar);
                p0Var.h0();
                if (p0Var.M) {
                    p0Var.n(l0Var);
                } else {
                    p0Var.t0();
                }
                b1.Y(p0Var, pVar, k0VarA);
                b1.Y(p0Var, rVar, w2VarO3);
                if (p0Var.M || !kotlin.jvm.internal.j.a(p0Var.I(), Integer.valueOf(i16))) {
                    w0.u(i16, p0Var, i16, mVar);
                }
                w0.x(p0Var, eVarM3, p0Var, 0, 2058660585);
                if (z14) {
                    p0Var.e0(1664855350);
                    qVar2 = qVar;
                    str3 = strTr;
                    i17 = 4;
                    i18 = 6;
                    z15 = true;
                    f5.b(f8, 0, 390, 24, gray, 0L, p0Var, d3.m(qVar, 40));
                    p0Var = p0Var;
                    p0Var.u(false);
                } else {
                    str3 = strTr;
                    qVar2 = qVar;
                    i17 = 4;
                    i18 = 6;
                    z15 = true;
                    p0Var.e0(71011344);
                    androidx.compose.material3.c3.b(null, gray, ge.a.v(), d3.m(qVar2, 44), p0Var, 432, 0);
                    p0Var.u(false);
                }
                f0.e(p0Var, d3.g(qVar2, i17));
                p0 p0Var2 = p0Var;
                k9.b(str3, null, Ios.INSTANCE.getLabel(p0Var, i18), x6.a.t(14), null, w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var2, 199680, 0, 131026);
                p0Var = p0Var2;
                w0.z(p0Var, false, z15, false, false);
                w0.z(p0Var, false, z15, false, false);
                w0.z(p0Var, false, z15, false, false);
                z16 = z14;
            } else {
                p0Var.Y();
                z16 = z13;
            }
            c3VarY = p0Var.y();
            if (c3VarY != null) {
                c3VarY.f3186d = new ee.e() { // from class: com.mlmvpn.scanner.ui.mami.e
                    @Override // ee.e
                    public final Object invoke(Object obj, Object obj2) {
                        int iIntValue = ((Integer) obj2).intValue();
                        return MamiScreenKt.PowerButton$lambda$73(z10, z11, z16, aVar, i, i10, (o) obj, iIntValue);
                    }
                };
            }
        }
        i11 |= 384;
        z13 = z12;
        if ((i10 & 8) != 0) {
            i11 |= MamiIdentity.RSA_BITS;
        } else if ((i & MamiIdentity.RSA_BITS) == 0) {
            if (p0Var.h(aVar)) {
                i12 = 2048;
            } else {
                i12 = 1024;
            }
            i11 |= i12;
        }
        if ((i11 & 1171) == 1170) {
            if (i19 != 0) {
                z14 = false;
            } else {
                z14 = z13;
            }
            r0 r0Var2 = v0.f3474a;
            if (z10) {
                p0Var.e0(-1039412243);
                gray = Ios.INSTANCE.getGreen(p0Var, 6);
            } else if (z11) {
                p0Var.e0(-1039411634);
                gray = Ios.INSTANCE.getOrange(p0Var, 6);
            } else {
                p0Var.e0(-1039410996);
                gray = Ios.INSTANCE.getGray(p0Var, 6);
            }
            p0Var.u(false);
            if (z10) {
                str = "قطع";
                str2 = "Disconnect";
            } else {
                str = "قطع";
                str2 = "Disconnect";
            }
            strTr = StoreNetKt.tr(str, str2);
            qVar = androidx.compose.ui.q.f4604b;
            t tVarE2 = d3.e(qVar, 1.0f);
            androidx.compose.ui.j jVar2 = androidx.compose.ui.b.f3544e;
            p0Var.e0(733328855);
            k0 k0VarC3 = androidx.compose.foundation.layout.t.c(jVar2, false, p0Var);
            p0Var.e0(-1323940314);
            i13 = p0Var.N;
            w2 w2VarO4 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM4 = androidx.compose.ui.layout.u.m(tVarE2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar2 = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar2, k0VarC3);
            androidx.compose.ui.node.r rVar2 = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar2, w2VarO4);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i13, p0Var, i13, mVar);
            } else {
                w0.u(i13, p0Var, i13, mVar);
            }
            w0.x(p0Var, eVarM4, p0Var, 0, 2058660585);
            t tVarM2 = d3.m(qVar, 132);
            e0.d dVar2 = e0.e.f17770a;
            t tVarF2 = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(tVarM2, dVar2), v.c(0.18f, gray), androidx.compose.ui.graphics.d0.f3719a);
            f8 = 3;
            t tVarH2 = androidx.compose.foundation.p.h(tVarF2, f8, gray, dVar2);
            p0Var.e0(-1586629307);
            zF = p0Var.f(strTr);
            objI = p0Var.I();
            i14 = 1;
            if (zF) {
                objI = new a(strTr, i14);
                p0Var.r0(objI);
            } else {
                objI = new a(strTr, i14);
                p0Var.r0(objI);
            }
            p0Var.u(false);
            t tVarL2 = androidx.compose.foundation.p.l(androidx.compose.ui.semantics.k.a(tVarH2, false, (ee.c) objI), false, new androidx.compose.ui.semantics.f(0), aVar, 3);
            p0Var.e0(733328855);
            k0 k0VarC4 = androidx.compose.foundation.layout.t.c(jVar2, false, p0Var);
            p0Var.e0(-1323940314);
            i15 = p0Var.N;
            w2 w2VarO5 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM5 = androidx.compose.ui.layout.u.m(tVarL2);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar2, k0VarC4);
            b1.Y(p0Var, rVar2, w2VarO5);
            if (p0Var.M) {
                w0.u(i15, p0Var, i15, mVar);
            } else {
                w0.u(i15, p0Var, i15, mVar);
            }
            w0.x(p0Var, eVarM5, p0Var, 0, 2058660585);
            androidx.compose.ui.h hVar2 = androidx.compose.ui.b.x;
            p0Var.e0(-483455358);
            k0 k0VarA2 = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar2, p0Var);
            p0Var.e0(-1323940314);
            i16 = p0Var.N;
            w2 w2VarO6 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM6 = androidx.compose.ui.layout.u.m(qVar);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar2, k0VarA2);
            b1.Y(p0Var, rVar2, w2VarO6);
            if (p0Var.M) {
                w0.u(i16, p0Var, i16, mVar);
            } else {
                w0.u(i16, p0Var, i16, mVar);
            }
            w0.x(p0Var, eVarM6, p0Var, 0, 2058660585);
            if (z14) {
                p0Var.e0(1664855350);
                qVar2 = qVar;
                str3 = strTr;
                i17 = 4;
                i18 = 6;
                z15 = true;
                f5.b(f8, 0, 390, 24, gray, 0L, p0Var, d3.m(qVar, 40));
                p0Var = p0Var;
                p0Var.u(false);
            } else {
                str3 = strTr;
                qVar2 = qVar;
                i17 = 4;
                i18 = 6;
                z15 = true;
                p0Var.e0(71011344);
                androidx.compose.material3.c3.b(null, gray, ge.a.v(), d3.m(qVar2, 44), p0Var, 432, 0);
                p0Var.u(false);
            }
            f0.e(p0Var, d3.g(qVar2, i17));
            p0 p0Var3 = p0Var;
            k9.b(str3, null, Ios.INSTANCE.getLabel(p0Var, i18), x6.a.t(14), null, w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var3, 199680, 0, 131026);
            p0Var = p0Var3;
            w0.z(p0Var, false, z15, false, false);
            w0.z(p0Var, false, z15, false, false);
            w0.z(p0Var, false, z15, false, false);
            z16 = z14;
        } else {
            if (i19 != 0) {
                z14 = false;
            } else {
                z14 = z13;
            }
            r0 r0Var3 = v0.f3474a;
            if (z10) {
                p0Var.e0(-1039412243);
                gray = Ios.INSTANCE.getGreen(p0Var, 6);
            } else if (z11) {
                p0Var.e0(-1039411634);
                gray = Ios.INSTANCE.getOrange(p0Var, 6);
            } else {
                p0Var.e0(-1039410996);
                gray = Ios.INSTANCE.getGray(p0Var, 6);
            }
            p0Var.u(false);
            if (z10) {
                str = "قطع";
                str2 = "Disconnect";
            } else {
                str = "قطع";
                str2 = "Disconnect";
            }
            strTr = StoreNetKt.tr(str, str2);
            qVar = androidx.compose.ui.q.f4604b;
            t tVarE3 = d3.e(qVar, 1.0f);
            androidx.compose.ui.j jVar3 = androidx.compose.ui.b.f3544e;
            p0Var.e0(733328855);
            k0 k0VarC5 = androidx.compose.foundation.layout.t.c(jVar3, false, p0Var);
            p0Var.e0(-1323940314);
            i13 = p0Var.N;
            w2 w2VarO7 = p0Var.o();
            androidx.compose.ui.node.u.i.getClass();
            l0Var = androidx.compose.ui.node.t.f4279b;
            androidx.compose.runtime.internal.e eVarM7 = androidx.compose.ui.layout.u.m(tVarE3);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            androidx.compose.ui.node.p pVar3 = androidx.compose.ui.node.t.f4283f;
            b1.Y(p0Var, pVar3, k0VarC5);
            androidx.compose.ui.node.r rVar3 = androidx.compose.ui.node.t.f4282e;
            b1.Y(p0Var, rVar3, w2VarO7);
            mVar = androidx.compose.ui.node.t.i;
            if (p0Var.M) {
                w0.u(i13, p0Var, i13, mVar);
            } else {
                w0.u(i13, p0Var, i13, mVar);
            }
            w0.x(p0Var, eVarM7, p0Var, 0, 2058660585);
            t tVarM3 = d3.m(qVar, 132);
            e0.d dVar3 = e0.e.f17770a;
            t tVarF3 = androidx.compose.foundation.p.f(androidx.compose.ui.draw.h.b(tVarM3, dVar3), v.c(0.18f, gray), androidx.compose.ui.graphics.d0.f3719a);
            f8 = 3;
            t tVarH3 = androidx.compose.foundation.p.h(tVarF3, f8, gray, dVar3);
            p0Var.e0(-1586629307);
            zF = p0Var.f(strTr);
            objI = p0Var.I();
            i14 = 1;
            if (zF) {
                objI = new a(strTr, i14);
                p0Var.r0(objI);
            } else {
                objI = new a(strTr, i14);
                p0Var.r0(objI);
            }
            p0Var.u(false);
            t tVarL3 = androidx.compose.foundation.p.l(androidx.compose.ui.semantics.k.a(tVarH3, false, (ee.c) objI), false, new androidx.compose.ui.semantics.f(0), aVar, 3);
            p0Var.e0(733328855);
            k0 k0VarC6 = androidx.compose.foundation.layout.t.c(jVar3, false, p0Var);
            p0Var.e0(-1323940314);
            i15 = p0Var.N;
            w2 w2VarO8 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM8 = androidx.compose.ui.layout.u.m(tVarL3);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar3, k0VarC6);
            b1.Y(p0Var, rVar3, w2VarO8);
            if (p0Var.M) {
                w0.u(i15, p0Var, i15, mVar);
            } else {
                w0.u(i15, p0Var, i15, mVar);
            }
            w0.x(p0Var, eVarM8, p0Var, 0, 2058660585);
            androidx.compose.ui.h hVar3 = androidx.compose.ui.b.x;
            p0Var.e0(-483455358);
            k0 k0VarA3 = c0.a(androidx.compose.foundation.layout.i.f2024c, hVar3, p0Var);
            p0Var.e0(-1323940314);
            i16 = p0Var.N;
            w2 w2VarO9 = p0Var.o();
            androidx.compose.runtime.internal.e eVarM9 = androidx.compose.ui.layout.u.m(qVar);
            p0Var.h0();
            if (p0Var.M) {
                p0Var.n(l0Var);
            } else {
                p0Var.t0();
            }
            b1.Y(p0Var, pVar3, k0VarA3);
            b1.Y(p0Var, rVar3, w2VarO9);
            if (p0Var.M) {
                w0.u(i16, p0Var, i16, mVar);
            } else {
                w0.u(i16, p0Var, i16, mVar);
            }
            w0.x(p0Var, eVarM9, p0Var, 0, 2058660585);
            if (z14) {
                p0Var.e0(1664855350);
                qVar2 = qVar;
                str3 = strTr;
                i17 = 4;
                i18 = 6;
                z15 = true;
                f5.b(f8, 0, 390, 24, gray, 0L, p0Var, d3.m(qVar, 40));
                p0Var = p0Var;
                p0Var.u(false);
            } else {
                str3 = strTr;
                qVar2 = qVar;
                i17 = 4;
                i18 = 6;
                z15 = true;
                p0Var.e0(71011344);
                androidx.compose.material3.c3.b(null, gray, ge.a.v(), d3.m(qVar2, 44), p0Var, 432, 0);
                p0Var.u(false);
            }
            f0.e(p0Var, d3.g(qVar2, i17));
            p0 p0Var4 = p0Var;
            k9.b(str3, null, Ios.INSTANCE.getLabel(p0Var, i18), x6.a.t(14), null, w.f4817h, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, p0Var4, 199680, 0, 131026);
            p0Var = p0Var4;
            w0.z(p0Var, false, z15, false, false);
            w0.z(p0Var, false, z15, false, false);
            w0.z(p0Var, false, z15, false, false);
            z16 = z14;
        }
        c3VarY = p0Var.y();
        if (c3VarY != null) {
            c3VarY.f3186d = new ee.e() { // from class: com.mlmvpn.scanner.ui.mami.e
                @Override // ee.e
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return MamiScreenKt.PowerButton$lambda$73(z10, z11, z16, aVar, i, i10, (o) obj, iIntValue);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u PowerButton$lambda$72$lambda$69$lambda$68(String str, j0 semantics) {
        kotlin.jvm.internal.j.e(semantics, "$this$semantics");
        g0.c(str, semantics);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u PowerButton$lambda$73(boolean z10, boolean z11, boolean z12, ee.a aVar, int i, int i10, o oVar, int i11) {
        PowerButton(z10, z11, z12, aVar, oVar, b1.b0(i | 1), i10);
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String catalogLine(MamiEngine.CatalogInfo catalogInfo) {
        String strG;
        String strTr;
        if (catalogInfo == null) {
            return StoreNetKt.tr("هنوز فهرستی گرفته نشده.", "No list yet.");
        }
        if (catalogInfo.getSkipped() > 0) {
            strG = com.mlmvpn.core.aether.i.g(" (", catalogInfo.getSkipped(), " invalid left out)", w0.n(" (", fa(catalogInfo.getSkipped()), " سرور نامعتبر کنار گذاشته شد)"));
        } else {
            strG = "";
        }
        if (catalogInfo.getFresh()) {
            strTr = g1.j("valid until ", whenWord(catalogInfo.getExpiresAt()), v0.a.h("معتبر تا ", whenWord(catalogInfo.getExpiresAt())));
        } else {
            strTr = StoreNetKt.tr("منقضی — اتصال بعدی فهرست تازه می\u200cگیرد", "expired — the next connect fetches a new one");
        }
        return StoreNetKt.tr(w0.r(d1.k(fa(catalogInfo.getServers()), " سرور", strG, " · گرفته\u200cشده ", whenWord(catalogInfo.getFetchedAt())), " · ", strTr), catalogInfo.getServers() + " servers" + strG + " · fetched " + whenWord(catalogInfo.getFetchedAt()) + " · " + strTr);
    }

    private static final String country(String str) {
        if (kotlin.text.o.L0(str) || kotlin.jvm.internal.j.a(str, "??")) {
            return StoreNetKt.tr("نامعلوم", "unknown");
        }
        String displayCountry = new Locale("", str).getDisplayCountry(Locale.getDefault());
        return kotlin.text.o.L0(displayCountry) ? str : displayCountry;
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
    public static final String getTITLE() {
        return StoreNetKt.tr("مامی", "Mami");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String headLine(MamiEngine.Status status, MamiEngine.Method method) {
        MamiEngine.Method method2 = MamiEngine.INSTANCE.method(status.getMethod());
        if (method2 != null) {
            method = method2;
        }
        String phase = status.getPhase();
        int iHashCode = phase.hashCode();
        if (iHashCode != -775651656) {
            if (iHashCode != 3551) {
                if (iHashCode != 3327780) {
                    if (iHashCode == 1715648628 && phase.equals("stopping")) {
                        return StoreNetKt.tr("در حال قطع…", "Disconnecting…");
                    }
                } else if (phase.equals("lost")) {
                    return StoreNetKt.tr("اتصال دیگر داده رد نمی\u200cکند", "The connection no longer carries data");
                }
            } else if (phase.equals("on")) {
                return g1.j("Connected — ", methodName(method), v0.a.h("وصل — ", methodName(method)));
            }
        } else if (phase.equals(TunnelVpnService.STATUS_CONNECTING)) {
            return com.mlmvpn.core.aether.i.i("Connecting — ", methodName(method), "…", w0.n("در حال اتصال — ", methodName(method), "…"));
        }
        return getTITLE();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final String methodAbout(MamiEngine.Method method) {
        String key = method.getKey();
        switch (key.hashCode()) {
            case -1077557844:
                if (key.equals("meteor")) {
                    return StoreNetKt.tr(method.getAbout(), "A worldwide network with hidden paths");
                }
                break;
            case 3005871:
                if (key.equals("auto")) {
                    return StoreNetKt.tr(method.getAbout(), "The best server of Mami's sealed list, by a real delay test");
                }
                break;
            case 3202928:
                if (key.equals("hive")) {
                    return StoreNetKt.tr(method.getAbout(), "Bridges other devices have tested");
                }
                break;
            case 109549001:
                if (key.equals("smart")) {
                    return StoreNetKt.tr(method.getAbout(), "Finds the best way by itself");
                }
                break;
            case 1686617758:
                if (key.equals("exclusive")) {
                    return StoreNetKt.tr(method.getAbout(), "A bridge Mami's server makes for this device alone");
                }
                break;
        }
        return StoreNetKt.tr(method.getAbout(), "Anonymous and many-layered, with its own bridges");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final int methodIcon(String str) {
        switch (str.hashCode()) {
            case -1077557844:
                if (str.equals("meteor")) {
                    return R.drawable.ic_mami_m_meteor;
                }
                break;
            case 115031:
                if (str.equals("tor")) {
                    return R.drawable.ic_mami_m_tor;
                }
                break;
            case 3202928:
                if (str.equals("hive")) {
                    return R.drawable.ic_mami_m_hive;
                }
                break;
            case 109549001:
                if (str.equals("smart")) {
                    return R.drawable.ic_mami_m_smart;
                }
                break;
            case 1686617758:
                if (str.equals("exclusive")) {
                    return R.drawable.ic_mami_m_exclusive;
                }
                break;
        }
        return R.drawable.ic_mami_m_auto;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String methodName(MamiEngine.Method method) {
        String key = method.getKey();
        switch (key.hashCode()) {
            case -1077557844:
                if (key.equals("meteor")) {
                    return StoreNetKt.tr(method.getName(), "Sun");
                }
                break;
            case 3005871:
                if (key.equals("auto")) {
                    return StoreNetKt.tr(method.getName(), "Auto");
                }
                break;
            case 3202928:
                if (key.equals("hive")) {
                    return StoreNetKt.tr(method.getName(), "Lion");
                }
                break;
            case 109549001:
                if (key.equals("smart")) {
                    return StoreNetKt.tr(method.getName(), "Smart");
                }
                break;
            case 1686617758:
                if (key.equals("exclusive")) {
                    return StoreNetKt.tr(method.getName(), "Exclusive");
                }
                break;
        }
        return StoreNetKt.tr(method.getName(), "Tiger");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0085  */
    private static final long methodTint(String str, o oVar, int i) {
        long green;
        p0 p0Var = (p0) oVar;
        p0Var.e0(934911603);
        r0 r0Var = v0.f3474a;
        switch (str) {
            case "meteor":
                p0Var.e0(-448815727);
                green = Ios.INSTANCE.getYellow(p0Var, 6);
                p0Var.u(false);
                break;
            case "tor":
                p0Var.e0(-448813391);
                green = Ios.INSTANCE.getPurple(p0Var, 6);
                p0Var.u(false);
                break;
            case "hive":
                p0Var.e0(-448814929);
                green = Ios.INSTANCE.getPink(p0Var, 6);
                p0Var.u(false);
                break;
            case "smart":
                p0Var.e0(-448814159);
                green = Ios.INSTANCE.getIndigo(p0Var, 6);
                p0Var.u(false);
                break;
            case "exclusive":
                p0Var.e0(-448816591);
                green = Ios.INSTANCE.getOrange(p0Var, 6);
                p0Var.u(false);
                break;
            default:
                p0Var.e0(-448812656);
                green = Ios.INSTANCE.getGreen(p0Var, 6);
                p0Var.u(false);
                break;
        }
        p0Var.u(false);
        return green;
    }

    private static final String offLine(MamiEngine.Method method, MamiEngine.Prefs prefs, MamiEngine.CatalogInfo catalogInfo, MamiEngine.HiveInfo hiveInfo, List<MamiEngine.PlaceRow> list) {
        Object next;
        if (kotlin.jvm.internal.j.a(method.getKind(), WarpIdRelay.VIA_FRONT)) {
            return StoreNetKt.tr(d1.h("روش «", method.getName(), "» — ", method.getAbout(), ". یک ضربه وصل می\u200cشود؛ مسیر: تونل کامل."), d1.h("«", methodName(method), "» — ", methodAbout(method), ". One tap connects; path: full tunnel."));
        }
        if (kotlin.jvm.internal.j.a(method.getKey(), "exclusive")) {
            return StoreNetKt.tr("روش «اختصاصی» — پلی که سرور مامی فقط برای همین دستگاه می\u200cسازد. یک ضربه: پل گرفته می\u200cشود، با آن احراز هویت می\u200cشود و اتصال فقط وقتی «وصل» است که داده واقعاً رد شود.", "«Exclusive» — a bridge Mami's server makes for this device alone. One tap: the bridge is fetched, authenticated, and it is «connected» only once data really passes.");
        }
        if (kotlin.jvm.internal.j.a(method.getKey(), "hive")) {
            if (hiveInfo == null || hiveInfo.getServers() <= 0) {
                return StoreNetKt.tr("روش «لیون» — اولین اتصال فهرست پل\u200cهایی را که دستگاه\u200cهای دیگر آزموده\u200cاند از سرور مامی می\u200cگیرد، می\u200cسنجد و به بهترین وصل می\u200cشود.", "«Lion» — the first connect fetches the bridges other devices tested, measures them and connects to the best.");
            }
            return com.mlmvpn.core.aether.i.g("«Lion» — ", hiveInfo.getServers(), " bridges other devices tested. One tap: they are measured and the best that really carries data connects.", w0.n("روش «لیون» — ", fa(hiveInfo.getServers()), " پل که دستگاه\u200cهای دیگر آزموده\u200cاند. یک ضربه: پل\u200cها سنجیده می\u200cشوند و بهترینی که واقعاً داده رد کند وصل می\u200cشود."));
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.j.a(((MamiEngine.PlaceRow) next).getId(), prefs.getLocation()) && !kotlin.text.o.L0(prefs.getLocation())) {
                break;
            }
        }
        MamiEngine.PlaceRow placeRow = (MamiEngine.PlaceRow) next;
        if (catalogInfo == null || catalogInfo.getServers() <= 0) {
            return StoreNetKt.tr("روش «خودکار» — اولین اتصال فهرست رمزشده و امضاشدهٔ سرورها را از سرور مامی می\u200cگیرد، سرورها را می\u200cسنجد و به سریع\u200cترین وصل می\u200cشود.", "«Auto» — the first connect fetches Mami's sealed, signed server list, measures the servers and connects to the fastest.");
        }
        return StoreNetKt.tr(d1.h("روش «خودکار» — ", fa(catalogInfo.getServers()), " سرور در فهرست مامی", placeRow != null ? d1.g("؛ مکان: ", placeRow.getCountry(), " · ", placeRow.getCity()) : "", ". یک ضربه: سرورها سنجیده می\u200cشوند و سریع\u200cترینی که واقعاً داده رد کند وصل می\u200cشود."), "«Auto» — " + catalogInfo.getServers() + " servers in Mami's list" + (placeRow != null ? d1.g("; place: ", placeRow.getCountry(), " · ", placeRow.getCity()) : "") + ". One tap: they are measured and the fastest that really carries data connects.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String profileWord(String str, String str2) {
        String str3 = PROFILE_WORDS.get(str);
        if (str3 == null) {
            return f0.a.l(str, " · ", kotlin.jvm.internal.j.a(str2, "trojan") ? "Trojan" : "VLESS");
        }
        return str3;
    }

    private static final String serverWord(MamiEngine.ServerRef serverRef) {
        if (serverRef == null) {
            return "";
        }
        return f0.a.m(flag(serverRef.getCc()), " ", serverRef.getCountry(), kotlin.text.o.L0(serverRef.getCity()) ? "" : v0.a.h(" · ", serverRef.getCity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String statusLine(MamiEngine.Status status, MamiEngine.Method method, MamiEngine.Prefs prefs, MamiEngine.CatalogInfo catalogInfo, MamiEngine.HiveInfo hiveInfo, List<MamiEngine.PlaceRow> list) {
        String strP;
        String strTr;
        String str;
        String str2;
        String strServerWord = serverWord(status.getServer());
        String phase = status.getPhase();
        int iHashCode = phase.hashCode();
        if (iHashCode != -775651656) {
            if (iHashCode != 3551) {
                if (iHashCode != 3327780) {
                    if (iHashCode == 1715648628 && phase.equals("stopping")) {
                        return "";
                    }
                } else if (phase.equals("lost")) {
                    return f0.a.l(!kotlin.text.o.L0(strServerWord) ? v0.a.p(strServerWord, " — ") : "", StoreNetKt.tr("دو آزمون پیاپی جواب نداد.", "Two checks in a row got no answer."), kotlin.jvm.internal.j.a(status.getMethod(), "auto") ? StoreNetKt.tr(" اگر ادامه پیدا کند «خودکار» خودش به سرور بعدی می\u200cرود.", " If it goes on, «Auto» moves to the next server by itself.") : "");
                }
            } else if (phase.equals("on")) {
                MamiEngine.Exit exit = status.getExit();
                String strTr2 = (exit == null || kotlin.text.o.L0(exit.getLoc()) || kotlin.jvm.internal.j.a(exit.getLoc(), "??")) ? StoreNetKt.tr("وصل", TunnelVpnService.STATUS_CONNECTED) : g1.j("exit in ", country(exit.getLoc()), v0.a.h("خروج از ", country(exit.getLoc())));
                String strJ = (exit == null || kotlin.text.o.L0(exit.getIp())) ? "" : g1.j(" · IP ", exit.getIp(), v0.a.h(" · آی\u200cپی ", exit.getIp()));
                if (exit == null || exit.getMs() <= 0) {
                    strTr = "";
                } else {
                    strTr = StoreNetKt.tr(w0.n(" · ", fa(exit.getMs()), " میلی\u200cثانیه"), " · " + exit.getMs() + " ms");
                }
                strP = kotlin.text.o.L0(strServerWord) ? "" : v0.a.p(strServerWord, " · ");
                if (status.getMode() == MamiEngine.Mode.TUNNEL) {
                    str = "تونل کامل";
                    str2 = "full tunnel";
                } else {
                    str = "پراکسی";
                    str2 = WarpIdRelay.VIA_PROXY;
                }
                return w0.r(d1.k(strP, strTr2, strJ, strTr, " — "), StoreNetKt.tr(str, str2), StoreNetKt.tr(". هر دقیقه یک درخواست واقعی از داخل اتصال فرستاده می\u200cشود.", ". A real request goes through it every minute."));
            }
        } else if (phase.equals(TunnelVpnService.STATUS_CONNECTING)) {
            String strG = status.getAttempt() > 1 ? com.mlmvpn.core.aether.i.g(" (server ", status.getAttempt(), ")", w0.n(" (سرور ", fa(status.getAttempt()), ")")) : "";
            strP = kotlin.text.o.L0(strServerWord) ? "" : v0.a.p(strServerWord, " — ");
            String stepWord = status.getStepWord();
            if (kotlin.text.o.L0(stepWord)) {
                stepWord = StoreNetKt.tr("در حال اتصال…", "Connecting…");
            }
            return strP + ((Object) stepWord) + strG;
        }
        return offLine(method, prefs, catalogInfo, hiveInfo, list);
    }

    private static final ee.a vpnLauncher(ee.a aVar, o oVar, int i) {
        p0 p0Var = (p0) oVar;
        p0Var.e0(1999157007);
        r0 r0Var = v0.f3474a;
        Context context = (Context) p0Var.l(w1.f4590b);
        h0 h0Var = new h0(false);
        p0Var.e0(1665461137);
        int i10 = (i & 14) ^ 6;
        int i11 = 1;
        boolean z10 = (i10 > 4 && p0Var.f(aVar)) || (i & 6) == 4;
        Object objI = p0Var.I();
        e2 e2Var = n.f3284a;
        if (z10 || objI == e2Var) {
            objI = new a(aVar, 2);
            p0Var.r0(objI);
        }
        p0Var.u(false);
        androidx.activity.compose.n nVarC = com.google.android.gms.internal.mlkit_language_id_common.j.C(h0Var, (ee.c) objI, p0Var, 0);
        p0Var.e0(1665464154);
        boolean zH = ((i10 > 4 && p0Var.f(aVar)) || (i & 6) == 4) | p0Var.h(context) | p0Var.h(nVarC);
        Object objI2 = p0Var.I();
        if (zH || objI2 == e2Var) {
            objI2 = new c(context, nVarC, aVar, i11);
            p0Var.r0(objI2);
        }
        ee.a aVar2 = (ee.a) objI2;
        p0Var.u(false);
        p0Var.u(false);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u vpnLauncher$lambda$21$lambda$20(ee.a aVar, e.a res) {
        kotlin.jvm.internal.j.e(res, "res");
        if (res.f17738a == -1) {
            aVar.invoke();
        }
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u vpnLauncher$lambda$24$lambda$23(Context context, androidx.activity.compose.n nVar, ee.a aVar) {
        ScanGuard.INSTANCE.run(ScanGuard.Reason.CONNECT_VPN, new c(context, nVar, aVar, 0));
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u vpnLauncher$lambda$24$lambda$23$lambda$22(Context context, androidx.activity.compose.n nVar, ee.a aVar) {
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
        return u.f67154a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String whenWord(long j) {
        if (j <= 0) {
            return "—";
        }
        if (j < 1000000000000L) {
            j *= (long) 1000;
        }
        long jRound = Math.round((System.currentTimeMillis() - j) / 60000.0d);
        if (jRound >= 0) {
            if (jRound < 1) {
                return StoreNetKt.tr("همین حالا", "just now");
            }
            if (jRound < 60) {
                return g1.h(jRound, " min ago", v0.a.p(fa(jRound), " دقیقه پیش"));
            }
            if (jRound < 1440) {
                double d10 = jRound / 60.0d;
                return g1.h(Math.round(d10), " h ago", v0.a.p(fa(Math.round(d10)), " ساعت پیش"));
            }
            double d11 = jRound / 1440.0d;
            return g1.h(Math.round(d11), " days ago", v0.a.p(fa(Math.round(d11)), " روز پیش"));
        }
        long j10 = -jRound;
        if (j10 < 60) {
            return StoreNetKt.tr(v0.a.p(fa(j10), " دقیقهٔ دیگر"), "in " + j10 + " min");
        }
        if (j10 < 1440) {
            double d12 = j10 / 60.0d;
            return StoreNetKt.tr(v0.a.p(fa(Math.round(d12)), " ساعت دیگر"), "in " + Math.round(d12) + " h");
        }
        double d13 = j10 / 1440.0d;
        return StoreNetKt.tr(v0.a.p(fa(Math.round(d13)), " روز دیگر"), "in " + Math.round(d13) + " days");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fa(int i) {
        return fa(i);
    }
}
