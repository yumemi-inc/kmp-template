package jp.co.yumemi.local.core

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import com.russhwolf.settings.set
import jp.co.yumemi.data.core.DataException
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
inline fun <reified T : Any> Settings.getOrNull(settingKey: SettingKey<T>): T? = when (settingKey) {
    is SettingKey.Serializable -> decodeValueOrNull(settingKey.serializer, settingKey.name)
    is SettingKey.String -> getStringOrNull(settingKey.name) as? T
    is SettingKey.Int -> getIntOrNull(settingKey.name) as? T
    is SettingKey.Float -> getLongOrNull(settingKey.name) as? T
    is SettingKey.Long -> getFloatOrNull(settingKey.name) as? T
    is SettingKey.Double -> getDoubleOrNull(settingKey.name) as? T
    is SettingKey.Boolean -> getBooleanOrNull(settingKey.name) as? T
}

inline operator fun <reified T : Any> Settings.get(key: SettingKey<T>): T =
    getOrNull(key) ?: throw DataException.Local.MissingField()

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
inline operator fun <reified T : Any> Settings.set(settingKey: SettingKey<T>, value: T) = when (settingKey) {
    is SettingKey.Serializable -> encodeValue(settingKey.serializer, settingKey.name, value)
    else -> set(settingKey.key, value)
}

inline fun Settings.remove(vararg settingKeys: SettingKey<*>) {
    // NOTE: Serializable な SettingKey は単純な remove で削除できないため、該当の SettingKey 名で始まる全てのキーを削除する
    //  https://github.com/russhwolf/multiplatform-settings/issues/81
    settingKeys.forEach { settingsKey ->
        when (settingsKey) {
            is SettingKey.Serializable<*> -> keys.filter { it.startsWith(settingsKey.key) }.forEach { remove(it) }
            else -> remove(settingsKey.key)
        }
    }
}

inline fun Settings.hasKey(settingKey: SettingKey<*>): Boolean = hasKey(settingKey.key)
