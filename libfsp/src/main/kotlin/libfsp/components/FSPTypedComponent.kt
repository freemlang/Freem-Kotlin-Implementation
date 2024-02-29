package libfsp.components

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue
import java.util.LinkedList

abstract class FSPTypedComponent<Type, Return>: FSPComponent<Type, Return>() {
    protected abstract fun FSPComponentListConstructDispatcher<Type>.initialize(): FSPValue<Return>

    internal val component: FSPComponent<Type, Return> get() = lazy.first
    internal val returnValue: FSPValue<Return> get() = lazy.second
    private val lazy by lazy {
        val components = LinkedList<FSPComponent<Type, *>>()
        val dispatcher = FSPComponentListConstructDispatcher(components)
        val returnValue = dispatcher.initialize()
        val component = when (components.size) {
            0 -> throw IllegalStateException("component cannot be empty")
            1 -> FSPReturnDelegateComponent(components[0], returnValue)
            else -> FSPGroup(components, returnValue)
        }
        return@lazy component to returnValue
    }

    override fun FSPComponentDispatcher<Type>.run(): FSPValue<Return> {
        with(component) { run() }
        return returnValue
    }
}