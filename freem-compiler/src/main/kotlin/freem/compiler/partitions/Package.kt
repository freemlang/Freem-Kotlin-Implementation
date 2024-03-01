package freem.compiler.partitions

import libfsp.components.contexts.FSPEntityConstructDispatcher
import libfsp.reference.FSPValue

class Package private constructor(

) {
    companion object: FSPTypedComponent<Char, Package>() {
        override fun FSPEntityConstructDispatcher<Char>.initialize(): FSPValue<Package> {
            TODO("Not yet implemented")
        }
    }
}