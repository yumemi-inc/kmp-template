package plugins.android

import config.Config
import config.Plugins
import dsl.androidApp
import dsl.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.androidApp)

        androidApp {
            configureAndroid {
                compileOptions {
                    isCoreLibraryDesugaringEnabled = true
                }
            }

            defaultConfig {
                targetSdk = Config.Android.targetSdk
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            packaging {
                resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }

            buildTypes {
                release {
                    isMinifyEnabled = true
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    packaging {
                        resources.excludes += "DebugProbesKt.bin"
                    }
                }
            }
        }
    }
}