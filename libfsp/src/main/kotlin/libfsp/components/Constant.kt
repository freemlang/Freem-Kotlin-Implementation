package libfsp.components

data class Constant<Type>(internal val content: Array<Type>): FSPComponent<Type>