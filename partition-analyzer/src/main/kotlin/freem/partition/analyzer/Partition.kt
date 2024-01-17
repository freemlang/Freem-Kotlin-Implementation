package freem.partition.analyzer

import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

abstract class Partition<ReturnType> {
    internal val returnValue: PartitionValue<ReturnType>
    internal val taskQueue: Queue<AnalyzeTask>

    init {
        val taskWrapperQueue: Queue<AnalyzeTaskWrapper> = LinkedList()
        val field = PartitionField(taskWrapperQueue)
        with(field) {
            returnValue = initialize()
        }
        val taskQueue: Queue<AnalyzeTask> = LinkedList()
        while (true) taskQueue.add(
            taskWrapperQueue
                .poll()
                ?.task
                ?:break
        )
        this.taskQueue = taskQueue
    }

    protected abstract fun PartitionField.initialize(): PartitionValue<ReturnType>
}
