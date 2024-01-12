package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

class CodeBlock {
    companion object: Partition<CodeBlock> {
        override fun PartitionField.initialize(): Promise<CodeBlock> {
            add static '{'
            add static '}'

            return Promise { CodeBlock() }
        }
    }
}