package freem.compiler.partitions

import libfsp.components.FSPVoidPattern
import libfsp.components.contexts.FSPPatternContext

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

object EmptySpace: FSPVoidPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = switch {
            case = judge(Char::isWhitespace).lazyRepeat(1, null)
            case = Comment
        }.lazyRepeat(1, null)
    }
}

object OptionalEmptySpace: FSPVoidPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = EmptySpace.optional()
    }
}

object SeparateSpace: FSPVoidPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = switch {
            case = EmptySpace
            case = const(';')
        }.lazyRepeat(1, null)
    }
}

object OptionalSeparateSpace: FSPVoidPattern<Char>() {
    override fun FSPPatternContext<Char>.initialize() {
        next = SeparateSpace.optional()
    }
}