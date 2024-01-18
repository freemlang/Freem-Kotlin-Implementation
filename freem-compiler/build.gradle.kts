plugins {
    id("freem.kotlin-application-conventions")
}

dependencies {
    implementation(project(":partition-analyzer"))
}

application {
    mainClass.set("freem.compiler.frcKt")
}
