package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTask
import java.util.Queue

class TypedSwitchField<ReturnsType> internal constructor(registrationObject: AnalyzeTaskRegistrationObject, tasks: MutableList<AnalyzeTask>) {
    val case = TypedAnalyzeTaskRegistrationObject<ReturnsType>(registrationObject, tasks)
}

