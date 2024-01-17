package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class StringStaticTask(private val string: String): AnalyzeTask() {

    init {
        if (string.isEmpty()) throw IllegalArgumentException("Static value cannot be empty.")
    }

    override fun AnalyzeTaskExecutionObject.task() {
        for (char in string) {
            if (peek == char) advance()
            else fail()
        }
    }
}