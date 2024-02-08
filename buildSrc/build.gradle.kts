import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    // ref: https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.android)
    implementation(libs.gradle.safeArgs)
    implementation(libs.gradle.hilt)
    implementation(libs.gradle.kover)
    implementation(libs.gradle.ktlint)
    implementation(libs.gradle.serialization)
    implementation(libs.gradle.sqldelight)
    implementation(libs.gradle.dokka)
    implementation(libs.gradle.mockmp)
    implementation(libs.gradle.realm)
    implementation(libs.gradle.ksp)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}