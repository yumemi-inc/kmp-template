plugins {
    androidLibrary()
    id(libs.plugins.hilt)
    id(libs.plugins.ksp)
    id(libs.plugins.safeArgs)
}

android {
    namespace = "jp.co.yumemi.navigation"
}

dependencies {
    androidFeatures()
    mppBase()
    modules(
        AndroidModule.Base.Core,
    )
    implementations(
        libs.androidx.navigationUi,
        libs.androidx.navigationFragment,
        libs.hilt.android,
    )
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
    ksp(libs.hilt.compiler)
}
