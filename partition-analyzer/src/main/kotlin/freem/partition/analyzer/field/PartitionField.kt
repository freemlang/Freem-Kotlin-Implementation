package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTaskQueue
import java.util.*

class PartitionField {
    internal val taskQueue: PartitionAnalyzeTaskQueue = LinkedList()

    val add = AddObject()

    fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}

