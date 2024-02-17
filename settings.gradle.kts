pluginManagement {
    includeBuild("build-logic")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "freem"

include(
    "partition-analyzer",
    "libfsp",
    "freem-compiler",
    "utilities"
)
