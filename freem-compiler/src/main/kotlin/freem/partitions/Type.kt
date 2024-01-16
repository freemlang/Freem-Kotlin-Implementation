package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

class Type private constructor() {
    companion object: Partition<Type>() {
        override fun PartitionField.initialize(): Future<Type> {
            TODO("Not yet implemented")
        }
    }
}