package libfsp.components

import libfsp.FSPPatternContext
import libfsp.reference.FSPReference

abstract class FSPTypedPattern<Type, Return>: FSPPattern<Type, FSPReference<Return>>() {
    internal val returnReference: FSPReference<Return>
    final override val components: Array<FSPComponent<Type>>

    init {
        val components = mutableListOf<FSPComponent<Type>>()
        val field = FSPPatternContext(components)
        returnReference = field.initialize()
        this.components = components.toTypedArray()
    }
}