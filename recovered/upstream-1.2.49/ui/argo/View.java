package com.mlmvpn.scanner.ui.argo;

import com.mlmvpn.scanner.ui.EngineTone;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
final class View {
    private final boolean canPress;
    private final String head;
    private final String line;
    private final EngineTone tone;

    public View(EngineTone tone, String head, String line, boolean z10) {
        kotlin.jvm.internal.j.e(tone, "tone");
        kotlin.jvm.internal.j.e(head, "head");
        kotlin.jvm.internal.j.e(line, "line");
        this.tone = tone;
        this.head = head;
        this.line = line;
        this.canPress = z10;
    }

    public final boolean getCanPress() {
        return this.canPress;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getLine() {
        return this.line;
    }

    public final EngineTone getTone() {
        return this.tone;
    }
}
