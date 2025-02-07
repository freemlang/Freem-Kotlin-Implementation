package util.rusty.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import util.iterator.NoneIterator
import util.iterator.SingleIterator
import util.rusty.Panic
import util.rusty.option.None
import util.rusty.option.Option
import util.rusty.option.Some

@Suppress("NOTHING_TO_INLINE")
@OptIn(ExperimentalContracts::class)
sealed class Result<out T, out E> : Cloneable {
    inline fun isOk(): Boolean {
        contract {
            returns(true) implies (this@Result is Ok)
            returns(false) implies (this@Result is Err)
        }
        return this is Ok
    }

    inline fun isOkAnd(f: (T) -> Boolean): Boolean {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return this is Ok && f(result)
    }

    inline fun isErr(): Boolean {
        contract {
            returns(true) implies (this@Result is Err)
            returns(false) implies (this@Result is Ok)
        }
        return this is Err
    }

    inline fun isErrAnd(f: (E) -> Boolean): Boolean {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return this is Err && f(error)
    }

    inline fun expect(msg: String): T {
        return if (this is Ok) result else throw Panic(msg)
    }

    inline fun expect(f: (E) -> String): T {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this.isOk()) result else throw Panic(f(error))
    }

    inline fun expectErr(msg: String): E {
        return if (this is Err) error else throw Panic(msg)
    }

    inline fun expectErr(f: (T) -> String): E {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this.isErr()) error else throw Panic(f(result))
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
        return if (this.isOk()) Ok(op(result)) else Err(error)
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
        return if (this.isErr()) Err(op(error)) else Ok(result)
    }

    inline fun <F> mapErr(default: F, f: (E) -> F): F {
        contract { callsInPlace(f, InvocationKind.AT_MOST_ONCE) }
        return if (this.isErr()) f(error) else default
    }

    inline fun <F> mapErr(default: () -> F, f: (E) -> F): F {
        contract {
            callsInPlace(default, InvocationKind.AT_MOST_ONCE)
            callsInPlace(f, InvocationKind.AT_MOST_ONCE)
        }
        return if (this.isErr()) f(error) else default()
    }

    inline fun ok(): Option<T> {
        return if (this is Ok) Some(result) else None
    }

    inline fun err(): Option<E> {
        return if (this is Err) Some(error) else None
    }

    inline fun iter(): Iterator<T> {
        return if (this is Ok) SingleIterator(result) else NoneIterator
    }

    inline infix fun <U> and(res: Result<U, @UnsafeVariance E>): Result<U, E> {
        return if (this.isOk()) res else this
    }

    inline infix fun <U> and(op: () -> Result<U, @UnsafeVariance E>): Result<U, E> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return if (this.isOk()) op() else this
    }

    inline infix fun <F> or(res: Result<@UnsafeVariance T, F>): Result<T, F> {
        return if (this.isErr()) res else this
    }

    inline infix fun <F> or(op: () -> Result<@UnsafeVariance T, F>): Result<T, F> {
        contract { callsInPlace(op, InvocationKind.AT_MOST_ONCE) }
        return if (this.isErr()) op() else this
    }

    abstract override fun clone(): Result<T, E>
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Result<Option<T>, E>.transpose(): Option<Result<T, E>> {
    return when (this) {
        is Ok -> if (result is Some) Some(Ok(result.value)) else None
        is Err -> Some(Err(error))
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Result<Result<T, E>, E>.flatten(): Result<T, E> {
    return when (this) {
        is Ok -> result
        is Err -> Err(error)
    }
}

data class Ok<out T>(val result: T) : Result<T, Nothing>() {
    override fun clone(): Ok<T> {
        return Ok(result)
    }
}

data class Err<out E>(val error: E) : Result<Nothing, E>() {
    override fun clone(): Err<E> {
        return Err(error)
    }
}
