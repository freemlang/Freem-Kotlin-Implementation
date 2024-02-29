package json

import libfsp.components.FSPUnitComponent
import libfsp.components.contexts.FSPComponentListConstructDispatcher

internal data object JSONNull: JSONValue, FSPUnitComponent<Char>() {
    override fun FSPComponentListConstructDispatcher<Char>.initialize() {
        "null".queue()
    }
}