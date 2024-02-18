package libfsp.components

data class FSPGreedyRepeat<Type> internal constructor(
    override val min: Int?,
    override val max: Int?,
    override val component: FSPComponent<Type>
): FSPDynamicRepeat<Type>()