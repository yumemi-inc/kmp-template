plugins {
    `kotlin-dsl`
}

group = "jp.co.yumemi"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs += "-Xcontext-receivers"
            jvmTarget = "17"
        }
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "build.android.app"
            implementationClass = "plugins.android.AndroidApplicationPlugin"
        }
        register("androidCompose") {
            id = "build.android.compose"
            implementationClass = "plugins.android.AndroidComposePlugin"
        }
        register("androidFlavors") {
            id = "build.android.flavors"
            implementationClass = "plugins.android.AndroidFlavorsPlugin"
        }
        register("androidKotlin") {
            id = "build.android.kotlin"
            implementationClass = "plugins.android.AndroidKotlinPlugin"
        }
        register("androidLibrary") {
            id = "build.android.library"
            implementationClass = "plugins.android.AndroidLibraryPlugin"
        }
        register("kmpAndroid") {
            id = "build.kmp.android"
            implementationClass = "plugins.kotlin.KmpAndroidPlugin"
        }
        register("kmpIos") {
            id = "build.kmp.ios"
            implementationClass = "plugins.kotlin.KmpIosPlugin"
        }
        register("ktlint") {
            id = "build.ktlint"
            implementationClass = "plugins.tools.KtlintPlugin"
        }
        register("mockmp") {
            id = "build.mockmp"
            implementationClass = "plugins.tools.MockmpPlugin"
        }
    }
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    compileOnly(gradleApi())
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
