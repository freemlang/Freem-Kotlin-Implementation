package libfsp

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.reflect.KProperty

abstract class FSPPattern<Type>: FSPEntity<Type>() {
    protected abstract fun FSPPatternField<Type>.initialize()

    private val components: List<FSPComponent<Type>> by lazy {
        val components = mutableListOf<FSPComponent<Type>>()
        val field = FSPPatternField(components)
        field.initialize()
        return@lazy components
    }

    override fun iterator(): Iterator<FSPComponent<Type>> = components.iterator()
}

abstract class FSPEntity<Type> internal constructor() {
    internal abstract fun iterator(): Iterator<FSPComponent<Type>>
}

internal interface FSPComponent<Type> {
    fun FSPTaskExecutionSystemField<Type>.run()
}

internal class FSPPatternExecutionSystem<Type>
internal class FSPTaskExecutionSystemField<Type> {

}


class FSPPatternField<Type> internal constructor(components: MutableList<FSPComponent<Type>>): FSPPatternConstructField<Type>() {
    var next: FSPEntity<Type>
        get() = TODO("current task")
        set(task) {

        }
}

abstract class FSPPatternConstructField<Type> internal constructor() {

    fun FSPPatternConstructField<Type>.const(value: Type): Constant<Type> { TODO() }
    fun FSPPatternConstructField<Type>.const(vararg value: Type): Constant<Type> { TODO() }
    fun FSPPatternConstructField<Char>.const(value: String): Constant<Type> { TODO() }

    fun FSPPatternConstructField<Type>.judge(condition: (Type) -> Boolean): Judgement<Type> { TODO() }

    @OptIn(ExperimentalContracts::class)
    fun FSPPatternConstructField<Type>.group(constructor: FSPPatternField<Type>.() -> Unit): Group<Type> {
        contract {
            callsInPlace(constructor, InvocationKind.EXACTLY_ONCE)
        }
        TODO()
    }

    fun FSPPatternConstructField<Type>.lazyRepeat(times: Int, component: FSPEntity<Type>): LazyRepeat<Type> { TODO() }
    fun FSPPatternConstructField<Type>.lazyRepeat(min: Int?, max: Int?, component: FSPEntity<Type>): LazyRepeat<Type> { TODO() }
    fun FSPPatternConstructField<Type>.greedyRepeat(times: Int, component: FSPEntity<Type>): GreedyRepeat<Type> { TODO() }
    fun FSPPatternConstructField<Type>.greedyRepeat(min: Int?, max: Int?, component: FSPEntity<Type>): GreedyRepeat<Type> { TODO() }

    val FSPEntity<Type>.value get() = PatternEntityValue()
    inner class PatternEntityValue internal constructor()
    val FSPPatternConstructField<Char>.PatternEntityValue.asString: FSPPatternEntityValueDelegate<String> get() = TODO()
    val FSPPatternConstructField<Char>.PatternEntityValue.asArray: FSPPatternEntityValueDelegate<Array<Type>> get() = TODO()

    class FSPPatternEntityValueDelegate<Type> {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Type { TODO() }
    }
}

data class Constant<Type>(val content: Array<Type>): FSPEntity<Type>()
data class Judgement<Type>(val condition: (Type) -> Boolean): FSPEntity<Type>()
data class Group<Type>(val actions: List<FSPEntity<Type>>): FSPEntity<Type>()
sealed class Repeat<Type>: FSPEntity<Type>() {
    abstract val min: Int?
    abstract val max: Int?
}
data class LazyRepeat<Type>(override val min: Int?, override val max: Int?): Repeat<Type>()
data class GreedyRepeat<Type>(override val min: Int?, override val max: Int?): Repeat<Type>()

fun FSPPatternField<Char>.test() {
    next = lazyRepeat(null, null, group {
        next = const("a")
    })
    val a by next.value.asString
    next = const("test")
}
