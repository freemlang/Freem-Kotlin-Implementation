package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPValue
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentConstructDispatcher<Type> internal constructor() {

    context(FSPComponentConstructDispatcher<Type>)
    fun const(contents: List<Type>): FSPConstant<Type> {
        check(contents.isNotEmpty()) { "value is empty" }
        return FSPConstant(contents)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun const(vararg content: Type): FSPConstant<Type> {
        return const(content.toList())
    }

    context(FSPComponentConstructDispatcher<Char>)
    fun const(content: String): FSPConstant<Char> {
        return const(content.toList())
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun judge(condition: (Type) -> Boolean): FSPJudgement<Type> {
        return FSPJudgement(condition)
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    fun group(constructor: context(FSPEntityConstructDispatcher<Type>) () -> Unit): FSPGroup<Type, List<Type>> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = mutableListOf<FSPComponent<Type, *>>()
        val dispatcher = FSPEntityConstructDispatcher(components)
        constructor(dispatcher)
        val fixedDispatcher = FSPEntityConstructDispatcher.combineConsecutiveConstants(components)
        components.clear()
        return FSPGroup(fixedDispatcher)
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("valueGroup")
    fun <Return> group(constructor: context(FSPEntityConstructDispatcher<Type>) () -> FSPValue<Return>): FSPGroup<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = mutableListOf<FSPComponent<Type, *>>()
        val dispatcher = FSPEntityConstructDispatcher(components)
        val returnedValue = constructor(dispatcher)
        val fixedDispatcher = FSPEntityConstructDispatcher.combineConsecutiveConstants(components)
        components.clear()
        return FSPGroup(fixedDispatcher)
    }

    fun <Type, Return> optimizeSwitch(components: List<FSPComponent<Type, *>>) {
        /*
        val componentBuffer: MutableList<FSPComponent<Type, *>> = mutableListOf()
        val consecutiveComponentBuffer: MutableList<Pair<FSPComponent<Type, *>, FSPValue<Return>>> = mutableListOf()
        var beforeComponentClass: Class<*>? = null
        for (component in components) {
            val currentComponentClass = component::class.java
            if (currentComponentClass != beforeComponentClass) {
                when (consecutiveComponentBuffer.size) {
                    0 -> {}
                    1 -> componentBuffer.add(consecutiveComponentBuffer[0])
                    else -> when (consecutiveComponentBuffer[0]) {
                        is FSPConstant -> {
                            @Suppress("UNCHECKED_CAST") (consecutiveComponentBuffer as List<FSPConstant<Type>>)
                            val trie = consecutiveComponentBuffer.map { it.content }.toTrie()

                        }
                        is FSPGroup -> TODO()
                        is FSPJudgement<*> -> TODO()
                        is FSPOptional -> TODO()
                        is FSPTypedComponent -> TODO()
                        is FSPUnitComponent -> TODO()
                        is FSPDynamicRepeat<*, *> -> TODO()
                        is FSPStaticRepeat<*, *> -> TODO()
                        is FSPSwitch -> TODO()
                        is FSPLambdaTask -> TODO()
                    }
                }
                consecutiveComponentBuffer.clear()
            }
            consecutiveComponentBuffer.add(component)
            beforeComponentClass = currentComponentClass
        }
        val result = componentBuffer.toList()
        componentBuffer.clear()
        return result
        */
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    fun switch(constructor: context(FSPEntityConstructDispatcher<Type>) () -> Unit): FSPSwitch<Type, List<Type>> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = mutableListOf<FSPComponent<Type, *>>()
        val dispatcher = FSPEntityConstructDispatcher(components)
        constructor(dispatcher)
        return FSPSwitch(components.map { it to (null as FSPValue<List<Type>> /*TODO: component's return value*/) })
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("valueSwitch")
    fun <Return> switch(constructor: context(FSPTypedSwitchConstructDispatcher<Type, Return>) () -> Unit): FSPSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = mutableListOf<Pair<FSPComponent<Type, *>, FSPValue<Return>>>()
        val dispatcher = FSPTypedSwitchConstructDispatcher(components)
        constructor(dispatcher)
        return FSPSwitch(components)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.optional(): FSPOptional<Type, Return> {
        return FSPOptional(
            if (this is FSPOptional<Type, *>)
                @Suppress("UNCHECKED_CAST") (component as FSPComponent<Type, Return>)
            else this
        )
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.repeat(times: Int): FSPStaticRepeat<Type, Return> {
        return FSPStaticRepeat(times, this)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.lazyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.LAZY)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Return> FSPComponent<Type, Return>.greedyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.GREEDY)
    }
}
