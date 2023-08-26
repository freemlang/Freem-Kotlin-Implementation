plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:20230618")
}

gradlePlugin {
    plugins {
        create("LLVM") {
            id = "LLVM"
            implementationClass = "LLVM.LLVMTask"
        }
    }
}