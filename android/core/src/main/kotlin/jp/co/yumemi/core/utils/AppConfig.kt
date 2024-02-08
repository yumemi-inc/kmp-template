package jp.co.yumemi.core.utils

data class AppConfig(
    val debug: Boolean,
    val applicationId: String,
    val buildType: String,
    val flavor: String,
    val versionCode: Int,
    val versionName: String,
)
