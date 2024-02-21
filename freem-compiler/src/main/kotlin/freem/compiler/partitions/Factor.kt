package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class Factor {
    companion object: FSPTypedPattern<Char, Factor>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Factor> {
            '('.queue()
            ')'.queue()

            return value { Factor() }
        }
    }
}