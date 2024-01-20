package freem.partition.analyzer.field.additionalOptions

import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.field.value.VoidPartitionValue
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper
import kotlin.reflect.KProperty

abstract class AdditionalOptions<Type> internal constructor(internal val baseTaskWrapper: AnyAnalyzeTaskWrapper) {
    internal var baseTask by baseTaskWrapper

    abstract infix fun optional(dummy: Any?): AdditionalOptions<Type?>

    /**By default, the lazy option is applied. To change the lazy option, use the lazy function.*/
    abstract infix fun repeat(count: Int): AdditionalOptions<List<Type>>

    /**By default, the lazy option is applied. To change the lazy option, use the lazy function.*/
    abstract infix fun repeat(range: IntRange): AdditionalOptions<List<Type>>

    /**By default, the lazy option is applied. To change the lazy option, use the lazy function.*/
    abstract infix fun repeatMin(min: Int): AdditionalOptions<List<Type>>

    /**By default, the lazy option is applied. To change the lazy option, use the lazy function.*/
    abstract infix fun repeatMax(max: Int): AdditionalOptions<List<Type>>

    abstract infix fun by(value: PartitionValue<Type>): AdditionalOptions<Type>

    operator fun getValue(thisRef: Any?, property: KProperty<*>): PartitionValue<Type> = VoidPartitionValue<Type>().apply(::by)
}