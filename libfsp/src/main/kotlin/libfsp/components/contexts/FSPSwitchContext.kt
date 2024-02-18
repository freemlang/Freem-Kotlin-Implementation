package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPSwitchContext<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentContext<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    var FSPSwitchContext<Type>.case: FSPComponent<Type, *>
        get() = throw NullPointerException()
        set(task) { components_.add(task) }
}