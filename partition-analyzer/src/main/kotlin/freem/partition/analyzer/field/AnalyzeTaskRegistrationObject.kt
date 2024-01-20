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
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import freem.partition.analyzer.task.wrap

class AnalyzeTaskRegistrationObject internal constructor(private val tasks: MutableList<AnalyzeTaskWrapper>) {
    infix fun static(string: String): DefaultAdditionalOptions<String> {
        val task = StringStaticTask(string).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun static(char: Char): DefaultAdditionalOptions<Char> {
        val task = CharStaticTask(char).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun judge(judgement: (Char) -> Boolean): DefaultAdditionalOptions<Char> {
        val task = JudgeTask(judgement).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun dynamic(field: DynamicField.() -> Unit): DefaultAdditionalOptions<String> {
        val task = DynamicTask(field).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun <ReturnType> partition(partition: Partition<ReturnType>): DefaultAdditionalOptions<ReturnType> {
        val task = PartitionTask(partition).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun field(field: PartitionField.() -> Unit): DefaultAdditionalOptions<String> {
        val task = FieldTask(field).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    infix fun switch(field: SwitchField.() -> Unit): DefaultAdditionalOptions<String> {
        val task = SwitchTask(field).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <ReturnType> switch(field: TypedSwitchField<ReturnType>.() -> Unit): DefaultAdditionalOptions<ReturnType> {
        val task = TypedSwitchTask(field).wrap()
        tasks.add(task)
        return DefaultAdditionalOptions(task)
    }
}

