package libfsp

class Parser<Input, Return> {
    fun parse(input: Array<Input>): Return = parse(input.asList())
    fun parse(input: ArrayList<Input>): Return = parse(input)

    private fun parse(input: List<Input>): Return {
        val process = ParseProcess(input)
        TODO("Not yet implemented")
    }
}