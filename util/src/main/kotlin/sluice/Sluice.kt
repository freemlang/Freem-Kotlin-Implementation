package sluice

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

    suspend fun tryClose(): Boolean {
        if (continuation !== null) return false
        suspendCoroutine { continuation -> this.continuation = continuation }
        return true
    }

    fun tryOpen(): Boolean {
        val continuation = continuation
        if (continuation == null) return false
        continuation.resume(Unit)
        return true
    }

    fun isOpened() = continuation == null

    fun isClosed() = continuation !== null
}
