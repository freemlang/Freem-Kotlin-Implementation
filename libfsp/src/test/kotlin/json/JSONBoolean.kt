package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class JSONBoolean: JSONValue {
    companion object: FSPTypedPattern<Char, JSONBoolean>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<JSONBoolean> {
            TODO("Not yet implemented")
        }
    }
}