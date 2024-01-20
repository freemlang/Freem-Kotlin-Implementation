package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class MinRepeatTask(private val baseTask: AnalyzeTask, private val min: Int): RepeatTask {

    init {
        if (min < 0) throw IllegalArgumentException("Min must be greater than or equal to 0.")
    }

    override fun AnalyzeTaskExecutionField.run(): Boolean {
        var count = 0
        while (true) {
            with(baseTask) {
                if (!backup { run() } && count < min) return false
            }
            count++
        }
    }
}