package freem.partition.analyzer.field

import freem.partition.analyzer.field.value.NullablePartitionValue
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import kotlin.reflect.KProperty

open class AdditionalOptions<Type> internal constructor(baseTaskWrapper: AnalyzeTaskWrapper) {
    private var baseTask by baseTaskWrapper

    infix fun optional(optional: Boolean): AdditionalOptions<Type> {


        return this
    }

    infix fun repeat(count: Int): AdditionalOptions<Type> {


        return this
    }

    infix fun repeat(range: IntRange): AdditionalOptions<Type> {


        return this
    }

    infix fun repeatMin(min: Int): AdditionalOptions<Type> {


        return this
    }

    infix fun repeatMax(max: Int): AdditionalOptions<Type> {


        return this
    }


    infix fun by(value: PartitionValue<Type>): AdditionalOptions<Type> {
        if (value !is NullablePartitionValue<*>) throw IllegalArgumentException("value is already initialized")
        value.initializer = {
            TODO()
        }
        return this
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): PartitionValue<Type> {
        TODO("Not yet implemented")
    }
}

