package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeContext

sealed class FSPPattern<Type, InitializeReturn, ComponentReturn>: FSPComponent<Type, ComponentReturn> {
    protected abstract fun FSPPatternInitializeContext<Type>.initialize(): InitializeReturn
    internal abstract val components: List<FSPComponent<Type, *>>
}