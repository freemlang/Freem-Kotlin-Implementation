package parser.context

import parser.Parser
import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some
import kotlin.reflect.KProperty

class Branch<in Input, out Output>(internal val parser: Parser<Input, Output>) {
    private var output: Option<Output> = None

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Output {
        val output = output
        check(output is Some) { "Branch is not used" }
        return output.unwrap()
    }
}
