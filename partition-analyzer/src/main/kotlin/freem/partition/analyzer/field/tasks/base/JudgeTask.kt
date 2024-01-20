package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class JudgeTask(private val condition: (Char) -> Boolean): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run() = condition(next())
}