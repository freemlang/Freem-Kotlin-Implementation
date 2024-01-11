package partitions

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.PartitionField

sealed class Comment {
    companion object: Partition<Unit> {
        override fun PartitionField.initialize() {
            add case {
                add partition Inline
                add partition Multiline
            }
        }
    }

    object Inline: Comment(), Partition<Unit> {
        override fun PartitionField.initialize() {
            add static "//"

            capture start "content"

            add custom { true } repeatMin 0

            capture fin "content"

            add static '\n'
        }
    }

    object Multiline: Comment(), Partition<Unit> {
        override fun PartitionField.initialize() {
            add static "/*"

            capture start "content"

            add custom { true } repeatMin 0

            capture fin "content"
            add static "*/"
        }
    }
}