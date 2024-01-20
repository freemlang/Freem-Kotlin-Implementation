package freem.partition.analyzer.field.additionalOptions

import freem.partition.analyzer.field.tasks.additional.*
import freem.partition.analyzer.field.tasks.additional.CountRepeatTask
import freem.partition.analyzer.field.tasks.additional.MinRepeatTask
import freem.partition.analyzer.field.tasks.additional.OptionalTask
import freem.partition.analyzer.field.tasks.additional.RangeRepeatTask
import freem.partition.analyzer.field.value.VoidPartitionValue
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper
import kotlin.reflect.KProperty

open class DefaultAdditionalOptions<Type>
internal constructor(baseTaskWrapper: AnyAnalyzeTaskWrapper): AdditionalOptions<Type>(baseTaskWrapper) {
    override infix fun optional(dummy: Any?): DefaultAdditionalOptions<Type?> {
        baseTask = OptionalTask(baseTask)
        return DefaultAdditionalOptions(baseTaskWrapper)
    }

    override infix fun repeat(count: Int): RepeatAdditionalOptions<Type> {
        baseTask = CountRepeatTask(baseTask, count)
        @Suppress("UNCHECKED_CAST")
        return RepeatAdditionalOptions(baseTaskWrapper as AnalyzeTaskWrapper<RepeatTask>)
    }

    override infix fun repeat(range: IntRange): RepeatAdditionalOptions<Type> {
        baseTask = RangeRepeatTask(baseTask, range)
        @Suppress("UNCHECKED_CAST")
        return RepeatAdditionalOptions(baseTaskWrapper as AnalyzeTaskWrapper<RepeatTask>)
    }

    override infix fun repeatMin(min: Int): RepeatAdditionalOptions<Type> {
        baseTask = MinRepeatTask(baseTask, min)
        @Suppress("UNCHECKED_CAST")
        return RepeatAdditionalOptions(baseTaskWrapper as AnalyzeTaskWrapper<RepeatTask>)
    }

    override infix fun repeatMax(max: Int): RepeatAdditionalOptions<Type> {
        baseTask = MaxRepeatTask(baseTask, max)
        @Suppress("UNCHECKED_CAST")
        return RepeatAdditionalOptions(baseTaskWrapper as AnalyzeTaskWrapper<RepeatTask>)
    }

    override infix fun by(value: PartitionValue<Type>): DefaultAdditionalOptions<Type> {
        if (value !is VoidPartitionValue<*> || value.isInitialized) throw IllegalArgumentException("value is already initialized")
        value.initializer = {
            TODO()
        }
        return this
    }
}

