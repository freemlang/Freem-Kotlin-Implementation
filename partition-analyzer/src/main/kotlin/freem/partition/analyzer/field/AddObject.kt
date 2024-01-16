package freem.partition.analyzer.field

import freem.partition.analyzer.Partition
import freem.partition.analyzer.PartitionAnalyzeTask
import freem.partition.analyzer.PartitionAnalyzeTaskExecuteObject
import freem.partition.analyzer.PartitionAnalyzeTaskQueue

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

    infix fun dynamic(string: () -> String): AdditionalOptions {
        TODO("Not yet implemented")
    }

    infix fun <Return> partition(partition: Partition<Return>): FuturePromisedAdditionalOptions<Return> {
        TODO("Not yet implemented")
    }

    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions {
        TODO("Not yet implemented")
    }

    infix fun switch(field: SwitchField<Unit>.() -> Unit): FuturePromisedAdditionalOptions<String> {
        TODO("Not yet implemented")
    }

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    infix fun <Return> switch(field: SwitchField<Return>.() -> Unit): FuturePromisedAdditionalOptions<Return> {
        TODO("Not yet implemented")
    }

}

