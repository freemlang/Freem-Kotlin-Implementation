import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

plugins {
    kotlin("multiplatform") version "1.9.0-RC"
    kotlin("plugin.serialization") version "1.9.0-RC"
}

group = "org.freem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs: String = System.getProperty("os.name")
    val nativeTarget: KotlinNativeTargetWithHostTests = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        hostOs.startsWith("Windows") -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable("frc") {
                entryPoint = "org.freem.compiler.frontend.main"
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("com.squareup.okio:okio:3.3.0")
            }
        }
        val nativeTest by getting
    }
}
