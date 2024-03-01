package json

import libfsp.components.FSPUnitComponent
import libfsp.components.contexts.FSPEntityConstructDispatcher

internal data object JSONNull: JSONValue, FSPUnitComponent<Char>() {
    override fun FSPEntityConstructDispatcher<Char>.initialize() {
        "null".queue()
    }
}