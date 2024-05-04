fun main() {
    val map = mutableMapOf<String, Unit?>()
    map["a"] = Unit
    map["b"] = null

    println(map.getValue("a"))
    println(map.getValue("b"))
}