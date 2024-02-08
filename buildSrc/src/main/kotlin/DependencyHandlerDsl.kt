import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun DependencyHandler.implementations(vararg dependencies: Provider<MinimalExternalModuleDependency>) {
    dependencies.forEach { add("implementation", it) }
}

fun DependencyHandler.project(module: Module): Dependency? = add("implementation", project(module.path))

fun DependencyHandler.projectApi(module: Module): Dependency? = add("api", project(module.path))

fun DependencyHandler.projectTest(module: Module): Dependency? = add("testImplementation", project(module.path))

fun DependencyHandler.modules(vararg module: Module) = module.forEach(::project)

fun DependencyHandler.mppBase() = modules(*KmpModule.Base.values())

fun DependencyHandler.mppFeatures() = modules(*KmpModule.Feature.values())

fun DependencyHandler.androidFeatures() = modules(*AndroidModule.Feature.values())

fun KotlinDependencyHandler.implementations(vararg dependencies: Provider<MinimalExternalModuleDependency>) = dependencies.forEach(::implementation)

fun KotlinDependencyHandler.apis(vararg dependencies: Provider<MinimalExternalModuleDependency>) = dependencies.forEach(::api)

fun KotlinDependencyHandler.project(module: Module): Dependency? = implementation(project(module.path))

fun KotlinDependencyHandler.projectApi(module: Module): Dependency? = api(project(module.path))

fun KotlinDependencyHandler.modules(vararg module: KmpModule) = module.forEach(this::project)