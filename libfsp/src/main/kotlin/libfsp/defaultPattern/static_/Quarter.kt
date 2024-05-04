package libfsp.defaultPattern.static_

import libfsp.ParseProcess
import libfsp.Pattern

class Quarter<Input>(patterns: List<Pattern<Input>>): Pattern<Input>() {
    override fun scan(process: ParseProcess<Input>, trial: Int) = with(process) {
        TODO("Not yet implemented")
    }
}