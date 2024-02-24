package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

sealed interface JSONValue {
    companion object: FSPTypedPattern<Char, JSONValue>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<JSONValue> {
            TODO()
        }
    }
}

val JSONValue.asObject: JSONObject get() {
    check(this is JSONObject) { "data is not object" }
    return this
}

val JSONValue.asNumber: JSONNumber get() {
    check(this is JSONNumber) { "data is not number" }
    return this
}

val JSONValue.asArray: JSONArray get() {
    check(this is JSONArray) { "data is not array" }
    return this
}

val JSONValue.asBoolean: JSONBoolean get() {
    check(this is JSONBoolean) { "data is not boolean" }
    return this
}

val JSONValue.asString: JSONString get() {
    check(this is JSONString) { "data is not string" }
    return this
}