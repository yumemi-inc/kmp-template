package plugins.tools

import config.Plugins
import dsl.androidApp
import dsl.apply
import dsl.configureAndroid
import dsl.libs
import dsl.mockmp
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class MockmpPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.ksp)
        pluginManager.apply(Plugins.mockmp)

        mockmp {
            usesHelper = true
            installWorkaround()
        }
    }
}