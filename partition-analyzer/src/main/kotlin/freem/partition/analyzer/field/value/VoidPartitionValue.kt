package freem.partition.analyzer.field.value

internal class VoidPartitionValue<Type>: PartitionValue<Type>() {
    override val initializer: PartitionValueUsableField.() -> Type
        get() = TODO("Not yet implemented")
    private val lazy = lazy(LazyThreadSafetyMode.NONE) {
        val initializer = initializer
        if (initializer === null) throw IllegalStateException("PartitionValue is not initialized")
        return@lazy PartitionValueUsableField().initializer()
    }
    val isInitialized get() = lazy.isInitialized()
}