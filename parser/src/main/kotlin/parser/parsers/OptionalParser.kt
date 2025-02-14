package parser.parsers

import parser.Context
import parser.Parser
import parser.State
import tyfe.option.Option

class OptionalParser<out Input, out Output>(val parser: Parser<Input, Output>) :
    Parser<Input, Option<Output>> {
    override fun Context.next(input: Option<@UnsafeVariance Input>): State<Input, Option<Output>> {
        return request()
    }
}
