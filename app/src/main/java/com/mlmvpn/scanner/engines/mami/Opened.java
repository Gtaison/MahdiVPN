package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class Opened {
    public static final int $stable = 8;
    private final long expiresAt;
    private final long issuedAt;
    private final String keyId;
    private final byte[] plaintext;
    private final long revision;

    public Opened(byte[] plaintext, String keyId, long j, long j10, long j11) {
        j.e(plaintext, "plaintext");
        j.e(keyId, "keyId");
        this.plaintext = plaintext;
        this.keyId = keyId;
        this.revision = j;
        this.issuedAt = j10;
        this.expiresAt = j11;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    public final long getIssuedAt() {
        return this.issuedAt;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final byte[] getPlaintext() {
        return this.plaintext;
    }

    public final long getRevision() {
        return this.revision;
    }
}
