package org.freem.compiler.frontend

interface Partition<Return> {
    fun PartitionField.initialize(): Return
}

sealed class PartitionField: Iterator<Char> {

    protected abstract val array: Array<Char>
    var index: Int = 0
        private set

    object add {
        infix fun static(string: String): AdditionalOptions { TODO() }
        infix fun static(char: Char): AdditionalOptions { TODO() }
    }
    sealed class AdditionalOptions {

    }

    fun current(): Char= array[index]
    fun currentOrNull(): Char? = array.getOrNull(index)
    fun nextOrNull(): Char? = array.getOrNull(index++)
    override fun next(): Char = array[index++]
    override fun hasNext(): Boolean = index < array.size

    fun need(char: Char, message: String? = null): Char = need(message) { it == char }

    fun need(message: String? = null, condition: (Char) -> Boolean): Char {
        val char = currentOrNull()?:interrupt(Exception("TODO"))
        if (!condition(char)) interrupt(message)
        index++
        return char
    }

    fun need(string: String, message: String? = null): String {
        val startIndex = index
        for (char in string) need(char, message)
        val result = array.sliceArray(startIndex..<index).joinToString("")
        return result
    }
    
    fun <Return> import(partition: Partition<Return>, message: String? = null): Return {
        val startIndex = index
        val thisRef = this
        try {
            return with(partition) {
                thisRef.initialize()
            }
        } catch (throwable: Throwable) {
            index = startIndex
            interrupt(message, throwable)
        }
    }

    fun interrupt(message: String?, cause: Throwable?)  : Nothing = throw PartitionInterruption(message, cause)
    fun interrupt(message: String?)                     : Nothing = throw PartitionInterruption(message)
    fun interrupt(cause: Throwable?)                    : Nothing = throw PartitionInterruption(cause)
    fun interrupt()                                     : Nothing = throw PartitionInterruption()
}

class Field(override val array: Array<Char>): PartitionField()

class PartitionInterruption(message: String?, cause: Throwable?): Throwable(message, cause) {
    constructor(message: String?): this(message, null)
    constructor(cause: Throwable?): this(cause?.toString(), cause)
    constructor(): this(null, null)
}