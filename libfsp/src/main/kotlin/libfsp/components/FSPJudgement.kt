package libfsp.components

data class FSPJudgement<Type> internal constructor(internal val condition: (Type) -> Boolean): FSPComponent<Type, Type>