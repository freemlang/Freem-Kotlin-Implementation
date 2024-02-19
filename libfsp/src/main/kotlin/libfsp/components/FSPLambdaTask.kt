package libfsp.components

internal class FSPLambdaTask<Type>(private val task: () -> Unit): FSPTask<Type> {
    override fun run() = task()
}