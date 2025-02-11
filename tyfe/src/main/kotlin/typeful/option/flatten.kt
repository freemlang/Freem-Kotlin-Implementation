package typeful.option

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Option<Option<T>>.flatten(): Option<T> {
    return if (this is Some) value else None
}
