package libfsp

import libfsp.components.FSPComponent

class FSPPatternContext<Type> internal constructor(components: MutableList<FSPComponent<Type>>): FSPPatternConstructContext<Type>() {
    var next: FSPComponent<Type>
        get() = TODO("current task")
        set(task) {

        }
}