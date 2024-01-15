package org.freem.compiler.partition.interfaces.field

import org.freem.compiler.partition.Partition

interface AddObject {
    infix fun static(string: String): AdditionalOptions
    infix fun static(char: Char): AdditionalOptions
    infix fun custom(condition: (Char) -> Boolean): AdditionalOptions
    infix fun dynamic(string: () -> String): AdditionalOptions
    infix fun <Return> partition(partition: Partition<Return>): FuturePromisedAdditionalOptions<Return>
    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions
    infix fun switch(field: SwitchField<Unit>.() -> Unit): FuturePromisedAdditionalOptions<String>
    @Suppress("INAPPLICABLE_JVM_NAME") @JvmName("typedSwitch")
    infix fun <Return> switch(field: SwitchField<Return>.() -> Unit): FuturePromisedAdditionalOptions<Return>
}

