package parser.context.branchcontext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import parser.Parser
import java.util.*

class BranchContext<out Input> internal constructor(private val coroutineScope: CoroutineScope) {
    internal val tasks: LinkedList<Deferred<*>> = TODO()

    fun <Output, Error> case(parser: Parser<Input, Output, Error>): Case<Output, Error> {
        val deferred = coroutineScope.async {
            val context =
            with (parser) {  }
        }
        TODO()
    }

    suspend fun run() {

    }
}