package org.freem.compiler.partition.interfaces.field

interface PartitionField {
    val add: AddObject

    fun newCapture(): CaptureObject
}

