package freem.partition.analyzer.field.value

internal class LambdaPartitionValue<Type>(initializer: PartitionValueGettableField.() -> Type): PartitionValue<Type>() {
    override val value by lazy(LazyThreadSafetyMode.NONE) {
        return@lazy PartitionValueGettableObject.initializer()
    }
}