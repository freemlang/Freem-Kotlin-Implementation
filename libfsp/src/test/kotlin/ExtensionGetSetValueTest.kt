import kotlin.reflect.KProperty

fun main() {
    with(DelegateScope) {
        val testDelegate = TestDelegate(10)
        val value by testDelegate
        println(value)
    }
}

object DelegateScope {
    operator fun TestDelegate.getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }
}

class TestDelegate(val value: Int)