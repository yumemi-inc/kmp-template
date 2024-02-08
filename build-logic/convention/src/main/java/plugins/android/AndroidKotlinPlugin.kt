package plugins.android

import config.Config
import config.Plugins
import dsl.android
import dsl.androidTestImplementationPlatform
import dsl.configureKotlin
import dsl.implementationPlatform
import dsl.kotlinOptions
import dsl.library
import dsl.libs
import dsl.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.kotlinAndroid)

        configureKotlin {
            dependencies {
                implementationPlatform(libs.library("kotlin-bom"))
                implementationPlatform(libs.library("kotlinx-coroutinesBom"))
            }
        }

        android {
            kotlinOptions {
                // Treat all Kotlin warnings as errors (disabled by default)
                // allWarningsAsErrors = properties["warningsAsErrors"] as? Boolean ?: false

                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-progressive",
                    "-Xjavac-arguments='${Config.Java.compilerArgs.joinToString(" ")}'",
                )

                jvmTarget = Config.Java.jvmTarget
            }
        }

        dependencies {
            implementationPlatform(libs.library("kotlin-bom"))
            androidTestImplementationPlatform(libs.library("kotlin-bom"))
            implementationPlatform(libs.library("kotlinx-coroutinesBom"))
            androidTestImplementationPlatform(libs.library("kotlinx-coroutinesBom"))
        }
    }
}