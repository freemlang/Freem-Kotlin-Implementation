plugins {
    id("freem.kotlin-application-conventions")
}

dependencies {
    implementation(project(":libfsp"))
    implementation("org.bytedeco:llvm:17.0.6-1.5.10")
}

application {
    mainClass = "freem.compiler.frcKt"
}
