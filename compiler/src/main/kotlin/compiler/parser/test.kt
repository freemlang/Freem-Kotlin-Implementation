package compiler.parser

import parser.Context
import parser.Parser
import parser.State
import tyfe.option.Option

class Test : Parser<Char, Unit> {
    override fun Context.next(input: Option<Char>): State<Char, Unit> {
        TODO("Not yet implemented")
    }
}
