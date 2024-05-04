package libfsp.defaultPattern.static_

import libfsp.ParseProcess
import libfsp.Pattern

class Static<Input>(val content: List<Input>): Pattern<Input>() {
    override fun scan(process: ParseProcess<Input>, trial: Int) = with(process) {
        TODO("Not yet implemented")
    }
}