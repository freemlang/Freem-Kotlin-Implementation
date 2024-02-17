package libfsp

import libfsp.components.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.reflect.KProperty

abstract class FSPPatternConstructContext<Type> internal constructor() {

    fun FSPPatternConstructContext<Type>.const(value: Type): Constant<Type> { TODO() }
    fun FSPPatternConstructContext<Type>.const(vararg value: Type): Constant<Type> { TODO() }
    fun FSPPatternConstructContext<Char>.const(value: String): Constant<Type> { TODO() }

    fun FSPPatternConstructContext<Type>.judge(condition: (Type) -> Boolean): Judgement<Type> { TODO() }

    @OptIn(ExperimentalContracts::class)
    fun FSPPatternConstructContext<Type>.group(constructor: FSPPatternContext<Type>.() -> Unit): Group<Type> {
        contract {
            callsInPlace(constructor, InvocationKind.EXACTLY_ONCE)
        }
        TODO()
    }

    fun FSPPatternConstructContext<Type>.lazyRepeat(times: Int, component: FSPComponent<Type>): LazyRepeat<Type> { TODO() }
    fun FSPPatternConstructContext<Type>.lazyRepeat(min: Int?, max: Int?, component: FSPComponent<Type>): LazyRepeat<Type> { TODO() }
    fun FSPPatternConstructContext<Type>.greedyRepeat(times: Int, component: FSPComponent<Type>): GreedyRepeat<Type> { TODO() }
    fun FSPPatternConstructContext<Type>.greedyRepeat(min: Int?, max: Int?, component: FSPComponent<Type>): GreedyRepeat<Type> { TODO() }

    val FSPComponent<Type>.value get() = PatternEntityValue()
    inner class PatternEntityValue internal constructor()
    val FSPPatternConstructContext<Char>.PatternEntityValue.asString: FSPPatternEntityValueDelegate<String> get() = TODO()
    val FSPPatternConstructContext<Char>.PatternEntityValue.asArray: FSPPatternEntityValueDelegate<Array<Type>> get() = TODO()

    class FSPPatternEntityValueDelegate<Type> {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Type { TODO() }
    }
}