import java.io.FileInputStream
import java.util.Properties

rootProject.name = "yumemi-kmp-template"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.github.com/yumemi-inc/accompanist") {
            authentication {
                create<BasicAuthentication>(name = "basic")
            }
            credentials {
                username = getProperty(key = "GITHUB_MPP_USERNAME")
                password = getProperty(key = "GITHUB_MPP_TOKEN")
            }
        }
    }
}

// Android
include(":android:app")
include(":android:core")
include(":android:navigation")
include(":android:features:sample")
// KMP
include(":kmp:application")
include(":kmp:domain")
include(":kmp:data")
include(":kmp:remote")
include(":kmp:local")
include(":kmp:utils")
include(":kmp:ios")
include(":kmp:presentation:sample-shared")

fun getProperty(key: String, default: String? = null): String = System.getProperty(key)
    ?: System.getenv(key)
    ?: localProperties.getProperty(key)
    ?: default
    ?: error("Missing [$key] property in local.properties or environment variables")

val localProperties: Properties
    get() = Properties().apply {
        load(FileInputStream(File(rootProject.projectDir, "local.properties")))
    }