package libfsp.components

data class FSPLazyRepeat<Type> internal constructor(
    override val min: Int?,
    override val max: Int?,
    override val component: FSPComponent<Type>
): FSPDynamicRepeat<Type>()