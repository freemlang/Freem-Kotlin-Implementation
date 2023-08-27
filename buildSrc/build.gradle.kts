plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
}

gradlePlugin {
    plugins {
        create("llvm") {
            id = "org.llvm"
            implementationClass = "org.llvm.LLVMPlugin"

        }
    }
}