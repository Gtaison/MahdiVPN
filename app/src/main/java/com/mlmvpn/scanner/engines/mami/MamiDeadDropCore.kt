package com.mlmvpn.scanner.engines.mami

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.selects.select
import okhttp3.OkHttpClient
import okhttp3.Request
import java.nio.charset.StandardCharsets
import java.util.Locale
import java.util.concurrent.TimeUnit

/** Resolves the current Mami API hostname from the two upstream dead-drop documents. */
class MamiDeadDropCore(
    private val userAgent: String = DEFAULT_USER_AGENT
) {
    data class Source(val id: String, val url: String)
    data class FetchResult(val source: Source, val host: String?, val error: String? = null)
    data class Outcome(val host: String?, val source: String?, val results: List<FetchResult>)

    private val sources = listOf(
        Source(
            "google-doc",
            "https://docs.google.com/document/d/1jqH4YHTkBy-6m6Mdmw8LqQHESgLjOdlJv7XoXxgZuvI/export?format=txt"
        ),
        Source(
            "github-raw",
            "https://raw.githubusercontent.com/YamYamVPN/refactored-barnacle/refs/heads/main/LOREM"
        )
    )

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(12, TimeUnit.SECONDS)
        .callTimeout(14, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build()

    suspend fun resolve(): Outcome = coroutineScope {
        val pending = sources.map { source -> async(Dispatchers.IO) { fetchSource(source) } }.toMutableList()
        val results = mutableListOf<FetchResult>()
        while (pending.isNotEmpty()) {
            val (completed, result) = select<Pair<Deferred<FetchResult>, FetchResult>> {
                pending.forEach { deferred ->
                    deferred.onAwait { deferred to it }
                }
            }
            pending.remove(completed)
            results += result
            if (result.host != null) {
                pending.forEach { it.cancel() }
                return@coroutineScope Outcome(result.host, result.source.id, results)
            }
        }
        Outcome(null, null, results)
    }

    fun extractDomain(document: String): String? {
        val pattern = Regex(
            """volutpat\.[ \t\u000B\u000C\r]+([A-Za-z0-9.-]{1,200})[ \t\u000B\u000C\r]+Ut wisi enim(?![A-Za-z0-9_])[^\n\r\u2028\u2029]*(?<![A-Za-z0-9_])commodo consequat\.[ \t\u000B\u000C\r]+\.?([A-Za-z]{2,24})$""",
            RegexOption.IGNORE_CASE
        )
        document.lineSequence().forEach { raw ->
            val line = raw
                .replace(Regex("[\u200c\u200f\u200e\u202a-\u202e]"), "")
                .trim()
                .trimEnd('.')
            val match = pattern.find(line) ?: return@forEach
            val host = (match.groupValues[1] + "." + match.groupValues[2]).lowercase(Locale.ROOT)
            if (isValidHost(host)) return host
        }
        return null
    }

    fun isValidHost(host: String): Boolean {
        if (host.length !in 4..253 || host.endsWith(".invalid", ignoreCase = true)) return false
        if (host.any { !(it.isLetterOrDigit() || it == '.' || it == '-') }) return false
        val labels = host.lowercase(Locale.ROOT).split('.')
        if (labels.size < 2) return false
        val tld = labels.last()
        if (tld.length !in 2..24 || !tld.all { it in 'a'..'z' }) return false
        return labels.all { label ->
            label.isNotEmpty() && label.length <= 63 &&
                label.first() != '-' && label.last() != '-' &&
                label.all { it in 'a'..'z' || it in '0'..'9' || it == '-' }
        }
    }

    private fun fetchSource(source: Source): FetchResult {
        return try {
            val request = Request.Builder()
                .url(source.url)
                .header("User-Agent", userAgent)
                .header("Accept", "text/plain,*/*")
                .header("Cache-Control", "no-cache")
                .build()
            client.newCall(request).execute().use { response ->
                require(response.isSuccessful) { "HTTP ${response.code}" }
                val bytes = response.body?.bytes() ?: ByteArray(0)
                require(bytes.isNotEmpty() && bytes.size <= MAX_DOCUMENT_BYTES) {
                    "Dead-drop document is empty or too large"
                }
                val text = String(bytes, StandardCharsets.UTF_8)
                val host = extractDomain(text)
                if (host == null) FetchResult(source, null, "No valid host marker found")
                else FetchResult(source, host)
            }
        } catch (failure: Throwable) {
            FetchResult(source, null, failure.message ?: failure.javaClass.simpleName)
        }
    }

    companion object {
        const val DEFAULT_USER_AGENT = "Dalvik/2.1.0 (Linux; U; Android 14; Mami)"
        private const val MAX_DOCUMENT_BYTES = 524_288
    }
}
