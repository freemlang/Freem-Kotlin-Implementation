package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPLambdaTask
import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue
import kotlin.reflect.KProperty

class FSPPatternInitializeDispatcher<Type> internal constructor(components: MutableList<FSPComponent<Type, *>>): FSPComponentConstructDispatcher<Type>() {

    internal constructor(): this(mutableListOf())

    internal val components: List<FSPComponent<Type, *>> get() = components_.toList()
    private val components_: MutableList<FSPComponent<Type, *>> = components

    context(FSPPatternInitializeDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.queue(): FSPValueDelegate<Type, Return> { TODO() }

    context(FSPPatternInitializeDispatcher<Type>)
    fun task(task: context(FSPReferenceDispatcher) () -> Unit) {
        components_.add(FSPLambdaTask { task(FSPReferenceDispatcher()) })
    }

    context(FSPPatternInitializeDispatcher<Type>)
    fun <Type> ((Type) -> Boolean).queue(): FSPValueDelegate<Type, Type> = judge(this).queue()

    context(FSPPatternInitializeDispatcher<Type>)
    fun <Type> Type.queue(): FSPValueDelegate<Type, List<Type>> = const(this).queue()

    context(FSPPatternInitializeDispatcher<Char>)
    fun String.queue(): FSPValueDelegate<Char, List<Char>> = const(this).queue()
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