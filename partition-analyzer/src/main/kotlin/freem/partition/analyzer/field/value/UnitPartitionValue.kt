package freem.partition.analyzer.field.value

object UnitPartitionValue: PartitionValue<Unit>() {
    override val initializer: PartitionValueUsableField.() -> Unit = {}
}