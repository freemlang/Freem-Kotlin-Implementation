package org.freem.compiler.frontend.implement.field

import org.freem.compiler.frontend.interfaces.field.AddObject
import org.freem.compiler.frontend.interfaces.field.CaptureObject
import org.freem.compiler.frontend.interfaces.field.PartitionField
import java.util.*

internal class PartitionFieldImpl: PartitionField {
    val addObject = AddObjectImpl()
    val queue: Queue<Iterator<Char>.() -> Unit> = addObject.queue

    override val add: AddObject = addObject

    override fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}