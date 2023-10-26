package org.freem.compiler.frontend.partition

import org.freem.compiler.frontend.module.Module

fun <T, D>part(block: PartitionBlock<T, D>): Partition<T, D> = Partition(block)

data class Partition<T, D>(val block: PartitionBlock<T, D>)

typealias PartitionBlock<T, D> = PartitionStruct<T, D>.() -> Unit

interface PartitionStruct<T, D>: Iterator<T> {
    val stack: List<T>
    val data: D

    fun interrupt(message: String? = null): Nothing
    fun current(): T
    override fun next(): T
    override fun hasNext(): Boolean
}

