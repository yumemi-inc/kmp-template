plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.parcelize)
    id(libs.plugins.serialization)
}

android {
    namespace = "kmp.data"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                modules(
                    KmpModule.Base.Domain,
                    KmpModule.Base.Application,
                    KmpModule.Base.Utils,
                )
                implementations(
                    libs.kotlinx.dateTime,
                    libs.kotlinx.coroutinesCore,
                    libs.kotlinx.serializationJson,
                    libs.ktor.client.core,
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
