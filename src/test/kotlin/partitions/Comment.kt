package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField
import org.freem.compiler.frontend.Promise

sealed class Comment {
    companion object: Partition<String> {
        override fun PartitionField.initialize(): Promise<String> {
            val content by add case {
                add partition Inline
                add partition Multiline
            }
            return content
        }
    }

    object Inline: Comment(), Partition<String> {
        override fun PartitionField.initialize(): Promise<String> {
            add static "//"

            val content = newCapture()

            add custom { true } repeatMin 0

            content.fin()

            add static '\n'

            return content
        }
    }

    object Multiline: Comment(), Partition<String> {
        override fun PartitionField.initialize(): Promise<String> {
            add static "/*"

            val content = newCapture()

            add custom { true } repeatMin 0

            content.fin()

            add static "*/"

            return content
        }
    }
}