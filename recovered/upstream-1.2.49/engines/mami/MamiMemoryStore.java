package com.mlmvpn.scanner.engines.mami;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiMemoryStore implements MamiStore {
    public static final int $stable = 8;
    private final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public void delete(String name) {
        j.e(name, "name");
        this.map.remove(name);
    }

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public sf.c readJson(String name) {
        j.e(name, "name");
        String str = this.map.get(name);
        if (str == null) {
            return null;
        }
        try {
            return new sf.c(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public void writeJson(String name, sf.c obj) {
        j.e(name, "name");
        j.e(obj, "obj");
        this.map.put(name, obj.toString());
    }
}
