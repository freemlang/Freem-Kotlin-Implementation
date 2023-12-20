package partitions.comment

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

class MultilineComment private constructor(override val content: String): Comment {
    companion object: Partition<MultilineComment> {
        override fun PartitionField.execute(): MultilineComment {
            TODO("Not yet implemented")
        }
    }
}