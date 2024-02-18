package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternContext
import libfsp.reference.FSPValue

class Package private constructor(

) {
    companion object: FSPTypedPattern<Char, Package>() {
        override fun FSPPatternContext<Char>.initialize(): FSPValue<Package> {
            TODO("Not yet implemented")
        }
    }
}