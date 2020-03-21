plugins {
    kotlin("js").version("1.3.70")
}

repositories {
    jcenter()
}

kotlin.target.browser {
    dceTask {}
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib-js"))
}
