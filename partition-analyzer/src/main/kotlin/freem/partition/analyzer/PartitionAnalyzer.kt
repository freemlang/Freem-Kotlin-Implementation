package freem.partition.analyzer

class PartitionAnalyzer<Return>(private val partition: Partition<Return>) {
    fun analyze(iterator: Iterator<Char>): Return {
        TODO()
    }
    fun analyze(iterable: Iterable<Char>)   = analyze(iterable.iterator())
    fun analyze(array: Array<Char>)         = analyze(array.iterator())
    fun analyze(sequence: Sequence<Char>)   = analyze(sequence.iterator())
    fun analyze(charSequence: CharSequence) = analyze(charSequence.iterator())
}