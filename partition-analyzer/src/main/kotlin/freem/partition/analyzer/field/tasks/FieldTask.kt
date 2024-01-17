package freem.partition.analyzer.field.tasks

import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class FieldTask(field: PartitionField.() -> Unit): AnalyzeTask() {
    override fun AnalyzeTaskExecutionObject.task() {
        TODO("Not yet implemented")
    }
}