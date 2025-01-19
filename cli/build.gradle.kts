plugins { id("application-build-conventions") }

dependencies {
    implementation(project(":parser"))
    implementation(project(":compiler"))
}

application { mainClass = "mainKt" }
