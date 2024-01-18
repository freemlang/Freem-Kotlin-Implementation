package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.field.DynamicField
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.LinkedList

internal class DynamicTask(private val field: DynamicField.() -> Unit): BaseTask {
    override fun AnalyzeTaskExecutionObject.run() {
        val tasksWrapper = LinkedList<AnalyzeTaskWrapper>()
        val dynamicField = DynamicField(tasksWrapper)
        dynamicField.field()
        val tasks = tasksWrapper.map { it.task }
        for (task in tasks) {
            with(task) {
                run()
            }
        }
    }
}