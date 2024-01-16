package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import kotlin.reflect.KProperty

open class Type private constructor() {
    companion object: Partition<Type>() {
        override fun PartitionField.initialize(): PartitionValue<Type> {
            TODO("Not yet implemented")
        }
    }
    object Void: Type()
}