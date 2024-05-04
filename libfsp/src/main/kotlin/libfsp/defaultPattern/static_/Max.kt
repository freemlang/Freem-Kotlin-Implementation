package libfsp.defaultPattern.static_

import libfsp.ParseProcess
import libfsp.Pattern

class Max<Input>(val pattern: Pattern<Input>, val max: Int): Pattern<Input>() {
    init {

    }

    override fun scan(process: ParseProcess<Input>, trial: Int) = with(process) {
        TODO("Not yet implemented")
    }
}