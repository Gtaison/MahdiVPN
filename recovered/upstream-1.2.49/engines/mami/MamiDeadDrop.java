package com.mlmvpn.scanner.engines.mami;

import androidx.media3.exoplayer.l1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.collections.f0;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.jvm.internal.j;
import kotlin.text.i;
import kotlin.text.l;
import kotlin.text.o;
import kotlin.text.v;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiDeadDrop {
    public static final int MAX_BODY = 524288;
    private static final String WS = "[ \\t\\n\\u000B\\u000C\\r]";
    public static final MamiDeadDrop INSTANCE = new MamiDeadDrop();
    private static final List<DeadDropSource> SOURCES = r.a0(new DeadDropSource("gdocs", "Google Docs", "https://docs.google.com/document/d/1jqH4YHTkBy-6m6Mdmw8LqQHESgLjOdlJv7XoXxgZuvI/export?format=txt"), new DeadDropSource("github", "GitHub", "https://raw.githubusercontent.com/YamYamVPN/refactored-barnacle/refs/heads/main/LOREM"));
    private static final l LINE_RE = new l("volutpat\\.[ \\t\\n\\u000B\\u000C\\r]+([A-Za-z0-9.-]{1,200})[ \\t\\n\\u000B\\u000C\\r]+Ut wisi enim(?![A-Za-z0-9_])[^\\n\\r\\u2028\\u2029]*(?<![A-Za-z0-9_])commodo consequat\\.[ \\t\\n\\u000B\\u000C\\r]+\\.?([A-Za-z]{2,24})\\z");
    public static final int $stable = 8;

    private MamiDeadDrop() {
    }

    public static /* synthetic */ DeadDropResult fetchSource$default(MamiDeadDrop mamiDeadDrop, DeadDropSource deadDropSource, ee.f fVar, int i, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i = 12000;
        }
        return mamiDeadDrop.fetchSource(deadDropSource, fVar, i);
    }

    private final boolean isLabel(String str) {
        if (str.length() != 0 && str.length() <= 63 && o.E0(str) != '-' && o.M0(str) != '-') {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (('a' <= cCharAt && cCharAt < '{') || (('0' <= cCharAt && cCharAt < ':') || cCharAt == '-')) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeadDropOutcome resolve$default(MamiDeadDrop mamiDeadDrop, List list, int i, ee.f fVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = SOURCES;
        }
        if ((i10 & 2) != 0) {
            i = 12000;
        }
        return mamiDeadDrop.resolve(list, i, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolve$lambda$3(DeadDropSource deadDropSource, ee.f fVar, int i, CopyOnWriteArrayList copyOnWriteArrayList, LinkedBlockingQueue linkedBlockingQueue) throws InterruptedException {
        DeadDropResult deadDropResultFetchSource = INSTANCE.fetchSource(deadDropSource, fVar, i);
        copyOnWriteArrayList.add(deadDropResultFetchSource);
        linkedBlockingQueue.put(deadDropResultFetchSource);
    }

    public final String extractDomain(String str) {
        if (str == null) {
            str = "";
        }
        String strP0 = v.p0(str, (char) 160, ' ');
        int length = strP0.length();
        int i = 0;
        for (int i10 = 0; i10 <= length; i10++) {
            if (i10 == length || strP0.charAt(i10) == '\n' || strP0.charAt(i10) == '\r') {
                String strSubstring = strP0.substring(i, i10);
                j.d(strSubstring, "substring(...)");
                int i11 = i10 + 1;
                kotlin.text.g gVarFind$default = l.find$default(LINE_RE, o.q1(MamiJs.INSTANCE.trim(strSubstring), '.'), 0, 2, null);
                if (gVarFind$default != null) {
                    i iVar = (i) gVarFind$default;
                    String lowerCase = (((f0) iVar.a()).get(1) + "." + ((f0) iVar.a()).get(2)).toLowerCase(Locale.ROOT);
                    j.d(lowerCase, "toLowerCase(...)");
                    if (isValidHost(lowerCase)) {
                        return lowerCase;
                    }
                }
                i = i11;
            }
        }
        return null;
    }

    public final DeadDropResult fetchSource(DeadDropSource source, ee.f fetch, int i) {
        String str;
        j.e(source, "source");
        j.e(fetch, "fetch");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            sd.j jVar = (sd.j) fetch.invoke(source.getUrl(), Integer.valueOf(i), 532480);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jVar == null) {
                return new DeadDropResult(source.getId(), source.getLabel(), false, jCurrentTimeMillis2, null, "no answer", 16, null);
            }
            if (((Number) jVar.getFirst()).intValue() != 200) {
                String id2 = source.getId();
                String label = source.getLabel();
                if (((Number) jVar.getFirst()).intValue() != 0) {
                    str = "HTTP " + jVar.getFirst();
                } else {
                    str = "no answer";
                }
                return new DeadDropResult(id2, label, false, jCurrentTimeMillis2, null, str, 16, null);
            }
            if (((byte[]) jVar.getSecond()).length > 524288) {
                return new DeadDropResult(source.getId(), source.getLabel(), false, jCurrentTimeMillis2, null, "document too large", 16, null);
            }
            try {
                String strExtractDomain = extractDomain(new String((byte[]) jVar.getSecond(), kotlin.text.a.f23859a));
                if (strExtractDomain != null) {
                    return new DeadDropResult(source.getId(), source.getLabel(), true, jCurrentTimeMillis2, strExtractDomain, null, 32, null);
                }
                return new DeadDropResult(source.getId(), source.getLabel(), false, jCurrentTimeMillis2, null, "no domain in the document", 16, null);
            } catch (Exception e10) {
                e = e10;
                String id3 = source.getId();
                String label2 = source.getLabel();
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                return new DeadDropResult(id3, label2, false, jCurrentTimeMillis3, null, message, 16, null);
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final List<DeadDropSource> getSOURCES() {
        return SOURCES;
    }

    public final boolean isValidHost(String str) {
        String str2;
        int length;
        if (str != null && str.length() <= 253 && !v.k0(str, ".invalid", false)) {
            List listA1 = o.a1(str, new char[]{'.'}, 6);
            if (listA1.size() >= 2 && 2 <= (length = (str2 = (String) q.G0(listA1)).length()) && length < 25) {
                for (int i = 0; i < str2.length(); i++) {
                    char cCharAt = str2.charAt(i);
                    if ('a' <= cCharAt && cCharAt < '{') {
                    }
                }
                List listU0 = q.u0(listA1);
                if (!(listU0 instanceof Collection) || !listU0.isEmpty()) {
                    Iterator it = listU0.iterator();
                    while (it.hasNext()) {
                        if (!INSTANCE.isLabel((String) it.next())) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final DeadDropOutcome resolve(List<DeadDropSource> sources, int i, ee.f fetch) {
        j.e(sources, "sources");
        j.e(fetch, "fetch");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (sources.isEmpty()) {
            return new DeadDropOutcome(false, null, null, 0L, copyOnWriteArrayList);
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (DeadDropSource deadDropSource : sources) {
            CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
            int i10 = i;
            ee.f fVar = fetch;
            copyOnWriteArrayList = copyOnWriteArrayList2;
            Thread thread = new Thread(new l1(deadDropSource, fVar, i10, copyOnWriteArrayList2, linkedBlockingQueue, 1));
            thread.setDaemon(true);
            thread.setName("mami-deaddrop-" + deadDropSource.getId());
            thread.start();
            fetch = fVar;
            i = i10;
        }
        int size = sources.size();
        while (size > 0) {
            DeadDropResult deadDropResult = (DeadDropResult) linkedBlockingQueue.take();
            size--;
            if (deadDropResult.getOk()) {
                return new DeadDropOutcome(true, deadDropResult.getHost(), deadDropResult.getSource(), System.currentTimeMillis() - jCurrentTimeMillis, copyOnWriteArrayList);
            }
        }
        return new DeadDropOutcome(false, null, null, System.currentTimeMillis() - jCurrentTimeMillis, copyOnWriteArrayList);
    }
}
