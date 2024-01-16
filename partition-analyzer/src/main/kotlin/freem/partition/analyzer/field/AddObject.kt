package freem.partition.analyzer.field

import freem.partition.analyzer.Partition
import freem.partition.analyzer.PartitionAnalyzeTask
import freem.partition.analyzer.PartitionAnalyzeTaskExecuteObject
import freem.partition.analyzer.PartitionAnalyzeTaskQueue
import freem.partition.analyzer.field.value.PartitionValueGettableField
import java.util.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class AddObject internal constructor(private val taskQueue: PartitionAnalyzeTaskQueue) {
    infix fun static(string: String): AdditionalOptions {
        val task = object: PartitionAnalyzeTask() {
            override fun PartitionAnalyzeTaskExecuteObject.task() {

            }
        }
        taskQueue.add(task)
        return AdditionalOptions(task)
    }

    infix fun static(char: Char): AdditionalOptions {
        TODO("Not yet implemented")
    }

    infix fun custom(condition: (Char) -> Boolean): AdditionalOptions {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalContracts::class)
    infix fun dynamic(string: PartitionValueGettableField.() -> String): AdditionalOptions {
        contract {
            callsInPlace(string, InvocationKind.EXACTLY_ONCE)
        }
        TODO("Not yet implemented")
    }

    infix fun <Return> partition(partition: Partition<Return>): TypedAdditionalOptions<Return> {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalContracts::class)
    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions {
        contract {
            callsInPlace(field, InvocationKind.EXACTLY_ONCE)
        }
        val taskQueue: PartitionAnalyzeTaskQueue = LinkedList()
        val partitionField = PartitionField(taskQueue)
        partitionField.field()
        return AdditionalOptions(object: PartitionAnalyzeTask() {
            override fun PartitionAnalyzeTaskExecuteObject.task() {
                TODO("Not yet implemented")
            }
        })
    }

    @OptIn(ExperimentalContracts::class)
    infix fun switch(field: SwitchField.() -> Unit): TypedAdditionalOptions<String> {
        contract {
            callsInPlace(field, InvocationKind.EXACTLY_ONCE)
        }
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <Return> switch(field: TypedSwitchField<Return>.() -> Unit): TypedAdditionalOptions<Return> {
        contract {
            callsInPlace(field, InvocationKind.EXACTLY_ONCE)
        }
        TODO("Not yet implemented")
    }
}

