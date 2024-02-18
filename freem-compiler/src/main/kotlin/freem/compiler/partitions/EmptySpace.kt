package freem.compiler.partitions

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.components.contexts.FSPSwitchContext
import libfsp.components.contexts.FSPTypedSwitchContext

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

val FSPPatternContext<Char>.` `: Unit get() { next = EmptySpace }
val FSPPatternContext<Char>.` ?`: Unit get() { next = OptionalEmptySpace }
val FSPPatternContext<Char>.`|`: Unit get() { next = SeparateSpace }
val FSPPatternContext<Char>.`|?`: Unit get() { next = OptionalSeparateSpace }

val FSPSwitchContext<Char>.` ` get() = EmptySpace
val FSPSwitchContext<Char>.` ?` get() = OptionalEmptySpace
val FSPSwitchContext<Char>.`|` get() = SeparateSpace
val FSPSwitchContext<Char>.`|?` get() = OptionalSeparateSpace

val FSPTypedSwitchContext<Char, *>.` ` get() = EmptySpace
val FSPTypedSwitchContext<Char, *>.` ?` get() = OptionalEmptySpace
val FSPTypedSwitchContext<Char, *>.`|` get() = SeparateSpace
val FSPTypedSwitchContext<Char, *>.`|?` get() = OptionalSeparateSpace

object EmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = switch {
            case = judge(Char::isWhitespace).lazyRepeat(1, null)
            case = Comment
        }.lazyRepeat(1, null)
    }
}

object OptionalEmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = EmptySpace.optional()
    }
}

object SeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = switch {
            case = EmptySpace
            case = const(';')
        }.lazyRepeat(1, null)
    }
}

object OptionalSeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = SeparateSpace.optional()
    }
}