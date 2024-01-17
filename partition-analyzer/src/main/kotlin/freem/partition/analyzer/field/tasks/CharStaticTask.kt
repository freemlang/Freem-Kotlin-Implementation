package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class CharStaticTask(private val char: Char): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        if (peek == char) advance()
        else fail()
    }
}