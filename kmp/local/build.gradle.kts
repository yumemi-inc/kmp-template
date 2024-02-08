plugins {
    kmpAndroid()
    kmpIos()
    id(libs.plugins.sqldelight)
    id(libs.plugins.serialization)
    id(libs.plugins.realm)
}

android {
    namespace = "kmp.local"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            modules(
                KmpModule.Base.Application,
                KmpModule.Base.Data,
                KmpModule.Base.Utils
            )
            implementations(
                libs.kotlinx.serializationJson,
                libs.kotlinx.coroutinesCore,
                libs.kotlinx.dateTime,
                libs.sqldelight.coroutineExtensions,
                libs.sqldelight.primitiveAdapters,
                libs.settings.core,
                libs.settings.serialization,
                libs.sqldelight.runtime,
                libs.settings.core,
            )
        }
        androidMain.dependencies {
            implementations(
                libs.sqldelight.androidDriver,
            )
        }
        iosMain.dependencies {
            implementations(
                libs.sqldelight.nativeDriver,
            )
        }
        commonTest.dependencies {
            implementations(
                libs.test.kotlin,
                libs.test.coroutinesTest,
                libs.test.turbine,
                libs.test.kotest,
                libs.settings.test,
            )
        }
        androidUnitTest.dependencies {
            implementation(libs.sqldelight.sqliteDriver)
        }
    }
}

sqldelight {
    database("Database") {
        packageName = "jp.co.yumemi.local"
        dialect("app.cash.sqldelight:sqlite-3-30-dialect:2.0.0-alpha04")
    }
}
