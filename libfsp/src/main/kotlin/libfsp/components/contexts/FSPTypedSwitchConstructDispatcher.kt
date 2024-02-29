package libfsp.components.contexts

import libfsp.components.FSPComponent
import libfsp.components.FSPGroup
import libfsp.components.FSPLambdaTask
import libfsp.reference.FSPReference
import libfsp.reference.FSPReferenceDispatcher

class FSPTypedSwitchConstructDispatcher<Type, Return> internal constructor(
    private val components: MutableList<FSPComponent<Type, Return>>
): FSPComponentConstructDispatcher<Type>() {

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun FSPComponent<Type, *>.queue(
        `return`: Return
    ) {
        val returnReference = FSPReference<Return>()
        components.add(
            FSPGroup(
                listOf(
                    FSPLambdaTask { uuid, _ ->
                        returnReference.register(uuid, `return`)
                    },
                    this
                ),
                returnReference
            )
        )
    }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun ((Type) -> Boolean).queue(
        `return`: Return
    ) { judge(this).queue(`return`) }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun Type.queue(
        `return`: Return
    ) { const(this).queue(`return`) }

    context(FSPTypedSwitchConstructDispatcher<Char, Return>)
    fun String.queue(
        `return`: Return
    ) { const(this).queue(`return`) }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Return, ComponentReturn> FSPComponent<Type, ComponentReturn>.queue(
        getter: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, ComponentReturn>) -> Return
    ) { TODO() }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun ((Type) -> Boolean).queue(
        getter: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, Type>) -> Return
    ) { judge(this).queue(getter) }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun Type.queue(
        getter: context(FSPReferenceDispatcher) (FSPValueDelegate<Type, List<Type>>) -> Return
    ) { const(this).queue(getter) }

    context(FSPTypedSwitchConstructDispatcher<Char, Return>)
    fun String.queue(
        getter: context(FSPReferenceDispatcher) (FSPValueDelegate<Char, List<Char>>) -> Return
    ) { const(this).queue(getter) }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Return> FSPComponent<Type, Return>.autoQueue() { this.queue(getter = { val `return` by it; `return`.value }) }

    context(FSPTypedSwitchConstructDispatcher<Type, List<Type>>)
    fun FSPComponent<Type, *>.autoQueue() { this.queue(getter = { val list by it.asList; list.value }) }

    context(FSPTypedSwitchConstructDispatcher<Char, String>)
    fun FSPComponent<Char, *>.autoQueue() { this.queue(getter = { val string by it.asString; string.value }) }

    context(FSPTypedSwitchConstructDispatcher<Type, Type>)
    fun <Type> Type.autoQueue() { this.queue { val type by it; type.value[0] } }

    context(FSPTypedSwitchConstructDispatcher<Type, List<Type>>)
    fun <Type> Type.autoQueue() { this.queue { val list by it.asList; list.value } }

    context(FSPTypedSwitchConstructDispatcher<Char, String>)
    fun Char.autoQueue() { this.queue { val string by it.asString; string.value } }

    context(FSPTypedSwitchConstructDispatcher<Char, List<Char>>)
    fun String.autoQueue() { this.queue { val list by it; list.value } }

    context(FSPTypedSwitchConstructDispatcher<Char, String>)
    fun String.autoQueue() { this.queue { val string by it.asString; string.value } }
}