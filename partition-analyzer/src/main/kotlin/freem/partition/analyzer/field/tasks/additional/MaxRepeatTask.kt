package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class MaxRepeatTask(private val baseTask: AnalyzeTask, private val max: Int): RepeatTask {

    init {
        if (max < 1) throw IllegalArgumentException("Max must be greater than 0.")
    }

    override fun AnalyzeTaskExecutionField.run(): Boolean {
        var count = 0
        while (count < max) {
            val indexBackup = index
            with (baseTask) {
                if (!run()) index = indexBackup
            }
            count++
        }
        return true
    }
}