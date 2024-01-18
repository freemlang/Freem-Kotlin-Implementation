package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

class SwitchField internal constructor(tasks: MutableList<AnalyzeTaskWrapper>) {
    val case = AnalyzeTaskRegistrationObject(tasks)
}