package partitions.comment

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class InlineComment private constructor(override val content: String): Comment {
    companion object: Partition<InlineComment> {
        override fun PartitionField.execute(): InlineComment {
            TODO("Not yet implemented")
        }
    }
}