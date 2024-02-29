package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class Factor {
    companion object: FSPTypedComponent<Char, Factor>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Factor> {
            '('.queue()
            ')'.queue()

            return value { Factor() }
        }
    }
}