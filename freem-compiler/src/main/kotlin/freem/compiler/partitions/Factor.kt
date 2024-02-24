package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class Factor {
    companion object: FSPTypedPattern<Char, Factor>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Factor> {
            '('.queue()
            ')'.queue()

            return value { Factor() }
        }
    }
}