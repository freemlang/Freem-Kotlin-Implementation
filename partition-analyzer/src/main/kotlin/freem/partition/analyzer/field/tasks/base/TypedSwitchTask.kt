package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.field.TypedSwitchField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class TypedSwitchTask<ReturnType>(private val field: TypedSwitchField<ReturnType>.() -> Unit): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {
        TODO("Not yet implemented")
    }
}