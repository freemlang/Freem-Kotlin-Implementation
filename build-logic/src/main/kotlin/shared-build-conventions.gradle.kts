plugins { kotlin("jvm") }

repositories { gradlePluginPortal() }

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

tasks.compileKotlin.configure { compilerOptions { freeCompilerArgs.add("-Xcontext-receivers") } }

layout.buildDirectory = rootDir.resolve(".builds").resolve(projectDir.name)
