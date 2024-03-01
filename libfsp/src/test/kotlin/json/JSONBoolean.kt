package json

import libfsp.components.FSPTypedComponent
import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class JSONBoolean: JSONValue {
    companion object: FSPTypedComponent<Char, JSONBoolean>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<JSONBoolean> {
            TODO("Not yet implemented")
        }
    }
}