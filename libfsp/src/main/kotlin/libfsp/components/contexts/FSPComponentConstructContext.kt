package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPReferenceContext
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentConstructContext<Type> internal constructor() {

    fun FSPComponentConstructContext<Type>.const(content: Type): FSPConstant<Type>                    = FSPConstant(listOf(content))
    fun FSPComponentConstructContext<Type>.const(vararg content: Type): FSPConstant<Type> {
        return FSPConstant(content.toList())
    }
    fun FSPComponentConstructContext<Char>.const(content: String): FSPConstant<Char> {
        return FSPConstant(content.toList())
    }
    fun FSPComponentConstructContext<Type>.judge(condition: (Type) -> Boolean): FSPJudgement<Type>  = FSPJudgement(condition)

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentConstructContext<Type>.group(constructor: FSPPatternInitializeContext<Type>.() -> Unit): FSPGroup<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        val components = FSPPatternInitializeContext<Type>().apply(constructor).components
        check(components.isNotEmpty()) { "group is empty" }
        return FSPGroup(components)
    }

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentConstructContext<Type>.switch(constructor: FSPSwitchConstructContext<Type>.() -> Unit): FSPSwitch<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    fun <Return> FSPComponentConstructContext<Type>.switch(constructor: FSPTypedSwitchConstructContext<Type, Return>.() -> Unit): FSPTypedSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    fun <Type, Return> FSPComponent<Type, Return>.optional(): FSPOptional<Type, Return>                              = FSPOptional(this)
    fun <Type, Return> FSPComponent<Type, Return>.repeat(times: Int): FSPStaticRepeat<Type, Return>                  = FSPStaticRepeat(times, this)
    fun <Type, Return> FSPComponent<Type, Return>.lazyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return>   = FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.LAZY)
    fun <Type, Return> FSPComponent<Type, Return>.greedyRepeat(min: Int?, max: Int?): FSPDynamicRepeat<Type, Return> = FSPDynamicRepeat(min, max, this, FSPDynamicRepeatKind.GREEDY)

    fun <Value> FSPComponentConstructContext<Type>.value(initializer: FSPReferenceContext.() -> Value): FSPValue<Value> { TODO() }
    fun <Variance> FSPComponentConstructContext<Type>.variance(initializer: FSPReferenceContext.() -> Variance): FSPVariance<Variance> { TODO() }

    val <Type> FSPComponent<Type, *>.valueAsList: FSPValue<List<Type>> get() = TODO()
    val <Type, Return> FSPComponent<Type, Return>.fspvalue: FSPValue<Return> get() = TODO()
    val FSPComponent<Char, *>.valueAsString: FSPValue<String> get() = TODO()
}

context(FSPComponentConstructContext<Char>)
fun a() {

}