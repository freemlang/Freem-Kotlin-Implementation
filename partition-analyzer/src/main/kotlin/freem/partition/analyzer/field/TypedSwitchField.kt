package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTask
import java.util.Queue

class TypedSwitchField<ReturnsType> internal constructor(taskQueue: Queue<AnalyzeTask>) {
    val case = TypedAnalyzeTaskRegistrationObject<ReturnsType>(taskQueue)
}

