package jp.co.yumemi.local.core

import android.content.SharedPreferences
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import jp.co.yumemi.local.core.SettingsFactory

class AndroidSettingsFactory(
    private val delegate: SharedPreferences,
) : SettingsFactory {
    override fun create(): Settings = SharedPreferencesSettings(delegate)
}
