plugins {
    androidLibrary()
    compose()
    id(libs.plugins.kotlinKapt)
    id(libs.plugins.hilt)
    id(libs.plugins.safeArgs)
}

android {
    namespace = "jp.co.yumemi.features.common"
}

dependencies {
    mppBase()
    modules(
        AndroidModule.Base.Core,
        KmpModule.Feature.Sample,
    )
    implementations(
        libs.kotlinx.coroutinesCore,
        libs.kotlinx.coroutinesAndroid,
        libs.androidx.navigationUi,
        libs.androidx.navigationFragment,
        libs.androidx.savedState,
        libs.macaron.core,
        libs.macaron.statemachine,
        libs.macaron.logging,
        libs.macaron.messaging,
        libs.compose.runtime,
        libs.compose.material,
        libs.compose.material3,
        libs.compose.ui,
        libs.compose.uiGraphics,
        libs.compose.uiTooling,
        libs.compose.uiToolingPreview,
        libs.compose.material,
        libs.compose.foundation,
        libs.compose.foundationLayout,
        libs.hilt.android,
        libs.coil.core,
        libs.coil.compose,
        libs.log.timber,
        libs.androidx.activityCompose,
    )
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
    kapt(libs.hilt.compiler)
}
