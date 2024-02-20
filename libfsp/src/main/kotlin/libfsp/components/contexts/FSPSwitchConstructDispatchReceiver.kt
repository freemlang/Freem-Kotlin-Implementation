package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPSwitchConstructDispatchReceiver<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructDispatchReceiver<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    context(FSPSwitchConstructDispatchReceiver<Type>)
    var case: FSPComponent<Type, *>
        get() = throw NullPointerException()
        set(task) { components_.add(task) }
}