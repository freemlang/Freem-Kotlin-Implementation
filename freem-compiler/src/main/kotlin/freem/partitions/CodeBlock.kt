package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
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