package libfsp.components

internal sealed interface FSPTask<Type>: FSPComponent<Type, Nothing> {
    fun run()
}