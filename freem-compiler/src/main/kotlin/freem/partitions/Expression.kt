package freem.partitions

import freem.compiler.partition.Partition
import freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future

class Expression private constructor() {
    companion object: Partition<Expression>() {
        override fun PartitionField.initialize(): Future<Expression> {
            TODO("Not yet implemented")
        }
    }
}