package jp.co.yumemi.local.providers

import com.russhwolf.settings.Settings
import jp.co.yumemi.data.core.ExceptionHandler
import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.local.Database
import jp.co.yumemi.local.core.LocalExceptionHandler
import jp.co.yumemi.local.core.get
import jp.co.yumemi.local.core.set
import jp.co.yumemi.local.mappers.SampleLocalMapper
import jp.co.yumemi.local.settings.SettingKeys

class SampleLocalDataProvider(
    private val database: Database,
    private val settings: Settings,
    private val exceptionHandler: LocalExceptionHandler,
) : SampleLocalDataSource {
    override suspend fun getDatabaseSample(id: String): SampleModel = runHandling(exceptionHandler) {
        database.sampleTableQueries.get(id = id).executeAsOne().let(SampleLocalMapper::toDataModel)
    }

    override suspend fun saveDatabaseSample(model: SampleModel) = runHandling(exceptionHandler) {
        database.sampleTableQueries.insert(SampleTable = model.let(SampleLocalMapper::toDbModel))
    }

    override suspend fun getSettingsSample(): SampleModel = runHandling(exceptionHandler) {
        settings[SettingKeys.Sample]
    }

    override suspend fun saveSettingsSample(model: SampleModel) = runHandling(exceptionHandler) {
        settings[SettingKeys.Sample] = model
    }
}
