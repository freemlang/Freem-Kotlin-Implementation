package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTaskQueue
import freem.partition.analyzer.field.value.*
import freem.partition.analyzer.field.value.LambdaPartitionValue
import freem.partition.analyzer.field.value.NullablePartitionValue

class PartitionField internal constructor(taskQueue: PartitionAnalyzeTaskQueue) {
    val add = AddObject(taskQueue)
    val unit = UnitPartitionValue

    fun <Type> newValue(): PartitionValue<Type> = NullablePartitionValue()
    fun <Type> newValue(value: PartitionValueGettableField.() -> Type): PartitionValue<Type> = LambdaPartitionValue(value)

    fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}

