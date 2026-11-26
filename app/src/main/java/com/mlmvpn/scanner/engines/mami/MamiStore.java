package com.mlmvpn.scanner.engines.mami;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public interface MamiStore {
    void delete(String str);

    sf.c readJson(String str);

    void writeJson(String str, sf.c cVar);
}
