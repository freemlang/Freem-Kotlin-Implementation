plugins {
    kotlin("jvm") version "2.1.10"
    id("com.diffplug.spotless") version "7.0.2"
}

spotless { kotlin { ktfmt("0.54").kotlinlangStyle() } }
