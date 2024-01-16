package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future

class Expression private constructor() {
    companion object: Partition<Expression>() {
        override fun PartitionField.initialize(): PartitionValue<Expression> {
            TODO("Not yet implemented")
        }
    }
}