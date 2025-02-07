plugins { id("library-build-conventions") }

dependencies {
    implementation(project(":parser"))
    implementation("org.bytedeco:llvm:19.1.3-1.5.11")
    implementation("dev.forkhandles:parser4k:2.20.0.0")
}
