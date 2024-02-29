package libfsp.components

import libfsp.reference.FSPUnit

internal data object FSPEmptyComponent: FSPComponent<Nothing, Unit>() {
    override fun FSPComponentDispatcher<Nothing>.run() = FSPUnit
}