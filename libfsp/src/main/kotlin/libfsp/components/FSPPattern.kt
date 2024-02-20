package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver

sealed class FSPPattern<Type, InitializeReturn, ComponentReturn>: FSPComponent<Type, ComponentReturn> {
    protected abstract fun FSPPatternInitializeDispatchReceiver<Type>.initialize(): InitializeReturn
    internal abstract val components: List<FSPComponent<Type, *>>
}