package freem.partition.analyzer.field.value

internal class NullablePartitionValue<Type>: PartitionValue<Type>() {
    var initializer: (PartitionValueGettableField.() -> Type)? = null
    override val value: Type by lazy(LazyThreadSafetyMode.NONE) {
        val initializer = initializer
        if (initializer === null) throw IllegalStateException("PartitionValue is not initialized")
        return@lazy PartitionValueGettableFieldImpl.initializer()
    }
}