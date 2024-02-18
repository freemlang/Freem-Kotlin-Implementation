package libfsp.components

data class FSPOptional<Type, ComponentReturn> internal constructor(internal val component: FSPComponent<Type, ComponentReturn>): FSPComponent<Type, ComponentReturn?>