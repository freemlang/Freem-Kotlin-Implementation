package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeContext

abstract class FSPUnitPattern<Type>: FSPPattern<Type, Unit, Unit>() {
    final override val components: List<FSPComponent<Type, *>>

    init {
        val context = FSPPatternInitializeContext<Type>()
        @Suppress("LeakingThis")
        context.initialize()
        components = FSPConstant.combineConsecutiveConstants(context.components)
        check(components.isNotEmpty()) { "pattern is empty" }
    }
}