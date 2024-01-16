package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class Factor {
    companion object: Partition<Factor>() {
        override fun PartitionField.initialize(): PartitionValue<Factor> {
            add static '('
            add static ')'

            return newValue { Factor() }
        }
    }
}