package typeful.result

import typeful.option.None
import typeful.option.Option
import typeful.option.Some

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Result<Option<T>, E>.transpose(): Option<Result<T, E>> {
    return when (this) {
        is Ok -> if (result is Some) Some(Ok(result.value)) else None
        is Err -> Some(Err(error))
    }
}
