package freem.partition.analyzer.task

import kotlin.reflect.KProperty

internal typealias AnyAnalyzeTaskWrapper = AnalyzeTaskWrapper<AnalyzeTask>

internal open class AnalyzeTaskWrapper<out TaskType: AnalyzeTask>(var task: @UnsafeVariance TaskType) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = task
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: @UnsafeVariance TaskType) {
        task = value
    }
}

internal fun <TaskType: AnalyzeTask> TaskType.wrap() = AnalyzeTaskWrapper(this)