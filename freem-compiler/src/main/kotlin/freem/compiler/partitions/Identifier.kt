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
                next = lazyRepeat(0, null, judge { letter(it) || it.isDigit() })
            }

            val name = next.asString

            return value { Identifier(name.value) }
        }
    }
}