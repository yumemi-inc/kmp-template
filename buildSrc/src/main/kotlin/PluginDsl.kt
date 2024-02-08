import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.plugin.use.PluginDependency

fun PluginDependenciesSpecScope.id(dependency: Provider<PluginDependency>) {
    id(dependency.get().pluginId)
}

fun PluginDependenciesSpecScope.kmpAndroid() {
    id("build.kmp.android")
    id("build.mockmp")
}

fun PluginDependenciesSpecScope.kmpIos() {
    id("build.kmp.ios")
}

fun PluginDependenciesSpecScope.androidApp() {
    id("build.android.app")
    id("build.android.kotlin")
}

fun PluginDependenciesSpecScope.androidLibrary() {
    id("build.android.library")
    id("build.android.kotlin")
}

fun PluginDependenciesSpecScope.androidFlavors() {
    id("build.android.flavors")
}

fun PluginDependenciesSpecScope.compose() {
    id("build.android.compose")
}