package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class Factor {
    companion object: FSPTypedPattern<Char, Factor>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Factor> {
            next = const('(')
            next = const(')')

            return value { Factor() }
        }
    }
}