package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnalyzeTask
import java.util.*

class SwitchField internal constructor(taskQueue: Queue<AnalyzeTask>) {
    val case = AnalyzeTaskRegistrationObject(taskQueue)
}