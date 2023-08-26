package llvm

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property

interface LLVMPluginExtension {
    val appVersion: Property<String>
    val outputDirectory: DirectoryProperty
}