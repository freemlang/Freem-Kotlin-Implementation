package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class Identifier private constructor(val value: String) {


    companion object: Partition<Identifier> {
        override fun PartitionField.execute(): Identifier {
            return Identifier("")
        }
    }
}