package json

import libfsp.FSPPatternExecutionSystem

object JSON {
    private val analyzer = FSPPatternExecutionSystem(JSONData)
    fun parse(input: String): JSONData? = analyzer.execute(input.toList())
}