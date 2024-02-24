package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.components.FSPUnitPattern

sealed class Comment: FSPUnitPattern<Char>() {
    companion object: FSPUnitPattern<Char>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize() {
            switch {
                Inline.queue()
                Multiline.queue()
            }.queue()
        }
    }

    data object Inline: Comment() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize() {
            "//".queue()
            judge { it != '\n' }.greedyRepeat(0, null).queue()
            const('\n').optional().queue()
        }
    }

    data object Multiline: Comment() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize() {
            "/*".queue()
            judge { true }.lazyRepeat(0, null).queue()
            "*/".queue()
        }
    }
}
