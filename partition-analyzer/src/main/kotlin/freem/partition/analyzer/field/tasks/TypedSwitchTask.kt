package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.field.TypedSwitchField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class TypedSwitchTask<ReturnType>(private val field: TypedSwitchField<ReturnType>.() -> Unit): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        TODO("Not yet implemented")
    }
}