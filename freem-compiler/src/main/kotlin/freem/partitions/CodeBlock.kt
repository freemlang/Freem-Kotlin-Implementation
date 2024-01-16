package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

class CodeBlock {
    companion object: Partition<CodeBlock>() {
        override fun PartitionField.initialize(): PartitionValue<CodeBlock> {
            add static '{'
            add static '}'

            return newValue { CodeBlock() }
        }
    }
}