package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPTask
import libfsp.reference.FSPReferenceContext

class FSPPatternContext<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentContext<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    private var currentComponent: FSPComponent<Type, *>? = null
    var FSPPatternContext<Type>.next: FSPComponent<Type, *>
        get() = currentComponent?:throw NullPointerException()
        set(task) {
            components_.add(task)
            currentComponent = task
        }

    fun FSPPatternContext<Type>.task(task: FSPReferenceContext.() -> Unit) {
        components_.add(FSPTask { FSPReferenceContext().task() })
    }
}