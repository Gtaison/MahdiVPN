package com.mlmvpn.scanner.engines.mami;

import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class EnvelopeFields {
    public static final int $stable = 0;
    private final String audience;
    private final String ciphertext;
    private final long expiresAt;
    private final long issuedAt;
    private final String iv;
    private final String keyId;
    private final String nonce;
    private final String recipientKeyHash;
    private final long revision;
    private final String signature;
    private final String suite;
    private final long version;
    private final String wrappedKey;

    public EnvelopeFields(long j, long j10, long j11, long j12, String suite, String keyId, String audience, String nonce, String recipientKeyHash, String wrappedKey, String iv, String ciphertext, String signature) {
        j.e(suite, "suite");
        j.e(keyId, "keyId");
        j.e(audience, "audience");
        j.e(nonce, "nonce");
        j.e(recipientKeyHash, "recipientKeyHash");
        j.e(wrappedKey, "wrappedKey");
        j.e(iv, "iv");
        j.e(ciphertext, "ciphertext");
        j.e(signature, "signature");
        this.version = j;
        this.issuedAt = j10;
        this.expiresAt = j11;
        this.revision = j12;
        this.suite = suite;
        this.keyId = keyId;
        this.audience = audience;
        this.nonce = nonce;
        this.recipientKeyHash = recipientKeyHash;
        this.wrappedKey = wrappedKey;
        this.iv = iv;
        this.ciphertext = ciphertext;
        this.signature = signature;
    }

    public final String getAudience() {
        return this.audience;
    }

    public final String getCiphertext() {
        return this.ciphertext;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    public final long getIssuedAt() {
        return this.issuedAt;
    }

    public final String getIv() {
        return this.iv;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getRecipientKeyHash() {
        return this.recipientKeyHash;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getSuite() {
        return this.suite;
    }

    public final long getVersion() {
        return this.version;
    }

    public final String getWrappedKey() {
        return this.wrappedKey;
    }
}
