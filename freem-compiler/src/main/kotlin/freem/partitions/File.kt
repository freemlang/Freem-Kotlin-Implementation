package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

class File private constructor(
    val name: String,
    val package_: Package,
    val imports: List<Package>,
) {
    companion object: Partition<File>() {
        override fun PartitionField.initialize(): Future<File> {
            TODO("Not yet implemented")
        }
    }
}