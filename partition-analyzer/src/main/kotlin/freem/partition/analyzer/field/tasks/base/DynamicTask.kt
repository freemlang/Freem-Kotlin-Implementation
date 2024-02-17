package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.field.DynamicField
import freem.partition.analyzer.field.PartitionField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionField
import freem.partition.analyzer.task.AnyAnalyzeTaskWrapper
import java.util.*

internal class DynamicTask(private val field: DynamicField.() -> Unit): AnalyzeTask {
    override fun AnalyzeTaskExecutionField.run(): Boolean {
        val tasksWrapper = LinkedList<AnyAnalyzeTaskWrapper>()
        val dynamicField = DynamicField(tasksWrapper)
        dynamicField.field()
        val tasks = tasksWrapper.map { it.task }
        for (task in tasks) {
            with(task) {
                if(!run()) return false
            }
        }
        return true
    }
}