package tyfe.internal

internal object NoneIterator : Iterator<Nothing> {
    override fun next(): Nothing {
        throw IndexOutOfBoundsException()
    }

    override fun hasNext(): Boolean {
        return false
    }
}
