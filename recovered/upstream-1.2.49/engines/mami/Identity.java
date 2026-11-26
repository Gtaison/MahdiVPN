package com.mlmvpn.scanner.engines.mami;

import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-9c33713b02f717a9a1522e2b248e1caf2ff7c354c02a43fccd866999cef7544f */
/* JADX INFO: loaded from: classes3.dex */
public final class Identity extends Recipient {
    public static final int $stable = 0;
    private final String androidId;
    private final long createdAt;
    private final String deviceId;
    private final long keyCreatedAt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Identity(String deviceId, String androidId, long j, long j10, PrivateKey privateKey, PublicKey publicKey, String recipientPublicKey, String recipientKeyHash) {
        super(privateKey, publicKey, recipientPublicKey, recipientKeyHash);
        j.e(deviceId, "deviceId");
        j.e(androidId, "androidId");
        j.e(privateKey, "privateKey");
        j.e(publicKey, "publicKey");
        j.e(recipientPublicKey, "recipientPublicKey");
        j.e(recipientKeyHash, "recipientKeyHash");
        this.deviceId = deviceId;
        this.androidId = androidId;
        this.createdAt = j;
        this.keyCreatedAt = j10;
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getKeyCreatedAt() {
        return this.keyCreatedAt;
    }
}
