package freem.partition.analyzer.field

import freem.partition.analyzer.field.value.PartitionValueUsableField
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper

class DynamicField internal constructor(tasks: MutableList<AnyAnalyzeTaskWrapper>): PartitionValueUsableField() {
    val call = AnalyzeTaskRegistrationObject(tasks)
}