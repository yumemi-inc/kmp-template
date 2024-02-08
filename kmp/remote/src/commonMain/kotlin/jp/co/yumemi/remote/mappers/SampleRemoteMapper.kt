package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.remote.models.SampleApiModel

internal object SampleRemoteMapper {
    fun toDataModel(apiModel: SampleApiModel) = SampleModel(
        id = apiModel.id,
        value = apiModel.value
    )
}
