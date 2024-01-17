package freem.partition.analyzer.task

import kotlin.reflect.KProperty

internal data class AnalyzeTaskWrapper(var task: AnalyzeTask) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = task
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: AnalyzeTask) {
        task = value
    }
}
internal fun AnalyzeTask.wrap() = AnalyzeTaskWrapper(this)