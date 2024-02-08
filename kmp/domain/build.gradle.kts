plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.parcelize)
    id(libs.plugins.serialization)
}

android {
    namespace = "kmp.domain"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                modules(KmpModule.Base.Utils)
                implementations(
                    libs.kotlinx.coroutinesCore,
                    libs.kotlinx.dateTime,
                )
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
