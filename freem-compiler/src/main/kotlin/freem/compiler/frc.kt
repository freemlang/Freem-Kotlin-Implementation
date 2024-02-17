package freem.compiler

import kotlin.time.TimeSource

fun main() {
    val mark = TimeSource.Monotonic.markNow()

    val elapsed = mark.elapsedNow()
    println("\nuptime: ${elapsed.inWholeSeconds}s ${elapsed.inWholeMilliseconds}ms ${elapsed.inWholeMicroseconds}μs")
}
