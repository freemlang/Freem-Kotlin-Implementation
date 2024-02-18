package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPReferenceContext
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentContext<Type> internal constructor() {

    fun FSPComponentContext<Type>.const(value: Type): FSPConstant<Type>                    = FSPConstant(listOf(value))
    fun FSPComponentContext<Type>.const(vararg value: Type): FSPConstant<Type> {
        check(value.isNotEmpty()) { "value is empty" }
        return FSPConstant(value.toList())
    }
    fun FSPComponentContext<Char>.const(value: String): FSPConstant<Char> {
        check(value.isNotEmpty()) { "value is empty" }
        return FSPConstant(value.toList())
    }
    fun FSPComponentContext<Type>.judge(condition: (Type) -> Boolean): FSPJudgement<Type>  = FSPJudgement(condition)

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentContext<Type>.group(constructor: FSPPatternContext<Type>.() -> Unit): FSPGroup<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = FSPPatternContext<Type>().apply(constructor).components
        check(components.isNotEmpty()) { "group is empty" }
        return FSPGroup(components)
    }

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentContext<Type>.switch(constructor: FSPSwitchContext<Type>.() -> Unit): FSPSwitch<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    fun <Return> FSPComponentContext<Type>.switch(constructor: FSPTypedSwitchContext<Type, Return>.() -> Unit): FSPTypedSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    fun <Type, Return> FSPComponent<Type, Return>.optional(): FSPOptional<Type, Return>                         = FSPOptional(this)
    fun <Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>
            Component.repeat(times: Int): FSPStaticRepeat<Type, ComponentReturn, Component>                     = FSPStaticRepeat(times, this)
    fun <Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>
            Component.lazyRepeat(min: Int?, max: Int?): FSPLazyRepeat<Type, ComponentReturn, Component>         = FSPLazyRepeat(min, max, this)
    fun <Type, ComponentReturn, Component: FSPComponent<Type, ComponentReturn>>
            Component.greedyRepeat(min: Int?, max: Int?): FSPGreedyRepeat<Type, ComponentReturn, Component>     = FSPGreedyRepeat(min, max, this)

    fun <Value> FSPComponentContext<Type>.value(initializer: FSPReferenceContext.() -> Value): FSPValue<Value> { TODO() }
    fun <Variance> FSPComponentContext<Type>.variance(initializer: FSPReferenceContext.() -> Variance): FSPVariance<Variance> { TODO() }

    val <Type> FSPComponent<Type, *>.valueAsList: FSPValue<List<Type>> get() = TODO()
    val <Type, Return> FSPComponent<Type, Return>.fspvalue: FSPValue<Return> get() = TODO()
    val FSPComponent<Char, *>.valueAsString: FSPValue<String> get() = TODO()
}