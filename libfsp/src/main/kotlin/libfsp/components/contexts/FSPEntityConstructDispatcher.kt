package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPEntity
import libfsp.components.FSPLambdaTask
import libfsp.components.FSPTask
import libfsp.reference.*
import java.util.LinkedList
import kotlin.reflect.KProperty

class FSPEntityConstructDispatcher<Type> private constructor(): FSPComponentConstructDispatcher<Type>() {

    companion object {
        internal fun <Type> createEntity(constructor: context(FSPEntityConstructDispatcher<Type>) () -> Unit): FSPEntity<Type, Unit> {
            val dispatcher = FSPEntityConstructDispatcher<Type>()
            constructor(dispatcher)
            val entities = dispatcher.entityBuffer + dispatcher.memoryReleaseEntityBuffer
            return FSPEntity(FSPComponent(entities, FSPUnit), null)
        }
    }

    private val entityBuffer = LinkedList<FSPEntity<Type, *>>()
    private val memoryReleaseEntityBuffer = LinkedList<FSPEntity<Type, Unit>>()

    context(FSPEntityConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.queue(lazyErrorMessage: (context(FSPReferenceAccessDispatcher) () -> String)? = null): FSPValueDelegate<Type, Return> {
        entityBuffer.add(FSPEntity(this, lazyErrorMessage))
        return TODO()
    }

    context(FSPEntityConstructDispatcher<Type>)
    fun Type.queue(lazyErrorMessage: (context(FSPReferenceAccessDispatcher) () -> String)? = null): FSPValueDelegate<Type, List<Type>> {
        return const(this).queue(lazyErrorMessage)
    }

    context(FSPEntityConstructDispatcher<Char>)
    fun String.queue(lazyErrorMessage: (context(FSPReferenceAccessDispatcher) () -> String)? = null): FSPValueDelegate<Char, List<Char>> {
        return const(this).queue(lazyErrorMessage)
    }

    context(FSPEntityConstructDispatcher<Type>)
    fun task(task: context(FSPReferenceAccessDispatcher) () -> Unit) {
        entityBuffer.add(
            FSPEntity(
                FSPLambdaTask { _, dispatcher ->
                    task(dispatcher)
                }, null
            )
        )
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Value> value(initializer: context(FSPReferenceAccessDispatcher) () -> Value): FSPValue<Value> {
        return newReference(initializer)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Variance> variance(initializer: context(FSPReferenceAccessDispatcher) () -> Variance): FSPVariance<Variance> {
        return newReference(initializer)
    }

    private fun <RefType> newReference(initializer: context(FSPReferenceAccessDispatcher) () -> RefType): FSPReference<RefType> {
        val reference = FSPReference<RefType>()
        entityBuffer.add(
            FSPEntity(
                FSPLambdaTask { uuid, dispatcher ->
                    reference.enable(uuid, initializer(dispatcher))
                }, null
            )
        )
        memoryReleaseEntityBuffer.add(
            FSPEntity(
                FSPLambdaTask { uuid, _ ->
                    reference.disable(uuid)
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