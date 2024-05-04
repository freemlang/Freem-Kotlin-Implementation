package libfsp

abstract class CustomComponent<Input>(): Component<Input>() {
    abstract fun render(trial: Int)

    override fun render(process: ParseProcess<Input>, trial: Int) {
        TODO("Not yet implemented")
    }
}