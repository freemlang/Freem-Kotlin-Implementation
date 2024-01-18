package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.UnitPartitionValue

val ` ` = WhiteSpace
val ` ?` = WhiteSpaceAble

object WhiteSpace: Partition<Unit>() {
    override fun PartitionField.initialize(): UnitPartitionValue {
        add switch {
            add judge Char::isWhitespace repeatMin 1
            add partition Comment
        }
        return unit
    }
}

object WhiteSpaceAble: Partition<Unit>() {
    override fun PartitionField.initialize(): UnitPartitionValue {
        add partition WhiteSpace optional true

        return unit
    }
}