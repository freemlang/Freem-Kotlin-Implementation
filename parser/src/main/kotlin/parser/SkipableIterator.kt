package parser

interface SkipableIterator<T> : Iterator<T> {
    fun skip(n: Long)
}
