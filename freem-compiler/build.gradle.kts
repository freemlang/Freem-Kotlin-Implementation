plugins {
    id("freem.kotlin-application-conventions")
}

dependencies {
    implementation(project(":partition"))
}

application {
    mainClass.set("freem.frcKt")
}
