package libfsp.components

class FSPGroup<Type, Return> internal constructor(internal val components: List<FSPComponent<Type, *>>): FSPComponent<Type, Return>