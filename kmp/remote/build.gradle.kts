plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.serialization)
}

android {
    namespace = "kmp.remote"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            modules(
                KmpModule.Base.Application,
                KmpModule.Base.Data,
                KmpModule.Base.Utils,
            )
            implementations(
                libs.kotlinx.serializationJson,
                libs.kotlinx.dateTime,
                libs.ktor.contentNegotiation,
                libs.ktor.serialization,
                libs.ktor.logging,
                libs.ktor.client.core,
                libs.log.kermit,
            )
        }
        androidMain.dependencies {
            implementations(
                libs.ktor.client.android,
            )
        }
        iosMain.dependencies {
            implementations(
                libs.ktor.client.ios,
            )
        }
        commonTest {
            dependencies {
                implementations(
                    libs.test.kotlin,
                    libs.test.coroutinesTest,
                    libs.test.turbine,
                    libs.test.kotest,
                    libs.ktor.client.mock
                )
            }
        }
    }
}
