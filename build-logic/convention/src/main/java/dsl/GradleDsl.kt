package dsl

import org.gradle.api.provider.Provider
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.implementation(
    artifact: Dependency,
) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.implementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.debugImplementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("debugImplementation", artifact)
}

internal fun DependencyHandlerScope.androidTestImplementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("androidTestImplementation", artifact)
}

internal fun DependencyHandlerScope.testImplementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("testImplementation", artifact)
}

internal fun DependencyHandlerScope.implementationPlatform(
    artifact: MinimalExternalModuleDependency,
) {
    add("implementation", platform(artifact))
}

internal fun DependencyHandlerScope.androidTestImplementationPlatform(
    artifact: MinimalExternalModuleDependency,
) {
    add("androidTestImplementation", platform(artifact))
}

internal fun DependencyHandlerScope.lintChecks(
    artifact: MinimalExternalModuleDependency,
) {
    add("lintChecks", artifact)
}

internal fun DependencyHandlerScope.api(
    artifact: MinimalExternalModuleDependency,
) {
    add("api", artifact)
}

internal fun DependencyHandlerScope.ksp(
    artifact: MinimalExternalModuleDependency,
) {
    add("ksp", artifact)
}

internal fun DependencyHandlerScope.kspTest(
    artifact: MinimalExternalModuleDependency,
) {
    add("kspTest", artifact)
}

