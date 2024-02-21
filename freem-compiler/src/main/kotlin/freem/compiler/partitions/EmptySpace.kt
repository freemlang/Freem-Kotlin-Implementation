package freem.compiler.partitions

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.components.contexts.FSPTypedSwitchConstructDispatcher

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

context(FSPPatternInitializeDispatcher<Char>) val ` `: Unit get() { EmptySpace.queue() }
context(FSPPatternInitializeDispatcher<Char>) val ` ?`: Unit get() { OptionalEmptySpace.queue() }
context(FSPPatternInitializeDispatcher<Char>) val `|`: Unit get() { SeparateSpace.queue() }
context(FSPPatternInitializeDispatcher<Char>) val `|?`: Unit get() { OptionalSeparateSpace.queue() }

object EmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatcher<Char>.initialize() {
        switch {
            judge(Char::isWhitespace).lazyRepeat(1, null).queue()
            Comment.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalEmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatcher<Char>.initialize() {
        EmptySpace.optional().queue()
    }
}

object SeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatcher<Char>.initialize() {
        switch {
            EmptySpace.queue()
            ';'.queue()
        }.lazyRepeat(1, null).queue()
    }
}

object OptionalSeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatcher<Char>.initialize() {
        SeparateSpace.optional().queue()
    }
}