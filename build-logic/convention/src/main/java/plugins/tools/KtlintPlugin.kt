package plugins.tools

import config.Plugins
import dsl.ktlint
import dsl.libs
import dsl.version
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class KtlintPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Plugins.ktlint)

        ktlint {
            version.set(libs.version("ktlint"))
            verbose.set(true)
            android.set(true)
            enableExperimentalRules.set(true)
            outputToConsole.set(true)
            reporters {
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
            }

            // 自動生成されたファイルをチェックしない
            filter {
                exclude("**/generated/**")
            }
        }
    }
}
