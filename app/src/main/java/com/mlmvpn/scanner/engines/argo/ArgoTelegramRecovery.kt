package com.mlmvpn.scanner.engines.argo

import java.security.SecureRandom
import java.util.function.BiConsumer
import java.util.function.BooleanSupplier
import kotlinx.coroutines.delay

private val telegramRecoveryRandom = SecureRandom()
private val falconTextMarker = Regex("فالکن|falcon", RegexOption.IGNORE_CASE)
private val bridgePayloadLine = Regex("BRIDGE BLOCK|^[A-Za-z0-9+/=]{20,}$")

suspend fun recoverTelegramPageRetry(
    pool: ArgoPool,
    channel: String,
    beforeId: Long?,
    route: ArgoNet.Route?,
    shouldStop: BooleanSupplier
): ArgoPool.Page {
    var page = ArgoPool.Page(false, 0, emptyList())
    val retryDelays = longArrayOf(0L, 3_000L, 8_000L, 20_000L, 45_000L)
    for (waitMs in retryDelays) {
        if (waitMs > 0L) delay(waitMs)
        if (shouldStop.asBoolean) break
        page = ArgoPoolRecoveryBridge.telegramPage(pool, channel, beforeId, route)
        if (page.ok || page.code == 404) break
    }
    return page
}

suspend fun recoverHarvestTelegram(
    pool: ArgoPool,
    source: ArgoPool.Source,
    maxPages: Int,
    route: ArgoNet.Route?,
    onProgress: BiConsumer<Int, Int>,
    shouldStop: BooleanSupplier
): Int {
    val channel = ArgoPoolRecoveryBridge.sourceChannel(source)
        ?: throw IllegalStateException("کانال تلگرام برای این منبع تعریف نشده است")
    val sourceId = ArgoPoolRecoveryBridge.sourceId(source)
    var beforeId: Long? = null
    var pageNumber = 0
    var totalServers = 0
    var consecutiveEmptyPages = 0

    while (pageNumber < maxPages) {
        if (shouldStop.asBoolean) break
        val page = recoverTelegramPageRetry(pool, channel, beforeId, route, shouldStop)
        if (!page.ok) {
            if (pageNumber > 0) break
            val message = when {
                page.code != 0 -> "کانال جواب نداد (کد ${page.code}) — نام کانال را بررسی کنید"
                route != null -> "تلگرام از راه «${route.label}» هم جواب نداد — اتصال همان موتور را بررسی کنید"
                else -> "تلگرام روی این اینترنت در دسترس نیست — اول یکی از موتورها را وصل کنید و دوباره «به‌روزرسانی» را بزنید"
            }
            throw IllegalStateException(message)
        }

        val posts = page.posts
        if (posts.isEmpty()) break
        var absorbedOnPage = 0
        for (post in posts) {
            val text = post.text
            if (text.isBlank()) continue
            val payload = if (falconTextMarker.containsMatchIn(text)) {
                text
            } else {
                text.lineSequence()
                    .filter { line -> bridgePayloadLine.containsMatchIn(line.trim()) }
                    .joinToString("\n")
            }
            if (payload.isBlank()) continue
            val timestamp = post.at.takeIf { it > 0L } ?: System.currentTimeMillis()
            absorbedOnPage += ArgoPoolRecoveryBridge.absorbText(pool, payload, sourceId, timestamp)
        }

        pageNumber += 1
        totalServers += absorbedOnPage
        onProgress.accept(pageNumber, totalServers)
        if (absorbedOnPage > 0) consecutiveEmptyPages = 0 else consecutiveEmptyPages++
        val oldestPostId = posts.minOfOrNull { it.id } ?: break
        if (beforeId != null && oldestPostId < beforeId) break
        if (oldestPostId <= 1L || consecutiveEmptyPages >= 6) break
        beforeId = oldestPostId
        if (pageNumber < maxPages) delay(600L + telegramRecoveryRandom.nextInt(600).toLong())
    }
    return totalServers
}