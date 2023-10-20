package org.freem.compiler.frontend.partition

import java.util.*

open class PartitionProcessor<T>(): PartitionStruct<T> {
    private var index: Int = 0
    override val stack: List<T> = Stack()
    override val data: MutableMap<String, String> = mutableMapOf()

    override fun interrupt(message: String?) = throw PartitionInterruptedException(message, this)
    override fun import(partition: Partition<T>) = TODO("Not yet implemented")
    override fun current(): T = TODO("Not yet implemented")
    override fun next(): T = TODO("Not yet implemented")
    override fun hasNext(): Boolean = TODO("Not yet implemented")
}