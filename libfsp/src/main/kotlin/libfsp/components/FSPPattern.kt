package libfsp.components

import libfsp.components.contexts.FSPComponentListConstructDispatcher

sealed class FSPPattern<Type, InitializeReturn, ComponentReturn>: FSPComponent<Type, ComponentReturn> {
    protected abstract fun FSPComponentListConstructDispatcher<Type>.initialize(): InitializeReturn
    internal abstract val components: List<FSPComponent<Type, *>>
}
