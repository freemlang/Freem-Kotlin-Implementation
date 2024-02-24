package json

import libfsp.FSPPatternExecutionSystem

object JSON {
    private val analyzer = FSPPatternExecutionSystem(JSONValue)
    fun parse(input: String): JSONValue? = analyzer.execute(input.toList())
    fun objectOf(vararg pair: Pair<String, JSONValue>): JSONObject { TODO() }
    fun mutableObjectOf(vararg pair: Pair<String, JSONValue>): JSONMutableObject { TODO() }
}