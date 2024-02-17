package freem.partition.analyzer.field.value

open class PartitionValueUsableField internal constructor() {
    fun <Type> PartitionValue<Type>.get(): Type = TODO()
    fun <Type> PartitionVariance<Type>.set(value: Type) { TODO() }
}