package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class Class private constructor(
    val name: Identifier,
    val modifier: AccessModifier,
    val factor: Factor,
) {
    companion object: FSPTypedPattern<Char, Class>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<Class> {
            val modifier by AccessModifier.queue()
            ` `
            "class".queue()
            ` `
            val name by Identifier.queue()
            ` ?`
            val factor by Factor.queue()

            '{'.queue()

            '}'.queue()

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