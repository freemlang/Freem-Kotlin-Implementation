package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: FSPTypedPattern<Char, Class>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Class> {
            val modifier: FSPValue<AccessModifier>
            next = AccessModifier.also { modifier = it.fspvalue }
            next = ` `
            next = const("class")
            next = ` `
            val name: FSPValue<Identifier>
            next = Identifier.also { name = it.fspvalue }
            next = ` ?`
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