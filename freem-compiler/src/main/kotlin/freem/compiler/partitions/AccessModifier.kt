package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

enum class AccessModifier {
    PUBLIC,
    PRIVATE,
    PROTECTED,
    INTERNAL
    ;
    companion object: FSPTypedPattern<Char, AccessModifier>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<AccessModifier> {
            val modifier by  switch<AccessModifier> {
                "public".queue(PUBLIC)
                "private".queue(PRIVATE)
                "protected".queue(PROTECTED)
                "internal".queue(INTERNAL)
            }.queue()

            return modifier
        }
    }
}
