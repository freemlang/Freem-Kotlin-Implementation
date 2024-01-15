package org.freem.compiler.frontend

class PartitionExecutor<Return>(private val partition: Partition<Return>) {
    fun execute(iterator: Iterator<Char>): Return {
        TODO()
    }
    fun execute(iterable: Iterable<Char>)   = execute(iterable.iterator())
    fun execute(array: Array<Char>)         = execute(array.iterator())
    fun execute(sequence: Sequence<Char>)   = execute(sequence.iterator())
    fun execute(charSequence: CharSequence) = execute(charSequence.iterator())
}