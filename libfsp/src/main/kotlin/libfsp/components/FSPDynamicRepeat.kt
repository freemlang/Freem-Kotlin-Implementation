package libfsp.components

sealed class FSPDynamicRepeat<Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>: FSPRepeat<Type, ComponentReturn, Component>() {
    internal abstract val min: Int?
    internal abstract val max: Int?
}