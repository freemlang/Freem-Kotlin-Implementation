package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTask
import java.util.*

class TypedAnalyzeTaskRegistrationObject<ReturnsType>
internal constructor(private val taskQueue: Queue<AnalyzeTask>) {
    infix fun returns(value: ReturnsType): AnalyzeTaskRegistrationObject {
        TODO("Not yet implemented")
    }
}
