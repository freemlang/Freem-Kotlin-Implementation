package freem.partition.analyzer

import freem.partition.analyzer.field.PartitionField
import java.util.LinkedList
import java.util.Queue
import java.util.concurrent.Future

abstract class Partition<ReturnType> {
    internal val returnFuture: Future<ReturnType>
    internal val taskQueue: PartitionAnalyzeTaskQueue = LinkedList()

    init {
        val field = PartitionField(taskQueue)
        with(field) {
            returnFuture = initialize()
        }
    }

    protected abstract fun PartitionField.initialize(): Future<ReturnType>
}
