package tyfe.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import tyfe.Panic
import tyfe.internal.NoneIterator
import tyfe.internal.SomeIterator
import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some

@Suppress("NOTHING_TO_INLINE")
@OptIn(ExperimentalContracts::class)
sealed class Result<out T, out E> : Cloneable {
    inline fun expect(msg: String): T {
        contract { returns() implies (this@Result is Ok) }
        return if (this is Ok) result else throw Panic(msg)
    }

    inline fun expect(f: (E) -> String): T {
        contract {
            returns() implies (this@Result is Ok)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        when (this) {
            is Ok -> return result
            is Err -> throw Panic(f(error))
        }
    }

    inline fun expectErr(msg: String): E {
        contract { returns() implies (this@Result is Err) }
        return if (this is Err) error else throw Panic(msg)
    }

    inline fun expectErr(f: (T) -> String): E {
        contract {
            returns() implies (this@Result is Err)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        when (this) {
            is Err -> return error
            is Ok -> throw Panic(f(result))
        }
    }

    inline fun inspect(f: (T) -> Unit): Result<T, E> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        if (this is Ok) f(result)
        return this
    }

    inline fun inspectErr(f: (E) -> Unit): Result<T, E> {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        if (this is Err) f(error)
        return this
    }

    inline fun unwrap(): T {
        contract { returns() implies (this@Result is Ok) }
        return if (this is Ok) result else throw Panic("called `Result::unwrap()` on a `Err` value")
    }

    inline fun unwrap(default: @UnsafeVariance T): T {
        return if (this is Ok) result else default
    }

    inline fun unwrap(f: () -> @UnsafeVariance T): T {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Ok) result else f()
    }

    inline fun unwrapErr(): E {
        contract { returns() implies (this@Result is Err) }
        return if (this is Err) error
        else throw Panic("called `Result::unwrapErr()` on a `Ok` value")
    }

    inline fun unwrapErr(default: @UnsafeVariance E): E {
        return if (this is Err) error else default
    }

    inline fun unwrapErr(f: () -> @UnsafeVariance E): E {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Err) error else f()
    }

    inline fun <U> map(op: (T) -> U): Result<U, E> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return when (this) {
            is Ok -> Ok(op(result))
            is Err -> Err(error)
        }
    }

    inline fun <U> map(default: U, f: (T) -> U): U {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Ok) f(result) else default
    }

    inline fun <U> map(default: () -> U, f: (T) -> U): U {
        contract {
            callsInPlace(default, InvocationKind.AT_MOST_ONCE)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        return if (this is Ok) f(result) else default()
    }

    inline fun <F> mapErr(op: (E) -> F): Result<T, F> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return when (this) {
            is Err -> Err(op(error))
            is Ok -> Ok(result)
        }
    }

    inline fun <F> mapErr(default: F, f: (E) -> F): F {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this is Err) f(error) else default
    }

    inline fun <F> mapErr(default: () -> F, f: (E) -> F): F {
        contract {
            callsInPlace(default, InvocationKind.AT_MOST_ONCE)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        return if (this is Err) f(error) else default()
    }

    inline fun ok(): Option<T> {
        return if (this is Ok) Some(result) else None
    }

    inline fun err(): Option<E> {
        return if (this is Err) Some(error) else None
    }

    fun iter(): Iterator<T> {
        return if (this is Ok) SomeIterator(result) else NoneIterator
    }

    fun iterErr(): Iterator<E> {
        return if (this is Err) SomeIterator(error) else NoneIterator
    }

    inline infix fun <U> and(res: Result<U, @UnsafeVariance E>): Result<U, E> {
        return if (this !is Err) res else this
    }

    inline infix fun <U> and(op: () -> Result<U, @UnsafeVariance E>): Result<U, E> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return if (this !is Err) op() else this
    }

    inline infix fun <F> or(res: Result<@UnsafeVariance T, F>): Result<T, F> {
        return if (this !is Ok) res else this
    }

    inline infix fun <F> or(op: () -> Result<@UnsafeVariance T, F>): Result<T, F> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return if (this !is Ok) op() else this
    }

    abstract override fun clone(): Result<T, E>
}
