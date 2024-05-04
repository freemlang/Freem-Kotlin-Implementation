import java.util.*
import kotlin.system.measureNanoTime

fun main() {
    val runtime = Runtime.getRuntime()
    var elapsedRecord = 0L

    while (true) {
        print("enter depth: ")
        val depth = Scanner(System.`in`).nextInt()

        if (depth <= 0) {
            println("exit")
            break
        }

        var a = A { println("last a called") }

        repeat(depth - 1) {
            val aref = a
            a = A { aref.call() }
        }

        val elapsed = measureNanoTime {
            a.call()
        }

        val elapsedDiff = elapsed - elapsedRecord

        println("elapsed: ${elapsed}ns (${
            (if (elapsedDiff >= 0) "+" else "") + elapsedDiff
        }, x${
            if (elapsedRecord != 0L)
                elapsed.toDouble() / elapsedRecord
            else "?"
        })")

        val totalMemory = runtime.totalMemory().toDouble()
        val freeMemory = runtime.freeMemory().toDouble()
        val usedMemory = totalMemory - freeMemory

        println("total memory: ${totalMemory / (1024 * 1024)}MB ${totalMemory / 1024}KB")
        println("free memory: ${freeMemory / (1024 * 1024)}MB ${freeMemory / 1024}KB")
        println("used memory: ${usedMemory / (1024 * 1024)}MB ${usedMemory / 1024}KB")

        println()

        elapsedRecord = elapsed
    }

}

class A(private val block: () -> Unit) {
    fun call() {
        block()
    }
}