package libfsp.defaultPattern.static_

import libfsp.ParseProcess
import libfsp.Pattern

class Repeat<Input>(val pattern: Pattern<Input>, val count: Int): Pattern<Input>() {
    override fun scan(process: ParseProcess<Input>, trial: Int) = with(process) {
        TODO("Not yet implemented")
    }
}