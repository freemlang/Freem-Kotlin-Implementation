package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.Partition
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class PartitionTask<ReturnType>(private val partition: Partition<ReturnType>): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {
        for (task in partition.tasks) {
            with(task) {
                if (!run()) return false
            }
        }
        return true
    }
}