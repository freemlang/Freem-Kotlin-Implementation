package freem.partition.analyzer.task

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

internal class AnalyzeTaskExecutionField(private val input: Iterator<Char>): Iterator<Char> {
    var index = 0

    val peek: Char get() = TODO()

    fun advance() {
        index++
    }

    override fun next(): Char {
        val value = peek
        advance()
        return peek
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalContracts::class)
    fun backup(block: AnalyzeTaskExecutionField.() -> Boolean): Boolean {
        contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
        val backupIndex = index
        val result = block()
        if (!result) index = backupIndex
        return result
    }
}