package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.reference.FSPValue

enum class AccessModifier {
    PUBLIC,
    PRIVATE,
    PROTECTED,
    INTERNAL
    ;
    companion object: FSPTypedPattern<Char, AccessModifier>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<AccessModifier> {
            val switch = switch<AccessModifier> {
                case[PUBLIC]    = const("public")
                case[PRIVATE]   = const("private")
                case[PROTECTED] = const("protected")
                case[INTERNAL]  = const("internal")
            }
            next = switch

            return switch.fspvalue
        }
    }
}
