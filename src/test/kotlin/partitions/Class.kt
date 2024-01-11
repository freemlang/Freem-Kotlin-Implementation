package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Class private constructor(val name: String) {


    companion object: Partition<Class> {
        override fun PartitionField.initialize(): Class {
            TODO("Not yet implemented")
        }
    }
}