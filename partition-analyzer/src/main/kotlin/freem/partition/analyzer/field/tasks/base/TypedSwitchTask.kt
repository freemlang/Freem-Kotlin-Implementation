package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.field.TypedSwitchField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class TypedSwitchTask<ReturnType>(private val field: TypedSwitchField<ReturnType>.() -> Unit): BaseTask {
    override fun AnalyzeTaskExecutionObject.run() {
        TODO("Not yet implemented")
    }
}