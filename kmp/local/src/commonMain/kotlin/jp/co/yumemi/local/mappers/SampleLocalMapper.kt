package jp.co.yumemi.local.mappers

import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.local.SampleTable

internal object SampleLocalMapper {
    fun toDbModel(dataModel: SampleModel) = SampleTable(
        id = dataModel.id,
        value_ = dataModel.value
    )

    fun toDataModel(dbModel: SampleTable) = SampleModel(
        id = dbModel.id,
        value = dbModel.value_
    )
}
