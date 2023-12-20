package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Package private constructor(

) {
    companion object: Partition<Package> {
        override fun PartitionField.execute(): Package {
            TODO("Not yet implemented")
        }
    }
}