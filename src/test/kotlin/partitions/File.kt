package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.field.PartitionField
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