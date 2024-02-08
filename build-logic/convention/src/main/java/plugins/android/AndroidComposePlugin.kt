package plugins.android

import dsl.androidBase
import dsl.androidTestImplementationPlatform
import dsl.implementationPlatform
import dsl.library
import dsl.libs
import dsl.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        androidBase {
            buildFeatures.compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = libs.version("composeCompiler")
            }
        }

        dependencies {
            implementationPlatform(libs.library("compose-bom"))
            androidTestImplementationPlatform(libs.library("compose-bom"))
        }
    }
}