package libfsp

sealed class FSPNode<Type, Return> {
    fun parse(input: Array<out Type>) = parse(input.asList())
    fun parse(input: ArrayList<out Type>) = parse(input as List<Type>)

    private fun parse(input: List<Type>): Return {
        TODO()
    }

    internal abstract fun createParser()
}
