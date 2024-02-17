package libfsp.components

sealed class Repeat<Type>: FSPComponent<Type> {
    internal abstract val min: Int?
    internal abstract val max: Int?
}