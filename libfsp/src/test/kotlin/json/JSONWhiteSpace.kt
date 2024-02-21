package json

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher

internal object JSONWhiteSpace: FSPUnitPattern<Char>() {
    override fun FSPPatternInitializeDispatcher<Char>.initialize() {
        queue = judge(Char::isWhitespace).greedyRepeat(0, null)
    }
}

context(FSPPatternInitializeDispatcher<Char>)
internal val space: Unit get() {
    queue = JSONWhiteSpace
}