package freem.partition.analyzer.field.value

abstract class PartitionValue<Type> internal constructor() {
    internal abstract val initializer: PartitionValueUsableField.() -> Type
}
