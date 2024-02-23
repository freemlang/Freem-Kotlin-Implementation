package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class JSONBoolean: JSONValue {
    companion object: FSPTypedPattern<Char, JSONBoolean>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONBoolean> {
            TODO("Not yet implemented")
        }
    }
}