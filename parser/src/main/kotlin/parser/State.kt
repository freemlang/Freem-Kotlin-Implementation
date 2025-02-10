package parser

sealed interface State<out Input, out Output> {
    data object ACCEPT : State<Nothing, Nothing>

    data class COMPLETE<out Output>(internal val output: Output) : State<Nothing, Output>

    class REQUEST<out Input, out Output>
    private constructor(
        internal val requestArray: Array<out Parser<@UnsafeVariance Input, @UnsafeVariance Output>>
    ) : State<Input, Output> {
        companion object {
            operator fun <Input, Output> invoke(
                vararg requests: Parser<@UnsafeVariance Input, @UnsafeVariance Output>
            ): REQUEST<Input, Output> {
                return REQUEST(requests)
            }
        }
    }
}
