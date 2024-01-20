package freem.partition.analyzer.field.tasks.additional

import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField

internal class RangeRepeatTask(private val baseTask: AnalyzeTask, private val range: IntRange): RepeatTask {

    init {
        if (range.first < 0 && range.last < 0) throw IllegalArgumentException("Range must be greater than or equal to 0.")
    }

    override fun AnalyzeTaskExecutionField.run(): Boolean {
        TODO("Not yet implemented")
    }
}