package llvm

import org.gradle.api.Plugin
import org.gradle.api.Project

class LLVMPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create(
            "bundleReleaseFiles",
            LLVMPluginExtension::class.java
        )

        target.tasks.register("createDefFile") {

        }
    }
}