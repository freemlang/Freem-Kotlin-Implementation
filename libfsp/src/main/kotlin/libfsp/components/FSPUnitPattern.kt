package libfsp.components

import libfsp.components.contexts.FSPPatternContext

abstract class FSPUnitPattern<Type>: FSPPattern<Type, Unit, Unit>() {
    final override val components: List<FSPComponent<Type, *>>

    init {
        val context = FSPPatternContext<Type>()
        context.initialize()
        components = context.components
    }
}