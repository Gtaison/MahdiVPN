package com.mlmvpn.scanner.engines.argo

import java.util.concurrent.CancellationException
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

suspend fun recoverConnect(
    engine: ArgoEngine,
    selectedId: String?,
    rawConfig: String?,
    mode: ArgoEngine.Mode?
): Any? {
    val candidates = ArgoPoolRecoveryBridge.candidates(selectedId, rawConfig)
    if (candidates.isEmpty()) {
        throw IllegalStateException("هیچ پل یا فالکنی برای اتصال نیست — اول «به‌روزرسانی» یا «سنجش» را بزنید")
    }
    var lastError = "وصل نشد"
    var attempt = 0
    for (endpoint in candidates) {
        attempt++
        if (!engine.recoveryShouldConnect()) return Unit
        try {
            suspendCoroutineUninterceptedOrReturn<Unit> { continuation ->
                engine.recoveryTryOne(endpoint, mode, attempt, continuation)
            }
            return Unit
        } catch (cancelled: CancellationException) {
            throw cancelled
        } catch (failure: Throwable) {
            val message = failure.message?.takeIf { it.isNotBlank() } ?: "وصل نشد"
            lastError = message
            engine.log("«${endpoint.host}» وصل نشد: $message")
            ArgoPoolRecoveryBridge.recordFailed(endpoint, message)
            engine.recoveryStopService()
        }
    }
    engine.recoveryMarkFailed(lastError)
    return Unit
}