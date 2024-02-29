package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

context(FSPComponentListConstructDispatcher<Char>) val ` `: Unit get() { EmptySpace.queue() }
context(FSPComponentListConstructDispatcher<Char>) val ` ?`: Unit get() { OptionalEmptySpace.queue() }
context(FSPComponentListConstructDispatcher<Char>) val `|`: Unit get() { SeparateSpace.queue() }
context(FSPComponentListConstructDispatcher<Char>) val `|?`: Unit get() { OptionalSeparateSpace.queue() }

object EmptySpace: FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        switch {
            judge(Char::isWhitespace).lazyRepeat(1, null).queue()
            Comment.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalEmptySpace: FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        EmptySpace.optional().queue()
    }
}

object SeparateSpace: FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        switch {
            EmptySpace.queue()
            ';'.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalSeparateSpace: FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        SeparateSpace.optional().queue()
    }
}