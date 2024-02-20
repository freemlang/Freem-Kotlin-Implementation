package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.reference.FSPValue

class Constructor {
    companion object: FSPTypedPattern<Char, Constructor>() {
        override fun FSPPatternInitializeDispatchReceiver<Char>.initialize(): FSPValue<Constructor> {
            next = AccessModifier
            ` `
            next = const("constructor")
            ` ?`
            next = Factor
            ` ?`
            next = CodeBlock

            return value { Constructor() }
        }
    }
}