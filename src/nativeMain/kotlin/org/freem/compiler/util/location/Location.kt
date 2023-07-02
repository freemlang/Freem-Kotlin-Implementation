package org.freem.compiler.util.location

interface Location
interface MutableLocation<L: Location>: Location {
    fun update(location: L)
}