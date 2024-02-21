package libfsp.reference

sealed class FSPVariance<Type>: FSPValue<Type>() {
    abstract override var value: Type
    abstract fun apply(block: FSPReferenceDispatcher.() -> Unit): FSPVariance<Type>
}