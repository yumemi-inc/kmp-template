plugins {
    androidLibrary()
    compose()
    id(libs.plugins.hilt)
    id(libs.plugins.ksp)
}


android {
    namespace = "jp.co.yumemi.core"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    mppBase()
    implementations(
        libs.kotlinx.coroutinesCore,
        libs.kotlinx.coroutinesAndroid,
        libs.kotlinx.dateTime,
        libs.androidx.navigationUi,
        libs.androidx.navigationFragment,
        libs.androidx.savedState,
        libs.androidx.constraintLayoutCompose,
        libs.androidx.activityCompose,
        libs.macaron.core,
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
    )
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
    ksp(libs.hilt.compiler)
}

