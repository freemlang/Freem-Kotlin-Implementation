package libfsp.components

data class Judgement<Type>(internal val condition: (Type) -> Boolean): FSPComponent<Type>