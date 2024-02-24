package libfsp.components

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue

abstract class FSPTypedPattern<Type, Return>: FSPPattern<Type, FSPValue<Return>, Return>() {
    final override val components: List<FSPComponent<Type, *>> get() = lazyInitializer.first
    internal val returnedValue: FSPValue<Return> get() = lazyInitializer.second

    private val lazyInitializer: Pair<List<FSPComponent<Type, *>>, FSPValue<Return>> by lazy {
        val components = mutableListOf<FSPComponent<Type, *>>()
        val dispatcher = FSPComponentListConstructDispatcher(components)
        val returnedValue: FSPValue<Return>
        with(dispatcher) { returnedValue = initialize() }
        check(components.isNotEmpty()) { "pattern is empty" }
        return@lazy components to returnedValue
    }
}