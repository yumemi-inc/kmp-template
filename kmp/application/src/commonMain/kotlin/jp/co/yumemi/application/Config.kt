package jp.co.yumemi.application

data class Config(
    val platform: Platform,
    val buildType: BuildType,
    val isLoggingEnabled: Boolean = false,
)
