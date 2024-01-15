package freem.compiler.partition.implement.field

import freem.compiler.partition.interfaces.field.AddObject
import freem.compiler.partition.interfaces.field.CaptureObject
import freem.compiler.partition.interfaces.field.PartitionField
import java.util.*

internal class PartitionFieldImpl: PartitionField {
    val addObject = AddObjectImpl()
    val queue: Queue<Iterator<Char>.() -> Unit> = addObject.queue

    override val add: AddObject = addObject

    override fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}