package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Type private constructor() {


    companion object: Partition<Type> {
        override fun PartitionField.initialize(): Type {
            TODO("Not yet implemented")
        }
    }
}