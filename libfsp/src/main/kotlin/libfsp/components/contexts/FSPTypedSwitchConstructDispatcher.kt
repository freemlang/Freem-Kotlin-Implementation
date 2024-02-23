package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue

class FSPTypedSwitchConstructDispatcher<Type, Return> private constructor(): FSPComponentConstructDispatcher<Type>() {

    internal companion object {
        operator fun <Type, Return> invoke(context: context(FSPTypedSwitchConstructDispatcher<Type, Return>) () -> Unit): List<Pair<FSPComponent<Type, *>, Return>> {
            val dispatcher = FSPTypedSwitchConstructDispatcher<Type, Return>()
            context(dispatcher)
            val components = dispatcher.components.toList()
            dispatcher.components.clear()
            return components
        }
    }

    private val components: MutableList<Pair<FSPComponent<Type, *>, Return>> = mutableListOf()

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Return, ComponentReturn> FSPComponent<Type, ComponentReturn>.queue(
        `return`: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, ComponentReturn>) -> Return
    ) { TODO() }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Return> FSPComponent<Type, Return>.queue() { this.queue { val fspvalue by it; fspvalue.value } }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Type> ((Type) -> Boolean).queue(
        `return`: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, Type>) -> Return
    ) { judge(this).queue(`return`) }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Type> Type.queue(
        `return`: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, List<Type>>) -> Return
    ) { const(this).queue(`return`) }

    context(FSPTypedSwitchConstructDispatcher<Char, Return>)
    fun String.queue(
        `return`: context(FSPReferenceDispatcher) (FSPValueDelegate<Char, List<Char>>) -> Return
    ) { const(this).queue(`return`) }
}