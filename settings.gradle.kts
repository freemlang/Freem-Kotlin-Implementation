rootProject.name = "freem"

include(
    "cli",
    "compiler",
    "parser",
)

pluginManagement {
    includeBuild("build-logic")
    plugins { kotlin("jvm") version "2.1.0" }
}

plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0" }
