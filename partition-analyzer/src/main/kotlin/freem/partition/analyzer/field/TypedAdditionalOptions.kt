package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTask
import freem.partition.analyzer.field.value.NullablePartitionValue
import freem.partition.analyzer.field.value.PartitionValue
import kotlin.reflect.KProperty

class TypedAdditionalOptions<Type> internal constructor(baseTask: PartitionAnalyzeTask): AdditionalOptions(baseTask) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): PartitionValue<Type> {
        TODO("Not yet implemented")
    }

    infix fun by(value: PartitionValue<Type>): TypedAdditionalOptions<Type> {
        if (value !is NullablePartitionValue<*>) throw IllegalArgumentException("value is already initialized")
        value.initializer = {
            TODO()
        }
        return this
    }
}

