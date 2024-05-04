package libfsp.defaultPattern.static_

import libfsp.ParseProcess
import libfsp.Pattern

class Range<Input>(val pattern: Pattern<Input>, val min: Int, val max: Int): Pattern<Input>() {
    override fun scan(process: ParseProcess<Input>, trial: Int) = with(process) {
        TODO("Not yet implemented")
    }
}