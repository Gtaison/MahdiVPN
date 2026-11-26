package com.mlmvpn.scanner.engines.argo

import java.util.concurrent.CancellationException
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

/**
 * Restores Argo's endpoint selection and retry loop from the upstream
 * coroutine bytecode fallback. The actual connection attempt is delegated
 * to the original ArgoEngine.tryOne implementation.
 */
suspend fun recoverConnect(
    engine: ArgoEngine,
    selectedId: String?,
    rawConfig: String?,
    mode: ArgoEngine.Mode?,
    continuation: wd.d
): Any? {
    val pool = ArgoPool.INSTANCE
    val candidates: List<ArgoProtocol.Endpoint> = when {
        !rawConfig.isNullOrBlank() -> listOf(pool.endpointFromRaw(rawConfig))
        !selectedId.isNullOrBlank() -> listOf(
            pool.get(selectedId) ?: throw IllegalStateException("این مورد در فهرست نیست")
        )
        else -> pool.pick(3)
    }

    if (candidates.isEmpty()) {
        throw IllegalStateException("هیچ پل یا فالکنی برای اتصال نیست — اول «به‌روزرسانی» یا «سنجش» را بزنید")
    }

    var lastError = "وصل نشد"
    var attempt = 0
    for (endpoint in candidates) {
        attempt += 1
        if (!engine.recoveryShouldConnect()) return Unit

        try {
            suspendCoroutineUninterceptedOrReturn<Unit> { cont ->
                engine.tryOne(endpoint, mode, attempt, cont as wd.d)
            }
            return Unit
        } catch (cancelled: CancellationException) {
            throw cancelled
        } catch (failure: Throwable) {
            val message = failure.message?.takeIf { it.isNotBlank() } ?: "وصل نشد"
            lastError = message
            engine.log("«${endpoint.host}» وصل نشد: $message")
            pool.record(endpoint.id, false, 0L, "", "", message, false, "")
            engine.stopService()
        }
    }

    engine.recoveryMarkFailed(lastError)
    return Unit
}