package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.PartitionInterruption

sealed class Comment {
    companion object: Partition<Unit> {
        override fun PartitionField.initialize() {
            try {
                import(Inline)
            } catch (interruption: PartitionInterruption) {
                import(Multiline)
            }
        }
    }

    object Inline: Comment(), Partition<Unit> {
        override fun PartitionField.initialize() {
            need("//")
            while (hasNext() && current() != '\n') next()
            nextOrNull()
        }
    }

    object Multiline: Comment(), Partition<Unit> {
        override fun PartitionField.initialize() {
            need("/*")
            while (hasNext()) {
                if (next() == '*' && nextOrNull() == '/') break
            }
        }
    }
}