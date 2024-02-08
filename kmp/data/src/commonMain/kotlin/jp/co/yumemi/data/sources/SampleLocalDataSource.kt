package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.SampleModel

interface SampleLocalDataSource {
    suspend fun getDatabaseSample(id: String): SampleModel
    suspend fun saveDatabaseSample(model: SampleModel)
    suspend fun getSettingsSample(): SampleModel
    suspend fun saveSettingsSample(model: SampleModel)
}