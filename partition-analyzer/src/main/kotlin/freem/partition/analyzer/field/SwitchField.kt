package freem.partition.analyzer.field

import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper

class SwitchField internal constructor(tasks: MutableList<AnyAnalyzeTaskWrapper>) {
    val case = AnalyzeTaskRegistrationObject(tasks)
}