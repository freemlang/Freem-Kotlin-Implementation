package freem.compiler.partitions

import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.asString
import libfsp.reference.FSPValue

class Identifier private constructor(val value: String) {
    companion object: FSPTypedPattern<Char, Identifier>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            val name by group {
                letter.queue()
                judge { letter(it) || it.isDigit() }.lazyRepeat(0, null).queue()
            }.queue().asString

            return value { Identifier(name.value) }
        }
    }
}