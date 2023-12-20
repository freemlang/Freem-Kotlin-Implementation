package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class File private constructor(
    val name: String,
    val package_: Package,
    val imports: List<Package>,
) {
    companion object: Partition<File> {
        override fun PartitionField.execute(): File {
            TODO("Not yet implemented")
        }
    }
}