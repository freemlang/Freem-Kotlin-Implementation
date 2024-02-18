package libfsp.components

import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

abstract class FSPTypedPattern<Type, Return>: FSPPattern<Type, FSPValue<Return>>() {
    internal val returnReference: FSPValue<Return>
    final override val components: Array<FSPComponent<Type>>

    init {
        val components = mutableListOf<FSPComponent<Type>>()
        val field = FSPPatternContext(components)
        returnReference = field.initialize()
        this.components = components.toTypedArray()
    }
}