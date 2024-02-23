package libfsp.components

class FSPGroup<Type, Return> internal constructor(components: List<FSPComponent<Type, *>>): FSPComponent<Type, Return> {
    internal val components: List<FSPComponent<Type, *>> = FSPConstant.combineConsecutiveConstants(components)
}