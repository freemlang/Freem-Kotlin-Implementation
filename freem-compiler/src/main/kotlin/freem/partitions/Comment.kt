package freem.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import java.util.concurrent.Future

sealed class Comment: Partition<String>() {
    companion object: Partition<String>() {
        override fun PartitionField.initialize(): Future<String> {
            val content by add switch {
                add partition Inline
                add partition Multiline
            }
            return content
        }
    }

    data object Inline: Comment() {
        override fun PartitionField.initialize(): Future<String> {
            add static "//"

            val content = newCapture()

            add custom { true } repeatMin 0

            content.fin()

            add static '\n'

            return content
        }
    }

    data object Multiline: Comment() {
        override fun PartitionField.initialize(): Future<String> {
            add static "/*"

            val content = newCapture()

            add custom { true } repeatMin 0

            content.fin()

            add static "*/"

            return content
        }
    }
}