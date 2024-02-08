plugins {
    androidApp()
    androidFlavors()
    compose()
    id(libs.plugins.kotlinKapt)
    id(libs.plugins.hilt)
    id(libs.plugins.parcelize)
    id(libs.plugins.safeArgs)
    id(libs.plugins.serialization)
}

android {
    namespace = "jp.co.yumemi.app"

    defaultConfig {
        versionCode = 1
        versionName = getProperty("VERSION", Config.version)
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    mppBase()
    mppFeatures()
    modules(
        AndroidModule.Base.Core,
        AndroidModule.Base.Navigation,
        AndroidModule.Feature.Sample,
    )
    implementations(
        libs.androidx.core,
        libs.androidx.coreSplash,
        libs.androidx.appCompat,
        libs.androidx.navigationUi,
        libs.androidx.navigationFragment,
        libs.macaron.core,
        libs.macaron.statemachine,
        libs.macaron.logging,
        libs.macaron.messaging,
        libs.hilt.android,
        libs.log.timber,
        libs.kotlinx.coroutinesCore,
        libs.kotlinx.coroutinesAndroid,
        libs.androidx.navigationUi,
        libs.androidx.navigationFragment,
        libs.androidx.savedState,
        platform(libs.compose.bom),
        libs.compose.runtime,
        libs.compose.material,
        libs.compose.material3,
        libs.compose.ui,
        libs.compose.uiGraphics,
        libs.compose.uiTooling,
        libs.compose.uiToolingPreview,
        libs.compose.foundation,
        libs.compose.foundationLayout,
        libs.coil.core,
        libs.coil.compose,
        libs.hilt.android,
        libs.log.timber,
        libs.settings.core,
        libs.sqldelight.runtime,
    )
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
    kapt(libs.hilt.compiler)
    debugImplementation(libs.leak.leakCanary)
}
