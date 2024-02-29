package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPConstant
import libfsp.components.FSPLambdaTask
import libfsp.reference.*
import kotlin.reflect.KProperty

class FSPComponentListConstructDispatcher<Type> internal constructor(
    private val components: MutableList<FSPComponent<Type, *>>
): FSPComponentConstructDispatcher<Type>() {

    context(FSPComponentListConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.queue(): FSPValueDelegate<Type, Return> {
        components.add(this)
        return TODO()
    }

    context(FSPComponentListConstructDispatcher<Type>)
    fun Type.queue(): FSPValueDelegate<Type, List<Type>> = const(this).queue()

    context(FSPComponentListConstructDispatcher<Char>)
    fun String.queue(): FSPValueDelegate<Char, List<Char>> = const(this).queue()

    context(FSPComponentListConstructDispatcher<Type>)
    fun task(task: context(FSPReferenceDispatcher) () -> Unit) {
        components.add(FSPLambdaTask { _, dispatcher -> task(dispatcher) })
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Value> value(initializer: context(FSPReferenceDispatcher) () -> Value): FSPValue<Value> {
        return newReference(initializer)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Variance> variance(initializer: context(FSPReferenceDispatcher) () -> Variance): FSPVariance<Variance> {
        return newReference(initializer)
    }

    private fun <Type> newReference(initializer: context(FSPReferenceDispatcher) () -> Type): FSPReference<Type> {
        val reference = FSPReference<Type>()
        components.add(
            FSPLambdaTask { uuid, dispatcher ->
                reference.register(uuid, initializer(dispatcher))
            }
        )
        return reference
    }
}

class FSPValueDelegate<Type, Return> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): FSPValue<Return> {
        TODO()
    }
}

val FSPValueDelegate<Char, *>.asString: FSPStringDelegate get() = TODO()
val <Type> FSPValueDelegate<Type, *>.asList: FSPListDelegate<Type> get() = TODO()
class FSPListDelegate<Type> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): FSPValue<List<Type>> {
        TODO()
    }
}

class FSPStringDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): FSPValue<String> {
        TODO()
    }
}