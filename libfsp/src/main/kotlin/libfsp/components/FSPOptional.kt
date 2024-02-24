package libfsp.components

class FSPOptional<Type, Return> internal constructor(internal val component: FSPComponent<Type, Return>): FSPComponent<Type, Return?>