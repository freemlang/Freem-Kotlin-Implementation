package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

context(FSPEntityConstructDispatcher<Char>) val ` `: Unit get() { EmptySpace.queue() }
context(FSPEntityConstructDispatcher<Char>) val ` ?`: Unit get() { OptionalEmptySpace.queue() }
context(FSPEntityConstructDispatcher<Char>) val `|`: Unit get() { SeparateSpace.queue() }
context(FSPEntityConstructDispatcher<Char>) val `|?`: Unit get() { OptionalSeparateSpace.queue() }

object EmptySpace: FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        switch {
            judge(Char::isWhitespace).lazyRepeat(1, null).queue()
            Comment.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalEmptySpace: FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        EmptySpace.optional().queue()
    }
}

object SeparateSpace: FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        switch {
            EmptySpace.queue()
            ';'.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalSeparateSpace: FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        SeparateSpace.optional().queue()
    }
}