plugins { `kotlin-dsl` }

repositories { gradlePluginPortal() }

dependencies { implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0") }

layout.buildDirectory = rootDir.parentFile.resolve(".builds").resolve(projectDir.name)
