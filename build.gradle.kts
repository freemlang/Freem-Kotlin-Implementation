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
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val name = "native"
    val nativeTarget = when {
        hostOs == "Mac OS X"-> if (isArm64) macosArm64(name) else macosX64(name)
        hostOs == "Linux" -> if (isArm64) linuxArm64(name) else linuxX64(name)
        hostOs.startsWith("Windows") -> mingwX64(name)
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        compilations.getByName("main") {
            cinterops {
                val path = "src/nativeInterop/cinterop/llvm/def"
                for (def in File(path).walkTopDown().filter { it.toString().endsWith(".def") }) {
                    create(def.name).defFile(project.file(def))
                }
            }
        }

        binaries {
            all {
                outputDirectory = File("bin")
            }
            executable("frc") {
                entryPoint = "org.freem.cli.frc"
            }
            executable("test") {
                entryPoint = "org.freem.cli.test"
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val nativeMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio:3.5.0")
            }
        }
        val nativeTest by getting
    }
}
