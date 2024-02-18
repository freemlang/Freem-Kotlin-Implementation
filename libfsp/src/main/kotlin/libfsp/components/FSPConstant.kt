package libfsp.components

data class FSPConstant<Type> internal constructor(internal val content: List<Type>): FSPComponent<Type>