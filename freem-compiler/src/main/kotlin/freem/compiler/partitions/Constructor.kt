package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class Constructor {
    companion object: FSPTypedComponent<Char, Constructor>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Constructor> {
            AccessModifier.queue()
            ` `
            "constructor".queue()
            ` ?`
            Factor.queue()
            ` ?`
            CodeBlock.queue()

            return value { Constructor() }
        }
    }
}