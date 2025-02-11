package parser

sealed class Context {
    internal data object InternalObject : Context()
}
