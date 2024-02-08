package config

import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion

internal object Config {
    object Java {
        const val jvmTarget = "17"
        const val jvmToolChain = 17
        val version = JavaVersion.VERSION_17
        val languageVersion = JavaLanguageVersion.of(jvmToolChain)
        val compilerArgs = listOf(
            "-Xlint:unchecked",
            "-Xlint:deprecation",
        )
    }

    object Android {
        const val minSdk = 24
        const val targetSdk = 34
        const val compileSdk = targetSdk
        const val buildToolsVersion = "34.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val compilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-Xcontext-receivers",
            "-Xskip-prerelease-check",
        )
    }
}
