package json

import libfsp.FSPComponentExecutor

object JSON {
    private val analyzer = FSPComponentExecutor(JSONValue)
    fun parse(input: String): JSONValue? {
        val jsonValue = analyzer.execute(input.toCharArray().toTypedArray())
        return if (jsonValue == JSONNull) null else jsonValue
    }
    fun objectOf(vararg pair: Pair<String, JSONValue>): JSONObject { TODO() }
    fun mutableObjectOf(vararg pair: Pair<String, JSONValue>): JSONMutableObject { TODO() }
}