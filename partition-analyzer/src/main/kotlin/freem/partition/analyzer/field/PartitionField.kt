package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTaskQueue

class PartitionField internal constructor(taskQueue: PartitionAnalyzeTaskQueue) {
    val add = AddObject(taskQueue)

    fun newCapture(): CaptureObject {
        TODO("Not yet implemented")
    }
}

