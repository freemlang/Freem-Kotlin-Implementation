package compiler.parser

import lagacyparser.Context
import lagacyparser.Parser
import lagacyparser.State
import tyfe.option.Option

class Test : Parser<Char, Unit> {
    override fun Context.next(input: Option<Char>): State<Char, Unit> {
        TODO("Not yet implemented")
    }
}
