package freem.partition.analyzer

import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.LinkedList

abstract class Partition<ReturnType> {
    internal val returnValue: PartitionValue<ReturnType>
    internal val taskQueue: PartitionAnalyzeTaskQueue = LinkedList()

    init {
        val field = PartitionField(taskQueue)
        with(field) {
            returnValue = initialize()
        }
    }

    protected abstract fun PartitionField.initialize(): PartitionValue<ReturnType>
}
