package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.field.DynamicField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class DynamicTask(private val field: DynamicField.() -> Unit): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        TODO("Not yet implemented")
    }
}