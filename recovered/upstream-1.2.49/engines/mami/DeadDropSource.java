package com.mlmvpn.scanner.engines.mami;

import a6.w0;
import androidx.media3.common.s;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class DeadDropSource {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f11575id;
    private final String label;
    private final String url;

    public DeadDropSource(String id2, String label, String url) {
        j.e(id2, "id");
        j.e(label, "label");
        j.e(url, "url");
        this.f11575id = id2;
        this.label = label;
        this.url = url;
    }

    public static /* synthetic */ DeadDropSource copy$default(DeadDropSource deadDropSource, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deadDropSource.f11575id;
        }
        if ((i & 2) != 0) {
            str2 = deadDropSource.label;
        }
        if ((i & 4) != 0) {
            str3 = deadDropSource.url;
        }
        return deadDropSource.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f11575id;
    }

    public final String component2() {
        return this.label;
    }

    public final String component3() {
        return this.url;
    }

    public final DeadDropSource copy(String id2, String label, String url) {
        j.e(id2, "id");
        j.e(label, "label");
        j.e(url, "url");
        return new DeadDropSource(id2, label, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeadDropSource)) {
            return false;
        }
        DeadDropSource deadDropSource = (DeadDropSource) obj;
        return j.a(this.f11575id, deadDropSource.f11575id) && j.a(this.label, deadDropSource.label) && j.a(this.url, deadDropSource.url);
    }

    public final String getId() {
        return this.f11575id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode() + s.d(this.f11575id.hashCode() * 31, 31, this.label);
    }

    public String toString() {
        String str = this.f11575id;
        String str2 = this.label;
        return w0.r(s.n("DeadDropSource(id=", str, ", label=", str2, ", url="), this.url, ")");
    }
}
