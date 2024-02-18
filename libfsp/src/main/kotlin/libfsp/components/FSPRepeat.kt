package libfsp.components

sealed class FSPRepeat<Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>: FSPComponent<Type, List<ComponentReturn>> {
    internal abstract val component: Component
}