package dsl

import app.cash.sqldelight.gradle.SqlDelightExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import java.io.File
import java.io.FileInputStream
import java.util.Properties
import kotlinx.kover.api.KoverTaskExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.kodein.mock.gradle.MocKMPGradlePlugin

internal fun Project.java(action: JavaPluginExtension.() -> Unit) = extensions.configure(action)

internal fun Project.kotlin(action: KotlinProjectExtension.() -> Unit) = extensions.configure(action)

internal fun Project.kmp(block: KotlinMultiplatformExtension.() -> Unit) = extensions.configure(block)

internal fun Project.android(block: TestedExtension.() -> Unit) = extensions.configure(block)

internal fun Project.androidCommon(block: CommonExtension<*, *, *, *, *>.() -> Unit) = extensions.configure(block)

internal fun Project.androidLibrary(block: LibraryExtension.() -> Unit) = extensions.configure(block)

internal fun Project.androidApp(block: BaseAppModuleExtension.() -> Unit) = extensions.configure(block)

internal fun Project.androidBase(block: BaseExtension.() -> Unit) = extensions.configure(block)

internal fun Project.androidComponents(block: AndroidComponentsExtension<*, *, *>.() -> Unit) = extensions.configure(block)

internal fun Project.ktlint(block: KtlintExtension.() -> Unit) = extensions.configure(block)

internal fun Project.kover(block: KoverTaskExtension.() -> Unit) = extensions.configure(block)

internal fun Project.sqlDelight(block: SqlDelightExtension.() -> Unit) = extensions.configure(block)

internal fun Project.mockmp(block: MocKMPGradlePlugin.Extension.() -> Unit) = extensions.configure(block)

internal fun KotlinMultiplatformExtension.sourceSets(block: NamedDomainObjectContainer<KotlinSourceSet>.() -> Unit) = sourceSets.block()

internal fun TestedExtension.kotlinOptions(action: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", action)
}
