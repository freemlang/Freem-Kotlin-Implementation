package freem.partition.analyzer

import freem.partition.analyzer.task.AnalyzeTaskExecutionField

class PartitionAnalyzer<Return>(private val partition: Partition<Return>) {
    fun analyze(iterator: Iterator<Char>): Return {
        val executeObject = AnalyzeTaskExecutionField(iterator)
        for (task in partition.tasks) {
            with(task) {
                executeObject.run()
            }
        }
        TODO()
        //return partition.returnValue
    }
    fun analyze(iterable: Iterable<Char>)   = analyze(iterable.iterator())
    fun analyze(array: Array<Char>)         = analyze(array.iterator())
    fun analyze(sequence: Sequence<Char>)   = analyze(sequence.iterator())
    fun analyze(charSequence: CharSequence) = analyze(charSequence.iterator())
}