package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.field.PartitionField
import java.util.concurrent.Future

class Function private constructor(val name: String, val returnType: Type) {
    companion object: Partition<Function>() {
        override fun PartitionField.initialize(): Future<Function> {
            TODO("Not yet implemented")
        }
    }
}