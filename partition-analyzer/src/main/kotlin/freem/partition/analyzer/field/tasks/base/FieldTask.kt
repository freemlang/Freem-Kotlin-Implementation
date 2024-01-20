package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class FieldTask(field: PartitionField.() -> Unit): AnalyzeTask {

    private val tasks: List<AnalyzeTask> = Partition {
        field()
        return@Partition unit
    }.tasks

    override fun AnalyzeTaskExecutionField.run(): Boolean {
        for (task in tasks) {
            with(task) {
                if(!run()) return false
            }
        }
        return true
    }
}