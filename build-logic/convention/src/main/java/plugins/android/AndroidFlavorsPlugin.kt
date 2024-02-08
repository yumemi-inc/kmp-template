package plugins.android

import com.android.build.api.variant.VariantBuilder
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import config.Config
import dsl.androidBase
import dsl.androidComponents
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

@Suppress("unused")
class AndroidFlavorsPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val isApp = extensions.findByType<BaseAppModuleExtension>() != null
        androidBase {
            productFlavors {
                flavorDimensionList.clear()
                flavorDimensionList.addAll(Dimensions.values().map { it.label })
                Flavors.values().forEach { flavor ->
                    productFlavors.create(flavor.label) {
                        dimension = flavor.dimension.label
                        if (isApp) {
                            applicationId = flavor.applicationId
                            minSdk = Config.Android.minSdk
                            targetSdk = Config.Android.targetSdk
                        }
                        if (flavor.suffix != null) {
                            resValue("string", "app_name", "KmpSample${flavor.suffix}")
                        }
                    }
                }
            }
        }

//        androidComponents {
//            beforeVariants { variantBuilder ->
//                variantBuilder.enable(
//                    // VariantFilterSetting(name = "debug", Flavors.Production), // 本番環境でもデバッグビルド有効にするためコメントアウト
//                    VariantFilterSetting(name = "release", Flavors.Mock, Flavors.Develop),
//                )
//            }
//        }
    }
}

private enum class Flavors(
    val label: String,
    val dimension: Dimensions,
    open val suffix: String? = null,
    open val applicationId: String? = null,
) {
    Develop("develop", Dimensions.BuildEnv) {
        override val suffix: String = ".$label"
        override val applicationId: String = "${Flavors.DEFAULT_APPLICATION_ID}$suffix"
    },
    Mock("mock", Dimensions.BuildEnv) {
        override val suffix: String = ".$label"
        override val applicationId: String = "${Flavors.DEFAULT_APPLICATION_ID}$suffix"
    },
    Staging("staging", Dimensions.BuildEnv) {
        override val suffix: String = ".$label"
        override val applicationId: String = "${Flavors.DEFAULT_APPLICATION_ID}$suffix"
    },
    Production("product", Dimensions.BuildEnv) {
        override val applicationId: String = Flavors.PRODUCTION_APPLICATION_ID
    },
    ;

    val index get() = Dimensions.values().indexOf(dimension)

    companion object {
        private const val DEFAULT_APPLICATION_ID = "jp.co.yumemi.sample"
        private const val PRODUCTION_APPLICATION_ID = "jp.co.yumemi.sample"

        fun fromLabel(label: String): Flavors? = values().find { it.label == label }
    }
}

private enum class Dimensions(
    val label: String
) {
    BuildEnv("BUILD_ENV"),
}

private class VariantFilterSetting(val name: String, vararg val flavors: Flavors)

private fun VariantBuilder.enable(vararg settings: VariantFilterSetting) {
    enable = settings.none { filter ->
        buildType == filter.name && filter.flavors.any {
            this.flavorName?.let { filter.flavors.contains(Flavors.fromLabel(it)) } ?: false
        }
    }
}