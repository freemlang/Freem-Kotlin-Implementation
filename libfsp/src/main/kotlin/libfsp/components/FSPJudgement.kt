package libfsp.components

data class FSPJudgement<Type> internal constructor(internal val condition: (Type) -> Boolean): FSPComponent<Type, Type>() {
    override fun FSPEntityExecuteDispatcher<Type>.run() {
        if (condition(input[index]).not()) throwInvalid()
        index++
    }
}