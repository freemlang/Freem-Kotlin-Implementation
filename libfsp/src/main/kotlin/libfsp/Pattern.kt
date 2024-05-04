package libfsp

abstract class Pattern<Input> {
    internal abstract fun scan(process: ParseProcess<Input>, trial: Int)
}