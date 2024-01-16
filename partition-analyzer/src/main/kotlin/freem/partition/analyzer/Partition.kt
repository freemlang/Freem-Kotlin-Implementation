package freem.partition.analyzer

import freem.partition.analyzer.field.PartitionField
import java.util.Queue
import java.util.concurrent.Future

abstract class Partition<ReturnType> {
    internal val returnFuture: Future<ReturnType>
    internal val taskQueue: PartitionAnalyzeTaskQueue

    init {
        val field = PartitionField()
        with(field) {
            returnFuture = initialize()
        }
        taskQueue = field.taskQueue
    }

    protected abstract fun PartitionField.initialize(): Future<ReturnType>
}
