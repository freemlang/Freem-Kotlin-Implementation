package json

import libfsp.components.FSPTypedComponent
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class JSONBoolean: JSONValue {
    companion object: FSPTypedComponent<Char, JSONBoolean>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<JSONBoolean> {
            TODO("Not yet implemented")
        }
    }
}