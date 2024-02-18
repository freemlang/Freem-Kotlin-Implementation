package libfsp.components

data class FSPSwitch<Type> internal constructor(internal val components: FSPComponent<Type, *>): FSPComponent<Type, List<Type>>