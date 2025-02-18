package lagacyparser

data class ParseResult<out Output>(val output: Output, val isFulfilled: Boolean)
