package freem.partition.analyzer.field.value

internal class LambdaPartitionValue<Type>(override val initializer: PartitionValueUsableField.() -> Type): PartitionValue<Type>()