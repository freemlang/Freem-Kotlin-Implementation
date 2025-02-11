package typeful.option

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import typeful.Panic
import typeful.internal.NoneIterator
import typeful.internal.SomeIterator
import typeful.result.Err
import typeful.result.Ok
import typeful.result.Result

@Suppress("NOTHING_TO_INLINE")
@OptIn(ExperimentalContracts::class)
sealed class Option<out T> : Cloneable {
    inline fun isSome(): Boolean {
        contract {
            returns(true) implies (this@Option is Some)
            returns(false) implies (this@Option is None)
        }
        return this is Some
    }

    inline fun isSomeAnd(f: (T) -> Boolean): Boolean {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return this is Some && f(value)
    }

    inline fun isNone(): Boolean {
        contract {
            returns(true) implies (this@Option is None)
            returns(false) implies (this@Option is Some)
        }
        return this is None
    }

    inline fun isNoneOr(f: (T) -> Boolean): Boolean {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return this !is Some || f(value)
    }

    inline fun expect(msg: String): T {
        return if (this is Some) value else throw Panic(msg)
    }

    inline fun inspect(f: (T) -> Unit): Option<T> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        if (this is Some) f(value)
        return this
    }

    inline fun unwrap(): T {
        return if (this is Some) value
        else throw Panic("called `Option::unwrap()` on a `None` value")
    }

    inline fun unwrap(default: @UnsafeVariance T): T {
        return if (this is Some) value else default
    }

    inline fun unwrap(f: () -> @UnsafeVariance T): T {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) value else f()
    }

    inline fun <U> map(f: (T) -> U): Option<U> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) Some(f(value)) else None
    }

    inline fun <U> map(default: U, f: (T) -> U): U {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) f(value) else default
    }

    inline fun <U> map(default: () -> U, f: (T) -> U): U {
        contract {
            callsInPlace(default, InvocationKind.AT_MOST_ONCE)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        return if (this is Some) f(value) else default()
    }

    inline fun <E> okOr(err: E): Result<T, E> {
        return if (this is Some) Ok(value) else Err(err)
    }

    inline fun <E> okOr(err: () -> E): Result<T, E> {
        contract { callsInPlace(err, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) Ok(value) else Err(err())
    }

    fun iter(): Iterator<T> {
        return if (this is Some) SomeIterator(value) else NoneIterator
    }

    inline fun filter(predicate: (T) -> Boolean): Option<T> {
        contract { callsInPlace(predicate, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some && predicate(value)) Some(value) else None
    }

    inline infix fun <U> and(optb: Option<U>): Option<U> {
        return if (this is Some) optb else None
    }

    inline infix fun <U> and(f: () -> Option<U>): Option<U> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) f() else None
    }

    inline infix fun or(optb: Option<@UnsafeVariance T>): Option<T> {
        return if (this is Some) this else optb
    }

    inline infix fun or(f: () -> Option<@UnsafeVariance T>): Option<T> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some) this else f()
    }

    inline infix fun xor(optb: Option<@UnsafeVariance T>): Option<T> {
        return when (this) {
            is Some -> if (optb is None) this else None
            is None -> if (optb is Some) optb else None
        }
    }

    inline fun <U> zip(other: Option<U>): Option<Pair<@UnsafeVariance T, U>> {
        return if (this is Some && other is Some) Some(Pair(value, other.value)) else None
    }

    inline fun <U, R> zip(other: Option<U>, f: (T, U) -> R): Option<R> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Some && other is Some) Some(f(value, other.value)) else None
    }

    abstract override fun clone(): Option<T>
}
