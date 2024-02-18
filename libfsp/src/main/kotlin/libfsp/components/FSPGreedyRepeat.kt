package libfsp.components

data class FSPGreedyRepeat<Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>> internal constructor(
    override val min: Int?,
    override val max: Int?,
    override val component: Component
): FSPDynamicRepeat<Type, ComponentReturn, Component>()