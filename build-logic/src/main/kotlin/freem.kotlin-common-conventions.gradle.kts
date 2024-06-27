import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.0")
        }
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<KotlinCompilationTask<*>>("compileKotlin").configure {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
    }
}