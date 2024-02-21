package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class Function private constructor(val name: Identifier, val returnType: Type) {
    companion object: FSPTypedPattern<Char, Function>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Function> {
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
            val type: FSPValue<Type>
            group {
                ':'.queue()
                ` ?`
                val type_ by Type.queue()
                type = type_
                ` ?`
            }.optional().queue()
            CodeBlock.queue()

            return value { Function(name.value, type.value) }
        }
    }
}