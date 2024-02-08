package plugins.android

import config.Plugins
import dsl.androidLibrary
import dsl.apply
import dsl.configureAndroid
import dsl.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.androidLibrary)

        androidLibrary {
            configureAndroid {
                compileOptions {
                    isCoreLibraryDesugaringEnabled = true
                }
            }

            defaultConfig {
                consumerProguardFiles("consumer-rules.pro")
            }
        }
    }
}