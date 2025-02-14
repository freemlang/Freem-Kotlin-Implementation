package tyfe.option

data class Some<out T>(val value: T) : Option<T>() {
    override fun clone(): Some<T> {
        return Some(value)
    }
}
