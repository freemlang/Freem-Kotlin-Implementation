package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Expression private constructor() {


    companion object: Partition<Expression> {
        override fun PartitionField.execute(): Expression {
            TODO("Not yet implemented")
        }
    }
}