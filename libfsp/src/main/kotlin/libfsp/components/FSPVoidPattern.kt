package libfsp.components

import libfsp.FSPPatternContext

abstract class FSPVoidPattern<Type>: FSPPattern<Type, Unit>() {
    final override val components: Array<FSPComponent<Type>>

    init {
        val components = mutableListOf<FSPComponent<Type>>()
        val field = FSPPatternContext(components)
        field.initialize()
        this.components = components.toTypedArray()
    }
}