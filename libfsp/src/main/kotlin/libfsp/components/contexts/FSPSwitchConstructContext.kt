package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPSwitchConstructContext<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructContext<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    var FSPSwitchConstructContext<Type>.case: FSPComponent<Type, *>
        get() = throw NullPointerException()
        set(task) { components_.add(task) }
}