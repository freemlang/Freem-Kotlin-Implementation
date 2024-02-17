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

open class DefaultAdditionalOptions<Type>
internal constructor(baseTaskWrapper: AnyAnalyzeTaskWrapper): AdditionalOptions<Type>(baseTaskWrapper) {
    override infix fun optional(dummy: Any?): DefaultAdditionalOptions<Type?> {
        baseTask = OptionalTask(baseTask)
        return DefaultAdditionalOptions(baseTaskWrapper)
    }

    private fun repeatOption(generator: () -> RepeatTask): RepeatAdditionalOptions<Type> {
        baseTask = generator()
        @Suppress("UNCHECKED_CAST")
        return RepeatAdditionalOptions(baseTaskWrapper as AnalyzeTaskWrapper<RepeatTask>)
    }

    override infix fun repeat(count: Int)       = repeatOption { CountRepeatTask(baseTask, count) }
    override infix fun repeat(range: IntRange)  = repeatOption { RangeRepeatTask(baseTask, range) }
    override infix fun repeatMin(min: Int)      = repeatOption { MinRepeatTask(baseTask, min) }
    override infix fun repeatMax(max: Int)      = repeatOption { MaxRepeatTask(baseTask, max) }

    override infix fun by(value: PartitionValue<Type>): DefaultAdditionalOptions<Type> {
        if (value !is VoidPartitionValue<*> || value.isInitialized) throw IllegalArgumentException("value is already initialized")
//        value.initializer = {
//            TODO()
//        }
        return this
    }
}

