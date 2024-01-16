package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

class Package private constructor(

) {
    companion object: Partition<Package>() {
        override fun PartitionField.initialize(): Future<Package> {
            TODO("Not yet implemented")
        }
    }
}