plugins {
    id("freem.kotlin-application-conventions")
}

dependencies {
    implementation(project(":libfsp"))
}

application {
    mainClass.set("freem.compiler.frcKt")
}
