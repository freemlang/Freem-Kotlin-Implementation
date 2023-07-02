package org.freem.compiler.util.range

import org.freem.compiler.util.location.Location
import org.freem.compiler.util.location.MutableLocation

interface Range {
    val start: Location
    val end: Location
}
interface MutableRange<R: Range>: Range {
    override val start: MutableLocation<*>
    override val end: MutableLocation<*>

    fun update(range: R)
}
