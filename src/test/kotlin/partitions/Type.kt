package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.interfaces.field.PartitionField
import java.util.concurrent.Future

class Type private constructor() {
    companion object: Partition<Type>() {
        override fun PartitionField.initialize(): Future<Type> {
            TODO("Not yet implemented")
        }
    }
}