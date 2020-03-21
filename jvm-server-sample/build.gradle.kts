plugins {
    kotlin("jvm").version("1.3.70")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.undertow:undertow-core:2.0.30.Final")
}
