package com.mlmvpn.scanner.engines.argo

import kotlinx.coroutines.delay
import java.security.SecureRandom

private val telegramRecoveryRandom = SecureRandom()
private val falconTextMarker = Regex("فالکن|falcon", RegexOption.IGNORE_CASE)
private val bridgePayloadLine = Regex("BRIDGE BLOCK|^[A-Za-z0-9+/=]{20,}$")

/**
 * Recovered coroutine logic for the Telegram source path.
 *
 * JADX 1.5.7 could not reconstruct these state machines from the
 * upstream 1.2.49 APK. This implementation follows the bytecode fallback
 * control flow: the retry delays, stop checks, HTTP 404 handling, post
 * filtering, absorb counters, progress callback, and bounded page pacing.
 */
suspend fun recoverTelegramPageRetry(
    pool: ArgoPool,
    channel: String,
    beforeId: Long?,
    route: ArgoNet.Route?,
    shouldStop: ee.a
): ArgoPool.Page {
    var page = ArgoPool.Page(false, 0, emptyList())
    val retryDelays = longArrayOf(0L, 3_000L, 8_000L, 20_000L, 45_000L)

    for (waitMs in retryDelays) {
        if (waitMs > 0L) delay(waitMs)
        if (shouldStop.invoke() as Boolean) break

        page = pool.telegramPage(channel, beforeId, route)
        if (page.ok || page.code == 404) break
    }
    return page
}

/**
 * Reads a Telegram channel page-by-page, absorbing signed bridge blocks and
 * Falcon hosts while reporting page and server counters back to the UI.
 */
suspend fun recoverHarvestTelegram(
    pool: ArgoPool,
    source: ArgoPool.Source,
    maxPages: Int,
    route: ArgoNet.Route?,
    onProgress: ee.e,
    shouldStop: ee.a
): Int {
    val channel = source.value.lastOrNull()
        ?: throw IllegalStateException("کانال تلگرام برای این منبع تعریف نشده است")
    var beforeId: Long? = null
    var pageNumber = 0
    var totalServers = 0
    var consecutiveEmptyPages = 0

    while (pageNumber < maxPages) {
        if (shouldStop.invoke() as Boolean) break

        val page = recoverTelegramPageRetry(pool, channel, beforeId, route, shouldStop)
        if (!page.ok) {
            if (pageNumber > 0) break
            val message = when {
                page.code != 0 -> "کانال جواب نداد (کد ${page.code}) — نام کانال را بررسی کنید"
                route != null -> "تلگرام از راه «${route.label}» هم جواب نداد — اتصال همان موتور را بررسی کنید"
                else -> "تلگرام روی این اینترنت فیلتر است — اول یکی از موتورها (یا خود آرگو) را وصل کنید و دوباره «به‌روزرسانی» را بزنید"
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
            val absorbed = pool.absorbText(payload, source.id, timestamp, false, false)
            absorbedOnPage += absorbed.bridges + absorbed.falcons
        }

        pageNumber += 1
        totalServers += absorbedOnPage
        onProgress.invoke(pageNumber, totalServers)

        if (absorbedOnPage > 0) {
            consecutiveEmptyPages = 0
        } else {
            consecutiveEmptyPages += 1
        }

        val oldestPostId = posts.minOfOrNull { it.id } ?: break
        if (beforeId != null && oldestPostId < beforeId) break
        if (oldestPostId <= 1L) break
        if (consecutiveEmptyPages >= 6) break

        beforeId = oldestPostId
        if (pageNumber < maxPages) {
            delay(600L + telegramRecoveryRandom.nextInt(600).toLong())
        }
    }
    return totalServers
}
