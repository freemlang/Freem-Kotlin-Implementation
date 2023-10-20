package org.freem.compiler.frontend.partition

fun <T>part(block: PartitionBlock<T>): Partition<T> = PartitionData(block)
fun <T>part(id: String, block: PartitionBlock<T>): Partition<T> = IDPartitionData(id, block)

interface Partition<T> {
    val partitionBlock: PartitionBlock<T>
}

interface IDPartition<T>: Partition<T> {
    val id: String
}

private open class PartitionData<T>(
    override val partitionBlock: PartitionBlock<T>
): Partition<T>

private open class IDPartitionData<T>(
    override val id: String,
    partitionBlock: PartitionBlock<T>
): PartitionData<T>(partitionBlock), IDPartition<T>

typealias PartitionBlock<T> = PartitionStruct<T>.() -> Unit

interface PartitionStruct<T>: Iterator<T> {
    val stack: List<T>
    val data: MutableMap<String, *>

    fun interrupt(message: String? = null): Nothing
    fun import(partition: Partition<T>)
    fun current(): T
    override fun next(): T
    override fun hasNext(): Boolean
}

interface IDPartitionStruct<T>: PartitionStruct<T> {
    val id: String
}