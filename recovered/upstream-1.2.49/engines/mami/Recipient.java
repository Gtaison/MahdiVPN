package com.mlmvpn.scanner.engines.mami;

import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public class Recipient {
    public static final int $stable = 8;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final String recipientKeyHash;
    private final String recipientPublicKey;

    public Recipient(PrivateKey privateKey, PublicKey publicKey, String recipientPublicKey, String recipientKeyHash) {
        j.e(privateKey, "privateKey");
        j.e(publicKey, "publicKey");
        j.e(recipientPublicKey, "recipientPublicKey");
        j.e(recipientKeyHash, "recipientKeyHash");
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.recipientPublicKey = recipientPublicKey;
        this.recipientKeyHash = recipientKeyHash;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final PublicKey getPublicKey() {
        return this.publicKey;
    }

    public final String getRecipientKeyHash() {
        return this.recipientKeyHash;
    }

    public final String getRecipientPublicKey() {
        return this.recipientPublicKey;
    }
}
