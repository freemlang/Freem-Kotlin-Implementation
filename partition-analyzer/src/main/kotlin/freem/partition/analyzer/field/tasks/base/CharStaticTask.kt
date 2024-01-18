package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class CharStaticTask(val char: Char): BaseTask {
    override fun AnalyzeTaskExecutionObject.run() {
        if (peek == char) advance()
        else fail()
    }
}