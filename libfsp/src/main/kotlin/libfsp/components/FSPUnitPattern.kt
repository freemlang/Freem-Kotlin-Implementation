package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeDispatcher

abstract class FSPUnitPattern<Type>: FSPPattern<Type, Unit, Unit>() {
    final override val components: List<FSPComponent<Type, *>>

    init {
        val context = FSPPatternInitializeDispatcher<Type>()
        context.initialize()
        components = FSPConstant.combineConsecutiveConstants(context.components)
        check(components.isNotEmpty()) { "pattern is empty" }
    }
}