package freem.compiler.partitions

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.components.contexts.FSPSwitchConstructContext
import libfsp.components.contexts.FSPTypedSwitchConstructContext

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

val FSPPatternInitializeContext<Char>.` `: Unit get() { next = EmptySpace }
val FSPPatternInitializeContext<Char>.` ?`: Unit get() { next = OptionalEmptySpace }
val FSPPatternInitializeContext<Char>.`|`: Unit get() { next = SeparateSpace }
val FSPPatternInitializeContext<Char>.`|?`: Unit get() { next = OptionalSeparateSpace }

val FSPSwitchConstructContext<Char>.` ` get() = EmptySpace
val FSPSwitchConstructContext<Char>.` ?` get() = OptionalEmptySpace
val FSPSwitchConstructContext<Char>.`|` get() = SeparateSpace
val FSPSwitchConstructContext<Char>.`|?` get() = OptionalSeparateSpace

val FSPTypedSwitchConstructContext<Char, *>.` ` get() = EmptySpace
val FSPTypedSwitchConstructContext<Char, *>.` ?` get() = OptionalEmptySpace
val FSPTypedSwitchConstructContext<Char, *>.`|` get() = SeparateSpace
val FSPTypedSwitchConstructContext<Char, *>.`|?` get() = OptionalSeparateSpace

object EmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeContext<Char>.initialize() {
        next = switch {
            case = judge(Char::isWhitespace).lazyRepeat(1, null)
            case = Comment
        }.lazyRepeat(1, null)
    }
}

object OptionalEmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeContext<Char>.initialize() {
        next = EmptySpace.optional()
    }
}

object SeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeContext<Char>.initialize() {
        next = switch {
            case = EmptySpace
            case = const(';')
        }.lazyRepeat(1, null)
    }
}

object OptionalSeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeContext<Char>.initialize() {
        next = SeparateSpace.optional()
    }
}