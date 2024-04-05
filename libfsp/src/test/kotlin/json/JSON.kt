package json

import libfsp.FreeStyleParser

object JSON {
    private val analyzer = FreeStyleParser(JSONValue)
    fun parse(input: String): JSONValue? {
        val jsonValue = analyzer.execute(input.toCharArray().toTypedArray())
        return if (jsonValue == JSONNull) null else jsonValue
    }
    fun objectOf(vararg pair: Pair<String, JSONValue>): JSONObject { TODO() }
    fun mutableObjectOf(vararg pair: Pair<String, JSONValue>): JSONMutableObject { TODO() }
}