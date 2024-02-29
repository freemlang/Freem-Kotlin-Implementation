package libfsp.components

data class FSPSwitch<Type, Return> internal constructor(internal val components: List<FSPComponent<Type, Return>>): FSPComponent<Type, Return>