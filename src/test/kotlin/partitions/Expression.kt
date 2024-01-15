package partitions

import org.freem.compiler.partition.Partition
import org.freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future

class Expression private constructor() {
    companion object: Partition<Expression>() {
        override fun PartitionField.initialize(): Future<Expression> {
            TODO("Not yet implemented")
        }
    }
}