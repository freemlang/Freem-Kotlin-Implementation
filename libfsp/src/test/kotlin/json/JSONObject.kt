package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeDispatcher
import libfsp.reference.FSPValue

class JSONObject: JSONValue {
    companion object: FSPTypedPattern<Char, JSONObject>() {
        override fun FSPPatternInitializeDispatcher<Char>.initialize(): FSPValue<JSONObject> {
            '{'.queue()
            space
            val pairPattern = group {
                JSONString.queue()
                space
                ':'.queue()
                space
                JSONValue.queue()
            }
            group {
                pairPattern.queue()
                group {
                    space
                    ','.queue()
                    space
                    pairPattern.queue()
                }.lazyRepeat(0, null)
            }.optional().queue()
            space
            '}'.queue()
            return value {
                JSONObject()
            }
        }
    }

    override fun toString(): String {
        return """
            
        """.trimIndent()
    }
}