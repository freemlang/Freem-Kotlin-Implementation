package freem.partition.analyzer.field

import freem.partition.analyzer.Partition

class AddObject internal constructor() {
    infix fun static(string: String): AdditionalOptions {
        TODO("Not yet implemented")
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

