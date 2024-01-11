package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Function private constructor(val name: String, val returnType: Type) {


    companion object: Partition<Function> {
        override fun PartitionField.initialize(): Function {
            TODO("Not yet implemented")
        }
    }
}