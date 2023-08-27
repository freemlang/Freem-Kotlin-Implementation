import java.io.*

plugins {
    kotlin("multiplatform") version "1.9.10"
    id("org.llvm")
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

    nativeTarget.binaries {
        all { outputDirectory = File("bin") }
        executable("frc") { entryPoint = "org.freem.cli.frc" }
        executable("test") { entryPoint = "org.freem.cli.test" }
    }
    nativeTarget.llvm {

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

//task("importPyTask") {
//    val pytaskDir = "pytask"
//    val pytaskFiles = File(pytaskDir).listFiles { file ->
//        file.name.startsWith('_').not() && file.extension == "py"
//    }?: emptyArray()
//    for (taskFile in pytaskFiles) {
//        if (taskFile.name.startsWith('_').not()) {
//            tasks.create(taskFile.nameWithoutExtension) {
//                enabled = false
//                val process = ProcessBuilder()
//                    .redirectErrorStream(true)
//                    .command("py", taskFile.path)
//                    .start()
//
//                val reader = BufferedReader(InputStreamReader(process.inputStream))
//                var line: String?
//                while (reader.readLine().also { line = it } != null) println(line)
//
//                process.waitFor()
//
//            }
//        }
//    }
//}