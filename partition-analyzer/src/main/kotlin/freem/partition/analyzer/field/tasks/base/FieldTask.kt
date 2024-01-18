package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject
import java.util.*

internal class FieldTask(field: PartitionField.() -> Unit): BaseTask {

    private val tasks: List<AnalyzeTask> = Partition {
        field()
        return@Partition unit
    }.tasks

    override fun AnalyzeTaskExecutionObject.run() {
        for (task in tasks) {
            with(task) {
                run()
            }
        }
    }
}