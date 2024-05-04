import java.util.LinkedHashMap

fun main() {
    val mutableMap = mapOf(1 to 0, 2 to 0) as LinkedHashMap<Int, Int>
    mutableMap[3] = 0
    println(mutableMap)
}