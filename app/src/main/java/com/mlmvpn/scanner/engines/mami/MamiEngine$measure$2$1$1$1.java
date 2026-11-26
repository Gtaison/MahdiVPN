package com.mlmvpn.scanner.engines.mami;

import com.mlmvpn.scanner.data.CombineEngine;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.sync.l;
import sd.m;
import sd.u;
import xd.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
@xd.e(c = "com.mlmvpn.scanner.engines.mami.MamiEngine$measure$2$1$1$1", f = "MamiEngine.kt", l = {1041, 424, 425}, m = "invokeSuspend")
public final class MamiEngine$measure$2$1$1$1 extends j implements ee.e {
    final /* synthetic */ String $id;
    final /* synthetic */ sf.c $ob;
    final /* synthetic */ ConcurrentHashMap<String, Long> $out;
    final /* synthetic */ String $probeUrl;
    final /* synthetic */ kotlinx.coroutines.sync.h $sem;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MamiEngine$measure$2$1$1$1(kotlinx.coroutines.sync.h hVar, ConcurrentHashMap<String, Long> concurrentHashMap, String str, String str2, sf.c cVar, wd.d dVar) {
        super(2, dVar);
        this.$sem = hVar;
        this.$out = concurrentHashMap;
        this.$id = str;
        this.$probeUrl = str2;
        this.$ob = cVar;
    }

    @Override // xd.a
    public final wd.d create(Object obj, wd.d dVar) {
        MamiEngine$measure$2$1$1$1 mamiEngine$measure$2$1$1$1 = new MamiEngine$measure$2$1$1$1(this.$sem, this.$out, this.$id, this.$probeUrl, this.$ob, dVar);
        mamiEngine$measure$2$1$1$1.L$0 = obj;
        return mamiEngine$measure$2$1$1$1;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0114  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0120  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // xd.a
    public final Object invokeSuspend(Object obj) {
        Object objM1004constructorimpl;
        ConcurrentHashMap<String, Long> r4;
        String r8;
        Long l6;
        long jLongValue;
        ConcurrentHashMap<String, Long> concurrentHashMap;
        kotlinx.coroutines.sync.h hVar;
        String str;
        sf.c cVar;
        String str2;
        ConcurrentHashMap<String, Long> concurrentHashMap2;
        Object objMeasureDelay$default;
        String str3;
        ConcurrentHashMap<String, Long> concurrentHashMap3;
        kotlinx.coroutines.sync.h hVar2;
        Object objMeasureDelay;
        String str4;
        ConcurrentHashMap<String, Long> concurrentHashMap4;
        kotlinx.coroutines.sync.h hVar3;
        long jLongValue2;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.COROUTINE_SUSPENDED;
        int i = this.label;
        String r10;
        ConcurrentHashMap<String, Long> r11;
        kotlinx.coroutines.sync.h r12;
        try {
            try {
                if (i == 0) {
                    m.b(obj);
                    i0 i0Var = (i0) this.L$0;
                    kotlinx.coroutines.sync.h hVar4 = this.$sem;
                    concurrentHashMap = this.$out;
                    String str5 = this.$id;
                    String str6 = this.$probeUrl;
                    sf.c cVar2 = this.$ob;
                    this.L$0 = i0Var;
                    this.L$1 = hVar4;
                    this.L$2 = concurrentHashMap;
                    this.L$3 = str5;
                    this.L$4 = str6;
                    this.L$5 = cVar2;
                    this.label = 1;
                    l lVar = (l) hVar4;
                    if (lVar.a(this) != aVar) {
                        hVar = lVar;
                        str = str6;
                        cVar = cVar2;
                        str2 = str5;
                    }
                    return aVar;
                }
                if (i != 1) {
                    if (i == 2) {
                        String str7 = (String) this.L$2;
                        ConcurrentHashMap<String, Long> concurrentHashMap5 = (ConcurrentHashMap) this.L$1;
                        kotlinx.coroutines.sync.h hVar5 = (kotlinx.coroutines.sync.h) this.L$0;
                        m.b(obj);
                        objMeasureDelay = obj;
                        str4 = str7;
                        concurrentHashMap4 = concurrentHashMap5;
                        hVar3 = hVar5;
                        jLongValue2 = ((Number) objMeasureDelay).longValue();
                        r10 = str4;
                        r11 = concurrentHashMap4;
                        r12 = hVar3;
                        objM1004constructorimpl = sd.l.m1004constructorimpl(new Long(jLongValue2));
                        r8 = r10;
                        r4 = r11;
                        r12 = r12;
                        l6 = new Long(0L);
                        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                            objM1004constructorimpl = l6;
                        }
                        jLongValue = ((Number) objM1004constructorimpl).longValue();
                        if (jLongValue > 0) {
                            jLongValue = -1;
                        }
                        r4.put(r8, new Long(jLongValue));
                        return u.f67154a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str8 = (String) this.L$2;
                    ConcurrentHashMap<String, Long> concurrentHashMap6 = (ConcurrentHashMap) this.L$1;
                    kotlinx.coroutines.sync.h hVar6 = (kotlinx.coroutines.sync.h) this.L$0;
                    m.b(obj);
                    objMeasureDelay$default = obj;
                    str3 = str8;
                    concurrentHashMap3 = concurrentHashMap6;
                    hVar2 = hVar6;
                    jLongValue2 = ((Number) objMeasureDelay$default).longValue();
                    r10 = str3;
                    r11 = concurrentHashMap3;
                    r12 = hVar2;
                    objM1004constructorimpl = sd.l.m1004constructorimpl(new Long(jLongValue2));
                    r8 = r10;
                    r4 = r11;
                    r12 = r12;
                    l6 = new Long(0L);
                    if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                        objM1004constructorimpl = l6;
                    }
                    jLongValue = ((Number) objM1004constructorimpl).longValue();
                    if (jLongValue > 0) {
                        jLongValue = -1;
                    }
                    r4.put(r8, new Long(jLongValue));
                    return u.f67154a;
                }
                cVar = (sf.c) this.L$5;
                str = (String) this.L$4;
                String str9 = (String) this.L$3;
                concurrentHashMap = (ConcurrentHashMap) this.L$2;
                kotlinx.coroutines.sync.h hVar7 = (kotlinx.coroutines.sync.h) this.L$1;
                m.b(obj);
                str2 = str9;
                hVar = hVar7;
                if (str != null) {
                    CombineEngine combineEngine = CombineEngine.INSTANCE;
                    String strTestConfig = MamiEngine.INSTANCE.testConfig(cVar);
                    this.L$0 = hVar;
                    this.L$1 = concurrentHashMap2;
                    this.L$2 = str2;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 2;
                    objMeasureDelay = combineEngine.measureDelay(strTestConfig, str, 12000L, this);
                    if (objMeasureDelay != aVar) {
                        str4 = str2;
                        concurrentHashMap4 = concurrentHashMap2;
                        hVar3 = hVar;
                        jLongValue2 = ((Number) objMeasureDelay).longValue();
                        r10 = str4;
                        r11 = concurrentHashMap4;
                        r12 = hVar3;
                        objM1004constructorimpl = sd.l.m1004constructorimpl(new Long(jLongValue2));
                        r8 = r10;
                        r4 = r11;
                        r12 = r12;
                        l6 = new Long(0L);
                        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                            objM1004constructorimpl = l6;
                        }
                        jLongValue = ((Number) objM1004constructorimpl).longValue();
                        if (jLongValue > 0) {
                            jLongValue = -1;
                        }
                        r4.put(r8, new Long(jLongValue));
                        return u.f67154a;
                    }
                } else {
                    CombineEngine combineEngine2 = CombineEngine.INSTANCE;
                    String strTestConfig2 = MamiEngine.INSTANCE.testConfig(cVar);
                    this.L$0 = hVar;
                    this.L$1 = concurrentHashMap2;
                    this.L$2 = str2;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 3;
                    objMeasureDelay$default = CombineEngine.measureDelay$default(combineEngine2, strTestConfig2, null, 12000L, this, 2, null);
                    if (objMeasureDelay$default != aVar) {
                        str3 = str2;
                        concurrentHashMap3 = concurrentHashMap2;
                        hVar2 = hVar;
                        jLongValue2 = ((Number) objMeasureDelay$default).longValue();
                        r10 = str3;
                        r11 = concurrentHashMap3;
                        r12 = hVar2;
                        objM1004constructorimpl = sd.l.m1004constructorimpl(new Long(jLongValue2));
                        r8 = r10;
                        r4 = r11;
                        r12 = r12;
                        l6 = new Long(0L);
                        if (sd.l.m1010isFailureimpl(objM1004constructorimpl)) {
                            objM1004constructorimpl = l6;
                        }
                        jLongValue = ((Number) objM1004constructorimpl).longValue();
                        if (jLongValue > 0) {
                            jLongValue = -1;
                        }
                        r4.put(r8, new Long(jLongValue));
                        return u.f67154a;
                    }
                }
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                r10 = str2;
                r11 = concurrentHashMap2;
                r12 = hVar;
                try {
                    objM1004constructorimpl = sd.l.m1004constructorimpl(m.a(th));
                    r8 = r10;
                    r4 = r11;
                    r12 = r12;
                } finally {
                    ((l) r12).c();
                }
            }
            concurrentHashMap2 = concurrentHashMap;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // ee.e
    public final Object invoke(i0 i0Var, wd.d dVar) {
        return ((MamiEngine$measure$2$1$1$1) create(i0Var, dVar)).invokeSuspend(u.f67154a);
    }
}
