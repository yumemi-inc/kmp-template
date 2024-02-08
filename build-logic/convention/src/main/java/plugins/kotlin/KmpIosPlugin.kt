package plugins.kotlin

import config.Plugins
import dsl.apply
import dsl.configureKotlin
import dsl.kmp
import dsl.libs
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

class KmpIosPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.kotlinMultiplatform)

        configureKotlin()

        kmp {
            applyDefaultHierarchyTemplate()
            jvmToolchain(17)

            targets.withType<KotlinNativeTarget> {
                compilations.all {
                    kotlinOptions.freeCompilerArgs += "-Xexport-kdoc"
                }
            }

            iosArm64()
            iosX64()
            iosSimulatorArm64()

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