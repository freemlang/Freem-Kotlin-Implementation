package org.freem.utils.range

import org.freem.utils.location.Location
import org.freem.utils.location.MutableLocation

interface Range {
    val start: Location
    val end: Location
}
interface MutableRange<R: Range>: Range {
    override val start: MutableLocation<*>
    override val end: MutableLocation<*>

    fun update(range: R)
}
