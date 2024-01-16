package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTaskQueue

class TypedCaseObject<ReturnsType>
internal constructor(private val taskQueue: PartitionAnalyzeTaskQueue) {
    infix fun returns(value: ReturnsType): AddObject {
        TODO("Not yet implemented")
    }
}
