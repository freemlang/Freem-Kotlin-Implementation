package org.freem.compiler.frontend.field

import org.freem.compiler.frontend.Partition

sealed interface AddObject {
    infix fun static(string: String): AdditionalOptions
    infix fun static(char: Char): AdditionalOptions
    infix fun custom(condition: (Char) -> Boolean): AdditionalOptions
    infix fun dynamic(string: () -> String): AdditionalOptions
    infix fun <Return> partition(partition: Partition<Return>): FuturePromisedAdditionalOptions<Return>
    infix fun field(field: PartitionField.() -> Unit): AdditionalOptions
    infix fun switch(field: CaseField<Unit>.() -> Unit): FuturePromisedAdditionalOptions<String>
    @Suppress("INAPPLICABLE_JVM_NAME") @JvmName("typedSwitch")
    infix fun <Return> switch(field: CaseField<Return>.() -> Unit): FuturePromisedAdditionalOptions<Return>
}

internal class AddObjectImpl: AddObject {
    override fun static(string: String): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun static(char: Char): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun custom(condition: (Char) -> Boolean): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun dynamic(string: () -> String): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun <Return> partition(partition: Partition<Return>): FuturePromisedAdditionalOptions<Return> {
        TODO("Not yet implemented")
    }

    override fun field(field: PartitionField.() -> Unit): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun switch(field: CaseField<Unit>.() -> Unit): FuturePromisedAdditionalOptions<String> {
        TODO("Not yet implemented")
    }

    override fun <Return> switch(field: CaseField<Return>.() -> Unit): FuturePromisedAdditionalOptions<Return> {
        TODO("Not yet implemented")
    }
}