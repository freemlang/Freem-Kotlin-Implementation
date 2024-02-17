package freem.partition.analyzer.field.additionalOptions

import freem.partition.analyzer.field.tasks.additional.RepeatTask
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.task.AnalyzeTaskWrapper

class RepeatAdditionalOptions<Type>
internal constructor(baseTaskWrapper: AnalyzeTaskWrapper<RepeatTask>): DefaultAdditionalOptions<List<Type>>(baseTaskWrapper) {
    infix fun lazy(state: Boolean): RepeatAdditionalOptions<Type> {
        TODO()
    }
    infix fun byString(value: PartitionValue<in String>): RepeatAdditionalOptions<Type> {
        TODO()
    }
}