package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPEntity
import libfsp.components.FSPLambdaTask
import libfsp.reference.*
import java.util.LinkedList
import kotlin.reflect.KProperty

class FSPEntityConstructDispatcher<Type> private constructor(): FSPComponentConstructDispatcher<Type>() {

    companion object {
        internal fun <Type, Return> createEntity(constructor: context(FSPEntityConstructDispatcher<Type>) () -> Unit): FSPEntity<Type, Return> {
            val dispatcher = FSPEntityConstructDispatcher<Type>()

        }
    }

    private val componentBuffer = LinkedList<FSPComponent<Type, *>>()

    context(FSPEntityConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.queue(lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)? = null): FSPValueDelegate<Type, Return> {
        if (lazyErrorMessage != null) {
            componentBuffer
        }
        return TODO()
    }

    context(FSPEntityConstructDispatcher<Type>)
    fun Type.queue(lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)? = null): FSPValueDelegate<Type, List<Type>> {
        return const(this).queue(lazyErrorMessage)
    }

    context(FSPEntityConstructDispatcher<Char>)
    fun String.queue(lazyErrorMessage: (context(FSPReferenceDispatcher) () -> String)? = null): FSPValueDelegate<Char, List<Char>> {
        return const(this).queue(lazyErrorMessage)
    }

    context(FSPEntityConstructDispatcher<Type>)
    fun task(task: context(FSPReferenceDispatcher) () -> Unit) {
        entities.add(
            FSPEntity(
                FSPLambdaTask { _, dispatcher ->
                    task(dispatcher)
                }, null
            )
        )
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
        entities.add(
            FSPEntity(
                FSPLambdaTask { uuid, dispatcher ->
                    reference.register(uuid, initializer(dispatcher))
                }, null
            )
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