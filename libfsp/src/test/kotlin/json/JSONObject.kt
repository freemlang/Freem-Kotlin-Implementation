package json

import libfsp.components.FSPTypedComponent
import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

sealed interface JSONObject: JSONValue, Map<String, JSONValue> {

}
sealed interface JSONMutableObject: JSONObject, MutableMap<String, JSONValue>

internal class JSONHashObject(private val map: MutableMap<String, JSONValue>): JSONMutableObject, MutableMap<String, JSONValue> by map {
    companion object: FSPTypedComponent<Char, JSONObject>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<JSONObject> {
            '{'.queue()
            space
            val pairPattern = group<Pair<String, JSONValue>> {
                val string by JSONString.queue()
                space
                ':'.queue()
                space
                val value by JSONValue.queue()
                value { string.value.string to value.value }
            }
            val map by group<MutableMap<String, JSONValue>> {
                val firstPair by pairPattern.queue()
                val pairs by group<Pair<String, JSONValue>> {
                    space
                    ','.queue()
                    space
                    val pair by pairPattern.queue()
                    pair
                }.lazyRepeat(0, null).queue()
                value { mutableMapOf(firstPair.value, *pairs.value.toTypedArray()) }
            }.optional().queue()
            space
            '}'.queue()
            return value { JSONHashObject(map.value?: mutableMapOf()) }
        }
    }
}