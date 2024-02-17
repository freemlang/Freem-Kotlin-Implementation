package freem.partition.analyzer.field

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.additionalOptions.DefaultAdditionalOptions
import freem.partition.analyzer.field.tasks.base.CharStaticTask
import freem.partition.analyzer.field.tasks.base.DynamicTask
import freem.partition.analyzer.field.tasks.base.FieldTask
import freem.partition.analyzer.field.tasks.base.JudgeTask
import freem.partition.analyzer.field.tasks.base.PartitionTask
import freem.partition.analyzer.field.tasks.base.StringStaticTask
import freem.partition.analyzer.field.tasks.base.SwitchTask
import freem.partition.analyzer.field.tasks.base.TypedSwitchTask
import freem.partition.analyzer.field.value.PartitionValue
import freem.partition.analyzer.field.value.PartitionValueUsableField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper
import freem.partition.analyzer.task.wrap

class AnalyzeTaskRegistrationObject internal constructor(private val tasks: MutableList<AnyAnalyzeTaskWrapper>) {
    private fun <Type> register(generator: () -> AnalyzeTask): DefaultAdditionalOptions<Type> {
        val task = generator().wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun static(string: String)                                    = register<String> { StringStaticTask(string) }
    infix fun static(char: Char)                                        = register<Char> { CharStaticTask(char) }
    infix fun judge(judgement: (Char) -> Boolean)                       = register<Char> { JudgeTask(judgement) }
    infix fun dynamic(field: DynamicField.() -> Unit)                   = register<String> { DynamicTask(field) }
    infix fun <ReturnType> partition(partition: Partition<ReturnType>)  = register<ReturnType> { PartitionTask(partition) }
    infix fun field(field: PartitionField.() -> Unit)                   = register<String> { FieldTask(field) }
    infix fun switch(field: SwitchField.() -> Unit)                     = register<String> { SwitchTask(field) }
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <ReturnType> switch(field: TypedSwitchField<ReturnType>.() -> Unit) = register<ReturnType> { TypedSwitchTask(field) }

    infix fun task(task: PartitionValueUsableField.() -> Unit) { TODO() }
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedTask")
    infix fun <ReturnType> task(task: PartitionValueUsableField.() -> ReturnType): PartitionValue<ReturnType> { TODO() }
}

