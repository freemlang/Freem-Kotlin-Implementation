package freem.partition.analyzer

import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

abstract class Partition<ReturnType> {
    internal val returnValue: PartitionValue<ReturnType>
    internal val tasks: List<AnalyzeTask>

    init {
        val taskWrapperQueue: MutableList<AnalyzeTaskWrapper> = LinkedList()
        val field = PartitionField(taskWrapperQueue)
        with(field) {
            returnValue = initialize()
        }
        tasks = taskWrapperQueue.map { it.task }
    }

    protected abstract fun PartitionField.initialize(): PartitionValue<ReturnType>

    companion object {
        private class LambdaPartition<ReturnType>(
            private val initializer: PartitionField.() -> PartitionValue<ReturnType>
        ): Partition<ReturnType>() {
            override fun PartitionField.initialize() = initializer()
        }
        operator fun <ReturnType> invoke(
            initializer: PartitionField.() -> PartitionValue<ReturnType>
        ): Partition<ReturnType> = LambdaPartition(initializer)
    }
}