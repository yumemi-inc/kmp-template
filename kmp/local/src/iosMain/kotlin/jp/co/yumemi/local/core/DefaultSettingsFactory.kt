package jp.co.yumemi.local.core

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import jp.co.yumemi.local.core.SettingsFactory
import platform.Foundation.NSUserDefaults

class IosSettingsFactory(
    private val delegate: NSUserDefaults,
) : SettingsFactory {
    override fun create(): Settings = NSUserDefaultsSettings(delegate)
}

@OptIn(ExperimentalSettingsImplementation::class)
class KeychainSettingsFactory(
    private val service: String,
) : SettingsFactory {
    override fun create(): Settings = KeychainSettings(service = service)
}
