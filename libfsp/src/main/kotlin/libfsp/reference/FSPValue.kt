package libfsp.reference

sealed class FSPValue<Type> {
    internal abstract val value: Type
}