package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.field.tasks.base.BaseTask
import freem.partition.analyzer.task.AnalyzeTask

internal sealed interface AdditionalTask: AnalyzeTask {
    val baseTask: BaseTask
    val contentTask: AnalyzeTask
}