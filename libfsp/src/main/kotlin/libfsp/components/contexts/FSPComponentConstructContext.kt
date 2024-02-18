package libfsp.components.contexts

import libfsp.components.*
import libfsp.reference.FSPReferenceContext
import libfsp.reference.FSPValue
import libfsp.reference.FSPVariance
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class FSPComponentConstructContext<Type> internal constructor() {

    fun FSPComponentConstructContext<Type>.const(value: Type): FSPConstant<Type>                    = FSPConstant(listOf(value))
    fun FSPComponentConstructContext<Type>.const(vararg value: Type): FSPConstant<Type>             = FSPConstant(value.toList())
    fun FSPComponentConstructContext<Char>.const(value: String): FSPConstant<Char>                  = FSPConstant(value.toList())
    fun FSPComponentConstructContext<Type>.judge(condition: (Type) -> Boolean): FSPJudgement<Type>  = FSPJudgement(condition)

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentConstructContext<Type>.group(constructor: FSPPatternContext<Type>.() -> Unit): FSPGroup<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        return FSPGroup(FSPPatternContext<Type>().apply(constructor).components)
    }

    @OptIn(ExperimentalContracts::class)
    fun FSPComponentConstructContext<Type>.switch(constructor: FSPSwitchContext<Type>.() -> Unit): FSPSwitch<Type> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    @OptIn(ExperimentalContracts::class)
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("typedSwitch")
    fun <Return> FSPComponentConstructContext<Type>.switch(constructor: FSPTypedSwitchContext<Type, Return>.() -> Unit): FSPTypedSwitch<Type, Return> {
        contract { callsInPlace(constructor, InvocationKind.EXACTLY_ONCE) }
        TODO()
    }

    fun FSPComponent<Type>.optional(): FSPOptional<Type>                                = FSPOptional(this)
    fun FSPComponent<Type>.repeat(times: Int): FSPStaticRepeat<Type>                    = FSPStaticRepeat(times, this)
    fun FSPComponent<Type>.lazyRepeat(min: Int?, max: Int?): FSPLazyRepeat<Type>        = FSPLazyRepeat(min, max, this)
    fun FSPComponent<Type>.greedyRepeat(min: Int?, max: Int?): FSPGreedyRepeat<Type>    = FSPGreedyRepeat(min, max, this)

    fun <Value> FSPComponentConstructContext<Type>.value(initializer: FSPReferenceContext.() -> Value): FSPValue<Value> { TODO() }
    fun <Variance> FSPComponentConstructContext<Type>.variance(initializer: FSPReferenceContext.() -> Variance): FSPVariance<Variance> { TODO() }

    val FSPComponent<Type>.asArray: FSPValue<Array<Type>> get() = TODO()
    val FSPComponent<Char>.asString: FSPValue<String> get() = TODO()
    val <Return> FSPTypedSwitch<Type, Return>.asCaseReturn: FSPValue<Return> get() = TODO()
}