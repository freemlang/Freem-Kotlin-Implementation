package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class CharStaticTask(val char: Char): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run() = next() == char
}