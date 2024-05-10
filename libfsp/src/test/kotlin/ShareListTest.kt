fun main() {
    val l1 = MutableList(10) { it }
    val l2 = l1.subList(0, 4)
    l2[0] = 100
    println(l1)
}