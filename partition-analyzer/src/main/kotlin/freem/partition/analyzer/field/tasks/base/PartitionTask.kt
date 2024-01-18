package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.Partition
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

internal class PartitionTask<ReturnType>(private val partition: Partition<ReturnType>): BaseTask {
    override fun AnalyzeTaskExecutionObject.run() {
        for (task in partition.tasks) {
            with(task) {
                run()
            }
        }
    }
}