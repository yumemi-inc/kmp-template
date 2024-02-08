plugins {
    kmpIos()
}

kotlin {
    listOf(iosArm64(), iosSimulatorArm64()).forEach { target ->
        target.binaries.framework {
            baseName = "Shared"
            isStatic = false
            linkerOpts.add("-lsqlite3")
            embedBitcode("disable")
            KmpModule.Base.values().forEach { module -> export(project(module.path)) }
            KmpModule.Feature.values().forEach { module -> export(project(module.path)) }
            export(libs.macaron.core)
            export(libs.macaron.statemachine)
            export(libs.macaron.logging)
            export(libs.macaron.messaging)
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                KmpModule.Base.values().forEach { module -> projectApi(module) }
                KmpModule.Feature.values().forEach { module -> projectApi(module) }
                apis(
                    libs.macaron.core,
                    libs.macaron.statemachine,
                    libs.macaron.logging,
                    libs.macaron.messaging,
                )
            }
        }
    }
}