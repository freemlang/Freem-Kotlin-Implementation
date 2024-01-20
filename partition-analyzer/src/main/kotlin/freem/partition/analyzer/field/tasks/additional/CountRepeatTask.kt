package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class CountRepeatTask(private val baseTask: AnalyzeTask, private val count: Int): RepeatTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {
        repeat(count) {
            with(baseTask) {
                if (!run()) return false
            }
        }
        return true
    }
}