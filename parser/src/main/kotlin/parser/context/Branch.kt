package parser.context

import parser.Parser
import tyfe.option.None
import tyfe.option.Option
import kotlin.reflect.KProperty

class Branch<in Input, Output>(internal val parser: Parser<Input, Output>) {
    internal var output: Option<Output> = None

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Output {
        val output = output
        check(output.isSome()) { "Branch is not used" }
        @Suppress("UNCHECKED_CAST")
        return output.unwrap() as Output
    }
}
