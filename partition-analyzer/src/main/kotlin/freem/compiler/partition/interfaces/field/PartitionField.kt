package freem.compiler.partition.interfaces.field

interface PartitionField {
    val add: AddObject

    fun newCapture(): CaptureObject
}

