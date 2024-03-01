package libfsp.components

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPUnit
import libfsp.reference.FSPValue
import java.util.*

abstract class FSPUnitComponent<Type>: FSPComponent<Type, Unit>() {
    protected abstract fun FSPEntityConstructDispatcher<Type>.initialize()

    internal val component: FSPComponent<Type, Unit> by lazy {
        val components = LinkedList<FSPComponent<Type, *>>()
        val dispatcher = FSPEntityConstructDispatcher(components)
        dispatcher.initialize()
        val component = when (components.size) {
            0 -> throw IllegalStateException("component cannot be empty")
            1 -> FSPReturnDelegateComponent(components[0], FSPUnit)
            else -> FSPGroup(components, FSPUnit)
        }
        return@lazy component
    }

    override fun FSPComponentDispatcher<Type>.run(): FSPValue<Unit> {
        with(component) { run() }
        return FSPUnit
    }
}