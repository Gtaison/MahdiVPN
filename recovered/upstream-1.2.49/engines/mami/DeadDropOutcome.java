package com.mlmvpn.scanner.engines.mami;

import java.util.List;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class DeadDropOutcome {
    public static final int $stable = 8;
    private final String host;
    private final long ms;
    private final boolean ok;
    private final List<DeadDropResult> results;
    private final String source;

    public DeadDropOutcome(boolean z10, String str, String str2, long j, List<DeadDropResult> results) {
        j.e(results, "results");
        this.ok = z10;
        this.host = str;
        this.source = str2;
        this.ms = j;
        this.results = results;
    }

    public final String getHost() {
        return this.host;
    }

    public final long getMs() {
        return this.ms;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final List<DeadDropResult> getResults() {
        return this.results;
    }

    public final String getSource() {
        return this.source;
    }
}
