package coroutines.sluice

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Sluice {
    private var continuation: Continuation<Unit>? = null

    suspend fun close() {
        check(continuation == null) { "Sluice is already closed" }
        suspendCoroutine { continuation -> this.continuation = continuation }
    }

    fun open() {
        val continuation = continuation
        check(continuation !== null) { "Sluice is already opened" }
        continuation!!.resume(Unit)
    }

    fun tryOpen(): Boolean {
        val continuation = continuation ?: return false
        continuation.resume(Unit)
        return true
    }

    fun isOpened() = continuation == null

    fun isClosed() = continuation !== null
}
