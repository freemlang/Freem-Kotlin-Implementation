package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class Function private constructor(val name: Identifier, val returnType: Type) {
    companion object: FSPTypedComponent<Char, Function>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Function> {
            AccessModifier.queue()
            ` `
            switch {
                "infix".queue()
                "inline".queue()
            }.optional().queue()
            ` `
            "func".queue()
            switch {
                ` `
                group {
                    ` ?`
                    // TODO: add partition Generic
                    ` ?`
                }.queue()
            }.queue()
            val name by Identifier.queue()
            ` ?`
            Factor.queue()
            ` ?`
            val type by group<Type> {
                ':'.queue()
                ` ?`
                val type by Type.queue()
                ` ?`
                type
            }.optional().queue()
            CodeBlock.queue()

            return value { Function(name.value, type.value?:Type.Void) }
        }
    }
}