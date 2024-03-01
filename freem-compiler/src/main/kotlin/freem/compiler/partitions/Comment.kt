package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher

sealed class Comment: FSPUnitComponent<Char>() {
    companion object: FSPUnitComponent<Char>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize() {
            switch {
                Inline.queue()
                Multiline.queue()
            }.queue()
        }
    }

    data object Inline: Comment() {
        override fun FSPEntityConstructDispatcher<Char>.initialize() {
            "//".queue()
            judge { it != '\n' }.greedyRepeat(0, null).queue()
            const('\n').optional().queue()
        }
    }

    data object Multiline: Comment() {
        override fun FSPEntityConstructDispatcher<Char>.initialize() {
            "/*".queue()
            judge { true }.lazyRepeat(0, null).queue()
            "*/".queue()
        }
    }
}
