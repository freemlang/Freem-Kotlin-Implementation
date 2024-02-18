package libfsp.components

sealed class FSPDynamicRepeat<Type>: FSPRepeat<Type>() {
    internal abstract val min: Int?
    internal abstract val max: Int?
}