package libfsp.components

data class FSPStaticRepeat<Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>(
    internal val times: Int,
    override val component: Component
): FSPRepeat<Type, ComponentReturn, Component>()