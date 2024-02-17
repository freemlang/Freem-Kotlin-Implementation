package libfsp.reference

sealed class FSPVariance<Type>: FSPReference<Type>() {
    abstract override var value: Type
}