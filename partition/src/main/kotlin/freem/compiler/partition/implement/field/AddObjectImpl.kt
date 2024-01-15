package freem.compiler.partition.implement.field

import freem.compiler.partition.Partition
import freem.compiler.partition.interfaces.field.*
import java.util.LinkedList
import java.util.Queue

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