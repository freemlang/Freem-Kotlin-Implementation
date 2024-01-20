package freem.compiler.partitions

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.field.value.UnitPartitionValue

val ` ` = EmptySpace
val ` ?` = OptionalEmptySpace
val `|` = SeparateSpace
val `|?` = OptionalSeparateSpace

object EmptySpace: Partition<Unit>() {
    override fun PartitionField.initialize(): UnitPartitionValue {
        add switch {
            add judge Char::isWhitespace repeatMin 1
            add partition Comment
        } repeatMin 1
        return unit
    }
}

object OptionalEmptySpace: Partition<Unit>() {
    override fun PartitionField.initialize(): UnitPartitionValue {
        add partition EmptySpace optional true
        return unit
    }
}

object SeparateSpace: Partition<Unit>() {
    override fun PartitionField.initialize(): PartitionValue<Unit> {
        add switch {
            case partition EmptySpace
            case static ';'
        } repeatMin 1
        return unit
    }
}

object OptionalSeparateSpace: Partition<Unit>() {
    override fun PartitionField.initialize(): PartitionValue<Unit> {
        add partition SeparateSpace optional true
        return unit
    }
}