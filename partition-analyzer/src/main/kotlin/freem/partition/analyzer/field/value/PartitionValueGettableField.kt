package freem.partition.analyzer.field.value

open class PartitionValueGettableField internal constructor() {
    fun <Type> PartitionValue<Type>.get(): Type = value
}