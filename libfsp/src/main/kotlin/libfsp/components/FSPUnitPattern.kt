package libfsp.components

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPReferenceDispatcher

abstract class FSPUnitPattern<Type>: FSPPattern<Type, Unit, Unit>() {
    final override val components: List<FSPComponent<Type, *>> by lazy {
        val components = mutableListOf<FSPComponent<Type, *>>()
        val dispatcher = FSPComponentListConstructDispatcher(components)
        with(dispatcher) { initialize() }
        check(components.isNotEmpty()) { "pattern is empty" }
        return@lazy components
    }
}