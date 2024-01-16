package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTaskQueue

class TypedSwitchField<ReturnsType> internal constructor(taskQueue: PartitionAnalyzeTaskQueue) {
    val case = TypedCaseObject<ReturnsType>(taskQueue)
}

