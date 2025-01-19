plugins {
    `kotlin-dsl`
    id("com.diffplug.spotless") version "7.0.2"
}

repositories { gradlePluginPortal() }

dependencies { implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0") }

spotless { kotlin { ktfmt("0.54").kotlinlangStyle() } }

layout.buildDirectory = rootDir.parentFile.resolve(".builds").resolve(projectDir.name)
