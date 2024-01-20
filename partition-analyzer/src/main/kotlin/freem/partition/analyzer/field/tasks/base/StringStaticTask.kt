package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class StringStaticTask(val string: String): AnalyzeTask {

    init {
        if (string.isEmpty()) throw IllegalArgumentException("Static value cannot be empty.")
    }

    override fun AnalyzeTaskExecutionField.run(): Boolean {
        for (char in string) if (next() != char) return false
        return true
    }
}