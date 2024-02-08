package jp.co.yumemi.local.core

import com.russhwolf.settings.Settings

fun interface SettingsFactory {
    fun create(): Settings
}
