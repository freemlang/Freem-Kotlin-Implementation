package freem.partitions

import freem.compiler.partition.Partition
import freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future

class Type private constructor() {
    companion object: Partition<Type>() {
        override fun PartitionField.initialize(): Future<Type> {
            TODO("Not yet implemented")
        }
    }
}