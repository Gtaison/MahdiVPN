package com.mlmvpn.scanner.engines.mami;

import java.security.PrivateKey;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestCtx {
    public static final int $stable = 8;
    private final String audience;
    private final long minimumRevision;
    private final long monoNs;
    private final String nonce;
    private final PrivateKey privateKey;
    private final String recipientKeyHash;
    private final long requestedAt;
    private volatile boolean used;

    public RequestCtx(String nonce, String audience, long j, long j10, long j11, String recipientKeyHash, PrivateKey privateKey) {
        j.e(nonce, "nonce");
        j.e(audience, "audience");
        j.e(recipientKeyHash, "recipientKeyHash");
        j.e(privateKey, "privateKey");
        this.nonce = nonce;
        this.audience = audience;
        this.minimumRevision = j;
        this.requestedAt = j10;
        this.monoNs = j11;
        this.recipientKeyHash = recipientKeyHash;
        this.privateKey = privateKey;
    }

    public final String getAudience() {
        return this.audience;
    }

    public final long getMinimumRevision() {
        return this.minimumRevision;
    }

    public final long getMonoNs() {
        return this.monoNs;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final String getRecipientKeyHash() {
        return this.recipientKeyHash;
    }

    public final long getRequestedAt() {
        return this.requestedAt;
    }

    public final boolean getUsed() {
        return this.used;
    }

    public final void setUsed(boolean z10) {
        this.used = z10;
    }
}
