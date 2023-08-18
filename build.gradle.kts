plugins {
    kotlin("multiplatform") version "1.9.0"
}

group = "org.freem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        hostOs.startsWith("Windows") -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        compilations.getByName("main") {
            cinterops {
                val cinteropPath = "src/nativeInterop/cinterop"
                val llvm by creating {
                    val llvmPath = "$cinteropPath/llvm-16.0.6.src"
                    defFile(project.file("$cinteropPath/llvm.def"))
                    packageName("llvm")
                    compilerOpts("-I$llvmPath/include")
                    linkerOpts("-L$llvmPath/lib")
                    includeDirs.allHeaders("$llvmPath/include")
                }
            }
        }

        binaries {
            all { outputDirectory = File("bin") }
            fun createExecutable(vararg name: String) { for (n in name) executable(n) { entryPoint("org.freem.cli.$n") } }
            createExecutable(
                "frc",
                "fpm",
                "test"
            )
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0-RC")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-okio:1.6.0-RC")
                implementation("com.squareup.okio:okio:3.5.0")
            }
        }
        val nativeTest by getting
    }
}
