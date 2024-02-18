package libfsp.components

import libfsp.components.contexts.FSPPatternContext

sealed class FSPPattern<Type, InitializeReturn, ComponentReturn>: FSPComponent<Type, ComponentReturn> {
    protected abstract fun FSPPatternContext<Type>.initialize(): InitializeReturn
    internal abstract val components: List<FSPComponent<Type, *>>
}