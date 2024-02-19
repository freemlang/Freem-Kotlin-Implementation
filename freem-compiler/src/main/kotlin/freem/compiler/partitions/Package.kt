package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPPatternInitializeContext
import libfsp.reference.FSPValue

class Package private constructor(

) {
    companion object: FSPTypedPattern<Char, Package>() {
        override fun FSPPatternInitializeContext<Char>.initialize(): FSPValue<Package> {
            TODO("Not yet implemented")
        }
    }
}