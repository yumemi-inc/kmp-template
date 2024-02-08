package plugins.kotlin

import config.Config
import config.Plugins
import dsl.androidLibrary
import dsl.configureAndroid
import dsl.configureKotlin
import dsl.implementationPlatform
import dsl.kmp
import dsl.library
import dsl.libs
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.kotlinMultiplatform)
        pluginManager.apply(Plugins.androidLibrary)

        configureKotlin {
            dependencies {
                implementationPlatform(libs.library("kotlin-bom"))
                implementationPlatform(libs.library("kotlinx-coroutinesBom"))
            }
        }

        configureAndroid()

        kmp {
            applyDefaultHierarchyTemplate()
            jvmToolchain(Config.Java.jvmToolChain)

            androidTarget {
                publishAllLibraryVariants()
            }

            sourceSets {
                all {
                    languageSettings.apply {
                        optIn("kotlin.RequiresOptIn")
                        optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                    }
                }
            }
        }
    }
}