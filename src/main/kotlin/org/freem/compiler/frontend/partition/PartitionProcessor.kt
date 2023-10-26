package org.freem.compiler.frontend.partition

import java.util.*

open class PartitionProcessor<T>(): PartitionStruct<T, Nothing> {
    private var index: Int = 0
    override val stack: List<T> = Stack()
    override val data: Nothing = TODO()

    override fun interrupt(message: String?) = TODO() //throw PartitionInterruptedException(message, this)
    override fun current(): T = TODO("Not yet implemented")
    override fun next(): T = TODO("Not yet implemented")
    override fun hasNext(): Boolean = TODO("Not yet implemented")
}