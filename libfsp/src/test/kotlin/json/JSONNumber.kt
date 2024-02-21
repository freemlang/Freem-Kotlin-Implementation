package json

class JSONNumber(private val rawValue: String): JSONData {
    val asByte: Byte get() = rawValue.toByte()
    val asShort: Short get() = rawValue.toShort()
    val asInt: Int get() = rawValue.toInt()
    val asLong: Long get() = rawValue.toLong()
    val asFloat: Float get() = rawValue.toFloat()
    val asDouble: Double get() = rawValue.toDouble()
}