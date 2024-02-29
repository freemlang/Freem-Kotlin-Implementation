package libfsp

import libfsp.components.*

class FSPComponentExecutor<Type, Return>(private val component: FSPComponent<Type, Return>) {
    fun execute(input: Array<out Type>) = execute(input.asList())
    fun execute(input: ArrayList<Type>) = execute(input as List<Type>)

    private fun execute(input: List<Type>): Return {
        val dispatcher = FSPComponentDispatcher(input)
        return with(component) { dispatcher.run() }
    }
}
