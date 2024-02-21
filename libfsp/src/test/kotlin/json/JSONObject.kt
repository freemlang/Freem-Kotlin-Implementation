package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class JSONObject: JSONData {
    companion object: FSPTypedPattern<Char, JSONObject>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONObject> {

        }
    }
}