package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPTypedSwitchContext<Type, Return> internal constructor(components: MutableMap<FSPComponent<Type, *>, Return>): FSPComponentContext<Type>() {

    internal constructor(): this(mutableMapOf())

    internal val components: Map<FSPComponent<Type, *>, Return> get() = components_.toMap()
    private val components_: MutableMap<FSPComponent<Type, *>, Return> = components

    private val case_ = Case()
    val FSPTypedSwitchContext<Type, Return>.case get() = case_
    inner class Case {
        operator fun set(`return`: Return, component: FSPComponent<Type, *>) {
            components_[component] = `return`
        }
    }
}