package freem.compiler.partitions

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.components.contexts.FSPSwitchConstructDispatchReceiver
import libfsp.components.contexts.FSPTypedSwitchConstructDispatchReceiver

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

val FSPPatternInitializeDispatchReceiver<Char>.` `: Unit get() { next = EmptySpace }
val FSPPatternInitializeDispatchReceiver<Char>.` ?`: Unit get() { next = OptionalEmptySpace }
val FSPPatternInitializeDispatchReceiver<Char>.`|`: Unit get() { next = SeparateSpace }
val FSPPatternInitializeDispatchReceiver<Char>.`|?`: Unit get() { next = OptionalSeparateSpace }

val FSPSwitchConstructDispatchReceiver<Char>.` ` get() = EmptySpace
val FSPSwitchConstructDispatchReceiver<Char>.` ?` get() = OptionalEmptySpace
val FSPSwitchConstructDispatchReceiver<Char>.`|` get() = SeparateSpace
val FSPSwitchConstructDispatchReceiver<Char>.`|?` get() = OptionalSeparateSpace

val FSPTypedSwitchConstructDispatchReceiver<Char, *>.` ` get() = EmptySpace
val FSPTypedSwitchConstructDispatchReceiver<Char, *>.` ?` get() = OptionalEmptySpace
val FSPTypedSwitchConstructDispatchReceiver<Char, *>.`|` get() = SeparateSpace
val FSPTypedSwitchConstructDispatchReceiver<Char, *>.`|?` get() = OptionalSeparateSpace

object EmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatchReceiver<Char>.initialize() {
        next = switch {
            case = judge(Char::isWhitespace).lazyRepeat(1, null)
            case = Comment
        }.lazyRepeat(1, null)
    }
}

object OptionalEmptySpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatchReceiver<Char>.initialize() {
        next = EmptySpace.optional()
    }
}

object SeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatchReceiver<Char>.initialize() {
        next = switch {
            case = EmptySpace
            case = const(';')
        }.lazyRepeat(1, null)
    }
}

object OptionalSeparateSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatchReceiver<Char>.initialize() {
        next = SeparateSpace.optional()
    }
}