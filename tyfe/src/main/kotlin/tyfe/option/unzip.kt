package tyfe.option

@Suppress("NOTHING_TO_INLINE")
inline fun <T, U> Option<Pair<T, U>>.unzip(): Pair<Option<T>, Option<U>> {
    return if (this is Some) Pair(Some(value.first), Some(value.second)) else Pair(None, None)
}
