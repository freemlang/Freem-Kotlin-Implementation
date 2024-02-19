package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.reference.FSPValue

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: FSPTypedPattern<Char, Class>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<Class> {
            val modifier: FSPValue<AccessModifier>
            next = AccessModifier.also { modifier = it.fspvalue }
            ` `
            next = const("class")
            ` `
            val name: FSPValue<Identifier>
            next = Identifier.also { name = it.fspvalue }
            ` ?`
            val factor: FSPValue<Factor>
            next = Factor.also { factor = it.fspvalue }

            next = const('{')

            next = const('}')

            return value {
                Class(
                    name.value,
                    modifier.value,
                    factor.value,
                )
            }
        }
    }
}