package jp.co.yumemi.local.core

import kotlinx.serialization.KSerializer

sealed class SettingKey<T>(val key: kotlin.String) {
    abstract class Serializable<K>(val name: kotlin.String, val serializer: KSerializer<K>) : SettingKey<K>(key = name)
    abstract class String(val name: kotlin.String) : SettingKey<kotlin.String>(key = name)
    abstract class Int(val name: kotlin.String) : SettingKey<kotlin.Int>(key = name)
    abstract class Long(val name: kotlin.String) : SettingKey<kotlin.Long>(key = name)
    abstract class Float(val name: kotlin.String) : SettingKey<kotlin.Float>(key = name)
    abstract class Double(val name: kotlin.String) : SettingKey<kotlin.Double>(key = name)
    abstract class Boolean(val name: kotlin.String) : SettingKey<kotlin.Boolean>(key = name)
}
