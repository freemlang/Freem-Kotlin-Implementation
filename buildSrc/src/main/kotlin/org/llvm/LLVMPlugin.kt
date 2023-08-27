package org.llvm

import org.gradle.api.Action
import org.llvm.extensions.LLVMExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
//import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

class LLVMPlugin: Plugin<Project> {
    override fun apply(project: Project) {

        project.afterEvaluate {

        }

        with(project) {
            val llvm = extensions.create("llvm", LLVMExtension::class.java)
            println("llvmVersion: ${llvm.llvmVersion}")

            tasks.register("createDefFile") {
                group = "llvm"
                doLast {
                    println("llvmVersion: ${llvm.llvmVersion}")
                }
            }
        }
    }

    //fun KotlinNativeTarget.llvm() {

    //}
}