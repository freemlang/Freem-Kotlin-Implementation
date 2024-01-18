package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTask
import java.util.*

class TypedAnalyzeTaskRegistrationObject<ReturnsType> internal constructor(
    private val registrationObject: AnalyzeTaskRegistrationObject,
    private val tasks: MutableList<AnalyzeTask>
) {
    infix fun returns(value: ReturnsType): AnalyzeTaskRegistrationObject {
        TODO("Not yet implemented")

        return registrationObject
    }
}
