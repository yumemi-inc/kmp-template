plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.parcelize)
}

android {
    namespace = "kmp.utils"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                modules(KmpModule.Base.Application)
                implementation(libs.kotlinx.coroutinesCore)
                implementation(libs.kotlinx.dateTime)
                implementation(libs.ktor.client.core)
            }
        }
        commonTest {
            dependencies {
                implementations(
                    libs.test.kotlin,
                    libs.test.coroutinesTest,
                    libs.test.turbine,
                    libs.test.kotest,
                )
            }
        }
    }
}
