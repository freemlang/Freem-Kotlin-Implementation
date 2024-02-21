package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class Constructor {
    companion object: FSPTypedPattern<Char, Constructor>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Constructor> {
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