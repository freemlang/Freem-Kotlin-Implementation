package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

class DynamicField internal constructor(taskQueue: Queue<AnalyzeTaskWrapper>) {
    val call = AnalyzeTaskRegistrationObject(taskQueue)
}
