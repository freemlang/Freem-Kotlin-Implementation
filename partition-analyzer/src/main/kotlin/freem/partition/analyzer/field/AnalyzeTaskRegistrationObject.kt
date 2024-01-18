package freem.partition.analyzer.field

import freem.partition.analyzer.Partition
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
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class AnalyzeTaskRegistrationObject internal constructor(private val tasks: MutableList<AnalyzeTaskWrapper>) {
    infix fun static(string: String): AdditionalOptions<String> {
        val task = StringStaticTask(string).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    infix fun static(char: Char): AdditionalOptions<Char> {
        val task = CharStaticTask(char).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    infix fun judge(judgement: (Char) -> Boolean): AdditionalOptions<Char> {
        val task = JudgeTask(judgement).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun dynamic(field: DynamicField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.UNKNOWN) }
        val task = DynamicTask(field).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    infix fun <ReturnType> partition(partition: Partition<ReturnType>): AdditionalOptions<ReturnType> {
        val task = PartitionTask(partition).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = FieldTask(field).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun switch(field: SwitchField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = SwitchTask(field).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <ReturnType> switch(field: TypedSwitchField<ReturnType>.() -> Unit): AdditionalOptions<ReturnType> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = TypedSwitchTask(field).wrap()
        tasks.add(task)
        return AdditionalOptions(task)
    }
}

