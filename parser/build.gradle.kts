plugins { id("library-build-conventions") }

dependencies {
    api(project(":tyfe"))
    implementation(project(":util"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
}
