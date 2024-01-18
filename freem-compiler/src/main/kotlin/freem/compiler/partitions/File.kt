package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future

class File private constructor(
    val name: String,
    val package_: Package,
    val imports: List<Package>,
) {
    companion object: Partition<File>() {
        override fun PartitionField.initialize(): PartitionValue<File> {
            TODO("Not yet implemented")
        }
    }
}