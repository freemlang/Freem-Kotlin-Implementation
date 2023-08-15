package org.freem.cli

import org.freem.tools.scope.checkElapsed
import org.freem.tools.scope.deferBlock

fun test() = deferBlock {
    checkElapsed()

}
