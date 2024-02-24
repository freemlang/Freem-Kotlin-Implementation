package json

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class JSONArray(private val list: List<JSONValue>): JSONValue, List<JSONValue> by list {
    companion object: FSPTypedPattern<Char, JSONArray>() {
        override fun initialize(): context(FSPComponentListConstructDispatcher<Char>) () -> FSPValue<JSONArray> = {
            '['.queue()
            space
            val firstItem by JSONValue.optional().queue()
            val items by group<JSONValue> {
                ','.queue()
                space
                val item by JSONValue.queue()
                space
                item
            }.greedyRepeat(0, null).queue()
            group {
                ','.queue()
                space
            }.optional().queue()
            ']'.queue()
            value {
                val list = items.value.toMutableList()
                list.addFirst(firstItem.value)
                return@value JSONArray(list)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JSONArray

        return list == other.list
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }
}