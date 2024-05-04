import java.security.SecureRandom

fun main() {
    val int = SecureRandom().nextInt()
    println(int)
    println(int.hashCode())
}