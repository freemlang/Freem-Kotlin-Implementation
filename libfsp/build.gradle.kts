plugins {
    id("freem.kotlin-library-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}
