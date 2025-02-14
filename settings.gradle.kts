rootProject.name = "freem"

include(
    "cli",
    "compiler",
    "parser",
    "tyfe",
    "util",
)

pluginManagement { includeBuild("build-logic") }

plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0" }
