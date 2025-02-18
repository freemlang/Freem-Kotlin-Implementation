package parser.context.branchcontext

import kotlinx.coroutines.Deferred
import tyfe.result.Result
import kotlin.reflect.KProperty

class Case<out Output, out Error> internal constructor(private val deferred: Deferred<Result<Output, Error>>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Result<Output, Error> {
        check(deferred.isCompleted) { "Case is not completed yet" }
    }
}