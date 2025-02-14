package tyfe.result

@Suppress("NOTHING_TO_INLINE")
inline fun <T, E> Result<Result<T, E>, E>.flatten(): Result<T, E> {
    return when (this) {
        is Ok -> result
        is Err -> Err(error)
    }
}
