package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPLambdaTask
import libfsp.reference.FSPReferenceContext

class FSPPatternInitializeDispatchReceiver<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructDispatchReceiver<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    private var currentComponent: FSPComponent<Type, *>? = null
    context(FSPPatternInitializeDispatchReceiver<Type>)
    var next: FSPComponent<Type, *>
        get() = currentComponent?:throw NullPointerException()
        set(task) {
            components_.add(task)
            currentComponent = task
        }

    context(FSPPatternInitializeDispatchReceiver<Type>)
    fun task(task: context(FSPReferenceContext) () -> Unit) {
        components_.add(FSPLambdaTask { task(FSPReferenceContext()) })
    }
}