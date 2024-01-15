package partitions

import org.freem.compiler.partition.Partition
import org.freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future

class Package private constructor(

) {
    companion object: Partition<Package>() {
        override fun PartitionField.initialize(): Future<Package> {
            TODO("Not yet implemented")
        }
    }
}