package com.mlmvpn.scanner.engines.mami

/** RFC 4648 URL-safe Base64 without padding; independent of Android API level. */
internal object Base64UrlCodec {
    private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"
    private val reverse = IntArray(128) { -1 }.also { table ->
        ALPHABET.forEachIndexed { index, char -> table[char.code] = index }
    }

    fun encode(bytes: ByteArray): String {
        if (bytes.isEmpty()) return ""
        val output = StringBuilder((bytes.size * 4 + 2) / 3)
        var index = 0
        while (index + 3 <= bytes.size) {
            val a = bytes[index++].toInt() and 0xff
            val b = bytes[index++].toInt() and 0xff
            val c = bytes[index++].toInt() and 0xff
            output.append(ALPHABET[a ushr 2])
            output.append(ALPHABET[((a and 0x03) shl 4) or (b ushr 4)])
            output.append(ALPHABET[((b and 0x0f) shl 2) or (c ushr 6)])
            output.append(ALPHABET[c and 0x3f])
        }
        val remaining = bytes.size - index
        if (remaining == 1) {
            val a = bytes[index].toInt() and 0xff
            output.append(ALPHABET[a ushr 2])
            output.append(ALPHABET[(a and 0x03) shl 4])
        } else if (remaining == 2) {
            val a = bytes[index].toInt() and 0xff
            val b = bytes[index + 1].toInt() and 0xff
            output.append(ALPHABET[a ushr 2])
            output.append(ALPHABET[((a and 0x03) shl 4) or (b ushr 4)])
            output.append(ALPHABET[(b and 0x0f) shl 2])
        }
        return output.toString()
    }

    fun decode(value: String): ByteArray {
        require(value.isNotEmpty() && value.length % 4 != 1) { "Invalid Base64URL length" }
        require(value.all { it.code < reverse.size && reverse[it.code] >= 0 }) {
            "Invalid Base64URL character"
        }
        val output = ByteArray(value.length * 3 / 4 + 2)
        var out = 0
        var accumulator = 0
        var bits = 0
        value.forEach { char ->
            accumulator = (accumulator shl 6) or reverse[char.code]
            bits += 6
            if (bits >= 8) {
                bits -= 8
                output[out++] = (accumulator ushr bits).toByte()
                accumulator = accumulator and ((1 shl bits) - 1)
            }
        }
        require(accumulator == 0) { "Non-canonical Base64URL trailing bits" }
        return output.copyOf(out)
    }
}
