package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.*

class SwitchField internal constructor(taskQueue: Queue<AnalyzeTaskWrapper>) {
    val case = AnalyzeTaskRegistrationObject(taskQueue)
}