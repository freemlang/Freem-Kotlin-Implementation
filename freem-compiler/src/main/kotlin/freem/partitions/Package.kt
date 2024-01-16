package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future

class Package private constructor(

) {
    companion object: Partition<Package>() {
        override fun PartitionField.initialize(): PartitionValue<Package> {
            TODO("Not yet implemented")
        }
    }
}