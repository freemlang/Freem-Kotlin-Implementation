package tyfe.result

import tyfe.option.None
import tyfe.option.Option
import tyfe.option.Some

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Result<Option<T>, E>.transpose(): Option<Result<T, E>> {
    return when (this) {
        is Ok -> if (result is Some) Some(Ok(result.value)) else None
        is Err -> Some(Err(error))
    }
}
