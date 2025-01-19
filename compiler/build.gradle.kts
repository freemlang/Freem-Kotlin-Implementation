plugins { id("library-build-conventions") }

dependencies {
    implementation(project(":parser"))
    implementation("org.bytedeco:llvm:19.1.3-1.5.11")
}
