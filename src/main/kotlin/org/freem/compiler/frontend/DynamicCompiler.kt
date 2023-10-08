package org.freem.compiler.frontend

abstract class DynamicCompiler<T, R> {

    fun compile(array: Array<T>): R = compile(array.iterator())
    fun compile(sequence: Sequence<T>): R = compile(sequence.iterator())
    fun compile(iterable: Iterable<T>): R = compile(iterable.iterator())
    fun compile(iterator: Iterator<T>): R {
        // TODO
        return getResult()
    }

    protected abstract fun getResult(): R
}

abstract class DynamicIterator<T>: Iterator<T> {
    fun nextOrNull(): T? { TODO() }
    override fun next(): T { TODO() }
    override fun hasNext(): Boolean { TODO() }
    fun get(offset: Int): T { TODO() }
    fun peek(): T = get(0)
}

abstract class Process<T> {
    protected val iterator: DynamicIterator<T> = TODO()
}

interface Pattern

interface Any
interface Maybe
interface Amount
interface Group
