package lagacyparser

sealed interface State<out Input, out Output> {
    data object ACCEPT : State<Nothing, Nothing>

    data class COMPLETE<out Output>(internal val output: Output) : State<Nothing, Output>

    class REQUEST<out Input, out Output>(
        internal val requests: Array<out Parser<@UnsafeVariance Input, @UnsafeVariance Output>>
    ) : State<Input, Output> {
        init {
            require(requests.isNotEmpty()) { "The number of requests cannot be less than 1" }
        }
    }
}
