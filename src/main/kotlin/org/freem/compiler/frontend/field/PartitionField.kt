package org.freem.compiler.frontend.field

sealed interface PartitionField {
    val add: AddObject

    fun newCapture(): CaptureObject
}

internal class PartitionFieldImpl: PartitionField {
    override val add: AddObject = AddObjectImpl()

    override fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}