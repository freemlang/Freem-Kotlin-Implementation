package json

import libfsp.components.FSPUnitComponent
import libfsp.components.contexts.FSPEntityConstructDispatcher

internal object JSONWhiteSpace: FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        judge(Char::isWhitespace).greedyRepeat(0, null).queue()
    }
}

context(FSPEntityConstructDispatcher<Char>)
internal val space: Unit get() {
    JSONWhiteSpace.queue()
}