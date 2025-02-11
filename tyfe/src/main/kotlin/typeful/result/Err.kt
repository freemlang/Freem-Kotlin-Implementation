package typeful.result

data class Err<out E>(val error: E) : Result<Nothing, E>() {
    override fun clone(): Err<E> {
        return Err(error)
    }
}
