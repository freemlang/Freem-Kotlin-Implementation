package util.iterator

class SingleIterator<T>(private val value: T) : Iterator<T> {
    private var consumed = false

    override fun next(): T {
        if (consumed) throw IndexOutOfBoundsException()
        consumed = true
        return value
    }

    override fun hasNext(): Boolean {
        return !consumed
    }
}
