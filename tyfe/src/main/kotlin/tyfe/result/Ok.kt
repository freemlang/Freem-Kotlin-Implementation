package tyfe.result

data class Ok<out T>(val result: T) : Result<T, Nothing>() {
    override fun clone(): Ok<T> {
        return Ok(result)
    }
}
