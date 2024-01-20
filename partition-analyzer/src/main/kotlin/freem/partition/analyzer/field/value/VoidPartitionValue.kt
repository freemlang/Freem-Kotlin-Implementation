package freem.partition.analyzer.field.value

internal class VoidPartitionValue<Type>: PartitionValue<Type>() {
    var initializer: (PartitionValueGettableField.() -> Type)? = null
    private val lazy = lazy(LazyThreadSafetyMode.NONE) {
        val initializer = initializer
        if (initializer === null) throw IllegalStateException("PartitionValue is not initialized")
        return@lazy PartitionValueGettableFieldImpl.initializer()
    }
    override val value: Type by lazy
    val isInitialized get() = lazy.isInitialized()
}