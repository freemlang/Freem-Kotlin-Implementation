package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class Constructor {
    companion object: FSPTypedPattern<Char, Constructor>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Constructor> {
            next = AccessModifier
            next = ` `
            next = const("constructor")
            next = ` ?`
            next = Factor
            next = ` ?`
            next = CodeBlock

            return value { Constructor() }
        }
    }
}