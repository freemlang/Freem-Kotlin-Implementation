package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

enum class AccessModifier {
    PUBLIC,
    PRIVATE,
    PROTECTED,
    INTERNAL
    ;
    companion object: FSPTypedComponent<Char, AccessModifier>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<AccessModifier> {
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
