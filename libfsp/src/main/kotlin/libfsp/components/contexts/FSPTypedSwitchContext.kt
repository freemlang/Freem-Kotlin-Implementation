package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPTypedSwitchContext<Type, Return> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructContext<Type>() {
    private val case_ = Case()
    val FSPTypedSwitchContext<Type, Return>.case get() = case_
    inner class Case {
        operator fun set(`return`: Return, component: FSPComponent<Type, *>) {
            TODO()
        }
    }
}