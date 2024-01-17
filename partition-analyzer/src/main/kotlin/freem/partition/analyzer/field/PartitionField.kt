package freem.partition.analyzer.field

import freem.partition.analyzer.field.value.*
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

class PartitionField internal constructor(taskQueue: Queue<AnalyzeTaskWrapper>) {
    val add = AnalyzeTaskRegistrationObject(taskQueue)
    val unit = UnitPartitionValue

    fun <Type> newValue(): PartitionValue<Type> = NullablePartitionValue()
    fun <Type> newValue(value: PartitionValueGettableField.() -> Type): PartitionValue<Type> = LambdaPartitionValue(value)

    fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}

