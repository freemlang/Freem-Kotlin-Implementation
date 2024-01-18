package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class StringStaticTask(val string: String): BaseTask {

    init {
        if (string.isEmpty()) throw IllegalArgumentException("Static value cannot be empty.")
    }

    override fun AnalyzeTaskExecutionObject.run() {
        for (char in string) {
            if (peek == char) advance()
            else fail()
        }
    }
}