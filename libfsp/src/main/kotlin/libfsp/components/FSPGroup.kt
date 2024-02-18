package libfsp.components

data class FSPGroup<Type> internal constructor(internal val components: List<FSPComponent<Type>>): FSPComponent<Type>