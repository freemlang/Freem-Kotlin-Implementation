package org.freem.compiler.frontend.interfaces.field

interface PartitionField {
    val add: AddObject

    fun newCapture(): CaptureObject
}

