package libfsp.components

import libfsp.components.contexts.FSPPatternInitializeDispatchReceiver
import libfsp.reference.FSPValue

abstract class FSPTypedPattern<Type, Return>: FSPPattern<Type, FSPValue<Return>, Return>() {
    internal val returnReference: FSPValue<Return>
    final override val components: List<FSPComponent<Type, *>>

    init {
        val context = FSPPatternInitializeDispatchReceiver<Type>()
        @Suppress("LeakingThis")
        returnReference = context.initialize()
        components = FSPConstant.combineConsecutiveConstants(context.components)
        check(components.isNotEmpty()) { "pattern is empty" }
    }
}