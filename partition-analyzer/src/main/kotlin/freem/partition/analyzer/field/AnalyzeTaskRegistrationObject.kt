package freem.partition.analyzer.field

import freem.partition.analyzer.Partition
import freem.partition.analyzer.field.tasks.*
import freem.partition.analyzer.field.tasks.CharStaticTask
import freem.partition.analyzer.field.tasks.FieldTask
import freem.partition.analyzer.field.tasks.JudgeTask
import freem.partition.analyzer.field.tasks.StringStaticTask
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import freem.partition.analyzer.task.wrap
import java.util.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class AnalyzeTaskRegistrationObject internal constructor(private val taskQueue: Queue<AnalyzeTaskWrapper>) {
    infix fun static(string: String): AdditionalOptions<String> {
        val task = StringStaticTask(string).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    infix fun static(char: Char): AdditionalOptions<Char> {
        val task = CharStaticTask(char).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    infix fun judge(judgement: (Char) -> Boolean): AdditionalOptions<Char> {
        val task = JudgeTask(judgement).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun dynamic(field: DynamicField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.UNKNOWN) }
        val task = DynamicTask(field).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    infix fun <ReturnType> partition(partition: Partition<ReturnType>): AdditionalOptions<ReturnType> {
        val task = PartitionTask(partition).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = FieldTask(field).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    infix fun switch(field: SwitchField.() -> Unit): AdditionalOptions<String> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = SwitchTask(field).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <ReturnType> switch(field: TypedSwitchField<ReturnType>.() -> Unit): AdditionalOptions<ReturnType> {
        contract { callsInPlace(field, InvocationKind.EXACTLY_ONCE) }
        val task = TypedSwitchTask(field).wrap()
        taskQueue.add(task)
        return AdditionalOptions(task)
    }
}

