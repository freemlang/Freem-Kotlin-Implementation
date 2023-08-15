package org.freem.tools.scope

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import platform.posix.atexit
import kotlin.time.TimeSource

fun DeferScope.checkElapsed() {
    val mark = TimeSource.Monotonic.markNow()
    defer {
        val elapsed = mark.elapsedNow()
        println("\nuptime: ${elapsed.inWholeSeconds}s ${elapsed.inWholeMilliseconds}ms ${elapsed.inWholeMicroseconds}μs")
    }
}