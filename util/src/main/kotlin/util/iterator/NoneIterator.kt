package util.iterator

object NoneIterator : Iterator<Nothing> {
    override fun next(): Nothing {
        throw IndexOutOfBoundsException()
    }

    override fun hasNext(): Boolean {
        return false
    }
}
