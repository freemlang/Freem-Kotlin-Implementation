package freem.partition.analyzer.field

import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class CaptureObject internal constructor(): Future<String> {
    fun fin() {
        TODO("Not yet implemented")
    }

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCancelled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isDone(): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(): String {
        TODO("Not yet implemented")
    }

    override fun get(timeout: Long, unit: TimeUnit): String {
        TODO("Not yet implemented")
    }
}