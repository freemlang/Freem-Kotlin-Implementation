package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPReferenceDispatcher
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentConstructDispatcher<Type> internal constructor() {
    context(FSPComponentConstructDispatcher<Type>)
    fun const(content: Type): FSPConstant<Type> {
        return FSPConstant(listOf(content))
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun const(vararg content: Type): FSPConstant<Type> {
        return FSPConstant(content.toList())
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun const(content: String): FSPConstant<Char> {
        return FSPConstant(content.toList())
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun judge(condition: (Type) -> Boolean): FSPJudgement<Type> {
        return FSPJudgement(condition)
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    fun group(constructor: context(FSPPatternInitializeDispatcher<Type>) () -> Unit): FSPGroup<Type, List<Type>> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = FSPPatternInitializeDispatcher(constructor)
        check(components.isNotEmpty()) { "group is empty" }
        return FSPGroup(components)
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("valueGroup")
    fun <Return> group(condition: context(FSPPatternInitializeDispatcher<Type>) () -> FSPValue<Return>): FSPGroup<Type, Return> {
        contract { callsInPlace(condition, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    fun switch(constructor: context(FSPPatternInitializeDispatcher<Type>) () -> Unit): FSPSwitch<Type, List<Type>> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    context(FSPComponentConstructDispatcher<Type>)
    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("valueSwitch")
    fun <Return> switch(constructor: context(FSPTypedSwitchConstructDispatcher<Type, Return>) () -> Unit): FSPSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.optional(): FSPOptional<Type, Return> {
        return FSPOptional(this)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.repeat(times: Int): FSPStaticRepeat<Type, Return> {
        return FSPStaticRepeat(times, this)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.lazyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.LAZY)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.greedyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.GREEDY)
    }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Value> value(initializer: context(FSPReferenceDispatcher) () -> Value): FSPValue<Value> { TODO() }

    context(FSPComponentConstructDispatcher<Type>)
    fun <Variance> variance(initializer: context(FSPReferenceDispatcher) () -> Variance): FSPVariance<Variance> { TODO() }
}
