package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class JudgeTask(private val condition: (Char) -> Boolean): BaseTask {
    override fun AnalyzeTaskExecutionObject.run() {
        if (condition(peek)) advance()
        else fail()
    }
}