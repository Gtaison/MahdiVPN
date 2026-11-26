package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import androidx.media3.common.s;
import kotlin.jvm.internal.j;
import org.telegram.ui.Cells.d1;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class DeadDropResult {
    public static final int $stable = 0;
    private final String error;
    private final String host;
    private final String label;
    private final long ms;
    private final boolean ok;
    private final String source;

    public DeadDropResult(String source, String label, boolean z10, long j, String str, String str2) {
        j.e(source, "source");
        j.e(label, "label");
        this.source = source;
        this.label = label;
        this.ok = z10;
        this.ms = j;
        this.host = str;
        this.error = str2;
    }

    public static /* synthetic */ DeadDropResult copy$default(DeadDropResult deadDropResult, String str, String str2, boolean z10, long j, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deadDropResult.source;
        }
        if ((i & 2) != 0) {
            str2 = deadDropResult.label;
        }
        if ((i & 4) != 0) {
            z10 = deadDropResult.ok;
        }
        if ((i & 8) != 0) {
            j = deadDropResult.ms;
        }
        if ((i & 16) != 0) {
            str3 = deadDropResult.host;
        }
        if ((i & 32) != 0) {
            str4 = deadDropResult.error;
        }
        long j10 = j;
        boolean z11 = z10;
        return deadDropResult.copy(str, str2, z11, j10, str3, str4);
    }

    public final String component1() {
        return this.source;
    }

    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.ok;
    }

    public final long component4() {
        return this.ms;
    }

    public final String component5() {
        return this.host;
    }

    public final String component6() {
        return this.error;
    }

    public final DeadDropResult copy(String source, String label, boolean z10, long j, String str, String str2) {
        j.e(source, "source");
        j.e(label, "label");
        return new DeadDropResult(source, label, z10, j, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeadDropResult)) {
            return false;
        }
        DeadDropResult deadDropResult = (DeadDropResult) obj;
        return j.a(this.source, deadDropResult.source) && j.a(this.label, deadDropResult.label) && this.ok == deadDropResult.ok && this.ms == deadDropResult.ms && j.a(this.host, deadDropResult.host) && j.a(this.error, deadDropResult.error);
    }

    public final String getError() {
        return this.error;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getMs() {
        return this.ms;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int iC = w0.c(w0.d(s.d(this.source.hashCode() * 31, 31, this.label), 31, this.ok), 31, this.ms);
        String str = this.host;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.source;
        String str2 = this.label;
        boolean z10 = this.ok;
        long j = this.ms;
        String str3 = this.host;
        String str4 = this.error;
        StringBuilder sbN = s.n("DeadDropResult(source=", str, ", label=", str2, ", ok=");
        sbN.append(z10);
        sbN.append(", ms=");
        sbN.append(j);
        d1.x(sbN, ", host=", str3, ", error=", str4);
        sbN.append(")");
        return sbN.toString();
    }

    public /* synthetic */ DeadDropResult(String str, String str2, boolean z10, long j, String str3, String str4, int i, kotlin.jvm.internal.e eVar) {
        this(str, str2, z10, j, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }
}
