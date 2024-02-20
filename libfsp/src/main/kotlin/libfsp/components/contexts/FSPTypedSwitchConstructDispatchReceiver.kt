package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPTypedSwitchConstructDispatchReceiver<Type, Return> internal constructor(components: MutableMap<FSPComponent<Type, *>, Return>): FSPComponentConstructDispatchReceiver<Type>() {

    internal constructor(): this(mutableMapOf())

    internal val components: Map<FSPComponent<Type, *>, Return> get() = components_.toMap()
    private val components_: MutableMap<FSPComponent<Type, *>, Return> = components

    private val case_ = Case()
    context(FSPTypedSwitchConstructDispatchReceiver<Type, Return>)
    val case get() = case_
    inner class Case {
        operator fun set(`return`: Return, component: FSPComponent<Type, *>) {
            components_[component] = `return`
        }
    }
}