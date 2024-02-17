package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class CaptureStartTask(private val captureObject: CaptureObject): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {

        return true
    }
}