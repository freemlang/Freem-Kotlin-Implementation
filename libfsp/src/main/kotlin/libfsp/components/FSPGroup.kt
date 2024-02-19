package libfsp.components

class FSPGroup<Type> internal constructor(components: List<FSPComponent<Type, *>>): FSPComponent<Type, List<Type>> {
    internal val components: List<FSPComponent<Type, *>> = FSPConstant.combineConsecutiveConstants(components)
}