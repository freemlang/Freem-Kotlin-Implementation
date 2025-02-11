package typeful.option

import typeful.result.Err
import typeful.result.Ok
import typeful.result.Result

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Option<Result<T, E>>.transpose(): Result<Option<T>, E> {
    if (this !is Some) return Ok(None)
    return when (value) {
        is Ok -> Ok(Some(value.result))
        is Err -> Err(value.error)
    }
}
