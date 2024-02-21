package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

sealed interface JSONData {
    companion object: FSPTypedPattern<Char, JSONData?>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONData?> {
            TODO()
        }
    }
}

val JSONData.asObject: JSONObject get() {
    check(this is JSONObject) { "data is not object" }
    return this
}

val JSONData.asNumber: JSONNumber get() {
    check(this is JSONNumber) { "data is not number" }
    return this
}

val JSONData.asArray: JSONArray get() {
    check(this is JSONArray) { "data is not array" }
    return this
}

val JSONData.asBoolean: JSONBoolean get() {
    check(this is JSONBoolean) { "data is not boolean" }
    return this
}

val JSONData.asString: JSONString get() {
    check(this is JSONString) { "data is not string" }
    return this
}