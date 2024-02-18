package freem.compiler.partitions

import libfsp.components.contexts.FSPPatternContext
import libfsp.components.FSPTypedPattern
import libfsp.reference.FSPValue

sealed class Comment: FSPTypedPattern<Char, String>() {
    companion object: FSPTypedPattern<Char, String>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<String> {
            next = switch {
                next = Inline
                next = Multiline
            }
            return next.asString
        }
    }

    data object Inline: Comment() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<String> {
            next = const("//")
            next = greedyRepeat(0, null, judge { it != '\n' })
            val content = next.asString
            next = const('\n').optional()
            return content
        }
    }

    data object Multiline: Comment() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<String> {
            next = const("/*")
            next = lazyRepeat(0, null, judge { true })
            val content = next.asString
            next = const("*/")
            return content
        }
    }
}
