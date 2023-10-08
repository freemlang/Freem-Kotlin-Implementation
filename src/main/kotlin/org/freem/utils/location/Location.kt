package org.freem.utils.location

interface Location
interface MutableLocation<L: Location>: Location {
    fun update(location: L)
}