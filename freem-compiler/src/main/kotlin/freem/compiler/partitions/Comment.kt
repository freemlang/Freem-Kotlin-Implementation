package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue

sealed class Comment: Partition<String>() {
    companion object: Partition<String>() {
        override fun PartitionField.initialize(): PartitionValue<String> {
            val content by add switch {
                add partition Inline
                add partition Multiline
            }
            return content
        }
    }

    data object Inline: Comment() {
        override fun PartitionField.initialize(): PartitionValue<String> {
            add static "//"
            val content = newValue<String>()
            add judge { it != '\n' } repeatMin 0 lazy false byString content
            add static '\n' optional true
            return content
        }
    }

    data object Multiline: Comment() {
        override fun PartitionField.initialize(): PartitionValue<String> {
            add static "/*"
            val content = newValue<String>()
            add judge { true } repeatMin 0 byString content
            add static "*/"
            return content
        }
    }
}
