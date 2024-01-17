package freem.partition.analyzer

import freem.partition.analyzer.task.AnalyzeTaskExecutionObject

class PartitionAnalyzer<Return>(private val partition: Partition<Return>) {
    fun analyze(iterator: Iterator<Char>): Return {
        val executeObject = AnalyzeTaskExecutionObject(iterator)
        while (true) {
            val poll = partition.taskQueue.poll() ?: break
            with(poll) {
                executeObject.task()
            }
        }
        return partition.returnValue.value
    }
    fun analyze(iterable: Iterable<Char>)   = analyze(iterable.iterator())
    fun analyze(array: Array<Char>)         = analyze(array.iterator())
    fun analyze(sequence: Sequence<Char>)   = analyze(sequence.iterator())
    fun analyze(charSequence: CharSequence) = analyze(charSequence.iterator())
}