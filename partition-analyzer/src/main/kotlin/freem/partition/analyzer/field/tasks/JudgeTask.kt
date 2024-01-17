package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class JudgeTask(private val condition: (Char) -> Boolean): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        if (condition(peek)) advance()
        else fail()
    }
}