package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class Function private constructor(val name: Identifier, val returnType: Type) {
    companion object: FSPTypedPattern<Char, Function>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Function> {
            next = AccessModifier
            ` `
            next = switch {
                case = const("infix")
                case = const("inline")
            }.optional()
            ` `
            next = const("func")
            next = switch {
                case = ` `
                case = group {
                    ` ?`
                    // TODO: add partition Generic
                    ` ?`
                }
            }
            val name: FSPValue<Identifier>
            next = Identifier.also { name = it.fspvalue }
            ` ?`
            next = Factor
            ` ?`
            val type: FSPValue<Type>
            next = group {
                next = const(':')
                ` ?`
                next = Type.also { type = it.fspvalue }
                ` ?`
            }.optional()
            next = CodeBlock

            return value { Function(name.value, type.value) }
        }
    }
}