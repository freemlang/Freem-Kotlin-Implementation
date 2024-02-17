package libfsp.components

data class Group<Type>(internal val components: List<FSPComponent<Type>>): FSPComponent<Type>