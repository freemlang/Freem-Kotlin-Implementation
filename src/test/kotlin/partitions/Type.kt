package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Type private constructor() {


    companion object: Partition<Type> {
        override fun PartitionField.execute(): Type {
            TODO("Not yet implemented")
        }
    }
}