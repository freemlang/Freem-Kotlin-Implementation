package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeDispatcher

sealed class FSPPattern<Type, InitializeReturn, ComponentReturn>: FSPComponent<Type, ComponentReturn> {
    protected abstract fun FSPPatternInitializeDispatcher<Type>.initialize(): InitializeReturn
    internal abstract val components: List<FSPComponent<Type, *>>
}
