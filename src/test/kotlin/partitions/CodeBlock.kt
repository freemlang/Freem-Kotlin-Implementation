package partitions

import org.freem.compiler.partition.Partition
import org.freem.compiler.partition.interfaces.field.PartitionField
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class CodeBlock {
    companion object: Partition<CodeBlock>() {
        override fun PartitionField.initialize(): Future<CodeBlock> {
            add static '{'
            add static '}'

            return FutureTask { CodeBlock() }
        }
    }
}