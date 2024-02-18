package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPTypedSwitchContext<Type, Return> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructContext<Type>() {
    val case = Case()
    inner class Case {
        operator fun set(`return`: Return, component: FSPComponent<Type, *>) {
            TODO()
        }
    }
}