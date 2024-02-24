package freem.compiler.partitions

import libfsp.components.FSPTypedPattern
import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class Package private constructor(

) {
    companion object: FSPTypedPattern<Char, Package>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Package> {
            TODO("Not yet implemented")
        }
    }
}