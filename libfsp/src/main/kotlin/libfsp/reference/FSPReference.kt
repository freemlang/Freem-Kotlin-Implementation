package libfsp.reference

sealed class FSPReference<Type> {
    internal abstract val value: Type
}