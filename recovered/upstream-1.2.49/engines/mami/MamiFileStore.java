package com.mlmvpn.scanner.engines.mami;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.j;
import kotlin.text.o;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class MamiFileStore implements MamiStore {
    public static final int $stable = 8;
    private final File dir;

    public MamiFileStore(File dir) {
        j.e(dir, "dir");
        this.dir = dir;
    }

    private final File fileOf(String str) {
        if (str.length() <= 0 || o.I0('/', 0, 6, str) >= 0 || o.I0('\\', 0, 6, str) >= 0 || str.equals(".") || str.equals("..")) {
            throw new IllegalArgumentException("bad store name");
        }
        return new File(this.dir, str);
    }

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public synchronized void delete(String name) {
        j.e(name, "name");
        try {
            fileOf(name).delete();
        } catch (Exception unused) {
        }
    }

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public synchronized sf.c readJson(String name) {
        sf.c cVar;
        j.e(name, "name");
        cVar = null;
        try {
            File fileFileOf = fileOf(name);
            if (fileFileOf.isFile()) {
                cVar = new sf.c(new String(ce.o.l0(fileFileOf), kotlin.text.a.f23859a));
            }
        } catch (Exception unused) {
        }
        return cVar;
    }

    @Override // com.mlmvpn.scanner.engines.mami.MamiStore
    public synchronized void writeJson(String name, sf.c obj) {
        j.e(name, "name");
        j.e(obj, "obj");
        File fileFileOf = fileOf(name);
        this.dir.mkdirs();
        File file = new File(this.dir, name + "." + System.nanoTime() + ".tmp");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                String strM = obj.M(1);
                j.d(strM, "toString(...)");
                byte[] bytes = strM.getBytes(kotlin.text.a.f23859a);
                j.d(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (!file.renameTo(fileFileOf)) {
                    fileFileOf.delete();
                    if (!file.renameTo(fileFileOf)) {
                        throw new IOException("could not replace ".concat(name));
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    a.a.g(fileOutputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            if (file.exists()) {
                file.delete();
            }
            throw th4;
        }
    }
}
