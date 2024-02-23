package json

import libfsp.FSPPatternExecutionSystem

object JSON {
    private val analyzer = FSPPatternExecutionSystem(JSONValue)
    fun parse(input: String): JSONValue? = analyzer.execute(input.toList())
}