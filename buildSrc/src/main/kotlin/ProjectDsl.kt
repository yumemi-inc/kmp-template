import java.io.File
import java.io.FileInputStream
import java.util.Properties
import org.gradle.api.Project

fun Project.getProperty(key: String, default: String? = null): String = System.getenv(key)
    ?: System.getProperty(key)
    ?: localProperties.getProperty(key)
    ?: default
    ?: error("Missing [$key] property in local.properties or environment variables")

val Project.localProperties: Properties
    get() = Properties().apply {
        load(FileInputStream(File(rootProject.rootDir, "local.properties")))
    }