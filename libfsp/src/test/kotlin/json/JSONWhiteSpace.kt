package json

import libfsp.components.FSPUnitPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher

internal object JSONWhiteSpace: FSPUnitPattern<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        judge(Char::isWhitespace).greedyRepeat(0, null).queue()
    }
}

context(FSPComponentListConstructDispatcher<Char>)
internal val space: Unit get() {
    JSONWhiteSpace.queue()
}