package freem.compiler.partitions

import libfsp.components.contexts.FSPPatternContext
import libfsp.components.FSPTypedPattern
import libfsp.reference.FSPValue

class Identifier private constructor(val value: String) {
    companion object: FSPTypedPattern<Char, Identifier>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Identifier> {
            val letter = { char: Char -> char in 'a'..'z' || char in 'A'..'Z' }

            next = group {
                next = judge(letter)
                next = judge { letter(it) || it.isDigit() }.lazyRepeat(0, null)
            }

            val name = next.valueAsString

            return value { Identifier(name.value) }
        }
    }
}