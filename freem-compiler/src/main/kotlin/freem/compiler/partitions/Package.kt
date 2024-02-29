package freem.compiler.partitions

import libfsp.components.contexts.FSPComponentListConstructDispatcher
import libfsp.reference.FSPValue

class Package private constructor(

) {
    companion object: FSPTypedComponent<Char, Package>() {
        override fun FSPComponentListConstructDispatcher<Char>.initialize(): FSPValue<Package> {
            TODO("Not yet implemented")
        }
    }
}