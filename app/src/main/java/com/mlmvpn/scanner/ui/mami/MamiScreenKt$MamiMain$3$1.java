package com.mlmvpn.scanner.ui.mami;

import a6.w0;
import androidx.compose.runtime.k2;
import androidx.compose.runtime.l4;
import com.mlmvpn.scanner.engines.mami.MamiEngine;
import com.mlmvpn.scanner.store.StoreNetKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlinx.coroutines.i0;
import sd.u;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes4.dex */
@xd.e(c = "com.mlmvpn.scanner.ui.mami.MamiScreenKt$MamiMain$3$1", f = "MamiScreen.kt", l = {}, m = "invokeSuspend")
public final class MamiScreenKt$MamiMain$3$1 extends xd.j implements ee.e {
    final /* synthetic */ l4 $busy$delegate;
    final /* synthetic */ k2 $note$delegate;
    final /* synthetic */ k2 $wasBusy$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiScreenKt$MamiMain$3$1(l4 l4Var, k2 k2Var, k2 k2Var2, wd.d dVar) {
        super(2, dVar);
        this.$busy$delegate = l4Var;
        this.$wasBusy$delegate = k2Var;
        this.$note$delegate = k2Var2;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        return new MamiScreenKt$MamiMain$3$1(this.$busy$delegate, this.$wasBusy$delegate, this.$note$delegate, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:85:0x016d A[PHI: r4
      0x016d: PHI (r4v5 java.lang.String) = (r4v1 java.lang.String), (r4v6 java.lang.String) binds: [B:92:0x019d, B:83:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        String strG;
        int i;
        int i10;
        int i11;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sd.m.b(obj);
        if (MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate).length() == 0 && MamiScreenKt.MamiMain$lambda$55(this.$wasBusy$delegate).length() > 0) {
            k2 k2Var = this.$note$delegate;
            String strMamiMain$lambda$55 = MamiScreenKt.MamiMain$lambda$55(this.$wasBusy$delegate);
            int iHashCode = strMamiMain$lambda$55.hashCode();
            String strTr = "";
            if (iHashCode != 3202928) {
                if (iHashCode != 555704345) {
                    if (iHashCode == 938321246 && strMamiMain$lambda$55.equals("measure")) {
                        List<MamiEngine.ServerRow> listServers = MamiEngine.INSTANCE.servers();
                        boolean z10 = listServers instanceof Collection;
                        int i12 = 0;
                        if (z10 && listServers.isEmpty()) {
                            i = 0;
                        } else {
                            Iterator<T> it = listServers.iterator();
                            i = 0;
                            while (it.hasNext()) {
                                if (((MamiEngine.ServerRow) it.next()).getMs() > 0 && (i = i + 1) < 0) {
                                    r.e0();
                                    throw null;
                                }
                            }
                        }
                        String strFa = MamiScreenKt.fa(i);
                        if (z10 && listServers.isEmpty()) {
                            i10 = 0;
                        } else {
                            Iterator<T> it2 = listServers.iterator();
                            i10 = 0;
                            while (it2.hasNext()) {
                                if (((MamiEngine.ServerRow) it2.next()).getSupported() && (i10 = i10 + 1) < 0) {
                                    r.e0();
                                    throw null;
                                }
                            }
                        }
                        String strM = f0.a.m(strFa, " سرور از ", MamiScreenKt.fa(i10), " جواب داد.");
                        if (z10 && listServers.isEmpty()) {
                            i11 = 0;
                        } else {
                            Iterator<T> it3 = listServers.iterator();
                            i11 = 0;
                            while (it3.hasNext()) {
                                if (((MamiEngine.ServerRow) it3.next()).getMs() > 0 && (i11 = i11 + 1) < 0) {
                                    r.e0();
                                    throw null;
                                }
                            }
                        }
                        if (!z10 || !listServers.isEmpty()) {
                            Iterator<T> it4 = listServers.iterator();
                            while (it4.hasNext()) {
                                if (((MamiEngine.ServerRow) it4.next()).getSupported() && (i12 = i12 + 1) < 0) {
                                    r.e0();
                                    throw null;
                                }
                            }
                        }
                        strTr = StoreNetKt.tr(strM, i11 + " of " + i12 + " servers answered.");
                    }
                } else if (strMamiMain$lambda$55.equals("catalog")) {
                    MamiEngine.CatalogInfo catalogInfo = MamiEngine.INSTANCE.catalogInfo();
                    strG = catalogInfo != null ? com.mlmvpn.core.aether.i.g("A new list was fetched: ", catalogInfo.getServers(), " servers.", w0.n("فهرست تازه گرفته شد: ", MamiScreenKt.fa(catalogInfo.getServers()), " سرور.")) : null;
                    if (strG != null) {
                        strTr = strG;
                    }
                }
            } else if (strMamiMain$lambda$55.equals("hive")) {
                MamiEngine.HiveInfo hiveInfo = MamiEngine.INSTANCE.hiveInfo();
                strG = hiveInfo != null ? com.mlmvpn.core.aether.i.g("A new Lion list was fetched: ", hiveInfo.getServers(), " bridges.", w0.n("فهرست لیون تازه گرفته شد: ", MamiScreenKt.fa(hiveInfo.getServers()), " پل.")) : null;
                if (strG != null) {
                    strTr = strG;
                }
            }
            MamiScreenKt.MamiMain$lambda$48(k2Var, strTr);
        }
        this.$wasBusy$delegate.setValue(MamiScreenKt.MamiMain$lambda$31(this.$busy$delegate));
        return u.f67154a;
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiScreenKt$MamiMain$3$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
