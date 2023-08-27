package org.llvm

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class LLVMDefaultTask: DefaultTask() {
    @TaskAction
    fun run() {
        println("testdwmaodm")
    }
}