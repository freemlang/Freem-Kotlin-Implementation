package libfsp.components

data class FSPTypedSwitch<Type, Return> internal constructor(internal val components: FSPComponent<Type, *>): FSPComponent<Type, Return>