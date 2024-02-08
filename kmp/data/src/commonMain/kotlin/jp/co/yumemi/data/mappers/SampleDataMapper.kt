package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.domain.entities.SampleEntity

internal object SampleDataMapper {
    fun toEntity(model: SampleModel) = SampleEntity(
        id = model.id,
        value = model.value
    )
}
