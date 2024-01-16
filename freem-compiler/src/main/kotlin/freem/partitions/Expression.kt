package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

class Expression private constructor() {
    companion object: Partition<Expression>() {
        override fun PartitionField.initialize(): Future<Expression> {
            TODO("Not yet implemented")
        }
    }
}