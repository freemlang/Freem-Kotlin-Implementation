import org.gradle.internal.impldep.org.apache.commons.compress.compressors.xz.XZCompressorInputStream
import org.jetbrains.kotlin.com.google.gson.JsonParser
import org.jetbrains.kotlin.konan.file.use
import java.io.*
import java.net.HttpURLConnection
import java.net.URI
import java.util.*

plugins {
    kotlin("multiplatform") version "1.9.10"
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

task("reloadLLVMProject") {
    val propertiesPath = "llvm.properties"
    val llvmProperties = Properties().apply { FileInputStream(File(propertiesPath)).use(::load) }

    val githubRepositoryOwner = "llvm"
    val githubRepositoryName = "llvm-project"
    val githubReleaseVersion = llvmProperties.getProperty("version")
    val githubReleaseTag = "llvmorg-$githubReleaseVersion"
    val githubGetReleaseByTagURL = "https://api.github.com/repos/$githubRepositoryOwner/$githubRepositoryName/releases/tags/$githubReleaseTag"

    fun GETRequestURL(url: String): String {

        val connection = URI(url).toURL().openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        with (connection.responseCode) {
            require(this == HttpURLConnection.HTTP_OK) {
                "API Request Failed with response code: $this"
            }
        }

        val response = InputStreamReader(connection.inputStream).use(InputStreamReader::readText)

        connection.disconnect()

        return response
    }

    val llvmAsset = JsonParser
        .parseString(
            GETRequestURL(
                githubGetReleaseByTagURL
            )
        )
        .asJsonObject
        .also {
            require(
                it.has("message").not()
            ) {
                "Invalid version $githubReleaseVersion"
            }
        }
        .getAsJsonArray("assets")
        .find {
            it
                .asJsonObject
                .getAsJsonPrimitive("name")
                .asString
                .run {
                    startsWith("llvm-") && endsWith(".src.tar.xz")
                }
        }!!
        .asJsonObject
    val llvmDownloadURL = llvmAsset.getAsJsonPrimitive("browser_download_url").asString
    val llvmFileName = llvmAsset.getAsJsonPrimitive("name").asString

    println(llvmDownloadURL)

    val outputDir = "src/nativeInterop/cinterop/llvm"

    val connection = URI(llvmDownloadURL).toURL().openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    with (connection.responseCode) {
        require(this == HttpURLConnection.HTTP_OK) {
            "API Request Failed with response code: $this"
        }
    }
    val inputStream = BufferedInputStream(connection.inputStream)
    val outputFile = File(outputDir, llvmFileName)

    val outputStream = FileOutputStream(outputFile)
    val buffer = ByteArray(1024)
    var bytesRead: Int

    while (inputStream.read(buffer).also { bytesRead = it } != -1) outputStream.write(buffer, 0, bytesRead)

    outputStream.close()
    inputStream.close()
    connection.disconnect()

    XZCompressorInputStream()

}

task("reloadLLVMInterop") {

}