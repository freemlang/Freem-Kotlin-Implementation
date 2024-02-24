package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPConstant
import libfsp.components.FSPLambdaTask
import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.reflect.KProperty

class FSPComponentListConstructDispatcher<Type> internal constructor(
    private val components: MutableList<FSPComponent<Type, *>>
): FSPComponentConstructDispatcher<Type>() {

    internal companion object {
        fun <Type> combineConsecutiveConstants(components: List<FSPComponent<Type, *>>): List<FSPComponent<Type, *>> {
            val componentBuffer = mutableListOf<FSPComponent<Type, *>>()
            if (components.isEmpty()) throw IllegalStateException("group is empty")
            else if (components.size > 1) {
                val constBuffer = mutableListOf<Type>()
                fun uploadBuffer() {
                    if (constBuffer.isNotEmpty()) {
                        componentBuffer.add(FSPConstant(constBuffer.toList()))
                        constBuffer.clear()
                    }
                }
                for (component in components) {
                    if (component is FSPConstant) {
                        constBuffer.addAll(component.content)
                        continue
                    }
                    uploadBuffer()
                    componentBuffer.add(component)
                }
                uploadBuffer()
            }
            val result = componentBuffer.toList()
            componentBuffer.clear()
            return result
        }
    }

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
        components.add(FSPLambdaTask { dispatcher -> task(dispatcher) })
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Value> value(initializer: context(FSPReferenceDispatcher) () -> Value): FSPValue<Value> { TODO() }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Variance> variance(initializer: context(FSPReferenceDispatcher) () -> Variance): FSPVariance<Variance> { TODO() }
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