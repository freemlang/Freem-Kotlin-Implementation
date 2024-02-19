package freem.compiler.partitions

import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.components.FSPTypedPattern
import libfsp.reference.FSPValue

sealed class Comment: FSPTypedPattern<Char, String>() {
    companion object: FSPTypedPattern<Char, String>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<String> {
            next = switch {
                next = Inline
                next = Multiline
            }
            return next.valueAsString
        }
    }

    data object Inline: Comment() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<String> {
            next = const("//")
            next = judge { it != '\n' }.greedyRepeat(0, null)
            val content = next.valueAsString
            next = const('\n').optional()
            return content
        }
    }

    data object Multiline: Comment() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<String> {
            next = const("/*")
            next = judge { true }.lazyRepeat(0, null)
            val content = next.valueAsString
            next = const("*/")
            return content
        }
    }
}
