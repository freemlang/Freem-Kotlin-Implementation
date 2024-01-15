package org.freem.compiler.frontend.implement.field

import org.freem.compiler.frontend.Partition
import org.freem.compiler.frontend.interfaces.field.*
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

internal class AddObjectImpl: AddObject {
    val queue: Queue<Iterator<Char>.() -> Unit> = LinkedList()

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

    override fun <ReturnType> partition(partition: Partition<ReturnType>): FuturePromisedAdditionalOptions<ReturnType> {
        TODO("Not yet implemented")
    }

    override fun field(field: PartitionField.() -> Unit): AdditionalOptions {
        TODO("Not yet implemented")
    }

    override fun switch(field: SwitchField<Unit>.() -> Unit): FuturePromisedAdditionalOptions<String> {
        TODO("Not yet implemented")
    }

    override fun <ReturnType> switch(field: SwitchField<ReturnType>.() -> Unit): FuturePromisedAdditionalOptions<ReturnType> {
        TODO("Not yet implemented")
    }
}