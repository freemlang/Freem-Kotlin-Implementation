package libfsp.components.contexts

import libfsp.components.FSPComponent

class FSPTypedSwitchConstructDispatcher<Type, Return> internal constructor(components: MutableList<Pair<FSPComponent<Type, *>, Return>>): FSPComponentConstructDispatcher<Type>() {
    internal constructor(): this(mutableListOf())

    internal val components: List<Pair<FSPComponent<Type, *>, Return>> get() = components_.toList()
    private val components_: MutableList<Pair<FSPComponent<Type, *>, Return>> = components

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Return, ComponentReturn> FSPComponent<Type, ComponentReturn>.queue(`return`: Return): FSPValueDelegate<Type, ComponentReturn> { TODO() }

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Type> ((Type) -> Boolean).queue(`return`: Return): FSPValueDelegate<Type, Type> = judge(this).queue(`return`)

    context(FSPTypedSwitchConstructDispatcher<Type, Return>)
    fun <Type> Type.queue(`return`: Return): FSPValueDelegate<Type, List<Type>> = const(this).queue(`return`)

    context(FSPTypedSwitchConstructDispatcher<Char, Return>)
    fun String.queue(`return`: Return): FSPValueDelegate<Char, List<Char>> = const(this).queue(`return`)
}