package com.mlmvpn.scanner.engines.fenix.arman

import android.os.ParcelFileDescriptor

/**
 * JNI adapter for the Arman engine's hev-socks5-tunnel bridge.
 *
 * The native library binds these methods in JNI_OnLoad to this exact
 * package/class name. Keep the package stable unless the native build's
 * PKGNAME/CLSNAME flags are changed in lockstep.
 */
object Tun2Socks {
    private external fun TProxyStartService(configPath: String, fd: Int): Boolean
    private external fun TProxyStopService(): Boolean
    private external fun TProxyIsRunning(): Boolean

    @Suppress("unused")
    private external fun TProxyGetStats(): LongArray

    private var device: ParcelFileDescriptor? = null

    @Synchronized
    fun start(configPath: String, tun: ParcelFileDescriptor): Boolean {
        try {
            stop()
            System.loadLibrary("hev-socks5-tunnel")
            device = tun
            if (TProxyStartService(configPath, tun.fd)) return true
        } catch (error: Throwable) {
            device = null
            tun.close()
            throw error
        }
        stop()
        return false
    }

    @Synchronized
    fun stop() {
        val tun = device ?: return
        device = null
        TProxyStopService()
        tun.close()
    }

    @Synchronized
    fun running(): Boolean = device != null && TProxyIsRunning()

    @Synchronized
    fun ended(): Boolean = device != null && !TProxyIsRunning()
}
