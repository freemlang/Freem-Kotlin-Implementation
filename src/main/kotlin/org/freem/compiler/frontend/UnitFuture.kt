package org.freem.compiler.frontend

import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

object UnitFuture: Future<Unit> {
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
    override fun isCancelled(): Boolean = false
    override fun isDone(): Boolean = true
    override fun get() = Unit
    override fun get(timeout: Long, unit: TimeUnit) = Unit
}