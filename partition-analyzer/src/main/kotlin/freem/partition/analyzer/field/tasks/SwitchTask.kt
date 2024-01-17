package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.field.SwitchField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class SwitchTask(private val field: SwitchField.() -> Unit): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        TODO("Not yet implemented")
    }
}