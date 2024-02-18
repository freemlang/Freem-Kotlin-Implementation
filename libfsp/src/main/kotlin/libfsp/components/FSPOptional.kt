package libfsp.components

data class FSPOptional<Type> internal constructor(internal val component: FSPComponent<Type>): FSPComponent<Type>