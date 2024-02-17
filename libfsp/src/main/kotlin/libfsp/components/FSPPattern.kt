package libfsp.components

import libfsp.FSPPatternContext

sealed class FSPPattern<Type, Return>: FSPComponent<Type> {
    protected abstract fun FSPPatternContext<Type>.initialize(): Return
    internal abstract val components: Array<FSPComponent<Type>>
}