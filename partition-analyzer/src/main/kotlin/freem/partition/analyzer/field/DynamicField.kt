package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

class DynamicField internal constructor(tasks: MutableList<AnalyzeTaskWrapper>) {
    val call = AnalyzeTaskRegistrationObject(tasks)
}
