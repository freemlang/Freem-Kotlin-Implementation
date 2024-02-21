package freem.compiler.partitions

import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.components.FSPTypedPattern
import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.asString
import libfsp.reference.FSPValue

sealed class Comment: FSPUnitPattern<Char>() {
    companion object: FSPUnitPattern<Char>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize() {
            switch {
                Inline.queue()
                Multiline.queue()
            }.queue()
        }
    }

    data object Inline: Comment() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize() {
            "//".queue()
            judge { it != '\n' }.greedyRepeat(0, null).queue()
            const('\n').optional().queue()
        }
    }

    data object Multiline: Comment() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize() {
            "/*".queue()
            judge { true }.lazyRepeat(0, null).queue()
            "*/".queue()
        }
    }
}
