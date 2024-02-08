package dsl

import config.Config
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlin(block: KotlinProjectExtension.() -> Unit = {}) {
    kotlin {
        jvmToolchain {
            languageVersion.set(Config.Java.languageVersion)
        }
    }

    gradle.projectsEvaluated {
        tasks.withType<JavaCompile> {
            options.compilerArgs = options.compilerArgs + Config.Java.compilerArgs
        }

        tasks.withType<KotlinCompile>().all {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-progressive",
                    "-Xjavac-arguments='${Config.Java.compilerArgs.joinToString(" ")}'",
                )
                jvmTarget = Config.Java.jvmTarget
            }
        }
    }
}
