package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class Factor {
    companion object: FSPTypedComponent<Char, Factor>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Factor> {
            '('.queue()
            ')'.queue()

            return value { Factor() }
        }
    }
}