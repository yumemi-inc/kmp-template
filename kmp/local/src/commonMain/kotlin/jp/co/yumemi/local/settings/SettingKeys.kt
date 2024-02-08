package jp.co.yumemi.local.settings

import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.local.core.SettingKey

object SettingKeys {
    object Sample : SettingKey.Serializable<SampleModel>(name = "Sample", serializer = SampleModel.serializer())
}
