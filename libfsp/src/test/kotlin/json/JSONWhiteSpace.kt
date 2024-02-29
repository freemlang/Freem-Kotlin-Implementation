package json

import libfsp.components.FSPUnitComponent
import libfsp.components.contexts.FSPComponentListConstructDispatcher

internal object JSONWhiteSpace: FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        judge(Char::isWhitespace).greedyRepeat(0, null).queue()
    }
}

context(FSPComponentListConstructDispatcher<Char>)
internal val space: Unit get() {
    JSONWhiteSpace.queue()
}