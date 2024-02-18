package libfsp.components

import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

abstract class FSPTypedPattern<Type, Return>: FSPPattern<Type, FSPValue<Return>, Return>() {
    internal val returnReference: FSPValue<Return>
    final override val components: List<FSPComponent<Type, *>>

    init {
        val context = FSPPatternContext<Type>()
        returnReference = context.initialize()
        components = context.components
        check(components.isNotEmpty()) { "pattern is empty" }
    }
}