package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class OptionalTask(private val baseTask: AnalyzeTask): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {
        val indexBackup = index
        with(baseTask) {
            if (!run()) index = indexBackup
        }
        return true
    }
}