package libfsp.components

data class FSPStaticRepeat<Type, Return>(
    internal val times: Int,
    override val component: FSPComponent<Type, Return>
): FSPRepeat<Type, Return>()