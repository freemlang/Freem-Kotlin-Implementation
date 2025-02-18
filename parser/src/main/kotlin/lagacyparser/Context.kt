package lagacyparser

@Suppress("NOTHING_TO_INLINE")
sealed class Context {
    internal data object Instance : Context()

    inline fun accept(): State.ACCEPT {
        return State.ACCEPT
    }

    inline fun <Output> complete(output: Output): State.COMPLETE<Output> {
        return State.COMPLETE(output)
    }

    inline fun <Input, Output> request(
        vararg requests: Parser<Input, Output>
    ): State.REQUEST<Input, Output> {
        return State.REQUEST(requests)
    }
}
