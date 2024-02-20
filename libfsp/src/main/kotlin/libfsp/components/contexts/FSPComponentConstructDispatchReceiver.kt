package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPReferenceContext
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentConstructDispatchReceiver<Type> internal constructor() {

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun const(content: Type): FSPConstant<Type> {
        return FSPConstant(listOf(content))
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun const(vararg content: Type): FSPConstant<Type> {
        return FSPConstant(content.toList())
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun const(content: String): FSPConstant<Char> {
        return FSPConstant(content.toList())
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun judge(condition: (Type) -> Boolean): FSPJudgement<Type> {
        return FSPJudgement(condition)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    @OptIn(ExperimentalContracts::class)
    fun group(constructor: FSPPatternInitializeDispatchReceiver<Type>.() -> Unit): FSPGroup<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = FSPPatternInitializeDispatchReceiver<Type>().apply(constructor).components
        check(components.isNotEmpty()) { "group is empty" }
        return FSPGroup(components)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    @OptIn(ExperimentalContracts::class)
    fun switch(constructor: FSPSwitchConstructDispatchReceiver<Type>.() -> Unit): FSPSwitch<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    fun <Return> switch(constructor: FSPTypedSwitchConstructDispatchReceiver<Type, Return>.() -> Unit): FSPTypedSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.optional(): FSPOptional<Type, Return> {
        return FSPOptional(this)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.repeat(times: Int): FSPStaticRepeat<Type, Return> {
        return FSPStaticRepeat(times, this)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.lazyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.LAZY)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Type, Return> FSPComponent<Type, Return>.greedyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> {
        return FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.GREEDY)
    }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Value> value(initializer: FSPReferenceContext.() -> Value): FSPValue<Value> { TODO() }

    context(FSPComponentConstructDispatchReceiver<Type>)
    fun <Variance> variance(initializer: FSPReferenceContext.() -> Variance): FSPVariance<Variance> { TODO() }

    context(FSPComponentConstructDispatchReceiver<Type>)
    val <Type> FSPComponent<Type, *>.valueAsList: FSPValue<List<Type>> get() = TODO()

    context(FSPComponentConstructDispatchReceiver<Type>)
    val <Type, Return> FSPComponent<Type, Return>.fspvalue: FSPValue<Return> get() = TODO()

    context(FSPComponentConstructDispatchReceiver<Type>)
    val FSPComponent<Char, *>.valueAsString: FSPValue<String> get() = TODO()
}
