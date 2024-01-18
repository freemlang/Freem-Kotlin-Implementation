package freem.partition.analyzer.field.tasks.base

import freem.partition.analyzer.field.SwitchField
import freem.partition.analyzer.field.tasks.additional.AdditionalTask
import freem.partition.analyzer.task.AnalyzeTask
import freem.partition.analyzer.task.AnalyzeTaskExecutionObject
import freem.partition.analyzer.task.AnalyzeTaskWrapper
import java.util.LinkedList
import java.util.Stack

internal class SwitchTask: BaseTask {
    private val tasks: List<AnalyzeTask>

    constructor(tasks: List<AnalyzeTask>) {
        this.tasks = tasks
    }

    constructor(field: SwitchField.() -> Unit) {
        val casesWrapper = LinkedList<AnalyzeTaskWrapper>()
        val switchField = SwitchField(casesWrapper)
        switchField.field()
        val cases = casesWrapper.map { it.task }
        val tasks = LinkedList<AnalyzeTask>()
        val staticStack = Stack<String>()
        for (task in cases) {
            when (task) {
                is CharStaticTask -> staticStack.add(task.char.toString())
                is StringStaticTask -> staticStack.add(task.string)
                else -> {
                    if (staticStack.size >= 2) {
                        TODO("trie not implemented")
                    }
                    staticStack.clear()
                }
            }
        }
        this.tasks = tasks
    }

    override fun AnalyzeTaskExecutionObject.run() {


    }
}