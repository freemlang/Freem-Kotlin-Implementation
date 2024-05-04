package libfsp

abstract class Component<Input> internal constructor() {
    internal abstract fun render(process: ParseProcess<Input>, trial: Int)
}