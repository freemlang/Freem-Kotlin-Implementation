package freem.partition.analyzer.task

internal class AnalyzeTaskExecutionObject(private val input: Iterator<Char>): Iterator<Char> {
    private var _index: Int = 0
    val index: Int get() = _index

    private var _isFailed: Boolean = false
    val isFailed: Boolean get() = _isFailed

    val peek: Char get() = TODO()

    fun advance() {
        _index++
    }

    override fun next(): Char {
        val value = peek
        advance()
        return peek
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    fun fail(): Nothing {
        _isFailed = true
        throw AnalyzeTaskFailure()
    }
}