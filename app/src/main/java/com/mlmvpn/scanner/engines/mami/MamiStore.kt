package com.mlmvpn.scanner.engines.mami

import android.content.Context
import org.json.JSONObject
import java.io.File
import java.nio.charset.StandardCharsets

/** Small atomic JSON store used for Mami's device identity, API tokens and cached catalog. */
class MamiStore(context: Context) {
    private val root = File(context.applicationContext.filesDir, "mami").apply { mkdirs() }

    fun readText(name: String): String? {
        requireSafeName(name)
        val file = File(root, name)
        return if (file.isFile && file.length() <= MAX_FILE_BYTES) {
            runCatching { file.readText(StandardCharsets.UTF_8) }.getOrNull()
        } else null
    }

    fun readJson(name: String): JSONObject? =
        readText(name)?.let { runCatching { JSONObject(it) }.getOrNull() }

    @Synchronized
    fun writeText(name: String, value: String) {
        requireSafeName(name)
        require(value.toByteArray(StandardCharsets.UTF_8).size <= MAX_FILE_BYTES) {
            "Mami store item exceeds the size limit"
        }
        val destination = File(root, name)
        val temporary = File(root, "$name.tmp")
        temporary.writeText(value, StandardCharsets.UTF_8)
        if (destination.exists() && !destination.delete()) {
            temporary.delete()
            throw IllegalStateException("Could not replace Mami store item")
        }
        if (!temporary.renameTo(destination)) {
            temporary.delete()
            throw IllegalStateException("Could not persist Mami store item")
        }
    }

    fun writeJson(name: String, value: JSONObject) = writeText(name, value.toString())

    @Synchronized
    fun delete(name: String) {
        requireSafeName(name)
        File(root, name).takeIf { it.exists() }?.delete()
    }

    private fun requireSafeName(name: String) {
        require(name.matches(Regex("[A-Za-z0-9._-]{1,80}")) && !name.contains("..")) {
            "Invalid Mami store key"
        }
    }

    companion object {
        private const val MAX_FILE_BYTES = 1_048_576
    }
}
