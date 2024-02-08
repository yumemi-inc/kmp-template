package dsl

import com.android.build.gradle.TestedExtension
import config.Config
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureAndroid(block: TestedExtension.() -> Unit = {}) {
    android {
        namespace?.let {
            this.namespace = it
        }
        compileSdkVersion(Config.Android.compileSdk)
        buildToolsVersion = Config.Android.buildToolsVersion

        compileOptions {
            sourceCompatibility = Config.Java.version
            targetCompatibility = Config.Java.version
        }

        defaultConfig {
            minSdk = Config.Android.minSdk
            targetSdk = Config.Android.targetSdk
        }

        block()
    }

    tasks.withType(KotlinCompile::class.java) {
        kotlinOptions {
            jvmTarget = Config.Java.jvmTarget
            freeCompilerArgs += Config.Android.compilerArgs
        }
    }
}
